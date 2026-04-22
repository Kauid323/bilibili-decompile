package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.ModEvent;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$ModPoolImpl$fetchRemote$1", f = "KModImpl.kt", i = {0}, l = {169}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"}, v = 1)
final class KModImpl$ModPoolImpl$fetchRemote$1 extends SuspendLambda implements Function2<FlowCollector<? super ModEvent.FetchEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modName;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ KModImpl.ModPoolImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$ModPoolImpl$fetchRemote$1(KModImpl.ModPoolImpl modPoolImpl, String str, Continuation<? super KModImpl$ModPoolImpl$fetchRemote$1> continuation) {
        super(2, continuation);
        this.this$0 = modPoolImpl;
        this.$modName = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$ModPoolImpl$fetchRemote$1 = new KModImpl$ModPoolImpl$fetchRemote$1(this.this$0, this.$modName, continuation);
        kModImpl$ModPoolImpl$fetchRemote$1.L$0 = obj;
        return kModImpl$ModPoolImpl$fetchRemote$1;
    }

    public final Object invoke(FlowCollector<? super ModEvent.FetchEvent> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.label = 1;
                if (FlowKt.emitAll($this$flow, this.this$0.getOrCreateMod(this.$modName).getOrCreateWorkFlow(), (Continuation) this) == coroutine_suspended) {
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