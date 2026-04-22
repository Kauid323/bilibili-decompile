package kntr.watch.later.watchlater.edit;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.Plurals0_commonMainKt;
import bili.resource.favorites.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kntr.watch.later.watchlater.consts.WatchLaterConsts_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.PluralStringResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.home.watch.later.generated.resources.Drawable0_commonMainKt;
import srcs.app.home.watch.later.generated.resources.Res;

/* compiled from: FavoritesFolderBottomSheet.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u001a9\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0001¢\u0006\u0002\u0010\t\u001a\u001b\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0015²\u0006\u0010\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"FavoriteSingleBottomSheet", "", "opType", "", "resources", "", "onDismissRequest", "Lkotlin/Function0;", "onOperateSuccess", "(ILjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FolderHeader", "onAddFolder", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FolderItem", "folder", "Lkntr/watch/later/watchlater/edit/FavFolder;", "onClick", "(Lkntr/watch/later/watchlater/edit/FavFolder;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LoadingIndicator", "(Landroidx/compose/runtime/Composer;I)V", "ProcessingDialog", "watch_later_debug", "onDismissRequestState", "isLoading", "", "isFavoriting"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FavoritesFolderBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteSingleBottomSheet$lambda$8(int i, String str, Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        FavoriteSingleBottomSheet(i, str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderHeader$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        FolderHeader(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderItem$lambda$2(FavFolder favFolder, Function0 function0, int i, Composer composer, int i2) {
        FolderItem(favFolder, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoadingIndicator$lambda$1(int i, Composer composer, int i2) {
        LoadingIndicator(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProcessingDialog$lambda$1(int i, Composer composer, int i2) {
        ProcessingDialog(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0222 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void FavoriteSingleBottomSheet(final int opType, final String resources, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Composer $composer2;
        Unit unit;
        int i;
        State isFavoriting$delegate;
        boolean invalid$iv;
        State onDismissRequestState$delegate;
        boolean invalid$iv2;
        Toaster toaster;
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(function02, "onOperateSuccess");
        Composer $composer3 = $composer.startRestartGroup(1021686410);
        ComposerKt.sourceInformation($composer3, "C(FavoriteSingleBottomSheet)N(opType,resources,onDismissRequest,onOperateSuccess)80@3626L38,81@3685L38,82@3744L23,83@3789L59,84@3894L7,86@3940L583,86@3919L604,105@4565L16,106@4629L16,107@4677L7,108@4714L7,109@4747L235,109@4726L256,118@5055L194,118@5001L248,155@6190L6,161@6335L2215,128@5269L3281:FavoritesFolderBottomSheet.kt#rnkbx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(opType) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(resources) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1021686410, $dirty2, -1, "kntr.watch.later.watchlater.edit.FavoriteSingleBottomSheet (FavoritesFolderBottomSheet.kt:79)");
            }
            State onDismissRequestState$delegate2 = SnapshotStateKt.rememberUpdatedState(function0, $composer3, ($dirty2 >> 6) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, -1706863216, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new FavoriteSingleViewModel();
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final FavoriteSingleViewModel viewModel = (FavoriteSingleViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final LazyListState listState = LazyListStateKt.rememberLazyListState(0, 0, $composer3, 0, 3);
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) null, $composer3, 6, 2);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            LifecycleOwner lifecycleOwner = (LifecycleOwner) consume;
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1706854511, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            boolean invalid$iv3 = (($dirty2 & 14) == 4) | $composer3.changedInstance(viewModel) | $composer3.changed(onDismissRequestState$delegate2) | $composer3.changedInstance(lifecycleOwner);
            Object value$iv2 = $composer3.rememberedValue();
            if (!invalid$iv3 && value$iv2 != Composer.Companion.getEmpty()) {
                unit = unit2;
                i = 6;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer3, i);
                final State isLoading$delegate = SnapshotStateKt.collectAsState(viewModel.isLoading(), (CoroutineContext) null, $composer3, 0, 1);
                isFavoriting$delegate = SnapshotStateKt.collectAsState(viewModel.isFavoriting(), (CoroutineContext) null, $composer3, 0, 1);
                CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Toaster toaster2 = (Toaster) consume2;
                CompositionLocal this_$iv3 = RouterKt.getLocalRouter();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume3 = $composer3.consume(this_$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                final Router router = (Router) consume3;
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1706829035, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
                invalid$iv = $composer3.changedInstance(viewModel) | $composer3.changedInstance(toaster2);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv) {
                    onDismissRequestState$delegate = onDismissRequestState$delegate2;
                    if (it$iv2 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(unit3, (Function2) it$iv2, $composer3, 6);
                        Boolean valueOf = Boolean.valueOf(listState.getCanScrollForward());
                        Boolean valueOf2 = Boolean.valueOf(FavoriteSingleBottomSheet$lambda$3(isLoading$delegate));
                        ComposerKt.sourceInformationMarkerStart($composer3, -1706819220, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
                        invalid$iv2 = $composer3.changed(listState) | $composer3.changed(isLoading$delegate) | $composer3.changedInstance(viewModel);
                        Object it$iv3 = $composer3.rememberedValue();
                        if (invalid$iv2 && it$iv3 != Composer.Companion.getEmpty()) {
                            toaster = toaster2;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv3, $composer3, 0);
                            $composer2 = $composer3;
                            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0.0f, 0L, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2611getLambda$977763723$watch_later_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1424447720, true, new Function3() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda9
                                public final Object invoke(Object obj, Object obj2, Object obj3) {
                                    Unit FavoriteSingleBottomSheet$lambda$7;
                                    FavoriteSingleBottomSheet$lambda$7 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7(Router.this, listState, viewModel, resources, function02, function0, isLoading$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                    return FavoriteSingleBottomSheet$lambda$7;
                                }
                            }, $composer3, 54), $composer2, (($dirty2 >> 6) & 14) | 48, 3078, 7064);
                            if (FavoriteSingleBottomSheet$lambda$4(isFavoriting$delegate)) {
                                $composer2.startReplaceGroup(-1368287498);
                                ComposerKt.sourceInformation($composer2, "229@8599L18");
                                ProcessingDialog($composer2, 0);
                            } else {
                                $composer2.startReplaceGroup(-1376809832);
                            }
                            $composer2.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        toaster = toaster2;
                        Object value$iv3 = (Function2) new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1(listState, viewModel, isLoading$delegate, null);
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv3 = value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv3, $composer3, 0);
                        $composer2 = $composer3;
                        ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0.0f, 0L, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2611getLambda$977763723$watch_later_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1424447720, true, new Function3() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda9
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                Unit FavoriteSingleBottomSheet$lambda$7;
                                FavoriteSingleBottomSheet$lambda$7 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7(Router.this, listState, viewModel, resources, function02, function0, isLoading$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                return FavoriteSingleBottomSheet$lambda$7;
                            }
                        }, $composer3, 54), $composer2, (($dirty2 >> 6) & 14) | 48, 3078, 7064);
                        if (FavoriteSingleBottomSheet$lambda$4(isFavoriting$delegate)) {
                        }
                        $composer2.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                } else {
                    onDismissRequestState$delegate = onDismissRequestState$delegate2;
                }
                Object value$iv4 = (Function2) new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$2$1(viewModel, toaster2, null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(unit3, (Function2) it$iv2, $composer3, 6);
                Boolean valueOf3 = Boolean.valueOf(listState.getCanScrollForward());
                Boolean valueOf22 = Boolean.valueOf(FavoriteSingleBottomSheet$lambda$3(isLoading$delegate));
                ComposerKt.sourceInformationMarkerStart($composer3, -1706819220, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
                invalid$iv2 = $composer3.changed(listState) | $composer3.changed(isLoading$delegate) | $composer3.changedInstance(viewModel);
                Object it$iv32 = $composer3.rememberedValue();
                if (invalid$iv2) {
                    toaster = toaster2;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(valueOf3, valueOf22, (Function2) it$iv32, $composer3, 0);
                    $composer2 = $composer3;
                    ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0.0f, 0L, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2611getLambda$977763723$watch_later_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1424447720, true, new Function3() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit FavoriteSingleBottomSheet$lambda$7;
                            FavoriteSingleBottomSheet$lambda$7 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7(Router.this, listState, viewModel, resources, function02, function0, isLoading$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return FavoriteSingleBottomSheet$lambda$7;
                        }
                    }, $composer3, 54), $composer2, (($dirty2 >> 6) & 14) | 48, 3078, 7064);
                    if (FavoriteSingleBottomSheet$lambda$4(isFavoriting$delegate)) {
                    }
                    $composer2.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                toaster = toaster2;
                Object value$iv32 = (Function2) new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1(listState, viewModel, isLoading$delegate, null);
                $composer3.updateRememberedValue(value$iv32);
                it$iv32 = value$iv32;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(valueOf3, valueOf22, (Function2) it$iv32, $composer3, 0);
                $composer2 = $composer3;
                ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0.0f, 0L, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2611getLambda$977763723$watch_later_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1424447720, true, new Function3() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit FavoriteSingleBottomSheet$lambda$7;
                        FavoriteSingleBottomSheet$lambda$7 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7(Router.this, listState, viewModel, resources, function02, function0, isLoading$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return FavoriteSingleBottomSheet$lambda$7;
                    }
                }, $composer3, 54), $composer2, (($dirty2 >> 6) & 14) | 48, 3078, 7064);
                if (FavoriteSingleBottomSheet$lambda$4(isFavoriting$delegate)) {
                }
                $composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            unit = unit2;
            i = 6;
            value$iv2 = new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$1$1(viewModel, lifecycleOwner, opType, onDismissRequestState$delegate2, null);
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv2, $composer3, i);
            final State isLoading$delegate2 = SnapshotStateKt.collectAsState(viewModel.isLoading(), (CoroutineContext) null, $composer3, 0, 1);
            isFavoriting$delegate = SnapshotStateKt.collectAsState(viewModel.isFavoriting(), (CoroutineContext) null, $composer3, 0, 1);
            CompositionLocal this_$iv22 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume22 = $composer3.consume(this_$iv22);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Toaster toaster22 = (Toaster) consume22;
            CompositionLocal this_$iv32 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume32 = $composer3.consume(this_$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router2 = (Router) consume32;
            Unit unit32 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1706829035, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            invalid$iv = $composer3.changedInstance(viewModel) | $composer3.changedInstance(toaster22);
            Object it$iv22 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv42 = (Function2) new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$2$1(viewModel, toaster22, null);
            $composer3.updateRememberedValue(value$iv42);
            it$iv22 = value$iv42;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit32, (Function2) it$iv22, $composer3, 6);
            Boolean valueOf32 = Boolean.valueOf(listState.getCanScrollForward());
            Boolean valueOf222 = Boolean.valueOf(FavoriteSingleBottomSheet$lambda$3(isLoading$delegate2));
            ComposerKt.sourceInformationMarkerStart($composer3, -1706819220, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            invalid$iv2 = $composer3.changed(listState) | $composer3.changed(isLoading$delegate2) | $composer3.changedInstance(viewModel);
            Object it$iv322 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            toaster = toaster22;
            Object value$iv322 = (Function2) new FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$3$1(listState, viewModel, isLoading$delegate2, null);
            $composer3.updateRememberedValue(value$iv322);
            it$iv322 = value$iv322;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(valueOf32, valueOf222, (Function2) it$iv322, $composer3, 0);
            $composer2 = $composer3;
            ModalBottomSheetKt.ModalBottomSheet-YbuCTN8(function0, SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), sheetState, 0.0f, false, RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(8), Dp.constructor-impl(8), 0.0f, 0.0f, 12, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), 0L, 0.0f, 0L, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2611getLambda$977763723$watch_later_debug(), (Function2) null, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1424447720, true, new Function3() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit FavoriteSingleBottomSheet$lambda$7;
                    FavoriteSingleBottomSheet$lambda$7 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7(Router.this, listState, viewModel, resources, function02, function0, isLoading$delegate2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return FavoriteSingleBottomSheet$lambda$7;
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 6) & 14) | 48, 3078, 7064);
            if (FavoriteSingleBottomSheet$lambda$4(isFavoriting$delegate)) {
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit FavoriteSingleBottomSheet$lambda$8;
                    FavoriteSingleBottomSheet$lambda$8 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$8(opType, resources, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FavoriteSingleBottomSheet$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> FavoriteSingleBottomSheet$lambda$0(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean FavoriteSingleBottomSheet$lambda$3(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final boolean FavoriteSingleBottomSheet$lambda$4(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0270  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit FavoriteSingleBottomSheet$lambda$7(final Router $router, LazyListState $listState, final FavoriteSingleViewModel $viewModel, final String $resources, final Function0 $onOperateSuccess, final Function0 $onDismissRequest, final State $isLoading$delegate, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C162@6345L2199:FavoritesFolderBottomSheet.kt#rnkbx");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1424447720, $changed, -1, "kntr.watch.later.watchlater.edit.FavoriteSingleBottomSheet.<anonymous> (FavoritesFolderBottomSheet.kt:162)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxHeight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.5555556f), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -345842344, "C171@6633L84,170@6589L143,176@6746L41,184@6983L1496,179@6825L1654,223@8493L41:FavoritesFolderBottomSheet.kt#rnkbx");
            ComposerKt.sourceInformationMarkerStart($composer, -288251322, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($router);
            Object it$iv2 = $composer.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                ComposerKt.sourceInformationMarkerEnd($composer);
                FolderHeader((Function0) it$iv2, $composer, 0);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -288238710, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
                invalid$iv = $composer.changedInstance($viewModel) | $composer.changed($resources) | $composer.changed($onOperateSuccess) | $composer.changed($onDismissRequest) | $composer.changed($isLoading$delegate);
                it$iv = $composer.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    value$iv = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    LazyDslKt.LazyColumn(fillMaxWidth$default, $listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 6, 508);
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
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
                value$iv = new Function1() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        Unit FavoriteSingleBottomSheet$lambda$7$0$1$0;
                        FavoriteSingleBottomSheet$lambda$7$0$1$0 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7$0$1$0(FavoriteSingleViewModel.this, $resources, $onOperateSuccess, $onDismissRequest, $isLoading$delegate, (LazyListScope) obj);
                        return FavoriteSingleBottomSheet$lambda$7$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                LazyDslKt.LazyColumn(fillMaxWidth$default, $listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 6, 508);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit FavoriteSingleBottomSheet$lambda$7$0$0$0;
                    FavoriteSingleBottomSheet$lambda$7$0$0$0 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7$0$0$0(Router.this);
                    return FavoriteSingleBottomSheet$lambda$7$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            FolderHeader((Function0) it$iv2, $composer, 0);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer, 6);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -288238710, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            invalid$iv = $composer.changedInstance($viewModel) | $composer.changed($resources) | $composer.changed($onOperateSuccess) | $composer.changed($onDismissRequest) | $composer.changed($isLoading$delegate);
            it$iv = $composer.rememberedValue();
            if (!invalid$iv) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                LazyDslKt.LazyColumn(fillMaxWidth$default2, $listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 6, 508);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv = new Function1() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj) {
                    Unit FavoriteSingleBottomSheet$lambda$7$0$1$0;
                    FavoriteSingleBottomSheet$lambda$7$0$1$0 = FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet$lambda$7$0$1$0(FavoriteSingleViewModel.this, $resources, $onOperateSuccess, $onDismissRequest, $isLoading$delegate, (LazyListScope) obj);
                    return FavoriteSingleBottomSheet$lambda$7$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            LazyDslKt.LazyColumn(fillMaxWidth$default2, $listState, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv, $composer, 6, 508);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer, 6);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteSingleBottomSheet$lambda$7$0$0$0(Router $router) {
        $router.launch(UrisKt.toUri(WatchLaterConsts_androidKt.getCREATE_COLLECTION_URL()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteSingleBottomSheet$lambda$7$0$1$0(final FavoriteSingleViewModel $viewModel, final String $resources, final Function0 $onOperateSuccess, final Function0 $onDismissRequest, State $isLoading$delegate, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        final List items$iv = $viewModel.getFolders();
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$lambda$7$0$1$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$lambda$7$0$1$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:58:0x0365  */
            /* JADX WARN: Removed duplicated region for block: B:59:0x038f  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x03b9  */
            /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                Composer $composer2;
                Composer $composer$iv;
                Composer $composer3;
                Composer $composer$iv2;
                Composer $composer4;
                Object value$iv;
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
                    final FavFolder folder = (FavFolder) items$iv.get(it);
                    $composer.startReplaceGroup(641916989);
                    ComposerKt.sourceInformation($composer, "CN(index,folder)*186@7072L1172:FavoritesFolderBottomSheet.kt#rnkbx");
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.Companion;
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 202144382, "C187@7105L826:FavoritesFolderBottomSheet.kt#rnkbx");
                    Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(60)), 0.0f, 1, (Object) null);
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
                    ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScope boxScope = BoxScopeInstance.INSTANCE;
                    int i4 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1721292491, "C196@7518L356,194@7415L490:FavoritesFolderBottomSheet.kt#rnkbx");
                    ComposerKt.sourceInformationMarkerStart($composer, -83018606, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($viewModel) | (((($changed2 & 896) ^ 384) > 256 && $composer.changed(folder)) || ($changed2 & 384) == 256) | $composer.changed($resources) | $composer.changed($onOperateSuccess) | $composer.changed($onDismissRequest);
                    Object it$iv = $composer.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        $composer2 = $composer;
                        $composer$iv = $composer;
                        $composer4 = $composer;
                        value$iv = it$iv;
                        $composer$iv2 = $composer;
                        $composer3 = $composer;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Composer $composer5 = $composer2;
                        FavoritesFolderBottomSheetKt.FolderItem(folder, (Function0) value$iv, $composer5, ($changed2 >> 6) & 14);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if (it == CollectionsKt.getLastIndex($viewModel.getFolders())) {
                            $composer3.startReplaceGroup(203002554);
                            ComposerKt.sourceInformation($composer3, "207@8028L168");
                            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), 0L, $composer3, 54, 4);
                        } else {
                            $composer3.startReplaceGroup(195060602);
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer4.endReplaceGroup();
                        if (!ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    final FavoriteSingleViewModel favoriteSingleViewModel = $viewModel;
                    final String str = $resources;
                    final Function0 function0 = $onOperateSuccess;
                    final Function0 function02 = $onDismissRequest;
                    $composer2 = $composer;
                    $composer$iv = $composer;
                    $composer3 = $composer;
                    $composer$iv2 = $composer;
                    $composer4 = $composer;
                    value$iv = (Function0) new Function0<Unit>() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$FavoriteSingleBottomSheet$4$1$2$1$1$1$1$1$1
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2622invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m2622invoke() {
                            FavoriteSingleViewModel.this.submitFromWatchLater(folder, str, function0, function02);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Composer $composer52 = $composer2;
                    FavoritesFolderBottomSheetKt.FolderItem(folder, (Function0) value$iv, $composer52, ($changed2 >> 6) & 14);
                    ComposerKt.sourceInformationMarkerEnd($composer52);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    if (it == CollectionsKt.getLastIndex($viewModel.getFolders())) {
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer4.endReplaceGroup();
                    if (!ComposerKt.isTraceInProgress()) {
                    }
                } else {
                    $composer.skipToGroupEnd();
                }
            }
        }));
        if (FavoriteSingleBottomSheet$lambda$3($isLoading$delegate) && !$viewModel.getFolders().isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.getLambda$964076930$watch_later_debug(), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private static final void FolderHeader(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-132666659);
        ComposerKt.sourceInformation($composer3, "C(FolderHeader)N(onAddFolder)236@8735L1578:FavoritesFolderBottomSheet.kt#rnkbx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-132666659, $dirty, -1, "kntr.watch.later.watchlater.edit.FolderHeader (FavoritesFolderBottomSheet.kt:235)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 36218769, "C241@8914L672,266@9720L17,262@9596L711:FavoritesFolderBottomSheet.kt#rnkbx");
            Modifier modifier$iv2 = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            $composer2 = $composer3;
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i4 = ((390 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1704118421, "C246@9087L49,245@9055L221,252@9290L39,255@9372L62,256@9470L9,257@9519L6,254@9343L233:FavoritesFolderBottomSheet.kt#rnkbx");
            IconKt.Icon(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getPlayset_icon_folder(Res.drawable.INSTANCE), $composer3, 0), (ColorProducer) null, "Folder", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, Painter.$stable | 3504, 0);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(5)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getFavorites_global_string_17(FavoritesRes.INSTANCE.getString()), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17(), $composer3, 0, 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1384280558, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit FolderHeader$lambda$0$1$0;
                        FolderHeader$lambda$0$1$0 = FavoritesFolderBottomSheetKt.FolderHeader$lambda$0$1$0(function0);
                        return FolderHeader$lambda$0$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(wrapContentWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
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
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope3 = RowScopeInstance.INSTANCE;
            int i6 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1008492467, "C270@9868L17,269@9823L173,275@10010L39,278@10092L63,279@10191L9,280@10240L6,277@10063L234:FavoritesFolderBottomSheet.kt#rnkbx");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getPlus_add_line_500($composer3, 6), "Folder", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), 0L, $composer3, Painter.$stable | 432, 8);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(5)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getFavorites_global_string_113(FavoritesRes.INSTANCE.getString()), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, 0, 24576, 114682);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit FolderHeader$lambda$1;
                    FolderHeader$lambda$1 = FavoritesFolderBottomSheetKt.FolderHeader$lambda$1(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FolderHeader$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderHeader$lambda$0$1$0(Function0 $onAddFolder) {
        $onAddFolder.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FolderItem(final FavFolder folder, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        String str;
        Composer $composer3 = $composer.startRestartGroup(-815295718);
        ComposerKt.sourceInformation($composer3, "C(FolderItem)N(folder,onClick)296@10516L13,292@10409L1303:FavoritesFolderBottomSheet.kt#rnkbx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(folder) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-815295718, $dirty, -1, "kntr.watch.later.watchlater.edit.FolderItem (FavoritesFolderBottomSheet.kt:291)");
            }
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1815131385, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit FolderItem$lambda$0$0;
                        FolderItem$lambda$0$0 = FavoritesFolderBottomSheetKt.FolderItem$lambda$0$0(function0);
                        return FolderItem$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 2071132428, "C300@10622L9,301@10667L6,298@10547L215,305@10771L40,306@10820L886:FavoritesFolderBottomSheet.kt#rnkbx");
            String title = folder.getTitle();
            if (title == null) {
                title = "";
            }
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, 0, 24960, 110586);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -580272587, "C314@11188L9,315@11237L6,307@10838L426,318@11278L39,322@11380L204,327@11620L9,328@11669L6,320@11331L365:FavoritesFolderBottomSheet.kt#rnkbx");
            if (MediaAttrUtils.INSTANCE.isMTPlaylistPublic(folder.getAttr())) {
                $composer3.startReplaceGroup(-580210433);
                ComposerKt.sourceInformation($composer3, "310@10950L63");
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getFavorites_global_string_238(FavoritesRes.INSTANCE.getString()), $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource;
            } else {
                $composer3.startReplaceGroup(-580094369);
                ComposerKt.sourceInformation($composer3, "312@11067L63");
                String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getFavorites_global_string_131(FavoritesRes.INSTANCE.getString()), $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 131066);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            TextKt.Text-Nvy7gAk(PluralStringResourcesKt.pluralStringResource(Plurals0_commonMainKt.getFavorites_global_string_249(FavoritesRes.INSTANCE.getPlurals()), folder.getCount(), new Object[]{String.valueOf(folder.getCount())}, $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 131066);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FolderItem$lambda$2;
                    FolderItem$lambda$2 = FavoritesFolderBottomSheetKt.FolderItem$lambda$2(FavFolder.this, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FolderItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderItem$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LoadingIndicator(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1571727537);
        ComposerKt.sourceInformation($composer2, "C(LoadingIndicator)336@11765L290:FavoritesFolderBottomSheet.kt#rnkbx");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571727537, $changed, -1, "kntr.watch.later.watchlater.edit.LoadingIndicator (FavoritesFolderBottomSheet.kt:335)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
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
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -564360503, "C343@11936L113:FavoritesFolderBottomSheet.kt#rnkbx");
            ProgressIndicatorKt.CircularProgressIndicator-4lLiAd8(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), 0L, Dp.constructor-impl(3), 0L, 0, 0.0f, $composer2, 390, 58);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoadingIndicator$lambda$1;
                    LoadingIndicator$lambda$1 = FavoritesFolderBottomSheetKt.LoadingIndicator$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoadingIndicator$lambda$1;
                }
            });
        }
    }

    private static final void ProcessingDialog(Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(889685847);
        ComposerKt.sourceInformation($composer3, "C(ProcessingDialog)353@12148L14,352@12108L461:FavoritesFolderBottomSheet.kt#rnkbx");
        if (!$composer3.shouldExecute($changed != 0, $changed & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(889685847, $changed, -1, "kntr.watch.later.watchlater.edit.ProcessingDialog (FavoritesFolderBottomSheet.kt:351)");
            }
            Modifier modifier = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(280), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 289609285, "CC(remember):FavoritesFolderBottomSheet.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.AlertDialog-Oix01E0((Function0) it$iv, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.m2610getLambda$1224384097$watch_later_debug(), modifier, (Function2) null, (Function2) null, (Function2) null, ComposableSingletons$FavoritesFolderBottomSheetKt.INSTANCE.getLambda$913060132$watch_later_debug(), (Shape) null, 0L, 0L, 0L, 0L, 0.0f, (DialogProperties) null, $composer2, 1573302, 0, 16312);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProcessingDialog$lambda$1;
                    ProcessingDialog$lambda$1 = FavoritesFolderBottomSheetKt.ProcessingDialog$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ProcessingDialog$lambda$1;
                }
            });
        }
    }
}