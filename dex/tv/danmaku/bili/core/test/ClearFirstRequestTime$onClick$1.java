package tv.danmaku.bili.core.test;

import android.content.SharedPreferences;
import android.view.View;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.droid.ToastHelper;
import kotlin.Metadata;
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

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.ClearFirstRequestTime$onClick$1", f = "MainTestPageActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ClearFirstRequestTime$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $v;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClearFirstRequestTime$onClick$1(View view, Continuation<? super ClearFirstRequestTime$onClick$1> continuation) {
        super(2, continuation);
        this.$v = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ClearFirstRequestTime$onClick$1(this.$v, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SharedPreferences blkv = BiliGlobalPreferenceHelper.getBLKVSharedPreference(this.$v.getContext());
                Intrinsics.checkNotNull(blkv);
                SharedPreferences.Editor editor$iv = blkv.edit();
                editor$iv.putLong("notification_permission_android_13_first_request_time", 1L);
                editor$iv.apply();
                ToastHelper.showToastLong(BiliContext.application(), "已将第一次申请时间设置为0（可以满足第二次请求时间间隔）");
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}