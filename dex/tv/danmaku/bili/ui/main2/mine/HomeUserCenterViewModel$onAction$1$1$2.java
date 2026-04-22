package tv.danmaku.bili.ui.main2.mine;

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
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.HomeUserCenterAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterViewModel$onAction$1$1$2", f = "HomeUserCenterViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterViewModel$onAction$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountMine $mineInfo;
    int label;
    final /* synthetic */ HomeUserCenterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterViewModel$onAction$1$1$2(HomeUserCenterViewModel homeUserCenterViewModel, AccountMine accountMine, Continuation<? super HomeUserCenterViewModel$onAction$1$1$2> continuation) {
        super(2, continuation);
        this.this$0 = homeUserCenterViewModel;
        this.$mineInfo = accountMine;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeUserCenterViewModel$onAction$1$1$2(this.this$0, this.$mineInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HomeUserCenterViewModelKt.mineLog("local_ready");
                this.this$0.onAction(new HomeUserCenterAction.Update(this.$mineInfo, true));
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}