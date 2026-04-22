package tv.danmaku.biliplayerimpl.functionwidget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService;
import tv.danmaku.biliplayerv2.service.LifecycleObserver;
import tv.danmaku.biliplayerv2.service.LifecycleState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FunctionWidgetService.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mActivityLifecycleObserver$1", "Ltv/danmaku/biliplayerv2/service/LifecycleObserver;", "onLifecycleChanged", "", "state", "Ltv/danmaku/biliplayerv2/service/LifecycleState;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetService$mActivityLifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ FunctionWidgetService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FunctionWidgetService$mActivityLifecycleObserver$1(FunctionWidgetService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.LifecycleObserver
    public void onLifecycleChanged(LifecycleState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == LifecycleState.ACTIVITY_STOP) {
            FunctionWidgetService functionWidgetService = this.this$0;
            final FunctionWidgetService functionWidgetService2 = this.this$0;
            functionWidgetService.visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mActivityLifecycleObserver$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onLifecycleChanged$lambda$0;
                    onLifecycleChanged$lambda$0 = FunctionWidgetService$mActivityLifecycleObserver$1.onLifecycleChanged$lambda$0(FunctionWidgetService.this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                    return onLifecycleChanged$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onLifecycleChanged$lambda$0(FunctionWidgetService this$0, FunctionWidgetService.FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.getConfig().getFlag() & 4) != 0) {
            FunctionWidgetService.hideWidgetInternal$default(this$0, it, false, 2, null);
        }
        return Unit.INSTANCE;
    }
}