package kntr.app.ad.ui.inspector.ui.main.console.viewmodel;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.PrintType;
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

/* compiled from: ConsoleListViewModel.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\b\u0010\u001e\u001a\u00020\u0013H\u0002J.\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u001cH\u0002J\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020#0\"2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100%H\u0002J\u0006\u0010&\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "loadJob", "Lkotlinx/coroutines/Job;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$ViewState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "printJobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "processIntent", RoomRecommendViewModel.EMPTY_CURSOR, "intent", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", "loadPrintJobs", "selectPrintType", "type", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "updateSearchText", "text", RoomRecommendViewModel.EMPTY_CURSOR, "clearFilters", "updateFilteredPrintJobs", "applyFilters", "searchText", "calculateTypeStats", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getAllPrintJobDataFlow", "Lkotlinx/coroutines/flow/Flow;", "onCleared", "ViewState", "Intent", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConsoleListViewModel {
    public static final int $stable = 8;
    private Job loadJob;
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));
    private final MutableStateFlow<ViewState> _state = StateFlowKt.MutableStateFlow(new ViewState(false, null, null, null, null, null, null, 127, null));
    private final StateFlow<ViewState> state = this._state;
    private final MutableStateFlow<List<PrintJobData>> printJobs = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());

    public ConsoleListViewModel() {
        loadPrintJobs();
    }

    /* compiled from: ConsoleListViewModel.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003Jk\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000eHÖ\u0001J\t\u0010(\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006)"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$ViewState;", RoomRecommendViewModel.EMPTY_CURSOR, "isLoading", RoomRecommendViewModel.EMPTY_CURSOR, "printJobs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "filteredPrintJobs", "selectedPrintType", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "searchText", RoomRecommendViewModel.EMPTY_CURSOR, "typesCount", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "errorMessage", "<init>", "(ZLjava/util/List;Ljava/util/List;Lkntr/app/ad/domain/inspector/core/work/PrintType;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "()Z", "getPrintJobs", "()Ljava/util/List;", "getFilteredPrintJobs", "getSelectedPrintType", "()Lkntr/app/ad/domain/inspector/core/work/PrintType;", "getSearchText", "()Ljava/lang/String;", "getTypesCount", "()Ljava/util/Map;", "getErrorMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ViewState {
        public static final int $stable = 8;
        private final String errorMessage;
        private final List<PrintJobData> filteredPrintJobs;
        private final boolean isLoading;
        private final List<PrintJobData> printJobs;
        private final String searchText;
        private final PrintType selectedPrintType;
        private final Map<PrintType, Integer> typesCount;

        public ViewState() {
            this(false, null, null, null, null, null, null, 127, null);
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z, List list, List list2, PrintType printType, String str, Map map, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = viewState.isLoading;
            }
            List<PrintJobData> list3 = list;
            if ((i & 2) != 0) {
                list3 = viewState.printJobs;
            }
            List list4 = list3;
            List<PrintJobData> list5 = list2;
            if ((i & 4) != 0) {
                list5 = viewState.filteredPrintJobs;
            }
            List list6 = list5;
            if ((i & 8) != 0) {
                printType = viewState.selectedPrintType;
            }
            PrintType printType2 = printType;
            if ((i & 16) != 0) {
                str = viewState.searchText;
            }
            String str3 = str;
            Map<PrintType, Integer> map2 = map;
            if ((i & 32) != 0) {
                map2 = viewState.typesCount;
            }
            Map map3 = map2;
            if ((i & 64) != 0) {
                str2 = viewState.errorMessage;
            }
            return viewState.copy(z, list4, list6, printType2, str3, map3, str2);
        }

        public final boolean component1() {
            return this.isLoading;
        }

        public final List<PrintJobData> component2() {
            return this.printJobs;
        }

        public final List<PrintJobData> component3() {
            return this.filteredPrintJobs;
        }

        public final PrintType component4() {
            return this.selectedPrintType;
        }

        public final String component5() {
            return this.searchText;
        }

        public final Map<PrintType, Integer> component6() {
            return this.typesCount;
        }

        public final String component7() {
            return this.errorMessage;
        }

        public final ViewState copy(boolean z, List<PrintJobData> list, List<PrintJobData> list2, PrintType printType, String str, Map<PrintType, Integer> map, String str2) {
            Intrinsics.checkNotNullParameter(list, "printJobs");
            Intrinsics.checkNotNullParameter(list2, "filteredPrintJobs");
            Intrinsics.checkNotNullParameter(str, "searchText");
            Intrinsics.checkNotNullParameter(map, "typesCount");
            return new ViewState(z, list, list2, printType, str, map, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ViewState) {
                ViewState viewState = (ViewState) obj;
                return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.printJobs, viewState.printJobs) && Intrinsics.areEqual(this.filteredPrintJobs, viewState.filteredPrintJobs) && this.selectedPrintType == viewState.selectedPrintType && Intrinsics.areEqual(this.searchText, viewState.searchText) && Intrinsics.areEqual(this.typesCount, viewState.typesCount) && Intrinsics.areEqual(this.errorMessage, viewState.errorMessage);
            }
            return false;
        }

        public int hashCode() {
            return (((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading) * 31) + this.printJobs.hashCode()) * 31) + this.filteredPrintJobs.hashCode()) * 31) + (this.selectedPrintType == null ? 0 : this.selectedPrintType.hashCode())) * 31) + this.searchText.hashCode()) * 31) + this.typesCount.hashCode()) * 31) + (this.errorMessage != null ? this.errorMessage.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isLoading;
            List<PrintJobData> list = this.printJobs;
            List<PrintJobData> list2 = this.filteredPrintJobs;
            PrintType printType = this.selectedPrintType;
            String str = this.searchText;
            Map<PrintType, Integer> map = this.typesCount;
            return "ViewState(isLoading=" + z + ", printJobs=" + list + ", filteredPrintJobs=" + list2 + ", selectedPrintType=" + printType + ", searchText=" + str + ", typesCount=" + map + ", errorMessage=" + this.errorMessage + ")";
        }

        public ViewState(boolean isLoading, List<PrintJobData> list, List<PrintJobData> list2, PrintType selectedPrintType, String searchText, Map<PrintType, Integer> map, String errorMessage) {
            Intrinsics.checkNotNullParameter(list, "printJobs");
            Intrinsics.checkNotNullParameter(list2, "filteredPrintJobs");
            Intrinsics.checkNotNullParameter(searchText, "searchText");
            Intrinsics.checkNotNullParameter(map, "typesCount");
            this.isLoading = isLoading;
            this.printJobs = list;
            this.filteredPrintJobs = list2;
            this.selectedPrintType = selectedPrintType;
            this.searchText = searchText;
            this.typesCount = map;
            this.errorMessage = errorMessage;
        }

        public /* synthetic */ ViewState(boolean z, List list, List list2, PrintType printType, String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? CollectionsKt.emptyList() : list2, (i & 8) != 0 ? null : printType, (i & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 32) != 0 ? MapsKt.emptyMap() : map, (i & 64) != 0 ? null : str2);
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public final List<PrintJobData> getPrintJobs() {
            return this.printJobs;
        }

        public final List<PrintJobData> getFilteredPrintJobs() {
            return this.filteredPrintJobs;
        }

        public final PrintType getSelectedPrintType() {
            return this.selectedPrintType;
        }

        public final String getSearchText() {
            return this.searchText;
        }

        public final Map<PrintType, Integer> getTypesCount() {
            return this.typesCount;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    public final StateFlow<ViewState> getState() {
        return this.state;
    }

    /* compiled from: ConsoleListViewModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "LoadPrintJobs", "SelectPrintType", "UpdateSearchText", "ClearFilters", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$LoadPrintJobs;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$SelectPrintType;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$UpdateSearchText;", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static abstract class Intent {
        public static final int $stable = 0;

        public /* synthetic */ Intent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: ConsoleListViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$LoadPrintJobs;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class LoadPrintJobs extends Intent {
            public static final int $stable = 0;
            public static final LoadPrintJobs INSTANCE = new LoadPrintJobs();

            private LoadPrintJobs() {
                super(null);
            }
        }

        private Intent() {
        }

        /* compiled from: ConsoleListViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$SelectPrintType;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", "type", "Lkntr/app/ad/domain/inspector/core/work/PrintType;", "<init>", "(Lkntr/app/ad/domain/inspector/core/work/PrintType;)V", "getType", "()Lkntr/app/ad/domain/inspector/core/work/PrintType;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SelectPrintType extends Intent {
            public static final int $stable = 0;
            private final PrintType type;

            public static /* synthetic */ SelectPrintType copy$default(SelectPrintType selectPrintType, PrintType printType, int i, Object obj) {
                if ((i & 1) != 0) {
                    printType = selectPrintType.type;
                }
                return selectPrintType.copy(printType);
            }

            public final PrintType component1() {
                return this.type;
            }

            public final SelectPrintType copy(PrintType printType) {
                return new SelectPrintType(printType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectPrintType) && this.type == ((SelectPrintType) obj).type;
            }

            public int hashCode() {
                if (this.type == null) {
                    return 0;
                }
                return this.type.hashCode();
            }

            public String toString() {
                return "SelectPrintType(type=" + this.type + ")";
            }

            public SelectPrintType(PrintType type) {
                super(null);
                this.type = type;
            }

            public final PrintType getType() {
                return this.type;
            }
        }

        /* compiled from: ConsoleListViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$UpdateSearchText;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class UpdateSearchText extends Intent {
            public static final int $stable = 0;
            private final String text;

            public static /* synthetic */ UpdateSearchText copy$default(UpdateSearchText updateSearchText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = updateSearchText.text;
                }
                return updateSearchText.copy(str);
            }

            public final String component1() {
                return this.text;
            }

            public final UpdateSearchText copy(String str) {
                Intrinsics.checkNotNullParameter(str, "text");
                return new UpdateSearchText(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof UpdateSearchText) && Intrinsics.areEqual(this.text, ((UpdateSearchText) obj).text);
            }

            public int hashCode() {
                return this.text.hashCode();
            }

            public String toString() {
                return "UpdateSearchText(text=" + this.text + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateSearchText(String text) {
                super(null);
                Intrinsics.checkNotNullParameter(text, "text");
                this.text = text;
            }

            public final String getText() {
                return this.text;
            }
        }

        /* compiled from: ConsoleListViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent$ClearFilters;", "Lkntr/app/ad/ui/inspector/ui/main/console/viewmodel/ConsoleListViewModel$Intent;", "<init>", "()V", "ad-inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
        if (!(intent instanceof Intent.LoadPrintJobs)) {
            if (!(intent instanceof Intent.SelectPrintType)) {
                if (!(intent instanceof Intent.UpdateSearchText)) {
                    if (!(intent instanceof Intent.ClearFilters)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    clearFilters();
                    return;
                }
                updateSearchText(((Intent.UpdateSearchText) intent).getText());
                return;
            }
            selectPrintType(((Intent.SelectPrintType) intent).getType());
            return;
        }
        loadPrintJobs();
    }

    private final void loadPrintJobs() {
        Job job = this.loadJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), true, null, null, null, null, null, null, 126, null));
        try {
            this.loadJob = BuildersKt.launch$default(this.viewModelScope, (CoroutineContext) null, (CoroutineStart) null, new ConsoleListViewModel$loadPrintJobs$1(this, null), 3, (Object) null);
        } catch (Exception e) {
            this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, null, null, "加载失败: " + e.getMessage(), 62, null));
        }
    }

    private final void selectPrintType(PrintType type) {
        PrintType newType = ((ViewState) this._state.getValue()).getSelectedPrintType() == type ? null : type;
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, newType, null, null, null, 119, null));
        updateFilteredPrintJobs();
    }

    private final void updateSearchText(String text) {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, text, null, null, 111, null));
        updateFilteredPrintJobs();
    }

    private final void clearFilters() {
        this._state.setValue(ViewState.copy$default((ViewState) this._state.getValue(), false, null, null, null, RoomRecommendViewModel.EMPTY_CURSOR, null, null, 103, null));
        updateFilteredPrintJobs();
    }

    private final void updateFilteredPrintJobs() {
        ViewState currentState = (ViewState) this._state.getValue();
        List filteredPrintJobs = applyFilters((List) this.printJobs.getValue(), currentState.getSelectedPrintType(), currentState.getSearchText());
        this._state.setValue(ViewState.copy$default(currentState, false, null, filteredPrintJobs, null, null, null, null, 123, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PrintJobData> applyFilters(List<PrintJobData> list, PrintType type, String searchText) {
        List<PrintJobData> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PrintJobData jobData = (PrintJobData) element$iv$iv;
            boolean z = false;
            if (type == null || jobData.getType() == type) {
                if ((searchText.length() == 0) || StringsKt.contains(jobData.getName(), searchText, true) || StringsKt.contains(jobData.getMsg(), searchText, true)) {
                    z = true;
                }
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<PrintType, Integer> calculateTypeStats(List<PrintJobData> list) {
        Map result = new LinkedHashMap();
        Iterable $this$forEach$iv = PrintType.getEntries();
        for (Object element$iv : $this$forEach$iv) {
            PrintType type = (PrintType) element$iv;
            result.put(type, 0);
        }
        List<PrintJobData> $this$forEach$iv2 = list;
        for (Object element$iv2 : $this$forEach$iv2) {
            PrintJobData printJob = (PrintJobData) element$iv2;
            PrintType type2 = printJob.getType();
            Integer num = (Integer) result.get(printJob.getType());
            result.put(type2, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<List<PrintJobData>> getAllPrintJobDataFlow() {
        try {
            return StateManager.INSTANCE.getPrintJobDataListFlow();
        } catch (Exception e) {
            return FlowKt.emptyFlow();
        }
    }

    public final void onCleared() {
        CoroutineScopeKt.cancel$default(this.viewModelScope, (CancellationException) null, 1, (Object) null);
    }
}