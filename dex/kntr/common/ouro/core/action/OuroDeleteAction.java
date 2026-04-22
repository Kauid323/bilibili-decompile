package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/action/OuroDeleteAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "compositionRange", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getCompositionRange", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDeleteAction implements OuroEditAction, OuroSyncAction {
    private final OuroTextRange compositionRange;
    private final CompletableDeferred<OuroState> deferred;
    private final OuroTextRange range;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroDeleteAction copy$default(OuroDeleteAction ouroDeleteAction, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroTextRange = ouroDeleteAction.range;
        }
        if ((i & 2) != 0) {
            ouroTextRange2 = ouroDeleteAction.compositionRange;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroDeleteAction.deferred;
        }
        return ouroDeleteAction.copy(ouroTextRange, ouroTextRange2, completableDeferred);
    }

    public final OuroTextRange component1() {
        return this.range;
    }

    public final OuroTextRange component2() {
        return this.compositionRange;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroDeleteAction copy(OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(ouroTextRange, "range");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroDeleteAction(ouroTextRange, ouroTextRange2, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroDeleteAction) {
            OuroDeleteAction ouroDeleteAction = (OuroDeleteAction) obj;
            return Intrinsics.areEqual(this.range, ouroDeleteAction.range) && Intrinsics.areEqual(this.compositionRange, ouroDeleteAction.compositionRange) && Intrinsics.areEqual(this.deferred, ouroDeleteAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.range.hashCode() * 31) + (this.compositionRange == null ? 0 : this.compositionRange.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroTextRange ouroTextRange = this.range;
        OuroTextRange ouroTextRange2 = this.compositionRange;
        return "OuroDeleteAction(range=" + ouroTextRange + ", compositionRange=" + ouroTextRange2 + ", deferred=" + this.deferred + ")";
    }

    public OuroDeleteAction(OuroTextRange range, OuroTextRange compositionRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.range = range;
        this.compositionRange = compositionRange;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroDeleteAction(OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroTextRange, (i & 2) != 0 ? null : ouroTextRange2, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    public final OuroTextRange getCompositionRange() {
        return this.compositionRange;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}