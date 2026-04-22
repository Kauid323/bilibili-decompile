package kntr.app.deepsearch.base.model.biz;

import com.bilibili.blens.Lens;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.deepsearch.base.model.biz.RequestStatus;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestModel.kt */
@Lens
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestState;", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, "Lkntr/app/deepsearch/base/model/biz/RequestStatus;", "param", "Lkntr/app/deepsearch/base/model/biz/RequestParam;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/RequestStatus;Lkntr/app/deepsearch/base/model/biz/RequestParam;)V", "getStatus", "()Lkntr/app/deepsearch/base/model/biz/RequestStatus;", "getParam", "()Lkntr/app/deepsearch/base/model/biz/RequestParam;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestState {
    public static final Companion Companion = new Companion(null);
    private final RequestParam param;
    private final RequestStatus status;

    public RequestState() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ RequestState copy$default(RequestState requestState, RequestStatus requestStatus, RequestParam requestParam, int i, Object obj) {
        if ((i & 1) != 0) {
            requestStatus = requestState.status;
        }
        if ((i & 2) != 0) {
            requestParam = requestState.param;
        }
        return requestState.copy(requestStatus, requestParam);
    }

    public final RequestStatus component1() {
        return this.status;
    }

    public final RequestParam component2() {
        return this.param;
    }

    public final RequestState copy(RequestStatus requestStatus, RequestParam requestParam) {
        Intrinsics.checkNotNullParameter(requestStatus, AdAlarmExtraKey.STATUS);
        return new RequestState(requestStatus, requestParam);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RequestState) {
            RequestState requestState = (RequestState) obj;
            return Intrinsics.areEqual(this.status, requestState.status) && Intrinsics.areEqual(this.param, requestState.param);
        }
        return false;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + (this.param == null ? 0 : this.param.hashCode());
    }

    public String toString() {
        RequestStatus requestStatus = this.status;
        return "RequestState(status=" + requestStatus + ", param=" + this.param + ")";
    }

    public RequestState(RequestStatus status, RequestParam param) {
        Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
        this.status = status;
        this.param = param;
    }

    public /* synthetic */ RequestState(RequestStatus.Idle idle, RequestParam requestParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RequestStatus.Idle.INSTANCE : idle, (i & 2) != 0 ? null : requestParam);
    }

    public final RequestStatus getStatus() {
        return this.status;
    }

    public final RequestParam getParam() {
        return this.param;
    }

    /* compiled from: RequestModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/RequestState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}