package kntr.common.photonic.aphro.ui.component;

import ComposableSingletons$CustomBottomSheetKt$;
import android.app.Activity;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import bili.resource.following.Plurals0_commonMainKt;
import bili.resource.following.Res;
import bili.resource.following.String1_commonMainKt;
import bili.resource.others.OthersRes;
import bili.resource.others.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreGridStateKt;
import kntr.common.compose.list.ReachedEdgeState;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewLauncher_androidKt;
import kntr.common.photonic.aphro.ui.preview.ImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewDataNotifier;
import kntr.common.photonic.aphro.ui.preview.model.ImagePreviewSelectResult;
import kntr.common.photonic.aphro.ui.preview.model.PageImagePreviewType;
import kntr.common.photonic.aphro.ui.preview.model.PreviewImageData;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAsset;
import kntr.common.photonic.aphro.ui.preview.model.PreviewableAssetKt;
import kntr.common.photonic.permission.PlatformContext_androidKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.datetime.Clock;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.Instant;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.LocalDateKt;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.TimeZone;
import kotlinx.datetime.TimeZoneKt;
import org.jetbrains.compose.resources.PluralStringResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: MediaList.kt */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001aË\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\n2 \b\u0002\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\b\r¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112&\b\u0002\u0010\u0012\u001a \u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0004\u0012\u00020\u00030\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a_\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u00112\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0004\b\u001f\u0010 \u001a3\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00150\u00152\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010%\u001a\u0011\u0010*\u001a\u00020+*\u00020'H\u0007¢\u0006\u0002\u0010,\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006-²\u0006\n\u0010.\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010/\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\f\u00100\u001a\u0004\u0018\u000101X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"MEDIA_LIST_COLUMNS_COUNT", "", "GridMediaList", "", "state", "Lkntr/common/photonic/aphro/core/AphroState$AphroContent;", "onAction", "Lkotlin/Function1;", "Lkntr/common/photonic/aphro/core/AphroAction;", "modifier", "Landroidx/compose/ui/Modifier;", "shootContent", "Landroidx/compose/foundation/lazy/grid/LazyGridItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "captureVideoContent", "showDate", "", "onAssetItemClick", "Lkotlin/Function3;", "Lkntr/common/photonic/aphro/core/AssetItemState;", "", "Landroidx/compose/ui/unit/IntRect;", "showSelectIndex", "nestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "extraPadding", "Landroidx/compose/ui/unit/Dp;", "GridMediaList-aqv2aB4", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollConnection;FLandroidx/compose/runtime/Composer;II)V", "MediaList", "MediaList-au3_HiA", "(Lkntr/common/photonic/aphro/core/AphroState$AphroContent;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/input/nestedscroll/NestedScrollConnection;FLandroidx/compose/runtime/Composer;II)V", "DateLabel", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "mediaItemsRows", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "zeroInstant", "Lkotlinx/datetime/Instant;", "getZeroInstant", "()Lkotlinx/datetime/Instant;", "toDateString", "", "(Lkotlinx/datetime/Instant;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui_debug", "index", "firstOffset", "job", "Lkotlinx/coroutines/Job;", "dateVisible"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaListKt {
    public static final int MEDIA_LIST_COLUMNS_COUNT = 4;
    private static final Instant zeroInstant = Instant.Companion.fromEpochMilliseconds(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateLabel$lambda$12(LazyListState lazyListState, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DateLabel(lazyListState, list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridMediaList_aqv2aB4$lambda$3(AphroState.AphroContent aphroContent, Function1 function1, Modifier modifier, Function3 function3, Function3 function32, boolean z, Function3 function33, boolean z2, NestedScrollConnection nestedScrollConnection, float f, int i, int i2, Composer composer, int i3) {
        m2263GridMediaListaqv2aB4(aphroContent, function1, modifier, function3, function32, z, function33, z2, nestedScrollConnection, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaList_au3_HiA$lambda$1(AphroState.AphroContent aphroContent, Function1 function1, Modifier modifier, boolean z, boolean z2, NestedScrollConnection nestedScrollConnection, float f, int i, int i2, Composer composer, int i3) {
        m2264MediaListau3_HiA(aphroContent, function1, modifier, z, z2, nestedScrollConnection, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridMediaList_aqv2aB4$lambda$0$0(int i, AssetItemState assetItemState, List list) {
        Intrinsics.checkNotNullParameter(assetItemState, "<unused var>");
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04ae  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x04b7  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x04b9  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x04c4  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x057e  */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* renamed from: GridMediaList-aqv2aB4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2263GridMediaListaqv2aB4(final AphroState.AphroContent state, final Function1<? super AphroAction, Unit> function1, Modifier modifier, Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function3, Function3<? super LazyGridItemScope, ? super Composer, ? super Integer, Unit> function32, boolean showDate, Function3<? super Integer, ? super AssetItemState, ? super List<IntRect>, Unit> function33, boolean showSelectIndex, NestedScrollConnection nestedScrollConnection, float f, Composer $composer, final int $changed, final int i) {
        Function3 function34;
        Modifier modifier2;
        Function3 captureVideoContent;
        boolean showDate2;
        Function3 onAssetItemClick;
        boolean showSelectIndex2;
        NestedScrollConnection nestedScrollConnection2;
        float f2;
        Function3 shootContent;
        Function0 factory$iv$iv$iv;
        Alignment contentAlignment$iv;
        Object value$iv;
        boolean predict$iv;
        Modifier it;
        boolean invalid$iv;
        Object value$iv2;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(1903893799);
        ComposerKt.sourceInformation($composer3, "C(GridMediaList)N(state,onAction,modifier,shootContent,captureVideoContent,showDate,onAssetItemClick,showSelectIndex,nestedScrollConnection,extraPadding:c#ui.unit.Dp)98@4463L14,103@4640L7,104@4672L23,106@4726L118,111@4898L51,111@4864L85,115@4955L2589:MediaList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function34 = function3;
        } else if (($changed & 3072) == 0) {
            function34 = function3;
            $dirty |= $composer3.changedInstance(function34) ? 2048 : 1024;
        } else {
            function34 = function3;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function32) ? 16384 : 8192;
        }
        int i5 = i & 64;
        if (i5 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changedInstance(function33) ? 1048576 : 524288;
        }
        int i6 = i & 128;
        if (i6 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(showSelectIndex) ? 8388608 : 4194304;
        }
        int i7 = i & 256;
        if (i7 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changedInstance(nestedScrollConnection) ? 67108864 : 33554432;
        }
        int i8 = i & 512;
        if (i8 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changed(f) ? 536870912 : 268435456;
        }
        if ($composer3.shouldExecute(($dirty & 306717843) != 306717842, $dirty & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            shootContent = i3 != 0 ? null : function34;
            captureVideoContent = i4 != 0 ? null : function32;
            showDate2 = (i & 32) != 0 ? true : showDate;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -14115307, "CC(remember):MediaList.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit GridMediaList_aqv2aB4$lambda$0$0;
                            GridMediaList_aqv2aB4$lambda$0$0 = MediaListKt.GridMediaList_aqv2aB4$lambda$0$0(((Integer) obj).intValue(), (AssetItemState) obj2, (List) obj3);
                            return GridMediaList_aqv2aB4$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv = value$iv3;
                }
                Function3 onAssetItemClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onAssetItemClick = onAssetItemClick2;
            } else {
                onAssetItemClick = function33;
            }
            showSelectIndex2 = i6 != 0 ? true : showSelectIndex;
            NestedScrollConnection nestedScrollConnection3 = i7 != 0 ? null : nestedScrollConnection;
            f2 = i8 != 0 ? Dp.constructor-impl(0) : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1903893799, $dirty, -1, "kntr.common.photonic.aphro.ui.component.GridMediaList (MediaList.kt:102)");
            }
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Toaster toaster = (Toaster) consume;
            LazyGridState lazyGridState = LazyGridStateKt.rememberLazyGridState(0, 0, $composer3, 0, 3);
            final String toastString = StringResourcesKt.stringResource(String1_commonMainKt.getFollowing_global_string_736(Res.string.INSTANCE), new Object[]{Integer.valueOf(state.getOption().getMaxSelectCount())}, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -14101350, "CC(remember):MediaList.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 112) == 32;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv4 = (Function1) new MediaListKt$GridMediaList$2$1(function1, null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LoadMoreGridStateKt.applyLoadMoreEffects(lazyGridState, 20, (Function1<? super ReachedEdgeState, Boolean>) null, (Function1) it$iv2, $composer3, 48, 2);
            int $changed$iv = ($dirty >> 6) & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i10 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1519209906, "C119@5067L98,146@6078L1460,123@5175L2363:MediaList.kt#gh748z");
            final List allAssets = state.getAssetStateList();
            ComposerKt.sourceInformationMarkerStart($composer3, 228087907, "CC(remember):MediaList.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changed(allAssets);
            Object it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv3 && it$iv3 != Composer.Companion.getEmpty()) {
                value$iv = it$iv3;
                contentAlignment$iv = contentAlignment$iv2;
                final List positionList = (List) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier $this$ifMatch$iv = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
                predict$iv = nestedScrollConnection3 == null;
                if (predict$iv) {
                    it = $this$ifMatch$iv;
                } else {
                    it = $this$ifMatch$iv;
                    if (nestedScrollConnection3 != null) {
                        it = NestedScrollModifierKt.nestedScroll$default(it, nestedScrollConnection3, (NestedScrollDispatcher) null, 2, (Object) null);
                    }
                }
                Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
                nestedScrollConnection2 = nestedScrollConnection3;
                Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(3) + f2), Dp.constructor-impl(0))));
                GridCells fixed = new GridCells.Fixed(4);
                Arrangement.Vertical vertical2 = vertical;
                Arrangement.Horizontal horizontal2 = horizontal;
                ComposerKt.sourceInformationMarkerStart($composer3, 228121621, "CC(remember):MediaList.kt#9igjgp");
                invalid$iv = (($dirty & 7168) != 2048) | ((57344 & $dirty) != 16384) | $composer3.changedInstance(allAssets) | (($dirty & 14) != 4) | $composer3.changedInstance(positionList) | ((29360128 & $dirty) != 8388608) | ((3670016 & $dirty) != 1048576) | (($dirty & 112) != 32) | $composer3.changedInstance(toaster) | $composer3.changed(toastString);
                value$iv2 = $composer3.rememberedValue();
                if (!invalid$iv || value$iv2 == Composer.Companion.getEmpty()) {
                    final Function3 function35 = shootContent;
                    final Function3 function36 = captureVideoContent;
                    $composer2 = $composer3;
                    $composer$iv = $composer3;
                    final boolean z = showSelectIndex2;
                    $composer$iv2 = $composer3;
                    final Function3 function37 = onAssetItemClick;
                    value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj) {
                            Unit GridMediaList_aqv2aB4$lambda$2$2$0;
                            GridMediaList_aqv2aB4$lambda$2$2$0 = MediaListKt.GridMediaList_aqv2aB4$lambda$2$2$0(function35, function36, allAssets, state, positionList, z, function37, function1, toaster, toastString, (LazyGridScope) obj);
                            return GridMediaList_aqv2aB4$lambda$2$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    $composer$iv = $composer3;
                    $composer$iv2 = $composer3;
                    $composer2 = $composer3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyGridDslKt.LazyVerticalGrid(fixed, it, lazyGridState, paddingValues, false, vertical2, horizontal2, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv2, $composer2, 1769472, 0, 912);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            List $this$map$iv = allAssets;
            contentAlignment$iv = contentAlignment$iv2;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                AssetItemState assetItemState = (AssetItemState) item$iv$iv;
                destination$iv$iv.add(IntRect.Companion.getZero());
                $this$map$iv = $this$map$iv;
            }
            Object mutableList = CollectionsKt.toMutableList((List) destination$iv$iv);
            $composer3.updateRememberedValue(mutableList);
            value$iv = mutableList;
            final List positionList2 = (List) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier $this$ifMatch$iv2 = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
            if (nestedScrollConnection3 == null) {
            }
            if (predict$iv) {
            }
            Arrangement.Vertical vertical3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            nestedScrollConnection2 = nestedScrollConnection3;
            Arrangement.Horizontal horizontal3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(3) + f2), Dp.constructor-impl(0))));
            GridCells fixed2 = new GridCells.Fixed(4);
            Arrangement.Vertical vertical22 = vertical3;
            Arrangement.Horizontal horizontal22 = horizontal3;
            ComposerKt.sourceInformationMarkerStart($composer3, 228121621, "CC(remember):MediaList.kt#9igjgp");
            invalid$iv = (($dirty & 7168) != 2048) | ((57344 & $dirty) != 16384) | $composer3.changedInstance(allAssets) | (($dirty & 14) != 4) | $composer3.changedInstance(positionList2) | ((29360128 & $dirty) != 8388608) | ((3670016 & $dirty) != 1048576) | (($dirty & 112) != 32) | $composer3.changedInstance(toaster) | $composer3.changed(toastString);
            value$iv2 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            final Function3 function352 = shootContent;
            final Function3 function362 = captureVideoContent;
            $composer2 = $composer3;
            $composer$iv = $composer3;
            final boolean z2 = showSelectIndex2;
            $composer$iv2 = $composer3;
            final Function3 function372 = onAssetItemClick;
            value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit GridMediaList_aqv2aB4$lambda$2$2$0;
                    GridMediaList_aqv2aB4$lambda$2$2$0 = MediaListKt.GridMediaList_aqv2aB4$lambda$2$2$0(function352, function362, allAssets, state, positionList2, z2, function372, function1, toaster, toastString, (LazyGridScope) obj);
                    return GridMediaList_aqv2aB4$lambda$2$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyGridDslKt.LazyVerticalGrid(fixed2, it, lazyGridState, paddingValues2, false, vertical22, horizontal22, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv2, $composer2, 1769472, 0, 912);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            captureVideoContent = function32;
            showDate2 = showDate;
            onAssetItemClick = function33;
            showSelectIndex2 = showSelectIndex;
            nestedScrollConnection2 = nestedScrollConnection;
            f2 = f;
            shootContent = function34;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final Function3 function38 = shootContent;
            final Function3 function39 = captureVideoContent;
            final boolean z3 = showDate2;
            final Function3 function310 = onAssetItemClick;
            final boolean z4 = showSelectIndex2;
            final NestedScrollConnection nestedScrollConnection4 = nestedScrollConnection2;
            final float f3 = f2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit GridMediaList_aqv2aB4$lambda$3;
                    GridMediaList_aqv2aB4$lambda$3 = MediaListKt.GridMediaList_aqv2aB4$lambda$3(AphroState.AphroContent.this, function1, modifier3, function38, function39, z3, function310, z4, nestedScrollConnection4, f3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GridMediaList_aqv2aB4$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridMediaList_aqv2aB4$lambda$2$2$0(final Function3 $shootContent, final Function3 $captureVideoContent, final List $allAssets, final AphroState.AphroContent $state, final List $positionList, final boolean $showSelectIndex, final Function3 $onAssetItemClick, final Function1 $onAction, final Toaster $toaster, final String $toastString, LazyGridScope $this$LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter($this$LazyVerticalGrid, "$this$LazyVerticalGrid");
        if ($shootContent != null) {
            LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, (Function1) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(709730940, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GridMediaList_aqv2aB4$lambda$2$2$0$0$0;
                    GridMediaList_aqv2aB4$lambda$2$2$0$0$0 = MediaListKt.GridMediaList_aqv2aB4$lambda$2$2$0$0$0($shootContent, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GridMediaList_aqv2aB4$lambda$2$2$0$0$0;
                }
            }), 7, (Object) null);
        }
        if ($captureVideoContent != null) {
            LazyGridScope.-CC.item$default($this$LazyVerticalGrid, (Object) null, (Function1) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(683617587, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit GridMediaList_aqv2aB4$lambda$2$2$0$1$0;
                    GridMediaList_aqv2aB4$lambda$2$2$0$1$0 = MediaListKt.GridMediaList_aqv2aB4$lambda$2$2$0$1$0($captureVideoContent, (LazyGridItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return GridMediaList_aqv2aB4$lambda$2$2$0$1$0;
                }
            }), 7, (Object) null);
        }
        final Function2 key$iv = new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Object GridMediaList_aqv2aB4$lambda$2$2$0$2;
                GridMediaList_aqv2aB4$lambda$2$2$0$2 = MediaListKt.GridMediaList_aqv2aB4$lambda$2$2$0$2(((Integer) obj).intValue(), (AssetItemState) obj2);
                return GridMediaList_aqv2aB4$lambda$2$2$0$2;
            }
        };
        $this$LazyVerticalGrid.items($allAssets.size(), new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList_aqv2aB4$lambda$2$2$0$$inlined$itemsIndexed$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return key$iv.invoke(Integer.valueOf(index), $allAssets.get(index));
            }
        }, (Function2) null, new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList_aqv2aB4$lambda$2$2$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                $allAssets.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList_aqv2aB4$lambda$2$2$0$$inlined$itemsIndexed$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyGridItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyGridItemScope $this$items, final int it, Composer $composer, int $changed) {
                Composer $composer2;
                ComposerKt.sourceInformation($composer, "CN(it)576@25926L26:LazyGridDsl.kt#7791vq");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1942245546, $dirty, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
                    }
                    int $changed2 = ($dirty & 14) | ($dirty & 112);
                    final AssetItemState item = (AssetItemState) $allAssets.get(it);
                    $composer.startReplaceGroup(1794007189);
                    ComposerKt.sourceInformation($composer, "CN(index,item)*171@6809L114,174@6959L98,177@7101L394,165@6517L997:MediaList.kt#gh748z");
                    boolean z = item.getSelected() || $state.getCanSelectMore();
                    Modifier modifier = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer, -1604688325, "CC(remember):MediaList.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($positionList) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it)) || ($changed2 & 48) == 32);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        final List list = $positionList;
                        Object value$iv = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList$3$2$1$4$1$1
                            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                invoke((LayoutCoordinates) p1);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LayoutCoordinates it2) {
                                Intrinsics.checkNotNullParameter(it2, "it");
                                list.set(it, IntRectKt.roundToIntRect(LayoutCoordinatesKt.boundsInWindow$default(it2, false, 1, (Object) null)));
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) it$iv);
                    boolean z2 = $showSelectIndex;
                    ComposerKt.sourceInformationMarkerStart($composer, -1604683541, "CC(remember):MediaList.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changed($onAssetItemClick) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(it)) || ($changed2 & 48) == 32) | (((($changed2 & 896) ^ 384) > 256 && $composer.changedInstance(item)) || ($changed2 & 384) == 256) | $composer.changedInstance($positionList);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                        final Function3 function3 = $onAssetItemClick;
                        final List list2 = $positionList;
                        Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList$3$2$1$4$2$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2267invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2267invoke() {
                                function3.invoke(Integer.valueOf(it), item, list2);
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                    }
                    Function0 function0 = (Function0) it$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1604678701, "CC(remember):MediaList.kt#9igjgp");
                    boolean invalid$iv3 = $composer.changed($onAction) | (((($changed2 & 896) ^ 384) > 256 && $composer.changedInstance(item)) || ($changed2 & 384) == 256) | $composer.changed($state) | $composer.changedInstance($toaster) | $composer.changed($toastString);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                        final Function1 function1 = $onAction;
                        final AphroState.AphroContent aphroContent = $state;
                        final Toaster toaster = $toaster;
                        final String str = $toastString;
                        $composer2 = $composer;
                        Object value$iv3 = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$GridMediaList$3$2$1$4$3$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2268invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2268invoke() {
                                if (AssetItemState.this.getSelected()) {
                                    function1.invoke(new AphroAction.UnSelectAsset(AssetItemState.this.getAsset()));
                                } else if (aphroContent.getCanSelectMore()) {
                                    function1.invoke(new AphroAction.SelectAsset(AssetItemState.this.getAsset()));
                                } else {
                                    Toaster.CC.showToast$default(toaster, str, null, 2, null);
                                }
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                    } else {
                        $composer2 = $composer;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    MediaItemKt.MediaItem(item, true, z2, function0, (Function0) it$iv3, onGloballyPositioned, z, $composer2, AssetItemState.$stable | 48 | (($changed2 >> 6) & 14), 0);
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridMediaList_aqv2aB4$lambda$2$2$0$0$0(Function3 $it, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C149@6155L4:MediaList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(709730940, $dirty, -1, "kntr.common.photonic.aphro.ui.component.GridMediaList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaList.kt:149)");
            }
            $it.invoke($this$item, $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GridMediaList_aqv2aB4$lambda$2$2$0$1$0(Function3 $it, LazyGridItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C155@6275L4:MediaList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(683617587, $dirty, -1, "kntr.common.photonic.aphro.ui.component.GridMediaList.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MediaList.kt:155)");
            }
            $it.invoke($this$item, $composer, Integer.valueOf($dirty & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object GridMediaList_aqv2aB4$lambda$2$2$0$2(int index, AssetItemState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getAsset().getIdentifier();
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x047c  */
    /* renamed from: MediaList-au3_HiA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2264MediaListau3_HiA(final AphroState.AphroContent state, final Function1<? super AphroAction, Unit> function1, Modifier modifier, boolean showDate, boolean showSelectIndex, NestedScrollConnection nestedScrollConnection, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        boolean showSelectIndex2;
        NestedScrollConnection nestedScrollConnection2;
        float f2;
        NestedScrollConnection nestedScrollConnection3;
        Modifier modifier3;
        boolean showDate2;
        float f3;
        NestedScrollConnection nestedScrollConnection4;
        Function0 factory$iv$iv$iv;
        Object value$iv;
        final List mediaItemsRows;
        boolean predict$iv;
        Modifier it;
        boolean invalid$iv;
        Object it$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        BoxScope $this$MediaList_au3_HiA_u24lambda_u240;
        Composer $composer2;
        Composer $composer$iv2;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer4 = $composer.startRestartGroup(-1766674640);
        ComposerKt.sourceInformation($composer4, "C(MediaList)N(state,onAction,modifier,showDate,showSelectIndex,nestedScrollConnection,extraPadding:c#ui.unit.Dp)202@7872L7,203@7911L7,204@7943L23,206@7997L178,211@8180L9164:MediaList.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = showDate;
        } else if (($changed & 3072) == 0) {
            z = showDate;
            $dirty |= $composer4.changed(z) ? 2048 : 1024;
        } else {
            z = showDate;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            showSelectIndex2 = showSelectIndex;
        } else if (($changed & 24576) == 0) {
            showSelectIndex2 = showSelectIndex;
            $dirty |= $composer4.changed(showSelectIndex2) ? 16384 : 8192;
        } else {
            showSelectIndex2 = showSelectIndex;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            nestedScrollConnection2 = nestedScrollConnection;
        } else if (($changed & 196608) == 0) {
            nestedScrollConnection2 = nestedScrollConnection;
            $dirty |= $composer4.changedInstance(nestedScrollConnection2) ? 131072 : 65536;
        } else {
            nestedScrollConnection2 = nestedScrollConnection;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
            f2 = f;
        } else if (($changed & 1572864) == 0) {
            f2 = f;
            $dirty |= $composer4.changed(f2) ? 1048576 : 524288;
        } else {
            f2 = f;
        }
        if ($composer4.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                showDate2 = z;
            } else {
                showDate2 = true;
            }
            if (i4 != 0) {
                showSelectIndex2 = true;
            }
            if (i5 == 0) {
                nestedScrollConnection4 = nestedScrollConnection2;
            } else {
                nestedScrollConnection4 = null;
            }
            if (i6 != 0) {
                f2 = Dp.constructor-impl(0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1766674640, $dirty, -1, "kntr.common.photonic.aphro.ui.component.MediaList (MediaList.kt:201)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Router router = (Router) consume;
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Toaster toaster = (Toaster) consume2;
            LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer4, 0, 3);
            final String toastString = PluralStringResourcesKt.pluralStringResource(Plurals0_commonMainKt.getFollowing_global_string_1146(Res.plurals.INSTANCE), state.getOption().getMaxSelectCount(), new Object[]{String.valueOf(state.getOption().getMaxSelectCount())}, $composer4, 0);
            int $changed$iv = ($dirty >> 6) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i8 = (($changed$iv >> 6) & 112) | 6;
            BoxScope $this$MediaList_au3_HiA_u24lambda_u2402 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -502361002, "C214@8293L277,244@9340L7770,223@8580L8530:MediaList.kt#gh748z");
            final List allAssets = state.getAssetStateList();
            ComposerKt.sourceInformationMarkerStart($composer4, -1401684865, "CC(remember):MediaList.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changed(allAssets);
            Object it$iv2 = $composer4.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                value$iv = it$iv2;
                mediaItemsRows = (List) value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier $this$ifMatch$iv = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
                predict$iv = nestedScrollConnection4 == null;
                if (predict$iv) {
                    it = $this$ifMatch$iv;
                } else {
                    it = $this$ifMatch$iv;
                    if (nestedScrollConnection4 != null) {
                        it = NestedScrollModifierKt.nestedScroll$default(it, nestedScrollConnection4, (NestedScrollDispatcher) null, 2, (Object) null);
                    }
                }
                Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
                nestedScrollConnection3 = nestedScrollConnection4;
                final boolean showSelectIndex3 = showSelectIndex2;
                f3 = f2;
                PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(3) + f2), Dp.constructor-impl(0))));
                Arrangement.Vertical vertical2 = vertical;
                ComposerKt.sourceInformationMarkerStart($composer4, -1401643868, "CC(remember):MediaList.kt#9igjgp");
                invalid$iv = $composer4.changedInstance(mediaItemsRows) | (($dirty & 14) != 4) | ((57344 & $dirty) != 16384) | $composer4.changedInstance(allAssets) | (($dirty & 112) != 32) | $composer4.changedInstance(router) | $composer4.changedInstance(toaster) | $composer4.changed(toastString);
                it$iv = $composer4.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    $composer$iv$iv = $composer4;
                    $composer$iv = $composer4;
                    $this$MediaList_au3_HiA_u24lambda_u240 = $this$MediaList_au3_HiA_u24lambda_u2402;
                    $composer2 = $composer4;
                    $composer$iv2 = $composer4;
                    Object value$iv2 = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj) {
                            Unit MediaList_au3_HiA$lambda$0$2$0;
                            MediaList_au3_HiA$lambda$0$2$0 = MediaListKt.MediaList_au3_HiA$lambda$0$2$0(mediaItemsRows, state, showSelectIndex3, allAssets, function1, router, toaster, toastString, (LazyListScope) obj);
                            return MediaList_au3_HiA$lambda$0$2$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                } else {
                    $composer$iv = $composer4;
                    $composer$iv$iv = $composer4;
                    $composer$iv2 = $composer4;
                    $this$MediaList_au3_HiA_u24lambda_u240 = $this$MediaList_au3_HiA_u24lambda_u2402;
                    $composer2 = $composer4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LazyDslKt.LazyColumn(it, lazyListState, paddingValues, false, vertical2, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 24576, 488);
                if (showDate2) {
                    $composer3 = $composer2;
                    $composer3.startReplaceGroup(-510794088);
                } else {
                    $composer3 = $composer2;
                    $composer3.startReplaceGroup(-493790805);
                    ComposerKt.sourceInformation($composer3, "364@17147L181");
                    DateLabel(lazyListState, mediaItemsRows, $this$MediaList_au3_HiA_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getTopEnd()), $composer3, 0, 0);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                showSelectIndex2 = showSelectIndex3;
            }
            value$iv = CollectionsKt.windowed(allAssets, 4, 4, true);
            $composer4.updateRememberedValue(value$iv);
            mediaItemsRows = (List) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier $this$ifMatch$iv2 = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.Companion, 0.0f), 0.0f, 1, (Object) null);
            if (nestedScrollConnection4 == null) {
            }
            if (predict$iv) {
            }
            Arrangement.Vertical vertical3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
            nestedScrollConnection3 = nestedScrollConnection4;
            final boolean showSelectIndex32 = showSelectIndex2;
            f3 = f2;
            PaddingValues paddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.constructor-impl(Dp.constructor-impl(3) + f2), Dp.constructor-impl(0))));
            Arrangement.Vertical vertical22 = vertical3;
            ComposerKt.sourceInformationMarkerStart($composer4, -1401643868, "CC(remember):MediaList.kt#9igjgp");
            invalid$iv = $composer4.changedInstance(mediaItemsRows) | (($dirty & 14) != 4) | ((57344 & $dirty) != 16384) | $composer4.changedInstance(allAssets) | (($dirty & 112) != 32) | $composer4.changedInstance(router) | $composer4.changedInstance(toaster) | $composer4.changed(toastString);
            it$iv = $composer4.rememberedValue();
            if (!invalid$iv) {
            }
            $composer$iv$iv = $composer4;
            $composer$iv = $composer4;
            $this$MediaList_au3_HiA_u24lambda_u240 = $this$MediaList_au3_HiA_u24lambda_u2402;
            $composer2 = $composer4;
            $composer$iv2 = $composer4;
            Object value$iv22 = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj) {
                    Unit MediaList_au3_HiA$lambda$0$2$0;
                    MediaList_au3_HiA$lambda$0$2$0 = MediaListKt.MediaList_au3_HiA$lambda$0$2$0(mediaItemsRows, state, showSelectIndex32, allAssets, function1, router, toaster, toastString, (LazyListScope) obj);
                    return MediaList_au3_HiA$lambda$0$2$0;
                }
            };
            $composer4.updateRememberedValue(value$iv22);
            it$iv = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(it, lazyListState, paddingValues2, false, vertical22, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 24576, 488);
            if (showDate2) {
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
            showSelectIndex2 = showSelectIndex32;
        } else {
            $composer4.skipToGroupEnd();
            nestedScrollConnection3 = nestedScrollConnection2;
            modifier3 = modifier2;
            showDate2 = z;
            f3 = f2;
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final boolean z2 = showDate2;
            final boolean z3 = showSelectIndex2;
            final NestedScrollConnection nestedScrollConnection5 = nestedScrollConnection3;
            final float f4 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaList_au3_HiA$lambda$1;
                    MediaList_au3_HiA$lambda$1 = MediaListKt.MediaList_au3_HiA$lambda$1(AphroState.AphroContent.this, function1, modifier4, z2, z3, nestedScrollConnection5, f4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaList_au3_HiA$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaList_au3_HiA$lambda$0$2$0(final List $mediaItemsRows, final AphroState.AphroContent $state, final boolean $showSelectIndex, final List $allAssets, final Function1 $onAction, final Router $router, final Toaster $toaster, final String $toastString, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final Function1 contentType$iv = new Function1() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList_au3_HiA$lambda$0$2$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m2266invoke((List<? extends AssetItemState>) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m2266invoke(List<? extends AssetItemState> list) {
                return null;
            }
        };
        $this$LazyColumn.items($mediaItemsRows.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList_au3_HiA$lambda$0$2$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($mediaItemsRows.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList_au3_HiA$lambda$0$2$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                List it2;
                Composer $composer$iv;
                Composer $composer2;
                int i;
                boolean invalid$iv;
                Object it$iv;
                Activity platformContext;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int i2 = $dirty & 14;
                List it3 = (List) $mediaItemsRows.get(it);
                Composer $composer3 = $composer;
                $composer3.startReplaceGroup(151128274);
                ComposerKt.sourceInformation($composer3, "CN(it)*246@9394L7692:MediaList.kt#gh748z");
                Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(3));
                int $changed$iv = 54;
                Composer $composer$iv2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv = (54 << 3) & 112;
                String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Composer $composer$iv$iv = $composer$iv2;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv = $composer$iv$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                Composer $composer$iv$iv$iv = $composer$iv$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv$iv$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv$iv);
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                Composer $composer$iv3 = $composer$iv$iv$iv;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i4 = ((54 >> 6) & 112) | 6;
                RowScope $this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u240 = RowScopeInstance.INSTANCE;
                Composer $composer4 = $composer$iv3;
                ComposerKt.sourceInformationMarkerStart($composer4, 240486221, "C250@9589L20:MediaList.kt#gh748z");
                Activity platformContext2 = PlatformContext_androidKt.getPlatformContext($composer4, 0);
                $composer4.startReplaceGroup(-2070450409);
                ComposerKt.sourceInformation($composer4, "*252@9700L7346");
                int i5 = 0;
                while (true) {
                    int $changed$iv2 = $changed$iv;
                    if (i5 >= 4) {
                        break;
                    }
                    RowScope $this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u2402 = $this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u240;
                    Composer $composer5 = $composer3;
                    boolean z2 = z;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    Modifier modifier$iv2 = AspectRatioKt.aspectRatio$default(RowScope.-CC.weight$default($this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u2402, Modifier.Companion, 1.0f, false, 2, (Object) null), 1.0f, false, 2, (Object) null);
                    Composer $composer$iv4 = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv2 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str);
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                    String str3 = str;
                    CompositionLocalMap localMap$iv$iv2 = $composer$iv4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    Composer $composer$iv$iv2 = $composer$iv$iv;
                    Composer $composer$iv5 = $composer$iv2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str2);
                    if (!($composer$iv4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv4.startReusableNode();
                    if ($composer$iv4.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer$iv4.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer$iv4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv4);
                    String str4 = str2;
                    Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i7 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -79109619, "C:MediaList.kt#gh748z");
                    final AssetItemState item = (AssetItemState) CollectionsKt.getOrNull(it3, i5);
                    if (item == null) {
                        $composer$iv4.startReplaceGroup(-79253553);
                        $composer$iv4.endReplaceGroup();
                        i = i5;
                        platformContext = platformContext2;
                        $composer2 = $composer4;
                        it2 = it3;
                        $composer$iv = $composer$iv3;
                    } else {
                        $composer$iv4.startReplaceGroup(-78609869);
                        ComposerKt.sourceInformation($composer$iv4, "269@10514L24,276@10960L5339,346@16363L554,270@10575L6381");
                        it2 = it3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 683736516, "CC(remember):Effects.kt#9igjgp");
                        Object value$iv$iv = $composer$iv4.rememberedValue();
                        if (value$iv$iv == Composer.Companion.getEmpty()) {
                            value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer$iv4);
                            $composer$iv4.updateRememberedValue(value$iv$iv);
                        }
                        final CoroutineScope scope = (CoroutineScope) value$iv$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        boolean z3 = item.getSelected() || $state.getCanSelectMore();
                        boolean z4 = $showSelectIndex;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 1382952204, "CC(remember):MediaList.kt#9igjgp");
                        boolean invalid$iv2 = $composer$iv4.changedInstance(scope) | $composer$iv4.changedInstance($allAssets) | $composer$iv4.changedInstance(item) | $composer$iv4.changed($state) | $composer$iv4.changed($onAction) | $composer$iv4.changedInstance($router) | $composer$iv4.changedInstance(platformContext2);
                        $composer$iv = $composer$iv3;
                        Object it$iv2 = $composer$iv4.rememberedValue();
                        if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                            i = i5;
                            $composer2 = $composer4;
                            Function0 function0 = (Function0) it$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1383120315, "CC(remember):MediaList.kt#9igjgp");
                            invalid$iv = $composer$iv4.changedInstance(item) | $composer$iv4.changed($onAction) | $composer$iv4.changed($state) | $composer$iv4.changedInstance($toaster) | $composer$iv4.changed($toastString);
                            it$iv = $composer$iv4.rememberedValue();
                            if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                                final Function1 function1 = $onAction;
                                platformContext = platformContext2;
                                final AphroState.AphroContent aphroContent = $state;
                                final Toaster toaster = $toaster;
                                final String str5 = $toastString;
                                Object value$iv = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$2$1
                                    public /* bridge */ /* synthetic */ Object invoke() {
                                        m2270invoke();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: collision with other method in class */
                                    public final void m2270invoke() {
                                        if (AssetItemState.this.getSelected()) {
                                            function1.invoke(new AphroAction.UnSelectAsset(AssetItemState.this.getAsset()));
                                        } else if (aphroContent.getCanSelectMore()) {
                                            function1.invoke(new AphroAction.SelectAsset(AssetItemState.this.getAsset()));
                                        } else {
                                            Toaster.CC.showToast$default(toaster, str5, null, 2, null);
                                        }
                                    }
                                };
                                $composer$iv4.updateRememberedValue(value$iv);
                                it$iv = value$iv;
                            } else {
                                platformContext = platformContext2;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                            MediaItemKt.MediaItem(item, true, z4, function0, (Function0) it$iv, null, z3, $composer$iv4, AssetItemState.$stable | 48, 32);
                            $composer$iv4.endReplaceGroup();
                        }
                        final List list = $allAssets;
                        final AphroState.AphroContent aphroContent2 = $state;
                        $composer2 = $composer4;
                        final Router router = $router;
                        i = i5;
                        final Function1 function12 = $onAction;
                        final Activity activity = platformContext2;
                        Object value$iv2 = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* compiled from: MediaList.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                            @DebugMetadata(c = "kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1", f = "MediaList.kt", i = {0, 0, 1, 1}, l = {311, 333}, m = "invokeSuspend", n = {"$this$launch", "previewImageData", "$this$launch", "previewImageData"}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 1)
                            /* renamed from: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1  reason: invalid class name */
                            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ List<AssetItemState> $allAssets;
                                final /* synthetic */ AssetItemState $item;
                                final /* synthetic */ Function1<AphroAction, Unit> $onAction;
                                final /* synthetic */ Activity $platformContext;
                                final /* synthetic */ Router $router;
                                final /* synthetic */ AphroState.AphroContent $state;
                                private /* synthetic */ Object L$0;
                                Object L$1;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                AnonymousClass1(List<AssetItemState> list, AphroState.AphroContent aphroContent, Router router, Activity activity, AssetItemState assetItemState, Function1<? super AphroAction, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$allAssets = list;
                                    this.$state = aphroContent;
                                    this.$router = router;
                                    this.$platformContext = activity;
                                    this.$item = assetItemState;
                                    this.$onAction = function1;
                                }

                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    Continuation<Unit> anonymousClass1 = new AnonymousClass1(this.$allAssets, this.$state, this.$router, this.$platformContext, this.$item, this.$onAction, continuation);
                                    anonymousClass1.L$0 = obj;
                                    return anonymousClass1;
                                }

                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:34:0x017e A[RETURN] */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object invokeSuspend(Object $result) {
                                    PreviewImageData previewImageData;
                                    Flow onEach;
                                    final Function1<AphroAction, Unit> function1;
                                    CoroutineScope $this$launch = (CoroutineScope) this.L$0;
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            Iterable $this$map$iv = this.$allAssets;
                                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                            for (Object item$iv$iv : $this$map$iv) {
                                                AssetItemState asset = (AssetItemState) item$iv$iv;
                                                destination$iv$iv.add(PreviewableAssetKt.asPreviewableAsset$default(asset.getAsset(), null, null, false, 7, null));
                                            }
                                            ArrayList arrayList = (List) destination$iv$iv;
                                            PageImagePreviewType pageImagePreviewType = PageImagePreviewType.DEFAULT_IMAGE;
                                            List $this$indexOfFirst$iv = this.$allAssets;
                                            AssetItemState assetItemState = this.$item;
                                            int index$iv = 0;
                                            Iterator<AssetItemState> it = $this$indexOfFirst$iv.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    Object item$iv = it.next();
                                                    AssetItemState a = (AssetItemState) item$iv;
                                                    if (!Intrinsics.areEqual(a.getAsset().getIdentifier(), assetItemState.getAsset().getIdentifier())) {
                                                        index$iv++;
                                                    }
                                                } else {
                                                    index$iv = -1;
                                                }
                                            }
                                            int coerceAtLeast = RangesKt.coerceAtLeast(index$iv, 0);
                                            AlbumInfo selectedAlbum = this.$state.getSelectedAlbum();
                                            PreviewImageData previewImageData2 = new PreviewImageData(arrayList, pageImagePreviewType, coerceAtLeast, selectedAlbum != null ? selectedAlbum.getId() : null, null, 16, null);
                                            BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new C00091(previewImageData2, this.$onAction, null), 3, (Object) null);
                                            Router router = this.$router;
                                            List<PreviewableAsset> currentPreviewDataSource = previewImageData2.getCurrentPreviewDataSource();
                                            int currentPreviewInitialIndex = previewImageData2.getCurrentPreviewInitialIndex();
                                            ImagePreviewType.Gallery gallery = new ImagePreviewType.Gallery(this.$state.getCurrentSelected(), this.$state.getUseOriginImage(), new AphroSelectOption(9, 0, false, null, null, false, false, false, null, null, 1022, null), previewImageData2.getSelectResultMatchKey());
                                            Activity activity = this.$platformContext;
                                            AlbumInfo selectedAlbum2 = this.$state.getSelectedAlbum();
                                            String id = selectedAlbum2 != null ? selectedAlbum2.getId() : null;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                            this.L$1 = previewImageData2;
                                            this.label = 1;
                                            if (ImagePreviewLauncher_androidKt.launchImagePreview(router, currentPreviewDataSource, currentPreviewInitialIndex, gallery, activity, id, (Continuation) this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            previewImageData = previewImageData2;
                                            onEach = FlowKt.onEach(FlowKt.receiveAsFlow(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(previewImageData.getSelectResultMatchKey())), new AnonymousClass2(null));
                                            function1 = this.$onAction;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData);
                                            this.label = 2;
                                            if (onEach.collect(new FlowCollector() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt.MediaList.1.2.1.1.1.1.1.1.1.3
                                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                    return emit((ImagePreviewSelectResult) value, (Continuation<? super Unit>) $completion);
                                                }

                                                public final Object emit(ImagePreviewSelectResult result, Continuation<? super Unit> continuation) {
                                                    function1.invoke(new AphroAction.SetSelectedAssets(result.getSelectedAssets()));
                                                    function1.invoke(new AphroAction.CheckUseOriginImage(result.getUseOriginImage()));
                                                    return Unit.INSTANCE;
                                                }
                                            }, (Continuation) this) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            return Unit.INSTANCE;
                                        case 1:
                                            previewImageData = (PreviewImageData) this.L$1;
                                            ResultKt.throwOnFailure($result);
                                            onEach = FlowKt.onEach(FlowKt.receiveAsFlow(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(previewImageData.getSelectResultMatchKey())), new AnonymousClass2(null));
                                            function1 = this.$onAction;
                                            this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(previewImageData);
                                            this.label = 2;
                                            if (onEach.collect(new FlowCollector() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt.MediaList.1.2.1.1.1.1.1.1.1.3
                                                public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                    return emit((ImagePreviewSelectResult) value, (Continuation<? super Unit>) $completion);
                                                }

                                                public final Object emit(ImagePreviewSelectResult result, Continuation<? super Unit> continuation) {
                                                    function1.invoke(new AphroAction.SetSelectedAssets(result.getSelectedAssets()));
                                                    function1.invoke(new AphroAction.CheckUseOriginImage(result.getUseOriginImage()));
                                                    return Unit.INSTANCE;
                                                }
                                            }, (Continuation) this) == coroutine_suspended) {
                                            }
                                            return Unit.INSTANCE;
                                        case 2:
                                            PreviewImageData previewImageData3 = (PreviewImageData) this.L$1;
                                            ResultKt.throwOnFailure($result);
                                            return Unit.INSTANCE;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: MediaList.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                @DebugMetadata(c = "kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1$1", f = "MediaList.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                /* renamed from: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1$1  reason: invalid class name and collision with other inner class name */
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class C00091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ Function1<AphroAction, Unit> $onAction;
                                    final /* synthetic */ PreviewImageData $previewImageData;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    C00091(PreviewImageData previewImageData, Function1<? super AphroAction, Unit> function1, Continuation<? super C00091> continuation) {
                                        super(2, continuation);
                                        this.$previewImageData = previewImageData;
                                        this.$onAction = function1;
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00091(this.$previewImageData, this.$onAction, continuation);
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                Flow receiveAsFlow = FlowKt.receiveAsFlow(ImagePreviewDataNotifier.INSTANCE.getPreviewSelectResultChannel(this.$previewImageData.getSelectResultMatchKey()));
                                                final Function1<AphroAction, Unit> function1 = this.$onAction;
                                                this.label = 1;
                                                if (receiveAsFlow.collect(new FlowCollector() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt.MediaList.1.2.1.1.1.1.1.1.1.1.1
                                                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                                        return emit((ImagePreviewSelectResult) value, (Continuation<? super Unit>) $completion);
                                                    }

                                                    public final Object emit(ImagePreviewSelectResult it, Continuation<? super Unit> continuation) {
                                                        function1.invoke(new AphroAction.SetSelectedAssets(it.getSelectedAssets()));
                                                        function1.invoke(new AphroAction.CheckUseOriginImage(it.getUseOriginImage()));
                                                        return Unit.INSTANCE;
                                                    }
                                                }, (Continuation) this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                                break;
                                            case 1:
                                                ResultKt.throwOnFailure($result);
                                                break;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* compiled from: MediaList.kt */
                                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewSelectResult;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                                @DebugMetadata(c = "kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1$2", f = "MediaList.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                                /* renamed from: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$1$1$1$2  reason: invalid class name */
                                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                                public static final class AnonymousClass2 extends SuspendLambda implements Function2<ImagePreviewSelectResult, Continuation<? super Unit>, Object> {
                                    /* synthetic */ Object L$0;
                                    int label;

                                    AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                                        super(2, continuation);
                                    }

                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        Continuation<Unit> anonymousClass2 = new AnonymousClass2(continuation);
                                        anonymousClass2.L$0 = obj;
                                        return anonymousClass2;
                                    }

                                    public final Object invoke(ImagePreviewSelectResult imagePreviewSelectResult, Continuation<? super Unit> continuation) {
                                        return create(imagePreviewSelectResult, continuation).invokeSuspend(Unit.INSTANCE);
                                    }

                                    public final Object invokeSuspend(Object $result) {
                                        ImagePreviewSelectResult result = (ImagePreviewSelectResult) this.L$0;
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        switch (this.label) {
                                            case 0:
                                                ResultKt.throwOnFailure($result);
                                                KLog_androidKt.getKLog().i("Aphro_Preview", "selected image: " + result);
                                                return Unit.INSTANCE;
                                            default:
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                    }
                                }
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2269invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2269invoke() {
                                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(list, aphroContent2, router, activity, item, function12, null), 3, (Object) null);
                            }
                        };
                        $composer$iv4.updateRememberedValue(value$iv2);
                        it$iv2 = value$iv2;
                        Function0 function02 = (Function0) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, 1383120315, "CC(remember):MediaList.kt#9igjgp");
                        invalid$iv = $composer$iv4.changedInstance(item) | $composer$iv4.changed($onAction) | $composer$iv4.changed($state) | $composer$iv4.changedInstance($toaster) | $composer$iv4.changed($toastString);
                        it$iv = $composer$iv4.rememberedValue();
                        if (invalid$iv) {
                        }
                        final Function1<? super AphroAction, Unit> function13 = $onAction;
                        platformContext = platformContext2;
                        final AphroState.AphroContent aphroContent3 = $state;
                        final Toaster toaster2 = $toaster;
                        final String str52 = $toastString;
                        Object value$iv3 = (Function0) new Function0<Unit>() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$MediaList$1$2$1$1$1$1$2$1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2270invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m2270invoke() {
                                if (AssetItemState.this.getSelected()) {
                                    function13.invoke(new AphroAction.UnSelectAsset(AssetItemState.this.getAsset()));
                                } else if (aphroContent3.getCanSelectMore()) {
                                    function13.invoke(new AphroAction.SelectAsset(AssetItemState.this.getAsset()));
                                } else {
                                    Toaster.CC.showToast$default(toaster2, str52, null, 2, null);
                                }
                            }
                        };
                        $composer$iv4.updateRememberedValue(value$iv3);
                        it$iv = value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        MediaItemKt.MediaItem(item, true, z4, function02, (Function0) it$iv, null, z3, $composer$iv4, AssetItemState.$stable | 48, 32);
                        $composer$iv4.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    i5 = i + 1;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    $composer3 = $composer5;
                    $composer$iv$iv = $composer$iv$iv2;
                    $this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u240 = $this$MediaList_au3_HiA_u24lambda_u240_u242_u240_u240_u2402;
                    z = z2;
                    $changed$iv = $changed$iv2;
                    str = str3;
                    $composer$iv2 = $composer$iv5;
                    str2 = str4;
                    $composer$iv$iv$iv = $composer$iv$iv$iv2;
                    it3 = it2;
                    $composer$iv3 = $composer$iv;
                    $composer4 = $composer2;
                    platformContext2 = platformContext;
                }
                Composer $composer6 = $composer4;
                Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    private static final void DateLabel(final LazyListState lazyListState, final List<? extends List<AssetItemState>> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        int i2;
        final String dateString;
        Asset asset;
        Composer $composer2 = $composer.startRestartGroup(-416068663);
        ComposerKt.sourceInformation($composer2, "C(DateLabel)N(lazyListState,mediaItemsRows,modifier)379@17521L67,380@17612L74,381@17708L33,382@17765L34,383@17839L177,383@17804L212,404@18427L596,396@18163L860:MediaList.kt#gh748z");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(lazyListState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-416068663, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.DateLabel (MediaList.kt:378)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -410021652, "CC(remember):MediaList.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        int firstVisibleItemIndex;
                        firstVisibleItemIndex = lazyListState.getFirstVisibleItemIndex();
                        return Integer.valueOf(firstVisibleItemIndex);
                    }
                });
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            State index$delegate = (State) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -410018733, "CC(remember):MediaList.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        int firstVisibleItemScrollOffset;
                        firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
                        return Integer.valueOf(firstVisibleItemScrollOffset);
                    }
                });
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            State firstOffset$delegate = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -410015702, "CC(remember):MediaList.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableState job$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -410013877, "CC(remember):MediaList.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            } else {
                $dirty = $dirty2;
            }
            MutableState dateVisible$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Integer valueOf = Integer.valueOf(DateLabel$lambda$3(firstOffset$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -410011366, "CC(remember):MediaList.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Function2) new MediaListKt$DateLabel$1$1(job$delegate, dateVisible$delegate, null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv5, $composer2, 0);
            List list2 = (List) CollectionsKt.getOrNull(list, DateLabel$lambda$1(index$delegate));
            AssetItemState firstItem = list2 != null ? (AssetItemState) CollectionsKt.firstOrNull(list2) : null;
            Instant createTime = (firstItem == null || (asset = firstItem.getAsset()) == null) ? null : asset.getCreateTime();
            if (createTime == null) {
                $composer2.startReplaceGroup(174847050);
                $composer2.endReplaceGroup();
                dateString = null;
                i2 = 0;
            } else {
                $composer2.startReplaceGroup(-410001769);
                ComposerKt.sourceInformation($composer2, "395@18144L14");
                i2 = 0;
                dateString = toDateString(createTime, $composer2, 0);
                $composer2.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(DateLabel$lambda$8(dateVisible$delegate), ZIndexModifierKt.zIndex(Modifier.Companion, 1.0f).then(modifier4), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, i2, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-183119887, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit DateLabel$lambda$11;
                    DateLabel$lambda$11 = MediaListKt.DateLabel$lambda$11(dateString, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return DateLabel$lambda$11;
                }
            }, $composer2, 54), $composer2, 200064, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaListKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit DateLabel$lambda$12;
                    DateLabel$lambda$12 = MediaListKt.DateLabel$lambda$12(lazyListState, list, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DateLabel$lambda$12;
                }
            });
        }
    }

    private static final int DateLabel$lambda$1(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    private static final int DateLabel$lambda$3(State<Integer> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job DateLabel$lambda$5(MutableState<Job> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (Job) $this$getValue$iv.getValue();
    }

    private static final boolean DateLabel$lambda$8(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateLabel$lambda$9(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DateLabel$lambda$11(String $dateString, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C:MediaList.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-183119887, $changed, -1, "kntr.common.photonic.aphro.ui.component.DateLabel.<anonymous> (MediaList.kt:405)");
        }
        boolean z = false;
        if ($dateString != null && (!StringsKt.isBlank($dateString))) {
            z = true;
        }
        if (z) {
            $composer.startReplaceGroup(-716010133);
            ComposerKt.sourceInformation($composer, "412@18715L6,415@18902L9,417@18980L6,406@18489L518");
            TextKt.Text-Nvy7gAk($dateString, PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(20))), Dp.constructor-impl(10), Dp.constructor-impl(7)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getH3(), $composer, 0, 24576, 114680);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-734368271);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Instant getZeroInstant() {
        return zeroInstant;
    }

    public static final String toDateString(Instant $this$toDateString, Composer $composer, int $changed) {
        String stringResource;
        Intrinsics.checkNotNullParameter($this$toDateString, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -1788788565, "C(toDateString):MediaList.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1788788565, $changed, -1, "kntr.common.photonic.aphro.ui.component.toDateString (MediaList.kt:426)");
        }
        LocalDateTime today = TimeZoneKt.toLocalDateTime(Clock.System.INSTANCE.now(), TimeZone.Companion.currentSystemDefault());
        LocalDate thisDate = TimeZoneKt.toLocalDateTime($this$toDateString, TimeZone.Companion.currentSystemDefault()).getDate();
        if (Intrinsics.areEqual($this$toDateString, zeroInstant)) {
            $composer.startReplaceGroup(-2140664763);
            $composer.endReplaceGroup();
            stringResource = "";
        } else if (Intrinsics.areEqual(today.getDate(), thisDate)) {
            $composer.startReplaceGroup(-2140611474);
            ComposerKt.sourceInformation($composer, "432@19388L57");
            stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOthers_global_string_478(OthersRes.INSTANCE.getString()), $composer, 0);
            $composer.endReplaceGroup();
        } else {
            DatePeriod it = LocalDateKt.minus(today.getDate(), thisDate);
            if (((it.getYears() == 0 && it.getMonths() == 0 && it.getDays() == 1) ? 1 : null) != null) {
                $composer.startReplaceGroup(-2140415058);
                ComposerKt.sourceInformation($composer, "437@19586L57");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOthers_global_string_538(OthersRes.INSTANCE.getString()), $composer, 0);
                $composer.endReplaceGroup();
            } else if (today.getYear() == thisDate.getYear()) {
                $composer.startReplaceGroup(-2140301164);
                ComposerKt.sourceInformation($composer, "439@19698L147");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOthers_global_string_541(OthersRes.INSTANCE.getString()), new Object[]{Integer.valueOf(thisDate.getMonthNumber()), Integer.valueOf(thisDate.getDayOfMonth())}, $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-2140132679);
                ComposerKt.sourceInformation($composer, "445@19867L174");
                stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getOthers_global_string_542(OthersRes.INSTANCE.getString()), new Object[]{Integer.valueOf(thisDate.getYear()), Integer.valueOf(thisDate.getMonthNumber()), Integer.valueOf(thisDate.getDayOfMonth())}, $composer, 0);
                $composer.endReplaceGroup();
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }
}