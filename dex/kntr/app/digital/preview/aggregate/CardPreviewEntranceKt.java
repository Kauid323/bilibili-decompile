package kntr.app.digital.preview.aggregate;

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
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.digital.preview.RouterParams;
import kntr.app.digital.preview.SimpleCard;
import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.compose.launcher.KomponentRouterKt;
import kntr.common.compose.launcher.LifecycleKt;
import kntr.common.compose.launcher.LocalToasterKt;
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
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: CardPreviewEntrance.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u001aj\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0001¨\u0006\r"}, d2 = {"cardPreviewEntrance", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "act_id", RoomRecommendViewModel.EMPTY_CURSOR, "anchor_id", "vmid", "lottery_id", "f_source", "from", "from_id", "owned_status", "simple_card", "preview_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CardPreviewEntranceKt {
    public static final Komponent<Unit> cardPreviewEntrance(final String act_id, final String anchor_id, final String vmid, final String lottery_id, final String f_source, final String from, final String from_id, final String owned_status, final String simple_card) {
        Intrinsics.checkNotNullParameter(act_id, "act_id");
        Intrinsics.checkNotNullParameter(anchor_id, "anchor_id");
        Intrinsics.checkNotNullParameter(vmid, "vmid");
        Intrinsics.checkNotNullParameter(lottery_id, "lottery_id");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.digital.preview.aggregate.CardPreviewEntranceKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                SetContentResult cardPreviewEntrance$lambda$0;
                cardPreviewEntrance$lambda$0 = CardPreviewEntranceKt.cardPreviewEntrance$lambda$0(act_id, vmid, lottery_id, f_source, from, from_id, simple_card, anchor_id, owned_status, (KomponentScope) obj);
                return cardPreviewEntrance$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult cardPreviewEntrance$lambda$0(String $act_id, String $vmid, String $lottery_id, String $f_source, String $from, String $from_id, String $simple_card, String $anchor_id, String $owned_status, final KomponentScope $this$Komponent) {
        SimpleCard simpleCard;
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPreferredOrientation(new Function0() { // from class: kntr.app.digital.preview.aggregate.CardPreviewEntranceKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                Orientation orientation;
                orientation = Orientation.UserPortrait;
                return orientation;
            }
        });
        CardPreviewComponent.Factory cardPreviewComponentFactory = CardPreviewComponent_androidKt.cardPreviewComponentFactory();
        Lifecycle lifecycle = ((LifecycleOwner) $this$Komponent.getCurrent(LifecycleKt.getLocalLifecycleOwner())).getLifecycle();
        Integer intOrNull = StringsKt.toIntOrNull($act_id);
        int intValue = intOrNull != null ? intOrNull.intValue() : 0;
        Long longOrNull = StringsKt.toLongOrNull($vmid);
        long longValue = longOrNull != null ? longOrNull.longValue() : 0L;
        Long longOrNull2 = StringsKt.toLongOrNull($lottery_id);
        long longValue2 = longOrNull2 != null ? longOrNull2.longValue() : 0L;
        JsonObjectBuilder builder$iv = new JsonObjectBuilder();
        JsonElementBuildersKt.put(builder$iv, "owned_status", $owned_status == null ? AdSearchSubCardType.CARD_TYPE_NONE : $owned_status);
        Unit unit = Unit.INSTANCE;
        String jsonObject = builder$iv.build().toString();
        String str = $f_source == null ? RoomRecommendViewModel.EMPTY_CURSOR : $f_source;
        String str2 = $from == null ? RoomRecommendViewModel.EMPTY_CURSOR : $from;
        String str3 = $from_id == null ? RoomRecommendViewModel.EMPTY_CURSOR : $from_id;
        if ($simple_card == null) {
            simpleCard = null;
        } else {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            simpleCard = (SimpleCard) this_$iv.decodeFromString(BuiltinSerializersKt.getNullable(SimpleCard.Companion.serializer()), $simple_card);
        }
        CardPreviewComponent component = cardPreviewComponentFactory.create(lifecycle, new RouterParams(intValue, longValue, $anchor_id, longValue2, jsonObject, 2, str, str2, str3, simpleCard), (Toaster) $this$Komponent.getCurrent(LocalToasterKt.getLocalToaster()), (Router) $this$Komponent.getCurrent(KomponentRouterKt.getLocalRouter()), $this$Komponent);
        CardPreviewComponent_androidKt.initCardPreviewForPlatform($this$Komponent);
        final UiComposableLike child = KomponentHostScope.-CC.embed$default((KomponentHostScope) $this$Komponent, component.pageModel().komponent(), (Function1) null, 2, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, child) { // from class: kntr.app.digital.preview.aggregate.CardPreviewEntranceKt$cardPreviewEntrance$lambda$0$$inlined$setContent$1
            final /* synthetic */ UiComposableLike $child$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
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
                $composer.startReplaceGroup(-356607758);
                ComposerKt.sourceInformation($composer, "CN(modifier)*65@2544L318,65@2534L328:CardPreviewEntrance.kt#5q7t49");
                final UiComposableLike uiComposableLike = this.$child$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-2121785055, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.digital.preview.aggregate.CardPreviewEntranceKt$cardPreviewEntrance$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C66@2577L28,67@2639L64,67@2618L85,70@2716L136:CardPreviewEntrance.kt#5q7t49");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2121785055, $changed2, -1, "kntr.app.digital.preview.aggregate.cardPreviewEntrance.<anonymous>.<anonymous>.<anonymous> (CardPreviewEntrance.kt:66)");
                        }
                        SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer2, 0);
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, 1074030849, "CC(remember):CardPreviewEntrance.kt#9igjgp");
                        boolean invalid$iv = $composer2.changed(uiController);
                        Object it$iv = $composer2.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = (Function2) new CardPreviewEntranceKt$cardPreviewEntrance$1$2$1$1$1(uiController, null);
                            $composer2.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit2, (Function2) it$iv, $composer2, 6);
                        uiComposableLike.invoke(WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(modifier, Color.Companion.getBlack-0d7_KjU(), (Shape) null, 2, (Object) null)), $composer2, 0);
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