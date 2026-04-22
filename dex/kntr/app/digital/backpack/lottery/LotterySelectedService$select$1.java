package kntr.app.digital.backpack.lottery;

import com.bilibili.ktor.KApiResponse;
import kntr.app.digital.backpack.aggregate.BackpackModelBackedModule;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.api.GetBackpackAssetBag;
import kntr.app.digital.backpack.tab.TabModel;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LotterySelectedService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.backpack.lottery.LotterySelectedService$select$1", f = "LotterySelectedService.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LotterySelectedService$select$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $lotteryId;
    int label;
    final /* synthetic */ LotterySelectedService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotterySelectedService$select$1(LotterySelectedService lotterySelectedService, long j2, Continuation<? super LotterySelectedService$select$1> continuation) {
        super(2, continuation);
        this.this$0 = lotterySelectedService;
        this.$lotteryId = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LotterySelectedService$select$1(this.this$0, this.$lotteryId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        GetBackpackAssetBag getBackpackAssetBag;
        Object invoke;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                getBackpackAssetBag = this.this$0.getBackpackAssetBag;
                this.label = 1;
                invoke = getBackpackAssetBag.invoke(this.$lotteryId, (Continuation) this);
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
        LotterySelectedService lotterySelectedService = this.this$0;
        LotterySelectedService lotterySelectedService2 = this.this$0;
        if (businessFailure instanceof KApiResponse.BusinessFailure) {
            new IllegalStateException("code:" + businessFailure.getCode() + ",message:" + businessFailure.getMessage());
            mutableStateFlow3 = lotterySelectedService2._currentTabsModel;
            mutableStateFlow3.setValue(new TabsModel(CollectionsKt.arrayListOf(new TabModel[]{new TabModel(0L, null, null, 7, null), new TabModel(0L, null, null, 7, null), new TabModel(0L, null, null, 7, null)}), RoomRecommendViewModel.EMPTY_CURSOR));
        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
            ((KApiResponse.ServiceUnavailable) businessFailure).getException();
            mutableStateFlow2 = lotterySelectedService2._currentTabsModel;
            mutableStateFlow2.setValue(new TabsModel(CollectionsKt.arrayListOf(new TabModel[]{new TabModel(0L, null, null, 7, null), new TabModel(0L, null, null, 7, null), new TabModel(0L, null, null, 7, null)}), RoomRecommendViewModel.EMPTY_CURSOR));
        } else if (!(businessFailure instanceof KApiResponse.Success)) {
            throw new NoWhenBranchMatchedException();
        } else {
            BackpackAssetBagModel it = (BackpackAssetBagModel) ((KApiResponse.Success) businessFailure).getData();
            mutableStateFlow = lotterySelectedService._currentTabsModel;
            mutableStateFlow.setValue(BackpackModelBackedModule.INSTANCE.provideTabsModel(it));
        }
        return Unit.INSTANCE;
    }
}