package tv.danmaku.bili.report.platform.neuron.redirect;

import android.view.View;
import android.view.ViewGroup;
import com.bilibili.lib.neuron.model.config.RedirectConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;
import tv.danmaku.bili.widget.section.adapter.BaseSectionAdapter;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

/* compiled from: RedirectFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J$\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/redirect/Adapter;", "Ltv/danmaku/bili/widget/section/adapter/BaseSectionAdapter;", "proxy", "", "Lcom/bilibili/lib/neuron/model/config/RedirectConfig$Proxy;", "<init>", "(Ljava/util/List;)V", "createHolder", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "bindHolder", "", "holder", "position", "itemView", "Landroid/view/View;", "fillSectionList", "sectionManager", "Ltv/danmaku/bili/widget/section/adapter/BaseSectionAdapter$SectionManager;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class Adapter extends BaseSectionAdapter {
    private final List<RedirectConfig.Proxy> proxy;

    public Adapter(List<RedirectConfig.Proxy> list) {
        Intrinsics.checkNotNullParameter(list, "proxy");
        this.proxy = list;
    }

    public BaseViewHolder createHolder(ViewGroup parent, int viewType) {
        if (parent == null || viewType != 0) {
            return null;
        }
        return ProxyViewHolder.Companion.create(parent, (BaseAdapter) this);
    }

    public void bindHolder(BaseViewHolder holder, int position, View itemView) {
        int indexInSection = getIndexInSection(position);
        if (holder instanceof ProxyViewHolder) {
            ((ProxyViewHolder) holder).bind(this.proxy.get(indexInSection));
        }
    }

    protected void fillSectionList(BaseSectionAdapter.SectionManager sectionManager) {
        if (sectionManager != null) {
            sectionManager.addSectionWithNone(this.proxy.size(), 0);
        }
    }
}