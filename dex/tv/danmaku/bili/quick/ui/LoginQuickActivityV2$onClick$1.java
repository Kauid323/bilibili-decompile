package tv.danmaku.bili.quick.ui;

import android.content.Context;
import android.widget.CheckBox;
import com.bilibili.lib.accountsui.quick.LoginQuickManager;
import com.bilibili.lib.accountsui.quick.core.ILoginOnePass;
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
import tv.danmaku.bili.sms.SmsLoginDialogUtilKt;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;
import tv.danmaku.bili.utils.reporter.ILoginQuickReporter;

/* compiled from: LoginQuickActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.quick.ui.LoginQuickActivityV2$onClick$1", f = "LoginQuickActivityV2.kt", i = {}, l = {BR.pagerScrollState}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class LoginQuickActivityV2$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LoginQuickActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginQuickActivityV2$onClick$1(LoginQuickActivityV2 loginQuickActivityV2, Continuation<? super LoginQuickActivityV2$onClick$1> continuation) {
        super(2, continuation);
        this.this$0 = loginQuickActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginQuickActivityV2$onClick$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        LoginEulaDialogViewDelegate loginEulaDialogViewDelegate;
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setEulaDialogVisibility(SmsLoginDialogUtilKt.getShowEulaDialog());
                if (SmsLoginDialogUtilKt.getShowEulaDialog()) {
                    loginEulaDialogViewDelegate = this.this$0.eulaDelegate;
                    if (loginEulaDialogViewDelegate != null) {
                        EulaTriggerType eulaTriggerType = EulaTriggerType.Submit;
                        int btnId = EulaTriggerType.Submit.getBtnId();
                        ILoginOnePass.IspFlag ispFlag = LoginQuickManager.INSTANCE.ispFlag();
                        String ispName = ispFlag != null ? ispFlag.getIspName() : null;
                        this.label = 1;
                        Object show = loginEulaDialogViewDelegate.show(LoginReporterV2.PAGE_TYPE_ONEPASS, true, eulaTriggerType, btnId, (Map<String, String>) null, ispName, (AgreementLinkHelper.ClickLinkItemListener) this.this$0, (Continuation) this);
                        if (show == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result3 = $result;
                        $result = show;
                        $result2 = !((Boolean) $result).booleanValue() ? 1 : null;
                        if ($result2 != null) {
                            this.this$0.doLogin();
                            CheckBox mLoginRegCheckBox = this.this$0.getMLoginRegCheckBox();
                            if (mLoginRegCheckBox != null) {
                                mLoginRegCheckBox.setChecked(true);
                            }
                            ILoginQuickReporter mReporter = this.this$0.getMReporter();
                            if (mReporter != null) {
                                mReporter.reportRegCheckboxClick(this.this$0.getMLoginRegCheckBox());
                            }
                        }
                        this.this$0.setEulaDialogVisibility(false);
                        break;
                    } else {
                        $result2 = null;
                        if ($result2 != null) {
                        }
                        this.this$0.setEulaDialogVisibility(false);
                    }
                } else {
                    LoginRegHelper.INSTANCE.showRegPopView((Context) this.this$0, this.this$0.getMLoginRegPopView());
                    break;
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