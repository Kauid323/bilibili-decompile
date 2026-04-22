package kntr.common.trio.pagecontroller;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.backhandler.BackHandler_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.navigationevent.DirectNavigationEventInput;
import androidx.navigationevent.NavigationEventDispatcher;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.compose.RememberNavigationEventDispatcherOwnerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackHandler.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001aA\u0010\n\u001a\u00020\u000b*\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"BackHandler", "", "enabled", "", "onBack", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "rememberDirectNavigationEventInput", "Landroidx/navigationevent/DirectNavigationEventInput;", "(Landroidx/compose/runtime/Composer;I)Landroidx/navigationevent/DirectNavigationEventInput;", "goBackOnClick", "Landroidx/compose/ui/Modifier;", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "goBackOnClick-cJG_KMw", "(Landroidx/compose/ui/Modifier;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/Modifier;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BackHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackHandler$lambda$0(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        BackHandler(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void BackHandler(final boolean enabled, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Composer $composer2 = $composer.startRestartGroup(1398274161);
        ComposerKt.sourceInformation($composer2, "C(BackHandler)N(enabled,onBack)21@764L28:BackHandler.kt#yqq3oh");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(enabled) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                enabled = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1398274161, $dirty, -1, "kntr.common.trio.pagecontroller.BackHandler (BackHandler.kt:18)");
            }
            BackHandler_androidKt.BackHandler(enabled, function0, $composer2, ($dirty & 14) | ($dirty & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.trio.pagecontroller.BackHandlerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackHandler$lambda$0;
                    BackHandler$lambda$0 = BackHandlerKt.BackHandler$lambda$0(enabled, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackHandler$lambda$0;
                }
            });
        }
    }

    public static final DirectNavigationEventInput rememberDirectNavigationEventInput(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1183470821, "C(rememberDirectNavigationEventInput)26@915L40,27@993L101:BackHandler.kt#yqq3oh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1183470821, $changed, -1, "kntr.common.trio.pagecontroller.rememberDirectNavigationEventInput (BackHandler.kt:25)");
        }
        NavigationEventDispatcher navigationEventDispatcher = RememberNavigationEventDispatcherOwnerKt.rememberNavigationEventDispatcherOwner(false, (NavigationEventDispatcherOwner) null, $composer, 0, 3).getNavigationEventDispatcher();
        ComposerKt.sourceInformationMarkerStart($composer, 850880480, "CC(remember):BackHandler.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new DirectNavigationEventInput();
            navigationEventDispatcher.addInput((NavigationEventInput) value$iv);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        DirectNavigationEventInput directNavigationEventInput = (DirectNavigationEventInput) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return directNavigationEventInput;
    }

    /* renamed from: goBackOnClick-cJG_KMw  reason: not valid java name */
    public static final Modifier m2419goBackOnClickcJG_KMw(Modifier $this$goBackOnClick_u2dcJG_KMw, boolean enabled, String onClickLabel, Role role, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i) {
        Object m2636constructorimpl;
        Intrinsics.checkNotNullParameter($this$goBackOnClick_u2dcJG_KMw, "$this$goBackOnClick");
        ComposerKt.sourceInformationMarkerStart($composer, -1636860088, "C(goBackOnClick)N(enabled,onClickLabel,role:c#ui.semantics.Role,interactionSource)39@1359L7,42@1546L261:BackHandler.kt#yqq3oh");
        if ((i & 1) != 0) {
            enabled = true;
        }
        if ((i & 2) != 0) {
            onClickLabel = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        if ((i & 8) != 0) {
            interactionSource = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1636860088, $changed, -1, "kntr.common.trio.pagecontroller.goBackOnClick (BackHandler.kt:38)");
        }
        final OnBackPressedDispatcher onBackPressedDispatcher = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, 6);
        $composer.startReplaceGroup(-1064504516);
        ComposerKt.sourceInformation($composer, "*41@1426L36");
        try {
            Result.Companion companion = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(rememberDirectNavigationEventInput($composer, 0));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        $composer.endReplaceGroup();
        if (Result.m2642isFailureimpl(m2636constructorimpl)) {
            m2636constructorimpl = null;
        }
        final DirectNavigationEventInput directNavigationEventInput = (DirectNavigationEventInput) m2636constructorimpl;
        ComposerKt.sourceInformationMarkerStart($composer, -1064500019, "CC(remember):BackHandler.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(onBackPressedDispatcher) | $composer.changedInstance(directNavigationEventInput);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.common.trio.pagecontroller.BackHandlerKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit goBackOnClick_cJG_KMw$lambda$1$0;
                    goBackOnClick_cJG_KMw$lambda$1$0 = BackHandlerKt.goBackOnClick_cJG_KMw$lambda$1$0(onBackPressedDispatcher, directNavigationEventInput);
                    return goBackOnClick_cJG_KMw$lambda$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier = ClickableKt.clickable-oSLSa3U($this$goBackOnClick_u2dcJG_KMw, enabled, onClickLabel, role, interactionSource, (Function0) it$iv);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit goBackOnClick_cJG_KMw$lambda$1$0(OnBackPressedDispatcher $onBackPressedDispatcher, DirectNavigationEventInput $directNavigationEventInput) {
        $onBackPressedDispatcher.onBackPressed();
        if ($directNavigationEventInput != null) {
            $directNavigationEventInput.backCompleted();
        }
        return Unit.INSTANCE;
    }
}