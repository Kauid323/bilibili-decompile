package kntr.app.game.base.bridge;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameBookBridge.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lkntr/app/game/base/bridge/KntrGameBookService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "service", "Lkntr/app/game/base/bridge/IKntrGameBookService;", "getService", "()Lkntr/app/game/base/bridge/IKntrGameBookService;", "bookGame", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KntrGameBookService {
    public static final int $stable;
    public static final KntrGameBookService INSTANCE = new KntrGameBookService();
    private static final IKntrGameBookService service;

    private KntrGameBookService() {
    }

    static {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        service = (IKntrGameBookService) ((KntrGameBookServiceEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(KntrGameBookServiceEntryPoint.class))).getKntrGameBookService().orNull();
        $stable = 8;
    }

    public final IKntrGameBookService getService() {
        return service;
    }

    public final void bookGame(KBiligame game) {
        Intrinsics.checkNotNullParameter(game, "game");
        IKntrGameBookService iKntrGameBookService = service;
        if (iKntrGameBookService != null) {
            iKntrGameBookService.bookGame(game);
        }
    }
}