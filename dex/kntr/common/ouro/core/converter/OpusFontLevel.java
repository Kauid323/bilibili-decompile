package kntr.common.ouro.core.converter;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: OpusConverter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lkntr/common/ouro/core/converter/OpusFontLevel;", "", "level", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLevel", "()Ljava/lang/String;", "Regular", "Large", "XLarge", "XXLarge", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public enum OpusFontLevel {
    Regular("regular"),
    Large("large"),
    XLarge("xLarge"),
    XXLarge("xxLarge");
    
    private final String level;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<OpusFontLevel> getEntries() {
        return $ENTRIES;
    }

    OpusFontLevel(String level) {
        this.level = level;
    }

    public final String getLevel() {
        return this.level;
    }
}