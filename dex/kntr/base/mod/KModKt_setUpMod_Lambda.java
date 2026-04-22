package kntr.base.mod;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.KDownloader.KDownloader.IDownloader;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: KModKt_setUpMod_Lambda.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0012\u001a\u00020\u0000H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u000e\u0010\u0018\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lkntr/base/mod/KModKt_setUpMod_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/mod/KMod;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/KDownloader/KDownloader/IDownloader;", "v1", "Lkntr/base/neuron/IPlatformNeuron;", "v2", "Lkntr/base/mod/KModOptions;", "compatJavaParam", "", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "d_v2", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mod_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KModKt_setUpMod_Lambda extends ProducerBase<KMod> {
    private GDeferred<? extends IDownloader> d_v0;
    private GDeferred<? extends IPlatformNeuron> d_v1;
    private GDeferred<? extends KModOptions> d_v2;
    private final SuspendProducer<IDownloader> v0;
    private final SuspendProducer<IPlatformNeuron> v1;
    private final SuspendProducer<KModOptions> v2;

    public KModKt_setUpMod_Lambda(SuspendProducer<IDownloader> suspendProducer, SuspendProducer<IPlatformNeuron> suspendProducer2, SuspendProducer<KModOptions> suspendProducer3, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        Intrinsics.checkNotNullParameter(suspendProducer3, "v2");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
        this.v2 = suspendProducer3;
    }

    public KModKt_setUpMod_Lambda create() {
        return new KModKt_setUpMod_Lambda(this.v0, this.v1, this.v2, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        this.d_v2 = GenerateHelper.deferred(context, r, this.v2);
        return r;
    }

    protected Object invokeProducer(Continuation<? super KMod> continuation) {
        GDeferred<? extends IDownloader> gDeferred = this.d_v0;
        GDeferred<? extends KModOptions> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        IDownloader iDownloader = (IDownloader) gDeferred.getCompleted();
        GDeferred<? extends IPlatformNeuron> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
            gDeferred3 = null;
        }
        IPlatformNeuron iPlatformNeuron = (IPlatformNeuron) gDeferred3.getCompleted();
        GDeferred<? extends KModOptions> gDeferred4 = this.d_v2;
        if (gDeferred4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v2");
        } else {
            gDeferred2 = gDeferred4;
        }
        return KModKt.setUpMod(iDownloader, iPlatformNeuron, (KModOptions) gDeferred2.getCompleted(), continuation);
    }
}