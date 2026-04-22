package j;

import android.text.TextUtils;
import com.sina.weibo.sdk.web.WebActivity;
import j.b;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements c.b<String> {
    public final /* synthetic */ b.a a;
    public final /* synthetic */ e b;

    public d(e eVar, WebActivity.a aVar) {
        this.b = eVar;
        this.a = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0071, code lost:
        r4.a.d.loadUrl(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Object obj) {
        String str = (String) obj;
        g.c.a("WbShareTag", "handle image result :" + str);
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("code");
                String optString = jSONObject.optString("data");
                boolean z = true;
                if (optInt == 1 && !TextUtils.isEmpty(optString)) {
                    this.b.h = optString;
                    WebActivity.a aVar = this.a;
                    if (aVar != null) {
                        WebActivity.a aVar2 = aVar;
                        String a = aVar2.a.f.a();
                        if (TextUtils.isEmpty(a)) {
                            return;
                        }
                        aVar2.a.getClass();
                        if (TextUtils.isEmpty(a) || (!a.startsWith("https://service.weibo.com/share/mobilesdk.php") && !a.startsWith("https://open.weibo.cn/oauth2/authorize?"))) {
                            z = false;
                        }
                        return;
                    }
                    return;
                }
                WebActivity.a aVar3 = this.a;
                if (aVar3 != null) {
                    aVar3.a.g.a("图片内容不合适，禁止上传！");
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                WebActivity.a aVar4 = this.a;
                if (aVar4 != null) {
                    aVar4.a.g.a("解析服务端返回的字符串时发生异常！");
                    return;
                }
                return;
            }
        }
        WebActivity.a aVar5 = this.a;
        if (aVar5 != null) {
            aVar5.a.g.a("处理图片，服务端返回null!");
        }
    }

    public final void a(Throwable th) {
        WebActivity.a aVar = this.a;
        if (aVar != null) {
            aVar.a.g.a(th.getMessage());
        }
    }
}