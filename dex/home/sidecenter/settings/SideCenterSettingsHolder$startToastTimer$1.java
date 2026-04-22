package home.sidecenter.settings;

import home.sidecenter.settings.ISideCenterSettingsAction;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SideCenterSettingsHolder.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lhome/sidecenter/settings/ISideCenterSettingsAction;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$startToastTimer$1", f = "SideCenterSettingsHolder.kt", i = {0}, l = {133}, m = "invokeSuspend", n = {"$this$SideCenterSettingsActionResult"}, s = {"L$0"}, v = 1)
public final class SideCenterSettingsHolder$startToastTimer$1 extends SuspendLambda implements Function2<FlowCollector<? super ISideCenterSettingsAction>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SideCenterSettingsHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideCenterSettingsHolder$startToastTimer$1(SideCenterSettingsHolder sideCenterSettingsHolder, Continuation<? super SideCenterSettingsHolder$startToastTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = sideCenterSettingsHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> sideCenterSettingsHolder$startToastTimer$1 = new SideCenterSettingsHolder$startToastTimer$1(this.this$0, continuation);
        sideCenterSettingsHolder$startToastTimer$1.L$0 = obj;
        return sideCenterSettingsHolder$startToastTimer$1;
    }

    public final Object invoke(FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SideCenterSettingsHolder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "home.sidecenter.settings.SideCenterSettingsHolder$startToastTimer$1$1", f = "SideCenterSettingsHolder.kt", i = {0, 1}, l = {136, 139}, m = "invokeSuspend", n = {"dismissId", "dismissId"}, s = {"I$0", "I$0"}, v = 1)
    /* renamed from: home.sidecenter.settings.SideCenterSettingsHolder$startToastTimer$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FlowCollector<ISideCenterSettingsAction> $$this$SideCenterSettingsActionResult;
        int I$0;
        int label;
        final /* synthetic */ SideCenterSettingsHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(SideCenterSettingsHolder sideCenterSettingsHolder, FlowCollector<? super ISideCenterSettingsAction> flowCollector, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = sideCenterSettingsHolder;
            this.$$this$SideCenterSettingsActionResult = flowCollector;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$$this$SideCenterSettingsActionResult, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            SideCenterSettingsState currentState;
            int dismissId;
            SideCenterSettingsState currentState2;
            SideCenterSettingsState currentState3;
            int dismissId2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    currentState = this.this$0.getCurrentState();
                    dismissId = currentState.getToastDismissDelayId$sidecenter_debug();
                    KLog_androidKt.getKLog().i("SideCenterSettingsHolder", "Start toast id" + dismissId + " disappear timer");
                    this.I$0 = dismissId;
                    this.label = 1;
                    if (DelayKt.delay(5000L, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    dismissId = this.I$0;
                    ResultKt.throwOnFailure($result);
                    break;
                case 2:
                    dismissId2 = this.I$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            currentState2 = this.this$0.getCurrentState();
            if (dismissId == currentState2.getToastDismissDelayId$sidecenter_debug()) {
                KLog_androidKt.getKLog().i("SideCenterSettingsHolder", "Complete toast id" + dismissId + " disappear timer");
                this.I$0 = dismissId;
                this.label = 2;
                if (this.$$this$SideCenterSettingsActionResult.emit(ISideCenterSettingsAction.CheckedMineTabToastDismiss.INSTANCE, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                dismissId2 = dismissId;
                return Unit.INSTANCE;
            }
            ILogger kLog = KLog_androidKt.getKLog();
            currentState3 = this.this$0.getCurrentState();
            kLog.i("SideCenterSettingsHolder", "Suspend toast id" + dismissId + " disappear timer, current toast id is " + currentState3.getToastDismissDelayId$sidecenter_debug());
            return Unit.INSTANCE;
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
                if (CoroutineScopeKt.coroutineScope(new AnonymousClass1(this.this$0, $this$SideCenterSettingsActionResult, null), (Continuation) this) == coroutine_suspended) {
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