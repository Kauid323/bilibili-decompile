package kntr.app.ad.ui.inspector.ui.main.ad;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.app.ad.domain.inspector.core.work.IJobData;
import kntr.app.ad.domain.inspector.core.work.IStage;
import kntr.app.ad.domain.inspector.core.work.PrintJobData;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.domain.inspector.core.work.ReportType;
import kntr.app.ad.domain.inspector.model.InspectorInfo;
import kntr.app.ad.domain.inspector.model.StageType;
import kntr.app.ad.ui.inspector.core.util.AdTrackId;
import kntr.app.ad.ui.inspector.core.util.AdTrackIdDecoder;
import kntr.app.ad.ui.inspector.core.util.AdcbDecoder;
import kntr.app.ad.ui.inspector.core.util.SettingsManager;
import kntr.app.ad.ui.inspector.core.util.ShareText_androidKt;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.LocalUserRoleKt;
import kntr.app.ad.ui.inspector.ui.components.AdSlotIconKt;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.JsonDisplayKt;
import kntr.app.ad.ui.inspector.ui.components.StatusBadgeKt;
import kntr.app.ad.ui.inspector.ui.main.ad.viewmodel.AdDetailViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: AdDetailScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a>\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007¢\u0006\u0002\b\u0013H\u0003¢\u0006\u0002\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a#\u0010\u001a\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0003¢\u0006\u0002\u0010 ¨\u0006!²\u0006\n\u0010\"\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010$\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0011X\u008a\u008e\u0002²\u0006\f\u0010&\u001a\u0004\u0018\u00010\u0003X\u008a\u008e\u0002"}, d2 = {"AdDetailScreen", RoomRecommendViewModel.EMPTY_CURSOR, "adId", RoomRecommendViewModel.EMPTY_CURSOR, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "onReportClick", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ModernAdInfoCard", "adInfo", "Lkntr/app/ad/domain/inspector/model/InspectorInfo;", "(Lkntr/app/ad/domain/inspector/model/InspectorInfo;Landroidx/compose/runtime/Composer;I)V", "ExpandableInfoRow", "label", "value", "canExpand", RoomRecommendViewModel.EMPTY_CURSOR, "expandedContent", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "JsonContent", "json", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/JsonElement;Landroidx/compose/runtime/Composer;I)V", "ModernAdDetailCard", "ModernAdReportCard", "(Lkntr/app/ad/domain/inspector/model/InspectorInfo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TimelineView", "stages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/inspector/core/work/IStage;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug", "parseAdcb", "parseTrackId", "isExpanded", "copied", "jsonToCopy"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdDetailScreenKt {

    /* compiled from: AdDetailScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReportType.values().length];
            try {
                iArr[ReportType.FEE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ReportType.UI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ReportType.MMA.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$1(String str, PaddingValues paddingValues, Function0 function0, int i, Composer composer, int i2) {
        AdDetailScreen(str, paddingValues, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$3(String str, PaddingValues paddingValues, Function0 function0, int i, Composer composer, int i2) {
        AdDetailScreen(str, paddingValues, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandableInfoRow$lambda$4(String str, String str2, boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        ExpandableInfoRow(str, str2, z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit JsonContent$lambda$1(JsonElement jsonElement, int i, Composer composer, int i2) {
        JsonContent(jsonElement, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$1(InspectorInfo inspectorInfo, int i, Composer composer, int i2) {
        ModernAdDetailCard(inspectorInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdInfoCard$lambda$1(InspectorInfo inspectorInfo, int i, Composer composer, int i2) {
        ModernAdInfoCard(inspectorInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdReportCard$lambda$2(InspectorInfo inspectorInfo, Function0 function0, int i, Composer composer, int i2) {
        ModernAdReportCard(inspectorInfo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimelineView$lambda$1(List list, int i, Composer composer, int i2) {
        TimelineView(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AdDetailScreen(final String adId, final PaddingValues paddingValues, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(adId, "adId");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(function0, "onReportClick");
        Composer $composer3 = $composer.startRestartGroup(-2129369640);
        ComposerKt.sourceInformation($composer3, "C(AdDetailScreen)N(adId,paddingValues,onReportClick)75@3425L32,77@3548L20,98@4123L855,89@3795L1183:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(adId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(paddingValues) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2129369640, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreen (AdDetailScreen.kt:74)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1919787048, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new AdDetailViewModel();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AdDetailViewModel viewModel = (AdDetailViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State inspectorState = SnapshotStateKt.collectAsState(viewModel.getInspectorInfoByIdFlow(adId), (Object) null, (CoroutineContext) null, $composer3, 48, 2);
            final InspectorInfo adInfo = (InspectorInfo) inspectorState.getValue();
            if (adInfo == null) {
                $composer3.startReplaceGroup(616351606);
                ComposerKt.sourceInformation($composer3, "81@3642L85");
                EmptyViewKt.EmptyView("暂无数据", null, "请尝试创建一个新的上报", $composer3, 390, 2);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj, Object obj2) {
                            Unit AdDetailScreen$lambda$1;
                            AdDetailScreen$lambda$1 = AdDetailScreenKt.AdDetailScreen$lambda$1(adId, paddingValues, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                            return AdDetailScreen$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            $composer3.startReplaceGroup(612744074);
            $composer3.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(paddingValues.calculateTopPadding-D9Ej5fM() + Dp.constructor-impl(16)), Dp.constructor-impl(16), Dp.constructor-impl(paddingValues.calculateBottomPadding-D9Ej5fM() + Dp.constructor-impl(16)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1919763889, "CC(remember):AdDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(adInfo) | (($dirty2 & 896) == 256);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit AdDetailScreen$lambda$2$0;
                        AdDetailScreen$lambda$2$0 = AdDetailScreenKt.AdDetailScreen$lambda$2$0(InspectorInfo.this, function0, (LazyListScope) obj);
                        return AdDetailScreen$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, paddingValues2, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv2, $composer3, 6, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdDetailScreen$lambda$3;
                    AdDetailScreen$lambda$3 = AdDetailScreenKt.AdDetailScreen$lambda$3(adId, paddingValues, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AdDetailScreen$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$2$0(final InspectorInfo $adInfo, final Function0 $onReportClick, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-390384723, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda7
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AdDetailScreen$lambda$2$0$0;
                AdDetailScreen$lambda$2$0$0 = AdDetailScreenKt.AdDetailScreen$lambda$2$0$0(InspectorInfo.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AdDetailScreen$lambda$2$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1373670172, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AdDetailScreen$lambda$2$0$1;
                AdDetailScreen$lambda$2$0$1 = AdDetailScreenKt.AdDetailScreen$lambda$2$0$1(InspectorInfo.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AdDetailScreen$lambda$2$0$1;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-574095643, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda9
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AdDetailScreen$lambda$2$0$2;
                AdDetailScreen$lambda$2$0$2 = AdDetailScreenKt.AdDetailScreen$lambda$2$0$2(InspectorInfo.this, $onReportClick, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AdDetailScreen$lambda$2$0$2;
            }
        }), 3, (Object) null);
        Iterable $this$mapNotNull$iv = StageType.getEntries();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            StageType stageType = (StageType) element$iv$iv$iv;
            IStage stage = $adInfo.getPipeline().getStage(stageType);
            if (stage.getJobs().isEmpty()) {
                stage = null;
            }
            if (stage != null) {
                destination$iv$iv.add(stage);
            }
        }
        final List stages = (List) destination$iv$iv;
        if (!stages.isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1582299384, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AdDetailScreen$lambda$2$0$4;
                    AdDetailScreen$lambda$2$0$4 = AdDetailScreenKt.AdDetailScreen$lambda$2$0$4(stages, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AdDetailScreen$lambda$2$0$4;
                }
            }), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$2$0$0(InspectorInfo $adInfo, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C101@4170L64:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-390384723, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreen.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:101)");
            }
            ModernAdInfoCard($adInfo, $composer, InspectorInfo.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$2$0$1(InspectorInfo $adInfo, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C108@4289L66:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1373670172, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreen.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:108)");
            }
            ModernAdDetailCard($adInfo, $composer, InspectorInfo.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$2$0$2(InspectorInfo $adInfo, Function0 $onReportClick, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C115@4410L113:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-574095643, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreen.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:115)");
            }
            ModernAdReportCard($adInfo, $onReportClick, $composer, InspectorInfo.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdDetailScreen$lambda$2$0$4(List $stages, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C131@4880L68:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1582299384, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreen.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:131)");
            }
            TimelineView($stages, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ModernAdInfoCard(final InspectorInfo adInfo, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(699256325);
        ComposerKt.sourceInformation($composer3, "C(ModernAdInfoCard)N(adInfo)149@5285L4806,141@5052L5039:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(adInfo) : $composer3.changedInstance(adInfo) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(699256325, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdInfoCard (AdDetailScreen.kt:140)");
            }
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1638459594, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdInfoCard$lambda$0;
                    ModernAdInfoCard$lambda$0 = AdDetailScreenKt.ModernAdInfoCard$lambda$0(InspectorInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdInfoCard$lambda$0;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdInfoCard$lambda$1;
                    ModernAdInfoCard$lambda$1 = AdDetailScreenKt.ModernAdInfoCard$lambda$1(InspectorInfo.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdInfoCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdInfoCard$lambda$0(InspectorInfo $adInfo, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        final InspectorInfo inspectorInfo;
        Function2 function2;
        Function2 function22;
        String take;
        String sb;
        ComposerKt.sourceInformation($composer, "C150@5295L4790:AdDetailScreen.kt#rz1uci");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1638459594, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdInfoCard.<anonymous> (AdDetailScreen.kt:150)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2139614300, "C154@5428L1015,183@6457L135,189@6626L3449:AdDetailScreen.kt#rz1uci");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((390 >> 6) & 112) | 6;
            RowScope $this$ModernAdInfoCard_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 53297080, "C158@5590L25,160@5633L40,162@5691L594,177@6303L40,180@6385L44:AdDetailScreen.kt#rz1uci");
            AdSlotIconKt.AdSlotIcon($adInfo.getAdSlot(), $composer, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$ModernAdInfoCard_u24lambda_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1112878562, "C167@5923L10,164@5780L487:AdDetailScreen.kt#rz1uci");
            String title = $adInfo.getAdData().getTitle();
            if (title == null) {
                title = "未命名广告";
            }
            TextKt.Text-Nvy7gAk(title, (Modifier) null, ColorKt.Color(4280232247L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), 0L, TextUnitKt.getSp(16), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 384, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            StatusBadgeKt.StatusBadge($adInfo.getPipeline().getStatus(), $composer, 0);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), 0.0f, ColorKt.Color(4293060848L), $composer, 390, 2);
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1794604534, "C193@6762L140,199@6949L138,205@7134L150,211@7369L16,212@7402L1191,240@8687L16,241@8720L1341:AdDetailScreen.kt#rz1uci");
            String creativeId = $adInfo.getAdData().getCreativeId();
            ExpandableInfoRow("creativeId", creativeId == null ? "未知" : creativeId, false, null, $composer, 6, 12);
            String salesType = $adInfo.getAdData().getSalesType();
            ExpandableInfoRow("salesType", salesType == null ? "未知" : salesType, false, null, $composer, 6, 12);
            Integer cardStyle = $adInfo.getAdData().getCardStyle();
            ExpandableInfoRow("cardStyle", (cardStyle == null || (r0 = String.valueOf(cardStyle.intValue())) == null) ? "标准" : "标准", false, null, $composer, 6, 12);
            State parseAdcb$delegate = SnapshotStateKt.collectAsState(SettingsManager.INSTANCE.getParseAdcb(), (CoroutineContext) null, $composer, 0, 1);
            String str = StringsKt.take($adInfo.getAdData().getAdcb(), 16) + "...";
            boolean ModernAdInfoCard$lambda$0$0$1$0 = ModernAdInfoCard$lambda$0$0$1$0(parseAdcb$delegate);
            if (ModernAdInfoCard$lambda$0$0$1$0(parseAdcb$delegate)) {
                $composer.startReplaceGroup(-1793724352);
                ComposerKt.sourceInformation($composer, "221@7758L724");
                inspectorInfo = $adInfo;
                $composer.endReplaceGroup();
                function2 = (Function2) ComposableLambdaKt.rememberComposableLambda(1118516126, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ModernAdInfoCard$lambda$0$0$1$1;
                        ModernAdInfoCard$lambda$0$0$1$1 = AdDetailScreenKt.ModernAdInfoCard$lambda$0$0$1$1(InspectorInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                        return ModernAdInfoCard$lambda$0$0$1$1;
                    }
                }, $composer, 54);
            } else {
                inspectorInfo = $adInfo;
                $composer.startReplaceGroup(-1792966960);
                $composer.endReplaceGroup();
                function2 = null;
            }
            ExpandableInfoRow("adcb", str, ModernAdInfoCard$lambda$0$0$1$0, function2, $composer, 6, 0);
            State parseTrackId$delegate = SnapshotStateKt.collectAsState(SettingsManager.INSTANCE.getParseTrackId(), (CoroutineContext) null, $composer, 0, 1);
            String trackId = $adInfo.getAdData().getTrackId();
            String str2 = (trackId == null || (take = StringsKt.take(trackId, 16)) == null || (sb = new StringBuilder().append(take).append("...").toString()) == null) ? "未知" : sb;
            boolean ModernAdInfoCard$lambda$0$0$1$2 = ModernAdInfoCard$lambda$0$0$1$2(parseTrackId$delegate);
            if (ModernAdInfoCard$lambda$0$0$1$2(parseTrackId$delegate)) {
                $composer.startReplaceGroup(-1792390143);
                ComposerKt.sourceInformation($composer, "250@9099L851");
                $composer.endReplaceGroup();
                function22 = (Function2) ComposableLambdaKt.rememberComposableLambda(1004905631, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj, Object obj2) {
                        Unit ModernAdInfoCard$lambda$0$0$1$3;
                        ModernAdInfoCard$lambda$0$0$1$3 = AdDetailScreenKt.ModernAdInfoCard$lambda$0$0$1$3(InspectorInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                        return ModernAdInfoCard$lambda$0$0$1$3;
                    }
                }, $composer, 54);
            } else {
                $composer.startReplaceGroup(-1791510704);
                $composer.endReplaceGroup();
                function22 = null;
            }
            ExpandableInfoRow("track_id", str2, ModernAdInfoCard$lambda$0$0$1$2, function22, $composer, 6, 0);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean ModernAdInfoCard$lambda$0$0$1$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdInfoCard$lambda$0$0$1$1(InspectorInfo $adInfo, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C223@7846L163:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1118516126, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdInfoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:222)");
            }
            String adcb = $adInfo.getAdData().getAdcb();
            ComposerKt.sourceInformationMarkerStart($composer, 1152176065, "CC(remember):AdDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(adcb);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                String it = $adInfo.getAdData().getAdcb();
                AdcbDecoder.AdcbResult processAdcb = AdcbDecoder.INSTANCE.processAdcb(it);
                $composer.updateRememberedValue(processAdcb);
                it$iv = processAdcb;
            }
            AdcbDecoder.AdcbResult decodedAdcb = (AdcbDecoder.AdcbResult) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (decodedAdcb instanceof AdcbDecoder.AdcbResult.Success) {
                $composer.startReplaceGroup(1357970749);
                ComposerKt.sourceInformation($composer, "228@8189L168,231@8394L24");
                String jsonString = ((AdcbDecoder.AdcbResult.Success) decodedAdcb).getJsonString();
                ComposerKt.sourceInformationMarkerStart($composer, 1152187046, "CC(remember):AdDetailScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(jsonString);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = Json.Default.parseToJsonElement(((AdcbDecoder.AdcbResult.Success) decodedAdcb).getJsonString());
                    $composer.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                JsonElement jsonElement = (JsonElement) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                JsonContent(jsonElement, $composer, 0);
            } else {
                $composer.startReplaceGroup(1349930372);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean ModernAdInfoCard$lambda$0$0$1$2(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdInfoCard$lambda$0$0$1$3(InspectorInfo $adInfo, Composer $composer, int $changed) {
        AdTrackId decryptTrackId;
        String result;
        ComposerKt.sourceInformation($composer, "C252@9190L570:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1004905631, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdInfoCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:251)");
            }
            String trackId = $adInfo.getAdData().getTrackId();
            ComposerKt.sourceInformationMarkerStart($composer, -653326727, "CC(remember):AdDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(trackId);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                String it = $adInfo.getAdData().getTrackId();
                JsonElement jsonElement = null;
                if (it != null && (decryptTrackId = AdTrackIdDecoder.INSTANCE.decryptTrackId(it)) != null && (result = decryptTrackId.toJson()) != null) {
                    jsonElement = Json.Default.parseToJsonElement(result);
                }
                Object value$iv = jsonElement;
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            JsonElement decodedTrackId = (JsonElement) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (decodedTrackId != null) {
                $composer.startReplaceGroup(1222319296);
                ComposerKt.sourceInformation($composer, "263@9859L27");
                JsonContent(decodedTrackId, $composer, 0);
            } else {
                $composer.startReplaceGroup(1212572803);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x073e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void ExpandableInfoRow(final String label, final String value, boolean canExpand, Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function2 expandedContent;
        Composer $composer2;
        boolean canExpand2;
        Function2 expandedContent2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        final Function2 expandedContent3;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(1419244227);
        ComposerKt.sourceInformation($composer4, "C(ExpandableInfoRow)N(label,value,canExpand,expandedContent)282@10289L34,284@10329L2610:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(label) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(value) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            z = canExpand;
        } else if (($changed & 384) == 0) {
            z = canExpand;
            $dirty |= $composer4.changed(z) ? 256 : 128;
        } else {
            z = canExpand;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            expandedContent = function2;
        } else if (($changed & 3072) == 0) {
            expandedContent = function2;
            $dirty |= $composer4.changedInstance(expandedContent) ? 2048 : 1024;
        } else {
            expandedContent = function2;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                canExpand2 = false;
            } else {
                canExpand2 = z;
            }
            if (i3 == 0) {
                expandedContent2 = expandedContent;
            } else {
                expandedContent2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1419244227, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ExpandableInfoRow (AdDetailScreen.kt:281)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -1905892379, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState isExpanded$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Function2 expandedContent4 = expandedContent2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1283271298, "C291@10568L28,287@10397L2066:AdDetailScreen.kt#rz1uci");
            Modifier modifier = PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer4, 872682805, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ExpandableInfoRow$lambda$3$0$0;
                        ExpandableInfoRow$lambda$3$0$0 = AdDetailScreenKt.ExpandableInfoRow$lambda$3$0$0(isExpanded$delegate);
                        return ExpandableInfoRow$lambda$3$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier, canExpand2, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 14, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = ((432 >> 6) & 112) | 6;
            RowScope $this$ExpandableInfoRow_u24lambda_u243_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1187132021, "C299@10856L10,296@10762L299,306@11075L40,308@11129L1324:AdDetailScreen.kt#rz1uci");
            $composer2 = $composer4;
            TextKt.Text-Nvy7gAk(label, (Modifier) null, ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), 0L, TextUnitKt.getSp(14), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer4, ($dirty2 & 14) | 384, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer4, 6);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$ExpandableInfoRow_u24lambda_u243_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i9 = ((432 >> 6) & 112) | 6;
            RowScope $this$ExpandableInfoRow_u24lambda_u243_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1841331673, "C317@11462L10,314@11356L603:AdDetailScreen.kt#rz1uci");
            TextKt.Text-Nvy7gAk(value, $this$ExpandableInfoRow_u24lambda_u243_u241_u240.weight(Modifier.Companion, 1.0f, false), ColorKt.Color(4284773515L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getBodyMedium(), 0L, TextUnitKt.getSp(14), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (Intrinsics.areEqual(label, "adcb") || Intrinsics.areEqual(label, "track_id")) ? (SystemFontFamily) FontFamily.Companion.getMonospace() : FontFamily.Companion.getDefault(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer4, (($dirty2 >> 3) & 14) | 384, 24960, 109560);
            if (canExpand2) {
                $composer4.startReplaceGroup(-1840697414);
                ComposerKt.sourceInformation($composer4, "330@12038L39,331@12098L323");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer4, 6);
                IconKt.Icon-ww6aTOc(ExpandableInfoRow$lambda$1(isExpanded$delegate) ? AppIcons.INSTANCE.getKeyboardArrowUp() : AppIcons.INSTANCE.getKeyboardArrowDown(), ExpandableInfoRow$lambda$1(isExpanded$delegate) ? "收起" : "展开", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), ColorKt.Color(4287931320L), $composer4, 3456, 0);
            } else {
                $composer4.startReplaceGroup(-1852631391);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ExpandableInfoRow$lambda$1(isExpanded$delegate)) {
                expandedContent3 = expandedContent4;
                if (expandedContent3 != null) {
                    $composer3 = $composer4;
                    $composer3.startReplaceGroup(1285323993);
                    ComposerKt.sourceInformation($composer3, "349@12755L168,343@12547L376");
                    SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(0), 0.0f, 0.0f, 13, (Object) null), (Shape) null, ColorKt.Color(4294047225L), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1993351057, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ExpandableInfoRow$lambda$3$2;
                            ExpandableInfoRow$lambda$3$2 = AdDetailScreenKt.ExpandableInfoRow$lambda$3$2(expandedContent3, (Composer) obj, ((Integer) obj2).intValue());
                            return ExpandableInfoRow$lambda$3$2;
                        }
                    }, $composer3, 54), $composer3, 12583302, 122);
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    expandedContent = expandedContent3;
                } else {
                    $composer3 = $composer4;
                }
            } else {
                expandedContent3 = expandedContent4;
                $composer3 = $composer4;
            }
            $composer3.startReplaceGroup(1272877865);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
            expandedContent = expandedContent3;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            canExpand2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = canExpand2;
            final Function2 function22 = expandedContent;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ExpandableInfoRow$lambda$4;
                    ExpandableInfoRow$lambda$4 = AdDetailScreenKt.ExpandableInfoRow$lambda$4(label, value, z2, function22, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ExpandableInfoRow$lambda$4;
                }
            });
        }
    }

    private static final boolean ExpandableInfoRow$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ExpandableInfoRow$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandableInfoRow$lambda$3$0$0(MutableState $isExpanded$delegate) {
        ExpandableInfoRow$lambda$2($isExpanded$delegate, !ExpandableInfoRow$lambda$1($isExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExpandableInfoRow$lambda$3$2(Function2 $expandedContent, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C350@12773L136:AdDetailScreen.kt#rz1uci");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1993351057, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ExpandableInfoRow.<anonymous>.<anonymous> (AdDetailScreen.kt:350)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1776568969, "C353@12874L17:AdDetailScreen.kt#rz1uci");
            $expandedContent.invoke($composer, 0);
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

    private static final void JsonContent(JsonElement json, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Iterable $this$forEachIndexed$iv;
        boolean z;
        Iterator it;
        int index$iv;
        String str;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer4;
        String str2;
        Composer $composer$iv3;
        String str3;
        String str4;
        Composer $composer$iv4;
        String str5;
        Composer $composer$iv$iv$iv2;
        boolean z2;
        MeasurePolicy measurePolicy$iv$iv;
        Composer $composer$iv$iv2;
        Composer $composer5;
        Function0 factory$iv$iv$iv4;
        Composer $composer6;
        Function0 factory$iv$iv$iv5;
        Composer $composer$iv5;
        final JsonElement jsonElement = json;
        Composer $composer7 = $composer.startRestartGroup(-1819526039);
        ComposerKt.sourceInformation($composer7, "C(JsonContent)N(json)362@13004L5029:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer7.changedInstance(jsonElement) ? 4 : 2;
        }
        if (!$composer7.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer7;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1819526039, $dirty, -1, "kntr.app.ad.ui.inspector.ui.main.ad.JsonContent (AdDetailScreen.kt:361)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            Composer $composer$iv6 = $composer7;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv6, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv;
            Composer $composer$iv$iv3 = $composer$iv6;
            String str6 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            String str7 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            Composer $composer$iv$iv$iv3 = $composer$iv$iv3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv3.startReusableNode();
            if ($composer$iv$iv$iv3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv$iv$iv3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv$iv$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv7 = $composer$iv$iv$iv3;
            boolean z3 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            Composer $composer8 = $composer$iv7;
            ComposerKt.sourceInformationMarkerStart($composer8, 1736652631, "C:AdDetailScreen.kt#rz1uci");
            boolean z4 = jsonElement instanceof JsonObject;
            String str8 = "C101@5233L9:Row.kt#2w3rfo";
            String str9 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
            String str10 = RoomRecommendViewModel.EMPTY_CURSOR;
            if (z4) {
                $composer8.startReplaceGroup(1736608703);
                ComposerKt.sourceInformation($composer8, RoomRecommendViewModel.EMPTY_CURSOR);
                Iterable $this$forEach$iv = ((JsonObject) jsonElement).entrySet();
                boolean z5 = false;
                for (Object element$iv : $this$forEach$iv) {
                    Map.Entry entry = (Map.Entry) element$iv;
                    String key = (String) entry.getKey();
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    JsonPrimitive jsonPrimitive = (JsonElement) entry.getValue();
                    boolean z6 = z5;
                    if (jsonPrimitive instanceof JsonNull) {
                        $composer4 = $composer7;
                        str2 = str8;
                        $composer$iv3 = $composer$iv6;
                        str3 = str9;
                        str4 = str6;
                        $composer$iv4 = $composer$iv7;
                        str5 = str7;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        z2 = z3;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        $composer$iv$iv2 = $composer$iv$iv3;
                        $composer5 = $composer8;
                        $composer5.startReplaceGroup(-1521629520);
                        $composer5.endReplaceGroup();
                    } else {
                        $composer8.startReplaceGroup(-1508441903);
                        ComposerKt.sourceInformation($composer8, "369@13256L1967");
                        z2 = z3;
                        measurePolicy$iv$iv = measurePolicy$iv$iv2;
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                        Composer $composer$iv8 = $composer8;
                        $composer4 = $composer7;
                        $composer$iv3 = $composer$iv6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv8, 844473419, str9);
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv8, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv2 = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv8, -1159599143, str6);
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv8, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer$iv8.getCurrentCompositionLocalMap();
                        $composer$iv$iv2 = $composer$iv$iv3;
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv8, modifier$iv2);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        $composer$iv4 = $composer$iv7;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv8, -553112988, str7);
                        if (!($composer$iv8.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv8.startReusableNode();
                        if ($composer$iv8.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer$iv8.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer$iv8.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv8);
                        str3 = str9;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv8, 1456264949, str8);
                        int i4 = ((438 >> 6) & 112) | 6;
                        RowScope $this$JsonContent_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer$iv8, -1703676281, "C377@13662L10,374@13522L490:AdDetailScreen.kt#rz1uci");
                        TextKt.Text-Nvy7gAk(key, RowScope.-CC.weight$default($this$JsonContent_u24lambda_u240_u240_u240, Modifier.Companion, 0.4f, false, 2, (Object) null), ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv8, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(13), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer$iv8, 384, 0, 131064);
                        if (jsonPrimitive instanceof JsonPrimitive) {
                            $composer$iv8.startReplaceGroup(-1703087468);
                            ComposerKt.sourceInformation($composer$iv8, "390@14348L10,387@14147L669");
                            TextKt.Text-Nvy7gAk(StringsKt.removeSurrounding(jsonPrimitive.toString(), "\""), RowScope.-CC.weight$default($this$JsonContent_u24lambda_u240_u240_u240, Modifier.Companion, 0.6f, false, 2, (Object) null), ColorKt.Color(4284773515L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv8, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer$iv8, 384, 0, 130040);
                            $composer$iv8.endReplaceGroup();
                            $composer$iv5 = $composer$iv8;
                            str2 = str8;
                            $composer6 = $composer8;
                            str4 = str6;
                            str5 = str7;
                        } else if ((jsonPrimitive instanceof JsonObject) || (jsonPrimitive instanceof JsonArray)) {
                            $composer$iv8.startReplaceGroup(-1702339903);
                            ComposerKt.sourceInformation($composer$iv8, "401@14953L136");
                            Modifier modifier$iv3 = RowScope.-CC.weight$default($this$JsonContent_u24lambda_u240_u240_u240, Modifier.Companion, 0.6f, false, 2, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv3 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, -1159599143, str6);
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv8, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer$iv8.getCurrentCompositionLocalMap();
                            str2 = str8;
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv8, modifier$iv3);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            str4 = str6;
                            $composer6 = $composer8;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, -553112988, str7);
                            if (!($composer$iv8.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv8.startReusableNode();
                            if ($composer$iv8.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv8;
                                $composer$iv8.createNode(factory$iv$iv$iv5);
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv8;
                                $composer$iv8.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv8);
                            str5 = str7;
                            $composer$iv5 = $composer$iv8;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv8, 58529049, "C402@15033L18:AdDetailScreen.kt#rz1uci");
                            JsonContent(jsonPrimitive, $composer$iv8, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            $composer$iv8.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                            $composer$iv8.endReplaceGroup();
                        } else {
                            $composer$iv8.startReplaceGroup(-1702098289);
                            $composer$iv8.endReplaceGroup();
                            $composer$iv5 = $composer$iv8;
                            str2 = str8;
                            $composer6 = $composer8;
                            str4 = str6;
                            str5 = str7;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                        $composer$iv8.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv8);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer6.endReplaceGroup();
                        $composer5 = $composer6;
                    }
                    $composer8 = $composer5;
                    z5 = z6;
                    $this$forEach$iv = $this$forEach$iv2;
                    str8 = str2;
                    str6 = str4;
                    str7 = str5;
                    z3 = z2;
                    measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    $composer7 = $composer4;
                    $composer$iv6 = $composer$iv3;
                    $composer$iv$iv3 = $composer$iv$iv2;
                    $composer$iv$iv$iv3 = $composer$iv$iv$iv2;
                    $composer$iv7 = $composer$iv4;
                    str9 = str3;
                }
                $composer2 = $composer7;
                $composer3 = $composer8;
                $composer$iv = $composer$iv6;
                $composer$iv2 = $composer$iv7;
                $composer$iv$iv$iv = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv$iv3;
                $composer3.endReplaceGroup();
                jsonElement = json;
            } else {
                $composer2 = $composer7;
                $composer3 = $composer8;
                $composer$iv = $composer$iv6;
                String str11 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv2 = $composer$iv7;
                String str12 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv = $composer$iv$iv$iv3;
                $composer$iv$iv = $composer$iv$iv3;
                jsonElement = json;
                if (jsonElement instanceof JsonArray) {
                    $composer3.startReplaceGroup(1738785957);
                    ComposerKt.sourceInformation($composer3, RoomRecommendViewModel.EMPTY_CURSOR);
                    Iterable $this$forEachIndexed$iv2 = (Iterable) jsonElement;
                    boolean z7 = false;
                    int index$iv2 = 0;
                    Iterator it2 = $this$forEachIndexed$iv2.iterator();
                    while (it2.hasNext()) {
                        Object item$iv = it2.next();
                        int index$iv3 = index$iv2 + 1;
                        if (index$iv2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        JsonPrimitive jsonPrimitive2 = (JsonElement) item$iv;
                        if (jsonPrimitive2 instanceof JsonNull) {
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            z = z7;
                            it = it2;
                            index$iv = index$iv3;
                            str = str10;
                            $composer3.startReplaceGroup(-527056753);
                        } else {
                            $composer3.startReplaceGroup(-511664695);
                            ComposerKt.sourceInformation($composer3, str10);
                            if (jsonPrimitive2 instanceof JsonPrimitive) {
                                $composer3.startReplaceGroup(-511627867);
                                ComposerKt.sourceInformation($composer3, "418@15536L1546");
                                Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv4 = (54 << 3) & 112;
                                z = z7;
                                it = it2;
                                String str13 = str11;
                                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str13);
                                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                                CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                                index$iv = index$iv3;
                                str = str10;
                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                String str14 = str12;
                                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str14);
                                if (!($composer3.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer3.startReusableNode();
                                if ($composer3.getInserting()) {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv9;
                                    $composer3.createNode(factory$iv$iv$iv3);
                                } else {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv9;
                                    $composer3.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                int i8 = ((54 >> 6) & 112) | 6;
                                RowScope $this$JsonContent_u24lambda_u240_u241_u240 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer3, 1760037162, "C425@15942L10,422@15771L569,435@16580L10,432@16377L671:AdDetailScreen.kt#rz1uci");
                                TextKt.Text-Nvy7gAk("[" + index$iv2 + "]", RowScope.-CC.weight$default($this$JsonContent_u24lambda_u240_u241_u240, Modifier.Companion, 0.4f, false, 2, (Object) null), ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(13), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer3, 384, 0, 131064);
                                TextKt.Text-Nvy7gAk(StringsKt.removeSurrounding(jsonPrimitive2.toString(), "\""), RowScope.-CC.weight$default($this$JsonContent_u24lambda_u240_u241_u240, Modifier.Companion, 0.6f, false, 2, (Object) null), ColorKt.Color(4284773515L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer3, 384, 0, 130040);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                $composer3.endReplaceGroup();
                                str11 = str13;
                                str12 = str14;
                            } else {
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                z = z7;
                                it = it2;
                                index$iv = index$iv3;
                                str = str10;
                                String str15 = str11;
                                String str16 = str12;
                                if ((jsonPrimitive2 instanceof JsonObject) || (jsonPrimitive2 instanceof JsonArray)) {
                                    $composer3.startReplaceGroup(-509998445);
                                    ComposerKt.sourceInformation($composer3, "450@17366L10,447@17207L463,456@17703L140");
                                    TextKt.Text-Nvy7gAk("[" + index$iv2 + "]", (Modifier) null, ColorKt.Color(4281549141L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(13), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer3, 384, 0, 131066);
                                    Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                                    MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                                    int $changed$iv$iv5 = (6 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str15);
                                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                                    str11 = str15;
                                    CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str16);
                                    if (!($composer3.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer3.startReusableNode();
                                    if ($composer3.getInserting()) {
                                        factory$iv$iv$iv2 = factory$iv$iv$iv10;
                                        $composer3.createNode(factory$iv$iv$iv2);
                                    } else {
                                        factory$iv$iv$iv2 = factory$iv$iv$iv10;
                                        $composer3.useNode();
                                    }
                                    str12 = str16;
                                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                                    int i10 = ((6 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer3, -1455443970, "C457@17789L20:AdDetailScreen.kt#rz1uci");
                                    JsonContent(jsonPrimitive2, $composer3, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    $composer3.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    $composer3.endReplaceGroup();
                                } else {
                                    $composer3.startReplaceGroup(-509287987);
                                    $composer3.endReplaceGroup();
                                    str11 = str15;
                                    str12 = str16;
                                }
                            }
                        }
                        $composer3.endReplaceGroup();
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                        z7 = z;
                        it2 = it;
                        index$iv2 = index$iv;
                        str10 = str;
                    }
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1741389089);
                    $composer3.endReplaceGroup();
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit JsonContent$lambda$1;
                    JsonContent$lambda$1 = AdDetailScreenKt.JsonContent$lambda$1(jsonElement, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return JsonContent$lambda$1;
                }
            });
        }
    }

    private static final void ModernAdDetailCard(final InspectorInfo adInfo, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-55451288);
        ComposerKt.sourceInformation($composer3, "C(ModernAdDetailCard)N(adInfo)482@18342L5570,474@18109L5803:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(adInfo) : $composer3.changedInstance(adInfo) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-55451288, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdDetailCard (AdDetailScreen.kt:473)");
            }
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(575758061, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdDetailCard$lambda$0;
                    ModernAdDetailCard$lambda$0 = AdDetailScreenKt.ModernAdDetailCard$lambda$0(InspectorInfo.this, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdDetailCard$lambda$0;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdDetailCard$lambda$1;
                    ModernAdDetailCard$lambda$1 = AdDetailScreenKt.ModernAdDetailCard$lambda$1(InspectorInfo.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdDetailCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0719, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit ModernAdDetailCard$lambda$0(final InspectorInfo $adInfo, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        final MutableState isExpanded$delegate;
        Composer $composer2;
        Object obj;
        ComposerKt.sourceInformation($composer, "C483@18352L5554:AdDetailScreen.kt#rz1uci");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(575758061, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdDetailCard.<anonymous> (AdDetailScreen.kt:483)");
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
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1446949507, "C487@18471L34,489@18519L3261,574@21794L136:AdDetailScreen.kt#rz1uci");
            ComposerKt.sourceInformationMarkerStart($composer, 646056037, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object value$iv = $composer.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
            }
            MutableState isExpanded$delegate2 = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = spaceBetween;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -516582304, "C498@18858L767,519@19668L2098:AdDetailScreen.kt#rz1uci");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
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
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -945001924, "C504@19132L7,501@18971L254,507@19246L39,511@19425L10,508@19306L301:AdDetailScreen.kt#rz1uci");
            ImageVector dataObject = AppIcons.INSTANCE.getDataObject();
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconKt.Icon-ww6aTOc(dataObject, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), ((UserRole) consume).m353getColor0d7_KjU(), $composer, 438, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            TextKt.Text-Nvy7gAk("广告数据", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), 0L, TextUnitKt.getSp(15), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 390, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
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
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -465176905, "C521@19736L34,524@19857L170,524@19834L193,532@20103L42,545@20602L131,550@20814L345,544@20556L603,558@21181L29,562@21309L28,564@21418L330,561@21263L485:AdDetailScreen.kt#rz1uci");
            ComposerKt.sourceInformationMarkerStart($composer, -1400480572, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object value$iv2 = $composer.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
            }
            final MutableState copied$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Boolean valueOf = Boolean.valueOf(ModernAdDetailCard$lambda$0$0$3$1$1(copied$delegate));
            ComposerKt.sourceInformationMarkerStart($composer, -1400476564, "CC(remember):AdDetailScreen.kt#9igjgp");
            AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1 value$iv3 = $composer.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = new AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$1$1(copied$delegate, null);
                $composer.updateRememberedValue(value$iv3);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv3, $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -1400468820, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object value$iv4 = $composer.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
            }
            final MutableState jsonToCopy$delegate = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ModernAdDetailCard$lambda$0$0$3$1$5(jsonToCopy$delegate) != null) {
                $composer.startReplaceGroup(-464698483);
                ComposerKt.sourceInformation($composer, "536@20285L23,538@20397L115,538@20370L142");
                String ModernAdDetailCard$lambda$0$0$3$1$5 = ModernAdDetailCard$lambda$0$0$3$1$5(jsonToCopy$delegate);
                Intrinsics.checkNotNull(ModernAdDetailCard$lambda$0$0$3$1$5);
                ShareText_androidKt.ShareText(ModernAdDetailCard$lambda$0$0$3$1$5, $composer, 0);
                String ModernAdDetailCard$lambda$0$0$3$1$52 = ModernAdDetailCard$lambda$0$0$3$1$5(jsonToCopy$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, -1400459339, "CC(remember):AdDetailScreen.kt#9igjgp");
                AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$2$1 value$iv5 = $composer.rememberedValue();
                if (value$iv5 == Composer.Companion.getEmpty()) {
                    value$iv5 = new AdDetailScreenKt$ModernAdDetailCard$1$1$1$2$2$1(copied$delegate, jsonToCopy$delegate, null);
                    $composer.updateRememberedValue(value$iv5);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(ModernAdDetailCard$lambda$0$0$3$1$52, (Function2) value$iv5, $composer, 0);
            } else {
                $composer.startReplaceGroup(-484804928);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer, -1400452763, "CC(remember):AdDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($adInfo);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda12
                public final Object invoke() {
                    Unit ModernAdDetailCard$lambda$0$0$3$1$8$0;
                    ModernAdDetailCard$lambda$0$0$3$1$8$0 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$8$0(InspectorInfo.this, jsonToCopy$delegate);
                    return ModernAdDetailCard$lambda$0$0$3$1$8$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) it$iv, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-792926272, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ModernAdDetailCard$lambda$0$0$3$1$9;
                    ModernAdDetailCard$lambda$0$0$3$1$9 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$9(copied$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                    return ModernAdDetailCard$lambda$0$0$3$1$9;
                }
            }, $composer, 54), $composer, 1572912, 60);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer, 6);
            ComposerKt.sourceInformationMarkerStart($composer, -1400430242, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                isExpanded$delegate = isExpanded$delegate2;
                Object value$iv7 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit ModernAdDetailCard$lambda$0$0$3$1$10$0;
                        ModernAdDetailCard$lambda$0$0$3$1$10$0 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$10$0(isExpanded$delegate);
                        return ModernAdDetailCard$lambda$0$0$3$1$10$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv2 = value$iv7;
            } else {
                isExpanded$delegate = isExpanded$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) it$iv2, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1097689143, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj2, Object obj3) {
                    Unit ModernAdDetailCard$lambda$0$0$3$1$11;
                    ModernAdDetailCard$lambda$0$0$3$1$11 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$3$1$11(isExpanded$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                    return ModernAdDetailCard$lambda$0$0$3$1$11;
                }
            }, $composer, 54), $composer, 1572918, 60);
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
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), 0.0f, ColorKt.Color(4293257195L), $composer, 390, 2);
            if (ModernAdDetailCard$lambda$0$0$1(isExpanded$delegate)) {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-1443585977);
                ComposerKt.sourceInformation($composer2, "583@22073L349");
                String raw = $adInfo.getAdData().getRaw();
                ComposerKt.sourceInformationMarkerStart($composer2, 646171616, "CC(remember):AdDetailScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changed(raw);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    try {
                        Json.Default r0 = Json.Default;
                        String raw2 = $adInfo.getAdData().getRaw();
                        if (raw2 == null) {
                            raw2 = RoomRecommendViewModel.EMPTY_CURSOR;
                        }
                        JsonElement element = r0.parseToJsonElement(raw2);
                        Result.Companion companion = Result.Companion;
                        obj = Result.constructor-impl(element);
                    } catch (Exception e) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(e));
                    }
                    Object value$iv8 = Result.box-impl(obj);
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv3 = value$iv8;
                }
                Object jsonParseResult = ((Result) it$iv3).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (Result.isSuccess-impl(jsonParseResult)) {
                    $composer2.startReplaceGroup(-1443128386);
                    ComposerKt.sourceInformation($composer2, "594@22527L55");
                    Object obj2 = Result.isFailure-impl(jsonParseResult) ? null : jsonParseResult;
                    Intrinsics.checkNotNull(obj2);
                    JsonDisplayKt.ModernJsonElementDisplay((JsonElement) obj2, null, 0, $composer2, 0, 6);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1442935411);
                    ComposerKt.sourceInformation($composer2, "600@22781L10,597@22658L370");
                    TextKt.Text-Nvy7gAk("无法解析广告数据", (Modifier) null, ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer2, 390, 0, 131066);
                    $composer2.endReplaceGroup();
                }
                $composer2.endReplaceGroup();
            } else {
                $composer2 = $composer;
                $composer2.startReplaceGroup(-1442469760);
                ComposerKt.sourceInformation($composer2, "613@23299L583,609@23115L767");
                SurfaceKt.Surface-T9BRK9s(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)), ColorKt.Color(4294572795L), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1561934686, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj3, Object obj4) {
                        Unit ModernAdDetailCard$lambda$0$0$5;
                        ModernAdDetailCard$lambda$0$0$5 = AdDetailScreenKt.ModernAdDetailCard$lambda$0$0$5(InspectorInfo.this, (Composer) obj3, ((Integer) obj4).intValue());
                        return ModernAdDetailCard$lambda$0$0$5;
                    }
                }, $composer2, 54), $composer2, 12583302, 120);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
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

    private static final boolean ModernAdDetailCard$lambda$0$0$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void ModernAdDetailCard$lambda$0$0$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ModernAdDetailCard$lambda$0$0$3$1$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ModernAdDetailCard$lambda$0$0$3$1$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final String ModernAdDetailCard$lambda$0$0$3$1$5(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$0$0$3$1$8$0(InspectorInfo $adInfo, MutableState $jsonToCopy$delegate) {
        $jsonToCopy$delegate.setValue($adInfo.getAdData().getRaw());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$0$0$3$1$9(MutableState $copied$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C551@20840L297:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-792926272, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdDetailCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:551)");
            }
            IconKt.Icon-ww6aTOc(ModernAdDetailCard$lambda$0$0$3$1$1($copied$delegate) ? AppIcons.INSTANCE.getInfo() : AppIcons.INSTANCE.getContentCopy(), ModernAdDetailCard$lambda$0$0$3$1$1($copied$delegate) ? "已复制" : "复制广告数据", (Modifier) null, ColorKt.Color(ModernAdDetailCard$lambda$0$0$3$1$1($copied$delegate) ? 4279286145L : 4285231744L), $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$0$0$3$1$10$0(MutableState $isExpanded$delegate) {
        ModernAdDetailCard$lambda$0$0$2($isExpanded$delegate, !ModernAdDetailCard$lambda$0$0$1($isExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$0$0$3$1$11(MutableState $isExpanded$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C565@21444L282:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1097689143, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdDetailCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:565)");
            }
            IconKt.Icon-ww6aTOc(ModernAdDetailCard$lambda$0$0$1($isExpanded$delegate) ? AppIcons.INSTANCE.getKeyboardArrowUp() : AppIcons.INSTANCE.getKeyboardArrowDown(), ModernAdDetailCard$lambda$0$0$1($isExpanded$delegate) ? "收起" : "展开", (Modifier) null, ColorKt.Color(4285231744L), $composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ModernAdDetailCard$lambda$0$0$5(InspectorInfo $adInfo, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C617@23461L10,614@23321L543:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1561934686, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdDetailCard.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:614)");
            }
            String raw = $adInfo.getAdData().getRaw();
            if (raw == null) {
                raw = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            TextKt.Text-Nvy7gAk(raw, PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), ColorKt.Color(4285231744L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 3, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodySmall(), 0L, TextUnitKt.getSp(12), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, FontFamily.Companion.getMonospace(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777181, (Object) null), $composer, 432, 24960, 110584);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void ModernAdReportCard(final InspectorInfo adInfo, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(421595991);
        ComposerKt.sourceInformation($composer3, "C(ModernAdReportCard)N(adInfo,onReportClick)637@24042L32,639@24179L20,650@24484L5441,642@24252L5673:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(adInfo) : $composer3.changedInstance(adInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(421595991, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.ModernAdReportCard (AdDetailScreen.kt:636)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1426824951, "CC(remember):AdDetailScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new AdDetailViewModel();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AdDetailViewModel viewModel = (AdDetailViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            State latestReportState = SnapshotStateKt.collectAsState(viewModel.getLatestReportForAdFlow(adInfo.getId()), (Object) null, (CoroutineContext) null, $composer3, 48, 2);
            final ReportJobData latestReport = (ReportJobData) latestReportState.getValue();
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(169420444, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdReportCard$lambda$1;
                    ModernAdReportCard$lambda$1 = AdDetailScreenKt.ModernAdReportCard$lambda$1(ReportJobData.this, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdReportCard$lambda$1;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit ModernAdReportCard$lambda$2;
                    ModernAdReportCard$lambda$2 = AdDetailScreenKt.ModernAdReportCard$lambda$2(InspectorInfo.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ModernAdReportCard$lambda$2;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -93
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit ModernAdReportCard$lambda$1(kntr.app.ad.domain.inspector.core.work.ReportJobData r163, kotlin.jvm.functions.Function0 r164, androidx.compose.runtime.Composer r165, int r166) {
        /*
            Method dump skipped, instructions count: 3448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt.ModernAdReportCard$lambda$1(kntr.app.ad.domain.inspector.core.work.ReportJobData, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    private static final void TimelineView(final List<? extends IStage> list, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(873799148);
        ComposerKt.sourceInformation($composer3, "C(TimelineView)N(stages)800@30227L9341,792@29994L9574:AdDetailScreen.kt#rz1uci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(873799148, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.main.ad.TimelineView (AdDetailScreen.kt:791)");
            }
            $composer2 = $composer3;
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(16), 7, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(1), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-282269945, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimelineView$lambda$0;
                    TimelineView$lambda$0 = AdDetailScreenKt.TimelineView$lambda$0(list, (Composer) obj, ((Integer) obj2).intValue());
                    return TimelineView$lambda$0;
                }
            }, $composer3, 54), $composer3, 12779910, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit TimelineView$lambda$1;
                    TimelineView$lambda$1 = AdDetailScreenKt.TimelineView$lambda$1(list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TimelineView$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -108
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.Unit TimelineView$lambda$0(java.util.List r214, androidx.compose.runtime.Composer r215, int r216) {
        /*
            Method dump skipped, instructions count: 3901
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt.TimelineView$lambda$0(java.util.List, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimelineView$lambda$0$0$1$0$0$1$1$0$0(long $jobStatusColor, IJobData $jobData, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C952@37152L2176:AdDetailScreen.kt#rz1uci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-690395754, $changed, -1, "kntr.app.ad.ui.inspector.ui.main.ad.TimelineView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdDetailScreen.kt:952)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
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
            RowScope $this$TimelineView_u24lambda_u240_u240_u241_u240_u240_u241_u241_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -385195725, "C960@37684L356,967@38090L40,975@38634L10,972@38406L605:AdDetailScreen.kt#rz1uci");
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $jobStatusColor, RoundedCornerShapeKt.getCircleShape()), $composer, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            String text = $jobData instanceof PrintJobData ? ((PrintJobData) $jobData).getMsg() : $jobData.getName();
            TextKt.Text-Nvy7gAk(StringsKt.trim(StringsKt.substringAfter$default(text, ":", (String) null, 2, (Object) null)).toString(), RowScope.-CC.weight$default($this$TimelineView_u24lambda_u240_u240_u241_u240_u240_u241_u241_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), ColorKt.Color(4281811281L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), 0L, TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777213, (Object) null), $composer, 384, 0, 131064);
            if (!($jobData instanceof PrintJobData)) {
                $composer.startReplaceGroup(-383843599);
                ComposerKt.sourceInformation($composer, "984@39205L27");
                StatusBadgeKt.StatusBadge($jobData.getStatus(), $composer, 0);
            } else {
                $composer.startReplaceGroup(-422628784);
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
}