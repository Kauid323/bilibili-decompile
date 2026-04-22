package kntr.common.ouro.core.action;

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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/action/OuroInsertTextNodeAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "node", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getNode", "()Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroInsertTextNodeAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroTextElement.Plain node;
    private final OuroTextRange range;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroInsertTextNodeAction copy$default(OuroInsertTextNodeAction ouroInsertTextNodeAction, OuroTextElement.Plain plain, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            plain = ouroInsertTextNodeAction.node;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroInsertTextNodeAction.range;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroInsertTextNodeAction.deferred;
        }
        return ouroInsertTextNodeAction.copy(plain, ouroTextRange, completableDeferred);
    }

    public final OuroTextElement.Plain component1() {
        return this.node;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroInsertTextNodeAction copy(OuroTextElement.Plain plain, OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(plain, "node");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroInsertTextNodeAction(plain, ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroInsertTextNodeAction) {
            OuroInsertTextNodeAction ouroInsertTextNodeAction = (OuroInsertTextNodeAction) obj;
            return Intrinsics.areEqual(this.node, ouroInsertTextNodeAction.node) && Intrinsics.areEqual(this.range, ouroInsertTextNodeAction.range) && Intrinsics.areEqual(this.deferred, ouroInsertTextNodeAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.node.hashCode() * 31) + (this.range == null ? 0 : this.range.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroTextElement.Plain plain = this.node;
        OuroTextRange ouroTextRange = this.range;
        return "OuroInsertTextNodeAction(node=" + plain + ", range=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    public OuroInsertTextNodeAction(OuroTextElement.Plain node, OuroTextRange range, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.node = node;
        this.range = range;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroInsertTextNodeAction(OuroTextElement.Plain plain, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(plain, (i & 2) != 0 ? null : ouroTextRange, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroTextElement.Plain getNode() {
        return this.node;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}