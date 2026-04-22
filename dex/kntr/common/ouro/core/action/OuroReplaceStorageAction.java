package kntr.common.ouro.core.action;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.node.OuroDocument;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroEditAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/common/ouro/core/action/OuroReplaceStorageAction;", "Lkntr/common/ouro/core/action/OuroEditAction;", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "<init>", "(Lkntr/common/ouro/core/model/NodeStorage;)V", "getStorage", "()Lkntr/common/ouro/core/model/NodeStorage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroReplaceStorageAction implements OuroEditAction {
    private final NodeStorage<OuroDocument> storage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroReplaceStorageAction copy$default(OuroReplaceStorageAction ouroReplaceStorageAction, NodeStorage nodeStorage, int i, Object obj) {
        if ((i & 1) != 0) {
            nodeStorage = ouroReplaceStorageAction.storage;
        }
        return ouroReplaceStorageAction.copy(nodeStorage);
    }

    public final NodeStorage<OuroDocument> component1() {
        return this.storage;
    }

    public final OuroReplaceStorageAction copy(NodeStorage<OuroDocument> nodeStorage) {
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        return new OuroReplaceStorageAction(nodeStorage);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroReplaceStorageAction) && Intrinsics.areEqual(this.storage, ((OuroReplaceStorageAction) obj).storage);
    }

    public int hashCode() {
        return this.storage.hashCode();
    }

    public String toString() {
        return "OuroReplaceStorageAction(storage=" + this.storage + ")";
    }

    public OuroReplaceStorageAction(NodeStorage<OuroDocument> nodeStorage) {
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        this.storage = nodeStorage;
    }

    public final NodeStorage<OuroDocument> getStorage() {
        return this.storage;
    }
}