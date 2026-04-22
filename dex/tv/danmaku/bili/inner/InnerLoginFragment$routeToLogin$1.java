package tv.danmaku.bili.inner;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.lib.accounts.model.TInfoLogin;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.route.LoginPageDisplay;
import tv.danmaku.bili.fullscreen.route.LoginPageType;
import tv.danmaku.bili.fullscreen.route.StartLoginPageKt;
import tv.danmaku.bili.fullscreen.route.ValidLoginType;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.quick.core.LoginRuleProcessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$routeToLogin$1", f = "InnerLoginFragment.kt", i = {}, l = {BR.hasTitle, BR.iconVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class InnerLoginFragment$routeToLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ValidLoginType $preferredType;
    int label;
    final /* synthetic */ InnerLoginFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginFragment$routeToLogin$1(ValidLoginType validLoginType, InnerLoginFragment innerLoginFragment, Continuation<? super InnerLoginFragment$routeToLogin$1> continuation) {
        super(2, continuation);
        this.$preferredType = validLoginType;
        this.this$0 = innerLoginFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginFragment$routeToLogin$1(this.$preferredType, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object $result3;
        String str;
        Object loginPageRequest;
        Object $result4;
        TInfoLogin infoLogin;
        TInfoLogin.AB ab;
        RouteRequest it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$preferredType == ValidLoginType.SmsLogin) {
                    this.label = 1;
                    Object suspendGetLoginType$default = LoginRuleProcessor.suspendGetLoginType$default(LoginRuleProcessor.INSTANCE, false, false, (Continuation) this, 3, null);
                    if (suspendGetLoginType$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result3 = suspendGetLoginType$default;
                    infoLogin = (TInfoLogin) ((Pair) $result3).component2();
                    if (!(infoLogin == null && (ab = infoLogin.ab) != null && ab.isSmsLoginExp())) {
                        RouteUtilKt.routeToLoginOriginActivityV2$default(this.this$0.requireContext(), Boxing.boxBoolean(true), Boxing.boxBoolean(true), null, this.this$0.getArguments(), null, null, null, true, BR.followed, null);
                        return Unit.INSTANCE;
                    }
                }
                Context requireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                str = this.this$0.fromSpmid;
                if (str == null) {
                    str = "";
                }
                Iterable $this$sortedBy$iv = CollectionsKt.listOf(new ValidLoginType[]{ValidLoginType.SmsLogin, ValidLoginType.PwdLogin});
                final ValidLoginType validLoginType = this.$preferredType;
                this.label = 2;
                loginPageRequest = StartLoginPageKt.getLoginPageRequest(requireContext, str, (r14 & 4) != 0 ? LoginPageDisplay.Companion.getDefaultArray() : CollectionsKt.listOf(LoginPageDisplay.Fullscreen), (r14 & 8) != 0 ? LoginPageType.Invalid : null, (r14 & 16) != 0 ? ValidLoginType.Companion.getAllValues() : CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$routeToLogin$1$invokeSuspend$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        ValidLoginType it2 = (ValidLoginType) t;
                        ValidLoginType it3 = (ValidLoginType) t2;
                        return ComparisonsKt.compareValues(Integer.valueOf(Math.abs(it2.ordinal() - ValidLoginType.this.ordinal())), Integer.valueOf(Math.abs(it3.ordinal() - ValidLoginType.this.ordinal())));
                    }
                }), (r14 & 32) != 0 ? new Function1() { // from class: tv.danmaku.bili.fullscreen.route.StartLoginPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit loginPageRequest$lambda$0;
                        loginPageRequest$lambda$0 = StartLoginPageKt.getLoginPageRequest$lambda$0((Bundle) obj);
                        return loginPageRequest$lambda$0;
                    }
                } : null, (Continuation) this);
                if (loginPageRequest == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result4 = loginPageRequest;
                it = (RouteRequest) $result4;
                if (it != null) {
                    BLRouter.routeTo(it, this.this$0);
                }
                return Unit.INSTANCE;
            case 1:
                $result3 = $result;
                ResultKt.throwOnFailure($result3);
                $result2 = $result3;
                infoLogin = (TInfoLogin) ((Pair) $result3).component2();
                if (infoLogin == null) {
                    break;
                }
                if (!(infoLogin == null && (ab = infoLogin.ab) != null && ab.isSmsLoginExp())) {
                }
                break;
            case 2:
                $result4 = $result;
                ResultKt.throwOnFailure($result4);
                it = (RouteRequest) $result4;
                if (it != null) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}