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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B3\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0016J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/LimitTime;", "", "<init>", "()V", "seen0", "", "start", "", "end", "percent", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStart$annotations", "getStart", "()J", "setStart", "(J)V", "getEnd$annotations", "getEnd", "setEnd", "getPercent$annotations", "getPercent", "()I", "setPercent", "(I)V", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class LimitTime {
    public static final Companion Companion = new Companion(null);
    private long end;
    private int percent;
    private long start;

    @SerialName("end")
    public static /* synthetic */ void getEnd$annotations() {
    }

    @SerialName("percent")
    public static /* synthetic */ void getPercent$annotations() {
    }

    @SerialName("start")
    public static /* synthetic */ void getStart$annotations() {
    }

    /* compiled from: BubbleTiredConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/LimitTime$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/LimitTime;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LimitTime> serializer() {
            return LimitTime$$serializer.INSTANCE;
        }
    }

    public LimitTime() {
    }

    public /* synthetic */ LimitTime(int seen0, long start, long end, int percent, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.start = 0L;
        } else {
            this.start = start;
        }
        if ((seen0 & 2) == 0) {
            this.end = 0L;
        } else {
            this.end = end;
        }
        if ((seen0 & 4) == 0) {
            this.percent = 0;
        } else {
            this.percent = percent;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$entrance_debug(LimitTime self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.start != 0) {
            output.encodeLongElement(serialDesc, 0, self.start);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.end != 0) {
            output.encodeLongElement(serialDesc, 1, self.end);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.percent != 0) {
            output.encodeIntElement(serialDesc, 2, self.percent);
        }
    }

    public final long getStart() {
        return this.start;
    }

    public final void setStart(long j) {
        this.start = j;
    }

    public final long getEnd() {
        return this.end;
    }

    public final void setEnd(long j) {
        this.end = j;
    }

    public final int getPercent() {
        return this.percent;
    }

    public final void setPercent(int i) {
        this.percent = i;
    }

    public String toString() {
        long j = this.start;
        long j2 = this.end;
        return "LimitTime(start=" + j + ", end=" + j2 + ", percent=" + this.percent + ")";
    }
}