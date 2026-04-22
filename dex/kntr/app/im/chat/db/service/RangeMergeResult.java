package kntr.app.im.chat.db.service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: RangeDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bB7\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\t\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\t¢\u0006\u0004\b\u0007\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, d2 = {"Lkntr/app/im/chat/db/service/RangeMergeResult;", RoomRecommendViewModel.EMPTY_CURSOR, "mergedRanges", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "toDelete", "toInsert", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/util/Collection;Ljava/util/Collection;Ljava/util/Collection;)V", "getMergedRanges", "()Ljava/util/List;", "getToDelete", "getToInsert", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RangeMergeResult {
    private final List<LongRange> mergedRanges;
    private final List<LongRange> toDelete;
    private final List<LongRange> toInsert;

    public RangeMergeResult() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RangeMergeResult copy$default(RangeMergeResult rangeMergeResult, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = rangeMergeResult.mergedRanges;
        }
        if ((i & 2) != 0) {
            list2 = rangeMergeResult.toDelete;
        }
        if ((i & 4) != 0) {
            list3 = rangeMergeResult.toInsert;
        }
        return rangeMergeResult.copy(list, list2, list3);
    }

    public final List<LongRange> component1() {
        return this.mergedRanges;
    }

    public final List<LongRange> component2() {
        return this.toDelete;
    }

    public final List<LongRange> component3() {
        return this.toInsert;
    }

    public final RangeMergeResult copy(List<LongRange> list, List<LongRange> list2, List<LongRange> list3) {
        Intrinsics.checkNotNullParameter(list, "mergedRanges");
        Intrinsics.checkNotNullParameter(list2, "toDelete");
        Intrinsics.checkNotNullParameter(list3, "toInsert");
        return new RangeMergeResult(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RangeMergeResult) {
            RangeMergeResult rangeMergeResult = (RangeMergeResult) obj;
            return Intrinsics.areEqual(this.mergedRanges, rangeMergeResult.mergedRanges) && Intrinsics.areEqual(this.toDelete, rangeMergeResult.toDelete) && Intrinsics.areEqual(this.toInsert, rangeMergeResult.toInsert);
        }
        return false;
    }

    public int hashCode() {
        return (((this.mergedRanges.hashCode() * 31) + this.toDelete.hashCode()) * 31) + this.toInsert.hashCode();
    }

    public String toString() {
        List<LongRange> list = this.mergedRanges;
        List<LongRange> list2 = this.toDelete;
        return "RangeMergeResult(mergedRanges=" + list + ", toDelete=" + list2 + ", toInsert=" + this.toInsert + ")";
    }

    public RangeMergeResult(List<LongRange> list, List<LongRange> list2, List<LongRange> list3) {
        Intrinsics.checkNotNullParameter(list, "mergedRanges");
        Intrinsics.checkNotNullParameter(list2, "toDelete");
        Intrinsics.checkNotNullParameter(list3, "toInsert");
        this.mergedRanges = list;
        this.toDelete = list2;
        this.toInsert = list3;
    }

    public /* synthetic */ RangeMergeResult(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<LongRange>) ((i & 1) != 0 ? CollectionsKt.emptyList() : list), (List<LongRange>) ((i & 2) != 0 ? CollectionsKt.emptyList() : list2), (List<LongRange>) ((i & 4) != 0 ? CollectionsKt.emptyList() : list3));
    }

    public final List<LongRange> getMergedRanges() {
        return this.mergedRanges;
    }

    public final List<LongRange> getToDelete() {
        return this.toDelete;
    }

    public final List<LongRange> getToInsert() {
        return this.toInsert;
    }

    public /* synthetic */ RangeMergeResult(Collection collection, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RangeMergeResult(Collection<LongRange> collection, Collection<LongRange> collection2, Collection<LongRange> collection3) {
        this((List<LongRange>) r0, (List<LongRange>) r1, (List<LongRange>) CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeMergeResult$special$$inlined$sortedBy$3
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongRange it = (LongRange) t;
                LongRange it2 = (LongRange) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getFirst()), Long.valueOf(it2.getFirst()));
            }
        }));
        Intrinsics.checkNotNullParameter(collection, "mergedRanges");
        Intrinsics.checkNotNullParameter(collection2, "toDelete");
        Intrinsics.checkNotNullParameter(collection3, "toInsert");
        Iterable $this$sortedBy$iv = CollectionsKt.toList(collection);
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeMergeResult$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongRange it = (LongRange) t;
                LongRange it2 = (LongRange) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getFirst()), Long.valueOf(it2.getFirst()));
            }
        });
        Iterable $this$sortedBy$iv2 = CollectionsKt.toList(collection2);
        List sortedWith2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeMergeResult$special$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongRange it = (LongRange) t;
                LongRange it2 = (LongRange) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getFirst()), Long.valueOf(it2.getFirst()));
            }
        });
        Iterable $this$sortedBy$iv3 = CollectionsKt.toList(collection3);
    }
}