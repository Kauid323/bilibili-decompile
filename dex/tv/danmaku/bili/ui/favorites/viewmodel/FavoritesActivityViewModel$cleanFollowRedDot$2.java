package tv.danmaku.bili.ui.favorites.viewmodel;

import com.bilibili.okretro.BaseResponse;
import com.bilibili.okretro.GeneralResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.api.FavoritesApiManagerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bilibili/okretro/GeneralResponse;", "Lcom/bilibili/okretro/BaseResponse;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel$cleanFollowRedDot$2", f = "FavoritesActivityViewModel.kt", i = {}, l = {BR.cardTag, BR.cardTag}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesActivityViewModel$cleanFollowRedDot$2 extends SuspendLambda implements Function2<FlowCollector<? super GeneralResponse<BaseResponse>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $tabId;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityViewModel$cleanFollowRedDot$2(int i, Continuation<? super FavoritesActivityViewModel$cleanFollowRedDot$2> continuation) {
        super(2, continuation);
        this.$tabId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> favoritesActivityViewModel$cleanFollowRedDot$2 = new FavoritesActivityViewModel$cleanFollowRedDot$2(this.$tabId, continuation);
        favoritesActivityViewModel$cleanFollowRedDot$2.L$0 = obj;
        return favoritesActivityViewModel$cleanFollowRedDot$2;
    }

    public final Object invoke(FlowCollector<? super GeneralResponse<BaseResponse>> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object $result2;
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FlowCollector $this$flow = (FlowCollector) this.L$0;
                this.L$0 = $this$flow;
                this.label = 1;
                Object cleanRedDot = FavoritesApiManagerKt.cleanRedDot(this.$tabId, (Continuation) this);
                if (cleanRedDot == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = cleanRedDot;
                flowCollector = $this$flow;
                this.L$0 = null;
                this.label = 2;
                return flowCollector.emit($result, (Continuation) this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                flowCollector = (FlowCollector) this.L$0;
                $result2 = $result;
                this.L$0 = null;
                this.label = 2;
                if (flowCollector.emit($result, (Continuation) this) != coroutine_suspended) {
                }
                break;
            case 2:
                ResultKt.throwOnFailure($result);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}