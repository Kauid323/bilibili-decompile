package kntr.app.deepsearch.ui.paragraph.text.node;

import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KColors;
import com.bapis.bilibili.app.dynamic.v2.KEmoteNode;
import com.bapis.bilibili.app.dynamic.v2.KEmoteSize;
import com.bapis.bilibili.app.dynamic.v2.KImgInlineCfg;
import com.bapis.bilibili.app.dynamic.v2.KLinkNode;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeRich;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeShowType;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bilibili.common.paragraph.builder.ParagraphScope;
import com.bilibili.common.paragraph.impl.StyleUtilsKt;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResult;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextSpanFactory;
import com.bilibili.common.paragraph.impl.text.node.emote.InlineImageContent;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: DeepSearchLinkNodeBuilder.kt */
@ParagraphScope
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u0018\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\u001c\u0010\u0019\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J,\u0010\u001a\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lkntr/app/deepsearch/ui/paragraph/text/node/DeepSearchLinkNodeBuilder;", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KLink;", "density", "Landroidx/compose/ui/unit/Density;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "styleFactory", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "<init>", "(Landroidx/compose/ui/unit/Density;Lcom/bilibili/compose/theme/ThemeDayNight;Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;)V", "acceptType", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KTextNodeType;", "getAcceptType", "()Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KTextNodeType;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildNode", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuildResult;", "node", "rawText", RoomRecommendViewModel.EMPTY_CURSOR, "buildPlainNode", "buildRichNode", "buildEmote", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$IText;", "tNode", "Lcom/bapis/bilibili/app/dynamic/v2/KEmoteNode;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchLinkNodeBuilder implements TextNodeBuilder<KTextNode.KLink> {
    public static final int $stable = 0;
    private final Density density;
    private final TextSpanFactory styleFactory;
    private final ThemeDayNight themeDayNight;

    /* compiled from: DeepSearchLinkNodeBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public DeepSearchLinkNodeBuilder(Density density, ThemeDayNight themeDayNight, TextSpanFactory styleFactory) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        Intrinsics.checkNotNullParameter(styleFactory, "styleFactory");
        this.density = density;
        this.themeDayNight = themeDayNight;
        this.styleFactory = styleFactory;
    }

    public KTextNode.KTextNodeType getAcceptType() {
        return KTextNode.KTextNodeType.BIZ_LINK.INSTANCE;
    }

    public KClass<KTextNode.KLink> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(KTextNode.KLink.class);
    }

    public TextNodeBuildResult buildNode(KTextNode.KLink node, String rawText) {
        KLinkNode value;
        if (Intrinsics.areEqual((node == null || (value = node.getValue()) == null) ? null : value.getShowType(), KLinkNodeShowType.RICH_TEXT.INSTANCE)) {
            return buildRichNode(node, rawText);
        }
        return buildPlainNode(node, rawText);
    }

    private final TextNodeBuildResult buildPlainNode(KTextNode.KLink node, String rawText) {
        long j2;
        long color;
        if (node != null && rawText != null) {
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            KWordNode word = node.getValue().getShowText();
            if (word == null) {
                return TextNodeBuildResult.Companion.getEmpty();
            }
            TextUnit textUnit = TextUnit.box-impl(TextUnitKt.getSp(word.getFontSize()));
            long it = textUnit.unbox-impl();
            long sp = TextUnitKt.getSp(0.0d);
            TextUnitKt.checkArithmetic-NB67dxo(it, sp);
            if (!(Float.compare(TextUnit.getValue-impl(it), TextUnit.getValue-impl(sp)) > 0)) {
                textUnit = null;
            }
            long fontSize = textUnit != null ? textUnit.unbox-impl() : TextUnit.Companion.getUnspecified-XSAIIZE();
            KColors color2 = word.getColor();
            if (color2 != null) {
                color = StyleUtilsKt.getColor(color2, this.themeDayNight);
            } else {
                switch (WhenMappings.$EnumSwitchMapping$0[this.themeDayNight.ordinal()]) {
                    case 1:
                        if (!StringsKt.isBlank(node.getValue().getLink())) {
                            j2 = BiliColorsSourceKt.getNightColors().getText_link-0d7_KjU();
                            break;
                        } else {
                            j2 = BiliColorsSourceKt.getNightColors().getText1-0d7_KjU();
                            break;
                        }
                    case 2:
                        if (!StringsKt.isBlank(node.getValue().getLink())) {
                            j2 = BiliColorsSourceKt.getDayColors().getText_link-0d7_KjU();
                            break;
                        } else {
                            j2 = BiliColorsSourceKt.getDayColors().getText1-0d7_KjU();
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                color = j2;
            }
            Map inlineTextContent = new LinkedHashMap();
            if (!StringsKt.isBlank(node.getValue().getIcon())) {
                InlineTextContentKt.appendInlineContent(builder, node.getValue().getIcon(), rawText);
                String icon = node.getValue().getIcon();
                String icon2 = node.getValue().getIcon();
                Density $this$buildPlainNode_u24lambda_u242 = this.density;
                float f = $this$buildPlainNode_u24lambda_u242.toDp-GaN1DYA(fontSize);
                Density $this$buildPlainNode_u24lambda_u243 = this.density;
                inlineTextContent.put(icon, new InlineImageContent(icon2, false, DpKt.DpSize-YgX7TsA(f, $this$buildPlainNode_u24lambda_u243.toDp-GaN1DYA(fontSize)), this.density, color, ColorKt.Color(4293388263L), false, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), 64, (DefaultConstructorMarker) null).getInlineContent());
            }
            builder.append(AnnotatedStringKt.AnnotatedString$default(word.getWords(), this.styleFactory.buildSpanStyleFor(word), (ParagraphStyle) null, 4, (Object) null));
            if (!StringsKt.isBlank(node.getValue().getIconSuffix())) {
                InlineTextContentKt.appendInlineContent(builder, node.getValue().getIconSuffix(), rawText);
                String iconSuffix = node.getValue().getIconSuffix();
                String iconSuffix2 = node.getValue().getIconSuffix();
                Density $this$buildPlainNode_u24lambda_u244 = this.density;
                float f2 = $this$buildPlainNode_u24lambda_u244.toDp-GaN1DYA(fontSize);
                Density $this$buildPlainNode_u24lambda_u245 = this.density;
                inlineTextContent.put(iconSuffix, new InlineImageContent(iconSuffix2, false, DpKt.DpSize-YgX7TsA(f2, $this$buildPlainNode_u24lambda_u245.toDp-GaN1DYA(fontSize)), this.density, color, ColorKt.Color(4293388263L), false, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), 64, (DefaultConstructorMarker) null).getInlineContent());
            }
            return new TextNodeBuildResult((KTextNode.IText) node, builder.toAnnotatedString(), inlineTextContent, 0L, 8, (DefaultConstructorMarker) null);
        }
        return TextNodeBuildResult.Companion.getEmpty();
    }

    private final TextNodeBuildResult buildRichNode(KTextNode.KLink node, String rawText) {
        long j2;
        long color;
        List list;
        long j3;
        KWordNode word;
        Iterable $this$forEach$iv;
        if (node != null && rawText != null) {
            List list2 = new ArrayList();
            KWordNode word2 = node.getValue().getShowText();
            if (word2 == null) {
                return TextNodeBuildResult.Companion.getEmpty();
            }
            TextUnit textUnit = TextUnit.box-impl(TextUnitKt.getSp(word2.getFontSize()));
            long it = textUnit.unbox-impl();
            long sp = TextUnitKt.getSp(0.0d);
            TextUnitKt.checkArithmetic-NB67dxo(it, sp);
            if (!(Float.compare(TextUnit.getValue-impl(it), TextUnit.getValue-impl(sp)) > 0)) {
                textUnit = null;
            }
            long fontSize = textUnit != null ? textUnit.unbox-impl() : TextUnit.Companion.getUnspecified-XSAIIZE();
            KColors color2 = word2.getColor();
            if (color2 != null) {
                color = StyleUtilsKt.getColor(color2, this.themeDayNight);
            } else {
                switch (WhenMappings.$EnumSwitchMapping$0[this.themeDayNight.ordinal()]) {
                    case 1:
                        if (StringsKt.isBlank(node.getValue().getLink())) {
                            j2 = BiliColorsSourceKt.getNightColors().getText1-0d7_KjU();
                            break;
                        } else {
                            j2 = BiliColorsSourceKt.getNightColors().getText_link-0d7_KjU();
                            break;
                        }
                    case 2:
                        if (StringsKt.isBlank(node.getValue().getLink())) {
                            j2 = BiliColorsSourceKt.getDayColors().getText1-0d7_KjU();
                            break;
                        } else {
                            j2 = BiliColorsSourceKt.getDayColors().getText_link-0d7_KjU();
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                color = j2;
            }
            if (!StringsKt.isBlank(node.getValue().getIcon())) {
                Map inlineTextContent = new LinkedHashMap();
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                InlineTextContentKt.appendInlineContent(builder, node.getValue().getIcon(), rawText);
                String icon = node.getValue().getIcon();
                String icon2 = node.getValue().getIcon();
                Density $this$buildRichNode_u24lambda_u242 = this.density;
                float f = $this$buildRichNode_u24lambda_u242.toDp-GaN1DYA(fontSize);
                Density $this$buildRichNode_u24lambda_u243 = this.density;
                inlineTextContent.put(icon, new InlineImageContent(icon2, false, DpKt.DpSize-YgX7TsA(f, $this$buildRichNode_u24lambda_u243.toDp-GaN1DYA(fontSize)), this.density, color, ColorKt.Color(4293388263L), false, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), 64, (DefaultConstructorMarker) null).getInlineContent());
                list2.add(new TextNodeBuildResult((KTextNode.IText) node, builder.toAnnotatedString(), inlineTextContent, 0L, 8, (DefaultConstructorMarker) null));
            }
            Iterable $this$forEach$iv2 = node.getValue().getShowRich();
            for (Object element$iv : $this$forEach$iv2) {
                KLinkNodeRich typed = (KLinkNodeRich) element$iv;
                KLinkNodeRich.KEmote content = typed.getContent();
                if (content instanceof KLinkNodeRich.KEmote) {
                    KTextNode.IText iText = (KTextNode.IText) node;
                    KEmoteNode value = content.getValue();
                    KWordNode rawText2 = content.getValue().getRawText();
                    word = word2;
                    list2.add(buildEmote(iText, value, rawText2 != null ? rawText2.getWords() : null, this.styleFactory));
                    $this$forEach$iv = $this$forEach$iv2;
                } else {
                    word = word2;
                    if (content instanceof KLinkNodeRich.KText) {
                        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                        $this$forEach$iv = $this$forEach$iv2;
                        builder2.append(AnnotatedStringKt.AnnotatedString$default(((KLinkNodeRich.KText) content).getValue().getWords(), this.styleFactory.buildSpanStyleFor(((KLinkNodeRich.KText) content).getValue()), (ParagraphStyle) null, 4, (Object) null));
                        list2.add(new TextNodeBuildResult((KTextNode.IText) node, builder2.toAnnotatedString(), MapsKt.emptyMap(), 0L, 8, (DefaultConstructorMarker) null));
                    } else {
                        $this$forEach$iv = $this$forEach$iv2;
                        if (content != null) {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                word2 = word;
                $this$forEach$iv2 = $this$forEach$iv;
            }
            if (!StringsKt.isBlank(node.getValue().getIconSuffix())) {
                Map inlineTextContent2 = new LinkedHashMap();
                AnnotatedString.Builder builder3 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                InlineTextContentKt.appendInlineContent(builder3, node.getValue().getIconSuffix(), rawText);
                String iconSuffix = node.getValue().getIconSuffix();
                String iconSuffix2 = node.getValue().getIconSuffix();
                Density $this$buildRichNode_u24lambda_u245 = this.density;
                float f2 = $this$buildRichNode_u24lambda_u245.toDp-GaN1DYA(fontSize);
                Density $this$buildRichNode_u24lambda_u246 = this.density;
                inlineTextContent2.put(iconSuffix, new InlineImageContent(iconSuffix2, false, DpKt.DpSize-YgX7TsA(f2, $this$buildRichNode_u24lambda_u246.toDp-GaN1DYA(fontSize)), this.density, color, ColorKt.Color(4293388263L), false, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), 64, (DefaultConstructorMarker) null).getInlineContent());
                list2.add(new TextNodeBuildResult((KTextNode.IText) node, builder3.toAnnotatedString(), inlineTextContent2, 0L, 8, (DefaultConstructorMarker) null));
            }
            Iterable iterable = !list2.isEmpty() ? list2 : null;
            if (iterable != null) {
                Iterable $this$reduce$iv = iterable;
                Iterator iterator$iv = $this$reduce$iv.iterator();
                if (!iterator$iv.hasNext()) {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
                Object accumulator$iv = iterator$iv.next();
                while (iterator$iv.hasNext()) {
                    TextNodeBuildResult r = (TextNodeBuildResult) iterator$iv.next();
                    TextNodeBuildResult acc = (TextNodeBuildResult) accumulator$iv;
                    KTextNode.IText iText2 = (KTextNode.IText) node;
                    AnnotatedString plus = acc.getString().plus(r.getString());
                    Map plus2 = MapsKt.plus(acc.getInlineTextContent(), r.getInlineTextContent());
                    if (TextUnit.equals-impl0(acc.getLineHeight-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
                        j3 = r.getLineHeight-XSAIIZE();
                        list = list2;
                    } else if (TextUnit.equals-impl0(r.getLineHeight-XSAIIZE(), TextUnit.Companion.getUnspecified-XSAIIZE())) {
                        j3 = acc.getLineHeight-XSAIIZE();
                        list = list2;
                    } else {
                        long j4 = acc.getLineHeight-XSAIIZE();
                        long j5 = r.getLineHeight-XSAIIZE();
                        TextUnitKt.checkArithmetic-NB67dxo(j4, j5);
                        list = list2;
                        switch (MathKt.getSign(Float.compare(TextUnit.getValue-impl(j4), TextUnit.getValue-impl(j5)))) {
                            case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                                j3 = r.getLineHeight-XSAIIZE();
                                continue;
                            case 0:
                            default:
                                j3 = acc.getLineHeight-XSAIIZE();
                                continue;
                            case 1:
                                j3 = acc.getLineHeight-XSAIIZE();
                                continue;
                        }
                    }
                    accumulator$iv = new TextNodeBuildResult(iText2, plus, plus2, j3, (DefaultConstructorMarker) null);
                    list2 = list;
                }
                TextNodeBuildResult textNodeBuildResult = (TextNodeBuildResult) accumulator$iv;
                if (textNodeBuildResult != null) {
                    return textNodeBuildResult;
                }
            }
            return TextNodeBuildResult.Companion.getEmpty();
        }
        return TextNodeBuildResult.Companion.getEmpty();
    }

    public final TextNodeBuildResult buildEmote(KTextNode.IText node, KEmoteNode tNode, String rawText, TextSpanFactory styleFactory) {
        String img;
        AnnotatedString.Builder builder;
        Map emptyMap;
        AnnotatedString.Builder builder2;
        float f;
        InlineImageContent inlineImageContent;
        KColors color;
        Intrinsics.checkNotNullParameter(styleFactory, "styleFactory");
        if (rawText != null && tNode != null) {
            switch (WhenMappings.$EnumSwitchMapping$0[this.themeDayNight.ordinal()]) {
                case 1:
                    String emoteUrlDark = tNode.getEmoteUrlDark();
                    if (StringsKt.isBlank(emoteUrlDark)) {
                        emoteUrlDark = tNode.getEmoteUrl();
                    }
                    img = emoteUrlDark;
                    break;
                case 2:
                    img = tNode.getEmoteUrl();
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            AnnotatedString.Builder builder3 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            InlineImageContent inlineImageContent2 = null;
            if (!StringsKt.isBlank(img)) {
                if (tNode.isInlineImg()) {
                    KImgInlineCfg inlineImgCfg = tNode.getInlineImgCfg();
                    long color2 = (inlineImgCfg == null || (color = inlineImgCfg.getColor()) == null) ? Color.Companion.getUnspecified-0d7_KjU() : StyleUtilsKt.getColor(color, this.themeDayNight);
                    KImgInlineCfg inlineImgCfg2 = tNode.getInlineImgCfg();
                    if (inlineImgCfg2 == null) {
                        KWordNode tRawText = tNode.getRawText();
                        return tRawText == null ? TextNodeBuildResult.Companion.getEmpty() : new TextNodeBuildResult(node, AnnotatedStringKt.AnnotatedString$default(tRawText.getWords(), styleFactory.buildSpanStyleFor(tRawText), (ParagraphStyle) null, 4, (Object) null), MapsKt.emptyMap(), 0L, 8, (DefaultConstructorMarker) null);
                    }
                    Density $this$buildEmote_u24lambda_u242 = this.density;
                    builder2 = builder3;
                    inlineImageContent = new InlineImageContent(img, true, DpKt.DpSize-YgX7TsA($this$buildEmote_u24lambda_u242.toDp-u2uoSUM((float) inlineImgCfg2.getWidth()), $this$buildEmote_u24lambda_u242.toDp-u2uoSUM((float) inlineImgCfg2.getHeight())), this.density, color2, ColorKt.Color(4293388263L), false, 0, 192, (DefaultConstructorMarker) null);
                } else {
                    builder2 = builder3;
                    KEmoteSize size = tNode.getEmoteWidth();
                    Density $this$buildEmote_u24lambda_u243 = this.density;
                    if (size == null) {
                        f = $this$buildEmote_u24lambda_u243.toDp-GaN1DYA(TextUnitKt.getSp(20));
                    } else if (size.getWidth() > 0.0d) {
                        f = $this$buildEmote_u24lambda_u243.toDp-GaN1DYA(TextUnitKt.getSp((float) size.getWidth()));
                    } else {
                        f = $this$buildEmote_u24lambda_u243.toDp-GaN1DYA(TextUnitKt.getSp(20));
                    }
                    float sizeDp = f;
                    inlineImageContent = new InlineImageContent(img, tNode.getAllowAnimated(), DpKt.DpSize-YgX7TsA(sizeDp, sizeDp), this.density, Color.Companion.getUnspecified-0d7_KjU(), ColorKt.Color(4293388263L), false, 0, 192, (DefaultConstructorMarker) null);
                }
                inlineImageContent2 = inlineImageContent;
                builder = builder2;
                InlineTextContentKt.appendInlineContent(builder, rawText, rawText);
            } else {
                builder = builder3;
                builder.append(rawText);
            }
            AnnotatedString annotatedString = builder.toAnnotatedString();
            if (inlineImageContent2 != null) {
                InlineImageContent it = inlineImageContent2;
                Map mapOf = MapsKt.mapOf(TuplesKt.to(rawText, it.getInlineContent()));
                if (mapOf != null) {
                    emptyMap = mapOf;
                    return new TextNodeBuildResult(node, annotatedString, emptyMap, 0L, 8, (DefaultConstructorMarker) null);
                }
            }
            emptyMap = MapsKt.emptyMap();
            return new TextNodeBuildResult(node, annotatedString, emptyMap, 0L, 8, (DefaultConstructorMarker) null);
        }
        return TextNodeBuildResult.Companion.getEmpty();
    }
}