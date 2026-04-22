package kntr.common.trio.priority;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Lkntr/common/trio/priority/PriorityHorizontalScopeInstance;", "Lkntr/common/trio/priority/PriorityHorizontalScope;", "<init>", "()V", "priority", "Landroidx/compose/ui/Modifier;", "level", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PriorityHorizontalScopeInstance implements PriorityHorizontalScope {
    public static final PriorityHorizontalScopeInstance INSTANCE = new PriorityHorizontalScopeInstance();

    private PriorityHorizontalScopeInstance() {
    }

    @Override // kntr.common.trio.priority.PriorityHorizontalScope
    public Modifier priority(Modifier $this$priority, final int level) {
        Intrinsics.checkNotNullParameter($this$priority, "<this>");
        return $this$priority.then(new LayoutPriorityImpl(level, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: kntr.common.trio.priority.PriorityHorizontalScopeInstance$priority$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((InspectorInfo) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("priority");
                inspectorInfo.setValue(Integer.valueOf(level));
                inspectorInfo.getProperties().set("priority", Integer.valueOf(level));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}