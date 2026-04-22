package kntr.common.bilitheme.compose.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeBottomsheet.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0084\u0001\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\u001c\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0018\u001aK\u0010\u0019\u001a\u00020\u00012\u000e\b\b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\u001e\b\u0004\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#²\u0006\n\u0010$\u001a\u00020\tX\u008a\u008e\u0002"}, d2 = {"BottomSheetContainer", "", "onDismiss", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "onExpand", "containerColor", "Landroidx/compose/ui/graphics/Color;", "skipPartiallyExpanded", "", "enableSafeBottomPadding", "showDragHandle", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheetContainer-lVb_Clg", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JZZZLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScope", "sheetState", "Landroidx/compose/material3/SheetState;", "(Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", "BottomSheetColumnContainer", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetColumnItem", "title", "", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "(Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "compose-bottomsheet_debug", "showBottomSheet"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeBottomsheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetColumnItem$lambda$2(String str, Painter painter, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BottomSheetColumnItem(str, painter, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_lVb_Clg$lambda$7(Function0 function0, Function0 function02, long j, boolean z, boolean z2, boolean z3, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m1831BottomSheetContainerlVb_Clg(function0, function02, j, z, z2, z3, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:130:0x0226, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /* renamed from: BottomSheetContainer-lVb_Clg  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1831BottomSheetContainerlVb_Clg(final Function0<Unit> function0, Function0<Unit> function02, long j, boolean skipPartiallyExpanded, boolean enableSafeBottomPadding, boolean showDragHandle, PaddingValues contentPadding, final Function3<? super BottomSheetScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Function0<Unit> function03;
        long j2;
        boolean skipPartiallyExpanded2;
        boolean enableSafeBottomPadding2;
        boolean showDragHandle2;
        PaddingValues contentPadding2;
        Function0<Unit> function04;
        boolean skipPartiallyExpanded3;
        boolean enableSafeBottomPadding3;
        long j3;
        PaddingValues contentPadding3;
        int $dirty;
        boolean enableSafeBottomPadding4;
        boolean showDragHandle3;
        Function0<Unit> function05;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1663529574);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetContainer)N(onDismiss,onExpand,containerColor:c#ui.graphics.Color,skipPartiallyExpanded,enableSafeBottomPadding,showDragHandle,contentPadding,content)59@2680L45,63@2767L99,68@2939L110,68@2899L150:ComposeBottomsheet.kt#18ljev");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            function03 = function02;
        } else if (($changed & 48) == 0) {
            function03 = function02;
            $dirty2 |= $composer2.changedInstance(function03) ? 32 : 16;
        } else {
            function03 = function02;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i3 = 256;
                    $dirty2 |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = 128;
            $dirty2 |= i3;
        } else {
            j2 = j;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            skipPartiallyExpanded2 = skipPartiallyExpanded;
        } else if (($changed & 3072) == 0) {
            skipPartiallyExpanded2 = skipPartiallyExpanded;
            $dirty2 |= $composer2.changed(skipPartiallyExpanded2) ? 2048 : 1024;
        } else {
            skipPartiallyExpanded2 = skipPartiallyExpanded;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            enableSafeBottomPadding2 = enableSafeBottomPadding;
        } else if (($changed & 24576) == 0) {
            enableSafeBottomPadding2 = enableSafeBottomPadding;
            $dirty2 |= $composer2.changed(enableSafeBottomPadding2) ? 16384 : 8192;
        } else {
            enableSafeBottomPadding2 = enableSafeBottomPadding;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changed(showDragHandle) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0 && $composer2.changed(contentPadding)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "52@2344L6");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i4 != 0) {
                    function03 = null;
                }
                if ((i & 4) != 0) {
                    j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU();
                    $dirty2 &= -897;
                }
                if (i5 != 0) {
                    skipPartiallyExpanded2 = false;
                }
                if (i6 != 0) {
                    enableSafeBottomPadding2 = true;
                }
                boolean showDragHandle4 = i7 != 0 ? true : showDragHandle;
                if ((i & 64) != 0) {
                    boolean showDragHandle5 = showDragHandle4;
                    contentPadding3 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(19), Dp.constructor-impl(16), Dp.constructor-impl(16));
                    $dirty = $dirty2 & (-3670017);
                    enableSafeBottomPadding4 = enableSafeBottomPadding2;
                    showDragHandle3 = showDragHandle5;
                } else {
                    boolean showDragHandle6 = showDragHandle4;
                    contentPadding3 = contentPadding;
                    $dirty = $dirty2;
                    enableSafeBottomPadding4 = enableSafeBottomPadding2;
                    showDragHandle3 = showDragHandle6;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 64) != 0) {
                    int i8 = $dirty2 & (-3670017);
                    showDragHandle3 = showDragHandle;
                    contentPadding3 = contentPadding;
                    $dirty = i8;
                    enableSafeBottomPadding4 = enableSafeBottomPadding2;
                } else {
                    contentPadding3 = contentPadding;
                    $dirty = $dirty2;
                    enableSafeBottomPadding4 = enableSafeBottomPadding2;
                    showDragHandle3 = showDragHandle;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1663529574, $dirty, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetContainer (ComposeBottomsheet.kt:58)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 924102163, "CC(remember):ComposeBottomsheet.kt#9igjgp");
            Object value$iv = $composer2.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
            }
            final MutableState showBottomSheet$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(skipPartiallyExpanded2, (Function1) null, $composer2, ($dirty >> 9) & 14, 2);
            SheetValue currentValue = sheetState.getCurrentValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 924110516, "CC(remember):ComposeBottomsheet.kt#9igjgp");
            skipPartiallyExpanded3 = skipPartiallyExpanded2;
            boolean invalid$iv = (($dirty & 112) == 32) | $composer2.changed(sheetState);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = (Function2) new ComposeBottomsheetKt$BottomSheetContainer$1$1(sheetState, function03, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(currentValue, (Function2) it$iv, $composer2, 0);
            if (BottomSheetContainer_lVb_Clg$lambda$1(showBottomSheet$delegate)) {
                $composer2.startReplaceGroup(-1417138986);
                ComposerKt.sourceInformation($composer2, "78@3188L156,90@3589L1551,75@3086L2054");
                ComposerKt.sourceInformationMarkerStart($composer2, 924118530, "CC(remember):ComposeBottomsheet.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                function05 = function03;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit BottomSheetContainer_lVb_Clg$lambda$4$0;
                            BottomSheetContainer_lVb_Clg$lambda$4$0 = ComposeBottomsheetKt.BottomSheetContainer_lVb_Clg$lambda$4$0(function0, showBottomSheet$delegate);
                            return BottomSheetContainer_lVb_Clg$lambda$4$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final boolean z = showDragHandle3;
                final PaddingValues paddingValues = contentPadding3;
                final boolean z2 = enableSafeBottomPadding4;
                ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv2, (Modifier) null, sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null), j2, 0L, 0.0f, 0L, (Function2) null, new Function2() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        WindowInsets BottomSheetContainer_lVb_Clg$lambda$5;
                        BottomSheetContainer_lVb_Clg$lambda$5 = ComposeBottomsheetKt.BottomSheetContainer_lVb_Clg$lambda$5((Composer) obj, ((Integer) obj2).intValue());
                        return BottomSheetContainer_lVb_Clg$lambda$5;
                    }
                }, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-126586419, true, new Function3() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit BottomSheetContainer_lVb_Clg$lambda$6;
                        BottomSheetContainer_lVb_Clg$lambda$6 = ComposeBottomsheetKt.BottomSheetContainer_lVb_Clg$lambda$6(z, paddingValues, z2, sheetState, function0, function3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return BottomSheetContainer_lVb_Clg$lambda$6;
                    }
                }, $composer2, 54), $composer2, (($dirty << 12) & 3670016) | 6, 3078, 5018);
            } else {
                function05 = function03;
                $composer2.startReplaceGroup(-1420264964);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function04 = function05;
            enableSafeBottomPadding3 = enableSafeBottomPadding4;
            showDragHandle2 = showDragHandle3;
            contentPadding2 = contentPadding3;
            j3 = j2;
        } else {
            $composer2.skipToGroupEnd();
            showDragHandle2 = showDragHandle;
            contentPadding2 = contentPadding;
            function04 = function03;
            skipPartiallyExpanded3 = skipPartiallyExpanded2;
            enableSafeBottomPadding3 = enableSafeBottomPadding2;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function0<Unit> function06 = function04;
            final long j4 = j3;
            final boolean z3 = skipPartiallyExpanded3;
            final boolean z4 = enableSafeBottomPadding3;
            final boolean z5 = showDragHandle2;
            final PaddingValues paddingValues2 = contentPadding2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetContainer_lVb_Clg$lambda$7;
                    BottomSheetContainer_lVb_Clg$lambda$7 = ComposeBottomsheetKt.BottomSheetContainer_lVb_Clg$lambda$7(function0, function06, j4, z3, z4, z5, paddingValues2, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetContainer_lVb_Clg$lambda$7;
                }
            });
        }
    }

    private static final boolean BottomSheetContainer_lVb_Clg$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void BottomSheetContainer_lVb_Clg$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_lVb_Clg$lambda$4$0(Function0 $onDismiss, MutableState $showBottomSheet$delegate) {
        BottomSheetContainer_lVb_Clg$lambda$2($showBottomSheet$delegate, false);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets BottomSheetContainer_lVb_Clg$lambda$5(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1333840513);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1333840513, $changed, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetContainer.<anonymous> (ComposeBottomsheet.kt:88)");
        }
        WindowInsets WindowInsets$default = WindowInsetsKt.WindowInsets$default(0, 0, 0, 0, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return WindowInsets$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_lVb_Clg$lambda$6(final boolean $showDragHandle, PaddingValues $contentPadding, boolean $enableSafeBottomPadding, SheetState $sheetState, Function0 $onDismiss, Function3 $content, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Modifier modifier$iv;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C91@3631L6,95@3777L679,92@3675L1455:ComposeBottomsheet.kt#18ljev");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126586419, $changed, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetContainer.<anonymous> (ComposeBottomsheet.kt:91)");
            }
            final long handleColor = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            $composer.startReplaceGroup(-1390434554);
            ComposerKt.sourceInformation($composer, "");
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1390457676, "CC(remember):ComposeBottomsheet.kt#9igjgp");
            boolean invalid$iv = $composer.changed($showDragHandle) | $composer.changed(handleColor);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit BottomSheetContainer_lVb_Clg$lambda$6$0$0;
                        BottomSheetContainer_lVb_Clg$lambda$6$0$0 = ComposeBottomsheetKt.BottomSheetContainer_lVb_Clg$lambda$6$0$0($showDragHandle, handleColor, (ContentDrawScope) obj);
                        return BottomSheetContainer_lVb_Clg$lambda$6$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier $this$BottomSheetContainer_lVb_Clg_u24lambda_u246_u241 = PaddingKt.padding(DrawModifierKt.drawWithContent(modifier, (Function1) it$iv), $contentPadding);
            if ($enableSafeBottomPadding) {
                $composer.startReplaceGroup(491614052);
                ComposerKt.sourceInformation($composer, "111@4671L12,113@4797L17");
                modifier$iv = PaddingKt.padding($this$BottomSheetContainer_lVb_Clg_u24lambda_u246_u241, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0));
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(491920022);
                $composer.endReplaceGroup();
                modifier$iv = $this$BottomSheetContainer_lVb_Clg_u24lambda_u246_u241;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            Modifier modifier$iv$iv = modifier$iv;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1134020105, "C120@5018L47:ComposeBottomsheet.kt#18ljev");
            $composer.startReplaceGroup(452223290);
            ComposerKt.sourceInformation($composer, "*121@5089L9");
            BottomSheetScope $this$BottomSheetContainer_lVb_Clg_u24lambda_u246_u242_u240 = rememberBottomSheetScope($sheetState, $onDismiss, $composer, 0);
            $content.invoke($this$BottomSheetContainer_lVb_Clg_u24lambda_u246_u242_u240, $composer, 0);
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContainer_lVb_Clg$lambda$6$0$0(boolean $showDragHandle, long $handleColor, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if ($showDragHandle) {
            float width$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(30));
            float height$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(3));
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            long handleSize = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            long topLeft = Offset.minus-MK-Hz9U(SizeKt.getCenter-uvyYCjk(Size.copy-xjbvk4A$default($this$drawWithContent.getSize-NH-jbRc(), 0.0f, $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(19)), 1, (Object) null)), SizeKt.getCenter-uvyYCjk(handleSize));
            float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 1.5d));
            float y$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 1.5d));
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
            DrawScope.-CC.drawRoundRect-u-Aw5IA$default((DrawScope) $this$drawWithContent, $handleColor, topLeft, handleSize, CornerRadius.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), (DrawStyle) null, 0.0f, (ColorFilter) null, 0, 240, (Object) null);
        }
        return Unit.INSTANCE;
    }

    public static final BottomSheetScope rememberBottomSheetScope(SheetState sheetState, Function0<Unit> function0, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(sheetState, "sheetState");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        ComposerKt.sourceInformationMarkerStart($composer, 2070660844, "C(rememberBottomSheetScope)N(sheetState,onDismiss)139@5379L194:ComposeBottomsheet.kt#18ljev");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2070660844, $changed, -1, "kntr.common.bilitheme.compose.bottomsheet.rememberBottomSheetScope (ComposeBottomsheet.kt:139)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1335216782, "CC(remember):ComposeBottomsheet.kt#9igjgp");
        boolean invalid$iv = ((($changed & 112) ^ 48) > 32 && $composer.changed(function0)) || ($changed & 48) == 32;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new ComposeBottomsheetKt$rememberBottomSheetScope$1$1(sheetState, function0);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposeBottomsheetKt$rememberBottomSheetScope$1$1 composeBottomsheetKt$rememberBottomSheetScope$1$1 = (ComposeBottomsheetKt$rememberBottomSheetScope$1$1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return composeBottomsheetKt$rememberBottomSheetScope$1$1;
    }

    public static final void BottomSheetColumnContainer(Function0<Unit> function0, Modifier modifier, final Function3<? super BottomSheetScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, int $changed, int i) {
        final Modifier modifier2;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "content");
        ComposerKt.sourceInformationMarkerStart($composer, -1330546869, "CC(BottomSheetColumnContainer)N(onDismiss,modifier,content)154@5815L207,154@5771L251:ComposeBottomsheet.kt#18ljev");
        if ((i & 2) != 0) {
            modifier2 = (Modifier) Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        m1831BottomSheetContainerlVb_Clg(function0, null, 0L, false, false, false, null, ComposableLambdaKt.rememberComposableLambda(1454232538, true, new Function3<BottomSheetScope, Composer, Integer, Unit>() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$BottomSheetColumnContainer$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                invoke((BottomSheetScope) p1, (Composer) p2, ((Number) p3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BottomSheetScope $this$BottomSheetContainer, Composer $composer2, int $changed2) {
                Function0 factory$iv$iv$iv;
                Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
                ComposerKt.sourceInformation($composer2, "C155@5825L191:ComposeBottomsheet.kt#18ljev");
                int $dirty = $changed2;
                if (($changed2 & 6) == 0) {
                    $dirty |= $composer2.changed($this$BottomSheetContainer) ? 4 : 2;
                }
                if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                    $composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1454232538, $dirty, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetColumnContainer.<anonymous> (ComposeBottomsheet.kt:155)");
                }
                Modifier modifier$iv = ClipKt.clip(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                Function3<BottomSheetScope, Composer, Integer, Unit> function32 = function3;
                ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i3 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 639823158, "C160@5994L9:ComposeBottomsheet.kt#18ljev");
                function32.invoke($this$BottomSheetContainer, $composer2, Integer.valueOf($dirty & 14));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, $composer, 54), $composer, ($changed & 14) | 12582912, 126);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final void BottomSheetColumnItem(final String title, final Painter icon, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer3;
        Composer $composer$iv$iv;
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer4 = $composer.startRestartGroup(31595639);
        ComposerKt.sourceInformation($composer4, "C(BottomSheetColumnItem)N(title,icon,modifier)171@6176L6,177@6341L268,181@6639L6,172@6200L1077:ComposeBottomsheet.kt#18ljev");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer4.changed(icon) : $composer4.changedInstance(icon) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(31595639, $dirty2, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetColumnItem (ComposeBottomsheet.kt:170)");
            }
            final long dividerColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU();
            Modifier modifier5 = androidx.compose.foundation.layout.SizeKt.height-3ABfNKs(androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(52));
            ComposerKt.sourceInformationMarkerStart($composer4, 298647971, "CC(remember):ComposeBottomsheet.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(dividerColor);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit BottomSheetColumnItem$lambda$0$0;
                        BottomSheetColumnItem$lambda$0$0 = ComposeBottomsheetKt.BottomSheetColumnItem$lambda$0$0(dividerColor, (ContentDrawScope) obj);
                        return BottomSheetColumnItem$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(DrawModifierKt.drawWithContent(modifier5, (Function1) it$iv), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1122406573, "C196@7131L9,197@7176L6,194@7069L202:ComposeBottomsheet.kt#18ljev");
            if (icon != null) {
                $composer4.startReplaceGroup(1122430473);
                ComposerKt.sourceInformation($composer4, "189@6931L6,187@6860L190");
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer$iv$iv = $composer4;
                IconKt.Icon-ww6aTOc(icon, (String) null, androidx.compose.foundation.layout.SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), $composer3, Painter.$stable | 432 | (($dirty2 >> 3) & 14), 0);
            } else {
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer$iv$iv = $composer4;
                $composer3.startReplaceGroup(1115618471);
            }
            $composer3.endReplaceGroup();
            modifier3 = modifier4;
            $composer2 = $composer4;
            Composer $composer5 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer5, $dirty2 & 14, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetColumnItem$lambda$2;
                    BottomSheetColumnItem$lambda$2 = ComposeBottomsheetKt.BottomSheetColumnItem$lambda$2(title, icon, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetColumnItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetColumnItem$lambda$0$0(long $dividerColor, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        float x$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(44));
        int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long offset = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
        float width$iv = Float.intBitsToFloat(bits$iv$iv$iv2) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(44));
        float height$iv = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 0.5d));
        long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv2 = Float.floatToRawIntBits(height$iv);
        DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, $dividerColor, offset, Size.constructor-impl((v1$iv$iv2 << 32) | (4294967295L & v2$iv$iv2)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
        return Unit.INSTANCE;
    }
}