package kntr.base.net.comm.imp;

import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.GInterceptor;
import kntr.base.net.freedata.GFreeData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FreeDataImpKt_provideFreeDataRequest_Lambda.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0000H\u0016J\u000e\u0010\u000b\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/base/net/comm/imp/FreeDataImpKt_provideFreeDataRequest_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lkntr/base/net/GInterceptor;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lkntr/base/net/freedata/GFreeData;", "compatJavaParam", "", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "free_data_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FreeDataImpKt_provideFreeDataRequest_Lambda extends ProducerBase<GInterceptor> {
    private final SuspendProducer<GFreeData> v0;

    public FreeDataImpKt_provideFreeDataRequest_Lambda(SuspendProducer<GFreeData> suspendProducer, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        this.v0 = suspendProducer;
    }

    public FreeDataImpKt_provideFreeDataRequest_Lambda create() {
        return new FreeDataImpKt_provideFreeDataRequest_Lambda(this.v0, null);
    }

    protected Object invokeProducer(Continuation<? super GInterceptor> continuation) {
        return FreeDataImpKt.provideFreeDataRequest(this.v0);
    }
}