package kntr.app.game.steam.chart;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextPainterKt;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.TimeSource;

/* compiled from: BarChart.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001ai\u0010\u0015\u001a\u00020\u0001*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001ab\u0010\u001e\u001a\u00020\u0001*\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0002\u001aV\u0010#\u001a\u00020\u0001*\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00032\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002\u001a`\u0010'\u001a\u00020\u0001*\u00020\u000b2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rH\u0002¨\u0006)"}, d2 = {"BarChart", RoomRecommendViewModel.EMPTY_CURSOR, "data", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/steam/chart/BarData;", "modifier", "Landroidx/compose/ui/Modifier;", "config", "Lkntr/app/game/steam/chart/BarChartConfig;", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkntr/app/game/steam/chart/BarChartConfig;Landroidx/compose/runtime/Composer;II)V", "drawAxes", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "leftPadding", RoomRecommendViewModel.EMPTY_CURSOR, "topPadding", "chartWidth", "chartHeight", "axisColor", "Landroidx/compose/ui/graphics/Color;", "drawAxes-kKL39v8", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFFJ)V", "drawGrid", "gridColor", "maxValue", "minValue", "showHorizontalGrid", RoomRecommendViewModel.EMPTY_CURSOR, "showVerticalGrid", "drawGrid-3csKH6Y", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Ljava/util/List;FFFFJFFZZ)V", "drawBars", "barWidth", "cornerRadius", "reusablePath", "Landroidx/compose/ui/graphics/Path;", "drawAxisLabels", "xAxisLabels", "Landroidx/compose/ui/text/TextLayoutResult;", "yAxisLabels", "drawValueLabels", "valueLabels", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BarChartKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarChart$lambda$0(List list, Modifier modifier, BarChartConfig barChartConfig, int i, int i2, Composer composer, int i3) {
        BarChart(list, modifier, barChartConfig, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarChart$lambda$18(List list, Modifier modifier, BarChartConfig barChartConfig, int i, int i2, Composer composer, int i3) {
        BarChart(list, modifier, barChartConfig, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06ff  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x070d  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x07d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BarChart(final List<BarData> list, Modifier modifier, BarChartConfig config, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        BarChartConfig barChartConfig;
        Modifier modifier3;
        BarChartConfig config2;
        int $dirty;
        Modifier modifier4;
        Float valueOf;
        float floatValue;
        Float valueOf2;
        Float f;
        float floatValue2;
        Object it$iv;
        boolean z;
        Modifier fillMaxWidth$default;
        boolean invalid$iv;
        Object it$iv2;
        int i2;
        Intrinsics.checkNotNullParameter(list, "data");
        Composer $composer2 = $composer.startRestartGroup(1660108018);
        ComposerKt.sourceInformation($composer2, "C(BarChart)N(data,modifier,config)69@2412L22,74@2555L33,75@2611L49,76@2704L33,78@2771L88,81@2881L34,84@2983L40,84@2962L61,89@3100L449,89@3079L470,108@3655L124,112@3807L184,120@4042L201,127@4277L201,136@4540L172,143@4744L381,154@5157L228,162@5456L19,177@5927L2373,166@5554L2746:BarChart.kt#lmm5cu");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                barChartConfig = config;
                if ($composer2.changed(barChartConfig)) {
                    i2 = 256;
                    $dirty2 |= i2;
                }
            } else {
                barChartConfig = config;
            }
            i2 = 128;
            $dirty2 |= i2;
        } else {
            barChartConfig = config;
        }
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if ((i & 4) != 0) {
                    $dirty = $dirty2 & (-897);
                    modifier4 = modifier5;
                    config2 = new BarChartConfig(false, false, false, false, false, 0L, 0L, 0.0f, 0.0f, 0L, 0L, 0.0f, null, null, 0.0f, null, 0.0f, 131071, null);
                } else {
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    config2 = barChartConfig;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty2 &= -897;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                config2 = barChartConfig;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1660108018, $dirty, -1, "kntr.app.game.steam.chart.BarChart (BarChart.kt:68)");
            }
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer2, 0, 1);
            if (list.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    final BarChartConfig barChartConfig2 = config2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.chart.BarChartKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BarChart$lambda$0;
                            BarChart$lambda$0 = BarChartKt.BarChart$lambda$0(list, modifier6, barChartConfig2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BarChart$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1930947827, "CC(remember):BarChart.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(list, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv3 = value$iv;
            }
            MutableState stableData = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1930949635, "CC(remember):BarChart.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv4 = value$iv2;
            }
            MutableState pendingData = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1930952595, "CC(remember):BarChart.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv3 = TimeSource.Monotonic.INSTANCE;
                $composer2.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            }
            TimeSource.Monotonic timeSource = (TimeSource.Monotonic) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1930954794, "CC(remember):BarChart.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                long j2 = timeSource.markNow-z9LOYto();
                Duration.Companion companion = Duration.Companion;
                modifier3 = modifier4;
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(TimeSource.Monotonic.ValueTimeMark.box-impl(TimeSource.Monotonic.ValueTimeMark.minus-LRDsOJo(j2, DurationKt.toDuration(500, DurationUnit.MILLISECONDS))), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
            } else {
                modifier3 = modifier4;
            }
            MutableState lastUpdateMark = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1930958260, "CC(remember):BarChart.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default);
                it$iv7 = mutableStateOf$default;
            }
            MutableState isUpdating = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1930961530, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(list);
            Object it$iv8 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Function2) new BarChartKt$BarChart$2$1(pendingData, list, null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv8 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(list, (Function2) it$iv8, $composer2, $dirty & 14);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1930965683, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(timeSource);
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv9 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function2) new BarChartKt$BarChart$3$1(pendingData, stableData, isUpdating, lastUpdateMark, timeSource, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv9 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv9, $composer2, 6);
            final List currentData = (List) stableData.getValue();
            Float maxValue = config2.getMaxValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1930983118, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv4 = $composer2.changed(maxValue) | $composer2.changed(currentData);
            Object it$iv10 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv10 == Composer.Companion.getEmpty()) {
                Float maxValue2 = config2.getMaxValue();
                if (maxValue2 != null) {
                    floatValue = maxValue2.floatValue();
                } else {
                    Iterator it = currentData.iterator();
                    if (it.hasNext()) {
                        BarData it2 = (BarData) it.next();
                        float value = it2.getValue();
                        while (it.hasNext()) {
                            BarData it3 = (BarData) it.next();
                            value = Math.max(value, it3.getValue());
                            pendingData = pendingData;
                        }
                        valueOf = Float.valueOf(value);
                    } else {
                        valueOf = null;
                    }
                    floatValue = valueOf != null ? valueOf.floatValue() : 0.0f;
                }
                Object value$iv7 = Float.valueOf(floatValue);
                $composer2.updateRememberedValue(value$iv7);
                it$iv10 = value$iv7;
            }
            final float maxValue3 = ((Number) it$iv10).floatValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Float minValue = config2.getMinValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1930988042, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv5 = $composer2.changed(minValue) | $composer2.changed(currentData);
            Object it$iv11 = $composer2.rememberedValue();
            if (invalid$iv5 || it$iv11 == Composer.Companion.getEmpty()) {
                Float minValue2 = config2.getMinValue();
                if (minValue2 != null) {
                    floatValue2 = minValue2.floatValue();
                } else {
                    Iterator it4 = currentData.iterator();
                    if (it4.hasNext()) {
                        BarData it5 = (BarData) it4.next();
                        float value2 = it5.getValue();
                        while (it4.hasNext()) {
                            BarData it6 = (BarData) it4.next();
                            value2 = Math.min(value2, it6.getValue());
                            timeSource = timeSource;
                        }
                        valueOf2 = Float.valueOf(value2);
                    } else {
                        valueOf2 = null;
                    }
                    if (valueOf2 != null) {
                        float it7 = valueOf2.floatValue();
                        if (it7 >= 0.0f) {
                            it7 = 0.0f;
                        }
                        f = Float.valueOf(it7);
                    } else {
                        f = null;
                    }
                    floatValue2 = f != null ? f.floatValue() : 0.0f;
                }
                Object value$iv8 = Float.valueOf(floatValue2);
                $composer2.updateRememberedValue(value$iv8);
                it$iv11 = value$iv8;
            }
            final float minValue3 = ((Number) it$iv11).floatValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float labelTextSize = config2.getLabelTextSize();
            long m1338getLabelTextColor0d7_KjU = config2.m1338getLabelTextColor0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer2, 1930995579, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv6 = $composer2.changed(labelTextSize) | $composer2.changed(m1338getLabelTextColor0d7_KjU);
            Object it$iv12 = $composer2.rememberedValue();
            if (invalid$iv6 || it$iv12 == Composer.Companion.getEmpty()) {
                Object value$iv9 = new TextStyle(config2.m1338getLabelTextColor0d7_KjU(), TextUnitKt.getSp(config2.getLabelTextSize()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
                $composer2.updateRememberedValue(value$iv9);
                it$iv12 = value$iv9;
            }
            TextStyle labelTextStyle = (TextStyle) it$iv12;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            float valueTextSize = config2.getValueTextSize();
            long m1339getValueTextColor0d7_KjU = config2.m1339getValueTextColor0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer2, 1931003099, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv7 = $composer2.changed(valueTextSize) | $composer2.changed(m1339getValueTextColor0d7_KjU);
            Object it$iv13 = $composer2.rememberedValue();
            if (invalid$iv7 || it$iv13 == Composer.Companion.getEmpty()) {
                Object value$iv10 = new TextStyle(config2.m1339getValueTextColor0d7_KjU(), TextUnitKt.getSp(config2.getValueTextSize()), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
                $composer2.updateRememberedValue(value$iv10);
                it$iv13 = value$iv10;
            }
            TextStyle valueTextStyle = (TextStyle) it$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1931011486, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv8 = $composer2.changed(currentData) | $composer2.changed(labelTextStyle);
            Object it$iv14 = $composer2.rememberedValue();
            if (invalid$iv8 || it$iv14 == Composer.Companion.getEmpty()) {
                List $this$map$iv = currentData;
                int $i$f$cache = CollectionsKt.collectionSizeOrDefault($this$map$iv, 10);
                Collection destination$iv$iv = new ArrayList($i$f$cache);
                for (Object item$iv$iv : $this$map$iv) {
                    BarData barData = (BarData) item$iv$iv;
                    destination$iv$iv.add(TextMeasurer.measure-wNUYSr0$default(textMeasurer, barData.getLabel(), labelTextStyle, 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1020, (Object) null));
                    $this$map$iv = $this$map$iv;
                }
                Object value$iv11 = (List) destination$iv$iv;
                $composer2.updateRememberedValue(value$iv11);
                it$iv14 = value$iv11;
            }
            final List xAxisLabels = (List) it$iv14;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1931018223, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv9 = $composer2.changed(minValue3) | $composer2.changed(maxValue3) | $composer2.changed(labelTextStyle);
            Object it$iv15 = $composer2.rememberedValue();
            if (invalid$iv9 || it$iv15 == Composer.Companion.getEmpty()) {
                float valueRange = maxValue3 - minValue3;
                Iterable $this$map$iv2 = new IntRange(0, 5);
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                Iterable $this$mapTo$iv$iv = $this$map$iv2;
                IntIterator it8 = $this$mapTo$iv$iv.iterator();
                while (it8.hasNext()) {
                    int item$iv$iv2 = it8.nextInt();
                    Iterable $this$map$iv3 = $this$map$iv2;
                    Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                    float value3 = ((item$iv$iv2 / 5) * valueRange) + minValue3;
                    String text = String.valueOf(MathKt.roundToInt(value3));
                    destination$iv$iv2.add(TextMeasurer.measure-wNUYSr0$default(textMeasurer, text, labelTextStyle, 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1020, (Object) null));
                    $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                    $this$map$iv2 = $this$map$iv3;
                }
                Object value$iv12 = (List) destination$iv$iv2;
                $composer2.updateRememberedValue(value$iv12);
                it$iv15 = value$iv12;
            }
            final List yAxisLabels = (List) it$iv15;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1931031286, "CC(remember):BarChart.kt#9igjgp");
            boolean invalid$iv10 = $composer2.changed(currentData) | $composer2.changed(valueTextStyle);
            Object it$iv16 = $composer2.rememberedValue();
            if (!invalid$iv10 && it$iv16 != Composer.Companion.getEmpty()) {
                final List valueLabels = (List) it$iv16;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 1931040645, "CC(remember):BarChart.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv13 = AndroidPath_androidKt.Path();
                    $composer2.updateRememberedValue(value$iv13);
                    it$iv = value$iv13;
                }
                final Path reusablePath = (Path) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Modifier mod = modifier3;
                if (config2.m1336getChartWidthlTKBWiU() == null) {
                    fillMaxWidth$default = SizeKt.width-3ABfNKs(mod, config2.m1336getChartWidthlTKBWiU().unbox-impl());
                    z = true;
                } else {
                    z = true;
                    fillMaxWidth$default = SizeKt.fillMaxWidth$default(mod, 0.0f, 1, (Object) null);
                }
                Modifier modifier7 = GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(SizeKt.height-3ABfNKs(fillMaxWidth$default, config2.m1335getChartHeightD9Ej5fM()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524287, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 1931058071, "CC(remember):BarChart.kt#9igjgp");
                invalid$iv = $composer2.changedInstance(currentData) | ((((($dirty & 896) ^ 384) > 256 || !$composer2.changed(config2)) && ($dirty & 384) != 256) ? false : z) | $composer2.changed(maxValue3) | $composer2.changed(minValue3) | $composer2.changedInstance(reusablePath) | $composer2.changedInstance(xAxisLabels) | $composer2.changedInstance(yAxisLabels) | $composer2.changedInstance(valueLabels);
                it$iv2 = $composer2.rememberedValue();
                if (!invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    final BarChartConfig barChartConfig3 = config2;
                    Object value$iv14 = new Function1() { // from class: kntr.app.game.steam.chart.BarChartKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit BarChart$lambda$17$0;
                            BarChart$lambda$17$0 = BarChartKt.BarChart$lambda$17$0(BarChartConfig.this, currentData, maxValue3, minValue3, reusablePath, xAxisLabels, yAxisLabels, valueLabels, (DrawScope) obj);
                            return BarChart$lambda$17$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv14);
                    it$iv2 = value$iv14;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                CanvasKt.Canvas(modifier7, (Function1) it$iv2, $composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            List $this$map$iv4 = currentData;
            int $i$f$cache2 = CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10);
            Collection destination$iv$iv3 = new ArrayList($i$f$cache2);
            for (Object item$iv$iv3 : $this$map$iv4) {
                BarData barData2 = (BarData) item$iv$iv3;
                String text2 = String.valueOf(MathKt.roundToInt(barData2.getValue()));
                destination$iv$iv3.add(TextMeasurer.measure-wNUYSr0$default(textMeasurer, text2, valueTextStyle, 0, false, 0, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 1020, (Object) null));
                $this$map$iv4 = $this$map$iv4;
            }
            Object value$iv15 = (List) destination$iv$iv3;
            $composer2.updateRememberedValue(value$iv15);
            it$iv16 = value$iv15;
            final List valueLabels2 = (List) it$iv16;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1931040645, "CC(remember):BarChart.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            final Path reusablePath2 = (Path) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier mod2 = modifier3;
            if (config2.m1336getChartWidthlTKBWiU() == null) {
            }
            Modifier modifier72 = GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(SizeKt.height-3ABfNKs(fillMaxWidth$default, config2.m1335getChartHeightD9Ej5fM()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524287, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1931058071, "CC(remember):BarChart.kt#9igjgp");
            invalid$iv = $composer2.changedInstance(currentData) | ((((($dirty & 896) ^ 384) > 256 || !$composer2.changed(config2)) && ($dirty & 384) != 256) ? false : z) | $composer2.changed(maxValue3) | $composer2.changed(minValue3) | $composer2.changedInstance(reusablePath2) | $composer2.changedInstance(xAxisLabels) | $composer2.changedInstance(yAxisLabels) | $composer2.changedInstance(valueLabels2);
            it$iv2 = $composer2.rememberedValue();
            if (!invalid$iv) {
            }
            final BarChartConfig barChartConfig32 = config2;
            Object value$iv142 = new Function1() { // from class: kntr.app.game.steam.chart.BarChartKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit BarChart$lambda$17$0;
                    BarChart$lambda$17$0 = BarChartKt.BarChart$lambda$17$0(BarChartConfig.this, currentData, maxValue3, minValue3, reusablePath2, xAxisLabels, yAxisLabels, valueLabels2, (DrawScope) obj);
                    return BarChart$lambda$17$0;
                }
            };
            $composer2.updateRememberedValue(value$iv142);
            it$iv2 = value$iv142;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier72, (Function1) it$iv2, $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            config2 = barChartConfig;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier8 = modifier3;
            final BarChartConfig barChartConfig4 = config2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.game.steam.chart.BarChartKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BarChart$lambda$18;
                    BarChart$lambda$18 = BarChartKt.BarChart$lambda$18(list, modifier8, barChartConfig4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BarChart$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BarChart$lambda$17$0(BarChartConfig $config, List $currentData, float $maxValue, float $minValue, Path $reusablePath, List $xAxisLabels, List $yAxisLabels, List $valueLabels, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
        float canvasWidth = Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) (4294967295L & $this$Canvas.getSize-NH-jbRc());
        float canvasHeight = Float.intBitsToFloat(bits$iv$iv$iv2);
        float leftPadding = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(30));
        float rightPadding = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(0));
        float topPadding = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(19));
        float bottomPadding = $this$Canvas.toPx-0680j_4(Dp.constructor-impl(18));
        float chartWidth = (canvasWidth - leftPadding) - rightPadding;
        float chartHeight = (canvasHeight - topPadding) - bottomPadding;
        m1341drawAxeskKL39v8($this$Canvas, leftPadding, topPadding, chartWidth, chartHeight, $config.m1334getAxisColor0d7_KjU());
        if ($config.getShowGrid()) {
            m1342drawGrid3csKH6Y($this$Canvas, $currentData, leftPadding, topPadding, chartWidth, chartHeight, $config.m1337getGridColor0d7_KjU(), $maxValue, $minValue, $config.getShowHorizontalGrid(), $config.getShowVerticalGrid());
        }
        drawBars($this$Canvas, $currentData, leftPadding, topPadding, chartWidth, chartHeight, $maxValue, $minValue, $config.getBarWidth(), $config.getBarCornerRadius(), $reusablePath);
        if ($config.getShowAxisLabels()) {
            drawAxisLabels($this$Canvas, $xAxisLabels, $yAxisLabels, $currentData, leftPadding, topPadding, chartWidth, chartHeight);
        }
        if ($config.getShowValueLabels()) {
            drawValueLabels($this$Canvas, $valueLabels, $currentData, leftPadding, topPadding, chartWidth, chartHeight, $maxValue, $minValue, $config.getBarWidth());
        }
        return Unit.INSTANCE;
    }

    /* renamed from: drawAxes-kKL39v8  reason: not valid java name */
    private static final void m1341drawAxeskKL39v8(DrawScope $this$drawAxes_u2dkKL39v8, float leftPadding, float topPadding, float chartWidth, float chartHeight, long j2) {
        float y$iv = topPadding + chartHeight;
        long v1$iv$iv = Float.floatToRawIntBits(leftPadding);
        long v2$iv$iv = Float.floatToRawIntBits(y$iv);
        long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        float y$iv2 = leftPadding + chartWidth;
        float y$iv3 = topPadding + chartHeight;
        long v1$iv$iv2 = Float.floatToRawIntBits(y$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv3);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawAxes_u2dkKL39v8, j2, j3, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 1.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* renamed from: drawGrid-3csKH6Y  reason: not valid java name */
    private static final void m1342drawGrid3csKH6Y(DrawScope $this$drawGrid_u2d3csKH6Y, List<BarData> list, float leftPadding, float topPadding, float chartWidth, float chartHeight, long j2, float maxValue, float minValue, boolean showHorizontalGrid, boolean showVerticalGrid) {
        int gridLines = 5;
        float dash = $this$drawGrid_u2d3csKH6Y.toPx-0680j_4(Dp.constructor-impl(4));
        PathEffect dashedPathEffect = PathEffect.Companion.dashPathEffect(new float[]{dash, dash}, 0.0f);
        if (showHorizontalGrid) {
            int i = 0;
            while (true) {
                float y = (topPadding + chartHeight) - ((i / 5) * chartHeight);
                long v1$iv$iv = Float.floatToRawIntBits(leftPadding);
                long v2$iv$iv = Float.floatToRawIntBits(y);
                long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                float y$iv = leftPadding + chartWidth;
                long v1$iv$iv2 = Float.floatToRawIntBits(y$iv);
                long v2$iv$iv2 = Float.floatToRawIntBits(y);
                int i2 = i;
                DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawGrid_u2d3csKH6Y, j2, j3, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 1.0f, 0, dashedPathEffect, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
                if (i2 == 5) {
                    break;
                }
                i = i2 + 1;
            }
        }
        if (showVerticalGrid) {
            int barCount = list.size();
            float barSpacing = chartWidth / barCount;
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                float x = leftPadding + ((i3 + 0.5f) * barSpacing);
                long j4 = Color.copy-wmQWz5c$default(j2, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                long v1$iv$iv3 = Float.floatToRawIntBits(x);
                int gridLines2 = gridLines;
                long v2$iv$iv3 = Float.floatToRawIntBits(topPadding);
                long j5 = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
                float y$iv2 = topPadding + chartHeight;
                long v1$iv$iv4 = Float.floatToRawIntBits(x);
                long v2$iv$iv4 = Float.floatToRawIntBits(y$iv2);
                DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawGrid_u2d3csKH6Y, j4, j5, Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L)), 1.0f, 0, dashedPathEffect, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
                i3++;
                size = size;
                gridLines = gridLines2;
                dash = dash;
                barCount = barCount;
            }
        }
    }

    private static final void drawBars(DrawScope $this$drawBars, List<BarData> list, float leftPadding, float topPadding, float chartWidth, float chartHeight, float maxValue, float minValue, float barWidth, float cornerRadius, Path reusablePath) {
        float zeroY;
        float barTop;
        float valueRange;
        int barCount;
        float barSpacing;
        Iterable $this$forEachIndexed$iv;
        float zeroY2;
        float actualBarWidth;
        float valueRange2 = maxValue - minValue;
        int barCount2 = list.size();
        float barSpacing2 = chartWidth / barCount2;
        float actualBarWidth2 = barSpacing2 * barWidth;
        if (minValue < 0.0f) {
            zeroY = (topPadding + chartHeight) - ((Math.abs(minValue) / valueRange2) * chartHeight);
        } else {
            zeroY = topPadding + chartHeight;
        }
        List<BarData> $this$forEachIndexed$iv2 = list;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv2) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BarData barData = (BarData) item$iv;
            float barLeft = leftPadding + (index * barSpacing2) + ((barSpacing2 - actualBarWidth2) / 2);
            float barHeight = (Math.abs(barData.getValue()) / valueRange2) * chartHeight;
            if (barData.getValue() >= 0.0f) {
                barTop = zeroY - barHeight;
            } else {
                barTop = zeroY;
            }
            if (cornerRadius > 0.0f) {
                reusablePath.reset();
                if (barData.getValue() >= 0.0f) {
                    valueRange = valueRange2;
                    reusablePath.moveTo(barLeft, zeroY);
                    barCount = barCount2;
                    reusablePath.lineTo(barLeft, barTop + cornerRadius);
                    reusablePath.quadraticBezierTo(barLeft, barTop, barLeft + cornerRadius, barTop);
                    reusablePath.lineTo((barLeft + actualBarWidth2) - cornerRadius, barTop);
                    barSpacing = barSpacing2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    reusablePath.quadraticBezierTo(barLeft + actualBarWidth2, barTop, barLeft + actualBarWidth2, barTop + cornerRadius);
                    reusablePath.lineTo(barLeft + actualBarWidth2, zeroY);
                    reusablePath.close();
                } else {
                    valueRange = valueRange2;
                    barSpacing = barSpacing2;
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    barCount = barCount2;
                    reusablePath.moveTo(barLeft, zeroY);
                    reusablePath.lineTo(barLeft, barTop - cornerRadius);
                    reusablePath.quadraticBezierTo(barLeft, barTop, barLeft + cornerRadius, barTop);
                    reusablePath.lineTo((barLeft + actualBarWidth2) - cornerRadius, barTop);
                    reusablePath.quadraticBezierTo(barLeft + actualBarWidth2, barTop, barLeft + actualBarWidth2, barTop - cornerRadius);
                    reusablePath.lineTo(barLeft + actualBarWidth2, zeroY);
                    reusablePath.close();
                }
                if (barData.getGradient() != null) {
                    DrawScope.-CC.drawPath-GBMwjPU$default($this$drawBars, reusablePath, barData.getGradient(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                    actualBarWidth = actualBarWidth2;
                    zeroY2 = zeroY;
                } else {
                    DrawScope.-CC.drawPath-LG529CI$default($this$drawBars, reusablePath, barData.m1346getColor0d7_KjU(), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
                    actualBarWidth = actualBarWidth2;
                    zeroY2 = zeroY;
                }
            } else {
                valueRange = valueRange2;
                barCount = barCount2;
                barSpacing = barSpacing2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                if (barData.getGradient() != null) {
                    Brush gradient = barData.getGradient();
                    float y$iv = barTop;
                    long v1$iv$iv = Float.floatToRawIntBits(barLeft);
                    zeroY2 = zeroY;
                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                    long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                    float width$iv = actualBarWidth2;
                    long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
                    int $i$f$Size = Float.floatToRawIntBits(barHeight);
                    long v2$iv$iv2 = $i$f$Size;
                    DrawScope.-CC.drawRect-AsUm42w$default($this$drawBars, gradient, j2, Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                    actualBarWidth = actualBarWidth2;
                } else {
                    zeroY2 = zeroY;
                    long m1346getColor0d7_KjU = barData.m1346getColor0d7_KjU();
                    float y$iv2 = barTop;
                    long v1$iv$iv3 = Float.floatToRawIntBits(barLeft);
                    int $i$f$Offset = Float.floatToRawIntBits(y$iv2);
                    long v2$iv$iv3 = $i$f$Offset;
                    long j3 = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
                    float width$iv2 = actualBarWidth2;
                    long v1$iv$iv4 = Float.floatToRawIntBits(width$iv2);
                    int $i$f$Size2 = Float.floatToRawIntBits(barHeight);
                    actualBarWidth = actualBarWidth2;
                    long v2$iv$iv4 = $i$f$Size2;
                    DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBars, m1346getColor0d7_KjU, j3, Size.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv4 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
                }
            }
            index = index$iv;
            barCount2 = barCount;
            valueRange2 = valueRange;
            barSpacing2 = barSpacing;
            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
            actualBarWidth2 = actualBarWidth;
            zeroY = zeroY2;
        }
    }

    private static final void drawAxisLabels(DrawScope $this$drawAxisLabels, List<TextLayoutResult> list, List<TextLayoutResult> list2, List<BarData> list3, float leftPadding, float topPadding, float chartWidth, float chartHeight) {
        TextLayoutResult textLayoutResult;
        List<TextLayoutResult> $this$forEachIndexed$iv = list2;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextLayoutResult textLayoutResult2 = (TextLayoutResult) item$iv;
            int i = index$iv;
            float y = (topPadding + chartHeight) - ((i / 5) * chartHeight);
            float x$iv = (leftPadding - ((int) (textLayoutResult2.getSize-YbymL2g() >> 32))) - $this$drawAxisLabels.toPx-0680j_4(Dp.constructor-impl(8));
            float y$iv = y - (((int) (textLayoutResult2.getSize-YbymL2g() & 4294967295L)) / 2);
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            TextPainterKt.drawText-d8-rzKo$default($this$drawAxisLabels, textLayoutResult2, 0L, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 250, (Object) null);
            index$iv = index$iv2;
        }
        int barCount = list3.size();
        float barSpacing = chartWidth / barCount;
        List<TextLayoutResult> $this$forEachIndexed$iv2 = list;
        int index$iv3 = 0;
        for (Object item$iv2 : $this$forEachIndexed$iv2) {
            int index$iv4 = index$iv3 + 1;
            if (index$iv3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int index = index$iv3;
            float x = leftPadding + ((index + 0.5f) * barSpacing);
            float x$iv2 = x - (((int) (textLayoutResult.getSize-YbymL2g() >> 32)) / 2);
            float y$iv2 = topPadding + chartHeight + $this$drawAxisLabels.toPx-0680j_4(Dp.constructor-impl(8));
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            TextPainterKt.drawText-d8-rzKo$default($this$drawAxisLabels, (TextLayoutResult) item$iv2, 0L, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 250, (Object) null);
            index$iv3 = index$iv4;
        }
    }

    private static final void drawValueLabels(DrawScope $this$drawValueLabels, List<TextLayoutResult> list, List<BarData> list2, float leftPadding, float topPadding, float chartWidth, float chartHeight, float maxValue, float minValue, float barWidth) {
        float f;
        float f2;
        float valueRange = maxValue - minValue;
        int barCount = list2.size();
        float barSpacing = chartWidth / barCount;
        if (minValue < 0.0f) {
            f = (topPadding + chartHeight) - ((Math.abs(minValue) / valueRange) * chartHeight);
        } else {
            f = topPadding + chartHeight;
        }
        float zeroY = f;
        List<TextLayoutResult> $this$forEachIndexed$iv = list;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TextLayoutResult textLayoutResult = (TextLayoutResult) item$iv;
            int index = index$iv;
            float x = leftPadding + ((index + 0.5f) * barSpacing);
            BarData barData = list2.get(index);
            float barHeight = (Math.abs(barData.getValue()) / valueRange) * chartHeight;
            if (barData.getValue() >= 0.0f) {
                f2 = ((zeroY - barHeight) - $this$drawValueLabels.toPx-0680j_4(Dp.constructor-impl(4))) - ((int) (textLayoutResult.getSize-YbymL2g() & 4294967295L));
            } else {
                f2 = zeroY + barHeight + $this$drawValueLabels.toPx-0680j_4(Dp.constructor-impl(4));
            }
            float textY = f2;
            float x$iv = x - (((int) (textLayoutResult.getSize-YbymL2g() >> 32)) / 2);
            long v1$iv$iv = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv = Float.floatToRawIntBits(textY);
            TextPainterKt.drawText-d8-rzKo$default($this$drawValueLabels, textLayoutResult, 0L, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (Shadow) null, (TextDecoration) null, (DrawStyle) null, 0, 250, (Object) null);
            index$iv = index$iv2;
        }
    }
}