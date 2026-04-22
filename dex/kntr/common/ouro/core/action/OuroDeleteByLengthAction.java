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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J/\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lkntr/common/ouro/core/action/OuroDeleteByLengthAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "length", "", "compositionRange", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(ILkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getLength", "()I", "getCompositionRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroDeleteByLengthAction implements OuroEditAction, OuroSyncAction {
    private final OuroTextRange compositionRange;
    private final CompletableDeferred<OuroState> deferred;
    private final int length;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroDeleteByLengthAction copy$default(OuroDeleteByLengthAction ouroDeleteByLengthAction, int i, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ouroDeleteByLengthAction.length;
        }
        if ((i2 & 2) != 0) {
            ouroTextRange = ouroDeleteByLengthAction.compositionRange;
        }
        if ((i2 & 4) != 0) {
            completableDeferred = ouroDeleteByLengthAction.deferred;
        }
        return ouroDeleteByLengthAction.copy(i, ouroTextRange, completableDeferred);
    }

    public final int component1() {
        return this.length;
    }

    public final OuroTextRange component2() {
        return this.compositionRange;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroDeleteByLengthAction copy(int i, OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroDeleteByLengthAction(i, ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroDeleteByLengthAction) {
            OuroDeleteByLengthAction ouroDeleteByLengthAction = (OuroDeleteByLengthAction) obj;
            return this.length == ouroDeleteByLengthAction.length && Intrinsics.areEqual(this.compositionRange, ouroDeleteByLengthAction.compositionRange) && Intrinsics.areEqual(this.deferred, ouroDeleteByLengthAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.length * 31) + (this.compositionRange == null ? 0 : this.compositionRange.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        int i = this.length;
        OuroTextRange ouroTextRange = this.compositionRange;
        return "OuroDeleteByLengthAction(length=" + i + ", compositionRange=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    public OuroDeleteByLengthAction(int length, OuroTextRange compositionRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.length = length;
        this.compositionRange = compositionRange;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroDeleteByLengthAction(int i, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : ouroTextRange, (i2 & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final int getLength() {
        return this.length;
    }

    public final OuroTextRange getCompositionRange() {
        return this.compositionRange;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}