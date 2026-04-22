package kntr.app.upper.entrance.bubble2;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.ab.AbParamsProvider;
import kntr.base.account.KAccountStore;
import kntr.base.primer.GPrimerBizParamsList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u000f\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u000e\u0010\u0015\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkntr/app/upper/entrance/bubble2/ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/primer/GPrimerBizParamsList;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/account/KAccountStore;", "v1", "Lkntr/app/upper/entrance/ab/AbParamsProvider;", "compatJavaParam", "", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda extends ProducerBase<GPrimerBizParamsList> {
    private GDeferred<KAccountStore> d_v0;
    private GDeferred<? extends AbParamsProvider> d_v1;
    private final SuspendProducer<KAccountStore> v0;
    private final SuspendProducer<AbParamsProvider> v1;

    public ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda(SuspendProducer<KAccountStore> suspendProducer, SuspendProducer<AbParamsProvider> suspendProducer2, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
    }

    public ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda create() {
        return new ColdStartBubbleKt_provideColdStartBubbleInfoParams_Lambda(this.v0, this.v1, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        return r;
    }

    protected Object invokeProducer(Continuation<? super GPrimerBizParamsList> continuation) {
        GDeferred<KAccountStore> gDeferred = this.d_v0;
        GDeferred<? extends AbParamsProvider> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        KAccountStore kAccountStore = (KAccountStore) gDeferred.getCompleted();
        GDeferred<? extends AbParamsProvider> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
        } else {
            gDeferred2 = gDeferred3;
        }
        return ColdStartBubbleKt.provideColdStartBubbleInfoParams(kAccountStore, (AbParamsProvider) gDeferred2.getCompleted());
    }
}