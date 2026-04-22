package tv.danmaku.biliplayerimpl.controlcontainer;

import android.graphics.drawable.Drawable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayerv2.ControlContainerConfig;
import tv.danmaku.biliplayerv2.ControlContainerType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.widget.IControlWidget;
import tv.danmaku.biliplayerv2.widget.IWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IControlContainer.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH&J\b\u0010\r\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0006H&J\b\u0010\u000f\u001a\u00020\u0010H&J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0012\u001a\u00020\tH&J\b\u0010\u0013\u001a\u00020\tH&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u0018H&J\b\u0010\u001d\u001a\u00020\tH&J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\tH&J\u0012\u0010 \u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"H&J\b\u0010#\u001a\u00020\u0003H&J\b\u0010$\u001a\u00020\u001bH&J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H&J\u0010\u0010'\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H&J(\u0010(\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020\u001b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006-À\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/controlcontainer/IControlContainer;", "Ltv/danmaku/biliplayerv2/widget/IWidget;", "setControlContainerConfig", "", "config", "", "Ltv/danmaku/biliplayerv2/ControlContainerType;", "Ltv/danmaku/biliplayerv2/ControlContainerConfig;", "switchTo", "", "type", "shouldCreateInstance", "targetVisibility", "initCurrentControlContainerStandalone", "getCurrentControlContainerType", "getCurrentControlContainerScreenType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "getCurrentControlContainerConfig", "isShowing", "isAlwaysShowing", "show", "hide", "setControlAlpha", "alpha", "", "setControlWidgetAlpha", "widgetId", "", "getControlAlpha", "isImmersive", "setImmersive", "immersive", "setBackground", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "release", "getBottomSubtitleBlock", "setControllerEnable", "enable", "getControllerEnable", "insertSlotWidgets", "slotContainerId", "slotWidgets", "", "Ltv/danmaku/biliplayerv2/widget/IControlWidget;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IControlContainer extends IWidget {
    int getBottomSubtitleBlock();

    float getControlAlpha();

    boolean getControllerEnable(ControlContainerType controlContainerType);

    ControlContainerConfig getCurrentControlContainerConfig();

    ScreenModeType getCurrentControlContainerScreenType();

    ControlContainerType getCurrentControlContainerType();

    void hide();

    boolean initCurrentControlContainerStandalone();

    boolean insertSlotWidgets(ControlContainerType controlContainerType, int i, List<? extends IControlWidget> list);

    boolean isAlwaysShowing();

    boolean isImmersive();

    boolean isShowing();

    void release();

    void setBackground(Drawable drawable);

    void setControlAlpha(float f);

    void setControlContainerConfig(Map<ControlContainerType, ControlContainerConfig> map);

    void setControlWidgetAlpha(float f, int i);

    void setControllerEnable(boolean z, ControlContainerType controlContainerType);

    void setImmersive(int i, boolean z);

    void show();

    boolean switchTo(ControlContainerType controlContainerType, boolean z, boolean z2);
}