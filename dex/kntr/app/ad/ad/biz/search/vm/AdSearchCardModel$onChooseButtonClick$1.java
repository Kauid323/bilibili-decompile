package kntr.app.ad.ad.biz.search.vm;

import java.util.Map;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.domain.click.ClickerKt;
import kntr.app.ad.domain.click.IButtonClickListener;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdSearchCardModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.search.vm.AdSearchCardModel$onChooseButtonClick$1", f = "AdSearchCardModel.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AdSearchCardModel$onChooseButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ AdSearchCardModel<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdSearchCardModel$onChooseButtonClick$1(AdSearchCardModel<S> adSearchCardModel, int i, Continuation<? super AdSearchCardModel$onChooseButtonClick$1> continuation) {
        super(2, continuation);
        this.this$0 = adSearchCardModel;
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdSearchCardModel$onChooseButtonClick$1(this.this$0, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IButtonClickListener clickChooseButtonListener;
        Object clickButton;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Clicker clicker = this.this$0.getClicker();
                if (clicker != null) {
                    ClickArg chooseButtonClickArg = this.this$0.getChooseButtonClickArg(this.$index);
                    ClickArg cardClickArg = this.this$0.getCardClickArg();
                    Map plus = MapsKt.plus(MapsKt.plus(this.this$0.chooseButtonClickParams(this.$index), this.this$0.commonFeeParams()), this.this$0.commonUIParams());
                    clickChooseButtonListener = this.this$0.clickChooseButtonListener(this.$index);
                    this.label = 1;
                    clickButton = ClickerKt.clickButton(clicker, chooseButtonClickArg, cardClickArg, plus, clickChooseButtonListener, (Continuation) this);
                    if (clickButton == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Boolean bool = (Boolean) clickButton;
                    break;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                clickButton = $result;
                Boolean bool2 = (Boolean) clickButton;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}