package kntr.app.mall.product.details.page.ui.container;

import androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TopContainer.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"kntr/app/mall/product/details/page/ui/container/TopContainerKt$TopTabContainer$itemTabItem$1$1", "Lkntr/app/mall/product/details/page/ui/container/TopTabItem;", "itemKey", "", "getItemKey", "()I", "titleText", "", "getTitleText", "()Ljava/lang/String;", "onSelect", "Lkotlin/Function0;", "", "getOnSelect", "()Lkotlin/jvm/functions/Function0;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TopContainerKt$TopTabContainer$itemTabItem$1$1 implements TopTabItem {
    private final int itemKey;
    private final Function0<Unit> onSelect;
    private final String titleText = "商品";

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopContainerKt$TopTabContainer$itemTabItem$1$1(final PageViewModel $pageViewModel, final CoroutineScope $scope, final LazyStaggeredGridState $listState) {
        this.onSelect = new Function0() { // from class: kntr.app.mall.product.details.page.ui.container.TopContainerKt$TopTabContainer$itemTabItem$1$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onSelect$lambda$0;
                onSelect$lambda$0 = TopContainerKt$TopTabContainer$itemTabItem$1$1.onSelect$lambda$0(PageViewModel.this, $scope, $listState);
                return onSelect$lambda$0;
            }
        };
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopTabItem
    public int getItemKey() {
        return this.itemKey;
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopTabItem
    public String getTitleText() {
        return this.titleText;
    }

    @Override // kntr.app.mall.product.details.page.ui.container.TopTabItem
    public Function0<Unit> getOnSelect() {
        return this.onSelect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onSelect$lambda$0(PageViewModel $pageViewModel, CoroutineScope $scope, LazyStaggeredGridState $listState) {
        $pageViewModel.scrollToTab$product_details_page_debug(0, $scope, $listState);
        return Unit.INSTANCE;
    }
}