package kntr.app.game.base.ui.widget.gameaction;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: GameActionButton.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;", RoomRecommendViewModel.EMPTY_CURSOR, "onPay", RoomRecommendViewModel.EMPTY_CURSOR, "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "state", "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "onDownload", "onBook", "onDetail", "onSteamDetail", "onOpenIOS", "onFollow", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface OnActionListener {
    void onBook(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onDetail(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onDownload(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onFollow(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onOpenIOS(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onPay(KBiligame kBiligame, GameActionState gameActionState, String str);

    void onSteamDetail(KBiligame kBiligame, GameActionState gameActionState, String str);
}