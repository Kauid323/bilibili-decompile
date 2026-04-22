package kntr.app.live.room.lolracerscore;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LiveLPLPlayers.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u000bHÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0015R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0015¨\u0006."}, d2 = {"Lkntr/app/live/room/lolracerscore/LPLPlayer;", RoomRecommendViewModel.EMPTY_CURSOR, "playerId", RoomRecommendViewModel.EMPTY_CURSOR, "photo", RoomRecommendViewModel.EMPTY_CURSOR, "playerLocation", "playerNickname", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlayerId$annotations", "()V", "getPlayerId", "()J", "getPhoto$annotations", "getPhoto", "()Ljava/lang/String;", "getPlayerLocation$annotations", "getPlayerLocation", "getPlayerNickname$annotations", "getPlayerNickname", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lolracerscore_debug", "$serializer", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class LPLPlayer {
    public static final Companion Companion = new Companion(null);
    private final String photo;
    private final long playerId;
    private final String playerLocation;
    private final String playerNickname;

    public static /* synthetic */ LPLPlayer copy$default(LPLPlayer lPLPlayer, long j2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = lPLPlayer.playerId;
        }
        long j3 = j2;
        if ((i & 2) != 0) {
            str = lPLPlayer.photo;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = lPLPlayer.playerLocation;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = lPLPlayer.playerNickname;
        }
        return lPLPlayer.copy(j3, str4, str5, str3);
    }

    @SerialName("photo")
    public static /* synthetic */ void getPhoto$annotations() {
    }

    @SerialName("player_id")
    public static /* synthetic */ void getPlayerId$annotations() {
    }

    @SerialName("player_location")
    public static /* synthetic */ void getPlayerLocation$annotations() {
    }

    @SerialName("player_nickname")
    public static /* synthetic */ void getPlayerNickname$annotations() {
    }

    public final long component1() {
        return this.playerId;
    }

    public final String component2() {
        return this.photo;
    }

    public final String component3() {
        return this.playerLocation;
    }

    public final String component4() {
        return this.playerNickname;
    }

    public final LPLPlayer copy(long j2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "photo");
        return new LPLPlayer(j2, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LPLPlayer) {
            LPLPlayer lPLPlayer = (LPLPlayer) obj;
            return this.playerId == lPLPlayer.playerId && Intrinsics.areEqual(this.photo, lPLPlayer.photo) && Intrinsics.areEqual(this.playerLocation, lPLPlayer.playerLocation) && Intrinsics.areEqual(this.playerNickname, lPLPlayer.playerNickname);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.playerId) * 31) + this.photo.hashCode()) * 31) + (this.playerLocation == null ? 0 : this.playerLocation.hashCode())) * 31) + (this.playerNickname != null ? this.playerNickname.hashCode() : 0);
    }

    public String toString() {
        long j2 = this.playerId;
        String str = this.photo;
        String str2 = this.playerLocation;
        return "LPLPlayer(playerId=" + j2 + ", photo=" + str + ", playerLocation=" + str2 + ", playerNickname=" + this.playerNickname + ")";
    }

    /* compiled from: LiveLPLPlayers.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/LPLPlayer$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/live/room/lolracerscore/LPLPlayer;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LPLPlayer> serializer() {
            return LPLPlayer$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ LPLPlayer(int seen0, long playerId, String photo, String playerLocation, String playerNickname, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, LPLPlayer$$serializer.INSTANCE.getDescriptor());
        }
        this.playerId = playerId;
        this.photo = photo;
        if ((seen0 & 4) == 0) {
            this.playerLocation = null;
        } else {
            this.playerLocation = playerLocation;
        }
        if ((seen0 & 8) == 0) {
            this.playerNickname = null;
        } else {
            this.playerNickname = playerNickname;
        }
    }

    public LPLPlayer(long playerId, String photo, String playerLocation, String playerNickname) {
        Intrinsics.checkNotNullParameter(photo, "photo");
        this.playerId = playerId;
        this.photo = photo;
        this.playerLocation = playerLocation;
        this.playerNickname = playerNickname;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$lolracerscore_debug(LPLPlayer self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.playerId);
        output.encodeStringElement(serialDesc, 1, self.photo);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.playerLocation != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.playerLocation);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.playerNickname != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.playerNickname);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LPLPlayer(long j2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, str, r5, r6);
        String str4;
        String str5;
        if ((i & 4) == 0) {
            str4 = str2;
        } else {
            str4 = null;
        }
        if ((i & 8) == 0) {
            str5 = str3;
        } else {
            str5 = null;
        }
    }

    public final long getPlayerId() {
        return this.playerId;
    }

    public final String getPhoto() {
        return this.photo;
    }

    public final String getPlayerLocation() {
        return this.playerLocation;
    }

    public final String getPlayerNickname() {
        return this.playerNickname;
    }
}