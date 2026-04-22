package kntr.common.photonic.aphro.ui.preview.utils;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function5;
import kotlin.ranges.RangesKt;

/* compiled from: DetectTransformGestures.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0093\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042u\u0010\u0005\u001aq\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00040\u0006H\u0086@¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"detectTransformGestures", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "panZoomLock", "", "onGesture", "Lkotlin/Function5;", "", "Lkotlin/ParameterName;", "name", "pointerCount", "Landroidx/compose/ui/geometry/Offset;", "centroid", "pan", "", "zoom", "rotation", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLkotlin/jvm/functions/Function5;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateOffset", "Lkotlin/Pair;", "parentSize", "Landroidx/compose/ui/geometry/Size;", "pictureSize", "scale", "offset", "calculateOffset-e7dZX2I", "(JJFJ)Lkotlin/Pair;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DetectTransformGesturesKt {
    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z, Function5 function5, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return detectTransformGestures(pointerInputScope, z, function5, continuation);
    }

    public static final Object detectTransformGestures(PointerInputScope $this$detectTransformGestures, boolean panZoomLock, Function5<? super Integer, ? super Offset, ? super Offset, ? super Float, ? super Float, Boolean> function5, Continuation<? super Unit> continuation) {
        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$detectTransformGestures, new DetectTransformGesturesKt$detectTransformGestures$2(panZoomLock, function5, null), continuation);
        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
    }

    /* renamed from: calculateOffset-e7dZX2I  reason: not valid java name */
    public static final Pair<Offset, Boolean> m2324calculateOffsete7dZX2I(long j, long j2, float scale, long j3) {
        if (Size.equals-impl0(j, Size.Companion.getUnspecified-NH-jbRc()) || Size.equals-impl0(j, Size.Companion.getZero-NH-jbRc())) {
            return new Pair<>(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), false);
        }
        int bits$iv$iv$iv = (int) (j2 >> 32);
        int bits$iv$iv$iv2 = (int) (j >> 32);
        float overWidth = RangesKt.coerceAtLeast(((Float.intBitsToFloat(bits$iv$iv$iv) * scale) - Float.intBitsToFloat(bits$iv$iv$iv2)) / 2.0f, 0.0f);
        int bits$iv$iv$iv3 = (int) (j2 & 4294967295L);
        int bits$iv$iv$iv4 = (int) (j & 4294967295L);
        float overHeight = RangesKt.coerceAtLeast(((Float.intBitsToFloat(bits$iv$iv$iv3) * scale) - Float.intBitsToFloat(bits$iv$iv$iv4)) / 2.0f, 0.0f);
        int bits$iv$iv$iv5 = (int) (j3 >> 32);
        boolean xOver = Math.abs(Float.intBitsToFloat(bits$iv$iv$iv5)) > overWidth;
        int bits$iv$iv$iv6 = (int) (j3 & 4294967295L);
        boolean yOver = Math.abs(Float.intBitsToFloat(bits$iv$iv$iv6)) > overHeight;
        int bits$iv$iv$iv7 = (int) (j3 >> 32);
        float x$iv = RangesKt.coerceIn(Float.intBitsToFloat(bits$iv$iv$iv7), -overWidth, overWidth);
        int bits$iv$iv$iv8 = (int) (j3 & 4294967295L);
        float y$iv = RangesKt.coerceIn(Float.intBitsToFloat(bits$iv$iv$iv8), -overHeight, overHeight);
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long clampOffset = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        boolean shouldConsume = (xOver && yOver) ? false : true;
        return new Pair<>(Offset.box-impl(clampOffset), Boolean.valueOf(shouldConsume));
    }
}