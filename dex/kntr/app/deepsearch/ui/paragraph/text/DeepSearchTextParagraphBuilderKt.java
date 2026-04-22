package kntr.app.deepsearch.ui.paragraph.text;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bilibili.common.paragraph.action.ParagraphClickListener;
import com.bilibili.common.paragraph.impl.text.TextParagraphClickListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DeepSearchTextParagraphBuilder.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\b\u0012\u0004\u0012\u00020\b0\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", RoomRecommendViewModel.EMPTY_CURSOR, "asTextClickListener", "Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;", "Lcom/bilibili/common/paragraph/action/ParagraphClickListener;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "mergeRange", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/text/TextRange;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchTextParagraphBuilderKt {
    private static final String TAG = "DeepSearchTextParagraphBuilder";

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextParagraphClickListener asTextClickListener(ParagraphClickListener<? super KParagraph.KText> paragraphClickListener) {
        if (paragraphClickListener instanceof TextParagraphClickListener) {
            return (TextParagraphClickListener) paragraphClickListener;
        }
        return null;
    }

    public static final List<TextRange> mergeRange(List<TextRange> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<TextRange> $this$sortedBy$iv = list;
        List sorted = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.deepsearch.ui.paragraph.text.DeepSearchTextParagraphBuilderKt$mergeRange$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                long it = ((TextRange) t).unbox-impl();
                long it2 = ((TextRange) t2).unbox-impl();
                return ComparisonsKt.compareValues(Integer.valueOf(TextRange.getStart-impl(it)), Integer.valueOf(TextRange.getStart-impl(it2)));
            }
        });
        List res = new ArrayList();
        res.add(CollectionsKt.first(sorted));
        List $this$forEachIndexed$iv = sorted;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            long it = ((TextRange) item$iv).unbox-impl();
            long last = ((TextRange) CollectionsKt.last(res)).unbox-impl();
            if (TextRange.getStart-impl(it) <= TextRange.getEnd-impl(last) + 1) {
                int start = TextRange.getStart-impl(last);
                int end = RangesKt.coerceAtLeast(TextRange.getEnd-impl(it), TextRange.getEnd-impl(last));
                res.remove(res.size() - 1);
                res.add(TextRange.box-impl(TextRangeKt.TextRange(start, end)));
            } else {
                res.add(TextRange.box-impl(it));
            }
            index$iv = index$iv2;
        }
        return CollectionsKt.toList(res);
    }
}