package tv.danmaku.bili.report.platform.neuron.redirect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.lib.neuron.model.config.RedirectConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.section.adapter.BaseAdapter;
import tv.danmaku.bili.widget.section.holder.BaseViewHolder;

/* compiled from: RedirectFragment.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/redirect/ProxyViewHolder;", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", "itemView", "Landroid/view/View;", "adapter", "Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;", "<init>", "(Landroid/view/View;Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;)V", "mData", "Lcom/bilibili/lib/neuron/model/config/RedirectConfig$Proxy;", "mTv", "Landroid/widget/TextView;", "bind", "", "data", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final class ProxyViewHolder extends BaseViewHolder {
    public static final Companion Companion = new Companion(null);
    private RedirectConfig.Proxy mData;
    private TextView mTv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProxyViewHolder(View itemView, BaseAdapter adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mTv = (TextView) itemView.findViewById(R.id.f13tv);
    }

    public final void bind(RedirectConfig.Proxy data) {
        TextView textView;
        Intrinsics.checkNotNullParameter(data, "data");
        this.mData = data;
        RedirectConfig.Proxy it = this.mData;
        if (it == null || (textView = this.mTv) == null) {
            return;
        }
        textView.setText(it.domain + ", " + it.ip);
    }

    /* compiled from: RedirectFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/redirect/ProxyViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/widget/section/holder/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "adapter", "Ltv/danmaku/bili/widget/section/adapter/BaseAdapter;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BaseViewHolder create(ViewGroup parent, BaseAdapter adapter) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_list_item_single_text, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ProxyViewHolder(inflate, adapter);
        }
    }
}