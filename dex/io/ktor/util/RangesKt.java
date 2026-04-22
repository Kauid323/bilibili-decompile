package io.ktor.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/ranges/LongRange;", "other", "", "contains", "(Lkotlin/ranges/LongRange;Lkotlin/ranges/LongRange;)Z", "ktor-utils"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RangesKt {
    public static final boolean contains(LongRange $this$contains, LongRange other) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other.getFirst() >= $this$contains.getStart().longValue() && other.getLast() <= $this$contains.getEndInclusive().longValue();
    }
}