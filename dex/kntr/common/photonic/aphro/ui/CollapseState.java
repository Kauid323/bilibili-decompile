package kntr.common.photonic.aphro.ui;

import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.DraggableAnchors;
import androidx.compose.foundation.gestures.DraggableAnchorsConfig;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaSelectFloat.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u00122\u0010\u0007\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\r\u001a\u00020\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J5\u0010\u001b\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000eHÆ\u0003J_\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u000524\b\u0002\u0010\u0007\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000eHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\nHÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R=\u0010\u0007\u001a.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lkntr/common/photonic/aphro/ui/CollapseState;", "", "initState", "Lkntr/common/photonic/aphro/ui/CollapseStatus;", "onStatusChanged", "Lkotlin/Function1;", "", "anchorsConfigBuilder", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "", "Lkotlin/ParameterName;", "name", "maxOffsetPx", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkntr/common/photonic/aphro/ui/CollapseStatus;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getInitState", "()Lkntr/common/photonic/aphro/ui/CollapseStatus;", "getOnStatusChanged", "()Lkotlin/jvm/functions/Function1;", "getAnchorsConfigBuilder", "()Lkotlin/jvm/functions/Function2;", "buildAnchorsConfig", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CollapseState {
    public static final int $stable = 0;
    private final Function2<DraggableAnchorsConfig<CollapseStatus>, Integer, Unit> anchorsConfigBuilder;
    private final CollapseStatus initState;
    private final Function1<CollapseStatus, Unit> onStatusChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollapseState copy$default(CollapseState collapseState, CollapseStatus collapseStatus, Function1 function1, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            collapseStatus = collapseState.initState;
        }
        if ((i & 2) != 0) {
            function1 = collapseState.onStatusChanged;
        }
        if ((i & 4) != 0) {
            function2 = collapseState.anchorsConfigBuilder;
        }
        return collapseState.copy(collapseStatus, function1, function2);
    }

    public final CollapseStatus component1() {
        return this.initState;
    }

    public final Function1<CollapseStatus, Unit> component2() {
        return this.onStatusChanged;
    }

    public final Function2<DraggableAnchorsConfig<CollapseStatus>, Integer, Unit> component3() {
        return this.anchorsConfigBuilder;
    }

    public final CollapseState copy(CollapseStatus collapseStatus, Function1<? super CollapseStatus, Unit> function1, Function2<? super DraggableAnchorsConfig<CollapseStatus>, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(collapseStatus, "initState");
        Intrinsics.checkNotNullParameter(function1, "onStatusChanged");
        Intrinsics.checkNotNullParameter(function2, "anchorsConfigBuilder");
        return new CollapseState(collapseStatus, function1, function2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CollapseState) {
            CollapseState collapseState = (CollapseState) obj;
            return this.initState == collapseState.initState && Intrinsics.areEqual(this.onStatusChanged, collapseState.onStatusChanged) && Intrinsics.areEqual(this.anchorsConfigBuilder, collapseState.anchorsConfigBuilder);
        }
        return false;
    }

    public int hashCode() {
        return (((this.initState.hashCode() * 31) + this.onStatusChanged.hashCode()) * 31) + this.anchorsConfigBuilder.hashCode();
    }

    public String toString() {
        CollapseStatus collapseStatus = this.initState;
        Function1<CollapseStatus, Unit> function1 = this.onStatusChanged;
        return "CollapseState(initState=" + collapseStatus + ", onStatusChanged=" + function1 + ", anchorsConfigBuilder=" + this.anchorsConfigBuilder + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CollapseState(CollapseStatus initState, Function1<? super CollapseStatus, Unit> function1, Function2<? super DraggableAnchorsConfig<CollapseStatus>, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(initState, "initState");
        Intrinsics.checkNotNullParameter(function1, "onStatusChanged");
        Intrinsics.checkNotNullParameter(function2, "anchorsConfigBuilder");
        this.initState = initState;
        this.onStatusChanged = function1;
        this.anchorsConfigBuilder = function2;
    }

    public /* synthetic */ CollapseState(CollapseStatus collapseStatus, Function1 function1, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollapseStatus.COLLAPSE : collapseStatus, (i & 2) != 0 ? new Function1() { // from class: kntr.common.photonic.aphro.ui.CollapseState$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = CollapseState._init_$lambda$0((CollapseStatus) obj);
                return _init_$lambda$0;
            }
        } : function1, function2);
    }

    public final CollapseStatus getInitState() {
        return this.initState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(CollapseStatus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final Function1<CollapseStatus, Unit> getOnStatusChanged() {
        return this.onStatusChanged;
    }

    public final Function2<DraggableAnchorsConfig<CollapseStatus>, Integer, Unit> getAnchorsConfigBuilder() {
        return this.anchorsConfigBuilder;
    }

    public final DraggableAnchors<CollapseStatus> buildAnchorsConfig(final int maxOffsetPx) {
        return AnchoredDraggableKt.DraggableAnchors(new Function1() { // from class: kntr.common.photonic.aphro.ui.CollapseState$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildAnchorsConfig$lambda$0;
                buildAnchorsConfig$lambda$0 = CollapseState.buildAnchorsConfig$lambda$0(CollapseState.this, maxOffsetPx, (DraggableAnchorsConfig) obj);
                return buildAnchorsConfig$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnchorsConfig$lambda$0(CollapseState this$0, int $maxOffsetPx, DraggableAnchorsConfig $this$DraggableAnchors) {
        Intrinsics.checkNotNullParameter($this$DraggableAnchors, "$this$DraggableAnchors");
        this$0.anchorsConfigBuilder.invoke($this$DraggableAnchors, Integer.valueOf($maxOffsetPx));
        return Unit.INSTANCE;
    }
}