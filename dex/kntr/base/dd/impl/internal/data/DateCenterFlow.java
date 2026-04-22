package kntr.base.dd.impl.internal.data;

import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.utils.CoroutineExKt;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: DateCenterFlow.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0006J\u0014\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\u0018\u001a\u00020\u00142\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u0019"}, d2 = {"Lkntr/base/dd/impl/internal/data/DateCenterFlow;", "", "<init>", "()V", "_versions", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkntr/base/dd/IDeviceDecision$Version;", "_nodes", "", "", "_props", "versions", "Lkotlinx/coroutines/flow/Flow;", "getVersions", "()Lkotlinx/coroutines/flow/Flow;", "nodes", "getNodes", "props", "getProps", "didUpdatedVersion", "", AppKey.VERSION, "didUpdatedNodes", "keys", "didUpdatedProps", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DateCenterFlow {
    private final MutableSharedFlow<IDeviceDecision.Version> _versions = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
    private final MutableSharedFlow<Set<String>> _nodes = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
    private final MutableSharedFlow<Set<String>> _props = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);

    public final Flow<IDeviceDecision.Version> getVersions() {
        return FlowKt.asSharedFlow(this._versions);
    }

    public final Flow<Set<String>> getNodes() {
        return FlowKt.asSharedFlow(this._nodes);
    }

    public final Flow<Set<String>> getProps() {
        return FlowKt.asSharedFlow(this._props);
    }

    public final void didUpdatedVersion(IDeviceDecision.Version version) {
        Intrinsics.checkNotNullParameter(version, AppKey.VERSION);
        BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DateCenterFlow$didUpdatedVersion$1(this, version, null), 3, (Object) null);
    }

    public final void didUpdatedNodes(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "keys");
        if (!set.isEmpty()) {
            BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DateCenterFlow$didUpdatedNodes$1(this, set, null), 3, (Object) null);
        }
    }

    public final void didUpdatedProps(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "props");
        if (!set.isEmpty()) {
            BuildersKt.launch$default(CoroutineExKt.createIOScope(), (CoroutineContext) null, (CoroutineStart) null, new DateCenterFlow$didUpdatedProps$1(this, set, null), 3, (Object) null);
        }
    }
}