package kntr.common.trio.p000switch;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleSwitch.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aS\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"SimpleSwitch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "size", "Lkntr/common/trio/switch/SimpleSwitchSize;", "colors", "Lkntr/common/trio/switch/SimpleSwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkntr/common/trio/switch/SimpleSwitchSize;Lkntr/common/trio/switch/SimpleSwitchColors;Landroidx/compose/runtime/Composer;II)V", "defaultSimpleSwitchColors", "(Landroidx/compose/runtime/Composer;I)Lkntr/common/trio/switch/SimpleSwitchColors;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
/* renamed from: kntr.common.trio.switch.SimpleSwitchKt  reason: invalid package */
public final class SimpleSwitchKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleSwitch$lambda$3(boolean z, Function1 function1, Modifier modifier, boolean z2, SimpleSwitchSize simpleSwitchSize, SimpleSwitchColors simpleSwitchColors, int i, int i2, Composer composer, int i3) {
        SimpleSwitch(z, function1, modifier, z2, simpleSwitchSize, simpleSwitchColors, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x03ba, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SimpleSwitch(final boolean checked, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean enabled, SimpleSwitchSize size, SimpleSwitchColors colors, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        SimpleSwitchSize simpleSwitchSize;
        SimpleSwitchColors simpleSwitchColors;
        Modifier modifier3;
        boolean enabled2;
        SimpleSwitchSize size2;
        SimpleSwitchColors colors2;
        Modifier modifier4;
        boolean enabled3;
        SimpleSwitchSize size3;
        Modifier modifier5;
        SimpleSwitchSize size4;
        int $dirty;
        Function0 factory$iv$iv$iv;
        int i2;
        int i3;
        Composer $composer2 = $composer.startRestartGroup(1506672791);
        ComposerKt.sourceInformation($composer2, "C(SimpleSwitch)N(checked,onCheckedChange,modifier,enabled,size,colors)42@1527L13:SimpleSwitch.kt#918otk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else if (($changed & 3072) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = enabled;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                simpleSwitchSize = size;
                if ($composer2.changed(simpleSwitchSize)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                simpleSwitchSize = size;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            simpleSwitchSize = size;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                simpleSwitchColors = colors;
                if ($composer2.changed(simpleSwitchColors)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                simpleSwitchColors = colors;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            simpleSwitchColors = colors;
        }
        if ($composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "40@1476L27");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                modifier5 = modifier2;
                enabled2 = z;
                size4 = simpleSwitchSize;
                colors2 = simpleSwitchColors;
                $dirty = $dirty2;
            } else {
                if (i4 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i5 == 0) {
                    enabled3 = z;
                } else {
                    enabled3 = true;
                }
                if ((i & 16) == 0) {
                    size3 = simpleSwitchSize;
                } else {
                    size3 = new SimpleSwitchSize(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                    $dirty2 &= -57345;
                }
                if ((i & 32) == 0) {
                    modifier5 = modifier4;
                    enabled2 = enabled3;
                    size4 = size3;
                    colors2 = simpleSwitchColors;
                    $dirty = $dirty2;
                } else {
                    $dirty = $dirty2 & (-458753);
                    modifier5 = modifier4;
                    enabled2 = enabled3;
                    size4 = size3;
                    colors2 = defaultSimpleSwitchColors($composer2, 0);
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1506672791, $dirty, -1, "kntr.common.trio.switch.SimpleSwitch (SimpleSwitch.kt:41)");
            }
            $composer2.startMovableGroup(508583893, BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable));
            ComposerKt.sourceInformation($composer2, "44@1586L163,50@1793L163,56@2001L141,73@2615L39,76@2776L94,61@2152L1337");
            int $dirty3 = $dirty;
            final SimpleSwitchSize size5 = size4;
            State backgroundColor = SingleValueAnimationKt.animateColorAsState-euL9pac(((Color) colors2.getBackgroundColorTarget().invoke(Boolean.valueOf(enabled2), Boolean.valueOf(checked))).unbox-impl(), (AnimationSpec) null, "switch_background_color", (Function1) null, $composer2, 384, 10);
            final State foregroundColor = SingleValueAnimationKt.animateColorAsState-euL9pac(((Color) colors2.getForegroundColorTarget().invoke(Boolean.valueOf(enabled2), Boolean.valueOf(checked))).unbox-impl(), (AnimationSpec) null, "switch_foreground_color", (Function1) null, $composer2, 384, 10);
            final State offsetPercentage = AnimateAsStateKt.animateFloatAsState(checked ? 1.0f : 0.0f, (AnimationSpec) null, 0.0f, "switch_offset_percentage", (Function1) null, $composer2, 3072, 22);
            Modifier modifier6 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(modifier5, size5.m2452getWidthD9Ej5fM(), size5.m2449getHeightD9Ej5fM()), ((Color) backgroundColor.getValue()).unbox-impl(), RoundedCornerShapeKt.getCircleShape()), size5.m2450getPaddingD9Ej5fM(), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 508617214, "CC(remember):SimpleSwitch.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 508622421, "CC(remember):SimpleSwitch.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 112) == 32) | (($dirty3 & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.common.trio.switch.SimpleSwitchKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit SimpleSwitch$lambda$1$0;
                        SimpleSwitch$lambda$1$0 = SimpleSwitchKt.SimpleSwitch$lambda$1$0(function1, checked);
                        return SimpleSwitch$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource, (Indication) null, enabled2, (String) null, (Role) null, (Function0) it$iv2, 24, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier5;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1844130007, "C84@3053L426,82@2979L500:SimpleSwitch.kt#918otk");
            boolean $changed$iv$iv$iv2 = true;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -1306411760, "CC(remember):SimpleSwitch.kt#9igjgp");
            if ((((57344 & $dirty3) ^ 24576) <= 16384 || !$composer2.changed(size5)) && ($dirty3 & 24576) != 16384) {
                $changed$iv$iv$iv2 = false;
            }
            boolean invalid$iv2 = $composer2.changed(foregroundColor) | $changed$iv$iv$iv2 | $composer2.changed(offsetPercentage);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function1() { // from class: kntr.common.trio.switch.SimpleSwitchKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit SimpleSwitch$lambda$2$0$0;
                    SimpleSwitch$lambda$2$0$0 = SimpleSwitchKt.SimpleSwitch$lambda$2$0$0(SimpleSwitchSize.this, foregroundColor, offsetPercentage, (DrawScope) obj);
                    return SimpleSwitch$lambda$2$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(fillMaxWidth$default, (Function1) it$iv3, $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            size2 = size5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enabled2 = z;
            size2 = simpleSwitchSize;
            colors2 = simpleSwitchColors;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z2 = enabled2;
            final SimpleSwitchSize simpleSwitchSize2 = size2;
            final SimpleSwitchColors simpleSwitchColors2 = colors2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.trio.switch.SimpleSwitchKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleSwitch$lambda$3;
                    SimpleSwitch$lambda$3 = SimpleSwitchKt.SimpleSwitch$lambda$3(checked, function1, modifier7, z2, simpleSwitchSize2, simpleSwitchColors2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleSwitch$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleSwitch$lambda$1$0(Function1 $onCheckedChange, boolean $checked) {
        if ($onCheckedChange != null) {
            $onCheckedChange.invoke(Boolean.valueOf(!$checked));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleSwitch$lambda$2$0$0(SimpleSwitchSize $size, State $foregroundColor, State $offsetPercentage, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float f = 2;
        float radius = $this$Canvas.toPx-0680j_4($size.m2451getThumbSizeD9Ej5fM()) / f;
        long j = ((Color) $foregroundColor.getValue()).unbox-impl();
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float x$iv = ((Float.intBitsToFloat(bits$iv$iv$iv) - (f * radius)) * ((Number) $offsetPercentage.getValue()).floatValue()) + radius;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j, radius, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
        return Unit.INSTANCE;
    }

    public static final SimpleSwitchColors defaultSimpleSwitchColors(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -711709929, "C(defaultSimpleSwitchColors)143@4967L6,144@5027L6,145@5090L6,146@5151L6:SimpleSwitch.kt#918otk");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-711709929, $changed, -1, "kntr.common.trio.switch.defaultSimpleSwitchColors (SimpleSwitch.kt:142)");
        }
        SimpleSwitchColors simpleSwitchColors = new SimpleSwitchColors(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), 0L, 0L, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_white-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_white-0d7_KjU(), 0L, 0L, null, null, 972, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return simpleSwitchColors;
    }
}