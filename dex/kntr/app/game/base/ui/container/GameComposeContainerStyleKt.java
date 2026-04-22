package kntr.app.game.base.ui.container;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

/* compiled from: GameComposeContainerStyle.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"gameComposeContainerStyle", "Lkntr/app/game/base/ui/container/GameComposeContainerStyle;", "getGameComposeContainerStyle", "()Lkntr/app/game/base/ui/container/GameComposeContainerStyle;", "gameComposeContainerStyle$delegate", "Lkotlin/Lazy;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameComposeContainerStyleKt {
    private static final Lazy gameComposeContainerStyle$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerStyleKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            GameComposeContainerStyleKt$gameComposeContainerStyle$2$1 gameComposeContainerStyle_delegate$lambda$0;
            gameComposeContainerStyle_delegate$lambda$0 = GameComposeContainerStyleKt.gameComposeContainerStyle_delegate$lambda$0();
            return gameComposeContainerStyle_delegate$lambda$0;
        }
    });

    public static final GameComposeContainerStyle getGameComposeContainerStyle() {
        return (GameComposeContainerStyle) gameComposeContainerStyle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameComposeContainerStyleKt$gameComposeContainerStyle$2$1 gameComposeContainerStyle_delegate$lambda$0() {
        GameComposeContainerStyle containerStyle = (GameComposeContainerStyle) ((GameComposeContainerStyleEntryPoint) Component_jvmKt.entryPoint(Gripper_component_holder_androidKt.getRootGripperComponent(), Reflection.getOrCreateKotlinClass(GameComposeContainerStyleEntryPoint.class))).getGameComposeContainerStyle().orNull();
        return new GameComposeContainerStyleKt$gameComposeContainerStyle$2$1(containerStyle);
    }
}