package tv.danmaku.biliplayerv2.service;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidgetService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 *2\u00020\u0001:\u0001*J\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J.\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u001a\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0003H&J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0012\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0014H&J\b\u0010\u001a\u001a\u00020\u0014H&J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\b\u0010\u001f\u001a\u00020\u0016H'J\b\u0010 \u001a\u00020\tH'J\b\u0010!\u001a\u00020\tH'J\b\u0010\"\u001a\u00020\u0016H'J\b\u0010#\u001a\u00020\tH&J\b\u0010$\u001a\u00020\tH&J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0016H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "showWidget", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "widget", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "layoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "hideWidget", "", "clazz", "Ljava/lang/Class;", "configuration", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget$Configuration;", "token", "hideAllWidget", "removeWidget", "updateFunctionWidgetConfiguration", "updateFunctionWidgetAttribute", "attribute", "", "usable", "", "disableBufferingView", "disable", "getAvailableWidth", "getAvailableHeight", "addOnWidgetStateChangeListener", "listener", "Ltv/danmaku/biliplayerv2/service/OnWidgetStateChangeListener;", "removeOnWidgetStateChangeListener", "onBackPressed", "notifyControllerTypeChanged", "notifyVideoChanged", "changeOrientationEnable", "showBufferingWidget", "hideBufferingWidget", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "setDismissWidgetWhenVideoCompleted", "dismiss", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface AbsFunctionWidgetService extends IWithViewPlayerService {
    public static final Companion Companion = Companion.$$INSTANCE;

    void addOnWidgetStateChangeListener(OnWidgetStateChangeListener onWidgetStateChangeListener);

    boolean changeOrientationEnable();

    void disableBufferingView(boolean z);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    int getAvailableHeight();

    int getAvailableWidth();

    void hideAllWidget();

    void hideBufferingWidget();

    void hideWidget(FunctionWidgetToken functionWidgetToken);

    void hideWidget(AbsFunctionWidget absFunctionWidget);

    void notifyControllerTypeChanged();

    void notifyVideoChanged();

    boolean onBackPressed();

    void removeOnWidgetStateChangeListener(OnWidgetStateChangeListener onWidgetStateChangeListener);

    void removeWidget(FunctionWidgetToken functionWidgetToken);

    void setDismissWidgetWhenVideoCompleted(boolean z);

    void showBufferingWidget();

    FunctionWidgetToken showWidget(Class<? extends AbsFunctionWidget> cls, IFunctionContainer.LayoutParams layoutParams);

    FunctionWidgetToken showWidget(Class<? extends AbsFunctionWidget> cls, IFunctionContainer.LayoutParams layoutParams, AbsFunctionWidget.Configuration configuration);

    FunctionWidgetToken showWidget(AbsFunctionWidget absFunctionWidget, IFunctionContainer.LayoutParams layoutParams);

    void showWidget(FunctionWidgetToken functionWidgetToken);

    void showWidget(FunctionWidgetToken functionWidgetToken, AbsFunctionWidget.Configuration configuration);

    void updateFunctionWidgetAttribute(FunctionWidgetToken functionWidgetToken, int i, boolean z);

    void updateFunctionWidgetConfiguration(FunctionWidgetToken functionWidgetToken, AbsFunctionWidget.Configuration configuration);

    /* compiled from: IFunctionWidgetService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService$Companion;", "", "<init>", "()V", "EmptyLayoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "getEmptyLayoutParams", "()Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final IFunctionContainer.LayoutParams EmptyLayoutParams = new IFunctionContainer.LayoutParams(-2, -2);

        private Companion() {
        }

        public final IFunctionContainer.LayoutParams getEmptyLayoutParams() {
            return EmptyLayoutParams;
        }
    }

    /* compiled from: IFunctionWidgetService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = AbsFunctionWidgetService.Companion;
        }

        public static /* synthetic */ FunctionWidgetToken showWidget$default(AbsFunctionWidgetService absFunctionWidgetService, AbsFunctionWidget absFunctionWidget, IFunctionContainer.LayoutParams layoutParams, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    layoutParams = AbsFunctionWidgetService.Companion.getEmptyLayoutParams();
                }
                return absFunctionWidgetService.showWidget(absFunctionWidget, layoutParams);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWidget");
        }

        public static /* synthetic */ FunctionWidgetToken showWidget$default(AbsFunctionWidgetService absFunctionWidgetService, Class cls, IFunctionContainer.LayoutParams layoutParams, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    layoutParams = AbsFunctionWidgetService.Companion.getEmptyLayoutParams();
                }
                return absFunctionWidgetService.showWidget(cls, layoutParams);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWidget");
        }

        public static /* synthetic */ FunctionWidgetToken showWidget$default(AbsFunctionWidgetService absFunctionWidgetService, Class cls, IFunctionContainer.LayoutParams layoutParams, AbsFunctionWidget.Configuration configuration, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    layoutParams = AbsFunctionWidgetService.Companion.getEmptyLayoutParams();
                }
                return absFunctionWidgetService.showWidget(cls, layoutParams, configuration);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showWidget");
        }

        public static /* synthetic */ void disableBufferingView$default(AbsFunctionWidgetService absFunctionWidgetService, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: disableBufferingView");
            }
            if ((i & 1) != 0) {
                z = true;
            }
            absFunctionWidgetService.disableBufferingView(z);
        }

        public static boolean $default$dispatchTouchEvent(AbsFunctionWidgetService _this, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }
    }
}