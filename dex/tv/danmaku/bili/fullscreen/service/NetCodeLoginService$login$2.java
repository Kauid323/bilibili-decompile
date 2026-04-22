package tv.danmaku.bili.fullscreen.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.ThirdLoginParams;
import com.bilibili.lib.accounts.VerifyBundle;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.LoginReportHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetCodeLoginService.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/bilibili/lib/accounts/VerifyBundle;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.NetCodeLoginService$login$2", f = "NetCodeLoginService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NetCodeLoginService$login$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super VerifyBundle>, Object> {
    final /* synthetic */ String $bizSeq;
    final /* synthetic */ String $codeSecret;
    final /* synthetic */ String $extendCode;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetCodeLoginService$login$2(String str, String str2, String str3, Continuation<? super NetCodeLoginService$login$2> continuation) {
        super(2, continuation);
        this.$bizSeq = str;
        this.$codeSecret = str2;
        this.$extendCode = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NetCodeLoginService$login$2(this.$bizSeq, this.$codeSecret, this.$extendCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super VerifyBundle> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                return BiliAccounts.get(FoundationAlias.getFapp()).loginByThird(new ThirdLoginParams("00000037AA", "netcode", this.$bizSeq, LoginReportHelper.INSTANCE.getLoginSessionId(), LoginReportHelper.INSTANCE.getFromSpmid(), LoginReportHelper.INSTANCE.getGuideId(), LoginReportHelper.INSTANCE.getExtend(), this.$codeSecret, this.$extendCode));
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}