package tv.danmaku.bili.ui.main2.mine.topleft;

import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.list.widget.dialog.AgeSelectorDialogKt;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
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
/* compiled from: TopLeft.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.TopLeftKt$setTopLeft$3$1$1$1$1$1", f = "TopLeft.kt", i = {}, l = {BR.bannerControl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TopLeftKt$setTopLeft$3$1$1$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ FragmentManager $fragmentManager;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopLeftKt$setTopLeft$3$1$1$1$1$1(FragmentManager fragmentManager, Continuation<? super TopLeftKt$setTopLeft$3$1$1$1$1$1> continuation) {
        super(1, continuation);
        this.$fragmentManager = fragmentManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TopLeftKt$setTopLeft$3$1$1$1$1$1(this.$fragmentManager, continuation);
    }

    public final Object invoke(Continuation<? super Integer> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                Object chooseAge = AgeSelectorDialogKt.chooseAge(this.$fragmentManager, TeenagersModeKt.getTeenagerAge(), (Continuation) this);
                if (chooseAge == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return chooseAge;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}