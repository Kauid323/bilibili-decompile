package kntr.app.tribee.search.viewModels;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.tribee.search.event.TribeeSearchEvent;
import kntr.app.tribee.search.event.UIEvent;
import kntr.app.tribee.search.state.TribeeSearchState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.udf.Store;
import kntr.base.udf.StoreMachine;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: TribeeSearchViewModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B7\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0007¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0006H\u0002J\u001e\u0010$\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0006H\u0002J\f\u0010&\u001a\u00020\u0006*\u00020\u0006H\u0002R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lkntr/app/tribee/search/viewModels/TribeeSearchViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkntr/base/udf/Store;", "Lkntr/app/tribee/search/state/TribeeSearchState;", "Lkntr/app/tribee/search/event/TribeeSearchEvent;", "keyword", "", "tribeeId", "hint", "globalSearchUri", "enableHistory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "initialState", "_uiEventFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/app/tribee/search/event/UIEvent;", "uiEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getUiEventFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "machine", "Lkntr/base/udf/StoreMachine;", "collectAsState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "state", "Lkotlinx/coroutines/flow/Flow;", "getState", "()Lkotlinx/coroutines/flow/Flow;", "dispatch", "", "action", "(Lkntr/app/tribee/search/event/TribeeSearchEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onJumpUriChanged", "uri", "tribeeSearchUri", "from", "sanitizeQuery", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchViewModel extends ViewModel implements Store<TribeeSearchState, TribeeSearchEvent> {
    public static final int $stable = 8;
    private final MutableSharedFlow<UIEvent> _uiEventFlow;
    private final String enableHistory;
    private final String globalSearchUri;
    private final String hint;
    private final TribeeSearchState initialState;
    private final StoreMachine<TribeeSearchState, TribeeSearchEvent> machine;
    private final Flow<TribeeSearchState> state;
    private final String tribeeId;
    private final SharedFlow<UIEvent> uiEventFlow;

    public TribeeSearchViewModel(String keyword, String tribeeId, String hint, String globalSearchUri, String enableHistory) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        this.tribeeId = tribeeId;
        this.hint = hint;
        this.globalSearchUri = globalSearchUri;
        this.enableHistory = enableHistory;
        this.initialState = TribeeSearchState.Companion.create(keyword, this.hint, !Intrinsics.areEqual(this.enableHistory, "0"), this.globalSearchUri, this.tribeeId);
        this._uiEventFlow = SharedFlowKt.MutableSharedFlow$default(0, 1, (BufferOverflow) null, 5, (Object) null);
        this.uiEventFlow = FlowKt.asSharedFlow(this._uiEventFlow);
        StoreMachine.Companion companion = StoreMachine.Companion;
        Object initialState$iv = this.initialState;
        Function1 specBlock$iv = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit machine$lambda$0;
                machine$lambda$0 = TribeeSearchViewModel.machine$lambda$0(TribeeSearchViewModel.this, (FlowReduxStoreBuilder) obj);
                return machine$lambda$0;
            }
        };
        this.machine = new StoreMachine<>(initialState$iv, specBlock$iv);
        this.state = this.machine.getState();
    }

    @Override // kntr.base.udf.Store
    public /* bridge */ /* synthetic */ Object dispatch(TribeeSearchEvent tribeeSearchEvent, Continuation $completion) {
        return dispatch2(tribeeSearchEvent, (Continuation<? super Unit>) $completion);
    }

    public final SharedFlow<UIEvent> getUiEventFlow() {
        return this.uiEventFlow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0(final TribeeSearchViewModel this$0, FlowReduxStoreBuilder $this$StoreMachine) {
        Intrinsics.checkNotNullParameter($this$StoreMachine, "$this$StoreMachine");
        Function1 block$iv = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$0;
                machine$lambda$0$0 = TribeeSearchViewModel.machine$lambda$0$0(TribeeSearchViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$0;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(TribeeSearchState.class), block$iv);
        Function1 block$iv2 = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$1;
                machine$lambda$0$1 = TribeeSearchViewModel.machine$lambda$0$1(TribeeSearchViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$1;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(TribeeSearchState.Find.class), block$iv2);
        Function1 block$iv3 = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$2;
                machine$lambda$0$2 = TribeeSearchViewModel.machine$lambda$0$2(TribeeSearchViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$2;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(TribeeSearchState.Result.class), block$iv3);
        Function1 block$iv4 = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$3;
                machine$lambda$0$3 = TribeeSearchViewModel.machine$lambda$0$3(TribeeSearchViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$3;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(TribeeSearchState.Result.Loading.class), block$iv4);
        Function1 block$iv5 = new Function1() { // from class: kntr.app.tribee.search.viewModels.TribeeSearchViewModel$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit machine$lambda$0$4;
                machine$lambda$0$4 = TribeeSearchViewModel.machine$lambda$0$4(TribeeSearchViewModel.this, (InStateBuilderBlock) obj);
                return machine$lambda$0$4;
            }
        };
        $this$StoreMachine.inState(Reflection.getOrCreateKotlinClass(TribeeSearchState.Result.Success.class), block$iv5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$0(TribeeSearchViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSearchViewModel$machine$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.ClearQueryText.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeSearchViewModel$machine$1$1$2(this$0, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.DoSearch.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$1(TribeeSearchViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeSearchViewModel$machine$1$2$1(this$0, null));
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSearchViewModel$machine$1$2$2(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.RefreshHistory.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new TribeeSearchViewModel$machine$1$2$3(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.ShowClearHistoryDialog.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv3 = new TribeeSearchViewModel$machine$1$2$4(null);
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.HideClearHistoryDialog.class), executionPolicy$iv3, handler$iv3);
        BaseBuilderBlock $this$iv4 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv4 = new TribeeSearchViewModel$machine$1$2$5(this$0, null);
        ExecutionPolicy executionPolicy$iv4 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv4.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.ConfirmClearHistory.class), executionPolicy$iv4, handler$iv4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$2(TribeeSearchViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSearchViewModel$machine$1$3$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.GotoFindPage.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$3(TribeeSearchViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        $this$inState.onEnter(new TribeeSearchViewModel$machine$1$4$1(this$0, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit machine$lambda$0$4(TribeeSearchViewModel this$0, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TribeeSearchViewModel$machine$1$5$1(this$0, null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(TribeeSearchEvent.LoadMore.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    public final State<TribeeSearchState> collectAsState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1098611434, "C(collectAsState)225@9774L28:TribeeSearchViewModel.kt#fwcoh4");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1098611434, $changed, -1, "kntr.app.tribee.search.viewModels.TribeeSearchViewModel.collectAsState (TribeeSearchViewModel.kt:225)");
        }
        State<TribeeSearchState> collectAsState = SnapshotStateKt.collectAsState(getState(), this.initialState, (CoroutineContext) null, $composer, 0, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return collectAsState;
    }

    @Override // kntr.base.udf.Store
    public Flow<TribeeSearchState> getState() {
        return this.state;
    }

    /* renamed from: dispatch  reason: avoid collision after fix types in other method */
    public Object dispatch2(TribeeSearchEvent action, Continuation<? super Unit> continuation) {
        Object dispatch = this.machine.dispatch(action, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onJumpUriChanged(String uri) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new TribeeSearchViewModel$onJumpUriChanged$1(this, uri, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String tribeeSearchUri$default(TribeeSearchViewModel tribeeSearchViewModel, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return tribeeSearchViewModel.tribeeSearchUri(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String tribeeSearchUri(String keyword, String from) {
        return UrisKt.appendQueryDroppingNull(UrisKt.appendQueryDroppingNull(UrisKt.appendQueryDroppingNull(UrisKt.appendQueryDroppingNull(UrisKt.appendQueryDroppingNull(UrisKt.appendQueryDroppingNull(UrisKt.toUri("bilibili://tribee/search").buildUpon(), "keyword", keyword), "tribee_id", this.tribeeId), "hint", this.hint), "global_search_uri", this.globalSearchUri), "enable_history", this.enableHistory), "from", from).build().toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String sanitizeQuery(String $this$sanitizeQuery) {
        return StringsKt.take(new Regex("\\s+").replace($this$sanitizeQuery, ""), 150);
    }
}