package kntr.app.im.chat.service;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: FusionFetchMessagesServiceImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0001\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¨\u0006\u0006"}, d2 = {"isAdjacent", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ranges/LongRange;", "other", "isFollowedBy", "merge", "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FusionFetchMessagesServiceImplKt {
    public static final boolean isAdjacent(LongRange $this$isAdjacent, LongRange other) {
        Intrinsics.checkNotNullParameter($this$isAdjacent, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return isFollowedBy($this$isAdjacent, other) || isFollowedBy(other, $this$isAdjacent);
    }

    public static final boolean isFollowedBy(LongRange $this$isFollowedBy, LongRange other) {
        Intrinsics.checkNotNullParameter($this$isFollowedBy, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$isFollowedBy.getLast() + 1 >= other.getFirst() && $this$isFollowedBy.getFirst() <= other.getFirst();
    }

    public static final LongRange merge(LongRange $this$merge, LongRange other) {
        Intrinsics.checkNotNullParameter($this$merge, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (isAdjacent($this$merge, other)) {
            return new LongRange(Math.min($this$merge.getFirst(), other.getFirst()), Math.max($this$merge.getLast(), other.getLast()));
        }
        return $this$merge;
    }
}