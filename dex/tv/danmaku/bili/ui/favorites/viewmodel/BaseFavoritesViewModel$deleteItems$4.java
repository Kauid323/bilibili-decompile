package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseFavoritesViewModel.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BaseFavoritesViewModel$deleteItems$4<T> implements FlowCollector {
    final /* synthetic */ BaseFavoritesViewModel<UserAction, UIState, UIEffect> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseFavoritesViewModel$deleteItems$4(BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel) {
        this.this$0 = baseFavoritesViewModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(GeneralResponse<BaseResponse> generalResponse, Continuation<? super Unit> continuation) {
        Continuation $continuation;
        boolean z;
        if (continuation instanceof BaseFavoritesViewModel$deleteItems$4$emit$1) {
            $continuation = (BaseFavoritesViewModel$deleteItems$4$emit$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                z = false;
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel = this.this$0;
                        boolean z2 = generalResponse != null && generalResponse.isSuccess();
                        $continuation.L$0 = generalResponse;
                        $continuation.label = 1;
                        if (baseFavoritesViewModel.onDeleteSuccess(z2, $continuation) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        generalResponse = (GeneralResponse) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (generalResponse != null && generalResponse.isSuccess()) {
                    z = true;
                }
                if (!z) {
                    BLog.i(FavoritesListViewModel.TAG, "delete favorites success");
                } else {
                    BLog.i(FavoritesListViewModel.TAG, "delete favorites failed");
                }
                return Unit.INSTANCE;
            }
        }
        $continuation = new BaseFavoritesViewModel$deleteItems$4$emit$1(this, continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        z = false;
        switch ($continuation.label) {
        }
        if (generalResponse != null) {
            z = true;
        }
        if (!z) {
        }
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((GeneralResponse) value, (Continuation<? super Unit>) $completion);
    }
}