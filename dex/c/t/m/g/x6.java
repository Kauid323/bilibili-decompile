package c.t.m.g;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: TML */
public class x6 {
    public static void a(byte[] bArr, File file, boolean z) throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file, z));
            try {
                bufferedOutputStream2.write(bArr);
                bufferedOutputStream2.flush();
                i7.a(bufferedOutputStream2);
            } catch (IOException e) {
                e = e;
                bufferedOutputStream = bufferedOutputStream2;
                try {
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    i7.a(bufferedOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = bufferedOutputStream2;
                i7.a(bufferedOutputStream);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static void a(byte[] bArr, File file) throws IOException {
        a(bArr, file, true);
    }
}