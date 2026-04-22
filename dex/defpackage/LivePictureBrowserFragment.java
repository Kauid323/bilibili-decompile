package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.bilibili.bililive.infra.log.LiveLog;
import com.bilibili.bililive.infra.log.LiveLogDelegate;
import com.bilibili.bililive.infra.log.LiveLogger;
import com.bilibili.bililive.infra.picturebrowser.R;
import com.bilibili.bililive.infra.util.app.AppKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.widget.PinchBiliImageView;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;

/* compiled from: LivePictureBrowserFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00013B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001cH\u0016J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020$H\u0016J\u0012\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"LLivePictureBrowserFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "Lcom/bilibili/lib/imageviewer/widget/PinchBiliImageView$DragClosingListener;", "Lcom/bilibili/bililive/infra/log/LiveLogger;", "<init>", "()V", "pinchImageView", "Lcom/bilibili/lib/imageviewer/widget/PinchBiliImageView;", "textViewDesc", "Landroid/widget/TextView;", "backgroundView", "Landroid/view/View;", "listener", "LLivePictureBrowserListener;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setListener", "loadImage", LivePictureBrowserFragment.KEY_URL, "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "loadDesc", LivePictureBrowserFragment.KEY_DESC, "changeDescMarginByOrientation", "orientation", "", "setBgAlpha", "alpha", "", "doCloseImageViewAnim", "close", "isDownward", "", "onRelease", "duration", "onClick", "v", "logTag", "getLogTag", "()Ljava/lang/String;", "Companion", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: LivePictureBrowserFragment  reason: default package */
public class LivePictureBrowserFragment extends androidx_fragment_app_Fragment implements View.OnClickListener, PinchBiliImageView.DragClosingListener, LiveLogger {
    private static final long DURATION_IMAGEVIEW_CLOSE = 250;
    private static final String KEY_DESC = "desc";
    private static final String KEY_URL = "url";
    private static final String TAG = "LivePictureBrowserFragment";
    private View backgroundView;
    private LivePictureBrowserListener listener;
    private PinchBiliImageView pinchImageView;
    private TextView textViewDesc;
    public static final Companion Companion = new Companion(null);
    private static final int MARGIN_BOTTOM_LANDSCAPE = AppKt.dp2px(20.0f);
    private static final int MARGIN_BOTTOM_PORTRAIT = AppKt.dp2px(157.0f);

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.live_picture_browser_fragment, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        String string;
        Intrinsics.checkNotNullParameter(view, "view");
        this.pinchImageView = view.findViewById(R.id.iv_pic);
        this.backgroundView = view.findViewById(R.id.v_background);
        this.textViewDesc = (TextView) view.findViewById(R.id.tv_desc);
        PinchBiliImageView pinchBiliImageView = this.pinchImageView;
        if (pinchBiliImageView != null) {
            pinchBiliImageView.setCanCloseByScrollUp(true);
        }
        PinchBiliImageView pinchBiliImageView2 = this.pinchImageView;
        if (pinchBiliImageView2 != null) {
            pinchBiliImageView2.setOnClickListener(this);
        }
        PinchBiliImageView pinchBiliImageView3 = this.pinchImageView;
        if (pinchBiliImageView3 != null) {
            pinchBiliImageView3.setDragClosingListener(this);
        }
        Bundle arguments = getArguments();
        String str = "";
        loadImage((arguments == null || (r0 = arguments.getString(KEY_URL)) == null) ? "" : "");
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(KEY_DESC)) != null) {
            str = string;
        }
        loadDesc(str);
    }

    public final void setListener(LivePictureBrowserListener listener) {
        this.listener = listener;
    }

    public void loadImage(String url) {
        BiliImageView biliImageView;
        Intrinsics.checkNotNullParameter(url, KEY_URL);
        if (!StringsKt.isBlank(url) && (biliImageView = this.pinchImageView) != null) {
            ImageRequestBuilder url2 = BiliImageLoader.INSTANCE.with((Fragment) this).url(url);
            ScaleType scaleType = ScaleType.FIT_CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "FIT_CENTER");
            url2.actualImageScaleType(scaleType).into(biliImageView);
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == 2 || newConfig.orientation == 1) {
            changeDescMarginByOrientation(newConfig.orientation);
        }
    }

    public void loadDesc(String desc) {
        Intrinsics.checkNotNullParameter(desc, KEY_DESC);
        if (StringsKt.isBlank(desc)) {
            return;
        }
        TextView textView = this.textViewDesc;
        if (textView != null) {
            textView.setText(desc);
        }
        changeDescMarginByOrientation(getResources().getConfiguration().orientation);
        TextView textView2 = this.textViewDesc;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
    }

    private final void changeDescMarginByOrientation(int orientation) {
        int marginBottom;
        if (orientation == 2) {
            marginBottom = MARGIN_BOTTOM_LANDSCAPE;
        } else {
            marginBottom = MARGIN_BOTTOM_PORTRAIT;
        }
        TextView textView = this.textViewDesc;
        ConstraintLayout.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
        ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
        if (layoutParams2 != null) {
            ConstraintLayout.LayoutParams $this$changeDescMarginByOrientation_u24lambda_u240 = layoutParams2;
            $this$changeDescMarginByOrientation_u24lambda_u240.setMargins(0, 0, 0, marginBottom);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setBgAlpha(float alpha) {
        String str;
        LiveLog.Companion this_$iv$iv;
        String msg$iv$iv$iv$iv;
        String msg$iv$iv$iv;
        String msg$iv$iv$iv$iv2;
        String msg$iv$iv$iv$iv3;
        String msg$iv$iv$iv2;
        String str2;
        LiveLog.Companion this_$iv$iv2;
        Context it = getContext();
        if (it != null) {
            try {
                LivePictureBrowserFragment $this$logDebug_u24default$iv = this;
                LiveLog.Companion this_$iv$iv3 = LiveLog.Companion;
                String tag$iv$iv = $this$logDebug_u24default$iv.getLogTag();
                if (this_$iv$iv3.isDebug()) {
                    try {
                        try {
                            str2 = "alpha is " + alpha;
                        } catch (Exception e$iv$iv$iv) {
                            BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv);
                            str2 = null;
                        }
                        String msg$iv$iv$iv3 = str2;
                        if (msg$iv$iv$iv3 == null) {
                            msg$iv$iv$iv3 = "";
                        }
                        BLog.d(tag$iv$iv, msg$iv$iv$iv3);
                        LiveLogDelegate logDelegate = this_$iv$iv3.getLogDelegate();
                        if (logDelegate != null) {
                            this_$iv$iv2 = this_$iv$iv3;
                            LiveLogDelegate.-CC.onLog$default(logDelegate, 4, tag$iv$iv, msg$iv$iv$iv3, (Throwable) null, 8, (Object) null);
                        } else {
                            this_$iv$iv2 = this_$iv$iv3;
                        }
                        str = "";
                    } catch (Exception e) {
                        e = e;
                        str = "";
                        Exception e2 = e;
                        LivePictureBrowserFragment $this$logDebug_u24default$iv2 = this;
                        this_$iv$iv = LiveLog.Companion;
                        String tag$iv$iv2 = $this$logDebug_u24default$iv2.getLogTag();
                        if (this_$iv$iv.isDebug()) {
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else if (!this_$iv$iv3.matchLevel(4)) {
                    str = "";
                } else {
                    str = "";
                    try {
                        if (this_$iv$iv3.matchLevel(3)) {
                            try {
                                msg$iv$iv$iv$iv2 = "alpha is " + alpha;
                            } catch (Exception e$iv$iv$iv$iv) {
                                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv);
                                msg$iv$iv$iv$iv2 = null;
                            }
                            if (msg$iv$iv$iv$iv2 == null) {
                                msg$iv$iv$iv$iv2 = str;
                            }
                            LiveLogDelegate logDelegate2 = this_$iv$iv3.getLogDelegate();
                            if (logDelegate2 != null) {
                                LiveLogDelegate.-CC.onLog$default(logDelegate2, 3, tag$iv$iv, msg$iv$iv$iv$iv2, (Throwable) null, 8, (Object) null);
                            }
                            BLog.i(tag$iv$iv, msg$iv$iv$iv$iv2);
                        }
                    } catch (Exception e3) {
                        e = e3;
                        Exception e22 = e;
                        LivePictureBrowserFragment $this$logDebug_u24default$iv22 = this;
                        this_$iv$iv = LiveLog.Companion;
                        String tag$iv$iv22 = $this$logDebug_u24default$iv22.getLogTag();
                        if (this_$iv$iv.isDebug()) {
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                try {
                    int color = ContextCompat.getColor(it, R.color.image_container_bg_color);
                    int originalAlpha = Color.alpha(color);
                    float finalAlpha = (originalAlpha / 255.0f) * alpha;
                    LivePictureBrowserFragment $this$logDebug_u24default$iv3 = this;
                    LiveLog.Companion this_$iv$iv4 = LiveLog.Companion;
                    String tag$iv$iv3 = $this$logDebug_u24default$iv3.getLogTag();
                    if (this_$iv$iv4.isDebug()) {
                        try {
                            msg$iv$iv$iv2 = "finalAlpha is " + finalAlpha;
                        } catch (Exception e$iv$iv$iv2) {
                            BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv2);
                            msg$iv$iv$iv2 = null;
                        }
                        if (msg$iv$iv$iv2 == null) {
                            msg$iv$iv$iv2 = str;
                        }
                        BLog.d(tag$iv$iv3, msg$iv$iv$iv2);
                        LiveLogDelegate logDelegate3 = this_$iv$iv4.getLogDelegate();
                        if (logDelegate3 != null) {
                            LiveLogDelegate.-CC.onLog$default(logDelegate3, 4, tag$iv$iv3, msg$iv$iv$iv2, (Throwable) null, 8, (Object) null);
                        }
                    } else {
                        try {
                            if (this_$iv$iv4.matchLevel(4) && this_$iv$iv4.matchLevel(3)) {
                                try {
                                    msg$iv$iv$iv$iv3 = "finalAlpha is " + finalAlpha;
                                } catch (Exception e$iv$iv$iv$iv2) {
                                    BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv2);
                                    msg$iv$iv$iv$iv3 = null;
                                }
                                if (msg$iv$iv$iv$iv3 == null) {
                                    msg$iv$iv$iv$iv3 = str;
                                }
                                LiveLogDelegate logDelegate4 = this_$iv$iv4.getLogDelegate();
                                if (logDelegate4 != null) {
                                    LiveLogDelegate.-CC.onLog$default(logDelegate4, 3, tag$iv$iv3, msg$iv$iv$iv$iv3, (Throwable) null, 8, (Object) null);
                                }
                                BLog.i(tag$iv$iv3, msg$iv$iv$iv$iv3);
                            }
                        } catch (Exception e4) {
                            e = e4;
                            Exception e222 = e;
                            LivePictureBrowserFragment $this$logDebug_u24default$iv222 = this;
                            this_$iv$iv = LiveLog.Companion;
                            String tag$iv$iv222 = $this$logDebug_u24default$iv222.getLogTag();
                            if (this_$iv$iv.isDebug()) {
                            }
                            Unit unit22 = Unit.INSTANCE;
                        }
                    }
                    int finalColor = ColorUtils.setAlphaComponent(color, (int) (finalAlpha * 255.0f));
                    View view = this.backgroundView;
                    if (view != null) {
                        view.setBackgroundColor(finalColor);
                        Unit unit3 = Unit.INSTANCE;
                    }
                } catch (Exception e5) {
                    e = e5;
                    Exception e2222 = e;
                    LivePictureBrowserFragment $this$logDebug_u24default$iv2222 = this;
                    this_$iv$iv = LiveLog.Companion;
                    String tag$iv$iv2222 = $this$logDebug_u24default$iv2222.getLogTag();
                    if (this_$iv$iv.isDebug()) {
                        if (this_$iv$iv.matchLevel(4) && this_$iv$iv.matchLevel(3)) {
                            try {
                                msg$iv$iv$iv$iv = "setBgAlpha exception " + e2222;
                            } catch (Exception e$iv$iv$iv$iv3) {
                                BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv$iv3);
                                msg$iv$iv$iv$iv = null;
                            }
                            String msg$iv$iv$iv$iv4 = msg$iv$iv$iv$iv == null ? str : msg$iv$iv$iv$iv;
                            LiveLogDelegate logDelegate5 = this_$iv$iv.getLogDelegate();
                            if (logDelegate5 != null) {
                                LiveLogDelegate.-CC.onLog$default(logDelegate5, 3, tag$iv$iv2222, msg$iv$iv$iv$iv4, (Throwable) null, 8, (Object) null);
                            }
                            BLog.i(tag$iv$iv2222, msg$iv$iv$iv$iv4);
                        }
                    } else {
                        try {
                            msg$iv$iv$iv = "setBgAlpha exception " + e2222;
                        } catch (Exception e$iv$iv$iv3) {
                            BLog.e("LiveLog", "getLogMessage", e$iv$iv$iv3);
                            msg$iv$iv$iv = null;
                        }
                        if (msg$iv$iv$iv == null) {
                            msg$iv$iv$iv = str;
                        }
                        BLog.d(tag$iv$iv2222, msg$iv$iv$iv);
                        LiveLogDelegate logDelegate6 = this_$iv$iv.getLogDelegate();
                        if (logDelegate6 != null) {
                            LiveLogDelegate.-CC.onLog$default(logDelegate6, 4, tag$iv$iv2222, msg$iv$iv$iv, (Throwable) null, 8, (Object) null);
                        }
                    }
                    Unit unit222 = Unit.INSTANCE;
                }
            } catch (Exception e6) {
                e = e6;
                str = "";
            }
        }
    }

    private final void doCloseImageViewAnim() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator scaleX;
        ViewPropertyAnimator scaleY;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator duration;
        PinchBiliImageView pinchBiliImageView = this.pinchImageView;
        if (pinchBiliImageView != null && (animate = pinchBiliImageView.animate()) != null && (scaleX = animate.scaleX(0.0f)) != null && (scaleY = scaleX.scaleY(0.0f)) != null && (alpha = scaleY.alpha(0.0f)) != null && (listener = alpha.setListener(new AnimatorListenerAdapter() { // from class: LivePictureBrowserFragment$doCloseImageViewAnim$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                LivePictureBrowserListener livePictureBrowserListener;
                Intrinsics.checkNotNullParameter(animation, "animation");
                livePictureBrowserListener = LivePictureBrowserFragment.this.listener;
                if (livePictureBrowserListener != null) {
                    livePictureBrowserListener.onImageViewClick();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                LivePictureBrowserListener livePictureBrowserListener;
                Intrinsics.checkNotNullParameter(animation, "animation");
                livePictureBrowserListener = LivePictureBrowserFragment.this.listener;
                if (livePictureBrowserListener != null) {
                    livePictureBrowserListener.onImageViewClick();
                }
            }
        })) != null && (duration = listener.setDuration(DURATION_IMAGEVIEW_CLOSE)) != null) {
            duration.start();
        }
    }

    public void close(boolean isDownward) {
        LivePictureBrowserListener livePictureBrowserListener = this.listener;
        if (livePictureBrowserListener != null) {
            livePictureBrowserListener.onDragRelease();
        }
    }

    public void onRelease(int duration) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        doCloseImageViewAnim();
    }

    /* compiled from: LivePictureBrowserFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"LLivePictureBrowserFragment$Companion;", "", "<init>", "()V", "create", "LLivePictureBrowserFragment;", "data", "LILivePictureData;", "KEY_URL", "", "KEY_DESC", "TAG", "MARGIN_BOTTOM_LANDSCAPE", "", "MARGIN_BOTTOM_PORTRAIT", "DURATION_IMAGEVIEW_CLOSE", "", "picturebrowser_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: LivePictureBrowserFragment$Companion */
    /* loaded from: /data/np/file-convert/20260228072147352a8659-7851-447b-9412-098785020763/20260228072147352a8659-7851-447b-9412-098785020763.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LivePictureBrowserFragment create(ILivePictureData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            LivePictureBrowserFragment $this$create_u24lambda_u240 = new LivePictureBrowserFragment();
            Bundle bundle = new Bundle();
            bundle.putString(LivePictureBrowserFragment.KEY_URL, data.url());
            bundle.putString(LivePictureBrowserFragment.KEY_DESC, data.desc());
            $this$create_u24lambda_u240.setArguments(bundle);
            return $this$create_u24lambda_u240;
        }
    }

    public String getLogTag() {
        return TAG;
    }
}