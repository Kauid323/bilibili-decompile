package kntr.common.paragraph.input;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.paragraph.input.content.ParagraphContent;
import kntr.common.paragraph.input.content.TextContent;
import kntr.common.paragraph.input.content.TextRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: RichTextInputFields.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a£\u0001\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u001828\b\u0002\u0010\u0019\u001a2\u0012\u0004\u0012\u00020\u001b\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a¢\u0006\u0002\b!H\u0007¢\u0006\u0002\u0010\"\u001a\f\u0010#\u001a\u00020\u0010*\u00020\u0014H\u0003\u001a\u0011\u0010$\u001a\u00020%*\u00020&H\u0003¢\u0006\u0002\u0010'\u001a\u0013\u0010(\u001a\u00020&*\u00020%H\u0003¢\u0006\u0004\b)\u0010*¨\u0006+"}, d2 = {"RichTextInputFields", "", "contentState", "Lkntr/common/paragraph/input/RichTextContent;", "onAction", "Lkotlin/Function1;", "Lkntr/common/paragraph/input/RichTextAction;", "modifier", "Landroidx/compose/ui/Modifier;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "hint", "", "(Lkntr/common/paragraph/input/RichTextContent;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TextParagraphContent", "paragraphContent", "Lkntr/common/paragraph/input/content/TextContent;", "index", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "(Lkntr/common/paragraph/input/content/TextContent;ILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/foundation/text/input/InputTransformation;Ljava/lang/String;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "content", "composeRange", "Landroidx/compose/ui/text/TextRange;", "Lkntr/common/paragraph/input/content/TextRange;", "(Lkntr/common/paragraph/input/content/TextRange;)J", "range", "range-5zc-tL8", "(J)Lkntr/common/paragraph/input/content/TextRange;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RichTextInputFieldsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichTextInputFields$lambda$5(RichTextContent richTextContent, Function1 function1, Modifier modifier, PaddingValues paddingValues, String str, int i, int i2, Composer composer, int i3) {
        RichTextInputFields(richTextContent, function1, modifier, paddingValues, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextParagraphContent$lambda$2(TextContent textContent, int i, Function1 function1, Modifier modifier, TextFieldState textFieldState, InputTransformation inputTransformation, String str, MutableInteractionSource mutableInteractionSource, Function2 function2, int i2, int i3, Composer composer, int i4) {
        TextParagraphContent(textContent, i, function1, modifier, textFieldState, inputTransformation, str, mutableInteractionSource, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0193, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RichTextInputFields(final RichTextContent contentState, final Function1<? super RichTextAction, Unit> function1, Modifier modifier, PaddingValues contentPadding, String hint, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PaddingValues paddingValues;
        String hint2;
        Modifier modifier3;
        PaddingValues contentPadding2;
        Modifier modifier4;
        final String hint3;
        Intrinsics.checkNotNullParameter(contentState, "contentState");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(149743676);
        ComposerKt.sourceInformation($composer2, "C(RichTextInputFields)N(contentState,onAction,modifier,contentPadding,hint)42@1806L29,44@1869L68,51@2066L66,53@2148L180,60@2448L1773,47@1942L2279:RichTextInputFields.kt#wwauus");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(contentState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
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
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            paddingValues = contentPadding;
        } else if (($changed & 3072) == 0) {
            paddingValues = contentPadding;
            $dirty |= $composer2.changed(paddingValues) ? 2048 : 1024;
        } else {
            paddingValues = contentPadding;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            hint2 = hint;
        } else if (($changed & 24576) == 0) {
            hint2 = hint;
            $dirty |= $composer2.changed(hint2) ? 16384 : 8192;
        } else {
            hint2 = hint;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            contentPadding2 = paddingValues;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            PaddingValues contentPadding3 = i3 != 0 ? PaddingKt.PaddingValues-YgX7TsA$default(0.0f, 0.0f, 3, (Object) null) : paddingValues;
            if (i4 == 0) {
                hint3 = hint2;
            } else {
                hint3 = "";
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(149743676, $dirty, -1, "kntr.common.paragraph.input.RichTextInputFields (RichTextInputFields.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2125207815, "CC(remember):RichTextInputFields.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FocusRequester();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final FocusRequester parentFocus = (FocusRequester) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2125205760, "CC(remember):RichTextInputFields.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Map) new LinkedHashMap();
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Map paragraphFocus = (Map) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier focusRequester = FocusRequesterModifierKt.focusRequester(modifier4, parentFocus);
            ComposerKt.sourceInformationMarkerStart($composer2, -2125199458, "CC(remember):RichTextInputFields.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                modifier3 = modifier4;
                Object value$iv3 = new Function0() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit RichTextInputFields$lambda$2$0;
                        RichTextInputFields$lambda$2$0 = RichTextInputFieldsKt.RichTextInputFields$lambda$2$0(parentFocus);
                        return RichTextInputFields$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                modifier3 = modifier4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(focusRequester, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -2125196720, "CC(remember):RichTextInputFields.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(paragraphFocus) | $composer2.changedInstance(contentState);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv4 = new Function1() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit RichTextInputFields$lambda$3$0;
                    RichTextInputFields$lambda$3$0 = RichTextInputFieldsKt.RichTextInputFields$lambda$3$0(paragraphFocus, contentState, (FocusState) obj);
                    return RichTextInputFields$lambda$3$0;
                }
            };
            $composer2.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier focusable$default = FocusableKt.focusable$default(FocusChangedModifierKt.onFocusChanged(modifier5, (Function1) it$iv4), false, (MutableInteractionSource) null, 3, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer2, -2125185527, "CC(remember):RichTextInputFields.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(contentState) | $composer2.changedInstance(paragraphFocus) | (($dirty & 112) == 32) | ((57344 & $dirty) == 16384);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit RichTextInputFields$lambda$4$0;
                        RichTextInputFields$lambda$4$0 = RichTextInputFieldsKt.RichTextInputFields$lambda$4$0(RichTextContent.this, paragraphFocus, function1, hint3, (LazyListScope) obj);
                        return RichTextInputFields$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(focusable$default, (LazyListState) null, contentPadding3, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv5, $composer2, (($dirty >> 3) & 896) | 24576, 490);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentPadding2 = contentPadding3;
            hint2 = hint3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final PaddingValues paddingValues2 = contentPadding2;
            final String str = hint2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit RichTextInputFields$lambda$5;
                    RichTextInputFields$lambda$5 = RichTextInputFieldsKt.RichTextInputFields$lambda$5(RichTextContent.this, function1, modifier6, paddingValues2, str, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RichTextInputFields$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichTextInputFields$lambda$2$0(FocusRequester $parentFocus) {
        FocusRequester.requestFocus-3ESFkO8$default($parentFocus, 0, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichTextInputFields$lambda$3$0(Map $paragraphFocus, RichTextContent $contentState, FocusState it) {
        FocusRequester focusRequester;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isFocused() && (focusRequester = (FocusRequester) $paragraphFocus.get(Integer.valueOf(RangesKt.coerceAtLeast($contentState.getCurrentFocus(), 0)))) != null) {
            FocusRequester.requestFocus-3ESFkO8$default(focusRequester, 0, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RichTextInputFields$lambda$4$0(final RichTextContent $contentState, final Map $paragraphFocus, final Function1 $onAction, final String $hint, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $contentState.getContentList();
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$RichTextInputFields$lambda$4$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$RichTextInputFields$lambda$4$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:71:0x0305, code lost:
                if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, final int it, Composer $composer, int $changed) {
                FocusRequester focusRequester;
                Function0 factory$iv$iv$iv;
                Composer $composer$iv;
                String str;
                int index;
                Composer $composer$iv$iv;
                Composer $composer2;
                Composer $composer3;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    int $changed2 = ($dirty & 14) | ($dirty & 112);
                    ParagraphContent content = (ParagraphContent) items$iv.get(it);
                    $composer.startReplaceGroup(-620447161);
                    ComposerKt.sourceInformation($composer, "CN(index,content)*64@2649L331,73@2993L1212:RichTextInputFields.kt#wwauus");
                    Map $this$getOrPut$iv = $paragraphFocus;
                    Integer valueOf = Integer.valueOf(it);
                    Object value$iv = $this$getOrPut$iv.get(valueOf);
                    if (value$iv == null) {
                        focusRequester = new FocusRequester();
                        $this$getOrPut$iv.put(valueOf, focusRequester);
                    } else {
                        focusRequester = value$iv;
                    }
                    FocusRequester focusRequester2 = (FocusRequester) focusRequester;
                    ComposerKt.sourceInformationMarkerStart($composer, 672724731, "CC(remember):RichTextInputFields.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Modifier focusRequester3 = FocusRequesterModifierKt.focusRequester(Modifier.Companion, focusRequester2);
                        final Function1 function1 = $onAction;
                        Object value$iv2 = FocusChangedModifierKt.onFocusChanged(focusRequester3, new Function1<FocusState, Unit>() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$RichTextInputFields$3$1$1$itemModifier$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((FocusState) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(FocusState it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                if (it2.isFocused()) {
                                    function1.invoke(new RichTextAction.FocusOn(it, false, 2, null));
                                }
                            }
                        });
                        $composer.updateRememberedValue(value$iv2);
                        it$iv = value$iv2;
                    }
                    Modifier itemModifier = (Modifier) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv = LazyItemScope.-CC.fillParentMaxWidth$default($this$items, Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                    Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv2;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 368575617, "C95@3998L193,95@3919L272:RichTextInputFields.kt#wwauus");
                    if (content instanceof TextContent) {
                        $composer.startReplaceGroup(368583800);
                        ComposerKt.sourceInformation($composer, "78@3209L360");
                        TextContent textContent = (TextContent) content;
                        Function1 function12 = $onAction;
                        Modifier fillParentMaxWidth$default = LazyItemScope.-CC.fillParentMaxWidth$default($this$items, itemModifier, 0.0f, 1, (Object) null);
                        $composer$iv$iv = $composer;
                        $composer$iv = $composer;
                        str = "CC(remember):RichTextInputFields.kt#9igjgp";
                        $composer2 = $composer;
                        index = it;
                        RichTextInputFieldsKt.TextParagraphContent(textContent, it, function12, fillParentMaxWidth$default, null, null, $contentState.getContentList().size() == 1 ? $hint : null, null, null, $composer, (($changed2 >> 6) & 14) | ($changed2 & 112), 432);
                        $composer.endReplaceGroup();
                        $composer3 = $composer;
                    } else {
                        $composer$iv = $composer;
                        str = "CC(remember):RichTextInputFields.kt#9igjgp";
                        index = it;
                        $composer$iv$iv = $composer;
                        $composer2 = $composer;
                        $composer3 = $composer;
                        $composer3.startReplaceGroup(365408904);
                        $composer3.endReplaceGroup();
                    }
                    if (content instanceof AssetContent) {
                        $composer3.startReplaceGroup(369022171);
                        ComposerKt.sourceInformation($composer3, "88@3655L229");
                        AssetParagraphContentKt.AssetParagraphContent((AssetContent) content, index, $onAction, itemModifier, $composer3, (($changed2 >> 6) & 14) | 3072 | ($changed2 & 112), 0);
                    } else {
                        $composer3.startReplaceGroup(365408904);
                    }
                    $composer3.endReplaceGroup();
                    Boolean valueOf2 = Boolean.valueOf($contentState.getCurrentFocus() == index);
                    Boolean valueOf3 = Boolean.valueOf($contentState.getFocusConsumed());
                    ComposerKt.sourceInformationMarkerStart($composer3, -2066294437, str);
                    boolean invalid$iv = $composer3.changedInstance($contentState) | (((($changed2 & 112) ^ 48) > 32 && $composer3.changed(index)) || ($changed2 & 48) == 32) | $composer3.changed(focusRequester2);
                    Composer $this$cache$iv = $composer3;
                    RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1 value$iv3 = $this$cache$iv.rememberedValue();
                    if (invalid$iv) {
                    }
                    value$iv3 = new RichTextInputFieldsKt$RichTextInputFields$3$1$1$1$2$1($contentState, index, focusRequester2, null);
                    $this$cache$iv.updateRememberedValue(value$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf2, valueOf3, (Function2) value$iv3, $composer3, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:155:0x0275, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextParagraphContent(final TextContent paragraphContent, final int index, final Function1<? super RichTextAction, Unit> function1, Modifier modifier, TextFieldState state, InputTransformation inputTransformation, String hint, MutableInteractionSource interactionSource, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TextFieldState state2;
        String hint2;
        MutableInteractionSource interactionSource2;
        InputTransformation inputTransformation2;
        String hint3;
        Function2 onTextLayout;
        Modifier modifier3;
        MutableInteractionSource interactionSource3;
        TextFieldState state3;
        Modifier modifier4;
        Modifier modifier5;
        int i2;
        InputTransformation inputTransformation3;
        String hint4;
        int $dirty;
        Function2 onTextLayout2;
        int i3;
        Intrinsics.checkNotNullParameter(paragraphContent, "paragraphContent");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1278920994);
        ComposerKt.sourceInformation($composer2, "C(TextParagraphContent)N(paragraphContent,index,onAction,modifier,state,inputTransformation,hint,interactionSource,onTextLayout)117@4763L515,117@4694L584,131@5296L30,132@5400L89,132@5337L152,142@5718L6,149@5941L6,135@5494L680:RichTextInputFields.kt#wwauus");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(paragraphContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(index) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                state2 = state;
                if ($composer2.changed(state2)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                state2 = state;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            state2 = state;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer2.changed(inputTransformation) ? 131072 : 65536;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            hint2 = hint;
        } else if ((1572864 & $changed) == 0) {
            hint2 = hint;
            $dirty2 |= $composer2.changed(hint2) ? 1048576 : 524288;
        } else {
            hint2 = hint;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty2 |= 12582912;
            interactionSource2 = interactionSource;
        } else if (($changed & 12582912) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 8388608 : 4194304;
        } else {
            interactionSource2 = interactionSource;
        }
        int i8 = i & 256;
        if (i8 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 67108864 : 33554432;
        }
        int $dirty3 = $dirty2;
        if ($composer2.shouldExecute(($dirty3 & 38347923) != 38347922, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "111@4417L48");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                inputTransformation3 = inputTransformation;
                onTextLayout2 = function2;
                $dirty = $dirty3;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if ((i & 16) == 0) {
                    modifier5 = modifier4;
                    i2 = i7;
                } else {
                    i2 = i7;
                    modifier5 = modifier4;
                    $dirty3 &= -57345;
                    state2 = TextFieldStateKt.rememberTextFieldState-Le-punE(paragraphContent.getContent(), 0L, $composer2, 0, 2);
                }
                if (i5 == 0) {
                    inputTransformation3 = inputTransformation;
                } else {
                    inputTransformation3 = null;
                }
                if (i6 == 0) {
                    hint4 = hint;
                } else {
                    hint4 = null;
                }
                if (i2 != 0) {
                    interactionSource2 = null;
                }
                if (i8 == 0) {
                    modifier2 = modifier5;
                    hint2 = hint4;
                    $dirty = $dirty3;
                    onTextLayout2 = function2;
                } else {
                    hint2 = hint4;
                    onTextLayout2 = null;
                    $dirty = $dirty3;
                    modifier2 = modifier5;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1278920994, $dirty, -1, "kntr.common.paragraph.input.TextParagraphContent (RichTextInputFields.kt:116)");
            }
            String content = paragraphContent.getContent();
            TextRange selection = paragraphContent.getSelection();
            ComposerKt.sourceInformationMarkerStart($composer2, -682411231, "CC(remember):RichTextInputFields.kt#9igjgp");
            interactionSource3 = interactionSource2;
            boolean invalid$iv = (((($dirty & 57344) ^ 24576) > 16384 && $composer2.changed(state2)) || ($dirty & 24576) == 16384) | $composer2.changedInstance(paragraphContent);
            Object it$iv = $composer2.rememberedValue();
            onTextLayout = onTextLayout2;
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new RichTextInputFieldsKt$TextParagraphContent$1$1(paragraphContent, state2, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(content, selection, (Function2) it$iv, $composer2, 0);
            Function1 action = (Function1) SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty >> 6) & 14).getValue();
            CharSequence text = state2.getText();
            androidx.compose.ui.text.TextRange textRange = androidx.compose.ui.text.TextRange.box-impl(state2.getSelection-d9O1mEE());
            androidx.compose.ui.text.TextRange textRange2 = state2.getComposition-MzsxiRA();
            ComposerKt.sourceInformationMarkerStart($composer2, -682391273, "CC(remember):RichTextInputFields.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(action) | (((($dirty & 57344) ^ 24576) > 16384 && $composer2.changed(state2)) || ($dirty & 24576) == 16384) | (($dirty & 112) == 32);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = (Function2) new RichTextInputFieldsKt$TextParagraphContent$2$1(action, state2, index, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(text, textRange, textRange2, (Function2) it$iv2, $composer2, 0);
            String str = hint2 == null ? "" : hint2;
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa9-0d7_KjU();
            long sp = TextUnitKt.getSp(17);
            long sp2 = TextUnitKt.getSp(0);
            long sp3 = TextUnitKt.getSp(17);
            TextUnitKt.checkArithmetic--R2X_6o(sp3);
            TextStyle textStyle = new TextStyle(j, sp, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, sp2, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.pack(TextUnit.getRawType-impl(sp3), TextUnit.getValue-impl(sp3) * 1.7f), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646012, (DefaultConstructorMarker) null);
            long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU();
            long sp4 = TextUnitKt.getSp(17);
            long sp5 = TextUnitKt.getSp(0);
            long sp6 = TextUnitKt.getSp(17);
            TextUnitKt.checkArithmetic--R2X_6o(sp6);
            SimpleTextFieldKt.SimpleTextField(state2, modifier2, false, false, str, inputTransformation3, textStyle, new TextStyle(j2, sp4, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, sp5, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.pack(TextUnit.getRawType-impl(sp6), TextUnit.getValue-impl(sp6) * 1.7f), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646012, (DefaultConstructorMarker) null), (KeyboardOptions) null, (KeyboardActionHandler) null, (TextFieldLineLimits) null, onTextLayout, interactionSource3, (OutputTransformation) null, (ScrollState) null, (Brush) null, $composer2, (($dirty >> 12) & 14) | (($dirty >> 6) & 112) | (458752 & $dirty), (($dirty >> 21) & 112) | (($dirty >> 15) & 896), 59148);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            inputTransformation2 = inputTransformation3;
            modifier3 = modifier2;
            hint3 = hint2;
            state3 = state2;
        } else {
            $composer2.skipToGroupEnd();
            inputTransformation2 = inputTransformation;
            hint3 = hint;
            onTextLayout = function2;
            modifier3 = modifier2;
            interactionSource3 = interactionSource2;
            state3 = state2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final TextFieldState textFieldState = state3;
            final InputTransformation inputTransformation4 = inputTransformation2;
            final String str2 = hint3;
            final MutableInteractionSource mutableInteractionSource = interactionSource3;
            final Function2 function22 = onTextLayout;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.paragraph.input.RichTextInputFieldsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextParagraphContent$lambda$2;
                    TextParagraphContent$lambda$2 = RichTextInputFieldsKt.TextParagraphContent$lambda$2(TextContent.this, index, function1, modifier6, textFieldState, inputTransformation4, str2, mutableInteractionSource, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextParagraphContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextContent content(TextFieldState $this$content) {
        String obj = $this$content.getText().toString();
        TextRange m2174range5zctL8 = m2174range5zctL8($this$content.getSelection-d9O1mEE());
        androidx.compose.ui.text.TextRange textRange = $this$content.getComposition-MzsxiRA();
        return new TextContent(obj, m2174range5zctL8, textRange != null ? m2174range5zctL8(textRange.unbox-impl()) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long composeRange(TextRange $this$composeRange) {
        return TextRangeKt.TextRange($this$composeRange.getStart(), $this$composeRange.getEnd());
    }

    /* renamed from: range-5zc-tL8  reason: not valid java name */
    private static final TextRange m2174range5zctL8(long j) {
        return new TextRange(androidx.compose.ui.text.TextRange.getStart-impl(j), androidx.compose.ui.text.TextRange.getEnd-impl(j));
    }
}