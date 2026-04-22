package kntr.watch.later.watchlater;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import bili.resource.favorites.FavoritesRes;
import bili.resource.favorites.String0_commonMainKt;
import bili.resource.homepage.HomepageRes;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Router;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kntr.watch.later.watchlater.compose.WatchLaterPageComposeKt;
import kntr.watch.later.watchlater.data.DialogType;
import kntr.watch.later.watchlater.data.FavEditState;
import kntr.watch.later.watchlater.data.WatchLaterItem;
import kntr.watch.later.watchlater.data.WatchLaterState;
import kntr.watch.later.watchlater.edit.FavoritesFolderBottomSheetKt;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kntr.watch.later.watchlater.viewmodel.WatchLaterViewModel;
import kntr.watch.later.watchlater.widget.CustomDialogKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatcherLaterScreen.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u000b\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\nH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\nH\u0002\u001a\u0012\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f*\u00020\nH\u0002\u001a,\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0002¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u0084\u0002²\u0006\f\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u008a\u0084\u0002²\u0006\u0012\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u008a\u0084\u0002²\u0006\f\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u008a\u0084\u0002"}, d2 = {"WatchLaterScreen", "", "onBackClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AlertDialog", "dialog", "Lkntr/watch/later/watchlater/DialogInfo;", "(Lkntr/watch/later/watchlater/DialogInfo;Landroidx/compose/runtime/Composer;I)V", "rememberWatchLaterViewModel", "Lkntr/watch/later/watchlater/viewmodel/WatchLaterViewModel;", "(Landroidx/compose/runtime/Composer;I)Lkntr/watch/later/watchlater/viewmodel/WatchLaterViewModel;", "dismissBottomSheet", "dismissDialog", "generateManageBottomSheetItems", "", "LBottomSheetItemData;", "getDialogInfo", "dialogType", "Lkntr/watch/later/watchlater/data/DialogType;", "onCacnel", "onConfirm", "watch_later_debug", "pageState", "Lkntr/watch/later/watchlater/data/WatchLaterState;", "buttonClickable", "", "dialogInfo", "bottomSheetItems", "favEditState", "Lkntr/watch/later/watchlater/data/FavEditState;"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatcherLaterScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AlertDialog$lambda$0(DialogInfo dialogInfo, int i, Composer composer, int i2) {
        AlertDialog(dialogInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$9(Function0 function0, int i, Composer composer, int i2) {
        WatchLaterScreen(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void WatchLaterScreen(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(function0, "onBackClick");
        Composer $composer3 = $composer.startRestartGroup(229914424);
        ComposerKt.sourceInformation($composer3, "C(WatchLaterScreen)N(onBackClick)63@2969L29,64@3046L16,65@3116L21,66@3181L16,67@3253L16,68@3317L16,69@3363L7,70@3375L49,71@3450L188,71@3429L209,77@3669L535,95@4236L630,113@4882L1926,113@4872L1936:WatcherLaterScreen.kt#buddnv");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(229914424, $dirty2, -1, "kntr.watch.later.watchlater.WatchLaterScreen (WatcherLaterScreen.kt:62)");
            }
            final WatchLaterViewModel viewModel = rememberWatchLaterViewModel($composer3, 0);
            final State pageState$delegate = SnapshotStateKt.collectAsState(viewModel.getWatchLaterState(), (CoroutineContext) null, $composer3, 0, 1);
            final State buttonClickable$delegate = SnapshotStateKt.collectAsState(viewModel.getButtonClickable(), false, (CoroutineContext) null, $composer3, 48, 2);
            final State dialogInfo$delegate = SnapshotStateKt.collectAsState(viewModel.getDialogInfo(), (CoroutineContext) null, $composer3, 0, 1);
            final State bottomSheetItems$delegate = SnapshotStateKt.collectAsState(viewModel.getBottomSheetItems$watch_later_debug(), (CoroutineContext) null, $composer3, 0, 1);
            final State favEditState$delegate = SnapshotStateKt.collectAsState(viewModel.getFavEditState(), (CoroutineContext) null, $composer3, 0, 1);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Router router = (Router) consume;
            PvTriggerEntranceKt.rememberPvEventTrigger("main.later-watch.0.0.pv", $composer3, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1904447124, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(viewModel);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new WatcherLaterScreenKt$WatchLaterScreen$1$1(viewModel, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 1904454479, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit WatchLaterScreen$lambda$6$0;
                        WatchLaterScreen$lambda$6$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$6$0(WatchLaterViewModel.this, router, ((Boolean) obj).booleanValue(), (WatchLaterItem) obj2);
                        return WatchLaterScreen$lambda$6$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function2 onCardClick = (Function2) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1904472718, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj, Object obj2) {
                        Unit WatchLaterScreen$lambda$7$0;
                        WatchLaterScreen$lambda$7$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$7$0(WatchLaterViewModel.this, ((Boolean) obj).booleanValue(), (WatchLaterItem) obj2);
                        return WatchLaterScreen$lambda$7$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final Function2 onLongClick = (Function2) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-496481152, true, new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterScreen$lambda$8;
                    WatchLaterScreen$lambda$8 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8(WatchLaterViewModel.this, function0, router, onCardClick, onLongClick, bottomSheetItems$delegate, dialogInfo$delegate, favEditState$delegate, pageState$delegate, buttonClickable$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterScreen$lambda$8;
                }
            }, $composer3, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterScreen$lambda$9;
                    WatchLaterScreen$lambda$9 = WatcherLaterScreenKt.WatchLaterScreen$lambda$9(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterScreen$lambda$9;
                }
            });
        }
    }

    private static final WatchLaterState WatchLaterScreen$lambda$0(State<WatchLaterState> state) {
        Object thisObj$iv = state.getValue();
        return (WatchLaterState) thisObj$iv;
    }

    private static final boolean WatchLaterScreen$lambda$1(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    private static final DialogInfo WatchLaterScreen$lambda$2(State<DialogInfo> state) {
        Object thisObj$iv = state.getValue();
        return (DialogInfo) thisObj$iv;
    }

    private static final List<BottomSheetItemData> WatchLaterScreen$lambda$3(State<? extends List<BottomSheetItemData>> state) {
        Object thisObj$iv = state.getValue();
        return (List) thisObj$iv;
    }

    private static final FavEditState WatchLaterScreen$lambda$4(State<FavEditState> state) {
        Object thisObj$iv = state.getValue();
        return (FavEditState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$6$0(WatchLaterViewModel $viewModel, Router $router, boolean checkMode, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (checkMode) {
            $viewModel.onCardCheckClick(item.getItemId());
        } else {
            String it = item.getUri();
            if (it != null) {
                $router.launch(UrisKt.toUri(it));
            }
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_CARD_CLICK, MapsKt.mapOf(TuplesKt.to(WatchLaterReporterKt.KEY_AVID, String.valueOf(item.getAid()))));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$7$0(WatchLaterViewModel $viewModel, boolean checkMode, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (checkMode) {
            $viewModel.onCardCheckClick(item.getItemId());
        } else {
            $viewModel.onCardCheckClick(item.getItemId());
            $viewModel.changeCheckState();
            WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "1"), TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, "1")}));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x02e7, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0321, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x035b, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0395, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x03cd, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c6, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x023b, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0273, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02ad, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L59;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit WatchLaterScreen$lambda$8(final WatchLaterViewModel $viewModel, Function0 $onBackClick, final Router $router, Function2 $onCardClick, Function2 $onLongClick, State $bottomSheetItems$delegate, State $dialogInfo$delegate, State $favEditState$delegate, State $pageState$delegate, State $buttonClickable$delegate, Composer $composer, int $changed) {
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        boolean invalid$iv5;
        boolean invalid$iv6;
        boolean invalid$iv7;
        boolean invalid$iv8;
        ComposerKt.sourceInformation($composer, "C142@5789L29,143@5852L34,146@5998L65,149@6093L65,152@6185L40,153@6252L40,154@6318L37,155@6384L41,156@6459L45,157@6536L40,158@6609L41,159@6680L50,160@6764L27,136@5504L1298:WatcherLaterScreen.kt#buddnv");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-496481152, $changed, -1, "kntr.watch.later.watchlater.WatchLaterScreen.<anonymous> (WatcherLaterScreen.kt:114)");
            }
            List it = WatchLaterScreen$lambda$3($bottomSheetItems$delegate);
            it = (it == null || it.isEmpty()) ? null : null;
            if (it == null) {
                $composer.startReplaceGroup(1197429790);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1197429791);
                ComposerKt.sourceInformation($composer, "*117@5038L70,115@4956L167");
                ComposerKt.sourceInformationMarkerStart($composer, 151275093, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                boolean invalid$iv9 = $composer.changedInstance($viewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv9 || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit WatchLaterScreen$lambda$8$1$0$0;
                            WatchLaterScreen$lambda$8$1$0$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$1$0$0(WatchLaterViewModel.this);
                            return WatchLaterScreen$lambda$8$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                CustomBottomSheetKt.CustomBottomSheet(it, (Function0) it$iv, $composer, 0);
                Unit unit = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            DialogInfo dialog = WatchLaterScreen$lambda$2($dialogInfo$delegate);
            if (dialog == null) {
                $composer.startReplaceGroup(1197640776);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1197640777);
                ComposerKt.sourceInformation($composer, "*124@5183L19");
                AlertDialog(dialog, $composer, 0);
                Unit unit3 = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            }
            FavEditState it2 = WatchLaterScreen$lambda$4($favEditState$delegate);
            if (it2 == null) {
                $composer.startReplaceGroup(1197727359);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1197727360);
                ComposerKt.sourceInformation($composer, "*128@5254L230");
                FavoritesFolderBottomSheetKt.FavoriteSingleBottomSheet(it2.getOpType(), it2.getResources(), it2.getOnDismissRequest(), it2.getOnOperateSuccess(), $composer, 0);
                Unit unit5 = Unit.INSTANCE;
                $composer.endReplaceGroup();
                Unit unit6 = Unit.INSTANCE;
            }
            WatchLaterState WatchLaterScreen$lambda$0 = WatchLaterScreen$lambda$0($pageState$delegate);
            boolean WatchLaterScreen$lambda$1 = WatchLaterScreen$lambda$1($buttonClickable$delegate);
            LazyListState tabAllListState = $viewModel.getTabAllListState();
            LazyListState tabToViewListState = $viewModel.getTabToViewListState();
            ComposerKt.sourceInformationMarkerStart($composer, -376988163, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv10 = $composer.changedInstance($viewModel);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv10 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit WatchLaterScreen$lambda$8$4$0;
                        WatchLaterScreen$lambda$8$4$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$4$0(WatchLaterViewModel.this);
                        return WatchLaterScreen$lambda$8$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function0 function0 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376986142, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv11 = $composer.changedInstance($viewModel) | $composer.changedInstance($router);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv11 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        Unit WatchLaterScreen$lambda$8$5$0;
                        WatchLaterScreen$lambda$8$5$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$5$0(WatchLaterViewModel.this, $router);
                        return WatchLaterScreen$lambda$8$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function0 function02 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376981439, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv12 = $composer.changedInstance($viewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv12 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit WatchLaterScreen$lambda$8$6$0;
                        WatchLaterScreen$lambda$8$6$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$6$0(WatchLaterViewModel.this);
                        return WatchLaterScreen$lambda$8$6$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            Function0 function03 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376978399, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv13 = $composer.changedInstance($viewModel);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv13) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit WatchLaterScreen$lambda$8$7$0;
                    WatchLaterScreen$lambda$8$7$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$7$0(WatchLaterViewModel.this);
                    return WatchLaterScreen$lambda$8$7$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
            Function0 function04 = (Function0) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376975480, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            boolean invalid$iv14 = $composer.changedInstance($viewModel);
            Object it$iv6 = $composer.rememberedValue();
            if (!invalid$iv14 && it$iv6 != Composer.Companion.getEmpty()) {
                Function2 function2 = (Function2) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376973336, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv = $composer.changedInstance($viewModel);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv6 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$9$0;
                        WatchLaterScreen$lambda$8$9$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$9$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                        return WatchLaterScreen$lambda$8$9$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv7 = value$iv6;
                Function1 function1 = (Function1) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376971227, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv2 = $composer.changedInstance($viewModel);
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv7 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$10$0;
                        WatchLaterScreen$lambda$8$10$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$10$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                        return WatchLaterScreen$lambda$8$10$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv8 = value$iv7;
                Function1 function12 = (Function1) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376969111, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv3 = $composer.changedInstance($viewModel);
                Object it$iv9 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv8 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda12
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$11$0;
                        WatchLaterScreen$lambda$8$11$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$11$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                        return WatchLaterScreen$lambda$8$11$0;
                    }
                };
                $composer.updateRememberedValue(value$iv8);
                it$iv9 = value$iv8;
                Function1 function13 = (Function1) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376966707, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv4 = $composer.changedInstance($viewModel);
                Object it$iv10 = $composer.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv9 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda13
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$12$0;
                        WatchLaterScreen$lambda$8$12$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$12$0(WatchLaterViewModel.this, (WatchLaterItem) obj);
                        return WatchLaterScreen$lambda$8$12$0;
                    }
                };
                $composer.updateRememberedValue(value$iv9);
                it$iv10 = value$iv9;
                Function1 function14 = (Function1) it$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376964248, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv5 = $composer.changedInstance($viewModel);
                Object it$iv11 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv10 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$13$0;
                        WatchLaterScreen$lambda$8$13$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$13$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                        return WatchLaterScreen$lambda$8$13$0;
                    }
                };
                $composer.updateRememberedValue(value$iv10);
                it$iv11 = value$iv10;
                Function1 function15 = (Function1) it$iv11;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376961911, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv6 = $composer.changedInstance($viewModel);
                Object it$iv12 = $composer.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv11 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit WatchLaterScreen$lambda$8$14$0;
                        WatchLaterScreen$lambda$8$14$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$14$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                        return WatchLaterScreen$lambda$8$14$0;
                    }
                };
                $composer.updateRememberedValue(value$iv11);
                it$iv12 = value$iv11;
                Function1 function16 = (Function1) it$iv12;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376959630, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv7 = $composer.changedInstance($viewModel);
                Object it$iv13 = $composer.rememberedValue();
                if (invalid$iv7) {
                }
                Object value$iv12 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit WatchLaterScreen$lambda$8$15$0;
                        WatchLaterScreen$lambda$8$15$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$15$0(WatchLaterViewModel.this);
                        return WatchLaterScreen$lambda$8$15$0;
                    }
                };
                $composer.updateRememberedValue(value$iv12);
                it$iv13 = value$iv12;
                Function0 function05 = (Function0) it$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -376956965, "CC(remember):WatcherLaterScreen.kt#9igjgp");
                invalid$iv8 = $composer.changedInstance($viewModel);
                Object it$iv14 = $composer.rememberedValue();
                if (invalid$iv8) {
                }
                Object value$iv13 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit WatchLaterScreen$lambda$8$16$0;
                        WatchLaterScreen$lambda$8$16$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$16$0(WatchLaterViewModel.this);
                        return WatchLaterScreen$lambda$8$16$0;
                    }
                };
                $composer.updateRememberedValue(value$iv13);
                it$iv14 = value$iv13;
                ComposerKt.sourceInformationMarkerEnd($composer);
                WatchLaterPageComposeKt.WatchLaterPage(WatchLaterScreen$lambda$0, WatchLaterScreen$lambda$1, tabAllListState, tabToViewListState, $onBackClick, function0, function02, $onCardClick, $onLongClick, function03, function04, function2, function1, function12, function13, function14, function15, function16, function05, (Function0) it$iv14, $composer, 113246208, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv14 = (Function2) new WatcherLaterScreenKt$WatchLaterScreen$2$9$1($viewModel, null);
            $composer.updateRememberedValue(value$iv14);
            it$iv6 = value$iv14;
            Function2 function22 = (Function2) it$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376973336, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv = $composer.changedInstance($viewModel);
            Object it$iv72 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv62 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$9$0;
                    WatchLaterScreen$lambda$8$9$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$9$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                    return WatchLaterScreen$lambda$8$9$0;
                }
            };
            $composer.updateRememberedValue(value$iv62);
            it$iv72 = value$iv62;
            Function1 function17 = (Function1) it$iv72;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376971227, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv2 = $composer.changedInstance($viewModel);
            Object it$iv82 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv72 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$10$0;
                    WatchLaterScreen$lambda$8$10$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$10$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                    return WatchLaterScreen$lambda$8$10$0;
                }
            };
            $composer.updateRememberedValue(value$iv72);
            it$iv82 = value$iv72;
            Function1 function122 = (Function1) it$iv82;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376969111, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv3 = $composer.changedInstance($viewModel);
            Object it$iv92 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv82 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$11$0;
                    WatchLaterScreen$lambda$8$11$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$11$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                    return WatchLaterScreen$lambda$8$11$0;
                }
            };
            $composer.updateRememberedValue(value$iv82);
            it$iv92 = value$iv82;
            Function1 function132 = (Function1) it$iv92;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376966707, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv4 = $composer.changedInstance($viewModel);
            Object it$iv102 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv92 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$12$0;
                    WatchLaterScreen$lambda$8$12$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$12$0(WatchLaterViewModel.this, (WatchLaterItem) obj);
                    return WatchLaterScreen$lambda$8$12$0;
                }
            };
            $composer.updateRememberedValue(value$iv92);
            it$iv102 = value$iv92;
            Function1 function142 = (Function1) it$iv102;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376964248, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv5 = $composer.changedInstance($viewModel);
            Object it$iv112 = $composer.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv102 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$13$0;
                    WatchLaterScreen$lambda$8$13$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$13$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                    return WatchLaterScreen$lambda$8$13$0;
                }
            };
            $composer.updateRememberedValue(value$iv102);
            it$iv112 = value$iv102;
            Function1 function152 = (Function1) it$iv112;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376961911, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv6 = $composer.changedInstance($viewModel);
            Object it$iv122 = $composer.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv112 = new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit WatchLaterScreen$lambda$8$14$0;
                    WatchLaterScreen$lambda$8$14$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$14$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                    return WatchLaterScreen$lambda$8$14$0;
                }
            };
            $composer.updateRememberedValue(value$iv112);
            it$iv122 = value$iv112;
            Function1 function162 = (Function1) it$iv122;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376959630, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv7 = $composer.changedInstance($viewModel);
            Object it$iv132 = $composer.rememberedValue();
            if (invalid$iv7) {
            }
            Object value$iv122 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit WatchLaterScreen$lambda$8$15$0;
                    WatchLaterScreen$lambda$8$15$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$15$0(WatchLaterViewModel.this);
                    return WatchLaterScreen$lambda$8$15$0;
                }
            };
            $composer.updateRememberedValue(value$iv122);
            it$iv132 = value$iv122;
            Function0 function052 = (Function0) it$iv132;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -376956965, "CC(remember):WatcherLaterScreen.kt#9igjgp");
            invalid$iv8 = $composer.changedInstance($viewModel);
            Object it$iv142 = $composer.rememberedValue();
            if (invalid$iv8) {
            }
            Object value$iv132 = new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit WatchLaterScreen$lambda$8$16$0;
                    WatchLaterScreen$lambda$8$16$0 = WatcherLaterScreenKt.WatchLaterScreen$lambda$8$16$0(WatchLaterViewModel.this);
                    return WatchLaterScreen$lambda$8$16$0;
                }
            };
            $composer.updateRememberedValue(value$iv132);
            it$iv142 = value$iv132;
            ComposerKt.sourceInformationMarkerEnd($composer);
            WatchLaterPageComposeKt.WatchLaterPage(WatchLaterScreen$lambda$0, WatchLaterScreen$lambda$1, tabAllListState, tabToViewListState, $onBackClick, function0, function02, $onCardClick, $onLongClick, function03, function04, function22, function17, function122, function132, function142, function152, function162, function052, (Function0) it$iv142, $composer, 113246208, 0);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$1$0$0(WatchLaterViewModel $viewModel) {
        dismissBottomSheet($viewModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$4$0(WatchLaterViewModel $viewModel) {
        $viewModel.onManageClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$5$0(WatchLaterViewModel $viewModel, Router $router) {
        $viewModel.jumpPlayList($router);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$6$0(WatchLaterViewModel $viewModel) {
        $viewModel.onClickBatchOP(1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$7$0(WatchLaterViewModel $viewModel) {
        $viewModel.onClickBatchOP(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$9$0(WatchLaterViewModel $viewModel, int index) {
        $viewModel.load(index, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$10$0(WatchLaterViewModel $viewModel, int index) {
        $viewModel.refresh(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$11$0(WatchLaterViewModel $viewModel, int index) {
        $viewModel.load(index, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$12$0(WatchLaterViewModel $viewModel, WatchLaterItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        $viewModel.onThreePointClick(item);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$13$0(WatchLaterViewModel $viewModel, int index) {
        $viewModel.onCheckAll(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$14$0(WatchLaterViewModel $viewModel, int index) {
        $viewModel.onCancelAll(index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$15$0(WatchLaterViewModel $viewModel) {
        $viewModel.showDialog(DialogType.DeleteChecked.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterScreen$lambda$8$16$0(WatchLaterViewModel $viewModel) {
        $viewModel.onSortClick();
        return Unit.INSTANCE;
    }

    private static final void AlertDialog(final DialogInfo dialog, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(519394233);
        ComposerKt.sourceInformation($composer2, "C(AlertDialog)N(dialog)167@6874L291:WatcherLaterScreen.kt#buddnv");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(dialog) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(519394233, $dirty2, -1, "kntr.watch.later.watchlater.AlertDialog (WatcherLaterScreen.kt:166)");
            }
            String title = dialog.getTitle();
            Function0<Unit> onCacnel = dialog.getOnCacnel();
            String message = dialog.getMessage();
            if (message == null) {
                message = "";
            }
            CustomDialogKt.CustomDialog(onCacnel, title, message, dialog.getConfirmText(), dialog.getCancelText(), dialog.getOnConfirm(), dialog.getOnCacnel(), null, $composer2, 0, 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit AlertDialog$lambda$0;
                    AlertDialog$lambda$0 = WatcherLaterScreenKt.AlertDialog$lambda$0(DialogInfo.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AlertDialog$lambda$0;
                }
            });
        }
    }

    private static final WatchLaterViewModel rememberWatchLaterViewModel(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -325443388, "C(rememberWatchLaterViewModel)180@7257L46:WatcherLaterScreen.kt#buddnv");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-325443388, $changed, -1, "kntr.watch.later.watchlater.rememberWatchLaterViewModel (WatcherLaterScreen.kt:179)");
        }
        $composer.startReplaceGroup(781524308);
        ComposerKt.sourceInformation($composer, "*183@7359L7,184@7396L3790,184@7375L3811");
        ComposerKt.sourceInformationMarkerStart($composer, 781518962, "CC(remember):WatcherLaterScreen.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new WatchLaterViewModel();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        WatchLaterViewModel viewModel = (WatchLaterViewModel) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        CompositionLocal this_$iv = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Toaster toaster = (Toaster) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -518098763, "CC(remember):WatcherLaterScreen.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(viewModel) | $composer.changedInstance(toaster);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = (Function2) new WatcherLaterScreenKt$rememberWatchLaterViewModel$2$1$1(viewModel, toaster, null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return viewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissBottomSheet(WatchLaterViewModel $this$dismissBottomSheet) {
        $this$dismissBottomSheet.getBottomSheetItems$watch_later_debug().setValue((Object) null);
    }

    private static final void dismissDialog(WatchLaterViewModel $this$dismissDialog) {
        $this$dismissDialog.getDialogInfo().setValue((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<BottomSheetItemData> generateManageBottomSheetItems(final WatchLaterViewModel $this$generateManageBottomSheetItems) {
        return CollectionsKt.listOf(new BottomSheetItemData[]{new BottomSheetItemData(HomepageRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_228(FavoritesRes.INSTANCE.getString())), (String) null, (Function2) null, 0L, 0L, false, 0, false, new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj) {
                Unit generateManageBottomSheetItems$lambda$0;
                generateManageBottomSheetItems$lambda$0 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$0(WatchLaterViewModel.this, ((Integer) obj).intValue());
                return generateManageBottomSheetItems$lambda$0;
            }
        }, 254, (DefaultConstructorMarker) null), new BottomSheetItemData(HomepageRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_232(FavoritesRes.INSTANCE.getString())), (String) null, (Function2) null, 0L, 0L, false, 0, false, new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                Unit generateManageBottomSheetItems$lambda$1;
                generateManageBottomSheetItems$lambda$1 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$1(WatchLaterViewModel.this, ((Integer) obj).intValue());
                return generateManageBottomSheetItems$lambda$1;
            }
        }, 254, (DefaultConstructorMarker) null), new BottomSheetItemData(FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_103(FavoritesRes.INSTANCE.getString())), (String) null, (Function2) null, 0L, 0L, false, 0, false, new Function1() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                Unit generateManageBottomSheetItems$lambda$2;
                generateManageBottomSheetItems$lambda$2 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$2(WatchLaterViewModel.this, ((Integer) obj).intValue());
                return generateManageBottomSheetItems$lambda$2;
            }
        }, 254, (DefaultConstructorMarker) null)});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$0(final WatchLaterViewModel $this_generateManageBottomSheetItems, int it) {
        dismissBottomSheet($this_generateManageBottomSheetItems);
        $this_generateManageBottomSheetItems.getDialogInfo().setValue(getDialogInfo(DialogType.DeleteWatched.INSTANCE, new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda15
            public final Object invoke() {
                Unit generateManageBottomSheetItems$lambda$0$0;
                generateManageBottomSheetItems$lambda$0$0 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$0$0(WatchLaterViewModel.this);
                return generateManageBottomSheetItems$lambda$0$0;
            }
        }, new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda16
            public final Object invoke() {
                Unit generateManageBottomSheetItems$lambda$0$1;
                generateManageBottomSheetItems$lambda$0$1 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$0$1(WatchLaterViewModel.this);
                return generateManageBottomSheetItems$lambda$0$1;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$0$0(WatchLaterViewModel $this_generateManageBottomSheetItems) {
        $this_generateManageBottomSheetItems.getDialogInfo().setValue((Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$0$1(WatchLaterViewModel $this_generateManageBottomSheetItems) {
        $this_generateManageBottomSheetItems.getDialogInfo().setValue((Object) null);
        $this_generateManageBottomSheetItems.onDialogConfirm(DialogType.DeleteWatched.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$1(final WatchLaterViewModel $this_generateManageBottomSheetItems, int it) {
        dismissBottomSheet($this_generateManageBottomSheetItems);
        $this_generateManageBottomSheetItems.getDialogInfo().setValue(getDialogInfo(DialogType.DeleteInvalid.INSTANCE, new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda23
            public final Object invoke() {
                Unit generateManageBottomSheetItems$lambda$1$0;
                generateManageBottomSheetItems$lambda$1$0 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$1$0(WatchLaterViewModel.this);
                return generateManageBottomSheetItems$lambda$1$0;
            }
        }, new Function0() { // from class: kntr.watch.later.watchlater.WatcherLaterScreenKt$$ExternalSyntheticLambda24
            public final Object invoke() {
                Unit generateManageBottomSheetItems$lambda$1$1;
                generateManageBottomSheetItems$lambda$1$1 = WatcherLaterScreenKt.generateManageBottomSheetItems$lambda$1$1(WatchLaterViewModel.this);
                return generateManageBottomSheetItems$lambda$1$1;
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$1$0(WatchLaterViewModel $this_generateManageBottomSheetItems) {
        $this_generateManageBottomSheetItems.getDialogInfo().setValue((Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$1$1(WatchLaterViewModel $this_generateManageBottomSheetItems) {
        $this_generateManageBottomSheetItems.getDialogInfo().setValue((Object) null);
        $this_generateManageBottomSheetItems.onDialogConfirm(DialogType.DeleteInvalid.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit generateManageBottomSheetItems$lambda$2(WatchLaterViewModel $this_generateManageBottomSheetItems, int it) {
        dismissBottomSheet($this_generateManageBottomSheetItems);
        $this_generateManageBottomSheetItems.changeCheckState();
        WatchLaterReporterKt.reportWatchLaterClick(WatchLaterReporterKt.EVENT_MANAGE_OPTION_CLICK, MapsKt.mapOf(new Pair[]{TuplesKt.to(WatchLaterReporterKt.KEY_OPTION, "1"), TuplesKt.to(WatchLaterReporterKt.KEY_CLICK_TYPE, "0")}));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DialogInfo getDialogInfo(DialogType dialogType, Function0<Unit> function0, Function0<Unit> function02) {
        String title;
        String message;
        if (Intrinsics.areEqual(dialogType, DialogType.DeleteChecked.INSTANCE)) {
            title = FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_235(FavoritesRes.INSTANCE.getString()));
        } else if (Intrinsics.areEqual(dialogType, DialogType.DeleteInvalid.INSTANCE)) {
            title = FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_236(FavoritesRes.INSTANCE.getString()));
        } else if (!Intrinsics.areEqual(dialogType, DialogType.DeleteWatched.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        } else {
            title = FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_234(FavoritesRes.INSTANCE.getString()));
        }
        if (dialogType instanceof DialogType.DeleteWatched) {
            message = FavoritesRes.INSTANCE.getString(String0_commonMainKt.getFavorites_global_string_224(FavoritesRes.INSTANCE.getString()));
        } else {
            message = null;
        }
        return new DialogInfo(title, message, function02, function0, null, null, 48, null);
    }
}