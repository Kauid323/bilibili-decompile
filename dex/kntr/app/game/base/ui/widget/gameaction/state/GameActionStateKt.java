package kntr.app.game.base.ui.widget.gameaction.state;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.util.KBiligameExt_androidKt;
import com.bilibili.biligame.kntr.common.util.NumberExtKt;
import kntr.app.game.downloader.KntrGameDownloadManager;
import kntr.app.game.downloader.bean.GameDownloadState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionState.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u000e\u001a\u0016\u0010\u0010\u001a\u00020\u000e*\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u001a\u0012\u0010\u0013\u001a\u00020\u0014*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"ACTION_UNDEFINE", RoomRecommendViewModel.EMPTY_CURSOR, "ACTION_DETAIL", "ACTION_OPEN", "ACTION_DOWNLOAD", "ACTION_BOOK", "ACTION_BOOKED", "ACTION_PAY", "ACTION_PLAY", "ACTION_PLAY_HIDE", "ACTION_NON_MOBILE_DOWNLOAD", "ACTION_FOLLOW", "isDownloadState", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", "isPayState", "createOrUpdateActionState", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "oldState", "syncDownloadState", RoomRecommendViewModel.EMPTY_CURSOR, "downloadState", "Lkntr/app/game/downloader/bean/GameDownloadState;", "action2Text", RoomRecommendViewModel.EMPTY_CURSOR, "action", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameActionStateKt {
    public static final int ACTION_BOOK = 3;
    public static final int ACTION_BOOKED = 4;
    public static final int ACTION_DETAIL = 0;
    public static final int ACTION_DOWNLOAD = 2;
    public static final int ACTION_FOLLOW = 9;
    public static final int ACTION_NON_MOBILE_DOWNLOAD = 8;
    public static final int ACTION_OPEN = 1;
    public static final int ACTION_PAY = 5;
    public static final int ACTION_PLAY = 6;
    public static final int ACTION_PLAY_HIDE = 7;
    public static final int ACTION_UNDEFINE = -1;

    public static final boolean isDownloadState(GameActionState $this$isDownloadState) {
        Intrinsics.checkNotNullParameter($this$isDownloadState, "<this>");
        return $this$isDownloadState.getAction() == 2;
    }

    public static final boolean isPayState(GameActionState $this$isPayState) {
        Intrinsics.checkNotNullParameter($this$isPayState, "<this>");
        return $this$isPayState.getAction() == 5;
    }

    public static /* synthetic */ GameActionState createOrUpdateActionState$default(KBiligame kBiligame, GameActionState gameActionState, int i, Object obj) {
        if ((i & 1) != 0) {
            gameActionState = null;
        }
        return createOrUpdateActionState(kBiligame, gameActionState);
    }

    public static final GameActionState createOrUpdateActionState(KBiligame $this$createOrUpdateActionState, GameActionState oldState) {
        Intrinsics.checkNotNullParameter($this$createOrUpdateActionState, "<this>");
        int action = GameActionExt_androidKt.getAction($this$createOrUpdateActionState);
        GameActionState newState = oldState == null ? new GameActionState(String.valueOf($this$createOrUpdateActionState.getGameBaseId()), KBiligameExt_androidKt.getPkgVersion($this$createOrUpdateActionState), $this$createOrUpdateActionState.getAndroidPkgName()) : oldState;
        newState.setAction(action);
        newState.setDisable(action == 4);
        switch (action) {
            case 2:
                GameDownloadState downloadState = KntrGameDownloadManager.INSTANCE.updateDownloadState($this$createOrUpdateActionState.getAndroidPkgName(), KBiligameExt_androidKt.getPkgVersion($this$createOrUpdateActionState));
                syncDownloadState(newState, downloadState);
                break;
            case 5:
                newState.setOriginPrice(NumberExtKt.stripTrailingZeros($this$createOrUpdateActionState.getPrice()));
                newState.setDiscountPrice(NumberExtKt.stripTrailingZeros($this$createOrUpdateActionState.getDiscountPrice()));
                newState.setDiscount($this$createOrUpdateActionState.getDiscount());
                break;
            default:
                newState.setMainText(action2Text(action));
                break;
        }
        return newState;
    }

    public static final void syncDownloadState(GameActionState $this$syncDownloadState, GameDownloadState downloadState) {
        Intrinsics.checkNotNullParameter($this$syncDownloadState, "<this>");
        Intrinsics.checkNotNullParameter(downloadState, "downloadState");
        KLog_androidKt.getKLog().d("KntrDownloadBtnTest", "syncDownloadState: downloadState = " + downloadState);
        $this$syncDownloadState.setInDownload(downloadState.getInDownload());
        $this$syncDownloadState.setProgress(downloadState.getProgress());
        $this$syncDownloadState.setMainText(downloadState.getMainText());
        KLog_androidKt.getKLog().d("KntrDownloadBtnTest", "syncDownloadState: actionState.inDownload = " + $this$syncDownloadState.getInDownload());
        GameDownloadState.Companion.recycle(downloadState);
    }

    private static final String action2Text(int action) {
        switch (action) {
            case 0:
            case 2:
            case 5:
            case 7:
            default:
                return "查看";
            case 1:
                return "打开";
            case 3:
                return "预约";
            case 4:
                return "已预约";
            case 6:
                return "立即玩";
            case 8:
                return "前往";
            case 9:
                return "关注";
        }
    }
}