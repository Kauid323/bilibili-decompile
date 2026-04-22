package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.deepsearch.base.model.biz.RequestState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestStateLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/deepsearch/base/model/biz/RequestState;", "Lkntr/app/deepsearch/base/model/biz/RequestState$Companion;", "getLens$annotations", "(Lkntr/app/deepsearch/base/model/biz/RequestState$Companion;)V", "getLens", "(Lkntr/app/deepsearch/base/model/biz/RequestState$Companion;)Lcom/bilibili/blens/BSimpleLens;", AdAlarmExtraKey.STATUS, "Lkntr/app/deepsearch/base/model/biz/RequestStatus;", "getStatus$annotations", "getStatus", "param", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "getParam$annotations", "getParam", "T", RoomRecommendViewModel.EMPTY_CURSOR, "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "paramNullable$annotations", "paramNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RequestStateLensKt {
    public static /* synthetic */ void getLens$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getParam$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getParam$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getParam$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(RequestState.Companion companion) {
    }

    public static /* synthetic */ void paramNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<RequestState, RequestState> getLens(RequestState.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestState>() { // from class: kntr.app.deepsearch.base.model.biz.RequestStateLensKt$special$$inlined$invoke$1
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

    public static final BSimpleLens<RequestState, RequestStatus> getStatus(RequestState.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestStatus>() { // from class: kntr.app.deepsearch.base.model.biz.RequestStateLensKt$special$$inlined$invoke$2
            public RequestStatus get(RequestState requestState) {
                RequestState it = requestState;
                return it.getStatus();
            }

            public RequestState set(RequestState requestState, RequestStatus requestStatus) {
                RequestStatus status = requestStatus;
                RequestState it = requestState;
                return RequestState.copy$default(it, status, null, 2, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestStatus, ? extends RequestStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                RequestStatus status = (RequestStatus) function1.invoke(it.getStatus());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, status, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<RequestState, RequestParam> getParam(RequestState.Companion $this$param) {
        Intrinsics.checkNotNullParameter($this$param, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<RequestState, RequestParam>() { // from class: kntr.app.deepsearch.base.model.biz.RequestStateLensKt$special$$inlined$invoke$3
            public RequestParam get(RequestState requestState) {
                RequestState it = requestState;
                return it.getParam();
            }

            public RequestState set(RequestState requestState, RequestParam requestParam) {
                RequestParam param = requestParam;
                RequestState it = requestState;
                return RequestState.copy$default(it, null, param, 1, null);
            }

            public RequestState modify(RequestState requestState, Function1<? super RequestParam, ? extends RequestParam> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                RequestState it = requestState;
                RequestParam param = (RequestParam) function1.invoke(it.getParam());
                RequestState it2 = requestState;
                return RequestState.copy$default(it2, null, param, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, RequestStatus> getStatus(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> getParam(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getParam(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> statusNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> paramNullable(BSimpleLens<T, RequestState> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getParam(RequestState.Companion));
    }

    public static final <T> BNullableLens<T, RequestStatus> getStatus(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(RequestState.Companion));
    }

    public static final <T> BSimpleLens<T, RequestParam> getParam(BNullableLens<T, RequestState> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getParam(RequestState.Companion));
    }
}