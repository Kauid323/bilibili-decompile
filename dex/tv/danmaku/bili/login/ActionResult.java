package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/login/ActionResult;", "", "StateChange", "StateWithSideEffect", "Ltv/danmaku/bili/login/ActionResult$StateChange;", "Ltv/danmaku/bili/login/ActionResult$StateWithSideEffect;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface ActionResult {

    /* compiled from: OnePassLoginCheckViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/login/ActionResult$StateChange;", "Ltv/danmaku/bili/login/ActionResult;", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/login/LoginCheckState;", "<init>", "(Ltv/danmaku/bili/login/LoginCheckState;)V", "getState", "()Ltv/danmaku/bili/login/LoginCheckState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StateChange implements ActionResult {
        public static final int $stable = 8;
        private final LoginCheckState state;

        public static /* synthetic */ StateChange copy$default(StateChange stateChange, LoginCheckState loginCheckState, int i, Object obj) {
            if ((i & 1) != 0) {
                loginCheckState = stateChange.state;
            }
            return stateChange.copy(loginCheckState);
        }

        public final LoginCheckState component1() {
            return this.state;
        }

        public final StateChange copy(LoginCheckState loginCheckState) {
            Intrinsics.checkNotNullParameter(loginCheckState, AuthResultCbHelper.ARGS_STATE);
            return new StateChange(loginCheckState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StateChange) && Intrinsics.areEqual(this.state, ((StateChange) obj).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "StateChange(state=" + this.state + ")";
        }

        public StateChange(LoginCheckState state) {
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            this.state = state;
        }

        public final LoginCheckState getState() {
            return this.state;
        }
    }

    /* compiled from: OnePassLoginCheckViewModel.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J*\u0010\u0012\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ>\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\tHÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR/\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Ltv/danmaku/bili/login/ActionResult$StateWithSideEffect;", "Ltv/danmaku/bili/login/ActionResult;", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/login/LoginCheckState;", "sideEffect", "Lkotlin/Function2;", "Ltv/danmaku/bili/login/LoginCheckActionHandler;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Ltv/danmaku/bili/login/LoginCheckState;Lkotlin/jvm/functions/Function2;)V", "getState", "()Ltv/danmaku/bili/login/LoginCheckState;", "getSideEffect", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "component1", "component2", "copy", "(Ltv/danmaku/bili/login/LoginCheckState;Lkotlin/jvm/functions/Function2;)Ltv/danmaku/bili/login/ActionResult$StateWithSideEffect;", "equals", "", "other", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class StateWithSideEffect implements ActionResult {
        public static final int $stable = 8;
        private final Function2<LoginCheckActionHandler, Continuation<? super Unit>, Object> sideEffect;
        private final LoginCheckState state;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StateWithSideEffect copy$default(StateWithSideEffect stateWithSideEffect, LoginCheckState loginCheckState, Function2 function2, int i, Object obj) {
            if ((i & 1) != 0) {
                loginCheckState = stateWithSideEffect.state;
            }
            if ((i & 2) != 0) {
                function2 = stateWithSideEffect.sideEffect;
            }
            return stateWithSideEffect.copy(loginCheckState, function2);
        }

        public final LoginCheckState component1() {
            return this.state;
        }

        public final Function2<LoginCheckActionHandler, Continuation<? super Unit>, Object> component2() {
            return this.sideEffect;
        }

        public final StateWithSideEffect copy(LoginCheckState loginCheckState, Function2<? super LoginCheckActionHandler, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(loginCheckState, AuthResultCbHelper.ARGS_STATE);
            Intrinsics.checkNotNullParameter(function2, "sideEffect");
            return new StateWithSideEffect(loginCheckState, function2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof StateWithSideEffect) {
                StateWithSideEffect stateWithSideEffect = (StateWithSideEffect) obj;
                return Intrinsics.areEqual(this.state, stateWithSideEffect.state) && Intrinsics.areEqual(this.sideEffect, stateWithSideEffect.sideEffect);
            }
            return false;
        }

        public int hashCode() {
            return (this.state.hashCode() * 31) + this.sideEffect.hashCode();
        }

        public String toString() {
            LoginCheckState loginCheckState = this.state;
            return "StateWithSideEffect(state=" + loginCheckState + ", sideEffect=" + this.sideEffect + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public StateWithSideEffect(LoginCheckState state, Function2<? super LoginCheckActionHandler, ? super Continuation<? super Unit>, ? extends Object> function2) {
            Intrinsics.checkNotNullParameter(state, AuthResultCbHelper.ARGS_STATE);
            Intrinsics.checkNotNullParameter(function2, "sideEffect");
            this.state = state;
            this.sideEffect = function2;
        }

        public final Function2<LoginCheckActionHandler, Continuation<? super Unit>, Object> getSideEffect() {
            return this.sideEffect;
        }

        public final LoginCheckState getState() {
            return this.state;
        }
    }
}