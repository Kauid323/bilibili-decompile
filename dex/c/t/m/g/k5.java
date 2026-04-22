package c.t.m.g;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public final class k5 {
    public volatile boolean a;
    public final m4 b;
    public HandlerThread g;
    public b h;
    public c i;
    public SignalStrength j;

    /* renamed from: c  reason: collision with root package name */
    public w5 f54c = null;
    public ServiceState d = null;
    public w5 e = null;
    public w5 f = null;
    public c6 k = new c6();
    public d6 l = new d6();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k5.this.i = new c();
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class b extends Handler {
        public volatile boolean a;

        /* compiled from: TML */
        /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
        public class a extends TelephonyManager.CellInfoCallback {
            public a() {
            }

            @Override // android.telephony.TelephonyManager.CellInfoCallback
            public void onCellInfo(List<CellInfo> list) {
                p3.b(k5.this.h, 10005, 0, 0, list);
            }
        }

        public /* synthetic */ b(k5 k5Var, Looper looper, a aVar) {
            this(looper);
        }

        public final void a(Message message) {
            if (!k5.this.a || this.a) {
                return;
            }
            switch (message.what) {
                case 10002:
                    p3.a(k5.this.h, 10002);
                    w3.c("TxNewCellProvider", "MSG_ID_CELL_TIMER，cell access 30s timed");
                    b();
                    if (k5.this.f == null && k5.this.e == null) {
                        w3.a("TxNewCellProvider", "MSG_ID_CELL_TIMER，retry to access cell info");
                        p3.a(k5.this.h, 10003, 2000L);
                    }
                    p3.a(k5.this.h, 10002, 35000L);
                    return;
                case 10003:
                    w3.c("TxNewCellProvider", "MSG_ID_CELL_RETRY，cell access retry");
                    b();
                    return;
                case 10004:
                    p3.a(k5.this.h, 10004);
                    try {
                        if (Build.VERSION.SDK_INT > 29) {
                            w3.c("TxNewCellProvider", "handleMessage(MSG_ID_CELL_TIMER_REQUEST),ThreadName = " + Thread.currentThread().getName());
                            w3.c("CellPrivcay", "requestCellInfoUpdate");
                            k5.this.b.g().requestCellInfoUpdate(AsyncTask.THREAD_POOL_EXECUTOR, new a());
                        }
                    } catch (Exception e) {
                        w3.a("TxNewCellProvider", "MSG_ID_CELL_TIMER_REQUEST", e);
                    }
                    p3.a(k5.this.h, 10004, 30000L);
                    return;
                case 10005:
                    List<CellInfo> list = (List) message.obj;
                    w3.c("TxNewCellProvider", "handleMessage(MSG_ID_CELL_TIMER_REQUEST),ThreadName = " + Thread.currentThread().getName() + ",onCellInfo: " + (list == null ? "null" : "size:" + list.size()));
                    if (list == null || list.size() == 0) {
                        return;
                    }
                    k5.this.k.f12c = true;
                    k5.this.k.f = list;
                    w5 a2 = w5.a(k5.this.b, k5.this.k);
                    if (a2.h()) {
                        w3.a("TxNewCellProvider", "handleMessage(MSG_ID_CELL_TIMER_REQUEST) " + a2);
                        k5.this.e = a2;
                        k5.this.a(3);
                        return;
                    }
                    w3.a("TxNewCellProvider", "handleMessage(MSG_ID_CELL_TIMER_REQUEST) invalid cell. " + a2);
                    return;
                default:
                    return;
            }
        }

        public final void b() {
            boolean z;
            w3.a("TxNewCellProvider", "tryUpdateCellInfoAndCellLoc，timer notify");
            w5 w5Var = k5.this.f54c;
            if (w5Var == null || !w5Var.a(15000L)) {
                if (k5.this.b.g() == null) {
                    w3.a("TxNewCellProvider", "tryUpdateCellInfoAndCellLoc，mcellinfo is null or isFresh");
                    return;
                }
                k5.this.k.f12c = false;
                w5 a2 = w5.a(k5.this.b, k5.this.k);
                boolean z2 = true;
                if (a2.h() && !a2.b(k5.this.e)) {
                    k5.this.e = a2;
                    z = true;
                } else {
                    z = false;
                }
                k5.this.l.f12c = false;
                k5.this.l.g = k5.this.j;
                w5 b = w5.b(k5.this.b, k5.this.l);
                if (b == null || !b.h() || b.b(k5.this.f)) {
                    z2 = z;
                } else {
                    k5.this.f = b;
                }
                if (z2) {
                    k5.this.a(2);
                    return;
                }
                return;
            }
            w3.a("TxNewCellProvider", "tryUpdateCellInfoAndCellLoc，mTencentCellinfo is not null && is fresh");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Exception e) {
                w3.a("TxNewCellProvider", "handle message error.", e);
            }
        }

        public b(Looper looper) {
            super(looper);
            this.a = false;
            this.a = false;
        }

        public void a() {
            this.a = true;
        }
    }

    public k5(m4 m4Var) {
        this.b = m4Var;
        g7.b = 0L;
    }

    public void b() {
        if (this.a) {
            this.a = false;
            g7.b = 0L;
            c cVar = this.i;
            if (cVar != null) {
                cVar.a();
            }
            b bVar = this.h;
            if (bVar != null) {
                bVar.a();
                p3.b(bVar);
            }
            this.h = null;
            HandlerThread handlerThread = this.g;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.g = null;
            this.f54c = null;
            this.d = null;
            this.i = null;
            this.j = null;
            w3.c("TxNewCellProvider", "shutdown: state=[shutdown]");
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class c extends PhoneStateListener {
        public c() {
            a(1297);
        }

        public final void a(int i) {
            try {
                __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_listen(k5.this.b.g(), this, i);
                x3.a("cell", "lCS");
            } catch (Throwable th) {
                w3.a("TxNewCellProvider", "listenCellState: failed! flags=" + i, th);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list != null && list.size() != 0) {
                k5.this.k.f12c = true;
                k5.this.k.f = list;
                w5 a = w5.a(k5.this.b, k5.this.k);
                if (a != null && a.h()) {
                    w3.a("TxNewCellProvider", "onCellInfoChanged " + a);
                    k5.this.e = a;
                    k5.this.a(0);
                    return;
                }
                w3.a("TxNewCellProvider", "onCellInfoChanged invalid cell. " + a.toString());
                return;
            }
            w3.a("TxNewCellProvider", "onCellInfoChanged: null");
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation == null) {
                w3.a("TxNewCellProvider", "onCellLocationChanged: null");
                return;
            }
            k5.this.l.f12c = true;
            k5.this.l.g = k5.this.j;
            w5 b = w5.b(k5.this.b, k5.this.l);
            if (b != null && b.h()) {
                w3.a("TxNewCellProvider", "onCellLocationChanged " + b);
                k5.this.f = b;
                k5.this.a(1);
                return;
            }
            w3.a("TxNewCellProvider", "onCellLocationChanged invalid cell");
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState == null) {
                return;
            }
            try {
                ServiceState serviceState2 = k5.this.d;
                if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
                    k5.this.d = serviceState;
                    k5.this.a();
                }
            } catch (Throwable th) {
                w3.a("TxNewCellProvider", "onServiceStateChanged error.", th);
            }
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            k5.this.j = signalStrength;
        }

        public void a() {
            a(0);
        }

        @JvmStatic
        private static void __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_listen(TelephonyManager tm, PhoneStateListener listener, int events) {
            Intrinsics.checkNotNullParameter(tm, "tm");
            PrivacyHelper.CacheDuration defaultCacheTime$iv = PrivacyHelper.CacheDuration.Companion.getNever();
            try {
                if (!PrivacyHelper.INSTANCE.hookEnable$privacy_debug("tm_listen")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "hook disable, tag: [tm_listen]", (Throwable) null, 4, (Object) null);
                    tm.listen(listener, Integer.valueOf(events).intValue());
                } else if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("tm_listen")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "user deny, tag: [tm_listen] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
                } else if (PrivacyHelper.INSTANCE.forbiddenUse$privacy_debug("tm_listen")) {
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "use forbidden, tag: [tm_listen] defaultReturnValue = [" + ((Object) null) + "]", (Throwable) null, 4, (Object) null);
                } else if (PrivacyHelper.access$hitPrivacyCache(PrivacyHelper.INSTANCE, "tm_listen") == null) {
                    tm.listen(listener, Integer.valueOf(events).intValue());
                    Object res$iv = Unit.INSTANCE;
                    PrivacyHelper.INSTANCE.getPrivacyCache().put("tm_listen", new PrivacyHelper.Cache(res$iv, PrivacyHelper.access$getDDCacheTime(PrivacyHelper.INSTANCE, "tm_listen", defaultCacheTime$iv)));
                    ILog.-CC.i$default(PrivacyHelper.access$getLog$p(), "privacy_", "runOnPrivacyControl tag: tm_listen", (Throwable) null, 4, (Object) null);
                }
            } catch (Throwable t$iv) {
                if (PrivacyHelper.access$getDebug$p()) {
                    PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_listen, message = " + t$iv.getMessage(), t$iv);
                    return;
                }
                PrivacyHelper.access$getLog$p().e("privacy_", "catch error. tag: tm_listen, message = " + t$iv.getMessage(), (Throwable) null);
            }
        }
    }

    public void a(Handler handler, boolean z) {
        if (this.a) {
            return;
        }
        g7.b = 0L;
        HandlerThread handlerThread = new HandlerThread("new_cell_provider");
        this.g = handlerThread;
        try {
            handlerThread.start();
            this.h = new b(this, this.g.getLooper(), null);
        } catch (Throwable th) {
            if (handler != null) {
                this.h = new b(this, handler.getLooper(), null);
            }
        }
        this.k.c();
        this.l.c();
        this.a = true;
        if (!z) {
            p3.b(this.h, 10004);
            p3.b(this.h, 10002);
        }
        this.h.postDelayed(new a(), 1000L);
        w3.c("TxNewCellProvider", "start up");
    }

    public w5 a(m4 m4Var) {
        w3.c("TxNewCellProvider", "getLastCell");
        c6 c6Var = this.k;
        c6Var.f12c = false;
        w5 a2 = w5.a(this.b, c6Var);
        if (a2.h()) {
            return a2;
        }
        d6 d6Var = this.l;
        d6Var.f12c = false;
        d6Var.g = this.j;
        return w5.b(this.b, d6Var);
    }

    public final void a(w5 w5Var) {
        if (this.a && w5Var != null && this.b != null) {
            synchronized (this) {
                this.f54c = w5Var;
                w3.c("TxNewCellProvider", "notifyListeners:" + w5Var);
                o1.a().a(w5Var);
            }
            return;
        }
        w3.c("TxNewCellProvider", "notifyListeners, cellInfo is not valid");
    }

    public final synchronized void a(int i) {
        w5 w5Var;
        w5 w5Var2 = this.e;
        w5 w5Var3 = this.f;
        if (w5Var2 == null && w5Var3 != null) {
            w5Var = w5.a(w5Var3);
        } else if (w5Var2 != null && w5Var3 == null) {
            w5Var = w5.a(w5Var2);
        } else if (w5Var2 != null && w5Var3 != null) {
            if (w5Var2.e() > w5Var3.e()) {
                w5Var = w5.a(w5Var2);
                w5Var.d().add(w5Var3);
            } else {
                w5 a2 = w5.a(w5Var3);
                a2.d().add(w5Var2);
                for (w5 w5Var4 : w5Var2.d()) {
                    a2.d().add(w5Var4);
                }
                w5Var = a2;
            }
        } else if (w5Var2 == null && w5Var3 == null) {
            return;
        } else {
            w5Var = null;
        }
        w5 w5Var5 = this.f54c;
        if (w5Var5 == null) {
            w3.a("TxNewCellProvider", "TxCellInfoChange First callback! source:" + i + "info:" + w5Var.toString());
            a(w5Var);
        } else if (w5Var5.t.containsAll(w5Var.t)) {
            w3.a("TxNewCellProvider", "TxCellInfoChange cell size " + w5Var5.t.size() + " same :" + w5Var5.toString());
        } else {
            w3.d("CELL", "TxCellInfoChange src=" + i + ",info=" + w5Var.i());
            a(w5Var);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a() {
        int i;
        TelephonyManager g;
        boolean a2;
        if (this.a) {
            ServiceState serviceState = this.d;
            int i2 = 13004;
            boolean z = true;
            if (serviceState != null) {
                if (serviceState.getState() == 0) {
                    i = 13003;
                } else if (serviceState.getState() == 1) {
                    i = 13004;
                }
                g = this.b.g();
                a2 = u6.a(this.b.a);
                if (g != null) {
                    z = false;
                } else if (i4.a(g) != 5) {
                    z = false;
                }
                if (!a2 && z) {
                    i2 = i;
                }
                o1.a().a(new r1(12003, i2));
            }
            i = -1;
            g = this.b.g();
            a2 = u6.a(this.b.a);
            if (g != null) {
            }
            if (!a2) {
                i2 = i;
            }
            o1.a().a(new r1(12003, i2));
        }
    }
}