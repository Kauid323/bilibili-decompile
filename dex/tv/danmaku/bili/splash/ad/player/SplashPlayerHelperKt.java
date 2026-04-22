package tv.danmaku.bili.splash.ad.player;

import android.view.TextureView;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashPlayerHelper.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"centerCropVideo", "", "containerWidth", "", "containerHeight", "videoOriginWidth", "videoOriginHeight", "textureView", "Landroid/view/TextureView;", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPlayerHelperKt {
    public static final void centerCropVideo(int containerWidth, int containerHeight, int videoOriginWidth, int videoOriginHeight, TextureView textureView) {
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        int videoWith = containerWidth;
        int videoHeight = containerHeight;
        int hPadding = 0;
        int vPadding = 0;
        float wAspect = (videoWith * 1.0f) / videoOriginWidth;
        float hAspect = (videoHeight * 1.0f) / videoOriginHeight;
        if (wAspect > hAspect) {
            float actualVideoHeight = videoOriginHeight * wAspect;
            vPadding = (int) (((actualVideoHeight - videoHeight) / 2) + 0.5f);
            videoHeight = (int) (0.5f + actualVideoHeight);
        } else {
            float actualVideoWith = videoOriginWidth * hAspect;
            hPadding = (int) (((actualVideoWith - videoWith) / 2) + 0.5f);
            videoWith = (int) (0.5f + actualVideoWith);
        }
        ViewGroup.LayoutParams param = textureView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(param, "getLayoutParams(...)");
        param.width = videoWith;
        param.height = videoHeight;
        textureView.setLayoutParams(param);
        textureView.setPadding(-hPadding, -vPadding, -hPadding, -vPadding);
    }
}