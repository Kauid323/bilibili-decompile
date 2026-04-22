package kntr.app.digital.preview.gift;

import com.bilibili.ktor.KApiResponse;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: GiftActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.gift.GiftActionModule$provide$1$1", f = "GiftActionModule.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class GiftActionModule$provide$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $activityId;
    final /* synthetic */ DigitalCardStateService $cardStateService;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ DigitalGiftErrorDialogService $giftErrorDialogService;
    final /* synthetic */ RequestGiftInfo $requestGiftInfo;
    final /* synthetic */ Router $router;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftActionModule$provide$1$1(RequestGiftInfo requestGiftInfo, int i, DigitalCardStateService digitalCardStateService, Router router, CoroutineScope coroutineScope, DigitalGiftErrorDialogService digitalGiftErrorDialogService, Toaster toaster, Continuation<? super GiftActionModule$provide$1$1> continuation) {
        super(2, continuation);
        this.$requestGiftInfo = requestGiftInfo;
        this.$activityId = i;
        this.$cardStateService = digitalCardStateService;
        this.$router = router;
        this.$coroutineScope = coroutineScope;
        this.$giftErrorDialogService = digitalGiftErrorDialogService;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GiftActionModule$provide$1$1(this.$requestGiftInfo, this.$activityId, this.$cardStateService, this.$router, this.$coroutineScope, this.$giftErrorDialogService, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                invoke = this.$requestGiftInfo.invoke(this.$activityId, String.valueOf(this.$cardStateService.getCurrentCardItem().getBasic().getCardIdInfo().getCardId()), (Continuation) this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        KApiResponse.BusinessFailure businessFailure = (KApiResponse) invoke;
        Router router = this.$router;
        CoroutineScope coroutineScope = this.$coroutineScope;
        DigitalGiftErrorDialogService digitalGiftErrorDialogService = this.$giftErrorDialogService;
        Toaster toaster = this.$toaster;
        if (businessFailure instanceof KApiResponse.BusinessFailure) {
            int code = businessFailure.getCode();
            new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
            Toaster.-CC.showToast$default(toaster, "系统异常，请稍后处理", (ToastDuration) null, 2, (Object) null);
        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
            ((KApiResponse.ServiceUnavailable) businessFailure).getException();
            Toaster.-CC.showToast$default(toaster, "系统异常，请稍后处理", (ToastDuration) null, 2, (Object) null);
        } else if (businessFailure instanceof KApiResponse.Success) {
            DigitalCardGift it = (DigitalCardGift) ((KApiResponse.Success) businessFailure).getData();
            if (it.getStatus() == 0) {
                router.launch(UrisKt.toUri(it.getJumpUrl()));
            } else {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new GiftActionModule$provide$1$1$1$1(digitalGiftErrorDialogService, it, null), 3, (Object) null);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}