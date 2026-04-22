package kntr.app.game.base.ui.widget.gameaction.state;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.util.KBiligameExtKt;
import com.bilibili.biligame.kntr.common.util.KBiligameExt_androidKt;
import com.bilibili.biligame.kntr.common.util.UtilsKt;
import kntr.app.game.base.bridge.KntrGameTeenagerModeService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.widget.gameaction.OnActionListener;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionExt.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a*\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"getAction", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "buildClickModifier", "Landroidx/compose/ui/Modifier;", "state", "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", "game", RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "onActionListener", "Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameActionExt_androidKt {
    public static final int getAction(KBiligame $this$getAction) {
        Intrinsics.checkNotNullParameter($this$getAction, "<this>");
        if (KBiligameExtKt.isSmallGame($this$getAction)) {
            return KntrGameTeenagerModeService.INSTANCE.isForbiddenSmall() ? 7 : 6;
        } else if (KBiligameExtKt.isH5Game($this$getAction)) {
            return KBiligameExt_androidKt.checkDownloadStatus($this$getAction) ? 1 : 0;
        } else {
            if (KBiligameExt_androidKt.isBookGame($this$getAction)) {
                return $this$getAction.getBooked() ? 4 : 3;
            } else if (!KBiligameExtKt.isNoneMobileGame($this$getAction)) {
                return KBiligameExt_androidKt.isDownloadableGame($this$getAction) ? KBiligameExt_androidKt.isPayGame($this$getAction) ? (UtilsKt.isLogin() && $this$getAction.getPurchased()) ? KntrGameTeenagerModeService.INSTANCE.isForbiddenDownload() ? 0 : 2 : KntrGameTeenagerModeService.INSTANCE.isForbiddenPay() ? 0 : 5 : KntrGameTeenagerModeService.INSTANCE.isForbiddenDownload() ? 0 : 2 : (!KBiligameExt_androidKt.checkOnlyShow($this$getAction) || $this$getAction.getFollowed()) ? 0 : 9;
            } else if (!KBiligameExt_androidKt.checkOnlyShow($this$getAction) || $this$getAction.getFollowed()) {
                return KBiligameExt_androidKt.isSteamGame($this$getAction) ? 8 : 0;
            } else {
                return 9;
            }
        }
    }

    public static final Modifier buildClickModifier(Modifier $this$buildClickModifier, final GameActionState state, final KBiligame game, final String sourceFrom, final OnActionListener onActionListener) {
        Intrinsics.checkNotNullParameter($this$buildClickModifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Intrinsics.checkNotNullParameter(onActionListener, "onActionListener");
        return ClickableKt.clickable-O2vRcR0$default($this$buildClickModifier, InteractionSourceKt.MutableInteractionSource(), (Indication) null, false, (String) null, (Role) null, new Function0() { // from class: kntr.app.game.base.ui.widget.gameaction.state.GameActionExt_androidKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit buildClickModifier$lambda$0;
                buildClickModifier$lambda$0 = GameActionExt_androidKt.buildClickModifier$lambda$0(GameActionState.this, onActionListener, game, sourceFrom);
                return buildClickModifier$lambda$0;
            }
        }, 28, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildClickModifier$lambda$0(GameActionState $state, OnActionListener $onActionListener, KBiligame $game, String $sourceFrom) {
        int action = $state.getAction();
        switch (action) {
            case 0:
            case 1:
            case 6:
            case 7:
                $onActionListener.onDetail($game, $state, $sourceFrom);
                break;
            case 2:
                $onActionListener.onDownload($game, $state, $sourceFrom);
                break;
            case 3:
            case 4:
                $onActionListener.onBook($game, $state, $sourceFrom);
                break;
            case 5:
                $onActionListener.onPay($game, $state, $sourceFrom);
                break;
            case 8:
                $onActionListener.onSteamDetail($game, $state, $sourceFrom);
                break;
            case 9:
                $onActionListener.onFollow($game, $state, $sourceFrom);
                break;
        }
        return Unit.INSTANCE;
    }
}