package kntr.app.digital.preview.lock;

import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockUIService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.lock.LockUIService$Content$1$1$1", f = "LockUIService.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LockUIService$Content$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardItem<?> $currentCard;
    int label;
    final /* synthetic */ LockUIService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockUIService$Content$1$1$1(LockUIService lockUIService, CardItem<?> cardItem, Continuation<? super LockUIService$Content$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = lockUIService;
        this.$currentCard = cardItem;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LockUIService$Content$1$1$1(this.this$0, this.$currentCard, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UnlockCardDialogService unlockCardDialogService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                unlockCardDialogService = this.this$0.unlockCardDialogService;
                final LockUIService lockUIService = this.this$0;
                final CardItem<?> cardItem = this.$currentCard;
                this.label = 1;
                if (unlockCardDialogService.keepDialogShowing(new Function0() { // from class: kntr.app.digital.preview.lock.LockUIService$Content$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = LockUIService$Content$1$1$1.invokeSuspend$lambda$0(LockUIService.this, cardItem);
                        return invokeSuspend$lambda$0;
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
    public static final Unit invokeSuspend$lambda$0(LockUIService this$0, CardItem $currentCard) {
        LockStateService lockStateService;
        lockStateService = this$0.lockStateService;
        lockStateService.toggleDlcLockCard($currentCard, false);
        return Unit.INSTANCE;
    }
}