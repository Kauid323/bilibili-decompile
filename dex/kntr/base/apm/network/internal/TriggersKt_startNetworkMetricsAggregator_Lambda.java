package kntr.base.apm.network.internal;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.IPlatformConfig;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: TriggersKt_startNetworkMetricsAggregator_Lambda.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u000e\u001a\u00020\u0000H\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u000e\u0010\u0014\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lkntr/base/apm/network/internal/TriggersKt_startNetworkMetricsAggregator_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/config/IPlatformConfig;", "v1", "Lkntr/base/neuron/IPlatformNeuron;", "compatJavaParam", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TriggersKt_startNetworkMetricsAggregator_Lambda extends ProducerBase<Unit> {
    private GDeferred<? extends IPlatformConfig> d_v0;
    private GDeferred<? extends IPlatformNeuron> d_v1;
    private final SuspendProducer<IPlatformConfig> v0;
    private final SuspendProducer<IPlatformNeuron> v1;

    public TriggersKt_startNetworkMetricsAggregator_Lambda(SuspendProducer<IPlatformConfig> suspendProducer, SuspendProducer<IPlatformNeuron> suspendProducer2, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
    }

    public TriggersKt_startNetworkMetricsAggregator_Lambda create() {
        return new TriggersKt_startNetworkMetricsAggregator_Lambda(this.v0, this.v1, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        return r;
    }

    protected Object invokeProducer(Continuation<? super Unit> continuation) {
        GDeferred<? extends IPlatformConfig> gDeferred = this.d_v0;
        GDeferred<? extends IPlatformNeuron> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        IPlatformConfig iPlatformConfig = (IPlatformConfig) gDeferred.getCompleted();
        GDeferred<? extends IPlatformNeuron> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
        } else {
            gDeferred2 = gDeferred3;
        }
        TriggersKt.startNetworkMetricsAggregator(iPlatformConfig, (IPlatformNeuron) gDeferred2.getCompleted());
        return Unit.INSTANCE;
    }
}