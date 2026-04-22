package kntr.common.photonic.aphro.ui.preview.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;

/* compiled from: PreviewImageData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JC\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006\""}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/PreviewImageData;", "", "currentPreviewDataSource", "", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "currentPreviewType", "Lkntr/common/photonic/aphro/ui/preview/model/PageImagePreviewType;", "currentPreviewInitialIndex", "", "currentSelectAlbumId", "", "selectResultMatchKey", "<init>", "(Ljava/util/List;Lkntr/common/photonic/aphro/ui/preview/model/PageImagePreviewType;ILjava/lang/String;Ljava/lang/String;)V", "getCurrentPreviewDataSource", "()Ljava/util/List;", "getCurrentPreviewType", "()Lkntr/common/photonic/aphro/ui/preview/model/PageImagePreviewType;", "getCurrentPreviewInitialIndex", "()I", "getCurrentSelectAlbumId", "()Ljava/lang/String;", "getSelectResultMatchKey", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PreviewImageData {
    public static final int $stable = 8;
    private final List<PreviewableAsset> currentPreviewDataSource;
    private final int currentPreviewInitialIndex;
    private final PageImagePreviewType currentPreviewType;
    private final String currentSelectAlbumId;
    private final String selectResultMatchKey;

    public PreviewImageData() {
        this(null, null, 0, null, null, 31, null);
    }

    public static /* synthetic */ PreviewImageData copy$default(PreviewImageData previewImageData, List list, PageImagePreviewType pageImagePreviewType, int i, String str, String str2, int i2, Object obj) {
        List<PreviewableAsset> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = previewImageData.currentPreviewDataSource;
        }
        if ((i2 & 2) != 0) {
            pageImagePreviewType = previewImageData.currentPreviewType;
        }
        PageImagePreviewType pageImagePreviewType2 = pageImagePreviewType;
        if ((i2 & 4) != 0) {
            i = previewImageData.currentPreviewInitialIndex;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str = previewImageData.currentSelectAlbumId;
        }
        String str3 = str;
        if ((i2 & 16) != 0) {
            str2 = previewImageData.selectResultMatchKey;
        }
        return previewImageData.copy(list2, pageImagePreviewType2, i3, str3, str2);
    }

    public final List<PreviewableAsset> component1() {
        return this.currentPreviewDataSource;
    }

    public final PageImagePreviewType component2() {
        return this.currentPreviewType;
    }

    public final int component3() {
        return this.currentPreviewInitialIndex;
    }

    public final String component4() {
        return this.currentSelectAlbumId;
    }

    public final String component5() {
        return this.selectResultMatchKey;
    }

    public final PreviewImageData copy(List<? extends PreviewableAsset> list, PageImagePreviewType pageImagePreviewType, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "currentPreviewDataSource");
        Intrinsics.checkNotNullParameter(pageImagePreviewType, "currentPreviewType");
        Intrinsics.checkNotNullParameter(str2, "selectResultMatchKey");
        return new PreviewImageData(list, pageImagePreviewType, i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreviewImageData) {
            PreviewImageData previewImageData = (PreviewImageData) obj;
            return Intrinsics.areEqual(this.currentPreviewDataSource, previewImageData.currentPreviewDataSource) && this.currentPreviewType == previewImageData.currentPreviewType && this.currentPreviewInitialIndex == previewImageData.currentPreviewInitialIndex && Intrinsics.areEqual(this.currentSelectAlbumId, previewImageData.currentSelectAlbumId) && Intrinsics.areEqual(this.selectResultMatchKey, previewImageData.selectResultMatchKey);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.currentPreviewDataSource.hashCode() * 31) + this.currentPreviewType.hashCode()) * 31) + this.currentPreviewInitialIndex) * 31) + (this.currentSelectAlbumId == null ? 0 : this.currentSelectAlbumId.hashCode())) * 31) + this.selectResultMatchKey.hashCode();
    }

    public String toString() {
        List<PreviewableAsset> list = this.currentPreviewDataSource;
        PageImagePreviewType pageImagePreviewType = this.currentPreviewType;
        int i = this.currentPreviewInitialIndex;
        String str = this.currentSelectAlbumId;
        return "PreviewImageData(currentPreviewDataSource=" + list + ", currentPreviewType=" + pageImagePreviewType + ", currentPreviewInitialIndex=" + i + ", currentSelectAlbumId=" + str + ", selectResultMatchKey=" + this.selectResultMatchKey + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewImageData(List<? extends PreviewableAsset> list, PageImagePreviewType currentPreviewType, int currentPreviewInitialIndex, String currentSelectAlbumId, String selectResultMatchKey) {
        Intrinsics.checkNotNullParameter(list, "currentPreviewDataSource");
        Intrinsics.checkNotNullParameter(currentPreviewType, "currentPreviewType");
        Intrinsics.checkNotNullParameter(selectResultMatchKey, "selectResultMatchKey");
        this.currentPreviewDataSource = list;
        this.currentPreviewType = currentPreviewType;
        this.currentPreviewInitialIndex = currentPreviewInitialIndex;
        this.currentSelectAlbumId = currentSelectAlbumId;
        this.selectResultMatchKey = selectResultMatchKey;
    }

    public /* synthetic */ PreviewImageData(List list, PageImagePreviewType pageImagePreviewType, int i, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? PageImagePreviewType.IDLE : pageImagePreviewType, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? Uuid.Companion.random().toString() : str2);
    }

    public final List<PreviewableAsset> getCurrentPreviewDataSource() {
        return this.currentPreviewDataSource;
    }

    public final PageImagePreviewType getCurrentPreviewType() {
        return this.currentPreviewType;
    }

    public final int getCurrentPreviewInitialIndex() {
        return this.currentPreviewInitialIndex;
    }

    public final String getCurrentSelectAlbumId() {
        return this.currentSelectAlbumId;
    }

    public final String getSelectResultMatchKey() {
        return this.selectResultMatchKey;
    }
}