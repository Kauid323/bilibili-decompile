package tv.danmaku.biliplayerv2.service;

import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IControlContainerService.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u000eH&J\b\u0010\u0014\u001a\u00020\u000eH&J\b\u0010\u0015\u001a\u00020\tH&J\b\u0010\u0016\u001a\u00020\tH&J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0007H&J\b\u0010\u001c\u001a\u00020\u0019H&J\b\u0010\u001d\u001a\u00020\u000eH&J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u000eH&J\u0012\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020\tH&J\b\u0010$\u001a\u00020\tH&J\b\u0010%\u001a\u00020\u000eH&J\b\u0010&\u001a\u00020\u000eH&J\u001a\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0005H&J\u0012\u0010)\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010*H&J\b\u0010+\u001a\u00020\u000eH&J\u0010\u0010,\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0005H&J\u0010\u0010-\u001a\u00020\t2\u0006\u0010\n\u001a\u00020.H&J\u0010\u0010/\u001a\u00020\t2\u0006\u0010\n\u001a\u00020.H&J\u001c\u00100\u001a\u00020\t2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020302H&J\u0012\u00104\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u000106H&J\n\u00107\u001a\u0004\u0018\u000106H&J(\u00108\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u00109\u001a\u00020\u00072\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006=À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IControlContainerService;", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "getScreenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "getState", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "getBottomSubtitleBlock", "", "registerState", "", "observer", "Ltv/danmaku/biliplayerv2/service/ControlContainerObserver;", "unregisterState", "switchTo", "", "type", "registerControlContainerVisible", "Ltv/danmaku/biliplayerv2/service/ControlContainerVisibleObserver;", "unregisterControlContainerVisible", "isShowing", "isAlwaysShowing", "show", "hide", "setControlAlpha", "alpha", "", "setControlWidgetAlpha", "widgetId", "getControlAlpha", "isImmersive", "setImmersive", "immersive", "setBackground", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "addHideTask", "removeHideTask", "onBackPressed", "isControllerEnable", "setControllerEnable", "enable", "setEditHandler", "Ltv/danmaku/biliplayerv2/service/ControlEditHandler;", "supportEdit", "editController", "registerWidgetChangedObserver", "Ltv/danmaku/biliplayerv2/service/ControlWidgetChangedObserver;", "unregisterWidgetChangedObserver", "setControlContainerConfig", "config", "", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "setScreenOrientationDelegate", "delegate", "Ltv/danmaku/biliplayerv2/service/ScreenOrientationDelegate;", "getScreenOrientationDelegate", "insertSlotWidgets", "slotContainerId", "slotWidgets", "", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IControlContainerService extends IWithViewPlayerService {
    void addHideTask();

    void editController(ControlContainerType controlContainerType);

    int getBottomSubtitleBlock();

    float getControlAlpha();

    ScreenModeType getScreenModeType();

    ScreenOrientationDelegate getScreenOrientationDelegate();

    ControlContainerType getState();

    void hide();

    boolean insertSlotWidgets(ControlContainerType controlContainerType, int i, List<? extends IControlWidget> list);

    boolean isAlwaysShowing();

    boolean isControllerEnable();

    boolean isImmersive();

    boolean isShowing();

    boolean onBackPressed();

    void registerControlContainerVisible(ControlContainerVisibleObserver controlContainerVisibleObserver);

    void registerState(ControlContainerObserver controlContainerObserver);

    void registerWidgetChangedObserver(ControlWidgetChangedObserver controlWidgetChangedObserver);

    void removeHideTask();

    void setBackground(Drawable drawable);

    void setControlAlpha(float f);

    void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map);

    void setControlWidgetAlpha(float f, int i);

    void setControllerEnable(boolean z, ControlContainerType controlContainerType);

    void setEditHandler(ControlEditHandler controlEditHandler);

    void setImmersive(int i, boolean z);

    void setScreenOrientationDelegate(ScreenOrientationDelegate screenOrientationDelegate);

    void show();

    boolean supportEdit();

    boolean switchTo(ControlContainerType controlContainerType);

    void unregisterControlContainerVisible(ControlContainerVisibleObserver controlContainerVisibleObserver);

    void unregisterState(ControlContainerObserver controlContainerObserver);

    void unregisterWidgetChangedObserver(ControlWidgetChangedObserver controlWidgetChangedObserver);

    /* compiled from: IControlContainerService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IControlContainerService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void setControllerEnable$default(IControlContainerService iControlContainerService, boolean z, ControlContainerType controlContainerType, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setControllerEnable");
            }
            if ((i & 2) != 0) {
                controlContainerType = ControlContainerType.NONE;
            }
            iControlContainerService.setControllerEnable(z, controlContainerType);
        }
    }
}