package kntr.app.deepsearch.base.model.history;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListItem;
import kntr.app.deepsearch.base.model.DSTimeDescription;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: DSHistoryData.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00062\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006%"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSConversationItem;", RoomRecommendViewModel.EMPTY_CURSOR, "group", RoomRecommendViewModel.EMPTY_CURSOR, "title", "isCurrent", RoomRecommendViewModel.EMPTY_CURSOR, "itemId", "timestamp", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;J)V", "item", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryListItem;", "(Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryListItem;)V", "getGroup", "()Ljava/lang/String;", "getTitle", "()Z", "getItemId", "getTimestamp", "()J", "timeDescription", "Lkntr/app/deepsearch/base/model/DSTimeDescription;", "getTimeDescription", "()Lkntr/app/deepsearch/base/model/DSTimeDescription;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSConversationItem {
    private final String group;
    private final boolean isCurrent;
    private final String itemId;
    private final long timestamp;
    private final String title;

    public static /* synthetic */ DSConversationItem copy$default(DSConversationItem dSConversationItem, String str, String str2, boolean z, String str3, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dSConversationItem.group;
        }
        if ((i & 2) != 0) {
            str2 = dSConversationItem.title;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            z = dSConversationItem.isCurrent;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = dSConversationItem.itemId;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            j2 = dSConversationItem.timestamp;
        }
        return dSConversationItem.copy(str, str4, z2, str5, j2);
    }

    public final String component1() {
        return this.group;
    }

    public final String component2() {
        return this.title;
    }

    public final boolean component3() {
        return this.isCurrent;
    }

    public final String component4() {
        return this.itemId;
    }

    public final long component5() {
        return this.timestamp;
    }

    public final DSConversationItem copy(String str, String str2, boolean z, String str3, long j2) {
        Intrinsics.checkNotNullParameter(str, "group");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "itemId");
        return new DSConversationItem(str, str2, z, str3, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DSConversationItem) {
            DSConversationItem dSConversationItem = (DSConversationItem) obj;
            return Intrinsics.areEqual(this.group, dSConversationItem.group) && Intrinsics.areEqual(this.title, dSConversationItem.title) && this.isCurrent == dSConversationItem.isCurrent && Intrinsics.areEqual(this.itemId, dSConversationItem.itemId) && this.timestamp == dSConversationItem.timestamp;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.group.hashCode() * 31) + this.title.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCurrent)) * 31) + this.itemId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timestamp);
    }

    public String toString() {
        String str = this.group;
        String str2 = this.title;
        boolean z = this.isCurrent;
        String str3 = this.itemId;
        return "DSConversationItem(group=" + str + ", title=" + str2 + ", isCurrent=" + z + ", itemId=" + str3 + ", timestamp=" + this.timestamp + ")";
    }

    public DSConversationItem(String group, String title, boolean isCurrent, String itemId, long timestamp) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        this.group = group;
        this.title = title;
        this.isCurrent = isCurrent;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }

    public /* synthetic */ DSConversationItem(String str, String str2, boolean z, String str3, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, str2, (i & 4) != 0 ? false : z, str3, (i & 16) != 0 ? 0L : j2);
    }

    public final String getGroup() {
        return this.group;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCurrent() {
        return this.isCurrent;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DSConversationItem(KChatHistoryListItem item) {
        this(null, item.getTitle(), false, item.getSessionId(), item.getNewChatTime(), 5, null);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    public final DSTimeDescription getTimeDescription() {
        if (this.timestamp == 0) {
            return DSTimeDescription.Null.INSTANCE;
        }
        return DSTimeDescription.CC.timeDescription$default(DSTimeDescription.Null.INSTANCE, Instant.Companion.fromEpochMilliseconds(this.timestamp), null, 1, null);
    }
}