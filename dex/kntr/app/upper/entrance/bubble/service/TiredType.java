package kntr.app.upper.entrance.bubble.service;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: TiredType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lkntr/app/upper/entrance/bubble/service/TiredType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "NULL_DATA", "DAY_RANGE", "ONE_DAY", "ERR", "AB", "EMPTY_DATA", "LIMIT_TIME", "TIRED_STRATEGY", "START", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum TiredType {
    SUCCESS("0"),
    NULL_DATA("1"),
    DAY_RANGE("2"),
    ONE_DAY(WatchLaterReporterKt.CLEAN_INVALID),
    ERR("4"),
    AB("5"),
    EMPTY_DATA("6"),
    LIMIT_TIME("7"),
    TIRED_STRATEGY("8"),
    START("9");
    
    private final String value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<TiredType> getEntries() {
        return $ENTRIES;
    }

    TiredType(String value) {
        this.value = value;
    }

    public final String getValue() {
        return this.value;
    }
}