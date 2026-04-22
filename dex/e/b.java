package e;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import g.a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public final class b {
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
        if (r4 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c8, code lost:
        if (r4 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ca, code lost:
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d1, code lost:
        if (android.text.TextUtils.isEmpty(r0) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d3, code lost:
        r0 = new java.lang.StringBuilder().append(java.util.Calendar.getInstance().getTimeInMillis());
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e4, code lost:
        if (r12 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e6, code lost:
        r12 = "_sdk_temp.mp4";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e9, code lost:
        r12 = "_sdk_temp.jpg";
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
        r0 = r0.append(r12).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f3, code lost:
        r11 = new java.io.BufferedInputStream(new java.io.FileInputStream(r10.getContentResolver().openFileDescriptor(r11, "r").getFileDescriptor()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x010c, code lost:
        r10 = new java.io.File(android.os.Environment.getExternalStorageDirectory().getAbsolutePath() + r3 + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0132, code lost:
        if (r10.exists() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0134, code lost:
        r10.delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0137, code lost:
        r12 = new java.io.FileOutputStream(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x013e, code lost:
        r0 = new byte[1444];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0140, code lost:
        r2 = r11.read(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0145, code lost:
        if (r2 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0147, code lost:
        r12.write(r0, 0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014c, code lost:
        r10 = r10.getPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0150, code lost:
        r11.close();
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0157, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0158, code lost:
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015c, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015d, code lost:
        r2 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015f, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0161, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0163, code lost:
        r10 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0164, code lost:
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0165, code lost:
        r2 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0173, code lost:
        g.c.b("WBShareTag", "share util and error is " + r10.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0193, code lost:
        throw new java.lang.Throwable(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0194, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0199, code lost:
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019d, code lost:
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a1, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a5, code lost:
        r11.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01a1 A[Catch: Exception -> 0x019d, TRY_LEAVE, TryCatch #8 {Exception -> 0x019d, blocks: (B:77:0x0199, B:81:0x01a1), top: B:90:0x0199 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v9, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri, int i2) {
        FileOutputStream fileOutputStream;
        Calendar calendar;
        Cursor cursor;
        String str;
        String path;
        FileOutputStream fileOutputStream2 = null;
        try {
            a.C0022a a = g.a.a(context);
            String str2 = "";
            if (a != null) {
                str2 = a.a;
            }
            boolean isEmpty = TextUtils.isEmpty(str2);
            ?? r4 = str2;
            if (isEmpty) {
                r4 = "com.sina.weibo";
            }
            try {
                String str3 = "/Android/data/" + ((String) r4) + "/files/.composerTem/";
                new File(Environment.getExternalStorageDirectory().getAbsolutePath() + str3).mkdirs();
                calendar = Calendar.getInstance();
            } catch (Throwable th) {
                th = th;
            }
            try {
                if ("file".equals(uri.getScheme())) {
                    str = calendar.getTimeInMillis() + uri.getLastPathSegment();
                    cursor = null;
                } else {
                    cursor = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                str = cursor.getString(cursor.getColumnIndex("_display_name"));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            g.c.b("WBShareTag", "share util and exception is " + e.getMessage());
                            e.printStackTrace();
                            str = null;
                        }
                    }
                    str = null;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                r4 = 0;
                if (r4 != 0) {
                    r4.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            ?? r11 = fileOutputStream2;
            fileOutputStream2 = fileOutputStream;
            if (r11 != 0) {
            }
            if (fileOutputStream2 != null) {
            }
            throw th;
        }
        return path;
    }
}