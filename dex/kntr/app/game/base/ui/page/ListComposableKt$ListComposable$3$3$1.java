package kntr.app.game.base.ui.page;

import java.util.List;
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
/* compiled from: ListComposable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.ui.page.ListComposableKt$ListComposable$3$3$1", f = "ListComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ListComposableKt$ListComposable$3$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Item> $list;
    final /* synthetic */ Function2<CoroutineScope, List<? extends Item>, Unit> $onDataChange;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListComposableKt$ListComposable$3$3$1(Function2<? super CoroutineScope, ? super List<? extends Item>, Unit> function2, List<? extends Item> list, Continuation<? super ListComposableKt$ListComposable$3$3$1> continuation) {
        super(2, continuation);
        this.$onDataChange = function2;
        this.$list = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> listComposableKt$ListComposable$3$3$1 = new ListComposableKt$ListComposable$3$3$1(this.$onDataChange, this.$list, continuation);
        listComposableKt$ListComposable$3$3$1.L$0 = obj;
        return listComposableKt$ListComposable$3$3$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        CoroutineScope $this$LaunchedEffect = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<CoroutineScope, List<? extends Item>, Unit> function2 = this.$onDataChange;
                if (function2 != 0) {
                    function2.invoke($this$LaunchedEffect, this.$list);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}