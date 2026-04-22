package tv.danmaku.bili.ui.garb;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: NftCardDialog.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/NftCardPageType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "APPOINTMENT", "OBTAINED", "EXCHANGED", "NOT_OBTAINED", "DRAW_RESULT", "SCAN", "EXCHANGE_RESULT", "DRAGON_OBTAINED", "DRAGON_NOT_OBTAINED", "COMMENT_BG", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum NftCardPageType {
    APPOINTMENT(0),
    OBTAINED(1),
    EXCHANGED(2),
    NOT_OBTAINED(3),
    DRAW_RESULT(4),
    SCAN(5),
    EXCHANGE_RESULT(6),
    DRAGON_OBTAINED(7),
    DRAGON_NOT_OBTAINED(8),
    COMMENT_BG(9);
    
    private final int type;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<NftCardPageType> getEntries() {
        return $ENTRIES;
    }

    NftCardPageType(int type) {
        this.type = type;
    }

    public final int getType() {
        return this.type;
    }
}