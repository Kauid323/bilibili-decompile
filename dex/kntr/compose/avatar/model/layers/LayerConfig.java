package kntr.compose.avatar.model.layers;

import BottomSheetItemData$;
import com.bapis.bilibili.dagw.component.avatar.v1.KLayerTagConfig;
import java.util.LinkedHashMap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Configs.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u0006!"}, d2 = {"Lkntr/compose/avatar/model/layers/LayerConfig;", "", "isCritical", "", "overDraw", "tags", "Lkntr/compose/avatar/model/layers/LayerTags;", "mask", "Lkntr/compose/avatar/model/layers/MaskProperty;", "<init>", "(ZZLjava/util/LinkedHashMap;Lkntr/compose/avatar/model/layers/MaskProperty;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "()Z", "getOverDraw", "getTags-MPYkDdY", "()Ljava/util/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "getMask", "()Lkntr/compose/avatar/model/layers/MaskProperty;", "isValid", "component1", "component2", "component3", "component3-MPYkDdY", "component4", "copy", "copy-e4g2uPU", "(ZZLjava/util/LinkedHashMap;Lkntr/compose/avatar/model/layers/MaskProperty;)Lkntr/compose/avatar/model/layers/LayerConfig;", "equals", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerConfig {
    private final boolean isCritical;
    private final MaskProperty mask;
    private final boolean overDraw;
    private final LinkedHashMap<String, KLayerTagConfig> tags;

    public /* synthetic */ LayerConfig(boolean z, boolean z2, LinkedHashMap linkedHashMap, MaskProperty maskProperty, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, linkedHashMap, maskProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: copy-e4g2uPU$default  reason: not valid java name */
    public static /* synthetic */ LayerConfig m2539copye4g2uPU$default(LayerConfig layerConfig, boolean z, boolean z2, LinkedHashMap linkedHashMap, MaskProperty maskProperty, int i, Object obj) {
        if ((i & 1) != 0) {
            z = layerConfig.isCritical;
        }
        if ((i & 2) != 0) {
            z2 = layerConfig.overDraw;
        }
        if ((i & 4) != 0) {
            linkedHashMap = layerConfig.tags;
        }
        if ((i & 8) != 0) {
            maskProperty = layerConfig.mask;
        }
        return layerConfig.m2541copye4g2uPU(z, z2, linkedHashMap, maskProperty);
    }

    public final boolean component1() {
        return this.isCritical;
    }

    public final boolean component2() {
        return this.overDraw;
    }

    /* renamed from: component3-MPYkDdY  reason: not valid java name */
    public final LinkedHashMap<String, KLayerTagConfig> m2540component3MPYkDdY() {
        return this.tags;
    }

    public final MaskProperty component4() {
        return this.mask;
    }

    /* renamed from: copy-e4g2uPU  reason: not valid java name */
    public final LayerConfig m2541copye4g2uPU(boolean z, boolean z2, LinkedHashMap<String, KLayerTagConfig> linkedHashMap, MaskProperty maskProperty) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "$v$c$kntr-compose-avatar-model-layers-LayerTags$-tags$0");
        return new LayerConfig(z, z2, linkedHashMap, maskProperty, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayerConfig) {
            LayerConfig layerConfig = (LayerConfig) obj;
            return this.isCritical == layerConfig.isCritical && this.overDraw == layerConfig.overDraw && LayerTags.m2549equalsimpl0(this.tags, layerConfig.tags) && Intrinsics.areEqual(this.mask, layerConfig.mask);
        }
        return false;
    }

    public int hashCode() {
        return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCritical) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.overDraw)) * 31) + LayerTags.m2552hashCodeimpl(this.tags)) * 31) + (this.mask == null ? 0 : this.mask.hashCode());
    }

    public String toString() {
        boolean z = this.isCritical;
        boolean z2 = this.overDraw;
        String m2557toStringimpl = LayerTags.m2557toStringimpl(this.tags);
        return "LayerConfig(isCritical=" + z + ", overDraw=" + z2 + ", tags=" + m2557toStringimpl + ", mask=" + this.mask + ")";
    }

    private LayerConfig(boolean isCritical, boolean overDraw, LinkedHashMap<String, KLayerTagConfig> linkedHashMap, MaskProperty mask) {
        Intrinsics.checkNotNullParameter(linkedHashMap, "tags");
        this.isCritical = isCritical;
        this.overDraw = overDraw;
        this.tags = linkedHashMap;
        this.mask = mask;
    }

    public /* synthetic */ LayerConfig(boolean z, boolean z2, LinkedHashMap linkedHashMap, MaskProperty maskProperty, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? LayerTags.m2545constructorimpl$default(null, 1, null) : linkedHashMap, (i & 8) != 0 ? null : maskProperty, null);
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    public final boolean getOverDraw() {
        return this.overDraw;
    }

    /* renamed from: getTags-MPYkDdY  reason: not valid java name */
    public final LinkedHashMap<String, KLayerTagConfig> m2542getTagsMPYkDdY() {
        return this.tags;
    }

    public final MaskProperty getMask() {
        return this.mask;
    }

    public final boolean isValid() {
        return this.mask == null || this.mask.isValid();
    }
}