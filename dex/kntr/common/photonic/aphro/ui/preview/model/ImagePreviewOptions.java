package kntr.common.photonic.aphro.ui.preview.model;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewDataSource.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewOptions;", "", "originImageHint", "Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "<init>", "(Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;)V", "getOriginImageHint", "()Lkntr/common/photonic/aphro/ui/preview/model/OriginImageHint;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewOptions {
    public static final int $stable = 0;
    private final OriginImageHint originImageHint;

    public ImagePreviewOptions() {
        this(null, 1, null);
    }

    public static /* synthetic */ ImagePreviewOptions copy$default(ImagePreviewOptions imagePreviewOptions, OriginImageHint originImageHint, int i, Object obj) {
        if ((i & 1) != 0) {
            originImageHint = imagePreviewOptions.originImageHint;
        }
        return imagePreviewOptions.copy(originImageHint);
    }

    public final OriginImageHint component1() {
        return this.originImageHint;
    }

    public final ImagePreviewOptions copy(OriginImageHint originImageHint) {
        Intrinsics.checkNotNullParameter(originImageHint, "originImageHint");
        return new ImagePreviewOptions(originImageHint);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ImagePreviewOptions) && Intrinsics.areEqual(this.originImageHint, ((ImagePreviewOptions) obj).originImageHint);
    }

    public int hashCode() {
        return this.originImageHint.hashCode();
    }

    public String toString() {
        return "ImagePreviewOptions(originImageHint=" + this.originImageHint + ")";
    }

    public ImagePreviewOptions(OriginImageHint originImageHint) {
        Intrinsics.checkNotNullParameter(originImageHint, "originImageHint");
        this.originImageHint = originImageHint;
    }

    public /* synthetic */ ImagePreviewOptions(OriginImageHint originImageHint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ImagePreviewDataSourceKt.OriginImageHint() : originImageHint);
    }

    public final OriginImageHint getOriginImageHint() {
        return this.originImageHint;
    }
}