package tv.danmaku.biliplayerimpl.functionwidget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService;
import tv.danmaku.biliplayerv2.service.PlayerStateObserver;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: FunctionWidgetService.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"tv/danmaku/biliplayerimpl/functionwidget/FunctionWidgetService$mPlayerStateObserver$1", "Ltv/danmaku/biliplayerv2/service/PlayerStateObserver;", "onPlayerStateChanged", "", "state", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetService$mPlayerStateObserver$1 implements PlayerStateObserver {
    final /* synthetic */ FunctionWidgetService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FunctionWidgetService$mPlayerStateObserver$1(FunctionWidgetService $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerStateObserver
    public void onPlayerStateChanged(int state) {
        boolean z;
        if (state == 6) {
            z = this.this$0.mDismissWidgetWhenVideoCompleted;
            if (!z) {
                return;
            }
            FunctionWidgetService functionWidgetService = this.this$0;
            final FunctionWidgetService functionWidgetService2 = this.this$0;
            functionWidgetService.visitFunctionWidgets(new Function1() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionWidgetService$mPlayerStateObserver$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onPlayerStateChanged$lambda$0;
                    onPlayerStateChanged$lambda$0 = FunctionWidgetService$mPlayerStateObserver$1.onPlayerStateChanged$lambda$0(FunctionWidgetService.this, (FunctionWidgetService.FunctionWidgetRecord) obj);
                    return onPlayerStateChanged$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPlayerStateChanged$lambda$0(FunctionWidgetService this$0, FunctionWidgetService.FunctionWidgetRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it.getConfig().getFlag() & 32) != 0) {
            FunctionWidgetService.hideWidgetInternal$default(this$0, it, false, 2, null);
        }
        return Unit.INSTANCE;
    }
}