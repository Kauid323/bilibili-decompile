package tv.danmaku.bili.ui.garb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import bili.resource.homepage.R;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bili.digital.common.data.SpaceHeaderRefreshMsg;
import com.bilibili.app.comm.list.common.feed.PegasusStyle;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.bus.Violet;
import com.bilibili.common.webview.js.JsBridgeCallHandlerV2;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.core.GarbStorageHelper;
import tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper;
import tv.danmaku.bili.ui.garb.model.GarbData;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: GarbJsBridgeCallHandler.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J\u001c\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0019\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\"\u0010 \u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0002J,\u0010!\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010&\u001a\u00020\u000fH\u0002J\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0(H\u0016¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u000fH\u0016J\b\u0010+\u001a\u00020\fH\u0014J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/garb/GarbJsBridgeCallHandler;", "Lcom/bilibili/common/webview/js/JsBridgeCallHandlerV2;", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "mProgressDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "mThemeReloadHandlers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "invokeNative", "", "method", "data", "Lcom/alibaba/fastjson/JSONObject;", "callbackId", "onSkinChange", "skin", "Lcom/bilibili/lib/ui/garb/Garb;", GarbJsBridgeCallHandler.SET_THEME_RELOAD_HANDLER, "onSelectLoadEquip", "callbackJs", "isSuccess", "", "handleDownloadGarb", "result", "onEmoticonPurchase", "onEmotionSetted", "handleSelectGarb", "downloadGarb", "garbDetail", "Ltv/danmaku/bili/ui/garb/model/GarbData$GarbDetail;", "downloadOnly", "showProgressDialog", "hideProgressDialog", "getSupportFunctions", "", "()[Ljava/lang/String;", BuildConfig.BUILD_TYPE, "getTag", "trackGarbSwitch", "id", "", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GarbJsBridgeCallHandler extends JsBridgeCallHandlerV2 {
    public static final String COLLECTION_HALL_UPDATE = "collectionHallUpdate";
    public static final String DOWNLOAD_THEME = "downloadTheme";
    public static final String EMOJI_PANEL_UPDATE = "emojiPanelUpdate";
    public static final String GET_DARK_MODE_STATE = "getDarkModeState";
    public static final String GET_THEME_DETAIL_INFO = "getThemeDetailInfo";
    public static final String OPERATION_BRAND_CUSTOM_SPLASH = "loadSplash";
    public static final String PRELOAD_BRAND_SPLASH = "purchaseSplash";
    public static final String PURCHASE_RESULT_METHOD = "purchaseGarb";
    public static final String SELECT_LOAD_EQUIP = "switchLoadingEquip";
    public static final String SELECT_THEME = "selectTheme";
    public static final String SET_PEGASUS_COLUMN = "setPeagsusColumn";
    public static final String SET_THEME_RELOAD_HANDLER = "setThemeReloadHandler";
    public static final String TAG = "GarbJsBridgeCallHandler";
    private final Activity activity;
    private TintProgressDialog mProgressDialog;
    private final HashSet<String> mThemeReloadHandlers;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public GarbJsBridgeCallHandler(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        this.activity = activity;
        this.mThemeReloadHandlers = new HashSet<>();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    /* compiled from: GarbJsBridgeCallHandler.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/GarbJsBridgeCallHandler$Companion;", "", "<init>", "()V", "TAG", "", "COLLECTION_HALL_UPDATE", "SELECT_THEME", "SELECT_LOAD_EQUIP", "SET_PEGASUS_COLUMN", "GET_THEME_DETAIL_INFO", "GET_DARK_MODE_STATE", "PURCHASE_RESULT_METHOD", "DOWNLOAD_THEME", "SET_THEME_RELOAD_HANDLER", "PRELOAD_BRAND_SPLASH", "OPERATION_BRAND_CUSTOM_SPLASH", "EMOJI_PANEL_UPDATE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void invokeNative(String method, final JSONObject data, final String callbackId) {
        Map map;
        String valueOf;
        Map map2;
        String str;
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(method, "method");
        try {
            boolean z = true;
            switch (method.hashCode()) {
                case -1900711008:
                    if (method.equals(COLLECTION_HALL_UPDATE)) {
                        BLog.i(TAG, "garb COLLECTION_HALL_UPDATE bridge  " + data);
                        Violet.INSTANCE.sendMsg(new SpaceHeaderRefreshMsg(), false, true);
                        return;
                    }
                    break;
                case -1844552405:
                    if (!method.equals(PURCHASE_RESULT_METHOD)) {
                        break;
                    } else {
                        BLog.i(TAG, "garb PURCHASE_RESULT_METHOD bridge");
                        onEmoticonPurchase(this.activity);
                        return;
                    }
                case -1555965528:
                    if (!method.equals(SELECT_LOAD_EQUIP)) {
                        break;
                    } else {
                        BLog.i(TAG, "garb SELECT_LOAD_EQUIP bridge");
                        onSelectLoadEquip(data != null ? data.getJSONObject("params") : null, callbackId);
                        return;
                    }
                case -1249927918:
                    if (!method.equals(GET_THEME_DETAIL_INFO)) {
                        break;
                    } else {
                        Map jSONObject2 = new JSONObject();
                        if (GarbStorageHelper.INSTANCE.isGarbChanged(this.activity)) {
                            BLog.i(TAG, "garb GET_THEME_DETAIL_INFO bridge isGarbChanged：true");
                            jSONObject2.put("themeid", GarbStorageHelper.INSTANCE.getTargetGarbThemeId(this.activity));
                            jSONObject2.put("is_force", GarbStorageHelper.INSTANCE.getTargetGarbChangeable(this.activity));
                            jSONObject2.put("type", GarbStorageHelper.INSTANCE.getTargetGarbType(this.activity));
                        } else {
                            BLog.i(TAG, "garb GET_THEME_DETAIL_INFO bridge isGarbChanged：false");
                            Garb garb = GarbManager.getGarbWithNightMode(this.activity);
                            if (garb.isPure()) {
                                map = jSONObject2;
                                valueOf = garb.getColorName();
                            } else {
                                map = jSONObject2;
                                valueOf = String.valueOf(garb.getId());
                            }
                            map.put("themeid", valueOf);
                            jSONObject2.put("is_force", String.valueOf(!garb.getChangeable()));
                            if (garb.isPure()) {
                                map2 = jSONObject2;
                                str = GarbJsBridgeCallHandlerKt.PURE_THEME;
                            } else {
                                map2 = jSONObject2;
                                str = GarbJsBridgeCallHandlerKt.GARB_THEME;
                            }
                            map2.put("type", str);
                        }
                        jSONObject2.put("view", PegasusStyle.INSTANCE.getCurrentStyle().toString());
                        callbackToJs(new Object[]{callbackId, jSONObject2});
                        return;
                    }
                case -1215613622:
                    if (!method.equals(SET_PEGASUS_COLUMN)) {
                        break;
                    } else {
                        if (data != null && (jSONObject = data.getJSONObject("result")) != null) {
                            JSONObject valueOf2 = Integer.valueOf(jSONObject.getIntValue(LoginReporterV2.Click.SIGNUP_KEY_MODE));
                            int it = ((Number) valueOf2).intValue();
                            if (it <= 0) {
                                z = false;
                            }
                            JSONObject jSONObject3 = z ? valueOf2 : null;
                            if (jSONObject3 != null) {
                                int it2 = ((Number) jSONObject3).intValue();
                                BLog.i(TAG, "garb SET_PEGASUS_COLUMN bridge");
                                GarbManagerDelegate.setIndexCardStyle(it2);
                            }
                        }
                        return;
                    }
                case -883885113:
                    if (!method.equals(EMOJI_PANEL_UPDATE)) {
                        break;
                    } else {
                        BLog.i(TAG, "garb EMOJI_PANEL_UPDATE bridge");
                        onEmotionSetted(this.activity);
                        return;
                    }
                case 21352993:
                    if (!method.equals(DOWNLOAD_THEME)) {
                        break;
                    } else {
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                GarbJsBridgeCallHandler.invokeNative$lambda$1(data, this, callbackId);
                            }
                        });
                        return;
                    }
                case 204934701:
                    if (!method.equals(SELECT_THEME)) {
                        break;
                    } else {
                        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                GarbJsBridgeCallHandler.invokeNative$lambda$0(data, this, callbackId);
                            }
                        });
                        return;
                    }
                case 967842338:
                    if (!method.equals(GET_DARK_MODE_STATE)) {
                        break;
                    } else {
                        BLog.i(TAG, "garb GET_DARK_MODE_STATE bridge");
                        Map jSONObject4 = new JSONObject();
                        jSONObject4.put("systemdark", MultipleThemeUtils.isNightTheme(this.activity) ? "1" : "0");
                        callbackToJs(new Object[]{callbackId, jSONObject4});
                        return;
                    }
                case 1491545130:
                    if (!method.equals(SET_THEME_RELOAD_HANDLER)) {
                        break;
                    } else {
                        BLog.i(TAG, "garb SET_THEME_RELOAD_HANDLER bridge");
                        setThemeReloadHandler(callbackId);
                        return;
                    }
                default:
                    return;
            }
        } catch (Throwable th) {
            BLog.e(TAG, " garb invoke jsb error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$0(JSONObject $data, GarbJsBridgeCallHandler this$0, String $callbackId) {
        JSONObject result;
        if ($data == null || (result = $data.getJSONObject("result")) == null) {
            return;
        }
        BLog.i(TAG, "garb SELECT_THEME bridge");
        this$0.handleSelectGarb(this$0.activity, result, $callbackId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeNative$lambda$1(JSONObject $data, GarbJsBridgeCallHandler this$0, String $callbackId) {
        JSONObject result;
        if ($data == null || (result = $data.getJSONObject("result")) == null) {
            return;
        }
        BLog.i(TAG, "garb DOWNLOAD_THEME bridge");
        this$0.handleDownloadGarb(this$0.activity, result, $callbackId);
    }

    public final void onSkinChange(Garb skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                GarbJsBridgeCallHandler.onSkinChange$lambda$0(GarbJsBridgeCallHandler.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSkinChange$lambda$0(GarbJsBridgeCallHandler this$0) {
        Iterable $this$forEach$iv = this$0.mThemeReloadHandlers;
        for (Object element$iv : $this$forEach$iv) {
            String callbackId = (String) element$iv;
            this$0.callbackToJs(new Object[]{callbackId});
        }
    }

    private final void setThemeReloadHandler(final String callbackId) {
        String str = callbackId;
        if (!(str == null || str.length() == 0)) {
            runOnUiThread(new Runnable() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    GarbJsBridgeCallHandler.setThemeReloadHandler$lambda$0(GarbJsBridgeCallHandler.this, callbackId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setThemeReloadHandler$lambda$0(GarbJsBridgeCallHandler this$0, String $callbackId) {
        this$0.mThemeReloadHandlers.add($callbackId);
    }

    private final void onSelectLoadEquip(JSONObject data, final String callbackId) {
        boolean isUnsnatch = Intrinsics.areEqual(data != null ? data.get("type") : null, "unload");
        if (isUnsnatch) {
            BLog.i(TAG, " garb onSelectLoadEquip isUnsnatch");
            LoadEquipStorageHelper.INSTANCE.unsnatchLoadEquip();
            callbackJs(callbackId, true);
            return;
        }
        GarbData.LoadEquip loadEquip = (GarbData.LoadEquip) JSON.toJavaObject((JSON) data, GarbData.LoadEquip.class);
        LoadEquipStorageHelper.INSTANCE.acceptEquip(loadEquip, new LoadEquipStorageHelper.Listener() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$onSelectLoadEquip$1
            @Override // tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper.Listener
            public void onDownloadError(String errMsg) {
                BLog.i(GarbJsBridgeCallHandler.TAG, " garb onSelectLoadEquip failed");
                GarbJsBridgeCallHandler.this.callbackJs(callbackId, false);
            }

            @Override // tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper.Listener
            public void onDownloadSuccess() {
                BLog.i(GarbJsBridgeCallHandler.TAG, " garb onSelectLoadEquip success");
                GarbJsBridgeCallHandler.this.callbackJs(callbackId, true);
            }

            @Override // tv.danmaku.bili.ui.garb.core.LoadEquipStorageHelper.Listener
            public boolean isCanceled() {
                return GarbJsBridgeCallHandler.this.getActivity().isFinishing();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackJs(String callbackId, boolean isSuccess) {
        Map jSONObject = new JSONObject();
        jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
        jSONObject.put("success", isSuccess ? "1" : "0");
        callbackToJs(new Object[]{callbackId, jSONObject});
    }

    private final void handleDownloadGarb(Activity activity, JSONObject result, String callbackId) {
        String type = result.getString("type");
        if (Intrinsics.areEqual(GarbJsBridgeCallHandlerKt.GARB_THEME, type)) {
            BLog.i(TAG, " garb handleDownloadGarb GARB_THEME");
            GarbData.GarbDetail it = (GarbData.GarbDetail) JSON.parseObject(result.getString("data"), GarbData.GarbDetail.class);
            if (it != null) {
                BLog.i(TAG, " garb handleDownloadGarb downloadGarb");
                downloadGarb(activity, it, callbackId, true);
            }
        }
    }

    private final void onEmoticonPurchase(Activity activity) {
        BLog.i(TAG, " garb onEmoticonPurchase");
        activity.setResult(-1);
        SharedPreferences $this$edit_u24default$iv = BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity);
        Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "getBLKVSharedPreference(...)");
        SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
        editor$iv.putBoolean("pref_key_emoticon_package_change", true);
        editor$iv.apply();
    }

    private final void onEmotionSetted(Activity activity) {
        BLog.i(TAG, " garb onEmotionSetted");
        SharedPreferences $this$edit_u24default$iv = BiliGlobalPreferenceHelper.getBLKVSharedPreference(activity);
        Intrinsics.checkNotNullExpressionValue($this$edit_u24default$iv, "getBLKVSharedPreference(...)");
        SharedPreferences.Editor editor$iv = $this$edit_u24default$iv.edit();
        editor$iv.putBoolean("pref_key_emoticon_package_change", true);
        editor$iv.apply();
    }

    private final void handleSelectGarb(Activity activity, JSONObject result, String callbackId) {
        String type = result.getString("type");
        if (Intrinsics.areEqual(GarbJsBridgeCallHandlerKt.PURE_THEME, type)) {
            BLog.i(TAG, " garb handleSelectGarb PURE_THEME");
            String colorName = result.getString("id");
            if (!TextUtils.isEmpty(colorName)) {
                Intrinsics.checkNotNull(colorName);
                Garb it = GarbManagerDelegate.saveColorGarb(colorName);
                if (it != null) {
                    BLog.i(TAG, " garb handleSelectGarb PURE_THEME saveGarbChanged");
                    GarbStorageHelper.INSTANCE.saveGarbChanged(activity, it);
                }
                Map jSONObject = new JSONObject();
                jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
                jSONObject.put("success", "1");
                callbackToJs(new Object[]{callbackId, jSONObject});
                ToastHelper.showToast(activity, R.string.homepage_global_string_380, 0);
            }
        } else if (Intrinsics.areEqual(GarbJsBridgeCallHandlerKt.GARB_THEME, type)) {
            BLog.i(TAG, " garb handleSelectGarb GARB_THEME");
            GarbData.GarbDetail garbDetail = (GarbData.GarbDetail) JSON.parseObject(result.getString("data"), GarbData.GarbDetail.class);
            if (garbDetail == null) {
                return;
            }
            if (garbDetail.getConf() != null) {
                garbDetail.setOp(true);
            }
            if (GarbManagerDelegate.INSTANCE.isResValid(garbDetail)) {
                BLog.i(TAG, " garb handleSelectGarb GARB_THEME isResValid");
                GarbStorageHelper.INSTANCE.saveGarbChanged(activity, GarbManagerDelegate.saveGarb(garbDetail));
                Map jSONObject2 = new JSONObject();
                jSONObject2.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
                jSONObject2.put("success", "1");
                callbackToJs(new Object[]{callbackId, jSONObject2});
                ToastHelper.showToast(activity, R.string.homepage_global_string_380, 0);
            } else {
                BLog.i(TAG, " garb handleSelectGarb GARB_THEME downloadGarb");
                downloadGarb$default(this, activity, garbDetail, callbackId, false, 8, null);
            }
            trackGarbSwitch(garbDetail.getId());
        }
    }

    static /* synthetic */ void downloadGarb$default(GarbJsBridgeCallHandler garbJsBridgeCallHandler, Activity activity, GarbData.GarbDetail garbDetail, String str, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        garbJsBridgeCallHandler.downloadGarb(activity, garbDetail, str, z);
    }

    private final void downloadGarb(final Activity activity, final GarbData.GarbDetail garbDetail, final String callbackId, final boolean downloadOnly) {
        if (activity.isFinishing()) {
            return;
        }
        showProgressDialog(activity);
        GarbStorageHelper.INSTANCE.download(garbDetail, new GarbStorageHelper.Listener() { // from class: tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandler$downloadGarb$1
            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public void onDownloadSuccess() {
                BLog.i(GarbJsBridgeCallHandler.TAG, " garb handleSelectGarb GARB_THEME downloadGarb onDownloadSuccess");
                GarbJsBridgeCallHandler.this.hideProgressDialog();
                Map jSONObject = new JSONObject();
                jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
                jSONObject.put("success", "1");
                GarbJsBridgeCallHandler.this.callbackToJs(new Object[]{callbackId, jSONObject});
                if (!downloadOnly) {
                    GarbStorageHelper.INSTANCE.saveGarbChanged(activity, GarbManagerDelegate.saveGarb(garbDetail));
                    ToastHelper.showToast(activity, R.string.homepage_global_string_380, 0);
                }
            }

            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public void onDownloadError(String errMsg) {
                BLog.i(GarbJsBridgeCallHandler.TAG, " garb handleSelectGarb GARB_THEME downloadGarb onDownloadError");
                GarbJsBridgeCallHandler.this.hideProgressDialog();
                Map jSONObject = new JSONObject();
                jSONObject.put(LoginReporterV2.Show.SIGNUP_KEY_CODE, "0");
                jSONObject.put("success", "0");
                GarbJsBridgeCallHandler.this.callbackToJs(new Object[]{callbackId, jSONObject});
            }

            @Override // tv.danmaku.bili.ui.garb.core.GarbStorageHelper.Listener
            public boolean isCanceled() {
                return activity.isFinishing();
            }
        });
    }

    private final void showProgressDialog(Activity activity) {
        if (activity.isFinishing()) {
            return;
        }
        if (this.mProgressDialog == null) {
            this.mProgressDialog = TintProgressDialog.show(activity, "", activity.getString(bili.resource.common.R.string.common_global_string_350), true, false);
            return;
        }
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideProgressDialog() {
        TintProgressDialog tintProgressDialog = this.mProgressDialog;
        if (tintProgressDialog != null) {
            tintProgressDialog.dismiss();
        }
    }

    public String[] getSupportFunctions() {
        return new String[]{SELECT_THEME, SET_PEGASUS_COLUMN, GET_THEME_DETAIL_INFO, DOWNLOAD_THEME, GET_DARK_MODE_STATE, PURCHASE_RESULT_METHOD, SET_THEME_RELOAD_HANDLER, PRELOAD_BRAND_SPLASH, OPERATION_BRAND_CUSTOM_SPLASH, EMOJI_PANEL_UPDATE, COLLECTION_HALL_UPDATE};
    }

    public void release() {
    }

    protected String getTag() {
        return TAG;
    }

    private final void trackGarbSwitch(long id) {
        Neurons.reportH5Click(false, "main.my-personality-setting.globaltheme-feed.globaltheme-card.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_entity", "globaltheme"), TuplesKt.to("card_entity_id", String.valueOf(id)), TuplesKt.to("action", "swtich")}));
    }
}