package kntr.app.deepsearch.ui.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import java.util.Map;
import kntr.app.deepsearch.ui.colors.DSColorsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
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
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: Thinking.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0011\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u008e\u0002"}, d2 = {"Thinking", RoomRecommendViewModel.EMPTY_CURSOR, "thinking", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getShowContent", "Landroidx/compose/ui/text/AnnotatedString;", "color", "Landroidx/compose/ui/graphics/Color;", "getShowContent-RPmYEkk", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking;JLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/AnnotatedString;", "compose_debug", "start", RoomRecommendViewModel.EMPTY_CURSOR, "end", "alphaTarget", "lastShow", RoomRecommendViewModel.EMPTY_CURSOR}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ThinkingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thinking$lambda$2(KThinking kThinking, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Thinking(kThinking, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void Thinking(final KThinking thinking, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(thinking, "thinking");
        Composer $composer3 = $composer.startRestartGroup(-481796857);
        ComposerKt.sourceInformation($composer3, "C(Thinking)N(thinking,modifier)46@1930L7,52@2046L6,52@2036L31,55@2095L85,60@2186L3439:Thinking.kt#pp6rt");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(thinking) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-481796857, $dirty, -1, "kntr.app.deepsearch.ui.cards.Thinking (Thinking.kt:44)");
            }
            float height = Dp.constructor-impl(84);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            final float heightInPx = density.toPx-0680j_4(height);
            final long color = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_TEXT, $composer3, 48);
            final AnnotatedString content = m727getShowContentRPmYEkk(thinking, color, $composer3, $dirty & 14);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), height);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -194910761, "C76@2706L6,76@2696L43,77@2791L6,77@2781L41,83@3065L6,83@3055L33,95@3552L2067,66@2312L3307:Thinking.kt#pp6rt");
            $composer2 = $composer3;
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.wrapContentHeight(ClipKt.clipToBounds(PaddingKt.padding-qDBjuR0$default(BorderKt.border-xT4_qwU(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), height), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_BACKGROUND_START, $composer3, 48)), Color.box-impl(DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_BACKGROUND_END, $composer3, 48))}), 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), 0.0f, 4, (Object) null), Dp.constructor-impl((float) 0.5d), DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_STROKE, $composer3, 48), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(14), 0.0f, Dp.constructor-impl(14), Dp.constructor-impl(13), 2, (Object) null)), Alignment.Companion.getBottom(), true), Alignment.Companion.getBottomStart(), false, ComposableLambdaKt.rememberComposableLambda(-1655036757, true, new Function3() { // from class: kntr.app.deepsearch.ui.cards.ThinkingKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit Thinking$lambda$1$0;
                    Thinking$lambda$1$0 = ThinkingKt.Thinking$lambda$1$0(color, content, density, heightInPx, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return Thinking$lambda$1$0;
                }
            }, $composer3, 54), $composer3, 3120, 4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.ThinkingKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Thinking$lambda$2;
                    Thinking$lambda$2 = ThinkingKt.Thinking$lambda$2(thinking, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Thinking$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thinking$lambda$1$0(long $color, AnnotatedString $content, final Density $density, final float $heightInPx, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        int $dirty;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C96@3579L64,99@3667L64,103@3764L22,106@3838L9,116@4200L289,138@5031L563,125@4503L1106:Thinking.kt#pp6rt");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty3 = $dirty2;
        if ($composer.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1655036757, $dirty3, -1, "kntr.app.deepsearch.ui.cards.Thinking.<anonymous>.<anonymous> (Thinking.kt:96)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1352423029, "CC(remember):Thinking.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableFloatState start$delegate = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1352420213, "CC(remember):Thinking.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableFloatState end$delegate = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer, 0, 1);
            TextStyle style = TextStyle.copy-Ns73l9s$default(BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(Thinking$lambda$1$0$1(start$delegate)), Color.box-impl(Color.copy-wmQWz5c$default($color, 0.24000001f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(Thinking$lambda$1$0$4(end$delegate)), Color.box-impl(Color.copy-wmQWz5c$default($color, 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null)))}, 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(21), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33292286, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1352402932, "CC(remember):Thinking.kt#9igjgp");
            boolean invalid$iv = $composer.changed($content) | $composer.changed(style);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = Integer.valueOf(TextMeasurer.measure-xDpz5zY$default(textMeasurer, $content, style, 0, false, 0, (List) null, $this$BoxWithConstraints.getConstraints-msEJaDk(), (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1980, (Object) null).getLineCount());
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            int lineCount = ((Number) it$iv3).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer);
            float lineHeight = $density.toPx--R2X_6o(TextUnitKt.getSp(21));
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, $density.toDp-u2uoSUM(RangesKt.coerceAtLeast($density.toPx-0680j_4(Dp.constructor-impl(63)) - (lineCount * lineHeight), 0.0f)), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1352376066, "CC(remember):Thinking.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($density) | $composer.changed($heightInPx);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                $dirty = $dirty3;
                Object value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.ThinkingKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit Thinking$lambda$1$0$8$0;
                        Thinking$lambda$1$0$8$0 = ThinkingKt.Thinking$lambda$1$0$8$0($density, $heightInPx, start$delegate, end$delegate, (TextLayoutResult) obj);
                        return Thinking$lambda$1$0$8$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            } else {
                $dirty = $dirty3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Z58ophY($content, modifier, $color, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, Integer.MAX_VALUE, 0, (Map) null, (Function1) it$iv4, style, $composer, 0, 24576, 114680);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float Thinking$lambda$1$0$1(MutableFloatState $start$delegate) {
        FloatState $this$getValue$iv = (FloatState) $start$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float Thinking$lambda$1$0$4(MutableFloatState $end$delegate) {
        FloatState $this$getValue$iv = (FloatState) $end$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thinking$lambda$1$0$8$0(Density $density, float $heightInPx, MutableFloatState $start$delegate, MutableFloatState $end$delegate, TextLayoutResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        float h = $density.toPx-0680j_4(Dp.constructor-impl(71));
        float distance = $density.toPx-0680j_4(Dp.constructor-impl(30));
        $start$delegate.setFloatValue((((int) (it.getSize-YbymL2g() & 4294967295L)) - h) / ((int) (it.getSize-YbymL2g() & 4294967295L)));
        int $i$f$unpackInt2 = (int) (4294967295L & it.getSize-YbymL2g());
        $end$delegate.setFloatValue(((((int) (it.getSize-YbymL2g() & 4294967295L)) - h) + distance) / $i$f$unpackInt2);
        ILogger kLog = KLog_androidKt.getKLog();
        String str = IntSize.toString-impl(it.getSize-YbymL2g());
        float Thinking$lambda$1$0$1 = Thinking$lambda$1$0$1($start$delegate);
        kLog.d("thinking", "size:" + str + ", heightInPx:" + $heightInPx + ", start:" + Thinking$lambda$1$0$1 + ", end:" + Thinking$lambda$1$0$4($end$delegate));
        return Unit.INSTANCE;
    }

    /* renamed from: getShowContent-RPmYEkk  reason: not valid java name */
    public static final AnnotatedString m727getShowContentRPmYEkk(KThinking thinking, long j2, Composer $composer, int $changed) {
        State animateFloatAsState;
        Intrinsics.checkNotNullParameter(thinking, "thinking");
        ComposerKt.sourceInformationMarkerStart($composer, 1079375466, "C(getShowContent)N(thinking,color:c#ui.graphics.Color)165@5796L48,169@5878L32,169@5850L60,182@6152L52,187@6238L477:Thinking.kt#pp6rt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1079375466, $changed, -1, "kntr.app.deepsearch.ui.cards.getShowContent (Thinking.kt:162)");
        }
        String showContent = thinking.getThinkingContent();
        ComposerKt.sourceInformationMarkerStart($composer, -2102257798, "CC(remember):Thinking.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableFloatState alphaTarget$delegate = (MutableFloatState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -2102255190, "CC(remember):Thinking.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new ThinkingKt$getShowContent$1$1(alphaTarget$delegate, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(showContent, (Function2) it$iv2, $composer, 0);
        if (getShowContent_RPmYEkk$lambda$1(alphaTarget$delegate) == 0.0f) {
            $composer.startReplaceGroup(-745320228);
            ComposerKt.sourceInformation($composer, "175@5973L36");
            ComposerKt.sourceInformationMarkerStart($composer, -2102252146, "CC(remember):Thinking.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endReplaceGroup();
            animateFloatAsState = (State) ((MutableFloatState) it$iv3);
        } else {
            $composer.startReplaceGroup(-745253361);
            ComposerKt.sourceInformation($composer, "177@6072L48,177@6039L81");
            float showContent_RPmYEkk$lambda$1 = getShowContent_RPmYEkk$lambda$1(alphaTarget$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -2102248966, "CC(remember):Thinking.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.ThinkingKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit showContent_RPmYEkk$lambda$5$0;
                        showContent_RPmYEkk$lambda$5$0 = ThinkingKt.getShowContent_RPmYEkk$lambda$5$0(alphaTarget$delegate, ((Float) obj).floatValue());
                        return showContent_RPmYEkk$lambda$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            animateFloatAsState = AnimateAsStateKt.animateFloatAsState(showContent_RPmYEkk$lambda$1, (AnimationSpec) null, 0.0f, (String) null, (Function1) it$iv4, $composer, 24576, 14);
            $composer.endReplaceGroup();
        }
        State alpha = animateFloatAsState;
        ComposerKt.sourceInformationMarkerStart($composer, -2102246402, "CC(remember):Thinking.kt#9igjgp");
        Object it$iv5 = $composer.rememberedValue();
        if (it$iv5 == Composer.Companion.getEmpty()) {
            Object value$iv5 = SnapshotStateKt.mutableStateOf$default(showContent, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
        }
        MutableState lastShow$delegate = (MutableState) it$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        String showContent_RPmYEkk$lambda$7 = getShowContent_RPmYEkk$lambda$7(lastShow$delegate);
        ComposerKt.sourceInformationMarkerStart($composer, -2102243225, "CC(remember):Thinking.kt#9igjgp");
        boolean invalid$iv = $composer.changed(showContent_RPmYEkk$lambda$7) | $composer.changed(showContent) | $composer.changed(alpha);
        Object it$iv6 = $composer.rememberedValue();
        if (invalid$iv || it$iv6 == Composer.Companion.getEmpty()) {
            String diff = StringsKt.removePrefix(showContent, getShowContent_RPmYEkk$lambda$7(lastShow$delegate));
            AnnotatedString.Builder $this$getShowContent_RPmYEkk_u24lambda_u249_u240 = new AnnotatedString.Builder(getShowContent_RPmYEkk$lambda$7(lastShow$delegate));
            $this$getShowContent_RPmYEkk_u24lambda_u249_u240.pushStyle(new SpanStyle(Color.copy-wmQWz5c$default(j2, ((Number) alpha.getValue()).floatValue(), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
            $this$getShowContent_RPmYEkk_u24lambda_u249_u240.append(diff);
            $this$getShowContent_RPmYEkk_u24lambda_u249_u240.pop();
            Object value$iv6 = $this$getShowContent_RPmYEkk_u24lambda_u249_u240.toAnnotatedString();
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
        }
        AnnotatedString showAnnotated = (AnnotatedString) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        lastShow$delegate.setValue(showContent);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return showAnnotated;
    }

    private static final float getShowContent_RPmYEkk$lambda$1(MutableFloatState $alphaTarget$delegate) {
        FloatState $this$getValue$iv = (FloatState) $alphaTarget$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getShowContent_RPmYEkk$lambda$5$0(MutableFloatState $alphaTarget$delegate, float it) {
        $alphaTarget$delegate.setFloatValue(1.0f);
        return Unit.INSTANCE;
    }

    private static final String getShowContent_RPmYEkk$lambda$7(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }
}