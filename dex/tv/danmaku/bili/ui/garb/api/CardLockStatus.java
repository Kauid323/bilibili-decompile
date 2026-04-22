package tv.danmaku.bili.ui.garb.api;

import com.bilibili.bson.adapter.EnumWithJsonValue;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0003B\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/garb/api/CardLockStatus;", "Lcom/bilibili/bson/adapter/EnumWithJsonValue;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "getValue", "()Ljava/lang/Integer;", "UNLOCKED", "LOCKED", "PERMANENTLY_LOCKED", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum CardLockStatus implements EnumWithJsonValue<Integer> {
    UNLOCKED(1),
    LOCKED(2),
    PERMANENTLY_LOCKED(3);
    
    private final int value;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<CardLockStatus> getEntries() {
        return $ENTRIES;
    }

    CardLockStatus(int value) {
        this.value = value;
    }

    /* renamed from: getValue */
    public Integer m1726getValue() {
        return Integer.valueOf(this.value);
    }
}