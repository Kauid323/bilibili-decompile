package kntr.app.tribee.steam.state;

import com.bapis.bilibili.app.dynamic.v2.KLinkUrl;
import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamGameAchievementState.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0018\u0019\u001a\u001b\u001cBE\b\u0004\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0005\u001d\u001e\u001f !¨\u0006\""}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "tipsCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "steamPrivateRule", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;)V", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "getGames", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "getTipsCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "getSteamPrivateRule", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "EmptyGameState", "GameWithoutAchievementsState", "LoadingGameAchievementState", "ErrorGameAchievementState", "SuccessGameAchievementState", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$EmptyGameState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$ErrorGameAchievementState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$GameWithoutAchievementsState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$LoadingGameAchievementState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$SuccessGameAchievementState;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeSteamGameAchievementState {
    public static final int $stable = 0;
    private final KTribeeSteamHomeAchievement achievements;
    private final KTribeeSteamHomeGame games;
    private final KTribeeSteamHomeGameItem selectedGame;
    private final KLinkUrl steamPrivateRule;
    private final KTipsCard tipsCard;

    public /* synthetic */ TribeeSteamGameAchievementState(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, KTipsCard kTipsCard, KLinkUrl kLinkUrl, DefaultConstructorMarker defaultConstructorMarker) {
        this(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem, kTribeeSteamHomeGame, kTipsCard, kLinkUrl);
    }

    private TribeeSteamGameAchievementState(KTribeeSteamHomeAchievement achievements, KTribeeSteamHomeGameItem selectedGame, KTribeeSteamHomeGame games, KTipsCard tipsCard, KLinkUrl steamPrivateRule) {
        this.achievements = achievements;
        this.selectedGame = selectedGame;
        this.games = games;
        this.tipsCard = tipsCard;
        this.steamPrivateRule = steamPrivateRule;
    }

    public /* synthetic */ TribeeSteamGameAchievementState(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, KTipsCard kTipsCard, KLinkUrl kLinkUrl, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : kTribeeSteamHomeAchievement, (i & 2) != 0 ? null : kTribeeSteamHomeGameItem, (i & 4) != 0 ? null : kTribeeSteamHomeGame, (i & 8) != 0 ? null : kTipsCard, (i & 16) != 0 ? null : kLinkUrl, null);
    }

    public KTribeeSteamHomeAchievement getAchievements() {
        return this.achievements;
    }

    public KTribeeSteamHomeGameItem getSelectedGame() {
        return this.selectedGame;
    }

    public KTribeeSteamHomeGame getGames() {
        return this.games;
    }

    public KTipsCard getTipsCard() {
        return this.tipsCard;
    }

    public KLinkUrl getSteamPrivateRule() {
        return this.steamPrivateRule;
    }

    /* compiled from: TribeeSteamGameAchievementState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$EmptyGameState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "tipsCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "steamPrivateRule", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;)V", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getTipsCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "getSteamPrivateRule", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EmptyGameState extends TribeeSteamGameAchievementState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeAchievement achievements;
        private final KLinkUrl steamPrivateRule;
        private final KTipsCard tipsCard;

        public static /* synthetic */ EmptyGameState copy$default(EmptyGameState emptyGameState, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTipsCard kTipsCard, KLinkUrl kLinkUrl, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeAchievement = emptyGameState.achievements;
            }
            if ((i & 2) != 0) {
                kTipsCard = emptyGameState.tipsCard;
            }
            if ((i & 4) != 0) {
                kLinkUrl = emptyGameState.steamPrivateRule;
            }
            return emptyGameState.copy(kTribeeSteamHomeAchievement, kTipsCard, kLinkUrl);
        }

        public final KTribeeSteamHomeAchievement component1() {
            return this.achievements;
        }

        public final KTipsCard component2() {
            return this.tipsCard;
        }

        public final KLinkUrl component3() {
            return this.steamPrivateRule;
        }

        public final EmptyGameState copy(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTipsCard kTipsCard, KLinkUrl kLinkUrl) {
            return new EmptyGameState(kTribeeSteamHomeAchievement, kTipsCard, kLinkUrl);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EmptyGameState) {
                EmptyGameState emptyGameState = (EmptyGameState) obj;
                return Intrinsics.areEqual(this.achievements, emptyGameState.achievements) && Intrinsics.areEqual(this.tipsCard, emptyGameState.tipsCard) && Intrinsics.areEqual(this.steamPrivateRule, emptyGameState.steamPrivateRule);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.achievements == null ? 0 : this.achievements.hashCode()) * 31) + (this.tipsCard == null ? 0 : this.tipsCard.hashCode())) * 31) + (this.steamPrivateRule != null ? this.steamPrivateRule.hashCode() : 0);
        }

        public String toString() {
            KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement = this.achievements;
            KTipsCard kTipsCard = this.tipsCard;
            return "EmptyGameState(achievements=" + kTribeeSteamHomeAchievement + ", tipsCard=" + kTipsCard + ", steamPrivateRule=" + this.steamPrivateRule + ")";
        }

        public EmptyGameState(KTribeeSteamHomeAchievement achievements, KTipsCard tipsCard, KLinkUrl steamPrivateRule) {
            super(null, null, null, null, null, 31, null);
            this.achievements = achievements;
            this.tipsCard = tipsCard;
            this.steamPrivateRule = steamPrivateRule;
        }

        public /* synthetic */ EmptyGameState(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTipsCard kTipsCard, KLinkUrl kLinkUrl, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kTribeeSteamHomeAchievement, (i & 2) != 0 ? null : kTipsCard, (i & 4) != 0 ? null : kLinkUrl);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeAchievement getAchievements() {
            return this.achievements;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTipsCard getTipsCard() {
            return this.tipsCard;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KLinkUrl getSteamPrivateRule() {
            return this.steamPrivateRule;
        }
    }

    /* compiled from: TribeeSteamGameAchievementState.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$GameWithoutAchievementsState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "tipsCard", "Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "steamPrivateRule", "Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;)V", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "getTipsCard", "()Lcom/bapis/bilibili/app/dynamic/v2/KTipsCard;", "getSteamPrivateRule", "()Lcom/bapis/bilibili/app/dynamic/v2/KLinkUrl;", "getGames", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class GameWithoutAchievementsState extends TribeeSteamGameAchievementState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeAchievement achievements;
        private final KTribeeSteamHomeGame games;
        private final KTribeeSteamHomeGameItem selectedGame;
        private final KLinkUrl steamPrivateRule;
        private final KTipsCard tipsCard;

        public static /* synthetic */ GameWithoutAchievementsState copy$default(GameWithoutAchievementsState gameWithoutAchievementsState, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTipsCard kTipsCard, KLinkUrl kLinkUrl, KTribeeSteamHomeGame kTribeeSteamHomeGame, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeAchievement = gameWithoutAchievementsState.achievements;
            }
            if ((i & 2) != 0) {
                kTribeeSteamHomeGameItem = gameWithoutAchievementsState.selectedGame;
            }
            KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem2 = kTribeeSteamHomeGameItem;
            if ((i & 4) != 0) {
                kTipsCard = gameWithoutAchievementsState.tipsCard;
            }
            KTipsCard kTipsCard2 = kTipsCard;
            if ((i & 8) != 0) {
                kLinkUrl = gameWithoutAchievementsState.steamPrivateRule;
            }
            KLinkUrl kLinkUrl2 = kLinkUrl;
            if ((i & 16) != 0) {
                kTribeeSteamHomeGame = gameWithoutAchievementsState.games;
            }
            return gameWithoutAchievementsState.copy(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem2, kTipsCard2, kLinkUrl2, kTribeeSteamHomeGame);
        }

        public final KTribeeSteamHomeAchievement component1() {
            return this.achievements;
        }

        public final KTribeeSteamHomeGameItem component2() {
            return this.selectedGame;
        }

        public final KTipsCard component3() {
            return this.tipsCard;
        }

        public final KLinkUrl component4() {
            return this.steamPrivateRule;
        }

        public final KTribeeSteamHomeGame component5() {
            return this.games;
        }

        public final GameWithoutAchievementsState copy(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTipsCard kTipsCard, KLinkUrl kLinkUrl, KTribeeSteamHomeGame kTribeeSteamHomeGame) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new GameWithoutAchievementsState(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem, kTipsCard, kLinkUrl, kTribeeSteamHomeGame);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GameWithoutAchievementsState) {
                GameWithoutAchievementsState gameWithoutAchievementsState = (GameWithoutAchievementsState) obj;
                return Intrinsics.areEqual(this.achievements, gameWithoutAchievementsState.achievements) && Intrinsics.areEqual(this.selectedGame, gameWithoutAchievementsState.selectedGame) && Intrinsics.areEqual(this.tipsCard, gameWithoutAchievementsState.tipsCard) && Intrinsics.areEqual(this.steamPrivateRule, gameWithoutAchievementsState.steamPrivateRule) && Intrinsics.areEqual(this.games, gameWithoutAchievementsState.games);
            }
            return false;
        }

        public int hashCode() {
            return ((((((((this.achievements == null ? 0 : this.achievements.hashCode()) * 31) + this.selectedGame.hashCode()) * 31) + (this.tipsCard == null ? 0 : this.tipsCard.hashCode())) * 31) + (this.steamPrivateRule == null ? 0 : this.steamPrivateRule.hashCode())) * 31) + (this.games != null ? this.games.hashCode() : 0);
        }

        public String toString() {
            KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement = this.achievements;
            KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem = this.selectedGame;
            KTipsCard kTipsCard = this.tipsCard;
            KLinkUrl kLinkUrl = this.steamPrivateRule;
            return "GameWithoutAchievementsState(achievements=" + kTribeeSteamHomeAchievement + ", selectedGame=" + kTribeeSteamHomeGameItem + ", tipsCard=" + kTipsCard + ", steamPrivateRule=" + kLinkUrl + ", games=" + this.games + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GameWithoutAchievementsState(KTribeeSteamHomeAchievement achievements, KTribeeSteamHomeGameItem selectedGame, KTipsCard tipsCard, KLinkUrl steamPrivateRule, KTribeeSteamHomeGame games) {
            super(null, null, null, null, null, 31, null);
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.achievements = achievements;
            this.selectedGame = selectedGame;
            this.tipsCard = tipsCard;
            this.steamPrivateRule = steamPrivateRule;
            this.games = games;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ GameWithoutAchievementsState(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTipsCard kTipsCard, KLinkUrl kLinkUrl, KTribeeSteamHomeGame kTribeeSteamHomeGame, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem, kTipsCard, r4, kTribeeSteamHomeGame);
            KLinkUrl kLinkUrl2;
            if ((i & 8) == 0) {
                kLinkUrl2 = kLinkUrl;
            } else {
                kLinkUrl2 = null;
            }
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeAchievement getAchievements() {
            return this.achievements;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTipsCard getTipsCard() {
            return this.tipsCard;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KLinkUrl getSteamPrivateRule() {
            return this.steamPrivateRule;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGame getGames() {
            return this.games;
        }
    }

    /* compiled from: TribeeSteamGameAchievementState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$LoadingGameAchievementState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;)V", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getGames", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadingGameAchievementState extends TribeeSteamGameAchievementState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeAchievement achievements;
        private final KTribeeSteamHomeGame games;
        private final KTribeeSteamHomeGameItem selectedGame;

        public static /* synthetic */ LoadingGameAchievementState copy$default(LoadingGameAchievementState loadingGameAchievementState, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGame kTribeeSteamHomeGame, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeGameItem = loadingGameAchievementState.selectedGame;
            }
            if ((i & 2) != 0) {
                kTribeeSteamHomeAchievement = loadingGameAchievementState.achievements;
            }
            if ((i & 4) != 0) {
                kTribeeSteamHomeGame = loadingGameAchievementState.games;
            }
            return loadingGameAchievementState.copy(kTribeeSteamHomeGameItem, kTribeeSteamHomeAchievement, kTribeeSteamHomeGame);
        }

        public final KTribeeSteamHomeGameItem component1() {
            return this.selectedGame;
        }

        public final KTribeeSteamHomeAchievement component2() {
            return this.achievements;
        }

        public final KTribeeSteamHomeGame component3() {
            return this.games;
        }

        public final LoadingGameAchievementState copy(KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGame kTribeeSteamHomeGame) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new LoadingGameAchievementState(kTribeeSteamHomeGameItem, kTribeeSteamHomeAchievement, kTribeeSteamHomeGame);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadingGameAchievementState) {
                LoadingGameAchievementState loadingGameAchievementState = (LoadingGameAchievementState) obj;
                return Intrinsics.areEqual(this.selectedGame, loadingGameAchievementState.selectedGame) && Intrinsics.areEqual(this.achievements, loadingGameAchievementState.achievements) && Intrinsics.areEqual(this.games, loadingGameAchievementState.games);
            }
            return false;
        }

        public int hashCode() {
            return (((this.selectedGame.hashCode() * 31) + (this.achievements == null ? 0 : this.achievements.hashCode())) * 31) + (this.games != null ? this.games.hashCode() : 0);
        }

        public String toString() {
            KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem = this.selectedGame;
            KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement = this.achievements;
            return "LoadingGameAchievementState(selectedGame=" + kTribeeSteamHomeGameItem + ", achievements=" + kTribeeSteamHomeAchievement + ", games=" + this.games + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingGameAchievementState(KTribeeSteamHomeGameItem selectedGame, KTribeeSteamHomeAchievement achievements, KTribeeSteamHomeGame games) {
            super(null, null, null, null, null, 31, null);
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.selectedGame = selectedGame;
            this.achievements = achievements;
            this.games = games;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeAchievement getAchievements() {
            return this.achievements;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGame getGames() {
            return this.games;
        }
    }

    /* compiled from: TribeeSteamGameAchievementState.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$ErrorGameAchievementState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;)V", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "getGames", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ErrorGameAchievementState extends TribeeSteamGameAchievementState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeAchievement achievements;
        private final KTribeeSteamHomeGame games;
        private final KTribeeSteamHomeGameItem selectedGame;

        public static /* synthetic */ ErrorGameAchievementState copy$default(ErrorGameAchievementState errorGameAchievementState, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeAchievement = errorGameAchievementState.achievements;
            }
            if ((i & 2) != 0) {
                kTribeeSteamHomeGameItem = errorGameAchievementState.selectedGame;
            }
            if ((i & 4) != 0) {
                kTribeeSteamHomeGame = errorGameAchievementState.games;
            }
            return errorGameAchievementState.copy(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem, kTribeeSteamHomeGame);
        }

        public final KTribeeSteamHomeAchievement component1() {
            return this.achievements;
        }

        public final KTribeeSteamHomeGameItem component2() {
            return this.selectedGame;
        }

        public final KTribeeSteamHomeGame component3() {
            return this.games;
        }

        public final ErrorGameAchievementState copy(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new ErrorGameAchievementState(kTribeeSteamHomeAchievement, kTribeeSteamHomeGameItem, kTribeeSteamHomeGame);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ErrorGameAchievementState) {
                ErrorGameAchievementState errorGameAchievementState = (ErrorGameAchievementState) obj;
                return Intrinsics.areEqual(this.achievements, errorGameAchievementState.achievements) && Intrinsics.areEqual(this.selectedGame, errorGameAchievementState.selectedGame) && Intrinsics.areEqual(this.games, errorGameAchievementState.games);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.achievements == null ? 0 : this.achievements.hashCode()) * 31) + this.selectedGame.hashCode()) * 31) + (this.games != null ? this.games.hashCode() : 0);
        }

        public String toString() {
            KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement = this.achievements;
            KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem = this.selectedGame;
            return "ErrorGameAchievementState(achievements=" + kTribeeSteamHomeAchievement + ", selectedGame=" + kTribeeSteamHomeGameItem + ", games=" + this.games + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ErrorGameAchievementState(KTribeeSteamHomeAchievement achievements, KTribeeSteamHomeGameItem selectedGame, KTribeeSteamHomeGame games) {
            super(null, null, null, null, null, 31, null);
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.achievements = achievements;
            this.selectedGame = selectedGame;
            this.games = games;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeAchievement getAchievements() {
            return this.achievements;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGame getGames() {
            return this.games;
        }
    }

    /* compiled from: TribeeSteamGameAchievementState.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState$SuccessGameAchievementState;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "achievements", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "sectionList", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;)V", "getAchievements", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievement;", "getSectionList", "()Ljava/util/List;", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "getGames", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class SuccessGameAchievementState extends TribeeSteamGameAchievementState {
        public static final int $stable = 0;
        private final KTribeeSteamHomeAchievement achievements;
        private final KTribeeSteamHomeGame games;
        private final List<List<KTribeeSteamHomeAchievementItem>> sectionList;
        private final KTribeeSteamHomeGameItem selectedGame;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SuccessGameAchievementState copy$default(SuccessGameAchievementState successGameAchievementState, KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, List list, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeAchievement = successGameAchievementState.achievements;
            }
            if ((i & 2) != 0) {
                list = successGameAchievementState.sectionList;
            }
            if ((i & 4) != 0) {
                kTribeeSteamHomeGameItem = successGameAchievementState.selectedGame;
            }
            if ((i & 8) != 0) {
                kTribeeSteamHomeGame = successGameAchievementState.games;
            }
            return successGameAchievementState.copy(kTribeeSteamHomeAchievement, list, kTribeeSteamHomeGameItem, kTribeeSteamHomeGame);
        }

        public final KTribeeSteamHomeAchievement component1() {
            return this.achievements;
        }

        public final List<List<KTribeeSteamHomeAchievementItem>> component2() {
            return this.sectionList;
        }

        public final KTribeeSteamHomeGameItem component3() {
            return this.selectedGame;
        }

        public final KTribeeSteamHomeGame component4() {
            return this.games;
        }

        public final SuccessGameAchievementState copy(KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement, List<? extends List<KTribeeSteamHomeAchievementItem>> list, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, KTribeeSteamHomeGame kTribeeSteamHomeGame) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeAchievement, "achievements");
            Intrinsics.checkNotNullParameter(list, "sectionList");
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new SuccessGameAchievementState(kTribeeSteamHomeAchievement, list, kTribeeSteamHomeGameItem, kTribeeSteamHomeGame);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SuccessGameAchievementState) {
                SuccessGameAchievementState successGameAchievementState = (SuccessGameAchievementState) obj;
                return Intrinsics.areEqual(this.achievements, successGameAchievementState.achievements) && Intrinsics.areEqual(this.sectionList, successGameAchievementState.sectionList) && Intrinsics.areEqual(this.selectedGame, successGameAchievementState.selectedGame) && Intrinsics.areEqual(this.games, successGameAchievementState.games);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.achievements.hashCode() * 31) + this.sectionList.hashCode()) * 31) + this.selectedGame.hashCode()) * 31) + (this.games == null ? 0 : this.games.hashCode());
        }

        public String toString() {
            KTribeeSteamHomeAchievement kTribeeSteamHomeAchievement = this.achievements;
            List<List<KTribeeSteamHomeAchievementItem>> list = this.sectionList;
            KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem = this.selectedGame;
            return "SuccessGameAchievementState(achievements=" + kTribeeSteamHomeAchievement + ", sectionList=" + list + ", selectedGame=" + kTribeeSteamHomeGameItem + ", games=" + this.games + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public SuccessGameAchievementState(KTribeeSteamHomeAchievement achievements, List<? extends List<KTribeeSteamHomeAchievementItem>> list, KTribeeSteamHomeGameItem selectedGame, KTribeeSteamHomeGame games) {
            super(null, null, null, null, null, 31, null);
            Intrinsics.checkNotNullParameter(achievements, "achievements");
            Intrinsics.checkNotNullParameter(list, "sectionList");
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.achievements = achievements;
            this.sectionList = list;
            this.selectedGame = selectedGame;
            this.games = games;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeAchievement getAchievements() {
            return this.achievements;
        }

        public final List<List<KTribeeSteamHomeAchievementItem>> getSectionList() {
            return this.sectionList;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamGameAchievementState
        public KTribeeSteamHomeGame getGames() {
            return this.games;
        }
    }
}