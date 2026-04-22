package kntr.app.mall.product.details.page.ui.screen;

import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class ContentScreenKt$ContentScreen$1$7$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentScreenKt$ContentScreen$1$7$1(Object obj) {
        super(1, obj, PageViewModel.class, "toggleHeaderFullScreenPreview", "toggleHeaderFullScreenPreview$product_details_page_debug(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p0) {
        ((PageViewModel) this.receiver).toggleHeaderFullScreenPreview$product_details_page_debug(p0);
    }
}