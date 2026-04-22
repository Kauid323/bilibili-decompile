package kntr.common.photonic.aphro.ui.preview;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePreviewLauncher.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/DataSourceState;", "", "dataSource", "", "Lkntr/common/photonic/aphro/ui/preview/model/PreviewableAsset;", "initialIndex", "", "<init>", "(Ljava/util/List;I)V", "getDataSource", "()Ljava/util/List;", "getInitialIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DataSourceState {
    public static final int $stable = 8;
    private final List<PreviewableAsset> dataSource;
    private final int initialIndex;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DataSourceState copy$default(DataSourceState dataSourceState, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = dataSourceState.dataSource;
        }
        if ((i2 & 2) != 0) {
            i = dataSourceState.initialIndex;
        }
        return dataSourceState.copy(list, i);
    }

    public final List<PreviewableAsset> component1() {
        return this.dataSource;
    }

    public final int component2() {
        return this.initialIndex;
    }

    public final DataSourceState copy(List<? extends PreviewableAsset> list, int i) {
        Intrinsics.checkNotNullParameter(list, "dataSource");
        return new DataSourceState(list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DataSourceState) {
            DataSourceState dataSourceState = (DataSourceState) obj;
            return Intrinsics.areEqual(this.dataSource, dataSourceState.dataSource) && this.initialIndex == dataSourceState.initialIndex;
        }
        return false;
    }

    public int hashCode() {
        return (this.dataSource.hashCode() * 31) + this.initialIndex;
    }

    public String toString() {
        List<PreviewableAsset> list = this.dataSource;
        return "DataSourceState(dataSource=" + list + ", initialIndex=" + this.initialIndex + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DataSourceState(List<? extends PreviewableAsset> list, int initialIndex) {
        Intrinsics.checkNotNullParameter(list, "dataSource");
        this.dataSource = list;
        this.initialIndex = initialIndex;
    }

    public final List<PreviewableAsset> getDataSource() {
        return this.dataSource;
    }

    public final int getInitialIndex() {
        return this.initialIndex;
    }
}