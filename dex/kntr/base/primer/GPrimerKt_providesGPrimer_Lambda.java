package kntr.base.primer;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.KAccountStore;
import kntr.base.net.GNetPublicHeader;
import kntr.base.net.GNetPublicParam;
import kntr.base.net.GNetPublicParamList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: GPrimerKt_providesGPrimer_Lambda.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0083\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004\u0012\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0017\u001a\u00020\u0000H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u000e\u0010\u001d\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u001eR\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkntr/base/primer/GPrimerKt_providesGPrimer_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/primer/GPrimer;", "v0", "", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/GNetPublicParam;", "v1", "Lkntr/base/net/GNetPublicParamList;", "v2", "Lkntr/base/net/GNetPublicHeader;", "v3", "Lkntr/base/primer/GPrimerBizParams;", "v4", "Lkntr/base/primer/GPrimerBizParamsList;", "v5", "Lkntr/base/account/KAccountStore;", "compatJavaParam", "", "<init>", "(Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v5", "Lcom/bilibili/lib/gripper/api/GDeferred;", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "primer_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GPrimerKt_providesGPrimer_Lambda extends ProducerBase<GPrimer> {
    private GDeferred<KAccountStore> d_v5;
    private final Set<SuspendProducer<GNetPublicParam>> v0;
    private final Set<SuspendProducer<GNetPublicParamList>> v1;
    private final Set<SuspendProducer<GNetPublicHeader>> v2;
    private final Set<SuspendProducer<GPrimerBizParams>> v3;
    private final Set<SuspendProducer<GPrimerBizParamsList>> v4;
    private final SuspendProducer<KAccountStore> v5;

    public GPrimerKt_providesGPrimer_Lambda(Set<? extends SuspendProducer<GNetPublicParam>> set, Set<? extends SuspendProducer<GNetPublicParamList>> set2, Set<? extends SuspendProducer<GNetPublicHeader>> set3, Set<? extends SuspendProducer<GPrimerBizParams>> set4, Set<? extends SuspendProducer<GPrimerBizParamsList>> set5, SuspendProducer<KAccountStore> suspendProducer, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(set, "v0");
        Intrinsics.checkNotNullParameter(set2, "v1");
        Intrinsics.checkNotNullParameter(set3, "v2");
        Intrinsics.checkNotNullParameter(set4, "v3");
        Intrinsics.checkNotNullParameter(set5, "v4");
        Intrinsics.checkNotNullParameter(suspendProducer, "v5");
        this.v0 = set;
        this.v1 = set2;
        this.v2 = set3;
        this.v3 = set4;
        this.v4 = set5;
        this.v5 = suspendProducer;
    }

    public GPrimerKt_providesGPrimer_Lambda create() {
        return new GPrimerKt_providesGPrimer_Lambda(this.v0, this.v1, this.v2, this.v3, this.v4, this.v5, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v5 = GenerateHelper.deferred(context, r, this.v5);
        return r;
    }

    protected Object invokeProducer(Continuation<? super GPrimer> continuation) {
        Set<SuspendProducer<GNetPublicParam>> set = this.v0;
        Set<SuspendProducer<GNetPublicParamList>> set2 = this.v1;
        Set<SuspendProducer<GNetPublicHeader>> set3 = this.v2;
        Set<SuspendProducer<GPrimerBizParams>> set4 = this.v3;
        Set<SuspendProducer<GPrimerBizParamsList>> set5 = this.v4;
        GDeferred<KAccountStore> gDeferred = this.d_v5;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v5");
            gDeferred = null;
        }
        return GPrimerKt.providesGPrimer(set, set2, set3, set4, set5, (KAccountStore) gDeferred.getCompleted());
    }
}