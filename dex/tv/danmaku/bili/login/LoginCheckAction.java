package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckAction;", "", "reduce", "Ltv/danmaku/bili/login/ActionResult;", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/login/LoginCheckState;", "(Ltv/danmaku/bili/login/LoginCheckState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface LoginCheckAction {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object reduce(LoginCheckState loginCheckState, Continuation<? super ActionResult> continuation);

    /* compiled from: OnePassLoginCheckViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/login/LoginCheckAction$Companion;", "", "<init>", "()V", "invoke", "", "block", "Lkotlin/Function1;", "Ltv/danmaku/bili/login/LoginCheckActionScope;", "Lkotlin/ExtensionFunctionType;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final void invoke(Function1<? super LoginCheckActionScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            function1.invoke(LoginCheckActionScope.Companion.getInstance());
        }
    }
}