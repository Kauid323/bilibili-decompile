package kntr.common.ouro.core.plugin.editControls;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: OuroHistoryPlugin.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u001f\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u0017J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÂ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÂ\u0003J:\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÀ\u0001¢\u0006\u0002\b\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/common/ouro/core/plugin/editControls/OuroHistoryState;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "historyList", "", "Lkntr/common/ouro/core/OuroState;", "redoList", "lastInstant", "Lkotlinx/datetime/Instant;", "<init>", "(Ljava/util/List;Ljava/util/List;Lkotlinx/datetime/Instant;)V", "canUndo", "", "canRedo", "current", "getCurrent", "()Lkntr/common/ouro/core/OuroState;", "update", "state", "instant", "update$core_debug", "undo", "undo$core_debug", "redo", "redo$core_debug", "component1", "component2", "component3", "copy", "copy$core_debug", "equals", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroHistoryState implements OuroPluginState {
    private final OuroState current;
    private final List<OuroState> historyList;
    private final Instant lastInstant;
    private final List<OuroState> redoList;

    public OuroHistoryState() {
        this(null, null, null, 7, null);
    }

    private final List<OuroState> component1() {
        return this.historyList;
    }

    private final List<OuroState> component2() {
        return this.redoList;
    }

    private final Instant component3() {
        return this.lastInstant;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroHistoryState copy$core_debug$default(OuroHistoryState ouroHistoryState, List list, List list2, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ouroHistoryState.historyList;
        }
        if ((i & 2) != 0) {
            list2 = ouroHistoryState.redoList;
        }
        if ((i & 4) != 0) {
            instant = ouroHistoryState.lastInstant;
        }
        return ouroHistoryState.copy$core_debug(list, list2, instant);
    }

    public final OuroHistoryState copy$core_debug(List<OuroState> list, List<OuroState> list2, Instant instant) {
        Intrinsics.checkNotNullParameter(list, "historyList");
        Intrinsics.checkNotNullParameter(list2, "redoList");
        return new OuroHistoryState(list, list2, instant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroHistoryState) {
            OuroHistoryState ouroHistoryState = (OuroHistoryState) obj;
            return Intrinsics.areEqual(this.historyList, ouroHistoryState.historyList) && Intrinsics.areEqual(this.redoList, ouroHistoryState.redoList) && Intrinsics.areEqual(this.lastInstant, ouroHistoryState.lastInstant);
        }
        return false;
    }

    public int hashCode() {
        return (((this.historyList.hashCode() * 31) + this.redoList.hashCode()) * 31) + (this.lastInstant == null ? 0 : this.lastInstant.hashCode());
    }

    public String toString() {
        List<OuroState> list = this.historyList;
        List<OuroState> list2 = this.redoList;
        return "OuroHistoryState(historyList=" + list + ", redoList=" + list2 + ", lastInstant=" + this.lastInstant + ")";
    }

    public OuroHistoryState(List<OuroState> list, List<OuroState> list2, Instant lastInstant) {
        Intrinsics.checkNotNullParameter(list, "historyList");
        Intrinsics.checkNotNullParameter(list2, "redoList");
        this.historyList = list;
        this.redoList = list2;
        this.lastInstant = lastInstant;
        this.current = (OuroState) CollectionsKt.lastOrNull(this.historyList);
    }

    public /* synthetic */ OuroHistoryState(List list, List list2, Instant instant, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? null : instant);
    }

    public final boolean canUndo() {
        return this.historyList.size() > 1;
    }

    public final boolean canRedo() {
        return !this.redoList.isEmpty();
    }

    public final OuroState getCurrent() {
        return this.current;
    }

    public static /* synthetic */ OuroHistoryState update$core_debug$default(OuroHistoryState ouroHistoryState, OuroState ouroState, Instant instant, int i, Object obj) {
        if ((i & 2) != 0) {
            instant = Clock.System.INSTANCE.now();
        }
        return ouroHistoryState.update$core_debug(ouroState, instant);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (kotlin.time.Duration.compareTo-LRDsOJo(r0, kotlin.time.DurationKt.toDuration(300, kotlin.time.DurationUnit.MILLISECONDS)) >= 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final OuroHistoryState update$core_debug(OuroState state, Instant instant) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(instant, "instant");
        if (this.lastInstant != null && instant.compareTo(this.lastInstant) < 0) {
            return copy$core_debug$default(this, null, null, instant, 3, null);
        }
        if (state.getCompositionRange() == null) {
            if (this.lastInstant != null) {
                long j = instant.minus-5sfh64U(this.lastInstant);
                Duration.Companion companion = Duration.Companion;
            }
            NodeStorage<OuroDocument> storage = state.getStorage();
            OuroState ouroState = this.current;
            if (!Intrinsics.areEqual(storage, ouroState != null ? ouroState.getStorage() : null) || !Intrinsics.areEqual(state.getTextRange(), this.current.getTextRange())) {
                List newHistoryList = CollectionsKt.plus(this.historyList, state);
                return copy$core_debug(newHistoryList, CollectionsKt.emptyList(), instant);
            }
        }
        return this;
    }

    public final OuroHistoryState undo$core_debug() {
        if (canUndo() && this.current != null) {
            return copy$core_debug(CollectionsKt.dropLast(this.historyList, 1), CollectionsKt.plus(this.redoList, this.current), Clock.System.INSTANCE.now());
        }
        return this;
    }

    public final OuroHistoryState redo$core_debug() {
        if (!canRedo()) {
            return this;
        }
        return copy$core_debug(CollectionsKt.plus(this.historyList, CollectionsKt.last(this.redoList)), CollectionsKt.dropLast(this.redoList, 1), Clock.System.INSTANCE.now());
    }
}