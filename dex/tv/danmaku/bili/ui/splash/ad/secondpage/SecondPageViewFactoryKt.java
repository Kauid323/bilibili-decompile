package tv.danmaku.bili.ui.splash.ad.secondpage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.button.SplashButtonHelper;
import tv.danmaku.bili.ui.splash.ad.button.model.GuideButtonViewListInfo;
import tv.danmaku.bili.ui.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.page.BaseSplash;
import tv.danmaku.bili.ui.splash.utils.UiUtils;
import tv.danmaku.bili.ui.splash.widget.SplashInteractView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SecondPageViewFactory.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005\u001a8\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015\u001a&\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0005\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005¨\u0006\u001a"}, d2 = {"generateInteractView", "Ltv/danmaku/bili/ui/splash/widget/SplashInteractView;", "ctx", "Landroid/content/Context;", "enableInteract", "", "clickOnly", "generateGuideButtonList", "Ltv/danmaku/bili/ui/splash/ad/button/model/GuideButtonViewListInfo;", "parentWidth", "", "parentHeight", "baseSplash", "Ltv/danmaku/bili/ui/splash/ad/page/BaseSplash;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "listener", "Ltv/danmaku/bili/ui/splash/ad/button/model/SplashButtonClickListener;", "generateCloseBtn", "Landroid/widget/ImageView;", "clickListener", "Landroid/view/View$OnClickListener;", "generateSoundBtn", "openSound", "generateSoundIcon", "Landroid/graphics/Bitmap;", "splash_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SecondPageViewFactoryKt {
    public static final SplashInteractView generateInteractView(Context context, boolean enableInteract, boolean clickOnly) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        SplashInteractView $this$generateInteractView_u24lambda_u240 = new SplashInteractView(ctx, null, 0, 6, null);
        $this$generateInteractView_u24lambda_u240.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        $this$generateInteractView_u24lambda_u240.setInteractEnable(enableInteract);
        $this$generateInteractView_u24lambda_u240.setVisibility(0);
        $this$generateInteractView_u24lambda_u240.setResponseClickOnly(clickOnly);
        $this$generateInteractView_u24lambda_u240.setChangeVisibilityWhenInteractForbidden(false);
        return $this$generateInteractView_u24lambda_u240;
    }

    public static final GuideButtonViewListInfo generateGuideButtonList(Context context, int parentWidth, int parentHeight, BaseSplash baseSplash, Splash splash, SplashButtonClickListener listener) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(baseSplash, "baseSplash");
        Intrinsics.checkNotNullParameter(splash, "splash");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return new SplashButtonHelper().generateSecondPageButtonList$splash_debug(ctx, parentWidth, parentHeight, splash, baseSplash, listener);
    }

    public static final ImageView generateCloseBtn(Context context, View.OnClickListener clickListener) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Bitmap bm = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.ic_close);
        if (bm == null) {
            return new ImageView(ctx);
        }
        int defaultSize = UiUtils.dp2Px(40);
        int defaultPadding = UiUtils.dp2Px(12);
        float startX = UiUtils.dp2Px(16);
        float startY = UiUtils.dp2Px(54);
        ImageView $this$generateCloseBtn_u24lambda_u240 = new ImageView(ctx);
        $this$generateCloseBtn_u24lambda_u240.setLayoutParams(new ViewGroup.LayoutParams(defaultSize, defaultSize));
        $this$generateCloseBtn_u24lambda_u240.setX(startX);
        $this$generateCloseBtn_u24lambda_u240.setY(startY);
        $this$generateCloseBtn_u24lambda_u240.setScaleType(ImageView.ScaleType.FIT_XY);
        $this$generateCloseBtn_u24lambda_u240.setPadding(defaultPadding, defaultPadding, defaultPadding, defaultPadding);
        $this$generateCloseBtn_u24lambda_u240.setImageBitmap(bm);
        $this$generateCloseBtn_u24lambda_u240.setOnClickListener(clickListener);
        return $this$generateCloseBtn_u24lambda_u240;
    }

    public static final ImageView generateSoundBtn(Context context, int parentWidth, int parentHeight, boolean openSound) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        int defaultSize = UiUtils.dp2Px(40);
        int marginRight = UiUtils.dp2Px(16);
        int marginBottom = UiUtils.dp2Px(70);
        float startX = (parentWidth - defaultSize) - marginRight;
        float startY = (parentHeight - defaultSize) - marginBottom;
        Bitmap bm = generateSoundIcon(ctx, openSound);
        if (bm == null) {
            return new ImageView(ctx);
        }
        ImageView $this$generateSoundBtn_u24lambda_u240 = new ImageView(ctx);
        $this$generateSoundBtn_u24lambda_u240.setLayoutParams(new ViewGroup.LayoutParams(defaultSize, defaultSize));
        $this$generateSoundBtn_u24lambda_u240.setX(startX);
        $this$generateSoundBtn_u24lambda_u240.setY(startY);
        $this$generateSoundBtn_u24lambda_u240.setImageBitmap(bm);
        $this$generateSoundBtn_u24lambda_u240.setScaleType(ImageView.ScaleType.FIT_XY);
        return $this$generateSoundBtn_u24lambda_u240;
    }

    public static final Bitmap generateSoundIcon(Context context, boolean openSound) {
        Context ctx = EnhancedUnmodifiabilityKt.unmodifiable(context);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        int resourceId = openSound ? tv.danmaku.bili.ui.splash.R.drawable.ic_vol_normal : tv.danmaku.bili.ui.splash.R.drawable.ic_vol_mute;
        return BitmapFactory.decodeResource(ctx.getResources(), resourceId);
    }
}