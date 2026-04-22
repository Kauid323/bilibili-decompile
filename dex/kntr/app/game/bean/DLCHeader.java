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

/* compiled from: SteamGameDLCBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019¨\u0006."}, d2 = {"Lkntr/app/game/bean/DLCHeader;", RoomRecommendViewModel.EMPTY_CURSOR, "gameName", RoomRecommendViewModel.EMPTY_CURSOR, "gameIconUrl", "appIconRgb", "dlcStats", "Lkntr/app/game/bean/DLCStats;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/game/bean/DLCStats;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/app/game/bean/DLCStats;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getGameName$annotations", "()V", "getGameName", "()Ljava/lang/String;", "getGameIconUrl$annotations", "getGameIconUrl", "getAppIconRgb$annotations", "getAppIconRgb", "getDlcStats$annotations", "getDlcStats", "()Lkntr/app/game/bean/DLCStats;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class DLCHeader {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String appIconRgb;
    private final DLCStats dlcStats;
    private final String gameIconUrl;
    private final String gameName;

    public DLCHeader() {
        this((String) null, (String) null, (String) null, (DLCStats) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DLCHeader copy$default(DLCHeader dLCHeader, String str, String str2, String str3, DLCStats dLCStats, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dLCHeader.gameName;
        }
        if ((i & 2) != 0) {
            str2 = dLCHeader.gameIconUrl;
        }
        if ((i & 4) != 0) {
            str3 = dLCHeader.appIconRgb;
        }
        if ((i & 8) != 0) {
            dLCStats = dLCHeader.dlcStats;
        }
        return dLCHeader.copy(str, str2, str3, dLCStats);
    }

    @SerialName("app_icon_rgb")
    public static /* synthetic */ void getAppIconRgb$annotations() {
    }

    @SerialName("dlc_stats")
    public static /* synthetic */ void getDlcStats$annotations() {
    }

    @SerialName("game_icon_url")
    public static /* synthetic */ void getGameIconUrl$annotations() {
    }

    @SerialName("game_name")
    public static /* synthetic */ void getGameName$annotations() {
    }

    public final String component1() {
        return this.gameName;
    }

    public final String component2() {
        return this.gameIconUrl;
    }

    public final String component3() {
        return this.appIconRgb;
    }

    public final DLCStats component4() {
        return this.dlcStats;
    }

    public final DLCHeader copy(String str, String str2, String str3, DLCStats dLCStats) {
        Intrinsics.checkNotNullParameter(str, "gameName");
        Intrinsics.checkNotNullParameter(str2, "gameIconUrl");
        Intrinsics.checkNotNullParameter(str3, "appIconRgb");
        return new DLCHeader(str, str2, str3, dLCStats);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DLCHeader) {
            DLCHeader dLCHeader = (DLCHeader) obj;
            return Intrinsics.areEqual(this.gameName, dLCHeader.gameName) && Intrinsics.areEqual(this.gameIconUrl, dLCHeader.gameIconUrl) && Intrinsics.areEqual(this.appIconRgb, dLCHeader.appIconRgb) && Intrinsics.areEqual(this.dlcStats, dLCHeader.dlcStats);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.gameName.hashCode() * 31) + this.gameIconUrl.hashCode()) * 31) + this.appIconRgb.hashCode()) * 31) + (this.dlcStats == null ? 0 : this.dlcStats.hashCode());
    }

    public String toString() {
        String str = this.gameName;
        String str2 = this.gameIconUrl;
        String str3 = this.appIconRgb;
        return "DLCHeader(gameName=" + str + ", gameIconUrl=" + str2 + ", appIconRgb=" + str3 + ", dlcStats=" + this.dlcStats + ")";
    }

    /* compiled from: SteamGameDLCBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/DLCHeader$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/DLCHeader;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DLCHeader> serializer() {
            return DLCHeader$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DLCHeader(int seen0, String gameName, String gameIconUrl, String appIconRgb, DLCStats dlcStats, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.gameName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameName = gameName;
        }
        if ((seen0 & 2) == 0) {
            this.gameIconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.gameIconUrl = gameIconUrl;
        }
        if ((seen0 & 4) == 0) {
            this.appIconRgb = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.appIconRgb = appIconRgb;
        }
        if ((seen0 & 8) == 0) {
            this.dlcStats = null;
        } else {
            this.dlcStats = dlcStats;
        }
    }

    public DLCHeader(String gameName, String gameIconUrl, String appIconRgb, DLCStats dlcStats) {
        Intrinsics.checkNotNullParameter(gameName, "gameName");
        Intrinsics.checkNotNullParameter(gameIconUrl, "gameIconUrl");
        Intrinsics.checkNotNullParameter(appIconRgb, "appIconRgb");
        this.gameName = gameName;
        this.gameIconUrl = gameIconUrl;
        this.appIconRgb = appIconRgb;
        this.dlcStats = dlcStats;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(DLCHeader self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.gameName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.gameName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.gameIconUrl, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.gameIconUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.appIconRgb, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.appIconRgb);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.dlcStats != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DLCStats$$serializer.INSTANCE, self.dlcStats);
        }
    }

    public /* synthetic */ DLCHeader(String str, String str2, String str3, DLCStats dLCStats, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i & 4) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str3, (i & 8) != 0 ? null : dLCStats);
    }

    public final String getGameName() {
        return this.gameName;
    }

    public final String getGameIconUrl() {
        return this.gameIconUrl;
    }

    public final String getAppIconRgb() {
        return this.appIconRgb;
    }

    public final DLCStats getDlcStats() {
        return this.dlcStats;
    }
}