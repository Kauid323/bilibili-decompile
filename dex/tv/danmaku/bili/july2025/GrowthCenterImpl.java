package tv.danmaku.bili.july2025;

import com.bilibili.app.comm.list.common.growth.july2025.GrowthAction;
import com.bilibili.app.comm.list.common.growth.july2025.GrowthCenter;
import com.bilibili.app.comm.list.common.growth.july2025.GrowthEvent;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import tv.danmaku.bili.BR;

/* compiled from: GrowthCenterImpl.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/july2025/GrowthCenterImpl;", "Lcom/bilibili/app/comm/list/common/growth/july2025/GrowthCenter;", "<init>", "()V", "_events", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/bilibili/app/comm/list/common/growth/july2025/GrowthEvent;", "event", "Lkotlinx/coroutines/flow/SharedFlow;", "getEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "onAction", "", "action", "Lcom/bilibili/app/comm/list/common/growth/july2025/GrowthAction;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GrowthCenterImpl implements GrowthCenter {
    public static final GrowthCenterImpl INSTANCE = new GrowthCenterImpl();
    private static final MutableSharedFlow<GrowthEvent> _events = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    public static final int $stable = 8;

    private GrowthCenterImpl() {
    }

    public SharedFlow<GrowthEvent> getEvent() {
        return FlowKt.asSharedFlow(_events);
    }

    public void onAction(GrowthAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(EmptyCoroutineContext.INSTANCE)), (CoroutineContext) null, (CoroutineStart) null, new GrowthCenterImpl$onAction$1(action, null), 3, (Object) null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(EmptyCoroutineContext.INSTANCE)), (CoroutineContext) null, (CoroutineStart) null, new GrowthCenterImpl$onAction$2(action, null), 3, (Object) null);
    }
}