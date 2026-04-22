package kntr.compose.avatar.model.layers;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.IResource;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.UrlResource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MaskProperty.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lkntr/compose/avatar/model/layers/MaskProperty;", "", "generalSpec", "Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "maskSource", "Lkntr/compose/avatar/model/common/IResource;", "<init>", "(Lkntr/compose/avatar/model/common/LayerGeneralSpec;Lkntr/compose/avatar/model/common/IResource;)V", "getGeneralSpec", "()Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "getMaskSource", "()Lkntr/compose/avatar/model/common/IResource;", "isValid", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MaskProperty {
    private final LayerGeneralSpec generalSpec;
    private final IResource maskSource;

    public MaskProperty() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ MaskProperty copy$default(MaskProperty maskProperty, LayerGeneralSpec layerGeneralSpec, IResource iResource, int i, Object obj) {
        if ((i & 1) != 0) {
            layerGeneralSpec = maskProperty.generalSpec;
        }
        if ((i & 2) != 0) {
            iResource = maskProperty.maskSource;
        }
        return maskProperty.copy(layerGeneralSpec, iResource);
    }

    public final LayerGeneralSpec component1() {
        return this.generalSpec;
    }

    public final IResource component2() {
        return this.maskSource;
    }

    public final MaskProperty copy(LayerGeneralSpec layerGeneralSpec, IResource iResource) {
        Intrinsics.checkNotNullParameter(layerGeneralSpec, "generalSpec");
        Intrinsics.checkNotNullParameter(iResource, "maskSource");
        return new MaskProperty(layerGeneralSpec, iResource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MaskProperty) {
            MaskProperty maskProperty = (MaskProperty) obj;
            return Intrinsics.areEqual(this.generalSpec, maskProperty.generalSpec) && Intrinsics.areEqual(this.maskSource, maskProperty.maskSource);
        }
        return false;
    }

    public int hashCode() {
        return (this.generalSpec.hashCode() * 31) + this.maskSource.hashCode();
    }

    public String toString() {
        LayerGeneralSpec layerGeneralSpec = this.generalSpec;
        return "MaskProperty(generalSpec=" + layerGeneralSpec + ", maskSource=" + this.maskSource + ")";
    }

    public MaskProperty(LayerGeneralSpec generalSpec, IResource maskSource) {
        Intrinsics.checkNotNullParameter(generalSpec, "generalSpec");
        Intrinsics.checkNotNullParameter(maskSource, "maskSource");
        this.generalSpec = generalSpec;
        this.maskSource = maskSource;
    }

    public /* synthetic */ MaskProperty(LayerGeneralSpec layerGeneralSpec, UrlResource urlResource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new LayerGeneralSpec(null, null, null, 7, null) : layerGeneralSpec, (i & 2) != 0 ? new UrlResource(null, null, null, 7, null) : urlResource);
    }

    public final LayerGeneralSpec getGeneralSpec() {
        return this.generalSpec;
    }

    public final IResource getMaskSource() {
        return this.maskSource;
    }

    public final boolean isValid() {
        return this.generalSpec.isValid() && this.maskSource.isValidResource();
    }
}