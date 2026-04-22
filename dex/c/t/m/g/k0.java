package c.t.m.g;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.DeflaterOutputStream;

/* compiled from: TML */
public class k0 {
    public static boolean f = false;
    public static k0 g;
    public boolean a;
    public final File b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f52c;
    public HandlerThread d;
    public boolean e = false;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class b extends Handler {
        public File a;

        public /* synthetic */ b(k0 k0Var, Looper looper, a aVar) {
            this(looper);
        }

        public final File a() {
            File file = k0.this.b;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "dexlog");
        }

        /* JADX WARN: Removed duplicated region for block: B:45:0x00a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            BufferedOutputStream bufferedOutputStream;
            super.handleMessage(message);
            File file = this.a;
            if (file == null || !"dexlog".equals(file.getName())) {
                this.a = a();
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.a, true));
                    try {
                        if (k0.this.e) {
                            bufferedOutputStream.write(k0.b(message.obj.toString().getBytes("GBK")));
                        } else {
                            bufferedOutputStream.write(message.obj.toString().getBytes("GBK"));
                        }
                        bufferedOutputStream.flush();
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException e) {
                        }
                        File file2 = k0.this.b;
                        File file3 = this.a;
                        if (file2 == null || file3 == null) {
                            return;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        if (file3.length() > 409600) {
                            file3.renameTo(new File(file2, "dexlog_" + currentTimeMillis));
                        }
                    } catch (IOException e2) {
                        this.a = null;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e3) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream2 = "dexlog";
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
        }

        public b(Looper looper) {
            super(looper);
            this.a = a();
        }
    }

    public k0(Context context, File file) {
        boolean z = false;
        this.b = file;
        if (file != null && (file.exists() || file.mkdirs())) {
            z = true;
        }
        this.a = z;
        if (z) {
            HandlerThread handlerThread = new HandlerThread("log_worker", 10);
            this.d = handlerThread;
            handlerThread.start();
            this.f52c = new b(this, this.d.getLooper(), null);
        }
        if (f) {
            Log.i("TencentLogImpl", "log dir=" + this.b);
            if (this.a) {
                return;
            }
            Log.e("TencentLogImpl", "init failed: mPrepared=" + this.a);
        }
    }

    public static byte[] c(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i = (length % 5) + 7;
        int i2 = 0;
        while (true) {
            int i3 = (i << 1) + i2;
            if (i3 >= length) {
                return bArr2;
            }
            byte byteValue = Integer.valueOf(i2).byteValue();
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i2 + i4;
                byte b2 = bArr2[i5];
                int i6 = i2 + i + i4;
                bArr2[i5] = (byte) (bArr2[i6] ^ byteValue);
                bArr2[i6] = (byte) (b2 ^ byteValue);
            }
            i2 = i3;
        }
    }

    public static k0 a(Context context, File file) {
        if (g == null) {
            synchronized (k0.class) {
                if (g == null) {
                    g = new k0(context, file);
                }
            }
        }
        return g;
    }

    public static k0 b() {
        return g;
    }

    public static byte[] b(byte[] bArr) {
        byte[] c2 = c(a(bArr));
        byte[] bArr2 = new byte[c2.length + 4];
        int length = c2.length;
        bArr2[0] = Integer.valueOf(length >> 8).byteValue();
        bArr2[1] = Integer.valueOf(length >> 24).byteValue();
        bArr2[2] = Integer.valueOf(length >> 16).byteValue();
        bArr2[3] = Integer.valueOf(length).byteValue();
        System.arraycopy(c2, 0, bArr2, 4, length);
        return bArr2;
    }

    public final boolean a() {
        return this.a && this.f52c != null;
    }

    public void a(String str, int i, String str2) {
        if (a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            sb.append(":").append(str);
            sb.append(":").append(str2).append(XMPRDFWriter.XMP_DEFAULT_NEWLINE);
            p3.b(this.f52c, 1, 0, 0, sb.toString());
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr, 0, bArr.length);
            deflaterOutputStream.finish();
            deflaterOutputStream.flush();
            deflaterOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}