package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayer.baseres.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VerifyAvatarWithTopLabel.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0014J0\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0014J\u0006\u0010\u001d\u001a\u00020\rJ\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0012J\u000e\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u00122\b\b\u0001\u0010+\u001a\u00020\nJ\u000e\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\nJ\u0010\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\nH\u0004R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithTopLabel;", "Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarFrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTvLabel", "Ltv/danmaku/bili/videopage/common/widget/view/FlashTextView;", "mAvatarOverLayerView", "Landroid/view/View;", "mAvatarImgTopOffset", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", "getTopLabelView", "setLabel", "label", "", "showTopLabelFlashDelay", "delayTime", "", "hideTopLabelFlash", "setTopLabelBackgroundRes", "res", "setTopLabelBackground", "bg", "Landroid/graphics/drawable/Drawable;", "setTopLabelTextColorRes", "id", "setTopLabelTextColor", "color", "setAvatarTopOffset", "offset", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class VerifyAvatarWithTopLabel extends VerifyAvatarFrameLayout {
    public static final Companion Companion = new Companion(null);
    private int mAvatarImgTopOffset;
    private View mAvatarOverLayerView;
    private FlashTextView mTvLabel;

    public VerifyAvatarWithTopLabel(Context context) {
        this(context, null);
    }

    public VerifyAvatarWithTopLabel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyAvatarWithTopLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private final void init(Context context, AttributeSet attrs) {
        FlashTextView flashTextView;
        Drawable background = null;
        int labelColor = -1;
        int avatarWidth = 0;
        int avatarHeight = 0;
        boolean labelEnable = true;
        float labelTextSize = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        if (attrs != null) {
            Intrinsics.checkNotNull(context);
            TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.VerifyAvatarWithTopLabel);
            Intrinsics.checkNotNullExpressionValue(arr, "obtainStyledAttributes(...)");
            background = arr.getDrawable(R.styleable.VerifyAvatarWithTopLabel_topLabelBackground);
            labelTextSize = arr.getDimension(R.styleable.VerifyAvatarWithTopLabel_topLabelTextSize, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            labelColor = arr.getColor(R.styleable.VerifyAvatarWithTopLabel_topLabelColor, ThemeUtils.getColorById(context, com.bilibili.lib.theme.R.color.Wh0_u));
            avatarHeight = (int) arr.getDimension(R.styleable.VerifyAvatarWithTopLabel_avatar_height, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            avatarWidth = (int) arr.getDimension(R.styleable.VerifyAvatarWithTopLabel_avatar_width, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            labelEnable = arr.getBoolean(R.styleable.VerifyAvatarWithTopLabel_enableTopLabel, true);
            arr.recycle();
        }
        this.mAvatarOverLayerView = new VerifyAvatarOverLayerView(context);
        FrameLayout.LayoutParams overlayLp = new FrameLayout.LayoutParams(-2, -2);
        Intrinsics.checkNotNull(context);
        this.mTvLabel = new FlashTextView(context);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        FlashTextView flashTextView2 = this.mTvLabel;
        if (flashTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView2 = null;
        }
        flashTextView2.setBackground(background);
        FlashTextView flashTextView3 = this.mTvLabel;
        if (flashTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView3 = null;
        }
        flashTextView3.setTextColor(labelColor);
        FlashTextView flashTextView4 = this.mTvLabel;
        if (flashTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView4 = null;
        }
        flashTextView4.setGravity(17);
        FlashTextView flashTextView5 = this.mTvLabel;
        if (flashTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView5 = null;
        }
        flashTextView5.setMaxLines(1);
        FlashTextView flashTextView6 = this.mTvLabel;
        if (flashTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView6 = null;
        }
        flashTextView6.setPadding(VerifyAvatarWithTopLabelKt.access$getLABEL_LEFT_AND_RIGHT_PADDING$p(), 0, VerifyAvatarWithTopLabelKt.access$getLABEL_LEFT_AND_RIGHT_PADDING$p(), 0);
        if (labelTextSize <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            FlashTextView flashTextView7 = this.mTvLabel;
            if (flashTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView7 = null;
            }
            flashTextView7.setTextSize(10.0f);
        } else {
            FlashTextView flashTextView8 = this.mTvLabel;
            if (flashTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView8 = null;
            }
            flashTextView8.setTextSize(0, labelTextSize);
        }
        FlashTextView flashTextView9 = this.mTvLabel;
        if (flashTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView9 = null;
        }
        flashTextView9.setFlashColor(ContextCompat.getColor(context, R.color.Wh0_u_alpha40));
        FlashTextView flashTextView10 = this.mTvLabel;
        if (flashTextView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView10 = null;
        }
        flashTextView10.setFlashWidth(DisplayUtils.dp2Px(10));
        if (labelEnable) {
            FlashTextView flashTextView11 = this.mTvLabel;
            if (flashTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView11 = null;
            }
            flashTextView11.setVisibility(0);
        } else {
            FlashTextView flashTextView12 = this.mTvLabel;
            if (flashTextView12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView12 = null;
            }
            flashTextView12.setVisibility(8);
        }
        View view2 = this.mAvatarOverLayerView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarOverLayerView");
            view2 = null;
        }
        addView(view2, overlayLp);
        FlashTextView flashTextView13 = this.mTvLabel;
        if (flashTextView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView = null;
        } else {
            flashTextView = flashTextView13;
        }
        addView((View) flashTextView, lp);
        ViewGroup.LayoutParams alp = this.mAvatarImg.getLayoutParams();
        if (avatarHeight > 0) {
            alp.height = avatarHeight;
            overlayLp.height = avatarHeight;
        }
        if (avatarWidth > 0) {
            alp.width = avatarWidth;
            overlayLp.width = avatarWidth;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int maxHeight;
        int maxWidth;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        FlashTextView flashTextView = this.mTvLabel;
        FlashTextView flashTextView2 = null;
        if (flashTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView = null;
        }
        if (flashTextView.getMeasuredHeight() + getPaddingTop() + getPaddingBottom() > height) {
            FlashTextView flashTextView3 = this.mTvLabel;
            if (flashTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            } else {
                flashTextView2 = flashTextView3;
            }
            height = flashTextView2.getMeasuredHeight() + getPaddingTop() + getPaddingBottom();
        }
        if (View.MeasureSpec.getMode(widthMeasureSpec) == Integer.MIN_VALUE && width > (maxWidth = View.MeasureSpec.getSize(widthMeasureSpec))) {
            width = maxWidth;
        }
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE && height > (maxHeight = View.MeasureSpec.getSize(heightMeasureSpec))) {
            height = maxHeight;
        }
        super.setMeasuredDimension(width, height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mAvatarImg.setTop(Math.max(0, (((bottom - top) - this.mAvatarImg.getMeasuredHeight()) / 2) + this.mAvatarImgTopOffset));
        this.mAvatarImg.setBottom(this.mAvatarImg.getTop() + this.mAvatarImg.getMeasuredHeight());
        this.mAvatarImg.setLeft(((right - left) - this.mAvatarImg.getMeasuredWidth()) / 2);
        this.mAvatarImg.setRight(this.mAvatarImg.getLeft() + this.mAvatarImg.getMeasuredWidth());
        View view2 = this.mAvatarOverLayerView;
        FlashTextView flashTextView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarOverLayerView");
            view2 = null;
        }
        view2.setLeft(this.mAvatarImg.getLeft());
        View view3 = this.mAvatarOverLayerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarOverLayerView");
            view3 = null;
        }
        view3.setTop(this.mAvatarImg.getTop());
        View view4 = this.mAvatarOverLayerView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarOverLayerView");
            view4 = null;
        }
        view4.setRight(this.mAvatarImg.getRight());
        View view5 = this.mAvatarOverLayerView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatarOverLayerView");
            view5 = null;
        }
        view5.setBottom(this.mAvatarImg.getBottom());
        FlashTextView flashTextView2 = this.mTvLabel;
        if (flashTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView2 = null;
        }
        if (flashTextView2.getVisibility() != 8) {
            FlashTextView flashTextView3 = this.mTvLabel;
            if (flashTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView3 = null;
            }
            flashTextView3.setTop(this.mAvatarImg.getTop());
            FlashTextView flashTextView4 = this.mTvLabel;
            if (flashTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView4 = null;
            }
            flashTextView4.setLeft((this.mAvatarImg.getWidth() / 2) + this.mAvatarImg.getLeft());
            FlashTextView flashTextView5 = this.mTvLabel;
            if (flashTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView5 = null;
            }
            FlashTextView flashTextView6 = this.mTvLabel;
            if (flashTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView6 = null;
            }
            int measuredWidth = flashTextView6.getMeasuredWidth();
            FlashTextView flashTextView7 = this.mTvLabel;
            if (flashTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView7 = null;
            }
            flashTextView5.setRight(measuredWidth + flashTextView7.getLeft());
            FlashTextView flashTextView8 = this.mTvLabel;
            if (flashTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView8 = null;
            }
            FlashTextView flashTextView9 = this.mTvLabel;
            if (flashTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView9 = null;
            }
            int measuredHeight = flashTextView9.getMeasuredHeight();
            FlashTextView flashTextView10 = this.mTvLabel;
            if (flashTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView10 = null;
            }
            flashTextView8.setBottom(measuredHeight + flashTextView10.getTop());
            FlashTextView flashTextView11 = this.mTvLabel;
            if (flashTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView11 = null;
            }
            int overflow = flashTextView11.getRight() - (right - left);
            if (overflow > 0) {
                FlashTextView flashTextView12 = this.mTvLabel;
                if (flashTextView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                    flashTextView12 = null;
                }
                flashTextView12.setLeft(flashTextView12.getLeft() - overflow);
                FlashTextView flashTextView13 = this.mTvLabel;
                if (flashTextView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                } else {
                    flashTextView = flashTextView13;
                }
                flashTextView.setRight(flashTextView.getRight() - overflow);
            }
        }
        if (this.mVerifyImg.getVisibility() != 8) {
            this.mVerifyImg.setLeft(((this.mAvatarImg.getWidth() - this.mAvatarImg.getPaddingRight()) - this.mVerifyImg.getMeasuredWidth()) + this.mAvatarImg.getLeft());
            this.mVerifyImg.setTop(((this.mAvatarImg.getHeight() - this.mAvatarImg.getPaddingBottom()) - this.mVerifyImg.getMeasuredHeight()) + this.mAvatarImg.getTop());
            this.mVerifyImg.setRight(this.mVerifyImg.getLeft() + this.mVerifyImg.getMeasuredWidth());
            this.mVerifyImg.setBottom(this.mVerifyImg.getTop() + this.mVerifyImg.getMeasuredHeight());
        }
    }

    public final FlashTextView getTopLabelView() {
        FlashTextView flashTextView = this.mTvLabel;
        if (flashTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            return null;
        }
        return flashTextView;
    }

    public final void setLabel(String label) {
        Companion companion = Companion;
        FlashTextView flashTextView = this.mTvLabel;
        if (flashTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView = null;
        }
        companion.setFlashLabel(flashTextView, label);
    }

    public final void showTopLabelFlashDelay(long delayTime) {
        FlashTextView flashTextView = this.mTvLabel;
        if (flashTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView = null;
        }
        flashTextView.playFlashDelay(delayTime);
    }

    public final void hideTopLabelFlash() {
        FlashTextView flashTextView = this.mTvLabel;
        if (flashTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
            flashTextView = null;
        }
        flashTextView.stopPlayFlash();
    }

    public final void setTopLabelBackgroundRes(int res) {
        if (this.mTvLabel != null) {
            FlashTextView flashTextView = this.mTvLabel;
            if (flashTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView = null;
            }
            flashTextView.setBackgroundResource(res);
        }
    }

    public final void setTopLabelBackground(Drawable bg) {
        Intrinsics.checkNotNullParameter(bg, "bg");
        if (this.mTvLabel != null) {
            FlashTextView flashTextView = this.mTvLabel;
            if (flashTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView = null;
            }
            flashTextView.setBackground(bg);
        }
    }

    public final void setTopLabelTextColorRes(int id) {
        if (this.mTvLabel != null) {
            FlashTextView flashTextView = this.mTvLabel;
            if (flashTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView = null;
            }
            flashTextView.setTextColor(ContextCompat.getColor(getContext(), id));
        }
    }

    public final void setTopLabelTextColor(int color) {
        if (this.mTvLabel != null) {
            FlashTextView flashTextView = this.mTvLabel;
            if (flashTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvLabel");
                flashTextView = null;
            }
            flashTextView.setTextColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setAvatarTopOffset(int offset) {
        this.mAvatarImgTopOffset = offset;
    }

    /* compiled from: VerifyAvatarWithTopLabel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithTopLabel$Companion;", "", "<init>", "()V", "setFlashLabel", "", "label", "Ltv/danmaku/bili/videopage/common/widget/view/FlashTextView;", "text", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setFlashLabel(FlashTextView label, String text) {
            Intrinsics.checkNotNullParameter(label, "label");
            if (TextUtils.isEmpty(text)) {
                if (label.getVisibility() != 8) {
                    label.setVisibility(8);
                    return;
                }
                return;
            }
            if (label.getVisibility() != 0) {
                label.setVisibility(0);
            }
            String l = text;
            if (l != null && l.length() > 15 && text != null) {
                String substring = text.substring(0, 14);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                l = substring + "...";
            }
            if (!Intrinsics.areEqual(label.getText(), l)) {
                label.setText(l);
            }
        }
    }

    @JvmStatic
    public static final void setFlashLabel(FlashTextView label, String text) {
        Companion.setFlashLabel(label, text);
    }
}