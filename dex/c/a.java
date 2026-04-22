package c;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public final class a {
    public static d a(c cVar) {
        InputStream errorStream;
        String str = cVar.a;
        Bundle bundle = cVar.b;
        if (bundle != null && bundle.size() != 0 && !TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            if (!bundle.isEmpty()) {
                Uri.Builder buildUpon = parse.buildUpon();
                for (String str2 : bundle.keySet()) {
                    buildUpon.appendQueryParameter(str2, String.valueOf(bundle.get(str2)));
                }
                parse = buildUpon.build();
            }
            if (parse != null) {
                str = parse.toString();
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Charset", com.alipay.sdk.m.o.a.z);
                Bundle bundle2 = new Bundle();
                bundle2.putString("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection, bundle2);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setReadTimeout(cVar.g);
                httpURLConnection.setConnectTimeout(cVar.f);
                httpURLConnection.connect();
                a(httpURLConnection.getOutputStream(), cVar);
                if (httpURLConnection.getResponseCode() == 200) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                d dVar = new d(errorStream);
                httpURLConnection.disconnect();
                return dVar;
            } catch (Exception e) {
                throw new Throwable(e.getMessage());
            }
        } catch (Throwable th) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    public static void a(OutputStream outputStream, c cVar) {
        Bundle bundle = cVar.f0c;
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(com.alipay.sdk.m.o.a.l);
            }
            try {
                sb.append(URLEncoder.encode(str, com.alipay.sdk.m.o.a.z)).append("=").append(URLEncoder.encode(String.valueOf(bundle.get(str)), com.alipay.sdk.m.o.a.z));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.write(sb.toString().getBytes(com.alipay.sdk.m.o.a.z));
            dataOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        for (String str : bundle.keySet()) {
            httpURLConnection.addRequestProperty(str, String.valueOf(bundle.get(str)));
        }
    }
}