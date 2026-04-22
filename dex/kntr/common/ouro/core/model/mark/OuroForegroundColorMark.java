package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroTextMark.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 &2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003$%&B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "Lkntr/common/ouro/core/model/mark/OuroMark$BuiltIn;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "color", "Lkntr/common/ouro/core/model/mark/OuroColor;", "<init>", "(Lkntr/common/ouro/core/model/mark/OuroColor;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkntr/common/ouro/core/model/mark/OuroColor;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getColor", "()Lkntr/common/ouro/core/model/mark/OuroColor;", "key", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark$Key;", "getKey", "()Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark$Key;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Key", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class OuroForegroundColorMark implements OuroMark.BuiltIn, OuroTextMark, OuroDrawableMark {
    public static final Companion Companion = new Companion(null);
    private final OuroColor color;

    public static /* synthetic */ OuroForegroundColorMark copy$default(OuroForegroundColorMark ouroForegroundColorMark, OuroColor ouroColor, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroColor = ouroForegroundColorMark.color;
        }
        return ouroForegroundColorMark.copy(ouroColor);
    }

    public final OuroColor component1() {
        return this.color;
    }

    public final OuroForegroundColorMark copy(OuroColor ouroColor) {
        Intrinsics.checkNotNullParameter(ouroColor, "color");
        return new OuroForegroundColorMark(ouroColor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroForegroundColorMark) && Intrinsics.areEqual(this.color, ((OuroForegroundColorMark) obj).color);
    }

    public int hashCode() {
        return this.color.hashCode();
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OuroForegroundColorMark> serializer() {
            return OuroForegroundColorMark$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ OuroForegroundColorMark(int seen0, OuroColor color, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, OuroForegroundColorMark$$serializer.INSTANCE.getDescriptor());
        }
        this.color = color;
    }

    public OuroForegroundColorMark(OuroColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.color = color;
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark, kntr.common.ouro.core.model.mark.OuroMark.Override
    public /* bridge */ MergeRule.Override getMergeRule() {
        return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) this);
    }

    public final OuroColor getColor() {
        return this.color;
    }

    /* compiled from: OuroTextMark.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "Lkntr/common/ouro/core/model/mark/OuroForegroundColorMark;", "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Key implements OuroMark.Key<OuroForegroundColorMark> {
        public static final Key INSTANCE = new Key();

        private Key() {
        }
    }

    @Override // kntr.common.ouro.core.model.mark.OuroMark
    public Key getKey() {
        return Key.INSTANCE;
    }

    public String toString() {
        return "ForegroundColor(" + this.color + ")";
    }
}