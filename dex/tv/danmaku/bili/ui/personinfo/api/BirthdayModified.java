package tv.danmaku.bili.ui.personinfo.api;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BirthdayModified.kt */
@Bson
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/api/BirthdayModified;", "", "changed", "", "<init>", "(Z)V", "getChanged", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BirthdayModified {
    public static final int $stable = 0;
    @SerializedName("changed")
    private final boolean changed;

    public BirthdayModified() {
        this(false, 1, null);
    }

    public static /* synthetic */ BirthdayModified copy$default(BirthdayModified birthdayModified, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = birthdayModified.changed;
        }
        return birthdayModified.copy(z);
    }

    public final boolean component1() {
        return this.changed;
    }

    public final BirthdayModified copy(boolean z) {
        return new BirthdayModified(z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BirthdayModified) && this.changed == ((BirthdayModified) obj).changed;
    }

    public int hashCode() {
        return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.changed);
    }

    public String toString() {
        return "BirthdayModified(changed=" + this.changed + ")";
    }

    public BirthdayModified(boolean changed) {
        this.changed = changed;
    }

    public /* synthetic */ BirthdayModified(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    public final boolean getChanged() {
        return this.changed;
    }
}