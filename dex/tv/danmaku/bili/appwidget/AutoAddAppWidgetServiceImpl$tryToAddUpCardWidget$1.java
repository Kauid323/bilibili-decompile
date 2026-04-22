package tv.danmaku.bili.appwidget;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.moduleservice.appwidget.GuideScene;
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

/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1", f = "AutoAddAppWidgetServiceImpl.kt", i = {}, l = {BR.badgeUri, BR.banner}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ GuideScene $scene;
    int label;
    final /* synthetic */ AutoAddAppWidgetServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1(GuideScene guideScene, AutoAddAppWidgetServiceImpl autoAddAppWidgetServiceImpl, FragmentActivity fragmentActivity, Continuation<? super AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1> continuation) {
        super(2, continuation);
        this.$scene = guideScene;
        this.this$0 = autoAddAppWidgetServiceImpl;
        this.$activity = fragmentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoAddAppWidgetServiceImpl$tryToAddUpCardWidget$1(this.$scene, this.this$0, this.$activity, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object tryToAddAppWidgetV2;
        Object tryToAddAppWidgetFromMainSpace;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if ((this.$scene instanceof GuideScene.DynamicHome) || (this.$scene instanceof GuideScene.PlayerVideoDetail)) {
                    this.label = 1;
                    tryToAddAppWidgetV2 = this.this$0.tryToAddAppWidgetV2(this.$activity, this.$scene, (Continuation) this);
                    if (tryToAddAppWidgetV2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (this.$scene instanceof GuideScene.AuthorSpace) {
                    this.label = 2;
                    tryToAddAppWidgetFromMainSpace = this.this$0.tryToAddAppWidgetFromMainSpace(this.$activity, this.$scene, (Continuation) this);
                    if (tryToAddAppWidgetFromMainSpace == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}