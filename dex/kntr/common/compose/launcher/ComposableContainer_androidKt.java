package kntr.common.compose.launcher;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.ProvideLocalsScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ComposableContainer.android.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0001¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"platformLocalsInComposable", "Lkotlin/Function1;", "Lkntr/common/komponent/ProvideLocalsScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function1;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableContainer_androidKt {
    public static final Function1<ProvideLocalsScope, Unit> platformLocalsInComposable(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 702073481, "C(platformLocalsInComposable)8@307L7,9@326L45:ComposableContainer.android.kt#2jy5aq");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(702073481, $changed, -1, "kntr.common.compose.launcher.platformLocalsInComposable (ComposableContainer.android.kt:7)");
        }
        CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Context context = (Context) consume;
        ComposerKt.sourceInformationMarkerStart($composer, 382753622, "CC(remember):ComposableContainer.android.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(context);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.common.compose.launcher.ComposableContainer_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit platformLocalsInComposable$lambda$0$0;
                    platformLocalsInComposable$lambda$0$0 = ComposableContainer_androidKt.platformLocalsInComposable$lambda$0$0(context, (ProvideLocalsScope) obj);
                    return platformLocalsInComposable$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function1<ProvideLocalsScope, Unit> function1 = (Function1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit platformLocalsInComposable$lambda$0$0(Context $context, ProvideLocalsScope provideLocalsScope) {
        Intrinsics.checkNotNullParameter(provideLocalsScope, "<this>");
        provideLocalsScope.provides(LocalContextKt.getLocalContext(), $context);
        return Unit.INSTANCE;
    }
}