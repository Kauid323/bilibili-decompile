package kntr.app.game.gamebind.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.biligame.kntr.common.PlatformConfigKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.font.GameFontWeight_androidKt;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.ui.widget.BiligameAlertDialogKt;
import kntr.app.game.base.viewmodel.BaseViewModel;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.gamebind.RolesListViewModel;
import kntr.app.game.gamebind.bean.RoleItem;
import kntr.app.game.gamebind.bean.RoleMenuItem;
import kntr.app.game.gamebind.bean.RolesListData;
import kntr.app.game.gamebind.bean.SectionItem;
import kntr.app.game.gamebind.bean.UnbindRoleItem;
import kntr.app.game.gamebind.ui.item.GameItemViewKt;
import kntr.app.game.gamebind.ui.item.RoleItemViewKt;
import kntr.app.game.gamebind.ui.report.ReporterKt;
import kntr.app.game.gamebind.ui.sheet.RoleMenuSheetKt;
import kntr.app.game.gamebind.ui.sheet.RoleSwitchSheetKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.compose.res.CommonRes;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.game.game.bind.ui.generated.resources.Res;
import srcs.app.game.game.bind.ui.generated.resources.String0_commonMainKt;

/* compiled from: RoleListPage.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0010\u001a\u00020\u0011X\u008a\u0084\u0002"}, d2 = {"RoleListPage", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.MID, RoomRecommendViewModel.EMPTY_CURSOR, "isMyself", RoomRecommendViewModel.EMPTY_CURSOR, RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "isMineTab", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(JZLjava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug", "openBottomSheet", "menuState", "Lkntr/app/game/gamebind/RolesListViewModel$MenuState;"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoleListPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$2(long j2, boolean z, String str, Modifier modifier, boolean z2, ScrollState scrollState, int i, int i2, Composer composer, int i3) {
        RoleListPage(j2, z, str, modifier, z2, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void RoleListPage(final long mid, final boolean isMyself, final String sourceFrom, Modifier modifier, boolean isMineTab, ScrollState scrollState, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isMineTab2;
        ScrollState scrollState2;
        Modifier modifier3;
        boolean isMineTab3;
        ScrollState scrollState3;
        int $dirty;
        Modifier modifier4;
        int i2;
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-1866111443);
        ComposerKt.sourceInformation($composer2, "C(RoleListPage)N(mid,isMyself,sourceFrom,modifier,isMineTab,scrollState)93@4329L47,93@4319L57,99@4457L11933,91@4279L12111:RoleListPage.kt#ualdgv");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(mid) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(isMyself) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(sourceFrom) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            isMineTab2 = isMineTab;
        } else if (($changed & 24576) == 0) {
            isMineTab2 = isMineTab;
            $dirty2 |= $composer2.changed(isMineTab2) ? 16384 : 8192;
        } else {
            isMineTab2 = isMineTab;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                scrollState2 = scrollState;
                if ($composer2.changed(scrollState2)) {
                    i2 = 131072;
                    $dirty2 |= i2;
                }
            } else {
                scrollState2 = scrollState;
            }
            i2 = 65536;
            $dirty2 |= i2;
        } else {
            scrollState2 = scrollState;
        }
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "90@4251L22");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier modifier5 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
                if (i4 != 0) {
                    isMineTab2 = false;
                }
                if ((i & 32) != 0) {
                    $dirty = $dirty2 & (-458753);
                    modifier4 = modifier5;
                    scrollState3 = ScrollKt.rememberScrollState(0, $composer2, 6, 0);
                    isMineTab3 = isMineTab2;
                } else {
                    $dirty = $dirty2;
                    modifier4 = modifier5;
                    isMineTab3 = isMineTab2;
                    scrollState3 = scrollState2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty2 &= -458753;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                isMineTab3 = isMineTab2;
                scrollState3 = scrollState2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1866111443, $dirty, -1, "kntr.app.game.gamebind.ui.RoleListPage (RoleListPage.kt:91)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1963241244, "CC(remember):RoleListPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        RolesListViewModel RoleListPage$lambda$0$0;
                        RoleListPage$lambda$0$0 = RoleListPageKt.RoleListPage$lambda$0$0(mid, (CreationExtras) obj);
                        return RoleListPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 initializer$iv = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer2, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RolesListViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(RolesListViewModel.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            BaseViewModel baseViewModel = (BaseViewModel) viewModel;
            final boolean z = isMineTab3;
            final Modifier modifier6 = modifier4;
            final ScrollState scrollState4 = scrollState3;
            Modifier modifier7 = modifier4;
            LoadComposableKt.LoadComposable(baseViewModel, sourceFrom, null, false, true, ComposableLambdaKt.rememberComposableLambda(-1029585913, true, new Function5() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit RoleListPage$lambda$1;
                    RoleListPage$lambda$1 = RoleListPageKt.RoleListPage$lambda$1(z, isMyself, modifier6, scrollState4, sourceFrom, (RolesListData) obj, (RolesListViewModel) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return RoleListPage$lambda$1;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 112) | 224256, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier7;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isMineTab3 = isMineTab2;
            scrollState3 = scrollState2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            final boolean z2 = isMineTab3;
            final ScrollState scrollState5 = scrollState3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoleListPage$lambda$2;
                    RoleListPage$lambda$2 = RoleListPageKt.RoleListPage$lambda$2(mid, isMyself, sourceFrom, modifier8, z2, scrollState5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RoleListPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RolesListViewModel RoleListPage$lambda$0$0(long $mid, CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new RolesListViewModel($mid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0dec  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0df5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0e1f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x1043  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x106a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x1131  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x1361  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x05ef  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05f5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0661  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0885  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x08b7 A[LOOP:0: B:95:0x08b1->B:97:0x08b7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x09c8  */
    /* JADX WARN: Type inference failed for: r5v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RoleListPage$lambda$1(final boolean $isMineTab, final boolean $isMyself, Modifier $modifier, ScrollState $scrollState, String $sourceFrom, RolesListData data, final RolesListViewModel viewModel, PageLoadMoreState pageLoadMoreState, Composer $composer, int $changed) {
        Composer $this$cache$iv;
        MutableState openBottomSheet$delegate;
        Unit unit;
        int i;
        Ref.BooleanRef bottomSheetShowing;
        Function1 onRoleItemClick;
        String str;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        List list;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        String str2;
        String str3;
        Composer $composer$iv$iv$iv2;
        final boolean z;
        CoroutineScope scope;
        Composer $composer$iv2;
        Function1 onRoleItemClick2;
        Function2 onRoleItemExpose;
        boolean z2;
        Function1 onRoleMenuClick;
        Composer $composer2;
        List list2;
        String str4;
        String str5;
        Composer $composer3;
        RolesListViewModel.MenuState RoleListPage$lambda$1$10$4;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Iterable $this$forEach$iv;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv5;
        Composer $composer$iv4;
        MeasurePolicy measurePolicy$iv$iv;
        String str6;
        MeasurePolicy measurePolicy$iv$iv2;
        String str7;
        Composer $composer$iv$iv$iv3;
        Iterator it;
        Function0 factory$iv$iv$iv6;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(pageLoadMoreState, "$unused$var$");
        ComposerKt.sourceInformation($composer, "CN(data,viewModel)100@4497L24,102@4556L129,108@4720L277,118@5033L159,124@5227L154,130@5420L234,137@5684L18,138@5747L25,138@5730L42,139@5777L179,144@5988L7,145@6021L439,145@6000L460,162@6524L6,162@6465L9923:RoleListPage.kt#ualdgv");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1029585913, $changed, -1, "kntr.app.game.gamebind.ui.RoleListPage.<anonymous> (RoleListPage.kt:100)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        final CoroutineScope scope2 = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1589581016, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit RoleListPage$lambda$1$0$0;
                    RoleListPage$lambda$1$0$0 = RoleListPageKt.RoleListPage$lambda$1$0$0($isMyself, $isMineTab, (RoleItem) obj);
                    return RoleListPage$lambda$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        Function1 onRoleItemClick3 = (Function1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1589575620, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new Function1() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj) {
                    Unit RoleListPage$lambda$1$1$0;
                    RoleListPage$lambda$1$1$0 = RoleListPageKt.RoleListPage$lambda$1$1$0($isMineTab, scope2, viewModel, (RoleItem) obj);
                    return RoleListPage$lambda$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        Function1 onRoleMenuClick2 = (Function1) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1589565722, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv3 = $composer.rememberedValue();
        if (it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = new Function2() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoleListPage$lambda$1$2$0;
                    RoleListPage$lambda$1$2$0 = RoleListPageKt.RoleListPage$lambda$1$2$0($isMyself, $isMineTab, (RoleItem) obj, ((Boolean) obj2).booleanValue());
                    return RoleListPage$lambda$1$2$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        Function2 onRoleItemExpose2 = (Function2) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1589559519, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv4 = $composer.rememberedValue();
        if (it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = new Function2() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoleListPage$lambda$1$3$0;
                    RoleListPage$lambda$1$3$0 = RoleListPageKt.RoleListPage$lambda$1$3$0($isMineTab, (UnbindRoleItem) obj, ((Boolean) obj2).booleanValue());
                    return RoleListPage$lambda$1$3$0;
                }
            };
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        Function2 onGameItemClick = (Function2) it$iv4;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1589553263, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv5 = $composer.rememberedValue();
        if (it$iv5 == Composer.Companion.getEmpty()) {
            Object value$iv5 = new Function2() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Job RoleListPage$lambda$1$4$0;
                    RoleListPage$lambda$1$4$0 = RoleListPageKt.RoleListPage$lambda$1$4$0(scope2, viewModel, (RoleItem) obj, (RoleMenuItem) obj2);
                    return RoleListPage$lambda$1$4$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
        }
        final Function2 onRoleMenuItemClick = (Function2) it$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Ref.BooleanRef bottomSheetShowing2 = new Ref.BooleanRef();
        ComposerKt.sourceInformationMarkerStart($composer, -1589545031, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv6 = $composer.rememberedValue();
        if (it$iv6 == Composer.Companion.getEmpty()) {
            $composer.updateRememberedValue(false);
            it$iv6 = false;
        }
        boolean booleanValue = ((Boolean) it$iv6).booleanValue();
        ComposerKt.sourceInformationMarkerEnd($composer);
        bottomSheetShowing2.element = booleanValue;
        Object[] objArr = new Object[0];
        ComposerKt.sourceInformationMarkerStart($composer, -1589543008, "CC(remember):RoleListPage.kt#9igjgp");
        Object it$iv7 = $composer.rememberedValue();
        if (it$iv7 == Composer.Companion.getEmpty()) {
            Object value$iv6 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    MutableState RoleListPage$lambda$1$6$0;
                    RoleListPage$lambda$1$6$0 = RoleListPageKt.RoleListPage$lambda$1$6$0();
                    return RoleListPage$lambda$1$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv7 = value$iv6;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        MutableState openBottomSheet$delegate2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) it$iv7, $composer, 48);
        CoroutineScope scope3 = scope2;
        EffectsKt.LaunchedEffect(Boolean.valueOf(RoleListPage$lambda$1$7(openBottomSheet$delegate2)), new RoleListPageKt$RoleListPage$2$1(bottomSheetShowing2, viewModel, openBottomSheet$delegate2, null), $composer, 0);
        CompositionLocal this_$iv = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Toaster toaster = (Toaster) consume;
        Unit unit2 = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1589533826, "CC(remember):RoleListPage.kt#9igjgp");
        boolean invalid$iv = $composer.changed($isMineTab) | $composer.changed($isMyself) | $composer.changedInstance(viewModel) | $composer.changedInstance(toaster);
        Object value$iv7 = $composer.rememberedValue();
        if (invalid$iv) {
            $this$cache$iv = $composer;
        } else {
            $this$cache$iv = $composer;
            if (value$iv7 != Composer.Companion.getEmpty()) {
                openBottomSheet$delegate = openBottomSheet$delegate2;
                unit = unit2;
                bottomSheetShowing = bottomSheetShowing2;
                onRoleItemClick = onRoleItemClick3;
                i = 48;
                str = "CC(remember):RoleListPage.kt#9igjgp";
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv7, $composer, 6);
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Function1 onRoleMenuClick3 = onRoleMenuClick2;
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                Function2 onRoleItemExpose3 = onRoleItemExpose2;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer.createNode(factory$iv$iv$iv);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                Toaster toaster2 = toaster;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i3 = ((0 >> 6) & 112) | 6;
                BoxScope $this$RoleListPage_u24lambda_u241_u2410 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -828453109, "C163@6547L4471,281@11982L55:RoleListPage.kt#ualdgv");
                Modifier modifier$iv2 = ScrollKt.verticalScroll$default(Modifier.Companion, $scrollState, true, (FlingBehavior) null, false, 12, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                Composer $composer$iv5 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer.useNode();
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv8;
                    $composer.createNode(factory$iv$iv$iv2);
                }
                Function0 factory$iv$iv$iv9 = factory$iv$iv$iv2;
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Modifier materialized$iv$iv3 = materialized$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -2050184524, "C256@10941L67:RoleListPage.kt#ualdgv");
                final List roles = data.getRoles();
                list = roles;
                if (list != null || list.isEmpty()) {
                    $composer.startReplaceGroup(-2050198847);
                    ComposerKt.sourceInformation($composer, "168@6795L104,168@6765L134,166@6693L1886");
                    Modifier modifier = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer, -343228085, str);
                    boolean invalid$iv2 = $composer.changedInstance(roles) | $composer.changed($isMineTab) | $composer.changed($isMyself);
                    Object value$iv8 = $composer.rememberedValue();
                    if (!invalid$iv2 && value$iv8 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier$iv3 = ExposerKt.reportOnExposure(modifier, "role_list", null, null, null, value$iv8, $composer, 54, 14);
                        Composer $composer$iv6 = $composer;
                        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv;
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        $composer$iv3 = $composer;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer$iv3.getCurrentCompositionLocalMap();
                        $composer$iv$iv$iv = $composer;
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv3);
                        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        Alignment.Horizontal horizontalAlignment$iv2 = horizontalAlignment$iv;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer$iv3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv3.startReusableNode();
                        if ($composer$iv3.getInserting()) {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer$iv3.useNode();
                        } else {
                            factory$iv$iv$iv5 = factory$iv$iv$iv10;
                            $composer$iv3.createNode(factory$iv$iv$iv5);
                        }
                        Function0 factory$iv$iv$iv11 = factory$iv$iv$iv5;
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv3);
                        Arrangement.Vertical verticalArrangement$iv2 = verticalArrangement$iv;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        CompositionLocalMap localMap$iv$iv4 = localMap$iv$iv3;
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        Composer $composer4 = $composer$iv3;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1859445659, "C:RoleListPage.kt#ualdgv");
                        if ($isMyself) {
                            $composer$iv4 = $composer$iv3;
                            measurePolicy$iv$iv = measurePolicy$iv3;
                            str6 = str;
                            measurePolicy$iv$iv2 = measurePolicy$iv2;
                            str7 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            $composer$iv$iv$iv3 = $composer;
                            $composer4.startReplaceGroup(1852508974);
                        } else {
                            $composer4.startReplaceGroup(1859442031);
                            ComposerKt.sourceInformation($composer4, "173@6981L1007");
                            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl(4), 0.0f, 0.0f, 12, (Object) null);
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                            $composer$iv4 = $composer$iv3;
                            measurePolicy$iv$iv = measurePolicy$iv3;
                            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                            int $changed$iv$iv4 = (390 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                            CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                            str6 = str;
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            measurePolicy$iv$iv2 = measurePolicy$iv2;
                            $composer$iv$iv$iv3 = $composer;
                            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                $composer4.createNode(factory$iv$iv$iv6);
                            } else {
                                factory$iv$iv$iv6 = factory$iv$iv$iv12;
                                $composer4.useNode();
                            }
                            str7 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                            int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            int i9 = ((390 >> 6) & 112) | 6;
                            RowScope $this$RoleListPage_u24lambda_u241_u2410_u240_u241_u240 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1428337243, "C175@7164L49,176@7265L9,178@7389L6,174@7119L383,183@7643L9,184@7708L6,181@7531L431:RoleListPage.kt#ualdgv");
                            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_has_bind_list(Res.string.INSTANCE), $composer4, 0), $this$RoleListPage_u24lambda_u241_u2410_u240_u241_u240.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, 0, 0, 131000);
                            TextKt.Text-Nvy7gAk(String.valueOf(roles.size()), $this$RoleListPage_u24lambda_u241_u2410_u240_u241_u240.alignByBaseline(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), $composer4, 0, 0, 131064);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                        }
                        $composer4.endReplaceGroup();
                        $composer4.startReplaceGroup(-2018193857);
                        ComposerKt.sourceInformation($composer4, "*194@8080L459");
                        List $this$forEach$iv2 = roles;
                        boolean z3 = false;
                        it = $this$forEach$iv2.iterator();
                        while (it.hasNext()) {
                            Object element$iv = it.next();
                            Composer $composer$iv7 = $composer$iv5;
                            Function0 factory$iv$iv$iv13 = factory$iv$iv$iv9;
                            Composer $composer$iv8 = $composer$iv3;
                            Alignment.Horizontal horizontalAlignment$iv3 = horizontalAlignment$iv2;
                            Function0 factory$iv$iv$iv14 = factory$iv$iv$iv11;
                            Composer $composer5 = $composer4;
                            Composer $composer$iv9 = $composer$iv6;
                            Function1 onRoleItemClick4 = onRoleItemClick;
                            Function1 onRoleMenuClick4 = onRoleMenuClick3;
                            Function2 onRoleItemExpose4 = onRoleItemExpose3;
                            RoleItemViewKt.RoleItemView((RoleItem) element$iv, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 8, (Object) null), $isMyself, $sourceFrom, onRoleItemClick4, onRoleMenuClick4, onRoleItemExpose4, $composer5, 1794096, 0);
                            $this$forEach$iv2 = $this$forEach$iv2;
                            z3 = z3;
                            $composer4 = $composer5;
                            scope3 = scope3;
                            roles = roles;
                            str6 = str6;
                            onRoleMenuClick3 = onRoleMenuClick4;
                            onRoleItemExpose3 = onRoleItemExpose4;
                            horizontalAlignment$iv2 = horizontalAlignment$iv3;
                            it = it;
                            measurePolicy$iv$iv = measurePolicy$iv$iv;
                            measurePolicy$iv$iv3 = measurePolicy$iv$iv3;
                            factory$iv$iv$iv9 = factory$iv$iv$iv13;
                            materialized$iv$iv3 = materialized$iv$iv3;
                            $composer$iv4 = $composer$iv4;
                            onRoleItemClick = onRoleItemClick4;
                            verticalArrangement$iv2 = verticalArrangement$iv2;
                            $composer$iv6 = $composer$iv9;
                            factory$iv$iv$iv11 = factory$iv$iv$iv14;
                            $composer$iv3 = $composer$iv8;
                            $composer$iv5 = $composer$iv7;
                            localMap$iv$iv4 = localMap$iv$iv4;
                            toaster2 = toaster2;
                        }
                        $composer$iv2 = $composer$iv5;
                        onRoleItemClick2 = onRoleItemClick;
                        onRoleMenuClick = onRoleMenuClick3;
                        onRoleItemExpose = onRoleItemExpose3;
                        str2 = str6;
                        z2 = false;
                        z = $isMyself;
                        Composer $composer6 = $composer4;
                        scope = scope3;
                        $composer$iv = $composer$iv6;
                        str3 = str7;
                        $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                        $composer6.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        $composer$iv3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer.endReplaceGroup();
                        $composer2 = $composer;
                    }
                    value$iv8 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit RoleListPage$lambda$1$10$0$0$0;
                            RoleListPage$lambda$1$10$0$0$0 = RoleListPageKt.RoleListPage$lambda$1$10$0$0$0(roles, $isMineTab, $isMyself);
                            return RoleListPage$lambda$1$10$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv32 = ExposerKt.reportOnExposure(modifier, "role_list", null, null, null, value$iv8, $composer, 54, 14);
                    Composer $composer$iv62 = $composer;
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv4 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv$iv32 = measurePolicy$iv;
                    MeasurePolicy measurePolicy$iv32 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv4, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv32 = (0 << 3) & 112;
                    $composer$iv3 = $composer;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                    CompositionLocalMap localMap$iv$iv32 = $composer$iv3.getCurrentCompositionLocalMap();
                    $composer$iv$iv$iv = $composer;
                    Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv32);
                    Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
                    Alignment.Horizontal horizontalAlignment$iv22 = horizontalAlignment$iv4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer$iv3.getApplier() instanceof Applier)) {
                    }
                    $composer$iv3.startReusableNode();
                    if ($composer$iv3.getInserting()) {
                    }
                    Function0 factory$iv$iv$iv112 = factory$iv$iv$iv5;
                    Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer$iv3);
                    Arrangement.Vertical verticalArrangement$iv22 = verticalArrangement$iv3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    CompositionLocalMap localMap$iv$iv42 = localMap$iv$iv32;
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                    int i62 = ($changed$iv$iv$iv32 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                    int i72 = ((0 >> 6) & 112) | 6;
                    Composer $composer42 = $composer$iv3;
                    ComposerKt.sourceInformationMarkerStart($composer42, 1859445659, "C:RoleListPage.kt#ualdgv");
                    if ($isMyself) {
                    }
                    $composer42.endReplaceGroup();
                    $composer42.startReplaceGroup(-2018193857);
                    ComposerKt.sourceInformation($composer42, "*194@8080L459");
                    List $this$forEach$iv22 = roles;
                    boolean z32 = false;
                    it = $this$forEach$iv22.iterator();
                    while (it.hasNext()) {
                    }
                    $composer$iv2 = $composer$iv5;
                    onRoleItemClick2 = onRoleItemClick;
                    onRoleMenuClick = onRoleMenuClick3;
                    onRoleItemExpose = onRoleItemExpose3;
                    str2 = str6;
                    z2 = false;
                    z = $isMyself;
                    Composer $composer62 = $composer42;
                    scope = scope3;
                    $composer$iv = $composer$iv62;
                    str3 = str7;
                    $composer$iv$iv$iv2 = $composer$iv$iv$iv3;
                    $composer62.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer62);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer.endReplaceGroup();
                    $composer2 = $composer;
                } else {
                    $composer$iv$iv$iv = $composer;
                    $composer$iv = $composer;
                    str2 = str;
                    str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    $composer$iv$iv$iv2 = $composer;
                    z = $isMyself;
                    scope = scope3;
                    $composer$iv2 = $composer$iv5;
                    onRoleItemClick2 = onRoleItemClick;
                    onRoleItemExpose = onRoleItemExpose3;
                    z2 = false;
                    onRoleMenuClick = onRoleMenuClick3;
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(-2056880897);
                    $composer2.endReplaceGroup();
                }
                final List gameList = data.getGameList();
                list2 = gameList;
                if (((list2 != null || list2.isEmpty()) ? true : z2) && z) {
                    $composer2.startReplaceGroup(-2048191225);
                    ComposerKt.sourceInformation($composer2, "210@8843L109,210@8813L139,208@8708L1444,*243@10433L107,243@10393L147,240@10222L396,251@10825L6,248@10639L219");
                    Modifier modifier2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(20), 0.0f, 0.0f, 12, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer2, -343162544, str2);
                    boolean invalid$iv3 = $composer2.changedInstance(gameList) | $composer2.changed($isMineTab) | $composer2.changed(z);
                    Composer $this$cache$iv2 = $composer2;
                    Object it$iv8 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv3 || it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv9 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda17
                            public final Object invoke() {
                                Unit RoleListPage$lambda$1$10$0$2$0;
                                RoleListPage$lambda$1$10$0$2$0 = RoleListPageKt.RoleListPage$lambda$1$10$0$2$0(gameList, $isMineTab, z);
                                return RoleListPage$lambda$1$10$0$2$0;
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv9);
                        it$iv8 = value$iv9;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Modifier modifier$iv5 = ExposerKt.reportOnExposure(modifier2, "game_list", null, null, null, (Function0) it$iv8, $composer2, 54, 14);
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                    Composer $composer$iv10 = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv10, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv10, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv5 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv10, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv10, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer$iv10.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv10, modifier$iv5);
                    Function0 factory$iv$iv$iv15 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv10, -553112988, str3);
                    if (!($composer$iv10.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv10.startReusableNode();
                    if ($composer$iv10.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv15;
                        $composer$iv10.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv15;
                        $composer$iv10.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv10);
                    str5 = str3;
                    str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv10, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i11 = ((384 >> 6) & 112) | 6;
                    RowScope $this$RoleListPage_u24lambda_u241_u2410_u240_u243 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv10, -456181958, "C217@9161L9,219@9269L6,215@9062L304,224@9486L9,225@9543L6,222@9387L414,233@9859L55,234@9958L9,235@10015L6,232@9822L312:RoleListPage.kt#ualdgv");
                    TextKt.Text-Nvy7gAk(PlatformConfigKt.getWaitBindTitle(), $this$RoleListPage_u24lambda_u241_u2410_u240_u243.alignByBaseline(Modifier.Companion), BiliTheme.INSTANCE.getColors($composer$iv10, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv10, BiliTheme.$stable).getT14(), $composer$iv10, 0, 0, 131000);
                    TextKt.Text-Nvy7gAk(String.valueOf(gameList.size()), $this$RoleListPage_u24lambda_u241_u2410_u240_u243.alignByBaseline(RowScope.-CC.weight$default($this$RoleListPage_u24lambda_u241_u2410_u240_u243, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv10, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv10, BiliTheme.$stable).getT13(), $composer$iv10, 0, 0, 131064);
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_wait_bind_list_desc(Res.string.INSTANCE), $composer$iv10, 0), $this$RoleListPage_u24lambda_u241_u2410_u240_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv10, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv10, BiliTheme.$stable).getT13(), $composer$iv10, 0, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                    $composer$iv10.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv10);
                    List $this$forEach$iv3 = gameList;
                    for (Object element$iv2 : $this$forEach$iv3) {
                        final UnbindRoleItem unbindRole = (UnbindRoleItem) element$iv2;
                        Modifier modifier3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null);
                        Integer valueOf = Integer.valueOf(unbindRole.getGameBaseId());
                        ComposerKt.sourceInformationMarkerStart($composer2, -1087657410, str2);
                        boolean invalid$iv4 = $composer2.changedInstance(unbindRole) | $composer2.changed($isMineTab);
                        Composer $this$cache$iv3 = $composer2;
                        Object it$iv9 = $this$cache$iv3.rememberedValue();
                        if (invalid$iv4) {
                            $this$forEach$iv = $this$forEach$iv3;
                        } else {
                            $this$forEach$iv = $this$forEach$iv3;
                            if (it$iv9 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                GameItemViewKt.GameItemView(unbindRole, ExposerKt.reportOnExposure(modifier3, valueOf, null, null, null, (Function0) it$iv9, $composer2, 6, 14), onGameItemClick, $composer2, 384, 0);
                                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa2-0d7_KjU(), $composer2, 54, 0);
                                $this$forEach$iv3 = $this$forEach$iv;
                            }
                        }
                        Object value$iv10 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda18
                            public final Object invoke() {
                                Unit RoleListPage$lambda$1$10$0$4$0$0;
                                RoleListPage$lambda$1$10$0$4$0$0 = RoleListPageKt.RoleListPage$lambda$1$10$0$4$0$0(UnbindRoleItem.this, $isMineTab);
                                return RoleListPage$lambda$1$10$0$4$0$0;
                            }
                        };
                        $this$cache$iv3.updateRememberedValue(value$iv10);
                        it$iv9 = value$iv10;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        GameItemViewKt.GameItemView(unbindRole, ExposerKt.reportOnExposure(modifier3, valueOf, null, null, null, (Function0) it$iv9, $composer2, 6, 14), onGameItemClick, $composer2, 384, 0);
                        DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa2-0d7_KjU(), $composer2, 54, 0);
                        $this$forEach$iv3 = $this$forEach$iv;
                    }
                } else {
                    str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str5 = str3;
                    $composer2.startReplaceGroup(-2056880897);
                }
                $composer2.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, !z ? Dp.constructor-impl(20) : Dp.constructor-impl(100)), $composer2, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (z) {
                    $composer3 = $composer;
                    $composer3.startReplaceGroup(-824271241);
                    ComposerKt.sourceInformation($composer3, "264@11257L6,266@11383L127,269@11544L85,269@11511L118,259@11056L870");
                    Modifier align = $this$RoleListPage_u24lambda_u241_u2410.align(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(38), 7, (Object) null), Dp.constructor-impl(220), Dp.constructor-impl(44)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Alignment.Companion.getBottomCenter());
                    ComposerKt.sourceInformationMarkerStart($composer3, 2051630732, str2);
                    Object it$iv10 = $composer3.rememberedValue();
                    if (it$iv10 == Composer.Companion.getEmpty()) {
                        Object value$iv11 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda19
                            public final Object invoke() {
                                Unit RoleListPage$lambda$1$10$1$0;
                                RoleListPage$lambda$1$10$1$0 = RoleListPageKt.RoleListPage$lambda$1$10$1$0();
                                return RoleListPage$lambda$1$10$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv11);
                        it$iv10 = value$iv11;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier4 = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv10, 15, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 2051635842, str2);
                    Object it$iv11 = $composer3.rememberedValue();
                    if (it$iv11 == Composer.Companion.getEmpty()) {
                        Object value$iv12 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda20
                            public final Object invoke() {
                                Unit RoleListPage$lambda$1$10$2$0;
                                RoleListPage$lambda$1$10$2$0 = RoleListPageKt.RoleListPage$lambda$1$10$2$0();
                                return RoleListPage$lambda$1$10$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv12);
                        it$iv11 = value$iv12;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv6 = ExposerKt.reportOnExposure(modifier4, "manage_entry", null, null, null, (Function0) it$iv11, $composer3, 196656, 14);
                    Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                    int $changed$iv = i;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                    int $changed$iv$iv6 = ($changed$iv << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str4);
                    int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
                    Function0 factory$iv$iv$iv16 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str5);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv16;
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv16;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i13 = (($changed$iv >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1374804177, "C275@11749L48,276@11837L9,274@11716L196:RoleListPage.kt#ualdgv");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_bind_my_role(Res.string.INSTANCE), $composer3, 0), (Modifier) null, BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                } else {
                    $composer3 = $composer;
                    $composer3.startReplaceGroup(-835253611);
                }
                $composer3.endReplaceGroup();
                State menuState$delegate = SnapshotStateKt.collectAsState(viewModel.getMenuState(), RolesListViewModel.MenuState.Initialize.INSTANCE, (CoroutineContext) null, $composer3, 0, 2);
                RoleListPage$lambda$1$10$4 = RoleListPage$lambda$1$10$4(menuState$delegate);
                if (RoleListPage$lambda$1$10$4 instanceof RolesListViewModel.MenuState.ShowMenuDialog) {
                    final CoroutineScope scope4 = scope;
                    if (RoleListPage$lambda$1$10$4 instanceof RolesListViewModel.MenuState.ShowRoleSwitchDialog) {
                        $composer3.startReplaceGroup(-821943358);
                        ComposerKt.sourceInformation($composer3, "317@13604L180,325@13975L748,316@13547L1176");
                        RolesListViewModel.MenuState RoleListPage$lambda$1$10$42 = RoleListPage$lambda$1$10$4(menuState$delegate);
                        Intrinsics.checkNotNull(RoleListPage$lambda$1$10$42, "null cannot be cast to non-null type kntr.app.game.gamebind.RolesListViewModel.MenuState.ShowRoleSwitchDialog");
                        RolesListViewModel.MenuState.ShowRoleSwitchDialog showRoleSwitchDialog = (RolesListViewModel.MenuState.ShowRoleSwitchDialog) RoleListPage$lambda$1$10$42;
                        final RoleItem role = showRoleSwitchDialog.component1();
                        final RoleMenuItem menuItem = showRoleSwitchDialog.component2();
                        ReporterKt.reportSwitchRoleDialogExpose(role);
                        Shape shape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
                        long Color = ColorKt.Color(2130706432);
                        ComposerKt.sourceInformationMarkerStart($composer3, 2051701857, str2);
                        boolean invalid$iv5 = $composer3.changedInstance(scope4) | $composer3.changedInstance(viewModel);
                        Composer $this$cache$iv4 = $composer3;
                        Object it$iv12 = $this$cache$iv4.rememberedValue();
                        if (invalid$iv5 || it$iv12 == Composer.Companion.getEmpty()) {
                            Object value$iv13 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda23
                                public final Object invoke() {
                                    Unit RoleListPage$lambda$1$10$7$0;
                                    RoleListPage$lambda$1$10$7$0 = RoleListPageKt.RoleListPage$lambda$1$10$7$0(scope4, viewModel);
                                    return RoleListPage$lambda$1$10$7$0;
                                }
                            };
                            $this$cache$iv4.updateRememberedValue(value$iv13);
                            it$iv12 = value$iv13;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        final Ref.BooleanRef booleanRef = bottomSheetShowing;
                        final MutableState mutableState = openBottomSheet$delegate;
                        ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv12, (Modifier) null, (SheetState) null, 0.0f, false, shape, 0L, 0L, 0.0f, Color, ComposableSingletons$RoleListPageKt.INSTANCE.m1234getLambda$1349187559$game_bind_ui_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-610277044, true, new Function3() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit RoleListPage$lambda$1$10$8;
                                RoleListPage$lambda$1$10$8 = RoleListPageKt.RoleListPage$lambda$1$10$8(booleanRef, role, menuItem, scope4, viewModel, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return RoleListPage$lambda$1$10$8;
                            }
                        }, $composer3, 54), $composer3, 805306368, 3078, 6622);
                        $composer3.endReplaceGroup();
                    } else if (RoleListPage$lambda$1$10$4 instanceof RolesListViewModel.MenuState.UnbindDialog) {
                        $composer3.startReplaceGroup(-820526968);
                        ComposerKt.sourceInformation($composer3, "348@14966L40,349@15039L39,351@15155L180,356@15365L55,357@15452L57,360@15647L6,361@15695L242,367@15974L245,350@15095L1143");
                        RolesListViewModel.MenuState RoleListPage$lambda$1$10$43 = RoleListPage$lambda$1$10$4(menuState$delegate);
                        Intrinsics.checkNotNull(RoleListPage$lambda$1$10$43, "null cannot be cast to non-null type kntr.app.game.gamebind.RolesListViewModel.MenuState.UnbindDialog");
                        final RoleItem role2 = ((RolesListViewModel.MenuState.UnbindDialog) RoleListPage$lambda$1$10$43).getRole();
                        ReporterKt.reportUnbindDialogShow(role2);
                        final String leftText = StringResourcesKt.stringResource(srcs.common.compose.res.generated.resources.String0_commonMainKt.getConfirm(CommonRes.INSTANCE.getString()), $composer3, 0);
                        final String rightText = StringResourcesKt.stringResource(srcs.common.compose.res.generated.resources.String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer3, 0);
                        ComposerKt.sourceInformationMarkerStart($composer3, 2051751489, str2);
                        boolean invalid$iv6 = $composer3.changedInstance(scope4) | $composer3.changedInstance(viewModel);
                        Composer $this$cache$iv5 = $composer3;
                        Object it$iv13 = $this$cache$iv5.rememberedValue();
                        if (invalid$iv6 || it$iv13 == Composer.Companion.getEmpty()) {
                            Object value$iv14 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda1
                                public final Object invoke() {
                                    Unit RoleListPage$lambda$1$10$9$0;
                                    RoleListPage$lambda$1$10$9$0 = RoleListPageKt.RoleListPage$lambda$1$10$9$0(scope4, viewModel);
                                    return RoleListPage$lambda$1$10$9$0;
                                }
                            };
                            $this$cache$iv5.updateRememberedValue(value$iv14);
                            it$iv13 = value$iv14;
                        }
                        Function0 function0 = (Function0) it$iv13;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_unbind_dialog_title(Res.string.INSTANCE), $composer3, 0);
                        String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getBiligame_unbind_dialog_content(Res.string.INSTANCE), $composer3, 0);
                        long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2051768831, str2);
                        boolean invalid$iv7 = $composer3.changedInstance(role2) | $composer3.changed(leftText) | $composer3.changedInstance(scope4) | $composer3.changedInstance(viewModel);
                        Composer $this$cache$iv6 = $composer3;
                        Object it$iv14 = $this$cache$iv6.rememberedValue();
                        if (invalid$iv7 || it$iv14 == Composer.Companion.getEmpty()) {
                            Object value$iv15 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda2
                                public final Object invoke() {
                                    Unit RoleListPage$lambda$1$10$10$0;
                                    RoleListPage$lambda$1$10$10$0 = RoleListPageKt.RoleListPage$lambda$1$10$10$0(RoleItem.this, leftText, scope4, viewModel);
                                    return RoleListPage$lambda$1$10$10$0;
                                }
                            };
                            $this$cache$iv6.updateRememberedValue(value$iv15);
                            it$iv14 = value$iv15;
                        }
                        Function0 function02 = (Function0) it$iv14;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 2051777762, str2);
                        boolean invalid$iv8 = $composer3.changedInstance(role2) | $composer3.changed(rightText) | $composer3.changedInstance(scope4) | $composer3.changedInstance(viewModel);
                        Composer $this$cache$iv7 = $composer3;
                        Object it$iv15 = $this$cache$iv7.rememberedValue();
                        if (invalid$iv8 || it$iv15 == Composer.Companion.getEmpty()) {
                            Object value$iv16 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda3
                                public final Object invoke() {
                                    Unit RoleListPage$lambda$1$10$11$0;
                                    RoleListPage$lambda$1$10$11$0 = RoleListPageKt.RoleListPage$lambda$1$10$11$0(RoleItem.this, rightText, scope4, viewModel);
                                    return RoleListPage$lambda$1$10$11$0;
                                }
                            };
                            $this$cache$iv7.updateRememberedValue(value$iv16);
                            it$iv15 = value$iv16;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        BiligameAlertDialogKt.m1095BiligameAlertDialoggsbd_E(function0, stringResource, stringResource2, leftText, rightText, 0L, j2, function02, (Function0) it$iv15, false, false, false, $composer3, 0, 0, 3616);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-819105773);
                        $composer3.endReplaceGroup();
                        bottomSheetShowing.element = false;
                        RoleListPage$lambda$1$8(openBottomSheet$delegate, false);
                    }
                } else {
                    $composer3.startReplaceGroup(-823185187);
                    ComposerKt.sourceInformation($composer3, "287@12299L180,295@12670L620,286@12242L1048");
                    RolesListViewModel.MenuState RoleListPage$lambda$1$10$44 = RoleListPage$lambda$1$10$4(menuState$delegate);
                    Intrinsics.checkNotNull(RoleListPage$lambda$1$10$44, "null cannot be cast to non-null type kntr.app.game.gamebind.RolesListViewModel.MenuState.ShowMenuDialog");
                    RolesListViewModel.MenuState.ShowMenuDialog showMenuDialog = (RolesListViewModel.MenuState.ShowMenuDialog) RoleListPage$lambda$1$10$44;
                    final RoleItem role3 = showMenuDialog.component1();
                    final List menuList = showMenuDialog.component2();
                    Shape shape2 = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
                    long Color2 = ColorKt.Color(2130706432);
                    ComposerKt.sourceInformationMarkerStart($composer3, 2051660097, str2);
                    final CoroutineScope scope5 = scope;
                    boolean invalid$iv9 = $composer3.changedInstance(scope5) | $composer3.changedInstance(viewModel);
                    Composer $this$cache$iv8 = $composer3;
                    Object it$iv16 = $this$cache$iv8.rememberedValue();
                    if (invalid$iv9 || it$iv16 == Composer.Companion.getEmpty()) {
                        Object value$iv17 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda21
                            public final Object invoke() {
                                Unit RoleListPage$lambda$1$10$5$0;
                                RoleListPage$lambda$1$10$5$0 = RoleListPageKt.RoleListPage$lambda$1$10$5$0(scope5, viewModel);
                                return RoleListPage$lambda$1$10$5$0;
                            }
                        };
                        $this$cache$iv8.updateRememberedValue(value$iv17);
                        it$iv16 = value$iv17;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    final Ref.BooleanRef booleanRef2 = bottomSheetShowing;
                    final MutableState mutableState2 = openBottomSheet$delegate;
                    ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv16, (Modifier) null, (SheetState) null, 0.0f, false, shape2, 0L, 0L, 0.0f, Color2, ComposableSingletons$RoleListPageKt.INSTANCE.getLambda$2025103984$game_bind_ui_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(-262392733, true, new Function3() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda22
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit RoleListPage$lambda$1$10$6;
                            RoleListPage$lambda$1$10$6 = RoleListPageKt.RoleListPage$lambda$1$10$6(booleanRef2, role3, menuList, scope5, viewModel, mutableState2, onRoleMenuItemClick, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return RoleListPage$lambda$1$10$6;
                        }
                    }, $composer3, 54), $composer3, 805306368, 3078, 6622);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }
        openBottomSheet$delegate = openBottomSheet$delegate2;
        unit = unit2;
        i = 48;
        bottomSheetShowing = bottomSheetShowing2;
        onRoleItemClick = onRoleItemClick3;
        str = "CC(remember):RoleListPage.kt#9igjgp";
        value$iv7 = new RoleListPageKt$RoleListPage$2$2$1($isMineTab, $isMyself, viewModel, toaster, null);
        $this$cache$iv.updateRememberedValue(value$iv7);
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) value$iv7, $composer, 6);
        Modifier modifier$iv7 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default($modifier, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
        int $changed$iv$iv7 = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv8 = $composer.getCurrentCompositionLocalMap();
        Function1 onRoleMenuClick32 = onRoleMenuClick2;
        Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer, modifier$iv7);
        Function0 factory$iv$iv$iv72 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
        Function2 onRoleItemExpose32 = onRoleItemExpose2;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
        }
        Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer);
        Toaster toaster22 = toaster;
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
        int i22 = ($changed$iv$iv$iv7 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        int i32 = ((0 >> 6) & 112) | 6;
        BoxScope $this$RoleListPage_u24lambda_u241_u24102 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -828453109, "C163@6547L4471,281@11982L55:RoleListPage.kt#ualdgv");
        Modifier modifier$iv22 = ScrollKt.verticalScroll$default(Modifier.Companion, $scrollState, true, (FlingBehavior) null, false, 12, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
        int $changed$iv$iv22 = (0 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv22 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer, modifier$iv22);
        Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
        Composer $composer$iv52 = $composer;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
        }
        Function0 factory$iv$iv$iv92 = factory$iv$iv$iv2;
        Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer);
        Modifier materialized$iv$iv32 = materialized$iv$iv8;
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
        int i42 = ($changed$iv$iv$iv22 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
        int i52 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -2050184524, "C256@10941L67:RoleListPage.kt#ualdgv");
        final List roles2 = data.getRoles();
        list = roles2;
        if (list != null || list.isEmpty()) {
        }
        final List gameList2 = data.getGameList();
        list2 = gameList2;
        if ((list2 != null || list2.isEmpty()) ? true : z2) {
        }
        str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
        str5 = str3;
        $composer2.startReplaceGroup(-2056880897);
        $composer2.endReplaceGroup();
        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, !z ? Dp.constructor-impl(20) : Dp.constructor-impl(100)), $composer2, 0);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        if (z) {
        }
        $composer3.endReplaceGroup();
        State menuState$delegate2 = SnapshotStateKt.collectAsState(viewModel.getMenuState(), RolesListViewModel.MenuState.Initialize.INSTANCE, (CoroutineContext) null, $composer3, 0, 2);
        RoleListPage$lambda$1$10$4 = RoleListPage$lambda$1$10$4(menuState$delegate2);
        if (RoleListPage$lambda$1$10$4 instanceof RolesListViewModel.MenuState.ShowMenuDialog) {
        }
        ComposerKt.sourceInformationMarkerEnd($composer3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer$iv$iv$iv2.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$0$0(boolean $isMyself, boolean $isMineTab, RoleItem role) {
        Intrinsics.checkNotNullParameter(role, "role");
        ReporterKt.reportRoleItemClick(role, $isMyself, $isMineTab);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$1$0(boolean $isMineTab, CoroutineScope $scope, RolesListViewModel $viewModel, RoleItem role) {
        Intrinsics.checkNotNullParameter(role, "role");
        ReporterKt.reportRoleMenuClick(role, $isMineTab);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$onRoleMenuClick$1$1$1($viewModel, role, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$2$0(boolean $isMyself, boolean $isMineTab, RoleItem role, boolean showMenu) {
        Intrinsics.checkNotNullParameter(role, "role");
        ReporterKt.reportRoleItemExpose(role, showMenu, $isMyself, $isMineTab);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$3$0(boolean $isMineTab, UnbindRoleItem game, boolean isButton) {
        Intrinsics.checkNotNullParameter(game, "game");
        ReporterKt.reportGameItemClick(game, isButton, $isMineTab);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job RoleListPage$lambda$1$4$0(CoroutineScope $scope, RolesListViewModel $viewModel, RoleItem role, RoleMenuItem menuItem) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        return BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$onRoleMenuItemClick$1$1$1($viewModel, role, menuItem, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState RoleListPage$lambda$1$6$0() {
        return SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean RoleListPage$lambda$1$7(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void RoleListPage$lambda$1$8(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$0$0$0(List $roles, boolean $isMineTab, boolean $isMyself) {
        ReporterKt.reportRoleListExpose($roles, $isMineTab, $isMyself);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$0$2$0(List $gameList, boolean $isMineTab, boolean $isMyself) {
        ReporterKt.reportUnbindListExpose($gameList, $isMineTab, $isMyself);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$0$4$0$0(UnbindRoleItem $unbindRole, boolean $isMineTab) {
        ReporterKt.reportGameItemExpose($unbindRole, $isMineTab);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$1$0() {
        ReporterKt.reportManagementEntryClick();
        BindActionKt.openBindList$default(null, 1, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$2$0() {
        ReporterKt.reportManagementEntryExpose();
        return Unit.INSTANCE;
    }

    private static final RolesListViewModel.MenuState RoleListPage$lambda$1$10$4(State<? extends RolesListViewModel.MenuState> state) {
        Object thisObj$iv = state.getValue();
        return (RolesListViewModel.MenuState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$5$0(CoroutineScope $scope, RolesListViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$5$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$6(Ref.BooleanRef $bottomSheetShowing, final RoleItem $role, List $menuList, final CoroutineScope $scope, final RolesListViewModel $viewModel, MutableState $openBottomSheet$delegate, final Function2 $onRoleMenuItemClick, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C301@12916L95,304@13053L196,298@12781L491:RoleListPage.kt#ualdgv");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-262392733, $changed, -1, "kntr.app.game.gamebind.ui.RoleListPage.<anonymous>.<anonymous>.<anonymous> (RoleListPage.kt:296)");
            }
            RoleListPage$lambda$1$8($openBottomSheet$delegate, true);
            $bottomSheetShowing.element = true;
            ComposerKt.sourceInformationMarkerStart($composer, 1243662018, "CC(remember):RoleListPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($role);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit RoleListPage$lambda$1$10$6$0$0;
                        RoleListPage$lambda$1$10$6$0$0 = RoleListPageKt.RoleListPage$lambda$1$10$6$0$0($onRoleMenuItemClick, $role, (RoleMenuItem) obj);
                        return RoleListPage$lambda$1$10$6$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1243666503, "CC(remember):RoleListPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        Unit RoleListPage$lambda$1$10$6$1$0;
                        RoleListPage$lambda$1$10$6$1$0 = RoleListPageKt.RoleListPage$lambda$1$10$6$1$0($scope, $viewModel);
                        return RoleListPage$lambda$1$10$6$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            RoleMenuSheetKt.RoleMenuSheet($role, $menuList, function1, (Function0) it$iv2, null, $composer, 0, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$6$0$0(Function2 $onRoleMenuItemClick, RoleItem $role, RoleMenuItem menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        $onRoleMenuItemClick.invoke($role, menu);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$6$1$0(CoroutineScope $scope, RolesListViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$6$2$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$7$0(CoroutineScope $scope, RolesListViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$7$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$8(Ref.BooleanRef $bottomSheetShowing, final RoleItem $role, RoleMenuItem $menuItem, final CoroutineScope $scope, final RolesListViewModel $viewModel, MutableState $openBottomSheet$delegate, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C331@14226L218,336@14486L196,328@14086L619:RoleListPage.kt#ualdgv");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-610277044, $changed, -1, "kntr.app.game.gamebind.ui.RoleListPage.<anonymous>.<anonymous>.<anonymous> (RoleListPage.kt:326)");
            }
            RoleListPage$lambda$1$8($openBottomSheet$delegate, true);
            $bottomSheetShowing.element = true;
            ComposerKt.sourceInformationMarkerStart($composer, 1934288518, "CC(remember):RoleListPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($viewModel) | $composer.changedInstance($role);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit RoleListPage$lambda$1$10$8$0$0;
                        RoleListPage$lambda$1$10$8$0$0 = RoleListPageKt.RoleListPage$lambda$1$10$8$0$0($scope, $viewModel, $role, (SectionItem) obj);
                        return RoleListPage$lambda$1$10$8$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 function1 = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1934296816, "CC(remember):RoleListPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.RoleListPageKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit RoleListPage$lambda$1$10$8$1$0;
                        RoleListPage$lambda$1$10$8$1$0 = RoleListPageKt.RoleListPage$lambda$1$10$8$1$0($scope, $viewModel);
                        return RoleListPage$lambda$1$10$8$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            RoleSwitchSheetKt.RoleSwitchSheet($role, $menuItem, function1, (Function0) it$iv2, null, $composer, 0, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$8$0$0(CoroutineScope $scope, RolesListViewModel $viewModel, RoleItem $role, SectionItem server) {
        Intrinsics.checkNotNullParameter(server, "server");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$8$1$1$1($viewModel, $role, server, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$8$1$0(CoroutineScope $scope, RolesListViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$8$2$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$9$0(CoroutineScope $scope, RolesListViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$9$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$10$0(RoleItem $role, String $leftText, CoroutineScope $scope, RolesListViewModel $viewModel) {
        ReporterKt.reportUnbindDialogClick($role, $leftText);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$10$1$1($viewModel, $role, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoleListPage$lambda$1$10$11$0(RoleItem $role, String $rightText, CoroutineScope $scope, RolesListViewModel $viewModel) {
        ReporterKt.reportUnbindDialogClick($role, $rightText);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new RoleListPageKt$RoleListPage$2$3$11$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}