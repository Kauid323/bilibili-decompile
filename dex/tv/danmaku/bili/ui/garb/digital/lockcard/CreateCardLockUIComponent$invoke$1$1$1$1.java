package tv.danmaku.bili.ui.garb.digital.lockcard;

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
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CreateCardLockUIComponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$invoke$1$1$1$1", f = "CreateCardLockUIComponent.kt", i = {}, l = {BR.bgDrawable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CreateCardLockUIComponent$invoke$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $actId;
    final /* synthetic */ long $cardId;
    final /* synthetic */ String $cardNo;
    final /* synthetic */ long $cardTypeId;
    final /* synthetic */ LockModel $lockModel;
    int label;
    final /* synthetic */ CreateCardLockUIComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateCardLockUIComponent$invoke$1$1$1$1(CreateCardLockUIComponent createCardLockUIComponent, LockModel lockModel, long j, long j2, long j3, String str, Continuation<? super CreateCardLockUIComponent$invoke$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = createCardLockUIComponent;
        this.$lockModel = lockModel;
        this.$actId = j;
        this.$cardId = j2;
        this.$cardTypeId = j3;
        this.$cardNo = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateCardLockUIComponent$invoke$1$1$1$1(this.this$0, this.$lockModel, this.$actId, this.$cardId, this.$cardTypeId, this.$cardNo, continuation);
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
                unlockCardDialogService = this.this$0.dialogService;
                final LockModel lockModel = this.$lockModel;
                final long j = this.$actId;
                final long j2 = this.$cardId;
                final long j3 = this.$cardTypeId;
                final String str = this.$cardNo;
                this.label = 1;
                if (unlockCardDialogService.keepDialogShowing(new Function0() { // from class: tv.danmaku.bili.ui.garb.digital.lockcard.CreateCardLockUIComponent$invoke$1$1$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = CreateCardLockUIComponent$invoke$1$1$1$1.invokeSuspend$lambda$0(LockModel.this, j, j2, j3, str);
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
    public static final Unit invokeSuspend$lambda$0(LockModel $lockModel, long $actId, long $cardId, long $cardTypeId, String $cardNo) {
        $lockModel.toggleLockCard(false, $actId, $cardId, $cardTypeId, $cardNo);
        return Unit.INSTANCE;
    }
}