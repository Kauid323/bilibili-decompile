package kntr.app.deepsearch.base.model.biz;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryItem;
import com.bilibili.blens.Lens;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchContentList.kt */
@Lens
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionEndModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "list", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryItem;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;Ljava/util/List;)V", "getSessionEndModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "getList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchContentList {
    public static final Companion Companion = new Companion(null);
    private final List<KChatHistoryItem> list;
    private final DeepSearchSessionEndModel sessionEndModel;

    public DeepSearchContentList() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeepSearchContentList copy$default(DeepSearchContentList deepSearchContentList, DeepSearchSessionEndModel deepSearchSessionEndModel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            deepSearchSessionEndModel = deepSearchContentList.sessionEndModel;
        }
        if ((i & 2) != 0) {
            list = deepSearchContentList.list;
        }
        return deepSearchContentList.copy(deepSearchSessionEndModel, list);
    }

    public final DeepSearchSessionEndModel component1() {
        return this.sessionEndModel;
    }

    public final List<KChatHistoryItem> component2() {
        return this.list;
    }

    public final DeepSearchContentList copy(DeepSearchSessionEndModel deepSearchSessionEndModel, List<KChatHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new DeepSearchContentList(deepSearchSessionEndModel, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchContentList) {
            DeepSearchContentList deepSearchContentList = (DeepSearchContentList) obj;
            return Intrinsics.areEqual(this.sessionEndModel, deepSearchContentList.sessionEndModel) && Intrinsics.areEqual(this.list, deepSearchContentList.list);
        }
        return false;
    }

    public int hashCode() {
        return ((this.sessionEndModel == null ? 0 : this.sessionEndModel.hashCode()) * 31) + this.list.hashCode();
    }

    public String toString() {
        DeepSearchSessionEndModel deepSearchSessionEndModel = this.sessionEndModel;
        return "DeepSearchContentList(sessionEndModel=" + deepSearchSessionEndModel + ", list=" + this.list + ")";
    }

    public DeepSearchContentList(DeepSearchSessionEndModel sessionEndModel, List<KChatHistoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.sessionEndModel = sessionEndModel;
        this.list = list;
    }

    public /* synthetic */ DeepSearchContentList(DeepSearchSessionEndModel deepSearchSessionEndModel, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : deepSearchSessionEndModel, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final DeepSearchSessionEndModel getSessionEndModel() {
        return this.sessionEndModel;
    }

    public final List<KChatHistoryItem> getList() {
        return this.list;
    }

    /* compiled from: DeepSearchContentList.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContentList$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}