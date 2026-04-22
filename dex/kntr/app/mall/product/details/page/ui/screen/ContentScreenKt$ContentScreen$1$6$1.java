package kntr.app.mall.product.details.page.ui.screen;

import kntr.app.mall.product.details.page.vm.VideoPlayerViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentScreen.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class ContentScreenKt$ContentScreen$1$6$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentScreenKt$ContentScreen$1$6$1(Object obj) {
        super(0, obj, VideoPlayerViewModel.class, "toggleMuted", "toggleMuted$product_details_page_debug()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m626invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m626invoke() {
        ((VideoPlayerViewModel) this.receiver).toggleMuted$product_details_page_debug();
    }
}