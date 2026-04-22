package tv.danmaku.bili.splash.ad.utils;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.ui.unit.Dp;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bilibili.base.BiliContext;
import com.bilibili.lib.ui.util.StatusBarCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: UiUtils.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b\u001a0\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\u0017"}, d2 = {"toDp", "Landroidx/compose/ui/unit/Dp;", "", "getToDp", "(F)F", "pxToDp", "getPxToDp", "tintDrawable", "Landroid/graphics/drawable/Drawable;", "origin", GarbJsBridgeCallHandlerKt.PURE_THEME, "", "centerCropVideo", "", "containerWidth", "containerHeight", "videoOriginWidth", "videoOriginHeight", "textureView", "Landroid/view/TextureView;", "transportStatusBarV3", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UiUtilsKt {
    public static final float getToDp(float $this$toDp) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float $this$dp$iv = $this$toDp / (displayMetrics != null ? displayMetrics.density : 2.0f);
        return Dp.constructor-impl($this$dp$iv);
    }

    public static final float getPxToDp(float $this$pxToDp) {
        Resources resources;
        Application application = BiliContext.application();
        if (application == null || (resources = application.getResources()) == null) {
            return $this$pxToDp;
        }
        float density = resources.getDisplayMetrics().density;
        return $this$pxToDp / density;
    }

    public static final Drawable tintDrawable(Drawable origin, int color) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Drawable wrapper = DrawableCompat.wrap(origin.mutate());
        DrawableCompat.setTint(wrapper, color);
        Intrinsics.checkNotNull(wrapper);
        return wrapper;
    }

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

    public static final void transportStatusBarV3(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(StatusBarCompat.setNavigationBarMode(activity, systemUiVisibility | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText, false));
        window.setStatusBarColor(0);
    }
}