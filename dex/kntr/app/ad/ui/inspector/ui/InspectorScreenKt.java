package kntr.app.ad.ui.inspector.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.interaction.InteractionSourceKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.pager.PageSize;
import androidx.compose.foundation.pager.PagerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
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
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
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
import androidx.compose.ui.window.DialogProperties;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.domain.inspector.core.StateManager;
import kntr.app.ad.domain.inspector.core.work.ReportJobData;
import kntr.app.ad.ui.inspector.core.util.BackHandler_androidKt;
import kntr.app.ad.ui.inspector.core.util.EnterExitTransitionKt;
import kntr.app.ad.ui.inspector.core.util.OrientationDetector_androidKt;
import kntr.app.ad.ui.inspector.core.util.SystemStatusBarColor_androidKt;
import kntr.app.ad.ui.inspector.model.TabInfo;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.components.AppIcons;
import kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt;
import kntr.app.ad.ui.inspector.ui.components.EmptyViewKt;
import kntr.app.ad.ui.inspector.ui.components.ReportListKt;
import kntr.app.ad.ui.inspector.ui.main.FeedbackScreenKt;
import kntr.app.ad.ui.inspector.ui.main.ad.AdDetailScreenKt;
import kntr.app.ad.ui.inspector.ui.main.ad.AdListScreenKt;
import kntr.app.ad.ui.inspector.ui.main.console.ConsoleListScreenKt;
import kntr.app.ad.ui.inspector.ui.main.report.ReportDetailScreenKt;
import kntr.app.ad.ui.inspector.ui.main.report.ReportListScreenKt;
import kntr.app.ad.ui.inspector.ui.main.request.RequestDetailScreenKt;
import kntr.app.ad.ui.inspector.ui.main.request.RequestListScreenKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: InspectorScreen.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\n\u001a\u0091\u0001\u0010\u000b\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0017\u001a[\u0010\u0018\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00122\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0019\u001aG\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u001fH\u0003¢\u0006\u0004\b$\u0010%\u001a\u0091\u0001\u0010&\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00122\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u0017\u001a1\u0010'\u001a\u00020\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010(\u001a\u00020)H\u0003¢\u0006\u0002\u0010*\u001a7\u0010+\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H\u0003¢\u0006\u0002\u0010,¨\u0006-²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002²\u0006\f\u0010.\u001a\u0004\u0018\u00010\u0005X\u008a\u008e\u0002²\u0006\f\u0010/\u001a\u0004\u0018\u00010\u0005X\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u00010\u0005X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u001fX\u008a\u008e\u0002"}, d2 = {"InspectorScreen", RoomRecommendViewModel.EMPTY_CURSOR, "userRole", "Lkntr/app/ad/ui/inspector/model/UserRole;", "selectedAd", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "onBack", "Lkotlin/Function0;", "(Lkntr/app/ad/ui/inspector/model/UserRole;Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LandscapeMainContent", "visibleTabs", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/ui/inspector/model/TabInfo;", "selectedTabIndex", RoomRecommendViewModel.EMPTY_CURSOR, "onTabSelect", "Lkotlin/Function1;", "onAdClick", "onRequestClick", "onReportClick", "onShowSettings", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SidebarNavigation", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkntr/app/ad/ui/inspector/model/UserRole;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SidebarItem", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "selected", RoomRecommendViewModel.EMPTY_CURSOR, "onClick", "themeColor", "Landroidx/compose/ui/graphics/Color;", "smallIcon", "SidebarItem-FHprtrg", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;JZLandroidx/compose/runtime/Composer;II)V", "SimplisticMainContent", "MinimalisticTopBar", "scrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TopAppBarScrollBehavior;Landroidx/compose/runtime/Composer;I)V", "MinimalistTabStrip", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ad-inspector_debug", "selectedAdId", "selectedRequestId", "selectedReportId", "showSettings", "showFeedback", "showReportList", "showClearCacheDialog"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InspectorScreenKt {

    /* compiled from: InspectorScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UserRole.values().length];
            try {
                iArr[UserRole.DEVELOPER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UserRole.TESTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UserRole.OPERATOR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UserRole.PRODUCT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$2(UserRole userRole, String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        InspectorScreen(userRole, str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LandscapeMainContent$lambda$2(List list, int i, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, Function0 function02, int i2, int i3, Composer composer, int i4) {
        LandscapeMainContent(list, i, function1, function0, function12, function13, function14, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MinimalistTabStrip$lambda$1(List list, int i, Function1 function1, int i2, Composer composer, int i3) {
        MinimalistTabStrip(list, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MinimalisticTopBar$lambda$8(Function0 function0, Function0 function02, TopAppBarScrollBehavior topAppBarScrollBehavior, int i, Composer composer, int i2) {
        MinimalisticTopBar(function0, function02, topAppBarScrollBehavior, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SidebarItem_FHprtrg$lambda$1(ImageVector imageVector, String str, boolean z, Function0 function0, long j2, boolean z2, int i, int i2, Composer composer, int i3) {
        m388SidebarItemFHprtrg(imageVector, str, z, function0, j2, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SidebarNavigation$lambda$7(List list, int i, Function1 function1, UserRole userRole, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        SidebarNavigation(list, i, function1, userRole, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimplisticMainContent$lambda$6(List list, int i, Function1 function1, Function0 function0, Function1 function12, Function1 function13, Function1 function14, Function0 function02, int i2, int i3, Composer composer, int i4) {
        SimplisticMainContent(list, i, function1, function0, function12, function13, function14, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v8 */
    public static final void InspectorScreen(final UserRole userRole, final String selectedAd, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Modifier modifier3;
        Function0 onBack;
        final Modifier modifier4;
        final Function0 onBack2;
        Intrinsics.checkNotNullParameter(userRole, "userRole");
        Composer $composer2 = $composer.startRestartGroup(-869050207);
        ComposerKt.sourceInformation($composer2, "C(InspectorScreen)N(userRole,selectedAd,modifier,onBack)86@4141L2,88@4211L8912,88@4153L8970:InspectorScreen.kt#37tpck");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(userRole.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selectedAd) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onBack = function02;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                onBack2 = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer2, -1933589341, "CC(remember):InspectorScreen.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onBack2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-869050207, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen (InspectorScreen.kt:87)");
            }
            CompositionLocalKt.CompositionLocalProvider(LocalUserRoleKt.getLocalUserRole().provides(userRole), ComposableLambdaKt.rememberComposableLambda(191552865, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit InspectorScreen$lambda$1;
                    InspectorScreen$lambda$1 = InspectorScreenKt.InspectorScreen$lambda$1(UserRole.this, modifier4, selectedAd, onBack2, (Composer) obj, ((Integer) obj2).intValue());
                    return InspectorScreen$lambda$1;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onBack = onBack2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onBack;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit InspectorScreen$lambda$2;
                    InspectorScreen$lambda$2 = InspectorScreenKt.InspectorScreen$lambda$2(UserRole.this, selectedAd, modifier5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InspectorScreen$lambda$2;
                }
            });
        }
    }

    private static final int InspectorScreen$lambda$1$1(MutableIntState $selectedTabIndex$delegate) {
        IntState $this$getValue$iv = (IntState) $selectedTabIndex$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String InspectorScreen$lambda$1$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String InspectorScreen$lambda$1$7(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String InspectorScreen$lambda$1$10(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0670  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x06c1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x06c4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit InspectorScreen$lambda$1(UserRole $userRole, Modifier $modifier, String $selectedAd, Function0 $onBack, Composer $composer, int $changed) {
        MutableIntState selectedTabIndex$delegate;
        MutableState showReportList$delegate;
        boolean isLandscape;
        Object listOf;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        final MutableIntState selectedTabIndex$delegate2;
        ComposerKt.sourceInformation($composer, "C90@4314L33,91@4376L39,92@4449L42,93@4524L42,94@4595L34,95@4658L34,96@4723L34,99@4803L21,103@4887L970,133@6105L405,133@6063L447,145@6541L33,147@6584L6533:InspectorScreen.kt#37tpck");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(191552865, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous> (InspectorScreen.kt:90)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -601287134, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MutableIntState selectedTabIndex$delegate3 = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601285144, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default($selectedAd, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            final MutableState selectedAdId$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601282805, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv4 = $composer.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableState selectedRequestId$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601280405, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
            }
            final MutableState selectedReportId$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601278141, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv6 = $composer.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(mutableStateOf$default);
                it$iv6 = mutableStateOf$default;
            }
            final MutableState showSettings$delegate = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601276125, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv7 = $composer.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(mutableStateOf$default2);
                it$iv7 = mutableStateOf$default2;
            }
            final MutableState showFeedback$delegate = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -601274045, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv8 = $composer.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv5);
                it$iv8 = value$iv5;
            }
            MutableState showReportList$delegate2 = (MutableState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            boolean isLandscape2 = OrientationDetector_androidKt.rememberIsLandscape($composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, -601267861, "CC(remember):InspectorScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed($userRole.ordinal());
            Object it$iv9 = $composer.rememberedValue();
            if (!invalid$iv && it$iv9 != Composer.Companion.getEmpty()) {
                selectedTabIndex$delegate = selectedTabIndex$delegate3;
                showReportList$delegate = showReportList$delegate2;
                isLandscape = isLandscape2;
                List visibleTabs = (List) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer);
                boolean isDetailPageActive = InspectorScreen$lambda$1$4(selectedAdId$delegate) == null || InspectorScreen$lambda$1$7(selectedRequestId$delegate) != null || InspectorScreen$lambda$1$10(selectedReportId$delegate) != null || InspectorScreen$lambda$1$13(showSettings$delegate) || InspectorScreen$lambda$1$16(showFeedback$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, -601229450, "CC(remember):InspectorScreen.kt#9igjgp");
                it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    final MutableState mutableState = showReportList$delegate;
                    Object value$iv6 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda49
                        public final Object invoke() {
                            Unit InspectorScreen$lambda$1$22$0;
                            InspectorScreen$lambda$1$22$0 = InspectorScreenKt.InspectorScreen$lambda$1$22$0(showFeedback$delegate, selectedReportId$delegate, mutableState, selectedAdId$delegate, selectedRequestId$delegate, showSettings$delegate);
                            return InspectorScreen$lambda$1$22$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                    it$iv = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                BackHandler_androidKt.BackHandler(isDetailPageActive, (Function0) it$iv, $composer, 48);
                SystemStatusBarColor_androidKt.m352SystemStatusBarColorek8zF_U(Color.Companion.getWhite-0d7_KjU(), $composer, 6);
                Modifier modifier$iv$iv = SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer.createNode(factory$iv$iv$iv);
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
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -987016166, "C178@7944L919,174@7769L1094,209@9057L458,205@8877L638,227@9698L1754,223@9529L1923,273@11645L452,269@11466L631,291@12278L304,287@12111L471,306@12763L344,302@12596L511:InspectorScreen.kt#37tpck");
                if (isLandscape) {
                    final MutableIntState selectedTabIndex$delegate4 = selectedTabIndex$delegate;
                    $composer.startReplaceGroup(-986662860);
                    ComposerKt.sourceInformation($composer, "164@7393L25,166@7489L21,167@7549L26,168@7613L25,169@7677L23,161@7232L487");
                    int InspectorScreen$lambda$1$1 = InspectorScreen$lambda$1$1(selectedTabIndex$delegate4);
                    ComposerKt.sourceInformationMarkerStart($composer, 245272064, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv7 = $composer.rememberedValue();
                    if (value$iv7 == Composer.Companion.getEmpty()) {
                        value$iv7 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda64
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$5$0;
                                InspectorScreen$lambda$1$23$5$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$5$0(selectedTabIndex$delegate4, ((Integer) obj).intValue());
                                return InspectorScreen$lambda$1$23$5$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv7);
                    }
                    Function1 function1 = (Function1) value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245275132, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv8 = $composer.rememberedValue();
                    if (value$iv8 == Composer.Companion.getEmpty()) {
                        value$iv8 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda66
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$6$0;
                                InspectorScreen$lambda$1$23$6$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$6$0(selectedAdId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$6$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv8);
                    }
                    Function1 function12 = (Function1) value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245277057, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object it$iv10 = $composer.rememberedValue();
                    if (it$iv10 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda67
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$7$0;
                                InspectorScreen$lambda$1$23$7$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$7$0(selectedRequestId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$7$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv9);
                        it$iv10 = value$iv9;
                    }
                    Function1 function13 = (Function1) it$iv10;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245279104, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object it$iv11 = $composer.rememberedValue();
                    if (it$iv11 == Composer.Companion.getEmpty()) {
                        Object value$iv10 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda50
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$8$0;
                                InspectorScreen$lambda$1$23$8$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$8$0(selectedReportId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$8$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv10);
                        it$iv11 = value$iv10;
                    }
                    Function1 function14 = (Function1) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245281150, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object it$iv12 = $composer.rememberedValue();
                    if (it$iv12 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda51
                            public final Object invoke() {
                                Unit InspectorScreen$lambda$1$23$9$0;
                                InspectorScreen$lambda$1$23$9$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$9$0(showSettings$delegate);
                                return InspectorScreen$lambda$1$23$9$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv11);
                        it$iv12 = value$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SimplisticMainContent(visibleTabs, InspectorScreen$lambda$1$1, function1, $onBack, function12, function13, function14, (Function0) it$iv12, $composer, 14377344, 0);
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-987182699);
                    ComposerKt.sourceInformation($composer, "153@6868L25,155@6964L21,156@7024L26,157@7088L25,158@7152L23,150@6708L486");
                    int InspectorScreen$lambda$1$12 = InspectorScreen$lambda$1$1(selectedTabIndex$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer, 245255264, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv12 = $composer.rememberedValue();
                    if (value$iv12 == Composer.Companion.getEmpty()) {
                        selectedTabIndex$delegate2 = selectedTabIndex$delegate;
                        value$iv12 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda59
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$0$0;
                                InspectorScreen$lambda$1$23$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$0$0(selectedTabIndex$delegate2, ((Integer) obj).intValue());
                                return InspectorScreen$lambda$1$23$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv12);
                    } else {
                        selectedTabIndex$delegate2 = selectedTabIndex$delegate;
                    }
                    Function1 function15 = (Function1) value$iv12;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245258332, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv13 = $composer.rememberedValue();
                    if (value$iv13 == Composer.Companion.getEmpty()) {
                        value$iv13 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda60
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$1$0;
                                InspectorScreen$lambda$1$23$1$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$1$0(selectedAdId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$1$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv13);
                    }
                    Function1 function16 = (Function1) value$iv13;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245260257, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv14 = $composer.rememberedValue();
                    if (value$iv14 == Composer.Companion.getEmpty()) {
                        value$iv14 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda61
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$2$0;
                                InspectorScreen$lambda$1$23$2$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$2$0(selectedRequestId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$2$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv14);
                    }
                    Function1 function17 = (Function1) value$iv14;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245262304, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object value$iv15 = $composer.rememberedValue();
                    if (value$iv15 == Composer.Companion.getEmpty()) {
                        value$iv15 = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda62
                            public final Object invoke(Object obj) {
                                Unit InspectorScreen$lambda$1$23$3$0;
                                InspectorScreen$lambda$1$23$3$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$3$0(selectedReportId$delegate, (String) obj);
                                return InspectorScreen$lambda$1$23$3$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv15);
                    }
                    Function1 function18 = (Function1) value$iv15;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 245264350, "CC(remember):InspectorScreen.kt#9igjgp");
                    Object it$iv13 = $composer.rememberedValue();
                    if (it$iv13 == Composer.Companion.getEmpty()) {
                        Object value$iv16 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda63
                            public final Object invoke() {
                                Unit InspectorScreen$lambda$1$23$4$0;
                                InspectorScreen$lambda$1$23$4$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$4$0(showSettings$delegate);
                                return InspectorScreen$lambda$1$23$4$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv16);
                        it$iv13 = value$iv16;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LandscapeMainContent(visibleTabs, InspectorScreen$lambda$1$12, function15, $onBack, function16, function17, function18, (Function0) it$iv13, $composer, 14377344, 0);
                    $composer.endReplaceGroup();
                }
                final MutableState showReportList$delegate3 = showReportList$delegate;
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$4(selectedAdId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-1792609729, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda52
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$10;
                        InspectorScreen$lambda$1$23$10 = InspectorScreenKt.InspectorScreen$lambda$1$23$10(selectedAdId$delegate, showFeedback$delegate, showReportList$delegate3, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$10;
                    }
                }, $composer, 54), $composer, 196608, 18);
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$7(selectedRequestId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(853371702, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda53
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$11;
                        InspectorScreen$lambda$1$23$11 = InspectorScreenKt.InspectorScreen$lambda$1$23$11(selectedRequestId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$11;
                    }
                }, $composer, 54), $composer, 196608, 18);
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$19(showReportList$delegate3), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-905988169, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda55
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$12;
                        InspectorScreen$lambda$1$23$12 = InspectorScreenKt.InspectorScreen$lambda$1$23$12(showReportList$delegate3, selectedAdId$delegate, selectedReportId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$12;
                    }
                }, $composer, 54), $composer, 196608, 18);
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$10(selectedReportId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(1629619256, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda56
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$13;
                        InspectorScreen$lambda$1$23$13 = InspectorScreenKt.InspectorScreen$lambda$1$23$13(selectedReportId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$13;
                    }
                }, $composer, 54), $composer, 196608, 18);
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$13(showSettings$delegate), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-129740615, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda57
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$14;
                        InspectorScreen$lambda$1$23$14 = InspectorScreenKt.InspectorScreen$lambda$1$23$14(showSettings$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$14;
                    }
                }, $composer, 54), $composer, 196608, 18);
                AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$16(showFeedback$delegate), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-1889100486, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda58
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InspectorScreen$lambda$1$23$15;
                        InspectorScreen$lambda$1$23$15 = InspectorScreenKt.InspectorScreen$lambda$1$23$15(showFeedback$delegate, selectedAdId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InspectorScreen$lambda$1$23$15;
                    }
                }, $composer, 54), $composer, 196608, 18);
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
            switch (WhenMappings.$EnumSwitchMapping$0[$userRole.ordinal()]) {
                case 1:
                    selectedTabIndex$delegate = selectedTabIndex$delegate3;
                    showReportList$delegate = showReportList$delegate2;
                    isLandscape = isLandscape2;
                    listOf = CollectionsKt.listOf(new TabInfo[]{new TabInfo("广告", AppIcons.INSTANCE.getDashboard(), 0), new TabInfo("请求", AppIcons.INSTANCE.getApi(), 1), new TabInfo("上报", AppIcons.INSTANCE.getUpload(), 2), new TabInfo("控制台", AppIcons.INSTANCE.getCode(), 3)});
                    break;
                case 2:
                    selectedTabIndex$delegate = selectedTabIndex$delegate3;
                    isLandscape = isLandscape2;
                    showReportList$delegate = showReportList$delegate2;
                    listOf = CollectionsKt.listOf(new TabInfo[]{new TabInfo("广告", AppIcons.INSTANCE.getDashboard(), 0), new TabInfo("请求", AppIcons.INSTANCE.getApi(), 1), new TabInfo("上报", AppIcons.INSTANCE.getUpload(), 2), new TabInfo("控制台", AppIcons.INSTANCE.getCode(), 3)});
                    break;
                case 3:
                case 4:
                    listOf = CollectionsKt.listOf(new TabInfo("广告", AppIcons.INSTANCE.getDashboard(), 0));
                    selectedTabIndex$delegate = selectedTabIndex$delegate3;
                    showReportList$delegate = showReportList$delegate2;
                    isLandscape = isLandscape2;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Object value$iv17 = listOf;
            $composer.updateRememberedValue(value$iv17);
            it$iv9 = value$iv17;
            List visibleTabs2 = (List) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (InspectorScreen$lambda$1$4(selectedAdId$delegate) == null) {
            }
            ComposerKt.sourceInformationMarkerStart($composer, -601229450, "CC(remember):InspectorScreen.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BackHandler_androidKt.BackHandler(isDetailPageActive, (Function0) it$iv, $composer, 48);
            SystemStatusBarColor_androidKt.m352SystemStatusBarColorek8zF_U(Color.Companion.getWhite-0d7_KjU(), $composer, 6);
            Modifier modifier$iv$iv2 = SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv2);
            Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i22 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -987016166, "C178@7944L919,174@7769L1094,209@9057L458,205@8877L638,227@9698L1754,223@9529L1923,273@11645L452,269@11466L631,291@12278L304,287@12111L471,306@12763L344,302@12596L511:InspectorScreen.kt#37tpck");
            if (isLandscape) {
            }
            final MutableState showReportList$delegate32 = showReportList$delegate;
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$4(selectedAdId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-1792609729, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda52
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$10;
                    InspectorScreen$lambda$1$23$10 = InspectorScreenKt.InspectorScreen$lambda$1$23$10(selectedAdId$delegate, showFeedback$delegate, showReportList$delegate32, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$10;
                }
            }, $composer, 54), $composer, 196608, 18);
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$7(selectedRequestId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(853371702, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda53
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$11;
                    InspectorScreen$lambda$1$23$11 = InspectorScreenKt.InspectorScreen$lambda$1$23$11(selectedRequestId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$11;
                }
            }, $composer, 54), $composer, 196608, 18);
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$19(showReportList$delegate32), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-905988169, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda55
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$12;
                    InspectorScreen$lambda$1$23$12 = InspectorScreenKt.InspectorScreen$lambda$1$23$12(showReportList$delegate32, selectedAdId$delegate, selectedReportId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$12;
                }
            }, $composer, 54), $composer, 196608, 18);
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$10(selectedReportId$delegate) == null, (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(1629619256, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda56
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$13;
                    InspectorScreen$lambda$1$23$13 = InspectorScreenKt.InspectorScreen$lambda$1$23$13(selectedReportId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$13;
                }
            }, $composer, 54), $composer, 196608, 18);
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$13(showSettings$delegate), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-129740615, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda57
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$14;
                    InspectorScreen$lambda$1$23$14 = InspectorScreenKt.InspectorScreen$lambda$1$23$14(showSettings$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$14;
                }
            }, $composer, 54), $composer, 196608, 18);
            AnimatedVisibilityKt.AnimatedVisibility(InspectorScreen$lambda$1$16(showFeedback$delegate), (Modifier) null, EnterExitTransitionKt.iosEnterTransition(), EnterExitTransitionKt.iosPopExitTransition(), (String) null, ComposableLambdaKt.rememberComposableLambda(-1889100486, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda58
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit InspectorScreen$lambda$1$23$15;
                    InspectorScreen$lambda$1$23$15 = InspectorScreenKt.InspectorScreen$lambda$1$23$15(showFeedback$delegate, selectedAdId$delegate, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return InspectorScreen$lambda$1$23$15;
                }
            }, $composer, 54), $composer, 196608, 18);
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

    private static final boolean InspectorScreen$lambda$1$13(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void InspectorScreen$lambda$1$14(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean InspectorScreen$lambda$1$16(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void InspectorScreen$lambda$1$17(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean InspectorScreen$lambda$1$19(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void InspectorScreen$lambda$1$20(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$22$0(MutableState $showFeedback$delegate, MutableState $selectedReportId$delegate, MutableState $showReportList$delegate, MutableState $selectedAdId$delegate, MutableState $selectedRequestId$delegate, MutableState $showSettings$delegate) {
        if (InspectorScreen$lambda$1$16($showFeedback$delegate)) {
            InspectorScreen$lambda$1$17($showFeedback$delegate, false);
        } else if (InspectorScreen$lambda$1$10($selectedReportId$delegate) == null) {
            if (InspectorScreen$lambda$1$19($showReportList$delegate)) {
                InspectorScreen$lambda$1$20($showReportList$delegate, false);
            } else if (InspectorScreen$lambda$1$4($selectedAdId$delegate) == null) {
                if (InspectorScreen$lambda$1$7($selectedRequestId$delegate) == null) {
                    if (InspectorScreen$lambda$1$13($showSettings$delegate)) {
                        InspectorScreen$lambda$1$14($showSettings$delegate, false);
                    }
                } else {
                    $selectedRequestId$delegate.setValue(null);
                }
            } else {
                $selectedAdId$delegate.setValue(null);
            }
        } else {
            $selectedReportId$delegate.setValue(null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$0$0(MutableIntState $selectedTabIndex$delegate, int it) {
        $selectedTabIndex$delegate.setIntValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$1$0(MutableState $selectedAdId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedAdId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$2$0(MutableState $selectedRequestId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedRequestId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$3$0(MutableState $selectedReportId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedReportId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$4$0(MutableState $showSettings$delegate) {
        InspectorScreen$lambda$1$14($showSettings$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$5$0(MutableIntState $selectedTabIndex$delegate, int it) {
        $selectedTabIndex$delegate.setIntValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$6$0(MutableState $selectedAdId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedAdId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$7$0(MutableState $selectedRequestId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedRequestId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$8$0(MutableState $selectedReportId$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $selectedReportId$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$9$0(MutableState $showSettings$delegate) {
        InspectorScreen$lambda$1$14($showSettings$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10(final MutableState $selectedAdId$delegate, final MutableState $showFeedback$delegate, final MutableState $showReportList$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C181@8043L23,182@8098L328,192@8446L403,179@7962L887:InspectorScreen.kt#37tpck");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1792609729, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:179)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -416060682, "CC(remember):InspectorScreen.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda20
                public final Object invoke() {
                    Unit InspectorScreen$lambda$1$23$10$0$0;
                    InspectorScreen$lambda$1$23$10$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$10$0$0($selectedAdId$delegate);
                    return InspectorScreen$lambda$1$23$10$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DetailScaffoldKt.DetailScaffold("广告详情", (Function0) it$iv, ComposableLambdaKt.rememberComposableLambda(-1498873635, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda22
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InspectorScreen$lambda$1$23$10$1;
                InspectorScreen$lambda$1$23$10$1 = InspectorScreenKt.InspectorScreen$lambda$1$23$10$1($showFeedback$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InspectorScreen$lambda$1$23$10$1;
            }
        }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(-26814471, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda23
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InspectorScreen$lambda$1$23$10$2;
                InspectorScreen$lambda$1$23$10$2 = InspectorScreenKt.InspectorScreen$lambda$1$23$10$2($selectedAdId$delegate, $showReportList$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InspectorScreen$lambda$1$23$10$2;
            }
        }, $composer, 54), $composer, 3510, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10$0$0(MutableState $selectedAdId$delegate) {
        $selectedAdId$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10$1(final MutableState $showFeedback$delegate, RowScope $this$DetailScaffold, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$DetailScaffold, "$this$DetailScaffold");
        ComposerKt.sourceInformation($composer, "C185@8206L83,184@8156L248:InspectorScreen.kt#37tpck");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498873635, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:184)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1603515536, "CC(remember):InspectorScreen.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit InspectorScreen$lambda$1$23$10$1$0$0;
                        InspectorScreen$lambda$1$23$10$1$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$10$1$0$0($showFeedback$delegate);
                        return InspectorScreen$lambda$1$23$10$1$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) it$iv, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$1921791$ad_inspector_debug(), $composer, 1572870, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10$1$0$0(MutableState $showFeedback$delegate) {
        InspectorScreen$lambda$1$17($showFeedback$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10$2(MutableState $selectedAdId$delegate, final MutableState $showReportList$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation($composer, "CN(paddingValues):InspectorScreen.kt#37tpck");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-26814471, $dirty, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:193)");
            }
            String adId = InspectorScreen$lambda$1$4($selectedAdId$delegate);
            if (adId == null) {
                $composer.startReplaceGroup(34074364);
            } else {
                $composer.startReplaceGroup(34074365);
                ComposerKt.sourceInformation($composer, "*197@8697L85,194@8537L272");
                ComposerKt.sourceInformationMarkerStart($composer, -670602612, "CC(remember):InspectorScreen.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda68
                        public final Object invoke() {
                            Unit InspectorScreen$lambda$1$23$10$2$0$0$0;
                            InspectorScreen$lambda$1$23$10$2$0$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$10$2$0$0$0($showReportList$delegate);
                            return InspectorScreen$lambda$1$23$10$2$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                AdDetailScreenKt.AdDetailScreen(adId, paddingValues, (Function0) it$iv, $composer, (($dirty << 3) & 112) | 384);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$10$2$0$0$0(MutableState $showReportList$delegate) {
        InspectorScreen$lambda$1$20($showReportList$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$11(final MutableState $selectedRequestId$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C212@9156L28,213@9204L297,210@9075L426:InspectorScreen.kt#37tpck");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(853371702, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:210)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -248544718, "CC(remember):InspectorScreen.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda69
                public final Object invoke() {
                    Unit InspectorScreen$lambda$1$23$11$0$0;
                    InspectorScreen$lambda$1$23$11$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$11$0$0($selectedRequestId$delegate);
                    return InspectorScreen$lambda$1$23$11$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DetailScaffoldKt.DetailScaffold("请求详情", (Function0) it$iv, null, ComposableLambdaKt.rememberComposableLambda(1270532720, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda70
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InspectorScreen$lambda$1$23$11$1;
                InspectorScreen$lambda$1$23$11$1 = InspectorScreenKt.InspectorScreen$lambda$1$23$11$1($selectedRequestId$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InspectorScreen$lambda$1$23$11$1;
            }
        }, $composer, 54), $composer, 3126, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$11$0$0(MutableState $selectedRequestId$delegate) {
        $selectedRequestId$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$11$1(MutableState $selectedRequestId$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation($composer, "CN(paddingValues):InspectorScreen.kt#37tpck");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1270532720, $dirty, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:214)");
            }
            String requestId = InspectorScreen$lambda$1$7($selectedRequestId$delegate);
            if (requestId == null) {
                $composer.startReplaceGroup(-1106453740);
            } else {
                $composer.startReplaceGroup(-1106453739);
                ComposerKt.sourceInformation($composer, "*215@9305L156");
                RequestDetailScreenKt.RequestDetailScreen(requestId, null, paddingValues, $composer, ($dirty << 6) & 896, 2);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$12(final MutableState $showReportList$delegate, final MutableState $selectedAdId$delegate, final MutableState $selectedReportId$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C230@9797L26,231@9843L1595,228@9716L1722:InspectorScreen.kt#37tpck");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-905988169, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:228)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1223733873, "CC(remember):InspectorScreen.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda45
                public final Object invoke() {
                    Unit InspectorScreen$lambda$1$23$12$0$0;
                    InspectorScreen$lambda$1$23$12$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$12$0$0($showReportList$delegate);
                    return InspectorScreen$lambda$1$23$12$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        DetailScaffoldKt.DetailScaffold("上报列表", (Function0) it$iv, null, ComposableLambdaKt.rememberComposableLambda(-488827151, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda46
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InspectorScreen$lambda$1$23$12$1;
                InspectorScreen$lambda$1$23$12$1 = InspectorScreenKt.InspectorScreen$lambda$1$23$12$1($selectedAdId$delegate, $selectedReportId$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InspectorScreen$lambda$1$23$12$1;
            }
        }, $composer, 54), $composer, 3126, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$12$0$0(MutableState $showReportList$delegate) {
        InspectorScreen$lambda$1$20($showReportList$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InspectorScreen$lambda$1$23$12$1(final MutableState $selectedAdId$delegate, final MutableState $selectedReportId$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation($composer, "CN(paddingValues)241@10279L37:InspectorScreen.kt#37tpck");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-488827151, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:234)");
            }
            final Flow $this$map$iv = StateManager.INSTANCE.getReportJobDataListFlow();
            Flow reportJobsFlow = new Flow<List<? extends ReportJobData>>() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1
                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$map$iv.collect(new AnonymousClass2(collector, $selectedAdId$delegate), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ MutableState $selectedAdId$delegate$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2", f = "InspectorScreen.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    /* renamed from: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, MutableState mutableState) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$selectedAdId$delegate$inlined = mutableState;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        String InspectorScreen$lambda$1$4;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$map_u24lambda_u245 = this.$this_unsafeFlow;
                                        AnonymousClass1 anonymousClass1 = $continuation;
                                        Continuation $completion2 = $continuation;
                                        Iterable jobs = (List) value;
                                        Iterable $this$filter$iv = jobs;
                                        Collection destination$iv$iv = new ArrayList();
                                        for (T t : $this$filter$iv) {
                                            ReportJobData it = (ReportJobData) t;
                                            Object $result2 = $result;
                                            Object $result3 = it.getAdId();
                                            Continuation $completion3 = $completion2;
                                            InspectorScreen$lambda$1$4 = InspectorScreenKt.InspectorScreen$lambda$1$4(this.$selectedAdId$delegate$inlined);
                                            if (Intrinsics.areEqual($result3, InspectorScreen$lambda$1$4)) {
                                                destination$iv$iv.add(t);
                                            }
                                            $result = $result2;
                                            $completion2 = $completion3;
                                        }
                                        Iterable $this$sortedByDescending$iv = (List) destination$iv$iv;
                                        Iterable $this$sortedByDescending$iv2 = CollectionsKt.sortedWith($this$sortedByDescending$iv, 
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a9: INVOKE  (r1v4 '$this$sortedByDescending$iv2' java.lang.Iterable A[D('$this$sortedByDescending$iv' java.lang.Iterable)]) = 
                                              (r1v3 '$this$sortedByDescending$iv' java.lang.Iterable A[D('$this$sortedByDescending$iv' java.lang.Iterable)])
                                              (wrap: java.util.Comparator : 0x00a4: CONSTRUCTOR  (r9v3 java.util.Comparator A[REMOVE]) =  call: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$0$$inlined$sortedByDescending$1.<init>():void type: CONSTRUCTOR)
                                             type: STATIC call: kotlin.collections.CollectionsKt.sortedWith(java.lang.Iterable, java.util.Comparator):java.util.List in method: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1.2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:267)
                                            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:79)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                                            	at java.util.ArrayList.forEach(ArrayList.java:1257)
                                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$0$$inlined$sortedByDescending$1, state: NOT_LOADED
                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                                            	... 33 more
                                            */
                                        /*
                                            this = this;
                                            r0 = r22
                                            r1 = r24
                                            boolean r2 = r1 instanceof kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                            if (r2 == 0) goto L18
                                            r2 = r1
                                            kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2$1 r2 = (kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                                            int r3 = r2.label
                                            r4 = -2147483648(0xffffffff80000000, float:-0.0)
                                            r3 = r3 & r4
                                            if (r3 == 0) goto L18
                                            int r3 = r2.label
                                            int r3 = r3 - r4
                                            r2.label = r3
                                            goto L1d
                                        L18:
                                            kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2$1 r2 = new kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2$1
                                            r2.<init>(r1)
                                        L1d:
                                            java.lang.Object r3 = r2.result
                                            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                            int r5 = r2.label
                                            switch(r5) {
                                                case 0: goto L45;
                                                case 1: goto L30;
                                                default: goto L28;
                                            }
                                        L28:
                                            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                                            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                                            r1.<init>(r2)
                                            throw r1
                                        L30:
                                            int r4 = r2.I$0
                                            java.lang.Object r5 = r2.L$3
                                            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                                            java.lang.Object r6 = r2.L$2
                                            java.lang.Object r7 = r2.L$1
                                            kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1$2$1 r7 = (kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                                            java.lang.Object r8 = r2.L$0
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            r20 = r3
                                            goto Ld5
                                        L45:
                                            kotlin.ResultKt.throwOnFailure(r3)
                                            kotlinx.coroutines.flow.FlowCollector r5 = r0.$this_unsafeFlow
                                            r7 = r2
                                            r6 = r23
                                            r8 = 0
                                            r9 = r2
                                            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                                            r10 = r6
                                            java.util.List r10 = (java.util.List) r10
                                            r11 = 0
                                            r12 = r10
                                            java.lang.Iterable r12 = (java.lang.Iterable) r12
                                            r13 = 0
                                            java.util.ArrayList r14 = new java.util.ArrayList
                                            r14.<init>()
                                            java.util.Collection r14 = (java.util.Collection) r14
                                            r15 = r12
                                            r16 = 0
                                            java.util.Iterator r17 = r15.iterator()
                                        L68:
                                            boolean r18 = r17.hasNext()
                                            if (r18 == 0) goto L96
                                            java.lang.Object r1 = r17.next()
                                            r18 = r1
                                            kntr.app.ad.domain.inspector.core.work.ReportJobData r18 = (kntr.app.ad.domain.inspector.core.work.ReportJobData) r18
                                            r19 = 0
                                            r20 = r3
                                            java.lang.String r3 = r18.getAdId()
                                            r21 = r9
                                            androidx.compose.runtime.MutableState r9 = r0.$selectedAdId$delegate$inlined
                                            java.lang.String r9 = kntr.app.ad.ui.inspector.ui.InspectorScreenKt.access$InspectorScreen$lambda$1$4(r9)
                                            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r9)
                                            if (r3 == 0) goto L8f
                                            r14.add(r1)
                                        L8f:
                                            r1 = r24
                                            r3 = r20
                                            r9 = r21
                                            goto L68
                                        L96:
                                            r20 = r3
                                            r21 = r9
                                            r1 = r14
                                            java.util.List r1 = (java.util.List) r1
                                            java.lang.Iterable r1 = (java.lang.Iterable) r1
                                            r3 = 0
                                            kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$0$$inlined$sortedByDescending$1 r9 = new kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$0$$inlined$sortedByDescending$1
                                            r9.<init>()
                                            java.util.Comparator r9 = (java.util.Comparator) r9
                                            java.util.List r1 = kotlin.collections.CollectionsKt.sortedWith(r1, r9)
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r23)
                                            r2.L$0 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                                            r2.L$1 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                                            r2.L$2 = r3
                                            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                            r2.L$3 = r3
                                            r2.I$0 = r8
                                            r3 = 1
                                            r2.label = r3
                                            java.lang.Object r1 = r5.emit(r1, r2)
                                            if (r1 != r4) goto Ld2
                                            return r4
                                        Ld2:
                                            r4 = r8
                                            r8 = r23
                                        Ld5:
                                            kotlin.Unit r1 = kotlin.Unit.INSTANCE
                                            return r1
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$InspectorScreen$lambda$1$23$12$1$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                    }
                                }
                            };
                            State reportJobsState = SnapshotStateKt.collectAsState(reportJobsFlow, CollectionsKt.emptyList(), (CoroutineContext) null, $composer, 48, 2);
                            List reportJobDataList = (List) reportJobsState.getValue();
                            if (reportJobDataList.isEmpty()) {
                                $composer.startReplaceGroup(1585040156);
                                ComposerKt.sourceInformation($composer, "245@10463L133");
                                EmptyViewKt.EmptyView("暂无数据", null, "请尝试创建一个新的上报", $composer, 390, 2);
                                $composer.endReplaceGroup();
                            } else {
                                $composer.startReplaceGroup(1585244725);
                                ComposerKt.sourceInformation($composer, "254@10864L103,251@10698L700");
                                ComposerKt.sourceInformationMarkerStart($composer, -1611424072, "CC(remember):InspectorScreen.kt#9igjgp");
                                Object it$iv = $composer.rememberedValue();
                                if (it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda43
                                        public final Object invoke(Object obj) {
                                            Unit InspectorScreen$lambda$1$23$12$1$1$0;
                                            InspectorScreen$lambda$1$23$12$1$1$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$12$1$1$0($selectedReportId$delegate, (String) obj);
                                            return InspectorScreen$lambda$1$23$12$1$1$0;
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ReportListKt.ReportList(reportJobDataList, RoomRecommendViewModel.EMPTY_CURSOR, (Function1) it$iv, PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(paddingValues.calculateTopPadding-D9Ej5fM() + Dp.constructor-impl(16)), Dp.constructor-impl(16), Dp.constructor-impl(paddingValues.calculateBottomPadding-D9Ej5fM() + Dp.constructor-impl(16))), $composer, 432, 0);
                                $composer.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$12$1$1$0(MutableState $selectedReportId$delegate, String reportId) {
                        Intrinsics.checkNotNullParameter(reportId, "reportId");
                        $selectedReportId$delegate.setValue(reportId);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$13(final MutableState $selectedReportId$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer, "C276@11744L27,277@11791L292,274@11663L420:InspectorScreen.kt#37tpck");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1629619256, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:274)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer, -1598954829, "CC(remember):InspectorScreen.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda12
                                public final Object invoke() {
                                    Unit InspectorScreen$lambda$1$23$13$0$0;
                                    InspectorScreen$lambda$1$23$13$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$13$0$0($selectedReportId$delegate);
                                    return InspectorScreen$lambda$1$23$13$0$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        DetailScaffoldKt.DetailScaffold("上报详情", (Function0) it$iv, null, ComposableLambdaKt.rememberComposableLambda(2046780274, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit InspectorScreen$lambda$1$23$13$1;
                                InspectorScreen$lambda$1$23$13$1 = InspectorScreenKt.InspectorScreen$lambda$1$23$13$1($selectedReportId$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return InspectorScreen$lambda$1$23$13$1;
                            }
                        }, $composer, 54), $composer, 3126, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$13$0$0(MutableState $selectedReportId$delegate) {
                        $selectedReportId$delegate.setValue(null);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$13$1(MutableState $selectedReportId$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                        ComposerKt.sourceInformation($composer, "CN(paddingValues):InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
                        }
                        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2046780274, $dirty, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:278)");
                            }
                            String reportId = InspectorScreen$lambda$1$10($selectedReportId$delegate);
                            if (reportId == null) {
                                $composer.startReplaceGroup(-19495306);
                            } else {
                                $composer.startReplaceGroup(-19495305);
                                ComposerKt.sourceInformation($composer, "*279@11890L153");
                                ReportDetailScreenKt.ReportDetailScreen(reportId, null, paddingValues, $composer, ($dirty << 6) & 896, 2);
                            }
                            $composer.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$14(final MutableState $showSettings$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer, "C294@12375L24,292@12296L272:InspectorScreen.kt#37tpck");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-129740615, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:292)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer, -126676303, "CC(remember):InspectorScreen.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda11
                                public final Object invoke() {
                                    Unit InspectorScreen$lambda$1$23$14$0$0;
                                    InspectorScreen$lambda$1$23$14$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$14$0$0($showSettings$delegate);
                                    return InspectorScreen$lambda$1$23$14$0$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        DetailScaffoldKt.DetailScaffold("设置", (Function0) it$iv, null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$287420403$ad_inspector_debug(), $composer, 3126, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$14$0$0(MutableState $showSettings$delegate) {
                        InspectorScreen$lambda$1$14($showSettings$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$15(final MutableState $showFeedback$delegate, final MutableState $selectedAdId$delegate, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer, "C309@12862L24,310@12906L187,307@12781L312:InspectorScreen.kt#37tpck");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1889100486, $changed, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:307)");
                        }
                        ComposerKt.sourceInformationMarkerStart($composer, 1345602354, "CC(remember):InspectorScreen.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda16
                                public final Object invoke() {
                                    Unit InspectorScreen$lambda$1$23$15$0$0;
                                    InspectorScreen$lambda$1$23$15$0$0 = InspectorScreenKt.InspectorScreen$lambda$1$23$15$0$0($showFeedback$delegate);
                                    return InspectorScreen$lambda$1$23$15$0$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        DetailScaffoldKt.DetailScaffold("问题反馈", (Function0) it$iv, null, ComposableLambdaKt.rememberComposableLambda(-1471939468, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda17
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit InspectorScreen$lambda$1$23$15$1;
                                InspectorScreen$lambda$1$23$15$1 = InspectorScreenKt.InspectorScreen$lambda$1$23$15$1($selectedAdId$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return InspectorScreen$lambda$1$23$15$1;
                            }
                        }, $composer, 54), $composer, 3126, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$15$0$0(MutableState $showFeedback$delegate) {
                        InspectorScreen$lambda$1$17($showFeedback$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit InspectorScreen$lambda$1$23$15$1(MutableState $selectedAdId$delegate, PaddingValues paddingValues, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                        ComposerKt.sourceInformation($composer, "CN(paddingValues)311@12945L130:InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
                        }
                        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1471939468, $dirty, -1, "kntr.app.ad.ui.inspector.ui.InspectorScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:311)");
                            }
                            FeedbackScreenKt.FeedbackScreen(InspectorScreen$lambda$1$4($selectedAdId$delegate), paddingValues, $composer, ($dirty << 3) & 112, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    private static final void LandscapeMainContent(final List<TabInfo> list, final int selectedTabIndex, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super String, Unit> function14, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
                        Function0 function03;
                        int $dirty;
                        Composer $composer2;
                        Function0 onShowSettings;
                        Function0 onShowSettings2;
                        Function0 factory$iv$iv$iv;
                        Composer $composer$iv;
                        Composer $composer3;
                        Composer $composer$iv2;
                        float f;
                        Function0 factory$iv$iv$iv2;
                        Composer $composer4 = $composer.startRestartGroup(-1065401595);
                        ComposerKt.sourceInformation($composer4, "C(LandscapeMainContent)N(visibleTabs,selectedTabIndex,onTabSelect,onBack,onAdClick,onRequestClick,onReportClick,onShowSettings)330@13429L2,332@13470L7,336@13528L1822:InspectorScreen.kt#37tpck");
                        int $dirty2 = $changed;
                        if (($changed & 6) == 0) {
                            $dirty2 |= $composer4.changedInstance(list) ? 4 : 2;
                        }
                        if (($changed & 48) == 0) {
                            $dirty2 |= $composer4.changed(selectedTabIndex) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty2 |= $composer4.changedInstance(function1) ? 256 : 128;
                        }
                        if (($changed & 3072) == 0) {
                            $dirty2 |= $composer4.changedInstance(function0) ? 2048 : 1024;
                        }
                        if (($changed & 24576) == 0) {
                            $dirty2 |= $composer4.changedInstance(function12) ? 16384 : 8192;
                        }
                        if ((196608 & $changed) == 0) {
                            $dirty2 |= $composer4.changedInstance(function13) ? 131072 : 65536;
                        }
                        if ((1572864 & $changed) == 0) {
                            $dirty2 |= $composer4.changedInstance(function14) ? 1048576 : 524288;
                        }
                        int i2 = i & 128;
                        if (i2 != 0) {
                            $dirty2 |= 12582912;
                            function03 = function02;
                        } else if ((12582912 & $changed) == 0) {
                            function03 = function02;
                            $dirty2 |= $composer4.changedInstance(function03) ? 8388608 : 4194304;
                        } else {
                            function03 = function02;
                        }
                        if (!$composer4.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
                            $dirty = $dirty2;
                            $composer2 = $composer4;
                            $composer2.skipToGroupEnd();
                            onShowSettings = function03;
                        } else {
                            if (i2 != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer4, -1648707321, "CC(remember):InspectorScreen.kt#9igjgp");
                                Object it$iv = $composer4.rememberedValue();
                                if (it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda24
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    $composer4.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                onShowSettings2 = (Function0) it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                            } else {
                                onShowSettings2 = function03;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1065401595, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.LandscapeMainContent (InspectorScreen.kt:331)");
                            }
                            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer4.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            final UserRole userRole = (UserRole) consume;
                            float sidebarWidth = Dp.constructor-impl(200);
                            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv = (6 << 3) & 112;
                            $composer2 = $composer4;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            $dirty = $dirty2;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                            int i3 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            int i4 = ((6 >> 6) & 112) | 6;
                            RowScope $this$LandscapeMainContent_u24lambda_u241 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1548447306, "C359@14296L1048:InspectorScreen.kt#37tpck");
                            if (list.size() > 1 || userRole == UserRole.OPERATOR) {
                                $composer4.startReplaceGroup(1548470648);
                                ComposerKt.sourceInformation($composer4, "346@13908L350,339@13665L593");
                                $composer$iv = $composer4;
                                $composer3 = $composer4;
                                $composer$iv2 = $composer4;
                                f = 0.0f;
                                final Function0 function04 = onShowSettings2;
                                SurfaceKt.Surface-T9BRK9s(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), sidebarWidth), (Shape) null, Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl(2), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1319996885, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda25
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit LandscapeMainContent$lambda$1$0;
                                        LandscapeMainContent$lambda$1$0 = InspectorScreenKt.LandscapeMainContent$lambda$1$0(list, selectedTabIndex, function1, userRole, function04, function0, (Composer) obj, ((Integer) obj2).intValue());
                                        return LandscapeMainContent$lambda$1$0;
                                    }
                                }, $composer3, 54), $composer3, 12779910, 90);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer4.startReplaceGroup(1534908737);
                                $composer4.endReplaceGroup();
                                $composer3 = $composer4;
                                $composer$iv = $composer4;
                                $composer$iv2 = $composer4;
                                f = 0.0f;
                            }
                            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(RowScope.-CC.weight$default($this$LandscapeMainContent_u24lambda_u241, SizeKt.fillMaxSize$default(Modifier.Companion, f, 1, (Object) null), 1.0f, false, 2, (Object) null), ColorKt.Color(4294572795L), (Shape) null, 2, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(16));
                            Composer $composer$iv3 = $composer3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv2 = (0 << 3) & 112;
                            onShowSettings = onShowSettings2;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer$iv3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv$iv);
                            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer$iv3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv3.startReusableNode();
                            if ($composer$iv3.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer$iv3.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer$iv3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv3);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv3, -650887856, "C:InspectorScreen.kt#37tpck");
                            int realTabIndex = list.get(selectedTabIndex).getIndex();
                            switch (realTabIndex) {
                                case 0:
                                    $composer$iv3.startReplaceGroup(1641575151);
                                    ComposerKt.sourceInformation($composer$iv3, "372@14737L84");
                                    AdListScreenKt.AdListScreen(function12, null, $composer$iv3, ($dirty >> 12) & 14, 2);
                                    $composer$iv3.endReplaceGroup();
                                    Unit unit = Unit.INSTANCE;
                                    break;
                                case 1:
                                    $composer$iv3.startReplaceGroup(1641579225);
                                    ComposerKt.sourceInformation($composer$iv3, "377@14864L94");
                                    RequestListScreenKt.RequestListScreen(function13, null, $composer$iv3, ($dirty >> 15) & 14, 2);
                                    $composer$iv3.endReplaceGroup();
                                    Unit unit2 = Unit.INSTANCE;
                                    break;
                                case 2:
                                    $composer$iv3.startReplaceGroup(1641583607);
                                    ComposerKt.sourceInformation($composer$iv3, "382@15001L92");
                                    ReportListScreenKt.ReportListScreen(function14, null, $composer$iv3, ($dirty >> 18) & 14, 2);
                                    $composer$iv3.endReplaceGroup();
                                    Unit unit3 = Unit.INSTANCE;
                                    break;
                                case 3:
                                    $composer$iv3.startReplaceGroup(1641587854);
                                    ComposerKt.sourceInformation($composer$iv3, "387@15136L19");
                                    ConsoleListScreenKt.ConsoleListScreen(null, $composer$iv3, 0, 1);
                                    $composer$iv3.endReplaceGroup();
                                    Unit unit4 = Unit.INSTANCE;
                                    break;
                                default:
                                    $composer$iv3.startReplaceGroup(1641590034);
                                    ComposerKt.sourceInformation($composer$iv3, "390@15201L119");
                                    EmptyViewKt.EmptyView("未知页面", null, "无法显示此页面内容", $composer$iv3, 390, 2);
                                    $composer$iv3.endReplaceGroup();
                                    Unit unit5 = Unit.INSTANCE;
                                    break;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            $composer$iv3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function0 function05 = onShowSettings;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda26
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit LandscapeMainContent$lambda$2;
                                    LandscapeMainContent$lambda$2 = InspectorScreenKt.LandscapeMainContent$lambda$2(list, selectedTabIndex, function1, function0, function12, function13, function14, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return LandscapeMainContent$lambda$2;
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit LandscapeMainContent$lambda$1$0(List $visibleTabs, int $selectedTabIndex, Function1 $onTabSelect, UserRole $userRole, Function0 $onShowSettings, Function0 $onBack, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C347@13926L318:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1319996885, $changed, -1, "kntr.app.ad.ui.inspector.ui.LandscapeMainContent.<anonymous>.<anonymous> (InspectorScreen.kt:347)");
                            }
                            SidebarNavigation($visibleTabs, $selectedTabIndex, $onTabSelect, $userRole, $onShowSettings, $onBack, $composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    private static final void SidebarNavigation(final List<TabInfo> list, final int selectedTabIndex, final Function1<? super Integer, Unit> function1, final UserRole userRole, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
                        Function0 factory$iv$iv$iv;
                        Function0 factory$iv$iv$iv2;
                        Function0 factory$iv$iv$iv3;
                        Function0 factory$iv$iv$iv4;
                        Function0 factory$iv$iv$iv5;
                        String str;
                        final MutableState showClearCacheDialog$delegate;
                        Function0 value$iv;
                        Composer $composer2 = $composer.startRestartGroup(-1188623594);
                        ComposerKt.sourceInformation($composer2, "C(SidebarNavigation)N(visibleTabs,selectedTabIndex,onTabSelect,userRole,onShowSettings,onBack)409@15637L7,411@15705L34,412@15756L24,414@15786L4273:InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
                        }
                        if (($changed & 48) == 0) {
                            $dirty |= $composer2.changed(selectedTabIndex) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
                        }
                        if (($changed & 3072) == 0) {
                            $dirty |= $composer2.changed(userRole.ordinal()) ? 2048 : 1024;
                        }
                        if ((196608 & $changed) == 0) {
                            $dirty |= $composer2.changedInstance(function02) ? 131072 : 65536;
                        }
                        int $i$f$forEachIndexed = $dirty;
                        if ($composer2.shouldExecute((66707 & $i$f$forEachIndexed) != 66706, $i$f$forEachIndexed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1188623594, $i$f$forEachIndexed, -1, "kntr.app.ad.ui.inspector.ui.SidebarNavigation (InspectorScreen.kt:408)");
                            }
                            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
                            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer2.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            final long themeColor = ((UserRole) consume).m353getColor0d7_KjU();
                            ComposerKt.sourceInformationMarkerStart($composer2, 194036568, "CC(remember):InspectorScreen.kt#9igjgp");
                            Object it$iv = $composer2.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                $composer2.updateRememberedValue(value$iv2);
                                it$iv = value$iv2;
                            }
                            MutableState showClearCacheDialog$delegate2 = (MutableState) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
                            Object value$iv$iv = $composer2.rememberedValue();
                            if (value$iv$iv == Composer.Companion.getEmpty()) {
                                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                                $composer2.updateRememberedValue(value$iv$iv);
                            }
                            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null);
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                            int $changed$iv$iv = (438 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                $composer2.createNode(factory$iv$iv$iv6);
                            } else {
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                            int i2 = ((438 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, 203625774, "C423@16064L2075,486@18175L1878:InspectorScreen.kt#37tpck");
                            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Modifier modifier$iv2 = Modifier.Companion;
                            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv2 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            int $changed$iv$iv$iv3 = $i$f$forEachIndexed;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv7;
                                $composer2.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv7;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                            String str2 = "CC(remember):InspectorScreen.kt#9igjgp";
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                            int i4 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -2141854341, "C425@16115L1359,465@17488L41,468@17564L565:InspectorScreen.kt#37tpck");
                            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(8));
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv3 = (390 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                                $composer2.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                            int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i6 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1412360256, "C436@16521L10,433@16407L342,444@16790L289,457@17242L10,454@17121L339:InspectorScreen.kt#37tpck");
                            TextKt.Text-Nvy7gAk("AdInspector", (Modifier) null, ColorKt.Color(4279310375L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getTitleMedium(), 0L, TextUnitKt.getSp(16), FontWeight.Companion.getSemiBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer2, 390, 0, 131066);
                            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 2, (Object) null), Dp.constructor-impl(16)), Dp.constructor-impl(1)), ColorKt.Color(4293257195L), (Shape) null, 2, (Object) null), $composer2, 6);
                            TextKt.Text-Nvy7gAk(userRole.getDisplayName(), (Modifier) null, themeColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodyMedium(), 0L, TextUnitKt.getSp(14), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer2, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer2, 6);
                            Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(2));
                            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv4 = (54 << 3) & 112;
                            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv4;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv4);
                            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                                $composer2.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i7 = ($changed$iv$iv$iv5 >> 6) & 14;
                            boolean z = false;
                            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                            int i8 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -41423681, "C:InspectorScreen.kt#37tpck");
                            $composer2.startReplaceGroup(-139883208);
                            ComposerKt.sourceInformation($composer2, "*478@18003L22,474@17810L287");
                            List<TabInfo> $this$forEachIndexed$iv = list;
                            boolean z2 = false;
                            int index$iv = 0;
                            for (Object item$iv : $this$forEachIndexed$iv) {
                                int index$iv2 = index$iv + 1;
                                if (index$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                TabInfo tab = (TabInfo) item$iv;
                                final int index = index$iv;
                                ImageVector icon = tab.getIcon();
                                String title = tab.getTitle();
                                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                boolean z3 = index == selectedTabIndex;
                                boolean z4 = z2;
                                String str3 = str2;
                                ComposerKt.sourceInformationMarkerStart($composer2, -288313498, str3);
                                int $dirty2 = $changed$iv$iv$iv3;
                                int $dirty3 = $changed$iv$iv$iv5;
                                int $changed$iv$iv$iv6 = $dirty2 & 896;
                                boolean z5 = z;
                                boolean invalid$iv = ($changed$iv$iv$iv6 == 256) | $composer2.changed(index);
                                Object it$iv2 = $composer2.rememberedValue();
                                if (!invalid$iv && it$iv2 != Composer.Companion.getEmpty()) {
                                    value$iv = it$iv2;
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    m388SidebarItemFHprtrg(icon, title, z3, value$iv, themeColor, false, $composer2, 0, 32);
                                    $changed$iv$iv$iv5 = $dirty3;
                                    z = z5;
                                    index$iv = index$iv2;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    $changed$iv$iv$iv3 = $dirty2;
                                    str2 = str3;
                                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                    z2 = z4;
                                }
                                value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda38
                                    public final Object invoke() {
                                        Unit SidebarNavigation$lambda$3$0$1$0$0$0;
                                        SidebarNavigation$lambda$3$0$1$0$0$0 = InspectorScreenKt.SidebarNavigation$lambda$3$0$1$0$0$0(function1, index);
                                        return SidebarNavigation$lambda$3$0$1$0$0$0;
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                m388SidebarItemFHprtrg(icon, title, z3, value$iv, themeColor, false, $composer2, 0, 32);
                                $changed$iv$iv$iv5 = $dirty3;
                                z = z5;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                $changed$iv$iv$iv3 = $dirty2;
                                str2 = str3;
                                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                z2 = z4;
                            }
                            $i$f$forEachIndexed = $changed$iv$iv$iv3;
                            String str4 = str2;
                            $composer2.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Modifier modifier$iv5 = Modifier.Companion;
                            Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv4 = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv5 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv5 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer2, modifier$iv5);
                            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv5 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                                $composer2.createNode(factory$iv$iv$iv4);
                            } else {
                                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                            int i9 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope4 = ColumnScopeInstance.INSTANCE;
                            int i10 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, 1689621561, "C487@18196L172,494@18406L1637:InspectorScreen.kt#37tpck");
                            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), Dp.constructor-impl(1), ColorKt.Color(4293257195L), $composer2, 438, 0);
                            Modifier modifier$iv6 = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(8));
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv6 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                            CompositionLocalMap localMap$iv$iv6 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer2, modifier$iv6);
                            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv8 = (($changed$iv$iv6 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                                $composer2.createNode(factory$iv$iv$iv5);
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer2);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                            int i11 = ($changed$iv$iv$iv8 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope2 = RowScopeInstance.INSTANCE;
                            int i12 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1610649883, "C503@18744L31,505@18848L275,502@18702L421,531@19756L273,528@19635L394:InspectorScreen.kt#37tpck");
                            ComposerKt.sourceInformationMarkerStart($composer2, 2026253582, str4);
                            Object value$iv3 = $composer2.rememberedValue();
                            if (value$iv3 == Composer.Companion.getEmpty()) {
                                str = str4;
                                showClearCacheDialog$delegate = showClearCacheDialog$delegate2;
                                value$iv3 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda39
                                    public final Object invoke() {
                                        Unit SidebarNavigation$lambda$3$1$0$0$0;
                                        SidebarNavigation$lambda$3$1$0$0$0 = InspectorScreenKt.SidebarNavigation$lambda$3$1$0$0$0(showClearCacheDialog$delegate);
                                        return SidebarNavigation$lambda$3$1$0$0$0;
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv3);
                            } else {
                                str = str4;
                                showClearCacheDialog$delegate = showClearCacheDialog$delegate2;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            IconButtonKt.IconButton((Function0) value$iv3, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(629278097, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda40
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SidebarNavigation$lambda$3$1$0$1;
                                    SidebarNavigation$lambda$3$1$0$1 = InspectorScreenKt.SidebarNavigation$lambda$3$1$0$1(themeColor, (Composer) obj, ((Integer) obj2).intValue());
                                    return SidebarNavigation$lambda$3$1$0$1;
                                }
                            }, $composer2, 54), $composer2, 1572918, 60);
                            final MutableState showClearCacheDialog$delegate3 = showClearCacheDialog$delegate;
                            String str5 = str;
                            IconButtonKt.IconButton(function02, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1241764666, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda41
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SidebarNavigation$lambda$3$1$0$2;
                                    SidebarNavigation$lambda$3$1$0$2 = InspectorScreenKt.SidebarNavigation$lambda$3$1$0$2(themeColor, (Composer) obj, ((Integer) obj2).intValue());
                                    return SidebarNavigation$lambda$3$1$0$2;
                                }
                            }, $composer2, 54), $composer2, (($i$f$forEachIndexed >> 15) & 14) | 1572912, 60);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            if (SidebarNavigation$lambda$1(showClearCacheDialog$delegate3)) {
                                $composer2 = $composer2;
                                $composer2.startReplaceGroup(1724556007);
                                ComposerKt.sourceInformation($composer2, "546@20162L32,549@20318L347,561@20695L137,545@20118L725");
                                ComposerKt.sourceInformationMarkerStart($composer2, 194179190, str5);
                                Object it$iv3 = $composer2.rememberedValue();
                                if (it$iv3 == Composer.Companion.getEmpty()) {
                                    Object value$iv4 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda34
                                        public final Object invoke() {
                                            Unit SidebarNavigation$lambda$4$0;
                                            SidebarNavigation$lambda$4$0 = InspectorScreenKt.SidebarNavigation$lambda$4$0(showClearCacheDialog$delegate3);
                                            return SidebarNavigation$lambda$4$0;
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv4);
                                    it$iv3 = value$iv4;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) it$iv3, ComposableLambdaKt.rememberComposableLambda(-1476815133, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda35
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit SidebarNavigation$lambda$5;
                                        SidebarNavigation$lambda$5 = InspectorScreenKt.SidebarNavigation$lambda$5(scope, showClearCacheDialog$delegate3, (Composer) obj, ((Integer) obj2).intValue());
                                        return SidebarNavigation$lambda$5;
                                    }
                                }, $composer2, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(-809433243, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda36
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit SidebarNavigation$lambda$6;
                                        SidebarNavigation$lambda$6 = InspectorScreenKt.SidebarNavigation$lambda$6(showClearCacheDialog$delegate3, (Composer) obj, ((Integer) obj2).intValue());
                                        return SidebarNavigation$lambda$6;
                                    }
                                }, $composer2, 54), (Function2) null, ComposableSingletons$InspectorScreenKt.INSTANCE.m360getLambda$142051353$ad_inspector_debug(), ComposableSingletons$InspectorScreenKt.INSTANCE.m362getLambda$1955844056$ad_inspector_debug(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, 1772598, 0, 16276);
                            } else {
                                $composer2 = $composer2;
                                $composer2.startReplaceGroup(1704584908);
                            }
                            $composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda37
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SidebarNavigation$lambda$7;
                                    SidebarNavigation$lambda$7 = InspectorScreenKt.SidebarNavigation$lambda$7(list, selectedTabIndex, function1, userRole, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                                    return SidebarNavigation$lambda$7;
                                }
                            });
                        }
                    }

                    private static final boolean SidebarNavigation$lambda$1(MutableState<Boolean> mutableState) {
                        State $this$getValue$iv = (State) mutableState;
                        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void SidebarNavigation$lambda$2(MutableState<Boolean> mutableState, boolean z) {
                        Object value$iv = Boolean.valueOf(z);
                        mutableState.setValue(value$iv);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$3$0$1$0$0$0(Function1 $onTabSelect, int $index) {
                        $onTabSelect.invoke(Integer.valueOf($index));
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$3$1$0$0$0(MutableState $showClearCacheDialog$delegate) {
                        SidebarNavigation$lambda$2($showClearCacheDialog$delegate, true);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$3$1$0$1(long $themeColor, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C506@18870L235:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(629278097, $changed, -1, "kntr.app.ad.ui.inspector.ui.SidebarNavigation.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:506)");
                            }
                            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getDelete(), "清除缓存", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), $themeColor, $composer, 438, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$3$1$0$2(long $themeColor, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C532@19778L233:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1241764666, $changed, -1, "kntr.app.ad.ui.inspector.ui.SidebarNavigation.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:532)");
                            }
                            IconKt.Icon-ww6aTOc(AppIcons.INSTANCE.getLogout(), "退出", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), $themeColor, $composer, 438, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$4$0(MutableState $showClearCacheDialog$delegate) {
                        SidebarNavigation$lambda$2($showClearCacheDialog$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$5(final CoroutineScope $scope, final MutableState $showClearCacheDialog$delegate, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C551@20378L201,550@20336L315:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1476815133, $changed, -1, "kntr.app.ad.ui.inspector.ui.SidebarNavigation.<anonymous> (InspectorScreen.kt:550)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer, -1880133012, "CC(remember):InspectorScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance($scope);
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda54
                                    public final Object invoke() {
                                        Unit SidebarNavigation$lambda$5$0$0;
                                        SidebarNavigation$lambda$5$0$0 = InspectorScreenKt.SidebarNavigation$lambda$5$0$0($scope, $showClearCacheDialog$delegate);
                                        return SidebarNavigation$lambda$5$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$1570759072$ad_inspector_debug(), $composer, 805306368, 510);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$5$0$0(CoroutineScope $scope, MutableState $showClearCacheDialog$delegate) {
                        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InspectorScreenKt$SidebarNavigation$3$1$1$1($showClearCacheDialog$delegate, null), 3, (Object) null);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$6(final MutableState $showClearCacheDialog$delegate, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C562@20734L32,562@20713L105:InspectorScreen.kt#37tpck");
                        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-809433243, $changed, -1, "kntr.app.ad.ui.inspector.ui.SidebarNavigation.<anonymous> (InspectorScreen.kt:562)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer, -476264667, "CC(remember):InspectorScreen.kt#9igjgp");
                            Object it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda65
                                    public final Object invoke() {
                                        Unit SidebarNavigation$lambda$6$0$0;
                                        SidebarNavigation$lambda$6$0$0 = InspectorScreenKt.SidebarNavigation$lambda$6$0$0($showClearCacheDialog$delegate);
                                        return SidebarNavigation$lambda$6$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InspectorScreenKt.INSTANCE.m363getLambda$2056826334$ad_inspector_debug(), $composer, 805306374, 510);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarNavigation$lambda$6$0$0(MutableState $showClearCacheDialog$delegate) {
                        SidebarNavigation$lambda$2($showClearCacheDialog$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: SidebarItem-FHprtrg  reason: not valid java name */
                    private static final void m388SidebarItemFHprtrg(final ImageVector icon, final String label, final boolean selected, final Function0<Unit> function0, final long j2, boolean smallIcon, Composer $composer, final int $changed, final int i) {
                        long j3;
                        boolean z;
                        Composer $composer2;
                        boolean smallIcon2;
                        int $dirty;
                        final float iconSize;
                        Composer $composer3 = $composer.startRestartGroup(-533647002);
                        ComposerKt.sourceInformation($composer3, "C(SidebarItem)N(icon,label,selected,onClick,themeColor:c#ui.graphics.Color,smallIcon)590@21503L1420,584@21336L1587:InspectorScreen.kt#37tpck");
                        int $dirty2 = $changed;
                        if (($changed & 6) == 0) {
                            $dirty2 |= $composer3.changed(icon) ? 4 : 2;
                        }
                        if (($changed & 48) == 0) {
                            $dirty2 |= $composer3.changed(label) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty2 |= $composer3.changed(selected) ? 256 : 128;
                        }
                        if (($changed & 3072) == 0) {
                            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : 1024;
                        }
                        if (($changed & 24576) == 0) {
                            j3 = j2;
                            $dirty2 |= $composer3.changed(j3) ? 16384 : 8192;
                        } else {
                            j3 = j2;
                        }
                        int i2 = i & 32;
                        if (i2 != 0) {
                            $dirty2 |= 196608;
                            z = smallIcon;
                        } else if ((196608 & $changed) == 0) {
                            z = smallIcon;
                            $dirty2 |= $composer3.changed(z) ? 131072 : 65536;
                        } else {
                            z = smallIcon;
                        }
                        if ($composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
                            if (i2 != 0) {
                                smallIcon2 = false;
                            } else {
                                smallIcon2 = z;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-533647002, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.SidebarItem (InspectorScreen.kt:578)");
                            }
                            long backgroundColor = selected ? Color.copy-wmQWz5c$default(j2, 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : Color.Companion.getTransparent-0d7_KjU();
                            final long contentColor = selected ? j3 : ColorKt.Color(4285231744L);
                            FontWeight.Companion companion = FontWeight.Companion;
                            final FontWeight fontWeight = selected ? companion.getMedium() : companion.getNormal();
                            if (smallIcon2) {
                                iconSize = Dp.constructor-impl(18);
                                $dirty = $dirty2;
                            } else {
                                $dirty = $dirty2;
                                iconSize = Dp.constructor-impl(20);
                            }
                            $composer2 = $composer3;
                            SurfaceKt.Surface-T9BRK9s(ClickableKt.clickable-oSLSa3U$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), (Shape) null, backgroundColor, 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-2025566655, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda42
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SidebarItem_FHprtrg$lambda$0;
                                    SidebarItem_FHprtrg$lambda$0 = InspectorScreenKt.SidebarItem_FHprtrg$lambda$0(selected, j2, iconSize, icon, label, contentColor, fontWeight, (Composer) obj, ((Integer) obj2).intValue());
                                    return SidebarItem_FHprtrg$lambda$0;
                                }
                            }, $composer3, 54), $composer2, 12582912, 122);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer2 = $composer3;
                            $composer2.skipToGroupEnd();
                            smallIcon2 = z;
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final boolean z2 = smallIcon2;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda44
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SidebarItem_FHprtrg$lambda$1;
                                    SidebarItem_FHprtrg$lambda$1 = InspectorScreenKt.SidebarItem_FHprtrg$lambda$1(icon, label, selected, function0, j2, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return SidebarItem_FHprtrg$lambda$1;
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SidebarItem_FHprtrg$lambda$0(boolean $selected, long j2, float $iconSize, ImageVector $icon, String $label, long $contentColor, FontWeight $fontWeight, Composer $composer, int $changed) {
                        Function0 factory$iv$iv$iv;
                        ComposerKt.sourceInformation($composer, "C591@21513L1404:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2025566655, $changed, -1, "kntr.app.ad.ui.inspector.ui.SidebarItem.<anonymous> (InspectorScreen.kt:591)");
                            }
                            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(12));
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
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i2 = ((390 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -1109895323, "C615@22364L188,622@22566L40,627@22714L10,624@22620L287:InspectorScreen.kt#37tpck");
                            if ($selected) {
                                $composer.startReplaceGroup(-1109901555);
                                ComposerKt.sourceInformation($composer, "600@21814L387,610@22218L40");
                                BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), Dp.constructor-impl(20)), j2, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(0.0f, Dp.constructor-impl(4), Dp.constructor-impl(4), 0.0f, 9, (Object) null)), $composer, 0);
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                                $composer.endReplaceGroup();
                            } else {
                                $composer.startReplaceGroup(-1109409027);
                                ComposerKt.sourceInformation($composer, "612@22296L40");
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), $composer, 6);
                                $composer.endReplaceGroup();
                            }
                            IconKt.Icon-ww6aTOc($icon, $label, SizeKt.size-3ABfNKs(Modifier.Companion, $iconSize), $contentColor, $composer, 0, 0);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                            TextKt.Text-Nvy7gAk($label, (Modifier) null, $contentColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), 0L, TextUnitKt.getSp(14), $fontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (Object) null), $composer, 0, 0, 131066);
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

                    /* JADX WARN: Code restructure failed: missing block: B:85:0x012f, code lost:
                        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
                     */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Removed duplicated region for block: B:115:0x0285  */
                    /* JADX WARN: Type inference failed for: r5v24 */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private static final void SimplisticMainContent(final List<TabInfo> list, final int selectedTabIndex, final Function1<? super Integer, Unit> function1, final Function0<Unit> function0, final Function1<? super String, Unit> function12, final Function1<? super String, Unit> function13, final Function1<? super String, Unit> function14, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
                        Function0 function03;
                        Function0 onShowSettings;
                        Function0 onShowSettings2;
                        Composer $composer2 = $composer.startRestartGroup(-1534348045);
                        ComposerKt.sourceInformation($composer2, "C(SimplisticMainContent)N(visibleTabs,selectedTabIndex,onTabSelect,onBack,onAdClick,onRequestClick,onReportClick,onShowSettings)647@23270L2,653@23416L20,651@23328L119,657@23512L202,657@23479L235,666@23743L33,669@23846L134,669@23807L173,676@24063L24,676@24042L46,680@24204L338,692@24550L2634,678@24094L3090:InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
                        }
                        if (($changed & 48) == 0) {
                            $dirty |= $composer2.changed(selectedTabIndex) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
                        }
                        if (($changed & 3072) == 0) {
                            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
                        }
                        if (($changed & 24576) == 0) {
                            $dirty |= $composer2.changedInstance(function12) ? 16384 : 8192;
                        }
                        if ((196608 & $changed) == 0) {
                            $dirty |= $composer2.changedInstance(function13) ? 131072 : 65536;
                        }
                        if ((1572864 & $changed) == 0) {
                            $dirty |= $composer2.changedInstance(function14) ? 1048576 : 524288;
                        }
                        int i2 = i & 128;
                        if (i2 != 0) {
                            $dirty |= 12582912;
                            function03 = function02;
                        } else if ((12582912 & $changed) == 0) {
                            function03 = function02;
                            $dirty |= $composer2.changedInstance(function03) ? 8388608 : 4194304;
                        } else {
                            function03 = function02;
                        }
                        int $dirty2 = $dirty;
                        if ($composer2.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
                            if (i2 != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer2, -1334679659, "CC(remember):InspectorScreen.kt#9igjgp");
                                Object it$iv = $composer2.rememberedValue();
                                if (it$iv == Composer.Companion.getEmpty()) {
                                    Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda4
                                        public final Object invoke() {
                                            Unit unit;
                                            unit = Unit.INSTANCE;
                                            return unit;
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv);
                                    it$iv = value$iv;
                                }
                                Function0 onShowSettings3 = it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                onShowSettings2 = onShowSettings3;
                            } else {
                                onShowSettings2 = function03;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1534348045, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent (InspectorScreen.kt:648)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer2, -1334674969, "CC(remember):InspectorScreen.kt#9igjgp");
                            boolean invalid$iv = $composer2.changedInstance(list);
                            Object it$iv2 = $composer2.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda5
                                public final Object invoke() {
                                    int size;
                                    size = list.size();
                                    return Integer.valueOf(size);
                                }
                            };
                            $composer2.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            final Function0 onShowSettings4 = onShowSettings2;
                            final PagerState pagerState = PagerStateKt.rememberPagerState(selectedTabIndex, 0.0f, (Function0) it$iv2, $composer2, ($dirty2 >> 3) & 14, 2);
                            Integer valueOf = Integer.valueOf(selectedTabIndex);
                            ComposerKt.sourceInformationMarkerStart($composer2, -1334671715, "CC(remember):InspectorScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer2.changed(pagerState) | (($dirty2 & 112) == 32);
                            Object it$iv3 = $composer2.rememberedValue();
                            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                                Object value$iv3 = (Function2) new InspectorScreenKt$SimplisticMainContent$2$1(pagerState, selectedTabIndex, null);
                                $composer2.updateRememberedValue(value$iv3);
                                it$iv3 = value$iv3;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv3, $composer2, ($dirty2 >> 3) & 14);
                            State onTabSelectState = SnapshotStateKt.rememberUpdatedState(function1, $composer2, ($dirty2 >> 6) & 14);
                            Integer valueOf2 = Integer.valueOf(pagerState.getCurrentPage());
                            ComposerKt.sourceInformationMarkerStart($composer2, -1334661095, "CC(remember):InspectorScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer2.changed(pagerState) | (($dirty2 & 112) == 32) | $composer2.changed(onTabSelectState);
                            Object it$iv4 = $composer2.rememberedValue();
                            if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv4, $composer2, 0);
                                final TopAppBarScrollBehavior scrollBehavior = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer2, 0, 7), (Function0) null, $composer2, TopAppBarDefaults.$stable << 6, 2);
                                onShowSettings = onShowSettings4;
                                ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(516283575, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit SimplisticMainContent$lambda$4;
                                        SimplisticMainContent$lambda$4 = InspectorScreenKt.SimplisticMainContent$lambda$4(onShowSettings4, function0, scrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                                        return SimplisticMainContent$lambda$4;
                                    }
                                }, $composer2, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-358644798, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                                        Unit SimplisticMainContent$lambda$5;
                                        SimplisticMainContent$lambda$5 = InspectorScreenKt.SimplisticMainContent$lambda$5(list, selectedTabIndex, function1, pagerState, function12, function13, function14, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                        return SimplisticMainContent$lambda$5;
                                    }
                                }, $composer2, 54), $composer2, 805306416, 509);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            Object value$iv4 = (Function2) new InspectorScreenKt$SimplisticMainContent$3$1(selectedTabIndex, pagerState, onTabSelectState, null);
                            $composer2.updateRememberedValue(value$iv4);
                            it$iv4 = value$iv4;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv4, $composer2, 0);
                            final TopAppBarScrollBehavior scrollBehavior2 = TopAppBarDefaults.INSTANCE.pinnedScrollBehavior(AppBarKt.rememberTopAppBarState(0.0f, 0.0f, 0.0f, $composer2, 0, 7), (Function0) null, $composer2, TopAppBarDefaults.$stable << 6, 2);
                            onShowSettings = onShowSettings4;
                            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(516283575, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda6
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SimplisticMainContent$lambda$4;
                                    SimplisticMainContent$lambda$4 = InspectorScreenKt.SimplisticMainContent$lambda$4(onShowSettings4, function0, scrollBehavior2, (Composer) obj, ((Integer) obj2).intValue());
                                    return SimplisticMainContent$lambda$4;
                                }
                            }, $composer2, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-358644798, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda7
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    Unit SimplisticMainContent$lambda$5;
                                    SimplisticMainContent$lambda$5 = InspectorScreenKt.SimplisticMainContent$lambda$5(list, selectedTabIndex, function1, pagerState, function12, function13, function14, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    return SimplisticMainContent$lambda$5;
                                }
                            }, $composer2, 54), $composer2, 805306416, 509);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            onShowSettings = function03;
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Function0 function04 = onShowSettings;
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SimplisticMainContent$lambda$6;
                                    SimplisticMainContent$lambda$6 = InspectorScreenKt.SimplisticMainContent$lambda$6(list, selectedTabIndex, function1, function0, function12, function13, function14, function04, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                                    return SimplisticMainContent$lambda$6;
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SimplisticMainContent$lambda$4(final Function0 $onShowSettings, final Function0 $onBack, final TopAppBarScrollBehavior $scrollBehavior, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C684@24320L212,681@24218L314:InspectorScreen.kt#37tpck");
                        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(516283575, $changed, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent.<anonymous> (InspectorScreen.kt:681)");
                            }
                            SurfaceKt.Surface-T9BRK9s((Modifier) null, (Shape) null, Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl((float) 0.5d), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-241807022, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda18
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit SimplisticMainContent$lambda$4$0;
                                    SimplisticMainContent$lambda$4$0 = InspectorScreenKt.SimplisticMainContent$lambda$4$0($onShowSettings, $onBack, $scrollBehavior, (Composer) obj, ((Integer) obj2).intValue());
                                    return SimplisticMainContent$lambda$4$0;
                                }
                            }, $composer, 54), $composer, 12779904, 91);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SimplisticMainContent$lambda$4$0(Function0 $onShowSettings, Function0 $onBack, TopAppBarScrollBehavior $scrollBehavior, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C685@24338L180:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-241807022, $changed, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent.<anonymous>.<anonymous> (InspectorScreen.kt:685)");
                            }
                            MinimalisticTopBar($onShowSettings, $onBack, $scrollBehavior, $composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SimplisticMainContent$lambda$5(final List $visibleTabs, int $selectedTabIndex, Function1 $onTabSelect, PagerState $pagerState, final Function1 $onAdClick, final Function1 $onRequestClick, final Function1 $onReportClick, PaddingValues paddingValues, Composer $composer, int $changed) {
                        Function0 factory$iv$iv$iv;
                        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
                        ComposerKt.sourceInformation($composer, "CN(paddingValues)693@24577L2601:InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed(paddingValues) ? 4 : 2;
                        }
                        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-358644798, $dirty, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent.<anonymous> (InspectorScreen.kt:693)");
                            }
                            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, paddingValues.calculateTopPadding-D9Ej5fM(), 0.0f, 0.0f, 13, (Object) null), ColorKt.Color(4294572795L), (Shape) null, 2, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
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
                            int i2 = ((0 >> 6) & 112) | 6;
                            final ColumnScope $this$SimplisticMainContent_u24lambda_u245_u240 = ColumnScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, -1617771994, "C719@25515L1653,710@25127L2041:InspectorScreen.kt#37tpck");
                            if ($visibleTabs.size() > 1) {
                                $composer.startReplaceGroup(-1617811334);
                                ComposerKt.sourceInformation($composer, "702@24891L188");
                                MinimalistTabStrip($visibleTabs, $selectedTabIndex, $onTabSelect, $composer, 0);
                            } else {
                                $composer.startReplaceGroup(-1642493162);
                            }
                            $composer.endReplaceGroup();
                            PagerKt.HorizontalPager--8jOkeI($pagerState, PaddingKt.padding-VpY3zN4(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(12)), (PaddingValues) null, (PageSize) null, $visibleTabs.size(), Dp.constructor-impl(8), (Alignment.Vertical) null, (TargetedFlingBehavior) null, $visibleTabs.size() > 1, false, (Function1) null, (NestedScrollConnection) null, (SnapPosition) null, (OverscrollEffect) null, ComposableLambdaKt.rememberComposableLambda(463783467, true, new Function4() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda15
                                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                                    Unit SimplisticMainContent$lambda$5$0$0;
                                    SimplisticMainContent$lambda$5$0$0 = InspectorScreenKt.SimplisticMainContent$lambda$5$0$0($this$SimplisticMainContent_u24lambda_u245_u240, $visibleTabs, $onAdClick, $onRequestClick, $onReportClick, (PagerScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                                    return SimplisticMainContent$lambda$5$0$0;
                                }
                            }, $composer, 54), $composer, 196656, 24576, 16076);
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
                    public static final Unit SimplisticMainContent$lambda$5$0$0(ColumnScope $this_Column, final List $visibleTabs, final Function1 $onAdClick, final Function1 $onRequestClick, final Function1 $onReportClick, PagerScope $this$HorizontalPager, final int page, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$HorizontalPager, "$this$HorizontalPager");
                        ComposerKt.sourceInformation($composer, "CN(page)725@25782L7,729@25955L1199,720@25541L1613:InspectorScreen.kt#37tpck");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(463783467, $changed, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:720)");
                        }
                        EnterTransition fadeIn$default = androidx.compose.animation.EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null);
                        FiniteAnimationSpec tween$default = AnimationSpecKt.tween$default(300, 0, (Easing) null, 6, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer, -980678446, "CC(remember):InspectorScreen.kt#9igjgp");
                        Object it$iv = $composer.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = new Function1() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda47
                                public final Object invoke(Object obj) {
                                    int SimplisticMainContent$lambda$5$0$0$0$0;
                                    SimplisticMainContent$lambda$5$0$0$0$0 = InspectorScreenKt.SimplisticMainContent$lambda$5$0$0$0$0(((Integer) obj).intValue());
                                    return Integer.valueOf(SimplisticMainContent$lambda$5$0$0$0$0);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        AnimatedVisibilityKt.AnimatedVisibility($this_Column, true, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), fadeIn$default.plus(androidx.compose.animation.EnterExitTransitionKt.slideInVertically(tween$default, (Function1) it$iv)), (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(233121875, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda48
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit SimplisticMainContent$lambda$5$0$0$1;
                                SimplisticMainContent$lambda$5$0$0$1 = InspectorScreenKt.SimplisticMainContent$lambda$5$0$0$1($visibleTabs, page, $onAdClick, $onRequestClick, $onReportClick, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return SimplisticMainContent$lambda$5$0$0$1;
                            }
                        }, $composer, 54), $composer, 1573296, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final int SimplisticMainContent$lambda$5$0$0$0$0(int it) {
                        return -40;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit SimplisticMainContent$lambda$5$0$0$1(List $visibleTabs, int $page, Function1 $onAdClick, Function1 $onRequestClick, Function1 $onReportClick, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
                        Function0 factory$iv$iv$iv;
                        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
                        ComposerKt.sourceInformation($composer, "C732@26041L1095:InspectorScreen.kt#37tpck");
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(233121875, $changed, -1, "kntr.app.ad.ui.inspector.ui.SimplisticMainContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:730)");
                        }
                        int realTabIndex = ((TabInfo) $visibleTabs.get($page)).getIndex();
                        Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv = (54 << 3) & 112;
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
                        int i2 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -1463655278, "C:InspectorScreen.kt#37tpck");
                        switch (realTabIndex) {
                            case 0:
                                $composer.startReplaceGroup(-601402023);
                                ComposerKt.sourceInformation($composer, "738@26301L108");
                                AdListScreenKt.AdListScreen($onAdClick, null, $composer, 0, 2);
                                $composer.endReplaceGroup();
                                break;
                            case 1:
                                $composer.startReplaceGroup(-601396413);
                                ComposerKt.sourceInformation($composer, "743@26476L118");
                                RequestListScreenKt.RequestListScreen($onRequestClick, null, $composer, 0, 2);
                                $composer.endReplaceGroup();
                                break;
                            case 2:
                                $composer.startReplaceGroup(-601390495);
                                ComposerKt.sourceInformation($composer, "748@26661L116");
                                ReportListScreenKt.ReportListScreen($onReportClick, null, $composer, 0, 2);
                                $composer.endReplaceGroup();
                                break;
                            case 3:
                                $composer.startReplaceGroup(-601384736);
                                ComposerKt.sourceInformation($composer, "753@26844L19");
                                ConsoleListScreenKt.ConsoleListScreen(null, $composer, 0, 1);
                                $composer.endReplaceGroup();
                                break;
                            default:
                                $composer.startReplaceGroup(-601381752);
                                ComposerKt.sourceInformation($composer, "756@26933L155");
                                EmptyViewKt.EmptyView("未知页面", null, "无法显示此页面内容", $composer, 390, 2);
                                $composer.endReplaceGroup();
                                break;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    private static final void MinimalisticTopBar(final Function0<Unit> function0, final Function0<Unit> function02, final TopAppBarScrollBehavior scrollBehavior, Composer $composer, final int $changed) {
                        Composer $composer2;
                        final MutableState showClearCacheDialog$delegate;
                        Composer $composer3 = $composer.startRestartGroup(-868842398);
                        ComposerKt.sourceInformation($composer3, "C(MinimalisticTopBar)N(onShowSettings,onBack,scrollBehavior)776@27440L7,779@27501L24,782@27581L34,821@29189L184,785@27648L1492,827@29434L711,784@27621L2531:InspectorScreen.kt#37tpck");
                        int $dirty = $changed;
                        if (($changed & 48) == 0) {
                            $dirty |= $composer3.changedInstance(function02) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty |= $composer3.changed(scrollBehavior) ? 256 : 128;
                        }
                        int $dirty2 = $dirty;
                        if ($composer3.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-868842398, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar (InspectorScreen.kt:775)");
                            }
                            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer3.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            final UserRole userRole = (UserRole) consume;
                            final long themeColor = userRole.m353getColor0d7_KjU();
                            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
                            Object it$iv$iv = $composer3.rememberedValue();
                            if (it$iv$iv == Composer.Companion.getEmpty()) {
                                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                                $composer3.updateRememberedValue(value$iv$iv);
                                it$iv$iv = value$iv$iv;
                            }
                            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerStart($composer3, -1733879324, "CC(remember):InspectorScreen.kt#9igjgp");
                            Object it$iv = $composer3.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                                $composer3.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            final MutableState showClearCacheDialog$delegate2 = (MutableState) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer2 = $composer3;
                            AppBarKt.TopAppBar-gNPyAyM(ComposableLambdaKt.rememberComposableLambda(10214430, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda27
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit MinimalisticTopBar$lambda$3;
                                    MinimalisticTopBar$lambda$3 = InspectorScreenKt.MinimalisticTopBar$lambda$3(themeColor, userRole, (Composer) obj, ((Integer) obj2).intValue());
                                    return MinimalisticTopBar$lambda$3;
                                }
                            }, $composer3, 54), (Modifier) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(1061758227, true, new Function3() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda28
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    Unit MinimalisticTopBar$lambda$4;
                                    MinimalisticTopBar$lambda$4 = InspectorScreenKt.MinimalisticTopBar$lambda$4(function02, showClearCacheDialog$delegate2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    return MinimalisticTopBar$lambda$4;
                                }
                            }, $composer3, 54), 0.0f, (WindowInsets) null, TopAppBarDefaults.INSTANCE.topAppBarColors-5tl4gsc(Color.Companion.getWhite-0d7_KjU(), 0L, 0L, ColorKt.Color(4279310375L), themeColor, 0L, $composer3, (TopAppBarDefaults.$stable << 18) | 3078, 38), scrollBehavior, (PaddingValues) null, $composer3, (($dirty2 << 15) & 29360128) | 3078, 310);
                            if (MinimalisticTopBar$lambda$1(showClearCacheDialog$delegate2)) {
                                $composer2.startReplaceGroup(2086936763);
                                ComposerKt.sourceInformation($composer2, "857@30255L32,860@30411L347,872@30788L137,856@30211L725");
                                ComposerKt.sourceInformationMarkerStart($composer2, -1733793758, "CC(remember):InspectorScreen.kt#9igjgp");
                                Object it$iv2 = $composer2.rememberedValue();
                                if (it$iv2 == Composer.Companion.getEmpty()) {
                                    showClearCacheDialog$delegate = showClearCacheDialog$delegate2;
                                    Object value$iv2 = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda29
                                        public final Object invoke() {
                                            Unit MinimalisticTopBar$lambda$5$0;
                                            MinimalisticTopBar$lambda$5$0 = InspectorScreenKt.MinimalisticTopBar$lambda$5$0(showClearCacheDialog$delegate);
                                            return MinimalisticTopBar$lambda$5$0;
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv2);
                                    it$iv2 = value$iv2;
                                } else {
                                    showClearCacheDialog$delegate = showClearCacheDialog$delegate2;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) it$iv2, ComposableLambdaKt.rememberComposableLambda(606294965, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda30
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit MinimalisticTopBar$lambda$6;
                                        MinimalisticTopBar$lambda$6 = InspectorScreenKt.MinimalisticTopBar$lambda$6(scope, showClearCacheDialog$delegate, (Composer) obj, ((Integer) obj2).intValue());
                                        return MinimalisticTopBar$lambda$6;
                                    }
                                }, $composer2, 54), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(1587249779, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda31
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit MinimalisticTopBar$lambda$7;
                                        MinimalisticTopBar$lambda$7 = InspectorScreenKt.MinimalisticTopBar$lambda$7(showClearCacheDialog$delegate, (Composer) obj, ((Integer) obj2).intValue());
                                        return MinimalisticTopBar$lambda$7;
                                    }
                                }, $composer2, 54), (Function2) null, ComposableSingletons$InspectorScreenKt.INSTANCE.m361getLambda$1726762703$ad_inspector_debug(), ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$911198352$ad_inspector_debug(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, 1772598, 0, 16276);
                            } else {
                                $composer2.startReplaceGroup(2056953408);
                            }
                            $composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer2 = $composer3;
                            $composer2.skipToGroupEnd();
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda33
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit MinimalisticTopBar$lambda$8;
                                    MinimalisticTopBar$lambda$8 = InspectorScreenKt.MinimalisticTopBar$lambda$8(function0, function02, scrollBehavior, $changed, (Composer) obj, ((Integer) obj2).intValue());
                                    return MinimalisticTopBar$lambda$8;
                                }
                            });
                        }
                    }

                    private static final boolean MinimalisticTopBar$lambda$1(MutableState<Boolean> mutableState) {
                        State $this$getValue$iv = (State) mutableState;
                        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void MinimalisticTopBar$lambda$2(MutableState<Boolean> mutableState, boolean z) {
                        Object value$iv = Boolean.valueOf(z);
                        mutableState.setValue(value$iv);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$3(final long $themeColor, final UserRole $userRole, Composer $composer, int $changed) {
                        Function0 factory$iv$iv$iv;
                        Function0 factory$iv$iv$iv2;
                        ComposerKt.sourceInformation($composer, "C786@27662L1468:InspectorScreen.kt#37tpck");
                        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(10214430, $changed, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar.<anonymous> (InspectorScreen.kt:786)");
                            }
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.Companion;
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
                                $composer.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv3;
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
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i2 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -1816759425, "C788@27762L1354:InspectorScreen.kt#37tpck");
                            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Modifier modifier$iv2 = Modifier.Companion;
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv2 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                                $composer.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv4;
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
                            int i4 = ((0 >> 6) & 112) | 6;
                            RowScope $this$MinimalisticTopBar_u24lambda_u243_u240_u240 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, -1001043761, "C792@27914L10,789@27788L495,800@28304L39,809@28748L350,802@28395L703:InspectorScreen.kt#37tpck");
                            TextKt.Text-Nvy7gAk("AdInspector", (Modifier) null, ColorKt.Color(4279310375L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), 0L, TextUnitKt.getSp(18), FontWeight.Companion.getBold(), FontStyle.box-impl(FontStyle.Companion.getItalic-_-LCdwA()), (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(1), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777073, (Object) null), $composer, 390, 0, 131066);
                            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
                            SurfaceKt.Surface-T9BRK9s($this$MinimalisticTopBar_u24lambda_u243_u240_u240.align(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null), Alignment.Companion.getCenterVertically()), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), Color.copy-wmQWz5c$default($themeColor, 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-406234597, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit MinimalisticTopBar$lambda$3$0$0$0;
                                    MinimalisticTopBar$lambda$3$0$0$0 = InspectorScreenKt.MinimalisticTopBar$lambda$3$0$0$0(UserRole.this, $themeColor, (Composer) obj, ((Integer) obj2).intValue());
                                    return MinimalisticTopBar$lambda$3$0$0$0;
                                }
                            }, $composer, 54), $composer, 12582912, 120);
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

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$3$0$0$0(UserRole $userRole, long $themeColor, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C812@28887L10,810@28774L302:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-406234597, $changed, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InspectorScreen.kt:810)");
                            }
                            TextKt.Text-Nvy7gAk($userRole.getDisplayName(), PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(8), Dp.constructor-impl(4)), $themeColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 48, 0, 131064);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$4(Function0 $onBack, final MutableState $showClearCacheDialog$delegate, RowScope $this$TopAppBar, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter($this$TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C829@29491L31,829@29470L209,845@29953L182:InspectorScreen.kt#37tpck");
                        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1061758227, $changed, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar.<anonymous> (InspectorScreen.kt:829)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer, -1852558446, "CC(remember):InspectorScreen.kt#9igjgp");
                            Object it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda14
                                    public final Object invoke() {
                                        Unit MinimalisticTopBar$lambda$4$0$0;
                                        MinimalisticTopBar$lambda$4$0$0 = InspectorScreenKt.MinimalisticTopBar$lambda$4$0$0($showClearCacheDialog$delegate);
                                        return MinimalisticTopBar$lambda$4$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            IconButtonKt.IconButton((Function0) it$iv, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$1787419569$ad_inspector_debug(), $composer, 1572870, 62);
                            IconButtonKt.IconButton($onBack, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$InspectorScreenKt.INSTANCE.m364getLambda$7406040$ad_inspector_debug(), $composer, 1572864, 62);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$4$0$0(MutableState $showClearCacheDialog$delegate) {
                        MinimalisticTopBar$lambda$2($showClearCacheDialog$delegate, true);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$5$0(MutableState $showClearCacheDialog$delegate) {
                        MinimalisticTopBar$lambda$2($showClearCacheDialog$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$6(final CoroutineScope $scope, final MutableState $showClearCacheDialog$delegate, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C862@30471L201,861@30429L315:InspectorScreen.kt#37tpck");
                        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            $composer.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(606294965, $changed, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar.<anonymous> (InspectorScreen.kt:861)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer, -1466088770, "CC(remember):InspectorScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance($scope);
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda19
                                    public final Object invoke() {
                                        Unit MinimalisticTopBar$lambda$6$0$0;
                                        MinimalisticTopBar$lambda$6$0$0 = InspectorScreenKt.MinimalisticTopBar$lambda$6$0$0($scope, $showClearCacheDialog$delegate);
                                        return MinimalisticTopBar$lambda$6$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$809388568$ad_inspector_debug(), $composer, 805306368, 510);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$6$0$0(CoroutineScope $scope, MutableState $showClearCacheDialog$delegate) {
                        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new InspectorScreenKt$MinimalisticTopBar$4$1$1$1($showClearCacheDialog$delegate, null), 3, (Object) null);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$7(final MutableState $showClearCacheDialog$delegate, Composer $composer, int $changed) {
                        ComposerKt.sourceInformation($composer, "C873@30827L32,873@30806L105:InspectorScreen.kt#37tpck");
                        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1587249779, $changed, -1, "kntr.app.ad.ui.inspector.ui.MinimalisticTopBar.<anonymous> (InspectorScreen.kt:873)");
                            }
                            ComposerKt.sourceInformationMarkerStart($composer, 633648819, "CC(remember):InspectorScreen.kt#9igjgp");
                            Object it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda10
                                    public final Object invoke() {
                                        Unit MinimalisticTopBar$lambda$7$0$0;
                                        MinimalisticTopBar$lambda$7$0$0 = InspectorScreenKt.MinimalisticTopBar$lambda$7$0$0($showClearCacheDialog$delegate);
                                        return MinimalisticTopBar$lambda$7$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ButtonKt.TextButton((Function0) it$iv, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$InspectorScreenKt.INSTANCE.getLambda$1790343382$ad_inspector_debug(), $composer, 805306374, 510);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        } else {
                            $composer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalisticTopBar$lambda$7$0$0(MutableState $showClearCacheDialog$delegate) {
                        MinimalisticTopBar$lambda$2($showClearCacheDialog$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:77:0x03db, code lost:
                        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    private static final void MinimalistTabStrip(final List<TabInfo> list, final int selectedTabIndex, final Function1<? super Integer, Unit> function1, Composer $composer, final int $changed) {
                        Composer $composer2;
                        Function0 factory$iv$iv$iv;
                        Function0 factory$iv$iv$iv2;
                        Object it$iv;
                        int $dirty;
                        Function0 factory$iv$iv$iv3;
                        Function0 factory$iv$iv$iv4;
                        Composer $composer3;
                        int i = selectedTabIndex;
                        final Function1<? super Integer, Unit> function12 = function1;
                        Composer $composer4 = $composer.startRestartGroup(-935545141);
                        ComposerKt.sourceInformation($composer4, "C(MinimalistTabStrip)N(visibleTabs,selectedTabIndex,onTabSelect)887@31120L7,888@31138L3147:InspectorScreen.kt#37tpck");
                        int $dirty2 = $changed;
                        if (($changed & 6) == 0) {
                            $dirty2 |= $composer4.changedInstance(list) ? 4 : 2;
                        }
                        if (($changed & 48) == 0) {
                            $dirty2 |= $composer4.changed(i) ? 32 : 16;
                        }
                        if (($changed & 384) == 0) {
                            $dirty2 |= $composer4.changedInstance(function12) ? 256 : 128;
                        }
                        if (!$composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
                            $composer2 = $composer4;
                            $composer2.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-935545141, $dirty2, -1, "kntr.app.ad.ui.inspector.ui.MinimalistTabStrip (InspectorScreen.kt:886)");
                            }
                            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer4.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            long themeColor = ((UserRole) consume).m353getColor0d7_KjU();
                            Modifier modifier$iv = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(4)), Dp.constructor-impl(44));
                            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                            int $changed$iv$iv = (6 << 3) & 112;
                            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv = factory$iv$iv$iv5;
                                $composer4.createNode(factory$iv$iv$iv);
                            } else {
                                factory$iv$iv$iv = factory$iv$iv$iv5;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                            long themeColor2 = themeColor;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                            int i2 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            int i3 = ((6 >> 6) & 112) | 6;
                            BoxScope $this$MinimalistTabStrip_u24lambda_u240 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -48410971, "C896@31342L233,905@31585L2694:InspectorScreen.kt#37tpck");
                            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default($this$MinimalistTabStrip_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), 0.0f, 1, (Object) null), Dp.constructor-impl(1), ColorKt.Color(4293257195L), $composer4, 432, 0);
                            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                            String str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                            int $changed$iv$iv2 = (438 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            Composer $composer$iv$iv$iv = $composer4;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv$iv$iv.startReusableNode();
                            if ($composer$iv$iv$iv.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer$iv$iv$iv.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                            Composer $composer$iv = $composer$iv$iv$iv;
                            String str4 = "C101@5233L9:Row.kt#2w3rfo";
                            ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i5 = ((438 >> 6) & 112) | 6;
                            Composer $composer5 = $composer$iv;
                            ComposerKt.sourceInformationMarkerStart($composer5, 1529386981, "C:InspectorScreen.kt#37tpck");
                            $composer5.startReplaceGroup(-1890327214);
                            ComposerKt.sourceInformation($composer5, "*921@32363L39,923@32485L22,916@32127L1997");
                            List<TabInfo> $this$forEachIndexed$iv = list;
                            boolean z = false;
                            int index$iv = 0;
                            for (Object item$iv : $this$forEachIndexed$iv) {
                                int index$iv2 = index$iv + 1;
                                if (index$iv < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                TabInfo tab = (TabInfo) item$iv;
                                final int index = index$iv;
                                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                boolean selected = index == i;
                                long contentColor = selected ? themeColor2 : ColorKt.Color(4285231744L);
                                long labelSize = selected ? TextUnitKt.getSp(14) : TextUnitKt.getSp(13);
                                FontWeight.Companion companion = FontWeight.Companion;
                                FontWeight fontWeight = selected ? companion.getMedium() : companion.getNormal();
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                                Modifier modifier = Modifier.Companion;
                                boolean z2 = z;
                                int $changed$iv$iv$iv3 = $changed$iv$iv$iv2;
                                ComposerKt.sourceInformationMarkerStart($composer5, 212844100, "CC(remember):InspectorScreen.kt#9igjgp");
                                Composer $this$cache$iv = $composer5;
                                Object it$iv2 = $this$cache$iv.rememberedValue();
                                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                                if (it$iv2 == Composer.Companion.getEmpty()) {
                                    Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                                    $this$cache$iv.updateRememberedValue(MutableInteractionSource);
                                    it$iv = MutableInteractionSource;
                                } else {
                                    it$iv = it$iv2;
                                }
                                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                ComposerKt.sourceInformationMarkerStart($composer5, 212847987, "CC(remember):InspectorScreen.kt#9igjgp");
                                boolean invalid$iv = (($dirty2 & 896) == 256) | $composer4.changed(index);
                                Composer $this$cache$iv2 = $composer5;
                                Object it$iv3 = $this$cache$iv2.rememberedValue();
                                if (invalid$iv) {
                                    $dirty = $dirty2;
                                } else {
                                    $dirty = $dirty2;
                                }
                                Object value$iv = new Function0() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda21
                                    public final Object invoke() {
                                        Unit MinimalistTabStrip$lambda$0$0$0$1$0;
                                        MinimalistTabStrip$lambda$0$0$0$1$0 = InspectorScreenKt.MinimalistTabStrip$lambda$0$0$0$1$0(function12, index);
                                        return MinimalistTabStrip$lambda$0$0$0$1$0;
                                    }
                                };
                                $this$cache$iv2.updateRememberedValue(value$iv);
                                it$iv3 = value$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer5);
                                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                                Composer $composer$iv2 = $composer5;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                                int $changed$iv$iv3 = (384 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str);
                                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                                CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3);
                                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                                Composer $composer6 = $composer4;
                                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str2);
                                if (!($composer$iv2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer$iv2.startReusableNode();
                                if ($composer$iv2.getInserting()) {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                                    $composer$iv2.createNode(factory$iv$iv$iv3);
                                } else {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv7;
                                    $composer$iv2.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv2);
                                Composer $composer$iv3 = $composer$iv;
                                Composer $composer7 = $composer5;
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                int i6 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                                int i7 = ((384 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1363235892, "C926@32606L1003,952@33660L446:InspectorScreen.kt#37tpck");
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                                Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, str3);
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                                int $changed$iv$iv4 = (390 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str);
                                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                                String str5 = str;
                                CompositionLocalMap localMap$iv$iv4 = $composer$iv2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv4);
                                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                                String str6 = str3;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str2);
                                if (!($composer$iv2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer$iv2.startReusableNode();
                                if ($composer$iv2.getInserting()) {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                    $composer$iv2.createNode(factory$iv$iv$iv4);
                                } else {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv8;
                                    $composer$iv2.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
                                String str7 = str2;
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                int i8 = ($changed$iv$iv$iv5 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, str4);
                                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                                int i9 = ((390 >> 6) & 112) | 6;
                                String str8 = str4;
                                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1501841048, "C930@32799L248,937@33073L39,942@33272L10,939@33138L449:InspectorScreen.kt#37tpck");
                                IconKt.Icon-ww6aTOc(tab.getIcon(), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), contentColor, $composer$iv2, 432, 0);
                                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer$iv2, 6);
                                TextKt.Text-Nvy7gAk(tab.getTitle(), (Modifier) null, contentColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(MaterialTheme.INSTANCE.getTypography($composer$iv2, MaterialTheme.$stable).getBodyMedium(), 0L, labelSize, fontWeight, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, TextUnitKt.getSp(0), (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777081, (Object) null), $composer$iv2, 0, 0, 131066);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                $composer$iv2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                long themeColor3 = themeColor2;
                                BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), selected ? Dp.constructor-impl(20) : Dp.constructor-impl(0)), themeColor3, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(1), Dp.constructor-impl(1), 0.0f, 0.0f, 12, (Object) null)), $composer$iv2, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                $composer$iv2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                if (index < list.size() - 1) {
                                    $composer3 = $composer7;
                                    $composer3.startReplaceGroup(-1989967754);
                                    ComposerKt.sourceInformation($composer3, "965@34198L39");
                                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
                                } else {
                                    $composer3 = $composer7;
                                    $composer3.startReplaceGroup(-2023873787);
                                }
                                $composer3.endReplaceGroup();
                                i = selectedTabIndex;
                                function12 = function1;
                                themeColor2 = themeColor3;
                                $composer5 = $composer3;
                                index$iv = index$iv2;
                                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                z = z2;
                                $changed$iv$iv$iv2 = $changed$iv$iv$iv3;
                                materialized$iv$iv2 = materialized$iv$iv3;
                                $dirty2 = $dirty;
                                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                                $composer4 = $composer6;
                                $composer$iv = $composer$iv3;
                                str = str5;
                                str3 = str6;
                                str2 = str7;
                                str4 = str8;
                            }
                            $composer2 = $composer4;
                            Composer $composer8 = $composer5;
                            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                            $composer8.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer8);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv);
                            $composer$iv$iv$iv3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.InspectorScreenKt$$ExternalSyntheticLambda32
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit MinimalistTabStrip$lambda$1;
                                    MinimalistTabStrip$lambda$1 = InspectorScreenKt.MinimalistTabStrip$lambda$1(list, selectedTabIndex, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                                    return MinimalistTabStrip$lambda$1;
                                }
                            });
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit MinimalistTabStrip$lambda$0$0$0$1$0(Function1 $onTabSelect, int $index) {
                        $onTabSelect.invoke(Integer.valueOf($index));
                        return Unit.INSTANCE;
                    }
                }