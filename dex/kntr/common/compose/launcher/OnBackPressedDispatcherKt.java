package kntr.common.compose.launcher;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.komponent.KomponentLocal;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentLocalKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* compiled from: OnBackPressedDispatcher.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\b2\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0086@¢\u0006\u0002\u0010\f\"\u001b\u0010\u0000\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"localOnBackPressedDispatcher", "Lkntr/common/komponent/KomponentLocal;", "Landroidx/activity/OnBackPressedDispatcher;", "Lkntr/common/trio/pagecontroller/OnBackPressedDispatcher;", "getLocalOnBackPressedDispatcher", "()Lkntr/common/komponent/KomponentLocal;", "keepOnBackPressedCallback", "", "Lkntr/common/komponent/KomponentLocalAccessScope;", "callback", "Landroidx/activity/OnBackPressedCallback;", "Lkntr/common/trio/pagecontroller/OnBackPressedCallback;", "(Lkntr/common/komponent/KomponentLocalAccessScope;Landroidx/activity/OnBackPressedCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OnBackPressedDispatcherKt {
    private static final KomponentLocal<OnBackPressedDispatcher> localOnBackPressedDispatcher = KomponentLocalKt.komponentLocal$default(null, new Function1() { // from class: kntr.common.compose.launcher.OnBackPressedDispatcherKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            OnBackPressedDispatcher localOnBackPressedDispatcher$lambda$0;
            localOnBackPressedDispatcher$lambda$0 = OnBackPressedDispatcherKt.localOnBackPressedDispatcher$lambda$0((KomponentLocalAccessScope) obj);
            return localOnBackPressedDispatcher$lambda$0;
        }
    }, 1, null);

    public static final KomponentLocal<OnBackPressedDispatcher> getLocalOnBackPressedDispatcher() {
        return localOnBackPressedDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OnBackPressedDispatcher localOnBackPressedDispatcher$lambda$0(KomponentLocalAccessScope $this$komponentLocal) {
        Intrinsics.checkNotNullParameter($this$komponentLocal, "$this$komponentLocal");
        throw new IllegalStateException("No OnBackPressedDispatcher value provided.".toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object keepOnBackPressedCallback(KomponentLocalAccessScope $this$keepOnBackPressedCallback, OnBackPressedCallback callback, Continuation<? super Unit> continuation) {
        OnBackPressedDispatcherKt$keepOnBackPressedCallback$1 onBackPressedDispatcherKt$keepOnBackPressedCallback$1;
        try {
            if (continuation instanceof OnBackPressedDispatcherKt$keepOnBackPressedCallback$1) {
                onBackPressedDispatcherKt$keepOnBackPressedCallback$1 = (OnBackPressedDispatcherKt$keepOnBackPressedCallback$1) continuation;
                if ((onBackPressedDispatcherKt$keepOnBackPressedCallback$1.label & Integer.MIN_VALUE) != 0) {
                    onBackPressedDispatcherKt$keepOnBackPressedCallback$1.label -= Integer.MIN_VALUE;
                    Object $result = onBackPressedDispatcherKt$keepOnBackPressedCallback$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (onBackPressedDispatcherKt$keepOnBackPressedCallback$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            ((OnBackPressedDispatcher) $this$keepOnBackPressedCallback.getCurrent(localOnBackPressedDispatcher)).addCallback(callback);
                            onBackPressedDispatcherKt$keepOnBackPressedCallback$1.L$0 = SpillingKt.nullOutSpilledVariable($this$keepOnBackPressedCallback);
                            onBackPressedDispatcherKt$keepOnBackPressedCallback$1.L$1 = callback;
                            onBackPressedDispatcherKt$keepOnBackPressedCallback$1.label = 1;
                            if (DelayKt.awaitCancellation(onBackPressedDispatcherKt$keepOnBackPressedCallback$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            callback = (OnBackPressedCallback) onBackPressedDispatcherKt$keepOnBackPressedCallback$1.L$1;
                            KomponentLocalAccessScope komponentLocalAccessScope = (KomponentLocalAccessScope) onBackPressedDispatcherKt$keepOnBackPressedCallback$1.L$0;
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw new KotlinNothingValueException();
                }
            }
            switch (onBackPressedDispatcherKt$keepOnBackPressedCallback$1.label) {
            }
            throw new KotlinNothingValueException();
        } catch (Throwable th) {
            callback.remove();
            throw th;
        }
        onBackPressedDispatcherKt$keepOnBackPressedCallback$1 = new OnBackPressedDispatcherKt$keepOnBackPressedCallback$1(continuation);
        Object $result2 = onBackPressedDispatcherKt$keepOnBackPressedCallback$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }
}