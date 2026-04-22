package kntr.common.ouro.ui.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.mark.OuroBackgroundColorMark;
import kntr.common.ouro.core.model.mark.OuroColor;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroFontWeightMark;
import kntr.common.ouro.core.model.mark.OuroForegroundColorMark;
import kntr.common.ouro.core.model.mark.OuroItalicMark;
import kntr.common.ouro.core.model.mark.OuroLineHeightMark;
import kntr.common.ouro.core.model.mark.OuroLineHeightStyle;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksKt;
import kntr.common.ouro.core.model.mark.OuroMediumMark;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.mark.OuroRegularMark;
import kntr.common.ouro.core.model.mark.OuroSemiBoldMark;
import kntr.common.ouro.core.model.mark.OuroStrikethroughMark;
import kntr.common.ouro.core.model.mark.OuroSubscriptMark;
import kntr.common.ouro.core.model.mark.OuroSuperscriptMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignJustifyMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignStartMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.mark.OuroTextMark;
import kntr.common.ouro.core.model.mark.OuroTextSpacingMark;
import kntr.common.ouro.core.model.mark.OuroUnderlineMark;
import kntr.common.ouro.core.model.mark.OuroUnmergableMark;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.ui.utils.ListOrder;
import kntr.common.ouro.ui.utils.OuroAnnotatedString;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.common.ouroboros.editor.ui.generated.resources.Font0_commonMainKt;
import srcs.common.ouroboros.editor.ui.generated.resources.Res;

/* compiled from: AnnotatedStringUtils.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001aT\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a1\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0013\"\n\b\u0000\u0010\u0014\u0018\u0001*\u00020\u0015*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0016H\u0080\b\u001a*\u0010\u0017\u001a\u0004\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a \u0010\u001e\u001a\u0004\u0018\u00010\u001f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020 0\u001a2\u0006\u0010!\u001a\u00020\u000fH\u0002\u001a\r\u0010\"\u001a\u00020#H\u0007¢\u0006\u0002\u0010$\u001a&\u0010%\u001a\u0004\u0018\u0001H&\"\n\b\u0000\u0010&\u0018\u0001*\u00020\u001b*\b\u0012\u0004\u0012\u00020\u001b0\u0013H\u0082\b¢\u0006\u0002\u0010'\u001a\u001a\u0010(\u001a\u00020)*\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010*\u001a\u00020)H\u0000\u001a\u001a\u0010+\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010*\u001a\u00020\u000fH\u0000\u001a\u001a\u0010,\u001a\u00020-*\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010*\u001a\u00020-H\u0000\u001a\f\u0010.\u001a\u00020/*\u00020-H\u0002¨\u00060"}, d2 = {"buildAnnotatedString", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString;", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "context", "Lkntr/common/ouro/ui/utils/AnnotatedStringBuilderContext;", "appendNode", "", "builder", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString$Builder;", "node", "Lkntr/common/ouro/core/model/node/OuroNode;", "listOrder", "Lkntr/common/ouro/ui/utils/ListOrder;", "indent", "", "listPrefixIndent", "alpha", "getMergedMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "MARK", "Lkntr/common/ouro/core/model/mark/OuroMark;", "Lkntr/common/ouro/core/model/node/OuroNode$Markable;", "spanStyleFromMarks", "Landroidx/compose/ui/text/SpanStyle;", "marks", "", "Lkntr/common/ouro/core/model/mark/OuroTextMark;", "theme", "Lcom/bilibili/compose/theme/ThemeDayNight;", "paragraphStyleFromMarks", "Landroidx/compose/ui/text/ParagraphStyle;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "additionalIndent", "placeholderFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/font/FontFamily;", "findMarkOrNull", "T", "(Lkntr/common/ouro/core/model/mark/OuroMarks;)Lkntr/common/ouro/core/model/mark/OuroTextMark;", "getColorOrDefault", "Lkntr/common/ouro/core/model/mark/OuroColor;", "default", "getFontSizeOrDefault", "getFontWeightOrDefault", "Lkntr/common/ouro/core/model/mark/OuroFontWeightMark;", "toComposeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AnnotatedStringUtilsKt {

    /* compiled from: AnnotatedStringUtils.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[OuroLineHeightStyle.Trim.values().length];
            try {
                iArr[OuroLineHeightStyle.Trim.FirstLineTop.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OuroLineHeightStyle.Trim.LastLineBottom.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OuroLineHeightStyle.Trim.Both.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[OuroLineHeightStyle.Trim.None.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OuroLineHeightStyle.Mode.values().length];
            try {
                iArr2[OuroLineHeightStyle.Mode.Fixed.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr2[OuroLineHeightStyle.Mode.Minimum.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final OuroAnnotatedString buildAnnotatedString(NodeStorage<OuroDocument> nodeStorage, AnnotatedStringBuilderContext context) {
        OuroAnnotatedString res;
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (context.isEmptyContainer$ui_debug()) {
            res = new OuroAnnotatedString(null, null, null, null, null, 31, null);
        } else {
            OuroAnnotatedString.Builder $this$buildAnnotatedString_u24lambda_u240 = new OuroAnnotatedString.Builder(new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null), null, null, null, null, null, 62, null);
            appendNode$default(nodeStorage, $this$buildAnnotatedString_u24lambda_u240, nodeStorage.getRoot(), null, 0.0f, 0.0f, 0.0f, context, 60, null);
            res = $this$buildAnnotatedString_u24lambda_u240.toAnnotatedString();
        }
        context.getListOrderLayoutCache().update();
        return res;
    }

    static /* synthetic */ void appendNode$default(NodeStorage nodeStorage, OuroAnnotatedString.Builder builder, OuroNode ouroNode, ListOrder listOrder, float f, float f2, float f3, AnnotatedStringBuilderContext annotatedStringBuilderContext, int i, Object obj) {
        appendNode(nodeStorage, builder, ouroNode, (i & 4) != 0 ? null : listOrder, (i & 8) != 0 ? 0.0f : f, (i & 16) != 0 ? 0.0f : f2, (i & 32) != 0 ? 1.0f : f3, annotatedStringBuilderContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void appendNode(NodeStorage<OuroDocument> nodeStorage, OuroAnnotatedString.Builder builder, OuroNode node, ListOrder listOrder, float indent, float listPrefixIndent, float alpha, AnnotatedStringBuilderContext context) {
        Iterable children;
        ListOrderStyle style;
        int start$iv;
        boolean add;
        boolean add2;
        boolean add3;
        if (node instanceof OuroTextElement) {
            OuroNode.Markable node$iv = (OuroNode.Markable) node;
            OuroMarks marks = (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, node$iv, new OuroMarks(new OuroTextMark[0]), new Function2<OuroMarks<OuroTextMark>, OuroNode, OuroMarks<OuroTextMark>>() { // from class: kntr.common.ouro.ui.utils.AnnotatedStringUtilsKt$appendNode$$inlined$getMergedMarks$1
                public final OuroMarks<OuroTextMark> invoke(OuroMarks<OuroTextMark> ouroMarks, OuroNode node2) {
                    Intrinsics.checkNotNullParameter(ouroMarks, "acc");
                    Intrinsics.checkNotNullParameter(node2, "node");
                    if (node2 instanceof OuroNode.Markable) {
                        Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node2).getMarks();
                        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                        Collection destination$iv$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                            if (element$iv$iv$iv instanceof OuroTextMark) {
                                destination$iv$iv$iv.add(element$iv$iv$iv);
                            }
                        }
                        return OuroMarksKt.mergeParent(ouroMarks, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                    }
                    return ouroMarks;
                }
            });
            SpanStyle style2 = spanStyleFromMarks(marks, alpha, context.getTheme());
            SpanStyle style$iv = style2 == null ? new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65535, (DefaultConstructorMarker) null) : style2;
            OuroBackgroundColorMark it = (OuroBackgroundColorMark) marks.get(OuroBackgroundColorMark.Key.INSTANCE);
            OuroCustomStyle backgroundStyle$iv = it != null ? new BackgroundStyle(Color.copy-wmQWz5c$default(ColorKt.Color(it.getColor().colorForTheme(context.getTheme())), alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, 2, null) : null;
            builder.annotatedStringBuilder.pushStyle(style$iv);
            try {
                if (backgroundStyle$iv != null) {
                    try {
                        OuroCustomStyle style$iv$iv = backgroundStyle$iv;
                        builder.push(MapsKt.mapOf(TuplesKt.to(style$iv$iv.getKey(), style$iv$iv)));
                        int start$iv$iv = builder.getLength();
                        builder.append(((OuroTextElement) node).getMeta());
                        try {
                            try {
                                if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv$iv.getKey())) != null) {
                                    int end$iv$iv = builder.getLength();
                                    if (style$iv$iv instanceof DrawableStyle) {
                                        try {
                                            try {
                                                add3 = builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv$iv, end$iv$iv), style$iv$iv, null));
                                            } catch (Throwable th) {
                                                th = th;
                                                builder.annotatedStringBuilder.pop();
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    } else if (style$iv$iv instanceof QuoteStyle) {
                                        add3 = builder.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv$iv, end$iv$iv), style$iv$iv, null));
                                    } else if (style$iv$iv instanceof ListOrderStyle) {
                                        add3 = builder.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv$iv, end$iv$iv), style$iv$iv, null));
                                    } else if (!(style$iv$iv instanceof BackgroundStyle)) {
                                        throw new NoWhenBranchMatchedException();
                                    } else {
                                        add3 = builder.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv$iv, end$iv$iv), style$iv$iv, null));
                                    }
                                    Boolean.valueOf(add3);
                                }
                                builder.pop();
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    builder.append(((OuroTextElement) node).getMeta());
                }
                builder.annotatedStringBuilder.pop();
                Unit unit = Unit.INSTANCE;
            }
        } else if (node instanceof OuroParagraph) {
            OuroNode.Markable node$iv2 = (OuroNode.Markable) node;
            OuroMarks marks2 = (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, node$iv2, new OuroMarks(new OuroMark[0]), new Function2<OuroMarks<OuroMark>, OuroNode, OuroMarks<OuroMark>>() { // from class: kntr.common.ouro.ui.utils.AnnotatedStringUtilsKt$appendNode$$inlined$getMergedMarks$2
                public final OuroMarks<OuroMark> invoke(OuroMarks<OuroMark> ouroMarks, OuroNode node2) {
                    Intrinsics.checkNotNullParameter(ouroMarks, "acc");
                    Intrinsics.checkNotNullParameter(node2, "node");
                    if (node2 instanceof OuroNode.Markable) {
                        Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node2).getMarks();
                        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                        Collection destination$iv$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                            if (element$iv$iv$iv instanceof OuroMark) {
                                destination$iv$iv$iv.add(element$iv$iv$iv);
                            }
                        }
                        return OuroMarksKt.mergeParent(ouroMarks, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                    }
                    return ouroMarks;
                }
            });
            Iterable $this$filterIsInstance$iv$iv = marks2;
            Collection destination$iv$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                if (element$iv$iv$iv instanceof OuroParagraphMark) {
                    destination$iv$iv$iv.add(element$iv$iv$iv);
                }
            }
            ParagraphStyle style3 = paragraphStyleFromMarks(new OuroMarks((List) destination$iv$iv$iv), indent + listPrefixIndent);
            builder.annotatedStringBuilder.pushStyle(style3 == null ? new ParagraphStyle(0, 0, 0L, (TextIndent) null, (PlatformParagraphStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 511, (DefaultConstructorMarker) null) : style3);
            try {
                NodeStorage<OuroDocument> nodeStorage2 = nodeStorage;
                try {
                    Iterable children2 = nodeStorage2.getChildren((OuroNode.Parent) node);
                    if (children2 != null) {
                        Iterable $this$forEach$iv = children2;
                        for (Object element$iv : $this$forEach$iv) {
                            OuroNode it2 = (OuroNode) element$iv;
                            OuroMarks marks3 = marks2;
                            NodeStorage<OuroDocument> nodeStorage3 = nodeStorage2;
                            try {
                                appendNode(nodeStorage, builder, it2, listOrder, indent, listPrefixIndent, alpha, context);
                                nodeStorage2 = nodeStorage3;
                                marks2 = marks3;
                            } catch (Throwable th6) {
                                th = th6;
                                builder.annotatedStringBuilder.pop();
                                throw th;
                            }
                        }
                    }
                    builder.annotatedStringBuilder.pop();
                    Unit unit2 = Unit.INSTANCE;
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                th = th8;
            }
        } else if (node instanceof OuroLink) {
            Iterable children3 = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children3 != null) {
                Iterable $this$forEach$iv2 = children3;
                for (Object element$iv2 : $this$forEach$iv2) {
                    OuroNode it3 = (OuroNode) element$iv2;
                    appendNode(nodeStorage, builder, it3, listOrder, indent, listPrefixIndent, alpha, context);
                }
                Unit unit3 = Unit.INSTANCE;
            }
        } else if (node instanceof OuroDrawable) {
            long displaySize = DrawableUtilsKt.displaySize$default((OuroDrawable) node, nodeStorage, context.getMainAxisLength(), context.getDensity(), null, 8, null);
            long fontSize = TextUnitKt.getSp(Math.max(DpSize.getHeight-D9Ej5fM(displaySize), 1.0f));
            float scaleX = DpSize.getHeight-D9Ej5fM(displaySize) > 0.0f ? DpSize.getWidth-D9Ej5fM(displaySize) / DpSize.getHeight-D9Ej5fM(displaySize) : 1.0f;
            OuroCustomStyle style$iv2 = new DrawableStyle((OuroDrawable) node, displaySize, null);
            builder.push(MapsKt.mapOf(TuplesKt.to(style$iv2.getKey(), style$iv2)));
            int start$iv2 = builder.getLength();
            try {
                try {
                    builder.annotatedStringBuilder.pushStyle(new SpanStyle(0L, fontSize, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, context.getPlaceholderFontFamily(), (String) null, 0L, (BaselineShift) null, new TextGeometricTransform(scaleX, 0.0f, 2, (DefaultConstructorMarker) null), (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 64989, (DefaultConstructorMarker) null));
                    builder.append("\u200b");
                    builder.annotatedStringBuilder.pop();
                    if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv2.getKey())) != null) {
                        Boolean.valueOf(builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv2, builder.getLength()), style$iv2, null)));
                    }
                    builder.pop();
                    Unit unit4 = Unit.INSTANCE;
                } catch (Throwable th9) {
                    th = th9;
                    if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv2.getKey())) != null) {
                        Boolean.valueOf(builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv2, builder.getLength()), style$iv2, null)));
                    }
                    builder.pop();
                    throw th;
                }
            } catch (Throwable th10) {
                th = th10;
            }
        } else if (node instanceof OuroQuoteBlock) {
            OuroCustomStyle style$iv3 = QuoteStyle.INSTANCE;
            builder.push(MapsKt.mapOf(TuplesKt.to(style$iv3.getKey(), style$iv3)));
            int start$iv3 = builder.getLength();
            try {
                Iterable children4 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children4 != null) {
                    Iterable $this$forEach$iv3 = children4;
                    for (Object element$iv3 : $this$forEach$iv3) {
                        OuroNode it4 = (OuroNode) element$iv3;
                        appendNode(nodeStorage, builder, it4, listOrder, indent + QuoteStyle.INSTANCE.getIndent(), listPrefixIndent, QuoteStyle.INSTANCE.getAlpha(), context);
                    }
                    Unit unit5 = Unit.INSTANCE;
                }
                if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv3.getKey())) != null) {
                    int end$iv = builder.getLength();
                    if (style$iv3 instanceof DrawableStyle) {
                        add2 = builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv), style$iv3, null));
                    } else if (style$iv3 instanceof QuoteStyle) {
                        add2 = builder.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv), style$iv3, null));
                    } else if (style$iv3 instanceof ListOrderStyle) {
                        add2 = builder.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv), style$iv3, null));
                    } else if (!(style$iv3 instanceof BackgroundStyle)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        add2 = builder.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv), style$iv3, null));
                    }
                    Boolean.valueOf(add2);
                }
                builder.pop();
                Unit unit6 = Unit.INSTANCE;
            } catch (Throwable th11) {
                if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv3.getKey())) != null) {
                    int end$iv2 = builder.getLength();
                    if (style$iv3 instanceof DrawableStyle) {
                        add = builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv2), style$iv3, null));
                    } else if (style$iv3 instanceof QuoteStyle) {
                        add = builder.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv2), style$iv3, null));
                    } else if (style$iv3 instanceof ListOrderStyle) {
                        add = builder.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv2), style$iv3, null));
                    } else if (!(style$iv3 instanceof BackgroundStyle)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        add = builder.backgrounds.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv3, end$iv2), style$iv3, null));
                    }
                    Boolean.valueOf(add);
                }
                builder.pop();
                throw th11;
            }
        } else if (node instanceof OuroOrderedList) {
            Iterable children5 = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children5 != null) {
                Iterable $this$forEachIndexed$iv = children5;
                int index$iv = 0;
                for (Object item$iv : $this$forEachIndexed$iv) {
                    int index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    OuroNode child = (OuroNode) item$iv;
                    int index = index$iv;
                    appendNode(nodeStorage, builder, child, new ListOrder.Ordered(listOrder != null ? listOrder.getLevel() + 1 : 1, ((OuroOrderedList) node).getStartIndex() + index), indent, listPrefixIndent, alpha, context);
                    index$iv = index$iv2;
                }
                Unit unit7 = Unit.INSTANCE;
            }
        } else if (node instanceof OuroUnorderedList) {
            Iterable children6 = nodeStorage.getChildren((OuroNode.Parent) node);
            if (children6 != null) {
                Iterable $this$forEachIndexed$iv2 = children6;
                int index$iv3 = 0;
                for (Object item$iv2 : $this$forEachIndexed$iv2) {
                    int index$iv4 = index$iv3 + 1;
                    if (index$iv3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    OuroNode child2 = (OuroNode) item$iv2;
                    appendNode(nodeStorage, builder, child2, new ListOrder.Unordered(listOrder != null ? listOrder.getLevel() + 1 : 1), indent, listPrefixIndent, alpha, context);
                    index$iv3 = index$iv4;
                }
                Unit unit8 = Unit.INSTANCE;
            }
        } else if (!(node instanceof OuroListItem)) {
            if ((node instanceof OuroNode.Parent) && (children = nodeStorage.getChildren((OuroNode.Parent) node)) != null) {
                Iterable $this$forEach$iv4 = children;
                for (Object element$iv4 : $this$forEach$iv4) {
                    OuroNode it5 = (OuroNode) element$iv4;
                    appendNode(nodeStorage, builder, it5, listOrder, indent, listPrefixIndent, alpha, context);
                }
                Unit unit9 = Unit.INSTANCE;
            }
            Unit unit10 = Unit.INSTANCE;
        } else if (listOrder != null && (style = listOrder.style(((OuroListItem) node).getPrefixMarks(), context.getListOrderLayoutCache(), context.getTextMeasure(), context.getDensity(), context.getTheme())) != null) {
            ListOrderStyle style4 = style;
            ListOrderStyle style$iv4 = style4;
            builder.push(MapsKt.mapOf(TuplesKt.to(style$iv4.getKey(), style$iv4)));
            int start$iv4 = builder.getLength();
            try {
                Iterable children7 = nodeStorage.getChildren((OuroNode.Parent) node);
                if (children7 != null) {
                    Iterable $this$forEach$iv5 = children7;
                    for (Object element$iv5 : $this$forEach$iv5) {
                        OuroNode it6 = (OuroNode) element$iv5;
                        float indent2 = indent + style4.getIndent();
                        float prefixIndent = style4.getPrefixIndent();
                        ListOrderStyle style5 = style4;
                        start$iv = start$iv4;
                        try {
                            appendNode(nodeStorage, builder, it6, listOrder, indent2, prefixIndent, alpha, context);
                            start$iv4 = start$iv;
                            style4 = style5;
                        } catch (Throwable th12) {
                            th = th12;
                            if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv4.getKey())) != null) {
                                int end$iv3 = builder.getLength();
                                Boolean.valueOf(!(style$iv4 instanceof DrawableStyle) ? style$iv4 instanceof QuoteStyle ? builder.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv3), style$iv4, null)) : builder.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv3), style$iv4, null)) : builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv3), style$iv4, null)));
                            }
                            builder.pop();
                            throw th;
                        }
                    }
                    start$iv = start$iv4;
                    Unit unit11 = Unit.INSTANCE;
                } else {
                    start$iv = start$iv4;
                }
                if (((OuroCustomStyle) builder.currentAnnotations().get(style$iv4.getKey())) != null) {
                    int end$iv4 = builder.getLength();
                    Boolean.valueOf(style$iv4 instanceof DrawableStyle ? builder.drawables.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv4), style$iv4, null)) : style$iv4 instanceof QuoteStyle ? builder.quotes.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv4), style$iv4, null)) : builder.listOrders.add(new CustomAnnotation(TextRangeKt.TextRange(start$iv, end$iv4), style$iv4, null)));
                }
                builder.pop();
                Unit unit12 = Unit.INSTANCE;
                Unit unit13 = Unit.INSTANCE;
            } catch (Throwable th13) {
                th = th13;
                start$iv = start$iv4;
            }
        }
    }

    public static final /* synthetic */ <MARK extends OuroMark> OuroMarks<MARK> getMergedMarks(NodeStorage<?> nodeStorage, OuroNode.Markable<MARK> markable) {
        Intrinsics.checkNotNullParameter(nodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(markable, "node");
        Intrinsics.reifiedOperationMarker(0, "MARK?");
        OuroMarks ouroMarks = new OuroMarks(new OuroMark[0]);
        Intrinsics.needClassReification();
        return (OuroMarks) OuroNodeStorageUtilsKt.reduce(nodeStorage, markable, ouroMarks, AnnotatedStringUtilsKt$getMergedMarks$1.INSTANCE);
    }

    static /* synthetic */ SpanStyle spanStyleFromMarks$default(Collection collection, float f, ThemeDayNight themeDayNight, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        return spanStyleFromMarks(collection, f, themeDayNight);
    }

    private static final SpanStyle spanStyleFromMarks(Collection<? extends OuroTextMark> collection, float alpha, ThemeDayNight theme) {
        Color color = null;
        FontWeight fontWeight = null;
        FontStyle fontStyle = null;
        TextDecoration decoration = null;
        TextUnit fontSize = null;
        TextUnit letterSpacing = null;
        BaselineShift baselineShift = null;
        for (OuroTextMark mark : collection) {
            if (mark instanceof OuroRegularMark) {
                fontWeight = FontWeight.Companion.getW400();
            } else if (mark instanceof OuroMediumMark) {
                fontWeight = FontWeight.Companion.getW700();
            } else if (mark instanceof OuroSemiBoldMark) {
                fontWeight = FontWeight.Companion.getW700();
            } else if (mark instanceof OuroItalicMark) {
                fontStyle = FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA());
            } else if (mark instanceof OuroUnderlineMark) {
                decoration = (decoration == null ? TextDecoration.Companion.getNone() : decoration).plus(TextDecoration.Companion.getUnderline());
            } else if (mark instanceof OuroStrikethroughMark) {
                decoration = (decoration == null ? TextDecoration.Companion.getNone() : decoration).plus(TextDecoration.Companion.getLineThrough());
            } else if (mark instanceof OuroSubscriptMark) {
                baselineShift = BaselineShift.box-impl(BaselineShift.Companion.getSubscript-y9eOQZs());
            } else if (mark instanceof OuroSuperscriptMark) {
                baselineShift = BaselineShift.box-impl(BaselineShift.Companion.getSuperscript-y9eOQZs());
            } else if (mark instanceof OuroForegroundColorMark) {
                color = Color.box-impl(Color.copy-wmQWz5c$default(ColorKt.Color(((OuroForegroundColorMark) mark).getColor().colorForTheme(theme)), alpha, 0.0f, 0.0f, 0.0f, 14, (Object) null));
            } else if (mark instanceof OuroFontSizeMark) {
                fontSize = TextUnit.box-impl(TextUnitKt.getSp(((OuroFontSizeMark) mark).getSize()));
            } else if (mark instanceof OuroTextSpacingMark) {
                letterSpacing = TextUnit.box-impl(TextUnitKt.getEm(((OuroTextSpacingMark) mark).getSpacing()));
            } else if (!(mark instanceof OuroBackgroundColorMark) && !(mark instanceof OuroUnmergableMark)) {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (color != null || fontWeight != null || fontStyle != null || decoration != null || fontSize != null || letterSpacing != null || baselineShift != null) {
            return new SpanStyle(color != null ? color.unbox-impl() : Color.Companion.getUnspecified-0d7_KjU(), fontSize != null ? fontSize.unbox-impl() : TextUnit.Companion.getUnspecified-XSAIIZE(), fontWeight, fontStyle, (FontSynthesis) null, (FontFamily) null, (String) null, letterSpacing != null ? letterSpacing.unbox-impl() : TextUnit.Companion.getUnspecified-XSAIIZE(), baselineShift, (TextGeometricTransform) null, (LocaleList) null, 0L, decoration, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61040, (DefaultConstructorMarker) null);
        }
        return null;
    }

    private static final ParagraphStyle paragraphStyleFromMarks(Collection<? extends OuroParagraphMark> collection, float additionalIndent) {
        int i;
        int i2;
        TextAlign textAlign = null;
        TextUnit lineHeight = null;
        LineHeightStyle lineHeightStyle = null;
        float firstLineIndent = additionalIndent;
        float indent = additionalIndent;
        for (OuroParagraphMark mark : collection) {
            if (mark instanceof OuroTextAlignStartMark) {
                textAlign = TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk());
            } else if (mark instanceof OuroTextAlignCenterMark) {
                textAlign = TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk());
            } else if (mark instanceof OuroTextAlignEndMark) {
                textAlign = TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk());
            } else if (mark instanceof OuroTextAlignJustifyMark) {
                textAlign = TextAlign.box-impl(TextAlign.Companion.getJustify-e0LSkKk());
            } else if (mark instanceof OuroLineHeightMark) {
                lineHeight = TextUnit.box-impl(TextUnitKt.getSp(((OuroLineHeightMark) mark).getHeight()));
                float f = LineHeightStyle.Alignment.constructor-impl(((OuroLineHeightMark) mark).getStyle().m1968getAlignmentPqGQbD4());
                switch (WhenMappings.$EnumSwitchMapping$0[((OuroLineHeightMark) mark).getStyle().getTrim().ordinal()]) {
                    case 1:
                        i = LineHeightStyle.Trim.Companion.getFirstLineTop-EVpEnUU();
                        break;
                    case 2:
                        i = LineHeightStyle.Trim.Companion.getLastLineBottom-EVpEnUU();
                        break;
                    case 3:
                        i = LineHeightStyle.Trim.Companion.getBoth-EVpEnUU();
                        break;
                    case 4:
                        i = LineHeightStyle.Trim.Companion.getNone-EVpEnUU();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                switch (WhenMappings.$EnumSwitchMapping$1[((OuroLineHeightMark) mark).getStyle().getMode().ordinal()]) {
                    case 1:
                        i2 = LineHeightStyle.Mode.Companion.getFixed-lzQqcRY();
                        break;
                    case 2:
                        i2 = LineHeightStyle.Mode.Companion.getMinimum-lzQqcRY();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                lineHeightStyle = new LineHeightStyle(f, i, i2, (DefaultConstructorMarker) null);
            } else if (!(mark instanceof OuroTextIndentMark)) {
                throw new NoWhenBranchMatchedException();
            } else {
                firstLineIndent += ((OuroTextIndentMark) mark).getFirstLine();
                indent += ((OuroTextIndentMark) mark).getHanging();
            }
        }
        if (textAlign == null && lineHeight == null) {
            if (firstLineIndent == 0.0f) {
                if (indent == 0.0f) {
                    return null;
                }
            }
        }
        return new ParagraphStyle(textAlign != null ? textAlign.unbox-impl() : TextAlign.Companion.getUnspecified-e0LSkKk(), 0, lineHeight != null ? lineHeight.unbox-impl() : TextUnit.Companion.getUnspecified-XSAIIZE(), new TextIndent(TextUnitKt.getSp(firstLineIndent), TextUnitKt.getSp(indent), (DefaultConstructorMarker) null), (PlatformParagraphStyle) null, lineHeightStyle, 0, 0, (TextMotion) null, 466, (DefaultConstructorMarker) null);
    }

    public static final FontFamily placeholderFontFamily(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -268829243, "C(placeholderFontFamily)509@18601L26:AnnotatedStringUtils.kt#u01e3w");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-268829243, $changed, -1, "kntr.common.ouro.ui.utils.placeholderFontFamily (AnnotatedStringUtils.kt:509)");
        }
        FontFamily FontFamily = FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getPlaceholder(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer, 0, 14)});
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return FontFamily;
    }

    private static final /* synthetic */ <T extends OuroTextMark> T findMarkOrNull(OuroMarks<OuroTextMark> ouroMarks) {
        Object element$iv;
        OuroMarks<OuroTextMark> $this$firstOrNull$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                OuroTextMark it2 = (OuroTextMark) element$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it2 instanceof OuroTextMark) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) element$iv;
    }

    public static final OuroColor getColorOrDefault(OuroMarks<OuroTextMark> ouroMarks, OuroColor ouroColor) {
        Object element$iv$iv;
        OuroColor color;
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        Intrinsics.checkNotNullParameter(ouroColor, "default");
        OuroMarks<OuroTextMark> $this$firstOrNull$iv$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv$iv = it.next();
                OuroTextMark it$iv = (OuroTextMark) element$iv$iv;
                if (it$iv instanceof OuroForegroundColorMark) {
                    break;
                }
            } else {
                element$iv$iv = null;
                break;
            }
        }
        OuroForegroundColorMark ouroForegroundColorMark = element$iv$iv instanceof OuroForegroundColorMark ? element$iv$iv : null;
        return (ouroForegroundColorMark == null || (color = ouroForegroundColorMark.getColor()) == null) ? ouroColor : color;
    }

    public static final float getFontSizeOrDefault(OuroMarks<OuroTextMark> ouroMarks, float f) {
        Object element$iv$iv;
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        OuroMarks<OuroTextMark> $this$firstOrNull$iv$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv$iv = it.next();
                OuroTextMark it$iv = (OuroTextMark) element$iv$iv;
                if (it$iv instanceof OuroFontSizeMark) {
                    break;
                }
            } else {
                element$iv$iv = null;
                break;
            }
        }
        OuroFontSizeMark ouroFontSizeMark = element$iv$iv instanceof OuroFontSizeMark ? element$iv$iv : null;
        return ouroFontSizeMark != null ? ouroFontSizeMark.getSize() : f;
    }

    public static final OuroFontWeightMark getFontWeightOrDefault(OuroMarks<OuroTextMark> ouroMarks, OuroFontWeightMark ouroFontWeightMark) {
        Object element$iv$iv;
        Intrinsics.checkNotNullParameter(ouroMarks, "<this>");
        Intrinsics.checkNotNullParameter(ouroFontWeightMark, "default");
        OuroMarks<OuroTextMark> $this$firstOrNull$iv$iv = ouroMarks;
        Iterator<MARK> it = $this$firstOrNull$iv$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv$iv = it.next();
                OuroTextMark it$iv = (OuroTextMark) element$iv$iv;
                if (it$iv instanceof OuroFontWeightMark) {
                    break;
                }
            } else {
                element$iv$iv = null;
                break;
            }
        }
        OuroFontWeightMark ouroFontWeightMark2 = element$iv$iv instanceof OuroFontWeightMark ? element$iv$iv : null;
        return ouroFontWeightMark2 == null ? ouroFontWeightMark : ouroFontWeightMark2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontWeight toComposeFontWeight(OuroFontWeightMark $this$toComposeFontWeight) {
        if ($this$toComposeFontWeight instanceof OuroRegularMark) {
            return FontWeight.Companion.getW400();
        }
        if (!($this$toComposeFontWeight instanceof OuroMediumMark) && !($this$toComposeFontWeight instanceof OuroSemiBoldMark)) {
            return FontWeight.Companion.getW400();
        }
        return FontWeight.Companion.getW700();
    }
}