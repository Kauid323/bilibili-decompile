package kntr.common.ouro.core.plugin.localImage;

import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLocalImageState.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "taskState", "", "", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "<init>", "(Ljava/util/Map;)V", "getTaskState", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLocalImageState implements OuroPluginState {
    private final Map<String, UploadTaskState> taskState;

    public OuroLocalImageState() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroLocalImageState copy$default(OuroLocalImageState ouroLocalImageState, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = ouroLocalImageState.taskState;
        }
        return ouroLocalImageState.copy(map);
    }

    public final Map<String, UploadTaskState> component1() {
        return this.taskState;
    }

    public final OuroLocalImageState copy(Map<String, ? extends UploadTaskState> map) {
        Intrinsics.checkNotNullParameter(map, "taskState");
        return new OuroLocalImageState(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroLocalImageState) && Intrinsics.areEqual(this.taskState, ((OuroLocalImageState) obj).taskState);
    }

    public int hashCode() {
        return this.taskState.hashCode();
    }

    public String toString() {
        return "OuroLocalImageState(taskState=" + this.taskState + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroLocalImageState(Map<String, ? extends UploadTaskState> map) {
        Intrinsics.checkNotNullParameter(map, "taskState");
        this.taskState = map;
    }

    public /* synthetic */ OuroLocalImageState(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, UploadTaskState> getTaskState() {
        return this.taskState;
    }
}