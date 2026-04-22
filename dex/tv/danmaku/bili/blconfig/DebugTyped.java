package tv.danmaku.bili.blconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/blconfig/DebugTyped;", "", "dataSpName", "", "dataSize", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDataSpName", "()Ljava/lang/String;", "getDataSize", "()I", "AB", "CONFIG", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum DebugTyped {
    AB("ab.sp", 4194304),
    CONFIG("config.sp", 2097152);
    
    private final int dataSize;
    private final String dataSpName;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<DebugTyped> getEntries() {
        return $ENTRIES;
    }

    DebugTyped(String dataSpName, int dataSize) {
        this.dataSpName = dataSpName;
        this.dataSize = dataSize;
    }

    public final String getDataSpName() {
        return this.dataSpName;
    }

    public final int getDataSize() {
        return this.dataSize;
    }
}