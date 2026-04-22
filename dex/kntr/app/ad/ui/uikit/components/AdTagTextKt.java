package kntr.app.ad.ui.uikit.components;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Map;
import kntr.app.ad.ui.uikit.components.TagContent;
import kntr.app.ad.ui.uikit.modifiers.BackgroundModifierKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdTagText.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001a/\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000e\u001a/\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"AdTagText", RoomRecommendViewModel.EMPTY_CURSOR, "tagContent", "Lkntr/app/ad/ui/uikit/components/TagContent;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "style", "Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;", "(Lkntr/app/ad/ui/uikit/components/TagContent;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;Landroidx/compose/runtime/Composer;II)V", "AdTagTextWithIcon", "iconContent", "Lkntr/app/ad/ui/uikit/components/TagContent$Icon;", "(Lkntr/app/ad/ui/uikit/components/TagContent$Icon;Ljava/lang/String;Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AdTagTextWithText", "textContent", "Lkntr/app/ad/ui/uikit/components/TagContent$Text;", "(Lkntr/app/ad/ui/uikit/components/TagContent$Text;Ljava/lang/String;Lkntr/app/ad/ui/uikit/components/AdTagTextStyle;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "uikit_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdTagTextKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagText$lambda$0(TagContent tagContent, String str, Modifier modifier, AdTagTextStyle adTagTextStyle, int i, int i2, Composer composer, int i3) {
        AdTagText(tagContent, str, modifier, adTagTextStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagText$lambda$1(TagContent tagContent, String str, Modifier modifier, AdTagTextStyle adTagTextStyle, int i, int i2, Composer composer, int i3) {
        AdTagText(tagContent, str, modifier, adTagTextStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithIcon$lambda$2(TagContent.Icon icon, String str, AdTagTextStyle adTagTextStyle, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdTagTextWithIcon(icon, str, adTagTextStyle, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithText$lambda$1(TagContent.Text text, String str, AdTagTextStyle adTagTextStyle, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AdTagTextWithText(text, str, adTagTextStyle, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AdTagText(final TagContent tagContent, final String title, Modifier modifier, AdTagTextStyle style, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        AdTagTextStyle adTagTextStyle;
        Composer $composer2;
        Modifier modifier3;
        AdTagTextStyle style2;
        Modifier modifier4;
        int $dirty;
        int i2;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-156447333);
        ComposerKt.sourceInformation($composer3, "C(AdTagText)N(tagContent,title,modifier,style):AdTagText.kt#oqm2gb");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(tagContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(title) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                adTagTextStyle = style;
                if ($composer3.changed(adTagTextStyle)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                adTagTextStyle = style;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            adTagTextStyle = style;
        }
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer3.startDefaults();
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                modifier3 = modifier2;
                style2 = adTagTextStyle;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 8) == 0) {
                    $dirty = $dirty2;
                    modifier3 = modifier4;
                    style2 = adTagTextStyle;
                } else {
                    modifier3 = modifier4;
                    style2 = new AdTagTextStyle(0L, 0L, null, 0L, 15, null);
                    $dirty = $dirty2 & (-7169);
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-156447333, $dirty, -1, "kntr.app.ad.ui.uikit.components.AdTagText (AdTagText.kt:37)");
            }
            if (tagContent == null) {
                $composer3.startReplaceGroup(-682794745);
                ComposerKt.sourceInformation($composer3, "40@1512L328");
                TextKt.Text-Nvy7gAk(title, modifier3, style2.m495getTitleTextColor0d7_KjU(), (TextAutoSize) null, style2.m493getTitleFontSizeXSAIIZE(), (FontStyle) null, style2.getTitleFontWeight(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, style2.m494getTitleLineHeightXSAIIZE(), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty >> 3) & 14) | (($dirty >> 3) & 112), 24960, 239528);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier5 = modifier3;
                    final AdTagTextStyle adTagTextStyle2 = style2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AdTagText$lambda$0;
                            AdTagText$lambda$0 = AdTagTextKt.AdTagText$lambda$0(TagContent.this, title, modifier5, adTagTextStyle2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return AdTagText$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty3 = $dirty;
            $composer2 = $composer3;
            $composer2.startReplaceGroup(-684272825);
            $composer2.endReplaceGroup();
            if (tagContent instanceof TagContent.Icon) {
                $composer2.startReplaceGroup(-682350918);
                ComposerKt.sourceInformation($composer2, "55@1931L173");
                AdTagTextWithIcon((TagContent.Icon) tagContent, title, style2, modifier3, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 3) & 7168), 0);
                $composer2.endReplaceGroup();
            } else if (!(tagContent instanceof TagContent.Text)) {
                $composer2.startReplaceGroup(-22013059);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer2.startReplaceGroup(-682123750);
                ComposerKt.sourceInformation($composer2, "64@2160L173");
                AdTagTextWithText((TagContent.Text) tagContent, title, style2, modifier3, $composer2, ($dirty3 & 14) | ($dirty3 & 112) | (($dirty3 >> 3) & 896) | (($dirty3 << 3) & 7168), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            style2 = adTagTextStyle;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier3;
            final AdTagTextStyle adTagTextStyle3 = style2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdTagText$lambda$1;
                    AdTagText$lambda$1 = AdTagTextKt.AdTagText$lambda$1(TagContent.this, title, modifier6, adTagTextStyle3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdTagText$lambda$1;
                }
            });
        }
    }

    private static final void AdTagTextWithIcon(final TagContent.Icon iconContent, final String title, final AdTagTextStyle style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1772250146);
        ComposerKt.sourceInformation($composer2, "C(AdTagTextWithIcon)N(iconContent,title,style,modifier)114@3791L103,127@4085L671:AdTagText.kt#oqm2gb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(iconContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772250146, $dirty, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithIcon (AdTagText.kt:83)");
            }
            float strokeWidth = BackgroundModifierKt.getStrokeWidth(iconContent.getBackground());
            float f = 2;
            long iconHeight = TextUnitKt.getSp(iconContent.m502getHeightD9Ej5fM() + iconContent.getSpacing().calculateTopPadding-D9Ej5fM() + iconContent.getSpacing().calculateBottomPadding-D9Ej5fM() + (strokeWidth * f));
            long iconWidth = TextUnitKt.getSp(iconContent.m503getWidthD9Ej5fM() + iconContent.getSpacing().calculateLeftPadding-u2uoSUM(LayoutDirection.Ltr) + iconContent.getSpacing().calculateRightPadding-u2uoSUM(LayoutDirection.Ltr) + (f * strokeWidth));
            long m494getTitleLineHeightXSAIIZE = style.m494getTitleLineHeightXSAIIZE();
            TextUnitKt.checkArithmetic-NB67dxo(m494getTitleLineHeightXSAIIZE, iconHeight);
            Map inlineContent = MapsKt.mapOf(TuplesKt.to("icon", new InlineTextContent(new Placeholder(iconWidth, Float.compare(TextUnit.getValue-impl(m494getTitleLineHeightXSAIIZE), TextUnit.getValue-impl(iconHeight)) > 0 ? style.m494getTitleLineHeightXSAIIZE() : iconHeight, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-451948348, true, new Function3() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AdTagTextWithIcon$lambda$0;
                    AdTagTextWithIcon$lambda$0 = AdTagTextKt.AdTagTextWithIcon$lambda$0(TagContent.Icon.this, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AdTagTextWithIcon$lambda$0;
                }
            }, $composer2, 54))));
            AnnotatedString.Builder $this$AdTagTextWithIcon_u24lambda_u241 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            InlineTextContentKt.appendInlineContent($this$AdTagTextWithIcon_u24lambda_u241, "icon", "[icon]");
            $this$AdTagTextWithIcon_u24lambda_u241.append(title);
            AnnotatedString annotatedText = $this$AdTagTextWithIcon_u24lambda_u241.toAnnotatedString();
            TextStyle textStyle = new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), (DefaultConstructorMarker) null), 0, 0, (TextMotion) null, 15728639, (DefaultConstructorMarker) null);
            long m495getTitleTextColor0d7_KjU = style.m495getTitleTextColor0d7_KjU();
            long m493getTitleFontSizeXSAIIZE = style.m493getTitleFontSizeXSAIIZE();
            FontWeight titleFontWeight = style.getTitleFontWeight();
            long m494getTitleLineHeightXSAIIZE2 = style.m494getTitleLineHeightXSAIIZE();
            TextUnitKt.checkArithmetic-NB67dxo(m494getTitleLineHeightXSAIIZE2, iconHeight);
            TextKt.Text-Z58ophY(annotatedText, modifier4, m495getTitleTextColor0d7_KjU, (TextAutoSize) null, m493getTitleFontSizeXSAIIZE, (FontStyle) null, titleFontWeight, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, Float.compare(TextUnit.getValue-impl(m494getTitleLineHeightXSAIIZE2), TextUnit.getValue-impl(iconHeight)) > 0 ? style.m494getTitleLineHeightXSAIIZE() : iconHeight, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, inlineContent, (Function1) null, textStyle, $composer2, ($dirty >> 6) & 112, 24960, 173992);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdTagTextWithIcon$lambda$2;
                    AdTagTextWithIcon$lambda$2 = AdTagTextKt.AdTagTextWithIcon$lambda$2(TagContent.Icon.this, title, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdTagTextWithIcon$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithIcon$lambda$0(TagContent.Icon $iconContent, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)115@3813L63:AdTagText.kt#oqm2gb");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-451948348, $changed, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithIcon.<anonymous> (AdTagText.kt:115)");
            }
            AdTagKt.AdTag($iconContent, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void AdTagTextWithText(final TagContent.Text textContent, final String title, final AdTagTextStyle style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(-1871702878);
        ComposerKt.sourceInformation($composer2, "C(AdTagTextWithText)N(textContent,title,style,modifier)158@5004L7,160@5055L3260,160@5017L3298:AdTagText.kt#oqm2gb");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(textContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(title) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(style) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1871702878, $dirty2, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithText (AdTagText.kt:157)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 884841694, "CC(remember):AdTagText.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changed(density) | (($dirty2 & 896) == 256) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult AdTagTextWithText$lambda$0$0;
                        AdTagTextWithText$lambda$0$0 = AdTagTextKt.AdTagTextWithText$lambda$0$0(TagContent.Text.this, density, style, title, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return AdTagTextWithText$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) it$iv, $composer2, ($dirty2 >> 9) & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdTagTextWithText$lambda$1;
                    AdTagTextWithText$lambda$1 = AdTagTextKt.AdTagTextWithText$lambda$1(TagContent.Text.this, title, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdTagTextWithText$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult AdTagTextWithText$lambda$0$0(final TagContent.Text $textContent, Density $density, final AdTagTextStyle $style, String $title, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        int tagMaxWidthPx = !Dp.equals-impl0($textContent.m512getMaxWidthD9Ej5fM(), Dp.Companion.getUnspecified-D9Ej5fM()) ? $density.roundToPx-0680j_4($textContent.m512getMaxWidthD9Ej5fM()) : Integer.MAX_VALUE;
        long tagConstraints = ConstraintsKt.Constraints$default(0, Math.min(Constraints.getMaxWidth-impl(constraints.unbox-impl()), tagMaxWidthPx), 0, 0, 13, (Object) null);
        Placeable tagPlaceable = ((Measurable) $this$SubcomposeLayout.subcompose("tag", ComposableLambdaKt.composableLambdaInstance(-208438621, true, new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit AdTagTextWithText$lambda$0$0$1;
                AdTagTextWithText$lambda$0$0$1 = AdTagTextKt.AdTagTextWithText$lambda$0$0$1(TagContent.Text.this, (Composer) obj, ((Integer) obj2).intValue());
                return AdTagTextWithText$lambda$0$0$1;
            }
        })).get(0)).measure-BRTryo0(tagConstraints);
        float strokeWidth = BackgroundModifierKt.getStrokeWidth($textContent.getBackground());
        float f = 2;
        final long tagHeight = TextUnitKt.getSp(TextUnit.getValue-impl($textContent.m511getLineHeightXSAIIZE()) + $textContent.getPadding().calculateTopPadding-D9Ej5fM() + $textContent.getPadding().calculateBottomPadding-D9Ej5fM() + $textContent.getSpacing().calculateTopPadding-D9Ej5fM() + $textContent.getSpacing().calculateBottomPadding-D9Ej5fM() + (strokeWidth * f));
        long tagWidthSp = TextUnitKt.getSp($density.toDp-u2uoSUM(tagPlaceable.getWidth()) + (f * strokeWidth));
        long m494getTitleLineHeightXSAIIZE = $style.m494getTitleLineHeightXSAIIZE();
        TextUnitKt.checkArithmetic-NB67dxo(m494getTitleLineHeightXSAIIZE, tagHeight);
        final Map inlineContent = MapsKt.mapOf(TuplesKt.to("tag", new InlineTextContent(new Placeholder(tagWidthSp, Float.compare(TextUnit.getValue-impl(m494getTitleLineHeightXSAIIZE), TextUnit.getValue-impl(tagHeight)) > 0 ? $style.m494getTitleLineHeightXSAIIZE() : tagHeight, PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.composableLambdaInstance(804278885, true, new Function3() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AdTagTextWithText$lambda$0$0$3;
                AdTagTextWithText$lambda$0$0$3 = AdTagTextKt.AdTagTextWithText$lambda$0$0$3(TagContent.Text.this, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AdTagTextWithText$lambda$0$0$3;
            }
        }))));
        AnnotatedString.Builder $this$AdTagTextWithText_u24lambda_u240_u240_u244 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        InlineTextContentKt.appendInlineContent($this$AdTagTextWithText_u24lambda_u240_u240_u244, "tag", "[tag]");
        $this$AdTagTextWithText_u24lambda_u240_u240_u244.append($title);
        final AnnotatedString annotatedText = $this$AdTagTextWithText_u24lambda_u240_u240_u244.toAnnotatedString();
        final Placeable textPlaceable = ((Measurable) $this$SubcomposeLayout.subcompose("text", ComposableLambdaKt.composableLambdaInstance(-1984213848, true, new Function2() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2) {
                Unit AdTagTextWithText$lambda$0$0$5;
                AdTagTextWithText$lambda$0$0$5 = AdTagTextKt.AdTagTextWithText$lambda$0$0$5(AdTagTextStyle.this, tagHeight, annotatedText, inlineContent, (Composer) obj, ((Integer) obj2).intValue());
                return AdTagTextWithText$lambda$0$0$5;
            }
        })).get(0)).measure-BRTryo0(constraints.unbox-impl());
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, textPlaceable.getWidth(), textPlaceable.getHeight(), (Map) null, new Function1() { // from class: kntr.app.ad.ui.uikit.components.AdTagTextKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj) {
                Unit AdTagTextWithText$lambda$0$0$6;
                AdTagTextWithText$lambda$0$0$6 = AdTagTextKt.AdTagTextWithText$lambda$0$0$6(textPlaceable, (Placeable.PlacementScope) obj);
                return AdTagTextWithText$lambda$0$0$6;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithText$lambda$0$0$1(TagContent.Text $textContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C176@5550L28:AdTagText.kt#oqm2gb");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208438621, $changed, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithText.<anonymous>.<anonymous>.<anonymous> (AdTagText.kt:176)");
            }
            AdTagKt.AdTag($textContent, null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithText$lambda$0$0$3(TagContent.Text $textContent, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)211@6908L63:AdTagText.kt#oqm2gb");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804278885, $changed, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithText.<anonymous>.<anonymous>.<anonymous> (AdTagText.kt:211)");
            }
            AdTagKt.AdTag($textContent, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithText$lambda$0$0$5(AdTagTextStyle $style, long $tagHeight, AnnotatedString $annotatedText, Map $inlineContent, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C225@7296L844:AdTagText.kt#oqm2gb");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1984213848, $changed, -1, "kntr.app.ad.ui.uikit.components.AdTagTextWithText.<anonymous>.<anonymous>.<anonymous> (AdTagText.kt:225)");
            }
            TextStyle textStyle = new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), (DefaultConstructorMarker) null), 0, 0, (TextMotion) null, 15728639, (DefaultConstructorMarker) null);
            long m495getTitleTextColor0d7_KjU = $style.m495getTitleTextColor0d7_KjU();
            long m493getTitleFontSizeXSAIIZE = $style.m493getTitleFontSizeXSAIIZE();
            FontWeight titleFontWeight = $style.getTitleFontWeight();
            long m494getTitleLineHeightXSAIIZE = $style.m494getTitleLineHeightXSAIIZE();
            TextUnitKt.checkArithmetic-NB67dxo(m494getTitleLineHeightXSAIIZE, $tagHeight);
            TextKt.Text-Z58ophY($annotatedText, (Modifier) null, m495getTitleTextColor0d7_KjU, (TextAutoSize) null, m493getTitleFontSizeXSAIIZE, (FontStyle) null, titleFontWeight, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, Float.compare(TextUnit.getValue-impl(m494getTitleLineHeightXSAIIZE), TextUnit.getValue-impl($tagHeight)) > 0 ? $style.m494getTitleLineHeightXSAIIZE() : $tagHeight, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, $inlineContent, (Function1) null, textStyle, $composer, 0, 24960, 173994);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdTagTextWithText$lambda$0$0$6(Placeable $textPlaceable, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        Placeable.PlacementScope.placeRelative$default($this$layout, $textPlaceable, 0, 0, 0.0f, 4, (Object) null);
        return Unit.INSTANCE;
    }
}