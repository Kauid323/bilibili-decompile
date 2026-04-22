package kntr.app.ad.ui.inspector.ui.main.report.viewmodel;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.core.work.ReportType;
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

/* compiled from: ReportListViewModel.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002./B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002J\u0012\u0010#\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002JB\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J8\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002J\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020*0)2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100,H\u0002J\u0006\u0010-\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$ViewState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "reports", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "processIntent", RoomRecommendViewModel.EMPTY_CURSOR, "intent", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "loadReports", "selectStatus", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "selectReportType", "type", "Lkntr/app/ad/domain/inspector/core/work/ReportType;", "selectAdId", "adId", RoomRecommendViewModel.EMPTY_CURSOR, "search", "query", "clearFilters", "updateWithStatusFilter", "newStatus", "updateFilteredReports", "applyAllFilters", "applyNonStatusFilters", "calculateStats", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getAllReportJobDataFlow", "Lkotlinx/coroutines/flow/Flow;", "onCleared", "ViewState", "Intent", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ReportListViewModel {
    public static final int $stable = 8;
    private Job loadJob;
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final MutableStateFlow<ViewState> _state = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, null, null, null, null, 511, null));
    private final StateFlow<ViewState> state = this._state;
    private final MutableStateFlow<List<ReportJobData>> reports = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public ReportListViewModel() {
        loadReports();
    }

    /* compiled from: ReportListViewModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003J\u0083\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0011HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0015R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001e¨\u00061"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$ViewState;", RoomRecommendViewModel.EMPTY_CURSOR, "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, "reports", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "filteredReports", "selectedStatus", "Lkntr/app/ad/domain/inspector/model/Status;", "selectedReportType", "Lkntr/app/ad/domain/inspector/core/work/ReportType;", "selectedAdId", RoomRecommendViewModel.EMPTY_CURSOR, "searchText", "statsCount", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "errorMessage", "<init>", "(ZLjava/util/List;Ljava/util/List;Lkntr/app/ad/domain/inspector/model/Status;Lkntr/app/ad/domain/inspector/core/work/ReportType;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "()Z", "getReports", "()Ljava/util/List;", "getFilteredReports", "getSelectedStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "getSelectedReportType", "()Lkntr/app/ad/domain/inspector/core/work/ReportType;", "getSelectedAdId", "()Ljava/lang/String;", "getSearchText", "getStatsCount", "()Ljava/util/Map;", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ViewState {
        public static final int $stable = 8;
        private final String errorMessage;
        private final List<ReportJobData> filteredReports;
        private final boolean isLoading;
        private final List<ReportJobData> reports;
        private final String searchText;
        private final String selectedAdId;
        private final ReportType selectedReportType;
        private final Status selectedStatus;
        private final Map<Object, Integer> statsCount;

        public ViewState() {
            this(false, null, null, null, null, null, null, null, null, 511, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, List list, List list2, Status status, ReportType reportType, String str, String str2, Map map, String str3, int i, Object obj) {
            return viewState.copy((i & 1) != 0 ? viewState.isLoading : z, (i & 2) != 0 ? viewState.reports : list, (i & 4) != 0 ? viewState.filteredReports : list2, (i & 8) != 0 ? viewState.selectedStatus : status, (i & 16) != 0 ? viewState.selectedReportType : reportType, (i & 32) != 0 ? viewState.selectedAdId : str, (i & 64) != 0 ? viewState.searchText : str2, (i & 128) != 0 ? viewState.statsCount : map, (i & 256) != 0 ? viewState.errorMessage : str3);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final List<ReportJobData> component2() {
            return this.reports;
        }

        public final List<ReportJobData> component3() {
            return this.filteredReports;
        }

        public final Status component4() {
            return this.selectedStatus;
        }

        public final ReportType component5() {
            return this.selectedReportType;
        }

        public final String component6() {
            return this.selectedAdId;
        }

        public final String component7() {
            return this.searchText;
        }

        public final Map<Object, Integer> component8() {
            return this.statsCount;
        }

        public final String component9() {
            return this.errorMessage;
        }

        public final ViewState copy(boolean z, List<ReportJobData> list, List<ReportJobData> list2, Status status, ReportType reportType, String str, String str2, Map<Object, Integer> map, String str3) {
            Intrinsics.checkNotNullParameter(list, "reports");
            Intrinsics.checkNotNullParameter(list2, "filteredReports");
            Intrinsics.checkNotNullParameter(str2, "searchText");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            return new ViewState(z, list, list2, status, reportType, str, str2, map, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewState) {
                ViewState viewState = (ViewState) obj;
                return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.reports, viewState.reports) && Intrinsics.areEqual(this.filteredReports, viewState.filteredReports) && this.selectedStatus == viewState.selectedStatus && this.selectedReportType == viewState.selectedReportType && Intrinsics.areEqual(this.selectedAdId, viewState.selectedAdId) && Intrinsics.areEqual(this.searchText, viewState.searchText) && Intrinsics.areEqual(this.statsCount, viewState.statsCount) && Intrinsics.areEqual(this.errorMessage, viewState.errorMessage);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + this.reports.hashCode()) * 31) + this.filteredReports.hashCode()) * 31) + (this.selectedStatus == null ? 0 : this.selectedStatus.hashCode())) * 31) + (this.selectedReportType == null ? 0 : this.selectedReportType.hashCode())) * 31) + (this.selectedAdId == null ? 0 : this.selectedAdId.hashCode())) * 31) + this.searchText.hashCode()) * 31) + this.statsCount.hashCode()) * 31) + (this.errorMessage != null ? this.errorMessage.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isLoading;
            List<ReportJobData> list = this.reports;
            List<ReportJobData> list2 = this.filteredReports;
            Status status = this.selectedStatus;
            ReportType reportType = this.selectedReportType;
            String str = this.selectedAdId;
            String str2 = this.searchText;
            Map<Object, Integer> map = this.statsCount;
            return "ViewState(isLoading=" + z + ", reports=" + list + ", filteredReports=" + list2 + ", selectedStatus=" + status + ", selectedReportType=" + reportType + ", selectedAdId=" + str + ", searchText=" + str2 + ", statsCount=" + map + ", errorMessage=" + this.errorMessage + ")";
        }

        public ViewState(boolean isLoading, List<ReportJobData> list, List<ReportJobData> list2, Status selectedStatus, ReportType selectedReportType, String selectedAdId, String searchText, Map<Object, Integer> map, String errorMessage) {
            Intrinsics.checkNotNullParameter(list, "reports");
            Intrinsics.checkNotNullParameter(list2, "filteredReports");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            Intrinsics.checkNotNullParameter(map, "statsCount");
            this.isLoading = isLoading;
            this.reports = list;
            this.filteredReports = list2;
            this.selectedStatus = selectedStatus;
            this.selectedReportType = selectedReportType;
            this.selectedAdId = selectedAdId;
            this.searchText = searchText;
            this.statsCount = map;
            this.errorMessage = errorMessage;
        }

        public /* synthetic */ ViewState(boolean z, List list, List list2, Status status, ReportType reportType, String str, String str2, Map map, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : status, (i & 16) != 0 ? null : reportType, (i & 32) != 0 ? null : str, (i & 64) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 128) != 0 ? MapsKt.emptyMap() : map, (i & 256) == 0 ? str3 : null);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final List<ReportJobData> getReports() {
            return this.reports;
        }

        public final List<ReportJobData> getFilteredReports() {
            return this.filteredReports;
        }

        public final Status getSelectedStatus() {
            return this.selectedStatus;
        }

        public final ReportType getSelectedReportType() {
            return this.selectedReportType;
        }

        public final String getSelectedAdId() {
            return this.selectedAdId;
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

    /* compiled from: ReportListViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadReports", "SelectStatus", "SelectReportType", "SelectAdId", "Search", "ClearFilters", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$LoadReports;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$Search;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectAdId;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectReportType;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectStatus;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class Intent {
        public static final int $stable = 0;

        public /* synthetic */ Intent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$LoadReports;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadReports extends Intent {
            public static final int $stable = 0;
            public static final LoadReports INSTANCE = new LoadReports();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof LoadReports) {
                    LoadReports loadReports = (LoadReports) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -731296148;
            }

            public String toString() {
                return "LoadReports";
            }

            private LoadReports() {
                super(null);
            }
        }

        private Intent() {
        }

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectStatus;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", AdAlarmExtraKey.STATUS, "Lkntr/app/ad/domain/inspector/model/Status;", "<init>", "(Lkntr/app/ad/domain/inspector/model/Status;)V", "getStatus", "()Lkntr/app/ad/domain/inspector/model/Status;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectReportType;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "type", "Lkntr/app/ad/domain/inspector/core/work/ReportType;", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/ReportType;)V", "getType", "()Lkntr/app/ad/domain/inspector/core/work/ReportType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectReportType extends Intent {
            public static final int $stable = 0;
            private final ReportType type;

            public static /* synthetic */ SelectReportType copy$default(SelectReportType selectReportType, ReportType reportType, int i, Object obj) {
                if ((i & 1) != 0) {
                    reportType = selectReportType.type;
                }
                return selectReportType.copy(reportType);
            }

            public final ReportType component1() {
                return this.type;
            }

            public final SelectReportType copy(ReportType reportType) {
                return new SelectReportType(reportType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectReportType) && this.type == ((SelectReportType) obj).type;
            }

            public int hashCode() {
                if (this.type == null) {
                    return 0;
                }
                return this.type.hashCode();
            }

            public String toString() {
                return "SelectReportType(type=" + this.type + ")";
            }

            public SelectReportType(ReportType type) {
                super(null);
                this.type = type;
            }

            public final ReportType getType() {
                return this.type;
            }
        }

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$SelectAdId;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "adId", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getAdId", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectAdId extends Intent {
            public static final int $stable = 0;
            private final String adId;

            public static /* synthetic */ SelectAdId copy$default(SelectAdId selectAdId, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = selectAdId.adId;
                }
                return selectAdId.copy(str);
            }

            public final String component1() {
                return this.adId;
            }

            public final SelectAdId copy(String str) {
                return new SelectAdId(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectAdId) && Intrinsics.areEqual(this.adId, ((SelectAdId) obj).adId);
            }

            public int hashCode() {
                if (this.adId == null) {
                    return 0;
                }
                return this.adId.hashCode();
            }

            public String toString() {
                return "SelectAdId(adId=" + this.adId + ")";
            }

            public SelectAdId(String adId) {
                super(null);
                this.adId = adId;
            }

            public final String getAdId() {
                return this.adId;
            }
        }

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$Search;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* compiled from: ReportListViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/report/viewmodel/ReportListViewModel$Intent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class ClearFilters extends Intent {
            public static final int $stable = 0;
            public static final ClearFilters INSTANCE = new ClearFilters();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof ClearFilters) {
                    ClearFilters clearFilters = (ClearFilters) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return 1364523739;
            }

            public String toString() {
                return "ClearFilters";
            }

            private ClearFilters() {
                super(null);
            }
        }
    }

    public final void processIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (!(intent instanceof Intent.LoadReports)) {
            if (!(intent instanceof Intent.SelectStatus)) {
                if (!(intent instanceof Intent.SelectReportType)) {
                    if (!(intent instanceof Intent.SelectAdId)) {
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
                    selectAdId(((Intent.SelectAdId) intent).getAdId());
                    return;
                }
                selectReportType(((Intent.SelectReportType) intent).getType());
                return;
            }
            selectStatus(((Intent.SelectStatus) intent).getStatus());
            return;
        }
        loadReports();
    }

    private final void loadReports() {
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), true, null, null, null, null, null, null, null, null, 510, null));
        try {
            this.loadJob = BuildersKt.launch$default(this.viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new ReportListViewModel$loadReports$1(this, null), 3, (Object) null);
        } catch (Exception e) {
            this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, null, null, "加载失败: " + e.getMessage(), 254, null));
        }
    }

    private final void selectStatus(Status status) {
        Status newStatus = ((ViewState) this._state.getValue()).getSelectedStatus() == status ? null : status;
        updateWithStatusFilter(newStatus);
    }

    private final void selectReportType(ReportType type) {
        ReportType newType = ((ViewState) this._state.getValue()).getSelectedReportType() == type ? null : type;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, newType, null, null, null, null, 495, null));
        updateFilteredReports();
    }

    private final void selectAdId(String adId) {
        String newAdId = Intrinsics.areEqual(((ViewState) this._state.getValue()).getSelectedAdId(), adId) ? null : adId;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, newAdId, null, null, null, 479, null));
        updateFilteredReports();
    }

    private final void search(String query) {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, query, null, null, 447, null));
        updateFilteredReports();
    }

    private final void clearFilters() {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, RoomRecommendViewModel.EMPTY_CURSOR, null, null, 391, null));
        updateFilteredReports();
    }

    private final void updateWithStatusFilter(Status newStatus) {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredReports = applyAllFilters((List) this.reports.getValue(), newStatus, currentState.getSelectedReportType(), currentState.getSelectedAdId(), currentState.getSearchText());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredReports, newStatus, null, null, null, null, null, 499, null));
    }

    private final void updateFilteredReports() {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredForStats = applyNonStatusFilters((List) this.reports.getValue(), currentState.getSelectedReportType(), currentState.getSelectedAdId(), currentState.getSearchText());
        Map counts = calculateStats(filteredForStats);
        List filteredReports = applyAllFilters((List) this.reports.getValue(), currentState.getSelectedStatus(), currentState.getSelectedReportType(), currentState.getSelectedAdId(), currentState.getSearchText());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredReports, null, null, null, null, counts, null, 379, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ReportJobData> applyAllFilters(List<ReportJobData> list, Status status, ReportType type, String adId, String query) {
        boolean matchesSearch;
        boolean matchesAdId;
        Status status2 = status;
        ReportType reportType = type;
        List<ReportJobData> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ReportJobData jobData = (ReportJobData) element$iv$iv;
            boolean matchesStatus = status2 == null || jobData.getStatus() == status2;
            boolean matchesType = reportType == null || jobData.getReportType() == reportType;
            boolean matchesAdId2 = adId == null || Intrinsics.areEqual(jobData.getAdId(), adId);
            if (!(query.length() == 0) && !StringsKt.contains(jobData.getName(), query, true)) {
                String requestBody = jobData.getRequestBody();
                if (!(requestBody != null && StringsKt.contains(requestBody, query, true))) {
                    String url = jobData.getUrl();
                    if (!(url != null && StringsKt.contains(url, query, true))) {
                        matchesSearch = false;
                        matchesAdId = !matchesStatus && matchesType && matchesAdId2 && matchesSearch;
                        if (!matchesAdId) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        status2 = status;
                        reportType = type;
                    }
                }
            }
            matchesSearch = true;
            if (matchesStatus) {
            }
            if (!matchesAdId) {
            }
            status2 = status;
            reportType = type;
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0016 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ReportJobData> applyNonStatusFilters(List<ReportJobData> list, ReportType type, String adId, String query) {
        boolean matchesSearch;
        boolean matchesSearch2;
        List<ReportJobData> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ReportJobData jobData = (ReportJobData) element$iv$iv;
            boolean matchesType = type == null || jobData.getReportType() == type;
            boolean matchesAdId = adId == null || Intrinsics.areEqual(jobData.getAdId(), adId);
            if (!(query.length() == 0) && !StringsKt.contains(jobData.getName(), query, true)) {
                String requestBody = jobData.getRequestBody();
                if (!(requestBody != null && StringsKt.contains(requestBody, query, true))) {
                    String url = jobData.getUrl();
                    if (!(url != null && StringsKt.contains(url, query, true))) {
                        matchesSearch = false;
                        matchesSearch2 = !matchesType && matchesAdId && matchesSearch;
                        if (!matchesSearch2) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                }
            }
            matchesSearch = true;
            if (matchesType) {
            }
            if (!matchesSearch2) {
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<Object, Integer> calculateStats(List<ReportJobData> list) {
        Map result = new LinkedHashMap();
        Iterable $this$forEach$iv = Status.getEntries();
        for (Object element$iv : $this$forEach$iv) {
            result.put((Status) element$iv, 0);
        }
        Iterable $this$forEach$iv2 = ReportType.getEntries();
        for (Object element$iv2 : $this$forEach$iv2) {
            result.put((ReportType) element$iv2, 0);
        }
        List<ReportJobData> $this$forEach$iv3 = list;
        for (Object element$iv3 : $this$forEach$iv3) {
            ReportJobData report = (ReportJobData) element$iv3;
            Status status = report.getStatus();
            Integer num = (Integer) result.get(status);
            result.put(status, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
            ReportType type = report.getReportType();
            Integer num2 = (Integer) result.get(type);
            result.put(type, Integer.valueOf((num2 != null ? num2.intValue() : 0) + 1));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<ReportJobData>> getAllReportJobDataFlow() {
        try {
            return StateManager.INSTANCE.getReportJobDataListFlow();
        } catch (Exception e) {
            return FlowKt.emptyFlow();
        }
    }

    public final void onCleared() {
        CoroutineScopeKt.cancel$default(this.viewModelScope, (CancellationException) null, 1, (Object) null);
    }
}