package kntr.base.dd.impl.internal.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DDModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 72\u00020\u0001:\u000267BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010!JJ\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00062\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\nHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001J%\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u00002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u001dR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010!¨\u00068"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDProp;", "", "name", "", "default", "track", "", "rate", "", "cache", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "getDefault$annotations", "getDefault", "getTrack$annotations", "getTrack", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRate$annotations", "getRate", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getCache$annotations", "getCache", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)Lkntr/base/dd/impl/internal/model/DDProp;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_debug", "$serializer", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DDProp {
    public static final Companion Companion = new Companion(null);
    private final Integer cache;

    /* renamed from: default  reason: not valid java name */
    private final String f37default;
    private final String name;
    private final Double rate;
    private final Boolean track;

    public DDProp() {
        this((String) null, (String) null, (Boolean) null, (Double) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DDProp copy$default(DDProp dDProp, String str, String str2, Boolean bool, Double d, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dDProp.name;
        }
        if ((i & 2) != 0) {
            str2 = dDProp.f37default;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            bool = dDProp.track;
        }
        Boolean bool2 = bool;
        if ((i & 8) != 0) {
            d = dDProp.rate;
        }
        Double d2 = d;
        if ((i & 16) != 0) {
            num = dDProp.cache;
        }
        return dDProp.copy(str, str3, bool2, d2, num);
    }

    @SerialName("c")
    public static /* synthetic */ void getCache$annotations() {
    }

    @SerialName("d")
    public static /* synthetic */ void getDefault$annotations() {
    }

    @SerialName("n")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("r")
    public static /* synthetic */ void getRate$annotations() {
    }

    @SerialName("t")
    public static /* synthetic */ void getTrack$annotations() {
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.f37default;
    }

    public final Boolean component3() {
        return this.track;
    }

    public final Double component4() {
        return this.rate;
    }

    public final Integer component5() {
        return this.cache;
    }

    public final DDProp copy(String str, String str2, Boolean bool, Double d, Integer num) {
        return new DDProp(str, str2, bool, d, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DDProp) {
            DDProp dDProp = (DDProp) obj;
            return Intrinsics.areEqual(this.name, dDProp.name) && Intrinsics.areEqual(this.f37default, dDProp.f37default) && Intrinsics.areEqual(this.track, dDProp.track) && Intrinsics.areEqual(this.rate, dDProp.rate) && Intrinsics.areEqual(this.cache, dDProp.cache);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.name == null ? 0 : this.name.hashCode()) * 31) + (this.f37default == null ? 0 : this.f37default.hashCode())) * 31) + (this.track == null ? 0 : this.track.hashCode())) * 31) + (this.rate == null ? 0 : this.rate.hashCode())) * 31) + (this.cache != null ? this.cache.hashCode() : 0);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.f37default;
        Boolean bool = this.track;
        Double d = this.rate;
        return "DDProp(name=" + str + ", default=" + str2 + ", track=" + bool + ", rate=" + d + ", cache=" + this.cache + ")";
    }

    /* compiled from: DDModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDProp$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/dd/impl/internal/model/DDProp;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DDProp> serializer() {
            return DDProp$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ DDProp(int seen0, String name, String str, Boolean track, Double rate, Integer cache, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.name = null;
        } else {
            this.name = name;
        }
        if ((seen0 & 2) == 0) {
            this.f37default = null;
        } else {
            this.f37default = str;
        }
        if ((seen0 & 4) == 0) {
            this.track = null;
        } else {
            this.track = track;
        }
        if ((seen0 & 8) == 0) {
            this.rate = null;
        } else {
            this.rate = rate;
        }
        if ((seen0 & 16) == 0) {
            this.cache = null;
        } else {
            this.cache = cache;
        }
    }

    public DDProp(String name, String str, Boolean track, Double rate, Integer cache) {
        this.name = name;
        this.f37default = str;
        this.track = track;
        this.rate = rate;
        this.cache = cache;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$impl_debug(DDProp self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.f37default != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.f37default);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.track != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.track);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.rate != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, DoubleSerializer.INSTANCE, self.rate);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.cache != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.cache);
        }
    }

    public /* synthetic */ DDProp(String str, String str2, Boolean bool, Double d, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : num);
    }

    public final String getName() {
        return this.name;
    }

    public final String getDefault() {
        return this.f37default;
    }

    public final Boolean getTrack() {
        return this.track;
    }

    public final Double getRate() {
        return this.rate;
    }

    public final Integer getCache() {
        return this.cache;
    }
}