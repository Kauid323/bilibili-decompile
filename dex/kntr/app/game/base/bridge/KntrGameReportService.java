package kntr.app.game.base.bridge;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameReportBridge.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lkntr/app/game/base/bridge/KntrGameReportService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "service", "Lkntr/app/game/base/bridge/IKntrGameReportService;", "getService", "()Lkntr/app/game/base/bridge/IKntrGameReportService;", "getSpmidFrom", RoomRecommendViewModel.EMPTY_CURSOR, "setSpmidFrom", RoomRecommendViewModel.EMPTY_CURSOR, "spmidFrom", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KntrGameReportService {
    public static final int $stable;
    public static final KntrGameReportService INSTANCE = new KntrGameReportService();
    private static final IKntrGameReportService service;

    private KntrGameReportService() {
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        service = (IKntrGameReportService) ((KntrGameReportServiceEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KntrGameReportServiceEntryPoint.class))).getKntrGameReportService().orNull();
        $stable = 8;
    }

    public final IKntrGameReportService getService() {
        return service;
    }

    public final String getSpmidFrom() {
        String spmidFrom;
        IKntrGameReportService iKntrGameReportService = service;
        return (iKntrGameReportService == null || (spmidFrom = iKntrGameReportService.getSpmidFrom()) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : spmidFrom;
    }

    public final void setSpmidFrom(String spmidFrom) {
        Intrinsics.checkNotNullParameter(spmidFrom, "spmidFrom");
        IKntrGameReportService iKntrGameReportService = service;
        if (iKntrGameReportService != null) {
            iKntrGameReportService.setSpmidFrom(spmidFrom);
        }
    }
}