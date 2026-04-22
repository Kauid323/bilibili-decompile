package kntr.app.deepsearch.ui.paragraph.text;

import android.os.Build;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* compiled from: UnderlineWidth.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"underlineWidth", "Landroidx/compose/ui/unit/Dp;", "getUnderlineWidth", "()F", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UnderlineWidthKt {
    public static final float getUnderlineWidth() {
        if (Build.VERSION.SDK_INT >= 26) {
            float $this$dp$iv = Dp.constructor-impl(1.6f);
            return $this$dp$iv;
        }
        float $this$dp$iv2 = Dp.constructor-impl(0.5f);
        return $this$dp$iv2;
    }
}