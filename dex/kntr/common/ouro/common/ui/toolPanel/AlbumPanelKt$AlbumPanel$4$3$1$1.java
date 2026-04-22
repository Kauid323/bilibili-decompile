package kntr.common.ouro.common.ui.toolPanel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AlbumPanel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt$AlbumPanel$4$3$1$1", f = "AlbumPanel.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AlbumPanelKt$AlbumPanel$4$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AphroAction $action;
    final /* synthetic */ AphroViewModel $aphroViewModel;
    final /* synthetic */ Function1<AlbumPanelEvent, Unit> $onEvent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AlbumPanelKt$AlbumPanel$4$3$1$1(AphroViewModel aphroViewModel, AphroAction aphroAction, Function1<? super AlbumPanelEvent, Unit> function1, Continuation<? super AlbumPanelKt$AlbumPanel$4$3$1$1> continuation) {
        super(2, continuation);
        this.$aphroViewModel = aphroViewModel;
        this.$action = aphroAction;
        this.$onEvent = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumPanelKt$AlbumPanel$4$3$1$1(this.$aphroViewModel, this.$action, this.$onEvent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (this.$aphroViewModel.dispatch(this.$action, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AphroAction aphroAction = this.$action;
        if (aphroAction instanceof AphroAction.ConfirmSelection) {
            this.$onEvent.invoke(AlbumPanelEvent.CONFIRM);
        } else if (aphroAction instanceof AphroAction.SelectAsset) {
            this.$onEvent.invoke(AlbumPanelEvent.SELECT);
        } else if (aphroAction instanceof AphroAction.UnSelectAsset) {
            this.$onEvent.invoke(AlbumPanelEvent.UNSELECT);
        }
        return Unit.INSTANCE;
    }
}