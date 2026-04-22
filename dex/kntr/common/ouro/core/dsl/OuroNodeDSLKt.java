package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroBoxContainerMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroLineHeightMark;
import kntr.common.ouro.core.model.mark.OuroLineHeightStyle;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroTextSpacingMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u00012\u0006\u0010\u001a\u001a\u00020\u0011\u001a\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00012\u0006\u0010\u001a\u001a\u00020\u0011\u001a \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00012\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u0011\u001a7\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00012\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(\u001a5\u0010)\u001a\b\u0012\u0004\u0012\u00020*0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020+0\u00012\u0019\b\u0002\u0010$\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020'0%¢\u0006\u0002\b(\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0004\"\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0004\"\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0004¨\u0006-"}, d2 = {"Bold", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getBold", "()Lkntr/common/ouro/core/model/mark/OuroMarks;", "Italic", "getItalic", "Strikethrough", "getStrikethrough", "Underline", "getUnderline", "ForegroundColor", "color", "Lkntr/common/ouro/core/model/mark/OuroColor;", "BackgroundColor", "Kern", "spacing", "", "AlignStart", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "getAlignStart", "AlignCenter", "getAlignCenter", "AlignEnd", "getAlignEnd", "LineHeightDp", "h", "LineHeightFactor", "Indent", "first", "rest", "Document", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "marks", "Lkntr/common/ouro/core/model/mark/OuroMark;", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/DocumentBuilder;", "", "Lkotlin/ExtensionFunctionType;", "BoxContainer", "Lkntr/common/ouro/core/model/node/drawable/OuroBoxContainer;", "Lkntr/common/ouro/core/model/mark/OuroBoxContainerMark;", "Lkntr/common/ouro/core/dsl/BoxContainerBuilder;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroNodeDSLKt {
    private static final OuroMarks<OuroTextMark> Bold = new OuroMarks<>(OuroSemiBoldMark.INSTANCE);
    private static final OuroMarks<OuroTextMark> Italic = new OuroMarks<>(OuroItalicMark.INSTANCE);
    private static final OuroMarks<OuroTextMark> Strikethrough = new OuroMarks<>(OuroStrikethroughMark.INSTANCE);
    private static final OuroMarks<OuroTextMark> Underline = new OuroMarks<>(OuroUnderlineMark.INSTANCE);
    private static final OuroMarks<OuroParagraphMark> AlignStart = new OuroMarks<>(OuroTextAlignStartMark.INSTANCE);
    private static final OuroMarks<OuroParagraphMark> AlignCenter = new OuroMarks<>(OuroTextAlignCenterMark.INSTANCE);
    private static final OuroMarks<OuroParagraphMark> AlignEnd = new OuroMarks<>(OuroTextAlignEndMark.INSTANCE);

    public static final OuroMarks<OuroTextMark> getBold() {
        return Bold;
    }

    public static final OuroMarks<OuroTextMark> getItalic() {
        return Italic;
    }

    public static final OuroMarks<OuroTextMark> getStrikethrough() {
        return Strikethrough;
    }

    public static final OuroMarks<OuroTextMark> getUnderline() {
        return Underline;
    }

    public static final OuroMarks<OuroTextMark> ForegroundColor(OuroColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new OuroMarks<>(new OuroForegroundColorMark(color));
    }

    public static final OuroMarks<OuroTextMark> BackgroundColor(OuroColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new OuroMarks<>(new OuroBackgroundColorMark(color, 0.0f, 2, (DefaultConstructorMarker) null));
    }

    public static final OuroMarks<OuroTextMark> Kern(float spacing) {
        return new OuroMarks<>(new OuroTextSpacingMark(spacing));
    }

    public static final OuroMarks<OuroParagraphMark> getAlignStart() {
        return AlignStart;
    }

    public static final OuroMarks<OuroParagraphMark> getAlignCenter() {
        return AlignCenter;
    }

    public static final OuroMarks<OuroParagraphMark> getAlignEnd() {
        return AlignEnd;
    }

    public static final OuroMarks<OuroParagraphMark> LineHeightDp(float h) {
        return new OuroMarks<>(new OuroLineHeightMark(h, new OuroLineHeightStyle(OuroLineHeightStyle.Alignment.Companion.m1983getProportionalPqGQbD4(), OuroLineHeightStyle.Trim.None, OuroLineHeightStyle.Mode.Minimum, OuroLineHeightStyle.Unit.DP, null)));
    }

    public static final OuroMarks<OuroParagraphMark> LineHeightFactor(float h) {
        return new OuroMarks<>(new OuroLineHeightMark(h, new OuroLineHeightStyle(OuroLineHeightStyle.Alignment.Companion.m1983getProportionalPqGQbD4(), OuroLineHeightStyle.Trim.None, OuroLineHeightStyle.Mode.Minimum, OuroLineHeightStyle.Unit.FACTOR, null)));
    }

    public static /* synthetic */ OuroMarks Indent$default(float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return Indent(f, f2);
    }

    public static final OuroMarks<OuroParagraphMark> Indent(float first, float rest) {
        return new OuroMarks<>(new OuroTextIndentMark(first, rest));
    }

    public static /* synthetic */ NodeStorage Document$default(OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroMarks = OuroText.Companion.getDefaultTextMarks();
        }
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kntr.common.ouro.core.dsl.OuroNodeDSLKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit Document$lambda$0;
                    Document$lambda$0 = OuroNodeDSLKt.Document$lambda$0((DocumentBuilder) obj2);
                    return Document$lambda$0;
                }
            };
        }
        return Document(ouroMarks, function1);
    }

    public static final Unit Document$lambda$0(DocumentBuilder documentBuilder) {
        Intrinsics.checkNotNullParameter(documentBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final NodeStorage<OuroDocument> Document(OuroMarks<OuroMark> ouroMarks, Function1<? super DocumentBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroDocument document = new OuroDocument(ouroMarks);
        NodeStorageBuilder builder = new NodeStorageBuilder(document, null, null, 6, null);
        function1.invoke(new DocumentBuilder(builder, document));
        return OuroNodeMutableStorage.CC.build$default(builder, false, 1, null);
    }

    public static /* synthetic */ NodeStorage BoxContainer$default(OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kntr.common.ouro.core.dsl.OuroNodeDSLKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit BoxContainer$lambda$0;
                    BoxContainer$lambda$0 = OuroNodeDSLKt.BoxContainer$lambda$0((BoxContainerBuilder) obj2);
                    return BoxContainer$lambda$0;
                }
            };
        }
        return BoxContainer(ouroMarks, function1);
    }

    public static final Unit BoxContainer$lambda$0(BoxContainerBuilder boxContainerBuilder) {
        Intrinsics.checkNotNullParameter(boxContainerBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final NodeStorage<OuroBoxContainer> BoxContainer(OuroMarks<OuroBoxContainerMark> ouroMarks, Function1<? super BoxContainerBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroBoxContainer container = new OuroBoxContainer(ouroMarks);
        NodeStorageBuilder builder = new NodeStorageBuilder(container, null, null, 6, null);
        function1.invoke(new BoxContainerBuilder(builder, container));
        return OuroNodeMutableStorage.CC.build$default(builder, false, 1, null);
    }
}