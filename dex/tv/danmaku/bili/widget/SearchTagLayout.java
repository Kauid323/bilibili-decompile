package tv.danmaku.bili.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bilibili.app.comm.list.widget.search.ISearchTag;
import com.bilibili.app.comm.list.widget.search.UrlToDrawableHelper;
import com.bilibili.lib.ui.util.NightTheme;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import java.util.List;
import tv.danmaku.bili.widget.FlowLayout;
import tv.danmaku.bili.widget.SearchTagLayout;

public class SearchTagLayout extends FlowLayout {
    public static final int DEFAULT_WORD_KEY = 1;
    public static final int DEFINE_UI_WORD_KEY = 6;
    public static final int HOT_WORD_KEY = 2;
    private static final int KEY_POS = 1593835520;
    public static final int MOST_HOT_WORD_KEY = 5;
    public static final int MOST_NEW_WORD_KEY = 4;
    public static final int SPECIALS_BACKGROUND_COLOR_WORD_KEY = 3;
    private boolean hasDelete;
    private List<?> mData;
    private SearchTagView.TagClickListener mTagSelectedListener;

    public SearchTagLayout(Context context) {
        this(context, null);
    }

    public SearchTagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchTagLayout(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        this.hasDelete = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // tv.danmaku.bili.widget.FlowLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < this.lines.size(); i++) {
            FlowLayout.LineDefinition line = this.lines.get(i);
            for (int j = 0; j < line.viewCount; j++) {
                View child = line.views[j];
                FlowLayout.LayoutParams lp = (FlowLayout.LayoutParams) child.getLayoutParams();
                child.layout(lp.x + lp.leftMargin, lp.y + lp.topMargin, lp.x + lp.leftMargin + child.getMeasuredWidth(), lp.y + lp.topMargin + child.getMeasuredHeight());
            }
        }
    }

    public int getLinesViewCount() {
        int count = 0;
        for (int i = 0; i < this.lines.size(); i++) {
            count += this.lines.get(i).viewCount;
        }
        return count;
    }

    public int getLineViewCount(int index) {
        if (this.lines.size() > index) {
            return this.lines.get(index).viewCount;
        }
        return 0;
    }

    public void setHasDelete(boolean value) {
        this.hasDelete = value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [tv.danmaku.bili.widget.SearchTagLayout$SearchTagView, android.view.View] */
    public void setData(List<?> data) {
        if (this.mData != data) {
            if (this.mData != null) {
                removeAllViewsInLayout();
            }
            if (data == null) {
                removeAllViewsInLayout();
            } else {
                int index = 0;
                for (int i = 0; i < data.size(); i++) {
                    Object item = data.get(i);
                    if ((item instanceof ISearchTag) && !TextUtils.isEmpty(((ISearchTag) item).getTagName())) {
                        ISearchTag searchTag = (ISearchTag) item;
                        ?? searchTagView = new SearchTagView(getContext());
                        searchTagView.setHasDelete(this.hasDelete);
                        searchTagView.bindData(searchTag);
                        searchTagView.setOnTagClickListener(this.mTagSelectedListener);
                        searchTagView.setTag(KEY_POS, Integer.valueOf(index));
                        addViewInLayout(searchTagView, -1, generateDefaultLayoutParams(), true);
                        index++;
                    }
                }
            }
            this.mData = data;
            requestLayout();
            invalidate();
        }
    }

    public void setOnTagSelectedListener(SearchTagView.TagClickListener l) {
        this.mTagSelectedListener = l;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SearchTagView extends TintFrameLayout {
        public static final int STATE_EDIT = 2;
        public static final int STATE_NORMAL = 0;
        private ISearchTag mData;
        private ImageView mDelIcon;
        private UrlToDrawableHelper mHelper;
        private int mState;
        private TagClickListener mTagClickListener;
        private VectorTextView mTagName;

        public void setHasDelete(boolean hasDelete) {
            if (hasDelete) {
                setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.widget.SearchTagLayout$SearchTagView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return SearchTagLayout.SearchTagView.this.m2044lambda$setHasDelete$0$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(view2);
                    }
                });
                this.mDelIcon.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchTagLayout$SearchTagView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchTagLayout.SearchTagView.this.m2045lambda$setHasDelete$1$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(view2);
                    }
                });
                return;
            }
            setOnLongClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$setHasDelete$0$tv-danmaku-bili-widget-SearchTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ boolean m2044lambda$setHasDelete$0$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(View v) {
            if (this.mState == 2) {
                return true;
            }
            if (this.mTagClickListener != null) {
                this.mTagClickListener.onLongClick(this, -1, this.mData);
            }
            ViewGroup parent = (ViewGroup) getParent();
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                if (child instanceof SearchTagView) {
                    ((SearchTagView) child).setState(0);
                }
            }
            setState(2);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: lambda$setHasDelete$1$tv-danmaku-bili-widget-SearchTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ void m2045lambda$setHasDelete$1$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(View v) {
            if (this.mTagClickListener != null && v.isClickable() && v.isShown()) {
                ViewParent parent = getParent();
                if (parent instanceof SearchTagLayout) {
                    ((SearchTagLayout) parent).removeView(this);
                }
                if (this.mTagClickListener != null) {
                    Object tag = getTag(SearchTagLayout.KEY_POS);
                    int position = tag instanceof Integer ? ((Integer) tag).intValue() : -1;
                    this.mTagClickListener.onDelIconClick(this, position, this.mData);
                }
            }
        }

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public interface TagClickListener {
            void onDelIconClick(SearchTagView searchTagView, int i, ISearchTag iSearchTag);

            void onLongClick(SearchTagView searchTagView, int i, ISearchTag iSearchTag);

            void onTagClick(SearchTagView searchTagView, int i, ISearchTag iSearchTag);

            /* renamed from: tv.danmaku.bili.widget.SearchTagLayout$SearchTagView$TagClickListener$-CC  reason: invalid class name */
            /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
            public final /* synthetic */ class CC {
                public static void $default$onLongClick(TagClickListener _this, SearchTagView view2, int index, ISearchTag tag) {
                }
            }
        }

        public SearchTagView(Context context, int layoutId) {
            super(context);
            init(context, layoutId);
        }

        public SearchTagView(Context context) {
            super(context);
            init(context);
        }

        public SearchTagView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public SearchTagView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            init(context, com.bilibili.app.comm.listwidget.R.layout.bili_app_layout_search_discover_tag);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void init(Context context, int layoutId) {
            LayoutInflater.from(context).inflate(layoutId, (ViewGroup) this, true);
            this.mTagName = (VectorTextView) findViewById(com.bilibili.app.comm.listwidget.R.id.tag_name);
            setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchTagLayout$SearchTagView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchTagLayout.SearchTagView.this.m2043lambda$init$2$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(view2);
                }
            });
            this.mTagName.setEllipsize(TextUtils.TruncateAt.END);
            this.mDelIcon = (ImageView) findViewById(com.bilibili.app.comm.listwidget.R.id.img_delete);
            this.mDelIcon.setVisibility(8);
            this.mHelper = new UrlToDrawableHelper();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$init$2$tv-danmaku-bili-widget-SearchTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ void m2043lambda$init$2$tvdanmakubiliwidgetSearchTagLayout$SearchTagView(View v) {
            if (this.mTagClickListener != null) {
                setState(0);
                Object tag = getTag(SearchTagLayout.KEY_POS);
                int position = tag instanceof Integer ? ((Integer) tag).intValue() : -1;
                this.mTagClickListener.onTagClick(this, position, this.mData);
            }
        }

        public void setState(int state) {
            if (this.mState == state) {
                return;
            }
            this.mState = state;
            if (this.mState == 0) {
                this.mDelIcon.setVisibility(8);
                this.mDelIcon.setClickable(false);
            } else if (this.mState == 2) {
                this.mDelIcon.setVisibility(0);
                this.mDelIcon.setClickable(true);
            }
        }

        public void bindData(ISearchTag tag) {
            this.mData = tag;
            setState(tag.getState());
            String text = tag.getTagName();
            String nameType = tag.getNameType();
            String iconUrl = tag.getIconUrl();
            Resources res = this.mTagName.getContext().getResources();
            int wordType = tag.getWordType();
            switch (wordType) {
                case 1:
                    this.mTagName.setPadding((int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0, (int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0);
                    this.mTagName.setText(text);
                    return;
                case 2:
                    this.mTagName.setPadding((int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0, (int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0);
                    Drawable drawable = res.getDrawable(com.bilibili.app.comm.listwidget.R.drawable.ic_search_hot_keyword);
                    if (NightTheme.isNightTheme(this.mTagName.getContext())) {
                        drawable.setAlpha(179);
                    }
                    this.mTagName.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
                    this.mTagName.setText(text);
                    return;
                case 3:
                    this.mTagName.setPadding((int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0, (int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0);
                    GradientDrawable drawableColor = new GradientDrawable();
                    drawableColor.setCornerRadius((int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_hot_radius));
                    drawableColor.setColor(res.getColor(com.bilibili.lib.theme.R.color.Or1));
                    this.mTagName.setBackgroundDrawable(drawableColor);
                    this.mTagName.setTextColor(res.getColor(com.bilibili.lib.theme.R.color.Or5));
                    this.mTagName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    this.mTagName.setText(text);
                    return;
                case 4:
                case 5:
                case 6:
                    this.mTagName.setPadding((int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0, (int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0);
                    Drawable mDefaultDrawable = new ColorDrawable(res.getColor(com.bilibili.lib.theme.R.color.Ga2));
                    mDefaultDrawable.setBounds(0, 0, (int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_16), (int) res.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_16));
                    if (NightTheme.isNightTheme(this.mTagName.getContext())) {
                        mDefaultDrawable.setAlpha(179);
                    }
                    this.mTagName.setCompoundDrawables(mDefaultDrawable, null, null, null);
                    this.mTagName.setText(text);
                    if (!TextUtils.isEmpty(iconUrl) && !isBlank(iconUrl)) {
                        this.mHelper.loadIcon(this.mTagName.getContext(), this.mTagName, iconUrl);
                        return;
                    }
                    return;
                default:
                    if (!TextUtils.isEmpty(nameType)) {
                        SpannableStringBuilder spanStr = new SpannableStringBuilder(nameType);
                        spanStr.setSpan(new ForegroundColorSpan(getResources().getColor(com.bilibili.lib.theme.R.color.Ga5)), 0, nameType.length(), 17);
                        spanStr.append((CharSequence) text);
                        this.mTagName.setText(spanStr);
                        this.mTagName.setPadding((int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0, (int) getResources().getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0);
                        this.mTagName.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        return;
                    }
                    int iconRes = tag.getStatusIcon();
                    Resources res1 = this.mTagName.getContext().getResources();
                    Drawable drawable1 = null;
                    if (iconRes != 0) {
                        this.mTagName.setPadding((int) res1.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0, (int) res1.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_12), 0);
                        drawable1 = res1.getDrawable(iconRes);
                        if (NightTheme.isNightTheme(this.mTagName.getContext())) {
                            drawable1.setAlpha(179);
                        }
                    } else {
                        this.mTagName.setPadding((int) res1.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0, (int) res1.getDimension(com.bilibili.app.comm.listwidget.R.dimen.search_margin_14), 0);
                    }
                    this.mTagName.setCompoundDrawablesWithIntrinsicBounds(drawable1, null, null, null);
                    this.mTagName.setText(text);
                    return;
            }
        }

        public void setOnTagClickListener(TagClickListener listener) {
            this.mTagClickListener = listener;
        }

        private static boolean isBlank(CharSequence cs) {
            int strLen;
            if (cs == null || (strLen = cs.length()) == 0) {
                return true;
            }
            for (int i = 0; i < strLen; i++) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}