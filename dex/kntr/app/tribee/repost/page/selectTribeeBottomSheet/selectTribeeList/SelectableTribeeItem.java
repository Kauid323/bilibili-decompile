package kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectTribeeState.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "", "id", "", "name", "", "desc", "imageUrl", "partitions", "", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getDesc", "getImageUrl", "getPartitions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectableTribeeItem {
    public static final int $stable = 0;
    private final String desc;
    private final long id;
    private final String imageUrl;
    private final String name;
    private final List<SelectableTribeePartition> partitions;

    public static /* synthetic */ SelectableTribeeItem copy$default(SelectableTribeeItem selectableTribeeItem, long j, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = selectableTribeeItem.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = selectableTribeeItem.name;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = selectableTribeeItem.desc;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = selectableTribeeItem.imageUrl;
        }
        String str6 = str3;
        List<SelectableTribeePartition> list2 = list;
        if ((i & 16) != 0) {
            list2 = selectableTribeeItem.partitions;
        }
        return selectableTribeeItem.copy(j2, str4, str5, str6, list2);
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.desc;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final List<SelectableTribeePartition> component5() {
        return this.partitions;
    }

    public final SelectableTribeeItem copy(long j, String str, String str2, String str3, List<SelectableTribeePartition> list) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "desc");
        Intrinsics.checkNotNullParameter(str3, "imageUrl");
        Intrinsics.checkNotNullParameter(list, "partitions");
        return new SelectableTribeeItem(j, str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SelectableTribeeItem) {
            SelectableTribeeItem selectableTribeeItem = (SelectableTribeeItem) obj;
            return this.id == selectableTribeeItem.id && Intrinsics.areEqual(this.name, selectableTribeeItem.name) && Intrinsics.areEqual(this.desc, selectableTribeeItem.desc) && Intrinsics.areEqual(this.imageUrl, selectableTribeeItem.imageUrl) && Intrinsics.areEqual(this.partitions, selectableTribeeItem.partitions);
        }
        return false;
    }

    public int hashCode() {
        return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + this.imageUrl.hashCode()) * 31) + this.partitions.hashCode();
    }

    public String toString() {
        long j = this.id;
        String str = this.name;
        String str2 = this.desc;
        String str3 = this.imageUrl;
        return "SelectableTribeeItem(id=" + j + ", name=" + str + ", desc=" + str2 + ", imageUrl=" + str3 + ", partitions=" + this.partitions + ")";
    }

    public SelectableTribeeItem(long id, String name, String desc, String imageUrl, List<SelectableTribeePartition> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        Intrinsics.checkNotNullParameter(list, "partitions");
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.imageUrl = imageUrl;
        this.partitions = list;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<SelectableTribeePartition> getPartitions() {
        return this.partitions;
    }
}