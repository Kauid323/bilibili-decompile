package kntr.app.upper.entrance.bubble2.bean;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BK\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0002\u0010\u000fJ%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0003\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R*\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006-"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/FansShow;", "", "<init>", "()V", "seen0", "", "fanStart", "fanEnd", "day", "times", "info", "", "Lkntr/app/upper/entrance/bubble2/bean/FansShowInfo;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFanStart$annotations", "getFanStart", "()I", "setFanStart", "(I)V", "getFanEnd$annotations", "getFanEnd", "setFanEnd", "getDay$annotations", "getDay", "setDay", "getTimes$annotations", "getTimes", "setTimes", "getInfo$annotations", "getInfo", "()Ljava/util/List;", "setInfo", "(Ljava/util/List;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class FansShow {
    private int day;
    private int fanEnd;
    private int fanStart;
    private List<FansShowInfo> info;
    private int times;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.FansShow$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = FansShow._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    @SerialName("day")
    public static /* synthetic */ void getDay$annotations() {
    }

    @SerialName("fan_end")
    public static /* synthetic */ void getFanEnd$annotations() {
    }

    @SerialName("fan_start")
    public static /* synthetic */ void getFanStart$annotations() {
    }

    @SerialName("info")
    public static /* synthetic */ void getInfo$annotations() {
    }

    @SerialName("times")
    public static /* synthetic */ void getTimes$annotations() {
    }

    /* compiled from: BubbleTiredConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/FansShow$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/FansShow;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FansShow> serializer() {
            return FansShow$$serializer.INSTANCE;
        }
    }

    public FansShow() {
        this.info = new ArrayList();
    }

    public /* synthetic */ FansShow(int seen0, int fanStart, int fanEnd, int day, int times, List info, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.fanStart = 0;
        } else {
            this.fanStart = fanStart;
        }
        if ((seen0 & 2) == 0) {
            this.fanEnd = 0;
        } else {
            this.fanEnd = fanEnd;
        }
        if ((seen0 & 4) == 0) {
            this.day = 0;
        } else {
            this.day = day;
        }
        if ((seen0 & 8) == 0) {
            this.times = 0;
        } else {
            this.times = times;
        }
        if ((seen0 & 16) == 0) {
            this.info = new ArrayList();
        } else {
            this.info = info;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(FansShowInfo$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$entrance_debug(FansShow self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.fanStart != 0) {
            output.encodeIntElement(serialDesc, 0, self.fanStart);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fanEnd != 0) {
            output.encodeIntElement(serialDesc, 1, self.fanEnd);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.day != 0) {
            output.encodeIntElement(serialDesc, 2, self.day);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.times != 0) {
            output.encodeIntElement(serialDesc, 3, self.times);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.info, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.info);
        }
    }

    public final int getFanStart() {
        return this.fanStart;
    }

    public final void setFanStart(int i) {
        this.fanStart = i;
    }

    public final int getFanEnd() {
        return this.fanEnd;
    }

    public final void setFanEnd(int i) {
        this.fanEnd = i;
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

    public final List<FansShowInfo> getInfo() {
        return this.info;
    }

    public final void setInfo(List<FansShowInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.info = list;
    }
}