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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetGuideManager;
import tv.danmaku.bili.appwidget.guide.function.FunctionWidgetUtilsKt;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidget;

/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1", f = "AutoAddAppWidgetServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ GuideScene $scene;
    int label;
    final /* synthetic */ AutoAddAppWidgetServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1(AutoAddAppWidgetServiceImpl autoAddAppWidgetServiceImpl, FragmentActivity fragmentActivity, GuideScene guideScene, Continuation<? super AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1> continuation) {
        super(2, continuation);
        this.this$0 = autoAddAppWidgetServiceImpl;
        this.$activity = fragmentActivity;
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoAddAppWidgetServiceImpl$startFunctionWidgetGuide$1(this.this$0, this.$activity, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean checkAutoAddAppWidgetRequest;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String name = HotWordAppWidget.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                checkAutoAddAppWidgetRequest = this.this$0.checkAutoAddAppWidgetRequest(this.$activity, name);
                if (!checkAutoAddAppWidgetRequest) {
                    return Unit.INSTANCE;
                }
                if (FunctionWidgetUtilsKt.enableFunctionGuideWidget()) {
                    FunctionWidgetGuideManager.INSTANCE.registerFunctionGuide(this.$activity, this.$scene);
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}