package home.sidecenter.settings;

import com.bapis.bilibili.app.home.v1.KMineSelectionContentRes;
import com.bapis.bilibili.app.home.v1.KTopLeftTabRes;
import com.tencent.smtt.sdk.TbsListener;
import home.sidecenter.settings.ISideCenterSettingsAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$loadData$1", f = "SideCenterSettingsHolder.kt", i = {0}, l = {151}, m = "invokeSuspend", n = {"$this$SideCenterSettingsActionResult"}, s = {"L$0"}, v = 1)
final class SideCenterSettingsHolder$loadData$1 extends SuspendLambda implements Function2<FlowCollector<? super ISideCenterSettingsAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SideCenterSettingsHolder$loadData$1(Continuation<? super SideCenterSettingsHolder$loadData$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSettingsHolder$loadData$1 = new SideCenterSettingsHolder$loadData$1(continuation);
        sideCenterSettingsHolder$loadData$1.L$0 = obj;
        return sideCenterSettingsHolder$loadData$1;
    }

    public final Object invoke(FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SideCenterSettingsHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$loadData$1$1", f = "SideCenterSettingsHolder.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {174, 175, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 179}, m = "invokeSuspend", n = {"$this$coroutineScope", "exception", "result1", "result2", "$this$coroutineScope", "exception", "result1", "result2", "res1", "$this$coroutineScope", "exception", "result1", "result2", "res1", "res2", "$this$coroutineScope", "exception", "result1", "result2", "res1", "res2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    /* renamed from: home.sidecenter.settings.SideCenterSettingsHolder$loadData$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<ISideCenterSettingsAction> $$this$SideCenterSettingsActionResult;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$$this$SideCenterSettingsActionResult = flowCollector;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$$this$SideCenterSettingsActionResult, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x00df A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0165 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0166  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object $result) {
            Deferred result1;
            Deferred result2;
            Object await;
            Ref.ObjectRef exception;
            KTopLeftTabRes res1;
            Object await2;
            Ref.ObjectRef exception2;
            Deferred result12;
            KMineSelectionContentRes res2;
            CoroutineScope $this$coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Ref.ObjectRef exception3 = new Ref.ObjectRef();
                    result1 = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideCenterSettingsHolder$loadData$1$1$result1$1(exception3, null), 3, (Object) null);
                    result2 = BuildersKt.async$default($this$coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SideCenterSettingsHolder$loadData$1$1$result2$1(exception3, null), 3, (Object) null);
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = exception3;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                    this.L$3 = result2;
                    this.label = 1;
                    await = result1.await((Continuation) this);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    exception = exception3;
                    res1 = (KTopLeftTabRes) await;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = exception;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(result2);
                    this.L$4 = res1;
                    this.label = 2;
                    await2 = result2.await((Continuation) this);
                    if (await2 != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    exception2 = exception;
                    result12 = result2;
                    res2 = (KMineSelectionContentRes) await2;
                    if (res1 == null || res2 != null) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(exception2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(result12);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(res1);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(res2);
                        this.label = 4;
                        if (this.$$this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.LoadDataSuccess(new SideCenterSettingsState(res1, res2)), (Continuation) this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(exception2);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(result12);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(res1);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(res2);
                        this.label = 3;
                        if (this.$$this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.LoadDataFailed((Throwable) exception2.element), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    result2 = (Deferred) this.L$3;
                    exception = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure($result);
                    result1 = (Deferred) this.L$2;
                    await = $result;
                    res1 = (KTopLeftTabRes) await;
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = exception;
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(result2);
                    this.L$4 = res1;
                    this.label = 2;
                    await2 = result2.await((Continuation) this);
                    if (await2 != coroutine_suspended) {
                    }
                    break;
                case 2:
                    ResultKt.throwOnFailure($result);
                    result1 = (Deferred) this.L$2;
                    exception2 = (Ref.ObjectRef) this.L$1;
                    await2 = $result;
                    result12 = (Deferred) this.L$3;
                    res1 = (KTopLeftTabRes) this.L$4;
                    res2 = (KMineSelectionContentRes) await2;
                    if (res1 == null) {
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$coroutineScope);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(exception2);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result1);
                    this.L$3 = SpillingKt.nullOutSpilledVariable(result12);
                    this.L$4 = SpillingKt.nullOutSpilledVariable(res1);
                    this.L$5 = SpillingKt.nullOutSpilledVariable(res2);
                    this.label = 4;
                    if (this.$$this$SideCenterSettingsActionResult.emit(new ISideCenterSettingsAction.LoadDataSuccess(new SideCenterSettingsState(res1, res2)), (Continuation) this) != coroutine_suspended) {
                    }
                    break;
                case 3:
                    KMineSelectionContentRes kMineSelectionContentRes = (KMineSelectionContentRes) this.L$5;
                    KTopLeftTabRes kTopLeftTabRes = (KTopLeftTabRes) this.L$4;
                    Deferred deferred = (Deferred) this.L$3;
                    Deferred deferred2 = (Deferred) this.L$2;
                    Ref.ObjectRef objectRef = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                case 4:
                    KMineSelectionContentRes kMineSelectionContentRes2 = (KMineSelectionContentRes) this.L$5;
                    KTopLeftTabRes kTopLeftTabRes2 = (KTopLeftTabRes) this.L$4;
                    Deferred deferred3 = (Deferred) this.L$3;
                    Deferred deferred4 = (Deferred) this.L$2;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.L$1;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$SideCenterSettingsActionResult = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$SideCenterSettingsActionResult);
                this.label = 1;
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1($this$SideCenterSettingsActionResult, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}