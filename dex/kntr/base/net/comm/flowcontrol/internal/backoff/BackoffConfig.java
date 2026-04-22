package kntr.base.net.comm.flowcontrol.internal.backoff;

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

/* compiled from: BackoffConfig.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J;\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001J%\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0001¢\u0006\u0002\b6R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b \u0010\u0010\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f¨\u00069"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "", "maxTimes", "", "initialDelay", "maxDelay", "factor", "", "jitter", "<init>", "(IIIFF)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIFFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMaxTimes$annotations", "()V", "getMaxTimes", "()I", "setMaxTimes", "(I)V", "getInitialDelay$annotations", "getInitialDelay", "setInitialDelay", "getMaxDelay$annotations", "getMaxDelay", "setMaxDelay", "getFactor$annotations", "getFactor", "()F", "setFactor", "(F)V", "getJitter$annotations", "getJitter", "setJitter", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$flow_control_debug", "$serializer", "Companion", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BackoffConfig {
    public static final Companion Companion = new Companion(null);
    private float factor;
    private int initialDelay;
    private float jitter;
    private int maxDelay;
    private int maxTimes;

    public BackoffConfig() {
        this(0, 0, 0, 0.0f, 0.0f, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BackoffConfig copy$default(BackoffConfig backoffConfig, int i, int i2, int i3, float f, float f2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = backoffConfig.maxTimes;
        }
        if ((i4 & 2) != 0) {
            i2 = backoffConfig.initialDelay;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = backoffConfig.maxDelay;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            f = backoffConfig.factor;
        }
        float f3 = f;
        if ((i4 & 16) != 0) {
            f2 = backoffConfig.jitter;
        }
        return backoffConfig.copy(i, i5, i6, f3, f2);
    }

    @SerialName("factor")
    public static /* synthetic */ void getFactor$annotations() {
    }

    @SerialName("initialDelay")
    public static /* synthetic */ void getInitialDelay$annotations() {
    }

    @SerialName("jitter")
    public static /* synthetic */ void getJitter$annotations() {
    }

    @SerialName("maxDelay")
    public static /* synthetic */ void getMaxDelay$annotations() {
    }

    @SerialName("maxTimes")
    public static /* synthetic */ void getMaxTimes$annotations() {
    }

    public final int component1() {
        return this.maxTimes;
    }

    public final int component2() {
        return this.initialDelay;
    }

    public final int component3() {
        return this.maxDelay;
    }

    public final float component4() {
        return this.factor;
    }

    public final float component5() {
        return this.jitter;
    }

    public final BackoffConfig copy(int i, int i2, int i3, float f, float f2) {
        return new BackoffConfig(i, i2, i3, f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BackoffConfig) {
            BackoffConfig backoffConfig = (BackoffConfig) obj;
            return this.maxTimes == backoffConfig.maxTimes && this.initialDelay == backoffConfig.initialDelay && this.maxDelay == backoffConfig.maxDelay && Float.compare(this.factor, backoffConfig.factor) == 0 && Float.compare(this.jitter, backoffConfig.jitter) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.maxTimes * 31) + this.initialDelay) * 31) + this.maxDelay) * 31) + Float.floatToIntBits(this.factor)) * 31) + Float.floatToIntBits(this.jitter);
    }

    public String toString() {
        int i = this.maxTimes;
        int i2 = this.initialDelay;
        int i3 = this.maxDelay;
        float f = this.factor;
        return "BackoffConfig(maxTimes=" + i + ", initialDelay=" + i2 + ", maxDelay=" + i3 + ", factor=" + f + ", jitter=" + this.jitter + ")";
    }

    /* compiled from: BackoffConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/net/comm/flowcontrol/internal/backoff/BackoffConfig;", "flow_control_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BackoffConfig> serializer() {
            return BackoffConfig$$serializer.INSTANCE;
        }
    }

    public BackoffConfig(int maxTimes, int initialDelay, int maxDelay, float factor, float jitter) {
        this.maxTimes = maxTimes;
        this.initialDelay = initialDelay;
        this.maxDelay = maxDelay;
        this.factor = factor;
        this.jitter = jitter;
    }

    public /* synthetic */ BackoffConfig(int seen0, int maxTimes, int initialDelay, int maxDelay, float factor, float jitter, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.maxTimes = 3;
        } else {
            this.maxTimes = maxTimes;
        }
        if ((seen0 & 2) == 0) {
            this.initialDelay = 3;
        } else {
            this.initialDelay = initialDelay;
        }
        if ((seen0 & 4) == 0) {
            this.maxDelay = BackoffConfigKt.MAX_DELAY_SECONDS;
        } else {
            this.maxDelay = maxDelay;
        }
        if ((seen0 & 8) == 0) {
            this.factor = 1.6f;
        } else {
            this.factor = factor;
        }
        if ((seen0 & 16) == 0) {
            this.jitter = 0.2f;
        } else {
            this.jitter = jitter;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$flow_control_debug(BackoffConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.maxTimes != 3) {
            output.encodeIntElement(serialDesc, 0, self.maxTimes);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.initialDelay != 3) {
            output.encodeIntElement(serialDesc, 1, self.initialDelay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.maxDelay != 120) {
            output.encodeIntElement(serialDesc, 2, self.maxDelay);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || Float.compare(self.factor, 1.6f) != 0) {
            output.encodeFloatElement(serialDesc, 3, self.factor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || Float.compare(self.jitter, 0.2f) != 0) {
            output.encodeFloatElement(serialDesc, 4, self.jitter);
        }
    }

    public /* synthetic */ BackoffConfig(int i, int i2, int i3, float f, float f2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 3 : i, (i4 & 2) == 0 ? i2 : 3, (i4 & 4) != 0 ? 120 : i3, (i4 & 8) != 0 ? 1.6f : f, (i4 & 16) != 0 ? 0.2f : f2);
    }

    public final int getMaxTimes() {
        return this.maxTimes;
    }

    public final void setMaxTimes(int i) {
        this.maxTimes = i;
    }

    public final int getInitialDelay() {
        return this.initialDelay;
    }

    public final void setInitialDelay(int i) {
        this.initialDelay = i;
    }

    public final int getMaxDelay() {
        return this.maxDelay;
    }

    public final void setMaxDelay(int i) {
        this.maxDelay = i;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final void setFactor(float f) {
        this.factor = f;
    }

    public final float getJitter() {
        return this.jitter;
    }

    public final void setJitter(float f) {
        this.jitter = f;
    }
}