package c.t.m.g;

import com.ashampoo.xmp.internal.XMPRDFWriter;
import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: TML */
public class n0 {
    public static void a(String str, String str2) {
        w3.a(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        w3.a(str, str2, th);
    }

    public static String a(Throwable th) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            printWriter.close();
            stringBuffer.append(stringWriter.toString());
            return stringBuffer.toString().replaceAll(XMPRDFWriter.XMP_DEFAULT_NEWLINE, "$");
        } catch (Throwable th2) {
            return "";
        }
    }
}