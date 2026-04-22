package kntr.app.tribee.publish.ui.v2;

import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.tribee.base.TribeeEditContent;
import kntr.app.tribee.publish.core.v2.TribeePublishViewModel;
import kntr.app.tribee.publish.core.v2.di.edit.TribeePublishEditComponentEntryPoint;
import kntr.app.tribee.publish.core.v2.di.edit.TribeePublishV2EditComponent;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.compose.launcher.ComposableContainerKt;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.dsl.OuroNodeDSLKt;
import kntr.common.ouro.ui.utils.DisplayLengthTransform_androidKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
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

/* compiled from: TribeePublishEditPage.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007\u001a7\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\t¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\fX\u008a\u008e\u0002²\u0006\f\u0010\r\u001a\u0004\u0018\u00010\u000eX\u008a\u008e\u0002"}, d2 = {"TribeePublishEdit", "Lkntr/common/komponent/Komponent;", "", "id", "", "tribeeIdStr", "tribeeName", "fromSpmid", "PreviewTribeePublishEdit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "showConfirm", "", "initState", "Lkntr/app/tribee/base/TribeeEditContent;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishEditPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewTribeePublishEdit$lambda$4(String str, String str2, String str3, String str4, int i, int i2, Composer composer, int i3) {
        PreviewTribeePublishEdit(str, str2, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Komponent TribeePublishEdit$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 8) != 0) {
            str4 = null;
        }
        return TribeePublishEdit(str, str2, str3, str4);
    }

    public static final Komponent<Unit> TribeePublishEdit(final String id, final String tribeeIdStr, final String tribeeName, final String fromSpmid) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishEditPageKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                SetContentResult TribeePublishEdit$lambda$0;
                TribeePublishEdit$lambda$0 = TribeePublishEditPageKt.TribeePublishEdit$lambda$0(tribeeIdStr, tribeeName, id, fromSpmid, (KomponentScope) obj);
                return TribeePublishEdit$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult TribeePublishEdit$lambda$0(final String $tribeeIdStr, final String $tribeeName, final String $id, final String $fromSpmid, final KomponentScope $this$Komponent) {
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        $this$Komponent.setPopGestureEnabled(new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishEditPageKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean TribeePublishEdit$lambda$0$0;
                TribeePublishEdit$lambda$0$0 = TribeePublishEditPageKt.TribeePublishEdit$lambda$0$0();
                return Boolean.valueOf(TribeePublishEdit$lambda$0$0);
            }
        });
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, $tribeeIdStr, $tribeeName, $id, $fromSpmid) { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishEditPageKt$TribeePublishEdit$lambda$0$$inlined$setContent$1
            final /* synthetic */ String $fromSpmid$inlined;
            final /* synthetic */ String $id$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ String $tribeeIdStr$inlined;
            final /* synthetic */ String $tribeeName$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$tribeeIdStr$inlined = $tribeeIdStr;
                this.$tribeeName$inlined = $tribeeName;
                this.$id$inlined = $id;
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
                $composer.startReplaceGroup(-289731864);
                ComposerKt.sourceInformation($composer, "CN(it)*51@2342L24,53@2403L599,66@3033L100,66@3012L121,70@3153L1348,70@3143L1358:TribeePublishEditPage.kt#oim1ra");
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
                ComposerKt.sourceInformationMarkerStart($composer, 267749239, "CC(remember):TribeePublishEditPage.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                    TribeePublishV2EditComponent.Factory tribeePublishV2EditComponentFactory = ((TribeePublishEditComponentEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeePublishEditComponentEntryPoint.class))).tribeePublishV2EditComponentFactory();
                    Long longOrNull = StringsKt.toLongOrNull(this.$tribeeIdStr$inlined);
                    Object value$iv = tribeePublishV2EditComponentFactory.build(new TribeeInfo(longOrNull != null ? longOrNull.longValue() : 0L, this.$tribeeName$inlined), this.$id$inlined, this.$fromSpmid$inlined != null ? this.$fromSpmid$inlined : "", scope, new OuroState(OuroNodeDSLKt.Document$default(null, null, 3, null), null, null, DisplayLengthTransform_androidKt.getUiDisplayLengthTransform(), null, 22, null)).viewModel();
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                TribeePublishViewModel viewModel = (TribeePublishViewModel) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 267768900, "CC(remember):TribeePublishEditPage.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = (Function2) new TribeePublishEditPageKt$TribeePublishEdit$1$2$1$1(null);
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1288297352, true, new TribeePublishEditPageKt$TribeePublishEdit$1$2$2(viewModel, scope), $composer, 54), $composer, 384, 3);
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
    public static final boolean TribeePublishEdit$lambda$0$0() {
        return false;
    }

    public static final void PreviewTribeePublishEdit(final String id, final String tribeeIdStr, final String tribeeName, String fromSpmid, Composer $composer, final int $changed, final int i) {
        String str;
        String fromSpmid2;
        String fromSpmid3;
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(tribeeIdStr, "tribeeIdStr");
        Intrinsics.checkNotNullParameter(tribeeName, "tribeeName");
        Composer $composer2 = $composer.startRestartGroup(-97968877);
        ComposerKt.sourceInformation($composer2, "C(PreviewTribeePublishEdit)N(id,tribeeIdStr,tribeeName,fromSpmid)121@4914L65,124@5031L7,125@5064L971,125@5043L992:TribeePublishEditPage.kt#oim1ra");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(id) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(tribeeIdStr) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(tribeeName) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            str = fromSpmid;
        } else if (($changed & 3072) == 0) {
            str = fromSpmid;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = fromSpmid;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            fromSpmid2 = str;
        } else {
            if (i2 != 0) {
                fromSpmid3 = null;
            } else {
                fromSpmid3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-97968877, $dirty2, -1, "kntr.app.tribee.publish.ui.v2.PreviewTribeePublishEdit (TribeePublishEditPage.kt:120)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 341198068, "CC(remember):TribeePublishEditPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState initState$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 341203774, "CC(remember):TribeePublishEditPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | $composer2.changedInstance(backHandler);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new TribeePublishEditPageKt$PreviewTribeePublishEdit$1$1(id, initState$delegate, backHandler, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            if (PreviewTribeePublishEdit$lambda$1(initState$delegate) != null) {
                $composer2.startReplaceGroup(1988353262);
                ComposerKt.sourceInformation($composer2, "159@6280L17,160@6306L41");
                UiComposableLike editUI = ComposableContainerKt.runInComposable(TribeePublishEdit(id, tribeeIdStr, tribeeName, fromSpmid3), $composer2, 0);
                editUI.invoke(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer2, 6);
            } else {
                $composer2.startReplaceGroup(1982327823);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            fromSpmid2 = fromSpmid3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str2 = fromSpmid2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishEditPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PreviewTribeePublishEdit$lambda$4;
                    PreviewTribeePublishEdit$lambda$4 = TribeePublishEditPageKt.PreviewTribeePublishEdit$lambda$4(id, tribeeIdStr, tribeeName, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PreviewTribeePublishEdit$lambda$4;
                }
            });
        }
    }

    private static final TribeeEditContent PreviewTribeePublishEdit$lambda$1(MutableState<TribeeEditContent> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TribeeEditContent) $this$getValue$iv.getValue();
    }
}