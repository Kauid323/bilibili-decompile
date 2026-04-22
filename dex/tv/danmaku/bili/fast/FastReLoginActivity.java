package tv.danmaku.bili.fast;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
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
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.pvtracker.IPvTracker;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.helper.LoginLifecycleObserver;
import tv.danmaku.bili.normal.ui.RouteUtilKt;
import tv.danmaku.bili.report.LoginReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: FastReLoginActivity.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u0014H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Ltv/danmaku/bili/fast/FastReLoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/fast/FastReLoginViewModel;", "getViewModel", "()Ltv/danmaku/bili/fast/FastReLoginViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pageStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ltv/danmaku/bili/fast/FastReLoginState;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "routeTo", "url", "", "clickLogin", "agreed", "", "performLogin", "loginOther", "registerLoginListener", "routeToLogin", "onAgreementDialogConfirmed", "reportClick", "option", "finish", "skipCheck", "getPvEventId", "getPvExtra", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FastReLoginActivity extends AppCompatActivity implements IPvTracker {
    public static final int $stable = 8;
    private final MutableStateFlow<FastReLoginState> pageStateFlow;
    private final Lazy viewModel$delegate;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    public FastReLoginActivity() {
        getDelegate().setLocalNightMode(MultipleThemeUtils.getCurrentNightMode((Context) this));
        final ComponentActivity $this$viewModels_u24default$iv = (ComponentActivity) this;
        Function0 factoryPromise$iv = new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$special$$inlined$viewModels$default$1
            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1012invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        };
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(FastReLoginViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$special$$inlined$viewModels$default$2
            /* renamed from: invoke */
            public final ViewModelStore m1013invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, factoryPromise$iv, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$special$$inlined$viewModels$default$3
            /* renamed from: invoke */
            public final CreationExtras m1014invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r1;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.pageStateFlow = StateFlowKt.MutableStateFlow((Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FastReLoginViewModel getViewModel() {
        return (FastReLoginViewModel) this.viewModel$delegate.getValue();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerLoginListener();
        getLifecycle().addObserver(LoginLifecycleObserver.INSTANCE);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        LoginReportHelper.generateValueFromIntent(intent);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FastReLoginActivity$onCreate$1(this, null), 3, (Object) null);
        overridePendingTransition(0, 0);
        ComponentActivityKt.setContent$default((ComponentActivity) this, (CompositionContext) null, ComposableLambdaKt.composableLambdaInstance(432022319, true, new Function2() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreate$lambda$0;
                onCreate$lambda$0 = FastReLoginActivity.onCreate$lambda$0(FastReLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreate$lambda$0;
            }
        }), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(final FastReLoginActivity this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C89@3573L1429,89@3563L1439,115@5026L211,115@5015L222:FastReLoginActivity.kt#gr7clh");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(432022319, $changed, -1, "tv.danmaku.bili.fast.FastReLoginActivity.onCreate.<anonymous> (FastReLoginActivity.kt:89)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1722469095, true, new Function2() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreate$lambda$0$0;
                    onCreate$lambda$0$0 = FastReLoginActivity.onCreate$lambda$0$0(FastReLoginActivity.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreate$lambda$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            ComposerKt.sourceInformationMarkerStart($composer, -1438331678, "CC(remember):FastReLoginActivity.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit onCreate$lambda$0$1$0;
                        onCreate$lambda$0$1$0 = FastReLoginActivity.onCreate$lambda$0$1$0();
                        return onCreate$lambda$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.SideEffect((Function0) it$iv, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0172, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x01ac, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01e6, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0220, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x025a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x029b, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreate$lambda$0$0(final FastReLoginActivity this$0, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C90@3591L1397:FastReLoginActivity.kt#gr7clh");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1722469095, $changed, -1, "tv.danmaku.bili.fast.FastReLoginActivity.onCreate.<anonymous>.<anonymous> (FastReLoginActivity.kt:90)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & BR.containerVisible;
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
            int i2 = ((54 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 2037790497, "C91@3719L16:FastReLoginActivity.kt#gr7clh");
            FastReLoginState pageState = (FastReLoginState) SnapshotStateKt.collectAsState(this$0.pageStateFlow, (CoroutineContext) null, $composer, 0, 1).getValue();
            if (pageState != null) {
                $composer.startReplaceGroup(2037907056);
                ComposerKt.sourceInformation($composer, "96@4011L32,97@4088L36,98@4170L36,99@4255L33,110@4869L52,105@4607L204,100@4346L210,93@3811L1137");
                boolean quickReloginSkippable = this$0.getViewModel().getFullscreenLoginExp().getQuickReloginSkippable();
                ComposerKt.sourceInformationMarkerStart($composer, 897028225, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(this$0);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = (KFunction) new FastReLoginActivity$onCreate$2$1$1$1$1(this$0);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                Function0 function0 = (KFunction) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 897030693, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(this$0);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = (KFunction) new FastReLoginActivity$onCreate$2$1$1$2$1(this$0);
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                Function1 function1 = (KFunction) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 897033317, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance(this$0);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = (KFunction) new FastReLoginActivity$onCreate$2$1$1$3$1(this$0);
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                Function1 function12 = (KFunction) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 897036034, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv4 = $composer.changedInstance(this$0);
                Object it$iv4 = $composer.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv4 = (KFunction) new FastReLoginActivity$onCreate$2$1$1$4$1(this$0);
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                Function1 function13 = (KFunction) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 897055701, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv5 = $composer.changedInstance(this$0);
                Object it$iv5 = $composer.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv5 = (KFunction) new FastReLoginActivity$onCreate$2$1$1$5$1(this$0);
                $composer.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
                Function0 function02 = (KFunction) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Function0 function03 = function0;
                Function1 function14 = function1;
                ComposerKt.sourceInformationMarkerStart($composer, 897047469, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv6 = $composer.changedInstance(this$0);
                Object it$iv6 = $composer.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        Unit onCreate$lambda$0$0$0$5$0;
                        onCreate$lambda$0$0$0$5$0 = FastReLoginActivity.onCreate$lambda$0$0$0$5$0(FastReLoginActivity.this, ((Boolean) obj).booleanValue());
                        return onCreate$lambda$0$0$0$5$0;
                    }
                };
                $composer.updateRememberedValue(value$iv6);
                it$iv6 = value$iv6;
                Function1 function15 = (Function1) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Function0 function04 = function02;
                ComposerKt.sourceInformationMarkerStart($composer, 897039123, "CC(remember):FastReLoginActivity.kt#9igjgp");
                boolean invalid$iv7 = $composer.changedInstance(this$0);
                Object it$iv7 = $composer.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: tv.danmaku.bili.fast.FastReLoginActivity$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit onCreate$lambda$0$0$0$6$0;
                            onCreate$lambda$0$0$0$6$0 = FastReLoginActivity.onCreate$lambda$0$0$0$6$0(FastReLoginActivity.this);
                            return onCreate$lambda$0$0$0$6$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                FastReloginComposeKt.FastReLoginDialog(pageState, quickReloginSkippable, function03, function14, function15, function04, (Function0) it$iv7, function12, function13, $composer, 0, 0);
            } else {
                $composer.startReplaceGroup(2034090305);
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
    public static final Unit onCreate$lambda$0$0$0$6$0(FastReLoginActivity this$0) {
        MutableStateFlow<FastReLoginState> mutableStateFlow = this$0.pageStateFlow;
        FastReLoginState fastReLoginState = (FastReLoginState) this$0.pageStateFlow.getValue();
        mutableStateFlow.setValue(fastReLoginState != null ? FastReLoginState.copy$default(fastReLoginState, null, false, false, false, 7, null) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$0$0$5$0(FastReLoginActivity this$0, boolean it) {
        MutableStateFlow<FastReLoginState> mutableStateFlow = this$0.pageStateFlow;
        FastReLoginState fastReLoginState = (FastReLoginState) this$0.pageStateFlow.getValue();
        mutableStateFlow.setValue(fastReLoginState != null ? FastReLoginState.copy$default(fastReLoginState, null, false, it, false, 11, null) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0$1$0() {
        Neurons.reportExposure$default(false, "app.fast-login.0.0.show", LoginReportHelper.getCommonParams().build(), (List) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeTo(String url) {
        BLog.i(FastReLoginActivityKt.TAG, "Route to " + url);
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(url), (Context) this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clickLogin(boolean agreed) {
        reportClick("1", agreed);
        if (agreed) {
            performLogin();
            return;
        }
        MutableStateFlow<FastReLoginState> mutableStateFlow = this.pageStateFlow;
        FastReLoginState fastReLoginState = (FastReLoginState) this.pageStateFlow.getValue();
        mutableStateFlow.setValue(fastReLoginState != null ? FastReLoginState.copy$default(fastReLoginState, null, false, false, true, 7, null) : null);
    }

    private final void performLogin() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FastReLoginActivity$performLogin$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loginOther(boolean agreed) {
        routeToLogin();
        reportClick("2", agreed);
    }

    private final void registerLoginListener() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FastReLoginActivity$registerLoginListener$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void routeToLogin() {
        BLog.i(FastReLoginActivityKt.TAG, "Route to other login page");
        if (!getViewModel().getLoginNewRoute()) {
            RouteUtilKt.routeToLoginActivity((Context) this, null, true, true, true, (r23 & 32) != 0 ? null : getViewModel().getPromptScene(), (r23 & 64) != 0 ? null : getViewModel().getRouteFrom(), (r23 & BR.cover) != 0 ? null : 33554432, (r23 & BR.hallEnterHotText) != 0 ? false : true, (r23 & BR.roleType) != 0 ? null : null);
            super.finish();
            if (getViewModel().getInDialogManager()) {
                MainDialogManager.showNextDialog("login_guide", false, (Context) this);
                return;
            }
            return;
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new FastReLoginActivity$routeToLogin$1(this, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAgreementDialogConfirmed() {
        MutableStateFlow<FastReLoginState> mutableStateFlow = this.pageStateFlow;
        FastReLoginState fastReLoginState = (FastReLoginState) this.pageStateFlow.getValue();
        mutableStateFlow.setValue(fastReLoginState != null ? FastReLoginState.copy$default(fastReLoginState, null, false, true, false, 3, null) : null);
        performLogin();
    }

    private final void reportClick(String option, boolean agreed) {
        Map<String, String> build = LoginReportHelper.getCommonParams().build();
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("option", option);
        pairArr[1] = TuplesKt.to("is_agree", agreed ? "1" : "0");
        Neurons.reportClick(false, LoginReporterV2.Click.APP_FAST_RE_LOGIN_BTN_CLICK, MapsKt.plus(build, MapsKt.mapOf(pairArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finish(boolean skipCheck) {
        if (getViewModel().getFullscreenLoginExp().getQuickReloginSkippable() || BiliAccounts.get((Context) this).isLogin() || skipCheck) {
            super.finish();
            if (getViewModel().getInDialogManager()) {
                MainDialogManager.showNextDialog("login_guide", false, (Context) this);
            }
        }
    }

    public void finish() {
        finish(false);
    }

    public String getPvEventId() {
        return "app.fast-login.0.0.pv";
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }
}