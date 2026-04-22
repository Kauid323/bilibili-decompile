package b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b.b;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.WebActivity;
import com.sina.weibo.sdk.web.WebData;
import g.a;
import g.c;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public final class a {
    public WbAuthListener a;

    public final void a(Activity activity) {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            a.a a = g.a.a(activity);
            Intent intent = new Intent();
            if (a == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(a.a, a.b);
            }
            if (a.a.a) {
                AuthInfo authInfo = a.a.b;
                intent.putExtra("appKey", authInfo.getAppKey());
                intent.putExtra("redirectUri", authInfo.getRedirectUrl());
                intent.putExtra("scope", authInfo.getScope());
                intent.putExtra("packagename", authInfo.getPackageName());
                intent.putExtra("key_hash", authInfo.getHash());
                intent.putExtra("_weibo_command_type", 3);
                intent.putExtra("_weibo_transaction", System.currentTimeMillis() + "");
                if (activity == null) {
                    this.a.onError(new UiError(-1, "activity is null", ""));
                    return;
                } else if (g.a.a(activity, intent)) {
                    activity.startActivityForResult(intent, 32973);
                    c.a("WBSsoTag", "start SsoActivity ");
                    return;
                } else {
                    this.a.onError(new UiError(-2, "your app is illegal", ""));
                    return;
                }
            }
            throw new RuntimeException("please init sdk before use it. Wb.install()");
        } catch (Exception e) {
            e.printStackTrace();
            c.b("WBSsoTag", e.getMessage());
            this.a.onError(new UiError(-3, "occur exception", e.getMessage()));
        }
    }

    public final void b(Activity activity) {
        b bVar;
        HashMap hashMap = new HashMap();
        if (a.a.a) {
            AuthInfo authInfo = a.a.b;
            if (authInfo == null) {
                return;
            }
            hashMap.put("client_id", authInfo.getAppKey());
            hashMap.put("redirect_uri", authInfo.getRedirectUrl());
            hashMap.put("scope", authInfo.getScope());
            hashMap.put("packagename", authInfo.getPackageName());
            hashMap.put("key_hash", authInfo.getHash());
            hashMap.put("response_type", "code");
            hashMap.put("version", "0041005000");
            hashMap.put("luicode", "10000360");
            hashMap.put("lfid", "OP_" + authInfo.getAppKey());
            Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
            if (readAccessToken != null) {
                String accessToken = readAccessToken.getAccessToken();
                if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                    hashMap.put("trans_token", accessToken);
                    hashMap.put("trans_access_token", accessToken);
                }
            }
            StringBuilder append = new StringBuilder().append("https://open.weibo.cn/oauth2/authorize?");
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str : hashMap.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                String str2 = (String) hashMap.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        sb.append(URLEncoder.encode(str, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
            String sb2 = append.append(sb.toString()).toString();
            if (this.a != null) {
                synchronized (b.class) {
                    bVar = b.a.a;
                }
                bVar.getClass();
                String str3 = System.currentTimeMillis() + "";
                WbAuthListener wbAuthListener = this.a;
                synchronized (bVar) {
                    if (!TextUtils.isEmpty(str3) && wbAuthListener != null) {
                        bVar.a.put(str3, wbAuthListener);
                    }
                }
                Intent intent = new Intent(activity, WebActivity.class);
                WebData webData = new WebData(authInfo, 2, sb2, str3);
                String str4 = System.currentTimeMillis() + "";
                Bundle bundle = new Bundle();
                bundle.putParcelable("web_data", webData);
                int i = webData.b;
                if (i == 1) {
                    bundle.putInt("web_type", 1);
                } else if (i == 2) {
                    bundle.putInt("web_type", 2);
                } else if (i == 3) {
                    bundle.putInt("web_type", 3);
                }
                bundle.putString("_weibo_transaction", str4);
                intent.putExtras(bundle);
                activity.startActivity(intent);
                return;
            }
            return;
        }
        throw new RuntimeException("please init sdk before use it. Wb.install()");
    }
}