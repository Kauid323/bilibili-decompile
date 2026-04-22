package kntr.app.tribee.repost.page.selectTribeeBottomSheet;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bapis.bilibili.app.dynamic.v2.KRepostTribeeListReq;
import com.bapis.bilibili.app.dynamic.v2.KRepostTribeeListResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeMoss;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSelectBox;
import com.bapis.bilibili.pagination.KPagination;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CancellationException;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetState;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetStateAction;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListScrollPosition;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectTribeeListState;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeeItem;
import kntr.app.tribee.repost.page.selectTribeeBottomSheet.selectTribeeList.SelectableTribeePartition;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SelectTribeeBottomSheetViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B}\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012>\u0010\t\u001a:\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010&J\b\u0010(\u001a\u00020\bH\u0002J\u001c\u0010)\u001a\u00020\b2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u0010\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0002J\u000e\u00101\u001a\u000202H\u0082@¢\u0006\u0002\u0010&J\u0016\u00103\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u00104R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013RI\u0010\t\u001a:\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "getDefaultSelectedTribeeIdHandler", "Lkotlin/Function0;", "", "onListTribeeItemExposed", "Lkotlin/Function2;", "", "", "onSelectedTribeeOrPartitionChanged", "Lkotlin/Function3;", "Lkotlin/Pair;", "", "onDismiss", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "getGetDefaultSelectedTribeeIdHandler", "()Lkotlin/jvm/functions/Function0;", "getOnListTribeeItemExposed", "()Lkotlin/jvm/functions/Function2;", "getOnSelectedTribeeOrPartitionChanged", "()Lkotlin/jvm/functions/Function3;", "getOnDismiss", "state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "next", "loadingJob", "Lkotlinx/coroutines/Job;", "loadMoreJob", "dispatch", "action", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/SelectTribeeBottomSheetStateAction;", "handleLoading", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleLoadMore", "cancelLoadMoreJobIfNeed", "handleSelectTribeeOrPartition", "tribee", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeeItem;", "partition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectableTribeePartition;", "handleSaveListScrollPosition", "listScrollPosition", "Lkntr/app/tribee/repost/page/selectTribeeBottomSheet/selectTribeeList/SelectTribeeListScrollPosition;", "initialData", "Lcom/bapis/bilibili/app/dynamic/v2/KRepostTribeeListResp;", "nextData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SelectTribeeBottomSheetViewModel extends ViewModel {
    public static final int $stable = 8;
    private final Function0<Long> getDefaultSelectedTribeeIdHandler;
    private Job loadMoreJob;
    private Job loadingJob;
    private String next;
    private final Function0<Unit> onDismiss;
    private final Function2<Long, String, Unit> onListTribeeItemExposed;
    private final Function3<Pair<Long, String>, Pair<Long, String>, Boolean, Unit> onSelectedTribeeOrPartitionChanged;
    private final MutableStateFlow<SelectTribeeBottomSheetState> state;
    private final StateFlow<SelectTribeeBottomSheetState> stateFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectTribeeBottomSheetViewModel(Function0<Long> function0, Function2<? super Long, ? super String, Unit> function2, Function3<? super Pair<Long, String>, ? super Pair<Long, String>, ? super Boolean, Unit> function3, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "getDefaultSelectedTribeeIdHandler");
        Intrinsics.checkNotNullParameter(function2, "onListTribeeItemExposed");
        Intrinsics.checkNotNullParameter(function3, "onSelectedTribeeOrPartitionChanged");
        Intrinsics.checkNotNullParameter(function02, "onDismiss");
        this.getDefaultSelectedTribeeIdHandler = function0;
        this.onListTribeeItemExposed = function2;
        this.onSelectedTribeeOrPartitionChanged = function3;
        this.onDismiss = function02;
        this.state = StateFlowKt.MutableStateFlow(SelectTribeeBottomSheetState.SelectTribeeBottomSheetLoadingState.INSTANCE);
        this.stateFlow = FlowKt.asStateFlow(this.state);
        this.next = "";
        dispatch(SelectTribeeBottomSheetStateAction.Loading.INSTANCE);
    }

    public final Function0<Long> getGetDefaultSelectedTribeeIdHandler() {
        return this.getDefaultSelectedTribeeIdHandler;
    }

    public final Function2<Long, String, Unit> getOnListTribeeItemExposed() {
        return this.onListTribeeItemExposed;
    }

    public final Function3<Pair<Long, String>, Pair<Long, String>, Boolean, Unit> getOnSelectedTribeeOrPartitionChanged() {
        return this.onSelectedTribeeOrPartitionChanged;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final StateFlow<SelectTribeeBottomSheetState> getStateFlow() {
        return this.stateFlow;
    }

    public final void dispatch(SelectTribeeBottomSheetStateAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof SelectTribeeBottomSheetStateAction.Loading) {
            Job job = this.loadingJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.loadingJob = null;
            this.loadingJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SelectTribeeBottomSheetViewModel$dispatch$1(this, null), 3, (Object) null);
        } else if (action instanceof SelectTribeeBottomSheetStateAction.LoadMore) {
            this.loadMoreJob = BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new SelectTribeeBottomSheetViewModel$dispatch$2(this, null), 3, (Object) null);
        } else if (action instanceof SelectTribeeBottomSheetStateAction.ListTribeeItemExposed) {
            this.onListTribeeItemExposed.invoke(Long.valueOf(((SelectTribeeBottomSheetStateAction.ListTribeeItemExposed) action).getTribeeId()), ((SelectTribeeBottomSheetStateAction.ListTribeeItemExposed) action).getTribeeName());
        } else if (action instanceof SelectTribeeBottomSheetStateAction.SelectTribeeOrPartition) {
            cancelLoadMoreJobIfNeed();
            handleSelectTribeeOrPartition(((SelectTribeeBottomSheetStateAction.SelectTribeeOrPartition) action).getTribee(), ((SelectTribeeBottomSheetStateAction.SelectTribeeOrPartition) action).getPartition());
        } else if (!(action instanceof SelectTribeeBottomSheetStateAction.SaveListScrollPosition)) {
            throw new NoWhenBranchMatchedException();
        } else {
            handleSaveListScrollPosition(((SelectTribeeBottomSheetStateAction.SaveListScrollPosition) action).getListScrollPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0060 A[Catch: Exception -> 0x02b9, TRY_LEAVE, TryCatch #0 {Exception -> 0x02b9, blocks: (B:20:0x0050, B:22:0x0060, B:26:0x007c, B:27:0x008f, B:34:0x00be, B:35:0x00d8, B:37:0x00de, B:38:0x0114, B:46:0x015d, B:17:0x0047), top: B:94:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a0 A[Catch: Exception -> 0x02b7, TRY_LEAVE, TryCatch #1 {Exception -> 0x02b7, blocks: (B:48:0x016c, B:49:0x017d, B:51:0x0183, B:52:0x01ad, B:53:0x01d1, B:55:0x01ea, B:57:0x01f7, B:60:0x0206, B:62:0x020e, B:64:0x021f, B:65:0x022f, B:69:0x0247, B:71:0x0267, B:74:0x0273, B:76:0x0279, B:78:0x027f, B:81:0x028b, B:83:0x0291, B:85:0x02a0), top: B:96:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoading(Continuation<? super Unit> continuation) {
        Continuation selectTribeeBottomSheetViewModel$handleLoading$1;
        Continuation $continuation;
        Object obj;
        KRepostTribeeListResp response;
        KTribeeSelectBox box;
        if (continuation instanceof SelectTribeeBottomSheetViewModel$handleLoading$1) {
            selectTribeeBottomSheetViewModel$handleLoading$1 = (SelectTribeeBottomSheetViewModel$handleLoading$1) continuation;
            if ((selectTribeeBottomSheetViewModel$handleLoading$1.label & Integer.MIN_VALUE) != 0) {
                selectTribeeBottomSheetViewModel$handleLoading$1.label -= Integer.MIN_VALUE;
                $continuation = selectTribeeBottomSheetViewModel$handleLoading$1;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        this.state.setValue(SelectTribeeBottomSheetState.SelectTribeeBottomSheetLoadingState.INSTANCE);
                        try {
                            $continuation.label = 1;
                            obj = initialData($continuation);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            response = (KRepostTribeeListResp) obj;
                            this.next = response.getNext();
                            box = response.getBox();
                        } catch (Exception e) {
                            e = e;
                            KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loading error! (" + e.getMessage() + ")");
                            this.state.setValue(SelectTribeeBottomSheetState.SelectTribeeBottomSheetErrorState.INSTANCE);
                            return Unit.INSTANCE;
                        }
                        try {
                            if (box == null) {
                                List tribees = box.getTribees();
                                if (tribees.isEmpty()) {
                                    this.state.setValue(new SelectTribeeBottomSheetState.SelectTribeeBottomSheetEmptyState(null, 1, null));
                                } else {
                                    List $this$distinctBy$iv = tribees;
                                    HashSet set$iv = new HashSet();
                                    ArrayList list$iv = new ArrayList();
                                    for (Object e$iv : $this$distinctBy$iv) {
                                        if (set$iv.add(Boxing.boxLong(((KTribeeSelectBox.KTribee) e$iv).getId()))) {
                                            list$iv.add(e$iv);
                                        }
                                    }
                                    ArrayList $this$map$iv = list$iv;
                                    boolean z = false;
                                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        KTribeeSelectBox.KTribee tribee = (KTribeeSelectBox.KTribee) item$iv$iv;
                                        long id = tribee.getId();
                                        String name = tribee.getName();
                                        String desc = tribee.getDesc();
                                        String picUrl = tribee.getPicUrl();
                                        Iterable $this$distinctBy$iv2 = tribee.getCategories();
                                        HashSet set$iv2 = new HashSet();
                                        Iterable list$iv2 = new ArrayList();
                                        for (Object e$iv2 : $this$distinctBy$iv2) {
                                            KRepostTribeeListResp response2 = response;
                                            HashSet set$iv3 = set$iv2;
                                            if (!set$iv3.add(Boxing.boxLong(((KTribeeSelectBox.KCategory) e$iv2).getId()))) {
                                                set$iv2 = set$iv3;
                                                response = response2;
                                            } else {
                                                set$iv2 = set$iv3;
                                                ArrayList list$iv3 = list$iv2;
                                                list$iv3.add(e$iv2);
                                                list$iv2 = list$iv3;
                                                response = response2;
                                            }
                                        }
                                        KRepostTribeeListResp response3 = response;
                                        Iterable $this$map$iv2 = (List) list$iv2;
                                        Continuation $continuation2 = $continuation;
                                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                                        for (Object item$iv$iv2 : $this$map$iv2) {
                                            KTribeeSelectBox.KCategory category = (KTribeeSelectBox.KCategory) item$iv$iv2;
                                            destination$iv$iv2.add(new SelectableTribeePartition(category.getId(), category.getName()));
                                            $this$map$iv = $this$map$iv;
                                            z = z;
                                            $this$map$iv2 = $this$map$iv2;
                                        }
                                        destination$iv$iv.add(new SelectableTribeeItem(id, name, desc, picUrl, (List) destination$iv$iv2));
                                        $continuation = $continuation2;
                                        response = response3;
                                        $this$map$iv = $this$map$iv;
                                        z = z;
                                    }
                                    List items = (List) destination$iv$iv;
                                    SelectableTribeeItem selectedTribee = null;
                                    if (box.getSelectedTribeeIdx() >= 0 && box.getSelectedTribeeIdx() < tribees.size()) {
                                        selectedTribee = (SelectableTribeeItem) items.get((int) box.getSelectedTribeeIdx());
                                    }
                                    SelectableTribeePartition selectedPartition = null;
                                    if (selectedTribee != null && box.getSelectedCategoryIdx() >= 0 && box.getSelectedCategoryIdx() < selectedTribee.getPartitions().size()) {
                                        selectedPartition = selectedTribee.getPartitions().get((int) box.getSelectedCategoryIdx());
                                    }
                                    this.state.setValue(new SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState(new SelectTribeeListState(items, false, !Intrinsics.areEqual(this.next, ""), selectedTribee, selectedPartition, null, 2, null)));
                                    this.onSelectedTribeeOrPartitionChanged.invoke(TuplesKt.to(selectedTribee != null ? Boxing.boxLong(selectedTribee.getId()) : null, selectedTribee != null ? selectedTribee.getName() : null), TuplesKt.to(selectedPartition != null ? Boxing.boxLong(selectedPartition.getId()) : null, selectedPartition != null ? selectedPartition.getName() : null), Boxing.boxBoolean(false));
                                }
                            } else {
                                SelectTribeeBottomSheetViewModel $this$handleLoading_u24lambda_u241 = this;
                                $this$handleLoading_u24lambda_u241.state.setValue(new SelectTribeeBottomSheetState.SelectTribeeBottomSheetEmptyState(null, 1, null));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loading error! (" + e.getMessage() + ")");
                            this.state.setValue(SelectTribeeBottomSheetState.SelectTribeeBottomSheetErrorState.INSTANCE);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        try {
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            response = (KRepostTribeeListResp) obj;
                            this.next = response.getNext();
                            box = response.getBox();
                            if (box == null) {
                            }
                        } catch (Exception e3) {
                            e = e3;
                            KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loading error! (" + e.getMessage() + ")");
                            this.state.setValue(SelectTribeeBottomSheetState.SelectTribeeBottomSheetErrorState.INSTANCE);
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        selectTribeeBottomSheetViewModel$handleLoading$1 = new SelectTribeeBottomSheetViewModel$handleLoading$1(this, continuation);
        $continuation = selectTribeeBottomSheetViewModel$handleLoading$1;
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 38, insn: 0x02b7: MOVE  (r5 I:??[OBJECT, ARRAY]) = 
      (r38 I:??[OBJECT, ARRAY] A[D('currentState' kntr.app.tribee.repost.page.selectTribeeBottomSheet.SelectTribeeBottomSheetState)])
    , block:B:84:0x02b7 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf A[Catch: Exception -> 0x003c, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x003c, blocks: (B:13:0x0037, B:32:0x00bf), top: B:106:0x0037 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x030a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleLoadMore(Continuation<? super Unit> continuation) {
        Continuation selectTribeeBottomSheetViewModel$handleLoadMore$1;
        Continuation $continuation;
        SelectTribeeBottomSheetState currentState;
        Object nextData;
        SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState selectTribeeBottomSheetContentState;
        SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState latestState;
        SelectTribeeBottomSheetState currentState2;
        Iterable $this$map$iv;
        Object $result;
        HashSet set$iv;
        Continuation $continuation2;
        if (continuation instanceof SelectTribeeBottomSheetViewModel$handleLoadMore$1) {
            selectTribeeBottomSheetViewModel$handleLoadMore$1 = (SelectTribeeBottomSheetViewModel$handleLoadMore$1) continuation;
            if ((selectTribeeBottomSheetViewModel$handleLoadMore$1.label & Integer.MIN_VALUE) != 0) {
                selectTribeeBottomSheetViewModel$handleLoadMore$1.label -= Integer.MIN_VALUE;
                $continuation = selectTribeeBottomSheetViewModel$handleLoadMore$1;
                Object $result2 = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        currentState = (SelectTribeeBottomSheetState) this.state.getValue();
                        if (currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) {
                            if (!((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState().isLoadingMore() && ((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState().getHasMore()) {
                                this.state.setValue(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).copy(SelectTribeeListState.copy$default(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState(), null, true, false, null, null, null, 61, null)));
                                try {
                                    String str = this.next;
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                                    $continuation.label = 1;
                                    nextData = nextData(str, $continuation);
                                    if (nextData == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    try {
                                        KRepostTribeeListResp response = (KRepostTribeeListResp) nextData;
                                        this.next = response.getNext();
                                        Object value = this.state.getValue();
                                        latestState = !(value instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) ? (SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) value : null;
                                        if (latestState == null) {
                                            KTribeeSelectBox box = response.getBox();
                                            try {
                                                if (box != null) {
                                                    MutableStateFlow<SelectTribeeBottomSheetState> mutableStateFlow = this.state;
                                                    SelectTribeeListState listState = latestState.getListState();
                                                    List<SelectableTribeeItem> items = latestState.getListState().getItems();
                                                    Iterable tribees = box.getTribees();
                                                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(tribees, 10));
                                                    Iterable $this$mapTo$iv$iv = tribees;
                                                    for (Object item$iv$iv : $this$mapTo$iv$iv) {
                                                        KTribeeSelectBox.KTribee tribee = (KTribeeSelectBox.KTribee) item$iv$iv;
                                                        long id = tribee.getId();
                                                        String name = tribee.getName();
                                                        String desc = tribee.getDesc();
                                                        String picUrl = tribee.getPicUrl();
                                                        Iterable $this$distinctBy$iv = tribee.getCategories();
                                                        HashSet set$iv2 = new HashSet();
                                                        Iterable list$iv = new ArrayList();
                                                        for (Object e$iv : $this$distinctBy$iv) {
                                                            try {
                                                                set$iv = set$iv2;
                                                                $continuation2 = $continuation;
                                                            } catch (Exception e) {
                                                                e = e;
                                                            }
                                                            try {
                                                                if (set$iv.add(Boxing.boxLong(((KTribeeSelectBox.KCategory) e$iv).getId()))) {
                                                                    ArrayList list$iv2 = list$iv;
                                                                    list$iv2.add(e$iv);
                                                                    list$iv = list$iv2;
                                                                    $continuation = $continuation2;
                                                                    set$iv2 = set$iv;
                                                                } else {
                                                                    $continuation = $continuation2;
                                                                    set$iv2 = set$iv;
                                                                }
                                                            } catch (Exception e2) {
                                                                e = e2;
                                                                KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loadMore error! (" + e.getMessage() + ")");
                                                                Object value2 = this.state.getValue();
                                                                if (!(value2 instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState)) {
                                                                }
                                                                if (selectTribeeBottomSheetContentState != null) {
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        }
                                                        Continuation continuation2 = $continuation;
                                                        try {
                                                            $this$map$iv = (List) list$iv;
                                                            $result = $result2;
                                                        } catch (Exception e3) {
                                                            e = e3;
                                                        }
                                                        try {
                                                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                                            for (Object item$iv$iv2 : $this$map$iv) {
                                                                KTribeeSelectBox.KCategory category = (KTribeeSelectBox.KCategory) item$iv$iv2;
                                                                SelectTribeeBottomSheetState currentState3 = currentState;
                                                                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                                                                destination$iv$iv2.add(new SelectableTribeePartition(category.getId(), category.getName()));
                                                                currentState = currentState3;
                                                                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                                                                $this$map$iv = $this$map$iv;
                                                            }
                                                            destination$iv$iv.add(new SelectableTribeeItem(id, name, desc, picUrl, (List) destination$iv$iv2));
                                                            $result2 = $result;
                                                            $continuation = continuation2;
                                                            currentState = currentState;
                                                            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loadMore error! (" + e.getMessage() + ")");
                                                            Object value22 = this.state.getValue();
                                                            if (!(value22 instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState)) {
                                                            }
                                                            if (selectTribeeBottomSheetContentState != null) {
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }
                                                    currentState2 = currentState;
                                                    Iterable $this$distinctBy$iv2 = CollectionsKt.plus(items, (List) destination$iv$iv);
                                                    HashSet set$iv3 = new HashSet();
                                                    ArrayList list$iv3 = new ArrayList();
                                                    for (Object e$iv2 : $this$distinctBy$iv2) {
                                                        SelectableTribeeItem it = (SelectableTribeeItem) e$iv2;
                                                        if (set$iv3.add(Boxing.boxLong(it.getId()))) {
                                                            list$iv3.add(e$iv2);
                                                        }
                                                    }
                                                    mutableStateFlow.setValue(latestState.copy(SelectTribeeListState.copy$default(listState, list$iv3, false, !Intrinsics.areEqual(this.next, ""), null, null, null, 56, null)));
                                                } else {
                                                    currentState2 = currentState;
                                                    SelectTribeeBottomSheetViewModel $this$handleLoadMore_u24lambda_u240_u241 = this;
                                                    $this$handleLoadMore_u24lambda_u240_u241.state.setValue(latestState.copy(SelectTribeeListState.copy$default(latestState.getListState(), null, false, false, null, null, null, 61, null)));
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                            }
                                        } else {
                                            currentState2 = currentState;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                    }
                                } catch (Exception e7) {
                                    e = e7;
                                    KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loadMore error! (" + e.getMessage() + ")");
                                    Object value222 = this.state.getValue();
                                    selectTribeeBottomSheetContentState = !(value222 instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) ? (SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) value222 : null;
                                    if (selectTribeeBottomSheetContentState != null) {
                                        SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState latestState2 = selectTribeeBottomSheetContentState;
                                        this.state.setValue(latestState2.copy(SelectTribeeListState.copy$default(latestState2.getListState(), null, false, false, null, null, null, 61, null)));
                                    }
                                    return Unit.INSTANCE;
                                }
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    case 1:
                        currentState = (SelectTribeeBottomSheetState) $continuation.L$0;
                        try {
                            ResultKt.throwOnFailure($result2);
                            nextData = $result2;
                            KRepostTribeeListResp response2 = (KRepostTribeeListResp) nextData;
                            this.next = response2.getNext();
                            Object value3 = this.state.getValue();
                            if (!(value3 instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState)) {
                            }
                            if (latestState == null) {
                            }
                        } catch (Exception e8) {
                            e = e8;
                            KLog_androidKt.getKLog().e("SelectTribeeBottomSheetViewModel", "loadMore error! (" + e.getMessage() + ")");
                            Object value2222 = this.state.getValue();
                            if (!(value2222 instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState)) {
                            }
                            if (selectTribeeBottomSheetContentState != null) {
                            }
                            return Unit.INSTANCE;
                        }
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        selectTribeeBottomSheetViewModel$handleLoadMore$1 = new SelectTribeeBottomSheetViewModel$handleLoadMore$1(this, continuation);
        $continuation = selectTribeeBottomSheetViewModel$handleLoadMore$1;
        Object $result22 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
    }

    private final void cancelLoadMoreJobIfNeed() {
        if (this.loadMoreJob != null) {
            Job job = this.loadMoreJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.loadMoreJob = null;
            Object value = this.state.getValue();
            SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState selectTribeeBottomSheetContentState = value instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState ? (SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) value : null;
            if (selectTribeeBottomSheetContentState != null) {
                SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState latestState = selectTribeeBottomSheetContentState;
                this.state.setValue(latestState.copy(SelectTribeeListState.copy$default(latestState.getListState(), null, false, false, null, null, null, 61, null)));
            }
        }
    }

    private final void handleSelectTribeeOrPartition(SelectableTribeeItem tribee, SelectableTribeePartition partition) {
        SelectTribeeBottomSheetState currentState = (SelectTribeeBottomSheetState) this.state.getValue();
        if (currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) {
            SelectableTribeePartition selectedPartition = partition;
            if (tribee != null && partition == null && !tribee.getPartitions().isEmpty() && ((int) ((SelectableTribeePartition) CollectionsKt.first(tribee.getPartitions())).getId()) == 0) {
                selectedPartition = (SelectableTribeePartition) CollectionsKt.first(tribee.getPartitions());
            }
            this.state.setValue(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).copy(SelectTribeeListState.copy$default(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState(), null, false, false, tribee, selectedPartition, null, 39, null)));
            this.onSelectedTribeeOrPartitionChanged.invoke(TuplesKt.to(tribee != null ? Long.valueOf(tribee.getId()) : null, tribee != null ? tribee.getName() : null), TuplesKt.to(selectedPartition != null ? Long.valueOf(selectedPartition.getId()) : null, selectedPartition != null ? selectedPartition.getName() : null), true);
            if (tribee != null && tribee.getPartitions().isEmpty()) {
                this.onDismiss.invoke();
            } else if (partition != null) {
                this.onDismiss.invoke();
            }
        }
    }

    private final void handleSaveListScrollPosition(SelectTribeeListScrollPosition listScrollPosition) {
        SelectTribeeBottomSheetState currentState = (SelectTribeeBottomSheetState) this.state.getValue();
        if (currentState instanceof SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) {
            this.state.setValue(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).copy(SelectTribeeListState.copy$default(((SelectTribeeBottomSheetState.SelectTribeeBottomSheetContentState) currentState).getListState(), null, false, false, null, null, listScrollPosition, 31, null)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object initialData(Continuation<? super KRepostTribeeListResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).repostTribeeList(new KRepostTribeeListReq(new KPagination(0, (String) null, 3, (DefaultConstructorMarker) null), ((Number) this.getDefaultSelectedTribeeIdHandler.invoke()).longValue()), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object nextData(String next, Continuation<? super KRepostTribeeListResp> continuation) {
        return new KTribeeMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).repostTribeeList(new KRepostTribeeListReq(new KPagination(20, next), ((Number) this.getDefaultSelectedTribeeIdHandler.invoke()).longValue()), continuation);
    }
}