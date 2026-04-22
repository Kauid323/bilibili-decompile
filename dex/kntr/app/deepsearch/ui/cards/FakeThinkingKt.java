package kntr.app.deepsearch.ui.cards;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.deepsearch.ui.colors.DSColorsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Drawable0_commonMainKt;
import srcs.app.deepsearch.compose.generated.resources.Res;

/* compiled from: FakeThinking.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007²\u0006\n\u0010\b\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"FakeThinking", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "maxOffset", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "compose_debug", "offset"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FakeThinkingKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FakeThinking$lambda$3(Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        FakeThinking(modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FakeThinking(Modifier modifier, float maxOffset, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final float maxOffset2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(-320405912);
        ComposerKt.sourceInformation($composer3, "C(FakeThinking)N(modifier,maxOffset)44@1994L13,46@2062L6,46@2052L40,47@2121L6,47@2111L38,50@2174L236,60@2441L28,61@2507L295,71@2808L1807:FakeThinking.kt#pp6rt");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            maxOffset2 = maxOffset;
        } else if (($changed & 48) == 0) {
            maxOffset2 = maxOffset;
            $dirty |= $composer3.changed(maxOffset2) ? 32 : 16;
        } else {
            maxOffset2 = maxOffset;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(84)), 0.0f, 1, (Object) null) : modifier2;
            float maxOffset3 = i3 != 0 ? 340.0f : maxOffset2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-320405912, $dirty2, -1, "kntr.app.deepsearch.ui.cards.FakeThinking (FakeThinking.kt:43)");
            }
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer3, BiliTheme.$stable) == ThemeDayNight.Night;
            long backStart = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_FAKE_BG_START, $composer3, 48);
            long backEnd = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_FAKE_BG_END, $composer3, 48);
            ComposerKt.sourceInformationMarkerStart($composer3, 1327574452, "CC(remember):FakeThinking.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(backStart) | $composer3.changed(backEnd);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(backStart), Color.box-impl(backEnd)}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Brush back = (Brush) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer3, 0, 1);
            final State offset$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, maxOffset3, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(4000, 0, new CubicBezierEasing(0.33f, 0.0f, 0.0f, 0.7f), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), (String) null, $composer3, InfiniteTransition.$stable | 48 | (($dirty2 << 3) & 896) | (InfiniteRepeatableSpec.$stable << 9), 8);
            Modifier modifier$iv = ClipKt.clipToBounds(BackgroundKt.background$default(modifier3, back, (Shape) null, 0.0f, 6, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier3;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -366149546, "C78@2993L7,82@3179L6,82@3169L35,83@3282L924,83@3213L993,110@4235L211,109@4216L377:FakeThinking.kt#pp6rt");
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            final float dp16 = density.toPx-0680j_4(Dp.constructor-impl(16));
            final float dp12 = density.toPx-0680j_4(Dp.constructor-impl(12));
            final float dp5 = density.toPx-0680j_4(Dp.constructor-impl(5));
            final long color = DSColorsKt.get(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable), DSColorsKt.THINKING_FAKE_BAR, $composer3, 48);
            $composer2 = $composer3;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 819482110, "CC(remember):FakeThinking.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(density) | $composer3.changed(offset$delegate) | $composer3.changed(dp16) | $composer3.changed(color) | $composer3.changed(dp5) | $composer3.changed(dp12);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.cards.FakeThinkingKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit FakeThinking$lambda$2$3$0;
                        FakeThinking$lambda$2$3$0 = FakeThinkingKt.FakeThinking$lambda$2$3$0(density, offset$delegate, dp16, color, dp5, dp12, (DrawScope) obj);
                        return FakeThinking$lambda$2$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CanvasKt.Canvas(fillMaxSize$default, (Function1) it$iv2, $composer3, 6);
            ImageKt.Image(ImageResourcesKt.painterResource(isNight ? Drawable0_commonMainKt.getBg_fake_thinking_night(Res.drawable.INSTANCE) : Drawable0_commonMainKt.getBg_fake_thinking(Res.drawable.INSTANCE), $composer3, 0), RoomRecommendViewModel.EMPTY_CURSOR, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 25008, 104);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            maxOffset2 = maxOffset3;
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.cards.FakeThinkingKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FakeThinking$lambda$3;
                    FakeThinking$lambda$3 = FakeThinkingKt.FakeThinking$lambda$3(modifier2, maxOffset2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FakeThinking$lambda$3;
                }
            });
        }
    }

    private static final float FakeThinking$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FakeThinking$lambda$2$3$0(Density $density, State $offset$delegate, float $dp16, long $color, float $dp5, float $dp12, DrawScope $this$Canvas) {
        float left$iv;
        float top$iv;
        boolean z;
        float intBitsToFloat;
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float $this$dp$iv = FakeThinking$lambda$1($offset$delegate);
        float top$iv2 = -$density.toPx-0680j_4(Dp.constructor-impl($this$dp$iv));
        float left$iv2 = 0.0f;
        $this$Canvas.getDrawContext().getTransform().translate(0.0f, top$iv2);
        boolean z2 = false;
        float top = $dp16;
        int i = 0;
        while (i < 6) {
            float top2 = top;
            int i2 = 0;
            while (i2 < 4) {
                int index = i2;
                switch (index) {
                    case 0:
                        z = z2;
                        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
                        intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv);
                        break;
                    case 1:
                        try {
                            z = z2;
                            int bits$iv$iv$iv2 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
                            intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv2) * 0.7f;
                            break;
                        } catch (Throwable th) {
                            th = th;
                            left$iv = left$iv2;
                            top$iv = top$iv2;
                            $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                            throw th;
                        }
                    default:
                        z = z2;
                        try {
                            int bits$iv$iv$iv3 = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
                            intBitsToFloat = Float.intBitsToFloat(bits$iv$iv$iv3) * 0.5f;
                            break;
                        } catch (Throwable th2) {
                            th = th2;
                            left$iv = left$iv2;
                            top$iv = top$iv2;
                            $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                            throw th;
                        }
                }
                float width = intBitsToFloat;
                float y$iv = top2;
                long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                long v1$iv$iv2 = Float.floatToRawIntBits(width);
                long v2$iv$iv2 = Float.floatToRawIntBits($dp5);
                long v1$iv$iv3 = Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L));
                int i3 = i2;
                int i4 = i;
                left$iv = left$iv2;
                top$iv = top$iv2;
                try {
                    DrawScope.-CC.drawRect-n-J9OG0$default($this$Canvas, $color, j2, v1$iv$iv3, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                    top2 += $dp12 + $dp5;
                    i2 = i3 + 1;
                    top$iv2 = top$iv;
                    z2 = z;
                    i = i4;
                    left$iv2 = left$iv;
                } catch (Throwable th3) {
                    th = th3;
                    $this$Canvas.getDrawContext().getTransform().translate(-left$iv, -top$iv);
                    throw th;
                }
            }
            i++;
            top = top2;
        }
        $this$Canvas.getDrawContext().getTransform().translate(-left$iv2, -top$iv2);
        return Unit.INSTANCE;
    }
}