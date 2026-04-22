package tv.danmaku.biliplayerimpl.toast;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bilibili.base.BiliContext;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.center.CenterToastView;
import tv.danmaku.biliplayerimpl.toast.left.LeftToastView;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.ScreenModeType;
import tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.service.IWindowInsetObserver;
import tv.danmaku.biliplayerv2.service.WindowInset;
import tv.danmaku.biliplayerv2.utils.DpUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ToastContainer.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00017B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0007\u0010\u000bB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u0007\u0010\u000eJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010)\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0018H\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u0010H\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0016J(\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\r2\u0006\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/ToastContainer;", "Landroid/widget/FrameLayout;", "Ltv/danmaku/biliplayerimpl/toast/IToastContainer;", "Ltv/danmaku/biliplayerv2/panel/IVideoInsetChangedObserver;", "Ltv/danmaku/biliplayerv2/service/IWindowInsetObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mLeftToastView", "Ltv/danmaku/biliplayerimpl/toast/left/LeftToastView;", "mCenterToastView", "Ltv/danmaku/biliplayerimpl/toast/center/CenterToastView;", "mPaddingRect", "Landroid/graphics/Rect;", "mScreenModeType", "Ltv/danmaku/biliplayerv2/ScreenModeType;", "mMainHandler", "Landroid/os/Handler;", "mIsReleased", "", "showToast", "", "toast", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "removeAllToast", "setPadding", "rect", "dismissToast", "setScreenModeType", "type", "release", "refreshToast", "refreshLeftToastViewPadding", "bindPlayerContainer", "playerContainer", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "onWindowInsetChanged", "windowInset", "Ltv/danmaku/biliplayerv2/service/WindowInset;", "windowInsetChanged", "leftPadding", "topPadding", "rightPadding", "bottomPadding", "Companion", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ToastContainer extends FrameLayout implements IToastContainer, IVideoInsetChangedObserver, IWindowInsetObserver {
    private CenterToastView mCenterToastView;
    private boolean mIsReleased;
    private LeftToastView mLeftToastView;
    private Handler mMainHandler;
    private Rect mPaddingRect;
    private PlayerContainer mPlayerContainer;
    private ScreenModeType mScreenModeType;
    public static final Companion Companion = new Companion(null);
    private static final int LANDSCAPE_FULLSCREEN_BOTTOM_PADDING = (int) DpUtils.dp2px(BiliContext.application(), 70.0f);
    private static final int VERTICAL_FULLSCREEN_BOTTOM_PADDING = (int) DpUtils.dp2px(BiliContext.application(), 238.0f);
    private static final int THUMB_BOTTOM_PADDING = (int) DpUtils.dp2px(BiliContext.application(), 38.0f);
    private static final int WINDOW_INSET_LEFT_PADDING = (int) DpUtils.dp2px(BiliContext.application(), 8.0f);

    /* compiled from: ToastContainer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ScreenModeType.values().length];
            try {
                iArr[ScreenModeType.LANDSCAPE_FULLSCREEN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ScreenModeType.VERTICAL_FULLSCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ScreenModeType.THUMB.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: ToastContainer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/ToastContainer$Companion;", "", "<init>", "()V", "LANDSCAPE_FULLSCREEN_BOTTOM_PADDING", "", "VERTICAL_FULLSCREEN_BOTTOM_PADDING", "THUMB_BOTTOM_PADDING", "WINDOW_INSET_LEFT_PADDING", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScreenModeType = ScreenModeType.THUMB;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScreenModeType = ScreenModeType.THUMB;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScreenModeType = ScreenModeType.THUMB;
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void showToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (this.mIsReleased) {
            return;
        }
        LeftToastView leftToastView = null;
        CenterToastView centerToastView = null;
        switch (toast.getLocation()) {
            case 32:
                if (this.mLeftToastView == null) {
                    PlayerContainer playerContainer = this.mPlayerContainer;
                    if (playerContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer = null;
                    }
                    this.mLeftToastView = new LeftToastView(playerContainer.getContext(), this, this.mMainHandler);
                    refreshToast(this.mScreenModeType);
                }
                LeftToastView leftToastView2 = this.mLeftToastView;
                if (leftToastView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                } else {
                    leftToastView = leftToastView2;
                }
                leftToastView.addToast(toast);
                return;
            case 33:
            case 34:
                if (this.mCenterToastView == null) {
                    PlayerContainer playerContainer2 = this.mPlayerContainer;
                    if (playerContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
                        playerContainer2 = null;
                    }
                    this.mCenterToastView = new CenterToastView(playerContainer2.getContext(), this);
                    refreshToast(this.mScreenModeType);
                }
                CenterToastView centerToastView2 = this.mCenterToastView;
                if (centerToastView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
                } else {
                    centerToastView = centerToastView2;
                }
                centerToastView.showToast(toast, toast.getLocation());
                return;
            default:
                return;
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void removeAllToast() {
        CenterToastView centerToastView = null;
        if (this.mLeftToastView != null) {
            LeftToastView leftToastView = this.mLeftToastView;
            if (leftToastView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                leftToastView = null;
            }
            leftToastView.removeAll();
        }
        if (this.mCenterToastView != null) {
            CenterToastView centerToastView2 = this.mCenterToastView;
            if (centerToastView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
            } else {
                centerToastView = centerToastView2;
            }
            centerToastView.dismiss();
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void setPadding(Rect rect) {
        this.mPaddingRect = rect;
        refreshLeftToastViewPadding(this.mScreenModeType);
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void dismissToast(PlayerToast toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        CenterToastView centerToastView = null;
        LeftToastView leftToastView = null;
        if (toast.getLocation() == 32) {
            if (this.mLeftToastView != null) {
                LeftToastView leftToastView2 = this.mLeftToastView;
                if (leftToastView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                } else {
                    leftToastView = leftToastView2;
                }
                leftToastView.removeToast(toast);
            }
        } else if (toast.getLocation() == 33 && this.mCenterToastView != null) {
            CenterToastView centerToastView2 = this.mCenterToastView;
            if (centerToastView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
            } else {
                centerToastView = centerToastView2;
            }
            centerToastView.dismiss();
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void setScreenModeType(ScreenModeType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type != this.mScreenModeType) {
            this.mScreenModeType = type;
            refreshToast(type);
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.IToastContainer
    public void release() {
        this.mIsReleased = true;
        PlayerContainer playerContainer = this.mPlayerContainer;
        if (playerContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPlayerContainer");
            playerContainer = null;
        }
        playerContainer.getActivityStateService().registerWindowInset(this);
        if (this.mLeftToastView != null) {
            LeftToastView leftToastView = this.mLeftToastView;
            if (leftToastView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                leftToastView = null;
            }
            leftToastView.removeAll();
        }
        if (this.mCenterToastView != null) {
            CenterToastView centerToastView = this.mCenterToastView;
            if (centerToastView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
                centerToastView = null;
            }
            centerToastView.release();
        }
        this.mMainHandler.removeCallbacksAndMessages(null);
    }

    private final void refreshToast(ScreenModeType type) {
        CenterToastView centerToastView = null;
        if (type == ScreenModeType.LANDSCAPE_FULLSCREEN) {
            if (this.mLeftToastView != null) {
                LeftToastView leftToastView = this.mLeftToastView;
                if (leftToastView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                    leftToastView = null;
                }
                leftToastView.scale(1.0f);
                refreshLeftToastViewPadding(type);
            }
            if (this.mCenterToastView != null) {
                CenterToastView centerToastView2 = this.mCenterToastView;
                if (centerToastView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
                } else {
                    centerToastView = centerToastView2;
                }
                centerToastView.scale(1.0f);
            }
        } else if (type == ScreenModeType.VERTICAL_FULLSCREEN) {
            if (this.mLeftToastView != null) {
                LeftToastView leftToastView2 = this.mLeftToastView;
                if (leftToastView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                    leftToastView2 = null;
                }
                leftToastView2.scale(1.0f);
                refreshLeftToastViewPadding(type);
            }
            if (this.mCenterToastView != null) {
                CenterToastView centerToastView3 = this.mCenterToastView;
                if (centerToastView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
                } else {
                    centerToastView = centerToastView3;
                }
                centerToastView.scale(1.0f);
            }
        } else if (type == ScreenModeType.THUMB) {
            if (this.mLeftToastView != null) {
                LeftToastView leftToastView3 = this.mLeftToastView;
                if (leftToastView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
                    leftToastView3 = null;
                }
                leftToastView3.scale(1.0f);
                refreshLeftToastViewPadding(type);
            }
            if (this.mCenterToastView != null) {
                CenterToastView centerToastView4 = this.mCenterToastView;
                if (centerToastView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCenterToastView");
                } else {
                    centerToastView = centerToastView4;
                }
                centerToastView.scale(1.0f);
            }
        }
    }

    private final void refreshLeftToastViewPadding(ScreenModeType type) {
        int i;
        if (this.mLeftToastView == null) {
            return;
        }
        LeftToastView leftToastView = null;
        if (this.mPaddingRect == null) {
            LeftToastView leftToastView2 = this.mLeftToastView;
            if (leftToastView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
            } else {
                leftToastView = leftToastView2;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 1:
                    i = LANDSCAPE_FULLSCREEN_BOTTOM_PADDING;
                    break;
                case 2:
                    i = VERTICAL_FULLSCREEN_BOTTOM_PADDING;
                    break;
                case 3:
                    i = THUMB_BOTTOM_PADDING;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            leftToastView.setMargin(0, 0, 0, i);
            return;
        }
        LeftToastView leftToastView3 = this.mLeftToastView;
        if (leftToastView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftToastView");
        } else {
            leftToastView = leftToastView3;
        }
        Rect rect = this.mPaddingRect;
        Intrinsics.checkNotNull(rect);
        int i2 = rect.left;
        Rect rect2 = this.mPaddingRect;
        Intrinsics.checkNotNull(rect2);
        int i3 = rect2.top;
        Rect rect3 = this.mPaddingRect;
        Intrinsics.checkNotNull(rect3);
        int i4 = rect3.right;
        Rect rect4 = this.mPaddingRect;
        Intrinsics.checkNotNull(rect4);
        leftToastView.setMargin(i2, i3, i4, rect4.bottom);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
        playerContainer.getActivityStateService().registerWindowInset(this);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver
    public void onVideoInsetChanged(VideoInset inset) {
        Intrinsics.checkNotNullParameter(inset, "inset");
        Rect containerInset = inset.getContainerInset();
        if (containerInset == null) {
            return;
        }
        windowInsetChanged(containerInset.left, containerInset.top, containerInset.right, containerInset.bottom);
    }

    @Override // tv.danmaku.biliplayerv2.service.IWindowInsetObserver
    public void onWindowInsetChanged(WindowInset windowInset) {
        Intrinsics.checkNotNullParameter(windowInset, "windowInset");
        windowInsetChanged(windowInset.getLeftPadding() - WINDOW_INSET_LEFT_PADDING, windowInset.getTopPadding(), windowInset.getRightPadding(), windowInset.getBottomPadding());
    }

    private final void windowInsetChanged(int leftPadding, int topPadding, int rightPadding, int bottomPadding) {
        int left;
        int top;
        int right;
        int bottom = 0;
        if (leftPadding > 0) {
            left = leftPadding;
        } else {
            left = 0;
        }
        if (topPadding > 0) {
            top = topPadding;
        } else {
            top = 0;
        }
        if (rightPadding > 0) {
            right = rightPadding;
        } else {
            right = 0;
        }
        if (bottomPadding > 0) {
            bottom = bottomPadding;
        }
        setPadding(left, top, right, bottom);
    }
}