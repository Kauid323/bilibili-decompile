package kntr.app.game.base.ui.widget.gameaction.provider;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.util.KBiligameExt_androidKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionState;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.game.downloader.KntrGameDownloadManager;
import kntr.app.game.downloader.bean.GameDownloadState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameActionStateProvider.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/provider/GameActionStateProvider;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "mActionStateMap", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/base/ui/widget/gameaction/state/GameActionState;", "getGameActionState", "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "updateGameActionState", RoomRecommendViewModel.EMPTY_CURSOR, "getUniqueKey", "updateDownloadState", "pkgName", "Companion", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameActionStateProvider {
    private static final String TAG = "GameActionStateProvider";
    private final Map<String, GameActionState> mActionStateMap;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final GameActionStateProvider mDefaultInstant = new GameActionStateProvider();
    private static final List<GameActionStateProvider> mGameStateProviders = new ArrayList();

    public /* synthetic */ GameActionStateProvider(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private GameActionStateProvider() {
        this.mActionStateMap = new LinkedHashMap();
    }

    public final GameActionState getGameActionState(KBiligame game) {
        if (game == null) {
            return new GameActionState(AdSearchSubCardType.CARD_TYPE_NONE, 0, null);
        }
        GameActionState $this$getGameActionState_u24lambda_u240 = this.mActionStateMap.get(getUniqueKey(game));
        if ($this$getGameActionState_u24lambda_u240 == null) {
            GameActionState $this$getGameActionState_u24lambda_u241_u240 = GameActionStateKt.createOrUpdateActionState$default(game, null, 1, null);
            this.mActionStateMap.put(getUniqueKey(game), $this$getGameActionState_u24lambda_u241_u240);
            return $this$getGameActionState_u24lambda_u241_u240;
        }
        GameActionStateKt.createOrUpdateActionState(game, $this$getGameActionState_u24lambda_u240);
        return $this$getGameActionState_u24lambda_u240;
    }

    public final void updateGameActionState(KBiligame game) {
        GameActionState it;
        if (game != null && (it = this.mActionStateMap.get(getUniqueKey(game))) != null) {
            GameActionStateKt.createOrUpdateActionState(game, it);
        }
    }

    private final String getUniqueKey(KBiligame game) {
        return KBiligameExt_androidKt.getUniqueId(game);
    }

    public final void updateDownloadState(String pkgName) {
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        GameActionState state = this.mActionStateMap.get(pkgName);
        if (state != null && GameActionStateKt.isDownloadState(state)) {
            GameDownloadState downloadState = KntrGameDownloadManager.INSTANCE.updateDownloadState(pkgName, state.getPkgVer());
            GameActionStateKt.syncDownloadState(state, downloadState);
        }
    }

    /* compiled from: GameActionStateProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/app/game/base/ui/widget/gameaction/provider/GameActionStateProvider$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "mDefaultInstant", "Lkntr/app/game/base/ui/widget/gameaction/provider/GameActionStateProvider;", "getMDefaultInstant$base_ui_debug", "()Lkntr/app/game/base/ui/widget/gameaction/provider/GameActionStateProvider;", "mGameStateProviders", RoomRecommendViewModel.EMPTY_CURSOR, "createGameStateProvider", "removeGameStateProvider", RoomRecommendViewModel.EMPTY_CURSOR, "provider", "updateDownloadStates", "pkgName", "updateGameActionState", "game", "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GameActionStateProvider getMDefaultInstant$base_ui_debug() {
            return GameActionStateProvider.mDefaultInstant;
        }

        public final GameActionStateProvider createGameStateProvider() {
            GameActionStateProvider provider = new GameActionStateProvider(null);
            KLog_androidKt.getKLog().d(GameActionStateProvider.TAG, "createGameStateProvider: " + provider.hashCode());
            GameActionStateProvider.mGameStateProviders.add(provider);
            return provider;
        }

        public final void removeGameStateProvider(GameActionStateProvider provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            KLog_androidKt.getKLog().d(GameActionStateProvider.TAG, "removeGameStateProvider: " + provider.hashCode());
            GameActionStateProvider.mGameStateProviders.remove(provider);
        }

        public final void updateDownloadStates(String pkgName) {
            Intrinsics.checkNotNullParameter(pkgName, "pkgName");
            Iterable $this$forEach$iv = GameActionStateProvider.mGameStateProviders;
            for (Object element$iv : $this$forEach$iv) {
                GameActionStateProvider provider = (GameActionStateProvider) element$iv;
                KLog_androidKt.getKLog().d(GameActionStateProvider.TAG, "updateDownloadStates: " + provider.hashCode());
                provider.updateDownloadState(pkgName);
            }
        }

        public final void updateGameActionState(KBiligame game) {
            if (game == null) {
                return;
            }
            Iterable $this$forEach$iv = GameActionStateProvider.mGameStateProviders;
            for (Object element$iv : $this$forEach$iv) {
                GameActionStateProvider provider = (GameActionStateProvider) element$iv;
                KLog_androidKt.getKLog().d(GameActionStateProvider.TAG, "updateGameActionState: " + provider.hashCode());
                provider.updateGameActionState(game);
            }
        }
    }
}