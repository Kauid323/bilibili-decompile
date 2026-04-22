package kntr.app.game.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0002=>BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fBW\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000e\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0011HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010!R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010$R\u001e\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010'¨\u0006?"}, d2 = {"Lkntr/app/game/bean/SteamGameDetailData;", RoomRecommendViewModel.EMPTY_CURSOR, "gameInfo", "Lkntr/app/game/bean/GameInfo;", "playerInfo", "Lkntr/app/game/bean/SteamPlayerInfo;", "playData", "Lkntr/app/game/bean/PlayData;", "achievementProgress", "Lkntr/app/game/bean/AchievementProgress;", "recentAchievements", "Lkntr/app/game/bean/RecentAchievements;", "dlcModule", "Lkntr/app/game/bean/DlcModule;", "<init>", "(Lkntr/app/game/bean/GameInfo;Lkntr/app/game/bean/SteamPlayerInfo;Lkntr/app/game/bean/PlayData;Lkntr/app/game/bean/AchievementProgress;Lkntr/app/game/bean/RecentAchievements;Lkntr/app/game/bean/DlcModule;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/app/game/bean/GameInfo;Lkntr/app/game/bean/SteamPlayerInfo;Lkntr/app/game/bean/PlayData;Lkntr/app/game/bean/AchievementProgress;Lkntr/app/game/bean/RecentAchievements;Lkntr/app/game/bean/DlcModule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameInfo$annotations", "()V", "getGameInfo", "()Lkntr/app/game/bean/GameInfo;", "getPlayerInfo$annotations", "getPlayerInfo", "()Lkntr/app/game/bean/SteamPlayerInfo;", "getPlayData$annotations", "getPlayData", "()Lkntr/app/game/bean/PlayData;", "getAchievementProgress$annotations", "getAchievementProgress", "()Lkntr/app/game/bean/AchievementProgress;", "getRecentAchievements$annotations", "getRecentAchievements", "()Lkntr/app/game/bean/RecentAchievements;", "getDlcModule$annotations", "getDlcModule", "()Lkntr/app/game/bean/DlcModule;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SteamGameDetailData {
    private final AchievementProgress achievementProgress;
    private final DlcModule dlcModule;
    private final GameInfo gameInfo;
    private final PlayData playData;
    private final SteamPlayerInfo playerInfo;
    private final RecentAchievements recentAchievements;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public SteamGameDetailData() {
        this((GameInfo) null, (SteamPlayerInfo) null, (PlayData) null, (AchievementProgress) null, (RecentAchievements) null, (DlcModule) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SteamGameDetailData copy$default(SteamGameDetailData steamGameDetailData, GameInfo gameInfo, SteamPlayerInfo steamPlayerInfo, PlayData playData, AchievementProgress achievementProgress, RecentAchievements recentAchievements, DlcModule dlcModule, int i, Object obj) {
        if ((i & 1) != 0) {
            gameInfo = steamGameDetailData.gameInfo;
        }
        if ((i & 2) != 0) {
            steamPlayerInfo = steamGameDetailData.playerInfo;
        }
        SteamPlayerInfo steamPlayerInfo2 = steamPlayerInfo;
        if ((i & 4) != 0) {
            playData = steamGameDetailData.playData;
        }
        PlayData playData2 = playData;
        if ((i & 8) != 0) {
            achievementProgress = steamGameDetailData.achievementProgress;
        }
        AchievementProgress achievementProgress2 = achievementProgress;
        if ((i & 16) != 0) {
            recentAchievements = steamGameDetailData.recentAchievements;
        }
        RecentAchievements recentAchievements2 = recentAchievements;
        if ((i & 32) != 0) {
            dlcModule = steamGameDetailData.dlcModule;
        }
        return steamGameDetailData.copy(gameInfo, steamPlayerInfo2, playData2, achievementProgress2, recentAchievements2, dlcModule);
    }

    @SerialName("achievement_progress")
    public static /* synthetic */ void getAchievementProgress$annotations() {
    }

    @SerialName("dlc_module")
    public static /* synthetic */ void getDlcModule$annotations() {
    }

    @SerialName("game_info")
    public static /* synthetic */ void getGameInfo$annotations() {
    }

    @SerialName("play_data")
    public static /* synthetic */ void getPlayData$annotations() {
    }

    @SerialName("player_info")
    public static /* synthetic */ void getPlayerInfo$annotations() {
    }

    @SerialName("recent_achievements")
    public static /* synthetic */ void getRecentAchievements$annotations() {
    }

    public final GameInfo component1() {
        return this.gameInfo;
    }

    public final SteamPlayerInfo component2() {
        return this.playerInfo;
    }

    public final PlayData component3() {
        return this.playData;
    }

    public final AchievementProgress component4() {
        return this.achievementProgress;
    }

    public final RecentAchievements component5() {
        return this.recentAchievements;
    }

    public final DlcModule component6() {
        return this.dlcModule;
    }

    public final SteamGameDetailData copy(GameInfo gameInfo, SteamPlayerInfo steamPlayerInfo, PlayData playData, AchievementProgress achievementProgress, RecentAchievements recentAchievements, DlcModule dlcModule) {
        return new SteamGameDetailData(gameInfo, steamPlayerInfo, playData, achievementProgress, recentAchievements, dlcModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SteamGameDetailData) {
            SteamGameDetailData steamGameDetailData = (SteamGameDetailData) obj;
            return Intrinsics.areEqual(this.gameInfo, steamGameDetailData.gameInfo) && Intrinsics.areEqual(this.playerInfo, steamGameDetailData.playerInfo) && Intrinsics.areEqual(this.playData, steamGameDetailData.playData) && Intrinsics.areEqual(this.achievementProgress, steamGameDetailData.achievementProgress) && Intrinsics.areEqual(this.recentAchievements, steamGameDetailData.recentAchievements) && Intrinsics.areEqual(this.dlcModule, steamGameDetailData.dlcModule);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((this.gameInfo == null ? 0 : this.gameInfo.hashCode()) * 31) + (this.playerInfo == null ? 0 : this.playerInfo.hashCode())) * 31) + (this.playData == null ? 0 : this.playData.hashCode())) * 31) + (this.achievementProgress == null ? 0 : this.achievementProgress.hashCode())) * 31) + (this.recentAchievements == null ? 0 : this.recentAchievements.hashCode())) * 31) + (this.dlcModule != null ? this.dlcModule.hashCode() : 0);
    }

    public String toString() {
        GameInfo gameInfo = this.gameInfo;
        SteamPlayerInfo steamPlayerInfo = this.playerInfo;
        PlayData playData = this.playData;
        AchievementProgress achievementProgress = this.achievementProgress;
        RecentAchievements recentAchievements = this.recentAchievements;
        return "SteamGameDetailData(gameInfo=" + gameInfo + ", playerInfo=" + steamPlayerInfo + ", playData=" + playData + ", achievementProgress=" + achievementProgress + ", recentAchievements=" + recentAchievements + ", dlcModule=" + this.dlcModule + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/SteamGameDetailData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/SteamGameDetailData;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SteamGameDetailData> serializer() {
            return SteamGameDetailData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SteamGameDetailData(int seen0, GameInfo gameInfo, SteamPlayerInfo playerInfo, PlayData playData, AchievementProgress achievementProgress, RecentAchievements recentAchievements, DlcModule dlcModule, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.gameInfo = null;
        } else {
            this.gameInfo = gameInfo;
        }
        if ((seen0 & 2) == 0) {
            this.playerInfo = null;
        } else {
            this.playerInfo = playerInfo;
        }
        if ((seen0 & 4) == 0) {
            this.playData = null;
        } else {
            this.playData = playData;
        }
        if ((seen0 & 8) == 0) {
            this.achievementProgress = null;
        } else {
            this.achievementProgress = achievementProgress;
        }
        if ((seen0 & 16) == 0) {
            this.recentAchievements = null;
        } else {
            this.recentAchievements = recentAchievements;
        }
        if ((seen0 & 32) == 0) {
            this.dlcModule = null;
        } else {
            this.dlcModule = dlcModule;
        }
    }

    public SteamGameDetailData(GameInfo gameInfo, SteamPlayerInfo playerInfo, PlayData playData, AchievementProgress achievementProgress, RecentAchievements recentAchievements, DlcModule dlcModule) {
        this.gameInfo = gameInfo;
        this.playerInfo = playerInfo;
        this.playData = playData;
        this.achievementProgress = achievementProgress;
        this.recentAchievements = recentAchievements;
        this.dlcModule = dlcModule;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(SteamGameDetailData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.gameInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, GameInfo$$serializer.INSTANCE, self.gameInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.playerInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, SteamPlayerInfo$$serializer.INSTANCE, self.playerInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.playData != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, PlayData$$serializer.INSTANCE, self.playData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.achievementProgress != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AchievementProgress$$serializer.INSTANCE, self.achievementProgress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.recentAchievements != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, RecentAchievements$$serializer.INSTANCE, self.recentAchievements);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.dlcModule != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, DlcModule$$serializer.INSTANCE, self.dlcModule);
        }
    }

    public /* synthetic */ SteamGameDetailData(GameInfo gameInfo, SteamPlayerInfo steamPlayerInfo, PlayData playData, AchievementProgress achievementProgress, RecentAchievements recentAchievements, DlcModule dlcModule, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : gameInfo, (i & 2) != 0 ? null : steamPlayerInfo, (i & 4) != 0 ? null : playData, (i & 8) != 0 ? null : achievementProgress, (i & 16) != 0 ? null : recentAchievements, (i & 32) != 0 ? null : dlcModule);
    }

    public final GameInfo getGameInfo() {
        return this.gameInfo;
    }

    public final SteamPlayerInfo getPlayerInfo() {
        return this.playerInfo;
    }

    public final PlayData getPlayData() {
        return this.playData;
    }

    public final AchievementProgress getAchievementProgress() {
        return this.achievementProgress;
    }

    public final RecentAchievements getRecentAchievements() {
        return this.recentAchievements;
    }

    public final DlcModule getDlcModule() {
        return this.dlcModule;
    }
}