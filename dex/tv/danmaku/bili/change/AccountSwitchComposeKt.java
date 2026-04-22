package tv.danmaku.bili.change;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.app.comm.list.widget.statement.ErrorState;
import com.bilibili.app.comm.list.widget.statement.PlaceHolderState;
import com.bilibili.app.comm.list.widget.statement.StatePageKt;
import com.bilibili.app.comm.list.widget.text.MessageString;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.bilibili.compose.widget.BiliTopAppBarKt;
import com.bilibili.iconfont.KtxKt;
import com.bilibili.lib.accounts.model.SimpleAccountItem;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AccountSwitchCompose.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0007\u001a9\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"AccountSwitchPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/change/AccountSwitchPage;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/change/ISwitchAction;", "(Ltv/danmaku/bili/change/AccountSwitchPage;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AccountItem", "account", "Lcom/bilibili/lib/accounts/model/SimpleAccountItem;", "selected", "", "editMode", "(Lcom/bilibili/lib/accounts/model/SimpleAccountItem;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "AddAccount", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AccountSwitchComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountItem$lambda$2(SimpleAccountItem simpleAccountItem, boolean z, boolean z2, Function1 function1, int i, Composer composer, int i2) {
        AccountItem(simpleAccountItem, z, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$2(AccountSwitchPage accountSwitchPage, Function1 function1, int i, Composer composer, int i2) {
        AccountSwitchPage(accountSwitchPage, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAccount$lambda$2(Function1 function1, int i, Composer composer, int i2) {
        AddAccount(function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AccountSwitchPage(final AccountSwitchPage page, final Function1<? super ISwitchAction, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer3 = $composer.startRestartGroup(1169105243);
        ComposerKt.sourceInformation($composer3, "C(AccountSwitchPage)N(page,onAction)62@2604L1746,101@4357L2927,58@2488L4796:AccountSwitchCompose.kt#khrci7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1169105243, $dirty2, -1, "tv.danmaku.bili.change.AccountSwitchPage (AccountSwitchCompose.kt:57)");
            }
            $composer2 = $composer3;
            ScaffoldKt.Scaffold-27mzLpw(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null)), (ScaffoldState) null, ComposableLambdaKt.rememberComposableLambda(-2019323210, true, new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountSwitchPage$lambda$0;
                    AccountSwitchPage$lambda$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$0(function1, page, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountSwitchPage$lambda$0;
                }
            }, $composer3, 54), (Function2) null, (Function3) null, (Function2) null, 0, false, (Function3) null, false, (Shape) null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-291751587, true, new Function3() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AccountSwitchPage$lambda$1;
                    AccountSwitchPage$lambda$1 = AccountSwitchComposeKt.AccountSwitchPage$lambda$1(AccountSwitchPage.this, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AccountSwitchPage$lambda$1;
                }
            }, $composer3, 54), $composer2, (int) BR.negativeBtnVisible, 12582912, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountSwitchPage$lambda$2;
                    AccountSwitchPage$lambda$2 = AccountSwitchComposeKt.AccountSwitchPage$lambda$2(AccountSwitchPage.this, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountSwitchPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$0$0(final Function1 $onAction, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C72@2992L28,71@2946L491:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1697463456, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous>.<anonymous> (AccountSwitchCompose.kt:71)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -825189060, "CC(remember):AccountSwitchCompose.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onAction);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit AccountSwitchPage$lambda$0$0$0$0;
                        AccountSwitchPage$lambda$0$0$0$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$0$0$0$0($onAction);
                        return AccountSwitchPage$lambda$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IconButtonKt.IconButton((Function0) it$iv, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(24)), false, (MutableInteractionSource) null, ComposableSingletons$AccountSwitchComposeKt.INSTANCE.getLambda$1584467516$accountui_apinkDebug(), $composer, 24624, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$0$0$0$0(Function1 $onAction) {
        $onAction.invoke(PageExitAction.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$0$1(final AccountSwitchPage $page, final Function1 $onAction, RowScope $this$BiliTopAppBar, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliTopAppBar, "$this$BiliTopAppBar");
        ComposerKt.sourceInformation($composer, "C:AccountSwitchCompose.kt#khrci7");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-139079991, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous>.<anonymous> (AccountSwitchCompose.kt:85)");
            }
            if ($page.getAccountLoadState() == AccountLoadState.SUCCESS) {
                $composer.startReplaceGroup(1311523838);
                ComposerKt.sourceInformation($composer, "87@3627L157,90@3944L49,91@4041L6,92@4101L9,86@3586L555");
                String stringResource = StringResources_androidKt.stringResource($page.getEditMode() ? R.string.account_global_string_57 : R.string.account_global_string_178, $composer, 0);
                Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -511870374, "CC(remember):AccountSwitchCompose.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onAction) | $composer.changedInstance($page);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit AccountSwitchPage$lambda$0$1$0$0;
                            AccountSwitchPage$lambda$0$1$0$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$0$1$0$0($onAction, $page);
                            return AccountSwitchPage$lambda$0$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.Text--4IGK_g(stringResource, ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 65528);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1307972633);
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
    public static final Unit AccountSwitchPage$lambda$0$1$0$0(Function1 $onAction, AccountSwitchPage $page) {
        $onAction.invoke(new EditModeAction(!$page.getEditMode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$0(final Function1 $onAction, final AccountSwitchPage $page, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C97@4261L6,98@4314L6,70@2924L531,84@3483L698,63@2618L1722:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2019323210, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous> (AccountSwitchCompose.kt:63)");
            }
            BiliTopAppBarKt.BiliTopAppBar-7zSek6w(ComposableSingletons$AccountSwitchComposeKt.INSTANCE.getLambda$1170069406$accountui_apinkDebug(), (Modifier) null, ComposableLambdaKt.rememberComposableLambda(1697463456, true, new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountSwitchPage$lambda$0$0;
                    AccountSwitchPage$lambda$0$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$0$0($onAction, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountSwitchPage$lambda$0$0;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(-139079991, true, new Function3() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AccountSwitchPage$lambda$0$1;
                    AccountSwitchPage$lambda$0$1 = AccountSwitchComposeKt.AccountSwitchPage$lambda$0$1(AccountSwitchPage.this, $onAction, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AccountSwitchPage$lambda$0$1;
                }
            }, $composer, 54), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), Dp.constructor-impl(4), (PaddingValues) null, $composer, 1576326, (int) BR.coverHorizontal);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$1(final AccountSwitchPage $page, final Function1 $onAction, PaddingValues it, Composer $composer, int $changed) {
        PlaceHolderState placeHolderState;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it):AccountSwitchCompose.kt#khrci7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-291751587, $dirty2, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous> (AccountSwitchCompose.kt:103)");
            }
            if ($page.getAccountLoadState() == AccountLoadState.SUCCESS) {
                $composer.startReplaceGroup(1442410880);
                ComposerKt.sourceInformation($composer, "107@4570L6,109@4629L1933,104@4437L2125");
                Modifier padding = PaddingKt.padding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), it);
                ComposerKt.sourceInformationMarkerStart($composer, -1200390230, "CC(remember):AccountSwitchCompose.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($page) | $composer.changed($onAction);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit AccountSwitchPage$lambda$1$0$0;
                            AccountSwitchPage$lambda$1$0$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$1$0$0(AccountSwitchPage.this, $onAction, (LazyListScope) obj);
                            return AccountSwitchPage$lambda$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                LazyDslKt.LazyColumn(padding, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer, 0, (int) BR.roleName);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1444503721);
                ComposerKt.sourceInformation($composer, "166@6836L13,167@6899L369");
                if ($page.getAccountLoadState() == AccountLoadState.ERROR) {
                    placeHolderState = (PlaceHolderState) PlaceHolderState.ErrorHolder.INSTANCE;
                } else {
                    placeHolderState = PlaceHolderState.LoadingHolder.INSTANCE;
                }
                float alpha = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night ? 0.5f : 1.0f;
                Modifier modifier$iv = AlphaKt.alpha(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), alpha);
                Alignment contentAlignment$iv = new BiasAlignment(0.0f, -0.2f);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
                int i2 = ((0 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1280938094, "C174@7234L2,171@7060L194:AccountSwitchCompose.kt#khrci7");
                ErrorState networkError = new ErrorState.NetworkError(0, (MessageString) null, (MessageString) null, (MessageString) null, false, 15, (DefaultConstructorMarker) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1565346613, "CC(remember):AccountSwitchCompose.kt#9igjgp");
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                StatePageKt.StatePage(placeHolderState, networkError, (Function0) it$iv2, $composer, (ErrorState.NetworkError.$stable << 3) | BR.negativeBtnVisible);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit AccountSwitchPage$lambda$1$0$0(final AccountSwitchPage $page, final Function1 $onAction, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(769585005, true, new Function3() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AccountSwitchPage$lambda$1$0$0$0;
                AccountSwitchPage$lambda$1$0$0$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$1$0$0$0(AccountSwitchPage.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AccountSwitchPage$lambda$1$0$0$0;
            }
        }), 3, (Object) null);
        final List items$iv = $page.getAccountList();
        $this$LazyColumn.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$AccountSwitchPage$lambda$1$0$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$AccountSwitchPage$lambda$1$0$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Function0 factory$iv$iv$iv;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if ($composer.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    Object obj = items$iv.get(it);
                    int $changed2 = ($dirty & 14) | ($dirty & BR.containerVisible);
                    SimpleAccountItem account = (SimpleAccountItem) obj;
                    $composer.startReplaceGroup(-1292552444);
                    ComposerKt.sourceInformation($composer, "CN(index,account)*128@5458L504:AccountSwitchCompose.kt#khrci7");
                    Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & BR.containerVisible));
                    int $changed$iv$iv = (6 << 3) & BR.containerVisible;
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
                    int i2 = ((6 >> 6) & BR.containerVisible) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -1630056951, "C132@5692L248:AccountSwitchCompose.kt#khrci7");
                    if (it != 0) {
                        $composer.startReplaceGroup(-1630050039);
                        ComposerKt.sourceInformation($composer, "130@5599L6,130@5573L68");
                        DividerKt.Divider-oMI9zvI((Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU(), Dp.constructor-impl((float) 0.5d), 0.0f, $composer, (int) BR.negativeBtnVisible, 9);
                    } else {
                        $composer.startReplaceGroup(-1635553531);
                    }
                    $composer.endReplaceGroup();
                    AccountSwitchComposeKt.AccountItem(account, it == $page.getCurrentUserIndex(), $page.getEditMode(), $onAction, $composer, ($changed2 >> 6) & 14);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$AccountSwitchComposeKt.INSTANCE.m761getLambda$76628010$accountui_apinkDebug(), 3, (Object) null);
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-194264779, true, new Function3() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit AccountSwitchPage$lambda$1$0$0$2;
                AccountSwitchPage$lambda$1$0$0$2 = AccountSwitchComposeKt.AccountSwitchPage$lambda$1$0$0$2(AccountSwitchPage.this, $onAction, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return AccountSwitchPage$lambda$1$0$0$2;
            }
        }), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$1$0$0$0(AccountSwitchPage $page, LazyItemScope $this$item, Composer $composer, int $changed) {
        int i;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C117@4978L27,118@5049L6,119@5105L9,116@4941L410:AccountSwitchCompose.kt#khrci7");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(769585005, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AccountSwitchCompose.kt:111)");
            }
            if ($page.getEditMode()) {
                i = R.string.account_global_string_128;
            } else {
                i = R.string.account_global_string_172;
            }
            int textId = i;
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(textId, $composer, 0), PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(10), 0.0f, Dp.constructor-impl(6), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12(), $composer, 48, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$1$0$0$2(AccountSwitchPage $page, final Function1 $onAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C154@6451L79,150@6248L282:AccountSwitchCompose.kt#khrci7");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-194264779, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AccountSwitchCompose.kt:150)");
            }
            AnimatedVisibilityKt.AnimatedVisibility($page.getShowAddButton() && !$page.getEditMode(), (Modifier) null, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1680506531, true, new Function3() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AccountSwitchPage$lambda$1$0$0$2$0;
                    AccountSwitchPage$lambda$1$0$0$2$0 = AccountSwitchComposeKt.AccountSwitchPage$lambda$1$0$0$2$0($onAction, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AccountSwitchPage$lambda$1$0$0$2$0;
                }
            }, $composer, 54), $composer, 200064, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountSwitchPage$lambda$1$0$0$2$0(Function1 $onAction, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C155@6477L31:AccountSwitchCompose.kt#khrci7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1680506531, $changed, -1, "tv.danmaku.bili.change.AccountSwitchPage.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AccountSwitchCompose.kt:155)");
        }
        AddAccount($onAction, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AccountItem(final SimpleAccountItem account, final boolean selected, final boolean editMode, final Function1<? super ISwitchAction, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1267064725);
        ComposerKt.sourceInformation($composer2, "C(AccountItem)N(account,selected,editMode,onAction)192@7574L267,201@7884L6,188@7450L2076:AccountSwitchCompose.kt#khrci7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(account) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changed(editMode) ? 256 : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1267064725, $dirty2, -1, "tv.danmaku.bili.change.AccountItem (AccountSwitchCompose.kt:187)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(80));
            ComposerKt.sourceInformationMarkerStart($composer2, -2121502560, "CC(remember):AccountSwitchCompose.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & BR.containerVisible) == 32) | (($dirty2 & 896) == 256) | $composer2.changedInstance(account) | (($dirty2 & 7168) == 2048);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda14
                    public final Object invoke() {
                        Unit AccountItem$lambda$0$0;
                        AccountItem$lambda$0$0 = AccountSwitchComposeKt.AccountItem$lambda$0$0(selected, editMode, account, function1);
                        return AccountItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
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
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            RowScope $this$AccountItem_u24lambda_u241 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -880719509, "C205@8009L141,216@8343L6,217@8387L9,211@8160L252:AccountSwitchCompose.kt#khrci7");
            BiliImageKt.BiliImage(account.getFace(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), RoundedCornerShapeKt.getCircleShape()), (String) null, false, 0, (String) null, false, (Function3) null, (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, 0, 0, 4092);
            TextKt.Text--4IGK_g(account.getName(), PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$AccountItem_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(44), 0.0f, 10, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b(), $composer2, 0, 0, 65528);
            if (selected) {
                $composer2.startReplaceGroup(-880324043);
                ComposerKt.sourceInformation($composer2, "223@8552L7,222@8483L218,230@8865L6,232@8997L6,221@8450L580");
                CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, com.bilibili.iconfont.R.drawable.ref_checkmark_line_500), $composer2, 0), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getPi5-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(3)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 48, 56);
                $composer2.endReplaceGroup();
            } else {
                if (editMode) {
                    $composer2.startReplaceGroup(-879709499);
                    ComposerKt.sourceInformation($composer2, "237@9176L7,236@9107L219,243@9477L6,235@9074L436");
                    CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume2, com.bilibili.iconfont.R.drawable.ref_arrow_exit_line_500), $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_icon-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | BR.pendentVisible, 56);
                } else {
                    $composer2.startReplaceGroup(-888712271);
                }
                $composer2.endReplaceGroup();
            }
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountItem$lambda$2;
                    AccountItem$lambda$2 = AccountSwitchComposeKt.AccountItem$lambda$2(account, selected, editMode, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountItem$lambda$0$0(boolean $selected, boolean $editMode, SimpleAccountItem $account, Function1 $onAction) {
        ISwitchAction it;
        if ($selected) {
            it = null;
        } else {
            it = $editMode ? new ExitAccountAction($account) : new SwitchAccountAction($account);
        }
        if (it != null) {
            $onAction.invoke(it);
        }
        return Unit.INSTANCE;
    }

    private static final void AddAccount(final Function1<? super ISwitchAction, Unit> function1, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-2123726329);
        ComposerKt.sourceInformation($composer2, "C(AddAccount)N(onAction)255@9730L53,258@9826L6,251@9606L1057:AccountSwitchCompose.kt#khrci7");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2123726329, $dirty, -1, "tv.danmaku.bili.change.AddAccount (AccountSwitchCompose.kt:250)");
            }
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(80));
            ComposerKt.sourceInformationMarkerStart($composer2, -791530756, "CC(remember):AccountSwitchCompose.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit AddAccount$lambda$0$0;
                        AddAccount$lambda$0$0 = AccountSwitchComposeKt.AddAccount$lambda$0$0(function1);
                        return AddAccount$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU$default(ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) it$iv, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
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
            int i2 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 608388086, "C263@9980L84,267@10212L6,269@10358L6,262@9951L438,273@10424L76,274@10532L6,275@10576L9,272@10399L258:AccountSwitchCompose.kt#khrci7");
            ImageKt.Image(PainterResources_androidKt.painterResource(com.bilibili.app.comm.baseres.R.drawable.ic_vector_general_add, $composer2, 0), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(12)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_medium-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | 48, 56);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_48, $composer2, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14b(), $composer2, 48, 0, 65528);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.change.AccountSwitchComposeKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit AddAccount$lambda$2;
                    AddAccount$lambda$2 = AccountSwitchComposeKt.AddAccount$lambda$2(function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return AddAccount$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddAccount$lambda$0$0(Function1 $onAction) {
        $onAction.invoke(LoginAction.INSTANCE);
        return Unit.INSTANCE;
    }
}