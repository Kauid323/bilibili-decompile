package kntr.app.game.gamebind.ui.authorize;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.LinkInteractionListener;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLinkStyles;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.bilibili.biligame.kntr.common.util.StringExtKt;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Map;
import kntr.app.game.base.ui.ExposerKt;
import kntr.app.game.base.ui.font.GameFontWeight_androidKt;
import kntr.app.game.base.ui.indication.NoPressIndication;
import kntr.app.game.base.ui.widget.BiliGameCustomBottomSheetKt;
import kntr.app.game.base.ui.widget.BiligameCheckboxKt;
import kntr.app.game.base.ui.widget.BiligameImageKt;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.game.gamebind.AuthorizeAction;
import kntr.app.game.gamebind.GameAuthorizeViewModel;
import kntr.app.game.gamebind.bean.AuthorizeInfo;
import kntr.app.game.gamebind.bean.AuthorizeParams;
import kntr.app.game.gamebind.ui.report.ReporterKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: GameAuthorizeDialog.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0096\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010\u0019\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u001aX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u001aX\u008a\u008e\u0002"}, d2 = {"GameAuthorizeDialog", RoomRecommendViewModel.EMPTY_CURSOR, "authorizeParams", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "onLinkClick", "Lkotlin/Function1;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlin/ParameterName;", "name", "link", "onClose", "Lkotlin/Function0;", "onTencentGameBindClick", "Lkotlin/Function2;", "blkLink", "gameName", "onNoRoleInfo", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/game/gamebind/bean/AuthorizeParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "game-bind-ui_debug", "pageState", "Lkntr/app/game/base/viewmodel/PageState;", "action", "Lkntr/app/game/gamebind/AuthorizeAction;", "backFromTencentBind", RoomRecommendViewModel.EMPTY_CURSOR, "agreementChecked", "authorizeAllChecked"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GameAuthorizeDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$11(AuthorizeParams authorizeParams, Function1 function1, Function0 function0, Function2 function2, Function0 function02, Modifier modifier, int i, int i2, Composer composer, int i3) {
        GameAuthorizeDialog(authorizeParams, function1, function0, function2, function02, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void GameAuthorizeDialog(final AuthorizeParams authorizeParams, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function2<? super String, ? super String, Unit> function2, final Function0<Unit> function02, Modifier modifier, Composer $composer, final int $changed, final int i) {
        int $dirty;
        Modifier modifier2;
        Unit unit;
        MutableState backFromTencentBind$delegate;
        int i2;
        Intrinsics.checkNotNullParameter(authorizeParams, "authorizeParams");
        Intrinsics.checkNotNullParameter(function1, "onLinkClick");
        Intrinsics.checkNotNullParameter(function0, "onClose");
        Intrinsics.checkNotNullParameter(function2, "onTencentGameBindClick");
        Intrinsics.checkNotNullParameter(function02, "onNoRoleInfo");
        Composer $composer2 = $composer.startRestartGroup(-464870837);
        ComposerKt.sourceInformation($composer2, "C(GameAuthorizeDialog)N(authorizeParams,onLinkClick,onClose,onTencentGameBindClick,onNoRoleInfo,modifier)76@3271L43,76@3261L53,77@3331L24,79@3394L203,89@3634L39,90@3698L93,96@3833L7,97@3872L34,98@3932L515,98@3911L536,112@4480L7:GameAuthorizeDialog.kt#82z3yk");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(authorizeParams) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer2.changedInstance(function02) ? 16384 : 8192;
        }
        int $dirty3 = $dirty2;
        boolean z = false;
        if ($composer2.shouldExecute(($dirty3 & 9363) != 9362, $dirty3 & 1)) {
            modifier2 = (i & 32) != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-464870837, $dirty3, -1, "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialog (GameAuthorizeDialog.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -64265898, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(authorizeParams);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj) {
                        GameAuthorizeViewModel GameAuthorizeDialog$lambda$0$0;
                        GameAuthorizeDialog$lambda$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$0$0(AuthorizeParams.this, (CreationExtras) obj);
                        return GameAuthorizeDialog$lambda$0$0;
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
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(GameAuthorizeViewModel.class);
            InitializerViewModelFactoryBuilder $this$viewModel_u24lambda_u243$iv = new InitializerViewModelFactoryBuilder();
            $this$viewModel_u24lambda_u243$iv.addInitializer(Reflection.getOrCreateKotlinClass(GameAuthorizeViewModel.class), initializer$iv);
            ViewModel viewModel = ViewModelKt.viewModel(orCreateKotlinClass, current, (String) null, $this$viewModel_u24lambda_u243$iv.build(), current instanceof HasDefaultViewModelProviderFactory ? current.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, $composer2, ((0 << 3) & 112) | ((0 << 3) & 896), 0);
            $composer2.endReplaceableGroup();
            final GameAuthorizeViewModel viewModel2 = (GameAuthorizeViewModel) viewModel;
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $dirty = $dirty3;
            State pageState$delegate = SnapshotStateKt.collectAsState(viewModel2.getState(), (authorizeParams.getAuthStatus() == 0 || authorizeParams.getOnlyAuth()) ? PageState.Loading.INSTANCE : PageState.Empty.INSTANCE, (CoroutineContext) null, $composer2, 0, 2);
            State action$delegate = SnapshotStateKt.collectAsState(viewModel2.getAction(), AuthorizeAction.Nothing.INSTANCE, (CoroutineContext) null, $composer2, 0, 2);
            ComposerKt.sourceInformationMarkerStart($composer2, -64252184, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(scope) | $composer2.changedInstance(viewModel2);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Job GameAuthorizeDialog$lambda$3$0;
                        GameAuthorizeDialog$lambda$3$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$3$0(scope, viewModel2);
                        return GameAuthorizeDialog$lambda$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            final Function0 dismissDialog = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CompositionLocal this_$iv = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LifecycleOwner lifecycle = (LifecycleOwner) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, -64246675, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableState backFromTencentBind$delegate2 = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -64244274, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(authorizeParams) | $composer2.changedInstance(viewModel2) | $composer2.changedInstance(lifecycle);
            Object value$iv4 = $composer2.rememberedValue();
            if (invalid$iv3 || value$iv4 == Composer.Companion.getEmpty()) {
                unit = unit2;
                backFromTencentBind$delegate = backFromTencentBind$delegate2;
                i2 = 2023513938;
                value$iv4 = new GameAuthorizeDialogKt$GameAuthorizeDialog$1$1(authorizeParams, viewModel2, lifecycle, backFromTencentBind$delegate2, null);
                $composer2.updateRememberedValue(value$iv4);
            } else {
                unit = unit2;
                backFromTencentBind$delegate = backFromTencentBind$delegate2;
                i2 = 2023513938;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv4, $composer2, 6);
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer2, i2, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Toaster toaster = (Toaster) consume2;
            AuthorizeAction GameAuthorizeDialog$lambda$2 = GameAuthorizeDialog$lambda$2(action$delegate);
            if (GameAuthorizeDialog$lambda$2 instanceof AuthorizeAction.Close) {
                AuthorizeAction GameAuthorizeDialog$lambda$22 = GameAuthorizeDialog$lambda$2(action$delegate);
                Intrinsics.checkNotNull(GameAuthorizeDialog$lambda$22, "null cannot be cast to non-null type kntr.app.game.gamebind.AuthorizeAction.Close");
                String toast = ((AuthorizeAction.Close) GameAuthorizeDialog$lambda$22).getToast();
                String str = toast;
                if (!((str == null || StringsKt.isBlank(str)) ? true : true)) {
                    Toaster.-CC.showToast$default(toaster, toast, (ToastDuration) null, 2, (Object) null);
                }
                function0.invoke();
            } else if (GameAuthorizeDialog$lambda$2 instanceof AuthorizeAction.GoBindTencent) {
                GameAuthorizeDialog$lambda$6(backFromTencentBind$delegate, true);
                AuthorizeAction GameAuthorizeDialog$lambda$23 = GameAuthorizeDialog$lambda$2(action$delegate);
                Intrinsics.checkNotNull(GameAuthorizeDialog$lambda$23, "null cannot be cast to non-null type kntr.app.game.gamebind.AuthorizeAction.GoBindTencent");
                function2.invoke(((AuthorizeAction.GoBindTencent) GameAuthorizeDialog$lambda$23).getTokenLink(), authorizeParams.getGameName());
            } else if (GameAuthorizeDialog$lambda$2 instanceof AuthorizeAction.NoRoleInfo) {
                function02.invoke();
            }
            PageState GameAuthorizeDialog$lambda$1 = GameAuthorizeDialog$lambda$1(pageState$delegate);
            if (GameAuthorizeDialog$lambda$1 instanceof PageState.Error) {
                $composer2.startReplaceGroup(-1990401622);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                PageState GameAuthorizeDialog$lambda$12 = GameAuthorizeDialog$lambda$1(pageState$delegate);
                Intrinsics.checkNotNull(GameAuthorizeDialog$lambda$12, "null cannot be cast to non-null type kntr.app.game.base.viewmodel.PageState.Error");
                PageState.Error error = (PageState.Error) GameAuthorizeDialog$lambda$12;
                if (error.getCode() == -8006) {
                    $composer2.startReplaceGroup(-1990316496);
                    ComposerKt.sourceInformation($composer2, "138@5250L81");
                    ComposerKt.sourceInformationMarkerStart($composer2, -64202532, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                    boolean invalid$iv4 = $composer2.changedInstance(viewModel2);
                    Object it$iv4 = $composer2.rememberedValue();
                    if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = (Function2) new GameAuthorizeDialogKt$GameAuthorizeDialog$2$1(viewModel2, null);
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, (Function2) it$iv4, 3, (Object) null);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-1990178019);
                    $composer2.endReplaceGroup();
                    Toaster.-CC.showToast$default(toaster, error.getMessage(), (ToastDuration) null, 2, (Object) null);
                    function0.invoke();
                    Unit unit3 = Unit.INSTANCE;
                }
                $composer2.endReplaceGroup();
            } else if (GameAuthorizeDialog$lambda$1 instanceof PageState.Content) {
                $composer2.startReplaceGroup(-1989452743);
                ComposerKt.sourceInformation($composer2, "151@5644L55,154@5758L6,155@5785L18795,150@5593L18987");
                PageState GameAuthorizeDialog$lambda$13 = GameAuthorizeDialog$lambda$1(pageState$delegate);
                Intrinsics.checkNotNull(GameAuthorizeDialog$lambda$13, "null cannot be cast to non-null type kntr.app.game.base.viewmodel.PageState.Content<*>");
                Object data = ((PageState.Content) GameAuthorizeDialog$lambda$13).getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kntr.app.game.gamebind.bean.AuthorizeInfo");
                final AuthorizeInfo authorizeInfo = (AuthorizeInfo) data;
                ComposerKt.sourceInformationMarkerStart($composer2, -64189950, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer2.changed(dismissDialog);
                Object it$iv5 = $composer2.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit GameAuthorizeDialog$lambda$9$0;
                            GameAuthorizeDialog$lambda$9$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$9$0(dismissDialog);
                            return GameAuthorizeDialog$lambda$9$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BiliGameCustomBottomSheetKt.GameCustomBottomSheet((Function0) it$iv5, BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), ComposableLambdaKt.rememberComposableLambda(1147318311, true, new Function2() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj, Object obj2) {
                        Unit GameAuthorizeDialog$lambda$10;
                        GameAuthorizeDialog$lambda$10 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10(AuthorizeParams.this, dismissDialog, scope, viewModel2, authorizeInfo, function1, toaster, (Composer) obj, ((Integer) obj2).intValue());
                        return GameAuthorizeDialog$lambda$10;
                    }
                }, $composer2, 54), $composer2, 384, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1971077524);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $dirty = $dirty3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameAuthorizeDialog$lambda$11;
                    GameAuthorizeDialog$lambda$11 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$11(AuthorizeParams.this, function1, function0, function2, function02, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return GameAuthorizeDialog$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GameAuthorizeViewModel GameAuthorizeDialog$lambda$0$0(AuthorizeParams $authorizeParams, CreationExtras $this$viewModel) {
        Intrinsics.checkNotNullParameter($this$viewModel, "$this$viewModel");
        return new GameAuthorizeViewModel($authorizeParams);
    }

    private static final PageState GameAuthorizeDialog$lambda$1(State<? extends PageState> state) {
        Object thisObj$iv = state.getValue();
        return (PageState) thisObj$iv;
    }

    private static final AuthorizeAction GameAuthorizeDialog$lambda$2(State<? extends AuthorizeAction> state) {
        Object thisObj$iv = state.getValue();
        return (AuthorizeAction) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job GameAuthorizeDialog$lambda$3$0(CoroutineScope $scope, GameAuthorizeViewModel $viewModel) {
        return BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new GameAuthorizeDialogKt$GameAuthorizeDialog$dismissDialog$1$1$1($viewModel, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GameAuthorizeDialog$lambda$5(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void GameAuthorizeDialog$lambda$6(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$9$0(Function0 $dismissDialog) {
        $dismissDialog.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10(final AuthorizeParams $authorizeParams, final Function0 $dismissDialog, final CoroutineScope $scope, final GameAuthorizeViewModel $viewModel, final AuthorizeInfo $authorizeInfo, final Function1 $onLinkClick, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C156@5874L18692,156@5803L18763:GameAuthorizeDialog.kt#82z3yk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1147318311, $changed, -1, "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialog.<anonymous> (GameAuthorizeDialog.kt:156)");
            }
            CompositionLocalKt.CompositionLocalProvider(IndicationKt.getLocalIndication().provides(new NoPressIndication()), ComposableLambdaKt.rememberComposableLambda(-2110086297, true, new Function2() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameAuthorizeDialog$lambda$10$0;
                    GameAuthorizeDialog$lambda$10$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0(AuthorizeParams.this, $dismissDialog, $scope, $viewModel, $authorizeInfo, $onLinkClick, $toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return GameAuthorizeDialog$lambda$10$0;
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0(final AuthorizeParams $authorizeParams, final Function0 $dismissDialog, final CoroutineScope $scope, final GameAuthorizeViewModel $viewModel, final AuthorizeInfo $authorizeInfo, final Function1 $onLinkClick, final Toaster $toaster, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C157@5923L18625,157@5896L18652:GameAuthorizeDialog.kt#82z3yk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2110086297, $changed, -1, "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialog.<anonymous>.<anonymous> (GameAuthorizeDialog.kt:157)");
            }
            ExposerKt.BiligameExposureComposable(ComposableLambdaKt.rememberComposableLambda(1243548016, true, new Function2() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit GameAuthorizeDialog$lambda$10$0$0;
                    GameAuthorizeDialog$lambda$10$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0(AuthorizeParams.this, $dismissDialog, $scope, $viewModel, $authorizeInfo, $onLinkClick, $toaster, (Composer) obj, ((Integer) obj2).intValue());
                    return GameAuthorizeDialog$lambda$10$0$0;
                }
            }, $composer, 54), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x026d, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x02ad, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:175:0x110a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x1116  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x111c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x122d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x1245  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x1373  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x137f  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x1385  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x140f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x1421  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x14b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0(final AuthorizeParams $authorizeParams, final Function0 $dismissDialog, final CoroutineScope $scope, final GameAuthorizeViewModel $viewModel, final AuthorizeInfo $authorizeInfo, final Function1 $onLinkClick, final Toaster $toaster, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv$iv;
        Modifier materialized$iv$iv;
        String str;
        Function0 onDisagreeClick;
        MutableState agreementChecked$delegate;
        MutableState authorizeAllChecked$delegate;
        Function0 onAgreeClick;
        final AuthorizeInfo authorizeInfo;
        String str2;
        String str3;
        String str4;
        String str5;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        final MutableState agreementChecked$delegate2;
        Composer $composer3;
        final Function1 function1;
        Function0 factory$iv$iv$iv3;
        Composer $composer$iv;
        final MutableState authorizeAllChecked$delegate2;
        Function0 factory$iv$iv$iv4;
        long j2;
        boolean invalid$iv;
        Object value$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv$iv$iv3;
        int i;
        Composer $composer$iv2;
        String str6;
        Composer $composer4;
        final MutableState agreementChecked$delegate3;
        Composer $composer$iv3;
        Function0 factory$iv$iv$iv5;
        long j3;
        Function0 factory$iv$iv$iv6;
        String str7;
        String str8;
        Composer $composer5;
        Function0 factory$iv$iv$iv7;
        final MutableState authorizeAllChecked$delegate3;
        ComposerKt.sourceInformation($composer, "C160@6066L6,160@6129L109,160@6106L132,158@5949L18577:GameAuthorizeDialog.kt#82z3yk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1243548016, $changed, -1, "kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialog.<anonymous>.<anonymous>.<anonymous> (GameAuthorizeDialog.kt:158)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1048741789, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance($authorizeParams);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit GameAuthorizeDialog$lambda$10$0$0$0$0;
                        GameAuthorizeDialog$lambda$10$0$0$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$0$0(AuthorizeParams.this);
                        return GameAuthorizeDialog$lambda$10$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ExposerKt.reportOnExposure(modifier, unit, null, null, null, (Function0) it$iv, $composer, 48, 14);
            Alignment.Horizontal horizontalAlignment$iv = $authorizeParams.getBindMethodType() == 2 ? Alignment.Companion.getCenterHorizontally() : Alignment.Companion.getStart();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -531033275, "C172@6728L120,175@6904L120,178@7075L79,182@7203L370,393@20570L3930:GameAuthorizeDialog.kt#82z3yk");
            ComposerKt.sourceInformationMarkerStart($composer, -294241678, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            Object value$iv3 = $composer.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                $composer$iv$iv$iv = $composer;
                value$iv3 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf($authorizeInfo.getDefaultCheck() == 1), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv3);
            } else {
                $composer$iv$iv$iv = $composer;
            }
            final MutableState agreementChecked$delegate4 = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -294236046, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                materialized$iv$iv = materialized$iv$iv2;
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf($authorizeInfo.getDefaultCheck() == 1), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
            } else {
                materialized$iv$iv = materialized$iv$iv2;
            }
            final MutableState authorizeAllChecked$delegate4 = (MutableState) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -294230615, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($dismissDialog);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda16
                public final Object invoke() {
                    Job GameAuthorizeDialog$lambda$10$0$0$1$6$0;
                    GameAuthorizeDialog$lambda$10$0$0$1$6$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$6$0($dismissDialog);
                    return GameAuthorizeDialog$lambda$10$0$0$1$6$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv3 = value$iv5;
            Function0 onDisagreeClick2 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -294226228, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
            boolean invalid$iv4 = $composer.changedInstance($scope) | $composer.changedInstance($viewModel) | $composer.changedInstance($authorizeInfo);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv6 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda17
                public final Object invoke() {
                    Unit GameAuthorizeDialog$lambda$10$0$0$1$7$0;
                    GameAuthorizeDialog$lambda$10$0$0$1$7$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$7$0($scope, $viewModel, $authorizeInfo, authorizeAllChecked$delegate4);
                    return GameAuthorizeDialog$lambda$10$0$0$1$7$0;
                }
            };
            $composer.updateRememberedValue(value$iv6);
            it$iv4 = value$iv6;
            Function0 onAgreeClick2 = (Function0) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            if ($authorizeParams.getBindMethodType() == 1) {
                $composer.startReplaceGroup(-530426792);
                ComposerKt.sourceInformation($composer, "194@7833L9,195@7902L6,192@7693L334,201@8185L9,203@8317L6,199@8061L381,209@8602L9,210@8671L6,207@8476L319,214@8829L3151");
                String dialogTitle = $authorizeInfo.getDialogTitle();
                if (dialogTitle == null) {
                    dialogTitle = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                TextKt.Text-Nvy7gAk(dialogTitle, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 48, 0, 131064);
                TextKt.Text-Nvy7gAk($authorizeInfo.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15(), $composer, 48, 0, 131000);
                TextKt.Text-Nvy7gAk($authorizeInfo.getContent(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 48, 0, 131064);
                onAgreeClick = onAgreeClick2;
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                onDisagreeClick = onDisagreeClick2;
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv9;
                    $composer.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv9;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                String str9 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i5 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 516869605, "C219@9133L109,217@8999L375,226@9523L6,228@9636L1940,257@11739L9,258@11812L6,255@11613L333:GameAuthorizeDialog.kt#82z3yk");
                boolean GameAuthorizeDialog$lambda$10$0$0$1$1 = GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate4);
                ComposerKt.sourceInformationMarkerStart($composer, 1125053320, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                Object value$iv7 = $composer.rememberedValue();
                if (value$iv7 == Composer.Companion.getEmpty()) {
                    value$iv7 = new Function1() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit GameAuthorizeDialog$lambda$10$0$0$1$8$0$0;
                            GameAuthorizeDialog$lambda$10$0$0$1$8$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$8$0$0(agreementChecked$delegate4, ((Boolean) obj).booleanValue());
                            return GameAuthorizeDialog$lambda$10$0$0$1$8$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                BiligameCheckboxKt.m1113BiligameCheckboxb7W0Lw(GameAuthorizeDialog$lambda$10$0$0$1$1, (Function1) value$iv7, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(14)), 0.0f, false, null, null, $composer, 432, 120);
                String agreementText = $authorizeInfo.getAgreementTitle();
                long linkColor = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_link-0d7_KjU();
                ComposerKt.sourceInformationMarkerStart($composer, 1125071247, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                boolean invalid$iv5 = $composer.changed(agreementText);
                Object it$iv5 = $composer.rememberedValue();
                if (!invalid$iv5 && it$iv5 != Composer.Companion.getEmpty()) {
                    agreementChecked$delegate = agreementChecked$delegate4;
                    AnnotatedString annotatedText = (AnnotatedString) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TextKt.Text-Z58ophY(annotatedText, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 262136);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    String authorizeTitle = $authorizeInfo.getBatchAuthorizeTitle();
                    str7 = authorizeTitle;
                    if ((str7 != null || str7.length() == 0) && $authorizeInfo.getCanBatchAuth()) {
                        $composer5 = $composer;
                        $composer5.startReplaceGroup(-526095534);
                        ComposerKt.sourceInformation($composer5, "264@12205L2190");
                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
                        str8 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        ComposerKt.sourceInformationMarkerStart($composer5, 844473419, str8);
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv3 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                        Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str9);
                        if (!($composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer5.startReusableNode();
                        if ($composer5.getInserting()) {
                            factory$iv$iv$iv7 = factory$iv$iv$iv10;
                            $composer5.createNode(factory$iv$iv$iv7);
                        } else {
                            factory$iv$iv$iv7 = factory$iv$iv$iv10;
                            $composer5.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                        str9 = str9;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope2 = RowScopeInstance.INSTANCE;
                        int i7 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -1991927600, "C269@12531L120,267@12386L405,275@12864L6,277@12983L978,294@14138L9,295@14215L6,292@14002L355:GameAuthorizeDialog.kt#82z3yk");
                        boolean GameAuthorizeDialog$lambda$10$0$0$1$4 = GameAuthorizeDialog$lambda$10$0$0$1$4(authorizeAllChecked$delegate4);
                        ComposerKt.sourceInformationMarkerStart($composer5, 74294392, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                        Object value$iv8 = $composer5.rememberedValue();
                        if (value$iv8 == Composer.Companion.getEmpty()) {
                            authorizeAllChecked$delegate3 = authorizeAllChecked$delegate4;
                            value$iv8 = new Function1() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda2
                                public final Object invoke(Object obj) {
                                    Unit GameAuthorizeDialog$lambda$10$0$0$1$9$0$0;
                                    GameAuthorizeDialog$lambda$10$0$0$1$9$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$9$0$0(authorizeAllChecked$delegate3, ((Boolean) obj).booleanValue());
                                    return GameAuthorizeDialog$lambda$10$0$0$1$9$0$0;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv8);
                        } else {
                            authorizeAllChecked$delegate3 = authorizeAllChecked$delegate4;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        BiligameCheckboxKt.m1113BiligameCheckboxb7W0Lw(GameAuthorizeDialog$lambda$10$0$0$1$4, (Function1) value$iv8, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(14)), 0.0f, false, null, null, $composer5, 432, 120);
                        long annotatedColor = BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU();
                        ComposerKt.sourceInformationMarkerStart($composer5, 74309714, "CC(remember):GameAuthorizeDialog.kt#9igjgp");
                        boolean invalid$iv6 = $composer5.changed(authorizeTitle);
                        Object it$iv6 = $composer5.rememberedValue();
                        if (!invalid$iv6 && it$iv6 != Composer.Companion.getEmpty()) {
                            str = "CC(remember):GameAuthorizeDialog.kt#9igjgp";
                            authorizeAllChecked$delegate = authorizeAllChecked$delegate3;
                            AnnotatedString annotatedString = (AnnotatedString) it$iv6;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            TextKt.Text-Z58ophY(annotatedString, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), $composer5, 48, 0, 262136);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            $composer5.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                        }
                        AnnotatedString.Builder $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u249_u241_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                        $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u249_u241_u240.append(authorizeTitle);
                        authorizeAllChecked$delegate = authorizeAllChecked$delegate3;
                        str = "CC(remember):GameAuthorizeDialog.kt#9igjgp";
                        if (StringsKt.startsWith$default(authorizeTitle, "批量授权", false, 2, (Object) null)) {
                            $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u249_u241_u240.addStyle(new SpanStyle(annotatedColor, 0L, GameFontWeight_androidKt.getGameFontBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), 0, 4);
                        }
                        Object value$iv9 = $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u249_u241_u240.toAnnotatedString();
                        $composer5.updateRememberedValue(value$iv9);
                        it$iv6 = value$iv9;
                        AnnotatedString annotatedString2 = (AnnotatedString) it$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        TextKt.Text-Z58ophY(annotatedString2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT12(), $composer5, 48, 0, 262136);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                    } else {
                        str = "CC(remember):GameAuthorizeDialog.kt#9igjgp";
                        authorizeAllChecked$delegate = authorizeAllChecked$delegate4;
                        str8 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        $composer5 = $composer;
                        $composer5.startReplaceGroup(-538236312);
                    }
                    $composer5.endReplaceGroup();
                    $composer5.endReplaceGroup();
                    authorizeInfo = $authorizeInfo;
                    str2 = "C101@5233L9:Row.kt#2w3rfo";
                    $composer2 = $composer5;
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str4 = str9;
                    str5 = str8;
                }
                int start = StringsKt.indexOf$default(agreementText, "《", 0, false, 6, (Object) null);
                int end = StringsKt.indexOf$default(agreementText, "》", 0, false, 6, (Object) null);
                agreementChecked$delegate = agreementChecked$delegate4;
                AnnotatedString.Builder $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u248_u241_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u248_u241_u240.append(agreementText);
                if (start >= 0 && end >= 0) {
                    $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u248_u241_u240.addLink(new LinkAnnotation.Clickable("AGREEMENT_LINK", new TextLinkStyles(new SpanStyle(linkColor, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), (SpanStyle) null, (SpanStyle) null, (SpanStyle) null, 14, (DefaultConstructorMarker) null), new LinkInteractionListener() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda1
                        public final void onClick(LinkAnnotation linkAnnotation) {
                            GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$8$1$0$0($onLinkClick, $authorizeInfo, linkAnnotation);
                        }
                    }), start, end + 1);
                }
                Object value$iv10 = $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u248_u241_u240.toAnnotatedString();
                $composer.updateRememberedValue(value$iv10);
                it$iv5 = value$iv10;
                AnnotatedString annotatedText2 = (AnnotatedString) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.Text-Z58ophY(annotatedText2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 262136);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                String authorizeTitle2 = $authorizeInfo.getBatchAuthorizeTitle();
                str7 = authorizeTitle2;
                if (str7 != null || str7.length() == 0) {
                }
                str = "CC(remember):GameAuthorizeDialog.kt#9igjgp";
                authorizeAllChecked$delegate = authorizeAllChecked$delegate4;
                str8 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                $composer5 = $composer;
                $composer5.startReplaceGroup(-538236312);
                $composer5.endReplaceGroup();
                $composer5.endReplaceGroup();
                authorizeInfo = $authorizeInfo;
                str2 = "C101@5233L9:Row.kt#2w3rfo";
                $composer2 = $composer5;
                str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str4 = str9;
                str5 = str8;
            } else {
                str = "CC(remember):GameAuthorizeDialog.kt#9igjgp";
                onDisagreeClick = onDisagreeClick2;
                agreementChecked$delegate = agreementChecked$delegate4;
                authorizeAllChecked$delegate = authorizeAllChecked$delegate4;
                onAgreeClick = onAgreeClick2;
                if ($authorizeParams.getBindMethodType() == 2) {
                    $composer.startReplaceGroup(-523638102);
                    ComposerKt.sourceInformation($composer, "301@14561L304,309@15022L9,311@15154L6,307@14898L381,317@15439L9,318@15508L6,315@15313L319,322@15666L4845");
                    BiligameImageKt.m1121BiligameImageo3XDK20(StringExtKt.handleUrl($authorizeParams.getIcon()), Dp.constructor-impl(56), Dp.constructor-impl(12), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), null, $composer, 3504, 16);
                    TextKt.Text-Nvy7gAk($authorizeInfo.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, GameFontWeight_androidKt.getGameFontBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT15(), $composer, 48, 0, 131000);
                    TextKt.Text-Nvy7gAk($authorizeInfo.getContent(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(8), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 131064);
                    Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv4 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv11;
                        $composer.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv11;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i8 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope3 = RowScopeInstance.INSTANCE;
                    int i9 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -319609040, "C327@15970L109,325@15836L375,334@16360L6,336@16473L3634,387@20270L9,388@20343L6,385@20144L333:GameAuthorizeDialog.kt#82z3yk");
                    boolean GameAuthorizeDialog$lambda$10$0$0$1$12 = GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate);
                    ComposerKt.sourceInformationMarkerStart($composer, 128237119, str);
                    Object value$iv11 = $composer.rememberedValue();
                    if (value$iv11 == Composer.Companion.getEmpty()) {
                        agreementChecked$delegate2 = agreementChecked$delegate;
                        value$iv11 = new Function1() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda11
                            public final Object invoke(Object obj) {
                                Unit GameAuthorizeDialog$lambda$10$0$0$1$10$0$0;
                                GameAuthorizeDialog$lambda$10$0$0$1$10$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$10$0$0(agreementChecked$delegate2, ((Boolean) obj).booleanValue());
                                return GameAuthorizeDialog$lambda$10$0$0$1$10$0$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv11);
                    } else {
                        agreementChecked$delegate2 = agreementChecked$delegate;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    BiligameCheckboxKt.m1113BiligameCheckboxb7W0Lw(GameAuthorizeDialog$lambda$10$0$0$1$12, (Function1) value$iv11, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(14)), 0.0f, false, null, null, $composer, 432, 120);
                    String agreementText2 = $authorizeInfo.getAgreementTitle();
                    long linkColor2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_link-0d7_KjU();
                    ComposerKt.sourceInformationMarkerStart($composer, 128256740, str);
                    boolean invalid$iv7 = $composer.changed(agreementText2);
                    Object it$iv7 = $composer.rememberedValue();
                    if (!invalid$iv7 && it$iv7 != Composer.Companion.getEmpty()) {
                        str = str;
                        str2 = "C101@5233L9:Row.kt#2w3rfo";
                        $composer3 = $composer;
                        agreementChecked$delegate = agreementChecked$delegate2;
                        str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        authorizeInfo = $authorizeInfo;
                        str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        AnnotatedString annotatedText3 = (AnnotatedString) it$iv7;
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        TextKt.Text-Z58ophY(annotatedText3, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 262136);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer3.endReplaceGroup();
                        $composer2 = $composer3;
                    }
                    int start2 = StringsKt.indexOf$default(agreementText2, "《", 0, false, 6, (Object) null);
                    int end2 = StringsKt.indexOf$default(agreementText2, "》", 0, false, 6, (Object) null);
                    str = str;
                    agreementChecked$delegate = agreementChecked$delegate2;
                    AnnotatedString.Builder $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2410_u241_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                    $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2410_u241_u240.append(agreementText2);
                    if (start2 < 0 || end2 < 0) {
                        str2 = "C101@5233L9:Row.kt#2w3rfo";
                        $composer3 = $composer;
                        str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        authorizeInfo = $authorizeInfo;
                        str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        function1 = $onLinkClick;
                    } else {
                        str2 = "C101@5233L9:Row.kt#2w3rfo";
                        str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        authorizeInfo = $authorizeInfo;
                        str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        function1 = $onLinkClick;
                        $composer3 = $composer;
                        $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2410_u241_u240.addLink(new LinkAnnotation.Clickable("AGREEMENT_LINK", new TextLinkStyles(new SpanStyle(linkColor2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), (SpanStyle) null, (SpanStyle) null, (SpanStyle) null, 14, (DefaultConstructorMarker) null), new LinkInteractionListener() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda12
                            public final void onClick(LinkAnnotation linkAnnotation) {
                                GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$10$1$0$0(function1, authorizeInfo, linkAnnotation);
                            }
                        }), start2, end2 + 1);
                    }
                    int start3 = StringsKt.lastIndexOf$default(agreementText2, "《", 0, false, 6, (Object) null);
                    int end3 = StringsKt.lastIndexOf$default(agreementText2, "》", 0, false, 6, (Object) null);
                    if (start3 >= 0 && end3 >= 0) {
                        $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2410_u241_u240.addLink(new LinkAnnotation.Clickable("PRIVACY_LINK", new TextLinkStyles(new SpanStyle(linkColor2, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), (SpanStyle) null, (SpanStyle) null, (SpanStyle) null, 14, (DefaultConstructorMarker) null), new LinkInteractionListener() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda13
                            public final void onClick(LinkAnnotation linkAnnotation) {
                                GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$10$1$0$1(function1, authorizeInfo, linkAnnotation);
                            }
                        }), start3, end3 + 1);
                    }
                    Object value$iv12 = $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2410_u241_u240.toAnnotatedString();
                    $composer.updateRememberedValue(value$iv12);
                    it$iv7 = value$iv12;
                    AnnotatedString annotatedText32 = (AnnotatedString) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TextKt.Text-Z58ophY(annotatedText32, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 262136);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                } else {
                    authorizeInfo = $authorizeInfo;
                    str2 = "C101@5233L9:Row.kt#2w3rfo";
                    str3 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                    str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                    str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                    $composer2 = $composer;
                    $composer2.startReplaceGroup(-538236312);
                    $composer2.endReplaceGroup();
                }
            }
            Modifier modifier$iv5 = PaddingKt.padding-VpY3zN4$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(10), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl(60)), Dp.constructor-impl(4), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
            Composer $composer$iv4 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, str5);
            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer$iv4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv5 = (390 << 3) & 112;
            String str10 = str3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str10);
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv5);
            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
            Composer $composer6 = $composer2;
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            String str11 = str4;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str11);
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv12;
                $composer$iv4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv12;
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, str2);
            int i11 = ((390 >> 6) & 112) | 6;
            RowScope $this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2411 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 361664624, "C408@21383L6,409@21481L460,402@21049L1339,426@22422L40,439@23174L764,428@22496L1974:GameAuthorizeDialog.kt#82z3yk");
            Modifier modifier2 = BorderKt.border-xT4_qwU(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2411, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(44)), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getLine_light-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            String str12 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1789437854, str12);
            final Function0 onDisagreeClick3 = onDisagreeClick;
            boolean invalid$iv8 = $composer$iv4.changedInstance($authorizeParams) | $composer$iv4.changedInstance(authorizeInfo) | $composer$iv4.changed(onDisagreeClick3);
            Object it$iv8 = $composer$iv4.rememberedValue();
            if (!invalid$iv8 && it$iv8 != Composer.Companion.getEmpty()) {
                $composer$iv = $composer$iv4;
                authorizeAllChecked$delegate2 = authorizeAllChecked$delegate;
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                Modifier modifier$iv6 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv8, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv6 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str10);
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer$iv4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv6);
                Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str11);
                if (!($composer$iv4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv4.startReusableNode();
                if ($composer$iv4.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv13;
                    $composer$iv4.useNode();
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv13;
                    $composer$iv4.createNode(factory$iv$iv$iv4);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i13 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 157026153, "C421@22230L9,422@22303L6,419@22088L266:GameAuthorizeDialog.kt#82z3yk");
                TextKt.Text-Nvy7gAk($authorizeInfo.getDisagreeBtnText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT16(), $composer$iv4, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv4, 6);
                Modifier weight$default = RowScope.-CC.weight$default($this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2411, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, false, 2, (Object) null);
                if (GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate)) {
                    $composer$iv4.startReplaceGroup(-1789390279);
                    ComposerKt.sourceInformation($composer$iv4, "436@22975L6");
                    j2 = BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getGa2-0d7_KjU();
                } else {
                    $composer$iv4.startReplaceGroup(-1789391111);
                    ComposerKt.sourceInformation($composer$iv4, "436@22949L6");
                    j2 = BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getPi5-0d7_KjU();
                }
                $composer$iv4.endReplaceGroup();
                Modifier modifier3 = BackgroundKt.background-bw27NRU(weight$default, j2, RoundedCornerShapeKt.RoundedCornerShape(50));
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1789383374, str12);
                final Function0 onAgreeClick3 = onAgreeClick;
                invalid$iv = $composer$iv4.changedInstance($authorizeParams) | $composer$iv4.changedInstance(authorizeInfo) | $composer$iv4.changedInstance($toaster) | $composer$iv4.changed(onAgreeClick3);
                value$iv = $composer$iv4.rememberedValue();
                if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    $composer$iv$iv$iv2 = $composer$iv4;
                    $composer$iv$iv$iv3 = $composer6;
                    i = -1159599143;
                    $composer$iv2 = $composer;
                    str6 = str10;
                    $composer4 = $composer$iv4;
                    agreementChecked$delegate3 = agreementChecked$delegate;
                    final MutableState mutableState = authorizeAllChecked$delegate2;
                    value$iv = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit GameAuthorizeDialog$lambda$10$0$0$1$11$2$0;
                            GameAuthorizeDialog$lambda$10$0$0$1$11$2$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$11$2$0(AuthorizeParams.this, $authorizeInfo, $toaster, onAgreeClick3, mutableState, agreementChecked$delegate3);
                            return GameAuthorizeDialog$lambda$10$0$0$1$11$2$0;
                        }
                    };
                    $composer$iv4.updateRememberedValue(value$iv);
                } else {
                    $composer4 = $composer$iv4;
                    $composer$iv$iv$iv2 = $composer$iv4;
                    $composer$iv2 = $composer;
                    str6 = str10;
                    $composer$iv$iv$iv3 = $composer6;
                    agreementChecked$delegate3 = agreementChecked$delegate;
                    i = -1159599143;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                $composer$iv3 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv7 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, i, str6);
                int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
                CompositionLocalMap localMap$iv$iv7 = $composer$iv3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv$iv);
                Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str11);
                if (!($composer$iv3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv3.startReusableNode();
                if ($composer$iv3.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv14;
                    $composer$iv3.useNode();
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv14;
                    $composer$iv3.createNode(factory$iv$iv$iv5);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer$iv3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv7, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
                int i14 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i15 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv3, -238590342, "C456@24271L9,454@24132L304:GameAuthorizeDialog.kt#82z3yk");
                String agreeBtnText = $authorizeInfo.getAgreeBtnText();
                TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT16();
                if (GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate3)) {
                    $composer$iv3.startReplaceGroup(-284783106);
                    ComposerKt.sourceInformation($composer$iv3, "457@24385L6");
                    j3 = BiliTheme.INSTANCE.getColors($composer$iv3, BiliTheme.$stable).getText3-0d7_KjU();
                    $composer$iv3.endReplaceGroup();
                } else {
                    $composer$iv3.startReplaceGroup(-284783940);
                    $composer$iv3.endReplaceGroup();
                    j3 = BiliColorsSourceKt.getDayColors().getWh0-0d7_KjU();
                }
                TextKt.Text-Nvy7gAk(agreeBtnText, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer$iv3, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                $composer$iv3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $composer$iv = $composer$iv4;
            authorizeAllChecked$delegate2 = authorizeAllChecked$delegate;
            Object value$iv13 = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda14
                public final Object invoke() {
                    Unit GameAuthorizeDialog$lambda$10$0$0$1$11$0$0;
                    GameAuthorizeDialog$lambda$10$0$0$1$11$0$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$11$0$0(AuthorizeParams.this, authorizeInfo, onDisagreeClick3, authorizeAllChecked$delegate2);
                    return GameAuthorizeDialog$lambda$10$0$0$1$11$0$0;
                }
            };
            $composer$iv4.updateRememberedValue(value$iv13);
            it$iv8 = value$iv13;
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            Modifier modifier$iv62 = ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv8, 15, (Object) null);
            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv62 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv62 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str10);
            int compositeKeyHash$iv$iv62 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv62 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv62);
            Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv62 = (($changed$iv$iv62 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, str11);
            if (!($composer$iv4.getApplier() instanceof Applier)) {
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv62, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv62), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
            int i122 = ($changed$iv$iv$iv62 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i132 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 157026153, "C421@22230L9,422@22303L6,419@22088L266:GameAuthorizeDialog.kt#82z3yk");
            TextKt.Text-Nvy7gAk($authorizeInfo.getDisagreeBtnText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT16(), $composer$iv4, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv4, 6);
            Modifier weight$default2 = RowScope.-CC.weight$default($this$GameAuthorizeDialog_u24lambda_u2410_u240_u240_u241_u2411, SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, false, 2, (Object) null);
            if (GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate)) {
            }
            $composer$iv4.endReplaceGroup();
            Modifier modifier32 = BackgroundKt.background-bw27NRU(weight$default2, j2, RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1789383374, str12);
            final Function0 onAgreeClick32 = onAgreeClick;
            invalid$iv = $composer$iv4.changedInstance($authorizeParams) | $composer$iv4.changedInstance(authorizeInfo) | $composer$iv4.changedInstance($toaster) | $composer$iv4.changed(onAgreeClick32);
            value$iv = $composer$iv4.rememberedValue();
            if (invalid$iv) {
            }
            $composer$iv$iv$iv2 = $composer$iv4;
            $composer$iv$iv$iv3 = $composer6;
            i = -1159599143;
            $composer$iv2 = $composer;
            str6 = str10;
            $composer4 = $composer$iv4;
            agreementChecked$delegate3 = agreementChecked$delegate;
            final MutableState mutableState2 = authorizeAllChecked$delegate2;
            value$iv = new Function0() { // from class: kntr.app.game.gamebind.ui.authorize.GameAuthorizeDialogKt$$ExternalSyntheticLambda15
                public final Object invoke() {
                    Unit GameAuthorizeDialog$lambda$10$0$0$1$11$2$0;
                    GameAuthorizeDialog$lambda$10$0$0$1$11$2$0 = GameAuthorizeDialogKt.GameAuthorizeDialog$lambda$10$0$0$1$11$2$0(AuthorizeParams.this, $authorizeInfo, $toaster, onAgreeClick32, mutableState2, agreementChecked$delegate3);
                    return GameAuthorizeDialog$lambda$10$0$0$1$11$2$0;
                }
            };
            $composer$iv4.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier32, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) value$iv, 15, (Object) null);
            Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
            $composer$iv3 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv72 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
            int $changed$iv$iv72 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, i, str6);
            int compositeKeyHash$iv$iv72 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv3, 0));
            CompositionLocalMap localMap$iv$iv72 = $composer$iv3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv82 = ComposedModifierKt.materializeModifier($composer$iv3, modifier$iv$iv2);
            Function0 factory$iv$iv$iv142 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv72 = (($changed$iv$iv72 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -553112988, str11);
            if (!($composer$iv3.getApplier() instanceof Applier)) {
            }
            $composer$iv3.startReusableNode();
            if ($composer$iv3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv72 = Updater.constructor-impl($composer$iv3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, measurePolicy$iv72, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, localMap$iv$iv72, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv72, Integer.valueOf(compositeKeyHash$iv$iv72), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv72, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv72, materialized$iv$iv82, ComposeUiNode.Companion.getSetModifier());
            int i142 = ($changed$iv$iv$iv72 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
            int i152 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv3, -238590342, "C456@24271L9,454@24132L304:GameAuthorizeDialog.kt#82z3yk");
            String agreeBtnText2 = $authorizeInfo.getAgreeBtnText();
            TextStyle t162 = BiliTheme.INSTANCE.getTextStyle($composer$iv3, BiliTheme.$stable).getT16();
            if (GameAuthorizeDialog$lambda$10$0$0$1$1(agreementChecked$delegate3)) {
            }
            TextKt.Text-Nvy7gAk(agreeBtnText2, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t162, $composer$iv3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
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
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$0$0(AuthorizeParams $authorizeParams) {
        ReporterKt.reportAuthDialogShow($authorizeParams);
        return Unit.INSTANCE;
    }

    private static final boolean GameAuthorizeDialog$lambda$10$0$0$1$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void GameAuthorizeDialog$lambda$10$0$0$1$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean GameAuthorizeDialog$lambda$10$0$0$1$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void GameAuthorizeDialog$lambda$10$0$0$1$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Job GameAuthorizeDialog$lambda$10$0$0$1$6$0(Function0 $dismissDialog) {
        return (Job) $dismissDialog.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$7$0(CoroutineScope $scope, GameAuthorizeViewModel $viewModel, AuthorizeInfo $authorizeInfo, MutableState $authorizeAllChecked$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new GameAuthorizeDialogKt$GameAuthorizeDialog$4$1$1$2$onAgreeClick$1$1$1($viewModel, $authorizeInfo, $authorizeAllChecked$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$8$0$0(MutableState $agreementChecked$delegate, boolean it) {
        GameAuthorizeDialog$lambda$10$0$0$1$2($agreementChecked$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GameAuthorizeDialog$lambda$10$0$0$1$8$1$0$0(Function1 $onLinkClick, AuthorizeInfo $authorizeInfo, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String agreementUrl = $authorizeInfo.getAgreementUrl();
        if (agreementUrl == null) {
            agreementUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $onLinkClick.invoke(agreementUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$9$0$0(MutableState $authorizeAllChecked$delegate, boolean it) {
        GameAuthorizeDialog$lambda$10$0$0$1$5($authorizeAllChecked$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$10$0$0(MutableState $agreementChecked$delegate, boolean it) {
        GameAuthorizeDialog$lambda$10$0$0$1$2($agreementChecked$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GameAuthorizeDialog$lambda$10$0$0$1$10$1$0$0(Function1 $onLinkClick, AuthorizeInfo $authorizeInfo, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String agreementUrl = $authorizeInfo.getAgreementUrl();
        if (agreementUrl == null) {
            agreementUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $onLinkClick.invoke(agreementUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void GameAuthorizeDialog$lambda$10$0$0$1$10$1$0$1(Function1 $onLinkClick, AuthorizeInfo $authorizeInfo, LinkAnnotation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String privacyUrl = $authorizeInfo.getPrivacyUrl();
        if (privacyUrl == null) {
            privacyUrl = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        $onLinkClick.invoke(privacyUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$11$0$0(AuthorizeParams $authorizeParams, AuthorizeInfo $authorizeInfo, Function0 $onDisagreeClick, MutableState $authorizeAllChecked$delegate) {
        ReporterKt.reportAuthDialogBClick($authorizeParams, $authorizeInfo.getDisagreeBtnText(), GameAuthorizeDialog$lambda$10$0$0$1$4($authorizeAllChecked$delegate));
        $onDisagreeClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit GameAuthorizeDialog$lambda$10$0$0$1$11$2$0(AuthorizeParams $authorizeParams, AuthorizeInfo $authorizeInfo, Toaster $toaster, Function0 $onAgreeClick, MutableState $authorizeAllChecked$delegate, MutableState $agreementChecked$delegate) {
        ReporterKt.reportAuthDialogBClick($authorizeParams, $authorizeInfo.getAgreeBtnText(), GameAuthorizeDialog$lambda$10$0$0$1$4($authorizeAllChecked$delegate));
        if (!GameAuthorizeDialog$lambda$10$0$0$1$1($agreementChecked$delegate)) {
            Toaster.-CC.showToast$default($toaster, "需要勾选须知哦~", (ToastDuration) null, 2, (Object) null);
        } else {
            $onAgreeClick.invoke();
        }
        return Unit.INSTANCE;
    }
}