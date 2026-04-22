package kntr.common.compose.pulltorefresh;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.bilitheme.compose.pulltorefresh.generated.resources.Drawable0_commonMainKt;
import srcs.common.bilitheme.compose.pulltorefresh.generated.resources.Res;

/* compiled from: PullToRefreshIndicator.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0017\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\b\u001a-\u0010\t\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u008e\u0002"}, d2 = {"PullToRefreshIndicator", "", "state", "Lkntr/common/compose/pulltorefresh/PullToRefreshState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/compose/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "LoadAnimation", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AnimatedImageSequence", "imageResIds", "", "Lorg/jetbrains/compose/resources/DrawableResource;", "frameDurationMs", "", "(Landroidx/compose/ui/Modifier;Ljava/util/List;JLandroidx/compose/runtime/Composer;II)V", "compose-pulltorefresh_debug", "currentFrameIndex", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PullToRefreshIndicatorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedImageSequence$lambda$5(Modifier modifier, List list, long j, int i, int i2, Composer composer, int i3) {
        AnimatedImageSequence(modifier, list, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadAnimation$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        LoadAnimation(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshIndicator$lambda$3(PullToRefreshState pullToRefreshState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PullToRefreshIndicator(pullToRefreshState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0296  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PullToRefreshIndicator(final PullToRefreshState state, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-1279198334);
        ComposerKt.sourceInformation($composer2, "C(PullToRefreshIndicator)N(state,modifier)35@1620L7,41@1809L165,36@1660L888:PullToRefreshIndicator.kt#8f2f3d");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1279198334, $dirty, -1, "kntr.common.compose.pulltorefresh.PullToRefreshIndicator (PullToRefreshIndicator.kt:33)");
            }
            float indicatorHeight = Dp.constructor-impl(40);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$PullToRefreshIndicator_u24lambda_u240 = (Density) consume;
            final float indicatorHeightPx = $this$PullToRefreshIndicator_u24lambda_u240.toPx-0680j_4(indicatorHeight);
            Modifier modifier4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), indicatorHeight);
            ComposerKt.sourceInformationMarkerStart($composer2, -948940473, "CC(remember):PullToRefreshIndicator.kt#9igjgp");
            boolean invalid$iv = (($dirty & 14) == 4) | $composer2.changed(indicatorHeightPx);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit PullToRefreshIndicator$lambda$1$0;
                        PullToRefreshIndicator$lambda$1$0 = PullToRefreshIndicatorKt.PullToRefreshIndicator$lambda$1$0(PullToRefreshState.this, indicatorHeightPx, (GraphicsLayerScope) obj);
                        return PullToRefreshIndicator$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv$iv = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) it$iv);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            Modifier modifier5 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1853089003, "C:PullToRefreshIndicator.kt#8f2f3d");
            if (!state.isRefreshing() && (state.isRefreshing() || !state.isPullInProgress() || state.getContentOffset() < state.getRefreshTriggerDistancePx())) {
                $composer2.startReplaceGroup(1853310993);
                ComposerKt.sourceInformation($composer2, "54@2378L45,53@2345L187");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIndicatorFrame1(Res.drawable.INSTANCE), $composer2, 0), (String) null, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier5;
            }
            $composer2.startReplaceGroup(1853229308);
            ComposerKt.sourceInformation($composer2, "51@2267L48");
            LoadAnimation(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6, 0);
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PullToRefreshIndicator$lambda$3;
                    PullToRefreshIndicator$lambda$3 = PullToRefreshIndicatorKt.PullToRefreshIndicator$lambda$3(PullToRefreshState.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PullToRefreshIndicator$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PullToRefreshIndicator$lambda$1$0(PullToRefreshState $state, float $indicatorHeightPx, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        float trans = $state.getContentOffset() - (($state.getRefreshingOffsetPx() + $indicatorHeightPx) / 2);
        $this$graphicsLayer.setTranslationY(trans);
        return Unit.INSTANCE;
    }

    public static final void LoadAnimation(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(-1269006710);
        ComposerKt.sourceInformation($composer2, "C(LoadAnimation)N(modifier)64@2619L329:PullToRefreshIndicator.kt#8f2f3d");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1269006710, $dirty2, -1, "kntr.common.compose.pulltorefresh.LoadAnimation (PullToRefreshIndicator.kt:63)");
            }
            AnimatedImageSequence(modifier, CollectionsKt.listOf(new DrawableResource[]{Drawable0_commonMainKt.getIndicatorFrame1(Res.drawable.INSTANCE), Drawable0_commonMainKt.getIndicatorFrame2(Res.drawable.INSTANCE), Drawable0_commonMainKt.getIndicatorFrame3(Res.drawable.INSTANCE), Drawable0_commonMainKt.getIndicatorFrame4(Res.drawable.INSTANCE)}), 150L, $composer2, ($dirty2 & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadAnimation$lambda$0;
                    LoadAnimation$lambda$0 = PullToRefreshIndicatorKt.LoadAnimation$lambda$0(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadAnimation$lambda$0;
                }
            });
        }
    }

    public static final void AnimatedImageSequence(Modifier modifier, final List<DrawableResource> list, final long frameDurationMs, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(list, "imageResIds");
        Composer $composer2 = $composer.startRestartGroup(724930093);
        ComposerKt.sourceInformation($composer2, "C(AnimatedImageSequence)N(modifier,imageResIds,frameDurationMs)85@3201L33,87@3261L151,87@3240L172,94@3418L126:PullToRefreshIndicator.kt#8f2f3d");
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
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(frameDurationMs) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(724930093, $dirty2, -1, "kntr.common.compose.pulltorefresh.AnimatedImageSequence (PullToRefreshIndicator.kt:82)");
            }
            $composer2.startReplaceGroup(873122866);
            ComposerKt.sourceInformation($composer2, "*83@3148L20");
            List<DrawableResource> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                DrawableResource resId = (DrawableResource) item$iv$iv;
                destination$iv$iv.add(ImageResourcesKt.imageResource(resId, $composer2, 0));
            }
            List imageBitmaps = (List) destination$iv$iv;
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer2, 873125038, "CC(remember):PullToRefreshIndicator.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableIntState currentFrameIndex$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 873127076, "CC(remember):PullToRefreshIndicator.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(imageBitmaps) | (($dirty2 & 896) == 256);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new PullToRefreshIndicatorKt$AnimatedImageSequence$1$1(frameDurationMs, imageBitmaps, currentFrameIndex$delegate, null);
                $composer2.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer2, 6);
            ImageKt.Image-5h-nEew((ImageBitmap) imageBitmaps.get(AnimatedImageSequence$lambda$2(currentFrameIndex$delegate)), (String) null, modifier4, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, 0, $composer2, (($dirty2 << 6) & 896) | 48, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.compose.pulltorefresh.PullToRefreshIndicatorKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AnimatedImageSequence$lambda$5;
                    AnimatedImageSequence$lambda$5 = PullToRefreshIndicatorKt.AnimatedImageSequence$lambda$5(modifier5, list, frameDurationMs, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AnimatedImageSequence$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedImageSequence$lambda$2(MutableIntState $currentFrameIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $currentFrameIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }
}