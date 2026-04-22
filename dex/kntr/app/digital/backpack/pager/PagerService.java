package kntr.app.digital.backpack.pager;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import javax.inject.Inject;
import kntr.app.digital.backpack.card.CategoriesService;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.digital.backpack.lottery.LotterySelectedService;
import kntr.app.digital.backpack.tab.TabModel;
import kntr.app.digital.backpack.tab.TabsModel;
import kntr.app.digital.backpack.tab.TabsService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: PagerService.kt */
@BusinessScope
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r²\u0006\n\u0010\u000e\u001a\u00020\u000fX\u008a\u0084\u0002"}, d2 = {"Lkntr/app/digital/backpack/pager/PagerService;", RoomRecommendViewModel.EMPTY_CURSOR, "categoriesService", "Lkntr/app/digital/backpack/card/CategoriesService;", "lotterySelectedService", "Lkntr/app/digital/backpack/lottery/LotterySelectedService;", "tabsService", "Lkntr/app/digital/backpack/tab/TabsService;", "<init>", "(Lkntr/app/digital/backpack/card/CategoriesService;Lkntr/app/digital/backpack/lottery/LotterySelectedService;Lkntr/app/digital/backpack/tab/TabsService;)V", "komponent", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "backpack_debug", "tabsModel", "Lkntr/app/digital/backpack/tab/TabsModel;"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PagerService {
    public static final int $stable = 8;
    private final CategoriesService categoriesService;
    private final LotterySelectedService lotterySelectedService;
    private final TabsService tabsService;

    @Inject
    public PagerService(CategoriesService categoriesService, LotterySelectedService lotterySelectedService, TabsService tabsService) {
        Intrinsics.checkNotNullParameter(categoriesService, "categoriesService");
        Intrinsics.checkNotNullParameter(lotterySelectedService, "lotterySelectedService");
        Intrinsics.checkNotNullParameter(tabsService, "tabsService");
        this.categoriesService = categoriesService;
        this.lotterySelectedService = lotterySelectedService;
        this.tabsService = tabsService;
    }

    public final Komponent<Unit> komponent() {
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.pager.PagerService$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult komponent$lambda$0;
                komponent$lambda$0 = PagerService.komponent$lambda$0(PagerService.this, (KomponentScope) obj);
                return komponent$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult komponent$lambda$0(final PagerService this$0, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, this$0) { // from class: kntr.app.digital.backpack.pager.PagerService$komponent$lambda$0$$inlined$setContent$1
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;
            final /* synthetic */ PagerService this$0;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.this$0 = this$0;
                this.state = state$iv$iv;
            }

            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                LotterySelectedService lotterySelectedService;
                TabsService tabsService;
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                $composer.startReplaceGroup(1567525996);
                ComposerKt.sourceInformation($composer, "CN(it)*26@1010L16,31@1234L211,27@1047L398:PagerService.kt#n9o43p");
                lotterySelectedService = this.this$0.lotterySelectedService;
                final State tabsModel$delegate = SnapshotStateKt.collectAsState(lotterySelectedService.getCurrentTabsModel(), (CoroutineContext) null, $composer, 0, 1);
                tabsService = this.this$0.tabsService;
                PagerState pagerState = tabsService.getPagerState();
                final PagerService pagerService = this.this$0;
                PagerKt.HorizontalPager--8jOkeI(pagerState, modifier, (PaddingValues) null, (PageSize) null, 2, 0.0f, (Alignment.Vertical) null, (TargetedFlingBehavior) null, false, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(1618924202, true, new Function4<PagerScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.digital.backpack.pager.PagerService$komponent$1$1$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                        invoke((PagerScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PagerScope $this$HorizontalPager, int page, Composer $composer2, int $changed2) {
                        TabsModel komponent$lambda$0$0$0;
                        CategoriesService categoriesService;
                        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
                        ComposerKt.sourceInformation($composer2, "CN(page)*33@1343L54:PagerService.kt#n9o43p");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1618924202, $changed2, -1, "kntr.app.digital.backpack.pager.PagerService.komponent.<anonymous>.<anonymous>.<anonymous> (PagerService.kt:32)");
                        }
                        komponent$lambda$0$0$0 = PagerService.komponent$lambda$0$0$0(tabsModel$delegate);
                        TabModel $this$invoke_u24lambda_u240 = komponent$lambda$0$0$0.getTabs().get(page);
                        categoriesService = pagerService.categoriesService;
                        categoriesService.Content($this$invoke_u24lambda_u240.getCategories(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, ((($changed & 14) << 3) & 112) | 24576, 24576, 16364);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TabsModel komponent$lambda$0$0$0(State<TabsModel> state) {
        Object thisObj$iv = state.getValue();
        return (TabsModel) thisObj$iv;
    }
}