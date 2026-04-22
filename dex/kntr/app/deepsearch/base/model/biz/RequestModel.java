package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.Lens;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestModel.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006&"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestModel;", RoomRecommendViewModel.EMPTY_CURSOR, "textConfigReqState", "Lkntr/app/deepsearch/base/model/biz/RequestState;", "sessionReqState", "chatReqState", "stopChatReqState", "chatHistoryReqState", "likeReqState", "submitTreadState", "<init>", "(Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;Lkntr/app/deepsearch/base/model/biz/RequestState;)V", "getTextConfigReqState", "()Lkntr/app/deepsearch/base/model/biz/RequestState;", "getSessionReqState", "getChatReqState", "getStopChatReqState", "getChatHistoryReqState", "getLikeReqState$annotations", "()V", "getLikeReqState", "getSubmitTreadState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestModel {
    public static final Companion Companion = new Companion(null);
    private final RequestState chatHistoryReqState;
    private final RequestState chatReqState;
    private final RequestState likeReqState;
    private final RequestState sessionReqState;
    private final RequestState stopChatReqState;
    private final RequestState submitTreadState;
    private final RequestState textConfigReqState;

    public RequestModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ RequestModel copy$default(RequestModel requestModel, RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4, RequestState requestState5, RequestState requestState6, RequestState requestState7, int i, Object obj) {
        if ((i & 1) != 0) {
            requestState = requestModel.textConfigReqState;
        }
        if ((i & 2) != 0) {
            requestState2 = requestModel.sessionReqState;
        }
        RequestState requestState8 = requestState2;
        if ((i & 4) != 0) {
            requestState3 = requestModel.chatReqState;
        }
        RequestState requestState9 = requestState3;
        if ((i & 8) != 0) {
            requestState4 = requestModel.stopChatReqState;
        }
        RequestState requestState10 = requestState4;
        if ((i & 16) != 0) {
            requestState5 = requestModel.chatHistoryReqState;
        }
        RequestState requestState11 = requestState5;
        if ((i & 32) != 0) {
            requestState6 = requestModel.likeReqState;
        }
        RequestState requestState12 = requestState6;
        if ((i & 64) != 0) {
            requestState7 = requestModel.submitTreadState;
        }
        return requestModel.copy(requestState, requestState8, requestState9, requestState10, requestState11, requestState12, requestState7);
    }

    public static /* synthetic */ void getLikeReqState$annotations() {
    }

    public final RequestState component1() {
        return this.textConfigReqState;
    }

    public final RequestState component2() {
        return this.sessionReqState;
    }

    public final RequestState component3() {
        return this.chatReqState;
    }

    public final RequestState component4() {
        return this.stopChatReqState;
    }

    public final RequestState component5() {
        return this.chatHistoryReqState;
    }

    public final RequestState component6() {
        return this.likeReqState;
    }

    public final RequestState component7() {
        return this.submitTreadState;
    }

    public final RequestModel copy(RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4, RequestState requestState5, RequestState requestState6, RequestState requestState7) {
        Intrinsics.checkNotNullParameter(requestState, "textConfigReqState");
        Intrinsics.checkNotNullParameter(requestState2, "sessionReqState");
        Intrinsics.checkNotNullParameter(requestState3, "chatReqState");
        Intrinsics.checkNotNullParameter(requestState4, "stopChatReqState");
        Intrinsics.checkNotNullParameter(requestState5, "chatHistoryReqState");
        Intrinsics.checkNotNullParameter(requestState6, "likeReqState");
        Intrinsics.checkNotNullParameter(requestState7, "submitTreadState");
        return new RequestModel(requestState, requestState2, requestState3, requestState4, requestState5, requestState6, requestState7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestModel) {
            RequestModel requestModel = (RequestModel) obj;
            return Intrinsics.areEqual(this.textConfigReqState, requestModel.textConfigReqState) && Intrinsics.areEqual(this.sessionReqState, requestModel.sessionReqState) && Intrinsics.areEqual(this.chatReqState, requestModel.chatReqState) && Intrinsics.areEqual(this.stopChatReqState, requestModel.stopChatReqState) && Intrinsics.areEqual(this.chatHistoryReqState, requestModel.chatHistoryReqState) && Intrinsics.areEqual(this.likeReqState, requestModel.likeReqState) && Intrinsics.areEqual(this.submitTreadState, requestModel.submitTreadState);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.textConfigReqState.hashCode() * 31) + this.sessionReqState.hashCode()) * 31) + this.chatReqState.hashCode()) * 31) + this.stopChatReqState.hashCode()) * 31) + this.chatHistoryReqState.hashCode()) * 31) + this.likeReqState.hashCode()) * 31) + this.submitTreadState.hashCode();
    }

    public String toString() {
        RequestState requestState = this.textConfigReqState;
        RequestState requestState2 = this.sessionReqState;
        RequestState requestState3 = this.chatReqState;
        RequestState requestState4 = this.stopChatReqState;
        RequestState requestState5 = this.chatHistoryReqState;
        RequestState requestState6 = this.likeReqState;
        return "RequestModel(textConfigReqState=" + requestState + ", sessionReqState=" + requestState2 + ", chatReqState=" + requestState3 + ", stopChatReqState=" + requestState4 + ", chatHistoryReqState=" + requestState5 + ", likeReqState=" + requestState6 + ", submitTreadState=" + this.submitTreadState + ")";
    }

    public RequestModel(RequestState textConfigReqState, RequestState sessionReqState, RequestState chatReqState, RequestState stopChatReqState, RequestState chatHistoryReqState, RequestState likeReqState, RequestState submitTreadState) {
        Intrinsics.checkNotNullParameter(textConfigReqState, "textConfigReqState");
        Intrinsics.checkNotNullParameter(sessionReqState, "sessionReqState");
        Intrinsics.checkNotNullParameter(chatReqState, "chatReqState");
        Intrinsics.checkNotNullParameter(stopChatReqState, "stopChatReqState");
        Intrinsics.checkNotNullParameter(chatHistoryReqState, "chatHistoryReqState");
        Intrinsics.checkNotNullParameter(likeReqState, "likeReqState");
        Intrinsics.checkNotNullParameter(submitTreadState, "submitTreadState");
        this.textConfigReqState = textConfigReqState;
        this.sessionReqState = sessionReqState;
        this.chatReqState = chatReqState;
        this.stopChatReqState = stopChatReqState;
        this.chatHistoryReqState = chatHistoryReqState;
        this.likeReqState = likeReqState;
        this.submitTreadState = submitTreadState;
    }

    public /* synthetic */ RequestModel(RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4, RequestState requestState5, RequestState requestState6, RequestState requestState7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RequestState(null, null, 3, null) : requestState, (i & 2) != 0 ? new RequestState(null, null, 3, null) : requestState2, (i & 4) != 0 ? new RequestState(null, null, 3, null) : requestState3, (i & 8) != 0 ? new RequestState(null, null, 3, null) : requestState4, (i & 16) != 0 ? new RequestState(null, null, 3, null) : requestState5, (i & 32) != 0 ? new RequestState(null, null, 3, null) : requestState6, (i & 64) != 0 ? new RequestState(null, null, 3, null) : requestState7);
    }

    public final RequestState getTextConfigReqState() {
        return this.textConfigReqState;
    }

    public final RequestState getSessionReqState() {
        return this.sessionReqState;
    }

    public final RequestState getChatReqState() {
        return this.chatReqState;
    }

    public final RequestState getStopChatReqState() {
        return this.stopChatReqState;
    }

    public final RequestState getChatHistoryReqState() {
        return this.chatHistoryReqState;
    }

    public final RequestState getLikeReqState() {
        return this.likeReqState;
    }

    public final RequestState getSubmitTreadState() {
        return this.submitTreadState;
    }

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestModel$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}