package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchRetryChatModel.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent;", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "treadModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "<init>", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;)V", "getQueryId", "()Ljava/lang/String;", "getTreadModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopModel;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTreadPopContent {
    public static final Companion Companion = new Companion(null);
    private final String queryId;
    private final DeepSearchTreadPopModel treadModel;

    public static /* synthetic */ DeepSearchTreadPopContent copy$default(DeepSearchTreadPopContent deepSearchTreadPopContent, String str, DeepSearchTreadPopModel deepSearchTreadPopModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepSearchTreadPopContent.queryId;
        }
        if ((i & 2) != 0) {
            deepSearchTreadPopModel = deepSearchTreadPopContent.treadModel;
        }
        return deepSearchTreadPopContent.copy(str, deepSearchTreadPopModel);
    }

    public final String component1() {
        return this.queryId;
    }

    public final DeepSearchTreadPopModel component2() {
        return this.treadModel;
    }

    public final DeepSearchTreadPopContent copy(String str, DeepSearchTreadPopModel deepSearchTreadPopModel) {
        Intrinsics.checkNotNullParameter(str, "queryId");
        return new DeepSearchTreadPopContent(str, deepSearchTreadPopModel);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchTreadPopContent) {
            DeepSearchTreadPopContent deepSearchTreadPopContent = (DeepSearchTreadPopContent) obj;
            return Intrinsics.areEqual(this.queryId, deepSearchTreadPopContent.queryId) && Intrinsics.areEqual(this.treadModel, deepSearchTreadPopContent.treadModel);
        }
        return false;
    }

    public int hashCode() {
        return (this.queryId.hashCode() * 31) + (this.treadModel == null ? 0 : this.treadModel.hashCode());
    }

    public String toString() {
        String str = this.queryId;
        return "DeepSearchTreadPopContent(queryId=" + str + ", treadModel=" + this.treadModel + ")";
    }

    public DeepSearchTreadPopContent(String queryId, DeepSearchTreadPopModel treadModel) {
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        this.queryId = queryId;
        this.treadModel = treadModel;
    }

    public /* synthetic */ DeepSearchTreadPopContent(String str, DeepSearchTreadPopModel deepSearchTreadPopModel, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : deepSearchTreadPopModel);
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final DeepSearchTreadPopModel getTreadModel() {
        return this.treadModel;
    }

    /* compiled from: DeepSearchRetryChatModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTreadPopContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}