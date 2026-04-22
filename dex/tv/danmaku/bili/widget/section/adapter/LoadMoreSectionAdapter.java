package tv.danmaku.bili.widget.section.adapter;

import android.view.View;
import android.view.ViewGroup;
import tv.danmaku.bili.widget.section.adapter.BaseSectionAdapter;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;
import tv.danmaku.bili.widget.section.holder.LoadMoreHolder;

public abstract class LoadMoreSectionAdapter extends BaseSectionAdapter {
    public static int TYPE_CONTENT_LOAD_MORE = -1000;
    private LoadMoreHolder mLoadMoreHolder;

    protected abstract void fillSection(BaseSectionAdapter.SectionManager sectionManager);

    protected abstract void onBindHolder(BaseViewHolder baseViewHolder, int i, View view2);

    protected abstract BaseViewHolder onCreateHolder(ViewGroup viewGroup, int i);

    @Override // tv.danmaku.bili.widget.section.adapter.BaseSectionAdapter
    protected final void fillSectionList(BaseSectionAdapter.SectionManager sectionManager) {
        fillSection(sectionManager);
        sectionManager.addSectionWithNone(1, TYPE_CONTENT_LOAD_MORE);
    }

    @Override // tv.danmaku.bili.widget.section.adapter.BaseAdapter
    public final BaseViewHolder createHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT_LOAD_MORE) {
            this.mLoadMoreHolder = LoadMoreHolder.create(parent, this);
            LoadMoreHolder create = LoadMoreHolder.create(parent, this);
            this.mLoadMoreHolder = create;
            return create;
        }
        return onCreateHolder(parent, viewType);
    }

    @Override // tv.danmaku.bili.widget.section.adapter.BaseAdapter
    public final void bindHolder(BaseViewHolder holder, int position, View itemView) {
        if (!(holder instanceof LoadMoreHolder)) {
            onBindHolder(holder, position, itemView);
        }
    }

    @Deprecated
    public void showLoadMoreRefresh() {
        showFooterLoading();
        notifySectionData();
    }

    @Deprecated
    public void showLoadMoreEmpty() {
        showFooterEmpty();
        notifySectionData();
    }

    @Deprecated
    public void showLoadMoreError() {
        showFooterError();
        notifySectionData();
    }

    @Deprecated
    public void hideLoadMore() {
        hideFooter();
        notifySectionData();
    }

    public void showFooterLoading() {
        if (this.mLoadMoreHolder != null) {
            this.mLoadMoreHolder.setupView(0);
        }
    }

    public void showFooterEmpty() {
        if (this.mLoadMoreHolder != null) {
            this.mLoadMoreHolder.setupView(1);
        }
    }

    public void showFooterError() {
        if (this.mLoadMoreHolder != null) {
            this.mLoadMoreHolder.setupView(2);
        }
    }

    public void hideFooter() {
        if (this.mLoadMoreHolder != null) {
            this.mLoadMoreHolder.setupView(3);
        }
    }
}