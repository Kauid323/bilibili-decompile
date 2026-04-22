package kntr.app.im.chat.sticker.stateMachine;

import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import im.base.IMToast;
import java.util.List;
import kntr.app.im.chat.sticker.model.StickerAction;
import kntr.app.im.chat.sticker.model.StickerManagerData;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.datetime.Instant;
import org.jetbrains.compose.resources.StringResourcesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerManagerStateMachine.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/sticker/model/StickerManagerData;", "action", "Lkntr/app/im/chat/sticker/model/StickerAction$DeleteStickers;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$3", f = "StickerManagerStateMachine.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {141, 142}, m = "invokeSuspend", n = {"action", "state", "stickersToDelete", "action", "state", "stickersToDelete", "failedCount"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class StickerManagerStateMachine$bindStickerCrud$3 extends SuspendLambda implements Function3<StickerAction.DeleteStickers, State<StickerManagerData>, Continuation<? super ChangedState<? extends StickerManagerData>>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ StickerManagerStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerManagerStateMachine$bindStickerCrud$3(StickerManagerStateMachine stickerManagerStateMachine, Continuation<? super StickerManagerStateMachine$bindStickerCrud$3> continuation) {
        super(3, continuation);
        this.this$0 = stickerManagerStateMachine;
    }

    public final Object invoke(StickerAction.DeleteStickers deleteStickers, State<StickerManagerData> state, Continuation<? super ChangedState<StickerManagerData>> continuation) {
        StickerManagerStateMachine$bindStickerCrud$3 stickerManagerStateMachine$bindStickerCrud$3 = new StickerManagerStateMachine$bindStickerCrud$3(this.this$0, continuation);
        stickerManagerStateMachine$bindStickerCrud$3.L$0 = deleteStickers;
        stickerManagerStateMachine$bindStickerCrud$3.L$1 = state;
        return stickerManagerStateMachine$bindStickerCrud$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x007d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        List stickersToDelete;
        StickerManagerService stickerManagerService;
        Object deleteStickers;
        Object string;
        final int failedCount;
        StickerAction.DeleteStickers action = (StickerAction.DeleteStickers) this.L$0;
        State state = (State) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                stickersToDelete = action.getStickers();
                stickerManagerService = this.this$0.stickerManagerService;
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(stickersToDelete);
                this.label = 1;
                deleteStickers = stickerManagerService.deleteStickers(stickersToDelete, (Continuation) this);
                if (deleteStickers == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int failedCount2 = ((Number) deleteStickers).intValue();
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(stickersToDelete);
                this.I$0 = failedCount2;
                this.label = 2;
                string = StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_904(Res.string.INSTANCE), (Continuation) this);
                if (string != coroutine_suspended) {
                    return coroutine_suspended;
                }
                failedCount = failedCount2;
                final String toastMessage = (String) string;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        StickerManagerData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$3.invokeSuspend$lambda$0(failedCount, toastMessage, (StickerManagerData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            case 1:
                stickersToDelete = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                deleteStickers = $result;
                int failedCount22 = ((Number) deleteStickers).intValue();
                this.L$0 = SpillingKt.nullOutSpilledVariable(action);
                this.L$1 = state;
                this.L$2 = SpillingKt.nullOutSpilledVariable(stickersToDelete);
                this.I$0 = failedCount22;
                this.label = 2;
                string = StringResourcesKt.getString(String1_commonMainKt.getIm_global_string_904(Res.string.INSTANCE), (Continuation) this);
                if (string != coroutine_suspended) {
                }
                break;
            case 2:
                failedCount = this.I$0;
                List list = (List) this.L$2;
                ResultKt.throwOnFailure($result);
                string = $result;
                final String toastMessage2 = (String) string;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.sticker.stateMachine.StickerManagerStateMachine$bindStickerCrud$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        StickerManagerData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = StickerManagerStateMachine$bindStickerCrud$3.invokeSuspend$lambda$0(failedCount, toastMessage2, (StickerManagerData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StickerManagerData invokeSuspend$lambda$0(int $failedCount, String $toastMessage, StickerManagerData $this$mutate) {
        IMToast iMToast;
        StickerManagerData copy;
        if ($failedCount == 0) {
            iMToast = IMToast.Companion.create$default(IMToast.Companion, $toastMessage, (Instant) null, 2, (Object) null);
        } else {
            iMToast = null;
        }
        copy = $this$mutate.copy((r20 & 1) != 0 ? $this$mutate.mid : 0L, (r20 & 2) != 0 ? $this$mutate.stickerList : null, (r20 & 4) != 0 ? $this$mutate.selectedStickersToDelete : null, (r20 & 8) != 0 ? $this$mutate.selectedStickersToSave : null, (r20 & 16) != 0 ? $this$mutate.isEditMode : false, (r20 & 32) != 0 ? $this$mutate.toast : iMToast, (r20 & 64) != 0 ? $this$mutate.isShowConfirmDeleteDialog : false, (r20 & 128) != 0 ? $this$mutate.saved : false);
        return copy;
    }
}