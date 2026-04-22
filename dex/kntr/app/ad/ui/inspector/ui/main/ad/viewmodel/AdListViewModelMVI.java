package kntr.app.ad.ui.inspector.ui.main.ad.viewmodel;

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
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
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

/* compiled from: AdListViewModelMVI.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u0013H\u0002J\u0012\u0010!\u001a\u00020\u00132\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010#\u001a\u00020\u0013H\u0002J8\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J.\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(0'2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100*H\u0002J\u0006\u0010+\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$ViewState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "inspectors", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "processIntent", RoomRecommendViewModel.EMPTY_CURSOR, "intent", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", "loadInspectors", "selectStatus", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "selectSlot", "slot", "Lkntr/app/ad/common/model/AdSlot;", "search", "query", RoomRecommendViewModel.EMPTY_CURSOR, "clearFilters", "updateWithStatusFilter", "newStatus", "updateFilteredInspectors", "applyAllFilters", "applyNonStatusFilters", "calculateStats", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getAllInspectorsFlow", "Lkotlinx/coroutines/flow/Flow;", "onCleared", "ViewState", "Intent", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AdListViewModelMVI {
    public static final int $stable = 8;
    private Job loadJob;
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final MutableStateFlow<ViewState> _state = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, null, null, null, 255, null));
    private final StateFlow<ViewState> state = this._state;
    private final MutableStateFlow<List<InspectorInfo>> inspectors = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public AdListViewModelMVI() {
        loadInspectors();
    }

    /* compiled from: AdListViewModelMVI.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u0015\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003Jw\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010*\u001a\u00020\u00032\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0010HÖ\u0001J\t\u0010-\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001d¨\u0006."}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$ViewState;", RoomRecommendViewModel.EMPTY_CURSOR, "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, "inspectors", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "filteredInspectors", "selectedStatus", "Lkntr/app/ad/domain/inspector/model/Status;", "selectedSlot", "Lkntr/app/ad/common/model/AdSlot;", "searchText", RoomRecommendViewModel.EMPTY_CURSOR, "statsCount", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "errorMessage", "<init>", "(ZLjava/util/List;Ljava/util/List;Lkntr/app/ad/domain/inspector/model/Status;Lkntr/app/ad/common/model/AdSlot;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "()Z", "getInspectors", "()Ljava/util/List;", "getFilteredInspectors", "getSelectedStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "getSelectedSlot", "()Lkntr/app/ad/common/model/AdSlot;", "getSearchText", "()Ljava/lang/String;", "getStatsCount", "()Ljava/util/Map;", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ViewState {
        public static final int $stable = 8;
        private final String errorMessage;
        private final List<InspectorInfo> filteredInspectors;
        private final List<InspectorInfo> inspectors;
        private final boolean isLoading;
        private final String searchText;
        private final AdSlot selectedSlot;
        private final Status selectedStatus;
        private final Map<Object, Integer> statsCount;

        public ViewState() {
            this(false, null, null, null, null, null, null, null, 255, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, List list, List list2, Status status, AdSlot adSlot, String str, Map map, String str2, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.isLoading : z, (i & 2) != 0 ? viewState.inspectors : list, (i & 4) != 0 ? viewState.filteredInspectors : list2, (i & 8) != 0 ? viewState.selectedStatus : status, (i & 16) != 0 ? viewState.selectedSlot : adSlot, (i & 32) != 0 ? viewState.searchText : str, (i & 64) != 0 ? viewState.statsCount : map, (i & 128) != 0 ? viewState.errorMessage : str2);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final List<InspectorInfo> component2() {
            return this.inspectors;
        }

        public final List<InspectorInfo> component3() {
            return this.filteredInspectors;
        }

        public final Status component4() {
            return this.selectedStatus;
        }

        public final AdSlot component5() {
            return this.selectedSlot;
        }

        public final String component6() {
            return this.searchText;
        }

        public final Map<Object, Integer> component7() {
            return this.statsCount;
        }

        public final String component8() {
            return this.errorMessage;
        }

        public final ViewState copy(boolean z, List<InspectorInfo> list, List<InspectorInfo> list2, Status status, AdSlot adSlot, String str, Map<Object, Integer> map, String str2) {
            Intrinsics.checkNotNullParameter(list, "inspectors");
            Intrinsics.checkNotNullParameter(list2, "filteredInspectors");
            Intrinsics.checkNotNullParameter(str, "searchText");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            return new ViewState(z, list, list2, status, adSlot, str, map, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewState) {
                ViewState viewState = (ViewState) obj;
                return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.inspectors, viewState.inspectors) && Intrinsics.areEqual(this.filteredInspectors, viewState.filteredInspectors) && this.selectedStatus == viewState.selectedStatus && this.selectedSlot == viewState.selectedSlot && Intrinsics.areEqual(this.searchText, viewState.searchText) && Intrinsics.areEqual(this.statsCount, viewState.statsCount) && Intrinsics.areEqual(this.errorMessage, viewState.errorMessage);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + this.inspectors.hashCode()) * 31) + this.filteredInspectors.hashCode()) * 31) + (this.selectedStatus == null ? 0 : this.selectedStatus.hashCode())) * 31) + (this.selectedSlot == null ? 0 : this.selectedSlot.hashCode())) * 31) + this.searchText.hashCode()) * 31) + this.statsCount.hashCode()) * 31) + (this.errorMessage != null ? this.errorMessage.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isLoading;
            List<InspectorInfo> list = this.inspectors;
            List<InspectorInfo> list2 = this.filteredInspectors;
            Status status = this.selectedStatus;
            AdSlot adSlot = this.selectedSlot;
            String str = this.searchText;
            Map<Object, Integer> map = this.statsCount;
            return "ViewState(isLoading=" + z + ", inspectors=" + list + ", filteredInspectors=" + list2 + ", selectedStatus=" + status + ", selectedSlot=" + adSlot + ", searchText=" + str + ", statsCount=" + map + ", errorMessage=" + this.errorMessage + ")";
        }

        public ViewState(boolean isLoading, List<InspectorInfo> list, List<InspectorInfo> list2, Status selectedStatus, AdSlot selectedSlot, String searchText, Map<Object, Integer> map, String errorMessage) {
            Intrinsics.checkNotNullParameter(list, "inspectors");
            Intrinsics.checkNotNullParameter(list2, "filteredInspectors");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            this.isLoading = isLoading;
            this.inspectors = list;
            this.filteredInspectors = list2;
            this.selectedStatus = selectedStatus;
            this.selectedSlot = selectedSlot;
            this.searchText = searchText;
            this.statsCount = map;
            this.errorMessage = errorMessage;
        }

        public /* synthetic */ ViewState(boolean z, List list, List list2, Status status, AdSlot adSlot, String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : status, (i & 16) != 0 ? null : adSlot, (i & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 64) != 0 ? MapsKt.emptyMap() : map, (i & 128) == 0 ? str2 : null);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final List<InspectorInfo> getInspectors() {
            return this.inspectors;
        }

        public final List<InspectorInfo> getFilteredInspectors() {
            return this.filteredInspectors;
        }

        public final Status getSelectedStatus() {
            return this.selectedStatus;
        }

        public final AdSlot getSelectedSlot() {
            return this.selectedSlot;
        }

        public final String getSearchText() {
            return this.searchText;
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

    /* compiled from: AdListViewModelMVI.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadInspectors", "SelectStatus", "SelectSlot", "Search", "ClearFilters", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$LoadInspectors;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$Search;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$SelectSlot;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$SelectStatus;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class Intent {
        public static final int $stable = 0;

        public /* synthetic */ Intent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: AdListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$LoadInspectors;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadInspectors extends Intent {
            public static final int $stable = 0;
            public static final LoadInspectors INSTANCE = new LoadInspectors();

            private LoadInspectors() {
                super(null);
            }
        }

        private Intent() {
        }

        /* compiled from: AdListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$SelectStatus;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "<init>", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* compiled from: AdListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$SelectSlot;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", "slot", "Lkntr/app/ad/common/model/AdSlot;", "<init>", "(Lkntr/app/ad/common/model/AdSlot;)V", "getSlot", "()Lkntr/app/ad/common/model/AdSlot;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* compiled from: AdListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$Search;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class Search extends Intent {
            public static final int $stable = 0;
            private final String query;

            public static /* synthetic */ Search copy$default(Search search, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = search.query;
                }
                return search.copy(str);
            }

            public final String component1() {
                return this.query;
            }

            public final Search copy(String str) {
                Intrinsics.checkNotNullParameter(str, "query");
                return new Search(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Search) && Intrinsics.areEqual(this.query, ((Search) obj).query);
            }

            public int hashCode() {
                return this.query.hashCode();
            }

            public String toString() {
                return "Search(query=" + this.query + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Search(String query) {
                super(null);
                Intrinsics.checkNotNullParameter(query, "query");
                this.query = query;
            }

            public final String getQuery() {
                return this.query;
            }
        }

        /* compiled from: AdListViewModelMVI.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/ad/viewmodel/AdListViewModelMVI$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
        if (!(intent instanceof Intent.LoadInspectors)) {
            if (!(intent instanceof Intent.SelectStatus)) {
                if (!(intent instanceof Intent.SelectSlot)) {
                    if (!(intent instanceof Intent.Search)) {
                        if (!(intent instanceof Intent.ClearFilters)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        clearFilters();
                        return;
                    }
                    search(((Intent.Search) intent).getQuery());
                    return;
                }
                selectSlot(((Intent.SelectSlot) intent).getSlot());
                return;
            }
            selectStatus(((Intent.SelectStatus) intent).getStatus());
            return;
        }
        loadInspectors();
    }

    private final void loadInspectors() {
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), true, null, null, null, null, null, null, null, 254, null));
        try {
            this.loadJob = BuildersKt.launch$default(this.viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new AdListViewModelMVI$loadInspectors$1(this, null), 3, (Object) null);
        } catch (Exception e) {
            this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, null, "加载失败: " + e.getMessage(), 126, null));
        }
    }

    private final void selectStatus(Status status) {
        Status newStatus = ((ViewState) this._state.getValue()).getSelectedStatus() == status ? null : status;
        updateWithStatusFilter(newStatus);
    }

    private final void selectSlot(AdSlot slot) {
        AdSlot newSlot = ((ViewState) this._state.getValue()).getSelectedSlot() == slot ? null : slot;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, newSlot, null, null, null, 239, null));
        updateFilteredInspectors();
    }

    private final void search(String query) {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, query, null, null, 223, null));
        updateFilteredInspectors();
    }

    private final void clearFilters() {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, RoomRecommendViewModel.EMPTY_CURSOR, null, null, 199, null));
        updateFilteredInspectors();
    }

    private final void updateWithStatusFilter(Status newStatus) {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredInspectors = applyAllFilters((List) this.inspectors.getValue(), newStatus, currentState.getSelectedSlot(), currentState.getSearchText());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredInspectors, newStatus, null, null, null, null, 243, null));
    }

    private final void updateFilteredInspectors() {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredForStats = applyNonStatusFilters((List) this.inspectors.getValue(), currentState.getSelectedSlot(), currentState.getSearchText());
        Map counts = calculateStats(filteredForStats);
        List filteredInspectors = applyAllFilters((List) this.inspectors.getValue(), currentState.getSelectedStatus(), currentState.getSelectedSlot(), currentState.getSearchText());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredInspectors, null, null, null, counts, null, 187, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0016 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<InspectorInfo> applyAllFilters(List<InspectorInfo> list, Status status, AdSlot slot, String query) {
        boolean matchesSearch;
        boolean matchesSearch2;
        List<InspectorInfo> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InspectorInfo inspector = (InspectorInfo) element$iv$iv;
            boolean matchesStatus = status == null || inspector.getPipeline().getStatus() == status;
            boolean matchesSlot = slot == null || inspector.getAdSlot() == slot;
            if (!(query.length() == 0)) {
                String title = inspector.getAdData().getTitle();
                if (!(title != null && StringsKt.contains(title, query, true))) {
                    matchesSearch = false;
                    matchesSearch2 = !matchesStatus && matchesSlot && matchesSearch;
                    if (!matchesSearch2) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
            }
            matchesSearch = true;
            if (matchesStatus) {
            }
            if (!matchesSearch2) {
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0014 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<InspectorInfo> applyNonStatusFilters(List<InspectorInfo> list, AdSlot slot, String query) {
        boolean matchesSearch;
        List<InspectorInfo> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            InspectorInfo inspector = (InspectorInfo) element$iv$iv;
            boolean z = false;
            boolean matchesSlot = slot == null || inspector.getAdSlot() == slot;
            if (!(query.length() == 0)) {
                String title = inspector.getAdData().getTitle();
                if (!(title != null && StringsKt.contains(title, query, true))) {
                    matchesSearch = false;
                    if (matchesSlot && matchesSearch) {
                        z = true;
                    }
                    if (!z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
            }
            matchesSearch = true;
            if (matchesSlot) {
                z = true;
            }
            if (!z) {
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Integer> calculateStats(List<InspectorInfo> list) {
        Map result = new LinkedHashMap();
        Iterable $this$forEach$iv = Status.getEntries();
        for (Object element$iv : $this$forEach$iv) {
            result.put((Status) element$iv, 0);
        }
        List<InspectorInfo> $this$forEach$iv2 = list;
        for (Object element$iv2 : $this$forEach$iv2) {
            InspectorInfo inspector = (InspectorInfo) element$iv2;
            Status status = inspector.getPipeline().getStatus();
            Integer num = (Integer) result.get(status);
            result.put(status, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<InspectorInfo>> getAllInspectorsFlow() {
        try {
            return StateManager.INSTANCE.getInspectorsFlow();
        } catch (Exception e) {
            return FlowKt.emptyFlow();
        }
    }

    public final void onCleared() {
        CoroutineScopeKt.cancel$default(this.viewModelScope, (CancellationException) null, 1, (Object) null);
    }
}