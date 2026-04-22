package kntr.app.appwidget.guide;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.util.Consumer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.appwidget.guide.model.WidgetGuidePopupParams;
import kntr.app.appwidget.guide.ui.AppWidgetGuidePopupState;
import kntr.app.appwidget.guide.ui.AppWidgetGuidePopupStateKt;
import kntr.app.appwidget.guide.utils.DisplayExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformContext.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u00072\u0006\u0010\b\u001a\u00020\tH\u0080@¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\f"}, d2 = {"VIEW_TAG", RoomRecommendViewModel.EMPTY_CURSOR, "PlatformContext", "Landroidx/fragment/app/FragmentActivity;", "showGuidePopup", RoomRecommendViewModel.EMPTY_CURSOR, "context", "Lkntr/app/appwidget/guide/PlatformContext;", "params", "Lkntr/app/appwidget/guide/model/WidgetGuidePopupParams;", "(Landroidx/fragment/app/FragmentActivity;Lkntr/app/appwidget/guide/model/WidgetGuidePopupParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "closeGuidePopup", "guide_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PlatformContext_androidKt {
    private static final String VIEW_TAG = "AppWidgetGuidePopupComposeView";

    public static final Object showGuidePopup(final FragmentActivity context, final WidgetGuidePopupParams params, Continuation<? super Unit> continuation) {
        if (!context.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            return Unit.INSTANCE;
        }
        ViewGroup rootView = (ViewGroup) context.findViewById(16908290);
        ComposeView it = rootView.findViewWithTag(VIEW_TAG);
        if (it != null) {
            rootView.removeView((View) it);
        }
        final ComposeView $this$showGuidePopup_u24lambda_u241 = new ComposeView((Context) context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$showGuidePopup_u24lambda_u241.setTag(VIEW_TAG);
        $this$showGuidePopup_u24lambda_u241.setContent(ComposableLambdaKt.composableLambdaInstance(2137943424, true, new Function2() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit showGuidePopup$lambda$1$0;
                showGuidePopup$lambda$1$0 = PlatformContext_androidKt.showGuidePopup$lambda$1$0(WidgetGuidePopupParams.this, context, (Composer) obj, ((Integer) obj2).intValue());
                return showGuidePopup$lambda$1$0;
            }
        }));
        rootView.addView((View) $this$showGuidePopup_u24lambda_u241);
        $this$showGuidePopup_u24lambda_u241.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$showGuidePopup$3
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View v) {
                Intrinsics.checkNotNullParameter(v, "v");
                if ($this$showGuidePopup_u24lambda_u241.getHasComposition()) {
                    $this$showGuidePopup_u24lambda_u241.disposeComposition();
                }
                $this$showGuidePopup_u24lambda_u241.removeOnAttachStateChangeListener(this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGuidePopup$lambda$1$0(final WidgetGuidePopupParams $params, final FragmentActivity $context, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C45@1492L2654,45@1482L2664:PlatformContext.android.kt#q5xzkp");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2137943424, $changed, -1, "kntr.app.appwidget.guide.showGuidePopup.<anonymous>.<anonymous> (PlatformContext.android.kt:45)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1836166456, true, new Function2() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit showGuidePopup$lambda$1$0$0;
                    showGuidePopup$lambda$1$0$0 = PlatformContext_androidKt.showGuidePopup$lambda$1$0$0(WidgetGuidePopupParams.this, $context, (Composer) obj, ((Integer) obj2).intValue());
                    return showGuidePopup$lambda$1$0$0;
                }
            }, $composer, 54), $composer, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showGuidePopup$lambda$1$0$0(final WidgetGuidePopupParams $params, final FragmentActivity $context, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C46@1530L39,47@1609L14,49@1668L1043,49@1645L1066,70@2733L48,71@2823L1305,71@2802L1326:PlatformContext.android.kt#q5xzkp");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1836166456, $changed, -1, "kntr.app.appwidget.guide.showGuidePopup.<anonymous>.<anonymous>.<anonymous> (PlatformContext.android.kt:46)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -675593185, "CC(remember):PlatformContext.android.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new AppWidgetGuidePopupState();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AppWidgetGuidePopupState hostState = (AppWidgetGuidePopupState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            int displayWidth = DisplayExtKt.displayWidth($composer, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -675587765, "CC(remember):PlatformContext.android.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($params) | $composer.changedInstance($context);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult showGuidePopup$lambda$1$0$0$1$0;
                        showGuidePopup$lambda$1$0$0$1$0 = PlatformContext_androidKt.showGuidePopup$lambda$1$0$0$1$0($context, $params, (DisposableEffectScope) obj);
                        return showGuidePopup$lambda$1$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.DisposableEffect(unit, (Function1) it$iv2, $composer, 6);
            AppWidgetGuidePopupStateKt.AppWidgetGuidePopupHost(hostState, displayWidth, $composer, 6, 0);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -675550543, "CC(remember):PlatformContext.android.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($params) | $composer.changedInstance($context);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new PlatformContext_androidKt$showGuidePopup$composeView$1$1$1$2$1(hostState, $params, $context, null);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv3, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult showGuidePopup$lambda$1$0$0$1$0(final FragmentActivity $context, final WidgetGuidePopupParams $params, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final Consumer configurationChangeListener = new Consumer() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$$ExternalSyntheticLambda1
            public final void accept(Object obj) {
                PlatformContext_androidKt.showGuidePopup$lambda$1$0$0$1$0$0(WidgetGuidePopupParams.this, $context, (Configuration) obj);
            }
        };
        $context.addOnConfigurationChangedListener(configurationChangeListener);
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$$ExternalSyntheticLambda2
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                PlatformContext_androidKt.showGuidePopup$lambda$1$0$0$1$0$1(WidgetGuidePopupParams.this, $context, lifecycleOwner, event);
            }
        };
        $context.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: kntr.app.appwidget.guide.PlatformContext_androidKt$showGuidePopup$lambda$1$0$0$1$0$$inlined$onDispose$1
            public void dispose() {
                $context.removeOnConfigurationChangedListener(configurationChangeListener);
                $context.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuidePopup$lambda$1$0$0$1$0$0(WidgetGuidePopupParams $params, FragmentActivity $context, Configuration it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $params.getDismiss().invoke(false);
        closeGuidePopup($context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGuidePopup$lambda$1$0$0$1$0$1(WidgetGuidePopupParams $params, FragmentActivity $context, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_STOP) {
            $params.getDismiss().invoke(false);
            closeGuidePopup($context);
        }
    }

    public static final void closeGuidePopup(FragmentActivity context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ViewGroup rootView = (ViewGroup) context.findViewById(16908290);
        ComposeView it = rootView.findViewWithTag(VIEW_TAG);
        if (it != null) {
            rootView.removeView((View) it);
        }
    }
}