package im.direct.notification.interactive;

import bili.resource.common.CommonRes;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgTabType;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.utils.CIOKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.datetime.Clock;
import org.jetbrains.compose.resources.StringResource;

/* compiled from: INStateHolder.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0007J\u001e\u0010.\u001a\u00020/2\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0082@¢\u0006\u0002\u00100J\"\u00101\u001a\u00020/2\u0006\u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u000105H\u0082@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020(H\u0082@¢\u0006\u0002\u00109J\u0016\u0010:\u001a\u00020/2\u0006\u00108\u001a\u00020(H\u0082@¢\u0006\u0002\u00109J\u0016\u0010;\u001a\u00020/2\u0006\u00108\u001a\u00020(H\u0082@¢\u0006\u0002\u00109J\u0016\u0010<\u001a\u00020/2\u0006\u00108\u001a\u00020(H\u0082@¢\u0006\u0002\u00109R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00128\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020%0$X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00180$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lim/direct/notification/interactive/INStateHolder;", "", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "pageType", "Lim/direct/notification/interactive/INPageType;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lim/direct/notification/interactive/INPageType;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$interactive_debug$annotations", "()V", "getCoroutineScope$interactive_debug", "()Lkotlinx/coroutines/CoroutineScope;", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lim/direct/notification/interactive/INState;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow$annotations", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "toast", "Lkotlinx/coroutines/flow/SharedFlow;", "Lim/direct/notification/interactive/ToastMessage;", "getToast$annotations", "getToast", "()Lkotlinx/coroutines/flow/SharedFlow;", "currentState", "getCurrentState", "()Lim/direct/notification/interactive/INState;", "tabType", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgTabType;", "getTabType", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgTabType;", "pageStatusLens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/direct/notification/interactive/INPageStatus;", "cardsLens", "", "Lim/direct/notification/interactive/INMessageCard;", "toastLens", "handleAction", "", AuthActivity.ACTION_KEY, "Lim/direct/notification/interactive/INAction;", "dispatchAction", "Lim/direct/notification/interactive/INActionResult;", "(Lim/direct/notification/interactive/INState;Lim/direct/notification/interactive/INAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestList", "requestScope", "Lim/direct/notification/interactive/RequestScope;", "changeFilter", "Lim/direct/notification/interactive/INFilter;", "(Lim/direct/notification/interactive/RequestScope;Lim/direct/notification/interactive/INFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "like", "card", "(Lim/direct/notification/interactive/INMessageCard;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "thank", "delete", "mute", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INStateHolder {
    private final MutableStateFlow<INState> _stateFlow;
    private final BSimpleLens<INState, List<INMessageCard>> cardsLens;
    private final CoroutineScope coroutineScope;
    private final BSimpleLens<INState, INPageStatus> pageStatusLens;
    private final INPageType pageType;
    private final StateFlow<INState> stateFlow;
    private final SharedFlow<ToastMessage> toast;
    private final BSimpleLens<INState, ToastMessage> toastLens;

    /* compiled from: INStateHolder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[INPageType.values().length];
            try {
                iArr[INPageType.Reply.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[INPageType.Like.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[RequestScope.values().length];
            try {
                iArr2[RequestScope.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[RequestScope.TAB.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[RequestScope.NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static /* synthetic */ void getCoroutineScope$interactive_debug$annotations() {
    }

    public static /* synthetic */ void getStateFlow$annotations() {
    }

    public static /* synthetic */ void getToast$annotations() {
    }

    public INStateHolder(CoroutineContext coroutineContext, INPageType pageType) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        this.pageType = pageType;
        KLog_androidKt.getKLog().i(INStateHolderKt.TAG, "StateHolder init with page type " + this.pageType);
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineContext.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
        this._stateFlow = StateFlowKt.MutableStateFlow(new INState(INPageStatusInitial.INSTANCE, CollectionsKt.emptyList(), null, CollectionsKt.emptyList(), null, null, null, 16, null));
        this.stateFlow = FlowKt.asStateFlow(this._stateFlow);
        final Flow $this$mapNotNull$iv = this.stateFlow;
        this.toast = FlowKt.shareIn$default(FlowKt.distinctUntilChanged(new Flow<ToastMessage>() { // from class: im.direct.notification.interactive.INStateHolder$special$$inlined$mapNotNull$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            /* renamed from: im.direct.notification.interactive.INStateHolder$special$$inlined$mapNotNull$1$2  reason: invalid class name */
            /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "im.direct.notification.interactive.INStateHolder$special$$inlined$mapNotNull$1$2", f = "INStateHolder.kt", i = {0, 0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                /* renamed from: im.direct.notification.interactive.INStateHolder$special$$inlined$mapNotNull$1$2$1  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
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
                /* JADX WARN: Removed duplicated region for block: B:13:0x0042  */
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
                                    FlowCollector $this$mapNotNull_u24lambda_u246 = this.$this_unsafeFlow;
                                    AnonymousClass1 anonymousClass1 = $continuation;
                                    INState it = (INState) value;
                                    Object transformed = it.getToast$interactive_debug();
                                    if (transformed != null) {
                                        $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                        $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                        $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$mapNotNull_u24lambda_u246);
                                        $continuation.L$4 = SpillingKt.nullOutSpilledVariable(transformed);
                                        $continuation.I$0 = 0;
                                        $continuation.label = 1;
                                        if ($this$mapNotNull_u24lambda_u246.emit(transformed, $continuation) != coroutine_suspended) {
                                            break;
                                        } else {
                                            return coroutine_suspended;
                                        }
                                    }
                                    break;
                                case 1:
                                    int i2 = $continuation.I$0;
                                    ToastMessage toastMessage = (ToastMessage) $continuation.L$4;
                                    FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                    Object obj = $continuation.L$2;
                                    AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
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
                Object collect = $this$mapNotNull$iv.collect(new AnonymousClass2(collector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), this.coroutineScope, SharingStarted.Companion.getLazily(), 0, 4, (Object) null);
        this.pageStatusLens = INStateLensKt.getPageStatus(INState.Companion);
        this.cardsLens = INStateLensKt.getMessageCards(INState.Companion);
        this.toastLens = INStateLensKt.getToast(INState.Companion);
    }

    public final CoroutineScope getCoroutineScope$interactive_debug() {
        return this.coroutineScope;
    }

    public final StateFlow<INState> getStateFlow() {
        return this.stateFlow;
    }

    public final SharedFlow<ToastMessage> getToast() {
        return this.toast;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final INState getCurrentState() {
        return (INState) this.stateFlow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KMsgTabType getTabType() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.pageType.ordinal()]) {
            case 1:
                return KMsgTabType.RECEIVE_REPLY.INSTANCE;
            case 2:
                return KMsgTabType.RECEIVE_LIKE.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void handleAction(INAction action) {
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new INStateHolder$handleAction$1(this, action, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object dispatchAction(INState currentState, INAction action, Continuation<? super INActionResult> continuation) {
        INStateHolder$dispatchAction$1 iNStateHolder$dispatchAction$1;
        INStateHolder$dispatchAction$1 iNStateHolder$dispatchAction$12;
        Object element$iv;
        INMessageCard copy;
        Object ToastMessage$default;
        Object ToastMessage$default2;
        Object ToastMessage$default3;
        Object obj;
        INActionResult iNActionResult;
        ThankCtrl thankCtrl;
        INMessageCard newCard;
        ThankCtrl copy2;
        Object ToastMessage$default4;
        Object obj2;
        final boolean isSelected;
        final List newList;
        Object suspendGetString;
        LikeCtrl likeCtrl;
        INMessageCard newCard2;
        LikeCtrl copy3;
        Object ToastMessage$default5;
        INState refresh$interactive_debug;
        final INState currentState2 = currentState;
        final INAction action2 = action;
        if (continuation instanceof INStateHolder$dispatchAction$1) {
            iNStateHolder$dispatchAction$1 = (INStateHolder$dispatchAction$1) continuation;
            if ((iNStateHolder$dispatchAction$1.label & Integer.MIN_VALUE) != 0) {
                iNStateHolder$dispatchAction$1.label -= Integer.MIN_VALUE;
                iNStateHolder$dispatchAction$12 = iNStateHolder$dispatchAction$1;
                Object $result = iNStateHolder$dispatchAction$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iNStateHolder$dispatchAction$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KLog_androidKt.getKLog().i(INStateHolderKt.TAG, "Start to dispatch action " + INActionKt.logString(action));
                        if (action2 instanceof INActionRequestList) {
                            RequestScope requestScope = RequestScope.PAGE;
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 1;
                            Object requestList$default = requestList$default(this, requestScope, null, iNStateHolder$dispatchAction$12, 2, null);
                            return requestList$default == coroutine_suspended ? coroutine_suspended : requestList$default;
                        } else if (action2 instanceof INActionRequestNext) {
                            if (currentState.getCursor$interactive_debug() == null || currentState.getCursor$interactive_debug().isEnd()) {
                                return new INActionResult(currentState2, null, 2, null);
                            }
                            RequestScope requestScope2 = RequestScope.NEXT;
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 2;
                            Object requestList$default2 = requestList$default(this, requestScope2, null, iNStateHolder$dispatchAction$12, 2, null);
                            return requestList$default2 == coroutine_suspended ? coroutine_suspended : requestList$default2;
                        } else if (action2 instanceof INActionRequestListSuccess) {
                            switch (WhenMappings.$EnumSwitchMapping$1[((INActionRequestListSuccess) action2).getRequestScope().ordinal()]) {
                                case 1:
                                    refresh$interactive_debug = currentState2.refresh$interactive_debug(((INActionRequestListSuccess) action2).getResponse());
                                    break;
                                case 2:
                                    refresh$interactive_debug = currentState2.refreshTab$interactive_debug(((INActionRequestListSuccess) action2).getResponse());
                                    break;
                                case 3:
                                    refresh$interactive_debug = currentState2.append$interactive_debug(((INActionRequestListSuccess) action2).getResponse());
                                    break;
                                default:
                                    throw new NoWhenBranchMatchedException();
                            }
                            return new INActionResult(refresh$interactive_debug, null, 2, null);
                        } else if (action2 instanceof INActionRequestListFail) {
                            Throwable error = ((INActionRequestListFail) action2).getError();
                            iNStateHolder$dispatchAction$12.L$0 = currentState2;
                            iNStateHolder$dispatchAction$12.L$1 = action2;
                            iNStateHolder$dispatchAction$12.label = 3;
                            ToastMessage$default5 = INStateKt.ToastMessage$default(error, null, iNStateHolder$dispatchAction$12, 2, null);
                            if (ToastMessage$default5 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            final ToastMessage toastMessage = (ToastMessage) ToastMessage$default5;
                            return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj3) {
                                    Unit dispatchAction$lambda$0;
                                    dispatchAction$lambda$0 = INStateHolder.dispatchAction$lambda$0(INState.this, this, action2, toastMessage, (CopyScope) obj3);
                                    return dispatchAction$lambda$0;
                                }
                            }), null, 2, null);
                        } else if (action2 instanceof INActionLike) {
                            INMessageCard card = ((INActionLike) action2).getCard();
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 4;
                            Object like = like(card, iNStateHolder$dispatchAction$12);
                            return like == coroutine_suspended ? coroutine_suspended : like;
                        } else if (action2 instanceof INActionLikeSuccess) {
                            try {
                                Result.Companion companion = Result.Companion;
                                Iterable $this$first$iv = currentState.getMessageCards$interactive_debug();
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                            }
                            for (Object element$iv2 : $this$first$iv) {
                                INMessageCard it = (INMessageCard) element$iv2;
                                if (it.isSameWith$interactive_debug(((INActionLikeSuccess) action2).getCard())) {
                                    INMessageCard card2 = (INMessageCard) element$iv2;
                                    int index = currentState.getMessageCards$interactive_debug().indexOf(card2);
                                    LikeCtrl likeCtrl2 = card2.getLikeCtrl();
                                    if (likeCtrl2 != null) {
                                        copy3 = likeCtrl2.copy((r16 & 1) != 0 ? likeCtrl2.subjectID : 0L, (r16 & 2) != 0 ? likeCtrl2.businessID : 0L, (r16 & 4) != 0 ? likeCtrl2.sourceID : 0L, (r16 & 8) != 0 ? likeCtrl2.isSelected : !likeCtrl2.isSelected());
                                        likeCtrl = copy3;
                                    } else {
                                        likeCtrl = null;
                                    }
                                    newCard2 = card2.copy((r36 & 1) != 0 ? card2.message : null, (r36 & 2) != 0 ? card2.type : null, (r36 & 4) != 0 ? card2.f1973common : null, (r36 & 8) != 0 ? card2.richTextContentByteArray : null, (r36 & 16) != 0 ? card2.description : null, (r36 & 32) != 0 ? card2.commentCtrl : null, (r36 & 64) != 0 ? card2.likeCtrl : likeCtrl, (r36 & 128) != 0 ? card2.thankCtrl : null, (r36 & 256) != 0 ? card2.minorOperations : null, (r36 & 512) != 0 ? card2.isMuted : false, (r36 & 1024) != 0 ? card2.isPinned : false, (r36 & 2048) != 0 ? card2.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? card2.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? card2.hasUnreadMark : false, (r36 & 16384) != 0 ? card2.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? card2.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? card2.isNeedTeach : false);
                                    LikeCtrl likeCtrl3 = newCard2.getLikeCtrl();
                                    Boolean boxBoolean = Boxing.boxBoolean(likeCtrl3 != null ? likeCtrl3.isSelected() : false);
                                    List $this$dispatchAction_u24lambda_u241_u241 = CollectionsKt.toMutableList(currentState.getMessageCards$interactive_debug());
                                    $this$dispatchAction_u24lambda_u241_u241.set(index, newCard2);
                                    obj2 = Result.constructor-impl(TuplesKt.to(boxBoolean, CollectionsKt.toList($this$dispatchAction_u24lambda_u241_u241)));
                                    JobKt.ensureActive(iNStateHolder$dispatchAction$12.getContext());
                                    Object it$iv = Result.exceptionOrNull-impl(obj2);
                                    if (it$iv == null) {
                                        Pair pair = (Pair) obj2;
                                        isSelected = ((Boolean) pair.component1()).booleanValue();
                                        newList = (List) pair.component2();
                                        CommonRes commonRes = CommonRes.INSTANCE;
                                        StringResource common_global_string_137 = String0_commonMainKt.getCommon_global_string_137(Res.string.INSTANCE);
                                        iNStateHolder$dispatchAction$12.L$0 = currentState2;
                                        iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                        iNStateHolder$dispatchAction$12.L$2 = newList;
                                        iNStateHolder$dispatchAction$12.I$0 = 0;
                                        iNStateHolder$dispatchAction$12.Z$0 = isSelected;
                                        iNStateHolder$dispatchAction$12.label = 5;
                                        suspendGetString = commonRes.suspendGetString(common_global_string_137, iNStateHolder$dispatchAction$12);
                                        if (suspendGetString == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        final String toastMessage2 = (String) suspendGetString;
                                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj3) {
                                                Unit dispatchAction$lambda$2$0;
                                                dispatchAction$lambda$2$0 = INStateHolder.dispatchAction$lambda$2$0(INStateHolder.this, newList, isSelected, toastMessage2, (CopyScope) obj3);
                                                return dispatchAction$lambda$2$0;
                                            }
                                        }), null, 2, null);
                                    }
                                    return new INActionResult(currentState2, null, 2, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        } else if (action2 instanceof INActionLikeFail) {
                            Throwable error2 = ((INActionLikeFail) action2).getError();
                            iNStateHolder$dispatchAction$12.L$0 = currentState2;
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 6;
                            ToastMessage$default4 = INStateKt.ToastMessage$default(error2, null, iNStateHolder$dispatchAction$12, 2, null);
                            if (ToastMessage$default4 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            final ToastMessage toastMessage3 = (ToastMessage) ToastMessage$default4;
                            return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj3) {
                                    Unit dispatchAction$lambda$4;
                                    dispatchAction$lambda$4 = INStateHolder.dispatchAction$lambda$4(INStateHolder.this, toastMessage3, (CopyScope) obj3);
                                    return dispatchAction$lambda$4;
                                }
                            }), null, 2, null);
                        } else if (action2 instanceof INActionThank) {
                            INMessageCard card3 = ((INActionThank) action2).getCard();
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 7;
                            Object thank = thank(card3, iNStateHolder$dispatchAction$12);
                            return thank == coroutine_suspended ? coroutine_suspended : thank;
                        } else if (action2 instanceof INActionThankSuccess) {
                            try {
                                Result.Companion companion3 = Result.Companion;
                                Iterable $this$first$iv2 = currentState.getMessageCards$interactive_debug();
                            } catch (Throwable th2) {
                                Result.Companion companion4 = Result.Companion;
                                obj = Result.constructor-impl(ResultKt.createFailure(th2));
                            }
                            for (Object element$iv3 : $this$first$iv2) {
                                INMessageCard it2 = (INMessageCard) element$iv3;
                                if (it2.isSameWith$interactive_debug(((INActionThankSuccess) action2).getCard())) {
                                    INMessageCard card4 = (INMessageCard) element$iv3;
                                    int index2 = currentState.getMessageCards$interactive_debug().indexOf(card4);
                                    ThankCtrl thankCtrl2 = card4.getThankCtrl();
                                    if (thankCtrl2 != null) {
                                        copy2 = thankCtrl2.copy((r18 & 1) != 0 ? thankCtrl2.isSelected : !thankCtrl2.isSelected(), (r18 & 2) != 0 ? thankCtrl2.receiverName : null, (r18 & 4) != 0 ? thankCtrl2.senderAvatar : null, (r18 & 8) != 0 ? thankCtrl2.msgText : null, (r18 & 16) != 0 ? thankCtrl2.msgID : 0L, (r18 & 32) != 0 ? thankCtrl2.receiverMid : 0L);
                                        thankCtrl = copy2;
                                    } else {
                                        thankCtrl = null;
                                    }
                                    newCard = card4.copy((r36 & 1) != 0 ? card4.message : null, (r36 & 2) != 0 ? card4.type : null, (r36 & 4) != 0 ? card4.f1973common : null, (r36 & 8) != 0 ? card4.richTextContentByteArray : null, (r36 & 16) != 0 ? card4.description : null, (r36 & 32) != 0 ? card4.commentCtrl : null, (r36 & 64) != 0 ? card4.likeCtrl : null, (r36 & 128) != 0 ? card4.thankCtrl : thankCtrl, (r36 & 256) != 0 ? card4.minorOperations : null, (r36 & 512) != 0 ? card4.isMuted : false, (r36 & 1024) != 0 ? card4.isPinned : false, (r36 & 2048) != 0 ? card4.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? card4.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? card4.hasUnreadMark : false, (r36 & 16384) != 0 ? card4.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? card4.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? card4.isNeedTeach : false);
                                    List $this$dispatchAction_u24lambda_u245_u241 = CollectionsKt.toMutableList(currentState.getMessageCards$interactive_debug());
                                    $this$dispatchAction_u24lambda_u245_u241.set(index2, newCard);
                                    obj = Result.constructor-impl(CollectionsKt.toList($this$dispatchAction_u24lambda_u245_u241));
                                    JobKt.ensureActive(iNStateHolder$dispatchAction$12.getContext());
                                    if (Result.exceptionOrNull-impl(obj) == null) {
                                        final List newList2 = (List) obj;
                                        iNActionResult = new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj3) {
                                                Unit dispatchAction$lambda$6$0;
                                                dispatchAction$lambda$6$0 = INStateHolder.dispatchAction$lambda$6$0(INStateHolder.this, newList2, action2, (CopyScope) obj3);
                                                return dispatchAction$lambda$6$0;
                                            }
                                        }), null, 2, null);
                                    } else {
                                        iNActionResult = new INActionResult(currentState2, null, 2, null);
                                    }
                                    return iNActionResult;
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        } else if (action2 instanceof INActionThankFail) {
                            Throwable error3 = ((INActionThankFail) action2).getError();
                            iNStateHolder$dispatchAction$12.L$0 = currentState2;
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 8;
                            ToastMessage$default3 = INStateKt.ToastMessage$default(error3, null, iNStateHolder$dispatchAction$12, 2, null);
                            if (ToastMessage$default3 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            final ToastMessage toastMessage4 = (ToastMessage) ToastMessage$default3;
                            return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda4
                                public final Object invoke(Object obj3) {
                                    Unit dispatchAction$lambda$8;
                                    dispatchAction$lambda$8 = INStateHolder.dispatchAction$lambda$8(INStateHolder.this, toastMessage4, (CopyScope) obj3);
                                    return dispatchAction$lambda$8;
                                }
                            }), null, 2, null);
                        } else if (action2 instanceof INCardAction) {
                            if (((INCardAction) action2).getOperation() instanceof INDeleteOperation) {
                                INMessageCard card5 = ((INCardAction) action2).getCard();
                                iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                                iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                iNStateHolder$dispatchAction$12.label = 9;
                                Object delete = delete(card5, iNStateHolder$dispatchAction$12);
                                return delete == coroutine_suspended ? coroutine_suspended : delete;
                            }
                            INMessageCard card6 = ((INCardAction) action2).getCard();
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 10;
                            Object mute = mute(card6, iNStateHolder$dispatchAction$12);
                            return mute == coroutine_suspended ? coroutine_suspended : mute;
                        } else if (action2 instanceof INActionDelete) {
                            INMessageCard card7 = ((INActionDelete) action2).getCard();
                            iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                            iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                            iNStateHolder$dispatchAction$12.label = 11;
                            Object delete2 = delete(card7, iNStateHolder$dispatchAction$12);
                            return delete2 == coroutine_suspended ? coroutine_suspended : delete2;
                        } else if (action2 instanceof INActionDeleteSuccess) {
                            return new INActionResult(currentState2.delete$interactive_debug(((INActionDeleteSuccess) action2).getCard()), null, 2, null);
                        } else {
                            if (action2 instanceof INActionDeleteFail) {
                                Throwable error4 = ((INActionDeleteFail) action2).getError();
                                iNStateHolder$dispatchAction$12.L$0 = currentState2;
                                iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                iNStateHolder$dispatchAction$12.label = 12;
                                ToastMessage$default2 = INStateKt.ToastMessage$default(error4, null, iNStateHolder$dispatchAction$12, 2, null);
                                if (ToastMessage$default2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                final ToastMessage toastMessage5 = (ToastMessage) ToastMessage$default2;
                                return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj3) {
                                        Unit dispatchAction$lambda$9;
                                        dispatchAction$lambda$9 = INStateHolder.dispatchAction$lambda$9(INStateHolder.this, toastMessage5, (CopyScope) obj3);
                                        return dispatchAction$lambda$9;
                                    }
                                }), null, 2, null);
                            } else if (action2 instanceof INActionMuteMsg) {
                                INMessageCard card8 = ((INActionMuteMsg) action2).getCard();
                                iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                                iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                iNStateHolder$dispatchAction$12.label = 13;
                                Object mute2 = mute(card8, iNStateHolder$dispatchAction$12);
                                return mute2 == coroutine_suspended ? coroutine_suspended : mute2;
                            } else if (action2 instanceof INActionMuteMsgSuccess) {
                                final Ref.ObjectRef toastString = new Ref.ObjectRef();
                                toastString.element = "";
                                KMsgItem msgItem = ((INActionMuteMsgSuccess) action2).getCard().getMessage().getMsgItem();
                                if (!((msgItem != null ? msgItem.getMsgCard() : null) instanceof KMsgItem.KLikeCard)) {
                                    KMsgItem msgItem2 = ((INActionMuteMsgSuccess) action2).getCard().getMessage().getMsgItem();
                                    if (!((msgItem2 != null ? msgItem2.getMsgCard() : null) instanceof KMsgItem.KCoinCard)) {
                                        KMsgItem msgItem3 = ((INActionMuteMsgSuccess) action2).getCard().getMessage().getMsgItem();
                                        if (!((msgItem3 != null ? msgItem3.getMsgCard() : null) instanceof KMsgItem.KFavoriteCard)) {
                                            KMsgItem msgItem4 = ((INActionMuteMsgSuccess) action2).getCard().getMessage().getMsgItem();
                                            if ((msgItem4 != null ? msgItem4.getMsgCard() : null) instanceof KMsgItem.KReplyCard) {
                                                toastString.element = ((INActionMuteMsgSuccess) action2).isMuted() ? GetStringById_androidKt.getStringById(882) : GetStringById_androidKt.getStringById(883);
                                            }
                                            return new INActionResult((INState) CopyScopeKt.copy(currentState2.mute$interactive_debug(((INActionMuteMsgSuccess) action2).getCard(), ((INActionMuteMsgSuccess) action2).isMuted()), new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda6
                                                public final Object invoke(Object obj3) {
                                                    Unit dispatchAction$lambda$10;
                                                    dispatchAction$lambda$10 = INStateHolder.dispatchAction$lambda$10(INStateHolder.this, toastString, (CopyScope) obj3);
                                                    return dispatchAction$lambda$10;
                                                }
                                            }), null, 2, null);
                                        }
                                    }
                                }
                                toastString.element = ((INActionMuteMsgSuccess) action2).isMuted() ? GetStringById_androidKt.getStringById(880) : GetStringById_androidKt.getStringById(881);
                                return new INActionResult((INState) CopyScopeKt.copy(currentState2.mute$interactive_debug(((INActionMuteMsgSuccess) action2).getCard(), ((INActionMuteMsgSuccess) action2).isMuted()), new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj3) {
                                        Unit dispatchAction$lambda$10;
                                        dispatchAction$lambda$10 = INStateHolder.dispatchAction$lambda$10(INStateHolder.this, toastString, (CopyScope) obj3);
                                        return dispatchAction$lambda$10;
                                    }
                                }), null, 2, null);
                            } else if (action2 instanceof INActionMuteMsgFail) {
                                Throwable error5 = ((INActionMuteMsgFail) action2).getError();
                                iNStateHolder$dispatchAction$12.L$0 = currentState2;
                                iNStateHolder$dispatchAction$12.L$1 = action2;
                                iNStateHolder$dispatchAction$12.label = 14;
                                ToastMessage$default = INStateKt.ToastMessage$default(error5, null, iNStateHolder$dispatchAction$12, 2, null);
                                if (ToastMessage$default == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                final ToastMessage toastMessage6 = (ToastMessage) ToastMessage$default;
                                return new INActionResult((INState) CopyScopeKt.copy(currentState2.requestFail$interactive_debug(((INActionMuteMsgFail) action2).getCard()), new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj3) {
                                        Unit dispatchAction$lambda$11;
                                        dispatchAction$lambda$11 = INStateHolder.dispatchAction$lambda$11(INStateHolder.this, toastMessage6, (CopyScope) obj3);
                                        return dispatchAction$lambda$11;
                                    }
                                }), null, 2, null);
                            } else if (action2 instanceof INActionChangeFilter) {
                                if (INStateKt.shouldChangeToFilter(currentState.getFilters(), ((INActionChangeFilter) action2).getFilter())) {
                                    RequestScope requestScope3 = RequestScope.TAB;
                                    INFilter filter = ((INActionChangeFilter) action2).getFilter();
                                    iNStateHolder$dispatchAction$12.L$0 = SpillingKt.nullOutSpilledVariable(currentState);
                                    iNStateHolder$dispatchAction$12.L$1 = SpillingKt.nullOutSpilledVariable(action);
                                    iNStateHolder$dispatchAction$12.label = 15;
                                    Object requestList = requestList(requestScope3, filter, iNStateHolder$dispatchAction$12);
                                    return requestList == coroutine_suspended ? coroutine_suspended : requestList;
                                }
                                return new INActionResult(currentState2, null, 2, null);
                            } else if (action2 instanceof INActionClickCard) {
                                if (((INActionClickCard) action2).getCard().isUnread()) {
                                    Iterable $this$firstOrNull$iv = CollectionsKt.withIndex(currentState.getMessageCards$interactive_debug());
                                    Iterator it3 = $this$firstOrNull$iv.iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            element$iv = it3.next();
                                            IndexedValue it4 = (IndexedValue) element$iv;
                                            if (((INMessageCard) it4.getValue()).isSameWith$interactive_debug(((INActionClickCard) action2).getCard())) {
                                            }
                                        } else {
                                            element$iv = null;
                                        }
                                    }
                                    IndexedValue indexedCard = (IndexedValue) element$iv;
                                    List messageCards = CollectionsKt.toMutableList(currentState.getMessageCards$interactive_debug());
                                    if (indexedCard != null) {
                                        int index3 = indexedCard.getIndex();
                                        copy = r20.copy((r36 & 1) != 0 ? r20.message : null, (r36 & 2) != 0 ? r20.type : null, (r36 & 4) != 0 ? r20.f1973common : null, (r36 & 8) != 0 ? r20.richTextContentByteArray : null, (r36 & 16) != 0 ? r20.description : null, (r36 & 32) != 0 ? r20.commentCtrl : null, (r36 & 64) != 0 ? r20.likeCtrl : null, (r36 & 128) != 0 ? r20.thankCtrl : null, (r36 & 256) != 0 ? r20.minorOperations : null, (r36 & 512) != 0 ? r20.isMuted : false, (r36 & 1024) != 0 ? r20.isPinned : false, (r36 & 2048) != 0 ? r20.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? r20.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? r20.hasUnreadMark : false, (r36 & 16384) != 0 ? r20.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? r20.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? ((INMessageCard) indexedCard.getValue()).isNeedTeach : false);
                                        messageCards.set(index3, copy);
                                    }
                                    return new INActionResult(INState.copy$default(currentState, null, CollectionsKt.toList(messageCards), null, null, null, null, null, TbsListener.ErrorCode.DOWNLOAD_THROWABLE, null), null, 2, null);
                                }
                                return new INActionResult(currentState2, null, 2, null);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    case 1:
                        INAction iNAction = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 2:
                        INAction iNAction2 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 3:
                        ResultKt.throwOnFailure($result);
                        action2 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ToastMessage$default5 = $result;
                        final ToastMessage toastMessage7 = (ToastMessage) ToastMessage$default5;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$0;
                                dispatchAction$lambda$0 = INStateHolder.dispatchAction$lambda$0(INState.this, this, action2, toastMessage7, (CopyScope) obj3);
                                return dispatchAction$lambda$0;
                            }
                        }), null, 2, null);
                    case 4:
                        INAction iNAction3 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState3 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 5:
                        boolean isSelected2 = iNStateHolder$dispatchAction$12.Z$0;
                        int i2 = iNStateHolder$dispatchAction$12.I$0;
                        newList = (List) iNStateHolder$dispatchAction$12.L$2;
                        INAction iNAction4 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        ResultKt.throwOnFailure($result);
                        isSelected = isSelected2;
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        suspendGetString = $result;
                        final String toastMessage22 = (String) suspendGetString;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$2$0;
                                dispatchAction$lambda$2$0 = INStateHolder.dispatchAction$lambda$2$0(INStateHolder.this, newList, isSelected, toastMessage22, (CopyScope) obj3);
                                return dispatchAction$lambda$2$0;
                            }
                        }), null, 2, null);
                    case 6:
                        INAction iNAction5 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        ResultKt.throwOnFailure($result);
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ToastMessage$default4 = $result;
                        final ToastMessage toastMessage32 = (ToastMessage) ToastMessage$default4;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda2
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$4;
                                dispatchAction$lambda$4 = INStateHolder.dispatchAction$lambda$4(INStateHolder.this, toastMessage32, (CopyScope) obj3);
                                return dispatchAction$lambda$4;
                            }
                        }), null, 2, null);
                    case 7:
                        INAction iNAction6 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState4 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 8:
                        INAction iNAction7 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        ResultKt.throwOnFailure($result);
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ToastMessage$default3 = $result;
                        final ToastMessage toastMessage42 = (ToastMessage) ToastMessage$default3;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda4
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$8;
                                dispatchAction$lambda$8 = INStateHolder.dispatchAction$lambda$8(INStateHolder.this, toastMessage42, (CopyScope) obj3);
                                return dispatchAction$lambda$8;
                            }
                        }), null, 2, null);
                    case 9:
                        INAction iNAction8 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState5 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 10:
                        INAction iNAction9 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState6 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 11:
                        INAction iNAction10 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState7 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 12:
                        INAction iNAction11 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        ResultKt.throwOnFailure($result);
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ToastMessage$default2 = $result;
                        final ToastMessage toastMessage52 = (ToastMessage) ToastMessage$default2;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2, new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda5
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$9;
                                dispatchAction$lambda$9 = INStateHolder.dispatchAction$lambda$9(INStateHolder.this, toastMessage52, (CopyScope) obj3);
                                return dispatchAction$lambda$9;
                            }
                        }), null, 2, null);
                    case 13:
                        INAction iNAction12 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState8 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 14:
                        ResultKt.throwOnFailure($result);
                        action2 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        currentState2 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ToastMessage$default = $result;
                        final ToastMessage toastMessage62 = (ToastMessage) ToastMessage$default;
                        return new INActionResult((INState) CopyScopeKt.copy(currentState2.requestFail$interactive_debug(((INActionMuteMsgFail) action2).getCard()), new Function1() { // from class: im.direct.notification.interactive.INStateHolder$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj3) {
                                Unit dispatchAction$lambda$11;
                                dispatchAction$lambda$11 = INStateHolder.dispatchAction$lambda$11(INStateHolder.this, toastMessage62, (CopyScope) obj3);
                                return dispatchAction$lambda$11;
                            }
                        }), null, 2, null);
                    case 15:
                        INAction iNAction13 = (INAction) iNStateHolder$dispatchAction$12.L$1;
                        INState iNState9 = (INState) iNStateHolder$dispatchAction$12.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iNStateHolder$dispatchAction$1 = new INStateHolder$dispatchAction$1(this, continuation);
        iNStateHolder$dispatchAction$12 = iNStateHolder$dispatchAction$1;
        Object $result2 = iNStateHolder$dispatchAction$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iNStateHolder$dispatchAction$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$0(INState $currentState, INStateHolder this$0, INAction $action, ToastMessage $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        if ($currentState.getMessageCards$interactive_debug().isEmpty()) {
            $this$copy.set(this$0.pageStatusLens, new INPageStatusError(((INActionRequestListFail) $action).getError()));
        } else {
            $this$copy.set(this$0.pageStatusLens, INPageStatusSuccess.INSTANCE);
            $this$copy.set(this$0.toastLens, $toastMessage);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$2$0(INStateHolder this$0, List $newList, boolean $isSelected, String $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.cardsLens, $newList);
        if ($isSelected) {
            $this$copy.set(this$0.toastLens, new ToastMessage($toastMessage, 0L, 2, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$4(INStateHolder this$0, ToastMessage $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.toastLens, $toastMessage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$6$0(INStateHolder this$0, List $newList, INAction $action, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.cardsLens, $newList);
        if (((INActionThankSuccess) $action).getResponse().getToast().length() > 0) {
            $this$copy.set(this$0.toastLens, new ToastMessage(((INActionThankSuccess) $action).getResponse().getToast(), 0L, 2, null));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$8(INStateHolder this$0, ToastMessage $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.toastLens, $toastMessage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$9(INStateHolder this$0, ToastMessage $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.toastLens, $toastMessage);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$10(INStateHolder this$0, Ref.ObjectRef $toastString, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.toastLens, new ToastMessage((String) $toastString.element, 0L, 2, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dispatchAction$lambda$11(INStateHolder this$0, ToastMessage $toastMessage, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(this$0.toastLens, $toastMessage);
        return Unit.INSTANCE;
    }

    static /* synthetic */ Object requestList$default(INStateHolder iNStateHolder, RequestScope requestScope, INFilter iNFilter, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            iNFilter = null;
        }
        return iNStateHolder.requestList(requestScope, iNFilter, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestList(RequestScope requestScope, INFilter changeFilter, Continuation<? super INActionResult> continuation) {
        INPageStatus iNPageStatus;
        INPageStatus currentPageStatus = getCurrentState().getPageStatus();
        boolean z = false;
        switch (WhenMappings.$EnumSwitchMapping$1[requestScope.ordinal()]) {
            case 1:
                z = currentPageStatus instanceof INPageStatusPageLoading;
                break;
            case 2:
                break;
            case 3:
                if (!(currentPageStatus instanceof INPageStatusSuccess)) {
                    z = true;
                    break;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        boolean ignoreRequest = z;
        if (ignoreRequest) {
            return new INActionResult(getCurrentState(), null, 2, null);
        }
        List cards = changeFilter == null ? getCurrentState().getMessageCards$interactive_debug() : CollectionsKt.emptyList();
        INState currentState = getCurrentState();
        switch (WhenMappings.$EnumSwitchMapping$1[requestScope.ordinal()]) {
            case 1:
            case 2:
                iNPageStatus = cards.isEmpty() ? INPageStatusPageLoading.INSTANCE : INPageStatusPullLoading.INSTANCE;
                break;
            case 3:
                iNPageStatus = INPageStatusNextPageLoading.INSTANCE;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return new INActionResult(INState.copy$default(currentState, iNPageStatus, cards, null, INStateKt.select(getCurrentState().getFilters(), changeFilter), null, null, Boxing.boxLong(Clock.System.INSTANCE.now().toEpochMilliseconds()), 52, null), new INStateHolder$requestList$2(this, requestScope, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object like(INMessageCard card, Continuation<? super INActionResult> continuation) {
        return new INActionResult(getCurrentState(), new INStateHolder$like$2(card, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object thank(INMessageCard card, Continuation<? super INActionResult> continuation) {
        return new INActionResult(getCurrentState(), new INStateHolder$thank$2(card, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object delete(INMessageCard card, Continuation<? super INActionResult> continuation) {
        return new INActionResult(getCurrentState(), new INStateHolder$delete$2(card, this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object mute(INMessageCard card, Continuation<? super INActionResult> continuation) {
        return new INActionResult(getCurrentState(), new INStateHolder$mute$2(card, this, null));
    }
}