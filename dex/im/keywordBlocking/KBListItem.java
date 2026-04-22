package im.keywordBlocking;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0013"}, d2 = {"Lim/keywordBlocking/KBListItem;", "", "keyword", "", "isLoading", "", "<init>", "(Ljava/lang/String;Z)V", "getKeyword", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBListItem {
    private final boolean isLoading;
    private final String keyword;

    public static /* synthetic */ KBListItem copy$default(KBListItem kBListItem, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBListItem.keyword;
        }
        if ((i2 & 2) != 0) {
            z = kBListItem.isLoading;
        }
        return kBListItem.copy(str, z);
    }

    public final String component1() {
        return this.keyword;
    }

    public final boolean component2() {
        return this.isLoading;
    }

    public final KBListItem copy(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "keyword");
        return new KBListItem(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBListItem) {
            KBListItem kBListItem = (KBListItem) obj;
            return Intrinsics.areEqual(this.keyword, kBListItem.keyword) && this.isLoading == kBListItem.isLoading;
        }
        return false;
    }

    public int hashCode() {
        return (this.keyword.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading);
    }

    public String toString() {
        String str = this.keyword;
        return "KBListItem(keyword=" + str + ", isLoading=" + this.isLoading + ")";
    }

    public KBListItem(String keyword, boolean isLoading) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.keyword = keyword;
        this.isLoading = isLoading;
    }

    public /* synthetic */ KBListItem(String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? false : z);
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }
}