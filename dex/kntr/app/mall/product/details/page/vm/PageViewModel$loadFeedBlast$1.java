package kntr.app.mall.product.details.page.vm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel", f = "PageViewModel.kt", i = {0}, l = {1710}, m = "loadFeedBlast$product_details_page_debug", n = {"pageNum"}, s = {"I$0"}, v = 1)
public final class PageViewModel$loadFeedBlast$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$loadFeedBlast$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$loadFeedBlast$1> continuation) {
        super(continuation);
        this.this$0 = pageViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadFeedBlast$product_details_page_debug(0, (Continuation) this);
    }
}