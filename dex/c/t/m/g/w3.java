package c.t.m.g;

import android.util.Log;
import com.ashampoo.kim.format.jpeg.iptc.IptcConstants;
import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: TML */
public class w3 {
    public static final boolean a() {
        return b2.d() || b2.c() != null;
    }

    public static void b(String str, String str2) {
        a(6, str, str2, (Throwable) null);
    }

    public static void c(String str, String str2) {
        a(4, str, str2, (Throwable) null);
    }

    public static void d(String str, String str2) {
        a((int) IptcConstants.IMAGE_RESOURCE_BLOCK_ALPHA_CHANNELS_NAMES, str, str2);
    }

    public static void e(String str, String str2) {
        a(1004, str, str2);
    }

    public static void a(String str, String str2) {
        a(3, str, str2, (Throwable) null);
    }

    public static void a(String str, String str2, Throwable th) {
        try {
            a(6, str, str2, th);
        } catch (Throwable th2) {
            if ((th2 instanceof OutOfMemoryError) || !a()) {
                return;
            }
            a("LogUtil", "", th2);
        }
    }

    public static void a(int i, String str, String str2, Throwable th) {
        a(str, i, str2, th);
        if (b2.c() != null) {
            b2.c().a(i, str, str2, th);
        }
    }

    public static void a(String str, int i, String str2, Throwable th) {
        if (b2.d()) {
            if (th != null) {
                str2 = str2 + ". exception: " + Log.getStackTraceString(th);
            }
            Log.println(i, str, str2);
        }
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "no crash";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "no crash";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        return stringWriter2.contains(XMPRDFWriter.XMP_DEFAULT_NEWLINE) ? stringWriter2.replaceAll(XMPRDFWriter.XMP_DEFAULT_NEWLINE, "") : stringWriter2;
    }

    public static void a(int i, String str, String str2) {
        a(str, 3, str2, (Throwable) null);
        if (b2.b() != null) {
            b2.b().a(i, str, str2);
        }
    }
}