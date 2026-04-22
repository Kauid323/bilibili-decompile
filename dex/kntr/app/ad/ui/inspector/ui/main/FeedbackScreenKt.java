package kntr.app.ad.ui.inspector.ui.main;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextFieldKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.EmptyJobData;
import kntr.app.ad.domain.inspector.core.work.IJob;
import kntr.app.ad.domain.inspector.core.work.IJobData;
import kntr.app.ad.domain.inspector.core.work.NormalJobData;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.core.work.RequestJobData;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.LocalUserRoleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;

/* compiled from: FeedbackScreen.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a!\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002¨\u0006\n²\u0006\n\u0010\u000b\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\n\u0010\u000e\u001a\u00020\rX\u008a\u008e\u0002"}, d2 = {"FeedbackScreen", RoomRecommendViewModel.EMPTY_CURSOR, "adId", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Ljava/lang/String;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "encodeToString", "Lkotlinx/serialization/json/JsonElement;", "Lkntr/app/ad/domain/inspector/core/work/IJobData;", "ad-inspector_debug", "feedbackText", "isSubmitting", RoomRecommendViewModel.EMPTY_CURSOR, "showSuccessMessage"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FeedbackScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackScreen$lambda$10(String str, PaddingValues paddingValues, int i, int i2, Composer composer, int i3) {
        FeedbackScreen(str, paddingValues, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void FeedbackScreen(final String adId, PaddingValues paddingValues, Composer $composer, final int $changed, final int i) {
        final PaddingValues paddingValues2;
        Composer $composer2;
        PaddingValues paddingValues3;
        Function0 factory$iv$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(-1649080115);
        ComposerKt.sourceInformation($composer3, "C(FeedbackScreen)N(adId,paddingValues)55@2428L31,56@2484L34,57@2549L34,59@2589L5925:FeedbackScreen.kt#flo5hv");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(adId) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            paddingValues2 = paddingValues;
        } else if (($changed & 48) == 0) {
            paddingValues2 = paddingValues;
            $dirty |= $composer3.changed(paddingValues2) ? 32 : 16;
        } else {
            paddingValues2 = paddingValues;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                paddingValues3 = PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(0));
            } else {
                paddingValues3 = paddingValues2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1649080115, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.FeedbackScreen (FeedbackScreen.kt:54)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 76945676, "CC(remember):FeedbackScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState feedbackText$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 76947471, "CC(remember):FeedbackScreen.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState isSubmitting$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 76949551, "CC(remember):FeedbackScreen.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState showSuccessMessage$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(paddingValues3.calculateTopPadding-D9Ej5fM() + Dp.constructor-impl(16)), Dp.constructor-impl(16), Dp.constructor-impl(paddingValues3.calculateBottomPadding-D9Ej5fM() + Dp.constructor-impl(16)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            PaddingValues paddingValues4 = paddingValues3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -827030399, "C76@3143L4571,71@2961L4753:FeedbackScreen.kt#flo5hv");
            SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-194389604, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedbackScreen$lambda$9$0;
                    FeedbackScreen$lambda$9$0 = FeedbackScreenKt.FeedbackScreen$lambda$9$0(adId, feedbackText$delegate, isSubmitting$delegate, showSuccessMessage$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedbackScreen$lambda$9$0;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (FeedbackScreen$lambda$7(showSuccessMessage$delegate)) {
                $composer3.startReplaceGroup(-822414717);
                ComposerKt.sourceInformation($composer3, "178@7778L41,179@7832L485,194@8393L105,194@8358L140");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
                SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)), ColorKt.Color(4292672743L), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableSingletons$FeedbackScreenKt.INSTANCE.getLambda$509023905$ad_inspector_debug(), $composer3, 12583302, 120);
                Boolean valueOf = Boolean.valueOf(FeedbackScreen$lambda$7(showSuccessMessage$delegate));
                ComposerKt.sourceInformationMarkerStart($composer3, -2104720000, "CC(remember):FeedbackScreen.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = (Function2) new FeedbackScreenKt$FeedbackScreen$1$2$1(showSuccessMessage$delegate, null);
                    $composer3.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv4, $composer3, 0);
            } else {
                $composer3.startReplaceGroup(-830140661);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            paddingValues2 = paddingValues4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedbackScreen$lambda$10;
                    FeedbackScreen$lambda$10 = FeedbackScreenKt.FeedbackScreen$lambda$10(adId, paddingValues2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedbackScreen$lambda$10;
                }
            });
        }
    }

    private static final String FeedbackScreen$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final boolean FeedbackScreen$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void FeedbackScreen$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean FeedbackScreen$lambda$7(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FeedbackScreen$lambda$8(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackScreen$lambda$9$0(final String $adId, final MutableState $feedbackText$delegate, final MutableState $isSubmitting$delegate, final MutableState $showSuccessMessage$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Object value$iv;
        ComposerKt.sourceInformation($composer, "C77@3157L4547:FeedbackScreen.kt#flo5hv");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-194389604, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.FeedbackScreen.<anonymous>.<anonymous> (FeedbackScreen.kt:77)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$FeedbackScreen_u24lambda_u249_u240_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1666960015, "C100@4177L7,95@3825L392,104@4343L10,83@3361L21,81@3272L1198,109@4488L41,113@4609L1969,152@6857L7,151@6784L185,112@4571L3119:FeedbackScreen.kt#flo5hv");
            String FeedbackScreen$lambda$1 = FeedbackScreen$lambda$1($feedbackText$delegate);
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(200));
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            long Color = ColorKt.Color(4294047225L);
            long Color2 = ColorKt.Color(4294047225L);
            long j2 = Color.Companion.getTransparent-0d7_KjU();
            long j3 = Color.Companion.getTransparent-0d7_KjU();
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextFieldColors textFieldColors = textFieldDefaults.colors-0hiis_0(0L, 0L, 0L, 0L, Color2, Color, 0L, 0L, ((UserRole) consume).m353getColor0d7_KjU(), 0L, (TextSelectionColors) null, j3, j2, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer, 221184, 432, 0, 0, 3072, 2147477199, 4095);
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6));
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), ColorKt.Color(4281811281L), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 469413351, "CC(remember):FeedbackScreen.kt#9igjgp");
            Object value$iv2 = $composer.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit FeedbackScreen$lambda$9$0$0$0$0;
                        FeedbackScreen$lambda$9$0$0$0$0 = FeedbackScreenKt.FeedbackScreen$lambda$9$0$0$0$0($feedbackText$delegate, (String) obj);
                        return FeedbackScreen$lambda$9$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextFieldKt.TextField(FeedbackScreen$lambda$1, (Function1) value$iv2, modifier, false, false, textStyle, (Function2) null, ComposableSingletons$FeedbackScreenKt.INSTANCE.getLambda$1362446093$ad_inspector_debug(), (Function2) null, (Function2) null, (Function2) null, (Function2) null, (Function2) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, shape, textFieldColors, $composer, 12583344, 0, 0, 2096984);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
            ComposerKt.sourceInformationMarkerStart($composer, 469455235, "CC(remember):FeedbackScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed($adId);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit FeedbackScreen$lambda$9$0$0$1$0;
                        FeedbackScreen$lambda$9$0$0$1$0 = FeedbackScreenKt.FeedbackScreen$lambda$9$0$0$1$0($adId, $feedbackText$delegate, $isSubmitting$delegate, $showSuccessMessage$delegate);
                        return FeedbackScreen$lambda$9$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            Function0 function0 = (Function0) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier align = $this$FeedbackScreen_u24lambda_u249_u240_u240.align(Modifier.Companion, Alignment.Companion.getEnd());
            boolean z = (StringsKt.isBlank(FeedbackScreen$lambda$1($feedbackText$delegate)) || FeedbackScreen$lambda$4($isSubmitting$delegate)) ? false : true;
            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
            CompositionLocal this_$iv2 = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.Button(function0, align, z, (Shape) null, buttonDefaults.buttonColors-ro_MJ88(((UserRole) consume2).m353getColor0d7_KjU(), 0L, ColorKt.Color(4293060848L), 0L, $composer, (ButtonDefaults.$stable << 12) | 384, 10), (ButtonElevation) null, (BorderStroke) null, PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(24), Dp.constructor-impl(12)), (MutableInteractionSource) null, ComposableSingletons$FeedbackScreenKt.INSTANCE.getLambda$973775362$ad_inspector_debug(), $composer, 817889280, 360);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackScreen$lambda$9$0$0$0$0(MutableState $feedbackText$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $feedbackText$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackScreen$lambda$9$0$0$1$0(String $adId, MutableState $feedbackText$delegate, MutableState $isSubmitting$delegate, MutableState $showSuccessMessage$delegate) {
        FeedbackInfo feedbackInfo;
        if (!StringsKt.isBlank(FeedbackScreen$lambda$1($feedbackText$delegate))) {
            FeedbackScreen$lambda$5($isSubmitting$delegate, true);
            InspectorInfo it = StateManager.INSTANCE.getInspector($adId == null ? RoomRecommendViewModel.EMPTY_CURSOR : $adId);
            if (it != null) {
                Map map = new LinkedHashMap();
                StageType stageType = StageType.PREPARATION;
                Iterable $this$map$iv = it.getPipeline().getPreparationJobs();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    destination$iv$iv.add(encodeToString(((IJob) item$iv$iv).getData()));
                }
                map.put(stageType, (List) destination$iv$iv);
                StageType stageType2 = StageType.DRAWING;
                Iterable $this$map$iv2 = it.getPipeline().getDrawingJobs();
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv2 : $this$map$iv2) {
                    destination$iv$iv2.add(encodeToString(((IJob) item$iv$iv2).getData()));
                }
                map.put(stageType2, (List) destination$iv$iv2);
                StageType stageType3 = StageType.IMPRESSION;
                Iterable $this$map$iv3 = it.getPipeline().getImpressionJobs();
                Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                for (Object item$iv$iv3 : $this$map$iv3) {
                    destination$iv$iv3.add(encodeToString(((IJob) item$iv$iv3).getData()));
                }
                map.put(stageType3, (List) destination$iv$iv3);
                StageType stageType4 = StageType.INTERACTING;
                Iterable $this$map$iv4 = it.getPipeline().getInteractingJobs();
                Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
                for (Object item$iv$iv4 : $this$map$iv4) {
                    destination$iv$iv4.add(encodeToString(((IJob) item$iv$iv4).getData()));
                }
                map.put(stageType4, (List) destination$iv$iv4);
                AdSlot adSlot = it.getAdSlot();
                Json.Default r8 = Json.Default;
                String raw = it.getAdData().getRaw();
                if (raw == null) {
                    raw = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                feedbackInfo = new FeedbackInfo(adSlot, r8.parseToJsonElement(raw), map);
            } else {
                feedbackInfo = null;
            }
            FeedbackInfo feedbackInfo2 = feedbackInfo;
            KNeuron kNeuron = KNeuron.INSTANCE;
            StringFormat $this$encodeToString$iv = Json.Default;
            $this$encodeToString$iv.getSerializersModule();
            kNeuron.trackT(true, "ad.ops.inspector.feedback", MapsKt.mapOf(new Pair[]{TuplesKt.to("complain", FeedbackScreen$lambda$1($feedbackText$delegate)), TuplesKt.to("data", $this$encodeToString$iv.encodeToString(BuiltinSerializersKt.getNullable(FeedbackInfo.Companion.serializer()), feedbackInfo2))}), new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    boolean FeedbackScreen$lambda$9$0$0$1$0$1;
                    FeedbackScreen$lambda$9$0$0$1$0$1 = FeedbackScreenKt.FeedbackScreen$lambda$9$0$0$1$0$1();
                    return Boolean.valueOf(FeedbackScreen$lambda$9$0$0$1$0$1);
                }
            });
            FeedbackScreen$lambda$8($showSuccessMessage$delegate, true);
            $feedbackText$delegate.setValue(RoomRecommendViewModel.EMPTY_CURSOR);
            FeedbackScreen$lambda$5($isSubmitting$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FeedbackScreen$lambda$9$0$0$1$0$1() {
        return true;
    }

    private static final JsonElement encodeToString(IJobData $this$encodeToString) {
        if (!($this$encodeToString instanceof NormalJobData)) {
            if (!($this$encodeToString instanceof PrintJobData)) {
                if (!($this$encodeToString instanceof ReportJobData)) {
                    if (!($this$encodeToString instanceof RequestJobData)) {
                        if (!($this$encodeToString instanceof EmptyJobData)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Json $this$encodeToJsonElement$iv = Json.Default;
                        $this$encodeToJsonElement$iv.getSerializersModule();
                        return $this$encodeToJsonElement$iv.encodeToJsonElement(EmptyJobData.Companion.serializer(), $this$encodeToString);
                    }
                    Json $this$encodeToJsonElement$iv2 = Json.Default;
                    $this$encodeToJsonElement$iv2.getSerializersModule();
                    return $this$encodeToJsonElement$iv2.encodeToJsonElement(RequestJobData.Companion.serializer(), $this$encodeToString);
                }
                Json $this$encodeToJsonElement$iv3 = Json.Default;
                $this$encodeToJsonElement$iv3.getSerializersModule();
                return $this$encodeToJsonElement$iv3.encodeToJsonElement(ReportJobData.Companion.serializer(), $this$encodeToString);
            }
            Json $this$encodeToJsonElement$iv4 = Json.Default;
            $this$encodeToJsonElement$iv4.getSerializersModule();
            return $this$encodeToJsonElement$iv4.encodeToJsonElement(PrintJobData.Companion.serializer(), $this$encodeToString);
        }
        Json $this$encodeToJsonElement$iv5 = Json.Default;
        $this$encodeToJsonElement$iv5.getSerializersModule();
        return $this$encodeToJsonElement$iv5.encodeToJsonElement(NormalJobData.Companion.serializer(), $this$encodeToString);
    }
}