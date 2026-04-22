package kntr.common.paragraph.watermark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: AssetUploaderWaterMark.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkntr/common/paragraph/watermark/WaterMarkPosition;", "", "param", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getParam", "()Ljava/lang/String;", "None", "Center", "BottomRight", "watermark_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum WaterMarkPosition {
    None(""),
    Center("center"),
    BottomRight("se");
    
    private final String param;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<WaterMarkPosition> getEntries() {
        return $ENTRIES;
    }

    WaterMarkPosition(String param) {
        this.param = param;
    }

    public final String getParam() {
        return this.param;
    }
}