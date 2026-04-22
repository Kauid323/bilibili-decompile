package kntr.app.upper.entrance.bubble2.bean;

import kntr.app.upcomingEpisode.ConstantsKt;
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

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B5\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;", "", "<init>", "()V", "seen0", "", "day", "times", "info", "Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getDay$annotations", "getDay", "()I", "setDay", "(I)V", "getTimes$annotations", "getTimes", "setTimes", "getInfo$annotations", "getInfo", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;", "setInfo", "(Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShowInfo;)V", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BubbleResourceShow {
    public static final Companion Companion = new Companion(null);
    private int day;
    private BubbleResourceShowInfo info;
    private int times;

    @SerialName("day")
    public static /* synthetic */ void getDay$annotations() {
    }

    @SerialName("info")
    public static /* synthetic */ void getInfo$annotations() {
    }

    @SerialName("times")
    public static /* synthetic */ void getTimes$annotations() {
    }

    /* compiled from: BubbleTiredConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BubbleResourceShow> serializer() {
            return BubbleResourceShow$$serializer.INSTANCE;
        }
    }

    public BubbleResourceShow() {
        this.day = 7;
        this.times = 1;
        this.info = new BubbleResourceShowInfo();
    }

    public /* synthetic */ BubbleResourceShow(int seen0, int day, int times, BubbleResourceShowInfo info, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.day = 7;
        } else {
            this.day = day;
        }
        if ((seen0 & 2) == 0) {
            this.times = 1;
        } else {
            this.times = times;
        }
        if ((seen0 & 4) == 0) {
            this.info = new BubbleResourceShowInfo();
        } else {
            this.info = info;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$entrance_debug(BubbleResourceShow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.day != 7) {
            output.encodeIntElement(serialDesc, 0, self.day);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.times != 1) {
            output.encodeIntElement(serialDesc, 1, self.times);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.info, new BubbleResourceShowInfo())) {
            output.encodeSerializableElement(serialDesc, 2, BubbleResourceShowInfo$$serializer.INSTANCE, self.info);
        }
    }

    public final int getDay() {
        return this.day;
    }

    public final void setDay(int i) {
        this.day = i;
    }

    public final int getTimes() {
        return this.times;
    }

    public final void setTimes(int i) {
        this.times = i;
    }

    public final BubbleResourceShowInfo getInfo() {
        return this.info;
    }

    public final void setInfo(BubbleResourceShowInfo bubbleResourceShowInfo) {
        Intrinsics.checkNotNullParameter(bubbleResourceShowInfo, "<set-?>");
        this.info = bubbleResourceShowInfo;
    }

    public String toString() {
        int i = this.day;
        int i2 = this.times;
        return "BubbleResourceShow(day=" + i + ", times=" + i2 + ", info=" + this.info + ")";
    }
}