package kntr.common.ouro.core.action;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Job;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B5\u0012\u001c\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\u001e\b\u0002\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R'\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/action/OuroReplacePlainNodesWithStoragesAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "Lkntr/common/ouro/core/action/OuroSyncAction;", "list", "", "Lkotlin/Pair;", "Lkntr/common/ouro/core/model/node/OuroTextElement$Plain;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "Lkntr/common/ouro/core/OuroState;", "<init>", "(Ljava/util/List;Lkotlinx/coroutines/CompletableDeferred;)V", "getList", "()Ljava/util/List;", "getDeferred", "()Lkotlinx/coroutines/CompletableDeferred;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroReplacePlainNodesWithStoragesAction implements OuroEditAction, OuroSyncAction {
    private final CompletableDeferred<OuroState> deferred;
    private final List<Pair<OuroTextElement.Plain, OuroNodeStorage<?>>> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroReplacePlainNodesWithStoragesAction copy$default(OuroReplacePlainNodesWithStoragesAction ouroReplacePlainNodesWithStoragesAction, List list, CompletableDeferred completableDeferred, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ouroReplacePlainNodesWithStoragesAction.list;
        }
        if ((i & 2) != 0) {
            completableDeferred = ouroReplacePlainNodesWithStoragesAction.deferred;
        }
        return ouroReplacePlainNodesWithStoragesAction.copy(list, completableDeferred);
    }

    public final List<Pair<OuroTextElement.Plain, OuroNodeStorage<?>>> component1() {
        return this.list;
    }

    public final CompletableDeferred<OuroState> component2() {
        return this.deferred;
    }

    public final OuroReplacePlainNodesWithStoragesAction copy(List<? extends Pair<OuroTextElement.Plain, ? extends OuroNodeStorage<?>>> list, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        return new OuroReplacePlainNodesWithStoragesAction(list, completableDeferred);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroReplacePlainNodesWithStoragesAction) {
            OuroReplacePlainNodesWithStoragesAction ouroReplacePlainNodesWithStoragesAction = (OuroReplacePlainNodesWithStoragesAction) obj;
            return Intrinsics.areEqual(this.list, ouroReplacePlainNodesWithStoragesAction.list) && Intrinsics.areEqual(this.deferred, ouroReplacePlainNodesWithStoragesAction.deferred);
        }
        return false;
    }

    public int hashCode() {
        return (this.list.hashCode() * 31) + this.deferred.hashCode();
    }

    public String toString() {
        List<Pair<OuroTextElement.Plain, OuroNodeStorage<?>>> list = this.list;
        return "OuroReplacePlainNodesWithStoragesAction(list=" + list + ", deferred=" + this.deferred + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroReplacePlainNodesWithStoragesAction(List<? extends Pair<OuroTextElement.Plain, ? extends OuroNodeStorage<?>>> list, CompletableDeferred<OuroState> completableDeferred) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(completableDeferred, "deferred");
        this.list = list;
        this.deferred = completableDeferred;
    }

    public /* synthetic */ OuroReplacePlainNodesWithStoragesAction(List list, CompletableDeferred completableDeferred, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null) : completableDeferred);
    }

    public final List<Pair<OuroTextElement.Plain, OuroNodeStorage<?>>> getList() {
        return this.list;
    }

    @Override // kntr.common.ouro.core.action.OuroSyncAction
    public CompletableDeferred<OuroState> getDeferred() {
        return this.deferred;
    }
}