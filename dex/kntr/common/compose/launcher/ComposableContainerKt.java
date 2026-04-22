package kntr.common.compose.launcher;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.ProvideLocalsScope;
import kntr.common.komponent.UiComposableLike;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ComposableContainer.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"runInComposable", "Lkntr/common/komponent/UiComposableLike;", "S", "Lkntr/common/komponent/Komponent;", "(Lkntr/common/komponent/Komponent;Landroidx/compose/runtime/Composer;I)Lkntr/common/komponent/UiComposableLike;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableContainerKt {
    public static final <S> UiComposableLike<S> runInComposable(Komponent<? extends S> komponent, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(komponent, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1484479976, "C(runInComposable)16@648L24,17@702L7,18@773L7,19@826L7,20@865L7,21@898L28,22@938L431:ComposableContainer.kt#2jy5aq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1484479976, $changed, -1, "kntr.common.compose.launcher.runInComposable (ComposableContainer.kt:15)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = RouterKt.getLocalRouter();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Router router = (Router) consume;
        final OnBackPressedDispatcher onBackPressedDispatcher = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
        CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(this_$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
        CompositionLocal this_$iv3 = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume3 = $composer.consume(this_$iv3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Toaster toaster = (Toaster) consume3;
        final Function1 platformLocals = ComposableContainer_androidKt.platformLocalsInComposable($composer, 0);
        ComposerKt.sourceInformationMarkerStart($composer, 656127159, "CC(remember):ComposableContainer.kt#9igjgp");
        boolean invalid$iv = $composer.changed(komponent);
        Object value$iv = $composer.rememberedValue();
        if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
            value$iv = KomponentKt.actIn(komponent, coroutineScope, new Function1() { // from class: kntr.common.compose.launcher.ComposableContainerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit runInComposable$lambda$0$0;
                    runInComposable$lambda$0$0 = ComposableContainerKt.runInComposable$lambda$0$0(Router.this, onBackPressedDispatcher, lifecycleOwner, toaster, platformLocals, (ProvideLocalsScope) obj);
                    return runInComposable$lambda$0$0;
                }
            });
            $composer.updateRememberedValue(value$iv);
        }
        UiComposableLike<S> uiComposableLike = (UiComposableLike) value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return uiComposableLike;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit runInComposable$lambda$0$0(Router $router, OnBackPressedDispatcher $onBackPressedDispatcher, LifecycleOwner $lifecycleOwner, Toaster $toaster, Function1 $platformLocals, ProvideLocalsScope $this$actIn) {
        Intrinsics.checkNotNullParameter($this$actIn, "$this$actIn");
        $this$actIn.provides(KomponentRouterKt.getLocalRouter(), $router);
        $this$actIn.provides(OnBackPressedDispatcherKt.getLocalOnBackPressedDispatcher(), $onBackPressedDispatcher);
        $this$actIn.provides(LifecycleKt.getLocalLifecycleOwner(), $lifecycleOwner);
        $this$actIn.provides(LocalToasterKt.getLocalToaster(), $toaster);
        if ($platformLocals != null) {
            $platformLocals.invoke($this$actIn);
        }
        return Unit.INSTANCE;
    }
}