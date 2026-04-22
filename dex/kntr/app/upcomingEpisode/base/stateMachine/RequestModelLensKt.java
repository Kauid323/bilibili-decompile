package kntr.app.upcomingEpisode.base.stateMachine;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestModelLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"*\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0017\u001a\u0004\b\u000e\u0010\u0018\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001c\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u001c\"B\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u001c\"B\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u001c\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010#\u001a\u0004\b\u000b\u0010$\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010#\u001a\u0004\b\u000e\u0010$\"@\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010#\u001a\u0004\b\u0011\u0010$\"@\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\t0\u0019\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00198FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010#\u001a\u0004\b\u0014\u0010$¨\u0006%"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel$Companion;", "getLens$annotations", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel$Companion;)V", "getLens", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel$Companion;)Lcom/bilibili/blens/BSimpleLens;", "delCalendarCardReqState", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;", "getDelCalendarCardReqState$annotations", "getDelCalendarCardReqState", "watchCalendarReqState", "getWatchCalendarReqState$annotations", "getWatchCalendarReqState", "reserveCardReqState", "getReserveCardReqState$annotations", "getReserveCardReqState", "cancelReserveCardReqState", "getCancelReserveCardReqState$annotations", "getCancelReserveCardReqState", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "delCalendarCardReqStateNullable$annotations", "delCalendarCardReqStateNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "watchCalendarReqStateNullable$annotations", "watchCalendarReqStateNullable", "reserveCardReqStateNullable$annotations", "reserveCardReqStateNullable", "cancelReserveCardReqStateNullable$annotations", "cancelReserveCardReqStateNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RequestModelLensKt {
    public static /* synthetic */ void cancelReserveCardReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void delCalendarCardReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCancelReserveCardReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCancelReserveCardReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCancelReserveCardReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getDelCalendarCardReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getDelCalendarCardReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getDelCalendarCardReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getReserveCardReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getReserveCardReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getReserveCardReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void getWatchCalendarReqState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getWatchCalendarReqState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getWatchCalendarReqState$annotations(RequestModel.Companion companion) {
    }

    public static /* synthetic */ void reserveCardReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void watchCalendarReqStateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<RequestModel, RequestModel> getLens(RequestModel.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestModel>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt$special$$inlined$invoke$1
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

    public static final BSimpleLens<RequestModel, RequestState> getDelCalendarCardReqState(RequestModel.Companion $this$delCalendarCardReqState) {
        Intrinsics.checkNotNullParameter($this$delCalendarCardReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt$special$$inlined$invoke$2
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getDelCalendarCardReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState delCalendarCardReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, delCalendarCardReqState, null, null, null, 14, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState delCalendarCardReqState = (RequestState) function1.invoke(it.getDelCalendarCardReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, delCalendarCardReqState, null, null, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getWatchCalendarReqState(RequestModel.Companion $this$watchCalendarReqState) {
        Intrinsics.checkNotNullParameter($this$watchCalendarReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt$special$$inlined$invoke$3
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getWatchCalendarReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState watchCalendarReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, watchCalendarReqState, null, null, 13, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState watchCalendarReqState = (RequestState) function1.invoke(it.getWatchCalendarReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, watchCalendarReqState, null, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getReserveCardReqState(RequestModel.Companion $this$reserveCardReqState) {
        Intrinsics.checkNotNullParameter($this$reserveCardReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt$special$$inlined$invoke$4
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getReserveCardReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState reserveCardReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, reserveCardReqState, null, 11, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState reserveCardReqState = (RequestState) function1.invoke(it.getReserveCardReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, reserveCardReqState, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<RequestModel, RequestState> getCancelReserveCardReqState(RequestModel.Companion $this$cancelReserveCardReqState) {
        Intrinsics.checkNotNullParameter($this$cancelReserveCardReqState, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestModel, RequestState>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestModelLensKt$special$$inlined$invoke$5
            public RequestState get(RequestModel requestModel) {
                RequestModel it = requestModel;
                return it.getCancelReserveCardReqState();
            }

            public RequestModel set(RequestModel requestModel, RequestState requestState) {
                RequestState cancelReserveCardReqState = requestState;
                RequestModel it = requestModel;
                return RequestModel.copy$default(it, null, null, null, cancelReserveCardReqState, 7, null);
            }

            public RequestModel modify(RequestModel requestModel, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestModel it = requestModel;
                RequestState cancelReserveCardReqState = (RequestState) function1.invoke(it.getCancelReserveCardReqState());
                RequestModel it2 = requestModel;
                return RequestModel.copy$default(it2, null, null, null, cancelReserveCardReqState, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, RequestState> getDelCalendarCardReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getDelCalendarCardReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getWatchCalendarReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getWatchCalendarReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getReserveCardReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getReserveCardReqState(RequestModel.Companion));
    }

    public static final <T> BSimpleLens<T, RequestState> getCancelReserveCardReqState(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCancelReserveCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> delCalendarCardReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getDelCalendarCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> watchCalendarReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getWatchCalendarReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> reserveCardReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getReserveCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> cancelReserveCardReqStateNullable(BSimpleLens<T, RequestModel> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCancelReserveCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getDelCalendarCardReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getDelCalendarCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getWatchCalendarReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getWatchCalendarReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getReserveCardReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getReserveCardReqState(RequestModel.Companion));
    }

    public static final <T> BNullableLens<T, RequestState> getCancelReserveCardReqState(BNullableLens<T, RequestModel> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCancelReserveCardReqState(RequestModel.Companion));
    }
}