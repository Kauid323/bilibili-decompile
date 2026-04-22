package tv.danmaku.biliplayerimpl.functionwidget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.bilibili.droid.thread.HandlerThreads;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer;
import tv.danmaku.biliplayerv2.BuildConfig;
import tv.danmaku.biliplayerv2.PlayerContainer;
import tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver;
import tv.danmaku.biliplayerv2.panel.VideoInset;
import tv.danmaku.biliplayerv2.service.AbsFunctionWidgetService;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.log.PlayerLogModule;

/* compiled from: FunctionContainer.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0000\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003>?@B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000fH\u0016J\b\u0010$\u001a\u00020\"H\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\fH\u0014J0\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\fH\u0014J\u0018\u00104\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u001aH\u0002J\u0014\u00106\u001a\u00020\"2\n\u00107\u001a\u00060\u0013R\u00020\u0000H\u0002J\u0014\u00108\u001a\u00020\"2\n\u00107\u001a\u00060\u0013R\u00020\u0000H\u0002J\u0014\u00109\u001a\u00020\"2\n\u00107\u001a\u00060\u0013R\u00020\u0000H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u0012H\u0016J\b\u0010;\u001a\u00020\fH\u0016J\b\u0010<\u001a\u00020\fH\u0016J\b\u0010=\u001a\u00020\"H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\u0013R\u00020\u00000\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00060\u0016R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0017\u001a\f\u0012\b\u0012\u00060\u0013R\u00020\u00000\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer;", "Landroid/widget/RelativeLayout;", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer;", "Ltv/danmaku/biliplayerv2/panel/IVideoInsetChangedObserver;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPlayerContainer", "Ltv/danmaku/biliplayerv2/PlayerContainer;", "mRenderElementsByWidget", "Ljava/util/HashMap;", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$RenderElement;", "mLastIndexByFunctionType", "mUnmountElementRunnableForAnimate", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$UnmountElementRunnable;", "mPendingMountAnimationElements", "", "mMountAnimationRunnableScheduled", "", "mWindowIsVisibility", "mWidgetHideAnimationRunnable", "Ljava/lang/Runnable;", "mMountAnimationTimeoutRunnable", "mExecuteMountAnimationRunnable", "Landroid/os/MessageQueue$IdleHandler;", "bindPlayerContainer", "", "playerContainer", "executeMountAnimation", "showWidget", "widget", "params", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "onVideoInsetChanged", "inset", "Ltv/danmaku/biliplayerv2/panel/VideoInset;", "onWindowVisibilityChanged", "visibility", "onLayout", "changed", "l", "t", "r", "b", "hideWidgetInternal", "animEnable", "unmountRenderElement", "element", "mountRenderElement", "scheduleMountAnimationRunnable", "hideWidget", "getAvailableHeight", "getAvailableWidth", "release", "Companion", "RenderElement", "UnmountElementRunnable", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionContainer extends RelativeLayout implements IFunctionContainer, IVideoInsetChangedObserver {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FunctionContainer";
    private final MessageQueue.IdleHandler mExecuteMountAnimationRunnable;
    private HashMap<Integer, Integer> mLastIndexByFunctionType;
    private boolean mMountAnimationRunnableScheduled;
    private final Runnable mMountAnimationTimeoutRunnable;
    private final List<RenderElement> mPendingMountAnimationElements;
    private PlayerContainer mPlayerContainer;
    private HashMap<AbsFunctionWidget, RenderElement> mRenderElementsByWidget;
    private final UnmountElementRunnable mUnmountElementRunnableForAnimate;
    private Runnable mWidgetHideAnimationRunnable;
    private boolean mWindowIsVisibility;

    /* compiled from: FunctionContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$Companion;", "", "<init>", "()V", "TAG", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mExecuteMountAnimationRunnable$lambda$0(FunctionContainer this$0) {
        this$0.executeMountAnimation();
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionContainer(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRenderElementsByWidget = new HashMap<>(2);
        this.mLastIndexByFunctionType = new HashMap<>(4);
        this.mUnmountElementRunnableForAnimate = new UnmountElementRunnable();
        this.mPendingMountAnimationElements = new LinkedList();
        this.mWindowIsVisibility = true;
        this.mMountAnimationTimeoutRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FunctionContainer.this.executeMountAnimation();
            }
        };
        this.mExecuteMountAnimationRunnable = new MessageQueue.IdleHandler() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda1
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean mExecuteMountAnimationRunnable$lambda$0;
                mExecuteMountAnimationRunnable$lambda$0 = FunctionContainer.mExecuteMountAnimationRunnable$lambda$0(FunctionContainer.this);
                return mExecuteMountAnimationRunnable$lambda$0;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRenderElementsByWidget = new HashMap<>(2);
        this.mLastIndexByFunctionType = new HashMap<>(4);
        this.mUnmountElementRunnableForAnimate = new UnmountElementRunnable();
        this.mPendingMountAnimationElements = new LinkedList();
        this.mWindowIsVisibility = true;
        this.mMountAnimationTimeoutRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FunctionContainer.this.executeMountAnimation();
            }
        };
        this.mExecuteMountAnimationRunnable = new MessageQueue.IdleHandler() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda1
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean mExecuteMountAnimationRunnable$lambda$0;
                mExecuteMountAnimationRunnable$lambda$0 = FunctionContainer.mExecuteMountAnimationRunnable$lambda$0(FunctionContainer.this);
                return mExecuteMountAnimationRunnable$lambda$0;
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FunctionContainer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mRenderElementsByWidget = new HashMap<>(2);
        this.mLastIndexByFunctionType = new HashMap<>(4);
        this.mUnmountElementRunnableForAnimate = new UnmountElementRunnable();
        this.mPendingMountAnimationElements = new LinkedList();
        this.mWindowIsVisibility = true;
        this.mMountAnimationTimeoutRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FunctionContainer.this.executeMountAnimation();
            }
        };
        this.mExecuteMountAnimationRunnable = new MessageQueue.IdleHandler() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$$ExternalSyntheticLambda1
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean mExecuteMountAnimationRunnable$lambda$0;
                mExecuteMountAnimationRunnable$lambda$0 = FunctionContainer.mExecuteMountAnimationRunnable$lambda$0(FunctionContainer.this);
                return mExecuteMountAnimationRunnable$lambda$0;
            }
        };
    }

    @Override // tv.danmaku.biliplayerv2.widget.IWidget
    public void bindPlayerContainer(PlayerContainer playerContainer) {
        Intrinsics.checkNotNullParameter(playerContainer, "playerContainer");
        this.mPlayerContainer = playerContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void executeMountAnimation() {
        HandlerThreads.remove(0, this.mMountAnimationTimeoutRunnable);
        Looper.myQueue().removeIdleHandler(this.mExecuteMountAnimationRunnable);
        this.mMountAnimationRunnableScheduled = false;
        while (this.mPendingMountAnimationElements.size() > 0) {
            RenderElement element = this.mPendingMountAnimationElements.remove(0);
            if (element.isMounted() && !element.isUnmounting()) {
                element.getContent().setVisibility(0);
                Animation animation = AnimationUtils.loadAnimation(element.getContent().getContext(), element.getParams().getEnterAnim());
                if (animation != null) {
                    element.getContent().startAnimation(animation);
                }
            }
        }
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionContainer
    public void showWidget(AbsFunctionWidget widget, IFunctionContainer.LayoutParams params) {
        RenderElement element;
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.getFunctionType() != 0 && params.getFunctionType() != 1 && params.getFunctionType() != 2 && params.getFunctionType() != 3) {
            throw new IllegalArgumentException("functionType must one of: \n1、1\n2、2\n3、3\n4、0\n");
        }
        if (BuildConfig.DEBUG) {
            String tag = widget.getTag();
            String layoutTypeAlias = IFunctionContainer.LayoutParams.Companion.layoutTypeAlias(params.getLayoutType());
            int width = params.getWidth();
            PlayerLog.i(PlayerLogModule.Function, "show widget: {tag=" + tag + ",layoutType=" + layoutTypeAlias + ",width=" + width + ", height=" + params.getHeight() + "}");
        }
        RenderElement element2 = this.mRenderElementsByWidget.get(widget);
        if (element2 != null) {
            if (indexOfChild(element2.getContent()) >= 0) {
                PlayerLog.i(PlayerLogModule.Function, "widget(" + getTag() + "@" + widget + ") is already showing, hide it first");
                Animation animation = element2.getContent().getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                element2.getContent().clearAnimation();
                hideWidgetInternal(widget, false);
                this.mUnmountElementRunnableForAnimate.removeElement(element2);
            }
            element = new RenderElement(this, params, widget, element2.getContent(), false);
            this.mRenderElementsByWidget.put(widget, element);
        } else {
            boolean willBusy = widget.shouldRecreateView();
            element = new RenderElement(this, params, widget, widget.getView(), willBusy);
            this.mRenderElementsByWidget.put(widget, element);
        }
        int layoutType = params.getLayoutType();
        if (layoutType == 0) {
            layoutType = 16;
        }
        if (params.getWidth() == -1 && params.getWidth() == -1 && layoutType == 16) {
            layoutType = 32;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(params.getWidth(), params.getHeight());
        if ((layoutType & 32) != 0) {
            if (params.getExitAnim() == 0) {
                params.setExitAnim(-1);
            }
            if (params.getEnterAnim() == 0) {
                params.setEnterAnim(-1);
            }
        } else if (((layoutType & 1) != 0 && (layoutType & 2) != 0 && (layoutType & 4) != 0 && (layoutType & 8) != 0) || (layoutType & 16) != 0) {
            layoutParams.addRule(13);
            if (params.getEnterAnim() == 0) {
                params.setEnterAnim(R.anim.bplayer_function_widget_fade_in);
            }
            if (params.getExitAnim() == 0) {
                params.setExitAnim(R.anim.bplayer_function_widget_fade_out);
            }
        } else {
            if ((layoutType & 1) != 0 && (layoutType & 4) != 0) {
                layoutParams.addRule(14);
            } else if ((layoutType & 1) != 0 && (layoutType & 4) == 0) {
                layoutParams.addRule(9);
                if (params.getEnterAnim() == 0) {
                    params.setEnterAnim(R.anim.bplayer_function_widget_slide_in_from_left);
                }
                if (params.getExitAnim() == 0) {
                    params.setExitAnim(R.anim.bplayer_function_widget_slide_out_from_left);
                }
            } else if ((layoutType & 1) == 0 && (layoutType & 4) != 0) {
                layoutParams.addRule(11);
                if (params.getEnterAnim() == 0) {
                    params.setEnterAnim(R.anim.bplayer_function_widget_slide_in_from_right);
                }
                if (params.getExitAnim() == 0) {
                    params.setExitAnim(R.anim.bplayer_function_widget_slide_out_from_right);
                }
            }
            if ((layoutType & 8) != 0 && (layoutType & 2) != 0) {
                layoutParams.addRule(15);
            } else if ((layoutType & 8) != 0 && (layoutType & 2) == 0) {
                layoutParams.addRule(12);
                if (params.getEnterAnim() == 0) {
                    params.setEnterAnim(R.anim.bplayer_function_widget_slide_in_from_bottom);
                }
                if (params.getExitAnim() == 0) {
                    params.setExitAnim(R.anim.bplayer_function_widget_slide_out_from_bottom);
                }
            } else if ((layoutType & 8) == 0 && (layoutType & 2) != 0) {
                layoutParams.addRule(10);
                if (params.getEnterAnim() == 0) {
                    params.setEnterAnim(R.anim.bplayer_function_widget_slide_in_from_top);
                }
                if (params.getExitAnim() == 0) {
                    params.setExitAnim(R.anim.bplayer_function_widget_slide_out_from_top);
                }
            }
        }
        layoutParams.leftMargin = params.getLeftMargin();
        layoutParams.topMargin = params.getTopMargin();
        layoutParams.rightMargin = params.getRightMargin();
        layoutParams.bottomMargin = params.getBottomMargin();
        element.getContent().setLayoutParams(layoutParams);
        mountRenderElement(element);
    }

    @Override // tv.danmaku.biliplayerv2.panel.IVideoInsetChangedObserver
    public void onVideoInsetChanged(VideoInset inset) {
        int left;
        int top;
        int right;
        Intrinsics.checkNotNullParameter(inset, "inset");
        Rect containerInset = inset.getContainerInset();
        if (containerInset == null) {
            return;
        }
        if (containerInset.left > 0) {
            left = containerInset.left;
        } else {
            left = 0;
        }
        if (containerInset.top > 0) {
            top = containerInset.top;
        } else {
            top = 0;
        }
        if (containerInset.right > 0) {
            right = containerInset.right;
        } else {
            right = 0;
        }
        int bottom = containerInset.bottom > 0 ? containerInset.bottom : 0;
        setPadding(left, top, right, bottom);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        this.mWindowIsVisibility = visibility == 0;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            Map $this$forEach$iv = this.mRenderElementsByWidget;
            for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
                if (element$iv.getValue().isUnmounting()) {
                    this.mUnmountElementRunnableForAnimate.addElement(element$iv.getValue());
                }
            }
        }
    }

    private final void hideWidgetInternal(final AbsFunctionWidget widget, boolean animEnable) {
        final Animation animation;
        final RenderElement element = this.mRenderElementsByWidget.get(widget);
        if (element == null) {
            PlayerLog.i(PlayerLogModule.Function, "could not found a element to match widget(" + widget.getTag() + "@" + widget + ")");
            return;
        }
        if (this.mPendingMountAnimationElements.remove(element)) {
            element.getContent().setVisibility(0);
        }
        if (!animEnable || !this.mWindowIsVisibility || element.getContent().getVisibility() != 0) {
            unmountRenderElement(element);
            return;
        }
        if (element.getParams().getExitAnim() == -1) {
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(element.getContent().getContext(), element.getParams().getExitAnim());
        }
        if (animation == null) {
            unmountRenderElement(element);
        } else if (element.isUnmounting()) {
        } else {
            element.setUnmounting(true);
            animation.setAnimationListener(new Animation.AnimationListener() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$hideWidgetInternal$1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation p0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation p0) {
                    FunctionContainer.UnmountElementRunnable unmountElementRunnable;
                    unmountElementRunnable = FunctionContainer.this.mUnmountElementRunnableForAnimate;
                    unmountElementRunnable.addElement(element);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation p0) {
                }
            });
            this.mWidgetHideAnimationRunnable = new Runnable() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$hideWidgetInternal$2
                @Override // java.lang.Runnable
                public void run() {
                    AbsFunctionWidget.this.getView().startAnimation(animation);
                }
            };
            Runnable it = this.mWidgetHideAnimationRunnable;
            if (it != null) {
                HandlerThreads.remove(0, it);
                HandlerThreads.post(0, it);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unmountRenderElement(RenderElement element) {
        Integer num;
        if (BuildConfig.DEBUG) {
            num = 3;
            PlayerLog.d(PlayerLogModule.Function, "unmountElement start... lastIndex: {embeddedView = " + this.mLastIndexByFunctionType.get(0) + "normal = " + this.mLastIndexByFunctionType.get(1) + " popuwindow = " + this.mLastIndexByFunctionType.get(2) + " dialog = " + this.mLastIndexByFunctionType.get(3) + "}");
        } else {
            num = 3;
        }
        if (!element.isMounted()) {
            this.mRenderElementsByWidget.remove(element.getWidget());
            element.setUnmounting(false);
            PlayerLog.d(PlayerLogModule.Function, "has not attach to view");
            return;
        }
        removeView(element.getContent());
        removeView(element.getBackground());
        element.setUnmounting(false);
        element.setMounted(false);
        this.mPendingMountAnimationElements.remove(element);
        this.mRenderElementsByWidget.remove(element.getWidget());
        int ft = element.getParams().getFunctionType();
        Integer num2 = this.mLastIndexByFunctionType.get(Integer.valueOf(ft));
        int i = -1;
        int lastIndex = num2 != null ? num2.intValue() : -1;
        this.mLastIndexByFunctionType.put(Integer.valueOf(ft), Integer.valueOf(lastIndex - 2));
        int type = ft + 1;
        while (type <= 3) {
            Integer num3 = this.mLastIndexByFunctionType.get(Integer.valueOf(type));
            int index = num3 != null ? num3.intValue() : i;
            if (index != i) {
                this.mLastIndexByFunctionType.put(Integer.valueOf(type), Integer.valueOf(index - 2));
            }
            type++;
            i = -1;
        }
        if (BuildConfig.DEBUG) {
            PlayerLog.d(PlayerLogModule.Function, "unmountElement end... lastIndex: {embeddedView = " + this.mLastIndexByFunctionType.get(0) + "normal = " + this.mLastIndexByFunctionType.get(1) + " popuwindow = " + this.mLastIndexByFunctionType.get(2) + " dialog = " + this.mLastIndexByFunctionType.get(num) + "}");
        }
    }

    private final void mountRenderElement(final RenderElement element) {
        Integer num;
        int functionType;
        if (BuildConfig.DEBUG) {
            num = 3;
            PlayerLog.d(PlayerLogModule.Function, "mountElement start... lastIndex: {embeddedView = " + this.mLastIndexByFunctionType.get(0) + "normal = " + this.mLastIndexByFunctionType.get(1) + " popuwindow = " + this.mLastIndexByFunctionType.get(2) + " dialog = " + this.mLastIndexByFunctionType.get(3) + "}");
        } else {
            num = 3;
        }
        int functionType2 = element.getParams().getFunctionType();
        Integer num2 = this.mLastIndexByFunctionType.get(Integer.valueOf(functionType2));
        int i = -1;
        int lastIndex = num2 != null ? num2.intValue() : -1;
        try {
            addView(element.getBackground(), lastIndex + 1);
            addView(element.getContent(), lastIndex + 2);
            element.setMounted(true);
            this.mLastIndexByFunctionType.put(Integer.valueOf(functionType2), Integer.valueOf(lastIndex + 2));
            int type = functionType2 + 1;
            while (type <= 3) {
                Integer num3 = this.mLastIndexByFunctionType.get(Integer.valueOf(type));
                int t = num3 != null ? num3.intValue() : i;
                if (t == i) {
                    functionType = functionType2;
                    this.mLastIndexByFunctionType.put(Integer.valueOf(type), Integer.valueOf(lastIndex + 2));
                } else {
                    functionType = functionType2;
                    this.mLastIndexByFunctionType.put(Integer.valueOf(type), Integer.valueOf(t + 2));
                }
                type++;
                functionType2 = functionType;
                i = -1;
            }
            if (BuildConfig.DEBUG) {
                PlayerLog.d(PlayerLogModule.Function, "mountElement end... lastIndex: {embeddedView = " + this.mLastIndexByFunctionType.get(0) + "normal = " + this.mLastIndexByFunctionType.get(1) + " popuwindow = " + this.mLastIndexByFunctionType.get(2) + " dialog = " + this.mLastIndexByFunctionType.get(num) + "}");
            }
            if (element.getContent().getVisibility() == 0 && element.getParams().getEnterAnim() != 0 && element.getParams().getEnterAnim() != -1 && this.mWindowIsVisibility) {
                element.getContent().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$mountRenderElement$1
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        List list;
                        FunctionContainer.RenderElement.this.getContent().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (!FunctionContainer.RenderElement.this.isMounted() || FunctionContainer.RenderElement.this.isUnmounting()) {
                            return;
                        }
                        FunctionContainer.RenderElement.this.getContent().setVisibility(4);
                        list = this.mPendingMountAnimationElements;
                        list.add(FunctionContainer.RenderElement.this);
                        this.scheduleMountAnimationRunnable(FunctionContainer.RenderElement.this);
                    }
                });
            }
        } catch (Exception e) {
            BLog.e(TAG, "Add view failed!!", e);
            if (BuildConfig.DEBUG) {
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleMountAnimationRunnable(RenderElement element) {
        long delayMs;
        if (this.mMountAnimationRunnableScheduled) {
            return;
        }
        this.mMountAnimationRunnableScheduled = true;
        Looper.myQueue().addIdleHandler(this.mExecuteMountAnimationRunnable);
        if (element.getWillBusy()) {
            delayMs = 300;
        } else {
            delayMs = 100;
        }
        HandlerThreads.postDelayed(0, this.mMountAnimationTimeoutRunnable, delayMs);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionContainer
    public void hideWidget(AbsFunctionWidget widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        RenderElement element = this.mRenderElementsByWidget.get(widget);
        if (element == null || indexOfChild(element.getContent()) < 0) {
            PlayerLog.i(PlayerLogModule.Function, "widget(" + widget.getTag() + "@" + widget + ") do not mount this moment, do nothing");
            return;
        }
        hideWidgetInternal(widget, true);
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionContainer
    public int getAvailableHeight() {
        return (getHeight() - getPaddingBottom()) - getPaddingTop();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionContainer
    public int getAvailableWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    @Override // tv.danmaku.biliplayerv2.widget.IFunctionContainer
    public void release() {
        this.mUnmountElementRunnableForAnimate.release();
        Looper.myQueue().removeIdleHandler(this.mExecuteMountAnimationRunnable);
        HandlerThreads.remove(0, this.mMountAnimationTimeoutRunnable);
    }

    /* compiled from: FunctionContainer.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0018\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$RenderElement;", "", "p", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "w", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "v", "Landroid/view/View;", "b", "", "<init>", "(Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer;Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;Landroid/view/View;Z)V", "isMounted", "()Z", "setMounted", "(Z)V", "params", "getParams", "()Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "widget", "getWidget", "()Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "content", "getContent", "()Landroid/view/View;", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "getBackground", "setBackground", "(Landroid/view/View;)V", "isUnmounting", "setUnmounting", "willBusy", "getWillBusy", "setWillBusy", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class RenderElement {
        private View background;
        private final View content;
        private boolean isMounted;
        private boolean isUnmounting;
        private final IFunctionContainer.LayoutParams params;
        final /* synthetic */ FunctionContainer this$0;
        private final AbsFunctionWidget widget;
        private boolean willBusy;

        public RenderElement(FunctionContainer this$0, IFunctionContainer.LayoutParams p, AbsFunctionWidget w, View v, boolean b) {
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(w, "w");
            Intrinsics.checkNotNullParameter(v, "v");
            this.this$0 = this$0;
            this.params = p;
            this.widget = w;
            this.content = v;
            this.willBusy = b;
            if (this.params.getLayoutType() == 0) {
                this.params.setLayoutType(16);
            }
            this.background = new View(v.getContext());
            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(-1, -1);
            this.background.setLayoutParams(lp);
            if (this.params.getBackgroundDrawable() != null) {
                this.background.setBackground(this.params.getBackgroundDrawable());
            }
            if ((this.params.getFlag() & 2) != 0) {
                this.content.setClickable(true);
                if ((this.params.getFlag() & 1) == 0) {
                    return;
                }
                View view2 = this.background;
                final FunctionContainer functionContainer = this.this$0;
                view2.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.biliplayerimpl.functionwidget.FunctionContainer$RenderElement$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        FunctionContainer.RenderElement._init_$lambda$0(FunctionContainer.this, this, view3);
                    }
                });
                return;
            }
            this.content.setClickable(false);
            this.background.setClickable(false);
        }

        public final boolean isMounted() {
            return this.isMounted;
        }

        public final void setMounted(boolean z) {
            this.isMounted = z;
        }

        public final IFunctionContainer.LayoutParams getParams() {
            return this.params;
        }

        public final AbsFunctionWidget getWidget() {
            return this.widget;
        }

        public final View getContent() {
            return this.content;
        }

        public final View getBackground() {
            return this.background;
        }

        public final void setBackground(View view2) {
            Intrinsics.checkNotNullParameter(view2, "<set-?>");
            this.background = view2;
        }

        public final boolean isUnmounting() {
            return this.isUnmounting;
        }

        public final void setUnmounting(boolean z) {
            this.isUnmounting = z;
        }

        public final boolean getWillBusy() {
            return this.willBusy;
        }

        public final void setWillBusy(boolean z) {
            this.willBusy = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(FunctionContainer this$0, RenderElement this$1, View it) {
            AbsFunctionWidgetService functionWidgetService;
            PlayerContainer playerContainer = this$0.mPlayerContainer;
            if (playerContainer == null || (functionWidgetService = playerContainer.getFunctionWidgetService()) == null) {
                return;
            }
            functionWidgetService.hideWidget(this$1.widget.getToken());
        }
    }

    /* compiled from: FunctionContainer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u0006R\u00020\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\n\u0010\r\u001a\u00060\u0006R\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u000bR\u0018\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006R\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$UnmountElementRunnable;", "Ljava/lang/Runnable;", "<init>", "(Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer;)V", "elements", "", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer$RenderElement;", "Ltv/danmaku/biliplayerimpl/functionwidget/FunctionContainer;", "waitRunning", "", "run", "", "addElement", "element", "removeElement", "release", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final class UnmountElementRunnable implements Runnable {
        private final List<RenderElement> elements = new LinkedList();
        private boolean waitRunning;

        public UnmountElementRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterable $this$forEach$iv = this.elements;
            FunctionContainer functionContainer = FunctionContainer.this;
            for (Object element$iv : $this$forEach$iv) {
                RenderElement it = (RenderElement) element$iv;
                functionContainer.unmountRenderElement(it);
            }
            this.elements.clear();
            this.waitRunning = false;
        }

        public final void addElement(RenderElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            this.elements.add(element);
            if (this.waitRunning) {
                return;
            }
            FunctionContainer.this.post(this);
            this.waitRunning = true;
        }

        public final void removeElement(RenderElement element) {
            Intrinsics.checkNotNullParameter(element, "element");
            this.elements.remove(element);
            if (this.elements.isEmpty()) {
                FunctionContainer.this.removeCallbacks(this);
                this.waitRunning = false;
            }
        }

        public final void release() {
            FunctionContainer.this.removeCallbacks(this);
        }
    }
}