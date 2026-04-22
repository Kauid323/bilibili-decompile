package tv.danmaku.ijk.media.player.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;
import tv.danmaku.ijk.media.player.utils.IjkNetworkManager;

public class IjkMediaPlayerMonitor implements IIjkMediaPlayerMonitor, IjkNetworkManager.NetWorkChangeListener {
    private static final int DO_UPDATE_SYSTEM_INFO = 0;
    private static final int POLLING_INTERVAL = 3000;
    private static final String PREF_CPU_NAME = "pref_ijktracker_key_cpu_name";
    private static final String PREF_NAME = "pref_ijktracker";
    private static IjkMediaPlayerMonitor sMonitor = null;
    private final String TAG = "IjkMediaPlayerMonitor";
    private Context mContext = null;
    private SharedPreferences mPref = null;
    private String mCpuName = null;
    private int mActiveNetworkInfoType = 0;
    private IjkNetworkUtils.NetWorkType mNetWorkType = IjkNetworkUtils.NetWorkType.NONE;
    private HandlerThread mHandlerThread = null;
    private TaskHandler mHandler = null;
    private int mUseCount = 0;
    private boolean mInited = false;
    private boolean mStarted = false;

    public static synchronized IIjkMediaPlayerMonitor getInstance() {
        IjkMediaPlayerMonitor ijkMediaPlayerMonitor;
        synchronized (IjkMediaPlayerMonitor.class) {
            if (sMonitor == null) {
                sMonitor = new IjkMediaPlayerMonitor();
            }
            ijkMediaPlayerMonitor = sMonitor;
        }
        return ijkMediaPlayerMonitor;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public int getActiveNetworkInfoType() {
        if (!this.mStarted) {
            return getActiveNetworkInfoTypeInternal();
        }
        return this.mActiveNetworkInfoType;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public String getCpuName() {
        if (this.mCpuName != null) {
            return this.mCpuName;
        }
        if (this.mPref != null) {
            String cpuName = this.mPref.getString(PREF_NAME, null);
            if (TextUtils.isEmpty(cpuName)) {
                this.mCpuName = IjkCpuInfo.getCpuName();
                this.mPref.edit().putString(PREF_CPU_NAME, this.mCpuName).apply();
            }
        } else {
            this.mCpuName = IjkCpuInfo.getCpuName();
        }
        return this.mCpuName;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public Looper getLooper() {
        if (!this.mInited) {
            return null;
        }
        return this.mHandlerThread.getLooper();
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public IjkNetworkUtils.NetWorkType getNetworkState() {
        if (!this.mStarted) {
            return getNetWorkTypeInternal();
        }
        return this.mNetWorkType;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public IIjkMediaPlayerMonitor init(Context context) {
        if (this.mInited) {
            return this;
        }
        if (context == null) {
            return this;
        }
        Context appContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("ijk_java_monitor");
        handlerThread.start();
        Looper looper = handlerThread.getLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
            BLog.i("IjkMediaPlayerMonitor", "Initialize Monitor Looper at main thread !!!");
        }
        IjkNetworkManager.getInstance(appContext).registerListener(this);
        TaskHandler handler = new TaskHandler(this, looper);
        synchronized (this) {
            if (!this.mInited) {
                this.mContext = appContext;
                this.mHandlerThread = handlerThread;
                this.mHandler = handler;
                this.mInited = true;
            }
        }
        return this;
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public void start() {
        if (!this.mInited) {
            return;
        }
        synchronized (this) {
            this.mUseCount++;
            this.mHandler.removeMessages(0);
            this.mHandler.sendEmptyMessage(0);
        }
    }

    @Override // tv.danmaku.ijk.media.player.utils.IIjkMediaPlayerMonitor
    public void pause() {
        if (!this.mInited) {
            return;
        }
        synchronized (this) {
            this.mUseCount--;
            if (this.mUseCount == 0) {
                this.mHandler.removeMessages(0);
            }
        }
    }

    private boolean isConnectedWifi(NetworkInfo info) {
        return info != null && info.isConnected() && info.getType() == 1;
    }

    private NetworkInfo getActiveNetworkInfoInternal() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private int getActiveNetworkInfoTypeInternal() {
        NetworkInfo activeNetInfo = getActiveNetworkInfoInternal();
        if (activeNetInfo != null) {
            return activeNetInfo.getType();
        }
        return this.mActiveNetworkInfoType;
    }

    private IjkNetworkUtils.NetWorkType getNetWorkTypeInternal() {
        IjkNetworkUtils.NetWorkType type = IjkNetworkUtils.NetWorkType.NONE;
        try {
            IjkNetworkUtils.NetWorkType type2 = IjkNetworkUtils.getNetworkState(this.mContext);
            return type2;
        } catch (Exception e) {
            return type;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSystemInfo() {
        synchronized (this) {
            this.mActiveNetworkInfoType = getActiveNetworkInfoTypeInternal();
            this.mNetWorkType = getNetWorkTypeInternal();
            this.mStarted = true;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private static final class TaskHandler extends Handler {
        private WeakReference<IjkMediaPlayerMonitor> mWeakInstance;

        TaskHandler(IjkMediaPlayerMonitor instance, Looper looper) {
            super(looper);
            this.mWeakInstance = null;
            this.mWeakInstance = new WeakReference<>(instance);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            IjkMediaPlayerMonitor monitor = this.mWeakInstance.get();
            if (monitor == null) {
                return;
            }
            switch (msg.what) {
                case 0:
                    monitor.updateSystemInfo();
                    sendEmptyMessageDelayed(0, PlayerToastConfig.DURATION_3);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // tv.danmaku.ijk.media.player.utils.IjkNetworkManager.NetWorkChangeListener
    public void onNetWorkChange(IjkNetworkUtils.NetWorkType cur, IjkNetworkUtils.NetWorkType old) {
        synchronized (this) {
            this.mNetWorkType = cur;
        }
    }
}