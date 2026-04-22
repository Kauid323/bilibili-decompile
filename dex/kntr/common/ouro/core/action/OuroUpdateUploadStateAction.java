package kntr.common.ouro.core.action;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroCommonAction.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lkntr/common/ouro/core/action/OuroUpdateUploadStateAction;", "Lkntr/common/ouro/core/action/OuroCommonAction;", "map", "", "", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "<init>", "(Ljava/util/Map;)V", "getMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroUpdateUploadStateAction implements OuroCommonAction {
    private final Map<String, UploadTaskState> map;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroUpdateUploadStateAction copy$default(OuroUpdateUploadStateAction ouroUpdateUploadStateAction, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = ouroUpdateUploadStateAction.map;
        }
        return ouroUpdateUploadStateAction.copy(map);
    }

    public final Map<String, UploadTaskState> component1() {
        return this.map;
    }

    public final OuroUpdateUploadStateAction copy(Map<String, ? extends UploadTaskState> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return new OuroUpdateUploadStateAction(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroUpdateUploadStateAction) && Intrinsics.areEqual(this.map, ((OuroUpdateUploadStateAction) obj).map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "OuroUpdateUploadStateAction(map=" + this.map + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroUpdateUploadStateAction(Map<String, ? extends UploadTaskState> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public final Map<String, UploadTaskState> getMap() {
        return this.map;
    }
}