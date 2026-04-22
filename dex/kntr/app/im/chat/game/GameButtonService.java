package kntr.app.im.chat.game;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GameButtonInject.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u0005H'¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/game/GameButtonService;", RoomRecommendViewModel.EMPTY_CURSOR, "GameButton", RoomRecommendViewModel.EMPTY_CURSOR, "gameId", RoomRecommendViewModel.EMPTY_CURSOR, "onGameButtonClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "getGameGiftData", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/im/chat/game/GameGiftData;", "gameGiftId", "(JLandroidx/compose/runtime/Composer;I)Lkotlinx/coroutines/flow/Flow;", "showGameGiftRow", RoomRecommendViewModel.EMPTY_CURSOR, "game_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface GameButtonService {
    void GameButton(long j2, Function0<Unit> function0, Modifier modifier, Composer composer, int i);

    Flow<GameGiftData> getGameGiftData(long j2, Composer composer, int i);

    boolean showGameGiftRow();

    /* compiled from: GameButtonInject.kt */
    /* renamed from: kntr.app.im.chat.game.GameButtonService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$showGameGiftRow(GameButtonService _this) {
            return false;
        }
    }

    /* compiled from: GameButtonInject.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean showGameGiftRow(GameButtonService $this) {
            return CC.$default$showGameGiftRow($this);
        }
    }
}