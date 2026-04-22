package kntr.app.im.chat.db.util;

import kntr.app.im.chat.db.entity.RangeEntity;
import kntr.app.im.chat.db.entity.SessionIdEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: RangeExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"asLongRange", "Lkotlin/ranges/LongRange;", "Lkntr/app/im/chat/db/entity/RangeEntity;", "asEntity", "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "db_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RangeExtKt {
    public static final LongRange asLongRange(RangeEntity $this$asLongRange) {
        Intrinsics.checkNotNullParameter($this$asLongRange, "<this>");
        return new LongRange($this$asLongRange.getStart(), $this$asLongRange.getEnd());
    }

    public static final RangeEntity asEntity(LongRange $this$asEntity, SessionIdEntity sessionId) {
        Intrinsics.checkNotNullParameter($this$asEntity, "<this>");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new RangeEntity(0L, sessionId, $this$asEntity.getFirst(), $this$asEntity.getLast(), 1, null);
    }
}