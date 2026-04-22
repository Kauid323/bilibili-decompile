package tv.danmaku.bili.ui.favorites.fragment;

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
import tv.danmaku.bili.ui.favorites.viewmodel.FolderListViewModel;

/* compiled from: FavoritesFolderTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$4", f = "FavoritesFolderTabFragment.kt", i = {}, l = {BR.followedCountText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesFolderTabFragment$onViewCreated$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesFolderTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesFolderTabFragment$onViewCreated$4(FavoritesFolderTabFragment favoritesFolderTabFragment, Continuation<? super FavoritesFolderTabFragment$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = favoritesFolderTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesFolderTabFragment$onViewCreated$4(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FolderListViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                Flow<Boolean> isRefreshing = viewModel.isRefreshing();
                final FavoritesFolderTabFragment favoritesFolderTabFragment = this.this$0;
                this.label = 1;
                if (isRefreshing.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesFolderTabFragment$onViewCreated$4.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        FavoritesFolderTabFragment.this.getBinding().swipeLayout.setRefreshing(it);
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