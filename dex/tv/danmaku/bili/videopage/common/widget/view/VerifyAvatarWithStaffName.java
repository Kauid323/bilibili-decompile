package tv.danmaku.bili.videopage.common.widget.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bilibili.droid.TalkbackUtilsKt;
import com.bilibili.lib.theme.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VerifyAvatarWithStaffName.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0014J0\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0014J\"\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00182\b\b\u0001\u0010!\u001a\u00020\nJ\u0006\u0010\"\u001a\u00020#R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithStaffName;", "Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithFollow;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTvStaffName", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "STAFF_NAME_PADDING_TOP", "STAFF_NAME_PADDING_LEFT_RIGHT", "AVATAR_TOP_OFFSET", "init", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "left", "top", "right", "bottom", "setStaffName", "name", "", "isYearVip", "nameColor", "getStaffNameView", "Landroid/view/View;", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VerifyAvatarWithStaffName extends VerifyAvatarWithFollow {
    public static final Companion Companion = new Companion(null);
    private final int AVATAR_TOP_OFFSET;
    private final int STAFF_NAME_PADDING_LEFT_RIGHT;
    private final int STAFF_NAME_PADDING_TOP;
    private TintTextView mTvStaffName;

    public VerifyAvatarWithStaffName(Context context) {
        this(context, null);
    }

    public VerifyAvatarWithStaffName(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerifyAvatarWithStaffName(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.STAFF_NAME_PADDING_TOP = DisplayUtils.dp2Px(2);
        this.STAFF_NAME_PADDING_LEFT_RIGHT = DisplayUtils.dp2Px(5);
        this.AVATAR_TOP_OFFSET = DisplayUtils.dp2Px(6);
        init(context, attrs);
    }

    private final void init(Context context, AttributeSet attrs) {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(-2, -2);
        this.mTvStaffName = new TintTextView(context);
        TintTextView tintTextView = this.mTvStaffName;
        TintTextView tintTextView2 = null;
        if (tintTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView = null;
        }
        tintTextView.setPadding(this.STAFF_NAME_PADDING_LEFT_RIGHT, 0, this.STAFF_NAME_PADDING_LEFT_RIGHT, 0);
        TintTextView tintTextView3 = this.mTvStaffName;
        if (tintTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView3 = null;
        }
        tintTextView3.setTextSize(2, 10.0f);
        TintTextView tintTextView4 = this.mTvStaffName;
        if (tintTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView4 = null;
        }
        tintTextView4.setTextColor(ThemeUtils.getColorById(context, R.color.Ga5));
        TintTextView tintTextView5 = this.mTvStaffName;
        if (tintTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView5 = null;
        }
        tintTextView5.setGravity(17);
        TintTextView tintTextView6 = this.mTvStaffName;
        if (tintTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView6 = null;
        }
        tintTextView6.setMaxLines(1);
        TintTextView tintTextView7 = this.mTvStaffName;
        if (tintTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView7 = null;
        }
        tintTextView7.setEllipsize(TextUtils.TruncateAt.END);
        TintTextView tintTextView8 = this.mTvStaffName;
        if (tintTextView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView8 = null;
        }
        TalkbackUtilsKt.setViewNotImportantForAccessibility((View) tintTextView8);
        TintTextView tintTextView9 = this.mTvStaffName;
        if (tintTextView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
        } else {
            tintTextView2 = tintTextView9;
        }
        addView((View) tintTextView2, lp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.videopage.common.widget.view.VerifyAvatarWithTopLabel, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setAvatarTopOffset(-this.AVATAR_TOP_OFFSET);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.videopage.common.widget.view.VerifyAvatarWithFollow, tv.danmaku.bili.videopage.common.widget.view.VerifyAvatarWithTopLabel, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        TintTextView tintTextView = this.mTvStaffName;
        TintTextView tintTextView2 = null;
        if (tintTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView = null;
        }
        if (tintTextView.getVisibility() != 8) {
            TintTextView tintTextView3 = this.mTvStaffName;
            if (tintTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView3 = null;
            }
            int i = right - left;
            TintTextView tintTextView4 = this.mTvStaffName;
            if (tintTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView4 = null;
            }
            tintTextView3.setLeft(Math.max(0, i - tintTextView4.getMeasuredWidth()) / 2);
            TintTextView tintTextView5 = this.mTvStaffName;
            if (tintTextView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView5 = null;
            }
            tintTextView5.setTop(this.mAvatarImg.getBottom() + this.STAFF_NAME_PADDING_TOP);
            TintTextView tintTextView6 = this.mTvStaffName;
            if (tintTextView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView6 = null;
            }
            TintTextView tintTextView7 = this.mTvStaffName;
            if (tintTextView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView7 = null;
            }
            int left2 = tintTextView7.getLeft();
            TintTextView tintTextView8 = this.mTvStaffName;
            if (tintTextView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView8 = null;
            }
            tintTextView6.setRight(left2 + tintTextView8.getMeasuredWidth());
            TintTextView tintTextView9 = this.mTvStaffName;
            if (tintTextView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView9 = null;
            }
            TintTextView tintTextView10 = this.mTvStaffName;
            if (tintTextView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
                tintTextView10 = null;
            }
            int top2 = tintTextView10.getTop();
            TintTextView tintTextView11 = this.mTvStaffName;
            if (tintTextView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            } else {
                tintTextView2 = tintTextView11;
            }
            tintTextView9.setBottom(top2 + tintTextView2.getMeasuredHeight());
        }
    }

    public final void setStaffName(String name, boolean isYearVip, int nameColor) {
        Companion companion = Companion;
        TintTextView tintTextView = this.mTvStaffName;
        if (tintTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView = null;
        }
        companion.setStaffName(tintTextView, name, isYearVip, nameColor);
        TalkbackUtilsKt.setViewContentDescription(this, "up主" + name);
    }

    public final View getStaffNameView() {
        TintTextView tintTextView = this.mTvStaffName;
        if (tintTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvStaffName");
            tintTextView = null;
        }
        return (View) tintTextView;
    }

    /* compiled from: VerifyAvatarWithStaffName.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH\u0007¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/videopage/common/widget/view/VerifyAvatarWithStaffName$Companion;", "", "<init>", "()V", "setStaffName", "", "staff", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "name", "", "isYearVip", "", "nameColor", "", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setStaffName(TintTextView staff, String name, boolean isYearVip, int nameColor) {
            int i;
            Intrinsics.checkNotNullParameter(staff, "staff");
            staff.setText(name != null ? name : "");
            if (nameColor != 0) {
                staff.setTextColor(nameColor);
                return;
            }
            Context context = staff.getContext();
            if (isYearVip) {
                i = com.bilibili.app.comm.baseres.R.color.pink;
            } else {
                i = R.color.Ga5;
            }
            staff.setTextColor(ContextCompat.getColor(context, i));
        }
    }

    @JvmStatic
    public static final void setStaffName(TintTextView staff, String name, boolean isYearVip, int nameColor) {
        Companion.setStaffName(staff, name, isYearVip, nameColor);
    }
}