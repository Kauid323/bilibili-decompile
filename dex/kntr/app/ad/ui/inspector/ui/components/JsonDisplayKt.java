package kntr.app.ad.ui.inspector.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.LocalUserRoleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: JsonDisplay.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001ag\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001ag\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0018\u001a(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0002\u001a \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\rH\u0002\u001a\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¨\u0006\u001d²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u008e\u0002²\u0006\u0010\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u008a\u008e\u0002²\u0006\u0010\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u008a\u008e\u0002"}, d2 = {"ModernJsonElementDisplay", RoomRecommendViewModel.EMPTY_CURSOR, "jsonElement", "Lkotlinx/serialization/json/JsonElement;", "modifier", "Landroidx/compose/ui/Modifier;", "indent", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonElement;Landroidx/compose/ui/Modifier;ILandroidx/compose/runtime/Composer;II)V", "ModernJsonObjectDisplay", "jsonObject", "Lkotlinx/serialization/json/JsonObject;", "searchQuery", RoomRecommendViewModel.EMPTY_CURSOR, "expandedPaths", RoomRecommendViewModel.EMPTY_CURSOR, "filteredPaths", "currentPath", "showBraces", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/serialization/json/JsonObject;Landroidx/compose/ui/Modifier;ILjava/lang/String;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "ModernJsonArrayDisplay", "jsonArray", "Lkotlinx/serialization/json/JsonArray;", "(Lkotlinx/serialization/json/JsonArray;Landroidx/compose/ui/Modifier;ILjava/lang/String;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;II)V", "findMatchingPaths", "getAllPaths", "getAllParentPaths", "paths", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JsonDisplayKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonArrayDisplay$lambda$2(JsonArray jsonArray, Modifier modifier, int i, String str, Set set, Set set2, String str2, boolean z, int i2, int i3, Composer composer, int i4) {
        ModernJsonArrayDisplay(jsonArray, modifier, i, str, set, set2, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonElementDisplay$lambda$10(JsonElement jsonElement, Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        ModernJsonElementDisplay(jsonElement, modifier, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonObjectDisplay$lambda$2(JsonObject jsonObject, Modifier modifier, int i, String str, Set set, Set set2, String str2, boolean z, int i2, int i3, Composer composer, int i4) {
        ModernJsonObjectDisplay(jsonObject, modifier, i, str, set, set2, str2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final void ModernJsonElementDisplay(final JsonElement jsonElement, Modifier modifier, int indent, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int i2;
        Composer $composer2;
        Modifier modifier3;
        int indent2;
        Modifier modifier4;
        int indent3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Composer $composer$iv;
        Composer $composer4;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        long textColor;
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        Composer $composer5 = $composer.startRestartGroup(1721557649);
        ComposerKt.sourceInformation($composer5, "C(ModernJsonElementDisplay)N(jsonElement,modifier,indent)52@2185L31,54@2258L53,55@2337L44,57@2387L6267:JsonDisplay.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changedInstance(jsonElement) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            i2 = indent;
        } else if (($changed & 384) == 0) {
            i2 = indent;
            $dirty |= $composer5.changed(i2) ? 256 : 128;
        } else {
            i2 = indent;
        }
        int $dirty2 = $dirty;
        if (!$composer5.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            indent2 = i2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i4 == 0) {
                indent3 = i2;
            } else {
                indent3 = 0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1721557649, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.components.ModernJsonElementDisplay (JsonDisplay.kt:51)");
            }
            ComposerKt.sourceInformationMarkerStart($composer5, 854496336, "CC(remember):JsonDisplay.kt#9igjgp");
            Object it$iv = $composer5.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState searchQuery$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 854498694, "CC(remember):JsonDisplay.kt#9igjgp");
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(getAllPaths$default(jsonElement, null, 2, null), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState expandedPaths$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 854501213, "CC(remember):JsonDisplay.kt#9igjgp");
            Object it$iv3 = $composer5.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(SetsKt.emptySet(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer5.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState filteredPaths$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            modifier3 = modifier4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            $composer2 = $composer5;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            indent2 = indent3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -1087968452, "C66@2674L2525,59@2440L2759,132@5266L21,133@5296L3352:JsonDisplay.kt#pigpjk");
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), ColorKt.Color(4294047225L), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1209526690, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernJsonElementDisplay$lambda$9$0;
                    ModernJsonElementDisplay$lambda$9$0 = JsonDisplayKt.ModernJsonElementDisplay$lambda$9$0(jsonElement, searchQuery$delegate, expandedPaths$delegate, filteredPaths$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernJsonElementDisplay$lambda$9$0;
                }
            }, $composer5, 54), $composer5, 12583302, 120);
            ScrollState horizontalScrollState = ScrollKt.rememberScrollState(0, $composer5, 0, 1);
            Modifier modifier$iv2 = ScrollKt.horizontalScroll$default(Modifier.Companion, horizontalScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer5.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -86885014, "C:JsonDisplay.kt#pigpjk");
            if (jsonElement instanceof JsonObject) {
                $composer5.startReplaceGroup(-86902034);
                ComposerKt.sourceInformation($composer5, "136@5452L343");
                $composer3 = $composer5;
                $composer$iv = $composer5;
                ModernJsonObjectDisplay((JsonObject) jsonElement, Modifier.Companion, indent2, ModernJsonElementDisplay$lambda$1(searchQuery$delegate), ModernJsonElementDisplay$lambda$4(expandedPaths$delegate), ModernJsonElementDisplay$lambda$7(filteredPaths$delegate), null, false, $composer5, ($dirty2 & 896) | ($dirty2 & 14) | 48, 192);
                $composer5.endReplaceGroup();
                $composer4 = $composer5;
            } else {
                $composer3 = $composer5;
                $composer$iv = $composer5;
                if (jsonElement instanceof JsonArray) {
                    $composer4 = $composer5;
                    $composer4.startReplaceGroup(-86506939);
                    ComposerKt.sourceInformation($composer4, "146@5849L384");
                    ModernJsonArrayDisplay((JsonArray) jsonElement, Modifier.Companion, indent2, ModernJsonElementDisplay$lambda$1(searchQuery$delegate), ModernJsonElementDisplay$lambda$4(expandedPaths$delegate), ModernJsonElementDisplay$lambda$7(filteredPaths$delegate), null, true, $composer4, ($dirty2 & 14) | 12582960 | ($dirty2 & 896), 64);
                    $composer4.endReplaceGroup();
                } else {
                    $composer4 = $composer5;
                    if (jsonElement instanceof JsonPrimitive) {
                        $composer4.startReplaceGroup(-86048666);
                        ComposerKt.sourceInformation($composer4, RoomRecommendViewModel.EMPTY_CURSOR);
                        if (!(ModernJsonElementDisplay$lambda$1(searchQuery$delegate).length() == 0)) {
                            String lowerCase = ((JsonPrimitive) jsonElement).getContent().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            String lowerCase2 = ModernJsonElementDisplay$lambda$1(searchQuery$delegate).toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                            if (!StringsKt.contains$default(lowerCase, lowerCase2, false, 2, (Object) null)) {
                                $composer4.startReplaceGroup(-92322043);
                                $composer4.endReplaceGroup();
                                $composer4.endReplaceGroup();
                            }
                        }
                        $composer4.startReplaceGroup(-85836843);
                        ComposerKt.sourceInformation($composer4, "162@6518L1376");
                        int $this$dp$iv = indent2 * 12;
                        Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl($this$dp$iv), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer4.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope = RowScopeInstance.INSTANCE;
                        int i10 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2054467130, "C182@7589L10,175@7208L660:JsonDisplay.kt#pigpjk");
                        if (((JsonPrimitive) jsonElement).isString()) {
                            textColor = ColorKt.Color(4278556265L);
                        } else if (JsonElementKt.getBooleanOrNull((JsonPrimitive) jsonElement) != null) {
                            textColor = ColorKt.Color(4293870660L);
                        } else if (JsonElementKt.getLongOrNull((JsonPrimitive) jsonElement) != null || JsonElementKt.getDoubleOrNull((JsonPrimitive) jsonElement) != null) {
                            textColor = ColorKt.Color(4284704497L);
                        } else {
                            textColor = ColorKt.Color(4281811281L);
                        }
                        TextKt.Text-Nvy7gAk(((JsonPrimitive) jsonElement).isString() ? "\"" + ((JsonPrimitive) jsonElement).getContent() + "\"" : ((JsonPrimitive) jsonElement).toString(), (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer4, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endReplaceGroup();
                        $composer4.endReplaceGroup();
                    } else if (!Intrinsics.areEqual(jsonElement, JsonNull.INSTANCE)) {
                        $composer4.startReplaceGroup(-556992071);
                        $composer4.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    } else {
                        $composer4.startReplaceGroup(-84400303);
                        ComposerKt.sourceInformation($composer4, RoomRecommendViewModel.EMPTY_CURSOR);
                        if (ModernJsonElementDisplay$lambda$1(searchQuery$delegate).length() == 0) {
                            $composer4.startReplaceGroup(-84353772);
                            ComposerKt.sourceInformation($composer4, "194@8039L545");
                            int $this$dp$iv2 = indent2 * 12;
                            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl($this$dp$iv2), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv4 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                $composer4.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i12 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1496457306, "C198@8271L10,195@8128L430:JsonDisplay.kt#pigpjk");
                            TextKt.Text-Nvy7gAk("null", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer4, 390, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                        } else {
                            $composer4.startReplaceGroup(-92322043);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.endReplaceGroup();
                    }
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final int i13 = indent2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernJsonElementDisplay$lambda$10;
                    ModernJsonElementDisplay$lambda$10 = JsonDisplayKt.ModernJsonElementDisplay$lambda$10(jsonElement, modifier5, i13, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernJsonElementDisplay$lambda$10;
                }
            });
        }
    }

    private static final String ModernJsonElementDisplay$lambda$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final Set<String> ModernJsonElementDisplay$lambda$4(MutableState<Set<String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Set) $this$getValue$iv.getValue();
    }

    private static final Set<String> ModernJsonElementDisplay$lambda$7(MutableState<Set<String>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Set) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0253, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ModernJsonElementDisplay$lambda$9$0(final JsonElement $jsonElement, final MutableState $searchQuery$delegate, final MutableState $expandedPaths$delegate, final MutableState $filteredPaths$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C67@2688L2501:JsonDisplay.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1209526690, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.ModernJsonElementDisplay.<anonymous>.<anonymous> (JsonDisplay.kt:67)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv = (390 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((390 >> 6) & 112) | 6;
            RowScope $this$ModernJsonElementDisplay_u24lambda_u249_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1680753639, "C71@2841L220,78@3079L39,96@3963L7,98@4049L10,82@3229L673,80@3136L1273:JsonDisplay.kt#pigpjk");
            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getSearch(), "搜索", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), ColorKt.Color(4284773515L), $composer, 3510, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            String ModernJsonElementDisplay$lambda$1 = ModernJsonElementDisplay$lambda$1($searchQuery$delegate);
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Brush solidColor = new SolidColor(((UserRole) consume).m353getColor0d7_KjU(), (DefaultConstructorMarker) null);
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), ColorKt.Color(4281549141L), TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (Object) null);
            Modifier modifier = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ModernJsonElementDisplay_u24lambda_u249_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer, 885512607, "CC(remember):JsonDisplay.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($jsonElement);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit ModernJsonElementDisplay$lambda$9$0$0$0$0;
                    ModernJsonElementDisplay$lambda$9$0$0$0$0 = JsonDisplayKt.ModernJsonElementDisplay$lambda$9$0$0$0$0($jsonElement, $searchQuery$delegate, $expandedPaths$delegate, $filteredPaths$delegate, (String) obj);
                    return ModernJsonElementDisplay$lambda$9$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            BasicTextFieldKt.BasicTextField(ModernJsonElementDisplay$lambda$1, (Function1) it$iv, modifier, false, false, textStyle, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, solidColor, (Function3) null, $composer, 100663296, 0, 48856);
            if (ModernJsonElementDisplay$lambda$1($searchQuery$delegate).length() > 0) {
                $composer.startReplaceGroup(1682306614);
                ComposerKt.sourceInformation($composer, "110@4479L39,113@4586L244,112@4540L617");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
                ComposerKt.sourceInformationMarkerStart($composer, 885555602, "CC(remember):JsonDisplay.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance($jsonElement);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit ModernJsonElementDisplay$lambda$9$0$0$1$0;
                            ModernJsonElementDisplay$lambda$9$0$0$1$0 = JsonDisplayKt.ModernJsonElementDisplay$lambda$9$0$0$1$0($jsonElement, $searchQuery$delegate, $expandedPaths$delegate, $filteredPaths$delegate);
                            return ModernJsonElementDisplay$lambda$9$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconButtonKt.IconButton((Function0) it$iv2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$JsonDisplayKt.INSTANCE.getLambda$1851363493$ad_inspector_debug(), $composer, 1572912, 60);
            } else {
                $composer.startReplaceGroup(1677862020);
            }
            $composer.endReplaceGroup();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonElementDisplay$lambda$9$0$0$0$0(JsonElement $jsonElement, MutableState $searchQuery$delegate, MutableState $expandedPaths$delegate, MutableState $filteredPaths$delegate, String newQuery) {
        Intrinsics.checkNotNullParameter(newQuery, "newQuery");
        $searchQuery$delegate.setValue(newQuery);
        if (newQuery.length() > 0) {
            Set matchingPaths = findMatchingPaths$default($jsonElement, newQuery, null, 4, null);
            $expandedPaths$delegate.setValue(matchingPaths);
            $filteredPaths$delegate.setValue(getAllParentPaths(matchingPaths));
        } else {
            $expandedPaths$delegate.setValue(getAllPaths$default($jsonElement, null, 2, null));
            $filteredPaths$delegate.setValue(SetsKt.emptySet());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonElementDisplay$lambda$9$0$0$1$0(JsonElement $jsonElement, MutableState $searchQuery$delegate, MutableState $expandedPaths$delegate, MutableState $filteredPaths$delegate) {
        $searchQuery$delegate.setValue(RoomRecommendViewModel.EMPTY_CURSOR);
        $expandedPaths$delegate.setValue(getAllPaths$default($jsonElement, null, 2, null));
        $filteredPaths$delegate.setValue(SetsKt.emptySet());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:240:0x0620, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x05d0  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05da  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0618  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x06e4  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x06f6  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x076e  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0820  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0987  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0a2d  */
    /* JADX WARN: Removed duplicated region for block: B:360:0x11aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ModernJsonObjectDisplay(final JsonObject jsonObject, Modifier modifier, int indent, String searchQuery, Set<String> set, Set<String> set2, String currentPath, boolean showBraces, Composer $composer, final int $changed, final int i) {
        Set set3;
        Set set4;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        int indent2;
        String searchQuery2;
        String currentPath2;
        boolean showBraces2;
        Set expandedPaths;
        Set filteredPaths;
        Modifier modifier3;
        int indent3;
        String searchQuery3;
        Set expandedPaths2;
        Set filteredPaths2;
        String currentPath3;
        boolean showBraces3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer3;
        Function0 factory$iv$iv$iv2;
        Modifier materialized$iv$iv;
        String currentPath4;
        String currentPath5;
        Composer $composer$iv2;
        boolean showBraces4;
        Composer $composer$iv$iv$iv2;
        String searchQuery4;
        Set filteredPaths3;
        boolean shouldHighlight;
        Object value$iv;
        Boolean bool;
        boolean invalid$iv;
        Composer $composer$iv3;
        SnapshotStateMap expandedStates;
        String str;
        Composer $composer4;
        String str2;
        Set expandedPaths3;
        Function0 factory$iv$iv$iv3;
        JsonObject value;
        long textColor;
        String str3;
        String str4;
        Composer $composer5;
        String str5;
        int $dirty2;
        int $dirty3;
        Function0 factory$iv$iv$iv4;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Composer $composer6 = $composer.startRestartGroup(197710727);
        ComposerKt.sourceInformation($composer6, "C(ModernJsonObjectDisplay)N(jsonObject,modifier,indent,searchQuery,expandedPaths,filteredPaths,currentPath,showBraces)225@9070L49,227@9125L11417:JsonDisplay.kt#pigpjk");
        int $dirty4 = $changed;
        if (($changed & 6) == 0) {
            $dirty4 |= $composer6.changedInstance(jsonObject) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer6.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer6.changed(indent) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty4 |= $composer6.changed(searchQuery) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty4 |= 24576;
            set3 = set;
        } else if (($changed & 24576) == 0) {
            set3 = set;
            $dirty4 |= $composer6.changedInstance(set3) ? 16384 : 8192;
        } else {
            set3 = set;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty4 |= 196608;
            set4 = set2;
        } else if ((196608 & $changed) == 0) {
            set4 = set2;
            $dirty4 |= $composer6.changedInstance(set4) ? 131072 : 65536;
        } else {
            set4 = set2;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty4 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty4 |= $composer6.changed(currentPath) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty4 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty4 |= $composer6.changed(showBraces) ? 8388608 : 4194304;
        }
        if (!$composer6.shouldExecute(($dirty4 & 4793491) != 4793490, $dirty4 & 1)) {
            $dirty = $dirty4;
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            indent2 = indent;
            searchQuery2 = searchQuery;
            currentPath2 = currentPath;
            showBraces2 = showBraces;
            expandedPaths = set3;
            filteredPaths = set4;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                indent3 = indent;
            } else {
                indent3 = 0;
            }
            if (i4 == 0) {
                searchQuery3 = searchQuery;
            } else {
                searchQuery3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i5 == 0) {
                expandedPaths2 = set3;
            } else {
                expandedPaths2 = SetsKt.emptySet();
            }
            if (i6 == 0) {
                filteredPaths2 = set4;
            } else {
                filteredPaths2 = SetsKt.emptySet();
            }
            if (i7 == 0) {
                currentPath3 = currentPath;
            } else {
                currentPath3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i8 == 0) {
                showBraces3 = showBraces;
            } else {
                showBraces3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(197710727, $dirty4, -1, "kntr.app.ad.ui.inspector.ui.components.ModernJsonObjectDisplay (JsonDisplay.kt:222)");
            }
            int $this$dp$iv = indent3 * 12;
            float f = Dp.constructor-impl($this$dp$iv);
            ComposerKt.sourceInformationMarkerStart($composer6, 1021460472, "CC(remember):JsonDisplay.kt#9igjgp");
            Object it$iv = $composer6.rememberedValue();
            indent2 = indent3;
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateMapOf();
                $composer6.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            final Map expandedStates2 = (SnapshotStateMap) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier modifier4 = modifier3;
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(modifier4, f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            String str8 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            Composer $composer$iv$iv$iv3 = $composer6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv3, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            $composer2 = $composer6;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv3.startReusableNode();
            if ($composer$iv$iv$iv3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer$iv$iv$iv3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer$iv$iv$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv3);
            int $dirty5 = $dirty4;
            String str9 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv4 = $composer$iv$iv$iv3;
            boolean z3 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            Composer $composer7 = $composer$iv4;
            ComposerKt.sourceInformationMarkerStart($composer7, 446881245, "C:JsonDisplay.kt#pigpjk");
            if (!(searchQuery3.length() == 0)) {
                if (!(currentPath3.length() == 0) && !filteredPaths2.isEmpty()) {
                    Iterable $this$any$iv = filteredPaths2;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator it = $this$any$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z2 = false;
                                break;
                            }
                            Object element$iv = it.next();
                            Iterable $this$any$iv2 = $this$any$iv;
                            String it2 = (String) element$iv;
                            Iterator it3 = it;
                            int $changed$iv$iv$iv2 = $changed$iv$iv$iv;
                            boolean z4 = z3;
                            if (StringsKt.startsWith$default(currentPath3, it2, false, 2, (Object) null) || StringsKt.startsWith$default(it2, currentPath3, false, 2, (Object) null)) {
                                z2 = true;
                                break;
                            }
                            $this$any$iv = $this$any$iv2;
                            it = it3;
                            $changed$iv$iv$iv = $changed$iv$iv$iv2;
                            z3 = z4;
                        }
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        $composer7.startReplaceGroup(437372645);
                        $composer7.endReplaceGroup();
                        $composer$iv = $composer$iv4;
                        showBraces2 = showBraces3;
                        searchQuery2 = searchQuery3;
                        expandedPaths = expandedPaths2;
                        filteredPaths = filteredPaths2;
                        currentPath2 = currentPath3;
                        $composer$iv$iv$iv = $composer$iv$iv$iv3;
                        $composer3 = $composer7;
                        $dirty = $dirty5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                    }
                }
            }
            $composer7.startReplaceGroup(447079210);
            String str10 = RoomRecommendViewModel.EMPTY_CURSOR;
            ComposerKt.sourceInformation($composer7, RoomRecommendViewModel.EMPTY_CURSOR);
            if (showBraces3) {
                $composer7.startReplaceGroup(446793018);
                ComposerKt.sourceInformation($composer7, "238@9589L10,235@9485L331");
                TextKt.Text-Nvy7gAk("{", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer7, 390, 0, 131066);
            } else {
                $composer7.startReplaceGroup(437372645);
            }
            $composer7.endReplaceGroup();
            $composer7.startReplaceGroup(-2063775505);
            ComposerKt.sourceInformation($composer7, RoomRecommendViewModel.EMPTY_CURSOR);
            Iterable $this$forEach$iv = jsonObject.entrySet();
            int $i$f$forEach = 0;
            Iterator it4 = $this$forEach$iv.iterator();
            while (true) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                int $i$f$forEach2 = $i$f$forEach;
                if (it4.hasNext()) {
                    Object element$iv2 = it4.next();
                    Map.Entry entry = (Map.Entry) element$iv2;
                    final String key = (String) entry.getKey();
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    JsonObject jsonObject2 = (JsonElement) entry.getValue();
                    if (currentPath3.length() == 0) {
                        currentPath4 = currentPath3;
                        currentPath5 = key;
                        materialized$iv$iv = materialized$iv$iv2;
                    } else {
                        materialized$iv$iv = materialized$iv$iv2;
                        currentPath4 = currentPath3;
                        currentPath5 = currentPath3 + "." + key;
                    }
                    if (searchQuery3.length() == 0) {
                        $composer$iv2 = $composer$iv4;
                        showBraces4 = showBraces3;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                    } else if (filteredPaths2.isEmpty()) {
                        $composer$iv2 = $composer$iv4;
                        showBraces4 = showBraces3;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                    } else {
                        Iterable $this$any$iv3 = filteredPaths2;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        if (!($this$any$iv3 instanceof Collection) || !((Collection) $this$any$iv3).isEmpty()) {
                            Iterator it5 = $this$any$iv3.iterator();
                            while (true) {
                                if (it5.hasNext()) {
                                    Object element$iv3 = it5.next();
                                    Iterator it6 = it5;
                                    String it7 = (String) element$iv3;
                                    $composer$iv2 = $composer$iv4;
                                    showBraces4 = showBraces3;
                                    Iterable $this$any$iv4 = $this$any$iv3;
                                    if (StringsKt.startsWith$default(currentPath5, it7, false, 2, (Object) null) || StringsKt.startsWith$default(it7, currentPath5, false, 2, (Object) null)) {
                                        z = true;
                                        break;
                                    }
                                    it5 = it6;
                                    $this$any$iv3 = $this$any$iv4;
                                    $composer$iv4 = $composer$iv2;
                                    showBraces3 = showBraces4;
                                } else {
                                    $composer$iv2 = $composer$iv4;
                                    showBraces4 = showBraces3;
                                    z = false;
                                    break;
                                }
                            }
                        } else {
                            $composer$iv2 = $composer$iv4;
                            showBraces4 = showBraces3;
                            z = false;
                        }
                        if (!z) {
                            $composer7.startReplaceGroup(69224559);
                            $composer7.endReplaceGroup();
                            str3 = str10;
                            expandedStates = expandedStates2;
                            searchQuery4 = searchQuery3;
                            filteredPaths3 = filteredPaths2;
                            str4 = str8;
                            $dirty2 = $dirty5;
                            str5 = str9;
                            expandedPaths3 = expandedPaths2;
                            $composer5 = $composer7;
                            str8 = str4;
                            $composer7 = $composer5;
                            str10 = str3;
                            expandedPaths2 = expandedPaths3;
                            $this$forEach$iv = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach2;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            materialized$iv$iv2 = materialized$iv$iv;
                            currentPath3 = currentPath4;
                            $composer$iv4 = $composer$iv2;
                            showBraces3 = showBraces4;
                            filteredPaths2 = filteredPaths3;
                            searchQuery3 = searchQuery4;
                            expandedStates2 = expandedStates;
                            $dirty5 = $dirty2;
                            str9 = str5;
                            $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                        }
                    }
                    $composer7.startReplaceGroup(79778664);
                    ComposerKt.sourceInformation($composer7, "278@11406L203,271@10967L6483");
                    final boolean isExpandable = (jsonObject2 instanceof JsonObject) || (jsonObject2 instanceof JsonArray);
                    if (!(searchQuery3.length() > 0)) {
                        searchQuery4 = searchQuery3;
                        filteredPaths3 = filteredPaths2;
                    } else {
                        String lowerCase = key.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        String lowerCase2 = searchQuery3.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                        searchQuery4 = searchQuery3;
                        filteredPaths3 = filteredPaths2;
                        if (StringsKt.contains$default(lowerCase, lowerCase2, false, 2, (Object) null) || expandedPaths2.contains(currentPath5)) {
                            shouldHighlight = true;
                            Map $this$getOrPut$iv = expandedStates2;
                            value$iv = $this$getOrPut$iv.get(key);
                            if (value$iv != null) {
                                bool = true;
                                $this$getOrPut$iv.put(key, 1);
                            } else {
                                bool = value$iv;
                            }
                            final boolean isExpanded = ((Boolean) bool).booleanValue();
                            String path = currentPath5;
                            Modifier modifier5 = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), !shouldHighlight ? ColorKt.Color(4294898631L) : Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                            ComposerKt.sourceInformationMarkerStart($composer7, 833882270, "CC(remember):JsonDisplay.kt#9igjgp");
                            invalid$iv = $composer7.changed(isExpandable) | $composer7.changed(key) | $composer7.changed(isExpanded);
                            Composer $this$cache$iv = $composer7;
                            Object it$iv2 = $this$cache$iv.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv3 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda0
                                public final Object invoke() {
                                    Unit ModernJsonObjectDisplay$lambda$1$1$2$0;
                                    ModernJsonObjectDisplay$lambda$1$1$2$0 = JsonDisplayKt.ModernJsonObjectDisplay$lambda$1$1$2$0(isExpandable, expandedStates2, key, isExpanded);
                                    return ModernJsonObjectDisplay$lambda$1$1$2$0;
                                }
                            };
                            $this$cache$iv.updateRememberedValue(value$iv3);
                            it$iv2 = value$iv3;
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                            $composer$iv3 = $composer7;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            expandedStates = expandedStates2;
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv2 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str8);
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                            str = str8;
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv2);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                            $composer4 = $composer7;
                            str2 = str9;
                            expandedPaths3 = expandedPaths2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str2);
                            if (!($composer$iv3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv3.startReusableNode();
                            if (!$composer$iv3.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                $composer$iv3.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                                $composer$iv3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i12 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -470587799, "C299@12460L10,296@12324L515,307@12865L39:JsonDisplay.kt#pigpjk");
                            if (!isExpandable) {
                                $composer$iv3.startReplaceGroup(-470704670);
                                ComposerKt.sourceInformation($composer$iv3, "286@11804L366");
                                AppIcons appIcons = AppIcons.INSTANCE;
                                IconKt.Icon-ww6aTOc(isExpanded ? appIcons.getKeyboardArrowDown() : appIcons.getKeyboardArrowRight(), isExpanded ? "折叠" : "展开", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ColorKt.Color(4285231744L), $composer$iv3, 3456, 0);
                                $composer$iv3.endReplaceGroup();
                            } else {
                                $composer$iv3.startReplaceGroup(-470318224);
                                ComposerKt.sourceInformation($composer$iv3, "293@12232L40");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv3, 6);
                                $composer$iv3.endReplaceGroup();
                            }
                            String str11 = "\"" + key + "\":";
                            TextStyle bodySmall = MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall();
                            FontFamily monospace = FontFamily.Companion.getMonospace();
                            long sp = TextUnitKt.getSp(12);
                            FontWeight.Companion companion = FontWeight.Companion;
                            TextKt.Text-Nvy7gAk(str11, (Modifier) null, ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(bodySmall, 0L, sp, !shouldHighlight ? companion.getMedium() : companion.getNormal(), (FontStyle) null, (FontSynthesis) null, monospace, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (Object) null), $composer$iv3, 384, 0, 131066);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer$iv3, 6);
                            if (isExpandable || !isExpanded) {
                                value = jsonObject2;
                                $composer$iv3.startReplaceGroup(-482426576);
                            } else {
                                $composer$iv3.startReplaceGroup(-469473660);
                                ComposerKt.sourceInformation($composer$iv3, "319@13432L10,311@13035L684");
                                value = jsonObject2;
                                if (value instanceof JsonObject) {
                                    str7 = "{";
                                } else {
                                    str7 = value instanceof JsonArray ? "[" : str10;
                                }
                                TextKt.Text-Nvy7gAk(str7, (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv3, 384, 0, 131066);
                            }
                            $composer$iv3.endReplaceGroup();
                            if (!isExpandable && isExpanded) {
                                $composer$iv3.startReplaceGroup(-482426576);
                            } else {
                                $composer$iv3.startReplaceGroup(-468590687);
                                ComposerKt.sourceInformation($composer$iv3, str10);
                                if (!(value instanceof JsonObject)) {
                                    $composer$iv3.startReplaceGroup(-468582317);
                                    ComposerKt.sourceInformation($composer$iv3, "333@14105L10,330@13937L573");
                                    TextKt.Text-Nvy7gAk("{...}", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777173, (Object) null), $composer$iv3, 390, 0, 131066);
                                    $composer$iv3.endReplaceGroup();
                                } else if (value instanceof JsonArray) {
                                    $composer$iv3.startReplaceGroup(-467892877);
                                    ComposerKt.sourceInformation($composer$iv3, "346@14800L10,343@14632L573");
                                    TextKt.Text-Nvy7gAk("[...]", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777173, (Object) null), $composer$iv3, 390, 0, 131066);
                                    $composer$iv3.endReplaceGroup();
                                } else if (value instanceof JsonPrimitive) {
                                    $composer$iv3.startReplaceGroup(-467209451);
                                    ComposerKt.sourceInformation($composer$iv3, "375@16407L10,368@15988L738");
                                    if (value.isString()) {
                                        textColor = ColorKt.Color(4278556265L);
                                    } else if (JsonElementKt.getBooleanOrNull(value) != null) {
                                        textColor = ColorKt.Color(4293870660L);
                                    } else if (JsonElementKt.getLongOrNull(value) != null || JsonElementKt.getDoubleOrNull(value) != null) {
                                        textColor = ColorKt.Color(4284704497L);
                                    } else {
                                        textColor = ColorKt.Color(4281811281L);
                                    }
                                    TextKt.Text-Nvy7gAk(value.isString() ? "\"" + value.getContent() + "\"" : value.toString(), (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv3, 0, 0, 131066);
                                    $composer$iv3.endReplaceGroup();
                                } else if (!Intrinsics.areEqual(value, JsonNull.INSTANCE)) {
                                    $composer$iv3.startReplaceGroup(1785999489);
                                    $composer$iv3.endReplaceGroup();
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    $composer$iv3.startReplaceGroup(-465701022);
                                    ComposerKt.sourceInformation($composer$iv3, "387@17011L10,384@16844L494");
                                    TextKt.Text-Nvy7gAk("null", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv3, 390, 0, 131066);
                                    $composer$iv3.endReplaceGroup();
                                }
                            }
                            $composer$iv3.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            $composer$iv3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            if (isExpandable || !isExpanded) {
                                str3 = str10;
                                str4 = str;
                                $composer5 = $composer4;
                                str5 = str2;
                                $dirty2 = $dirty5;
                                $composer5.startReplaceGroup(69224559);
                            } else {
                                $composer5 = $composer4;
                                $composer5.startReplaceGroup(86662710);
                                ComposerKt.sourceInformation($composer5, "429@18809L1034");
                                if (value instanceof JsonObject) {
                                    $composer5.startReplaceGroup(834082693);
                                    ComposerKt.sourceInformation($composer5, "402@17661L466");
                                    $dirty3 = $dirty5;
                                    ModernJsonObjectDisplay(value, Modifier.Companion, 2, searchQuery4, expandedPaths3, filteredPaths3, path, false, $composer5, ($dirty3 & 7168) | 12583344 | (57344 & $dirty3) | (458752 & $dirty3), 0);
                                    $composer5.endReplaceGroup();
                                } else {
                                    $dirty3 = $dirty5;
                                    if (value instanceof JsonArray) {
                                        $composer5.startReplaceGroup(834100100);
                                        ComposerKt.sourceInformation($composer5, "414@18205L465");
                                        ModernJsonArrayDisplay(value, Modifier.Companion, 2, searchQuery4, expandedPaths3, filteredPaths3, path, false, $composer5, ($dirty3 & 7168) | 12583344 | (57344 & $dirty3) | (458752 & $dirty3), 0);
                                        $composer5.endReplaceGroup();
                                    } else {
                                        $composer5.startReplaceGroup(87783949);
                                        $composer5.endReplaceGroup();
                                    }
                                }
                                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(0), 0.0f, 2, (Object) null);
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                                ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                int $changed$iv$iv3 = (390 << 3) & 112;
                                str3 = str10;
                                str4 = str;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, str4);
                                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                                $dirty2 = $dirty3;
                                str5 = str2;
                                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str5);
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                    $composer5.createNode(factory$iv$iv$iv4);
                                } else {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv7;
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                int i13 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                                int i14 = ((390 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1655033482, "C433@19037L40,442@19530L10,434@19133L684:JsonDisplay.kt#pigpjk");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), $composer5, 6);
                                if (value instanceof JsonObject) {
                                    str6 = "}";
                                } else {
                                    str6 = value instanceof JsonArray ? "]" : str3;
                                }
                                TextKt.Text-Nvy7gAk(str6, (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer5, 384, 0, 131066);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                            }
                            $composer5.endReplaceGroup();
                            $composer5.endReplaceGroup();
                            str8 = str4;
                            $composer7 = $composer5;
                            str10 = str3;
                            expandedPaths2 = expandedPaths3;
                            $this$forEach$iv = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach2;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            materialized$iv$iv2 = materialized$iv$iv;
                            currentPath3 = currentPath4;
                            $composer$iv4 = $composer$iv2;
                            showBraces3 = showBraces4;
                            filteredPaths2 = filteredPaths3;
                            searchQuery3 = searchQuery4;
                            expandedStates2 = expandedStates;
                            $dirty5 = $dirty2;
                            str9 = str5;
                            $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                        }
                    }
                    shouldHighlight = false;
                    Map $this$getOrPut$iv2 = expandedStates2;
                    value$iv = $this$getOrPut$iv2.get(key);
                    if (value$iv != null) {
                    }
                    final boolean isExpanded2 = ((Boolean) bool).booleanValue();
                    String path2 = currentPath5;
                    Modifier modifier52 = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), !shouldHighlight ? ColorKt.Color(4294898631L) : Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                    ComposerKt.sourceInformationMarkerStart($composer7, 833882270, "CC(remember):JsonDisplay.kt#9igjgp");
                    invalid$iv = $composer7.changed(isExpandable) | $composer7.changed(key) | $composer7.changed(isExpanded2);
                    Composer $this$cache$iv2 = $composer7;
                    Object it$iv22 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv32 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit ModernJsonObjectDisplay$lambda$1$1$2$0;
                            ModernJsonObjectDisplay$lambda$1$1$2$0 = JsonDisplayKt.ModernJsonObjectDisplay$lambda$1$1$2$0(isExpandable, expandedStates2, key, isExpanded2);
                            return ModernJsonObjectDisplay$lambda$1$1$2$0;
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv32);
                    it$iv22 = value$iv32;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    Modifier modifier$iv22 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier52, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv22, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                    $composer$iv3 = $composer7;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    expandedStates = expandedStates2;
                    MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv22 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, str8);
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer$iv3.getCurrentCompositionLocalMap();
                    str = str8;
                    Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv22);
                    Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv32 = (($changed$iv$iv22 << 6) & 896) | 6;
                    $composer4 = $composer7;
                    str2 = str9;
                    expandedPaths3 = expandedPaths2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str2);
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                    }
                    $composer$iv3.startReusableNode();
                    if (!$composer$iv3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer$iv3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                    int i112 = ($changed$iv$iv$iv32 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                    int i122 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -470587799, "C299@12460L10,296@12324L515,307@12865L39:JsonDisplay.kt#pigpjk");
                    if (!isExpandable) {
                    }
                    String str112 = "\"" + key + "\":";
                    TextStyle bodySmall2 = MaterialTheme.INSTANCE.getTypography($composer$iv3, MaterialTheme.$stable).getBodySmall();
                    FontFamily monospace2 = FontFamily.Companion.getMonospace();
                    long sp2 = TextUnitKt.getSp(12);
                    FontWeight.Companion companion2 = FontWeight.Companion;
                    TextKt.Text-Nvy7gAk(str112, (Modifier) null, ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(bodySmall2, 0L, sp2, !shouldHighlight ? companion2.getMedium() : companion2.getNormal(), (FontStyle) null, (FontSynthesis) null, monospace2, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777177, (Object) null), $composer$iv3, 384, 0, 131066);
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer$iv3, 6);
                    if (isExpandable) {
                    }
                    value = jsonObject2;
                    $composer$iv3.startReplaceGroup(-482426576);
                    $composer$iv3.endReplaceGroup();
                    if (!isExpandable) {
                    }
                    $composer$iv3.startReplaceGroup(-468590687);
                    ComposerKt.sourceInformation($composer$iv3, str10);
                    if (!(value instanceof JsonObject)) {
                    }
                    $composer$iv3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    if (isExpandable) {
                    }
                    str3 = str10;
                    str4 = str;
                    $composer5 = $composer4;
                    str5 = str2;
                    $dirty2 = $dirty5;
                    $composer5.startReplaceGroup(69224559);
                    $composer5.endReplaceGroup();
                    $composer5.endReplaceGroup();
                    str8 = str4;
                    $composer7 = $composer5;
                    str10 = str3;
                    expandedPaths2 = expandedPaths3;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    materialized$iv$iv2 = materialized$iv$iv;
                    currentPath3 = currentPath4;
                    $composer$iv4 = $composer$iv2;
                    showBraces3 = showBraces4;
                    filteredPaths2 = filteredPaths3;
                    searchQuery3 = searchQuery4;
                    expandedStates2 = expandedStates;
                    $dirty5 = $dirty2;
                    str9 = str5;
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                } else {
                    $composer$iv = $composer$iv4;
                    showBraces2 = showBraces3;
                    searchQuery2 = searchQuery3;
                    filteredPaths = filteredPaths2;
                    String str12 = str8;
                    currentPath2 = currentPath3;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    $dirty = $dirty5;
                    String str13 = str9;
                    expandedPaths = expandedPaths2;
                    $composer3 = $composer7;
                    $composer3.endReplaceGroup();
                    if (showBraces2) {
                        $composer3.startReplaceGroup(457159790);
                        ComposerKt.sourceInformation($composer3, "454@19945L567");
                        Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                        Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv4 = (390 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str12);
                        int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                        Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                        int $i$f$Row = $changed$iv$iv4 << 6;
                        int $changed$iv$iv$iv5 = ($i$f$Row & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str13);
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv8;
                            $composer3.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv8;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                        int i15 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope4 = RowScopeInstance.INSTANCE;
                        int i16 = ((390 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1402235370, "C461@20247L10,458@20131L363:JsonDisplay.kt#pigpjk");
                        TextKt.Text-Nvy7gAk("}", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer3, 390, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                    } else {
                        $composer3.startReplaceGroup(437372645);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final int i17 = indent2;
            final String str14 = searchQuery2;
            final Set set5 = expandedPaths;
            final Set set6 = filteredPaths;
            final String str15 = currentPath2;
            final boolean z5 = showBraces2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernJsonObjectDisplay$lambda$2;
                    ModernJsonObjectDisplay$lambda$2 = JsonDisplayKt.ModernJsonObjectDisplay$lambda$2(jsonObject, modifier6, i17, str14, set5, set6, str15, z5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernJsonObjectDisplay$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonObjectDisplay$lambda$1$1$2$0(boolean $isExpandable, SnapshotStateMap $expandedStates, String $key, boolean $isExpanded) {
        if ($isExpandable) {
            ((Map) $expandedStates).put($key, Boolean.valueOf(!$isExpanded));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:240:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x06a3  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x06d6  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x07f1  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0877  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x08f8  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0a30  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0d3a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:360:0x133e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ModernJsonArrayDisplay(final JsonArray jsonArray, Modifier modifier, int indent, String searchQuery, Set<String> set, Set<String> set2, String currentPath, boolean showBraces, Composer $composer, final int $changed, final int i) {
        Set set3;
        Set set4;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        int indent2;
        String searchQuery2;
        String currentPath2;
        boolean showBraces2;
        Set expandedPaths;
        Set filteredPaths;
        Modifier modifier3;
        int indent3;
        String searchQuery3;
        Set expandedPaths2;
        Set filteredPaths2;
        String currentPath3;
        boolean showBraces3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Function0 factory$iv$iv$iv3;
        Iterable $this$forEachIndexed$iv;
        String str;
        boolean z;
        Iterator it;
        String currentPath4;
        Set expandedPaths3;
        boolean shouldHighlight;
        Object value$iv;
        Boolean bool;
        int index$iv;
        boolean invalid$iv;
        final SnapshotStateMap expandedIndices;
        Composer $composer$iv2;
        String str2;
        SnapshotStateMap expandedIndices2;
        boolean showBraces4;
        String str3;
        Set expandedPaths4;
        Composer $composer4;
        String str4;
        Function0 factory$iv$iv$iv4;
        long textColor;
        String str5;
        String path;
        String str6;
        String str7;
        String str8;
        Composer $composer5;
        String str9;
        Function0 factory$iv$iv$iv5;
        int $dirty2;
        Function0 factory$iv$iv$iv6;
        String str10;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        Composer $composer6 = $composer.startRestartGroup(-467703359);
        ComposerKt.sourceInformation($composer6, "C(ModernJsonArrayDisplay)N(jsonArray,modifier,indent,searchQuery,expandedPaths,filteredPaths,currentPath,showBraces)486@20956L46,488@21008L11394:JsonDisplay.kt#pigpjk");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer6.changedInstance(jsonArray) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty3 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty3 |= $composer6.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty3 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty3 |= $composer6.changed(indent) ? 256 : 128;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty3 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty3 |= $composer6.changed(searchQuery) ? 2048 : 1024;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty3 |= 24576;
            set3 = set;
        } else if (($changed & 24576) == 0) {
            set3 = set;
            $dirty3 |= $composer6.changedInstance(set3) ? 16384 : 8192;
        } else {
            set3 = set;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty3 |= 196608;
            set4 = set2;
        } else if ((196608 & $changed) == 0) {
            set4 = set2;
            $dirty3 |= $composer6.changedInstance(set4) ? 131072 : 65536;
        } else {
            set4 = set2;
        }
        int i7 = i & 64;
        if (i7 != 0) {
            $dirty3 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty3 |= $composer6.changed(currentPath) ? 1048576 : 524288;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty3 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty3 |= $composer6.changed(showBraces) ? 8388608 : 4194304;
        }
        if (!$composer6.shouldExecute(($dirty3 & 4793491) != 4793490, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            indent2 = indent;
            searchQuery2 = searchQuery;
            currentPath2 = currentPath;
            showBraces2 = showBraces;
            expandedPaths = set3;
            filteredPaths = set4;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                indent3 = indent;
            } else {
                indent3 = 0;
            }
            if (i4 == 0) {
                searchQuery3 = searchQuery;
            } else {
                searchQuery3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i5 == 0) {
                expandedPaths2 = set3;
            } else {
                expandedPaths2 = SetsKt.emptySet();
            }
            if (i6 == 0) {
                filteredPaths2 = set4;
            } else {
                filteredPaths2 = SetsKt.emptySet();
            }
            if (i7 == 0) {
                currentPath3 = currentPath;
            } else {
                currentPath3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i8 == 0) {
                showBraces3 = showBraces;
            } else {
                showBraces3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-467703359, $dirty3, -1, "kntr.app.ad.ui.inspector.ui.components.ModernJsonArrayDisplay (JsonDisplay.kt:483)");
            }
            int $this$dp$iv = indent3 * 12;
            float f = Dp.constructor-impl($this$dp$iv);
            ComposerKt.sourceInformationMarkerStart($composer6, 1508650863, "CC(remember):JsonDisplay.kt#9igjgp");
            Object it$iv = $composer6.rememberedValue();
            indent2 = indent3;
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateMapOf();
                $composer6.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            Map map = (SnapshotStateMap) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier modifier4 = modifier3;
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(modifier4, f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            $composer2 = $composer6;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $dirty = $dirty3;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            SnapshotStateMap expandedIndices3 = map;
            Set expandedPaths5 = expandedPaths2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            boolean z4 = false;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            String str11 = "C:JsonDisplay.kt#pigpjk";
            Composer $composer7 = $composer6;
            ComposerKt.sourceInformationMarkerStart($composer7, 1917865242, "C:JsonDisplay.kt#pigpjk");
            if (!(searchQuery3.length() == 0)) {
                if (!(currentPath3.length() == 0) && !filteredPaths2.isEmpty()) {
                    Iterable $this$any$iv = filteredPaths2;
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator it2 = $this$any$iv.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z3 = false;
                                break;
                            }
                            Object element$iv = it2.next();
                            Iterable $this$any$iv2 = $this$any$iv;
                            String it3 = (String) element$iv;
                            Iterator it4 = it2;
                            Modifier materialized$iv$iv2 = materialized$iv$iv;
                            boolean z5 = z4;
                            if (StringsKt.startsWith$default(currentPath3, it3, false, 2, (Object) null) || StringsKt.startsWith$default(it3, currentPath3, false, 2, (Object) null)) {
                                z3 = true;
                                break;
                            }
                            $this$any$iv = $this$any$iv2;
                            it2 = it4;
                            materialized$iv$iv = materialized$iv$iv2;
                            z4 = z5;
                        }
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        $composer7.startReplaceGroup(1896569419);
                        $composer7.endReplaceGroup();
                        $composer$iv$iv$iv = $composer6;
                        showBraces2 = showBraces3;
                        $composer$iv = $composer6;
                        searchQuery2 = searchQuery3;
                        filteredPaths = filteredPaths2;
                        currentPath2 = currentPath3;
                        $composer3 = $composer7;
                        expandedPaths = expandedPaths5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier4;
                    }
                }
            }
            $composer7.startReplaceGroup(1918063207);
            ComposerKt.sourceInformation($composer7, "495@21334L503");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            $composer$iv$iv$iv = $composer6;
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
            $composer$iv = $composer6;
            String str12 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            filteredPaths = filteredPaths2;
            String str13 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer7.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer7);
            String str14 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            searchQuery2 = searchQuery3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
            String str15 = "C101@5233L9:Row.kt#2w3rfo";
            ComposerKt.sourceInformationMarkerStart($composer7, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i12 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, 2016038154, "C:JsonDisplay.kt#pigpjk");
            if (showBraces3) {
                $composer7.startReplaceGroup(2016074113);
                ComposerKt.sourceInformation($composer7, "500@21558L10,497@21442L363");
                TextKt.Text-Nvy7gAk("[", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer7, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer7, 390, 0, 131066);
            } else {
                $composer7.startReplaceGroup(1994791404);
            }
            $composer7.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.startReplaceGroup(477531135);
            String str16 = RoomRecommendViewModel.EMPTY_CURSOR;
            ComposerKt.sourceInformation($composer7, RoomRecommendViewModel.EMPTY_CURSOR);
            Iterable $this$forEachIndexed$iv2 = (Iterable) jsonArray;
            boolean z6 = false;
            final int index$iv2 = 0;
            Iterator it5 = $this$forEachIndexed$iv2.iterator();
            while (it5.hasNext()) {
                Object item$iv = it5.next();
                int index$iv3 = index$iv2 + 1;
                if (index$iv2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonObject jsonObject = (JsonElement) item$iv;
                if (currentPath3.length() == 0) {
                    str = String.valueOf(index$iv2);
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    str = currentPath3 + "." + index$iv2;
                }
                String path2 = str;
                if (searchQuery2.length() == 0) {
                    z = z6;
                    it = it5;
                    currentPath4 = currentPath3;
                } else if (filteredPaths.isEmpty()) {
                    z = z6;
                    it = it5;
                    currentPath4 = currentPath3;
                } else {
                    Set $this$any$iv3 = filteredPaths;
                    z = z6;
                    if (!($this$any$iv3 instanceof Collection) || !$this$any$iv3.isEmpty()) {
                        Iterator it6 = $this$any$iv3.iterator();
                        while (true) {
                            if (it6.hasNext()) {
                                Object element$iv2 = it6.next();
                                Iterator it7 = it6;
                                String it8 = (String) element$iv2;
                                it = it5;
                                currentPath4 = currentPath3;
                                Object item$iv2 = item$iv;
                                if (StringsKt.startsWith$default(path2, it8, false, 2, (Object) null) || StringsKt.startsWith$default(it8, path2, false, 2, (Object) null)) {
                                    z2 = true;
                                    break;
                                }
                                it6 = it7;
                                it5 = it;
                                currentPath3 = currentPath4;
                                item$iv = item$iv2;
                            } else {
                                it = it5;
                                currentPath4 = currentPath3;
                                z2 = false;
                                break;
                            }
                        }
                    } else {
                        it = it5;
                        currentPath4 = currentPath3;
                        z2 = false;
                    }
                    if (!z2) {
                        $composer7.startReplaceGroup(1375873629);
                        $composer7.endReplaceGroup();
                        str5 = str16;
                        showBraces4 = showBraces3;
                        path = str15;
                        str6 = str11;
                        $composer5 = $composer7;
                        expandedPaths4 = expandedPaths5;
                        str8 = str12;
                        str9 = str14;
                        index$iv = index$iv3;
                        str7 = str13;
                        expandedIndices2 = expandedIndices3;
                        str12 = str8;
                        str15 = path;
                        $composer7 = $composer5;
                        str14 = str9;
                        str11 = str6;
                        index$iv2 = index$iv;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        expandedIndices3 = expandedIndices2;
                        z6 = z;
                        it5 = it;
                        currentPath3 = currentPath4;
                        showBraces3 = showBraces4;
                        expandedPaths5 = expandedPaths4;
                        str16 = str5;
                        str13 = str7;
                    }
                }
                $composer7.startReplaceGroup(1398348536);
                ComposerKt.sourceInformation($composer7, "534@23156L206,527@22717L6279");
                final boolean isExpandable = (jsonObject instanceof JsonObject) || (jsonObject instanceof JsonArray);
                if (searchQuery2.length() > 0) {
                    expandedPaths3 = expandedPaths5;
                    if (expandedPaths3.contains(path2)) {
                        shouldHighlight = true;
                        Map $this$getOrPut$iv = expandedIndices3;
                        Integer valueOf = Integer.valueOf(index$iv2);
                        value$iv = $this$getOrPut$iv.get(valueOf);
                        if (value$iv != null) {
                            bool = true;
                            $this$getOrPut$iv.put(valueOf, 1);
                        } else {
                            bool = value$iv;
                        }
                        final boolean isExpanded = ((Boolean) bool).booleanValue();
                        index$iv = index$iv3;
                        Modifier modifier5 = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), !shouldHighlight ? ColorKt.Color(4294898631L) : Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                        ComposerKt.sourceInformationMarkerStart($composer7, 876408243, "CC(remember):JsonDisplay.kt#9igjgp");
                        invalid$iv = $composer7.changed(isExpandable) | $composer7.changed(index$iv2) | $composer7.changed(isExpanded);
                        Composer $this$cache$iv = $composer7;
                        Object it$iv2 = $this$cache$iv.rememberedValue();
                        if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                            expandedIndices = expandedIndices3;
                            ComposerKt.sourceInformationMarkerEnd($composer7);
                            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                            $composer$iv2 = $composer7;
                            str2 = str13;
                            expandedIndices2 = expandedIndices;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, str2);
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            showBraces4 = showBraces3;
                            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv3 = (384 << 3) & 112;
                            str3 = str12;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str3);
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3);
                            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            expandedPaths4 = expandedPaths3;
                            $composer4 = $composer7;
                            str4 = str14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str4);
                            if (!($composer$iv2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv2.startReusableNode();
                            if (!$composer$iv2.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                                $composer$iv2.createNode(factory$iv$iv$iv4);
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                                $composer$iv2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, str15);
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i14 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv2, 877608900, str11);
                            if (!isExpandable) {
                                $composer$iv2.startReplaceGroup(877498446);
                                ComposerKt.sourceInformation($composer$iv2, "542@23557L366");
                                AppIcons appIcons = AppIcons.INSTANCE;
                                IconKt.Icon-ww6aTOc(isExpanded ? appIcons.getKeyboardArrowDown() : appIcons.getKeyboardArrowRight(), isExpanded ? "折叠" : "展开", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ColorKt.Color(4285231744L), $composer$iv2, 3456, 0);
                                $composer$iv2.endReplaceGroup();
                            } else {
                                $composer$iv2.startReplaceGroup(877884892);
                                ComposerKt.sourceInformation($composer$iv2, "549@23985L40");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv2, 6);
                                $composer$iv2.endReplaceGroup();
                            }
                            if (jsonObject instanceof JsonObject) {
                                if (!(jsonObject instanceof JsonArray)) {
                                    if (!(jsonObject instanceof JsonPrimitive)) {
                                        if (Intrinsics.areEqual(jsonObject, JsonNull.INSTANCE)) {
                                            $composer$iv2.startReplaceGroup(882321550);
                                            ComposerKt.sourceInformation($composer$iv2, "637@28571L10,634@28416L462");
                                            TextKt.Text-Nvy7gAk("null", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv2, 390, 0, 131066);
                                            $composer$iv2.endReplaceGroup();
                                        } else {
                                            $composer$iv2.startReplaceGroup(882833050);
                                            $composer$iv2.endReplaceGroup();
                                        }
                                    } else {
                                        $composer$iv2.startReplaceGroup(880900851);
                                        ComposerKt.sourceInformation($composer$iv2, "625@28011L10,618@27614L696");
                                        if (((JsonPrimitive) jsonObject).isString()) {
                                            textColor = ColorKt.Color(4278556265L);
                                        } else if (JsonElementKt.getBooleanOrNull((JsonPrimitive) jsonObject) != null) {
                                            textColor = ColorKt.Color(4293870660L);
                                        } else if (JsonElementKt.getLongOrNull((JsonPrimitive) jsonObject) != null || JsonElementKt.getDoubleOrNull((JsonPrimitive) jsonObject) != null) {
                                            textColor = ColorKt.Color(4284704497L);
                                        } else {
                                            textColor = ColorKt.Color(4281811281L);
                                        }
                                        TextKt.Text-Nvy7gAk(((JsonPrimitive) jsonObject).isString() ? "\"" + ((JsonPrimitive) jsonObject).getContent() + "\"" : ((JsonPrimitive) jsonObject).toString(), (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv2, 0, 0, 131066);
                                        $composer$iv2.endReplaceGroup();
                                    }
                                } else {
                                    $composer$iv2.startReplaceGroup(-1495647410);
                                    ComposerKt.sourceInformation($composer$iv2, str16);
                                    if (!isExpanded) {
                                        $composer$iv2.startReplaceGroup(879602943);
                                        ComposerKt.sourceInformation($composer$iv2, "585@25840L10,582@25672L573");
                                        TextKt.Text-Nvy7gAk("[...]", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777173, (Object) null), $composer$iv2, 390, 0, 131066);
                                        $composer$iv2.endReplaceGroup();
                                    } else {
                                        $composer$iv2.startReplaceGroup(880302737);
                                        ComposerKt.sourceInformation($composer$iv2, "597@26544L10,594@26380L491");
                                        TextKt.Text-Nvy7gAk("[", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv2, 390, 0, 131066);
                                        $composer$iv2.endReplaceGroup();
                                    }
                                    $composer$iv2.endReplaceGroup();
                                }
                            } else {
                                $composer$iv2.startReplaceGroup(878107844);
                                ComposerKt.sourceInformation($composer$iv2, str16);
                                if (!isExpanded) {
                                    $composer$iv2.startReplaceGroup(878219103);
                                    ComposerKt.sourceInformation($composer$iv2, "559@24445L10,556@24277L573");
                                    TextKt.Text-Nvy7gAk("{...}", (Modifier) null, ColorKt.Color(4288455599L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777173, (Object) null), $composer$iv2, 390, 0, 131066);
                                    $composer$iv2.endReplaceGroup();
                                } else {
                                    $composer$iv2.startReplaceGroup(878917905);
                                    ComposerKt.sourceInformation($composer$iv2, "571@25148L10,568@24984L491");
                                    TextKt.Text-Nvy7gAk("{", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv2, 390, 0, 131066);
                                    $composer$iv2.endReplaceGroup();
                                }
                                $composer$iv2.endReplaceGroup();
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer$iv2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            if (isExpandable || !isExpanded) {
                                str5 = str16;
                                path = str15;
                                str6 = str11;
                                str7 = str2;
                                str8 = str3;
                                $composer5 = $composer4;
                                str9 = str4;
                                $composer5.startReplaceGroup(1375873629);
                            } else {
                                $composer5 = $composer4;
                                $composer5.startReplaceGroup(1404775146);
                                ComposerKt.sourceInformation($composer5, "651@29119L1471,683@30661L1042");
                                Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv4 = (6 << 3) & 112;
                                str5 = str16;
                                str8 = str3;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, str8);
                                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                                CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
                                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                str9 = str4;
                                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str9);
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                                    $composer5.createNode(factory$iv$iv$iv5);
                                } else {
                                    factory$iv$iv$iv5 = factory$iv$iv$iv10;
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer5);
                                String str17 = str15;
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                int i16 = ((6 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -688520388, str11);
                                if (!(jsonObject instanceof JsonObject)) {
                                    $dirty2 = $dirty;
                                    if (jsonObject instanceof JsonArray) {
                                        $composer5.startReplaceGroup(-1961850739);
                                        ComposerKt.sourceInformation($composer5, "667@29958L532");
                                        ModernJsonArrayDisplay((JsonArray) jsonObject, Modifier.Companion, 0, searchQuery2, expandedPaths4, filteredPaths, path2, false, $composer5, ($dirty2 & 7168) | 12583344 | ($dirty2 & 57344) | ($dirty2 & 458752), 0);
                                        $composer5.endReplaceGroup();
                                    } else {
                                        $composer5.startReplaceGroup(-687277785);
                                        $composer5.endReplaceGroup();
                                    }
                                } else {
                                    $composer5.startReplaceGroup(-1961870515);
                                    ComposerKt.sourceInformation($composer5, "655@29340L532");
                                    $dirty2 = $dirty;
                                    ModernJsonObjectDisplay(jsonObject, Modifier.Companion, 0, searchQuery2, expandedPaths4, filteredPaths, path2, false, $composer5, ($dirty2 & 7168) | 12583344 | ($dirty2 & 57344) | ($dirty2 & 458752), 0);
                                    $composer5.endReplaceGroup();
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(0), 0.0f, 2, (Object) null);
                                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                                str7 = str2;
                                ComposerKt.sourceInformationMarkerStart($composer5, 844473419, str7);
                                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer5, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                int $changed$iv$iv5 = (390 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, str8);
                                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                                $dirty = $dirty2;
                                CompositionLocalMap localMap$iv$iv5 = $composer5.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer5, modifier$iv$iv);
                                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                str6 = str11;
                                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str9);
                                if (!($composer5.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer5.startReusableNode();
                                if ($composer5.getInserting()) {
                                    factory$iv$iv$iv6 = factory$iv$iv$iv11;
                                    $composer5.createNode(factory$iv$iv$iv6);
                                } else {
                                    factory$iv$iv$iv6 = factory$iv$iv$iv11;
                                    $composer5.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer5);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                                int i17 = ($changed$iv$iv$iv5 >> 6) & 14;
                                path = str17;
                                ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, path);
                                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                                int i18 = ((390 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer5, -1435851452, "C687@30889L40,696@31384L10,688@30985L692:JsonDisplay.kt#pigpjk");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(28)), $composer5, 6);
                                if (jsonObject instanceof JsonObject) {
                                    str10 = "}";
                                } else {
                                    str10 = jsonObject instanceof JsonArray ? "]" : str5;
                                }
                                TextKt.Text-Nvy7gAk(str10, (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer5, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer5, 384, 0, 131066);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                $composer5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                            }
                            $composer5.endReplaceGroup();
                            $composer5.endReplaceGroup();
                            str12 = str8;
                            str15 = path;
                            $composer7 = $composer5;
                            str14 = str9;
                            str11 = str6;
                            index$iv2 = index$iv;
                            $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                            expandedIndices3 = expandedIndices2;
                            z6 = z;
                            it5 = it;
                            currentPath3 = currentPath4;
                            showBraces3 = showBraces4;
                            expandedPaths5 = expandedPaths4;
                            str16 = str5;
                            str13 = str7;
                        }
                        expandedIndices = expandedIndices3;
                        Object value$iv3 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit ModernJsonArrayDisplay$lambda$1$2$2$0;
                                ModernJsonArrayDisplay$lambda$1$2$2$0 = JsonDisplayKt.ModernJsonArrayDisplay$lambda$1$2$2$0(isExpandable, expandedIndices, index$iv2, isExpanded);
                                return ModernJsonArrayDisplay$lambda$1$2$2$0;
                            }
                        };
                        $this$cache$iv.updateRememberedValue(value$iv3);
                        it$iv2 = value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer7);
                        Modifier modifier$iv32 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                        Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getCenterVertically();
                        $composer$iv2 = $composer7;
                        str2 = str13;
                        expandedIndices2 = expandedIndices;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, str2);
                        Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
                        showBraces4 = showBraces3;
                        MeasurePolicy measurePolicy$iv32 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv32 = (384 << 3) & 112;
                        str3 = str12;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str3);
                        int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                        CompositionLocalMap localMap$iv$iv32 = $composer$iv2.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv32);
                        Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                        expandedPaths4 = expandedPaths3;
                        $composer4 = $composer7;
                        str4 = str14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str4);
                        if (!($composer$iv2.getApplier() instanceof Applier)) {
                        }
                        $composer$iv2.startReusableNode();
                        if (!$composer$iv2.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer$iv2);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                        int i132 = ($changed$iv$iv$iv32 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, str15);
                        RowScope rowScope22 = RowScopeInstance.INSTANCE;
                        int i142 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv2, 877608900, str11);
                        if (!isExpandable) {
                        }
                        if (jsonObject instanceof JsonObject) {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer$iv2.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        if (isExpandable) {
                        }
                        str5 = str16;
                        path = str15;
                        str6 = str11;
                        str7 = str2;
                        str8 = str3;
                        $composer5 = $composer4;
                        str9 = str4;
                        $composer5.startReplaceGroup(1375873629);
                        $composer5.endReplaceGroup();
                        $composer5.endReplaceGroup();
                        str12 = str8;
                        str15 = path;
                        $composer7 = $composer5;
                        str14 = str9;
                        str11 = str6;
                        index$iv2 = index$iv;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        expandedIndices3 = expandedIndices2;
                        z6 = z;
                        it5 = it;
                        currentPath3 = currentPath4;
                        showBraces3 = showBraces4;
                        expandedPaths5 = expandedPaths4;
                        str16 = str5;
                        str13 = str7;
                    }
                } else {
                    expandedPaths3 = expandedPaths5;
                }
                shouldHighlight = false;
                Map $this$getOrPut$iv2 = expandedIndices3;
                Integer valueOf2 = Integer.valueOf(index$iv2);
                value$iv = $this$getOrPut$iv2.get(valueOf2);
                if (value$iv != null) {
                }
                final boolean isExpanded2 = ((Boolean) bool).booleanValue();
                index$iv = index$iv3;
                Modifier modifier52 = BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), !shouldHighlight ? ColorKt.Color(4294898631L) : Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                ComposerKt.sourceInformationMarkerStart($composer7, 876408243, "CC(remember):JsonDisplay.kt#9igjgp");
                invalid$iv = $composer7.changed(isExpandable) | $composer7.changed(index$iv2) | $composer7.changed(isExpanded2);
                Composer $this$cache$iv2 = $composer7;
                Object it$iv22 = $this$cache$iv2.rememberedValue();
                if (!invalid$iv) {
                    expandedIndices = expandedIndices3;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    Modifier modifier$iv322 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier52, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv22, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv222 = Alignment.Companion.getCenterVertically();
                    $composer$iv2 = $composer7;
                    str2 = str13;
                    expandedIndices2 = expandedIndices;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, str2);
                    Arrangement.Horizontal horizontalArrangement$iv222 = Arrangement.INSTANCE.getStart();
                    showBraces4 = showBraces3;
                    MeasurePolicy measurePolicy$iv322 = RowKt.rowMeasurePolicy(horizontalArrangement$iv222, verticalAlignment$iv222, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv322 = (384 << 3) & 112;
                    str3 = str12;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str3);
                    int compositeKeyHash$iv$iv322 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    CompositionLocalMap localMap$iv$iv322 = $composer$iv2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv422 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv322);
                    Function0 factory$iv$iv$iv922 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv322 = (($changed$iv$iv322 << 6) & 896) | 6;
                    expandedPaths4 = expandedPaths3;
                    $composer4 = $composer7;
                    str4 = str14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str4);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                    }
                    $composer$iv2.startReusableNode();
                    if (!$composer$iv2.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv322 = Updater.constructor-impl($composer$iv2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, measurePolicy$iv322, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, localMap$iv$iv322, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv322, Integer.valueOf(compositeKeyHash$iv$iv322), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv322, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv322, materialized$iv$iv422, ComposeUiNode.Companion.getSetModifier());
                    int i1322 = ($changed$iv$iv$iv322 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, str15);
                    RowScope rowScope222 = RowScopeInstance.INSTANCE;
                    int i1422 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 877608900, str11);
                    if (!isExpandable) {
                    }
                    if (jsonObject instanceof JsonObject) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (isExpandable) {
                    }
                    str5 = str16;
                    path = str15;
                    str6 = str11;
                    str7 = str2;
                    str8 = str3;
                    $composer5 = $composer4;
                    str9 = str4;
                    $composer5.startReplaceGroup(1375873629);
                    $composer5.endReplaceGroup();
                    $composer5.endReplaceGroup();
                    str12 = str8;
                    str15 = path;
                    $composer7 = $composer5;
                    str14 = str9;
                    str11 = str6;
                    index$iv2 = index$iv;
                    $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    expandedIndices3 = expandedIndices2;
                    z6 = z;
                    it5 = it;
                    currentPath3 = currentPath4;
                    showBraces3 = showBraces4;
                    expandedPaths5 = expandedPaths4;
                    str16 = str5;
                    str13 = str7;
                }
                expandedIndices = expandedIndices3;
                Object value$iv32 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit ModernJsonArrayDisplay$lambda$1$2$2$0;
                        ModernJsonArrayDisplay$lambda$1$2$2$0 = JsonDisplayKt.ModernJsonArrayDisplay$lambda$1$2$2$0(isExpandable, expandedIndices, index$iv2, isExpanded2);
                        return ModernJsonArrayDisplay$lambda$1$2$2$0;
                    }
                };
                $this$cache$iv2.updateRememberedValue(value$iv32);
                it$iv22 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                Modifier modifier$iv3222 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier52, isExpandable, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv22, 14, (Object) null), 0.0f, Dp.constructor-impl(2), 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv2222 = Alignment.Companion.getCenterVertically();
                $composer$iv2 = $composer7;
                str2 = str13;
                expandedIndices2 = expandedIndices;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, str2);
                Arrangement.Horizontal horizontalArrangement$iv2222 = Arrangement.INSTANCE.getStart();
                showBraces4 = showBraces3;
                MeasurePolicy measurePolicy$iv3222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2222, verticalAlignment$iv2222, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3222 = (384 << 3) & 112;
                str3 = str12;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str3);
                int compositeKeyHash$iv$iv3222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                CompositionLocalMap localMap$iv$iv3222 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4222 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3222);
                Function0 factory$iv$iv$iv9222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3222 = (($changed$iv$iv3222 << 6) & 896) | 6;
                expandedPaths4 = expandedPaths3;
                $composer4 = $composer7;
                str4 = str14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str4);
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                }
                $composer$iv2.startReusableNode();
                if (!$composer$iv2.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3222 = Updater.constructor-impl($composer$iv2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, measurePolicy$iv3222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, localMap$iv$iv3222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3222, Integer.valueOf(compositeKeyHash$iv$iv3222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3222, materialized$iv$iv4222, ComposeUiNode.Companion.getSetModifier());
                int i13222 = ($changed$iv$iv$iv3222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, str15);
                RowScope rowScope2222 = RowScopeInstance.INSTANCE;
                int i14222 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 877608900, str11);
                if (!isExpandable) {
                }
                if (jsonObject instanceof JsonObject) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (isExpandable) {
                }
                str5 = str16;
                path = str15;
                str6 = str11;
                str7 = str2;
                str8 = str3;
                $composer5 = $composer4;
                str9 = str4;
                $composer5.startReplaceGroup(1375873629);
                $composer5.endReplaceGroup();
                $composer5.endReplaceGroup();
                str12 = str8;
                str15 = path;
                $composer7 = $composer5;
                str14 = str9;
                str11 = str6;
                index$iv2 = index$iv;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                expandedIndices3 = expandedIndices2;
                z6 = z;
                it5 = it;
                currentPath3 = currentPath4;
                showBraces3 = showBraces4;
                expandedPaths5 = expandedPaths4;
                str16 = str5;
                str13 = str7;
            }
            showBraces2 = showBraces3;
            String str18 = str15;
            currentPath2 = currentPath3;
            $composer3 = $composer7;
            expandedPaths = expandedPaths5;
            String str19 = str12;
            String str20 = str13;
            String str21 = str14;
            $composer3.endReplaceGroup();
            if (showBraces2) {
                $composer3.startReplaceGroup(1928121684);
                ComposerKt.sourceInformation($composer3, "708@31805L567");
                Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, str20);
                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv6 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str19);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $i$f$Row = $changed$iv$iv6 << 6;
                int $changed$iv$iv$iv6 = ($i$f$Row & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str21);
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv12;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv12;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i19 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, str18);
                RowScope rowScope4 = RowScopeInstance.INSTANCE;
                int i20 = ((390 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 992481031, "C715@32107L10,712@31991L363:JsonDisplay.kt#pigpjk");
                TextKt.Text-Nvy7gAk("]", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer3, 390, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer3.startReplaceGroup(1896569419);
            }
            $composer3.endReplaceGroup();
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final int i21 = indent2;
            final String str22 = searchQuery2;
            final Set set5 = expandedPaths;
            final Set set6 = filteredPaths;
            final String str23 = currentPath2;
            final boolean z7 = showBraces2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernJsonArrayDisplay$lambda$2;
                    ModernJsonArrayDisplay$lambda$2 = JsonDisplayKt.ModernJsonArrayDisplay$lambda$2(jsonArray, modifier6, i21, str22, set5, set6, str23, z7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernJsonArrayDisplay$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernJsonArrayDisplay$lambda$1$2$2$0(boolean $isExpandable, SnapshotStateMap $expandedIndices, int $index, boolean $isExpanded) {
        if ($isExpandable) {
            ((Map) $expandedIndices).put(Integer.valueOf($index), Boolean.valueOf(!$isExpanded));
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ Set findMatchingPaths$default(JsonElement jsonElement, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return findMatchingPaths(jsonElement, str, str2);
    }

    private static final Set<String> findMatchingPaths(JsonElement jsonElement, String searchQuery, String currentPath) {
        Iterable $this$forEachIndexed$iv;
        boolean z;
        Iterator it;
        Set paths = new LinkedHashSet();
        String lowerCase = searchQuery.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String query = StringsKt.trim(lowerCase).toString();
        if (query.length() == 0) {
            return paths;
        }
        if (jsonElement instanceof JsonObject) {
            Iterable $this$forEach$iv = ((JsonObject) jsonElement).entrySet();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry entry = (Map.Entry) element$iv;
                String key = (String) entry.getKey();
                JsonPrimitive jsonPrimitive = (JsonElement) entry.getValue();
                String path = currentPath.length() == 0 ? key : currentPath + "." + key;
                String lowerCase2 = key.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                if (StringsKt.contains$default(lowerCase2, query, false, 2, (Object) null)) {
                    findMatchingPaths$addPath(paths, path);
                }
                if (jsonPrimitive instanceof JsonPrimitive) {
                    String content = findMatchingPaths$getPrimitiveContent(jsonPrimitive).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(content, "toLowerCase(...)");
                    if (StringsKt.contains$default(content, query, false, 2, (Object) null)) {
                        findMatchingPaths$addPath(paths, path);
                    }
                } else if (jsonPrimitive instanceof JsonObject) {
                    Set childPaths = findMatchingPaths(jsonPrimitive, query, path);
                    if (!childPaths.isEmpty()) {
                        findMatchingPaths$addPath(paths, path);
                        paths.addAll(childPaths);
                    }
                } else if (!(jsonPrimitive instanceof JsonArray)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    Set childPaths2 = findMatchingPaths(jsonPrimitive, query, path);
                    if (!childPaths2.isEmpty()) {
                        findMatchingPaths$addPath(paths, path);
                        paths.addAll(childPaths2);
                    }
                }
                $this$forEach$iv = $this$forEach$iv2;
            }
        } else if (jsonElement instanceof JsonArray) {
            Iterable $this$forEachIndexed$iv2 = (Iterable) jsonElement;
            boolean z2 = false;
            int index$iv = 0;
            Iterator it2 = $this$forEachIndexed$iv2.iterator();
            while (it2.hasNext()) {
                Object item$iv = it2.next();
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonPrimitive jsonPrimitive2 = (JsonElement) item$iv;
                String path2 = currentPath.length() == 0 ? String.valueOf(index$iv) : currentPath + "." + index$iv;
                if (jsonPrimitive2 instanceof JsonPrimitive) {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    String content2 = findMatchingPaths$getPrimitiveContent(jsonPrimitive2).toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(content2, "toLowerCase(...)");
                    z = z2;
                    it = it2;
                    if (StringsKt.contains$default(content2, query, false, 2, (Object) null)) {
                        findMatchingPaths$addPath(paths, path2);
                    }
                } else {
                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                    z = z2;
                    it = it2;
                    if (jsonPrimitive2 instanceof JsonObject) {
                        Set childPaths3 = findMatchingPaths(jsonPrimitive2, query, path2);
                        if (!childPaths3.isEmpty()) {
                            findMatchingPaths$addPath(paths, path2);
                            paths.addAll(childPaths3);
                        }
                    } else if (!(jsonPrimitive2 instanceof JsonArray)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        Set childPaths4 = findMatchingPaths(jsonPrimitive2, query, path2);
                        if (!childPaths4.isEmpty()) {
                            findMatchingPaths$addPath(paths, path2);
                            paths.addAll(childPaths4);
                        }
                    }
                }
                index$iv = index$iv2;
                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                z2 = z;
                it2 = it;
            }
        } else if (jsonElement instanceof JsonPrimitive) {
            String content3 = findMatchingPaths$getPrimitiveContent((JsonPrimitive) jsonElement).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(content3, "toLowerCase(...)");
            if (StringsKt.contains$default(content3, query, false, 2, (Object) null)) {
                findMatchingPaths$addPath(paths, currentPath);
            }
        }
        return paths;
    }

    private static final void findMatchingPaths$addPath(Set<String> set, String path) {
        if (path.length() > 0) {
            set.add(path);
        }
    }

    private static final String findMatchingPaths$getPrimitiveContent(JsonPrimitive primitive) {
        return primitive.isString() ? primitive.getContent() : primitive.toString();
    }

    static /* synthetic */ Set getAllPaths$default(JsonElement jsonElement, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return getAllPaths(jsonElement, str);
    }

    private static final Set<String> getAllPaths(JsonElement jsonElement, String currentPath) {
        Set paths = new LinkedHashSet();
        if (jsonElement instanceof JsonObject) {
            Iterable $this$forEach$iv = ((JsonObject) jsonElement).entrySet();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry entry = (Map.Entry) element$iv;
                String key = (String) entry.getKey();
                JsonElement value = (JsonElement) entry.getValue();
                String path = currentPath.length() == 0 ? key : currentPath + "." + key;
                getAllPaths$addPath(paths, path);
                if ((value instanceof JsonObject) || (value instanceof JsonArray)) {
                    paths.addAll(getAllPaths(value, path));
                }
            }
        } else if (jsonElement instanceof JsonArray) {
            Iterable $this$forEachIndexed$iv = (Iterable) jsonElement;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonElement element = (JsonElement) item$iv;
                String path2 = currentPath.length() == 0 ? String.valueOf(index) : currentPath + "." + index;
                getAllPaths$addPath(paths, path2);
                if ((element instanceof JsonObject) || (element instanceof JsonArray)) {
                    paths.addAll(getAllPaths(element, path2));
                }
                index = index$iv;
            }
        }
        return paths;
    }

    private static final void getAllPaths$addPath(Set<String> set, String path) {
        if (path.length() > 0) {
            set.add(path);
        }
    }

    private static final Set<String> getAllParentPaths(Set<String> set) {
        Iterable $this$forEach$iv;
        String str;
        Set allPaths = new LinkedHashSet();
        Set<String> $this$forEach$iv2 = set;
        for (Object element$iv : $this$forEach$iv2) {
            String path = (String) element$iv;
            allPaths.add(path);
            Iterable parts = StringsKt.split$default(path, new String[]{"."}, false, 0, 6, (Object) null);
            String str2 = RoomRecommendViewModel.EMPTY_CURSOR;
            for (Object element$iv2 : parts) {
                String part = (String) element$iv2;
                if (str2.length() == 0) {
                    $this$forEach$iv = $this$forEach$iv2;
                    str = part;
                } else {
                    $this$forEach$iv = $this$forEach$iv2;
                    str = ((Object) str2) + "." + part;
                }
                str2 = str;
                allPaths.add(str2);
                $this$forEach$iv2 = $this$forEach$iv;
            }
        }
        return allPaths;
    }
}