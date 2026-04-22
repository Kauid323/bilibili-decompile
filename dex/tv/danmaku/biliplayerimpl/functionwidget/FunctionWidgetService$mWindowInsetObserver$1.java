package tv.danmaku.biliplayerimpl.functionwidget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService;
import tv.danmaku.biliplayerv2.service.FunctionWidgetInsetConfig;
import tv.danmaku.biliplayerv2.service.IWindowInsetObserver;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FunctionWidgetService.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mWindowInsetObserver$1", "Ltv/danmaku/biliplayerv2/service/IWindowInsetObserver;", "onWindowInsetChanged", "", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetService$mWindowInsetObserver$1 implements IWindowInsetObserver {
    final /* synthetic */ FunctionWidgetService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FunctionWidgetService$mWindowInsetObserver$1(FunctionWidgetService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.IWindowInsetObserver
    public void onWindowInsetChanged(final WindowInset windowInset) {
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        this.this$0.visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mWindowInsetObserver$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onWindowInsetChanged$lambda$0;
                onWindowInsetChanged$lambda$0 = FunctionWidgetService$mWindowInsetObserver$1.onWindowInsetChanged$lambda$0(WindowInset.this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                return onWindowInsetChanged$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onWindowInsetChanged$lambda$0(WindowInset $windowInset, FunctionWidgetService.FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isShowing()) {
            FunctionWidgetInsetConfig functionInsetConfig = it.getWidget().getFunctionInsetConfig();
            boolean z = false;
            if (functionInsetConfig != null && functionInsetConfig.getSupport()) {
                z = true;
            }
            if (z) {
                it.getWidget().onWindowInsetChanged($windowInset);
            }
        }
        return Unit.INSTANCE;
    }
}