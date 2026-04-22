package kntr.common.ouro.core.plugin.pasteboard;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroSyncAction;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroPasteboardAction.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J%\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkntr/common/ouro/core/plugin/pasteboard/OuroCutAction;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroCutAction implements OuroAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroTextRange range;

    public OuroCutAction() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroCutAction copy$default(OuroCutAction ouroCutAction, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroTextRange = ouroCutAction.range;
        }
        if ((i & 2) != 0) {
            completableDeferred = ouroCutAction.deferred;
        }
        return ouroCutAction.copy(ouroTextRange, completableDeferred);
    }

    public final OuroTextRange component1() {
        return this.range;
    }

    public final CompletableDeferred<OuroState> component2() {
        return this.deferred;
    }

    public final OuroCutAction copy(OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroCutAction(ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroCutAction) {
            OuroCutAction ouroCutAction = (OuroCutAction) obj;
            return Intrinsics.areEqual(this.range, ouroCutAction.range) && Intrinsics.areEqual(this.deferred, ouroCutAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return ((this.range == null ? 0 : this.range.hashCode()) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroTextRange ouroTextRange = this.range;
        return "OuroCutAction(range=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    public OuroCutAction(OuroTextRange range, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.range = range;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroCutAction(OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ouroTextRange, (i & 2) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}