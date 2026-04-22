package tv.danmaku.bili.stepbystep.sms;

import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.platform.SoftwareKeyboardController;
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
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginCompose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.stepbystep.sms.StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1", f = "StepByStepSmsLoginCompose.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ SoftwareKeyboardController $keyboardController;
    final /* synthetic */ StepByStepSmsLoginPhonePage $pageState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1(StepByStepSmsLoginPhonePage stepByStepSmsLoginPhonePage, FocusRequester focusRequester, SoftwareKeyboardController softwareKeyboardController, Continuation<? super StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1> continuation) {
        super(2, continuation);
        this.$pageState = stepByStepSmsLoginPhonePage;
        this.$focusRequester = focusRequester;
        this.$keyboardController = softwareKeyboardController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StepByStepSmsLoginComposeKt$LoginSmsPhonePage$1$1(this.$pageState, this.$focusRequester, this.$keyboardController, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                FocusState focusState = this.$pageState.getFocusState();
                if (!(focusState != null && focusState.getHasFocus())) {
                    Boxing.boxBoolean(FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, (Object) null));
                } else {
                    SoftwareKeyboardController softwareKeyboardController = this.$keyboardController;
                    if (softwareKeyboardController != null) {
                        softwareKeyboardController.show();
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}