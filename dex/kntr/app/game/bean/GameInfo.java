package kntr.app.game.bean;

import ComposableSingletons$CustomBottomSheetKt$;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0002<=BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eBc\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003JY\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0007HÖ\u0001J\t\u00103\u001a\u00020\u0005HÖ\u0001J%\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\b;R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b\t\u0010\u001cR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0019R\u001c\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u001c¨\u0006>"}, d2 = {"Lkntr/app/game/bean/GameInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "appId", RoomRecommendViewModel.EMPTY_CURSOR, "appName", RoomRecommendViewModel.EMPTY_CURSOR, "appPrice", RoomRecommendViewModel.EMPTY_CURSOR, "priceInYuan", "isFree", "appIconUrl", "appIconRgb", "totalAchievementsCount", "<init>", "(JLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppId$annotations", "()V", "getAppId", "()J", "getAppName$annotations", "getAppName", "()Ljava/lang/String;", "getAppPrice$annotations", "getAppPrice", "()I", "getPriceInYuan$annotations", "getPriceInYuan", "isFree$annotations", "getAppIconUrl$annotations", "getAppIconUrl", "getAppIconRgb$annotations", "getAppIconRgb", "getTotalAchievementsCount$annotations", "getTotalAchievementsCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class GameInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String appIconRgb;
    private final String appIconUrl;
    private final long appId;
    private final String appName;
    private final int appPrice;
    private final int isFree;
    private final String priceInYuan;
    private final int totalAchievementsCount;

    public GameInfo() {
        this(0L, (String) null, 0, (String) null, 0, (String) null, (String) null, 0, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("app_icon_rgb")
    public static /* synthetic */ void getAppIconRgb$annotations() {
    }

    @SerialName("app_icon_url")
    public static /* synthetic */ void getAppIconUrl$annotations() {
    }

    @SerialName("app_id")
    public static /* synthetic */ void getAppId$annotations() {
    }

    @SerialName("app_name")
    public static /* synthetic */ void getAppName$annotations() {
    }

    @SerialName("app_price")
    public static /* synthetic */ void getAppPrice$annotations() {
    }

    @SerialName("price_in_yuan")
    public static /* synthetic */ void getPriceInYuan$annotations() {
    }

    @SerialName("total_achievements_count")
    public static /* synthetic */ void getTotalAchievementsCount$annotations() {
    }

    @SerialName("is_free")
    public static /* synthetic */ void isFree$annotations() {
    }

    public final long component1() {
        return this.appId;
    }

    public final String component2() {
        return this.appName;
    }

    public final int component3() {
        return this.appPrice;
    }

    public final String component4() {
        return this.priceInYuan;
    }

    public final int component5() {
        return this.isFree;
    }

    public final String component6() {
        return this.appIconUrl;
    }

    public final String component7() {
        return this.appIconRgb;
    }

    public final int component8() {
        return this.totalAchievementsCount;
    }

    public final GameInfo copy(long j2, String str, int i, String str2, int i2, String str3, String str4, int i3) {
        Intrinsics.checkNotNullParameter(str, "appName");
        Intrinsics.checkNotNullParameter(str2, "priceInYuan");
        Intrinsics.checkNotNullParameter(str3, "appIconUrl");
        Intrinsics.checkNotNullParameter(str4, "appIconRgb");
        return new GameInfo(j2, str, i, str2, i2, str3, str4, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GameInfo) {
            GameInfo gameInfo = (GameInfo) obj;
            return this.appId == gameInfo.appId && Intrinsics.areEqual(this.appName, gameInfo.appName) && this.appPrice == gameInfo.appPrice && Intrinsics.areEqual(this.priceInYuan, gameInfo.priceInYuan) && this.isFree == gameInfo.isFree && Intrinsics.areEqual(this.appIconUrl, gameInfo.appIconUrl) && Intrinsics.areEqual(this.appIconRgb, gameInfo.appIconRgb) && this.totalAchievementsCount == gameInfo.totalAchievementsCount;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.appId) * 31) + this.appName.hashCode()) * 31) + this.appPrice) * 31) + this.priceInYuan.hashCode()) * 31) + this.isFree) * 31) + this.appIconUrl.hashCode()) * 31) + this.appIconRgb.hashCode()) * 31) + this.totalAchievementsCount;
    }

    public String toString() {
        long j2 = this.appId;
        String str = this.appName;
        int i = this.appPrice;
        String str2 = this.priceInYuan;
        int i2 = this.isFree;
        String str3 = this.appIconUrl;
        String str4 = this.appIconRgb;
        return "GameInfo(appId=" + j2 + ", appName=" + str + ", appPrice=" + i + ", priceInYuan=" + str2 + ", isFree=" + i2 + ", appIconUrl=" + str3 + ", appIconRgb=" + str4 + ", totalAchievementsCount=" + this.totalAchievementsCount + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/GameInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/GameInfo;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<GameInfo> serializer() {
            return GameInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ GameInfo(int seen0, long appId, String appName, int appPrice, String priceInYuan, int isFree, String appIconUrl, String appIconRgb, int totalAchievementsCount, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.appId = 0L;
        } else {
            this.appId = appId;
        }
        if ((seen0 & 2) == 0) {
            this.appName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appName = appName;
        }
        if ((seen0 & 4) == 0) {
            this.appPrice = 0;
        } else {
            this.appPrice = appPrice;
        }
        if ((seen0 & 8) == 0) {
            this.priceInYuan = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.priceInYuan = priceInYuan;
        }
        if ((seen0 & 16) == 0) {
            this.isFree = 0;
        } else {
            this.isFree = isFree;
        }
        if ((seen0 & 32) == 0) {
            this.appIconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appIconUrl = appIconUrl;
        }
        if ((seen0 & 64) == 0) {
            this.appIconRgb = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appIconRgb = appIconRgb;
        }
        if ((seen0 & 128) == 0) {
            this.totalAchievementsCount = 0;
        } else {
            this.totalAchievementsCount = totalAchievementsCount;
        }
    }

    public GameInfo(long appId, String appName, int appPrice, String priceInYuan, int isFree, String appIconUrl, String appIconRgb, int totalAchievementsCount) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(priceInYuan, "priceInYuan");
        Intrinsics.checkNotNullParameter(appIconUrl, "appIconUrl");
        Intrinsics.checkNotNullParameter(appIconRgb, "appIconRgb");
        this.appId = appId;
        this.appName = appName;
        this.appPrice = appPrice;
        this.priceInYuan = priceInYuan;
        this.isFree = isFree;
        this.appIconUrl = appIconUrl;
        this.appIconRgb = appIconRgb;
        this.totalAchievementsCount = totalAchievementsCount;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(GameInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.appId != 0) {
            output.encodeLongElement(serialDesc, 0, self.appId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.appName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.appName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.appPrice != 0) {
            output.encodeIntElement(serialDesc, 2, self.appPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.priceInYuan, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.priceInYuan);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.isFree != 0) {
            output.encodeIntElement(serialDesc, 4, self.isFree);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.appIconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 5, self.appIconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.appIconRgb, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.appIconRgb);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.totalAchievementsCount != 0) {
            output.encodeIntElement(serialDesc, 7, self.totalAchievementsCount);
        }
    }

    public /* synthetic */ GameInfo(long j2, String str, int i, String str2, int i2, String str3, String str4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j2, (i4 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i4 & 64) == 0 ? str4 : RoomRecommendViewModel.EMPTY_CURSOR, (i4 & 128) == 0 ? i3 : 0);
    }

    public final long getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final int getAppPrice() {
        return this.appPrice;
    }

    public final String getPriceInYuan() {
        return this.priceInYuan;
    }

    public final int isFree() {
        return this.isFree;
    }

    public final String getAppIconUrl() {
        return this.appIconUrl;
    }

    public final String getAppIconRgb() {
        return this.appIconRgb;
    }

    public final int getTotalAchievementsCount() {
        return this.totalAchievementsCount;
    }
}