package kntr.common.ouro.core.model.node.drawable;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawable.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;", "M", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/drawable/OuroDrawableChild;", "castChildOrNull", "other", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroDrawable<M extends OuroDrawableMark> extends OuroNode, OuroNode.Markable<M>, OuroNode.Parent<OuroDrawableChild> {
    OuroDrawableChild castChildOrNull(OuroNode ouroNode);

    /* compiled from: OuroDrawable.kt */
    /* renamed from: kntr.common.ouro.core.model.node.drawable.OuroDrawable$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ OuroDrawableChild access$castChild$jd(OuroDrawable $this, OuroNode other) {
            return (OuroDrawableChild) OuroNode.Parent.CC.$default$castChild($this, other);
        }

        /* renamed from: $default$castChildOrNull */
        public static OuroDrawableChild m2014$default$castChildOrNull(OuroDrawable _this, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof OuroDrawableChild) {
                return (OuroDrawableChild) other;
            }
            return null;
        }
    }

    /* compiled from: OuroDrawable.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <M extends OuroDrawableMark> OuroDrawableChild castChild(OuroDrawable<M> ouroDrawable, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.access$castChild$jd(ouroDrawable, other);
        }

        @Deprecated
        public static <M extends OuroDrawableMark> boolean isValidParentOf(OuroDrawable<M> ouroDrawable, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return OuroNode.Parent.CC.$default$isValidParentOf(ouroDrawable, other);
        }

        @Deprecated
        public static <M extends OuroDrawableMark> Pair<OuroNode.Parent<OuroDrawableChild>, OuroNode.Parent<OuroDrawableChild>> tryDivide(OuroDrawable<M> ouroDrawable) {
            return OuroNode.Parent.CC.$default$tryDivide(ouroDrawable);
        }

        @Deprecated
        public static <M extends OuroDrawableMark> OuroDrawableChild castChildOrNull(OuroDrawable<M> ouroDrawable, OuroNode other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.m2014$default$castChildOrNull((OuroDrawable) ouroDrawable, other);
        }
    }
}