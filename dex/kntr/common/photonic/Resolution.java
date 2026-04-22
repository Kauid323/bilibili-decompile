package kntr.common.photonic;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Resolution.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\nJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006!"}, d2 = {"Lkntr/common/photonic/Resolution;", "", "widthPx", "", "heightPx", "<init>", "(II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWidthPx", "()I", "getHeightPx", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$image_debug", "Companion", "$serializer", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class Resolution {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final Resolution Zero = new Resolution(0, 0);
    private final int heightPx;
    private final int widthPx;

    public static /* synthetic */ Resolution copy$default(Resolution resolution, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = resolution.widthPx;
        }
        if ((i3 & 2) != 0) {
            i2 = resolution.heightPx;
        }
        return resolution.copy(i, i2);
    }

    public final int component1() {
        return this.widthPx;
    }

    public final int component2() {
        return this.heightPx;
    }

    public final Resolution copy(int i, int i2) {
        return new Resolution(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Resolution) {
            Resolution resolution = (Resolution) obj;
            return this.widthPx == resolution.widthPx && this.heightPx == resolution.heightPx;
        }
        return false;
    }

    public int hashCode() {
        return (this.widthPx * 31) + this.heightPx;
    }

    public String toString() {
        int i = this.widthPx;
        return "Resolution(widthPx=" + i + ", heightPx=" + this.heightPx + ")";
    }

    public Resolution(int widthPx, int heightPx) {
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }

    public /* synthetic */ Resolution(int seen0, int widthPx, int heightPx, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, Resolution$$serializer.INSTANCE.getDescriptor());
        }
        this.widthPx = widthPx;
        this.heightPx = heightPx;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$image_debug(Resolution self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.widthPx);
        output.encodeIntElement(serialDesc, 1, self.heightPx);
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    /* compiled from: Resolution.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/common/photonic/Resolution$Companion;", "", "<init>", "()V", "Zero", "Lkntr/common/photonic/Resolution;", "getZero", "()Lkntr/common/photonic/Resolution;", "serializer", "Lkotlinx/serialization/KSerializer;", "image_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Resolution> serializer() {
            return Resolution$$serializer.INSTANCE;
        }

        public final Resolution getZero() {
            return Resolution.Zero;
        }
    }
}