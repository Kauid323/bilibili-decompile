package tv.danmaku.bili.core.test;

import android.content.SharedPreferences;
import android.view.View;
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
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.CleanTopGameTabLottieDisplayHistory$onClick$1", f = "MainTestPageActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CleanTopGameTabLottieDisplayHistory$onClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $v;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CleanTopGameTabLottieDisplayHistory$onClick$1(View view, Continuation<? super CleanTopGameTabLottieDisplayHistory$onClick$1> continuation) {
        super(2, continuation);
        this.$v = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CleanTopGameTabLottieDisplayHistory$onClick$1(this.$v, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                SharedPreferences pref = BiliGlobalPreferenceHelper.getBLKVSharedPreference();
                if (pref == null) {
                    return Unit.INSTANCE;
                }
                boolean success = pref.edit().remove("top_game_already_clicked").remove("top_game_residue_time").remove("top_game_local_time").remove("top_game_lottie_finish").commit();
                View view = this.$v;
                ToastHelper.showToastShort(view != null ? view.getContext() : null, "清除" + (success ? "成功" : "失败"));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}