package kntr.compose.avatar.model.layers;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.layers.LayerResource;
import kotlin.Metadata;

/* compiled from: Layer.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lkntr/compose/avatar/model/layers/PluginResource;", "Lkntr/compose/avatar/model/layers/LayerResource;", "<init>", "()V", "resType", "Lkntr/compose/avatar/model/layers/ResType;", "getResType", "()Lkntr/compose/avatar/model/layers/ResType;", "shouldDraw", "", "getShouldDraw", "()Z", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PluginResource implements LayerResource {
    public static final PluginResource INSTANCE = new PluginResource();

    private PluginResource() {
    }

    @Override // kntr.compose.avatar.model.layers.LayerResource
    public /* bridge */ String getSourceDesc() {
        return LayerResource.CC.$default$getSourceDesc(this);
    }

    @Override // kntr.compose.avatar.model.layers.LayerResource
    public ResType getResType() {
        return ResType.Plugin;
    }

    @Override // kntr.compose.avatar.model.layers.LayerResource
    public boolean getShouldDraw() {
        return false;
    }
}