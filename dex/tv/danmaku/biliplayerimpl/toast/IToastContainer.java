package tv.danmaku.biliplayerimpl.toast;

import android.graphics.Rect;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.widget.IWidget;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IToastContainer.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/IToastContainer;", "Ltv/danmaku/biliplayerv2/widget/IWidget;", "showToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "dismissToast", "removeAllToast", "setScreenModeType", "type", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "setPadding", "rect", "Landroid/graphics/Rect;", "release", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IToastContainer extends IWidget {
    void dismissToast(PlayerToast playerToast);

    void release();

    void removeAllToast();

    void setPadding(Rect rect);

    void setScreenModeType(ScreenModeType screenModeType);

    void showToast(PlayerToast playerToast);
}