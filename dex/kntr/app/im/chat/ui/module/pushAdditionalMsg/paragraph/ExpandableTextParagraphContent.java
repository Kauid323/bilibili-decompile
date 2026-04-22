package kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph;

import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KTextParagraph;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResult;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResultKt;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilderProvider;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextParagraphClickListener;
import com.bilibili.compose.theme.BiliTheme;
import im.base.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ExpandableTextParagraph.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0017¢\u0006\u0002\u0010)J\u001e\u0010*\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020#\u0018\u00010+2\u0006\u0010-\u001a\u00020,H\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002"}, d2 = {"Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextParagraphContent;", "Lcom/bilibili/common/paragraph/builder/ParagraphContent;", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "paragraph", "textNodeBuilder", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "spacing", "Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "format", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;", "textParagraphConfig", "Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;", "expandableTextConfig", "Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;", "clickListener", "Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphFormat;Lcom/bilibili/common/paragraph/impl/constant/TextParagraphConfig;Lkntr/app/im/chat/ui/module/pushAdditionalMsg/paragraph/ExpandableTextConfig;Lcom/bilibili/common/paragraph/impl/text/TextParagraphClickListener;)V", "getParagraph", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KText;", "getTextNodeBuilder", "()Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilderProvider;", "getSpacing", "()Lcom/bapis/bilibili/app/dynamic/v2/KParaSpacing;", "textLayoutResultState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/text/TextLayoutResult;", "getTextLayoutResultState", "()Landroidx/compose/runtime/MutableState;", "type", "Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "getType", "()Lcom/bapis/bilibili/app/dynamic/v2/KParagraph$KParagraphType;", "nodeList", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuildResult;", "content", "Content", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "findTextNodeOfIndex", "Lkotlin/Pair;", RoomRecommendViewModel.EMPTY_CURSOR, "index", "ui_debug", "expanded", RoomRecommendViewModel.EMPTY_CURSOR}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ExpandableTextParagraphContent implements ParagraphContent<KParagraph.KText> {
    public static final int $stable = 0;
    private final TextParagraphClickListener clickListener;
    private final TextNodeBuildResult content;
    private final ExpandableTextConfig expandableTextConfig;
    private final KParagraph.KParagraphFormat format;
    private final List<TextNodeBuildResult> nodeList;
    private final KParagraph.KText paragraph;
    private final KParaSpacing spacing;
    private final MutableState<TextLayoutResult> textLayoutResultState;
    private final TextNodeBuilderProvider textNodeBuilder;
    private final TextParagraphConfig textParagraphConfig;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$5(ExpandableTextParagraphContent expandableTextParagraphContent, Modifier modifier, int i, Composer composer, int i2) {
        expandableTextParagraphContent.Content(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00cc, code lost:
        if (r1 != null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ExpandableTextParagraphContent(KParagraph.KText paragraph, TextNodeBuilderProvider textNodeBuilder, KParaSpacing spacing, KParagraph.KParagraphFormat format, TextParagraphConfig textParagraphConfig, ExpandableTextConfig expandableTextConfig, TextParagraphClickListener clickListener) {
        List<TextNodeBuildResult> emptyList;
        KTextParagraph value;
        Iterable nodes;
        Intrinsics.checkNotNullParameter(textNodeBuilder, "textNodeBuilder");
        Intrinsics.checkNotNullParameter(textParagraphConfig, "textParagraphConfig");
        Intrinsics.checkNotNullParameter(expandableTextConfig, "expandableTextConfig");
        this.paragraph = paragraph;
        this.textNodeBuilder = textNodeBuilder;
        this.spacing = spacing;
        this.format = format;
        this.textParagraphConfig = textParagraphConfig;
        this.expandableTextConfig = expandableTextConfig;
        this.clickListener = clickListener;
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

    public final MutableState<TextLayoutResult> getTextLayoutResultState() {
        return this.textLayoutResultState;
    }

    public KParagraph.KParagraphType getType() {
        return KParagraph.KParagraphType.TEXT.INSTANCE;
    }

    public void Content(final Modifier modifier, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(407011511);
        ComposerKt.sourceInformation($composer2, "C(Content)N(modifier)114@5056L34,115@5118L22,118@5217L9,119@5271L6,124@5406L377,135@5929L9125,132@5792L9262:ExpandableTextParagraph.kt#k1izse");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(407011511, $dirty2, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent.Content (ExpandableTextParagraph.kt:113)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 296040025, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState expanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            final AnnotatedString text = this.content.getString();
            final TextStyle style = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, LineBreak.Companion.getSimple-rAG3T2k(), 0, (TextMotion) null, 14680062, (Object) null);
            Map inlineTextContent = this.content.getInlineTextContent();
            AnnotatedString string = this.content.getString();
            long m1834getConstraintsmsEJaDk = this.expandableTextConfig.m1834getConstraintsmsEJaDk();
            ComposerKt.sourceInformationMarkerStart($composer2, 296051568, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(inlineTextContent) | $composer2.changed(string) | $composer2.changed(m1834getConstraintsmsEJaDk);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = TextMeasurer.measure-xDpz5zY$default(textMeasurer, text, style, 0, false, 0, TextNodeBuildResultKt.getPlaceholderRanges(this.content.getString(), this.content.getInlineTextContent()), this.expandableTextConfig.m1834getConstraintsmsEJaDk(), (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1948, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final TextLayoutResult originResult = (TextLayoutResult) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ExpandableTextParagraphKt.TextWithFirstLineBottom((int) originResult.getLineBottom(0), modifier, ComposableLambdaKt.rememberComposableLambda(-31281658, true, new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$4;
                    Content$lambda$4 = ExpandableTextParagraphContent.Content$lambda$4(originResult, this, textMeasurer, style, text, expanded$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$4;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 112) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$5;
                    Content$lambda$5 = ExpandableTextParagraphContent.Content$lambda$5(ExpandableTextParagraphContent.this, modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$5;
                }
            });
        }
    }

    private static final boolean Content$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void Content$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x041a, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit Content$lambda$4(TextLayoutResult $originResult, final ExpandableTextParagraphContent this$0, TextMeasurer $textMeasurer, TextStyle $style, final AnnotatedString $text, final MutableState $expanded$delegate, Composer $composer, int $changed) {
        AnnotatedString string;
        int i;
        Appendable $this$Content_u24lambda_u244_u243;
        int index$iv;
        ComposerKt.sourceInformation($composer, "C260@12495L2270,304@14869L72,249@11986L3058:ExpandableTextParagraph.kt#k1izse");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-31281658, $changed, -1, "kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent.Content.<anonymous> (ExpandableTextParagraph.kt:136)");
            }
            boolean needExtraButton = $originResult.getLineCount() > this$0.expandableTextConfig.getCollapseLineCount();
            if (needExtraButton) {
                $composer.startReplaceGroup(96375747);
                ComposerKt.sourceInformation($composer, RoomRecommendViewModel.EMPTY_CURSOR);
                if (Content$lambda$1($expanded$delegate)) {
                    $composer.startReplaceGroup(96314274);
                    ComposerKt.sourceInformation($composer, "*145@6454L6,157@7147L6,158@7197L318");
                    TextLayoutResult buttonResult = TextMeasurer.measure-wNUYSr0$default($textMeasurer, this$0.expandableTextConfig.getToCollapse(), $style, 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1020, (Object) null);
                    $this$Content_u24lambda_u244_u243 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    SpanStyle style$iv = new SpanStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
                    index$iv = $this$Content_u24lambda_u244_u243.pushStyle(style$iv);
                    try {
                        $this$Content_u24lambda_u244_u243.append($text);
                        try {
                            try {
                                if ($originResult.getLineRight($originResult.getLineCount() - 1) + ((int) (buttonResult.getSize-YbymL2g() >> 32)) > Constraints.getMaxWidth-impl(this$0.expandableTextConfig.m1834getConstraintsmsEJaDk())) {
                                    $this$Content_u24lambda_u244_u243.append('\n');
                                }
                                Unit unit = Unit.INSTANCE;
                                $this$Content_u24lambda_u244_u243.pop(index$iv);
                                TextLinkStyles textLinkStyles = new TextLinkStyles(new SpanStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), (SpanStyle) null, (SpanStyle) null, (SpanStyle) null, 14, (DefaultConstructorMarker) null);
                                ComposerKt.sourceInformationMarkerStart($composer, 1150481198, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
                                boolean invalid$iv = $composer.changed($text);
                                Object it$iv = $composer.rememberedValue();
                                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = new LinkInteractionListener() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$$ExternalSyntheticLambda0
                                        public final void onClick(LinkAnnotation linkAnnotation) {
                                            ExpandableTextParagraphContent.Content$lambda$4$0$1$0($text, $expanded$delegate, linkAnnotation);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                LinkAnnotation link$iv = new LinkAnnotation.Clickable("collapse", textLinkStyles, (LinkInteractionListener) it$iv);
                                index$iv = $this$Content_u24lambda_u244_u243.pushLink(link$iv);
                                try {
                                    $this$Content_u24lambda_u244_u243.append(this$0.expandableTextConfig.getToCollapse());
                                    Unit unit2 = Unit.INSTANCE;
                                    $this$Content_u24lambda_u244_u243.pop(index$iv);
                                    string = $this$Content_u24lambda_u244_u243.toAnnotatedString();
                                    $composer.endReplaceGroup();
                                } finally {
                                }
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    $composer.startReplaceGroup(97920477);
                    ComposerKt.sourceInformation($composer, "193@9034L911,210@10015L780,*225@10901L6,233@11349L6,234@11399L315");
                    AnnotatedString firstLine = $text.subSequence-5zc-tL8(TextRangeKt.TextRange($originResult.getLineStart(0), TextLayoutResult.getLineEnd$default($originResult, RangesKt.coerceAtLeast(this$0.expandableTextConfig.getCollapseLineCount() - 2, 0), false, 2, (Object) null)));
                    AnnotatedString originSecondLine = $text.subSequence-5zc-tL8(TextRangeKt.TextRange($originResult.getLineStart(this$0.expandableTextConfig.getCollapseLineCount() - 1), TextLayoutResult.getLineEnd$default($originResult, this$0.expandableTextConfig.getCollapseLineCount() - 1, false, 2, (Object) null)));
                    AnnotatedString toExpandButtonContent = new AnnotatedString(this$0.expandableTextConfig.getEllipsis() + this$0.expandableTextConfig.getToExpand(), (List) null, 2, (DefaultConstructorMarker) null);
                    AnnotatedString secondLineForMeasure = toExpandButtonContent.plus(originSecondLine);
                    int i2 = Constraints.getMaxWidth-impl(this$0.expandableTextConfig.m1834getConstraintsmsEJaDk());
                    Map inlineTextContent = this$0.content.getInlineTextContent();
                    ComposerKt.sourceInformationMarkerStart($composer, 3198005, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changed(i2) | $composer.changed(secondLineForMeasure) | $composer.changed(inlineTextContent);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = TextMeasurer.measure-xDpz5zY$default($textMeasurer, secondLineForMeasure, $style, 0, false, 0, TextNodeBuildResultKt.getPlaceholderRanges(secondLineForMeasure, this$0.content.getInlineTextContent()), ConstraintsKt.Constraints$default(Constraints.getMaxWidth-impl(this$0.expandableTextConfig.m1834getConstraintsmsEJaDk()), Constraints.getMaxWidth-impl(this$0.expandableTextConfig.m1834getConstraintsmsEJaDk()), 0, 0, 12, (Object) null), (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1948, (Object) null);
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    TextLayoutResult secondLineResult = (TextLayoutResult) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 3229266, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changed(secondLineResult) | $composer.changed(originSecondLine) | $composer.changed(toExpandButtonContent);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = secondLineResult.getLineCount() > 1 ? originSecondLine.subSequence(0, RangesKt.coerceAtLeast(TextLayoutResult.getLineEnd$default(secondLineResult, 0, false, 2, (Object) null) - toExpandButtonContent.length(), 0)) : originSecondLine;
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    }
                    AnnotatedString secondLine = (AnnotatedString) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $this$Content_u24lambda_u244_u243 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    SpanStyle style$iv2 = new SpanStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
                    index$iv = $this$Content_u24lambda_u244_u243.pushStyle(style$iv2);
                    try {
                        $this$Content_u24lambda_u244_u243.append(firstLine);
                        $this$Content_u24lambda_u244_u243.append(secondLine);
                    } catch (Throwable th4) {
                        th = th4;
                    }
                    try {
                        $this$Content_u24lambda_u244_u243.append(this$0.expandableTextConfig.getEllipsis());
                        Unit unit3 = Unit.INSTANCE;
                        $this$Content_u24lambda_u244_u243.pop(index$iv);
                        TextLinkStyles textLinkStyles2 = new TextLinkStyles(new SpanStyle(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), (SpanStyle) null, (SpanStyle) null, (SpanStyle) null, 14, (DefaultConstructorMarker) null);
                        ComposerKt.sourceInformationMarkerStart($composer, -11125214, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
                        boolean invalid$iv4 = $composer.changed($text);
                        Object it$iv4 = $composer.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv4 = new LinkInteractionListener() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$$ExternalSyntheticLambda1
                            public final void onClick(LinkAnnotation linkAnnotation) {
                                ExpandableTextParagraphContent.Content$lambda$4$3$1$0($text, $expanded$delegate, linkAnnotation);
                            }
                        };
                        $composer.updateRememberedValue(value$iv4);
                        it$iv4 = value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        LinkAnnotation link$iv2 = new LinkAnnotation.Clickable("expand", textLinkStyles2, (LinkInteractionListener) it$iv4);
                        index$iv = $this$Content_u24lambda_u244_u243.pushLink(link$iv2);
                        try {
                            $this$Content_u24lambda_u244_u243.append(this$0.expandableTextConfig.getToExpand());
                            Unit unit4 = Unit.INSTANCE;
                            $this$Content_u24lambda_u244_u243.pop(index$iv);
                            string = $this$Content_u24lambda_u244_u243.toAnnotatedString();
                            $composer.endReplaceGroup();
                        } finally {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                }
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(101973510);
                $composer.endReplaceGroup();
                string = this$0.content.getString();
            }
            AnnotatedString contentText = string;
            Map inlineTextContent2 = this$0.content.getInlineTextContent();
            KParagraph.KParagraphFormat kParagraphFormat = this$0.format;
            KParagraph.KParagraphAlign align = kParagraphFormat != null ? kParagraphFormat.getAlign() : null;
            if (align instanceof KParagraph.KParagraphAlign.MIDDLE) {
                i = TextAlign.Companion.getCenter-e0LSkKk();
            } else {
                i = align instanceof KParagraph.KParagraphAlign.RIGHT ? TextAlign.Companion.getRight-e0LSkKk() : TextAlign.Companion.getLeft-e0LSkKk();
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 3310116, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
            boolean invalid$iv5 = $composer.changed(this$0);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$Content$2$1$1

                    /* compiled from: ExpandableTextParagraph.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$Content$2$1$1$1", f = "ExpandableTextParagraph.kt", i = {0, 0, 1, 1, 1, 1}, l = {265, 275}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "result", "$this$awaitEachGesture", "result", "down", "longPressTimeout"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "J$0"}, v = 1)
                    /* renamed from: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$Content$2$1$1$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                        long J$0;
                        private /* synthetic */ Object L$0;
                        Object L$1;
                        Object L$2;
                        int label;
                        final /* synthetic */ ExpandableTextParagraphContent this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(ExpandableTextParagraphContent expandableTextParagraphContent, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = expandableTextParagraphContent;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                            return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[RETURN] */
                        /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
                        /* JADX WARN: Removed duplicated region for block: B:40:0x0103  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object invokeSuspend(Object $result) {
                            PointerInputChange upOrCancel;
                            Pair findTextNodeOfIndex;
                            TextParagraphClickListener textParagraphClickListener;
                            Object awaitFirstDown$default;
                            TextLayoutResult result;
                            PointerInputChange down;
                            PointerInputChange upOrCancel2;
                            Object withTimeout;
                            AwaitPointerEventScope $this$awaitEachGesture = (AwaitPointerEventScope) this.L$0;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            long longPressTimeout = this.label;
                            try {
                            } catch (PointerEventTimeoutCancellationException e) {
                                upOrCancel = upOrCancel2;
                            }
                            switch (longPressTimeout) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    TextLayoutResult result2 = (TextLayoutResult) this.this$0.getTextLayoutResultState().getValue();
                                    if (result2 == null) {
                                        return Unit.INSTANCE;
                                    }
                                    this.L$0 = $this$awaitEachGesture;
                                    this.L$1 = result2;
                                    this.label = 1;
                                    awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default($this$awaitEachGesture, false, PointerEventPass.Initial, (Continuation) this, 1, (Object) null);
                                    if (awaitFirstDown$default == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    result = result2;
                                    down = (PointerInputChange) awaitFirstDown$default;
                                    longPressTimeout = $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis();
                                    upOrCancel2 = null;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitEachGesture);
                                    this.L$1 = result;
                                    this.L$2 = down;
                                    this.J$0 = longPressTimeout;
                                    this.label = 2;
                                    withTimeout = $this$awaitEachGesture.withTimeout(longPressTimeout, new C00211(null), (Continuation) this);
                                    if (withTimeout == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    upOrCancel = (PointerInputChange) withTimeout;
                                    if (upOrCancel != null) {
                                        long offset = upOrCancel.getPosition-F1C5BW0();
                                        int textIndex = result.getOffsetForPosition-k-4lQ0M(offset);
                                        findTextNodeOfIndex = this.this$0.findTextNodeOfIndex(textIndex);
                                        if (findTextNodeOfIndex == null) {
                                            return Unit.INSTANCE;
                                        }
                                        int startIndex = ((Number) findTextNodeOfIndex.component1()).intValue();
                                        TextNodeBuildResult node = (TextNodeBuildResult) findTextNodeOfIndex.component2();
                                        KTextNode.IText text = node.getNode();
                                        if (text == null) {
                                            return Unit.INSTANCE;
                                        }
                                        TextNodeClickInfo info = new TextNodeClickInfo(text, TextRangeKt.TextRange(startIndex, node.getString().length() + startIndex), offset, result, (DefaultConstructorMarker) null);
                                        textParagraphClickListener = this.this$0.clickListener;
                                        if (textParagraphClickListener != null) {
                                            Boxing.boxBoolean(textParagraphClickListener.onTextNodeClick(text, info));
                                        }
                                        down.consume();
                                        upOrCancel.consume();
                                    }
                                    return Unit.INSTANCE;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    result = (TextLayoutResult) this.L$1;
                                    awaitFirstDown$default = $result;
                                    down = (PointerInputChange) awaitFirstDown$default;
                                    longPressTimeout = $this$awaitEachGesture.getViewConfiguration().getLongPressTimeoutMillis();
                                    upOrCancel2 = null;
                                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitEachGesture);
                                    this.L$1 = result;
                                    this.L$2 = down;
                                    this.J$0 = longPressTimeout;
                                    this.label = 2;
                                    withTimeout = $this$awaitEachGesture.withTimeout(longPressTimeout, new C00211(null), (Continuation) this);
                                    if (withTimeout == coroutine_suspended) {
                                    }
                                    upOrCancel = (PointerInputChange) withTimeout;
                                    if (upOrCancel != null) {
                                    }
                                    return Unit.INSTANCE;
                                case 2:
                                    longPressTimeout = this.J$0;
                                    upOrCancel2 = null;
                                    down = (PointerInputChange) this.L$2;
                                    result = (TextLayoutResult) this.L$1;
                                    ResultKt.throwOnFailure($result);
                                    withTimeout = $result;
                                    upOrCancel = (PointerInputChange) withTimeout;
                                    if (upOrCancel != null) {
                                    }
                                    return Unit.INSTANCE;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: ExpandableTextParagraph.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$Content$2$1$1$1$1", f = "ExpandableTextParagraph.kt", i = {0}, l = {276}, m = "invokeSuspend", n = {"$this$withTimeout"}, s = {"L$0"}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$Content$2$1$1$1$1  reason: invalid class name and collision with other inner class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class C00211 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
                            private /* synthetic */ Object L$0;
                            int label;

                            C00211(Continuation<? super C00211> continuation) {
                                super(2, continuation);
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                Continuation<Unit> c00211 = new C00211(continuation);
                                c00211.L$0 = obj;
                                return c00211;
                            }

                            public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
                                return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                AwaitPointerEventScope $this$withTimeout = (AwaitPointerEventScope) this.L$0;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$withTimeout);
                                        this.label = 1;
                                        Object waitForUpOrCancellation = TapGestureDetectorKt.waitForUpOrCancellation($this$withTimeout, PointerEventPass.Main, (Continuation) this);
                                        if (waitForUpOrCancellation == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return waitForUpOrCancellation;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        return $result;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            }
                        }
                    }

                    public final Object invoke(PointerInputScope $this$pointerInput, Continuation<? super Unit> continuation) {
                        Object awaitEachGesture = ForEachGestureKt.awaitEachGesture($this$pointerInput, new AnonymousClass1(ExpandableTextParagraphContent.this, null), continuation);
                        return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(SuspendingPointerInputFilterKt.pointerInput(modifier, contentText, (PointerInputEventHandler) it$iv5), 0.0f, 1, (Object) null);
            int maxLine = this$0.textParagraphConfig.getMaxLine();
            int i3 = this$0.textParagraphConfig.getOverflow-gIe3tQ8();
            TextAlign textAlign = TextAlign.box-impl(i);
            ComposerKt.sourceInformationMarkerStart($composer, 3383886, "CC(remember):ExpandableTextParagraph.kt#9igjgp");
            boolean invalid$iv6 = $composer.changed(this$0);
            Object it$iv6 = $composer.rememberedValue();
            if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function1() { // from class: kntr.app.im.chat.ui.module.pushAdditionalMsg.paragraph.ExpandableTextParagraphContent$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$4$5$0;
                        Content$lambda$4$5$0 = ExpandableTextParagraphContent.Content$lambda$4$5$0(ExpandableTextParagraphContent.this, (TextLayoutResult) obj);
                        return Content$lambda$4$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Z58ophY(contentText, fillMaxWidth$default, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, textAlign, 0L, i3, false, maxLine, 0, inlineTextContent2, (Function1) it$iv6, $style, $composer, 0, 0, 44028);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content$lambda$4$0$1$0(AnnotatedString $text, MutableState $expanded$delegate, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IMLog.Companion.i("ExpandableTextParagraphContent", "click to collapse, text=" + $text);
        Content$lambda$2($expanded$delegate, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Content$lambda$4$3$1$0(AnnotatedString $text, MutableState $expanded$delegate, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IMLog.Companion.i("ExpandableTextParagraphContent", "click to expand, text=" + $text);
        Content$lambda$2($expanded$delegate, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$4$5$0(ExpandableTextParagraphContent this$0, TextLayoutResult it) {
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
}