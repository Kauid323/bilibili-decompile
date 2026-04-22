package kntr.base.moss;

import com.bilibili.lib.gripper.api.internal.ProducerBase;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: GripperMossKt_initKmoss_Lambda.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0000H\u0016J\u000e\u0010\u0007\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lkntr/base/moss/GripperMossKt_initKmoss_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "compatJavaParam", "<init>", "(Lkotlin/Unit;)V", "create", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GripperMossKt_initKmoss_Lambda extends ProducerBase<Unit> {
    public GripperMossKt_initKmoss_Lambda(Unit compatJavaParam) {
    }

    public GripperMossKt_initKmoss_Lambda create() {
        return new GripperMossKt_initKmoss_Lambda(null);
    }

    protected Object invokeProducer(Continuation<? super Unit> continuation) {
        GripperMossKt.initKmoss();
        return Unit.INSTANCE;
    }
}