package kntr.app.im.chat.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.uuid.Uuid;

/* compiled from: UUID.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000¨\u0006\u0002"}, d2 = {"generateUUID", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UUIDKt {
    public static final String generateUUID() {
        return Uuid.Companion.random().toString();
    }
}