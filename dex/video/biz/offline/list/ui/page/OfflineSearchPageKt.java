package video.biz.offline.list.ui.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.Plurals0_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.GarbInfo;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import java.util.Set;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.compose.res.CommonRes;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.PluralStringResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.String0_commonMainKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflineCachedCardModel;
import video.biz.offline.list.logic.model.OfflinePageState;
import video.biz.offline.list.logic.model.OfflinePageStateKt;
import video.biz.offline.list.logic.statemachine.OfflineSearchPageStateMachine;
import video.biz.offline.list.ui.utils.ColorUtilsKt;
import video.biz.offline.list.ui.widget.ContentWithStateKt;

/* compiled from: OfflineSearchPage.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003²\u0006\n\u0010\u0004\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\b\u001a\u00020\u0007X\u008a\u008e\u0002²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002"}, d2 = {"OfflineSearchPage", "", "(Landroidx/compose/runtime/Composer;I)V", "ui_debug", "firstRender", "", "searchKeyword", "", "displayKeyword", "state", "Lvideo/biz/offline/list/logic/model/OfflinePageState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSearchPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$15(int i, Composer composer, int i2) {
        OfflineSearchPage(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void OfflineSearchPage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1630975792);
        ComposerKt.sourceInformation($composer2, "C(OfflineSearchPage)76@3602L33,77@3665L7,78@3723L7,79@3747L24,80@3797L31,81@3855L31,84@3912L49,87@4003L7,89@4037L205,96@4274L47,98@4363L7,99@4396L338,99@4375L359,111@4760L150,111@4739L171,118@4977L23,120@5016L7317,120@5006L7327:OfflineSearchPage.kt#rawcr6");
        if ($composer2.shouldExecute($changed != 0, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1630975792, $changed, -1, "video.biz.offline.list.ui.page.OfflineSearchPage (OfflineSearchPage.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -295325327, "CC(remember):OfflineSearchPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(true, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState firstRender$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Router router = (Router) consume;
            final OnBackPressedDispatcher backHandle = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer2, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -295319089, "CC(remember):OfflineSearchPage.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final MutableState searchKeyword$delegate = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -295317233, "CC(remember):OfflineSearchPage.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState displayKeyword$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -295315391, "CC(remember):OfflineSearchPage.kt#9igjgp");
            Object it$iv4 = $composer2.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new FocusRequester();
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            final FocusRequester focus = (FocusRequester) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final FocusManager focusManager = (FocusManager) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, -295311235, "CC(remember):OfflineSearchPage.kt#9igjgp");
            Object it$iv5 = $composer2.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new OfflineSearchPageStateMachine(OfflinePageStateKt.offlineSearchPageInitialState(), router, scope);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            final OfflineSearchPageStateMachine machine = (OfflineSearchPageStateMachine) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final State state$delegate = SnapshotStateKt.collectAsState(machine.getState(), OfflinePageStateKt.offlineSearchPageInitialState(), (CoroutineContext) null, $composer2, OfflinePageState.$stable << 3, 2);
            CompositionLocal this_$iv3 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume3;
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -295299614, "CC(remember):OfflineSearchPage.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(lifecycle);
            Object it$iv6 = $composer2.rememberedValue();
            if (invalid$iv || it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv6 = (Function2) new OfflineSearchPageKt$OfflineSearchPage$1$1(lifecycle, null);
                $composer2.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer2, 6);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -295288154, "CC(remember):OfflineSearchPage.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycle) | $composer2.changedInstance(machine);
            Object it$iv7 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv7 = (Function2) new OfflineSearchPageKt$OfflineSearchPage$2$1(lifecycle, machine, searchKeyword$delegate, null);
                $composer2.updateRememberedValue(value$iv7);
                it$iv7 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit2, (Function2) it$iv7, $composer2, 6);
            final LazyListState lazyListState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(2127979128, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineSearchPage$lambda$14;
                    OfflineSearchPage$lambda$14 = OfflineSearchPageKt.OfflineSearchPage$lambda$14(backHandle, scope, machine, focusManager, focus, searchKeyword$delegate, displayKeyword$delegate, firstRender$delegate, state$delegate, lazyListState, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineSearchPage$lambda$14;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineSearchPage$lambda$15;
                    OfflineSearchPage$lambda$15 = OfflineSearchPageKt.OfflineSearchPage$lambda$15($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineSearchPage$lambda$15;
                }
            });
        }
    }

    private static final boolean OfflineSearchPage$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void OfflineSearchPage$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String OfflineSearchPage$lambda$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String OfflineSearchPage$lambda$7(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final OfflinePageState OfflineSearchPage$lambda$11(State<OfflinePageState> state) {
        Object thisObj$iv = state.getValue();
        return (OfflinePageState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14(final OnBackPressedDispatcher $backHandle, final CoroutineScope $scope, final OfflineSearchPageStateMachine $machine, final FocusManager $focusManager, final FocusRequester $focus, final MutableState $searchKeyword$delegate, final MutableState $displayKeyword$delegate, final MutableState $firstRender$delegate, final State $state$delegate, final LazyListState $lazyListState, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C121@5043L28,122@5091L20,123@5150L10,123@5161L17,125@5240L5166,223@10418L1909,124@5209L7118:OfflineSearchPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2127979128, $changed, -1, "video.biz.offline.list.ui.page.OfflineSearchPage.<anonymous> (OfflineSearchPage.kt:121)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            final float paddingTop = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer, 6), $composer, 0).calculateTopPadding-D9Ej5fM();
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(1555994172, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineSearchPage$lambda$14$0;
                    OfflineSearchPage$lambda$14$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0(paddingTop, $backHandle, $scope, $machine, $focusManager, $focus, $searchKeyword$delegate, $displayKeyword$delegate, $firstRender$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineSearchPage$lambda$14$0;
                }
            }, $composer, 54), (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(1779232327, true, new Function3() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit OfflineSearchPage$lambda$14$1;
                    OfflineSearchPage$lambda$14$1 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$1($state$delegate, $lazyListState, $scope, $machine, $displayKeyword$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return OfflineSearchPage$lambda$14$1;
                }
            }, $composer, 54), $composer, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x06cc, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0645  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0653  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x068c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0714  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x076c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x07f5  */
    /* JADX WARN: Type inference failed for: r1v40 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineSearchPage$lambda$14$0(float $paddingTop, final OnBackPressedDispatcher $backHandle, final CoroutineScope $scope, final OfflineSearchPageStateMachine $machine, final FocusManager $focusManager, final FocusRequester $focus, final MutableState $searchKeyword$delegate, final MutableState $displayKeyword$delegate, final MutableState $firstRender$delegate, Composer $composer, int $changed) {
        boolean z;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Composer $composer3;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv2;
        String str;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv3;
        boolean invalid$iv;
        Object it$iv;
        Object value$iv;
        Object value$iv2;
        boolean invalid$iv2;
        Object it$iv2;
        ComposerKt.sourceInformation($composer, "C126@5258L5134:OfflineSearchPage.kt#rawcr6");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1555994172, $changed, -1, "video.biz.offline.list.ui.page.OfflineSearchPage.<anonymous>.<anonymous> (OfflineSearchPage.kt:126)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl($paddingTop + Dp.constructor-impl(44)));
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
                $composer.createNode(factory$iv$iv$iv2);
            } else {
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
            ComposerKt.sourceInformationMarkerStart($composer, -486599601, "C127@5357L5,136@5829L4545:OfflineSearchPage.kt#rawcr6");
            GarbInfo homeGarb = BiliTheme.INSTANCE.getTheme($composer, BiliTheme.$stable);
            if (homeGarb.getHomePrimaryBgPath().length() == 0) {
                $composer.startReplaceGroup(-486673052);
                $composer.endReplaceGroup();
                z = true;
            } else {
                $composer.startReplaceGroup(1508322567);
                ComposerKt.sourceInformation($composer, "128@5437L10");
                z = !BiliTheme.INSTANCE.getInHomePage($composer, BiliTheme.$stable);
                $composer.endReplaceGroup();
            }
            if (z) {
                $composer.startReplaceGroup(-486630106);
                ComposerKt.sourceInformation($composer, "129@5481L74");
                $composer$iv = $composer;
                BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), ColorKt.Color(homeGarb.getPrimary()), (Shape) null, 2, (Object) null), $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer$iv = $composer;
                $composer.startReplaceGroup(-486499937);
                ComposerKt.sourceInformation($composer, "131@5609L177");
                String $this$asRequest_u24default$iv = homeGarb.getHomePrimaryBgPath();
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer, 48, 508);
                $composer.endReplaceGroup();
            }
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $paddingTop, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 13, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((432 >> 6) & 112) | 6;
            RowScope $this$OfflineSearchPage_u24lambda_u2414_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 382763870, "C151@6580L6,145@6289L3623,212@9978L39,213@10055L19,214@10122L9,216@10227L98,211@9937L415:OfflineSearchPage.kt#rawcr6");
            Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$OfflineSearchPage_u24lambda_u2414_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(32)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(10), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv3 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                $composer.createNode(factory$iv$iv$iv4);
            } else {
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((432 >> 6) & 112) | 6;
            RowScope $this$OfflineSearchPage_u24lambda_u2414_u240_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 976719900, "C158@7006L25,159@7082L6,157@6945L324,170@7742L375,184@8525L469,193@9050L9,177@8168L90,164@7299L1846:OfflineSearchPage.kt#rawcr6");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getMagnifier_search_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(2), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 13, (Object) null), Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            String OfflineSearchPage$lambda$4 = OfflineSearchPage$lambda$4($searchKeyword$delegate);
            String string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2164(PlayerbaseresRes.INSTANCE.getString()));
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.Companion.getSearch-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1694098017, "CC(remember):OfflineSearchPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($scope) | $composer.changedInstance($machine) | $composer.changedInstance($focusManager);
            Object value$iv3 = $composer.rememberedValue();
            if (!invalid$iv3) {
                $composer2 = $composer;
                if (value$iv3 != Composer.Companion.getEmpty()) {
                    $composer$iv3 = $composer;
                    $composer$iv$iv$iv = $composer;
                    $composer3 = $composer2;
                    str = "CC(remember):OfflineSearchPage.kt#9igjgp";
                    $composer$iv$iv = $composer;
                    $composer$iv$iv2 = $composer;
                    $composer$iv2 = $composer;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    KeyboardActions keyboardActions = new KeyboardActions((Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) value$iv3, (Function1) null, 47, (DefaultConstructorMarker) null);
                    Modifier focusRequester = FocusRequesterModifierKt.focusRequester(RowScope.-CC.weight$default($this$OfflineSearchPage_u24lambda_u2414_u240_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $focus);
                    Composer $composer4 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer4, 1694123167, str);
                    invalid$iv = $composer4.changedInstance($scope);
                    it$iv = $composer4.rememberedValue();
                    if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                        value$iv = it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester, (Function1) value$iv);
                        TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14();
                        ComposerKt.sourceInformationMarkerStart($composer4, 1694111364, str);
                        value$iv2 = $composer4.rememberedValue();
                        if (value$iv2 != Composer.Companion.getEmpty()) {
                            value$iv2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda8
                                public final Object invoke(Object obj) {
                                    Unit OfflineSearchPage$lambda$14$0$0$0$0$2$0;
                                    OfflineSearchPage$lambda$14$0$0$0$0$2$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$0$2$0($searchKeyword$delegate, (String) obj);
                                    return OfflineSearchPage$lambda$14$0$0$0$0$2$0;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv2);
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        SimpleTextFieldKt.SimpleTextField(OfflineSearchPage$lambda$4, string, (Function1) value$iv2, onGloballyPositioned, t14, (TextStyle) null, false, true, 0, keyboardOptions, keyboardActions, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer4, 817889664, 0, 14688);
                        if (StringsKt.isBlank(OfflineSearchPage$lambda$4($searchKeyword$delegate))) {
                            $composer4.startReplaceGroup(978925425);
                            ComposerKt.sourceInformation($composer4, "199@9306L27,200@9388L6,203@9558L188,198@9241L615");
                            Painter xmark_close_circle_fill_500 = BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer4, 6);
                            long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_weak-0d7_KjU();
                            Modifier modifier = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1694155942, str);
                            boolean invalid$iv4 = $composer4.changedInstance($focusManager);
                            Object it$iv3 = $composer4.rememberedValue();
                            if (invalid$iv4) {
                            }
                            Object value$iv4 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda9
                                public final Object invoke() {
                                    Unit OfflineSearchPage$lambda$14$0$0$0$0$3$0;
                                    OfflineSearchPage$lambda$14$0$0$0$0$3$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$0$3$0($focusManager, $searchKeyword$delegate);
                                    return OfflineSearchPage$lambda$14$0$0$0$0$3$0;
                                }
                            };
                            $composer4.updateRememberedValue(value$iv4);
                            it$iv3 = value$iv4;
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            IconKt.Icon-ww6aTOc(xmark_close_circle_fill_500, (String) null, SizeKt.size-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), Dp.constructor-impl(16)), j, $composer4, Painter.$stable | 48, 0);
                        } else {
                            $composer4.startReplaceGroup(969738296);
                        }
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer, 0);
                        long headerTintTextColor = ColorUtilsKt.getHeaderTintTextColor($composer, 0);
                        TextStyle t142 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
                        Modifier modifier2 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer, -541720056, str);
                        invalid$iv2 = $composer.changedInstance($backHandle);
                        it$iv2 = $composer.rememberedValue();
                        if (!invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv5 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda10
                                public final Object invoke() {
                                    Unit OfflineSearchPage$lambda$14$0$0$0$1$0;
                                    OfflineSearchPage$lambda$14$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$1$0($backHandle);
                                    return OfflineSearchPage$lambda$14$0$0$0$1$0;
                                }
                            };
                            $composer.updateRememberedValue(value$iv5);
                            it$iv2 = value$iv5;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TextKt.Text-Nvy7gAk(stringResource, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), headerTintTextColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t142, $composer, 0, 0, 131064);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                        $composer$iv$iv$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                    Object obj = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda7
                        public final Object invoke(Object obj2) {
                            Unit OfflineSearchPage$lambda$14$0$0$0$0$1$0;
                            OfflineSearchPage$lambda$14$0$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$0$1$0($scope, $firstRender$delegate, $focus, (LayoutCoordinates) obj2);
                            return OfflineSearchPage$lambda$14$0$0$0$0$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(obj);
                    value$iv = obj;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester, (Function1) value$iv);
                    TextStyle t143 = BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14();
                    ComposerKt.sourceInformationMarkerStart($composer4, 1694111364, str);
                    value$iv2 = $composer4.rememberedValue();
                    if (value$iv2 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    SimpleTextFieldKt.SimpleTextField(OfflineSearchPage$lambda$4, string, (Function1) value$iv2, onGloballyPositioned2, t143, (TextStyle) null, false, true, 0, keyboardOptions, keyboardActions, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer4, 817889664, 0, 14688);
                    if (StringsKt.isBlank(OfflineSearchPage$lambda$4($searchKeyword$delegate))) {
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    String stringResource2 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer, 0);
                    long headerTintTextColor2 = ColorUtilsKt.getHeaderTintTextColor($composer, 0);
                    TextStyle t1422 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
                    Modifier modifier22 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer, -541720056, str);
                    invalid$iv2 = $composer.changedInstance($backHandle);
                    it$iv2 = $composer.rememberedValue();
                    if (!invalid$iv2) {
                    }
                    Object value$iv52 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit OfflineSearchPage$lambda$14$0$0$0$1$0;
                            OfflineSearchPage$lambda$14$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$1$0($backHandle);
                            return OfflineSearchPage$lambda$14$0$0$0$1$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv52);
                    it$iv2 = value$iv52;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TextKt.Text-Nvy7gAk(stringResource2, ClickableKt.clickable-oSLSa3U$default(modifier22, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), headerTintTextColor2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t1422, $composer, 0, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
            } else {
                $composer2 = $composer;
            }
            $composer3 = $composer2;
            $composer$iv$iv = $composer;
            $composer$iv$iv2 = $composer;
            str = "CC(remember):OfflineSearchPage.kt#9igjgp";
            $composer$iv2 = $composer;
            $composer$iv$iv$iv = $composer;
            $composer$iv3 = $composer;
            value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2) {
                    Unit OfflineSearchPage$lambda$14$0$0$0$0$0$0;
                    OfflineSearchPage$lambda$14$0$0$0$0$0$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$0$0$0($scope, $focusManager, $searchKeyword$delegate, $displayKeyword$delegate, $machine, (KeyboardActionScope) obj2);
                    return OfflineSearchPage$lambda$14$0$0$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            KeyboardActions keyboardActions2 = new KeyboardActions((Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) value$iv3, (Function1) null, 47, (DefaultConstructorMarker) null);
            Modifier focusRequester2 = FocusRequesterModifierKt.focusRequester(RowScope.-CC.weight$default($this$OfflineSearchPage_u24lambda_u2414_u240_u240_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $focus);
            Composer $composer42 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer42, 1694123167, str);
            invalid$iv = $composer42.changedInstance($scope);
            it$iv = $composer42.rememberedValue();
            if (!invalid$iv) {
                value$iv = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer42);
                Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester2, (Function1) value$iv);
                TextStyle t1432 = BiliTheme.INSTANCE.getTextStyle($composer42, BiliTheme.$stable).getT14();
                ComposerKt.sourceInformationMarkerStart($composer42, 1694111364, str);
                value$iv2 = $composer42.rememberedValue();
                if (value$iv2 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer42);
                SimpleTextFieldKt.SimpleTextField(OfflineSearchPage$lambda$4, string, (Function1) value$iv2, onGloballyPositioned22, t1432, (TextStyle) null, false, true, 0, keyboardOptions, keyboardActions2, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer42, 817889664, 0, 14688);
                if (StringsKt.isBlank(OfflineSearchPage$lambda$4($searchKeyword$delegate))) {
                }
                $composer42.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer42);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                String stringResource22 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer, 0);
                long headerTintTextColor22 = ColorUtilsKt.getHeaderTintTextColor($composer, 0);
                TextStyle t14222 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
                Modifier modifier222 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer, -541720056, str);
                invalid$iv2 = $composer.changedInstance($backHandle);
                it$iv2 = $composer.rememberedValue();
                if (!invalid$iv2) {
                }
                Object value$iv522 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit OfflineSearchPage$lambda$14$0$0$0$1$0;
                        OfflineSearchPage$lambda$14$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$1$0($backHandle);
                        return OfflineSearchPage$lambda$14$0$0$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv522);
                it$iv2 = value$iv522;
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.Text-Nvy7gAk(stringResource22, ClickableKt.clickable-oSLSa3U$default(modifier222, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), headerTintTextColor22, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t14222, $composer, 0, 0, 131064);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            Object obj2 = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj22) {
                    Unit OfflineSearchPage$lambda$14$0$0$0$0$1$0;
                    OfflineSearchPage$lambda$14$0$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$0$1$0($scope, $firstRender$delegate, $focus, (LayoutCoordinates) obj22);
                    return OfflineSearchPage$lambda$14$0$0$0$0$1$0;
                }
            };
            $composer42.updateRememberedValue(obj2);
            value$iv = obj2;
            ComposerKt.sourceInformationMarkerEnd($composer42);
            Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(focusRequester2, (Function1) value$iv);
            TextStyle t14322 = BiliTheme.INSTANCE.getTextStyle($composer42, BiliTheme.$stable).getT14();
            ComposerKt.sourceInformationMarkerStart($composer42, 1694111364, str);
            value$iv2 = $composer42.rememberedValue();
            if (value$iv2 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer42);
            SimpleTextFieldKt.SimpleTextField(OfflineSearchPage$lambda$4, string, (Function1) value$iv2, onGloballyPositioned222, t14322, (TextStyle) null, false, true, 0, keyboardOptions, keyboardActions2, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer42, 817889664, 0, 14688);
            if (StringsKt.isBlank(OfflineSearchPage$lambda$4($searchKeyword$delegate))) {
            }
            $composer42.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer42);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            String stringResource222 = StringResourcesKt.stringResource(String0_commonMainKt.getCancel(CommonRes.INSTANCE.getString()), $composer, 0);
            long headerTintTextColor222 = ColorUtilsKt.getHeaderTintTextColor($composer, 0);
            TextStyle t142222 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14();
            Modifier modifier2222 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -541720056, str);
            invalid$iv2 = $composer.changedInstance($backHandle);
            it$iv2 = $composer.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv5222 = new Function0() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit OfflineSearchPage$lambda$14$0$0$0$1$0;
                    OfflineSearchPage$lambda$14$0$0$0$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$0$0$0$1$0($backHandle);
                    return OfflineSearchPage$lambda$14$0$0$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv5222);
            it$iv2 = value$iv5222;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(stringResource222, ClickableKt.clickable-oSLSa3U$default(modifier2222, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), headerTintTextColor222, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t142222, $composer, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$0$0$0$0$0$0(CoroutineScope $scope, FocusManager $focusManager, MutableState $searchKeyword$delegate, MutableState $displayKeyword$delegate, OfflineSearchPageStateMachine $machine, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        $displayKeyword$delegate.setValue(OfflineSearchPage$lambda$4($searchKeyword$delegate));
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSearchPageKt$OfflineSearchPage$3$1$1$1$1$1$1$1($machine, $searchKeyword$delegate, null), 3, (Object) null);
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$0$0$0$0$2$0(MutableState $searchKeyword$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $searchKeyword$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$0$0$0$0$1$0(CoroutineScope $scope, MutableState $firstRender$delegate, FocusRequester $focus, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (OfflineSearchPage$lambda$1($firstRender$delegate)) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSearchPageKt$OfflineSearchPage$3$1$1$1$1$2$1$1($focus, null), 3, (Object) null);
            OfflineSearchPage$lambda$2($firstRender$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$0$0$0$0$3$0(FocusManager $focusManager, MutableState $searchKeyword$delegate) {
        $searchKeyword$delegate.setValue("");
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$0$0$0$1$0(OnBackPressedDispatcher $backHandle) {
        $backHandle.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineSearchPage$lambda$14$1(final State $state$delegate, final LazyListState $lazyListState, final CoroutineScope $scope, final OfflineSearchPageStateMachine $machine, final MutableState $displayKeyword$delegate, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "CN(innerPadding)230@10707L6,232@10787L1530,224@10448L1869:OfflineSearchPage.kt#rawcr6");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1779232327, $dirty2, -1, "video.biz.offline.list.ui.page.OfflineSearchPage.<anonymous>.<anonymous> (OfflineSearchPage.kt:224)");
            }
            ContentWithStateKt.ContentWithState(OfflineSearchPage$lambda$11($state$delegate).getDataState(), PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.Companion, innerPadding), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(10), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(-892123994, true, new Function2() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineSearchPage$lambda$14$1$0;
                    OfflineSearchPage$lambda$14$1$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$1$0($lazyListState, $scope, $machine, $state$delegate, $displayKeyword$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineSearchPage$lambda$14$1$0;
                }
            }, $composer, 54), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0234, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit OfflineSearchPage$lambda$14$1$0(LazyListState $lazyListState, final CoroutineScope $scope, final OfflineSearchPageStateMachine $machine, State $state$delegate, MutableState $displayKeyword$delegate, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C233@10805L1498:OfflineSearchPage.kt#rawcr6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-892123994, $changed, -1, "video.biz.offline.list.ui.page.OfflineSearchPage.<anonymous>.<anonymous>.<anonymous> (OfflineSearchPage.kt:233)");
            }
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
            ComposerKt.sourceInformationMarkerStart($composer, -78986360, "C258@12080L182,247@11464L821:OfflineSearchPage.kt#rawcr6");
            if (OfflineSearchPage$lambda$11($state$delegate).getCompleted().isEmpty()) {
                $composer.startReplaceGroup(-89779662);
            } else {
                $composer.startReplaceGroup(-78955485);
                ComposerKt.sourceInformation($composer, "237@10992L6,239@11071L323,235@10894L527");
                TextKt.Text-Nvy7gAk(PluralStringResourcesKt.pluralStringResource(Plurals0_commonMainKt.getPlayerbaseres_global_string_2392(PlayerbaseresRes.INSTANCE.getPlurals()), OfflineSearchPage$lambda$11($state$delegate).getCompleted().size(), new Object[]{OfflineSearchPage$lambda$7($displayKeyword$delegate), String.valueOf(OfflineSearchPage$lambda$11($state$delegate).getCompleted().size())}, $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262122);
            }
            $composer.endReplaceGroup();
            List emptyList = CollectionsKt.emptyList();
            List<OfflineCachedCardModel> completed = OfflineSearchPage$lambda$11($state$delegate).getCompleted();
            List emptyList2 = CollectionsKt.emptyList();
            Set<String> selected = OfflineSearchPage$lambda$11($state$delegate).selected();
            String string = PlayerbaseresRes.INSTANCE.getString(bili.resource.playerbaseres.String0_commonMainKt.getPlayerbaseres_global_string_1391(PlayerbaseresRes.INSTANCE.getString()));
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -1942171994, "CC(remember):OfflineSearchPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($machine);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.page.OfflineSearchPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit OfflineSearchPage$lambda$14$1$0$0$0$0;
                    OfflineSearchPage$lambda$14$1$0$0$0$0 = OfflineSearchPageKt.OfflineSearchPage$lambda$14$1$0$0$0$0($scope, $machine, (String) obj);
                    return OfflineSearchPage$lambda$14$1$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            OfflineHomePageKt.OfflineCacheHomeList(false, false, emptyList, completed, emptyList2, $lazyListState, fillMaxSize$default, selected, string, null, (Function1) it$iv, null, null, $composer, 1597878, 0, 6656);
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
    public static final Unit OfflineSearchPage$lambda$14$1$0$0$0$0(CoroutineScope $scope, OfflineSearchPageStateMachine $machine, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSearchPageKt$OfflineSearchPage$3$2$1$1$1$1$1($machine, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}