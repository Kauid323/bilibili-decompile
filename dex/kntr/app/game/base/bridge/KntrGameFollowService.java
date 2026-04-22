package kntr.app.game.base.bridge;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameFollowBridge.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/app/game/base/bridge/KntrGameFollowService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "service", "Lkntr/app/game/base/bridge/IKntrGameFollowService;", "followGame", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KntrGameFollowService {
    public static final int $stable;
    public static final KntrGameFollowService INSTANCE = new KntrGameFollowService();
    private static final IKntrGameFollowService service;

    private KntrGameFollowService() {
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        service = (IKntrGameFollowService) ((KntrGameFollowServiceEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KntrGameFollowServiceEntryPoint.class))).getKntrGameFollowService().orNull();
        $stable = 8;
    }

    public final void followGame(KBiligame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        IKntrGameFollowService iKntrGameFollowService = service;
        if (iKntrGameFollowService != null) {
            iKntrGameFollowService.followGame(game);
        }
    }
}