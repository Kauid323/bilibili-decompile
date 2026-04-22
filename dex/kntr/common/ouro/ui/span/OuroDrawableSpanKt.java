package kntr.common.ouro.ui.span;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawableSpan.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"isValid", "", "Landroid/graphics/drawable/Drawable;", "TAG", "", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDrawableSpanKt {
    private static final String TAG = "OuroDrawableSpan";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isValid(Drawable $this$isValid) {
        if ($this$isValid instanceof BitmapDrawable) {
            return !((BitmapDrawable) $this$isValid).getBitmap().isRecycled();
        }
        if (Intrinsics.areEqual($this$isValid.getCurrent(), $this$isValid)) {
            return true;
        }
        Drawable current = $this$isValid.getCurrent();
        Intrinsics.checkNotNullExpressionValue(current, "getCurrent(...)");
        return isValid(current);
    }
}