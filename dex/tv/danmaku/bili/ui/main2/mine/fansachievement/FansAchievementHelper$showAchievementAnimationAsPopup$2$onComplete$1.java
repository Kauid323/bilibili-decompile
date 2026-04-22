package tv.danmaku.bili.ui.main2.mine.fansachievement;

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

/* compiled from: FansAchievementHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.fansachievement.FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1", f = "FansAchievementHelper.kt", i = {}, l = {BR.gifThumbHeight}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AccountMine.FansEffect $fansEffect;
    int label;
    final /* synthetic */ FansAchievementHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1(FansAchievementHelper fansAchievementHelper, AccountMine.FansEffect fansEffect, Continuation<? super FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = fansAchievementHelper;
        this.$fansEffect = fansEffect;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FansAchievementHelper$showAchievementAnimationAsPopup$2$onComplete$1(this.this$0, this.$fansEffect, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object reportDisplay;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                reportDisplay = this.this$0.reportDisplay(this.$fansEffect, (Continuation) this);
                if (reportDisplay == coroutine_suspended) {
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