package kntr.common.photonic.gallery;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: GalleryLoadConfig.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/photonic/gallery/Pagination;", "", "page", "", "pageSize", "<init>", "(II)V", "getPage", "()I", "getPageSize", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Pagination {
    public static final int $stable = 0;
    private final int page;
    private final int pageSize;

    public static /* synthetic */ Pagination copy$default(Pagination pagination, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = pagination.page;
        }
        if ((i3 & 2) != 0) {
            i2 = pagination.pageSize;
        }
        return pagination.copy(i, i2);
    }

    public final int component1() {
        return this.page;
    }

    public final int component2() {
        return this.pageSize;
    }

    public final Pagination copy(int i, int i2) {
        return new Pagination(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pagination) {
            Pagination pagination = (Pagination) obj;
            return this.page == pagination.page && this.pageSize == pagination.pageSize;
        }
        return false;
    }

    public int hashCode() {
        return (this.page * 31) + this.pageSize;
    }

    public String toString() {
        int i = this.page;
        return "Pagination(page=" + i + ", pageSize=" + this.pageSize + ")";
    }

    public Pagination(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }
}