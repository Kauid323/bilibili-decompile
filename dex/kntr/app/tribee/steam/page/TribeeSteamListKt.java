package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KLinkUrl;
import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievement;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementSuccess;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeData;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.steam.state.TribeeSteamGameAchievementState;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.compose.res.CommonRes;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: TribeeSteamList.kt */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u009b\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00122\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0018\u001aA\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010!\u001a\u001f\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010%\u001a\u0017\u0010&\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0002\u0010'\u001aJ\u0010(\u001a\u00020\u0001*\u00020)2\u0006\u0010\u0002\u001a\u00020*2\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u00122\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u00122\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0002¨\u0006+"}, d2 = {"TribeeSteamList", "", "state", "Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "accountInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "games", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "modifier", "Landroidx/compose/ui/Modifier;", "isMaster", "", "isSharing", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "onStateAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "onUpdateUserInfoHeight", "", "(Lkntr/app/tribee/steam/state/TribeeSteamState$SteamInfoState;Landroidx/compose/foundation/lazy/LazyListState;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "TribeeSteamGameFilter", "game", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "countString", "", "countIcon", "timeIcon", "isShowPullDownButton", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "SteamGameAchievementItem", "achievement", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AchievementItemImagePlaceholder", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "steamGameAchievementDataContent", "Landroidx/compose/foundation/lazy/LazyListScope;", "Lkntr/app/tribee/steam/state/TribeeSteamGameAchievementState;", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AchievementItemImagePlaceholder$lambda$0(Modifier modifier, int i, int i2, Composer composer, int i3) {
        AchievementItemImagePlaceholder(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementItem$lambda$1(KTribeeSteamHomeAchievementItem kTribeeSteamHomeAchievementItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SteamGameAchievementItem(kTribeeSteamHomeAchievementItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamGameFilter$lambda$1(KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, String str, String str2, String str3, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        TribeeSteamGameFilter(kTribeeSteamHomeGameItem, str, str2, str3, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$4(TribeeSteamState.SteamInfoState steamInfoState, LazyListState lazyListState, KTribeeSteamHomeData kTribeeSteamHomeData, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KTribeeSteamHomeGame kTribeeSteamHomeGame, Modifier modifier, boolean z, boolean z2, Function1 function1, Function1 function12, Function1 function13, int i, int i2, int i3, Composer composer, int i4) {
        TribeeSteamList(steamInfoState, lazyListState, kTribeeSteamHomeData, kTribeeSteamHomeUserInfo, kTribeeSteamHomeGame, modifier, z, z2, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$2$0(int it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r9v18 */
    public static final void TribeeSteamList(final TribeeSteamState.SteamInfoState state, final LazyListState lazyListState, final KTribeeSteamHomeData accountInfo, final KTribeeSteamHomeUserInfo userInfo, final KTribeeSteamHomeGame games, Modifier modifier, boolean isMaster, boolean isSharing, Function1<? super TribeeSteamUIAction, Unit> function1, Function1<? super TribeeSteamStateAction, Unit> function12, Function1<? super Integer, Unit> function13, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        boolean isMaster2;
        boolean isSharing2;
        Function1 onUIAction;
        Function1 onStateAction;
        Function1 onUpdateUserInfoHeight;
        int $dirty;
        KTribeeSteamHomeAchievementSuccess value;
        KTribeeSteamHomeAchievementSuccess value2;
        KTribeeSteamHomeAchievementSuccess value3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer $composer3 = $composer.startRestartGroup(-786308646);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamList)N(state,lazyListState,accountInfo,userInfo,games,modifier,isMaster,isSharing,onUIAction,onStateAction,onUpdateUserInfoHeight)81@3761L2,82@3819L2,83@3867L2,96@4581L5094,92@4463L5212:TribeeSteamList.kt#k3l5ii");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(lazyListState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(accountInfo) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(userInfo) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(games) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(isMaster) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changed(isSharing) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 67108864 : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function13) ? 4 : 2;
        }
        if ($composer3.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 3) == 2) ? false : true, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            isMaster2 = i3 != 0 ? true : isMaster;
            isSharing2 = i4 != 0 ? false : isSharing;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 271646780, "CC(remember):TribeeSteamList.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda21
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamList$lambda$0$0;
                            TribeeSteamList$lambda$0$0 = TribeeSteamListKt.TribeeSteamList$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamList$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onUIAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUIAction = onUIAction2;
            } else {
                onUIAction = function1;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 271648636, "CC(remember):TribeeSteamList.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamList$lambda$1$0;
                            TribeeSteamList$lambda$1$0 = TribeeSteamListKt.TribeeSteamList$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamList$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onStateAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction2;
            } else {
                onStateAction = function12;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 271650172, "CC(remember):TribeeSteamList.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamList$lambda$2$0;
                            TribeeSteamList$lambda$2$0 = TribeeSteamListKt.TribeeSteamList$lambda$2$0(((Integer) obj).intValue());
                            return TribeeSteamList$lambda$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function1 onUpdateUserInfoHeight2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUpdateUserInfoHeight = onUpdateUserInfoHeight2;
            } else {
                onUpdateUserInfoHeight = function13;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-786308646, $dirty2, $dirty1, "kntr.app.tribee.steam.page.TribeeSteamList (TribeeSteamList.kt:84)");
            }
            final TribeeSteamGameAchievementState achievementState = state.getAchievementState();
            final KTribeeSteamHomeAchievement achievements = achievementState.getAchievements();
            final KTribeeSteamHomeGameItem selectedGame = achievementState.getSelectedGame();
            KTribeeSteamHomeAchievement.IData data = achievements != null ? achievements.getData() : null;
            KTribeeSteamHomeAchievement.KSuccess kSuccess = data instanceof KTribeeSteamHomeAchievement.KSuccess ? (KTribeeSteamHomeAchievement.KSuccess) data : null;
            final String countString = (kSuccess == null || (value3 = kSuccess.getValue()) == null) ? null : value3.getCountStr();
            KTribeeSteamHomeAchievement.IData data2 = achievements != null ? achievements.getData() : null;
            KTribeeSteamHomeAchievement.KSuccess kSuccess2 = data2 instanceof KTribeeSteamHomeAchievement.KSuccess ? (KTribeeSteamHomeAchievement.KSuccess) data2 : null;
            final String countIcon = (kSuccess2 == null || (value2 = kSuccess2.getValue()) == null) ? null : value2.getAchieveCountIcon();
            KTribeeSteamHomeAchievement.IData data3 = achievements != null ? achievements.getData() : null;
            KTribeeSteamHomeAchievement.KSuccess kSuccess3 = data3 instanceof KTribeeSteamHomeAchievement.KSuccess ? (KTribeeSteamHomeAchievement.KSuccess) data3 : null;
            final String timeIcon = (kSuccess3 == null || (value = kSuccess3.getValue()) == null) ? null : value.getPlayTimeIcon();
            boolean z = !isSharing2;
            ComposerKt.sourceInformationMarkerStart($composer3, 271678112, "CC(remember):TribeeSteamList.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(userInfo) | (($dirty1 & 14) == 4) | ((234881024 & $dirty2) == 67108864) | (($dirty2 & 14) == 4) | $composer3.changedInstance(accountInfo) | ((3670016 & $dirty2) == 1048576) | ((29360128 & $dirty2) == 8388608) | ((1879048192 & $dirty2) == 536870912) | $composer3.changed(achievementState) | $composer3.changedInstance(achievements) | $composer3.changedInstance(selectedGame) | $composer3.changedInstance(games) | $composer3.changed(countString) | $composer3.changed(countIcon) | $composer3.changed(timeIcon);
            Object value$iv4 = $composer3.rememberedValue();
            if (invalid$iv || value$iv4 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                final boolean z2 = isSharing2;
                final Function1 function14 = onStateAction;
                final Function1 function15 = onUIAction;
                $composer2 = $composer3;
                final Function1 function16 = onUpdateUserInfoHeight;
                final boolean z3 = isMaster2;
                value$iv4 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit TribeeSteamList$lambda$3$0;
                        TribeeSteamList$lambda$3$0 = TribeeSteamListKt.TribeeSteamList$lambda$3$0(z2, achievementState, selectedGame, games, function14, function15, userInfo, function16, state, accountInfo, z3, achievements, countString, countIcon, timeIcon, (LazyListScope) obj);
                        return TribeeSteamList$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                $dirty = $dirty2;
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(modifier2, lazyListState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, z, (OverscrollEffect) null, (Function1) value$iv4, $composer2, (($dirty >> 15) & 14) | ($dirty & 112), 380);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            isMaster2 = isMaster;
            isSharing2 = isSharing;
            onUIAction = function1;
            onStateAction = function12;
            onUpdateUserInfoHeight = function13;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z4 = isMaster2;
            final boolean z5 = isSharing2;
            final Function1 function17 = onUIAction;
            final Function1 function18 = onStateAction;
            final Function1 function19 = onUpdateUserInfoHeight;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamList$lambda$4;
                    TribeeSteamList$lambda$4 = TribeeSteamListKt.TribeeSteamList$lambda$4(TribeeSteamState.SteamInfoState.this, lazyListState, accountInfo, userInfo, games, modifier3, z4, z5, function17, function18, function19, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamList$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$3$0(final boolean $isSharing, TribeeSteamGameAchievementState $achievementState, final KTribeeSteamHomeGameItem $selectedGame, final KTribeeSteamHomeGame $games, final Function1 $onStateAction, final Function1 $onUIAction, final KTribeeSteamHomeUserInfo $userInfo, final Function1 $onUpdateUserInfoHeight, final TribeeSteamState.SteamInfoState $state, final KTribeeSteamHomeData $accountInfo, final boolean $isMaster, final KTribeeSteamHomeAchievement $achievements, final String $countString, final String $countIcon, final String $timeIcon, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-806480731, true, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda14
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TribeeSteamList$lambda$3$0$0;
                TribeeSteamList$lambda$3$0$0 = TribeeSteamListKt.TribeeSteamList$lambda$3$0$0($userInfo, $onUpdateUserInfoHeight, $onUIAction, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TribeeSteamList$lambda$3$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-182920114, true, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda15
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit TribeeSteamList$lambda$3$0$1;
                TribeeSteamList$lambda$3$0$1 = TribeeSteamListKt.TribeeSteamList$lambda$3$0$1(TribeeSteamState.SteamInfoState.this, $accountInfo, $isMaster, $isSharing, $onStateAction, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return TribeeSteamList$lambda$3$0$1;
            }
        }), 3, (Object) null);
        boolean hideAchievement = $isSharing && (($achievementState instanceof TribeeSteamGameAchievementState.LoadingGameAchievementState) || ($achievementState instanceof TribeeSteamGameAchievementState.ErrorGameAchievementState));
        if (!hideAchievement) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(866191018, true, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeSteamList$lambda$3$0$2;
                    TribeeSteamList$lambda$3$0$2 = TribeeSteamListKt.TribeeSteamList$lambda$3$0$2($achievements, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeSteamList$lambda$3$0$2;
                }
            }), 3, (Object) null);
            if ($selectedGame != null && $games != null) {
                LazyListScope.-CC.stickyHeader$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(548448739, true, new Function4() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda17
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit TribeeSteamList$lambda$3$0$3;
                        TribeeSteamList$lambda$3$0$3 = TribeeSteamListKt.TribeeSteamList$lambda$3$0$3($isSharing, $games, $onUIAction, $selectedGame, $countString, $countIcon, $timeIcon, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return TribeeSteamList$lambda$3$0$3;
                    }
                }), 3, (Object) null);
            }
            steamGameAchievementDataContent($this$LazyColumn, $achievementState, $onStateAction, $onUIAction, $isSharing);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$3$0$0(KTribeeSteamHomeUserInfo $userInfo, Function1 $onUpdateUserInfoHeight, Function1 $onUIAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C98@4610L314:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806480731, $changed, -1, "kntr.app.tribee.steam.page.TribeeSteamList.<anonymous>.<anonymous>.<anonymous> (TribeeSteamList.kt:98)");
            }
            TribeeUserInfoKt.m1152TribeeUserInfoTN_CM5M($userInfo, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, $onUpdateUserInfoHeight, $onUIAction, $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$3$0$1(TribeeSteamState.SteamInfoState $state, KTribeeSteamHomeData $accountInfo, boolean $isMaster, boolean $isSharing, Function1 $onStateAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Iterable $this$any$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C115@5196L6,110@4963L581:TribeeSteamList.kt#k3l5ii");
        boolean z = false;
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-182920114, $changed, -1, "kntr.app.tribee.steam.page.TribeeSteamList.<anonymous>.<anonymous>.<anonymous> (TribeeSteamList.kt:110)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null);
            Iterable requestingActions = $state.getRequestingActions();
            if (requestingActions != null) {
                Iterable $this$any$iv2 = requestingActions;
                if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                    Iterator<T> it = $this$any$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            TribeeSteamStateAction it2 = (TribeeSteamStateAction) element$iv;
                            if (it2 instanceof TribeeSteamStateAction.LaunchPolling) {
                                $this$any$iv = 1;
                                break;
                            }
                        } else {
                            $this$any$iv = null;
                            break;
                        }
                    }
                } else {
                    $this$any$iv = null;
                }
                if ($this$any$iv == 1) {
                    z = true;
                }
            }
            TribeeSteamAccountInfoKt.TribeeSteamAccountInfo($accountInfo, modifier, $isMaster, z, $isSharing, $onStateAction, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$3$0$2(KTribeeSteamHomeAchievement $achievements, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C138@6158L6,133@5919L2062:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(866191018, $changed, -1, "kntr.app.tribee.steam.page.TribeeSteamList.<anonymous>.<anonymous>.<anonymous> (TribeeSteamList.kt:133)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeSteamList_u24lambda_u243_u240_u242_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 268469712, "C141@6286L972,169@7601L6,163@7280L683:TribeeSteamList.kt#k3l5ii");
            String $this$asRequest_u24default$iv = $achievements != null ? $achievements.getTitlePicUrl() : null;
            if ($this$asRequest_u24default$iv == null) {
                $this$asRequest_u24default$iv = "";
            }
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), "icon", null, null, null, null, ComposableSingletons$TribeeSteamListKt.INSTANCE.m1116getLambda$688143295$consume_debug(), ComposableSingletons$TribeeSteamListKt.INSTANCE.getLambda$2140584247$consume_debug(), $composer, 113246640, BackoffConfigKt.MAX_DELAY_SECONDS);
            String it = ($achievements == null || (it = $achievements.getTitle()) == null || StringsKt.isBlank(it)) ? null : null;
            if (it == null) {
                $composer.startReplaceGroup(1948356925);
                ComposerKt.sourceInformation($composer, "165@7396L119");
                it = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_27(TribeeRes.INSTANCE.getString()), $composer, 0);
            } else {
                $composer.startReplaceGroup(1948355344);
            }
            $composer.endReplaceGroup();
            TextKt.Text-Nvy7gAk(it, RowScope.-CC.weight$default($this$TribeeSteamList_u24lambda_u243_u240_u242_u240, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer, 1597440, 24960, 241576);
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
    public static final Unit TribeeSteamList$lambda$3$0$3(boolean $isSharing, final KTribeeSteamHomeGame $games, final Function1 $onUIAction, final KTribeeSteamHomeGameItem $selectedGame, String $countString, String $countIcon, String $timeIcon, LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)189@8444L39,191@8574L514,184@8188L1210:TribeeSteamList.kt#k3l5ii");
        boolean z = false;
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(548448739, $changed, -1, "kntr.app.tribee.steam.page.TribeeSteamList.<anonymous>.<anonymous>.<anonymous> (TribeeSteamList.kt:183)");
            }
            if (!$isSharing && $games.getItem().size() > 1) {
                z = true;
            }
            final boolean isShowPullDownButton = z;
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1221727638, "CC(remember):TribeeSteamList.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1221723003, "CC(remember):TribeeSteamList.kt#9igjgp");
            boolean invalid$iv = $composer.changed(isShowPullDownButton) | $composer.changed($onUIAction) | $composer.changedInstance($games) | $composer.changedInstance($selectedGame);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit TribeeSteamList$lambda$3$0$3$1$0;
                        TribeeSteamList$lambda$3$0$3$1$0 = TribeeSteamListKt.TribeeSteamList$lambda$3$0$3$1$0(isShowPullDownButton, $onUIAction, $games, $selectedGame);
                        return TribeeSteamList$lambda$3$0$3$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeSteamGameFilter($selectedGame, $countString == null ? "" : $countString, $countIcon == null ? "" : $countIcon, $timeIcon == null ? "" : $timeIcon, ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), isShowPullDownButton, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamList$lambda$3$0$3$1$0(boolean $isShowPullDownButton, Function1 $onUIAction, KTribeeSteamHomeGame $games, KTribeeSteamHomeGameItem $selectedGame) {
        if ($isShowPullDownButton) {
            $onUIAction.invoke(new TribeeSteamUIAction.ShowGameListBottomSheet($games, $selectedGame));
        }
        return Unit.INSTANCE;
    }

    private static final void TribeeSteamGameFilter(final KTribeeSteamHomeGameItem game, final String countString, final String countIcon, final String timeIcon, Modifier modifier, boolean isShowPullDownButton, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isShowPullDownButton2;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv2;
        Modifier materialized$iv$iv;
        int $dirty;
        Composer $composer$iv$iv;
        String str;
        String str2;
        String str3;
        String str4;
        Composer $composer$iv$iv2;
        Composer $composer$iv3;
        Composer $composer3;
        Composer $composer$iv4;
        Composer $composer$iv5;
        Composer $composer$iv6;
        Composer $composer$iv$iv3;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv$iv$iv3;
        Composer $composer$iv7;
        Composer $composer4;
        Composer $composer5;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Composer $composer6 = $composer.startRestartGroup(2116292182);
        ComposerKt.sourceInformation($composer6, "C(TribeeSteamGameFilter)N(game,countString,countIcon,timeIcon,modifier,isShowPullDownButton)233@10029L6,229@9917L6155:TribeeSteamList.kt#k3l5ii");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer6.changedInstance(game) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer6.changed(countString) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer6.changed(countIcon) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer6.changed(timeIcon) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer6.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            z = isShowPullDownButton;
        } else if ((196608 & $changed) == 0) {
            z = isShowPullDownButton;
            $dirty2 |= $composer6.changed(z) ? 131072 : 65536;
        } else {
            z = isShowPullDownButton;
        }
        int $dirty3 = $dirty2;
        if ($composer6.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                isShowPullDownButton2 = z;
            } else {
                isShowPullDownButton2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116292182, $dirty3, -1, "kntr.app.tribee.steam.page.TribeeSteamGameFilter (TribeeSteamList.kt:228)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(modifier4, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier4;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeSteamGameFilter_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, -2081495154, "C238@10207L1058,268@11275L3688:TribeeSteamList.kt#k3l5ii");
            String $this$asRequest$iv = game.getGameHeader();
            ImageRequest $this$TribeeSteamGameFilter_u24lambda_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$TribeeSteamGameFilter_u24lambda_u240_u240.contentScale(ContentScale.Companion.getCrop());
            BiliImageKt.BiliImage($this$TribeeSteamGameFilter_u24lambda_u240_u240.build(), ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(90), Dp.constructor-impl(40)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), "game cover", null, null, null, null, ComposableSingletons$TribeeSteamListKt.INSTANCE.getLambda$195441837$consume_debug(), ComposableSingletons$TribeeSteamListKt.INSTANCE.getLambda$1057412387$consume_debug(), $composer6, 113246592, BackoffConfigKt.MAX_DELAY_SECONDS);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeeSteamGameFilter_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 978115717, "C280@11645L9,281@11694L6,274@11431L370,286@11815L3138:TribeeSteamList.kt#k3l5ii");
            TextKt.Text-Nvy7gAk(game.getGameName(), SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT13(), $composer6, 48, 24960, 110584);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(12), Alignment.Companion.getStart());
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer6, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv3 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer6.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i9 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 1054981871, "C:TribeeSteamList.kt#k3l5ii");
            if (!StringsKt.isBlank(game.getGameTime())) {
                $composer6.startReplaceGroup(1054970772);
                ComposerKt.sourceInformation($composer6, "299@12309L1262");
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                $composer$iv$iv$iv = $composer6;
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv4 = Modifier.Companion;
                $composer$iv = $composer6;
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer6, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv4 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer6.getCurrentCompositionLocalMap();
                $composer$iv2 = $composer6;
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer6, modifier$iv4);
                Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                materialized$iv$iv = materialized$iv$iv4;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv10;
                    $composer6.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv10;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer6);
                $composer$iv$iv = $composer6;
                $dirty = $dirty3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i11 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, 1471504367, "C302@12434L888,323@13449L9,324@13510L6,321@13347L202:TribeeSteamList.kt#k3l5ii");
                ImageRequest $this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u240_u240 = new ImageRequest(timeIcon);
                $this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u240_u240.contentScale(ContentScale.Companion.getCrop());
                BiliImageKt.BiliImage($this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u240_u240.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(2), 0.0f, 11, (Object) null), Dp.constructor-impl(12)), "game time icon", null, null, null, null, null, ComposableSingletons$TribeeSteamListKt.INSTANCE.m1111getLambda$1378224214$consume_debug(), $composer6, 100663728, 248);
                TextKt.Text-Nvy7gAk(game.getGameTime(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
            } else {
                $composer$iv$iv$iv = $composer6;
                $composer$iv = $composer6;
                $composer$iv2 = $composer6;
                materialized$iv$iv = materialized$iv$iv4;
                $dirty = $dirty3;
                $composer$iv$iv = $composer6;
                $composer6.startReplaceGroup(1042740714);
            }
            $composer6.endReplaceGroup();
            if (StringsKt.isBlank(countString)) {
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str2 = "C101@5233L9:Row.kt#2w3rfo";
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer2 = $composer6;
                $composer$iv$iv2 = $composer6;
                $composer$iv3 = $composer6;
                $composer3 = $composer6;
                $composer$iv4 = $composer$iv;
                $composer$iv5 = $composer6;
                modifier3 = modifier5;
                $composer$iv6 = $composer6;
                $composer$iv$iv3 = $composer6;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                $composer$iv$iv$iv3 = $composer6;
                $composer$iv7 = $composer6;
                $composer4 = $composer6;
                $composer4.startReplaceGroup(1042740714);
                $composer4.endReplaceGroup();
            } else {
                $composer6.startReplaceGroup(1056309972);
                ComposerKt.sourceInformation($composer6, "330@13659L1262");
                Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Modifier modifier$iv5 = Modifier.Companion;
                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer6, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv5 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer6.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer6, modifier$iv5);
                Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer6.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer6.startReusableNode();
                if ($composer6.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv11;
                    $composer6.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv11;
                    $composer6.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer6);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope3 = RowScopeInstance.INSTANCE;
                int i13 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer6, 824785062, "C333@13784L890,354@14799L9,355@14860L6,352@14699L200:TribeeSteamList.kt#k3l5ii");
                ImageRequest $this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u241_u240 = new ImageRequest(countIcon);
                $this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u241_u240.contentScale(ContentScale.Companion.getCrop());
                BiliImageKt.BiliImage($this$TribeeSteamGameFilter_u24lambda_u240_u241_u240_u241_u240.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(2), 0.0f, 11, (Object) null), Dp.constructor-impl(12)), "game count icon", null, null, null, null, null, ComposableSingletons$TribeeSteamListKt.INSTANCE.m1115getLambda$438183405$consume_debug(), $composer6, 100663728, 248);
                str = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                $composer$iv$iv3 = $composer6;
                $composer$iv6 = $composer6;
                $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                $composer$iv$iv$iv3 = $composer6;
                $composer$iv7 = $composer6;
                $composer$iv4 = $composer$iv;
                $composer$iv5 = $composer6;
                modifier3 = modifier5;
                $composer$iv3 = $composer6;
                $composer3 = $composer6;
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer2 = $composer6;
                $composer$iv$iv2 = $composer6;
                str2 = "C101@5233L9:Row.kt#2w3rfo";
                TextKt.Text-Nvy7gAk(countString, (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT12(), $composer6, ($dirty >> 3) & 14, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer6);
                $composer6.endReplaceGroup();
                $composer4 = $composer6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv5);
            $composer$iv7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (isShowPullDownButton2) {
                $composer5 = $composer3;
                $composer5.startReplaceGroup(-2076890043);
                ComposerKt.sourceInformation($composer5, "371@15358L6,372@15442L6,373@15530L6,363@15013L1043");
                Modifier modifier$iv6 = BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(28), Dp.constructor-impl(20)), Dp.constructor-impl(1), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10)), false, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText3-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText3-0d7_KjU(), 1.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 4, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10)));
                Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv5 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer5, 844473419, str);
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv6 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, str3);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer5, modifier$iv6);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str4);
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer5.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv12;
                    $composer5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer5);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i14 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, str2);
                RowScope rowScope4 = RowScopeInstance.INSTANCE;
                int i15 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, 820170082, "C378@15789L21,382@15955L6,377@15740L302:TribeeSteamList.kt#k3l5ii");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_expand_line_900($composer5, 6), "filter icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText3-0d7_KjU(), $composer5, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
            } else {
                $composer5 = $composer3;
                $composer5.startReplaceGroup(-2091803120);
            }
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isShowPullDownButton2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z2 = isShowPullDownButton2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamGameFilter$lambda$1;
                    TribeeSteamGameFilter$lambda$1 = TribeeSteamListKt.TribeeSteamGameFilter$lambda$1(game, countString, countIcon, timeIcon, modifier6, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamGameFilter$lambda$1;
                }
            });
        }
    }

    private static final void SteamGameAchievementItem(final KTribeeSteamHomeAchievementItem achievement, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(769087671);
        ComposerKt.sourceInformation($composer3, "C(SteamGameAchievementItem)N(achievement,modifier)395@16219L2054:TribeeSteamList.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(achievement) ? 4 : 2;
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
                ComposerKt.traceEventStart(769087671, $dirty, -1, "kntr.app.tribee.steam.page.SteamGameAchievementItem (TribeeSteamList.kt:394)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            int $changed$iv = (($dirty >> 3) & 14) | 384;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2070761927, "C399@16332L1372,439@17824L6,436@17714L306,449@18140L6,446@18030L237:TribeeSteamList.kt#k3l5ii");
            Modifier modifier$iv2 = BorderKt.border-ziNgDLE(ClipKt.clip(SizeKt.size-3ABfNKs(ShadowKt.shadow-s4CzXII$default(Modifier.Companion, Dp.constructor-impl(10), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), false, 0L, 0L, 28, (Object) null), Dp.constructor-impl(48)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(3), Brush.Companion.linearGradient-mHitzGk$default(Brush.Companion, TribeeExtensionsKt.getBorderColorList(achievement), 0L, 0L, 0, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1861314313, "C422@17225L137,414@16919L775:TribeeSteamList.kt#k3l5ii");
            String $this$asRequest$iv = achievement.getAchievePicUrl();
            ImageRequest $this$SteamGameAchievementItem_u24lambda_u240_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$SteamGameAchievementItem_u24lambda_u240_u240_u240.contentScale(ContentScale.Companion.getCrop());
            ImmutableImageRequest build = $this$SteamGameAchievementItem_u24lambda_u240_u240_u240.build();
            Modifier modifier5 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(46));
            ComposerKt.sourceInformationMarkerStart($composer3, 1029882876, "CC(remember):TribeeSteamList.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda19
                    public final Object invoke(Object obj) {
                        Unit SteamGameAchievementItem$lambda$0$0$1$0;
                        SteamGameAchievementItem$lambda$0$0$1$0 = TribeeSteamListKt.SteamGameAchievementItem$lambda$0$0$1$0((GraphicsLayerScope) obj);
                        return SteamGameAchievementItem$lambda$0$0$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), "steam game cover", null, null, null, null, ComposableSingletons$TribeeSteamListKt.INSTANCE.getLambda$899740248$consume_debug(), ComposableSingletons$TribeeSteamListKt.INSTANCE.m1112getLambda$176637790$consume_debug(), $composer3, 113246592, BackoffConfigKt.MAX_DELAY_SECONDS);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(achievement.getAchieveName(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(4), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(15), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 25008, 239592);
            TextKt.Text-Nvy7gAk(achievement.getAchieveTime(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(14), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 25008, 239594);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamGameAchievementItem$lambda$1;
                    SteamGameAchievementItem$lambda$1 = TribeeSteamListKt.SteamGameAchievementItem$lambda$1(achievement, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamGameAchievementItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamGameAchievementItem$lambda$0$0$1$0(GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setTranslationX($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        $this$graphicsLayer.setTranslationY($this$graphicsLayer.toPx-0680j_4(Dp.constructor-impl(1)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AchievementItemImagePlaceholder(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(1946046498);
        ComposerKt.sourceInformation($composer2, "C(AchievementItemImagePlaceholder)N(modifier)463@18493L6,459@18370L181:TribeeSteamList.kt#k3l5ii");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1946046498, $dirty, -1, "kntr.app.tribee.steam.page.AchievementItemImagePlaceholder (TribeeSteamList.kt:458)");
            }
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(modifier, Dp.constructor-impl(46)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), $composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit AchievementItemImagePlaceholder$lambda$0;
                    AchievementItemImagePlaceholder$lambda$0 = TribeeSteamListKt.AchievementItemImagePlaceholder$lambda$0(modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AchievementItemImagePlaceholder$lambda$0;
                }
            });
        }
    }

    static /* synthetic */ void steamGameAchievementDataContent$default(LazyListScope lazyListScope, TribeeSteamGameAchievementState tribeeSteamGameAchievementState, Function1 function1, Function1 function12, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj2) {
                    Unit steamGameAchievementDataContent$lambda$0;
                    steamGameAchievementDataContent$lambda$0 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$0((TribeeSteamStateAction) obj2);
                    return steamGameAchievementDataContent$lambda$0;
                }
            };
        }
        if ((i & 4) != 0) {
            function12 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2) {
                    Unit steamGameAchievementDataContent$lambda$1;
                    steamGameAchievementDataContent$lambda$1 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$1((TribeeSteamUIAction) obj2);
                    return steamGameAchievementDataContent$lambda$1;
                }
            };
        }
        if ((i & 8) != 0) {
            z = false;
        }
        steamGameAchievementDataContent(lazyListScope, tribeeSteamGameAchievementState, function1, function12, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit steamGameAchievementDataContent$lambda$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit steamGameAchievementDataContent$lambda$1(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    private static final void steamGameAchievementDataContent(LazyListScope $this$steamGameAchievementDataContent, final TribeeSteamGameAchievementState state, final Function1<? super TribeeSteamStateAction, Unit> function1, final Function1<? super TribeeSteamUIAction, Unit> function12, final boolean isSharing) {
        if (state instanceof TribeeSteamGameAchievementState.SuccessGameAchievementState) {
            LazyListScope.-CC.items$default($this$steamGameAchievementDataContent, ((TribeeSteamGameAchievementState.SuccessGameAchievementState) state).getSectionList().size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-901811820, true, new Function4() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit steamGameAchievementDataContent$lambda$2;
                    steamGameAchievementDataContent$lambda$2 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$2(TribeeSteamGameAchievementState.this, function12, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                    return steamGameAchievementDataContent$lambda$2;
                }
            }), 6, (Object) null);
        } else if (state instanceof TribeeSteamGameAchievementState.LoadingGameAchievementState) {
            LazyListScope.-CC.item$default($this$steamGameAchievementDataContent, (Object) null, (Object) null, ComposableSingletons$TribeeSteamListKt.INSTANCE.m1114getLambda$1892238796$consume_debug(), 3, (Object) null);
        } else if (state instanceof TribeeSteamGameAchievementState.ErrorGameAchievementState) {
            LazyListScope.-CC.item$default($this$steamGameAchievementDataContent, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1589351405, true, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit steamGameAchievementDataContent$lambda$3;
                    steamGameAchievementDataContent$lambda$3 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$3(function1, state, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return steamGameAchievementDataContent$lambda$3;
                }
            }), 3, (Object) null);
        } else if (!(state instanceof TribeeSteamGameAchievementState.GameWithoutAchievementsState) && !(state instanceof TribeeSteamGameAchievementState.EmptyGameState)) {
            throw new NoWhenBranchMatchedException();
        } else {
            LazyListScope.-CC.item$default($this$steamGameAchievementDataContent, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1286464014, true, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit steamGameAchievementDataContent$lambda$4;
                    steamGameAchievementDataContent$lambda$4 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$4(isSharing, state, function12, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return steamGameAchievementDataContent$lambda$4;
                }
            }), 3, (Object) null);
        }
        if (state instanceof TribeeSteamGameAchievementState.SuccessGameAchievementState) {
            LazyListScope.-CC.item$default($this$steamGameAchievementDataContent, (Object) null, (Object) null, ComposableSingletons$TribeeSteamListKt.INSTANCE.m1113getLambda$1808844882$consume_debug(), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0276, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit steamGameAchievementDataContent$lambda$2(TribeeSteamGameAchievementState $state, final Function1 $onUIAction, LazyItemScope $this$items, int it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        List section;
        boolean z;
        int $changed$iv;
        Object it$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(it)484@19275L6,479@19060L1992:TribeeSteamList.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(it) ? 32 : 16;
        }
        if ($composer.shouldExecute(($dirty & 145) != 144, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-901811820, $dirty, -1, "kntr.app.tribee.steam.page.steamGameAchievementDataContent.<anonymous> (TribeeSteamList.kt:478)");
            }
            List section2 = (List) CollectionsKt.getOrNull(((TribeeSteamGameAchievementState.SuccessGameAchievementState) $state).getSectionList(), it);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(130)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, it == 0 ? Dp.constructor-impl(12) : Dp.constructor-impl(0), 0.0f, it == ((TribeeSteamGameAchievementState.SuccessGameAchievementState) $state).getSectionList().size() - 1 ? Dp.constructor-impl(12) : Dp.constructor-impl(0), 5, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            int $changed$iv2 = 384;
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$steamGameAchievementDataContent_u24lambda_u242_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -85051994, "C:TribeeSteamList.kt#k3l5ii");
            $composer.startReplaceGroup(1936919037);
            ComposerKt.sourceInformation($composer, "");
            int i3 = 0;
            while (i3 < 3) {
                int index = i3;
                final KTribeeSteamHomeAchievementItem achievement = section2 != null ? (KTribeeSteamHomeAchievementItem) CollectionsKt.getOrNull(section2, index) : null;
                if (achievement != null) {
                    section = section2;
                    $composer.startReplaceGroup(1873023421);
                    ComposerKt.sourceInformation($composer, "500@20135L39,502@20281L375,495@19853L893");
                    Modifier weight$default = RowScope.-CC.weight$default($this$steamGameAchievementDataContent_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    z = z2;
                    ComposerKt.sourceInformationMarkerStart($composer, -1325045041, "CC(remember):TribeeSteamList.kt#9igjgp");
                    Object it$iv2 = $composer.rememberedValue();
                    $changed$iv = $changed$iv2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                        $composer.updateRememberedValue(MutableInteractionSource);
                        it$iv = MutableInteractionSource;
                    } else {
                        it$iv = it$iv2;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1325040033, "CC(remember):TribeeSteamList.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onUIAction) | $composer.changedInstance(achievement);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit steamGameAchievementDataContent$lambda$2$0$0$1$0;
                            steamGameAchievementDataContent$lambda$2$0$0$1$0 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$2$0$0$1$0($onUIAction, achievement);
                            return steamGameAchievementDataContent$lambda$2$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv3 = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    SteamGameAchievementItem(achievement, ClickableKt.clickable-O2vRcR0$default(weight$default, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), $composer, 0, 0);
                    $composer.endReplaceGroup();
                } else {
                    section = section2;
                    z = z2;
                    $changed$iv = $changed$iv2;
                    $composer.startReplaceGroup(1873920592);
                    ComposerKt.sourceInformation($composer, "512@20808L178");
                    SpacerKt.Spacer(RowScope.-CC.weight$default($this$steamGameAchievementDataContent_u24lambda_u242_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer, 0);
                    $composer.endReplaceGroup();
                }
                i3++;
                z2 = z;
                section2 = section;
                $changed$iv2 = $changed$iv;
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
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit steamGameAchievementDataContent$lambda$2$0$0$1$0(Function1 $onUIAction, KTribeeSteamHomeAchievementItem $achievement) {
        $onUIAction.invoke(new TribeeSteamUIAction.ShowGameAchievementBottomSheet($achievement));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x02a3, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit steamGameAchievementDataContent$lambda$3(final Function1 $onStateAction, final TribeeSteamGameAchievementState $state, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C553@22333L2316:TribeeSteamList.kt#k3l5ii");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1589351405, $changed, -1, "kntr.app.tribee.steam.page.steamGameAchievementDataContent.<anonymous> (TribeeSteamList.kt:553)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 42301689, "C561@22700L22,564@22902L6,560@22646L291,567@22995L56,568@23095L6,569@23151L9,566@22958L229,577@23506L6,580@23697L39,582@23839L356,571@23208L1423:TribeeSteamList.kt#k3l5ii");
            BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getBrandtv_error_line_500($composer, 6), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(80), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(24)), "error icon", BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_29(TribeeRes.INSTANCE.getString()), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 131066);
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(74), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer, -552793072, "CC(remember):TribeeSteamList.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -552788211, "CC(remember):TribeeSteamList.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onStateAction) | $composer.changed($state);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    Unit steamGameAchievementDataContent$lambda$3$0$1$0;
                    steamGameAchievementDataContent$lambda$3$0$1$0 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$3$0$1$0($onStateAction, $state);
                    return steamGameAchievementDataContent$lambda$3$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
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
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1891055385, "C594@24461L56,595@24565L6,593@24420L189:TribeeSteamList.kt#k3l5ii");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_30(TribeeRes.INSTANCE.getString()), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 0, 0, 262138);
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
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit steamGameAchievementDataContent$lambda$3$0$1$0(Function1 $onStateAction, TribeeSteamGameAchievementState $state) {
        $onStateAction.invoke(new TribeeSteamStateAction.ToggleGameAchievement(((TribeeSteamGameAchievementState.ErrorGameAchievementState) $state).getSelectedGame()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x03b8, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit steamGameAchievementDataContent$lambda$4(boolean $isSharing, TribeeSteamGameAchievementState $state, final Function1 $onUIAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Object value$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C:TribeeSteamList.kt#k3l5ii");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1286464014, $changed, -1, "kntr.app.tribee.steam.page.steamGameAchievementDataContent.<anonymous> (TribeeSteamList.kt:604)");
            }
            if (!$isSharing) {
                $composer.startReplaceGroup(-1056109351);
                ComposerKt.sourceInformation($composer, "605@24876L3031");
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv = (438 << 3) & 112;
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
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
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
                int i2 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1453292428, "C629@26233L6,630@26293L9,627@26064L327,657@27844L41:TribeeSteamList.kt#k3l5ii");
                $composer.startReplaceGroup(-46881534);
                ComposerKt.sourceInformation($composer, "");
                KTipsCard tipsCard = $state.getTipsCard();
                String picUrl = tipsCard != null ? tipsCard.getPicUrl() : null;
                if (picUrl == null) {
                    str = "";
                    $composer.startReplaceGroup(1830849968);
                    ComposerKt.sourceInformation($composer, "621@25734L51,620@25681L302");
                    ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_empty(CommonRes.INSTANCE.getDrawable()), $composer, 0), "empty_image", SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(80), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                    $composer.endReplaceGroup();
                } else {
                    str = "";
                    $composer.startReplaceGroup(1830508813);
                    ComposerKt.sourceInformation($composer, "614@25338L273");
                    String $this$asRequest_u24default$iv = picUrl;
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(80), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(140)), "empty_image", null, null, null, null, null, null, $composer, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                    $composer.endReplaceGroup();
                }
                Unit unit2 = Unit.INSTANCE;
                $composer.endReplaceGroup();
                KTipsCard tipsCard2 = $state.getTipsCard();
                String desc = tipsCard2 != null ? tipsCard2.getDesc() : null;
                if (desc == null) {
                    $composer.startReplaceGroup(-46853829);
                    ComposerKt.sourceInformation($composer, "628@26129L56");
                    desc = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_31(TribeeRes.INSTANCE.getString()), $composer, 0);
                } else {
                    $composer.startReplaceGroup(-46854573);
                }
                $composer.endReplaceGroup();
                TextKt.Text-Nvy7gAk(desc, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 130042);
                KLinkUrl steamPrivateRule = $state.getSteamPrivateRule();
                final String linkUrl = steamPrivateRule != null ? steamPrivateRule.getJumpUrl() : null;
                if (linkUrl == null) {
                    linkUrl = str;
                }
                KLinkUrl steamPrivateRule2 = $state.getSteamPrivateRule();
                String showWord = steamPrivateRule2 != null ? steamPrivateRule2.getShowWord() : null;
                if (showWord == null) {
                    showWord = str;
                }
                String linkString = showWord;
                if (StringsKt.isBlank(linkString) || StringsKt.isBlank(linkUrl)) {
                    $composer.startReplaceGroup(-1478391393);
                } else {
                    $composer.startReplaceGroup(-1451890299);
                    ComposerKt.sourceInformation($composer, "638@26786L6,639@26854L9,645@27196L39,647@27354L365,636@26679L1114");
                    long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_link-0d7_KjU();
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
                    int i3 = TextAlign.Companion.getCenter-e0LSkKk();
                    Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, -46819702, "CC(remember):TribeeSteamList.kt#9igjgp");
                    Object it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        value$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -46814320, "CC(remember):TribeeSteamList.kt#9igjgp");
                    boolean invalid$iv = $composer.changed($onUIAction) | $composer.changed(linkUrl);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv2 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamListKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit steamGameAchievementDataContent$lambda$4$0$2$0;
                            steamGameAchievementDataContent$lambda$4$0$2$0 = TribeeSteamListKt.steamGameAchievementDataContent$lambda$4$0$2$0($onUIAction, linkUrl);
                            return steamGameAchievementDataContent$lambda$4$0$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TextKt.Text-Nvy7gAk(linkString, ClickableKt.clickable-O2vRcR0$default(modifier, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i3), 0L, 0, false, 0, 0, (Function1) null, t12, $composer, 0, 0, 130040);
                }
                $composer.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer, 6);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1053151765);
                ComposerKt.sourceInformation($composer, "660@27953L637");
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(160)), 0.0f, 1, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (54 << 3) & 112;
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
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
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
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1767582117, "C669@28410L6,670@28470L9,667@28236L332:TribeeSteamList.kt#k3l5ii");
                KTipsCard tipsCard3 = $state.getTipsCard();
                String descShare = tipsCard3 != null ? tipsCard3.getDescShare() : null;
                if (descShare == null) {
                    $composer.startReplaceGroup(-2135226796);
                    ComposerKt.sourceInformation($composer, "668@28306L56");
                    descShare = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_31(TribeeRes.INSTANCE.getString()), $composer, 0);
                } else {
                    $composer.startReplaceGroup(-2135227695);
                }
                $composer.endReplaceGroup();
                TextKt.Text-Nvy7gAk(descShare, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 0, 0, 130042);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit steamGameAchievementDataContent$lambda$4$0$2$0(Function1 $onUIAction, String $linkUrl) {
        $onUIAction.invoke(new TribeeSteamUIAction.RouterTo($linkUrl));
        return Unit.INSTANCE;
    }
}