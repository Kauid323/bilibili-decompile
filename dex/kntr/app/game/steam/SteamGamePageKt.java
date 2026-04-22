package kntr.app.game.steam;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.animation.core.Animatable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kntr.app.ad.ad.biz.search.AdSearchSubCardType;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.ui.util.MultiTouchFilterKt;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.bean.AchievementItem;
import kntr.app.game.bean.AchievementProgress;
import kntr.app.game.bean.DLCDetail;
import kntr.app.game.bean.DLCHeader;
import kntr.app.game.bean.DLCStats;
import kntr.app.game.bean.DlcItem;
import kntr.app.game.bean.DlcModule;
import kntr.app.game.bean.DlcOwnership;
import kntr.app.game.bean.GameDLCsData;
import kntr.app.game.bean.GameInfo;
import kntr.app.game.bean.PlayData;
import kntr.app.game.bean.RecentAchievementItem;
import kntr.app.game.bean.RecentAchievements;
import kntr.app.game.bean.SteamGameDetailData;
import kntr.app.game.bean.SteamPlayerInfo;
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
import kntr.common.router.GlobalRouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.base.ui.generated.resources.Font0_commonMainKt;
import srcs.app.game.base.ui.generated.resources.Res;
import srcs.app.game.gamebiz.generated.resources.Drawable0_commonMainKt;
import srcs.app.game.gamebiz.generated.resources.Res;

/* compiled from: SteamGamePage.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a=\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\f\u001aM\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a9\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001b\u001a+\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u001f\u001aQ\u0010 \u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010#\u001a\u001f\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010'\u001aW\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010.\u001a/\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u0002012\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0007¢\u0006\u0002\u00103¨\u00064²\u0006\n\u00105\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"toDlcModule", "Lkntr/app/game/bean/DlcModule;", "Lkntr/app/game/bean/GameDLCsData;", "SteamGamePage", RoomRecommendViewModel.EMPTY_CURSOR, "steamId", RoomRecommendViewModel.EMPTY_CURSOR, "appId", "modifier", "Landroidx/compose/ui/Modifier;", RouterHelperKt.PARAM_SOURCE_FROM, "steamGameName", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SteamGamePageContent", "onBackPress", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "SteamGameTopAppBar", "title", "immersive", RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "PersonalInfoSection", "playerInfo", "Lkntr/app/game/bean/SteamPlayerInfo;", "playData", "Lkntr/app/game/bean/PlayData;", "(Lkntr/app/game/bean/SteamPlayerInfo;Lkntr/app/game/bean/PlayData;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "GameStatsSection", "achievementProgress", "Lkntr/app/game/bean/AchievementProgress;", "(Lkntr/app/game/bean/PlayData;Lkntr/app/game/bean/AchievementProgress;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SteamAchievementsSection", "recentAchievements", "Lkntr/app/game/bean/RecentAchievements;", "(Lkntr/app/game/bean/AchievementProgress;Lkntr/app/game/bean/RecentAchievements;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "RecentUnlockItem", "achievement", "Lkntr/app/game/bean/RecentAchievementItem;", "(Lkntr/app/game/bean/RecentAchievementItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DLCSection", "dlcModule", "viewModel", "Lkntr/app/game/steam/SteamGameVM;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkntr/app/game/bean/DlcModule;Lkntr/app/game/steam/SteamGameVM;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "DLCItem", "dlc", "Lkntr/app/game/bean/DlcItem;", "onClick", "(Lkntr/app/game/bean/DlcItem;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "gamebiz_debug", "isRefreshing"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamGamePageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCItem$lambda$2(DlcItem dlcItem, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        DLCItem(dlcItem, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$6(DlcModule dlcModule, SteamGameVM steamGameVM, CoroutineScope coroutineScope, String str, String str2, Modifier modifier, String str3, String str4, int i, int i2, Composer composer, int i3) {
        DLCSection(dlcModule, steamGameVM, coroutineScope, str, str2, modifier, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameStatsSection$lambda$1(PlayData playData, AchievementProgress achievementProgress, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GameStatsSection(playData, achievementProgress, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PersonalInfoSection$lambda$1(SteamPlayerInfo steamPlayerInfo, PlayData playData, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PersonalInfoSection(steamPlayerInfo, playData, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentUnlockItem$lambda$1(RecentAchievementItem recentAchievementItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        RecentUnlockItem(recentAchievementItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$5(AchievementProgress achievementProgress, RecentAchievements recentAchievements, String str, String str2, Modifier modifier, String str3, String str4, int i, int i2, Composer composer, int i3) {
        SteamAchievementsSection(achievementProgress, recentAchievements, str, str2, modifier, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePage$lambda$1(String str, String str2, Modifier modifier, String str3, String str4, int i, int i2, Composer composer, int i3) {
        SteamGamePage(str, str2, modifier, str3, str4, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$8(String str, String str2, Modifier modifier, String str3, String str4, Function0 function0, int i, int i2, Composer composer, int i3) {
        SteamGamePageContent(str, str2, modifier, str3, str4, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameTopAppBar$lambda$2(String str, Function0 function0, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        SteamGameTopAppBar(str, function0, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final DlcModule toDlcModule(GameDLCsData $this$toDlcModule) {
        DLCStats it;
        DLCHeader header = $this$toDlcModule.getHeader();
        DlcOwnership ownership = (header == null || (it = header.getDlcStats()) == null) ? null : new DlcOwnership(it.getOwnedCount(), it.getTotalCount(), it.getTotalValueYuan());
        Iterable $this$map$iv = $this$toDlcModule.getDlcs();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DLCDetail dlcDetail = (DLCDetail) item$iv$iv;
            destination$iv$iv.add(new DlcItem(dlcDetail.getDlcAppId(), dlcDetail.getDlcName(), dlcDetail.getDlcIconUrl(), dlcDetail.getReleaseDate(), dlcDetail.getPriceYuan(), dlcDetail.isFreeInt(), dlcDetail.getOwned()));
            $this$map$iv = $this$map$iv;
        }
        List dlcItems = (List) destination$iv$iv;
        return new DlcModule(ownership, dlcItems, $this$toDlcModule.getDlcUpdateTime());
    }

    public static final void SteamGamePage(final String steamId, final String appId, Modifier modifier, String sourceFrom, String steamGameName, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String str2;
        Modifier modifier3;
        String sourceFrom2;
        String steamGameName2;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Composer $composer2 = $composer.startRestartGroup(-1782144265);
        ComposerKt.sourceInformation($composer2, "C(SteamGamePage)N(steamId,appId,modifier,sourceFrom,steamGameName)144@6178L7,151@6385L51,145@6190L253:SteamGamePage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(steamId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(appId) ? 32 : 16;
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
            str = sourceFrom;
        } else if (($changed & 3072) == 0) {
            str = sourceFrom;
            $dirty |= $composer2.changed(str) ? 2048 : 1024;
        } else {
            str = sourceFrom;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            str2 = steamGameName;
        } else if (($changed & 24576) == 0) {
            str2 = steamGameName;
            $dirty |= $composer2.changed(str2) ? 16384 : 8192;
        } else {
            str2 = steamGameName;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            sourceFrom2 = str;
            steamGameName2 = str2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                sourceFrom2 = str;
            } else {
                sourceFrom2 = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            if (i4 == 0) {
                steamGameName2 = str2;
            } else {
                steamGameName2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1782144265, $dirty2, -1, "kntr.app.game.steam.SteamGamePage (SteamGamePage.kt:143)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 1051325930, "CC(remember):SteamGamePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(backHandler);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit SteamGamePage$lambda$0$0;
                        SteamGamePage$lambda$0$0 = SteamGamePageKt.SteamGamePage$lambda$0$0(backHandler);
                        return SteamGamePage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SteamGamePageContent(steamId, appId, modifier3, sourceFrom2, steamGameName2, (Function0) it$iv, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final String str3 = sourceFrom2;
            final String str4 = steamGameName2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGamePage$lambda$1;
                    SteamGamePage$lambda$1 = SteamGamePageKt.SteamGamePage$lambda$1(steamId, appId, modifier4, str3, str4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGamePage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePage$lambda$0$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v27 */
    public static final void SteamGamePageContent(final String steamId, final String appId, Modifier modifier, String sourceFrom, String steamGameName, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String steamGameName2;
        String sourceFrom2;
        Function0 onBackPress;
        Modifier modifier3;
        boolean z;
        int $dirty;
        String spmid;
        Toaster toaster;
        CoroutineScope scope;
        String str;
        int i2;
        final String spmid2;
        Unit unit;
        String spmid3;
        int i3;
        SteamGameVM viewModel;
        Intrinsics.checkNotNullParameter(steamId, "steamId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Composer $composer2 = $composer.startRestartGroup(-1973047842);
        ComposerKt.sourceInformation($composer2, "C(SteamGamePageContent)N(steamId,appId,modifier,sourceFrom,steamGameName,onBackPress)164@6654L2,170@6765L149,176@6959L17,176@6949L27,177@6993L24,178@7049L7,183@7191L72,184@7295L256,184@7268L283,193@7598L137,193@7575L160,201@7809L7,202@7847L128,202@7821L154,208@8002L893,208@7981L914,235@8930L7368:SteamGamePage.kt#xy3gb6");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(steamId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(appId) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changed(sourceFrom) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            steamGameName2 = steamGameName;
        } else if (($changed & 24576) == 0) {
            steamGameName2 = steamGameName;
            $dirty2 |= $composer2.changed(steamGameName2) ? 16384 : 8192;
        } else {
            steamGameName2 = steamGameName;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ($composer2.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            sourceFrom2 = i5 != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : sourceFrom;
            if (i6 != 0) {
                steamGameName2 = null;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -2018392384, "CC(remember):SteamGamePage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda10
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
                onBackPress = function0;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1973047842, $dirty2, -1, "kntr.app.game.steam.SteamGamePageContent (SteamGamePage.kt:165)");
            }
            long defaultBackgroundColor = ColorKt.Color(4279969848L);
            ComposerKt.sourceInformationMarkerStart($composer2, -2018388685, "CC(remember):SteamGamePage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                z = true;
                Object value$iv2 = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4279464097L)), Color.box-impl(ColorKt.Color(4279049279L))}), 0.0f, 0.0f, 0, 14, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                z = true;
            }
            Brush brush = (Brush) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2018382609, "CC(remember):SteamGamePage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda21
                    public final Object invoke(Object obj) {
                        SteamGameVM SteamGamePageContent$lambda$2$0;
                        SteamGamePageContent$lambda$2$0 = SteamGamePageKt.SteamGamePageContent$lambda$2$0((CreationExtras) obj);
                        return SteamGamePageContent$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function1 initializer$iv = (Function1) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer2, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SteamGameVM.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(SteamGameVM.class), initializer$iv);
            ViewModel viewModel2 = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            SteamGameVM viewModel3 = (SteamGameVM) viewModel2;
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
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("game-ball.steam-game-data.steam-game-data.0.pv", $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -2018371618, "CC(remember):SteamGamePage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 7168) == 2048 ? z : false) | $composer2.changedInstance(pvTrigger) | $composer2.changed(spmidFrom) | (($dirty2 & 112) == 32 ? z : false);
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv || value$iv4 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-data";
                String spmid4 = sourceFrom2;
                toaster = toaster2;
                scope = scope2;
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                i2 = 6;
                value$iv4 = new SteamGamePageKt$SteamGamePageContent$2$1(pvTrigger, "game-ball.steam-game-data", spmid4, spmidFrom, appId, null);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                scope = scope2;
                str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                $dirty = $dirty2;
                spmid = "game-ball.steam-game-data";
                toaster = toaster2;
                i2 = 6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $dirty3 = $dirty;
            EffectsKt.LaunchedEffect(sourceFrom2, (Function2) value$iv4, $composer2, ($dirty3 >> 9) & 14);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2018362041, "CC(remember):SteamGamePage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                spmid2 = spmid;
                Object value$iv5 = new Function1() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda32
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SteamGamePageContent$lambda$4$0;
                        SteamGamePageContent$lambda$4$0 = SteamGamePageKt.SteamGamePageContent$lambda$4$0(spmid2, (DisposableEffectScope) obj);
                        return SteamGamePageContent$lambda$4$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            } else {
                spmid2 = spmid;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv4, $composer2, 54);
            CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, str);
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, -2018354082, "CC(remember):SteamGamePage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(viewModel3);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function2) new SteamGamePageKt$SteamGamePageContent$4$1(lifecycle, viewModel3, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv5 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(lifecycle, (Function2) it$iv5, $composer2, 0);
            Unit unit3 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2018348357, "CC(remember):SteamGamePage.kt#9igjgp");
            final CoroutineScope scope3 = scope;
            Toaster toaster3 = toaster;
            boolean invalid$iv3 = $composer2.changedInstance(viewModel3) | (($dirty3 & 14) == 4) | (($dirty3 & 112) == 32) | $composer2.changedInstance(scope3) | $composer2.changedInstance(toaster3) | (($dirty3 & 7168) == 2048);
            Object value$iv7 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv7 == Composer.Companion.getEmpty()) {
                unit = unit3;
                spmid3 = spmid2;
                i3 = i2;
                viewModel = viewModel3;
                value$iv7 = new SteamGamePageKt$SteamGamePageContent$5$1(viewModel3, steamId, appId, scope3, toaster3, sourceFrom2, null);
                $composer2.updateRememberedValue(value$iv7);
            } else {
                unit = unit3;
                spmid3 = spmid2;
                i3 = i2;
                viewModel = viewModel3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv7, $composer2, i3);
            Modifier modifier$iv = MultiTouchFilterKt.singleTouchOnly$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), defaultBackgroundColor, (Shape) null, 2, (Object) null), 0L, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | i3;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
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
            int i9 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SteamGamePageContent_u24lambda_u247 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1377496226, "C237@9051L183,249@9463L6829,243@9244L7048:SteamGamePage.kt#xy3gb6");
            SteamGameTopAppBar(steamGameName2 == null ? RoomRecommendViewModel.EMPTY_CURSOR : steamGameName2, onBackPress, $this$SteamGamePageContent_u24lambda_u247.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getTopStart()), false, $composer2, ($dirty3 >> 12) & 112, 8);
            final String str2 = steamGameName2;
            final Function0 function02 = onBackPress;
            final String str3 = sourceFrom2;
            final SteamGameVM steamGameVM = viewModel;
            LoadComposableKt.LoadComposable(viewModel, "steam_game_" + appId, SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), false, false, ComposableLambdaKt.rememberComposableLambda(785599202, true, new Function5() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda35
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit SteamGamePageContent$lambda$7$0;
                    SteamGamePageContent$lambda$7$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0(str2, function02, steamId, appId, str3, steamGameVM, scope3, (SteamGameDetailData) obj, (SteamGameVM) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return SteamGamePageContent$lambda$7$0;
                }
            }, $composer2, 54), $composer2, 224640, 0);
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
            sourceFrom2 = sourceFrom;
            onBackPress = function0;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str4 = sourceFrom2;
            final String str5 = steamGameName2;
            final Function0 function03 = onBackPress;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGamePageContent$lambda$8;
                    SteamGamePageContent$lambda$8 = SteamGamePageKt.SteamGamePageContent$lambda$8(steamId, appId, modifier5, str4, str5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGamePageContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SteamGameVM SteamGamePageContent$lambda$2$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new SteamGameVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SteamGamePageContent$lambda$4$0(final String $spmid, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.game.steam.SteamGamePageKt$SteamGamePageContent$lambda$4$0$$inlined$onDispose$1
            public void dispose() {
                KntrGameReportService.INSTANCE.setSpmidFrom($spmid);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v61 */
    public static final Unit SteamGamePageContent$lambda$7$0(final String $steamGameName, Function0 $onBackPress, final String $steamId, final String $appId, final String $sourceFrom, final SteamGameVM $viewModel, final CoroutineScope $scope, final SteamGameDetailData gameData, SteamGameVM vm, PageLoadMoreState pageLoadMoreState, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        BoxScope $this$SteamGamePageContent_u24lambda_u247_u240_u240;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv3;
        Composer $composer$iv4;
        Intrinsics.checkNotNullParameter(gameData, "gameData");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(pageLoadMoreState, "$unused$var$");
        ComposerKt.sourceInformation($composer, "CN(gameData,vm)253@9609L54,255@9677L6605:SteamGamePage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(785599202, $changed, -1, "kntr.app.game.steam.SteamGamePageContent.<anonymous>.<anonymous> (SteamGamePage.kt:251)");
        }
        final DlcModule dlcModule = gameData.getDlcModule();
        GameInfo gameInfo = gameData.getGameInfo();
        Brush dynamicBrush = SteamGameBackgroundKt.createSteamGameGradient(gameInfo != null ? gameInfo.getAppIconRgb() : null, $composer, 0);
        Modifier modifier$iv = BackgroundKt.background$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), dynamicBrush, (Shape) null, 0.0f, 6, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        int i2 = ((0 >> 6) & 112) | 6;
        BoxScope $this$SteamGamePageContent_u24lambda_u247_u240_u2402 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1981546729, "C295@11926L4342:SteamGamePage.kt#xy3gb6");
        GameInfo gameInfo2 = gameData.getGameInfo();
        String iconUrl = gameInfo2 != null ? gameInfo2.getAppIconUrl() : null;
        if (iconUrl == null) {
            $composer.startReplaceGroup(-1981652069);
            $composer.endReplaceGroup();
            $this$SteamGamePageContent_u24lambda_u247_u240_u240 = $this$SteamGamePageContent_u24lambda_u247_u240_u2402;
            $composer$iv = $composer;
            $composer$iv2 = $composer;
        } else {
            $composer$iv = $composer;
            $composer.startReplaceGroup(-1981652068);
            ComposerKt.sourceInformation($composer, "*268@10442L1426,258@9900L1991");
            String $this$asRequest_u24default$iv = iconUrl;
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest.build();
            $composer$iv2 = $composer;
            Modifier modifier = GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default($this$SteamGamePageContent_u24lambda_u247_u240_u2402.align(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 2.1929824f, false, 2, (Object) null), Alignment.Companion.getTopCenter()), 0.0f, 0.0f, 0.54f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, CompositingStrategy.Companion.getOffscreen--NrFUSI(), 0, (ColorFilter) null, 458747, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 964288092, "CC(remember):SteamGamePage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            $this$SteamGamePageContent_u24lambda_u247_u240_u240 = $this$SteamGamePageContent_u24lambda_u247_u240_u2402;
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda29
                    public final Object invoke(Object obj) {
                        Unit SteamGamePageContent$lambda$7$0$0$0$0$0;
                        SteamGamePageContent$lambda$7$0$0$0$0$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$0$0$0((ContentDrawScope) obj);
                        return SteamGamePageContent$lambda$7$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliImageKt.BiliImage(build, DrawModifierKt.drawWithContent(modifier, (Function1) it$iv), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 0, 508);
            Unit unit2 = Unit.INSTANCE;
            $composer.endReplaceGroup();
            Unit unit3 = Unit.INSTANCE;
        }
        Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
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
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
        int i4 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -1182795391, "C296@11990L235,304@12340L3910,302@12247L4003:SteamGamePage.kt#xy3gb6");
        if ($steamGameName == null) {
            GameInfo gameInfo3 = gameData.getGameInfo();
            String appName = gameInfo3 != null ? gameInfo3.getAppName() : null;
            if (appName == null) {
                appName = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            str = appName;
        } else {
            str = $steamGameName;
        }
        SteamGameTopAppBar(str, $onBackPress, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), false, $composer, 384, 8);
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 100403492, "CC(remember):SteamGamePage.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(gameData) | $composer.changed($steamId) | $composer.changed($appId) | $composer.changed($sourceFrom) | $composer.changed($steamGameName) | $composer.changedInstance(dlcModule) | $composer.changedInstance($viewModel) | $composer.changedInstance($scope);
        Object value$iv2 = $composer.rememberedValue();
        if (invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
            $composer$iv$iv$iv = $composer;
            $composer$iv$iv = $composer;
            $composer2 = $composer;
            $composer$iv3 = $composer;
            $composer$iv4 = $composer;
            value$iv2 = new Function1() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj) {
                    Unit SteamGamePageContent$lambda$7$0$0$1$0$0;
                    SteamGamePageContent$lambda$7$0$0$1$0$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0(SteamGameDetailData.this, dlcModule, $steamId, $appId, $sourceFrom, $steamGameName, $viewModel, $scope, (LazyListScope) obj);
                    return SteamGamePageContent$lambda$7$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
        } else {
            $composer2 = $composer;
            $composer$iv4 = $composer;
            $composer$iv$iv$iv = $composer;
            $composer$iv3 = $composer;
            $composer$iv$iv = $composer;
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        LazyDslKt.LazyColumn(fillMaxSize$default, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv2, $composer2, 6, 510);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
        $composer$iv$iv$iv.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$7$0$0$0$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        DrawScope.-CC.drawRect-AsUm42w$default((DrawScope) $this$drawWithContent, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), 0.0f, 0.0f, 0, 14, (Object) null), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        Brush.Companion companion = Brush.Companion;
        Pair[] pairArr = {TuplesKt.to(Float.valueOf(0.01f), Color.box-impl(Color.Companion.getWhite-0d7_KjU())), TuplesKt.to(Float.valueOf(0.5726f), Color.box-impl(Color.Companion.getTransparent-0d7_KjU()))};
        int bits$iv$iv$iv = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
        float x$iv = Float.intBitsToFloat(bits$iv$iv$iv) * 0.5f;
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(0.0f);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv2 = (int) ($this$drawWithContent.getSize-NH-jbRc() >> 32);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv2) * 0.4f;
        int bits$iv$iv$iv3 = (int) ($this$drawWithContent.getSize-NH-jbRc() & 4294967295L);
        float y$iv = Float.intBitsToFloat(bits$iv$iv$iv3);
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y$iv);
        DrawScope.-CC.drawRect-AsUm42w$default((DrawScope) $this$drawWithContent, Brush.Companion.linearGradient-mHitzGk$default(companion, pairArr, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 0, 8, (Object) null), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getDstIn-0nO6VwU(), 62, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamGamePageContent$lambda$7$0$0$1$0$0(final SteamGameDetailData $gameData, final DlcModule $dlcModule, final String $steamId, final String $appId, final String $sourceFrom, final String $steamGameName, final SteamGameVM $viewModel, final CoroutineScope $scope, LazyListScope $this$LazyColumn) {
        boolean z;
        boolean hasAchievements;
        boolean hasDLCs;
        List<DlcItem> dlcs;
        List<RecentAchievementItem> achievements;
        List<AchievementItem> rareAchievements;
        List<AchievementItem> commonAchievements;
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1721266445, true, new Function3() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGamePageContent$lambda$7$0$0$1$0$0$0;
                SteamGamePageContent$lambda$7$0$0$1$0$0$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0$0(SteamGameDetailData.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGamePageContent$lambda$7$0$0$1$0$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-303187734, true, new Function3() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit SteamGamePageContent$lambda$7$0$0$1$0$0$1;
                SteamGamePageContent$lambda$7$0$0$1$0$0$1 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0$1(SteamGameDetailData.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return SteamGamePageContent$lambda$7$0$0$1$0$0$1;
            }
        }), 3, (Object) null);
        AchievementProgress achievementProgress = $gameData.getAchievementProgress();
        boolean z2 = false;
        if (!((achievementProgress == null || (commonAchievements = achievementProgress.getCommonAchievements()) == null || !(commonAchievements.isEmpty() ^ true)) ? false : true)) {
            AchievementProgress achievementProgress2 = $gameData.getAchievementProgress();
            if (!((achievementProgress2 == null || (rareAchievements = achievementProgress2.getRareAchievements()) == null || !(rareAchievements.isEmpty() ^ true)) ? false : true)) {
                RecentAchievements recentAchievements = $gameData.getRecentAchievements();
                if (!((recentAchievements == null || (achievements = recentAchievements.getAchievements()) == null || !(achievements.isEmpty() ^ true)) ? false : true)) {
                    z = false;
                    hasAchievements = z;
                    if (hasAchievements) {
                        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(634873870, true, new Function3() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda16
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit SteamGamePageContent$lambda$7$0$0$1$0$0$2;
                                SteamGamePageContent$lambda$7$0$0$1$0$0$2 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0$2(SteamGameDetailData.this, $steamId, $appId, $sourceFrom, $steamGameName, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return SteamGamePageContent$lambda$7$0$0$1$0$0$2;
                            }
                        }), 3, (Object) null);
                    }
                    if ($dlcModule != null && (dlcs = $dlcModule.getDlcs()) != null && (!dlcs.isEmpty())) {
                        z2 = true;
                    }
                    hasDLCs = z2;
                    if (hasDLCs && $dlcModule != null) {
                        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(545759623, true, new Function3() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda17
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit SteamGamePageContent$lambda$7$0$0$1$0$0$3$0;
                                SteamGamePageContent$lambda$7$0$0$1$0$0$3$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0$3$0(DlcModule.this, $viewModel, $scope, $steamId, $appId, $sourceFrom, $steamGameName, $gameData, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return SteamGamePageContent$lambda$7$0$0$1$0$0$3$0;
                            }
                        }), 3, (Object) null);
                    }
                    if (!hasAchievements && !hasDLCs) {
                        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGamePageKt.INSTANCE.getLambda$820870790$gamebiz_debug(), 3, (Object) null);
                    }
                    LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGamePageKt.INSTANCE.getLambda$17793067$gamebiz_debug(), 3, (Object) null);
                    return Unit.INSTANCE;
                }
            }
        }
        z = true;
        hasAchievements = z;
        if (hasAchievements) {
        }
        if ($dlcModule != null) {
            z2 = true;
        }
        hasDLCs = z2;
        if (hasDLCs) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(545759623, true, new Function3() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SteamGamePageContent$lambda$7$0$0$1$0$0$3$0;
                    SteamGamePageContent$lambda$7$0$0$1$0$0$3$0 = SteamGamePageKt.SteamGamePageContent$lambda$7$0$0$1$0$0$3$0(DlcModule.this, $viewModel, $scope, $steamId, $appId, $sourceFrom, $steamGameName, $gameData, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SteamGamePageContent$lambda$7$0$0$1$0$0$3$0;
                }
            }), 3, (Object) null);
        }
        if (!hasAchievements) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGamePageKt.INSTANCE.getLambda$820870790$gamebiz_debug(), 3, (Object) null);
        }
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$SteamGamePageKt.INSTANCE.getLambda$17793067$gamebiz_debug(), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$7$0$0$1$0$0$0(SteamGameDetailData $gameData, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C306@12401L178:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1721266445, $changed, -1, "kntr.app.game.steam.SteamGamePageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:306)");
            }
            PersonalInfoSection($gameData.getPlayerInfo(), $gameData.getPlayData(), null, $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$7$0$0$1$0$0$1(SteamGameDetailData $gameData, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C313@12666L266:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-303187734, $changed, -1, "kntr.app.game.steam.SteamGamePageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:313)");
            }
            GameStatsSection($gameData.getPlayData(), $gameData.getAchievementProgress(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(9), 0.0f, 0.0f, 13, (Object) null), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$7$0$0$1$0$0$2(SteamGameDetailData $gameData, String $steamId, String $appId, String $sourceFrom, String $steamGameName, LazyItemScope $this$item, Composer $composer, int $changed) {
        String str;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C327@13472L603:SteamGamePage.kt#xy3gb6");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(634873870, $changed, -1, "kntr.app.game.steam.SteamGamePageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:327)");
            }
            AchievementProgress achievementProgress = $gameData.getAchievementProgress();
            RecentAchievements recentAchievements = $gameData.getRecentAchievements();
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(16), Dp.constructor-impl(12), 0.0f, 8, (Object) null);
            if ($steamGameName == null) {
                GameInfo gameInfo = $gameData.getGameInfo();
                str = gameInfo != null ? gameInfo.getAppName() : null;
            } else {
                str = $steamGameName;
            }
            SteamAchievementsSection(achievementProgress, recentAchievements, $steamId, $appId, modifier, $sourceFrom, str, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGamePageContent$lambda$7$0$0$1$0$0$3$0(DlcModule $currentDlcModule, SteamGameVM $viewModel, CoroutineScope $scope, String $steamId, String $appId, String $sourceFrom, String $steamGameName, SteamGameDetailData $gameData, LazyItemScope $this$item, Composer $composer, int $changed) {
        String str;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C344@14438L41,345@14516L606:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(545759623, $changed, -1, "kntr.app.game.steam.SteamGamePageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:344)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            if ($steamGameName == null) {
                GameInfo gameInfo = $gameData.getGameInfo();
                str = gameInfo != null ? gameInfo.getAppName() : null;
            } else {
                str = $steamGameName;
            }
            DLCSection($currentDlcModule, $viewModel, $scope, $steamId, $appId, modifier, $sourceFrom, str, $composer, 196608, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void SteamGameTopAppBar(final String title, final Function0<Unit> function0, Modifier modifier, boolean immersive, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean immersive2;
        Modifier modifier3;
        Modifier modifier4;
        boolean immersive3;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onBackPress");
        Composer $composer2 = $composer.startRestartGroup(559187302);
        ComposerKt.sourceInformation($composer2, "C(SteamGameTopAppBar)N(title,onBackPress,modifier,immersive)395@16461L1078:SteamGamePage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
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
            immersive2 = immersive;
        } else if (($changed & 3072) == 0) {
            immersive2 = immersive;
            $dirty |= $composer2.changed(immersive2) ? 2048 : 1024;
        } else {
            immersive2 = immersive;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                immersive3 = immersive2;
            } else {
                immersive3 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(559187302, $dirty, -1, "kntr.app.game.steam.SteamGameTopAppBar (SteamGamePage.kt:394)");
            }
            $composer2.startReplaceGroup(508092129);
            ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
            Modifier mod = modifier4;
            if (immersive3) {
                $composer2.startReplaceGroup(-476832286);
                ComposerKt.sourceInformation($composer2, "400@16634L10");
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(mod, WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer2, 6));
                $composer2.endReplaceGroup();
                modifier5 = windowInsetsPadding;
            } else {
                $composer2.startReplaceGroup(-476732497);
                $composer2.endReplaceGroup();
                modifier5 = mod;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = SizeKt.defaultMinSize-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(modifier5, 0.0f, 0.0f, Dp.constructor-impl(0), 0.0f, 11, (Object) null), 0.0f, Dp.constructor-impl(40), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
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
            modifier3 = modifier4;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SteamGameTopAppBar_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            boolean immersive4 = immersive3;
            ComposerKt.sourceInformationMarkerStart($composer2, 309606233, "C407@16831L214,422@17358L9,414@17054L479:SteamGamePage.kt#xy3gb6");
            IconButtonKt.IconButton(function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$SteamGamePageKt.INSTANCE.m1262getLambda$1625502454$gamebiz_debug(), $composer2, (($dirty >> 3) & 14) | 1572864, 62);
            String str = title == null ? RoomRecommendViewModel.EMPTY_CURSOR : title;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default($this$SteamGameTopAppBar_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterStart()), Dp.constructor-impl(48), 0.0f, Dp.constructor-impl(12), 0.0f, 10, (Object) null), 0.0f, 1, (Object) null);
            int i6 = TextAlign.Companion.getLeft-e0LSkKk();
            TextKt.Text-Nvy7gAk(str, fillMaxWidth$default, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17(), $composer2, 1573248, 24960, 109496);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            immersive2 = immersive4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z = immersive2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameTopAppBar$lambda$2;
                    SteamGameTopAppBar$lambda$2 = SteamGamePageKt.SteamGameTopAppBar$lambda$2(title, function0, modifier6, z, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameTopAppBar$lambda$2;
                }
            });
        }
    }

    public static final void PersonalInfoSection(final SteamPlayerInfo playerInfo, final PlayData playData, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer3 = $composer.startRestartGroup(1374530938);
        ComposerKt.sourceInformation($composer3, "C(PersonalInfoSection)N(playerInfo,playData,modifier)441@17956L1548:SteamGamePage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(playerInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(playData) ? 32 : 16;
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
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
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
                ComposerKt.traceEventStart(1374530938, $dirty2, -1, "kntr.app.game.steam.PersonalInfoSection (SteamGamePage.kt:436)");
            }
            String avatarUrl = (playerInfo == null || (avatarUrl = playerInfo.getAvatar()) == null) ? "https://i0.hdslb.com/bfs/game/c3de2e5f23ed2f623a0c72de1c01731fce34b022.png" : "https://i0.hdslb.com/bfs/game/c3de2e5f23ed2f623a0c72de1c01731fce34b022.png";
            String lastPlayedTime = playData != null ? playData.getRtimeLastPlayedFormatted() : null;
            String str2 = lastPlayedTime;
            boolean hasLastPlayed = !(str2 == null || str2.length() == 0);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.heightIn-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(50), 0.0f, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(0));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$PersonalInfoSection_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1043115838, "C449@18207L235,458@18452L40,460@18502L996:SteamGamePage.kt#xy3gb6");
            String $this$asRequest_u24default$iv = avatarUrl;
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(50)), Dp.constructor-impl(50)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, 508);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$PersonalInfoSection_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(10), 0.0f, 11, (Object) null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = hasLastPlayed ? arrangement.getTop() : arrangement.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1012642910, "C467@18751L413:SteamGamePage.kt#xy3gb6");
            if (playerInfo == null || (str = playerInfo.getPersonName()) == null) {
                str = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            TextKt.Text-Nvy7gAk(str, hasLastPlayed ? OffsetKt.offset-VpY3zN4$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(21)), 0.0f, Dp.constructor-impl(-5), 1, (Object) null) : Modifier.Companion, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.Companion.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(21), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 1597824, 25008, 239528);
            if (hasLastPlayed) {
                $composer3.startReplaceGroup(-1012198402);
                ComposerKt.sourceInformation($composer3, "478@19214L260");
                TextKt.Text-Nvy7gAk("最后运行：" + lastPlayedTime, (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 24960, 241642);
            } else {
                $composer3.startReplaceGroup(-1031267742);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit PersonalInfoSection$lambda$1;
                    PersonalInfoSection$lambda$1 = SteamGamePageKt.PersonalInfoSection$lambda$1(SteamPlayerInfo.this, playData, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PersonalInfoSection$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:94:0x0842
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public static final void GameStatsSection(kntr.app.game.bean.PlayData r167, kntr.app.game.bean.AchievementProgress r168, androidx.compose.ui.Modifier r169, androidx.compose.runtime.Composer r170, int r171, int r172) {
        /*
            Method dump skipped, instructions count: 3236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.SteamGamePageKt.GameStatsSection(kntr.app.game.bean.PlayData, kntr.app.game.bean.AchievementProgress, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -56
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void SteamAchievementsSection(kntr.app.game.bean.AchievementProgress r200, kntr.app.game.bean.RecentAchievements r201, java.lang.String r202, java.lang.String r203, androidx.compose.ui.Modifier r204, java.lang.String r205, java.lang.String r206, androidx.compose.runtime.Composer r207, int r208, int r209) {
        /*
            Method dump skipped, instructions count: 10540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.SteamGamePageKt.SteamAchievementsSection(kntr.app.game.bean.AchievementProgress, kntr.app.game.bean.RecentAchievements, java.lang.String, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$1$0(Map $commonReportParams, String $steamId, String $appId, String $sourceFrom, String $steamGameName) {
        ReportKt.reportClick("game-ball.steam-game-data.steam-game-achievement.module.click", MapsKt.plus($commonReportParams, MapsKt.mapOf(TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()))));
        Builder $this$SteamAchievementsSection_u24lambda_u241_u240_u240 = Uri.Companion.parse("bilibili://game/compose/steam/game/achievement_page").buildUpon().appendQueryParameter("steamId", $steamId).appendQueryParameter("appId", $appId).appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom).appendQueryParameter("defaultShowRareOnly", AdSearchSubCardType.CARD_TYPE_NONE);
        if ($steamGameName != null) {
            $this$SteamAchievementsSection_u24lambda_u241_u240_u240.appendQueryParameter("steamGameName", $steamGameName);
        }
        Uri uri = $this$SteamAchievementsSection_u24lambda_u241_u240_u240.build();
        GlobalRouterKt.getGlobalRouter().launch(uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$2$0(Map $commonReportParams, String $steamId, String $appId, String $sourceFrom, String $steamGameName) {
        ReportKt.reportClick("game-ball.steam-game-data.steam-game-achievement.module.click", MapsKt.plus($commonReportParams, MapsKt.mapOf(TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()))));
        Builder $this$SteamAchievementsSection_u24lambda_u242_u240_u240 = Uri.Companion.parse("bilibili://game/compose/steam/game/achievement_page").buildUpon().appendQueryParameter("steamId", $steamId).appendQueryParameter("appId", $appId).appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom).appendQueryParameter("defaultShowRareOnly", "1");
        if ($steamGameName != null) {
            $this$SteamAchievementsSection_u24lambda_u242_u240_u240.appendQueryParameter("steamGameName", $steamGameName);
        }
        Uri uri = $this$SteamAchievementsSection_u24lambda_u242_u240_u240.build();
        GlobalRouterKt.getGlobalRouter().launch(uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$3$0(Map $commonReportParams, String $steamId, String $appId, String $sourceFrom, String $steamGameName) {
        ReportKt.reportClick("game-ball.steam-game-data.steam-game-achievement.recent_list.click", MapsKt.plus($commonReportParams, MapsKt.mapOf(TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()))));
        Builder $this$SteamAchievementsSection_u24lambda_u243_u240_u240 = Uri.Companion.parse("bilibili://game/compose/steam/game/achievement_page").buildUpon().appendQueryParameter("steamId", $steamId).appendQueryParameter("appId", $appId).appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom).appendQueryParameter("defaultShowRareOnly", AdSearchSubCardType.CARD_TYPE_NONE);
        if ($steamGameName != null) {
            $this$SteamAchievementsSection_u24lambda_u243_u240_u240.appendQueryParameter("steamGameName", $steamGameName);
        }
        Uri uri = $this$SteamAchievementsSection_u24lambda_u243_u240_u240.build();
        GlobalRouterKt.getGlobalRouter().launch(uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$1$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.module.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(new Pair[]{TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("achievement_type", "1")})));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$2$1$0$1$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.module.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(new Pair[]{TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("achievement_type", "1")})));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$2$1$0$2$1$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, Color.Companion.getBlack-0d7_KjU(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getSaturation-0nO6VwU(), 62, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$2$1$0$2$2(ColorFilter $grayscaleFilter, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C873@37299L88,872@37242L395:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(914135261, $changed, -1, "kntr.app.game.steam.SteamAchievementsSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:872)");
            }
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$2$1$0$2$3(ColorFilter $grayscaleFilter, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)881@37818L88,880@37761L395:SteamGamePage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1249158739, $changed, -1, "kntr.app.game.steam.SteamAchievementsSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:880)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$3$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.module.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(new Pair[]{TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("achievement_type", AdSearchSubCardType.CARD_TYPE_2)})));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$4$1$0$1$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.module.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(new Pair[]{TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("achievement_type", AdSearchSubCardType.CARD_TYPE_2)})));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$4$1$0$2$1$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, Color.Companion.getBlack-0d7_KjU(), 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, BlendMode.Companion.getSaturation-0nO6VwU(), 62, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$4$1$0$2$2(ColorFilter $grayscaleFilter, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1053@46671L88,1052@46614L395:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1820989076, $changed, -1, "kntr.app.game.steam.SteamAchievementsSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:1052)");
            }
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$4$1$0$2$3(ColorFilter $grayscaleFilter, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)1061@47190L88,1060@47133L395:SteamGamePage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1656004234, $changed, -1, "kntr.app.game.steam.SteamAchievementsSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:1060)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(32)), (Alignment) null, (ContentScale) null, 0.0f, $grayscaleFilter, $composer, Painter.$stable | 432, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$5$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.recent_module.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAchievementsSection$lambda$4$6$1$0$0(Map $commonReportParams) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-achievement.recent_list.show", MapsKt.plus($commonReportParams, MapsKt.mapOf(TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()))));
        return Unit.INSTANCE;
    }

    public static final void RecentUnlockItem(final RecentAchievementItem achievement, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter(achievement, "achievement");
        Composer $composer3 = $composer.startRestartGroup(2127921711);
        ComposerKt.sourceInformation($composer3, "C(RecentUnlockItem)N(achievement,modifier)1142@50610L5126:SteamGamePage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(achievement) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2127921711, $dirty, -1, "kntr.app.game.steam.RecentUnlockItem (SteamGamePage.kt:1141)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(52));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RecentUnlockItem_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -67432007, "C1146@50705L896,1172@51629L1350,1213@53016L1465,1253@54508L1222:SteamGamePage.kt#xy3gb6");
            String iconUrl = achievement.getIconUrl();
            if (iconUrl.length() == 0) {
                iconUrl = RoomRecommendViewModel.EMPTY_CURSOR;
            }
            String $this$asRequest_u24default$iv = iconUrl;
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), $this$RecentUnlockItem_u24lambda_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), Alignment.Companion.getTopStart()), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableSingletons$SteamGamePageKt.INSTANCE.m1264getLambda$801948828$gamebiz_debug(), ComposableSingletons$SteamGamePageKt.INSTANCE.m1263getLambda$785933734$gamebiz_debug(), $composer3, 113246208, 124);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default($this$RecentUnlockItem_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.constructor-impl(64), 0.0f, Dp.constructor-impl(83), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $changed$iv);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1142167713, "C1179@51834L309,1188@52156L40,1190@52227L324,1199@52564L40,1201@52637L332:SteamGamePage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(achievement.getAchievementName(), SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(15)), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(15), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 25008, 25008, 239592);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            TextKt.Text-Nvy7gAk(achievement.getDescription(), SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 25008, 25008, 239592);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            TextKt.Text-Nvy7gAk(achievement.getUnlockTimeFormatted(), SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 25008, 25008, 239592);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = OffsetKt.offset-VpY3zN4$default($this$RecentUnlockItem_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, Dp.constructor-impl(-10), 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
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
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 962616972, "C1221@53260L894,1241@54167L40,1243@54243L228:SteamGamePage.kt#xy3gb6");
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv4 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 890117609, "C1230@53671L68,1225@53402L357,1232@53776L39,1238@54052L68,1233@53832L308:SteamGamePage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(StringsKt.replace$default(achievement.getAchievePercentFormatted(), "%", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null), (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 48, 259946);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer3, 6);
            TextKt.Text-Nvy7gAk("%", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24966, 48, 259946);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(3)), $composer3, 6);
            TextKt.Text-Nvy7gAk("全网达成率", SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(14), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 25014, 48, 260072);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv5 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default($this$RecentUnlockItem_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart()), 0.0f, 1, (Object) null), Dp.constructor-impl(64), 0.0f, Dp.constructor-impl(0), 0.0f, 10, (Object) null), Dp.constructor-impl(3)), ColorKt.Color(268435455), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 1.5d)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv5 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv10;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1496835576, "C1269@55109L611:SteamGamePage.kt#xy3gb6");
            Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.replace$default(achievement.getAchievePercentFormatted(), "%", RoomRecommendViewModel.EMPTY_CURSOR, false, 4, (Object) null));
            float progressPercent = floatOrNull != null ? floatOrNull.floatValue() : 0.0f;
            float progressFraction = RangesKt.coerceIn(progressPercent / 100.0f, 0.0f, 1.0f);
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxWidth(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), progressFraction), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(ColorKt.Color(2583691263L))), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(ColorKt.Color(268435455)))}, 0.0f, 0.0f, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 1.5d)), 0.0f, 4, (Object) null), $composer3, 0);
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
            modifier2 = modifier$iv$iv;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecentUnlockItem$lambda$1;
                    RecentUnlockItem$lambda$1 = SteamGamePageKt.RecentUnlockItem$lambda$1(RecentAchievementItem.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RecentUnlockItem$lambda$1;
                }
            });
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -110
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void DLCSection(kntr.app.game.bean.DlcModule r146, kntr.app.game.steam.SteamGameVM r147, kotlinx.coroutines.CoroutineScope r148, java.lang.String r149, java.lang.String r150, androidx.compose.ui.Modifier r151, java.lang.String r152, java.lang.String r153, androidx.compose.runtime.Composer r154, int r155, int r156) {
        /*
            Method dump skipped, instructions count: 3352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.game.steam.SteamGamePageKt.DLCSection(kntr.app.game.bean.DlcModule, kntr.app.game.steam.SteamGameVM, kotlinx.coroutines.CoroutineScope, java.lang.String, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DLCSection$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$3$0(String $appId, String $sourceFrom, String $steamId, String $steamGameName) {
        ReportKt.reportClick("game-ball.steam-game-data.steam-game-dlc.module.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", $appId), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", $sourceFrom), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom())}));
        Builder $this$DLCSection_u24lambda_u243_u240_u240 = Uri.Companion.parse("bilibili://game/compose/steam/game/dlc_page").buildUpon().appendQueryParameter("steamId", $steamId).appendQueryParameter("appId", $appId).appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom);
        if ($steamGameName != null) {
            $this$DLCSection_u24lambda_u243_u240_u240.appendQueryParameter("steamGameName", $steamGameName);
        }
        Uri uri = $this$DLCSection_u24lambda_u243_u240_u240.build();
        GlobalRouterKt.getGlobalRouter().launch(uri);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$4$0(String $appId, String $sourceFrom) {
        ReportKt.reportExposure("game-ball.steam-game-data.steam-game-dlc.module.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", $appId), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", $sourceFrom), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom())}));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$5$0$0$0$0(String $appId, String $sourceFrom) {
        ReportKt.reportExposure("game-ball.steam-game-dlc.steam-game-dlc.refresh.show", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", $appId), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", $sourceFrom), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("bound_source", AdSearchSubCardType.CARD_TYPE_4)}));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$5$0$0$1$0$0(String $appId, String $sourceFrom, CoroutineScope $scope, SteamGameVM $viewModel) {
        ReportKt.reportClick("game-ball.steam-game-dlc.steam-game-dlc.refresh.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("app_id", $appId), TuplesKt.to(AdAlarmExtraKey.STATUS, "1"), TuplesKt.to("sourcefrom", $sourceFrom), TuplesKt.to("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()), TuplesKt.to("bound_source", AdSearchSubCardType.CARD_TYPE_4)}));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new SteamGamePageKt$DLCSection$3$1$1$2$1$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DLCSection$lambda$5$0$0$1$1(Animatable $rotateAnim, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1419@61148L22,1418@61087L334:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1827427857, $changed, -1, "kntr.app.game.steam.DLCSection.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SteamGamePage.kt:1418)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer, 6), "刷新", RotateKt.rotate(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), ((Number) $rotateAnim.getValue()).floatValue()), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer, Painter.$stable | 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v7 */
    public static final void DLCItem(final DlcItem dlc, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onClick;
        Function0 onClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        BoxScope $this$DLCItem_u24lambda_u241;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv3;
        Intrinsics.checkNotNullParameter(dlc, "dlc");
        Composer $composer4 = $composer.startRestartGroup(-1879837782);
        ComposerKt.sourceInformation($composer4, "C(DLCItem)N(dlc,modifier,onClick)1484@63415L2,1486@63427L2031:SteamGamePage.kt#xy3gb6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(dlc) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer4.changedInstance(function02) ? 256 : 128;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 1657126668, "CC(remember):SteamGamePage.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda31
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                onClick2 = function02;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1879837782, $dirty2, -1, "kntr.app.game.steam.DLCItem (SteamGamePage.kt:1485)");
            }
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(54)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), false, (String) null, (Role) null, (MutableInteractionSource) null, onClick2, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
            Function0 onClick3 = onClick2;
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
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$DLCItem_u24lambda_u2412 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -676805959, "C1495@63698L1315,1537@65214L68,1532@65037L415:SteamGamePage.kt#xy3gb6");
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default($this$DLCItem_u24lambda_u2412.align(Modifier.Companion, Alignment.Companion.getTopStart()), Dp.constructor-impl(10), Dp.constructor-impl(8), Dp.constructor-impl(10), 0.0f, 8, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            $composer2 = $composer4;
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
            int i7 = ((384 >> 6) & 112) | 6;
            RowScope $this$DLCItem_u24lambda_u241_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1392780020, "C1502@63952L318:SteamGamePage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk(dlc.getDlcName(), SizeKt.height-3ABfNKs($this$DLCItem_u24lambda_u241_u240.weight(Modifier.Companion, 1.0f, false), Dp.constructor-impl(18)), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 24960, 25008, 239592);
            if (dlc.getOwned()) {
                $composer4.startReplaceGroup(1393112525);
                ComposerKt.sourceInformation($composer4, "1512@64316L39,1513@64372L617");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer4, 6);
                Modifier modifier$iv3 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(36), Dp.constructor-impl(14)), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer3 = $composer4;
                $this$DLCItem_u24lambda_u241 = $this$DLCItem_u24lambda_u2412;
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
                $composer$iv = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i9 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -945648959, "C1520@64702L269:SteamGamePage.kt#xy3gb6");
                TextKt.Text-Nvy7gAk("已拥有", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.8f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(14), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer4, 24966, 48, 259050);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer3 = $composer4;
                $this$DLCItem_u24lambda_u241 = $this$DLCItem_u24lambda_u2412;
                $composer$iv = $composer4;
                $composer4.startReplaceGroup(1329306062);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            TextKt.Text-Nvy7gAk("¥" + dlc.getPriceYuan(), PaddingKt.padding-qDBjuR0$default($this$DLCItem_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getBottomStart()), Dp.constructor-impl(10), 0.0f, 0.0f, Dp.constructor-impl(8), 6, (Object) null), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(new Font[]{FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_bold(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14)}), 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 48, 259944);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onClick = onClick3;
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.steam.SteamGamePageKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2) {
                    Unit DLCItem$lambda$2;
                    DLCItem$lambda$2 = SteamGamePageKt.DLCItem$lambda$2(DlcItem.this, modifier5, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DLCItem$lambda$2;
                }
            });
        }
    }
}