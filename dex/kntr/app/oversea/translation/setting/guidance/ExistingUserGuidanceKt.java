package kntr.app.oversea.translation.setting.guidance;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.localization.LocaleKt;
import kntr.base.localization.Localization;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.neuron.KNeuron;
import kntr.base.router.Router;
import kntr.common.language.settings.LanguageSettingsServiceKt;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.oversea.translation.setting.guidance.generated.resources.Drawable0_commonMainKt;
import srcs.app.oversea.translation.setting.guidance.generated.resources.Res;

/* compiled from: ExistingUserGuidance.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0012\u001a\u00020\u000eX\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"ExistingUserGuidance", "", "system", "Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;", "current", "onDismiss", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "bottomInset", "", "(Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;Lkntr/app/oversea/translation/setting/guidance/ExistingUserGuidanceData;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "ImageCheckbox", "checked", "", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "translation-setting-guidance_debug", "alwaysTranslateCheck", "displaySystemLanguage", "data"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ExistingUserGuidanceKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$10(ExistingUserGuidanceData existingUserGuidanceData, ExistingUserGuidanceData existingUserGuidanceData2, Function0 function0, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        ExistingUserGuidance(existingUserGuidanceData, existingUserGuidanceData2, function0, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageCheckbox$lambda$0(boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ImageCheckbox(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ExistingUserGuidance(final ExistingUserGuidanceData system, final ExistingUserGuidanceData current, final Function0<Unit> function0, Modifier modifier, float bottomInset, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float bottomInset2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        float bottomInset3;
        Intrinsics.checkNotNullParameter(system, "system");
        Intrinsics.checkNotNullParameter(current, "current");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-1326520367);
        ComposerKt.sourceInformation($composer2, "C(ExistingUserGuidance)N(system,current,onDismiss,modifier,bottomInset)63@2713L149,63@2692L170,71@2893L7,72@2933L33,73@3000L33,74@3050L133,80@3199L7216,80@3189L7226:ExistingUserGuidance.kt#rigd6o");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(system) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(current) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            bottomInset2 = bottomInset;
        } else if (($changed & 24576) == 0) {
            bottomInset2 = bottomInset;
            $dirty2 |= $composer2.changed(bottomInset2) ? 16384 : 8192;
        } else {
            bottomInset2 = bottomInset;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                bottomInset3 = bottomInset2;
            } else {
                bottomInset3 = 0.0f;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1326520367, $dirty2, -1, "kntr.app.oversea.translation.setting.guidance.ExistingUserGuidance (ExistingUserGuidance.kt:57)");
            }
            final Map extra = MapsKt.mapOf(new Pair[]{TuplesKt.to("system_language_identifier", Localization.INSTANCE.getSYSTEM().toLanguageTag()), TuplesKt.to("app_language_identifier", Localization.INSTANCE.getCurrent().toLanguageTag())});
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 819227942, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(extra);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                Object value$iv = (Function2) new ExistingUserGuidanceKt$ExistingUserGuidance$1$1(extra, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                $dirty = $dirty2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 819234866, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState alwaysTranslateCheck$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 819237010, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState displaySystemLanguage$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            boolean ExistingUserGuidance$lambda$5 = ExistingUserGuidance$lambda$5(displaySystemLanguage$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, 819238710, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(ExistingUserGuidance$lambda$5);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        ExistingUserGuidanceData ExistingUserGuidance$lambda$7$0;
                        ExistingUserGuidance$lambda$7$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$7$0(ExistingUserGuidanceData.this, current, displaySystemLanguage$delegate);
                        return ExistingUserGuidance$lambda$7$0;
                    }
                });
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final State data$delegate = (State) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Modifier modifier5 = modifier4;
            final float f = bottomInset3;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-328068215, true, new Function2() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExistingUserGuidance$lambda$9;
                    ExistingUserGuidance$lambda$9 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9(modifier5, extra, router, data$delegate, function0, f, displaySystemLanguage$delegate, alwaysTranslateCheck$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ExistingUserGuidance$lambda$9;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            bottomInset2 = bottomInset3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final float f2 = bottomInset2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExistingUserGuidance$lambda$10;
                    ExistingUserGuidance$lambda$10 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$10(ExistingUserGuidanceData.this, current, function0, modifier6, f2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ExistingUserGuidance$lambda$10;
                }
            });
        }
    }

    private static final boolean ExistingUserGuidance$lambda$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ExistingUserGuidance$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean ExistingUserGuidance$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ExistingUserGuidance$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final ExistingUserGuidanceData ExistingUserGuidance$lambda$8(State<ExistingUserGuidanceData> state) {
        Object thisObj$iv = state.getValue();
        return (ExistingUserGuidanceData) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExistingUserGuidanceData ExistingUserGuidance$lambda$7$0(ExistingUserGuidanceData $system, ExistingUserGuidanceData $current, MutableState $displaySystemLanguage$delegate) {
        return ExistingUserGuidance$lambda$5($displaySystemLanguage$delegate) ? $system : $current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x053c, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0bb1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0c4d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0c59  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0c5f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0db0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ExistingUserGuidance$lambda$9(Modifier $modifier, final Map $extra, final Router $router, final State $data$delegate, final Function0 $onDismiss, float $bottomInset, final MutableState $displaySystemLanguage$delegate, final MutableState $alwaysTranslateCheck$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Painter caption_change_line_500;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 value$iv;
        boolean invalid$iv;
        Object it$iv;
        Function0 value$iv2;
        String str;
        boolean invalid$iv2;
        Object it$iv2;
        Function0 factory$iv$iv$iv6;
        ComposerKt.sourceInformation($composer, "C87@3454L6,81@3209L7200:ExistingUserGuidance.kt#rigd6o");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-328068215, $changed, -1, "kntr.app.oversea.translation.setting.guidance.ExistingUserGuidance.<anonymous> (ExistingUserGuidance.kt:81)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(ClipKt.clip(SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null)), Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -352166304, "C98@3936L6,92@3695L301,100@4009L1414,137@5546L6,134@5437L315,147@5883L6,144@5766L246,156@6168L53,152@6026L764,174@6804L2288,233@9379L394,227@9106L1193,258@10313L86:ExistingUserGuidance.kt#rigd6o");
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 1, (Object) null), Dp.constructor-impl(30)), Dp.constructor-impl(3)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa3-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer, 0);
            Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            BoxScope $this$ExistingUserGuidance_u24lambda_u249_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -269054706, "C103@4098L172,107@4287L1122:ExistingUserGuidance.kt#rigd6o");
            BiliImageKt.BiliImage(new ImageRequest(ExistingUserGuidance$lambda$8($data$delegate).getIconUrl()).build(), $this$ExistingUserGuidance_u24lambda_u249_u240_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), Alignment.Companion.getCenter()), null, null, null, null, null, null, null, $composer, 0, 508);
            Modifier modifier$iv3 = $this$ExistingUserGuidance_u24lambda_u249_u240_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd());
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1019297208, "C114@4705L115,111@4470L373,120@4925L20,122@5029L339,119@4865L526:ExistingUserGuidance.kt#rigd6o");
            if (ExistingUserGuidance$lambda$5($displaySystemLanguage$delegate)) {
                $composer.startReplaceGroup(32882440);
                ComposerKt.sourceInformation($composer, "112@4557L22");
                caption_change_line_500 = BiliIconfont.INSTANCE.getOriginal_text_line_500($composer, 6);
            } else {
                $composer.startReplaceGroup(32883753);
                ComposerKt.sourceInformation($composer, "112@4598L23");
                caption_change_line_500 = BiliIconfont.INSTANCE.getCaption_change_line_500($composer, 6);
            }
            $composer.endReplaceGroup();
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 32887269, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            Object value$iv3 = $composer.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit ExistingUserGuidance$lambda$9$0$0$0$0$0;
                        ExistingUserGuidance$lambda$9$0$0$0$0$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$0$0$0$0($displaySystemLanguage$delegate);
                        return ExistingUserGuidance$lambda$9$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton(caption_change_line_500, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv3, 15, (Object) null), $composer, Painter.$stable, 0);
            Painter xmark_close_line_500 = BiliIconfont.INSTANCE.getXmark_close_line_500($composer, 6);
            Modifier modifier2 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, 32897861, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($extra) | $composer.changed($onDismiss);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit ExistingUserGuidance$lambda$9$0$0$0$1$0;
                    ExistingUserGuidance$lambda$9$0$0$0$1$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$0$0$1$0($extra, $onDismiss);
                    return ExistingUserGuidance$lambda$9$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton(xmark_close_line_500, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), $composer, Painter.$stable, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(18), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 2, 0, (Function1) null, (TextStyle) null, $composer, 1597488, 24576, 244648);
            TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getFormattedDesc(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24624, 0, 261096);
            Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1673855704, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit ExistingUserGuidance$lambda$9$0$1$0;
                        ExistingUserGuidance$lambda$9$0$1$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$1$0($alwaysTranslateCheck$delegate);
                        return ExistingUserGuidance$lambda$9$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv4, 15, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv4 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1258677470, "C160@6374L145,168@6656L6,165@6537L239:ExistingUserGuidance.kt#rigd6o");
            ImageCheckbox(ExistingUserGuidance$lambda$2($alwaysTranslateCheck$delegate), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), $composer, 48, 0);
            String tip = ExistingUserGuidance$lambda$8($data$delegate).getTip();
            long sp = TextUnitKt.getSp(12);
            TextKt.Text-Nvy7gAk(tip, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getStart-e0LSkKk()), TextUnitKt.getSp(14), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 48, 259050);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv5 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(60));
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv5 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i10 = ((438 >> 6) & 112) | 6;
            RowScope $this$ExistingUserGuidance_u24lambda_u249_u240_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1303167165, "C189@7485L48,190@7611L6,180@7092L292,192@7723L273,179@7054L942,215@8686L6,215@8646L58,202@8052L493,217@8799L279,201@8014L1064:ExistingUserGuidance.kt#rigd6o");
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(30));
            ButtonColors buttonColors = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(Color.Companion.getTransparent-0d7_KjU(), 0L, 0L, 0L, $composer, (ButtonDefaults.$stable << 12) | 6, 14);
            BorderStroke borderStroke = BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_bold-0d7_KjU());
            Modifier modifier4 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ExistingUserGuidance_u24lambda_u249_u240_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer, -1566058820, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed($extra) | $composer.changed($onDismiss);
            Object it$iv5 = $composer.rememberedValue();
            if (!invalid$iv4 && it$iv5 != Composer.Companion.getEmpty()) {
                value$iv = it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv, modifier4, false, shape, buttonColors, (ButtonElevation) null, borderStroke, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(2030613160, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ExistingUserGuidance$lambda$9$0$3$1;
                        ExistingUserGuidance$lambda$9$0$3$1 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$1($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ExistingUserGuidance$lambda$9$0$3$1;
                    }
                }, $composer, 54), $composer, 805306368, 420);
                Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(30));
                ButtonColors buttonColors2 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
                Modifier modifier5 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ExistingUserGuidance_u24lambda_u249_u240_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44));
                ComposerKt.sourceInformationMarkerStart($composer, -1566027899, "CC(remember):ExistingUserGuidance.kt#9igjgp");
                invalid$iv = $composer.changed($extra) | $composer.changed($onDismiss);
                it$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    value$iv2 = it$iv;
                    str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ButtonKt.Button(value$iv2, modifier5, false, shape2, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1164428113, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit ExistingUserGuidance$lambda$9$0$3$3;
                            ExistingUserGuidance$lambda$9$0$3$3 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$3($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return ExistingUserGuidance$lambda$9$0$3$3;
                        }
                    }, $composer, 54), $composer, 805306368, 484);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                    Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                    Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, -1673752611, "CC(remember):ExistingUserGuidance.kt#9igjgp");
                    invalid$iv2 = $composer.changed($extra) | $composer.changedInstance($router) | $composer.changed($data$delegate) | $composer.changed($onDismiss);
                    it$iv2 = $composer.rememberedValue();
                    if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit ExistingUserGuidance$lambda$9$0$4$0;
                                ExistingUserGuidance$lambda$9$0$4$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$4$0($extra, $router, $onDismiss, $data$delegate);
                                return ExistingUserGuidance$lambda$9$0$4$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv2 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                    Arrangement.Horizontal horizontalArrangement$iv4 = horizontal;
                    ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv6 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
                    Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, str);
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if (!$composer.getInserting()) {
                        factory$iv$iv$iv6 = factory$iv$iv$iv12;
                        $composer.createNode(factory$iv$iv$iv6);
                    } else {
                        factory$iv$iv$iv6 = factory$iv$iv$iv12;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                    int i12 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -259427122, "C246@9939L6,243@9807L213,252@10140L28,253@10207L6,250@10038L247:ExistingUserGuidance.kt#rigd6o");
                    TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getGotoSettingsText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261098);
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    float $this$dp$iv = Dp.constructor-impl($bottomInset);
                    BoxKt.Box(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($this$dp$iv + Dp.constructor-impl(16))), $composer, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                value$iv2 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit ExistingUserGuidance$lambda$9$0$3$2$0;
                        ExistingUserGuidance$lambda$9$0$3$2$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$2$0($extra, $onDismiss, $alwaysTranslateCheck$delegate);
                        return ExistingUserGuidance$lambda$9$0$3$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv2, modifier5, false, shape2, buttonColors2, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1164428113, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ExistingUserGuidance$lambda$9$0$3$3;
                        ExistingUserGuidance$lambda$9$0$3$3 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$3($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ExistingUserGuidance$lambda$9$0$3$3;
                    }
                }, $composer, 54), $composer, 805306368, 484);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Arrangement.Horizontal horizontal2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                Alignment.Vertical verticalAlignment$iv42 = Alignment.Companion.getCenterVertically();
                Modifier modifier62 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1673752611, "CC(remember):ExistingUserGuidance.kt#9igjgp");
                invalid$iv2 = $composer.changed($extra) | $composer.changedInstance($router) | $composer.changed($data$delegate) | $composer.changed($onDismiss);
                it$iv2 = $composer.rememberedValue();
                if (!invalid$iv2) {
                }
                Object value$iv62 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ExistingUserGuidance$lambda$9$0$4$0;
                        ExistingUserGuidance$lambda$9$0$4$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$4$0($extra, $router, $onDismiss, $data$delegate);
                        return ExistingUserGuidance$lambda$9$0$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv62);
                it$iv2 = value$iv62;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv62 = ClickableKt.clickable-oSLSa3U$default(modifier62, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv42 = horizontal2;
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv62 = RowKt.rowMeasurePolicy(horizontalArrangement$iv42, verticalAlignment$iv42, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv62 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv62 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv62 = ComposedModifierKt.materializeModifier($composer, modifier$iv62);
                Function0 factory$iv$iv$iv122 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str);
                if (!($composer.getApplier() instanceof Applier)) {
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv62, ComposeUiNode.Companion.getSetModifier());
                int i112 = ($changed$iv$iv$iv62 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope32 = RowScopeInstance.INSTANCE;
                int i122 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -259427122, "C246@9939L6,243@9807L213,252@10140L28,253@10207L6,250@10038L247:ExistingUserGuidance.kt#rigd6o");
                TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getGotoSettingsText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261098);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                float $this$dp$iv2 = Dp.constructor-impl($bottomInset);
                BoxKt.Box(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($this$dp$iv2 + Dp.constructor-impl(16))), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit ExistingUserGuidance$lambda$9$0$3$0$0;
                    ExistingUserGuidance$lambda$9$0$3$0$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$0$0($extra, $onDismiss);
                    return ExistingUserGuidance$lambda$9$0$3$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(value$iv, modifier4, false, shape, buttonColors, (ButtonElevation) null, borderStroke, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(2030613160, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ExistingUserGuidance$lambda$9$0$3$1;
                    ExistingUserGuidance$lambda$9$0$3$1 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$1($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ExistingUserGuidance$lambda$9$0$3$1;
                }
            }, $composer, 54), $composer, 805306368, 420);
            Shape shape22 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(30));
            ButtonColors buttonColors22 = ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, 0L, 0L, $composer, ButtonDefaults.$stable << 12, 14);
            Modifier modifier52 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ExistingUserGuidance_u24lambda_u249_u240_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer, -1566027899, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            invalid$iv = $composer.changed($extra) | $composer.changed($onDismiss);
            it$iv = $composer.rememberedValue();
            if (!invalid$iv) {
                value$iv2 = it$iv;
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.Button(value$iv2, modifier52, false, shape22, buttonColors22, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1164428113, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit ExistingUserGuidance$lambda$9$0$3$3;
                        ExistingUserGuidance$lambda$9$0$3$3 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$3($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return ExistingUserGuidance$lambda$9$0$3$3;
                    }
                }, $composer, 54), $composer, 805306368, 484);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Arrangement.Horizontal horizontal22 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                Alignment.Vertical verticalAlignment$iv422 = Alignment.Companion.getCenterVertically();
                Modifier modifier622 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1673752611, "CC(remember):ExistingUserGuidance.kt#9igjgp");
                invalid$iv2 = $composer.changed($extra) | $composer.changedInstance($router) | $composer.changed($data$delegate) | $composer.changed($onDismiss);
                it$iv2 = $composer.rememberedValue();
                if (!invalid$iv2) {
                }
                Object value$iv622 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit ExistingUserGuidance$lambda$9$0$4$0;
                        ExistingUserGuidance$lambda$9$0$4$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$4$0($extra, $router, $onDismiss, $data$delegate);
                        return ExistingUserGuidance$lambda$9$0$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv622);
                it$iv2 = value$iv622;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv622 = ClickableKt.clickable-oSLSa3U$default(modifier622, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv422 = horizontal22;
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv622 = RowKt.rowMeasurePolicy(horizontalArrangement$iv422, verticalAlignment$iv422, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv622 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv622 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv622 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv622 = ComposedModifierKt.materializeModifier($composer, modifier$iv622);
                Function0 factory$iv$iv$iv1222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv622 = (($changed$iv$iv622 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str);
                if (!($composer.getApplier() instanceof Applier)) {
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv622 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv622, measurePolicy$iv622, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv622, localMap$iv$iv622, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv622, Integer.valueOf(compositeKeyHash$iv$iv622), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv622, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv622, materialized$iv$iv622, ComposeUiNode.Companion.getSetModifier());
                int i1122 = ($changed$iv$iv$iv622 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope322 = RowScopeInstance.INSTANCE;
                int i1222 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -259427122, "C246@9939L6,243@9807L213,252@10140L28,253@10207L6,250@10038L247:ExistingUserGuidance.kt#rigd6o");
                TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getGotoSettingsText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261098);
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                float $this$dp$iv22 = Dp.constructor-impl($bottomInset);
                BoxKt.Box(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($this$dp$iv22 + Dp.constructor-impl(16))), $composer, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            value$iv2 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit ExistingUserGuidance$lambda$9$0$3$2$0;
                    ExistingUserGuidance$lambda$9$0$3$2$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$2$0($extra, $onDismiss, $alwaysTranslateCheck$delegate);
                    return ExistingUserGuidance$lambda$9$0$3$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(value$iv2, modifier52, false, shape22, buttonColors22, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(1164428113, true, new Function3() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ExistingUserGuidance$lambda$9$0$3$3;
                    ExistingUserGuidance$lambda$9$0$3$3 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$3$3($data$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ExistingUserGuidance$lambda$9$0$3$3;
                }
            }, $composer, 54), $composer, 805306368, 484);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Arrangement.Horizontal horizontal222 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv4222 = Alignment.Companion.getCenterVertically();
            Modifier modifier6222 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1673752611, "CC(remember):ExistingUserGuidance.kt#9igjgp");
            invalid$iv2 = $composer.changed($extra) | $composer.changedInstance($router) | $composer.changed($data$delegate) | $composer.changed($onDismiss);
            it$iv2 = $composer.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv6222 = new Function0() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit ExistingUserGuidance$lambda$9$0$4$0;
                    ExistingUserGuidance$lambda$9$0$4$0 = ExistingUserGuidanceKt.ExistingUserGuidance$lambda$9$0$4$0($extra, $router, $onDismiss, $data$delegate);
                    return ExistingUserGuidance$lambda$9$0$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv6222);
            it$iv2 = value$iv6222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv6222 = ClickableKt.clickable-oSLSa3U$default(modifier6222, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv4222 = horizontal222;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv6222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4222, verticalAlignment$iv4222, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv6222 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv6222 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6222 = ComposedModifierKt.materializeModifier($composer, modifier$iv6222);
            Function0 factory$iv$iv$iv12222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6222 = (($changed$iv$iv6222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, str);
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6222 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6222, measurePolicy$iv6222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6222, localMap$iv$iv6222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6222, Integer.valueOf(compositeKeyHash$iv$iv6222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6222, materialized$iv$iv6222, ComposeUiNode.Companion.getSetModifier());
            int i11222 = ($changed$iv$iv$iv6222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3222 = RowScopeInstance.INSTANCE;
            int i12222 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -259427122, "C246@9939L6,243@9807L213,252@10140L28,253@10207L6,250@10038L247:ExistingUserGuidance.kt#rigd6o");
            TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getGotoSettingsText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 261098);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            float $this$dp$iv222 = Dp.constructor-impl($bottomInset);
            BoxKt.Box(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($this$dp$iv222 + Dp.constructor-impl(16))), $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$0$0$0$0(MutableState $displaySystemLanguage$delegate) {
        ExistingUserGuidance$lambda$6($displaySystemLanguage$delegate, !ExistingUserGuidance$lambda$5($displaySystemLanguage$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$0$0$1$0(Map $extra, Function0 $onDismiss) {
        KNeuron.INSTANCE.reportClick(false, "main.homepage.translation-popup-olduser.close.click", $extra);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$1$0(MutableState $alwaysTranslateCheck$delegate) {
        ExistingUserGuidance$lambda$3($alwaysTranslateCheck$delegate, !ExistingUserGuidance$lambda$2($alwaysTranslateCheck$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$3$0$0(Map $extra, Function0 $onDismiss) {
        KNeuron.INSTANCE.reportClick(false, "main.homepage.translation-popup-olduser.no-translation.click", $extra);
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$3$1(State $data$delegate, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C196@7889L6,193@7745L233:ExistingUserGuidance.kt#rigd6o");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2030613160, $changed, -1, "kntr.app.oversea.translation.setting.guidance.ExistingUserGuidance.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExistingUserGuidance.kt:193)");
            }
            TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getCancelButtonText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, new FontWeight((int) ConstantsKt.UPCOMING_EP_LIST_DIALOG_DEFAULT_MIN_HEIGHT), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 0, 262058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$3$2$0(Map $extra, Function0 $onDismiss, MutableState $alwaysTranslateCheck$delegate) {
        KNeuron.INSTANCE.reportClick(false, "main.homepage.translation-popup-olduser.translation.click", $extra);
        LanguageSettingsServiceKt.applyLanguageSettings(LocaleKt.getNormalized(Localization.INSTANCE.getSYSTEM()), ExistingUserGuidance$lambda$2($alwaysTranslateCheck$delegate));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$3$3(State $data$delegate, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C221@8966L6,218@8821L239:ExistingUserGuidance.kt#rigd6o");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1164428113, $changed, -1, "kntr.app.oversea.translation.setting.guidance.ExistingUserGuidance.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExistingUserGuidance.kt:218)");
            }
            TextKt.Text-Nvy7gAk(ExistingUserGuidance$lambda$8($data$delegate).getConfirmButtonText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, new FontWeight((int) ConstantsKt.UPCOMING_EP_LIST_DIALOG_DEFAULT_MIN_HEIGHT), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 0, 262058);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExistingUserGuidance$lambda$9$0$4$0(Map $extra, Router $router, Function0 $onDismiss, State $data$delegate) {
        KNeuron.INSTANCE.reportClick(false, "main.homepage.translation-popup-olduser.setting.click", $extra);
        $router.launch(Uri.Companion.parse(ExistingUserGuidance$lambda$8($data$delegate).getGotoSettingsUri()));
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    private static final void ImageCheckbox(final boolean checked, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        DrawableResource checkbox_unselected;
        Composer $composer2 = $composer.startRestartGroup(-102463619);
        ComposerKt.sourceInformation($composer2, "C(ImageCheckbox)N(checked,modifier)272@10560L209,270@10523L329:ExistingUserGuidance.kt#rigd6o");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-102463619, $dirty2, -1, "kntr.app.oversea.translation.setting.guidance.ImageCheckbox (ExistingUserGuidance.kt:269)");
            }
            if (checked) {
                checkbox_unselected = Drawable0_commonMainKt.getCheckbox_selected(Res.drawable.INSTANCE);
            } else {
                checkbox_unselected = Drawable0_commonMainKt.getCheckbox_unselected(Res.drawable.INSTANCE);
            }
            Modifier modifier4 = modifier3;
            ImageKt.Image(ImageResourcesKt.painterResource(checkbox_unselected, $composer2, 0), (String) null, SizeKt.size-3ABfNKs(modifier3, Dp.constructor-impl(16)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | 48, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.oversea.translation.setting.guidance.ExistingUserGuidanceKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageCheckbox$lambda$0;
                    ImageCheckbox$lambda$0 = ExistingUserGuidanceKt.ImageCheckbox$lambda$0(checked, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageCheckbox$lambda$0;
                }
            });
        }
    }
}