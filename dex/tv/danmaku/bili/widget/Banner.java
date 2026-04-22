package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import tv.danmaku.bili.videopage.common.widget.TripleCustomBubble;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class Banner extends RoundRectFrameLayout implements Handler.Callback, ViewPager.OnPageChangeListener {
    private static final int BANNER_FLIP_INTERVAL = 2500;
    private static final int BANNER_START_DELAY = 1500;
    private static final int BANNER_TOTAL_COUNT = Integer.MAX_VALUE;
    public static final int INDEX_INDICATOR = 1;
    public static final int INDEX_PAGER = 0;
    private static final int MSG_FLIP = 110;
    private static final int POSITION_OFFSET = 10000;
    private static final int[] SPACING_ATTRS = {com.bilibili.lib.widget.R.attr.layout_spacing};
    private BannerPagerAdapter mAdapter;
    private int mAspectRadioHeight;
    private int mAspectRadioWidth;
    private List<BannerItem> mBannerChildren;
    private float mCurrentX;
    private float mCurrentY;
    private int mCustomBannerFlipInterval;
    private int mCustomBannerTotalCount;
    private boolean mEnableForceStop;
    private boolean mFliping;
    private Handler mHandler;
    private float mHeightRatio;
    private BannerIndicator mIndicator;
    private int mInnerPadding;
    private OnBannerClickListener mOnBannerClickListener;
    private OnBannerSlideListener mOnBannerSlideListener;
    private ViewPager mPager;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface BannerItem {
        View getView(ViewGroup viewGroup);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnBannerClickListener {
        void onClick(BannerItem bannerItem);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnBannerSlideListener {
        void onSlideTo(BannerItem bannerItem);
    }

    public Banner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCustomBannerFlipInterval = BANNER_FLIP_INTERVAL;
        this.mCustomBannerTotalCount = Integer.MAX_VALUE;
        this.mEnableForceStop = false;
        this.mAspectRadioWidth = 32;
        this.mAspectRadioHeight = 10;
        this.mBannerChildren = new ArrayList();
        init(context, attrs);
    }

    public Banner(Context context) {
        super(context);
        this.mCustomBannerFlipInterval = BANNER_FLIP_INTERVAL;
        this.mCustomBannerTotalCount = Integer.MAX_VALUE;
        this.mEnableForceStop = false;
        this.mAspectRadioWidth = 32;
        this.mAspectRadioHeight = 10;
        this.mBannerChildren = new ArrayList();
        init(context, null);
    }

    public Banner(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCustomBannerFlipInterval = BANNER_FLIP_INTERVAL;
        this.mCustomBannerTotalCount = Integer.MAX_VALUE;
        this.mEnableForceStop = false;
        this.mAspectRadioWidth = 32;
        this.mAspectRadioHeight = 10;
        this.mBannerChildren = new ArrayList();
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mHandler = new Handler(this);
        this.mInnerPadding = (int) TypedValue.applyDimension(1, 8.0f, context.getResources().getDisplayMetrics());
        applyAttr(context, attrs);
        initViewPager(context);
        initAdapter();
        this.mPager.setAdapter(this.mAdapter);
        initIndicator(context, attrs);
        this.mIndicator.setViewPager(this.mPager);
    }

    private void applyAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, com.bilibili.lib.widget.R.styleable.Banner);
        this.mAspectRadioWidth = array.getInt(com.bilibili.lib.widget.R.styleable.Banner_aspectRadioWidth, this.mAspectRadioWidth);
        this.mAspectRadioHeight = array.getInt(com.bilibili.lib.widget.R.styleable.Banner_aspectRadioHeight, this.mAspectRadioHeight);
        this.mCustomBannerFlipInterval = array.getInt(com.bilibili.lib.widget.R.styleable.Banner_flipInterval, BANNER_FLIP_INTERVAL);
        if (this.mCustomBannerFlipInterval < 0) {
            this.mCustomBannerFlipInterval = BANNER_FLIP_INTERVAL;
        }
        this.mCustomBannerTotalCount = array.getInt(com.bilibili.lib.widget.R.styleable.Banner_totalCount, Integer.MAX_VALUE);
        if (this.mCustomBannerTotalCount < 0) {
            this.mCustomBannerTotalCount = Integer.MAX_VALUE;
        }
        this.mHeightRatio = this.mAspectRadioHeight / this.mAspectRadioWidth;
        array.recycle();
        TypedArray array2 = context.obtainStyledAttributes(attrs, SPACING_ATTRS);
        this.mInnerPadding = array2.getDimensionPixelSize(0, this.mInnerPadding);
        array2.recycle();
    }

    private void initViewPager(Context context) {
        this.mPager = new ViewPager(context);
        this.mPager.setId(com.bilibili.lib.widget.R.id.pager);
        this.mPager.setPageMargin(this.mInnerPadding);
        this.mPager.setOffscreenPageLimit(1);
        addViewInLayout(this.mPager, 0, new ViewGroup.LayoutParams(-1, -1));
    }

    private void initIndicator(Context context, AttributeSet attrs) {
        this.mIndicator = new BannerIndicator(context, attrs);
        this.mIndicator.setOnPageChangeListener(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = 85;
        int padding = this.mInnerPadding;
        this.mIndicator.setRealSize(getCount());
        this.mIndicator.setPadding(padding, padding / 2, padding, padding / 2);
        addViewInLayout(this.mIndicator, 1, params, true);
    }

    public void setIndicatorGravity(int gravity) {
        if (this.mIndicator != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mIndicator.getLayoutParams();
            layoutParams.gravity = gravity;
            this.mIndicator.setLayoutParams(layoutParams);
        }
    }

    public void setIndicatorVisible(boolean visible) {
        if (this.mIndicator != null) {
            this.mIndicator.setVisibility(visible ? 0 : 8);
        }
    }

    public void setBannerFlipInterval(int interval) {
        if (interval <= 0) {
            this.mCustomBannerFlipInterval = BANNER_FLIP_INTERVAL;
        } else {
            this.mCustomBannerFlipInterval = interval;
        }
    }

    public void setIndicatorLayoutPadding(int left, int top, int right, int bottom) {
        if (this.mIndicator != null) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.mIndicator.setPadding((int) TypedValue.applyDimension(1, left, displayMetrics), (int) TypedValue.applyDimension(1, top, displayMetrics), (int) TypedValue.applyDimension(1, right, displayMetrics), (int) TypedValue.applyDimension(1, bottom, displayMetrics));
        }
    }

    protected void initAdapter() {
        if (this.mAdapter == null) {
            this.mAdapter = new BannerPagerAdapter(this.mBannerChildren, this.mCustomBannerTotalCount);
            this.mAdapter.setOnBannerClickListener(this.mOnBannerClickListener);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width * this.mHeightRatio);
        View pager = getChildAt(0);
        if (this.mBannerChildren != null && this.mBannerChildren.size() > 0) {
            measureChild(pager, View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        }
        View indicator = getChildAt(1);
        measureChild(indicator, View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
        setMeasuredDimension(width, height);
    }

    public void setOnBannerSlideListener(OnBannerSlideListener l) {
        this.mOnBannerSlideListener = l;
    }

    public void setOnBannerClickListener(OnBannerClickListener l) {
        this.mOnBannerClickListener = l;
        if (this.mAdapter != null) {
            this.mAdapter.setOnBannerClickListener(l);
        }
    }

    public void setHeightRatio(float heightRatio) {
        if (heightRatio != this.mHeightRatio) {
            this.mHeightRatio = heightRatio;
            requestLayout();
        }
    }

    public int getCount() {
        return this.mBannerChildren.size();
    }

    public void setCurrentItem(int position) {
        if (this.mBannerChildren.isEmpty()) {
            return;
        }
        if (this.mBannerChildren.size() == 1) {
            if (position == 10000) {
                BannerItem bannerItem = this.mBannerChildren.get(0);
                stopFlipping();
                if (this.mOnBannerSlideListener != null) {
                    this.mOnBannerSlideListener.onSlideTo(bannerItem);
                    return;
                }
                return;
            }
            return;
        }
        this.mIndicator.setCurrentItem(position);
    }

    public void showNextItem() {
        int currentPage = this.mIndicator.getCurrentPage();
        if (currentPage < 0) {
            currentPage += 10000;
        }
        setCurrentItem(currentPage + 1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                this.mCurrentY = ev.getY();
                this.mCurrentX = ev.getX();
                break;
            case 1:
            default:
                this.mCurrentY = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                this.mCurrentX = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
                break;
            case 2:
                if (this.mCurrentY > DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN) {
                    float dY = Math.abs(this.mCurrentY - ev.getY());
                    float dX = Math.abs(this.mCurrentX - ev.getX());
                    if (dY > 100.0f && dX < 100.0f) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    } else if (this.mAdapter != null && getParent() != null) {
                        getParent().requestDisallowInterceptTouchEvent(this.mAdapter.getCount() > 1);
                        break;
                    }
                }
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    public void addItem(BannerItem item) {
        this.mBannerChildren.add(item);
    }

    public void startFlipping() {
        this.mFliping = true;
        if (!this.mHandler.hasMessages(110)) {
            this.mHandler.sendEmptyMessageDelayed(110, TripleCustomBubble.PRE_ANIM_TIME);
        }
    }

    public void startFlippingWithDelay(int delay) {
        this.mFliping = true;
        if (!this.mHandler.hasMessages(110)) {
            this.mHandler.sendEmptyMessageDelayed(110, delay);
        }
    }

    public void startFlippingNow() {
        this.mFliping = true;
        this.mHandler.removeMessages(110);
        this.mHandler.sendEmptyMessageDelayed(110, 100L);
    }

    public void stopFlipping() {
        this.mFliping = false;
        this.mHandler.removeMessages(110);
    }

    public void stopFlipping(boolean enableForceStop) {
        this.mFliping = false;
        this.mEnableForceStop = enableForceStop;
        this.mHandler.removeMessages(110);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mFliping) {
            startFlipping();
        }
    }

    @Override // android.view.View
    public void onScreenStateChanged(int screenState) {
        super.onScreenStateChanged(screenState);
        if (screenState == 0) {
            this.mHandler.removeCallbacksAndMessages(null);
        } else if (this.mFliping) {
            startFlipping();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        if (msg.what == 110) {
            this.mHandler.removeMessages(110);
            boolean canFlip = true;
            if (this.mEnableForceStop && !this.mFliping) {
                canFlip = false;
            }
            if (canFlip) {
                if (this.mIndicator.isScrollIdle()) {
                    this.mHandler.sendEmptyMessageDelayed(110, this.mCustomBannerFlipInterval);
                    showNextItem();
                    return true;
                }
                this.mHandler.sendEmptyMessageDelayed(110, TripleCustomBubble.PRE_ANIM_TIME);
                return true;
            }
            return true;
        }
        return true;
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        if (this.mOnBannerSlideListener != null && this.mAdapter != null) {
            this.mOnBannerSlideListener.onSlideTo(this.mAdapter.getItem(position));
        }
    }

    public void onPageScrollStateChanged(int state) {
        if (this.mIndicator.isScrollIdle()) {
            this.mHandler.removeMessages(110);
            this.mHandler.sendEmptyMessageDelayed(110, this.mCustomBannerFlipInterval);
        }
    }

    public void setBannerItems(List<? extends BannerItem> banners) {
        int newSize = banners == null ? 0 : banners.size();
        int oldSize = this.mBannerChildren.size();
        if (newSize == 0) {
            return;
        }
        this.mBannerChildren.clear();
        this.mBannerChildren.addAll(banners);
        this.mIndicator.setRealSize(this.mBannerChildren.size());
        if (this.mAdapter != null) {
            this.mAdapter.setItems(this.mBannerChildren);
            this.mAdapter.notifyDataSetChanged();
        }
        if (oldSize == 0) {
            requestLayout();
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static abstract class BannerItemImpl implements BannerItem {
        private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
        SparseArray<View> itemViewCaches;

        public abstract View createItemView(ViewGroup viewGroup);

        public abstract void reuseItemView(View view2);

        private static int getViewId() {
            int result;
            int newValue;
            do {
                result = sNextGeneratedId.get();
                newValue = result + 1;
                if (newValue > 16777215) {
                    newValue = 1;
                }
            } while (!sNextGeneratedId.compareAndSet(result, newValue));
            return result;
        }

        @Override // tv.danmaku.bili.widget.Banner.BannerItem
        public final View getView(ViewGroup container) {
            if (this.itemViewCaches == null) {
                this.itemViewCaches = new SparseArray<>(4);
            }
            View itemView = null;
            for (int i = 0; i < this.itemViewCaches.size(); i++) {
                View itemView2 = this.itemViewCaches.valueAt(i);
                itemView = itemView2;
                if (itemView.getParent() == null) {
                    break;
                }
                itemView = null;
            }
            if (itemView == null) {
                itemView = createItemView(container);
                if (itemView.getId() == -1) {
                    itemView.setId(getViewId());
                }
                this.itemViewCaches.put(itemView.getId(), itemView);
            } else {
                reuseItemView(itemView);
            }
            return itemView;
        }

        public void onDestroy() {
            if (this.itemViewCaches != null) {
                this.itemViewCaches.clear();
                this.itemViewCaches = null;
            }
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class BannerPagerAdapter extends PagerAdapter implements View.OnClickListener {
        private List<BannerItem> mItems = new ArrayList(6);
        private OnBannerClickListener mOnBannerClickListener;
        private int totalCount;

        public BannerPagerAdapter(List<BannerItem> items, int totalCount) {
            setItems(items);
            this.totalCount = totalCount;
        }

        public int getItemPosition(Object object) {
            return -2;
        }

        public void setItems(List<BannerItem> items) {
            this.mItems.clear();
            this.mItems.addAll(items);
        }

        public void setOnBannerClickListener(OnBannerClickListener l) {
            this.mOnBannerClickListener = l;
        }

        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        public Object instantiateItem(ViewGroup container, int position) {
            BannerItem item = getItem(position);
            View view2 = item.getView(container);
            view2.setTag(item);
            view2.setOnClickListener(this);
            container.addView(view2);
            return view2;
        }

        public int getBannerPosition(int position) {
            return position % this.mItems.size();
        }

        public BannerItem getItem(int position) {
            return this.mItems.get(getBannerPosition(position));
        }

        public int getCount() {
            return this.totalCount;
        }

        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg1 == arg0;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (this.mOnBannerClickListener != null) {
                this.mOnBannerClickListener.onClick((BannerItem) v.getTag());
            }
        }
    }

    public ViewPager getPager() {
        return this.mPager;
    }
}