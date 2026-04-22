package f;

import android.os.Bundle;
import c.c;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class f extends c<Void, Void, String> {

    /* renamed from: e  reason: collision with root package name */
    public c.b<String> f1901e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f1902f;

    /* renamed from: g  reason: collision with root package name */
    public String f1903g;

    /* renamed from: h  reason: collision with root package name */
    public Oauth2AccessToken f1904h;

    public f(String str, Oauth2AccessToken oauth2AccessToken, AccessTokenHelper.a aVar) {
        this.f1903g = str;
        this.f1904h = oauth2AccessToken;
        this.f1901e = aVar;
    }

    @Override // f.c
    public final void a(String str) {
        String str2 = str;
        Throwable th = this.f1902f;
        if (th != null) {
            c.b<String> bVar = this.f1901e;
            if (bVar != null) {
                bVar.a(th);
                return;
            }
            return;
        }
        c.b<String> bVar2 = this.f1901e;
        if (bVar2 != null) {
            bVar2.a(str2);
        }
    }

    @Override // f.c
    public final String a() {
        try {
            c.a aVar = new c.a();
            aVar.a = "https://api.weibo.com/oauth2/access_token";
            String str = this.f1903g;
            Bundle bundle = aVar.c;
            if (str != null) {
                bundle.putString("client_id", str);
            }
            String str2 = this.f1903g;
            Bundle bundle2 = aVar.c;
            if (str2 != null) {
                bundle2.putString("appKey", str2);
            }
            aVar.c.putString("grant_type", "refresh_token");
            String refreshToken = this.f1904h.getRefreshToken();
            Bundle bundle3 = aVar.c;
            if (refreshToken != null) {
                bundle3.putString("refresh_token", refreshToken);
            }
            c.d a = c.a.a(new c.c(aVar));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = a.a.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        byteArrayOutputStream.close();
                        return byteArrayOutputStream2;
                    }
                }
            } catch (IOException e2) {
                throw e2;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.f1902f = th;
            return null;
        }
    }
}