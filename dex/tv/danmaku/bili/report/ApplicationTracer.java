package tv.danmaku.bili.report;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.util.AtomicFile;
import com.bilibili.base.BiliContext;
import com.bilibili.commons.io.FileUtils;
import com.bilibili.commons.io.IOUtils;
import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.gripper.GripperExecute;
import com.bilibili.gripper.GripperExecuteKt;
import com.bilibili.gripper.api.infoeyes.GInfoeyes;
import com.bilibili.lib.biliid.api.BiliIds;
import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.biliid.utils.device.HwIdHelper;
import com.bilibili.lib.biliid.utils.device.PhoneIdHelper;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.crashreport.CrashReporter;
import com.bilibili.lib.drmid.DrmIdHelper;
import com.bilibili.lib.infoeyes.InfoEyesManager;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.oaid.MsaHelper;
import com.tencent.bugly.crashreport.BuglyLog;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.BuildConfig;
import tv.danmaku.bili.report.ApplicationTracer;
import tv.danmaku.bili.report.platform.infoeyes.TaskIdConst;
import tv.danmaku.bili.report.platform.neuron.NeuronEventId;

public class ApplicationTracer {
    private static String ANDROID_ID = null;
    private static final boolean DEBUG = BuildConfig.DEBUG;
    private static String IMEI = null;
    private static final int NON_UI_COLD_STARTUP = 2;
    public static final int SESSION_EXPIRE_THRESHOLD = 10000;
    public static final String TAG = "APP-TRACER";
    private static final int UI_COLD_STARTUP = 1;
    private static String WIFI_MAC;
    private static volatile ApplicationTracer mSingleton;
    private static boolean sHasInit;
    private SessionManager mSessionManager;

    public static ApplicationTracer initialize(Context context) {
        if (mSingleton == null) {
            synchronized (ApplicationTracer.class) {
                if (mSingleton == null) {
                    mSingleton = new ApplicationTracer(context);
                }
            }
        }
        return mSingleton;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void initIds(Context context) {
        ANDROID_ID = PhoneIdHelper.getAndroidId(context);
        IMEI = PhoneIdHelper.getImei(context);
        WIFI_MAC = HwIdHelper.getWifiMacAddr(context);
    }

    private ApplicationTracer(Context context) {
        this.mSessionManager = new SessionManager(context);
    }

    public void onPause(Activity activity) {
        if (!tv.danmaku.bili.OnlineParamsHelper.enableAppActiveReport()) {
            return;
        }
        this.mSessionManager.updateSession(false);
    }

    public void onResume(Activity activity) {
        if (!tv.danmaku.bili.OnlineParamsHelper.enableAppActiveReport()) {
            return;
        }
        this.mSessionManager.updateSession(true);
    }

    public int getColdStart() {
        return this.mSessionManager.sColdStart ? 1 : 2;
    }

    public String getSessionId() {
        if (this.mSessionManager.mCurrentSession != null) {
            return this.mSessionManager.mCurrentSession.id;
        }
        return null;
    }

    public void setIsColdStart(boolean isColdStart) {
        this.mSessionManager.sColdStart = isColdStart;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class Session {
        static final byte[] MAGIC = "sess!on".getBytes();
        static final int VER = 2;
        public String id;
        public int isColdStartup;
        public long realEnd;
        public long realStart;
        public long start;

        Session() {
        }

        void start(boolean coldStartup) {
            this.id = UUID.randomUUID().toString();
            this.start = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.realStart = elapsedRealtime;
            this.realEnd = elapsedRealtime;
            if (ApplicationTracer.DEBUG) {
                BLog.i(ApplicationTracer.TAG, "Start new session " + this.id + ", start=" + this.start + "coldStartup=" + coldStartup);
            }
            this.isColdStartup = coldStartup ? 1 : 2;
        }

        void mark() {
            checkStart();
            this.realEnd = SystemClock.elapsedRealtime();
            if (ApplicationTracer.DEBUG) {
                BLog.d(ApplicationTracer.TAG, "Session's clock tick  " + this.id + ", d=" + (this.realEnd - this.realStart));
            }
        }

        private void checkStart() {
            if (!isValid()) {
                throw new IllegalStateException("start session first");
            }
        }

        public String toString() {
            return '\'' + this.id + "': {start=" + this.start + ", real=(" + this.realStart + ", " + this.realEnd + ", dtime=" + (this.realEnd - this.realStart) + ")}";
        }

        public boolean isExpired() {
            if (isValid()) {
                long currentRealTime = SystemClock.elapsedRealtime();
                return currentRealTime < this.realStart || currentRealTime - this.realEnd >= 10000;
            }
            return true;
        }

        public long getDuration() {
            return this.realEnd - this.realStart;
        }

        public boolean isValid() {
            return this.id != null && this.id.length() > 0 && this.realEnd > 0 && this.realEnd >= this.realStart && this.start > 0;
        }

        boolean writeTo(OutputStream out) {
            try {
                out.write(MAGIC);
                SimpleSerialization.writeInt(out, 2);
                if (this.id == null) {
                    out.write(-1);
                } else {
                    out.write(0);
                    SimpleSerialization.writeString(out, this.id);
                    SimpleSerialization.writeLong(out, this.start);
                    SimpleSerialization.writeLong(out, this.realStart);
                    SimpleSerialization.writeLong(out, this.realEnd);
                    SimpleSerialization.writeInt(out, this.isColdStartup);
                }
                out.flush();
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        boolean readFrom(InputStream input) {
            try {
                byte[] head = new byte[MAGIC.length];
                input.read(head);
                if (!Arrays.equals(head, MAGIC)) {
                    if (ApplicationTracer.DEBUG) {
                        BLog.w(ApplicationTracer.TAG, "header doesn't match");
                    }
                    return false;
                }
                int ver = SimpleSerialization.readInt(input);
                readFrom(input, ver);
                return true;
            } catch (Exception e) {
                if (ApplicationTracer.DEBUG) {
                    BLog.d(ApplicationTracer.TAG, "read exception " + e);
                }
                return false;
            }
        }

        private void readFrom(InputStream input, int ver) throws IOException {
            if (ver == 2) {
                if (((byte) input.read()) == -1) {
                    throw new EOFException();
                }
                this.id = SimpleSerialization.readString(input);
                this.start = SimpleSerialization.readLong(input);
                this.realStart = SimpleSerialization.readLong(input);
                this.realEnd = SimpleSerialization.readLong(input);
                this.isColdStartup = SimpleSerialization.readInt(input);
                return;
            }
            throw new IOException();
        }

        public String[] asArgs() {
            long duration = getDuration();
            return new String[]{Uri.encode(this.id), String.valueOf(this.start / 1000), String.valueOf((this.start + duration) / 1000), String.valueOf(duration / 1000), ApplicationTracer.ANDROID_ID, ApplicationTracer.IMEI, ApplicationTracer.WIFI_MAC, String.valueOf(this.isColdStartup), "", "", "", "", MsaHelper.getOaid(), DrmIdHelper.INSTANCE.getDrmId()};
        }

        public Map<String, String> asMap() {
            long duration = getDuration();
            Map<String, String> map = new HashMap<>();
            map.put("eid", this.id);
            map.put("start_time", String.valueOf(this.start));
            map.put("end_time", String.valueOf(this.start + duration));
            map.put("duration", String.valueOf(duration));
            map.put("openudid", ApplicationTracer.ANDROID_ID);
            map.put("idfa", ApplicationTracer.IMEI);
            map.put("mac", ApplicationTracer.WIFI_MAC);
            map.put("is_coldstart", String.valueOf(this.isColdStartup));
            map.put("buvid_fp", BiliIds.buvidLocal());
            map.put("deviceid_fp", BiliIds.buvidServer());
            map.put("oaid", MsaHelper.getOaid());
            map.put("drmid", DrmIdHelper.INSTANCE.getDrmId());
            map.put("buvid3", BuvidHelper.getRemoteBuvid());
            map.put("local_buvid", BuvidHelper.getLocalBuvid());
            return map;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static class SessionManager {
        private static final String FILE_NAME = "bili_main.session.5.26";
        private Session mCurrentSession;
        private AtomicFile mFile;
        private boolean mLoaded = false;
        private Object mWritingToken = new Object();
        boolean sColdStart = true;
        private Handler mDiskIOHandler = HandlerThreads.getHandler(3);

        SessionManager(Context context) {
            startLoadSession(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void initFile(Context context) {
            File file = new File(context.getFilesDir(), FILE_NAME);
            if (file.isDirectory()) {
                FileUtils.deleteQuietly(file);
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            this.mFile = new AtomicFile(file);
        }

        private void startLoadSession(final Context context) {
            synchronized (this) {
                this.mLoaded = false;
            }
            this.mDiskIOHandler.post(new Runnable() { // from class: tv.danmaku.bili.report.ApplicationTracer.SessionManager.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (SessionManager.this) {
                        SessionManager.this.initFile(context.getApplicationContext());
                        SessionManager.this.loadFromDiskLocked();
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadFromDiskLocked() {
            if (this.mLoaded) {
                return;
            }
            try {
                FileInputStream input = this.mFile.openRead();
                Session session = new Session();
                if (session.readFrom(input)) {
                    this.mCurrentSession = session;
                } else {
                    this.mCurrentSession = null;
                }
                IOUtils.closeQuietly(input);
            } catch (FileNotFoundException e) {
            }
            this.mLoaded = true;
            notifyAll();
        }

        public void persist(boolean maybeStart) {
            if (this.mCurrentSession == null) {
                return;
            }
            this.mDiskIOHandler.removeCallbacksAndMessages(this.mWritingToken);
            final Session session = this.mCurrentSession;
            this.mDiskIOHandler.postAtTime(new Runnable() { // from class: tv.danmaku.bili.report.ApplicationTracer.SessionManager.2
                @Override // java.lang.Runnable
                public void run() {
                    SessionManager.this.writeToDisk(session);
                }
            }, this.mWritingToken, SystemClock.uptimeMillis() + (maybeStart ? BR.rightBtnBackDrawable : 0));
        }

        void writeToDisk(Session session) {
            try {
                FileOutputStream out = this.mFile.startWrite();
                if (!session.writeTo(out)) {
                    BLog.e(ApplicationTracer.TAG, "failed to write session " + session.id + " to file " + this.mFile.getBaseFile().getPath());
                    this.mFile.failWrite(out);
                    return;
                }
                this.mFile.finishWrite(out);
                if (ApplicationTracer.DEBUG) {
                    BLog.d(ApplicationTracer.TAG, "write session file " + session.id);
                }
            } catch (IOException e) {
                if (ApplicationTracer.DEBUG) {
                    BLog.w(ApplicationTracer.TAG, e);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void awaitLoadedLocked() {
            while (!this.mLoaded) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
        }

        public void updateSession(boolean maybeStart) {
            this.mDiskIOHandler.post(new SessionTicker(maybeStart));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public class SessionTicker implements Runnable {
            boolean maybeStart;

            SessionTicker(boolean maybeStart) {
                this.maybeStart = maybeStart;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (SessionManager.this) {
                    SessionManager.this.awaitLoadedLocked();
                }
                if (SessionManager.this.mCurrentSession == null) {
                    if (this.maybeStart) {
                        SessionManager.this.mCurrentSession = SessionManager.newSession(SessionManager.this.sColdStart);
                    } else {
                        BLog.e(ApplicationTracer.TAG, "should not call onPause() before onResume()!");
                        return;
                    }
                } else if (this.maybeStart && SessionManager.this.mCurrentSession.isExpired()) {
                    Session localSession = new Session();
                    if (readLocalAndCheckExpiration(localSession)) {
                        SessionManager.this.reportSession(SessionManager.this.mCurrentSession);
                        if (ApplicationTracer.DEBUG) {
                            BLog.i(ApplicationTracer.TAG, "Current session expired " + SessionManager.this.mCurrentSession.id);
                        }
                        localSession.start(SessionManager.this.sColdStart);
                    } else {
                        if (ApplicationTracer.DEBUG) {
                            BLog.i(ApplicationTracer.TAG, "Restore current session " + localSession.id + " from " + SessionManager.this.mCurrentSession.id);
                        }
                        localSession.mark();
                    }
                    SessionManager.this.mCurrentSession = localSession;
                } else {
                    if (!SessionManager.this.mCurrentSession.isValid()) {
                        BuglyLog.w(ApplicationTracer.TAG, "Wants to +1s into invalid session : " + String.valueOf(SessionManager.this.mCurrentSession));
                        CrashReporter.INSTANCE.postCaughtException(new IllegalStateException("[A] Session is invalid"));
                        SessionManager.this.mCurrentSession.start(SessionManager.this.sColdStart);
                    }
                    SessionManager.this.mCurrentSession.mark();
                    if (ApplicationTracer.DEBUG && this.maybeStart) {
                        BLog.i(ApplicationTracer.TAG, "Extend current session " + SessionManager.this.mCurrentSession.id);
                    }
                }
                SessionManager.this.persist(this.maybeStart);
            }

            private boolean readLocalAndCheckExpiration(Session local) {
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                }
                FileInputStream input = null;
                try {
                    input = SessionManager.this.mFile.openRead();
                    local.readFrom(input);
                    IOUtils.closeQuietly(input);
                    if (TextUtils.equals(SessionManager.this.mCurrentSession.id, local.id)) {
                        return local.isExpired();
                    }
                    return local.realStart <= SessionManager.this.mCurrentSession.realStart && local.start <= SessionManager.this.mCurrentSession.start;
                } catch (Exception e2) {
                    IOUtils.closeQuietly(input);
                    return true;
                } catch (Throwable th) {
                    IOUtils.closeQuietly(input);
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Session newSession(boolean coldstart) {
            Session session = new Session();
            session.start(coldstart);
            return session;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reportSession(Session session) {
            if (!session.isValid()) {
                return;
            }
            if (!ApplicationTracer.sHasInit) {
                ApplicationTracer.initIds(BiliContext.application());
                ApplicationTracer.sHasInit = true;
            }
            final Map<String, String> v3 = session.asMap();
            final String[] v2 = session.asArgs();
            DelayReportForOaid.INSTANCE.delayIfNeed(new Function0() { // from class: tv.danmaku.bili.report.ApplicationTracer$SessionManager$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return ApplicationTracer.SessionManager.this.m1300lambda$reportSession$0$tvdanmakubilireportApplicationTracer$SessionManager(v3, v2);
                }
            });
            AppsFlyerWrapper.start(BiliContext.application());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$reportSession$0$tv-danmaku-bili-report-ApplicationTracer$SessionManager  reason: not valid java name */
        public /* synthetic */ Unit m1300lambda$reportSession$0$tvdanmakubilireportApplicationTracer$SessionManager(Map v3, final String[] v2) {
            if (((String) v3.get("oaid")).isEmpty()) {
                v3.put("oaid", MsaHelper.getOaid());
            }
            Neurons.report(true, 4, ((Boolean) ConfigManager.ab().get("dausdk.exchange.enable", true)).booleanValue() ? "app.active.duration-infra.sys" : NeuronEventId.APP_ACTIVE, v3);
            if (v2[12].isEmpty()) {
                v2[12] = MsaHelper.getOaid();
            }
            GripperExecuteKt.subscribeReady(GripperExecute.Companion.of(), GInfoeyes.class, new Function0<Unit>() { // from class: tv.danmaku.bili.report.ApplicationTracer.SessionManager.3
                public Unit invoke() {
                    InfoEyesManager.getInstance().report2(true, TaskIdConst.TABLE_APP_ACTIVE, v2);
                    return null;
                }
            });
            BLog.i(ApplicationTracer.TAG, "report duration is" + v3);
            return null;
        }
    }
}