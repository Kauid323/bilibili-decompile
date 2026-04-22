package kntr.common.ouro.core.action;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroTextRange;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroCommonAction.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/action/OuroUpdateSelectionAction;", "Lkntr/common/ouro/core/action/OuroCommonAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "needConstrain", "", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/OuroTextRange;ZLkotlinx/coroutines/CompletableDeferred;)V", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getNeedConstrain", "()Z", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroUpdateSelectionAction implements OuroCommonAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final boolean needConstrain;
    private final OuroTextRange range;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroUpdateSelectionAction copy$default(OuroUpdateSelectionAction ouroUpdateSelectionAction, OuroTextRange ouroTextRange, boolean z, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroTextRange = ouroUpdateSelectionAction.range;
        }
        if ((i & 2) != 0) {
            z = ouroUpdateSelectionAction.needConstrain;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroUpdateSelectionAction.deferred;
        }
        return ouroUpdateSelectionAction.copy(ouroTextRange, z, completableDeferred);
    }

    public final OuroTextRange component1() {
        return this.range;
    }

    public final boolean component2() {
        return this.needConstrain;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroUpdateSelectionAction copy(OuroTextRange ouroTextRange, boolean z, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(ouroTextRange, "range");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroUpdateSelectionAction(ouroTextRange, z, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroUpdateSelectionAction) {
            OuroUpdateSelectionAction ouroUpdateSelectionAction = (OuroUpdateSelectionAction) obj;
            return Intrinsics.areEqual(this.range, ouroUpdateSelectionAction.range) && this.needConstrain == ouroUpdateSelectionAction.needConstrain && Intrinsics.areEqual(this.deferred, ouroUpdateSelectionAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.range.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needConstrain)) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroTextRange ouroTextRange = this.range;
        boolean z = this.needConstrain;
        return "OuroUpdateSelectionAction(range=" + ouroTextRange + ", needConstrain=" + z + ", deferred=" + this.deferred + ")";
    }

    public OuroUpdateSelectionAction(OuroTextRange range, boolean needConstrain, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.range = range;
        this.needConstrain = needConstrain;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroUpdateSelectionAction(OuroTextRange ouroTextRange, boolean z, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroTextRange, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    public final boolean getNeedConstrain() {
        return this.needConstrain;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}