package tv.danmaku.bili.eula;

import androidx.fragment.app.FragmentManager;
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
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LoginEulaDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.eula.LoginEulaDialog$show$2", f = "LoginEulaDialog.kt", i = {}, l = {BR.buttonText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LoginEulaDialog$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EulaLinkItemListener $eulaItemListener;
    final /* synthetic */ Map<String, String> $extraParams;
    final /* synthetic */ FragmentManager $fragmentManager;
    final /* synthetic */ boolean $isPhoneLogin;
    final /* synthetic */ String $ispCode;
    final /* synthetic */ Function0<Unit> $onNegativeClick;
    final /* synthetic */ Function0<Unit> $onPositiveClick;
    final /* synthetic */ String $pageType;
    final /* synthetic */ int $triggerButtonId;
    final /* synthetic */ EulaTriggerType $triggerType;
    int label;
    final /* synthetic */ LoginEulaDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginEulaDialog$show$2(LoginEulaDialog loginEulaDialog, FragmentManager fragmentManager, String str, boolean z, EulaTriggerType eulaTriggerType, int i, Map<String, String> map, String str2, EulaLinkItemListener eulaLinkItemListener, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super LoginEulaDialog$show$2> continuation) {
        super(2, continuation);
        this.this$0 = loginEulaDialog;
        this.$fragmentManager = fragmentManager;
        this.$pageType = str;
        this.$isPhoneLogin = z;
        this.$triggerType = eulaTriggerType;
        this.$triggerButtonId = i;
        this.$extraParams = map;
        this.$ispCode = str2;
        this.$eulaItemListener = eulaLinkItemListener;
        this.$onPositiveClick = function0;
        this.$onNegativeClick = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginEulaDialog$show$2(this.this$0, this.$fragmentManager, this.$pageType, this.$isPhoneLogin, this.$triggerType, this.$triggerButtonId, this.$extraParams, this.$ispCode, this.$eulaItemListener, this.$onPositiveClick, this.$onNegativeClick, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        AgreementLinkHelper.ClickLinkItemListener warpListener;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LoginEulaDialog loginEulaDialog = this.this$0;
                FragmentManager fragmentManager = this.$fragmentManager;
                String str = this.$pageType;
                boolean z = this.$isPhoneLogin;
                EulaTriggerType eulaTriggerType = this.$triggerType;
                int i = this.$triggerButtonId;
                Map<String, String> map = this.$extraParams;
                String str2 = this.$ispCode;
                warpListener = this.this$0.warpListener(this.$eulaItemListener);
                this.label = 1;
                Object show = loginEulaDialog.show(fragmentManager, str, z, eulaTriggerType, i, map, str2, warpListener, (Continuation) this);
                if (show != coroutine_suspended) {
                    $result = show;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) $result).booleanValue()) {
            this.$onPositiveClick.invoke();
        } else {
            this.$onNegativeClick.invoke();
        }
        return Unit.INSTANCE;
    }
}