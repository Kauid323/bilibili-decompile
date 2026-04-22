package kntr.app.im.chat.ui.utils;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: PictureLifecycleKeyHandle.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lkntr/app/im/chat/ui/utils/PictureLifecycleKeyHandle;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "pageState", "Landroidx/compose/runtime/MutableState;", RoomRecommendViewModel.EMPTY_CURSOR, "innerState", "innerInt", "Landroidx/compose/runtime/MutableIntState;", "key", RoomRecommendViewModel.EMPTY_CURSOR, "getKey", "()I", "trigger", RoomRecommendViewModel.EMPTY_CURSOR, "start", "register", "Landroidx/compose/runtime/State;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PictureLifecycleKeyHandle {
    public static final int $stable = 0;
    private final MutableState<Boolean> pageState = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableState<Boolean> innerState = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private final MutableIntState innerInt = SnapshotIntStateKt.mutableIntStateOf(0);

    public final int getKey() {
        return this.innerInt.getValue().intValue();
    }

    public final void trigger(boolean start) {
        this.pageState.setValue(Boolean.valueOf(start));
    }

    public final State<Boolean> register(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1011358559, "C(register)28@924L7,29@961L359,29@940L380,40@1350L198,40@1329L219:PictureLifecycleKeyHandle.kt#we9gw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1011358559, $changed, -1, "kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle.register (PictureLifecycleKeyHandle.kt:27)");
        }
        CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1252962136, "CC(remember):PictureLifecycleKeyHandle.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(this)) || ($changed & 6) == 4) | $composer.changedInstance(lifecycleOwner);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new PictureLifecycleKeyHandle$register$1$1(lifecycleOwner, this, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
        Unit unit2 = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1252949849, "CC(remember):PictureLifecycleKeyHandle.kt#9igjgp");
        boolean invalid$iv2 = ((($changed & 14) ^ 6) > 4 && $composer.changed(this)) || ($changed & 6) == 4;
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new PictureLifecycleKeyHandle$register$2$1(this, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit2, (Function2) it$iv2, $composer, 6);
        State<Boolean> state = this.innerState;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }
}