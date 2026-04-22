package im.session.di;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import im.session.service.IMSessionDataCacheService;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.base.account.KAccountStore;
import kntr.common.restricted.IRestrictedMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: IMCacheObserverKt_establishCacheObserver_Lambda.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0000H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lim/session/di/IMCacheObserverKt_establishCacheObserver_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/account/KAccountStore;", "v1", "Lim/session/service/IMSessionDataCacheService;", "v2", "Lkntr/common/restricted/IRestrictedMode;", "compatJavaParam", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "d_v2", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMCacheObserverKt_establishCacheObserver_Lambda extends ProducerBase<Unit> {
    private GDeferred<KAccountStore> d_v0;
    private GDeferred<? extends IMSessionDataCacheService> d_v1;
    private GDeferred<? extends IRestrictedMode> d_v2;
    private final SuspendProducer<KAccountStore> v0;
    private final SuspendProducer<IMSessionDataCacheService> v1;
    private final SuspendProducer<IRestrictedMode> v2;

    public IMCacheObserverKt_establishCacheObserver_Lambda(SuspendProducer<KAccountStore> suspendProducer, SuspendProducer<IMSessionDataCacheService> suspendProducer2, SuspendProducer<IRestrictedMode> suspendProducer3, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        Intrinsics.checkNotNullParameter(suspendProducer3, "v2");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
        this.v2 = suspendProducer3;
    }

    public IMCacheObserverKt_establishCacheObserver_Lambda create() {
        return new IMCacheObserverKt_establishCacheObserver_Lambda(this.v0, this.v1, this.v2, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        this.d_v2 = GenerateHelper.deferred(context, r, this.v2);
        return r;
    }

    protected Object invokeProducer(Continuation<? super Unit> continuation) {
        GDeferred<KAccountStore> gDeferred = this.d_v0;
        GDeferred<? extends IRestrictedMode> gDeferred2 = null;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        KAccountStore kAccountStore = (KAccountStore) gDeferred.getCompleted();
        GDeferred<? extends IMSessionDataCacheService> gDeferred3 = this.d_v1;
        if (gDeferred3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
            gDeferred3 = null;
        }
        IMSessionDataCacheService iMSessionDataCacheService = (IMSessionDataCacheService) gDeferred3.getCompleted();
        GDeferred<? extends IRestrictedMode> gDeferred4 = this.d_v2;
        if (gDeferred4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v2");
        } else {
            gDeferred2 = gDeferred4;
        }
        IMCacheObserverKt.establishCacheObserver(kAccountStore, iMSessionDataCacheService, (IRestrictedMode) gDeferred2.getCompleted());
        return Unit.INSTANCE;
    }
}