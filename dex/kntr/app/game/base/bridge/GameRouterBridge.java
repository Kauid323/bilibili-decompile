package kntr.app.game.base.bridge;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameRouterBridge.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rJ$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u000fR\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/game/base/bridge/GameRouterBridge;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "service", "Lkntr/app/game/base/bridge/GameRouterService;", "getService", "()Lkntr/app/game/base/bridge/GameRouterService;", "service$delegate", "Lkotlin/Lazy;", "isAppStoreUrl", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "getCommonRouterParams", RoomRecommendViewModel.EMPTY_CURSOR, "openAppStorePage", RoomRecommendViewModel.EMPTY_CURSOR, "params", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameRouterBridge {
    public static final GameRouterBridge INSTANCE = new GameRouterBridge();
    private static final Lazy service$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.game.base.bridge.GameRouterBridge$$ExternalSyntheticLambda0
        public final Object invoke() {
            GameRouterService service_delegate$lambda$0;
            service_delegate$lambda$0 = GameRouterBridge.service_delegate$lambda$0();
            return service_delegate$lambda$0;
        }
    });
    public static final int $stable = 8;

    private GameRouterBridge() {
    }

    private final GameRouterService getService() {
        return (GameRouterService) service$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameRouterService service_delegate$lambda$0() {
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return (GameRouterService) ((GameRouterEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(GameRouterEntryPoint.class))).getGameRouterService().orNull();
    }

    public final boolean isAppStoreUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        GameRouterService service = getService();
        if (service != null) {
            return service.isAppStoreUrl(url);
        }
        return false;
    }

    public final Map<String, String> getCommonRouterParams(String url) {
        Map<String, String> commonRouterParams;
        Intrinsics.checkNotNullParameter(url, "url");
        GameRouterService service = getService();
        return (service == null || (commonRouterParams = service.getCommonRouterParams(url)) == null) ? MapsKt.emptyMap() : commonRouterParams;
    }

    public final void openAppStorePage(String url, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(url, "url");
        GameRouterService service = getService();
        if (service != null) {
            service.openAppStorePage(url, map);
        }
    }
}