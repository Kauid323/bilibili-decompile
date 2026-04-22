package kntr.base.imageloader;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.unit.IntSize;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: LottiePainter.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0082\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "Landroid/graphics/drawable/Drawable;", "getIntrinsicSize", "(Landroid/graphics/drawable/Drawable;)J", "times", "Landroidx/compose/ui/unit/IntSize;", "scale", "Landroidx/compose/ui/layout/ScaleFactor;", "times-UQTWf7w", "(JJ)J", "imageloader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LottiePainterKt {
    private static final Lazy MAIN_HANDLER$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: kntr.base.imageloader.LottiePainterKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            Handler MAIN_HANDLER_delegate$lambda$0;
            MAIN_HANDLER_delegate$lambda$0 = LottiePainterKt.MAIN_HANDLER_delegate$lambda$0();
            return MAIN_HANDLER_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler getMAIN_HANDLER() {
        return (Handler) MAIN_HANDLER$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler MAIN_HANDLER_delegate$lambda$0() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getIntrinsicSize(Drawable $this$intrinsicSize) {
        if ($this$intrinsicSize.getIntrinsicWidth() >= 0 && $this$intrinsicSize.getIntrinsicHeight() >= 0) {
            float width$iv = $this$intrinsicSize.getIntrinsicWidth();
            float height$iv = $this$intrinsicSize.getIntrinsicHeight();
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            return androidx.compose.ui.geometry.Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
        }
        return androidx.compose.ui.geometry.Size.Companion.getUnspecified-NH-jbRc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: times-UQTWf7w  reason: not valid java name */
    public static final long m1507timesUQTWf7w(long j, long j2) {
        int bits$iv$iv$iv = (int) (j >> 32);
        int bits$iv$iv$iv2 = (int) (j2 >> 32);
        int width$iv = (int) (Float.intBitsToFloat(bits$iv$iv$iv) * Float.intBitsToFloat(bits$iv$iv$iv2));
        int bits$iv$iv$iv3 = (int) (j & 4294967295L);
        int bits$iv$iv$iv4 = (int) (j2 & 4294967295L);
        int height$iv = (int) (Float.intBitsToFloat(bits$iv$iv$iv3) * Float.intBitsToFloat(bits$iv$iv$iv4));
        return IntSize.constructor-impl((width$iv << 32) | (4294967295L & height$iv));
    }
}