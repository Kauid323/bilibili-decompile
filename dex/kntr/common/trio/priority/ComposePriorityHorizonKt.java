package kntr.common.trio.priority;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ComposePriorityHorizon.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\b\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\u000b¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"PriorityHorizon", "", "modifier", "Landroidx/compose/ui/Modifier;", "policy", "Lkntr/common/trio/priority/PriorityHorizonPolicy;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "content", "Lkotlin/Function1;", "Lkntr/common/trio/priority/PriorityHorizontalScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkntr/common/trio/priority/PriorityHorizonPolicy;Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposePriorityHorizonKt {

    /* compiled from: ComposePriorityHorizon.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PriorityHorizonPolicy.values().length];
            try {
                iArr[PriorityHorizonPolicy.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PriorityHorizonPolicy.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriorityHorizon$lambda$1(Modifier modifier, PriorityHorizonPolicy priorityHorizonPolicy, Alignment.Vertical vertical, Function3 function3, int i, int i2, Composer composer, int i3) {
        PriorityHorizon(modifier, priorityHorizonPolicy, vertical, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PriorityHorizon(Modifier modifier, PriorityHorizonPolicy policy, Alignment.Vertical verticalAlignment, final Function3<? super PriorityHorizontalScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Alignment.Vertical verticalAlignment2;
        PriorityHorizonPolicy policy2;
        Modifier modifier3;
        Modifier modifier4;
        final PriorityHorizonPolicy policy3;
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-720804598);
        ComposerKt.sourceInformation($composer2, "C(PriorityHorizon)N(modifier,policy,verticalAlignment,content)28@741L1348,28@703L1386:ComposePriorityHorizon.kt#1hw4x4");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(policy == null ? -1 : policy.ordinal()) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            verticalAlignment2 = verticalAlignment;
        } else if (($changed & 384) == 0) {
            verticalAlignment2 = verticalAlignment;
            $dirty |= $composer2.changed(verticalAlignment2) ? 256 : 128;
        } else {
            verticalAlignment2 = verticalAlignment;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            policy2 = policy;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                policy3 = policy;
            } else {
                policy3 = PriorityHorizonPolicy.START;
            }
            if (i4 != 0) {
                verticalAlignment2 = Alignment.Companion.getTop();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-720804598, $dirty2, -1, "kntr.common.trio.priority.PriorityHorizon (ComposePriorityHorizon.kt:27)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1203473490, "CC(remember):ComposePriorityHorizon.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 7168) == 2048) | (($dirty2 & 112) == 32) | (($dirty2 & 896) == 256);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function2() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult PriorityHorizon$lambda$0$0;
                        PriorityHorizon$lambda$0$0 = ComposePriorityHorizonKt.PriorityHorizon$lambda$0$0(PriorityHorizonPolicy.this, function3, verticalAlignment2, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return PriorityHorizon$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SubcomposeLayoutKt.SubcomposeLayout(modifier4, (Function2) it$iv, $composer2, $dirty2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            policy2 = policy3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final PriorityHorizonPolicy priorityHorizonPolicy = policy2;
            final Alignment.Vertical vertical = verticalAlignment2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriorityHorizon$lambda$1;
                    PriorityHorizon$lambda$1 = ComposePriorityHorizonKt.PriorityHorizon$lambda$1(modifier5, priorityHorizonPolicy, vertical, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PriorityHorizon$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult PriorityHorizon$lambda$0$0(PriorityHorizonPolicy $policy, final Function3 $content, final Alignment.Vertical $verticalAlignment, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        int width;
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        Iterable $this$mapIndexed$iv = $this$SubcomposeLayout.subcompose("PriorityHorizon", ComposableLambdaKt.composableLambdaInstance(-2082497104, true, new Function2() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit PriorityHorizon$lambda$0$0$0;
                PriorityHorizon$lambda$0$0$0 = ComposePriorityHorizonKt.PriorityHorizon$lambda$0$0$0($content, (Composer) obj, ((Integer) obj2).intValue());
                return PriorityHorizon$lambda$0$0$0;
            }
        }));
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Measurable measurable = (Measurable) item$iv$iv;
            destination$iv$iv.add(new IndexMeasurable(index$iv$iv, measurable));
            index$iv$iv = index$iv$iv2;
        }
        Iterable l = (List) destination$iv$iv;
        Iterable $this$sortedByDescending$iv = l;
        Iterable $this$sortedByDescending$iv2 = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$PriorityHorizon$lambda$0$0$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                IndexMeasurable it = (IndexMeasurable) t2;
                Object parentData = it.getMeasurable().getParentData();
                PriorityParentData priorityParentData = parentData instanceof PriorityParentData ? (PriorityParentData) parentData : null;
                Integer valueOf = Integer.valueOf(priorityParentData != null ? priorityParentData.getPriority() : 0);
                IndexMeasurable it2 = (IndexMeasurable) t;
                Object parentData2 = it2.getMeasurable().getParentData();
                PriorityParentData priorityParentData2 = parentData2 instanceof PriorityParentData ? (PriorityParentData) parentData2 : null;
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(priorityParentData2 != null ? priorityParentData2.getPriority() : 0));
            }
        });
        int left = Constraints.getMaxWidth-impl(constraints.unbox-impl());
        Iterable $this$map$iv = $this$sortedByDescending$iv2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv2 : $this$map$iv) {
            IndexMeasurable it = (IndexMeasurable) item$iv$iv2;
            int index = it.getIndex();
            Placeable p = it.getMeasurable().measure-BRTryo0(ConstraintsKt.Constraints$default(0, left, 0, 0, 13, (Object) null));
            left -= p.getMeasuredWidth();
            Unit unit = Unit.INSTANCE;
            destination$iv$iv2.add(new IndexPlaceable(index, p));
        }
        Iterable pList = (List) destination$iv$iv2;
        Iterable $this$sortedBy$iv = pList;
        final List<IndexPlaceable> sp = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$PriorityHorizon$lambda$0$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                IndexPlaceable it2 = (IndexPlaceable) t;
                IndexPlaceable it3 = (IndexPlaceable) t2;
                return ComparisonsKt.compareValues(Integer.valueOf(it2.getIndex()), Integer.valueOf(it3.getIndex()));
            }
        });
        Iterator it2 = sp.iterator();
        if (it2.hasNext()) {
            IndexPlaceable it3 = (IndexPlaceable) it2.next();
            int measuredHeight = it3.getPlaceable().getMeasuredHeight();
            while (it2.hasNext()) {
                IndexPlaceable it4 = (IndexPlaceable) it2.next();
                int measuredHeight2 = it4.getPlaceable().getMeasuredHeight();
                if (measuredHeight < measuredHeight2) {
                    measuredHeight = measuredHeight2;
                }
            }
            final int height = measuredHeight;
            switch (WhenMappings.$EnumSwitchMapping$0[$policy.ordinal()]) {
                case 1:
                    width = Constraints.getMaxWidth-impl(constraints.unbox-impl());
                    break;
                case 2:
                    int i = 0;
                    for (IndexPlaceable it5 : sp) {
                        i += it5.getPlaceable().getMeasuredWidth();
                    }
                    width = RangesKt.coerceAtMost(i, Constraints.getMaxWidth-impl(constraints.unbox-impl()));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, width, height, (Map) null, new Function1() { // from class: kntr.common.trio.priority.ComposePriorityHorizonKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit PriorityHorizon$lambda$0$0$7;
                    PriorityHorizon$lambda$0$0$7 = ComposePriorityHorizonKt.PriorityHorizon$lambda$0$0$7(sp, $verticalAlignment, height, (Placeable.PlacementScope) obj);
                    return PriorityHorizon$lambda$0$0$7;
                }
            }, 4, (Object) null);
        }
        throw new NoSuchElementException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriorityHorizon$lambda$0$0$0(Function3 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C30@860L9:ComposePriorityHorizon.kt#1hw4x4");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2082497104, $changed, -1, "kntr.common.trio.priority.PriorityHorizon.<anonymous>.<anonymous>.<anonymous> (ComposePriorityHorizon.kt:30)");
            }
            $content.invoke(PriorityHorizontalScopeInstance.INSTANCE, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriorityHorizon$lambda$0$0$7(List $sp, Alignment.Vertical $verticalAlignment, int $height, Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        int offset = 0;
        List $this$forEach$iv = $sp;
        for (Object element$iv : $this$forEach$iv) {
            IndexPlaceable it = (IndexPlaceable) element$iv;
            Placeable.PlacementScope.place$default($this$layout, it.getPlaceable(), offset, $verticalAlignment.align(it.getPlaceable().getHeight(), $height), 0.0f, 4, (Object) null);
            offset += it.getPlaceable().getMeasuredWidth();
        }
        return Unit.INSTANCE;
    }
}