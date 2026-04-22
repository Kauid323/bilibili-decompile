package kntr.compose.avatar.parser.protobuf;

import com.bapis.bilibili.dagw.component.avatar.common.KColorConfig;
import com.bapis.bilibili.dagw.component.avatar.common.KColorSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KLayerGeneralSpec;
import com.bapis.bilibili.dagw.component.avatar.common.KMaskProperty;
import com.bapis.bilibili.dagw.component.avatar.common.KResourceSource;
import com.bapis.bilibili.dagw.component.avatar.v1.KBasicLayerResource;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.compose.avatar.model.common.ARGBColor;
import kntr.compose.avatar.model.common.ColorConfig;
import kntr.compose.avatar.model.common.DrawSource;
import kntr.compose.avatar.model.common.IResource;
import kntr.compose.avatar.model.common.InvalidResource;
import kntr.compose.avatar.model.common.LayerGeneralSpec;
import kntr.compose.avatar.model.common.LocalSource;
import kntr.compose.avatar.model.common.LocalSourceEnum;
import kntr.compose.avatar.model.common.SourceType;
import kntr.compose.avatar.model.common.UrlResource;
import kntr.compose.avatar.model.layers.AnimationResource;
import kntr.compose.avatar.model.layers.EmptyResource;
import kntr.compose.avatar.model.layers.ImageResource;
import kntr.compose.avatar.model.layers.InvalidLayerResource;
import kntr.compose.avatar.model.layers.LayerResource;
import kntr.compose.avatar.model.layers.MaskProperty;
import kntr.compose.avatar.model.layers.NativeDrawResource;
import kntr.compose.avatar.model.layers.PluginResource;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: Resource.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u000e\u0010\f\u001a\u00020\r*\u00060\u000bj\u0002`\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u000f\u001a\u00020\u0015*\u00020\u0016*\n\u0010\n\"\u00020\u000b2\u00020\u000b¨\u0006\u0017"}, d2 = {"toColor", "Lkntr/compose/avatar/model/common/ColorConfig;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KColorConfig;", "parseColor", "Lkntr/compose/avatar/model/common/ARGBColor;", "", "(Ljava/lang/String;)I", "toLocalSourceEnum", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KResourceSource$KLocalRes;", "PBSourceType", "Lcom/bapis/bilibili/dagw/component/avatar/common/KResourceSource$KSourceType;", "toType", "Lkntr/compose/avatar/model/common/SourceType;", "Lkntr/compose/avatar/parser/protobuf/PBSourceType;", "toResource", "Lkntr/compose/avatar/model/common/IResource;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KResourceSource;", "toMask", "Lkntr/compose/avatar/model/layers/MaskProperty;", "Lcom/bapis/bilibili/dagw/component/avatar/common/KMaskProperty;", "Lkntr/compose/avatar/model/layers/LayerResource;", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KBasicLayerResource;", "parser_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ResourceKt {
    public static final ColorConfig toColor(KColorConfig $this$toColor) {
        String argb;
        String argb2;
        if ($this$toColor == null) {
            return new ColorConfig(false, null, null, 7, null);
        }
        boolean isDarkModeAware = $this$toColor.isDarkModeAware();
        KColorSpec day = $this$toColor.getDay();
        ARGBColor m2525boximpl = (day == null || (argb2 = day.getArgb()) == null) ? null : ARGBColor.m2525boximpl(parseColor(argb2));
        KColorSpec night = $this$toColor.getNight();
        return new ColorConfig(isDarkModeAware, m2525boximpl, (night == null || (argb = night.getArgb()) == null) ? null : ARGBColor.m2525boximpl(parseColor(argb)), null);
    }

    public static final int parseColor(String $this$parseColor) {
        int a;
        Intrinsics.checkNotNullParameter($this$parseColor, "<this>");
        try {
            List colorFields = CollectionsKt.toMutableList(StringsKt.chunked(StringsKt.substringAfter$default($this$parseColor, "#", (String) null, 2, (Object) null), 2));
            if (colorFields.size() == 4) {
                a = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            } else {
                a = KotlinVersion.MAX_COMPONENT_VALUE;
            }
            int r = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            int g = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            int b = Integer.parseInt((String) colorFields.remove(0), CharsKt.checkRadix(16));
            return ARGBColor.m2526constructorimpl((a << 24) | (r << 16) | (g << 8) | b);
        } catch (Exception e) {
            KLog_androidKt.getKLog().e("AvatarProtoParser", "Fail to parse color " + $this$parseColor, e);
            return ARGBColor.Companion.m2532getTransparentLQWBnzc();
        }
    }

    public static final LocalSourceEnum toLocalSourceEnum(KResourceSource.KLocalRes $this$toLocalSourceEnum) {
        Intrinsics.checkNotNullParameter($this$toLocalSourceEnum, "<this>");
        return Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_ICON_VIP.INSTANCE) ? LocalSourceEnum.Vip : Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_ICON_SMALL_VIP.INSTANCE) ? LocalSourceEnum.SmallVip : Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_ICON_PERSONAL_VERIFY.INSTANCE) ? LocalSourceEnum.PersonalVerify : Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_ICON_ENTERPRISE_VERIFY.INSTANCE) ? LocalSourceEnum.EnterpriseVerify : Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_ICON_NFT_MAINLAND.INSTANCE) ? LocalSourceEnum.MainlandNft : Intrinsics.areEqual($this$toLocalSourceEnum, KResourceSource.KLocalRes.LOCAL_RES_DEFAULT_AVATAR.INSTANCE) ? LocalSourceEnum.DefaultAvatar : LocalSourceEnum.Invalid;
    }

    public static final SourceType toType(KResourceSource.KSourceType $this$toType) {
        Intrinsics.checkNotNullParameter($this$toType, "<this>");
        return Intrinsics.areEqual($this$toType, KResourceSource.KSourceType.SRC_TYPE_URL.INSTANCE) ? SourceType.URLSource : Intrinsics.areEqual($this$toType, KResourceSource.KSourceType.SRC_TYPE_LOCAL.INSTANCE) ? SourceType.LocalSource : Intrinsics.areEqual($this$toType, KResourceSource.KSourceType.SRC_TYPE_DRAW.INSTANCE) ? SourceType.NativeDrawSource : SourceType.InvalidSource;
    }

    public static final IResource toResource(KResourceSource $this$toResource) {
        Intrinsics.checkNotNullParameter($this$toResource, "<this>");
        toType($this$toResource.getSrcType());
        LocalSourceEnum placeHolder = toLocalSourceEnum($this$toResource.getPlaceholder());
        KResourceSource.KLocal res = $this$toResource.getRes();
        if (res instanceof KResourceSource.KLocal) {
            return new LocalSource(toLocalSourceEnum(res.getValue()));
        }
        if (res instanceof KResourceSource.KRemote) {
            return new UrlResource(((KResourceSource.KRemote) res).getValue().getUrl(), ((KResourceSource.KRemote) res).getValue().getBfsStyle(), placeHolder);
        }
        if (res instanceof KResourceSource.KDraw) {
            return new DrawSource(NativeDrawKt.toDrawType(((KResourceSource.KDraw) res).getValue().getDrawType()), NativeDrawKt.toFillMode(((KResourceSource.KDraw) res).getValue().getFillMode()), toColor(((KResourceSource.KDraw) res).getValue().getColorConfig()), (float) ((KResourceSource.KDraw) res).getValue().getEdgeWeight());
        }
        return InvalidResource.INSTANCE;
    }

    public static final MaskProperty toMask(KMaskProperty $this$toMask) {
        LayerGeneralSpec layerGeneralSpec;
        InvalidResource invalidResource;
        Intrinsics.checkNotNullParameter($this$toMask, "<this>");
        KLayerGeneralSpec generalSpec = $this$toMask.getGeneralSpec();
        if (generalSpec == null || (layerGeneralSpec = CoordinateKt.toLayerGeneralSpec(generalSpec)) == null) {
            layerGeneralSpec = new LayerGeneralSpec(null, null, null, 7, null);
        }
        KResourceSource maskSrc = $this$toMask.getMaskSrc();
        if (maskSrc == null || (invalidResource = toResource(maskSrc)) == null) {
            invalidResource = InvalidResource.INSTANCE;
        }
        return new MaskProperty(layerGeneralSpec, invalidResource);
    }

    public static final LayerResource toResource(KBasicLayerResource $this$toResource) {
        KResourceSource webpSrc;
        IResource it;
        KResourceSource imageSrc;
        IResource it2;
        Intrinsics.checkNotNullParameter($this$toResource, "<this>");
        $this$toResource.getPayload();
        KBasicLayerResource.KResType resType = $this$toResource.getResType();
        if (Intrinsics.areEqual(resType, KBasicLayerResource.KResType.RES_TYPE_PLUGIN.INSTANCE)) {
            return PluginResource.INSTANCE;
        }
        if (Intrinsics.areEqual(resType, KBasicLayerResource.KResType.RES_TYPE_EMPTY.INSTANCE)) {
            return EmptyResource.INSTANCE;
        }
        ImageResource imageResource = null;
        if (Intrinsics.areEqual(resType, KBasicLayerResource.KResType.RES_TYPE_IMAGE.INSTANCE)) {
            KBasicLayerResource.KResImage payload = $this$toResource.getPayload();
            if ((payload instanceof KBasicLayerResource.KResImage) && (imageSrc = payload.getValue().getImageSrc()) != null && (it2 = toResource(imageSrc)) != null) {
                imageResource = new ImageResource(it2);
            }
            return imageResource != null ? imageResource : InvalidLayerResource.INSTANCE;
        } else if (Intrinsics.areEqual(resType, KBasicLayerResource.KResType.RES_TYPE_ANIMATION.INSTANCE)) {
            KBasicLayerResource.KResAnimation payload2 = $this$toResource.getPayload();
            if ((payload2 instanceof KBasicLayerResource.KResAnimation) && (webpSrc = payload2.getValue().getWebpSrc()) != null && (it = toResource(webpSrc)) != null) {
                imageResource = new AnimationResource(it);
            }
            return imageResource != null ? imageResource : InvalidLayerResource.INSTANCE;
        } else if (Intrinsics.areEqual(resType, KBasicLayerResource.KResType.RES_TYPE_NATIVE_DRAW.INSTANCE)) {
            KBasicLayerResource.KResNativeDraw payload3 = $this$toResource.getPayload();
            if (payload3 instanceof KBasicLayerResource.KResNativeDraw) {
                KResourceSource drawSrc = payload3.getValue().getDrawSrc();
                IResource resource = drawSrc != null ? toResource(drawSrc) : null;
                DrawSource it3 = resource instanceof DrawSource ? (DrawSource) resource : null;
                if (it3 != null) {
                    imageResource = new NativeDrawResource(it3);
                }
            }
            return imageResource != null ? imageResource : InvalidLayerResource.INSTANCE;
        } else {
            return InvalidLayerResource.INSTANCE;
        }
    }
}