package tv.danmaku.biliplayerv2;

import android.app.Application;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.bilibili.base.BiliContext;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NewPlayerUtils.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0002*\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007\u001a \u0010\n\u001a\u00020\u000b*\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"toPx", "", "", "toFloatPx", "spToPx", "setVisibleOrGone", "", "Landroid/view/View;", "visible", "", "ifNullOrBlank", "", "block", "Lkotlin/Function0;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NewPlayerUtilsKt {
    public static final int toPx(float $this$toPx) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Application application = BiliContext.application();
        float scale = (application == null || (resources = application.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : displayMetrics.density;
        return MathKt.roundToInt(($this$toPx * scale) + 0.5f);
    }

    public static final float toFloatPx(float $this$toFloatPx) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Application application = BiliContext.application();
        float scale = (application == null || (resources = application.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : displayMetrics.density;
        return ($this$toFloatPx * scale) + 0.5f;
    }

    public static final int toPx(int $this$toPx) {
        return toPx($this$toPx);
    }

    public static final float spToPx(int $this$spToPx) {
        Resources resources;
        DisplayMetrics displayMetrics;
        float scale = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        if ($this$spToPx <= 0) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        Application application = BiliContext.application();
        if (application != null && (resources = application.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            scale = displayMetrics.density;
        }
        return $this$spToPx * scale;
    }

    @Deprecated(message = "Switch to View.isVisible = visible", replaceWith = @ReplaceWith(expression = "this.isVisible = visible", imports = {"androidx.core.view.isVisible"}))
    public static final void setVisibleOrGone(View $this$setVisibleOrGone, boolean visible) {
        Intrinsics.checkNotNullParameter($this$setVisibleOrGone, "<this>");
        $this$setVisibleOrGone.setVisibility(visible ? 0 : 8);
    }

    public static final String ifNullOrBlank(String $this$ifNullOrBlank, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        String str = $this$ifNullOrBlank;
        if (str == null || StringsKt.isBlank(str)) {
            return (String) function0.invoke();
        }
        return $this$ifNullOrBlank;
    }
}