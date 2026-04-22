package tv.danmaku.bili.ui.splash.brand.uiv2.setting;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSettingTab;
import tv.danmaku.bili.ui.splash.brand.reporter.BrandSplashReporter;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$9;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.view.SplashBrandTabItemView;
import tv.danmaku.bili.ui.splash.brand.uiv2.setting.vm.BrandSplashSettingViewModel;
import tv.danmaku.bili.ui.splash.databinding.BiliAppListBrandSplashSettingFragmentBinding;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BrandSplashSettingFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$9", f = "BrandSplashSettingFragment.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BrandSplashSettingFragment$initView$9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrandSplashSettingViewPagerAdapter $adapter;
    int label;
    final /* synthetic */ BrandSplashSettingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BrandSplashSettingFragment$initView$9(BrandSplashSettingFragment brandSplashSettingFragment, BrandSplashSettingViewPagerAdapter brandSplashSettingViewPagerAdapter, Continuation<? super BrandSplashSettingFragment$initView$9> continuation) {
        super(2, continuation);
        this.this$0 = brandSplashSettingFragment;
        this.$adapter = brandSplashSettingViewPagerAdapter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BrandSplashSettingFragment$initView$9(this.this$0, this.$adapter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BrandSplashSettingFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "Ltv/danmaku/bili/ui/splash/brand/modelv2/BrandSplashSettingTab;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$9$1", f = "BrandSplashSettingFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$9$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends BrandSplashSettingTab>, Continuation<? super Unit>, Object> {
        final /* synthetic */ BrandSplashSettingViewPagerAdapter $adapter;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BrandSplashSettingFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BrandSplashSettingViewPagerAdapter brandSplashSettingViewPagerAdapter, BrandSplashSettingFragment brandSplashSettingFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$adapter = brandSplashSettingViewPagerAdapter;
            this.this$0 = brandSplashSettingFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$adapter, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(List<BrandSplashSettingTab> list, Continuation<? super Unit> continuation) {
            return create(list, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            BiliAppListBrandSplashSettingFragmentBinding binding;
            BiliAppListBrandSplashSettingFragmentBinding binding2;
            BiliAppListBrandSplashSettingFragmentBinding binding3;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    final List it = (List) this.L$0;
                    this.$adapter.update(it);
                    binding = this.this$0.getBinding();
                    TabLayout tabLayout = binding.brandSplashTab;
                    binding2 = this.this$0.getBinding();
                    ViewPager2 viewPager2 = binding2.vpContainer;
                    final BrandSplashSettingFragment brandSplashSettingFragment = this.this$0;
                    new TabLayoutMediator(tabLayout, viewPager2, false, new TabLayoutMediator.TabConfigurationStrategy() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment$initView$9$1$$ExternalSyntheticLambda0
                        public final void onConfigureTab(TabLayout.Tab tab, int i) {
                            BrandSplashSettingFragment$initView$9.AnonymousClass1.invokeSuspend$lambda$0(it, brandSplashSettingFragment, tab, i);
                        }
                    }).attach();
                    binding3 = this.this$0.getBinding();
                    binding3.brandSplashTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: tv.danmaku.bili.ui.splash.brand.uiv2.setting.BrandSplashSettingFragment.initView.9.1.2
                        public void onTabSelected(TabLayout.Tab tab) {
                            View customView = tab != null ? tab.getCustomView() : null;
                            SplashBrandTabItemView view2 = customView instanceof SplashBrandTabItemView ? (SplashBrandTabItemView) customView : null;
                            if (view2 != null) {
                                view2.setSelected(true);
                            }
                            BrandSplashReporter.INSTANCE.reportSettingTabClick(view2 != null ? view2.getSource() : null);
                        }

                        public void onTabUnselected(TabLayout.Tab tab) {
                            KeyEvent.Callback customView = tab != null ? tab.getCustomView() : null;
                            SplashBrandTabItemView view2 = customView instanceof SplashBrandTabItemView ? (SplashBrandTabItemView) customView : null;
                            if (view2 != null) {
                                view2.setSelected(false);
                            }
                        }

                        public void onTabReselected(TabLayout.Tab tab) {
                        }
                    });
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(List $it, BrandSplashSettingFragment this$0, TabLayout.Tab tab, int pos) {
            BiliAppListBrandSplashSettingFragmentBinding binding;
            BrandSplashSettingTab tabData = (BrandSplashSettingTab) $it.get(pos);
            binding = this$0.getBinding();
            Context context = binding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SplashBrandTabItemView $this$invokeSuspend_u24lambda_u240_u240 = new SplashBrandTabItemView(context, null, 2, null);
            $this$invokeSuspend_u24lambda_u240_u240.setTabTitle(tabData.getTitle());
            $this$invokeSuspend_u24lambda_u240_u240.setSource(tabData.getSource());
            $this$invokeSuspend_u24lambda_u240_u240.setSelected(pos == 0);
            tab.setCustomView($this$invokeSuspend_u24lambda_u240_u240);
            tab.setText(tabData.getTitle());
        }
    }

    public final Object invokeSuspend(Object $result) {
        BrandSplashSettingViewModel vm;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                vm = this.this$0.getVm();
                this.label = 1;
                if (FlowKt.collectLatest(vm.getTabs(), new AnonymousClass1(this.$adapter, this.this$0, null), (Continuation) this) == coroutine_suspended) {
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