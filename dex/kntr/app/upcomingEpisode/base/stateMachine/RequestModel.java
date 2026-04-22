package kntr.app.upcomingEpisode.base.stateMachine;

import com.bilibili.blens.Lens;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcomingEpisodeData.kt */
@Lens
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel;", "", "delCalendarCardReqState", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;", "watchCalendarReqState", "reserveCardReqState", "cancelReserveCardReqState", "<init>", "(Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;)V", "getDelCalendarCardReqState", "()Lkntr/app/upcomingEpisode/base/stateMachine/RequestState;", "getWatchCalendarReqState", "getReserveCardReqState", "getCancelReserveCardReqState", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RequestModel {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final RequestState cancelReserveCardReqState;
    private final RequestState delCalendarCardReqState;
    private final RequestState reserveCardReqState;
    private final RequestState watchCalendarReqState;

    public RequestModel() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ RequestModel copy$default(RequestModel requestModel, RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4, int i, Object obj) {
        if ((i & 1) != 0) {
            requestState = requestModel.delCalendarCardReqState;
        }
        if ((i & 2) != 0) {
            requestState2 = requestModel.watchCalendarReqState;
        }
        if ((i & 4) != 0) {
            requestState3 = requestModel.reserveCardReqState;
        }
        if ((i & 8) != 0) {
            requestState4 = requestModel.cancelReserveCardReqState;
        }
        return requestModel.copy(requestState, requestState2, requestState3, requestState4);
    }

    public final RequestState component1() {
        return this.delCalendarCardReqState;
    }

    public final RequestState component2() {
        return this.watchCalendarReqState;
    }

    public final RequestState component3() {
        return this.reserveCardReqState;
    }

    public final RequestState component4() {
        return this.cancelReserveCardReqState;
    }

    public final RequestModel copy(RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4) {
        Intrinsics.checkNotNullParameter(requestState, "delCalendarCardReqState");
        Intrinsics.checkNotNullParameter(requestState2, "watchCalendarReqState");
        Intrinsics.checkNotNullParameter(requestState3, "reserveCardReqState");
        Intrinsics.checkNotNullParameter(requestState4, "cancelReserveCardReqState");
        return new RequestModel(requestState, requestState2, requestState3, requestState4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestModel) {
            RequestModel requestModel = (RequestModel) obj;
            return Intrinsics.areEqual(this.delCalendarCardReqState, requestModel.delCalendarCardReqState) && Intrinsics.areEqual(this.watchCalendarReqState, requestModel.watchCalendarReqState) && Intrinsics.areEqual(this.reserveCardReqState, requestModel.reserveCardReqState) && Intrinsics.areEqual(this.cancelReserveCardReqState, requestModel.cancelReserveCardReqState);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.delCalendarCardReqState.hashCode() * 31) + this.watchCalendarReqState.hashCode()) * 31) + this.reserveCardReqState.hashCode()) * 31) + this.cancelReserveCardReqState.hashCode();
    }

    public String toString() {
        RequestState requestState = this.delCalendarCardReqState;
        RequestState requestState2 = this.watchCalendarReqState;
        RequestState requestState3 = this.reserveCardReqState;
        return "RequestModel(delCalendarCardReqState=" + requestState + ", watchCalendarReqState=" + requestState2 + ", reserveCardReqState=" + requestState3 + ", cancelReserveCardReqState=" + this.cancelReserveCardReqState + ")";
    }

    public RequestModel(RequestState delCalendarCardReqState, RequestState watchCalendarReqState, RequestState reserveCardReqState, RequestState cancelReserveCardReqState) {
        Intrinsics.checkNotNullParameter(delCalendarCardReqState, "delCalendarCardReqState");
        Intrinsics.checkNotNullParameter(watchCalendarReqState, "watchCalendarReqState");
        Intrinsics.checkNotNullParameter(reserveCardReqState, "reserveCardReqState");
        Intrinsics.checkNotNullParameter(cancelReserveCardReqState, "cancelReserveCardReqState");
        this.delCalendarCardReqState = delCalendarCardReqState;
        this.watchCalendarReqState = watchCalendarReqState;
        this.reserveCardReqState = reserveCardReqState;
        this.cancelReserveCardReqState = cancelReserveCardReqState;
    }

    public /* synthetic */ RequestModel(RequestState requestState, RequestState requestState2, RequestState requestState3, RequestState requestState4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new RequestState(null, null, null, null, 15, null) : requestState, (i & 2) != 0 ? new RequestState(null, null, null, null, 15, null) : requestState2, (i & 4) != 0 ? new RequestState(null, null, null, null, 15, null) : requestState3, (i & 8) != 0 ? new RequestState(null, null, null, null, 15, null) : requestState4);
    }

    public final RequestState getDelCalendarCardReqState() {
        return this.delCalendarCardReqState;
    }

    public final RequestState getWatchCalendarReqState() {
        return this.watchCalendarReqState;
    }

    public final RequestState getReserveCardReqState() {
        return this.reserveCardReqState;
    }

    public final RequestState getCancelReserveCardReqState() {
        return this.cancelReserveCardReqState;
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestModel$Companion;", "", "<init>", "()V", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}