package kntr.app.upcomingEpisode.base.handler;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: UpcomingEpisodeTrackerHandler.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkntr/app/upcomingEpisode/base/handler/CalendarCardClickArea;", "", "<init>", "(Ljava/lang/String;I)V", "UP_INFO", "CARD", "MORE", "REMOVE", "RESERVE", "CANCEL_RESERVE", "BUTTON", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum CalendarCardClickArea {
    UP_INFO,
    CARD,
    MORE,
    REMOVE,
    RESERVE,
    CANCEL_RESERVE,
    BUTTON;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CalendarCardClickArea> getEntries() {
        return $ENTRIES;
    }
}