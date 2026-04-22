package kntr.app.mall.product.details.page.ui.components;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a|\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010\u0018\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052#\b\u0002\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001b\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u001c\")\u0010\u001a\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"reportOnExposure", "Landroidx/compose/ui/Modifier;", "key", "", "collectorHolder", "Lkntr/app/mall/product/details/page/ui/components/CollectorHolder;", "collectorFactory", "Lkotlin/Function1;", "Lkntr/app/mall/product/details/page/ui/components/ExposureConfig;", "Lkotlin/ParameterName;", "name", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/app/mall/product/details/page/ui/components/IExposureCollector;", "repeatable", "", "visibleProportion", "", "visiblePixelAbsolute", "", "visibleDuration", "", "onExpose", "Lkotlin/Function0;", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkntr/app/mall/product/details/page/ui/components/CollectorHolder;Lkotlin/jvm/functions/Function1;ZFIJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Ljava/lang/Object;Lkntr/app/mall/product/details/page/ui/components/CollectorHolder;Lkotlin/jvm/functions/Function1;Lkntr/app/mall/product/details/page/ui/components/ExposureConfig;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "defaultCollectorFactory", "rememberCollectorHolder", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/mall/product/details/page/ui/components/CollectorHolder;", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExposerKt {
    private static final Function1<ExposureConfig, IExposureCollector> defaultCollectorFactory = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ExposerKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            DefaultExposureCollector defaultCollectorFactory$lambda$0;
            defaultCollectorFactory$lambda$0 = ExposerKt.defaultCollectorFactory$lambda$0((ExposureConfig) obj);
            return defaultCollectorFactory$lambda$0;
        }
    };

    public static final Modifier reportOnExposure(Modifier $this$reportOnExposure, Object key, CollectorHolder collectorHolder, Function1<? super ExposureConfig, ? extends IExposureCollector> function1, boolean repeatable, float visibleProportion, int visiblePixelAbsolute, long visibleDuration, Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Function1 collectorFactory;
        boolean repeatable2;
        float visibleProportion2;
        int visiblePixelAbsolute2;
        long visibleDuration2;
        Intrinsics.checkNotNullParameter($this$reportOnExposure, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(collectorHolder, "collectorHolder");
        Intrinsics.checkNotNullParameter(function0, "onExpose");
        ComposerKt.sourceInformationMarkerStart($composer, 1281639195, "C(reportOnExposure)N(key,collectorHolder,collectorFactory,repeatable,visibleProportion,visiblePixelAbsolute,visibleDuration,onExpose)40@1350L74:Exposer.kt#o90vz8");
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
            ComposerKt.traceEventStart(1281639195, $changed, -1, "kntr.app.mall.product.details.page.ui.components.reportOnExposure (Exposer.kt:32)");
        }
        ExposureConfig config = new ExposureConfig(repeatable2, visibleProportion2, visiblePixelAbsolute2, visibleDuration2);
        Modifier reportOnExposure = reportOnExposure($this$reportOnExposure, key, collectorHolder, collectorFactory, config, function0, $composer, ($changed & 14) | ($changed & 112) | ($changed & 896) | ($changed & 7168) | (($changed >> 9) & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return reportOnExposure;
    }

    public static final Modifier reportOnExposure(Modifier $this$reportOnExposure, final Object key, final CollectorHolder collectorHolder, Function1<? super ExposureConfig, ? extends IExposureCollector> function1, ExposureConfig config, final Function0<Unit> function0, Composer $composer, int $changed, int i) {
        Function1 collectorFactory;
        ExposureConfig config2;
        Intrinsics.checkNotNullParameter($this$reportOnExposure, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(collectorHolder, "collectorHolder");
        Intrinsics.checkNotNullParameter(function0, "onExpose");
        ComposerKt.sourceInformationMarkerStart($composer, 634371959, "C(reportOnExposure)N(key,collectorHolder,collectorFactory,config,onExpose):Exposer.kt#o90vz8");
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
            ComposerKt.traceEventStart(634371959, $changed, -1, "kntr.app.mall.product.details.page.ui.components.reportOnExposure (Exposer.kt:50)");
        }
        final ExposureConfig exposureConfig = config2;
        final Function1 function12 = collectorFactory;
        Modifier composed$default = ComposedModifierKt.composed$default($this$reportOnExposure, (Function1) null, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.ExposerKt$$ExternalSyntheticLambda0
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
        $composer.startReplaceGroup(803425087);
        ComposerKt.sourceInformation($composer, "C52@1813L156,52@1782L187,62@1996L520:Exposer.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(803425087, $changed, -1, "kntr.app.mall.product.details.page.ui.components.reportOnExposure.<anonymous> (Exposer.kt:51)");
        }
        final IExposureCollector collector = $collectorHolder.get($key, $config, $collectorFactory);
        ComposerKt.sourceInformationMarkerStart($composer, -1002601061, "CC(remember):Exposer.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(collector) | $composer.changed($onExpose);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new ExposerKt$reportOnExposure$1$1$1(collector, $onExpose, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect($key, collector, (Function2) it$iv, $composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, -1002594841, "CC(remember):Exposer.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(collector);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.app.mall.product.details.page.ui.components.ExposerKt$$ExternalSyntheticLambda1
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
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        return new DefaultExposureCollector(config);
    }

    public static final CollectorHolder rememberCollectorHolder(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -146275331, "C(rememberCollectorHolder)146@4845L42:Exposer.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-146275331, $changed, -1, "kntr.app.mall.product.details.page.ui.components.rememberCollectorHolder (Exposer.kt:146)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1163329415, "CC(remember):Exposer.kt#9igjgp");
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
}