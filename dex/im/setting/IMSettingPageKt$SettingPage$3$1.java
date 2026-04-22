package im.setting;

import im.base.IMToast;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.IMSettingPageKt$SettingPage$3$1", f = "IMSettingPage.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class IMSettingPageKt$SettingPage$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SettingViewModel $settingViewModel;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSettingPageKt$SettingPage$3$1(SettingViewModel settingViewModel, Toaster toaster, Continuation<? super IMSettingPageKt$SettingPage$3$1> continuation) {
        super(2, continuation);
        this.$settingViewModel = settingViewModel;
        this.$toaster = toaster;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSettingPageKt$SettingPage$3$1(this.$settingViewModel, this.$toaster, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<IMToast> toastFlow = this.$settingViewModel.getToastFlow();
                final Toaster toaster = this.$toaster;
                this.label = 1;
                if (toastFlow.collect(new FlowCollector() { // from class: im.setting.IMSettingPageKt$SettingPage$3$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IMToast) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IMToast it, Continuation<? super Unit> continuation) {
                        Toaster.-CC.showToast$default(toaster, it.getContent(), (ToastDuration) null, 2, (Object) null);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}