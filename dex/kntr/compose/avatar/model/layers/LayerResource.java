package kntr.compose.avatar.model.layers;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: Layer.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0001\u0004\u000e\u000f\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/compose/avatar/model/layers/LayerResource;", "", "resType", "Lkntr/compose/avatar/model/layers/ResType;", "getResType", "()Lkntr/compose/avatar/model/layers/ResType;", "shouldDraw", "", "getShouldDraw", "()Z", "sourceDesc", "", "getSourceDesc", "()Ljava/lang/String;", "Lkntr/compose/avatar/model/layers/EmptyResource;", "Lkntr/compose/avatar/model/layers/InvalidLayerResource;", "Lkntr/compose/avatar/model/layers/PluginResource;", "Lkntr/compose/avatar/model/layers/ValidResource;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface LayerResource {
    ResType getResType();

    boolean getShouldDraw();

    String getSourceDesc();

    /* compiled from: Layer.kt */
    /* renamed from: kntr.compose.avatar.model.layers.LayerResource$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static String $default$getSourceDesc(LayerResource _this) {
            return "Invalid";
        }
    }

    /* compiled from: Layer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static String getSourceDesc(LayerResource $this) {
            return CC.$default$getSourceDesc($this);
        }
    }
}