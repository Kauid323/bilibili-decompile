package tv.danmaku.bili.ui.garb.holder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.databinding.BiliAppViewCollectionAllHeaderBinding;

/* compiled from: CollectionAllTitleViewHolder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/CollectionAllTitleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltv/danmaku/bili/databinding/BiliAppViewCollectionAllHeaderBinding;", "<init>", "(Ltv/danmaku/bili/databinding/BiliAppViewCollectionAllHeaderBinding;)V", "getBinding", "()Ltv/danmaku/bili/databinding/BiliAppViewCollectionAllHeaderBinding;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionAllTitleViewHolder extends RecyclerView.ViewHolder {
    public static final String TAG = "CollectionAllViewHolder";
    private final BiliAppViewCollectionAllHeaderBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollectionAllTitleViewHolder(BiliAppViewCollectionAllHeaderBinding binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
    }

    public final BiliAppViewCollectionAllHeaderBinding getBinding() {
        return this.binding;
    }

    /* compiled from: CollectionAllTitleViewHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/garb/holder/CollectionAllTitleViewHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/garb/holder/CollectionAllTitleViewHolder;", "parent", "Landroid/view/ViewGroup;", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CollectionAllTitleViewHolder create(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            BiliAppViewCollectionAllHeaderBinding binding = BiliAppViewCollectionAllHeaderBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            Intrinsics.checkNotNullExpressionValue(binding, "inflate(...)");
            return new CollectionAllTitleViewHolder(binding);
        }
    }
}