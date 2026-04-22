package im.direct.notification.interactive;

import BottomSheetItemData$;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedFilter;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedFilterType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\rB\t\b\u0010¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000e\u0010\u0018\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u0019J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0004\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lim/direct/notification/interactive/INFilter;", "", "title", "", "isSelected", "", "type", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilterType;", "<init>", "(Ljava/lang/String;ZLcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilterType;)V", "msgFeedFilter", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilter;", "isFirstFilter", "(Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilter;Z)V", "()V", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "isSelected$annotations", "()Z", "getType$interactive_debug", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedFilterType;", "component1", "component2", "component3", "component3$interactive_debug", "copy", "equals", "other", "hashCode", "", "toString", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INFilter {
    private final boolean isSelected;
    private final String title;
    private final KMsgFeedFilterType type;

    public static /* synthetic */ INFilter copy$default(INFilter iNFilter, String str, boolean z, KMsgFeedFilterType kMsgFeedFilterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = iNFilter.title;
        }
        if ((i2 & 2) != 0) {
            z = iNFilter.isSelected;
        }
        if ((i2 & 4) != 0) {
            kMsgFeedFilterType = iNFilter.type;
        }
        return iNFilter.copy(str, z, kMsgFeedFilterType);
    }

    public static /* synthetic */ void getTitle$annotations() {
    }

    public static /* synthetic */ void isSelected$annotations() {
    }

    public final String component1() {
        return this.title;
    }

    public final boolean component2() {
        return this.isSelected;
    }

    public final KMsgFeedFilterType component3$interactive_debug() {
        return this.type;
    }

    public final INFilter copy(String str, boolean z, KMsgFeedFilterType kMsgFeedFilterType) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(kMsgFeedFilterType, "type");
        return new INFilter(str, z, kMsgFeedFilterType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof INFilter) {
            INFilter iNFilter = (INFilter) obj;
            return Intrinsics.areEqual(this.title, iNFilter.title) && this.isSelected == iNFilter.isSelected && Intrinsics.areEqual(this.type, iNFilter.type);
        }
        return false;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected)) * 31) + this.type.hashCode();
    }

    public String toString() {
        String str = this.title;
        boolean z = this.isSelected;
        return "INFilter(title=" + str + ", isSelected=" + z + ", type=" + this.type + ")";
    }

    public INFilter(String title, boolean isSelected, KMsgFeedFilterType type) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(type, "type");
        this.title = title;
        this.isSelected = isSelected;
        this.type = type;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final KMsgFeedFilterType getType$interactive_debug() {
        return this.type;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public INFilter(KMsgFeedFilter msgFeedFilter, boolean isFirstFilter) {
        this(msgFeedFilter.getName(), isFirstFilter, msgFeedFilter.getType());
        Intrinsics.checkNotNullParameter(msgFeedFilter, "msgFeedFilter");
    }

    public INFilter() {
        this("", true, KMsgFeedFilterType.MSG_FEED_ALL.INSTANCE);
    }
}