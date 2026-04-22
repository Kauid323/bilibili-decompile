package kntr.common.ouro.ui.textField;

import androidx.compose.ui.platform.PlatformTextInputInterceptor;
import androidx.compose.ui.platform.PlatformTextInputMethodRequest;
import androidx.compose.ui.platform.PlatformTextInputSession;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OuroComposeTextField.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1 implements PlatformTextInputInterceptor {
    final /* synthetic */ boolean $disableIme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1(boolean z) {
        this.$disableIme = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object interceptStartInputMethod(PlatformTextInputMethodRequest req, PlatformTextInputSession handler, Continuation<?> continuation) {
        OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1 ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1;
        if (continuation instanceof OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1) {
            ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1 = (OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1) continuation;
            if ((ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label & Integer.MIN_VALUE) != 0) {
                ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label -= Integer.MIN_VALUE;
                Object $result = ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (this.$disableIme) {
                            ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$0 = SpillingKt.nullOutSpilledVariable(req);
                            ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$1 = SpillingKt.nullOutSpilledVariable(handler);
                            ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label = 1;
                            if (DelayKt.awaitCancellation(ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw new KotlinNothingValueException();
                        }
                        ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$0 = SpillingKt.nullOutSpilledVariable(req);
                        ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$1 = SpillingKt.nullOutSpilledVariable(handler);
                        ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label = 2;
                        if (handler.startInputMethod(req, ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        throw new KotlinNothingValueException();
                    case 1:
                        PlatformTextInputSession platformTextInputSession = (PlatformTextInputSession) ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$1;
                        PlatformTextInputMethodRequest platformTextInputMethodRequest = (PlatformTextInputMethodRequest) ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$0;
                        ResultKt.throwOnFailure($result);
                        throw new KotlinNothingValueException();
                    case 2:
                        PlatformTextInputSession platformTextInputSession2 = (PlatformTextInputSession) ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$1;
                        PlatformTextInputMethodRequest platformTextInputMethodRequest2 = (PlatformTextInputMethodRequest) ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.L$0;
                        ResultKt.throwOnFailure($result);
                        throw new KotlinNothingValueException();
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1 = new OuroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1(this, continuation);
        Object $result2 = ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ouroComposeTextFieldKt$OuroComposeTextField$4$1$2$1$interceptStartInputMethod$1.label) {
        }
    }
}