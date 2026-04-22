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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d¨\u00063"}, d2 = {"Lkntr/app/game/bean/SteamPlayerInfo;", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "personName", "avatar", "timeCreated", RoomRecommendViewModel.EMPTY_CURSOR, "steamLevel", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSteamId$annotations", "()V", "getSteamId", "()Ljava/lang/String;", "getPersonName$annotations", "getPersonName", "getAvatar$annotations", "getAvatar", "getTimeCreated$annotations", "getTimeCreated", "()J", "getSteamLevel$annotations", "getSteamLevel", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class SteamPlayerInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String avatar;
    private final String personName;
    private final String steamId;
    private final int steamLevel;
    private final long timeCreated;

    public SteamPlayerInfo() {
        this((String) null, (String) null, (String) null, 0L, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SteamPlayerInfo copy$default(SteamPlayerInfo steamPlayerInfo, String str, String str2, String str3, long j2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = steamPlayerInfo.steamId;
        }
        if ((i2 & 2) != 0) {
            str2 = steamPlayerInfo.personName;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = steamPlayerInfo.avatar;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            j2 = steamPlayerInfo.timeCreated;
        }
        long j3 = j2;
        if ((i2 & 16) != 0) {
            i = steamPlayerInfo.steamLevel;
        }
        return steamPlayerInfo.copy(str, str4, str5, j3, i);
    }

    @SerialName("avatar")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    @SerialName("person_name")
    public static /* synthetic */ void getPersonName$annotations() {
    }

    @SerialName("steam_id")
    public static /* synthetic */ void getSteamId$annotations() {
    }

    @SerialName("steam_level")
    public static /* synthetic */ void getSteamLevel$annotations() {
    }

    @SerialName("time_created")
    public static /* synthetic */ void getTimeCreated$annotations() {
    }

    public final String component1() {
        return this.steamId;
    }

    public final String component2() {
        return this.personName;
    }

    public final String component3() {
        return this.avatar;
    }

    public final long component4() {
        return this.timeCreated;
    }

    public final int component5() {
        return this.steamLevel;
    }

    public final SteamPlayerInfo copy(String str, String str2, String str3, long j2, int i) {
        Intrinsics.checkNotNullParameter(str, "steamId");
        Intrinsics.checkNotNullParameter(str2, "personName");
        Intrinsics.checkNotNullParameter(str3, "avatar");
        return new SteamPlayerInfo(str, str2, str3, j2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SteamPlayerInfo) {
            SteamPlayerInfo steamPlayerInfo = (SteamPlayerInfo) obj;
            return Intrinsics.areEqual(this.steamId, steamPlayerInfo.steamId) && Intrinsics.areEqual(this.personName, steamPlayerInfo.personName) && Intrinsics.areEqual(this.avatar, steamPlayerInfo.avatar) && this.timeCreated == steamPlayerInfo.timeCreated && this.steamLevel == steamPlayerInfo.steamLevel;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.steamId.hashCode() * 31) + this.personName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeCreated)) * 31) + this.steamLevel;
    }

    public String toString() {
        String str = this.steamId;
        String str2 = this.personName;
        String str3 = this.avatar;
        long j2 = this.timeCreated;
        return "SteamPlayerInfo(steamId=" + str + ", personName=" + str2 + ", avatar=" + str3 + ", timeCreated=" + j2 + ", steamLevel=" + this.steamLevel + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/SteamPlayerInfo$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/SteamPlayerInfo;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SteamPlayerInfo> serializer() {
            return SteamPlayerInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ SteamPlayerInfo(int seen0, String steamId, String personName, String avatar, long timeCreated, int steamLevel, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.steamId = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.steamId = steamId;
        }
        if ((seen0 & 2) == 0) {
            this.personName = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.personName = personName;
        }
        if ((seen0 & 4) == 0) {
            this.avatar = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.avatar = avatar;
        }
        if ((seen0 & 8) == 0) {
            this.timeCreated = 0L;
        } else {
            this.timeCreated = timeCreated;
        }
        if ((seen0 & 16) == 0) {
            this.steamLevel = 0;
        } else {
            this.steamLevel = steamLevel;
        }
    }

    public SteamPlayerInfo(String steamId, String personName, String avatar, long timeCreated, int steamLevel) {
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        this.steamId = steamId;
        this.personName = personName;
        this.avatar = avatar;
        this.timeCreated = timeCreated;
        this.steamLevel = steamLevel;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(SteamPlayerInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.steamId, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 0, self.steamId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.personName, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.personName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.avatar, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 2, self.avatar);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.timeCreated != 0) {
            output.encodeLongElement(serialDesc, 3, self.timeCreated);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.steamLevel != 0) {
            output.encodeIntElement(serialDesc, 4, self.steamLevel);
        }
    }

    public /* synthetic */ SteamPlayerInfo(String str, String str2, String str3, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2, (i2 & 4) == 0 ? str3 : RoomRecommendViewModel.EMPTY_CURSOR, (i2 & 8) != 0 ? 0L : j2, (i2 & 16) != 0 ? 0 : i);
    }

    public final String getSteamId() {
        return this.steamId;
    }

    public final String getPersonName() {
        return this.personName;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final long getTimeCreated() {
        return this.timeCreated;
    }

    public final int getSteamLevel() {
        return this.steamLevel;
    }
}