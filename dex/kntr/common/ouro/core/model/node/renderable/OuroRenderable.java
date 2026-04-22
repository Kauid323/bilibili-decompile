package kntr.common.ouro.core.model.node.renderable;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroDrawableChild;
import kotlin.Metadata;

/* compiled from: OuroRenderable.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRenderable;", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/node/drawable/OuroDrawableChild;", "reuseIdentifier", "", "getReuseIdentifier", "()Ljava/lang/String;", "BuiltIn", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroRenderable extends OuroNode, OuroDrawableChild {

    /* compiled from: OuroRenderable.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0004\u0002\u0003\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRenderable$BuiltIn;", "Lkntr/common/ouro/core/model/node/renderable/OuroRenderable;", "Lkntr/common/ouro/core/model/node/renderable/OuroDivider;", "Lkntr/common/ouro/core/model/node/renderable/OuroLocalImage;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "Lkntr/common/ouro/core/model/node/renderable/OuroUnrecognizedCard;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface BuiltIn extends OuroRenderable {
    }

    String getReuseIdentifier();
}