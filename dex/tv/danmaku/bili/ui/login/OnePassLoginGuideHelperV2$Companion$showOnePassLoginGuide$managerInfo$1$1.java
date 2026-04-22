package tv.danmaku.bili.ui.login;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.dialogmanager.MainDialogManager;
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
/* compiled from: OnePassLoginGuideHelperV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.login.OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1", f = "OnePassLoginGuideHelperV2.kt", i = {}, l = {BR.desc}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ String $fromSpmid;
    final /* synthetic */ boolean $fromVideo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1(String str, FragmentActivity fragmentActivity, boolean z, Continuation<? super OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1> continuation) {
        super(2, continuation);
        this.$fromSpmid = str;
        this.$activity = fragmentActivity;
        this.$fromVideo = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OnePassLoginGuideHelperV2$Companion$showOnePassLoginGuide$managerInfo$1$1(this.$fromSpmid, this.$activity, this.$fromVideo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object limitOrShowOnePass;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                limitOrShowOnePass = OnePassLoginGuideHelperV2.Companion.limitOrShowOnePass(this.$fromSpmid, this.$activity, this.$fromVideo, (Continuation) this);
                if (limitOrShowOnePass != coroutine_suspended) {
                    $result = limitOrShowOnePass;
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
        if (((Boolean) $result).booleanValue()) {
            MainDialogManager.showNextDialog("login_guide", false, this.$activity);
        }
        return Unit.INSTANCE;
    }
}