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

/* compiled from: SteamGameAchievementBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lkntr/app/game/bean/AchievementHeader;", RoomRecommendViewModel.EMPTY_CURSOR, "gameCoverUrl", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", "appIconRgb", "achievementStats", "Lkntr/app/game/bean/AchievementStats;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/game/bean/AchievementStats;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/game/bean/AchievementStats;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameCoverUrl$annotations", "()V", "getGameCoverUrl", "()Ljava/lang/String;", "getGameName$annotations", "getGameName", "getAppIconRgb$annotations", "getAppIconRgb", "getAchievementStats$annotations", "getAchievementStats", "()Lkntr/app/game/bean/AchievementStats;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AchievementHeader {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AchievementStats achievementStats;
    private final String appIconRgb;
    private final String gameCoverUrl;
    private final String gameName;

    public AchievementHeader() {
        this((String) null, (String) null, (String) null, (AchievementStats) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AchievementHeader copy$default(AchievementHeader achievementHeader, String str, String str2, String str3, AchievementStats achievementStats, int i, Object obj) {
        if ((i & 1) != 0) {
            str = achievementHeader.gameCoverUrl;
        }
        if ((i & 2) != 0) {
            str2 = achievementHeader.gameName;
        }
        if ((i & 4) != 0) {
            str3 = achievementHeader.appIconRgb;
        }
        if ((i & 8) != 0) {
            achievementStats = achievementHeader.achievementStats;
        }
        return achievementHeader.copy(str, str2, str3, achievementStats);
    }

    @SerialName("achievement_stats")
    public static /* synthetic */ void getAchievementStats$annotations() {
    }

    @SerialName("app_icon_rgb")
    public static /* synthetic */ void getAppIconRgb$annotations() {
    }

    @SerialName("game_cover_url")
    public static /* synthetic */ void getGameCoverUrl$annotations() {
    }

    @SerialName("game_name")
    public static /* synthetic */ void getGameName$annotations() {
    }

    public final String component1() {
        return this.gameCoverUrl;
    }

    public final String component2() {
        return this.gameName;
    }

    public final String component3() {
        return this.appIconRgb;
    }

    public final AchievementStats component4() {
        return this.achievementStats;
    }

    public final AchievementHeader copy(String str, String str2, String str3, AchievementStats achievementStats) {
        Intrinsics.checkNotNullParameter(str, "gameCoverUrl");
        Intrinsics.checkNotNullParameter(str2, "gameName");
        Intrinsics.checkNotNullParameter(str3, "appIconRgb");
        return new AchievementHeader(str, str2, str3, achievementStats);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AchievementHeader) {
            AchievementHeader achievementHeader = (AchievementHeader) obj;
            return Intrinsics.areEqual(this.gameCoverUrl, achievementHeader.gameCoverUrl) && Intrinsics.areEqual(this.gameName, achievementHeader.gameName) && Intrinsics.areEqual(this.appIconRgb, achievementHeader.appIconRgb) && Intrinsics.areEqual(this.achievementStats, achievementHeader.achievementStats);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.gameCoverUrl.hashCode() * 31) + this.gameName.hashCode()) * 31) + this.appIconRgb.hashCode()) * 31) + (this.achievementStats == null ? 0 : this.achievementStats.hashCode());
    }

    public String toString() {
        String str = this.gameCoverUrl;
        String str2 = this.gameName;
        String str3 = this.appIconRgb;
        return "AchievementHeader(gameCoverUrl=" + str + ", gameName=" + str2 + ", appIconRgb=" + str3 + ", achievementStats=" + this.achievementStats + ")";
    }

    /* compiled from: SteamGameAchievementBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/AchievementHeader$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/AchievementHeader;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AchievementHeader> serializer() {
            return AchievementHeader$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AchievementHeader(int seen0, String gameCoverUrl, String gameName, String appIconRgb, AchievementStats achievementStats, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.gameCoverUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameCoverUrl = gameCoverUrl;
        }
        if ((seen0 & 2) == 0) {
            this.gameName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameName = gameName;
        }
        if ((seen0 & 4) == 0) {
            this.appIconRgb = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appIconRgb = appIconRgb;
        }
        if ((seen0 & 8) == 0) {
            this.achievementStats = null;
        } else {
            this.achievementStats = achievementStats;
        }
    }

    public AchievementHeader(String gameCoverUrl, String gameName, String appIconRgb, AchievementStats achievementStats) {
        Intrinsics.checkNotNullParameter(gameCoverUrl, "gameCoverUrl");
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(appIconRgb, "appIconRgb");
        this.gameCoverUrl = gameCoverUrl;
        this.gameName = gameName;
        this.appIconRgb = appIconRgb;
        this.achievementStats = achievementStats;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(AchievementHeader self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.gameCoverUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.gameCoverUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.gameName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.gameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.appIconRgb, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.appIconRgb);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.achievementStats != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, AchievementStats$$serializer.INSTANCE, self.achievementStats);
        }
    }

    public /* synthetic */ AchievementHeader(String str, String str2, String str3, AchievementStats achievementStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? null : achievementStats);
    }

    public final String getGameCoverUrl() {
        return this.gameCoverUrl;
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getAppIconRgb() {
        return this.appIconRgb;
    }

    public final AchievementStats getAchievementStats() {
        return this.achievementStats;
    }
}