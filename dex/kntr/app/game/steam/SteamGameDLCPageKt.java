package kntr.app.game.steam;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.Velocity;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.ExposureConfig;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.bean.DLCDetail;
import kntr.app.game.bean.DLCHeader;
import kntr.app.game.bean.DLCStats;
import kntr.app.game.bean.GameDLCsData;
import kntr.app.game.report.ReportKt;
import kntr.app.game.steam.background.SteamGameBackgroundKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.app.game.base.ui.generated.resources.Font0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;

/* compiled from: SteamGameDLCPage.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\t\u001aK\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r\u001a7\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a/\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0018\u001a;\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u001c2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001d\u001a?\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010#\u001a)\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010'\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010(¨\u0006)²\u0006\n\u0010*\u001a\u00020+X\u008a\u008e\u0002²\u0006\n\u0010,\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010-\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010.\u001a\u00020\u0015X\u008a\u008e\u0002²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u000200X\u008a\u008e\u0002"}, d2 = {"SteamGameDLCPage", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "appId", RouterHelperKt.PARAM_SOURCE_FROM, "modifier", "Landroidx/compose/ui/Modifier;", "steamGameName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SteamGameDLCPageContent", "onBackPress", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "DLCTopAppBar", "title", "immersive", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "DLCStatisticsSection", "ownedCount", RoomRecommendViewModel.EMPTY_CURSOR, "totalCount", "totalValue", "(IILjava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DLCListTitle", "selectedTab", "onTabSelect", "Lkotlin/Function1;", "(IILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DLCTabItemCompact", "text", "count", "selected", "onClick", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DLCListItem", "dlc", "Lkntr/app/game/bean/DLCDetail;", "isLastItem", "(Lkntr/app/game/bean/DLCDetail;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "gamebiz_debug", "currentBackgroundBrush", "Landroidx/compose/ui/graphics/Brush;", "filter", "showSticky", "lineCount", "lastLineWidth", RoomRecommendViewModel.EMPTY_CURSOR, "textLayoutWidth"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamGameDLCPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListItem$lambda$13(DLCDetail dLCDetail, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        DLCListItem(dLCDetail, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListTitle$lambda$1(int i, int i2, Function1 function1, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        DLCListTitle(i, i2, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCStatisticsSection$lambda$1(int i, int i2, String str, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        DLCStatisticsSection(i, i2, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCTabItemCompact$lambda$1(String str, Integer num, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DLCTabItemCompact(str, num, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCTopAppBar$lambda$2(String str, Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        DLCTopAppBar(str, function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPage$lambda$1(String str, String str2, String str3, Modifier modifier, String str4, int i, int i2, Composer composer, int i3) {
        SteamGameDLCPage(str, str2, str3, modifier, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPageContent$lambda$14(String str, String str2, String str3, Modifier modifier, String str4, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamGameDLCPageContent(str, str2, str3, modifier, str4, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SteamGameDLCPage(final String steamId, final String appId, final String sourceFrom, Modifier modifier, String steamGameName, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        Modifier modifier3;
        String steamGameName2;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-922964001);
        ComposerKt.sourceInformation($composer2, "C(SteamGameDLCPage)N(steamId,appId,sourceFrom,modifier,steamGameName)96@4378L7,103@4588L51,97@4390L256:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(steamId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(appId) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(sourceFrom) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty |= 24576;
            str = steamGameName;
        } else if (($changed & 24576) == 0) {
            str = steamGameName;
            $dirty |= $composer2.changed(str) ? 16384 : 8192;
        } else {
            str = steamGameName;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            steamGameName2 = str;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                steamGameName2 = str;
            } else {
                steamGameName2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-922964001, $dirty2, -1, "kntr.app.game.steam.SteamGameDLCPage (SteamGameDLCPage.kt:95)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 2089838834, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(backHandler);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit SteamGameDLCPage$lambda$0$0;
                        SteamGameDLCPage$lambda$0$0 = SteamGameDLCPageKt.SteamGameDLCPage$lambda$0$0(backHandler);
                        return SteamGameDLCPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SteamGameDLCPageContent(steamId, appId, sourceFrom, modifier3, steamGameName2, (Function0) it$iv, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str2 = steamGameName2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameDLCPage$lambda$1;
                    SteamGameDLCPage$lambda$1 = SteamGameDLCPageKt.SteamGameDLCPage$lambda$1(steamId, appId, sourceFrom, modifier4, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameDLCPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPage$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:159:0x068e, code lost:
        if (r0 == null) goto L122;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v119, types: [java.lang.Object[], androidx.compose.ui.graphics.Color[]] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SteamGameDLCPageContent(final String steamId, final String appId, final String sourceFrom, Modifier modifier, String steamGameName, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String steamGameName2;
        Function0 function02;
        Modifier modifier3;
        Function0 onBackPress;
        boolean z;
        int $dirty;
        String spmid;
        int i2;
        Toaster toaster;
        CoroutineScope scope;
        String str;
        final String spmid2;
        Unit unit;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        String it;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-715203170);
        ComposerKt.sourceInformation($composer2, "C(SteamGameDLCPageContent)N(steamId,appId,sourceFrom,modifier,steamGameName,onBackPress)116@4855L2,123@5055L47,125@5134L164,130@5333L53,134@5434L20,134@5424L30,135@5471L24,136@5527L7,141@5668L70,142@5770L256,142@5743L283,151@6073L137,151@6050L160,159@6255L33,161@6315L259,161@6294L280,173@6610L11966:SteamGameDLCPage.kt#xy3gb6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(steamId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(appId) ? 32 : 16;
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
            steamGameName2 = steamGameName;
        } else if (($changed & 24576) == 0) {
            steamGameName2 = steamGameName;
            $dirty2 |= $composer2.changed(steamGameName2) ? 16384 : 8192;
        } else {
            steamGameName2 = steamGameName;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            function02 = function0;
        } else if (($changed & 196608) == 0) {
            function02 = function0;
            $dirty2 |= $composer2.changedInstance(function02) ? 131072 : 65536;
        } else {
            function02 = function0;
        }
        if ($composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i4 != 0) {
                steamGameName2 = null;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -115472832, "CC(remember):SteamGameDLCPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit unit2;
                            unit2 = Unit.INSTANCE;
                            return unit2;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackPress2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onBackPress = onBackPress2;
            } else {
                onBackPress = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-715203170, $dirty2, -1, "kntr.app.game.steam.SteamGameDLCPageContent (SteamGameDLCPage.kt:117)");
            }
            ColorKt.Color(4279969848L);
            ComposerKt.sourceInformationMarkerStart($composer2, -115466387, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SteamGameBackgroundKt.calculateSteamGradientColors(null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Pair defaultGradientColors = (Pair) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -115463742, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                z = true;
                Object value$iv3 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{defaultGradientColors.getFirst(), defaultGradientColors.getSecond()}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                z = true;
            }
            Brush defaultBrush = (Brush) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -115457485, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(defaultBrush, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState currentBackgroundBrush$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -115454286, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        SteamGameDLCVM SteamGameDLCPageContent$lambda$6$0;
                        SteamGameDLCPageContent$lambda$6$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$6$0((CreationExtras) obj);
                        return SteamGameDLCPageContent$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            Function1 initializer$iv = (Function1) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer2, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SteamGameDLCVM.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(SteamGameDLCVM.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            SteamGameDLCVM viewModel2 = (SteamGameDLCVM) viewModel;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            CoroutineScope scope2 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Toaster toaster2 = (Toaster) consume;
            String spmidFrom = KntrGameReportService.INSTANCE.getSpmidFrom();
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("game-ball.steam-game-dlc.steam-game-dlc.0.pv", $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -115443298, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256 ? z : false) | $composer2.changedInstance(pvTrigger) | $composer2.changed(spmidFrom) | (($dirty2 & 112) == 32 ? z : false);
            Object value$iv6 = $composer2.rememberedValue();
            if (invalid$iv || value$iv6 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-dlc";
                i2 = 0;
                toaster = toaster2;
                scope = scope2;
                str = "CC(remember):SteamGameDLCPage.kt#9igjgp";
                value$iv6 = new SteamGameDLCPageKt$SteamGameDLCPageContent$2$1(pvTrigger, "game-ball.steam-game-dlc", sourceFrom, spmidFrom, appId, null);
                $composer2.updateRememberedValue(value$iv6);
            } else {
                toaster = toaster2;
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-dlc";
                str = "CC(remember):SteamGameDLCPage.kt#9igjgp";
                scope = scope2;
                i2 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(sourceFrom, (Function2) value$iv6, $composer2, ($dirty >> 6) & 14);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -115433721, str);
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                spmid2 = spmid;
                Object value$iv7 = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SteamGameDLCPageContent$lambda$8$0;
                        SteamGameDLCPageContent$lambda$8$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$8$0(spmid2, (DisposableEffectScope) obj);
                        return SteamGameDLCPageContent$lambda$8$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv7);
                it$iv6 = value$iv7;
            } else {
                spmid2 = spmid;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv6, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, -115428001, str);
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv8 = SnapshotIntStateKt.mutableIntStateOf(i2);
                $composer2.updateRememberedValue(value$iv8);
                it$iv7 = value$iv8;
            }
            final MutableIntState filter$delegate = (MutableIntState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -115425855, str);
            Toaster toaster3 = toaster;
            int i6 = ($composer2.changedInstance(viewModel2) ? 1 : 0) | (($dirty & 14) == 4 ? 1 : i2) | (($dirty & 112) == 32 ? 1 : i2) | ($composer2.changedInstance(scope) ? 1 : 0) | ($composer2.changedInstance(toaster3) ? 1 : 0);
            Object value$iv9 = $composer2.rememberedValue();
            if (i6 != 0 || value$iv9 == Composer.Companion.getEmpty()) {
                CoroutineScope coroutineScope = scope;
                unit = unit3;
                value$iv9 = new SteamGameDLCPageKt$SteamGameDLCPageContent$4$1(viewModel2, steamId, appId, coroutineScope, toaster3, null);
                $composer2.updateRememberedValue(value$iv9);
            } else {
                unit = unit3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv9, $composer2, 6);
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), SteamGameDLCPageContent$lambda$4(currentBackgroundBrush$delegate), (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, i2));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 2048945935, "C174@6702L11868:SteamGameDLCPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv3);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1273997076, "C176@6795L188,188@7231L11329,182@6997L11563:SteamGameDLCPage.kt#xy3gb6");
            if (steamGameName2 != null) {
                String it2 = steamGameName2;
                $composer$iv = $composer2;
                it = "《" + it2 + "》DLCs";
            } else {
                $composer$iv = $composer2;
            }
            it = RoomRecommendViewModel.EMPTY_CURSOR;
            DLCTopAppBar(it, onBackPress, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, $composer2, (($dirty >> 12) & 112) | 384, 8);
            final String str2 = steamGameName2;
            LoadComposableKt.LoadComposable(viewModel2, sourceFrom, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, ComposableLambdaKt.rememberComposableLambda(1543376906, true, new Function5() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit SteamGameDLCPageContent$lambda$13$0$1;
                    SteamGameDLCPageContent$lambda$13$0$1 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1(str2, currentBackgroundBrush$delegate, filter$delegate, appId, sourceFrom, (GameDLCsData) obj, (SteamGameDLCVM) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return SteamGameDLCPageContent$lambda$13$0$1;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 112) | 224640, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
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
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onBackPress = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str3 = steamGameName2;
            final Function0 function03 = onBackPress;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameDLCPageContent$lambda$14;
                    SteamGameDLCPageContent$lambda$14 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$14(steamId, appId, sourceFrom, modifier5, str3, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameDLCPageContent$lambda$14;
                }
            });
        }
    }

    private static final Brush SteamGameDLCPageContent$lambda$4(MutableState<Brush> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Brush) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SteamGameDLCVM SteamGameDLCPageContent$lambda$6$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new SteamGameDLCVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SteamGameDLCPageContent$lambda$8$0(final String $spmid, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$lambda$8$0$$inlined$onDispose$1
            public void dispose() {
                KntrGameReportService.INSTANCE.setSpmidFrom($spmid);
            }
        };
    }

    private static final int SteamGameDLCPageContent$lambda$10(MutableIntState $filter$delegate) {
        IntState $this$getValue$iv = (IntState) $filter$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0331, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0413  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0691  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x077e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1(String $steamGameName, MutableState $currentBackgroundBrush$delegate, final MutableIntState $filter$delegate, final String $appId, final String $sourceFrom, GameDLCsData dlcData, SteamGameDLCVM vm, PageLoadMoreState pageLoadMoreState, Composer $composer, int $changed) {
        String str;
        String str2;
        Brush dynamicBrush;
        boolean invalid$iv;
        LazyListState lazyListState;
        boolean invalid$iv2;
        State showSticky$delegate;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        int ownedCount;
        Composer $composer$iv;
        String str3;
        String totalValue;
        Composer $composer$iv2;
        Composer $composer2;
        Composer $composer$iv$iv;
        LazyListState listState;
        float f;
        Composer $composer3;
        boolean invalid$iv3;
        Object value$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Intrinsics.checkNotNullParameter(dlcData, "dlcData");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(pageLoadMoreState, "$unused$var$");
        ComposerKt.sourceInformation($composer, "CN(dlcData,vm)201@7778L125,205@7959L232,212@8278L77,212@8249L106,218@8451L368,228@8884L36,230@8965L7,231@9024L10,236@9249L23,237@9306L23,238@9363L23,247@9676L59,247@9653L82,254@9901L172,262@10204L1161,291@11431L7115:SteamGameDLCPage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1543376906, $changed, -1, "kntr.app.game.steam.SteamGameDLCPageContent.<anonymous>.<anonymous>.<anonymous> (SteamGameDLCPage.kt:189)");
        }
        DLCHeader header = dlcData.getHeader();
        DLCStats stats = header != null ? header.getDlcStats() : null;
        int ownedCount2 = stats != null ? stats.getOwnedCount() : 0;
        int totalCount = stats != null ? stats.getTotalCount() : dlcData.getTotalCount();
        if (stats == null || (str = stats.getTotalValueYuan()) == null) {
            str = AdSearchSubCardType.CARD_TYPE_NONE;
        }
        String totalValue2 = str;
        if ($steamGameName == null) {
            str2 = header != null ? header.getGameName() : null;
            if (str2 == null) {
                str2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
        } else {
            str2 = $steamGameName;
        }
        String appIconRgb = header != null ? header.getAppIconRgb() : null;
        ComposerKt.sourceInformationMarkerStart($composer, 1421507175, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        boolean invalid$iv4 = $composer.changed(appIconRgb);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv4 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SteamGameBackgroundKt.calculateSteamGradientColors(header != null ? header.getAppIconRgb() : null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        Pair dynamicGradientColors = (Pair) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        String appIconRgb2 = header != null ? header.getAppIconRgb() : null;
        ComposerKt.sourceInformationMarkerStart($composer, 1421513074, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        boolean invalid$iv5 = $composer.changed(appIconRgb2);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv5 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{dynamicGradientColors.getFirst(), dynamicGradientColors.getSecond()}), 0.0f, 0.0f, 0, 14, (Object) null);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Brush dynamicBrush2 = (Brush) it$iv3;
        ComposerKt.sourceInformationMarkerStart($composer, 1421523127, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        boolean invalid$iv6 = $composer.changed(dynamicBrush2);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv6 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = (Function2) new SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$1$1(dynamicBrush2, $currentBackgroundBrush$delegate, null);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(dynamicBrush2, (Function2) it$iv4, $composer, 0);
        List<DLCDetail> dlcs = dlcData.getDlcs();
        int SteamGameDLCPageContent$lambda$10 = SteamGameDLCPageContent$lambda$10($filter$delegate);
        ComposerKt.sourceInformationMarkerStart($composer, 1421528954, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        boolean invalid$iv7 = $composer.changed(dlcs) | $composer.changed(SteamGameDLCPageContent$lambda$10);
        Object it$iv5 = $composer.rememberedValue();
        if (invalid$iv7 || it$iv5 == Composer.Companion.getEmpty()) {
            switch (SteamGameDLCPageContent$lambda$10($filter$delegate)) {
                case 0:
                    dynamicBrush = dlcData.getDlcs();
                    break;
                case 1:
                    Iterable $this$filter$iv = dlcData.getDlcs();
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        DLCDetail it = (DLCDetail) element$iv$iv;
                        if (it.getOwned()) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        $this$filter$iv = $this$filter$iv2;
                    }
                    dynamicBrush = (List) destination$iv$iv;
                    break;
                case 2:
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv2 : dlcData.getDlcs()) {
                        Brush dynamicBrush3 = dynamicBrush2;
                        DLCDetail it2 = (DLCDetail) element$iv$iv2;
                        if (it2.getOwned()) {
                            invalid$iv = invalid$iv7;
                        } else {
                            invalid$iv = invalid$iv7;
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        dynamicBrush2 = dynamicBrush3;
                        invalid$iv7 = invalid$iv;
                    }
                    dynamicBrush = (List) destination$iv$iv2;
                    break;
                default:
                    dynamicBrush = dlcData.getDlcs();
                    break;
            }
            $composer.updateRememberedValue(dynamicBrush);
            it$iv5 = dynamicBrush;
        }
        final List filteredDlcs = (List) it$iv5;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1421542478, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        Object it$iv6 = $composer.rememberedValue();
        if (it$iv6 == Composer.Companion.getEmpty()) {
            Object value$iv5 = (List) new ArrayList();
            $composer.updateRememberedValue(value$iv5);
            it$iv6 = value$iv5;
        }
        final List exposedList = (List) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        int statusBarHeight = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6).getTop(density);
        Dp.constructor-impl(density.toDp-u2uoSUM(statusBarHeight) + Dp.constructor-impl(40));
        LazyListState listState0 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        LazyListState listState1 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        LazyListState listState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        switch (SteamGameDLCPageContent$lambda$10($filter$delegate)) {
            case 1:
                lazyListState = listState1;
                break;
            case 2:
                lazyListState = listState2;
                break;
            default:
                lazyListState = listState0;
                break;
        }
        final LazyListState listState3 = lazyListState;
        Integer valueOf = Integer.valueOf(SteamGameDLCPageContent$lambda$10($filter$delegate));
        ComposerKt.sourceInformationMarkerStart($composer, 1421567845, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        boolean invalid$iv8 = $composer.changedInstance(exposedList);
        Object it$iv7 = $composer.rememberedValue();
        if (!invalid$iv8 && it$iv7 != Composer.Companion.getEmpty()) {
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv7, $composer, 0);
            int SteamGameDLCPageContent$lambda$102 = SteamGameDLCPageContent$lambda$10($filter$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1421575158, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            invalid$iv2 = $composer.changed(SteamGameDLCPageContent$lambda$102);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv6 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda19
                public final Object invoke() {
                    boolean SteamGameDLCPageContent$lambda$13$0$1$7$0;
                    SteamGameDLCPageContent$lambda$13$0$1$7$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$7$0(listState3, r2);
                    return Boolean.valueOf(SteamGameDLCPageContent$lambda$13$0$1$7$0);
                }
            });
            $composer.updateRememberedValue(value$iv6);
            it$iv8 = value$iv6;
            showSticky$delegate = (State) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1421585843, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv7 = new NestedScrollConnection() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$nestedScrollConnection$1$1
                    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                    public long m1309onPreScrollOzD1aCk(long j2, int i) {
                        return Offset.Companion.getZero-F1C5BW0();
                    }

                    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                    public long m1307onPostScrollDzOQY0M(long j2, long j3, int i) {
                        return j3;
                    }

                    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                    public Object m1308onPreFlingQWom1Mo(long j2, Continuation<? super Velocity> continuation) {
                        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                    }

                    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                    public Object m1306onPostFlingRZ2iAVY(long j2, long j3, Continuation<? super Velocity> continuation) {
                        return Velocity.box-impl(j3);
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv = value$iv7;
            }
            SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$nestedScrollConnection$1$1 nestedScrollConnection = (SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$nestedScrollConnection$1$1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
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
            if (!$composer.getInserting()) {
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
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 159508719, "C298@11798L6,293@11548L337,326@12955L5573,320@12688L5840:SteamGameDLCPage.kt#xy3gb6");
            SpacerKt.Spacer(ZIndexModifierKt.zIndex(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(90), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), -1.0f), $composer, 0);
            if (!SteamGameDLCPageContent$lambda$13$0$1$8(showSticky$delegate)) {
                $composer.startReplaceGroup(159687402);
                ComposerKt.sourceInformation($composer, "303@11949L696");
                Modifier modifier$iv2 = ZIndexModifierKt.zIndex(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), 2.0f);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
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
                ownedCount = ownedCount2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i4 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1102758439, "C313@12413L107,310@12242L377:SteamGameDLCPage.kt#xy3gb6");
                int SteamGameDLCPageContent$lambda$103 = SteamGameDLCPageContent$lambda$10($filter$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, -1143946308, "CC(remember):SteamGameDLCPage.kt#9igjgp");
                Object value$iv8 = $composer.rememberedValue();
                if (value$iv8 == Composer.Companion.getEmpty()) {
                    $composer$iv$iv$iv = $composer;
                    value$iv8 = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda20
                        public final Object invoke(Object obj) {
                            Unit SteamGameDLCPageContent$lambda$13$0$1$10$0$0$0;
                            SteamGameDLCPageContent$lambda$13$0$1$10$0$0$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$0$0$0($filter$delegate, ((Integer) obj).intValue());
                            return SteamGameDLCPageContent$lambda$13$0$1$10$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                } else {
                    $composer$iv$iv$iv = $composer;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                f = 0.0f;
                $composer$iv2 = $composer;
                $composer$iv = $composer;
                listState = listState3;
                str3 = "CC(remember):SteamGameDLCPage.kt#9igjgp";
                totalValue = totalValue2;
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                $composer$iv$iv = $composer;
                $composer2 = $composer;
                DLCListTitle(totalCount, SteamGameDLCPageContent$lambda$103, (Function1) value$iv8, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 3456, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                $composer3 = $composer;
            } else {
                ownedCount = ownedCount2;
                $composer$iv = $composer;
                str3 = "CC(remember):SteamGameDLCPage.kt#9igjgp";
                totalValue = totalValue2;
                $composer$iv2 = $composer;
                $composer2 = $composer;
                $composer$iv$iv = $composer;
                listState = listState3;
                f = 0.0f;
                $composer3 = $composer;
                $composer3.startReplaceGroup(147835730);
                $composer3.endReplaceGroup();
            }
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, f, 1, (Object) null), nestedScrollConnection, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1667757045, str3);
            final int ownedCount3 = ownedCount;
            final String totalValue3 = totalValue;
            invalid$iv3 = $composer3.changed(ownedCount3) | $composer3.changed(totalCount) | $composer3.changed(totalValue3) | $composer3.changedInstance(filteredDlcs) | $composer3.changed($appId) | $composer3.changedInstance(exposedList) | $composer3.changed($sourceFrom);
            Composer $this$cache$iv = $composer3;
            value$iv = $this$cache$iv.rememberedValue();
            if (!invalid$iv3 || value$iv == Composer.Companion.getEmpty()) {
                final int totalCount2 = totalCount;
                value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj) {
                        Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0;
                        SteamGameDLCPageContent$lambda$13$0$1$10$1$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$1$0(filteredDlcs, ownedCount3, totalCount2, totalValue3, $filter$delegate, $appId, exposedList, $sourceFrom, (LazyListScope) obj);
                        return SteamGameDLCPageContent$lambda$13$0$1$10$1$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LazyDslKt.LazyColumn(nestedScroll$default, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer3, 0, 508);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        Object value$iv9 = (Function2) new SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$2$1(exposedList, null);
        $composer.updateRememberedValue(value$iv9);
        it$iv7 = value$iv9;
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv7, $composer, 0);
        int SteamGameDLCPageContent$lambda$1022 = SteamGameDLCPageContent$lambda$10($filter$delegate);
        ComposerKt.sourceInformationMarkerStart($composer, 1421575158, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        invalid$iv2 = $composer.changed(SteamGameDLCPageContent$lambda$1022);
        Object it$iv82 = $composer.rememberedValue();
        if (invalid$iv2) {
        }
        Object value$iv62 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda19
            public final Object invoke() {
                boolean SteamGameDLCPageContent$lambda$13$0$1$7$0;
                SteamGameDLCPageContent$lambda$13$0$1$7$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$7$0(listState3, r2);
                return Boolean.valueOf(SteamGameDLCPageContent$lambda$13$0$1$7$0);
            }
        });
        $composer.updateRememberedValue(value$iv62);
        it$iv82 = value$iv62;
        showSticky$delegate = (State) it$iv82;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 1421585843, "CC(remember):SteamGameDLCPage.kt#9igjgp");
        it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
        }
        SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$nestedScrollConnection$1$1 nestedScrollConnection2 = (SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$nestedScrollConnection$1$1) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
        int $changed$iv$iv3 = (6 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
        Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
        }
        $composer.startReusableNode();
        if (!$composer.getInserting()) {
        }
        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
        int i22 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 159508719, "C298@11798L6,293@11548L337,326@12955L5573,320@12688L5840:SteamGameDLCPage.kt#xy3gb6");
        SpacerKt.Spacer(ZIndexModifierKt.zIndex(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(90), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), -1.0f), $composer, 0);
        if (!SteamGameDLCPageContent$lambda$13$0$1$8(showSticky$delegate)) {
        }
        Modifier nestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, f, 1, (Object) null), nestedScrollConnection2, (NestedScrollDispatcher) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer3, 1667757045, str3);
        final int ownedCount32 = ownedCount;
        final String totalValue32 = totalValue;
        invalid$iv3 = $composer3.changed(ownedCount32) | $composer3.changed(totalCount) | $composer3.changed(totalValue32) | $composer3.changedInstance(filteredDlcs) | $composer3.changed($appId) | $composer3.changedInstance(exposedList) | $composer3.changed($sourceFrom);
        Composer $this$cache$iv2 = $composer3;
        value$iv = $this$cache$iv2.rememberedValue();
        if (!invalid$iv3) {
        }
        final int totalCount22 = totalCount;
        value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0;
                SteamGameDLCPageContent$lambda$13$0$1$10$1$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$1$0(filteredDlcs, ownedCount32, totalCount22, totalValue32, $filter$delegate, $appId, exposedList, $sourceFrom, (LazyListScope) obj);
                return SteamGameDLCPageContent$lambda$13$0$1$10$1$0;
            }
        };
        $this$cache$iv2.updateRememberedValue(value$iv);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        LazyDslKt.LazyColumn(nestedScroll$default2, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer3, 0, 508);
        ComposerKt.sourceInformationMarkerEnd($composer3);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    private static final boolean SteamGameDLCPageContent$lambda$13$0$1$8(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamGameDLCPageContent$lambda$13$0$1$7$0(LazyListState $listState, int $listTitleIndex) {
        return $listState.getFirstVisibleItemIndex() > $listTitleIndex + (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1$10$0$0$0(MutableIntState $filter$delegate, int filterValue) {
        $filter$delegate.setIntValue(filterValue);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0(final List $filteredDlcs, final int $ownedCount, final int $totalCount, final String $totalValue, final MutableIntState $filter$delegate, final String $appId, final List $exposedList, final String $sourceFrom, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1623907173, true, new Function3() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda17
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$0;
                SteamGameDLCPageContent$lambda$13$0$1$10$1$0$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$1$0$0($ownedCount, $totalCount, $totalValue, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGameDLCPageContent$lambda$13$0$1$10$1$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1402051684, true, new Function3() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda18
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1;
                SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1($totalCount, $filter$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1;
            }
        }), 3, (Object) null);
        if ($filteredDlcs.isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGameDLCPageKt.INSTANCE.m1260getLambda$1867982400$gamebiz_debug(), 3, (Object) null);
        } else {
            $this$LazyColumn.items($filteredDlcs.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$lambda$13$0$1$10$1$0$$inlined$itemsIndexed$default$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    $filteredDlcs.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$lambda$13$0$1$10$1$0$$inlined$itemsIndexed$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Function0 factory$iv$iv$iv;
                    ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                        }
                        int $changed2 = ($dirty & 14) | ($dirty & 112);
                        DLCDetail dlc = (DLCDetail) $filteredDlcs.get(it);
                        $composer.startReplaceGroup(1329353096);
                        ComposerKt.sourceInformation($composer, "CN(index,dlc)*393@16530L6,397@16805L969,394@16587L1187,389@16303L1841:SteamGameDLCPage.kt#xy3gb6");
                        final String dlcKey = "steam_dlc_" + $appId + "_" + dlc.getDlcAppId() + "_" + it;
                        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ExposureConfig exposureConfig = new ExposureConfig(true, 0.0f, 0, 0L, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer, 1289826298, "CC(remember):SteamGameDLCPage.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance($exposedList) | $composer.changed(dlcKey) | $composer.changed($appId) | $composer.changed($sourceFrom);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            final List list = $exposedList;
                            final String str = $appId;
                            final String str2 = $sourceFrom;
                            Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$SteamGameDLCPageContent$5$1$2$3$2$1$3$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1305invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1305invoke() {
                                    if (!list.contains(dlcKey)) {
                                        ReportKt.reportExposure("game-ball.steam-game-dlc.steam-game-dlc.list.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", str), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", str2), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom())}));
                                        list.add(dlcKey);
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier$iv = ExposerKt.reportOnExposure(modifier, dlcKey, null, null, exposureConfig, (Function0) it$iv, $composer, ExposureConfig.$stable << 12, 6);
                        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -1735132078, "C412@17848L262:SteamGameDLCPage.kt#xy3gb6");
                        Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        SteamGameDLCPageKt.DLCListItem(dlc, modifier$iv$iv, it == $filteredDlcs.size() - 1, $composer, (($changed2 >> 6) & 14) | 48, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }));
        }
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGameDLCPageKt.INSTANCE.getLambda$2117820061$gamebiz_debug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$0(int $ownedCount, int $totalCount, String $totalValue, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C329@13050L554:SteamGameDLCPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1623907173, $changed, -1, "kntr.app.game.steam.SteamGameDLCPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGameDLCPage.kt:329)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2109864105, "C330@13127L374,336@13534L40:SteamGameDLCPage.kt#xy3gb6");
            DLCStatisticsSection($ownedCount, $totalCount, $totalValue, PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(2), Dp.constructor-impl(16), Dp.constructor-impl(12)), $composer, 3072, 0);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
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
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1(int $totalCount, final MutableIntState $filter$delegate, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C342@13725L512:SteamGameDLCPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1402051684, $changed, -1, "kntr.app.game.steam.SteamGameDLCPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGameDLCPage.kt:342)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 627540348, "C346@13985L115,343@13802L405:SteamGameDLCPage.kt#xy3gb6");
            int SteamGameDLCPageContent$lambda$10 = SteamGameDLCPageContent$lambda$10($filter$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -2057961179, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object value$iv = $composer.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1$0$0$0;
                        SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1$0$0$0 = SteamGameDLCPageKt.SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1$0$0$0($filter$delegate, ((Integer) obj).intValue());
                        return SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            DLCListTitle($totalCount, SteamGameDLCPageContent$lambda$10, (Function1) value$iv, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 3456, 0);
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
    public static final Unit SteamGameDLCPageContent$lambda$13$0$1$10$1$0$1$0$0$0(MutableIntState $filter$delegate, int filterValue) {
        $filter$delegate.setIntValue(filterValue);
        return Unit.INSTANCE;
    }

    public static final void DLCTopAppBar(final String title, final Function0<Unit> function0, Modifier modifier, boolean immersive, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean immersive2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(function0, "onBackPress");
        Composer $composer3 = $composer.startRestartGroup(-1475767050);
        ComposerKt.sourceInformation($composer3, "C(DLCTopAppBar)N(title,onBackPress,modifier,immersive)441@18732L1053:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = immersive;
        } else if (($changed & 3072) == 0) {
            z = immersive;
            $dirty |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = immersive;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            immersive2 = z;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                immersive2 = z;
            } else {
                immersive2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1475767050, $dirty2, -1, "kntr.app.game.steam.DLCTopAppBar (SteamGameDLCPage.kt:440)");
            }
            $composer3.startReplaceGroup(-872920687);
            ComposerKt.sourceInformation($composer3, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier mod = modifier3;
            if (immersive2) {
                $composer3.startReplaceGroup(-1167744954);
                ComposerKt.sourceInformation($composer3, "446@18905L10");
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(mod, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6));
                $composer3.endReplaceGroup();
                modifier4 = windowInsetsPadding;
            } else {
                $composer3.startReplaceGroup(-1167645165);
                $composer3.endReplaceGroup();
                modifier4 = mod;
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv = SizeKt.defaultMinSize-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(modifier4, 0.0f, 0.0f, Dp.constructor-impl(0), 0.0f, 11, (Object) null), 0.0f, Dp.constructor-impl(40), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DLCTopAppBar_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -307904626, "C453@19102L214,460@19325L454:SteamGameDLCPage.kt#xy3gb6");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$SteamGameDLCPageKt.INSTANCE.m1259getLambda$1065676846$gamebiz_debug(), $composer3, (($dirty2 >> 3) & 14) | 1572864, 62);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$DLCTopAppBar_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.constructor-impl(48), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getLeft-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 1597824, 24960, 240552);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = immersive2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCTopAppBar$lambda$2;
                    DLCTopAppBar$lambda$2 = SteamGameDLCPageKt.DLCTopAppBar$lambda$2(title, function0, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCTopAppBar$lambda$2;
                }
            });
        }
    }

    public static final void DLCStatisticsSection(final int ownedCount, final int totalCount, final String totalValue, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Intrinsics.checkNotNullParameter(totalValue, "totalValue");
        Composer $composer3 = $composer.startRestartGroup(-1968815801);
        ComposerKt.sourceInformation($composer3, "C(DLCStatisticsSection)N(ownedCount,totalCount,totalValue,modifier)484@19936L3657:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(ownedCount) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(totalCount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(totalValue) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1968815801, $dirty2, -1, "kntr.app.game.steam.DLCStatisticsSection (SteamGameDLCPage.kt:483)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 9) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$DLCStatisticsSection_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 636306651, "C489@20062L1829,536@21916L197,545@22144L1443:SteamGameDLCPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$DLCStatisticsSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(60));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -793053363, "C496@20256L1625:SteamGameDLCPage.kt#xy3gb6");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2028341123, "C499@20364L1220,525@21601L40,526@21658L209:SteamGameDLCPage.kt#xy3gb6");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $changed$iv$iv$iv4 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, $changed$iv$iv$iv4);
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1951461515, "C507@20698L68,502@20467L381,515@21111L68,510@20869L334,522@21474L68,517@21224L342:SteamGameDLCPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(String.valueOf(ownedCount), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, FontWeight.Companion.getSemiBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597824, 48, 259882);
            TextKt.Text-Nvy7gAk(" / ", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24966, 48, 259946);
            TextKt.Text-Nvy7gAk(String.valueOf(totalCount), (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 48, 259946);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk("全部DLC", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597830, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 0.5d)), Dp.constructor-impl(37)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), $composer3, 6);
            Modifier modifier$iv5 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$DLCStatisticsSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(60));
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv11);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i12 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1082222969, "C552@22338L1239:SteamGameDLCPage.kt#xy3gb6");
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv6 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv6 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i13 = ($changed$iv$iv$iv7 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i14 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1512002103, "C555@22446L833,574@23296L40,575@23353L210:SteamGameDLCPage.kt#xy3gb6");
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv7 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv7 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv7);
            Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv6 = factory$iv$iv$iv13;
                $composer3.createNode(factory$iv$iv$iv6);
            } else {
                factory$iv$iv$iv6 = factory$iv$iv$iv13;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
            int i15 = ($changed$iv$iv$iv8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i16 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1907892208, "C563@22770L68,558@22549L313,570@23111L68,565@22883L378:SteamGameDLCPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("¥", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24966, 48, 259946);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(totalValue, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, FontWeight.Companion.getSemiBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, (($dirty2 >> 6) & 14) | 1597824, 48, 259882);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk("DLC总价值", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597830, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCStatisticsSection$lambda$1;
                    DLCStatisticsSection$lambda$1 = SteamGameDLCPageKt.DLCStatisticsSection$lambda$1(ownedCount, totalCount, totalValue, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCStatisticsSection$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0446, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0360, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x03d5, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v42 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DLCListTitle(final int totalCount, final int selectedTab, final Function1<? super Integer, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(function1, "onTabSelect");
        Composer $composer3 = $composer.startRestartGroup(-1223609631);
        ComposerKt.sourceInformation($composer3, "C(DLCListTitle)N(totalCount,selectedTab,onTabSelect,modifier)598@23891L6,593@23745L1365:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(totalCount) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selectedTab) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1223609631, $dirty2, -1, "kntr.app.game.steam.DLCListTitle (SteamGameDLCPage.kt:592)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null)), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(10), Dp.constructor-impl(0));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            modifier3 = modifier4;
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1791345390, "C604@24146L958:SteamGameDLCPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(18));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -835717077, "C612@24452L18,608@24297L225,615@24535L40,620@24738L18,616@24588L220,623@24821L40,628@25024L18,624@24874L220:SteamGameDLCPage.kt#xy3gb6");
            Integer valueOf = Integer.valueOf(totalCount);
            boolean z = selectedTab == 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -581143763, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit DLCListTitle$lambda$0$0$0$0;
                    DLCListTitle$lambda$0$0$0$0 = SteamGameDLCPageKt.DLCListTitle$lambda$0$0$0$0(function1);
                    return DLCListTitle$lambda$0$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DLCTabItemCompact("全部", valueOf, z, (Function0) it$iv, Modifier.Companion, $composer3, (($dirty2 << 3) & 112) | 24582, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer3, 6);
            boolean z2 = selectedTab == 1;
            ComposerKt.sourceInformationMarkerStart($composer3, -581134611, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda14
                public final Object invoke() {
                    Unit DLCListTitle$lambda$0$0$1$0;
                    DLCListTitle$lambda$0$0$1$0 = SteamGameDLCPageKt.DLCListTitle$lambda$0$0$1$0(function1);
                    return DLCListTitle$lambda$0$0$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DLCTabItemCompact("已拥有", null, z2, value$iv2, Modifier.Companion, $composer3, 24630, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer3, 6);
            boolean z3 = selectedTab == 2;
            ComposerKt.sourceInformationMarkerStart($composer3, -581125459, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda15
                public final Object invoke() {
                    Unit DLCListTitle$lambda$0$0$2$0;
                    DLCListTitle$lambda$0$0$2$0 = SteamGameDLCPageKt.DLCListTitle$lambda$0$0$2$0(function1);
                    return DLCListTitle$lambda$0$0$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv2 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DLCTabItemCompact("未拥有", null, z3, (Function0) it$iv2, Modifier.Companion, $composer3, 24630, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCListTitle$lambda$1;
                    DLCListTitle$lambda$1 = SteamGameDLCPageKt.DLCListTitle$lambda$1(totalCount, selectedTab, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCListTitle$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListTitle$lambda$0$0$0$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListTitle$lambda$0$0$1$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListTitle$lambda$0$0$2$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(2);
        return Unit.INSTANCE;
    }

    public static final void DLCTabItemCompact(final String text, final Integer count, final boolean selected, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        long j2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-230314999);
        ComposerKt.sourceInformation($composer3, "C(DLCTabItemCompact)N(text,count,selected,onClick,modifier)643@25275L537:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(selected) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty & 9347) != 9346, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-230314999, $dirty, -1, "kntr.app.game.steam.DLCTabItemCompact (SteamGameDLCPage.kt:642)");
            }
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(SizeKt.heightIn-VpY3zN4$default(modifier3, Dp.constructor-impl(18), 0.0f, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -870903058, "C650@25478L328:SteamGameDLCPage.kt#xy3gb6");
            if (selected) {
                $composer3.startReplaceGroup(-870830984);
                ComposerKt.sourceInformation($composer3, "654@25591L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU();
                $composer3.endReplaceGroup();
                j2 = j3;
            } else {
                $composer3.startReplaceGroup(-870764551);
                ComposerKt.sourceInformation($composer3, "656@25658L6");
                long j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU();
                $composer3.endReplaceGroup();
                j2 = j4;
            }
            long sp = TextUnitKt.getSp(13);
            FontWeight.Companion companion = FontWeight.Companion;
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j2, (TextAutoSize) null, sp, (FontStyle) null, selected ? companion.getBold() : companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty & 14) | 24576, 0, 262058);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCTabItemCompact$lambda$1;
                    DLCTabItemCompact$lambda$1 = SteamGameDLCPageKt.DLCTabItemCompact$lambda$1(text, count, selected, function0, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCTabItemCompact$lambda$1;
                }
            });
        }
    }

    public static final void DLCListItem(final DLCDetail dlc, Modifier modifier, boolean isLastItem, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isLastItem2;
        Function0 factory$iv$iv$iv;
        float tagOffsetY;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(dlc, "dlc");
        Composer $composer3 = $composer.startRestartGroup(945759583);
        ComposerKt.sourceInformation($composer3, "C(DLCListItem)N(dlc,modifier,isLastItem)670@25958L33,671@26025L36,672@26100L36,674@26181L7,687@26677L3033:SteamGameDLCPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(dlc) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = isLastItem;
        } else if (($changed & 384) == 0) {
            z = isLastItem;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = isLastItem;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            boolean isLastItem3 = i3 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945759583, $dirty2, -1, "kntr.app.game.steam.DLCListItem (SteamGameDLCPage.kt:669)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1658103296, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(1);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState lineCount$delegate = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1658101149, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableFloatState lastLineWidth$delegate = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1658098749, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableFloatState textLayoutWidth$delegate = (MutableFloatState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Density density = (Density) consume;
            float tagWidth = density.toPx-0680j_4(Dp.constructor-impl(36));
            float spacing = density.toPx-0680j_4(Dp.constructor-impl(6));
            density.toPx-0680j_4(Dp.constructor-impl(12));
            boolean needNewLine = dlc.getOwned() && (DLCListItem$lambda$4(lastLineWidth$delegate) + spacing) + tagWidth > DLCListItem$lambda$7(textLayoutWidth$delegate);
            int extraHeight = needNewLine ? 18 : 0;
            int $this$dp$iv = ((DLCListItem$lambda$1(lineCount$delegate) - 1) * 20) + 54 + extraHeight;
            float itemHeight = Dp.constructor-impl($this$dp$iv);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), itemHeight);
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            isLastItem2 = isLastItem3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DLCListItem_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 633463531, "C698@27021L6,703@27219L431,696@26953L708,755@29052L6,753@28976L318:SteamGameDLCPage.kt#xy3gb6");
            Modifier textModifier = PaddingKt.padding-qDBjuR0$default($this$DLCListItem_u24lambda_u2412.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.constructor-impl(12), Dp.constructor-impl(7), Dp.constructor-impl(12), 0.0f, 8, (Object) null);
            String dlcName = dlc.getDlcName();
            long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU();
            long sp = TextUnitKt.getSp(13);
            long sp2 = TextUnitKt.getSp(18);
            FontWeight normal = FontWeight.Companion.getNormal();
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(textModifier, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 713183112, "CC(remember):SteamGameDLCPage.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit DLCListItem$lambda$12$0$0;
                        DLCListItem$lambda$12$0$0 = SteamGameDLCPageKt.DLCListItem$lambda$12$0$0(lineCount$delegate, textLayoutWidth$delegate, lastLineWidth$delegate, (TextLayoutResult) obj);
                        return DLCListItem$lambda$12$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(dlcName, fillMaxWidth$default, j2, (TextAutoSize) null, sp, (FontStyle) null, normal, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 0, 0, (Function1) it$iv4, (TextStyle) null, $composer3, 1597440, 1572912, 194472);
            if (dlc.getOwned()) {
                $composer3.startReplaceGroup(634359151);
                ComposerKt.sourceInformation($composer3, "739@28545L6,734@28313L605");
                if (needNewLine) {
                    float f = Dp.constructor-impl(12);
                    int $i$f$getDp = DLCListItem$lambda$1(lineCount$delegate);
                    int $this$dp$iv2 = $i$f$getDp * 18;
                    tagOffsetY = Dp.constructor-impl(f + Dp.constructor-impl($this$dp$iv2));
                } else {
                    float f2 = Dp.constructor-impl(12);
                    int $i$f$getDp2 = DLCListItem$lambda$1(lineCount$delegate);
                    int $this$dp$iv3 = ($i$f$getDp2 - 1) * 18;
                    tagOffsetY = Dp.constructor-impl(Dp.constructor-impl(f2 + Dp.constructor-impl($this$dp$iv3)) + Dp.constructor-impl(2));
                }
                float tagOffsetX = needNewLine ? Dp.constructor-impl(12) : Dp.constructor-impl(Dp.constructor-impl(Dp.constructor-impl(12) + density.toDp-u2uoSUM(DLCListItem$lambda$4(lastLineWidth$delegate))) + Dp.constructor-impl(6));
                Modifier modifier5 = OffsetKt.offset-VpY3zN4(Modifier.Companion, tagOffsetX, tagOffsetY);
                float tagOffsetX2 = 36;
                float tagOffsetY2 = 14;
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(modifier5, Dp.constructor-impl(tagOffsetX2), Dp.constructor-impl(tagOffsetY2)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1345865888, "C744@28747L6,742@28669L235:SteamGameDLCPage.kt#xy3gb6");
                TextKt.Text-Nvy7gAk("已拥有", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(14), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24582, 48, 259050);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                $composer3.startReplaceGroup(606824393);
            }
            $composer3.endReplaceGroup();
            TextKt.Text-Nvy7gAk("¥" + dlc.getPriceYuan(), PaddingKt.padding-qDBjuR0$default($this$DLCListItem_u24lambda_u2412.align(Modifier.Companion, Alignment.Companion.getBottomStart()), Dp.constructor-impl(12), 0.0f, 0.0f, Dp.constructor-impl(12), 6, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(15), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 48, 260072);
            if (isLastItem2) {
                $composer3.startReplaceGroup(606824393);
            } else {
                $composer3.startReplaceGroup(635953481);
                ComposerKt.sourceInformation($composer3, "773@29668L6,766@29366L328");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$DLCListItem_u24lambda_u2412.align(Modifier.Companion, Alignment.Companion.getBottomStart()), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
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
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isLastItem2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = isLastItem2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameDLCPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCListItem$lambda$13;
                    DLCListItem$lambda$13 = SteamGameDLCPageKt.DLCListItem$lambda$13(DLCDetail.this, modifier6, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCListItem$lambda$13;
                }
            });
        }
    }

    private static final int DLCListItem$lambda$1(MutableIntState $lineCount$delegate) {
        IntState $this$getValue$iv = (IntState) $lineCount$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final float DLCListItem$lambda$4(MutableFloatState $lastLineWidth$delegate) {
        FloatState $this$getValue$iv = (FloatState) $lastLineWidth$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float DLCListItem$lambda$7(MutableFloatState $textLayoutWidth$delegate) {
        FloatState $this$getValue$iv = (FloatState) $textLayoutWidth$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCListItem$lambda$12$0$0(MutableIntState $lineCount$delegate, MutableFloatState $textLayoutWidth$delegate, MutableFloatState $lastLineWidth$delegate, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        $lineCount$delegate.setIntValue(textLayoutResult.getLineCount());
        $textLayoutWidth$delegate.setFloatValue((int) (textLayoutResult.getSize-YbymL2g() >> 32));
        if (DLCListItem$lambda$1($lineCount$delegate) > 0) {
            int lastLineIndex = DLCListItem$lambda$1($lineCount$delegate) - 1;
            $lastLineWidth$delegate.setFloatValue(textLayoutResult.getLineRight(lastLineIndex) - textLayoutResult.getLineLeft(lastLineIndex));
        }
        return Unit.INSTANCE;
    }
}