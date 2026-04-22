package tv.danmaku.biliplayerimpl.toast;

import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bilibili.api.BiliConfig;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.biliplayerimpl.AbsCorePlayerService;
import tv.danmaku.biliplayerimpl.PlayerContainerImpl;
import tv.danmaku.biliplayerimpl.R;
import tv.danmaku.biliplayerv2.PlayerContainerKt;
import tv.danmaku.biliplayerv2.PlayerSharingBundle;
import tv.danmaku.biliplayerv2.PlayerSharingType;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.panel.BuiltInLayer;
import tv.danmaku.biliplayerv2.panel.IPanelContainer;
import tv.danmaku.biliplayerv2.service.IToastService;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: ToastService.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0014H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\nH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010/\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020-H\u0016J\b\u00100\u001a\u00020\u001cH\u0016J\u0010\u00101\u001a\u00020\n2\u0006\u00102\u001a\u000203H\u0016J\u0012\u00104\u001a\u00020\u001c2\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020\u001cH\u0016J\b\u00108\u001a\u00020\u001cH\u0002J\u0010\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020\bH\u0016J\u0018\u0010;\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020=2\u0006\u00105\u001a\u000206H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006>"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/ToastService;", "Ltv/danmaku/biliplayerv2/service/IToastService;", "Ltv/danmaku/biliplayerimpl/AbsCorePlayerService;", "<init>", "()V", "mToastContainer", "Ltv/danmaku/biliplayerimpl/toast/IToastContainer;", "mPlayerContainer", "Ltv/danmaku/biliplayerimpl/PlayerContainerImpl;", "mToastAvailable", "", "getMToastAvailable", "()Z", "_toastAvailableFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "toastAvailableFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getToastAvailableFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "mFixedlocation", "", "mIgnoreContent", "", "getMIgnoreContent", "()Ljava/lang/String;", "mIgnoreContent$delegate", "Lkotlin/Lazy;", "notifyScreenModeTypeChanged", "", "type", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "setPadding", "rect", "Landroid/graphics/Rect;", "fixedLocation", "location", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "setToastAvailable", "available", "isToastAvailable", "showToast", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "showToastInternal", "dismissToast", "removeAllToast", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onStart", "bundle", "Ltv/danmaku/biliplayerv2/PlayerSharingBundle;", "onStop", "ensureToastContainer", "bindPlayerContainer", "playerContainer", "onCollectSharedParams", "sharingType", "Ltv/danmaku/biliplayerv2/PlayerSharingType;", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ToastService extends AbsCorePlayerService implements IToastService {
    private int mFixedlocation;
    private PlayerContainerImpl mPlayerContainer;
    private IToastContainer mToastContainer;
    private final MutableStateFlow<Boolean> _toastAvailableFlow = StateFlowKt.MutableStateFlow(true);
    private final Lazy mIgnoreContent$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.biliplayerimpl.toast.ToastService$$ExternalSyntheticLambda1
        public final Object invoke() {
            String mIgnoreContent_delegate$lambda$0;
            mIgnoreContent_delegate$lambda$0 = ToastService.mIgnoreContent_delegate$lambda$0();
            return mIgnoreContent_delegate$lambda$0;
        }
    });

    private final boolean getMToastAvailable() {
        return ((Boolean) this._toastAvailableFlow.getValue()).booleanValue();
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public StateFlow<Boolean> getToastAvailableFlow() {
        return EnhancedUnmodifiabilityKt.unmodifiable(FlowKt.asStateFlow(this._toastAvailableFlow));
    }

    private final String getMIgnoreContent() {
        return (String) this.mIgnoreContent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mIgnoreContent_delegate$lambda$0() {
        List configInfo;
        String config = (String) ConfigManager.Companion.config().get("videodetail.player_toast_ignore", (Object) null);
        if (config != null) {
            try {
                configInfo = StringsKt.split$default(config, new String[]{","}, false, 0, 6, (Object) null);
            } catch (Exception e) {
            }
        } else {
            configInfo = null;
        }
        boolean z = true;
        if (configInfo != null && configInfo.size() == 3) {
            if (((CharSequence) configInfo.get(0)).length() > 0) {
                int currentCode = BiliConfig.getBiliVersionCode();
                int minVersionCode = Integer.parseInt((String) configInfo.get(1));
                int maxVersionCode = Integer.parseInt((String) configInfo.get(2));
                if (minVersionCode > currentCode || currentCode > maxVersionCode) {
                    z = false;
                }
                if (z) {
                    return (String) configInfo.get(0);
                }
            }
        }
        return null;
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void notifyScreenModeTypeChanged(ScreenModeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.setScreenModeType(type);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void setPadding(Rect rect) {
        ensureToastContainer();
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.setPadding(rect);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void fixedLocation(int location) {
        this.mFixedlocation = location;
    }

    @Override // tv.danmaku.biliplayerv2.service.IWithViewPlayerService
    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ToastContainer toastContainer = new ToastContainer(context);
        PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
        PlayerContainerImpl playerContainerImpl2 = null;
        if (playerContainerImpl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainerImpl = null;
        }
        toastContainer.setScreenModeType(playerContainerImpl.getControlContainerService().getScreenModeType());
        PlayerContainerImpl playerContainerImpl3 = this.mPlayerContainer;
        if (playerContainerImpl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
        } else {
            playerContainerImpl2 = playerContainerImpl3;
        }
        toastContainer.bindPlayerContainer(playerContainerImpl2);
        this.mToastContainer = toastContainer;
        return toastContainer;
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void setToastAvailable(boolean available) {
        if (getMToastAvailable() != available) {
            IToastContainer iToastContainer = this.mToastContainer;
            if (iToastContainer != null) {
                iToastContainer.removeAllToast();
            }
            this._toastAvailableFlow.setValue(Boolean.valueOf(available));
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public boolean isToastAvailable() {
        return getMToastAvailable();
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void showToast(final PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            showToastInternal(toast);
        } else {
            HandlerThreads.post(0, new Runnable() { // from class: tv.danmaku.biliplayerimpl.toast.ToastService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ToastService.this.showToastInternal(toast);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showToastInternal(PlayerToast toast) {
        boolean z;
        if (!getMToastAvailable()) {
            return;
        }
        String toastText = toast.getExtraString(PlayerToastConfig.EXTRA_TITLE);
        if (getMIgnoreContent() != null) {
            if (toastText != null) {
                String mIgnoreContent = getMIgnoreContent();
                Intrinsics.checkNotNull(mIgnoreContent);
                if (StringsKt.contains$default(toastText, mIgnoreContent, false, 2, (Object) null)) {
                    z = true;
                    if (z) {
                        PlayerLog.i(PlayerContainerKt.TAG, "show toast fail, cause config ignore: " + toastText);
                        return;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        if (this.mFixedlocation != 0 && toast.getLocation() != this.mFixedlocation && (this.mFixedlocation != 33 || toast.getToastType() == 17 || toast.getToastType() == 20)) {
            toast.setLocation(this.mFixedlocation);
        }
        PlayerLog.i(PlayerContainerKt.TAG, "player show toast: " + toastText);
        ensureToastContainer();
        if (toast.getToastType() == 20) {
            Application application = BiliContext.application();
            Intrinsics.checkNotNull(application);
            Toast newToast = new Toast(application.getApplicationContext());
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            View view2 = LayoutInflater.from(playerContainerImpl.getContext()).inflate(R.layout.bili_app_player_top_center_toast, (ViewGroup) null);
            TextView tvMessage = (TextView) view2.findViewById(tv.danmaku.biliplayerv2.R.id.message);
            tvMessage.setText(toastText);
            newToast.setView(view2);
            newToast.setDuration(toast.getDuration() < PlayerToastConfig.DURATION_2 ? 0 : 1);
            newToast.setGravity(17, 0, 0);
            ToastHelper.showToastSafely(newToast);
            return;
        }
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.showToast(toast);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void dismissToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.dismissToast(toast);
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public void removeAllToast() {
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.removeAllToast();
        }
    }

    @Override // tv.danmaku.biliplayerv2.service.IToastService
    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IToastContainer iToastContainer = this.mToastContainer;
        View view2 = iToastContainer instanceof View ? (View) iToastContainer : null;
        if (view2 != null) {
            return view2.dispatchTouchEvent(event);
        }
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStart(PlayerSharingBundle bundle) {
    }

    @Override // tv.danmaku.biliplayerv2.service.IPlayerService
    public void onStop() {
        IToastContainer iToastContainer = this.mToastContainer;
        if (iToastContainer != null) {
            iToastContainer.release();
        }
    }

    private final void ensureToastContainer() {
        if (this.mToastContainer == null) {
            PlayerContainerImpl playerContainerImpl = this.mPlayerContainer;
            if (playerContainerImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                playerContainerImpl = null;
            }
            IPanelContainer panelContainer = playerContainerImpl.getPanelContainer();
            if (panelContainer != null) {
                panelContainer.ensureBuiltInLayer(BuiltInLayer.LayerToast, this);
            }
        }
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService
    public void bindPlayerContainer(PlayerContainerImpl playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    @Override // tv.danmaku.biliplayerimpl.AbsCorePlayerService, tv.danmaku.biliplayerv2.service.IPlayerService
    public void onCollectSharedParams(PlayerSharingType sharingType, PlayerSharingBundle bundle) {
        Intrinsics.checkNotNullParameter(sharingType, "sharingType");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        removeAllToast();
    }
}