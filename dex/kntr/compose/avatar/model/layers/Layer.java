package kntr.compose.avatar.model.layers;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Layer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J;\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0011R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000f¨\u0006*"}, d2 = {"Lkntr/compose/avatar/model/layers/Layer;", "", "id", "", "visible", "", "generalSpec", "Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "layerConfig", "Lkntr/compose/avatar/model/layers/LayerConfig;", "resource", "Lkntr/compose/avatar/model/layers/LayerResource;", "<init>", "(Ljava/lang/String;ZLkntr/compose/avatar/model/common/LayerGeneralSpec;Lkntr/compose/avatar/model/layers/LayerConfig;Lkntr/compose/avatar/model/layers/LayerResource;)V", "getId", "()Ljava/lang/String;", "getVisible", "()Z", "getGeneralSpec", "()Lkntr/compose/avatar/model/common/LayerGeneralSpec;", "getLayerConfig", "()Lkntr/compose/avatar/model/layers/LayerConfig;", "getResource", "()Lkntr/compose/avatar/model/layers/LayerResource;", "isValid", "isBackground", "isAvatar", "isPendant", "isIcon", "logString", "getLogString", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Layer {
    private final LayerGeneralSpec generalSpec;
    private final String id;
    private final LayerConfig layerConfig;
    private final String logString;
    private final LayerResource resource;
    private final boolean visible;

    public Layer() {
        this(null, false, null, null, null, 31, null);
    }

    public static /* synthetic */ Layer copy$default(Layer layer, String str, boolean z, LayerGeneralSpec layerGeneralSpec, LayerConfig layerConfig, LayerResource layerResource, int i, Object obj) {
        if ((i & 1) != 0) {
            str = layer.id;
        }
        if ((i & 2) != 0) {
            z = layer.visible;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            layerGeneralSpec = layer.generalSpec;
        }
        LayerGeneralSpec layerGeneralSpec2 = layerGeneralSpec;
        if ((i & 8) != 0) {
            layerConfig = layer.layerConfig;
        }
        LayerConfig layerConfig2 = layerConfig;
        if ((i & 16) != 0) {
            layerResource = layer.resource;
        }
        return layer.copy(str, z2, layerGeneralSpec2, layerConfig2, layerResource);
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.visible;
    }

    public final LayerGeneralSpec component3() {
        return this.generalSpec;
    }

    public final LayerConfig component4() {
        return this.layerConfig;
    }

    public final LayerResource component5() {
        return this.resource;
    }

    public final Layer copy(String str, boolean z, LayerGeneralSpec layerGeneralSpec, LayerConfig layerConfig, LayerResource layerResource) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(layerGeneralSpec, "generalSpec");
        Intrinsics.checkNotNullParameter(layerConfig, "layerConfig");
        Intrinsics.checkNotNullParameter(layerResource, "resource");
        return new Layer(str, z, layerGeneralSpec, layerConfig, layerResource);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Layer) {
            Layer layer = (Layer) obj;
            return Intrinsics.areEqual(this.id, layer.id) && this.visible == layer.visible && Intrinsics.areEqual(this.generalSpec, layer.generalSpec) && Intrinsics.areEqual(this.layerConfig, layer.layerConfig) && Intrinsics.areEqual(this.resource, layer.resource);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.visible)) * 31) + this.generalSpec.hashCode()) * 31) + this.layerConfig.hashCode()) * 31) + this.resource.hashCode();
    }

    public String toString() {
        String str = this.id;
        boolean z = this.visible;
        LayerGeneralSpec layerGeneralSpec = this.generalSpec;
        LayerConfig layerConfig = this.layerConfig;
        return "Layer(id=" + str + ", visible=" + z + ", generalSpec=" + layerGeneralSpec + ", layerConfig=" + layerConfig + ", resource=" + this.resource + ")";
    }

    public Layer(String id, boolean visible, LayerGeneralSpec generalSpec, LayerConfig layerConfig, LayerResource resource) {
        String str;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(generalSpec, "generalSpec");
        Intrinsics.checkNotNullParameter(layerConfig, "layerConfig");
        Intrinsics.checkNotNullParameter(resource, "resource");
        this.id = id;
        this.visible = visible;
        this.generalSpec = generalSpec;
        this.layerConfig = layerConfig;
        this.resource = resource;
        String str2 = this.id;
        if (isBackground()) {
            str = "background layer";
        } else if (isAvatar()) {
            str = "avatar layer";
        } else if (isPendant()) {
            str = "pendant layer";
        } else {
            str = isIcon() ? "icon layer" : "other layer";
        }
        this.logString = "id " + str2 + " " + str + ", resource type" + this.resource.getResType() + ", valid " + isValid();
    }

    public /* synthetic */ Layer(String str, boolean z, LayerGeneralSpec layerGeneralSpec, LayerConfig layerConfig, LayerResource layerResource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? true : z, (i & 4) != 0 ? new LayerGeneralSpec(null, null, null, 7, null) : layerGeneralSpec, (i & 8) != 0 ? new LayerConfig(false, false, null, null, 15, null) : layerConfig, (i & 16) != 0 ? InvalidLayerResource.INSTANCE : layerResource);
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final LayerGeneralSpec getGeneralSpec() {
        return this.generalSpec;
    }

    public final LayerConfig getLayerConfig() {
        return this.layerConfig;
    }

    public final LayerResource getResource() {
        return this.resource;
    }

    public final boolean isValid() {
        return this.generalSpec.isValid() && this.layerConfig.isValid();
    }

    public final boolean isBackground() {
        return LayerTags.m2554isBackgroundimpl(this.layerConfig.m2542getTagsMPYkDdY());
    }

    public final boolean isAvatar() {
        return LayerTags.m2553isAvatarimpl(this.layerConfig.m2542getTagsMPYkDdY());
    }

    public final boolean isPendant() {
        return LayerTags.m2556isPendantimpl(this.layerConfig.m2542getTagsMPYkDdY());
    }

    public final boolean isIcon() {
        return LayerTags.m2555isIconimpl(this.layerConfig.m2542getTagsMPYkDdY());
    }

    public final String getLogString() {
        return this.logString;
    }
}