package kntr.app.game.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.bean.KBiligameTag;
import com.bilibili.biligame.kntr.common.util.KBiligameExtKt;
import com.bilibili.biligame.kntr.common.util.StringExtKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import java.util.concurrent.CancellationException;
import kntr.app.game.base.event.KntrGameStatusEvent;
import kntr.app.game.base.event.KntrGameStatusEventKt;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.page.ListComposableKt;
import kntr.app.game.base.ui.widget.BiligameImageKt;
import kntr.app.game.base.ui.widget.gameaction.GameActionButtonKt;
import kntr.app.game.base.ui.widget.gameaction.GameActionButtonStyle;
import kntr.app.game.base.ui.widget.gameaction.OnActionListener;
import kntr.app.game.base.ui.widget.gameaction.provider.GameActionStateProvider;
import kntr.app.game.base.viewmodel.BaseListViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: DownloaderTest.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a3\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0003¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"DownloaderTestComposable", RoomRecommendViewModel.EMPTY_CURSOR, "type", RoomRecommendViewModel.EMPTY_CURSOR, RouterHelperKt.PARAM_SOURCE_FROM, "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "handleGameStatusEvent", "data", RoomRecommendViewModel.EMPTY_CURSOR, "Lcom/bilibili/biligame/kntr/common/bean/KBiligame;", "event", "Lkntr/app/game/base/event/KntrGameStatusEvent;", "GameItem", "game", "onButtonActionListener", "Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;", "buttonStyle", "Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;", "onCardClick", "Lkotlin/Function0;", "(Lcom/bilibili/biligame/kntr/common/bean/KBiligame;Lkntr/app/game/base/ui/widget/gameaction/OnActionListener;Lkntr/app/game/base/ui/widget/gameaction/GameActionButtonStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "gamebiz_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DownloaderTestKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderTestComposable$lambda$3(String str, String str2, int i, int i2, Composer composer, int i3) {
        DownloaderTestComposable(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameItem$lambda$1(KBiligame kBiligame, OnActionListener onActionListener, GameActionButtonStyle gameActionButtonStyle, Function0 function0, int i, Composer composer, int i2) {
        GameItem(kBiligame, onActionListener, gameActionButtonStyle, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DownloaderTestComposable(final String type, String sourceFrom, Composer $composer, final int $changed, final int i) {
        final String sourceFrom2;
        Composer $composer2;
        String sourceFrom3;
        CreationExtras creationExtras;
        Composer $composer3 = $composer.startRestartGroup(1435054534);
        ComposerKt.sourceInformation($composer3, "C(DownloaderTestComposable)N(type,sourceFrom)59@2413L376,71@2840L27,71@2830L37,74@2958L70,70@2794L840:DownloaderTest.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(type) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            sourceFrom2 = sourceFrom;
        } else if (($changed & 48) == 0) {
            sourceFrom2 = sourceFrom;
            $dirty |= $composer3.changed(sourceFrom2) ? 32 : 16;
        } else {
            sourceFrom2 = sourceFrom;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                sourceFrom3 = null;
            } else {
                sourceFrom3 = sourceFrom2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1435054534, $dirty, -1, "kntr.app.game.biz.DownloaderTestComposable (DownloaderTest.kt:56)");
            }
            final Ref.ObjectRef eventCollectJob = new Ref.ObjectRef();
            ComposerKt.sourceInformationMarkerStart($composer3, 402910462, "CC(remember):DownloaderTest.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function2() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit DownloaderTestComposable$lambda$0$0;
                        DownloaderTestComposable$lambda$0$0 = DownloaderTestKt.DownloaderTestComposable$lambda$0$0(eventCollectJob, (CoroutineScope) obj, (List) obj2);
                        return DownloaderTestComposable$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function2 onDataChanged = (Function2) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 402923777, "CC(remember):DownloaderTest.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        GameListViewModel DownloaderTestComposable$lambda$1$0;
                        DownloaderTestComposable$lambda$1$0 = DownloaderTestKt.DownloaderTestComposable$lambda$1$0(type, (CreationExtras) obj);
                        return DownloaderTestComposable$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            Function1 initializer$iv = (Function1) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer3, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer3, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GameListViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(GameListViewModel.class), initializer$iv);
            ViewModelProvider.Factory build = $this$viewModel_u24lambda_u243$iv.build();
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = current.getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, build, creationExtras, $composer3, ((0 << 3) & 112) | ((0 << 3) & 896), 0);
            $composer3.endReplaceableGroup();
            BaseListViewModel baseListViewModel = (BaseListViewModel) viewModel;
            ComposerKt.sourceInformationMarkerStart($composer3, 402927596, "CC(remember):DownloaderTest.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function2() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2) {
                        Object DownloaderTestComposable$lambda$2$0;
                        DownloaderTestComposable$lambda$2$0 = DownloaderTestKt.DownloaderTestComposable$lambda$2$0(((Integer) obj).intValue(), (KBiligame) obj2);
                        return DownloaderTestComposable$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            ListComposableKt.ListComposable(baseListViewModel, sourceFrom3, null, true, false, null, null, false, null, null, null, false, null, (Function2) it$iv3, onDataChanged, ComposableSingletons$DownloaderTestKt.INSTANCE.getLambda$265797693$gamebiz_debug(), $composer2, BaseListViewModel.$stable | 3072 | ($dirty & 112), 224256, 8180);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            sourceFrom2 = sourceFrom3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit DownloaderTestComposable$lambda$3;
                    DownloaderTestComposable$lambda$3 = DownloaderTestKt.DownloaderTestComposable$lambda$3(type, sourceFrom2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DownloaderTestComposable$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DownloaderTestComposable$lambda$0$0(Ref.ObjectRef $eventCollectJob, CoroutineScope scope, List data) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(data, "data");
        Job job = (Job) $eventCollectJob.element;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        $eventCollectJob.element = BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new DownloaderTestKt$DownloaderTestComposable$onDataChanged$1$1$1(data, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameListViewModel DownloaderTestComposable$lambda$1$0(String $type, CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new GameListViewModel($type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object DownloaderTestComposable$lambda$2$0(int i, KBiligame kBiligame) {
        Intrinsics.checkNotNullParameter(kBiligame, "<unused var>");
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleGameStatusEvent(List<? extends KBiligame> list, KntrGameStatusEvent event) {
        KLog_androidKt.getKLog().d("DownloaderTestComposable", "handleGameStatusEvent");
        List<? extends KBiligame> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            KBiligame game = (KBiligame) element$iv;
            if (game.getGameBaseId() == event.getGameBaseId()) {
                KntrGameStatusEventKt.updateGameStatus(game, event);
                GameActionStateProvider.Companion.updateGameActionState(game);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GameItem(final KBiligame game, final OnActionListener onButtonActionListener, final GameActionButtonStyle buttonStyle, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(1104838240);
        ComposerKt.sourceInformation($composer2, "C(GameItem)N(game,onButtonActionListener,buttonStyle,onCardClick)150@5490L6,146@5365L1364:DownloaderTest.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(game) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(onButtonActionListener) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(buttonStyle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1104838240, $dirty, -1, "kntr.app.game.biz.GameItem (DownloaderTest.kt:145)");
            }
            String str = null;
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(1), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10), Dp.constructor-impl(12), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((384 >> 6) & 112) | 6;
            RowScope $this$GameItem_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -969668598, "C155@5678L50,156@5737L846,180@6592L131:DownloaderTest.kt#351edr");
            BiligameImageKt.m1121BiligameImageo3XDK20(StringExtKt.handleUrl(game.getIcon()), Dp.constructor-impl(60), Dp.constructor-impl(10), null, null, $composer2, 432, 24);
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$GameItem_u24lambda_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, Dp.constructor-impl(10), 0.0f, 10, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -159880465, "C164@5993L6,165@6040L9,162@5907L161,169@6211L6,170@6257L9,167@6081L261,175@6442L6,176@6488L9,173@6355L218:DownloaderTest.kt#351edr");
            TextKt.Text-Nvy7gAk(KBiligameExtKt.formatGameName(game), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT15(), $composer2, 0, 0, 131066);
            List tagList = game.getTagList();
            if (tagList == null) {
                $composer2.startReplaceGroup(-159684578);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1667719101);
                ComposerKt.sourceInformation($composer2, "168@6144L21");
                List list = tagList;
                ComposerKt.sourceInformationMarkerStart($composer2, -1667718481, "CC(remember):DownloaderTest.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            CharSequence GameItem$lambda$0$0$0$0;
                            GameItem$lambda$0$0$0$0 = DownloaderTestKt.GameItem$lambda$0$0$0$0((KBiligameTag) obj);
                            return GameItem$lambda$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                String joinToString$default = CollectionsKt.joinToString$default(list, r53, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) it$iv, 30, (Object) null);
                $composer2.endReplaceGroup();
                str = joinToString$default;
            }
            TextKt.Text-Nvy7gAk(str == null ? RoomRecommendViewModel.EMPTY_CURSOR : str, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 0, 131064);
            String summary = game.getSummary();
            TextKt.Text-Nvy7gAk(summary == null ? RoomRecommendViewModel.EMPTY_CURSOR : summary, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            GameActionButtonKt.GameActionButton(game, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(56), Dp.constructor-impl(30)), null, onButtonActionListener, buttonStyle, $composer2, ($dirty & 14) | 48 | (($dirty << 6) & 7168) | (($dirty << 6) & 57344), 4);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.DownloaderTestKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameItem$lambda$1;
                    GameItem$lambda$1 = DownloaderTestKt.GameItem$lambda$1(game, onButtonActionListener, buttonStyle, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return GameItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence GameItem$lambda$0$0$0$0(KBiligameTag it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String name = it.getName();
        if (name == null) {
            name = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return name;
    }
}