package tv.danmaku.bili.fullscreen.state;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.fullscreen.service.LoginReportService;
import tv.danmaku.bili.fullscreen.service.LoginReportServiceKt;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastLoginPage.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Ltv/danmaku/bili/fullscreen/state/IFastLoginPage;", "<unused var>", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", AuthResultCbHelper.ARGS_STATE, "Lcom/freeletics/flowredux/dsl/State;", "Ltv/danmaku/bili/fullscreen/state/FastLoginPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$6", f = "FastLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FastLoginStateMachine$1$1$6 extends SuspendLambda implements Function3<IFullscreenLoginAction.LoginAction, State<FastLoginPage>, Continuation<? super ChangedState<? extends IFastLoginPage>>, Object> {
    final /* synthetic */ InStateBuilderBlock<FastLoginPage, IFastLoginPage, IFullscreenAction> $this_inState;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FastLoginStateMachine this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FastLoginStateMachine$1$1$6(InStateBuilderBlock<FastLoginPage, IFastLoginPage, IFullscreenAction> inStateBuilderBlock, FastLoginStateMachine fastLoginStateMachine, Continuation<? super FastLoginStateMachine$1$1$6> continuation) {
        super(3, continuation);
        this.$this_inState = inStateBuilderBlock;
        this.this$0 = fastLoginStateMachine;
    }

    public final Object invoke(IFullscreenLoginAction.LoginAction loginAction, State<FastLoginPage> state, Continuation<? super ChangedState<? extends IFastLoginPage>> continuation) {
        FastLoginStateMachine$1$1$6 fastLoginStateMachine$1$1$6 = new FastLoginStateMachine$1$1$6(this.$this_inState, this.this$0, continuation);
        fastLoginStateMachine$1$1$6.L$0 = state;
        return fastLoginStateMachine$1$1$6.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                State state = (State) this.L$0;
                BLog.i(IFullscreenLoginPageKt.TAG_FULLSCREEN, "on password login, agreement checked " + ((FastLoginPage) state.getSnapshot()).getAgreementChecked());
                BaseBuilderBlock $this$iv = this.$this_inState;
                Function3 handler$iv = new AnonymousClass1(this.this$0, null);
                ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
                $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IFullscreenLoginAction.LoginAction.class), executionPolicy$iv, handler$iv);
                return state.override(new Function1() { // from class: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$6$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        FastLoginLoadingPage invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = FastLoginStateMachine$1$1$6.invokeSuspend$lambda$0((FastLoginPage) obj2);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FastLoginPage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "action", "Ltv/danmaku/bili/fullscreen/state/IFullscreenLoginAction$LoginAction;", "stateSnapshot", "Ltv/danmaku/bili/fullscreen/state/FastLoginPage;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$6$1", f = "FastLoginPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.fullscreen.state.FastLoginStateMachine$1$1$6$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<IFullscreenLoginAction.LoginAction, FastLoginPage, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ FastLoginStateMachine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FastLoginStateMachine fastLoginStateMachine, Continuation<? super AnonymousClass1> continuation) {
            super(3, continuation);
            this.this$0 = fastLoginStateMachine;
        }

        public final Object invoke(IFullscreenLoginAction.LoginAction loginAction, FastLoginPage fastLoginPage, Continuation<? super Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = loginAction;
            anonymousClass1.L$1 = fastLoginPage;
            return anonymousClass1.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            LoginReportService loginReportService;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    IFullscreenLoginAction.LoginAction action = (IFullscreenLoginAction.LoginAction) this.L$0;
                    FastLoginPage stateSnapshot = (FastLoginPage) this.L$1;
                    if (action.getReport()) {
                        loginReportService = this.this$0.loginReportService;
                        loginReportService.report("app.login.submit.0.click", stateSnapshot.getLoginType(), TuplesKt.to("is_agree", LoginReportServiceKt.getReportString(stateSnapshot.getAgreementChecked())));
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FastLoginLoadingPage invokeSuspend$lambda$0(FastLoginPage $this$override) {
        return new FastLoginLoadingPage($this$override);
    }
}