package kntr.app.im.chat.ui.widget;

import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupBubbleMenu.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0005R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00148F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u0002\u0010\u0010\"\u0004\b\u0019\u0010\u0005¨\u0006\u001c"}, d2 = {"Lkntr/app/im/chat/ui/widget/PopupState;", RoomRecommendViewModel.EMPTY_CURSOR, "isVisible", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "pivotFractionX", "getPivotFractionX", "()F", "setPivotFractionX$ui_debug", "(F)V", "pivotFractionX$delegate", "Landroidx/compose/runtime/MutableFloatState;", "isTop", "()Z", "setTop$ui_debug", "isTop$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/Dp;", "arrowOffsetX", "getArrowOffsetX-D9Ej5fM", "setArrowOffsetX-0680j_4$ui_debug", "arrowOffsetX$delegate", "setVisible", "isVisible$delegate", "Companion", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PopupState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Saver<PopupState, Map<String, Object>> saver = SaverKt.Saver(new Function2() { // from class: kntr.app.im.chat.ui.widget.PopupState$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            Map saver$lambda$0;
            saver$lambda$0 = PopupState.saver$lambda$0((SaverScope) obj, (PopupState) obj2);
            return saver$lambda$0;
        }
    }, new Function1() { // from class: kntr.app.im.chat.ui.widget.PopupState$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            PopupState saver$lambda$1;
            saver$lambda$1 = PopupState.saver$lambda$1((Map) obj);
            return saver$lambda$1;
        }
    });
    private final MutableState arrowOffsetX$delegate;
    private final MutableState isTop$delegate;
    private final MutableState isVisible$delegate;
    private final MutableFloatState pivotFractionX$delegate;

    public PopupState() {
        this(false, 1, null);
    }

    public PopupState(boolean isVisible) {
        this.pivotFractionX$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isTop$delegate = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.arrowOffsetX$delegate = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.Companion.getUnspecified-D9Ej5fM()), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isVisible$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(isVisible), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public /* synthetic */ PopupState(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final float getPivotFractionX() {
        FloatState $this$getValue$iv = this.pivotFractionX$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    public final void setPivotFractionX$ui_debug(float f) {
        MutableFloatState $this$setValue$iv = this.pivotFractionX$delegate;
        $this$setValue$iv.setFloatValue(f);
    }

    public final boolean isTop() {
        State $this$getValue$iv = this.isTop$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setTop$ui_debug(boolean z) {
        MutableState $this$setValue$iv = this.isTop$delegate;
        Object value$iv = Boolean.valueOf(z);
        $this$setValue$iv.setValue(value$iv);
    }

    /* renamed from: getArrowOffsetX-D9Ej5fM  reason: not valid java name */
    public final float m1983getArrowOffsetXD9Ej5fM() {
        State $this$getValue$iv = this.arrowOffsetX$delegate;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* renamed from: setArrowOffsetX-0680j_4$ui_debug  reason: not valid java name */
    public final void m1984setArrowOffsetX0680j_4$ui_debug(float f) {
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

    /* compiled from: PopupBubbleMenu.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R)\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/ui/widget/PopupState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "saver", "Landroidx/compose/runtime/saveable/Saver;", "Lkntr/app/im/chat/ui/widget/PopupState;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<PopupState, Map<String, Object>> getSaver() {
            return PopupState.saver;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map saver$lambda$0(SaverScope $this$Saver, PopupState state) {
        Intrinsics.checkNotNullParameter($this$Saver, "$this$Saver");
        Intrinsics.checkNotNullParameter(state, "state");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("isVisible", Boolean.valueOf(state.isVisible())), TuplesKt.to("pivotFractionX", Float.valueOf(state.getPivotFractionX())), TuplesKt.to("isTop", Boolean.valueOf(state.isTop())), TuplesKt.to("arrowOffsetX", Float.valueOf(state.m1983getArrowOffsetXD9Ej5fM()))});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PopupState saver$lambda$1(Map saved) {
        Intrinsics.checkNotNullParameter(saved, "saved");
        Object obj = saved.get("isVisible");
        boolean isVisible = Intrinsics.areEqual(obj instanceof Boolean ? (Boolean) obj : null, true);
        Object obj2 = saved.get("pivotFractionX");
        Float f = obj2 instanceof Float ? (Float) obj2 : null;
        float pivotFractionX = f != null ? f.floatValue() : 0.0f;
        Object obj3 = saved.get("isTop");
        boolean isTop = Intrinsics.areEqual(obj3 instanceof Boolean ? (Boolean) obj3 : null, true);
        Object obj4 = saved.get("arrowOffsetX");
        Float f2 = obj4 instanceof Float ? (Float) obj4 : null;
        float arrowOffsetX = f2 != null ? f2.floatValue() : 0.0f;
        PopupState $this$saver_u24lambda_u241_u240 = new PopupState(isVisible);
        $this$saver_u24lambda_u241_u240.setPivotFractionX$ui_debug(pivotFractionX);
        $this$saver_u24lambda_u241_u240.setTop$ui_debug(isTop);
        $this$saver_u24lambda_u241_u240.m1984setArrowOffsetX0680j_4$ui_debug(Dp.constructor-impl(arrowOffsetX));
        return $this$saver_u24lambda_u241_u240;
    }
}