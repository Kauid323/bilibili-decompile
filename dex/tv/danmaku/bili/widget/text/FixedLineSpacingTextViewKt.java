package tv.danmaku.bili.widget.text;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FixedLineSpacingTextView.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toPx", "", "", "widget_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FixedLineSpacingTextViewKt {
    public static final int toPx(float $this$toPx) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return (int) (((displayMetrics != null ? displayMetrics.density : 2.0f) * $this$toPx) + 0.5f);
    }
}