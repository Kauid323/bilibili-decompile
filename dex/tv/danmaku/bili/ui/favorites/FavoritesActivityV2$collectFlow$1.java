package tv.danmaku.bili.ui.favorites;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FavPageState;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$1", f = "FavoritesActivityV2.kt", i = {}, l = {BR.coverThumbHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesActivityV2$collectFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityV2$collectFlow$1(FavoritesActivityV2 favoritesActivityV2, Continuation<? super FavoritesActivityV2$collectFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = favoritesActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesActivityV2$collectFlow$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FavoritesActivityViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                Flow<FavPageState> pageState = viewModel.getPageState();
                final FavoritesActivityV2 favoritesActivityV2 = this.this$0;
                this.label = 1;
                if (pageState.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((FavPageState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(FavPageState it, Continuation<? super Unit> continuation) {
                        FavoritesActivityV2.this.showErrorView(it);
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
        return Unit.INSTANCE;
    }
}