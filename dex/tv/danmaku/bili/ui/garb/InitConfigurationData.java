package tv.danmaku.bili.ui.garb;

import com.bilibili.bson.common.Bson;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: CollectionRoomFragment.kt */
@Bson
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/garb/InitConfigurationData;", "", "collectionCompletedUrl", "", "<init>", "(Ljava/lang/String;)V", "getCollectionCompletedUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InitConfigurationData {
    public static final int $stable = 0;
    private final String collectionCompletedUrl;

    public static /* synthetic */ InitConfigurationData copy$default(InitConfigurationData initConfigurationData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = initConfigurationData.collectionCompletedUrl;
        }
        return initConfigurationData.copy(str);
    }

    public final String component1() {
        return this.collectionCompletedUrl;
    }

    public final InitConfigurationData copy(String str) {
        return new InitConfigurationData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InitConfigurationData) && Intrinsics.areEqual(this.collectionCompletedUrl, ((InitConfigurationData) obj).collectionCompletedUrl);
    }

    public int hashCode() {
        if (this.collectionCompletedUrl == null) {
            return 0;
        }
        return this.collectionCompletedUrl.hashCode();
    }

    public String toString() {
        return "InitConfigurationData(collectionCompletedUrl=" + this.collectionCompletedUrl + ")";
    }

    public InitConfigurationData(String collectionCompletedUrl) {
        this.collectionCompletedUrl = collectionCompletedUrl;
    }

    public final String getCollectionCompletedUrl() {
        return this.collectionCompletedUrl;
    }
}