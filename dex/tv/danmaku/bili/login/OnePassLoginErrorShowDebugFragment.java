package tv.danmaku.bili.login;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonElevation;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.spy.generated.androidx_fragment_app_Fragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.login.ActionResult;
import tv.danmaku.bili.login.LoginCheckState;
import tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment;
import tv.danmaku.bili.quick.core.OnePassLoginError;
import tv.danmaku.bili.quick.core.OnePassLoginErrorData;

/* compiled from: OnePassLoginErrorShowDebugFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u0018J#\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u0010!J\u0015\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006'"}, d2 = {"Ltv/danmaku/bili/login/OnePassLoginErrorShowDebugFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "viewModel", "Ltv/danmaku/bili/login/OnePassLoginCheckViewModel;", "getViewModel", "()Ltv/danmaku/bili/login/OnePassLoginCheckViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "LoginCheckList", "", AuthResultCbHelper.ARGS_STATE, "Ltv/danmaku/bili/login/LoginCheckState;", "actionHandler", "Ltv/danmaku/bili/login/LoginCheckActionHandler;", "(Ltv/danmaku/bili/login/LoginCheckState;Ltv/danmaku/bili/login/LoginCheckActionHandler;Landroidx/compose/runtime/Composer;I)V", "LazyColumnList", "list", "", "Ltv/danmaku/bili/quick/core/OnePassLoginError;", "clearOrReload", "Ltv/danmaku/bili/login/OnePassLoginErrorShowDebugFragment$ButtonStatus;", "(Ljava/util/List;Ltv/danmaku/bili/login/OnePassLoginErrorShowDebugFragment$ButtonStatus;Landroidx/compose/runtime/Composer;I)V", "ClearOrReloadButton", "(Ltv/danmaku/bili/login/OnePassLoginErrorShowDebugFragment$ButtonStatus;Landroidx/compose/runtime/Composer;I)V", "FirstColumn", "width", "", "(ILandroidx/compose/runtime/Composer;I)V", "ButtonStatus", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class OnePassLoginErrorShowDebugFragment extends androidx_fragment_app_Fragment {
    public static final int $stable = 8;
    private final Lazy viewModel$delegate;

    /* compiled from: OnePassLoginErrorShowDebugFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/login/OnePassLoginErrorShowDebugFragment$ButtonStatus;", "", "<init>", "(Ljava/lang/String;I)V", "Clear", "Reload", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public enum ButtonStatus {
        Clear,
        Reload;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ButtonStatus> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearOrReloadButton$lambda$2(OnePassLoginErrorShowDebugFragment onePassLoginErrorShowDebugFragment, ButtonStatus buttonStatus, int i, Composer composer, int i2) {
        onePassLoginErrorShowDebugFragment.ClearOrReloadButton(buttonStatus, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FirstColumn$lambda$1(OnePassLoginErrorShowDebugFragment onePassLoginErrorShowDebugFragment, int i, int i2, Composer composer, int i3) {
        onePassLoginErrorShowDebugFragment.FirstColumn(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyColumnList$lambda$1(OnePassLoginErrorShowDebugFragment onePassLoginErrorShowDebugFragment, List list, ButtonStatus buttonStatus, int i, Composer composer, int i2) {
        onePassLoginErrorShowDebugFragment.LazyColumnList(list, buttonStatus, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginCheckList$lambda$3(OnePassLoginErrorShowDebugFragment onePassLoginErrorShowDebugFragment, LoginCheckState loginCheckState, LoginCheckActionHandler loginCheckActionHandler, int i, Composer composer, int i2) {
        onePassLoginErrorShowDebugFragment.LoginCheckList(loginCheckState, loginCheckActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public OnePassLoginErrorShowDebugFragment() {
        final Fragment $this$viewModels_u24default$iv = (Fragment) this;
        final Function0 ownerProducer$iv = new Function0<Fragment>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$special$$inlined$viewModels$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final Fragment m1183invoke() {
                return $this$viewModels_u24default$iv;
            }
        };
        final Lazy owner$delegate$iv = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<ViewModelStoreOwner>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$special$$inlined$viewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStoreOwner m1184invoke() {
                return (ViewModelStoreOwner) ownerProducer$iv.invoke();
            }
        });
        this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy($this$viewModels_u24default$iv, Reflection.getOrCreateKotlinClass(OnePassLoginCheckViewModel.class), new Function0<ViewModelStore>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelStore m1185invoke() {
                return FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final CreationExtras m1186invoke() {
                CreationExtras creationExtras;
                Function0 function0 = r2;
                if (function0 != null && (creationExtras = (CreationExtras) function0.invoke()) != null) {
                    return creationExtras;
                }
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                return hasDefaultViewModelProviderFactory2 != null ? hasDefaultViewModelProviderFactory2.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke */
            public final ViewModelProvider.Factory m1187invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = FragmentViewModelLazyKt.access$viewModels$lambda-1(owner$delegate$iv);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory2 = hasDefaultViewModelProviderFactory instanceof HasDefaultViewModelProviderFactory ? hasDefaultViewModelProviderFactory : null;
                if (hasDefaultViewModelProviderFactory2 != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory2.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OnePassLoginCheckViewModel getViewModel() {
        return (OnePassLoginCheckViewModel) this.viewModel$delegate.getValue();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context context = inflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        View composeView = new ComposeView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1895258646, true, new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2) {
                Unit onCreateView$lambda$0$0;
                onCreateView$lambda$0$0 = OnePassLoginErrorShowDebugFragment.onCreateView$lambda$0$0(OnePassLoginErrorShowDebugFragment.this, (Composer) obj, ((Integer) obj2).intValue());
                return onCreateView$lambda$0$0;
            }
        }));
        return composeView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final OnePassLoginErrorShowDebugFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C54@2159L167,54@2149L177:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1895258646, $changed, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.onCreateView.<anonymous>.<anonymous> (OnePassLoginErrorShowDebugFragment.kt:54)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(283981618, true, new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit onCreateView$lambda$0$0$0;
                    onCreateView$lambda$0$0$0 = OnePassLoginErrorShowDebugFragment.onCreateView$lambda$0$0$0(OnePassLoginErrorShowDebugFragment.this, (Composer) obj, ((Integer) obj2).intValue());
                    return onCreateView$lambda$0$0$0;
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(OnePassLoginErrorShowDebugFragment this$0, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C55@2209L16,56@2246L62:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(283981618, $changed, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (OnePassLoginErrorShowDebugFragment.kt:55)");
            }
            State state = SnapshotStateKt.collectAsState(this$0.getViewModel().getState(), (CoroutineContext) null, $composer, 0, 1);
            this$0.LoginCheckList((LoginCheckState) state.getValue(), this$0.getViewModel(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0120, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void LoginCheckList(final LoginCheckState state, final LoginCheckActionHandler actionHandler, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-935974554);
        ComposerKt.sourceInformation($composer2, "C(LoginCheckList)N(state,actionHandler)69@2557L79,72@2665L68,75@2742L47:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(actionHandler) : $composer2.changedInstance(actionHandler) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(this) ? BR.hallEnterHotText : BR.cover;
        }
        if ($composer2.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-935974554, $dirty, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.LoginCheckList (OnePassLoginErrorShowDebugFragment.kt:68)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1823378123, "CC(remember):OnePassLoginErrorShowDebugFragment.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState list = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1823374678, "CC(remember):OnePassLoginErrorShowDebugFragment.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotStateKt.mutableStateOf$default(ButtonStatus.Reload, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableState clearOrReload = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyColumnList((List) list.getValue(), (ButtonStatus) clearOrReload.getValue(), $composer2, $dirty & 896);
            if (Intrinsics.areEqual(state, LoginCheckState.IDLE.INSTANCE)) {
                $composer2.startReplaceGroup(-689850913);
                ComposerKt.sourceInformation($composer2, "*79@2924L178");
                LoginCheckActionScope $this$LoginCheckList_u24lambda_u242 = LoginCheckActionScope.Companion.getInstance();
                ComposerKt.sourceInformationMarkerStart($composer2, 157101991, "CC(remember):OnePassLoginErrorShowDebugFragment.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(this);
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        ActionResult.StateWithSideEffect LoginCheckList$lambda$2$0$0;
                        LoginCheckList$lambda$2$0$0 = OnePassLoginErrorShowDebugFragment.LoginCheckList$lambda$2$0$0(OnePassLoginErrorShowDebugFragment.this, (LoginCheckActionScope) obj, (LoginCheckState) obj2);
                        return LoginCheckList$lambda$2$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                actionHandler.onAction($this$LoginCheckList_u24lambda_u242.sideEffective((Function2) it$iv3));
                $composer2.endReplaceGroup();
            } else if (state instanceof LoginCheckState.Loaded) {
                $composer2.startReplaceGroup(-689530807);
                $composer2.endReplaceGroup();
                list.setValue(((LoginCheckState.Loaded) state).getColumns());
                clearOrReload.setValue(ButtonStatus.Clear);
            } else if (Intrinsics.areEqual(state, LoginCheckState.Loading.INSTANCE)) {
                $composer2.startReplaceGroup(-689379124);
                $composer2.endReplaceGroup();
            } else if (Intrinsics.areEqual(state, LoginCheckState.Failed.INSTANCE)) {
                $composer2.startReplaceGroup(-689321805);
                $composer2.endReplaceGroup();
                clearOrReload.setValue(ButtonStatus.Reload);
            } else if (!Intrinsics.areEqual(state, LoginCheckState.Cleared.INSTANCE)) {
                $composer2.startReplaceGroup(-1823369719);
                $composer2.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer2.startReplaceGroup(-689209244);
                $composer2.endReplaceGroup();
                list.setValue(CollectionsKt.emptyList());
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginCheckList$lambda$3;
                    LoginCheckList$lambda$3 = OnePassLoginErrorShowDebugFragment.LoginCheckList$lambda$3(OnePassLoginErrorShowDebugFragment.this, state, actionHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginCheckList$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionResult.StateWithSideEffect LoginCheckList$lambda$2$0$0(OnePassLoginErrorShowDebugFragment this$0, LoginCheckActionScope $this$sideEffective, LoginCheckState it) {
        Intrinsics.checkNotNullParameter($this$sideEffective, "$this$sideEffective");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ActionResult.StateWithSideEffect(LoginCheckState.Loading.INSTANCE, new OnePassLoginErrorShowDebugFragment$LoginCheckList$1$1$1$1(this$0, null));
    }

    public final void LazyColumnList(final List<OnePassLoginError> list, final ButtonStatus clearOrReload, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(clearOrReload, "clearOrReload");
        Composer $composer3 = $composer.startRestartGroup(450513764);
        ComposerKt.sourceInformation($composer3, "C(LazyColumnList)N(list,clearOrReload)108@3717L7,115@3992L1225,109@3752L1465:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(clearOrReload.ordinal()) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changedInstance(this) ? BR.hallEnterHotText : BR.cover;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & BR.danmakuNumIcon) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(450513764, $dirty2, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.LazyColumnList (OnePassLoginErrorShowDebugFragment.kt:107)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final int width = ((Configuration) consume).screenWidthDp - 16;
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.Companion.getWhite-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(8), 0.0f, 10, (Object) null);
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, -847955827, "CC(remember):OnePassLoginErrorShowDebugFragment.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(this) | (($dirty2 & BR.containerVisible) == 32) | $composer3.changed(width) | $composer3.changedInstance(list);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit LazyColumnList$lambda$0$0;
                        LazyColumnList$lambda$0$0 = OnePassLoginErrorShowDebugFragment.LazyColumnList$lambda$0$0(list, this, clearOrReload, width, (LazyListScope) obj);
                        return LazyColumnList$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier, (LazyListState) null, (PaddingValues) null, false, vertical, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer3, 24582, (int) BR.rightBadgeVisible);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit LazyColumnList$lambda$1;
                    LazyColumnList$lambda$1 = OnePassLoginErrorShowDebugFragment.LazyColumnList$lambda$1(OnePassLoginErrorShowDebugFragment.this, list, clearOrReload, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LazyColumnList$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyColumnList$lambda$0$0(final List $list, final OnePassLoginErrorShowDebugFragment this$0, final ButtonStatus $clearOrReload, final int $width, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1021666297, true, new Function3() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit LazyColumnList$lambda$0$0$0;
                LazyColumnList$lambda$0$0$0 = OnePassLoginErrorShowDebugFragment.LazyColumnList$lambda$0$0$0(OnePassLoginErrorShowDebugFragment.this, $clearOrReload, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return LazyColumnList$lambda$0$0$0;
            }
        }), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-896886928, true, new Function3() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit LazyColumnList$lambda$0$0$1;
                LazyColumnList$lambda$0$0$1 = OnePassLoginErrorShowDebugFragment.LazyColumnList$lambda$0$0$1(OnePassLoginErrorShowDebugFragment.this, $width, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return LazyColumnList$lambda$0$0$1;
            }
        }), 3, (Object) null);
        final Function1 contentType$iv = new Function1() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return m1182invoke((OnePassLoginError) p1);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final Void m1182invoke(OnePassLoginError onePassLoginError) {
                return null;
            }
        };
        $this$LazyColumn.items($list.size(), (Function1) null, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke($list.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$4
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                Function0 factory$iv$iv$iv2;
                OnePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$4 onePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$4 = this;
                ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                int i = $dirty & 14;
                OnePassLoginError it2 = (OnePassLoginError) $list.get(it);
                $composer.startReplaceGroup(923177389);
                ComposerKt.sourceInformation($composer, "CN(it)*123@4188L1005:OnePassLoginErrorShowDebugFragment.kt#m400d2");
                Modifier modifier$iv = BorderKt.border-xT4_qwU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(1), Color.Companion.getBlue-0d7_KjU(), (Shape) null, 4, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                int $changed$iv$iv = (6 << 3) & BR.containerVisible;
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
                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i3 = ((6 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 308034763, "C131@4564L9,128@4382L217,133@4620L555:OnePassLoginErrorShowDebugFragment.kt#m400d2");
                TextKt.Text--4IGK_g(it2.getTime(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), Dp.constructor-impl(2), 0.0f, Dp.constructor-impl(2), 4, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 48, 0, 65532);
                Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, Dp.constructor-impl(2), Dp.constructor-impl(2), 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                int $changed$iv$iv2 = (6 << 3) & BR.containerVisible;
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
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -831000881, "C:OnePassLoginErrorShowDebugFragment.kt#m400d2");
                $composer.startReplaceGroup(111740852);
                ComposerKt.sourceInformation($composer, "*137@4924L9,135@4769L276,140@5074L53");
                Iterator<OnePassLoginErrorData> it3 = it2.getList().iterator();
                while (it3.hasNext()) {
                    OnePassLoginErrorData i6 = it3.next();
                    Iterator<OnePassLoginErrorData> it4 = it3;
                    OnePassLoginError it5 = it2;
                    String str = Intrinsics.areEqual(i6.getPhaseStatus(), "通过") ? "通过此阶段" : "错误信息为：" + i6.getError();
                    TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
                    boolean z2 = z;
                    double $this$dp$iv = $width * 0.25d;
                    TextKt.Text--4IGK_g(str, SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv)), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer, 0, 0, 65532);
                    double $this$dp$iv2 = $width * 0.125d;
                    SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv2)), $composer, 0);
                    onePassLoginErrorShowDebugFragment$LazyColumnList$lambda$0$0$$inlined$items$default$4 = this;
                    materialized$iv$iv2 = materialized$iv$iv2;
                    it3 = it4;
                    it2 = it5;
                    z = z2;
                }
                $composer.endReplaceGroup();
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
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyColumnList$lambda$0$0$0(OnePassLoginErrorShowDebugFragment this$0, ButtonStatus $clearOrReload, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C117@4029L34:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1021666297, $changed, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.LazyColumnList.<anonymous>.<anonymous>.<anonymous> (OnePassLoginErrorShowDebugFragment.kt:117)");
            }
            this$0.ClearOrReloadButton($clearOrReload, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LazyColumnList$lambda$0$0$1(OnePassLoginErrorShowDebugFragment this$0, int $width, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C120@4113L18:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-896886928, $changed, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.LazyColumnList.<anonymous>.<anonymous>.<anonymous> (OnePassLoginErrorShowDebugFragment.kt:120)");
            }
            this$0.FirstColumn($width, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final void ClearOrReloadButton(final ButtonStatus clearOrReload, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(clearOrReload, "clearOrReload");
        Composer $composer3 = $composer.startRestartGroup(1820154117);
        ComposerKt.sourceInformation($composer3, "C(ClearOrReloadButton)N(clearOrReload)151@5338L705,175@6315L6,176@6375L6,174@6257L150,178@6418L175,150@5308L1285:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(clearOrReload.ordinal()) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(this) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1820154117, $dirty2, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.ClearOrReloadButton (OnePassLoginErrorShowDebugFragment.kt:149)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1116420646, "CC(remember):OnePassLoginErrorShowDebugFragment.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(this) | (($dirty2 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit ClearOrReloadButton$lambda$0$0;
                        ClearOrReloadButton$lambda$0$0 = OnePassLoginErrorShowDebugFragment.ClearOrReloadButton$lambda$0$0(OnePassLoginErrorShowDebugFragment.ButtonStatus.this, this);
                        return ClearOrReloadButton$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            ButtonKt.Button((Function0) it$iv, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(32), Dp.constructor-impl(4), Dp.constructor-impl(32), 0.0f, 8, (Object) null), false, (MutableInteractionSource) null, (ButtonElevation) null, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), (BorderStroke) null, ButtonDefaults.INSTANCE.buttonColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, 0L, $composer3, ButtonDefaults.$stable << 12, 12), (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(101948661, true, new Function3() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit ClearOrReloadButton$lambda$1;
                    ClearOrReloadButton$lambda$1 = OnePassLoginErrorShowDebugFragment.ClearOrReloadButton$lambda$1(OnePassLoginErrorShowDebugFragment.ButtonStatus.this, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return ClearOrReloadButton$lambda$1;
                }
            }, $composer2, 54), $composer2, 805306368, (int) BR.leftText);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit ClearOrReloadButton$lambda$2;
                    ClearOrReloadButton$lambda$2 = OnePassLoginErrorShowDebugFragment.ClearOrReloadButton$lambda$2(OnePassLoginErrorShowDebugFragment.this, clearOrReload, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ClearOrReloadButton$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearOrReloadButton$lambda$0$0(ButtonStatus $clearOrReload, final OnePassLoginErrorShowDebugFragment this$0) {
        if ($clearOrReload == ButtonStatus.Clear) {
            LoginCheckActionHandler $this$handle$iv = this$0.getViewModel();
            LoginCheckActionScope $this$ClearOrReloadButton_u24lambda_u240_u240_u240 = LoginCheckActionScope.Companion.getInstance();
            $this$handle$iv.onAction($this$ClearOrReloadButton_u24lambda_u240_u240_u240.sideEffective(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    ActionResult.StateWithSideEffect ClearOrReloadButton$lambda$0$0$0$0;
                    ClearOrReloadButton$lambda$0$0$0$0 = OnePassLoginErrorShowDebugFragment.ClearOrReloadButton$lambda$0$0$0$0(OnePassLoginErrorShowDebugFragment.this, (LoginCheckActionScope) obj, (LoginCheckState) obj2);
                    return ClearOrReloadButton$lambda$0$0$0$0;
                }
            }));
        } else {
            LoginCheckActionHandler $this$handle$iv2 = this$0.getViewModel();
            LoginCheckActionScope $this$ClearOrReloadButton_u24lambda_u240_u240_u241 = LoginCheckActionScope.Companion.getInstance();
            $this$handle$iv2.onAction($this$ClearOrReloadButton_u24lambda_u240_u240_u241.sideEffective(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    ActionResult.StateWithSideEffect ClearOrReloadButton$lambda$0$0$1$0;
                    ClearOrReloadButton$lambda$0$0$1$0 = OnePassLoginErrorShowDebugFragment.ClearOrReloadButton$lambda$0$0$1$0(OnePassLoginErrorShowDebugFragment.this, (LoginCheckActionScope) obj, (LoginCheckState) obj2);
                    return ClearOrReloadButton$lambda$0$0$1$0;
                }
            }));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionResult.StateWithSideEffect ClearOrReloadButton$lambda$0$0$0$0(OnePassLoginErrorShowDebugFragment this$0, LoginCheckActionScope $this$sideEffective, LoginCheckState it) {
        Intrinsics.checkNotNullParameter($this$sideEffective, "$this$sideEffective");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ActionResult.StateWithSideEffect(LoginCheckState.IDLE.INSTANCE, new OnePassLoginErrorShowDebugFragment$ClearOrReloadButton$1$1$1$1$1(this$0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActionResult.StateWithSideEffect ClearOrReloadButton$lambda$0$0$1$0(OnePassLoginErrorShowDebugFragment this$0, LoginCheckActionScope $this$sideEffective, LoginCheckState it) {
        Intrinsics.checkNotNullParameter($this$sideEffective, "$this$sideEffective");
        Intrinsics.checkNotNullParameter(it, "it");
        return new ActionResult.StateWithSideEffect(LoginCheckState.Loading.INSTANCE, new OnePassLoginErrorShowDebugFragment$ClearOrReloadButton$1$1$2$1$1(this$0, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearOrReloadButton$lambda$1(ButtonStatus $clearOrReload, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C181@6556L9,179@6432L151:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(101948661, $changed, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.ClearOrReloadButton.<anonymous> (OnePassLoginErrorShowDebugFragment.kt:179)");
            }
            TextKt.Text--4IGK_g($clearOrReload == ButtonStatus.Clear ? "清除数据" : "重新加载", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT18(), $composer, 0, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public final void FirstColumn(final int width, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1613156581);
        ComposerKt.sourceInformation($composer2, "C(FirstColumn)N(width)188@6659L929:OnePassLoginErrorShowDebugFragment.kt#m400d2");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(width) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1613156581, $dirty, -1, "tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment.FirstColumn (OnePassLoginErrorShowDebugFragment.kt:187)");
            }
            Modifier modifier$iv = BorderKt.border-xT4_qwU$default(Modifier.Companion, Dp.constructor-impl(2), Color.Companion.getBlue-0d7_KjU(), (Shape) null, 4, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv << 6;
            int $changed$iv$iv$iv = ($i$f$Row & 896) | 6;
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
            int i2 = ((6 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 117052731, "C190@6796L9,189@6739L222,195@6974L53,197@7100L9,196@7040L211,202@7264L53,204@7400L9,203@7330L248:OnePassLoginErrorShowDebugFragment.kt#m400d2");
            double $this$dp$iv = width * 0.25d;
            TextKt.Text--4IGK_g("触发一键登录", PaddingKt.padding-qDBjuR0$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv)), Dp.constructor-impl(2), Dp.constructor-impl(2), 0.0f, 0.0f, 12, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 6, 0, 65532);
            double $this$dp$iv2 = width * 0.125d;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv2)), $composer2, 0);
            double $this$dp$iv3 = width * 0.25d;
            TextKt.Text--4IGK_g("获取登录方式等信息", PaddingKt.padding-qDBjuR0$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv3)), 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 6, 0, 65532);
            double $this$dp$iv4 = width * 0.125d;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv4)), $composer2, 0);
            double $this$dp$iv5 = width * 0.25d;
            TextKt.Text--4IGK_g("调用基架SDK确认是否满足一键登录条件", PaddingKt.padding-qDBjuR0$default(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) $this$dp$iv5)), 0.0f, Dp.constructor-impl(2), Dp.constructor-impl(2), Dp.constructor-impl(2), 1, (Object) null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 6, 0, 65532);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.login.OnePassLoginErrorShowDebugFragment$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit FirstColumn$lambda$1;
                    FirstColumn$lambda$1 = OnePassLoginErrorShowDebugFragment.FirstColumn$lambda$1(OnePassLoginErrorShowDebugFragment.this, width, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FirstColumn$lambda$1;
                }
            });
        }
    }
}