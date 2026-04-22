package kntr.app.im.chat.db.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: RangeDatabaseServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0001¨\u0006\u0004"}, d2 = {"merge", "Lkntr/app/im/chat/db/service/RangeMergeResult;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RangeDatabaseServiceImplKt {
    public static final RangeMergeResult merge(Collection<LongRange> collection) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        if (collection.isEmpty()) {
            return new RangeMergeResult((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
        }
        Collection<LongRange> $this$map$iv = collection;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LongRange it = (LongRange) item$iv$iv;
            destination$iv$iv.add(new LongRange(it.getFirst(), it.getLast()));
        }
        Iterable $this$sortedBy$iv = (List) destination$iv$iv;
        List sortedRanges = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.db.service.RangeDatabaseServiceImplKt$merge$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                LongRange it2 = (LongRange) t;
                LongRange it3 = (LongRange) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it2.getFirst()), Long.valueOf(it3.getFirst()));
            }
        });
        Set merged = new LinkedHashSet();
        LongRange current = (LongRange) CollectionsKt.first(sortedRanges);
        for (LongRange range : CollectionsKt.drop(sortedRanges, 1)) {
            if (range.getFirst() <= current.getLast() + 1) {
                current = new LongRange(current.getFirst(), Math.max(current.getLast(), range.getLast()));
            } else {
                merged.add(current);
                current = range;
            }
        }
        merged.add(current);
        return new RangeMergeResult(merged, CollectionsKt.minus(sortedRanges, merged), SetsKt.minus(merged, sortedRanges));
    }
}