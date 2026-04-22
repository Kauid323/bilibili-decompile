package tv.danmaku.bili.ui.main.deeplink;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bilibili.api.BiliApiException;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.RomUtils;
import com.bilibili.lib.biliid.api.EnvironmentManager;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.oaid.MsaHelper;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import retrofit2.Callback;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.splash.ClipboardJumpHelper;
import tv.danmaku.bili.utils.ChannelNameUtil;

/* compiled from: DelayDeepLinkHelper.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\n2\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Ltv/danmaku/bili/ui/main/deeplink/DelayDeepLinkHelper;", "", "<init>", "()V", "TAG", "", "CHANNEL_PREFIX", "fetch", "", "appCtx", "Landroid/content/Context;", "jump", "context", "url", "fetchDelayDeepLink", "cb", "Lcom/bilibili/okretro/BiliApiDataCallback;", "Ltv/danmaku/bili/ui/main/deeplink/DelayDeepLink;", "reportDeepLinkJump", "isSuccess", "", "reportDeepLinkFetchResult", "errorCode", "", "DelayDeepLinkApi", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DelayDeepLinkHelper {
    public static final int $stable = 0;
    private static final String CHANNEL_PREFIX = "xxl_hw_";
    public static final DelayDeepLinkHelper INSTANCE = new DelayDeepLinkHelper();
    private static final String TAG = "DelayDeepLinkHelper";

    /* compiled from: DelayDeepLinkHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main/deeplink/DelayDeepLinkHelper$DelayDeepLinkApi;", "", "getDelayDeepLinkUrl", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/main/deeplink/DelayDeepLink;", "oaid", "", "bundle", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @BaseUrl("https://app.bilibili.com")
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface DelayDeepLinkApi {
        @GET("/x/resource/deeplink/huawei")
        BiliCall<GeneralResponse<DelayDeepLink>> getDelayDeepLinkUrl(@Query("oaid") String str, @Query("bundle") String str2);
    }

    private DelayDeepLinkHelper() {
    }

    @JvmStatic
    public static final void fetch(final Context appCtx) {
        String it;
        Intrinsics.checkNotNullParameter(appCtx, "appCtx");
        boolean hitChannel = true;
        if (!Intrinsics.areEqual(ConfigManager.Companion.ab().get("delay_deep_link_enable", true), true)) {
            BLog.i(TAG, "Switcher is off.");
        } else if (!EnvironmentManager.getInstance().isFirstStart()) {
            BLog.i(TAG, "No need fetch, cause not first start.");
        } else {
            String channel = ChannelNameUtil.Companion.getPackageChannel();
            Contract config = ConfigManager.Companion.config();
            String str = CHANNEL_PREFIX;
            String it2 = (String) config.get("main.delay_deeplink_channel_prefix", CHANNEL_PREFIX);
            if (it2 != null) {
                if (TextUtils.isEmpty(it2)) {
                    it2 = null;
                }
                if (it2 != null) {
                    str = it2;
                }
            }
            String targetChannelPrefixs = str;
            Iterable $this$any$iv = StringsKt.split$default(targetChannelPrefixs, new char[]{','}, false, 0, 6, (Object) null);
            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                Iterator it3 = $this$any$iv.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object element$iv = it3.next();
                        String it4 = (String) element$iv;
                        if (TextUtils.isEmpty(it4) || !StringsKt.startsWith(channel, it4, true)) {
                            it = null;
                            continue;
                        } else {
                            it = 1;
                            continue;
                        }
                        if (it != null) {
                            break;
                        }
                    } else {
                        hitChannel = false;
                        break;
                    }
                }
            } else {
                hitChannel = false;
            }
            if (!RomUtils.isHuaweiRom() || !hitChannel) {
                BLog.i(TAG, "No need fetch, cause not huawei channel or i18l app.");
            } else if (ClipboardJumpHelper.isClipboardJumped() || ClipboardJumpHelper.isSceneRedirected()) {
                BLog.i(TAG, "No need fetch, cause clipboard jumped or scene redirected");
            } else {
                INSTANCE.fetchDelayDeepLink(appCtx, new BiliApiDataCallback<DelayDeepLink>() { // from class: tv.danmaku.bili.ui.main.deeplink.DelayDeepLinkHelper$fetch$1
                    public void onDataSuccess(DelayDeepLink data) {
                        if (data != null) {
                            DelayDeepLink it5 = !TextUtils.isEmpty(data.getDeepLink()) ? data : null;
                            if (it5 != null) {
                                Context context = appCtx;
                                BLog.i("DelayDeepLinkHelper", "Fetch delay deep link success, url: " + data.getDeepLink());
                                DelayDeepLinkHelper delayDeepLinkHelper = DelayDeepLinkHelper.INSTANCE;
                                String deepLink = data.getDeepLink();
                                Intrinsics.checkNotNull(deepLink);
                                delayDeepLinkHelper.jump(context, deepLink);
                                DelayDeepLinkHelper delayDeepLinkHelper2 = DelayDeepLinkHelper.INSTANCE;
                                String deepLink2 = it5.getDeepLink();
                                Intrinsics.checkNotNull(deepLink2);
                                delayDeepLinkHelper2.reportDeepLinkFetchResult(0, deepLink2);
                                return;
                            }
                        }
                        DelayDeepLinkHelper.INSTANCE.reportDeepLinkFetchResult(1, "");
                    }

                    public void onError(Throwable t) {
                        if (t instanceof BiliApiException) {
                            DelayDeepLinkHelper.INSTANCE.reportDeepLinkFetchResult(((BiliApiException) t).mCode, "");
                            BLog.e("DelayDeepLinkHelper", "Fetch delay deep link error: " + ((BiliApiException) t).mCode, t);
                            return;
                        }
                        DelayDeepLinkHelper.INSTANCE.reportDeepLinkFetchResult(-1, "");
                        BLog.e("DelayDeepLinkHelper", "Fetch delay deep link error", t);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jump(final Context context, final String url) {
        if (ClipboardJumpHelper.isClipboardJumped() || ClipboardJumpHelper.isSceneRedirected()) {
            BLog.i(TAG, "No need jump, cause clipboard jumped or scene redirected");
            reportDeepLinkJump(url, false);
            return;
        }
        MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("delay_deep_link", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.deeplink.DelayDeepLinkHelper$jump$dialogInfo$1
            public void onShow() {
                if (ClipboardJumpHelper.isClipboardJumped() || ClipboardJumpHelper.isSceneRedirected()) {
                    BLog.i("DelayDeepLinkHelper", "No need jump, cause clipboard jumped or scene redirected");
                    DelayDeepLinkHelper.INSTANCE.reportDeepLinkJump(url, false);
                    MainDialogManager.showNextDialog("delay_deep_link", false, context);
                    return;
                }
                Activity topActivity = BiliContext.topActivitiy();
                RouteRequest req = new RouteRequest.Builder(url).build();
                BLRouter.routeTo(req, topActivity);
                DelayDeepLinkHelper.INSTANCE.reportDeepLinkJump(url, true);
                MainDialogManager.showNextDialog("delay_deep_link", false, context);
            }
        }, 1040);
        dialogInfo.setMainOnly(false);
        MainDialogManager.addDialog(dialogInfo, context);
    }

    private final void fetchDelayDeepLink(Context context, BiliApiDataCallback<DelayDeepLink> biliApiDataCallback) {
        String oaid = MsaHelper.getOaid();
        if (TextUtils.isEmpty(oaid)) {
            BLog.i(TAG, "No need fetch, cause no oaid.");
            return;
        }
        Object createService = ServiceGenerator.createService(DelayDeepLinkApi.class);
        Intrinsics.checkNotNullExpressionValue(createService, "createService(...)");
        DelayDeepLinkApi api = (DelayDeepLinkApi) createService;
        api.getDelayDeepLinkUrl(oaid, context.getPackageName()).enqueue((Callback) biliApiDataCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDeepLinkJump(String url, boolean isSuccess) {
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("jump_url", url);
        pairArr[1] = TuplesKt.to(AuthResultCbHelper.ARGS_STATE, isSuccess ? "0" : "1");
        Neurons.trackT(false, "main.delay-deeplink.jump.track", MapsKt.mapOf(pairArr), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.deeplink.DelayDeepLinkHelper$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean reportDeepLinkJump$lambda$0;
                reportDeepLinkJump$lambda$0 = DelayDeepLinkHelper.reportDeepLinkJump$lambda$0();
                return Boolean.valueOf(reportDeepLinkJump$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportDeepLinkJump$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDeepLinkFetchResult(int errorCode, String url) {
        Neurons.trackT(false, "main.delay-deeplink.result.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_code", String.valueOf(errorCode)), TuplesKt.to("jump_url", url)}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.deeplink.DelayDeepLinkHelper$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean reportDeepLinkFetchResult$lambda$0;
                reportDeepLinkFetchResult$lambda$0 = DelayDeepLinkHelper.reportDeepLinkFetchResult$lambda$0();
                return Boolean.valueOf(reportDeepLinkFetchResult$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean reportDeepLinkFetchResult$lambda$0() {
        return true;
    }
}