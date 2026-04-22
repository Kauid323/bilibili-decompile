package tv.danmaku.bili.splash.ad.page.landingpage;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.list.widget.utils.PaddingUtilsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.databinding.BiliAppListSplashImmersiveVideoLandingActivityV3Binding;
import tv.danmaku.bili.splash.ad.business.livereserve.LiveReserveTriggerType;
import tv.danmaku.bili.splash.ad.business.livereserve.SplashLiveReserveHelper;
import tv.danmaku.bili.splash.ad.model.SplashMiddlePageInfo;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.player.MiddlePageShareData;
import tv.danmaku.bili.splash.ad.player.SplashMediaPlayerManager;
import tv.danmaku.bili.splash.ad.player.SplashPlayerHelperKt;
import tv.danmaku.bili.splash.ad.reporter.ad.SplashAdHelper;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.splash.ad.utils.UiUtilsKt;

/* compiled from: SplashImmersiveVideoLandingActivityV3.kt */
@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0003*\u0001\u0019\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/splash/ad/page/landingpage/SplashImmersiveVideoLandingActivityV3;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "binding", "Ltv/danmaku/bili/adsplash/databinding/BiliAppListSplashImmersiveVideoLandingActivityV3Binding;", "tSurface", "Landroid/view/Surface;", "openSoundState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "showTime", "", "closeType", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "handlePageJump", "delayFinish", "onBackPressed", "onDestroy", "textureListener", "tv/danmaku/bili/splash/ad/page/landingpage/SplashImmersiveVideoLandingActivityV3$textureListener$1", "Ltv/danmaku/bili/splash/ad/page/landingpage/SplashImmersiveVideoLandingActivityV3$textureListener$1;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashImmersiveVideoLandingActivityV3 extends AppCompatActivity {
    public static final int $stable = 8;
    private BiliAppListSplashImmersiveVideoLandingActivityV3Binding binding;
    private long showTime;
    private Surface tSurface;
    private MutableStateFlow<Boolean> openSoundState = StateFlowKt.MutableStateFlow(false);
    private int closeType = -1;
    private final SplashImmersiveVideoLandingActivityV3$textureListener$1 textureListener = new TextureView.SurfaceTextureListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$textureListener$1
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[read]SplashImmersiveVideoLandingActivityV3", "onSurfaceTextureAvailable, width = " + width + ", height = " + height);
            SplashImmersiveVideoLandingActivityV3.this.tSurface = new Surface(surface);
            MediaPlayer player = SplashMediaPlayerManager.INSTANCE.getPlayer();
            if (player != null) {
                surface2 = SplashImmersiveVideoLandingActivityV3.this.tSurface;
                player.setSurface(surface2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            BLog.i("[read]SplashImmersiveVideoLandingActivityV3", "onSurfaceTextureSizeChanged, width = " + width + ", height = " + height);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            Surface surface2;
            Intrinsics.checkNotNullParameter(surface, "surface");
            surface2 = SplashImmersiveVideoLandingActivityV3.this.tSurface;
            if (surface2 != null) {
                surface2.release();
            }
            SplashImmersiveVideoLandingActivityV3.this.tSurface = null;
            BLog.i("[read]SplashImmersiveVideoLandingActivityV3", "onSurfaceTextureDestroyed");
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    };

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        UiUtilsKt.transportStatusBarV3((Activity) this);
        super.onCreate(savedInstanceState);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding inflate = BiliAppListSplashImmersiveVideoLandingActivityV3Binding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding = null;
        }
        setContentView((View) biliAppListSplashImmersiveVideoLandingActivityV3Binding.getRoot());
        BLog.i("[read]SplashImmersiveVideoLandingActivityV3", "centerCropVideo,start");
        initView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0128, code lost:
        if (r2.getShowLive() == 1) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        boolean z;
        MiddlePageShareData $this$initView_u24lambda_u240 = SplashMediaPlayerManager.INSTANCE.getShareData();
        this.showTime = System.currentTimeMillis();
        SplashAdHelper.INSTANCE.adReportMiddlePageExposed($this$initView_u24lambda_u240.getSplash());
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        SplashOrder splash = $this$initView_u24lambda_u240.getSplash();
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding = null;
        String adCb = splash != null ? splash.getAdCb() : null;
        SplashOrder splash2 = $this$initView_u24lambda_u240.getSplash();
        splashAdHelper.reportMiddlePageShow(adCb, splash2 != null ? splash2.getJumpUrl() : null);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding2 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding2 = null;
        }
        biliAppListSplashImmersiveVideoLandingActivityV3Binding2.videoBackground.setImageBitmap((Bitmap) $this$initView_u24lambda_u240.getTakeLatestScreenshot().invoke());
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding3 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding3 = null;
        }
        biliAppListSplashImmersiveVideoLandingActivityV3Binding3.videoLayer.setSurfaceTextureListener(this.textureListener);
        int playerWidth = $this$initView_u24lambda_u240.getPlayerWidth();
        int playerHeight = $this$initView_u24lambda_u240.getPlayerHeight();
        int videoWidth = $this$initView_u24lambda_u240.getVideoWidth();
        int videoHeight = $this$initView_u24lambda_u240.getVideoHeight();
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding4 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding4 = null;
        }
        TextureView textureView = biliAppListSplashImmersiveVideoLandingActivityV3Binding4.videoLayer;
        Intrinsics.checkNotNullExpressionValue(textureView, "videoLayer");
        SplashPlayerHelperKt.centerCropVideo(playerWidth, playerHeight, videoWidth, videoHeight, textureView);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding5 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding5 = null;
        }
        TextView textView = biliAppListSplashImmersiveVideoLandingActivityV3Binding5.tvEnterLive;
        SplashMiddlePageInfo middlePageInfo = $this$initView_u24lambda_u240.getMiddlePageInfo();
        textView.setText(middlePageInfo != null ? middlePageInfo.getBtnText() : null);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding6 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding6 = null;
        }
        TextView textView2 = biliAppListSplashImmersiveVideoLandingActivityV3Binding6.title;
        SplashMiddlePageInfo middlePageInfo2 = $this$initView_u24lambda_u240.getMiddlePageInfo();
        textView2.setText(middlePageInfo2 != null ? middlePageInfo2.getTitle() : null);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding7 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding7 = null;
        }
        TextView textView3 = biliAppListSplashImmersiveVideoLandingActivityV3Binding7.desc;
        SplashMiddlePageInfo middlePageInfo3 = $this$initView_u24lambda_u240.getMiddlePageInfo();
        textView3.setText(middlePageInfo3 != null ? middlePageInfo3.getDesc() : null);
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding8 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding8 = null;
        }
        Context context = biliAppListSplashImmersiveVideoLandingActivityV3Binding8.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ImageRequestBuilder with = biliImageLoader.with(context);
        SplashMiddlePageInfo middlePageInfo4 = $this$initView_u24lambda_u240.getMiddlePageInfo();
        ImageRequestBuilder failureImageResId$default = ImageRequestBuilder.failureImageResId$default(ImageRequestBuilder.placeholderImageResId$default(with.url(middlePageInfo4 != null ? middlePageInfo4.getLogo() : null), R.drawable.ic_default_avatar, (ScaleType) null, 2, (Object) null), R.drawable.ic_default_avatar, (ScaleType) null, 2, (Object) null);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding9 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding9 = null;
        }
        BiliImageView biliImageView = biliAppListSplashImmersiveVideoLandingActivityV3Binding9.icon;
        Intrinsics.checkNotNullExpressionValue(biliImageView, "icon");
        failureImageResId$default.into(biliImageView);
        SplashMiddlePageInfo middlePageInfo5 = $this$initView_u24lambda_u240.getMiddlePageInfo();
        if (middlePageInfo5 != null) {
            z = true;
        }
        z = false;
        if (z) {
            BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding10 = this.binding;
            if (biliAppListSplashImmersiveVideoLandingActivityV3Binding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListSplashImmersiveVideoLandingActivityV3Binding10 = null;
            }
            View view = biliAppListSplashImmersiveVideoLandingActivityV3Binding10.topLeftRoundContainer;
            Intrinsics.checkNotNullExpressionValue(view, "topLeftRoundContainer");
            PaddingUtilsKt.setPaddingEnd(view, ListExtentionsKt.toPx(0));
            BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding11 = this.binding;
            if (biliAppListSplashImmersiveVideoLandingActivityV3Binding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListSplashImmersiveVideoLandingActivityV3Binding11 = null;
            }
            biliAppListSplashImmersiveVideoLandingActivityV3Binding11.topLiveContainer.setVisibility(0);
        } else {
            BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding12 = this.binding;
            if (biliAppListSplashImmersiveVideoLandingActivityV3Binding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListSplashImmersiveVideoLandingActivityV3Binding12 = null;
            }
            biliAppListSplashImmersiveVideoLandingActivityV3Binding12.topLiveContainer.setVisibility(8);
            BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding13 = this.binding;
            if (biliAppListSplashImmersiveVideoLandingActivityV3Binding13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                biliAppListSplashImmersiveVideoLandingActivityV3Binding13 = null;
            }
            View view2 = biliAppListSplashImmersiveVideoLandingActivityV3Binding13.topLeftRoundContainer;
            Intrinsics.checkNotNullExpressionValue(view2, "topLeftRoundContainer");
            PaddingUtilsKt.setPaddingEnd(view2, ListExtentionsKt.toPx(17));
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SplashImmersiveVideoLandingActivityV3$initView$1$1(this, null), 3, (Object) null);
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding14 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding14 = null;
        }
        biliAppListSplashImmersiveVideoLandingActivityV3Binding14.muteBtn.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SplashImmersiveVideoLandingActivityV3.initView$lambda$0$0(SplashImmersiveVideoLandingActivityV3.this, view3);
            }
        });
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding15 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding15 = null;
        }
        biliAppListSplashImmersiveVideoLandingActivityV3Binding15.btnBack.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SplashImmersiveVideoLandingActivityV3.initView$lambda$0$1(SplashImmersiveVideoLandingActivityV3.this, view3);
            }
        });
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding16 = this.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            biliAppListSplashImmersiveVideoLandingActivityV3Binding = biliAppListSplashImmersiveVideoLandingActivityV3Binding16;
        }
        biliAppListSplashImmersiveVideoLandingActivityV3Binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SplashImmersiveVideoLandingActivityV3.this.handlePageJump();
            }
        });
        MediaPlayer player = SplashMediaPlayerManager.INSTANCE.getPlayer();
        if (player != null) {
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$$ExternalSyntheticLambda3
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer) {
                    SplashImmersiveVideoLandingActivityV3.initView$lambda$0$3(SplashImmersiveVideoLandingActivityV3.this, mediaPlayer);
                }
            });
        }
        ValueAnimator $this$initView_u24lambda_u241 = ValueAnimator.ofFloat(0.0f, 1.0f);
        $this$initView_u24lambda_u241.setDuration(200L);
        $this$initView_u24lambda_u241.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.splash.ad.page.landingpage.SplashImmersiveVideoLandingActivityV3$$ExternalSyntheticLambda4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashImmersiveVideoLandingActivityV3.initView$lambda$1$0(SplashImmersiveVideoLandingActivityV3.this, valueAnimator);
            }
        });
        $this$initView_u24lambda_u241.start();
        BLog.i("[read]SplashImmersiveVideoLandingActivityV3", "centerCropVideo,end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0$0(SplashImmersiveVideoLandingActivityV3 this$0, View it) {
        this$0.openSoundState.setValue(Boolean.valueOf(!((Boolean) this$0.openSoundState.getValue()).booleanValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0$1(SplashImmersiveVideoLandingActivityV3 this$0, View it) {
        this$0.closeType = 0;
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0$3(SplashImmersiveVideoLandingActivityV3 this$0, MediaPlayer it) {
        this$0.closeType = 3;
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1$0(SplashImmersiveVideoLandingActivityV3 this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BiliAppListSplashImmersiveVideoLandingActivityV3Binding biliAppListSplashImmersiveVideoLandingActivityV3Binding = this$0.binding;
        if (biliAppListSplashImmersiveVideoLandingActivityV3Binding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            biliAppListSplashImmersiveVideoLandingActivityV3Binding = null;
        }
        ConstraintLayout constraintLayout = biliAppListSplashImmersiveVideoLandingActivityV3Binding.maskLayer;
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        constraintLayout.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePageJump() {
        MiddlePageShareData data = SplashMediaPlayerManager.INSTANCE.getShareData();
        SplashOrder splash = data.getSplash();
        if (splash == null) {
            return;
        }
        long showTimeBeforeClick = System.currentTimeMillis() - this.showTime;
        SplashLiveReserveHelper.handleLiveBooking$default(SplashLiveReserveHelper.INSTANCE, (Context) this, splash, LiveReserveTriggerType.CLICK.getValue(), false, null, 24, null);
        SplashCustomReporterKt.reportSplashClick(splash, data.getJumpUrl(), "", "BUTTON", getIntent() != null ? getIntent().getDataString() : "", showTimeBeforeClick);
        SplashAdHelper.INSTANCE.adReportSplashClicked$adsplash_debug(splash, true, "resume_playback_page", (r20 & 8) != 0 ? null : "", showTimeBeforeClick, (r20 & 32) != 0, (r20 & 64) != 0 ? null : null);
        SplashAdHelper.INSTANCE.adReportMiddlePageClicked(splash);
        SplashAdHelper.INSTANCE.handleAdJump((Context) this, splash, (r18 & 4) != 0 ? "" : data.getSchema(), (r18 & 8) != 0 ? "" : data.getJumpUrl(), (r18 & 16) != 0 ? "" : null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
        SplashAdHelper.INSTANCE.reportMiddlePageClick(splash.getAdCb(), showTimeBeforeClick, splash.getJumpUrl());
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        SplashOrder splash2 = SplashMediaPlayerManager.INSTANCE.getShareData().getSplash();
        splashAdHelper.reportMiddlePageExit(splash2 != null ? splash2.getAdCb() : null, System.currentTimeMillis() - this.showTime, 2);
        delayFinish();
    }

    private final void delayFinish() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SplashImmersiveVideoLandingActivityV3$delayFinish$1(this, null), 3, (Object) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.closeType == -1) {
            this.closeType = 1;
        }
        SplashAdHelper splashAdHelper = SplashAdHelper.INSTANCE;
        SplashOrder splash = SplashMediaPlayerManager.INSTANCE.getShareData().getSplash();
        splashAdHelper.reportMiddlePageExit(splash != null ? splash.getAdCb() : null, System.currentTimeMillis() - this.showTime, this.closeType);
    }

    protected void onDestroy() {
        super.onDestroy();
        SplashMediaPlayerManager.INSTANCE.release();
    }
}