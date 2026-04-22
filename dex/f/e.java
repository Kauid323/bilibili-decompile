package f;

import android.content.Context;
import android.os.Bundle;
import c.c;
import com.sina.weibo.sdk.net.HttpManager;
import com.tencent.open.SocialConstants;
import io.ktor.http.auth.HttpAuthHeader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class e extends c<Void, Void, String> {

    /* renamed from: e  reason: collision with root package name */
    public Context f1896e;

    /* renamed from: f  reason: collision with root package name */
    public c.b<String> f1897f;

    /* renamed from: g  reason: collision with root package name */
    public Throwable f1898g;

    /* renamed from: h  reason: collision with root package name */
    public String f1899h;

    /* renamed from: i  reason: collision with root package name */
    public String f1900i;
    public String j;

    public e(Context context, String str, String str2, String str3, j.d dVar) {
        this.f1896e = context;
        this.f1899h = str;
        this.f1900i = str2;
        this.j = str3;
        this.f1897f = dVar;
    }

    @Override // f.c
    public final void a(String str) {
        String str2 = str;
        Throwable th = this.f1898g;
        if (th != null) {
            c.b<String> bVar = this.f1897f;
            if (bVar != null) {
                bVar.a(th);
                return;
            }
            return;
        }
        c.b<String> bVar2 = this.f1897f;
        if (bVar2 != null) {
            bVar2.a(str2);
        }
    }

    @Override // f.c
    public final String a() {
        try {
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            c.a aVar = new c.a();
            aVar.a = "https://service.weibo.com/share/mobilesdk_uppic.php";
            Bundle bundle = aVar.b;
            if (valueOf != null) {
                bundle.putString(HttpAuthHeader.Parameters.OAuthTimestamp, valueOf);
            }
            String a = HttpManager.a(this.f1896e, this.j, this.f1900i, valueOf);
            Bundle bundle2 = aVar.b;
            if (a != null) {
                bundle2.putString("oauth_sign", a);
            }
            String str = this.f1900i;
            Bundle bundle3 = aVar.c;
            if (str != null) {
                bundle3.putString("appKey", str);
            }
            Bundle bundle4 = aVar.c;
            if (valueOf != null) {
                bundle4.putString(HttpAuthHeader.Parameters.OAuthTimestamp, valueOf);
            }
            String a2 = HttpManager.a(this.f1896e, this.j, this.f1900i, valueOf);
            Bundle bundle5 = aVar.c;
            if (a2 != null) {
                bundle5.putString("oauth_sign", a2);
            }
            String str2 = this.f1899h;
            Bundle bundle6 = aVar.c;
            if (str2 != null) {
                bundle6.putString(SocialConstants.PARAM_IMG_URL, str2);
            }
            c.d a3 = c.a.a(new c.c(aVar));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = a3.a.read(bArr);
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
            this.f1898g = th;
            return null;
        }
    }
}