package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/* compiled from: TML */
public final class s5 extends BroadcastReceiver {
    public static boolean n;
    public volatile boolean a;
    public final m4 b;

    /* renamed from: c  reason: collision with root package name */
    public final WifiManager f95c;
    public HashSet<String> d;
    public volatile Handler e;
    public volatile Handler f;
    public volatile b g;
    public volatile List<ScanResult> h;
    public volatile List<ScanResult> i;
    public Runnable j;
    public String k;
    public long l = 30000;
    public final byte[] m = new byte[0];

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void a() {
            s5.this.k = "";
            List list = s5.this.h;
            if (list != null && list.size() > 0) {
                if (s5.this.i == null) {
                    s5.this.i = new ArrayList();
                }
                try {
                    int min = Math.min(20, list.size());
                    for (int i = 0; i < min; i++) {
                        if (list.get(i) != null) {
                            s5.a(s5.this, (Object) (((ScanResult) list.get(i)).SSID + "," + ((ScanResult) list.get(i)).BSSID + "|"));
                        }
                    }
                } catch (Throwable th) {
                    a7.b("TxWifiProvider", th.toString());
                }
                s5.this.i.clear();
                s5.this.i.addAll(list);
                t5.a(s5.this.i);
                a7.c("TxWifiProvider", "processScanResultsAvailable,mNewScanList size: " + s5.this.i.size());
                if (s5.this.i == null || s5.this.i.size() <= 0) {
                    return;
                }
                s5 s5Var = s5.this;
                s5Var.b(s5Var.i);
                return;
            }
            a7.b("TxWifiProvider", "wifis, notify wifiList is null");
            o1.a().a(e6.d);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (s5.this.m) {
                switch (message.what) {
                    case 1201:
                        s5.this.a();
                        break;
                    case 1202:
                        a7.c("TxWifiProvider", "MSG_SCAN_RESULTS_AVAILABLE");
                        a();
                        break;
                    case 1203:
                        a7.c("TxWifiProvider", "MSG_WIFI_BROADCAST_ONRECEIVE");
                        s5.this.a((Intent) message.obj);
                        break;
                    case 1204:
                        a7.c("TxWifiProvider", "wifi scan. interval:" + s5.this.l + ", success:" + s5.this.c());
                        if (s5.this.g != null && s5.this.l > 0) {
                            s5.this.g.removeMessages(1204);
                            s5.this.g.sendEmptyMessageDelayed(1204, s5.this.l);
                            break;
                        }
                        break;
                }
            }
        }
    }

    public s5(m4 m4Var) {
        this.b = m4Var;
        this.f95c = m4Var.i();
        g7.a = 0L;
        this.d = new HashSet<>();
        this.j = new a();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        a7.c("TxWifiProvider", "wifi broadcast onReceive");
        a(1203, intent);
    }

    public final boolean c() {
        if (j7.c(this.b) && !n) {
            boolean b2 = j7.b(this.f95c);
            x3.a("WIFI", "fs:" + d4.a(b2));
            return b2;
        }
        a7.b("TxWifiProvider", "wifi is disable");
        return false;
    }

    public final void d(List<ScanResult> list) {
        if (a(list)) {
            e6 e6Var = new e6(list, System.currentTimeMillis(), j7.a(this.f95c));
            a7.c("wifis", "notifyListener, wifiInfo: " + e6Var);
            o1.a().a(e6Var);
            a7.c("TxWifiProvider", "notifyListeners wifiInfo");
        }
    }

    public void b() {
        synchronized (this.m) {
            if (this.a) {
                this.a = false;
                g7.a = 0L;
                try {
                    this.b.a.unregisterReceiver(this);
                    a7.b("TxWifiProvider", "unregisterReceiver success");
                } catch (Exception e) {
                    a7.b("TxWifiProvider", "unregisterReceiver failed");
                }
                this.d = null;
                if (this.i != null) {
                    this.i.clear();
                }
                if (this.d != null) {
                    this.d.clear();
                }
                if (this.g != null) {
                    this.g.removeCallbacksAndMessages(null);
                    this.g = null;
                }
                a7.c("TxWifiProvider", "shutdown: state=[shutdown]");
            }
        }
    }

    public static /* synthetic */ String a(s5 s5Var, Object obj) {
        String str = s5Var.k + obj;
        s5Var.k = str;
        return str;
    }

    public void a(Handler handler, Handler handler2, Handler handler3, boolean z) {
        synchronized (this.m) {
            if (this.a) {
                return;
            }
            this.a = true;
            g7.a = 0L;
            n = z;
            this.e = handler;
            this.f = handler3;
            if (this.g == null || this.g.getLooper() != handler.getLooper()) {
                if (this.g != null) {
                    this.g.removeCallbacksAndMessages(null);
                }
                if (handler != null) {
                    this.g = new b(handler.getLooper());
                }
            }
            handler2.post(this.j);
            if (!n) {
                a(0L);
            }
            a7.c("TxWifiProvider", "startup: state=[start]");
        }
    }

    public final boolean c(List<ScanResult> list) {
        HashSet<String> hashSet = this.d;
        if (hashSet == null || list == null || hashSet.size() != list.size()) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        for (ScanResult scanResult : list) {
            if (scanResult != null) {
                hashSet2.add(scanResult.BSSID + scanResult.level);
            }
        }
        return this.d.containsAll(hashSet2);
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            try {
                if (s5.this.f != null) {
                    __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(s5.this.b.a, s5.this, intentFilter, null, s5.this.f);
                } else {
                    __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(s5.this.b.a, s5.this, intentFilter);
                }
            } catch (Exception e) {
                a7.a("TxWifiProvider", "listenWifiState: failed", e);
            }
        }

        private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter) {
            if (Build.VERSION.SDK_INT >= 34) {
                return ((Context) ctx).registerReceiver(receiver, filter, 4);
            }
            return ((Context) ctx).registerReceiver(receiver, filter);
        }

        private static Intent __Ghost$Insertion$com_bilibili_infra_base_aop_RegisterReceiverHook_hookRegisterReceiver(Object ctx, BroadcastReceiver receiver, IntentFilter filter, String permission, Handler scheduler) {
            if (Build.VERSION.SDK_INT >= 34) {
                return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler, 4);
            }
            return ((Context) ctx).registerReceiver(receiver, filter, permission, scheduler);
        }
    }

    public void b(long j) {
        this.l = j;
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            a7.c("TxWifiProvider", "onWifiBroadcastReceive: " + action);
            boolean equals = "android.net.wifi.WIFI_STATE_CHANGED".equals(action);
            boolean equals2 = "android.net.wifi.SCAN_RESULTS".equals(action);
            if (equals) {
                a(1201);
            }
            if (equals2 || equals) {
                a7.b("TxWifiProvider", "begin getScanResult, isAvailableAction=" + equals2 + ",isStatusAction=" + equals);
                this.h = j7.a(this.f95c, equals2);
                a7.c("wifis", "onWifiBroadcastReceive, scanList: " + this.h.size());
                w6.a("wr," + equals2 + "," + equals + "," + this.h.size());
                a(1202);
            }
        } catch (Throwable th) {
            a7.a("TxWifiProvider", "onReceive() error!", th);
        }
    }

    public final void b(List<ScanResult> list) {
        if (list != null && list.size() > 0) {
            if (j7.a) {
                a7.c("TxWifiProvider", "handleWifiUpdate,Permission_Denied");
                j7.a = false;
                a();
            }
            boolean c2 = c(list);
            a7.c("wifis", "handleWifiUpdate isSame: " + c2);
            if (!c2) {
                d(list);
                HashSet<String> hashSet = this.d;
                if (hashSet != null) {
                    hashSet.clear();
                    for (ScanResult scanResult : list) {
                        if (scanResult != null) {
                            this.d.add(scanResult.BSSID + scanResult.level);
                        }
                    }
                }
                a7.b("TxWifiProvider", "wifi list not same. update");
                return;
            }
            a7.b("TxWifiProvider", "wifi list size, mac and rssi same. not update");
            return;
        }
        a7.c("TxWifiProvider", "handleWifiUpdate,scanList null or empty");
        a();
    }

    public final void a(int i) {
        if (this.g != null) {
            p3.b(this.g, i);
        }
    }

    public final void a(int i, Object obj) {
        b bVar = this.g;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.obj = obj;
            p3.a(bVar, obtainMessage);
        }
    }

    public void a(long j) {
        if (this.g != null) {
            this.g.sendEmptyMessageDelayed(1204, j);
        }
    }

    public final boolean a(List<ScanResult> list) {
        if (this.g != null && !d4.a((Collection) list)) {
            try {
                if (!j7.c(this.b)) {
                    long j = 0;
                    for (ScanResult scanResult : list) {
                        j = Math.max(scanResult.timestamp, j);
                    }
                    long elapsedRealtime = SystemClock.elapsedRealtime() - (j / 1000);
                    boolean z = elapsedRealtime <= 60000;
                    try {
                        x3.a("WIFI", "wifi closed,list v=" + z + ",d_t=" + elapsedRealtime + "ms");
                        a7.c("wifis", "checkScanListValid,wifi closed,list v=" + z + ",d_t=" + elapsedRealtime + "msscanreuslt size: " + list);
                    } catch (Throwable th) {
                    }
                    return z;
                }
                a7.c("TxWifiProvider", "checkScanListValid,wifi not scannable!");
                return true;
            } catch (Throwable th2) {
                return true;
            }
        }
        a7.c("TxWifiProvider", "checkScanListValid,ScanResult invalid!");
        return false;
    }

    public final void a() {
        int i;
        a7.c("TxWifiProvider#notifyStatus", "notifyStatus");
        try {
            int a2 = j7.a(this.f95c);
            if (a2 == 3) {
                a(0L);
                i = 13001;
            } else if (a2 == 1) {
                if (!j7.c(this.b)) {
                    if (this.i != null) {
                        this.i.clear();
                    }
                    if (this.e != null) {
                        a7.c("TxWifiProvider#notifyStatus", "wifi开关关闭，且alwaysScan关闭，清空wifi列表， send msg MSG_ID_CLEAR_WIFI(555)");
                        p3.b(this.e, 555);
                    }
                }
                i = 13002;
            } else {
                i = -1;
            }
            try {
                if (Settings.Secure.getInt(this.b.a.getContentResolver(), "location_mode") == 0) {
                    i = 13005;
                }
            } catch (Throwable th) {
            }
            a7.c("TxWifiProvider#notifyStatus", "notifyStatus wifiProvider");
            o1.a().a(new r1(12001, i));
        } catch (Throwable th2) {
            a7.a("TxWifiProvider#notifyStatus", "notifyStatus error!", th2);
        }
    }
}