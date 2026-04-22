package tv.danmaku.bili.splash.ad.button.card;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.adcommon.utils.ext.AdExtensions;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.BiliImageLoaderHelper;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.magicasakura.widgets.TintImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.adsplash.databinding.BiliAppLayoutButtonAnimatedImage2Binding;
import tv.danmaku.bili.splash.ad.button.model.SplashButtonClickListener;
import tv.danmaku.bili.splash.ad.button.sensor.SplashRotateSensorHelperKt;
import tv.danmaku.bili.splash.ad.model.ExtSplashGuideButtonKt;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelper;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;

/* compiled from: SplashButtonWebpBrandCard.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aJ\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"TAG", "", "miniButtonWidth", "", "buttonRadio", "", "createWebpButtonByInteractStyle", "Landroid/view/View;", "context", "Landroid/content/Context;", "screenWidth", "screenHeight", "buttonData", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "listener", "Ltv/danmaku/bili/splash/ad/button/model/SplashButtonClickListener;", "isTwist", "", "isJumpThirdPartApp", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashButtonWebpBrandCardKt {
    private static final String TAG = "[Splash]SplashButtonWebpBrandCard";
    private static final float buttonRadio = 4.0f;
    private static final int miniButtonWidth = ListExtentionsKt.toPx(300);

    public static final View createWebpButtonByInteractStyle(Context context, int screenWidth, int screenHeight, final SplashGuideButton buttonData, SplashOrder splash, final SplashButtonClickListener listener, boolean isTwist, boolean isJumpThirdPartApp) {
        String jumpImageUrl;
        String jumpImageMD5;
        File file;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(buttonData, "buttonData");
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        Intrinsics.checkNotNullParameter(listener, "listener");
        BLog.i(TAG, "createWebpButtonByInteractStyle");
        BiliAppLayoutButtonAnimatedImage2Binding binding = BiliAppLayoutButtonAnimatedImage2Binding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
        View root = binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        int buttonHeight = (int) (screenHeight * ExtSplashGuideButtonKt.getGetHeightPercent(buttonData));
        int buttonWidth = RangesKt.coerceAtLeast((int) (buttonHeight * buttonRadio), miniButtonWidth);
        float buttonCenterX = screenWidth * ExtSplashGuideButtonKt.getGetXPercent(buttonData);
        float buttonCenterY = screenHeight * ExtSplashGuideButtonKt.getGetYPercent(buttonData);
        int webpWidth = (int) (buttonHeight * 1.3f);
        float textSize1 = 0.22f * buttonHeight;
        float textSize2 = 0.17f * buttonHeight;
        int textMaxWidth = (buttonWidth - ListExtentionsKt.toPx(58)) - webpWidth;
        TintImageView tintImageView = binding.textBackground;
        ViewGroup.LayoutParams $this$createWebpButtonByInteractStyle_u24lambda_u240 = binding.textBackground.getLayoutParams();
        $this$createWebpButtonByInteractStyle_u24lambda_u240.width = buttonWidth;
        $this$createWebpButtonByInteractStyle_u24lambda_u240.height = buttonHeight;
        tintImageView.setLayoutParams($this$createWebpButtonByInteractStyle_u24lambda_u240);
        binding.title.setMaxWidth(textMaxWidth);
        binding.subtitle.setMaxWidth(textMaxWidth);
        binding.getRoot().setLayoutParams(new ConstraintLayout.LayoutParams(buttonWidth, buttonHeight));
        root.setX(buttonCenterX - (buttonWidth / 2));
        root.setY(buttonCenterY - (buttonHeight / 2));
        BLog.i(TAG, "rootView.x=" + root.getX() + ", rootView.y=" + root.getY());
        binding.title.setText(buttonData.getBrandCardTitle());
        binding.subtitle.setText(buttonData.getBrandCardDesc());
        binding.title.setTextSize(AdExtensions.getToDp(textSize1));
        binding.subtitle.setTextSize(AdExtensions.getToDp(textSize2));
        BiliImageView biliImageView = binding.animatedImage;
        ViewGroup.LayoutParams $this$createWebpButtonByInteractStyle_u24lambda_u241 = binding.animatedImage.getLayoutParams();
        $this$createWebpButtonByInteractStyle_u24lambda_u241.width = webpWidth;
        $this$createWebpButtonByInteractStyle_u24lambda_u241.height = webpWidth;
        biliImageView.setLayoutParams($this$createWebpButtonByInteractStyle_u24lambda_u241);
        if (isJumpThirdPartApp) {
            jumpImageUrl = buttonData.getSchemaImageUrl();
        } else {
            jumpImageUrl = buttonData.getJumpImageUrl();
        }
        String imageUrl = jumpImageUrl;
        if (isJumpThirdPartApp) {
            jumpImageMD5 = buttonData.getSchemaImageMD5();
        } else {
            jumpImageMD5 = buttonData.getJumpImageMD5();
        }
        String imageHash = jumpImageMD5;
        BLog.i(TAG, "genShakeView actual used image url = " + imageUrl);
        String str = imageUrl;
        if ((str == null || StringsKt.isBlank(str)) || (file = BusinessSplashResHelper.INSTANCE.fetchResourceFileByHash(imageHash)) == null) {
            return null;
        }
        String webpResUrl = BiliImageLoaderHelper.fileToUri(file);
        BLog.i(TAG, "webpResUrl=" + webpResUrl);
        ImageRequestBuilder noLimitWidth = BiliImageLoader.INSTANCE.with(context).url(webpResUrl).overrideHeight(webpWidth).noLimitWidth();
        ScaleType scaleType = ScaleType.FIT_CENTER;
        Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
        ImageRequestBuilder fadeDuration = ImageRequestBuilder.enableAutoPlayAnimation$default(noLimitWidth.actualImageScaleType(scaleType), true, false, 2, (Object) null).fadeDuration(0);
        BiliImageView biliImageView2 = binding.animatedImage;
        Intrinsics.checkNotNullExpressionValue(biliImageView2, "animatedImage");
        fadeDuration.into(biliImageView2);
        if (!isTwist) {
            i = 1;
        } else {
            View root2 = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            View view = root2;
            View root3 = binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root3, "getRoot(...)");
            i = 1;
            SplashRotateSensorHelperKt.addRotateSensor(context, view, root3, buttonData, splash, listener);
        }
        if (buttonData.getExtInteractStyle() == i) {
            root.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.splash.ad.button.card.SplashButtonWebpBrandCardKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SplashButtonClickListener.this.onClick(buttonData);
                }
            });
        } else {
            root.setOnClickListener((View.OnClickListener) null);
        }
        return root;
    }
}