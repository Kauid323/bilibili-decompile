package tv.danmaku.gifplayer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.base.util.ContextUtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.gifplayer.GifVideoView;

/* compiled from: PlayerImageView.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0002?@B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010'\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0007J\b\u0010(\u001a\u00020\u001fH\u0007J\u0010\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&H\u0007J\u0010\u0010,\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0013J\u0010\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0013J\u000e\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u0011J\u0010\u00101\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u0013J\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u000bJ\b\u00104\u001a\u00020\u001fH\u0014J\b\u00105\u001a\u00020\u001fH\u0014J\b\u00106\u001a\u00020\u001fH\u0007J\u0006\u00107\u001a\u00020\u001fJ\u0006\u00108\u001a\u00020\u001fJ\u0006\u00109\u001a\u00020\u000bJ\b\u0010:\u001a\u00020\u001fH\u0016J\b\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u0011H\u0016J\b\u0010>\u001a\u00020\u001fH\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Ltv/danmaku/gifplayer/PlayerImageView;", "Landroid/widget/FrameLayout;", "Ltv/danmaku/gifplayer/GifVideoView$Listener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mResources", "Ltv/danmaku/gifplayer/Resources;", "mFillType", "mAttachedWindow", "", "mPlaceHolderDrawable", "Landroid/graphics/drawable/Drawable;", "mErrorDrawable", "mProgressDrawable", "mImageView", "Landroid/widget/ImageView;", "mGifVideoView", "Ltv/danmaku/gifplayer/GifVideoView;", "mProgressView", "mState", "mOnPlayListener", "Ltv/danmaku/gifplayer/PlayerImageView$OnPlayListener;", "setResources", "", "resources", "setNetResourcesOnly", "url", "", "setFileResourcesOnly", "file", "Ljava/io/File;", "setNetResources", "resetNetResources", "setOnPlayListener", "listener", "setFileResources", "setPlaceHodler", "drawable", "setErrorDrawable", "setPlayLoopMode", "loop", "setLoadingDrawable", "setFillType", "type", "onAttachedToWindow", "onDetachedFromWindow", "startPlay", "stopPlay", "stopPlayAndRelease", "getState", "onFirstRender", "onError", "onStop", "byOther", "onComplete", "Companion", "OnPlayListener", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerImageView extends FrameLayout implements GifVideoView.Listener {
    public static final Companion Companion = new Companion(null);
    public static final int FILL_TYPE_ADJUST_CONTENT = 2;
    public static final int FILL_TYPE_CENTER_CROP = 3;
    public static final int FILL_TYPE_FIX_XY = 1;
    public static final int STATE_ERROR = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_LOADING = 2;
    public static final int STATE_PLAYING = 3;
    private boolean mAttachedWindow;
    private Drawable mErrorDrawable;
    private int mFillType;
    private GifVideoView mGifVideoView;
    private ImageView mImageView;
    private OnPlayListener mOnPlayListener;
    private Drawable mPlaceHolderDrawable;
    private Drawable mProgressDrawable;
    private ImageView mProgressView;
    private Resources mResources;
    private int mState;

    /* compiled from: PlayerImageView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/gifplayer/PlayerImageView$Companion;", "", "<init>", "()V", "FILL_TYPE_FIX_XY", "", "FILL_TYPE_ADJUST_CONTENT", "FILL_TYPE_CENTER_CROP", "STATE_IDLE", "STATE_LOADING", "STATE_PLAYING", "STATE_ERROR", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerImageView(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PlayerImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayerImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mFillType = 2;
        boolean z = true;
        this.mState = 1;
        FragmentActivity activity = ContextUtilKt.findFragmentActivityOrNull(context);
        if (activity == null) {
            throw new IllegalStateException("context must is FragmentActivity");
        }
        this.mGifVideoView = GifVideoView.Companion.with(activity);
        this.mImageView = new ImageView(context);
        FrameLayout.LayoutParams ivParams = new FrameLayout.LayoutParams(-1, -1);
        this.mImageView.setLayoutParams(ivParams);
        addView(this.mImageView);
        this.mProgressView = new ImageView(context);
        FrameLayout.LayoutParams pgParams = new FrameLayout.LayoutParams(-2, -2);
        pgParams.gravity = 17;
        this.mProgressView.setLayoutParams(pgParams);
        addView(this.mProgressView);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.PlayerImageView);
            Intrinsics.checkNotNullExpressionValue(a, "obtainStyledAttributes(...)");
            Drawable placeHolder = a.getDrawable(R.styleable.PlayerImageView_placeHolder);
            setPlaceHodler(placeHolder);
            Drawable errorDrawable = a.getDrawable(R.styleable.PlayerImageView_errorDrawable);
            setErrorDrawable(errorDrawable);
            Drawable loadingDrawable = a.getDrawable(R.styleable.PlayerImageView_loadingDrawable);
            setLoadingDrawable(loadingDrawable);
            int fillType = a.getInt(R.styleable.PlayerImageView_fillType, 2);
            setFillType(fillType);
            String playUrl = a.getString(R.styleable.PlayerImageView_playUrl);
            String str = playUrl;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (!z) {
                int type = a.getInt(R.styleable.PlayerImageView_urlType, 2);
                setResources(new StringResources(playUrl, type));
            }
            a.recycle();
        }
    }

    public final void setResources(Resources resources) {
        this.mResources = resources;
        if (resources == null) {
            if (this.mState == 3) {
                stopPlay();
            }
        } else if (this.mAttachedWindow) {
            startPlay();
        }
    }

    public final void setNetResourcesOnly(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mResources = new NetResources(url);
    }

    public final void setFileResourcesOnly(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.mResources = new FileResources(file);
    }

    public final void setNetResources(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mResources = new NetResources(url);
        if (this.mAttachedWindow) {
            startPlay();
        }
    }

    public final void resetNetResources() {
        this.mResources = null;
    }

    public final void setOnPlayListener(OnPlayListener listener) {
        this.mOnPlayListener = listener;
    }

    public final void setFileResources(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.mResources = new FileResources(file);
        if (this.mAttachedWindow) {
            startPlay();
        }
    }

    public final void setPlaceHodler(Drawable drawable) {
        if (Intrinsics.areEqual(drawable, this.mPlaceHolderDrawable)) {
            return;
        }
        this.mPlaceHolderDrawable = drawable;
        if (this.mState == 2 || this.mState == 1) {
            this.mImageView.setImageDrawable(this.mPlaceHolderDrawable);
        }
    }

    public final void setErrorDrawable(Drawable drawable) {
        if (Intrinsics.areEqual(drawable, this.mErrorDrawable)) {
            return;
        }
        this.mErrorDrawable = drawable;
        if (this.mState == 4) {
            this.mImageView.setImageDrawable(drawable);
        }
    }

    public final void setPlayLoopMode(boolean loop) {
        this.mGifVideoView.setPlayLoopMode(loop);
    }

    public final void setLoadingDrawable(Drawable drawable) {
        if (Intrinsics.areEqual(drawable, this.mProgressDrawable)) {
            return;
        }
        this.mProgressDrawable = drawable;
        if (this.mState == 4) {
            this.mProgressView.setImageDrawable(drawable);
        }
    }

    public final void setFillType(int type) {
        switch (type) {
            case 1:
                this.mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;
            case 2:
            default:
                this.mImageView.setScaleType(ImageView.ScaleType.CENTER);
                break;
            case 3:
                this.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
        }
        this.mImageView.requestLayout();
        this.mGifVideoView.setFillType(type);
        this.mGifVideoView.requestLayout();
        this.mFillType = type;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedWindow = true;
        if (this.mResources != null) {
            startPlay();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedWindow = false;
        stopPlay();
        this.mState = 1;
        this.mImageView.setVisibility(0);
    }

    public final void startPlay() {
        Resources resources;
        if (this.mAttachedWindow && (resources = this.mResources) != null) {
            this.mState = 2;
            this.mProgressView.setVisibility(0);
            OnPlayListener onPlayListener = this.mOnPlayListener;
            if (onPlayListener != null) {
                onPlayListener.onStartLoading();
            }
            this.mGifVideoView.start(resources, this, this);
        }
    }

    public final void stopPlay() {
        if (this.mState == 3 || this.mState == 2) {
            this.mState = 1;
            this.mGifVideoView.stop(false, false);
        }
    }

    public final void stopPlayAndRelease() {
        if (this.mState == 3 || this.mState == 2) {
            this.mGifVideoView.stop(false, true);
        }
    }

    public final int getState() {
        return this.mState;
    }

    @Override // tv.danmaku.gifplayer.GifVideoView.Listener
    public void onFirstRender() {
        this.mState = 3;
        this.mImageView.setVisibility(4);
        this.mProgressView.setVisibility(4);
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onPlaying();
        }
    }

    @Override // tv.danmaku.gifplayer.GifVideoView.Listener
    public void onError() {
        this.mImageView.setVisibility(0);
        this.mImageView.setImageDrawable(this.mErrorDrawable);
        this.mGifVideoView.stop(false, true);
        this.mState = 4;
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onError();
        }
    }

    @Override // tv.danmaku.gifplayer.GifVideoView.Listener
    public void onStop(boolean byOther) {
        this.mState = 1;
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onStopPlay(byOther);
        }
    }

    @Override // tv.danmaku.gifplayer.GifVideoView.Listener
    public void onComplete() {
        this.mState = 1;
        OnPlayListener onPlayListener = this.mOnPlayListener;
        if (onPlayListener != null) {
            onPlayListener.onComplete();
        }
    }

    /* compiled from: PlayerImageView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/gifplayer/PlayerImageView$OnPlayListener;", "", "onStartLoading", "", "onPlaying", "onError", "onComplete", "onStopPlay", "byOther", "", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnPlayListener {
        void onComplete();

        void onError();

        void onPlaying();

        void onStartLoading();

        void onStopPlay(boolean z);

        /* compiled from: PlayerImageView.kt */
        /* renamed from: tv.danmaku.gifplayer.PlayerImageView$OnPlayListener$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
            public static void $default$onStartLoading(OnPlayListener _this) {
            }

            public static void $default$onPlaying(OnPlayListener _this) {
            }

            public static void $default$onError(OnPlayListener _this) {
            }

            public static void $default$onComplete(OnPlayListener _this) {
            }

            public static void $default$onStopPlay(OnPlayListener _this, boolean byOther) {
            }
        }
    }
}