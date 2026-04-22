package kntr.common.ouro.common.ui.toolPanel.expandablePanel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.AnchoredDraggableKt;
import androidx.compose.foundation.gestures.AnchoredDraggableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ExpandablePanel.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"kntr/common/ouro/common/ui/toolPanel/expandablePanel/ExpandablePanelKt$preUpPostDownNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExpandablePanelKt$preUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ AnchoredDraggableState<T> $this_preUpPostDownNestedScrollConnection;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExpandablePanelKt$preUpPostDownNestedScrollConnection$1(AnchoredDraggableState<T> anchoredDraggableState, CoroutineScope $scope) {
        this.$this_preUpPostDownNestedScrollConnection = anchoredDraggableState;
        this.$scope = $scope;
    }

    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    public /* bridge */ Object m1912onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j, continuation);
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public /* bridge */ long m1913onPreScrollOzD1aCk(long j, int i) {
        return NestedScrollConnection.-CC.$default$onPreScroll-OzD1aCk(this, j, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m1910onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1 expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1;
        if (continuation instanceof ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1) {
            expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1 = (ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1) continuation;
            if ((expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.label -= Integer.MIN_VALUE;
                Object $result = expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        AnchoredDraggableState<T> anchoredDraggableState = this.$this_preUpPostDownNestedScrollConnection;
                        Object targetValue = this.$this_preUpPostDownNestedScrollConnection.getTargetValue();
                        expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.J$0 = j;
                        expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.J$1 = j2;
                        expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.label = 1;
                        if (AnchoredDraggableKt.animateTo$default(anchoredDraggableState, targetValue, (AnimationSpec) null, expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1, 2, (Object) null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        j2 = expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.J$1;
                        long j3 = expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Velocity.box-impl(VelocityKt.Velocity(0.0f, Velocity.getY-impl(j2)));
            }
        }
        expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1 = new ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1(this, continuation);
        Object $result2 = expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (expandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostFling$1.label) {
        }
        return Velocity.box-impl(VelocityKt.Velocity(0.0f, Velocity.getY-impl(j2)));
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m1911onPostScrollDzOQY0M(long j, long j2, int i) {
        if (NestedScrollSource.equals-impl0(i, NestedScrollSource.Companion.getUserInput-WNlRxjI())) {
            int bits$iv$iv$iv = (int) (j2 & 4294967295L);
            if (Float.intBitsToFloat(bits$iv$iv$iv) > 0.0f) {
                BuildersKt.launch$default(this.$scope, (CoroutineContext) null, (CoroutineStart) null, new ExpandablePanelKt$preUpPostDownNestedScrollConnection$1$onPostScroll$1(this.$this_preUpPostDownNestedScrollConnection, j2, null), 3, (Object) null);
                int bits$iv$iv$iv2 = (int) (j2 & 4294967295L);
                float y$iv = Float.intBitsToFloat(bits$iv$iv$iv2);
                long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
            }
            return Offset.Companion.getZero-F1C5BW0();
        }
        return Offset.Companion.getZero-F1C5BW0();
    }
}