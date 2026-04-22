package kntr.app.upcomingEpisode.base.stateMachine;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestStateLens.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"0\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\",\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001b\u001a\u0004\b\u000b\u0010\u001c\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u000f\u0010\u001c\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u0014\u0010\u001c\"B\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u0018\u0010\u001c\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 \"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010 \"H\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b#\u0010\u001b\u001a\u0004\b$\u0010 \"D\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001b\u001a\u0004\b&\u0010\u001c\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\t0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010'\u001a\u0004\b\u000b\u0010(\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\r0\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010'\u001a\u0004\b\u000f\u0010(\"F\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u0002H\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u001d\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010'\u001a\u0004\b\u0014\u0010(\"B\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0001\"\b\b\u0000\u0010\u0019*\u00020\u001a*\u000e\u0012\u0004\u0012\u0002H\u0019\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010'\u001a\u0004\b\u0018\u0010)¨\u0006*"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestState$Companion;", "getLens$annotations", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestState$Companion;)V", "getLens", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestState$Companion;)Lcom/bilibili/blens/BSimpleLens;", "state", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;", "getState$annotations", "getState", "from", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "getFrom$annotations", "getFrom", "onReqSuccess", "Lkotlin/Function0;", "", "getOnReqSuccess$annotations", "getOnReqSuccess", "param", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "getParam$annotations", "getParam", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "stateNullable$annotations", "stateNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "fromNullable$annotations", "fromNullable", "onReqSuccessNullable$annotations", "onReqSuccessNullable", "paramNullable$annotations", "paramNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RequestStateLensKt {
    public static /* synthetic */ void fromNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFrom$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getFrom$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getFrom$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getOnReqSuccess$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOnReqSuccess$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOnReqSuccess$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getParam$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getParam$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getParam$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getState$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getState$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getState$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void onReqSuccessNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void paramNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void stateNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<RequestState, RequestState> getLens(RequestState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestState>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt$special$$inlined$invoke$1
            public RequestState get(RequestState requestState) {
                RequestState it = requestState;
                return it;
            }

            public RequestState set(RequestState requestState, RequestState requestState2) {
                RequestState it = requestState2;
                return it;
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestState, ? extends RequestState> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                return (RequestState) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<RequestState, RequestStatus> getState(RequestState.Companion $this$state) {
        Intrinsics.checkNotNullParameter($this$state, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestStatus>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt$special$$inlined$invoke$2
            public RequestStatus get(RequestState requestState) {
                RequestState it = requestState;
                return it.getState();
            }

            public RequestState set(RequestState requestState, RequestStatus requestStatus) {
                RequestStatus state = requestStatus;
                RequestState it = requestState;
                return RequestState.copy$default(it, state, null, null, null, 14, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                RequestStatus state = (RequestStatus) function1.invoke(it.getState());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, state, null, null, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<RequestState, RequestFrom> getFrom(RequestState.Companion $this$from) {
        Intrinsics.checkNotNullParameter($this$from, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestFrom>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt$special$$inlined$invoke$3
            public RequestFrom get(RequestState requestState) {
                RequestState it = requestState;
                return it.getFrom();
            }

            public RequestState set(RequestState requestState, RequestFrom requestFrom) {
                RequestFrom from = requestFrom;
                RequestState it = requestState;
                return RequestState.copy$default(it, null, from, null, null, 13, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestFrom, ? extends RequestFrom> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                RequestFrom from = (RequestFrom) function1.invoke(it.getFrom());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, null, from, null, null, 13, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<RequestState, Function0<Unit>> getOnReqSuccess(RequestState.Companion $this$onReqSuccess) {
        Intrinsics.checkNotNullParameter($this$onReqSuccess, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, Function0<? extends Unit>>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt$special$$inlined$invoke$4
            public Function0<? extends Unit> get(RequestState requestState) {
                RequestState it = requestState;
                return it.getOnReqSuccess();
            }

            public RequestState set(RequestState requestState, Function0<? extends Unit> function0) {
                Function0<? extends Unit> onReqSuccess = function0;
                RequestState it = requestState;
                return RequestState.copy$default(it, null, null, onReqSuccess, null, 11, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super Function0<? extends Unit>, ? extends Function0<? extends Unit>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                Function0 onReqSuccess = (Function0) function1.invoke(it.getOnReqSuccess());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, null, null, onReqSuccess, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<RequestState, RequestParam> getParam(RequestState.Companion $this$param) {
        Intrinsics.checkNotNullParameter($this$param, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestParam>() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestStateLensKt$special$$inlined$invoke$5
            public RequestParam get(RequestState requestState) {
                RequestState it = requestState;
                return it.getParam();
            }

            public RequestState set(RequestState requestState, RequestParam requestParam) {
                RequestParam param = requestParam;
                RequestState it = requestState;
                return RequestState.copy$default(it, null, null, null, param, 7, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestParam, ? extends RequestParam> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                RequestParam param = (RequestParam) function1.invoke(it.getParam());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, null, null, null, param, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, RequestStatus> getState(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getState(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestFrom> getFrom(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getFrom(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, Function0<Unit>> getOnReqSuccess(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOnReqSuccess(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> getParam(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getParam(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> stateNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getState(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestFrom> fromNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getFrom(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, Function0<Unit>> onReqSuccessNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOnReqSuccess(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> paramNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getParam(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getState(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getState(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestFrom> getFrom(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getFrom(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, Function0<Unit>> getOnReqSuccess(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOnReqSuccess(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> getParam(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getParam(RequestState.Companion));
    }
}