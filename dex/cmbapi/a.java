package cmbapi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Hashtable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

final class a implements CMBApi {
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private final String f130c;
    private boolean d;
    private boolean a = true;
    private CMBPayCallback e = null;
    private int f = 65536091;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Activity activity, String str, boolean z) {
        this.b = null;
        this.d = false;
        this.b = activity;
        this.f130c = str;
        this.d = z;
    }

    private int a(CMBRequest cMBRequest) {
        if (this.b == null) {
            return CMBConstants.RequestCode_Params_Error;
        }
        if (TextUtils.isEmpty(cMBRequest.CMBJumpAppUrl) || cMBRequest.CMBJumpAppUrl.startsWith("cmbmobilebank://")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(cMBRequest.CMBJumpAppUrl);
            stringBuffer.append(String.format(CMBConstants.REQ_PARAMS, getApiVersion(), this.f130c, cMBRequest.method));
            stringBuffer.append(cMBRequest.requestData);
            Intent intent = new Intent();
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.setAction("android.intent.action.VIEW");
            this.b.startActivity(intent);
            return CMBConstants.RequestCode_Params_Well_Done;
        }
        return CMBConstants.RequestCode_Params_Error;
    }

    private boolean a(int i, String str, CMBEventHandler cMBEventHandler) {
        CMBResponse cMBResponse = new CMBResponse();
        cMBResponse.respCode = i;
        cMBResponse.respMsg = str;
        cMBEventHandler.onResp(cMBResponse);
        return true;
    }

    private boolean a(CMBRequest cMBRequest, CMBPayCallback cMBPayCallback) {
        if (this.b == null) {
            if (cMBPayCallback != null) {
                cMBPayCallback.onError("context is null.");
            }
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(cMBRequest.CMBH5Url);
        stringBuffer.append(String.format("&cmbpbsdk_version=%s&sdk_deviceType=E&cmbpbsdk_appid=%s&cmbpbsdk_method=%s", getApiVersion(), getAppId(), cMBRequest.method));
        if (cMBPayCallback != null) {
            this.e = cMBPayCallback;
        }
        Intent intent = new Intent(this.b, CMBApiEntryActivity.class);
        intent.putExtra(CMBConstants.Key_Params_URL, stringBuffer.toString());
        intent.putExtra(CMBConstants.Key_Params_Data, cMBRequest.requestData);
        intent.putExtra(CMBConstants.Key_Params_ShowNavigation, this.a);
        this.b.startActivityForResult(intent, 3);
        return true;
    }

    private boolean a(String str, CMBEventHandler cMBEventHandler) {
        Hashtable<String, String> GetUrlParms;
        boolean z;
        if (TextUtils.isEmpty(str) || (GetUrlParms = CMBApiUtils.GetUrlParms(str)) == null) {
            return false;
        }
        String str2 = GetUrlParms.get("CMBSDKRespCode");
        String str3 = GetUrlParms.get("CMBPayRespCode");
        if (!TextUtils.isEmpty(str2)) {
            z = false;
        } else if (TextUtils.isEmpty(str3)) {
            return false;
        } else {
            z = true;
        }
        try {
            int parseInt = z ? Integer.parseInt(str3) : Integer.parseInt(str2);
            String str4 = GetUrlParms.get(!z ? "CMBSDKRespMsg" : "CMBPayRespMsg");
            try {
                str4 = URLDecoder.decode(str4.replace("+", ""), com.alipay.sdk.m.o.a.z);
            } catch (UnsupportedEncodingException e) {
            }
            String str5 = str4 != null ? str4 : "";
            CMBResponse cMBResponse = new CMBResponse();
            cMBResponse.respCode = parseInt;
            cMBResponse.respMsg = str5;
            Log.e(CMBConstants.TAG, "CMBApiImp-handleResponeMsg-responseMSG= " + cMBResponse.respMsg);
            cMBEventHandler.onResp(cMBResponse);
            Log.e(CMBConstants.TAG, "CMBApiImp-handleResponeMsg-after respCode= " + cMBResponse.respCode);
            return true;
        } catch (NumberFormatException e2) {
            return false;
        }
    }

    private int b(CMBRequest cMBRequest) {
        if (this.b == null) {
            return CMBConstants.RequestCode_Params_Error;
        }
        if (TextUtils.isEmpty(cMBRequest.CMBH5Url) || cMBRequest.CMBH5Url.startsWith("http://") || cMBRequest.CMBH5Url.startsWith("https://")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(String.format(CMBConstants.REQ_PARAMS, getApiVersion(), getAppId(), cMBRequest.method));
            stringBuffer.append(cMBRequest.requestData);
            Intent intent = new Intent(this.b, CMBApiEntryActivity.class);
            intent.putExtra(CMBConstants.Key_Params_URL, cMBRequest.CMBH5Url);
            intent.putExtra(CMBConstants.Key_Params_Data, stringBuffer.toString());
            intent.putExtra(CMBConstants.Key_Params_ShowNavigation, cMBRequest.isShowNavigationBar);
            this.b.startActivityForResult(intent, 3);
            return CMBConstants.RequestCode_Params_Well_Done;
        }
        return CMBConstants.RequestCode_Params_Error;
    }

    private boolean b(CMBRequest cMBRequest, CMBPayCallback cMBPayCallback) {
        if (this.b == null) {
            if (cMBPayCallback != null) {
                cMBPayCallback.onError("context is null");
            }
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("cmbmobilebank://CMBLS/functionjump?id=1200&action=gofuncid&funcid=200011&serverid=CMBEUserPay&requesttype=post&cmb_app_trans_parms_start=here");
        stringBuffer.append(String.format("&cmbpbsdk_version=%s&sdk_deviceType=E&cmbpbsdk_appid=%s&cmbpbsdk_method=%s&cmbpbsdk_payParam=", getApiVersion(), this.f130c, cMBRequest.method));
        try {
            stringBuffer.append(URLEncoder.encode(Base64.encodeToString(cMBRequest.CMBJumpAppUrl.getBytes(), 0), com.alipay.sdk.m.o.a.z));
            if (cMBPayCallback != null) {
                this.e = cMBPayCallback;
            }
            Intent intent = new Intent();
            intent.setData(Uri.parse(stringBuffer.toString()));
            intent.setAction("android.intent.action.VIEW");
            this.b.startActivity(intent);
            return true;
        } catch (IOException e) {
            if (cMBPayCallback != null) {
                cMBPayCallback.onError("URLEncoder fail.");
            }
            return false;
        }
    }

    @Override // cmbapi.CMBApi
    public String getApiVersion() {
        return CMBApiUtils.SDK_VERSION;
    }

    @Override // cmbapi.CMBApi
    public final String getAppId() {
        return this.f130c;
    }

    @Override // cmbapi.CMBApi
    public final boolean handleIntent(Intent intent, CMBEventHandler cMBEventHandler) {
        if (intent == null || cMBEventHandler == null) {
            return false;
        }
        String dataString = intent.getDataString();
        if (!TextUtils.isEmpty(dataString)) {
            Log.d(CMBConstants.TAG, "CMBApiImp-handleIntent-URL= " + dataString);
            return a(dataString, cMBEventHandler);
        }
        String stringExtra = intent.getStringExtra(CMBApiUtils.CMBAPI_INTENT_MSG);
        int intExtra = intent.getIntExtra(CMBApiUtils.CMBAPI_INTENT_CODE, this.f);
        if (intExtra == this.f) {
            return false;
        }
        Log.d(CMBConstants.TAG, "CMBApiImp-handleIntent-h5MSG= " + stringExtra + "h5CODE= " + intExtra);
        return a(intExtra, stringExtra, cMBEventHandler);
    }

    @Override // cmbapi.CMBApi
    public boolean isCMBAppInstalled() {
        boolean z = false;
        try {
            if (__Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(this.b.getPackageManager(), "cmb.pb", 256) != null) {
                z = true;
            }
        } catch (Exception e) {
        }
        System.out.println("isCMBAppInstalled result:" + z);
        return z;
    }

    @Override // cmbapi.CMBApi
    public int sendReq(CMBRequest cMBRequest) {
        return cMBRequest == null ? CMBConstants.RequestCode_Params_Error : (TextUtils.isEmpty(cMBRequest.CMBJumpAppUrl) || !isCMBAppInstalled()) ? b(cMBRequest) : a(cMBRequest);
    }

    @Override // cmbapi.CMBApi
    public boolean sendReq(CMBRequest cMBRequest, CMBPayCallback cMBPayCallback) {
        if (cMBRequest == null) {
            return false;
        }
        return (TextUtils.isEmpty(cMBRequest.CMBJumpAppUrl) || !isCMBAppInstalled()) ? a(cMBRequest, cMBPayCallback) : b(cMBRequest, cMBPayCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.text.StringsKt.contains$default(r5, r9, false, 2, (java.lang.Object) null) == true) goto L19;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(PackageManager pm, String pkg, int flag) {
        boolean agreeGetPackageInfo;
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        boolean inPkgWhiteLst = true;
        try {
            agreeGetPackageInfo = ConfigManager.Companion.ab2().getWithDefault("ff.privacy.hook.agree.get_package_info", true);
        } catch (Exception e) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e2) {
            }
            if (!inPkgWhiteLst) {
                if (Intrinsics.areEqual(pkg, FoundationAlias.getFapps().getAppId())) {
                    PackageInfo fake = pm.getPackageArchiveInfo(FoundationAlias.getFapp().getPackageCodePath(), 0);
                    if (fake == null) {
                        PackageInfo it = new PackageInfo();
                        it.versionCode = 2233;
                        return it;
                    }
                    return fake;
                }
                throw new PackageManager.NameNotFoundException(pkg);
            }
        }
        PackageInfo packageInfo = pm.getPackageInfo(pkg, Integer.valueOf(flag).intValue());
        if (packageInfo instanceof PackageInfo) {
            return packageInfo;
        }
        return null;
    }
}