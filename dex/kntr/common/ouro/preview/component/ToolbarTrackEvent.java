package kntr.common.ouro.preview.component;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: Toolbar.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lkntr/common/ouro/preview/component/ToolbarTrackEvent;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT_STYLE", "PARAGRAPH_STYLE", "STICKER", "ALBUM", "REDO", "UNDO", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum ToolbarTrackEvent {
    TEXT_STYLE,
    PARAGRAPH_STYLE,
    STICKER,
    ALBUM,
    REDO,
    UNDO;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ToolbarTrackEvent> getEntries() {
        return $ENTRIES;
    }
}