package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.bilibili.droid.TalkbackUtilsKt;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.magicasakura.widgets.TintTextView;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.videopage.common.helper.DisplayUtils;
import tv.danmaku.bili.widget.ExpandableTagFlowLayout;
import tv.danmaku.bili.widget.FlowLayout;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ExpandableTagFlowLayout.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 W2\u00020\u0001:\u0003UVWB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0014J0\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u00101\u001a\u00020%H\u0002J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0018\u00105\u001a\u00020%2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J(\u00106\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J(\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\u0016\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000fJ\u000e\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0007J\u0006\u0010D\u001a\u00020%J\u0006\u0010E\u001a\u00020%J\b\u0010F\u001a\u00020%H\u0002J\b\u0010G\u001a\u00020%H\u0002J\u0018\u0010H\u001a\u00020%2\b\u0010I\u001a\u0004\u0018\u00010\u00182\u0006\u0010J\u001a\u00020\u000fJ\u0018\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0002J\u0010\u0010N\u001a\u00020%2\u0006\u0010O\u001a\u00020PH\u0016J\n\u0010Q\u001a\u0004\u0018\u00010PH\u0016J\u000e\u0010R\u001a\u00020%2\u0006\u0010S\u001a\u00020\u000fJ\u000e\u0010T\u001a\u00020%2\u0006\u0010+\u001a\u00020\u001aR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Ltv/danmaku/bili/widget/ExpandableTagFlowLayout;", "Ltv/danmaku/bili/widget/FlowLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mExpandIv", "Landroid/widget/ImageView;", "mExpandHint", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "mEnableExpand", "", "mEnableExpandHint", "mHintCount", "mTagChanged", "mIsExpanded", "mCollapseLines", "mExpandLines", "mTouchSpread", "mAdapter", "Landroid/widget/BaseAdapter;", "mTagSelectedListener", "Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$OnTagSelectedListener;", "mSelectedTagView", "Landroid/view/View;", "mSelectable", "mOnLongSelectEnabled", "mTagClick", "Landroid/view/View$OnClickListener;", "mTagLongClick", "Landroid/view/View$OnLongClickListener;", "mActionClickListener", "initActionView", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onLayout", "changed", "l", "t", "r", "b", "revertVisible", "view", "expandActionViewDelegate", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "measureWithExpand", "preMeasure", "controlMaxLength", "modeLength", "measureItem", "child", "lp", "Ltv/danmaku/bili/widget/FlowLayout$LayoutParams;", "setEnableExpand", "enable", "enableHint", "setCollapseLines", "collapseLines", "setExpandLines", "expandLines", "expand", "collapse", "invalidateInner", "invalidateExpandIcon", "setAdapter", "adapter", "forceNotify", "removeLinesInLayout", "start", "count", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "setTagSelectable", "selectable", "setOnTagSelectedListener", "SavedState", "OnTagSelectedListener", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ExpandableTagFlowLayout extends FlowLayout {
    private static final int COLLAPSE_LINE_DEFAULT = 1;
    public static final Companion Companion = new Companion(null);
    private static final int EXPAND_LINE_DEFAULT = Integer.MAX_VALUE;
    private static final int KEY_POS = 1593835520;
    private static final String TAG = "ExpandableFlowLayout";
    private final View.OnClickListener mActionClickListener;
    private BaseAdapter mAdapter;
    private int mCollapseLines;
    private boolean mEnableExpand;
    private boolean mEnableExpandHint;
    private TintTextView mExpandHint;
    private ImageView mExpandIv;
    private int mExpandLines;
    private int mHintCount;
    private boolean mIsExpanded;
    private boolean mOnLongSelectEnabled;
    private boolean mSelectable;
    private View mSelectedTagView;
    private boolean mTagChanged;
    private final View.OnClickListener mTagClick;
    private final View.OnLongClickListener mTagLongClick;
    private OnTagSelectedListener mTagSelectedListener;
    private int mTouchSpread;

    /* compiled from: ExpandableTagFlowLayout.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$OnTagSelectedListener;", "", "onMoreClick", "", "onSelect", "view", "Ltv/danmaku/bili/widget/ExpandableTagFlowLayout;", "selectedView", "Landroid/view/View;", "positionInAdapter", "", "onLongSelect", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnTagSelectedListener {
        void onLongSelect(ExpandableTagFlowLayout expandableTagFlowLayout, View view2, int i);

        void onMoreClick();

        void onSelect(ExpandableTagFlowLayout expandableTagFlowLayout, View view2, int i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableTagFlowLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableTagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTagFlowLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCollapseLines = 1;
        this.mExpandLines = Integer.MAX_VALUE;
        this.mSelectable = true;
        this.mOnLongSelectEnabled = true;
        this.mTagClick = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.ExpandableTagFlowLayout$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExpandableTagFlowLayout.mTagClick$lambda$0(ExpandableTagFlowLayout.this, view2);
            }
        };
        this.mTagLongClick = new View.OnLongClickListener() { // from class: tv.danmaku.bili.widget.ExpandableTagFlowLayout$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean mTagLongClick$lambda$0;
                mTagLongClick$lambda$0 = ExpandableTagFlowLayout.mTagLongClick$lambda$0(ExpandableTagFlowLayout.this, view2);
                return mTagLongClick$lambda$0;
            }
        };
        this.mActionClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.ExpandableTagFlowLayout$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ExpandableTagFlowLayout.mActionClickListener$lambda$0(ExpandableTagFlowLayout.this, view2);
            }
        };
        setGravity(119);
        setWeightDefault(1.0f);
        initActionView();
        this.mTouchSpread = DisplayUtils.dp2Px(8.0f);
    }

    public /* synthetic */ ExpandableTagFlowLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mTagClick$lambda$0(ExpandableTagFlowLayout this$0, View v) {
        Object tag = v.getTag(KEY_POS);
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num == null) {
            return;
        }
        int pos = num.intValue();
        View view2 = this$0.mSelectedTagView;
        if (view2 != null) {
            view2.setSelected(false);
        }
        if (this$0.mSelectable) {
            v.setSelected(true);
            this$0.mSelectedTagView = v;
        } else {
            this$0.mSelectedTagView = null;
        }
        OnTagSelectedListener onTagSelectedListener = this$0.mTagSelectedListener;
        if (onTagSelectedListener != null) {
            Intrinsics.checkNotNull(v);
            onTagSelectedListener.onSelect(this$0, v, pos);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean mTagLongClick$lambda$0(ExpandableTagFlowLayout this$0, View v) {
        Object tag = v.getTag(KEY_POS);
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            int pos = num.intValue();
            if (this$0.mTagSelectedListener != null) {
                OnTagSelectedListener onTagSelectedListener = this$0.mTagSelectedListener;
                if (onTagSelectedListener != null) {
                    Intrinsics.checkNotNull(v);
                    onTagSelectedListener.onLongSelect(this$0, v, pos);
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mActionClickListener$lambda$0(ExpandableTagFlowLayout this$0, View it) {
        this$0.mIsExpanded = !this$0.mIsExpanded;
        this$0.invalidateInner();
        OnTagSelectedListener onTagSelectedListener = this$0.mTagSelectedListener;
        if (onTagSelectedListener != null) {
            onTagSelectedListener.onMoreClick();
        }
    }

    private final void initActionView() {
        if (this.mEnableExpand) {
            if (this.mExpandIv != null && indexOfChild(this.mExpandIv) < 0) {
                this.mExpandIv = null;
            }
            if (this.mExpandHint != null && indexOfChild((View) this.mExpandHint) < 1) {
                this.mExpandHint = null;
            }
            if (this.mExpandIv == null) {
                ImageView $this$initActionView_u24lambda_u240 = new ImageView(getContext());
                invalidateExpandIcon();
                $this$initActionView_u24lambda_u240.setClickable(true);
                int spacing = DisplayUtils.dp2Px(2.0f);
                $this$initActionView_u24lambda_u240.setPadding(0, 0, spacing, 0);
                $this$initActionView_u24lambda_u240.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                FlowLayout.LayoutParams params = generateDefaultLayoutParams();
                params.weight = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                addViewInLayout($this$initActionView_u24lambda_u240, 0, params, true);
                $this$initActionView_u24lambda_u240.setOnClickListener(this.mActionClickListener);
                BLog.d(TAG, "new action view");
                this.mExpandIv = $this$initActionView_u24lambda_u240;
            }
            if (this.mExpandHint == null) {
                TintTextView $this$initActionView_u24lambda_u241 = new TintTextView(getContext());
                $this$initActionView_u24lambda_u241.setTextSize(12.0f);
                $this$initActionView_u24lambda_u241.setTextColor(ContextCompat.getColor($this$initActionView_u24lambda_u241.getContext(), com.bilibili.lib.theme.R.color.Ga5));
                FlowLayout.LayoutParams params2 = generateDefaultLayoutParams();
                int leftPadding = DisplayUtils.dp2Px(12.0f);
                int rightPadding = DisplayUtils.dp2Px(4.0f);
                $this$initActionView_u24lambda_u241.setPadding(leftPadding, 0, rightPadding, 0);
                String hint = $this$initActionView_u24lambda_u241.getResources().getQuantityString(bili.resource.playerbaseres.R.plurals.playerbaseres_global_string_2348, this.mHintCount, Integer.valueOf(this.mHintCount));
                Intrinsics.checkNotNullExpressionValue(hint, "getQuantityString(...)");
                $this$initActionView_u24lambda_u241.setText(hint);
                TalkbackUtilsKt.setViewContentDescription(this.mExpandIv, "展开" + hint + "标签");
                $this$initActionView_u24lambda_u241.setClickable(false);
                $this$initActionView_u24lambda_u241.setVisibility(8);
                addViewInLayout((View) $this$initActionView_u24lambda_u241, -1, params2, false);
                this.mExpandHint = $this$initActionView_u24lambda_u241;
                return;
            }
            return;
        }
        if (this.mExpandIv != null) {
            removeViewInLayout(this.mExpandIv);
            ImageView imageView = this.mExpandIv;
            if (imageView != null) {
                imageView.setOnClickListener(null);
            }
            this.mExpandIv = null;
            BLog.d(TAG, "release action view");
        }
        if (this.mExpandHint != null) {
            removeViewInLayout((View) this.mExpandHint);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        invalidateInner();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        boolean isLayout;
        boolean isLayout2 = false;
        int i = 0;
        int size = this.lines.size();
        while (true) {
            int i2 = 1;
            if (i >= size) {
                break;
            }
            FlowLayout.LineDefinition line = this.lines.get(i);
            int j = 0;
            int i3 = line.viewCount;
            while (j < i3) {
                TintTextView tintTextView = line.views[j];
                if (tintTextView == null) {
                    isLayout = isLayout2;
                } else {
                    ViewGroup.LayoutParams layoutParams = tintTextView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                    FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) layoutParams;
                    if (tintTextView != this.mExpandIv && tintTextView != this.mExpandHint) {
                        isLayout = isLayout2;
                    } else if ((this.mExpandHint != null || line.viewCount <= i2) && (this.mExpandHint == null || line.viewCount <= 2)) {
                        isLayout = isLayout2;
                    } else {
                        View preChild = line.views[j - 1];
                        if (this.mExpandIv == preChild && line.viewCount > 2) {
                            preChild = line.views[j - 2];
                        }
                        if (preChild != null) {
                            int diff = (preChild.getMeasuredHeight() - tintTextView.getMeasuredHeight()) / 2;
                            if (tintTextView == this.mExpandHint) {
                                int mExpandW = 0;
                                ImageView it = this.mExpandIv;
                                if (it != null) {
                                    ViewGroup.LayoutParams layoutParams2 = it.getLayoutParams();
                                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                                    FlowLayout.LayoutParams lpExpand = (FlowLayout.LayoutParams) layoutParams2;
                                    mExpandW = it.getMeasuredWidth() + lpExpand.leftMargin + lpExpand.rightMargin;
                                }
                                lp.x = ((getMeasuredWidth() - tintTextView.getMeasuredWidth()) - lp.leftMargin) - mExpandW;
                            }
                            tintTextView.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin + diff, lp.x + lp.leftMargin + tintTextView.getMeasuredWidth(), lp.y + lp.topMargin + tintTextView.getMeasuredHeight() + diff);
                        } else {
                            tintTextView.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + tintTextView.getMeasuredWidth(), lp.y + lp.topMargin + tintTextView.getMeasuredHeight());
                        }
                        isLayout2 = true;
                        j++;
                        i2 = 1;
                    }
                    tintTextView.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + tintTextView.getMeasuredWidth(), lp.y + lp.topMargin + tintTextView.getMeasuredHeight());
                }
                isLayout2 = isLayout;
                j++;
                i2 = 1;
            }
            i++;
        }
        TintTextView tintTextView2 = this.mExpandHint;
        if (tintTextView2 != null && tintTextView2.getVisibility() == 0) {
            int count = getChildCount();
            for (int i4 = 0; i4 < count; i4++) {
                TintTextView childAt = getChildAt(i4);
                if (childAt != this.mExpandHint && childAt != this.mExpandIv) {
                    revertVisible(childAt);
                }
            }
        }
        if (this.mExpandIv != null && isLayout2) {
            expandActionViewDelegate();
        }
    }

    private final void revertVisible(View view2) {
        if (view2 == null) {
            return;
        }
        if (getOrientation() == 0) {
            if (view2.getTop() + view2.getMeasuredHeight() > getMeasuredHeight()) {
                return;
            }
        } else if (view2.getLeft() + view2.getMeasuredWidth() > getMeasuredWidth()) {
            return;
        }
        boolean isShow = false;
        int size = this.lines.size();
        for (int i = 0; i < size; i++) {
            FlowLayout.LineDefinition line = this.lines.get(i);
            int j = 0;
            int i2 = line.viewCount;
            while (true) {
                if (j >= i2) {
                    break;
                }
                View child = line.views[j];
                if (child == null || view2 != child) {
                    j++;
                } else {
                    isShow = true;
                    break;
                }
            }
        }
        if (!isShow) {
            if (getOrientation() == 0) {
                view2.setTop(getMeasuredHeight());
            } else {
                view2.setLeft(getMeasuredWidth());
            }
        }
    }

    private final void expandActionViewDelegate() {
        ImageView imageView = this.mExpandIv;
        ViewParent parent = imageView != null ? imageView.getParent() : null;
        View view2 = parent instanceof View ? (View) parent : null;
        if (view2 == null) {
            return;
        }
        final View parentView = view2;
        ImageView imageView2 = this.mExpandIv;
        if (imageView2 != null) {
            imageView2.post(new Runnable() { // from class: tv.danmaku.bili.widget.ExpandableTagFlowLayout$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandableTagFlowLayout.expandActionViewDelegate$lambda$0(ExpandableTagFlowLayout.this, parentView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void expandActionViewDelegate$lambda$0(ExpandableTagFlowLayout this$0, View $parentView) {
        Rect bounds = new Rect();
        ImageView it = this$0.mExpandIv;
        if (it != null) {
            bounds.left = it.getLeft() - this$0.mTouchSpread;
            bounds.top = it.getTop() - this$0.mTouchSpread;
            bounds.right = it.getRight() + this$0.mTouchSpread;
            bounds.bottom = it.getBottom() + this$0.mTouchSpread;
            bounds.left = it.getLeft() - (bounds.right - bounds.left);
        }
        TouchDelegate touchDelegate = new TouchDelegate(bounds, this$0.mExpandIv);
        $parentView.setTouchDelegate(touchDelegate);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (!this.mEnableExpand || this.mExpandIv == null) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            measureWithExpand(widthMeasureSpec, heightMeasureSpec);
        }
    }

    private final void measureWithExpand(int widthMeasureSpec, int heightMeasureSpec) {
        int controlMaxThickness;
        boolean hasHint;
        int totalControlWidth;
        int totalControlHeight;
        TintTextView tintTextView;
        String str;
        TintTextView tintTextView2;
        int firstLineMaxLength;
        TintTextView it;
        int sizeWidth = (View.MeasureSpec.getSize(widthMeasureSpec) - getPaddingRight()) - getPaddingLeft();
        int sizeHeight = (View.MeasureSpec.getSize(heightMeasureSpec) - getPaddingTop()) - getPaddingBottom();
        int modeWidth = View.MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = View.MeasureSpec.getMode(heightMeasureSpec);
        int controlMaxLength = getOrientation() == 0 ? sizeWidth : sizeHeight;
        int controlMaxThickness2 = getOrientation() == 0 ? sizeHeight : sizeWidth;
        int modeLength = getOrientation() == 0 ? modeWidth : modeHeight;
        int modeThickness = getOrientation() == 0 ? modeHeight : modeWidth;
        boolean measuredAll = preMeasure(widthMeasureSpec, heightMeasureSpec, controlMaxLength, modeLength);
        boolean displayArrow = this.mEnableExpand && (!measuredAll || this.lines.size() > this.mCollapseLines);
        boolean hasHint2 = (!displayArrow || this.mIsExpanded || this.mExpandHint == null) ? false : true;
        if (displayArrow) {
            int firstLineMaxLength2 = controlMaxLength;
            ImageView it2 = this.mExpandIv;
            if (it2 != null) {
                ViewGroup.LayoutParams layoutParams = it2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                measureItem(it2, (FlowLayout.LayoutParams) layoutParams, widthMeasureSpec, heightMeasureSpec);
                firstLineMaxLength2 = (controlMaxLength - it2.getMeasuredWidth()) - (getSpacing() / 3);
            }
            if (hasHint2 && (it = this.mExpandHint) != null) {
                ViewGroup.LayoutParams layoutParams2 = it.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                measureItem((View) it, (FlowLayout.LayoutParams) layoutParams2, widthMeasureSpec, heightMeasureSpec);
                if (it.getVisibility() != 0) {
                    it.setVisibility(0);
                }
                firstLineMaxLength = firstLineMaxLength2 - it.getMeasuredWidth();
            } else {
                firstLineMaxLength = firstLineMaxLength2;
            }
            FlowLayout.LineDefinition currentLine = lineOf(0, firstLineMaxLength);
            Intrinsics.checkNotNullExpressionValue(currentLine, "lineOf(...)");
            int count = getChildCount();
            int lineIndex = 0;
            FlowLayout.LineDefinition currentLine2 = currentLine;
            int i = 0;
            while (true) {
                if (i >= count) {
                    controlMaxThickness = controlMaxThickness2;
                    hasHint = hasHint2;
                    break;
                }
                int count2 = count;
                TintTextView childAt = getChildAt(i);
                hasHint = hasHint2;
                controlMaxThickness = controlMaxThickness2;
                if (childAt.getVisibility() != 8 && childAt != this.mExpandIv && childAt != this.mExpandHint) {
                    ViewGroup.LayoutParams layoutParams3 = childAt.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                    boolean newLine = ((FlowLayout.LayoutParams) layoutParams3).newLine || !(modeLength == 0 || currentLine2.canFit(childAt));
                    if (newLine && lineIndex == 0) {
                        if (this.mExpandHint != null && currentLine2.viewCount == 0) {
                            ViewGroup.LayoutParams layoutParams4 = childAt.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                            FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) layoutParams4;
                            if (getOrientation() == 0) {
                                lp.width = firstLineMaxLength;
                            } else {
                                lp.height = firstLineMaxLength;
                            }
                            Intrinsics.checkNotNull(childAt);
                            measureItem(childAt, lp, widthMeasureSpec, heightMeasureSpec);
                            newLine = false;
                        }
                    }
                    if (newLine) {
                        if (lineIndex == 0 && this.mExpandIv != null) {
                            currentLine2.addView(this.mExpandIv);
                            currentLine2.addView((View) this.mExpandHint);
                        }
                        if (lineIndex == getMaxLines() - 1) {
                            break;
                        }
                        lineIndex++;
                        FlowLayout.LineDefinition lineOf = lineOf(lineIndex, controlMaxLength);
                        Intrinsics.checkNotNullExpressionValue(lineOf, "lineOf(...)");
                        currentLine2 = lineOf;
                    }
                    currentLine2.addView(childAt);
                }
                i++;
                count = count2;
                hasHint2 = hasHint;
                controlMaxThickness2 = controlMaxThickness;
            }
            while (lineIndex < this.lines.size() - 1) {
                this.lines.remove(this.lines.size() - 1);
            }
        } else {
            controlMaxThickness = controlMaxThickness2;
            hasHint = hasHint2;
        }
        calculateLinesAndChildPosition(this.lines);
        if (displayArrow) {
            ImageView imageView = this.mExpandIv;
            ViewGroup.LayoutParams layoutParams5 = imageView != null ? imageView.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
            FlowLayout.LayoutParams lp2 = (FlowLayout.LayoutParams) layoutParams5;
            FlowLayout.LineDefinition line0 = this.lines.get(0);
            line0.maxLength = controlMaxLength;
            lp2.setInlineStartLength(line0.maxLength - lp2.getLength());
            line0.setLength(line0.maxLength);
        }
        FlowLayout.LineDefinition currentLine3 = this.lines.get(this.lines.size() - 1);
        int contentLength = 0;
        int linesCount = this.lines.size();
        for (int i2 = 0; i2 < linesCount; i2++) {
            FlowLayout.LineDefinition l = this.lines.get(i2);
            contentLength = Math.max(contentLength, l.getLineLength());
        }
        int i3 = currentLine3.getLineStartThickness();
        int contentThickness = i3 + currentLine3.getLineThickness();
        int realControlLength = findSize(modeLength, controlMaxLength, contentLength);
        int realControlThickness = findSize(modeThickness, controlMaxThickness, contentThickness);
        applyGravityToLines(this.lines, realControlLength, realControlThickness);
        for (int i4 = 0; i4 < linesCount; i4++) {
            FlowLayout.LineDefinition line = this.lines.get(i4);
            if (currentLine3 != line) {
                applyGravityToLine(line);
            }
            applyPositionsToViews(line);
        }
        int totalControlWidth2 = getPaddingLeft() + getPaddingRight();
        int totalControlHeight2 = getPaddingBottom() + getPaddingTop();
        if (getOrientation() == 0) {
            totalControlWidth = totalControlWidth2 + contentLength;
            totalControlHeight = totalControlHeight2 + contentThickness;
        } else {
            totalControlWidth = totalControlWidth2 + contentThickness;
            totalControlHeight = totalControlHeight2 + contentLength;
        }
        if (hasHint && this.mTagChanged) {
            this.mTagChanged = false;
            int hideCount = getChildCount();
            int contentLength2 = hideCount;
            int linesCount2 = 0;
            for (int size = this.lines.size(); linesCount2 < size; size = size) {
                contentLength2 -= this.lines.get(linesCount2).viewCount;
                linesCount2++;
            }
            if (contentLength2 > 0 && contentLength2 != this.mHintCount) {
                boolean needReMeasure = new StringBuilder().append(contentLength2).toString().length() != new StringBuilder().append(this.mHintCount).toString().length() || this.mHintCount * contentLength2 == 0;
                this.mHintCount = contentLength2;
                TintTextView tintTextView3 = this.mExpandHint;
                if (tintTextView3 != null) {
                    Resources resources = getResources();
                    int hideCount2 = bili.resource.playerbaseres.R.plurals.playerbaseres_global_string_2348;
                    tintTextView3.setText(resources.getQuantityString(hideCount2, this.mHintCount, Integer.valueOf(this.mHintCount)));
                }
                ImageView imageView2 = this.mExpandIv;
                if (this.mIsExpanded) {
                    str = "收起标签";
                } else {
                    str = "展开" + ((Object) (this.mExpandHint != null ? tintTextView.getText() : null)) + "标签";
                }
                TalkbackUtilsKt.setViewContentDescription(imageView2, str);
                if (needReMeasure) {
                    if (this.mHintCount == 0 && (tintTextView2 = this.mExpandHint) != null) {
                        tintTextView2.setVisibility(8);
                    }
                    measureWithExpand(widthMeasureSpec, heightMeasureSpec);
                }
            }
        }
        setMeasuredDimension(View.resolveSize(totalControlWidth, widthMeasureSpec), View.resolveSize(totalControlHeight, heightMeasureSpec));
    }

    private final boolean preMeasure(int widthMeasureSpec, int heightMeasureSpec, int controlMaxLength, int modeLength) {
        boolean measuredAll = true;
        int lineIndex = 0;
        FlowLayout.LineDefinition currentLine = lineOf(0, controlMaxLength);
        Intrinsics.checkNotNullExpressionValue(currentLine, "lineOf(...)");
        int count = getChildCount();
        int i = 0;
        while (true) {
            if (i >= count) {
                break;
            }
            TintTextView childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 && childAt != this.mExpandIv && childAt != this.mExpandHint) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type tv.danmaku.bili.widget.FlowLayout.LayoutParams");
                FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) layoutParams;
                Intrinsics.checkNotNull(childAt);
                measureItem(childAt, lp, widthMeasureSpec, heightMeasureSpec);
                boolean newLine = lp.newLine || !(modeLength == 0 || currentLine.canFit(childAt));
                if (newLine) {
                    if (lineIndex == getMaxLines() - 1) {
                        measuredAll = false;
                        break;
                    }
                    lineIndex++;
                    FlowLayout.LineDefinition lineOf = lineOf(lineIndex, controlMaxLength);
                    Intrinsics.checkNotNullExpressionValue(lineOf, "lineOf(...)");
                    currentLine = lineOf;
                }
                currentLine.addView(childAt);
            }
            i++;
        }
        while (lineIndex < this.lines.size() - 1) {
            this.lines.remove(this.lines.size() - 1);
        }
        return measuredAll;
    }

    private final void measureItem(View child, FlowLayout.LayoutParams lp, int widthMeasureSpec, int heightMeasureSpec) {
        child.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, getPaddingLeft() + getPaddingRight(), lp.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), lp.height));
        lp.clearCalculatedFields(getOrientation());
        if (getOrientation() == 0) {
            lp.setLength(child.getMeasuredWidth());
            lp.setThickness(child.getMeasuredHeight());
            return;
        }
        lp.setLength(child.getMeasuredHeight());
        lp.setThickness(child.getMeasuredWidth());
    }

    public final void setEnableExpand(boolean enable, boolean enableHint) {
        if (this.mEnableExpand != enable || this.mEnableExpandHint != enableHint) {
            this.mEnableExpand = enable;
            this.mEnableExpandHint = enableHint;
            invalidateInner();
        }
    }

    public final void setCollapseLines(int collapseLines) {
        if (this.mCollapseLines != collapseLines) {
            this.mCollapseLines = collapseLines;
            invalidateInner();
        }
    }

    public final void setExpandLines(int expandLines) {
        if (this.mExpandLines != expandLines) {
            this.mExpandLines = expandLines;
            invalidateInner();
        }
    }

    public final void expand() {
        this.mIsExpanded = true;
        invalidateInner();
    }

    public final void collapse() {
        this.mIsExpanded = false;
        invalidateInner();
    }

    private final void invalidateInner() {
        initActionView();
        if (this.mEnableExpand) {
            if (this.mIsExpanded) {
                setMaxLines(this.mExpandLines);
                BLog.d(TAG, "set max lines when flush: expand: " + this.mExpandLines);
            } else {
                setMaxLines(this.mCollapseLines);
                BLog.d(TAG, "set max lines when flush: collapse: " + this.mCollapseLines);
            }
            invalidateExpandIcon();
        } else {
            this.mIsExpanded = true;
            setMaxLines(this.mExpandLines);
            BLog.d(TAG, "set max lines when flush: disable expand: " + this.mExpandLines);
        }
        requestLayout();
    }

    private final void invalidateExpandIcon() {
        TintTextView tintTextView;
        String str;
        TintTextView tintTextView2;
        ImageView it = this.mExpandIv;
        if (it != null) {
            it.setRotation(this.mIsExpanded ? 180.0f : DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
            it.setImageResource(tv.danmaku.biliplayer.baseres.R.drawable.ugcvideo_ic_video_detail_arrow_down);
        }
        ImageView imageView = this.mExpandIv;
        if (this.mIsExpanded) {
            str = "收起标签";
        } else {
            str = "展开" + ((Object) (this.mExpandHint != null ? tintTextView.getText() : null)) + "标签";
        }
        TalkbackUtilsKt.setViewContentDescription(imageView, str);
        if (!this.mIsExpanded || (tintTextView2 = this.mExpandHint) == null) {
            return;
        }
        tintTextView2.setVisibility(8);
    }

    public final void setAdapter(BaseAdapter adapter, boolean forceNotify) {
        this.mTagChanged = true;
        if (this.mAdapter != adapter || forceNotify) {
            if (this.mAdapter != null) {
                removeAllViewsInLayout();
                BLog.d(TAG, "remove all views when set adapter");
            }
            if (adapter == null) {
                removeLinesInLayout(0, this.lines.size());
            } else {
                this.mAdapter = adapter;
                Boolean bool = (Boolean) Contract.-CC.get$default(ConfigManager.Companion.ab(), "videodetail_tag_long_press_enable", (Object) null, 2, (Object) null);
                this.mOnLongSelectEnabled = bool != null ? bool.booleanValue() : true;
                if (this.mOnLongSelectEnabled) {
                    int count = adapter.getCount();
                    for (int i = 0; i < count; i++) {
                        View itemView = adapter.getView(i, null, this);
                        itemView.setOnClickListener(this.mTagClick);
                        itemView.setOnLongClickListener(this.mTagLongClick);
                        itemView.setTag(KEY_POS, Integer.valueOf(i));
                        addViewInLayout(itemView, -1, generateDefaultLayoutParams(), true);
                    }
                } else {
                    int count2 = adapter.getCount();
                    for (int i2 = 0; i2 < count2; i2++) {
                        View itemView2 = adapter.getView(i2, null, this);
                        itemView2.setOnClickListener(this.mTagClick);
                        itemView2.setTag(KEY_POS, Integer.valueOf(i2));
                        addViewInLayout(itemView2, -1, generateDefaultLayoutParams(), true);
                    }
                }
                BLog.d(TAG, "add all views when set adapter: " + adapter.getCount());
                initActionView();
            }
            requestLayout();
            invalidate();
        }
        invalidateExpandIcon();
    }

    private final void removeLinesInLayout(int start, int count) {
        int count2 = count;
        if (count2 > this.lines.size()) {
            count2 = this.lines.size();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "remove line:(%d, %d)", Arrays.copyOf(new Object[]{Integer.valueOf(start), Integer.valueOf(start + count2)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        BLog.d(TAG, format);
        ListIterator listIterator = this.lines.listIterator();
        for (int i = start; i < count2 && listIterator.hasNext(); i++) {
            FlowLayout.LineDefinition line = listIterator.next();
            line.reset();
            listIterator.remove();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(Locale.getDefault(), "remove line:(%d)", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            BLog.d(TAG, format2);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mEnableExpand = savedState.getMEnableExpand() != 0;
        this.mIsExpanded = savedState.getMIsExpanded() != 0;
        this.mCollapseLines = savedState.getMCollapseLines();
        this.mExpandLines = savedState.getMExpandLines();
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        Intrinsics.checkNotNull(superState);
        SavedState savedState = new SavedState(superState);
        savedState.setMEnableExpand(this.mEnableExpand ? 1 : 0);
        savedState.setMIsExpanded(this.mIsExpanded ? 1 : 0);
        savedState.setMCollapseLines(this.mCollapseLines);
        savedState.setMExpandLines(this.mExpandLines);
        return savedState;
    }

    /* compiled from: ExpandableTagFlowLayout.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\nH\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u001d"}, d2 = {"Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$SavedState;", "Landroid/view/View$BaseSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "src", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mEnableExpand", "", "getMEnableExpand", "()I", "setMEnableExpand", "(I)V", "mIsExpanded", "getMIsExpanded", "setMIsExpanded", "mCollapseLines", "getMCollapseLines", "setMCollapseLines", "mExpandLines", "getMExpandLines", "setMExpandLines", "writeToParcel", "", "dest", "flags", "Companion", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class SavedState extends View.BaseSavedState {
        private int mCollapseLines;
        private int mEnableExpand;
        private int mExpandLines;
        private int mIsExpanded;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.danmaku.bili.widget.ExpandableTagFlowLayout$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public ExpandableTagFlowLayout.SavedState createFromParcel(Parcel src) {
                Intrinsics.checkNotNullParameter(src, "src");
                return new ExpandableTagFlowLayout.SavedState(src, null);
            }

            @Override // android.os.Parcelable.Creator
            public ExpandableTagFlowLayout.SavedState[] newArray(int size) {
                return new ExpandableTagFlowLayout.SavedState[size];
            }
        };

        public /* synthetic */ SavedState(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
            this(parcel);
        }

        public final int getMEnableExpand() {
            return this.mEnableExpand;
        }

        public final void setMEnableExpand(int i) {
            this.mEnableExpand = i;
        }

        public final int getMIsExpanded() {
            return this.mIsExpanded;
        }

        public final void setMIsExpanded(int i) {
            this.mIsExpanded = i;
        }

        public final int getMCollapseLines() {
            return this.mCollapseLines;
        }

        public final void setMCollapseLines(int i) {
            this.mCollapseLines = i;
        }

        public final int getMExpandLines() {
            return this.mExpandLines;
        }

        public final void setMExpandLines(int i) {
            this.mExpandLines = i;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
            this.mCollapseLines = 1;
            this.mExpandLines = Integer.MAX_VALUE;
        }

        private SavedState(Parcel src) {
            super(src);
            this.mCollapseLines = 1;
            this.mExpandLines = Integer.MAX_VALUE;
            this.mEnableExpand = src.readInt();
            this.mIsExpanded = src.readInt();
            this.mCollapseLines = src.readInt();
            this.mExpandLines = src.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeInt(this.mEnableExpand);
            dest.writeInt(this.mIsExpanded);
            dest.writeInt(this.mCollapseLines);
            dest.writeInt(this.mExpandLines);
        }

        /* compiled from: ExpandableTagFlowLayout.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$SavedState$Companion;", "", "<init>", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$SavedState;", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    public final void setTagSelectable(boolean selectable) {
        View view2;
        this.mSelectable = selectable;
        if (this.mSelectable || (view2 = this.mSelectedTagView) == null) {
            return;
        }
        view2.setSelected(false);
    }

    public final void setOnTagSelectedListener(OnTagSelectedListener l) {
        Intrinsics.checkNotNullParameter(l, "l");
        this.mTagSelectedListener = l;
    }

    /* compiled from: ExpandableTagFlowLayout.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/widget/ExpandableTagFlowLayout$Companion;", "", "<init>", "()V", "TAG", "", "COLLAPSE_LINE_DEFAULT", "", "EXPAND_LINE_DEFAULT", "KEY_POS", "videopagecommon_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}