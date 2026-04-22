package tv.danmaku.bili.sms;

import android.widget.CheckBox;
import android.widget.EditText;
import com.bilibili.lib.accountsui.sms.ISmsLoginPresenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.reg.LoginRegHelper;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmsLoginDialogActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.sms.SmsLoginDialogActivityV2$getCode$2", f = "SmsLoginDialogActivityV2.kt", i = {}, l = {BR.titleMaxLines}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginDialogActivityV2$getCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SmsLoginDialogActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginDialogActivityV2$getCode$2(SmsLoginDialogActivityV2 smsLoginDialogActivityV2, Continuation<? super SmsLoginDialogActivityV2$getCode$2> continuation) {
        super(2, continuation);
        this.this$0 = smsLoginDialogActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginDialogActivityV2$getCode$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LoginEulaDialogViewDelegate loginEulaDialogViewDelegate;
        Object $result2;
        AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener;
        Object $result3;
        ISmsLoginPresenter iSmsLoginPresenter;
        CheckBox checkBox;
        CheckBox checkBox2;
        EditText editText;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setEulaDialogVisibility(true);
                loginEulaDialogViewDelegate = this.this$0.eulaDelegate;
                if (loginEulaDialogViewDelegate == null) {
                    $result2 = null;
                    break;
                } else {
                    EulaTriggerType eulaTriggerType = EulaTriggerType.GetSms;
                    int btnId = EulaTriggerType.GetSms.getBtnId();
                    clickLinkItemListener = this.this$0.clickEulaLinkListener2;
                    this.label = 1;
                    Object show = loginEulaDialogViewDelegate.show(LoginReporterV2.PAGE_TYPE_SMS2, true, eulaTriggerType, btnId, (Map<String, String>) null, (String) null, clickLinkItemListener, (Continuation) this);
                    if (show != coroutine_suspended) {
                        $result3 = $result;
                        $result = show;
                        if (((Boolean) $result).booleanValue()) {
                            $result2 = null;
                            break;
                        } else {
                            $result2 = 1;
                            break;
                        }
                    } else {
                        return coroutine_suspended;
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                if (((Boolean) $result).booleanValue()) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if ($result2 != null) {
            iSmsLoginPresenter = this.this$0.mPresenter;
            if (iSmsLoginPresenter != null) {
                editText = this.this$0.mPhoneEditText;
                iSmsLoginPresenter.sendCaptcha(String.valueOf(editText != null ? editText.getText() : null));
            }
            checkBox = this.this$0.mLoginRegCheckBox;
            if (checkBox != null) {
                checkBox.setChecked(true);
            }
            checkBox2 = this.this$0.mLoginRegCheckBox;
            LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN2, checkBox2);
        }
        this.this$0.setEulaDialogVisibility(false);
        return Unit.INSTANCE;
    }
}