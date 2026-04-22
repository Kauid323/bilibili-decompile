package kntr.app.deepsearch.base.model.biz;

import BottomSheetItemData$;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam;", RoomRecommendViewModel.EMPTY_CURSOR, "SessionReqParam", "ChatReqParam", "LikeReqParam", "SubmitTreadParam", "Lkntr/app/deepsearch/base/model/biz/RequestParam$ChatReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam$LikeReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam$SessionReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam$SubmitTreadParam;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RequestParam {

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$SessionReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "isRefreshSession", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SessionReqParam implements RequestParam {
        public static final Companion Companion = new Companion(null);
        private final boolean isRefreshSession;

        public SessionReqParam() {
            this(false, 1, null);
        }

        public static /* synthetic */ SessionReqParam copy$default(SessionReqParam sessionReqParam, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = sessionReqParam.isRefreshSession;
            }
            return sessionReqParam.copy(z);
        }

        public final boolean component1() {
            return this.isRefreshSession;
        }

        public final SessionReqParam copy(boolean z) {
            return new SessionReqParam(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionReqParam) && this.isRefreshSession == ((SessionReqParam) obj).isRefreshSession;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRefreshSession);
        }

        public String toString() {
            return "SessionReqParam(isRefreshSession=" + this.isRefreshSession + ")";
        }

        public SessionReqParam(boolean isRefreshSession) {
            this.isRefreshSession = isRefreshSession;
        }

        public /* synthetic */ SessionReqParam(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isRefreshSession() {
            return this.isRefreshSession;
        }

        /* compiled from: RequestModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$SessionReqParam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$ChatReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ChatReqParam implements RequestParam {
        public static final Companion Companion = new Companion(null);
        private final String query;
        private final String queryId;

        public ChatReqParam() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ ChatReqParam copy$default(ChatReqParam chatReqParam, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = chatReqParam.query;
            }
            if ((i & 2) != 0) {
                str2 = chatReqParam.queryId;
            }
            return chatReqParam.copy(str, str2);
        }

        public final String component1() {
            return this.query;
        }

        public final String component2() {
            return this.queryId;
        }

        public final ChatReqParam copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "query");
            Intrinsics.checkNotNullParameter(str2, "queryId");
            return new ChatReqParam(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChatReqParam) {
                ChatReqParam chatReqParam = (ChatReqParam) obj;
                return Intrinsics.areEqual(this.query, chatReqParam.query) && Intrinsics.areEqual(this.queryId, chatReqParam.queryId);
            }
            return false;
        }

        public int hashCode() {
            return (this.query.hashCode() * 31) + this.queryId.hashCode();
        }

        public String toString() {
            String str = this.query;
            return "ChatReqParam(query=" + str + ", queryId=" + this.queryId + ")";
        }

        public ChatReqParam(String query, String queryId) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.query = query;
            this.queryId = queryId;
        }

        public /* synthetic */ ChatReqParam(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        }

        public final String getQuery() {
            return this.query;
        }

        public final String getQueryId() {
            return this.queryId;
        }

        /* compiled from: RequestModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$ChatReqParam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$LikeReqParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;)V", "getQueryId", "()Ljava/lang/String;", "getLikeType$annotations", "()V", "getLikeType", "()Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LikeReqParam implements RequestParam {
        public static final Companion Companion = new Companion(null);
        private final KLikeType likeType;
        private final String queryId;

        public LikeReqParam() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ LikeReqParam copy$default(LikeReqParam likeReqParam, String str, KLikeType kLikeType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = likeReqParam.queryId;
            }
            if ((i & 2) != 0) {
                kLikeType = likeReqParam.likeType;
            }
            return likeReqParam.copy(str, kLikeType);
        }

        public static /* synthetic */ void getLikeType$annotations() {
        }

        public final String component1() {
            return this.queryId;
        }

        public final KLikeType component2() {
            return this.likeType;
        }

        public final LikeReqParam copy(String str, KLikeType kLikeType) {
            Intrinsics.checkNotNullParameter(str, "queryId");
            Intrinsics.checkNotNullParameter(kLikeType, "likeType");
            return new LikeReqParam(str, kLikeType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LikeReqParam) {
                LikeReqParam likeReqParam = (LikeReqParam) obj;
                return Intrinsics.areEqual(this.queryId, likeReqParam.queryId) && Intrinsics.areEqual(this.likeType, likeReqParam.likeType);
            }
            return false;
        }

        public int hashCode() {
            return (this.queryId.hashCode() * 31) + this.likeType.hashCode();
        }

        public String toString() {
            String str = this.queryId;
            return "LikeReqParam(queryId=" + str + ", likeType=" + this.likeType + ")";
        }

        public LikeReqParam(String queryId, KLikeType likeType) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            Intrinsics.checkNotNullParameter(likeType, "likeType");
            this.queryId = queryId;
            this.likeType = likeType;
        }

        public /* synthetic */ LikeReqParam(String str, KLikeType kLikeType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? (KLikeType) KLikeType.INVALID.INSTANCE : kLikeType);
        }

        public final String getQueryId() {
            return this.queryId;
        }

        public final KLikeType getLikeType() {
            return this.likeType;
        }

        /* compiled from: RequestModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$LikeReqParam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0018"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$SubmitTreadParam;", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "selectedContent", "inputContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "getSelectedContent", "getInputContent", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SubmitTreadParam implements RequestParam {
        public static final Companion Companion = new Companion(null);
        private final String inputContent;
        private final String queryId;
        private final String selectedContent;

        public SubmitTreadParam() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SubmitTreadParam copy$default(SubmitTreadParam submitTreadParam, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitTreadParam.queryId;
            }
            if ((i & 2) != 0) {
                str2 = submitTreadParam.selectedContent;
            }
            if ((i & 4) != 0) {
                str3 = submitTreadParam.inputContent;
            }
            return submitTreadParam.copy(str, str2, str3);
        }

        public final String component1() {
            return this.queryId;
        }

        public final String component2() {
            return this.selectedContent;
        }

        public final String component3() {
            return this.inputContent;
        }

        public final SubmitTreadParam copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "queryId");
            Intrinsics.checkNotNullParameter(str2, "selectedContent");
            Intrinsics.checkNotNullParameter(str3, "inputContent");
            return new SubmitTreadParam(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubmitTreadParam) {
                SubmitTreadParam submitTreadParam = (SubmitTreadParam) obj;
                return Intrinsics.areEqual(this.queryId, submitTreadParam.queryId) && Intrinsics.areEqual(this.selectedContent, submitTreadParam.selectedContent) && Intrinsics.areEqual(this.inputContent, submitTreadParam.inputContent);
            }
            return false;
        }

        public int hashCode() {
            return (((this.queryId.hashCode() * 31) + this.selectedContent.hashCode()) * 31) + this.inputContent.hashCode();
        }

        public String toString() {
            String str = this.queryId;
            String str2 = this.selectedContent;
            return "SubmitTreadParam(queryId=" + str + ", selectedContent=" + str2 + ", inputContent=" + this.inputContent + ")";
        }

        public SubmitTreadParam(String queryId, String selectedContent, String inputContent) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            Intrinsics.checkNotNullParameter(selectedContent, "selectedContent");
            Intrinsics.checkNotNullParameter(inputContent, "inputContent");
            this.queryId = queryId;
            this.selectedContent = selectedContent;
            this.inputContent = inputContent;
        }

        public /* synthetic */ SubmitTreadParam(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3);
        }

        public final String getQueryId() {
            return this.queryId;
        }

        public final String getSelectedContent() {
            return this.selectedContent;
        }

        public final String getInputContent() {
            return this.inputContent;
        }

        /* compiled from: RequestModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestParam$SubmitTreadParam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}