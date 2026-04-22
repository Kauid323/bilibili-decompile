package kntr.app.ad.domain.inspector.core;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Comparator;
import java.util.List;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: StateManager.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0013\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\rJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00182\u0006\u0010\u0016\u001a\u00020\u0006J\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00182\u0006\u0010(\u001a\u00020\u0006J\u0016\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00182\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u000fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00190\u00188F¢\u0006\f\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00190\u00188F¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u001cR#\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00190\u00188F¢\u0006\f\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u001cR#\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00190\u00188F¢\u0006\f\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010\u001c¨\u0006,"}, d2 = {"Lkntr/app/ad/domain/inspector/core/StateManager;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "inspectors", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "requestJobDataList", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "reportJobDataList", "Lkntr/app/ad/domain/inspector/core/work/ReportJobData;", "printJobDataList", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "addInspectorInfo", RoomRecommendViewModel.EMPTY_CURSOR, "inspector", "addRequestJobData", "jobData", "addReportJobData", "addPrintJobData", "getInspector", "adId", "inspectorsFlow", "Lkotlinx/coroutines/flow/Flow;", RoomRecommendViewModel.EMPTY_CURSOR, "getInspectorsFlow$annotations", "getInspectorsFlow", "()Lkotlinx/coroutines/flow/Flow;", "requestJobDataListFlow", "getRequestJobDataListFlow$annotations", "getRequestJobDataListFlow", "reportJobDataListFlow", "getReportJobDataListFlow$annotations", "getReportJobDataListFlow", "printJobDataListFlow", "getPrintJobDataListFlow$annotations", "getPrintJobDataListFlow", "getInspectorInfoFlow", "getRequestJobDataFlow", "requestId", "getReportJobDataFlow", "reportId", "clearAllData", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StateManager {
    public static final int $stable = 0;
    public static final StateManager INSTANCE = new StateManager();
    private static final SnapshotStateMap<String, InspectorInfo> inspectors = SnapshotStateKt.mutableStateMapOf();
    private static final SnapshotStateMap<String, RequestJobData> requestJobDataList = SnapshotStateKt.mutableStateMapOf();
    private static final SnapshotStateMap<String, ReportJobData> reportJobDataList = SnapshotStateKt.mutableStateMapOf();
    private static final SnapshotStateMap<String, PrintJobData> printJobDataList = SnapshotStateKt.mutableStateMapOf();

    public static /* synthetic */ void getInspectorsFlow$annotations() {
    }

    public static /* synthetic */ void getPrintJobDataListFlow$annotations() {
    }

    public static /* synthetic */ void getReportJobDataListFlow$annotations() {
    }

    public static /* synthetic */ void getRequestJobDataListFlow$annotations() {
    }

    private StateManager() {
    }

    public final void addInspectorInfo(InspectorInfo inspector) {
        Intrinsics.checkNotNullParameter(inspector, "inspector");
        inspectors.put(inspector.getId(), inspector);
    }

    public final void addRequestJobData(RequestJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        requestJobDataList.put(jobData.getId(), jobData);
    }

    public final void addReportJobData(ReportJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        reportJobDataList.put(jobData.getId(), jobData);
    }

    public final void addPrintJobData(PrintJobData jobData) {
        Intrinsics.checkNotNullParameter(jobData, "jobData");
        printJobDataList.put(jobData.getId(), jobData);
    }

    public final InspectorInfo getInspector(String adId) {
        return (InspectorInfo) inspectors.get(adId);
    }

    public final Flow<List<InspectorInfo>> getInspectorsFlow() {
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda4
            public final Object invoke() {
                List _get_inspectorsFlow_$lambda$0;
                _get_inspectorsFlow_$lambda$0 = StateManager._get_inspectorsFlow_$lambda$0();
                return _get_inspectorsFlow_$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_inspectorsFlow_$lambda$0() {
        Iterable $this$sortedByDescending$iv = CollectionsKt.toList(inspectors.values());
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.app.ad.domain.inspector.core.StateManager$_get_inspectorsFlow_$lambda$0$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                InspectorInfo it = (InspectorInfo) t2;
                InspectorInfo it2 = (InspectorInfo) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getTimestamp()), Long.valueOf(it2.getTimestamp()));
            }
        });
    }

    public final Flow<List<RequestJobData>> getRequestJobDataListFlow() {
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda3
            public final Object invoke() {
                List _get_requestJobDataListFlow_$lambda$0;
                _get_requestJobDataListFlow_$lambda$0 = StateManager._get_requestJobDataListFlow_$lambda$0();
                return _get_requestJobDataListFlow_$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_requestJobDataListFlow_$lambda$0() {
        Iterable $this$sortedByDescending$iv = CollectionsKt.toList(requestJobDataList.values());
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.app.ad.domain.inspector.core.StateManager$_get_requestJobDataListFlow_$lambda$0$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                RequestJobData it = (RequestJobData) t2;
                RequestJobData it2 = (RequestJobData) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getTimestamp()), Long.valueOf(it2.getTimestamp()));
            }
        });
    }

    public final Flow<List<ReportJobData>> getReportJobDataListFlow() {
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda6
            public final Object invoke() {
                List _get_reportJobDataListFlow_$lambda$0;
                _get_reportJobDataListFlow_$lambda$0 = StateManager._get_reportJobDataListFlow_$lambda$0();
                return _get_reportJobDataListFlow_$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_reportJobDataListFlow_$lambda$0() {
        Iterable $this$sortedByDescending$iv = CollectionsKt.toList(reportJobDataList.values());
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.app.ad.domain.inspector.core.StateManager$_get_reportJobDataListFlow_$lambda$0$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ReportJobData it = (ReportJobData) t2;
                ReportJobData it2 = (ReportJobData) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getTimestamp()), Long.valueOf(it2.getTimestamp()));
            }
        });
    }

    public final Flow<List<PrintJobData>> getPrintJobDataListFlow() {
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                List _get_printJobDataListFlow_$lambda$0;
                _get_printJobDataListFlow_$lambda$0 = StateManager._get_printJobDataListFlow_$lambda$0();
                return _get_printJobDataListFlow_$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _get_printJobDataListFlow_$lambda$0() {
        Iterable $this$sortedByDescending$iv = CollectionsKt.toList(printJobDataList.values());
        return CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.app.ad.domain.inspector.core.StateManager$_get_printJobDataListFlow_$lambda$0$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                PrintJobData it = (PrintJobData) t2;
                PrintJobData it2 = (PrintJobData) t;
                return ComparisonsKt.compareValues(Long.valueOf(it.getTimestamp()), Long.valueOf(it2.getTimestamp()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InspectorInfo getInspectorInfoFlow$lambda$0(String $adId) {
        return (InspectorInfo) inspectors.get($adId);
    }

    public final Flow<InspectorInfo> getInspectorInfoFlow(final String adId) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda2
            public final Object invoke() {
                InspectorInfo inspectorInfoFlow$lambda$0;
                inspectorInfoFlow$lambda$0 = StateManager.getInspectorInfoFlow$lambda$0(adId);
                return inspectorInfoFlow$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RequestJobData getRequestJobDataFlow$lambda$0(String $requestId) {
        return (RequestJobData) requestJobDataList.get($requestId);
    }

    public final Flow<RequestJobData> getRequestJobDataFlow(final String requestId) {
        Intrinsics.checkNotNullParameter(requestId, "requestId");
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                RequestJobData requestJobDataFlow$lambda$0;
                requestJobDataFlow$lambda$0 = StateManager.getRequestJobDataFlow$lambda$0(requestId);
                return requestJobDataFlow$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReportJobData getReportJobDataFlow$lambda$0(String $reportId) {
        return (ReportJobData) reportJobDataList.get($reportId);
    }

    public final Flow<ReportJobData> getReportJobDataFlow(final String reportId) {
        Intrinsics.checkNotNullParameter(reportId, "reportId");
        return FlowKt.distinctUntilChanged(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.ad.domain.inspector.core.StateManager$$ExternalSyntheticLambda5
            public final Object invoke() {
                ReportJobData reportJobDataFlow$lambda$0;
                reportJobDataFlow$lambda$0 = StateManager.getReportJobDataFlow$lambda$0(reportId);
                return reportJobDataFlow$lambda$0;
            }
        }));
    }

    public final void clearAllData() {
        requestJobDataList.clear();
        inspectors.clear();
        reportJobDataList.clear();
        printJobDataList.clear();
    }
}