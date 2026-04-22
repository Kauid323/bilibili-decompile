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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MineVipModuleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.modularvip.MineVipModuleManager$rollback$1", f = "MineVipModuleManager.kt", i = {}, l = {BR.displayingBanner}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class MineVipModuleManager$rollback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MineVipModuleManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineVipModuleManager$rollback$1(MineVipModuleManager mineVipModuleManager, Continuation<? super MineVipModuleManager$rollback$1> continuation) {
        super(2, continuation);
        this.this$0 = mineVipModuleManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MineVipModuleManager$rollback$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        MineVipModel model;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MineVipModel $this$invokeSuspend_u24lambda_u240 = (MineVipModel) this.this$0.modelFlow.getValue();
                MineVipBackgroundModel onRollback = $this$invokeSuspend_u24lambda_u240.getBackground().onRollback();
                MineVipButtonModel onRollback2 = $this$invokeSuspend_u24lambda_u240.getButton().onRollback();
                MineVipLogoModel logo = $this$invokeSuspend_u24lambda_u240.getLogo();
                MineVipLogoModel onRollback3 = logo != null ? logo.onRollback() : null;
                MineVipButtonIconModel buttonIcon = $this$invokeSuspend_u24lambda_u240.getButtonIcon();
                model = $this$invokeSuspend_u24lambda_u240.copy((r22 & 1) != 0 ? $this$invokeSuspend_u24lambda_u240.isVip : null, (r22 & 2) != 0 ? $this$invokeSuspend_u24lambda_u240.mid : 0L, (r22 & 4) != 0 ? $this$invokeSuspend_u24lambda_u240.background : onRollback, (r22 & 8) != 0 ? $this$invokeSuspend_u24lambda_u240.button : onRollback2, (r22 & 16) != 0 ? $this$invokeSuspend_u24lambda_u240.buttonIcon : buttonIcon != null ? buttonIcon.onRollback() : null, (r22 & 32) != 0 ? $this$invokeSuspend_u24lambda_u240.logo : onRollback3, (r22 & 64) != 0 ? $this$invokeSuspend_u24lambda_u240.title : $this$invokeSuspend_u24lambda_u240.getTitle().onRollback(), (r22 & BR.cover) != 0 ? $this$invokeSuspend_u24lambda_u240.subtitle : $this$invokeSuspend_u24lambda_u240.getSubtitle().onRollback(), (r22 & BR.hallEnterHotText) != 0 ? $this$invokeSuspend_u24lambda_u240.trackParams : null);
                BLog.d(MineVipModuleManagerKt.TAG, "rollback.(" + model + ")");
                this.label = 1;
                if (this.this$0.modelFlow.emit(model, (Continuation) this) != coroutine_suspended) {
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
        return Unit.INSTANCE;
    }
}