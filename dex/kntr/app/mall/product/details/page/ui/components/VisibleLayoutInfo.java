package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.ui.geometry.Rect;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/app/mall/product/details/page/ui/components/VisibleLayoutInfo;", "", "visibleRect", "Landroidx/compose/ui/geometry/Rect;", "fullRect", "<init>", "(Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;)V", "getVisibleRect", "()Landroidx/compose/ui/geometry/Rect;", "visibleProportion", "", "getVisibleProportion", "()F", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VisibleLayoutInfo {
    public static final int $stable = 0;
    private final float visibleProportion;
    private final Rect visibleRect;

    public VisibleLayoutInfo(Rect visibleRect, Rect fullRect) {
        Intrinsics.checkNotNullParameter(visibleRect, "visibleRect");
        Intrinsics.checkNotNullParameter(fullRect, "fullRect");
        this.visibleRect = visibleRect;
        Rect this_$iv = this.visibleRect;
        Rect this_$iv2 = this.visibleRect;
        this.visibleProportion = ((this_$iv.getRight() - this_$iv.getLeft()) / (fullRect.getRight() - fullRect.getLeft())) * ((this_$iv2.getBottom() - this_$iv2.getTop()) / (fullRect.getBottom() - fullRect.getTop()));
    }

    public final Rect getVisibleRect() {
        return this.visibleRect;
    }

    public final float getVisibleProportion() {
        return this.visibleProportion;
    }
}