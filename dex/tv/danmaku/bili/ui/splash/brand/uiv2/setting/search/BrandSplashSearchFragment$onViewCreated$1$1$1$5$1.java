package tv.danmaku.bili.ui.splash.brand.uiv2.setting.search;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSearchFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$5$1", f = "BrandSplashSearchFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSearchFragment$onViewCreated$1$1$1$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyListState $listState;
    int label;
    final /* synthetic */ BrandSplashSearchFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSearchFragment$onViewCreated$1$1$1$5$1(LazyListState lazyListState, BrandSplashSearchFragment brandSplashSearchFragment, Continuation<? super BrandSplashSearchFragment$onViewCreated$1$1$1$5$1> continuation) {
        super(2, continuation);
        this.$listState = lazyListState;
        this.this$0 = brandSplashSearchFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSearchFragment$onViewCreated$1$1$1$5$1(this.$listState, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final LazyListState lazyListState = this.$listState;
                Flow conflate = FlowKt.conflate(SnapshotStateKt.snapshotFlow(new Function0() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$5$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = BrandSplashSearchFragment$onViewCreated$1$1$1$5$1.invokeSuspend$lambda$0(lazyListState);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                }));
                final BrandSplashSearchFragment brandSplashSearchFragment = this.this$0;
                this.label = 1;
                if (conflate.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.search.BrandSplashSearchFragment$onViewCreated$1$1$1$5$1.2
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit(((Boolean) value).booleanValue(), $completion);
                    }

                    public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                        BrandSplashSettingViewModel vm;
                        if (it) {
                            vm = BrandSplashSearchFragment.this.getVm();
                            vm.getSearchPageViewModel().search();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(LazyListState $listState) {
        LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull($listState.getLayoutInfo().getVisibleItemsInfo());
        return lastVisibleItem != null && lastVisibleItem.getIndex() >= $listState.getLayoutInfo().getTotalItemsCount();
    }
}