package tv.danmaku.bili.fakepage;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: FakeTabAdapter.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Ltv/danmaku/bili/fakepage/FakeTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/fakepage/FakeTabAdapter$TabViewHolder;", "clickListener", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "mTabs", "", "Lkotlin/Pair;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "TabViewHolder", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FakeTabAdapter extends RecyclerView.Adapter<TabViewHolder> {
    public static final int $stable = 8;
    private final Function1<String, Unit> clickListener;
    private final List<Pair<String, String>> mTabs;

    /* JADX WARN: Multi-variable type inference failed */
    public FakeTabAdapter(Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.clickListener = function1;
        this.mTabs = CollectionsKt.listOf(new Pair[]{TuplesKt.to("直播", "live_tab"), TuplesKt.to("推荐", "tm_tab"), TuplesKt.to("热门", "hot_tab"), TuplesKt.to("追番", "ogv_tab"), TuplesKt.to("影视", "movie_tab"), TuplesKt.to("建党百年", "activity_tab")});
    }

    public TabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_app_activity_fake_tab_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new TabViewHolder(inflate);
    }

    public void onBindViewHolder(TabViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Pair tab = this.mTabs.get(position);
        holder.getText().setText((CharSequence) tab.getFirst());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.fakepage.FakeTabAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FakeTabAdapter.onBindViewHolder$lambda$0(FakeTabAdapter.this, tab, view);
            }
        });
        Resources res = holder.itemView.getResources();
        if (position == 1) {
            holder.getText().getPaint().setFakeBoldText(true);
            holder.getText().setTextColor(res.getColor(com.bilibili.lib.theme.R.color.Pi5));
            holder.getLine().setVisibility(0);
        } else {
            holder.getText().setTextColor(res.getColor(com.bilibili.lib.theme.R.color.Ga7));
            holder.getText().getPaint().setFakeBoldText(false);
            holder.getLine().setVisibility(8);
        }
        if (position != 2) {
            holder.getRedDot().setVisibility(8);
        } else {
            holder.getRedDot().setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(FakeTabAdapter this$0, Pair $tab, View it) {
        this$0.clickListener.invoke($tab.getSecond());
    }

    public int getItemCount() {
        return this.mTabs.size();
    }

    /* compiled from: FakeTabAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/fakepage/FakeTabAdapter$TabViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "getText", "()Landroid/widget/TextView;", "line", "getLine", "()Landroid/view/View;", "redDot", "getRedDot", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class TabViewHolder extends RecyclerView.ViewHolder {
        public static final int $stable = 8;
        private final View line;
        private final View redDot;
        private final TextView text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.text);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.text = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.line);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.line = findViewById2;
            View findViewById3 = view.findViewById(R.id.red_dot);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.redDot = findViewById3;
        }

        public final TextView getText() {
            return this.text;
        }

        public final View getLine() {
            return this.line;
        }

        public final View getRedDot() {
            return this.redDot;
        }
    }
}