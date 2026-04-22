package tv.danmaku.bili.ui.favorites.fragment;

import java.util.List;
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
import tv.danmaku.bili.ui.favorites.model.FavoritesMediasItem;

/* compiled from: FavoritesTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$2", f = "FavoritesTabFragment.kt", i = {}, l = {BR.imageBadge}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesTabFragment$onViewCreated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesTabFragment$onViewCreated$2(FavoritesTabFragment favoritesTabFragment, Continuation<? super FavoritesTabFragment$onViewCreated$2> continuation) {
        super(2, continuation);
        this.this$0 = favoritesTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesTabFragment$onViewCreated$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<List<FavoritesMediasItem>> itemListFlow = this.this$0.getViewModel().getItemListFlow();
                final FavoritesTabFragment favoritesTabFragment = this.this$0;
                this.label = 1;
                if (itemListFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((List) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(List<FavoritesMediasItem> list, Continuation<? super Unit> continuation) {
                        FavoritesTabFragment.this.getAdapter().submitList(list);
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