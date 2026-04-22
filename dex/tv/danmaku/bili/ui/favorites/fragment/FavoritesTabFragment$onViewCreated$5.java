package tv.danmaku.bili.ui.favorites.fragment;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.state.FavPageFooterState;

/* compiled from: FavoritesTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$5", f = "FavoritesTabFragment.kt", i = {}, l = {BR.info}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FavoritesTabFragment$onViewCreated$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesTabFragment$onViewCreated$5(FavoritesTabFragment favoritesTabFragment, Continuation<? super FavoritesTabFragment$onViewCreated$5> continuation) {
        super(2, continuation);
        this.this$0 = favoritesTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesTabFragment$onViewCreated$5(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<FavPageFooterState> footerStateFlow = this.this$0.getViewModel().getFooterStateFlow();
                final FavoritesTabFragment favoritesTabFragment = this.this$0;
                this.label = 1;
                if (footerStateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.favorites.fragment.FavoritesTabFragment$onViewCreated$5.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((FavPageFooterState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(FavPageFooterState it, Continuation<? super Unit> continuation) {
                        if (Intrinsics.areEqual(it, FavPageFooterState.CleanInvalid.INSTANCE)) {
                            FavoritesTabFragment.this.getAdapter().showFooterCleanInvalid();
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
        return Unit.INSTANCE;
    }
}