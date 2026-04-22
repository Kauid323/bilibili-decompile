package tv.danmaku.bili.appwidget.guide.function;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.BiliContext;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FunctionWidgetGuideManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager$registerFunctionGuide$1", f = "FunctionWidgetGuideManager.kt", i = {0}, l = {BR.bgBarVisible}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class FunctionWidgetGuideManager$registerFunctionGuide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ GuideScene $scene;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionWidgetGuideManager$registerFunctionGuide$1(FragmentActivity fragmentActivity, GuideScene guideScene, Continuation<? super FunctionWidgetGuideManager$registerFunctionGuide$1> continuation) {
        super(2, continuation);
        this.$activity = fragmentActivity;
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> functionWidgetGuideManager$registerFunctionGuide$1 = new FunctionWidgetGuideManager$registerFunctionGuide$1(this.$activity, this.$scene, continuation);
        functionWidgetGuideManager$registerFunctionGuide$1.L$0 = obj;
        return functionWidgetGuideManager$registerFunctionGuide$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        RouteTraceManager routeTraceManager;
        Object initialRouteWhiteList;
        CoroutineScope $this$launch;
        FunctionWidgetGuideManager$callback$1 functionWidgetGuideManager$callback$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
                FunctionWidgetGuideManager functionWidgetGuideManager = FunctionWidgetGuideManager.INSTANCE;
                FunctionWidgetGuideManager.showGuide = false;
                FunctionWidgetGuideManager functionWidgetGuideManager2 = FunctionWidgetGuideManager.INSTANCE;
                FunctionWidgetGuideManager.reply = null;
                routeTraceManager = FunctionWidgetGuideManager.routeTraceManager;
                routeTraceManager.create((Activity) this.$activity, this.$scene);
                this.L$0 = $this$launch2;
                this.label = 1;
                initialRouteWhiteList = FunctionWidgetGuideManager.INSTANCE.initialRouteWhiteList((Continuation) this);
                if (initialRouteWhiteList == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$launch = $this$launch2;
                break;
            case 1:
                $this$launch = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        functionWidgetGuideManager$callback$1 = FunctionWidgetGuideManager.callback;
        BiliContext.registerActivityStateCallback(functionWidgetGuideManager$callback$1);
        CoroutineScope $this$awaitCancel$iv = $this$launch;
        BuildersKt.launch$default($this$awaitCancel$iv, (CoroutineContext) null, (CoroutineStart) null, new FunctionWidgetGuideManager$registerFunctionGuide$1$invokeSuspend$$inlined$awaitCancel$1(null, this.$activity, this.$scene), 3, (Object) null);
        return Unit.INSTANCE;
    }
}