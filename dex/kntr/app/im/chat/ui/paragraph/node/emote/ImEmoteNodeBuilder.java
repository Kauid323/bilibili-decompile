package kntr.app.im.chat.ui.paragraph.node.emote;

import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KColors;
import com.bapis.bilibili.app.dynamic.v2.KEmoteNode;
import com.bapis.bilibili.app.dynamic.v2.KEmoteSize;
import com.bapis.bilibili.app.dynamic.v2.KImgInlineCfg;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.dynamic.v2.KWordNode;
import com.bilibili.common.paragraph.impl.StyleUtilsKt;
import com.bilibili.common.paragraph.impl.text.TextNodeBuildResult;
import com.bilibili.common.paragraph.impl.text.TextNodeBuilder;
import com.bilibili.common.paragraph.impl.text.TextSpanFactory;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.Map;
import javax.inject.Inject;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;

/* compiled from: ImEmoteNodeBuilder.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lkntr/app/im/chat/ui/paragraph/node/emote/ImEmoteNodeBuilder;", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuilder;", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KEmote;", "density", "Landroidx/compose/ui/unit/Density;", "themeDayNight", "Lcom/bilibili/compose/theme/ThemeDayNight;", "styleFactory", "Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;", "<init>", "(Landroidx/compose/ui/unit/Density;Lcom/bilibili/compose/theme/ThemeDayNight;Lcom/bilibili/common/paragraph/impl/text/TextSpanFactory;)V", "acceptType", "Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KTextNodeType;", "getAcceptType", "()Lcom/bapis/bilibili/app/dynamic/v2/KTextNode$KTextNodeType;", "acceptClass", "Lkotlin/reflect/KClass;", "getAcceptClass", "()Lkotlin/reflect/KClass;", "buildNode", "Lcom/bilibili/common/paragraph/impl/text/TextNodeBuildResult;", "node", "rawText", RoomRecommendViewModel.EMPTY_CURSOR, "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImEmoteNodeBuilder implements TextNodeBuilder<KTextNode.KEmote> {
    public static final int $stable = 0;
    private final Density density;
    private final TextSpanFactory styleFactory;
    private final ThemeDayNight themeDayNight;

    /* compiled from: ImEmoteNodeBuilder.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ThemeDayNight.values().length];
            try {
                iArr[ThemeDayNight.Day.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ThemeDayNight.Night.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Inject
    public ImEmoteNodeBuilder(Density density, ThemeDayNight themeDayNight, TextSpanFactory styleFactory) {
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(themeDayNight, "themeDayNight");
        Intrinsics.checkNotNullParameter(styleFactory, "styleFactory");
        this.density = density;
        this.themeDayNight = themeDayNight;
        this.styleFactory = styleFactory;
    }

    public KTextNode.KTextNodeType getAcceptType() {
        return KTextNode.KTextNodeType.EMOTE.INSTANCE;
    }

    public KClass<KTextNode.KEmote> getAcceptClass() {
        return Reflection.getOrCreateKotlinClass(KTextNode.KEmote.class);
    }

    public TextNodeBuildResult buildNode(KTextNode.KEmote node, String rawText) {
        KEmoteNode tNode;
        String img;
        AnnotatedString.Builder builder;
        Map emptyMap;
        AnnotatedString.Builder builder2;
        float f;
        InlineImageContent inlineImageContent;
        long color;
        KColors color2;
        if (rawText == null) {
            return TextNodeBuildResult.Companion.getEmpty();
        }
        if (node == null || (tNode = node.getValue()) == null) {
            return TextNodeBuildResult.Companion.getEmpty();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.themeDayNight.ordinal()]) {
            case 1:
                img = tNode.getEmoteUrl();
                break;
            case 2:
                String emoteUrlDark = tNode.getEmoteUrlDark();
                if (StringsKt.isBlank(emoteUrlDark)) {
                    emoteUrlDark = tNode.getEmoteUrl();
                }
                img = emoteUrlDark;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        AnnotatedString.Builder builder3 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        InlineImageContent inlineImageContent2 = null;
        if (!StringsKt.isBlank(img)) {
            if (tNode.isInlineImg()) {
                KImgInlineCfg inlineImgCfg = tNode.getInlineImgCfg();
                if (inlineImgCfg != null && (color2 = inlineImgCfg.getColor()) != null) {
                    color = StyleUtilsKt.getColor(color2, this.themeDayNight);
                } else {
                    color = Color.Companion.getUnspecified-0d7_KjU();
                }
                KImgInlineCfg inlineImgCfg2 = tNode.getInlineImgCfg();
                if (inlineImgCfg2 == null) {
                    ImEmoteNodeBuilder $this$buildNode_u24lambda_u241 = this;
                    KWordNode rawWord = tNode.getRawText();
                    if (rawWord == null) {
                        return TextNodeBuildResult.Companion.getEmpty();
                    }
                    AnnotatedString styled = AnnotatedStringKt.AnnotatedString$default(rawWord.getWords(), SpanStyle.copy-GSF8kmg$default($this$buildNode_u24lambda_u241.styleFactory.buildSpanStyleFor(rawWord), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65535, (Object) null), (ParagraphStyle) null, 4, (Object) null);
                    return new TextNodeBuildResult((KTextNode.IText) node, styled, MapsKt.emptyMap(), 0L, 8, (DefaultConstructorMarker) null);
                }
                builder2 = builder3;
                inlineImageContent = new InlineImageContent(img, true, DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float) inlineImgCfg2.getWidth()), Dp.constructor-impl((float) inlineImgCfg2.getHeight())), this.density, color, ColorKt.Color(4293388263L), false, 0, 192, null);
            } else {
                builder2 = builder3;
                KEmoteSize size = tNode.getEmoteWidth();
                Density $this$buildNode_u24lambda_u242 = this.density;
                if (size == null) {
                    f = $this$buildNode_u24lambda_u242.toDp-GaN1DYA(TextUnitKt.getSp(20));
                } else if (size.getWidth() > 0.0d) {
                    f = $this$buildNode_u24lambda_u242.toDp-GaN1DYA(TextUnitKt.getSp((float) size.getWidth()));
                } else if (size.getEmojiSize() == 2) {
                    f = $this$buildNode_u24lambda_u242.toDp-GaN1DYA(TextUnitKt.getSp(40));
                } else {
                    f = $this$buildNode_u24lambda_u242.toDp-GaN1DYA(TextUnitKt.getSp(20));
                }
                float sizeDp = f;
                inlineImageContent = new InlineImageContent(img, tNode.getAllowAnimated(), DpKt.DpSize-YgX7TsA(sizeDp, sizeDp), this.density, Color.Companion.getUnspecified-0d7_KjU(), ColorKt.Color(4293388263L), false, PlaceholderVerticalAlign.Companion.getBottom-J6kI3mc(), 64, null);
            }
            inlineImageContent2 = inlineImageContent;
            builder = builder2;
            InlineTextContentKt.appendInlineContent$default(builder, rawText, (String) null, 2, (Object) null);
        } else {
            builder = builder3;
            builder.append(rawText);
        }
        KTextNode.IText iText = (KTextNode.IText) node;
        AnnotatedString annotatedString = builder.toAnnotatedString();
        if (inlineImageContent2 != null) {
            InlineImageContent it = inlineImageContent2;
            Map mapOf = MapsKt.mapOf(TuplesKt.to(rawText, it.getInlineContent()));
            if (mapOf != null) {
                emptyMap = mapOf;
                return new TextNodeBuildResult(iText, annotatedString, emptyMap, 0L, 8, (DefaultConstructorMarker) null);
            }
        }
        emptyMap = MapsKt.emptyMap();
        return new TextNodeBuildResult(iText, annotatedString, emptyMap, 0L, 8, (DefaultConstructorMarker) null);
    }
}