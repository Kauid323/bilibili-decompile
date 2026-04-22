package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/base/imageloader/ImageSource;", "", "error", "Lkntr/base/imageloader/ImageException;", "source", "Lkntr/base/imageloader/Image;", "<init>", "(Lkntr/base/imageloader/ImageException;Lkntr/base/imageloader/Image;)V", "getError", "()Lkntr/base/imageloader/ImageException;", "getSource", "()Lkntr/base/imageloader/Image;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImageSource {
    public static final int $stable = 0;
    private final ImageException error;
    private final Image source;

    public ImageSource() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ImageSource copy$default(ImageSource imageSource, ImageException imageException, Image image, int i, Object obj) {
        if ((i & 1) != 0) {
            imageException = imageSource.error;
        }
        if ((i & 2) != 0) {
            image = imageSource.source;
        }
        return imageSource.copy(imageException, image);
    }

    public final ImageException component1() {
        return this.error;
    }

    public final Image component2() {
        return this.source;
    }

    public final ImageSource copy(ImageException imageException, Image image) {
        return new ImageSource(imageException, image);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImageSource) {
            ImageSource imageSource = (ImageSource) obj;
            return Intrinsics.areEqual(this.error, imageSource.error) && Intrinsics.areEqual(this.source, imageSource.source);
        }
        return false;
    }

    public int hashCode() {
        return ((this.error == null ? 0 : this.error.hashCode()) * 31) + (this.source != null ? this.source.hashCode() : 0);
    }

    public String toString() {
        ImageException imageException = this.error;
        return "ImageSource(error=" + imageException + ", source=" + this.source + ")";
    }

    public ImageSource(ImageException error, Image source) {
        this.error = error;
        this.source = source;
    }

    public /* synthetic */ ImageSource(ImageException imageException, Image image, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : imageException, (i & 2) != 0 ? null : image);
    }

    public final ImageException getError() {
        return this.error;
    }

    public final Image getSource() {
        return this.source;
    }
}