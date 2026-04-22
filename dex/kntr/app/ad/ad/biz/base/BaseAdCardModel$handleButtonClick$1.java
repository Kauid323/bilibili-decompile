package kntr.app.ad.ad.biz.base;

import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.domain.click.ClickerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BaseAdCardModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.base.BaseAdCardModel$handleButtonClick$1", f = "BaseAdCardModel.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BaseAdCardModel$handleButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseAdCardModel<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAdCardModel$handleButtonClick$1(BaseAdCardModel<S> baseAdCardModel, Continuation<? super BaseAdCardModel$handleButtonClick$1> continuation) {
        super(2, continuation);
        this.this$0 = baseAdCardModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseAdCardModel$handleButtonClick$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object clickButton$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Clicker clicker = this.this$0.getClicker();
                if (clicker != null) {
                    this.label = 1;
                    clickButton$default = ClickerKt.clickButton$default(clicker, this.this$0.getButtonClickArg(), this.this$0.getCardClickArg(), MapsKt.plus(this.this$0.commonFeeParams(), this.this$0.commonUIParams()), null, (Continuation) this, 8, null);
                    if (clickButton$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boolean bool = (Boolean) clickButton$default;
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                clickButton$default = $result;
                Boolean bool2 = (Boolean) clickButton$default;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}