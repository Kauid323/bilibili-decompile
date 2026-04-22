package kntr.base.mod.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.mod.ModEvent;
import kntr.base.mod.internal.KModImpl;
import kotlin.Metadata;
import kotlin.Pair;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KModImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkntr/base/mod/ModEvent$FetchEvent;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.mod.internal.KModImpl$JobManager$realFetchAndDownload$1", f = "KModImpl.kt", i = {0, 1, 1}, l = {246, 249}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "entry"}, s = {"L$0", "L$0", "L$1"}, v = 1)
public final class KModImpl$JobManager$realFetchAndDownload$1 extends SuspendLambda implements Function2<FlowCollector<? super ModEvent.FetchEvent>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $modName;
    final /* synthetic */ String $poolName;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ KModImpl.JobManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KModImpl$JobManager$realFetchAndDownload$1(KModImpl.JobManager jobManager, String str, String str2, Continuation<? super KModImpl$JobManager$realFetchAndDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = jobManager;
        this.$poolName = str;
        this.$modName = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kModImpl$JobManager$realFetchAndDownload$1 = new KModImpl$JobManager$realFetchAndDownload$1(this.this$0, this.$poolName, this.$modName, continuation);
        kModImpl$JobManager$realFetchAndDownload$1.L$0 = obj;
        return kModImpl$JobManager$realFetchAndDownload$1;
    }

    public final Object invoke(FlowCollector<? super ModEvent.FetchEvent> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object requestSingleMod;
        Pair entry;
        FlowCollector $this$flow = (FlowCollector) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.L$0 = $this$flow;
                this.label = 1;
                requestSingleMod = this.this$0.requestSingleMod(this.$poolName, this.$modName, (Continuation) this);
                if (requestSingleMod == coroutine_suspended) {
                    return coroutine_suspended;
                }
                entry = (Pair) requestSingleMod;
                if (entry != null) {
                    throw new IllegalStateException(("No mod named " + this.this$0.keyOf(this.$poolName, this.$modName) + " from moss.").toString());
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$flow);
                this.L$1 = SpillingKt.nullOutSpilledVariable(entry);
                this.label = 2;
                if (FlowKt.emitAll($this$flow, KModImpl.JobManager.realDownloadAndInstall$default(this.this$0, entry, false, 2, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                requestSingleMod = $result;
                entry = (Pair) requestSingleMod;
                if (entry != null) {
                }
                break;
            case 2:
                Pair pair = (Pair) this.L$1;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}