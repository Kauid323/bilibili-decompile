package kntr.common.compose.chart;

import androidx.compose.foundation.CanvasKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.compose.chart.model.PieDataItem;
import kntr.common.compose.chart.model.PieType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposeChart.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u001ae\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0003\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"PieChart", "", "dataList", "", "Lkntr/common/compose/chart/model/PieDataItem;", "modifier", "Landroidx/compose/ui/Modifier;", "type", "Lkntr/common/compose/chart/model/PieType;", "strokeWidth", "Landroidx/compose/ui/unit/Dp;", "hasLine", "", "lineColor", "Landroidx/compose/ui/graphics/Color;", "lineWidth", "alpha", "", "PieChart-1CPYgEU", "(Ljava/util/List;Landroidx/compose/ui/Modifier;Lkntr/common/compose/chart/model/PieType;FZJFFLandroidx/compose/runtime/Composer;II)V", "compose-chart_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeChartKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PieChart_1CPYgEU$lambda$0(List list, Modifier modifier, PieType pieType, float f, boolean z, long j, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m1834PieChart1CPYgEU(list, modifier, pieType, f, z, j, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PieChart_1CPYgEU$lambda$4(List list, Modifier modifier, PieType pieType, float f, boolean z, long j, float f2, float f3, int i, int i2, Composer composer, int i3) {
        m1834PieChart1CPYgEU(list, modifier, pieType, f, z, j, f2, f3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: PieChart-1CPYgEU  reason: not valid java name */
    public static final void m1834PieChart1CPYgEU(final List<PieDataItem> list, Modifier modifier, PieType type, float f, boolean hasLine, long j, float f2, float alpha, Composer $composer, final int $changed, final int i) {
        boolean hasLine2;
        long j2;
        int $dirty;
        PieType type2;
        float f3;
        float f4;
        float alpha2;
        long j3;
        boolean hasLine3;
        Modifier modifier2;
        boolean z;
        Composer $composer2 = $composer.startRestartGroup(-2105854124);
        ComposerKt.sourceInformation($composer2, "C(PieChart)N(dataList,modifier,type,strokeWidth:c#ui.unit.Dp,hasLine,lineColor:c#ui.graphics.Color,lineWidth:c#ui.unit.Dp,alpha)48@1471L50,50@1549L118,54@1701L1612,54@1673L1640:ComposeChart.kt#7y5c30");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(type == null ? -1 : type.ordinal()) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(f) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty2 |= 24576;
            hasLine2 = hasLine;
        } else if (($changed & 24576) == 0) {
            hasLine2 = hasLine;
            $dirty2 |= $composer2.changed(hasLine2) ? 16384 : 8192;
        } else {
            hasLine2 = hasLine;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty2 |= 196608;
            j2 = j;
        } else if (($changed & 196608) == 0) {
            j2 = j;
            $dirty2 |= $composer2.changed(j2) ? 131072 : 65536;
        } else {
            j2 = j;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(f2) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer2.changed(alpha) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            type2 = i3 != 0 ? PieType.Full : type;
            f3 = i4 != 0 ? Dp.constructor-impl(0) : f;
            if (i5 != 0) {
                hasLine2 = false;
            }
            j3 = i6 != 0 ? Color.Companion.getWhite-0d7_KjU() : j2;
            float f5 = i7 != 0 ? Dp.constructor-impl(1) : f2;
            alpha2 = i8 != 0 ? 1.0f : alpha;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2105854124, $dirty2, -1, "kntr.common.compose.chart.PieChart (ComposeChart.kt:44)");
            }
            List<PieDataItem> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    final PieType pieType = type2;
                    final float f6 = f3;
                    final boolean z2 = hasLine2;
                    final long j4 = j3;
                    final float f7 = f5;
                    final float f8 = alpha2;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.chart.ComposeChartKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit PieChart_1CPYgEU$lambda$0;
                            PieChart_1CPYgEU$lambda$0 = ComposeChartKt.PieChart_1CPYgEU$lambda$0(list, modifier4, pieType, f6, z2, j4, f7, f8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return PieChart_1CPYgEU$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            int $dirty3 = $dirty2;
            Modifier modifier5 = modifier3;
            final boolean hasLine4 = hasLine2;
            ComposerKt.sourceInformationMarkerStart($composer2, -796204826, "CC(remember):ComposeChart.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(list);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                long j5 = 0;
                for (PieDataItem it : list) {
                    j5 += it.getCount();
                }
                Object value$iv = Long.valueOf(j5);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            long total = ((Number) it$iv).longValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -796202262, "CC(remember):ComposeChart.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(list);
            boolean z3 = false;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                List<PieDataItem> $this$map$iv = list;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    PieDataItem it2 = (PieDataItem) item$iv$iv;
                    destination$iv$iv.add(Float.valueOf((((float) it2.getCount()) / ((float) total)) * 360.0f));
                    z3 = z3;
                    it$iv2 = it$iv2;
                }
                Collection $this$toTypedArray$iv = (List) destination$iv$iv;
                z = false;
                Object value$iv2 = (Float[]) $this$toTypedArray$iv.toArray(new Float[0]);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                z = false;
            }
            final Float[] rateList = (Float[]) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -796195904, "CC(remember):ComposeChart.kt#9igjgp");
            boolean invalid$iv3 = (($dirty3 & 7168) == 2048 ? true : z) | $composer2.changedInstance(rateList) | $composer2.changedInstance(list) | (($dirty3 & 896) == 256 ? true : z) | ((29360128 & $dirty3) == 8388608 ? true : z) | ((57344 & $dirty3) == 16384 ? true : z) | ((458752 & $dirty3) == 131072 ? true : z) | ((3670016 & $dirty3) != 1048576 ? z : true);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                final float f9 = f3;
                final PieType pieType2 = type2;
                final float f10 = alpha2;
                final long j6 = j3;
                final float f11 = f5;
                value$iv3 = new Function1() { // from class: kntr.common.compose.chart.ComposeChartKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit PieChart_1CPYgEU$lambda$3$0;
                        PieChart_1CPYgEU$lambda$3$0 = ComposeChartKt.PieChart_1CPYgEU$lambda$3$0(f9, rateList, hasLine4, list, pieType2, f10, j6, f11, (DrawScope) obj);
                        return PieChart_1CPYgEU$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier5, (Function1) value$iv3, $composer2, ($dirty3 >> 3) & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $dirty = $dirty3;
            f4 = f5;
            hasLine3 = hasLine4;
            modifier2 = modifier5;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            type2 = type;
            f3 = f;
            f4 = f2;
            alpha2 = alpha;
            j3 = j2;
            hasLine3 = hasLine2;
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier6 = modifier2;
            final PieType pieType3 = type2;
            final float f12 = f3;
            final boolean z4 = hasLine3;
            final long j7 = j3;
            final float f13 = f4;
            final float f14 = alpha2;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.common.compose.chart.ComposeChartKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PieChart_1CPYgEU$lambda$4;
                    PieChart_1CPYgEU$lambda$4 = ComposeChartKt.PieChart_1CPYgEU$lambda$4(list, modifier6, pieType3, f12, z4, j7, f13, f14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PieChart_1CPYgEU$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PieChart_1CPYgEU$lambda$3$0(float f, Float[] $rateList, boolean $hasLine, List $dataList, PieType $type, float $alpha, long j, float f2, DrawScope $this$Canvas) {
        int it;
        float f3;
        float centerY;
        float centerX;
        DrawScope drawScope = $this$Canvas;
        Intrinsics.checkNotNullParameter(drawScope, "$this$Canvas");
        int bits$iv$iv$iv = (int) (SizeKt.getCenter-uvyYCjk($this$Canvas.getSize-NH-jbRc()) >> 32);
        float centerX2 = Float.intBitsToFloat(bits$iv$iv$iv);
        int bits$iv$iv$iv2 = (int) (SizeKt.getCenter-uvyYCjk($this$Canvas.getSize-NH-jbRc()) & 4294967295L);
        float centerY2 = Float.intBitsToFloat(bits$iv$iv$iv2);
        float lineLength = Math.min(centerX2, centerY2);
        float f4 = 2;
        float radius = lineLength - (drawScope.toPx-0680j_4(f) / f4);
        Iterable $this$forEach$iv = ArraysKt.getIndices($rateList);
        IntIterator it2 = $this$forEach$iv.iterator();
        float prefixAngle = 0.0f;
        while (it2.hasNext()) {
            int element$iv = it2.nextInt();
            Color m1838getColorQN2ZGVo = ((PieDataItem) $dataList.get(element$iv)).m1838getColorQN2ZGVo();
            if (m1838getColorQN2ZGVo == null) {
                it = element$iv;
                f3 = f4;
                centerY = centerY2;
                centerX = centerX2;
            } else {
                long color = m1838getColorQN2ZGVo.unbox-impl();
                boolean z = $type == PieType.Full;
                float f5 = prefixAngle - 90.0f;
                float floatValue = $rateList[element$iv].floatValue();
                float x$iv = centerX2 - radius;
                float y$iv = centerY2 - radius;
                long v1$iv$iv = Float.floatToRawIntBits(x$iv);
                int $i$f$Offset = Float.floatToRawIntBits(y$iv);
                long v2$iv$iv = $i$f$Offset;
                long v2$iv$iv2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                float width$iv = radius * f4;
                float height$iv = radius * f4;
                long v1$iv$iv2 = Float.floatToRawIntBits(width$iv);
                int $i$f$Size = Float.floatToRawIntBits(height$iv);
                long v2$iv$iv3 = $i$f$Size;
                it = element$iv;
                f3 = f4;
                centerY = centerY2;
                centerX = centerX2;
                DrawScope.-CC.drawArc-yD3GUKo$default($this$Canvas, color, f5, floatValue, z, v2$iv$iv2, Size.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L)), $alpha, (DrawStyle) ($type == PieType.Ring ? new Stroke(drawScope.toPx-0680j_4(f), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null) : Fill.INSTANCE), (ColorFilter) null, 0, 768, (Object) null);
            }
            prefixAngle += $rateList[it].floatValue();
            drawScope = $this$Canvas;
            f4 = f3;
            centerY2 = centerY;
            centerX2 = centerX;
        }
        float centerY3 = centerY2;
        float centerX3 = centerX2;
        if ($hasLine && $dataList.size() > 1) {
            Iterable $this$forEach$iv2 = ArraysKt.getIndices($rateList);
            IntIterator it3 = $this$forEach$iv2.iterator();
            float prefixAngle2 = 0.0f;
            while (it3.hasNext()) {
                int element$iv2 = it3.nextInt();
                float radians = (float) (((prefixAngle2 - 90.0f) * 3.141592653589793d) / 180.0f);
                long v1$iv$iv3 = Float.floatToRawIntBits(centerX3);
                long v2$iv$iv4 = Float.floatToRawIntBits(centerY3);
                long j2 = Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv4 & 4294967295L));
                float x$iv2 = centerX3 + (((float) Math.cos(radians)) * lineLength);
                float y$iv2 = centerY3 + (((float) Math.sin(radians)) * lineLength);
                long v1$iv$iv4 = Float.floatToRawIntBits(x$iv2);
                long v2$iv$iv5 = Float.floatToRawIntBits(y$iv2);
                DrawScope.-CC.drawLine-NGM6Ib0$default($this$Canvas, j, j2, Offset.constructor-impl((v1$iv$iv4 << 32) | (v2$iv$iv5 & 4294967295L)), $this$Canvas.toPx-0680j_4(f2), 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
                prefixAngle2 += $rateList[element$iv2].floatValue();
            }
        }
        return Unit.INSTANCE;
    }
}