package kntr.common.ouro.core.action;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lkntr/common/ouro/core/action/OuroInsertTextNodesAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "nodes", "", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/util/List;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getNodes", "()Ljava/util/List;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroInsertTextNodesAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final List<OuroTextElement.Plain> nodes;
    private final OuroTextRange range;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroInsertTextNodesAction copy$default(OuroInsertTextNodesAction ouroInsertTextNodesAction, List list, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ouroInsertTextNodesAction.nodes;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroInsertTextNodesAction.range;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroInsertTextNodesAction.deferred;
        }
        return ouroInsertTextNodesAction.copy(list, ouroTextRange, completableDeferred);
    }

    public final List<OuroTextElement.Plain> component1() {
        return this.nodes;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroInsertTextNodesAction copy(List<OuroTextElement.Plain> list, OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroInsertTextNodesAction(list, ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroInsertTextNodesAction) {
            OuroInsertTextNodesAction ouroInsertTextNodesAction = (OuroInsertTextNodesAction) obj;
            return Intrinsics.areEqual(this.nodes, ouroInsertTextNodesAction.nodes) && Intrinsics.areEqual(this.range, ouroInsertTextNodesAction.range) && Intrinsics.areEqual(this.deferred, ouroInsertTextNodesAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.nodes.hashCode() * 31) + (this.range == null ? 0 : this.range.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        List<OuroTextElement.Plain> list = this.nodes;
        OuroTextRange ouroTextRange = this.range;
        return "OuroInsertTextNodesAction(nodes=" + list + ", range=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    public OuroInsertTextNodesAction(List<OuroTextElement.Plain> list, OuroTextRange range, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.nodes = list;
        this.range = range;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroInsertTextNodesAction(List list, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : ouroTextRange, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final List<OuroTextElement.Plain> getNodes() {
        return this.nodes;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}