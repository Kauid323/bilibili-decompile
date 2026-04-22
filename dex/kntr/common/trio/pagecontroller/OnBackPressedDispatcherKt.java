package kntr.common.trio.pagecontroller;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a>\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u001b\u0010\u0007\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\t*\u00060\u0003j\u0002`\u0004H\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"addCallback", "Landroidx/activity/OnBackPressedCallback;", "Lkntr/common/trio/pagecontroller/OnBackPressedCallback;", "Landroidx/activity/OnBackPressedDispatcher;", "Lkntr/common/trio/pagecontroller/OnBackPressedDispatcher;", "enabled", "", "onBackPressed", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/activity/OnBackPressedDispatcher;ZLkotlin/jvm/functions/Function1;)Landroidx/activity/OnBackPressedCallback;", "awaitBackPressed", "(Landroidx/activity/OnBackPressedDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trio_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OnBackPressedDispatcherKt {
    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return addCallback(onBackPressedDispatcher, z, function1);
    }

    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher $this$addCallback, boolean enabled, Function1<? super OnBackPressedCallback, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$addCallback, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onBackPressed");
        OnBackPressedCallback callback = OnBackPressedCallback_androidKt.OnBackPressedCallback(enabled, function1);
        $this$addCallback.addCallback(callback);
        return callback;
    }

    public static final Object awaitBackPressed(OnBackPressedDispatcher $this$awaitBackPressed, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation it = cancellableContinuationImpl;
        final OnBackPressedCallback callback = OnBackPressedCallback_androidKt.OnBackPressedCallback(true, new Function1<OnBackPressedCallback, Unit>() { // from class: kntr.common.trio.pagecontroller.OnBackPressedDispatcherKt$awaitBackPressed$2$callback$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((OnBackPressedCallback) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(OnBackPressedCallback $this$OnBackPressedCallback) {
                Intrinsics.checkNotNullParameter($this$OnBackPressedCallback, "$this$OnBackPressedCallback");
                Result.Companion companion = Result.Companion;
                it.resumeWith(Result.m2636constructorimpl(Unit.INSTANCE));
                $this$OnBackPressedCallback.remove();
            }
        });
        it.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kntr.common.trio.pagecontroller.OnBackPressedDispatcherKt$awaitBackPressed$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it2) {
                callback.remove();
            }
        });
        $this$awaitBackPressed.addCallback(callback);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}