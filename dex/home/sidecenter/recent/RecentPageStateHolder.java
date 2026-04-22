package home.sidecenter.recent;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import home.sidecenter.recent.IRecentAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.moss.api.KBusinessException;
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
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: RecentPageStateHolder.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0087@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020#H\u0002J\u0010\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020/H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u00138\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lhome/sidecenter/recent/RecentPageStateHolder;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "getScope$sidecenter_debug$annotations", "()V", "getScope$sidecenter_debug", "()Lkotlinx/coroutines/CoroutineScope;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lhome/sidecenter/recent/RecentPageState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "toastFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "Lkotlin/Pair;", "Lhome/sidecenter/recent/RecentPageStatus;", "", "getToastFlow$annotations", "getToastFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentState", "getCurrentState", "()Lhome/sidecenter/recent/RecentPageState;", "handleAction", "", AuthActivity.ACTION_KEY, "Lhome/sidecenter/recent/IRecentAction;", "(Lhome/sidecenter/recent/IRecentAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchAction", "Lhome/sidecenter/recent/RecentActionResult;", "(Lhome/sidecenter/recent/RecentPageState;Lhome/sidecenter/recent/IRecentAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "noOp", "toast", "throwable", "", "loadData", "removeRecentVideoItem", "item", "Lhome/sidecenter/recent/RecentVideoContent;", "removeToViewVideoItem", "removeFavItem", "Lhome/sidecenter/recent/RecentFavContent;", "sidecenter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentPageStateHolder {
    public static final int $stable = 8;
    private final MutableStateFlow<RecentPageState> _stateFlow;
    private final CoroutineScope scope;
    private final StateFlow<RecentPageState> stateFlow;
    private final SharedFlow<Pair<RecentPageStatus, String>> toastFlow;

    public static /* synthetic */ void getScope$sidecenter_debug$annotations() {
    }

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public static /* synthetic */ void getToastFlow$annotations() {
    }

    public RecentPageStateHolder(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this._stateFlow = StateFlowKt.MutableStateFlow(new RecentPageState(null, null, null, null, null, null, null, TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME, null));
        this.stateFlow = FlowKt.asStateFlow(this._stateFlow);
        final Flow $this$map$iv = this.stateFlow;
        this.toastFlow = FlowKt.shareIn$default(FlowKt.distinctUntilChanged(new Flow<Pair<? extends RecentPageStatus, ? extends String>>() { // from class: home.sidecenter.recent.RecentPageStateHolder$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: home.sidecenter.recent.RecentPageStateHolder$special$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "home.sidecenter.recent.RecentPageStateHolder$special$$inlined$map$1$2", f = "RecentPageStateHolder.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                /* renamed from: home.sidecenter.recent.RecentPageStateHolder$special$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, (Continuation) this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation $completion) {
                    Continuation $continuation;
                    if ($completion instanceof AnonymousClass1) {
                        $continuation = (AnonymousClass1) $completion;
                        if (($continuation.label & Integer.MIN_VALUE) != 0) {
                            $continuation.label -= Integer.MIN_VALUE;
                            Object $result = $continuation.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch ($continuation.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                    RecentPageState it = (RecentPageState) value;
                                    Pair pair = TuplesKt.to(it.getPageStatus(), it.getToast());
                                    $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$1 = SpillingKt.nullOutSpilledVariable($continuation);
                                    $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                    $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$map_u24lambda_u245);
                                    $continuation.I$0 = 0;
                                    $continuation.label = 1;
                                    if ($this$map_u24lambda_u245.emit(pair, $continuation) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    int i2 = $continuation.I$0;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass1 = (AnonymousClass1) $continuation.L$1;
                                    Object value2 = $continuation.L$0;
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    $continuation = new AnonymousClass1($completion);
                    Object $result2 = $continuation.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch ($continuation.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            public Object collect(FlowCollector collector, Continuation $completion) {
                Object collect = $this$map$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), this.scope, SharingStarted.Companion.getEagerly(), 0, 4, (Object) null);
    }

    public final CoroutineScope getScope$sidecenter_debug() {
        return this.scope;
    }

    public final StateFlow<RecentPageState> getStateFlow() {
        return this.stateFlow;
    }

    public final SharedFlow<Pair<RecentPageStatus, String>> getToastFlow() {
        return this.toastFlow;
    }

    private final RecentPageState getCurrentState() {
        return (RecentPageState) this.stateFlow.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleAction(IRecentAction action, Continuation<? super Unit> continuation) {
        RecentPageStateHolder$handleAction$1 recentPageStateHolder$handleAction$1;
        Object dispatchAction;
        if (continuation instanceof RecentPageStateHolder$handleAction$1) {
            recentPageStateHolder$handleAction$1 = (RecentPageStateHolder$handleAction$1) continuation;
            if ((recentPageStateHolder$handleAction$1.label & Integer.MIN_VALUE) != 0) {
                recentPageStateHolder$handleAction$1.label -= Integer.MIN_VALUE;
                Object $result = recentPageStateHolder$handleAction$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (recentPageStateHolder$handleAction$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        recentPageStateHolder$handleAction$1.L$0 = SpillingKt.nullOutSpilledVariable(action);
                        recentPageStateHolder$handleAction$1.label = 1;
                        dispatchAction = dispatchAction((RecentPageState) this.stateFlow.getValue(), action, recentPageStateHolder$handleAction$1);
                        if (dispatchAction == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        IRecentAction iRecentAction = (IRecentAction) recentPageStateHolder$handleAction$1.L$0;
                        ResultKt.throwOnFailure($result);
                        dispatchAction = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                RecentActionResult result = (RecentActionResult) dispatchAction;
                this._stateFlow.setValue(result.getNewState());
                BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RecentPageStateHolder$handleAction$2(result, this, null), 3, (Object) null);
                return Unit.INSTANCE;
            }
        }
        recentPageStateHolder$handleAction$1 = new RecentPageStateHolder$handleAction$1(this, continuation);
        Object $result2 = recentPageStateHolder$handleAction$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (recentPageStateHolder$handleAction$1.label) {
        }
        RecentActionResult result2 = (RecentActionResult) dispatchAction;
        this._stateFlow.setValue(result2.getNewState());
        BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new RecentPageStateHolder$handleAction$2(result2, this, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object dispatchAction(RecentPageState currentState, IRecentAction action, Continuation<? super RecentActionResult> continuation) {
        MineSelection mineSelection;
        String str;
        if (action instanceof IRecentAction.LoadData) {
            return loadData();
        }
        if (action instanceof IRecentAction.LoadDataSuccess) {
            return new RecentActionResult(((IRecentAction.LoadDataSuccess) action).getState(), null, 2, null);
        }
        if (action instanceof IRecentAction.LoadDataFailed) {
            RecentPageStatus recentPageStatus = RecentPageStatus.Error;
            Throwable it = ((IRecentAction.LoadDataFailed) action).getThrowable();
            if (it instanceof KBusinessException) {
                str = it.getMessage();
                if (str == null) {
                    str = "";
                }
            } else {
                str = "";
            }
            return new RecentActionResult(RecentPageState.copy$default(currentState, recentPageStatus, str, MineSelection.Companion.getLocalItems(), null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR, null), null, 2, null);
        } else if (action instanceof IRecentAction.ClickMineSelectionItem) {
            MineSelection it2 = currentState.getMineSelection();
            if (it2 != null) {
                Iterable $this$map$iv = it2.getItems();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    RecentIconItem item = (RecentIconItem) item$iv$iv;
                    RecentIconItem newItem = RecentIconItem.copy$default(item, null, null, null, null, null, false, false, Intrinsics.areEqual(((IRecentAction.ClickMineSelectionItem) action).getItem().getId(), item.getId()) ? TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR : TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME, null);
                    destination$iv$iv.add(newItem);
                }
                mineSelection = new MineSelection(CollectionsKt.toMutableList((List) destination$iv$iv));
            } else {
                mineSelection = null;
            }
            return new RecentActionResult(RecentPageState.copy$default(currentState, null, null, mineSelection, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED, null), null, 2, null);
        } else if (action instanceof IRecentAction.ClickDeleteHistory) {
            return removeRecentVideoItem(((IRecentAction.ClickDeleteHistory) action).getItem());
        } else {
            if (action instanceof IRecentAction.ClickDeleteToView) {
                return removeToViewVideoItem(((IRecentAction.ClickDeleteToView) action).getItem());
            }
            if (action instanceof IRecentAction.ClickDeleteFav) {
                return removeFavItem(((IRecentAction.ClickDeleteFav) action).getItem());
            }
            if (!(action instanceof IRecentAction.DeleteToViewSuccess) && !(action instanceof IRecentAction.DeleteHistorySuccess) && !(action instanceof IRecentAction.DeleteFavSuccess)) {
                if (action instanceof IRecentAction.DeleteToViewFailed) {
                    return toast(((IRecentAction.DeleteToViewFailed) action).getThrowable());
                }
                if (action instanceof IRecentAction.DeleteHistoryFailed) {
                    return toast(((IRecentAction.DeleteHistoryFailed) action).getThrowable());
                }
                if (action instanceof IRecentAction.DeleteFavFailed) {
                    return toast(((IRecentAction.DeleteFavFailed) action).getThrowable());
                }
                throw new NoWhenBranchMatchedException();
            }
            return noOp();
        }
    }

    private final RecentActionResult noOp() {
        return new RecentActionResult(getCurrentState(), null, 2, null);
    }

    private final RecentActionResult toast(Throwable throwable) {
        String message;
        RecentPageState currentState = getCurrentState();
        String str = "";
        if ((throwable instanceof KBusinessException) && (message = ((KBusinessException) throwable).getMessage()) != null) {
            str = message;
        }
        return new RecentActionResult(RecentPageState.copy$default(currentState, null, str, null, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_THROWABLE, null), null, 2, null);
    }

    private final RecentActionResult loadData() {
        return new RecentActionResult(RecentPageState.copy$default(getCurrentState(), RecentPageStatus.Loading, null, null, null, null, null, null, TbsListener.ErrorCode.PV_UPLOAD_ERROR, null), new RecentPageStateHolder$loadData$1(null));
    }

    private final RecentActionResult removeRecentVideoItem(RecentVideoContent item) {
        RecentModule recentModule;
        RecentContentPool<RecentVideoContent> content;
        RecentPageState currentState = getCurrentState();
        RecentModule<RecentVideoContent> recentVideo = getCurrentState().getRecentVideo();
        if (recentVideo != null) {
            RecentModule<RecentVideoContent> recentVideo2 = getCurrentState().getRecentVideo();
            recentModule = RecentModule.copy$default(recentVideo, null, (recentVideo2 == null || (content = recentVideo2.getContent()) == null) ? null : RecentContentPoolsKt.popItem(content, item), null, 5, null);
        } else {
            recentModule = null;
        }
        return new RecentActionResult(RecentPageState.copy$default(currentState, null, null, null, null, recentModule, null, null, TbsListener.ErrorCode.NETWORK_NOT_WIFI_ERROR, null), new RecentPageStateHolder$removeRecentVideoItem$1(item, null));
    }

    private final RecentActionResult removeToViewVideoItem(RecentVideoContent item) {
        RecentModule recentModule;
        RecentContentPool<RecentVideoContent> content;
        RecentPageState currentState = getCurrentState();
        RecentModule<RecentVideoContent> toView = getCurrentState().getToView();
        if (toView != null) {
            RecentModule<RecentVideoContent> toView2 = getCurrentState().getToView();
            recentModule = RecentModule.copy$default(toView, null, (toView2 == null || (content = toView2.getContent()) == null) ? null : RecentContentPoolsKt.popItem(content, item), null, 5, null);
        } else {
            recentModule = null;
        }
        return new RecentActionResult(RecentPageState.copy$default(currentState, null, null, null, null, null, recentModule, null, 95, null), new RecentPageStateHolder$removeToViewVideoItem$1(item, null));
    }

    private final RecentActionResult removeFavItem(RecentFavContent item) {
        RecentModule recentModule;
        RecentContentPool<RecentFavContent> content;
        RecentPageState currentState = getCurrentState();
        RecentModule<RecentFavContent> recentFav = getCurrentState().getRecentFav();
        if (recentFav != null) {
            RecentModule<RecentFavContent> recentFav2 = getCurrentState().getRecentFav();
            recentModule = RecentModule.copy$default(recentFav, null, (recentFav2 == null || (content = recentFav2.getContent()) == null) ? null : RecentContentPoolsKt.popItem(content, item), null, 5, null);
        } else {
            recentModule = null;
        }
        return new RecentActionResult(RecentPageState.copy$default(currentState, null, null, null, null, null, null, recentModule, 63, null), new RecentPageStateHolder$removeFavItem$1(item, null));
    }
}