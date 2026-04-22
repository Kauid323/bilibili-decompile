package tv.danmaku.bili.ui.garb.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.lib.image2.BiliImageLoader;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.databinding.BiliAppViewHolderCollectionAllBinding;
import tv.danmaku.bili.ui.garb.utils.CollectionImageColorHelper;
import tv.danmaku.biliplayerv2.utils.DpUtils;

/* compiled from: CollectionAllViewHolder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/CollectionAllViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionAllBinding;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionAllBinding;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppViewHolderCollectionAllBinding;", "getPageColor", "", ReportUtilKt.POS_COVER, "", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Ljava/lang/String;Landroid/content/Context;Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionAllViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "CollectionAllViewHolder";
    private final BiliAppViewHolderCollectionAllBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionAllViewHolder(BiliAppViewHolderCollectionAllBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final BiliAppViewHolderCollectionAllBinding getBinding() {
        return this.binding;
    }

    public final Object getPageColor(String cover, Context context, Lifecycle lifecycle, Continuation<? super Integer> continuation) {
        return CollectionImageColorHelper.INSTANCE.getColorFromSource(BiliImageLoader.INSTANCE.acquire(context, lifecycle), cover, ContextCompat.getColor(context, R.color.black_alpha40), new Pair<>(Boxing.boxFloat(0.5f), Boxing.boxFloat(0.5f)), (int) DpUtils.dp2px(context, 16.0f), (int) DpUtils.dp2px(context, 24.0f), continuation);
    }

    /* compiled from: CollectionAllViewHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/CollectionAllViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/garb/holder/CollectionAllViewHolder;", "parent", "Landroid/view/ViewGroup;", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionAllViewHolder create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BiliAppViewHolderCollectionAllBinding binding = BiliAppViewHolderCollectionAllBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
            return new CollectionAllViewHolder(binding);
        }
    }
}