package kntr.app.tribee.publish;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import bili.resource.following.Res;
import bili.resource.following.String1_commonMainKt;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.publish.internal.DialogsKt;
import kntr.app.tribee.publish.internal.HeaderKt;
import kntr.app.tribee.publish.internal.KeyboardAnimationState;
import kntr.app.tribee.publish.internal.KeyboardAnimationStateKt;
import kntr.app.tribee.publish.internal.TribeeActionsKt;
import kntr.app.tribee.publish.internal.TribeeInputFieldsKt;
import kntr.app.tribee.publish.internal.TribeeSettingPanelKt;
import kntr.app.tribee.publish.internal.TribeeTailKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.aphro.core.AphroAction;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AphroSelection;
import kntr.common.photonic.aphro.core.ContentSizeLimit;
import kntr.common.photonic.aphro.ui.MediaSelectBottomSheetKt;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publish.ui.generated.resources.Res;
import srcs.app.tribee.publish.ui.generated.resources.String0_commonMainKt;

/* compiled from: TribeePublishPage.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052&\u0010\t\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\nj\u0002`\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0006X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0006X\u008a\u008e\u0002"}, d2 = {"TribeePublishPage", "", "state", "Lkntr/app/tribee/publish/TribeePublishState;", "needCheckContentOnClosing", "Lkotlin/Function0;", "", "onCloseCheckContent", "onClosing", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/publish/TribeePublishState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "showMediaSelect", "showSettingPanel", "needFocusTitle"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$10(TribeePublishState tribeePublishState, Function0 function0, Function0 function02, Function0 function03, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeePublishPage(tribeePublishState, function0, function02, function03, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x04bc, code lost:
        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0659, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x069e, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L114;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x049a  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x052f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0827  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0a15  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0d9d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0e1e  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0e5f  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0e67  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0ef5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0409  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeePublishPage(final TribeePublishState state, final Function0<Boolean> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object value$iv;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean invalid$iv;
        final TribeePublishContent content;
        String str;
        Composer $composer3;
        int $dirty;
        CoroutineScope scope;
        ColumnScope $this$TribeePublishPage_u24lambda_u247_u240;
        Composer $composer4;
        final MutableState showMediaSelect$delegate;
        Composer $composer5;
        final Function0 checkContentOnClosing;
        Function0 factory$iv$iv$iv3;
        final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function22;
        final CoroutineScope scope2;
        TribeePublishContent publishContent;
        boolean invalid$iv2;
        Object it$iv;
        boolean invalid$iv3;
        Object it$iv2;
        Float floatOrNull;
        Function0 factory$iv$iv$iv4;
        String str2;
        final MutableState showSettingPanel$delegate;
        Object value$iv2;
        final MutableState showMediaSelect$delegate2;
        Composer $composer6;
        TribeePublishContent content2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(function0, "needCheckContentOnClosing");
        Intrinsics.checkNotNullParameter(function02, "onCloseCheckContent");
        Intrinsics.checkNotNullParameter(function03, "onClosing");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer7 = $composer.startRestartGroup(1910401627);
        ComposerKt.sourceInformation($composer7, "C(TribeePublishPage)N(state,needCheckContentOnClosing,onCloseCheckContent,onClosing,onAction,modifier)70@3232L46,73@3307L46,76@3386L41,77@3452L31,78@3506L24,79@3572L7,80@3613L32,82@3667L31,83@3724L80,83@3703L101,88@3876L6,88@3809L9250,300@13092L7,301@13116L49,302@13198L147,302@13176L169,309@13373L84,309@13351L106:TribeePublishPage.kt#ufloxe");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer7.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer7.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer7.changedInstance(function02) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer7.changedInstance(function03) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer7.changedInstance(function2) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty2 |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer7.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer7.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1910401627, $dirty3, -1, "kntr.app.tribee.publish.TribeePublishPage (TribeePublishPage.kt:69)");
            }
            ComposerKt.sourceInformationMarkerStart($composer7, 1944936681, "CC(remember):TribeePublishPage.kt#9igjgp");
            Object it$iv3 = $composer7.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer7.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            MutableState showMediaSelect$delegate3 = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerStart($composer7, 1944939081, "CC(remember):TribeePublishPage.kt#9igjgp");
            Object it$iv4 = $composer7.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer7.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            MutableState showSettingPanel$delegate2 = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            final Function0 checkContentOnClosing2 = (Function0) SnapshotStateKt.rememberUpdatedState(function02, $composer7, ($dirty3 >> 6) & 14).getValue();
            final Function0 closing = (Function0) SnapshotStateKt.rememberUpdatedState(function03, $composer7, ($dirty3 >> 9) & 14).getValue();
            ComposerKt.sourceInformationMarkerStart($composer7, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer7, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer7.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer7);
                $composer7.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope3 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalFocusManager();
            ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer7.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            final FocusManager focusManager = (FocusManager) consume;
            final KeyboardAnimationState keyboardAnimationState = KeyboardAnimationStateKt.rememberKeyboardAnimationState($composer7, 0);
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("read.column-contribution.0.0.pv", $composer7, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, 1944952459, "CC(remember):TribeePublishPage.kt#9igjgp");
            boolean invalid$iv4 = $composer7.changedInstance(pvTrigger);
            Object it$iv5 = $composer7.rememberedValue();
            if (!invalid$iv4 && it$iv5 != Composer.Companion.getEmpty()) {
                value$iv = it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer7, 6);
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
                CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer7.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer7.startReusableNode();
                if ($composer7.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer7.useNode();
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv5;
                    $composer7.createNode(factory$iv$iv$iv);
                }
                modifier3 = modifier4;
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer7);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer7, -695134784, "C93@4030L12,94@4091L3,95@4125L17,89@3899L5001:TribeePublishPage.kt#ufloxe");
                Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, WindowInsetsKt.asPaddingValues(WindowInsetsKt.union(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer7, 6), WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer7, 6)), $composer7, 0).calculateBottomPadding-D9Ej5fM(), 7, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer7.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer7, modifier$iv2);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer7.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer7.startReusableNode();
                if ($composer7.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer7.useNode();
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv6;
                    $composer7.createNode(factory$iv$iv$iv2);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer7);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                int i6 = ((0 >> 6) & 112) | 6;
                ColumnScope $this$TribeePublishPage_u24lambda_u247_u2402 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer7, -384126333, "C101@4360L75,99@4241L318:TribeePublishPage.kt#ufloxe");
                boolean z = !(state instanceof TribeePublishContent) && ((TribeePublishContent) state).getButtonValid();
                ComposerKt.sourceInformationMarkerStart($composer7, 126155394, "CC(remember):TribeePublishPage.kt#9igjgp");
                invalid$iv = (($dirty3 & 112) != 32) | $composer7.changed(checkContentOnClosing2) | $composer7.changed(closing);
                Object it$iv6 = $composer7.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv5 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeePublishPage$lambda$7$0$0$0;
                        TribeePublishPage$lambda$7$0$0$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$0$0(function0, checkContentOnClosing2, closing);
                        return TribeePublishPage$lambda$7$0$0$0;
                    }
                };
                $composer7.updateRememberedValue(value$iv5);
                it$iv6 = value$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer7);
                MutableState showMediaSelect$delegate4 = showMediaSelect$delegate3;
                HeaderKt.Header(z, (Function0) it$iv6, function2, WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer7, ($dirty3 >> 6) & 896, 0);
                content = state.getPublishContent();
                if (content == null) {
                    $composer7.startReplaceGroup(-383737129);
                    ComposerKt.sourceInformation($composer7, "108@4691L7,109@4730L55,110@4824L114,131@5748L150,125@5506L197,119@5211L75,122@5322L141,114@4956L1041,138@6014L411,150@6613L385,158@7037L1338,147@6442L2177,191@8637L239");
                    CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
                    ComposerKt.sourceInformationMarkerStart($composer7, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer7.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    final Toaster toaster = (Toaster) consume2;
                    final String toastStr = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_title_overflow_toast(Res.string.INSTANCE), $composer7, 0);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126170281, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Object it$iv7 = $composer7.rememberedValue();
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        Object value$iv6 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf((content.getFromEdit() || content.getFromDraft()) ? false : true), (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer7.updateRememberedValue(value$iv6);
                        it$iv7 = value$iv6;
                    } else {
                        str2 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    }
                    final MutableState needFocusTitle$delegate = (MutableState) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    String inputHint = TribeeInputHintHelper.INSTANCE.getInputHint();
                    boolean TribeePublishPage$lambda$7$0$2 = TribeePublishPage$lambda$7$0$2(needFocusTitle$delegate);
                    $composer3 = $composer7;
                    Modifier weight = $this$TribeePublishPage_u24lambda_u247_u2402.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, true);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126199885, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Object it$iv8 = $composer7.rememberedValue();
                    if (it$iv8 == Composer.Companion.getEmpty()) {
                        showSettingPanel$delegate = showSettingPanel$delegate2;
                        value$iv2 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$0$4$0;
                                TribeePublishPage$lambda$7$0$4$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$4$0(showSettingPanel$delegate);
                                return TribeePublishPage$lambda$7$0$4$0;
                            }
                        };
                        $composer7.updateRememberedValue(value$iv2);
                    } else {
                        showSettingPanel$delegate = showSettingPanel$delegate2;
                        value$iv2 = it$iv8;
                    }
                    Function0 function04 = (Function0) value$iv2;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126192188, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Object value$iv7 = $composer7.rememberedValue();
                    if (value$iv7 == Composer.Companion.getEmpty()) {
                        value$iv7 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$0$5$0;
                                TribeePublishPage$lambda$7$0$5$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$5$0(needFocusTitle$delegate, showSettingPanel$delegate);
                                return TribeePublishPage$lambda$7$0$5$0;
                            }
                        };
                        $composer7.updateRememberedValue(value$iv7);
                    }
                    Function0 function05 = (Function0) value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126182626, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv5 = $composer7.changedInstance(toaster) | $composer7.changed(toastStr);
                    Object it$iv9 = $composer7.rememberedValue();
                    if (invalid$iv5) {
                    }
                    Object value$iv8 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit TribeePublishPage$lambda$7$0$6$0;
                            TribeePublishPage$lambda$7$0$6$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$6$0(Toaster.this, toastStr);
                            return TribeePublishPage$lambda$7$0$6$0;
                        }
                    };
                    $composer7.updateRememberedValue(value$iv8);
                    it$iv9 = value$iv8;
                    Function0 function06 = (Function0) it$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126186244, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv6 = $composer7.changedInstance(scope3) | $composer7.changedInstance(function2);
                    Object it$iv10 = $composer7.rememberedValue();
                    if (invalid$iv6) {
                    }
                    Object value$iv9 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit TribeePublishPage$lambda$7$0$7$0;
                            TribeePublishPage$lambda$7$0$7$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$7$0(scope3, function2);
                            return TribeePublishPage$lambda$7$0$7$0;
                        }
                    };
                    $composer7.updateRememberedValue(value$iv9);
                    it$iv10 = value$iv9;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    final MutableState showSettingPanel$delegate3 = showSettingPanel$delegate;
                    $dirty = $dirty3;
                    TribeeInputFieldsKt.TribeeInputFields(content, inputHint, function2, TribeePublishPage$lambda$7$0$2, function04, function05, function06, (Function0) it$iv10, weight, $composer7, (($dirty3 >> 6) & 896) | 221232, 0);
                    TribeeTailKt.TribeeTail(content.getTribeeInfo(), content.getContent().getTextCount(), content.getLimitInfo(), content.getSelectedCategory(), content.getCategories(), function2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer7, (458752 & ($dirty << 3)) | 1572864, 0);
                    boolean sendToFollowing = content.getSendToFollowing();
                    boolean TribeePublishPage$lambda$4 = TribeePublishPage$lambda$4(showSettingPanel$delegate3);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126227800, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv7 = $composer7.changedInstance(scope3) | $composer7.changedInstance(function2);
                    Object it$iv11 = $composer7.rememberedValue();
                    if (invalid$iv7 || it$iv11 == Composer.Companion.getEmpty()) {
                        showMediaSelect$delegate2 = showMediaSelect$delegate4;
                        Object value$iv10 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$0$8$0;
                                TribeePublishPage$lambda$7$0$8$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$8$0(scope3, function2, showMediaSelect$delegate2);
                                return TribeePublishPage$lambda$7$0$8$0;
                            }
                        };
                        $composer7.updateRememberedValue(value$iv10);
                        it$iv11 = value$iv10;
                    } else {
                        showMediaSelect$delegate2 = showMediaSelect$delegate4;
                    }
                    Function0 function07 = (Function0) it$iv11;
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerStart($composer7, 126242321, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv8 = $composer7.changedInstance(scope3) | $composer7.changedInstance(content) | $composer7.changedInstance(function2) | $composer7.changed(keyboardAnimationState.ordinal()) | $composer7.changedInstance(focusManager);
                    Object value$iv11 = $composer7.rememberedValue();
                    if (invalid$iv8 || value$iv11 == Composer.Companion.getEmpty()) {
                        showMediaSelect$delegate4 = showMediaSelect$delegate2;
                        $composer2 = $composer7;
                        $composer6 = $composer7;
                        content2 = content;
                        scope = scope3;
                        str = str2;
                        $this$TribeePublishPage_u24lambda_u247_u240 = null;
                        value$iv11 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda6
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$0$9$0;
                                TribeePublishPage$lambda$7$0$9$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$9$0(scope3, keyboardAnimationState, focusManager, showSettingPanel$delegate3, content, function2, needFocusTitle$delegate);
                                return TribeePublishPage$lambda$7$0$9$0;
                            }
                        };
                        $composer7.updateRememberedValue(value$iv11);
                    } else {
                        $composer2 = $composer7;
                        $composer6 = $composer7;
                        content2 = content;
                        scope = scope3;
                        showMediaSelect$delegate4 = showMediaSelect$delegate2;
                        str = str2;
                        $this$TribeePublishPage_u24lambda_u247_u240 = null;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    TribeeActionsKt.TribeeActions(sendToFollowing, TribeePublishPage$lambda$4, function07, (Function0) value$iv11, content2.getShowSettingsButton(), !content2.getFromEdit(), function2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, $this$TribeePublishPage_u24lambda_u247_u240), $composer6, (($dirty << 6) & 3670016) | 12582912, 0);
                    TribeeSettingPanelKt.TribeeSettingPanel(content2.getSettingItems(), function2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, $this$TribeePublishPage_u24lambda_u247_u240), TribeePublishPage$lambda$4(showSettingPanel$delegate3), $composer6, (($dirty >> 9) & 112) | 384, 0);
                    $composer6.endReplaceGroup();
                    $composer4 = $composer6;
                } else {
                    str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    $composer3 = $composer7;
                    $dirty = $dirty3;
                    $composer2 = $composer7;
                    scope = scope3;
                    $this$TribeePublishPage_u24lambda_u247_u240 = null;
                    $composer4 = $composer7;
                    $composer4.startReplaceGroup(-388478517);
                    $composer4.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                showMediaSelect$delegate = showMediaSelect$delegate4;
                if (state instanceof TribeePublishUploading) {
                    $composer5 = $composer3;
                    if (state instanceof TribeePublishInitLoading) {
                        $composer5.startReplaceGroup(-690008749);
                        ComposerKt.sourceInformation($composer5, "214@9443L62,212@9358L246");
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer5, 1917407263, "CC(remember):TribeePublishPage.kt#9igjgp");
                        Object it$iv12 = $composer5.rememberedValue();
                        if (it$iv12 == Composer.Companion.getEmpty()) {
                            Object value$iv12 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda9
                                public final Object invoke() {
                                    Unit unit2;
                                    unit2 = Unit.INSTANCE;
                                    return unit2;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv12);
                            it$iv12 = value$iv12;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        Modifier modifier$iv$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv12, 15, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv$iv);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer5.startReusableNode();
                        if ($composer5.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer5.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv7;
                            $composer5.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i8 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer5, -802796150, "C219@9588L2,219@9576L14:TribeePublishPage.kt#ufloxe");
                        ComposerKt.sourceInformationMarkerStart($composer5, -995727603, "CC(remember):TribeePublishPage.kt#9igjgp");
                        Object it$iv13 = $composer5.rememberedValue();
                        if (it$iv13 == Composer.Companion.getEmpty()) {
                            Object value$iv13 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda10
                                public final Object invoke() {
                                    Unit unit2;
                                    unit2 = Unit.INSTANCE;
                                    return unit2;
                                }
                            };
                            $composer5.updateRememberedValue(value$iv13);
                            it$iv13 = value$iv13;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        BackHandlerKt.BackHandler(false, (Function0) it$iv13, $composer5, 48, 1);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        ComposerKt.sourceInformationMarkerEnd($composer5);
                        $composer5.endReplaceGroup();
                        checkContentOnClosing = checkContentOnClosing2;
                    } else {
                        if (state instanceof TribeePublishContent) {
                            $composer5.startReplaceGroup(-689705755);
                            ComposerKt.sourceInformation($composer5, "222@9710L27,222@9669L68");
                            boolean booleanValue = ((Boolean) function0.invoke()).booleanValue();
                            ComposerKt.sourceInformationMarkerStart($composer5, 1917415772, "CC(remember):TribeePublishPage.kt#9igjgp");
                            checkContentOnClosing = checkContentOnClosing2;
                            boolean invalid$iv9 = $composer5.changed(checkContentOnClosing);
                            Object it$iv14 = $composer5.rememberedValue();
                            if (invalid$iv9 || it$iv14 == Composer.Companion.getEmpty()) {
                                Object value$iv14 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda11
                                    public final Object invoke() {
                                        Unit TribeePublishPage$lambda$7$5$0;
                                        TribeePublishPage$lambda$7$5$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$5$0(checkContentOnClosing);
                                        return TribeePublishPage$lambda$7$5$0;
                                    }
                                };
                                $composer5.updateRememberedValue(value$iv14);
                                it$iv14 = value$iv14;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            BackHandlerKt.BackHandler(booleanValue, (Function0) it$iv14, $composer5, 0, 0);
                        } else {
                            checkContentOnClosing = checkContentOnClosing2;
                            $composer5.startReplaceGroup(-699287359);
                        }
                        $composer5.endReplaceGroup();
                    }
                } else {
                    $composer5 = $composer3;
                    $composer5.startReplaceGroup(-690400031);
                    ComposerKt.sourceInformation($composer5, "203@9046L62,201@8961L328");
                    Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, $this$TribeePublishPage_u24lambda_u247_u240);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917394559, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Object it$iv15 = $composer5.rememberedValue();
                    if (it$iv15 == Composer.Companion.getEmpty()) {
                        Object value$iv15 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda7
                            public final Object invoke() {
                                Unit unit2;
                                unit2 = Unit.INSTANCE;
                                return unit2;
                            }
                        };
                        $composer5.updateRememberedValue(value$iv15);
                        it$iv15 = value$iv15;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Modifier modifier$iv$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv15, 15, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                    int $changed$iv$iv4 = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                    CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv$iv2);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer5.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer5.startReusableNode();
                    if ($composer5.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer5.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv8;
                        $composer5.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer5);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i10 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$TribeePublishPage_u24lambda_u247_u242 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer5, -667652799, "C208@9191L2,208@9179L14,209@9210L65:TribeePublishPage.kt#ufloxe");
                    ComposerKt.sourceInformationMarkerStart($composer5, 1225389092, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Object it$iv16 = $composer5.rememberedValue();
                    if (it$iv16 == Composer.Companion.getEmpty()) {
                        Object value$iv16 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit unit2;
                                unit2 = Unit.INSTANCE;
                                return unit2;
                            }
                        };
                        $composer5.updateRememberedValue(value$iv16);
                        it$iv16 = value$iv16;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    BackHandlerKt.BackHandler(false, (Function0) it$iv16, $composer5, 48, 1);
                    DialogsKt.PublishLoadingDialog($this$TribeePublishPage_u24lambda_u247_u242.align(Modifier.Companion, Alignment.Companion.getCenter()), $composer5, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endReplaceGroup();
                    checkContentOnClosing = checkContentOnClosing2;
                }
                if (TribeePublishPage$lambda$1(showMediaSelect$delegate) || !(state instanceof TribeePublishContent)) {
                    function22 = function2;
                    scope2 = scope;
                    $composer5.startReplaceGroup(-699287359);
                } else {
                    $composer5.startReplaceGroup(-689472635);
                    ComposerKt.sourceInformation($composer5, "226@9847L54,234@10312L500,245@10870L1088,270@12091L315,227@9914L2507");
                    String toastOnExceeded = StringResourcesKt.stringResource(String1_commonMainKt.getFollowing_global_string_756(Res.string.INSTANCE), $composer5, 0);
                    int picMaxNum = ((int) ((TribeePublishContent) state).getLimitInfo().getPicMaxNum()) - ((TribeePublishContent) state).getContent().getAssetCount();
                    int picMaxNum2 = (int) ((TribeePublishContent) state).getLimitInfo().getPicMaxNum();
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917435509, "CC(remember):TribeePublishPage.kt#9igjgp");
                    Composer $this$cache$iv = $composer5;
                    Object it$iv17 = $this$cache$iv.rememberedValue();
                    if (it$iv17 == Composer.Companion.getEmpty()) {
                        String config = KConfig.INSTANCE.config("tribee_image_max_size_limit_mb", "");
                        float maxMB = (config == null || (floatOrNull = StringsKt.toFloatOrNull(config)) == null) ? 20.0f : floatOrNull.floatValue();
                        Object value$iv17 = new ContentSizeLimit(ContentSizeKt.megabytes(Float.valueOf(maxMB)), toastOnExceeded, 0.0d, null, 12, null);
                        $this$cache$iv.updateRememberedValue(value$iv17);
                        it$iv17 = value$iv17;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    AphroSelectOption aphroSelectOption = new AphroSelectOption(picMaxNum, picMaxNum2, false, null, null, false, false, false, (ContentSizeLimit) it$iv17, null, 700, null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917453953, "CC(remember):TribeePublishPage.kt#9igjgp");
                    scope2 = scope;
                    function22 = function2;
                    boolean invalid$iv10 = $composer2.changedInstance(scope2) | $composer2.changedInstance(function22);
                    Composer $this$cache$iv2 = $composer5;
                    Object it$iv18 = $this$cache$iv2.rememberedValue();
                    if (invalid$iv10 || it$iv18 == Composer.Companion.getEmpty()) {
                        Object value$iv18 = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda12
                            public final Object invoke(Object obj) {
                                Unit TribeePublishPage$lambda$7$7$0;
                                TribeePublishPage$lambda$7$7$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$7$0(scope2, function22, showMediaSelect$delegate, (AphroSelection) obj);
                                return TribeePublishPage$lambda$7$7$0;
                            }
                        };
                        $this$cache$iv2.updateRememberedValue(value$iv18);
                        it$iv18 = value$iv18;
                    }
                    Function1 function1 = (Function1) it$iv18;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(44), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917492252, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv11 = $composer2.changedInstance(scope2) | $composer2.changedInstance(function22);
                    Composer $this$cache$iv3 = $composer5;
                    Object it$iv19 = $this$cache$iv3.rememberedValue();
                    if (invalid$iv11 || it$iv19 == Composer.Companion.getEmpty()) {
                        Object value$iv19 = new Function1() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda13
                            public final Object invoke(Object obj) {
                                Unit TribeePublishPage$lambda$7$8$0;
                                TribeePublishPage$lambda$7$8$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$8$0(scope2, function22, (AphroAction) obj);
                                return TribeePublishPage$lambda$7$8$0;
                            }
                        };
                        $this$cache$iv3.updateRememberedValue(value$iv19);
                        it$iv19 = value$iv19;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    MediaSelectBottomSheetKt.MediaSelectBottomSheet(aphroSelectOption, function1, modifier5, null, false, (Function1) it$iv19, $composer5, AphroSelectOption.$stable | 24960, 8);
                }
                $composer5.endReplaceGroup();
                publishContent = state.getPublishContent();
                if (publishContent == null && publishContent.getShowPublishConfirmDialog()) {
                    $composer5.startReplaceGroup(-699287359);
                } else {
                    $composer5.startReplaceGroup(-686863458);
                    ComposerKt.sourceInformation($composer5, "282@12570L278,291@12877L151,281@12520L523");
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917507543, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv12 = $composer2.changedInstance(scope2) | $composer2.changedInstance(function22);
                    Composer $this$cache$iv4 = $composer5;
                    Object it$iv20 = $this$cache$iv4.rememberedValue();
                    if (invalid$iv12 || it$iv20 == Composer.Companion.getEmpty()) {
                        Object value$iv20 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda14
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$9$0;
                                TribeePublishPage$lambda$7$9$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$9$0(scope2, function22);
                                return TribeePublishPage$lambda$7$9$0;
                            }
                        };
                        $this$cache$iv4.updateRememberedValue(value$iv20);
                        it$iv20 = value$iv20;
                    }
                    Function0 function08 = (Function0) it$iv20;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, 1917517240, "CC(remember):TribeePublishPage.kt#9igjgp");
                    boolean invalid$iv13 = $composer2.changedInstance(scope2) | $composer2.changedInstance(function22);
                    Composer $this$cache$iv5 = $composer5;
                    Object it$iv21 = $this$cache$iv5.rememberedValue();
                    if (invalid$iv13 || it$iv21 == Composer.Companion.getEmpty()) {
                        Object value$iv21 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda15
                            public final Object invoke() {
                                Unit TribeePublishPage$lambda$7$10$0;
                                TribeePublishPage$lambda$7$10$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$10$0(scope2, function22);
                                return TribeePublishPage$lambda$7$10$0;
                            }
                        };
                        $this$cache$iv5.updateRememberedValue(value$iv21);
                        it$iv21 = value$iv21;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    DialogsKt.PublishConfirmDialog(function08, (Function0) it$iv21, null, $composer5, 0, 4);
                }
                $composer5.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                CompositionLocal this_$iv3 = ToasterKt.getLocalToaster();
                Composer $composer$iv = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 2023513938, str);
                Object consume3 = $composer$iv.consume(this_$iv3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                Toaster toaster2 = (Toaster) consume3;
                BSimpleLens<TribeePublishState, String> editToast = state.getEditToast();
                String toast = (String) SnapshotStateKt.rememberUpdatedState(editToast == null ? (String) editToast.get(state) : null, $composer2, 0).getValue();
                ComposerKt.sourceInformationMarkerStart($composer2, 1945255694, "CC(remember):TribeePublishPage.kt#9igjgp");
                invalid$iv2 = $composer2.changed(toast) | $composer2.changedInstance(toaster2) | $composer2.changedInstance(function22);
                Composer $this$cache$iv6 = $composer2;
                it$iv = $this$cache$iv6.rememberedValue();
                if (!invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv22 = (Function2) new TribeePublishPageKt$TribeePublishPage$3$1(toast, toaster2, function22, null);
                    $this$cache$iv6.updateRememberedValue(value$iv22);
                    it$iv = value$iv22;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(toast, (Function2) it$iv, $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, 1945261231, "CC(remember):TribeePublishPage.kt#9igjgp");
                invalid$iv3 = $composer2.changedInstance(state) | $composer2.changed(closing);
                Composer $this$cache$iv7 = $composer2;
                it$iv2 = $this$cache$iv7.rememberedValue();
                if (!invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv23 = (Function2) new TribeePublishPageKt$TribeePublishPage$4$1(state, closing, null);
                    $this$cache$iv7.updateRememberedValue(value$iv23);
                    it$iv2 = value$iv23;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(state, (Function2) it$iv2, $composer2, $dirty & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            value$iv = (Function2) new TribeePublishPageKt$TribeePublishPage$1$1(pvTrigger, null);
            $composer7.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer7, 6);
            Modifier modifier$iv3 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer7, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv4 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv4, false);
            int $changed$iv$iv5 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer7, modifier$iv3);
            Function0 factory$iv$iv$iv52 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
            }
            modifier3 = modifier4;
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope3 = BoxScopeInstance.INSTANCE;
            int i42 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -695134784, "C93@4030L12,94@4091L3,95@4125L17,89@3899L5001:TribeePublishPage.kt#ufloxe");
            Modifier modifier$iv22 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, WindowInsetsKt.asPaddingValues(WindowInsetsKt.union(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer7, 6), WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer7, 6)), $composer7, 0).calculateBottomPadding-D9Ej5fM(), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer7, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv22 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer7.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer7, modifier$iv22);
            Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i52 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i62 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$TribeePublishPage_u24lambda_u247_u24022 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, -384126333, "C101@4360L75,99@4241L318:TribeePublishPage.kt#ufloxe");
            if (state instanceof TribeePublishContent) {
            }
            ComposerKt.sourceInformationMarkerStart($composer7, 126155394, "CC(remember):TribeePublishPage.kt#9igjgp");
            invalid$iv = (($dirty3 & 112) != 32) | $composer7.changed(checkContentOnClosing2) | $composer7.changed(closing);
            Object it$iv62 = $composer7.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv52 = new Function0() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit TribeePublishPage$lambda$7$0$0$0;
                    TribeePublishPage$lambda$7$0$0$0 = TribeePublishPageKt.TribeePublishPage$lambda$7$0$0$0(function0, checkContentOnClosing2, closing);
                    return TribeePublishPage$lambda$7$0$0$0;
                }
            };
            $composer7.updateRememberedValue(value$iv52);
            it$iv62 = value$iv52;
            ComposerKt.sourceInformationMarkerEnd($composer7);
            MutableState showMediaSelect$delegate42 = showMediaSelect$delegate3;
            HeaderKt.Header(z, (Function0) it$iv62, function2, WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer7, ($dirty3 >> 6) & 896, 0);
            content = state.getPublishContent();
            if (content == null) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            showMediaSelect$delegate = showMediaSelect$delegate42;
            if (state instanceof TribeePublishUploading) {
            }
            if (TribeePublishPage$lambda$1(showMediaSelect$delegate)) {
            }
            function22 = function2;
            scope2 = scope;
            $composer5.startReplaceGroup(-699287359);
            $composer5.endReplaceGroup();
            publishContent = state.getPublishContent();
            if (publishContent == null && publishContent.getShowPublishConfirmDialog()) {
            }
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            CompositionLocal this_$iv32 = ToasterKt.getLocalToaster();
            Composer $composer$iv2 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 2023513938, str);
            Object consume32 = $composer$iv2.consume(this_$iv32);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            Toaster toaster22 = (Toaster) consume32;
            BSimpleLens<TribeePublishState, String> editToast2 = state.getEditToast();
            String toast2 = (String) SnapshotStateKt.rememberUpdatedState(editToast2 == null ? (String) editToast2.get(state) : null, $composer2, 0).getValue();
            ComposerKt.sourceInformationMarkerStart($composer2, 1945255694, "CC(remember):TribeePublishPage.kt#9igjgp");
            invalid$iv2 = $composer2.changed(toast2) | $composer2.changedInstance(toaster22) | $composer2.changedInstance(function22);
            Composer $this$cache$iv62 = $composer2;
            it$iv = $this$cache$iv62.rememberedValue();
            if (!invalid$iv2) {
            }
            Object value$iv222 = (Function2) new TribeePublishPageKt$TribeePublishPage$3$1(toast2, toaster22, function22, null);
            $this$cache$iv62.updateRememberedValue(value$iv222);
            it$iv = value$iv222;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(toast2, (Function2) it$iv, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1945261231, "CC(remember):TribeePublishPage.kt#9igjgp");
            invalid$iv3 = $composer2.changedInstance(state) | $composer2.changed(closing);
            Composer $this$cache$iv72 = $composer2;
            it$iv2 = $this$cache$iv72.rememberedValue();
            if (!invalid$iv3) {
            }
            Object value$iv232 = (Function2) new TribeePublishPageKt$TribeePublishPage$4$1(state, closing, null);
            $this$cache$iv72.updateRememberedValue(value$iv232);
            it$iv2 = value$iv232;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(state, (Function2) it$iv2, $composer2, $dirty & 14);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer7;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.TribeePublishPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePublishPage$lambda$10;
                    TribeePublishPage$lambda$10 = TribeePublishPageKt.TribeePublishPage$lambda$10(TribeePublishState.this, function0, function02, function03, function2, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePublishPage$lambda$10;
                }
            });
        }
    }

    private static final boolean TribeePublishPage$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeePublishPage$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    private static final boolean TribeePublishPage$lambda$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeePublishPage$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$0$0(Function0 $needCheckContentOnClosing, Function0 $checkContentOnClosing, Function0 $closing) {
        if (((Boolean) $needCheckContentOnClosing.invoke()).booleanValue()) {
            $checkContentOnClosing.invoke();
        } else {
            $closing.invoke();
        }
        return Unit.INSTANCE;
    }

    private static final boolean TribeePublishPage$lambda$7$0$2(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TribeePublishPage$lambda$7$0$3(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$6$0(Toaster $toaster, String $toastStr) {
        Toaster.CC.showToast$default($toaster, $toastStr, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$7$0(CoroutineScope $scope, Function2 $onAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$1$5$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$5$0(MutableState $needFocusTitle$delegate, MutableState $showSettingPanel$delegate) {
        TribeePublishPage$lambda$7$0$3($needFocusTitle$delegate, false);
        if (TribeePublishPage$lambda$4($showSettingPanel$delegate)) {
            TribeePublishPage$lambda$5($showSettingPanel$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$4$0(MutableState $showSettingPanel$delegate) {
        if (TribeePublishPage$lambda$4($showSettingPanel$delegate)) {
            TribeePublishPage$lambda$5($showSettingPanel$delegate, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$8$0(CoroutineScope $scope, Function2 $onAction, MutableState $showMediaSelect$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$1$6$1$1($onAction, null), 3, (Object) null);
        TribeePublishPage$lambda$2($showMediaSelect$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$0$9$0(CoroutineScope $scope, KeyboardAnimationState $keyboardAnimationState, FocusManager $focusManager, MutableState $showSettingPanel$delegate, TribeePublishContent $content, Function2 $onAction, MutableState $needFocusTitle$delegate) {
        if (TribeePublishPage$lambda$4($showSettingPanel$delegate)) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$1$7$1$1($content, $onAction, $showSettingPanel$delegate, $needFocusTitle$delegate, null), 3, (Object) null);
        } else if ($keyboardAnimationState != KeyboardAnimationState.Opening) {
            FocusManager.-CC.clearFocus$default($focusManager, false, 1, (Object) null);
            TribeePublishPage$lambda$5($showSettingPanel$delegate, true);
            Unit unit = Unit.INSTANCE;
        } else {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$1$7$1$2($focusManager, $showSettingPanel$delegate, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$5$0(Function0 $checkContentOnClosing) {
        $checkContentOnClosing.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$7$0(CoroutineScope $scope, Function2 $onAction, MutableState $showMediaSelect$delegate, AphroSelection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (!it.getSelectedAssets().isEmpty()) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$8$1$1($onAction, it, null), 3, (Object) null);
        }
        TribeePublishPage$lambda$2($showMediaSelect$delegate, false);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$8$1$2($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$8$0(CoroutineScope $scope, Function2 $onAction, AphroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((it instanceof AphroAction.SelectAsset) || (it instanceof AphroAction.UnSelectAsset)) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$9$1$1($onAction, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$9$0(CoroutineScope $scope, Function2 $onAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$10$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishPage$lambda$7$10$0(CoroutineScope $scope, Function2 $onAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishPageKt$TribeePublishPage$2$11$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}