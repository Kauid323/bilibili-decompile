package kntr.common.photonic.aphro.ui.preview.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewDataSource.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003JC\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;", "", "dataSource", "", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "initialIndex", "", "imagePreviewType", "Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewOptions;", "initialAlbumId", "", "<init>", "(Ljava/util/List;ILkntr/common/photonic/aphro/ui/preview/ImagePreviewType;Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewOptions;Ljava/lang/String;)V", "getDataSource", "()Ljava/util/List;", "getInitialIndex", "()I", "getImagePreviewType", "()Lkntr/common/photonic/aphro/ui/preview/ImagePreviewType;", "getOption", "()Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewOptions;", "getInitialAlbumId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewDataSource {
    public static final int $stable = 0;
    private final List<PreviewableAsset> dataSource;
    private final ImagePreviewType imagePreviewType;
    private final String initialAlbumId;
    private final int initialIndex;
    private final ImagePreviewOptions option;

    public static /* synthetic */ ImagePreviewDataSource copy$default(ImagePreviewDataSource imagePreviewDataSource, List list, int i, ImagePreviewType imagePreviewType, ImagePreviewOptions imagePreviewOptions, String str, int i2, Object obj) {
        List<PreviewableAsset> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = imagePreviewDataSource.dataSource;
        }
        if ((i2 & 2) != 0) {
            i = imagePreviewDataSource.initialIndex;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            imagePreviewType = imagePreviewDataSource.imagePreviewType;
        }
        ImagePreviewType imagePreviewType2 = imagePreviewType;
        if ((i2 & 8) != 0) {
            imagePreviewOptions = imagePreviewDataSource.option;
        }
        ImagePreviewOptions imagePreviewOptions2 = imagePreviewOptions;
        if ((i2 & 16) != 0) {
            str = imagePreviewDataSource.initialAlbumId;
        }
        return imagePreviewDataSource.copy(list2, i3, imagePreviewType2, imagePreviewOptions2, str);
    }

    public final List<PreviewableAsset> component1() {
        return this.dataSource;
    }

    public final int component2() {
        return this.initialIndex;
    }

    public final ImagePreviewType component3() {
        return this.imagePreviewType;
    }

    public final ImagePreviewOptions component4() {
        return this.option;
    }

    public final String component5() {
        return this.initialAlbumId;
    }

    public final ImagePreviewDataSource copy(List<? extends PreviewableAsset> list, int i, ImagePreviewType imagePreviewType, ImagePreviewOptions imagePreviewOptions, String str) {
        Intrinsics.checkNotNullParameter(list, "dataSource");
        Intrinsics.checkNotNullParameter(imagePreviewType, "imagePreviewType");
        Intrinsics.checkNotNullParameter(imagePreviewOptions, WatchLaterReporterKt.KEY_OPTION);
        return new ImagePreviewDataSource(list, i, imagePreviewType, imagePreviewOptions, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ImagePreviewDataSource) {
            ImagePreviewDataSource imagePreviewDataSource = (ImagePreviewDataSource) obj;
            return Intrinsics.areEqual(this.dataSource, imagePreviewDataSource.dataSource) && this.initialIndex == imagePreviewDataSource.initialIndex && Intrinsics.areEqual(this.imagePreviewType, imagePreviewDataSource.imagePreviewType) && Intrinsics.areEqual(this.option, imagePreviewDataSource.option) && Intrinsics.areEqual(this.initialAlbumId, imagePreviewDataSource.initialAlbumId);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.dataSource.hashCode() * 31) + this.initialIndex) * 31) + this.imagePreviewType.hashCode()) * 31) + this.option.hashCode()) * 31) + (this.initialAlbumId == null ? 0 : this.initialAlbumId.hashCode());
    }

    public String toString() {
        List<PreviewableAsset> list = this.dataSource;
        int i = this.initialIndex;
        ImagePreviewType imagePreviewType = this.imagePreviewType;
        ImagePreviewOptions imagePreviewOptions = this.option;
        return "ImagePreviewDataSource(dataSource=" + list + ", initialIndex=" + i + ", imagePreviewType=" + imagePreviewType + ", option=" + imagePreviewOptions + ", initialAlbumId=" + this.initialAlbumId + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImagePreviewDataSource(List<? extends PreviewableAsset> list, int initialIndex, ImagePreviewType imagePreviewType, ImagePreviewOptions option, String initialAlbumId) {
        Intrinsics.checkNotNullParameter(list, "dataSource");
        Intrinsics.checkNotNullParameter(imagePreviewType, "imagePreviewType");
        Intrinsics.checkNotNullParameter(option, WatchLaterReporterKt.KEY_OPTION);
        this.dataSource = list;
        this.initialIndex = initialIndex;
        this.imagePreviewType = imagePreviewType;
        this.option = option;
        this.initialAlbumId = initialAlbumId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ImagePreviewDataSource(List list, int i, ImagePreviewType imagePreviewType, ImagePreviewOptions imagePreviewOptions, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i, imagePreviewType, r5, r6);
        ImagePreviewOptions imagePreviewOptions2;
        String str2;
        if ((i2 & 8) == 0) {
            imagePreviewOptions2 = imagePreviewOptions;
        } else {
            imagePreviewOptions2 = new ImagePreviewOptions(null, 1, null);
        }
        if ((i2 & 16) == 0) {
            str2 = str;
        } else {
            str2 = null;
        }
    }

    public final List<PreviewableAsset> getDataSource() {
        return this.dataSource;
    }

    public final int getInitialIndex() {
        return this.initialIndex;
    }

    public final ImagePreviewType getImagePreviewType() {
        return this.imagePreviewType;
    }

    public final ImagePreviewOptions getOption() {
        return this.option;
    }

    public final String getInitialAlbumId() {
        return this.initialAlbumId;
    }
}