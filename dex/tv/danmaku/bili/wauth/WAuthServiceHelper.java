package tv.danmaku.bili.wauth;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import cn.wh.auth.WAuthService;
import cn.wh.auth.bean.WParams;
import com.bilibili.bson.dsl.JsonDslKt;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.privacy.PrivacyHelper;
import com.google.gson.JsonObject;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.wauth.service.WAuthInvokeService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WAuthServiceHelper.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\u0006\u0010\u001b\u001a\u00020\u0007J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0007H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u0007X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Ltv/danmaku/bili/wauth/WAuthServiceHelper;", "Ltv/danmaku/bili/wauth/service/WAuthInvokeService;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "orgID", "", "appID", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "getOrgID$networkauth_debug", "()Ljava/lang/String;", "setOrgID$networkauth_debug", "(Ljava/lang/String;)V", "getAppID$networkauth_debug", "setAppID$networkauth_debug", "PKG_NAME_W_AUTH", "getPKG_NAME_W_AUTH$networkauth_debug", "mSerialNumber", "getAuthFromIntent", "", "type", "Ltv/danmaku/bili/wauth/BusinessType;", "miniProgram", "getVersion", "generateSerialNumber", "getExtras", "getSerialNumber", "checkAppInstalled", "context", "Landroid/content/Context;", "packageName", "networkauth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WAuthServiceHelper implements WAuthInvokeService {
    private final String PKG_NAME_W_AUTH;
    private final Activity activity;
    private String appID;
    private String mSerialNumber;
    private String orgID;

    public WAuthServiceHelper(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.orgID = "00000037";
        this.appID = "0001";
        this.PKG_NAME_W_AUTH = "cn.cyberIdentity.certification";
        this.activity = activity;
        this.mSerialNumber = "";
    }

    public final String getOrgID$networkauth_debug() {
        return this.orgID;
    }

    public final void setOrgID$networkauth_debug(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orgID = str;
    }

    public final String getAppID$networkauth_debug() {
        return this.appID;
    }

    public final void setAppID$networkauth_debug(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appID = str;
    }

    public final String getPKG_NAME_W_AUTH$networkauth_debug() {
        return this.PKG_NAME_W_AUTH;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WAuthServiceHelper(Activity activity, String orgID, String appID) {
        this(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(orgID, "orgID");
        Intrinsics.checkNotNullParameter(appID, "appID");
        this.orgID = orgID;
        this.appID = appID;
    }

    @Override // tv.danmaku.bili.wauth.service.WAuthInvokeService
    public boolean getAuthFromIntent(BusinessType type, boolean miniProgram) {
        Intrinsics.checkNotNullParameter(type, "type");
        boolean isInstall = checkAppInstalled(this.activity, this.PKG_NAME_W_AUTH);
        if (!isInstall) {
            return false;
        }
        String extras = "";
        if (miniProgram) {
            extras = getExtras();
        }
        this.mSerialNumber = generateSerialNumber();
        Log.i(WAuthErrorMsg.ERROR_MESSAGE_CALL, "WAuthServiceHelper-mSerialNumber: " + this.mSerialNumber);
        WParams params = new WParams(this.orgID, this.appID, this.mSerialNumber, type.getValue(), extras);
        WAuthService service = new WAuthService(this.activity, params);
        service.getAuthFromIntent();
        return true;
    }

    @Override // tv.danmaku.bili.wauth.service.WAuthInvokeService
    public String getVersion() {
        return "";
    }

    private final String generateSerialNumber() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        String substring = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null).substring(0, 32);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private final String getExtras() {
        JsonObject jsonobj = new JsonObject();
        JsonDslKt.set(jsonobj, "miniProgramID", "w001");
        JsonDslKt.set(jsonobj, "miniProgramPlatformID", "w00000011");
        String jsonObject = jsonobj.toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "toString(...)");
        return jsonObject;
    }

    public final String getSerialNumber() {
        return this.mSerialNumber;
    }

    private final boolean checkAppInstalled(Context context, String packageName) {
        PackageManager pm;
        if (TextUtils.isEmpty(packageName) || (pm = context.getPackageManager()) == null) {
            return false;
        }
        try {
            Intrinsics.checkNotNull(packageName);
            return __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(pm, packageName, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        } catch (NullPointerException e2) {
            return false;
        }
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