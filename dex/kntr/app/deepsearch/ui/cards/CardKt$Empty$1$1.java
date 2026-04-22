package kntr.app.deepsearch.ui.cards;

import com.bapis.bilibili.broadcast.message.deepsearch.KCardItem;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Card.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.ui.cards.CardKt$Empty$1$1", f = "Card.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CardKt$Empty$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ KCardItem.ICardItem $item;
    final /* synthetic */ KCardItem.KCardType $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardKt$Empty$1$1(KCardItem.ICardItem iCardItem, KCardItem.KCardType kCardType, Continuation<? super CardKt$Empty$1$1> continuation) {
        super(2, continuation);
        this.$item = iCardItem;
        this.$type = kCardType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardKt$Empty$1$1(this.$item, this.$type, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                ILogger kLog = KLog_androidKt.getKLog();
                KCardItem.ICardItem iCardItem = this.$item;
                kLog.i("deepsearch", "unknown card item: " + iCardItem + " @type" + this.$type.getValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}