package tv.danmaku.bili.ui.push.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ImageInfo;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.RoundingParams;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.image2.view.legacy.StaticImageView2;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.lib.ui.util.NightTheme;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.Tintable;
import com.bilibili.module.main.innerpush.InnerPush;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.push.innerpush.model.InnerPushExtensionKt;
import tv.danmaku.bili.ui.push.HeadsUpLiveAvatar;
import tv.danmaku.bili.ui.push.v2.manager.InnerPushStatusListener;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: InnerPushView.kt */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001CB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010&\u001a\u00020\nH\u0002J\b\u0010'\u001a\u00020\u0011H\u0014J\b\u0010(\u001a\u00020\u0011H\u0014J\b\u0010)\u001a\u0004\u0018\u00010*J\u0018\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010*2\u0006\u0010-\u001a\u00020\u0015J\u0010\u0010.\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010*J\u001e\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u0002012\u0006\u0010-\u001a\u00020\u00152\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\u00112\u0006\u00100\u001a\u000201H\u0002J\b\u00105\u001a\u00020\u0011H\u0002J\u0012\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0014\u00109\u001a\u00020\u00112\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0010\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010<\u001a\u00020=H\u0017J\b\u0010?\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010,\u001a\u00020*H\u0002J\u0010\u0010B\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Ltv/danmaku/bili/ui/push/v2/InnerPushView;", "Landroid/widget/FrameLayout;", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$Observer;", "context", "Landroid/content/Context;", "hasBizView", "", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;ZLandroid/util/AttributeSet;I)V", "mDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "mOffScreenCallback", "Lkotlin/Function0;", "", "mLiveAvatar", "Ltv/danmaku/bili/ui/push/HeadsUpLiveAvatar;", "mOnViewStatusListener", "Ltv/danmaku/bili/ui/push/v2/manager/InnerPushStatusListener;", "mTitleView", "Landroid/widget/TextView;", "mMessageView", "mCoverImage", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mIconImage", "Lcom/bilibili/lib/image2/view/legacy/StaticImageView2;", "mBizRootView", "Landroid/widget/RelativeLayout;", "mInnerRootView", "mContentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mBarrier", "Landroidx/constraintlayout/widget/Barrier;", "mArrowImage", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "getTopMarginInner", "onAttachedToWindow", "onDetachedFromWindow", "getBizRootView", "Landroid/view/View;", "addBizView", "view", "onViewStatusListener", "replaceBizView", "update", "innerPush", "Lcom/bilibili/module/main/innerpush/InnerPush;", "listener", "Lcom/bilibili/lib/image2/bean/ImageLoadingListener;", "updateIcon", "updateBackground", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOffScreenCallback", "callback", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "computeScroll", "onThemeChanged", "tint", "initViews", "DragHelperCallback", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class InnerPushView extends FrameLayout implements ThemeWatcher.Observer {
    public static final int $stable = 8;
    private TintImageView mArrowImage;
    private Barrier mBarrier;
    private RelativeLayout mBizRootView;
    private ConstraintLayout mContentView;
    private BiliImageView mCoverImage;
    private ViewDragHelper mDragHelper;
    private StaticImageView2 mIconImage;
    private FrameLayout mInnerRootView;
    private HeadsUpLiveAvatar mLiveAvatar;
    private TextView mMessageView;
    private Function0<Unit> mOffScreenCallback;
    private InnerPushStatusListener mOnViewStatusListener;
    private TextView mTitleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context) {
        this(context, false, null, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context, boolean z) {
        this(context, z, null, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context, boolean z, AttributeSet attributeSet) {
        this(context, z, attributeSet, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerPushView(Context context, boolean hasBizView, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(getContext(), R.layout.bili_app_layout_app_inner_push, this);
        initViews(hasBizView);
        ViewGroup rootContent = hasBizView ? this.mBizRootView : this.mInnerRootView;
        ViewGroup.LayoutParams layoutParams = rootContent != null ? rootContent.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin += getTopMarginInner();
            rootContent.requestLayout();
        }
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new DragHelperCallback());
        Barrier barrier = this.mBarrier;
        if (barrier != null) {
            barrier.setReferencedIds(new int[]{R.id.icon, R.id.live_icon});
        }
    }

    public /* synthetic */ InnerPushView(Context context, boolean z, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : attributeSet, (i2 & 8) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTopMarginInner() {
        return InnerPushViewUtilsKt.getStatusBarHeight(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        BLog.i("InnerPushView", "InnerPushView onAttachedToWindow");
        super.onAttachedToWindow();
        ThemeWatcher.getInstance().subscribe(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().unSubscribe(this);
    }

    public final View getBizRootView() {
        return this.mBizRootView;
    }

    public final void addBizView(View view2, InnerPushStatusListener onViewStatusListener) {
        RelativeLayout relativeLayout;
        Intrinsics.checkNotNullParameter(onViewStatusListener, "onViewStatusListener");
        this.mOnViewStatusListener = onViewStatusListener;
        if (view2 != null && (relativeLayout = this.mBizRootView) != null) {
            relativeLayout.addView(view2);
        }
        requestLayout();
    }

    public final void replaceBizView(View view2) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2 = this.mBizRootView;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
        }
        if (view2 != null && (relativeLayout = this.mBizRootView) != null) {
            relativeLayout.addView(view2);
        }
        requestLayout();
    }

    public final void update(final InnerPush innerPush, InnerPushStatusListener onViewStatusListener, final ImageLoadingListener listener) {
        Intrinsics.checkNotNullParameter(innerPush, "innerPush");
        Intrinsics.checkNotNullParameter(onViewStatusListener, "onViewStatusListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnViewStatusListener = onViewStatusListener;
        if (InnerPushExtensionKt.isImageType(innerPush)) {
            setVisibility(0);
            FrameLayout frameLayout = this.mInnerRootView;
            if (frameLayout != null) {
                frameLayout.setBackgroundColor(0);
            }
            ConstraintLayout constraintLayout = this.mContentView;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            BiliImageView coverImage = this.mCoverImage;
            if (coverImage == null) {
                return;
            }
            coverImage.setVisibility(0);
            float corner = ListExtentionsKt.toPx(12);
            RoundingParams roundingParams = RoundingParams.Companion.fromCornersRadii(corner, corner, corner, corner);
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = coverImage.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            ImageRequestBuilder.enableAutoPlayAnimation$default(biliImageLoader.with(context).url(innerPush.getPureImage()).roundingParams(roundingParams).imageLoadingListener(new ImageLoadingListener() { // from class: tv.danmaku.bili.ui.push.v2.InnerPushView$update$1
                public /* synthetic */ void onImageLoading(Uri uri) {
                    ImageLoadingListener.-CC.$default$onImageLoading(this, uri);
                }

                public /* synthetic */ void onImageSet(ImageInfo imageInfo, Bitmap bitmap) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo, bitmap);
                }

                public /* synthetic */ void onIntermediateImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onIntermediateImageSet(this, imageInfo);
                }

                public void onImageSet(ImageInfo imageInfo) {
                    ImageLoadingListener.-CC.$default$onImageSet(this, imageInfo);
                    listener.onImageSet(imageInfo);
                    this.updateBackground();
                }

                public void onImageLoadFailed(Throwable err) {
                    ImageLoadingListener.-CC.$default$onImageLoadFailed(this, err);
                    listener.onImageLoadFailed(err);
                    BLog.i("InnerPushView", "onImageLoadFailed, coverUrl = " + innerPush.getPureImage());
                }
            }), true, false, 2, (Object) null).into(coverImage);
            return;
        }
        BiliImageView coverImage2 = this.mCoverImage;
        if (coverImage2 != null) {
            coverImage2.setVisibility(8);
        }
        ConstraintLayout constraintLayout2 = this.mContentView;
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(innerPush.getTitle());
        }
        TextView textView2 = this.mMessageView;
        if (textView2 != null) {
            String message = innerPush.getMessage();
            if (message == null) {
                message = "";
            }
            textView2.setText(new SpannableString(message));
        }
        TintImageView tintImageView = this.mArrowImage;
        if (tintImageView != null) {
            tintImageView.setVisibility(innerPush.getHideArrow() ? 8 : 0);
        }
        updateIcon(innerPush);
        updateBackground();
    }

    private final void updateIcon(InnerPush innerPush) {
        String icon = innerPush.getIcon();
        if (!(icon == null || icon.length() == 0)) {
            if (InnerPushExtensionKt.getLiveBorderEnable(innerPush) || InnerPushExtensionKt.getLiveMarkerEnable(innerPush)) {
                if (this.mLiveAvatar == null) {
                    View findViewById = findViewById(R.id.live_avatar_stub);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                    ViewStub stub = (ViewStub) findViewById;
                    this.mLiveAvatar = new HeadsUpLiveAvatar(stub);
                }
                HeadsUpLiveAvatar liveAvatar = this.mLiveAvatar;
                if (liveAvatar != null) {
                    StaticImageView2 staticImageView2 = this.mIconImage;
                    if (staticImageView2 != null) {
                        staticImageView2.setVisibility(4);
                    }
                    liveAvatar.setVisible(true);
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    liveAvatar.setup(context, innerPush.getIcon(), InnerPushExtensionKt.getLiveBorderEnable(innerPush), InnerPushExtensionKt.getLiveMarkerEnable(innerPush));
                    TextView textView = this.mTitleView;
                    ViewGroup.LayoutParams layoutParams = textView != null ? textView.getLayoutParams() : null;
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = ListExtentionsKt.toPx(10);
                        TextView textView2 = this.mTitleView;
                        if (textView2 != null) {
                            textView2.requestLayout();
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            HeadsUpLiveAvatar liveAvatar2 = this.mLiveAvatar;
            if (liveAvatar2 != null) {
                liveAvatar2.setVisible(false);
            }
            StaticImageView2 staticImageView22 = this.mIconImage;
            if (staticImageView22 != null) {
                staticImageView22.setVisibility(0);
            }
            BiliImageView biliImageView = this.mIconImage;
            if (biliImageView != null) {
                BiliImageView.setImageTint$default(biliImageView, com.bilibili.lib.widget.R.color.auto_night_shade, (PorterDuff.Mode) null, 2, (Object) null);
            }
            BiliImageView biliImageView2 = this.mIconImage;
            if (biliImageView2 != null) {
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Context context2 = biliImageView2.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                biliImageLoader.with(context2).url(innerPush.getIcon()).into(biliImageView2);
            }
            TextView textView3 = this.mTitleView;
            ViewGroup.LayoutParams layoutParams2 = textView3 != null ? textView3.getLayoutParams() : null;
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ListExtentionsKt.toPx(16);
                TextView textView4 = this.mTitleView;
                if (textView4 != null) {
                    textView4.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        HeadsUpLiveAvatar headsUpLiveAvatar = this.mLiveAvatar;
        if (headsUpLiveAvatar != null) {
            headsUpLiveAvatar.setVisible(false);
        }
        StaticImageView2 staticImageView23 = this.mIconImage;
        if (staticImageView23 != null) {
            staticImageView23.setVisibility(8);
        }
        TextView textView5 = this.mTitleView;
        ViewGroup.LayoutParams layoutParams3 = textView5 != null ? textView5.getLayoutParams() : null;
        if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = ListExtentionsKt.toPx(16);
            TextView textView6 = this.mTitleView;
            if (textView6 != null) {
                textView6.requestLayout();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackground() {
        FrameLayout frameLayout = this.mInnerRootView;
        if (frameLayout != null) {
            frameLayout.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.img_inner_push_bg));
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        ConstraintLayout constraintLayout = this.mContentView;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(l);
        }
        BiliImageView biliImageView = this.mCoverImage;
        if (biliImageView != null) {
            biliImageView.setOnClickListener(l);
        }
        RelativeLayout relativeLayout = this.mBizRootView;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(l);
        }
    }

    public final void setOffScreenCallback(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "callback");
        this.mOffScreenCallback = function0;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        int action = MotionEventCompat.getActionMasked(ev);
        switch (action) {
            case 1:
            case 3:
                ViewDragHelper viewDragHelper = this.mDragHelper;
                if (viewDragHelper != null) {
                    viewDragHelper.cancel();
                }
                return false;
            case 2:
            default:
                ViewDragHelper viewDragHelper2 = this.mDragHelper;
                if (viewDragHelper2 != null) {
                    return viewDragHelper2.shouldInterceptTouchEvent(ev);
                }
                return false;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        ViewDragHelper viewDragHelper = this.mDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(ev);
            return true;
        }
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.mDragHelper;
        boolean z = false;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            z = true;
        }
        if (z) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    public void onThemeChanged() {
        StaticImageView2 staticImageView2 = this.mIconImage;
        if (staticImageView2 != null) {
            staticImageView2.setAlpha(NightTheme.isNightTheme(getContext()) ? 0.8f : 1.0f);
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga10));
        }
        TextView textView2 = this.mMessageView;
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(getContext(), com.bilibili.lib.theme.R.color.Ga5));
        }
        updateBackground();
        tint(this);
        HeadsUpLiveAvatar headsUpLiveAvatar = this.mLiveAvatar;
        if (headsUpLiveAvatar != null) {
            headsUpLiveAvatar.onThemeChanged();
        }
    }

    private final void tint(View view2) {
        Tintable tintable = view2 instanceof Tintable ? (Tintable) view2 : null;
        if (tintable != null) {
            tintable.tint();
        }
        if (view2 instanceof ViewGroup) {
            int size = ((ViewGroup) view2).getChildCount();
            for (int i = 0; i < size; i++) {
                View childAt = ((ViewGroup) view2).getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                tint(childAt);
            }
        }
    }

    private final void initViews(boolean hasBizView) {
        this.mBizRootView = (RelativeLayout) findViewById(R.id.biz_root_view);
        this.mInnerRootView = (FrameLayout) findViewById(R.id.inner_root_view);
        if (hasBizView) {
            RelativeLayout relativeLayout = this.mBizRootView;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            FrameLayout frameLayout = this.mInnerRootView;
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        } else {
            RelativeLayout relativeLayout2 = this.mBizRootView;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            FrameLayout frameLayout2 = this.mInnerRootView;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(0);
            }
        }
        this.mContentView = findViewById(R.id.content_view);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mMessageView = (TextView) findViewById(R.id.message);
        this.mIconImage = findViewById(R.id.icon);
        this.mBarrier = findViewById(R.id.icon_barrier);
        this.mArrowImage = findViewById(R.id.go);
        this.mCoverImage = findViewById(R.id.iv_cover);
    }

    /* compiled from: InnerPushView.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J0\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/ui/push/v2/InnerPushView$DragHelperCallback;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "<init>", "(Ltv/danmaku/bili/ui/push/v2/InnerPushView;)V", "tryCaptureView", "", "child", "Landroid/view/View;", "pointerId", "", "clampViewPositionVertical", "top", "dy", "onViewReleased", "", "releasedChild", "xvel", "", "yvel", "getViewVerticalDragRange", "onViewPositionChanged", "changedView", "left", "dx", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    private final class DragHelperCallback extends ViewDragHelper.Callback {
        public DragHelperCallback() {
        }

        public boolean tryCaptureView(View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            return true;
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            Intrinsics.checkNotNullParameter(child, "child");
            int topBound = (-InnerPushView.this.getHeight()) - InnerPushView.this.getTopMarginInner();
            int bottomBound = InnerPushView.this.getTopMarginInner();
            return Math.min(Math.max(top, topBound), bottomBound);
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            InnerPushStatusListener innerPushStatusListener;
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            int originY = InnerPushView.this.getTopMarginInner();
            boolean isSettle = xvel >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && ((float) originY) - releasedChild.getY() < 90.0f;
            int finalTop = isSettle ? InnerPushView.this.getTopMarginInner() : (-releasedChild.getHeight()) - InnerPushView.this.getTopMarginInner();
            if (!isSettle && (innerPushStatusListener = InnerPushView.this.mOnViewStatusListener) != null) {
                innerPushStatusListener.onDismiss(InnerPushView.this.getContext(), 1);
            }
            ViewDragHelper viewDragHelper = InnerPushView.this.mDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.settleCapturedViewAt(releasedChild.getLeft(), finalTop);
            }
            InnerPushView.this.invalidate();
        }

        public int getViewVerticalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            return child.getHeight();
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
            Function0 function0;
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            if (top > (-changedView.getHeight()) || (function0 = InnerPushView.this.mOffScreenCallback) == null) {
                return;
            }
            function0.invoke();
        }
    }
}