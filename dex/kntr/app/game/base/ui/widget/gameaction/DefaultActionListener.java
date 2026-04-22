package kntr.app.game.base.ui.widget.gameaction;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import kntr.app.game.base.bridge.KntrGameBookService;
import kntr.app.game.base.bridge.KntrGameFollowService;
import kntr.app.game.base.bridge.KntrGamePayService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionState;
import kntr.app.game.downloader.KntrGameDownloadManager;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionButton.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u0013"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/DefaultActionListener;", "Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;", "<init>", "()V", "onPay", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "state", "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "onDownload", "onBook", "onDetail", "onSteamDetail", "onFollow", "onOpenIOS", "onButtonClick", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class DefaultActionListener implements OnActionListener {
    public static final int $stable = 0;

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onPay(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        KntrGamePayService.INSTANCE.payGame(game);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onDownload(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        KntrGameDownloadManager.INSTANCE.reportDownloadClick(game, state.getButtonName());
        KntrGameDownloadManager.INSTANCE.handleClickDownload(game);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onBook(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        KntrGameBookService.INSTANCE.bookGame(game);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onDetail(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        RouterHelperKt.handleGameDetail$default(game, 0, false, 0, false, MapsKt.mapOf(TuplesKt.to(RouterHelperKt.PARAM_SOURCE_FROM, sourceFrom)), null, 94, null);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onSteamDetail(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        RouterHelperKt.openUrl$default(game.getSteamLink(), null, 2, null);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onFollow(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        KntrGameFollowService.INSTANCE.followGame(game);
    }

    @Override // kntr.app.game.base.ui.widget.gameaction.OnActionListener
    public void onOpenIOS(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        onButtonClick(game, state, sourceFrom);
        RouterHelperKt.openUrl(game.getDownloadLink(), MapsKt.mapOf(TuplesKt.to(RouterHelperKt.PARAM_SOURCE_FROM, sourceFrom)));
    }

    public void onButtonClick(KBiligame game, GameActionState state, String sourceFrom) {
        Intrinsics.checkNotNullParameter(game, "game");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
    }
}