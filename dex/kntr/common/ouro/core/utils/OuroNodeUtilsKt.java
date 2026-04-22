package kntr.common.ouro.core.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;

/* compiled from: OuroNodeUtils.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0000\u001a\u001d\u0010\u0005\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0001\u001a\u001d\u0010\u0007\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0002\u001a\u001d\u0010\t\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0003\u001a\u001d\u0010\u000b\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0004\u001a\u001d\u0010\r\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0005\u001a\u001d\u0010\u000f\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0082\u0002\n\n\b\b\u0000\u001a\u0004\u0010\u0001(\u0006ò\u0001(\n\u0006\u0012\u0002\b\u00030\u0004\n\u00020\u0006\n\u00020\b\n\u00020\n\n\u00020\f\n\u0006\u0012\u0002\b\u00030\u000e\n\u0006\u0012\u0002\b\u00030\u0010¨\u0006\u0011"}, d2 = {"isElement", "", "node", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/node/OuroNode$Element;", "isSelectable", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "isSeparable", "Lkntr/common/ouro/core/model/node/OuroNode$Separable;", "isMergeable", "Lkntr/common/ouro/core/model/node/OuroNode$Mergeable;", "isAbsorbable", "Lkntr/common/ouro/core/model/node/OuroNode$Absorbable;", "isMarkable", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "isOuroParent", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroNodeUtilsKt {
    public static final boolean isElement(OuroNode node) {
        return node instanceof OuroNode.Element;
    }

    public static final boolean isSelectable(OuroNode node) {
        return node instanceof OuroNode.Selectable;
    }

    public static final boolean isSeparable(OuroNode node) {
        return node instanceof OuroNode.Separable;
    }

    public static final boolean isMergeable(OuroNode node) {
        return node instanceof OuroNode.Mergeable;
    }

    public static final boolean isAbsorbable(OuroNode node) {
        return node instanceof OuroNode.Absorbable;
    }

    public static final boolean isMarkable(OuroNode node) {
        return node instanceof OuroNode.Markable;
    }

    public static final boolean isOuroParent(OuroNode node) {
        return node instanceof OuroNode.Parent;
    }
}