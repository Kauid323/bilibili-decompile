package kntr.app.deepsearch.ui.paragraph.text;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StampedPathEffectStyle;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeRich;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeShowType;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResult;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import com.bilibili.common.paragraph.impl.text.TextParagraphClickListener;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.deepsearch.ui.colors.DayNightColor;
import kntr.app.deepsearch.ui.paragraph.constants.ParagraphTextDrawParams;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: DeepSearchTextParagraphBuilder.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BA\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0017¢\u0006\u0002\u00105J\u001e\u00106\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020'\u0018\u0001072\u0006\u00109\u001a\u000208H\u0002J\u0016\u0010:\u001a\u0002022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010+\u001a\b\u0012\u0004\u0012\u00020,0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.¨\u0006>²\u0006\n\u0010?\u001a\u00020@X\u008a\u008e\u0002"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/TextParagraphContent;", "Lcom/bilibili/common/paragraph/builder/ParagraphContent;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "paragraph", "textNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "spacing", "Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "clickListener", "Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;", "drawParams", "Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;", "format", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;)V", "getParagraph", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "getTextNodeBuilder", "()Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "getSpacing", "()Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "getClickListener", "()Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;", "getDrawParams", "()Lkntr/app/deepsearch/ui/paragraph/constants/ParagraphTextDrawParams;", "loggable", RoomRecommendViewModel.EMPTY_CURSOR, "textLayoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/text/TextLayoutResult;", "getTextLayoutResultState", "()Landroidx/compose/runtime/MutableState;", "type", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "getType", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "nodeList", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuildResult;", "content", "contentString", "Landroidx/compose/ui/text/AnnotatedString;", "underlineOffsetList", "Landroidx/compose/ui/text/TextRange;", "getUnderlineOffsetList", "()Ljava/util/List;", "underlineOffsetList$delegate", "Lkotlin/Lazy;", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "findTextNodeOfIndex", "Lkotlin/Pair;", RoomRecommendViewModel.EMPTY_CURSOR, "index", "log", "msg", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "compose_debug", "widthDp", "Landroidx/compose/ui/unit/Dp;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TextParagraphContent implements ParagraphContent<KParagraph.KText> {
    public static final int $stable = 0;
    private final TextParagraphClickListener clickListener;
    private final TextNodeBuildResult content;
    private final AnnotatedString contentString;
    private final ParagraphTextDrawParams drawParams;
    private final KParagraph.KParagraphFormat format;
    private final boolean loggable;
    private final List<TextNodeBuildResult> nodeList;
    private final KParagraph.KText paragraph;
    private final KParaSpacing spacing;
    private final MutableState<TextLayoutResult> textLayoutResultState;
    private final TextNodeBuilderProvider textNodeBuilder;
    private final Lazy underlineOffsetList$delegate;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$6(TextParagraphContent textParagraphContent, Modifier modifier, int i, Composer composer, int i2) {
        textParagraphContent.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00be, code lost:
        if (r1 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextParagraphContent(KParagraph.KText paragraph, TextNodeBuilderProvider textNodeBuilder, KParaSpacing spacing, TextParagraphClickListener clickListener, ParagraphTextDrawParams drawParams, KParagraph.KParagraphFormat format) {
        List<TextNodeBuildResult> emptyList;
        KTextParagraph value;
        Iterable nodes;
        Intrinsics.checkNotNullParameter(textNodeBuilder, "textNodeBuilder");
        this.paragraph = paragraph;
        this.textNodeBuilder = textNodeBuilder;
        this.spacing = spacing;
        this.clickListener = clickListener;
        this.drawParams = drawParams;
        this.format = format;
        this.textLayoutResultState = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        KParagraph.KText paragraph2 = getParagraph();
        if (paragraph2 != null && (value = paragraph2.getValue()) != null && (nodes = value.getNodes()) != null) {
            Iterable $this$mapNotNull$iv = nodes;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                KTextNode node = (KTextNode) element$iv$iv$iv;
                TextNodeBuilder it = this.textNodeBuilder.get(node.getNodeType());
                TextNodeBuilder $this$nodeList_u24lambda_u240_u241 = it.getAcceptClass().isInstance(node.getText()) ? it : null;
                TextNodeBuildResult buildNode = $this$nodeList_u24lambda_u240_u241 != null ? $this$nodeList_u24lambda_u240_u241.buildNode(node.getText(), node.getRawText()) : null;
                if (buildNode != null) {
                    destination$iv$iv.add(buildNode);
                }
            }
            emptyList = CollectionsKt.toList((List) destination$iv$iv);
        }
        emptyList = CollectionsKt.emptyList();
        this.nodeList = emptyList;
        Iterable $this$fold$iv = this.nodeList;
        TextNodeBuildResult empty = TextNodeBuildResult.Companion.getEmpty();
        for (Object element$iv : $this$fold$iv) {
            TextNodeBuildResult r = (TextNodeBuildResult) element$iv;
            TextNodeBuildResult acc = empty;
            empty = acc.plus(r);
        }
        this.content = empty;
        this.contentString = this.content.getString();
        this.underlineOffsetList$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda2
            public final Object invoke() {
                List underlineOffsetList_delegate$lambda$0;
                underlineOffsetList_delegate$lambda$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0(TextParagraphContent.this);
                return underlineOffsetList_delegate$lambda$0;
            }
        });
    }

    public KParagraph.KText getParagraph() {
        return this.paragraph;
    }

    public final TextNodeBuilderProvider getTextNodeBuilder() {
        return this.textNodeBuilder;
    }

    public KParaSpacing getSpacing() {
        return this.spacing;
    }

    public final TextParagraphClickListener getClickListener() {
        return this.clickListener;
    }

    public final ParagraphTextDrawParams getDrawParams() {
        return this.drawParams;
    }

    public final MutableState<TextLayoutResult> getTextLayoutResultState() {
        return this.textLayoutResultState;
    }

    public KParagraph.KParagraphType getType() {
        return KParagraph.KParagraphType.TEXT.INSTANCE;
    }

    private final List<TextRange> getUnderlineOffsetList() {
        return (List) this.underlineOffsetList$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List underlineOffsetList_delegate$lambda$0(final TextParagraphContent this$0) {
        boolean z;
        Iterable $this$forEach$iv;
        int $i$f$forEach;
        Iterator it;
        KWordNode.KWordNodeStyle style;
        boolean z2;
        Iterable $this$forEach$iv2;
        int $i$f$forEach2;
        Iterator it2;
        KWordNode.KWordNodeStyle style2;
        String words;
        int i;
        final List $this$underlineOffsetList_delegate_u24lambda_u240_u240 = new ArrayList();
        boolean z3 = false;
        final Ref.IntRef offset = new Ref.IntRef();
        Function3 addAndLog = new Function3() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit underlineOffsetList_delegate$lambda$0$0$0;
                underlineOffsetList_delegate$lambda$0$0$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$0(offset, this$0, $this$underlineOffsetList_delegate_u24lambda_u240_u240, (String) obj, (TextNodeBuildResult) obj2, (Function0) obj3);
                return underlineOffsetList_delegate$lambda$0$0$0;
            }
        };
        Iterable $this$forEach$iv3 = this$0.nodeList;
        int $i$f$forEach3 = 0;
        Iterator it3 = $this$forEach$iv3.iterator();
        while (it3.hasNext()) {
            Object element$iv = it3.next();
            TextNodeBuildResult result = (TextNodeBuildResult) element$iv;
            final KTextNode.KLink node = result.getNode();
            if (node instanceof KTextNode.KWord) {
                addAndLog.invoke("KWord", result, new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        boolean underlineOffsetList_delegate$lambda$0$0$1$0;
                        underlineOffsetList_delegate$lambda$0$0$1$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$1$0(node);
                        return Boolean.valueOf(underlineOffsetList_delegate$lambda$0$0$1$0);
                    }
                });
                z = z3;
                $this$forEach$iv = $this$forEach$iv3;
                $i$f$forEach = $i$f$forEach3;
                it = it3;
            } else if (node instanceof KTextNode.KEmote) {
                addAndLog.invoke("KEmote", result, new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        boolean underlineOffsetList_delegate$lambda$0$0$1$1;
                        underlineOffsetList_delegate$lambda$0$0$1$1 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$1$1(node);
                        return Boolean.valueOf(underlineOffsetList_delegate$lambda$0$0$1$1);
                    }
                });
                z = z3;
                $this$forEach$iv = $this$forEach$iv3;
                $i$f$forEach = $i$f$forEach3;
                it = it3;
            } else if (node instanceof KTextNode.KLink) {
                if (!Intrinsics.areEqual(node.getValue().getShowType(), KLinkNodeShowType.RICH_TEXT.INSTANCE)) {
                    z = z3;
                    $this$forEach$iv = $this$forEach$iv3;
                    $i$f$forEach = $i$f$forEach3;
                    it = it3;
                    KWordNode showText = node.getValue().getShowText();
                    if ((showText == null || (style = showText.getStyle()) == null || !style.getUnderline()) ? false : true) {
                        $this$underlineOffsetList_delegate_u24lambda_u240_u240.add(TextRange.box-impl(TextRangeKt.TextRange(offset.element, (offset.element + result.getString().length()) - 1)));
                    }
                    offset.element += result.getString().length();
                } else {
                    for (Object element$iv2 : node.getValue().getShowRich()) {
                        KLinkNodeRich rich = (KLinkNodeRich) element$iv2;
                        KLinkNodeRich.KText content = rich.getContent();
                        if (content instanceof KLinkNodeRich.KText) {
                            int length = content.getValue().getWords().length();
                            KWordNode.KWordNodeStyle style3 = content.getValue().getStyle();
                            if (style3 != null) {
                                z2 = z3;
                                boolean underline = style3.getUnderline();
                                $this$forEach$iv2 = $this$forEach$iv3;
                                if (underline) {
                                    i = 1;
                                    if (i != 0) {
                                        $i$f$forEach2 = $i$f$forEach3;
                                    } else {
                                        final int start = offset.element;
                                        final int end = (start + length) - 1;
                                        long $this$underlineOffsetList_delegate_u24lambda_u240_u240_u241_u242_u240 = TextRangeKt.TextRange(start, end);
                                        $i$f$forEach2 = $i$f$forEach3;
                                        this$0.log(new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda11
                                            public final Object invoke() {
                                                String underlineOffsetList_delegate$lambda$0$0$1$2$0$0;
                                                underlineOffsetList_delegate$lambda$0$0$1$2$0$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$1$2$0$0(start, end, this$0);
                                                return underlineOffsetList_delegate$lambda$0$0$1$2$0$0;
                                            }
                                        });
                                        $this$underlineOffsetList_delegate_u24lambda_u240_u240.add(TextRange.box-impl($this$underlineOffsetList_delegate_u24lambda_u240_u240_u241_u242_u240));
                                    }
                                    offset.element += length;
                                    it2 = it3;
                                }
                            } else {
                                z2 = z3;
                                $this$forEach$iv2 = $this$forEach$iv3;
                            }
                            i = 0;
                            if (i != 0) {
                            }
                            offset.element += length;
                            it2 = it3;
                        } else {
                            z2 = z3;
                            $this$forEach$iv2 = $this$forEach$iv3;
                            $i$f$forEach2 = $i$f$forEach3;
                            if (content instanceof KLinkNodeRich.KEmote) {
                                KWordNode rawText = ((KLinkNodeRich.KEmote) content).getValue().getRawText();
                                int length2 = (rawText == null || (words = rawText.getWords()) == null) ? 0 : words.length();
                                KWordNode rawText2 = ((KLinkNodeRich.KEmote) content).getValue().getRawText();
                                if (!((rawText2 == null || (style2 = rawText2.getStyle()) == null || !style2.getUnderline()) ? false : true)) {
                                    it2 = it3;
                                } else {
                                    final int start2 = offset.element;
                                    final int end2 = (start2 + length2) - 1;
                                    long $this$underlineOffsetList_delegate_u24lambda_u240_u240_u241_u242_u241 = TextRangeKt.TextRange(start2, end2);
                                    it2 = it3;
                                    this$0.log(new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda12
                                        public final Object invoke() {
                                            String underlineOffsetList_delegate$lambda$0$0$1$2$1$0;
                                            underlineOffsetList_delegate$lambda$0$0$1$2$1$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$1$2$1$0(start2, end2, this$0);
                                            return underlineOffsetList_delegate$lambda$0$0$1$2$1$0;
                                        }
                                    });
                                    $this$underlineOffsetList_delegate_u24lambda_u240_u240.add(TextRange.box-impl($this$underlineOffsetList_delegate_u24lambda_u240_u240_u241_u242_u241));
                                }
                                offset.element += length2;
                            } else {
                                it2 = it3;
                                offset.element += result.getString().length();
                            }
                        }
                        $this$forEach$iv3 = $this$forEach$iv2;
                        z3 = z2;
                        it3 = it2;
                        $i$f$forEach3 = $i$f$forEach2;
                    }
                    z = z3;
                    $this$forEach$iv = $this$forEach$iv3;
                    $i$f$forEach = $i$f$forEach3;
                    it = it3;
                }
            } else {
                z = z3;
                $this$forEach$iv = $this$forEach$iv3;
                $i$f$forEach = $i$f$forEach3;
                it = it3;
                if (node instanceof KTextNode.KFormula) {
                    addAndLog.invoke("KFormula", result, new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            boolean underlineOffsetList_delegate$lambda$0$0$1$3;
                            underlineOffsetList_delegate$lambda$0$0$1$3 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$1$3(node);
                            return Boolean.valueOf(underlineOffsetList_delegate$lambda$0$0$1$3);
                        }
                    });
                }
            }
            $this$forEach$iv3 = $this$forEach$iv;
            z3 = z;
            it3 = it;
            $i$f$forEach3 = $i$f$forEach;
        }
        final List $this$underlineOffsetList_delegate_u24lambda_u240_u241 = DeepSearchTextParagraphBuilderKt.mergeRange($this$underlineOffsetList_delegate_u24lambda_u240_u240);
        this$0.log(new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda1
            public final Object invoke() {
                String obj;
                obj = $this$underlineOffsetList_delegate_u24lambda_u240_u241.toString();
                return obj;
            }
        });
        return $this$underlineOffsetList_delegate_u24lambda_u240_u241;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit underlineOffsetList_delegate$lambda$0$0$0(Ref.IntRef $offset, final TextParagraphContent this$0, List $this_apply, final String who, TextNodeBuildResult result, Function0 predicator) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(predicator, "predicator");
        if (((Boolean) predicator.invoke()).booleanValue()) {
            final long $this$underlineOffsetList_delegate_u24lambda_u240_u240_u240_u240 = TextRangeKt.TextRange($offset.element, ($offset.element + result.getString().length()) - 1);
            this$0.log(new Function0() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda3
                public final Object invoke() {
                    String underlineOffsetList_delegate$lambda$0$0$0$0$0;
                    underlineOffsetList_delegate$lambda$0$0$0$0$0 = TextParagraphContent.underlineOffsetList_delegate$lambda$0$0$0$0$0(who, $this$underlineOffsetList_delegate_u24lambda_u240_u240_u240_u240, this$0);
                    return underlineOffsetList_delegate$lambda$0$0$0$0$0;
                }
            });
            $this_apply.add(TextRange.box-impl($this$underlineOffsetList_delegate_u24lambda_u240_u240_u240_u240));
        }
        $offset.element += result.getString().length();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String underlineOffsetList_delegate$lambda$0$0$0$0$0(String $who, long $this_apply, TextParagraphContent this$0) {
        int i = TextRange.getStart-impl($this_apply);
        int i2 = TextRange.getEnd-impl($this_apply);
        return "+" + $who + ": [" + i + ", " + i2 + "] => " + this$0.contentString.subSequence(TextRange.getStart-impl($this_apply), TextRange.getEnd-impl($this_apply)).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean underlineOffsetList_delegate$lambda$0$0$1$0(KTextNode.IText $node) {
        KWordNode.KWordNodeStyle style = ((KTextNode.KWord) $node).getValue().getStyle();
        return style != null && style.getUnderline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean underlineOffsetList_delegate$lambda$0$0$1$1(KTextNode.IText $node) {
        KWordNode.KWordNodeStyle style;
        KWordNode rawText = ((KTextNode.KEmote) $node).getValue().getRawText();
        if (rawText != null && (style = rawText.getStyle()) != null && style.getUnderline()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String underlineOffsetList_delegate$lambda$0$0$1$2$0$0(int $start, int $end, TextParagraphContent this$0) {
        return "+KLink.Text: [" + $start + ", " + $end + "] => " + this$0.contentString.subSequence($start, $end).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String underlineOffsetList_delegate$lambda$0$0$1$2$1$0(int $start, int $end, TextParagraphContent this$0) {
        return "+KLink.Emote: [" + $start + ", " + $end + "] => " + this$0.contentString.subSequence($start, $end).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean underlineOffsetList_delegate$lambda$0$0$1$3(KTextNode.IText $node) {
        KWordNode.KWordNodeStyle style;
        KWordNode latexContent = ((KTextNode.KFormula) $node).getValue().getLatexContent();
        if (latexContent != null && (style = latexContent.getStyle()) != null && style.getUnderline()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0404, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01a9, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0369, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0467  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Content(final Modifier modifier, Composer $composer, final int $changed) {
        Color color;
        long underlineColor;
        int maxLines;
        Function0 factory$iv$iv$iv;
        int i;
        boolean invalid$iv;
        TextOverflow m778getOverflowoLHJmLw;
        Integer maxLines2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(2000747565);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier)246@11452L7,247@11495L7,250@11713L33,254@11850L184,251@11755L7997:DeepSearchTextParagraphBuilder.kt#6r81bt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2000747565, $dirty, -1, "kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent.Content (DeepSearchTextParagraphBuilder.kt:241)");
            }
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            ParagraphStyle style$iv = new ParagraphStyle(0, 0, this.content.getLineHeight-XSAIIZE(), (TextIndent) null, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 507, (DefaultConstructorMarker) null);
            int index$iv = builder.pushStyle(style$iv);
            try {
                builder.append(this.content.getString());
                Unit unit = Unit.INSTANCE;
                builder.pop(index$iv);
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                SoftwareKeyboardController soft = (SoftwareKeyboardController) consume;
                CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer2.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final Density density = (Density) consume2;
                ParagraphTextDrawParams paragraphTextDrawParams = this.drawParams;
                DayNightColor underlineColor2 = paragraphTextDrawParams != null ? paragraphTextDrawParams.getUnderlineColor() : null;
                if (underlineColor2 == null) {
                    $composer2.startReplaceGroup(-1285064721);
                    $composer2.endReplaceGroup();
                    color = null;
                } else {
                    $composer2.startReplaceGroup(-1426927022);
                    ComposerKt.sourceInformation($composer2, "248@11560L5");
                    long value = underlineColor2.getValue($composer2, 0);
                    $composer2.endReplaceGroup();
                    color = Color.box-impl(value);
                }
                if (color == null) {
                    $composer2.startReplaceGroup(-1426926192);
                    ComposerKt.sourceInformation($composer2, "248@11579L6");
                    underlineColor = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa4-0d7_KjU();
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1426927866);
                    $composer2.endReplaceGroup();
                    underlineColor = color.unbox-impl();
                }
                ParagraphTextDrawParams paragraphTextDrawParams2 = this.drawParams;
                if (paragraphTextDrawParams2 == null || (maxLines2 = paragraphTextDrawParams2.getMaxLines()) == null) {
                    KParagraph.KParagraphFormat kParagraphFormat = this.format;
                    maxLines = kParagraphFormat != null ? kParagraphFormat.getMaxLines() : Integer.MAX_VALUE;
                } else {
                    maxLines = maxLines2.intValue();
                }
                int maxLines3 = RangesKt.coerceAtLeast(maxLines, 1);
                ComposerKt.sourceInformationMarkerStart($composer2, -1426922098, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                final MutableState widthDp$delegate = (MutableState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1426917563, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(density);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$4$0;
                        Content$lambda$4$0 = TextParagraphContent.Content$lambda$4$0(density, widthDp$delegate, (LayoutCoordinates) obj);
                        return Content$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier modifier$iv = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) it$iv2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                final long underlineColor3 = underlineColor;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1561427822, "C:DeepSearchTextParagraphBuilder.kt#6r81bt");
                $composer2.startMovableGroup(1851483957, Dp.box-impl(Content$lambda$2(widthDp$delegate)));
                ComposerKt.sourceInformation($composer2, "278@12921L1285,300@14218L5374,383@19629L80,262@12091L7637");
                ParagraphTextDrawParams paragraphTextDrawParams3 = this.drawParams;
                if (paragraphTextDrawParams3 == null || (m778getOverflowoLHJmLw = paragraphTextDrawParams3.m778getOverflowoLHJmLw()) == null) {
                    i = maxLines3 < Integer.MAX_VALUE ? TextOverflow.Companion.getEllipsis-gIe3tQ8() : TextOverflow.Companion.getClip-gIe3tQ8();
                } else {
                    i = m778getOverflowoLHJmLw.unbox-impl();
                }
                AnnotatedString annotatedString = builder.toAnnotatedString();
                Map inlineTextContent = this.content.getInlineTextContent();
                KParagraph.KParagraphFormat kParagraphFormat2 = this.format;
                KParagraph.KParagraphAlign align = kParagraphFormat2 != null ? kParagraphFormat2.getAlign() : null;
                int i4 = align instanceof KParagraph.KParagraphAlign.MIDDLE ? TextAlign.Companion.getCenter-e0LSkKk() : align instanceof KParagraph.KParagraphAlign.RIGHT ? TextAlign.Companion.getRight-e0LSkKk() : TextAlign.Companion.getLeft-e0LSkKk();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1851505112, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                boolean invalid$iv3 = $composer2.changed(soft) | (($dirty & 112) == 32);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = (PointerInputEventHandler) new TextParagraphContent$Content$4$1$1(soft, this);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(fillMaxWidth$default, (Object) null, (PointerInputEventHandler) it$iv3);
                ComposerKt.sourceInformationMarkerStart($composer2, 1851550705, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                boolean invalid$iv4 = (($dirty & 112) == 32) | $composer2.changed(underlineColor3);
                Object value$iv4 = $composer2.rememberedValue();
                if (!invalid$iv4 && value$iv4 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier drawBehind = DrawModifierKt.drawBehind(pointerInput, (Function1) value$iv4);
                    TextAlign textAlign = TextAlign.box-impl(i4);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1851718563, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                    invalid$iv = ($dirty & 112) != 32;
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv5 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit Content$lambda$5$2$0;
                            Content$lambda$5$2$0 = TextParagraphContent.Content$lambda$5$2$0(TextParagraphContent.this, (TextLayoutResult) obj);
                            return Content$lambda$5$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv4 = value$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Z58ophY(annotatedString, drawBehind, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, textAlign, 0L, i, false, maxLines3, 0, inlineTextContent, (Function1) it$iv4, (TextStyle) null, $composer2, 0, 0, 306172);
                    $composer2.endMovableGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$5$1$0;
                        Content$lambda$5$1$0 = TextParagraphContent.Content$lambda$5$1$0(TextParagraphContent.this, underlineColor3, (DrawScope) obj);
                        return Content$lambda$5$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier drawBehind2 = DrawModifierKt.drawBehind(pointerInput, (Function1) value$iv4);
                TextAlign textAlign2 = TextAlign.box-impl(i4);
                ComposerKt.sourceInformationMarkerStart($composer2, 1851718563, "CC(remember):DeepSearchTextParagraphBuilder.kt#9igjgp");
                invalid$iv = ($dirty & 112) != 32;
                Object it$iv42 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv52 = new Function1() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$5$2$0;
                        Content$lambda$5$2$0 = TextParagraphContent.Content$lambda$5$2$0(TextParagraphContent.this, (TextLayoutResult) obj);
                        return Content$lambda$5$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv52);
                it$iv42 = value$iv52;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Z58ophY(annotatedString, drawBehind2, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, textAlign2, 0L, i, false, maxLines3, 0, inlineTextContent, (Function1) it$iv42, (TextStyle) null, $composer2, 0, 0, 306172);
                $composer2.endMovableGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                }
            } catch (Throwable th) {
                builder.pop(index$iv);
                throw th;
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.paragraph.text.TextParagraphContent$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$6;
                    Content$lambda$6 = TextParagraphContent.Content$lambda$6(TextParagraphContent.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$6;
                }
            });
        }
    }

    private static final float Content$lambda$2(MutableState<Dp> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void Content$lambda$3(MutableState<Dp> mutableState, float f) {
        Object value$iv = Dp.box-impl(f);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4$0(Density $density, MutableState $widthDp$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Content$lambda$3($widthDp$delegate, $density.toDp-u2uoSUM((int) (it.getSize-YbymL2g() >> 32)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$1$0(TextParagraphContent this$0, long $underlineColor, DrawScope $this$drawBehind) {
        Iterable $this$forEach$iv;
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        TextLayoutResult layout = (TextLayoutResult) this$0.textLayoutResultState.getValue();
        if (layout != null) {
            float size = $this$drawBehind.toPx-0680j_4(UnderlineWidthKt.getUnderlineWidth());
            float $this$dp$iv = Dp.constructor-impl(1.5f);
            float gap = $this$drawBehind.toPx-0680j_4($this$dp$iv) + size;
            float verticalOffset = $this$drawBehind.toPx-0680j_4(Dp.constructor-impl(5)) - (size / 2.0f);
            PathEffect.Companion companion = PathEffect.Companion;
            Path $this$Content_u24lambda_u245_u241_u240_u240_u240 = AndroidPath_androidKt.Path();
            Path.-CC.addOval$default($this$Content_u24lambda_u245_u241_u240_u240_u240, new Rect(0.0f, 0.0f, size, size), (Path.Direction) null, 2, (Object) null);
            PathEffect pathEffect = companion.stampedPathEffect-7aD1DOk($this$Content_u24lambda_u245_u241_u240_u240_u240, gap, 0.0f, StampedPathEffectStyle.Companion.getTranslate-Ypspkwk());
            List<TextRange> drawRangeList = new ArrayList();
            Iterable $this$forEach$iv2 = this$0.getUnderlineOffsetList();
            boolean z = false;
            Iterator it = $this$forEach$iv2.iterator();
            while (it.hasNext()) {
                Object element$iv = it.next();
                long range = ((TextRange) element$iv).unbox-impl();
                int startLine = layout.getMultiParagraph().getLineForOffset(TextRange.getStart-impl(range));
                if (startLine == layout.getMultiParagraph().getLineForOffset(TextRange.getEnd-impl(range))) {
                    drawRangeList.add(TextRange.box-impl(range));
                    $this$forEach$iv = $this$forEach$iv2;
                } else {
                    int currentLine = startLine;
                    int startOffset = TextRange.getStart-impl(range);
                    while (true) {
                        $this$forEach$iv = $this$forEach$iv2;
                        if (startOffset <= TextRange.getEnd-impl(range) && currentLine < layout.getMultiParagraph().getLineCount()) {
                            boolean z2 = z;
                            Iterator it2 = it;
                            Object element$iv2 = element$iv;
                            int endOffset = MultiParagraph.getLineEnd$default(layout.getMultiParagraph(), currentLine, false, 2, (Object) null) - 1;
                            if (TextRange.getEnd-impl(range) <= endOffset) {
                                drawRangeList.add(TextRange.box-impl(TextRangeKt.TextRange(startOffset, TextRange.getEnd-impl(range))));
                                startOffset = TextRange.getEnd-impl(range) + 1;
                                element$iv = element$iv2;
                                $this$forEach$iv2 = $this$forEach$iv;
                                z = z2;
                                it = it2;
                            } else {
                                drawRangeList.add(TextRange.box-impl(TextRangeKt.TextRange(startOffset, endOffset)));
                                startOffset = endOffset + 1;
                                currentLine++;
                                element$iv = element$iv2;
                                $this$forEach$iv2 = $this$forEach$iv;
                                z = z2;
                                it = it2;
                            }
                        }
                    }
                }
                $this$forEach$iv2 = $this$forEach$iv;
                z = z;
                it = it;
            }
            for (TextRange textRange : drawRangeList) {
                long it3 = textRange.unbox-impl();
                Rect startBox = layout.getMultiParagraph().getBoundingBox(TextRange.getStart-impl(it3));
                Rect endBox = layout.getMultiParagraph().getBoundingBox(TextRange.getEnd-impl(it3));
                float baselineStart = layout.getMultiParagraph().getLineBaseline(layout.getMultiParagraph().getLineForOffset(TextRange.getStart-impl(it3)));
                float baselineEnd = layout.getMultiParagraph().getLineBaseline(layout.getMultiParagraph().getLineForOffset(TextRange.getEnd-impl(it3)));
                int bits$iv$iv$iv = (int) (startBox.getBottomLeft-F1C5BW0() >> 32);
                float x$iv = Float.intBitsToFloat(bits$iv$iv$iv);
                float y$iv = baselineStart + verticalOffset;
                long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                int bits$iv$iv$iv2 = (int) (endBox.getBottomRight-F1C5BW0() >> 32);
                float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2);
                float y$iv2 = baselineEnd + verticalOffset;
                long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
                long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
                DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, $underlineColor, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), size, 0, pathEffect, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
                gap = gap;
                size = size;
                drawRangeList = drawRangeList;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5$2$0(TextParagraphContent this$0, TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.textLayoutResultState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Integer, TextNodeBuildResult> findTextNodeOfIndex(int index) {
        int offset = 0;
        for (TextNodeBuildResult value : this.nodeList) {
            if (value.getString().length() + offset > index) {
                return TuplesKt.to(Integer.valueOf(offset), value);
            }
            offset += value.getString().length();
        }
        return null;
    }

    private final void log(Function0<String> function0) {
        if (this.loggable) {
            KLog_androidKt.getKLog().d("DeepSearchTextParagraphBuilder", (String) function0.invoke());
        }
    }
}