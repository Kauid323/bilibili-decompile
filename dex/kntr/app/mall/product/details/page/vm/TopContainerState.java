package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/mall/product/details/page/vm/TopContainerState;", "", "data", "Lkntr/app/mall/product/details/page/vm/ContentModule$HeaderModule;", "<init>", "(Lkntr/app/mall/product/details/page/vm/ContentModule$HeaderModule;)V", "getData", "()Lkntr/app/mall/product/details/page/vm/ContentModule$HeaderModule;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TopContainerState {
    public static final int $stable = 8;
    private final ContentModule.HeaderModule data;

    public static /* synthetic */ TopContainerState copy$default(TopContainerState topContainerState, ContentModule.HeaderModule headerModule, int i, Object obj) {
        if ((i & 1) != 0) {
            headerModule = topContainerState.data;
        }
        return topContainerState.copy(headerModule);
    }

    public final ContentModule.HeaderModule component1() {
        return this.data;
    }

    public final TopContainerState copy(ContentModule.HeaderModule headerModule) {
        Intrinsics.checkNotNullParameter(headerModule, "data");
        return new TopContainerState(headerModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TopContainerState) && Intrinsics.areEqual(this.data, ((TopContainerState) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "TopContainerState(data=" + this.data + ")";
    }

    public TopContainerState(ContentModule.HeaderModule data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final ContentModule.HeaderModule getData() {
        return this.data;
    }
}