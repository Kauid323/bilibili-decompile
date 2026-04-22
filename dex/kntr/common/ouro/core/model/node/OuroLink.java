package kntr.common.ouro.core.model.node;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroLink.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/OuroLink;", "META", "Lkntr/common/ouro/core/model/node/OuroNode$BuiltIn;", "Lkntr/common/ouro/core/model/node/OuroNode$DeleteConfirm;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkntr/common/ouro/core/model/node/OuroNode$Element;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroLinkChild;", "Lkntr/common/ouro/core/model/node/OuroParagraphChild;", "castChildOrNull", "other", "Lkntr/common/ouro/core/model/node/OuroNode;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroLink<META> extends OuroNode.BuiltIn, OuroNode.DeleteConfirm, OuroNode.Selectable, OuroNode.Element<META>, OuroNode.Parent<OuroLinkChild>, OuroParagraphChild {
    OuroLinkChild castChildOrNull(OuroNode ouroNode);

    /* compiled from: OuroLink.kt */
    /* renamed from: kntr.common.ouro.core.model.node.OuroLink$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ OuroLinkChild access$castChild$jd(OuroLink $this, OuroNode other) {
            return (OuroLinkChild) OuroNode.Parent.CC.$default$castChild($this, other);
        }

        public static OuroLinkChild $default$castChildOrNull(OuroLink _this, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof OuroLinkChild) {
                return (OuroLinkChild) other;
            }
            return null;
        }
    }

    /* compiled from: OuroLink.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <META> OuroLinkChild castChild(OuroLink<META> ouroLink, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.access$castChild$jd(ouroLink, other);
        }

        @Deprecated
        public static <META> boolean isValidParentOf(OuroLink<META> ouroLink, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return OuroNode.Parent.CC.$default$isValidParentOf(ouroLink, other);
        }

        @Deprecated
        public static <META> Pair<OuroNode.Parent<OuroLinkChild>, OuroNode.Parent<OuroLinkChild>> tryDivide(OuroLink<META> ouroLink) {
            return OuroNode.Parent.CC.$default$tryDivide(ouroLink);
        }

        @Deprecated
        public static <META> OuroLinkChild castChildOrNull(OuroLink<META> ouroLink, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.$default$castChildOrNull((OuroLink) ouroLink, other);
        }
    }
}