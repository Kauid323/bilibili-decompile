package tv.danmaku.render.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: VideoRenderLayoutHelper.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0007J&\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\tJ\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u0007J\b\u0010+\u001a\u00020\u001eH\u0002J\u000e\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\u0018J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020\u0010J\u0016\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Ltv/danmaku/render/core/VideoRenderLayoutHelper;", "", "mVideoView", "Ltv/danmaku/render/core/IVideoRenderLayer;", "<init>", "(Ltv/danmaku/render/core/IVideoRenderLayer;)V", "mViewPort", "Landroid/graphics/Rect;", "mVideoWidth", "", "mVideoHeight", "mVideoSarNum", "mVideoSarDen", "mAspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "mShouldRelayout", "", "mAlignViews", "Ljava/util/LinkedList;", "Landroid/view/View;", "mWindowDisplayWidth", "mWindowDisplayHeight", "mLayoutFrame", "mBasicScaleX", "", "mBasicScaleY", "mBasicTranslateX", "mBasicTranslateY", "mIsFlip", "addAlignView", "", "view", "removeAlignView", "updateViewPort", "viewPort", "updateVideoSize", "width", "height", "sarNum", "sarDen", "setAspectRatio", "aspectRatio", "getVideoViewBounds", "relayoutIfNeed", "userScale", "scale", "flip", "userTranslate", "tX", "tY", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoRenderLayoutHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Render::VideoRenderLayoutHelper";
    private final LinkedList<View> mAlignViews;
    private AspectRatio mAspectRatio;
    private float mBasicScaleX;
    private float mBasicScaleY;
    private float mBasicTranslateX;
    private float mBasicTranslateY;
    private boolean mIsFlip;
    private Rect mLayoutFrame;
    private boolean mShouldRelayout;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private final IVideoRenderLayer mVideoView;
    private int mVideoWidth;
    private Rect mViewPort;
    private int mWindowDisplayHeight;
    private int mWindowDisplayWidth;

    /* compiled from: VideoRenderLayoutHelper.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\rJ>\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/render/core/VideoRenderLayoutHelper$Companion;", "", "<init>", "()V", "TAG", "", "getVideoDisplayRatio", "", "aspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "viewPort", "Landroid/graphics/Rect;", "videoWidth", "", "videoHeight", "videoSarNum", "videoSarDen", "calculateVideoDisplaySize", "", "point", "Landroid/graphics/Point;", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {

        /* compiled from: VideoRenderLayoutHelper.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AspectRatio.values().length];
                try {
                    iArr[AspectRatio.RATIO_CENTER_CROP.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[AspectRatio.RATIO_ADJUST_CONTENT.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[AspectRatio.RATIO_16_9_INSIDE.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[AspectRatio.RATIO_4_3_INSIDE.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[AspectRatio.RATIO_ADJUST_SCREEN.ordinal()] = 5;
                } catch (NoSuchFieldError e5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ float getVideoDisplayRatio$default(Companion companion, AspectRatio aspectRatio, Rect rect, int i, int i2, int i3, int i4, int i5, Object obj) {
            int i6;
            int i7;
            if ((i5 & 16) == 0) {
                i6 = i3;
            } else {
                i6 = 1;
            }
            if ((i5 & 32) == 0) {
                i7 = i4;
            } else {
                i7 = 1;
            }
            return companion.getVideoDisplayRatio(aspectRatio, rect, i, i2, i6, i7);
        }

        public final float getVideoDisplayRatio(AspectRatio aspectRatio, Rect viewPort, int videoWidth, int videoHeight, int videoSarNum, int videoSarDen) {
            float videoRatio;
            Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
            Intrinsics.checkNotNullParameter(viewPort, "viewPort");
            float viewPortRatio = viewPort.width() / viewPort.height();
            switch (WhenMappings.$EnumSwitchMapping$0[aspectRatio.ordinal()]) {
                case 1:
                case 2:
                    if (videoWidth == 0 || videoHeight == 0) {
                        PlayerLog.i(VideoRenderLayoutHelper.TAG, "video size is empty use view ratio");
                        return viewPortRatio;
                    }
                    videoRatio = videoWidth / videoHeight;
                    if (videoSarNum >= 1 && videoSarDen >= 1) {
                        videoRatio = (videoSarNum * videoRatio) / videoSarDen;
                        break;
                    }
                    break;
                case 3:
                    videoRatio = 1.7777778f;
                    break;
                case 4:
                    videoRatio = 1.3333334f;
                    break;
                case 5:
                default:
                    videoRatio = viewPortRatio;
                    break;
            }
            float displayRatio = videoRatio;
            return displayRatio;
        }

        public final void calculateVideoDisplaySize(Point point, AspectRatio aspectRatio, Rect viewPort, int videoWidth, int videoHeight, int videoSarNum, int videoSarDen) {
            int width;
            int height;
            Intrinsics.checkNotNullParameter(point, "point");
            Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
            Intrinsics.checkNotNullParameter(viewPort, "viewPort");
            float displayRatio = getVideoDisplayRatio(aspectRatio, viewPort, videoWidth, videoHeight, videoSarNum, videoSarDen);
            int viewPortWidth = viewPort.width();
            int viewPortHeight = viewPort.height();
            float viewPortRatio = viewPortWidth / viewPortHeight;
            if (aspectRatio != AspectRatio.RATIO_CENTER_CROP) {
                width = viewPortRatio <= displayRatio ? viewPortWidth : (int) ((viewPortHeight * displayRatio) + 0.5d);
                height = viewPortRatio > displayRatio ? viewPortHeight : (int) ((viewPortWidth / displayRatio) + 0.5d);
            } else {
                width = viewPortRatio > displayRatio ? viewPortWidth : (int) ((viewPortHeight * displayRatio) + 0.5d);
                height = viewPortRatio <= displayRatio ? viewPortHeight : (int) ((viewPortWidth / displayRatio) + 0.5d);
            }
            point.set(width, height);
        }
    }

    public VideoRenderLayoutHelper(IVideoRenderLayer mVideoView) {
        Intrinsics.checkNotNullParameter(mVideoView, "mVideoView");
        this.mVideoView = mVideoView;
        this.mViewPort = new Rect();
        this.mAspectRatio = AspectRatio.RATIO_ADJUST_CONTENT;
        this.mAlignViews = new LinkedList<>();
        this.mLayoutFrame = new Rect();
        this.mBasicScaleX = 1.0f;
        this.mBasicScaleY = 1.0f;
    }

    public final void addAlignView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.mAlignViews.add(view2);
        this.mShouldRelayout = true;
        relayoutIfNeed();
    }

    public final void removeAlignView(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.mAlignViews.remove(view2);
        this.mShouldRelayout = true;
        relayoutIfNeed();
    }

    public final void updateViewPort(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        if (Intrinsics.areEqual(viewPort, this.mViewPort)) {
            return;
        }
        this.mViewPort.set(viewPort);
        this.mShouldRelayout = this.mViewPort.width() > 0 && this.mViewPort.height() > 0;
        relayoutIfNeed();
    }

    public final void updateVideoSize(int width, int height, int sarNum, int sarDen) {
        if (this.mVideoWidth == width && this.mVideoHeight == height) {
            return;
        }
        this.mVideoWidth = width;
        this.mVideoHeight = height;
        this.mVideoSarNum = sarNum;
        this.mVideoSarDen = sarDen;
        this.mShouldRelayout = this.mVideoHeight > 0 && this.mVideoWidth > 0;
        relayoutIfNeed();
    }

    public final void setAspectRatio(AspectRatio aspectRatio) {
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        if (aspectRatio == this.mAspectRatio) {
            return;
        }
        this.mAspectRatio = aspectRatio;
        this.mShouldRelayout = true;
        relayoutIfNeed();
    }

    public final Rect getVideoViewBounds() {
        Rect rect = new Rect();
        rect.set(this.mLayoutFrame);
        return rect;
    }

    private final void relayoutIfNeed() {
        if (this.mShouldRelayout) {
            this.mShouldRelayout = false;
            ViewParent parent = this.mVideoView.getView().getParent();
            if (!(parent instanceof View)) {
                return;
            }
            int windowWidth = ((View) parent).getWidth();
            int windowHeight = ((View) parent).getHeight();
            if (windowWidth != 0 && windowHeight != 0) {
                if (this.mVideoView.getView().getWidth() == 0 || this.mVideoView.getView().getHeight() == 0 || windowHeight != this.mWindowDisplayHeight || windowWidth != this.mWindowDisplayWidth) {
                    this.mWindowDisplayWidth = windowWidth;
                    this.mWindowDisplayHeight = windowHeight;
                    ViewGroup.LayoutParams layoutParams = this.mVideoView.getView().getLayoutParams();
                    if (layoutParams == null) {
                        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(this.mWindowDisplayWidth, this.mWindowDisplayHeight);
                        this.mVideoView.getView().setLayoutParams(layoutParams2);
                    }
                    int measureSpecWidth = View.MeasureSpec.makeMeasureSpec(this.mWindowDisplayWidth, 1073741824);
                    int measureSpecHeight = View.MeasureSpec.makeMeasureSpec(this.mWindowDisplayHeight, 1073741824);
                    this.mVideoView.getView().measure(measureSpecWidth, measureSpecHeight);
                    this.mVideoView.getView().layout(0, 0, this.mVideoView.getView().getMeasuredWidth(), this.mVideoView.getView().getMeasuredHeight());
                }
                Point point = new Point();
                Companion.calculateVideoDisplaySize(point, this.mAspectRatio, this.mViewPort, this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
                PlayerLog.i(TAG, "window display size: {width: " + this.mVideoView.getView().getWidth() + ", height: " + this.mVideoView.getView().getHeight() + "}; video view port size: {width:" + point.x + ", height: " + point.y + "}");
                float scaleX = point.x / this.mWindowDisplayWidth;
                float scaleY = point.y / this.mWindowDisplayHeight;
                int viewPortTopInCanvas = this.mViewPort.top;
                int viewPortLeftInCanvas = this.mViewPort.left;
                int displayTopInViewPort = (this.mViewPort.height() - point.y) / 2;
                int displayLeftIntViewPort = (this.mViewPort.width() - point.x) / 2;
                this.mLayoutFrame.left = displayLeftIntViewPort + viewPortLeftInCanvas;
                this.mLayoutFrame.top = displayTopInViewPort + viewPortTopInCanvas;
                this.mLayoutFrame.right = this.mLayoutFrame.left + point.x;
                this.mLayoutFrame.bottom = this.mLayoutFrame.top + point.y;
                PlayerLog.i(TAG, "layout frame: " + this.mLayoutFrame);
                this.mVideoView.getView().setPivotX(this.mLayoutFrame.left + (this.mLayoutFrame.width() / 2.0f));
                this.mVideoView.getView().setPivotY(this.mLayoutFrame.top + (this.mLayoutFrame.height() / 2.0f));
                this.mBasicScaleX = scaleX;
                this.mBasicScaleY = scaleY;
                float f = 1;
                this.mBasicTranslateX = ((-this.mVideoView.getView().getPivotX()) * (f - this.mBasicScaleX)) + this.mLayoutFrame.left;
                this.mBasicTranslateY = ((-this.mVideoView.getView().getPivotY()) * (f - this.mBasicScaleY)) + this.mLayoutFrame.top;
                Pair userTranslate = this.mVideoView.currentTranslate();
                this.mVideoView.getView().setTranslationX(this.mBasicTranslateX + ((Number) userTranslate.getFirst()).floatValue());
                this.mVideoView.getView().setTranslationY(this.mBasicTranslateY + ((Number) userTranslate.getSecond()).floatValue());
                if (this.mIsFlip) {
                    this.mVideoView.getView().setScaleX((-this.mBasicScaleX) * this.mVideoView.currentScale());
                } else {
                    this.mVideoView.getView().setScaleX(this.mBasicScaleX * this.mVideoView.currentScale());
                }
                this.mVideoView.getView().setScaleY(this.mBasicScaleY * this.mVideoView.currentScale());
                int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutFrame.width(), 1073741824);
                int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.mLayoutFrame.height(), 1073741824);
                Iterable $this$forEach$iv = this.mAlignViews;
                for (Object element$iv : $this$forEach$iv) {
                    Point point2 = point;
                    View it = (View) element$iv;
                    it.measure(widthMeasureSpec, heightMeasureSpec);
                    it.layout(this.mLayoutFrame.left, this.mLayoutFrame.top, this.mLayoutFrame.right, this.mLayoutFrame.height());
                    point = point2;
                    parent = parent;
                    windowWidth = windowWidth;
                    windowHeight = windowHeight;
                    scaleX = scaleX;
                }
            }
        }
    }

    public final void userScale(float scale) {
        if (this.mIsFlip) {
            this.mVideoView.getView().setScaleX((-this.mBasicScaleX) * scale);
        } else {
            this.mVideoView.getView().setScaleX(this.mBasicScaleX * scale);
        }
        this.mVideoView.getView().setScaleY(this.mBasicScaleY * scale);
    }

    public final void flip(boolean flip) {
        this.mIsFlip = flip;
        if (flip) {
            this.mVideoView.getView().setScaleX(Math.abs(this.mVideoView.getView().getScaleX()) * (-1));
        } else {
            this.mVideoView.getView().setScaleX(Math.abs(this.mVideoView.getView().getScaleX()));
        }
    }

    public final void userTranslate(int tX, int tY) {
        this.mVideoView.getView().setTranslationX(tX + this.mBasicTranslateX);
        this.mVideoView.getView().setTranslationY(tY + this.mBasicTranslateY);
    }
}