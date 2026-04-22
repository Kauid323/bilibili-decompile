package kntr.app.deepsearch.base.model.history;

import java.util.List;
import kntr.app.deepsearch.base.model.DSTimeDescriptionType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSHistoryData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSConversationSection;", RoomRecommendViewModel.EMPTY_CURSOR, "type", "Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "items", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "<init>", "(Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;Ljava/util/List;)V", "getType", "()Lkntr/app/deepsearch/base/model/DSTimeDescriptionType;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSConversationSection {
    private final List<DSConversationItem> items;
    private final DSTimeDescriptionType type;

    public DSConversationSection() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DSConversationSection copy$default(DSConversationSection dSConversationSection, DSTimeDescriptionType dSTimeDescriptionType, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            dSTimeDescriptionType = dSConversationSection.type;
        }
        if ((i & 2) != 0) {
            list = dSConversationSection.items;
        }
        return dSConversationSection.copy(dSTimeDescriptionType, list);
    }

    public final DSTimeDescriptionType component1() {
        return this.type;
    }

    public final List<DSConversationItem> component2() {
        return this.items;
    }

    public final DSConversationSection copy(DSTimeDescriptionType dSTimeDescriptionType, List<DSConversationItem> list) {
        Intrinsics.checkNotNullParameter(dSTimeDescriptionType, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        return new DSConversationSection(dSTimeDescriptionType, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DSConversationSection) {
            DSConversationSection dSConversationSection = (DSConversationSection) obj;
            return this.type == dSConversationSection.type && Intrinsics.areEqual(this.items, dSConversationSection.items);
        }
        return false;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.items.hashCode();
    }

    public String toString() {
        DSTimeDescriptionType dSTimeDescriptionType = this.type;
        return "DSConversationSection(type=" + dSTimeDescriptionType + ", items=" + this.items + ")";
    }

    public DSConversationSection(DSTimeDescriptionType type, List<DSConversationItem> list) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(list, "items");
        this.type = type;
        this.items = list;
    }

    public /* synthetic */ DSConversationSection(DSTimeDescriptionType dSTimeDescriptionType, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DSTimeDescriptionType.Null : dSTimeDescriptionType, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final DSTimeDescriptionType getType() {
        return this.type;
    }

    public final List<DSConversationItem> getItems() {
        return this.items;
    }
}