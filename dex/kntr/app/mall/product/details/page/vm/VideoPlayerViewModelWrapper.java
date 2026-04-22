package kntr.app.mall.product.details.page.vm;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "", "viewModel", "Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModel;", "<init>", "(Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModel;)V", "getViewModel", "()Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModel;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoPlayerViewModelWrapper {
    public static final int $stable = 8;
    private final VideoPlayerViewModel viewModel;

    public VideoPlayerViewModelWrapper(VideoPlayerViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
    }

    public final VideoPlayerViewModel getViewModel() {
        return this.viewModel;
    }
}