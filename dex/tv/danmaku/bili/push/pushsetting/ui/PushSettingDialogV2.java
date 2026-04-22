package tv.danmaku.bili.push.pushsetting.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.mod.ModResource;
import com.bilibili.lib.mod.ModResourceClient;
import java.io.File;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.android.util.AppResUtil;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt;
import tv.danmaku.bili.push.pushsetting.reporter.TrackTKt;
import tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.theme.BiliTheme;
import tv.danmaku.bili.widget.BaseDialog;

/* compiled from: PushSettingDialogV2.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0017H\u0002J\u000e\u0010\u001f\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\"H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/PushSettingDialogV2;", "Ltv/danmaku/bili/widget/BaseDialog;", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", ReportUtilKt.POS_TITLE, "", "message", "typeFrom", FavoritesConstsKt.SPMID, "abMsg", "confirmAction", "", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "mTitle", "mMessage", "mTypeFrom", "mFromSpmid", "mAbMsg", "mActivity", "mImageView", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "showSystemDialogWhenDismiss", "", "onCreateView", "Landroid/view/View;", "setUiBeforeShow", "", "onStart", "reportClick", "isOpen", "showDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openSystemNotificationSetting", "Landroid/app/Activity;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingDialogV2 extends BaseDialog<PushSettingDialogV2> {
    private static final String PUSH_SETTING_GIF_DAY = "main_push_setting_day.webp";
    private static final String PUSH_SETTING_GIF_NIGHT = "main_push_setting_night.webp";
    private static final String TAG = "[Push]PushSettingDialogV2";
    private final int confirmAction;
    private String mAbMsg;
    private AppCompatActivity mActivity;
    private String mFromSpmid;
    private StaticImageView2 mImageView;
    private String mMessage;
    private String mTitle;
    private String mTypeFrom;
    private boolean showSystemDialogWhenDismiss;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingDialogV2(AppCompatActivity activity, String title, String message, String typeFrom, String spmid, String abMsg, int confirmAction) {
        super((Context) activity, true);
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(typeFrom, "typeFrom");
        Intrinsics.checkNotNullParameter(spmid, FavoritesConstsKt.SPMID);
        this.confirmAction = confirmAction;
        this.mTitle = title;
        this.mMessage = message;
        this.mTypeFrom = typeFrom;
        this.mFromSpmid = spmid;
        this.mAbMsg = abMsg;
        this.mActivity = activity;
        setOwnerActivity((Activity) activity);
        setCanceledOnTouchOutside(false);
    }

    public View onCreateView() {
        View dialogLayout = LayoutInflater.from(getContext()).inflate(R.layout.bili_app_layout_dialog_push_setting, (ViewGroup) null);
        View content = dialogLayout.findViewById(R.id.content);
        content.setBackground(ContextCompat.getDrawable(this.mActivity, com.bilibili.app.comm.baseres.R.drawable.shape_roundrect_solid_white_radius_8));
        TextView title = (TextView) dialogLayout.findViewById(R.id.text1);
        title.setText(this.mTitle);
        TextView message = (TextView) dialogLayout.findViewById(R.id.text2);
        message.setText(this.mMessage);
        View close = dialogLayout.findViewById(R.id.image_close);
        close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogV2$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingDialogV2.onCreateView$lambda$0(PushSettingDialogV2.this, view);
            }
        });
        TextView open = (TextView) dialogLayout.findViewById(R.id.text4);
        open.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogV2$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PushSettingDialogV2.onCreateView$lambda$1(PushSettingDialogV2.this, view);
            }
        });
        this.mImageView = dialogLayout.findViewById(R.id.image);
        BLog.i(TAG, "push dialog has show.");
        Intrinsics.checkNotNull(dialogLayout);
        return dialogLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(PushSettingDialogV2 this$0, View it) {
        this$0.reportClick(false);
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$1(PushSettingDialogV2 this$0, View it) {
        this$0.reportClick(true);
        if (this$0.confirmAction == 1 && SystemPushDialogHelperKt.canShowSystemPushDialog(this$0.mActivity)) {
            this$0.showSystemDialogWhenDismiss = true;
        } else {
            this$0.showSystemDialogWhenDismiss = false;
            this$0.openSystemNotificationSetting((Activity) this$0.mActivity);
        }
        this$0.dismiss();
    }

    public void setUiBeforeShow() {
        if (this.mImageView != null) {
            boolean isNightTheme = BiliTheme.isNightTheme(this.mActivity);
            ModResource modResource = ModResourceClient.getInstance().get(this.mActivity, "mainSiteAndroid", "combus_bigImages");
            Intrinsics.checkNotNullExpressionValue(modResource, "get(...)");
            String path = modResource.getResourceDirPath();
            boolean isAvailable = modResource.isAvailable();
            String str = PUSH_SETTING_GIF_NIGHT;
            if (path == null || !isAvailable) {
                ImageRequestBuilder with = BiliImageLoader.INSTANCE.with(this.mActivity);
                if (!isNightTheme) {
                    str = PUSH_SETTING_GIF_DAY;
                }
                ImageRequestBuilder enableAutoPlayAnimation$default = ImageRequestBuilder.enableAutoPlayAnimation$default(ImageRequestBuilder.placeholderImageResId$default(with.url(AppResUtil.getImageUrl(str)), isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day, (ScaleType) null, 2, (Object) null), true, false, 2, (Object) null);
                BiliImageView biliImageView = this.mImageView;
                Intrinsics.checkNotNull(biliImageView);
                enableAutoPlayAnimation$default.into(biliImageView);
                return;
            }
            File imageRes = isNightTheme ? modResource.retrieveFile(PUSH_SETTING_GIF_NIGHT) : modResource.retrieveFile(PUSH_SETTING_GIF_DAY);
            if (imageRes != null) {
                BLog.d(TAG, "use ModManager resource");
                ImageRequestBuilder enableAutoPlayAnimation$default2 = ImageRequestBuilder.enableAutoPlayAnimation$default(ImageRequestBuilder.placeholderImageResId$default(BiliImageLoader.INSTANCE.with(this.mActivity).url(BusinessSplashDefine.FILE_URI_PREFIX + imageRes.getPath()), isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day, (ScaleType) null, 2, (Object) null), true, false, 2, (Object) null);
                BiliImageView biliImageView2 = this.mImageView;
                Intrinsics.checkNotNull(biliImageView2);
                enableAutoPlayAnimation$default2.into(biliImageView2);
                return;
            }
            ImageRequestBuilder with2 = BiliImageLoader.INSTANCE.with(this.mActivity);
            if (!isNightTheme) {
                str = PUSH_SETTING_GIF_DAY;
            }
            ImageRequestBuilder enableAutoPlayAnimation$default3 = ImageRequestBuilder.enableAutoPlayAnimation$default(ImageRequestBuilder.placeholderImageResId$default(with2.url(AppResUtil.getImageUrl(str)), isNightTheme ? com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_night : com.bilibili.app.comm.baseres.R.drawable.ic_push_setting_day, (ScaleType) null, 2, (Object) null), true, false, 2, (Object) null);
            BiliImageView biliImageView3 = this.mImageView;
            Intrinsics.checkNotNull(biliImageView3);
            enableAutoPlayAnimation$default3.into(biliImageView3);
        }
    }

    protected void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setLayout(-1, -2);
        }
    }

    private final void reportClick(boolean isOpen) {
        PushSettingReporterKt.reportPushDialogClick(PushDialogType.DIY, this.mTypeFrom, this.mFromSpmid, isOpen ? "1" : "0", (r14 & 16) != 0 ? "" : "", (r14 & 32) != 0 ? null : this.mAbMsg, (r14 & 64) != 0 ? 1 : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object showDialog(Continuation<? super Unit> continuation) {
        Continuation $continuation;
        PushSettingDialogV2 pushSettingDialogV2;
        if (continuation instanceof PushSettingDialogV2$showDialog$1) {
            $continuation = (PushSettingDialogV2$showDialog$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        pushSettingDialogV2 = this;
                        $continuation.label = 1;
                        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted($continuation));
                        final Continuation continuation2 = safeContinuation;
                        try {
                            pushSettingDialogV2.show();
                            pushSettingDialogV2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: tv.danmaku.bili.push.pushsetting.ui.PushSettingDialogV2$showDialog$2$1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface it) {
                                    Continuation<Unit> continuation3 = continuation2;
                                    Result.Companion companion = Result.Companion;
                                    continuation3.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                                }
                            });
                        } catch (Throwable t) {
                            Result.Companion companion = Result.Companion;
                            continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(t)));
                        }
                        Object orThrow = safeContinuation.getOrThrow();
                        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (orThrow == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (pushSettingDialogV2.showSystemDialogWhenDismiss) {
                            pushSettingDialogV2.showSystemDialogWhenDismiss = false;
                            AppCompatActivity appCompatActivity = pushSettingDialogV2.mActivity;
                            String str = pushSettingDialogV2.mTypeFrom;
                            String str2 = pushSettingDialogV2.mFromSpmid;
                            $continuation.label = 2;
                            if (SystemPushDialogHelperKt.showSystemPushDialogSuspend(appCompatActivity, str, str2, 2, $continuation) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    case 1:
                        pushSettingDialogV2 = this;
                        ResultKt.throwOnFailure($result);
                        if (pushSettingDialogV2.showSystemDialogWhenDismiss) {
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        $continuation = new PushSettingDialogV2$showDialog$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }

    private final void openSystemNotificationSetting(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", activity.getPackageName());
        } else {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", activity.getPackageName());
            intent.putExtra("app_uid", activity.getApplicationInfo().uid);
        }
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            TrackTKt.reportTrackT("open_system_setting_failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("stack_trace", ExceptionsKt.stackTraceToString(e)), TuplesKt.to("step", "1")}));
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
            try {
                activity.startActivity(intent);
            } catch (ActivityNotFoundException e1) {
                e1.printStackTrace();
                TrackTKt.reportTrackT("open_system_setting_failed", MapsKt.mapOf(new Pair[]{TuplesKt.to("stack_trace", ExceptionsKt.stackTraceToString(e1)), TuplesKt.to("step", "2")}));
            }
        }
    }

    /* compiled from: PushSettingDialogV2.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/push/pushsetting/ui/PushSettingDialogV2$Companion;", "", "<init>", "()V", "TAG", "", "PUSH_SETTING_GIF_DAY", "PUSH_SETTING_GIF_NIGHT", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}