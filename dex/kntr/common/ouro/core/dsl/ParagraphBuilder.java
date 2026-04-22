package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.OuroUniversalLink;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0016\u0010\u000f\u001a\u00020\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ'\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0015J3\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00182\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0015R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lkntr/common/ouro/core/dsl/ParagraphBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "paragraph", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroParagraph;)V", "Plain", "", "content", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "HardBreak", "Link", "href", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/LinkBuilder;", "Lkotlin/ExtensionFunctionType;", "InlineContent", "size", "Lkotlin/Pair;", "", "Lkntr/common/ouro/core/dsl/InlineContentBuilder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ParagraphBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroParagraph paragraph;

    public ParagraphBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroParagraph paragraph) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(paragraph, "paragraph");
        this.builder = ouroNodeMutableStorage;
        this.paragraph = paragraph;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Plain$default(ParagraphBuilder paragraphBuilder, String str, OuroMarks ouroMarks, int i, Object obj) {
        if ((i & 2) != 0) {
            ouroMarks = new OuroMarks(null, 1, null);
        }
        paragraphBuilder.Plain(str, ouroMarks);
    }

    public final void Plain(String content, OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        OuroTextElement.Plain plain = new OuroTextElement.Plain(content, ouroMarks);
        OuroNodeMutableStorage $this$Plain_u24lambda_u240 = this.builder;
        $this$Plain_u24lambda_u240.addChild((OuroNode.Parent<OuroParagraph>) this.paragraph, (OuroParagraph) plain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void HardBreak$default(ParagraphBuilder paragraphBuilder, OuroMarks ouroMarks, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroMarks = new OuroMarks(null, 1, null);
        }
        paragraphBuilder.HardBreak(ouroMarks);
    }

    public final void HardBreak(OuroMarks<OuroTextMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        OuroTextElement.HardBreak hardBreak = new OuroTextElement.HardBreak(ouroMarks);
        OuroNodeMutableStorage $this$HardBreak_u24lambda_u240 = this.builder;
        $this$HardBreak_u24lambda_u240.addChild((OuroNode.Parent<OuroParagraph>) this.paragraph, (OuroParagraph) hardBreak);
    }

    public final void Link(String href, Function1<? super LinkBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(href, "href");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroUniversalLink link = new OuroUniversalLink(href, (byte[]) null, 2, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$Link_u24lambda_u240 = this.builder;
        $this$Link_u24lambda_u240.addChild((OuroNode.Parent<OuroParagraph>) this.paragraph, (OuroParagraph) link);
        function1.invoke(new LinkBuilder(this.builder, link));
    }

    public final void InlineContent(Pair<Float, Float> pair, Function1<? super InlineContentBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(pair, "size");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroMarks marks = new OuroMarks(new OuroDrawableMark.Size.Specified(pair.getFirst().floatValue(), pair.getSecond().floatValue()));
        OuroInlineContent inlineContent = new OuroInlineContent(marks);
        OuroNodeMutableStorage $this$InlineContent_u24lambda_u240 = this.builder;
        $this$InlineContent_u24lambda_u240.addChild((OuroNode.Parent<OuroParagraph>) this.paragraph, (OuroParagraph) inlineContent);
        function1.invoke(new InlineContentBuilder(this.builder, inlineContent));
    }
}