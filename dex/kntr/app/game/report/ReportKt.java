package kntr.app.game.report;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Report.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u001a&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0007\u001a&\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0007\u001a(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H\u0007\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"reporter", "Lkntr/app/game/report/BiligameKntrReporter;", "reportClick", RoomRecommendViewModel.EMPTY_CURSOR, "eventId", RoomRecommendViewModel.EMPTY_CURSOR, "extended", RoomRecommendViewModel.EMPTY_CURSOR, "reportExposure", "reportSystem", "report_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ReportKt {
    private static final BiligameKntrReporter reporter;

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        reporter = (BiligameKntrReporter) ((BiligameReporterEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(BiligameReporterEntryPoint.class))).getBiligameKntrReporter().orNull();
    }

    public static /* synthetic */ void reportClick$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        reportClick(str, map);
    }

    public static final void reportClick(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extended");
        BiligameKntrReporter biligameKntrReporter = reporter;
        if (biligameKntrReporter != null) {
            biligameKntrReporter.reportClick(eventId, map);
        }
    }

    public static /* synthetic */ void reportExposure$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        reportExposure(str, map);
    }

    public static final void reportExposure(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(map, "extended");
        BiligameKntrReporter biligameKntrReporter = reporter;
        if (biligameKntrReporter != null) {
            biligameKntrReporter.reportExposure(eventId, map);
        }
    }

    public static /* synthetic */ void reportSystem$default(String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        reportSystem(str, map);
    }

    public static final void reportSystem(String eventId, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        BiligameKntrReporter biligameKntrReporter = reporter;
        if (biligameKntrReporter != null) {
            biligameKntrReporter.reportSystem(eventId, map);
        }
    }
}