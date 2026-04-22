package kntr.common.ouro.core.action;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u00032\u00020\u0004B7\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lkntr/common/ouro/core/action/OuroInsertStoragesAction;", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "storages", "", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/util/List;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlinx/coroutines/CompletableDeferred;)V", "getStorages", "()Ljava/util/List;", "getRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroInsertStoragesAction<T extends OuroNode.Parent<?>> implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final OuroTextRange range;
    private final List<OuroNodeStorage<T>> storages;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroInsertStoragesAction copy$default(OuroInsertStoragesAction ouroInsertStoragesAction, List list, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ouroInsertStoragesAction.storages;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroInsertStoragesAction.range;
        }
        if ((i & 4) != 0) {
            completableDeferred = ouroInsertStoragesAction.deferred;
        }
        return ouroInsertStoragesAction.copy(list, ouroTextRange, completableDeferred);
    }

    public final List<OuroNodeStorage<T>> component1() {
        return this.storages;
    }

    public final OuroTextRange component2() {
        return this.range;
    }

    public final CompletableDeferred<OuroState> component3() {
        return this.deferred;
    }

    public final OuroInsertStoragesAction<T> copy(List<? extends OuroNodeStorage<T>> list, OuroTextRange ouroTextRange, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "storages");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroInsertStoragesAction<>(list, ouroTextRange, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroInsertStoragesAction) {
            OuroInsertStoragesAction ouroInsertStoragesAction = (OuroInsertStoragesAction) obj;
            return Intrinsics.areEqual(this.storages, ouroInsertStoragesAction.storages) && Intrinsics.areEqual(this.range, ouroInsertStoragesAction.range) && Intrinsics.areEqual(this.deferred, ouroInsertStoragesAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (((this.storages.hashCode() * 31) + (this.range == null ? 0 : this.range.hashCode())) * 31) + this.deferred.hashCode();
    }

    public String toString() {
        List<OuroNodeStorage<T>> list = this.storages;
        OuroTextRange ouroTextRange = this.range;
        return "OuroInsertStoragesAction(storages=" + list + ", range=" + ouroTextRange + ", deferred=" + this.deferred + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroInsertStoragesAction(List<? extends OuroNodeStorage<T>> list, OuroTextRange range, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "storages");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.storages = list;
        this.range = range;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroInsertStoragesAction(List list, OuroTextRange ouroTextRange, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? null : ouroTextRange, (i & 4) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final List<OuroNodeStorage<T>> getStorages() {
        return this.storages;
    }

    public final OuroTextRange getRange() {
        return this.range;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}