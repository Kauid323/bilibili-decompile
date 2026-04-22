package kntr.app.mall.product.details.page.vm;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
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
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$scrollToTab$1", f = "PageViewModel.kt", i = {0}, l = {513}, m = "invokeSuspend", n = {"scrollOffset"}, s = {"I$0"}, v = 1)
public final class PageViewModel$scrollToTab$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LazyStaggeredGridState $listState;
    final /* synthetic */ int $tabIndex;
    int I$0;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$scrollToTab$1(int i, PageViewModel pageViewModel, LazyStaggeredGridState lazyStaggeredGridState, Continuation<? super PageViewModel$scrollToTab$1> continuation) {
        super(2, continuation);
        this.$tabIndex = i;
        this.this$0 = pageViewModel;
        this.$listState = lazyStaggeredGridState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PageViewModel$scrollToTab$1(this.$tabIndex, this.this$0, this.$listState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int scrollOffset;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    if (this.$tabIndex == 0) {
                        scrollOffset = 0;
                    } else {
                        scrollOffset = -((Number) this.this$0.getTopContainerHeightFlow().getValue()).intValue();
                    }
                    if (this.$tabIndex < this.$listState.getLayoutInfo().getTotalItemsCount()) {
                        this.I$0 = scrollOffset;
                        this.label = 1;
                        if (this.$listState.scrollToItem(this.$tabIndex, scrollOffset, (Continuation) this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        ILogger kLog = KLog_androidKt.getKLog();
                        int i = this.$tabIndex;
                        kLog.e("PageViewModel", "滚动索引越界: " + i + ", 总项数: " + this.$listState.getLayoutInfo().getTotalItemsCount());
                        break;
                    }
                case 1:
                    int i2 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("PageViewModel", "滚动发生错误: " + e.getMessage(), e);
        }
        return Unit.INSTANCE;
    }
}