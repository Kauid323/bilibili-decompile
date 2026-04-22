package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0011\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/common/ouro/core/dsl/QuoteBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "quoteBlock", "Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroQuoteBlock;)V", "Text", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/ParagraphBuilder;", "Lkotlin/ExtensionFunctionType;", "H1", "H2", "H3", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class QuoteBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroQuoteBlock quoteBlock;

    public QuoteBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroQuoteBlock quoteBlock) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(quoteBlock, "quoteBlock");
        this.builder = ouroNodeMutableStorage;
        this.quoteBlock = quoteBlock;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Text$default(QuoteBuilder quoteBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        quoteBuilder.Text(ouroMarks2, function1);
    }

    public final void Text(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroText paragraph = new OuroText(ouroMarks);
        OuroNodeMutableStorage $this$Text_u24lambda_u240 = this.builder;
        $this$Text_u24lambda_u240.addChild((OuroNode.Parent<OuroQuoteBlock>) this.quoteBlock, (OuroQuoteBlock) paragraph);
        function1.invoke(new ParagraphBuilder(this.builder, paragraph));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H1$default(QuoteBuilder quoteBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        quoteBuilder.H1(ouroMarks2, function1);
    }

    public final void H1(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH1 h1 = new OuroH1(ouroMarks);
        OuroNodeMutableStorage $this$H1_u24lambda_u240 = this.builder;
        $this$H1_u24lambda_u240.addChild((OuroNode.Parent<OuroQuoteBlock>) this.quoteBlock, (OuroQuoteBlock) h1);
        function1.invoke(new ParagraphBuilder(this.builder, h1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H2$default(QuoteBuilder quoteBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        quoteBuilder.H2(ouroMarks2, function1);
    }

    public final void H2(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH2 h2 = new OuroH2(ouroMarks);
        OuroNodeMutableStorage $this$H2_u24lambda_u240 = this.builder;
        $this$H2_u24lambda_u240.addChild((OuroNode.Parent<OuroQuoteBlock>) this.quoteBlock, (OuroQuoteBlock) h2);
        function1.invoke(new ParagraphBuilder(this.builder, h2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H3$default(QuoteBuilder quoteBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        quoteBuilder.H3(ouroMarks2, function1);
    }

    public final void H3(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH3 h3 = new OuroH3(ouroMarks);
        OuroNodeMutableStorage $this$H3_u24lambda_u240 = this.builder;
        $this$H3_u24lambda_u240.addChild((OuroNode.Parent<OuroQuoteBlock>) this.quoteBlock, (OuroQuoteBlock) h3);
        function1.invoke(new ParagraphBuilder(this.builder, h3));
    }
}