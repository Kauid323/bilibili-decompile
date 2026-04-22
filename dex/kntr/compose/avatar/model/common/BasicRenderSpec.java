package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GeneralSpec.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/compose/avatar/model/common/BasicRenderSpec;", "", "opacity", "", "<init>", "(F)V", "getOpacity", "()F", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BasicRenderSpec {
    private final float opacity;

    public BasicRenderSpec() {
        this(0.0f, 1, null);
    }

    public static /* synthetic */ BasicRenderSpec copy$default(BasicRenderSpec basicRenderSpec, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = basicRenderSpec.opacity;
        }
        return basicRenderSpec.copy(f);
    }

    public final float component1() {
        return this.opacity;
    }

    public final BasicRenderSpec copy(float f) {
        return new BasicRenderSpec(f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BasicRenderSpec) && Float.compare(this.opacity, ((BasicRenderSpec) obj).opacity) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.opacity);
    }

    public String toString() {
        return "BasicRenderSpec(opacity=" + this.opacity + ")";
    }

    public BasicRenderSpec(float opacity) {
        this.opacity = opacity;
    }

    public /* synthetic */ BasicRenderSpec(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f);
    }

    public final float getOpacity() {
        return this.opacity;
    }
}