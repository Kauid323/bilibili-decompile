package kntr.common.ouro.core.plugin.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroSyncAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.node.OuroUniversalLink;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroPasteboardAction.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lkntr/common/ouro/core/plugin/pasteboard/OuroPasteLinkAction;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "linkStorage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroUniversalLink;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/NodeStorage;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getLinkStorage", "()Lkntr/common/ouro/core/model/NodeStorage;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroPasteLinkAction implements OuroAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final NodeStorage<OuroUniversalLink> linkStorage;
    private final OuroTextRange range;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroPasteLinkAction copy$default(OuroPasteLinkAction ouroPasteLinkAction, NodeStorage nodeStorage, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            nodeStorage = ouroPasteLinkAction.linkStorage;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroPasteLinkAction.range;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroPasteLinkAction.deferred;
        }
        return ouroPasteLinkAction.copy(nodeStorage, ouroTextRange, completableDeferred);
    }

    public final NodeStorage<OuroUniversalLink> component1() {
        return this.linkStorage;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroPasteLinkAction copy(NodeStorage<OuroUniversalLink> nodeStorage, OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(nodeStorage, "linkStorage");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroPasteLinkAction(nodeStorage, ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroPasteLinkAction) {
            OuroPasteLinkAction ouroPasteLinkAction = (OuroPasteLinkAction) obj;
            return Intrinsics.areEqual(this.linkStorage, ouroPasteLinkAction.linkStorage) && Intrinsics.areEqual(this.range, ouroPasteLinkAction.range) && Intrinsics.areEqual(this.deferred, ouroPasteLinkAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.linkStorage.hashCode() * 31) + (this.range == null ? 0 : this.range.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        NodeStorage<OuroUniversalLink> nodeStorage = this.linkStorage;
        OuroTextRange ouroTextRange = this.range;
        return "OuroPasteLinkAction(linkStorage=" + nodeStorage + ", range=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    public OuroPasteLinkAction(NodeStorage<OuroUniversalLink> nodeStorage, OuroTextRange range, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(nodeStorage, "linkStorage");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.linkStorage = nodeStorage;
        this.range = range;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroPasteLinkAction(NodeStorage nodeStorage, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nodeStorage, (i & 2) != 0 ? null : ouroTextRange, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final NodeStorage<OuroUniversalLink> getLinkStorage() {
        return this.linkStorage;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}