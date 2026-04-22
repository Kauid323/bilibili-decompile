package tv.danmaku.bili.ui.deeplinkbutton;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MarginLayoutParamsCompat;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.ui.theme.ThemeWatcher;
import com.bilibili.magicasakura.widgets.TintImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.DisplayUtils;
import tv.danmaku.bili.ui.deeplinkbutton.api.DeepLinkButtonInfo;

/* compiled from: DeepLinkButtonView.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u0011J\u0010\u0010&\u001a\u00020\"2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\"H\u0014J\b\u00100\u001a\u00020\"H\u0014R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnTouchListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTitleView", "Landroid/widget/TextView;", "mCloseView", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "mListen", "Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonView$IDeepLinkViewListen;", "mArrowView", "mLastY", "", "mContentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mIsMove", "", "mDeepLinkButtonInfo", "Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "mOriginalOrientation", "mIconView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mIconBgView", "mThemeObserver", "Lcom/bilibili/lib/ui/theme/ThemeWatcher$MainObserver;", "initViews", "", "setDeepLinkButtonInfo", "buttonInfo", "clickListen", "onClick", "view", "Landroid/view/View;", "onTouch", "motionEvent", "Landroid/view/MotionEvent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAttachedToWindow", "onDetachedFromWindow", "IDeepLinkViewListen", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeepLinkButtonView extends FrameLayout implements View.OnClickListener, View.OnTouchListener {
    public static final int $stable = 8;
    private TintImageView mArrowView;
    private TintImageView mCloseView;
    private ConstraintLayout mContentView;
    private DeepLinkButtonInfo mDeepLinkButtonInfo;
    private FrameLayout mIconBgView;
    private BiliImageView mIconView;
    private boolean mIsMove;
    private float mLastY;
    private IDeepLinkViewListen mListen;
    private int mOriginalOrientation;
    private final ThemeWatcher.MainObserver mThemeObserver;
    private TextView mTitleView;

    /* compiled from: DeepLinkButtonView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/DeepLinkButtonView$IDeepLinkViewListen;", "", "onClickJump", "", "backUrl", "", "onClickClose", "onTouchEvent", "dy", "", "onDistanceChange", "onPortLandChange", "orientation", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface IDeepLinkViewListen {
        void onClickClose();

        void onClickJump(String str);

        void onDistanceChange();

        void onPortLandChange(int i);

        void onTouchEvent(int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeepLinkButtonView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeepLinkButtonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepLinkButtonView(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mThemeObserver = new ThemeWatcher.MainObserver() { // from class: tv.danmaku.bili.ui.deeplinkbutton.DeepLinkButtonView$$ExternalSyntheticLambda0
            public final void onThemeChanged() {
                DeepLinkButtonView.mThemeObserver$lambda$0(DeepLinkButtonView.this, context);
            }
        };
        initViews();
    }

    public /* synthetic */ DeepLinkButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mThemeObserver$lambda$0(DeepLinkButtonView this$0, Context $context) {
        ConstraintLayout constraintLayout = this$0.mContentView;
        Drawable $this$mThemeObserver_u24lambda_u240_u243 = null;
        if (constraintLayout != null) {
            Drawable $this$mThemeObserver_u24lambda_u240_u240 = $context.getDrawable(R.drawable.main_deeplink_button_bg);
            if ($this$mThemeObserver_u24lambda_u240_u240 != null) {
                $this$mThemeObserver_u24lambda_u240_u240.setTint($context.getColor(com.bilibili.lib.theme.R.color.Ga11));
            } else {
                $this$mThemeObserver_u24lambda_u240_u240 = null;
            }
            constraintLayout.setBackgroundDrawable($this$mThemeObserver_u24lambda_u240_u240);
        }
        TextView textView = this$0.mTitleView;
        if (textView != null) {
            textView.setTextColor($context.getColor(com.bilibili.lib.theme.R.color.main_Ga10));
        }
        TintImageView tintImageView = this$0.mArrowView;
        if (tintImageView != null) {
            Drawable $this$mThemeObserver_u24lambda_u240_u241 = $context.getDrawable(com.bilibili.app.comm.baseres.R.drawable.icon_br_arrow);
            if ($this$mThemeObserver_u24lambda_u240_u241 != null) {
                $this$mThemeObserver_u24lambda_u240_u241.setTint($context.getColor(com.bilibili.lib.theme.R.color.main_Ga7));
            } else {
                $this$mThemeObserver_u24lambda_u240_u241 = null;
            }
            tintImageView.setImageDrawable($this$mThemeObserver_u24lambda_u240_u241);
        }
        FrameLayout frameLayout = this$0.mIconBgView;
        if (frameLayout != null) {
            Drawable $this$mThemeObserver_u24lambda_u240_u242 = $context.getDrawable(R.drawable.main_deeplink_button_icon_bg);
            if ($this$mThemeObserver_u24lambda_u240_u242 != null) {
                $this$mThemeObserver_u24lambda_u240_u242.setTint($context.getColor(com.bilibili.lib.theme.R.color.Ga1));
            } else {
                $this$mThemeObserver_u24lambda_u240_u242 = null;
            }
            frameLayout.setBackgroundDrawable($this$mThemeObserver_u24lambda_u240_u242);
        }
        TintImageView tintImageView2 = this$0.mCloseView;
        if (tintImageView2 != null) {
            Drawable drawable = $context.getDrawable(com.bilibili.app.comm.baseres.R.drawable.icon_close);
            if (drawable != null) {
                $this$mThemeObserver_u24lambda_u240_u243 = drawable;
                $this$mThemeObserver_u24lambda_u240_u243.setTint($context.getColor(com.bilibili.lib.theme.R.color.Ga7));
            }
            tintImageView2.setImageDrawable($this$mThemeObserver_u24lambda_u240_u243);
        }
    }

    private final void initViews() {
        View.inflate(getContext(), R.layout.bili_app_layout_app_deeplink_button, this);
        this.mContentView = findViewById(R.id.content_layout);
        this.mTitleView = (TextView) findViewById(R.id.title);
        this.mCloseView = findViewById(R.id.close);
        this.mArrowView = findViewById(R.id.back);
        this.mIconView = findViewById(R.id.icon);
        this.mIconBgView = (FrameLayout) findViewById(R.id.icon_bg);
        ConstraintLayout constraintLayout = this.mContentView;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(this);
        }
        TintImageView tintImageView = this.mCloseView;
        if (tintImageView != null) {
            tintImageView.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout2 = this.mContentView;
        if (constraintLayout2 != null) {
            constraintLayout2.setOnTouchListener(this);
        }
        this.mOriginalOrientation = getContext().getResources().getConfiguration().orientation;
        ThemeWatcher.getInstance().subscribe(this.mThemeObserver);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r0 == true) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setDeepLinkButtonInfo(DeepLinkButtonInfo buttonInfo, IDeepLinkViewListen clickListen) {
        boolean z;
        CharSequence text;
        TextView textView;
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        this.mDeepLinkButtonInfo = buttonInfo;
        this.mListen = clickListen;
        if (!TextUtils.isEmpty(buttonInfo.getBackName()) && (textView = this.mTitleView) != null) {
            textView.setText(buttonInfo.getBackName());
        }
        TintImageView tintImageView = this.mCloseView;
        if (tintImageView != null) {
            tintImageView.setVisibility(buttonInfo.isNoCloseIcon() ? 8 : 0);
        }
        TextView textView2 = this.mTitleView;
        if (textView2 != null && (text = textView2.getText()) != null) {
            String string = getContext().getString(R.string.bili_deeplink_button_icon_show);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            boolean contains$default = StringsKt.contains$default(text, string, false, 2, (Object) null);
            z = true;
        }
        z = false;
        if (z) {
            BiliImageView $this$setDeepLinkButtonInfo_u24lambda_u240 = this.mIconView;
            if ($this$setDeepLinkButtonInfo_u24lambda_u240 != null) {
                $this$setDeepLinkButtonInfo_u24lambda_u240.setImageResource(com.bilibili.app.comm.baseres.R.drawable.ic_baidu);
                $this$setDeepLinkButtonInfo_u24lambda_u240.setVisibility(0);
            }
            FrameLayout frameLayout = this.mIconBgView;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }
        ConstraintLayout constraintLayout = this.mContentView;
        ViewGroup.LayoutParams layoutParams = constraintLayout != null ? constraintLayout.getLayoutParams() : null;
        if (buttonInfo.getBtnSize() == 2) {
            if (layoutParams != null) {
                ViewGroup.LayoutParams it = layoutParams;
                it.height = DisplayUtils.dp2Px(40);
                ConstraintLayout constraintLayout2 = this.mContentView;
                if (constraintLayout2 != null) {
                    constraintLayout2.setLayoutParams(it);
                }
            }
            TintImageView tintImageView2 = this.mArrowView;
            ViewGroup.LayoutParams layoutParams2 = tintImageView2 != null ? tintImageView2.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams arrowViewMargin = (ViewGroup.MarginLayoutParams) layoutParams2;
            MarginLayoutParamsCompat.setMarginStart(arrowViewMargin, DisplayUtils.dp2Px(12));
            TintImageView tintImageView3 = this.mCloseView;
            ViewGroup.LayoutParams layoutParams3 = tintImageView3 != null ? tintImageView3.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams closeViewMargin = (ViewGroup.MarginLayoutParams) layoutParams3;
            MarginLayoutParamsCompat.setMarginEnd(closeViewMargin, DisplayUtils.dp2Px(6));
            TextView textView3 = this.mTitleView;
            ViewGroup.LayoutParams layoutParams4 = textView3 != null ? textView3.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams titleViewMargin = (ViewGroup.MarginLayoutParams) layoutParams4;
            MarginLayoutParamsCompat.setMarginEnd(titleViewMargin, DisplayUtils.dp2Px(14));
        } else if (layoutParams != null) {
            ViewGroup.LayoutParams it2 = layoutParams;
            it2.height = DisplayUtils.dp2Px(30);
            ConstraintLayout constraintLayout3 = this.mContentView;
            if (constraintLayout3 != null) {
                constraintLayout3.setLayoutParams(it2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IDeepLinkViewListen iDeepLinkViewListen;
        String it;
        IDeepLinkViewListen iDeepLinkViewListen2;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id == R.id.content_layout) {
            DeepLinkButtonInfo deepLinkButtonInfo = this.mDeepLinkButtonInfo;
            if (deepLinkButtonInfo == null || (it = deepLinkButtonInfo.getBackUrl()) == null || (iDeepLinkViewListen2 = this.mListen) == null) {
                return;
            }
            iDeepLinkViewListen2.onClickJump(it);
        } else if (id != R.id.close || (iDeepLinkViewListen = this.mListen) == null) {
        } else {
            iDeepLinkViewListen.onClickClose();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        switch (motionEvent.getAction()) {
            case 0:
                this.mIsMove = false;
                this.mLastY = motionEvent.getRawY();
                return false;
            case 1:
                if (this.mIsMove) {
                    IDeepLinkViewListen iDeepLinkViewListen = this.mListen;
                    if (iDeepLinkViewListen != null) {
                        iDeepLinkViewListen.onDistanceChange();
                    }
                    return true;
                }
                break;
            case 2:
                float moveY = motionEvent.getRawY() - this.mLastY;
                if (!(moveY == 0.0f)) {
                    this.mIsMove = true;
                    IDeepLinkViewListen iDeepLinkViewListen2 = this.mListen;
                    if (iDeepLinkViewListen2 != null) {
                        iDeepLinkViewListen2.onTouchEvent((int) moveY);
                    }
                } else {
                    this.mIsMove = false;
                }
                this.mLastY = motionEvent.getRawY();
                return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        IDeepLinkViewListen iDeepLinkViewListen = this.mListen;
        if (iDeepLinkViewListen != null) {
            iDeepLinkViewListen.onPortLandChange(newConfig.orientation);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        IDeepLinkViewListen iDeepLinkViewListen;
        super.onAttachedToWindow();
        if (this.mOriginalOrientation == getContext().getResources().getConfiguration().orientation || (iDeepLinkViewListen = this.mListen) == null) {
            return;
        }
        iDeepLinkViewListen.onPortLandChange(getContext().getResources().getConfiguration().orientation);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThemeWatcher.getInstance().unSubscribe(this.mThemeObserver);
    }
}