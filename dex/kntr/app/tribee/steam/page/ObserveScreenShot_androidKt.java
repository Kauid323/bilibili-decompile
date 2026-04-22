package kntr.app.tribee.steam.page;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.screenshot.ScreenshotLocalContext;
import kntr.common.screenshot.ScreenshotProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ObserveScreenShot.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a-\u0010\u0007\u001a\u00020\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ObserveScreenshot", "", "screenshotProvider", "Lkntr/common/screenshot/ScreenshotProvider;", "onScreenshot", "Lkotlin/Function0;", "(Lkntr/common/screenshot/ScreenshotProvider;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ObserveLifecycle", "onStart", "onStop", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ObserveScreenShot_androidKt {

    /* compiled from: ObserveScreenShot.android.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveLifecycle$lambda$3(Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        ObserveLifecycle(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveScreenshot$lambda$3(ScreenshotProvider screenshotProvider, Function0 function0, int i, Composer composer, int i2) {
        ObserveScreenshot(screenshotProvider, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ObserveScreenshot(final ScreenshotProvider screenshotProvider, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(screenshotProvider, "screenshotProvider");
        Intrinsics.checkNotNullParameter(function0, "onScreenshot");
        Composer $composer2 = $composer.startRestartGroup(-1486558694);
        ComposerKt.sourceInformation($composer2, "C(ObserveScreenshot)N(screenshotProvider,onScreenshot)16@522L27,18@577L227,27@845L181,31@1045L185,26@809L428:ObserveScreenShot.android.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(screenshotProvider) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1486558694, $dirty, -1, "kntr.app.tribee.steam.page.ObserveScreenshot (ObserveScreenShot.android.kt:15)");
            }
            final ScreenshotLocalContext context = TribeeScreenshotLocalContextKt.provideScreenLocalContext($composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1641210429, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new TribeeScreenshotListener(new Function1() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit ObserveScreenshot$lambda$0$0;
                        ObserveScreenshot$lambda$0$0 = ObserveScreenShot_androidKt.ObserveScreenshot$lambda$0$0(function0, (String) obj);
                        return ObserveScreenshot$lambda$0$0;
                    }
                });
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeScreenshotListener listener = (TribeeScreenshotListener) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1641218959, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(screenshotProvider) | $composer2.changedInstance(context);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit ObserveScreenshot$lambda$1$0;
                        ObserveScreenshot$lambda$1$0 = ObserveScreenShot_androidKt.ObserveScreenshot$lambda$1$0(ScreenshotProvider.this, context, listener);
                        return ObserveScreenshot$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function02 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1641225363, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(screenshotProvider) | $composer2.changedInstance(context);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit ObserveScreenshot$lambda$2$0;
                        ObserveScreenshot$lambda$2$0 = ObserveScreenShot_androidKt.ObserveScreenshot$lambda$2$0(ScreenshotProvider.this, context, listener);
                        return ObserveScreenshot$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ObserveLifecycle(function02, (Function0) it$iv3, $composer2, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit ObserveScreenshot$lambda$3;
                    ObserveScreenshot$lambda$3 = ObserveScreenShot_androidKt.ObserveScreenshot$lambda$3(ScreenshotProvider.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ObserveScreenshot$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveScreenshot$lambda$0$0(Function0 $onScreenshot, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KLog_androidKt.getKLog().i("ScreenshotObserver", "Screenshot taken: " + it);
        $onScreenshot.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveScreenshot$lambda$1$0(ScreenshotProvider $screenshotProvider, ScreenshotLocalContext $context, TribeeScreenshotListener $listener) {
        KLog_androidKt.getKLog().i("ScreenshotObserver", "Registered screenshot observer");
        $screenshotProvider.registerContentObserver($context, $listener);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ObserveScreenshot$lambda$2$0(ScreenshotProvider $screenshotProvider, ScreenshotLocalContext $context, TribeeScreenshotListener $listener) {
        KLog_androidKt.getKLog().i("ScreenshotObserver", "Unregistered screenshot observer");
        $screenshotProvider.unregisterContentObserver($context, $listener);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v7 */
    private static final void ObserveLifecycle(Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Function0 function03;
        final Function0 onStop;
        final Function0 onStart;
        Composer $composer2 = $composer.startRestartGroup(782202107);
        ComposerKt.sourceInformation($composer2, "C(ObserveLifecycle)N(onStart,onStop)40@1309L2,41@1338L2,43@1391L7,45@1454L436,45@1404L486:ObserveScreenShot.android.kt#k3l5ii");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            function03 = function0;
        } else if (($changed & 6) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? 4 : 2;
        } else {
            function03 = function0;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            onStop = function02;
        } else if (($changed & 48) == 0) {
            onStop = function02;
            $dirty |= $composer2.changedInstance(onStop) ? 32 : 16;
        } else {
            onStop = function02;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            onStart = function03;
        } else {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 76949565, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onStart2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onStart = onStart2;
            } else {
                onStart = function03;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 76950493, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onStop2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onStop = onStop2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(782202107, $dirty2, -1, "kntr.app.tribee.steam.page.ObserveLifecycle (ObserveScreenShot.android.kt:42)");
            }
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 76954639, "CC(remember):ObserveScreenShot.android.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (($dirty2 & 112) == 32) | $composer2.changedInstance(lifecycleOwner);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        DisposableEffectResult ObserveLifecycle$lambda$2$0;
                        ObserveLifecycle$lambda$2$0 = ObserveScreenShot_androidKt.ObserveLifecycle$lambda$2$0(lifecycleOwner, onStart, onStop, (DisposableEffectScope) obj);
                        return ObserveLifecycle$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(lifecycleOwner, onStart, onStop, (Function1) it$iv3, $composer2, (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit ObserveLifecycle$lambda$3;
                    ObserveLifecycle$lambda$3 = ObserveScreenShot_androidKt.ObserveLifecycle$lambda$3(onStart, onStop, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ObserveLifecycle$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ObserveLifecycle$lambda$2$0(final LifecycleOwner $lifecycleOwner, final Function0 $onStart, final Function0 $onStop, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$$ExternalSyntheticLambda0
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                ObserveScreenShot_androidKt.ObserveLifecycle$lambda$2$0$0($onStart, $onStop, lifecycleOwner, event);
            }
        };
        $lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: kntr.app.tribee.steam.page.ObserveScreenShot_androidKt$ObserveLifecycle$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                $lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ObserveLifecycle$lambda$2$0$0(Function0 $onStart, Function0 $onStop, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                $onStart.invoke();
                return;
            case 2:
                $onStop.invoke();
                return;
            default:
                return;
        }
    }
}