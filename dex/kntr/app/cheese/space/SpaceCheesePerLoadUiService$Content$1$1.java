package kntr.app.cheese.space;

import androidx.compose.foundation.lazy.LazyListState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpaceCheesePerLoadUiService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.cheese.space.SpaceCheesePerLoadUiService$Content$1$1", f = "SpaceCheesePerLoadUiService.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SpaceCheesePerLoadUiService$Content$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpaceCheesePerLoadUiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceCheesePerLoadUiService$Content$1$1(SpaceCheesePerLoadUiService spaceCheesePerLoadUiService, Continuation<? super SpaceCheesePerLoadUiService$Content$1$1> continuation) {
        super(2, continuation);
        this.this$0 = spaceCheesePerLoadUiService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceCheesePerLoadUiService$Content$1$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow mutableSharedFlow = this.this$0.scrollToPosition;
                final SpaceCheesePerLoadUiService spaceCheesePerLoadUiService = this.this$0;
                this.label = 1;
                if (mutableSharedFlow.collect(new FlowCollector() { // from class: kntr.app.cheese.space.SpaceCheesePerLoadUiService$Content$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Number) value).intValue(), $completion);
                    }

                    public final Object emit(int index, Continuation<? super Unit> continuation) {
                        Object scrollToItem$default = LazyListState.scrollToItem$default(SpaceCheesePerLoadUiService.this.listState, index, 0, continuation, 2, (Object) null);
                        return scrollToItem$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? scrollToItem$default : Unit.INSTANCE;
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