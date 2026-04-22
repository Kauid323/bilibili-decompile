package kntr.app.im.chat.game;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: GameBinding.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\f\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\r\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"IMGameButton", RoomRecommendViewModel.EMPTY_CURSOR, "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "onGameButtonClick", "Lkotlin/Function0;", "(JLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "gameGiftData", "Landroidx/compose/runtime/State;", "Lkntr/app/im/chat/game/GameGiftData;", "gameGiftId", "(JLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "showGiftRow", RoomRecommendViewModel.EMPTY_CURSOR, "game_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameBindingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMGameButton$lambda$2(long j2, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        IMGameButton(j2, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v7 */
    public static final void IMGameButton(final long gameId, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 onGameButtonClick;
        Modifier modifier3;
        Modifier modifier4;
        Function0 onGameButtonClick2;
        Function0 onGameButtonClick3;
        Composer $composer2 = $composer.startRestartGroup(1186062202);
        ComposerKt.sourceInformation($composer2, "C(IMGameButton)N(gameId,modifier,onGameButtonClick)16@558L2,18@582L39,20@648L110:GameBinding.kt#kbzm8o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(gameId) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            onGameButtonClick = function0;
        } else if (($changed & 384) == 0) {
            onGameButtonClick = function0;
            $dirty |= $composer2.changedInstance(onGameButtonClick) ? 256 : 128;
        } else {
            onGameButtonClick = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1639446108, "CC(remember):GameBinding.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.im.chat.game.GameBindingKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onGameButtonClick4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onGameButtonClick2 = onGameButtonClick4;
            } else {
                onGameButtonClick2 = onGameButtonClick;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1186062202, $dirty, -1, "kntr.app.im.chat.game.IMGameButton (GameBinding.kt:17)");
            }
            State click = SnapshotStateKt.rememberUpdatedState(onGameButtonClick2, $composer2, ($dirty >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 1639449096, "CC(remember):GameBinding.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(GameButtonService.class), (String) null, 2, (Object) null);
                Object value$iv2 = suspendProducer != null ? (GameButtonService) suspendProducer.getOrNull() : null;
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            GameButtonService service = (GameButtonService) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (service == null) {
                $composer2.startReplaceGroup(-716562505);
                $composer2.endReplaceGroup();
                onGameButtonClick3 = onGameButtonClick2;
            } else {
                $composer2.startReplaceGroup(-716562504);
                ComposerKt.sourceInformation($composer2, "23@772L112");
                onGameButtonClick3 = onGameButtonClick2;
                service.GameButton(gameId, (Function0) click.getValue(), modifier4, $composer2, ($dirty & 14) | (($dirty << 3) & 896));
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onGameButtonClick = onGameButtonClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function02 = onGameButtonClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.game.GameBindingKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMGameButton$lambda$2;
                    IMGameButton$lambda$2 = GameBindingKt.IMGameButton$lambda$2(gameId, modifier5, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IMGameButton$lambda$2;
                }
            });
        }
    }

    public static final State<GameGiftData> gameGiftData(long gameGiftId, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -996969440, "C(gameGiftData)N(gameGiftId)33@951L122,36@1124L20:GameBinding.kt#kbzm8o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-996969440, $changed, -1, "kntr.app.im.chat.game.gameGiftData (GameBinding.kt:32)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -309923078, "CC(remember):GameBinding.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(gameGiftId)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        Flow<GameGiftData> flow = null;
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(GameButtonService.class), (String) null, 2, (Object) null);
            Object value$iv = suspendProducer != null ? (GameButtonService) suspendProducer.getOrNull() : null;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        GameButtonService gameButtonService = (GameButtonService) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (gameButtonService == null) {
            $composer.startReplaceGroup(-1017560762);
        } else {
            $composer.startReplaceGroup(-309919205);
            ComposerKt.sourceInformation($composer, "35@1075L27");
            flow = gameButtonService.getGameGiftData(gameGiftId, $composer, $changed & 14);
        }
        $composer.endReplaceGroup();
        State<GameGiftData> collectAsState = SnapshotStateKt.collectAsState(flow == null ? FlowKt.emptyFlow() : flow, (Object) null, (CoroutineContext) null, $composer, 48, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return collectAsState;
    }

    public static final boolean showGiftRow() {
        GameButtonService gameButtonService;
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(GameButtonService.class), (String) null, 2, (Object) null);
        if (suspendProducer == null || (gameButtonService = (GameButtonService) suspendProducer.getOrNull()) == null) {
            return false;
        }
        return gameButtonService.showGameGiftRow();
    }
}