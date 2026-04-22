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

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003)*+B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB-\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u000bHÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "color", "Lkntr/common/ouro/core/model/mark/OuroColor;", "heightDp", "", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroColor;F)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroColor;FLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getColor", "()Lkntr/common/ouro/core/model/mark/OuroColor;", "getHeightDp", "()F", "key", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark$Key;", "toString", "", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Key", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroBackgroundColorMark implements OuroMark.BuiltIn, OuroTextMark, OuroDrawableMark {
    public static final Companion Companion = new Companion(null);
    private final OuroColor color;
    private final float heightDp;

    public static /* synthetic */ OuroBackgroundColorMark copy$default(OuroBackgroundColorMark ouroBackgroundColorMark, OuroColor ouroColor, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroColor = ouroBackgroundColorMark.color;
        }
        if ((i & 2) != 0) {
            f = ouroBackgroundColorMark.heightDp;
        }
        return ouroBackgroundColorMark.copy(ouroColor, f);
    }

    public final OuroColor component1() {
        return this.color;
    }

    public final float component2() {
        return this.heightDp;
    }

    public final OuroBackgroundColorMark copy(OuroColor ouroColor, float f) {
        Intrinsics.checkNotNullParameter(ouroColor, "color");
        return new OuroBackgroundColorMark(ouroColor, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroBackgroundColorMark) {
            OuroBackgroundColorMark ouroBackgroundColorMark = (OuroBackgroundColorMark) obj;
            return Intrinsics.areEqual(this.color, ouroBackgroundColorMark.color) && Float.compare(this.heightDp, ouroBackgroundColorMark.heightDp) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (this.color.hashCode() * 31) + Float.floatToIntBits(this.heightDp);
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroBackgroundColorMark> serializer() {
            return OuroBackgroundColorMark$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroBackgroundColorMark(int seen0, OuroColor color, float heightDp, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroBackgroundColorMark$$serializer.INSTANCE.getDescriptor());
        }
        this.color = color;
        if ((seen0 & 2) == 0) {
            this.heightDp = 12.0f;
        } else {
            this.heightDp = heightDp;
        }
    }

    public OuroBackgroundColorMark(OuroColor color, float heightDp) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
        this.heightDp = heightDp;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(OuroBackgroundColorMark self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, OuroColor$$serializer.INSTANCE, self.color);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Float.compare(self.heightDp, 12.0f) != 0) {
            output.encodeFloatElement(serialDesc, 1, self.heightDp);
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Override getMergeRule() {
        return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
    }

    public /* synthetic */ OuroBackgroundColorMark(OuroColor ouroColor, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ouroColor, (i & 2) != 0 ? 12.0f : f);
    }

    public final OuroColor getColor() {
        return this.color;
    }

    public final float getHeightDp() {
        return this.heightDp;
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroBackgroundColorMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroBackgroundColorMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public Key getKey() {
        return Key.INSTANCE;
    }

    public String toString() {
        return "BackgroundColor(" + this.color + ")";
    }
}