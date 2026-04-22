package kntr.app.game.steam;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ColorMatrix;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.ContentScale;
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
import java.util.Iterator;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.ExposureConfig;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.bean.AchievementDetail;
import kntr.app.game.bean.AchievementHeader;
import kntr.app.game.bean.AchievementStats;
import kntr.app.game.bean.GameAchievementsData;
import kntr.app.game.report.ReportKt;
import kntr.app.game.steam.background.SteamGameBackgroundKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.base.ui.generated.resources.Font0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;
import srcs.app.game.gamebiz.generated.resources.Drawable0_commonMainKt;
import srcs.app.game.gamebiz.generated.resources.Res;

/* compiled from: SteamGameAchievementPage.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aE\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\n\u001aU\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a7\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001a\u001a_\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010!\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020\f2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010(\u001a)\u0010)\u001a\u00020\u00012\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010,\u001a\u00020\fH\u0007¢\u0006\u0002\u0010-¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u001f\u001a\u00020\fX\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\fX\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"SteamGameAchievementPage", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "appId", RouterHelperKt.PARAM_SOURCE_FROM, "modifier", "Landroidx/compose/ui/Modifier;", "steamGameName", "defaultShowRareOnly", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SteamGameAchievementPageContent", RoomRecommendViewModel.EMPTY_CURSOR, "onBackPress", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "AchievementTopAppBar", "title", "immersive", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "AchievementStatisticsSection", "achievedCount", RoomRecommendViewModel.EMPTY_CURSOR, "totalCount", "achieveRate", RoomRecommendViewModel.EMPTY_CURSOR, "(IIFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AchievementListTitle", "selectedTab", "onTabSelect", "Lkotlin/Function1;", "showRareOnly", "onRareFilterToggle", "hasRareAchievements", "(IILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "AchievementTabItemCompact", "text", "count", "selected", "onClick", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AchievementListItem", "achievement", "Lkntr/app/game/bean/AchievementDetail;", "isLastItem", "(Lkntr/app/game/bean/AchievementDetail;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "gamebiz_debug", "currentBackgroundBrush", "Landroidx/compose/ui/graphics/Brush;", "unlockFilter", "showSticky", "titleLineCount", "descLineCount"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamGameAchievementPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$7(AchievementDetail achievementDetail, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        AchievementListItem(achievementDetail, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListTitle$lambda$2(int i, int i2, Function1 function1, Modifier modifier, boolean z, Function0 function0, boolean z2, int i3, int i4, Composer composer, int i5) {
        AchievementListTitle(i, i2, function1, modifier, z, function0, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementStatisticsSection$lambda$1(int i, int i2, float f, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        AchievementStatisticsSection(i, i2, f, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementTabItemCompact$lambda$1(String str, Integer num, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AchievementTabItemCompact(str, num, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementTopAppBar$lambda$2(String str, Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        AchievementTopAppBar(str, function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPage$lambda$1(String str, String str2, String str3, Modifier modifier, String str4, String str5, int i, int i2, Composer composer, int i3) {
        SteamGameAchievementPage(str, str2, str3, modifier, str4, str5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$17(String str, String str2, String str3, Modifier modifier, String str4, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamGameAchievementPageContent(str, str2, str3, modifier, str4, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void SteamGameAchievementPage(final String steamId, final String appId, final String sourceFrom, Modifier modifier, String steamGameName, String defaultShowRareOnly, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String str2;
        Modifier modifier3;
        String steamGameName2;
        String defaultShowRareOnly2;
        String defaultShowRareOnly3;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-1053312350);
        ComposerKt.sourceInformation($composer2, "C(SteamGameAchievementPage)N(steamId,appId,sourceFrom,modifier,steamGameName,defaultShowRareOnly)107@4962L7,115@5295L51,108@4974L379:SteamGameAchievementPage.kt#xy3gb6");
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
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty |= 196608;
            str2 = defaultShowRareOnly;
        } else if ((196608 & $changed) == 0) {
            str2 = defaultShowRareOnly;
            $dirty |= $composer2.changed(str2) ? 131072 : 65536;
        } else {
            str2 = defaultShowRareOnly;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            steamGameName2 = str;
            defaultShowRareOnly2 = str2;
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
            if (i4 == 0) {
                defaultShowRareOnly3 = str2;
            } else {
                defaultShowRareOnly3 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053312350, $dirty2, -1, "kntr.app.game.steam.SteamGameAchievementPage (SteamGameAchievementPage.kt:106)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            boolean z = Intrinsics.areEqual(defaultShowRareOnly3, "1") || StringsKt.equals(defaultShowRareOnly3, "true", true);
            ComposerKt.sourceInformationMarkerStart($composer2, 1379132437, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(backHandler);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit SteamGameAchievementPage$lambda$0$0;
                        SteamGameAchievementPage$lambda$0$0 = SteamGameAchievementPageKt.SteamGameAchievementPage$lambda$0$0(backHandler);
                        return SteamGameAchievementPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            defaultShowRareOnly2 = defaultShowRareOnly3;
            SteamGameAchievementPageContent(steamId, appId, sourceFrom, modifier3, steamGameName2, z, (Function0) it$iv, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str3 = steamGameName2;
            final String str4 = defaultShowRareOnly2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameAchievementPage$lambda$1;
                    SteamGameAchievementPage$lambda$1 = SteamGameAchievementPageKt.SteamGameAchievementPage$lambda$1(steamId, appId, sourceFrom, modifier4, str3, str4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameAchievementPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPage$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x06f4, code lost:
        if (r0 == null) goto L131;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v104, types: [java.lang.Object[], androidx.compose.ui.graphics.Color[]] */
    /* JADX WARN: Type inference failed for: r5v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void SteamGameAchievementPageContent(final String steamId, final String appId, final String sourceFrom, Modifier modifier, String steamGameName, boolean defaultShowRareOnly, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Function0 onBackPress;
        String steamGameName2;
        Modifier modifier3;
        boolean defaultShowRareOnly2;
        Function0 onBackPress2;
        boolean z2;
        int $dirty;
        String spmid;
        Toaster toaster;
        CoroutineScope scope;
        SteamGameAchievementVM viewModel;
        Function0 onBackPress3;
        int i2;
        final String spmid2;
        Toaster toaster2;
        Unit unit;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        String it;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(sourceFrom, RouterHelperKt.PARAM_SOURCE_FROM);
        Composer $composer2 = $composer.startRestartGroup(-1586218886);
        ComposerKt.sourceInformation($composer2, "C(SteamGameAchievementPageContent)N(steamId,appId,sourceFrom,modifier,steamGameName,defaultShowRareOnly,onBackPress)129@5612L2,136@5812L47,138@5891L164,143@6090L53,147@6199L28,147@6189L38,148@6244L24,149@6300L7,154@6449L86,155@6567L256,155@6540L283,164@6870L137,164@6847L160,172@7058L33,173@7116L48,175@7191L259,175@7170L280,187@7486L13563:SteamGameAchievementPage.kt#xy3gb6");
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
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changed(steamGameName) ? 16384 : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            z = defaultShowRareOnly;
        } else if (($changed & 196608) == 0) {
            z = defaultShowRareOnly;
            $dirty2 |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = defaultShowRareOnly;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty2 |= 1572864;
            onBackPress = function0;
        } else if (($changed & 1572864) == 0) {
            onBackPress = function0;
            $dirty2 |= $composer2.changedInstance(onBackPress) ? 1048576 : 524288;
        } else {
            onBackPress = function0;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            Modifier modifier4 = i3 != 0 ? (Modifier) Modifier.Companion : modifier2;
            steamGameName2 = i4 != 0 ? null : steamGameName;
            defaultShowRareOnly2 = i5 != 0 ? false : z;
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 357048412, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda27
                        public final Object invoke() {
                            Unit unit2;
                            unit2 = Unit.INSTANCE;
                            return unit2;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackPress4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onBackPress = onBackPress4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1586218886, $dirty2, -1, "kntr.app.game.steam.SteamGameAchievementPageContent (SteamGameAchievementPage.kt:130)");
            }
            ColorKt.Color(4279969848L);
            ComposerKt.sourceInformationMarkerStart($composer2, 357054857, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SteamGameBackgroundKt.calculateSteamGradientColors(null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Pair defaultGradientColors = (Pair) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 357057502, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                z2 = true;
                Object value$iv3 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{defaultGradientColors.getFirst(), defaultGradientColors.getSecond()}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            } else {
                z2 = true;
            }
            Brush defaultBrush = (Brush) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 357063759, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(defaultBrush, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default);
                it$iv4 = mutableStateOf$default;
            }
            final MutableState currentBackgroundBrush$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 357067222, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda28
                    public final Object invoke(Object obj) {
                        SteamGameAchievementVM SteamGameAchievementPageContent$lambda$6$0;
                        SteamGameAchievementPageContent$lambda$6$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$6$0((CreationExtras) obj);
                        return SteamGameAchievementPageContent$lambda$6$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
            }
            Function1 initializer$iv = (Function1) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer2, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SteamGameAchievementVM.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(SteamGameAchievementVM.class), initializer$iv);
            ViewModel viewModel2 = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            SteamGameAchievementVM viewModel3 = (SteamGameAchievementVM) viewModel2;
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
            Toaster toaster3 = (Toaster) consume;
            String spmidFrom = KntrGameReportService.INSTANCE.getSpmidFrom();
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("game-ball.steam-game-achievement.steam-game-achievement.0.pv", $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 357079226, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256 ? z2 : false) | $composer2.changedInstance(pvTrigger) | $composer2.changed(spmidFrom) | (($dirty2 & 112) == 32 ? z2 : false);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-achievement";
                toaster = toaster3;
                scope = scope2;
                viewModel = viewModel3;
                onBackPress3 = onBackPress;
                i2 = 0;
                value$iv5 = new SteamGameAchievementPageKt$SteamGameAchievementPageContent$2$1(pvTrigger, "game-ball.steam-game-achievement", sourceFrom, spmidFrom, appId, null);
                $composer2.updateRememberedValue(value$iv5);
            } else {
                viewModel = viewModel3;
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-achievement";
                onBackPress3 = onBackPress;
                i2 = 0;
                toaster = toaster3;
                scope = scope2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(sourceFrom, (Function2) value$iv5, $composer2, ($dirty >> 6) & 14);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 357088803, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv6 = $composer2.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                spmid2 = spmid;
                Object value$iv6 = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SteamGameAchievementPageContent$lambda$8$0;
                        SteamGameAchievementPageContent$lambda$8$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$8$0(spmid2, (DisposableEffectScope) obj);
                        return SteamGameAchievementPageContent$lambda$8$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            } else {
                spmid2 = spmid;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv6, $composer2, 54);
            ComposerKt.sourceInformationMarkerStart($composer2, 357094715, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv7 = $composer2.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = SnapshotIntStateKt.mutableIntStateOf(i2);
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            final MutableIntState unlockFilter$delegate = (MutableIntState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 357096586, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv8 = $composer2.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default2 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(defaultShowRareOnly2), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(mutableStateOf$default2);
                it$iv8 = mutableStateOf$default2;
            }
            final MutableState showRareOnly$delegate = (MutableState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 357099197, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Toaster toaster4 = toaster;
            int i7 = ($composer2.changedInstance(viewModel) ? 1 : 0) | (($dirty & 14) == 4 ? 1 : i2) | (($dirty & 112) == 32 ? 1 : i2) | ($composer2.changedInstance(scope) ? 1 : 0) | ($composer2.changedInstance(toaster4) ? 1 : 0);
            Object value$iv8 = $composer2.rememberedValue();
            if (i7 != 0 || value$iv8 == Composer.Companion.getEmpty()) {
                toaster2 = toaster4;
                unit = unit3;
                value$iv8 = new SteamGameAchievementPageKt$SteamGameAchievementPageContent$4$1(viewModel, steamId, appId, scope, toaster4, null);
                $composer2.updateRememberedValue(value$iv8);
            } else {
                toaster2 = toaster4;
                unit = unit3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv8, $composer2, 6);
            Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), SteamGameAchievementPageContent$lambda$4(currentBackgroundBrush$delegate), (Shape) null, 0.0f, 6, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, i2));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier5 = modifier4;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -158145002, "C188@7578L13465:SteamGameAchievementPage.kt#xy3gb6");
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
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i11 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1810976243, "C190@7671L196,202@8115L12918,196@7881L13152:SteamGameAchievementPage.kt#xy3gb6");
            if (steamGameName2 != null) {
                String it2 = steamGameName2;
                $composer$iv = $composer2;
                it = "《" + it2 + "》成就详情";
            } else {
                $composer$iv = $composer2;
            }
            it = RoomRecommendViewModel.EMPTY_CURSOR;
            AchievementTopAppBar(it, onBackPress3, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, $composer2, (($dirty >> 15) & 112) | 384, 8);
            final String str = steamGameName2;
            modifier3 = modifier5;
            LoadComposableKt.LoadComposable(viewModel, sourceFrom, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, ComposableLambdaKt.rememberComposableLambda(-551235954, true, new Function5() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit SteamGameAchievementPageContent$lambda$16$0$1;
                    SteamGameAchievementPageContent$lambda$16$0$1 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1(str, currentBackgroundBrush$delegate, unlockFilter$delegate, showRareOnly$delegate, appId, sourceFrom, (GameAchievementsData) obj, (SteamGameAchievementVM) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return SteamGameAchievementPageContent$lambda$16$0$1;
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
            onBackPress2 = onBackPress3;
        } else {
            $composer2.skipToGroupEnd();
            steamGameName2 = steamGameName;
            modifier3 = modifier2;
            defaultShowRareOnly2 = z;
            onBackPress2 = onBackPress;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str2 = steamGameName2;
            final boolean z3 = defaultShowRareOnly2;
            final Function0 function02 = onBackPress2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameAchievementPageContent$lambda$17;
                    SteamGameAchievementPageContent$lambda$17 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$17(steamId, appId, sourceFrom, modifier6, str2, z3, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameAchievementPageContent$lambda$17;
                }
            });
        }
    }

    private static final Brush SteamGameAchievementPageContent$lambda$4(MutableState<Brush> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Brush) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SteamGameAchievementVM SteamGameAchievementPageContent$lambda$6$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new SteamGameAchievementVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SteamGameAchievementPageContent$lambda$8$0(final String $spmid, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$lambda$8$0$$inlined$onDispose$1
            public void dispose() {
                KntrGameReportService.INSTANCE.setSpmidFrom($spmid);
            }
        };
    }

    private static final int SteamGameAchievementPageContent$lambda$10(MutableIntState $unlockFilter$delegate) {
        IntState $this$getValue$iv = (IntState) $unlockFilter$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final boolean SteamGameAchievementPageContent$lambda$13(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void SteamGameAchievementPageContent$lambda$14(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0437, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05e2  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x07d3  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x08c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1(String $steamGameName, MutableState $currentBackgroundBrush$delegate, final MutableIntState $unlockFilter$delegate, final MutableState $showRareOnly$delegate, final String $appId, final String $sourceFrom, GameAchievementsData achievementsData, SteamGameAchievementVM vm, PageLoadMoreState pageLoadMoreState, Composer $composer, int $changed) {
        int i;
        String str;
        boolean z;
        Iterable achievements;
        boolean z2;
        LazyListState lazyListState;
        boolean invalid$iv;
        State showSticky$delegate;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        String str2;
        float achieveRate;
        int statusBarHeight;
        Composer $composer$iv;
        Composer $composer$iv2;
        LazyListState listState;
        Composer $composer2;
        boolean invalid$iv2;
        Object value$iv;
        Composer $composer$iv$iv;
        Intrinsics.checkNotNullParameter(achievementsData, "achievementsData");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(pageLoadMoreState, "$unused$var$");
        ComposerKt.sourceInformation($composer, "CN(achievementsData,vm)215@8789L125,219@8970L232,226@9289L77,226@9260L106,232@9459L135,238@9716L761,254@10542L36,256@10623L7,257@10682L10,262@10907L23,263@10964L23,264@11021L23,273@11379L59,273@11336L102,280@11604L178,288@11913L1161,317@13140L7879:SteamGameAchievementPage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-551235954, $changed, -1, "kntr.app.game.steam.SteamGameAchievementPageContent.<anonymous>.<anonymous>.<anonymous> (SteamGameAchievementPage.kt:203)");
        }
        AchievementHeader header = achievementsData.getHeader();
        AchievementStats stats = header != null ? header.getAchievementStats() : null;
        int totalCount = stats != null ? stats.getTotalCount() : achievementsData.getTotalCount();
        if (stats != null) {
            i = stats.getUnlockedCount();
        } else {
            Iterable $this$count$iv = achievementsData.getAchievements();
            if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                i = 0;
            } else {
                int count$iv = 0;
                for (Object element$iv : $this$count$iv) {
                    AchievementDetail it = (AchievementDetail) element$iv;
                    if (it.getAchieved() && (count$iv = count$iv + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
                i = count$iv;
            }
        }
        int achievedCount = i;
        float achieveRate2 = totalCount > 0 ? (achievedCount * 100.0f) / totalCount : 0.0f;
        if ($steamGameName == null) {
            str = header != null ? header.getGameName() : null;
            if (str == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
        } else {
            str = $steamGameName;
        }
        String appIconRgb = header != null ? header.getAppIconRgb() : null;
        ComposerKt.sourceInformationMarkerStart($composer, -1456752693, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv3 = $composer.changed(appIconRgb);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SteamGameBackgroundKt.calculateSteamGradientColors(header != null ? header.getAppIconRgb() : null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        Pair dynamicGradientColors = (Pair) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        String appIconRgb2 = header != null ? header.getAppIconRgb() : null;
        ComposerKt.sourceInformationMarkerStart($composer, -1456746794, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv4 = $composer.changed(appIconRgb2);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv4 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{dynamicGradientColors.getFirst(), dynamicGradientColors.getSecond()}), 0.0f, 0.0f, 0, 14, (Object) null);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Brush dynamicBrush = (Brush) it$iv3;
        ComposerKt.sourceInformationMarkerStart($composer, -1456736741, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv5 = $composer.changed(dynamicBrush);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv5 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = (Function2) new SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$1$1(dynamicBrush, $currentBackgroundBrush$delegate, null);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(dynamicBrush, (Function2) it$iv4, $composer, 0);
        List<AchievementDetail> achievements2 = achievementsData.getAchievements();
        ComposerKt.sourceInformationMarkerStart($composer, -1456731243, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv6 = $composer.changed(achievements2);
        Object it$iv5 = $composer.rememberedValue();
        if (invalid$iv6 || it$iv5 == Composer.Companion.getEmpty()) {
            Iterable $this$any$iv = achievementsData.getAchievements();
            boolean invalid$iv7 = $this$any$iv instanceof Collection;
            if (!invalid$iv7 || !((Collection) $this$any$iv).isEmpty()) {
                Iterator<T> it2 = $this$any$iv.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Object element$iv2 = it2.next();
                        AchievementDetail it3 = (AchievementDetail) element$iv2;
                        if (it3.isRare()) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
            } else {
                z = false;
            }
            Object value$iv5 = Boolean.valueOf(z);
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
        }
        final boolean hasRareAchievements = ((Boolean) it$iv5).booleanValue();
        ComposerKt.sourceInformationMarkerEnd($composer);
        List<AchievementDetail> achievements3 = achievementsData.getAchievements();
        int SteamGameAchievementPageContent$lambda$10 = SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate);
        boolean SteamGameAchievementPageContent$lambda$13 = SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate);
        ComposerKt.sourceInformationMarkerStart($composer, -1456722393, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv8 = $composer.changed(achievements3) | $composer.changed(SteamGameAchievementPageContent$lambda$10) | $composer.changed(SteamGameAchievementPageContent$lambda$13);
        Object it$iv6 = $composer.rememberedValue();
        if (invalid$iv8 || it$iv6 == Composer.Companion.getEmpty()) {
            switch (SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate)) {
                case 0:
                    achievements = achievementsData.getAchievements();
                    break;
                case 1:
                    Iterable $this$filter$iv = achievementsData.getAchievements();
                    boolean z3 = false;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        Iterable $this$filter$iv2 = $this$filter$iv;
                        AchievementDetail it4 = (AchievementDetail) element$iv$iv;
                        if (it4.getAchieved()) {
                            z2 = z3;
                            destination$iv$iv.add(element$iv$iv);
                        } else {
                            z2 = z3;
                        }
                        $this$filter$iv = $this$filter$iv2;
                        z3 = z2;
                    }
                    achievements = (List) destination$iv$iv;
                    break;
                case 2:
                    Collection destination$iv$iv2 = new ArrayList();
                    for (Object element$iv$iv2 : achievementsData.getAchievements()) {
                        Brush dynamicBrush2 = dynamicBrush;
                        AchievementDetail it5 = (AchievementDetail) element$iv$iv2;
                        if (!it5.getAchieved()) {
                            destination$iv$iv2.add(element$iv$iv2);
                        }
                        dynamicBrush = dynamicBrush2;
                    }
                    achievements = (List) destination$iv$iv2;
                    break;
                default:
                    achievements = achievementsData.getAchievements();
                    break;
            }
            if (SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate)) {
                Iterable $this$filter$iv3 = achievements;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv3 : $this$filter$iv3) {
                    Iterable $this$filter$iv4 = $this$filter$iv3;
                    AchievementDetail it6 = (AchievementDetail) element$iv$iv3;
                    if (it6.isRare()) {
                        destination$iv$iv3.add(element$iv$iv3);
                    }
                    $this$filter$iv3 = $this$filter$iv4;
                }
                achievements = (List) destination$iv$iv3;
            }
            $composer.updateRememberedValue(achievements);
            it$iv6 = achievements;
        }
        final List filteredAchievements = (List) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1456696686, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        Object it$iv7 = $composer.rememberedValue();
        if (it$iv7 == Composer.Companion.getEmpty()) {
            Object value$iv6 = (List) new ArrayList();
            $composer.updateRememberedValue(value$iv6);
            it$iv7 = value$iv6;
        }
        final List exposedList = (List) it$iv7;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density density = (Density) consume;
        int statusBarHeight2 = WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6).getTop(density);
        Dp.constructor-impl(density.toDp-u2uoSUM(statusBarHeight2) + Dp.constructor-impl(40));
        LazyListState listState0 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        LazyListState listState1 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        LazyListState listState2 = LazyListStateKt.rememberLazyListState(0, 0, $composer, 0, 3);
        switch (SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate)) {
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
        Integer valueOf = Integer.valueOf(SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate));
        Boolean valueOf2 = Boolean.valueOf(SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate));
        ComposerKt.sourceInformationMarkerStart($composer, -1456669879, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        boolean invalid$iv9 = $composer.changedInstance(exposedList);
        SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$2$1 value$iv7 = $composer.rememberedValue();
        if (!invalid$iv9 && value$iv7 != Composer.Companion.getEmpty()) {
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) value$iv7, $composer, 0);
            int SteamGameAchievementPageContent$lambda$102 = SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1456662560, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            invalid$iv = $composer.changed(SteamGameAchievementPageContent$lambda$102);
            Object it$iv8 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv8 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    boolean SteamGameAchievementPageContent$lambda$16$0$1$9$0;
                    SteamGameAchievementPageContent$lambda$16$0$1$9$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$9$0(listState3, r2);
                    return Boolean.valueOf(SteamGameAchievementPageContent$lambda$16$0$1$9$0);
                }
            });
            $composer.updateRememberedValue(value$iv8);
            it$iv8 = value$iv8;
            showSticky$delegate = (State) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1456651689, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv9 = new NestedScrollConnection() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$nestedScrollConnection$1$1
                    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                    public long m1298onPreScrollOzD1aCk(long j2, int i2) {
                        return Offset.Companion.getZero-F1C5BW0();
                    }

                    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                    public long m1296onPostScrollDzOQY0M(long j2, long j3, int i2) {
                        return j3;
                    }

                    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                    public Object m1297onPreFlingQWom1Mo(long j2, Continuation<? super Velocity> continuation) {
                        return Velocity.box-impl(Velocity.Companion.getZero-9UxMQ8M());
                    }

                    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                    public Object m1295onPostFlingRZ2iAVY(long j2, long j3, Continuation<? super Velocity> continuation) {
                        return Velocity.box-impl(j3);
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                it$iv = value$iv9;
            }
            SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$nestedScrollConnection$1$1 nestedScrollConnection = (SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$nestedScrollConnection$1$1) it$iv;
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
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -2012150161, "C324@13507L6,319@13257L337,357@14965L6036,351@14698L6303:SteamGameAchievementPage.kt#xy3gb6");
            SpacerKt.Spacer(ZIndexModifierKt.zIndex(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(90), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), -1.0f), $composer, 0);
            if (SteamGameAchievementPageContent$lambda$16$0$1$10(showSticky$delegate)) {
                $composer$iv$iv$iv = $composer;
                str2 = "CC(remember):SteamGameAchievementPage.kt#9igjgp";
                achieveRate = achieveRate2;
                statusBarHeight = achievedCount;
                $composer$iv = $composer;
                $composer$iv2 = $composer;
                listState = listState3;
                $composer2 = $composer;
                $composer2.startReplaceGroup(-2025542162);
                $composer2.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-2011985831);
                ComposerKt.sourceInformation($composer, "329@13658L997");
                Modifier modifier$iv2 = ZIndexModifierKt.zIndex(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48)), 2.0f);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                $composer$iv$iv$iv = $composer;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 889419848, "C339@14136L103,344@14423L100,336@13951L678:SteamGameAchievementPage.kt#xy3gb6");
                int SteamGameAchievementPageContent$lambda$103 = SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 305790972, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object value$iv10 = $composer.rememberedValue();
                if (value$iv10 == Composer.Companion.getEmpty()) {
                    value$iv10 = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj) {
                            Unit SteamGameAchievementPageContent$lambda$16$0$1$12$0$0$0;
                            SteamGameAchievementPageContent$lambda$16$0$1$12$0$0$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$0$0$0($unlockFilter$delegate, ((Integer) obj).intValue());
                            return SteamGameAchievementPageContent$lambda$16$0$1$12$0$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv10);
                }
                Function1 function1 = (Function1) value$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                boolean SteamGameAchievementPageContent$lambda$132 = SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate);
                ComposerKt.sourceInformationMarkerStart($composer, 305800153, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object it$iv9 = $composer.rememberedValue();
                if (it$iv9 == Composer.Companion.getEmpty()) {
                    $composer$iv$iv = $composer;
                    Object value$iv11 = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda19
                        public final Object invoke() {
                            Unit SteamGameAchievementPageContent$lambda$16$0$1$12$0$1$0;
                            SteamGameAchievementPageContent$lambda$16$0$1$12$0$1$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$0$1$0($showRareOnly$delegate);
                            return SteamGameAchievementPageContent$lambda$16$0$1$12$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv11);
                    it$iv9 = value$iv11;
                } else {
                    $composer$iv$iv = $composer;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer$iv = $composer;
                $composer$iv2 = $composer;
                listState = listState3;
                str2 = "CC(remember):SteamGameAchievementPage.kt#9igjgp";
                achieveRate = achieveRate2;
                statusBarHeight = achievedCount;
                AchievementListTitle(totalCount, SteamGameAchievementPageContent$lambda$103, function1, fillMaxWidth$default, SteamGameAchievementPageContent$lambda$132, (Function0) it$iv9, hasRareAchievements, $composer, 200064, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                $composer2 = $composer;
            }
            Modifier nestedScroll$default = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), nestedScrollConnection, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1874807528, str2);
            invalid$iv2 = $composer2.changed(statusBarHeight) | $composer2.changed(totalCount) | $composer2.changed(achieveRate) | $composer2.changed(hasRareAchievements) | $composer2.changedInstance(filteredAchievements) | $composer2.changed($appId) | $composer2.changedInstance(exposedList) | $composer2.changed($sourceFrom);
            Composer $this$cache$iv = $composer2;
            value$iv = $this$cache$iv.rememberedValue();
            if (!invalid$iv2 || value$iv == Composer.Companion.getEmpty()) {
                final int i6 = statusBarHeight;
                final int i7 = totalCount;
                final float f = achieveRate;
                value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj) {
                        Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0;
                        SteamGameAchievementPageContent$lambda$16$0$1$12$1$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0(filteredAchievements, i6, i7, f, hasRareAchievements, $unlockFilter$delegate, $showRareOnly$delegate, $appId, exposedList, $sourceFrom, (LazyListScope) obj);
                        return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(nestedScroll$default, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, 0, 508);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return Unit.INSTANCE;
        }
        value$iv7 = new SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$2$1(exposedList, null);
        $composer.updateRememberedValue(value$iv7);
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) value$iv7, $composer, 0);
        int SteamGameAchievementPageContent$lambda$1022 = SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate);
        ComposerKt.sourceInformationMarkerStart($composer, -1456662560, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        invalid$iv = $composer.changed(SteamGameAchievementPageContent$lambda$1022);
        Object it$iv82 = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv82 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda17
            public final Object invoke() {
                boolean SteamGameAchievementPageContent$lambda$16$0$1$9$0;
                SteamGameAchievementPageContent$lambda$16$0$1$9$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$9$0(listState3, r2);
                return Boolean.valueOf(SteamGameAchievementPageContent$lambda$16$0$1$9$0);
            }
        });
        $composer.updateRememberedValue(value$iv82);
        it$iv82 = value$iv82;
        showSticky$delegate = (State) it$iv82;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -1456651689, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
        it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
        }
        SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$nestedScrollConnection$1$1 nestedScrollConnection2 = (SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$nestedScrollConnection$1$1) it$iv;
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
        Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
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
        int i22 = ($changed$iv$iv$iv3 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
        int i32 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -2012150161, "C324@13507L6,319@13257L337,357@14965L6036,351@14698L6303:SteamGameAchievementPage.kt#xy3gb6");
        SpacerKt.Spacer(ZIndexModifierKt.zIndex(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(90), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), -1.0f), $composer, 0);
        if (SteamGameAchievementPageContent$lambda$16$0$1$10(showSticky$delegate)) {
        }
        Modifier nestedScroll$default2 = NestedScrollModifierKt.nestedScroll$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), nestedScrollConnection2, (NestedScrollDispatcher) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer2, 1874807528, str2);
        invalid$iv2 = $composer2.changed(statusBarHeight) | $composer2.changed(totalCount) | $composer2.changed(achieveRate) | $composer2.changed(hasRareAchievements) | $composer2.changedInstance(filteredAchievements) | $composer2.changed($appId) | $composer2.changedInstance(exposedList) | $composer2.changed($sourceFrom);
        Composer $this$cache$iv2 = $composer2;
        value$iv = $this$cache$iv2.rememberedValue();
        if (!invalid$iv2) {
        }
        final int i62 = statusBarHeight;
        final int i72 = totalCount;
        final float f2 = achieveRate;
        value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0;
                SteamGameAchievementPageContent$lambda$16$0$1$12$1$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0(filteredAchievements, i62, i72, f2, hasRareAchievements, $unlockFilter$delegate, $showRareOnly$delegate, $appId, exposedList, $sourceFrom, (LazyListScope) obj);
                return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0;
            }
        };
        $this$cache$iv2.updateRememberedValue(value$iv);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LazyDslKt.LazyColumn(nestedScroll$default2, listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer2, 0, 508);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    private static final boolean SteamGameAchievementPageContent$lambda$16$0$1$10(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SteamGameAchievementPageContent$lambda$16$0$1$9$0(LazyListState $listState, int $listTitleIndex) {
        return $listState.getFirstVisibleItemIndex() > $listTitleIndex + (-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$0$0$0(MutableIntState $unlockFilter$delegate, int filter) {
        $unlockFilter$delegate.setIntValue(filter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$0$1$0(MutableState $showRareOnly$delegate) {
        SteamGameAchievementPageContent$lambda$14($showRareOnly$delegate, !SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0(final List $filteredAchievements, final int $achievedCount, final int $totalCount, final float $achieveRate, final boolean $hasRareAchievements, final MutableIntState $unlockFilter$delegate, final MutableState $showRareOnly$delegate, final String $appId, final List $exposedList, final String $sourceFrom, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(653910761, true, new Function3() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda10
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$0;
                SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$0($achievedCount, $totalCount, $achieveRate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(551462944, true, new Function3() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1;
                SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1($totalCount, $hasRareAchievements, $unlockFilter$delegate, $showRareOnly$delegate, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1;
            }
        }), 3, (Object) null);
        if ($filteredAchievements.isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGameAchievementPageKt.INSTANCE.getLambda$1567697476$gamebiz_debug(), 3, (Object) null);
        } else {
            $this$LazyColumn.items($filteredAchievements.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$$inlined$itemsIndexed$default$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    $filteredAchievements.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$$inlined$itemsIndexed$default$3
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
                        AchievementDetail achievement = (AchievementDetail) $filteredAchievements.get(it);
                        $composer.startReplaceGroup(49262417);
                        ComposerKt.sourceInformation($composer, "CN(index,achievement)*429@18931L6,433@19214L1001,430@18988L1227,425@18704L1913:SteamGameAchievementPage.kt#xy3gb6");
                        final String achievementKey = "steam_achievement_" + $appId + "_" + achievement.getAchievementName() + "_" + it;
                        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ExposureConfig exposureConfig = new ExposureConfig(true, 0.0f, 0, 0L, 14, null);
                        ComposerKt.sourceInformationMarkerStart($composer, -136939094, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance($exposedList) | $composer.changed(achievementKey) | $composer.changed($appId) | $composer.changed($sourceFrom);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            final List list = $exposedList;
                            final String str = $appId;
                            final String str2 = $sourceFrom;
                            Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$SteamGameAchievementPageContent$5$1$2$3$2$1$3$1$1
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1294invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: collision with other method in class */
                                public final void m1294invoke() {
                                    if (!list.contains(achievementKey)) {
                                        ReportKt.reportExposure("game-ball.steam-game-achievement.steam-game-achievement.list.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", str), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", str2), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom())}));
                                        list.add(achievementKey);
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier$iv = ExposerKt.reportOnExposure(modifier, achievementKey, null, null, exposureConfig, (Function0) it$iv, $composer, ExposureConfig.$stable << 12, 6);
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
                        ComposerKt.sourceInformationMarkerStart($composer, 1317785218, "C448@20289L294:SteamGameAchievementPage.kt#xy3gb6");
                        Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        SteamGameAchievementPageKt.AchievementListItem(achievement, modifier$iv$iv, it == $filteredAchievements.size() - 1, $composer, (($changed2 >> 6) & 14) | 48, 0);
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
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGameAchievementPageKt.INSTANCE.m1257getLambda$847983071$gamebiz_debug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$0(int $achievedCount, int $totalCount, float $achieveRate, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C360@15060L570:SteamGameAchievementPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(653910761, $changed, -1, "kntr.app.game.steam.SteamGameAchievementPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGameAchievementPage.kt:360)");
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
            ComposerKt.sourceInformationMarkerStart($composer, -1315306859, "C361@15137L390,367@15560L40:SteamGameAchievementPage.kt#xy3gb6");
            AchievementStatisticsSection($achievedCount, $totalCount, $achieveRate, PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(2), Dp.constructor-impl(16), Dp.constructor-impl(12)), $composer, 3072, 0);
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
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1(int $totalCount, boolean $hasRareAchievements, final MutableIntState $unlockFilter$delegate, final MutableState $showRareOnly$delegate, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C373@15751L833:SteamGameAchievementPage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(551462944, $changed, -1, "kntr.app.game.steam.SteamGameAchievementPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGameAchievementPage.kt:373)");
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
            ComposerKt.sourceInformationMarkerStart($composer, 1169544023, "C377@16025L111,382@16332L108,374@15828L726:SteamGameAchievementPage.kt#xy3gb6");
            int SteamGameAchievementPageContent$lambda$10 = SteamGameAchievementPageContent$lambda$10($unlockFilter$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1700300901, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object value$iv = $composer.rememberedValue();
            if (value$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$0$0;
                        SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$0$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$0$0($unlockFilter$delegate, ((Integer) obj).intValue());
                        return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
            }
            Function1 function1 = (Function1) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            boolean SteamGameAchievementPageContent$lambda$13 = SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, 1700310722, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$1$0;
                        SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$1$0 = SteamGameAchievementPageKt.SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$1$0($showRareOnly$delegate);
                        return SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            AchievementListTitle($totalCount, SteamGameAchievementPageContent$lambda$10, function1, fillMaxWidth$default, SteamGameAchievementPageContent$lambda$13, (Function0) it$iv, $hasRareAchievements, $composer, 200064, 0);
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
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$0$0(MutableIntState $unlockFilter$delegate, int filter) {
        $unlockFilter$delegate.setIntValue(filter);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementPageContent$lambda$16$0$1$12$1$0$1$0$1$0(MutableState $showRareOnly$delegate) {
        SteamGameAchievementPageContent$lambda$14($showRareOnly$delegate, !SteamGameAchievementPageContent$lambda$13($showRareOnly$delegate));
        return Unit.INSTANCE;
    }

    public static final void AchievementTopAppBar(final String title, final Function0<Unit> function0, Modifier modifier, boolean immersive, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean immersive2;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(function0, "onBackPress");
        Composer $composer3 = $composer.startRestartGroup(-947685042);
        ComposerKt.sourceInformation($composer3, "C(AchievementTopAppBar)N(title,onBackPress,modifier,immersive)477@21213L1053:SteamGameAchievementPage.kt#xy3gb6");
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
                ComposerKt.traceEventStart(-947685042, $dirty2, -1, "kntr.app.game.steam.AchievementTopAppBar (SteamGameAchievementPage.kt:476)");
            }
            $composer3.startReplaceGroup(-192251671);
            ComposerKt.sourceInformation($composer3, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier mod = modifier3;
            if (immersive2) {
                $composer3.startReplaceGroup(-1523824402);
                ComposerKt.sourceInformation($composer3, "482@21386L10");
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(mod, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6));
                $composer3.endReplaceGroup();
                modifier4 = windowInsetsPadding;
            } else {
                $composer3.startReplaceGroup(-1523724613);
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
            BoxScope $this$AchievementTopAppBar_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1772777418, "C489@21583L214,496@21806L454:SteamGameAchievementPage.kt#xy3gb6");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$SteamGameAchievementPageKt.INSTANCE.getLambda$599505962$gamebiz_debug(), $composer3, (($dirty2 >> 3) & 14) | 1572864, 62);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$AchievementTopAppBar_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.constructor-impl(48), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getLeft-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 1597824, 24960, 240552);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit AchievementTopAppBar$lambda$2;
                    AchievementTopAppBar$lambda$2 = SteamGameAchievementPageKt.AchievementTopAppBar$lambda$2(title, function0, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AchievementTopAppBar$lambda$2;
                }
            });
        }
    }

    public static final void AchievementStatisticsSection(final int achievedCount, final int totalCount, final float achieveRate, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Function0 factory$iv$iv$iv7;
        Composer $composer3 = $composer.startRestartGroup(1770339734);
        ComposerKt.sourceInformation($composer3, "C(AchievementStatisticsSection)N(achievedCount,totalCount,achieveRate,modifier)520@22428L3675:SteamGameAchievementPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(achievedCount) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(totalCount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(achieveRate) ? 256 : 128;
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
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1770339734, $dirty2, -1, "kntr.app.game.steam.AchievementStatisticsSection (SteamGameAchievementPage.kt:519)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv = (($dirty2 >> 9) & 14) | 384;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv8;
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
            RowScope $this$AchievementStatisticsSection_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1385814865, "C525@22553L1831,572@24409L197,581@24638L1459:SteamGameAchievementPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$AchievementStatisticsSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(60));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            $composer2 = $composer3;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
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
            ComposerKt.sourceInformationMarkerStart($composer3, -203602488, "C532@22747L1627:SteamGameAchievementPage.kt#xy3gb6");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv3 = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            int $changed$iv$iv$iv3 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $changed$iv$iv$iv3);
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -858092724, "C535@22855L1223,561@24095L40,562@24152L208:SteamGameAchievementPage.kt#xy3gb6");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1898503451, "C543@23192L68,538@22958L384,551@23605L68,546@23363L334,558@23968L68,553@23718L342:SteamGameAchievementPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(String.valueOf(achievedCount), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, FontWeight.Companion.getSemiBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597824, 48, 259882);
            TextKt.Text-Nvy7gAk(" / ", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24966, 48, 259946);
            TextKt.Text-Nvy7gAk(String.valueOf(totalCount), (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 48, 259946);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk("全部成就", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597830, 0, 262058);
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
            Modifier modifier$iv5 = SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$AchievementStatisticsSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(60));
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Box = $changed$iv$iv5 << 6;
            int $changed$iv$iv$iv6 = ($i$f$Box & 896) | 6;
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
            ComposerKt.sourceInformationMarkerStart($composer3, -1699439676, "C588@24832L1255:SteamGameAchievementPage.kt#xy3gb6");
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
            Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 695457480, "C591@24940L848,610@25805L40,611@25862L211:SteamGameAchievementPage.kt#xy3gb6");
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv$iv = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv7 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv7 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv7 = factory$iv$iv$iv14;
                $composer3.createNode(factory$iv$iv$iv7);
            } else {
                factory$iv$iv$iv7 = factory$iv$iv$iv14;
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
            ComposerKt.sourceInformationMarkerStart($composer3, -202256070, "C599@25285L68,594@25043L392,607@25678L68,602@25456L314:SteamGameAchievementPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(String.valueOf((int) achieveRate), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, FontWeight.Companion.getSemiBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(20), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597824, 48, 259882);
            TextKt.Text-Nvy7gAk(" %", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(16), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24966, 48, 259946);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            TextKt.Text-Nvy7gAk("全部成就达成率", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597830, 0, 262058);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit AchievementStatisticsSection$lambda$1;
                    AchievementStatisticsSection$lambda$1 = SteamGameAchievementPageKt.AchievementStatisticsSection$lambda$1(achievedCount, totalCount, achieveRate, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AchievementStatisticsSection$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0405, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x047b, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x04eb, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L97;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AchievementListTitle(final int totalCount, final int selectedTab, final Function1<? super Integer, Unit> function1, Modifier modifier, boolean showRareOnly, Function0<Unit> function0, boolean hasRareAchievements, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean showRareOnly2;
        Function0 onRareFilterToggle;
        int $dirty;
        Composer $composer2;
        boolean hasRareAchievements2;
        Modifier modifier3;
        boolean showRareOnly3;
        Function0 onRareFilterToggle2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Painter painter;
        long j2;
        Intrinsics.checkNotNullParameter(function1, "onTabSelect");
        Composer $composer3 = $composer.startRestartGroup(1810664165);
        ComposerKt.sourceInformation($composer3, "C(AchievementListTitle)N(totalCount,selectedTab,onTabSelect,modifier,showRareOnly,onRareFilterToggle,hasRareAchievements)629@26327L2,637@26526L6,632@26380L2723:SteamGameAchievementPage.kt#xy3gb6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(totalCount) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(selectedTab) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            showRareOnly2 = showRareOnly;
        } else if (($changed & 24576) == 0) {
            showRareOnly2 = showRareOnly;
            $dirty2 |= $composer3.changed(showRareOnly2) ? 16384 : 8192;
        } else {
            showRareOnly2 = showRareOnly;
        }
        int i4 = i & 32;
        if (i4 != 0) {
            $dirty2 |= 196608;
            onRareFilterToggle = function0;
        } else if ((196608 & $changed) == 0) {
            onRareFilterToggle = function0;
            $dirty2 |= $composer3.changedInstance(onRareFilterToggle) ? 131072 : 65536;
        } else {
            onRareFilterToggle = function0;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(hasRareAchievements) ? 1048576 : 524288;
        }
        if ($composer3.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                showRareOnly2 = false;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 586514343, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda22
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onRareFilterToggle3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onRareFilterToggle = onRareFilterToggle3;
            }
            boolean hasRareAchievements3 = i5 != 0 ? true : hasRareAchievements;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1810664165, $dirty2, -1, "kntr.app.game.steam.AchievementListTitle (SteamGameAchievementPage.kt:631)");
            }
            modifier3 = modifier4;
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null)), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(0));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            $composer2 = $composer3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            showRareOnly3 = showRareOnly2;
            onRareFilterToggle2 = onRareFilterToggle;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1369750436, "C643@26781L2316:SteamGameAchievementPage.kt#xy3gb6");
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
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i9 = ((390 >> 6) & 112) | 6;
            RowScope $this$AchievementListTitle_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1331439975, "C651@27095L18,647@26932L233,654@27178L40,659@27389L18,655@27231L228,662@27472L40,667@27683L18,663@27525L228,671@27767L38:SteamGameAchievementPage.kt#xy3gb6");
            Integer valueOf = Integer.valueOf(totalCount);
            boolean z = selectedTab == 0;
            ComposerKt.sourceInformationMarkerStart($composer3, -1428419919, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda23
                public final Object invoke() {
                    Unit AchievementListTitle$lambda$1$0$0$0;
                    AchievementListTitle$lambda$1$0$0$0 = SteamGameAchievementPageKt.AchievementListTitle$lambda$1$0$0$0(function1);
                    return AchievementListTitle$lambda$1$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AchievementTabItemCompact("全部", valueOf, z, (Function0) it$iv2, Modifier.Companion, $composer3, (($dirty2 << 3) & 112) | 24582, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer3, 6);
            boolean z2 = selectedTab == 1;
            ComposerKt.sourceInformationMarkerStart($composer3, -1428410511, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 896) == 256;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda24
                public final Object invoke() {
                    Unit AchievementListTitle$lambda$1$0$1$0;
                    AchievementListTitle$lambda$1$0$1$0 = SteamGameAchievementPageKt.AchievementListTitle$lambda$1$0$1$0(function1);
                    return AchievementListTitle$lambda$1$0$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AchievementTabItemCompact("已解锁", null, z2, (Function0) it$iv3, Modifier.Companion, $composer3, 24630, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer3, 6);
            boolean z3 = selectedTab == 2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1428401103, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 896) == 256;
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv3) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv4 = new Function0() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda25
                public final Object invoke() {
                    Unit AchievementListTitle$lambda$1$0$2$0;
                    AchievementListTitle$lambda$1$0$2$0 = SteamGameAchievementPageKt.AchievementListTitle$lambda$1$0$2$0(function1);
                    return AchievementListTitle$lambda$1$0$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            AchievementTabItemCompact("未解锁", null, z3, (Function0) it$iv4, Modifier.Companion, $composer3, 24630, 0);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$AchievementListTitle_u24lambda_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            if (hasRareAchievements3) {
                $composer3.startReplaceGroup(-1330513045);
                ComposerKt.sourceInformation($composer3, "675@27897L1176");
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(Modifier.Companion, false, (String) null, (Role) null, (MutableInteractionSource) null, onRareFilterToggle2, 15, (Object) null);
                hasRareAchievements2 = hasRareAchievements3;
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv3 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i11 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1387637022, "C680@28120L548,690@28689L39,691@28749L306:SteamGameAchievementPage.kt#xy3gb6");
                if (showRareOnly3) {
                    $composer3.startReplaceGroup(1387699207);
                    ComposerKt.sourceInformation($composer3, "683@28241L93");
                    Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getSteam_select_radiobox(Res.drawable.INSTANCE), $composer3, 0);
                    $composer3.endReplaceGroup();
                    painter = painterResource;
                } else {
                    $composer3.startReplaceGroup(1387860686);
                    ComposerKt.sourceInformation($composer3, "685@28404L86");
                    Painter painterResource2 = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getSteam_radiobox(Res.drawable.INSTANCE), $composer3, 0);
                    $composer3.endReplaceGroup();
                    painter = painterResource2;
                }
                ImageKt.Image(painter, (String) null, OffsetKt.offset-VpY3zN4$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0.0f, Dp.constructor-impl(2), 1, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, 120);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
                if (showRareOnly3) {
                    $composer3.startReplaceGroup(598974594);
                    ComposerKt.sourceInformation($composer3, "693@28854L6");
                    j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU();
                } else {
                    $composer3.startReplaceGroup(598975457);
                    ComposerKt.sourceInformation($composer3, "693@28881L6");
                    j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU();
                }
                $composer3.endReplaceGroup();
                long j3 = j2;
                long sp = TextUnitKt.getSp(13);
                FontWeight.Companion companion = FontWeight.Companion;
                TextKt.Text-Nvy7gAk("只看稀有", (Modifier) null, j3, (TextAutoSize) null, sp, (FontStyle) null, showRareOnly3 ? companion.getSemiBold() : companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24582, 0, 262058);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                hasRareAchievements2 = hasRareAchievements3;
                $composer3.startReplaceGroup(-1358224317);
            }
            $composer3.endReplaceGroup();
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
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            hasRareAchievements2 = hasRareAchievements;
            modifier3 = modifier2;
            showRareOnly3 = showRareOnly2;
            onRareFilterToggle2 = onRareFilterToggle;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z4 = showRareOnly3;
            final Function0 function02 = onRareFilterToggle2;
            final boolean z5 = hasRareAchievements2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda26
                public final Object invoke(Object obj, Object obj2) {
                    Unit AchievementListTitle$lambda$2;
                    AchievementListTitle$lambda$2 = SteamGameAchievementPageKt.AchievementListTitle$lambda$2(totalCount, selectedTab, function1, modifier5, z4, function02, z5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AchievementListTitle$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListTitle$lambda$1$0$0$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListTitle$lambda$1$0$1$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListTitle$lambda$1$0$2$0(Function1 $onTabSelect) {
        $onTabSelect.invoke(2);
        return Unit.INSTANCE;
    }

    public static final void AchievementTabItemCompact(final String text, final Integer count, final boolean selected, final Function0<Unit> function0, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        long j2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-11134327);
        ComposerKt.sourceInformation($composer3, "C(AchievementTabItemCompact)N(text,count,selected,onClick,modifier)711@29276L541:SteamGameAchievementPage.kt#xy3gb6");
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
                ComposerKt.traceEventStart(-11134327, $dirty, -1, "kntr.app.game.steam.AchievementTabItemCompact (SteamGameAchievementPage.kt:710)");
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2030329066, "C718@29479L332:SteamGameAchievementPage.kt#xy3gb6");
            if (selected) {
                $composer3.startReplaceGroup(2030401016);
                ComposerKt.sourceInformation($composer3, "722@29592L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU();
                $composer3.endReplaceGroup();
                j2 = j3;
            } else {
                $composer3.startReplaceGroup(2030467449);
                ComposerKt.sourceInformation($composer3, "724@29659L6");
                long j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU();
                $composer3.endReplaceGroup();
                j2 = j4;
            }
            long sp = TextUnitKt.getSp(13);
            FontWeight.Companion companion = FontWeight.Companion;
            Modifier modifier4 = modifier3;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j2, (TextAutoSize) null, sp, (FontStyle) null, selected ? companion.getSemiBold() : companion.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, ($dirty & 14) | 24576, 0, 262058);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit AchievementTabItemCompact$lambda$1;
                    AchievementTabItemCompact$lambda$1 = SteamGameAchievementPageKt.AchievementTabItemCompact$lambda$1(text, count, selected, function0, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AchievementTabItemCompact$lambda$1;
                }
            });
        }
    }

    public static final void AchievementListItem(final AchievementDetail achievement, Modifier modifier, boolean isLastItem, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isLastItem2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ColorFilter colorFilter;
        Modifier modifier4;
        Function0 factory$iv$iv$iv3;
        long j2;
        Composer $composer$iv$iv$iv;
        final MutableIntState titleLineCount$delegate;
        MutableIntState titleLineCount$delegate2;
        final MutableIntState titleLineCount$delegate3;
        Alignment contentAlignment$iv;
        Composer $composer3;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv;
        Composer $composer4;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Object it$iv;
        Intrinsics.checkNotNullParameter(achievement, "achievement");
        Composer $composer5 = $composer.startRestartGroup(1470878947);
        ComposerKt.sourceInformation($composer5, "C(AchievementListItem)N(achievement,modifier,isLastItem)742@30159L33,743@30218L33,751@30506L6110:SteamGameAchievementPage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(achievement) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer5.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = isLastItem;
        } else if (($changed & 384) == 0) {
            z = isLastItem;
            $dirty |= $composer5.changed(z) ? 256 : 128;
        } else {
            z = isLastItem;
        }
        int $dirty2 = $dirty;
        if ($composer5.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier5 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            boolean isLastItem3 = i3 != 0 ? false : z;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1470878947, $dirty2, -1, "kntr.app.game.steam.AchievementListItem (SteamGameAchievementPage.kt:737)");
            }
            String unlockTimeFormatted = achievement.getUnlockTimeFormatted();
            boolean hasUnlockTime = unlockTimeFormatted.length() > 0;
            boolean isAchieved = achievement.getAchieved();
            ComposerKt.sourceInformationMarkerStart($composer5, 470438148, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(1);
                $composer5.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MutableIntState titleLineCount$delegate4 = (MutableIntState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 470440036, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object it$iv3 = $composer5.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(1);
                $composer5.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            MutableIntState descLineCount$delegate = (MutableIntState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            int itemHeight = ((((AchievementListItem$lambda$1(titleLineCount$delegate4) - 1) * 18) + 71) + ((AchievementListItem$lambda$4(descLineCount$delegate) - 1) * 14)) - ((hasUnlockTime || (AchievementListItem$lambda$1(titleLineCount$delegate4) <= 1 && AchievementListItem$lambda$4(descLineCount$delegate) <= 1)) ? 0 : 14);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier5, 0.0f, 1, (Object) null), Dp.constructor-impl(itemHeight));
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            modifier3 = modifier5;
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            $composer2 = $composer5;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            isLastItem2 = isLastItem3;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$AchievementListItem_u24lambda_u246 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 1590835344, "C755@30636L2113,810@32821L1674,855@34560L1640:SteamGameAchievementPage.kt#xy3gb6");
            Modifier modifier$iv2 = SizeKt.size-3ABfNKs(OffsetKt.offset-VpY3zN4($this$AchievementListItem_u24lambda_u246.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.constructor-impl(12), Dp.constructor-impl(7)), Dp.constructor-impl(52));
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer5.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 1191457956, "C790@31978L355,798@32369L355,768@31069L1670:SteamGameAchievementPage.kt#xy3gb6");
            if (isAchieved) {
                colorFilter = null;
            } else {
                ColorFilter.Companion companion = ColorFilter.Companion;
                float[] $this$AchievementListItem_u24lambda_u246_u240_u240 = ColorMatrix.constructor-impl$default((float[]) null, 1, (DefaultConstructorMarker) null);
                ColorMatrix.setToSaturation-impl($this$AchievementListItem_u24lambda_u246_u240_u240, 0.0f);
                colorFilter = companion.colorMatrix-jHG-Opc($this$AchievementListItem_u24lambda_u246_u240_u240);
            }
            final ColorFilter grayscaleFilter = colorFilter;
            String iconUrl = achievement.getIconUrl();
            if (iconUrl.length() == 0) {
                iconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            String $this$asRequest_u24default$iv = iconUrl;
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest.build();
            $composer5.startReplaceGroup(-515739540);
            ComposerKt.sourceInformation($composer5, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier it = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            if (isAchieved) {
                $composer5.startReplaceGroup(-559121309);
                $composer5.endReplaceGroup();
                modifier4 = it;
            } else {
                $composer5.startReplaceGroup(-559529083);
                ComposerKt.sourceInformation($composer5, "779@31478L333");
                ComposerKt.sourceInformationMarkerStart($composer5, -1819163030, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object it$iv4 = $composer5.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object obj = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj2) {
                            Unit AchievementListItem$lambda$6$0$2$0$0;
                            AchievementListItem$lambda$6$0$2$0$0 = SteamGameAchievementPageKt.AchievementListItem$lambda$6$0$2$0$0((ContentDrawScope) obj2);
                            return AchievementListItem$lambda$6$0$2$0$0;
                        }
                    };
                    $composer5.updateRememberedValue(obj);
                    it$iv = obj;
                } else {
                    it$iv = it$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                Modifier drawWithContent = DrawModifierKt.drawWithContent(it, (Function1) it$iv);
                $composer5.endReplaceGroup();
                modifier4 = drawWithContent;
            }
            $composer5.endReplaceGroup();
            BiliImageKt.BiliImage(build, modifier4, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.rememberComposableLambda(-644298670, true, new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3) {
                    Unit AchievementListItem$lambda$6$0$3;
                    AchievementListItem$lambda$6$0$3 = SteamGameAchievementPageKt.AchievementListItem$lambda$6$0$3(grayscaleFilter, (Composer) obj2, ((Integer) obj3).intValue());
                    return AchievementListItem$lambda$6$0$3;
                }
            }, $composer5, 54), ComposableLambdaKt.rememberComposableLambda(1050310472, true, new Function4() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit AchievementListItem$lambda$6$0$4;
                    AchievementListItem$lambda$6$0$4 = SteamGameAchievementPageKt.AchievementListItem$lambda$6$0$4(grayscaleFilter, (ImageFailScope) obj2, (ImageException) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return AchievementListItem$lambda$6$0$4;
                }
            }, $composer5, 54), $composer5, 113246208, 124);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier modifier6 = Modifier.Companion;
            Alignment.Companion companion2 = Alignment.Companion;
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default($this$AchievementListItem_u24lambda_u246.align(modifier6, hasUnlockTime ? companion2.getTopStart() : companion2.getCenterStart()), Dp.constructor-impl(74), hasUnlockTime ? Dp.constructor-impl(7) : Dp.constructor-impl(0), Dp.constructor-impl(82), 0.0f, 8, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer5.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -1431216194, "C823@33441L103,817@33143L416:SteamGameAchievementPage.kt#xy3gb6");
            String achievementName = achievement.getAchievementName();
            if (isAchieved) {
                $composer5.startReplaceGroup(1477854731);
                ComposerKt.sourceInformation($composer5, "819@33251L6");
                j2 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getGa10-0d7_KjU();
            } else {
                $composer5.startReplaceGroup(1477855594);
                ComposerKt.sourceInformation($composer5, "819@33278L6");
                j2 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getGa5-0d7_KjU();
            }
            $composer5.endReplaceGroup();
            long j3 = j2;
            long sp = TextUnitKt.getSp(13);
            long sp2 = TextUnitKt.getSp(18);
            FontWeight semiBold = FontWeight.Companion.getSemiBold();
            ComposerKt.sourceInformationMarkerStart($composer5, 1477860686, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
            Object value$iv3 = $composer5.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                $composer$iv$iv$iv = $composer5;
                titleLineCount$delegate = titleLineCount$delegate4;
                value$iv3 = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj2) {
                        Unit AchievementListItem$lambda$6$1$0$0;
                        AchievementListItem$lambda$6$1$0$0 = SteamGameAchievementPageKt.AchievementListItem$lambda$6$1$0$0(titleLineCount$delegate, (TextLayoutResult) obj2);
                        return AchievementListItem$lambda$6$1$0$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv3);
            } else {
                $composer$iv$iv$iv = $composer5;
                titleLineCount$delegate = titleLineCount$delegate4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer5);
            TextKt.Text-Nvy7gAk(achievementName, (Modifier) null, j3, (TextAutoSize) null, sp, (FontStyle) null, semiBold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp2, 0, false, 0, 0, (Function1) value$iv3, (TextStyle) null, $composer5, 1597440, 1572912, 194474);
            if (achievement.getAchievementDesc().length() > 0) {
                $composer5.startReplaceGroup(-1430729216);
                ComposerKt.sourceInformation($composer5, "830@33680L40,833@33837L6,836@33962L110,831@33737L354");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer5, 6);
                String achievementDesc = achievement.getAchievementDesc();
                long j4 = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getGa5-0d7_KjU();
                long sp3 = TextUnitKt.getSp(11);
                long sp4 = TextUnitKt.getSp(15);
                ComposerKt.sourceInformationMarkerStart($composer5, 1477877365, "CC(remember):SteamGameAchievementPage.kt#9igjgp");
                Object it$iv5 = $composer5.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    titleLineCount$delegate2 = titleLineCount$delegate;
                    titleLineCount$delegate3 = descLineCount$delegate;
                    Object value$iv4 = new Function1() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj2) {
                            Unit AchievementListItem$lambda$6$1$1$0;
                            AchievementListItem$lambda$6$1$1$0 = SteamGameAchievementPageKt.AchievementListItem$lambda$6$1$1$0(titleLineCount$delegate3, (TextLayoutResult) obj2);
                            return AchievementListItem$lambda$6$1$1$0;
                        }
                    };
                    $composer5.updateRememberedValue(value$iv4);
                    it$iv5 = value$iv4;
                } else {
                    titleLineCount$delegate2 = titleLineCount$delegate;
                    titleLineCount$delegate3 = descLineCount$delegate;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                TextKt.Text-Nvy7gAk(achievementDesc, (Modifier) null, j4, (TextAutoSize) null, sp3, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, sp4, 0, false, 0, 0, (Function1) it$iv5, (TextStyle) null, $composer5, 24576, 1572912, 194538);
            } else {
                titleLineCount$delegate2 = titleLineCount$delegate;
                titleLineCount$delegate3 = descLineCount$delegate;
                $composer5.startReplaceGroup(-1464136645);
            }
            $composer5.endReplaceGroup();
            if (unlockTimeFormatted.length() > 0) {
                $composer5.startReplaceGroup(-1430203301);
                ComposerKt.sourceInformation($composer5, "844@34215L40,847@34364L6,845@34272L199");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer5, 6);
                contentAlignment$iv = contentAlignment$iv2;
                $composer3 = $composer5;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                $composer$iv = $composer5;
                TextKt.Text-Nvy7gAk(unlockTimeFormatted, (Modifier) null, BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(15), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer5, 24576, 48, 260074);
                $composer5.endReplaceGroup();
                $composer4 = $composer5;
            } else {
                contentAlignment$iv = contentAlignment$iv2;
                $composer3 = $composer5;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                $composer$iv = $composer5;
                $composer4 = $composer5;
                $composer4.startReplaceGroup(-1464136645);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default($this$AchievementListItem_u24lambda_u246.align(Modifier.Companion, Alignment.Companion.getTopEnd()), 0.0f, Dp.constructor-impl((float) 15.5d), Dp.constructor-impl(12), 0.0f, 9, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            Composer $composer$iv2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv4 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv2.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i11 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1883064075, "C863@34870L976,886@35919L40,889@36044L6,887@35972L218:SteamGameAchievementPage.kt#xy3gb6");
            Modifier modifier$iv5 = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv2, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv5 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            Composer $composer$iv3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer$iv2.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i13 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1230708509, "C869@35137L6,872@35272L68,867@35012L398,875@35427L39,878@35559L6,881@35694L68,876@35483L349:SteamGameAchievementPage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(StringsKt.replace$default(achievement.getAchievePercentFormatted(), "%", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(18), (FontStyle) null, FontWeight.Companion.getBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer$iv2, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer$iv2, 1597440, 48, 259882);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer$iv2, 6);
            TextKt.Text-Nvy7gAk("%", (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getBold(), FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer$iv2, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer$iv2, 1597446, 48, 259882);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer$iv2, 6);
            TextKt.Text-Nvy7gAk("全网达成率", SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(14), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer$iv2, 24630, 48, 260072);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (isLastItem2) {
                $composer3.startReplaceGroup(1560258245);
            } else {
                $composer3.startReplaceGroup(1596238085);
                ComposerKt.sourceInformation($composer3, "905@36574L6,898@36272L328");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$AchievementListItem_u24lambda_u246.align(Modifier.Companion, Alignment.Companion.getBottomStart()), Dp.constructor-impl(74), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isLastItem2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z2 = isLastItem2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGameAchievementPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj2, Object obj3) {
                    Unit AchievementListItem$lambda$7;
                    AchievementListItem$lambda$7 = SteamGameAchievementPageKt.AchievementListItem$lambda$7(AchievementDetail.this, modifier7, z2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return AchievementListItem$lambda$7;
                }
            });
        }
    }

    private static final int AchievementListItem$lambda$1(MutableIntState $titleLineCount$delegate) {
        IntState $this$getValue$iv = (IntState) $titleLineCount$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final int AchievementListItem$lambda$4(MutableIntState $descLineCount$delegate) {
        IntState $this$getValue$iv = (IntState) $descLineCount$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$6$0$2$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, Color.Companion.getBlack-0d7_KjU(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getSaturation-0nO6VwU(), 62, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$6$0$3(ColorFilter $grayscaleFilter, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C792@32041L88,791@32000L315:SteamGameAchievementPage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-644298670, $changed, -1, "kntr.app.game.steam.AchievementListItem.<anonymous>.<anonymous>.<anonymous> (SteamGameAchievementPage.kt:791)");
            }
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$6$0$4(ColorFilter $grayscaleFilter, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)800@32432L88,799@32391L315:SteamGameAchievementPage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1050310472, $changed, -1, "kntr.app.game.steam.AchievementListItem.<anonymous>.<anonymous>.<anonymous> (SteamGameAchievementPage.kt:799)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$6$1$0$0(MutableIntState $titleLineCount$delegate, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        $titleLineCount$delegate.setIntValue(textLayoutResult.getLineCount());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementListItem$lambda$6$1$1$0(MutableIntState $descLineCount$delegate, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        $descLineCount$delegate.setIntValue(textLayoutResult.getLineCount());
        return Unit.INSTANCE;
    }
}