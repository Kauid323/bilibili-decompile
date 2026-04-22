package kntr.app.im.chat.sticker.widget;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PopupBubbleSticker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0002\u0010\u0010\"\u0004\b\u0019\u0010\u0005¨\u0006\u001b"}, d2 = {"Lkntr/app/im/chat/sticker/widget/PopupBubbleStickerState;", RoomRecommendViewModel.EMPTY_CURSOR, "isVisible", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "pivotFractionX", "getPivotFractionX", "()F", "setPivotFractionX$sticker_debug", "(F)V", "pivotFractionX$delegate", "Landroidx/compose/runtime/MutableFloatState;", "isTop", "()Z", "setTop$sticker_debug", "isTop$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "arrowOffsetX", "getArrowOffsetX-D9Ej5fM", "setArrowOffsetX-0680j_4$sticker_debug", "arrowOffsetX$delegate", "setVisible", "isVisible$delegate", "sticker_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupBubbleStickerState {
    public static final int $stable = 0;
    private final MutableState arrowOffsetX$delegate;
    private final MutableState isTop$delegate;
    private final MutableState isVisible$delegate;
    private final MutableFloatState pivotFractionX$delegate;

    public PopupBubbleStickerState() {
        this(false, 1, null);
    }

    public PopupBubbleStickerState(boolean isVisible) {
        this.pivotFractionX$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isTop$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.arrowOffsetX$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.Companion.getUnspecified-D9Ej5fM()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isVisible), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ PopupBubbleStickerState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final float getPivotFractionX() {
        FloatState $this$getValue$iv = this.pivotFractionX$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setPivotFractionX$sticker_debug(float f) {
        MutableFloatState $this$setValue$iv = this.pivotFractionX$delegate;
        $this$setValue$iv.setFloatValue(f);
    }

    public final boolean isTop() {
        State $this$getValue$iv = this.isTop$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setTop$sticker_debug(boolean z) {
        MutableState $this$setValue$iv = this.isTop$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    /* renamed from: getArrowOffsetX-D9Ej5fM  reason: not valid java name */
    public final float m1714getArrowOffsetXD9Ej5fM() {
        State $this$getValue$iv = this.arrowOffsetX$delegate;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* renamed from: setArrowOffsetX-0680j_4$sticker_debug  reason: not valid java name */
    public final void m1715setArrowOffsetX0680j_4$sticker_debug(float f) {
        MutableState $this$setValue$iv = this.arrowOffsetX$delegate;
        Object value$iv = Dp.box-impl(f);
        $this$setValue$iv.setValue(value$iv);
    }

    public final boolean isVisible() {
        State $this$getValue$iv = this.isVisible$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setVisible(boolean z) {
        MutableState $this$setValue$iv = this.isVisible$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }
}