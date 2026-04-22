package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.SparseArrayCompat;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.magicasakura.widgets.Tintable;
import java.lang.reflect.Field;
import tv.danmaku.android.util.AppBuildConfig;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class PagerSlidingTabStrip extends HorizontalScrollView implements Tintable {
    private SparseArrayCompat<Float> cacheItemContentWidth;
    private int colorId;
    protected int currentPosition;
    protected float currentPositionOffset;
    protected LinearLayout.LayoutParams defaultTabLayoutParams;
    public ViewPager.OnPageChangeListener delegatePageListener;
    protected LinearLayout.LayoutParams expandedTabLayoutParams;
    private int indicatorColor;
    private boolean indicatorEnable;
    private int indicatorHeight;
    protected int indicatorRound;
    protected int indicatorWidth;
    private boolean indicatorWrapContent;
    private int indicatorWrapOffset;
    private int lastScrollX;
    private View.OnClickListener mTabClick;
    private ViewPager.OnPageChangeListener pageListener;
    protected ViewPager pager;
    protected Paint rectPaint;
    private PageReselectedListener reselectedListener;
    private int scrollOffset;
    private boolean shouldExpand;
    private int tabBackgroundResId;
    private TabClickListener tabClickListener;
    private int tabCount;
    protected int tabLayoutPadding;
    private int tabPadding;
    private int tabTextAppearance;
    private int tabTextMaxWidth;
    protected LinearLayout tabsContainer;
    private boolean textAllCaps;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IconTabProvider {
        int getPageIconResId(int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface PageReselectedListener {
        void onReselected(int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface TabClickListener {
        void onTabClick(int i);
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.currentPosition = 0;
        this.currentPositionOffset = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        this.indicatorColor = -10066330;
        this.shouldExpand = false;
        this.textAllCaps = true;
        this.indicatorWrapContent = false;
        this.indicatorWrapOffset = 0;
        this.indicatorWidth = 0;
        this.indicatorRound = 0;
        this.cacheItemContentWidth = new SparseArrayCompat<>();
        this.scrollOffset = 52;
        this.indicatorHeight = 8;
        this.tabPadding = 24;
        this.tabTextMaxWidth = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.lastScrollX = 0;
        this.tabBackgroundResId = 0;
        this.mTabClick = new View.OnClickListener() { // from class: tv.danmaku.bili.widget.PagerSlidingTabStrip.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int position = ((Integer) v.getTag()).intValue();
                int current = PagerSlidingTabStrip.this.pager.getCurrentItem();
                if (current == position) {
                    if (PagerSlidingTabStrip.this.reselectedListener != null) {
                        PagerSlidingTabStrip.this.reselectedListener.onReselected(position);
                        return;
                    }
                    return;
                }
                if (PagerSlidingTabStrip.this.tabClickListener != null) {
                    PagerSlidingTabStrip.this.tabClickListener.onTabClick(position);
                }
                PagerSlidingTabStrip.this.pager.setCurrentItem(position, Math.abs(current - position) < 3);
            }
        };
        this.indicatorEnable = true;
        setFillViewport(true);
        setWillNotDraw(false);
        this.tabsContainer = new LinearLayout(context);
        this.tabsContainer.setOrientation(0);
        this.tabsContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.tabsContainer.setClipChildren(false);
        addView(this.tabsContainer);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        this.scrollOffset = (int) TypedValue.applyDimension(1, this.scrollOffset, dm);
        this.indicatorHeight = (int) TypedValue.applyDimension(1, this.indicatorHeight, dm);
        this.tabPadding = (int) TypedValue.applyDimension(1, this.tabPadding, dm);
        if (isInEditMode()) {
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip);
        try {
            this.colorId = a.getResourceId(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorColor, 0);
            this.indicatorColor = this.colorId != 0 ? ThemeUtils.getColorById(context, this.colorId) : this.indicatorColor;
            this.indicatorHeight = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorHeight, this.indicatorHeight);
            this.tabPadding = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsTabPaddingLeftRight, this.tabPadding);
            this.tabBackgroundResId = a.getResourceId(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsTabBackground, this.tabBackgroundResId);
            this.shouldExpand = a.getBoolean(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsShouldExpand, this.shouldExpand);
            this.scrollOffset = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsScrollOffset, this.scrollOffset);
            this.textAllCaps = a.getBoolean(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsTextAllCaps, this.textAllCaps);
            this.tabTextMaxWidth = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsTabMaxWidth, this.tabTextMaxWidth);
            this.tabTextAppearance = a.getResourceId(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_android_textAppearance, com.bilibili.lib.widget.R.style.TextAppearance_App_Title);
            this.tabLayoutPadding = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsTabLayoutPadding, 0);
            this.tabsContainer.setPadding(this.tabLayoutPadding, 0, this.tabLayoutPadding, 0);
            this.indicatorWrapContent = a.getBoolean(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorWrapContent, this.indicatorWrapContent);
            this.indicatorWrapOffset = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorWrapOffset, 0);
            if (AppBuildConfig.isHDApp()) {
                this.indicatorWidth = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorWidth, 0);
                this.indicatorRound = a.getDimensionPixelSize(com.bilibili.lib.widget.R.styleable.PagerSlidingTabStrip_pstsIndicatorRound, 0);
            }
            a.recycle();
            this.rectPaint = new Paint();
            this.rectPaint.setAntiAlias(true);
            this.rectPaint.setStyle(Paint.Style.FILL);
            this.defaultTabLayoutParams = new LinearLayout.LayoutParams(-2, -1);
            this.expandedTabLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
            this.pageListener = getPageListener();
        } catch (Throwable th) {
            a.recycle();
            throw th;
        }
    }

    protected ViewPager.OnPageChangeListener getPageListener() {
        return new PageListener();
    }

    public void setViewPager(ViewPager pager) {
        this.pager = pager;
        if (pager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        pager.addOnPageChangeListener(this.pageListener);
        notifyDataSetChanged();
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        this.delegatePageListener = listener;
    }

    public void setOnPageReselectedListener(PageReselectedListener l) {
        this.reselectedListener = l;
    }

    public void setOnTabClickListener(TabClickListener l) {
        this.tabClickListener = l;
    }

    public void notifyDataSetChanged() {
        this.tabsContainer.removeAllViews();
        this.cacheItemContentWidth.clear();
        IconTabProvider adapter = this.pager.getAdapter();
        if (adapter == null) {
            return;
        }
        this.tabCount = adapter.getCount();
        for (int i = 0; i < this.tabCount; i++) {
            if (adapter instanceof IconTabProvider) {
                addIconTab(i, adapter.getPageIconResId(i));
            } else {
                addTextTab(i, adapter.getPageTitle(i));
            }
        }
        updateTabStyles();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.widget.PagerSlidingTabStrip.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                PagerSlidingTabStrip.this.updateSelectedTab();
            }
        });
    }

    protected int pagerPosToCurrentPos(int pos) {
        return pos;
    }

    protected void updateSelectedTab() {
        this.currentPosition = pagerPosToCurrentPos(this.pager.getCurrentItem());
        View child = this.tabsContainer.getChildAt(this.currentPosition);
        if (child != null) {
            child.setSelected(true);
            scrollToChild(this.currentPosition, 0);
        }
    }

    private void addTextTab(int position, CharSequence title) {
        addTab(position, generateTab(position, title));
    }

    public int getTabTextMaxWidth() {
        return this.tabTextMaxWidth;
    }

    protected View generateTab(int position, CharSequence title) {
        TintTextView tintTextView = new TintTextView(getContext());
        tintTextView.setText(title);
        tintTextView.setMaxWidth(this.tabTextMaxWidth);
        tintTextView.setGravity(17);
        tintTextView.setEllipsize(TextUtils.TruncateAt.END);
        tintTextView.setSingleLine();
        tintTextView.setPadding(this.tabPadding, 0, this.tabPadding, 0);
        tintTextView.setId(com.bilibili.lib.widget.R.id.tab_title);
        return tintTextView;
    }

    protected float measureTabItemWidth(View tabItemView) {
        float wrapContentWidth;
        float textWidth = -1.0f;
        if (tabItemView instanceof TextView) {
            TextView textView = (TextView) tabItemView;
            textWidth = textView.getPaint().measureText(textView.getText(), 0, textView.length());
        } else if (tabItemView instanceof ImageView) {
            ImageView imageView = (ImageView) tabItemView;
            Drawable d = imageView.getDrawable();
            if (d != null) {
                textWidth = d.getIntrinsicWidth();
            }
        }
        if (this.indicatorWrapContent) {
            wrapContentWidth = this.tabTextMaxWidth - (this.tabPadding * 2);
        } else {
            wrapContentWidth = this.tabTextMaxWidth;
        }
        return Math.min(textWidth, wrapContentWidth);
    }

    private void addIconTab(int position, int resId) {
        TintImageView tintImageView = new TintImageView(getContext());
        tintImageView.setImageResource(resId);
        addTab(position, tintImageView);
    }

    public int getTabCount() {
        return this.tabCount;
    }

    public View getTabAt(int index) {
        if (index >= this.tabCount || index < 0) {
            throw new ArrayIndexOutOfBoundsException("index=" + index + ",length=" + this.tabCount);
        }
        return this.tabsContainer.getChildAt(index);
    }

    public int getTabTextAppearance() {
        return this.tabTextAppearance;
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        if (isEnabled() == enabled) {
            return;
        }
        for (int i = 0; i < this.tabCount; i++) {
            View child = this.tabsContainer.getChildAt(i);
            child.setEnabled(enabled);
        }
        super.setEnabled(enabled);
    }

    private void addTab(int position, View tab) {
        tab.setFocusable(true);
        tab.setTag(Integer.valueOf(position));
        tab.setOnClickListener(this.mTabClick);
        this.tabsContainer.addView(tab, position, this.shouldExpand ? this.expandedTabLayoutParams : this.defaultTabLayoutParams);
    }

    protected void updateTabStyles() {
        for (int i = 0; i < this.tabCount; i++) {
            View v = this.tabsContainer.getChildAt(i);
            v.setBackgroundResource(this.tabBackgroundResId);
            if (v instanceof TextView) {
                TextView tab = (TextView) v;
                updateTextViewStyle(tab);
            } else if (v instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) v;
                updateViewGroupStyle(viewGroup);
            }
        }
    }

    private void updateViewGroupStyle(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int index = 0; index < childCount; index++) {
            View childView = viewGroup.getChildAt(index);
            if (childView instanceof TextView) {
                TextView tab = (TextView) childView;
                updateTextViewStyle(tab);
            } else if (childView instanceof ViewGroup) {
                updateViewGroupStyle((ViewGroup) childView);
            }
        }
    }

    protected void updateTextViewStyle(TextView tab) {
        if (tab.getId() != com.bilibili.lib.widget.R.id.tab_title) {
            return;
        }
        tab.setTextAppearance(tab.getContext(), this.tabTextAppearance);
        if (this.textAllCaps) {
            tab.setAllCaps(true);
        }
    }

    protected void scrollToChild(int position, int offset) {
        int newScrollX;
        if (this.tabCount == 0) {
            return;
        }
        View child = this.tabsContainer.getChildAt(position);
        if (child == null) {
            newScrollX = offset;
        } else {
            newScrollX = child.getLeft() + offset;
        }
        if (position > 0 || offset > 0) {
            newScrollX -= this.scrollOffset;
        }
        if (newScrollX != this.lastScrollX) {
            this.lastScrollX = newScrollX;
            scrollTo(newScrollX, 0);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isEnabled() && super.onInterceptTouchEvent(ev);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return isEnabled() && super.onTouchEvent(ev);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode() || this.tabCount == 0 || !this.indicatorEnable) {
            return;
        }
        int height = getHeight();
        this.rectPaint.setColor(this.indicatorColor);
        View currentTab = this.tabsContainer.getChildAt(this.currentPosition);
        int left = this.tabsContainer.getLeft();
        float lineOffset = getLineOffset(currentTab);
        float lineLeft = currentTab.getLeft() + left + lineOffset;
        float lineRight = (currentTab.getRight() + left) - lineOffset;
        if (this.currentPositionOffset > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && this.currentPosition < this.tabCount - 1) {
            View nextTab = this.tabsContainer.getChildAt(this.currentPosition + 1);
            float nextLineOffset = getLineOffset(nextTab);
            float nextTabLeft = nextTab.getLeft() + left + nextLineOffset;
            float nextTabRight = (nextTab.getRight() + left) - nextLineOffset;
            lineLeft = (this.currentPositionOffset * nextTabLeft) + ((1.0f - this.currentPositionOffset) * lineLeft);
            lineRight = (this.currentPositionOffset * nextTabRight) + ((1.0f - this.currentPositionOffset) * lineRight);
        }
        if (!AppBuildConfig.isHDApp(getContext())) {
            canvas.drawRect(lineLeft, height - this.indicatorHeight, lineRight, height, this.rectPaint);
        } else if (this.indicatorWidth == 0) {
            canvas.drawRoundRect(lineLeft, height - this.indicatorHeight, lineRight, height, this.indicatorRound, this.indicatorRound, this.rectPaint);
        } else {
            float tempLeft = (((lineRight - lineLeft) - this.indicatorWidth) / 2.0f) + lineLeft;
            if (tempLeft > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                canvas.drawRoundRect(tempLeft, height - this.indicatorHeight, tempLeft + this.indicatorWidth, height, this.indicatorRound, this.indicatorRound, this.rectPaint);
                return;
            }
            canvas.drawRoundRect(lineLeft, height - this.indicatorHeight, lineRight, height, this.indicatorRound, this.indicatorRound, this.rectPaint);
        }
    }

    public void setIndicatorEnable(boolean indicatorEnable) {
        this.indicatorEnable = indicatorEnable;
    }

    private float getLineOffset(View tabView) {
        if (!this.indicatorWrapContent) {
            return this.tabPadding;
        }
        int position = getPosition(tabView);
        if (position < 0) {
            return this.tabPadding;
        }
        Float width = (Float) this.cacheItemContentWidth.get(position);
        if (width == null || width.floatValue() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            width = Float.valueOf(measureTabItemWidth(tabView));
        }
        if (width.floatValue() <= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
            return this.tabPadding;
        }
        this.cacheItemContentWidth.put(position, width);
        return ((tabView.getMeasuredWidth() - width.floatValue()) / 2.0f) - this.indicatorWrapOffset;
    }

    protected int getPosition(View tab) {
        Object tag = tab.getTag();
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public class PageListener implements ViewPager.OnPageChangeListener {
        protected PageListener() {
        }

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (position >= PagerSlidingTabStrip.this.tabsContainer.getChildCount()) {
                return;
            }
            PagerSlidingTabStrip.this.currentPosition = PagerSlidingTabStrip.this.pagerPosToCurrentPos(position);
            PagerSlidingTabStrip.this.currentPositionOffset = positionOffset;
            View child = PagerSlidingTabStrip.this.tabsContainer.getChildAt(position);
            int offSet = 0;
            if (child != null) {
                offSet = (int) (child.getWidth() * positionOffset);
            }
            PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.currentPosition, offSet);
            PagerSlidingTabStrip.this.invalidate();
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        public void onPageScrollStateChanged(int state) {
            if (state == 0) {
                PagerSlidingTabStrip.this.scrollToChild(PagerSlidingTabStrip.this.pagerPosToCurrentPos(PagerSlidingTabStrip.this.pager.getCurrentItem()), 0);
            }
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageScrollStateChanged(state);
            }
        }

        public void onPageSelected(int position) {
            int index = 0;
            while (index < PagerSlidingTabStrip.this.tabsContainer.getChildCount()) {
                PagerSlidingTabStrip.this.tabsContainer.getChildAt(index).setSelected(position == index);
                index++;
            }
            if (PagerSlidingTabStrip.this.delegatePageListener != null) {
                PagerSlidingTabStrip.this.delegatePageListener.onPageSelected(position);
            }
        }
    }

    @Deprecated
    public void setIndicatorColor(int indicatorColor) {
        this.indicatorColor = indicatorColor;
        invalidate();
    }

    public void setIndicatorColorResource(int resId) {
        this.colorId = resId;
        this.indicatorColor = getResources().getColor(resId);
        invalidate();
    }

    public int getIndicatorColor() {
        return this.indicatorColor;
    }

    public void setIndicatorHeight(int indicatorLineHeightPx) {
        this.indicatorHeight = indicatorLineHeightPx;
        invalidate();
    }

    public int getIndicatorHeight() {
        return this.indicatorHeight;
    }

    public void setScrollOffset(int scrollOffsetPx) {
        this.scrollOffset = scrollOffsetPx;
        invalidate();
    }

    public int getScrollOffset() {
        return this.scrollOffset;
    }

    public void setShouldExpand(boolean shouldExpand) {
        this.shouldExpand = shouldExpand;
        requestLayout();
    }

    public boolean getShouldExpand() {
        return this.shouldExpand;
    }

    public boolean isTextAllCaps() {
        return this.textAllCaps;
    }

    public void setAllCaps(boolean textAllCaps) {
        this.textAllCaps = textAllCaps;
    }

    public void setTabTextAppearance(int textAppearance) {
        this.tabTextAppearance = textAppearance;
        updateTabStyles();
    }

    public void setTabBackground(int resId) {
        this.tabBackgroundResId = resId;
    }

    public int getTabBackground() {
        return this.tabBackgroundResId;
    }

    public void setTabPaddingLeftRight(int paddingPx) {
        this.tabPadding = paddingPx;
        updateTabStyles();
    }

    public int getTabPaddingLeftRight() {
        return this.tabPadding;
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        SavedState savedState = (SavedState) state;
        this.currentPosition = savedState.currentPosition;
        Parcelable superState = savedState.getSuperState();
        try {
            Field isLayoutRtl = superState.getClass().getDeclaredField("isLayoutRtl");
            isLayoutRtl.setBoolean(superState, false);
        } catch (Exception e) {
        }
        super.onRestoreInstanceState(superState);
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        SavedState savedState = new SavedState(superState);
        savedState.currentPosition = this.currentPosition;
        return savedState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: tv.danmaku.bili.widget.PagerSlidingTabStrip.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        int currentPosition;

        public SavedState(Parcelable superState) {
            super(superState);
        }

        private SavedState(Parcel in) {
            super(in);
            this.currentPosition = in.readInt();
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            super.writeToParcel(dest, flags);
            dest.writeInt(this.currentPosition);
        }
    }

    public void tint() {
        int newColor;
        if (this.colorId != 0 && (newColor = ThemeUtils.getColorById(getContext(), this.colorId)) != this.indicatorColor) {
            setIndicatorColor(newColor);
        }
    }
}