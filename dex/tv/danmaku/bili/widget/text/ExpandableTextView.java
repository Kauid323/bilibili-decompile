package tv.danmaku.bili.widget.text;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.bilibili.magicasakura.utils.ThemeUtils;
import java.util.Arrays;
import tv.danmaku.bili.widget.R;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import video.biz.offline.list.logic.tree.VideoFile;

public class ExpandableTextView extends ClickableSpanTextView {
    private static final long ANIM_DURATION = 300;
    private static final EmptyDescInfo DESC_EMPTY = new EmptyDescInfo();
    public static final String ELLIPSIS = "...";
    private static final int MAX_LINES_DEFAULT = 1;
    public static final String SPACE = " ";
    public static final char SPACE_CHAR = ' ';
    private CharSequence mCacheExpandText;
    private CharSequence mCacheRetractText;
    private CharSequence mContent;
    private View.OnClickListener mDescClickListener;
    private int mDescColor;
    private boolean mEnableTouchToggle;
    private int mExpandHeight;
    private OnStateChangeListener mExpandListener;
    private AbsDescInfo mExpandedDesc;
    private TextInterceptor mInterceptor;
    private boolean mIsAnimating;
    private boolean mIsExpand;
    private boolean mIsNullText;
    private boolean mIsOutLines;
    private int mMaxRetractLines;
    private int mRetractHeight;
    private AbsDescInfo mRetractedDesc;
    private boolean mShowExpandedDesc;
    private boolean mShowRetractedDesc;
    private ITextBuilder mTextBuilder;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ITextBuilder {
        CharSequence buildExpandText(CharSequence charSequence, Layout layout, AbsDescInfo absDescInfo);

        CharSequence buildNormalText();

        CharSequence buildRetractText(CharSequence charSequence, Layout layout, AbsDescInfo absDescInfo, int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnStateChangeListener {
        void onStateChanged(boolean z);

        void onStateOutline(boolean z);

        void onStateWillChange(boolean z, boolean z2);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface TextInterceptor {
        CharSequence intercept(CharSequence charSequence, boolean z);
    }

    public ExpandableTextView(Context context) {
        this(context, null);
    }

    public ExpandableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIsNullText = false;
        this.mEnableTouchToggle = true;
        this.mDescClickListener = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.text.ExpandableTextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExpandableTextView.this.toggle();
            }
        };
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
        String expandedDesc = ta.getString(R.styleable.ExpandableTextView_expandedDesc);
        String retractedDesc = ta.getString(R.styleable.ExpandableTextView_retractedDesc);
        this.mShowExpandedDesc = ta.getBoolean(R.styleable.ExpandableTextView_showExpandedDesc, true);
        this.mShowRetractedDesc = ta.getBoolean(R.styleable.ExpandableTextView_showRetractedDesc, true);
        this.mMaxRetractLines = ta.getInt(R.styleable.ExpandableTextView_maxRetractLines, 1);
        this.mMaxRetractLines = Math.max(this.mMaxRetractLines, 0);
        this.mDescColor = ta.getColor(R.styleable.ExpandableTextView_descColor, ThemeUtils.getColorById(context, com.bilibili.app.comm.baseres.R.color.theme_color_secondary));
        ta.recycle();
        if (TextUtils.isEmpty(expandedDesc)) {
            this.mExpandedDesc = DESC_EMPTY;
        } else {
            this.mExpandedDesc = new ThemeStringDescInfo(getContext(), expandedDesc, this.mDescColor);
        }
        if (TextUtils.isEmpty(retractedDesc)) {
            this.mRetractedDesc = DESC_EMPTY;
        } else {
            this.mRetractedDesc = new ThemeStringDescInfo(getContext(), retractedDesc, this.mDescColor);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOriginText(ITextBuilder textBuilder) {
        this.mTextBuilder = textBuilder;
        if (this.mTextBuilder == null) {
            reset();
            setText(null);
            return;
        }
        CharSequence content = this.mTextBuilder.buildNormalText();
        if (TextUtils.equals(this.mContent, content)) {
            return;
        }
        reset();
        this.mContent = content;
        OneShotPreDrawListener.add(this, new Runnable() { // from class: tv.danmaku.bili.widget.text.ExpandableTextView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExpandableTextView.this.m2130lambda$setOriginText$0$tvdanmakubiliwidgettextExpandableTextView();
            }
        });
        setText(this.mContent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$setOriginText$0$tv-danmaku-bili-widget-text-ExpandableTextView  reason: not valid java name */
    public /* synthetic */ void m2130lambda$setOriginText$0$tvdanmakubiliwidgettextExpandableTextView() {
        if (this.mEnableTouchToggle) {
            setOnClickListener(null);
        }
        getViewTreeObserver().removeOnPreDrawListener(this);
        Layout layout = getLayout();
        if (layout == null) {
            return;
        }
        this.mIsExpand = true;
        this.mExpandHeight = calcExpandHeight(layout);
        int lines = layout.getLineCount();
        if (lines > this.mMaxRetractLines) {
            this.mIsOutLines = true;
            retract();
            requestLayout();
            if (this.mEnableTouchToggle) {
                setOnClickListener(this.mDescClickListener);
            }
        } else {
            this.mIsOutLines = false;
            expand();
            requestLayout();
        }
        if (this.mExpandListener != null) {
            this.mExpandListener.onStateOutline(this.mIsOutLines);
        }
    }

    private void reset() {
        this.mIsAnimating = false;
        this.mIsExpand = false;
        this.mIsOutLines = false;
        this.mExpandHeight = 0;
        this.mRetractHeight = 0;
        this.mContent = null;
        this.mCacheExpandText = null;
        this.mCacheRetractText = null;
    }

    private int calcExpandHeight(Layout layout) {
        if (TextUtils.isEmpty(this.mExpandedDesc.getDesc()) || !this.mShowExpandedDesc || layout == null) {
            return getHeight();
        }
        CharSequence expandText = buildExpandedText(layout, this.mContent);
        StaticLayout staticLayout = new StaticLayout(expandText, layout.getPaint(), layout.getWidth(), layout.getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd(), false);
        return (staticLayout.getHeight() + (layout.getBottomPadding() - layout.getTopPadding())) - (staticLayout.getBottomPadding() - staticLayout.getTopPadding());
    }

    private CharSequence buildExpandedText(Layout layout, CharSequence originText) {
        if (this.mTextBuilder == null) {
            return originText;
        }
        if (this.mCacheExpandText == null) {
            this.mCacheExpandText = this.mTextBuilder.buildExpandText(originText, layout, this.mExpandedDesc);
        }
        return this.mCacheExpandText;
    }

    private CharSequence buildRetractText(Layout layout, CharSequence originText) {
        if (this.mTextBuilder == null) {
            return originText;
        }
        AbsDescInfo retractedDesc = this.mRetractedDesc;
        if (!this.mShowRetractedDesc) {
            retractedDesc = DESC_EMPTY;
        }
        if (this.mCacheRetractText == null) {
            this.mCacheRetractText = this.mTextBuilder.buildRetractText(originText, layout, retractedDesc, this.mMaxRetractLines);
        }
        return this.mCacheRetractText;
    }

    public void toggle() {
        if (!this.mIsOutLines) {
            return;
        }
        if (this.mIsExpand) {
            retractWithAnim();
        } else {
            expandWithAnim();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void expandWithAnim() {
        if (this.mIsAnimating || !this.mIsOutLines || this.mIsExpand) {
            return;
        }
        if (this.mExpandListener != null) {
            this.mExpandListener.onStateWillChange(false, true);
        }
        this.mRetractHeight = this.mMaxRetractLines != 0 ? getHeight() : 0;
        if (this.mExpandHeight <= 0 || this.mRetractHeight < 0) {
            expand();
            return;
        }
        getLayoutParams().height = this.mRetractHeight;
        expand();
        ValueAnimator animator = createAnimator(this, this.mRetractHeight, this.mExpandHeight);
        animator.setDuration(ANIM_DURATION);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.widget.text.ExpandableTextView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ExpandableTextView.this.mIsAnimating = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                ExpandableTextView.this.mIsAnimating = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ExpandableTextView.this.mIsAnimating = false;
                ExpandableTextView.this.getLayoutParams().height = -2;
                ExpandableTextView.this.requestLayout();
            }
        });
        animator.start();
    }

    private void expand() {
        if (this.mContent == null || !this.mIsOutLines || this.mIsExpand) {
            return;
        }
        this.mIsExpand = true;
        if (!TextUtils.isEmpty(this.mContent)) {
            CharSequence text = buildExpandedText(getLayout(), this.mContent);
            if (this.mInterceptor != null) {
                text = this.mInterceptor.intercept(text, this.mIsExpand);
            }
            setText(text);
        }
        if (this.mExpandListener != null) {
            this.mExpandListener.onStateChanged(this.mIsExpand);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void retractWithAnim() {
        if (this.mIsAnimating || !this.mIsOutLines || !this.mIsExpand) {
            return;
        }
        if (this.mExpandListener != null) {
            this.mExpandListener.onStateWillChange(true, false);
        }
        if (this.mExpandHeight == 0) {
            retract();
            return;
        }
        ValueAnimator animator = createAnimator(this, this.mExpandHeight, this.mRetractHeight);
        animator.addListener(new AnimatorListenerAdapter() { // from class: tv.danmaku.bili.widget.text.ExpandableTextView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                ExpandableTextView.this.mIsAnimating = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                ExpandableTextView.this.mIsAnimating = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                ExpandableTextView.this.retract();
                ExpandableTextView.this.mIsAnimating = false;
                ExpandableTextView.this.getLayoutParams().height = -2;
                ExpandableTextView.this.requestLayout();
            }
        });
        animator.setDuration(ANIM_DURATION);
        animator.setInterpolator(new FastOutSlowInInterpolator());
        animator.start();
    }

    public void retract() {
        if (this.mContent == null || !this.mIsOutLines || !this.mIsExpand) {
            return;
        }
        this.mIsExpand = false;
        CharSequence content = buildRetractText(getLayout(), this.mContent);
        setText(content);
        if (this.mExpandListener != null) {
            this.mExpandListener.onStateChanged(this.mIsExpand);
        }
    }

    private ValueAnimator createAnimator(final View target, int from, int to) {
        ValueAnimator animator = ValueAnimator.ofInt(from, to);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: tv.danmaku.bili.widget.text.ExpandableTextView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                target.getLayoutParams().height = ((Integer) animation.getAnimatedValue()).intValue();
                target.requestLayout();
            }
        });
        return animator;
    }

    public void setTextInterceptor(TextInterceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public void setExpandListener(OnStateChangeListener expandListener) {
        this.mExpandListener = expandListener;
    }

    public void setMaxRetractLines(int maxRetractLines) {
        this.mMaxRetractLines = maxRetractLines;
    }

    public void setExpandedDesc(AbsDescInfo expandedDesc) {
        this.mExpandedDesc = expandedDesc;
        if (this.mExpandedDesc == null) {
            this.mExpandedDesc = DESC_EMPTY;
        }
    }

    public void setRetractedDesc(AbsDescInfo retractedDesc) {
        this.mRetractedDesc = retractedDesc;
        if (this.mRetractedDesc == null) {
            this.mRetractedDesc = DESC_EMPTY;
        }
    }

    public void setShowExpandedDesc(boolean showExpandedDesc) {
        this.mShowExpandedDesc = showExpandedDesc;
    }

    public void setShowRetractedDesc(boolean showRetractedDesc) {
        this.mShowRetractedDesc = showRetractedDesc;
    }

    public void setEnableTouchToggle(boolean enableTouchToggle) {
        this.mEnableTouchToggle = enableTouchToggle;
    }

    public boolean isExpand() {
        return this.mIsExpand;
    }

    public static CharSequence trim(CharSequence s) {
        return trim(s, true, true);
    }

    public static CharSequence trim(CharSequence s, boolean trimStart, boolean trimEnd) {
        int len = s.length();
        int start = 0;
        if (trimStart) {
            while (start < len && s.charAt(start) <= ' ') {
                start++;
            }
        }
        int end = len;
        if (trimEnd) {
            while (end > start && s.charAt(end - 1) <= ' ') {
                end--;
            }
        }
        return (start > 0 || end < len) ? s.subSequence(start, end) : s;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class AbsDescInfo {
        private CharSequence mCache;

        public abstract CharSequence buildDesc();

        public abstract float measureWidth(Paint paint);

        public final CharSequence getDesc() {
            if (this.mCache == null) {
                this.mCache = buildDesc();
            }
            return this.mCache;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ThemeStringDescInfo extends AbsDescInfo {
        private Context mContext;
        private String mDesc;
        private int mDescColor;

        public ThemeStringDescInfo(Context context, String desc, int descColor) {
            this.mContext = context;
            this.mDesc = desc;
            this.mDescColor = descColor;
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.AbsDescInfo
        public CharSequence buildDesc() {
            if (TextUtils.isEmpty(this.mDesc)) {
                return "";
            }
            SpannableString desc = new SpannableString(this.mDesc);
            desc.setSpan(new ForegroundColorSpan(this.mDescColor), 0, desc.length(), 18);
            return desc;
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.AbsDescInfo
        public float measureWidth(Paint paint) {
            CharSequence desc = getDesc();
            if (TextUtils.isEmpty(desc)) {
                return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
            }
            return paint.measureText(desc, 0, desc.length());
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class EmptyDescInfo extends AbsDescInfo {
        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.AbsDescInfo
        public CharSequence buildDesc() {
            return "";
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.AbsDescInfo
        public float measureWidth(Paint paint) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class DefaultTextBuilder implements ITextBuilder {
        private CharSequence mNormalText;

        public DefaultTextBuilder() {
        }

        public DefaultTextBuilder(CharSequence normalText) {
            this.mNormalText = normalText;
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.ITextBuilder
        public CharSequence buildNormalText() {
            return this.mNormalText;
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.ITextBuilder
        public CharSequence buildExpandText(CharSequence originText, Layout layout, AbsDescInfo descInfo) {
            if (TextUtils.isEmpty(originText) || layout == null || TextUtils.isEmpty(descInfo.getDesc())) {
                return originText;
            }
            TextPaint paint = layout.getPaint();
            StaticLayout staticLayout = new StaticLayout(originText, paint, layout.getWidth(), layout.getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd(), false);
            SpannableStringBuilder ssb = new SpannableStringBuilder(originText);
            int lastLine = staticLayout.getLineCount() - 1;
            float maxWidth = staticLayout.getWidth();
            float lastLineWidth = staticLayout.getLineMax(lastLine);
            float descWidth = descInfo.measureWidth(paint);
            float[] measures = new float[1];
            float avail = maxWidth - descWidth;
            if (lastLineWidth > avail) {
                ssb.append((CharSequence) VideoFile.TREE_END);
                measures[0] = 0.0f;
            } else {
                measures[0] = lastLineWidth;
            }
            float leftWidth = avail - measures[0];
            fillWithSpace(ssb, paint, leftWidth);
            ssb.append(descInfo.getDesc());
            return ssb;
        }

        @Override // tv.danmaku.bili.widget.text.ExpandableTextView.ITextBuilder
        public CharSequence buildRetractText(CharSequence originText, Layout layout, AbsDescInfo descInfo, int maxRetractLines) {
            if (TextUtils.isEmpty(originText) || layout == null) {
                return originText;
            }
            if (maxRetractLines == 0) {
                return null;
            }
            Paint paint = layout.getPaint();
            SpannableStringBuilder ssb = new SpannableStringBuilder();
            int lastLine = maxRetractLines - 1;
            int lastLineStart = layout.getLineStart(lastLine);
            int lastLineEnd = layout.getLineEnd(lastLine);
            float maxWidth = layout.getWidth();
            CharSequence lastLineText = ExpandableTextView.trim(originText.subSequence(lastLineStart, lastLineEnd), false, true);
            int lastLineTextLength = lastLineText.length();
            float descWidth = descInfo.measureWidth(paint);
            float ellipsisWid = paint.measureText("... ");
            float avail = (maxWidth - descWidth) - ellipsisWid;
            float[] measures = new float[1];
            int left = paint.breakText(lastLineText, 0, lastLineTextLength, true, avail, measures);
            if (left > 0) {
                ssb.append(ExpandableTextView.trim(originText.subSequence(0, lastLineStart + left), false, true));
            } else {
                ssb.append(originText.subSequence(0, lastLineStart));
            }
            ssb.append((CharSequence) "...").append((CharSequence) " ");
            float leftWidth = avail - measures[0];
            fillWithSpace(ssb, paint, leftWidth);
            ssb.append(descInfo.getDesc());
            return ssb;
        }

        public static void fillWithSpace(SpannableStringBuilder ssb, Paint paint, float leftSpace) {
            if (leftSpace <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                return;
            }
            float singleSpaceWidth = paint.measureText(" ");
            int spaceCount = singleSpaceWidth > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN ? (int) (leftSpace / singleSpaceWidth) : 0;
            if (leftSpace % singleSpaceWidth < singleSpaceWidth / 2.0f) {
                spaceCount--;
            }
            if (spaceCount > 0) {
                char[] chars = new char[spaceCount];
                Arrays.fill(chars, ' ');
                ssb.append((CharSequence) new StringBuilder().append(chars));
            }
        }
    }

    public void setText(CharSequence text, TextView.BufferType type) {
        this.mIsNullText = text == null || text.length() == 0;
        super.setText(text, type);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mIsNullText || (getLayoutParams() != null && getLayoutParams().height == 0)) {
            heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}