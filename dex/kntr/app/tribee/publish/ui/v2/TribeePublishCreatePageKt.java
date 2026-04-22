package kntr.app.tribee.publish.ui.v2;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.publish.core.v2.TribeePublishViewModel;
import kntr.app.tribee.publish.core.v2.di.create.TribeePublishCreateComponentEntryPoint;
import kntr.app.tribee.publish.core.v2.di.create.TribeePublishV2CreateComponent;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.dsl.OuroNodeDSLKt;
import kntr.common.ouro.ui.utils.DisplayLengthTransform_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeePublishCreatePage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"TribeePublishCreatePage", "Lkntr/common/komponent/Komponent;", "", "tribeeIdStr", "", "tribeeName", "resultKey", "fromSpmid", "ui_debug", "showDraftDialog", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishCreatePageKt {
    public static /* synthetic */ Komponent TribeePublishCreatePage$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return TribeePublishCreatePage(str, str2, str3, str4);
    }

    public static final Komponent<Unit> TribeePublishCreatePage(final String tribeeIdStr, final String tribeeName, final String resultKey, final String fromSpmid) {
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult TribeePublishCreatePage$lambda$0;
                TribeePublishCreatePage$lambda$0 = TribeePublishCreatePageKt.TribeePublishCreatePage$lambda$0(tribeeIdStr, tribeeName, resultKey, fromSpmid, (KomponentScope) obj);
                return TribeePublishCreatePage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult TribeePublishCreatePage$lambda$0(final String $tribeeIdStr, final String $tribeeName, final String $resultKey, final String $fromSpmid, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPopGestureEnabled(new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean TribeePublishCreatePage$lambda$0$0;
                TribeePublishCreatePage$lambda$0$0 = TribeePublishCreatePageKt.TribeePublishCreatePage$lambda$0$0();
                return Boolean.valueOf(TribeePublishCreatePage$lambda$0$0);
            }
        });
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, $tribeeIdStr, $tribeeName, $resultKey, $fromSpmid) { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishCreatePageKt$TribeePublishCreatePage$lambda$0$$inlined$setContent$1
            final /* synthetic */ String $fromSpmid$inlined;
            final /* synthetic */ String $resultKey$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ String $tribeeIdStr$inlined;
            final /* synthetic */ String $tribeeName$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$tribeeIdStr$inlined = $tribeeIdStr;
                this.$tribeeName$inlined = $tribeeName;
                this.$resultKey$inlined = $resultKey;
                this.$fromSpmid$inlined = $fromSpmid;
                this.state = state$iv$iv;
            }

            @Override // kntr.common.komponent.UiComposableLike
            public void invoke(Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(820621504);
                ComposerKt.sourceInformation($composer, "CN(it)*43@1876L24,45@1937L642,59@2610L102,59@2589L123,63@2732L2064,63@2722L2074:TribeePublishCreatePage.kt#oim1ra");
                ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.Companion.getEmpty()) {
                    Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                    $composer.updateRememberedValue(value$iv$iv);
                    it$iv$iv = value$iv$iv;
                }
                CoroutineScope scope = (CoroutineScope) it$iv$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1827587025, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                    TribeePublishV2CreateComponent.Factory tribeePublishV2ComponentFactory = ((TribeePublishCreateComponentEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeePublishCreateComponentEntryPoint.class))).tribeePublishV2ComponentFactory();
                    Long longOrNull = StringsKt.toLongOrNull(this.$tribeeIdStr$inlined);
                    Object value$iv = tribeePublishV2ComponentFactory.build(new TribeeInfo(longOrNull != null ? longOrNull.longValue() : 0L, this.$tribeeName$inlined), this.$resultKey$inlined != null ? this.$resultKey$inlined : "", this.$fromSpmid$inlined != null ? this.$fromSpmid$inlined : "", scope, new OuroState(OuroNodeDSLKt.Document$default(null, null, 3, null), null, null, DisplayLengthTransform_androidKt.getUiDisplayLengthTransform(), null, 22, null)).viewModel();
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                TribeePublishViewModel viewModel = (TribeePublishViewModel) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1827608021, "CC(remember):TribeePublishCreatePage.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = (Function2) new TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$1$1(null);
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(965044327, true, new TribeePublishCreatePageKt$TribeePublishCreatePage$1$2$2(viewModel, scope), $composer, 54), $composer, 384, 3);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            @Override // kntr.common.komponent.UiComposableLike
            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            @Override // kntr.common.komponent.UiComposableLike
            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            @Override // kntr.common.komponent.UiComposableLike
            public S getState() {
                return this.state;
            }

            @Override // kntr.common.komponent.UiComposableLike
            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TribeePublishCreatePage$lambda$0$0() {
        return false;
    }
}