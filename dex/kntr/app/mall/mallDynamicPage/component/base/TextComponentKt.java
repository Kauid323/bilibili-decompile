package kntr.app.mall.mallDynamicPage.component.base;

import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.parser.MappingHelperKt;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: TextComponent.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"TextComponent", RoomRecommendViewModel.EMPTY_CURSOR, "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/mallDynamicPage/bean/Props;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextComponent$lambda$0(Props props, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TextComponent(props, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TextComponent(final Props props, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        String str;
        Boolean softWrap;
        Integer letterSpacing;
        Integer minLines;
        Integer maxLines;
        Integer lineHeight;
        Integer fontWeight;
        Integer fontSize;
        Composer $composer2 = $composer.startRestartGroup(54854102);
        ComposerKt.sourceInformation($composer2, "C(TextComponent)N(props,style,modifier)28@1037L21,30@1108L26,24@940L899:TextComponent.kt#ay1t0q");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(props) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(style) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        boolean z = true;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(54854102, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.TextComponent (TextComponent.kt:23)");
            }
            if (props == null || (str = props.getText()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            String str2 = str;
            Modifier then = ModifierCreatorKt.createModifier(Modifier.Companion, style, $composer2, ($dirty2 & 112) | 6).then(modifier4);
            long mappingColor = MappingHelperKt.mappingColor(props != null ? props.getColor() : null, $composer2, 0);
            long j2 = (props == null || (fontSize = props.getFontSize()) == null) ? TextUnit.Companion.getUnspecified-XSAIIZE() : TextUnitKt.getSp(fontSize.intValue());
            int mappingFontStyle = MappingHelperKt.mappingFontStyle(props != null ? props.getFontStyle() : null);
            FontWeight fontWeight2 = new FontWeight((props == null || (fontWeight = props.getFontWeight()) == null) ? 500 : fontWeight.intValue());
            FontFamily mappingFontFamily = MappingHelperKt.mappingFontFamily(props != null ? props.getFontFamily() : null);
            long j3 = (props == null || (lineHeight = props.getLineHeight()) == null) ? TextUnit.Companion.getUnspecified-XSAIIZE() : TextUnitKt.getSp(lineHeight.intValue());
            int intValue = (props == null || (maxLines = props.getMaxLines()) == null) ? Integer.MAX_VALUE : maxLines.intValue();
            int intValue2 = (props == null || (minLines = props.getMinLines()) == null) ? 1 : minLines.intValue();
            long j4 = (props == null || (letterSpacing = props.getLetterSpacing()) == null) ? TextUnit.Companion.getUnspecified-XSAIIZE() : TextUnitKt.getSp(letterSpacing.intValue());
            TextDecoration mappingTextDecoration = MappingHelperKt.mappingTextDecoration(props != null ? props.getTextDecoration() : null);
            int mappingTextAlign = MappingHelperKt.mappingTextAlign(props != null ? props.getTextAlign() : null);
            int mappingOverflow = MappingHelperKt.mappingOverflow(props != null ? props.getOverflow() : null);
            if (props != null && (softWrap = props.getSoftWrap()) != null) {
                z = softWrap.booleanValue();
            }
            TextKt.Text-Nvy7gAk(str2, then, mappingColor, (TextAutoSize) null, j2, FontStyle.box-impl(mappingFontStyle), fontWeight2, mappingFontFamily, j4, mappingTextDecoration, TextAlign.box-impl(mappingTextAlign), j3, mappingOverflow, z, intValue, intValue2, (Function1) null, (TextStyle) null, $composer2, 0, 0, 196616);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.TextComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextComponent$lambda$0;
                    TextComponent$lambda$0 = TextComponentKt.TextComponent$lambda$0(Props.this, style, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextComponent$lambda$0;
                }
            });
        }
    }
}