package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.httpdns.api.ConstsKt;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OverseaLoginPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.OverseaLoginStateMachine$1$1$3$result$1$1", f = "OverseaLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OverseaLoginStateMachine$1$1$3$result$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNew;
    final /* synthetic */ State<OverseaLoginState> $state;
    int label;
    final /* synthetic */ OverseaLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverseaLoginStateMachine$1$1$3$result$1$1(boolean z, OverseaLoginStateMachine overseaLoginStateMachine, State<OverseaLoginState> state, Continuation<? super OverseaLoginStateMachine$1$1$3$result$1$1> continuation) {
        super(2, continuation);
        this.$isNew = z;
        this.this$0 = overseaLoginStateMachine;
        this.$state = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OverseaLoginStateMachine$1$1$3$result$1$1(this.$isNew, this.this$0, this.$state, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        LoginReportService loginReportService;
        LoginReportService loginReportService2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                BLog.i("OverseaLoginStateMachine", "Google Login Success");
                if (this.$isNew) {
                    loginReportService2 = this.this$0.loginReportService;
                    loginReportService2.report(LoginReporterV2.Show.APP_REGISTER_PASSED_0_SHOW, ((OverseaLoginState) this.$state.getSnapshot()).getLoginType(), TuplesKt.to("is_oversea", "1"));
                }
                loginReportService = this.this$0.loginReportService;
                loginReportService.report(LoginReporterV2.Show.APP_LOGIN_SUCCEED_0_SHOW, ((OverseaLoginState) this.$state.getSnapshot()).getLoginType(), TuplesKt.to("type", ConstsKt.SP_GOOGLE), TuplesKt.to("is_oversea", "1"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}