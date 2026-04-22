package kntr.app.live.room.multivideo.poll;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandler.kt */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", RoomRecommendViewModel.EMPTY_CURSOR, "kotlinx-coroutines-core"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LivePollConnection$start$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    final /* synthetic */ LivePollConnection this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LivePollConnection$start$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key $super_call_param$1, LivePollConnection livePollConnection) {
        super((CoroutineContext.Key) $super_call_param$1);
        this.this$0 = livePollConnection;
    }

    public void handleException(CoroutineContext context, Throwable exception) {
        LivePollParam livePollParam;
        ILogger kLog = KLog_androidKt.getKLog();
        livePollParam = this.this$0.livePollParam;
        String bizName = livePollParam.getBizName();
        kLog.i(LivePollConnection.TAG, bizName + ": LivePollConnection canceled by " + exception.getMessage() + " ");
    }
}