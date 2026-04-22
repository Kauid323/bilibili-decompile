package c.t.m.g;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.io.File;
import java.io.IOException;

/* compiled from: TML */
public final class i6 {
    public static boolean e = false;
    public static boolean f = true;
    public boolean a;
    public final File b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f46c;
    public HandlerThread d;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public final class b extends Handler {
        public File a;

        public /* synthetic */ b(i6 i6Var, Looper looper, a aVar) {
            this(looper);
        }

        public final File a() {
            File file = i6.this.b;
            if (!file.exists()) {
                boolean mkdirs = file.mkdirs();
                if (i6.e) {
                    Log.e("TencentLogImpl", "mkdirs result: " + mkdirs);
                }
            }
            File file2 = new File(file, "txwatchdog");
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file2;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (i6.this.d == null || !i6.this.d.isAlive()) {
                return;
            }
            if (i6.e) {
                Log.e("TencentLogImpl", "write log");
            }
            File file = this.a;
            if (file == null) {
                if (i6.e) {
                    Log.e("TencentLogImpl", "mDest = null");
                    return;
                }
                return;
            }
            if (!file.exists() || !"txwatchdog".equals(this.a.getName())) {
                if (i6.e) {
                    Log.e("TencentLogImpl", "mDest not exists");
                }
                this.a = a();
                if (i6.e) {
                    Log.e("TencentLogImpl", "mDest = " + this.a.getName());
                }
            }
            try {
                if (i6.f) {
                    x6.a(g7.a(message.obj.toString().getBytes("GBK")), this.a);
                } else {
                    x6.a(message.obj.toString().getBytes("GBK"), this.a);
                }
                if (i6.e) {
                    Log.e("TencentLogImpl", "Files.append");
                }
                if (i6.e) {
                    Log.e("TencentLogImpl", "mDest = " + this.a.getAbsolutePath());
                }
                File file2 = i6.this.b;
                File file3 = this.a;
                if (file2 == null || file3 == null) {
                    if (i6.e) {
                        Log.e("TencentLogImpl", "handleMessage: dir == null || dest == null");
                    }
                } else if (file3.length() > 52428800) {
                    file3.renameTo(new File(file2, "txwatchdog_" + f3.a("yyyyMMdd")));
                }
            } catch (IOException e) {
                this.a = null;
                if (i6.e) {
                    Log.e("TencentLogImpl", "handleMessage: " + e.getMessage());
                }
            }
        }

        public b(Looper looper) {
            super(looper);
            this.a = a();
        }
    }

    public i6(Context context, File file) {
        if (file != null && e) {
            Log.i("TencentLogImpl", "TencentLogImpl init dir: " + file.getAbsolutePath());
        }
        this.b = file;
        boolean z = file != null && (file.exists() || file.mkdirs());
        this.a = z;
        if (z) {
            HandlerThread handlerThread = new HandlerThread("log_worker", 10);
            this.d = handlerThread;
            handlerThread.start();
            this.f46c = new b(this, this.d.getLooper(), null);
        } else if (e) {
            Log.e("TencentLogImpl", "mPrepared: " + this.a);
        }
        if (e) {
            Log.i("TencentLogImpl", "log dir=" + this.b);
            if (this.a) {
                return;
            }
            Log.e("TencentLogImpl", "init failed: mPrepared=" + this.a);
        }
    }

    public static boolean d() {
        return e;
    }

    public final boolean a() {
        return this.a && this.f46c != null;
    }

    public void a(String str, int i, String str2) {
        if (a()) {
            StringBuilder sb = new StringBuilder();
            sb.append(DateFormat.format("yyyy-MM-dd kk:mm:ss", System.currentTimeMillis()));
            sb.append(":").append(str);
            sb.append(":").append(str2).append(XMPRDFWriter.XMP_DEFAULT_NEWLINE);
            this.f46c.obtainMessage(1, sb.toString()).sendToTarget();
        } else if (e) {
            Log.e("TencentLogImpl", "unprepared");
        }
        if (e) {
            if (i == 4) {
                Log.i(str, str2);
            } else {
                Log.e(str, str2);
            }
        }
    }
}