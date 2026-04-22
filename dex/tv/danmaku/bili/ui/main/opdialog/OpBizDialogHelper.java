package tv.danmaku.bili.ui.main.opdialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.homepage.MainImageExtension;
import com.bilibili.lib.homepage.util.BottomTabSelectedHelper;
import com.bilibili.lib.homepage.util.UriUtils;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.DecodedImageAcquireRequestBuilder;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.performance.EntryPointKt;
import com.bilibili.okretro.GeneralResponse;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.http.BaseUrl;
import retrofit2.http.GET;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.log.BuildConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.core.test.FdDebugActivity;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.splash.ClipboardJumpHelper;

/* compiled from: OpBizDialogHelper.kt */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011*\u0001\u0011\bÁ\u0002\u0018\u00002\u00020\u0001:\u000201B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\b\u0010\u0016\u001a\u00020\rH\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u001a\u0010&\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u000bH\u0002J\u0012\u0010(\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010)\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u0010\u0010*\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u0005J\u0018\u0010.\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010$\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper;", "", "<init>", "()V", "TAG", "", "URI_MAIN_TAB", "isFirst", "", "hasTimeout", "showedMaxPrior", "", "fetchOpDialogInfo", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "listener", "tv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$listener$1", "Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$listener$1;", "addBizBlockDialog", "context", "Landroid/content/Context;", BuildConfig.BUILD_TYPE, "removeBizBlockDialog", "removeBizBlockDialogDelay", "dealWithDialog", "info", "Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;", "dealWithDialogWithImage", "canShowDialog", "isInMutiWindowMode", "checkPromoPage", "getBlockTimeout", "", "reportDialogReceive", "reportData", "REASON_PRIORITY", "REASON_OTHER_PAGE", "reportDialogNotShow", "reason", "reportDialogShowInvoke", "reportDialogShow", "reportDialogClick", "MANUAL_CLOSE", "PASSIVE_CLOSE", "ERROR_CLOSE", "reportDialogClose", "closeWay", "OpBizDialogApi", "OpDialogInfo", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OpBizDialogHelper {
    public static final int ERROR_CLOSE = 3;
    public static final int MANUAL_CLOSE = 1;
    public static final int PASSIVE_CLOSE = 2;
    private static final int REASON_OTHER_PAGE = 2;
    private static final int REASON_PRIORITY = 1;
    public static final String TAG = "OpBizDialog";
    private static final String URI_MAIN_TAB = "bilibili://main/home";
    private static boolean hasTimeout;
    private static int showedMaxPrior;
    public static final OpBizDialogHelper INSTANCE = new OpBizDialogHelper();
    public static boolean isFirst = true;
    private static final OpBizDialogHelper$listener$1 listener = new MainDialogManager.IDialogShowListener() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$listener$1
        public void onShowNext(int priority) {
            int i;
            i = OpBizDialogHelper.showedMaxPrior;
            if (priority > i) {
                OpBizDialogHelper opBizDialogHelper = OpBizDialogHelper.INSTANCE;
                OpBizDialogHelper.showedMaxPrior = priority;
            }
        }

        public void onEmpty() {
        }
    };
    public static final int $stable = 8;

    /* compiled from: OpBizDialogHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpBizDialogApi;", "", "fetchOpDialog", "Lcom/bilibili/okretro/call/BiliCall;", "Lcom/bilibili/okretro/GeneralResponse;", "Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @BaseUrl("https://app.bilibili.com")
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface OpBizDialogApi {
        @GET("/x/resource/pop/up")
        BiliCall<GeneralResponse<OpDialogInfo>> fetchOpDialog();
    }

    private OpBizDialogHelper() {
    }

    @JvmStatic
    public static final void fetchOpDialogInfo(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        if (!ConfigManager.Companion.isHitFF("ff_op_dialog_request_enable")) {
            BLog.i(TAG, "fetch op dialog switcher is off");
            removeBizBlockDialog(activity);
            return;
        }
        BLog.i(TAG, "Start fetch op dialog info.");
        isFirst = true;
        INSTANCE.removeBizBlockDialogDelay(activity);
        if (EntryPointKt.getNetRequestOptEnable()) {
            BLog.i(TAG, "/x/resource/pop/up hit network request exp");
        } else {
            ((OpBizDialogApi) ServiceGenerator.createService(OpBizDialogApi.class)).fetchOpDialog().enqueue(new OpBizDialogHelper$fetchOpDialogInfo$1(activity));
        }
        MainDialogManager.addOnDialogEmptyListener(listener);
    }

    @JvmStatic
    public static final void addBizBlockDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("biz_block_dialog", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda5
            public final void onShow() {
                OpBizDialogHelper.addBizBlockDialog$lambda$0();
            }
        }, 2000);
        dialogInfo.setAddShowTimes(false);
        MainDialogManager.addDialog(dialogInfo, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addBizBlockDialog$lambda$0() {
    }

    @JvmStatic
    public static final void release() {
        MainDialogManager.removeDialogEmptyListener(listener);
    }

    @JvmStatic
    public static final void removeBizBlockDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (MainDialogManager.isDialogShowing("biz_block_dialog")) {
            MainDialogManager.showNextDialog("biz_block_dialog", false, context);
        }
        MainDialogManager.removeDialog("biz_block_dialog");
    }

    private final void removeBizBlockDialogDelay(final Context context) {
        HandlerThreads.postDelayed(0, new Runnable() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OpBizDialogHelper.removeBizBlockDialogDelay$lambda$0(context);
            }
        }, getBlockTimeout());
        BLog.i(TAG, "Start block timeout count.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeBizBlockDialogDelay$lambda$0(Context $context) {
        removeBizBlockDialog($context);
        hasTimeout = true;
        BLog.i(TAG, "Block timeout.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithDialog(Activity activity, OpDialogInfo info) {
        if (activity instanceof FragmentActivity) {
            DecodedImageAcquireRequestBuilder thumbnailUrlTransformStrategy = BiliImageLoader.INSTANCE.acquire((FragmentActivity) activity).with(DisplayUtils.dp2Px(301), DisplayUtils.dp2Px((int) BR.newMsgText)).asDecodedImage().thumbnailUrlTransformStrategy(MainImageExtension.getThumbnailUrlTransformStrategy(0, 0, false));
            String picUrl = info.getPicUrl();
            Intrinsics.checkNotNull(picUrl);
            thumbnailUrlTransformStrategy.url(picUrl).submit().subscribe(new OpBizDialogHelper$dealWithDialog$1(activity, info));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealWithDialogWithImage(final Activity activity, final OpDialogInfo info) {
        if (!activity.isFinishing() && canShowDialog(activity, info)) {
            MainDialogManager.DialogManagerInfo dialogInfo = new MainDialogManager.DialogManagerInfo("op_biz_dialog", new MainDialogManager.IDialogInterface() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda1
                public final void onShow() {
                    OpBizDialogHelper.dealWithDialogWithImage$lambda$0(activity, info);
                }
            }, 2001);
            MainDialogManager.addDialog(dialogInfo, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealWithDialogWithImage$lambda$0(Activity $activity, OpDialogInfo $info) {
        if ($activity.isFinishing() || !INSTANCE.canShowDialog($activity, $info)) {
            MainDialogManager.showNextDialog("op_biz_dialog", false, $activity);
            return;
        }
        new OpBizDialog($activity, $info).show();
        INSTANCE.reportDialogShowInvoke($info.getReportData());
        BLog.i(TAG, "Op biz dialog showed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canShowDialog(Activity activity, OpDialogInfo info) {
        if (ClipboardJumpHelper.isClipboardJumped()) {
            reportDialogNotShow(info.getReportData(), 1);
            BLog.i(TAG, "Cannot show dialog cause clipboard jumped.");
            Neurons.trackT(false, "main.recommend.popups.no-pop.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", info.getReportData()), TuplesKt.to("reason", "2")}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda2
                public final Object invoke() {
                    boolean canShowDialog$lambda$0;
                    canShowDialog$lambda$0 = OpBizDialogHelper.canShowDialog$lambda$0();
                    return Boolean.valueOf(canShowDialog$lambda$0);
                }
            });
            return false;
        } else if (!isFirst || !checkPromoPage() || isInMutiWindowMode(activity)) {
            reportDialogNotShow(info.getReportData(), 2);
            BLog.i(TAG, "Cannot show dialog cause not at promo page.");
            Neurons.trackT(false, "main.recommend.popups.no-pop.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", info.getReportData()), TuplesKt.to("reason", "3")}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda3
                public final Object invoke() {
                    boolean canShowDialog$lambda$1;
                    canShowDialog$lambda$1 = OpBizDialogHelper.canShowDialog$lambda$1();
                    return Boolean.valueOf(canShowDialog$lambda$1);
                }
            });
            return false;
        } else if (!hasTimeout || showedMaxPrior <= 2001) {
            return true;
        } else {
            BLog.i(TAG, "Cannot show dialog cause timeout and other dialog showed.");
            Neurons.trackT(false, "main.recommend.popups.no-pop.track", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", info.getReportData()), TuplesKt.to("reason", "4")}), 1, new Function0() { // from class: tv.danmaku.bili.ui.main.opdialog.OpBizDialogHelper$$ExternalSyntheticLambda4
                public final Object invoke() {
                    boolean canShowDialog$lambda$2;
                    canShowDialog$lambda$2 = OpBizDialogHelper.canShowDialog$lambda$2();
                    return Boolean.valueOf(canShowDialog$lambda$2);
                }
            });
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canShowDialog$lambda$0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canShowDialog$lambda$1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canShowDialog$lambda$2() {
        return true;
    }

    private final boolean isInMutiWindowMode(Activity activity) {
        return activity != null && Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode();
    }

    private final boolean checkPromoPage() {
        return UriUtils.equals(BottomTabSelectedHelper.INSTANCE.getCurrentBottomTabUrl(), "bilibili://main/home") && BottomTabSelectedHelper.isRecommendPage;
    }

    private final long getBlockTimeout() {
        try {
            String str = (String) ConfigManager.Companion.config().get("main.op_dialog_timeout", "2000");
            if (str != null) {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                long it = valueOf.longValue();
                if (!(it > 0)) {
                    valueOf = null;
                }
                return valueOf != null ? valueOf.longValue() : FdDebugActivity.UPDATE_DELAY_TIME;
            }
            return FdDebugActivity.UPDATE_DELAY_TIME;
        } catch (NumberFormatException e) {
            return FdDebugActivity.UPDATE_DELAY_TIME;
        }
    }

    public final void reportDialogReceive(String reportData) {
        Neurons.reportExposure$default(false, "main.recommend.popups.get.show", MapsKt.mapOf(TuplesKt.to("report_data", reportData)), (List) null, 8, (Object) null);
    }

    private final void reportDialogNotShow(String reportData, int reason) {
        Neurons.reportClick(false, "main.recommend.popups.failed-to-pop.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", reportData), TuplesKt.to("nopop_reason", String.valueOf(reason))}));
    }

    private final void reportDialogShowInvoke(String reportData) {
        Neurons.reportExposure$default(false, "main.recommend.popups.launch.show", MapsKt.mapOf(TuplesKt.to("report_data", reportData)), (List) null, 8, (Object) null);
    }

    public final void reportDialogShow(String reportData) {
        Neurons.reportExposure$default(false, "main.recommend.popups.0.show", MapsKt.mapOf(TuplesKt.to("report_data", reportData)), (List) null, 8, (Object) null);
    }

    public final void reportDialogClick(String reportData) {
        Neurons.reportClick(false, "main.recommend.popups.0.click", MapsKt.mapOf(TuplesKt.to("report_data", reportData)));
    }

    public final void reportDialogClose(String reportData, int closeWay) {
        Neurons.reportClick(false, "main.recommend.popups.close.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("report_data", reportData), TuplesKt.to("close_way", String.valueOf(closeWay))}));
    }

    /* compiled from: OpBizDialogHelper.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020\u0014R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/main/opdialog/OpBizDialogHelper$OpDialogInfo;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "link", "", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "picUrl", "getPicUrl", "setPicUrl", "autoClose", "", "getAutoClose", "()Z", "setAutoClose", "(Z)V", "autoCloseTime", "getAutoCloseTime", "setAutoCloseTime", "reportData", "getReportData", "setReportData", "imageBm", "Landroid/graphics/Bitmap;", "getImageBm", "()Landroid/graphics/Bitmap;", "setImageBm", "(Landroid/graphics/Bitmap;)V", "isValid", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class OpDialogInfo {
        public static final int $stable = 8;
        @JSONField(name = "auto_close")
        private boolean autoClose;
        @JSONField(name = "auto_close_time")
        private long autoCloseTime;
        @JSONField(name = "id")
        private long id;
        private Bitmap imageBm;
        @JSONField(name = "link")
        private String link = "";
        @JSONField(name = "pic")
        private String picUrl = "";
        @JSONField(name = "report_data")
        private String reportData = "";

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final String getLink() {
            return this.link;
        }

        public final void setLink(String str) {
            this.link = str;
        }

        public final String getPicUrl() {
            return this.picUrl;
        }

        public final void setPicUrl(String str) {
            this.picUrl = str;
        }

        public final boolean getAutoClose() {
            return this.autoClose;
        }

        public final void setAutoClose(boolean z) {
            this.autoClose = z;
        }

        public final long getAutoCloseTime() {
            return this.autoCloseTime;
        }

        public final void setAutoCloseTime(long j) {
            this.autoCloseTime = j;
        }

        public final String getReportData() {
            return this.reportData;
        }

        public final void setReportData(String str) {
            this.reportData = str;
        }

        public final Bitmap getImageBm() {
            return this.imageBm;
        }

        public final void setImageBm(Bitmap bitmap) {
            this.imageBm = bitmap;
        }

        public final boolean isValid() {
            return true;
        }
    }
}