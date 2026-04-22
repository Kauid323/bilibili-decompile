package tv.danmaku.bili.ui.widget;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthBottomSheetDialog.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a\u001d\u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\b\u001a\u001d\u0010\n\u001a\u0004\u0018\u0001H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u0007*\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\b\u001a*\u0010\u000b\u001a\u00020\f*\u00020\u00072\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001¨\u0006\u0011"}, d2 = {"toPx", "", "", "toVisibility", "", "visible", "T", "Landroid/view/View;", "(Landroid/view/View;)Landroid/view/View;", "gone", "invisible", "setMargin", "", "top", "left", "right", "bottom", "auth_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthBottomSheetDialogKt {
    public static final int toPx(int $this$toPx) {
        float f = $this$toPx;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) ((f * (displayMetrics != null ? displayMetrics.density : 2.0f)) + 0.5f);
    }

    public static final int toPx(double $this$toPx) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) (((displayMetrics != null ? displayMetrics.density : 2.0f) * $this$toPx) + 0.5f);
    }

    public static final int toVisibility(boolean $this$toVisibility) {
        return $this$toVisibility ? 0 : 8;
    }

    public static final <T extends View> T visible(T t) {
        if (t != null) {
            t.setVisibility(0);
        }
        return t;
    }

    public static final <T extends View> T gone(T t) {
        if (t != null) {
            t.setVisibility(8);
        }
        return t;
    }

    public static final <T extends View> T invisible(T t) {
        if (t != null) {
            t.setVisibility(4);
        }
        return t;
    }

    public static final void setMargin(View $this$setMargin, int top, int left, int right, int bottom) {
        Intrinsics.checkNotNullParameter($this$setMargin, "<this>");
        ViewGroup.LayoutParams layoutParams = $this$setMargin.getLayoutParams();
        ViewGroup.MarginLayoutParams layoutParams2 = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.setMargins(left, top, right, bottom);
        $this$setMargin.setLayoutParams(layoutParams2);
    }
}