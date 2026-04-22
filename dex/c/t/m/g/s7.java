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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: TML */
public class s7 {
    public static s7 e = null;
    public static boolean f = false;
    public final File a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f96c;
    public HandlerThread d;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class b extends Handler {
        public File a;

        public /* synthetic */ b(s7 s7Var, Looper looper, a aVar) {
            this(looper);
        }

        public final File a() {
            File file = s7.this.a;
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "dexlog");
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            File file = this.a;
            if (file == null || !"dexlog".equals(file.getName())) {
                this.a = a();
            }
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.a, true));
                bufferedOutputStream.write(message.obj.toString().getBytes("GBK"));
                bufferedOutputStream.flush();
            } catch (IOException e) {
                this.a = null;
            }
        }

        public b(Looper looper) {
            super(looper);
            this.a = a();
        }
    }

    public s7(Context context, File file) {
        this.a = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.b = z;
        if (z) {
            HandlerThread handlerThread = new HandlerThread("log_worker", 10);
            this.d = handlerThread;
            handlerThread.start();
            this.f96c = new b(this, this.d.getLooper(), null);
        }
        if (f) {
            Log.i("TencentLogImpl", "log dir=" + this.a);
            if (this.b) {
                return;
            }
            Log.e("TencentLogImpl", "init failed: mPrepared=" + this.b);
        }
    }

    public final boolean b() {
        return this.b && this.f96c != null;
    }

    public static s7 a(Context context, File file) {
        if (e == null) {
            synchronized (s7.class) {
                if (e == null) {
                    e = new s7(context, file);
                }
            }
        }
        return e;
    }

    public static s7 a() {
        return e;
    }

    public void a(String str, int i, String str2) {
        if (b()) {
            StringBuilder sb = new StringBuilder();
            sb.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            sb.append(":").append(str);
            sb.append(":").append(str2).append(XMPRDFWriter.XMP_DEFAULT_NEWLINE);
            this.f96c.obtainMessage(1, sb.toString()).sendToTarget();
        }
    }
}