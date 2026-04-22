package tv.danmaku.bili.login;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: OnePassLoginCheckViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0080\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"handle", "", "Ltv/danmaku/bili/login/LoginCheckActionHandler;", "block", "Lkotlin/Function1;", "Ltv/danmaku/bili/login/LoginCheckActionScope;", "Ltv/danmaku/bili/login/LoginCheckAction;", "Lkotlin/ExtensionFunctionType;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginCheckViewModelKt {
    public static final void handle(LoginCheckActionHandler $this$handle, Function1<? super LoginCheckActionScope, ? extends LoginCheckAction> function1) {
        Intrinsics.checkNotNullParameter($this$handle, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        $this$handle.onAction((LoginCheckAction) function1.invoke(LoginCheckActionScope.Companion.getInstance()));
    }
}