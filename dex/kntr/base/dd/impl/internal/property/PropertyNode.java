package kntr.base.dd.impl.internal.property;

import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.impl.internal.common.UtilsKt;
import kntr.base.dd.impl.internal.model.DDProp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;

/* compiled from: PropertyNode.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u0019"}, d2 = {"Lkntr/base/dd/impl/internal/property/PropertyNode;", "", "prop", "Lkntr/base/dd/impl/internal/model/DDProp;", "node", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "<init>", "(Lkntr/base/dd/impl/internal/model/DDProp;Lkntr/base/dd/IDeviceDecisionProperty$Node;)V", "Lkotlinx/atomicfu/AtomicRef;", "updateLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "name", "", "getName", "()Ljava/lang/String;", "getValue", "extra", "isCacheable", "", "()Z", "isTrackable", "updateNode", "other", "updateProp", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PropertyNode {
    private final AtomicRef<IDeviceDecisionProperty.Node> node;
    private final AtomicRef<DDProp> prop;
    private final ReentrantLock updateLock;

    public PropertyNode() {
        this(null, null, 3, null);
    }

    public PropertyNode(DDProp prop, IDeviceDecisionProperty.Node node) {
        this.prop = AtomicFU.atomic(prop);
        this.node = AtomicFU.atomic(node);
        this.updateLock = new ReentrantLock();
    }

    public /* synthetic */ PropertyNode(DDProp dDProp, IDeviceDecisionProperty.Node node, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : dDProp, (i & 2) != 0 ? null : node);
    }

    public final String getName() {
        String name;
        DDProp dDProp = (DDProp) this.prop.getValue();
        if (dDProp == null || (name = dDProp.getName()) == null) {
            IDeviceDecisionProperty.Node node = (IDeviceDecisionProperty.Node) this.node.getValue();
            return node != null ? node.getName() : "";
        }
        return name;
    }

    public final String getValue(String extra) {
        String value;
        IDeviceDecisionProperty.Node node = (IDeviceDecisionProperty.Node) this.node.getValue();
        if (node == null || (value = node.value(extra)) == null) {
            DDProp dDProp = (DDProp) this.prop.getValue();
            if (dDProp != null) {
                return dDProp.getDefault();
            }
            return null;
        }
        return value;
    }

    public final boolean isCacheable() {
        Integer cache;
        DDProp dDProp = (DDProp) this.prop.getValue();
        return (dDProp == null || (cache = dDProp.getCache()) == null || cache.intValue() != 1) ? false : true;
    }

    public final boolean isTrackable() {
        DDProp it = (DDProp) this.prop.getValue();
        if (it != null) {
            if (!Intrinsics.areEqual(it.getTrack(), true)) {
                it = null;
            }
            if (it != null) {
                Double rate = it.getRate();
                return UtilsKt.randomHitsProbability$default(rate != null ? rate.doubleValue() : 0.0d, 0.0d, 2, null);
            }
        }
        return false;
    }

    public final boolean updateNode(IDeviceDecisionProperty.Node other) {
        Intrinsics.checkNotNullParameter(other, "other");
        ReentrantLock $this$with$iv = this.updateLock;
        $this$with$iv.lock();
        try {
            if (Intrinsics.areEqual(other.getName(), getName()) && this.node.getValue() == null) {
                this.node.setValue(other);
                $this$with$iv.unlock();
                return true;
            }
            $this$with$iv.unlock();
            return false;
        } catch (Throwable th) {
            $this$with$iv.unlock();
            throw th;
        }
    }

    public final boolean updateProp(DDProp other) {
        ReentrantLock $this$with$iv = this.updateLock;
        $this$with$iv.lock();
        try {
            DDProp prop = (DDProp) this.prop.getValue();
            boolean z = false;
            if (other != null || prop != null) {
                if (!Intrinsics.areEqual(other != null ? other.getCache() : null, prop != null ? prop.getCache() : null)) {
                    z = true;
                } else if (this.node.getValue() == null) {
                    z = Intrinsics.areEqual(other != null ? other.getDefault() : null, prop != null ? prop.getDefault() : null);
                }
                this.prop.setValue(other);
            }
            return z;
        } finally {
            $this$with$iv.unlock();
        }
    }
}