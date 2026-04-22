package kntr.compose.avatar.parser.protobuf;

import com.bapis.bilibili.dagw.component.avatar.common.KLayerGeneralSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KMaskProperty;
import com.bapis.bilibili.dagw.component.avatar.common.KSizeSpec;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import com.bapis.bilibili.dagw.component.avatar.v1.KBasicLayerResource;
import com.bapis.bilibili.dagw.component.avatar.v1.KLayer;
import com.bapis.bilibili.dagw.component.avatar.v1.KLayerConfig;
import com.bapis.bilibili.dagw.component.avatar.v1.KLayerGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.AvatarItem;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.SizeSpec;
import kntr.compose.avatar.model.layers.InvalidLayerResource;
import kntr.compose.avatar.model.layers.Layer;
import kntr.compose.avatar.model.layers.LayerConfig;
import kntr.compose.avatar.model.layers.LayerGroup;
import kntr.compose.avatar.model.layers.LayerTags;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Avatar.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b¨\u0006\f"}, d2 = {"toLayerConfig", "Lkntr/compose/avatar/model/layers/LayerConfig;", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayerConfig;", "toLayer", "Lkntr/compose/avatar/model/layers/Layer;", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayer;", "toLayerGroup", "Lkntr/compose/avatar/model/layers/LayerGroup;", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KLayerGroup;", "toAvatarItem", "Lkntr/compose/avatar/model/AvatarItem;", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KAvatarItem;", "parser_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvatarKt {
    public static final LayerConfig toLayerConfig(KLayerConfig $this$toLayerConfig) {
        Intrinsics.checkNotNullParameter($this$toLayerConfig, "<this>");
        boolean isCritical = $this$toLayerConfig.isCritical();
        boolean allowOverPaint = $this$toLayerConfig.getAllowOverPaint();
        KMaskProperty layerMask = $this$toLayerConfig.getLayerMask();
        return new LayerConfig(isCritical, allowOverPaint, LayerTags.m2544constructorimpl(new LinkedHashMap(MapsKt.emptyMap())), layerMask != null ? ResourceKt.toMask(layerMask) : null, null);
    }

    public static final Layer toLayer(KLayer $this$toLayer) {
        InvalidLayerResource invalidLayerResource;
        LayerConfig layerConfig;
        LayerGeneralSpec layerGeneralSpec;
        Intrinsics.checkNotNullParameter($this$toLayer, "<this>");
        String layerId = $this$toLayer.getLayerId();
        boolean visible = $this$toLayer.getVisible();
        KLayerGeneralSpec generalSpec = $this$toLayer.getGeneralSpec();
        LayerGeneralSpec layerGeneralSpec2 = (generalSpec == null || (layerGeneralSpec = CoordinateKt.toLayerGeneralSpec(generalSpec)) == null) ? new LayerGeneralSpec(null, null, null, 7, null) : layerGeneralSpec;
        KLayerConfig layerConfig2 = $this$toLayer.getLayerConfig();
        LayerConfig layerConfig3 = (layerConfig2 == null || (layerConfig = toLayerConfig(layerConfig2)) == null) ? new LayerConfig(false, false, null, null, 15, null) : layerConfig;
        KBasicLayerResource resource = $this$toLayer.getResource();
        if (resource == null || (invalidLayerResource = ResourceKt.toResource(resource)) == null) {
            invalidLayerResource = InvalidLayerResource.INSTANCE;
        }
        return new Layer(layerId, visible, layerGeneralSpec2, layerConfig3, invalidLayerResource);
    }

    public static final LayerGroup toLayerGroup(KLayerGroup $this$toLayerGroup) {
        Intrinsics.checkNotNullParameter($this$toLayerGroup, "<this>");
        String groupId = $this$toLayerGroup.getGroupId();
        Iterable $this$map$iv = $this$toLayerGroup.getLayers();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KLayer it = (KLayer) item$iv$iv;
            destination$iv$iv.add(toLayer(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        KMaskProperty groupMask = $this$toLayerGroup.getGroupMask();
        return new LayerGroup(groupId, arrayList, groupMask != null ? ResourceKt.toMask(groupMask) : null, $this$toLayerGroup.isCriticalGroup());
    }

    public static final AvatarItem toAvatarItem(KAvatarItem $this$toAvatarItem) {
        SizeSpec sizeSpec;
        Intrinsics.checkNotNullParameter($this$toAvatarItem, "<this>");
        long mid = $this$toAvatarItem.getMid();
        KSizeSpec containerSize = $this$toAvatarItem.getContainerSize();
        if (containerSize == null || (sizeSpec = CoordinateKt.toSizeSpec(containerSize)) == null) {
            sizeSpec = new SizeSpec(0.0f, 0.0f, 3, null);
        }
        SizeSpec sizeSpec2 = sizeSpec;
        Iterable $this$map$iv = $this$toAvatarItem.getLayers();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KLayerGroup it = (KLayerGroup) item$iv$iv;
            destination$iv$iv.add(toLayerGroup(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        KLayerGroup fallbackLayers = $this$toAvatarItem.getFallbackLayers();
        return new AvatarItem(mid, sizeSpec2, arrayList, fallbackLayers != null ? toLayerGroup(fallbackLayers) : null);
    }
}