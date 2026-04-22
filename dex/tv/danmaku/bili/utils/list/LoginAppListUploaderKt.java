package tv.danmaku.bili.utils.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.base.AppListConfig;
import com.bilibili.homepage.AesEncryptService;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blrouter.BLRouter;
import java.nio.charset.Charset;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppInfo;
import tv.danmaku.android.util.InstalledAppsUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LoginAppListUploader.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017\u001a\b\u0010\u0018\u001a\u00020\u0015H\u0000\u001a\b\u0010\u0019\u001a\u00020\u0015H\u0002\u001a\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0003\u001a\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002\u001a\n\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\b\u0010\"\u001a\u00020\u001cH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\"+\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"REPORT_MAX_BODY_SIZE", "", "TAG", "", "mAesCipher", "Ljavax/crypto/Cipher;", "getMAesCipher", "()Ljavax/crypto/Cipher;", "mAesCipher$delegate", "Lkotlin/Lazy;", "isRegistered", "", "<set-?>", "installVersionAbove746", "getInstallVersionAbove746", "()Z", "setInstallVersionAbove746", "(Z)V", "installVersionAbove746$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "initLoginAppListUploader", "", "context", "Landroid/content/Context;", "updateInstallVersionFlag", "uploadAppList", "getLimitedSizeString", "source", "Lorg/json/JSONArray;", "removeFirstElement", "aesEncrypt", "input", "", "getAESEncryptCipher", "getInstalledAppsAsJsonArray", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LoginAppListUploaderKt {
    private static final int REPORT_MAX_BODY_SIZE = 61440;
    private static final String TAG = "LoginAppListUploader";
    private static boolean isRegistered;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(LoginAppListUploaderKt.class, "installVersionAbove746", "getInstallVersionAbove746()Z", 1))};
    private static final Lazy mAesCipher$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.utils.list.LoginAppListUploaderKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Cipher mAesCipher_delegate$lambda$0;
            mAesCipher_delegate$lambda$0 = LoginAppListUploaderKt.mAesCipher_delegate$lambda$0();
            return mAesCipher_delegate$lambda$0;
        }
    });
    private static final SharedPreferencesField installVersionAbove746$delegate = new SharedPreferencesField("sp_key_app_list_install_version_above_746", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private static final Cipher getMAesCipher() {
        return (Cipher) mAesCipher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Cipher mAesCipher_delegate$lambda$0() {
        return getAESEncryptCipher();
    }

    public static final boolean getInstallVersionAbove746() {
        return ((Boolean) installVersionAbove746$delegate.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    public static final void setInstallVersionAbove746(boolean z) {
        installVersionAbove746$delegate.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public static final void initLoginAppListUploader(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        updateInstallVersionFlag();
        if (isRegistered) {
            return;
        }
        AppListConfig appListConfig = (AppListConfig) BLRouter.get$default(BLRouter.INSTANCE, AppListConfig.class, (String) null, 2, (Object) null);
        if (appListConfig != null && appListConfig.getReportAppListAfterLogin()) {
            AppListConfig appListConfig2 = (AppListConfig) BLRouter.get$default(BLRouter.INSTANCE, AppListConfig.class, (String) null, 2, (Object) null);
            if (!(appListConfig2 != null && appListConfig2.getDisableRegularAppListRequest())) {
                return;
            }
            BiliAccounts.get(context).hasFirstLogin();
            isRegistered = true;
            BiliAccounts.get(context).subscribe(new PassportObserver() { // from class: tv.danmaku.bili.utils.list.LoginAppListUploaderKt$$ExternalSyntheticLambda1
                public final void onChange(Topic topic) {
                    LoginAppListUploaderKt.initLoginAppListUploader$lambda$0(topic);
                }
            }, new Topic[]{Topic.SIGN_IN});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoginAppListUploader$lambda$0(Topic topic) {
        if (topic == Topic.SIGN_IN) {
            uploadAppList();
        }
    }

    public static final void updateInstallVersionFlag() {
        if (EnvironmentManager.getInstance().isFirstStart()) {
            BLog.i(TAG, "isFirstStart update flag");
            setInstallVersionAbove746(true);
        }
    }

    private static final void uploadAppList() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new LoginAppListUploaderKt$uploadAppList$1(null), 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getLimitedSizeString(JSONArray source) {
        String jSONArray = source.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "toString(...)");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        byte[] bytes = jSONArray.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String cryptString = aesEncrypt(bytes);
        while (cryptString.length() > REPORT_MAX_BODY_SIZE) {
            JSONArray resultJsonArray = removeFirstElement(source);
            String jSONArray2 = resultJsonArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "toString(...)");
            Charset forName2 = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName2, "forName(...)");
            byte[] bytes2 = jSONArray2.getBytes(forName2);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            cryptString = aesEncrypt(bytes2);
        }
        return cryptString;
    }

    private static final JSONArray removeFirstElement(JSONArray source) {
        if (source.length() > 0) {
            source.remove(0);
        }
        return source;
    }

    private static final String aesEncrypt(byte[] input) {
        if (getMAesCipher() == null) {
            return "";
        }
        try {
            Cipher mAesCipher = getMAesCipher();
            Intrinsics.checkNotNull(mAesCipher);
            String encodeToString = Base64.encodeToString(mAesCipher.doFinal(input), 2);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        } catch (Exception e) {
            BLog.e(TAG, e);
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e A[Catch: Exception -> 0x004c, TRY_LEAVE, TryCatch #0 {Exception -> 0x004c, blocks: (B:3:0x0002, B:5:0x0016, B:7:0x001c, B:9:0x0022, B:15:0x002e), top: B:22:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Cipher getAESEncryptCipher() {
        boolean z;
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            AesEncryptService aesEncryptService = (AesEncryptService) BLRouter.INSTANCE.get(AesEncryptService.class, "AesEncryptService");
            String key = aesEncryptService != null ? aesEncryptService.getKey() : null;
            String str = key;
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    return null;
                }
                byte[] bytes = key.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                SecretKey aesKey = new SecretKeySpec(bytes, "AES");
                cipher.init(1, aesKey);
                return cipher;
            }
            z = true;
            if (!z) {
            }
        } catch (Exception e) {
            BLog.e(TAG, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray getInstalledAppsAsJsonArray() {
        List<AppInfo> appList;
        JSONArray jsonArray = new JSONArray();
        try {
            appList = InstalledAppsUtils.Companion.getInstalledApps();
        } catch (NullPointerException e) {
            BLog.w(e.getMessage(), e);
            appList = null;
        }
        List list = appList;
        if (list == null || list.isEmpty()) {
            return jsonArray;
        }
        for (AppInfo applicationInfo : appList) {
            if ((applicationInfo.flags & 1) == 0) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("p", applicationInfo.packageName);
                    jsonArray.put(jsonObject);
                } catch (JSONException e2) {
                }
            }
        }
        return jsonArray;
    }
}