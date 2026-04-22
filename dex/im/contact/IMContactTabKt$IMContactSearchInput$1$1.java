package im.contact;

import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMContactTab.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.contact.IMContactTabKt$IMContactSearchInput$1$1", f = "IMContactTab.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMContactTabKt$IMContactSearchInput$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focus;
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ boolean $inSearchMode;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMContactTabKt$IMContactSearchInput$1$1(boolean z, FocusRequester focusRequester, FocusManager focusManager, Continuation<? super IMContactTabKt$IMContactSearchInput$1$1> continuation) {
        super(2, continuation);
        this.$inSearchMode = z;
        this.$focus = focusRequester;
        this.$focusManager = focusManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMContactTabKt$IMContactSearchInput$1$1(this.$inSearchMode, this.$focus, this.$focusManager, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$inSearchMode) {
                    Boxing.boxBoolean(FocusRequester.requestFocus-3ESFkO8$default(this.$focus, 0, 1, (Object) null));
                } else {
                    FocusManager.-CC.clearFocus$default(this.$focusManager, false, 1, (Object) null);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}