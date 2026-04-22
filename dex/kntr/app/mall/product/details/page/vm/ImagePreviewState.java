package kntr.app.mall.product.details.page.vm;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewModels.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u001b\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001a"}, d2 = {"Lkntr/app/mall/product/details/page/vm/ImagePreviewState;", "", "imageUrls", "", "", "index", "", "imageSizes", "Lkotlin/Pair;", "", "<init>", "(Ljava/util/List;ILjava/util/List;)V", "getImageUrls", "()Ljava/util/List;", "getIndex", "()I", "getImageSizes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewState {
    public static final int $stable = 8;
    private final List<Pair<Float, Float>> imageSizes;
    private final List<String> imageUrls;
    private final int index;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImagePreviewState copy$default(ImagePreviewState imagePreviewState, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = imagePreviewState.imageUrls;
        }
        if ((i2 & 2) != 0) {
            i = imagePreviewState.index;
        }
        if ((i2 & 4) != 0) {
            list2 = imagePreviewState.imageSizes;
        }
        return imagePreviewState.copy(list, i, list2);
    }

    public final List<String> component1() {
        return this.imageUrls;
    }

    public final int component2() {
        return this.index;
    }

    public final List<Pair<Float, Float>> component3() {
        return this.imageSizes;
    }

    public final ImagePreviewState copy(List<String> list, int i, List<Pair<Float, Float>> list2) {
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(list2, "imageSizes");
        return new ImagePreviewState(list, i, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePreviewState) {
            ImagePreviewState imagePreviewState = (ImagePreviewState) obj;
            return Intrinsics.areEqual(this.imageUrls, imagePreviewState.imageUrls) && this.index == imagePreviewState.index && Intrinsics.areEqual(this.imageSizes, imagePreviewState.imageSizes);
        }
        return false;
    }

    public int hashCode() {
        return (((this.imageUrls.hashCode() * 31) + this.index) * 31) + this.imageSizes.hashCode();
    }

    public String toString() {
        List<String> list = this.imageUrls;
        int i = this.index;
        return "ImagePreviewState(imageUrls=" + list + ", index=" + i + ", imageSizes=" + this.imageSizes + ")";
    }

    public ImagePreviewState(List<String> list, int index, List<Pair<Float, Float>> list2) {
        Intrinsics.checkNotNullParameter(list, "imageUrls");
        Intrinsics.checkNotNullParameter(list2, "imageSizes");
        this.imageUrls = list;
        this.index = index;
        this.imageSizes = list2;
    }

    public /* synthetic */ ImagePreviewState(List list, int i, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<String> getImageUrls() {
        return this.imageUrls;
    }

    public final int getIndex() {
        return this.index;
    }

    public final List<Pair<Float, Float>> getImageSizes() {
        return this.imageSizes;
    }
}