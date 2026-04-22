package kntr.common.ouro.ui.utils;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.UnderlineSpan;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroH1;
import kntr.common.ouro.core.model.node.OuroH2;
import kntr.common.ouro.core.model.node.OuroH3;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.ui.span.ListItemSpan;
import kntr.common.ouro.ui.span.OuroBackgroundColorSpan;
import kntr.common.ouro.ui.span.OuroDrawableSpan;
import kntr.common.ouro.ui.span.OuroLineHeightSpan;
import kntr.common.ouro.ui.span.OuroParagraphMarksSpan;
import kntr.common.ouro.ui.span.OuroTextMarksSpanKt;
import kntr.common.ouro.ui.span.ParaSpacingHelpSpan;
import kntr.common.ouro.ui.span.QuoteBlockSpan;
import kntr.common.ouro.ui.utils.ListOrder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: SpannableStringBuilderUtils.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001ay\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0002\u0010\u001b\u001a\u0016\u0010\u001e\u001a\u00020\n*\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"PLACEHOLDER_CHAR", "", "END_PLACEHOLDER_CHAR", "spannableStringBuilder", "Landroid/text/Spannable;", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "context", "Lkntr/common/ouro/ui/utils/SpannableStringBuilderContext;", "appendNode", "", "builder", "Landroid/text/SpannableStringBuilder;", "node", "Lkntr/common/ouro/core/model/node/OuroNode;", "parentMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "listOrder", "Lkntr/common/ouro/ui/utils/ListOrder;", "indent", "", "listPrefixIndent", "foregroundColorAlpha", "backgroundColorAlpha", "isLastListItem", "", "(Lkntr/common/ouro/core/model/NodeStorage;Landroid/text/SpannableStringBuilder;Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/mark/OuroMarks;Lkntr/common/ouro/ui/utils/SpannableStringBuilderContext;Lkntr/common/ouro/ui/utils/ListOrder;FFFFLjava/lang/Boolean;)V", "CompositionSpan", "Landroid/text/style/UnderlineSpan;", "setComposition", "range", "Lkntr/common/ouro/core/model/OuroTextRange;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class SpannableStringBuilderUtilsKt {
    private static final UnderlineSpan CompositionSpan = new UnderlineSpan();
    public static final char END_PLACEHOLDER_CHAR = 8204;
    public static final char PLACEHOLDER_CHAR = 8203;

    public static final Spannable spannableStringBuilder(NodeStorage<OuroDocument> nodeStorage, SpannableStringBuilderContext context) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.isEmptyContainer$ui_debug()) {
            CharSequence $this$toSpannable$iv = new SpannableStringBuilder();
            return SpannableString.valueOf($this$toSpannable$iv);
        }
        SpannableStringBuilder builder = new SpannableStringBuilder();
        appendNode$default(nodeStorage, builder, nodeStorage.getRoot(), new OuroMarks(new OuroMark[0]), context, null, 0.0f, 0.0f, 1.0f, 1.0f, null, 624, null);
        context.getTextLayoutResultCache$ui_debug().update();
        context.clearCache$ui_debug();
        SpannableStringBuilder $this$toSpannable$iv2 = builder;
        return SpannableString.valueOf($this$toSpannable$iv2);
    }

    static /* synthetic */ void appendNode$default(NodeStorage nodeStorage, SpannableStringBuilder spannableStringBuilder, OuroNode ouroNode, OuroMarks ouroMarks, SpannableStringBuilderContext spannableStringBuilderContext, ListOrder listOrder, float f, float f2, float f3, float f4, Boolean bool, int i, Object obj) {
        appendNode(nodeStorage, spannableStringBuilder, ouroNode, ouroMarks, spannableStringBuilderContext, (i & 16) != 0 ? null : listOrder, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? 0.0f : f2, f3, f4, (i & 512) != 0 ? null : bool);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0389, code lost:
        if (r26 != null) goto L115;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void appendNode(final NodeStorage<OuroDocument> nodeStorage, SpannableStringBuilder builder, final OuroNode node, OuroMarks<OuroMark> ouroMarks, final SpannableStringBuilderContext context, ListOrder listOrder, float indent, float listPrefixIndent, float foregroundColorAlpha, float backgroundColorAlpha, Boolean isLastListItem) {
        OuroMarks ouroMarks2;
        Iterable children;
        int startIndex;
        boolean z;
        OuroDrawableMark.Padding padding;
        int endIndex;
        int startIndex2;
        OuroBackgroundColorMark ouroBackgroundColorMark;
        SpannableStringBuilder spannableStringBuilder;
        OuroDrawableSpan span;
        OuroNode ouroNode;
        int startIndex3;
        int endIndex2;
        OuroForegroundColorMark ouroForegroundColorMark;
        OuroNode ouroNode2;
        Object element$iv;
        int i;
        int startIndex4;
        Iterable mergedMarks;
        int lineHeight;
        if (node instanceof OuroNode.Markable) {
            OuroMarks<OuroMark> marks = ((OuroNode.Markable) node).getMarks();
            Intrinsics.checkNotNull(marks, "null cannot be cast to non-null type kntr.common.ouro.core.model.mark.OuroMarks<kntr.common.ouro.core.model.mark.OuroMark>");
            ouroMarks2 = context.getMergedMarks$ui_debug(marks, ouroMarks);
        } else {
            ouroMarks2 = ouroMarks;
        }
        OuroMarks mergedMarks2 = ouroMarks2;
        if (node instanceof OuroTextElement.Plain) {
            Object element$iv$iv$iv = mergedMarks2;
            boolean z2 = false;
            Iterable $this$filterIsInstance$iv$iv = (Iterable) element$iv$iv$iv;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$filterIsInstance$iv$iv) {
                Object $this$filterInstanceOf$iv = element$iv$iv$iv;
                boolean z3 = z2;
                if (element$iv$iv$iv2 instanceof OuroTextMark) {
                    destination$iv$iv$iv.add(element$iv$iv$iv2);
                }
                element$iv$iv$iv = $this$filterInstanceOf$iv;
                z2 = z3;
            }
            OuroMarks textMarks = new OuroMarks((List) destination$iv$iv$iv);
            Spannable spannable = context.getPlainTextSpannable$ui_debug((OuroTextElement.Plain) node, textMarks, foregroundColorAlpha, backgroundColorAlpha);
            builder.append((CharSequence) spannable);
            return;
        }
        boolean z4 = true;
        if (node instanceof OuroTextElement.HardBreak) {
            Spannable spannable2 = context.getHardBreakSpannable$ui_debug((listOrder == null || Intrinsics.areEqual(isLastListItem, true)) ? 24 : 8, Intrinsics.areEqual(node, CollectionsKt.lastOrNull(nodeStorage.getAllSelectables())));
            builder.append((CharSequence) spannable2);
            return;
        }
        int i2 = 33;
        if (node instanceof OuroParagraph) {
            int startIndex5 = builder.length();
            Iterable children2 = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children2 != null) {
                Iterable $this$forEach$iv = children2;
                for (Object element$iv2 : $this$forEach$iv) {
                    OuroNode child = (OuroNode) element$iv2;
                    appendNode(nodeStorage, builder, child, mergedMarks2, context, listOrder, indent, listPrefixIndent, foregroundColorAlpha, backgroundColorAlpha, isLastListItem);
                    startIndex5 = startIndex5;
                    i2 = i2;
                    mergedMarks2 = mergedMarks2;
                }
                i = i2;
                startIndex4 = startIndex5;
                mergedMarks = mergedMarks2;
                Unit unit = Unit.INSTANCE;
            } else {
                i = 33;
                startIndex4 = startIndex5;
                mergedMarks = mergedMarks2;
            }
            int endIndex3 = builder.length();
            Iterable $this$filterInstanceOf$iv2 = mergedMarks;
            Iterable $this$filterIsInstance$iv$iv2 = $this$filterInstanceOf$iv2;
            Collection destination$iv$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv3 : $this$filterIsInstance$iv$iv2) {
                if (element$iv$iv$iv3 instanceof OuroParagraphMark) {
                    destination$iv$iv$iv2.add(element$iv$iv$iv3);
                }
            }
            OuroMarks paragraphMarks = new OuroMarks((List) destination$iv$iv$iv2);
            builder.setSpan(new OuroParagraphMarksSpan(paragraphMarks, context.getDensity().getDensity(), listPrefixIndent + indent), startIndex4, endIndex3, i);
            OuroParagraph ouroParagraph = (OuroParagraph) node;
            if (ouroParagraph instanceof OuroH1) {
                lineHeight = 32;
            } else if (ouroParagraph instanceof OuroH2) {
                lineHeight = 30;
            } else if (ouroParagraph instanceof OuroH3) {
                lineHeight = 30;
            } else if (!(ouroParagraph instanceof OuroText)) {
                throw new NoWhenBranchMatchedException();
            } else {
                lineHeight = 27;
            }
            OuroLineHeightSpan lineHeightSpan = new OuroLineHeightSpan(lineHeight);
            builder.setSpan(lineHeightSpan, startIndex4, endIndex3, i);
            Unit unit2 = Unit.INSTANCE;
        } else if (node instanceof OuroLink) {
            Iterable children3 = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children3 != null) {
                Iterable $this$forEach$iv2 = children3;
                for (Object element$iv3 : $this$forEach$iv2) {
                    appendNode(nodeStorage, builder, (OuroNode) element$iv3, mergedMarks2, context, listOrder, indent, listPrefixIndent, 1.0f, backgroundColorAlpha, isLastListItem);
                }
                Unit unit3 = Unit.INSTANCE;
            }
        } else if (node instanceof OuroDrawable) {
            int startIndex6 = builder.length();
            builder.append((char) 8203);
            if (node instanceof OuroBoxContainer) {
                builder.append("\n");
            }
            int endIndex4 = builder.length();
            OuroMarks mergedMarks3 = mergedMarks2;
            long $this$appendNode_u24lambda_u242 = DrawableUtilsKt.displaySize((OuroDrawable) node, nodeStorage, context.getMainAxisLength(), context.getDensity(), mergedMarks3);
            Density $this$appendNode_u24lambda_u242_u240 = context.getDensity();
            Pair pair = new Pair(Integer.valueOf((int) $this$appendNode_u24lambda_u242_u240.toPx-0680j_4(DpSize.getWidth-D9Ej5fM($this$appendNode_u24lambda_u242))), Integer.valueOf((int) $this$appendNode_u24lambda_u242_u240.toPx-0680j_4(DpSize.getHeight-D9Ej5fM($this$appendNode_u24lambda_u242))));
            int width = ((Number) pair.component1()).intValue();
            int height = ((Number) pair.component2()).intValue();
            OuroMarks marks2 = ((OuroDrawable) node).getMarks();
            if (!(marks2 instanceof OuroMarks)) {
                marks2 = null;
            }
            if (marks2 == null || (padding = (OuroDrawableMark.Padding) marks2.get(OuroDrawableMark.Padding.Key.INSTANCE)) == null) {
                padding = new OuroDrawableMark.Padding(0.0f, 0.0f, 3, (DefaultConstructorMarker) null);
            }
            OuroDrawableMark.Padding padding2 = padding;
            final int pl = (int) (padding2.getLeft() * context.getDensity().getDensity());
            final int pt = (int) (padding2.getTop() * context.getDensity().getDensity());
            final int pr = (int) (padding2.getRight() * context.getDensity().getDensity());
            final int pb = (int) (padding2.getBottom() * context.getDensity().getDensity());
            float ratio = width / height;
            final int drawableWidth = Math.min(width, (context.getMainAxisLength() - pl) - pr);
            final int drawableHeight = (int) (drawableWidth / ratio);
            OuroDrawable ouroDrawable = (OuroDrawable) node;
            final OuroDrawableSpan.Alignment verticalAlignment = ouroDrawable instanceof OuroBoxContainer ? OuroDrawableSpan.Alignment.CENTER_TO_CENTER : ouroDrawable instanceof OuroInlineContent ? OuroDrawableSpan.Alignment.BOTTOM_TO_BOTTOM : OuroDrawableSpan.Alignment.CENTER_TO_CENTER;
            boolean isDarkTheme = context.getTheme() == ThemeDayNight.Night;
            DrawableSpanCacheKey cacheKey = new DrawableSpanCacheKey(node, drawableWidth, drawableHeight, isDarkTheme, padding2.hashCode());
            if (node instanceof OuroBoxContainer) {
                Iterable children4 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children4 != null) {
                    Iterable $this$firstOrNull$iv = children4;
                    Iterator<T> it = $this$firstOrNull$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                        Iterable $this$firstOrNull$iv2 = $this$firstOrNull$iv;
                        OuroNode it2 = (OuroNode) element$iv;
                        OuroMarks mergedMarks4 = mergedMarks3;
                        if ((((it2 instanceof OuroLocalImage) || (it2 instanceof OuroRemoteImage.Image)) ? 1 : null) != null) {
                            break;
                        }
                        $this$firstOrNull$iv = $this$firstOrNull$iv2;
                        mergedMarks3 = mergedMarks4;
                    }
                    ouroNode2 = (OuroNode) element$iv;
                } else {
                    ouroNode2 = null;
                }
            }
            z4 = false;
            boolean isBoxImage = z4;
            OuroMarks marks3 = ((OuroDrawable) node).getMarks();
            if (!(marks3 instanceof OuroMarks)) {
                marks3 = null;
            }
            final OuroColor tintColor = (marks3 == null || (ouroForegroundColorMark = (OuroForegroundColorMark) marks3.get(OuroForegroundColorMark.Key.INSTANCE)) == null) ? null : ouroForegroundColorMark.getColor();
            if (isBoxImage) {
                final int extHPadding = Math.max((((context.getMainAxisLength() - pl) - pr) - drawableWidth) / 2, 0);
                startIndex2 = startIndex6;
                endIndex = endIndex4;
                ouroBackgroundColorMark = null;
                final boolean z5 = isDarkTheme;
                span = context.getOrCreateDrawableSpan$ui_debug(cacheKey, new Function0() { // from class: kntr.common.ouro.ui.utils.SpannableStringBuilderUtilsKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        OuroDrawableSpan appendNode$lambda$4;
                        appendNode$lambda$4 = SpannableStringBuilderUtilsKt.appendNode$lambda$4(NodeStorage.this, node, pl, extHPadding, pr, context, drawableWidth, drawableHeight, pt, pb, verticalAlignment, z5, tintColor);
                        return appendNode$lambda$4;
                    }
                });
                spannableStringBuilder = builder;
            } else {
                endIndex = endIndex4;
                startIndex2 = startIndex6;
                ouroBackgroundColorMark = null;
                spannableStringBuilder = builder;
                final boolean z6 = isDarkTheme;
                span = context.getOrCreateDrawableSpan$ui_debug(cacheKey, new Function0() { // from class: kntr.common.ouro.ui.utils.SpannableStringBuilderUtilsKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        OuroDrawableSpan appendNode$lambda$5;
                        appendNode$lambda$5 = SpannableStringBuilderUtilsKt.appendNode$lambda$5(NodeStorage.this, node, context, drawableWidth, drawableHeight, pl, pt, pr, pb, verticalAlignment, z6, tintColor);
                        return appendNode$lambda$5;
                    }
                });
            }
            if (isBoxImage) {
                ouroNode = node;
                startIndex3 = startIndex2;
                endIndex2 = endIndex;
            } else {
                ouroNode = node;
                OuroMarks marks4 = ((OuroDrawable) ouroNode).getMarks();
                if (!(marks4 instanceof OuroMarks)) {
                    marks4 = ouroBackgroundColorMark;
                }
                OuroBackgroundColorMark bgColorMark = marks4 != null ? (OuroBackgroundColorMark) marks4.get(OuroBackgroundColorMark.Key.INSTANCE) : ouroBackgroundColorMark;
                if (bgColorMark != null) {
                    startIndex3 = startIndex2;
                    endIndex2 = endIndex;
                    spannableStringBuilder.setSpan(new OuroBackgroundColorSpan(Integer.valueOf(OuroTextMarksSpanKt.fade(bgColorMark.getColor().colorForTheme(context.getTheme()), backgroundColorAlpha)), Float.valueOf(bgColorMark.getHeightDp() * context.getDensity().getDensity())), startIndex3, endIndex2, 33);
                } else {
                    startIndex3 = startIndex2;
                    endIndex2 = endIndex;
                }
            }
            spannableStringBuilder.setSpan(span, startIndex3, endIndex2, 33);
            if (ouroNode instanceof OuroBoxContainer) {
                ParaSpacingHelpSpan paraSpacing = new ParaSpacingHelpSpan(24);
                spannableStringBuilder.append((char) 8203);
                spannableStringBuilder.setSpan(paraSpacing, 2, 3, 33);
                spannableStringBuilder.append("\n");
            }
            Unit unit4 = Unit.INSTANCE;
        } else {
            boolean z7 = false;
            if (node instanceof OuroQuoteBlock) {
                int startIndex7 = builder.length();
                Iterable children5 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children5 != null) {
                    Iterable $this$forEach$iv3 = children5;
                    for (Object element$iv4 : $this$forEach$iv3) {
                        OuroNode child2 = (OuroNode) element$iv4;
                        appendNode(nodeStorage, builder, child2, mergedMarks2, context, listOrder, indent + QuoteStyle.INSTANCE.getIndent(), listPrefixIndent, 0.6f, 0.6f, isLastListItem);
                        z7 = z7;
                    }
                    z = z7;
                    Unit unit5 = Unit.INSTANCE;
                } else {
                    z = false;
                }
                int endIndex5 = builder.length();
                QuoteBlockSpan quoteSpan = new QuoteBlockSpan(startIndex7, endIndex5, context.getTheme() == ThemeDayNight.Night ? true : z, null, 8, null);
                builder.setSpan(quoteSpan, startIndex7, endIndex5, 33);
                Unit unit6 = Unit.INSTANCE;
            } else if (node instanceof OuroOrderedList) {
                List<OuroNode> children6 = nodeStorage.getChildren((OuroNode.Parent) node);
                Integer lastIndex = children6 != null ? Integer.valueOf(CollectionsKt.getLastIndex(children6)) : null;
                Iterable children7 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children7 != null) {
                    Iterable $this$forEachIndexed$iv = children7;
                    int index$iv = 0;
                    for (Object item$iv : $this$forEachIndexed$iv) {
                        int index$iv2 = index$iv + 1;
                        if (index$iv < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        OuroNode child3 = (OuroNode) item$iv;
                        int index = index$iv;
                        appendNode(nodeStorage, builder, child3, mergedMarks2, context, new ListOrder.Ordered(listOrder != null ? listOrder.getLevel() + 1 : 1, ((OuroOrderedList) node).getStartIndex() + index), indent, listPrefixIndent, foregroundColorAlpha, backgroundColorAlpha, Boolean.valueOf(isLastListItem == null ? lastIndex != null && index == lastIndex.intValue() : isLastListItem.booleanValue() && lastIndex != null && index == lastIndex.intValue()));
                        index$iv = index$iv2;
                    }
                    Unit unit7 = Unit.INSTANCE;
                }
            } else if (node instanceof OuroUnorderedList) {
                List<OuroNode> children8 = nodeStorage.getChildren((OuroNode.Parent) node);
                Integer lastIndex2 = children8 != null ? Integer.valueOf(CollectionsKt.getLastIndex(children8)) : null;
                Iterable children9 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children9 != null) {
                    Iterable $this$forEachIndexed$iv2 = children9;
                    int index$iv3 = 0;
                    for (Object item$iv2 : $this$forEachIndexed$iv2) {
                        int index$iv4 = index$iv3 + 1;
                        if (index$iv3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        OuroNode child4 = (OuroNode) item$iv2;
                        int index2 = index$iv3;
                        appendNode(nodeStorage, builder, child4, mergedMarks2, context, new ListOrder.Unordered(listOrder != null ? listOrder.getLevel() + 1 : 1), indent, listPrefixIndent, foregroundColorAlpha, backgroundColorAlpha, Boolean.valueOf(isLastListItem == null ? lastIndex2 != null && index2 == lastIndex2.intValue() : isLastListItem.booleanValue() && lastIndex2 != null && index2 == lastIndex2.intValue()));
                        index$iv3 = index$iv4;
                    }
                    Unit unit8 = Unit.INSTANCE;
                }
            } else if (!(node instanceof OuroListItem)) {
                if ((node instanceof OuroNode.Parent) && (children = nodeStorage.getChildren((OuroNode.Parent) node)) != null) {
                    Iterable $this$forEachIndexed$iv3 = children;
                    int index$iv5 = 0;
                    for (Object item$iv3 : $this$forEachIndexed$iv3) {
                        int index$iv6 = index$iv5 + 1;
                        if (index$iv5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        OuroNode child5 = (OuroNode) item$iv3;
                        appendNode(nodeStorage, builder, child5, mergedMarks2, context, listOrder, indent, listPrefixIndent, foregroundColorAlpha, backgroundColorAlpha, isLastListItem);
                        index$iv5 = index$iv6;
                    }
                    Unit unit9 = Unit.INSTANCE;
                }
                Unit unit10 = Unit.INSTANCE;
            } else if (listOrder != null) {
                ListOrderStyle style = listOrder.style(((OuroListItem) node).getPrefixMarks(), context.getTextLayoutResultCache$ui_debug(), context.getTextMeasure(), context.getDensity(), context.getTheme());
                if (style != null) {
                    int startIndex8 = builder.length();
                    List<OuroNode> children10 = nodeStorage.getChildren((OuroNode.Parent) node);
                    Integer lastIndex3 = children10 != null ? Integer.valueOf(CollectionsKt.getLastIndex(children10)) : null;
                    Iterable children11 = nodeStorage.getChildren((OuroNode.Parent) node);
                    if (children11 != null) {
                        Iterable $this$forEachIndexed$iv4 = children11;
                        int index$iv7 = 0;
                        for (Object item$iv4 : $this$forEachIndexed$iv4) {
                            int index$iv8 = index$iv7 + 1;
                            if (index$iv7 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            OuroNode child6 = (OuroNode) item$iv4;
                            int index3 = index$iv7;
                            float newIndent = indent + style.getIndent();
                            int startIndex9 = startIndex8;
                            appendNode(nodeStorage, builder, child6, mergedMarks2, context, listOrder, newIndent, style.getPrefixIndent(), foregroundColorAlpha, backgroundColorAlpha, Boolean.valueOf(isLastListItem == null ? lastIndex3 != null && index3 == lastIndex3.intValue() : isLastListItem.booleanValue() && lastIndex3 != null && index3 == lastIndex3.intValue()));
                            startIndex8 = startIndex9;
                            index$iv7 = index$iv8;
                        }
                        startIndex = startIndex8;
                        Unit unit11 = Unit.INSTANCE;
                    } else {
                        startIndex = startIndex8;
                    }
                    int endIndex6 = builder.length();
                    ListItemSpan listItemSpan = new ListItemSpan(style, context.getDensity());
                    builder.setSpan(listItemSpan, startIndex, endIndex6, 33);
                    Unit unit12 = Unit.INSTANCE;
                    Unit unit13 = Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroDrawableSpan appendNode$lambda$4(NodeStorage $this_appendNode, OuroNode $node, int $pl, int $extHPadding, int $pr, SpannableStringBuilderContext $context, int $drawableWidth, int $drawableHeight, int $pt, int $pb, OuroDrawableSpan.Alignment $verticalAlignment, boolean $isDarkTheme, OuroColor $tintColor) {
        return new OuroDrawableSpan($this_appendNode.getChildren((OuroNode.Parent) $node), $context.getDensity().getDensity(), $drawableWidth, $drawableHeight, $context, $pl + $extHPadding, $pt, $pr + $extHPadding, $pb, null, null, $verticalAlignment, $isDarkTheme, true, $tintColor, 1536, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroDrawableSpan appendNode$lambda$5(NodeStorage $this_appendNode, OuroNode $node, SpannableStringBuilderContext $context, int $drawableWidth, int $drawableHeight, int $pl, int $pt, int $pr, int $pb, OuroDrawableSpan.Alignment $verticalAlignment, boolean $isDarkTheme, OuroColor $tintColor) {
        return new OuroDrawableSpan($this_appendNode.getChildren((OuroNode.Parent) $node), $context.getDensity().getDensity(), $drawableWidth, $drawableHeight, $context, $pl, $pt, $pr, $pb, null, null, $verticalAlignment, $isDarkTheme, false, $tintColor, 1536, null);
    }

    public static final void setComposition(Spannable $this$setComposition, OuroTextRange range) {
        Intrinsics.checkNotNullParameter($this$setComposition, "<this>");
        $this$setComposition.removeSpan(CompositionSpan);
        if (range != null) {
            $this$setComposition.setSpan(CompositionSpan, RangesKt.coerceIn(range.getMin(), 0, $this$setComposition.length()), RangesKt.coerceIn(range.getMax(), 0, $this$setComposition.length()), 33);
        }
    }
}