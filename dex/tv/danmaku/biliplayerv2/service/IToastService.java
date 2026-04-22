package tv.danmaku.biliplayerv2.service;

import android.graphics.Rect;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IToastService.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\bH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H'J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001cÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IToastService;", "Ltv/danmaku/biliplayerv2/service/IWithViewPlayerService;", "toastAvailableFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getToastAvailableFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "showToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "dismissToast", "removeAllToast", "setToastAvailable", "available", "isToastAvailable", "notifyScreenModeTypeChanged", "type", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "setPadding", "rect", "Landroid/graphics/Rect;", "fixedLocation", "location", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IToastService extends IWithViewPlayerService {
    void dismissToast(PlayerToast playerToast);

    boolean dispatchTouchEvent(MotionEvent motionEvent);

    void fixedLocation(int i);

    StateFlow<Boolean> getToastAvailableFlow();

    boolean isToastAvailable();

    void notifyScreenModeTypeChanged(ScreenModeType screenModeType);

    void removeAllToast();

    void setPadding(Rect rect);

    void setToastAvailable(boolean z);

    void showToast(PlayerToast playerToast);

    /* compiled from: IToastService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IToastService$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$dispatchTouchEvent(IToastService _this, MotionEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return false;
        }
    }
}