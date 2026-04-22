package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: TML */
public class w1 {
    public byte[] a;
    public File b;

    /* renamed from: c  reason: collision with root package name */
    public FileOutputStream f113c;
    public BufferedOutputStream d;
    public StringBuilder e;
    public x1 f;
    public String g;
    public int h;
    public boolean i;
    public long j;
    public String k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                c3.a(new File(this.a), new File(this.a.substring(0, this.a.length() - w1.this.k.length()) + ".gzip"), true);
            } catch (Throwable th) {
            }
        }
    }

    public w1(File file) throws IOException {
        this(file, 5120);
    }

    public File b() {
        File file;
        synchronized (this.a) {
            file = this.b;
        }
        return file;
    }

    public final void c() {
        File file = new File(this.g + "_" + this.n + this.k);
        while (file.exists()) {
            this.n++;
            file = new File(this.g + "_" + this.n + this.k);
        }
        boolean renameTo = this.b.renameTo(file);
        if (w3.a()) {
            w3.a("FileWriterWrapper", "rename " + this.b.getName() + " to " + file.getName() + ": " + renameTo);
        }
        String absolutePath = file.getAbsolutePath();
        if (this.m && !d4.a(absolutePath)) {
            if (w3.a()) {
                w3.a("FileWriterWrapper", "compress file: " + absolutePath);
            }
            new Thread(new a(absolutePath), "th_loc_tmp").start();
        }
        this.n++;
    }

    public w1(File file, int i) throws IOException {
        this.a = new byte[0];
        this.g = "";
        this.h = 0;
        this.i = false;
        this.j = Long.MAX_VALUE;
        this.k = "";
        this.l = false;
        this.m = false;
        this.n = 1;
        this.o = 0;
        a(file, i);
    }

    public final void a(File file, int i) throws IOException {
        this.b = file;
        File parentFile = file == null ? null : file.getParentFile();
        if ((parentFile == null || !parentFile.exists()) && !parentFile.mkdirs()) {
            return;
        }
        this.g = file.getAbsolutePath();
        this.h = i;
        if (w3.a()) {
            w3.a("FileWriterWrapper", "create file:" + file.getAbsolutePath() + ",bufSize:" + i);
        }
        this.e = new StringBuilder(i);
        this.f113c = new FileOutputStream(file, true);
        this.d = new BufferedOutputStream(this.f113c, 5120);
    }

    public void a(String str) throws IOException {
        synchronized (this.a) {
            if (this.e != null) {
                this.e.append(str);
                if (this.e.length() >= this.h) {
                    a(this.e.toString().getBytes(com.alipay.sdk.m.o.a.z));
                    this.e.setLength(0);
                }
            }
        }
    }

    public void a(byte[] bArr) throws IOException {
        synchronized (this.a) {
            if (this.d == null) {
                return;
            }
            this.d.write(this.f == null ? bArr : this.f.a(bArr));
            if (this.i) {
                int length = this.o + bArr.length;
                this.o = length;
                if (length >= 5120) {
                    this.o = 0;
                    File b = b();
                    if ((b == null ? 0L : b.length()) >= this.j) {
                        this.d.close();
                        this.f113c.close();
                        c();
                        a(new File(this.g), this.h);
                    }
                }
            }
        }
    }

    public void a() throws IOException {
        synchronized (this.a) {
            if (this.d == null) {
                return;
            }
            a(this.e.toString().getBytes(com.alipay.sdk.m.o.a.z));
            this.e.setLength(0);
            if (w3.a()) {
                w3.a("FileWriterWrapper", this.b.getAbsolutePath() + " close(). length=" + this.b.length());
            }
            this.d.close();
            this.f113c.close();
            if (this.i && this.l) {
                c();
            }
            this.n = 1;
            this.d = null;
            this.f113c = null;
        }
    }

    public void a(x1 x1Var) {
        synchronized (this.a) {
            this.f = x1Var;
        }
    }
}