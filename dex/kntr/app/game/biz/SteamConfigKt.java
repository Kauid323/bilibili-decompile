package kntr.app.game.biz;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
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
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.biligame.kntr.common.util.UtilsKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.game.base.bridge.KntrGameReportService;
import kntr.app.game.base.router.RouterHelperKt;
import kntr.app.game.base.ui.page.LoadComposableKt;
import kntr.app.game.base.viewmodel.PageLoadMoreState;
import kntr.app.game.report.ReportKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.router.GlobalRouterKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SteamConfig.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a)\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\t\u001a}\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072&\b\u0002\u0010\u0012\u001a \b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0017\u001a3\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u00020\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001d\u001a9\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00142\"\u0010 \u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013H\u0003¢\u0006\u0002\u0010!¨\u0006\"²\u0006\n\u0010#\u001a\u00020$X\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020\u0014X\u008a\u008e\u0002"}, d2 = {"SteamConfigPage", RoomRecommendViewModel.EMPTY_CURSOR, RouterHelperKt.PARAM_SOURCE_FROM, RoomRecommendViewModel.EMPTY_CURSOR, "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "UnbindConfirmDialog", "onConfirm", "Lkotlin/Function0;", "onCancel", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SteamConfigContent", "steamData", "Lkntr/app/game/biz/SteamPrivacyResponse;", "modifier", "Landroidx/compose/ui/Modifier;", "onBindClick", "onUnbindClick", "onPrivacySettingsClick", "onShowFriendCodeChange", "Lkotlin/Function2;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/game/biz/SteamPrivacyResponse;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "SteamAccountSection", "steamAccountNumber", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SteamPrivacySettingsRow", "onClick", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SteamFriendCodeToggle", "showFriendCode", "onToggleChange", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "gamebiz_debug", "refreshTrigger", RoomRecommendViewModel.EMPTY_CURSOR, "showUnbindDialog", "localToggleState"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SteamConfigKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAccountSection$lambda$2(String str, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        SteamAccountSection(str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigContent$lambda$1(SteamPrivacyResponse steamPrivacyResponse, Modifier modifier, Function0 function0, Function0 function02, Function0 function03, Function2 function2, int i, int i2, Composer composer, int i3) {
        SteamConfigContent(steamPrivacyResponse, modifier, function0, function02, function03, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$8(String str, int i, Composer composer, int i2) {
        SteamConfigPage(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamFriendCodeToggle$lambda$4(boolean z, Function2 function2, int i, Composer composer, int i2) {
        SteamFriendCodeToggle(z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamPrivacySettingsRow$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        SteamPrivacySettingsRow(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnbindConfirmDialog$lambda$3(Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        UnbindConfirmDialog(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SteamConfigPage(final String sourceFrom, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-685406641);
        ComposerKt.sourceInformation($composer2, "C(SteamConfigPage)N(sourceFrom)178@7208L26,178@7198L36,179@7266L7,180@7319L7,181@7352L24,183@7403L210,183@7382L231,194@7664L33,197@7765L456,197@7732L489,214@8283L371,214@8252L402,231@8781L2064,227@8660L2185:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sourceFrom) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-685406641, $dirty2, -1, "kntr.app.game.biz.SteamConfigPage (SteamConfig.kt:177)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1545783191, "CC(remember):SteamConfig.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda26
                    public final Object invoke(Object obj) {
                        SteamConfigViewModel SteamConfigPage$lambda$0$0;
                        SteamConfigPage$lambda$0$0 = SteamConfigKt.SteamConfigPage$lambda$0$0((CreationExtras) obj);
                        return SteamConfigPage$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Function1 initializer$iv = (Function1) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceableGroup(419377738);
            ComposerKt.sourceInformation($composer2, "CC(viewModel)P(2,1)*124@5789L7,129@5965L288:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer2, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SteamConfigViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(SteamConfigViewModel.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((384 << 3) & 112) | ((384 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            final SteamConfigViewModel steamViewModel = (SteamConfigViewModel) viewModel;
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Toaster toaster = (Toaster) consume;
            CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final LifecycleOwner lifecycleOwner = (LifecycleOwner) consume2;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1545776767, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(steamViewModel) | $composer2.changedInstance(toaster);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new SteamConfigKt$SteamConfigPage$1$1(steamViewModel, toaster, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, -1545768592, "CC(remember):SteamConfig.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableIntState refreshTrigger$delegate = (MutableIntState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1545764937, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(lifecycleOwner);
            Object it$iv4 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function1() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult SteamConfigPage$lambda$5$0;
                        SteamConfigPage$lambda$5$0 = SteamConfigKt.SteamConfigPage$lambda$5$0(lifecycleOwner, refreshTrigger$delegate, (DisposableEffectScope) obj);
                        return SteamConfigPage$lambda$5$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(lifecycleOwner, (Function1) it$iv4, $composer2, 0);
            Integer valueOf = Integer.valueOf(SteamConfigPage$lambda$3(refreshTrigger$delegate));
            ComposerKt.sourceInformationMarkerStart($composer2, -1545748446, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(coroutineScope) | $composer2.changedInstance(steamViewModel);
            Object it$iv5 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = (Function2) new SteamConfigKt$SteamConfigPage$3$1(coroutineScope, refreshTrigger$delegate, steamViewModel, null);
                $composer2.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv5, $composer2, 0);
            LoadComposableKt.LoadComposable(steamViewModel, sourceFrom, null, true, false, ComposableLambdaKt.rememberComposableLambda(-2113569750, true, new Function5() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                    Unit SteamConfigPage$lambda$7;
                    SteamConfigPage$lambda$7 = SteamConfigKt.SteamConfigPage$lambda$7(SteamConfigViewModel.this, sourceFrom, (SteamPrivacyResponse) obj, (SteamConfigViewModel) obj2, (PageLoadMoreState) obj3, (Composer) obj4, ((Integer) obj5).intValue());
                    return SteamConfigPage$lambda$7;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 112) | 199680, 20);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamConfigPage$lambda$8;
                    SteamConfigPage$lambda$8 = SteamConfigKt.SteamConfigPage$lambda$8(sourceFrom, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamConfigPage$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SteamConfigViewModel SteamConfigPage$lambda$0$0(CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new SteamConfigViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int SteamConfigPage$lambda$3(MutableIntState $refreshTrigger$delegate) {
        IntState $this$getValue$iv = (IntState) $refreshTrigger$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult SteamConfigPage$lambda$5$0(final LifecycleOwner $lifecycleOwner, final MutableIntState $refreshTrigger$delegate, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        final LifecycleObserver lifecycleObserver = new LifecycleEventObserver() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda23
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                SteamConfigKt.SteamConfigPage$lambda$5$0$0($refreshTrigger$delegate, lifecycleOwner, event);
            }
        };
        $lifecycleOwner.getLifecycle().addObserver(lifecycleObserver);
        return new DisposableEffectResult() { // from class: kntr.app.game.biz.SteamConfigKt$SteamConfigPage$lambda$5$0$$inlined$onDispose$1
            public void dispose() {
                $lifecycleOwner.getLifecycle().removeObserver(lifecycleObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SteamConfigPage$lambda$5$0$0(MutableIntState $refreshTrigger$delegate, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            System.out.println((Object) "SteamConfig: 页面恢复，触发刷新");
            $refreshTrigger$delegate.setIntValue(SteamConfigPage$lambda$3($refreshTrigger$delegate) + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x01ee, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0273, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x02aa, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit SteamConfigPage$lambda$7(final SteamConfigViewModel $steamViewModel, final String $sourceFrom, final SteamPrivacyResponse data, SteamConfigViewModel steamConfigViewModel, PageLoadMoreState pageLoadMoreState, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(steamConfigViewModel, "$unused$var$");
        Intrinsics.checkNotNullParameter(pageLoadMoreState, "$unused$var$");
        ComposerKt.sourceInformation($composer, "CN(data)233@8891L34,234@8953L24,240@9117L6,236@8987L1440:SteamConfig.kt#351edr");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2113569750, $changed, -1, "kntr.app.game.biz.SteamConfigPage.<anonymous> (SteamConfig.kt:232)");
        }
        System.out.println((Object) ("SteamConfig: LoadComposable回调被调用，数据: " + data));
        ComposerKt.sourceInformationMarkerStart($composer, 379004812, "CC(remember):SteamConfig.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState showUnbindDialog$delegate = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        final CoroutineScope contentScope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa1-0d7_KjU(), (Shape) null, 2, (Object) null);
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
        ComposerKt.sourceInformationMarkerStart($composer, -449828528, "C244@9238L453,254@9725L63,257@9831L437,267@10311L91,242@9154L1263:SteamConfig.kt#351edr");
        ComposerKt.sourceInformationMarkerStart($composer, 816775273, "CC(remember):SteamConfig.kt#9igjgp");
        boolean invalid$iv = $composer.changed($sourceFrom);
        Object it$iv2 = $composer.rememberedValue();
        if (invalid$iv) {
        }
        Object value$iv2 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit SteamConfigPage$lambda$7$3$0$0;
                SteamConfigPage$lambda$7$3$0$0 = SteamConfigKt.SteamConfigPage$lambda$7$3$0$0($sourceFrom);
                return SteamConfigPage$lambda$7$3$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv2);
        it$iv2 = value$iv2;
        Function0 function0 = (Function0) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 816790467, "CC(remember):SteamConfig.kt#9igjgp");
        Object value$iv3 = $composer.rememberedValue();
        if (value$iv3 == Composer.Companion.getEmpty()) {
            value$iv3 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit SteamConfigPage$lambda$7$3$1$0;
                    SteamConfigPage$lambda$7$3$1$0 = SteamConfigKt.SteamConfigPage$lambda$7$3$1$0(showUnbindDialog$delegate);
                    return SteamConfigPage$lambda$7$3$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv3);
        }
        Function0 function02 = (Function0) value$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 816794233, "CC(remember):SteamConfig.kt#9igjgp");
        boolean invalid$iv2 = $composer.changed($sourceFrom) | (((($changed & 14) ^ 6) > 4 && $composer.changed(data)) || ($changed & 6) == 4);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2) {
        }
        Object value$iv4 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit SteamConfigPage$lambda$7$3$2$0;
                SteamConfigPage$lambda$7$3$2$0 = SteamConfigKt.SteamConfigPage$lambda$7$3$2$0($sourceFrom, data);
                return SteamConfigPage$lambda$7$3$2$0;
            }
        };
        $composer.updateRememberedValue(value$iv4);
        it$iv3 = value$iv4;
        Function0 function03 = (Function0) it$iv3;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 816809247, "CC(remember):SteamConfig.kt#9igjgp");
        boolean invalid$iv3 = $composer.changedInstance($steamViewModel);
        SteamConfigKt$SteamConfigPage$4$1$4$1 value$iv5 = $composer.rememberedValue();
        if (invalid$iv3) {
        }
        value$iv5 = new SteamConfigKt$SteamConfigPage$4$1$4$1($steamViewModel, null);
        $composer.updateRememberedValue(value$iv5);
        ComposerKt.sourceInformationMarkerEnd($composer);
        SteamConfigContent(data, null, function0, function02, function03, value$iv5, $composer, ($changed & 14) | 3072, 2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (SteamConfigPage$lambda$7$1(showUnbindDialog$delegate)) {
            $composer.startReplaceGroup(-1134169234);
            ComposerKt.sourceInformation($composer, "276@10540L181,282@10750L64,275@10491L338");
            ComposerKt.sourceInformationMarkerStart($composer, 379057727, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance(contentScope) | $composer.changedInstance($steamViewModel);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv6 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit SteamConfigPage$lambda$7$4$0;
                        SteamConfigPage$lambda$7$4$0 = SteamConfigKt.SteamConfigPage$lambda$7$4$0(contentScope, showUnbindDialog$delegate, $steamViewModel);
                        return SteamConfigPage$lambda$7$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv4 = value$iv6;
            }
            Function0 function04 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 379064330, "CC(remember):SteamConfig.kt#9igjgp");
            Object it$iv5 = $composer.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv7 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit SteamConfigPage$lambda$7$5$0;
                        SteamConfigPage$lambda$7$5$0 = SteamConfigKt.SteamConfigPage$lambda$7$5$0(showUnbindDialog$delegate);
                        return SteamConfigPage$lambda$7$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv7);
                it$iv5 = value$iv7;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            UnbindConfirmDialog(function04, (Function0) it$iv5, $composer, 48);
        } else {
            $composer.startReplaceGroup(-1144574632);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final boolean SteamConfigPage$lambda$7$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void SteamConfigPage$lambda$7$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$7$3$0$0(String $sourceFrom) {
        GlobalRouterKt.getGlobalRouter().launch(Uri.Companion.parse("https://gmds.biligame.com/?bound_source=2").buildUpon().appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom == null ? RoomRecommendViewModel.EMPTY_CURSOR : $sourceFrom).appendQueryParameter("spmid_from", KntrGameReportService.INSTANCE.getSpmidFrom()).build());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$7$3$1$0(MutableState $showUnbindDialog$delegate) {
        SteamConfigPage$lambda$7$2($showUnbindDialog$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$7$3$2$0(String $sourceFrom, SteamPrivacyResponse $data) {
        GlobalRouterKt.getGlobalRouter().launch(Uri.Companion.parse("bilibili://game_center/steam/privacy").buildUpon().appendQueryParameter(RouterHelperKt.PARAM_SOURCE_FROM, $sourceFrom == null ? RoomRecommendViewModel.EMPTY_CURSOR : $sourceFrom).appendQueryParameter("show_type", String.valueOf($data.getBindStatus())).build());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$7$4$0(CoroutineScope $contentScope, MutableState $showUnbindDialog$delegate, SteamConfigViewModel $steamViewModel) {
        SteamConfigPage$lambda$7$2($showUnbindDialog$delegate, false);
        BuildersKt.launch$default($contentScope, (CoroutineContext) null, (CoroutineStart) null, new SteamConfigKt$SteamConfigPage$4$2$1$1($steamViewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamConfigPage$lambda$7$5$0(MutableState $showUnbindDialog$delegate) {
        SteamConfigPage$lambda$7$2($showUnbindDialog$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x07e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void UnbindConfirmDialog(Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        final Function0<Unit> function03;
        Composer $composer2;
        final Function0<Unit> function04;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 value$iv;
        boolean invalid$iv;
        Composer $composer3 = $composer.startRestartGroup(1235011957);
        ComposerKt.sourceInformation($composer3, "C(UnbindConfirmDialog)N(onConfirm,onCancel)296@10995L90,296@10974L111,306@11273L14,301@11110L3522:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 32 : 16;
        }
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            function03 = function02;
            $composer2 = $composer3;
            function04 = function0;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1235011957, $dirty, -1, "kntr.app.game.biz.UnbindConfirmDialog (SteamConfig.kt:294)");
            }
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1435521103, "CC(remember):SteamConfig.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new SteamConfigKt$UnbindConfirmDialog$1$1(null);
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer3, 6);
            Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1435529923, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 112) == 32;
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit UnbindConfirmDialog$lambda$1$0;
                        UnbindConfirmDialog$lambda$1$0 = SteamConfigKt.UnbindConfirmDialog$lambda$1$0(function02);
                        return UnbindConfirmDialog$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1314504712, "C316@11568L6,318@11687L3,310@11366L3260:SteamConfig.kt#351edr");
            Modifier modifier2 = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(280)), Dp.constructor-impl(138)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 927434962, "CC(remember):SteamConfig.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit unit2;
                        unit2 = Unit.INSTANCE;
                        return unit2;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 14, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            ColumnScope $this$UnbindConfirmDialog_u24lambda_u242_u241 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1738595928, "C324@11869L9,325@11918L6,322@11798L253,331@12094L323,345@12539L6,343@12450L114,349@12597L2019:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk("解除绑定", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBa0_s-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 1572918, 0, 131000);
            Modifier modifier$iv3 = ColumnScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv7;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1559561061, "C337@12321L9,338@12374L6,335@12232L171:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk("确认解除绑定Steam账号？", (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa7-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), $composer3, 48, 1);
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(50));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceEvenly();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv4 = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv8;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i8 = ((438 >> 6) & 112) | 6;
            RowScope $this$UnbindConfirmDialog_u24lambda_u242_u241_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 2075540447, "C359@12965L331,358@12923L815,383@13822L332,382@13780L822:SteamConfig.kt#351edr");
            ComposerKt.sourceInformationMarkerStart($composer3, -1595615072, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv3 = ($dirty & 112) == 32;
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv3 && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                function03 = function02;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ButtonKt.TextButton(value$iv, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.getLambda$55220472$gamebiz_debug(), $composer3, 805306368, 508);
                ComposerKt.sourceInformationMarkerStart($composer3, -1595587647, "CC(remember):SteamConfig.kt#9igjgp");
                invalid$iv = ($dirty & 14) != 4;
                Object it$iv5 = $composer3.rememberedValue();
                if (!invalid$iv && it$iv5 != Composer.Companion.getEmpty()) {
                    function04 = function0;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ButtonKt.TextButton((Function0) it$iv5, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.m1180getLambda$598085535$gamebiz_debug(), $composer3, 805306368, 508);
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
                function04 = function0;
                Object value$iv5 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        Unit UnbindConfirmDialog$lambda$2$1$1$1$0;
                        UnbindConfirmDialog$lambda$2$1$1$1$0 = SteamConfigKt.UnbindConfirmDialog$lambda$2$1$1$1$0(function04);
                        return UnbindConfirmDialog$lambda$2$1$1$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ButtonKt.TextButton((Function0) it$iv5, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.m1180getLambda$598085535$gamebiz_debug(), $composer3, 805306368, 508);
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
                }
            }
            function03 = function02;
            value$iv = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda20
                public final Object invoke() {
                    Unit UnbindConfirmDialog$lambda$2$1$1$0$0;
                    UnbindConfirmDialog$lambda$2$1$1$0$0 = SteamConfigKt.UnbindConfirmDialog$lambda$2$1$1$0$0(function03);
                    return UnbindConfirmDialog$lambda$2$1$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ButtonKt.TextButton(value$iv, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.getLambda$55220472$gamebiz_debug(), $composer3, 805306368, 508);
            ComposerKt.sourceInformationMarkerStart($composer3, -1595587647, "CC(remember):SteamConfig.kt#9igjgp");
            invalid$iv = ($dirty & 14) != 4;
            Object it$iv52 = $composer3.rememberedValue();
            if (!invalid$iv) {
                function04 = function0;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ButtonKt.TextButton((Function0) it$iv52, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.m1180getLambda$598085535$gamebiz_debug(), $composer3, 805306368, 508);
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
                }
            }
            function04 = function0;
            Object value$iv52 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda21
                public final Object invoke() {
                    Unit UnbindConfirmDialog$lambda$2$1$1$1$0;
                    UnbindConfirmDialog$lambda$2$1$1$1$0 = SteamConfigKt.UnbindConfirmDialog$lambda$2$1$1$1$0(function04);
                    return UnbindConfirmDialog$lambda$2$1$1$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv52);
            it$iv52 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ButtonKt.TextButton((Function0) it$iv52, SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnbindConfirmDialog_u24lambda_u242_u241_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$SteamConfigKt.INSTANCE.m1180getLambda$598085535$gamebiz_debug(), $composer3, 805306368, 508);
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
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnbindConfirmDialog$lambda$3;
                    UnbindConfirmDialog$lambda$3 = SteamConfigKt.UnbindConfirmDialog$lambda$3(function04, function03, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UnbindConfirmDialog$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnbindConfirmDialog$lambda$1$0(Function0 $onCancel) {
        $onCancel.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnbindConfirmDialog$lambda$2$1$1$0$0(Function0 $onCancel) {
        ReportKt.reportClick("game-ball.steam-setting.steam-setting.unbind-pop-up.click", MapsKt.mapOf(TuplesKt.to("button_name", "取消")));
        $onCancel.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnbindConfirmDialog$lambda$2$1$1$1$0(Function0 $onConfirm) {
        ReportKt.reportClick("game-ball.steam-setting.steam-setting.unbind-pop-up.click", MapsKt.mapOf(TuplesKt.to("button_name", "解绑")));
        $onConfirm.invoke();
        return Unit.INSTANCE;
    }

    public static final void SteamConfigContent(final SteamPrivacyResponse steamData, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function2<? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> function2, Composer $composer, final int $changed, final int i) {
        Function0 function04;
        Function0 onUnbindClick;
        Function0 onPrivacySettingsClick;
        Function2 onShowFriendCodeChange;
        Composer $composer2;
        Modifier modifier2;
        Function0 onBindClick;
        Function0 onUnbindClick2;
        Modifier modifier3;
        Function0 onBindClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 onBindClick3;
        Function0 function05;
        Function0 function06;
        Function0 function07;
        Function0 function08;
        Function0 function09;
        Function2 function22;
        Object value$iv;
        Object it$iv;
        Intrinsics.checkNotNullParameter(steamData, "steamData");
        Composer $composer3 = $composer.startRestartGroup(766283751);
        ComposerKt.sourceInformation($composer3, "C(SteamConfigContent)N(steamData,modifier,onBindClick,onUnbindClick,onPrivacySettingsClick,onShowFriendCodeChange)427@15276L6,423@15158L1543:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(steamData) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function04 = function0;
        } else if (($changed & 384) == 0) {
            function04 = function0;
            $dirty |= $composer3.changedInstance(function04) ? 256 : 128;
        } else {
            function04 = function0;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onUnbindClick = function02;
        } else if (($changed & 3072) == 0) {
            onUnbindClick = function02;
            $dirty |= $composer3.changedInstance(onUnbindClick) ? 2048 : 1024;
        } else {
            onUnbindClick = function02;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            onPrivacySettingsClick = function03;
        } else if (($changed & 24576) == 0) {
            onPrivacySettingsClick = function03;
            $dirty |= $composer3.changedInstance(onPrivacySettingsClick) ? 16384 : 8192;
        } else {
            onPrivacySettingsClick = function03;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            onShowFriendCodeChange = function2;
        } else if ((196608 & $changed) == 0) {
            onShowFriendCodeChange = function2;
            $dirty |= $composer3.changedInstance(onShowFriendCodeChange) ? 131072 : 65536;
        } else {
            onShowFriendCodeChange = function2;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onBindClick = function04;
            onUnbindClick2 = onUnbindClick;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                onBindClick2 = function04;
            } else {
                onBindClick2 = null;
            }
            if (i4 != 0) {
                onUnbindClick = null;
            }
            if (i5 != 0) {
                onPrivacySettingsClick = null;
            }
            if (i6 != 0) {
                onShowFriendCodeChange = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(766283751, $dirty2, -1, "kntr.app.game.biz.SteamConfigContent (SteamConfig.kt:417)");
            }
            int bindStatus = steamData.getBindStatus();
            String steamAccountNumber = steamData.getSteamId();
            System.out.println((Object) ("SteamConfig: SteamConfigContent被调用 - bindStatus: " + bindStatus + ", steamAccountNumber: " + steamAccountNumber));
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            modifier2 = modifier3;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -423042646, "C434@15477L6,430@15343L1352:SteamConfig.kt#351edr");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            int $changed$iv = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, $changed$iv);
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
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1546084644, "C:SteamConfig.kt#351edr");
            if (bindStatus == 1) {
                $composer3.startReplaceGroup(1546096206);
                ComposerKt.sourceInformation($composer3, "439@15653L209,446@15912L102");
                if (onBindClick2 == null) {
                    $composer3.startReplaceGroup(1546271077);
                    ComposerKt.sourceInformation($composer3, "441@15784L2");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1019711037, "CC(remember):SteamConfig.kt#9igjgp");
                    Object it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv2 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        it$iv = value$iv2;
                    } else {
                        it$iv = it$iv2;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                    function07 = (Function0) it$iv;
                } else {
                    $composer3.startReplaceGroup(1019710572);
                    $composer3.endReplaceGroup();
                    function07 = onBindClick2;
                }
                if (onUnbindClick == null) {
                    $composer3.startReplaceGroup(1546327621);
                    ComposerKt.sourceInformation($composer3, "442@15841L2");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1019712861, "CC(remember):SteamConfig.kt#9igjgp");
                    Object it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        value$iv = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda14
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv3;
                    }
                    function08 = (Function0) value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1019712334);
                    $composer3.endReplaceGroup();
                    function08 = onUnbindClick;
                }
                SteamAccountSection(steamAccountNumber, function07, function08, $composer3, 0);
                if (onPrivacySettingsClick == null) {
                    $composer3.startReplaceGroup(1546478405);
                    ComposerKt.sourceInformation($composer3, "447@15993L2");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1019717725, "CC(remember):SteamConfig.kt#9igjgp");
                    Object it$iv4 = $composer3.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv4 = value$iv3;
                    }
                    function09 = (Function0) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1019716919);
                    $composer3.endReplaceGroup();
                    function09 = onPrivacySettingsClick;
                }
                SteamPrivacySettingsRow(function09, $composer3, 0);
                if (Intrinsics.areEqual(steamData.getFriendCodeMetaConfigEnabled(), true)) {
                    $composer3.startReplaceGroup(1546642581);
                    ComposerKt.sourceInformation($composer3, "452@16173L202");
                    Boolean showFriendCode = steamData.getShowFriendCode();
                    boolean booleanValue = showFriendCode != null ? showFriendCode.booleanValue() : false;
                    if (onShowFriendCodeChange == null) {
                        $composer3.startReplaceGroup(1546821978);
                        ComposerKt.sourceInformation($composer3, "454@16339L13");
                        ComposerKt.sourceInformationMarkerStart($composer3, 1019728808, "CC(remember):SteamConfig.kt#9igjgp");
                        Object it$iv5 = $composer3.rememberedValue();
                        if (it$iv5 == Composer.Companion.getEmpty()) {
                            Object value$iv4 = (Function2) new SteamConfigKt$SteamConfigContent$1$1$4$1(null);
                            $composer3.updateRememberedValue(value$iv4);
                            it$iv5 = value$iv4;
                        }
                        function22 = (Function2) it$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(1019728002);
                        $composer3.endReplaceGroup();
                        function22 = onShowFriendCodeChange;
                    }
                    SteamFriendCodeToggle(booleanValue, function22, $composer3, 0);
                } else {
                    $composer3.startReplaceGroup(1530612295);
                }
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                onBindClick3 = onBindClick2;
            } else {
                $composer3.startReplaceGroup(1546903415);
                ComposerKt.sourceInformation($composer3, "459@16463L208");
                if (onBindClick2 == null) {
                    $composer3.startReplaceGroup(1547073605);
                    ComposerKt.sourceInformation($composer3, "461@16593L2");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1019736925, "CC(remember):SteamConfig.kt#9igjgp");
                    Object it$iv6 = $composer3.rememberedValue();
                    onBindClick3 = onBindClick2;
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda16
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                    }
                    function05 = (Function0) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                } else {
                    onBindClick3 = onBindClick2;
                    $composer3.startReplaceGroup(1019736460);
                    $composer3.endReplaceGroup();
                    function05 = onBindClick3;
                }
                if (onUnbindClick == null) {
                    $composer3.startReplaceGroup(1547130149);
                    ComposerKt.sourceInformation($composer3, "462@16650L2");
                    ComposerKt.sourceInformationMarkerStart($composer3, 1019738749, "CC(remember):SteamConfig.kt#9igjgp");
                    Object it$iv7 = $composer3.rememberedValue();
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda17
                            public final Object invoke() {
                                Unit unit;
                                unit = Unit.INSTANCE;
                                return unit;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv7 = value$iv6;
                    }
                    function06 = (Function0) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(1019738222);
                    $composer3.endReplaceGroup();
                    function06 = onUnbindClick;
                }
                SteamAccountSection(null, function05, function06, $composer3, 6);
                $composer3.endReplaceGroup();
            }
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
            onBindClick = onBindClick3;
            onUnbindClick2 = onUnbindClick;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function0 function010 = onBindClick;
            final Function0 function011 = onUnbindClick2;
            final Function0 function012 = onPrivacySettingsClick;
            final Function2 function23 = onShowFriendCodeChange;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamConfigContent$lambda$1;
                    SteamConfigContent$lambda$1 = SteamConfigKt.SteamConfigContent$lambda$1(SteamPrivacyResponse.this, modifier4, function010, function011, function012, function23, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamConfigContent$lambda$1;
                }
            });
        }
    }

    private static final void SteamAccountSection(final String steamAccountNumber, Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        final Function0<Unit> function03;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(2123481470);
        ComposerKt.sourceInformation($composer3, "C(SteamAccountSection)N(steamAccountNumber,onBindClick,onUnbindClick)476@16908L265,476@16873L300,485@17178L3073:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(steamAccountNumber) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 256 : 128;
        }
        if (!$composer3.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            function03 = function0;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2123481470, $dirty, -1, "kntr.app.game.biz.SteamAccountSection (SteamConfig.kt:474)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 556233191, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new SteamConfigKt$SteamAccountSection$1$1(steamAccountNumber, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(steamAccountNumber, (Function2) it$iv, $composer3, $dirty & 14);
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(67));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
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
            int i2 = ((438 >> 6) & 112) | 6;
            RowScope $this$SteamAccountSection_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -692390488, "C493@17404L1361,540@19034L6,542@19144L792,534@18794L1451:SteamConfig.kt#351edr");
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$SteamAccountSection_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(20), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(67));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i4 = ((0 >> 6) & 112) | 6;
            BoxScope $this$SteamAccountSection_u24lambda_u241_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -738924655, "C502@17713L9,503@17762L6,500@17593L350:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk(steamAccountNumber != null ? "当前账户" : "绑定Steam账号", PaddingKt.padding-qDBjuR0$default($this$SteamAccountSection_u24lambda_u241_u240.align(Modifier.Companion, Alignment.Companion.getTopStart()), 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBa0_s-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT15(), $composer3, 0, 0, 131064);
            if (steamAccountNumber != null) {
                $composer3.startReplaceGroup(-738538923);
                ComposerKt.sourceInformation($composer3, "513@18106L9,514@18159L6,511@18007L357");
                TextKt.Text-Nvy7gAk("当前账号：" + steamAccountNumber, PaddingKt.padding-qDBjuR0$default($this$SteamAccountSection_u24lambda_u241_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(15), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 131064);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-738147641);
                ComposerKt.sourceInformation($composer3, "523@18483L9,524@18536L6,521@18402L339");
                TextKt.Text-Nvy7gAk("展示个人战绩", PaddingKt.padding-qDBjuR0$default($this$SteamAccountSection_u24lambda_u241_u240.align(Modifier.Companion, Alignment.Companion.getBottomStart()), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(15), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa5-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 6, 0, 131064);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(17), Dp.constructor-impl(20), 0.0f, 9, (Object) null), Dp.constructor-impl(76), Dp.constructor-impl(30)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer3, 116265786, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 896) == 256) | (($dirty & 14) == 4) | (($dirty & 112) == 32);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                function03 = function0;
                Object value$iv2 = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda24
                    public final Object invoke() {
                        Unit SteamAccountSection$lambda$1$1$0;
                        SteamAccountSection$lambda$1$1$0 = SteamConfigKt.SteamAccountSection$lambda$1$1$0(steamAccountNumber, function02, function03);
                        return SteamAccountSection$lambda$1$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                function03 = function0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (48 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -50796892, "C565@20122L9,563@20011L224:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk(steamAccountNumber != null ? "解绑" : "绑定", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 1573248, 0, 131002);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamAccountSection$lambda$2;
                    SteamAccountSection$lambda$2 = SteamConfigKt.SteamAccountSection$lambda$2(steamAccountNumber, function03, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamAccountSection$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamAccountSection$lambda$1$1$0(String $steamAccountNumber, Function0 $onUnbindClick, Function0 $onBindClick) {
        String buttonName = $steamAccountNumber != null ? "解绑" : "绑定";
        ReportKt.reportClick("game-ball.steam-setting.steam-setting.binding-button.click", MapsKt.mapOf(TuplesKt.to("button_name", buttonName)));
        if ($steamAccountNumber != null) {
            $onUnbindClick.invoke();
        } else if (!UtilsKt.isLogin()) {
            RouterHelperKt.login();
        } else {
            $onBindClick.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final void SteamPrivacySettingsRow(final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1833583084);
        ComposerKt.sourceInformation($composer3, "C(SteamPrivacySettingsRow)N(onClick)575@20330L1116:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (!$composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1833583084, $dirty, -1, "kntr.app.game.biz.SteamPrivacySettingsRow (SteamConfig.kt:574)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
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
            ComposerKt.sourceInformationMarkerStart($composer3, 2159441, "C580@20506L6,577@20364L163,587@20657L13,583@20537L903:SteamConfig.kt#351edr");
            DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, 2, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), $composer3, 54, 0);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, -1385395349, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit SteamPrivacySettingsRow$lambda$0$0$0;
                        SteamPrivacySettingsRow$lambda$0$0$0 = SteamConfigKt.SteamPrivacySettingsRow$lambda$0$0$0(function0);
                        return SteamPrivacySettingsRow$lambda$0$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(47)), Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
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
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -264231028, "C595@20965L9,596@21014L6,593@20889L209,601@21157L28,603@21263L6,600@21112L318:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk("Steam隐私设置", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 54, 0, 131064);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_800($composer3, 6), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(16), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamPrivacySettingsRow$lambda$1;
                    SteamPrivacySettingsRow$lambda$1 = SteamConfigKt.SteamPrivacySettingsRow$lambda$1(function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamPrivacySettingsRow$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamPrivacySettingsRow$lambda$0$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0296, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SteamFriendCodeToggle(final boolean showFriendCode, final Function2<? super Boolean, ? super Continuation<? super Boolean>, ? extends Object> function2, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(838649965);
        ComposerKt.sourceInformation($composer2, "C(SteamFriendCodeToggle)N(showFriendCode,onToggleChange)618@21608L59,619@21693L24,621@21723L1772:SteamConfig.kt#351edr");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(showFriendCode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(838649965, $dirty, -1, "kntr.app.game.biz.SteamFriendCodeToggle (SteamConfig.kt:617)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1511230808, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(showFriendCode), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState localToggleState$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope coroutineScope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(47)), Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getBottom();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -359255810, "C632@22066L9,633@22111L6,630@21997L193,639@22278L345,656@22939L6,658@23065L6,654@22828L650,637@22200L1289:SteamConfig.kt#351edr");
            TextKt.Text-Nvy7gAk("显示Steam好友码", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(17), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa10-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, 54, 0, 131064);
            boolean SteamFriendCodeToggle$lambda$1 = SteamFriendCodeToggle$lambda$1(localToggleState$delegate);
            ComposerKt.sourceInformationMarkerStart($composer2, -1951243702, "CC(remember):SteamConfig.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(localToggleState$delegate) | $composer2.changedInstance(coroutineScope) | $composer2.changedInstance(function2);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    Unit SteamFriendCodeToggle$lambda$3$0$0;
                    SteamFriendCodeToggle$lambda$3$0$0 = SteamConfigKt.SteamFriendCodeToggle$lambda$3$0$0(coroutineScope, localToggleState$delegate, function2, ((Boolean) obj).booleanValue());
                    return SteamFriendCodeToggle$lambda$3$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SwitchKt.Switch(SteamFriendCodeToggle$lambda$1, (Function1) it$iv2, SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), Dp.constructor-impl(48), Dp.constructor-impl(30)), (Function2) null, false, SwitchDefaults.INSTANCE.colors-V1nXRL4(Color.Companion.getWhite-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, Color.Companion.getWhite-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa4-0d7_KjU(), Color.Companion.getTransparent-0d7_KjU(), 0L, Color.Companion.getWhite-0d7_KjU(), 0L, Color.Companion.getTransparent-0d7_KjU(), 0L, Color.Companion.getWhite-0d7_KjU(), 0L, Color.Companion.getTransparent-0d7_KjU(), 0L, $composer2, 102261126, (SwitchDefaults.$stable << 18) | 24966, 43656), (MutableInteractionSource) null, $composer2, 384, 88);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.biz.SteamConfigKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit SteamFriendCodeToggle$lambda$4;
                    SteamFriendCodeToggle$lambda$4 = SteamConfigKt.SteamFriendCodeToggle$lambda$4(showFriendCode, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SteamFriendCodeToggle$lambda$4;
                }
            });
        }
    }

    private static final boolean SteamFriendCodeToggle$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SteamFriendCodeToggle$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SteamFriendCodeToggle$lambda$3$0$0(CoroutineScope $coroutineScope, MutableState $localToggleState$delegate, Function2 $onToggleChange, boolean newState) {
        SteamFriendCodeToggle$lambda$2($localToggleState$delegate, newState);
        BuildersKt.launch$default($coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SteamConfigKt$SteamFriendCodeToggle$1$1$1$1($onToggleChange, newState, $localToggleState$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}