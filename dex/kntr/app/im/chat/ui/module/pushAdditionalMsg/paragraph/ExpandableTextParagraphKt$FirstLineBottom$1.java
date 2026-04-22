package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ExpandableTextParagraph.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ExpandableTextParagraphKt$FirstLineBottom$1 extends FunctionReferenceImpl implements Function2<Integer, Integer, Integer> {
    public static final ExpandableTextParagraphKt$FirstLineBottom$1 INSTANCE = new ExpandableTextParagraphKt$FirstLineBottom$1();

    ExpandableTextParagraphKt$FirstLineBottom$1() {
        super(2, ComparisonsKt.class, "minOf", "minOf(II)I", 1);
    }

    public final Integer invoke(int p0, int p1) {
        return Integer.valueOf(Math.min(p0, p1));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        return invoke(((Number) p1).intValue(), ((Number) p2).intValue());
    }
}