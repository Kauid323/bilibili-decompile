package kntr.app.digital.preview.usage;

import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.KomponentScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ChangeAvatarActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.usage.ChangeAvatarActionModule$provide$1$1", f = "ChangeAvatarActionModule.kt", i = {0, 0}, l = {51}, m = "invokeSuspend", n = {"cardBasic", "cardId"}, s = {"L$0", "J$0"}, v = 1)
final class ChangeAvatarActionModule$provide$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DigitalCardStateService $cardStateService;
    final /* synthetic */ KomponentScope<Unit> $komponentScope;
    final /* synthetic */ Action<ChangeAvatarAction> $this_ActionModule;
    final /* synthetic */ DigitalUsageRestrictionDialogService $usingLimitedDialogService;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangeAvatarActionModule$provide$1$1(DigitalCardStateService digitalCardStateService, Action<ChangeAvatarAction> action, DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService, KomponentScope<? super Unit> komponentScope, Continuation<? super ChangeAvatarActionModule$provide$1$1> continuation) {
        super(2, continuation);
        this.$cardStateService = digitalCardStateService;
        this.$this_ActionModule = action;
        this.$usingLimitedDialogService = digitalUsageRestrictionDialogService;
        this.$komponentScope = komponentScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChangeAvatarActionModule$provide$1$1(this.$cardStateService, this.$this_ActionModule, this.$usingLimitedDialogService, this.$komponentScope, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        long cardId;
        long cardId2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CardBasic cardBasic = this.$cardStateService.getCurrentCardItem().getBasic();
                cardId = cardBasic.getCardIdInfo().getCardId() == 0 ? cardBasic.getCardIdInfo().getCardTypeId() : cardBasic.getCardIdInfo().getCardId();
                if (this.$this_ActionModule.getData().getHasLimitDialog()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(cardBasic);
                    this.J$0 = cardId;
                    this.label = 1;
                    if (this.$usingLimitedDialogService.keepShowing(this.$this_ActionModule.getData().getLimitDialogTitle(), this.$this_ActionModule.getData().getLimitDialogTime(), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cardId2 = cardId;
                    cardId = cardId2;
                    break;
                }
                break;
            case 1:
                cardId2 = this.J$0;
                CardBasic cardBasic2 = (CardBasic) this.L$0;
                ResultKt.throwOnFailure($result);
                cardId = cardId2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AvatarUploader_androidKt.getUploadAvatar().invoke(this.$komponentScope, this.$this_ActionModule.getData().getImageUrl(), cardId);
        return Unit.INSTANCE;
    }
}