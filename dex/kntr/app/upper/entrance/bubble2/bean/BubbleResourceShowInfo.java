package kntr.app.upper.entrance.bubble2.bean;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B;\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R$\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006'"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;", "", "<init>", "()V", "seen0", "", "interestDay", "interestTimes", "hotDay", "hotTimes", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getInterestDay$annotations", "getInterestDay", "()I", "setInterestDay", "(I)V", "getInterestTimes$annotations", "getInterestTimes", "setInterestTimes", "getHotDay$annotations", "getHotDay", "setHotDay", "getHotTimes$annotations", "getHotTimes", "setHotTimes", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BubbleResourceShowInfo {
    public static final Companion Companion = new Companion(null);
    private int hotDay;
    private int hotTimes;
    private int interestDay;
    private int interestTimes;

    @SerialName("hot_day")
    public static /* synthetic */ void getHotDay$annotations() {
    }

    @SerialName("hot_times")
    public static /* synthetic */ void getHotTimes$annotations() {
    }

    @SerialName("interest_day")
    public static /* synthetic */ void getInterestDay$annotations() {
    }

    @SerialName("interest_times")
    public static /* synthetic */ void getInterestTimes$annotations() {
    }

    /* compiled from: BubbleTiredConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BubbleResourceShowInfo> serializer() {
            return BubbleResourceShowInfo$$serializer.INSTANCE;
        }
    }

    public BubbleResourceShowInfo() {
        this.interestDay = 7;
        this.interestTimes = 1;
        this.hotDay = 14;
        this.hotTimes = 1;
    }

    public /* synthetic */ BubbleResourceShowInfo(int seen0, int interestDay, int interestTimes, int hotDay, int hotTimes, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.interestDay = 7;
        } else {
            this.interestDay = interestDay;
        }
        if ((seen0 & 2) == 0) {
            this.interestTimes = 1;
        } else {
            this.interestTimes = interestTimes;
        }
        if ((seen0 & 4) == 0) {
            this.hotDay = 14;
        } else {
            this.hotDay = hotDay;
        }
        if ((seen0 & 8) == 0) {
            this.hotTimes = 1;
        } else {
            this.hotTimes = hotTimes;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$entrance_debug(BubbleResourceShowInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.interestDay != 7) {
            output.encodeIntElement(serialDesc, 0, self.interestDay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.interestTimes != 1) {
            output.encodeIntElement(serialDesc, 1, self.interestTimes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.hotDay != 14) {
            output.encodeIntElement(serialDesc, 2, self.hotDay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.hotTimes != 1) {
            output.encodeIntElement(serialDesc, 3, self.hotTimes);
        }
    }

    public final int getInterestDay() {
        return this.interestDay;
    }

    public final void setInterestDay(int i) {
        this.interestDay = i;
    }

    public final int getInterestTimes() {
        return this.interestTimes;
    }

    public final void setInterestTimes(int i) {
        this.interestTimes = i;
    }

    public final int getHotDay() {
        return this.hotDay;
    }

    public final void setHotDay(int i) {
        this.hotDay = i;
    }

    public final int getHotTimes() {
        return this.hotTimes;
    }

    public final void setHotTimes(int i) {
        this.hotTimes = i;
    }

    public String toString() {
        int i = this.interestDay;
        int i2 = this.interestTimes;
        int i3 = this.hotDay;
        return "BubbleResourceShowInfo(interestDay=" + i + ", interestTimes=" + i2 + ", hotDay=" + i3 + ", hotTimes=" + this.hotTimes + ")";
    }
}