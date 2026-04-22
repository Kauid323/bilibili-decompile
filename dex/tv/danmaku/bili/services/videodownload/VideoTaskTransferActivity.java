package tv.danmaku.bili.services.videodownload;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import com.bilibili.pvtracker.IPvTracker;
import com.bilibili.pvtracker.PageViewTracker;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer;

/* compiled from: VideoTaskTransferActivity.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0002J\b\u00102\u001a\u00020(H\u0002J\b\u00103\u001a\u00020(H\u0016J\b\u00104\u001a\u00020(H\u0014J\b\u00105\u001a\u00020(H\u0002J\"\u00106\u001a\u00020(2\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020/2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u00020*H\u0016J\b\u0010<\u001a\u00020=H\u0016J\u0014\u0010>\u001a\u00020(*\u00020\u00192\u0006\u0010.\u001a\u00020=H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0013\u001a\n \t*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R#\u0010\u0018\u001a\n \t*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \t*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001e\u0010\u001bR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b$\u0010%¨\u0006@"}, d2 = {"Ltv/danmaku/bili/services/videodownload/VideoTaskTransferActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "isSuccess", "", "mButton", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getMButton", "()Landroid/view/View;", "mButton$delegate", "Lkotlin/Lazy;", "mImage", "Landroid/widget/ImageView;", "getMImage", "()Landroid/widget/ImageView;", "mImage$delegate", "mProgress", "Lcom/bilibili/magicasakura/widgets/TintProgressBar;", "getMProgress", "()Lcom/bilibili/magicasakura/widgets/TintProgressBar;", "mProgress$delegate", "mProgressText", "Landroid/widget/TextView;", "getMProgressText", "()Landroid/widget/TextView;", "mProgressText$delegate", "mTips", "getMTips", "mTips$delegate", "mAutoCloseAction", "Ljava/lang/Runnable;", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "tintStatusBar", "initViews", "updateProgress", "progress", "", "showLoading", "showSuccess", "showFail", "onBackPressed", "onDestroy", "updatePvExtra", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "getPvExtra", "getPvEventId", "", "setProgress", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VideoTaskTransferActivity extends BaseToolbarActivity implements IPvTracker {
    private static final String PV_ID = "main.file-transfer.0.0.pv";
    private static final String PV_STATUS = "status";
    private boolean isSuccess;
    private Runnable mAutoCloseAction;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy mButton$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda0
        public final Object invoke() {
            View mButton_delegate$lambda$0;
            mButton_delegate$lambda$0 = VideoTaskTransferActivity.mButton_delegate$lambda$0(VideoTaskTransferActivity.this);
            return mButton_delegate$lambda$0;
        }
    });
    private final Lazy mImage$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda1
        public final Object invoke() {
            ImageView mImage_delegate$lambda$0;
            mImage_delegate$lambda$0 = VideoTaskTransferActivity.mImage_delegate$lambda$0(VideoTaskTransferActivity.this);
            return mImage_delegate$lambda$0;
        }
    });
    private final Lazy mProgress$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda2
        public final Object invoke() {
            TintProgressBar mProgress_delegate$lambda$0;
            mProgress_delegate$lambda$0 = VideoTaskTransferActivity.mProgress_delegate$lambda$0(VideoTaskTransferActivity.this);
            return mProgress_delegate$lambda$0;
        }
    });
    private final Lazy mProgressText$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda3
        public final Object invoke() {
            TextView mProgressText_delegate$lambda$0;
            mProgressText_delegate$lambda$0 = VideoTaskTransferActivity.mProgressText_delegate$lambda$0(VideoTaskTransferActivity.this);
            return mProgressText_delegate$lambda$0;
        }
    });
    private final Lazy mTips$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda4
        public final Object invoke() {
            TextView mTips_delegate$lambda$0;
            mTips_delegate$lambda$0 = VideoTaskTransferActivity.mTips_delegate$lambda$0(VideoTaskTransferActivity.this);
            return mTips_delegate$lambda$0;
        }
    });
    private final Lazy mHandler$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda5
        public final Object invoke() {
            Handler mHandler_delegate$lambda$0;
            mHandler_delegate$lambda$0 = VideoTaskTransferActivity.mHandler_delegate$lambda$0();
            return mHandler_delegate$lambda$0;
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    private final View getMButton() {
        return (View) this.mButton$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View mButton_delegate$lambda$0(VideoTaskTransferActivity this$0) {
        return this$0.findViewById(R.id.close);
    }

    private final ImageView getMImage() {
        return (ImageView) this.mImage$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageView mImage_delegate$lambda$0(VideoTaskTransferActivity this$0) {
        return (ImageView) this$0.findViewById(R.id.image);
    }

    private final TintProgressBar getMProgress() {
        return (TintProgressBar) this.mProgress$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TintProgressBar mProgress_delegate$lambda$0(VideoTaskTransferActivity this$0) {
        return this$0.findViewById(R.id.progress);
    }

    private final TextView getMProgressText() {
        return (TextView) this.mProgressText$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mProgressText_delegate$lambda$0(VideoTaskTransferActivity this$0) {
        return (TextView) this$0.findViewById(R.id.progress_text);
    }

    private final TextView getMTips() {
        return (TextView) this.mTips$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextView mTips_delegate$lambda$0(VideoTaskTransferActivity this$0) {
        return (TextView) this$0.findViewById(R.id.tips);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler getMHandler() {
        return (Handler) this.mHandler$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mHandler_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.bili_activity_app_video_task_transfer);
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            finish();
            return;
        }
        tintStatusBar();
        this.mToolbar = findViewById(R.id.nav_top_bar);
        this.mToolbar.setNavigationIcon(androidx.appcompat.R.drawable.abc_ic_ab_back_material);
        setSupportActionBar(this.mToolbar);
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoTaskTransferActivity.onCreate$lambda$0(VideoTaskTransferActivity.this, view);
            }
        });
        setTitle(getString(bili.resource.homepage.R.string.homepage_global_string_152));
        initViews();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(VideoTaskTransferActivity this$0, View it) {
        this$0.updatePvExtra();
        this$0.finish();
    }

    private final void tintStatusBar() {
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure() || garb.isPrimaryOnly()) {
            StatusBarCompat.tintStatusBar((Activity) this, ThemeUtils.getThemeAttrColor((Context) this, androidx.appcompat.R.attr.colorPrimary));
        } else {
            StatusBarCompat.tintStatusBar((Activity) this, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
    }

    private final void initViews() {
        showLoading();
        DownloadTaskTransfer.INSTANCE.doTransfer((AppCompatActivity) this, new VideoTaskTransferActivity$initViews$1(this));
        View mButton = getMButton();
        if (mButton != null) {
            mButton.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoTaskTransferActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateProgress(int progress) {
        ObjectAnimator.ofInt(getMProgress(), "progress", progress).start();
        TextView mProgressText = getMProgressText();
        Intrinsics.checkNotNullExpressionValue(mProgressText, "<get-mProgressText>(...)");
        setProgress(mProgressText, String.valueOf(progress));
    }

    private final void showLoading() {
        getMButton().setVisibility(8);
        getMProgress().setVisibility(0);
        getMImage().setImageResource(tv.danmaku.biliplayer.baseres.R.drawable.bili_app_video_detail_topic_loading);
        Drawable drawable = getMImage().getDrawable();
        AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
        if (animationDrawable != null) {
            animationDrawable.start();
        }
        getMTips().setText(getString(bili.resource.homepage.R.string.homepage_global_string_122));
        int progress = DownloadTaskTransfer.INSTANCE.getProgress();
        getMProgress().setProgress(progress);
        TextView mProgressText = getMProgressText();
        Intrinsics.checkNotNullExpressionValue(mProgressText, "<get-mProgressText>(...)");
        setProgress(mProgressText, String.valueOf(progress));
        getMProgressText().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccess() {
        getMButton().setVisibility(0);
        getMProgress().setVisibility(8);
        getMProgressText().setVisibility(8);
        Drawable drawable = getMImage().getDrawable();
        AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        getMImage().setImageResource(com.bilibili.app.comm.baseres.R.drawable.ic_question_result_success);
        getMTips().setText(getString(bili.resource.homepage.R.string.homepage_global_string_171));
        getMProgress().setProgress(DownloadTaskTransfer.INSTANCE.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFail() {
        getMButton().setVisibility(0);
        getMProgress().setVisibility(8);
        getMProgressText().setVisibility(8);
        Drawable drawable = getMImage().getDrawable();
        AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        getMImage().setImageResource(com.bilibili.app.comm.baseres.R.drawable.bili_2233_fail);
        getMTips().setText(getString(bili.resource.homepage.R.string.homepage_global_string_166));
        getMProgress().setProgress(DownloadTaskTransfer.INSTANCE.getProgress());
    }

    public void onBackPressed() {
        updatePvExtra();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        DownloadTaskTransfer.INSTANCE.release();
        Runnable $this$onDestroy_u24lambda_u240 = this.mAutoCloseAction;
        if ($this$onDestroy_u24lambda_u240 != null) {
            getMHandler().removeCallbacks($this$onDestroy_u24lambda_u240);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePvExtra() {
        Bundle b = new Bundle();
        b.putString(PV_STATUS, DownloadTaskTransfer.INSTANCE.isProcessing() ? "1" : "2");
        PageViewTracker.getInstance().setExtra((Activity) this, PV_ID, b);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DownloadTaskTransfer.INSTANCE.onActivityResult((Activity) this, requestCode, resultCode, data);
    }

    public Bundle getPvExtra() {
        Bundle b = new Bundle();
        b.putString(PV_STATUS, "1");
        return b;
    }

    public String getPvEventId() {
        return PV_ID;
    }

    /* compiled from: VideoTaskTransferActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/services/videodownload/VideoTaskTransferActivity$Companion;", "", "<init>", "()V", "PV_ID", "", "PV_STATUS", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void setProgress(TextView $this$setProgress, String progress) {
        $this$setProgress.setText(getString(R.string.bili_app_video_transfer_progress_text, new Object[]{progress}));
    }
}