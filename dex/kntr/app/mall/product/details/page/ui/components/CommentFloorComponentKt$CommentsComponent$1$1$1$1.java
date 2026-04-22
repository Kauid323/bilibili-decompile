package kntr.app.mall.product.details.page.ui.components;

import java.util.List;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommentFloorComponent.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final /* synthetic */ class CommentFloorComponentKt$CommentsComponent$1$1$1$1 extends FunctionReferenceImpl implements Function3<List<? extends String>, Integer, List<? extends Pair<? extends Float, ? extends Float>>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CommentFloorComponentKt$CommentsComponent$1$1$1$1(Object obj) {
        super(3, obj, PageViewModel.class, "updateImagePreview", "updateImagePreview$product_details_page_debug(Ljava/util/List;ILjava/util/List;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
        invoke((List) p1, ((Number) p2).intValue(), (List) p3);
        return Unit.INSTANCE;
    }

    public final void invoke(List<String> list, int p1, List<Pair<Float, Float>> list2) {
        Intrinsics.checkNotNullParameter(list2, "p2");
        ((PageViewModel) this.receiver).updateImagePreview$product_details_page_debug(list, p1, list2);
    }
}