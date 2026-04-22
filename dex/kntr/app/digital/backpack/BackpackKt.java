package kntr.app.digital.backpack;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.framework.exposure.core.ExposureEntry;
import com.bilibili.framework.exposure.core.collecter.ComposeExposureLayoutInfoCollectorKt;
import com.bilibili.ogv.bpf.neuron.NeuronReportKt;
import java.util.Map;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.app.digital.backpack.aggregate.BackpackPageComponent_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStoreKt;
import kntr.base.router.Router;
import kntr.common.compose.launcher.KomponentRouterKt;
import kntr.common.compose.launcher.LifecycleKt;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.Orientation;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: Backpack.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001aH\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0001\"\u0011\u0010\u0000\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u000e"}, d2 = {"currentMid", RoomRecommendViewModel.EMPTY_CURSOR, "getCurrentMid", "()J", "pageEntrance", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "act_id", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, "page_from", "from", "from_id", "f_source", "backpack_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BackpackKt {
    public static final long getCurrentMid() {
        AccountState.Logged logged = (AccountState) KAccountStoreKt.getAccountHolder().getState().getValue();
        if (logged instanceof AccountState.Logged) {
            return logged.getUserInfo().getMid();
        }
        return 0L;
    }

    public static final Komponent<Unit> pageEntrance(final String act_id, final String mid, final String page_from, final String from, final String from_id, final String f_source) {
        Intrinsics.checkNotNullParameter(act_id, "act_id");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.backpack.BackpackKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult pageEntrance$lambda$0;
                pageEntrance$lambda$0 = BackpackKt.pageEntrance$lambda$0(act_id, mid, from, f_source, from_id, page_from, (KomponentScope) obj);
                return pageEntrance$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult pageEntrance$lambda$0(String $act_id, String $mid, String $from, String $f_source, String $from_id, final String $page_from, final KomponentScope $this$Komponent) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPreferredOrientation(new Function0() { // from class: kntr.app.digital.backpack.BackpackKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                Orientation orientation;
                orientation = Orientation.UserPortrait;
                return orientation;
            }
        });
        final ExposureEntry exposureEntry = ExposureEntryFactory.INSTANCE.newExposureEntry(new Function0() { // from class: kntr.app.digital.backpack.BackpackKt$$ExternalSyntheticLambda2
            public final Object invoke() {
                Unit pageEntrance$lambda$0$1;
                pageEntrance$lambda$0$1 = BackpackKt.pageEntrance$lambda$0$1($page_from);
                return pageEntrance$lambda$0$1;
            }
        });
        BackpackPageComponent.Factory backpackPageComponentFactory = BackpackPageComponent_androidKt.backpackPageComponentFactory();
        Lifecycle lifecycle = ((LifecycleOwner) $this$Komponent.getCurrent(LifecycleKt.getLocalLifecycleOwner())).getLifecycle();
        Integer intOrNull = StringsKt.toIntOrNull($act_id);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        long currentMid = ($mid == null || (longOrNull = StringsKt.toLongOrNull($mid)) == null) ? getCurrentMid() : longOrNull.longValue();
        Router router = (Router) $this$Komponent.getCurrent(KomponentRouterKt.getLocalRouter());
        Pair[] pairArr = new Pair[4];
        String str = RoomRecommendViewModel.EMPTY_CURSOR;
        pairArr[0] = TuplesKt.to("from", $from == null ? RoomRecommendViewModel.EMPTY_CURSOR : $from);
        pairArr[1] = TuplesKt.to("f_source", $f_source == null ? RoomRecommendViewModel.EMPTY_CURSOR : $f_source);
        pairArr[2] = TuplesKt.to("from_id", $from_id == null ? RoomRecommendViewModel.EMPTY_CURSOR : $from_id);
        pairArr[3] = TuplesKt.to("activity_id", $act_id);
        Map<String, String> mapOf = MapsKt.mapOf(pairArr);
        String str2 = $f_source == null ? RoomRecommendViewModel.EMPTY_CURSOR : $f_source;
        if ($from != null) {
            str = $from;
        }
        BackpackPageComponent component = backpackPageComponentFactory.create(intValue, currentMid, lifecycle, router, mapOf, str, str2, $this$Komponent);
        final UiComposableLike child = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, component.pageModel().komponent(), (Function1) null, 2, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, child, exposureEntry) { // from class: kntr.app.digital.backpack.BackpackKt$pageEntrance$lambda$0$$inlined$setContent$1
            final /* synthetic */ UiComposableLike $child$inlined;
            final /* synthetic */ ExposureEntry $exposureEntry$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$child$inlined = child;
                this.$exposureEntry$inlined = exposureEntry;
                this.state = state$iv$iv;
            }

            public void invoke(final Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(53012129);
                ComposerKt.sourceInformation($composer, "CN(modifier)*73@2462L380,73@2452L390:Backpack.kt#nfb1io");
                final UiComposableLike uiComposableLike = this.$child$inlined;
                final ExposureEntry exposureEntry2 = this.$exposureEntry$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1438801388, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.digital.backpack.BackpackKt$pageEntrance$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C74@2495L28,75@2557L64,75@2536L85,78@2634L198:Backpack.kt#nfb1io");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1438801388, $changed2, -1, "kntr.app.digital.backpack.pageEntrance.<anonymous>.<anonymous>.<anonymous> (Backpack.kt:74)");
                        }
                        SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, 291338548, "CC(remember):Backpack.kt#9igjgp");
                        boolean invalid$iv = $composer2.changed(uiController);
                        Object it$iv = $composer2.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = (Function2) new BackpackKt$pageEntrance$1$2$1$1$1(uiController, null);
                            $composer2.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
                        uiComposableLike.invoke(ComposeExposureLayoutInfoCollectorKt.collectExposureLayoutInfo(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(modifier, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null)), exposureEntry2), $composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), $composer, 384, 3);
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
    public static final Unit pageEntrance$lambda$0$1(String $page_from) {
        NeuronReportKt.getNeuronReport().invoke("sqzz.activity.bag.0.show", MapsKt.mapOf(TuplesKt.to("page_from", $page_from == null ? RoomRecommendViewModel.EMPTY_CURSOR : $page_from)));
        return Unit.INSTANCE;
    }
}