package c.t.m.g;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import c.t.m.g.q3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: TML */
public class l5 implements h6 {

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public class a implements q3.c {
        public final /* synthetic */ String[] a;

        public a(l5 l5Var, String[] strArr) {
            this.a = strArr;
        }

        @Override // c.t.m.g.q3.c
        public void a(String str) {
            a7.c("TxNewHttpClient", "NationCode, onFailed: " + str);
        }

        @Override // c.t.m.g.q3.c
        public void b(String str) {
            this.a[0] = str;
            a7.c("TxNewHttpClient", "NationCode, onSuccessed: " + this.a[0]);
        }
    }

    /* compiled from: TML */
    /* loaded from: /data/np/file-convert/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780/2026022807191929f2e8d3-def5-46d4-a9fe-584a69126780.dex */
    public static class b {
        public byte[] b;
        public String a = "gbk";

        /* renamed from: c  reason: collision with root package name */
        public String f59c = "";
    }

    public l5(Context context, String str) {
    }

    public static b b(String str, byte[] bArr) {
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestProperty("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4; Nexus 5 Build/KRT16M)");
            httpURLConnection.setRequestProperty("Content-Type", "application/octet-stream");
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.setRequestProperty("Connection", "close");
            a(bArr, httpURLConnection.getOutputStream());
            int responseCode = httpURLConnection.getResponseCode();
            a7.c("TxNewHttpClient", "urlStr: " + url + ", retCode : " + responseCode);
            if (responseCode != 200) {
                httpURLConnection.disconnect();
                return null;
            }
            b bVar = new b();
            String headerField = httpURLConnection.getHeaderField(com.alipay.sdk.m.l.e.f);
            String headerField2 = httpURLConnection.getHeaderField("x-android-sent-millis");
            String b2 = b(headerField);
            byte[] a2 = a(httpURLConnection.getInputStream());
            bVar.a = b2;
            bVar.b = a2;
            bVar.f59c = headerField2;
            return bVar;
        } catch (Throwable th) {
            a7.a("TxNewHttpClient", "postSyncOwn error", th);
            return null;
        }
    }

    @Override // c.t.m.g.h6
    public Bundle a(String str, byte[] bArr) throws IOException {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            b b2 = b(str, bArr);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (b2 != null) {
                x3.a("NET", "0,0,null," + currentTimeMillis2 + "," + a4.a());
                Bundle bundle = new Bundle();
                bundle.putString("req_key", "");
                String str2 = b2.f59c;
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putLong("data_header_time", Long.parseLong(str2));
                }
                if (b2.b == null) {
                    bundle.putByteArray("data_bytes", "{}".getBytes(com.alipay.sdk.m.o.a.z));
                    bundle.putString("data_charset", "utf-8");
                    return bundle;
                }
                String str3 = b2.a;
                bundle.putByteArray("data_bytes", b2.b);
                bundle.putString("data_charset", str3);
                return bundle;
            }
            throw new IOException("net sdk error: response is null");
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // c.t.m.g.h6
    public String a(String str) {
        try {
            String[] strArr = {null};
            a7.c("TxNewHttpClient", "NationCode, url: " + str);
            q3.a(str, new a(this, strArr));
            if (strArr[0] != null) {
                return strArr[0];
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static String b(String str) {
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
                inputStream.close();
                q2.a().a(a2);
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}