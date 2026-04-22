package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.vm.ContentModule;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/mall/product/details/page/vm/BottomContainerState;", "", "data", "Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;", "<init>", "(Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;)V", "getData", "()Lkntr/app/mall/product/details/page/vm/ContentModule$FooterModule;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BottomContainerState {
    public static final int $stable = 8;
    private final ContentModule.FooterModule data;

    public static /* synthetic */ BottomContainerState copy$default(BottomContainerState bottomContainerState, ContentModule.FooterModule footerModule, int i, Object obj) {
        if ((i & 1) != 0) {
            footerModule = bottomContainerState.data;
        }
        return bottomContainerState.copy(footerModule);
    }

    public final ContentModule.FooterModule component1() {
        return this.data;
    }

    public final BottomContainerState copy(ContentModule.FooterModule footerModule) {
        Intrinsics.checkNotNullParameter(footerModule, "data");
        return new BottomContainerState(footerModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BottomContainerState) && Intrinsics.areEqual(this.data, ((BottomContainerState) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "BottomContainerState(data=" + this.data + ")";
    }

    public BottomContainerState(ContentModule.FooterModule data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public final ContentModule.FooterModule getData() {
        return this.data;
    }
}