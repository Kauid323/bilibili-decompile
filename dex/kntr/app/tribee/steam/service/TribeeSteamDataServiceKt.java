package kntr.app.tribee.steam.service;

import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementEmpty;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementSuccess;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import java.util.List;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamDataService.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"TAG", "", "getGameAchievementState", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "game", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamDataServiceKt {
    private static final String TAG = "TribeeSteamDataService";

    static /* synthetic */ TribeeSteamGameAchievementState getGameAchievementState$default(KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, int i, Object obj) {
        if ((i & 1) != 0) {
            kTribeeSteamHomeGameItem = null;
        }
        if ((i & 2) != 0) {
            kTribeeSteamHomeGame = null;
        }
        if ((i & 4) != 0) {
            kTribeeSteamHomeAchievement = null;
        }
        return getGameAchievementState(kTribeeSteamHomeGameItem, kTribeeSteamHomeGame, kTribeeSteamHomeAchievement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TribeeSteamGameAchievementState getGameAchievementState(KTribeeSteamHomeGameItem game, KTribeeSteamHomeGame games, KTribeeSteamHomeAchievement achievements) {
        KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement;
        KTribeeSteamHomeAchievementEmpty value;
        KTribeeSteamHomeAchievementEmpty value2;
        if (game == null) {
            if (achievements == null) {
                kTribeeSteamHomeAchievement = null;
            } else {
                kTribeeSteamHomeAchievement = KTribeeSteamHomeAchievement.copy$default(achievements, (KTribeeSteamHomeAchievement.KTribeeSteamHomeAchievementType) null, (String) null, (String) null, (KTribeeSteamHomeAchievement.IData) null, 7, (Object) null);
            }
            KTribeeSteamHomeAchievement.IData data = achievements != null ? achievements.getData() : null;
            KTribeeSteamHomeAchievement.KEmpty kEmpty = data instanceof KTribeeSteamHomeAchievement.KEmpty ? (KTribeeSteamHomeAchievement.KEmpty) data : null;
            KTipsCard tips = (kEmpty == null || (value2 = kEmpty.getValue()) == null) ? null : value2.getTips();
            KTribeeSteamHomeAchievement.IData data2 = achievements != null ? achievements.getData() : null;
            KTribeeSteamHomeAchievement.KEmpty kEmpty2 = data2 instanceof KTribeeSteamHomeAchievement.KEmpty ? (KTribeeSteamHomeAchievement.KEmpty) data2 : null;
            if (kEmpty2 != null && (value = kEmpty2.getValue()) != null) {
                achievementData = value.getSteamPrivateRule();
            }
            return new TribeeSteamGameAchievementState.EmptyGameState(kTribeeSteamHomeAchievement, tips, achievementData);
        }
        achievementData = achievements != null ? achievements.getData() : null;
        if (achievementData instanceof KTribeeSteamHomeAchievement.KEmpty) {
            KTribeeSteamHomeAchievement.KEmpty data3 = achievements.getData();
            Intrinsics.checkNotNull(data3, "null cannot be cast to non-null type com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement.KEmpty");
            KTipsCard tips2 = data3.getValue().getTips();
            KTribeeSteamHomeAchievement.KEmpty data4 = achievements.getData();
            Intrinsics.checkNotNull(data4, "null cannot be cast to non-null type com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement.KEmpty");
            return new TribeeSteamGameAchievementState.GameWithoutAchievementsState(achievements, game, tips2, data4.getValue().getSteamPrivateRule(), games);
        } else if (achievementData instanceof KTribeeSteamHomeAchievement.KSuccess) {
            KTribeeSteamHomeAchievementSuccess.KSuccess data5 = achievementData.getValue().getData();
            if (data5 instanceof KTribeeSteamHomeAchievementSuccess.KSuccess) {
                List sectionList = CollectionsKt.chunked(data5.getValue().getItems(), 3);
                if (sectionList.isEmpty()) {
                    return new TribeeSteamGameAchievementState.GameWithoutAchievementsState(achievements, game, null, null, games);
                }
                return new TribeeSteamGameAchievementState.SuccessGameAchievementState(achievements, sectionList, game, games);
            } else if (data5 instanceof KTribeeSteamHomeAchievementSuccess.KEmpty) {
                return new TribeeSteamGameAchievementState.GameWithoutAchievementsState(achievements, game, ((KTribeeSteamHomeAchievementSuccess.KEmpty) data5).getValue().getTips(), ((KTribeeSteamHomeAchievementSuccess.KEmpty) data5).getValue().getSteamPrivateRule(), games);
            } else {
                return new TribeeSteamGameAchievementState.ErrorGameAchievementState(achievements, game, games);
            }
        } else {
            return new TribeeSteamGameAchievementState.ErrorGameAchievementState(achievements, game, games);
        }
    }
}