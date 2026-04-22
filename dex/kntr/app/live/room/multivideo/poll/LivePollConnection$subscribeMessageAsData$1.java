package kntr.app.live.room.multivideo.poll;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: LivePollConnection.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.live.room.multivideo.poll.LivePollConnection$subscribeMessageAsData$1", f = "LivePollConnection.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LivePollConnection$subscribeMessageAsData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<T, Unit> $onReceiveMsg;
    int label;
    final /* synthetic */ LivePollConnection<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LivePollConnection$subscribeMessageAsData$1(LivePollConnection<T> livePollConnection, Function1<? super T, Unit> function1, Continuation<? super LivePollConnection$subscribeMessageAsData$1> continuation) {
        super(2, continuation);
        this.this$0 = livePollConnection;
        this.$onReceiveMsg = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LivePollConnection$subscribeMessageAsData$1(this.this$0, this.$onReceiveMsg, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableSharedFlow = ((LivePollConnection) this.this$0).messageFlow;
                final Function1<T, Unit> function1 = this.$onReceiveMsg;
                this.label = 1;
                if (mutableSharedFlow.collect(new FlowCollector() { // from class: kntr.app.live.room.multivideo.poll.LivePollConnection$subscribeMessageAsData$1.1
                    public final Object emit(T t, Continuation<? super Unit> continuation) {
                        function1.invoke(t);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}