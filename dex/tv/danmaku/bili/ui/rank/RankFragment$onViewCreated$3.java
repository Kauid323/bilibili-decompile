package tv.danmaku.bili.ui.rank;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.routeui.PagerFragmentAdapter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import tv.danmaku.bili.ui.rank.model.RankStatus;
import tv.danmaku.bili.ui.rank.model.RankUiState;
import tv.danmaku.bili.widget.PagerSlidingTabStrip;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.rank.RankFragment$onViewCreated$3", f = "RankFragment.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class RankFragment$onViewCreated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RankFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankFragment$onViewCreated$3(RankFragment rankFragment, Continuation<? super RankFragment$onViewCreated$3> continuation) {
        super(2, continuation);
        this.this$0 = rankFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankFragment$onViewCreated$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RankFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Ltv/danmaku/bili/ui/rank/model/RankUiState;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @DebugMetadata(c = "tv.danmaku.bili.ui.rank.RankFragment$onViewCreated$3$1", f = "RankFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.ui.rank.RankFragment$onViewCreated$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<RankUiState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RankFragment this$0;

        /* compiled from: RankFragment.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* renamed from: tv.danmaku.bili.ui.rank.RankFragment$onViewCreated$3$1$WhenMappings */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RankStatus.values().length];
                try {
                    iArr[RankStatus.IDLE.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[RankStatus.LOADING.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[RankStatus.SUCCESS.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[RankStatus.FAILED.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(RankFragment rankFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = rankFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(RankUiState rankUiState, Continuation<? super Unit> continuation) {
            return create(rankUiState, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            RankViewModel viewModel;
            View view2;
            PagerSlidingTabStrip pagerSlidingTabStrip;
            ViewPager viewPager;
            PagerSlidingTabStrip pagerSlidingTabStrip2;
            ViewPager viewPager2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    RankUiState state = (RankUiState) this.L$0;
                    switch (WhenMappings.$EnumSwitchMapping$0[state.getStatus().ordinal()]) {
                        case 1:
                            viewModel = this.this$0.getViewModel();
                            viewModel.loadData();
                            break;
                        case 2:
                            this.this$0.showErrorView(PlaceHolderState.LoadingHolder.INSTANCE);
                            break;
                        case 3:
                            view2 = this.this$0.mErrorView;
                            if (view2 != null) {
                                ListExtentionsKt.gone(view2);
                            }
                            pagerSlidingTabStrip = this.this$0.mTabs;
                            ListExtentionsKt.visible(pagerSlidingTabStrip);
                            viewPager = this.this$0.mPager;
                            if (viewPager != null) {
                                FragmentManager childFragmentManager = this.this$0.getChildFragmentManager();
                                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                                viewPager.setAdapter(new PagerFragmentAdapter(childFragmentManager, state.getPageList()));
                            }
                            pagerSlidingTabStrip2 = this.this$0.mTabs;
                            if (pagerSlidingTabStrip2 != null) {
                                viewPager2 = this.this$0.mPager;
                                pagerSlidingTabStrip2.setViewPager(viewPager2);
                                break;
                            }
                            break;
                        case 4:
                            this.this$0.showErrorView(PlaceHolderState.ErrorHolder.INSTANCE);
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final Object invokeSuspend(Object $result) {
        RankViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                if (FlowKt.collectLatest(viewModel.getUiState(), new AnonymousClass1(this.this$0, null), (Continuation) this) == coroutine_suspended) {
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