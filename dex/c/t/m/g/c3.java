package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;

/* compiled from: TML */
public class c3 {
    public static byte[] a(byte[] bArr) {
        c4.a(bArr);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            w3.a("CompressUtil", "compressGzip failed.", th);
            return v2.a;
        }
    }

    public static boolean a(File file, File file2, boolean z) {
        byte[] a = q2.a().a(2048);
        try {
            long length = file.length();
            File file3 = new File(file.getAbsolutePath() + ".tmp");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file3));
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(a);
                if (read == -1) {
                    break;
                }
                gZIPOutputStream.write(a, 0, read);
            }
            fileInputStream.close();
            gZIPOutputStream.close();
            if (z) {
                file.delete();
            }
            file3.renameTo(file2);
            long length2 = file2.length();
            w3.a("CompressUtil", String.format(Locale.ENGLISH, "compressFileGzip:%s,%d,%s,%d,%.2f", file.getName(), Long.valueOf(length), file2.getName(), Long.valueOf(length2), Double.valueOf(length2 / length)));
            return true;
        } catch (Throwable th) {
            try {
                w3.a("CompressUtil", "compressFileGzip failed:" + file.getName() + "," + file.length() + ".", th);
                return false;
            } finally {
                q2.a().a(a);
            }
        }
    }
}