package d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.web.WebData;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.tauth.Tencent;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import e.f;
import g.a;
import g.c;

public final class a implements IWBAPI {
    public Context a;
    public b.a b = new b.a();
    public f c = new f();

    public a(Context context) {
        this.a = context;
    }

    public final void authorize(Activity activity, WbAuthListener wbAuthListener) {
        b.a aVar = this.b;
        aVar.getClass();
        c.a("WBSsoTag", "authorize()");
        if (wbAuthListener != null) {
            aVar.a = wbAuthListener;
            if (a.a.b(activity)) {
                if (g.a.a(activity) != null) {
                    aVar.a(activity);
                    return;
                }
            }
            aVar.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    public final void authorizeCallback(Activity activity, int i2, int i3, Intent intent) {
        b.a aVar = this.b;
        aVar.getClass();
        c.a("WBSsoTag", "authorizeCallback()");
        WbAuthListener wbAuthListener = aVar.a;
        if (wbAuthListener == null) {
            return;
        }
        if (32973 != i2) {
            wbAuthListener.onError(new UiError(-7, "request code is error", "requestCode is error"));
        } else if (i3 != -1) {
            if (i3 == 0) {
                wbAuthListener.onCancel();
            } else {
                wbAuthListener.onError(new UiError(-6, "result code is error", "result code is error"));
            }
        } else if (intent == null) {
        } else {
            String stringExtra = intent.getStringExtra("error");
            String stringExtra2 = intent.getStringExtra(PushMessageHelper.ERROR_TYPE);
            String stringExtra3 = intent.getStringExtra("error_description");
            if (TextUtils.isEmpty(stringExtra) && TextUtils.isEmpty(stringExtra2) && TextUtils.isEmpty(stringExtra3)) {
                Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                if (parseAccessToken != null) {
                    AccessTokenHelper.writeAccessToken(activity, parseAccessToken);
                    aVar.a.onComplete(parseAccessToken);
                    return;
                }
                aVar.a.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
            } else if (!"access_denied".equals(stringExtra) && !"OAuthAccessDeniedException".equals(stringExtra)) {
                aVar.a.onError(new UiError(-5, stringExtra2, stringExtra3));
            } else {
                aVar.a.onCancel();
            }
        }
    }

    public final void authorizeClient(Activity activity, WbAuthListener wbAuthListener) {
        b.a aVar = this.b;
        aVar.getClass();
        c.a("WBSsoTag", "authorizeClient()");
        if (wbAuthListener != null) {
            aVar.a = wbAuthListener;
            aVar.a(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    public final void authorizeWeb(Activity activity, WbAuthListener wbAuthListener) {
        b.a aVar = this.b;
        aVar.getClass();
        c.a("WBSsoTag", "authorizeWeb()");
        if (wbAuthListener != null) {
            aVar.a = wbAuthListener;
            aVar.b(activity);
            return;
        }
        throw new RuntimeException("listener can not be null.");
    }

    public final void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        Bundle extras;
        this.c.getClass();
        if (intent == null || wbShareCallback == null || (extras = intent.getExtras()) == null) {
            return;
        }
        try {
            int i2 = extras.getInt("_weibo_resp_errcode", -1);
            if (i2 == 0) {
                wbShareCallback.onComplete();
            } else if (i2 == 1) {
                wbShareCallback.onCancel();
            } else if (i2 == 2) {
                wbShareCallback.onError(new UiError(i2, extras.getString("_weibo_resp_errstr"), "error from weibo client!"));
            }
        } catch (Exception e2) {
            wbShareCallback.onError(new UiError(-1, e2.getMessage(), e2.getMessage()));
        }
    }

    public final boolean isWBAppInstalled() {
        return a.a.b(this.a);
    }

    public final boolean isWBAppSupportMultipleImage() {
        return a.a.a(this.a);
    }

    public final void registerApp(Context context, AuthInfo authInfo, SdkListener sdkListener) {
        if (a.a.a) {
            return;
        }
        if (authInfo != null) {
            a.a.b = authInfo;
            a.a.a = true;
            if (sdkListener != null) {
                sdkListener.onInitSuccess();
                return;
            }
            return;
        }
        throw new RuntimeException("authInfo must not be null.");
    }

    public final void setLoggerEnable(boolean z) {
        c.a = z;
    }

    public final void shareMessage(Activity activity, WeiboMultiMessage weiboMultiMessage, boolean z) {
        f fVar = this.c;
        fVar.getClass();
        if (activity == null) {
            return;
        }
        if (a.a.b(activity) || !z) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - fVar.a < 5000) {
                return;
            }
            fVar.a = currentTimeMillis;
            if (z) {
                f.a(activity, weiboMultiMessage);
                return;
            }
            a.C0022a a = g.a.a(activity);
            if (a.a.b(activity) && a != null) {
                a.C0022a a2 = g.a.a(activity);
                if (a2 != null && a2.c > 10000) {
                    f.a(activity, weiboMultiMessage);
                    return;
                }
            }
            if (a.a.a) {
                AuthInfo authInfo = a.a.b;
                if (authInfo == null) {
                    return;
                }
                String str = null;
                WebData webData = new WebData(authInfo, 1, (String) null, (String) null);
                String str2 = System.currentTimeMillis() + "";
                String packageName = activity.getPackageName();
                Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
                if (readAccessToken != null) {
                    String accessToken = readAccessToken.getAccessToken();
                    if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                        str = accessToken;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("web_data", webData);
                int i2 = webData.b;
                if (i2 == 1) {
                    bundle.putInt("web_type", 1);
                } else if (i2 == 2) {
                    bundle.putInt("web_type", 2);
                } else if (i2 == 3) {
                    bundle.putInt("web_type", 3);
                }
                bundle.putString("_weibo_transaction", str2);
                if (weiboMultiMessage != null) {
                    weiboMultiMessage.writeToBundle(bundle);
                }
                bundle.putString("token", str);
                bundle.putString("packageName", packageName);
                Intent intent = new Intent(activity, ShareTransActivity.class);
                intent.putExtra("start_flag", HardCoderJNI.FUNC_CHECK_PERMISSION);
                intent.putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
                intent.putExtras(bundle);
                activity.startActivityForResult(intent, Tencent.REQUEST_LOGIN);
                return;
            }
            throw new RuntimeException("please init sdk before use it. Wb.install()");
        }
    }

    public final void registerApp(Context context, AuthInfo authInfo) {
        registerApp(context, authInfo, null);
    }
}