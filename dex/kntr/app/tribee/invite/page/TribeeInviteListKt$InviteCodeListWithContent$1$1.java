package kntr.app.tribee.invite.page;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: TribeeInviteList.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.invite.page.TribeeInviteListKt$InviteCodeListWithContent$1$1", f = "TribeeInviteList.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class TribeeInviteListKt$InviteCodeListWithContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SnapshotStateList<InviteItem> $inviteList;
    final /* synthetic */ State<List<Pair<Integer, Boolean>>> $itemIndexBoundaryMap;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TribeeInviteListKt$InviteCodeListWithContent$1$1(State<? extends List<Pair<Integer, Boolean>>> state, SnapshotStateList<InviteItem> snapshotStateList, Continuation<? super TribeeInviteListKt$InviteCodeListWithContent$1$1> continuation) {
        super(2, continuation);
        this.$itemIndexBoundaryMap = state;
        this.$inviteList = snapshotStateList;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeeInviteListKt$InviteCodeListWithContent$1$1(this.$itemIndexBoundaryMap, this.$inviteList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final State<List<Pair<Integer, Boolean>>> state = this.$itemIndexBoundaryMap;
                Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$InviteCodeListWithContent$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        List invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TribeeInviteListKt$InviteCodeListWithContent$1$1.invokeSuspend$lambda$0(state);
                        return invokeSuspend$lambda$0;
                    }
                });
                final SnapshotStateList<InviteItem> snapshotStateList = this.$inviteList;
                this.label = 1;
                if (snapshotFlow.collect(new FlowCollector() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$InviteCodeListWithContent$1$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<Pair<Integer, Boolean>> list, Continuation<? super Unit> continuation) {
                        TribeeInviteListKt.updateListBackground(snapshotStateList, list);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$0(State $itemIndexBoundaryMap) {
        return (List) $itemIndexBoundaryMap.getValue();
    }
}