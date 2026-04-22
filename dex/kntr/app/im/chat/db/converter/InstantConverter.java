package kntr.app.im.chat.db.converter;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.datetime.Instant;

/* compiled from: InstantConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/db/converter/InstantConverter;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "instantToLong", RoomRecommendViewModel.EMPTY_CURSOR, "value", "Lkotlinx/datetime/Instant;", "(Lkotlinx/datetime/Instant;)Ljava/lang/Long;", "longToInstant", "(Ljava/lang/Long;)Lkotlinx/datetime/Instant;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InstantConverter {
    public final Long instantToLong(Instant value) {
        if (value != null) {
            return Long.valueOf(value.toEpochMilliseconds());
        }
        return null;
    }

    public final Instant longToInstant(Long value) {
        if (value != null) {
            long it = value.longValue();
            return Instant.Companion.fromEpochMilliseconds(it);
        }
        return null;
    }
}