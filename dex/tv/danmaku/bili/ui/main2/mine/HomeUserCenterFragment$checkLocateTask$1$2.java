package tv.danmaku.bili.ui.main2.mine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HomeUserCenterFragment.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.HomeUserCenterFragment$checkLocateTask$1$2", f = "HomeUserCenterFragment.kt", i = {}, l = {1405}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HomeUserCenterFragment$checkLocateTask$1$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ long $id;
    int label;
    final /* synthetic */ HomeUserCenterFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeUserCenterFragment$checkLocateTask$1$2(HomeUserCenterFragment homeUserCenterFragment, long j, Continuation<? super HomeUserCenterFragment$checkLocateTask$1$2> continuation) {
        super(1, continuation);
        this.this$0 = homeUserCenterFragment;
        this.$id = j;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HomeUserCenterFragment$checkLocateTask$1$2(this.this$0, this.$id, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object scrollToAdapterPosition;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                scrollToAdapterPosition = this.this$0.scrollToAdapterPosition(4, this.$id, (Continuation) this);
                if (scrollToAdapterPosition == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}