package tv.danmaku.bili.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bilibili.magicasakura.widgets.TintFrameLayout;
import java.util.List;
import tv.danmaku.bili.widget.FlowLayout;
import tv.danmaku.bili.widget.SearchPreTagLayout;

public class SearchPreTagLayout extends FlowLayout {
    private static final int KEY_POS = 1593835520;
    private boolean hasDelete;
    private List<?> mData;
    private SearchTagView.TagClickListener mTagSelectedListener;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface ISearchTag {
        String getTagName();
    }

    public SearchPreTagLayout(Context context) {
        this(context, null);
    }

    public SearchPreTagLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SearchPreTagLayout(Context context, AttributeSet attributeSet, int defStyle) {
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
    /* JADX WARN: Type inference failed for: r3v5, types: [android.view.View, tv.danmaku.bili.widget.SearchPreTagLayout$SearchTagView] */
    public void setData(List<?> data, Style style) {
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
                    ?? searchTagView = new SearchTagView(getContext(), style);
                    searchTagView.setHasDelete(this.hasDelete);
                    searchTagView.bindData((ISearchTag) item);
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

    public List<?> getData() {
        return this.mData;
    }

    public void setOnTagSelectedListener(SearchTagView.TagClickListener l) {
        this.mTagSelectedListener = l;
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum Style {
        OLD(com.bilibili.bplus.followingcard.R.layout.bili_app_layout_search_discover_tag_holder),
        NEW(com.bilibili.bplus.followingcard.R.layout.bili_new_search_discover_tag_holder);
        
        private final int layoutId;

        Style(int layoutId) {
            this.layoutId = layoutId;
        }

        public int getLayoutId() {
            return this.layoutId;
        }
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static class SearchTagView extends TintFrameLayout {
        public static final int STATE_EDIT = 2;
        public static final int STATE_NORMAL = 0;
        private ISearchTag mData;
        private ImageView mDelIcon;
        private int mState;
        private TagClickListener mTagClickListener;
        private TextView mTagName;

        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public interface TagClickListener {
            void onDelIconClick(SearchTagView searchTagView, int i, ISearchTag iSearchTag);

            void onTagClick(SearchTagView searchTagView, int i, ISearchTag iSearchTag);
        }

        public void setHasDelete(boolean hasDelete) {
            if (hasDelete) {
                this.mTagName.setOnLongClickListener(new View.OnLongClickListener() { // from class: tv.danmaku.bili.widget.SearchPreTagLayout$SearchTagView$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view2) {
                        return SearchPreTagLayout.SearchTagView.this.m2041lambda$setHasDelete$0$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(view2);
                    }
                });
                this.mDelIcon.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchPreTagLayout$SearchTagView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SearchPreTagLayout.SearchTagView.this.m2042lambda$setHasDelete$1$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(view2);
                    }
                });
                return;
            }
            setOnLongClickListener(null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$setHasDelete$0$tv-danmaku-bili-widget-SearchPreTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ boolean m2041lambda$setHasDelete$0$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(View v) {
            if (this.mState == 2) {
                return true;
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
        /* renamed from: lambda$setHasDelete$1$tv-danmaku-bili-widget-SearchPreTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ void m2042lambda$setHasDelete$1$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(View v) {
            if (this.mTagClickListener != null && v.isClickable() && v.isShown()) {
                ViewGroup parent = (ViewGroup) getParent();
                parent.removeView(this);
                if (this.mTagClickListener != null) {
                    this.mTagClickListener.onDelIconClick(this, ((Integer) getTag(SearchPreTagLayout.KEY_POS)).intValue(), this.mData);
                }
            }
        }

        public SearchTagView(Context context, Style style) {
            super(context);
            init(context, style);
        }

        public SearchTagView(Context context, AttributeSet attrs, Style style) {
            super(context, attrs);
            init(context, style);
        }

        public SearchTagView(Context context, AttributeSet attrs, int defStyleAttr, Style style) {
            super(context, attrs, defStyleAttr);
            init(context, style);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void init(Context context, Style style) {
            LayoutInflater.from(context).inflate(style.getLayoutId(), (ViewGroup) this, true);
            this.mTagName = (TextView) findViewById(com.bilibili.bplus.followingcard.R.id.tag_name);
            this.mTagName.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.widget.SearchPreTagLayout$SearchTagView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SearchPreTagLayout.SearchTagView.this.m2040lambda$init$2$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(view2);
                }
            });
            this.mDelIcon = (ImageView) findViewById(com.bilibili.bplus.followingcard.R.id.img_delete);
            this.mDelIcon.setVisibility(8);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$init$2$tv-danmaku-bili-widget-SearchPreTagLayout$SearchTagView  reason: not valid java name */
        public /* synthetic */ void m2040lambda$init$2$tvdanmakubiliwidgetSearchPreTagLayout$SearchTagView(View v) {
            if (this.mTagClickListener != null) {
                setState(0);
                this.mTagClickListener.onTagClick(this, ((Integer) getTag(SearchPreTagLayout.KEY_POS)).intValue(), this.mData);
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
            setState(0);
            String text = tag.getTagName();
            if (!TextUtils.isEmpty(text)) {
                if (text.length() >= 9) {
                    this.mTagName.setText(String.format("%s…", text.substring(0, 8)));
                } else {
                    this.mTagName.setText(text);
                }
            }
        }

        public void setOnTagClickListener(TagClickListener listener) {
            this.mTagClickListener = listener;
        }
    }
}