package tv.danmaku.bili.splash.ad.utils.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: ViewLayerUtil.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"findIndexInParent", "", "Landroid/view/View;", "splashwidget_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ViewLayerUtilKt {
    public static final int findIndexInParent(View $this$findIndexInParent) {
        if ($this$findIndexInParent == null) {
            return -1;
        }
        ViewParent parent = $this$findIndexInParent.getParent();
        ViewGroup vg = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (vg == null) {
            return -1;
        }
        int childCount = vg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            int index = i;
            if (Intrinsics.areEqual(vg.getChildAt(index), $this$findIndexInParent)) {
                return index;
            }
        }
        return -1;
    }
}