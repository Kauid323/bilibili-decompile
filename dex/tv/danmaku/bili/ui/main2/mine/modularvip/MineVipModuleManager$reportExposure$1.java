package tv.danmaku.bili.ui.main2.mine.modularvip;

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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$reportExposure$1", f = "MineVipModuleManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MineVipModuleManager$reportExposure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MineVipModuleManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipModuleManager$reportExposure$1(MineVipModuleManager mineVipModuleManager, Continuation<? super MineVipModuleManager$reportExposure$1> continuation) {
        super(2, continuation);
        this.this$0 = mineVipModuleManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineVipModuleManager$reportExposure$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                MineVipModel model = (MineVipModel) this.this$0.modelFlow.getValue();
                MineVipService.INSTANCE.reportExposureEvent(model);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}