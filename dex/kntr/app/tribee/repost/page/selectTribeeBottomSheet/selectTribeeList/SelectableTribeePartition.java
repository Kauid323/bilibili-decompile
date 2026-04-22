package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectTribeeState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "", "id", "", "name", "", "<init>", "(JLjava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectableTribeePartition {
    public static final int $stable = 0;
    private final long id;
    private final String name;

    public static /* synthetic */ SelectableTribeePartition copy$default(SelectableTribeePartition selectableTribeePartition, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = selectableTribeePartition.id;
        }
        if ((i & 2) != 0) {
            str = selectableTribeePartition.name;
        }
        return selectableTribeePartition.copy(j, str);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final SelectableTribeePartition copy(long j, String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new SelectableTribeePartition(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectableTribeePartition) {
            SelectableTribeePartition selectableTribeePartition = (SelectableTribeePartition) obj;
            return this.id == selectableTribeePartition.id && Intrinsics.areEqual(this.name, selectableTribeePartition.name);
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.name.hashCode();
    }

    public String toString() {
        long j = this.id;
        return "SelectableTribeePartition(id=" + j + ", name=" + this.name + ")";
    }

    public SelectableTribeePartition(long id, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}