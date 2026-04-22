package kntr.app.ad.ui.uikit.utils;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BlurMaskFilter.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"applyBlurMaskFilter", RoomRecommendViewModel.EMPTY_CURSOR, "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "blur", RoomRecommendViewModel.EMPTY_CURSOR, "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BlurMaskFilter_androidKt {
    public static final void applyBlurMaskFilter(Paint $this$applyBlurMaskFilter, float blur) {
        Intrinsics.checkNotNullParameter($this$applyBlurMaskFilter, "<this>");
        $this$applyBlurMaskFilter.setMaskFilter(new BlurMaskFilter(blur, BlurMaskFilter.Blur.NORMAL));
    }
}