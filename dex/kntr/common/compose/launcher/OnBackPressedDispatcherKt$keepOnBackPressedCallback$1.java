package kntr.common.compose.launcher;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.compose.launcher.OnBackPressedDispatcherKt", f = "OnBackPressedDispatcher.kt", i = {0, 0}, l = {16}, m = "keepOnBackPressedCallback", n = {"$this$keepOnBackPressedCallback", "callback"}, s = {"L$0", "L$1"}, v = 1)
public final class OnBackPressedDispatcherKt$keepOnBackPressedCallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnBackPressedDispatcherKt$keepOnBackPressedCallback$1(Continuation<? super OnBackPressedDispatcherKt$keepOnBackPressedCallback$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OnBackPressedDispatcherKt.keepOnBackPressedCallback(null, null, (Continuation) this);
    }
}