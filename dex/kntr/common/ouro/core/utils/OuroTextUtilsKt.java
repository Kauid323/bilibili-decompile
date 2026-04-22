package kntr.common.ouro.core.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: OuroTextUtils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\u0007"}, d2 = {"toOuroTextWithHardBreaks", "", "Lkntr/common/ouro/core/model/node/OuroTextElement;", "", "textMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextUtilsKt {
    public static final List<OuroTextElement> toOuroTextWithHardBreaks(String $this$toOuroTextWithHardBreaks, OuroMarks<OuroTextMark> ouroMarks) {
        OuroTextElement plain;
        Intrinsics.checkNotNullParameter($this$toOuroTextWithHardBreaks, "<this>");
        Intrinsics.checkNotNullParameter(ouroMarks, "textMarks");
        Regex regex = new Regex("(?<=\n)|(?=\n)");
        Iterable parts = regex.split($this$toOuroTextWithHardBreaks, 0);
        Iterable $this$filter$iv = parts;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            String it = (String) element$iv$iv;
            if (it.length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String item = (String) item$iv$iv;
            if (Intrinsics.areEqual(item, "\n")) {
                plain = new OuroTextElement.HardBreak(ouroMarks);
            } else {
                plain = new OuroTextElement.Plain(item, ouroMarks);
            }
            destination$iv$iv2.add(plain);
        }
        return (List) destination$iv$iv2;
    }
}