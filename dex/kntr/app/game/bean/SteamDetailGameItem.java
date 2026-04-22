package kntr.app.game.bean;

import com.bilibili.biligame.kntr.common.util.NumberExtKt;
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

/* compiled from: SteamDetailBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002=>Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011B}\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u0006\u00100\u001a\u00020\u0003J\u0006\u00101\u001a\u00020\u0003J\u0006\u00102\u001a\u00020\u0003J\u0006\u00103\u001a\u000204J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010 R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010 R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u0017\u001a\u0004\b&\u0010\u0019R\u001c\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010)R\u001c\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0017\u001a\u0004\b+\u0010\u0019R\u001c\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0017\u001a\u0004\b-\u0010)R\u001c\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010 ¨\u0006?"}, d2 = {"Lkntr/app/game/bean/SteamDetailGameItem;", RoomRecommendViewModel.EMPTY_CURSOR, "appId", RoomRecommendViewModel.EMPTY_CURSOR, "appName", "appIcon", "appPrice", RoomRecommendViewModel.EMPTY_CURSOR, "appAchievementsCount", "ownedAchievementsCount", "playtimeForever", "playtimeForeverHours", RoomRecommendViewModel.EMPTY_CURSOR, "playtimeLast2weeks", "playtimeLast2weeksHours", "moreThanPercent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;DLjava/lang/String;DI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;DLjava/lang/String;DILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAppId$annotations", "()V", "getAppId", "()Ljava/lang/String;", "getAppName$annotations", "getAppName", "getAppIcon$annotations", "getAppIcon", "getAppPrice$annotations", "getAppPrice", "()I", "getAppAchievementsCount$annotations", "getAppAchievementsCount", "getOwnedAchievementsCount$annotations", "getOwnedAchievementsCount", "getPlaytimeForever$annotations", "getPlaytimeForever", "getPlaytimeForeverHours$annotations", "getPlaytimeForeverHours", "()D", "getPlaytimeLast2weeks$annotations", "getPlaytimeLast2weeks", "getPlaytimeLast2weeksHours$annotations", "getPlaytimeLast2weeksHours", "getMoreThanPercent$annotations", "getMoreThanPercent", "moreThanPercentDesc", "playtimeForeverHoursDesc", "playtimeLast2weeksHoursDesc", "fullAchievements", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SteamDetailGameItem {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int appAchievementsCount;
    private final String appIcon;
    private final String appId;
    private final String appName;
    private final int appPrice;
    private final int moreThanPercent;
    private final int ownedAchievementsCount;
    private final String playtimeForever;
    private final double playtimeForeverHours;
    private final String playtimeLast2weeks;
    private final double playtimeLast2weeksHours;

    public SteamDetailGameItem() {
        this((String) null, (String) null, (String) null, 0, 0, 0, (String) null, 0.0d, (String) null, 0.0d, 0, 2047, (DefaultConstructorMarker) null);
    }

    @SerialName("app_achievements_count")
    public static /* synthetic */ void getAppAchievementsCount$annotations() {
    }

    @SerialName("app_icon")
    public static /* synthetic */ void getAppIcon$annotations() {
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

    @SerialName("more_than_percent")
    public static /* synthetic */ void getMoreThanPercent$annotations() {
    }

    @SerialName("owned_achievements_count")
    public static /* synthetic */ void getOwnedAchievementsCount$annotations() {
    }

    @SerialName("playtime_forever")
    public static /* synthetic */ void getPlaytimeForever$annotations() {
    }

    @SerialName("playtime_forever_hours")
    public static /* synthetic */ void getPlaytimeForeverHours$annotations() {
    }

    @SerialName("playtime_last2weeks")
    public static /* synthetic */ void getPlaytimeLast2weeks$annotations() {
    }

    @SerialName("playtime_last2weeks_hours")
    public static /* synthetic */ void getPlaytimeLast2weeksHours$annotations() {
    }

    /* compiled from: SteamDetailBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/SteamDetailGameItem$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/SteamDetailGameItem;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SteamDetailGameItem> serializer() {
            return SteamDetailGameItem$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SteamDetailGameItem(int seen0, String appId, String appName, String appIcon, int appPrice, int appAchievementsCount, int ownedAchievementsCount, String playtimeForever, double playtimeForeverHours, String playtimeLast2weeks, double playtimeLast2weeksHours, int moreThanPercent, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.appId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appId = appId;
        }
        if ((seen0 & 2) == 0) {
            this.appName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appName = appName;
        }
        if ((seen0 & 4) == 0) {
            this.appIcon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appIcon = appIcon;
        }
        if ((seen0 & 8) == 0) {
            this.appPrice = 0;
        } else {
            this.appPrice = appPrice;
        }
        if ((seen0 & 16) == 0) {
            this.appAchievementsCount = 0;
        } else {
            this.appAchievementsCount = appAchievementsCount;
        }
        if ((seen0 & 32) == 0) {
            this.ownedAchievementsCount = 0;
        } else {
            this.ownedAchievementsCount = ownedAchievementsCount;
        }
        if ((seen0 & 64) == 0) {
            this.playtimeForever = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playtimeForever = playtimeForever;
        }
        if ((seen0 & 128) == 0) {
            this.playtimeForeverHours = 0.0d;
        } else {
            this.playtimeForeverHours = playtimeForeverHours;
        }
        if ((seen0 & 256) == 0) {
            this.playtimeLast2weeks = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playtimeLast2weeks = playtimeLast2weeks;
        }
        if ((seen0 & 512) == 0) {
            this.playtimeLast2weeksHours = 0.0d;
        } else {
            this.playtimeLast2weeksHours = playtimeLast2weeksHours;
        }
        if ((seen0 & 1024) == 0) {
            this.moreThanPercent = 0;
        } else {
            this.moreThanPercent = moreThanPercent;
        }
    }

    public SteamDetailGameItem(String appId, String appName, String appIcon, int appPrice, int appAchievementsCount, int ownedAchievementsCount, String playtimeForever, double playtimeForeverHours, String playtimeLast2weeks, double playtimeLast2weeksHours, int moreThanPercent) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appIcon, "appIcon");
        Intrinsics.checkNotNullParameter(playtimeForever, "playtimeForever");
        Intrinsics.checkNotNullParameter(playtimeLast2weeks, "playtimeLast2weeks");
        this.appId = appId;
        this.appName = appName;
        this.appIcon = appIcon;
        this.appPrice = appPrice;
        this.appAchievementsCount = appAchievementsCount;
        this.ownedAchievementsCount = ownedAchievementsCount;
        this.playtimeForever = playtimeForever;
        this.playtimeForeverHours = playtimeForeverHours;
        this.playtimeLast2weeks = playtimeLast2weeks;
        this.playtimeLast2weeksHours = playtimeLast2weeksHours;
        this.moreThanPercent = moreThanPercent;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(SteamDetailGameItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.appId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.appId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.appName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.appName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.appIcon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.appIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.appPrice != 0) {
            output.encodeIntElement(serialDesc, 3, self.appPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.appAchievementsCount != 0) {
            output.encodeIntElement(serialDesc, 4, self.appAchievementsCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.ownedAchievementsCount != 0) {
            output.encodeIntElement(serialDesc, 5, self.ownedAchievementsCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.playtimeForever, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.playtimeForever);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || Double.compare(self.playtimeForeverHours, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 7, self.playtimeForeverHours);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.playtimeLast2weeks, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 8, self.playtimeLast2weeks);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || Double.compare(self.playtimeLast2weeksHours, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 9, self.playtimeLast2weeksHours);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.moreThanPercent != 0) {
            output.encodeIntElement(serialDesc, 10, self.moreThanPercent);
        }
    }

    public /* synthetic */ SteamDetailGameItem(String str, String str2, String str3, int i, int i2, int i3, String str4, double d, String str5, double d2, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i5 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i5 & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i5 & 8) != 0 ? 0 : i, (i5 & 16) != 0 ? 0 : i2, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str4, (i5 & 128) != 0 ? 0.0d : d, (i5 & 256) == 0 ? str5 : RoomRecommendViewModel.EMPTY_CURSOR, (i5 & 512) == 0 ? d2 : 0.0d, (i5 & 1024) == 0 ? i4 : 0);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppIcon() {
        return this.appIcon;
    }

    public final int getAppPrice() {
        return this.appPrice;
    }

    public final int getAppAchievementsCount() {
        return this.appAchievementsCount;
    }

    public final int getOwnedAchievementsCount() {
        return this.ownedAchievementsCount;
    }

    public final String getPlaytimeForever() {
        return this.playtimeForever;
    }

    public final double getPlaytimeForeverHours() {
        return this.playtimeForeverHours;
    }

    public final String getPlaytimeLast2weeks() {
        return this.playtimeLast2weeks;
    }

    public final double getPlaytimeLast2weeksHours() {
        return this.playtimeLast2weeksHours;
    }

    public final int getMoreThanPercent() {
        return this.moreThanPercent;
    }

    public final String moreThanPercentDesc() {
        if (this.moreThanPercent <= 0) {
            return RoomRecommendViewModel.EMPTY_CURSOR;
        }
        if (this.moreThanPercent >= 100) {
            return "超过100%B站玩家";
        }
        return "超" + this.moreThanPercent + "%B站玩家";
    }

    public final String playtimeForeverHoursDesc() {
        if (this.playtimeForeverHours >= 2.14748364E8d) {
            String des = ((long) this.playtimeForeverHours) + "h";
            return des;
        }
        String des2 = NumberExtKt.keep1Decimal$default(this.playtimeForeverHours, false, 1, (Object) null);
        return des2 + "h";
    }

    public final String playtimeLast2weeksHoursDesc() {
        if (this.playtimeLast2weeksHours >= 2.14748364E8d) {
            String des = ((long) this.playtimeLast2weeksHours) + "h";
            return des;
        }
        String des2 = NumberExtKt.keep1Decimal$default(this.playtimeLast2weeksHours, false, 1, (Object) null);
        return des2 + "h";
    }

    public final boolean fullAchievements() {
        return this.appAchievementsCount > 0 && this.appAchievementsCount == this.ownedAchievementsCount;
    }
}