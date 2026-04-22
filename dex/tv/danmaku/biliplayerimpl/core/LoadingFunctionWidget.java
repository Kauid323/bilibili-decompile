package tv.danmaku.biliplayerimpl.core;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import bili.resource.playerbaseres.R;
import com.airbnb.lottie.LottieAnimationView;
import com.bilibili.droid.thread.HandlerThreads;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerConfiguration;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.PlayerParamsV2;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: LoadingFunctionWidget.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0016J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020!8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/LoadingFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "tag", "", "getTag", "()Ljava/lang/String;", "mRootView", "Landroid/widget/LinearLayout;", "mLoadingImg", "Lcom/airbnb/lottie/LottieAnimationView;", "mLoadingTip", "Landroid/widget/TextView;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "createContentView", "Landroid/view/View;", "onWidgetShow", "", "onWidgetDismiss", "onConfigurationChanged", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "startNetBuffSpeedRunner", "stopNetBuffSpeedRunner", "mBuffSpeedRunnable", "Ljava/lang/Runnable;", "mDelayRunnable", "onRelease", "bindPlayerContainer", "playerContainer", "Configuration", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class LoadingFunctionWidget extends AbsFunctionWidget {
    private final Runnable mBuffSpeedRunnable;
    private final Runnable mDelayRunnable;
    private LottieAnimationView mLoadingImg;
    private TextView mLoadingTip;
    private PlayerContainer mPlayerContainer;
    private LinearLayout mRootView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingFunctionWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBuffSpeedRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.core.LoadingFunctionWidget$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoadingFunctionWidget.mBuffSpeedRunnable$lambda$0(LoadingFunctionWidget.this);
            }
        };
        this.mDelayRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.core.LoadingFunctionWidget$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                LoadingFunctionWidget.mDelayRunnable$lambda$0(LoadingFunctionWidget.this);
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public FunctionWidgetConfig getFunctionWidgetConfig() {
        FunctionWidgetConfig.Builder builder = new FunctionWidgetConfig.Builder();
        builder.persistent(true);
        builder.dismissWhenVideoCompleted(true);
        builder.dismissWhenVideoChange(false);
        builder.dismissWhenScreenModeChange(false);
        builder.dismissWhenActivityStop(false);
        builder.launchType(2);
        return builder.build();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public String getTag() {
        return "LoadingFunctionWidget";
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected View createContentView(Context context) {
        PlayerParamsV2 playerParams;
        PlayerConfiguration config;
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout $this$createContentView_u24lambda_u240 = new LinearLayout(context);
        $this$createContentView_u24lambda_u240.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int i = 1;
        $this$createContentView_u24lambda_u240.setOrientation(1);
        $this$createContentView_u24lambda_u240.setGravity(17);
        $this$createContentView_u24lambda_u240.setVisibility(8);
        this.mRootView = $this$createContentView_u24lambda_u240;
        LottieAnimationView $this$createContentView_u24lambda_u241 = new LottieAnimationView(context);
        $this$createContentView_u24lambda_u241.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        $this$createContentView_u24lambda_u241.setRepeatCount(-1);
        this.mLoadingImg = $this$createContentView_u24lambda_u241;
        LinearLayout linearLayout = this.mRootView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            linearLayout = null;
        }
        LottieAnimationView lottieAnimationView = this.mLoadingImg;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
            lottieAnimationView = null;
        }
        linearLayout.addView((View) lottieAnimationView);
        TextView $this$createContentView_u24lambda_u242 = new TextView(context);
        $this$createContentView_u24lambda_u242.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        $this$createContentView_u24lambda_u242.setGravity(17);
        $this$createContentView_u24lambda_u242.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        $this$createContentView_u24lambda_u242.setMarqueeRepeatLimit(0);
        $this$createContentView_u24lambda_u242.setShadowLayer(3.0f, 2.0f, 2.0f, -11908534);
        $this$createContentView_u24lambda_u242.setSingleLine(true);
        $this$createContentView_u24lambda_u242.setText(context.getString(R.string.playerbaseres_global_string_1364));
        $this$createContentView_u24lambda_u242.setTextColor(-1);
        this.mLoadingTip = $this$createContentView_u24lambda_u242;
        LinearLayout linearLayout3 = this.mRootView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            linearLayout3 = null;
        }
        TextView textView = this.mLoadingTip;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTip");
            textView = null;
        }
        linearLayout3.addView(textView);
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (playerParams = playerContainer.getPlayerParams()) != null && (config = playerParams.getConfig()) != null) {
            i = config.getTheme();
        }
        int theme = i;
        if (theme == 2) {
            LottieAnimationView lottieAnimationView2 = this.mLoadingImg;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setAnimation("player_loading_tv_green.json");
        } else {
            LottieAnimationView lottieAnimationView3 = this.mLoadingImg;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setAnimation("player_loading_tv.json");
        }
        LinearLayout linearLayout4 = this.mRootView;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            linearLayout2 = linearLayout4;
        }
        return linearLayout2;
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        PlayerParamsV2 playerParams;
        PlayerConfiguration config;
        super.onWidgetShow();
        LottieAnimationView lottieAnimationView = this.mLoadingImg;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
            lottieAnimationView = null;
        }
        lottieAnimationView.playAnimation();
        PlayerContainer playerContainer = this.mPlayerContainer;
        long delayTime = (playerContainer == null || (playerParams = playerContainer.getPlayerParams()) == null || (config = playerParams.getConfig()) == null) ? 0L : config.getMLoadingDelayTime();
        HandlerThreads.postDelayed(0, this.mDelayRunnable, delayTime);
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        super.onWidgetDismiss();
        HandlerThreads.remove(0, this.mDelayRunnable);
        stopNetBuffSpeedRunner();
        LottieAnimationView lottieAnimationView = this.mLoadingImg;
        LinearLayout linearLayout = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
            lottieAnimationView = null;
        }
        lottieAnimationView.cancelAnimation();
        LinearLayout linearLayout2 = this.mRootView;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public void onConfigurationChanged(AbsFunctionWidget.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (configuration instanceof Configuration) {
            LottieAnimationView lottieAnimationView = this.mLoadingImg;
            TextView textView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
                lottieAnimationView = null;
            }
            lottieAnimationView.setAnimation(((Configuration) configuration).getAnimatorFile());
            TextView textView2 = this.mLoadingTip;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingTip");
            } else {
                textView = textView2;
            }
            textView.setText(((Configuration) configuration).getTip());
        }
    }

    private final void startNetBuffSpeedRunner() {
        HandlerThreads.postDelayed(0, this.mBuffSpeedRunnable, 1000L);
    }

    private final void stopNetBuffSpeedRunner() {
        HandlerThreads.remove(0, this.mBuffSpeedRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mBuffSpeedRunnable$lambda$0(LoadingFunctionWidget this$0) {
        String text;
        long j;
        IPlayerCoreService playerCoreService;
        PlayerContainer playerContainer = this$0.mPlayerContainer;
        TextView textView = null;
        Long speed = (playerContainer == null || (playerCoreService = playerContainer.getPlayerCoreService()) == null) ? null : Long.valueOf(playerCoreService.getTcpSpeed());
        if (speed != null && speed.longValue() >= 0) {
            Long speed2 = Long.valueOf(speed.longValue() / 1024);
            text = speed2.longValue() < 1024 ? this$0.getMContext().getString(R.string.playerbaseres_global_string_1364) + speed2 + "KB/s" : this$0.getMContext().getString(R.string.playerbaseres_global_string_1364) + (speed2.longValue() / j) + "MB/s";
        } else {
            text = this$0.getMContext().getString(R.string.playerbaseres_global_string_1364);
            Intrinsics.checkNotNull(text);
        }
        TextView textView2 = this$0.mLoadingTip;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTip");
            textView2 = null;
        }
        if (!Intrinsics.areEqual(textView2.getText(), text)) {
            TextView textView3 = this$0.mLoadingTip;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoadingTip");
            } else {
                textView = textView3;
            }
            textView.setText(text);
        }
        this$0.startNetBuffSpeedRunner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mDelayRunnable$lambda$0(LoadingFunctionWidget this$0) {
        HandlerThreads.remove(0, this$0.mBuffSpeedRunnable);
        TextView textView = this$0.mLoadingTip;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingTip");
            textView = null;
        }
        textView.setText(this$0.getMContext().getString(R.string.playerbaseres_global_string_1364));
        LinearLayout linearLayout = this$0.mRootView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        LottieAnimationView lottieAnimationView2 = this$0.mLoadingImg;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingImg");
        } else {
            lottieAnimationView = lottieAnimationView2;
        }
        lottieAnimationView.playAnimation();
        this$0.startNetBuffSpeedRunner();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onRelease() {
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    /* compiled from: LoadingFunctionWidget.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Ltv/danmaku/biliplayerimpl/core/LoadingFunctionWidget$Configuration;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "animatorFile", "", "tip", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAnimatorFile", "()Ljava/lang/String;", "setAnimatorFile", "(Ljava/lang/String;)V", "getTip", "setTip", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Configuration extends AbsFunctionWidget.Configuration {
        private String animatorFile;
        private String tip;

        public Configuration(String animatorFile, String tip) {
            Intrinsics.checkNotNullParameter(animatorFile, "animatorFile");
            Intrinsics.checkNotNullParameter(tip, "tip");
            this.animatorFile = animatorFile;
            this.tip = tip;
        }

        public final String getAnimatorFile() {
            return this.animatorFile;
        }

        public final String getTip() {
            return this.tip;
        }

        public final void setAnimatorFile(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.animatorFile = str;
        }

        public final void setTip(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.tip = str;
        }
    }
}