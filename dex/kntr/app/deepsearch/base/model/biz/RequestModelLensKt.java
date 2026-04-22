package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.deepsearch.base.model.biz.RequestModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestModelLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0007\"*\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010 \u001a\u0004\b\u000b\u0010!\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010 \u001a\u0004\b\u000e\u0010!\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010 \u001a\u0004\b\u0011\u0010!\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010 \u001a\u0004\b\u0014\u0010!\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010 \u001a\u0004\b\u0017\u0010!\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010 \u001a\u0004\b\u001a\u0010!\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010 \u001a\u0004\b\u001d\u0010!\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010 \u001a\u0004\b$\u0010%\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010 \u001a\u0004\b'\u0010%\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010 \u001a\u0004\b)\u0010%\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010 \u001a\u0004\b+\u0010%\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010 \u001a\u0004\b-\u0010%\"B\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010 \u001a\u0004\b/\u0010%\"B\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u0010\u0012\u0004\u0012\u0002H\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010 \u001a\u0004\b1\u0010%\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u00102\u001a\u0004\b\u000b\u00103\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u00102\u001a\u0004\b\u000e\u00103\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u00102\u001a\u0004\b\u0011\u00103\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u00102\u001a\u0004\b\u0014\u00103\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u00102\u001a\u0004\b\u0017\u00103\"@\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u00102\u001a\u0004\b\u001a\u00103\"@\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\t0\"\"\b\b\u0000\u0010\u001e*\u00020\u001f*\u000e\u0012\u0004\u0012\u0002H\u001e\u0012\u0004\u0012\u00020\u00020\"8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u00102\u001a\u0004\b\u001d\u00103¨\u00064"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/RequestModel;", "Lkntr/app/deepsearch/base/model/biz/RequestModel$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/RequestModel$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/RequestModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "textConfigReqState", "Lkntr/app/deepsearch/base/model/biz/RequestState;", "getTextConfigReqState$annotations", "getTextConfigReqState", "sessionReqState", "getSessionReqState$annotations", "getSessionReqState", "chatReqState", "getChatReqState$annotations", "getChatReqState", "stopChatReqState", "getStopChatReqState$annotations", "getStopChatReqState", "chatHistoryReqState", "getChatHistoryReqState$annotations", "getChatHistoryReqState", "likeReqState", "getLikeReqState$annotations", "getLikeReqState", "submitTreadState", "getSubmitTreadState$annotations", "getSubmitTreadState", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "textConfigReqStateNullable$annotations", "textConfigReqStateNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "sessionReqStateNullable$annotations", "sessionReqStateNullable", "chatReqStateNullable$annotations", "chatReqStateNullable", "stopChatReqStateNullable$annotations", "stopChatReqStateNullable", "chatHistoryReqStateNullable$annotations", "chatHistoryReqStateNullable", "likeReqStateNullable$annotations", "likeReqStateNullable", "submitTreadStateNullable$annotations", "submitTreadStateNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RequestModelLensKt {
    public static /* synthetic */ void chatHistoryReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void chatReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatHistoryReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatHistoryReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatHistoryReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getChatReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getChatReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getChatReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getLikeReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getLikeReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getLikeReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getSessionReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSessionReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSessionReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getStopChatReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStopChatReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStopChatReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getSubmitTreadState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSubmitTreadState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSubmitTreadState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getTextConfigReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTextConfigReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTextConfigReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void likeReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void sessionReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void stopChatReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void submitTreadStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void textConfigReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<RequestModel, RequestModel> getLens(RequestModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestModel>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$1
            public RequestModel get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it;
            }

            public RequestModel set(RequestModel requestModel, RequestModel requestModel2) {
                RequestModel it = requestModel2;
                return it;
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestModel, ? extends RequestModel> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                return (RequestModel) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getTextConfigReqState(RequestModel.Companion $this$textConfigReqState) {
        Intrinsics.checkNotNullParameter($this$textConfigReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$2
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getTextConfigReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState textConfigReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, textConfigReqState, null, null, null, null, null, null, 126, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState textConfigReqState = (RequestState) function1.invoke(it.getTextConfigReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, textConfigReqState, null, null, null, null, null, null, 126, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getSessionReqState(RequestModel.Companion $this$sessionReqState) {
        Intrinsics.checkNotNullParameter($this$sessionReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$3
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getSessionReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState sessionReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, sessionReqState, null, null, null, null, null, 125, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState sessionReqState = (RequestState) function1.invoke(it.getSessionReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, sessionReqState, null, null, null, null, null, 125, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getChatReqState(RequestModel.Companion $this$chatReqState) {
        Intrinsics.checkNotNullParameter($this$chatReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$4
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getChatReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState chatReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, chatReqState, null, null, null, null, 123, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState chatReqState = (RequestState) function1.invoke(it.getChatReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, chatReqState, null, null, null, null, 123, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getStopChatReqState(RequestModel.Companion $this$stopChatReqState) {
        Intrinsics.checkNotNullParameter($this$stopChatReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$5
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getStopChatReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState stopChatReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, null, stopChatReqState, null, null, null, 119, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState stopChatReqState = (RequestState) function1.invoke(it.getStopChatReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, null, stopChatReqState, null, null, null, 119, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getChatHistoryReqState(RequestModel.Companion $this$chatHistoryReqState) {
        Intrinsics.checkNotNullParameter($this$chatHistoryReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$6
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getChatHistoryReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState chatHistoryReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, null, null, chatHistoryReqState, null, null, 111, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState chatHistoryReqState = (RequestState) function1.invoke(it.getChatHistoryReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, null, null, chatHistoryReqState, null, null, 111, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getLikeReqState(RequestModel.Companion $this$likeReqState) {
        Intrinsics.checkNotNullParameter($this$likeReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$7
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getLikeReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState likeReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, null, null, null, likeReqState, null, 95, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState likeReqState = (RequestState) function1.invoke(it.getLikeReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, null, null, null, likeReqState, null, 95, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getSubmitTreadState(RequestModel.Companion $this$submitTreadState) {
        Intrinsics.checkNotNullParameter($this$submitTreadState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestModelLensKt$special$$inlined$invoke$8
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getSubmitTreadState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState submitTreadState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, null, null, null, null, submitTreadState, 63, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState submitTreadState = (RequestState) function1.invoke(it.getSubmitTreadState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, null, null, null, null, submitTreadState, 63, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, RequestState> getTextConfigReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTextConfigReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getSessionReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSessionReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getChatReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getStopChatReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStopChatReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getChatHistoryReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getChatHistoryReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getLikeReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getLikeReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getSubmitTreadState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSubmitTreadState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> textConfigReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTextConfigReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> sessionReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSessionReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> chatReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> stopChatReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStopChatReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> chatHistoryReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getChatHistoryReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> likeReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getLikeReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> submitTreadStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSubmitTreadState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getTextConfigReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTextConfigReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getSessionReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSessionReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getChatReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getStopChatReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStopChatReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getChatHistoryReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getChatHistoryReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getLikeReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getLikeReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getSubmitTreadState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSubmitTreadState(RequestModel.Companion));
    }
}