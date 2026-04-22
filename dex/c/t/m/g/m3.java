package c.t.m.g;

import android.content.Context;
import android.os.Environment;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: TML */
public class m3 {
    public static File a;

    @Deprecated
    public static void a(Closeable closeable) {
        r3.a(closeable);
    }

    public static byte[] a(File file) {
        BufferedInputStream bufferedInputStream;
        if (file.exists() && file.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] a2 = q2.a().a(2048);
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(a2);
                        if (read != -1) {
                            byteArrayOutputStream.write(a2, 0, read);
                        } else {
                            return byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            w3.a("FileUtil", "toByteArray error.", th);
                            return v2.a;
                        } finally {
                            q2.a().a(a2);
                            r3.a(bufferedInputStream);
                            r3.a(byteArrayOutputStream);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
            }
        } else {
            return v2.a;
        }
    }

    public static boolean a(File file, byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z);
            try {
                fileOutputStream.write(bArr);
                r3.a(fileOutputStream);
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    w3.a("FileUtil", "byteArrayToFile error.", th);
                    r3.a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    r3.a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static File a(Context context, String str) {
        if (a != null) {
            return a;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalFilesDir = context.getExternalFilesDir(str);
            a = externalFilesDir;
            return externalFilesDir;
        }
        File filesDir = context.getApplicationContext().getFilesDir();
        a = filesDir;
        return filesDir;
    }
}