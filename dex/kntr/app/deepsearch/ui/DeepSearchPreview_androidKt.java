package kntr.app.deepsearch.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bilibili.base.BiliContext;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchPreview.android.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0007¢\u0006\u0002\u0010\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"ConfigWindow", RoomRecommendViewModel.EMPTY_CURSOR, "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "getImeHeight", "Landroidx/compose/runtime/IntState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/IntState;", "getWindowY", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)I", "getAppWindowTopOnScreen", "activity", "Landroid/app/Activity;", "setSupportImmersiveStatusBar", "window", "Landroid/view/Window;", "isNight", RoomRecommendViewModel.EMPTY_CURSOR, "rememberAppVisibleState", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "compose_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeepSearchPreview_androidKt {
    public static final void ConfigWindow(Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(function2, "block");
        ComposerKt.sourceInformationMarkerStart($composer, 1441700542, "CC(ConfigWindow)N(block)31@1201L7:DeepSearchPreview.android.kt#7uvpm4");
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Activity activity = ContextUtilKt.findActivityOrNull((Context) consume);
        if (Build.VERSION.SDK_INT < 30 && activity != null) {
            $composer.startReplaceGroup(28068508);
            ComposerKt.sourceInformation($composer, "33@1325L13,34@1394L251,34@1370L275");
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -1800206695, "CC(remember):DeepSearchPreview.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(activity) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new DeepSearchPreview_androidKt$ConfigWindow$1$1(activity, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(28421133);
            ComposerKt.sourceInformation($composer, "40@1667L7");
            function2.invoke($composer, Integer.valueOf($changed & 14));
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    public static final IntState getImeHeight(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1552893851, "C(getImeHeight)47@1759L53,50@1848L3,50@1875L7:DeepSearchPreview.android.kt#7uvpm4");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1552893851, $changed, -1, "kntr.app.deepsearch.ui.getImeHeight (DeepSearchPreview.android.kt:45)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1977337254, "CC(remember):DeepSearchPreview.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        IntState intState = (MutableIntState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        WindowInsets ime = WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer, 6);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        intState.setIntValue(ime.getBottom((Density) consume));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return intState;
    }

    public static final int getWindowY(Composer $composer, int $changed) {
        int i;
        ComposerKt.sourceInformationMarkerStart($composer, -649256645, "C(getWindowY)56@1979L7:DeepSearchPreview.android.kt#7uvpm4");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-649256645, $changed, -1, "kntr.app.deepsearch.ui.getWindowY (DeepSearchPreview.android.kt:55)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Context context = (Context) consume;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            Activity it = activity;
            i = getAppWindowTopOnScreen(it);
        } else {
            i = 0;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return i;
    }

    private static final int getAppWindowTopOnScreen(Activity activity) {
        int[] location = new int[2];
        activity.getWindow().getDecorView().getLocationOnScreen(location);
        return location[1];
    }

    public static final void setSupportImmersiveStatusBar(Window window, boolean isNight) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT > 28) {
            window.addFlags(67108864);
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            int flags = decorView.getSystemUiVisibility();
            if (!isNight) {
                decorView.setSystemUiVisibility(flags | 8192);
                return;
            } else {
                decorView.setSystemUiVisibility(flags & (-8193));
                return;
            }
        }
        window.setStatusBarColor(ColorKt.toArgb-8_81llA(Color.Companion.getTransparent-0d7_KjU()));
    }

    public static final State<Boolean> rememberAppVisibleState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1517175165, "C(rememberAppVisibleState)92@3099L53,95@3180L843,95@3157L866:DeepSearchPreview.android.kt#7uvpm4");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1517175165, $changed, -1, "kntr.app.deepsearch.ui.rememberAppVisibleState (DeepSearchPreview.android.kt:90)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 2011422578, "CC(remember):DeepSearchPreview.android.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final State<Boolean> state = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 2011425960, "CC(remember):DeepSearchPreview.android.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.ui.DeepSearchPreview_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    DisposableEffectResult rememberAppVisibleState$lambda$1$0;
                    rememberAppVisibleState$lambda$1$0 = DeepSearchPreview_androidKt.rememberAppVisibleState$lambda$1$0(state, (DisposableEffectScope) obj);
                    return rememberAppVisibleState$lambda$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.DisposableEffect(unit, (Function1) it$iv2, $composer, 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [kntr.app.deepsearch.ui.DeepSearchPreview_androidKt$rememberAppVisibleState$1$1$callback$1] */
    public static final DisposableEffectResult rememberAppVisibleState$lambda$1$0(final MutableState $state, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final ?? r0 = new BiliContext.ActivityStateCallback() { // from class: kntr.app.deepsearch.ui.DeepSearchPreview_androidKt$rememberAppVisibleState$1$1$callback$1
            public void onVisibleCountChanged(Activity activity, int lastVisibleCount, int currentVisibleCount) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                super.onVisibleCountChanged(activity, lastVisibleCount, currentVisibleCount);
                if (lastVisibleCount > 0 && currentVisibleCount <= 0) {
                    $state.setValue(false);
                } else if (lastVisibleCount <= 0 && currentVisibleCount > 0) {
                    $state.setValue(true);
                }
            }
        };
        BiliContext.registerActivityStateCallback((BiliContext.ActivityStateCallback) r0);
        return new DisposableEffectResult() { // from class: kntr.app.deepsearch.ui.DeepSearchPreview_androidKt$rememberAppVisibleState$lambda$1$0$$inlined$onDispose$1
            public void dispose() {
                BiliContext.unregisterActivityStateCallback(DeepSearchPreview_androidKt$rememberAppVisibleState$1$1$callback$1.this);
            }
        };
    }
}