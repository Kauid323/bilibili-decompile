package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: CertType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/auth/v2/CertType;", "", "cardType", "", "<init>", "(Ljava/lang/String;II)V", "getCardType", "()I", "RESIDENT_ID", "HK_MO_TRAVEL_PERMIT", "TW_TRAVEL_PERMIT", "PASSPORT_CHINA", "FOREIGN_PERMANENT_RESIDENCE", "OTHER_COUNTRY_ID", "HK_MO_RESIDENCE_PERMIT", "TW_RESIDENCE_PERMIT", "UNKNOWN", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum CertType {
    RESIDENT_ID(0),
    HK_MO_TRAVEL_PERMIT(2),
    TW_TRAVEL_PERMIT(3),
    PASSPORT_CHINA(4),
    FOREIGN_PERMANENT_RESIDENCE(5),
    OTHER_COUNTRY_ID(6),
    HK_MO_RESIDENCE_PERMIT(7),
    TW_RESIDENCE_PERMIT(8),
    UNKNOWN(-1);
    
    private final int cardType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CertType> getEntries() {
        return $ENTRIES;
    }

    CertType(int cardType) {
        this.cardType = cardType;
    }

    public final int getCardType() {
        return this.cardType;
    }
}