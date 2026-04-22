package tv.danmaku.biliplayerv2.widget.function.progress;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.IPlayerCoreService;
import tv.danmaku.biliplayerv2.service.PlayerProgressObserver;
import tv.danmaku.biliplayerv2.view.SimpleProgressView;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SimpleProgressFunctionWidget.kt */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006\u001f"}, d2 = {"Ltv/danmaku/biliplayerv2/widget/function/progress/SimpleProgressFunctionWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mSimpleProgressView", "Ltv/danmaku/biliplayerv2/view/SimpleProgressView;", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "tag", "", "getTag", "()Ljava/lang/String;", "mPlayerProgressObserver", "tv/danmaku/biliplayerv2/widget/function/progress/SimpleProgressFunctionWidget$mPlayerProgressObserver$1", "Ltv/danmaku/biliplayerv2/widget/function/progress/SimpleProgressFunctionWidget$mPlayerProgressObserver$1;", "onWidgetShow", "", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "onWidgetDismiss", "createContentView", "Landroid/view/View;", "onRelease", "bindPlayerContainer", "playerContainer", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SimpleProgressFunctionWidget extends AbsFunctionWidget {
    private PlayerContainer mPlayerContainer;
    private final SimpleProgressFunctionWidget$mPlayerProgressObserver$1 mPlayerProgressObserver;
    private SimpleProgressView mSimpleProgressView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v1, types: [tv.danmaku.biliplayerv2.widget.function.progress.SimpleProgressFunctionWidget$mPlayerProgressObserver$1] */
    public SimpleProgressFunctionWidget(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPlayerProgressObserver = new PlayerProgressObserver() { // from class: tv.danmaku.biliplayerv2.widget.function.progress.SimpleProgressFunctionWidget$mPlayerProgressObserver$1
            @Override // tv.danmaku.biliplayerv2.service.PlayerProgressObserver
            public void onPlayerProgressChange(int progress, int duration) {
                SimpleProgressView simpleProgressView;
                simpleProgressView = SimpleProgressFunctionWidget.this.mSimpleProgressView;
                if (simpleProgressView != null) {
                    simpleProgressView.setProgress(progress, duration);
                }
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public FunctionWidgetConfig getFunctionWidgetConfig() {
        FunctionWidgetConfig.Builder builder = new FunctionWidgetConfig.Builder();
        builder.persistent(true);
        builder.dismissWhenVideoChange(false);
        builder.dismissWhenVideoCompleted(false);
        builder.dismissWhenScreenModeChange(false);
        builder.launchType(2);
        return builder.build();
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public String getTag() {
        return "SimpleProgressFunctionWidget";
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetShow() {
        SimpleProgressView simpleProgressView;
        IPlayerCoreService playerCoreService;
        super.onWidgetShow();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (playerCoreService = playerContainer.getPlayerCoreService()) != null) {
            playerCoreService.registerPlayerProgressObserver(this.mPlayerProgressObserver);
        }
        PlayerContainer it = this.mPlayerContainer;
        if (it == null || (simpleProgressView = this.mSimpleProgressView) == null) {
            return;
        }
        simpleProgressView.setProgress(it.getPlayerCoreService().getCurrentPosition(), it.getPlayerCoreService().getDuration());
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    public void onWidgetShow(AbsFunctionWidget.Configuration configuration) {
        super.onWidgetShow(configuration);
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onWidgetDismiss() {
        IPlayerCoreService playerCoreService;
        super.onWidgetDismiss();
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer != null && (playerCoreService = playerContainer.getPlayerCoreService()) != null) {
            playerCoreService.unregisterPlayerProgressObserver(this.mPlayerProgressObserver);
        }
        SimpleProgressView simpleProgressView = this.mSimpleProgressView;
        if (simpleProgressView != null) {
            simpleProgressView.reset();
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
    protected View createContentView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mSimpleProgressView = new SimpleProgressView(context);
        SimpleProgressView simpleProgressView = this.mSimpleProgressView;
        Intrinsics.checkNotNull(simpleProgressView);
        return simpleProgressView;
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
    public void onRelease() {
    }

    @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }
}