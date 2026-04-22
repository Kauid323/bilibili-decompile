package kntr.app.game.bean;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.biligame.kntr.common.util.NumberExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamDetailBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fBQ\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u0006\u0010!\u001a\u00020\u0003J\u0006\u0010\"\u001a\u00020\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003JE\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0007HÖ\u0001J\t\u0010.\u001a\u00020\u0003HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u001b¨\u00069"}, d2 = {"Lkntr/app/game/bean/UserSteamInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "userIcon", "steamUserName", "steamUserLevel", RoomRecommendViewModel.EMPTY_CURSOR, "steamCreatedTime", RoomRecommendViewModel.EMPTY_CURSOR, "personState", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSteamId$annotations", "()V", "getSteamId", "()Ljava/lang/String;", "getUserIcon$annotations", "getUserIcon", "getSteamUserName$annotations", "getSteamUserName", "getSteamUserLevel$annotations", "getSteamUserLevel", "()I", "getSteamCreatedTime$annotations", "getSteamCreatedTime", "()J", "getPersonState$annotations", "getPersonState", "createdYears", "personStateDesc", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class UserSteamInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int personState;
    private final long steamCreatedTime;
    private final String steamId;
    private final int steamUserLevel;
    private final String steamUserName;
    private final String userIcon;

    public UserSteamInfo() {
        this((String) null, (String) null, (String) null, 0, 0L, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ UserSteamInfo copy$default(UserSteamInfo userSteamInfo, String str, String str2, String str3, int i, long j2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = userSteamInfo.steamId;
        }
        if ((i3 & 2) != 0) {
            str2 = userSteamInfo.userIcon;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = userSteamInfo.steamUserName;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i = userSteamInfo.steamUserLevel;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            j2 = userSteamInfo.steamCreatedTime;
        }
        long j3 = j2;
        if ((i3 & 32) != 0) {
            i2 = userSteamInfo.personState;
        }
        return userSteamInfo.copy(str, str4, str5, i4, j3, i2);
    }

    @SerialName("person_state")
    public static /* synthetic */ void getPersonState$annotations() {
    }

    @SerialName("steam_created_time")
    public static /* synthetic */ void getSteamCreatedTime$annotations() {
    }

    @SerialName("steam_id")
    public static /* synthetic */ void getSteamId$annotations() {
    }

    @SerialName("steam_user_level")
    public static /* synthetic */ void getSteamUserLevel$annotations() {
    }

    @SerialName("steam_user_name")
    public static /* synthetic */ void getSteamUserName$annotations() {
    }

    @SerialName("user_icon")
    public static /* synthetic */ void getUserIcon$annotations() {
    }

    public final String component1() {
        return this.steamId;
    }

    public final String component2() {
        return this.userIcon;
    }

    public final String component3() {
        return this.steamUserName;
    }

    public final int component4() {
        return this.steamUserLevel;
    }

    public final long component5() {
        return this.steamCreatedTime;
    }

    public final int component6() {
        return this.personState;
    }

    public final UserSteamInfo copy(String str, String str2, String str3, int i, long j2, int i2) {
        Intrinsics.checkNotNullParameter(str, "steamId");
        Intrinsics.checkNotNullParameter(str2, "userIcon");
        Intrinsics.checkNotNullParameter(str3, "steamUserName");
        return new UserSteamInfo(str, str2, str3, i, j2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserSteamInfo) {
            UserSteamInfo userSteamInfo = (UserSteamInfo) obj;
            return Intrinsics.areEqual(this.steamId, userSteamInfo.steamId) && Intrinsics.areEqual(this.userIcon, userSteamInfo.userIcon) && Intrinsics.areEqual(this.steamUserName, userSteamInfo.steamUserName) && this.steamUserLevel == userSteamInfo.steamUserLevel && this.steamCreatedTime == userSteamInfo.steamCreatedTime && this.personState == userSteamInfo.personState;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.steamId.hashCode() * 31) + this.userIcon.hashCode()) * 31) + this.steamUserName.hashCode()) * 31) + this.steamUserLevel) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.steamCreatedTime)) * 31) + this.personState;
    }

    public String toString() {
        String str = this.steamId;
        String str2 = this.userIcon;
        String str3 = this.steamUserName;
        int i = this.steamUserLevel;
        long j2 = this.steamCreatedTime;
        return "UserSteamInfo(steamId=" + str + ", userIcon=" + str2 + ", steamUserName=" + str3 + ", steamUserLevel=" + i + ", steamCreatedTime=" + j2 + ", personState=" + this.personState + ")";
    }

    /* compiled from: SteamDetailBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/UserSteamInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/UserSteamInfo;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserSteamInfo> serializer() {
            return UserSteamInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ UserSteamInfo(int seen0, String steamId, String userIcon, String steamUserName, int steamUserLevel, long steamCreatedTime, int personState, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.steamId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.steamId = steamId;
        }
        if ((seen0 & 2) == 0) {
            this.userIcon = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.userIcon = userIcon;
        }
        if ((seen0 & 4) == 0) {
            this.steamUserName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.steamUserName = steamUserName;
        }
        if ((seen0 & 8) == 0) {
            this.steamUserLevel = 0;
        } else {
            this.steamUserLevel = steamUserLevel;
        }
        if ((seen0 & 16) == 0) {
            this.steamCreatedTime = 0L;
        } else {
            this.steamCreatedTime = steamCreatedTime;
        }
        if ((seen0 & 32) == 0) {
            this.personState = 0;
        } else {
            this.personState = personState;
        }
    }

    public UserSteamInfo(String steamId, String userIcon, String steamUserName, int steamUserLevel, long steamCreatedTime, int personState) {
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(userIcon, "userIcon");
        Intrinsics.checkNotNullParameter(steamUserName, "steamUserName");
        this.steamId = steamId;
        this.userIcon = userIcon;
        this.steamUserName = steamUserName;
        this.steamUserLevel = steamUserLevel;
        this.steamCreatedTime = steamCreatedTime;
        this.personState = personState;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(UserSteamInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.steamId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.steamId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.userIcon, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.userIcon);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.steamUserName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.steamUserName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.steamUserLevel != 0) {
            output.encodeIntElement(serialDesc, 3, self.steamUserLevel);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.steamCreatedTime != 0) {
            output.encodeLongElement(serialDesc, 4, self.steamCreatedTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.personState != 0) {
            output.encodeIntElement(serialDesc, 5, self.personState);
        }
    }

    public /* synthetic */ UserSteamInfo(String str, String str2, String str3, int i, long j2, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i3 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i3 & 4) == 0 ? str3 : RoomRecommendViewModel.EMPTY_CURSOR, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0L : j2, (i3 & 32) != 0 ? 0 : i2);
    }

    public final String getSteamId() {
        return this.steamId;
    }

    public final String getUserIcon() {
        return this.userIcon;
    }

    public final String getSteamUserName() {
        return this.steamUserName;
    }

    public final int getSteamUserLevel() {
        return this.steamUserLevel;
    }

    public final long getSteamCreatedTime() {
        return this.steamCreatedTime;
    }

    public final int getPersonState() {
        return this.personState;
    }

    public final String createdYears() {
        if (this.steamCreatedTime <= 0) {
            return RoomRecommendViewModel.EMPTY_CURSOR;
        }
        double years = ((Clock.System.INSTANCE.now().toEpochMilliseconds() / 1000) - this.steamCreatedTime) / 3.15576E7d;
        return years < 0.1d ? "<0.1" : NumberExtKt.keep1DecimalRound$default(years, false, 1, (Object) null);
    }

    public final String personStateDesc() {
        switch (this.personState) {
            case 0:
            default:
                return "离线";
            case 1:
                return "在线";
            case 2:
                return "忙碌";
            case 3:
                return "离开";
            case 4:
                return "休眠";
            case 5:
                return "寻求交易";
            case 6:
                return "寻求游戏";
        }
    }
}