package c.t.m.g;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLException;

/* compiled from: TML */
public class q3 {
    public static g2 a;

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface a {
        void a(String str);

        void a(byte[] bArr);
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface b {
        void a(int i, Map<String, Object> map);
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public interface c {
        void a(String str);

        void b(String str);
    }

    public static void a(String str, byte[] bArr, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("tmap-traceid", i4.o());
        if (bArr == null) {
            bArr = v2.a;
        }
        a(str, bArr, 0, hashMap, obj);
    }

    public static byte[] a(String str, Object obj) {
        c cVar = (obj == null || !(obj instanceof c)) ? null : (c) obj;
        a aVar = (obj == null || !(obj instanceof a)) ? null : (a) obj;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            byte[] a2 = a(httpURLConnection.getInputStream());
            if (a2 != null) {
                int length = str.getBytes().length;
                int length2 = a2.length;
            }
            if (aVar != null) {
                aVar.a(a2);
            }
            if (cVar != null) {
                cVar.b(new String(a2, com.alipay.sdk.m.o.a.z));
            }
            httpURLConnection.disconnect();
            return a2;
        } catch (Throwable th) {
            long length3 = str.getBytes().length;
            w3.a("HttpUtil", "getSync error.", th);
            if (aVar != null) {
                aVar.a(th.toString());
            }
            if (cVar != null) {
                cVar.a(th.toString());
            }
            g2 g2Var = a;
            if (g2Var != null) {
                g2Var.a(str, currentTimeMillis, length3, 0L, System.currentTimeMillis() - currentTimeMillis, false);
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(String str, byte[] bArr, int i, HashMap<String, String> hashMap, Object obj) {
        String str2;
        Object obj2;
        String str3;
        boolean z;
        boolean z2;
        long j;
        long j2;
        g2 g2Var;
        long j3;
        long j4;
        boolean z3;
        c cVar = (obj == null || !(obj instanceof c)) ? null : (c) obj;
        a aVar = (obj == null || !(obj instanceof a)) ? null : (a) obj;
        b bVar = (obj == null || !(obj instanceof b)) ? null : (b) obj;
        HashMap hashMap2 = bVar == null ? null : new HashMap();
        long currentTimeMillis = System.currentTimeMillis();
        if (hashMap != null && hashMap.containsKey("tmap-traceid")) {
            str2 = hashMap.get("tmap-traceid");
            if (str2 == null) {
                str2 = "";
            }
        } else {
            str2 = "";
        }
        long j5 = 0;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            if (hashMap != null && hashMap.size() > 0) {
                Iterator<Map.Entry<String, String>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, String> next = it.next();
                    if (next != null) {
                        Iterator<Map.Entry<String, String>> it2 = it;
                        String key = next.getKey();
                        w3.c("HttpUtil", "http setRequestProperty: " + key);
                        httpURLConnection.setRequestProperty(key, next.getValue());
                        it = it2;
                    }
                }
            }
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            long length = bArr.length;
            try {
                httpURLConnection.setFixedLengthStreamingMode(length);
                w3.c("HttpUtil", "start write stream data");
                httpURLConnection.setRequestProperty("Connection", "close");
                a(bArr, httpURLConnection.getOutputStream());
                int responseCode = httpURLConnection.getResponseCode();
                j3 = length;
                try {
                    w3.c("HttpUtil", "response code: " + responseCode);
                    if (responseCode != 200) {
                        String str4 = "net sdk error: " + responseCode;
                        if (cVar != null) {
                            cVar.a(str4);
                        }
                        if (aVar != null) {
                            aVar.a(str4);
                        }
                        if (bVar != null && hashMap2 != null) {
                            hashMap2.put("resp_code", Integer.valueOf(responseCode));
                            hashMap2.put("msg_fail", str4);
                            hashMap2.put("tmap_traceid", str2);
                            bVar.a(0, hashMap2);
                        }
                        httpURLConnection.getInputStream().close();
                        obj2 = "msg_fail";
                        j4 = 4;
                        z3 = false;
                    } else {
                        String a2 = a(httpURLConnection.getHeaderField(com.alipay.sdk.m.l.e.f));
                        byte[] a3 = a(httpURLConnection.getInputStream());
                        if (a3 == null) {
                            obj2 = "msg_fail";
                            j4 = 0;
                        } else {
                            obj2 = "msg_fail";
                            try {
                                j4 = a3.length;
                            } catch (Throwable th) {
                                th = th;
                                j5 = j3;
                                w3.a("HttpUtil", th instanceof UnknownHostException ? "postSync error." + th.getMessage() : "postSync error.", th);
                                if (i < 1) {
                                    str3 = str;
                                } else if ((th instanceof GeneralSecurityException) || (th instanceof SSLException)) {
                                    a(str.replaceAll("https:", "http:"), bArr, i + 1, hashMap, obj);
                                    z = false;
                                    z2 = z;
                                    j = 4;
                                    j2 = j5;
                                    g2Var = a;
                                    if (g2Var == null) {
                                    }
                                } else {
                                    str3 = str;
                                }
                                String str5 = "tryTime=" + i + "," + str3 + "," + w3.a(th);
                                if (cVar != null) {
                                    cVar.a(str5);
                                }
                                if (aVar != null) {
                                    aVar.a(str5);
                                }
                                if (bVar != null || hashMap2 == null) {
                                    z = false;
                                } else {
                                    hashMap2.put(obj2, str5);
                                    hashMap2.put("tmap_traceid", str2);
                                    z = false;
                                    bVar.a(0, hashMap2);
                                }
                                z2 = z;
                                j = 4;
                                j2 = j5;
                                g2Var = a;
                                if (g2Var == null) {
                                }
                            }
                        }
                        w3.c("HttpUtil", "read stream data finish: " + j4);
                        if (aVar != null) {
                            aVar.a(a3);
                        }
                        if (cVar != null) {
                            cVar.b(new String(a3, a2));
                        }
                        if (bVar != null && hashMap2 != null) {
                            hashMap2.put("resp_code", Integer.valueOf(responseCode));
                            hashMap2.put("charset", a2);
                            hashMap2.put("byte_data", a3);
                            hashMap2.put("tmap_traceid", str2);
                            bVar.a(1, hashMap2);
                        }
                        z3 = true;
                    }
                    httpURLConnection.disconnect();
                    z2 = z3;
                    j = j4;
                    j2 = j3;
                } catch (Throwable th2) {
                    th = th2;
                    obj2 = "msg_fail";
                    j5 = j3;
                    w3.a("HttpUtil", th instanceof UnknownHostException ? "postSync error." + th.getMessage() : "postSync error.", th);
                    if (i < 1) {
                    }
                    String str52 = "tryTime=" + i + "," + str3 + "," + w3.a(th);
                    if (cVar != null) {
                    }
                    if (aVar != null) {
                    }
                    if (bVar != null) {
                    }
                    z = false;
                    z2 = z;
                    j = 4;
                    j2 = j5;
                    g2Var = a;
                    if (g2Var == null) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                j3 = length;
            }
        } catch (Throwable th4) {
            th = th4;
            obj2 = "msg_fail";
        }
        g2Var = a;
        if (g2Var == null) {
            g2Var.a(str, currentTimeMillis, j2, j, System.currentTimeMillis() - currentTimeMillis, z2);
        }
    }

    public static void a(byte[] bArr, OutputStream outputStream) throws IOException {
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        byte[] a2 = q2.a().a(512);
        while (true) {
            int read = inputStream.read(a2);
            if (read != -1) {
                byteArrayOutputStream.write(a2, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                inputStream.close();
                q2.a().a(a2);
                return byteArray;
            }
        }
    }

    public static String a(String str) {
        if (str != null) {
            for (String str2 : str.split(com.alipay.sdk.m.q.h.b)) {
                String trim = str2.trim();
                int indexOf = trim.indexOf("charset=");
                if (-1 != indexOf) {
                    return trim.substring(indexOf + 8, trim.length());
                }
            }
        }
        return "GBK";
    }
}