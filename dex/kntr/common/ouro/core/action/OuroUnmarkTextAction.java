package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\u0019\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/core/action/OuroUnmarkTextAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkotlinx/coroutines/CompletableDeferred;)V", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroUnmarkTextAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;

    public OuroUnmarkTextAction() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroUnmarkTextAction copy$default(OuroUnmarkTextAction ouroUnmarkTextAction, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            completableDeferred = ouroUnmarkTextAction.deferred;
        }
        return ouroUnmarkTextAction.copy(completableDeferred);
    }

    public final CompletableDeferred<OuroState> component1() {
        return this.deferred;
    }

    public final OuroUnmarkTextAction copy(CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroUnmarkTextAction(completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroUnmarkTextAction) && Intrinsics.areEqual(this.deferred, ((OuroUnmarkTextAction) obj).deferred);
    }

    public int hashCode() {
        return this.deferred.hashCode();
    }

    public String toString() {
        return "OuroUnmarkTextAction(deferred=" + this.deferred + ")";
    }

    public OuroUnmarkTextAction(CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroUnmarkTextAction(CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}