package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import bili.resource.favorites.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;

/* compiled from: BaseFavTabFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.fragment.BaseFavTabFragment$cleanInvalid$1", f = "BaseFavTabFragment.kt", i = {}, l = {BR.danmukuTvVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BaseFavTabFragment$cleanInvalid$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BaseFavTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFavTabFragment$cleanInvalid$1(BaseFavTabFragment baseFavTabFragment, Continuation<? super BaseFavTabFragment$cleanInvalid$1> continuation) {
        super(2, continuation);
        this.this$0 = baseFavTabFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseFavTabFragment$cleanInvalid$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object cleanInvalid = FavoritesApiManagerKt.cleanInvalid(0, (Continuation) this);
                if (cleanInvalid != coroutine_suspended) {
                    $result = cleanInvalid;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        GeneralResponse $this$invokeSuspend_u24lambda_u240 = (GeneralResponse) $result;
        if ($this$invokeSuspend_u24lambda_u240 != null) {
            BaseFavTabFragment baseFavTabFragment = this.this$0;
            if ($this$invokeSuspend_u24lambda_u240.isSuccess()) {
                Context context = baseFavTabFragment.getContext();
                Context context2 = baseFavTabFragment.getContext();
                ToastHelper.showToast(context, context2 != null ? context2.getString(R.string.favorites_global_string_149) : null, 0, 17);
            } else {
                BLog.e(FavoritesFolderTabFragmentKt.TAG, "clean invalid failed " + $this$invokeSuspend_u24lambda_u240);
            }
        }
        return Unit.INSTANCE;
    }
}