package kntr.app.appwidget.guide.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"AppWidgetGuidePopupHost", RoomRecommendViewModel.EMPTY_CURSOR, "popupState", "Lkntr/app/appwidget/guide/ui/AppWidgetGuidePopupState;", "windowWidth", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/appwidget/guide/ui/AppWidgetGuidePopupState;ILandroidx/compose/runtime/Composer;II)V", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppWidgetGuidePopupStateKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppWidgetGuidePopupHost$lambda$2(AppWidgetGuidePopupState appWidgetGuidePopupState, int i, int i2, int i3, Composer composer, int i4) {
        AppWidgetGuidePopupHost(appWidgetGuidePopupState, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0123, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AppWidgetGuidePopupHost(final AppWidgetGuidePopupState popupState, int windowWidth, Composer $composer, final int $changed, final int i) {
        int i2;
        final int windowWidth2;
        Intrinsics.checkNotNullParameter(popupState, "popupState");
        Composer $composer2 = $composer.startRestartGroup(1440828875);
        ComposerKt.sourceInformation($composer2, "C(AppWidgetGuidePopupHost)N(popupState,windowWidth)26@896L111,26@863L144:AppWidgetGuidePopupState.kt#88uxtj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(popupState) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            i2 = windowWidth;
        } else if (($changed & 48) == 0) {
            i2 = windowWidth;
            $dirty |= $composer2.changed(i2) ? 32 : 16;
        } else {
            i2 = windowWidth;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            windowWidth2 = i2;
        } else {
            if (i3 != 0) {
                windowWidth2 = 0;
            } else {
                windowWidth2 = i2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1440828875, $dirty2, -1, "kntr.app.appwidget.guide.ui.AppWidgetGuidePopupHost (AppWidgetGuidePopupState.kt:24)");
            }
            final PopupData currentPopupData = popupState.getCurrentPopupData();
            ComposerKt.sourceInformationMarkerStart($composer2, 1657085850, "CC(remember):AppWidgetGuidePopupState.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(currentPopupData);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1(currentPopupData, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(currentPopupData, (Function2) it$iv, $composer2, 0);
            if (currentPopupData == null) {
                $composer2.startReplaceGroup(-169797060);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-169797059);
                ComposerKt.sourceInformation($composer2, "*41@1393L34,42@1439L219,33@1044L614");
                Alignment bottomCenter = Alignment.Companion.getBottomCenter();
                int y$iv = currentPopupData.getOffset();
                long j2 = IntOffset.constructor-impl((0 << 32) | (y$iv & 4294967295L));
                PopupProperties popupProperties = new PopupProperties(false, true, currentPopupData.getOutsideTouchable(), false, 9, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart($composer2, -1437309604, "CC(remember):AppWidgetGuidePopupState.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(currentPopupData);
                Object it$iv2 = $composer2.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = new Function0() { // from class: kntr.app.appwidget.guide.ui.AppWidgetGuidePopupStateKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit AppWidgetGuidePopupHost$lambda$1$0$0;
                        AppWidgetGuidePopupHost$lambda$1$0$0 = AppWidgetGuidePopupStateKt.AppWidgetGuidePopupHost$lambda$1$0$0(PopupData.this);
                        return AppWidgetGuidePopupHost$lambda$1$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidPopup_androidKt.Popup-K5zGePQ(bottomCenter, j2, (Function0) it$iv2, popupProperties, ComposableLambdaKt.rememberComposableLambda(-1082125763, true, new Function2() { // from class: kntr.app.appwidget.guide.ui.AppWidgetGuidePopupStateKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AppWidgetGuidePopupHost$lambda$1$1;
                        AppWidgetGuidePopupHost$lambda$1$1 = AppWidgetGuidePopupStateKt.AppWidgetGuidePopupHost$lambda$1$1(PopupData.this, currentPopupData, windowWidth2, (Composer) obj, ((Integer) obj2).intValue());
                        return AppWidgetGuidePopupHost$lambda$1$1;
                    }
                }, $composer2, 54), $composer2, 24582, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.appwidget.guide.ui.AppWidgetGuidePopupStateKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AppWidgetGuidePopupHost$lambda$2;
                    AppWidgetGuidePopupHost$lambda$2 = AppWidgetGuidePopupStateKt.AppWidgetGuidePopupHost$lambda$2(AppWidgetGuidePopupState.this, windowWidth2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AppWidgetGuidePopupHost$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppWidgetGuidePopupHost$lambda$1$0$0(PopupData $currentPopupData) {
        $currentPopupData.dismiss(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppWidgetGuidePopupHost$lambda$1$1(PopupData $it, PopupData $currentPopupData, int $windowWidth, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:AppWidgetGuidePopupState.kt#88uxtj");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1082125763, $changed, -1, "kntr.app.appwidget.guide.ui.AppWidgetGuidePopupHost.<anonymous>.<anonymous> (AppWidgetGuidePopupState.kt:43)");
            }
            if ($it.getStyle() == 0) {
                $composer.startReplaceGroup(-540770856);
                ComposerKt.sourceInformation($composer, "44@1492L59");
                GuideContentV1Kt.GuideContentV1($currentPopupData, Integer.valueOf($windowWidth), $composer, 0, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-540768138);
                ComposerKt.sourceInformation($composer, "46@1577L57");
                GuideContentKt.GuideContent($currentPopupData, Integer.valueOf($windowWidth), $composer, 0, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}