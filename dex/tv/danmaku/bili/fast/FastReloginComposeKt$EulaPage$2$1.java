package tv.danmaku.bili.fast;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.normal.ui.LoginEulaDialogViewDelegate;
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastReloginCompose.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fast.FastReloginComposeKt$EulaPage$2$1", f = "FastReloginCompose.kt", i = {}, l = {BR.followClickable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastReloginComposeKt$EulaPage$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<LoginEulaDialogViewDelegate> $delegate$delegate;
    final /* synthetic */ Function0<Unit> $dismiss;
    final /* synthetic */ Function1<String, Unit> $onAgreementClick;
    final /* synthetic */ Function0<Unit> $onLoginClick;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FastReloginComposeKt$EulaPage$2$1(Function0<Unit> function0, Function0<Unit> function02, MutableState<LoginEulaDialogViewDelegate> mutableState, Function1<? super String, Unit> function1, Continuation<? super FastReloginComposeKt$EulaPage$2$1> continuation) {
        super(2, continuation);
        this.$onLoginClick = function0;
        this.$dismiss = function02;
        this.$delegate$delegate = mutableState;
        this.$onAgreementClick = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FastReloginComposeKt$EulaPage$2$1(this.$onLoginClick, this.$dismiss, this.$delegate$delegate, this.$onAgreementClick, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginEulaDialogViewDelegate EulaPage$lambda$1;
        Boolean confirmed;
        Object $result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BLog.d(FastReLoginActivityKt.TAG, "Eula dialog shown");
                EulaPage$lambda$1 = FastReloginComposeKt.EulaPage$lambda$1(this.$delegate$delegate);
                if (EulaPage$lambda$1 == null) {
                    confirmed = null;
                    break;
                } else {
                    EulaTriggerType eulaTriggerType = EulaTriggerType.Submit;
                    final Function1<String, Unit> function1 = this.$onAgreementClick;
                    this.label = 1;
                    Object show$default = LoginEulaDialogViewDelegate.show$default(EulaPage$lambda$1, "fast-login", false, eulaTriggerType, 0, null, null, new AgreementLinkHelper.ClickLinkItemListener() { // from class: tv.danmaku.bili.fast.FastReloginComposeKt$EulaPage$2$1$$ExternalSyntheticLambda0
                        @Override // tv.danmaku.bili.ui.AgreementLinkHelper.ClickLinkItemListener
                        public final void onItemLinkClick(int i) {
                            FastReloginComposeKt$EulaPage$2$1.invokeSuspend$lambda$0(function1, i);
                        }
                    }, (Continuation) this, 24, null);
                    if (show$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = show$default;
                    confirmed = (Boolean) $result;
                    break;
                }
            case 1:
                $result = obj;
                ResultKt.throwOnFailure($result);
                confirmed = (Boolean) $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (Intrinsics.areEqual(confirmed, Boxing.boxBoolean(true))) {
            this.$onLoginClick.invoke();
        } else {
            this.$dismiss.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(Function1 $onAgreementClick, int it) {
        switch (it) {
            case 2:
                $onAgreementClick.invoke(AgreementLinkHelper.DEFAULT_USER_PROTOCOL_URL);
                return;
            case 3:
                $onAgreementClick.invoke(AgreementLinkHelper.DEFAULT_PRIVACY_POLICY_URL);
                return;
            default:
                return;
        }
    }
}