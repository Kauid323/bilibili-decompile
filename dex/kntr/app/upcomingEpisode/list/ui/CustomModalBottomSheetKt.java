package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.utils.DefaultBottomSheetProperties;
import kntr.app.upcomingEpisode.list.utils.DefaultDragHandleProperties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomModalBottomSheet.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001e\b\u0002\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"CustomModalBottomSheet", "", "modifier", "Landroidx/compose/ui/Modifier;", "onDismissRequest", "Lkotlin/Function0;", "sheetState", "Landroidx/compose/material3/SheetState;", "dragHandleProperties", "Lkntr/app/upcomingEpisode/list/utils/DefaultDragHandleProperties;", "modalBottomSheetProperties", "Lkntr/app/upcomingEpisode/list/utils/DefaultBottomSheetProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;Lkntr/app/upcomingEpisode/list/utils/DefaultDragHandleProperties;Lkntr/app/upcomingEpisode/list/utils/DefaultBottomSheetProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CustomModalBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomModalBottomSheet$lambda$3(Modifier modifier, Function0 function0, SheetState sheetState, DefaultDragHandleProperties defaultDragHandleProperties, DefaultBottomSheetProperties defaultBottomSheetProperties, Function3 function3, int i, int i2, Composer composer, int i3) {
        CustomModalBottomSheet(modifier, function0, sheetState, defaultDragHandleProperties, defaultBottomSheetProperties, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CustomModalBottomSheet(Modifier modifier, Function0<Unit> function0, SheetState sheetState, DefaultDragHandleProperties dragHandleProperties, DefaultBottomSheetProperties modalBottomSheetProperties, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        SheetState sheetState2;
        final DefaultDragHandleProperties dragHandleProperties2;
        DefaultBottomSheetProperties modalBottomSheetProperties2;
        Function3 function32;
        Function0 onDismissRequest;
        DefaultDragHandleProperties dragHandleProperties3;
        DefaultBottomSheetProperties modalBottomSheetProperties3;
        Function3 content;
        Modifier modifier3;
        SheetState sheetState3;
        Modifier modifier4;
        Function0 onDismissRequest2;
        SheetState sheetState4;
        int $dirty;
        DefaultBottomSheetProperties modalBottomSheetProperties4;
        final Function3 content2;
        int i2;
        int i3;
        int i4;
        Composer $composer2 = $composer.startRestartGroup(-221379382);
        ComposerKt.sourceInformation($composer2, "C(CustomModalBottomSheet)N(modifier,onDismissRequest,sheetState,dragHandleProperties,modalBottomSheetProperties,content)44@1984L9,31@1389L541,47@2080L25,28@1272L833:CustomModalBottomSheet.kt#kr57tx");
        int $dirty2 = $changed;
        int i5 = i & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty2 |= 48;
            function02 = function0;
        } else if (($changed & 48) == 0) {
            function02 = function0;
            $dirty2 |= $composer2.changedInstance(function02) ? 32 : 16;
        } else {
            function02 = function0;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetState2 = sheetState;
                if ($composer2.changed(sheetState2)) {
                    i4 = 256;
                    $dirty2 |= i4;
                }
            } else {
                sheetState2 = sheetState;
            }
            i4 = 128;
            $dirty2 |= i4;
        } else {
            sheetState2 = sheetState;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                dragHandleProperties2 = dragHandleProperties;
                if ($composer2.changedInstance(dragHandleProperties2)) {
                    i3 = 2048;
                    $dirty2 |= i3;
                }
            } else {
                dragHandleProperties2 = dragHandleProperties;
            }
            i3 = 1024;
            $dirty2 |= i3;
        } else {
            dragHandleProperties2 = dragHandleProperties;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                modalBottomSheetProperties2 = modalBottomSheetProperties;
                if ($composer2.changedInstance(modalBottomSheetProperties2)) {
                    i2 = 16384;
                    $dirty2 |= i2;
                }
            } else {
                modalBottomSheetProperties2 = modalBottomSheetProperties;
            }
            i2 = 8192;
            $dirty2 |= i2;
        } else {
            modalBottomSheetProperties2 = modalBottomSheetProperties;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
            function32 = function3;
        } else if ((196608 & $changed) == 0) {
            function32 = function3;
            $dirty2 |= $composer2.changedInstance(function32) ? 131072 : 65536;
        } else {
            function32 = function3;
        }
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "22@962L2,23@995L31");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier4 = i5 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart($composer2, 2002781836, "CC(remember):CustomModalBottomSheet.kt#9igjgp");
                    Object it$iv = $composer2.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheetKt$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    onDismissRequest2 = (Function0) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    onDismissRequest2 = function02;
                }
                if ((i & 4) != 0) {
                    sheetState4 = ModalBottomSheetKt.rememberModalBottomSheetState(false, (Function1) null, $composer2, 0, 3);
                    $dirty2 &= -897;
                } else {
                    sheetState4 = sheetState2;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    dragHandleProperties2 = new DefaultDragHandleProperties(0, 0, 0, 0, null, null, 63, null);
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                    modalBottomSheetProperties2 = new DefaultBottomSheetProperties(null, null, 0L, 7, null);
                }
                if (i7 != 0) {
                    content2 = ComposableSingletons$CustomModalBottomSheetKt.INSTANCE.getLambda$1366023213$main_debug();
                    $dirty = $dirty2;
                    modalBottomSheetProperties4 = modalBottomSheetProperties2;
                } else {
                    $dirty = $dirty2;
                    modalBottomSheetProperties4 = modalBottomSheetProperties2;
                    content2 = function32;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty2 &= -57345;
                }
                modifier4 = modifier2;
                onDismissRequest2 = function02;
                sheetState4 = sheetState2;
                content2 = function32;
                $dirty = $dirty2;
                modalBottomSheetProperties4 = modalBottomSheetProperties2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-221379382, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheet (CustomModalBottomSheet.kt:27)");
            }
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(onDismissRequest2, modifier4, sheetState4, 0.0f, false, modalBottomSheetProperties4.getShape(), ((Color) modalBottomSheetProperties4.getBgColor().invoke($composer2, 0)).unbox-impl(), 0L, 0.0f, 0L, ComposableLambdaKt.rememberComposableLambda(1364543423, true, new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomModalBottomSheet$lambda$1;
                    CustomModalBottomSheet$lambda$1 = CustomModalBottomSheetKt.CustomModalBottomSheet$lambda$1(DefaultDragHandleProperties.this, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomModalBottomSheet$lambda$1;
                }
            }, $composer2, 54), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-1669883604, true, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CustomModalBottomSheet$lambda$2;
                    CustomModalBottomSheet$lambda$2 = CustomModalBottomSheetKt.CustomModalBottomSheet$lambda$2(content2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CustomModalBottomSheet$lambda$2;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | (($dirty << 3) & 112) | ($dirty & 896), 3078, 7064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onDismissRequest = onDismissRequest2;
            modalBottomSheetProperties3 = modalBottomSheetProperties4;
            modifier3 = modifier4;
            sheetState3 = sheetState4;
            content = content2;
            dragHandleProperties3 = dragHandleProperties2;
        } else {
            $composer2.skipToGroupEnd();
            onDismissRequest = function02;
            dragHandleProperties3 = dragHandleProperties2;
            modalBottomSheetProperties3 = modalBottomSheetProperties2;
            content = function32;
            modifier3 = modifier2;
            sheetState3 = sheetState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onDismissRequest;
            final SheetState sheetState5 = sheetState3;
            final DefaultDragHandleProperties defaultDragHandleProperties = dragHandleProperties3;
            final DefaultBottomSheetProperties defaultBottomSheetProperties = modalBottomSheetProperties3;
            final Function3 function33 = content;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomModalBottomSheet$lambda$3;
                    CustomModalBottomSheet$lambda$3 = CustomModalBottomSheetKt.CustomModalBottomSheet$lambda$3(modifier5, function03, sheetState5, defaultDragHandleProperties, defaultBottomSheetProperties, function33, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomModalBottomSheet$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomModalBottomSheet$lambda$1(DefaultDragHandleProperties $dragHandleProperties, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C39@1807L7,32@1403L517:CustomModalBottomSheet.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1364543423, $changed, -1, "kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheet.<anonymous> (CustomModalBottomSheet.kt:32)");
            }
            Modifier modifier = Modifier.Companion;
            int $this$dp$iv = $dragHandleProperties.getPaddingTop();
            float f = Dp.constructor-impl($this$dp$iv);
            int $this$dp$iv2 = $dragHandleProperties.getPaddingBottom();
            Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(modifier, 0.0f, f, 0.0f, Dp.constructor-impl($this$dp$iv2), 5, (Object) null);
            int $this$dp$iv3 = $dragHandleProperties.getWidth();
            Modifier modifier3 = SizeKt.width-3ABfNKs(modifier2, Dp.constructor-impl($this$dp$iv3));
            int $this$dp$iv4 = $dragHandleProperties.getHeight();
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier3, Dp.constructor-impl($this$dp$iv4)), ((Color) $dragHandleProperties.getColor().invoke($composer, 0)).unbox-impl(), $dragHandleProperties.getShape()), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomModalBottomSheet$lambda$2(Function3 $content, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C48@2090L9:CustomModalBottomSheet.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$ModalBottomSheet) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1669883604, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.CustomModalBottomSheet.<anonymous> (CustomModalBottomSheet.kt:48)");
            }
            $content.invoke($this$ModalBottomSheet, $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}