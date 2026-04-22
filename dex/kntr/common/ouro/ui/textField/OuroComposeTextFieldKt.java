package kntr.common.ouro.ui.textField;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputInterceptor;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroDeleteByLengthAction;
import kntr.common.ouro.core.action.OuroInsertAction;
import kntr.common.ouro.core.action.OuroUpdateSelectionAction;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.ui.inlineContent.DrawableLayout;
import kntr.common.ouro.ui.utils.BackgroundStyle;
import kntr.common.ouro.ui.utils.CustomAnnotation;
import kntr.common.ouro.ui.utils.DrawableStyle;
import kntr.common.ouro.ui.utils.ListOrderStyle;
import kntr.common.ouro.ui.utils.OuroAnnotatedString;
import kntr.common.ouro.ui.utils.OuroCacheMap;
import kntr.common.ouro.ui.utils.TextRangeUtilsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.common.ouroboros.editor.ui.generated.resources.Font0_commonMainKt;
import srcs.common.ouroboros.editor.ui.generated.resources.Res;

/* compiled from: OuroComposeTextField.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u001aZ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\bH\u0002\u001a9\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a?\u0010\u0015\u001a\u00020\u000b*\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00012\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\u001a\u001a\u00020\u001bX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\u0016\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u008e\u0002²\u0006\f\u0010(\u001a\u0004\u0018\u00010%X\u008a\u008e\u0002²\u0006\u0010\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001X\u008a\u008e\u0002²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u0001X\u008a\u008e\u0002²\u0006\u0010\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0001X\u008a\u008e\u0002²\u0006\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0001X\u008a\u008e\u0002"}, d2 = {"filterVisibleItems", "", "T", "items", "scrollOffset", "", "viewportHeight", "getItemTop", "Lkotlin/Function1;", "getItemBottom", "OuroComposeTextField", "", "store", "Lkntr/common/ouro/core/OuroStore;", "disableIme", "", "modifier", "Landroidx/compose/ui/Modifier;", "onUserTap", "Lkotlin/Function0;", "(Lkntr/common/ouro/core/OuroStore;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DrawableLayer", "Landroidx/compose/foundation/layout/BoxScope;", "drawableLayoutList", "Lkntr/common/ouro/ui/inlineContent/DrawableLayout;", "ouroStore", "ouroState", "Lkntr/common/ouro/core/OuroState;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "mainAxisLength", "", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/util/List;Lkntr/common/ouro/core/OuroStore;Lkntr/common/ouro/core/OuroState;Landroidx/compose/foundation/ScrollState;ILandroidx/compose/runtime/Composer;I)V", "ui_debug", "listOrderLayoutCache", "Lkntr/common/ouro/ui/utils/OuroCacheMap;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "ouroAnnotatedString", "Lkntr/common/ouro/ui/utils/OuroAnnotatedString;", "textLayout", "blockQuoteLayoutList", "Lkntr/common/ouro/ui/textField/BlockQuoteLayout;", "listItemLayoutList", "Lkntr/common/ouro/ui/textField/ListItemLayout;", "backgroundLayoutList", "Lkntr/common/ouro/ui/textField/BackgroundLayout;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroComposeTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DrawableLayer$lambda$0(BoxScope boxScope, List list, OuroStore ouroStore, OuroState ouroState, ScrollState scrollState, int i, int i2, Composer composer, int i3) {
        DrawableLayer(boxScope, list, ouroStore, ouroState, scrollState, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroComposeTextField$lambda$28(OuroStore ouroStore, boolean z, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        OuroComposeTextField(ouroStore, z, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> List<T> filterVisibleItems(List<? extends T> list, float scrollOffset, float viewportHeight, Function1<? super T, Float> function1, Function1<? super T, Float> function12) {
        float visibleBottom = scrollOffset + viewportHeight;
        List<? extends T> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (T t : $this$filter$iv) {
            float itemTop = ((Number) function1.invoke(t)).floatValue();
            float itemBottom = ((Number) function12.invoke(t)).floatValue();
            if (itemBottom >= scrollOffset && itemTop <= visibleBottom) {
                destination$iv$iv.add(t);
            }
        }
        return (List) destination$iv$iv;
    }

    public static final void OuroComposeTextField(final OuroStore store, final boolean disableIme, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onUserTap;
        Modifier modifier4;
        MutableState ouroState$delegate;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer $composer3 = $composer.startRestartGroup(1510973859);
        ComposerKt.sourceInformation($composer3, "C(OuroComposeTextField)N(store,disableIme,modifier,onUserTap)122@4849L50,123@4943L26,124@5002L7,125@5053L7,127@5088L33,128@5154L69,129@5247L22,131@5293L21,132@5340L42,134@5415L50,137@5533L1031,172@6872L258,172@6851L279,180@7154L52,181@7237L62,182@7332L64,183@7427L62,184@7522L64,186@7592L21842:OuroComposeTextField.kt#equpx4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(store) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(disableIme) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onUserTap = function02;
            } else {
                onUserTap = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1510973859, $dirty2, -1, "kntr.common.ouro.ui.textField.OuroComposeTextField (OuroComposeTextField.kt:120)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 346939893, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(store.getStateFlow().getValue(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState ouroState$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = modifier4;
            FontFamily placeholderFontFamily = FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getPlaceholder(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)});
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ThemeDayNight dayNightTheme = (ThemeDayNight) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 346947524, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableIntState mainAxisLength$delegate = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 346949672, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(new OuroCacheMap(null, null, 3, null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState listOrderLayoutCache$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer3, 0, 1);
            final ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer3, 0, 1);
            final Ref.ObjectRef textFieldState = new Ref.ObjectRef();
            textFieldState.element = TextFieldStateKt.rememberTextFieldState-Le-punE("", TextRange.Companion.getZero-d9O1mEE(), $composer3, 6, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 346958005, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(new OuroAnnotatedString(null, null, null, null, null, 31, null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState ouroAnnotatedString$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final AnnotatedString annotatedString = OuroComposeTextField$lambda$9(ouroAnnotatedString$delegate).getAnnotatedString();
            EffectsKt.LaunchedEffect(Unit.INSTANCE, Integer.valueOf(OuroComposeTextField$lambda$4(mainAxisLength$delegate)), dayNightTheme, new OuroComposeTextFieldKt$OuroComposeTextField$1(store, density, dayNightTheme, placeholderFontFamily, textMeasurer, textFieldState, mainAxisLength$delegate, listOrderLayoutCache$delegate, ouroAnnotatedString$delegate, ouroState$delegate2, null), $composer3, 6);
            long biliPinkColor = ColorKt.Color(-39271);
            long biliBlueColor = ColorKt.Color(-16732436);
            TextSelectionColors customTextSelectionColors = new TextSelectionColors(biliPinkColor, Color.copy-wmQWz5c$default(biliBlueColor, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (DefaultConstructorMarker) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 347004837, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                ouroState$delegate = ouroState$delegate2;
                Object value$iv5 = (Function2) new OuroComposeTextFieldKt$OuroComposeTextField$2$1(ouroState$delegate, null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            } else {
                ouroState$delegate = ouroState$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 347013655, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            final MutableState textLayout$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 347016321, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            final MutableState drawableLayoutList$delegate = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 347019363, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv8 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv8);
                it$iv8 = value$iv8;
            }
            final MutableState blockQuoteLayoutList$delegate = (MutableState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 347022401, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv9 = $composer3.rememberedValue();
            if (it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv9 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv9);
                it$iv9 = value$iv9;
            }
            final MutableState listItemLayoutList$delegate = (MutableState) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 347025443, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv10 = $composer3.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                Object value$iv10 = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv10);
                it$iv10 = value$iv10;
            }
            final MutableState backgroundLayoutList$delegate = (MutableState) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = NestedScrollModifierKt.nestedScroll$default(modifier5, new NestedScrollConnection() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$OuroComposeTextField$3
                /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                public /* bridge */ Object m2098onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
                    return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j, j2, continuation);
                }

                /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                public /* bridge */ long m2099onPostScrollDzOQY0M(long j, long j2, int i4) {
                    return NestedScrollConnection.-CC.$default$onPostScroll-DzOQY0M(this, j, j2, i4);
                }

                /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                public /* bridge */ Object m2100onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
                    return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j, continuation);
                }

                /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                public long m2101onPreScrollOzD1aCk(long j, int i4) {
                    int bits$iv$iv$iv = (int) (j & 4294967295L);
                    if (Float.intBitsToFloat(bits$iv$iv$iv) >= 0.0f) {
                        int bits$iv$iv$iv2 = (int) (j & 4294967295L);
                        float y$iv = Math.max(Float.intBitsToFloat(bits$iv$iv$iv2) - scrollState.getValue(), 0.0f);
                        long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                        return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                    }
                    int bits$iv$iv$iv3 = (int) (j & 4294967295L);
                    float y$iv2 = Math.min((Float.intBitsToFloat(bits$iv$iv$iv3) + scrollState.getMaxValue()) - scrollState.getValue(), 0.0f);
                    long v1$iv$iv2 = Float.floatToRawIntBits(0.0f);
                    long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
                    return Offset.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2));
                }
            }, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            final BoxScope $this$OuroComposeTextField_u24lambda_u2427 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 552912762, "C209@8545L20883,207@8436L20992:OuroComposeTextField.kt#equpx4");
            final Function0 function03 = onUserTap;
            modifier3 = modifier5;
            final MutableState mutableState = ouroState$delegate;
            $composer2 = $composer3;
            CompositionLocalKt.CompositionLocalProvider(TextSelectionColorsKt.getLocalTextSelectionColors().provides(customTextSelectionColors), ComposableLambdaKt.rememberComposableLambda(819987817, true, new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit OuroComposeTextField$lambda$27$0;
                    OuroComposeTextField$lambda$27$0 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$27$0(function03, disableIme, textFieldState, $this$OuroComposeTextField_u24lambda_u2427, store, density, scrollState, mainAxisLength$delegate, mutableState, textMeasurer, annotatedString, textLayout$delegate, blockQuoteLayoutList$delegate, listItemLayoutList$delegate, listOrderLayoutCache$delegate, backgroundLayoutList$delegate, drawableLayoutList$delegate, ouroAnnotatedString$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OuroComposeTextField$lambda$27$0;
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onUserTap = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function0 function04 = onUserTap;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit OuroComposeTextField$lambda$28;
                    OuroComposeTextField$lambda$28 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$28(OuroStore.this, disableIme, modifier6, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OuroComposeTextField$lambda$28;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState OuroComposeTextField$lambda$1(MutableState<OuroState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (OuroState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int OuroComposeTextField$lambda$4(MutableIntState $mainAxisLength$delegate) {
        IntState $this$getValue$iv = (IntState) $mainAxisLength$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroCacheMap<String, TextLayoutResult> OuroComposeTextField$lambda$7(MutableState<OuroCacheMap<String, TextLayoutResult>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (OuroCacheMap) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroAnnotatedString OuroComposeTextField$lambda$9(MutableState<OuroAnnotatedString> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (OuroAnnotatedString) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLayoutResult OuroComposeTextField$lambda$13(MutableState<TextLayoutResult> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TextLayoutResult) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<DrawableLayout> OuroComposeTextField$lambda$16(MutableState<List<DrawableLayout>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<BlockQuoteLayout> OuroComposeTextField$lambda$19(MutableState<List<BlockQuoteLayout>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<ListItemLayout> OuroComposeTextField$lambda$22(MutableState<List<ListItemLayout>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<BackgroundLayout> OuroComposeTextField$lambda$25(MutableState<List<BackgroundLayout>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroComposeTextField$lambda$27$0(Function0 $onUserTap, boolean $disableIme, final Ref.ObjectRef $textFieldState, final BoxScope $this_Box, final OuroStore $store, final Density $density, final ScrollState $scrollState, final MutableIntState $mainAxisLength$delegate, final MutableState $ouroState$delegate, final TextMeasurer $textMeasurer, final AnnotatedString $annotatedString, final MutableState $textLayout$delegate, final MutableState $blockQuoteLayoutList$delegate, final MutableState $listItemLayoutList$delegate, final MutableState $listOrderLayoutCache$delegate, final MutableState $backgroundLayoutList$delegate, final MutableState $drawableLayoutList$delegate, final MutableState $ouroAnnotatedString$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C210@8583L39,211@8669L374,211@8635L408,223@9115L222,230@9353L20065,222@9057L20361:OuroComposeTextField.kt#equpx4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(819987817, $changed, -1, "kntr.common.ouro.ui.textField.OuroComposeTextField.<anonymous>.<anonymous> (OuroComposeTextField.kt:210)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 2029278224, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableInteractionSource interactionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2029281311, "CC(remember):OuroComposeTextField.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onUserTap);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new OuroComposeTextFieldKt$OuroComposeTextField$4$1$1$1(interactionSource, $onUserTap, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(interactionSource, (Function2) it$iv2, $composer, 6);
            ComposerKt.sourceInformationMarkerStart($composer, 2029295431, "CC(remember):OuroComposeTextField.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($disableIme);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (PlatformTextInputInterceptor) new OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1($disableIme);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            PlatformTextInputModifierNodeKt.InterceptPlatformTextInput((PlatformTextInputInterceptor) it$iv3, ComposableLambdaKt.rememberComposableLambda(1271057727, true, new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit OuroComposeTextField$lambda$27$0$3;
                    OuroComposeTextField$lambda$27$0$3 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$27$0$3($textFieldState, $this_Box, $store, $density, interactionSource, $scrollState, $mainAxisLength$delegate, $ouroState$delegate, $textMeasurer, $annotatedString, $textLayout$delegate, $blockQuoteLayoutList$delegate, $listItemLayoutList$delegate, $listOrderLayoutCache$delegate, $backgroundLayoutList$delegate, $drawableLayoutList$delegate, $ouroAnnotatedString$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OuroComposeTextField$lambda$27$0$3;
                }
            }, $composer, 54), $composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroComposeTextField$lambda$27$0$3(Ref.ObjectRef $textFieldState, BoxScope $this_Box, final OuroStore $store, final Density $density, MutableInteractionSource $interactionSource, ScrollState $scrollState, final MutableIntState $mainAxisLength$delegate, final MutableState $ouroState$delegate, TextMeasurer $textMeasurer, AnnotatedString $annotatedString, final MutableState $textLayout$delegate, final MutableState $blockQuoteLayoutList$delegate, final MutableState $listItemLayoutList$delegate, MutableState $listOrderLayoutCache$delegate, final MutableState $backgroundLayoutList$delegate, final MutableState $drawableLayoutList$delegate, final MutableState $ouroAnnotatedString$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C237@9637L89,240@9770L2202,279@12017L465,289@12519L4362,231@9371L20033:OuroComposeTextField.kt#equpx4");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1271057727, $changed, -1, "kntr.common.ouro.ui.textField.OuroComposeTextField.<anonymous>.<anonymous>.<anonymous> (OuroComposeTextField.kt:231)");
            }
            TextFieldState textFieldState = (TextFieldState) $textFieldState.element;
            Modifier align = $this_Box.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart());
            ComposerKt.sourceInformationMarkerStart($composer, 1715772760, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit OuroComposeTextField$lambda$27$0$3$0$0;
                        OuroComposeTextField$lambda$27$0$3$0$0 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$27$0$3$0$0($mainAxisLength$delegate, (IntSize) obj);
                        return OuroComposeTextField$lambda$27$0$3$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(align, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer, 1715779129, "CC(remember):OuroComposeTextField.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($store);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new InputTransformation() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda2
                    public /* synthetic */ void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        InputTransformation.-CC.$default$applySemantics(this, semanticsPropertyReceiver);
                    }

                    public /* synthetic */ KeyboardOptions getKeyboardOptions() {
                        return InputTransformation.-CC.$default$getKeyboardOptions(this);
                    }

                    public final void transformInput(TextFieldBuffer textFieldBuffer) {
                        OuroComposeTextFieldKt.OuroComposeTextField$lambda$27$0$3$1$0(OuroStore.this, $ouroState$delegate, textFieldBuffer);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            InputTransformation inputTransformation = (InputTransformation) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1715849296, "CC(remember):OuroComposeTextField.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new OutputTransformation() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda3
                    public final void transformOutput(TextFieldBuffer textFieldBuffer) {
                        Intrinsics.checkNotNullParameter(textFieldBuffer, "$this$BasicTextField");
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            OutputTransformation outputTransformation = (OutputTransformation) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4 ouroComposeTextFieldKt$OuroComposeTextField$4$1$3$4 = new OuroComposeTextFieldKt$OuroComposeTextField$4$1$3$4($scrollState, $textMeasurer, $annotatedString, $density, $textLayout$delegate, $blockQuoteLayoutList$delegate, $listItemLayoutList$delegate, $listOrderLayoutCache$delegate, $backgroundLayoutList$delegate, $store, $drawableLayoutList$delegate, $ouroState$delegate, $mainAxisLength$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1715869257, "CC(remember):OuroComposeTextField.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($density);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Unit OuroComposeTextField$lambda$27$0$3$3$0;
                        OuroComposeTextField$lambda$27$0$3$3$0 = OuroComposeTextFieldKt.OuroComposeTextField$lambda$27$0$3$3$0($textLayout$delegate, $ouroAnnotatedString$delegate, $drawableLayoutList$delegate, $density, $blockQuoteLayoutList$delegate, $listItemLayoutList$delegate, $backgroundLayoutList$delegate, (Density) obj, (Function0) obj2);
                        return OuroComposeTextField$lambda$27$0$3$3$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BasicTextFieldKt.BasicTextField(textFieldState, onSizeChanged, false, false, inputTransformation, (TextStyle) null, (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, (Function2) it$iv4, $interactionSource, (Brush) null, outputTransformation, ouroComposeTextFieldKt$OuroComposeTextField$4$1$3$4, $scrollState, $composer, 0, 390, 2540);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroComposeTextField$lambda$27$0$3$0$0(MutableIntState $mainAxisLength$delegate, IntSize it) {
        $mainAxisLength$delegate.setIntValue((int) (it.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OuroComposeTextField$lambda$27$0$3$1$0(OuroStore $store, MutableState $ouroState$delegate, TextFieldBuffer $this$BasicTextField) {
        TextFieldBuffer.ChangeList $this$forEachChange$iv;
        Intrinsics.checkNotNullParameter($this$BasicTextField, "$this$BasicTextField");
        if ($this$BasicTextField.getChanges().getChangeCount() == 1) {
            TextFieldBuffer.ChangeList $this$forEachChange$iv2 = $this$BasicTextField.getChanges();
            int i$iv = 0;
            while (i$iv < $this$forEachChange$iv2.getChangeCount()) {
                long insertedRange = $this$forEachChange$iv2.getRange--jx7JFs(i$iv);
                long replacedRange = $this$forEachChange$iv2.getOriginalRange--jx7JFs(i$iv);
                System.out.println((Object) ("OuroTextField: insertedRange:" + TextRange.toString-impl(insertedRange)));
                System.out.println((Object) ("OuroTextField: replacedRange:" + TextRange.toString-impl(replacedRange)));
                if (TextRange.getCollapsed-impl(insertedRange)) {
                    $store.dispatch(new OuroDeleteByLengthAction(TextRange.getLength-impl(replacedRange), null, null, 6, null));
                    $this$forEachChange$iv = $this$forEachChange$iv2;
                } else {
                    String obj = $this$BasicTextField.asCharSequence().subSequence(TextRange.getStart-impl(insertedRange), TextRange.getEnd-impl(insertedRange)).toString();
                    OuroState this_$iv = OuroComposeTextField$lambda$1($ouroState$delegate);
                    KClass key$iv = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
                    OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
                    $this$forEachChange$iv = $this$forEachChange$iv2;
                    if (!(ouroPluginState instanceof OuroTextStyleState)) {
                        ouroPluginState = null;
                    }
                    OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState;
                    if (ouroTextStyleState != null) {
                        $store.dispatch(new OuroInsertAction(obj, null, null, ouroTextStyleState.getInsertTextStyle().getMarks(), null, false, null, ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT, null));
                    } else {
                        throw new NoSuchElementException("No plugin state for " + key$iv);
                    }
                }
                i$iv++;
                $this$forEachChange$iv2 = $this$forEachChange$iv;
            }
        } else if ($this$BasicTextField.getChanges().getChangeCount() == 0) {
            $store.dispatch(new OuroUpdateSelectionAction(TextRangeUtilsKt.m2143toOuroTextRange5zctL8($this$BasicTextField.getSelection-d9O1mEE()), true, null, 4, null));
        } else {
            System.out.println((Object) ("More than one changes " + $this$BasicTextField.getChanges()));
        }
        $this$BasicTextField.revertAllChanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0264 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x032a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0260  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OuroComposeTextField$lambda$27$0$3$3$0(MutableState $textLayout$delegate, MutableState $ouroAnnotatedString$delegate, MutableState $drawableLayoutList$delegate, Density $density, MutableState $blockQuoteLayoutList$delegate, MutableState $listItemLayoutList$delegate, MutableState $backgroundLayoutList$delegate, Density $this$BasicTextField, Function0 it) {
        List emptyList;
        List emptyList2;
        List emptyList3;
        List emptyList4;
        boolean z;
        Iterable $this$mapNotNull$iv;
        Object m2636constructorimpl;
        BackgroundLayout backgroundLayout;
        TextLayoutResult layout;
        Object m2636constructorimpl2;
        ListItemLayout listItemLayout;
        TextLayoutResult layout2;
        Object m2636constructorimpl3;
        BlockQuoteLayout blockQuoteLayout;
        TextLayoutResult currentLayout;
        Object m2636constructorimpl4;
        DrawableLayout drawableLayout;
        Intrinsics.checkNotNullParameter($this$BasicTextField, "$this$BasicTextField");
        Intrinsics.checkNotNullParameter(it, "it");
        TextLayoutResult currentLayout2 = (TextLayoutResult) it.invoke();
        $textLayout$delegate.setValue(currentLayout2);
        if (currentLayout2 != null) {
            Iterable list$iv$iv = OuroComposeTextField$lambda$9($ouroAnnotatedString$delegate).getDrawables();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : list$iv$iv) {
                CustomAnnotation annotation = (CustomAnnotation) element$iv$iv;
                Iterable $this$flatMap$iv = list$iv$iv;
                CollectionsKt.addAll(destination$iv$iv, CollectionsKt.listOf(new IndexedValue(TextRange.getStart-impl(annotation.m2119getRanged9O1mEE()), annotation.getValue())));
                list$iv$iv = $this$flatMap$iv;
            }
            Iterable $this$mapNotNull$iv2 = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                IndexedValue indexedValue = (IndexedValue) element$iv$iv$iv;
                Iterable $this$mapNotNull$iv3 = $this$mapNotNull$iv2;
                int offset = indexedValue.component1();
                DrawableStyle style = (DrawableStyle) indexedValue.component2();
                try {
                    Result.Companion companion = Result.Companion;
                    Rect charBoundingBox = currentLayout2.getBoundingBox(offset);
                    int lineNumber = currentLayout2.getLineForOffset(offset);
                    float lineBottom = currentLayout2.getLineBottom(lineNumber);
                    currentLayout = currentLayout2;
                    try {
                        m2636constructorimpl4 = Result.m2636constructorimpl(new DrawableLayout(style, charBoundingBox, lineBottom));
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.Companion;
                        m2636constructorimpl4 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        if (Result.m2642isFailureimpl(m2636constructorimpl4)) {
                        }
                        drawableLayout = (DrawableLayout) m2636constructorimpl4;
                        if (drawableLayout == null) {
                        }
                        $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
                        currentLayout2 = currentLayout;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    currentLayout = currentLayout2;
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl4)) {
                    m2636constructorimpl4 = null;
                }
                drawableLayout = (DrawableLayout) m2636constructorimpl4;
                if (drawableLayout == null) {
                    destination$iv$iv2.add(drawableLayout);
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv3;
                currentLayout2 = currentLayout;
            }
            emptyList = (List) destination$iv$iv2;
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        $drawableLayoutList$delegate.setValue(emptyList);
        TextLayoutResult OuroComposeTextField$lambda$13 = OuroComposeTextField$lambda$13($textLayout$delegate);
        int i = 0;
        if (OuroComposeTextField$lambda$13 != null) {
            TextLayoutResult layout3 = OuroComposeTextField$lambda$13;
            Iterable $this$mapNotNull$iv4 = OuroComposeTextField$lambda$9($ouroAnnotatedString$delegate).getQuotes();
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv$iv2 : $this$mapNotNull$iv4) {
                CustomAnnotation style2 = (CustomAnnotation) element$iv$iv$iv2;
                try {
                    Result.Companion companion3 = Result.Companion;
                    int startOffset = TextRange.getMin-impl(style2.m2119getRanged9O1mEE());
                    int endOffset = Math.max(i, TextRange.getMax-impl(style2.m2119getRanged9O1mEE()) - 1);
                    int startLine = layout3.getLineForOffset(startOffset);
                    int endLine = layout3.getLineForOffset(Math.max(0, endOffset));
                    layout2 = layout3;
                    try {
                        m2636constructorimpl3 = Result.m2636constructorimpl(new BlockQuoteLayout(startOffset, endOffset, startLine, endLine, $density.toPx-0680j_4(Dp.constructor-impl(16))));
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion4 = Result.Companion;
                        m2636constructorimpl3 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        if (Result.m2642isFailureimpl(m2636constructorimpl3)) {
                        }
                        blockQuoteLayout = (BlockQuoteLayout) m2636constructorimpl3;
                        if (blockQuoteLayout == null) {
                        }
                        i = 0;
                        layout3 = layout2;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    layout2 = layout3;
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl3)) {
                    m2636constructorimpl3 = null;
                }
                blockQuoteLayout = (BlockQuoteLayout) m2636constructorimpl3;
                if (blockQuoteLayout == null) {
                    destination$iv$iv3.add(blockQuoteLayout);
                }
                i = 0;
                layout3 = layout2;
            }
            emptyList2 = (List) destination$iv$iv3;
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        $blockQuoteLayoutList$delegate.setValue(emptyList2);
        TextLayoutResult OuroComposeTextField$lambda$132 = OuroComposeTextField$lambda$13($textLayout$delegate);
        if (OuroComposeTextField$lambda$132 != null) {
            TextLayoutResult layout4 = OuroComposeTextField$lambda$132;
            Iterable $this$mapNotNull$iv5 = OuroComposeTextField$lambda$9($ouroAnnotatedString$delegate).getListOrders();
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv$iv3 : $this$mapNotNull$iv5) {
                CustomAnnotation annotation2 = (CustomAnnotation) element$iv$iv$iv3;
                try {
                    Result.Companion companion5 = Result.Companion;
                    int line = layout4.getLineForOffset(TextRange.getMin-impl(annotation2.m2119getRanged9O1mEE()));
                    layout = layout4;
                    try {
                        m2636constructorimpl2 = Result.m2636constructorimpl(new ListItemLayout((ListOrderStyle) annotation2.getValue(), line));
                    } catch (Throwable th5) {
                        th = th5;
                        Result.Companion companion6 = Result.Companion;
                        m2636constructorimpl2 = Result.m2636constructorimpl(ResultKt.createFailure(th));
                        if (Result.m2642isFailureimpl(m2636constructorimpl2)) {
                        }
                        listItemLayout = (ListItemLayout) m2636constructorimpl2;
                        if (listItemLayout == null) {
                        }
                        layout4 = layout;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    layout = layout4;
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl2)) {
                    m2636constructorimpl2 = null;
                }
                listItemLayout = (ListItemLayout) m2636constructorimpl2;
                if (listItemLayout == null) {
                    destination$iv$iv4.add(listItemLayout);
                }
                layout4 = layout;
            }
            emptyList3 = (List) destination$iv$iv4;
        } else {
            emptyList3 = CollectionsKt.emptyList();
        }
        $listItemLayoutList$delegate.setValue(emptyList3);
        TextLayoutResult layout5 = OuroComposeTextField$lambda$13($textLayout$delegate);
        if (layout5 != null) {
            boolean z2 = false;
            Iterable $this$mapNotNull$iv6 = OuroComposeTextField$lambda$9($ouroAnnotatedString$delegate).getBackgrounds();
            Collection destination$iv$iv5 = new ArrayList();
            for (Object element$iv$iv$iv4 : $this$mapNotNull$iv6) {
                CustomAnnotation annotation3 = (CustomAnnotation) element$iv$iv$iv4;
                try {
                    Result.Companion companion7 = Result.Companion;
                    int startOffset2 = TextRange.getMin-impl(annotation3.m2119getRanged9O1mEE());
                    try {
                        int endOffset2 = Math.max(0, TextRange.getMax-impl(annotation3.m2119getRanged9O1mEE()) - 1);
                        int startLine2 = layout5.getLineForOffset(startOffset2);
                        z = z2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv6;
                        try {
                            int endLine2 = layout5.getLineForOffset(Math.max(0, endOffset2));
                            m2636constructorimpl = Result.m2636constructorimpl(new BackgroundLayout(startOffset2, endOffset2, startLine2, endLine2, (BackgroundStyle) annotation3.getValue()));
                        } catch (Throwable th7) {
                            th = th7;
                            Result.Companion companion8 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            if (Result.m2642isFailureimpl(m2636constructorimpl)) {
                            }
                            backgroundLayout = (BackgroundLayout) m2636constructorimpl;
                            if (backgroundLayout == null) {
                            }
                            z2 = z;
                            $this$mapNotNull$iv6 = $this$mapNotNull$iv;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        z = z2;
                        $this$mapNotNull$iv = $this$mapNotNull$iv6;
                    }
                } catch (Throwable th9) {
                    th = th9;
                    z = z2;
                    $this$mapNotNull$iv = $this$mapNotNull$iv6;
                }
                if (Result.m2642isFailureimpl(m2636constructorimpl)) {
                    m2636constructorimpl = null;
                }
                backgroundLayout = (BackgroundLayout) m2636constructorimpl;
                if (backgroundLayout == null) {
                    destination$iv$iv5.add(backgroundLayout);
                }
                z2 = z;
                $this$mapNotNull$iv6 = $this$mapNotNull$iv;
            }
            emptyList4 = (List) destination$iv$iv5;
        } else {
            emptyList4 = CollectionsKt.emptyList();
        }
        $backgroundLayoutList$delegate.setValue(emptyList4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DrawableLayer(final BoxScope $this$DrawableLayer, final List<DrawableLayout> list, final OuroStore ouroStore, final OuroState ouroState, final ScrollState scrollState, final int mainAxisLength, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1301736213);
        ComposerKt.sourceInformation($composer2, "C(DrawableLayer)N(drawableLayoutList,ouroStore,ouroState,scrollState,mainAxisLength):OuroComposeTextField.kt#equpx4");
        if ($composer2.shouldExecute(($changed & 1) != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1301736213, $changed, -1, "kntr.common.ouro.ui.textField.DrawableLayer (OuroComposeTextField.kt:559)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.textField.OuroComposeTextFieldKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit DrawableLayer$lambda$0;
                    DrawableLayer$lambda$0 = OuroComposeTextFieldKt.DrawableLayer$lambda$0($this$DrawableLayer, list, ouroStore, ouroState, scrollState, mainAxisLength, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return DrawableLayer$lambda$0;
                }
            });
        }
    }
}