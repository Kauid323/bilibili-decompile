package tv.danmaku.render.core;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bilibili.base.util.ContextUtilKt;
import com.bilibili.droid.RomUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;
import tv.danmaku.videoplayer.core.videoview.AspectRatio;

/* compiled from: ExternalRenderHelper.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0012J\u0006\u0010 \u001a\u00020\u0012J\b\u0010!\u001a\u00020\u0017H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020$H\u0002J\u0006\u0010(\u001a\u00020\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/render/core/ExternalRenderHelper;", "", "mRenderLayer", "Ltv/danmaku/render/core/IVideoRenderLayer;", "<init>", "(Ltv/danmaku/render/core/IVideoRenderLayer;)V", "mVideoWidth", "", "mVideoHeight", "mVideoSarDen", "mVideoSarNum", "mAspectRatio", "Ltv/danmaku/videoplayer/core/videoview/AspectRatio;", "mShouldRelayout", "", "mDisplayWidth", "mDisplayHeight", "mViewPort", "Landroid/graphics/Rect;", "mLayoutFrame", "mLayerAncestor", "Landroid/view/View;", "setVideoSize", "", "width", "height", "sarNum", "sarDen", "setAspectRatio", "aspectRatio", "updateViewPort", "viewPort", "getLayoutFrame", "ensureRenderLayerAncestor", "relayoutIfNeed", "dp2px", "", "context", "Landroid/content/Context;", "dp", "onRenderDetachedFromWindow", "Companion", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ExternalRenderHelper {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ExternalRenderHelper";
    private AspectRatio mAspectRatio;
    private int mDisplayHeight;
    private int mDisplayWidth;
    private View mLayerAncestor;
    private final Rect mLayoutFrame;
    private final IVideoRenderLayer mRenderLayer;
    private boolean mShouldRelayout;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private final Rect mViewPort;

    /* compiled from: ExternalRenderHelper.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/render/core/ExternalRenderHelper$Companion;", "", "<init>", "()V", "TAG", "", "rendercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ExternalRenderHelper(IVideoRenderLayer mRenderLayer) {
        Intrinsics.checkNotNullParameter(mRenderLayer, "mRenderLayer");
        this.mRenderLayer = mRenderLayer;
        this.mAspectRatio = AspectRatio.RATIO_ADJUST_CONTENT;
        this.mViewPort = new Rect();
        this.mLayoutFrame = new Rect();
    }

    public final void setVideoSize(int width, int height, int sarNum, int sarDen) {
        if (this.mVideoWidth == width && this.mVideoHeight == height && this.mVideoSarNum == sarNum && this.mVideoSarDen == sarDen) {
            return;
        }
        this.mVideoWidth = width;
        this.mVideoHeight = height;
        this.mVideoSarNum = sarNum;
        this.mVideoSarDen = sarDen;
        this.mShouldRelayout = true;
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

    public final void updateViewPort(Rect viewPort) {
        Intrinsics.checkNotNullParameter(viewPort, "viewPort");
        if (Intrinsics.areEqual(this.mViewPort, viewPort)) {
            return;
        }
        this.mViewPort.set(viewPort);
        this.mShouldRelayout = true;
        relayoutIfNeed();
    }

    public final Rect getLayoutFrame() {
        return this.mLayoutFrame;
    }

    private final void ensureRenderLayerAncestor() {
        ViewParent p;
        if (this.mLayerAncestor != null || (p = this.mRenderLayer.getView().getParent()) == null) {
            return;
        }
        while (p.getParent() != null) {
            if (p instanceof View) {
                this.mLayerAncestor = (View) p;
                return;
            }
            ViewParent parent = p.getParent();
            Intrinsics.checkNotNullExpressionValue(parent, "getParent(...)");
            p = parent;
        }
    }

    private final void relayoutIfNeed() {
        Context context;
        if (!this.mShouldRelayout) {
            return;
        }
        ensureRenderLayerAncestor();
        View layerAncestor = this.mLayerAncestor;
        if (layerAncestor == null) {
            return;
        }
        int displayWidth = layerAncestor.getWidth();
        int displayHeight = layerAncestor.getHeight();
        try {
            if (RomUtils.isHuaweiRom()) {
                ViewParent view2 = this.mRenderLayer.getView().getParent();
                if (view2 instanceof View) {
                    context = ((View) view2).getContext();
                } else {
                    context = null;
                }
                Activity activity = ContextUtilKt.findActivityOrNull(context);
                if (activity != null && Build.VERSION.SDK_INT >= 24 && activity.isInMultiWindowMode() && (displayHeight = displayHeight - ((int) dp2px(context, 80.0f))) < this.mViewPort.height()) {
                    displayHeight = this.mViewPort.height();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mRenderLayer.getView().getWidth() == 0 || this.mRenderLayer.getView().getHeight() == 0 || displayWidth != this.mDisplayWidth || displayHeight != this.mDisplayHeight) {
            this.mDisplayHeight = displayHeight;
            this.mDisplayWidth = displayWidth;
            ViewGroup.LayoutParams layoutParams = this.mRenderLayer.getView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(0, 0);
                this.mRenderLayer.getView().setLayoutParams(layoutParams);
            }
            layoutParams.width = this.mDisplayWidth;
            layoutParams.height = this.mDisplayHeight;
            int measureSpecWidth = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
            int measureSpecHeight = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            this.mRenderLayer.getView().measure(measureSpecWidth, measureSpecHeight);
            this.mRenderLayer.getView().layout(0, 0, this.mRenderLayer.getView().getMeasuredWidth(), this.mRenderLayer.getView().getMeasuredHeight());
        }
        if (this.mViewPort.isEmpty()) {
            PlayerLog.i(TAG, "viewport is empty: " + this.mViewPort);
            return;
        }
        Point point = new Point();
        VideoRenderLayoutHelper.Companion.calculateVideoDisplaySize(point, this.mAspectRatio, this.mViewPort, this.mVideoWidth, this.mVideoHeight, this.mVideoSarNum, this.mVideoSarDen);
        int viewPortLeftInCanvas = this.mViewPort.left;
        int viewPortTopInCanvas = this.mViewPort.top;
        int leftInViewPort = (this.mViewPort.width() - point.x) / 2;
        int topInViewPort = (this.mViewPort.height() - point.y) / 2;
        this.mLayoutFrame.left = viewPortLeftInCanvas + leftInViewPort;
        this.mLayoutFrame.top = viewPortTopInCanvas + topInViewPort;
        this.mLayoutFrame.right = this.mLayoutFrame.left + point.x;
        this.mLayoutFrame.bottom = this.mLayoutFrame.top + point.y;
        View view3 = this.mRenderLayer.getView();
        int left = view3.getLeft();
        int top = view3.getTop();
        int right = view3.getRight();
        PlayerLog.i(TAG, "canvas: left=" + left + ", top=" + top + ",right=" + right + ",bottom=" + view3.getBottom() + "; layout frame: " + this.mLayoutFrame);
    }

    private final float dp2px(Context context, float dp) {
        if (context == null) {
            return dp;
        }
        Resources resources = context.getResources();
        if (resources == null) {
            return dp;
        }
        float density = resources.getDisplayMetrics().density;
        return dp * density;
    }

    public final void onRenderDetachedFromWindow() {
        this.mLayerAncestor = null;
    }
}