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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroParagraphMark.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003)*+B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB-\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$Inherit;", "height", "", "style", "Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "<init>", "(FLkntr/common/ouro/core/model/mark/OuroLineHeightStyle;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IFLkntr/common/ouro/core/model/mark/OuroLineHeightStyle;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getHeight", "()F", "getStyle", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightStyle;", "key", "Lkntr/common/ouro/core/model/mark/OuroLineHeightMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroLineHeightMark$Key;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Key", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroLineHeightMark implements OuroMark.BuiltIn, OuroParagraphMark, OuroMark.Inherit {
    public static final Companion Companion = new Companion(null);
    private final float height;
    private final OuroLineHeightStyle style;

    public static /* synthetic */ OuroLineHeightMark copy$default(OuroLineHeightMark ouroLineHeightMark, float f, OuroLineHeightStyle ouroLineHeightStyle, int i, Object obj) {
        if ((i & 1) != 0) {
            f = ouroLineHeightMark.height;
        }
        if ((i & 2) != 0) {
            ouroLineHeightStyle = ouroLineHeightMark.style;
        }
        return ouroLineHeightMark.copy(f, ouroLineHeightStyle);
    }

    public final float component1() {
        return this.height;
    }

    public final OuroLineHeightStyle component2() {
        return this.style;
    }

    public final OuroLineHeightMark copy(float f, OuroLineHeightStyle ouroLineHeightStyle) {
        Intrinsics.checkNotNullParameter(ouroLineHeightStyle, "style");
        return new OuroLineHeightMark(f, ouroLineHeightStyle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroLineHeightMark) {
            OuroLineHeightMark ouroLineHeightMark = (OuroLineHeightMark) obj;
            return Float.compare(this.height, ouroLineHeightMark.height) == 0 && Intrinsics.areEqual(this.style, ouroLineHeightMark.style);
        }
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.height) * 31) + this.style.hashCode();
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroLineHeightMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroLineHeightMark> serializer() {
            return OuroLineHeightMark$$serializer.INSTANCE;
        }
    }

    public OuroLineHeightMark(float height, OuroLineHeightStyle style) {
        Intrinsics.checkNotNullParameter(style, "style");
        this.height = height;
        this.style = style;
    }

    public /* synthetic */ OuroLineHeightMark(int seen0, float height, OuroLineHeightStyle style, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroLineHeightMark$$serializer.INSTANCE.getDescriptor());
        }
        this.height = height;
        if ((seen0 & 2) == 0) {
            this.style = OuroLineHeightStyle.Companion.getDefault();
        } else {
            this.style = style;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroLineHeightMark self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeFloatElement(serialDesc, 0, self.height);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.style, OuroLineHeightStyle.Companion.getDefault())) {
            output.encodeSerializableElement(serialDesc, 1, OuroLineHeightStyle$$serializer.INSTANCE, self.style);
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Inherit getMergeRule() {
        return OuroMark.Inherit.CC.$default$getMergeRule((OuroMark.Inherit) this);
    }

    public /* synthetic */ OuroLineHeightMark(float f, OuroLineHeightStyle ouroLineHeightStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, (i & 2) != 0 ? OuroLineHeightStyle.Companion.getDefault() : ouroLineHeightStyle);
    }

    public final float getHeight() {
        return this.height;
    }

    public final OuroLineHeightStyle getStyle() {
        return this.style;
    }

    /* compiled from: OuroParagraphMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroLineHeightMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroLineHeightMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroLineHeightMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public Key getKey() {
        return Key.INSTANCE;
    }

    public String toString() {
        float f = this.height;
        return "LineHeight(" + f + ", " + this.style + ")";
    }
}