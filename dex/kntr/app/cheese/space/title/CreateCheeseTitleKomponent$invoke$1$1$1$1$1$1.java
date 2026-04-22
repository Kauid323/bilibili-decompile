package kntr.app.cheese.space.title;

import androidx.compose.foundation.lazy.LazyListState;
import kntr.app.cheese.space.filter.ClassifiedTypeIndex;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CreateCheeseTitleKomponent.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.cheese.space.title.CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1", f = "CreateCheeseTitleKomponent.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $classifiedTypeListState;
    final /* synthetic */ int $scrollOffset;
    int label;
    final /* synthetic */ CreateCheeseTitleKomponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1(LazyListState lazyListState, CreateCheeseTitleKomponent createCheeseTitleKomponent, int i, Continuation<? super CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$classifiedTypeListState = lazyListState;
        this.this$0 = createCheeseTitleKomponent;
        this.$scrollOffset = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateCheeseTitleKomponent$invoke$1$1$1$1$1$1(this.$classifiedTypeListState, this.this$0, this.$scrollOffset, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ClassifiedTypeIndex classifiedTypeIndex;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LazyListState lazyListState = this.$classifiedTypeListState;
                classifiedTypeIndex = this.this$0.classifiedTypeIndex;
                this.label = 1;
                if (lazyListState.animateScrollToItem(classifiedTypeIndex.getValue(), this.$scrollOffset, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}