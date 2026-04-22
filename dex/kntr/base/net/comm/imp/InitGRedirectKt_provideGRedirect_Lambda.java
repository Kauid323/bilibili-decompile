package kntr.base.net.comm.imp;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.comm.GRedirect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: InitGRedirectKt_provideGRedirect_Lambda.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u0000H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/base/net/comm/imp/InitGRedirectKt_provideGRedirect_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/net/GInterceptor;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/comm/GRedirect;", "compatJavaParam", "", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "redirect_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitGRedirectKt_provideGRedirect_Lambda extends ProducerBase<GInterceptor> {
    private GDeferred<? extends GRedirect> d_v0;
    private final SuspendProducer<GRedirect> v0;

    public InitGRedirectKt_provideGRedirect_Lambda(SuspendProducer<GRedirect> suspendProducer, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        this.v0 = suspendProducer;
    }

    public InitGRedirectKt_provideGRedirect_Lambda create() {
        return new InitGRedirectKt_provideGRedirect_Lambda(this.v0, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        return r;
    }

    protected Object invokeProducer(Continuation<? super GInterceptor> continuation) {
        GDeferred<? extends GRedirect> gDeferred = this.d_v0;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        return InitGRedirectKt.provideGRedirect((GRedirect) gDeferred.getCompleted());
    }
}