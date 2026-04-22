package kntr.app.deepsearch.base.model.biz;

import BottomSheetItemData$;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchRetryChatModel.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", RoomRecommendViewModel.EMPTY_CURSOR, "query", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "isShowRetryBtn", RoomRecommendViewModel.EMPTY_CURSOR, "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;)V", "getQuery", "()Ljava/lang/String;", "getQueryId", "()Z", "getLikeType", "()Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchRetryChatModel {
    public static final Companion Companion = new Companion(null);
    private final boolean isShowRetryBtn;
    private final KLikeType likeType;
    private final String query;
    private final String queryId;

    public DeepSearchRetryChatModel() {
        this(null, null, false, null, 15, null);
    }

    public static /* synthetic */ DeepSearchRetryChatModel copy$default(DeepSearchRetryChatModel deepSearchRetryChatModel, String str, String str2, boolean z, KLikeType kLikeType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deepSearchRetryChatModel.query;
        }
        if ((i & 2) != 0) {
            str2 = deepSearchRetryChatModel.queryId;
        }
        if ((i & 4) != 0) {
            z = deepSearchRetryChatModel.isShowRetryBtn;
        }
        if ((i & 8) != 0) {
            kLikeType = deepSearchRetryChatModel.likeType;
        }
        return deepSearchRetryChatModel.copy(str, str2, z, kLikeType);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.queryId;
    }

    public final boolean component3() {
        return this.isShowRetryBtn;
    }

    public final KLikeType component4() {
        return this.likeType;
    }

    public final DeepSearchRetryChatModel copy(String str, String str2, boolean z, KLikeType kLikeType) {
        Intrinsics.checkNotNullParameter(str, "query");
        Intrinsics.checkNotNullParameter(str2, "queryId");
        Intrinsics.checkNotNullParameter(kLikeType, "likeType");
        return new DeepSearchRetryChatModel(str, str2, z, kLikeType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeepSearchRetryChatModel) {
            DeepSearchRetryChatModel deepSearchRetryChatModel = (DeepSearchRetryChatModel) obj;
            return Intrinsics.areEqual(this.query, deepSearchRetryChatModel.query) && Intrinsics.areEqual(this.queryId, deepSearchRetryChatModel.queryId) && this.isShowRetryBtn == deepSearchRetryChatModel.isShowRetryBtn && Intrinsics.areEqual(this.likeType, deepSearchRetryChatModel.likeType);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.query.hashCode() * 31) + this.queryId.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShowRetryBtn)) * 31) + this.likeType.hashCode();
    }

    public String toString() {
        String str = this.query;
        String str2 = this.queryId;
        boolean z = this.isShowRetryBtn;
        return "DeepSearchRetryChatModel(query=" + str + ", queryId=" + str2 + ", isShowRetryBtn=" + z + ", likeType=" + this.likeType + ")";
    }

    public DeepSearchRetryChatModel(String query, String queryId, boolean isShowRetryBtn, KLikeType likeType) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(likeType, "likeType");
        this.query = query;
        this.queryId = queryId;
        this.isShowRetryBtn = isShowRetryBtn;
        this.likeType = likeType;
    }

    public /* synthetic */ DeepSearchRetryChatModel(String str, String str2, boolean z, KLikeType kLikeType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? (KLikeType) KLikeType.INVALID.INSTANCE : kLikeType);
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final boolean isShowRetryBtn() {
        return this.isShowRetryBtn;
    }

    public final KLikeType getLikeType() {
        return this.likeType;
    }

    /* compiled from: DeepSearchRetryChatModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}