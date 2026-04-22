package kntr.app.live.room.lolracerscore;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LiveLPLPlayers.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u0002/0B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bBE\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J9\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u0006HÖ\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lkntr/app/live/room/lolracerscore/PlayersTeam;", RoomRecommendViewModel.EMPTY_CURSOR, "teamId", RoomRecommendViewModel.EMPTY_CURSOR, "placeId", "teamName", RoomRecommendViewModel.EMPTY_CURSOR, "players", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/live/room/lolracerscore/LPLPlayer;", "<init>", "(JJLjava/lang/String;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTeamId$annotations", "()V", "getTeamId", "()J", "getPlaceId$annotations", "getPlaceId", "getTeamName$annotations", "getTeamName", "()Ljava/lang/String;", "getPlayers$annotations", "getPlayers", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lolracerscore_debug", "$serializer", "Companion", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PlayersTeam {
    private final long placeId;
    private final List<LPLPlayer> players;
    private final long teamId;
    private final String teamName;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.live.room.lolracerscore.PlayersTeam$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = PlayersTeam._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ PlayersTeam copy$default(PlayersTeam playersTeam, long j2, long j3, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = playersTeam.teamId;
        }
        long j4 = j2;
        if ((i & 2) != 0) {
            j3 = playersTeam.placeId;
        }
        long j5 = j3;
        if ((i & 4) != 0) {
            str = playersTeam.teamName;
        }
        String str2 = str;
        List<LPLPlayer> list2 = list;
        if ((i & 8) != 0) {
            list2 = playersTeam.players;
        }
        return playersTeam.copy(j4, j5, str2, list2);
    }

    @SerialName("place_id")
    public static /* synthetic */ void getPlaceId$annotations() {
    }

    @SerialName("players")
    public static /* synthetic */ void getPlayers$annotations() {
    }

    @SerialName("team_id")
    public static /* synthetic */ void getTeamId$annotations() {
    }

    @SerialName("team_name")
    public static /* synthetic */ void getTeamName$annotations() {
    }

    public final long component1() {
        return this.teamId;
    }

    public final long component2() {
        return this.placeId;
    }

    public final String component3() {
        return this.teamName;
    }

    public final List<LPLPlayer> component4() {
        return this.players;
    }

    public final PlayersTeam copy(long j2, long j3, String str, List<LPLPlayer> list) {
        Intrinsics.checkNotNullParameter(str, "teamName");
        return new PlayersTeam(j2, j3, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayersTeam) {
            PlayersTeam playersTeam = (PlayersTeam) obj;
            return this.teamId == playersTeam.teamId && this.placeId == playersTeam.placeId && Intrinsics.areEqual(this.teamName, playersTeam.teamName) && Intrinsics.areEqual(this.players, playersTeam.players);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.teamId) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.placeId)) * 31) + this.teamName.hashCode()) * 31) + (this.players == null ? 0 : this.players.hashCode());
    }

    public String toString() {
        long j2 = this.teamId;
        long j3 = this.placeId;
        String str = this.teamName;
        return "PlayersTeam(teamId=" + j2 + ", placeId=" + j3 + ", teamName=" + str + ", players=" + this.players + ")";
    }

    /* compiled from: LiveLPLPlayers.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/live/room/lolracerscore/PlayersTeam$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/live/room/lolracerscore/PlayersTeam;", "lolracerscore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayersTeam> serializer() {
            return PlayersTeam$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayersTeam(int seen0, long teamId, long placeId, String teamName, List players, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, PlayersTeam$$serializer.INSTANCE.getDescriptor());
        }
        this.teamId = teamId;
        this.placeId = placeId;
        this.teamName = teamName;
        if ((seen0 & 8) == 0) {
            this.players = null;
        } else {
            this.players = players;
        }
    }

    public PlayersTeam(long teamId, long placeId, String teamName, List<LPLPlayer> list) {
        Intrinsics.checkNotNullParameter(teamName, "teamName");
        this.teamId = teamId;
        this.placeId = placeId;
        this.teamName = teamName;
        this.players = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(LPLPlayer$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$lolracerscore_debug(PlayersTeam self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeLongElement(serialDesc, 0, self.teamId);
        output.encodeLongElement(serialDesc, 1, self.placeId);
        output.encodeStringElement(serialDesc, 2, self.teamName);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.players != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.players);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlayersTeam(long j2, long j3, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3, str, r6);
        List list2;
        if ((i & 8) == 0) {
            list2 = list;
        } else {
            list2 = null;
        }
    }

    public final long getTeamId() {
        return this.teamId;
    }

    public final long getPlaceId() {
        return this.placeId;
    }

    public final String getTeamName() {
        return this.teamName;
    }

    public final List<LPLPlayer> getPlayers() {
        return this.players;
    }
}