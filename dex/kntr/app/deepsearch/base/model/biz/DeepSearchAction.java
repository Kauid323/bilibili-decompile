package kntr.app.deepsearch.base.model.biz;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import androidx.collection.DoubleList$;
import com.bapis.bilibili.app.dynamic.v2.KLinkNode;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeBubbleType;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KLikeType;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchAction.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000f\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0082\u0001\u000f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", RoomRecommendViewModel.EMPTY_CURSOR, "TextConfig", "CreateSession", "RetryChat", "ChatHistoryAction", "RetryIfPossible", "ContainerWidthChange", "ThinkPopViewAction", "InputAction", "AppStateAction", "DismissBubble", "CopyAction", "LikeAction", "TreadPopViewAction", "SubmitTreadAction", "TrackerAction", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ContainerWidthChange;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$CopyAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$CreateSession;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$DismissBubble;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$LikeAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryChat;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryIfPossible;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$SubmitTreadAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TextConfig;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchAction {

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TextConfig;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class TextConfig implements DeepSearchAction {
        public static final TextConfig INSTANCE = new TextConfig();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TextConfig) {
                TextConfig textConfig = (TextConfig) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1466419274;
        }

        public String toString() {
            return "TextConfig";
        }

        private TextConfig() {
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$CreateSession;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CreateSession implements DeepSearchAction {
        public static final CreateSession INSTANCE = new CreateSession();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CreateSession) {
                CreateSession createSession = (CreateSession) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1518022733;
        }

        public String toString() {
            return "CreateSession";
        }

        private CreateSession() {
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryChat;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "retryChatModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;)V", "getRetryChatModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RetryChat implements DeepSearchAction {
        private final DeepSearchRetryChatModel retryChatModel;

        public static /* synthetic */ RetryChat copy$default(RetryChat retryChat, DeepSearchRetryChatModel deepSearchRetryChatModel, int i, Object obj) {
            if ((i & 1) != 0) {
                deepSearchRetryChatModel = retryChat.retryChatModel;
            }
            return retryChat.copy(deepSearchRetryChatModel);
        }

        public final DeepSearchRetryChatModel component1() {
            return this.retryChatModel;
        }

        public final RetryChat copy(DeepSearchRetryChatModel deepSearchRetryChatModel) {
            Intrinsics.checkNotNullParameter(deepSearchRetryChatModel, "retryChatModel");
            return new RetryChat(deepSearchRetryChatModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RetryChat) && Intrinsics.areEqual(this.retryChatModel, ((RetryChat) obj).retryChatModel);
        }

        public int hashCode() {
            return this.retryChatModel.hashCode();
        }

        public String toString() {
            return "RetryChat(retryChatModel=" + this.retryChatModel + ")";
        }

        public RetryChat(DeepSearchRetryChatModel retryChatModel) {
            Intrinsics.checkNotNullParameter(retryChatModel, "retryChatModel");
            this.retryChatModel = retryChatModel;
        }

        public final DeepSearchRetryChatModel getRetryChatModel() {
            return this.retryChatModel;
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "Refresh", "LoadMore", "UpdateList", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$LoadMore;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$Refresh;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$UpdateList;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ChatHistoryAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$Refresh;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Refresh implements ChatHistoryAction {
            public static final Refresh INSTANCE = new Refresh();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Refresh) {
                    Refresh refresh = (Refresh) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 41902200;
            }

            public String toString() {
                return "Refresh";
            }

            private Refresh() {
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$LoadMore;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadMore implements ChatHistoryAction {
            public static final LoadMore INSTANCE = new LoadMore();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LoadMore) {
                    LoadMore loadMore = (LoadMore) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -439650466;
            }

            public String toString() {
                return "LoadMore";
            }

            private LoadMore() {
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction$UpdateList;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ChatHistoryAction;", "response", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryReply;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryReply;Ljava/lang/Exception;)V", "getResponse", "()Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryReply;", "getError", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class UpdateList implements ChatHistoryAction {
            private final Exception error;
            private final KChatHistoryReply response;

            public UpdateList() {
                this(null, null, 3, null);
            }

            public static /* synthetic */ UpdateList copy$default(UpdateList updateList, KChatHistoryReply kChatHistoryReply, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    kChatHistoryReply = updateList.response;
                }
                if ((i & 2) != 0) {
                    exc = updateList.error;
                }
                return updateList.copy(kChatHistoryReply, exc);
            }

            public final KChatHistoryReply component1() {
                return this.response;
            }

            public final Exception component2() {
                return this.error;
            }

            public final UpdateList copy(KChatHistoryReply kChatHistoryReply, Exception exc) {
                return new UpdateList(kChatHistoryReply, exc);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof UpdateList) {
                    UpdateList updateList = (UpdateList) obj;
                    return Intrinsics.areEqual(this.response, updateList.response) && Intrinsics.areEqual(this.error, updateList.error);
                }
                return false;
            }

            public int hashCode() {
                return ((this.response == null ? 0 : this.response.hashCode()) * 31) + (this.error != null ? this.error.hashCode() : 0);
            }

            public String toString() {
                KChatHistoryReply kChatHistoryReply = this.response;
                return "UpdateList(response=" + kChatHistoryReply + ", error=" + this.error + ")";
            }

            public UpdateList(KChatHistoryReply response, Exception error) {
                this.response = response;
                this.error = error;
            }

            public /* synthetic */ UpdateList(KChatHistoryReply kChatHistoryReply, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : kChatHistoryReply, (i & 2) != 0 ? null : exc);
            }

            public final KChatHistoryReply getResponse() {
                return this.response;
            }

            public final Exception getError() {
                return this.error;
            }
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$RetryIfPossible;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class RetryIfPossible implements DeepSearchAction {
        public static final RetryIfPossible INSTANCE = new RetryIfPossible();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RetryIfPossible) {
                RetryIfPossible retryIfPossible = (RetryIfPossible) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2023545327;
        }

        public String toString() {
            return "RetryIfPossible";
        }

        private RetryIfPossible() {
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ContainerWidthChange;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "containerWidth", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(D)V", "getContainerWidth", "()D", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ContainerWidthChange implements DeepSearchAction {
        private final double containerWidth;

        public static /* synthetic */ ContainerWidthChange copy$default(ContainerWidthChange containerWidthChange, double d, int i, Object obj) {
            if ((i & 1) != 0) {
                d = containerWidthChange.containerWidth;
            }
            return containerWidthChange.copy(d);
        }

        public final double component1() {
            return this.containerWidth;
        }

        public final ContainerWidthChange copy(double d) {
            return new ContainerWidthChange(d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContainerWidthChange) && Double.compare(this.containerWidth, ((ContainerWidthChange) obj).containerWidth) == 0;
        }

        public int hashCode() {
            return DoubleList$.ExternalSyntheticBackport0.m(this.containerWidth);
        }

        public String toString() {
            return "ContainerWidthChange(containerWidth=" + this.containerWidth + ")";
        }

        public ContainerWidthChange(double containerWidth) {
            this.containerWidth = containerWidth;
        }

        public final double getContainerWidth() {
            return this.containerWidth;
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "ThinkPopViewShow", "ThinkPopViewHidden", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction$ThinkPopViewHidden;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction$ThinkPopViewShow;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface ThinkPopViewAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction$ThinkPopViewShow;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ThinkPopViewShow implements ThinkPopViewAction {
            private final String queryId;

            public static /* synthetic */ ThinkPopViewShow copy$default(ThinkPopViewShow thinkPopViewShow, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = thinkPopViewShow.queryId;
                }
                return thinkPopViewShow.copy(str);
            }

            public final String component1() {
                return this.queryId;
            }

            public final ThinkPopViewShow copy(String str) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new ThinkPopViewShow(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ThinkPopViewShow) && Intrinsics.areEqual(this.queryId, ((ThinkPopViewShow) obj).queryId);
            }

            public int hashCode() {
                return this.queryId.hashCode();
            }

            public String toString() {
                return "ThinkPopViewShow(queryId=" + this.queryId + ")";
            }

            public ThinkPopViewShow(String queryId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction$ThinkPopViewHidden;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$ThinkPopViewAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ThinkPopViewHidden implements ThinkPopViewAction {
            public static final ThinkPopViewHidden INSTANCE = new ThinkPopViewHidden();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ThinkPopViewHidden) {
                    ThinkPopViewHidden thinkPopViewHidden = (ThinkPopViewHidden) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -705859397;
            }

            public String toString() {
                return "ThinkPopViewHidden";
            }

            private ThinkPopViewHidden() {
            }
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "InputChange", "InputClick", "SenderClick", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$InputChange;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$InputClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$SenderClick;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface InputAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$InputChange;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "value", RoomRecommendViewModel.EMPTY_CURSOR, "version", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;J)V", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getVersion", "()J", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class InputChange implements InputAction {
            private final String value;
            private final long version;

            public static /* synthetic */ InputChange copy$default(InputChange inputChange, String str, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = inputChange.value;
                }
                if ((i & 2) != 0) {
                    j2 = inputChange.version;
                }
                return inputChange.copy(str, j2);
            }

            public final String component1() {
                return this.value;
            }

            public final long component2() {
                return this.version;
            }

            public final InputChange copy(String str, long j2) {
                Intrinsics.checkNotNullParameter(str, "value");
                return new InputChange(str, j2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof InputChange) {
                    InputChange inputChange = (InputChange) obj;
                    return Intrinsics.areEqual(this.value, inputChange.value) && this.version == inputChange.version;
                }
                return false;
            }

            public int hashCode() {
                return (this.value.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version);
            }

            public String toString() {
                String str = this.value;
                return "InputChange(value=" + str + ", version=" + this.version + ")";
            }

            public InputChange(String value, long version) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.value = value;
                this.version = version;
            }

            public final String getValue() {
                return this.value;
            }

            public final long getVersion() {
                return this.version;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public InputChange(String value) {
                this(value, 0L);
                Intrinsics.checkNotNullParameter(value, "value");
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$InputClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class InputClick implements InputAction {
            public static final InputClick INSTANCE = new InputClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof InputClick) {
                    InputClick inputClick = (InputClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 468932211;
            }

            public String toString() {
                return "InputClick";
            }

            private InputClick() {
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction$SenderClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$InputAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SenderClick implements InputAction {
            public static final SenderClick INSTANCE = new SenderClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SenderClick) {
                    SenderClick senderClick = (SenderClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -1026909090;
            }

            public String toString() {
                return "SenderClick";
            }

            private SenderClick() {
            }
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "EnterBackground", "EnterForeground", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction$EnterBackground;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction$EnterForeground;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface AppStateAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction$EnterBackground;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class EnterBackground implements AppStateAction {
            public static final EnterBackground INSTANCE = new EnterBackground();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof EnterBackground) {
                    EnterBackground enterBackground = (EnterBackground) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 672018629;
            }

            public String toString() {
                return "EnterBackground";
            }

            private EnterBackground() {
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction$EnterForeground;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$AppStateAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class EnterForeground implements AppStateAction {
            public static final EnterForeground INSTANCE = new EnterForeground();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof EnterForeground) {
                    EnterForeground enterForeground = (EnterForeground) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -306297638;
            }

            public String toString() {
                return "EnterForeground";
            }

            private EnterForeground() {
            }
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$DismissBubble;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DismissBubble implements DeepSearchAction {
        public static final DismissBubble INSTANCE = new DismissBubble();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof DismissBubble) {
                DismissBubble dismissBubble = (DismissBubble) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1757549201;
        }

        public String toString() {
            return "DismissBubble";
        }

        private DismissBubble() {
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$CopyAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CopyAction implements DeepSearchAction {
        private final String queryId;

        public static /* synthetic */ CopyAction copy$default(CopyAction copyAction, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = copyAction.queryId;
            }
            return copyAction.copy(str);
        }

        public final String component1() {
            return this.queryId;
        }

        public final CopyAction copy(String str) {
            Intrinsics.checkNotNullParameter(str, "queryId");
            return new CopyAction(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CopyAction) && Intrinsics.areEqual(this.queryId, ((CopyAction) obj).queryId);
        }

        public int hashCode() {
            return this.queryId.hashCode();
        }

        public String toString() {
            return "CopyAction(queryId=" + this.queryId + ")";
        }

        public CopyAction(String queryId) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.queryId = queryId;
        }

        public final String getQueryId() {
            return this.queryId;
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$LikeAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "likeType", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;)V", "getQueryId", "()Ljava/lang/String;", "getLikeType", "()Lcom/bapis/bilibili/app/search/deepsearch/v1/KLikeType;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class LikeAction implements DeepSearchAction {
        private final KLikeType likeType;
        private final String queryId;

        public static /* synthetic */ LikeAction copy$default(LikeAction likeAction, String str, KLikeType kLikeType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = likeAction.queryId;
            }
            if ((i & 2) != 0) {
                kLikeType = likeAction.likeType;
            }
            return likeAction.copy(str, kLikeType);
        }

        public final String component1() {
            return this.queryId;
        }

        public final KLikeType component2() {
            return this.likeType;
        }

        public final LikeAction copy(String str, KLikeType kLikeType) {
            Intrinsics.checkNotNullParameter(str, "queryId");
            Intrinsics.checkNotNullParameter(kLikeType, "likeType");
            return new LikeAction(str, kLikeType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LikeAction) {
                LikeAction likeAction = (LikeAction) obj;
                return Intrinsics.areEqual(this.queryId, likeAction.queryId) && Intrinsics.areEqual(this.likeType, likeAction.likeType);
            }
            return false;
        }

        public int hashCode() {
            return (this.queryId.hashCode() * 31) + this.likeType.hashCode();
        }

        public String toString() {
            String str = this.queryId;
            return "LikeAction(queryId=" + str + ", likeType=" + this.likeType + ")";
        }

        public LikeAction(String queryId, KLikeType likeType) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            Intrinsics.checkNotNullParameter(likeType, "likeType");
            this.queryId = queryId;
            this.likeType = likeType;
        }

        public final String getQueryId() {
            return this.queryId;
        }

        public final KLikeType getLikeType() {
            return this.likeType;
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "TreadPopViewShow", "TreadPopViewHidden", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction$TreadPopViewHidden;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction$TreadPopViewShow;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface TreadPopViewAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction$TreadPopViewShow;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class TreadPopViewShow implements TreadPopViewAction {
            private final String queryId;

            public static /* synthetic */ TreadPopViewShow copy$default(TreadPopViewShow treadPopViewShow, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = treadPopViewShow.queryId;
                }
                return treadPopViewShow.copy(str);
            }

            public final String component1() {
                return this.queryId;
            }

            public final TreadPopViewShow copy(String str) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new TreadPopViewShow(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof TreadPopViewShow) && Intrinsics.areEqual(this.queryId, ((TreadPopViewShow) obj).queryId);
            }

            public int hashCode() {
                return this.queryId.hashCode();
            }

            public String toString() {
                return "TreadPopViewShow(queryId=" + this.queryId + ")";
            }

            public TreadPopViewShow(String queryId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction$TreadPopViewHidden;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TreadPopViewAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class TreadPopViewHidden implements TreadPopViewAction {
            public static final TreadPopViewHidden INSTANCE = new TreadPopViewHidden();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TreadPopViewHidden) {
                    TreadPopViewHidden treadPopViewHidden = (TreadPopViewHidden) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 480630715;
            }

            public String toString() {
                return "TreadPopViewHidden";
            }

            private TreadPopViewHidden() {
            }
        }
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$SubmitTreadAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "selectedContent", "inputContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "getSelectedContent", "getInputContent", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SubmitTreadAction implements DeepSearchAction {
        private final String inputContent;
        private final String queryId;
        private final String selectedContent;

        public static /* synthetic */ SubmitTreadAction copy$default(SubmitTreadAction submitTreadAction, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = submitTreadAction.queryId;
            }
            if ((i & 2) != 0) {
                str2 = submitTreadAction.selectedContent;
            }
            if ((i & 4) != 0) {
                str3 = submitTreadAction.inputContent;
            }
            return submitTreadAction.copy(str, str2, str3);
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

        public final SubmitTreadAction copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "queryId");
            Intrinsics.checkNotNullParameter(str2, "selectedContent");
            Intrinsics.checkNotNullParameter(str3, "inputContent");
            return new SubmitTreadAction(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SubmitTreadAction) {
                SubmitTreadAction submitTreadAction = (SubmitTreadAction) obj;
                return Intrinsics.areEqual(this.queryId, submitTreadAction.queryId) && Intrinsics.areEqual(this.selectedContent, submitTreadAction.selectedContent) && Intrinsics.areEqual(this.inputContent, submitTreadAction.inputContent);
            }
            return false;
        }

        public int hashCode() {
            return (((this.queryId.hashCode() * 31) + this.selectedContent.hashCode()) * 31) + this.inputContent.hashCode();
        }

        public String toString() {
            String str = this.queryId;
            String str2 = this.selectedContent;
            return "SubmitTreadAction(queryId=" + str + ", selectedContent=" + str2 + ", inputContent=" + this.inputContent + ")";
        }

        public SubmitTreadAction(String queryId, String selectedContent, String inputContent) {
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            Intrinsics.checkNotNullParameter(selectedContent, "selectedContent");
            Intrinsics.checkNotNullParameter(inputContent, "inputContent");
            this.queryId = queryId;
            this.selectedContent = selectedContent;
            this.inputContent = inputContent;
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
    }

    /* compiled from: DeepSearchAction.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0010\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0082\u0001\u0010\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !¨\u0006\"À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "HeadIconClick", "LinkNodeClick", "PictureClick", "BubbleClick", "ArchiveClick", "TimestampArchiveClick", "ArchiveTimestampClick", "PicturePreviewClick", "CopyClick", "LikeClick", "DisLikeClick", "SubmitDisLikeClick", "RetryClick", "PreviewPictureCommentFold", "PreviewPictureViewOriginPic", "HistoryEntryClick", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveTimestampClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$BubbleClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$CopyClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$DisLikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$HeadIconClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$HistoryEntryClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LinkNodeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PictureClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PicturePreviewClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureCommentFold;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureViewOriginPic;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$RetryClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$SubmitDisLikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$TimestampArchiveClick;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface TrackerAction extends DeepSearchAction {

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$HeadIconClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getMid", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class HeadIconClick implements TrackerAction {
            private final String mid;
            private final String queryId;

            public static /* synthetic */ HeadIconClick copy$default(HeadIconClick headIconClick, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = headIconClick.mid;
                }
                if ((i & 2) != 0) {
                    str2 = headIconClick.queryId;
                }
                return headIconClick.copy(str, str2);
            }

            public final String component1() {
                return this.mid;
            }

            public final String component2() {
                return this.queryId;
            }

            public final HeadIconClick copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, ReportBuildInParam.MID);
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new HeadIconClick(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HeadIconClick) {
                    HeadIconClick headIconClick = (HeadIconClick) obj;
                    return Intrinsics.areEqual(this.mid, headIconClick.mid) && Intrinsics.areEqual(this.queryId, headIconClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (this.mid.hashCode() * 31) + this.queryId.hashCode();
            }

            public String toString() {
                String str = this.mid;
                return "HeadIconClick(mid=" + str + ", queryId=" + this.queryId + ")";
            }

            public HeadIconClick(String mid, String queryId) {
                Intrinsics.checkNotNullParameter(mid, ReportBuildInParam.MID);
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.mid = mid;
                this.queryId = queryId;
            }

            public final String getMid() {
                return this.mid;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LinkNodeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "linkNode", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkNode;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KLinkNode;Ljava/lang/String;)V", "getLinkNode", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkNode;", "getQueryId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LinkNodeClick implements TrackerAction {
            private final KLinkNode linkNode;
            private final String queryId;

            public static /* synthetic */ LinkNodeClick copy$default(LinkNodeClick linkNodeClick, KLinkNode kLinkNode, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    kLinkNode = linkNodeClick.linkNode;
                }
                if ((i & 2) != 0) {
                    str = linkNodeClick.queryId;
                }
                return linkNodeClick.copy(kLinkNode, str);
            }

            public final KLinkNode component1() {
                return this.linkNode;
            }

            public final String component2() {
                return this.queryId;
            }

            public final LinkNodeClick copy(KLinkNode kLinkNode, String str) {
                Intrinsics.checkNotNullParameter(kLinkNode, "linkNode");
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new LinkNodeClick(kLinkNode, str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LinkNodeClick) {
                    LinkNodeClick linkNodeClick = (LinkNodeClick) obj;
                    return Intrinsics.areEqual(this.linkNode, linkNodeClick.linkNode) && Intrinsics.areEqual(this.queryId, linkNodeClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (this.linkNode.hashCode() * 31) + this.queryId.hashCode();
            }

            public String toString() {
                KLinkNode kLinkNode = this.linkNode;
                return "LinkNodeClick(linkNode=" + kLinkNode + ", queryId=" + this.queryId + ")";
            }

            public LinkNodeClick(KLinkNode linkNode, String queryId) {
                Intrinsics.checkNotNullParameter(linkNode, "linkNode");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.linkNode = linkNode;
                this.queryId = queryId;
            }

            public final KLinkNode getLinkNode() {
                return this.linkNode;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PictureClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "type", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;", "getParam", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class PictureClick implements TrackerAction {
            private final String param;
            private final String queryId;
            private final KPictureCard.KSource type;

            public static /* synthetic */ PictureClick copy$default(PictureClick pictureClick, KPictureCard.KSource kSource, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    kSource = pictureClick.type;
                }
                if ((i & 2) != 0) {
                    str = pictureClick.param;
                }
                if ((i & 4) != 0) {
                    str2 = pictureClick.queryId;
                }
                return pictureClick.copy(kSource, str, str2);
            }

            public final KPictureCard.KSource component1() {
                return this.type;
            }

            public final String component2() {
                return this.param;
            }

            public final String component3() {
                return this.queryId;
            }

            public final PictureClick copy(KPictureCard.KSource kSource, String str, String str2) {
                Intrinsics.checkNotNullParameter(kSource, "type");
                Intrinsics.checkNotNullParameter(str, "param");
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new PictureClick(kSource, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PictureClick) {
                    PictureClick pictureClick = (PictureClick) obj;
                    return Intrinsics.areEqual(this.type, pictureClick.type) && Intrinsics.areEqual(this.param, pictureClick.param) && Intrinsics.areEqual(this.queryId, pictureClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (((this.type.hashCode() * 31) + this.param.hashCode()) * 31) + this.queryId.hashCode();
            }

            public String toString() {
                KPictureCard.KSource kSource = this.type;
                String str = this.param;
                return "PictureClick(type=" + kSource + ", param=" + str + ", queryId=" + this.queryId + ")";
            }

            public PictureClick(KPictureCard.KSource type, String param, String queryId) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.type = type;
                this.param = param;
                this.queryId = queryId;
            }

            public final KPictureCard.KSource getType() {
                return this.type;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$BubbleClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "type", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkNodeBubbleType;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KLinkNodeBubbleType;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkNodeBubbleType;", "getParam", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class BubbleClick implements TrackerAction {
            private final String param;
            private final String queryId;
            private final KLinkNodeBubbleType type;

            public static /* synthetic */ BubbleClick copy$default(BubbleClick bubbleClick, KLinkNodeBubbleType kLinkNodeBubbleType, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    kLinkNodeBubbleType = bubbleClick.type;
                }
                if ((i & 2) != 0) {
                    str = bubbleClick.param;
                }
                if ((i & 4) != 0) {
                    str2 = bubbleClick.queryId;
                }
                return bubbleClick.copy(kLinkNodeBubbleType, str, str2);
            }

            public final KLinkNodeBubbleType component1() {
                return this.type;
            }

            public final String component2() {
                return this.param;
            }

            public final String component3() {
                return this.queryId;
            }

            public final BubbleClick copy(KLinkNodeBubbleType kLinkNodeBubbleType, String str, String str2) {
                Intrinsics.checkNotNullParameter(kLinkNodeBubbleType, "type");
                Intrinsics.checkNotNullParameter(str, "param");
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new BubbleClick(kLinkNodeBubbleType, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof BubbleClick) {
                    BubbleClick bubbleClick = (BubbleClick) obj;
                    return Intrinsics.areEqual(this.type, bubbleClick.type) && Intrinsics.areEqual(this.param, bubbleClick.param) && Intrinsics.areEqual(this.queryId, bubbleClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (((this.type.hashCode() * 31) + this.param.hashCode()) * 31) + this.queryId.hashCode();
            }

            public String toString() {
                KLinkNodeBubbleType kLinkNodeBubbleType = this.type;
                String str = this.param;
                return "BubbleClick(type=" + kLinkNodeBubbleType + ", param=" + str + ", queryId=" + this.queryId + ")";
            }

            public BubbleClick(KLinkNodeBubbleType type, String param, String queryId) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.type = type;
                this.param = param;
                this.queryId = queryId;
            }

            public final KLinkNodeBubbleType getType() {
                return this.type;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getParam", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ArchiveClick implements TrackerAction {
            private final String param;
            private final String queryId;

            public static /* synthetic */ ArchiveClick copy$default(ArchiveClick archiveClick, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = archiveClick.param;
                }
                if ((i & 2) != 0) {
                    str2 = archiveClick.queryId;
                }
                return archiveClick.copy(str, str2);
            }

            public final String component1() {
                return this.param;
            }

            public final String component2() {
                return this.queryId;
            }

            public final ArchiveClick copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "param");
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new ArchiveClick(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ArchiveClick) {
                    ArchiveClick archiveClick = (ArchiveClick) obj;
                    return Intrinsics.areEqual(this.param, archiveClick.param) && Intrinsics.areEqual(this.queryId, archiveClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (this.param.hashCode() * 31) + this.queryId.hashCode();
            }

            public String toString() {
                String str = this.param;
                return "ArchiveClick(param=" + str + ", queryId=" + this.queryId + ")";
            }

            public ArchiveClick(String param, String queryId) {
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.param = param;
                this.queryId = queryId;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$TimestampArchiveClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getParam", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class TimestampArchiveClick implements TrackerAction {
            private final String param;
            private final String queryId;

            public static /* synthetic */ TimestampArchiveClick copy$default(TimestampArchiveClick timestampArchiveClick, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = timestampArchiveClick.param;
                }
                if ((i & 2) != 0) {
                    str2 = timestampArchiveClick.queryId;
                }
                return timestampArchiveClick.copy(str, str2);
            }

            public final String component1() {
                return this.param;
            }

            public final String component2() {
                return this.queryId;
            }

            public final TimestampArchiveClick copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "param");
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new TimestampArchiveClick(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof TimestampArchiveClick) {
                    TimestampArchiveClick timestampArchiveClick = (TimestampArchiveClick) obj;
                    return Intrinsics.areEqual(this.param, timestampArchiveClick.param) && Intrinsics.areEqual(this.queryId, timestampArchiveClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (this.param.hashCode() * 31) + this.queryId.hashCode();
            }

            public String toString() {
                String str = this.param;
                return "TimestampArchiveClick(param=" + str + ", queryId=" + this.queryId + ")";
            }

            public TimestampArchiveClick(String param, String queryId) {
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.param = param;
                this.queryId = queryId;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$ArchiveTimestampClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getParam", "()Ljava/lang/String;", "getQueryId", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ArchiveTimestampClick implements TrackerAction {
            private final String param;
            private final String queryId;

            public ArchiveTimestampClick(String param, String queryId) {
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.param = param;
                this.queryId = queryId;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PicturePreviewClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "type", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;", "param", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard$KSource;", "getParam", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class PicturePreviewClick implements TrackerAction {
            private final String param;
            private final String queryId;
            private final KPictureCard.KSource type;

            public static /* synthetic */ PicturePreviewClick copy$default(PicturePreviewClick picturePreviewClick, KPictureCard.KSource kSource, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    kSource = picturePreviewClick.type;
                }
                if ((i & 2) != 0) {
                    str = picturePreviewClick.param;
                }
                if ((i & 4) != 0) {
                    str2 = picturePreviewClick.queryId;
                }
                return picturePreviewClick.copy(kSource, str, str2);
            }

            public final KPictureCard.KSource component1() {
                return this.type;
            }

            public final String component2() {
                return this.param;
            }

            public final String component3() {
                return this.queryId;
            }

            public final PicturePreviewClick copy(KPictureCard.KSource kSource, String str, String str2) {
                Intrinsics.checkNotNullParameter(kSource, "type");
                Intrinsics.checkNotNullParameter(str, "param");
                Intrinsics.checkNotNullParameter(str2, "queryId");
                return new PicturePreviewClick(kSource, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PicturePreviewClick) {
                    PicturePreviewClick picturePreviewClick = (PicturePreviewClick) obj;
                    return Intrinsics.areEqual(this.type, picturePreviewClick.type) && Intrinsics.areEqual(this.param, picturePreviewClick.param) && Intrinsics.areEqual(this.queryId, picturePreviewClick.queryId);
                }
                return false;
            }

            public int hashCode() {
                return (((this.type.hashCode() * 31) + this.param.hashCode()) * 31) + this.queryId.hashCode();
            }

            public String toString() {
                KPictureCard.KSource kSource = this.type;
                String str = this.param;
                return "PicturePreviewClick(type=" + kSource + ", param=" + str + ", queryId=" + this.queryId + ")";
            }

            public PicturePreviewClick(KPictureCard.KSource type, String param, String queryId) {
                Intrinsics.checkNotNullParameter(type, "type");
                Intrinsics.checkNotNullParameter(param, "param");
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.type = type;
                this.param = param;
                this.queryId = queryId;
            }

            public final KPictureCard.KSource getType() {
                return this.type;
            }

            public final String getParam() {
                return this.param;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$CopyClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class CopyClick implements TrackerAction {
            private final String queryId;

            public static /* synthetic */ CopyClick copy$default(CopyClick copyClick, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = copyClick.queryId;
                }
                return copyClick.copy(str);
            }

            public final String component1() {
                return this.queryId;
            }

            public final CopyClick copy(String str) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new CopyClick(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof CopyClick) && Intrinsics.areEqual(this.queryId, ((CopyClick) obj).queryId);
            }

            public int hashCode() {
                return this.queryId.hashCode();
            }

            public String toString() {
                return "CopyClick(queryId=" + this.queryId + ")";
            }

            public CopyClick(String queryId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$LikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "isCancel", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Z)V", "getQueryId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LikeClick implements TrackerAction {
            private final boolean isCancel;
            private final String queryId;

            public static /* synthetic */ LikeClick copy$default(LikeClick likeClick, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = likeClick.queryId;
                }
                if ((i & 2) != 0) {
                    z = likeClick.isCancel;
                }
                return likeClick.copy(str, z);
            }

            public final String component1() {
                return this.queryId;
            }

            public final boolean component2() {
                return this.isCancel;
            }

            public final LikeClick copy(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new LikeClick(str, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LikeClick) {
                    LikeClick likeClick = (LikeClick) obj;
                    return Intrinsics.areEqual(this.queryId, likeClick.queryId) && this.isCancel == likeClick.isCancel;
                }
                return false;
            }

            public int hashCode() {
                return (this.queryId.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCancel);
            }

            public String toString() {
                String str = this.queryId;
                return "LikeClick(queryId=" + str + ", isCancel=" + this.isCancel + ")";
            }

            public LikeClick(String queryId, boolean isCancel) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
                this.isCancel = isCancel;
            }

            public final String getQueryId() {
                return this.queryId;
            }

            public final boolean isCancel() {
                return this.isCancel;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$DisLikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "isCancel", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Z)V", "getQueryId", "()Ljava/lang/String;", "()Z", "component1", "component2", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class DisLikeClick implements TrackerAction {
            private final boolean isCancel;
            private final String queryId;

            public static /* synthetic */ DisLikeClick copy$default(DisLikeClick disLikeClick, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = disLikeClick.queryId;
                }
                if ((i & 2) != 0) {
                    z = disLikeClick.isCancel;
                }
                return disLikeClick.copy(str, z);
            }

            public final String component1() {
                return this.queryId;
            }

            public final boolean component2() {
                return this.isCancel;
            }

            public final DisLikeClick copy(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new DisLikeClick(str, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof DisLikeClick) {
                    DisLikeClick disLikeClick = (DisLikeClick) obj;
                    return Intrinsics.areEqual(this.queryId, disLikeClick.queryId) && this.isCancel == disLikeClick.isCancel;
                }
                return false;
            }

            public int hashCode() {
                return (this.queryId.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCancel);
            }

            public String toString() {
                String str = this.queryId;
                return "DisLikeClick(queryId=" + str + ", isCancel=" + this.isCancel + ")";
            }

            public DisLikeClick(String queryId, boolean isCancel) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
                this.isCancel = isCancel;
            }

            public final String getQueryId() {
                return this.queryId;
            }

            public final boolean isCancel() {
                return this.isCancel;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$SubmitDisLikeClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "disLikeReason", "reasonDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "getDisLikeReason", "getReasonDetail", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SubmitDisLikeClick implements TrackerAction {
            private final String disLikeReason;
            private final String queryId;
            private final String reasonDetail;

            public static /* synthetic */ SubmitDisLikeClick copy$default(SubmitDisLikeClick submitDisLikeClick, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = submitDisLikeClick.queryId;
                }
                if ((i & 2) != 0) {
                    str2 = submitDisLikeClick.disLikeReason;
                }
                if ((i & 4) != 0) {
                    str3 = submitDisLikeClick.reasonDetail;
                }
                return submitDisLikeClick.copy(str, str2, str3);
            }

            public final String component1() {
                return this.queryId;
            }

            public final String component2() {
                return this.disLikeReason;
            }

            public final String component3() {
                return this.reasonDetail;
            }

            public final SubmitDisLikeClick copy(String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                Intrinsics.checkNotNullParameter(str2, "disLikeReason");
                Intrinsics.checkNotNullParameter(str3, "reasonDetail");
                return new SubmitDisLikeClick(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof SubmitDisLikeClick) {
                    SubmitDisLikeClick submitDisLikeClick = (SubmitDisLikeClick) obj;
                    return Intrinsics.areEqual(this.queryId, submitDisLikeClick.queryId) && Intrinsics.areEqual(this.disLikeReason, submitDisLikeClick.disLikeReason) && Intrinsics.areEqual(this.reasonDetail, submitDisLikeClick.reasonDetail);
                }
                return false;
            }

            public int hashCode() {
                return (((this.queryId.hashCode() * 31) + this.disLikeReason.hashCode()) * 31) + this.reasonDetail.hashCode();
            }

            public String toString() {
                String str = this.queryId;
                String str2 = this.disLikeReason;
                return "SubmitDisLikeClick(queryId=" + str + ", disLikeReason=" + str2 + ", reasonDetail=" + this.reasonDetail + ")";
            }

            public SubmitDisLikeClick(String queryId, String disLikeReason, String reasonDetail) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                Intrinsics.checkNotNullParameter(disLikeReason, "disLikeReason");
                Intrinsics.checkNotNullParameter(reasonDetail, "reasonDetail");
                this.queryId = queryId;
                this.disLikeReason = disLikeReason;
                this.reasonDetail = reasonDetail;
            }

            public final String getQueryId() {
                return this.queryId;
            }

            public final String getDisLikeReason() {
                return this.disLikeReason;
            }

            public final String getReasonDetail() {
                return this.reasonDetail;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$RetryClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class RetryClick implements TrackerAction {
            private final String queryId;

            public static /* synthetic */ RetryClick copy$default(RetryClick retryClick, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = retryClick.queryId;
                }
                return retryClick.copy(str);
            }

            public final String component1() {
                return this.queryId;
            }

            public final RetryClick copy(String str) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new RetryClick(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof RetryClick) && Intrinsics.areEqual(this.queryId, ((RetryClick) obj).queryId);
            }

            public int hashCode() {
                return this.queryId.hashCode();
            }

            public String toString() {
                return "RetryClick(queryId=" + this.queryId + ")";
            }

            public RetryClick(String queryId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureCommentFold;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "isFold", RoomRecommendViewModel.EMPTY_CURSOR, "commentId", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "()Z", "getCommentId", "component1", "component2", "component3", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class PreviewPictureCommentFold implements TrackerAction {
            private final String commentId;
            private final boolean isFold;
            private final String queryId;

            public static /* synthetic */ PreviewPictureCommentFold copy$default(PreviewPictureCommentFold previewPictureCommentFold, String str, boolean z, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = previewPictureCommentFold.queryId;
                }
                if ((i & 2) != 0) {
                    z = previewPictureCommentFold.isFold;
                }
                if ((i & 4) != 0) {
                    str2 = previewPictureCommentFold.commentId;
                }
                return previewPictureCommentFold.copy(str, z, str2);
            }

            public final String component1() {
                return this.queryId;
            }

            public final boolean component2() {
                return this.isFold;
            }

            public final String component3() {
                return this.commentId;
            }

            public final PreviewPictureCommentFold copy(String str, boolean z, String str2) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                Intrinsics.checkNotNullParameter(str2, "commentId");
                return new PreviewPictureCommentFold(str, z, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof PreviewPictureCommentFold) {
                    PreviewPictureCommentFold previewPictureCommentFold = (PreviewPictureCommentFold) obj;
                    return Intrinsics.areEqual(this.queryId, previewPictureCommentFold.queryId) && this.isFold == previewPictureCommentFold.isFold && Intrinsics.areEqual(this.commentId, previewPictureCommentFold.commentId);
                }
                return false;
            }

            public int hashCode() {
                return (((this.queryId.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFold)) * 31) + this.commentId.hashCode();
            }

            public String toString() {
                String str = this.queryId;
                boolean z = this.isFold;
                return "PreviewPictureCommentFold(queryId=" + str + ", isFold=" + z + ", commentId=" + this.commentId + ")";
            }

            public PreviewPictureCommentFold(String queryId, boolean isFold, String commentId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                Intrinsics.checkNotNullParameter(commentId, "commentId");
                this.queryId = queryId;
                this.isFold = isFold;
                this.commentId = commentId;
            }

            public final String getQueryId() {
                return this.queryId;
            }

            public final boolean isFold() {
                return this.isFold;
            }

            public final String getCommentId() {
                return this.commentId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$PreviewPictureViewOriginPic;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQueryId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class PreviewPictureViewOriginPic implements TrackerAction {
            private final String queryId;

            public static /* synthetic */ PreviewPictureViewOriginPic copy$default(PreviewPictureViewOriginPic previewPictureViewOriginPic, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = previewPictureViewOriginPic.queryId;
                }
                return previewPictureViewOriginPic.copy(str);
            }

            public final String component1() {
                return this.queryId;
            }

            public final PreviewPictureViewOriginPic copy(String str) {
                Intrinsics.checkNotNullParameter(str, "queryId");
                return new PreviewPictureViewOriginPic(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof PreviewPictureViewOriginPic) && Intrinsics.areEqual(this.queryId, ((PreviewPictureViewOriginPic) obj).queryId);
            }

            public int hashCode() {
                return this.queryId.hashCode();
            }

            public String toString() {
                return "PreviewPictureViewOriginPic(queryId=" + this.queryId + ")";
            }

            public PreviewPictureViewOriginPic(String queryId) {
                Intrinsics.checkNotNullParameter(queryId, "queryId");
                this.queryId = queryId;
            }

            public final String getQueryId() {
                return this.queryId;
            }
        }

        /* compiled from: DeepSearchAction.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction$HistoryEntryClick;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction$TrackerAction;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class HistoryEntryClick implements TrackerAction {
            public static final HistoryEntryClick INSTANCE = new HistoryEntryClick();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof HistoryEntryClick) {
                    HistoryEntryClick historyEntryClick = (HistoryEntryClick) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -440321309;
            }

            public String toString() {
                return "HistoryEntryClick";
            }

            private HistoryEntryClick() {
            }
        }
    }
}