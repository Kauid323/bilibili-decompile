package c.t.m.g;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: TML */
public class b5 extends ScanCallback {
    public final Context a;
    public BluetoothManager b;

    /* renamed from: c  reason: collision with root package name */
    public BluetoothAdapter f10c;
    public BluetoothLeScanner d;
    public ScanSettings e;
    public List<ScanFilter> f;
    public String[] i;
    public boolean j;
    public a k;
    public HandlerThread l;
    public long m = 0;
    public final byte[] n = new byte[0];
    public List<v5> g = new LinkedList();
    public List<v5> h = new LinkedList();

    public b5(Context context) {
        this.a = context;
        a7.c("hh", "TxBluetoothProvider fun_d");
        this.i = "AB8190D5-D11E-4941-ACC4-42F30510B408,FDA50693-A4E2-4FB1-AFCF-C6EB07647825".split(",");
        this.b = (BluetoothManager) this.a.getSystemService("bluetooth");
        this.e = new ScanSettings.Builder().setScanMode(1).build();
        this.f = new ArrayList();
        for (String str : this.i) {
            this.f.add(b(str));
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> list) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int i) {
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int i, ScanResult scanResult) {
        a aVar = this.k;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage();
            obtainMessage.what = 99003;
            obtainMessage.obj = scanResult;
            aVar.sendMessage(obtainMessage);
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a extends Handler {
        public double a;
        public double b;

        public a(Looper looper) {
            super(looper);
        }

        public void a(double d, double d2) {
            this.a = d;
            this.b = d2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                a(message);
            } catch (Throwable th) {
            }
        }

        public void a(Message message) {
            switch (message.what) {
                case 99001:
                    a7.c("TxBluetoothProvider", "start ble scan");
                    b5 b5Var = b5.this;
                    b5Var.f10c = b5Var.b == null ? null : b5.this.b.getAdapter();
                    if (b5.this.f10c != null) {
                        b5 b5Var2 = b5.this;
                        b5Var2.d = b5Var2.f10c.getBluetoothLeScanner();
                    }
                    b5.this.c();
                    return;
                case 99002:
                    if (b5.this.j) {
                        a7.c("TxBluetoothProvider", "stop ble scan");
                        b5.this.d();
                        return;
                    }
                    return;
                case 99003:
                    b5.this.a((ScanResult) message.obj);
                    return;
                case 99004:
                    if (a()) {
                        sendEmptyMessage(99001);
                        return;
                    } else {
                        sendEmptyMessage(99002);
                        return;
                    }
                default:
                    return;
            }
        }

        public final boolean a() {
            int i = 0;
            while (true) {
                double[][] dArr = e5.f;
                if (i >= dArr.length) {
                    return false;
                }
                double[] dArr2 = dArr[i];
                double d = this.a;
                if (d > dArr2[0] && d < dArr2[2]) {
                    double d2 = this.b;
                    if (d2 > dArr2[1] && d2 < dArr2[3]) {
                        return true;
                    }
                }
                i++;
            }
        }
    }

    public void b() {
        synchronized (this.n) {
            if (this.k != null) {
                this.k.removeCallbacksAndMessages(null);
                this.k = null;
            }
            if (this.l != null) {
                this.l = null;
            }
        }
    }

    public final int c() {
        try {
            if (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                if (this.f10c == null || !this.f10c.isEnabled() || this.d == null) {
                    return -2;
                }
                this.d.startScan(this.f, this.e, this);
                this.j = true;
                return 0;
            }
            return -1;
        } catch (Throwable th) {
            Log.e("TxBluetoothProvider", "start ble scan failed.", th);
            return -3;
        }
    }

    public final void d() {
        try {
            synchronized (this.n) {
                if (this.a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
                    if (this.d != null) {
                        this.d.stopScan(this);
                    }
                    this.f10c = null;
                    this.j = false;
                    synchronized (this.g) {
                        this.g.clear();
                    }
                }
            }
        } catch (Throwable th) {
            Log.e("TxBluetoothProvider", "stop ble scan failed.", th);
        }
    }

    public void a(Handler handler) {
        synchronized (this.n) {
            a7.c("TxBluetoothProvider", "ble provider startup");
            if (this.k == null) {
                if (handler != null && handler.getLooper() != null) {
                    a7.c("TxBluetoothProvider", "ble handler create on other thread");
                    this.k = new a(handler.getLooper());
                } else {
                    HandlerThread handlerThread = new HandlerThread("thread-bleloc");
                    this.l = handlerThread;
                    handlerThread.start();
                    Looper looper = this.l.getLooper();
                    a7.c("TxBluetoothProvider", "ble handler create on thread-bleloc thread");
                    this.k = new a(looper);
                }
            }
        }
    }

    public final ScanFilter b(String str) {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.arraycopy(a(str.replace("-", "")), 0, bArr, 2, 16);
        return new ScanFilter.Builder().setManufacturerData(76, bArr, new byte[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0}).build();
    }

    public void a(double d, double d2) {
        synchronized (this.n) {
            a aVar = this.k;
            if (aVar != null) {
                if (System.currentTimeMillis() - this.m < 10000) {
                    return;
                }
                this.m = System.currentTimeMillis();
                aVar.a(d, d2);
                p3.b(this.k, 99004);
            }
        }
    }

    public List<v5> a() {
        List<v5> list;
        synchronized (this.g) {
            this.h.clear();
            for (v5 v5Var : this.g) {
                if (System.currentTimeMillis() - v5Var.e() <= 5000) {
                    this.h.add((v5) v5Var.clone());
                }
            }
            this.g.clear();
            list = this.h;
        }
        return list;
    }

    public final void a(ScanResult scanResult) {
        if (scanResult == null) {
            return;
        }
        try {
            BluetoothDevice device = scanResult.getDevice();
            int rssi = scanResult.getRssi();
            byte[] bytes = scanResult.getScanRecord().getBytes();
            if (bytes != null && bytes.length >= 30) {
                a(v5.a(device, rssi, bytes));
            }
        } catch (Throwable th) {
            Log.e("TxBluetoothProvider", "parse scan result failed.", th);
        }
    }

    public final void a(v5 v5Var) {
        synchronized (this.g) {
            if (v5Var != null) {
                this.g.add(v5Var);
            }
        }
    }

    public final byte[] a(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}