package tv.danmaku.bili.ui.watchlater.viewmodel;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelKt;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.watchlater.api.WatchLaterApiMangerKt;
import tv.danmaku.bili.ui.watchlater.consts.WatchLaterConstsKt;
import tv.danmaku.bili.ui.watchlater.data.DialogType;
import tv.danmaku.bili.ui.watchlater.data.ToastType;
import tv.danmaku.bili.ui.watchlater.data.WLAction;
import tv.danmaku.bili.ui.watchlater.data.WLEvent;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterResponse;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterState;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterReporterKt;
import tv.danmaku.bili.ui.watchlater.utils.WatchLaterRouterKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WatchLaterViewModel.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0002H\u0014J\u0006\u0010(\u001a\u00020$J\u0016\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020$2\u0006\u0010*\u001a\u00020\tJ\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020$J\u000e\u00102\u001a\u00020$2\u0006\u0010/\u001a\u000200J\u000e\u00103\u001a\u00020$2\u0006\u00104\u001a\u00020\u0006J\u000e\u00105\u001a\u00020$2\u0006\u0010*\u001a\u00020\tJ\u000e\u00106\u001a\u00020$2\u0006\u0010*\u001a\u00020\tJ\u000e\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020$2\u0006\u00108\u001a\u000209J\u0016\u0010;\u001a\u00020$2\u0006\u0010*\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010<J\u0010\u0010=\u001a\u00020$2\b\u0010>\u001a\u0004\u0018\u00010?J\u0018\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\t2\b\u0010B\u001a\u0004\u0018\u00010CJ,\u0010D\u001a\u00020$2\b\b\u0001\u0010*\u001a\u00020\t2\b\b\u0002\u0010+\u001a\u00020\u000e2\b\b\u0002\u0010E\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020$2\b\b\u0001\u0010H\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010<J\u0016\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010KJ\u0018\u0010L\u001a\u00020$2\u0006\u0010*\u001a\u00020\t2\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020$2\u0006\u0010*\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u000e\u0010 \u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterViewModel;", "Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterBaseViewModel;", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterState;", "<init>", "()V", "TAG", "", "curPageIndex", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "requestParam", "Ltv/danmaku/bili/ui/watchlater/viewmodel/WatchLaterRequestParam;", "pageFirstLoad", "", "", "buttonClickable", "Lkotlinx/coroutines/flow/Flow;", "getButtonClickable", "()Lkotlinx/coroutines/flow/Flow;", "<set-?>", "Landroidx/compose/foundation/lazy/LazyListState;", "tabAllListState", "getTabAllListState", "()Landroidx/compose/foundation/lazy/LazyListState;", "setTabAllListState", "(Landroidx/compose/foundation/lazy/LazyListState;)V", "tabAllListState$delegate", "Landroidx/compose/runtime/MutableState;", "tabToViewListState", "getTabToViewListState", "setTabToViewListState", "tabToViewListState$delegate", "isTabAllLoading", "isTabToViewLoading", "initialState", "onAction", "", "action", "Ltv/danmaku/bili/ui/watchlater/data/WLAction;", "state", "onSortClick", "load", "pageIndex", "isLoadMore", "refresh", "changeCheckState", "deleteItem", "aid", "", "onManageClick", "onThreePointClick", "onCardCheckClick", "itemId", "onCheckAll", "onCancelAll", "showDialog", "dialogType", "Ltv/danmaku/bili/ui/watchlater/data/DialogType;", "onDialogConfirm", "onTabClick", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jumpPlayList", "context", "Landroid/content/Context;", "onClickBatchOP", "opType", "fragmentManger", "Landroidx/fragment/app/FragmentManager;", "requestData", "isRefresh", "(IZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cleanVideo", "cleanType", "deleteVideos", "resource", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetRequestParams", "response", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterResponse;", "resetStartKey", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterViewModel extends WatchLaterBaseViewModel<WatchLaterState> {
    public static final int $stable = 8;
    private boolean isTabAllLoading;
    private boolean isTabToViewLoading;
    private final String TAG = "WatchLaterViewModel";
    private MutableStateFlow<Integer> curPageIndex = StateFlowKt.MutableStateFlow(Integer.valueOf(WatchLaterConstsKt.getWatchLaterInitialPage()));
    private WatchLaterRequestParam requestParam = new WatchLaterRequestParam(null, null, null, 7, null);
    private final Map<Integer, Boolean> pageFirstLoad = new LinkedHashMap();
    private final Flow<Boolean> buttonClickable = FlowKt.conflate(FlowKt.distinctUntilChanged(FlowKt.combine(this.curPageIndex, getWatchLaterState(), new WatchLaterViewModel$buttonClickable$1(null))));
    private final MutableState tabAllListState$delegate = SnapshotStateKt.mutableStateOf$default(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState tabToViewListState$delegate = SnapshotStateKt.mutableStateOf$default(new LazyListState(0, 0, 2, (DefaultConstructorMarker) null), (SnapshotMutationPolicy) null, 2, (Object) null);

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

    /* compiled from: WatchLaterViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$1", f = "WatchLaterViewModel.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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
                    if (mutableStateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel.1.1
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

    @Override // tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel
    public WatchLaterState initialState() {
        return new WatchLaterState(null, null, false, false, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel
    public void onAction(WLAction action, WatchLaterState state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        emitState(new WatchLaterViewModel$onAction$1(action, state, this, null));
    }

    public final void onSortClick() {
        sendAction(WLAction.SortAction.INSTANCE);
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_SORT_CLICK, MapsKt.mapOf(TuplesKt.to("order_type", !((WatchLaterState) getWatchLaterState().getValue()).getAsc() ? "1" : "2")));
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
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_DELETE_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to("avid", String.valueOf(aid)), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, "2")}));
    }

    public final void onManageClick() {
        if (((WatchLaterState) getWatchLaterState().getValue()).isCheckMode()) {
            changeCheckState();
        } else {
            emitEvent(new WatchLaterViewModel$onManageClick$1(null));
        }
        WatchLaterReporterKt.reportWatchLaterClick$default(WatchLaterReporterKt.EVENT_MANAGE_CLICK, null, 2, null);
    }

    public final void onThreePointClick(long aid) {
        emitEvent(new WatchLaterViewModel$onThreePointClick$1(aid, null));
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onTabClick(int pageIndex, Continuation<? super Unit> continuation) {
        WatchLaterViewModel$onTabClick$1 watchLaterViewModel$onTabClick$1;
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
                if (pageIndex == 1 && WatchLaterConstsKt.getWatchLaterInitialPage() != 1) {
                    WatchLaterConstsKt.setWatchLaterInitialPage(1);
                }
                WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_TAB_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), pageIndex))));
                return Unit.INSTANCE;
            }
        }
        watchLaterViewModel$onTabClick$1 = new WatchLaterViewModel$onTabClick$1(this, continuation);
        Object $result2 = watchLaterViewModel$onTabClick$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterViewModel$onTabClick$1.label) {
        }
        if (pageIndex == 1) {
            WatchLaterConstsKt.setWatchLaterInitialPage(1);
        }
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_TAB_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), pageIndex))));
        return Unit.INSTANCE;
    }

    public final void jumpPlayList(Context context) {
        String uri = (((Number) this.curPageIndex.getValue()).intValue() == 0 ? ((WatchLaterState) getWatchLaterState().getValue()).getTabAll() : ((WatchLaterState) getWatchLaterState().getValue()).getTabToView()).getPlayUrl();
        WatchLaterRouterKt.routerTo(uri, context, MapsKt.mapOf(TuplesKt.to("asc", String.valueOf(((WatchLaterState) getWatchLaterState().getValue()).getAsc()))));
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_PLAY_ALL_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_TAB_NAME, CollectionsKt.getOrNull(WatchLaterConstsKt.getTabList().getTabs(), ((Number) this.curPageIndex.getValue()).intValue()))));
    }

    public final void onClickBatchOP(int opType, FragmentManager fragmentManger) {
        if (fragmentManger == null) {
            return;
        }
        sendAction(new WLAction.BatchOperation(opType, fragmentManger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object requestData(int i, boolean z, boolean isRefresh, Continuation<? super Unit> continuation) {
        WatchLaterViewModel$requestData$1 watchLaterViewModel$requestData$1;
        boolean isLoadMore;
        int pageIndex;
        Object watchLater;
        WatchLaterViewModel watchLaterViewModel;
        boolean isRefresh2;
        Resource $this$then$iv;
        WLAction.LoadError loadError;
        if (continuation instanceof WatchLaterViewModel$requestData$1) {
            watchLaterViewModel$requestData$1 = (WatchLaterViewModel$requestData$1) continuation;
            if ((watchLaterViewModel$requestData$1.label & Integer.MIN_VALUE) != 0) {
                watchLaterViewModel$requestData$1.label -= Integer.MIN_VALUE;
                Object $result = watchLaterViewModel$requestData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (watchLaterViewModel$requestData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        isLoadMore = z;
                        pageIndex = i;
                        if (!isLoadMore || ((pageIndex != 0 || ((WatchLaterState) getWatchLaterState().getValue()).getTabAll().getHasMore()) && (pageIndex != 1 || ((WatchLaterState) getWatchLaterState().getValue()).getTabToView().getHasMore()))) {
                            if ((!this.isTabAllLoading || pageIndex != 0) && (!this.isTabToViewLoading || pageIndex != 1)) {
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
                                watchLater = WatchLaterApiMangerKt.getWatchLater(this.requestParam.getStartKey().get(pageIndex), asc, intValue, splitKey, watchLaterViewModel$requestData$1);
                                if (watchLater == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                watchLaterViewModel = this;
                                isRefresh2 = isRefresh;
                                break;
                            } else {
                                return Unit.INSTANCE;
                            }
                        } else {
                            return Unit.INSTANCE;
                        }
                        break;
                    case 1:
                        watchLaterViewModel = this;
                        isRefresh2 = watchLaterViewModel$requestData$1.Z$1;
                        isLoadMore = watchLaterViewModel$requestData$1.Z$0;
                        pageIndex = watchLaterViewModel$requestData$1.I$0;
                        ResultKt.throwOnFailure($result);
                        watchLater = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                $this$then$iv = (Resource) watchLater;
                if ($this$then$iv.getStatus() == Status.SUCCESS) {
                    WatchLaterResponse response = (WatchLaterResponse) $this$then$iv.getData();
                    if (pageIndex == 0) {
                        watchLaterViewModel.isTabAllLoading = false;
                    }
                    if (pageIndex == 1) {
                        watchLaterViewModel.isTabToViewLoading = false;
                    }
                    watchLaterViewModel.sendAction(new WLAction.LoadCompleteAction(response, pageIndex, isLoadMore));
                    if (response != null) {
                        watchLaterViewModel.resetRequestParams(pageIndex, response);
                    }
                }
                if ($this$then$iv.getStatus() == Status.ERROR && $this$then$iv.getError() != null) {
                    Intrinsics.checkNotNull($this$then$iv.getError());
                    if (pageIndex == 0) {
                        watchLaterViewModel.isTabAllLoading = false;
                    }
                    if (pageIndex == 1) {
                        watchLaterViewModel.isTabToViewLoading = false;
                    }
                    if (isRefresh2) {
                        loadError = new WLAction.LoadError(pageIndex, isLoadMore, ConnectivityMonitor.getInstance().isNetworkActive());
                    } else {
                        loadError = new WLAction.RefreshError(pageIndex);
                    }
                    watchLaterViewModel.sendAction(loadError);
                }
                return Unit.INSTANCE;
            }
        }
        watchLaterViewModel$requestData$1 = new WatchLaterViewModel$requestData$1(this, continuation);
        Object $result2 = watchLaterViewModel$requestData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (watchLaterViewModel$requestData$1.label) {
        }
        $this$then$iv = (Resource) watchLater;
        if ($this$then$iv.getStatus() == Status.SUCCESS) {
        }
        if ($this$then$iv.getStatus() == Status.ERROR) {
            Intrinsics.checkNotNull($this$then$iv.getError());
            if (pageIndex == 0) {
            }
            if (pageIndex == 1) {
            }
            if (isRefresh2) {
            }
            watchLaterViewModel.sendAction(loadError);
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
        Object collect = FlowKt.catch(FlowKt.flow(new WatchLaterViewModel$cleanVideo$2(cleanType, null)), new WatchLaterViewModel$cleanVideo$3(this, null)).collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((GeneralResponse) value, (Continuation<? super Unit>) $completion);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WatchLaterViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$1", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$1  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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

                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return new WLEvent.ShowToast(ToastType.OperateSuccess.INSTANCE);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }

            public final Object emit(GeneralResponse<BaseResponse> generalResponse, Continuation<? super Unit> continuation2) {
                if (generalResponse != null && generalResponse.isSuccess()) {
                    WatchLaterViewModel.this.emitEvent(new AnonymousClass1(null));
                    WatchLaterViewModel.this.sendAction(new WLAction.LoadAction(((Number) WatchLaterViewModel.this.curPageIndex.getValue()).intValue(), false));
                    WatchLaterViewModel.this.pageFirstLoad.put(Boxing.boxInt(1 ^ ((Number) WatchLaterViewModel.this.curPageIndex.getValue()).intValue()), Boxing.boxBoolean(false));
                } else {
                    WatchLaterViewModel.this.emitEvent(new AnonymousClass2(null));
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: WatchLaterViewModel.kt */
            @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/watchlater/data/WLEvent;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
            @DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$2", f = "WatchLaterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            /* renamed from: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$cleanVideo$4$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
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

                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
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
        Object collect = FlowKt.catch(FlowKt.flow(new WatchLaterViewModel$deleteVideos$2(resource, null)), new WatchLaterViewModel$deleteVideos$3(this, null)).collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterViewModel$deleteVideos$4
            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                return emit((GeneralResponse) value, (Continuation<? super Unit>) $completion);
            }

            public final Object emit(GeneralResponse<BaseResponse> generalResponse, Continuation<? super Unit> continuation2) {
                String str;
                String str2;
                boolean z = false;
                if (generalResponse != null && generalResponse.isSuccess()) {
                    z = true;
                }
                if (z) {
                    str2 = WatchLaterViewModel.this.TAG;
                    BLog.i(str2, "watch later delete success");
                } else {
                    str = WatchLaterViewModel.this.TAG;
                    BLog.i(str, "watch later delete failed");
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetRequestParams(int pageIndex, WatchLaterResponse response) {
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