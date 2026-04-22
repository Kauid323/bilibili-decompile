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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003JN\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001f\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0017¨\u00069"}, d2 = {"Lkntr/app/game/bean/PlayData;", RoomRecommendViewModel.EMPTY_CURSOR, "playtimeForever", RoomRecommendViewModel.EMPTY_CURSOR, "playtimeForeverFormatted", RoomRecommendViewModel.EMPTY_CURSOR, "playtimeLast2weeks", "playtimeLast2weeksFormatted", "rtimeLastPlayed", RoomRecommendViewModel.EMPTY_CURSOR, "rtimeLastPlayedFormatted", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlaytimeForever$annotations", "()V", "getPlaytimeForever", "()I", "getPlaytimeForeverFormatted$annotations", "getPlaytimeForeverFormatted", "()Ljava/lang/String;", "getPlaytimeLast2weeks$annotations", "getPlaytimeLast2weeks", "getPlaytimeLast2weeksFormatted$annotations", "getPlaytimeLast2weeksFormatted", "getRtimeLastPlayed$annotations", "getRtimeLastPlayed", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRtimeLastPlayedFormatted$annotations", "getRtimeLastPlayedFormatted", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lkntr/app/game/bean/PlayData;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$gamebiz_debug", "$serializer", "Companion", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PlayData {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int playtimeForever;
    private final String playtimeForeverFormatted;
    private final int playtimeLast2weeks;
    private final String playtimeLast2weeksFormatted;
    private final Long rtimeLastPlayed;
    private final String rtimeLastPlayedFormatted;

    public PlayData() {
        this(0, (String) null, 0, (String) null, (Long) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PlayData copy$default(PlayData playData, int i, String str, int i2, String str2, Long l, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = playData.playtimeForever;
        }
        if ((i3 & 2) != 0) {
            str = playData.playtimeForeverFormatted;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            i2 = playData.playtimeLast2weeks;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            str2 = playData.playtimeLast2weeksFormatted;
        }
        String str5 = str2;
        if ((i3 & 16) != 0) {
            l = playData.rtimeLastPlayed;
        }
        Long l2 = l;
        if ((i3 & 32) != 0) {
            str3 = playData.rtimeLastPlayedFormatted;
        }
        return playData.copy(i, str4, i4, str5, l2, str3);
    }

    @SerialName("playtime_forever")
    public static /* synthetic */ void getPlaytimeForever$annotations() {
    }

    @SerialName("playtime_forever_formatted")
    public static /* synthetic */ void getPlaytimeForeverFormatted$annotations() {
    }

    @SerialName("playtime_last2weeks")
    public static /* synthetic */ void getPlaytimeLast2weeks$annotations() {
    }

    @SerialName("playtime_last2weeks_formatted")
    public static /* synthetic */ void getPlaytimeLast2weeksFormatted$annotations() {
    }

    @SerialName("rtime_last_played")
    public static /* synthetic */ void getRtimeLastPlayed$annotations() {
    }

    @SerialName("rtime_last_played_formatted")
    public static /* synthetic */ void getRtimeLastPlayedFormatted$annotations() {
    }

    public final int component1() {
        return this.playtimeForever;
    }

    public final String component2() {
        return this.playtimeForeverFormatted;
    }

    public final int component3() {
        return this.playtimeLast2weeks;
    }

    public final String component4() {
        return this.playtimeLast2weeksFormatted;
    }

    public final Long component5() {
        return this.rtimeLastPlayed;
    }

    public final String component6() {
        return this.rtimeLastPlayedFormatted;
    }

    public final PlayData copy(int i, String str, int i2, String str2, Long l, String str3) {
        Intrinsics.checkNotNullParameter(str, "playtimeForeverFormatted");
        Intrinsics.checkNotNullParameter(str2, "playtimeLast2weeksFormatted");
        return new PlayData(i, str, i2, str2, l, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayData) {
            PlayData playData = (PlayData) obj;
            return this.playtimeForever == playData.playtimeForever && Intrinsics.areEqual(this.playtimeForeverFormatted, playData.playtimeForeverFormatted) && this.playtimeLast2weeks == playData.playtimeLast2weeks && Intrinsics.areEqual(this.playtimeLast2weeksFormatted, playData.playtimeLast2weeksFormatted) && Intrinsics.areEqual(this.rtimeLastPlayed, playData.rtimeLastPlayed) && Intrinsics.areEqual(this.rtimeLastPlayedFormatted, playData.rtimeLastPlayedFormatted);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.playtimeForever * 31) + this.playtimeForeverFormatted.hashCode()) * 31) + this.playtimeLast2weeks) * 31) + this.playtimeLast2weeksFormatted.hashCode()) * 31) + (this.rtimeLastPlayed == null ? 0 : this.rtimeLastPlayed.hashCode())) * 31) + (this.rtimeLastPlayedFormatted != null ? this.rtimeLastPlayedFormatted.hashCode() : 0);
    }

    public String toString() {
        int i = this.playtimeForever;
        String str = this.playtimeForeverFormatted;
        int i2 = this.playtimeLast2weeks;
        String str2 = this.playtimeLast2weeksFormatted;
        Long l = this.rtimeLastPlayed;
        return "PlayData(playtimeForever=" + i + ", playtimeForeverFormatted=" + str + ", playtimeLast2weeks=" + i2 + ", playtimeLast2weeksFormatted=" + str2 + ", rtimeLastPlayed=" + l + ", rtimeLastPlayedFormatted=" + this.rtimeLastPlayedFormatted + ")";
    }

    /* compiled from: SteamGameBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/game/bean/PlayData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/game/bean/PlayData;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayData> serializer() {
            return PlayData$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayData(int seen0, int playtimeForever, String playtimeForeverFormatted, int playtimeLast2weeks, String playtimeLast2weeksFormatted, Long rtimeLastPlayed, String rtimeLastPlayedFormatted, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.playtimeForever = 0;
        } else {
            this.playtimeForever = playtimeForever;
        }
        if ((seen0 & 2) == 0) {
            this.playtimeForeverFormatted = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playtimeForeverFormatted = playtimeForeverFormatted;
        }
        if ((seen0 & 4) == 0) {
            this.playtimeLast2weeks = 0;
        } else {
            this.playtimeLast2weeks = playtimeLast2weeks;
        }
        if ((seen0 & 8) == 0) {
            this.playtimeLast2weeksFormatted = RoomRecommendViewModel.EMPTY_CURSOR;
        } else {
            this.playtimeLast2weeksFormatted = playtimeLast2weeksFormatted;
        }
        if ((seen0 & 16) == 0) {
            this.rtimeLastPlayed = null;
        } else {
            this.rtimeLastPlayed = rtimeLastPlayed;
        }
        if ((seen0 & 32) == 0) {
            this.rtimeLastPlayedFormatted = null;
        } else {
            this.rtimeLastPlayedFormatted = rtimeLastPlayedFormatted;
        }
    }

    public PlayData(int playtimeForever, String playtimeForeverFormatted, int playtimeLast2weeks, String playtimeLast2weeksFormatted, Long rtimeLastPlayed, String rtimeLastPlayedFormatted) {
        Intrinsics.checkNotNullParameter(playtimeForeverFormatted, "playtimeForeverFormatted");
        Intrinsics.checkNotNullParameter(playtimeLast2weeksFormatted, "playtimeLast2weeksFormatted");
        this.playtimeForever = playtimeForever;
        this.playtimeForeverFormatted = playtimeForeverFormatted;
        this.playtimeLast2weeks = playtimeLast2weeks;
        this.playtimeLast2weeksFormatted = playtimeLast2weeksFormatted;
        this.rtimeLastPlayed = rtimeLastPlayed;
        this.rtimeLastPlayedFormatted = rtimeLastPlayedFormatted;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$gamebiz_debug(PlayData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.playtimeForever != 0) {
            output.encodeIntElement(serialDesc, 0, self.playtimeForever);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.playtimeForeverFormatted, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 1, self.playtimeForeverFormatted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.playtimeLast2weeks != 0) {
            output.encodeIntElement(serialDesc, 2, self.playtimeLast2weeks);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.playtimeLast2weeksFormatted, RoomRecommendViewModel.EMPTY_CURSOR)) {
            output.encodeStringElement(serialDesc, 3, self.playtimeLast2weeksFormatted);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.rtimeLastPlayed != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, LongSerializer.INSTANCE, self.rtimeLastPlayed);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.rtimeLastPlayedFormatted != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.rtimeLastPlayedFormatted);
        }
    }

    public /* synthetic */ PlayData(int i, String str, int i2, String str2, Long l, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) == 0 ? str2 : RoomRecommendViewModel.EMPTY_CURSOR, (i3 & 16) != 0 ? null : l, (i3 & 32) != 0 ? null : str3);
    }

    public final int getPlaytimeForever() {
        return this.playtimeForever;
    }

    public final String getPlaytimeForeverFormatted() {
        return this.playtimeForeverFormatted;
    }

    public final int getPlaytimeLast2weeks() {
        return this.playtimeLast2weeks;
    }

    public final String getPlaytimeLast2weeksFormatted() {
        return this.playtimeLast2weeksFormatted;
    }

    public final Long getRtimeLastPlayed() {
        return this.rtimeLastPlayed;
    }

    public final String getRtimeLastPlayedFormatted() {
        return this.rtimeLastPlayedFormatted;
    }
}