package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GeneralSpec.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001d"}, d2 = {"Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "", "size", "Lkntr/compose/avatar/model/common/SizeSpec;", "position", "Lkntr/compose/avatar/model/common/PositionSpec;", "renderSpec", "Lkntr/compose/avatar/model/common/BasicRenderSpec;", "<init>", "(Lkntr/compose/avatar/model/common/SizeSpec;Lkntr/compose/avatar/model/common/PositionSpec;Lkntr/compose/avatar/model/common/BasicRenderSpec;)V", "getSize", "()Lkntr/compose/avatar/model/common/SizeSpec;", "getPosition", "()Lkntr/compose/avatar/model/common/PositionSpec;", "getRenderSpec", "()Lkntr/compose/avatar/model/common/BasicRenderSpec;", "isValid", "", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerGeneralSpec {
    private final PositionSpec position;
    private final BasicRenderSpec renderSpec;
    private final SizeSpec size;

    public LayerGeneralSpec() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LayerGeneralSpec copy$default(LayerGeneralSpec layerGeneralSpec, SizeSpec sizeSpec, PositionSpec positionSpec, BasicRenderSpec basicRenderSpec, int i, Object obj) {
        if ((i & 1) != 0) {
            sizeSpec = layerGeneralSpec.size;
        }
        if ((i & 2) != 0) {
            positionSpec = layerGeneralSpec.position;
        }
        if ((i & 4) != 0) {
            basicRenderSpec = layerGeneralSpec.renderSpec;
        }
        return layerGeneralSpec.copy(sizeSpec, positionSpec, basicRenderSpec);
    }

    public final SizeSpec component1() {
        return this.size;
    }

    public final PositionSpec component2() {
        return this.position;
    }

    public final BasicRenderSpec component3() {
        return this.renderSpec;
    }

    public final LayerGeneralSpec copy(SizeSpec sizeSpec, PositionSpec positionSpec, BasicRenderSpec basicRenderSpec) {
        Intrinsics.checkNotNullParameter(sizeSpec, "size");
        Intrinsics.checkNotNullParameter(positionSpec, "position");
        Intrinsics.checkNotNullParameter(basicRenderSpec, "renderSpec");
        return new LayerGeneralSpec(sizeSpec, positionSpec, basicRenderSpec);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayerGeneralSpec) {
            LayerGeneralSpec layerGeneralSpec = (LayerGeneralSpec) obj;
            return Intrinsics.areEqual(this.size, layerGeneralSpec.size) && Intrinsics.areEqual(this.position, layerGeneralSpec.position) && Intrinsics.areEqual(this.renderSpec, layerGeneralSpec.renderSpec);
        }
        return false;
    }

    public int hashCode() {
        return (((this.size.hashCode() * 31) + this.position.hashCode()) * 31) + this.renderSpec.hashCode();
    }

    public String toString() {
        SizeSpec sizeSpec = this.size;
        PositionSpec positionSpec = this.position;
        return "LayerGeneralSpec(size=" + sizeSpec + ", position=" + positionSpec + ", renderSpec=" + this.renderSpec + ")";
    }

    public LayerGeneralSpec(SizeSpec size, PositionSpec position, BasicRenderSpec renderSpec) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(position, "position");
        Intrinsics.checkNotNullParameter(renderSpec, "renderSpec");
        this.size = size;
        this.position = position;
        this.renderSpec = renderSpec;
    }

    public /* synthetic */ LayerGeneralSpec(SizeSpec sizeSpec, PositionSpec positionSpec, BasicRenderSpec basicRenderSpec, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SizeSpec(0.0f, 0.0f, 3, null) : sizeSpec, (i & 2) != 0 ? new PositionSpec(0.0f, 0.0f, null, 7, null) : positionSpec, (i & 4) != 0 ? new BasicRenderSpec(0.0f, 1, null) : basicRenderSpec);
    }

    public final SizeSpec getSize() {
        return this.size;
    }

    public final PositionSpec getPosition() {
        return this.position;
    }

    public final BasicRenderSpec getRenderSpec() {
        return this.renderSpec;
    }

    public final boolean isValid() {
        return this.position.isValid();
    }
}