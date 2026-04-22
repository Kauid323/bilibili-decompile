package kntr.app.ad.ad.biz.liveroom.vm;

import kntr.app.ad.domain.click.ClickArg;
import kntr.app.ad.domain.click.ClickService;
import kntr.app.ad.domain.click.Clicker;
import kntr.app.ad.domain.click.ClickerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdLiveRoomBrandCardViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.ad.biz.liveroom.vm.AdLiveRoomBrandCardViewModel$clickCard$1", f = "AdLiveRoomBrandCardViewModel.kt", i = {0, 0}, l = {47}, m = "invokeSuspend", n = {"it", "$i$a$-let-AdLiveRoomBrandCardViewModel$clickCard$1$1"}, s = {"L$0", "I$0"}, v = 1)
public final class AdLiveRoomBrandCardViewModel$clickCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ AdLiveRoomBrandCardViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdLiveRoomBrandCardViewModel$clickCard$1(AdLiveRoomBrandCardViewModel adLiveRoomBrandCardViewModel, Continuation<? super AdLiveRoomBrandCardViewModel$clickCard$1> continuation) {
        super(2, continuation);
        this.this$0 = adLiveRoomBrandCardViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdLiveRoomBrandCardViewModel$clickCard$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ClickArg cardClickArg;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ClickService it = this.this$0.getClickerService();
                if (it != null) {
                    AdLiveRoomBrandCardViewModel adLiveRoomBrandCardViewModel = this.this$0;
                    Clicker clicker = new Clicker(it);
                    cardClickArg = adLiveRoomBrandCardViewModel.getCardClickArg();
                    this.L$0 = SpillingKt.nullOutSpilledVariable(it);
                    this.I$0 = 0;
                    this.label = 1;
                    if (ClickerKt.clickCard$default(clicker, cardClickArg, null, null, this, 6, null) != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                int i = this.I$0;
                ClickService clickService = (ClickService) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}