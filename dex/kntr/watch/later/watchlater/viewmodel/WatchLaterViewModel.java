package kntr.watch.later.watchlater.viewmodel;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KApiResponseKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.base.router.Router;
import kntr.common.router.UrisKt;
import kntr.watch.later.watchlater.DialogInfo;
import kntr.watch.later.watchlater.api.TranslateApiKt;
import kntr.watch.later.watchlater.api.WatchLaterApiKt;
import kntr.watch.later.watchlater.consts.WatchLaterConstsKt;
import kntr.watch.later.watchlater.consts.WatchLaterConsts_androidKt;
import kntr.watch.later.watchlater.data.DialogType;
import kntr.watch.later.watchlater.data.FavEditState;
import kntr.watch.later.watchlater.data.PageState;
import kntr.watch.later.watchlater.data.ToastType;
import kntr.watch.later.watchlater.data.WLAction;
import kntr.watch.later.watchlater.data.WLEvent;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kntr.watch.later.watchlater.data.WatchLaterList;
import kntr.watch.later.watchlater.data.WatchLaterResponse;
import kntr.watch.later.watchlater.data.WatchLaterState;
import kntr.watch.later.watchlater.data.WatchLaterTabState;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010+\u001a\u00020\u0002H\u0016J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0002H\u0014J\u0006\u00101\u001a\u00020-J\u0016\u00102\u001a\u00020-2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\fJ\u000e\u00105\u001a\u00020-2\u0006\u00103\u001a\u00020\u0007J\u0006\u00106\u001a\u00020-J\u000e\u00107\u001a\u00020-2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020-J\u000e\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020-2\u0006\u00103\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020-2\u0006\u00103\u001a\u00020\u0007J\u000e\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020EJ\u000e\u0010F\u001a\u00020-2\u0006\u0010D\u001a\u00020EJ\u000e\u0010G\u001a\u00020-2\u0006\u0010<\u001a\u00020=J$\u0010H\u001a\u00020-2\u0006\u0010<\u001a\u00020=2\u0006\u0010I\u001a\u00020\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010@H\u0002J\u0016\u0010K\u001a\u00020-2\u0006\u00103\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010LJ\u000e\u0010M\u001a\u00020-2\u0006\u0010N\u001a\u00020OJ\u000e\u0010P\u001a\u00020-2\u0006\u0010Q\u001a\u00020\u0007J\b\u0010R\u001a\u00020-H\u0002J*\u0010S\u001a\u00020-2\u0006\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\f2\b\b\u0002\u0010T\u001a\u00020\fH\u0082@¢\u0006\u0002\u0010UJ\u0016\u0010V\u001a\u00020-2\u0006\u0010W\u001a\u00020\u0007H\u0082@¢\u0006\u0002\u0010LJ\u0016\u0010X\u001a\u00020-2\u0006\u0010Y\u001a\u00020@H\u0082@¢\u0006\u0002\u0010ZJ\u0018\u0010[\u001a\u00020-2\u0006\u00103\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020-2\u0006\u00103\u001a\u00020\u0007H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\"\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020&\u0018\u00010%0\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010#¨\u0006_"}, d2 = {"Lkntr/watch/later/watchlater/viewmodel/WatchLaterViewModel;", "Lkntr/watch/later/watchlater/viewmodel/WatchLaterBaseViewModel;", "Lkntr/watch/later/watchlater/data/WatchLaterState;", "<init>", "()V", "curPageIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "requestParam", "Lkntr/watch/later/watchlater/viewmodel/WatchLaterRequestParam;", "pageFirstLoad", "", "", "buttonClickable", "Lkotlinx/coroutines/flow/Flow;", "getButtonClickable", "()Lkotlinx/coroutines/flow/Flow;", "<set-?>", "Landroidx/compose/foundation/lazy/LazyListState;", "tabAllListState", "getTabAllListState", "()Landroidx/compose/foundation/lazy/LazyListState;", "setTabAllListState", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "tabAllListState$delegate", "Landroidx/compose/runtime/MutableState;", "tabToViewListState", "getTabToViewListState", "setTabToViewListState", "tabToViewListState$delegate", "isTabAllLoading", "isTabToViewLoading", "dialogInfo", "Lkntr/watch/later/watchlater/DialogInfo;", "getDialogInfo", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "bottomSheetItems", "", "LBottomSheetItemData;", "getBottomSheetItems$watch_later_debug", "favEditState", "Lkntr/watch/later/watchlater/data/FavEditState;", "getFavEditState", "initialState", "onAction", "", "action", "Lkntr/watch/later/watchlater/data/WLAction;", "state", "onSortClick", "load", "pageIndex", "isLoadMore", "refresh", "changeCheckState", "deleteItem", "aid", "", "onManageClick", "onThreePointClick", "item", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "onCardCheckClick", "itemId", "", "onCheckAll", "onCancelAll", "showDialog", "dialogType", "Lkntr/watch/later/watchlater/data/DialogType;", "onDialogConfirm", "switchTranslate", "updateItemTranslateState", "status", "translatedTitle", "onTabClick", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jumpPlayList", "router", "Lkntr/base/router/Router;", "onClickBatchOP", "opType", "dismissFavEdit", "requestData", "isRefresh", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanVideo", "cleanType", "deleteVideos", "resource", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetRequestParams", "response", "Lkntr/watch/later/watchlater/data/WatchLaterResponse;", "resetStartKey", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterViewModel extends WatchLaterBaseViewModel<WatchLaterState> {
    public static final int $stable = 8;
    private boolean isTabAllLoading;
    private boolean isTabToViewLoading;
    private MutableStateFlow<Integer> curPageIndex = StateFlowKt.MutableStateFlow(Integer.valueOf(WatchLaterConsts_androidKt.getWatchLaterInitialPageIndex()));
    private WatchLaterRequestParam requestParam = new WatchLaterRequestParam(null, null, null, 7, null);
    private final Map<Integer, Boolean> pageFirstLoad = new LinkedHashMap();
    private final Flow<Boolean> buttonClickable = FlowKt.conflate(FlowKt.distinctUntilChanged(FlowKt.combine(this.curPageIndex, getWatchLaterState(), new WatchLaterViewModel$buttonClickable$1(null))));
    private final MutableState tabAllListState$delegate = SnapshotStateKt.mutableStateOf$default(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState tabToViewListState$delegate = SnapshotStateKt.mutableStateOf$default(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableStateFlow<DialogInfo> dialogInfo = StateFlowKt.MutableStateFlow((Object) null);
    private final MutableStateFlow<List<BottomSheetItemData>> bottomSheetItems = StateFlowKt.MutableStateFlow((Object) null);
    private final MutableStateFlow<FavEditState> favEditState = StateFlowKt.MutableStateFlow((Object) null);

    public WatchLaterViewModel() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final Flow<Boolean> getButtonClickable() {
        return this.buttonClickable;
    }

    public final LazyListState getTabAllListState() {
        State $this$getValue$iv = this.tabAllListState$delegate;
        return (LazyListState) $this$getValue$iv.getValue();
    }

    public final void setTabAllListState(LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(lazyListState, "<set-?>");
        MutableState $this$setValue$iv = this.tabAllListState$delegate;
        $this$setValue$iv.setValue(lazyListState);
    }

    public final LazyListState getTabToViewListState() {
        State $this$getValue$iv = this.tabToViewListState$delegate;
        return (LazyListState) $this$getValue$iv.getValue();
    }

    public final void setTabToViewListState(LazyListState lazyListState) {
        Intrinsics.checkNotNullParameter(lazyListState, "<set-?>");
        MutableState $this$setValue$iv = this.tabToViewListState$delegate;
        $this$setValue$iv.setValue(lazyListState);
    }

    public final MutableStateFlow<DialogInfo> getDialogInfo() {
        return this.dialogInfo;
    }

    public final MutableStateFlow<List<BottomSheetItemData>> getBottomSheetItems$watch_later_debug() {
        return this.bottomSheetItems;
    }

    public final MutableStateFlow<FavEditState> getFavEditState() {
        return this.favEditState;
    }

    /* compiled from: WatchLaterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$1", f = "WatchLaterViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    MutableStateFlow mutableStateFlow = WatchLaterViewModel.this.curPageIndex;
                    final WatchLaterViewModel watchLaterViewModel = WatchLaterViewModel.this;
                    this.label = 1;
                    if (mutableStateFlow.collect(new FlowCollector() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit(((Number) value).intValue(), $completion);
                        }

                        public final Object emit(int pageIndex, Continuation<? super Unit> continuation) {
                            if (!Intrinsics.areEqual(WatchLaterViewModel.this.pageFirstLoad.get(Boxing.boxInt(pageIndex)), Boxing.boxBoolean(true))) {
                                WatchLaterViewModel.this.pageFirstLoad.put(Boxing.boxInt(pageIndex), Boxing.boxBoolean(true));
                                WatchLaterViewModel.this.load(pageIndex, false);
                                return Unit.INSTANCE;
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kntr.watch.later.watchlater.viewmodel.WatchLaterBaseViewModel
    public WatchLaterState initialState() {
        return new WatchLaterState(null, null, false, false, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kntr.watch.later.watchlater.viewmodel.WatchLaterBaseViewModel
    public void onAction(final WLAction action, WatchLaterState state) {
        WatchLaterTabState watchLaterTabState;
        WatchLaterTabState watchLaterTabState2;
        WatchLaterState result;
        WatchLaterTabState tabAll;
        WatchLaterTabState tabToView;
        WatchLaterItem copy;
        WatchLaterItem copy2;
        Iterable $this$all$iv;
        WatchLaterTabState tabAll2;
        WatchLaterTabState tabToView2;
        WatchLaterItem copy3;
        WatchLaterItem copy4;
        WatchLaterTabState tabAll3;
        WatchLaterTabState tabToView3;
        WatchLaterItem watchLaterItem;
        WatchLaterItem watchLaterItem2;
        WatchLaterTabState watchLaterTabState3;
        WatchLaterTabState watchLaterTabState4;
        List it;
        List it2;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        if (action instanceof WLAction.LoadAction) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$1$1(this, action, null), 3, (Object) null);
        } else if (action instanceof WLAction.RefreshAction) {
            WatchLaterRequestParam $this$onAction_u24lambda_u241_u240 = this.requestParam;
            $this$onAction_u24lambda_u241_u240.getStartKey().set(((WLAction.RefreshAction) action).getPageIndex(), "");
            this.requestParam = $this$onAction_u24lambda_u241_u240;
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$2$2(this, action, null), 3, (Object) null);
        } else {
            if (action instanceof WLAction.LoadCompleteAction) {
                List list = new ArrayList();
                if (((WLAction.LoadCompleteAction) action).getPageIndex() == 0) {
                    if (((WLAction.LoadCompleteAction) action).isLoadMore()) {
                        list.addAll(state.getTabAll().getData().getList());
                    }
                    WatchLaterResponse response = ((WLAction.LoadCompleteAction) action).getResponse();
                    if (response != null && (it2 = response.getList()) != null) {
                        Boolean.valueOf(list.addAll(it2));
                    }
                    WatchLaterTabState tabAll4 = state.getTabAll();
                    WatchLaterList copy5 = state.getTabAll().getData().copy(list);
                    PageState pageState = list.isEmpty() ? PageState.Empty.INSTANCE : PageState.Success.INSTANCE;
                    WatchLaterResponse response2 = ((WLAction.LoadCompleteAction) action).getResponse();
                    String playUrl = response2 != null ? response2.getPlayUrl() : null;
                    boolean isLoadMore = ((WLAction.LoadCompleteAction) action).isLoadMore();
                    WatchLaterResponse response3 = ((WLAction.LoadCompleteAction) action).getResponse();
                    result = WatchLaterState.copy$default(state, tabAll4.copy(copy5, pageState, playUrl, isLoadMore, false, response3 != null ? response3.getHasMore() : false), null, false, false, 14, null);
                } else {
                    if (((WLAction.LoadCompleteAction) action).isLoadMore()) {
                        list.addAll(state.getTabToView().getData().getList());
                    }
                    WatchLaterResponse response4 = ((WLAction.LoadCompleteAction) action).getResponse();
                    if (response4 != null && (it = response4.getList()) != null) {
                        Boolean.valueOf(list.addAll(it));
                    }
                    WatchLaterTabState tabToView4 = state.getTabToView();
                    WatchLaterList copy6 = state.getTabToView().getData().copy(list);
                    PageState pageState2 = list.isEmpty() ? PageState.Empty.INSTANCE : PageState.Success.INSTANCE;
                    WatchLaterResponse response5 = ((WLAction.LoadCompleteAction) action).getResponse();
                    String playUrl2 = response5 != null ? response5.getPlayUrl() : null;
                    boolean isLoadMore2 = ((WLAction.LoadCompleteAction) action).isLoadMore();
                    WatchLaterResponse response6 = ((WLAction.LoadCompleteAction) action).getResponse();
                    result = WatchLaterState.copy$default(state, null, tabToView4.copy(copy6, pageState2, playUrl2, isLoadMore2, false, response6 != null ? response6.getHasMore() : false), false, false, 13, null);
                }
            } else if (action instanceof WLAction.LoadError) {
                result = ((WLAction.LoadError) action).getPageIndex() == 0 ? WatchLaterState.copy$default(state, WatchLaterTabState.copy$default(state.getTabAll(), null, ((WLAction.LoadError) action).isLoadMore() ? state.getTabAll().getPageState() : PageState.Error.INSTANCE, null, ((WLAction.LoadError) action).isLoadMore(), false, false, 53, null), null, false, false, 14, null) : WatchLaterState.copy$default(state, null, WatchLaterTabState.copy$default(state.getTabToView(), null, ((WLAction.LoadError) action).isLoadMore() ? state.getTabToView().getPageState() : PageState.Error.INSTANCE, null, ((WLAction.LoadError) action).isLoadMore(), false, false, 53, null), false, false, 13, null);
            } else if (action instanceof WLAction.RefreshError) {
                emitEvent(new WatchLaterViewModel$onAction$result$5(null));
                result = ((WLAction.RefreshError) action).getPageIndex() == 0 ? WatchLaterState.copy$default(state, WatchLaterTabState.copy$default(state.getTabAll(), null, null, null, false, false, false, 47, null), null, false, false, 14, null) : WatchLaterState.copy$default(state, null, WatchLaterTabState.copy$default(state.getTabToView(), null, null, null, false, false, false, 47, null), false, false, 13, null);
            } else if (action instanceof WLAction.Loading) {
                result = ((WLAction.Loading) action).getPageIndex() == 0 ? WatchLaterState.copy$default(state, WatchLaterTabState.copy$default(state.getTabAll(), null, ((WLAction.Loading) action).isLoadMore() ? state.getTabAll().getPageState() : PageState.Loading.INSTANCE, null, ((WLAction.Loading) action).isLoadMore(), false, false, 53, null), null, false, false, 14, null) : WatchLaterState.copy$default(state, null, WatchLaterTabState.copy$default(state.getTabToView(), null, ((WLAction.Loading) action).isLoadMore() ? state.getTabToView().getPageState() : PageState.Loading.INSTANCE, null, ((WLAction.Loading) action).isLoadMore(), false, false, 53, null), false, false, 13, null);
            } else if (action instanceof WLAction.Refreshing) {
                result = ((WLAction.Refreshing) action).getPageIndex() == 0 ? WatchLaterState.copy$default(state, WatchLaterTabState.copy$default(state.getTabAll(), null, null, null, false, true, false, 47, null), null, false, false, 14, null) : WatchLaterState.copy$default(state, null, WatchLaterTabState.copy$default(state.getTabToView(), null, null, null, false, true, false, 47, null), false, false, 13, null);
            } else {
                boolean z = true;
                if (Intrinsics.areEqual(action, WLAction.ChangeCheckState.INSTANCE)) {
                    result = WatchLaterState.copy$default(state, null, null, !state.isCheckMode(), false, 11, null);
                    if (state.isCheckMode()) {
                        sendAction(new WLAction.CancelAll(((Number) this.curPageIndex.getValue()).intValue()));
                    }
                } else if (Intrinsics.areEqual(action, WLAction.SortAction.INSTANCE)) {
                    result = WatchLaterState.copy$default(state, new WatchLaterTabState(null, null, null, false, false, false, 63, null), new WatchLaterTabState(null, null, null, false, false, false, 63, null), false, !state.getAsc(), 4, null);
                    sendAction(new WLAction.LoadAction(((Number) this.curPageIndex.getValue()).intValue(), false));
                    this.pageFirstLoad.put(Integer.valueOf(((Number) this.curPageIndex.getValue()).intValue() ^ 1), false);
                } else if (!(action instanceof WLAction.DeleteChecked)) {
                    if (Intrinsics.areEqual(action, WLAction.DeleteInvalid.INSTANCE)) {
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$9$1(this, null), 3, (Object) null);
                    } else if (Intrinsics.areEqual(action, WLAction.DeleteWatched.INSTANCE)) {
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$10$1(this, null), 3, (Object) null);
                    } else if (action instanceof WLAction.ChangeCardCheckState) {
                        if (((WLAction.ChangeCardCheckState) action).getPageIndex() == 0) {
                            WatchLaterTabState tabAll5 = state.getTabAll();
                            WatchLaterList data = state.getTabAll().getData();
                            Iterable $this$map$iv = state.getTabAll().getData().getList();
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                WatchLaterItem item = (WatchLaterItem) item$iv$iv;
                                if (Intrinsics.areEqual(item.getItemId(), ((WLAction.ChangeCardCheckState) action).getItemId())) {
                                    watchLaterItem2 = item.copy((r41 & 1) != 0 ? item.cardType : 0, (r41 & 2) != 0 ? item.aid : 0L, (r41 & 4) != 0 ? item.title : null, (r41 & 8) != 0 ? item.intro : null, (r41 & 16) != 0 ? item.pic : null, (r41 & 32) != 0 ? item.duration : 0L, (r41 & 64) != 0 ? item.progress : 0L, (r41 & 128) != 0 ? item.uri : null, (r41 & 256) != 0 ? item.arcState : 0, (r41 & 512) != 0 ? item.pgcLabel : null, (r41 & 1024) != 0 ? item.showUp : false, (r41 & 2048) != 0 ? item.forbidFav : false, (r41 & 4096) != 0 ? item.owner : null, (r41 & 8192) != 0 ? item.leftIconType : 0, (r41 & 16384) != 0 ? item.leftText : null, (r41 & 32768) != 0 ? item.rightIconType : 0, (r41 & 65536) != 0 ? item.rightText : null, (r41 & 131072) != 0 ? item.translateInfo : null, (r41 & 262144) != 0 ? item.isChecked : !item.isChecked(), (r41 & 524288) != 0 ? item.itemId : null);
                                } else {
                                    watchLaterItem2 = item;
                                }
                                destination$iv$iv.add(watchLaterItem2);
                            }
                            tabAll3 = WatchLaterTabState.copy$default(tabAll5, data.copy((List) destination$iv$iv), null, null, false, false, false, 62, null);
                        } else {
                            tabAll3 = state.getTabAll();
                        }
                        if (((WLAction.ChangeCardCheckState) action).getPageIndex() == 1) {
                            WatchLaterTabState tabToView5 = state.getTabToView();
                            WatchLaterList data2 = state.getTabToView().getData();
                            Iterable $this$map$iv2 = state.getTabToView().getData().getList();
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            for (Object item$iv$iv2 : $this$map$iv2) {
                                WatchLaterItem item2 = (WatchLaterItem) item$iv$iv2;
                                if (Intrinsics.areEqual(item2.getItemId(), ((WLAction.ChangeCardCheckState) action).getItemId())) {
                                    watchLaterItem = item2.copy((r41 & 1) != 0 ? item2.cardType : 0, (r41 & 2) != 0 ? item2.aid : 0L, (r41 & 4) != 0 ? item2.title : null, (r41 & 8) != 0 ? item2.intro : null, (r41 & 16) != 0 ? item2.pic : null, (r41 & 32) != 0 ? item2.duration : 0L, (r41 & 64) != 0 ? item2.progress : 0L, (r41 & 128) != 0 ? item2.uri : null, (r41 & 256) != 0 ? item2.arcState : 0, (r41 & 512) != 0 ? item2.pgcLabel : null, (r41 & 1024) != 0 ? item2.showUp : false, (r41 & 2048) != 0 ? item2.forbidFav : false, (r41 & 4096) != 0 ? item2.owner : null, (r41 & 8192) != 0 ? item2.leftIconType : 0, (r41 & 16384) != 0 ? item2.leftText : null, (r41 & 32768) != 0 ? item2.rightIconType : 0, (r41 & 65536) != 0 ? item2.rightText : null, (r41 & 131072) != 0 ? item2.translateInfo : null, (r41 & 262144) != 0 ? item2.isChecked : !item2.isChecked(), (r41 & 524288) != 0 ? item2.itemId : null);
                                } else {
                                    watchLaterItem = item2;
                                }
                                destination$iv$iv2.add(watchLaterItem);
                            }
                            tabToView3 = WatchLaterTabState.copy$default(tabToView5, data2.copy((List) destination$iv$iv2), null, null, false, false, false, 62, null);
                        } else {
                            tabToView3 = state.getTabToView();
                        }
                        result = WatchLaterState.copy$default(state, tabAll3, tabToView3, false, false, 12, null);
                    } else if (action instanceof WLAction.CheckAll) {
                        if (((WLAction.CheckAll) action).getPageIndex() == 0) {
                            Iterable $this$all$iv2 = state.getTabAll().getData().getList();
                            if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
                                Iterator<T> it3 = $this$all$iv2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        Object element$iv = it3.next();
                                        if (!((WatchLaterItem) element$iv).isChecked()) {
                                            $this$all$iv = null;
                                            break;
                                        }
                                    } else {
                                        $this$all$iv = 1;
                                        break;
                                    }
                                }
                            } else {
                                $this$all$iv = 1;
                            }
                        } else {
                            Iterable $this$all$iv3 = state.getTabToView().getData().getList();
                            if (!($this$all$iv3 instanceof Collection) || !((Collection) $this$all$iv3).isEmpty()) {
                                Iterator<T> it4 = $this$all$iv3.iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        Object element$iv2 = it4.next();
                                        if (!((WatchLaterItem) element$iv2).isChecked()) {
                                            $this$all$iv = null;
                                            break;
                                        }
                                    } else {
                                        $this$all$iv = 1;
                                        break;
                                    }
                                }
                            } else {
                                $this$all$iv = 1;
                            }
                        }
                        Iterable allChecked = $this$all$iv;
                        if (((WLAction.CheckAll) action).getPageIndex() == 0) {
                            WatchLaterTabState tabAll6 = state.getTabAll();
                            WatchLaterList data3 = state.getTabAll().getData();
                            Iterable $this$map$iv3 = state.getTabAll().getData().getList();
                            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                            for (Object item$iv$iv3 : $this$map$iv3) {
                                WatchLaterItem it5 = (WatchLaterItem) item$iv$iv3;
                                if (it5.isChecked() == (allChecked == null)) {
                                    copy4 = it5;
                                } else {
                                    copy4 = it5.copy((r41 & 1) != 0 ? it5.cardType : 0, (r41 & 2) != 0 ? it5.aid : 0L, (r41 & 4) != 0 ? it5.title : null, (r41 & 8) != 0 ? it5.intro : null, (r41 & 16) != 0 ? it5.pic : null, (r41 & 32) != 0 ? it5.duration : 0L, (r41 & 64) != 0 ? it5.progress : 0L, (r41 & 128) != 0 ? it5.uri : null, (r41 & 256) != 0 ? it5.arcState : 0, (r41 & 512) != 0 ? it5.pgcLabel : null, (r41 & 1024) != 0 ? it5.showUp : false, (r41 & 2048) != 0 ? it5.forbidFav : false, (r41 & 4096) != 0 ? it5.owner : null, (r41 & 8192) != 0 ? it5.leftIconType : 0, (r41 & 16384) != 0 ? it5.leftText : null, (r41 & 32768) != 0 ? it5.rightIconType : 0, (r41 & 65536) != 0 ? it5.rightText : null, (r41 & 131072) != 0 ? it5.translateInfo : null, (r41 & 262144) != 0 ? it5.isChecked : allChecked == null, (r41 & 524288) != 0 ? it5.itemId : null);
                                }
                                destination$iv$iv3.add(copy4);
                            }
                            tabAll2 = WatchLaterTabState.copy$default(tabAll6, data3.copy((List) destination$iv$iv3), null, null, false, false, false, 62, null);
                        } else {
                            tabAll2 = state.getTabAll();
                        }
                        if (((WLAction.CheckAll) action).getPageIndex() == 1) {
                            WatchLaterTabState tabToView6 = state.getTabToView();
                            WatchLaterList data4 = state.getTabToView().getData();
                            Iterable $this$map$iv4 = state.getTabToView().getData().getList();
                            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                            for (Object item$iv$iv4 : $this$map$iv4) {
                                WatchLaterItem it6 = (WatchLaterItem) item$iv$iv4;
                                boolean isChecked = it6.isChecked();
                                if (allChecked != null) {
                                    z = false;
                                }
                                if (isChecked == z) {
                                    copy3 = it6;
                                } else {
                                    copy3 = it6.copy((r41 & 1) != 0 ? it6.cardType : 0, (r41 & 2) != 0 ? it6.aid : 0L, (r41 & 4) != 0 ? it6.title : null, (r41 & 8) != 0 ? it6.intro : null, (r41 & 16) != 0 ? it6.pic : null, (r41 & 32) != 0 ? it6.duration : 0L, (r41 & 64) != 0 ? it6.progress : 0L, (r41 & 128) != 0 ? it6.uri : null, (r41 & 256) != 0 ? it6.arcState : 0, (r41 & 512) != 0 ? it6.pgcLabel : null, (r41 & 1024) != 0 ? it6.showUp : false, (r41 & 2048) != 0 ? it6.forbidFav : false, (r41 & 4096) != 0 ? it6.owner : null, (r41 & 8192) != 0 ? it6.leftIconType : 0, (r41 & 16384) != 0 ? it6.leftText : null, (r41 & 32768) != 0 ? it6.rightIconType : 0, (r41 & 65536) != 0 ? it6.rightText : null, (r41 & 131072) != 0 ? it6.translateInfo : null, (r41 & 262144) != 0 ? it6.isChecked : allChecked == null, (r41 & 524288) != 0 ? it6.itemId : null);
                                }
                                destination$iv$iv4.add(copy3);
                                z = true;
                            }
                            tabToView2 = WatchLaterTabState.copy$default(tabToView6, data4.copy((List) destination$iv$iv4), null, null, false, false, false, 62, null);
                        } else {
                            tabToView2 = state.getTabToView();
                        }
                        result = WatchLaterState.copy$default(state, tabAll2, tabToView2, false, false, 12, null);
                    } else if (action instanceof WLAction.CancelAll) {
                        if (((WLAction.CancelAll) action).getPageIndex() == 0) {
                            WatchLaterTabState tabAll7 = state.getTabAll();
                            WatchLaterList data5 = state.getTabAll().getData();
                            Iterable $this$map$iv5 = state.getTabAll().getData().getList();
                            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv5, 10));
                            for (Object item$iv$iv5 : $this$map$iv5) {
                                WatchLaterItem it7 = (WatchLaterItem) item$iv$iv5;
                                if (!it7.isChecked()) {
                                    copy2 = it7;
                                } else {
                                    copy2 = it7.copy((r41 & 1) != 0 ? it7.cardType : 0, (r41 & 2) != 0 ? it7.aid : 0L, (r41 & 4) != 0 ? it7.title : null, (r41 & 8) != 0 ? it7.intro : null, (r41 & 16) != 0 ? it7.pic : null, (r41 & 32) != 0 ? it7.duration : 0L, (r41 & 64) != 0 ? it7.progress : 0L, (r41 & 128) != 0 ? it7.uri : null, (r41 & 256) != 0 ? it7.arcState : 0, (r41 & 512) != 0 ? it7.pgcLabel : null, (r41 & 1024) != 0 ? it7.showUp : false, (r41 & 2048) != 0 ? it7.forbidFav : false, (r41 & 4096) != 0 ? it7.owner : null, (r41 & 8192) != 0 ? it7.leftIconType : 0, (r41 & 16384) != 0 ? it7.leftText : null, (r41 & 32768) != 0 ? it7.rightIconType : 0, (r41 & 65536) != 0 ? it7.rightText : null, (r41 & 131072) != 0 ? it7.translateInfo : null, (r41 & 262144) != 0 ? it7.isChecked : false, (r41 & 524288) != 0 ? it7.itemId : null);
                                }
                                destination$iv$iv5.add(copy2);
                            }
                            tabAll = WatchLaterTabState.copy$default(tabAll7, data5.copy((List) destination$iv$iv5), null, null, false, false, false, 62, null);
                        } else {
                            tabAll = state.getTabAll();
                        }
                        if (((WLAction.CancelAll) action).getPageIndex() == 1) {
                            WatchLaterTabState tabToView7 = state.getTabToView();
                            WatchLaterList data6 = state.getTabToView().getData();
                            Iterable $this$map$iv6 = state.getTabToView().getData().getList();
                            Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv6, 10));
                            for (Object item$iv$iv6 : $this$map$iv6) {
                                WatchLaterItem it8 = (WatchLaterItem) item$iv$iv6;
                                if (!it8.isChecked()) {
                                    copy = it8;
                                } else {
                                    copy = it8.copy((r41 & 1) != 0 ? it8.cardType : 0, (r41 & 2) != 0 ? it8.aid : 0L, (r41 & 4) != 0 ? it8.title : null, (r41 & 8) != 0 ? it8.intro : null, (r41 & 16) != 0 ? it8.pic : null, (r41 & 32) != 0 ? it8.duration : 0L, (r41 & 64) != 0 ? it8.progress : 0L, (r41 & 128) != 0 ? it8.uri : null, (r41 & 256) != 0 ? it8.arcState : 0, (r41 & 512) != 0 ? it8.pgcLabel : null, (r41 & 1024) != 0 ? it8.showUp : false, (r41 & 2048) != 0 ? it8.forbidFav : false, (r41 & 4096) != 0 ? it8.owner : null, (r41 & 8192) != 0 ? it8.leftIconType : 0, (r41 & 16384) != 0 ? it8.leftText : null, (r41 & 32768) != 0 ? it8.rightIconType : 0, (r41 & 65536) != 0 ? it8.rightText : null, (r41 & 131072) != 0 ? it8.translateInfo : null, (r41 & 262144) != 0 ? it8.isChecked : false, (r41 & 524288) != 0 ? it8.itemId : null);
                                }
                                destination$iv$iv6.add(copy);
                            }
                            tabToView = WatchLaterTabState.copy$default(tabToView7, data6.copy((List) destination$iv$iv6), null, null, false, false, false, 62, null);
                        } else {
                            tabToView = state.getTabToView();
                        }
                        result = WatchLaterState.copy$default(state, tabAll, tabToView, false, false, 12, null);
                    } else if (!(action instanceof WLAction.DeleteItem)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        WatchLaterTabState tabAll8 = WatchLaterTabState.copy$default(state.getTabAll(), state.getTabAll().getData().copy(WatchLaterViewModelKt.filterNotItem(state.getTabAll().getData().getList(), new Function1() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj) {
                                boolean onAction$lambda$21;
                                onAction$lambda$21 = WatchLaterViewModel.onAction$lambda$21(WLAction.this, (WatchLaterItem) obj);
                                return Boolean.valueOf(onAction$lambda$21);
                            }
                        })), null, null, false, false, false, 62, null);
                        WatchLaterTabState tabToView8 = WatchLaterTabState.copy$default(state.getTabToView(), state.getTabToView().getData().copy(WatchLaterViewModelKt.filterNotItem(state.getTabToView().getData().getList(), new Function1() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda3
                            public final Object invoke(Object obj) {
                                boolean onAction$lambda$22;
                                onAction$lambda$22 = WatchLaterViewModel.onAction$lambda$22(WLAction.this, (WatchLaterItem) obj);
                                return Boolean.valueOf(onAction$lambda$22);
                            }
                        })), null, null, false, false, false, 62, null);
                        if (tabAll8.getData().getList().isEmpty() && !tabAll8.getHasMore()) {
                            watchLaterTabState = WatchLaterTabState.copy$default(tabAll8, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null);
                        } else {
                            watchLaterTabState = tabAll8;
                        }
                        if (tabToView8.getData().getList().isEmpty() && !tabToView8.getHasMore()) {
                            watchLaterTabState2 = WatchLaterTabState.copy$default(tabToView8, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null);
                        } else {
                            watchLaterTabState2 = tabToView8;
                        }
                        result = WatchLaterState.copy$default(state, watchLaterTabState, watchLaterTabState2, false, false, 12, null);
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$17$1(this, state, action, null), 3, (Object) null);
                    }
                } else {
                    Iterable $this$filter$iv = (((Number) this.curPageIndex.getValue()).intValue() == 0 ? state.getTabAll() : state.getTabToView()).getData().getList();
                    Collection destination$iv$iv7 = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        if (((WatchLaterItem) element$iv$iv).isChecked()) {
                            destination$iv$iv7.add(element$iv$iv);
                        }
                    }
                    List deleteList = (List) destination$iv$iv7;
                    List $this$map$iv7 = deleteList;
                    Collection destination$iv$iv8 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv7, 10));
                    for (Object item$iv$iv7 : $this$map$iv7) {
                        destination$iv$iv8.add(Long.valueOf(((WatchLaterItem) item$iv$iv7).getAid()));
                    }
                    final List deleteAidList = (List) destination$iv$iv8;
                    WatchLaterTabState tabAll9 = WatchLaterTabState.copy$default(state.getTabAll(), state.getTabAll().getData().copy(WatchLaterViewModelKt.filterNotItem(state.getTabAll().getData().getList(), new Function1() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            boolean onAction$lambda$8;
                            onAction$lambda$8 = WatchLaterViewModel.onAction$lambda$8(WLAction.this, deleteAidList, (WatchLaterItem) obj);
                            return Boolean.valueOf(onAction$lambda$8);
                        }
                    })), null, null, false, false, false, 62, null);
                    WatchLaterTabState tabToView9 = WatchLaterTabState.copy$default(state.getTabToView(), state.getTabToView().getData().copy(WatchLaterViewModelKt.filterNotItem(state.getTabToView().getData().getList(), new Function1() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            boolean onAction$lambda$9;
                            onAction$lambda$9 = WatchLaterViewModel.onAction$lambda$9(WLAction.this, deleteAidList, (WatchLaterItem) obj);
                            return Boolean.valueOf(onAction$lambda$9);
                        }
                    })), null, null, false, false, false, 62, null);
                    if (tabAll9.getData().getList().isEmpty() && !tabAll9.getHasMore()) {
                        watchLaterTabState3 = WatchLaterTabState.copy$default(tabAll9, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null);
                    } else {
                        watchLaterTabState3 = tabAll9;
                    }
                    if (tabToView9.getData().getList().isEmpty() && !tabToView9.getHasMore()) {
                        watchLaterTabState4 = WatchLaterTabState.copy$default(tabToView9, null, PageState.Empty.INSTANCE, null, false, false, false, 61, null);
                    } else {
                        watchLaterTabState4 = tabToView9;
                    }
                    result = WatchLaterState.copy$default(state, watchLaterTabState3, watchLaterTabState4, false, false, 12, null);
                    if (((WLAction.DeleteChecked) action).getRealDelete()) {
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$onAction$result$8$1(this, deleteList, null), 3, (Object) null);
                    } else {
                        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_DELETE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf(deleteList.size()))));
                        sendAction(WLAction.ChangeCheckState.INSTANCE);
                    }
                }
            }
            emitState(result);
        }
        result = state;
        emitState(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAction$lambda$8(WLAction $action, List $deleteAidList, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (((WLAction.DeleteChecked) $action).getRealDelete()) {
            return $deleteAidList.contains(Long.valueOf(item.getAid()));
        }
        return $deleteAidList.contains(Long.valueOf(item.getAid())) && !item.isInvalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAction$lambda$9(WLAction $action, List $deleteAidList, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (((WLAction.DeleteChecked) $action).getRealDelete()) {
            return $deleteAidList.contains(Long.valueOf(item.getAid()));
        }
        return $deleteAidList.contains(Long.valueOf(item.getAid())) && !item.isInvalid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAction$lambda$21(WLAction $action, WatchLaterItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAid() == ((WLAction.DeleteItem) $action).getAid();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onAction$lambda$22(WLAction $action, WatchLaterItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAid() == ((WLAction.DeleteItem) $action).getAid();
    }

    public final void onSortClick() {
        sendAction(WLAction.SortAction.INSTANCE);
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_SORT_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_ORDER_TYPE, !((WatchLaterState) getWatchLaterState().getValue()).getAsc() ? "1" : "2")));
    }

    public final void load(int pageIndex, boolean isLoadMore) {
        if (this.isTabAllLoading && pageIndex == 0) {
            return;
        }
        if (this.isTabToViewLoading && pageIndex == 1) {
            return;
        }
        sendAction(new WLAction.LoadAction(pageIndex, isLoadMore));
    }

    public final void refresh(int pageIndex) {
        sendAction(new WLAction.RefreshAction(pageIndex));
    }

    public final void changeCheckState() {
        sendAction(WLAction.ChangeCheckState.INSTANCE);
    }

    public final void deleteItem(long aid) {
        sendAction(new WLAction.DeleteItem(aid));
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_DELETE_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_AVID, String.valueOf(aid)), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, "2")}));
    }

    public final void onManageClick() {
        if (((WatchLaterState) getWatchLaterState().getValue()).isCheckMode()) {
            changeCheckState();
        } else {
            emitEvent(new WatchLaterViewModel$onManageClick$1(null));
        }
        WatchLaterReporterKt.reportWatchLaterClick$default(WatchLaterReporterKt.EVENT_MANAGE_CLICK, null, 2, null);
    }

    public final void onThreePointClick(WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        emitEvent(new WatchLaterViewModel$onThreePointClick$1(item, null));
    }

    public final void onCardCheckClick(String itemId) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        sendAction(new WLAction.ChangeCardCheckState(((Number) this.curPageIndex.getValue()).intValue(), itemId));
    }

    public final void onCheckAll(int pageIndex) {
        sendAction(new WLAction.CheckAll(pageIndex));
    }

    public final void onCancelAll(int pageIndex) {
        sendAction(new WLAction.CancelAll(pageIndex));
    }

    public final void showDialog(DialogType dialogType) {
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        emitEvent(new WatchLaterViewModel$showDialog$1(dialogType, null));
    }

    public final void onDialogConfirm(DialogType dialogType) {
        Intrinsics.checkNotNullParameter(dialogType, "dialogType");
        if (!Intrinsics.areEqual(dialogType, DialogType.DeleteChecked.INSTANCE)) {
            if (!Intrinsics.areEqual(dialogType, DialogType.DeleteInvalid.INSTANCE)) {
                if (!Intrinsics.areEqual(dialogType, DialogType.DeleteWatched.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                sendAction(WLAction.DeleteWatched.INSTANCE);
                return;
            }
            sendAction(WLAction.DeleteInvalid.INSTANCE);
            return;
        }
        sendAction(new WLAction.DeleteChecked(true));
    }

    public final void switchTranslate(WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (TranslateApiKt.isTranslating(item)) {
            KLog_androidKt.getKLog().i("WatchLaterViewModel", "is tranlating");
            return;
        }
        KNeuron kNeuron = KNeuron.INSTANCE;
        Pair[] pairArr = new Pair[2];
        boolean z = false;
        pairArr[0] = TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, item.getTranslateStatus() == 2 ? "original" : "translate");
        pairArr[1] = TuplesKt.to("aid", String.valueOf(item.getAid()));
        kNeuron.reportClick(false, "main.later-watch.video-card.three-point-translate.click", MapsKt.mapOf(pairArr));
        if (item.getTranslateStatus() == 2) {
            updateItemTranslateState$default(this, item, 1, null, 4, null);
            return;
        }
        if (item.getTranslateStatus() == 1) {
            String translateTitle = item.getTranslateTitle();
            if (translateTitle == null || StringsKt.isBlank(translateTitle)) {
                z = true;
            }
            if (!z) {
                updateItemTranslateState$default(this, item, 2, null, 4, null);
                return;
            }
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new WatchLaterViewModel$switchTranslate$1(this, item, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void updateItemTranslateState$default(WatchLaterViewModel watchLaterViewModel, WatchLaterItem watchLaterItem, int i, String str, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = null;
        }
        watchLaterViewModel.updateItemTranslateState(watchLaterItem, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateItemTranslateState(WatchLaterItem item, int status, String translatedTitle) {
        String str = translatedTitle;
        if (!(str == null || StringsKt.isBlank(str))) {
            item.setTranslateTitle(translatedTitle);
        }
        item.setTranslateStatus(status);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onTabClick(int pageIndex, Continuation<? super Unit> continuation) {
        WatchLaterViewModel$onTabClick$1 watchLaterViewModel$onTabClick$1;
        String str;
        if (continuation instanceof WatchLaterViewModel$onTabClick$1) {
            watchLaterViewModel$onTabClick$1 = (WatchLaterViewModel$onTabClick$1) continuation;
            if ((watchLaterViewModel$onTabClick$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterViewModel$onTabClick$1.label -= Integer.MIN_VALUE;
                Object $result = watchLaterViewModel$onTabClick$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterViewModel$onTabClick$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableStateFlow<Integer> mutableStateFlow = this.curPageIndex;
                        Integer boxInt = Boxing.boxInt(pageIndex);
                        watchLaterViewModel$onTabClick$1.I$0 = pageIndex;
                        watchLaterViewModel$onTabClick$1.label = 1;
                        if (mutableStateFlow.emit(boxInt, watchLaterViewModel$onTabClick$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        pageIndex = watchLaterViewModel$onTabClick$1.I$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (pageIndex == 1 && WatchLaterConsts_androidKt.getWatchLaterInitialPageIndex() != 1) {
                    WatchLaterConsts_androidKt.setWatchLaterInitialPageIndex(1);
                }
                str = (String) CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), pageIndex);
                if (str == null) {
                    str = "";
                }
                WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_TAB_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, str)));
                return Unit.INSTANCE;
            }
        }
        watchLaterViewModel$onTabClick$1 = new WatchLaterViewModel$onTabClick$1(this, continuation);
        Object $result2 = watchLaterViewModel$onTabClick$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterViewModel$onTabClick$1.label) {
        }
        if (pageIndex == 1) {
            WatchLaterConsts_androidKt.setWatchLaterInitialPageIndex(1);
        }
        str = (String) CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), pageIndex);
        if (str == null) {
        }
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_TAB_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, str)));
        return Unit.INSTANCE;
    }

    public final void jumpPlayList(Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        String urlString = (((Number) this.curPageIndex.getValue()).intValue() == 0 ? ((WatchLaterState) getWatchLaterState().getValue()).getTabAll() : ((WatchLaterState) getWatchLaterState().getValue()).getTabToView()).getPlayUrl();
        String str = urlString;
        if (str == null || StringsKt.isBlank(str)) {
            return;
        }
        router.launch(UrisKt.toUri(urlString));
        String str2 = (String) CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), ((Number) this.curPageIndex.getValue()).intValue());
        if (str2 == null) {
            str2 = "";
        }
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_PLAY_ALL_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, str2)));
    }

    public final void onClickBatchOP(final int opType) {
        List list;
        if (((Number) this.curPageIndex.getValue()).intValue() == 0) {
            Iterable $this$filter$iv = ((WatchLaterState) getWatchLaterState().getValue()).getTabAll().getData().getList();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                WatchLaterItem it = (WatchLaterItem) element$iv$iv;
                if (((!it.isChecked() || it.getForbidFav()) ? null : 1) != null) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            list = (List) destination$iv$iv;
        } else {
            Iterable $this$filter$iv2 = ((WatchLaterState) getWatchLaterState().getValue()).getTabToView().getData().getList();
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                WatchLaterItem it2 = (WatchLaterItem) element$iv$iv2;
                if (((!it2.isChecked() || it2.getForbidFav()) ? null : 1) != null) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            list = (List) destination$iv$iv2;
        }
        List checkedList = list;
        final int count = checkedList.size();
        this.favEditState.setValue(new FavEditState(opType, WatchLaterViewModelKt.toResourceString(checkedList), new Function0() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit onClickBatchOP$lambda$2;
                onClickBatchOP$lambda$2 = WatchLaterViewModel.onClickBatchOP$lambda$2(WatchLaterViewModel.this);
                return onClickBatchOP$lambda$2;
            }
        }, new Function0() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit onClickBatchOP$lambda$3;
                onClickBatchOP$lambda$3 = WatchLaterViewModel.onClickBatchOP$lambda$3(WatchLaterViewModel.this, opType, count);
                return onClickBatchOP$lambda$3;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickBatchOP$lambda$3(WatchLaterViewModel this$0, int $opType, int $count) {
        this$0.dismissFavEdit();
        if ($opType == 0) {
            this$0.sendAction(WLAction.ChangeCheckState.INSTANCE);
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_COPY_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf($count))));
        } else {
            this$0.sendAction(new WLAction.DeleteChecked(false));
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_BATCH_MOVE_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_NUM, String.valueOf($count))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickBatchOP$lambda$2(WatchLaterViewModel this$0) {
        this$0.dismissFavEdit();
        return Unit.INSTANCE;
    }

    private final void dismissFavEdit() {
        this.favEditState.setValue((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:3|(9:5|6|7|8|15|(1:44)(1:19)|(8:(1:22)|(1:24)|25|(1:27)|28|(1:30)|31|(1:33))(4:(1:37)|(1:39)|(1:41)(1:43)|42)|34|35))|85|6|7|8|15|(1:17)|44|(0)(0)|34|35) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010a, code lost:
        r2 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestData(int pageIndex, boolean isLoadMore, boolean isRefresh, Continuation<? super Unit> continuation) {
        WatchLaterViewModel$requestData$1 watchLaterViewModel$requestData$1;
        Result result;
        WLAction.LoadError loadError;
        Object watchLater;
        if (continuation instanceof WatchLaterViewModel$requestData$1) {
            watchLaterViewModel$requestData$1 = (WatchLaterViewModel$requestData$1) continuation;
            if ((watchLaterViewModel$requestData$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterViewModel$requestData$1.label -= Integer.MIN_VALUE;
                Object $result = watchLaterViewModel$requestData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterViewModel$requestData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (isLoadMore && ((pageIndex == 0 && !((WatchLaterState) getWatchLaterState().getValue()).getTabAll().getHasMore()) || (pageIndex == 1 && !((WatchLaterState) getWatchLaterState().getValue()).getTabToView().getHasMore()))) {
                            return Unit.INSTANCE;
                        }
                        if ((this.isTabAllLoading && pageIndex == 0) || (this.isTabToViewLoading && pageIndex == 1)) {
                            return Unit.INSTANCE;
                        }
                        if (pageIndex == 0) {
                            this.isTabAllLoading = true;
                        }
                        if (pageIndex == 1) {
                            this.isTabToViewLoading = true;
                        }
                        if (isRefresh) {
                            sendAction(new WLAction.Refreshing(pageIndex));
                        } else {
                            sendAction(new WLAction.Loading(pageIndex, isLoadMore));
                        }
                        if (isRefresh || !isLoadMore) {
                            resetStartKey(pageIndex);
                        }
                        if (!isLoadMore && !isRefresh) {
                            if (pageIndex == 0) {
                                setTabAllListState(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null));
                            } else {
                                setTabToViewListState(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null));
                            }
                        }
                        boolean asc = ((WatchLaterState) getWatchLaterState().getValue()).getAsc();
                        int intValue = this.requestParam.getSortField().get(pageIndex).intValue();
                        String splitKey = this.requestParam.getSplitKey();
                        watchLaterViewModel$requestData$1.I$0 = pageIndex;
                        watchLaterViewModel$requestData$1.Z$0 = isLoadMore;
                        watchLaterViewModel$requestData$1.Z$1 = isRefresh;
                        watchLaterViewModel$requestData$1.label = 1;
                        watchLater = WatchLaterApiKt.getWatchLater(this.requestParam.getStartKey().get(pageIndex), asc, intValue, splitKey, watchLaterViewModel$requestData$1);
                        if (watchLater == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        isRefresh = watchLaterViewModel$requestData$1.Z$1;
                        isLoadMore = watchLaterViewModel$requestData$1.Z$0;
                        pageIndex = watchLaterViewModel$requestData$1.I$0;
                        ResultKt.throwOnFailure($result);
                        watchLater = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = Result.m2635boximpl(KApiResponseKt.asResult((KApiResponse) watchLater));
                if (!(result == null && true == Result.m2643isSuccessimpl(result.m2645unboximpl()))) {
                    if (pageIndex == 0) {
                        this.isTabAllLoading = false;
                    }
                    if (pageIndex == 1) {
                        this.isTabToViewLoading = false;
                    }
                    Object m2645unboximpl = result.m2645unboximpl();
                    if (Result.m2642isFailureimpl(m2645unboximpl)) {
                        m2645unboximpl = null;
                    }
                    sendAction(new WLAction.LoadCompleteAction((WatchLaterResponse) m2645unboximpl, pageIndex, isLoadMore));
                    Object m2645unboximpl2 = result.m2645unboximpl();
                    WatchLaterResponse it = Result.m2642isFailureimpl(m2645unboximpl2) ? null : m2645unboximpl2;
                    if (it != null) {
                        resetRequestParams(pageIndex, it);
                    }
                } else {
                    if (pageIndex == 0) {
                        this.isTabAllLoading = false;
                    }
                    if (pageIndex == 1) {
                        this.isTabToViewLoading = false;
                    }
                    if (isRefresh) {
                        loadError = new WLAction.RefreshError(pageIndex);
                    } else {
                        loadError = new WLAction.LoadError(pageIndex, isLoadMore);
                    }
                    sendAction(loadError);
                }
                return Unit.INSTANCE;
            }
        }
        watchLaterViewModel$requestData$1 = new WatchLaterViewModel$requestData$1(this, continuation);
        Object $result2 = watchLaterViewModel$requestData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterViewModel$requestData$1.label) {
        }
        result = Result.m2635boximpl(KApiResponseKt.asResult((KApiResponse) watchLater));
        if (!(result == null && true == Result.m2643isSuccessimpl(result.m2645unboximpl()))) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object requestData$default(WatchLaterViewModel watchLaterViewModel, int i, boolean z, boolean z2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        return watchLaterViewModel.requestData(i, z, z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cleanVideo(int cleanType, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.catch(FlowKt.flow(new WatchLaterViewModel$cleanVideo$2(cleanType, null)), new WatchLaterViewModel$cleanVideo$3(this, null)).collect(new FlowCollector() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit(((Boolean) value).booleanValue(), $completion);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WatchLaterViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lkntr/watch/later/watchlater/data/WLEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$1", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super WLEvent>, Object> {
                int label;

                AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                }

                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(continuation);
                }

                public final Object invoke(Continuation<? super WLEvent> continuation) {
                    return create(continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            return new WLEvent.ShowToast(ToastType.OperateSuccess.INSTANCE);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            public final Object emit(boolean isSuccess, Continuation<? super Unit> continuation2) {
                if (isSuccess) {
                    WatchLaterViewModel.this.emitEvent(new AnonymousClass1(null));
                    WatchLaterViewModel.this.sendAction(new WLAction.LoadAction(((Number) WatchLaterViewModel.this.curPageIndex.getValue()).intValue(), false));
                    WatchLaterViewModel.this.pageFirstLoad.put(Boxing.boxInt(((Number) WatchLaterViewModel.this.curPageIndex.getValue()).intValue() ^ 1), Boxing.boxBoolean(false));
                } else {
                    WatchLaterViewModel.this.emitEvent(new AnonymousClass2(null));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WatchLaterViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lkntr/watch/later/watchlater/data/WLEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @DebugMetadata(c = "kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$2", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super WLEvent>, Object> {
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(1, continuation);
                }

                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                public final Object invoke(Continuation<? super WLEvent> continuation) {
                    return create(continuation).invokeSuspend(Unit.INSTANCE);
                }

                public final Object invokeSuspend(Object $result) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            return new WLEvent.ShowToast(ToastType.OperateFailed.INSTANCE);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object deleteVideos(String resource, Continuation<? super Unit> continuation) {
        Object collect = FlowKt.catch(FlowKt.flow(new WatchLaterViewModel$deleteVideos$2(resource, null)), new WatchLaterViewModel$deleteVideos$3(null)).collect(new FlowCollector() { // from class: kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel$deleteVideos$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit(((Boolean) value).booleanValue(), $completion);
            }

            public final Object emit(boolean isSuccess, Continuation<? super Unit> continuation2) {
                if (isSuccess) {
                    KLog_androidKt.getKLog().i("WatchLaterViewModel", "watch later delete success");
                } else {
                    KLog_androidKt.getKLog().i("WatchLaterViewModel", "watch later delete failed");
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    private final void resetRequestParams(int pageIndex, WatchLaterResponse response) {
        WatchLaterRequestParam watchLaterRequestParam = this.requestParam;
        List $this$resetRequestParams_u24lambda_u240 = this.requestParam.getStartKey();
        String nextKey = response.getNextKey();
        if (nextKey == null) {
            nextKey = "";
        }
        $this$resetRequestParams_u24lambda_u240.set(pageIndex, nextKey);
        Unit unit = Unit.INSTANCE;
        String splitKey = response.getSplitKey();
        this.requestParam = WatchLaterRequestParam.copy$default(watchLaterRequestParam, $this$resetRequestParams_u24lambda_u240, null, splitKey == null ? "" : splitKey, 2, null);
    }

    private final void resetStartKey(int pageIndex) {
        this.requestParam.getStartKey().set(pageIndex, "");
    }
}