package kntr.app.im.chat.sticker.stateMachine;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: StickerManagerStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "action", "Lkntr/app/im/chat/sticker/model/StickerAction$SelectStickerOrUnSelectToSave;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindSelectStickerOrUnSelect$2", f = "StickerManagerStateMachine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class StickerManagerStateMachine$bindSelectStickerOrUnSelect$2 extends SuspendLambda implements Function3<StickerAction.SelectStickerOrUnSelectToSave, State<StickerManagerData>, Continuation<? super ChangedState<? extends StickerManagerData>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerManagerStateMachine$bindSelectStickerOrUnSelect$2(Continuation<? super StickerManagerStateMachine$bindSelectStickerOrUnSelect$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(StickerAction.SelectStickerOrUnSelectToSave selectStickerOrUnSelectToSave, State<StickerManagerData> state, Continuation<? super ChangedState<StickerManagerData>> continuation) {
        StickerManagerStateMachine$bindSelectStickerOrUnSelect$2 stickerManagerStateMachine$bindSelectStickerOrUnSelect$2 = new StickerManagerStateMachine$bindSelectStickerOrUnSelect$2(continuation);
        stickerManagerStateMachine$bindSelectStickerOrUnSelect$2.L$0 = selectStickerOrUnSelectToSave;
        stickerManagerStateMachine$bindSelectStickerOrUnSelect$2.L$1 = state;
        return stickerManagerStateMachine$bindSelectStickerOrUnSelect$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        final StickerAction.SelectStickerOrUnSelectToSave action = (StickerAction.SelectStickerOrUnSelectToSave) this.L$0;
        State state = (State) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindSelectStickerOrUnSelect$2$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        StickerManagerData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerStateMachine$bindSelectStickerOrUnSelect$2.invokeSuspend$lambda$0(StickerAction.SelectStickerOrUnSelectToSave.this, (StickerManagerData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerManagerData invokeSuspend$lambda$0(StickerAction.SelectStickerOrUnSelectToSave $action, StickerManagerData $this$mutate) {
        StickerManagerData copy;
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.mid : 0L, (r20 & 2) != 0 ? $this$mutate.stickerList : null, (r20 & 4) != 0 ? $this$mutate.selectedStickersToDelete : null, (r20 & 8) != 0 ? $this$mutate.selectedStickersToSave : CollectionsKt.toSet($action.getAssetList()), (r20 & 16) != 0 ? $this$mutate.isEditMode : false, (r20 & 32) != 0 ? $this$mutate.toast : null, (r20 & 64) != 0 ? $this$mutate.isShowConfirmDeleteDialog : false, (r20 & 128) != 0 ? $this$mutate.saved : false);
        return copy;
    }
}