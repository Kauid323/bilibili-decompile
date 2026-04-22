package kntr.common.ouro.core.plugin.paragraphStyle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroText;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Reflection;

/* compiled from: OuroParagraphStylePlugin.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¨\u0006\u0004"}, d2 = {"intersectParagraphType", "Lkntr/common/ouro/core/plugin/paragraphStyle/ParagraphType;", "", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroParagraphStylePluginKt {
    public static final /* synthetic */ ParagraphType access$intersectParagraphType(List $receiver) {
        return intersectParagraphType($receiver);
    }

    public static final ParagraphType intersectParagraphType(List<? extends OuroParagraph> list) {
        OuroParagraph paragraph;
        List<? extends OuroParagraph> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(Reflection.getOrCreateKotlinClass(((OuroParagraph) item$iv$iv).getClass()));
        }
        List it = CollectionsKt.distinct((List) destination$iv$iv);
        if (!(it.size() == 1)) {
            it = null;
        }
        if (it == null || (paragraph = (OuroParagraph) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        if (paragraph instanceof OuroH1) {
            return ParagraphType.H1;
        }
        if (paragraph instanceof OuroH2) {
            return ParagraphType.H2;
        }
        if (paragraph instanceof OuroH3) {
            return ParagraphType.H3;
        }
        if (paragraph instanceof OuroText) {
            return ParagraphType.TEXT;
        }
        throw new NoWhenBranchMatchedException();
    }
}