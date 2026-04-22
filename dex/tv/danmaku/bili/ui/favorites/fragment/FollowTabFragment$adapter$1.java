package tv.danmaku.bili.ui.favorites.fragment;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetDialog;
import com.bilibili.app.comm.list.common.widget.bottomsheet.ListBottomSheetItem;
import com.bilibili.lib.theme.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.adapter.FollowCardClickListener;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;
import tv.danmaku.bili.ui.favorites.model.FollowItem;
import tv.danmaku.bili.ui.favorites.state.FollowAction;
import tv.danmaku.bili.ui.favorites.util.FavReportHelperKt;

/* compiled from: FollowTabFragment.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"tv/danmaku/bili/ui/favorites/fragment/FollowTabFragment$adapter$1", "Ltv/danmaku/bili/ui/favorites/adapter/FollowCardClickListener;", "onItemClick", "", "item", "Ltv/danmaku/bili/ui/favorites/model/FollowItem;", FavoritesConstsKt.POS, "", "onThreePointClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FollowTabFragment$adapter$1 implements FollowCardClickListener {
    final /* synthetic */ FollowTabFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FollowTabFragment$adapter$1(FollowTabFragment $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FollowCardClickListener
    public void onItemClick(FollowItem item, int pos) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.this$0.getViewModel().sendAction(new FollowAction.ClickItem(pos));
        LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), Dispatchers.getIO(), (CoroutineStart) null, new FollowTabFragment$adapter$1$onItemClick$1(this.this$0, item, pos, null), 2, (Object) null);
    }

    @Override // tv.danmaku.bili.ui.favorites.adapter.FollowCardClickListener
    public void onThreePointClick(final int pos) {
        Context mContext = this.this$0.getContext();
        if (mContext == null) {
            return;
        }
        Iterable $this$map$iv = FavoritesConstsKt.getFollowTabBottomSheetItems();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Pair it = (Pair) item$iv$iv;
            destination$iv$iv.add(new ListBottomSheetItem(mContext.getString(((Number) it.getFirst()).intValue()), (Integer) it.getSecond(), 0, R.color.Text1, false, (String) null, 0, (int) BR.contentColor, (DefaultConstructorMarker) null));
        }
        ArrayList items = new ArrayList((List) destination$iv$iv);
        ListBottomSheetDialog.Companion companion = ListBottomSheetDialog.Companion;
        final FollowTabFragment followTabFragment = this.this$0;
        ListBottomSheetDialog newInstance = companion.newInstance(items, new Function1() { // from class: tv.danmaku.bili.ui.favorites.fragment.FollowTabFragment$adapter$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onThreePointClick$lambda$1;
                onThreePointClick$lambda$1 = FollowTabFragment$adapter$1.onThreePointClick$lambda$1(FollowTabFragment.this, pos, ((Integer) obj).intValue());
                return onThreePointClick$lambda$1;
            }
        });
        FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        newInstance.show(childFragmentManager, FollowTabFragment.TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onThreePointClick$lambda$1(FollowTabFragment this$0, int $pos, int it) {
        if (it == 0) {
            this$0.getViewModel().sendAction(new FollowAction.Delete($pos));
            String string = this$0.getString(((Number) FavoritesConstsKt.getFollowTabBottomSheetItems().get(it).getFirst()).intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            FavReportHelperKt.reportSecButtonClick(string);
        }
        return Unit.INSTANCE;
    }
}