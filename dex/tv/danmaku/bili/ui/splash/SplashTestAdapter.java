package tv.danmaku.bili.ui.splash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import tv.danmaku.bili.ui.splash.utils.UiUtilsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashTestAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/splash/SplashTestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/ui/splash/SplashTestHolder;", "mItems", "", "Ltv/danmaku/bili/ui/splash/SplashTestItem;", "<init>", "(Ljava/util/List;)V", "bgColors", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashTestAdapter extends RecyclerView.Adapter<SplashTestHolder> {
    public static final int $stable = 8;
    private final List<String> bgColors;
    private final List<SplashTestItem> mItems;

    public SplashTestAdapter(List<SplashTestItem> list) {
        List mItems = EnhancedUnmodifiabilityKt.unmodifiable(list);
        Intrinsics.checkNotNullParameter(mItems, "mItems");
        this.mItems = mItems;
        this.bgColors = CollectionsKt.listOf(new String[]{"#FF6200ee", "#FF3700b3", "#FFb0020", "#FF336ff", "#FFff0266", "#FFD81B60", "#FF880E4F", "#FF6A1B9A", "#FF9C27B0"});
    }

    public SplashTestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_splash_test, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new SplashTestHolder(inflate);
    }

    public void onBindViewHolder(final SplashTestHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view2 = holder.itemView;
        Integer parseColorSafely = UiUtilsKt.parseColorSafely((String) CollectionsKt.random(this.bgColors, Random.Default));
        view2.setBackgroundColor(parseColorSafely != null ? parseColorSafely.intValue() : -16777216);
        final SplashTestItem $this$onBindViewHolder_u24lambda_u240 = this.mItems.get(position);
        holder.getTitleView().setText($this$onBindViewHolder_u24lambda_u240.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.splash.SplashTestAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                SplashTestAdapter.onBindViewHolder$lambda$0$0(SplashTestItem.this, holder, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0$0(SplashTestItem $this_run, SplashTestHolder $holder, View it) {
        Function1<Context, Unit> action = $this_run.getAction();
        Context context = $holder.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        action.invoke(context);
    }

    public int getItemCount() {
        return this.mItems.size();
    }
}