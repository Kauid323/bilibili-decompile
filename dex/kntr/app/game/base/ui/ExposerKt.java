package kntr.app.game.base.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001a`\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001b\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u001c\u001a \u0010#\u001a\u00020\u00172\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b%H\u0007¢\u0006\u0002\u0010&\")\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00050\u001e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"reportOnExposure", "Landroidx/compose/ui/Modifier;", "key", RoomRecommendViewModel.EMPTY_CURSOR, "collectorHolder", "Lkntr/app/game/base/ui/CollectorHolder;", "collectorFactory", "Lkotlin/Function1;", "Lkntr/app/game/base/ui/ExposureConfig;", "Lkotlin/ParameterName;", "name", "config", "Lkntr/app/game/base/ui/IExposureCollector;", "repeatable", RoomRecommendViewModel.EMPTY_CURSOR, "visibleProportion", RoomRecommendViewModel.EMPTY_CURSOR, "visiblePixelAbsolute", RoomRecommendViewModel.EMPTY_CURSOR, "visibleDuration", RoomRecommendViewModel.EMPTY_CURSOR, "onExpose", "Lkotlin/Function0;", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkntr/app/game/base/ui/CollectorHolder;Lkotlin/jvm/functions/Function1;ZFIJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkntr/app/game/base/ui/CollectorHolder;Lkotlin/jvm/functions/Function1;Lkntr/app/game/base/ui/ExposureConfig;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "defaultCollectorFactory", "rememberCollectorHolder", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/game/base/ui/CollectorHolder;", "LocalExposeCollectorHolder", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalExposeCollectorHolder$annotations", "()V", "getLocalExposeCollectorHolder", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "BiligameExposureComposable", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExposerKt {
    private static final Function1<ExposureConfig, IExposureCollector> defaultCollectorFactory = new Function1() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            DefaultExposureCollector defaultCollectorFactory$lambda$0;
            defaultCollectorFactory$lambda$0 = ExposerKt.defaultCollectorFactory$lambda$0((ExposureConfig) obj);
            return defaultCollectorFactory$lambda$0;
        }
    };
    private static final ProvidableCompositionLocal<CollectorHolder> LocalExposeCollectorHolder = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            CollectorHolder LocalExposeCollectorHolder$lambda$0;
            LocalExposeCollectorHolder$lambda$0 = ExposerKt.LocalExposeCollectorHolder$lambda$0();
            return LocalExposeCollectorHolder$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameExposureComposable$lambda$1(Function2 function2, int i, Composer composer, int i2) {
        BiligameExposureComposable(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getLocalExposeCollectorHolder$annotations() {
    }

    public static final Modifier reportOnExposure(Modifier $this$reportOnExposure, Object key, CollectorHolder collectorHolder, Function1<? super ExposureConfig, ? extends IExposureCollector> function1, boolean repeatable, float visibleProportion, int visiblePixelAbsolute, long visibleDuration, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        CollectorHolder collectorHolder2;
        Function1 collectorFactory;
        boolean repeatable2;
        float visibleProportion2;
        int visiblePixelAbsolute2;
        long visibleDuration2;
        Intrinsics.checkNotNullParameter($this$reportOnExposure, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "onExpose");
        ComposerKt.sourceInformationMarkerStart($composer, 792660358, "C(reportOnExposure)N(key,collectorHolder,collectorFactory,repeatable,visibleProportion,visiblePixelAbsolute,visibleDuration,onExpose)28@965L7,43@1499L74:Exposer.kt#5u3tm7");
        if ((i & 2) != 0) {
            CompositionLocal this_$iv = LocalExposeCollectorHolder;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            collectorHolder2 = (CollectorHolder) consume;
        } else {
            collectorHolder2 = collectorHolder;
        }
        if ((i & 4) != 0) {
            collectorFactory = defaultCollectorFactory;
        } else {
            collectorFactory = function1;
        }
        if ((i & 8) == 0) {
            repeatable2 = repeatable;
        } else {
            repeatable2 = false;
        }
        if ((i & 16) == 0) {
            visibleProportion2 = visibleProportion;
        } else {
            visibleProportion2 = 0.0f;
        }
        if ((i & 32) == 0) {
            visiblePixelAbsolute2 = visiblePixelAbsolute;
        } else {
            visiblePixelAbsolute2 = 1;
        }
        if ((i & 64) == 0) {
            visibleDuration2 = visibleDuration;
        } else {
            visibleDuration2 = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(792660358, $changed, -1, "kntr.app.game.base.ui.reportOnExposure (Exposer.kt:35)");
        }
        ExposureConfig config = new ExposureConfig(repeatable2, visibleProportion2, visiblePixelAbsolute2, visibleDuration2);
        Modifier reportOnExposure = reportOnExposure($this$reportOnExposure, key, collectorHolder2, collectorFactory, config, function0, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (($changed >> 9) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return reportOnExposure;
    }

    public static final Modifier reportOnExposure(Modifier $this$reportOnExposure, final Object key, CollectorHolder collectorHolder, Function1<? super ExposureConfig, ? extends IExposureCollector> function1, ExposureConfig config, final Function0<Unit> function0, Composer $composer, int $changed, int i) {
        CollectorHolder collectorHolder2;
        Function1 collectorFactory;
        ExposureConfig config2;
        Intrinsics.checkNotNullParameter($this$reportOnExposure, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function0, "onExpose");
        ComposerKt.sourceInformationMarkerStart($composer, 1564243626, "C(reportOnExposure)N(key,collectorHolder,collectorFactory,config,onExpose)49@1700L7:Exposer.kt#5u3tm7");
        if ((i & 2) != 0) {
            CompositionLocal this_$iv = LocalExposeCollectorHolder;
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            collectorHolder2 = (CollectorHolder) consume;
        } else {
            collectorHolder2 = collectorHolder;
        }
        if ((i & 4) != 0) {
            collectorFactory = defaultCollectorFactory;
        } else {
            collectorFactory = function1;
        }
        if ((i & 8) == 0) {
            config2 = config;
        } else {
            config2 = new ExposureConfig(false, 0.0f, 0, 0L, 15, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1564243626, $changed, -1, "kntr.app.game.base.ui.reportOnExposure (Exposer.kt:53)");
        }
        final CollectorHolder collectorHolder3 = collectorHolder2;
        final ExposureConfig exposureConfig = config2;
        final Function1 function12 = collectorFactory;
        Modifier composed$default = ComposedModifierKt.composed$default($this$reportOnExposure, (Function1) null, new Function3() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier reportOnExposure$lambda$0;
                reportOnExposure$lambda$0 = ExposerKt.reportOnExposure$lambda$0(CollectorHolder.this, key, exposureConfig, function12, function0, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return reportOnExposure$lambda$0;
            }
        }, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return composed$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier reportOnExposure$lambda$0(CollectorHolder $collectorHolder, Object $key, ExposureConfig $config, Function1 $collectorFactory, Function0 $onExpose, Modifier $this$composed, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(1220798434);
        ComposerKt.sourceInformation($composer, "C55@1999L156,55@1968L187,65@2182L520:Exposer.kt#5u3tm7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1220798434, $changed, -1, "kntr.app.game.base.ui.reportOnExposure.<anonymous> (Exposer.kt:54)");
        }
        final IExposureCollector collector = $collectorHolder.get($key, $config, $collectorFactory);
        ComposerKt.sourceInformationMarkerStart($composer, 661226878, "CC(remember):Exposer.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(collector) | $composer.changed($onExpose);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new ExposerKt$reportOnExposure$1$1$1(collector, $onExpose, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($key, collector, (Function2) it$iv, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 661233098, "CC(remember):Exposer.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(collector);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit reportOnExposure$lambda$0$1$0;
                    reportOnExposure$lambda$0$1$0 = ExposerKt.reportOnExposure$lambda$0$1$0(IExposureCollector.this, (LayoutCoordinates) obj);
                    return reportOnExposure$lambda$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned($this$composed, (Function1) it$iv2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return onGloballyPositioned;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportOnExposure$lambda$0$1$0(IExposureCollector $collector, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow$default(layoutCoordinates, false, 1, (Object) null);
        long localTopLeft = layoutCoordinates.windowToLocal-MK-Hz9U(boundsInWindow.getTopLeft-F1C5BW0());
        long localBottomRight = layoutCoordinates.windowToLocal-MK-Hz9U(boundsInWindow.getBottomRight-F1C5BW0());
        Rect visibleBound = RectKt.Rect-0a9Yr6o(localTopLeft, localBottomRight);
        Rect fullBound = new Rect(0.0f, 0.0f, (int) (layoutCoordinates.getSize-YbymL2g() >> 32), (int) (layoutCoordinates.getSize-YbymL2g() & 4294967295L));
        $collector.onCollect(new VisibleLayoutInfo(visibleBound, fullBound));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultExposureCollector defaultCollectorFactory$lambda$0(ExposureConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new DefaultExposureCollector(config);
    }

    public static final CollectorHolder rememberCollectorHolder(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -671908380, "C(rememberCollectorHolder)149@5031L42:Exposer.kt#5u3tm7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-671908380, $changed, -1, "kntr.app.game.base.ui.rememberCollectorHolder (Exposer.kt:149)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1458857042, "CC(remember):Exposer.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new CollectorHolder();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        CollectorHolder collectorHolder = (CollectorHolder) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return collectorHolder;
    }

    public static final ProvidableCompositionLocal<CollectorHolder> getLocalExposeCollectorHolder() {
        return LocalExposeCollectorHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectorHolder LocalExposeCollectorHolder$lambda$0() {
        throw new IllegalStateException("CompositionLocal LocalExposeCollectorHolder not present".toString());
    }

    public static final void BiligameExposureComposable(final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1196140996);
        ComposerKt.sourceInformation($composer2, "C(BiligameExposureComposable)N(content)167@5605L25,168@5719L25,168@5635L109:Exposer.kt#5u3tm7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1196140996, $dirty, -1, "kntr.app.game.base.ui.BiligameExposureComposable (Exposer.kt:166)");
            }
            CollectorHolder exposeCollectorHolder = rememberCollectorHolder($composer2, 0);
            CompositionLocalKt.CompositionLocalProvider(LocalExposeCollectorHolder.provides(exposeCollectorHolder), ComposableLambdaKt.rememberComposableLambda(-351827204, true, new Function2() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameExposureComposable$lambda$0;
                    BiligameExposureComposable$lambda$0 = ExposerKt.BiligameExposureComposable$lambda$0(function2, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameExposureComposable$lambda$0;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.ExposerKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameExposureComposable$lambda$1;
                    BiligameExposureComposable$lambda$1 = ExposerKt.BiligameExposureComposable$lambda$1(function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameExposureComposable$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameExposureComposable$lambda$0(Function2 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C169@5729L9:Exposer.kt#5u3tm7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-351827204, $changed, -1, "kntr.app.game.base.ui.BiligameExposureComposable.<anonymous> (Exposer.kt:169)");
            }
            $content.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}