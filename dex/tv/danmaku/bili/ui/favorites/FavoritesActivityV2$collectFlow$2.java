package tv.danmaku.bili.ui.favorites;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.databinding.BiliAppActivityCollectionV2Binding;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;
import tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2;
import tv.danmaku.bili.ui.favorites.model.FavoritesTabs;
import tv.danmaku.bili.ui.favorites.model.Tab;
import tv.danmaku.bili.ui.favorites.state.FavoritesPageAction;
import tv.danmaku.bili.ui.favorites.viewmodel.FavoritesActivityViewModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FavoritesActivityV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2", f = "FavoritesActivityV2.kt", i = {}, l = {BR.createClick}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class FavoritesActivityV2$collectFlow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FavoritesActivityV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FavoritesActivityV2$collectFlow$2(FavoritesActivityV2 favoritesActivityV2, Continuation<? super FavoritesActivityV2$collectFlow$2> continuation) {
        super(2, continuation);
        this.this$0 = favoritesActivityV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FavoritesActivityV2$collectFlow$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FavoritesActivityV2.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* renamed from: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ FavoritesActivityV2 this$0;

        AnonymousClass1(FavoritesActivityV2 favoritesActivityV2) {
            this.this$0 = favoritesActivityV2;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((FavoritesTabs) value, (Continuation<? super Unit>) $completion);
        }

        public final Object emit(FavoritesTabs tabsData, Continuation<? super Unit> continuation) {
            BiliAppActivityCollectionV2Binding $this$emit_u24lambda_u240;
            View customView;
            final List tabsList = tabsData.getTabs();
            $this$emit_u24lambda_u240 = this.this$0.getBinding();
            final FavoritesActivityV2 favoritesActivityV2 = this.this$0;
            $this$emit_u24lambda_u240.viewPager.setAdapter(new FragmentStateAdapter(tabsList) { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2$1$1$1
                final /* synthetic */ List<Tab> $tabsList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super((FragmentActivity) FavoritesActivityV2.this);
                    this.$tabsList = tabsList;
                }

                public int getItemCount() {
                    List<Tab> list = this.$tabsList;
                    if (list != null) {
                        return list.size();
                    }
                    return 0;
                }

                /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
                    r1 = r4.this$0.appendParams(r1, (tv.danmaku.bili.ui.favorites.model.Tab) kotlin.collections.CollectionsKt.getOrNull(r4.$tabsList, r5));
                 */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Fragment createFragment(int position) {
                    Tab tab;
                    Context context = (Context) FavoritesActivityV2.this;
                    List<Tab> list = this.$tabsList;
                    String str = (list == null || (tab = (Tab) CollectionsKt.getOrNull(list, position)) == null || (r1 = tab.getUri()) == null || str == null) ? "" : "";
                    Fragment findFragmentByUrl$default = ListExtentionsKt.findFragmentByUrl$default(context, str, (Bundle) null, 2, (Object) null);
                    if (findFragmentByUrl$default != null) {
                        return findFragmentByUrl$default;
                    }
                    return new Fragment();
                }
            });
            $this$emit_u24lambda_u240.viewPager.setCurrentItem(tabsData.getDefaultPosition());
            new TabLayoutMediator($this$emit_u24lambda_u240.tabLayout, $this$emit_u24lambda_u240.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2$1$$ExternalSyntheticLambda0
                public final void onConfigureTab(TabLayout.Tab tab, int i) {
                    FavoritesActivityV2$collectFlow$2.AnonymousClass1.emit$lambda$0$0(FavoritesActivityV2.this, tabsList, tab, i);
                }
            }).attach();
            TabLayout.Tab tabAt = $this$emit_u24lambda_u240.tabLayout.getTabAt(tabsData.getDefaultPosition());
            if (tabAt != null && (customView = tabAt.getCustomView()) != null) {
                favoritesActivityV2.setTabSelected(customView, true);
            }
            $this$emit_u24lambda_u240.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2$1$1$3
                public void onTabSelected(TabLayout.Tab tab) {
                    View customView2;
                    if (tab != null && (customView2 = tab.getCustomView()) != null) {
                        FavoritesActivityV2.this.setTabSelected(customView2, true);
                    }
                }

                public void onTabUnselected(TabLayout.Tab tab) {
                    View customView2;
                    if (tab != null && (customView2 = tab.getCustomView()) != null) {
                        FavoritesActivityV2.this.setTabSelected(customView2, false);
                    }
                }

                public void onTabReselected(TabLayout.Tab tab) {
                    View customView2;
                    if (tab != null && (customView2 = tab.getCustomView()) != null) {
                        FavoritesActivityV2.this.setTabSelected(customView2, true);
                    }
                }
            });
            $this$emit_u24lambda_u240.cancelManage.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.favorites.FavoritesActivityV2$collectFlow$2$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FavoritesActivityV2$collectFlow$2.AnonymousClass1.emit$lambda$0$1(FavoritesActivityV2.this, view);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0$0(FavoritesActivityV2 this$0, List $tabsList, TabLayout.Tab tab, int pos) {
            Tab tab2;
            TintTextView $this$emit_u24lambda_u240_u240_u240;
            Tab tab3;
            Intrinsics.checkNotNullParameter(tab, BaseFavoritesFragment.TAB);
            View customTab = LayoutInflater.from((Context) this$0).inflate(R.layout.bili_app_layout_collection_tab_badge_item, (ViewGroup) null);
            tab.setCustomView(customTab);
            View customView = tab.getCustomView();
            boolean z = true;
            if (customView != null && ($this$emit_u24lambda_u240_u240_u240 = customView.findViewById(R.id.tab_title)) != null) {
                $this$emit_u24lambda_u240_u240_u240.setText(($tabsList == null || (tab3 = (Tab) CollectionsKt.getOrNull($tabsList, pos)) == null || (r5 = tab3.getTabName()) == null) ? "" : "");
                Integer toolbarTextColor$default = FavoritesActivityV2.getToolbarTextColor$default(this$0, null, 1, null);
                if (toolbarTextColor$default != null) {
                    int it = toolbarTextColor$default.intValue();
                    $this$emit_u24lambda_u240_u240_u240.setTextColor(it);
                } else {
                    $this$emit_u24lambda_u240_u240_u240.setTextColor(ThemeUtils.getColorById($this$emit_u24lambda_u240_u240_u240.getContext(), com.bilibili.lib.theme.R.color.Text1));
                }
                $this$emit_u24lambda_u240_u240_u240.setAlpha(0.68f);
            }
            View customView2 = tab.getCustomView();
            View badge = customView2 != null ? customView2.findViewById(R.id.badge) : null;
            if (badge != null) {
                if ($tabsList == null || (tab2 = (Tab) CollectionsKt.getOrNull($tabsList, pos)) == null || !tab2.getRedDot()) {
                    z = false;
                }
                badge.setVisibility(ListExtentionsKt.toVisibility(z));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$0$1(FavoritesActivityV2 this$0, View it) {
            FavoritesActivityViewModel viewModel;
            viewModel = this$0.getViewModel();
            viewModel.sendAction(FavoritesPageAction.QuitBatchManage.INSTANCE);
        }
    }

    public final Object invokeSuspend(Object $result) {
        FavoritesActivityViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (viewModel.getTabData().collect(new AnonymousClass1(this.this$0), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}