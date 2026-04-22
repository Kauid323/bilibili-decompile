package tv.danmaku.bili.eula;

import androidx.fragment.app.FragmentManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.ui.AgreementLinkHelper;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginEulaDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.eula.LoginEulaDialog", f = "LoginEulaDialog.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {BR.checkContent, 101}, m = ReportEvent.EVENT_TYPE_SHOW, n = {"pageType", "triggerType", "extraParams", "ispCode", "linkClickLinkItemListener", "isPhoneLogin", "triggerButtonId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0"}, v = 1)
public final class LoginEulaDialog$show$3 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoginEulaDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginEulaDialog$show$3(LoginEulaDialog loginEulaDialog, Continuation<? super LoginEulaDialog$show$3> continuation) {
        super(continuation);
        this.this$0 = loginEulaDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.show((FragmentManager) null, (String) null, false, (EulaTriggerType) null, 0, (Map<String, String>) null, (String) null, (AgreementLinkHelper.ClickLinkItemListener) null, (Continuation) this);
    }
}