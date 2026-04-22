package kntr.app.cheese.space;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.cheese.space.aggregate.SpaceCheesePageComponent;
import kntr.app.cheese.space.aggregate.SpaceCheesePageComponent_androidKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.Orientation;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SpaceCheesePageView.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"spaceCheesePageView", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "space_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SpaceCheesePageViewKt {
    public static final Komponent<Unit> spaceCheesePageView(final String mid) {
        Intrinsics.checkNotNullParameter(mid, ReportBuildInParam.MID);
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.cheese.space.SpaceCheesePageViewKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                SetContentResult spaceCheesePageView$lambda$0;
                spaceCheesePageView$lambda$0 = SpaceCheesePageViewKt.spaceCheesePageView$lambda$0(mid, (KomponentScope) obj);
                return spaceCheesePageView$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult spaceCheesePageView$lambda$0(final String $mid, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPreferredOrientation(new Function0() { // from class: kntr.app.cheese.space.SpaceCheesePageViewKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Orientation orientation;
                orientation = Orientation.UserPortrait;
                return orientation;
            }
        });
        SpaceCheesePageComponent component = SpaceCheesePageComponent_androidKt.upSpaceCheeseComponentFactory().create(Long.parseLong($mid));
        final UiComposableLike child = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, component.pageModel().komponent(), (Function1) null, 2, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, $mid, child) { // from class: kntr.app.cheese.space.SpaceCheesePageViewKt$spaceCheesePageView$lambda$0$$inlined$setContent$1
            final /* synthetic */ UiComposableLike $child$inlined;
            final /* synthetic */ String $mid$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$mid$inlined = $mid;
                this.$child$inlined = child;
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
                $composer.startReplaceGroup(1623134186);
                ComposerKt.sourceInformation($composer, "CN(modifier)*28@1033L502,28@1023L512:SpaceCheesePageView.kt#mv22nr");
                final String str = this.$mid$inlined;
                final UiComposableLike uiComposableLike = this.$child$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1879881727, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.cheese.space.SpaceCheesePageViewKt$spaceCheesePageView$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C29@1077L13,30@1122L28,31@1184L93,31@1163L114,34@1306L48,38@1499L6,36@1425L100:SpaceCheesePageView.kt#mv22nr");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1879881727, $changed2, -1, "kntr.app.cheese.space.spaceCheesePageView.<anonymous>.<anonymous>.<anonymous> (SpaceCheesePageView.kt:29)");
                        }
                        Enum dayNightTheme = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable);
                        SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1614896894, "CC(remember):SpaceCheesePageView.kt#9igjgp");
                        boolean invalid$iv = $composer2.changed(uiController) | $composer2.changed(dayNightTheme.ordinal());
                        Object it$iv = $composer2.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = (Function2) new SpaceCheesePageViewKt$spaceCheesePageView$1$2$1$1$1(uiController, dayNightTheme, null);
                            $composer2.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
                        PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("main.space-pugv.0.0.pv", $composer2, 6);
                        pvTrigger.updateExtra(MapsKt.mapOf(TuplesKt.to(ReportBuildInParam.UP_MID, str)));
                        uiComposableLike.invoke(BackgroundKt.background-bw27NRU$default(modifier, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), $composer2, 0);
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
}