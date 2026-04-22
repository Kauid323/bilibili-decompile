package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
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
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnPlacedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import com.bapis.bilibili.app.dynamic.v2.KColor;
import com.bapis.bilibili.app.dynamic.v2.KExitTribeeToast;
import com.bapis.bilibili.app.dynamic.v2.KFootHoverToast;
import com.bapis.bilibili.app.dynamic.v2.KGlobalPermissionType;
import com.bapis.bilibili.app.dynamic.v2.KJoinButton;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntry;
import com.bapis.bilibili.app.dynamic.v2.KNavigationEntryGameStats;
import com.bapis.bilibili.app.dynamic.v2.KNavigationType;
import com.bapis.bilibili.app.dynamic.v2.KPublishButton;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeBaseInfo;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInteraction;
import com.bapis.bilibili.app.dynamic.v2.KTribeeNavigation;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kntr.app.tribee.base.TribeeResultChannel;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.TribeePreference;
import kntr.app.tribee.consume.page.mine.TribeeUserCenterComposeKt;
import kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt;
import kntr.app.tribee.consume.viewmodel.TribeeHomeEntryPoint;
import kntr.app.tribee.consume.viewmodel.TribeeHomeStateAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeUIAction;
import kntr.app.tribee.consume.viewmodel.TribeeHomeViewModel;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeErrorState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeInitialState;
import kntr.app.tribee.consume.viewmodel.state.TribeeHomeState;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.Router;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.share.common.ShareParams;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeHomePage.kt */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u001aa\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0097\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u00152\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010!\u001a\u0097\u0001\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00060\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u00152\u0014\b\u0002\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010$\u001aH\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020#2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u00152\u0014\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u00060\u0015\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003¨\u0006)²\u0006\f\u0010*\u001a\u0004\u0018\u00010\u0016X\u008a\u008e\u0002²\u0006\f\u0010+\u001a\u0004\u0018\u00010,X\u008a\u008e\u0002²\u0006\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u008a\u0084\u0002²\u0006\u0016\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u0015X\u008a\u0084\u0002²\u0006\u0016\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00060\u0015X\u008a\u0084\u0002²\u0006\n\u00100\u001a\u000201X\u008a\u008e\u0002²\u0006\f\u00102\u001a\u0004\u0018\u000103X\u008a\u008e\u0002²\u0006\u0016\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00060\u0015X\u008a\u0084\u0002²\u0006\u0018\u00105\u001a\u0010\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u000208\u0018\u000106X\u008a\u008e\u0002²\u0006\n\u00109\u001a\u000208X\u008a\u008e\u0002²\u0006\n\u0010:\u001a\u000208X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010<\u001a\u000201X\u008a\u008e\u0002"}, d2 = {"NAVIGATION_HEIGHT", "Landroidx/compose/ui/unit/Dp;", "getNAVIGATION_HEIGHT", "()F", "F", "TribeeHomePage", "", "id", "", "fromSpmid", "tribeeId", "inviteCode", "categoryIdFromRouter", "fakeCardResultKeyFromRouter", "insertFakeCardToastFromRouter", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "pageState", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;", "pageScrollState", "Landroidx/compose/foundation/ScrollState;", "updateToasterDialog", "Lkotlin/Function1;", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "hasUsedFakeCardResultKeyHandler", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "onStateAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeStateAction;", "onUIAction", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeUIAction;", "fakeCardResultKey", "insertFakeCardToast", "(Ljava/lang/String;Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeState;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TribeeHomeContent", "Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;", "(Ljava/lang/String;Lkntr/app/tribee/consume/viewmodel/state/TribeeHomeContentState;Landroidx/compose/foundation/ScrollState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "checkTribeeHomePermission", "action", "router", "Lkntr/base/router/Router;", "consume_debug", "toasterDialog", "revisitGuideDialog", "Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;", "latestOnHasUsedFakeCardResultKeyHandler", "latestOnStateAction", "latestOnUIAction", "showDrawer", "", "shareParams", "Lkntr/common/share/common/ShareParams;", "currentOnStateAction", "tabPosition", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/IntSize;", "", "pageScrollConsumeY", "progress", "hasRedDot", "showBubble"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeHomePageKt {
    private static final float NAVIGATION_HEIGHT = Dp.constructor-impl(44);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$17(String str, TribeeHomeContentState tribeeHomeContentState, ScrollState scrollState, Function1 function1, Function0 function0, Modifier modifier, Function1 function12, Function1 function13, String str2, String str3, int i, int i2, Composer composer, int i3) {
        TribeeHomeContent(str, tribeeHomeContentState, scrollState, function1, function0, modifier, function12, function13, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$13(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, int i2, Composer composer, int i3) {
        TribeeHomePage(str, str2, str3, str4, str5, str6, str7, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$18(String str, TribeeHomeState tribeeHomeState, ScrollState scrollState, Function1 function1, Function0 function0, Modifier modifier, Function1 function12, Function1 function13, String str2, String str3, int i, int i2, Composer composer, int i3) {
        TribeeHomePage(str, tribeeHomeState, scrollState, function1, function0, modifier, function12, function13, str2, str3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final float getNAVIGATION_HEIGHT() {
        return NAVIGATION_HEIGHT;
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0259, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0319, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x042a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeHomePage(String id, String fromSpmid, String tribeeId, String inviteCode, String categoryIdFromRouter, String fakeCardResultKeyFromRouter, String insertFakeCardToastFromRouter, Composer $composer, final int $changed, final int i) {
        String fromSpmid2;
        String tribeeId2;
        String inviteCode2;
        String categoryIdFromRouter2;
        int $dirty;
        String id2;
        Object fakeCardResultKeyFromRouter2;
        Object insertFakeCardToastFromRouter2;
        String fromSpmid3;
        String tribeeId3;
        Object it$iv;
        Object it$iv2;
        Composer $composer2 = $composer.startRestartGroup(-1838183607);
        ComposerKt.sourceInformation($composer2, "C(TribeeHomePage)N(id,fromSpmid,tribeeId,inviteCode,categoryIdFromRouter,fakeCardResultKeyFromRouter,insertFakeCardToastFromRouter)130@6328L24,132@6402L400,143@6834L7,145@6863L31,146@6899L156,154@7122L63,158@7212L48,159@7291L51,161@7380L16,162@7423L21,164@7497L1140,198@8664L103,198@8643L124,204@8797L40,205@8868L42,207@8926L4504,207@8916L4514:TribeeHomePage.kt#iitu82");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(id) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            fromSpmid2 = fromSpmid;
        } else if (($changed & 48) == 0) {
            fromSpmid2 = fromSpmid;
            $dirty2 |= $composer2.changed(fromSpmid2) ? 32 : 16;
        } else {
            fromSpmid2 = fromSpmid;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            tribeeId2 = tribeeId;
        } else if (($changed & 384) == 0) {
            tribeeId2 = tribeeId;
            $dirty2 |= $composer2.changed(tribeeId2) ? 256 : 128;
        } else {
            tribeeId2 = tribeeId;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            inviteCode2 = inviteCode;
        } else if (($changed & 3072) == 0) {
            inviteCode2 = inviteCode;
            $dirty2 |= $composer2.changed(inviteCode2) ? 2048 : 1024;
        } else {
            inviteCode2 = inviteCode;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            categoryIdFromRouter2 = categoryIdFromRouter;
        } else if (($changed & 24576) == 0) {
            categoryIdFromRouter2 = categoryIdFromRouter;
            $dirty2 |= $composer2.changed(categoryIdFromRouter2) ? 16384 : 8192;
        } else {
            categoryIdFromRouter2 = categoryIdFromRouter;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer2.changed(fakeCardResultKeyFromRouter) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer2.changed(insertFakeCardToastFromRouter) ? 1048576 : 524288;
        }
        if ($composer2.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            String id3 = i2 != 0 ? null : id;
            if (i3 != 0) {
                fromSpmid2 = null;
            }
            if (i4 != 0) {
                tribeeId2 = null;
            }
            if (i5 != 0) {
                inviteCode2 = null;
            }
            if (i6 != 0) {
                categoryIdFromRouter2 = null;
            }
            Object fakeCardResultKeyFromRouter3 = i7 != 0 ? null : fakeCardResultKeyFromRouter;
            Object insertFakeCardToastFromRouter3 = i8 != 0 ? null : insertFakeCardToastFromRouter;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1838183607, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeHomePage (TribeeHomePage.kt:125)");
            }
            Ref.ObjectRef homeId = new Ref.ObjectRef();
            homeId.element = id3 != null ? StringsKt.toLongOrNull(id3) : null;
            if (homeId.element == null) {
                homeId.element = (tribeeId2 == null || (r9 = StringsKt.toLongOrNull(tribeeId2)) == null) ? 0L : 0L;
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            id2 = id3;
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            $dirty = $dirty2;
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1262865703, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                tribeeId3 = tribeeId2;
                Object value$iv = ((TribeeHomeEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeeHomeEntryPoint.class))).getTribeeHomeComponentFactory().build(scope, ((Number) homeId.element).longValue(), inviteCode2, categoryIdFromRouter2).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv3 = value$iv;
            } else {
                tribeeId3 = tribeeId2;
            }
            TribeeHomeViewModel viewModel = (TribeeHomeViewModel) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume;
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(TribeeExtensionsKt.PAGE_PV, $composer2, 6);
            EffectsKt.LaunchedEffect(Unit.INSTANCE, new TribeeHomePageKt$TribeeHomePage$1(pvTrigger, homeId, fromSpmid2, null), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -1262843000, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(viewModel);
            Object value$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv2 = (KFunction) new TribeeHomePageKt$TribeeHomePage$onStateAction$1$1(viewModel);
            $composer2.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Function1 onStateAction = (KFunction) value$iv2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1262840135, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv4 = value$iv3;
            }
            final MutableState toasterDialog$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1262837604, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv5 = value$iv4;
            }
            final MutableState revisitGuideDialog$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State pageState = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer2, 0, 1);
            final ScrollState pageScrollState = ScrollKt.rememberScrollState(0, $composer2, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer2, -1262829923, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(toaster) | $composer2.changedInstance(scope) | $composer2.changed(pageScrollState) | $composer2.changed(pageState);
            String inviteCode3 = inviteCode2;
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv5 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit TribeeHomePage$lambda$8$0;
                    TribeeHomePage$lambda$8$0 = TribeeHomePageKt.TribeeHomePage$lambda$8$0(scope, toaster, pageScrollState, pageState, toasterDialog$delegate, revisitGuideDialog$delegate, (TribeeHomeUIAction) obj);
                    return TribeeHomePage$lambda$8$0;
                }
            };
            $composer2.updateRememberedValue(value$iv5);
            it$iv6 = value$iv5;
            final Function1 onUIAction = (Function1) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1262793616, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(viewModel) | $composer2.changed(onUIAction);
            TribeeHomePageKt$TribeeHomePage$2$1 value$iv6 = $composer2.rememberedValue();
            if (!invalid$iv3 && value$iv6 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv6, $composer2, 6);
                final Ref.ObjectRef fakeCardResultKey = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart($composer2, -1262789423, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv7 = fakeCardResultKeyFromRouter3;
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                fakeCardResultKey.element = (String) it$iv;
                final Ref.ObjectRef insertFakeCardToast = new Ref.ObjectRef();
                ComposerKt.sourceInformationMarkerStart($composer2, -1262787149, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv2 = $composer2.rememberedValue();
                fakeCardResultKeyFromRouter2 = fakeCardResultKeyFromRouter3;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = insertFakeCardToastFromRouter3;
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv2 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                insertFakeCardToast.element = (String) it$iv2;
                final String str = fromSpmid2;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-288076143, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit TribeeHomePage$lambda$12;
                        TribeeHomePage$lambda$12 = TribeeHomePageKt.TribeeHomePage$lambda$12(str, pageState, fakeCardResultKey, insertFakeCardToast, pageScrollState, onStateAction, onUIAction, toasterDialog$delegate, revisitGuideDialog$delegate, (Composer) obj, ((Integer) obj2).intValue());
                        return TribeeHomePage$lambda$12;
                    }
                }, $composer2, 54), $composer2, 384, 3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                inviteCode2 = inviteCode3;
                insertFakeCardToastFromRouter2 = insertFakeCardToastFromRouter3;
                fromSpmid3 = fromSpmid2;
            }
            value$iv6 = new TribeeHomePageKt$TribeeHomePage$2$1(viewModel, onUIAction, null);
            $composer2.updateRememberedValue(value$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv6, $composer2, 6);
            final Ref.ObjectRef fakeCardResultKey2 = new Ref.ObjectRef();
            ComposerKt.sourceInformationMarkerStart($composer2, -1262789423, "CC(remember):TribeeHomePage.kt#9igjgp");
            it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            fakeCardResultKey2.element = (String) it$iv;
            final Ref.ObjectRef insertFakeCardToast2 = new Ref.ObjectRef();
            ComposerKt.sourceInformationMarkerStart($composer2, -1262787149, "CC(remember):TribeeHomePage.kt#9igjgp");
            it$iv2 = $composer2.rememberedValue();
            fakeCardResultKeyFromRouter2 = fakeCardResultKeyFromRouter3;
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            insertFakeCardToast2.element = (String) it$iv2;
            final String str2 = fromSpmid2;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-288076143, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeHomePage$lambda$12;
                    TribeeHomePage$lambda$12 = TribeeHomePageKt.TribeeHomePage$lambda$12(str2, pageState, fakeCardResultKey2, insertFakeCardToast2, pageScrollState, onStateAction, onUIAction, toasterDialog$delegate, revisitGuideDialog$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeHomePage$lambda$12;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
            }
            inviteCode2 = inviteCode3;
            insertFakeCardToastFromRouter2 = insertFakeCardToastFromRouter3;
            fromSpmid3 = fromSpmid2;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            id2 = id;
            fakeCardResultKeyFromRouter2 = fakeCardResultKeyFromRouter;
            insertFakeCardToastFromRouter2 = insertFakeCardToastFromRouter;
            fromSpmid3 = fromSpmid2;
            tribeeId3 = tribeeId2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str3 = id2;
            final String str4 = fromSpmid3;
            final String str5 = tribeeId3;
            final String str6 = inviteCode2;
            final String str7 = categoryIdFromRouter2;
            final String str8 = fakeCardResultKeyFromRouter2;
            final String str9 = insertFakeCardToastFromRouter2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeHomePage$lambda$13;
                    TribeeHomePage$lambda$13 = TribeeHomePageKt.TribeeHomePage$lambda$13(str3, str4, str5, str6, str7, str8, str9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeHomePage$lambda$13;
                }
            });
        }
    }

    private static final KToastDialog TribeeHomePage$lambda$3(MutableState<KToastDialog> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KToastDialog) $this$getValue$iv.getValue();
    }

    private static final KFootHoverToast TribeeHomePage$lambda$6(MutableState<KFootHoverToast> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (KFootHoverToast) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$8$0(CoroutineScope $scope, Toaster $toaster, ScrollState $pageScrollState, State $pageState, MutableState $toasterDialog$delegate, MutableState $revisitGuideDialog$delegate, TribeeHomeUIAction uiAction) {
        String it;
        Intrinsics.checkNotNullParameter(uiAction, "uiAction");
        if (uiAction instanceof TribeeHomeUIAction.ToastTips) {
            TribeeToast tribeeToast = ((TribeeHomeUIAction.ToastTips) uiAction).getTribeeToast();
            if (tribeeToast != null && (it = tribeeToast.getContent()) != null) {
                Toaster.CC.showToast$default($toaster, it, null, 2, null);
            }
        } else if (uiAction instanceof TribeeHomeUIAction.ScrollToTop) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeHomePageKt$TribeeHomePage$onUIAction$1$1$2($pageScrollState, $pageState, null), 3, (Object) null);
        } else if (uiAction instanceof TribeeHomeUIAction.ToastDialog) {
            if (TribeeHomePage$lambda$3($toasterDialog$delegate) != null) {
                $toasterDialog$delegate.setValue(null);
            }
            $toasterDialog$delegate.setValue(((TribeeHomeUIAction.ToastDialog) uiAction).getDialog());
        } else if (!(uiAction instanceof TribeeHomeUIAction.ShowRevisitGuide)) {
            throw new NoWhenBranchMatchedException();
        } else {
            TribeePreference.INSTANCE.setShowRevisitGuide(false);
            $revisitGuideDialog$delegate.setValue(((TribeeHomeUIAction.ShowRevisitGuide) uiAction).getGuide());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12(String $fromSpmid, final State $pageState, final Ref.ObjectRef $fakeCardResultKey, final Ref.ObjectRef $insertFakeCardToast, ScrollState $pageScrollState, final Function1 $onStateAction, Function1 $onUIAction, final MutableState $toasterDialog$delegate, final MutableState $revisitGuideDialog$delegate, Composer $composer, int $changed) {
        Composer composer;
        String str;
        final MutableState mutableState;
        ComposerKt.sourceInformation($composer, "C208@8955L28,209@9016L13,210@9085L64,210@9061L88,214@9184L7,222@9464L50,216@9201L577:TribeeHomePage.kt#iitu82");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288076143, $changed, -1, "kntr.app.tribee.consume.page.TribeeHomePage.<anonymous> (TribeeHomePage.kt:208)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -1963261327, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeHomePageKt$TribeeHomePage$3$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Router router = (Router) consume;
            String str2 = $fromSpmid == null ? "" : $fromSpmid;
            TribeeHomeState tribeeHomeState = (TribeeHomeState) $pageState.getValue();
            String str3 = (String) $fakeCardResultKey.element;
            String str4 = (String) $insertFakeCardToast.element;
            ComposerKt.sourceInformationMarkerStart($composer, -1963249213, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda32
                    public final Object invoke(Object obj) {
                        Unit TribeeHomePage$lambda$12$1$0;
                        TribeeHomePage$lambda$12$1$0 = TribeeHomePageKt.TribeeHomePage$lambda$12$1$0($toasterDialog$delegate, (KToastDialog) obj);
                        return TribeeHomePage$lambda$12$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeHomePage(str2, tribeeHomeState, $pageScrollState, (Function1) it$iv2, new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda33
                public final Object invoke() {
                    Unit TribeeHomePage$lambda$12$2;
                    TribeeHomePage$lambda$12$2 = TribeeHomePageKt.TribeeHomePage$lambda$12$2($fakeCardResultKey, $insertFakeCardToast);
                    return TribeeHomePage$lambda$12$2;
                }
            }, null, $onStateAction, $onUIAction, str3, str4, $composer, 3072, 32);
            if (TribeeHomePage$lambda$3($toasterDialog$delegate) != null) {
                composer = $composer;
                composer.startReplaceGroup(-730732996);
                ComposerKt.sourceInformation(composer, "236@9923L1130,263@11094L1992,305@13102L52,234@9829L3325");
                KToastDialog TribeeHomePage$lambda$3 = TribeeHomePage$lambda$3($toasterDialog$delegate);
                Intrinsics.checkNotNull(TribeeHomePage$lambda$3);
                str = "CC(remember):TribeeHomePage.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer, -1963233445, str);
                boolean invalid$iv2 = composer.changedInstance(router) | composer.changed($onStateAction);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    mutableState = $toasterDialog$delegate;
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda34
                        public final Object invoke(Object obj) {
                            Unit TribeeHomePage$lambda$12$3$0;
                            TribeeHomePage$lambda$12$3$0 = TribeeHomePageKt.TribeeHomePage$lambda$12$3$0(Router.this, $onStateAction, mutableState, (KToastDialog.KToastDialogType) obj);
                            return TribeeHomePage$lambda$12$3$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                } else {
                    mutableState = $toasterDialog$delegate;
                }
                Function1 function1 = (Function1) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1963195111, str);
                boolean invalid$iv3 = composer.changed($onStateAction) | composer.changed($pageState) | composer.changedInstance(router);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda35
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TribeeHomePage$lambda$12$4$0;
                            TribeeHomePage$lambda$12$4$0 = TribeeHomePageKt.TribeeHomePage$lambda$12$4$0($onStateAction, $pageState, router, mutableState, (KToastDialog.KToastDialogType) obj, (String) obj2);
                            return TribeeHomePage$lambda$12$4$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                Function2 function2 = (Function2) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1963132795, str);
                Object it$iv5 = $composer.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit TribeeHomePage$lambda$12$5$0;
                            TribeeHomePage$lambda$12$5$0 = TribeeHomePageKt.TribeeHomePage$lambda$12$5$0(mutableState);
                            return TribeeHomePage$lambda$12$5$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeDialogKt.TribeeDialog(TribeeHomePage$lambda$3, function1, function2, (Function0) it$iv5, $composer, 3072, 0);
            } else {
                composer = $composer;
                str = "CC(remember):TribeeHomePage.kt#9igjgp";
                composer.startReplaceGroup(-740574287);
            }
            $composer.endReplaceGroup();
            if (TribeeHomePage$lambda$6($revisitGuideDialog$delegate) != null) {
                composer.startReplaceGroup(-727453041);
                ComposerKt.sourceInformation(composer, "314@13357L57,311@13220L194");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                KFootHoverToast TribeeHomePage$lambda$6 = TribeeHomePage$lambda$6($revisitGuideDialog$delegate);
                Intrinsics.checkNotNull(TribeeHomePage$lambda$6);
                ComposerKt.sourceInformationMarkerStart(composer, -1963124630, str);
                Object it$iv6 = $composer.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit TribeeHomePage$lambda$12$6$0;
                            TribeeHomePage$lambda$12$6$0 = TribeeHomePageKt.TribeeHomePage$lambda$12$6$0($revisitGuideDialog$delegate);
                            return TribeeHomePage$lambda$12$6$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                RevisitGuideBottomSheetKt.RevisitGuideBottomSheet(TribeeHomePage$lambda$6, fillMaxWidth$default, (Function0) it$iv6, $composer, 432, 0);
            } else {
                composer.startReplaceGroup(-740574287);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$1$0(MutableState $toasterDialog$delegate, KToastDialog it) {
        $toasterDialog$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$2(Ref.ObjectRef $fakeCardResultKey, Ref.ObjectRef $insertFakeCardToast) {
        $fakeCardResultKey.element = null;
        $insertFakeCardToast.element = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$3$0(Router $router, Function1 $onStateAction, MutableState $toasterDialog$delegate, KToastDialog.KToastDialogType type) {
        String it;
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.EXIT.INSTANCE)) {
            TrackerKt.reportClickInExitDialog("no");
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.PUBLISH_JOIN.INSTANCE)) {
            TrackerKt.reportClickInJoinDialog("cancel");
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.PUBLISH_ABNORMAL.INSTANCE)) {
            TrackerKt.reportClickInPermissionDialog();
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE)) {
            KToastDialog TribeeHomePage$lambda$3 = TribeeHomePage$lambda$3($toasterDialog$delegate);
            String str = null;
            if (TribeeHomePage$lambda$3 != null && (it = TribeeHomePage$lambda$3.getCancelJumpUri()) != null && !StringsKt.isBlank(it)) {
                str = it;
            }
            String cancelJumpUri = str;
            if (cancelJumpUri != null) {
                Uri p0 = TribeeExtensionsKt.toUriOrNull(cancelJumpUri);
                if (p0 != null) {
                    $router.launch(p0);
                }
            } else {
                $onStateAction.invoke(TribeeHomeStateAction.ToJoinCandidatePool.INSTANCE);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$4$0(Function1 $onStateAction, State $pageState, Router $router, final MutableState $toasterDialog$delegate, KToastDialog.KToastDialogType type, String params) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.EXIT.INSTANCE)) {
            TrackerKt.reportClickInExitDialog("yes");
            $onStateAction.invoke(TribeeHomeStateAction.ToExitTribee.INSTANCE);
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.PUBLISH_JOIN.INSTANCE)) {
            TrackerKt.reportClickInJoinDialog("add");
            $onStateAction.invoke(TribeeHomeStateAction.ToJoinTribee.INSTANCE);
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.ACTIVATE_CANDIDATE.INSTANCE) || Intrinsics.areEqual(type, KToastDialog.KToastDialogType.ACTIVATE_NO_CANDIDATE.INSTANCE)) {
            if (params != null) {
                String it = !StringsKt.isBlank(params) ? params : null;
                if (it != null) {
                    $onStateAction.invoke(new TribeeHomeStateAction.ToJoinTribeeByInviteCode(it));
                }
            }
        } else if (Intrinsics.areEqual(type, KToastDialog.KToastDialogType.GAME_STATS_NO_TRIBEE.INSTANCE)) {
            TrackerKt.reportClickInJoinDialog("add");
            if (((TribeeHomeState) $pageState.getValue()) instanceof TribeeHomeContentState) {
                Object value = $pageState.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kntr.app.tribee.consume.viewmodel.state.TribeeHomeContentState");
                checkTribeeHomePermission(TribeeHomeStateAction.ToJoinTribee.INSTANCE, $router, (TribeeHomeContentState) value, $onStateAction, new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit TribeeHomePage$lambda$12$4$0$2;
                        TribeeHomePage$lambda$12$4$0$2 = TribeeHomePageKt.TribeeHomePage$lambda$12$4$0$2($toasterDialog$delegate, (KToastDialog) obj);
                        return TribeeHomePage$lambda$12$4$0$2;
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$4$0$2(MutableState $toasterDialog$delegate, KToastDialog it) {
        $toasterDialog$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$5$0(MutableState $toasterDialog$delegate) {
        $toasterDialog$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$12$6$0(MutableState $revisitGuideDialog$delegate) {
        $revisitGuideDialog$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$14$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$15$0(TribeeHomeUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x049a, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L113;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeHomePage(final String fromSpmid, final TribeeHomeState pageState, final ScrollState pageScrollState, final Function1<? super KToastDialog, Unit> function1, final Function0<Unit> function0, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function12, Function1<? super TribeeHomeUIAction, Unit> function13, String fakeCardResultKey, String insertFakeCardToast, Composer $composer, final int $changed, final int i) {
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        Function1 onStateAction;
        Function1 onUIAction;
        String fakeCardResultKey2;
        String insertFakeCardToast2;
        final Function1 onStateAction2;
        Composer $composer3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(pageScrollState, "pageScrollState");
        Intrinsics.checkNotNullParameter(function1, "updateToasterDialog");
        Intrinsics.checkNotNullParameter(function0, "hasUsedFakeCardResultKeyHandler");
        Composer $composer4 = $composer.startRestartGroup(2146907704);
        ComposerKt.sourceInformation($composer4, "C(TribeeHomePage)N(fromSpmid,pageState,pageScrollState,updateToasterDialog,hasUsedFakeCardResultKeyHandler,modifier,onStateAction,onUIAction,fakeCardResultKey,insertFakeCardToast)329@13742L2,330@13793L2:TribeeHomePage.kt#iitu82");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(fromSpmid) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(pageState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(pageScrollState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
        } else if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changed(modifier) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty2 |= 1572864;
        } else if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function12) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer4.changedInstance(function13) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer4.changed(fakeCardResultKey) ? 67108864 : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer4.changed(insertFakeCardToast) ? 536870912 : 268435456;
        }
        if ($composer4.shouldExecute(($dirty2 & 306783379) != 306783378, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 1594010938, "CC(remember):TribeeHomePage.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit TribeeHomePage$lambda$14$0;
                            TribeeHomePage$lambda$14$0 = TribeeHomePageKt.TribeeHomePage$lambda$14$0((TribeeHomeStateAction) obj);
                            return TribeeHomePage$lambda$14$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onStateAction2 = onStateAction3;
            } else {
                onStateAction2 = function12;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer4, 1594012570, "CC(remember):TribeeHomePage.kt#9igjgp");
                Object it$iv2 = $composer4.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit TribeeHomePage$lambda$15$0;
                            TribeeHomePage$lambda$15$0 = TribeeHomePageKt.TribeeHomePage$lambda$15$0((TribeeHomeUIAction) obj);
                            return TribeeHomePage$lambda$15$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onUIAction2 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onUIAction = onUIAction2;
            } else {
                onUIAction = function13;
            }
            fakeCardResultKey2 = i5 != 0 ? null : fakeCardResultKey;
            insertFakeCardToast2 = i6 != 0 ? null : insertFakeCardToast;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2146907704, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeHomePage (TribeeHomePage.kt:333)");
            }
            if (pageState instanceof TribeeHomeInitialState) {
                $composer4.startReplaceGroup(-2125059284);
                ComposerKt.sourceInformation($composer4, "340@14109L6,336@13955L358");
                Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer4.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeHomePage_u24lambda_u2416 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, -522569235, "C343@14203L21,344@14241L58:TribeeHomePage.kt#iitu82");
                TribeeDetailComposeKt.SimpleNavigationRow(null, $composer4, 0, 1);
                TribeePageStatusComposeKt.TribeeLoading($this$TribeeHomePage_u24lambda_u2416.align(Modifier.Companion, Alignment.Companion.getCenter()), $composer4, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endReplaceGroup();
                $dirty = $dirty2;
                modifier2 = modifier3;
                $composer3 = $composer4;
                onStateAction = onStateAction2;
            } else if (pageState instanceof TribeeHomeErrorState) {
                $composer4.startReplaceGroup(-2124641063);
                ComposerKt.sourceInformation($composer4, "353@14528L6,349@14374L441");
                Modifier modifier$iv2 = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                Modifier modifier4 = modifier3;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i10 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeHomePage_u24lambda_u2417 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer4, 1505603953, "C356@14622L21,357@14717L84,357@14660L141:TribeeHomePage.kt#iitu82");
                TribeeDetailComposeKt.SimpleNavigationRow(null, $composer4, 0, 1);
                Modifier align = $this$TribeeHomePage_u24lambda_u2417.align(Modifier.Companion, Alignment.Companion.getCenter());
                ComposerKt.sourceInformationMarkerStart($composer4, 741307475, "CC(remember):TribeeHomePage.kt#9igjgp");
                boolean invalid$iv = (3670016 & $dirty2) == 1048576;
                Object it$iv3 = $composer4.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        Unit TribeeHomePage$lambda$17$0$0;
                        TribeeHomePage$lambda$17$0$0 = TribeeHomePageKt.TribeeHomePage$lambda$17$0$0(onStateAction2);
                        return TribeeHomePage$lambda$17$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                TribeePageStatusComposeKt.TribeeError(align, false, (Function0) it$iv3, $composer4, 0, 2);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endReplaceGroup();
                $dirty = $dirty2;
                $composer3 = $composer4;
                onStateAction = onStateAction2;
                modifier2 = modifier4;
            } else {
                Modifier modifier5 = modifier3;
                if (!(pageState instanceof TribeeHomeContentState)) {
                    $composer4.startReplaceGroup(1594017026);
                    $composer4.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer4.startReplaceGroup(-2124125967);
                ComposerKt.sourceInformation($composer4, "364@14878L505");
                $dirty = $dirty2;
                modifier2 = modifier5;
                $composer3 = $composer4;
                onStateAction = onStateAction2;
                TribeeHomeContent(fromSpmid, (TribeeHomeContentState) pageState, pageScrollState, function1, function0, null, onStateAction2, onUIAction, fakeCardResultKey2, insertFakeCardToast2, $composer3, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | ($dirty2 & 7168) | (57344 & $dirty2) | (3670016 & $dirty2) | (29360128 & $dirty2) | (234881024 & $dirty2) | (1879048192 & $dirty2), 32);
                $composer3.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer2 = $composer3;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStateAction = function12;
            onUIAction = function13;
            fakeCardResultKey2 = fakeCardResultKey;
            insertFakeCardToast2 = insertFakeCardToast;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final Function1 function14 = onStateAction;
            final Function1 function15 = onUIAction;
            final String str = fakeCardResultKey2;
            final String str2 = insertFakeCardToast2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeHomePage$lambda$18;
                    TribeeHomePage$lambda$18 = TribeeHomePageKt.TribeeHomePage$lambda$18(fromSpmid, pageState, pageScrollState, function1, function0, modifier6, function14, function15, str, str2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeHomePage$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomePage$lambda$17$0$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeHomeStateAction.Initial.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$0$0(TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$1$0(TribeeHomeUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:136:0x022f, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x0515, code lost:
        if (r9 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L121;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04a7 A[LOOP:0: B:184:0x0465->B:207:0x04a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeHomeContent(final String fromSpmid, final TribeeHomeContentState pageState, final ScrollState pageScrollState, final Function1<? super KToastDialog, Unit> function1, final Function0<Unit> function0, Modifier modifier, Function1<? super TribeeHomeStateAction, Unit> function12, Function1<? super TribeeHomeUIAction, Unit> function13, String fakeCardResultKey, String insertFakeCardToast, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function1 onStateAction;
        final Function1 onUIAction;
        String fakeCardResultKey2;
        String insertFakeCardToast2;
        final Function1 onStateAction2;
        Function1 onUIAction2;
        String str;
        Color color;
        final long tribeeColor;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int $dirty;
        KTribeeDesc tribeeInfo;
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(pageScrollState, "pageScrollState");
        Intrinsics.checkNotNullParameter(function1, "updateToasterDialog");
        Intrinsics.checkNotNullParameter(function0, "hasUsedFakeCardResultKeyHandler");
        Composer $composer3 = $composer.startRestartGroup(1584739353);
        ComposerKt.sourceInformation($composer3, "C(TribeeHomeContent)N(fromSpmid,pageState,pageScrollState,updateToasterDialog,hasUsedFakeCardResultKeyHandler,modifier,onStateAction,onUIAction,fakeCardResultKey,insertFakeCardToast)388@15761L2,389@15812L2,394@15959L53,395@16044L35,397@16116L32,398@16174L599,398@16153L620,416@16806L7,417@16843L7,418@16867L24,428@17212L10,428@17223L17,431@17360L34,432@17418L59,435@17510L35,436@17569L28,438@17629L297,449@18069L6,454@18265L86,457@18359L13190,445@17932L13617:TribeeHomePage.kt#iitu82");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(fromSpmid) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(pageState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(pageScrollState) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 16384 : 8192;
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
        } else if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function13) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty2 |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty2 |= $composer3.changed(fakeCardResultKey) ? 67108864 : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty2 |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty2 |= $composer3.changed(insertFakeCardToast) ? 536870912 : 268435456;
        }
        if ($composer3.shouldExecute(($dirty2 & 306783379) != 306783378, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1778862053, "CC(remember):TribeeHomePage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit TribeeHomeContent$lambda$0$0;
                            TribeeHomeContent$lambda$0$0 = TribeeHomePageKt.TribeeHomeContent$lambda$0$0((TribeeHomeStateAction) obj);
                            return TribeeHomeContent$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction2 = it$iv;
            } else {
                onStateAction2 = function12;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1778860421, "CC(remember):TribeeHomePage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda21
                        public final Object invoke(Object obj) {
                            Unit TribeeHomeContent$lambda$1$0;
                            TribeeHomeContent$lambda$1$0 = TribeeHomePageKt.TribeeHomeContent$lambda$1$0((TribeeHomeUIAction) obj);
                            return TribeeHomeContent$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUIAction2 = (Function1) it$iv2;
            } else {
                onUIAction2 = function13;
            }
            fakeCardResultKey2 = i5 != 0 ? null : fakeCardResultKey;
            insertFakeCardToast2 = i6 != 0 ? null : insertFakeCardToast;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1584739353, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeHomeContent (TribeeHomePage.kt:392)");
            }
            State latestOnHasUsedFakeCardResultKeyHandler$delegate = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty2 >> 12) & 14);
            State latestOnStateAction$delegate = SnapshotStateKt.rememberUpdatedState(onStateAction2, $composer3, ($dirty2 >> 18) & 14);
            State latestOnUIAction$delegate = SnapshotStateKt.rememberUpdatedState(onUIAction2, $composer3, ($dirty2 >> 21) & 14);
            Unit unit = Unit.INSTANCE;
            Function1 onUIAction3 = onUIAction2;
            ComposerKt.sourceInformationMarkerStart($composer3, -1778848240, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv = ((234881024 & $dirty2) == 67108864) | $composer3.changed(latestOnStateAction$delegate) | ((1879048192 & $dirty2) == 536870912) | $composer3.changed(latestOnUIAction$delegate) | $composer3.changed(latestOnHasUsedFakeCardResultKeyHandler$delegate);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = (Function2) new TribeeHomePageKt$TribeeHomeContent$3$1(fakeCardResultKey2, insertFakeCardToast2, latestOnStateAction$delegate, latestOnUIAction$delegate, latestOnHasUsedFakeCardResultKeyHandler$delegate, null);
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer3, 6);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume;
            CompositionLocal this_$iv2 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            KTribeeBaseInfo baseInfo = pageState.getBaseInfo();
            KColor bgColor = (baseInfo == null || (tribeeInfo = baseInfo.getTribeeInfo()) == null) ? null : tribeeInfo.getBgColor();
            if (bgColor == null) {
                $composer3.startReplaceGroup(691096228);
                $composer3.endReplaceGroup();
                str = null;
            } else {
                $composer3.startReplaceGroup(-1778821891);
                ComposerKt.sourceInformation($composer3, "424@17043L7");
                CompositionLocal this_$iv3 = BiliThemeKt.getLocalDayNightTheme();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume3 = $composer3.consume(this_$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                String color2 = TribeeExtensionsKt.getColor(bgColor, (ThemeDayNight) consume3);
                $composer3.endReplaceGroup();
                str = color2;
            }
            if (str != null) {
                color = Color.box-impl(ComposeColorParserKt.parseColor(str));
                long it = color.unbox-impl();
                if (Color.equals-impl0(it, Color.Companion.getTransparent-0d7_KjU())) {
                    color = null;
                }
            } else {
                color = null;
            }
            if (color == null) {
                $composer3.startReplaceGroup(-1778817156);
                ComposerKt.sourceInformation($composer3, "427@17157L6");
                tribeeColor = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg3-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-1778824658);
                $composer3.endReplaceGroup();
                tribeeColor = color.unbox-impl();
            }
            final float statusBarsTopPadding = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer3, 6), $composer3, 0).calculateTopPadding-D9Ej5fM();
            final KTribeeNavigation mine = pageState.getNavigation();
            final KTribeeBaseInfo basicInfo = pageState.getBaseInfo();
            ComposerKt.sourceInformationMarkerStart($composer3, -1778810853, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final MutableState showDrawer$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1778808972, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final MutableState shareParams$delegate = (MutableState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final State currentOnStateAction$delegate = SnapshotStateKt.rememberUpdatedState(onStateAction2, $composer3, ($dirty2 >> 18) & 14);
            final PullToRefreshState refreshState = PullToRefreshKt.rememberPullToRefreshState($composer3, 0);
            Set<TribeeHomeStateAction> observedRequestingActions = pageState.getObservedRequestingActions();
            ComposerKt.sourceInformationMarkerStart($composer3, -1778801982, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changed(observedRequestingActions);
            boolean z5 = false;
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv6 == Composer.Companion.getEmpty()) {
                Iterable $this$any$iv = pageState.getObservedRequestingActions();
                boolean invalid$iv3 = $this$any$iv instanceof Collection;
                if (!invalid$iv3 || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it2 = $this$any$iv.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        Object element$iv = it2.next();
                        Iterable $this$any$iv2 = $this$any$iv;
                        TribeeHomeStateAction action = (TribeeHomeStateAction) element$iv;
                        Iterator it3 = it2;
                        TribeeHomeStateAction.Refresh refresh = action instanceof TribeeHomeStateAction.Refresh ? (TribeeHomeStateAction.Refresh) action : null;
                        if (refresh != null) {
                            z2 = z5;
                            if (refresh.getShowIndicator()) {
                                z3 = true;
                                if (!z3) {
                                    if ((action instanceof TribeeHomeStateAction.FetchCategory ? (TribeeHomeStateAction.FetchCategory) action : null) == null) {
                                        z4 = false;
                                        if (z4) {
                                            z = true;
                                            break;
                                        }
                                        $this$any$iv = $this$any$iv2;
                                        it2 = it3;
                                        z5 = z2;
                                    }
                                }
                                z4 = true;
                                if (z4) {
                                }
                            }
                        } else {
                            z2 = z5;
                        }
                        z3 = false;
                        if (!z3) {
                        }
                        z4 = true;
                        if (z4) {
                        }
                    }
                } else {
                    z = false;
                }
                Object value$iv6 = Boolean.valueOf(z);
                $composer3.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            final boolean isRefreshing = ((Boolean) it$iv6).booleanValue();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier4 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            boolean z6 = !TribeeHomeContent$lambda$8(showDrawer$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, -1778781841, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv4 = (3670016 & $dirty2) == 1048576;
            Object it$iv7 = $composer3.rememberedValue();
            if (invalid$iv4) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv7 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda29
                public final Object invoke() {
                    Unit TribeeHomeContent$lambda$15$0;
                    TribeeHomeContent$lambda$15$0 = TribeeHomePageKt.TribeeHomeContent$lambda$15$0(onStateAction2);
                    return TribeeHomeContent$lambda$15$0;
                }
            };
            $composer3.updateRememberedValue(value$iv7);
            it$iv7 = value$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier5 = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(modifier4, isRefreshing, refreshState, z6, 0.0f, (Function0) it$iv7, 8, (Object) null);
            modifier2 = modifier3;
            onUIAction = onUIAction3;
            final Function1 function14 = onStateAction2;
            onStateAction = onStateAction2;
            $composer2 = $composer3;
            BoxWithConstraintsKt.BoxWithConstraints(modifier5, (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-284000785, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeHomeContent$lambda$16;
                    TribeeHomeContent$lambda$16 = TribeeHomePageKt.TribeeHomeContent$lambda$16(pageScrollState, density, mine, basicInfo, tribeeColor, router, pageState, function14, function1, onUIAction, isRefreshing, refreshState, fromSpmid, statusBarsTopPadding, currentOnStateAction$delegate, scope, showDrawer$delegate, shareParams$delegate, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeHomeContent$lambda$16;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onStateAction = function12;
            onUIAction = function13;
            fakeCardResultKey2 = fakeCardResultKey;
            insertFakeCardToast2 = insertFakeCardToast;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final Function1 function15 = onStateAction;
            final Function1 function16 = onUIAction;
            final String str2 = fakeCardResultKey2;
            final String str3 = insertFakeCardToast2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda31
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeHomeContent$lambda$17;
                    TribeeHomeContent$lambda$17 = TribeeHomePageKt.TribeeHomeContent$lambda$17(fromSpmid, pageState, pageScrollState, function1, function0, modifier6, function15, function16, str2, str3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeHomeContent$lambda$17;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> TribeeHomeContent$lambda$2(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<TribeeHomeStateAction, Unit> TribeeHomeContent$lambda$3(State<? extends Function1<? super TribeeHomeStateAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<TribeeHomeUIAction, Unit> TribeeHomeContent$lambda$4(State<? extends Function1<? super TribeeHomeUIAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    private static final boolean TribeeHomeContent$lambda$8(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeHomeContent$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final ShareParams TribeeHomeContent$lambda$11(MutableState<ShareParams> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (ShareParams) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<TribeeHomeStateAction, Unit> TribeeHomeContent$lambda$13(State<? extends Function1<? super TribeeHomeStateAction, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function1) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$15$0(Function1 $onStateAction) {
        $onStateAction.invoke(new TribeeHomeStateAction.Refresh(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0727, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0797, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x09e3, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0b0c, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L210;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x027a, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x054c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x05a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0753  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x08b2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0920  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0928  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x093c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0949  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0952  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0958  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0993  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x09db  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x09e7  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0a32  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0a84  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0a8d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0a99  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0b39  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0be9  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0bff  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0c51  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0c73  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0c81  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0c8c  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0d08  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0d2f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0534 A[EDGE_INSN: B:323:0x0534->B:106:0x0534 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x050e  */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeHomeContent$lambda$16(final ScrollState $pageScrollState, Density $density, KTribeeNavigation $mine, final KTribeeBaseInfo $basicInfo, final long $tribeeColor, final Router $router, final TribeeHomeContentState $pageState, final Function1 $onStateAction, final Function1 $updateToasterDialog, Function1 $onUIAction, boolean $isRefreshing, PullToRefreshState $refreshState, final String $fromSpmid, float $statusBarsTopPadding, State $currentOnStateAction$delegate, final CoroutineScope $scope, final MutableState $showDrawer$delegate, MutableState $shareParams$delegate, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        int $dirty;
        float f;
        MutableState listHeight;
        boolean invalid$iv;
        Pair $this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240;
        MutableState listHeight2;
        MutableState tabPosition$delegate;
        float f2;
        Object it$iv;
        Object it$iv2;
        boolean invalid$iv2;
        boolean invalid$iv3;
        String str;
        Object it$iv3;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        String str2;
        KTribeeBaseInfo kTribeeBaseInfo;
        int index$iv;
        Iterator<T> it;
        boolean invalid$iv4;
        Object it$iv4;
        boolean invalid$iv5;
        Composer $composer$iv$iv;
        Continuation continuation;
        boolean invalid$iv6;
        Object it$iv5;
        final MutableState tabPosition$delegate2;
        boolean invalid$iv7;
        MutableState tabPosition$delegate3;
        KNavigationEntry kNavigationEntry;
        KNavigationEntry entry;
        boolean invalid$iv8;
        Object it$iv6;
        KNavigationEntry.KGameStats kGameStats;
        boolean z;
        boolean z2;
        boolean z3;
        KNavigationEntryGameStats value;
        boolean invalid$iv9;
        Object it$iv7;
        boolean invalid$iv10;
        KPublishButton it2;
        Composer composer;
        final MutableState mutableState;
        TribeeHomeContentState tribeeHomeContentState;
        Function1 function1;
        String str3;
        float f3;
        ?? r6;
        float f4;
        String str4;
        final Function1 function12;
        TribeeHomeContentState tribeeHomeContentState2;
        boolean invalid$iv11;
        Object it$iv8;
        Continuation continuation2;
        boolean invalid$iv12;
        Object it$iv9;
        Iterable navEntries;
        Object obj;
        Continuation continuation3;
        KTribeeDesc tribeeInfo;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C458@18388L56,460@18482L305,469@18825L377,479@19237L36,480@19298L36,481@19378L154,481@19343L189,487@19579L335,487@19541L373,505@20182L1723,498@19924L6186,647@26279L441,664@26851L163,673@27114L303,661@26730L735,685@27475L454,760@30208L139,766@30467L461,763@30356L572,781@30975L568,781@30938L605:TribeeHomePage.kt#iitu82");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-284000785, $dirty2, -1, "kntr.app.tribee.consume.page.TribeeHomeContent.<anonymous> (TribeeHomePage.kt:458)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1953153543, "CC(remember):TribeeHomePage.kt#9igjgp");
            Object it$iv10 = $composer.rememberedValue();
            if (it$iv10 == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(mutableStateOf$default);
                it$iv10 = mutableStateOf$default;
            }
            MutableState tabPosition$delegate4 = (MutableState) it$iv10;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Pair<IntSize, Float> TribeeHomeContent$lambda$16$1 = TribeeHomeContent$lambda$16$1(tabPosition$delegate4);
            ComposerKt.sourceInformationMarkerStart($composer, 1953156800, "CC(remember):TribeeHomePage.kt#9igjgp");
            boolean invalid$iv13 = $composer.changed(TribeeHomeContent$lambda$16$1);
            Object it$iv11 = $composer.rememberedValue();
            if (!invalid$iv13 && it$iv11 != Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                listHeight = (MutableState) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953167848, "CC(remember):TribeeHomePage.kt#9igjgp");
                invalid$iv = $composer.changed(listHeight);
                Object it$iv12 = $composer.rememberedValue();
                if (!invalid$iv && it$iv12 != Composer.Companion.getEmpty()) {
                    listHeight2 = listHeight;
                    tabPosition$delegate = tabPosition$delegate4;
                    MutableState pageHeight = (MutableState) it$iv12;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953180691, "CC(remember):TribeeHomePage.kt#9igjgp");
                    it$iv = $composer.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    final MutableFloatState pageScrollConsumeY$delegate = (MutableFloatState) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953182643, "CC(remember):TribeeHomePage.kt#9igjgp");
                    it$iv2 = $composer.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    MutableFloatState progress$delegate = (MutableFloatState) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Float valueOf = Float.valueOf(TribeeHomeContent$lambda$16$6(pageScrollConsumeY$delegate));
                    ComposerKt.sourceInformationMarkerStart($composer, 1953185321, "CC(remember):TribeeHomePage.kt#9igjgp");
                    invalid$iv2 = $composer.changed($pageScrollState);
                    Object it$iv13 = $composer.rememberedValue();
                    if (invalid$iv2) {
                    }
                    Object value$iv3 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$1$1(pageScrollConsumeY$delegate, $pageScrollState, null);
                    $composer.updateRememberedValue(value$iv3);
                    it$iv13 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv13, $composer, 0);
                    Integer valueOf2 = Integer.valueOf($pageScrollState.getValue());
                    ComposerKt.sourceInformationMarkerStart($composer, 1953191934, "CC(remember):TribeeHomePage.kt#9igjgp");
                    invalid$iv3 = $composer.changed($pageScrollState) | $composer.changed($density);
                    Object it$iv14 = $composer.rememberedValue();
                    if (!invalid$iv3 && it$iv14 != Composer.Companion.getEmpty()) {
                        str = "CC(remember):TribeeHomePage.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv14, $composer, 0);
                        int $dirty3 = $dirty;
                        String str5 = str;
                        MutableState listHeight3 = listHeight2;
                        MutableState tabPosition$delegate5 = tabPosition$delegate;
                        int i = -1;
                        Modifier verticalScroll$default = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str5);
                        it$iv3 = $composer.rememberedValue();
                        if (it$iv3 != Composer.Companion.getEmpty()) {
                            Object value$iv4 = new NestedScrollConnection() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$TribeeHomeContent$5$3$1
                                /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
                                public /* bridge */ Object m724onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation4) {
                                    return NestedScrollConnection.-CC.$default$onPostFling-RZ2iAVY(this, j, j2, continuation4);
                                }

                                /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
                                public /* bridge */ long m725onPostScrollDzOQY0M(long j, long j2, int i2) {
                                    return NestedScrollConnection.-CC.$default$onPostScroll-DzOQY0M(this, j, j2, i2);
                                }

                                /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
                                public /* bridge */ Object m726onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation4) {
                                    return NestedScrollConnection.-CC.$default$onPreFling-QWom1Mo(this, j, continuation4);
                                }

                                /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
                                public long m727onPreScrollOzD1aCk(long j, int i2) {
                                    int bits$iv$iv$iv = (int) (j & 4294967295L);
                                    float consumeY = 0.0f;
                                    if (Float.intBitsToFloat(bits$iv$iv$iv) < 0.0f) {
                                        int space = RangesKt.coerceAtMost($pageScrollState.getValue() - $pageScrollState.getMaxValue(), 0);
                                        int bits$iv$iv$iv2 = (int) (j & 4294967295L);
                                        float delta = Math.min(-Float.intBitsToFloat(bits$iv$iv$iv2), -space);
                                        consumeY = -delta;
                                    } else {
                                        int bits$iv$iv$iv3 = (int) (j & 4294967295L);
                                        if (Float.intBitsToFloat(bits$iv$iv$iv3) > 0.0f) {
                                            int space2 = $pageScrollState.getValue();
                                            int bits$iv$iv$iv4 = (int) (j & 4294967295L);
                                            float delta2 = Math.min(Float.intBitsToFloat(bits$iv$iv$iv4), space2);
                                            consumeY = delta2;
                                        }
                                    }
                                    pageScrollConsumeY$delegate.setFloatValue(consumeY);
                                    float y$iv = consumeY;
                                    long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                                    return Offset.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
                                }
                            };
                            $composer.updateRememberedValue(value$iv4);
                            it$iv3 = value$iv4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Modifier modifier$iv = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
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
                        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i3 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
                        if ($basicInfo == null) {
                            $composer.startReplaceGroup(895202174);
                            ComposerKt.sourceInformation($composer, "546@22248L367,540@21995L639");
                            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer, -1495135340, str5);
                            boolean invalid$iv14 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                            Object value$iv5 = $composer.rememberedValue();
                            if (invalid$iv14 || value$iv5 == Composer.Companion.getEmpty()) {
                                value$iv5 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda19
                                    public final Object invoke(Object obj2) {
                                        Unit TribeeHomeContent$lambda$16$14$0$0;
                                        TribeeHomeContent$lambda$16$14$0$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$0$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                        return TribeeHomeContent$lambda$16$14$0$0;
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            }
                            Function1 function13 = (Function1) value$iv5;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer2 = $composer;
                            str2 = str5;
                            kTribeeBaseInfo = $basicInfo;
                            TribeeDetailComposeKt.m697TribeeHomeHeadereuL9pac($tribeeColor, $basicInfo, fillMaxWidth$default, function13, $composer2, 384, 0);
                        } else {
                            $composer2 = $composer;
                            str2 = str5;
                            kTribeeBaseInfo = $basicInfo;
                            $composer2.startReplaceGroup(873362333);
                        }
                        $composer2.endReplaceGroup();
                        Iterable $this$indexOfFirst$iv = $pageState.getCategoryList().keySet();
                        index$iv = 0;
                        it = $this$indexOfFirst$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                break;
                            }
                            Object item$iv = it.next();
                            if (index$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            if (((KTribeeCategory) item$iv).getId() == $pageState.getCategoryId()) {
                                i = index$iv;
                                break;
                            }
                            index$iv++;
                        }
                        int selectedTabIndex = i;
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
                        invalid$iv4 = $composer2.changed($pageState);
                        Composer $this$cache$iv = $composer2;
                        it$iv4 = $this$cache$iv.rememberedValue();
                        if (!invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv6 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                                public final Object invoke() {
                                    int TribeeHomeContent$lambda$16$14$2$0;
                                    TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                                    return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                                }
                            };
                            $this$cache$iv.updateRememberedValue(value$iv6);
                            it$iv4 = value$iv6;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        final PagerState pagerState = PagerStateKt.rememberPagerState(selectedTabIndex, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
                        Integer valueOf3 = Integer.valueOf(selectedTabIndex);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
                        invalid$iv5 = $composer2.changed(pagerState) | $composer2.changed(selectedTabIndex);
                        Composer $this$cache$iv2 = $composer2;
                        Object it$iv15 = $this$cache$iv2.rememberedValue();
                        if (!invalid$iv5 && it$iv15 != Composer.Companion.getEmpty()) {
                            $composer$iv$iv = $composer;
                            continuation = null;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv15, $composer2, 0);
                            ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                            invalid$iv6 = $composer2.changed(pagerState) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                            Composer $this$cache$iv3 = $composer2;
                            it$iv5 = $this$cache$iv3.rememberedValue();
                            if (!invalid$iv6 || it$iv5 == Composer.Companion.getEmpty()) {
                                Object value$iv7 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState, $pageState, $currentOnStateAction$delegate, continuation);
                                $this$cache$iv3.updateRememberedValue(value$iv7);
                                it$iv5 = value$iv7;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(pagerState, (Function2) it$iv5, $composer2, 0);
                            if ($pageState.getCategoryList().size() <= 1) {
                                $composer2.startReplaceGroup(896775207);
                                ComposerKt.sourceInformation($composer2, "591@24037L93,594@24193L6,596@24338L112,601@24598L140,579@23564L1174");
                                if (kTribeeBaseInfo == null || (tribeeInfo = $basicInfo.getTribeeInfo()) == null) {
                                    continuation3 = continuation;
                                } else {
                                    continuation3 = String.valueOf(tribeeInfo.getId());
                                }
                                String str6 = continuation3 == null ? "" : continuation3;
                                Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, continuation), Dp.constructor-impl(42));
                                ComposerKt.sourceInformationMarkerStart($composer2, -1495078366, str2);
                                boolean invalid$iv15 = $composer2.changed($tribeeColor);
                                Composer $this$cache$iv4 = $composer2;
                                Object it$iv16 = $this$cache$iv4.rememberedValue();
                                if (invalid$iv15 || it$iv16 == Composer.Companion.getEmpty()) {
                                    Object value$iv8 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda22
                                        public final Object invoke(Object obj2) {
                                            Unit TribeeHomeContent$lambda$16$14$5$0;
                                            TribeeHomeContent$lambda$16$14$5$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$5$0($tribeeColor, (DrawScope) obj2);
                                            return TribeeHomeContent$lambda$16$14$5$0;
                                        }
                                    };
                                    $this$cache$iv4.updateRememberedValue(value$iv8);
                                    it$iv16 = value$iv8;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                Modifier modifier2 = BackgroundKt.background-bw27NRU(DrawModifierKt.drawBehind(modifier, (Function1) it$iv16), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
                                ComposerKt.sourceInformationMarkerStart($composer2, -1495068715, str2);
                                Composer $this$cache$iv5 = $composer2;
                                Object it$iv17 = $this$cache$iv5.rememberedValue();
                                if (it$iv17 == Composer.Companion.getEmpty()) {
                                    tabPosition$delegate2 = tabPosition$delegate5;
                                    Object value$iv9 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda23
                                        public final Object invoke(Object obj2) {
                                            Unit TribeeHomeContent$lambda$16$14$6$0;
                                            TribeeHomeContent$lambda$16$14$6$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$6$0(tabPosition$delegate2, (LayoutCoordinates) obj2);
                                            return TribeeHomeContent$lambda$16$14$6$0;
                                        }
                                    };
                                    $this$cache$iv5.updateRememberedValue(value$iv9);
                                    it$iv17 = value$iv9;
                                } else {
                                    tabPosition$delegate2 = tabPosition$delegate5;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                Modifier onPlaced = OnPlacedModifierKt.onPlaced(modifier2, (Function1) it$iv17);
                                List list = CollectionsKt.toList($pageState.getCategoryList().keySet());
                                int settledPage = pagerState.getSettledPage();
                                ComposerKt.sourceInformationMarkerStart($composer2, -1495060367, str2);
                                boolean invalid$iv16 = $composer2.changedInstance($scope) | $composer2.changed(pagerState);
                                Composer $this$cache$iv6 = $composer2;
                                Object it$iv18 = $this$cache$iv6.rememberedValue();
                                if (invalid$iv16) {
                                }
                                Object value$iv10 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda24
                                    public final Object invoke(Object obj2) {
                                        Unit TribeeHomeContent$lambda$16$14$7$0;
                                        TribeeHomeContent$lambda$16$14$7$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$7$0($scope, pagerState, ((Integer) obj2).intValue());
                                        return TribeeHomeContent$lambda$16$14$7$0;
                                    }
                                };
                                $this$cache$iv6.updateRememberedValue(value$iv10);
                                it$iv18 = value$iv10;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                TribeeTabLayoutKt.TribeeTabLayout(str6, pagerState, settledPage, list, onPlaced, (Function1) it$iv18, $composer2, 0, 0);
                                $composer2.endReplaceGroup();
                            } else {
                                tabPosition$delegate2 = tabPosition$delegate5;
                                $composer2.startReplaceGroup(897943814);
                                ComposerKt.sourceInformation($composer2, "612@24975L93,615@25131L6,617@25276L112,607@24776L631");
                                Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12));
                                ComposerKt.sourceInformationMarkerStart($composer2, -1495048350, str2);
                                boolean invalid$iv17 = $composer2.changed($tribeeColor);
                                Composer $this$cache$iv7 = $composer2;
                                Object it$iv19 = $this$cache$iv7.rememberedValue();
                                if (invalid$iv17) {
                                }
                                Object value$iv11 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda25
                                    public final Object invoke(Object obj2) {
                                        Unit TribeeHomeContent$lambda$16$14$8$0;
                                        TribeeHomeContent$lambda$16$14$8$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$8$0($tribeeColor, (DrawScope) obj2);
                                        return TribeeHomeContent$lambda$16$14$8$0;
                                    }
                                };
                                $this$cache$iv7.updateRememberedValue(value$iv11);
                                it$iv19 = value$iv11;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                Modifier modifier4 = BackgroundKt.background-bw27NRU(DrawModifierKt.drawBehind(modifier3, (Function1) it$iv19), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
                                ComposerKt.sourceInformationMarkerStart($composer2, -1495038699, str2);
                                Composer $this$cache$iv8 = $composer2;
                                Object it$iv20 = $this$cache$iv8.rememberedValue();
                                if (it$iv20 == Composer.Companion.getEmpty()) {
                                    Object value$iv12 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda26
                                        public final Object invoke(Object obj2) {
                                            Unit TribeeHomeContent$lambda$16$14$9$0;
                                            TribeeHomeContent$lambda$16$14$9$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$9$0(tabPosition$delegate2, (LayoutCoordinates) obj2);
                                            return TribeeHomeContent$lambda$16$14$9$0;
                                        }
                                    };
                                    $this$cache$iv8.updateRememberedValue(value$iv12);
                                    it$iv20 = value$iv12;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                SpacerKt.Spacer(OnPlacedModifierKt.onPlaced(modifier4, (Function1) it$iv20), $composer2, 0);
                                $composer2.endReplaceGroup();
                            }
                            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight3.getValue()).unbox-impl());
                            ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                            invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                            Composer $this$cache$iv9 = $composer2;
                            Object value$iv13 = $this$cache$iv9.rememberedValue();
                            if (invalid$iv7) {
                                tabPosition$delegate3 = tabPosition$delegate2;
                                if (value$iv13 != Composer.Companion.getEmpty()) {
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    TribeeDetailComposeKt.TribeeListPager($pageState, pagerState, $fromSpmid, modifier5, (Function1) value$iv13, $composer2, 0, 0);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    $composer.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    if ($mine != null || (navEntries = $mine.getNavEntries()) == null) {
                                        kNavigationEntry = null;
                                    } else {
                                        Iterable $this$firstOrNull$iv = navEntries;
                                        Iterator it3 = $this$firstOrNull$iv.iterator();
                                        while (true) {
                                            if (it3.hasNext()) {
                                                Object element$iv = it3.next();
                                                if (Intrinsics.areEqual(((KNavigationEntry) element$iv).getNavigationType(), KNavigationType.GAME_STATS.INSTANCE)) {
                                                    obj = element$iv;
                                                    break;
                                                }
                                            } else {
                                                obj = null;
                                                break;
                                            }
                                        }
                                        kNavigationEntry = (KNavigationEntry) obj;
                                    }
                                    entry = kNavigationEntry;
                                    boolean hasDidTapEntryGameStats = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                                    ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                                    MutableState tabPosition$delegate6 = tabPosition$delegate3;
                                    invalid$iv8 = $composer.changed(hasDidTapEntryGameStats) | $composer.changed(entry) | $composer.changed($basicInfo);
                                    it$iv6 = $composer.rememberedValue();
                                    if (!invalid$iv8 || it$iv6 == Composer.Companion.getEmpty()) {
                                        KNavigationEntry.IData data = entry != null ? entry.getData() : null;
                                        kGameStats = data instanceof KNavigationEntry.KGameStats ? (KNavigationEntry.KGameStats) data : null;
                                        if (((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) || TribeePreference.INSTANCE.getHasDidTapEntryGameStats()) {
                                            if ($basicInfo != null) {
                                                z = true;
                                                if ($basicInfo.isNewCodeRedDot()) {
                                                    z2 = true;
                                                    if (!z2) {
                                                        z3 = false;
                                                        Object value$iv14 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                                        $composer.updateRememberedValue(value$iv14);
                                                        it$iv6 = value$iv14;
                                                    }
                                                }
                                            } else {
                                                z = true;
                                            }
                                            z2 = false;
                                            if (!z2) {
                                            }
                                        } else {
                                            z = true;
                                        }
                                        z3 = z;
                                        Object value$iv142 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                                        $composer.updateRememberedValue(value$iv142);
                                        it$iv6 = value$iv142;
                                    }
                                    MutableState hasRedDot$delegate = (MutableState) it$iv6;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    float TribeeHomeContent$lambda$16$9 = TribeeHomeContent$lambda$16$9(progress$delegate);
                                    boolean TribeeHomeContent$lambda$16$17 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate);
                                    ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                                    invalid$iv9 = $composer.changedInstance($router);
                                    it$iv7 = $composer.rememberedValue();
                                    if (!invalid$iv9 || it$iv7 == Composer.Companion.getEmpty()) {
                                        Object value$iv15 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                                            public final Object invoke() {
                                                Unit TribeeHomeContent$lambda$16$18$0;
                                                TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                                                return TribeeHomeContent$lambda$16$18$0;
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv15);
                                        it$iv7 = value$iv15;
                                    }
                                    Function0 function0 = (Function0) it$iv7;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                                    invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                                    Object it$iv21 = $composer.rememberedValue();
                                    if (invalid$iv10) {
                                    }
                                    Object value$iv16 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                                        public final Object invoke(Object obj2) {
                                            Unit TribeeHomeContent$lambda$16$19$0;
                                            TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                            return TribeeHomeContent$lambda$16$19$0;
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv16);
                                    it$iv21 = value$iv16;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$9, TribeeHomeContent$lambda$16$17, $basicInfo, null, function0, (Function1) it$iv21, $onUIAction, $composer, 0, 16);
                                    Modifier align = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                                    Pair<IntSize, Float> TribeeHomeContent$lambda$16$12 = TribeeHomeContent$lambda$16$1(tabPosition$delegate6);
                                    String str7 = str2;
                                    TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$12 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$12.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                                    KTribeeInteraction interaction = $pageState.getInteraction();
                                    it2 = interaction != null ? interaction.getPublish() : null;
                                    if (it2 == null) {
                                        $composer.startReplaceGroup(427745757);
                                        $composer.endReplaceGroup();
                                        composer = $composer;
                                    } else {
                                        $composer.startReplaceGroup(427745758);
                                        ComposerKt.sourceInformation($composer, "*708@28354L349,700@27989L729");
                                        Modifier navigationBarsPadding = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.padding-qDBjuR0$default($this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(25), 3, (Object) null));
                                        boolean z4 = $basicInfo != null && $basicInfo.isJoined();
                                        ComposerKt.sourceInformationMarkerStart($composer, -1943090093, str7);
                                        boolean invalid$iv18 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                                        Object it$iv22 = $composer.rememberedValue();
                                        if (invalid$iv18) {
                                        }
                                        Object value$iv17 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda14
                                            public final Object invoke(Object obj2) {
                                                Unit TribeeHomeContent$lambda$16$21$0$0;
                                                TribeeHomeContent$lambda$16$21$0$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$21$0$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                                return TribeeHomeContent$lambda$16$21$0$0;
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv17);
                                        it$iv22 = value$iv17;
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        composer = $composer;
                                        TribeeDetailComposeKt.TribeeFloatPublish(z4, it2, navigationBarsPadding, (Function1) it$iv22, $composer, 0, 0);
                                        Unit unit = Unit.INSTANCE;
                                        $composer.endReplaceGroup();
                                        Unit unit2 = Unit.INSTANCE;
                                    }
                                    if ($mine != null) {
                                        composer.startReplaceGroup(428551479);
                                        ComposerKt.sourceInformation(composer, "728@29092L843,725@28949L22,721@28770L1180");
                                        boolean TribeeHomeContent$lambda$8 = TribeeHomeContent$lambda$8($showDrawer$delegate);
                                        KTribeeInteraction interaction2 = $pageState.getInteraction();
                                        BoxScope boxScope = (BoxScope) $this$BoxWithConstraints;
                                        ComposerKt.sourceInformationMarkerStart(composer, 1953496858, str7);
                                        boolean invalid$iv19 = composer.changed($pageState) | composer.changed($fromSpmid);
                                        Object it$iv23 = $composer.rememberedValue();
                                        if (invalid$iv19 || it$iv23 == Composer.Companion.getEmpty()) {
                                            mutableState = $shareParams$delegate;
                                            Object value$iv18 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda15
                                                public final Object invoke() {
                                                    Unit TribeeHomeContent$lambda$16$22$0;
                                                    TribeeHomeContent$lambda$16$22$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$22$0(TribeeHomeContentState.this, $fromSpmid, mutableState);
                                                    return TribeeHomeContent$lambda$16$22$0;
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv18);
                                            it$iv23 = value$iv18;
                                        } else {
                                            mutableState = $shareParams$delegate;
                                        }
                                        Function0 function02 = (Function0) it$iv23;
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        ComposerKt.sourceInformationMarkerStart(composer, 1953491461, str7);
                                        Object it$iv24 = $composer.rememberedValue();
                                        if (it$iv24 == Composer.Companion.getEmpty()) {
                                            Object value$iv19 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda16
                                                public final Object invoke() {
                                                    Unit TribeeHomeContent$lambda$16$23$0;
                                                    TribeeHomeContent$lambda$16$23$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$23$0($showDrawer$delegate);
                                                    return TribeeHomeContent$lambda$16$23$0;
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv19);
                                            it$iv24 = value$iv19;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        tribeeHomeContentState = $pageState;
                                        function1 = $onStateAction;
                                        str3 = str7;
                                        f3 = 0.0f;
                                        r6 = 1;
                                        TribeeUserCenterComposeKt.TribeeUserCenterDrawer(boxScope, $mine, interaction2, TribeeHomeContent$lambda$8, $onStateAction, $onUIAction, null, function02, (Function0) it$iv24, $composer, ($dirty3 & 14) | 100663296, 32);
                                    } else {
                                        mutableState = $shareParams$delegate;
                                        tribeeHomeContentState = $pageState;
                                        function1 = $onStateAction;
                                        str3 = str7;
                                        f3 = 0.0f;
                                        r6 = 1;
                                        composer.startReplaceGroup(399974067);
                                    }
                                    $composer.endReplaceGroup();
                                    if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                                        composer.startReplaceGroup(429735834);
                                        ComposerKt.sourceInformation(composer, "755@30120L50,752@30009L161");
                                        ShareParams TribeeHomeContent$lambda$11 = TribeeHomeContent$lambda$11($shareParams$delegate);
                                        Intrinsics.checkNotNull(TribeeHomeContent$lambda$11);
                                        ComposerKt.sourceInformationMarkerStart(composer, 1953528961, str3);
                                        Object it$iv25 = $composer.rememberedValue();
                                        if (it$iv25 == Composer.Companion.getEmpty()) {
                                            Object value$iv20 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda17
                                                public final Object invoke() {
                                                    Unit TribeeHomeContent$lambda$16$24$0;
                                                    TribeeHomeContent$lambda$16$24$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$24$0(mutableState);
                                                    return TribeeHomeContent$lambda$16$24$0;
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv20);
                                            it$iv25 = value$iv20;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer);
                                        f4 = f3;
                                        str4 = str3;
                                        function12 = function1;
                                        tribeeHomeContentState2 = tribeeHomeContentState;
                                        TribeeShareComposeKt.TribeeShare(TribeeHomeContent$lambda$11, $pageState, (Function0) it$iv25, $composer, ShareParams.$stable | 384, 0);
                                    } else {
                                        f4 = f3;
                                        str4 = str3;
                                        function12 = function1;
                                        tribeeHomeContentState2 = tribeeHomeContentState;
                                        composer.startReplaceGroup(399974067);
                                    }
                                    $composer.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                                    invalid$iv11 = composer.changed($basicInfo);
                                    it$iv8 = $composer.rememberedValue();
                                    if (!invalid$iv11 || it$iv8 == Composer.Companion.getEmpty()) {
                                        continuation2 = null;
                                        Object value$iv21 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                                        $composer.updateRememberedValue(value$iv21);
                                        it$iv8 = value$iv21;
                                    } else {
                                        continuation2 = null;
                                    }
                                    final MutableState showBubble$delegate = (MutableState) it$iv8;
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    Continuation continuation4 = continuation2;
                                    TribeeHomeContentState tribeeHomeContentState3 = tribeeHomeContentState2;
                                    AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                            Unit TribeeHomeContent$lambda$16$28;
                                            TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                            return TribeeHomeContent$lambda$16$28;
                                        }
                                    }, composer, 54), $composer, 196656, 28);
                                    Long valueOf4 = Long.valueOf($pageState.getCategoryId());
                                    ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                                    invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState3);
                                    it$iv9 = $composer.rememberedValue();
                                    if (!invalid$iv12 || it$iv9 == Composer.Companion.getEmpty()) {
                                        Object value$iv22 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState3, continuation4);
                                        $composer.updateRememberedValue(value$iv22);
                                        it$iv9 = value$iv22;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    EffectsKt.LaunchedEffect(valueOf4, (Function2) it$iv9, composer, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            } else {
                                tabPosition$delegate3 = tabPosition$delegate2;
                            }
                            value$iv13 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                                public final Object invoke(Object obj2) {
                                    Unit TribeeHomeContent$lambda$16$14$10$0;
                                    TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                    return TribeeHomeContent$lambda$16$14$10$0;
                                }
                            };
                            $this$cache$iv9.updateRememberedValue(value$iv13);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            TribeeDetailComposeKt.TribeeListPager($pageState, pagerState, $fromSpmid, modifier5, (Function1) value$iv13, $composer2, 0, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            if ($mine != null) {
                            }
                            kNavigationEntry = null;
                            entry = kNavigationEntry;
                            boolean hasDidTapEntryGameStats2 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                            ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                            MutableState tabPosition$delegate62 = tabPosition$delegate3;
                            invalid$iv8 = $composer.changed(hasDidTapEntryGameStats2) | $composer.changed(entry) | $composer.changed($basicInfo);
                            it$iv6 = $composer.rememberedValue();
                            if (!invalid$iv8) {
                            }
                            if (entry != null) {
                            }
                            if (data instanceof KNavigationEntry.KGameStats) {
                            }
                            if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                            }
                            if ($basicInfo != null) {
                            }
                            z2 = false;
                            if (!z2) {
                            }
                            z3 = z;
                            Object value$iv1422 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                            $composer.updateRememberedValue(value$iv1422);
                            it$iv6 = value$iv1422;
                            MutableState hasRedDot$delegate2 = (MutableState) it$iv6;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            float TribeeHomeContent$lambda$16$92 = TribeeHomeContent$lambda$16$9(progress$delegate);
                            boolean TribeeHomeContent$lambda$16$172 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate2);
                            ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                            invalid$iv9 = $composer.changedInstance($router);
                            it$iv7 = $composer.rememberedValue();
                            if (!invalid$iv9) {
                            }
                            Object value$iv152 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                                public final Object invoke() {
                                    Unit TribeeHomeContent$lambda$16$18$0;
                                    TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                                    return TribeeHomeContent$lambda$16$18$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv152);
                            it$iv7 = value$iv152;
                            Function0 function03 = (Function0) it$iv7;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                            invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                            Object it$iv212 = $composer.rememberedValue();
                            if (invalid$iv10) {
                            }
                            Object value$iv162 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                                public final Object invoke(Object obj2) {
                                    Unit TribeeHomeContent$lambda$16$19$0;
                                    TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                    return TribeeHomeContent$lambda$16$19$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv162);
                            it$iv212 = value$iv162;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$92, TribeeHomeContent$lambda$16$172, $basicInfo, null, function03, (Function1) it$iv212, $onUIAction, $composer, 0, 16);
                            Modifier align2 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                            Pair<IntSize, Float> TribeeHomeContent$lambda$16$122 = TribeeHomeContent$lambda$16$1(tabPosition$delegate62);
                            String str72 = str2;
                            TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align2, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$122 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$122.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                            KTribeeInteraction interaction3 = $pageState.getInteraction();
                            if (interaction3 != null) {
                            }
                            if (it2 == null) {
                            }
                            if ($mine != null) {
                            }
                            $composer.endReplaceGroup();
                            if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                            }
                            $composer.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                            invalid$iv11 = composer.changed($basicInfo);
                            it$iv8 = $composer.rememberedValue();
                            if (!invalid$iv11) {
                            }
                            continuation2 = null;
                            Object value$iv212 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                            $composer.updateRememberedValue(value$iv212);
                            it$iv8 = value$iv212;
                            final MutableState showBubble$delegate2 = (MutableState) it$iv8;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            Continuation continuation42 = continuation2;
                            TribeeHomeContentState tribeeHomeContentState32 = tribeeHomeContentState2;
                            AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate2), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                    Unit TribeeHomeContent$lambda$16$28;
                                    TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate2, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                    return TribeeHomeContent$lambda$16$28;
                                }
                            }, composer, 54), $composer, 196656, 28);
                            Long valueOf42 = Long.valueOf($pageState.getCategoryId());
                            ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                            invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState32);
                            it$iv9 = $composer.rememberedValue();
                            if (!invalid$iv12) {
                            }
                            Object value$iv222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState32, continuation42);
                            $composer.updateRememberedValue(value$iv222);
                            it$iv9 = value$iv222;
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            EffectsKt.LaunchedEffect(valueOf42, (Function2) it$iv9, composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                        $composer$iv$iv = $composer;
                        continuation = null;
                        Object value$iv23 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState, selectedTabIndex, null);
                        $this$cache$iv2.updateRememberedValue(value$iv23);
                        it$iv15 = value$iv23;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(valueOf3, (Function2) it$iv15, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                        invalid$iv6 = $composer2.changed(pagerState) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                        Composer $this$cache$iv32 = $composer2;
                        it$iv5 = $this$cache$iv32.rememberedValue();
                        if (!invalid$iv6) {
                        }
                        Object value$iv72 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState, $pageState, $currentOnStateAction$delegate, continuation);
                        $this$cache$iv32.updateRememberedValue(value$iv72);
                        it$iv5 = value$iv72;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(pagerState, (Function2) it$iv5, $composer2, 0);
                        if ($pageState.getCategoryList().size() <= 1) {
                        }
                        Modifier modifier52 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight3.getValue()).unbox-impl());
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                        invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                        Composer $this$cache$iv92 = $composer2;
                        Object value$iv132 = $this$cache$iv92.rememberedValue();
                        if (invalid$iv7) {
                        }
                        value$iv132 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj2) {
                                Unit TribeeHomeContent$lambda$16$14$10$0;
                                TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                return TribeeHomeContent$lambda$16$14$10$0;
                            }
                        };
                        $this$cache$iv92.updateRememberedValue(value$iv132);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        TribeeDetailComposeKt.TribeeListPager($pageState, pagerState, $fromSpmid, modifier52, (Function1) value$iv132, $composer2, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if ($mine != null) {
                        }
                        kNavigationEntry = null;
                        entry = kNavigationEntry;
                        boolean hasDidTapEntryGameStats22 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                        ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                        MutableState tabPosition$delegate622 = tabPosition$delegate3;
                        invalid$iv8 = $composer.changed(hasDidTapEntryGameStats22) | $composer.changed(entry) | $composer.changed($basicInfo);
                        it$iv6 = $composer.rememberedValue();
                        if (!invalid$iv8) {
                        }
                        if (entry != null) {
                        }
                        if (data instanceof KNavigationEntry.KGameStats) {
                        }
                        if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                        }
                        if ($basicInfo != null) {
                        }
                        z2 = false;
                        if (!z2) {
                        }
                        z3 = z;
                        Object value$iv14222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer.updateRememberedValue(value$iv14222);
                        it$iv6 = value$iv14222;
                        MutableState hasRedDot$delegate22 = (MutableState) it$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        float TribeeHomeContent$lambda$16$922 = TribeeHomeContent$lambda$16$9(progress$delegate);
                        boolean TribeeHomeContent$lambda$16$1722 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate22);
                        ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                        invalid$iv9 = $composer.changedInstance($router);
                        it$iv7 = $composer.rememberedValue();
                        if (!invalid$iv9) {
                        }
                        Object value$iv1522 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                            public final Object invoke() {
                                Unit TribeeHomeContent$lambda$16$18$0;
                                TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                                return TribeeHomeContent$lambda$16$18$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv1522);
                        it$iv7 = value$iv1522;
                        Function0 function032 = (Function0) it$iv7;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                        invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                        Object it$iv2122 = $composer.rememberedValue();
                        if (invalid$iv10) {
                        }
                        Object value$iv1622 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj2) {
                                Unit TribeeHomeContent$lambda$16$19$0;
                                TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                return TribeeHomeContent$lambda$16$19$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv1622);
                        it$iv2122 = value$iv1622;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$922, TribeeHomeContent$lambda$16$1722, $basicInfo, null, function032, (Function1) it$iv2122, $onUIAction, $composer, 0, 16);
                        Modifier align22 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                        Pair<IntSize, Float> TribeeHomeContent$lambda$16$1222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate622);
                        String str722 = str2;
                        TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align22, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$1222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$1222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                        KTribeeInteraction interaction32 = $pageState.getInteraction();
                        if (interaction32 != null) {
                        }
                        if (it2 == null) {
                        }
                        if ($mine != null) {
                        }
                        $composer.endReplaceGroup();
                        if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                        }
                        $composer.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                        invalid$iv11 = composer.changed($basicInfo);
                        it$iv8 = $composer.rememberedValue();
                        if (!invalid$iv11) {
                        }
                        continuation2 = null;
                        Object value$iv2122 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer.updateRememberedValue(value$iv2122);
                        it$iv8 = value$iv2122;
                        final MutableState showBubble$delegate22 = (MutableState) it$iv8;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Continuation continuation422 = continuation2;
                        TribeeHomeContentState tribeeHomeContentState322 = tribeeHomeContentState2;
                        AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate22), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                Unit TribeeHomeContent$lambda$16$28;
                                TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate22, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                return TribeeHomeContent$lambda$16$28;
                            }
                        }, composer, 54), $composer, 196656, 28);
                        Long valueOf422 = Long.valueOf($pageState.getCategoryId());
                        ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                        invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState322);
                        it$iv9 = $composer.rememberedValue();
                        if (!invalid$iv12) {
                        }
                        Object value$iv2222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState322, continuation422);
                        $composer.updateRememberedValue(value$iv2222);
                        it$iv9 = value$iv2222;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        EffectsKt.LaunchedEffect(valueOf422, (Function2) it$iv9, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    str = "CC(remember):TribeeHomePage.kt#9igjgp";
                    Object value$iv24 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$2$1($pageScrollState, $density, progress$delegate, null);
                    $composer.updateRememberedValue(value$iv24);
                    it$iv14 = value$iv24;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf2, (Function2) it$iv14, $composer, 0);
                    int $dirty32 = $dirty;
                    String str52 = str;
                    MutableState listHeight32 = listHeight2;
                    MutableState tabPosition$delegate52 = tabPosition$delegate;
                    int i4 = -1;
                    Modifier verticalScroll$default2 = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str52);
                    it$iv3 = $composer.rememberedValue();
                    if (it$iv3 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv2 = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default2, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                    Function0 factory$iv$iv$iv22 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if (!$composer.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i22 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i32 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
                    if ($basicInfo == null) {
                    }
                    $composer2.endReplaceGroup();
                    Iterable $this$indexOfFirst$iv2 = $pageState.getCategoryList().keySet();
                    index$iv = 0;
                    it = $this$indexOfFirst$iv2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                        index$iv++;
                    }
                    int selectedTabIndex2 = i4;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
                    invalid$iv4 = $composer2.changed($pageState);
                    Composer $this$cache$iv10 = $composer2;
                    it$iv4 = $this$cache$iv10.rememberedValue();
                    if (!invalid$iv4) {
                    }
                    Object value$iv62 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                        public final Object invoke() {
                            int TribeeHomeContent$lambda$16$14$2$0;
                            TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                            return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                        }
                    };
                    $this$cache$iv10.updateRememberedValue(value$iv62);
                    it$iv4 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final PagerState pagerState2 = PagerStateKt.rememberPagerState(selectedTabIndex2, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
                    Integer valueOf32 = Integer.valueOf(selectedTabIndex2);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
                    invalid$iv5 = $composer2.changed(pagerState2) | $composer2.changed(selectedTabIndex2);
                    Composer $this$cache$iv22 = $composer2;
                    Object it$iv152 = $this$cache$iv22.rememberedValue();
                    if (!invalid$iv5) {
                        $composer$iv$iv = $composer;
                        continuation = null;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(valueOf32, (Function2) it$iv152, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                        invalid$iv6 = $composer2.changed(pagerState2) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                        Composer $this$cache$iv322 = $composer2;
                        it$iv5 = $this$cache$iv322.rememberedValue();
                        if (!invalid$iv6) {
                        }
                        Object value$iv722 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState2, $pageState, $currentOnStateAction$delegate, continuation);
                        $this$cache$iv322.updateRememberedValue(value$iv722);
                        it$iv5 = value$iv722;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(pagerState2, (Function2) it$iv5, $composer2, 0);
                        if ($pageState.getCategoryList().size() <= 1) {
                        }
                        Modifier modifier522 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight32.getValue()).unbox-impl());
                        ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                        invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                        Composer $this$cache$iv922 = $composer2;
                        Object value$iv1322 = $this$cache$iv922.rememberedValue();
                        if (invalid$iv7) {
                        }
                        value$iv1322 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                            public final Object invoke(Object obj2) {
                                Unit TribeeHomeContent$lambda$16$14$10$0;
                                TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                return TribeeHomeContent$lambda$16$14$10$0;
                            }
                        };
                        $this$cache$iv922.updateRememberedValue(value$iv1322);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        TribeeDetailComposeKt.TribeeListPager($pageState, pagerState2, $fromSpmid, modifier522, (Function1) value$iv1322, $composer2, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if ($mine != null) {
                        }
                        kNavigationEntry = null;
                        entry = kNavigationEntry;
                        boolean hasDidTapEntryGameStats222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                        ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                        MutableState tabPosition$delegate6222 = tabPosition$delegate3;
                        invalid$iv8 = $composer.changed(hasDidTapEntryGameStats222) | $composer.changed(entry) | $composer.changed($basicInfo);
                        it$iv6 = $composer.rememberedValue();
                        if (!invalid$iv8) {
                        }
                        if (entry != null) {
                        }
                        if (data instanceof KNavigationEntry.KGameStats) {
                        }
                        if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                        }
                        if ($basicInfo != null) {
                        }
                        z2 = false;
                        if (!z2) {
                        }
                        z3 = z;
                        Object value$iv142222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer.updateRememberedValue(value$iv142222);
                        it$iv6 = value$iv142222;
                        MutableState hasRedDot$delegate222 = (MutableState) it$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        float TribeeHomeContent$lambda$16$9222 = TribeeHomeContent$lambda$16$9(progress$delegate);
                        boolean TribeeHomeContent$lambda$16$17222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate222);
                        ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                        invalid$iv9 = $composer.changedInstance($router);
                        it$iv7 = $composer.rememberedValue();
                        if (!invalid$iv9) {
                        }
                        Object value$iv15222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                            public final Object invoke() {
                                Unit TribeeHomeContent$lambda$16$18$0;
                                TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                                return TribeeHomeContent$lambda$16$18$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv15222);
                        it$iv7 = value$iv15222;
                        Function0 function0322 = (Function0) it$iv7;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                        invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                        Object it$iv21222 = $composer.rememberedValue();
                        if (invalid$iv10) {
                        }
                        Object value$iv16222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj2) {
                                Unit TribeeHomeContent$lambda$16$19$0;
                                TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                                return TribeeHomeContent$lambda$16$19$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv16222);
                        it$iv21222 = value$iv16222;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$9222, TribeeHomeContent$lambda$16$17222, $basicInfo, null, function0322, (Function1) it$iv21222, $onUIAction, $composer, 0, 16);
                        Modifier align222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                        Pair<IntSize, Float> TribeeHomeContent$lambda$16$12222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate6222);
                        String str7222 = str2;
                        TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$12222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$12222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                        KTribeeInteraction interaction322 = $pageState.getInteraction();
                        if (interaction322 != null) {
                        }
                        if (it2 == null) {
                        }
                        if ($mine != null) {
                        }
                        $composer.endReplaceGroup();
                        if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                        }
                        $composer.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                        invalid$iv11 = composer.changed($basicInfo);
                        it$iv8 = $composer.rememberedValue();
                        if (!invalid$iv11) {
                        }
                        continuation2 = null;
                        Object value$iv21222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer.updateRememberedValue(value$iv21222);
                        it$iv8 = value$iv21222;
                        final MutableState showBubble$delegate222 = (MutableState) it$iv8;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        Continuation continuation4222 = continuation2;
                        TribeeHomeContentState tribeeHomeContentState3222 = tribeeHomeContentState2;
                        AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                            public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                Unit TribeeHomeContent$lambda$16$28;
                                TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                                return TribeeHomeContent$lambda$16$28;
                            }
                        }, composer, 54), $composer, 196656, 28);
                        Long valueOf4222 = Long.valueOf($pageState.getCategoryId());
                        ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                        invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState3222);
                        it$iv9 = $composer.rememberedValue();
                        if (!invalid$iv12) {
                        }
                        Object value$iv22222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState3222, continuation4222);
                        $composer.updateRememberedValue(value$iv22222);
                        it$iv9 = value$iv22222;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        EffectsKt.LaunchedEffect(valueOf4222, (Function2) it$iv9, composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    $composer$iv$iv = $composer;
                    continuation = null;
                    Object value$iv232 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState2, selectedTabIndex2, null);
                    $this$cache$iv22.updateRememberedValue(value$iv232);
                    it$iv152 = value$iv232;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(valueOf32, (Function2) it$iv152, $composer2, 0);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                    invalid$iv6 = $composer2.changed(pagerState2) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                    Composer $this$cache$iv3222 = $composer2;
                    it$iv5 = $this$cache$iv3222.rememberedValue();
                    if (!invalid$iv6) {
                    }
                    Object value$iv7222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState2, $pageState, $currentOnStateAction$delegate, continuation);
                    $this$cache$iv3222.updateRememberedValue(value$iv7222);
                    it$iv5 = value$iv7222;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(pagerState2, (Function2) it$iv5, $composer2, 0);
                    if ($pageState.getCategoryList().size() <= 1) {
                    }
                    Modifier modifier5222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight32.getValue()).unbox-impl());
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                    invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                    Composer $this$cache$iv9222 = $composer2;
                    Object value$iv13222 = $this$cache$iv9222.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv13222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj2) {
                            Unit TribeeHomeContent$lambda$16$14$10$0;
                            TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                            return TribeeHomeContent$lambda$16$14$10$0;
                        }
                    };
                    $this$cache$iv9222.updateRememberedValue(value$iv13222);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TribeeDetailComposeKt.TribeeListPager($pageState, pagerState2, $fromSpmid, modifier5222, (Function1) value$iv13222, $composer2, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if ($mine != null) {
                    }
                    kNavigationEntry = null;
                    entry = kNavigationEntry;
                    boolean hasDidTapEntryGameStats2222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                    ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                    MutableState tabPosition$delegate62222 = tabPosition$delegate3;
                    invalid$iv8 = $composer.changed(hasDidTapEntryGameStats2222) | $composer.changed(entry) | $composer.changed($basicInfo);
                    it$iv6 = $composer.rememberedValue();
                    if (!invalid$iv8) {
                    }
                    if (entry != null) {
                    }
                    if (data instanceof KNavigationEntry.KGameStats) {
                    }
                    if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                    }
                    if ($basicInfo != null) {
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    z3 = z;
                    Object value$iv1422222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv1422222);
                    it$iv6 = value$iv1422222;
                    MutableState hasRedDot$delegate2222 = (MutableState) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    float TribeeHomeContent$lambda$16$92222 = TribeeHomeContent$lambda$16$9(progress$delegate);
                    boolean TribeeHomeContent$lambda$16$172222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate2222);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                    invalid$iv9 = $composer.changedInstance($router);
                    it$iv7 = $composer.rememberedValue();
                    if (!invalid$iv9) {
                    }
                    Object value$iv152222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                        public final Object invoke() {
                            Unit TribeeHomeContent$lambda$16$18$0;
                            TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                            return TribeeHomeContent$lambda$16$18$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv152222);
                    it$iv7 = value$iv152222;
                    Function0 function03222 = (Function0) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                    invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                    Object it$iv212222 = $composer.rememberedValue();
                    if (invalid$iv10) {
                    }
                    Object value$iv162222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            Unit TribeeHomeContent$lambda$16$19$0;
                            TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                            return TribeeHomeContent$lambda$16$19$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv162222);
                    it$iv212222 = value$iv162222;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$92222, TribeeHomeContent$lambda$16$172222, $basicInfo, null, function03222, (Function1) it$iv212222, $onUIAction, $composer, 0, 16);
                    Modifier align2222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                    Pair<IntSize, Float> TribeeHomeContent$lambda$16$122222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate62222);
                    String str72222 = str2;
                    TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align2222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$122222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$122222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                    KTribeeInteraction interaction3222 = $pageState.getInteraction();
                    if (interaction3222 != null) {
                    }
                    if (it2 == null) {
                    }
                    if ($mine != null) {
                    }
                    $composer.endReplaceGroup();
                    if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                    invalid$iv11 = composer.changed($basicInfo);
                    it$iv8 = $composer.rememberedValue();
                    if (!invalid$iv11) {
                    }
                    continuation2 = null;
                    Object value$iv212222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv212222);
                    it$iv8 = value$iv212222;
                    final MutableState showBubble$delegate2222 = (MutableState) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Continuation continuation42222 = continuation2;
                    TribeeHomeContentState tribeeHomeContentState32222 = tribeeHomeContentState2;
                    AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate2222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit TribeeHomeContent$lambda$16$28;
                            TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate2222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            return TribeeHomeContent$lambda$16$28;
                        }
                    }, composer, 54), $composer, 196656, 28);
                    Long valueOf42222 = Long.valueOf($pageState.getCategoryId());
                    ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                    invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState32222);
                    it$iv9 = $composer.rememberedValue();
                    if (!invalid$iv12) {
                    }
                    Object value$iv222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState32222, continuation42222);
                    $composer.updateRememberedValue(value$iv222222);
                    it$iv9 = value$iv222222;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf42222, (Function2) it$iv9, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                float f5 = ((Dp) listHeight.getValue()).unbox-impl();
                $this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240 = TribeeHomeContent$lambda$16$1(tabPosition$delegate4);
                if ($this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240 != null) {
                    listHeight2 = listHeight;
                    tabPosition$delegate = tabPosition$delegate4;
                    f2 = Dp.constructor-impl(0);
                } else {
                    listHeight2 = listHeight;
                    tabPosition$delegate = tabPosition$delegate4;
                    f2 = Dp.constructor-impl($density.toDp-u2uoSUM((int) ($this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240.getFirst().unbox-impl() & 4294967295L)) + Dp.constructor-impl($density.toDp-u2uoSUM($this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240.getSecond().floatValue()) - NAVIGATION_HEIGHT));
                }
                Object value$iv25 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(f5 + f2)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv25);
                it$iv12 = value$iv25;
                MutableState pageHeight2 = (MutableState) it$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953180691, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                final MutableFloatState pageScrollConsumeY$delegate2 = (MutableFloatState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953182643, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                }
                MutableFloatState progress$delegate2 = (MutableFloatState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Float valueOf5 = Float.valueOf(TribeeHomeContent$lambda$16$6(pageScrollConsumeY$delegate2));
                ComposerKt.sourceInformationMarkerStart($composer, 1953185321, "CC(remember):TribeeHomePage.kt#9igjgp");
                invalid$iv2 = $composer.changed($pageScrollState);
                Object it$iv132 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv32 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$1$1(pageScrollConsumeY$delegate2, $pageScrollState, null);
                $composer.updateRememberedValue(value$iv32);
                it$iv132 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf5, (Function2) it$iv132, $composer, 0);
                Integer valueOf22 = Integer.valueOf($pageScrollState.getValue());
                ComposerKt.sourceInformationMarkerStart($composer, 1953191934, "CC(remember):TribeeHomePage.kt#9igjgp");
                invalid$iv3 = $composer.changed($pageScrollState) | $composer.changed($density);
                Object it$iv142 = $composer.rememberedValue();
                if (!invalid$iv3) {
                    str = "CC(remember):TribeeHomePage.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf22, (Function2) it$iv142, $composer, 0);
                    int $dirty322 = $dirty;
                    String str522 = str;
                    MutableState listHeight322 = listHeight2;
                    MutableState tabPosition$delegate522 = tabPosition$delegate;
                    int i42 = -1;
                    Modifier verticalScroll$default22 = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight2.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str522);
                    it$iv3 = $composer.rememberedValue();
                    if (it$iv3 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv22 = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default22, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv22 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer, modifier$iv22);
                    Function0 factory$iv$iv$iv222 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                    }
                    $composer.startReusableNode();
                    if (!$composer.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i222 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
                    int i322 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
                    if ($basicInfo == null) {
                    }
                    $composer2.endReplaceGroup();
                    Iterable $this$indexOfFirst$iv22 = $pageState.getCategoryList().keySet();
                    index$iv = 0;
                    it = $this$indexOfFirst$iv22.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                        index$iv++;
                    }
                    int selectedTabIndex22 = i42;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
                    invalid$iv4 = $composer2.changed($pageState);
                    Composer $this$cache$iv102 = $composer2;
                    it$iv4 = $this$cache$iv102.rememberedValue();
                    if (!invalid$iv4) {
                    }
                    Object value$iv622 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                        public final Object invoke() {
                            int TribeeHomeContent$lambda$16$14$2$0;
                            TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                            return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                        }
                    };
                    $this$cache$iv102.updateRememberedValue(value$iv622);
                    it$iv4 = value$iv622;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    final PagerState pagerState22 = PagerStateKt.rememberPagerState(selectedTabIndex22, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
                    Integer valueOf322 = Integer.valueOf(selectedTabIndex22);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
                    invalid$iv5 = $composer2.changed(pagerState22) | $composer2.changed(selectedTabIndex22);
                    Composer $this$cache$iv222 = $composer2;
                    Object it$iv1522 = $this$cache$iv222.rememberedValue();
                    if (!invalid$iv5) {
                    }
                    $composer$iv$iv = $composer;
                    continuation = null;
                    Object value$iv2322 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState22, selectedTabIndex22, null);
                    $this$cache$iv222.updateRememberedValue(value$iv2322);
                    it$iv1522 = value$iv2322;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(valueOf322, (Function2) it$iv1522, $composer2, 0);
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                    invalid$iv6 = $composer2.changed(pagerState22) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                    Composer $this$cache$iv32222 = $composer2;
                    it$iv5 = $this$cache$iv32222.rememberedValue();
                    if (!invalid$iv6) {
                    }
                    Object value$iv72222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState22, $pageState, $currentOnStateAction$delegate, continuation);
                    $this$cache$iv32222.updateRememberedValue(value$iv72222);
                    it$iv5 = value$iv72222;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(pagerState22, (Function2) it$iv5, $composer2, 0);
                    if ($pageState.getCategoryList().size() <= 1) {
                    }
                    Modifier modifier52222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight322.getValue()).unbox-impl());
                    ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                    invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                    Composer $this$cache$iv92222 = $composer2;
                    Object value$iv132222 = $this$cache$iv92222.rememberedValue();
                    if (invalid$iv7) {
                    }
                    value$iv132222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                        public final Object invoke(Object obj2) {
                            Unit TribeeHomeContent$lambda$16$14$10$0;
                            TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                            return TribeeHomeContent$lambda$16$14$10$0;
                        }
                    };
                    $this$cache$iv92222.updateRememberedValue(value$iv132222);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TribeeDetailComposeKt.TribeeListPager($pageState, pagerState22, $fromSpmid, modifier52222, (Function1) value$iv132222, $composer2, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if ($mine != null) {
                    }
                    kNavigationEntry = null;
                    entry = kNavigationEntry;
                    boolean hasDidTapEntryGameStats22222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                    ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                    MutableState tabPosition$delegate622222 = tabPosition$delegate3;
                    invalid$iv8 = $composer.changed(hasDidTapEntryGameStats22222) | $composer.changed(entry) | $composer.changed($basicInfo);
                    it$iv6 = $composer.rememberedValue();
                    if (!invalid$iv8) {
                    }
                    if (entry != null) {
                    }
                    if (data instanceof KNavigationEntry.KGameStats) {
                    }
                    if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                    }
                    if ($basicInfo != null) {
                    }
                    z2 = false;
                    if (!z2) {
                    }
                    z3 = z;
                    Object value$iv14222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv14222222);
                    it$iv6 = value$iv14222222;
                    MutableState hasRedDot$delegate22222 = (MutableState) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    float TribeeHomeContent$lambda$16$922222 = TribeeHomeContent$lambda$16$9(progress$delegate2);
                    boolean TribeeHomeContent$lambda$16$1722222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate22222);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                    invalid$iv9 = $composer.changedInstance($router);
                    it$iv7 = $composer.rememberedValue();
                    if (!invalid$iv9) {
                    }
                    Object value$iv1522222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                        public final Object invoke() {
                            Unit TribeeHomeContent$lambda$16$18$0;
                            TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                            return TribeeHomeContent$lambda$16$18$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv1522222);
                    it$iv7 = value$iv1522222;
                    Function0 function032222 = (Function0) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                    invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                    Object it$iv2122222 = $composer.rememberedValue();
                    if (invalid$iv10) {
                    }
                    Object value$iv1622222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                        public final Object invoke(Object obj2) {
                            Unit TribeeHomeContent$lambda$16$19$0;
                            TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                            return TribeeHomeContent$lambda$16$19$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv1622222);
                    it$iv2122222 = value$iv1622222;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$922222, TribeeHomeContent$lambda$16$1722222, $basicInfo, null, function032222, (Function1) it$iv2122222, $onUIAction, $composer, 0, 16);
                    Modifier align22222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                    Pair<IntSize, Float> TribeeHomeContent$lambda$16$1222222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate622222);
                    String str722222 = str2;
                    TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align22222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$1222222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$1222222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                    KTribeeInteraction interaction32222 = $pageState.getInteraction();
                    if (interaction32222 != null) {
                    }
                    if (it2 == null) {
                    }
                    if ($mine != null) {
                    }
                    $composer.endReplaceGroup();
                    if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                    invalid$iv11 = composer.changed($basicInfo);
                    it$iv8 = $composer.rememberedValue();
                    if (!invalid$iv11) {
                    }
                    continuation2 = null;
                    Object value$iv2122222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                    $composer.updateRememberedValue(value$iv2122222);
                    it$iv8 = value$iv2122222;
                    final MutableState showBubble$delegate22222 = (MutableState) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Continuation continuation422222 = continuation2;
                    TribeeHomeContentState tribeeHomeContentState322222 = tribeeHomeContentState2;
                    AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate22222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                        public final Object invoke(Object obj2, Object obj3, Object obj4) {
                            Unit TribeeHomeContent$lambda$16$28;
                            TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate22222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                            return TribeeHomeContent$lambda$16$28;
                        }
                    }, composer, 54), $composer, 196656, 28);
                    Long valueOf422222 = Long.valueOf($pageState.getCategoryId());
                    ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                    invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState322222);
                    it$iv9 = $composer.rememberedValue();
                    if (!invalid$iv12) {
                    }
                    Object value$iv2222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState322222, continuation422222);
                    $composer.updateRememberedValue(value$iv2222222);
                    it$iv9 = value$iv2222222;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    EffectsKt.LaunchedEffect(valueOf422222, (Function2) it$iv9, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                str = "CC(remember):TribeeHomePage.kt#9igjgp";
                Object value$iv242 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$2$1($pageScrollState, $density, progress$delegate2, null);
                $composer.updateRememberedValue(value$iv242);
                it$iv142 = value$iv242;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf22, (Function2) it$iv142, $composer, 0);
                int $dirty3222 = $dirty;
                String str5222 = str;
                MutableState listHeight3222 = listHeight2;
                MutableState tabPosition$delegate5222 = tabPosition$delegate;
                int i422 = -1;
                Modifier verticalScroll$default222 = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight2.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str5222);
                it$iv3 = $composer.rememberedValue();
                if (it$iv3 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv222 = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default222, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv222 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv222 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv222, horizontalAlignment$iv222, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv222 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv222 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv222 = ComposedModifierKt.materializeModifier($composer, modifier$iv222);
                Function0 factory$iv$iv$iv2222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv222 = (($changed$iv$iv222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv222 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, measurePolicy$iv222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, localMap$iv$iv222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv222, Integer.valueOf(compositeKeyHash$iv$iv222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv222, materialized$iv$iv222, ComposeUiNode.Companion.getSetModifier());
                int i2222 = ($changed$iv$iv$iv222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope222 = ColumnScopeInstance.INSTANCE;
                int i3222 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
                if ($basicInfo == null) {
                }
                $composer2.endReplaceGroup();
                Iterable $this$indexOfFirst$iv222 = $pageState.getCategoryList().keySet();
                index$iv = 0;
                it = $this$indexOfFirst$iv222.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                    index$iv++;
                }
                int selectedTabIndex222 = i422;
                ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
                invalid$iv4 = $composer2.changed($pageState);
                Composer $this$cache$iv1022 = $composer2;
                it$iv4 = $this$cache$iv1022.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv6222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        int TribeeHomeContent$lambda$16$14$2$0;
                        TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                        return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                    }
                };
                $this$cache$iv1022.updateRememberedValue(value$iv6222);
                it$iv4 = value$iv6222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final PagerState pagerState222 = PagerStateKt.rememberPagerState(selectedTabIndex222, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
                Integer valueOf3222 = Integer.valueOf(selectedTabIndex222);
                ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
                invalid$iv5 = $composer2.changed(pagerState222) | $composer2.changed(selectedTabIndex222);
                Composer $this$cache$iv2222 = $composer2;
                Object it$iv15222 = $this$cache$iv2222.rememberedValue();
                if (!invalid$iv5) {
                }
                $composer$iv$iv = $composer;
                continuation = null;
                Object value$iv23222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState222, selectedTabIndex222, null);
                $this$cache$iv2222.updateRememberedValue(value$iv23222);
                it$iv15222 = value$iv23222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf3222, (Function2) it$iv15222, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                invalid$iv6 = $composer2.changed(pagerState222) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                Composer $this$cache$iv322222 = $composer2;
                it$iv5 = $this$cache$iv322222.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv722222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState222, $pageState, $currentOnStateAction$delegate, continuation);
                $this$cache$iv322222.updateRememberedValue(value$iv722222);
                it$iv5 = value$iv722222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(pagerState222, (Function2) it$iv5, $composer2, 0);
                if ($pageState.getCategoryList().size() <= 1) {
                }
                Modifier modifier522222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight3222.getValue()).unbox-impl());
                ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                Composer $this$cache$iv922222 = $composer2;
                Object value$iv1322222 = $this$cache$iv922222.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv1322222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj2) {
                        Unit TribeeHomeContent$lambda$16$14$10$0;
                        TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                        return TribeeHomeContent$lambda$16$14$10$0;
                    }
                };
                $this$cache$iv922222.updateRememberedValue(value$iv1322222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TribeeDetailComposeKt.TribeeListPager($pageState, pagerState222, $fromSpmid, modifier522222, (Function1) value$iv1322222, $composer2, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if ($mine != null) {
                }
                kNavigationEntry = null;
                entry = kNavigationEntry;
                boolean hasDidTapEntryGameStats222222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                MutableState tabPosition$delegate6222222 = tabPosition$delegate3;
                invalid$iv8 = $composer.changed(hasDidTapEntryGameStats222222) | $composer.changed(entry) | $composer.changed($basicInfo);
                it$iv6 = $composer.rememberedValue();
                if (!invalid$iv8) {
                }
                if (entry != null) {
                }
                if (data instanceof KNavigationEntry.KGameStats) {
                }
                if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                }
                if ($basicInfo != null) {
                }
                z2 = false;
                if (!z2) {
                }
                z3 = z;
                Object value$iv142222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv142222222);
                it$iv6 = value$iv142222222;
                MutableState hasRedDot$delegate222222 = (MutableState) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                float TribeeHomeContent$lambda$16$9222222 = TribeeHomeContent$lambda$16$9(progress$delegate2);
                boolean TribeeHomeContent$lambda$16$17222222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate222222);
                ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                invalid$iv9 = $composer.changedInstance($router);
                it$iv7 = $composer.rememberedValue();
                if (!invalid$iv9) {
                }
                Object value$iv15222222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        Unit TribeeHomeContent$lambda$16$18$0;
                        TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                        return TribeeHomeContent$lambda$16$18$0;
                    }
                };
                $composer.updateRememberedValue(value$iv15222222);
                it$iv7 = value$iv15222222;
                Function0 function0322222 = (Function0) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                Object it$iv21222222 = $composer.rememberedValue();
                if (invalid$iv10) {
                }
                Object value$iv16222222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj2) {
                        Unit TribeeHomeContent$lambda$16$19$0;
                        TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                        return TribeeHomeContent$lambda$16$19$0;
                    }
                };
                $composer.updateRememberedValue(value$iv16222222);
                it$iv21222222 = value$iv16222222;
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$9222222, TribeeHomeContent$lambda$16$17222222, $basicInfo, null, function0322222, (Function1) it$iv21222222, $onUIAction, $composer, 0, 16);
                Modifier align222222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                Pair<IntSize, Float> TribeeHomeContent$lambda$16$12222222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate6222222);
                String str7222222 = str2;
                TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align222222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$12222222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$12222222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                KTribeeInteraction interaction322222 = $pageState.getInteraction();
                if (interaction322222 != null) {
                }
                if (it2 == null) {
                }
                if ($mine != null) {
                }
                $composer.endReplaceGroup();
                if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                invalid$iv11 = composer.changed($basicInfo);
                it$iv8 = $composer.rememberedValue();
                if (!invalid$iv11) {
                }
                continuation2 = null;
                Object value$iv21222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv21222222);
                it$iv8 = value$iv21222222;
                final MutableState showBubble$delegate222222 = (MutableState) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Continuation continuation4222222 = continuation2;
                TribeeHomeContentState tribeeHomeContentState3222222 = tribeeHomeContentState2;
                AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate222222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit TribeeHomeContent$lambda$16$28;
                        TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate222222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return TribeeHomeContent$lambda$16$28;
                    }
                }, composer, 54), $composer, 196656, 28);
                Long valueOf4222222 = Long.valueOf($pageState.getCategoryId());
                ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState3222222);
                it$iv9 = $composer.rememberedValue();
                if (!invalid$iv12) {
                }
                Object value$iv22222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState3222222, continuation4222222);
                $composer.updateRememberedValue(value$iv22222222);
                it$iv9 = value$iv22222222;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf4222222, (Function2) it$iv9, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            float f6 = Dp.constructor-impl(Dp.constructor-impl($this$BoxWithConstraints.getMaxHeight-D9Ej5fM() - NAVIGATION_HEIGHT) - $statusBarsTopPadding);
            Pair<IntSize, Float> TribeeHomeContent$lambda$16$13 = TribeeHomeContent$lambda$16$1(tabPosition$delegate4);
            if (TribeeHomeContent$lambda$16$13 != null) {
                $dirty = $dirty2;
                f = $density.toDp-u2uoSUM((int) (TribeeHomeContent$lambda$16$13.getFirst().unbox-impl() & 4294967295L));
            } else {
                $dirty = $dirty2;
                f = Dp.constructor-impl(0);
            }
            Object value$iv26 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(f6 - f)), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv26);
            it$iv11 = value$iv26;
            listHeight = (MutableState) it$iv11;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1953167848, "CC(remember):TribeeHomePage.kt#9igjgp");
            invalid$iv = $composer.changed(listHeight);
            Object it$iv122 = $composer.rememberedValue();
            if (!invalid$iv) {
                listHeight2 = listHeight;
                tabPosition$delegate = tabPosition$delegate4;
                MutableState pageHeight22 = (MutableState) it$iv122;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953180691, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv = $composer.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                final MutableFloatState pageScrollConsumeY$delegate22 = (MutableFloatState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953182643, "CC(remember):TribeeHomePage.kt#9igjgp");
                it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                }
                MutableFloatState progress$delegate22 = (MutableFloatState) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Float valueOf52 = Float.valueOf(TribeeHomeContent$lambda$16$6(pageScrollConsumeY$delegate22));
                ComposerKt.sourceInformationMarkerStart($composer, 1953185321, "CC(remember):TribeeHomePage.kt#9igjgp");
                invalid$iv2 = $composer.changed($pageScrollState);
                Object it$iv1322 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv322 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$1$1(pageScrollConsumeY$delegate22, $pageScrollState, null);
                $composer.updateRememberedValue(value$iv322);
                it$iv1322 = value$iv322;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf52, (Function2) it$iv1322, $composer, 0);
                Integer valueOf222 = Integer.valueOf($pageScrollState.getValue());
                ComposerKt.sourceInformationMarkerStart($composer, 1953191934, "CC(remember):TribeeHomePage.kt#9igjgp");
                invalid$iv3 = $composer.changed($pageScrollState) | $composer.changed($density);
                Object it$iv1422 = $composer.rememberedValue();
                if (!invalid$iv3) {
                }
                str = "CC(remember):TribeeHomePage.kt#9igjgp";
                Object value$iv2422 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$2$1($pageScrollState, $density, progress$delegate22, null);
                $composer.updateRememberedValue(value$iv2422);
                it$iv1422 = value$iv2422;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf222, (Function2) it$iv1422, $composer, 0);
                int $dirty32222 = $dirty;
                String str52222 = str;
                MutableState listHeight32222 = listHeight2;
                MutableState tabPosition$delegate52222 = tabPosition$delegate;
                int i4222 = -1;
                Modifier verticalScroll$default2222 = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight22.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str52222);
                it$iv3 = $composer.rememberedValue();
                if (it$iv3 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv2222 = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default2222, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv2222 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv2222 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2222, horizontalAlignment$iv2222, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2222 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2222 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2222 = ComposedModifierKt.materializeModifier($composer, modifier$iv2222);
                Function0 factory$iv$iv$iv22222 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2222 = (($changed$iv$iv2222 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                }
                $composer.startReusableNode();
                if (!$composer.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2222 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, measurePolicy$iv2222, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, localMap$iv$iv2222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2222, Integer.valueOf(compositeKeyHash$iv$iv2222), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2222, materialized$iv$iv2222, ComposeUiNode.Companion.getSetModifier());
                int i22222 = ($changed$iv$iv$iv2222 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2222 = ColumnScopeInstance.INSTANCE;
                int i32222 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
                if ($basicInfo == null) {
                }
                $composer2.endReplaceGroup();
                Iterable $this$indexOfFirst$iv2222 = $pageState.getCategoryList().keySet();
                index$iv = 0;
                it = $this$indexOfFirst$iv2222.iterator();
                while (true) {
                    if (it.hasNext()) {
                    }
                    index$iv++;
                }
                int selectedTabIndex2222 = i4222;
                ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
                invalid$iv4 = $composer2.changed($pageState);
                Composer $this$cache$iv10222 = $composer2;
                it$iv4 = $this$cache$iv10222.rememberedValue();
                if (!invalid$iv4) {
                }
                Object value$iv62222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                    public final Object invoke() {
                        int TribeeHomeContent$lambda$16$14$2$0;
                        TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                        return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                    }
                };
                $this$cache$iv10222.updateRememberedValue(value$iv62222);
                it$iv4 = value$iv62222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final PagerState pagerState2222 = PagerStateKt.rememberPagerState(selectedTabIndex2222, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
                Integer valueOf32222 = Integer.valueOf(selectedTabIndex2222);
                ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
                invalid$iv5 = $composer2.changed(pagerState2222) | $composer2.changed(selectedTabIndex2222);
                Composer $this$cache$iv22222 = $composer2;
                Object it$iv152222 = $this$cache$iv22222.rememberedValue();
                if (!invalid$iv5) {
                }
                $composer$iv$iv = $composer;
                continuation = null;
                Object value$iv232222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState2222, selectedTabIndex2222, null);
                $this$cache$iv22222.updateRememberedValue(value$iv232222);
                it$iv152222 = value$iv232222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(valueOf32222, (Function2) it$iv152222, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
                invalid$iv6 = $composer2.changed(pagerState2222) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
                Composer $this$cache$iv3222222 = $composer2;
                it$iv5 = $this$cache$iv3222222.rememberedValue();
                if (!invalid$iv6) {
                }
                Object value$iv7222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState2222, $pageState, $currentOnStateAction$delegate, continuation);
                $this$cache$iv3222222.updateRememberedValue(value$iv7222222);
                it$iv5 = value$iv7222222;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(pagerState2222, (Function2) it$iv5, $composer2, 0);
                if ($pageState.getCategoryList().size() <= 1) {
                }
                Modifier modifier5222222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight32222.getValue()).unbox-impl());
                ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
                invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
                Composer $this$cache$iv9222222 = $composer2;
                Object value$iv13222222 = $this$cache$iv9222222.rememberedValue();
                if (invalid$iv7) {
                }
                value$iv13222222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj2) {
                        Unit TribeeHomeContent$lambda$16$14$10$0;
                        TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                        return TribeeHomeContent$lambda$16$14$10$0;
                    }
                };
                $this$cache$iv9222222.updateRememberedValue(value$iv13222222);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TribeeDetailComposeKt.TribeeListPager($pageState, pagerState2222, $fromSpmid, modifier5222222, (Function1) value$iv13222222, $composer2, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if ($mine != null) {
                }
                kNavigationEntry = null;
                entry = kNavigationEntry;
                boolean hasDidTapEntryGameStats2222222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
                ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
                MutableState tabPosition$delegate62222222 = tabPosition$delegate3;
                invalid$iv8 = $composer.changed(hasDidTapEntryGameStats2222222) | $composer.changed(entry) | $composer.changed($basicInfo);
                it$iv6 = $composer.rememberedValue();
                if (!invalid$iv8) {
                }
                if (entry != null) {
                }
                if (data instanceof KNavigationEntry.KGameStats) {
                }
                if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
                }
                if ($basicInfo != null) {
                }
                z2 = false;
                if (!z2) {
                }
                z3 = z;
                Object value$iv1422222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv1422222222);
                it$iv6 = value$iv1422222222;
                MutableState hasRedDot$delegate2222222 = (MutableState) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                float TribeeHomeContent$lambda$16$92222222 = TribeeHomeContent$lambda$16$9(progress$delegate22);
                boolean TribeeHomeContent$lambda$16$172222222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate2222222);
                ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
                invalid$iv9 = $composer.changedInstance($router);
                it$iv7 = $composer.rememberedValue();
                if (!invalid$iv9) {
                }
                Object value$iv152222222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        Unit TribeeHomeContent$lambda$16$18$0;
                        TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                        return TribeeHomeContent$lambda$16$18$0;
                    }
                };
                $composer.updateRememberedValue(value$iv152222222);
                it$iv7 = value$iv152222222;
                Function0 function03222222 = (Function0) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
                invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
                Object it$iv212222222 = $composer.rememberedValue();
                if (invalid$iv10) {
                }
                Object value$iv162222222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj2) {
                        Unit TribeeHomeContent$lambda$16$19$0;
                        TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                        return TribeeHomeContent$lambda$16$19$0;
                    }
                };
                $composer.updateRememberedValue(value$iv162222222);
                it$iv212222222 = value$iv162222222;
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$92222222, TribeeHomeContent$lambda$16$172222222, $basicInfo, null, function03222222, (Function1) it$iv212222222, $onUIAction, $composer, 0, 16);
                Modifier align2222222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
                Pair<IntSize, Float> TribeeHomeContent$lambda$16$122222222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate62222222);
                String str72222222 = str2;
                TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align2222222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$122222222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$122222222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
                KTribeeInteraction interaction3222222 = $pageState.getInteraction();
                if (interaction3222222 != null) {
                }
                if (it2 == null) {
                }
                if ($mine != null) {
                }
                $composer.endReplaceGroup();
                if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
                invalid$iv11 = composer.changed($basicInfo);
                it$iv8 = $composer.rememberedValue();
                if (!invalid$iv11) {
                }
                continuation2 = null;
                Object value$iv212222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv212222222);
                it$iv8 = value$iv212222222;
                final MutableState showBubble$delegate2222222 = (MutableState) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Continuation continuation42222222 = continuation2;
                TribeeHomeContentState tribeeHomeContentState32222222 = tribeeHomeContentState2;
                AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate2222222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit TribeeHomeContent$lambda$16$28;
                        TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate2222222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                        return TribeeHomeContent$lambda$16$28;
                    }
                }, composer, 54), $composer, 196656, 28);
                Long valueOf42222222 = Long.valueOf($pageState.getCategoryId());
                ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
                invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState32222222);
                it$iv9 = $composer.rememberedValue();
                if (!invalid$iv12) {
                }
                Object value$iv222222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState32222222, continuation42222222);
                $composer.updateRememberedValue(value$iv222222222);
                it$iv9 = value$iv222222222;
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(valueOf42222222, (Function2) it$iv9, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            float f52 = ((Dp) listHeight.getValue()).unbox-impl();
            $this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240 = TribeeHomeContent$lambda$16$1(tabPosition$delegate4);
            if ($this$TribeeHomeContent_u24lambda_u2416_u244_u240_u240 != null) {
            }
            Object value$iv252 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(f52 + f2)), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv252);
            it$iv122 = value$iv252;
            MutableState pageHeight222 = (MutableState) it$iv122;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1953180691, "CC(remember):TribeeHomePage.kt#9igjgp");
            it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            final MutableFloatState pageScrollConsumeY$delegate222 = (MutableFloatState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1953182643, "CC(remember):TribeeHomePage.kt#9igjgp");
            it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            MutableFloatState progress$delegate222 = (MutableFloatState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Float valueOf522 = Float.valueOf(TribeeHomeContent$lambda$16$6(pageScrollConsumeY$delegate222));
            ComposerKt.sourceInformationMarkerStart($composer, 1953185321, "CC(remember):TribeeHomePage.kt#9igjgp");
            invalid$iv2 = $composer.changed($pageScrollState);
            Object it$iv13222 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$1$1(pageScrollConsumeY$delegate222, $pageScrollState, null);
            $composer.updateRememberedValue(value$iv3222);
            it$iv13222 = value$iv3222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf522, (Function2) it$iv13222, $composer, 0);
            Integer valueOf2222 = Integer.valueOf($pageScrollState.getValue());
            ComposerKt.sourceInformationMarkerStart($composer, 1953191934, "CC(remember):TribeeHomePage.kt#9igjgp");
            invalid$iv3 = $composer.changed($pageScrollState) | $composer.changed($density);
            Object it$iv14222 = $composer.rememberedValue();
            if (!invalid$iv3) {
            }
            str = "CC(remember):TribeeHomePage.kt#9igjgp";
            Object value$iv24222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$2$1($pageScrollState, $density, progress$delegate222, null);
            $composer.updateRememberedValue(value$iv24222);
            it$iv14222 = value$iv24222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf2222, (Function2) it$iv14222, $composer, 0);
            int $dirty322222 = $dirty;
            String str522222 = str;
            MutableState listHeight322222 = listHeight2;
            MutableState tabPosition$delegate522222 = tabPosition$delegate;
            int i42222 = -1;
            Modifier verticalScroll$default22222 = ScrollKt.verticalScroll$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) pageHeight222.getValue()).unbox-impl()), $pageScrollState, false, (FlingBehavior) null, false, 14, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1953212618, str522222);
            it$iv3 = $composer.rememberedValue();
            if (it$iv3 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv22222 = NestedScrollModifierKt.nestedScroll$default(verticalScroll$default22222, (TribeeHomePageKt$TribeeHomeContent$5$3$1) it$iv3, (NestedScrollDispatcher) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv22222 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv22222 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv22222 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22222, horizontalAlignment$iv22222, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv22222 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv22222 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22222 = ComposedModifierKt.materializeModifier($composer, modifier$iv22222);
            Function0 factory$iv$iv$iv222222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22222 = (($changed$iv$iv22222 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
            }
            $composer.startReusableNode();
            if (!$composer.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22222 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, measurePolicy$iv22222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, localMap$iv$iv22222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22222, Integer.valueOf(compositeKeyHash$iv$iv22222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22222, materialized$iv$iv22222, ComposeUiNode.Companion.getSetModifier());
            int i222222 = ($changed$iv$iv$iv22222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope22222 = ColumnScopeInstance.INSTANCE;
            int i322222 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 895270220, "C561@22858L67,561@22821L104,564@22971L73,564@22938L106,567@23084L411,567@23057L438,631@25750L335,623@25435L665:TribeeHomePage.kt#iitu82");
            if ($basicInfo == null) {
            }
            $composer2.endReplaceGroup();
            Iterable $this$indexOfFirst$iv22222 = $pageState.getCategoryList().keySet();
            index$iv = 0;
            it = $this$indexOfFirst$iv22222.iterator();
            while (true) {
                if (it.hasNext()) {
                }
                index$iv++;
            }
            int selectedTabIndex22222 = i42222;
            ComposerKt.sourceInformationMarkerStart($composer2, -1495116120, str2);
            invalid$iv4 = $composer2.changed($pageState);
            Composer $this$cache$iv102222 = $composer2;
            it$iv4 = $this$cache$iv102222.rememberedValue();
            if (!invalid$iv4) {
            }
            Object value$iv622222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda20
                public final Object invoke() {
                    int TribeeHomeContent$lambda$16$14$2$0;
                    TribeeHomeContent$lambda$16$14$2$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState.this);
                    return Integer.valueOf(TribeeHomeContent$lambda$16$14$2$0);
                }
            };
            $this$cache$iv102222.updateRememberedValue(value$iv622222);
            it$iv4 = value$iv622222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final PagerState pagerState22222 = PagerStateKt.rememberPagerState(selectedTabIndex22222, 0.0f, (Function0) it$iv4, $composer2, 0, 2);
            Integer valueOf322222 = Integer.valueOf(selectedTabIndex22222);
            ComposerKt.sourceInformationMarkerStart($composer2, -1495112498, str2);
            invalid$iv5 = $composer2.changed(pagerState22222) | $composer2.changed(selectedTabIndex22222);
            Composer $this$cache$iv222222 = $composer2;
            Object it$iv1522222 = $this$cache$iv222222.rememberedValue();
            if (!invalid$iv5) {
            }
            $composer$iv$iv = $composer;
            continuation = null;
            Object value$iv2322222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$2$1(pagerState22222, selectedTabIndex22222, null);
            $this$cache$iv222222.updateRememberedValue(value$iv2322222);
            it$iv1522222 = value$iv2322222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf322222, (Function2) it$iv1522222, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, -1495108544, str2);
            invalid$iv6 = $composer2.changed(pagerState22222) | $composer2.changed($pageState) | $composer2.changed($currentOnStateAction$delegate);
            Composer $this$cache$iv32222222 = $composer2;
            it$iv5 = $this$cache$iv32222222.rememberedValue();
            if (!invalid$iv6) {
            }
            Object value$iv72222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$4$3$1(pagerState22222, $pageState, $currentOnStateAction$delegate, continuation);
            $this$cache$iv32222222.updateRememberedValue(value$iv72222222);
            it$iv5 = value$iv72222222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(pagerState22222, (Function2) it$iv5, $composer2, 0);
            if ($pageState.getCategoryList().size() <= 1) {
            }
            Modifier modifier52222222 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ((Dp) listHeight322222.getValue()).unbox-impl());
            ComposerKt.sourceInformationMarkerStart($composer2, -1495023308, str2);
            invalid$iv7 = $composer2.changedInstance($router) | $composer2.changed($pageState) | $composer2.changed($onStateAction) | $composer2.changed($updateToasterDialog);
            Composer $this$cache$iv92222222 = $composer2;
            Object value$iv132222222 = $this$cache$iv92222222.rememberedValue();
            if (invalid$iv7) {
            }
            value$iv132222222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda27
                public final Object invoke(Object obj2) {
                    Unit TribeeHomeContent$lambda$16$14$10$0;
                    TribeeHomeContent$lambda$16$14$10$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$14$10$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                    return TribeeHomeContent$lambda$16$14$10$0;
                }
            };
            $this$cache$iv92222222.updateRememberedValue(value$iv132222222);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TribeeDetailComposeKt.TribeeListPager($pageState, pagerState22222, $fromSpmid, modifier52222222, (Function1) value$iv132222222, $composer2, 0, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if ($mine != null) {
            }
            kNavigationEntry = null;
            entry = kNavigationEntry;
            boolean hasDidTapEntryGameStats22222222 = TribeePreference.INSTANCE.getHasDidTapEntryGameStats();
            ComposerKt.sourceInformationMarkerStart($composer, 1953406440, str2);
            MutableState tabPosition$delegate622222222 = tabPosition$delegate3;
            invalid$iv8 = $composer.changed(hasDidTapEntryGameStats22222222) | $composer.changed(entry) | $composer.changed($basicInfo);
            it$iv6 = $composer.rememberedValue();
            if (!invalid$iv8) {
            }
            if (entry != null) {
            }
            if (data instanceof KNavigationEntry.KGameStats) {
            }
            if ((kGameStats != null || (value = kGameStats.getValue()) == null || value.isBind()) ? false : true) {
            }
            if ($basicInfo != null) {
            }
            z2 = false;
            if (!z2) {
            }
            z3 = z;
            Object value$iv14222222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(z3), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv14222222222);
            it$iv6 = value$iv14222222222;
            MutableState hasRedDot$delegate22222222 = (MutableState) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            float TribeeHomeContent$lambda$16$922222222 = TribeeHomeContent$lambda$16$9(progress$delegate222);
            boolean TribeeHomeContent$lambda$16$1722222222 = TribeeHomeContent$lambda$16$17(hasRedDot$delegate22222222);
            ComposerKt.sourceInformationMarkerStart($composer, 1953424466, str2);
            invalid$iv9 = $composer.changedInstance($router);
            it$iv7 = $composer.rememberedValue();
            if (!invalid$iv9) {
            }
            Object value$iv1522222222 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda28
                public final Object invoke() {
                    Unit TribeeHomeContent$lambda$16$18$0;
                    TribeeHomeContent$lambda$16$18$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$18$0(Router.this, $showDrawer$delegate);
                    return TribeeHomeContent$lambda$16$18$0;
                }
            };
            $composer.updateRememberedValue(value$iv1522222222);
            it$iv7 = value$iv1522222222;
            Function0 function032222222 = (Function0) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1953433022, str2);
            invalid$iv10 = $composer.changedInstance($router) | $composer.changed($pageState) | $composer.changed($onStateAction) | $composer.changed($updateToasterDialog);
            Object it$iv2122222222 = $composer.rememberedValue();
            if (invalid$iv10) {
            }
            Object value$iv1622222222 = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj2) {
                    Unit TribeeHomeContent$lambda$16$19$0;
                    TribeeHomeContent$lambda$16$19$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$19$0(Router.this, $pageState, $onStateAction, $updateToasterDialog, (TribeeHomeStateAction) obj2);
                    return TribeeHomeContent$lambda$16$19$0;
                }
            };
            $composer.updateRememberedValue(value$iv1622222222);
            it$iv2122222222 = value$iv1622222222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeDetailComposeKt.m696NavigationRowpzZJ40c($tribeeColor, TribeeHomeContent$lambda$16$922222222, TribeeHomeContent$lambda$16$1722222222, $basicInfo, null, function032222222, (Function1) it$iv2122222222, $onUIAction, $composer, 0, 16);
            Modifier align22222222 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getTopCenter());
            Pair<IntSize, Float> TribeeHomeContent$lambda$16$1222222222 = TribeeHomeContent$lambda$16$1(tabPosition$delegate622222222);
            String str722222222 = str2;
            TribeeDetailComposeKt.RefreshIndicator($isRefreshing, $refreshState, PaddingKt.padding-qDBjuR0$default(align22222222, 0.0f, Dp.constructor-impl((TribeeHomeContent$lambda$16$1222222222 != null ? $density.toDp-u2uoSUM(TribeeHomeContent$lambda$16$1222222222.getSecond().floatValue()) : NAVIGATION_HEIGHT) + Dp.constructor-impl(60)), 0.0f, 0.0f, 13, (Object) null), $composer, 0, 0);
            KTribeeInteraction interaction32222222 = $pageState.getInteraction();
            if (interaction32222222 != null) {
            }
            if (it2 == null) {
            }
            if ($mine != null) {
            }
            $composer.endReplaceGroup();
            if (TribeeHomeContent$lambda$11($shareParams$delegate) != null) {
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer, 1953531866, str4);
            invalid$iv11 = composer.changed($basicInfo);
            it$iv8 = $composer.rememberedValue();
            if (!invalid$iv11) {
            }
            continuation2 = null;
            Object value$iv2122222222 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(((($basicInfo != null || $basicInfo.isNewCodePopup() != r6) ? false : r6) || StringsKt.isBlank($basicInfo.getNewCodePopupText())) ? false : r6), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv2122222222);
            it$iv8 = value$iv2122222222;
            final MutableState showBubble$delegate22222222 = (MutableState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Continuation continuation422222222 = continuation2;
            TribeeHomeContentState tribeeHomeContentState322222222 = tribeeHomeContentState2;
            AnimatedVisibilityKt.AnimatedVisibility(TribeeHomeContent$lambda$16$26(showBubble$delegate22222222), SizeKt.fillMaxSize$default(Modifier.Companion, f4, (int) r6, continuation2), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-245292857, (boolean) r6, new Function3() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit TribeeHomeContent$lambda$16$28;
                    TribeeHomeContent$lambda$16$28 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28($basicInfo, showBubble$delegate22222222, function12, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeeHomeContent$lambda$16$28;
                }
            }, composer, 54), $composer, 196656, 28);
            Long valueOf422222222 = Long.valueOf($pageState.getCategoryId());
            ComposerKt.sourceInformationMarkerStart(composer, 1953556839, str4);
            invalid$iv12 = composer.changed($fromSpmid) | composer.changedInstance($basicInfo) | composer.changed(tribeeHomeContentState322222222);
            it$iv9 = $composer.rememberedValue();
            if (!invalid$iv12) {
            }
            Object value$iv2222222222 = (Function2) new TribeeHomePageKt$TribeeHomeContent$5$13$1($fromSpmid, $basicInfo, tribeeHomeContentState322222222, continuation422222222);
            $composer.updateRememberedValue(value$iv2222222222);
            it$iv9 = value$iv2222222222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf422222222, (Function2) it$iv9, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final Pair<IntSize, Float> TribeeHomeContent$lambda$16$1(MutableState<Pair<IntSize, Float>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Pair) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float TribeeHomeContent$lambda$16$6(MutableFloatState $pageScrollConsumeY$delegate) {
        FloatState $this$getValue$iv = (FloatState) $pageScrollConsumeY$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    private static final float TribeeHomeContent$lambda$16$9(MutableFloatState $progress$delegate) {
        FloatState $this$getValue$iv = (FloatState) $progress$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$0$0(Router $router, TribeeHomeContentState $pageState, Function1 $onStateAction, Function1 $updateToasterDialog, TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        checkTribeeHomePermission(it, $router, $pageState, $onStateAction, $updateToasterDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int TribeeHomeContent$lambda$16$14$2$0(TribeeHomeContentState $pageState) {
        return $pageState.getCategoryList().size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$5$0(long $tribeeColor, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBehind, $tribeeColor, 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$6$0(MutableState $tabPosition$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IntSize intSize = IntSize.box-impl(it.getSize-YbymL2g());
        int bits$iv$iv$iv = (int) (4294967295L & LayoutCoordinatesKt.positionInParent(it));
        $tabPosition$delegate.setValue(TuplesKt.to(intSize, Float.valueOf(Float.intBitsToFloat(bits$iv$iv$iv))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$7$0(CoroutineScope $scope, PagerState $pagerState, int index) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeHomePageKt$TribeeHomeContent$5$4$6$1$1($pagerState, index, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$8$0(long $tribeeColor, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBehind, $tribeeColor, 0L, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$9$0(MutableState $tabPosition$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        IntSize intSize = IntSize.box-impl(it.getSize-YbymL2g());
        int bits$iv$iv$iv = (int) (4294967295L & LayoutCoordinatesKt.positionInParent(it));
        $tabPosition$delegate.setValue(TuplesKt.to(intSize, Float.valueOf(Float.intBitsToFloat(bits$iv$iv$iv))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$14$10$0(Router $router, TribeeHomeContentState $pageState, Function1 $onStateAction, Function1 $updateToasterDialog, TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        checkTribeeHomePermission(it, $router, $pageState, $onStateAction, $updateToasterDialog);
        return Unit.INSTANCE;
    }

    private static final boolean TribeeHomeContent$lambda$16$17(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$18$0(Router $router, MutableState $showDrawer$delegate) {
        if (TribeeExtensionsKt.checkAndLogin($router)) {
            return Unit.INSTANCE;
        }
        TribeeHomeContent$lambda$9($showDrawer$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$19$0(Router $router, TribeeHomeContentState $pageState, Function1 $onStateAction, Function1 $updateToasterDialog, TribeeHomeStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        checkTribeeHomePermission(it, $router, $pageState, $onStateAction, $updateToasterDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$21$0$0(Router $router, TribeeHomeContentState $pageState, Function1 $onStateAction, Function1 $updateToasterDialog, TribeeHomeStateAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        checkTribeeHomePermission(action, $router, $pageState, $onStateAction, $updateToasterDialog);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$23$0(MutableState $showDrawer$delegate) {
        TribeeHomeContent$lambda$9($showDrawer$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$22$0(TribeeHomeContentState $pageState, String $fromSpmid, MutableState $shareParams$delegate) {
        String str;
        KTribeeDesc tribeeInfo;
        KTribeeBaseInfo baseInfo = $pageState.getBaseInfo();
        if (baseInfo == null || (tribeeInfo = baseInfo.getTribeeInfo()) == null) {
            str = null;
        } else {
            str = String.valueOf(tribeeInfo.getId());
        }
        if (str == null) {
            str = "";
        }
        $shareParams$delegate.setValue(new ShareParams(TribeeExtensionsKt.PAGE_PV, str, "tribee", "", new ShareParams.PageInfo(TribeeExtensionsKt.SPMID, null, $fromSpmid, MapsKt.mapOf(TuplesKt.to("handler", "tribee")), null, 18, null), null, 32, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$24$0(MutableState $shareParams$delegate) {
        $shareParams$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    private static final boolean TribeeHomeContent$lambda$16$26(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeHomeContent$lambda$16$27(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$28(KTribeeBaseInfo $basicInfo, final MutableState $showBubble$delegate, final Function1 $onStateAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C769@30601L302,767@30481L437:TribeeHomePage.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245292857, $changed, -1, "kntr.app.tribee.consume.page.TribeeHomeContent.<anonymous>.<anonymous> (TribeeHomePage.kt:767)");
        }
        String newCodePopupText = $basicInfo != null ? $basicInfo.getNewCodePopupText() : null;
        if (newCodePopupText == null) {
            newCodePopupText = "";
        }
        String str = newCodePopupText;
        ComposerKt.sourceInformationMarkerStart($composer, 496770293, "CC(remember):TribeeHomePage.kt#9igjgp");
        boolean invalid$iv = $composer.changed($showBubble$delegate) | $composer.changed($onStateAction);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit TribeeHomeContent$lambda$16$28$0$0;
                    TribeeHomeContent$lambda$16$28$0$0 = TribeeHomePageKt.TribeeHomeContent$lambda$16$28$0$0($onStateAction, $showBubble$delegate);
                    return TribeeHomeContent$lambda$16$28$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TribeeInviteCodeBubbleKt.TribeeInviteCodeBubble(str, (Function0) it$iv, null, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeHomeContent$lambda$16$28$0$0(Function1 $onStateAction, MutableState $showBubble$delegate) {
        TribeeHomeContent$lambda$16$27($showBubble$delegate, false);
        $onStateAction.invoke(new TribeeHomeStateAction.ReportNotification(true, true));
        return Unit.INSTANCE;
    }

    public static final void checkTribeeHomePermission(final TribeeHomeStateAction action, Router router, final TribeeHomeContentState pageState, Function1<? super TribeeHomeStateAction, Unit> function1, Function1<? super KToastDialog, Unit> function12) {
        KExitTribeeToast exit;
        KJoinButton join;
        KJoinButton join2;
        KJoinButton join3;
        KGlobalPermissionType permType;
        KPublishButton publish;
        String uri;
        Builder buildUpon;
        Builder appendQueryParameter;
        Uri it;
        KPublishButton publish2;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(router, "router");
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Intrinsics.checkNotNullParameter(function1, "onStateAction");
        Intrinsics.checkNotNullParameter(function12, "updateToasterDialog");
        if (action.needCheckLogin() && TribeeExtensionsKt.checkAndLogin(router)) {
            function12.invoke((Object) null);
        } else if (!action.needCheckPermission()) {
            function1.invoke(action);
            function12.invoke((Object) null);
        } else {
            KTribeeBaseInfo baseInfo = pageState.getBaseInfo();
            Boolean isJoined = baseInfo != null ? Boolean.valueOf(baseInfo.isJoined()) : null;
            Function1 getPermissionToastDialog = new Function1() { // from class: kntr.app.tribee.consume.page.TribeeHomePageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    KToastDialog checkTribeeHomePermission$lambda$0;
                    checkTribeeHomePermission$lambda$0 = TribeeHomePageKt.checkTribeeHomePermission$lambda$0(TribeeHomeStateAction.this, pageState, (KGlobalPermissionType) obj);
                    return checkTribeeHomePermission$lambda$0;
                }
            };
            if (action instanceof TribeeHomeStateAction.GoToPublish) {
                boolean z = true;
                if (Intrinsics.areEqual(isJoined, true)) {
                    KTribeeInteraction interaction = pageState.getInteraction();
                    KToastDialog dialog = (KToastDialog) getPermissionToastDialog.invoke((interaction == null || (publish2 = interaction.getPublish()) == null) ? null : publish2.getPermType());
                    if (dialog == null) {
                        KTribeeInteraction interaction2 = pageState.getInteraction();
                        if (interaction2 != null && (publish = interaction2.getPublish()) != null && (uri = publish.getJumpUri()) != null) {
                            TribeeResultChannel.INSTANCE.prepareChannel(((TribeeHomeStateAction.GoToPublish) action).getResultKey());
                            Uri parseOrNull = Uri.Companion.parseOrNull(uri);
                            if (parseOrNull != null && (buildUpon = parseOrNull.buildUpon()) != null && (appendQueryParameter = buildUpon.appendQueryParameter("result_key", ((TribeeHomeStateAction.GoToPublish) action).getResultKey())) != null && (it = appendQueryParameter.build()) != null) {
                                router.launch(it);
                                function1.invoke(new TribeeHomeStateAction.AwaitPublishResult(((TribeeHomeStateAction.GoToPublish) action).getResultKey()));
                            }
                        }
                        function12.invoke((Object) null);
                        return;
                    }
                    function12.invoke(dialog);
                    return;
                }
                KTribeeInteraction interaction3 = pageState.getInteraction();
                if (interaction3 == null || (join3 = interaction3.getJoin()) == null || (permType = join3.getPermType()) == null || !TribeeExtensionsKt.enableJoin(permType)) {
                    z = false;
                }
                if (z) {
                    KPublishButton publish3 = pageState.getInteraction().getPublish();
                    function12.invoke(publish3 != null ? publish3.getPublishJoin() : null);
                    return;
                }
                KTribeeInteraction interaction4 = pageState.getInteraction();
                if (interaction4 != null && (join2 = interaction4.getJoin()) != null) {
                    r1 = join2.getPermType();
                }
                function12.invoke(getPermissionToastDialog.invoke(r1));
            } else if (action instanceof TribeeHomeStateAction.ToJoinTribee) {
                KTribeeInteraction interaction5 = pageState.getInteraction();
                KToastDialog dialog2 = (KToastDialog) getPermissionToastDialog.invoke((interaction5 == null || (join = interaction5.getJoin()) == null) ? null : join.getPermType());
                if (dialog2 == null) {
                    function1.invoke(TribeeHomeStateAction.ToJoinTribee.INSTANCE);
                    function12.invoke((Object) null);
                    return;
                }
                function12.invoke(dialog2);
            } else if (action instanceof TribeeHomeStateAction.ToExitTribee) {
                KTribeeInteraction interaction6 = pageState.getInteraction();
                if (interaction6 != null && (exit = interaction6.getExit()) != null) {
                    r1 = exit.getToastDialog();
                }
                function12.invoke(r1);
            } else {
                function1.invoke(action);
                function12.invoke((Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KToastDialog checkTribeeHomePermission$lambda$0(TribeeHomeStateAction $action, TribeeHomeContentState $pageState, KGlobalPermissionType permType) {
        KTribeeInteraction interaction;
        KPublishButton publish;
        KTribeeInteraction interaction2;
        KJoinButton join;
        KPublishButton publish2;
        KTribeeInteraction interaction3;
        KJoinButton join2;
        KPublishButton publish3;
        KTribeeInteraction interaction4;
        KPublishButton publish4;
        if (Intrinsics.areEqual(permType, KGlobalPermissionType.QUALIFIED.INSTANCE)) {
            return null;
        }
        if (Intrinsics.areEqual(permType, KGlobalPermissionType.QUALIFIED_BUT_BANNED.INSTANCE)) {
            if (!($action instanceof TribeeHomeStateAction.GoToPublish) || (interaction4 = $pageState.getInteraction()) == null || (publish4 = interaction4.getPublish()) == null) {
                return null;
            }
            return publish4.getPublishBanned();
        } else if (Intrinsics.areEqual(permType, KGlobalPermissionType.WHITELIST.INSTANCE)) {
            return null;
        } else {
            if (Intrinsics.areEqual(permType, KGlobalPermissionType.CANDIDATE_LIST.INSTANCE)) {
                if ($action instanceof TribeeHomeStateAction.GoToPublish) {
                    KTribeeInteraction interaction5 = $pageState.getInteraction();
                    if (interaction5 == null || (publish3 = interaction5.getPublish()) == null) {
                        return null;
                    }
                    return publish3.getPublishCandidate();
                } else if (!($action instanceof TribeeHomeStateAction.ToJoinTribee) || (interaction3 = $pageState.getInteraction()) == null || (join2 = interaction3.getJoin()) == null) {
                    return null;
                } else {
                    return join2.getJoinCandidate();
                }
            } else if (Intrinsics.areEqual(permType, KGlobalPermissionType.NOT_CANDIDATE_LIST.INSTANCE)) {
                if ($action instanceof TribeeHomeStateAction.GoToPublish) {
                    KTribeeInteraction interaction6 = $pageState.getInteraction();
                    if (interaction6 == null || (publish2 = interaction6.getPublish()) == null) {
                        return null;
                    }
                    return publish2.getPublishNotCandidate();
                } else if (!($action instanceof TribeeHomeStateAction.ToJoinTribee) || (interaction2 = $pageState.getInteraction()) == null || (join = interaction2.getJoin()) == null) {
                    return null;
                } else {
                    return join.getJoinNotCandidate();
                }
            } else if (!Intrinsics.areEqual(permType, KGlobalPermissionType.NOT_WHITELIST.INSTANCE) || (interaction = $pageState.getInteraction()) == null || (publish = interaction.getPublish()) == null) {
                return null;
            } else {
                return publish.getPublishAbnormal();
            }
        }
    }
}