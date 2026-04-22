package tv.danmaku.bili.ui.garb.nft;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DLCDrawCardDataManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/garb/nft/CardDataState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$requestData$2$respInfoTask$1", f = "DLCDrawCardDataManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCDrawCardDataManager$requestData$2$respInfoTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CardDataState>, Object> {
    int label;
    final /* synthetic */ DLCDrawCardDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardDataManager$requestData$2$respInfoTask$1(DLCDrawCardDataManager dLCDrawCardDataManager, Continuation<? super DLCDrawCardDataManager$requestData$2$respInfoTask$1> continuation) {
        super(2, continuation);
        this.this$0 = dLCDrawCardDataManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCDrawCardDataManager$requestData$2$respInfoTask$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CardDataState> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestDLCData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                requestDLCData = this.this$0.requestDLCData((Continuation) this);
                return requestDLCData == coroutine_suspended ? coroutine_suspended : requestDLCData;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}