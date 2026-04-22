package kntr.app.ad.common.utils;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.datetime.Clock;

/* compiled from: Time.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"getCurrentTimeMillis", RoomRecommendViewModel.EMPTY_CURSOR, "utils_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TimeKt {
    public static final long getCurrentTimeMillis() {
        return Clock.System.INSTANCE.now().toEpochMilliseconds();
    }
}