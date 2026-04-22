package kntr.common.ouro.core.dsl;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.renderable.OuroDivider;
import kntr.common.ouro.core.model.node.renderable.OuroUnrecognizedCard;
import kntr.common.ouro.core.utils.OuroLayoutUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0011\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0012\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0013\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J/\u0010\u0014\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010JR\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J\u001f\u0010 \u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J\u0006\u0010\"\u001a\u00020\tJ\u0006\u0010#\u001a\u00020\tR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkntr/common/ouro/core/dsl/DocumentBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "document", "Lkntr/common/ouro/core/model/node/OuroDocument;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroDocument;)V", "H1", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/ParagraphBuilder;", "Lkotlin/ExtensionFunctionType;", "H2", "H3", "Text", "Quote", "Lkntr/common/ouro/core/dsl/QuoteBuilder;", "BoxContainer", "padding", "", "aspectRatio", "size", "Lkotlin/Pair;", "Lkntr/common/ouro/core/dsl/BoxContainerBuilder;", "(FLjava/lang/Float;Lkotlin/Pair;Lkotlin/jvm/functions/Function1;)V", "OrderedList", "Lkntr/common/ouro/core/dsl/OrderedListBuilder;", "UnorderedList", "Lkntr/common/ouro/core/dsl/UnorderedListBuilder;", "Divider", "UnrecognizedCard", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DocumentBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroDocument document;

    public DocumentBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroDocument document) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(document, "document");
        this.builder = ouroNodeMutableStorage;
        this.document = document;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H1$default(DocumentBuilder documentBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        documentBuilder.H1(ouroMarks2, function1);
    }

    public final void H1(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH1 h1 = new OuroH1(ouroMarks);
        OuroNodeMutableStorage $this$H1_u24lambda_u240 = this.builder;
        $this$H1_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) h1);
        function1.invoke(new ParagraphBuilder(this.builder, h1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H2$default(DocumentBuilder documentBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        documentBuilder.H2(ouroMarks2, function1);
    }

    public final void H2(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH2 h2 = new OuroH2(ouroMarks);
        OuroNodeMutableStorage $this$H2_u24lambda_u240 = this.builder;
        $this$H2_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) h2);
        function1.invoke(new ParagraphBuilder(this.builder, h2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void H3$default(DocumentBuilder documentBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        documentBuilder.H3(ouroMarks2, function1);
    }

    public final void H3(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroH3 h3 = new OuroH3(ouroMarks);
        OuroNodeMutableStorage $this$H3_u24lambda_u240 = this.builder;
        $this$H3_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) h3);
        function1.invoke(new ParagraphBuilder(this.builder, h3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Text$default(DocumentBuilder documentBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        documentBuilder.Text(ouroMarks2, function1);
    }

    public final void Text(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroText text = new OuroText(ouroMarks);
        OuroNodeMutableStorage $this$Text_u24lambda_u240 = this.builder;
        $this$Text_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) text);
        function1.invoke(new ParagraphBuilder(this.builder, text));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Quote$default(DocumentBuilder documentBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        documentBuilder.Quote(ouroMarks2, function1);
    }

    public final void Quote(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super QuoteBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroQuoteBlock quoteBlock = new OuroQuoteBlock(ouroMarks);
        OuroNodeMutableStorage $this$Quote_u24lambda_u240 = this.builder;
        $this$Quote_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) quoteBlock);
        function1.invoke(new QuoteBuilder(this.builder, quoteBlock));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void BoxContainer$default(DocumentBuilder documentBuilder, float f, Float f2, Pair pair, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = null;
        }
        if ((i & 4) != 0) {
            pair = null;
        }
        documentBuilder.BoxContainer(f, f2, pair, function1);
    }

    public final void BoxContainer(float padding, Float aspectRatio, Pair<Float, Float> pair, Function1<? super BoxContainerBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        List marks = new ArrayList();
        if (padding > 0.0f) {
            marks.add(new OuroDrawableMark.Padding(padding, padding, padding, padding));
        }
        if (aspectRatio != null) {
            float it = aspectRatio.floatValue();
            marks.add(new OuroDrawableMark.Size.AspectRatio(it));
        }
        if (pair != null) {
            marks.add(new OuroDrawableMark.Size.Specified(pair.getFirst().floatValue(), pair.getSecond().floatValue()));
        }
        OuroBoxContainer container = new OuroBoxContainer(new OuroMarks(CollectionsKt.toList(marks)));
        OuroNodeMutableStorage $this$BoxContainer_u24lambda_u242 = this.builder;
        $this$BoxContainer_u24lambda_u242.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) container);
        function1.invoke(new BoxContainerBuilder(this.builder, container));
    }

    public final void OrderedList(Function1<? super OrderedListBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroOrderedList orderedList = new OuroOrderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$OrderedList_u24lambda_u240 = this.builder;
        $this$OrderedList_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) orderedList);
        function1.invoke(new OrderedListBuilder(this.builder, orderedList));
    }

    public final void UnorderedList(Function1<? super UnorderedListBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroUnorderedList unorderedList = new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$UnorderedList_u24lambda_u240 = this.builder;
        $this$UnorderedList_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) unorderedList);
        function1.invoke(new UnorderedListBuilder(this.builder, unorderedList));
    }

    public final void Divider() {
        OuroNodeMutableStorage $this$Divider_u24lambda_u240 = this.builder;
        OuroBoxContainer boxContainerBuilder = new OuroBoxContainer(OuroLayoutUtilsKt.getDividerDefaultMarks());
        OuroDivider divider = new OuroDivider((String) null, 1, (DefaultConstructorMarker) null);
        $this$Divider_u24lambda_u240.add(boxContainerBuilder, divider);
        $this$Divider_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) boxContainerBuilder);
    }

    public final void UnrecognizedCard() {
        OuroNodeMutableStorage $this$UnrecognizedCard_u24lambda_u240 = this.builder;
        OuroBoxContainer boxContainerBuilder = new OuroBoxContainer(OuroLayoutUtilsKt.getUnrecognizedCardDefaultMarks());
        OuroUnrecognizedCard card = new OuroUnrecognizedCard(StringsKt.encodeToByteArray("UnrecognizedCard"), (String) null, 2, (DefaultConstructorMarker) null);
        $this$UnrecognizedCard_u24lambda_u240.add(boxContainerBuilder, card);
        $this$UnrecognizedCard_u24lambda_u240.addChild((OuroNode.Parent<OuroDocument>) this.document, (OuroDocument) boxContainerBuilder);
    }
}