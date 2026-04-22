package tv.danmaku.bili.sms;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "tv.danmaku.bili.sms.SmsLoginDialogActivityV2$checkLoginReg$1", f = "SmsLoginDialogActivityV2.kt", i = {}, l = {BR.subContent}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmsLoginDialogActivityV2$checkLoginReg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $login;
    int label;
    final /* synthetic */ SmsLoginDialogActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginDialogActivityV2$checkLoginReg$1(SmsLoginDialogActivityV2 smsLoginDialogActivityV2, Function0<Unit> function0, Continuation<? super SmsLoginDialogActivityV2$checkLoginReg$1> continuation) {
        super(2, continuation);
        this.this$0 = smsLoginDialogActivityV2;
        this.$login = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmsLoginDialogActivityV2$checkLoginReg$1(this.this$0, this.$login, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        View view;
        LoginEulaDialogViewDelegate loginEulaDialogViewDelegate;
        Object $result2;
        AgreementLinkHelper.ClickLinkItemListener clickLinkItemListener;
        Object $result3;
        CheckBox checkBox;
        CheckBox checkBox2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setEulaDialogVisibility(SmsLoginDialogUtilKt.getShowEulaDialog());
                if (!SmsLoginDialogUtilKt.getShowEulaDialog()) {
                    view = this.this$0.mLoginRegPopView;
                    LoginRegHelper.INSTANCE.showRegPopView((Context) this.this$0, view);
                    break;
                } else {
                    loginEulaDialogViewDelegate = this.this$0.eulaDelegate;
                    if (loginEulaDialogViewDelegate != null) {
                        EulaTriggerType eulaTriggerType = EulaTriggerType.Submit;
                        int btnId = EulaTriggerType.Submit.getBtnId();
                        clickLinkItemListener = this.this$0.clickEulaLinkListener3;
                        this.label = 1;
                        Object show = loginEulaDialogViewDelegate.show(LoginReporterV2.PAGE_TYPE_SMS2, true, eulaTriggerType, btnId, (Map<String, String>) null, (String) null, clickLinkItemListener, (Continuation) this);
                        if (show != coroutine_suspended) {
                            $result3 = $result;
                            $result = show;
                            $result2 = !((Boolean) $result).booleanValue() ? 1 : null;
                            if ($result2 != null) {
                                this.$login.invoke();
                                checkBox = this.this$0.mLoginRegCheckBox;
                                if (checkBox != null) {
                                    checkBox.setChecked(true);
                                }
                                checkBox2 = this.this$0.mLoginRegCheckBox;
                                LoginRegHelper.reportRegCheckboxClick(LoginReporterV2.Click.CLICK_PROVISION_SMS_LOGIN2, checkBox2);
                            }
                            this.this$0.setEulaDialogVisibility(false);
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    } else {
                        $result2 = null;
                        if ($result2 != null) {
                        }
                        this.this$0.setEulaDialogVisibility(false);
                    }
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result3 = $result;
                if (!((Boolean) $result).booleanValue()) {
                }
                if ($result2 != null) {
                }
                this.this$0.setEulaDialogVisibility(false);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}