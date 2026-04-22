package tv.danmaku.bili.ui.garb.api.collection;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliCollectionData.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/collection/AllCollectionSettingJumpUrlPageFrom;", "", "reportValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReportValue", "()Ljava/lang/String;", "DRAWER_BAR_SETTING_BUTTON", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum AllCollectionSettingJumpUrlPageFrom {
    DRAWER_BAR_SETTING_BUTTON("0");
    
    private final String reportValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<AllCollectionSettingJumpUrlPageFrom> getEntries() {
        return $ENTRIES;
    }

    AllCollectionSettingJumpUrlPageFrom(String reportValue) {
        this.reportValue = reportValue;
    }

    public final String getReportValue() {
        return this.reportValue;
    }
}