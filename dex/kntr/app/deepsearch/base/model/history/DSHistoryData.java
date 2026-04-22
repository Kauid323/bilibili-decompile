package kntr.app.deepsearch.base.model.history;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListItem;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListReply;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.deepsearch.base.model.DSTimeDescriptionType;
import kntr.app.deepsearch.base.model.history.DSHistoryPageStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: DSHistoryData.kt */
@Lens
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 32\u00020\u0001:\u00013BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010!\u001a\u00020\u00002\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JQ\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00000\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00064"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryData;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, "Lkntr/app/deepsearch/base/model/history/DSHistoryPageStatus;", "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "groups", "Lkntr/app/deepsearch/base/model/history/DSConversationSection;", "cursor", "loadActionType", "Lkntr/app/deepsearch/base/model/history/LoadActionType;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/history/DSHistoryPageStatus;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Lkntr/app/deepsearch/base/model/history/LoadActionType;)V", "getSessionId", "()Ljava/lang/String;", "getStatus", "()Lkntr/app/deepsearch/base/model/history/DSHistoryPageStatus;", "getList", "()Ljava/util/List;", "getGroups", "getCursor", "getLoadActionType", "()Lkntr/app/deepsearch/base/model/history/LoadActionType;", "selected", "getSelected", "()Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "select", "Lkotlin/Function1;", "getSelect", "()Lkotlin/jvm/functions/Function1;", "receive", "result", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryListReply;", "(Ljava/lang/Object;)Lkntr/app/deepsearch/base/model/history/DSHistoryData;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryData {
    public static final Companion Companion = new Companion(null);
    private final String cursor;
    private final List<DSConversationSection> groups;
    private final List<DSConversationItem> list;
    private final LoadActionType loadActionType;
    private final String sessionId;
    private final DSHistoryPageStatus status;

    public DSHistoryData() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DSHistoryData copy$default(DSHistoryData dSHistoryData, String str, DSHistoryPageStatus dSHistoryPageStatus, List list, List list2, String str2, LoadActionType loadActionType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dSHistoryData.sessionId;
        }
        if ((i & 2) != 0) {
            dSHistoryPageStatus = dSHistoryData.status;
        }
        DSHistoryPageStatus dSHistoryPageStatus2 = dSHistoryPageStatus;
        List<DSConversationItem> list3 = list;
        if ((i & 4) != 0) {
            list3 = dSHistoryData.list;
        }
        List list4 = list3;
        List<DSConversationSection> list5 = list2;
        if ((i & 8) != 0) {
            list5 = dSHistoryData.groups;
        }
        List list6 = list5;
        if ((i & 16) != 0) {
            str2 = dSHistoryData.cursor;
        }
        String str3 = str2;
        if ((i & 32) != 0) {
            loadActionType = dSHistoryData.loadActionType;
        }
        return dSHistoryData.copy(str, dSHistoryPageStatus2, list4, list6, str3, loadActionType);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final DSHistoryPageStatus component2() {
        return this.status;
    }

    public final List<DSConversationItem> component3() {
        return this.list;
    }

    public final List<DSConversationSection> component4() {
        return this.groups;
    }

    public final String component5() {
        return this.cursor;
    }

    public final LoadActionType component6() {
        return this.loadActionType;
    }

    public final DSHistoryData copy(String str, DSHistoryPageStatus dSHistoryPageStatus, List<DSConversationItem> list, List<DSConversationSection> list2, String str2, LoadActionType loadActionType) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(dSHistoryPageStatus, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(list2, "groups");
        Intrinsics.checkNotNullParameter(str2, "cursor");
        Intrinsics.checkNotNullParameter(loadActionType, "loadActionType");
        return new DSHistoryData(str, dSHistoryPageStatus, list, list2, str2, loadActionType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DSHistoryData) {
            DSHistoryData dSHistoryData = (DSHistoryData) obj;
            return Intrinsics.areEqual(this.sessionId, dSHistoryData.sessionId) && Intrinsics.areEqual(this.status, dSHistoryData.status) && Intrinsics.areEqual(this.list, dSHistoryData.list) && Intrinsics.areEqual(this.groups, dSHistoryData.groups) && Intrinsics.areEqual(this.cursor, dSHistoryData.cursor) && this.loadActionType == dSHistoryData.loadActionType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + this.status.hashCode()) * 31) + this.list.hashCode()) * 31) + this.groups.hashCode()) * 31) + this.cursor.hashCode()) * 31) + this.loadActionType.hashCode();
    }

    public String toString() {
        String str = this.sessionId;
        DSHistoryPageStatus dSHistoryPageStatus = this.status;
        List<DSConversationItem> list = this.list;
        List<DSConversationSection> list2 = this.groups;
        String str2 = this.cursor;
        return "DSHistoryData(sessionId=" + str + ", status=" + dSHistoryPageStatus + ", list=" + list + ", groups=" + list2 + ", cursor=" + str2 + ", loadActionType=" + this.loadActionType + ")";
    }

    public DSHistoryData(String sessionId, DSHistoryPageStatus status, List<DSConversationItem> list, List<DSConversationSection> list2, String cursor, LoadActionType loadActionType) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(list2, "groups");
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(loadActionType, "loadActionType");
        this.sessionId = sessionId;
        this.status = status;
        this.list = list;
        this.groups = list2;
        this.cursor = cursor;
        this.loadActionType = loadActionType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ DSHistoryData(String str, DSHistoryPageStatus dSHistoryPageStatus, List list, List list2, String str2, LoadActionType loadActionType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(r12, r1, r2, (i & 8) != 0 ? Companion.groups(r2) : list2, (i & 16) == 0 ? str2 : r0, (i & 32) != 0 ? LoadActionType.Refresh : loadActionType);
        int i2 = i & 1;
        String str3 = RoomRecommendViewModel.EMPTY_CURSOR;
        String str4 = i2 != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str;
        DSHistoryPageStatus.Initial initial = (i & 2) != 0 ? DSHistoryPageStatus.Initial.INSTANCE : dSHistoryPageStatus;
        List emptyList = (i & 4) != 0 ? CollectionsKt.emptyList() : list;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final DSHistoryPageStatus getStatus() {
        return this.status;
    }

    public final List<DSConversationItem> getList() {
        return this.list;
    }

    public final List<DSConversationSection> getGroups() {
        return this.groups;
    }

    public final String getCursor() {
        return this.cursor;
    }

    public final LoadActionType getLoadActionType() {
        return this.loadActionType;
    }

    /* compiled from: DSHistoryData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/history/DSHistoryData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "defaultList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/history/DSConversationItem;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "groups", "Lkntr/app/deepsearch/base/model/history/DSConversationSection;", "anchorSelect", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<DSConversationItem> defaultList(String sessionId) {
            return CollectionsKt.listOf(new DSConversationItem(null, RoomRecommendViewModel.EMPTY_CURSOR, true, sessionId, Clock.System.INSTANCE.now().toEpochMilliseconds(), 1, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<DSConversationSection> groups(List<DSConversationItem> list) {
            ArrayList arrayList;
            List<DSConversationItem> $this$groupBy$iv = list;
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $this$groupBy$iv) {
                DSConversationItem it = (DSConversationItem) element$iv$iv;
                DSTimeDescriptionType type = it.getTimeDescription().getType();
                Object value$iv$iv$iv = destination$iv$iv.get(type);
                if (value$iv$iv$iv == null) {
                    arrayList = new ArrayList();
                    destination$iv$iv.put(type, arrayList);
                } else {
                    arrayList = value$iv$iv$iv;
                }
                Object key$iv$iv$iv = arrayList;
                List list$iv$iv = (List) key$iv$iv$iv;
                list$iv$iv.add(element$iv$iv);
            }
            Collection destination$iv$iv2 = new ArrayList(destination$iv$iv.size());
            for (Map.Entry item$iv$iv : destination$iv$iv.entrySet()) {
                DSTimeDescriptionType key = (DSTimeDescriptionType) item$iv$iv.getKey();
                List items = (List) item$iv$iv.getValue();
                destination$iv$iv2.add(new DSConversationSection(key, items));
            }
            return (List) destination$iv$iv2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<DSConversationItem> anchorSelect(List<DSConversationItem> list, String sessionId) {
            DSConversationItem dSConversationItem;
            List<DSConversationItem> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                DSConversationItem it = (DSConversationItem) item$iv$iv;
                if (Intrinsics.areEqual(it.getItemId(), sessionId)) {
                    dSConversationItem = DSConversationItem.copy$default(it, null, null, true, null, 0L, 27, null);
                } else if (it.isCurrent()) {
                    dSConversationItem = DSConversationItem.copy$default(it, null, null, false, null, 0L, 27, null);
                } else {
                    dSConversationItem = it;
                }
                destination$iv$iv.add(dSConversationItem);
            }
            return (List) destination$iv$iv;
        }
    }

    public final DSConversationItem getSelected() {
        Object element$iv;
        Iterable $this$firstOrNull$iv = this.list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                DSConversationItem it2 = (DSConversationItem) element$iv;
                if (it2.isCurrent()) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (DSConversationItem) element$iv;
    }

    public final Function1<DSConversationItem, DSHistoryData> getSelect() {
        return new Function1() { // from class: kntr.app.deepsearch.base.model.history.DSHistoryData$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                DSHistoryData _get_select_$lambda$0;
                _get_select_$lambda$0 = DSHistoryData._get_select_$lambda$0(DSHistoryData.this, (DSConversationItem) obj);
                return _get_select_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DSHistoryData _get_select_$lambda$0(DSHistoryData this$0, DSConversationItem selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        return copy$default(this$0, selected.getItemId(), null, Companion.anchorSelect(this$0.list, selected.getItemId()), Companion.groups(Companion.anchorSelect(this$0.list, selected.getItemId())), null, null, 50, null);
    }

    public final DSHistoryData receive(Object result) {
        List list;
        if (Result.exceptionOrNull-impl(result) == null) {
            KChatHistoryListReply reply = (KChatHistoryListReply) result;
            Iterable $this$map$iv = reply.getItems();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(new DSConversationItem((KChatHistoryListItem) item$iv$iv));
            }
            List addList = (List) destination$iv$iv;
            Companion companion = Companion;
            DSHistoryData it = this;
            if (it.loadActionType == LoadActionType.More) {
                list = CollectionsKt.plus(it.list, addList);
            } else {
                List list2 = addList;
                if (list2.isEmpty()) {
                    list2 = Companion.defaultList(this.sessionId);
                }
                list = list2;
            }
            List newList = companion.anchorSelect(list, this.sessionId);
            DSHistoryPageStatus.Idle idle = DSHistoryPageStatus.Idle.INSTANCE;
            return copy$default(this, null, idle, newList, Companion.groups(newList), reply.getNextCursor(), null, 33, null);
        }
        List list3 = this.list;
        if (list3.isEmpty()) {
            list3 = Companion.defaultList(this.sessionId);
        }
        List tempList = list3;
        return copy$default(this, null, new DSHistoryPageStatus.Error(new Throwable()), tempList, Companion.groups(tempList), null, null, 49, null);
    }
}