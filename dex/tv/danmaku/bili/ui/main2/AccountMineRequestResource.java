package tv.danmaku.bili.ui.main2;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.BR;

/* compiled from: AccountMineRequestResource.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/AccountMineRequestResource;", "", "showNextTips", "", "<init>", "(Ljava/lang/String;IZ)V", "getShowNextTips", "()Z", "RESUME", "RESELECTED", "SELECTED", "SIGN", "UNSIGN", "ACCOUNT_UPDATE", "REFRESH", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum AccountMineRequestResource {
    RESUME(true),
    RESELECTED(true),
    SELECTED(true),
    SIGN(false, 1, null),
    UNSIGN(false, 1, null),
    ACCOUNT_UPDATE(false, 1, null),
    REFRESH(false, 1, null);
    
    private final boolean showNextTips;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AccountMineRequestResource> getEntries() {
        return $ENTRIES;
    }

    AccountMineRequestResource(boolean showNextTips) {
        this.showNextTips = showNextTips;
    }

    /* synthetic */ AccountMineRequestResource(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getShowNextTips() {
        return this.showNextTips;
    }
}