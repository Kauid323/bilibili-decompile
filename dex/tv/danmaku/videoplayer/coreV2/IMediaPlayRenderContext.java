package tv.danmaku.videoplayer.coreV2;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.Surface;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.render.output.IJKEXTRendererInterface;
import tv.danmaku.videoplayer.coreV2.adapter.IMediaPlayAdapter;

/* compiled from: IMediaPlayRenderContext.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001PJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\fH&J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u0011H&J\b\u0010\u001b\u001a\u00020\u0011H&J\b\u0010\u001c\u001a\u00020\u0011H&J\b\u0010\u001d\u001a\u00020\u0011H&J(\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\fH&J$\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H&J.\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00112\b\b\u0002\u0010.\u001a\u00020\u00112\b\b\u0002\u0010/\u001a\u00020'H&J\u0010\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020)H&J\n\u00102\u001a\u0004\u0018\u00010)H&J\u0010\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0011H&J\u0010\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020'H&J\u0012\u00107\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u000108H&J'\u00109\u001a\u0004\u0018\u0001H:\"\u0004\b\u0000\u0010:2\u0006\u0010;\u001a\u00020<2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020'2\u0006\u0010@\u001a\u00020AH&J\u0016\u0010B\u001a\u00020\u00032\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0DH&J\b\u0010F\u001a\u00020\u0003H&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020'H&J\u0010\u0010I\u001a\u00020\u00032\u0006\u0010(\u001a\u00020EH&J\u0012\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LH&J\u0010\u0010M\u001a\u00020\u00032\u0006\u0010(\u001a\u00020EH&J\u0012\u0010N\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010OH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006QÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext;", "", "init", "", "params", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayParams;", "release", "setVideoDisPlay", "display", "Ltv/danmaku/videoplayer/coreV2/VideoDisplay;", "getVideoDisplay", "scale", "", "scaleX", "scaleY", "translate", "tX", "", "tY", "rotate", "degree", "transform", "notifyRefreshFrame", "setOnVideoSizeChangedListener", "listener", "Ltv/danmaku/ijk/media/player/IMediaPlayer$OnVideoSizeChangedListener;", "getVideoWidth", "getVideoHeight", "getVideoSarDen", "getVideoSarNum", "setBackgroundColor", "red", "green", "blue", "alpha", "setBackgroundImage", "bitmap", "Landroid/graphics/Bitmap;", "recycle", "", "rect", "Landroid/graphics/Rect;", "takeVideoCapture", "callback", "Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "width", "height", "ignoreModelChange", "setDisplayViewPort", "viewPort", "getDisplayViewPort", "setVerticesModel", "mode", "flipVideo", "flip", "setFirstFrameListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFirstFrameListener;", "invokeOp", "T", "op", "Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;", "(Ltv/danmaku/videoplayer/coreV2/adapter/IMediaPlayAdapter$Ops;Ljava/lang/Object;)Ljava/lang/Object;", "setEnhance", "enable", "type", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$IjkEnhanceType;", "setBlurRectList", "rectList", "", "Landroid/graphics/RectF;", "clearBlurRect", "setEnableMultiRender", "isEnable", "setMultiMainCaptureRect", "setMultiSubWindowSurface", "surface", "Landroid/view/Surface;", "setMultiSubWindowCaptureRect", "setOnFrameRendererListener", "Ltv/danmaku/ijk/media/player/render/output/IJKEXTRendererInterface$OnFrameRenderedListener;", "OnTakeVideoCapture", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaPlayRenderContext {

    /* compiled from: IMediaPlayRenderContext.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/IMediaPlayRenderContext$OnTakeVideoCapture;", "", "onResult", "", "capture", "Landroid/graphics/Bitmap;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnTakeVideoCapture {
        void onResult(Bitmap bitmap);
    }

    void clearBlurRect();

    void flipVideo(boolean z);

    Rect getDisplayViewPort();

    VideoDisplay getVideoDisplay();

    int getVideoHeight();

    int getVideoSarDen();

    int getVideoSarNum();

    int getVideoWidth();

    void init(IMediaPlayParams iMediaPlayParams);

    <T> T invokeOp(IMediaPlayAdapter.Ops ops, Object obj);

    void notifyRefreshFrame();

    void release();

    void rotate(float f);

    void scale(float f);

    void scale(float f, float f2);

    void setBackgroundColor(float f, float f2, float f3, float f4);

    void setBackgroundImage(Bitmap bitmap, boolean z, Rect rect);

    void setBlurRectList(List<? extends RectF> list);

    void setDisplayViewPort(Rect rect);

    void setEnableMultiRender(boolean z);

    void setEnhance(boolean z, IJKEXTRendererInterface.IjkEnhanceType ijkEnhanceType);

    void setFirstFrameListener(IJKEXTRendererInterface.OnFirstFrameListener onFirstFrameListener);

    void setMultiMainCaptureRect(RectF rectF);

    void setMultiSubWindowCaptureRect(RectF rectF);

    void setMultiSubWindowSurface(Surface surface);

    void setOnFrameRendererListener(IJKEXTRendererInterface.OnFrameRenderedListener onFrameRenderedListener);

    void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setVerticesModel(int i);

    void setVideoDisPlay(VideoDisplay videoDisplay);

    void takeVideoCapture(OnTakeVideoCapture onTakeVideoCapture, int i, int i2, boolean z);

    void transform(float f, int i, int i2, float f2);

    void translate(int i, int i2);

    /* compiled from: IMediaPlayRenderContext.kt */
    /* renamed from: tv.danmaku.videoplayer.coreV2.IMediaPlayRenderContext$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static VideoDisplay $default$getVideoDisplay(IMediaPlayRenderContext _this) {
            return null;
        }

        public static /* synthetic */ void takeVideoCapture$default(IMediaPlayRenderContext iMediaPlayRenderContext, OnTakeVideoCapture onTakeVideoCapture, int i, int i2, boolean z, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeVideoCapture");
            }
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = -1;
            }
            if ((i3 & 8) != 0) {
                z = false;
            }
            iMediaPlayRenderContext.takeVideoCapture(onTakeVideoCapture, i, i2, z);
        }
    }
}