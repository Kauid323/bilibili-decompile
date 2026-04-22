package tv.danmaku.bili.appwidget;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bapis.bilibili.app.show.mixture.v1.KGuideItem;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kntr.app.appwidget.guide.AppWidgetGuideHolder;
import kntr.app.appwidget.guide.GuideState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.guide.AddWidgetGuidePopupWindowManager;
import tv.danmaku.bili.appwidget.guide.WidgetGuideKt;

/* compiled from: AutoAddAppWidgetServiceImpl.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2", f = "AutoAddAppWidgetServiceImpl.kt", i = {}, l = {BR.containerVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ AppWidgetGuideHolder $holder;
    final /* synthetic */ GuideScene $scene;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2(AppWidgetGuideHolder appWidgetGuideHolder, FragmentActivity fragmentActivity, GuideScene guideScene, Continuation<? super AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2> continuation) {
        super(2, continuation);
        this.$holder = appWidgetGuideHolder;
        this.$activity = fragmentActivity;
        this.$scene = guideScene;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2(this.$holder, this.$activity, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                StateFlow stateFlow = this.$holder.getStateFlow();
                final FragmentActivity fragmentActivity = this.$activity;
                final GuideScene guideScene = this.$scene;
                this.label = 1;
                if (stateFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.appwidget.AutoAddAppWidgetServiceImpl$tryToAddAppWidgetV2$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((GuideState) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(GuideState state, Continuation<? super Unit> continuation) {
                        KGuideItem it;
                        if (fragmentActivity.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) && (state instanceof GuideState.PerformAction) && (it = ((GuideState.PerformAction) state).getItem()) != null) {
                            AddWidgetGuidePopupWindowManager.INSTANCE.tryToAddWidget(fragmentActivity, guideScene, WidgetGuideKt.convert(it));
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        throw new KotlinNothingValueException();
    }
}