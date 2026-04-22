package kntr.app.game.bean;

import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fBk\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u000eHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J%\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H\u0001¢\u0006\u0002\b9R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0015R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015¨\u0006<"}, d2 = {"Lkntr/app/game/bean/StatisticOverview;", RoomRecommendViewModel.EMPTY_CURSOR, "totalPrice", RoomRecommendViewModel.EMPTY_CURSOR, "totalPriceText", "gamesCount", "gamesCountText", "playHourAll", "playHourAllText", "playHourLast2weeksAll", "playHourLast2weeksAllText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTotalPrice$annotations", "()V", "getTotalPrice", "()Ljava/lang/String;", "getTotalPriceText$annotations", "getTotalPriceText", "getGamesCount$annotations", "getGamesCount", "getGamesCountText$annotations", "getGamesCountText", "getPlayHourAll$annotations", "getPlayHourAll", "getPlayHourAllText$annotations", "getPlayHourAllText", "getPlayHourLast2weeksAll$annotations", "getPlayHourLast2weeksAll", "getPlayHourLast2weeksAllText$annotations", "getPlayHourLast2weeksAllText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class StatisticOverview {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String gamesCount;
    private final String gamesCountText;
    private final String playHourAll;
    private final String playHourAllText;
    private final String playHourLast2weeksAll;
    private final String playHourLast2weeksAllText;
    private final String totalPrice;
    private final String totalPriceText;

    public StatisticOverview() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 255, (DefaultConstructorMarker) null);
    }

    @SerialName("games_count")
    public static /* synthetic */ void getGamesCount$annotations() {
    }

    @SerialName("games_count_text")
    public static /* synthetic */ void getGamesCountText$annotations() {
    }

    @SerialName("play_hour_all")
    public static /* synthetic */ void getPlayHourAll$annotations() {
    }

    @SerialName("play_hour_all_text")
    public static /* synthetic */ void getPlayHourAllText$annotations() {
    }

    @SerialName("play_hour_last2weeks_all")
    public static /* synthetic */ void getPlayHourLast2weeksAll$annotations() {
    }

    @SerialName("play_hour_last2weeks_all_text")
    public static /* synthetic */ void getPlayHourLast2weeksAllText$annotations() {
    }

    @SerialName("total_price")
    public static /* synthetic */ void getTotalPrice$annotations() {
    }

    @SerialName("total_price_text")
    public static /* synthetic */ void getTotalPriceText$annotations() {
    }

    public final String component1() {
        return this.totalPrice;
    }

    public final String component2() {
        return this.totalPriceText;
    }

    public final String component3() {
        return this.gamesCount;
    }

    public final String component4() {
        return this.gamesCountText;
    }

    public final String component5() {
        return this.playHourAll;
    }

    public final String component6() {
        return this.playHourAllText;
    }

    public final String component7() {
        return this.playHourLast2weeksAll;
    }

    public final String component8() {
        return this.playHourLast2weeksAllText;
    }

    public final StatisticOverview copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "totalPrice");
        Intrinsics.checkNotNullParameter(str2, "totalPriceText");
        Intrinsics.checkNotNullParameter(str3, "gamesCount");
        Intrinsics.checkNotNullParameter(str4, "gamesCountText");
        Intrinsics.checkNotNullParameter(str5, "playHourAll");
        Intrinsics.checkNotNullParameter(str6, "playHourAllText");
        Intrinsics.checkNotNullParameter(str7, "playHourLast2weeksAll");
        Intrinsics.checkNotNullParameter(str8, "playHourLast2weeksAllText");
        return new StatisticOverview(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StatisticOverview) {
            StatisticOverview statisticOverview = (StatisticOverview) obj;
            return Intrinsics.areEqual(this.totalPrice, statisticOverview.totalPrice) && Intrinsics.areEqual(this.totalPriceText, statisticOverview.totalPriceText) && Intrinsics.areEqual(this.gamesCount, statisticOverview.gamesCount) && Intrinsics.areEqual(this.gamesCountText, statisticOverview.gamesCountText) && Intrinsics.areEqual(this.playHourAll, statisticOverview.playHourAll) && Intrinsics.areEqual(this.playHourAllText, statisticOverview.playHourAllText) && Intrinsics.areEqual(this.playHourLast2weeksAll, statisticOverview.playHourLast2weeksAll) && Intrinsics.areEqual(this.playHourLast2weeksAllText, statisticOverview.playHourLast2weeksAllText);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.totalPrice.hashCode() * 31) + this.totalPriceText.hashCode()) * 31) + this.gamesCount.hashCode()) * 31) + this.gamesCountText.hashCode()) * 31) + this.playHourAll.hashCode()) * 31) + this.playHourAllText.hashCode()) * 31) + this.playHourLast2weeksAll.hashCode()) * 31) + this.playHourLast2weeksAllText.hashCode();
    }

    public String toString() {
        String str = this.totalPrice;
        String str2 = this.totalPriceText;
        String str3 = this.gamesCount;
        String str4 = this.gamesCountText;
        String str5 = this.playHourAll;
        String str6 = this.playHourAllText;
        String str7 = this.playHourLast2weeksAll;
        return "StatisticOverview(totalPrice=" + str + ", totalPriceText=" + str2 + ", gamesCount=" + str3 + ", gamesCountText=" + str4 + ", playHourAll=" + str5 + ", playHourAllText=" + str6 + ", playHourLast2weeksAll=" + str7 + ", playHourLast2weeksAllText=" + this.playHourLast2weeksAllText + ")";
    }

    /* compiled from: SteamDetailBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/StatisticOverview$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/StatisticOverview;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatisticOverview> serializer() {
            return StatisticOverview$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StatisticOverview(int seen0, String totalPrice, String totalPriceText, String gamesCount, String gamesCountText, String playHourAll, String playHourAllText, String playHourLast2weeksAll, String playHourLast2weeksAllText, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.totalPrice = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.totalPrice = totalPrice;
        }
        if ((seen0 & 2) == 0) {
            this.totalPriceText = "账号价值¥";
        } else {
            this.totalPriceText = totalPriceText;
        }
        if ((seen0 & 4) == 0) {
            this.gamesCount = AdSearchSubCardType.CARD_TYPE_NONE;
        } else {
            this.gamesCount = gamesCount;
        }
        if ((seen0 & 8) == 0) {
            this.gamesCountText = "游戏数量";
        } else {
            this.gamesCountText = gamesCountText;
        }
        if ((seen0 & 16) == 0) {
            this.playHourAll = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playHourAll = playHourAll;
        }
        if ((seen0 & 32) == 0) {
            this.playHourAllText = "游戏时长h";
        } else {
            this.playHourAllText = playHourAllText;
        }
        if ((seen0 & 64) == 0) {
            this.playHourLast2weeksAll = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playHourLast2weeksAll = playHourLast2weeksAll;
        }
        if ((seen0 & 128) == 0) {
            this.playHourLast2weeksAllText = "近两周时长h";
        } else {
            this.playHourLast2weeksAllText = playHourLast2weeksAllText;
        }
    }

    public StatisticOverview(String totalPrice, String totalPriceText, String gamesCount, String gamesCountText, String playHourAll, String playHourAllText, String playHourLast2weeksAll, String playHourLast2weeksAllText) {
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Intrinsics.checkNotNullParameter(totalPriceText, "totalPriceText");
        Intrinsics.checkNotNullParameter(gamesCount, "gamesCount");
        Intrinsics.checkNotNullParameter(gamesCountText, "gamesCountText");
        Intrinsics.checkNotNullParameter(playHourAll, "playHourAll");
        Intrinsics.checkNotNullParameter(playHourAllText, "playHourAllText");
        Intrinsics.checkNotNullParameter(playHourLast2weeksAll, "playHourLast2weeksAll");
        Intrinsics.checkNotNullParameter(playHourLast2weeksAllText, "playHourLast2weeksAllText");
        this.totalPrice = totalPrice;
        this.totalPriceText = totalPriceText;
        this.gamesCount = gamesCount;
        this.gamesCountText = gamesCountText;
        this.playHourAll = playHourAll;
        this.playHourAllText = playHourAllText;
        this.playHourLast2weeksAll = playHourLast2weeksAll;
        this.playHourLast2weeksAllText = playHourLast2weeksAllText;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(StatisticOverview self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.totalPrice, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.totalPrice);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.totalPriceText, "账号价值¥")) {
            output.encodeStringElement(serialDesc, 1, self.totalPriceText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.gamesCount, AdSearchSubCardType.CARD_TYPE_NONE)) {
            output.encodeStringElement(serialDesc, 2, self.gamesCount);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.gamesCountText, "游戏数量")) {
            output.encodeStringElement(serialDesc, 3, self.gamesCountText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.playHourAll, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 4, self.playHourAll);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.playHourAllText, "游戏时长h")) {
            output.encodeStringElement(serialDesc, 5, self.playHourAllText);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.playHourLast2weeksAll, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 6, self.playHourLast2weeksAll);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.playHourLast2weeksAllText, "近两周时长h")) {
            output.encodeStringElement(serialDesc, 7, self.playHourLast2weeksAllText);
        }
    }

    public /* synthetic */ StatisticOverview(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? "账号价值¥" : str2, (i & 4) != 0 ? AdSearchSubCardType.CARD_TYPE_NONE : str3, (i & 8) != 0 ? "游戏数量" : str4, (i & 16) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str5, (i & 32) != 0 ? "游戏时长h" : str6, (i & 64) == 0 ? str7 : RoomRecommendViewModel.EMPTY_CURSOR, (i & 128) != 0 ? "近两周时长h" : str8);
    }

    public final String getTotalPrice() {
        return this.totalPrice;
    }

    public final String getTotalPriceText() {
        return this.totalPriceText;
    }

    public final String getGamesCount() {
        return this.gamesCount;
    }

    public final String getGamesCountText() {
        return this.gamesCountText;
    }

    public final String getPlayHourAll() {
        return this.playHourAll;
    }

    public final String getPlayHourAllText() {
        return this.playHourAllText;
    }

    public final String getPlayHourLast2weeksAll() {
        return this.playHourLast2weeksAll;
    }

    public final String getPlayHourLast2weeksAllText() {
        return this.playHourLast2weeksAllText;
    }
}