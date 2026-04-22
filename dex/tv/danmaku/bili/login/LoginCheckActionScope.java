package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.login.ActionResult;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tJ%\u0010\n\u001a\u00020\u00052\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\b\t¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckActionScope;", "", "<init>", "()V", "moveTo", "Ltv/danmaku/bili/login/LoginCheckAction;", "block", "Lkotlin/Function2;", "Ltv/danmaku/bili/login/LoginCheckState;", "Lkotlin/ExtensionFunctionType;", "sideEffective", "Ltv/danmaku/bili/login/ActionResult$StateWithSideEffect;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LoginCheckActionScope {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final LoginCheckActionScope instance = new LoginCheckActionScope();

    /* compiled from: OnePassLoginCheckViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckActionScope$Companion;", "", "<init>", "()V", "instance", "Ltv/danmaku/bili/login/LoginCheckActionScope;", "getInstance", "()Ltv/danmaku/bili/login/LoginCheckActionScope;", "StateMove", "SideEffective", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginCheckActionScope getInstance() {
            return LoginCheckActionScope.instance;
        }

        /* compiled from: OnePassLoginCheckViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B&\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000eR(\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckActionScope$Companion$StateMove;", "Ltv/danmaku/bili/login/LoginCheckAction;", "block", "Lkotlin/Function2;", "Ltv/danmaku/bili/login/LoginCheckActionScope;", "Ltv/danmaku/bili/login/LoginCheckState;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getBlock", "()Lkotlin/jvm/functions/Function2;", "reduce", "Ltv/danmaku/bili/login/ActionResult;", AuthResultCbHelper.ARGS_STATE, "(Ltv/danmaku/bili/login/LoginCheckState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        private static final class StateMove implements LoginCheckAction {
            private final Function2<LoginCheckActionScope, LoginCheckState, LoginCheckState> block;

            /* JADX WARN: Multi-variable type inference failed */
            public StateMove(Function2<? super LoginCheckActionScope, ? super LoginCheckState, ? extends LoginCheckState> function2) {
                Intrinsics.checkNotNullParameter(function2, "block");
                this.block = function2;
            }

            public final Function2<LoginCheckActionScope, LoginCheckState, LoginCheckState> getBlock() {
                return this.block;
            }

            @Override // tv.danmaku.bili.login.LoginCheckAction
            public Object reduce(LoginCheckState state, Continuation<? super ActionResult> continuation) {
                return new ActionResult.StateChange((LoginCheckState) this.block.invoke(LoginCheckActionScope.Companion.getInstance(), state));
            }
        }

        /* compiled from: OnePassLoginCheckViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B&\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u000fR(\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckActionScope$Companion$SideEffective;", "Ltv/danmaku/bili/login/LoginCheckAction;", "block", "Lkotlin/Function2;", "Ltv/danmaku/bili/login/LoginCheckActionScope;", "Ltv/danmaku/bili/login/LoginCheckState;", "Ltv/danmaku/bili/login/ActionResult$StateWithSideEffect;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "getBlock", "()Lkotlin/jvm/functions/Function2;", "reduce", "Ltv/danmaku/bili/login/ActionResult;", AuthResultCbHelper.ARGS_STATE, "(Ltv/danmaku/bili/login/LoginCheckState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        private static final class SideEffective implements LoginCheckAction {
            private final Function2<LoginCheckActionScope, LoginCheckState, ActionResult.StateWithSideEffect> block;

            /* JADX WARN: Multi-variable type inference failed */
            public SideEffective(Function2<? super LoginCheckActionScope, ? super LoginCheckState, ActionResult.StateWithSideEffect> function2) {
                Intrinsics.checkNotNullParameter(function2, "block");
                this.block = function2;
            }

            public final Function2<LoginCheckActionScope, LoginCheckState, ActionResult.StateWithSideEffect> getBlock() {
                return this.block;
            }

            @Override // tv.danmaku.bili.login.LoginCheckAction
            public Object reduce(LoginCheckState state, Continuation<? super ActionResult> continuation) {
                return this.block.invoke(LoginCheckActionScope.Companion.getInstance(), state);
            }
        }
    }

    private LoginCheckActionScope() {
    }

    public final LoginCheckAction moveTo(Function2<? super LoginCheckActionScope, ? super LoginCheckState, ? extends LoginCheckState> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new Companion.StateMove(function2);
    }

    public final LoginCheckAction sideEffective(Function2<? super LoginCheckActionScope, ? super LoginCheckState, ActionResult.StateWithSideEffect> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new Companion.SideEffective(function2);
    }
}