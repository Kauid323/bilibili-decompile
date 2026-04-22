package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.alipay.sdk.app.PayTask;
import com.bilibili.privacy.ILog;
import com.bilibili.privacy.PrivacyHelper;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TML */
public final class d5 extends PhoneStateListener {
    public volatile boolean a;
    public final m4 b;
    public long g;
    public HandlerThread h;
    public b i;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f21c = new byte[0];
    public CellLocation d = null;
    public SignalStrength e = null;
    public ServiceState f = null;
    public d6 j = new d6();

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class b extends Handler {
        public volatile boolean a;

        public void a() {
            this.a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (d5.this.a) {
                synchronized (d5.this.f21c) {
                    if (d5.this.i != null && !this.a) {
                        sendEmptyMessageDelayed(0, 35000L);
                    }
                }
                d5.this.c(u6.b(d5.this.b));
            }
        }

        public b(Looper looper) {
            super(looper);
            this.a = false;
            this.a = false;
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class c implements Runnable {
        public w5 a;

        public c(m4 m4Var) {
        }

        public void a(w5 w5Var) {
            this.a = w5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            w5 w5Var = this.a;
            if (w5Var != null) {
                o1.a().a(w5Var);
            }
        }
    }

    public d5(m4 m4Var) {
        this.b = m4Var;
    }

    public final void d() {
        d6 d6Var = this.j;
        d6Var.f12c = true;
        d6Var.f = this.d;
        d6Var.g = this.e;
        w5 b2 = w5.b(this.b, d6Var);
        synchronized (this.f21c) {
            if (this.i != null && b2 != null) {
                c cVar = new c(this.b);
                cVar.a(b2);
                this.i.post(cVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        int i;
        TelephonyManager g;
        boolean a2;
        if (this.a) {
            ServiceState serviceState = this.f;
            int i2 = 13004;
            boolean z = true;
            if (serviceState != null) {
                if (serviceState.getState() == 0) {
                    i = 13003;
                } else if (this.f.getState() == 1) {
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

    public void f() {
        if (this.a) {
            this.a = false;
            a(0);
            synchronized (this.f21c) {
                if (this.i != null) {
                    this.i.a();
                    this.i.removeCallbacksAndMessages(null);
                    this.i = null;
                }
                if (this.h != null) {
                    this.h.quit();
                    this.h = null;
                }
                a();
                this.g = 0L;
            }
            a7.c("TxCellProvider", "shutdown: state=[shutdown]");
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        super.onCellLocationChanged(cellLocation);
        if (a(cellLocation)) {
            this.d = cellLocation;
            c();
            return;
        }
        a7.b("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + cellLocation);
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        super.onServiceStateChanged(serviceState);
        if (serviceState == null) {
            return;
        }
        ServiceState serviceState2 = this.f;
        if (serviceState2 == null || serviceState2.getState() != serviceState.getState()) {
            this.f = serviceState;
            e();
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength == null) {
            return;
        }
        try {
            SignalStrength signalStrength2 = this.e;
            int m = this.b.a().m();
            if (signalStrength2 == null || u6.a(m, signalStrength2, signalStrength)) {
                this.e = signalStrength;
                c();
            }
        } catch (Exception e) {
            a7.b("TxCellProvider", e.toString());
        }
    }

    public final void b() {
        synchronized (this.f21c) {
            HandlerThread handlerThread = new HandlerThread("CellProvider");
            this.h = handlerThread;
            handlerThread.start();
            b bVar = new b(this.h.getLooper());
            this.i = bVar;
            bVar.sendEmptyMessageDelayed(0, PayTask.j);
        }
    }

    public final void c(CellLocation cellLocation) {
        onCellLocationChanged(cellLocation);
    }

    public void a(Handler handler) {
        if (this.a) {
            return;
        }
        this.a = true;
        b();
        d6 d6Var = this.j;
        d6Var.f12c = false;
        d6Var.g = this.e;
        w5 b2 = w5.b(this.b, d6Var);
        if (b2 != null) {
            o1.a().a(b2);
        }
        a(273);
        a7.c("TxCellProvider", "startup: state=[start]");
    }

    public final void c() {
        if (this.a && this.d != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.g > 2000) {
                this.g = currentTimeMillis;
                d();
            }
        }
    }

    public final boolean b(CellLocation cellLocation) {
        d6 d6Var = this.j;
        d6Var.f12c = true;
        d6Var.f = this.d;
        d6Var.g = this.e;
        w5 b2 = w5.b(this.b, d6Var);
        if (b2 == null) {
            return true;
        }
        return u6.a(b2);
    }

    public final void a(int i) {
        try {
            __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_listen(this.b.g(), this, i);
        } catch (Exception e) {
            a7.a("TxCellProvider", "listenCellState: failed! flags=" + i, e);
        }
    }

    public final void a() {
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public final boolean a(CellLocation cellLocation) {
        if (cellLocation == null) {
            return false;
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0) {
                if (gsmCellLocation.getLac() == 0) {
                    return false;
                }
            }
        } catch (ClassCastException e) {
        }
        return u6.a(cellLocation) >= 0 && !u6.a(this.d, cellLocation) && b(cellLocation);
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