package kntr.common.ouro.common.ui.toolPanel;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: TextStylePanel.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/common/ui/toolPanel/TextStylePanelEvent;", "", "<init>", "(Ljava/lang/String;I)V", "H1", "H2", "H3", "TEXT", "BOLD", "ITALIC", "UNDERLINE", "STRIKETHROUGH", "FOREGROUND_COLOR", "BACKGROUND_COLOR", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum TextStylePanelEvent {
    H1,
    H2,
    H3,
    TEXT,
    BOLD,
    ITALIC,
    UNDERLINE,
    STRIKETHROUGH,
    FOREGROUND_COLOR,
    BACKGROUND_COLOR;
    
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<TextStylePanelEvent> getEntries() {
        return $ENTRIES;
    }
}