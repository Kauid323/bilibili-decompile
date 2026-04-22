package kntr.app.deepsearch.stub;

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
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: PageStub.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.deepsearch.stub.PageStub_androidKt$observeSession$1", f = "PageStub.android.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class PageStub_androidKt$observeSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $observer;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PageStub_androidKt$observeSession$1(Function1<? super String, Unit> function1, Continuation<? super PageStub_androidKt$observeSession$1> continuation) {
        super(2, continuation);
        this.$observer = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageStub_androidKt$observeSession$1(this.$observer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                mutableStateFlow = PageStub_androidKt.detailPageStub;
                final Function1<String, Unit> function1 = this.$observer;
                this.label = 1;
                if (mutableStateFlow.collect(new FlowCollector() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$observeSession$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((PageStub) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(PageStub it, Continuation<? super Unit> continuation) {
                        String sessionId;
                        if (it != null && (sessionId = it.getSessionId()) != null) {
                            function1.invoke(sessionId);
                        }
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