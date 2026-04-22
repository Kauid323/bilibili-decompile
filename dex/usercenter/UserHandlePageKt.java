package usercenter;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
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
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.CommonRes;
import bili.resource.profile.ProfileRes;
import bili.resource.profile.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUIKt;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import settings.base.ui.SettingsTopBarKt;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import usercenter.DialogState;
import usercenter.UserHandleState;
import video.biz.offline.base.infra.utils.EntryScannerKt;

/* compiled from: UserHandlePage.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a;\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\r2\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H\u0003¢\u0006\u0002\u0010\u0015\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\n\u001a\u00020\u000bX\u008a\u008e\u0002"}, d2 = {"MIN_TEXT_LENGTH", "", "UserHandlePage", "", "model", "Lusercenter/UserHandleModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lusercenter/UserHandleModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "HandleInputField", "text", "", "onTextChange", "Lkotlin/Function1;", "maxLength", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SaveButton", "isEnabled", "", "onSave", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "usercenter_debug", "state", "Lusercenter/UserHandleState;"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UserHandlePageKt {
    public static final int MIN_TEXT_LENGTH = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleInputField$lambda$1(String str, Function1 function1, int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        HandleInputField(str, function1, i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaveButton$lambda$2(boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        SaveButton(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$3(UserHandleModel userHandleModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UserHandlePage(userHandleModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void UserHandlePage(final UserHandleModel model, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(model, "model");
        Composer $composer2 = $composer.startRestartGroup(1705282731);
        ComposerKt.sourceInformation($composer2, "C(UserHandlePage)N(model,modifier)56@2308L39,57@2377L7,58@2418L16,60@2450L5707,60@2440L5717:UserHandlePage.kt#xobjkw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(model) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if ((i & 2) != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1705282731, $dirty2, -1, "usercenter.UserHandlePage (UserHandlePage.kt:55)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1900799118, "CC(remember):UserHandlePage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new UserHandleViewModel(model);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final UserHandleViewModel viewModel = (UserHandleViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer2, 0, 1);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1538889229, true, new Function2() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserHandlePage$lambda$2;
                    UserHandlePage$lambda$2 = UserHandlePageKt.UserHandlePage$lambda$2(UserHandleViewModel.this, model, router, state$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return UserHandlePage$lambda$2;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserHandlePage$lambda$3;
                    UserHandlePage$lambda$3 = UserHandlePageKt.UserHandlePage$lambda$3(UserHandleModel.this, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UserHandlePage$lambda$3;
                }
            });
        }
    }

    private static final UserHandleState UserHandlePage$lambda$1(State<? extends UserHandleState> state) {
        Object thisObj$iv = state.getValue();
        return (UserHandleState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0145, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x02fb, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0573, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit UserHandlePage$lambda$2(final UserHandleViewModel $viewModel, final UserHandleModel $model, final Router $router, State $state$delegate, Composer $composer, int $changed) {
        String handle;
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C61@2477L28,62@2525L20,64@2582L7,65@2635L7,66@2698L7,74@2943L42,76@3007L24,78@3062L381,78@3041L402,95@3586L6,91@3453L1620:UserHandlePage.kt#xobjkw");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1538889229, $changed, -1, "usercenter.UserHandlePage.<anonymous> (UserHandlePage.kt:61)");
            }
            SystemUiController controller = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            SystemUIKt.setStatusBarByGarb(controller, $composer, 0);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Toaster toaster = (Toaster) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final FocusManager focusManager = (FocusManager) consume2;
            OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
            UserHandleState currentState = UserHandlePage$lambda$1($state$delegate);
            if (currentState instanceof UserHandleState.Immutable) {
                handle = ((UserHandleState.Immutable) currentState).getHandle();
            } else if (!(currentState instanceof UserHandleState.Mutable)) {
                throw new NoWhenBranchMatchedException();
            } else {
                handle = ((UserHandleState.Mutable) currentState).getHandle();
            }
            String handle2 = handle;
            UserHandleState UserHandlePage$lambda$1 = UserHandlePage$lambda$1($state$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1403783427, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(UserHandlePage$lambda$1);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                MutableState mutableStateOf$default = SnapshotStateKt.mutableStateOf$default(handle2, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(mutableStateOf$default);
                it$iv = mutableStateOf$default;
            }
            final MutableState text$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
                $composer.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1403779280, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($viewModel) | $composer.changedInstance(toaster) | $composer.changedInstance(backHandler);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv = (Function2) new UserHandlePageKt$UserHandlePage$1$1$1($viewModel, toaster, backHandler, null);
            $composer.updateRememberedValue(value$iv);
            it$iv2 = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv2, $composer, 6);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1032604935, "C100@3824L814,98@3686L967,124@4745L13,122@4667L151,130@4907L9,131@4956L6,128@4832L231:UserHandlePage.kt#xobjkw");
            SettingsTopBarKt.SettingsTopBar(ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_68(ProfileRes.INSTANCE.getString())), (Modifier) null, false, (Function0) null, ComposableLambdaKt.rememberComposableLambda(72030459, true, new Function2() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit UserHandlePage$lambda$2$4$0;
                    UserHandlePage$lambda$2$4$0 = UserHandlePageKt.UserHandlePage$lambda$2$4$0(focusManager, scope, $viewModel, text$delegate, (Composer) obj, ((Integer) obj2).intValue());
                    return UserHandlePage$lambda$2$4$0;
                }
            }, $composer, 54), $composer, 24576, 14);
            String UserHandlePage$lambda$2$1 = UserHandlePage$lambda$2$1(text$delegate);
            ComposerKt.sourceInformationMarkerStart($composer, -1418750634, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed(text$delegate);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv2 = new Function1() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit UserHandlePage$lambda$2$4$1$0;
                    UserHandlePage$lambda$2$4$1$0 = UserHandlePageKt.UserHandlePage$lambda$2$4$1$0(text$delegate, (String) obj);
                    return UserHandlePage$lambda$2$4$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv3 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            HandleInputField(UserHandlePage$lambda$2$1, (Function1) it$iv3, $model.getMaxLength(), null, $composer, 0, 8);
            TextKt.Text-Nvy7gAk($model.getRuleMessage(), SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            UserHandleState currentState2 = UserHandlePage$lambda$1($state$delegate);
            if (currentState2 instanceof UserHandleState.Mutable) {
                $composer.startReplaceGroup(-565286043);
                ComposerKt.sourceInformation($composer, "");
                DialogState dialog = ((UserHandleState.Mutable) currentState2).getDialogState();
                if (dialog instanceof DialogState.DoubleCheck) {
                    $composer.startReplaceGroup(-565252842);
                    ComposerKt.sourceInformation($composer, "144@5497L199,149@5738L305,141@5325L745");
                    String alias = ((DialogState.DoubleCheck) dialog).getAlias();
                    String confirmMessage = $model.getConfirmMessage();
                    ComposerKt.sourceInformationMarkerStart($composer, -1403701542, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv4 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel);
                    Object it$iv4 = $composer.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda13
                            public final Object invoke() {
                                Unit UserHandlePage$lambda$2$5$0;
                                UserHandlePage$lambda$2$5$0 = UserHandlePageKt.UserHandlePage$lambda$2$5$0(scope, $viewModel);
                                return UserHandlePage$lambda$2$5$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                        it$iv4 = value$iv3;
                    }
                    Function0 function0 = (Function0) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1403693724, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv5 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel);
                    Object it$iv5 = $composer.rememberedValue();
                    if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = new Function1() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda14
                            public final Object invoke(Object obj) {
                                Unit UserHandlePage$lambda$2$6$0;
                                UserHandlePage$lambda$2$6$0 = UserHandlePageKt.UserHandlePage$lambda$2$6$0(scope, $viewModel, (String) obj);
                                return UserHandlePage$lambda$2$6$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv4);
                        it$iv5 = value$iv4;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    DoubleCheckHandleDialogKt.DoubleCheckHandleDialog(alias, confirmMessage, null, function0, (Function1) it$iv5, $composer, 0, 4);
                    $composer.endReplaceGroup();
                } else if (dialog instanceof DialogState.Recommend) {
                    $composer.startReplaceGroup(-564415160);
                    ComposerKt.sourceInformation($composer, "161@6292L199,166@6533L399,159@6168L791");
                    List<String> suggestions = ((DialogState.Recommend) dialog).getSuggestions();
                    ComposerKt.sourceInformationMarkerStart($composer, -1403676102, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv6 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel);
                    Object it$iv6 = $composer.rememberedValue();
                    if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                Unit UserHandlePage$lambda$2$7$0;
                                UserHandlePage$lambda$2$7$0 = UserHandlePageKt.UserHandlePage$lambda$2$7$0(scope, $viewModel);
                                return UserHandlePage$lambda$2$7$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv5);
                        it$iv6 = value$iv5;
                    }
                    Function0 function02 = (Function0) it$iv6;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1403668190, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv7 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel);
                    Object it$iv7 = $composer.rememberedValue();
                    if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function1() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj) {
                                Unit UserHandlePage$lambda$2$8$0;
                                UserHandlePage$lambda$2$8$0 = UserHandlePageKt.UserHandlePage$lambda$2$8$0(scope, $viewModel, (String) obj);
                                return UserHandlePage$lambda$2$8$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv6);
                        it$iv7 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    RecommendHandleDialogKt.RecommendAliasDialog(null, suggestions, function02, (Function1) it$iv7, $composer, 0, 1);
                    $composer.endReplaceGroup();
                } else if (dialog instanceof DialogState.BindPhone) {
                    $composer.startReplaceGroup(-563539224);
                    ComposerKt.sourceInformation($composer, "179@7114L199,184@7355L274,178@7057L599");
                    ComposerKt.sourceInformationMarkerStart($composer, -1403649798, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv8 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel);
                    Object it$iv8 = $composer.rememberedValue();
                    if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit UserHandlePage$lambda$2$9$0;
                                UserHandlePage$lambda$2$9$0 = UserHandlePageKt.UserHandlePage$lambda$2$9$0(scope, $viewModel);
                                return UserHandlePage$lambda$2$9$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv7);
                        it$iv8 = value$iv7;
                    }
                    Function0 function03 = (Function0) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerStart($composer, -1403642011, "CC(remember):UserHandlePage.kt#9igjgp");
                    boolean invalid$iv9 = $composer.changedInstance(scope) | $composer.changedInstance($viewModel) | $composer.changedInstance($router) | $composer.changed($model);
                    Object it$iv9 = $composer.rememberedValue();
                    if (invalid$iv9) {
                    }
                    Object value$iv8 = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit UserHandlePage$lambda$2$10$0;
                            UserHandlePage$lambda$2$10$0 = UserHandlePageKt.UserHandlePage$lambda$2$10$0(scope, $router, $model, $viewModel);
                            return UserHandlePage$lambda$2$10$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv8);
                    it$iv9 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    BindPhoneDialogKt.BindPhoneDialog(null, function03, (Function0) it$iv9, $composer, 0, 1);
                    $composer.endReplaceGroup();
                } else if (dialog instanceof DialogState.Loading) {
                    $composer.startReplaceGroup(-562864075);
                    ComposerKt.sourceInformation($composer, "194@7752L138");
                    LoadingDialogKt.LoadingDialog(CommonRes.INSTANCE.getString(bili.resource.common.String0_commonMainKt.getCommon_global_string_3(CommonRes.INSTANCE.getString())), null, $composer, 0, 2);
                    $composer.endReplaceGroup();
                } else if (!Intrinsics.areEqual(dialog, DialogState.None.INSTANCE)) {
                    $composer.startReplaceGroup(-1403708355);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                } else {
                    $composer.startReplaceGroup(-562641929);
                    $composer.endReplaceGroup();
                }
                $composer.endReplaceGroup();
            } else if (!(currentState2 instanceof UserHandleState.Immutable)) {
                $composer.startReplaceGroup(-1403711146);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            } else {
                $composer.startReplaceGroup(-562509094);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String UserHandlePage$lambda$2$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$4$0(final FocusManager $focusManager, final CoroutineScope $scope, final UserHandleViewModel $viewModel, final MutableState $text$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C101@3901L719,101@3846L774:UserHandlePage.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(72030459, $changed, -1, "usercenter.UserHandlePage.<anonymous>.<anonymous>.<anonymous> (UserHandlePage.kt:101)");
            }
            boolean z = UserHandlePage$lambda$2$1($text$delegate).length() >= 2;
            ComposerKt.sourceInformationMarkerStart($composer, 501797546, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($focusManager) | $composer.changedInstance($scope) | $composer.changedInstance($viewModel) | $composer.changed($text$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit UserHandlePage$lambda$2$4$0$0$0;
                        UserHandlePage$lambda$2$4$0$0$0 = UserHandlePageKt.UserHandlePage$lambda$2$4$0$0$0($focusManager, $scope, $viewModel, $text$delegate);
                        return UserHandlePage$lambda$2$4$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SaveButton(z, (Function0) it$iv, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$4$0$0$0(FocusManager $focusManager, CoroutineScope $scope, UserHandleViewModel $viewModel, MutableState $text$delegate) {
        FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$2$1$1$1$1($viewModel, $text$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$4$1$0(MutableState $text$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $text$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$5$0(CoroutineScope $scope, UserHandleViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$3$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$6$0(CoroutineScope $scope, UserHandleViewModel $viewModel, String finalAlias) {
        Intrinsics.checkNotNullParameter(finalAlias, "finalAlias");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$4$1$1($viewModel, finalAlias, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$7$0(CoroutineScope $scope, UserHandleViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$5$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$8$0(CoroutineScope $scope, UserHandleViewModel $viewModel, String selectedAlias) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$6$1$1($viewModel, selectedAlias, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$9$0(CoroutineScope $scope, UserHandleViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$7$1$1($viewModel, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UserHandlePage$lambda$2$10$0(CoroutineScope $scope, Router $router, UserHandleModel $model, UserHandleViewModel $viewModel) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new UserHandlePageKt$UserHandlePage$1$8$1$1($viewModel, null), 3, (Object) null);
        $router.launch(Uri.Companion.parse($model.getBindTelUrl()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ec, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x03a9, code lost:
        if (r14 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void HandleInputField(final String text, final Function1<? super String, Unit> function1, final int maxLength, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1025023344);
        ComposerKt.sourceInformation($composer2, "C(HandleInputField)N(text,onTextChange,maxLength,modifier)223@8434L6,219@8320L1746:UserHandlePage.kt#xobjkw");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(maxLength) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1025023344, $dirty2, -1, "usercenter.HandleInputField (UserHandlePage.kt:218)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(46)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier3 = modifier4;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$HandleInputField_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -667121366, "C229@8621L116,239@8963L6,241@9074L6,227@8551L941,256@9578L9,257@9623L6,254@9501L213,261@9764L27,266@9947L20,267@9998L6,260@9723L337:UserHandlePage.kt#xobjkw");
            ComposerKt.sourceInformationMarkerStart($composer2, 1225406792, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 896) == 256) | (($dirty2 & 112) == 32);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit HandleInputField$lambda$0$0$0;
                    HandleInputField$lambda$0$0$0 = UserHandlePageKt.HandleInputField$lambda$0$0$0(maxLength, function1, (String) obj);
                    return HandleInputField$lambda$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv$iv = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$HandleInputField_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(12), 1, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
            BasicTextFieldKt.BasicTextField(text, (Function1) it$iv, modifier$iv$iv, false, false, new TextStyle(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, new SolidColor(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (DefaultConstructorMarker) null), ComposableSingletons$UserHandlePageKt.INSTANCE.getLambda$2051181585$usercenter_debug(), $composer2, ($dirty2 & 14) | 100663296, 196608, 16088);
            TextKt.Text-Nvy7gAk(text.length() + EntryScannerKt.PATH_SEPARATOR + maxLength, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(4), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 10, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 0, 131064);
            Painter xmark_close_circle_fill_500 = BiliIconfont.INSTANCE.getXmark_close_circle_fill_500($composer2, 6);
            Modifier modifier5 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null), Dp.constructor-impl(16));
            ComposerKt.sourceInformationMarkerStart($composer2, 1225449128, "CC(remember):UserHandlePage.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 112) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2) {
                $dirty = $dirty2;
            } else {
                $dirty = $dirty2;
            }
            Object value$iv2 = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit HandleInputField$lambda$0$1$0;
                    HandleInputField$lambda$0$1$0 = UserHandlePageKt.HandleInputField$lambda$0$1$0(function1);
                    return HandleInputField$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(xmark_close_circle_fill_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit HandleInputField$lambda$1;
                    HandleInputField$lambda$1 = UserHandlePageKt.HandleInputField$lambda$1(text, function1, maxLength, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HandleInputField$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleInputField$lambda$0$0$0(int $maxLength, Function1 $onTextChange, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.length() <= $maxLength) {
            $onTextChange.invoke(it);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HandleInputField$lambda$0$1$0(Function1 $onTextChange) {
        $onTextChange.invoke("");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v5 */
    private static final void SaveButton(boolean isEnabled, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final boolean isEnabled2;
        final Function0 onSave;
        Composer $composer2;
        boolean isEnabled3;
        Function0 onSave2;
        long j;
        Composer $composer3 = $composer.startRestartGroup(1479119783);
        ComposerKt.sourceInformation($composer3, "C(SaveButton)N(isEnabled,onSave)276@10163L2,280@10285L9,291@10652L39,278@10175L538:UserHandlePage.kt#xobjkw");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            isEnabled2 = isEnabled;
        } else if (($changed & 6) == 0) {
            isEnabled2 = isEnabled;
            $dirty |= $composer3.changed(isEnabled2) ? 4 : 2;
        } else {
            isEnabled2 = isEnabled;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            onSave = function0;
        } else if (($changed & 48) == 0) {
            onSave = function0;
            $dirty |= $composer3.changedInstance(onSave) ? 32 : 16;
        } else {
            onSave = function0;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                isEnabled3 = false;
            } else {
                isEnabled3 = isEnabled2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -200061175, "CC(remember):UserHandlePage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda9
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onSave3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSave2 = onSave3;
            } else {
                onSave2 = onSave;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1479119783, $dirty, -1, "usercenter.SaveButton (UserHandlePage.kt:277)");
            }
            String string = CommonRes.INSTANCE.getString(bili.resource.common.String0_commonMainKt.getCommon_global_string_37(CommonRes.INSTANCE.getString()));
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16();
            if (isEnabled3) {
                $composer3.startReplaceGroup(-200054031);
                ComposerKt.sourceInformation($composer3, "283@10374L11");
                long j2 = BiliTheme.INSTANCE.getThemeColors($composer3, BiliTheme.$stable).getActionIcon-0d7_KjU();
                $composer3.endReplaceGroup();
                j = j2;
            } else {
                $composer3.startReplaceGroup(-200052372);
                ComposerKt.sourceInformation($composer3, "284@10431L6");
                long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
                $composer3.endReplaceGroup();
                j = j3;
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -200045490, "CC(remember):UserHandlePage.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(string, ClickableKt.clickable-O2vRcR0$default(modifier, (MutableInteractionSource) it$iv2, (Indication) null, isEnabled3, (String) null, (Role) null, onSave2, 24, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer2, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isEnabled2 = isEnabled3;
            onSave = onSave2;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: usercenter.UserHandlePageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaveButton$lambda$2;
                    SaveButton$lambda$2 = UserHandlePageKt.SaveButton$lambda$2(isEnabled2, onSave, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SaveButton$lambda$2;
                }
            });
        }
    }
}