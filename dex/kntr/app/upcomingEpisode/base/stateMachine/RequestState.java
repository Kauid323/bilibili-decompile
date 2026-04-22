package kntr.app.upcomingEpisode.base.stateMachine;

import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.base.stateMachine.RequestFrom;
import kntr.app.upcomingEpisode.base.stateMachine.RequestStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeData.kt */
@Lens
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001!B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;", "", "state", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;", "from", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "onReqSuccess", "Lkotlin/Function0;", "", "param", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "<init>", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;Lkotlin/jvm/functions/Function0;Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;)V", "getState", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestStatus;", "getFrom", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "getOnReqSuccess", "()Lkotlin/jvm/functions/Function0;", "getParam", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestParam;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RequestState {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final RequestFrom from;
    private final Function0<Unit> onReqSuccess;
    private final RequestParam param;
    private final RequestStatus state;

    public RequestState() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RequestState copy$default(RequestState requestState, RequestStatus requestStatus, RequestFrom requestFrom, Function0 function0, RequestParam requestParam, int i, Object obj) {
        if ((i & 1) != 0) {
            requestStatus = requestState.state;
        }
        if ((i & 2) != 0) {
            requestFrom = requestState.from;
        }
        if ((i & 4) != 0) {
            function0 = requestState.onReqSuccess;
        }
        if ((i & 8) != 0) {
            requestParam = requestState.param;
        }
        return requestState.copy(requestStatus, requestFrom, function0, requestParam);
    }

    public final RequestStatus component1() {
        return this.state;
    }

    public final RequestFrom component2() {
        return this.from;
    }

    public final Function0<Unit> component3() {
        return this.onReqSuccess;
    }

    public final RequestParam component4() {
        return this.param;
    }

    public final RequestState copy(RequestStatus requestStatus, RequestFrom requestFrom, Function0<Unit> function0, RequestParam requestParam) {
        Intrinsics.checkNotNullParameter(requestStatus, "state");
        Intrinsics.checkNotNullParameter(requestFrom, "from");
        Intrinsics.checkNotNullParameter(function0, "onReqSuccess");
        return new RequestState(requestStatus, requestFrom, function0, requestParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestState) {
            RequestState requestState = (RequestState) obj;
            return Intrinsics.areEqual(this.state, requestState.state) && Intrinsics.areEqual(this.from, requestState.from) && Intrinsics.areEqual(this.onReqSuccess, requestState.onReqSuccess) && Intrinsics.areEqual(this.param, requestState.param);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.state.hashCode() * 31) + this.from.hashCode()) * 31) + this.onReqSuccess.hashCode()) * 31) + (this.param == null ? 0 : this.param.hashCode());
    }

    public String toString() {
        RequestStatus requestStatus = this.state;
        RequestFrom requestFrom = this.from;
        Function0<Unit> function0 = this.onReqSuccess;
        return "RequestState(state=" + requestStatus + ", from=" + requestFrom + ", onReqSuccess=" + function0 + ", param=" + this.param + ")";
    }

    public RequestState(RequestStatus state, RequestFrom from, Function0<Unit> function0, RequestParam param) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(function0, "onReqSuccess");
        this.state = state;
        this.from = from;
        this.onReqSuccess = function0;
        this.param = param;
    }

    public /* synthetic */ RequestState(RequestStatus.Idle idle, RequestFrom.Default r2, Function0 function0, RequestParam requestParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RequestStatus.Idle.INSTANCE : idle, (i & 2) != 0 ? RequestFrom.Default.INSTANCE : r2, (i & 4) != 0 ? new Function0() { // from class: kntr.app.upcomingEpisode.base.stateMachine.RequestState$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        } : function0, (i & 8) != 0 ? null : requestParam);
    }

    public final RequestStatus getState() {
        return this.state;
    }

    public final RequestFrom getFrom() {
        return this.from;
    }

    public final Function0<Unit> getOnReqSuccess() {
        return this.onReqSuccess;
    }

    public final RequestParam getParam() {
        return this.param;
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestState$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}