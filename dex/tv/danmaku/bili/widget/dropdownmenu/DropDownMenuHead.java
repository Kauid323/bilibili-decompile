package tv.danmaku.bili.widget.dropdownmenu;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.widget.R;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.bili.widget.SpacesItemDecoration;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;

public class DropDownMenuHead extends RelativeLayout implements ValueAnimator.AnimatorUpdateListener, Animation.AnimationListener, BaseAdapter.HandleClickListener {
    private static final int SPAN_COUNT = 4;
    private boolean hideIndicator;
    protected boolean isAniming;
    private BaseSubMenuAdapter mAdapter;
    private int mBgColor;
    protected int mCurrentMenu;
    private IndicatorPoint mCurrentP;
    protected boolean mFirstClickMenuItem;
    private ImageView mIndicator;
    private long mIndicatorAnimDuration;
    private boolean mIndicatorAnimEnable;
    private boolean mIndicatorBounceEnable;
    private Rect mIndicatorRect;
    private int mIndicatorWidth;
    private OvershootInterpolator mInterpolator;
    private int mLastMenu;
    private IndicatorPoint mLastP;
    private View mLine;
    private int mLineColor;
    private OnMenuItemClickListener mListener;
    protected View mMask;
    protected Animation mMaskInAnim;
    protected Animation mMaskOutAnim;
    private LinearLayout mMenuContainer;
    protected Animation mMenuInAnim;
    protected ArrayList<DropDownMenuItem> mMenuItems;
    protected Animation mMenuOutAnim;
    protected RecyclerView mRecyclerView;
    private int mSpanCount;
    private OnSubMenuItemClickListener mSubListener;
    private ArrayList<DropDownMenuItem> mSubMenuItems;
    private int mTabCount;
    private ValueAnimator mValueAnimator;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnMenuItemClickListener {
        void onMenuItemClick(int i);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface OnSubMenuItemClickListener {
        void onSubMenuItemClick(int i, int i2, String str, DropDownMenuItem dropDownMenuItem);
    }

    public DropDownMenuHead(Context context) {
        this(context, null, 0);
    }

    public DropDownMenuHead(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DropDownMenuHead(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMenuItems = new ArrayList<>();
        this.mSubMenuItems = new ArrayList<>();
        this.mIndicatorRect = new Rect();
        this.mInterpolator = new OvershootInterpolator(1.0f);
        this.mSpanCount = 4;
        this.hideIndicator = false;
        this.mCurrentP = new IndicatorPoint();
        this.mLastP = new IndicatorPoint();
        obtainAttrs(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.bili_app_layout_drop_down_menu_head, (ViewGroup) this, true);
        this.mMenuContainer = (LinearLayout) findViewById(R.id.menu_container);
        this.mLine = findViewById(R.id.line);
        this.mIndicator = (ImageView) findViewById(R.id.indicator);
        this.mMenuContainer.setBackgroundColor(this.mBgColor);
        this.mLine.setBackgroundColor(this.mLineColor);
        this.mMaskInAnim = createFadeInAnim();
        this.mMaskOutAnim = createFadeOutAnim();
        this.mMenuInAnim = createTopInAnim();
        this.mMenuInAnim.setAnimationListener(this);
        this.mMenuOutAnim = createTopOutAnim();
        this.mMenuOutAnim.setAnimationListener(this);
        this.mIndicatorWidth = dp2px(14.5f);
        this.mValueAnimator = ValueAnimator.ofObject(new PointEvaluator(), this.mLastP, this.mCurrentP);
        this.mValueAnimator.addUpdateListener(this);
        this.mIndicatorAnimEnable = true;
        this.mIndicatorBounceEnable = true;
        this.mFirstClickMenuItem = true;
    }

    private void obtainAttrs(Context context, AttributeSet attrs) {
        TypedArray ta;
        if (attrs != null && (ta = context.obtainStyledAttributes(attrs, R.styleable.DropDownMenuHead)) != null) {
            this.mBgColor = ta.getColor(R.styleable.DropDownMenuHead_bgColor, Color.parseColor("#fafafa"));
            this.mLineColor = ta.getColor(R.styleable.DropDownMenuHead_lineColor, Color.parseColor("#bdbdbd"));
            ta.recycle();
        }
    }

    public void setFilterData(DropDownMenuContent dropDownMenuContent, ArrayList<? extends DropDownMenuItem> menuItems) {
        setFilterData(dropDownMenuContent, menuItems, null);
    }

    public void setFilterData(DropDownMenuContent dropDownMenuContent, ArrayList<? extends DropDownMenuItem> menuItems, BaseSubMenuAdapter adapter) {
        if (dropDownMenuContent == null || dropDownMenuContent.getRecyclerView() == null || dropDownMenuContent.getMask() == null) {
            throw new IllegalStateException("DropDownMenuContent not exist !");
        }
        if (menuItems == null || menuItems.size() == 0) {
            throw new IllegalStateException("menuItems can not be NULL or EMPTY !");
        }
        this.mRecyclerView = dropDownMenuContent.getRecyclerView();
        int spanCount = dropDownMenuContent.getSpanCount();
        if (spanCount != -1) {
            this.mSpanCount = spanCount;
        }
        RecyclerView.ItemDecoration itemDecoration = dropDownMenuContent.getItemDecoration();
        if (itemDecoration != null) {
            this.mRecyclerView.addItemDecoration(itemDecoration);
        } else {
            this.mRecyclerView.addItemDecoration(new SpacesItemDecoration(getResources().getDimensionPixelSize(com.bilibili.app.comm.baseres.R.dimen.item_spacing), this.mSpanCount));
        }
        if (adapter != null) {
            this.mAdapter = adapter;
        } else {
            this.mAdapter = new DefaultSubMenuAdapter();
        }
        this.mAdapter.setHandleClickListener(this);
        this.mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), this.mSpanCount));
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mMask = dropDownMenuContent.getMask();
        this.mMask.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.dropdownmenu.DropDownMenuHead.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                DropDownMenuHead.this.hide();
            }
        });
        this.mMenuItems.clear();
        this.mMenuItems.addAll(menuItems);
        initFilterItems();
    }

    private void initFilterItems() {
        this.mMenuContainer.removeAllViews();
        this.mTabCount = this.mMenuItems.size();
        for (int i = 0; i < this.mTabCount; i++) {
            View itemView = View.inflate(getContext(), R.layout.bili_app_layout_drop_down_menu_item, null);
            itemView.setTag(Integer.valueOf(i));
            addTab(i, itemView);
        }
        updateTabStyles(true);
    }

    private void addTab(int position, View itemView) {
        itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.dropdownmenu.DropDownMenuHead.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (DropDownMenuHead.this.isAniming) {
                    return;
                }
                int position2 = ((Integer) v.getTag()).intValue();
                boolean isCurrent = position2 == DropDownMenuHead.this.mCurrentMenu;
                DropDownMenuHead.this.setCurrentMenu(position2);
                int i = 0;
                while (i < DropDownMenuHead.this.mMenuItems.size()) {
                    DropDownMenuHead.this.mMenuItems.get(i).isSelect = position2 == i;
                    i++;
                }
                DropDownMenuHead.this.updateTabStyles(false);
                if (DropDownMenuHead.this.mListener != null) {
                    DropDownMenuHead.this.mListener.onMenuItemClick(position2);
                }
                DropDownMenuHead.this.setRecyclerView(position2);
                if (DropDownMenuHead.this.mRecyclerView.getVisibility() != 0) {
                    DropDownMenuHead.this.show();
                } else if (isCurrent) {
                    DropDownMenuHead.this.hide();
                }
            }
        });
        LinearLayout.LayoutParams lp_tab = new LinearLayout.LayoutParams(0, -1, 1.0f);
        this.mMenuContainer.addView(itemView, position, lp_tab);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRecyclerView(int position) {
        DropDownMenuItem menuItem = this.mMenuItems.get(position);
        if (menuItem != null && menuItem.subMenuItems != null && menuItem.subMenuItems.size() > 0) {
            this.mSubMenuItems.clear();
            this.mSubMenuItems.addAll(menuItem.subMenuItems);
            this.mAdapter.setSubMenuData(this.mSubMenuItems);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    @Override // tv.danmaku.bili.widget.section.adapter.BaseAdapter.HandleClickListener
    public void handleClick(final BaseViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.dropdownmenu.DropDownMenuHead.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int layoutPosition = holder.getLayoutPosition();
                int i = 0;
                while (true) {
                    if (i >= DropDownMenuHead.this.mSubMenuItems.size()) {
                        break;
                    }
                    DropDownMenuItem dropDownMenuItem = (DropDownMenuItem) DropDownMenuHead.this.mSubMenuItems.get(i);
                    if (i != layoutPosition) {
                        r3 = false;
                    }
                    dropDownMenuItem.isSelect = r3;
                    i++;
                }
                DropDownMenuHead.this.mAdapter.notifyDataSetChanged();
                DropDownMenuHead.this.hide();
                View tabView = DropDownMenuHead.this.mMenuContainer.getChildAt(DropDownMenuHead.this.mCurrentMenu);
                TextView menu = (TextView) tabView.findViewById(R.id.menu);
                ImageView arrow = (ImageView) tabView.findViewById(R.id.arrow);
                DropDownMenuItem dropDownMenuItem2 = (DropDownMenuItem) DropDownMenuHead.this.mSubMenuItems.get(layoutPosition);
                String menuName = dropDownMenuItem2.name;
                menu.setText(menuName);
                menu.setSelected(layoutPosition != 0);
                arrow.setSelected(false);
                if (DropDownMenuHead.this.mSubListener != null) {
                    DropDownMenuHead.this.mSubListener.onSubMenuItemClick(DropDownMenuHead.this.mCurrentMenu, layoutPosition, menuName, dropDownMenuItem2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTabStyles(boolean init) {
        for (int i = 0; i < this.mTabCount; i++) {
            View tabView = this.mMenuContainer.getChildAt(i);
            TextView menu = (TextView) tabView.findViewById(R.id.menu);
            ImageView arrow = (ImageView) tabView.findViewById(R.id.arrow);
            if (init) {
                menu.setText(this.mMenuItems.get(i).name);
                List<DropDownMenuItem> menuItemList = this.mMenuItems.get(i).subMenuItems;
                int m = 0;
                while (true) {
                    if (menuItemList == null || m >= menuItemList.size()) {
                        break;
                    }
                    DropDownMenuItem item = menuItemList.get(m);
                    if (item == null || !item.isSelect) {
                        m++;
                    } else if (m != 0) {
                        menu.setText(item.name);
                        menu.setSelected(true);
                    }
                }
            }
            if (this.mMenuItems.get(i).subMenuItems != null && !this.mMenuItems.get(i).subMenuItems.isEmpty() && this.mMenuItems.get(i).subMenuItems.get(0).isSelect) {
                menu.setSelected(this.mMenuItems.get(i).isSelect);
            }
            arrow.setSelected(this.mMenuItems.get(i).isSelect);
        }
    }

    public void show() {
        if (isShowing() || this.isAniming) {
            return;
        }
        this.mMask.setVisibility(0);
        this.mMask.startAnimation(this.mMaskInAnim);
        this.mRecyclerView.setVisibility(0);
        this.mRecyclerView.startAnimation(this.mMenuInAnim);
    }

    public void hide() {
        if (!isShowing() || this.isAniming) {
            return;
        }
        this.mMenuItems.get(this.mCurrentMenu).isSelect = false;
        ImageView arrow = (ImageView) this.mMenuContainer.getChildAt(this.mCurrentMenu).findViewById(R.id.arrow);
        arrow.setSelected(false);
        List<DropDownMenuItem> subMenuItems = this.mMenuItems.get(this.mCurrentMenu).subMenuItems;
        if (subMenuItems != null && !subMenuItems.isEmpty() && subMenuItems.get(0).isSelect) {
            this.mMenuContainer.getChildAt(this.mCurrentMenu).findViewById(R.id.menu).setSelected(false);
        }
        this.mMask.startAnimation(this.mMaskOutAnim);
        this.mMask.setVisibility(8);
        this.mRecyclerView.startAnimation(this.mMenuOutAnim);
        this.mRecyclerView.setVisibility(8);
        this.mIndicator.setVisibility(8);
        this.mFirstClickMenuItem = true;
    }

    public boolean isShowing() {
        return this.mRecyclerView != null && this.mRecyclerView.getVisibility() == 0;
    }

    public void setHideIndicator(boolean hide) {
        this.hideIndicator = hide;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        this.isAniming = true;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.isAniming = false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    public void setCurrentMenu(int currentMenu) {
        this.mLastMenu = this.mCurrentMenu;
        this.mCurrentMenu = currentMenu;
        if (this.mIndicator.getVisibility() != 0 && !this.hideIndicator) {
            this.mIndicator.setVisibility(0);
        }
        if (this.mIndicatorAnimEnable) {
            if (this.mFirstClickMenuItem) {
                this.mFirstClickMenuItem = false;
                this.mLastMenu = this.mCurrentMenu;
            }
            calcOffset();
            return;
        }
        calcIndicatorRectAndSet();
    }

    public void setBgColor(int bgColor) {
        this.mBgColor = bgColor;
        this.mMenuContainer.setBackgroundColor(this.mBgColor);
    }

    public void setLineColor(int lineColor) {
        this.mLineColor = lineColor;
        this.mLine.setBackgroundColor(this.mLineColor);
    }

    private void calcOffset() {
        View currentTabView = this.mMenuContainer.getChildAt(this.mCurrentMenu);
        this.mCurrentP.left = currentTabView.getLeft();
        this.mCurrentP.right = currentTabView.getRight();
        View lastTabView = this.mMenuContainer.getChildAt(this.mLastMenu);
        this.mLastP.left = lastTabView.getLeft();
        this.mLastP.right = lastTabView.getRight();
        if (this.mLastP.left == this.mCurrentP.left && this.mLastP.right == this.mCurrentP.right) {
            calcIndicatorRectAndSet();
            return;
        }
        this.mValueAnimator.setObjectValues(this.mLastP, this.mCurrentP);
        if (this.mIndicatorBounceEnable) {
            this.mValueAnimator.setInterpolator(this.mInterpolator);
        }
        if (this.mIndicatorAnimDuration <= 0) {
            this.mIndicatorAnimDuration = this.mIndicatorBounceEnable ? 600L : 250L;
        }
        this.mValueAnimator.setDuration(this.mIndicatorAnimDuration);
        this.mValueAnimator.start();
    }

    private void calcIndicatorRectAndSet() {
        View currentTabView = this.mMenuContainer.getChildAt(this.mCurrentMenu);
        this.mIndicatorRect.left = currentTabView.getLeft() + ((currentTabView.getWidth() - this.mIndicatorWidth) / 2);
        this.mIndicatorRect.right = this.mIndicatorRect.left + this.mIndicatorWidth;
        this.mIndicator.setX(this.mIndicatorRect.left);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        View currentTabView = this.mMenuContainer.getChildAt(this.mCurrentMenu);
        IndicatorPoint p = (IndicatorPoint) animation.getAnimatedValue();
        this.mIndicatorRect.left = (int) p.left;
        this.mIndicatorRect.right = (int) p.right;
        float indicatorLeft = p.left + ((currentTabView.getWidth() - this.mIndicatorWidth) / 2);
        this.mIndicatorRect.left = (int) indicatorLeft;
        this.mIndicatorRect.right = this.mIndicatorRect.left + this.mIndicatorWidth;
        this.mIndicator.setX(this.mIndicatorRect.left);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    class PointEvaluator implements TypeEvaluator<IndicatorPoint> {
        PointEvaluator() {
        }

        @Override // android.animation.TypeEvaluator
        public IndicatorPoint evaluate(float fraction, IndicatorPoint startValue, IndicatorPoint endValue) {
            float left = startValue.left + ((endValue.left - startValue.left) * fraction);
            float right = startValue.right + ((endValue.right - startValue.right) * fraction);
            IndicatorPoint point = new IndicatorPoint();
            point.left = left;
            point.right = right;
            return point;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class IndicatorPoint {
        public float left;
        public float right;

        IndicatorPoint() {
        }
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        this.mListener = listener;
    }

    public void setOnSubMenuItemClickListener(OnSubMenuItemClickListener listener) {
        this.mSubListener = listener;
    }

    protected int dp2px(float dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) ((dp * scale) + 0.5f);
    }

    private Animation createFadeInAnim() {
        AlphaAnimation anim = new AlphaAnimation((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1.0f);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(200L);
        anim.setFillAfter(false);
        return anim;
    }

    private Animation createFadeOutAnim() {
        AlphaAnimation anim = new AlphaAnimation(1.0f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        anim.setInterpolator(new AccelerateInterpolator());
        anim.setDuration(200L);
        anim.setFillAfter(false);
        return anim;
    }

    private Animation createTopInAnim() {
        TranslateAnimation anim = new TranslateAnimation(1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, -1.0f, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(300L);
        anim.setFillAfter(false);
        return anim;
    }

    private Animation createTopOutAnim() {
        TranslateAnimation anim = new TranslateAnimation(1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, -1.0f);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.setDuration(200L);
        anim.setFillAfter(false);
        return anim;
    }
}