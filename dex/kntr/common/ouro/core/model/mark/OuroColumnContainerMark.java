package kntr.common.ouro.core.model.mark;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.MergeRule;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;

/* compiled from: OuroDrawableMark.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0002\u0002\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/mark/OuroColumnContainerMark;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroColumnContainerMark extends OuroDrawableMark {

    /* compiled from: OuroDrawableMark.kt */
    /* renamed from: kntr.common.ouro.core.model.mark.OuroColumnContainerMark$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: OuroDrawableMark.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static MergeRule.Override getMergeRule(OuroColumnContainerMark $this) {
            return OuroMark.Override.CC.$default$getMergeRule((OuroMark.Override) $this);
        }
    }
}