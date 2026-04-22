package kntr.app.tribee.consume.widget;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.config.FlowControlConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FlexibleScrollableTabRow.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2.\b\u0002\u0010\f\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u00132\u0013\b\u0002\u0010\u0014\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u00132\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0013H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u001f\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"FlexibleScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "Landroidx/compose/ui/unit/Dp;", "minTabWidth", "indicator", "Lkotlin/Function1;", "", "Lkntr/app/tribee/consume/widget/TabPosition;", "Lkotlin/ParameterName;", "name", "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "FlexibleScrollableTabRow-xam5sdo", "(ILandroidx/compose/ui/Modifier;JJFFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "TabRowIndicatorSpec", "consume_debug", "currentTabWidth", "indicatorOffset"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FlexibleScrollableTabRowKt {
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);
    private static final AnimationSpec<Dp> TabRowIndicatorSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleScrollableTabRow_xam5sdo$lambda$2(int i, Modifier modifier, long j, long j2, float f, float f2, Function3 function3, Function2 function2, Function2 function22, int i2, int i3, Composer composer, int i4) {
        m784FlexibleScrollableTabRowxam5sdo(i, modifier, j, j2, f, f2, function3, function2, function22, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleScrollableTabRow_xam5sdo$lambda$0(int $selectedTabIndex, List tabPositions, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(tabPositions, "tabPositions");
        ComposerKt.sourceInformation($composer, "CN(tabPositions)91@4267L6,55@2389L1945:FlexibleScrollableTabRow.kt#vkdvar");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1428589920, $changed, -1, "kntr.app.tribee.consume.widget.FlexibleScrollableTabRow.<anonymous> (FlexibleScrollableTabRow.kt:54)");
        }
        final TabPosition currentTabPosition = (TabPosition) tabPositions.get($selectedTabIndex);
        SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(ComposedModifierKt.composed(Modifier.Companion, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$FlexibleScrollableTabRow_xam5sdo$lambda$0$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((InspectorInfo) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(TabPosition.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier FlexibleScrollableTabRow_xam5sdo$lambda$0$1;
                FlexibleScrollableTabRow_xam5sdo$lambda$0$1 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$0$1(TabPosition.this, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return FlexibleScrollableTabRow_xam5sdo$lambda$0$1;
            }
        }), 0.0f, 1, (Object) null), Dp.constructor-impl(2)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final float FlexibleScrollableTabRow_xam5sdo$lambda$0$1$0(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier FlexibleScrollableTabRow_xam5sdo$lambda$0$1(TabPosition $currentTabPosition, Modifier $this$composed, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(929966343);
        ComposerKt.sourceInformation($composer, "C66@2858L390,75@3332L536,87@4024L53:FlexibleScrollableTabRow.kt#vkdvar");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(929966343, $changed, -1, "kntr.app.tribee.consume.widget.FlexibleScrollableTabRow.<anonymous>.<anonymous> (FlexibleScrollableTabRow.kt:65)");
        }
        State currentTabWidth$delegate = AnimateAsStateKt.animateDpAsState-AjpBEmI(Dp.constructor-impl(14), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (String) null, (Function1) null, $composer, 6, 12);
        final State indicatorOffset$delegate = AnimateAsStateKt.animateDpAsState-AjpBEmI(Dp.constructor-impl($currentTabPosition.m786getLeftD9Ej5fM() + Dp.constructor-impl(Dp.constructor-impl($currentTabPosition.m788getWidthD9Ej5fM() - Dp.constructor-impl(14)) / 2)), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, (Object) null), (String) null, (Function1) null, $composer, 0, 12);
        Modifier wrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default($this$composed, 0.0f, 1, (Object) null), Alignment.Companion.getBottomStart(), false, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 344498140, "CC(remember):FlexibleScrollableTabRow.kt#9igjgp");
        boolean invalid$iv = $composer.changed(indicatorOffset$delegate);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    IntOffset FlexibleScrollableTabRow_xam5sdo$lambda$0$1$2$0;
                    FlexibleScrollableTabRow_xam5sdo$lambda$0$1$2$0 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$0$1$2$0(indicatorOffset$delegate, (Density) obj);
                    return FlexibleScrollableTabRow_xam5sdo$lambda$0$1$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier = SizeKt.width-3ABfNKs(OffsetKt.offset(wrapContentSize$default, (Function1) it$iv), FlexibleScrollableTabRow_xam5sdo$lambda$0$1$0(currentTabWidth$delegate));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return modifier;
    }

    private static final float FlexibleScrollableTabRow_xam5sdo$lambda$0$1$1(State<Dp> state) {
        Object thisObj$iv = state.getValue();
        return ((Dp) thisObj$iv).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset FlexibleScrollableTabRow_xam5sdo$lambda$0$1$2$0(State $indicatorOffset$delegate, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int x$iv = $this$offset.roundToPx-0680j_4(FlexibleScrollableTabRow_xam5sdo$lambda$0$1$1($indicatorOffset$delegate));
        return IntOffset.box-impl(IntOffset.constructor-impl((x$iv << 32) | (0 & 4294967295L)));
    }

    /* renamed from: FlexibleScrollableTabRow-xam5sdo  reason: not valid java name */
    public static final void m784FlexibleScrollableTabRowxam5sdo(final int selectedTabIndex, Modifier modifier, long j, long j2, float f, float f2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer $composer, final int $changed, final int i) {
        long j3;
        float f3;
        Modifier modifier2;
        long j4;
        float f4;
        Function3 indicator;
        Function2 divider;
        long j5;
        float f5;
        Modifier modifier3;
        long j6;
        long j7;
        float f6;
        float f7;
        int $dirty;
        Modifier modifier4;
        Function3 indicator2;
        int $dirty2;
        Function2 divider2;
        Modifier modifier5;
        int i2;
        Intrinsics.checkNotNullParameter(function22, "tabs");
        Composer $composer2 = $composer.startRestartGroup(-930209339);
        ComposerKt.sourceInformation($composer2, "C(FlexibleScrollableTabRow)N(selectedTabIndex,modifier,containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,edgePadding:c#ui.unit.Dp,minTabWidth:c#ui.unit.Dp,indicator,divider,tabs)97@4461L21,98@4569L3783,98@4487L3865:FlexibleScrollableTabRow.kt#vkdvar");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(selectedTabIndex) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer2.changed(modifier) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0 && $composer2.changed(j)) {
                i2 = 256;
                $dirty3 |= i2;
            }
            i2 = 128;
            $dirty3 |= i2;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
            j3 = j2;
        } else if (($changed & 3072) == 0) {
            j3 = j2;
            $dirty3 |= $composer2.changed(j3) ? 2048 : 1024;
        } else {
            j3 = j2;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
            f3 = f;
        } else if (($changed & 24576) == 0) {
            f3 = f;
            $dirty3 |= $composer2.changed(f3) ? 16384 : 8192;
        } else {
            f3 = f;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty3 |= $composer2.changed(f2) ? 131072 : 65536;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty3 |= $composer2.changedInstance(function22) ? 67108864 : 33554432;
        }
        if ($composer2.shouldExecute(($dirty3 & 38347923) != 38347922, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "48@2085L6,53@2291L2053");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    int i9 = $dirty3 & (-897);
                    j6 = j;
                    indicator2 = function3;
                    divider2 = function2;
                    $dirty2 = i9;
                    j7 = j3;
                    f6 = f3;
                    modifier5 = modifier;
                    f7 = f2;
                } else {
                    modifier5 = modifier;
                    j6 = j;
                    divider2 = function2;
                    $dirty2 = $dirty3;
                    j7 = j3;
                    f6 = f3;
                    f7 = f2;
                    indicator2 = function3;
                }
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if ((i & 4) == 0) {
                    j6 = j;
                } else {
                    j6 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
                    $dirty3 &= -897;
                }
                if (i4 == 0) {
                    j7 = j3;
                } else {
                    j7 = Color.Companion.getTransparent-0d7_KjU();
                }
                if (i5 == 0) {
                    f6 = f3;
                } else {
                    f6 = Dp.constructor-impl(12);
                }
                if (i6 == 0) {
                    f7 = f2;
                } else {
                    f7 = Dp.constructor-impl(28);
                }
                if (i7 != 0) {
                    $dirty = $dirty3;
                    modifier4 = modifier3;
                    indicator2 = (Function3) ComposableLambdaKt.rememberComposableLambda(-1428589920, true, new Function3() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit FlexibleScrollableTabRow_xam5sdo$lambda$0;
                            FlexibleScrollableTabRow_xam5sdo$lambda$0 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$0(selectedTabIndex, (List) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return FlexibleScrollableTabRow_xam5sdo$lambda$0;
                        }
                    }, $composer2, 54);
                } else {
                    $dirty = $dirty3;
                    modifier4 = modifier3;
                    indicator2 = function3;
                }
                if (i8 != 0) {
                    $dirty2 = $dirty;
                    divider2 = ComposableSingletons$FlexibleScrollableTabRowKt.INSTANCE.getLambda$851289432$consume_debug();
                    modifier5 = modifier4;
                } else {
                    $dirty2 = $dirty;
                    divider2 = function2;
                    modifier5 = modifier4;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-930209339, $dirty2, -1, "kntr.app.tribee.consume.widget.FlexibleScrollableTabRow (FlexibleScrollableTabRow.kt:96)");
            }
            final ScrollState scrollState = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
            final float f8 = f6;
            final float f9 = f7;
            final Function2 function23 = divider2;
            final Function3 function32 = indicator2;
            Function3 indicator3 = indicator2;
            Function2 divider3 = divider2;
            SurfaceKt.Surface-T9BRK9s(modifier5, (Shape) null, j6, j7, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(627570762, true, new Function2() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit FlexibleScrollableTabRow_xam5sdo$lambda$1;
                    FlexibleScrollableTabRow_xam5sdo$lambda$1 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$1(scrollState, f8, function22, f9, function23, function32, selectedTabIndex, (Composer) obj, ((Integer) obj2).intValue());
                    return FlexibleScrollableTabRow_xam5sdo$lambda$1;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 3) & 14) | 12582912 | ($dirty2 & 896) | ($dirty2 & 7168), (int) ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            indicator = indicator3;
            divider = divider3;
            modifier2 = modifier5;
            j4 = j6;
            f5 = f6;
            j5 = j7;
            f4 = f7;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            j4 = j;
            f4 = f2;
            indicator = function3;
            divider = function2;
            j5 = j3;
            f5 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final long j8 = j4;
            final long j9 = j5;
            final float f10 = f5;
            final float f11 = f4;
            final Function3 function33 = indicator;
            final Function2 function24 = divider;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit FlexibleScrollableTabRow_xam5sdo$lambda$2;
                    FlexibleScrollableTabRow_xam5sdo$lambda$2 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$2(selectedTabIndex, modifier6, j8, j9, f10, f11, function33, function24, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FlexibleScrollableTabRow_xam5sdo$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleScrollableTabRow_xam5sdo$lambda$1(ScrollState $scrollState, final float f, final Function2 $tabs, final float f2, final Function2 $divider, final Function3 $indicator, final int $selectedTabIndex, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C99@4600L24,101@4669L147,111@5085L3261,104@4825L3521:FlexibleScrollableTabRow.kt#vkdvar");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(627570762, $changed, -1, "kntr.app.tribee.consume.widget.FlexibleScrollableTabRow.<anonymous> (FlexibleScrollableTabRow.kt:99)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1800084189, "CC(remember):FlexibleScrollableTabRow.kt#9igjgp");
            boolean invalid$iv = $composer.changed($scrollState) | $composer.changed(coroutineScope);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new ScrollableTabData($scrollState, coroutineScope);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final ScrollableTabData scrollableTabData = (ScrollableTabData) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenterStart(), false, 2, (Object) null), $scrollState, false, (FlingBehavior) null, false, 14, (Object) null)));
            ComposerKt.sourceInformationMarkerStart($composer, 1800100615, "CC(remember):FlexibleScrollableTabRow.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed(f) | $composer.changed($tabs) | $composer.changed(f2) | $composer.changed($divider) | $composer.changed($indicator) | $composer.changedInstance(scrollableTabData) | $composer.changed($selectedTabIndex);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function2() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0;
                        FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0(f, $tabs, f2, $divider, scrollableTabData, $selectedTabIndex, $indicator, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) it$iv2, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0(float f, Function2 $tabs, float f2, final Function2 $divider, final ScrollableTabData $scrollableTabData, final int $selectedTabIndex, final Function3 $indicator, final SubcomposeMeasureScope $this$SubcomposeLayout, final Constraints constraints) {
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        final int padding = $this$SubcomposeLayout.roundToPx-0680j_4(f);
        List tabMeasurables = $this$SubcomposeLayout.subcompose(TabSlots.Tabs, $tabs);
        Object initial$iv = 0;
        List $this$fastFold$iv = tabMeasurables;
        Object accumulator$iv = initial$iv;
        int index$iv$iv = 0;
        int size = $this$fastFold$iv.size();
        while (index$iv$iv < size) {
            Object item$iv$iv = $this$fastFold$iv.get(index$iv$iv);
            Measurable measurable = (Measurable) item$iv$iv;
            Object initial$iv2 = initial$iv;
            int curr = ((Number) accumulator$iv).intValue();
            accumulator$iv = Integer.valueOf(Math.max(curr, measurable.maxIntrinsicHeight((int) FlowControlConfig.RETRY_MAX_TIMES)));
            index$iv$iv++;
            initial$iv = initial$iv2;
            $this$fastFold$iv = $this$fastFold$iv;
        }
        final int layoutHeight = ((Number) accumulator$iv).intValue();
        long tabConstraints = Constraints.copy-Zbe2FdA$default(constraints.unbox-impl(), $this$SubcomposeLayout.roundToPx-0680j_4(f2), 0, layoutHeight, layoutHeight, 2, (Object) null);
        final List tabPlaceables = new ArrayList();
        final List tabContentWidths = new ArrayList();
        List $this$fastForEach$iv = tabMeasurables;
        boolean z = false;
        int index$iv = 0;
        for (int size2 = $this$fastForEach$iv.size(); index$iv < size2; size2 = size2) {
            Object item$iv = $this$fastForEach$iv.get(index$iv);
            Measurable it = (Measurable) item$iv;
            List $this$fastForEach$iv2 = $this$fastForEach$iv;
            Placeable placeable = it.measure-BRTryo0(tabConstraints);
            boolean z2 = z;
            int $i$f$fastForEach = placeable.getHeight();
            float contentWidth = $this$SubcomposeLayout.toDp-u2uoSUM(Math.min(it.maxIntrinsicWidth($i$f$fastForEach), placeable.getWidth()));
            tabPlaceables.add(placeable);
            tabContentWidths.add(Dp.box-impl(contentWidth));
            index$iv++;
            $this$fastForEach$iv = $this$fastForEach$iv2;
            z = z2;
        }
        Object accumulator$iv2 = Integer.valueOf(padding * 2);
        int size3 = tabPlaceables.size();
        for (int index$iv$iv2 = 0; index$iv$iv2 < size3; index$iv$iv2++) {
            Object item$iv$iv2 = tabPlaceables.get(index$iv$iv2);
            Placeable measurable2 = (Placeable) item$iv$iv2;
            int curr2 = ((Number) accumulator$iv2).intValue();
            accumulator$iv2 = Integer.valueOf(curr2 + measurable2.getWidth());
        }
        final int layoutWidth = ((Number) accumulator$iv2).intValue();
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, layoutWidth, layoutHeight, (Map) null, new Function1() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3;
                FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3(padding, tabPlaceables, $this$SubcomposeLayout, $divider, $scrollableTabData, $selectedTabIndex, tabContentWidths, constraints, layoutWidth, layoutHeight, $indicator, (Placeable.PlacementScope) obj);
                return FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3(int $padding, List $tabPlaceables, SubcomposeMeasureScope $this_SubcomposeLayout, Function2 $divider, ScrollableTabData $scrollableTabData, int $selectedTabIndex, List $tabContentWidths, Constraints $constraints, int $layoutWidth, int $layoutHeight, final Function3 $indicator, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        final List tabPositions = new ArrayList();
        List $this$fastForEachIndexed$iv = $tabPlaceables;
        int size = $this$fastForEachIndexed$iv.size();
        int left = $padding;
        int index$iv = 0;
        while (index$iv < size) {
            Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
            Placeable placeable = (Placeable) item$iv;
            int index = index$iv;
            Placeable.PlacementScope.placeRelative$default($this$layout, placeable, left, 0, 0.0f, 4, (Object) null);
            tabPositions.add(new TabPosition($this$layout.toDp-u2uoSUM(left), $this$layout.toDp-u2uoSUM(placeable.getWidth()), ((Dp) $tabContentWidths.get(index)).unbox-impl(), null));
            left += placeable.getWidth();
            index$iv++;
            $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv;
        }
        List $this$fastForEach$iv = $this_SubcomposeLayout.subcompose(TabSlots.Divider, $divider);
        int size2 = $this$fastForEach$iv.size();
        for (int index$iv2 = 0; index$iv2 < size2; index$iv2++) {
            Object item$iv2 = $this$fastForEach$iv.get(index$iv2);
            Measurable it = (Measurable) item$iv2;
            Placeable placeable2 = it.measure-BRTryo0(Constraints.copy-Zbe2FdA$default($constraints.unbox-impl(), $layoutWidth, $layoutWidth, 0, 0, 8, (Object) null));
            Placeable.PlacementScope.placeRelative$default($this$layout, placeable2, 0, $layoutHeight - placeable2.getHeight(), 0.0f, 4, (Object) null);
        }
        List $this$fastForEach$iv2 = $this_SubcomposeLayout.subcompose(TabSlots.Indicator, ComposableLambdaKt.composableLambdaInstance(-1465685498, true, new Function2() { // from class: kntr.app.tribee.consume.widget.FlexibleScrollableTabRowKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3$2;
                FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3$2 = FlexibleScrollableTabRowKt.FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3$2($indicator, tabPositions, (Composer) obj, ((Integer) obj2).intValue());
                return FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3$2;
            }
        }));
        int index$iv3 = 0;
        for (int size3 = $this$fastForEach$iv2.size(); index$iv3 < size3; size3 = size3) {
            Object item$iv3 = $this$fastForEach$iv2.get(index$iv3);
            Measurable it2 = (Measurable) item$iv3;
            Placeable.PlacementScope.placeRelative$default($this$layout, it2.measure-BRTryo0(Constraints.Companion.fixed-JhjzzOo($layoutWidth, $layoutHeight)), 0, 0, 0.0f, 4, (Object) null);
            index$iv3++;
        }
        $scrollableTabData.onLaidOut((Density) $this_SubcomposeLayout, $padding, tabPositions, $selectedTabIndex);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FlexibleScrollableTabRow_xam5sdo$lambda$1$1$0$3$2(Function3 $indicator, List $tabPositions, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C176@7879L23:FlexibleScrollableTabRow.kt#vkdvar");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1465685498, $changed, -1, "kntr.app.tribee.consume.widget.FlexibleScrollableTabRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FlexibleScrollableTabRow.kt:176)");
            }
            $indicator.invoke($tabPositions, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}