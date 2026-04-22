package kntr.app.ad.ui.inspector.ui.main.request.viewmodel;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.domain.inspector.core.work.RequestType;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: RequestListViewModelMVI.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J:\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J0\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100*H\u0002J\u0006\u0010+\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$ViewState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "requests", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "processIntent", RoomRecommendViewModel.EMPTY_CURSOR, "intent", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", "loadRequests", "selectStatus", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "selectType", "type", "Lkntr/app/ad/domain/inspector/core/work/RequestType;", "selectSlot", "slot", "Lkntr/app/ad/common/model/AdSlot;", "clearFilters", "updateWithStatusFilter", "newStatus", "updateFilteredRequests", "applyAllFilters", "applyNonStatusFilters", "calculateStats", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getAllRequestJobDataFlow", "Lkotlinx/coroutines/flow/Flow;", "onCleared", "ViewState", "Intent", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RequestListViewModelMVI {
    public static final int $stable = 8;
    private Job loadJob;
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final MutableStateFlow<ViewState> _state = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, null, null, null, 255, null));
    private final StateFlow<ViewState> state = this._state;
    private final MutableStateFlow<List<RequestJobData>> requests = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public RequestListViewModelMVI() {
        loadRequests();
    }

    /* compiled from: RequestListViewModelMVI.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0015\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0012HÆ\u0003Jy\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0010HÖ\u0001J\t\u0010/\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$ViewState;", RoomRecommendViewModel.EMPTY_CURSOR, "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, "requests", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "filteredRequests", "selectedStatus", "Lkntr/app/ad/domain/inspector/model/Status;", "selectedType", "Lkntr/app/ad/domain/inspector/core/work/RequestType;", "selectedSlot", "Lkntr/app/ad/common/model/AdSlot;", "statsCount", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "errorMessage", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ZLjava/util/List;Ljava/util/List;Lkntr/app/ad/domain/inspector/model/Status;Lkntr/app/ad/domain/inspector/core/work/RequestType;Lkntr/app/ad/common/model/AdSlot;Ljava/util/Map;Ljava/lang/String;)V", "()Z", "getRequests", "()Ljava/util/List;", "getFilteredRequests", "getSelectedStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "getSelectedType", "()Lkntr/app/ad/domain/inspector/core/work/RequestType;", "getSelectedSlot", "()Lkntr/app/ad/common/model/AdSlot;", "getStatsCount", "()Ljava/util/Map;", "getErrorMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ViewState {
        public static final int $stable = 8;
        private final String errorMessage;
        private final List<RequestJobData> filteredRequests;
        private final boolean isLoading;
        private final List<RequestJobData> requests;
        private final AdSlot selectedSlot;
        private final Status selectedStatus;
        private final RequestType selectedType;
        private final Map<Object, Integer> statsCount;

        public ViewState() {
            this(false, null, null, null, null, null, null, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, List list, List list2, Status status, RequestType requestType, AdSlot adSlot, Map map, String str, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.isLoading : z, (i & 2) != 0 ? viewState.requests : list, (i & 4) != 0 ? viewState.filteredRequests : list2, (i & 8) != 0 ? viewState.selectedStatus : status, (i & 16) != 0 ? viewState.selectedType : requestType, (i & 32) != 0 ? viewState.selectedSlot : adSlot, (i & 64) != 0 ? viewState.statsCount : map, (i & 128) != 0 ? viewState.errorMessage : str);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final List<RequestJobData> component2() {
            return this.requests;
        }

        public final List<RequestJobData> component3() {
            return this.filteredRequests;
        }

        public final Status component4() {
            return this.selectedStatus;
        }

        public final RequestType component5() {
            return this.selectedType;
        }

        public final AdSlot component6() {
            return this.selectedSlot;
        }

        public final Map<Object, Integer> component7() {
            return this.statsCount;
        }

        public final String component8() {
            return this.errorMessage;
        }

        public final ViewState copy(boolean z, List<RequestJobData> list, List<RequestJobData> list2, Status status, RequestType requestType, AdSlot adSlot, Map<Object, Integer> map, String str) {
            Intrinsics.checkNotNullParameter(list, "requests");
            Intrinsics.checkNotNullParameter(list2, "filteredRequests");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            return new ViewState(z, list, list2, status, requestType, adSlot, map, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewState) {
                ViewState viewState = (ViewState) obj;
                return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.requests, viewState.requests) && Intrinsics.areEqual(this.filteredRequests, viewState.filteredRequests) && this.selectedStatus == viewState.selectedStatus && this.selectedType == viewState.selectedType && this.selectedSlot == viewState.selectedSlot && Intrinsics.areEqual(this.statsCount, viewState.statsCount) && Intrinsics.areEqual(this.errorMessage, viewState.errorMessage);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + this.requests.hashCode()) * 31) + this.filteredRequests.hashCode()) * 31) + (this.selectedStatus == null ? 0 : this.selectedStatus.hashCode())) * 31) + (this.selectedType == null ? 0 : this.selectedType.hashCode())) * 31) + (this.selectedSlot == null ? 0 : this.selectedSlot.hashCode())) * 31) + this.statsCount.hashCode()) * 31) + (this.errorMessage != null ? this.errorMessage.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isLoading;
            List<RequestJobData> list = this.requests;
            List<RequestJobData> list2 = this.filteredRequests;
            Status status = this.selectedStatus;
            RequestType requestType = this.selectedType;
            AdSlot adSlot = this.selectedSlot;
            Map<Object, Integer> map = this.statsCount;
            return "ViewState(isLoading=" + z + ", requests=" + list + ", filteredRequests=" + list2 + ", selectedStatus=" + status + ", selectedType=" + requestType + ", selectedSlot=" + adSlot + ", statsCount=" + map + ", errorMessage=" + this.errorMessage + ")";
        }

        public ViewState(boolean isLoading, List<RequestJobData> list, List<RequestJobData> list2, Status selectedStatus, RequestType selectedType, AdSlot selectedSlot, Map<Object, Integer> map, String errorMessage) {
            Intrinsics.checkNotNullParameter(list, "requests");
            Intrinsics.checkNotNullParameter(list2, "filteredRequests");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            this.isLoading = isLoading;
            this.requests = list;
            this.filteredRequests = list2;
            this.selectedStatus = selectedStatus;
            this.selectedType = selectedType;
            this.selectedSlot = selectedSlot;
            this.statsCount = map;
            this.errorMessage = errorMessage;
        }

        public /* synthetic */ ViewState(boolean z, List list, List list2, Status status, RequestType requestType, AdSlot adSlot, Map map, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : status, (i & 16) != 0 ? null : requestType, (i & 32) != 0 ? null : adSlot, (i & 64) != 0 ? MapsKt.emptyMap() : map, (i & 128) == 0 ? str : null);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final List<RequestJobData> getRequests() {
            return this.requests;
        }

        public final List<RequestJobData> getFilteredRequests() {
            return this.filteredRequests;
        }

        public final Status getSelectedStatus() {
            return this.selectedStatus;
        }

        public final RequestType getSelectedType() {
            return this.selectedType;
        }

        public final AdSlot getSelectedSlot() {
            return this.selectedSlot;
        }

        public final Map<Object, Integer> getStatsCount() {
            return this.statsCount;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public final StateFlow<ViewState> getState() {
        return this.state;
    }

    /* compiled from: RequestListViewModelMVI.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadRequests", "SelectStatus", "SelectType", "SelectSlot", "ClearFilters", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$LoadRequests;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectSlot;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectStatus;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectType;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class Intent {
        public static final int $stable = 0;

        public /* synthetic */ Intent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: RequestListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$LoadRequests;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadRequests extends Intent {
            public static final int $stable = 0;
            public static final LoadRequests INSTANCE = new LoadRequests();

            private LoadRequests() {
                super(null);
            }
        }

        private Intent() {
        }

        /* compiled from: RequestListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectStatus;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "<init>", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectStatus extends Intent {
            public static final int $stable = 0;
            private final Status status;

            public static /* synthetic */ SelectStatus copy$default(SelectStatus selectStatus, Status status, int i, Object obj) {
                if ((i & 1) != 0) {
                    status = selectStatus.status;
                }
                return selectStatus.copy(status);
            }

            public final Status component1() {
                return this.status;
            }

            public final SelectStatus copy(Status status) {
                return new SelectStatus(status);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectStatus) && this.status == ((SelectStatus) obj).status;
            }

            public int hashCode() {
                if (this.status == null) {
                    return 0;
                }
                return this.status.hashCode();
            }

            public String toString() {
                return "SelectStatus(status=" + this.status + ")";
            }

            public SelectStatus(Status status) {
                super(null);
                this.status = status;
            }

            public final Status getStatus() {
                return this.status;
            }
        }

        /* compiled from: RequestListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectType;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", "type", "Lkntr/app/ad/domain/inspector/core/work/RequestType;", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/RequestType;)V", "getType", "()Lkntr/app/ad/domain/inspector/core/work/RequestType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectType extends Intent {
            public static final int $stable = 0;
            private final RequestType type;

            public static /* synthetic */ SelectType copy$default(SelectType selectType, RequestType requestType, int i, Object obj) {
                if ((i & 1) != 0) {
                    requestType = selectType.type;
                }
                return selectType.copy(requestType);
            }

            public final RequestType component1() {
                return this.type;
            }

            public final SelectType copy(RequestType requestType) {
                return new SelectType(requestType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectType) && this.type == ((SelectType) obj).type;
            }

            public int hashCode() {
                if (this.type == null) {
                    return 0;
                }
                return this.type.hashCode();
            }

            public String toString() {
                return "SelectType(type=" + this.type + ")";
            }

            public SelectType(RequestType type) {
                super(null);
                this.type = type;
            }

            public final RequestType getType() {
                return this.type;
            }
        }

        /* compiled from: RequestListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$SelectSlot;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "<init>", "(Lkntr/app/ad/common/model/AdSlot;)V", "getSlot", "()Lkntr/app/ad/common/model/AdSlot;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectSlot extends Intent {
            public static final int $stable = 0;
            private final AdSlot slot;

            public static /* synthetic */ SelectSlot copy$default(SelectSlot selectSlot, AdSlot adSlot, int i, Object obj) {
                if ((i & 1) != 0) {
                    adSlot = selectSlot.slot;
                }
                return selectSlot.copy(adSlot);
            }

            public final AdSlot component1() {
                return this.slot;
            }

            public final SelectSlot copy(AdSlot adSlot) {
                return new SelectSlot(adSlot);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectSlot) && this.slot == ((SelectSlot) obj).slot;
            }

            public int hashCode() {
                if (this.slot == null) {
                    return 0;
                }
                return this.slot.hashCode();
            }

            public String toString() {
                return "SelectSlot(slot=" + this.slot + ")";
            }

            public SelectSlot(AdSlot slot) {
                super(null);
                this.slot = slot;
            }

            public final AdSlot getSlot() {
                return this.slot;
            }
        }

        /* compiled from: RequestListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/request/viewmodel/RequestListViewModelMVI$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ClearFilters extends Intent {
            public static final int $stable = 0;
            public static final ClearFilters INSTANCE = new ClearFilters();

            private ClearFilters() {
                super(null);
            }
        }
    }

    public final void processIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!(intent instanceof Intent.LoadRequests)) {
            if (!(intent instanceof Intent.SelectStatus)) {
                if (!(intent instanceof Intent.SelectType)) {
                    if (!(intent instanceof Intent.SelectSlot)) {
                        if (!(intent instanceof Intent.ClearFilters)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        clearFilters();
                        return;
                    }
                    selectSlot(((Intent.SelectSlot) intent).getSlot());
                    return;
                }
                selectType(((Intent.SelectType) intent).getType());
                return;
            }
            selectStatus(((Intent.SelectStatus) intent).getStatus());
            return;
        }
        loadRequests();
    }

    private final void loadRequests() {
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), true, null, null, null, null, null, null, null, 254, null));
        try {
            this.loadJob = BuildersKt.launch$default(this.viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new RequestListViewModelMVI$loadRequests$1(this, null), 3, (Object) null);
        } catch (Exception e) {
            this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, null, "加载失败: " + e.getMessage(), 126, null));
        }
    }

    private final void selectStatus(Status status) {
        Status newStatus = ((ViewState) this._state.getValue()).getSelectedStatus() == status ? null : status;
        updateWithStatusFilter(newStatus);
    }

    private final void selectType(RequestType type) {
        RequestType newType = ((ViewState) this._state.getValue()).getSelectedType() == type ? null : type;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, newType, null, null, null, 239, null));
        updateFilteredRequests();
    }

    private final void selectSlot(AdSlot slot) {
        AdSlot newSlot = ((ViewState) this._state.getValue()).getSelectedSlot() == slot ? null : slot;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, newSlot, null, null, 223, null));
        updateFilteredRequests();
    }

    private final void clearFilters() {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, null, null, 199, null));
        updateFilteredRequests();
    }

    private final void updateWithStatusFilter(Status newStatus) {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredRequests = applyAllFilters((List) this.requests.getValue(), newStatus, currentState.getSelectedType(), currentState.getSelectedSlot());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredRequests, newStatus, null, null, null, null, 243, null));
    }

    private final void updateFilteredRequests() {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredForStats = applyNonStatusFilters((List) this.requests.getValue(), currentState.getSelectedType(), currentState.getSelectedSlot());
        Map counts = calculateStats(filteredForStats);
        List filteredRequests = applyAllFilters((List) this.requests.getValue(), currentState.getSelectedStatus(), currentState.getSelectedType(), currentState.getSelectedSlot());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredRequests, null, null, null, counts, null, 187, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RequestJobData> applyAllFilters(List<RequestJobData> list, Status status, RequestType type, AdSlot slot) {
        List<RequestJobData> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            RequestJobData jobData = (RequestJobData) element$iv$iv;
            if ((status == null || jobData.getStatus() == status) && (type == null || jobData.getType() == type) && (slot == null || jobData.getSlot() == slot)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RequestJobData> applyNonStatusFilters(List<RequestJobData> list, RequestType type, AdSlot slot) {
        List<RequestJobData> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            RequestJobData jobData = (RequestJobData) element$iv$iv;
            if ((type == null || jobData.getType() == type) && (slot == null || jobData.getSlot() == slot)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Integer> calculateStats(List<RequestJobData> list) {
        Map result = new LinkedHashMap();
        for (Status status : Status.values()) {
            result.put(status, 0);
        }
        List<RequestJobData> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            RequestJobData request = (RequestJobData) element$iv;
            Status status2 = request.getStatus();
            Integer num = (Integer) result.get(status2);
            result.put(status2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<RequestJobData>> getAllRequestJobDataFlow() {
        try {
            return StateManager.INSTANCE.getRequestJobDataListFlow();
        } catch (Exception e) {
            return FlowKt.emptyFlow();
        }
    }

    public final void onCleared() {
        CoroutineScopeKt.cancel$default(this.viewModelScope, (CancellationException) null, 1, (Object) null);
    }
}