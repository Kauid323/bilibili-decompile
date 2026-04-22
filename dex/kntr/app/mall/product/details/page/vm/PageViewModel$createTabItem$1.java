package kntr.app.mall.product.details.page.vm;

import androidx.lifecycle.ViewModelKt;
import kntr.app.mall.product.details.page.ui.container.TopTabItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"kntr/app/mall/product/details/page/vm/PageViewModel$createTabItem$1", "Lkntr/app/mall/product/details/page/ui/container/TopTabItem;", "itemKey", "", "getItemKey", "()I", "titleText", "", "getTitleText", "()Ljava/lang/String;", "onSelect", "Lkotlin/Function0;", "", "getOnSelect", "()Lkotlin/jvm/functions/Function0;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PageViewModel$createTabItem$1 implements TopTabItem {
    private final int itemKey;
    private final Function0<Unit> onSelect;
    private final String titleText;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageViewModel$createTabItem$1(int $itemKey, String $title, final PageViewModel $receiver, final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        this.itemKey = $itemKey;
        this.titleText = $title;
        this.onSelect = new Function0() { // from class: kntr.app.mall.product.details.page.vm.PageViewModel$createTabItem$1$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onSelect$lambda$0;
                onSelect$lambda$0 = PageViewModel$createTabItem$1.onSelect$lambda$0(PageViewModel.this, function1);
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
    public static final Unit onSelect$lambda$0(PageViewModel this$0, Function1 $onClick) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this$0), (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$createTabItem$1$onSelect$1$1($onClick, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}