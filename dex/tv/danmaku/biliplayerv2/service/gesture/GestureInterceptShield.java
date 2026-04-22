package tv.danmaku.biliplayerv2.service.gesture;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.service.FunctionWidgetConfig;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GestureInterceptShield.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptShield;", "", "<init>", "()V", "mGestureInterceptor", "Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptor;", "mToken", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "show", "", "functionWidgetService", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "setGestureInterceptor", "interceptor", "dismiss", "ShieldWidget", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GestureInterceptShield {
    private GestureInterceptor mGestureInterceptor;
    private FunctionWidgetToken mToken;

    public final void show(AbsFunctionWidgetService functionWidgetService) {
        Intrinsics.checkNotNullParameter(functionWidgetService, "functionWidgetService");
        IFunctionContainer.LayoutParams layoutParams = new IFunctionContainer.LayoutParams(-1, -1);
        layoutParams.setEnterAnim(-1);
        layoutParams.setExitAnim(-1);
        layoutParams.setFunctionType(1);
        this.mToken = functionWidgetService.showWidget(ShieldWidget.class, layoutParams);
        FunctionWidgetToken functionWidgetToken = this.mToken;
        Intrinsics.checkNotNull(functionWidgetToken);
        functionWidgetService.updateFunctionWidgetConfiguration(functionWidgetToken, new ShieldWidget.Configuration(this.mGestureInterceptor));
    }

    public final void setGestureInterceptor(AbsFunctionWidgetService functionWidgetService, GestureInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(functionWidgetService, "functionWidgetService");
        FunctionWidgetToken it = this.mToken;
        if (it != null) {
            functionWidgetService.updateFunctionWidgetConfiguration(it, new ShieldWidget.Configuration(interceptor));
        }
        this.mGestureInterceptor = interceptor;
    }

    public final void dismiss(AbsFunctionWidgetService functionWidgetService) {
        Intrinsics.checkNotNullParameter(functionWidgetService, "functionWidgetService");
        FunctionWidgetToken functionWidgetToken = this.mToken;
        boolean z = false;
        if (functionWidgetToken != null && functionWidgetToken.isShowing()) {
            z = true;
        }
        if (z) {
            FunctionWidgetToken functionWidgetToken2 = this.mToken;
            Intrinsics.checkNotNull(functionWidgetToken2);
            functionWidgetService.hideWidget(functionWidgetToken2);
            this.mToken = null;
        }
    }

    /* compiled from: GestureInterceptShield.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptShield$ShieldWidget;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "tag", "", "getTag", "()Ljava/lang/String;", "functionWidgetConfig", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "getFunctionWidgetConfig", "()Ltv/danmaku/biliplayerv2/service/FunctionWidgetConfig;", "mGestureInterceptor", "Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptor;", "createContentView", "Landroid/view/View;", "onTouch", "", "v", "event", "Landroid/view/MotionEvent;", "onRelease", "", "bindPlayerContainer", "playerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "onConfigurationChanged", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "Configuration", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ShieldWidget extends AbsFunctionWidget implements View.OnTouchListener {
        private GestureInterceptor mGestureInterceptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShieldWidget(Context context) {
            super(context);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IFunctionWidget
        public String getTag() {
            return "ShieldWidget";
        }

        @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
        public FunctionWidgetConfig getFunctionWidgetConfig() {
            return new FunctionWidgetConfig.Builder().persistent(false).launchType(2).build();
        }

        @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
        protected View createContentView(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            View contentView = new View(context);
            contentView.setTag("ShieldWidget");
            contentView.setOnTouchListener(this);
            return contentView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            GestureInterceptor gestureInterceptor = this.mGestureInterceptor;
            if (gestureInterceptor != null) {
                gestureInterceptor.onIntercept(event);
                return true;
            }
            return true;
        }

        @Override // tv.danmaku.biliplayerv2.widget.IFunctionWidget
        public void onRelease() {
        }

        @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget, tv.danmaku.biliplayerv2.widget.IWidget
        public void bindPlayerContainer(PlayerContainer playerContainer) {
            Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        }

        @Override // tv.danmaku.biliplayerv2.widget.AbsFunctionWidget
        public void onConfigurationChanged(AbsFunctionWidget.Configuration configuration) {
            Intrinsics.checkNotNullParameter(configuration, "configuration");
            if (configuration instanceof Configuration) {
                this.mGestureInterceptor = ((Configuration) configuration).getMGestureInterceptor();
            }
        }

        /* compiled from: GestureInterceptShield.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptShield$ShieldWidget$Configuration;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "mGestureInterceptor", "Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptor;", "<init>", "(Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptor;)V", "getMGestureInterceptor", "()Ltv/danmaku/biliplayerv2/service/gesture/GestureInterceptor;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Configuration extends AbsFunctionWidget.Configuration {
            private final GestureInterceptor mGestureInterceptor;

            public Configuration(GestureInterceptor mGestureInterceptor) {
                this.mGestureInterceptor = mGestureInterceptor;
            }

            public final GestureInterceptor getMGestureInterceptor() {
                return this.mGestureInterceptor;
            }
        }
    }
}