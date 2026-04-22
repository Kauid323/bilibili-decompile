package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseFavoritesViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$deleteItems$4", f = "BaseFavoritesViewModel.kt", i = {0}, l = {BR.btnTryAgainText}, m = "emit", n = {"res"}, s = {"L$0"}, v = 1)
public final class BaseFavoritesViewModel$deleteItems$4$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseFavoritesViewModel$deleteItems$4<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseFavoritesViewModel$deleteItems$4$emit$1(BaseFavoritesViewModel$deleteItems$4<? super T> baseFavoritesViewModel$deleteItems$4, Continuation<? super BaseFavoritesViewModel$deleteItems$4$emit$1> continuation) {
        super(continuation);
        this.this$0 = baseFavoritesViewModel$deleteItems$4;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((GeneralResponse<BaseResponse>) null, (Continuation) this);
    }
}