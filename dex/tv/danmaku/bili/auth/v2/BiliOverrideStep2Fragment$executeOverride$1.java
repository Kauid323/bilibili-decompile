package tv.danmaku.bili.auth.v2;

import android.app.Application;
import com.bilibili.app.auth.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiliOverrideStep2Fragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment$executeOverride$1", f = "BiliOverrideStep2Fragment.kt", i = {}, l = {BR.followIconVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BiliOverrideStep2Fragment$executeOverride$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BiliOverrideStep2Fragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliOverrideStep2Fragment$executeOverride$1(BiliOverrideStep2Fragment biliOverrideStep2Fragment, Continuation<? super BiliOverrideStep2Fragment$executeOverride$1> continuation) {
        super(2, continuation);
        this.this$0 = biliOverrideStep2Fragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliOverrideStep2Fragment$executeOverride$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String str;
        String str2;
        Object m732requestData0E7RQCE;
        Object result;
        String string;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BiliOverrideStep2Fragment biliOverrideStep2Fragment = this.this$0;
                str = this.this$0.requestId;
                if (str == null) {
                    str = "";
                }
                str2 = this.this$0.mOverrideMid;
                String str3 = str2 != null ? str2 : "";
                this.label = 1;
                m732requestData0E7RQCE = biliOverrideStep2Fragment.m732requestData0E7RQCE(str, str3, (Continuation) this);
                if (m732requestData0E7RQCE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result = m732requestData0E7RQCE;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                result = ((Result) $result).unbox-impl();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (Result.isSuccess-impl(result)) {
            this.this$0.gotoSuccessPage();
        } else {
            Throwable e = Result.exceptionOrNull-impl(result);
            Application fapp = FoundationAlias.getFapp();
            if (e == null || (string = e.getMessage()) == null) {
                string = this.this$0.getString(R.string.auth_override_failed);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            }
            ToastHelper.showToastShort(fapp, string);
        }
        return Unit.INSTANCE;
    }
}