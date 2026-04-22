package kntr.app.tribee.publish.internal;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* compiled from: KeyboardAnimationState.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\n\u0010\u0004\u001a\u00020\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0005\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"rememberKeyboardAnimationState", "Lkntr/app/tribee/publish/internal/KeyboardAnimationState;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/tribee/publish/internal/KeyboardAnimationState;", "ui_debug", "animationState", "previousHeight", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KeyboardAnimationStateKt {
    public static final KeyboardAnimationState rememberKeyboardAnimationState(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1695976068, "C(rememberKeyboardAnimationState)21@699L56,22@782L33,23@849L3,23@876L7,25@916L361,25@890L387:KeyboardAnimationState.kt#1zy72f");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695976068, $changed, -1, "kntr.app.tribee.publish.internal.rememberKeyboardAnimationState (KeyboardAnimationState.kt:20)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -2040393260, "CC(remember):KeyboardAnimationState.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(KeyboardAnimationState.Idle, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        MutableState animationState$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -2040390627, "CC(remember):KeyboardAnimationState.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        MutableIntState previousHeight$delegate = (MutableIntState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        WindowInsets ime = WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer, 6);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        int imeHeight = ime.getBottom((Density) consume);
        Integer valueOf = Integer.valueOf(imeHeight);
        ComposerKt.sourceInformationMarkerStart($composer, -2040386011, "CC(remember):KeyboardAnimationState.kt#9igjgp");
        boolean invalid$iv = $composer.changed(imeHeight);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = (Function2) new KeyboardAnimationStateKt$rememberKeyboardAnimationState$1$1(imeHeight, previousHeight$delegate, animationState$delegate, null);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv3, $composer, 0);
        KeyboardAnimationState rememberKeyboardAnimationState$lambda$1 = rememberKeyboardAnimationState$lambda$1(animationState$delegate);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return rememberKeyboardAnimationState$lambda$1;
    }

    private static final KeyboardAnimationState rememberKeyboardAnimationState$lambda$1(MutableState<KeyboardAnimationState> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KeyboardAnimationState) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int rememberKeyboardAnimationState$lambda$4(MutableIntState $previousHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $previousHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }
}