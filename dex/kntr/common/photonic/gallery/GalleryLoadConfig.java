package kntr.common.photonic.gallery;

import java.util.List;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.MimeType;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GalleryLoadConfig.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lkntr/common/photonic/gallery/GalleryLoadConfig;", "", "mediaType", "Lkntr/common/photonic/gallery/GalleryLoadConfig$MediaType;", "transformOptions", "", "Lkntr/common/photonic/gallery/GalleryLoadConfig$TransformOption;", "pagination", "Lkntr/common/photonic/gallery/Pagination;", "<init>", "(Lkntr/common/photonic/gallery/GalleryLoadConfig$MediaType;Ljava/util/Set;Lkntr/common/photonic/gallery/Pagination;)V", "getMediaType", "()Lkntr/common/photonic/gallery/GalleryLoadConfig$MediaType;", "getTransformOptions", "()Ljava/util/Set;", "getPagination", "()Lkntr/common/photonic/gallery/Pagination;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "MediaType", "TransformOption", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GalleryLoadConfig {
    public static final int $stable = 8;
    private final MediaType mediaType;
    private final Pagination pagination;
    private final Set<TransformOption> transformOptions;

    /* compiled from: GalleryLoadConfig.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/common/photonic/gallery/GalleryLoadConfig$TransformOption;", "", "<init>", "(Ljava/lang/String;I)V", "LIVE_PHOTO_AS_IMAGE", "ONLY_IMAGE_FIRST_FRAME", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum TransformOption {
        LIVE_PHOTO_AS_IMAGE,
        ONLY_IMAGE_FIRST_FRAME;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<TransformOption> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GalleryLoadConfig copy$default(GalleryLoadConfig galleryLoadConfig, MediaType mediaType, Set set, Pagination pagination, int i, Object obj) {
        if ((i & 1) != 0) {
            mediaType = galleryLoadConfig.mediaType;
        }
        if ((i & 2) != 0) {
            set = galleryLoadConfig.transformOptions;
        }
        if ((i & 4) != 0) {
            pagination = galleryLoadConfig.pagination;
        }
        return galleryLoadConfig.copy(mediaType, set, pagination);
    }

    public final MediaType component1() {
        return this.mediaType;
    }

    public final Set<TransformOption> component2() {
        return this.transformOptions;
    }

    public final Pagination component3() {
        return this.pagination;
    }

    public final GalleryLoadConfig copy(MediaType mediaType, Set<? extends TransformOption> set, Pagination pagination) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(set, "transformOptions");
        return new GalleryLoadConfig(mediaType, set, pagination);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GalleryLoadConfig) {
            GalleryLoadConfig galleryLoadConfig = (GalleryLoadConfig) obj;
            return this.mediaType == galleryLoadConfig.mediaType && Intrinsics.areEqual(this.transformOptions, galleryLoadConfig.transformOptions) && Intrinsics.areEqual(this.pagination, galleryLoadConfig.pagination);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mediaType.hashCode() * 31) + this.transformOptions.hashCode()) * 31) + (this.pagination == null ? 0 : this.pagination.hashCode());
    }

    public String toString() {
        MediaType mediaType = this.mediaType;
        Set<TransformOption> set = this.transformOptions;
        return "GalleryLoadConfig(mediaType=" + mediaType + ", transformOptions=" + set + ", pagination=" + this.pagination + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GalleryLoadConfig(MediaType mediaType, Set<? extends TransformOption> set, Pagination pagination) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(set, "transformOptions");
        this.mediaType = mediaType;
        this.transformOptions = set;
        this.pagination = pagination;
    }

    public /* synthetic */ GalleryLoadConfig(MediaType mediaType, Set set, Pagination pagination, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaType, (i & 2) != 0 ? SetsKt.emptySet() : set, (i & 4) != 0 ? null : pagination);
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final Set<TransformOption> getTransformOptions() {
        return this.transformOptions;
    }

    public final Pagination getPagination() {
        return this.pagination;
    }

    /* compiled from: GalleryLoadConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lkntr/common/photonic/gallery/GalleryLoadConfig$MediaType;", "", "forType", "", "Lkntr/common/photonic/MimeType;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getForType", "()Ljava/util/List;", "ALL", "IMAGE", "VIDEO", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public enum MediaType {
        ALL(MimeType.Companion.getALL()),
        IMAGE(MimeType.Companion.getIMAGES()),
        VIDEO(MimeType.Companion.getVIDEOS());
        
        private final List<MimeType> forType;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<MediaType> getEntries() {
            return $ENTRIES;
        }

        MediaType(List forType) {
            this.forType = forType;
        }

        public final List<MimeType> getForType() {
            return this.forType;
        }
    }
}