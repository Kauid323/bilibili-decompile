package kntr.watch.later.watchlater.edit;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: FavFolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lkntr/watch/later/watchlater/edit/CollectionTypeEnum;", "", "typeValue", "", "<init>", "(Ljava/lang/String;II)V", "UGC", "SEASON", "PAY_SEASON", "UGC_SEASON", "OGV", "AUDIO", "FOLDER", "OGV_V2", "UNKNOWN", "value", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum CollectionTypeEnum {
    UGC(2),
    SEASON(21),
    PAY_SEASON(MediaAttrUtils.TYPE_PAY_SEASON),
    UGC_SEASON(2),
    OGV(24),
    AUDIO(12),
    FOLDER(11),
    OGV_V2(42),
    UNKNOWN(-1);
    
    private final int typeValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CollectionTypeEnum> getEntries() {
        return $ENTRIES;
    }

    CollectionTypeEnum(int typeValue) {
        this.typeValue = typeValue;
    }

    public final int value() {
        return this.typeValue;
    }
}