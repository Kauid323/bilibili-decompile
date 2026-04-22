package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 .2\u00020\u00012\u00020\u00022\u00020\u0003:\u0004+,-.B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB+\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextIndentMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$Custom;", "firstLine", "", "hanging", "<init>", "(FF)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFFLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFirstLine", "()F", "getHanging", "key", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "mergeRule", "Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "getMergeRule", "()Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Key", "MergeRule", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroTextIndentMark implements OuroMark.BuiltIn, OuroParagraphMark, OuroMark.Custom {
    public static final Companion Companion = new Companion(null);
    private final float firstLine;
    private final float hanging;

    public OuroTextIndentMark() {
        this(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OuroTextIndentMark copy$default(OuroTextIndentMark ouroTextIndentMark, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ouroTextIndentMark.firstLine;
        }
        if ((i & 2) != 0) {
            f2 = ouroTextIndentMark.hanging;
        }
        return ouroTextIndentMark.copy(f, f2);
    }

    public final float component1() {
        return this.firstLine;
    }

    public final float component2() {
        return this.hanging;
    }

    public final OuroTextIndentMark copy(float f, float f2) {
        return new OuroTextIndentMark(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroTextIndentMark) {
            OuroTextIndentMark ouroTextIndentMark = (OuroTextIndentMark) obj;
            return Float.compare(this.firstLine, ouroTextIndentMark.firstLine) == 0 && Float.compare(this.hanging, ouroTextIndentMark.hanging) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.firstLine) * 31) + Float.floatToIntBits(this.hanging);
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextIndentMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroTextIndentMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroTextIndentMark> serializer() {
            return OuroTextIndentMark$$serializer.INSTANCE;
        }
    }

    public OuroTextIndentMark(float firstLine, float hanging) {
        this.firstLine = firstLine;
        this.hanging = hanging;
    }

    public /* synthetic */ OuroTextIndentMark(int seen0, float firstLine, float hanging, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.firstLine = 0.0f;
        } else {
            this.firstLine = firstLine;
        }
        if ((seen0 & 2) == 0) {
            this.hanging = 0.0f;
        } else {
            this.hanging = hanging;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroTextIndentMark self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || Float.compare(self.firstLine, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 0, self.firstLine);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.hanging, 0.0f) != 0) {
            output.encodeFloatElement(serialDesc, 1, self.hanging);
        }
    }

    public /* synthetic */ OuroTextIndentMark(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f2);
    }

    public final float getFirstLine() {
        return this.firstLine;
    }

    public final float getHanging() {
        return this.hanging;
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextIndentMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroTextIndentMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroTextIndentMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00052\u0006\u0010\b\u001a\u0002H\u0005H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroTextIndentMark$MergeRule;", "Lkntr/common/ouro/core/model/mark/MergeRule$Custom;", "<init>", "()V", "invoke", "T", "Lkntr/common/ouro/core/model/mark/OuroMark;", "current", "parent", "(Lkntr/common/ouro/core/model/mark/OuroMark;Lkntr/common/ouro/core/model/mark/OuroMark;)Lkntr/common/ouro/core/model/mark/OuroMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MergeRule implements MergeRule.Custom {
        public static final MergeRule INSTANCE = new MergeRule();

        private MergeRule() {
        }

        @Override // kntr.common.ouro.core.model.mark.MergeRule
        public <T extends OuroMark> T invoke(T t, T t2) {
            Intrinsics.checkNotNullParameter(t, "current");
            Intrinsics.checkNotNullParameter(t2, "parent");
            if ((t instanceof OuroTextIndentMark) && (t2 instanceof OuroTextIndentMark)) {
                return new OuroTextIndentMark(((OuroTextIndentMark) t).getFirstLine() + ((OuroTextIndentMark) t2).getFirstLine(), ((OuroTextIndentMark) t).getHanging() + ((OuroTextIndentMark) t2).getHanging());
            }
            return t;
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public OuroMark.Key<? extends OuroParagraphMark> getKey() {
        return Key.INSTANCE;
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public MergeRule.Custom getMergeRule() {
        return MergeRule.INSTANCE;
    }

    public String toString() {
        float f = this.firstLine;
        return "TextIndent(" + f + ", " + this.hanging + ")";
    }
}