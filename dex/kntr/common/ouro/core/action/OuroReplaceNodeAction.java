package kntr.common.ouro.core.action;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lkntr/common/ouro/core/action/OuroReplaceNodeAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "old", "Lkntr/common/ouro/core/model/node/OuroNode;", "node", "preserveChildren", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/node/OuroNode;ZLkotlinx/coroutines/CompletableDeferred;)V", "getOld", "()Lkntr/common/ouro/core/model/node/OuroNode;", "getNode", "getPreserveChildren", "()Z", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroReplaceNodeAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroNode node;
    private final OuroNode old;
    private final boolean preserveChildren;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroReplaceNodeAction copy$default(OuroReplaceNodeAction ouroReplaceNodeAction, OuroNode ouroNode, OuroNode ouroNode2, boolean z, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroNode = ouroReplaceNodeAction.old;
        }
        if ((i & 2) != 0) {
            ouroNode2 = ouroReplaceNodeAction.node;
        }
        if ((i & 4) != 0) {
            z = ouroReplaceNodeAction.preserveChildren;
        }
        if ((i & 8) != 0) {
            completableDeferred = ouroReplaceNodeAction.deferred;
        }
        return ouroReplaceNodeAction.copy(ouroNode, ouroNode2, z, completableDeferred);
    }

    public final OuroNode component1() {
        return this.old;
    }

    public final OuroNode component2() {
        return this.node;
    }

    public final boolean component3() {
        return this.preserveChildren;
    }

    public final CompletableDeferred<OuroState> component4() {
        return this.deferred;
    }

    public final OuroReplaceNodeAction copy(OuroNode ouroNode, OuroNode ouroNode2, boolean z, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(ouroNode, "old");
        Intrinsics.checkNotNullParameter(ouroNode2, "node");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroReplaceNodeAction(ouroNode, ouroNode2, z, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroReplaceNodeAction) {
            OuroReplaceNodeAction ouroReplaceNodeAction = (OuroReplaceNodeAction) obj;
            return Intrinsics.areEqual(this.old, ouroReplaceNodeAction.old) && Intrinsics.areEqual(this.node, ouroReplaceNodeAction.node) && this.preserveChildren == ouroReplaceNodeAction.preserveChildren && Intrinsics.areEqual(this.deferred, ouroReplaceNodeAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.old.hashCode() * 31) + this.node.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.preserveChildren)) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroNode ouroNode = this.old;
        OuroNode ouroNode2 = this.node;
        boolean z = this.preserveChildren;
        return "OuroReplaceNodeAction(old=" + ouroNode + ", node=" + ouroNode2 + ", preserveChildren=" + z + ", deferred=" + this.deferred + ")";
    }

    public OuroReplaceNodeAction(OuroNode old, OuroNode node, boolean preserveChildren, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.old = old;
        this.node = node;
        this.preserveChildren = preserveChildren;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroReplaceNodeAction(OuroNode ouroNode, OuroNode ouroNode2, boolean z, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroNode, ouroNode2, (i & 4) != 0 ? true : z, (i & 8) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroNode getOld() {
        return this.old;
    }

    public final OuroNode getNode() {
        return this.node;
    }

    public final boolean getPreserveChildren() {
        return this.preserveChildren;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}