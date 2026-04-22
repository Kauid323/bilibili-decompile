package kntr.app.game.base.ui.container;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.contextaware.ContextAware;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.AndroidUriKt;
import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.tribe.core.internal.Hooks;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.log.KLog_androidKt;
import kntr.base.router.Router;
import kntr.base.router.target.FunctionTarget;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetKt;
import kntr.common.compose.launcher.KomponentRouterKt;
import kntr.common.compose.launcher.LifecycleKt;
import kntr.common.compose.launcher.LocalContextKt;
import kntr.common.compose.launcher.LocalToasterKt;
import kntr.common.compose.launcher.OnBackPressedDispatcherKt;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.LocalOnFinishKt;
import kntr.common.komponent.Orientation;
import kntr.common.komponent.ProvideLocalsScope;
import kntr.common.komponent.UiComposableLike;
import kntr.common.router.GlobalRouterKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.toast.AndroidToaster;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;

/* compiled from: GameComposeContainer.android.kt */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u001c\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR!\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lkntr/app/game/base/ui/container/GameComposeContainerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "pageResultRegistry", "kntr/app/game/base/ui/container/GameComposeContainerActivity$pageResultRegistry$1", "Lkntr/app/game/base/ui/container/GameComposeContainerActivity$pageResultRegistry$1;", "isNight", RoomRecommendViewModel.EMPTY_CURSOR, "()Z", "onCreate", RoomRecommendViewModel.EMPTY_CURSOR, "savedInstanceState", "Landroid/os/Bundle;", "applyKomponent", "router", "Lkntr/base/router/Router;", "komponent", "Lkntr/common/komponent/Komponent;", "unifiedFontSizeRes", "Landroid/content/res/Resources;", "getUnifiedFontSizeRes$annotations", "getUnifiedFontSizeRes", "()Landroid/content/res/Resources;", "unifiedFontSizeRes$delegate", "Lkotlin/Lazy;", "getResources", "setDayOrNightMode", "updateNightMode", "resource", "on", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameComposeContainerActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private final GameComposeContainerActivity$pageResultRegistry$1 pageResultRegistry = new kntr.common.compose.launcher.PageResultRegistry() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$pageResultRegistry$1
        public <R> void setPageResult(R r, KSerializer<R> kSerializer) {
            Intrinsics.checkNotNullParameter(kSerializer, "serializer");
            if (r == null) {
                GameComposeContainerActivity.this.setResult(0);
            } else {
                GameComposeContainerActivity.this.setResult(-1, new Intent().putExtra("INTENT_KEY_KOMPONENT_RESULT", Json.Default.encodeToString((SerializationStrategy) kSerializer, r)));
            }
        }
    };
    private final Lazy unifiedFontSizeRes$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda7
        public final Object invoke() {
            Resources unifiedFontSizeRes_delegate$lambda$0;
            unifiedFontSizeRes_delegate$lambda$0 = GameComposeContainerActivity.unifiedFontSizeRes_delegate$lambda$0(GameComposeContainerActivity.this);
            return unifiedFontSizeRes_delegate$lambda$0;
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    private static /* synthetic */ void getUnifiedFontSizeRes$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    private final boolean isNight() {
        return ThemeDayNight.Companion.getCurrentTheme().getValue() == ThemeDayNight.Night;
    }

    protected void onCreate(Bundle savedInstanceState) {
        Uri it;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable$default((ComponentActivity) this, (SystemBarStyle) null, (SystemBarStyle) null, 3, (Object) null);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        setDayOrNightMode(isNight());
        Router.Builder this_$iv = GlobalRouterKt.getGlobalRouter().newBuilder();
        Function0 provider$iv = new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda8
            public final Object invoke() {
                ContextAware onCreate$lambda$0;
                onCreate$lambda$0 = GameComposeContainerActivity.onCreate$lambda$0(GameComposeContainerActivity.this);
                return onCreate$lambda$0;
            }
        };
        this_$iv.addContextProvider(Reflection.typeOf(ContextAware.class), provider$iv);
        Function0 provider$iv2 = new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda9
            public final Object invoke() {
                Context onCreate$lambda$1;
                onCreate$lambda$1 = GameComposeContainerActivity.onCreate$lambda$1(GameComposeContainerActivity.this);
                return onCreate$lambda$1;
            }
        };
        this_$iv.addContextProvider(Reflection.typeOf(Context.class), provider$iv2);
        Function0 provider$iv3 = new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda10
            public final Object invoke() {
                kntr.common.compose.launcher.PageResultRegistry onCreate$lambda$2;
                onCreate$lambda$2 = GameComposeContainerActivity.onCreate$lambda$2(GameComposeContainerActivity.this);
                return onCreate$lambda$2;
            }
        };
        this_$iv.addContextProvider(Reflection.typeOf(kntr.common.compose.launcher.PageResultRegistry.class), provider$iv3);
        final Router router = this_$iv.build();
        android.net.Uri data = getIntent().getData();
        RouterTarget target = (data == null || (it = AndroidUriKt.toUri(data)) == null) ? null : router.find(it);
        if (target == null) {
            KLog_androidKt.getKLog().e("GameComposeContainerActivity", "No target found for URI: " + getIntent().getData());
            finish();
            return;
        }
        RouterTarget $this$castOrNull$iv = target;
        FunctionTarget komponentTarget = RouterTargetKt.castOrNull($this$castOrNull$iv, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function0.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Komponent.class, KTypeProjection.Companion.getSTAR()))))));
        if (komponentTarget != null) {
            Komponent komponent = (Komponent) ((Function0) komponentTarget.getF()).invoke();
            applyKomponent(router, komponent);
            return;
        }
        Object composable = null;
        RouterTarget $this$castOrNull$iv2 = target;
        FunctionTarget it2 = RouterTargetKt.castOrNull($this$castOrNull$iv2, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function3.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Modifier.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))));
        if (it2 != null) {
            composable = it2.getF();
        }
        if (composable == null) {
            RouterTarget $this$castOrNull$iv3 = target;
            final FunctionTarget it3 = RouterTargetKt.castOrNull($this$castOrNull$iv3, Reflection.typeOf(FunctionTarget.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Function2.class, new KTypeProjection[]{KTypeProjection.Companion.invariant(Reflection.typeOf(Composer.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Integer.TYPE)), KTypeProjection.Companion.invariant(Reflection.typeOf(Unit.class))}))));
            if (it3 != null) {
                composable = ComposableLambdaKt.composableLambdaInstance(-890820311, true, new Function3() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit onCreate$lambda$5$0;
                        onCreate$lambda$5$0 = GameComposeContainerActivity.onCreate$lambda$5$0(it3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return onCreate$lambda$5$0;
                    }
                });
            }
        }
        if (composable != null) {
            final Function3 ui = GameComposeContainerStyleKt.getGameComposeContainerStyle().style((Function3) composable);
            ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(163812832, true, new Function2() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$6;
                    onCreate$lambda$6 = GameComposeContainerActivity.onCreate$lambda$6(router, ui, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$6;
                }
            }), 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContextAware onCreate$lambda$0(GameComposeContainerActivity this$0) {
        return (ContextAware) this$0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context onCreate$lambda$1(GameComposeContainerActivity this$0) {
        return (Context) this$0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kntr.common.compose.launcher.PageResultRegistry onCreate$lambda$2(GameComposeContainerActivity this$0) {
        return this$0.pageResultRegistry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$0(FunctionTarget $it, Modifier modifier, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        ComposerKt.sourceInformation($composer, "CN(modifier)125@4909L24:GameComposeContainer.android.kt#whusci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(modifier) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-890820311, $dirty, -1, "kntr.app.game.base.ui.container.GameComposeContainerActivity.onCreate.<anonymous>.<anonymous> (GameComposeContainer.android.kt:125)");
            }
            int $changed$iv = $dirty & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier);
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
            int i2 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1554287430, "C125@4928L3:GameComposeContainer.android.kt#whusci");
            ((Function2) $it.getF()).invoke($composer, 0);
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
    public static final Unit onCreate$lambda$6(Router $router, final Function3 $ui, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C134@5196L66,132@5103L159:GameComposeContainer.android.kt#whusci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(163812832, $changed, -1, "kntr.app.game.base.ui.container.GameComposeContainerActivity.onCreate.<anonymous> (GameComposeContainer.android.kt:132)");
            }
            CompositionLocalKt.CompositionLocalProvider(RouterKt.getLocalRouter().provides($router), ComposableLambdaKt.rememberComposableLambda(1167812896, true, new Function2() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$6$0;
                    onCreate$lambda$6$0 = GameComposeContainerActivity.onCreate$lambda$6$0($ui, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$6$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$6$0(Function3 $ui, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C135@5218L26:GameComposeContainer.android.kt#whusci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1167812896, $changed, -1, "kntr.app.game.base.ui.container.GameComposeContainerActivity.onCreate.<anonymous>.<anonymous> (GameComposeContainer.android.kt:135)");
            }
            $ui.invoke(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void applyKomponent(final Router router, Komponent<?> komponent) {
        final UiComposableLike uiComposableLike = KomponentKt.actIn(komponent, LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), new Function1() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit applyKomponent$lambda$0;
                applyKomponent$lambda$0 = GameComposeContainerActivity.applyKomponent$lambda$0(router, this, (ProvideLocalsScope) obj);
                return applyKomponent$lambda$0;
            }
        });
        FlowKt.launchIn(FlowKt.onEach(SnapshotStateKt.snapshotFlow(new Function0() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda4
            public final Object invoke() {
                Orientation applyKomponent$lambda$1;
                applyKomponent$lambda$1 = GameComposeContainerActivity.applyKomponent$lambda$1(uiComposableLike);
                return applyKomponent$lambda$1;
            }
        }), new GameComposeContainerActivity$applyKomponent$2(this, null)), LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this));
        final Function3 ui = GameComposeContainerStyleKt.getGameComposeContainerStyle().style((Function3) ComposableLambdaKt.composableLambdaInstance(1808693249, true, new Function3() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit applyKomponent$lambda$2;
                applyKomponent$lambda$2 = GameComposeContainerActivity.applyKomponent$lambda$2(uiComposableLike, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return applyKomponent$lambda$2;
            }
        }));
        ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(-1016482768, true, new Function2() { // from class: kntr.app.game.base.ui.container.GameComposeContainerActivity$$ExternalSyntheticLambda6
            public final Object invoke(Object obj, Object obj2) {
                Unit applyKomponent$lambda$3;
                applyKomponent$lambda$3 = GameComposeContainerActivity.applyKomponent$lambda$3(ui, (Composer) obj, ((Integer) obj2).intValue());
                return applyKomponent$lambda$3;
            }
        }), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyKomponent$lambda$0(Router $router, GameComposeContainerActivity this$0, ProvideLocalsScope $this$actIn) {
        Intrinsics.checkNotNullParameter($this$actIn, "$this$actIn");
        $this$actIn.provides(KomponentRouterKt.getLocalRouter(), $router);
        $this$actIn.provides(OnBackPressedDispatcherKt.getLocalOnBackPressedDispatcher(), this$0.getOnBackPressedDispatcher());
        $this$actIn.provides(LifecycleKt.getLocalLifecycleOwner(), this$0);
        $this$actIn.provides(LocalContextKt.getLocalContext(), this$0);
        $this$actIn.provides(LocalOnFinishKt.getLocalOnFinishHostRequest(), new GameComposeContainerActivity$applyKomponent$uiComposableLike$1$1(this$0));
        $this$actIn.provides(LocalToasterKt.getLocalToaster(), new AndroidToaster((Context) this$0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Orientation applyKomponent$lambda$1(UiComposableLike $uiComposableLike) {
        return $uiComposableLike.getPreferredHostConfiguration().getOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyKomponent$lambda$2(UiComposableLike $uiComposableLike, Modifier it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)169@7017L20:GameComposeContainer.android.kt#whusci");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808693249, $dirty, -1, "kntr.app.game.base.ui.container.GameComposeContainerActivity.applyKomponent.<anonymous> (GameComposeContainer.android.kt:169)");
            }
            $uiComposableLike.invoke(it, $composer, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyKomponent$lambda$3(Function3 $ui, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C171@7073L26:GameComposeContainer.android.kt#whusci");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1016482768, $changed, -1, "kntr.app.game.base.ui.container.GameComposeContainerActivity.applyKomponent.<anonymous> (GameComposeContainer.android.kt:171)");
            }
            $ui.invoke(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final Resources getUnifiedFontSizeRes() {
        return (Resources) this.unifiedFontSizeRes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Resources unifiedFontSizeRes_delegate$lambda$0(GameComposeContainerActivity this$0) {
        Resources res = super.getResources();
        Configuration newConfig = res.getConfiguration();
        DisplayMetrics displayMetrics = res.getDisplayMetrics();
        if (!(newConfig.fontScale == 1.0f)) {
            newConfig.fontScale = 1.0f;
            displayMetrics.scaledDensity = displayMetrics.density * newConfig.fontScale;
            res.updateConfiguration(newConfig, displayMetrics);
        }
        Intrinsics.checkNotNull(res);
        return this$0.updateNightMode(res, this$0.isNight());
    }

    public Resources getResources() {
        return getUnifiedFontSizeRes();
    }

    private final void setDayOrNightMode(boolean isNight) {
        getDelegate().setLocalNightMode(isNight ? 2 : 1);
    }

    private final Resources updateNightMode(Resources resource, boolean on) {
        DisplayMetrics dm = resource.getDisplayMetrics();
        Configuration config = resource.getConfiguration();
        int uiModeNightMaskOrigin = config.uiMode & (-16);
        int uiModeNightMaskNew = on ? 32 : 16;
        if (uiModeNightMaskOrigin != uiModeNightMaskNew) {
            config.uiMode &= -49;
            config.uiMode |= uiModeNightMaskNew;
            resource.updateConfiguration(config, dm);
        }
        return resource;
    }
}