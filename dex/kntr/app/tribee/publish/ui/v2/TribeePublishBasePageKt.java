package kntr.app.tribee.publish.ui.v2;

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
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import bili.resource.following.Res;
import bili.resource.following.String1_commonMainKt;
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.common.KUpPermissionType;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.tribee.publish.core.v2.TribeePublishAction;
import kntr.app.tribee.publish.core.v2.model.TribeeInfo;
import kntr.app.tribee.publish.core.v2.model.TribeePublishContent;
import kntr.app.tribee.publish.core.v2.model.TribeePublishInitLoading;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSettingItem;
import kntr.app.tribee.publish.core.v2.model.TribeePublishState;
import kntr.app.tribee.publish.core.v2.model.TribeePublishUploading;
import kntr.app.tribee.publish.ui.v2.internal.DialogsKt;
import kntr.app.tribee.publish.ui.v2.internal.FooterKt;
import kntr.app.tribee.publish.ui.v2.internal.HeaderKt;
import kntr.app.tribee.publish.ui.v2.internal.InputFieldFocus;
import kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsHelper_androidKt;
import kntr.app.tribee.publish.ui.v2.internal.TribeeInputFieldsKt;
import kntr.app.tribee.publish.ui.v2.internal.TribeeInputHintHelper;
import kntr.app.tribee.publish.ui.v2.internal.TribeeToolbarKt;
import kntr.app.tribee.publish.ui.v2.utils.SettingItemTransformKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.account.AccountEntryPoint;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.config.KConfig;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.ouro.common.ui.toolPanel.AlbumPanelEvent;
import kntr.common.ouro.common.ui.toolPanel.AlbumPanelKt;
import kntr.common.ouro.common.ui.toolPanel.AtMentionPanelKt;
import kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelEvent;
import kntr.common.ouro.common.ui.toolPanel.ParagraphStylePanelKt;
import kntr.common.ouro.common.ui.toolPanel.StickerPanelKt;
import kntr.common.ouro.common.ui.toolPanel.TextStylePanelEvent;
import kntr.common.ouro.common.ui.toolPanel.TextStylePanelKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.Constant;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelKt;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelState;
import kntr.common.ouro.common.ui.toolPanel.expandablePanel.ExpandablePanelStateKt;
import kntr.common.ouro.common.ui.toolPanel.setting.SettingSectionItem;
import kntr.common.ouro.common.ui.toolPanel.setting.SettingSectionKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionPlugin;
import kntr.common.ouro.core.plugin.atMention.OuroAtMentionState;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryPlugin;
import kntr.common.ouro.core.plugin.editControls.OuroHistoryState;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyle;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStylePlugin;
import kntr.common.ouro.core.plugin.textStyle.OuroTextStyleState;
import kntr.common.ouro.preview.component.ToolbarItem;
import kntr.common.ouro.ui.textField.OuroFocusRequester;
import kntr.common.photonic.ContentSizeKt;
import kntr.common.photonic.aphro.core.AphroSelectOption;
import kntr.common.photonic.aphro.core.AspectRadioLimit;
import kntr.common.photonic.aphro.core.ContentSizeLimit;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kntr.common.trio.pagecontroller.BackHandlerKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publishV2.ui.generated.resources.Res;
import srcs.app.tribee.publishV2.ui.generated.resources.String0_commonMainKt;

/* compiled from: TribeePublishBasePage.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001ay\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122&\u0010\u0016\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001j\u0002`\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0000\"\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t*D\b\u0000\u0010\u0000\"\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020 X\u008a\u008e\u0002²\u0006\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u008a\u0084\u0002²\u0006\u0010\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012X\u008a\u0084\u0002²\u0006*\u0010#\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001j\u0002`\u0017X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002²\u0006\n\u0010'\u001a\u00020(X\u008a\u008e\u0002²\u0006\n\u0010)\u001a\u00020\u0007X\u008a\u008e\u0002"}, d2 = {"TribeeActionHandler", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/core/v2/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "", "IMAGE_PICKER_MAX_SELECT_COUNT", "", "getIMAGE_PICKER_MAX_SELECT_COUNT", "()I", "IMAGE_PICKER_MAX_SELECT_COUNT$delegate", "Lkotlin/Lazy;", "TribeePublishBasePage", "ouroStore", "Lkntr/common/ouro/core/OuroStore;", "tribeeState", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;", "needCheckContentOnClosing", "Lkotlin/Function0;", "", "onCloseCheckContent", "onClosing", "onAction", "Lkntr/app/tribee/publish/ui/v2/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/ouro/core/OuroStore;Lkntr/app/tribee/publish/core/v2/model/TribeePublishState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "mid", "", "Lkntr/base/account/AccountState;", "ui_debug", "panelType", "Lkntr/app/tribee/publish/ui/v2/TribeePublishPanelType;", "checkContentOnClosing", "closing", "handleAction", "accountState", "ouroState", "Lkntr/common/ouro/core/OuroState;", "inputFieldFocus", "Lkntr/app/tribee/publish/ui/v2/internal/InputFieldFocus;", "footerHeight"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishBasePageKt {
    private static final Lazy IMAGE_PICKER_MAX_SELECT_COUNT$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda10
        public final Object invoke() {
            int IMAGE_PICKER_MAX_SELECT_COUNT_delegate$lambda$0;
            IMAGE_PICKER_MAX_SELECT_COUNT_delegate$lambda$0 = TribeePublishBasePageKt.IMAGE_PICKER_MAX_SELECT_COUNT_delegate$lambda$0();
            return Integer.valueOf(IMAGE_PICKER_MAX_SELECT_COUNT_delegate$lambda$0);
        }
    });

    /* compiled from: TribeePublishBasePage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TribeePublishPanelType.values().length];
            try {
                iArr[TribeePublishPanelType.STICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[TribeePublishPanelType.TEXT_STYLE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[TribeePublishPanelType.PARAGRAPH_STYLE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[TribeePublishPanelType.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[TribeePublishPanelType.ALBUM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[TribeePublishPanelType.SETTING.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$22(OuroStore ouroStore, TribeePublishState tribeePublishState, Function0 function0, Function0 function02, Function0 function03, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeePublishBasePage(ouroStore, tribeePublishState, function0, function02, function03, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    private static final int getIMAGE_PICKER_MAX_SELECT_COUNT() {
        return ((Number) IMAGE_PICKER_MAX_SELECT_COUNT$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int IMAGE_PICKER_MAX_SELECT_COUNT_delegate$lambda$0() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config("tribee_image_picker_max_select_count", "18");
        if (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) {
            return 18;
        }
        return intOrNull.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:158:0x0689, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x07ba, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x123e, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:335:0x12b2, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L285;
     */
    /* JADX WARN: Code restructure failed: missing block: B:343:0x12f3, code lost:
        if (r5 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L290;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x138f, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x1427, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x1577, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:402:0x15b2, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L206;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x07be  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x08ed  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x09b0  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x09cb  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x09f2  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x16cb  */
    /* JADX WARN: Removed duplicated region for block: B:432:0x16d0  */
    /* JADX WARN: Removed duplicated region for block: B:438:0x1724  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0259  */
    /* JADX WARN: Type inference failed for: r0v189 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeePublishBasePage(final OuroStore ouroStore, final TribeePublishState tribeeState, final Function0<Boolean> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Object value$iv;
        Object value$iv2;
        OuroPluginState ouroPluginState;
        CoroutineScope scope;
        OuroPluginState ouroPluginState2;
        OuroAtMentionState ouroAtMentionState;
        FocusManager focusManager;
        Object value$iv3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        State handleAction$delegate;
        String str;
        State checkContentOnClosing$delegate;
        int $dirty;
        String str2;
        final FocusManager focusManager2;
        CoroutineScope scope2;
        Composer $composer$iv;
        final OuroFocusRequester contentFocusRequester;
        final MutableState panelType$delegate;
        String str3;
        BoxScope $this$TribeePublishBasePage_u24lambda_u2419;
        Composer $composer$iv2;
        Composer $composer3;
        String str4;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv3;
        Composer $composer4;
        State closing$delegate;
        int i2;
        float f;
        Composer $composer5;
        Composer $composer$iv4;
        final MutableIntState footerHeight$delegate;
        Composer $composer6;
        BoxScope $this$TribeePublishBasePage_u24lambda_u24192;
        FocusManager focusManager3;
        OuroFocusRequester contentFocusRequester2;
        CoroutineScope scope3;
        String str5;
        Composer $composer7;
        MutableIntState footerHeight$delegate2;
        BoxScope $this$TribeePublishBasePage_u24lambda_u24193;
        OuroFocusRequester contentFocusRequester3;
        Composer $composer8;
        final State checkContentOnClosing$delegate2;
        Function0 factory$iv$iv$iv3;
        final CoroutineScope scope4;
        final State handleAction$delegate2;
        TribeePublishState tribeePublishState;
        String str6;
        boolean invalid$iv;
        Float floatOrNull;
        Float floatOrNull2;
        Float floatOrNull3;
        Float floatOrNull4;
        final State handleAction$delegate3;
        Function0 factory$iv$iv$iv4;
        ColumnScope $this$TribeePublishBasePage_u24lambda_u2419_u240;
        final MutableState panelType$delegate2;
        Modifier materialized$iv$iv;
        final MutableState inputFieldFocus$delegate;
        boolean invalid$iv2;
        MutableState inputFieldFocus$delegate2;
        String str7;
        String str8;
        Composer $composer9;
        int i3;
        float f2;
        Intrinsics.checkNotNullParameter(ouroStore, "ouroStore");
        Intrinsics.checkNotNullParameter(tribeeState, "tribeeState");
        Intrinsics.checkNotNullParameter(function0, "needCheckContentOnClosing");
        Intrinsics.checkNotNullParameter(function02, "onCloseCheckContent");
        Intrinsics.checkNotNullParameter(function03, "onClosing");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer10 = $composer.startRestartGroup(1050601429);
        ComposerKt.sourceInformation($composer10, "C(TribeePublishBasePage)N(ouroStore,tribeeState,needCheckContentOnClosing,onCloseCheckContent,onClosing,onAction,modifier)109@5453L56,110@5543L41,111@5604L31,112@5660L30,113@5707L24,115@5753L31,116@5810L80,116@5789L101,123@5923L78,124@6045L16,126@6104L16,129@6226L149,134@6480L29,135@6542L33,136@6617L7,138@6653L49,140@6735L7,141@6767L33,172@7997L6,172@7930L14887,492@22850L7,493@22874L61,494@22968L151,494@22946L173,501@23153L90,501@23125L118:TribeePublishBasePage.kt#oim1ra");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer10.changedInstance(ouroStore) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer10.changedInstance(tribeeState) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer10.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer10.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer10.changedInstance(function03) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer10.changedInstance(function2) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer10.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer10.shouldExecute((599187 & $dirty3) != 599186, $dirty3 & 1)) {
            Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1050601429, $dirty3, -1, "kntr.app.tribee.publish.ui.v2.TribeePublishBasePage (TribeePublishBasePage.kt:108)");
            }
            ComposerKt.sourceInformationMarkerStart($composer10, 310668205, "CC(remember):TribeePublishBasePage.kt#9igjgp");
            Object it$iv = $composer10.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(TribeePublishPanelType.NONE, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer10.updateRememberedValue(value$iv4);
                it$iv = value$iv4;
            }
            MutableState panelType$delegate3 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer10);
            final State checkContentOnClosing$delegate3 = SnapshotStateKt.rememberUpdatedState(function02, $composer10, ($dirty3 >> 9) & 14);
            final State closing$delegate2 = SnapshotStateKt.rememberUpdatedState(function03, $composer10, ($dirty3 >> 12) & 14);
            State handleAction$delegate4 = SnapshotStateKt.rememberUpdatedState(function2, $composer10, ($dirty3 >> 15) & 14);
            ComposerKt.sourceInformationMarkerStart($composer10, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer10, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer10.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer10);
                $composer10.updateRememberedValue(value$iv$iv);
            }
            CoroutineScope scope5 = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer10);
            ComposerKt.sourceInformationMarkerEnd($composer10);
            PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger("read.column-contribution.0.0.pv", $composer10, 6);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer10, 310679653, "CC(remember):TribeePublishBasePage.kt#9igjgp");
            boolean invalid$iv3 = $composer10.changedInstance(pvTrigger);
            Object it$iv2 = $composer10.rememberedValue();
            if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                value$iv = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer10);
                EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer10, 6);
                ComposerKt.sourceInformationMarkerStart($composer10, 310683267, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                value$iv2 = $composer10.rememberedValue();
                if (value$iv2 != Composer.Companion.getEmpty()) {
                    Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                    value$iv2 = ((AccountEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AccountEntryPoint.class))).getAccount();
                    $composer10.updateRememberedValue(value$iv2);
                }
                KAccountStore accountStore = (KAccountStore) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer10);
                State accountState$delegate = SnapshotStateKt.collectAsState(accountStore.getState(), (CoroutineContext) null, $composer10, 0, 1);
                State ouroState$delegate = SnapshotStateKt.collectAsState(ouroStore.getStateFlow(), (CoroutineContext) null, $composer10, 0, 1);
                OuroState this_$iv = TribeePublishBasePage$lambda$9(ouroState$delegate);
                KClass key$iv = Reflection.getOrCreateKotlinClass(OuroHistoryPlugin.class);
                ouroPluginState = this_$iv.getPluginStates().get(key$iv);
                if (!(ouroPluginState instanceof OuroHistoryState)) {
                    ouroPluginState = null;
                }
                if (((OuroHistoryState) ouroPluginState) != null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv);
                }
                OuroState this_$iv2 = TribeePublishBasePage$lambda$9(ouroState$delegate);
                KClass key$iv2 = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
                OuroPluginState ouroPluginState3 = this_$iv2.getPluginStates().get(key$iv2);
                if (!(ouroPluginState3 instanceof OuroTextStyleState)) {
                    ouroPluginState3 = null;
                }
                OuroTextStyleState ouroTextStyleState = (OuroTextStyleState) ouroPluginState3;
                if (ouroTextStyleState == null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv2);
                }
                ComposerKt.sourceInformationMarkerStart($composer10, 310693034, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                boolean invalid$iv4 = $composer10.changed(ouroTextStyleState);
                Object it$iv3 = $composer10.rememberedValue();
                if (!invalid$iv4 && it$iv3 != Composer.Companion.getEmpty()) {
                    scope = scope5;
                    OuroTextStyle insertTextStyle = (OuroTextStyle) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    OuroState this_$iv3 = TribeePublishBasePage$lambda$9(ouroState$delegate);
                    KClass key$iv3 = Reflection.getOrCreateKotlinClass(OuroAtMentionPlugin.class);
                    ouroPluginState2 = this_$iv3.getPluginStates().get(key$iv3);
                    if (!(ouroPluginState2 instanceof OuroAtMentionState)) {
                        ouroPluginState2 = null;
                    }
                    ouroAtMentionState = (OuroAtMentionState) ouroPluginState2;
                    if (ouroAtMentionState != null) {
                        throw new NoSuchElementException("No plugin state for " + key$iv3);
                    }
                    OuroAtMentionState mentionState = ouroAtMentionState;
                    ComposerKt.sourceInformationMarkerStart($composer10, 310701042, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                    Object it$iv4 = $composer10.rememberedValue();
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = new FocusRequester();
                        $composer10.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                    }
                    FocusRequester titleFocusRequester = (FocusRequester) it$iv4;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    ComposerKt.sourceInformationMarkerStart($composer10, 310703030, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                    Object it$iv5 = $composer10.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new OuroFocusRequester();
                        $composer10.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                    }
                    final OuroFocusRequester contentFocusRequester4 = (OuroFocusRequester) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    CompositionLocal this_$iv4 = CompositionLocalsKt.getLocalFocusManager();
                    ComposerKt.sourceInformationMarkerStart($composer10, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer10.consume(this_$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    FocusManager focusManager4 = (FocusManager) consume;
                    ComposerKt.sourceInformationMarkerStart($composer10, 310706598, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                    Object it$iv6 = $composer10.rememberedValue();
                    if (it$iv6 == Composer.Companion.getEmpty()) {
                        focusManager = focusManager4;
                        value$iv3 = SnapshotStateKt.mutableStateOf$default(InputFieldFocus.NONE, (SnapshotMutationPolicy) null, 2, (Object) null);
                        $composer10.updateRememberedValue(value$iv3);
                    } else {
                        focusManager = focusManager4;
                        value$iv3 = it$iv6;
                    }
                    MutableState inputFieldFocus$delegate3 = (MutableState) value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    CompositionLocal this_$iv5 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer10, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer10.consume(this_$iv5);
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    Density density = (Density) consume2;
                    ComposerKt.sourceInformationMarkerStart($composer10, 310710230, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                    Object it$iv7 = $composer10.rememberedValue();
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv7 = SnapshotIntStateKt.mutableIntStateOf(0);
                        $composer10.updateRememberedValue(value$iv7);
                        it$iv7 = value$iv7;
                    }
                    MutableIntState footerHeight$delegate3 = (MutableIntState) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    final TribeePublishContent content = tribeeState.getPublishContent();
                    Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer10, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer10, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer10, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer10, 0));
                    CompositionLocalMap localMap$iv$iv = $composer10.getCurrentCompositionLocalMap();
                    Modifier modifier4 = modifier3;
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer10, modifier$iv);
                    Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer10, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer10.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer10.startReusableNode();
                    if ($composer10.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer10.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv5;
                        $composer10.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer10);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer10, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    int i6 = ((0 >> 6) & 112) | 6;
                    BoxScope $this$TribeePublishBasePage_u24lambda_u24194 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer10, 1478724257, "C173@8020L3729:TribeePublishBasePage.kt#oim1ra");
                    Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer10, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer10, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv2 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer10, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer10, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer10.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer10, modifier$iv2);
                    Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer10, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer10.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer10.startReusableNode();
                    if ($composer10.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer10.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv6;
                        $composer10.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer10);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer10, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    int i8 = ((6 >> 6) & 112) | 6;
                    ColumnScope $this$TribeePublishBasePage_u24lambda_u2419_u2402 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer10, 1545389923, "C176@8207L75,174@8076L334:TribeePublishBasePage.kt#oim1ra");
                    boolean z = (tribeeState instanceof TribeePublishContent) && ((TribeePublishContent) tribeeState).getButtonValid();
                    ComposerKt.sourceInformationMarkerStart($composer10, 326946556, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                    boolean invalid$iv5 = (($dirty3 & 896) == 256) | $composer10.changed(checkContentOnClosing$delegate3) | $composer10.changed(closing$delegate2);
                    Object it$iv8 = $composer10.rememberedValue();
                    if (invalid$iv5) {
                    }
                    Object value$iv8 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit TribeePublishBasePage$lambda$19$0$0$0;
                            TribeePublishBasePage$lambda$19$0$0$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$0$0(function0, checkContentOnClosing$delegate3, closing$delegate2);
                            return TribeePublishBasePage$lambda$19$0$0$0;
                        }
                    };
                    $composer10.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    HeaderKt.Header(z, (Function0) it$iv8, TribeePublishBasePage$lambda$5(handleAction$delegate4), WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), $composer10, 0, 0);
                    if (content != null) {
                        $composer10.startReplaceGroup(1545744531);
                        ComposerKt.sourceInformation($composer10, "182@8490L7,183@8529L54,206@9730L6,196@9262L255,193@9148L75,185@8675L1085");
                        CompositionLocal this_$iv6 = ToasterKt.getLocalToaster();
                        ComposerKt.sourceInformationMarkerStart($composer10, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume3 = $composer10.consume(this_$iv6);
                        ComposerKt.sourceInformationMarkerEnd($composer10);
                        final Toaster toaster = (Toaster) consume3;
                        final String toastStr = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_title_overflow_toast(Res.string.INSTANCE), $composer10, 0);
                        boolean contentShowSelectionWhenInactive = TribeePublishBasePage$hasCustomKeyboard(panelType$delegate3);
                        String inputHint = TribeeInputHintHelper.INSTANCE.getInputHint();
                        Function2<TribeePublishAction, Continuation<? super Unit>, Object> TribeePublishBasePage$lambda$5 = TribeePublishBasePage$lambda$5(handleAction$delegate4);
                        Modifier modifier5 = BackgroundKt.background-bw27NRU$default($this$TribeePublishBasePage_u24lambda_u2419_u2402.weight(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, true), BiliTheme.INSTANCE.getColors($composer10, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer10, 326980496, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                        final FocusManager focusManager5 = focusManager;
                        boolean invalid$iv6 = $composer10.changedInstance(contentFocusRequester4) | $composer10.changedInstance(focusManager5);
                        Object it$iv9 = $composer10.rememberedValue();
                        if (invalid$iv6) {
                            handleAction$delegate = handleAction$delegate4;
                        } else {
                            handleAction$delegate = handleAction$delegate4;
                            if (it$iv9 != Composer.Companion.getEmpty()) {
                                $this$TribeePublishBasePage_u24lambda_u2419_u240 = $this$TribeePublishBasePage_u24lambda_u2419_u2402;
                                panelType$delegate2 = panelType$delegate3;
                                materialized$iv$iv = materialized$iv$iv3;
                                inputFieldFocus$delegate = inputFieldFocus$delegate3;
                                Function1 function1 = (Function1) it$iv9;
                                ComposerKt.sourceInformationMarkerEnd($composer10);
                                ComposerKt.sourceInformationMarkerStart($composer10, 326976668, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                                invalid$iv2 = $composer10.changedInstance(toaster) | $composer10.changed(toastStr);
                                Object it$iv10 = $composer10.rememberedValue();
                                if (invalid$iv2) {
                                }
                                Object value$iv9 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda8
                                    public final Object invoke() {
                                        Unit TribeePublishBasePage$lambda$19$0$2$0;
                                        TribeePublishBasePage$lambda$19$0$2$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$2$0(Toaster.this, toastStr);
                                        return TribeePublishBasePage$lambda$19$0$2$0;
                                    }
                                };
                                $composer10.updateRememberedValue(value$iv9);
                                it$iv10 = value$iv9;
                                ComposerKt.sourceInformationMarkerEnd($composer10);
                                closing$delegate = closing$delegate2;
                                $composer3 = $composer10;
                                $composer$iv$iv$iv = $composer10;
                                modifier$iv$iv = modifier4;
                                checkContentOnClosing$delegate = checkContentOnClosing$delegate3;
                                MutableState panelType$delegate4 = panelType$delegate2;
                                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                                $dirty = $dirty3;
                                $this$TribeePublishBasePage_u24lambda_u2419 = $this$TribeePublishBasePage_u24lambda_u24194;
                                $composer$iv$iv = $composer10;
                                $composer$iv2 = $composer10;
                                $composer$iv3 = $composer10;
                                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                                focusManager2 = focusManager5;
                                inputFieldFocus$delegate2 = inputFieldFocus$delegate;
                                contentFocusRequester = contentFocusRequester4;
                                scope2 = scope;
                                $composer$iv = $composer10;
                                $composer$iv4 = $composer10;
                                TribeeInputFieldsKt.TribeeInputFields(ouroStore, content, inputHint, contentShowSelectionWhenInactive, titleFocusRequester, contentFocusRequester4, function1, TribeePublishBasePage$lambda$5, (Function0) it$iv10, modifier5, $composer10, ($dirty3 & 14) | 24960 | (OuroFocusRequester.$stable << 15), 0);
                                if (TribeePublishBasePage$lambda$14(inputFieldFocus$delegate2) == InputFieldFocus.CONTENT || Intrinsics.areEqual(mentionState, OuroAtMentionState.Idle.INSTANCE)) {
                                    str7 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                    $composer5 = $composer10;
                                    str8 = "CC(remember):TribeePublishBasePage.kt#9igjgp";
                                    $composer9 = $composer10;
                                    i3 = 1;
                                    f2 = 0.0f;
                                    $composer5.startReplaceGroup(1537263985);
                                } else {
                                    $composer5 = $composer10;
                                    $composer5.startReplaceGroup(1547085281);
                                    ComposerKt.sourceInformation($composer5, "213@10062L78,210@9891L272");
                                    i3 = 1;
                                    f2 = 0.0f;
                                    Modifier modifier6 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(83));
                                    str8 = "CC(remember):TribeePublishBasePage.kt#9igjgp";
                                    ComposerKt.sourceInformationMarkerStart($composer5, 327005919, str8);
                                    str7 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                    $composer9 = $composer10;
                                    boolean invalid$iv7 = $composer9.changedInstance(ouroStore);
                                    Object it$iv11 = $composer5.rememberedValue();
                                    if (invalid$iv7 || it$iv11 == Composer.Companion.getEmpty()) {
                                        Object value$iv10 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda9
                                            public final Object invoke(Object obj) {
                                                Unit TribeePublishBasePage$lambda$19$0$3$0;
                                                TribeePublishBasePage$lambda$19$0$3$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$3$0(OuroStore.this, (OuroAction) obj);
                                                return TribeePublishBasePage$lambda$19$0$3$0;
                                            }
                                        };
                                        $composer5.updateRememberedValue(value$iv10);
                                        it$iv11 = value$iv10;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    AtMentionPanelKt.AtMentionPanel(mentionState, (Function1) it$iv11, modifier6, $composer5, 384, 0);
                                }
                                $composer5.endReplaceGroup();
                                panelType$delegate = panelType$delegate4;
                                if (TribeePublishBasePage$hasToolbar(panelType$delegate, inputFieldFocus$delegate2)) {
                                    str3 = str7;
                                    $composer4 = $composer9;
                                    str = str8;
                                    f = f2;
                                    i2 = i3;
                                    $composer5.startReplaceGroup(1537263985);
                                } else {
                                    $composer5.startReplaceGroup(1547443362);
                                    ComposerKt.sourceInformation($composer5, "227@10664L96,220@10239L687");
                                    TribeeInfo tribeeInfo = content.getTribeeInfo();
                                    KTribeeCategory selectedCategory = content.getSelectedCategory();
                                    boolean sendToFollowing = content.getSendToFollowing();
                                    boolean z2 = !content.getFromEdit();
                                    ToolbarItem toolbarItem = TribeePublishPanelTypeKt.toolbarItem(TribeePublishBasePage$lambda$1(panelType$delegate));
                                    Function2<TribeePublishAction, Continuation<? super Unit>, Object> TribeePublishBasePage$lambda$52 = TribeePublishBasePage$lambda$5(handleAction$delegate);
                                    String str9 = str7;
                                    Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, f2, i3, (Object) null), Dp.constructor-impl(12), f2, 2, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart($composer5, 327025201, str8);
                                    boolean invalid$iv8 = $composer5.changedInstance(contentFocusRequester) | $composer5.changedInstance(focusManager2);
                                    Composer $this$cache$iv = $composer5;
                                    Object it$iv12 = $this$cache$iv.rememberedValue();
                                    if (!invalid$iv8 && it$iv12 != Composer.Companion.getEmpty()) {
                                        focusManager2 = focusManager2;
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        str3 = str9;
                                        str = str8;
                                        i2 = 1;
                                        $composer4 = $composer9;
                                        contentFocusRequester = contentFocusRequester;
                                        f = 0.0f;
                                        TribeeToolbarKt.TribeeToolbar(tribeeInfo, ouroStore, z2, sendToFollowing, selectedCategory, toolbarItem, (Function1) it$iv12, TribeePublishBasePage$lambda$52, modifier7, $composer5, (($dirty << 3) & 112) | 100663296, 0);
                                    }
                                    Object value$iv11 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda11
                                        public final Object invoke(Object obj) {
                                            Unit TribeePublishBasePage$lambda$19$0$4$0;
                                            TribeePublishBasePage$lambda$19$0$4$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$4$0(OuroFocusRequester.this, focusManager2, panelType$delegate, (ToolbarItem) obj);
                                            return TribeePublishBasePage$lambda$19$0$4$0;
                                        }
                                    };
                                    focusManager2 = focusManager2;
                                    $this$cache$iv.updateRememberedValue(value$iv11);
                                    it$iv12 = value$iv11;
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    str3 = str9;
                                    str = str8;
                                    i2 = 1;
                                    $composer4 = $composer9;
                                    contentFocusRequester = contentFocusRequester;
                                    f = 0.0f;
                                    TribeeToolbarKt.TribeeToolbar(tribeeInfo, ouroStore, z2, sendToFollowing, selectedCategory, toolbarItem, (Function1) it$iv12, TribeePublishBasePage$lambda$52, modifier7, $composer5, (($dirty << 3) & 112) | 100663296, 0);
                                }
                                $composer5.endReplaceGroup();
                                if (TribeePublishBasePage$hasCustomKeyboard(panelType$delegate)) {
                                    $composer5.startReplaceGroup(1548338797);
                                    ComposerKt.sourceInformation($composer5, "242@11341L12,243@11414L3,244@11460L17,238@11167L540");
                                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(Math.max(WindowInsetsKt.asPaddingValues(WindowInsetsKt.union(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer5, 6), WindowInsets_androidKt.getIme(WindowInsets.Companion, $composer5, 6)), $composer5, 0).calculateBottomPadding-D9Ej5fM(), Dp.box-impl(density.toDp-u2uoSUM(TribeePublishBasePage$lambda$17(footerHeight$delegate3))).unbox-impl()))), $composer5, 0);
                                    $composer5.endReplaceGroup();
                                } else {
                                    $composer5.startReplaceGroup(1548167832);
                                    ComposerKt.sourceInformation($composer5, "236@11052L69");
                                    BoxKt.Box(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, f, i2, (Object) null), Constant.INSTANCE.m1904getNormalHeightD9Ej5fM()), $composer5, 0);
                                    $composer5.endReplaceGroup();
                                }
                            }
                        }
                        $this$TribeePublishBasePage_u24lambda_u2419_u240 = $this$TribeePublishBasePage_u24lambda_u2419_u2402;
                        panelType$delegate2 = panelType$delegate3;
                        materialized$iv$iv = materialized$iv$iv3;
                        inputFieldFocus$delegate = inputFieldFocus$delegate3;
                        Object value$iv12 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda7
                            public final Object invoke(Object obj) {
                                Unit TribeePublishBasePage$lambda$19$0$1$0;
                                TribeePublishBasePage$lambda$19$0$1$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$1$0(inputFieldFocus$delegate, contentFocusRequester4, focusManager5, panelType$delegate2, (InputFieldFocus) obj);
                                return TribeePublishBasePage$lambda$19$0$1$0;
                            }
                        };
                        $composer10.updateRememberedValue(value$iv12);
                        it$iv9 = value$iv12;
                        Function1 function12 = (Function1) it$iv9;
                        ComposerKt.sourceInformationMarkerEnd($composer10);
                        ComposerKt.sourceInformationMarkerStart($composer10, 326976668, "CC(remember):TribeePublishBasePage.kt#9igjgp");
                        invalid$iv2 = $composer10.changedInstance(toaster) | $composer10.changed(toastStr);
                        Object it$iv102 = $composer10.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv92 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda8
                            public final Object invoke() {
                                Unit TribeePublishBasePage$lambda$19$0$2$0;
                                TribeePublishBasePage$lambda$19$0$2$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$0$2$0(Toaster.this, toastStr);
                                return TribeePublishBasePage$lambda$19$0$2$0;
                            }
                        };
                        $composer10.updateRememberedValue(value$iv92);
                        it$iv102 = value$iv92;
                        ComposerKt.sourceInformationMarkerEnd($composer10);
                        closing$delegate = closing$delegate2;
                        $composer3 = $composer10;
                        $composer$iv$iv$iv = $composer10;
                        modifier$iv$iv = modifier4;
                        checkContentOnClosing$delegate = checkContentOnClosing$delegate3;
                        MutableState panelType$delegate42 = panelType$delegate2;
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $dirty = $dirty3;
                        $this$TribeePublishBasePage_u24lambda_u2419 = $this$TribeePublishBasePage_u24lambda_u24194;
                        $composer$iv$iv = $composer10;
                        $composer$iv2 = $composer10;
                        $composer$iv3 = $composer10;
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        focusManager2 = focusManager5;
                        inputFieldFocus$delegate2 = inputFieldFocus$delegate;
                        contentFocusRequester = contentFocusRequester4;
                        scope2 = scope;
                        $composer$iv = $composer10;
                        $composer$iv4 = $composer10;
                        TribeeInputFieldsKt.TribeeInputFields(ouroStore, content, inputHint, contentShowSelectionWhenInactive, titleFocusRequester, contentFocusRequester4, function12, TribeePublishBasePage$lambda$5, (Function0) it$iv102, modifier5, $composer10, ($dirty3 & 14) | 24960 | (OuroFocusRequester.$stable << 15), 0);
                        if (TribeePublishBasePage$lambda$14(inputFieldFocus$delegate2) == InputFieldFocus.CONTENT) {
                        }
                        str7 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        $composer5 = $composer10;
                        str8 = "CC(remember):TribeePublishBasePage.kt#9igjgp";
                        $composer9 = $composer10;
                        i3 = 1;
                        f2 = 0.0f;
                        $composer5.startReplaceGroup(1537263985);
                        $composer5.endReplaceGroup();
                        panelType$delegate = panelType$delegate42;
                        if (TribeePublishBasePage$hasToolbar(panelType$delegate, inputFieldFocus$delegate2)) {
                        }
                        $composer5.endReplaceGroup();
                        if (TribeePublishBasePage$hasCustomKeyboard(panelType$delegate)) {
                        }
                    } else {
                        handleAction$delegate = handleAction$delegate4;
                        str = "CC(remember):TribeePublishBasePage.kt#9igjgp";
                        checkContentOnClosing$delegate = checkContentOnClosing$delegate3;
                        $dirty = $dirty3;
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        focusManager2 = focusManager;
                        scope2 = scope;
                        $composer$iv = $composer10;
                        contentFocusRequester = contentFocusRequester4;
                        panelType$delegate = panelType$delegate3;
                        str3 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                        $this$TribeePublishBasePage_u24lambda_u2419 = $this$TribeePublishBasePage_u24lambda_u24194;
                        $composer$iv2 = $composer10;
                        $composer3 = $composer10;
                        str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $composer$iv$iv = $composer10;
                        $composer$iv$iv$iv = $composer10;
                        $composer$iv3 = $composer10;
                        $composer4 = $composer10;
                        closing$delegate = closing$delegate2;
                        i2 = 1;
                        f = 0.0f;
                        $composer5 = $composer10;
                        $composer$iv4 = $composer10;
                        modifier$iv$iv = modifier4;
                        $composer5.startReplaceGroup(1537263985);
                    }
                    $composer5.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    if (content != null) {
                        $composer6 = $composer3;
                        $composer6.startReplaceGroup(1482024361);
                        ComposerKt.sourceInformation($composer6, "262@12163L222,272@12577L80,255@11794L902");
                        TribeeInfo tribeeInfo2 = content.getTribeeInfo();
                        List<KTribeeCategory> categories = content.getCategories();
                        KTribeeCategory selectedCategory2 = content.getSelectedCategory();
                        boolean sendToFollowing2 = content.getSendToFollowing();
                        boolean z3 = !content.getFromEdit();
                        Function2<TribeePublishAction, Continuation<? super Unit>, Object> TribeePublishBasePage$lambda$53 = TribeePublishBasePage$lambda$5(handleAction$delegate);
                        str5 = str;
                        ComposerKt.sourceInformationMarkerStart($composer6, -367823207, str5);
                        final OuroFocusRequester contentFocusRequester5 = contentFocusRequester;
                        $composer7 = $composer4;
                        final FocusManager focusManager6 = focusManager2;
                        final CoroutineScope scope6 = scope2;
                        boolean invalid$iv9 = $composer7.changedInstance(contentFocusRequester5) | $composer7.changedInstance(focusManager6) | $composer7.changedInstance(scope6) | $composer7.changedInstance(function2);
                        Object value$iv13 = $composer6.rememberedValue();
                        if (invalid$iv9 || value$iv13 == Composer.Companion.getEmpty()) {
                            scope3 = scope6;
                            focusManager3 = focusManager6;
                            final MutableState mutableState = panelType$delegate;
                            contentFocusRequester2 = contentFocusRequester5;
                            value$iv13 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda12
                                public final Object invoke() {
                                    Unit TribeePublishBasePage$lambda$19$1$0;
                                    TribeePublishBasePage$lambda$19$1$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$1$0(scope6, contentFocusRequester5, focusManager6, mutableState, function2);
                                    return TribeePublishBasePage$lambda$19$1$0;
                                }
                            };
                            $composer6.updateRememberedValue(value$iv13);
                        } else {
                            scope3 = scope6;
                            focusManager3 = focusManager6;
                            contentFocusRequester2 = contentFocusRequester5;
                        }
                        Function0 function04 = value$iv13;
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        $this$TribeePublishBasePage_u24lambda_u24192 = $this$TribeePublishBasePage_u24lambda_u2419;
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default($this$TribeePublishBasePage_u24lambda_u24192.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), f, i2, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer6, -367810101, str5);
                        Object it$iv13 = $composer6.rememberedValue();
                        if (it$iv13 == Composer.Companion.getEmpty()) {
                            footerHeight$delegate = footerHeight$delegate3;
                            Object value$iv14 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda13
                                public final Object invoke(Object obj) {
                                    Unit TribeePublishBasePage$lambda$19$2$0;
                                    TribeePublishBasePage$lambda$19$2$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$2$0(footerHeight$delegate, (IntSize) obj);
                                    return TribeePublishBasePage$lambda$19$2$0;
                                }
                            };
                            $composer6.updateRememberedValue(value$iv14);
                            it$iv13 = value$iv14;
                        } else {
                            footerHeight$delegate = footerHeight$delegate3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        FooterKt.Footer(tribeeInfo2, categories, selectedCategory2, sendToFollowing2, z3, TribeePublishBasePage$lambda$53, function04, WindowInsetsPadding_androidKt.navigationBarsPadding(OnRemeasuredModifierKt.onSizeChanged(fillMaxWidth$default, (Function1) it$iv13)), $composer6, 0, 0);
                    } else {
                        footerHeight$delegate = footerHeight$delegate3;
                        $composer6 = $composer3;
                        $this$TribeePublishBasePage_u24lambda_u24192 = $this$TribeePublishBasePage_u24lambda_u2419;
                        focusManager3 = focusManager2;
                        contentFocusRequester2 = contentFocusRequester;
                        scope3 = scope2;
                        str5 = str;
                        $composer7 = $composer4;
                        $composer6.startReplaceGroup(1470308903);
                    }
                    $composer6.endReplaceGroup();
                    OuroFocusRequester contentFocusRequester6 = contentFocusRequester2;
                    if (tribeeState instanceof TribeePublishUploading) {
                        $composer6.startReplaceGroup(1482977735);
                        ComposerKt.sourceInformation($composer6, "281@12858L62,279@12773L328");
                        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, f, 1, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer6, -367801127, str5);
                        Composer $this$cache$iv2 = $composer6;
                        Object it$iv14 = $this$cache$iv2.rememberedValue();
                        if (it$iv14 == Composer.Companion.getEmpty()) {
                            Object value$iv15 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda14
                                public final Object invoke() {
                                    Unit unit2;
                                    unit2 = Unit.INSTANCE;
                                    return unit2;
                                }
                            };
                            $this$cache$iv2.updateRememberedValue(value$iv15);
                            it$iv14 = value$iv15;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv14, 15, (Object) null);
                        Composer $composer$iv5 = $composer6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, str2);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer$iv5.getCurrentCompositionLocalMap();
                        footerHeight$delegate2 = footerHeight$delegate;
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv3);
                        Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        $this$TribeePublishBasePage_u24lambda_u24193 = $this$TribeePublishBasePage_u24lambda_u24192;
                        $composer8 = $composer7;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, str4);
                        if (!($composer$iv5.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv5.startReusableNode();
                        if ($composer$iv5.getInserting()) {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer$iv5.createNode(factory$iv$iv$iv4);
                        } else {
                            factory$iv$iv$iv4 = factory$iv$iv$iv7;
                            $composer$iv5.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv5);
                        contentFocusRequester3 = contentFocusRequester6;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                        int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        int i10 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$TribeePublishBasePage_u24lambda_u2419_u244 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, 800046512, "C286@13003L2,286@12991L14,287@13022L65:TribeePublishBasePage.kt#oim1ra");
                        ComposerKt.sourceInformationMarkerStart($composer$iv5, -944023083, str5);
                        Object it$iv15 = $composer$iv5.rememberedValue();
                        if (it$iv15 == Composer.Companion.getEmpty()) {
                            Object value$iv16 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda16
                                public final Object invoke() {
                                    Unit unit2;
                                    unit2 = Unit.INSTANCE;
                                    return unit2;
                                }
                            };
                            $composer$iv5.updateRememberedValue(value$iv16);
                            it$iv15 = value$iv16;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        BackHandlerKt.BackHandler(false, (Function0) it$iv15, $composer$iv5, 48, 1);
                        DialogsKt.PublishLoadingDialog($this$TribeePublishBasePage_u24lambda_u2419_u244.align(Modifier.Companion, Alignment.Companion.getCenter()), $composer$iv5, 0, 0);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer$iv5.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                        $composer6.endReplaceGroup();
                        checkContentOnClosing$delegate2 = checkContentOnClosing$delegate;
                    } else {
                        footerHeight$delegate2 = footerHeight$delegate;
                        $this$TribeePublishBasePage_u24lambda_u24193 = $this$TribeePublishBasePage_u24lambda_u24192;
                        contentFocusRequester3 = contentFocusRequester6;
                        $composer8 = $composer7;
                        String str10 = str4;
                        String str11 = str2;
                        if (tribeeState instanceof TribeePublishInitLoading) {
                            $composer6.startReplaceGroup(1483374969);
                            ComposerKt.sourceInformation($composer6, "292@13261L62,290@13176L246");
                            Modifier fillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer6, -367788231, str5);
                            Composer $this$cache$iv3 = $composer6;
                            Object it$iv16 = $this$cache$iv3.rememberedValue();
                            if (it$iv16 == Composer.Companion.getEmpty()) {
                                Object value$iv17 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda17
                                    public final Object invoke() {
                                        Unit unit2;
                                        unit2 = Unit.INSTANCE;
                                        return unit2;
                                    }
                                };
                                $this$cache$iv3.updateRememberedValue(value$iv17);
                                it$iv16 = value$iv17;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            Modifier modifier$iv$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv16, 15, (Object) null);
                            Composer $composer$iv6 = $composer6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
                            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                            int $changed$iv$iv4 = (0 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, -1159599143, str11);
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv6, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer$iv6.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv6, modifier$iv$iv2);
                            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, -553112988, str10);
                            if (!($composer$iv6.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv6.startReusableNode();
                            if ($composer$iv6.getInserting()) {
                                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                $composer$iv6.createNode(factory$iv$iv$iv3);
                            } else {
                                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                $composer$iv6.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv6);
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                            int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i12 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, -1776568519, "C297@13406L2,297@13394L14:TribeePublishBasePage.kt#oim1ra");
                            ComposerKt.sourceInformationMarkerStart($composer$iv6, -57308290, str5);
                            Object it$iv17 = $composer$iv6.rememberedValue();
                            if (it$iv17 == Composer.Companion.getEmpty()) {
                                Object value$iv18 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda18
                                    public final Object invoke() {
                                        Unit unit2;
                                        unit2 = Unit.INSTANCE;
                                        return unit2;
                                    }
                                };
                                $composer$iv6.updateRememberedValue(value$iv18);
                                it$iv17 = value$iv18;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            BackHandlerKt.BackHandler(false, (Function0) it$iv17, $composer$iv6, 48, 1);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            $composer$iv6.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                            $composer6.endReplaceGroup();
                            checkContentOnClosing$delegate2 = checkContentOnClosing$delegate;
                        } else {
                            if (tribeeState instanceof TribeePublishContent) {
                                $composer6.startReplaceGroup(1483683915);
                                ComposerKt.sourceInformation($composer6, "300@13534L27,300@13493L68");
                                boolean booleanValue = ((Boolean) function0.invoke()).booleanValue();
                                ComposerKt.sourceInformationMarkerStart($composer6, -367779530, str5);
                                checkContentOnClosing$delegate2 = checkContentOnClosing$delegate;
                                boolean invalid$iv10 = $composer6.changed(checkContentOnClosing$delegate2);
                                Composer $this$cache$iv4 = $composer6;
                                Object it$iv18 = $this$cache$iv4.rememberedValue();
                                if (invalid$iv10 || it$iv18 == Composer.Companion.getEmpty()) {
                                    Object value$iv19 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda19
                                        public final Object invoke() {
                                            Unit TribeePublishBasePage$lambda$19$7$0;
                                            TribeePublishBasePage$lambda$19$7$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$7$0(checkContentOnClosing$delegate2);
                                            return TribeePublishBasePage$lambda$19$7$0;
                                        }
                                    };
                                    $this$cache$iv4.updateRememberedValue(value$iv19);
                                    it$iv18 = value$iv19;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                BackHandlerKt.BackHandler(booleanValue, (Function0) it$iv18, $composer6, 0, 0);
                            } else {
                                checkContentOnClosing$delegate2 = checkContentOnClosing$delegate;
                                $composer6.startReplaceGroup(1470308903);
                            }
                            $composer6.endReplaceGroup();
                        }
                    }
                    if (tribeeState instanceof TribeePublishContent) {
                        $composer6.startReplaceGroup(1484101206);
                        ComposerKt.sourceInformation($composer6, "");
                        switch (WhenMappings.$EnumSwitchMapping$0[TribeePublishBasePage$lambda$1(panelType$delegate).ordinal()]) {
                            case 1:
                                $composer2 = $composer8;
                                final OuroFocusRequester contentFocusRequester7 = contentFocusRequester3;
                                scope4 = scope3;
                                final FocusManager focusManager7 = focusManager3;
                                $composer6.startReplaceGroup(1488721260);
                                ComposerKt.sourceInformation($composer6, "394@18770L19,395@18827L44,397@18980L30,390@18566L467");
                                long mid = mid(TribeePublishBasePage$lambda$8(accountState$delegate));
                                ComposerKt.sourceInformationMarkerStart($composer6, -367611986, str5);
                                boolean invalid$iv11 = $composer2.changedInstance(ouroStore);
                                Composer $this$cache$iv5 = $composer6;
                                Object it$iv19 = $this$cache$iv5.rememberedValue();
                                if (invalid$iv11 || it$iv19 == Composer.Companion.getEmpty()) {
                                    Object value$iv20 = (KFunction) new TribeePublishBasePageKt$TribeePublishBasePage$2$14$1(ouroStore);
                                    $this$cache$iv5.updateRememberedValue(value$iv20);
                                    it$iv19 = value$iv20;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                Function1 function13 = (KFunction) it$iv19;
                                ComposerKt.sourceInformationMarkerStart($composer6, -367610137, str5);
                                boolean invalid$iv12 = $composer6.changedInstance(contentFocusRequester7) | $composer6.changedInstance(focusManager7);
                                Composer $this$cache$iv6 = $composer6;
                                Object it$iv20 = $this$cache$iv6.rememberedValue();
                                if (invalid$iv12 || it$iv20 == Composer.Companion.getEmpty()) {
                                    Object value$iv21 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda22
                                        public final Object invoke() {
                                            Unit TribeePublishBasePage$lambda$19$14$0;
                                            TribeePublishBasePage$lambda$19$14$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$14$0(OuroFocusRequester.this, focusManager7, panelType$delegate);
                                            return TribeePublishBasePage$lambda$19$14$0;
                                        }
                                    };
                                    $this$cache$iv6.updateRememberedValue(value$iv21);
                                    it$iv20 = value$iv21;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                StickerPanelKt.StickerPanel("tribee", mid, insertTextStyle, function13, (Function0) it$iv20, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ExpandablePanelStateKt.rememberExpandablePanelState(null, false, null, null, $composer6, 0, 15), $composer6, 196614, 0);
                                $composer6.endReplaceGroup();
                                Unit unit2 = Unit.INSTANCE;
                                break;
                            case 2:
                                $composer2 = $composer8;
                                scope4 = scope3;
                                $composer6.startReplaceGroup(1489289521);
                                ComposerKt.sourceInformation($composer6, "409@19477L442,402@19128L814");
                                Modifier align = $this$TribeePublishBasePage_u24lambda_u24193.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Constant.INSTANCE.m1904getNormalHeightD9Ej5fM()), Alignment.Companion.getBottomCenter());
                                ComposerKt.sourceInformationMarkerStart($composer6, -367588939, str5);
                                boolean invalid$iv13 = $composer2.changedInstance(scope4) | $composer2.changedInstance(function2);
                                Composer $this$cache$iv7 = $composer6;
                                Object it$iv21 = $this$cache$iv7.rememberedValue();
                                if (!invalid$iv13) {
                                    break;
                                }
                                Object value$iv22 = new Function2() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda23
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit TribeePublishBasePage$lambda$19$15$0;
                                        TribeePublishBasePage$lambda$19$15$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$15$0(scope4, function2, (TextStylePanelEvent) obj, ((Boolean) obj2).booleanValue());
                                        return TribeePublishBasePage$lambda$19$15$0;
                                    }
                                };
                                $this$cache$iv7.updateRememberedValue(value$iv22);
                                it$iv21 = value$iv22;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                TextStylePanelKt.TextStylePanel(ouroStore, align, (Function2) it$iv21, $composer6, $dirty & 14, 0);
                                $composer6.endReplaceGroup();
                                Unit unit3 = Unit.INSTANCE;
                                break;
                            case 3:
                                State handleAction$delegate5 = handleAction$delegate;
                                Composer $composer11 = $composer8;
                                scope4 = scope3;
                                $composer6.startReplaceGroup(1490196364);
                                ComposerKt.sourceInformation($composer6, "430@20396L442,423@20042L819");
                                Modifier align2 = $this$TribeePublishBasePage_u24lambda_u24193.align(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Constant.INSTANCE.m1904getNormalHeightD9Ej5fM()), Alignment.Companion.getBottomCenter());
                                ComposerKt.sourceInformationMarkerStart($composer6, -367559531, str5);
                                boolean invalid$iv14 = $composer11.changedInstance(scope4) | $composer11.changedInstance(function2);
                                Composer $this$cache$iv8 = $composer6;
                                Object it$iv22 = $this$cache$iv8.rememberedValue();
                                if (!invalid$iv14) {
                                    break;
                                }
                                Object value$iv23 = new Function2() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda0
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit TribeePublishBasePage$lambda$19$16$0;
                                        TribeePublishBasePage$lambda$19$16$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$16$0(scope4, function2, (ParagraphStylePanelEvent) obj, ((Boolean) obj2).booleanValue());
                                        return TribeePublishBasePage$lambda$19$16$0;
                                    }
                                };
                                $this$cache$iv8.updateRememberedValue(value$iv23);
                                it$iv22 = value$iv23;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                $composer2 = $composer11;
                                handleAction$delegate = handleAction$delegate5;
                                ParagraphStylePanelKt.ParagraphStylePanel(ouroStore, align2, (Function2) it$iv22, $composer6, $dirty & 14, 0);
                                $composer6.endReplaceGroup();
                                Unit unit4 = Unit.INSTANCE;
                                break;
                            case 4:
                            default:
                                $composer2 = $composer8;
                                scope4 = scope3;
                                $composer6.startReplaceGroup(1492281765);
                                $composer6.endReplaceGroup();
                                Unit unit5 = Unit.INSTANCE;
                                break;
                            case 5:
                                State handleAction$delegate6 = handleAction$delegate;
                                final OuroFocusRequester contentFocusRequester8 = contentFocusRequester3;
                                scope4 = scope3;
                                final FocusManager focusManager8 = focusManager3;
                                $composer6.startReplaceGroup(1484051730);
                                ComposerKt.sourceInformation($composer6, "307@13775L78,324@14784L1080,342@15953L1159,362@17180L19,382@18211L240,363@17237L161,367@17434L640,309@13940L4534");
                                String toastOnSizeExceeded = StringResourcesKt.stringResource(String1_commonMainKt.getFollowing_global_string_756(Res.string.INSTANCE), $composer6, 0);
                                int min = Math.min(getIMAGE_PICKER_MAX_SELECT_COUNT(), ((int) ((TribeePublishContent) tribeeState).getLimitInfo().getPicMaxNum()) - ((TribeePublishContent) tribeeState).getContent().getPictureCount());
                                int min2 = Math.min(getIMAGE_PICKER_MAX_SELECT_COUNT(), (int) ((TribeePublishContent) tribeeState).getLimitInfo().getPicMaxNum());
                                ComposerKt.sourceInformationMarkerStart($composer6, -367738477, str5);
                                Composer $this$cache$iv9 = $composer6;
                                Object value$iv24 = $this$cache$iv9.rememberedValue();
                                if (value$iv24 == Composer.Companion.getEmpty()) {
                                    String config = KConfig.INSTANCE.config("tribee_image_max_size_limit_mb", "");
                                    float maxMB = (config == null || (floatOrNull4 = StringsKt.toFloatOrNull(config)) == null) ? 20.0f : floatOrNull4.floatValue();
                                    String config2 = KConfig.INSTANCE.config("tribee_animated_image_max_size_limit_mb", "");
                                    float maxMBForAnimatedImage = (config2 == null || (floatOrNull3 = StringsKt.toFloatOrNull(config2)) == null) ? 8.0f : floatOrNull3.floatValue();
                                    value$iv24 = new ContentSizeLimit(ContentSizeKt.megabytes(Float.valueOf(maxMB)), toastOnSizeExceeded, ContentSizeKt.megabytes(Float.valueOf(maxMBForAnimatedImage)), null, 8, null);
                                    $this$cache$iv9.updateRememberedValue(value$iv24);
                                }
                                ContentSizeLimit contentSizeLimit = (ContentSizeLimit) value$iv24;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerStart($composer6, -367700990, str5);
                                Composer $this$cache$iv10 = $composer6;
                                Object it$iv23 = $this$cache$iv10.rememberedValue();
                                if (it$iv23 == Composer.Companion.getEmpty()) {
                                    String config3 = KConfig.INSTANCE.config("tribee_image_min_aspect_radio_limit", "");
                                    float minAspectRadio = (config3 == null || (floatOrNull2 = StringsKt.toFloatOrNull(config3)) == null) ? 0.033333335f : floatOrNull2.floatValue();
                                    String config4 = KConfig.INSTANCE.config("tribee_image_max_aspect_radio_limit", "");
                                    float maxAspectRadio = (config4 == null || (floatOrNull = StringsKt.toFloatOrNull(config4)) == null) ? 12.0f : floatOrNull.floatValue();
                                    Object value$iv25 = new AspectRadioLimit(minAspectRadio, maxAspectRadio, "请上传合适尺寸的图片");
                                    $this$cache$iv10.updateRememberedValue(value$iv25);
                                    it$iv23 = value$iv25;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                AphroSelectOption aphroSelectOption = new AphroSelectOption(min, min2, false, null, null, false, false, false, contentSizeLimit, (AspectRadioLimit) it$iv23, 188, null);
                                ComposerKt.sourceInformationMarkerStart($composer6, -367662866, str5);
                                Composer $composer12 = $composer8;
                                boolean invalid$iv15 = $composer12.changedInstance(ouroStore);
                                Composer $this$cache$iv11 = $composer6;
                                Object value$iv26 = $this$cache$iv11.rememberedValue();
                                if (!invalid$iv15) {
                                    break;
                                }
                                value$iv26 = (KFunction) new TribeePublishBasePageKt$TribeePublishBasePage$2$11$1(ouroStore);
                                $this$cache$iv11.updateRememberedValue(value$iv26);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                ExpandablePanelState rememberExpandablePanelState = ExpandablePanelStateKt.rememberExpandablePanelState(ExpandablePanelState.Style.Expanded, false, new ExpandablePanelState.Anchor.AbsoluteHeight(Dp.constructor-impl(0), null), null, $composer6, (ExpandablePanelState.Anchor.AbsoluteHeight.$stable << 6) | 6, 10);
                                Function1 function14 = (KFunction) value$iv26;
                                ComposerKt.sourceInformationMarkerStart($composer6, -367660900, str5);
                                boolean invalid$iv16 = $composer6.changedInstance(contentFocusRequester8) | $composer6.changedInstance(focusManager8);
                                Composer $this$cache$iv12 = $composer6;
                                Object it$iv24 = $this$cache$iv12.rememberedValue();
                                if (!invalid$iv16) {
                                    break;
                                }
                                Object value$iv27 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda20
                                    public final Object invoke() {
                                        Unit TribeePublishBasePage$lambda$19$11$0;
                                        TribeePublishBasePage$lambda$19$11$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$11$0(OuroFocusRequester.this, focusManager8, panelType$delegate);
                                        return TribeePublishBasePage$lambda$19$11$0;
                                    }
                                };
                                $this$cache$iv12.updateRememberedValue(value$iv27);
                                it$iv24 = value$iv27;
                                Function0 function05 = (Function0) it$iv24;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerStart($composer6, -367654117, str5);
                                boolean invalid$iv17 = $composer12.changedInstance(scope4) | $composer12.changedInstance(function2);
                                Composer $this$cache$iv13 = $composer6;
                                Object it$iv25 = $this$cache$iv13.rememberedValue();
                                if (!invalid$iv17) {
                                    break;
                                }
                                Object value$iv28 = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda21
                                    public final Object invoke(Object obj) {
                                        Unit TribeePublishBasePage$lambda$19$12$0;
                                        TribeePublishBasePage$lambda$19$12$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$12$0(scope4, function2, (AlbumPanelEvent) obj);
                                        return TribeePublishBasePage$lambda$19$12$0;
                                    }
                                };
                                $this$cache$iv13.updateRememberedValue(value$iv28);
                                it$iv25 = value$iv28;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                AlbumPanelKt.AlbumPanel(aphroSelectOption, function14, function05, fillMaxWidth$default2, (Function1) it$iv25, rememberExpandablePanelState, $composer6, AphroSelectOption.$stable | 3072, 0);
                                $composer6.endReplaceGroup();
                                Unit unit6 = Unit.INSTANCE;
                                handleAction$delegate = handleAction$delegate6;
                                $composer2 = $composer12;
                                break;
                            case 6:
                                $composer6.startReplaceGroup(1491110399);
                                ComposerKt.sourceInformation($composer6, "");
                                if (content != null) {
                                    $composer6.startReplaceGroup(1491151164);
                                    ComposerKt.sourceInformation($composer6, "448@21149L357,453@21555L44,454@21627L456,445@21000L1083");
                                    Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                    ExpandablePanelState rememberExpandablePanelState2 = ExpandablePanelStateKt.rememberExpandablePanelState(ExpandablePanelState.Style.Expanded, false, new ExpandablePanelState.Anchor.AbsoluteHeight(Dp.constructor-impl(0), null), new ExpandablePanelState.Anchor.AbsoluteHeight(Dp.constructor-impl(300), null), $composer6, (ExpandablePanelState.Anchor.AbsoluteHeight.$stable << 6) | 6 | (ExpandablePanelState.Anchor.AbsoluteHeight.$stable << 9), 2);
                                    ComposerKt.sourceInformationMarkerStart($composer6, -367522841, str5);
                                    final OuroFocusRequester contentFocusRequester9 = contentFocusRequester3;
                                    final FocusManager focusManager9 = focusManager3;
                                    boolean invalid$iv18 = $composer6.changedInstance(contentFocusRequester9) | $composer6.changedInstance(focusManager9);
                                    Composer $this$cache$iv14 = $composer6;
                                    Object it$iv26 = $this$cache$iv14.rememberedValue();
                                    if (invalid$iv18 || it$iv26 == Composer.Companion.getEmpty()) {
                                        Object value$iv29 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda1
                                            public final Object invoke() {
                                                Unit TribeePublishBasePage$lambda$19$17$0;
                                                TribeePublishBasePage$lambda$19$17$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$17$0(OuroFocusRequester.this, focusManager9, panelType$delegate);
                                                return TribeePublishBasePage$lambda$19$17$0;
                                            }
                                        };
                                        $this$cache$iv14.updateRememberedValue(value$iv29);
                                        it$iv26 = value$iv29;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd($composer6);
                                    handleAction$delegate3 = handleAction$delegate;
                                    scope4 = scope3;
                                    ExpandablePanelKt.ExpandablePanel(fillMaxWidth$default3, rememberExpandablePanelState2, (Function0) it$iv26, ComposableLambdaKt.rememberComposableLambda(-881653463, true, new Function2() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit TribeePublishBasePage$lambda$19$18;
                                            TribeePublishBasePage$lambda$19$18 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$18(TribeePublishContent.this, scope4, handleAction$delegate3, (Composer) obj, ((Integer) obj2).intValue());
                                            return TribeePublishBasePage$lambda$19$18;
                                        }
                                    }, $composer6, 54), $composer6, 3078, 0);
                                } else {
                                    handleAction$delegate3 = handleAction$delegate;
                                    scope4 = scope3;
                                    $composer6.startReplaceGroup(1470308903);
                                }
                                $composer6.endReplaceGroup();
                                $composer6.endReplaceGroup();
                                Unit unit7 = Unit.INSTANCE;
                                handleAction$delegate = handleAction$delegate3;
                                $composer2 = $composer8;
                                break;
                        }
                    } else {
                        $composer2 = $composer8;
                        scope4 = scope3;
                        $composer6.startReplaceGroup(1470308903);
                    }
                    $composer6.endReplaceGroup();
                    TribeePublishContent publishContent = tribeeState.getPublishContent();
                    if (publishContent != null && publishContent.getShowPublishConfirmDialog()) {
                        $composer6.startReplaceGroup(1492405052);
                        ComposerKt.sourceInformation($composer6, "474@22320L282,483@22631L155,473@22270L531");
                        ComposerKt.sourceInformationMarkerStart($composer6, -367498123, str5);
                        handleAction$delegate2 = handleAction$delegate;
                        boolean invalid$iv19 = $composer6.changedInstance(scope4) | $composer6.changed(handleAction$delegate2);
                        Composer $this$cache$iv15 = $composer6;
                        Object it$iv27 = $this$cache$iv15.rememberedValue();
                        if (invalid$iv19) {
                        }
                        Object value$iv30 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit TribeePublishBasePage$lambda$19$19$0;
                                TribeePublishBasePage$lambda$19$19$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$19$0(scope4, handleAction$delegate2);
                                return TribeePublishBasePage$lambda$19$19$0;
                            }
                        };
                        $this$cache$iv15.updateRememberedValue(value$iv30);
                        it$iv27 = value$iv30;
                        Function0 function06 = (Function0) it$iv27;
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerStart($composer6, -367488298, str5);
                        boolean invalid$iv20 = $composer6.changedInstance(scope4) | $composer6.changed(handleAction$delegate2);
                        Composer $this$cache$iv16 = $composer6;
                        Object it$iv28 = $this$cache$iv16.rememberedValue();
                        if (invalid$iv20) {
                        }
                        Object value$iv31 = new Function0() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit TribeePublishBasePage$lambda$19$20$0;
                                TribeePublishBasePage$lambda$19$20$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$20$0(scope4, handleAction$delegate2);
                                return TribeePublishBasePage$lambda$19$20$0;
                            }
                        };
                        $this$cache$iv16.updateRememberedValue(value$iv31);
                        it$iv28 = value$iv31;
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        DialogsKt.PublishConfirmDialog(function06, (Function0) it$iv28, null, $composer6, 0, 4);
                    } else {
                        handleAction$delegate2 = handleAction$delegate;
                        $composer6.startReplaceGroup(1470308903);
                    }
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer10.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    ComposerKt.sourceInformationMarkerEnd($composer10);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    CompositionLocal this_$iv7 = ToasterKt.getLocalToaster();
                    Composer $composer$iv7 = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv7, 2023513938, str3);
                    Object consume4 = $composer$iv7.consume(this_$iv7);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv7);
                    Toaster toaster2 = (Toaster) consume4;
                    BSimpleLens<TribeePublishState, String> editToast = tribeeState.getEditToast();
                    if (editToast != null) {
                        tribeePublishState = tribeeState;
                        str6 = (String) editToast.get(tribeePublishState);
                    } else {
                        tribeePublishState = tribeeState;
                        str6 = null;
                    }
                    String toast = (String) SnapshotStateKt.rememberUpdatedState(str6, $composer2, 0).getValue();
                    ComposerKt.sourceInformationMarkerStart($composer2, 311228780, str5);
                    boolean invalid$iv21 = $composer2.changed(toast) | $composer2.changedInstance(toaster2) | $composer2.changed(handleAction$delegate2);
                    Composer $this$cache$iv17 = $composer2;
                    Object it$iv29 = $this$cache$iv17.rememberedValue();
                    if (!invalid$iv21 && it$iv29 != Composer.Companion.getEmpty()) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(toast, (Function2) it$iv29, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, 311234639, str5);
                        State closing$delegate3 = closing$delegate;
                        invalid$iv = $composer2.changedInstance(tribeePublishState) | $composer2.changed(closing$delegate3);
                        Composer $this$cache$iv18 = $composer2;
                        Object it$iv30 = $this$cache$iv18.rememberedValue();
                        if (!invalid$iv && it$iv30 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(tribeePublishState, (Function2) it$iv30, $composer2, ($dirty >> 3) & 14);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        Object value$iv32 = (Function2) new TribeePublishBasePageKt$TribeePublishBasePage$4$1(tribeePublishState, closing$delegate3, null);
                        $this$cache$iv18.updateRememberedValue(value$iv32);
                        it$iv30 = value$iv32;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(tribeePublishState, (Function2) it$iv30, $composer2, ($dirty >> 3) & 14);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv33 = (Function2) new TribeePublishBasePageKt$TribeePublishBasePage$3$1(toast, toaster2, handleAction$delegate2, null);
                    $this$cache$iv17.updateRememberedValue(value$iv33);
                    it$iv29 = value$iv33;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(toast, (Function2) it$iv29, $composer2, 0);
                    ComposerKt.sourceInformationMarkerStart($composer2, 311234639, str5);
                    State closing$delegate32 = closing$delegate;
                    invalid$iv = $composer2.changedInstance(tribeePublishState) | $composer2.changed(closing$delegate32);
                    Composer $this$cache$iv182 = $composer2;
                    Object it$iv302 = $this$cache$iv182.rememberedValue();
                    if (!invalid$iv) {
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(tribeePublishState, (Function2) it$iv302, $composer2, ($dirty >> 3) & 14);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv322 = (Function2) new TribeePublishBasePageKt$TribeePublishBasePage$4$1(tribeePublishState, closing$delegate32, null);
                    $this$cache$iv182.updateRememberedValue(value$iv322);
                    it$iv302 = value$iv322;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    EffectsKt.LaunchedEffect(tribeePublishState, (Function2) it$iv302, $composer2, ($dirty >> 3) & 14);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                OuroState this_$iv8 = TribeePublishBasePage$lambda$9(ouroState$delegate);
                KClass key$iv4 = Reflection.getOrCreateKotlinClass(OuroTextStylePlugin.class);
                OuroPluginState ouroPluginState4 = this_$iv8.getPluginStates().get(key$iv4);
                scope = scope5;
                if (!(ouroPluginState4 instanceof OuroTextStyleState)) {
                    ouroPluginState4 = null;
                }
                OuroTextStyleState ouroTextStyleState2 = (OuroTextStyleState) ouroPluginState4;
                if (ouroTextStyleState2 == null) {
                    throw new NoSuchElementException("No plugin state for " + key$iv4);
                }
                Object value$iv34 = ouroTextStyleState2.getInsertTextStyle();
                $composer10.updateRememberedValue(value$iv34);
                it$iv3 = value$iv34;
                OuroTextStyle insertTextStyle2 = (OuroTextStyle) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer10);
                OuroState this_$iv32 = TribeePublishBasePage$lambda$9(ouroState$delegate);
                KClass key$iv32 = Reflection.getOrCreateKotlinClass(OuroAtMentionPlugin.class);
                ouroPluginState2 = this_$iv32.getPluginStates().get(key$iv32);
                if (!(ouroPluginState2 instanceof OuroAtMentionState)) {
                }
                ouroAtMentionState = (OuroAtMentionState) ouroPluginState2;
                if (ouroAtMentionState != null) {
                }
            }
            Object obj = (Function2) new TribeePublishBasePageKt$TribeePublishBasePage$1$1(pvTrigger, null);
            $composer10.updateRememberedValue(obj);
            value$iv = obj;
            ComposerKt.sourceInformationMarkerEnd($composer10);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer10, 6);
            ComposerKt.sourceInformationMarkerStart($composer10, 310683267, "CC(remember):TribeePublishBasePage.kt#9igjgp");
            value$iv2 = $composer10.rememberedValue();
            if (value$iv2 != Composer.Companion.getEmpty()) {
            }
            KAccountStore accountStore2 = (KAccountStore) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer10);
            State accountState$delegate2 = SnapshotStateKt.collectAsState(accountStore2.getState(), (CoroutineContext) null, $composer10, 0, 1);
            State ouroState$delegate2 = SnapshotStateKt.collectAsState(ouroStore.getStateFlow(), (CoroutineContext) null, $composer10, 0, 1);
            OuroState this_$iv9 = TribeePublishBasePage$lambda$9(ouroState$delegate2);
            KClass key$iv5 = Reflection.getOrCreateKotlinClass(OuroHistoryPlugin.class);
            ouroPluginState = this_$iv9.getPluginStates().get(key$iv5);
            if (!(ouroPluginState instanceof OuroHistoryState)) {
            }
            if (((OuroHistoryState) ouroPluginState) != null) {
            }
        } else {
            $composer2 = $composer10;
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier$iv$iv;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TribeePublishBasePage$lambda$22;
                    TribeePublishBasePage$lambda$22 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$22(OuroStore.this, tribeeState, function0, function02, function03, function2, modifier8, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeePublishBasePage$lambda$22;
                }
            });
        }
    }

    private static final TribeePublishPanelType TribeePublishBasePage$lambda$1(MutableState<TribeePublishPanelType> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (TribeePublishPanelType) $this$getValue$iv.getValue();
    }

    private static final Function0<Unit> TribeePublishBasePage$lambda$3(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> TribeePublishBasePage$lambda$4(State<? extends Function0<Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function0) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<TribeePublishAction, Continuation<? super Unit>, Object> TribeePublishBasePage$lambda$5(State<? extends Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }

    private static final AccountState TribeePublishBasePage$lambda$8(State<? extends AccountState> state) {
        Object thisObj$iv = state.getValue();
        return (AccountState) thisObj$iv;
    }

    private static final OuroState TribeePublishBasePage$lambda$9(State<OuroState> state) {
        Object thisObj$iv = state.getValue();
        return (OuroState) thisObj$iv;
    }

    private static final InputFieldFocus TribeePublishBasePage$lambda$14(MutableState<InputFieldFocus> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (InputFieldFocus) $this$getValue$iv.getValue();
    }

    private static final int TribeePublishBasePage$lambda$17(MutableIntState $footerHeight$delegate) {
        IntState $this$getValue$iv = (IntState) $footerHeight$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final boolean TribeePublishBasePage$hasCustomKeyboard(MutableState<TribeePublishPanelType> mutableState) {
        switch (WhenMappings.$EnumSwitchMapping$0[TribeePublishBasePage$lambda$1(mutableState).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private static final void TribeePublishBasePage$updatePanel(OuroFocusRequester contentFocusRequester, FocusManager focusManager, MutableState<TribeePublishPanelType> mutableState, TribeePublishPanelType newValue) {
        if (newValue != TribeePublishPanelType.NONE) {
            if (TribeePublishBasePage$lambda$1(mutableState) == newValue) {
                mutableState.setValue(TribeePublishPanelType.NONE);
                contentFocusRequester.requestFocus();
                return;
            }
            mutableState.setValue(newValue);
            TribeeInputFieldsHelper_androidKt.handlePanelShow(focusManager);
            OuroFocusRequester.freeFocus$default(contentFocusRequester, false, TribeePublishBasePage$hasCustomKeyboard(mutableState), 1, null);
            return;
        }
        mutableState.setValue(newValue);
    }

    private static final boolean TribeePublishBasePage$hasToolbar(MutableState<TribeePublishPanelType> mutableState, MutableState<InputFieldFocus> mutableState2) {
        switch (WhenMappings.$EnumSwitchMapping$0[TribeePublishBasePage$lambda$1(mutableState).ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                return TribeePublishBasePage$lambda$14(mutableState2) == InputFieldFocus.CONTENT;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$0$0$0(Function0 $needCheckContentOnClosing, State $checkContentOnClosing$delegate, State $closing$delegate) {
        (((Boolean) $needCheckContentOnClosing.invoke()).booleanValue() ? TribeePublishBasePage$lambda$3($checkContentOnClosing$delegate) : TribeePublishBasePage$lambda$4($closing$delegate)).invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$0$2$0(Toaster $toaster, String $toastStr) {
        Toaster.CC.showToast$default($toaster, $toastStr, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$0$1$0(MutableState $inputFieldFocus$delegate, OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate, InputFieldFocus it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $inputFieldFocus$delegate.setValue(it);
        if (it == InputFieldFocus.TITLE || it == InputFieldFocus.CONTENT) {
            TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelType.NONE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$0$3$0(OuroStore $ouroStore, OuroAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $ouroStore.dispatch(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$0$4$0(OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate, ToolbarItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelTypeKt.tribeePublishPanelType(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$1$0(CoroutineScope $scope, OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate, Function2 $onAction) {
        TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelType.SETTING);
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$2$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$2$0(MutableIntState $footerHeight$delegate, IntSize it) {
        $footerHeight$delegate.setIntValue((int) (4294967295L & it.unbox-impl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$7$0(State $checkContentOnClosing$delegate) {
        TribeePublishBasePage$lambda$3($checkContentOnClosing$delegate).invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$11$0(OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate) {
        TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelType.NONE);
        $contentFocusRequester.requestFocus();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$12$0(CoroutineScope $scope, Function2 $onAction, AlbumPanelEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$13$1$1($onAction, it, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$14$0(OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate) {
        TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelType.NONE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$15$0(CoroutineScope $scope, Function2 $onAction, TextStylePanelEvent event, boolean isSelected) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$16$1$1($onAction, event, isSelected, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$16$0(CoroutineScope $scope, Function2 $onAction, ParagraphStylePanelEvent event, boolean isSelected) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$17$1$1($onAction, event, isSelected, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$17$0(OuroFocusRequester $contentFocusRequester, FocusManager $focusManager, MutableState $panelType$delegate) {
        TribeePublishBasePage$updatePanel($contentFocusRequester, $focusManager, $panelType$delegate, TribeePublishPanelType.NONE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$18(TribeePublishContent $content, final CoroutineScope $scope, final State $handleAction$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C456@21747L181,*462@22009L18:TribeePublishBasePage.kt#oim1ra");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-881653463, $changed, -1, "kntr.app.tribee.publish.ui.v2.TribeePublishBasePage.<anonymous>.<anonymous> (TribeePublishBasePage.kt:455)");
            }
            Map<KUpPermissionType, TribeePublishSettingItem> settingItems = $content.getSettingItems();
            ComposerKt.sourceInformationMarkerStart($composer, -1160416610, "CC(remember):TribeePublishBasePage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($handleAction$delegate);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.publish.ui.v2.TribeePublishBasePageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit TribeePublishBasePage$lambda$19$18$0$0;
                        TribeePublishBasePage$lambda$19$18$0$0 = TribeePublishBasePageKt.TribeePublishBasePage$lambda$19$18$0$0($scope, $handleAction$delegate, (TribeePublishAction) obj);
                        return TribeePublishBasePage$lambda$19$18$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Iterable sections = SettingItemTransformKt.toSections(settingItems, (Function1) it$iv);
            Iterable $this$forEach$iv = sections;
            for (Object element$iv : $this$forEach$iv) {
                SettingSectionItem it = (SettingSectionItem) element$iv;
                SettingSectionKt.SettingSection(it, null, $composer, SettingSectionItem.$stable, 2);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$18$0$0(CoroutineScope $scope, State $handleAction$delegate, TribeePublishAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$19$sections$1$1$1(it, $handleAction$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$19$0(CoroutineScope $scope, State $handleAction$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$20$1$1($handleAction$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePublishBasePage$lambda$19$20$0(CoroutineScope $scope, State $handleAction$delegate) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeePublishBasePageKt$TribeePublishBasePage$2$21$1$1($handleAction$delegate, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final long mid(AccountState $this$mid) {
        Intrinsics.checkNotNullParameter($this$mid, "<this>");
        if ($this$mid instanceof AccountState.Idle) {
            return 0L;
        }
        if ($this$mid instanceof AccountState.Logged) {
            return ((AccountState.Logged) $this$mid).getUserInfo().getMid();
        }
        throw new NoWhenBranchMatchedException();
    }
}