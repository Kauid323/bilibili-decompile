package tv.danmaku.bili.core.test;

import com.bapis.bilibili.account.fission.v1.FissionMoss;
import com.bapis.bilibili.account.fission.v1.FissionMossKtxKt;
import com.bapis.bilibili.account.fission.v1.PrivacyReply;
import com.bapis.bilibili.account.fission.v1.PrivacyReq;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.moss.api.BusinessException;
import com.bilibili.lib.moss.api.CallOptions;
import com.bilibili.lib.moss.api.MossException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.领一天大会员$onClick$1", f = "MainTestPageActivity.kt", i = {}, l = {BR.loadingViewVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.领一天大会员$onClick$1  reason: invalid class name and case insensitive filesystem */
final class C0026$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0026$onClick$1(Continuation<? super C0026$onClick$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0026$onClick$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v9, types: [com.bapis.bilibili.account.fission.v1.PrivacyReply] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        String toast;
        Object $result2;
        Object $result3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure((Object) $result);
                    FissionMoss fissionMoss = new FissionMoss((String) null, 0, (CallOptions) null, 7, (DefaultConstructorMarker) null);
                    PrivacyReq build = PrivacyReq.newBuilder().setActivityUid("privacy-vip").build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    this.label = 1;
                    Object suspendPrivacy = FissionMossKtxKt.suspendPrivacy(fissionMoss, build, (Continuation) this);
                    if (suspendPrivacy != coroutine_suspended) {
                        $result2 = $result;
                        $result3 = suspendPrivacy;
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    ResultKt.throwOnFailure((Object) $result);
                    $result2 = $result;
                    $result3 = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (MossException e) {
            $result = e;
        }
        try {
            $result = (PrivacyReply) $result3;
            if ($result != 0) {
                r2 = $result.getMessage();
            }
        } catch (MossException e2) {
            Object obj = $result2;
            $result = e2;
            $result = obj;
            BusinessException businessException = $result instanceof BusinessException ? (BusinessException) $result : null;
            r2 = businessException != null ? businessException.getMessage() : null;
            toast = r2;
            if (toast != null) {
            }
            return Unit.INSTANCE;
        }
        toast = r2;
        if (toast != null) {
            ToastHelper.showToastLong(BiliContext.application(), toast);
        }
        return Unit.INSTANCE;
    }
}