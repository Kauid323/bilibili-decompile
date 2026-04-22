package kntr.app.mall.product.details.page.vm;

import BottomSheetItemData$;
import androidx.collection.DoubleList$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ImageBottomSheetState;", "", "show", "", "imageUrl", "", "imageWidth", "", "imageHeight", "<init>", "(ZLjava/lang/String;DD)V", "getShow", "()Z", "getImageUrl", "()Ljava/lang/String;", "getImageWidth", "()D", "getImageHeight", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageBottomSheetState {
    public static final int $stable = 0;
    private final double imageHeight;
    private final String imageUrl;
    private final double imageWidth;
    private final boolean show;

    public static /* synthetic */ ImageBottomSheetState copy$default(ImageBottomSheetState imageBottomSheetState, boolean z, String str, double d, double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = imageBottomSheetState.show;
        }
        if ((i & 2) != 0) {
            str = imageBottomSheetState.imageUrl;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            d = imageBottomSheetState.imageWidth;
        }
        double d3 = d;
        if ((i & 8) != 0) {
            d2 = imageBottomSheetState.imageHeight;
        }
        return imageBottomSheetState.copy(z, str2, d3, d2);
    }

    public final boolean component1() {
        return this.show;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final double component3() {
        return this.imageWidth;
    }

    public final double component4() {
        return this.imageHeight;
    }

    public final ImageBottomSheetState copy(boolean z, String str, double d, double d2) {
        Intrinsics.checkNotNullParameter(str, "imageUrl");
        return new ImageBottomSheetState(z, str, d, d2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageBottomSheetState) {
            ImageBottomSheetState imageBottomSheetState = (ImageBottomSheetState) obj;
            return this.show == imageBottomSheetState.show && Intrinsics.areEqual(this.imageUrl, imageBottomSheetState.imageUrl) && Double.compare(this.imageWidth, imageBottomSheetState.imageWidth) == 0 && Double.compare(this.imageHeight, imageBottomSheetState.imageHeight) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.show) * 31) + this.imageUrl.hashCode()) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.imageWidth)) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.imageHeight);
    }

    public String toString() {
        boolean z = this.show;
        String str = this.imageUrl;
        double d = this.imageWidth;
        return "ImageBottomSheetState(show=" + z + ", imageUrl=" + str + ", imageWidth=" + d + ", imageHeight=" + this.imageHeight + ")";
    }

    public ImageBottomSheetState(boolean show, String imageUrl, double imageWidth, double imageHeight) {
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        this.show = show;
        this.imageUrl = imageUrl;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final double getImageWidth() {
        return this.imageWidth;
    }

    public final double getImageHeight() {
        return this.imageHeight;
    }
}