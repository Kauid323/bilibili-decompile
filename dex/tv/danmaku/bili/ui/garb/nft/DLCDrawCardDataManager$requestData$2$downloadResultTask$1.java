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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.nft.DLCDrawCardDataManager$requestData$2$downloadResultTask$1", f = "DLCDrawCardDataManager.kt", i = {}, l = {BR.backgroundUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DLCDrawCardDataManager$requestData$2$downloadResultTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ DLCDrawCardDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DLCDrawCardDataManager$requestData$2$downloadResultTask$1(DLCDrawCardDataManager dLCDrawCardDataManager, Continuation<? super DLCDrawCardDataManager$requestData$2$downloadResultTask$1> continuation) {
        super(2, continuation);
        this.this$0 = dLCDrawCardDataManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DLCDrawCardDataManager$requestData$2$downloadResultTask$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object downloadRes;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                downloadRes = this.this$0.downloadRes((Continuation) this);
                if (downloadRes == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return downloadRes;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}