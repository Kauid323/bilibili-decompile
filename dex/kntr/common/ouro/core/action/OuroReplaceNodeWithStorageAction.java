package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J\r\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0006HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lkntr/common/ouro/core/action/OuroReplaceNodeWithStorageAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "old", "Lkntr/common/ouro/core/model/node/OuroNode;", "storage", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/OuroNodeStorage;Lkotlinx/coroutines/CompletableDeferred;)V", "getOld", "()Lkntr/common/ouro/core/model/node/OuroNode;", "getStorage", "()Lkntr/common/ouro/core/model/OuroNodeStorage;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroReplaceNodeWithStorageAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroNode old;
    private final OuroNodeStorage<?> storage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroReplaceNodeWithStorageAction copy$default(OuroReplaceNodeWithStorageAction ouroReplaceNodeWithStorageAction, OuroNode ouroNode, OuroNodeStorage ouroNodeStorage, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroNode = ouroReplaceNodeWithStorageAction.old;
        }
        if ((i & 2) != 0) {
            ouroNodeStorage = ouroReplaceNodeWithStorageAction.storage;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroReplaceNodeWithStorageAction.deferred;
        }
        return ouroReplaceNodeWithStorageAction.copy(ouroNode, ouroNodeStorage, completableDeferred);
    }

    public final OuroNode component1() {
        return this.old;
    }

    public final OuroNodeStorage<?> component2() {
        return this.storage;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroReplaceNodeWithStorageAction copy(OuroNode ouroNode, OuroNodeStorage<?> ouroNodeStorage, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(ouroNode, "old");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroReplaceNodeWithStorageAction(ouroNode, ouroNodeStorage, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroReplaceNodeWithStorageAction) {
            OuroReplaceNodeWithStorageAction ouroReplaceNodeWithStorageAction = (OuroReplaceNodeWithStorageAction) obj;
            return Intrinsics.areEqual(this.old, ouroReplaceNodeWithStorageAction.old) && Intrinsics.areEqual(this.storage, ouroReplaceNodeWithStorageAction.storage) && Intrinsics.areEqual(this.deferred, ouroReplaceNodeWithStorageAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.old.hashCode() * 31) + this.storage.hashCode()) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        OuroNode ouroNode = this.old;
        OuroNodeStorage<?> ouroNodeStorage = this.storage;
        return "OuroReplaceNodeWithStorageAction(old=" + ouroNode + ", storage=" + ouroNodeStorage + ", deferred=" + this.deferred + ")";
    }

    public OuroReplaceNodeWithStorageAction(OuroNode old, OuroNodeStorage<?> ouroNodeStorage, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.old = old;
        this.storage = ouroNodeStorage;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroReplaceNodeWithStorageAction(OuroNode ouroNode, OuroNodeStorage ouroNodeStorage, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroNode, ouroNodeStorage, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final OuroNode getOld() {
        return this.old;
    }

    public final OuroNodeStorage<?> getStorage() {
        return this.storage;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}