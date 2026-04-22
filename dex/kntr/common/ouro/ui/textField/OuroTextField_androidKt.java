package kntr.common.ouro.ui.textField;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.kntr.srcs_common_ouroboros_editor_ui_ouro_ui_library_android.R;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.OuroStore;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.core.plugin.pasteboard.OuroCopyAction;
import kntr.common.ouro.core.plugin.pasteboard.OuroCutAction;
import kntr.common.ouro.core.plugin.pasteboard.OuroPasteAction;
import kntr.common.ouro.ui.utils.SpannableStringBuilderContext;
import kntr.common.ouro.ui.utils.SpannableStringBuilderUtilsKt;
import kntr.common.ouro.ui.utils.TextRangeUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;

/* compiled from: OuroTextField.android.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0015X\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002²\u0006\f\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"OuroTextField", "", "store", "Lkntr/common/ouro/core/OuroStore;", "focusRequester", "Lkntr/common/ouro/ui/textField/OuroFocusRequester;", "onKeyboardShow", "Lkotlin/Function1;", "", "didScroll", "Landroidx/compose/ui/unit/Dp;", "onContentHeightChange", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "hintText", "Lkntr/common/ouro/ui/textField/HintText;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/ouro/core/OuroStore;Lkntr/common/ouro/ui/textField/OuroFocusRequester;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/layout/PaddingValues;Lkntr/common/ouro/ui/textField/HintText;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug", "ouroState", "Lkntr/common/ouro/core/OuroState;", "mainAxisLength", "", "scrollView", "Lkntr/common/ouro/ui/textField/OuroEditScrollView;", "visibleTop", "visibleHeight", "editTextHeight"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextField_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroTextField$lambda$34(OuroStore ouroStore, OuroFocusRequester ouroFocusRequester, Function1 function1, Function1 function12, Function1 function13, PaddingValues paddingValues, HintText hintText, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OuroTextField(ouroStore, ouroFocusRequester, function1, function12, function13, paddingValues, hintText, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0313, code lost:
        if (r2 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0356, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x039b, code lost:
        if (r15 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x03f2, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0453, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x04b9, code lost:
        if (r12 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x051f, code lost:
        if (r13 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0588, code lost:
        if (r11 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x05c7, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L139;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03f6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0517  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0580  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05bf  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05cb  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x066e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0741  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x07a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x07ee  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x083b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x084d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0869  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x086c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x088c  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x088f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x08a0  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0905  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void OuroTextField(final OuroStore store, final OuroFocusRequester focusRequester, final Function1<? super Boolean, Unit> function1, final Function1<? super Dp, Unit> function12, final Function1<? super Dp, Unit> function13, final PaddingValues contentPadding, final HintText hintText, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Object it$iv;
        Object value$iv;
        boolean invalid$iv;
        boolean invalid$iv2;
        boolean invalid$iv3;
        boolean invalid$iv4;
        boolean invalid$iv5;
        boolean invalid$iv6;
        boolean invalid$iv7;
        boolean invalid$iv8;
        boolean invalid$iv9;
        boolean invalid$iv10;
        boolean invalid$iv11;
        int $dirty;
        boolean invalid$iv12;
        Object it$iv2;
        boolean invalid$iv13;
        Object it$iv3;
        boolean invalid$iv14;
        boolean invalid$iv15;
        OuroEditText editText;
        Function1<? super Dp, Unit> function14;
        Object it$iv4;
        final MutableIntState mainAxisLength$delegate;
        boolean invalid$iv16;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(function1, "onKeyboardShow");
        Intrinsics.checkNotNullParameter(function12, "didScroll");
        Intrinsics.checkNotNullParameter(function13, "onContentHeightChange");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Composer $composer3 = $composer.startRestartGroup(1234870657);
        ComposerKt.sourceInformation($composer3, "C(OuroTextField)N(store,focusRequester,onKeyboardShow,didScroll,onContentHeightChange,contentPadding,hintText,modifier)60@2644L16,63@2787L7,64@2826L7,65@2860L33,67@2918L22,69@2964L54,70@3041L33,71@3100L33,72@3160L33,75@3222L104,80@3357L85,85@3476L85,90@3588L80,95@3702L119,100@3855L86,105@3976L393,116@4404L247,124@4682L73,128@4793L64,128@4761L96,132@4897L33,132@4863L67,136@4988L232,136@4936L284,146@5278L217,146@5226L269,154@5556L606,154@5501L661,173@6211L74,173@6168L117,177@6344L52,177@6291L105,182@6457L29,183@6506L10804,181@6402L10915:OuroTextField.android.kt#equpx4");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(store) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changedInstance(focusRequester) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changedInstance(function13) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer3.changed(contentPadding) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer3.changed(hintText) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty2 |= 12582912;
            modifier2 = modifier;
        } else if (($changed & 12582912) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 8388608 : 4194304;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1234870657, $dirty2, -1, "kntr.common.ouro.ui.textField.OuroTextField (OuroTextField.android.kt:59)");
            }
            final State ouroState$delegate = SnapshotStateKt.collectAsState(store.getStateFlow(), (CoroutineContext) null, $composer3, 0, 1);
            OuroState this_$iv = OuroTextField$lambda$0(ouroState$delegate);
            KClass key$iv = Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class);
            OuroPluginState ouroPluginState = this_$iv.getPluginStates().get(key$iv);
            if (!(ouroPluginState instanceof OuroLocalImageState)) {
                ouroPluginState = null;
            }
            OuroLocalImageState localImageState = (OuroLocalImageState) ouroPluginState;
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Enum r21 = (ThemeDayNight) consume;
            CompositionLocal this_$iv3 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Density density = (Density) consume2;
            ComposerKt.sourceInformationMarkerStart($composer3, 1299745090, "CC(remember):OuroTextField.android.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer3.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            }
            MutableIntState mainAxisLength$delegate2 = (MutableIntState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextMeasurer textMeasurer = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer3, 0, 1);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299748439, "CC(remember):OuroTextField.android.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object mutableStateOf$default = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(mutableStateOf$default);
                it$iv = mutableStateOf$default;
            } else {
                it$iv = it$iv6;
            }
            final MutableState scrollView$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299750882, "CC(remember):OuroTextField.android.kt#9igjgp");
            Object value$iv4 = $composer3.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
            }
            final MutableState visibleTop$delegate = (MutableState) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299752770, "CC(remember):OuroTextField.android.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv7 = value$iv5;
            }
            final MutableState visibleHeight$delegate = (MutableState) it$iv7;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299754690, "CC(remember):OuroTextField.android.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv6 = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv6);
                it$iv8 = value$iv6;
            }
            final MutableState editTextHeight$delegate = (MutableState) it$iv8;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            OuroEditScrollView OuroTextField$lambda$5 = OuroTextField$lambda$5(scrollView$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299756745, "CC(remember):OuroTextField.android.kt#9igjgp");
            boolean invalid$iv17 = $composer3.changed(OuroTextField$lambda$5);
            Object it$iv9 = $composer3.rememberedValue();
            if (!invalid$iv17 && it$iv9 != Composer.Companion.getEmpty()) {
                OuroEditText editText2 = (OuroEditText) it$iv9;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299761046, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv = ($dirty2 & 458752) != 131072;
                Object it$iv10 = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv7 = Dp.box-impl(contentPadding.calculateTopPadding-D9Ej5fM());
                $composer3.updateRememberedValue(value$iv7);
                it$iv10 = value$iv7;
                float topPadding = ((Dp) it$iv10).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299764854, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv2 = (458752 & $dirty2) != 131072;
                Object it$iv11 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv8 = Dp.box-impl(contentPadding.calculateTopPadding-D9Ej5fM());
                $composer3.updateRememberedValue(value$iv8);
                it$iv11 = value$iv8;
                float bottomPadding = ((Dp) it$iv11).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                float OuroTextField$lambda$8 = OuroTextField$lambda$8(visibleTop$delegate);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299768433, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv3 = $composer3.changed(OuroTextField$lambda$8) | $composer3.changed(topPadding);
                Object it$iv12 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv9 = Dp.box-impl(Dp.constructor-impl(OuroTextField$lambda$8(visibleTop$delegate) - topPadding));
                $composer3.updateRememberedValue(value$iv9);
                it$iv12 = value$iv9;
                float offset = ((Dp) it$iv12).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                float OuroTextField$lambda$14 = OuroTextField$lambda$14(editTextHeight$delegate);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299772120, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv4 = $composer3.changed(OuroTextField$lambda$14) | $composer3.changed(topPadding) | $composer3.changed(bottomPadding);
                Object it$iv13 = $composer3.rememberedValue();
                if (invalid$iv4) {
                }
                Object value$iv10 = Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(OuroTextField$lambda$14(editTextHeight$delegate) - topPadding) - bottomPadding));
                $composer3.updateRememberedValue(value$iv10);
                it$iv13 = value$iv10;
                float contentHeight = ((Dp) it$iv13).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                float OuroTextField$lambda$82 = OuroTextField$lambda$8(visibleTop$delegate);
                float OuroTextField$lambda$11 = OuroTextField$lambda$11(visibleHeight$delegate);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299776983, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv5 = $composer3.changed(OuroTextField$lambda$82) | $composer3.changed(OuroTextField$lambda$11);
                Object it$iv14 = $composer3.rememberedValue();
                if (invalid$iv5) {
                }
                Object value$iv11 = Dp.box-impl(Dp.constructor-impl(OuroTextField$lambda$8(visibleTop$delegate) + OuroTextField$lambda$11(visibleHeight$delegate)));
                $composer3.updateRememberedValue(value$iv11);
                it$iv14 = value$iv11;
                float visibleBottom = ((Dp) it$iv14).unbox-impl();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int OuroTextField$lambda$2 = OuroTextField$lambda$2(mainAxisLength$delegate2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299781162, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv6 = $composer3.changed(OuroTextField$lambda$2) | $composer3.changed(density) | $composer3.changed(textMeasurer) | $composer3.changed(r21.ordinal());
                Object it$iv15 = $composer3.rememberedValue();
                if (invalid$iv6) {
                }
                Object value$iv12 = new SpannableStringBuilderContext(density, textMeasurer, r21, OuroTextField$lambda$2(mainAxisLength$delegate2), localImageState, (KFunction) new OuroTextField_androidKt$OuroTextField$builderContext$1$1(store));
                $composer3.updateRememberedValue(value$iv12);
                it$iv15 = value$iv12;
                SpannableStringBuilderContext builderContext = (SpannableStringBuilderContext) it$iv15;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                NodeStorage<OuroDocument> storage = OuroTextField$lambda$0(ouroState$delegate).getStorage();
                ComposerKt.sourceInformationMarkerStart($composer3, 1299794712, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv7 = $composer3.changed(storage) | $composer3.changed(builderContext);
                Object it$iv16 = $composer3.rememberedValue();
                if (invalid$iv7) {
                }
                SpannableString value$iv13 = !OuroTextField$lambda$0(ouroState$delegate).getStorage().getHasContent() ? SpannableStringBuilderUtilsKt.spannableStringBuilder(OuroTextField$lambda$0(ouroState$delegate).getStorage(), builderContext) : new SpannableString("");
                $composer3.updateRememberedValue(value$iv13);
                it$iv16 = value$iv13;
                Spannable spannableString = (Spannable) it$iv16;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                OuroTextRange textRange = OuroTextField$lambda$0(ouroState$delegate).getTextRange();
                ComposerKt.sourceInformationMarkerStart($composer3, 1299803434, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv8 = $composer3.changed(textRange);
                Object it$iv17 = $composer3.rememberedValue();
                if (invalid$iv8) {
                }
                Object value$iv14 = OuroTextField$lambda$0(ouroState$delegate).getTextRange();
                $composer3.updateRememberedValue(value$iv14);
                it$iv17 = value$iv14;
                OuroTextRange toSelection = (OuroTextRange) it$iv17;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299806977, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv9 = $composer3.changedInstance(builderContext) | $composer3.changedInstance(localImageState);
                Object it$iv18 = $composer3.rememberedValue();
                if (invalid$iv9) {
                }
                Object value$iv15 = (Function2) new OuroTextField_androidKt$OuroTextField$1$1(builderContext, localImageState, null);
                $composer3.updateRememberedValue(value$iv15);
                it$iv18 = value$iv15;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(localImageState, (Function2) it$iv18, $composer3, 0);
                Dp dp = Dp.box-impl(offset);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299810274, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv10 = $composer3.changed(offset) | (($dirty2 & 7168) != 2048);
                OuroTextField_androidKt$OuroTextField$2$1 value$iv16 = $composer3.rememberedValue();
                if (!invalid$iv10 && value$iv16 != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(function12, dp, (Function2) value$iv16, $composer3, ($dirty2 >> 9) & 14);
                    Dp dp2 = Dp.box-impl(OuroTextField$lambda$8(visibleTop$delegate));
                    Dp dp3 = Dp.box-impl(visibleBottom);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299813385, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv11 = $composer3.changedInstance(editText2) | $composer3.changed(density) | $composer3.changed(visibleBottom);
                    Object it$iv19 = $composer3.rememberedValue();
                    if (invalid$iv11) {
                        $dirty = $dirty2;
                        if (it$iv19 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            int $dirty3 = $dirty;
                            EffectsKt.LaunchedEffect(editText2, dp2, dp3, (Function2) it$iv19, $composer3, 0);
                            Dp dp4 = Dp.box-impl(topPadding);
                            Dp dp5 = Dp.box-impl(bottomPadding);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299822650, "CC(remember):OuroTextField.android.kt#9igjgp");
                            invalid$iv12 = $composer3.changedInstance(editText2) | $composer3.changed(density) | $composer3.changed(topPadding) | $composer3.changed(bottomPadding);
                            it$iv2 = $composer3.rememberedValue();
                            if (!invalid$iv12 || it$iv2 == Composer.Companion.getEmpty()) {
                                Object value$iv17 = (Function2) new OuroTextField_androidKt$OuroTextField$4$1(editText2, density, topPadding, bottomPadding, null);
                                $composer3.updateRememberedValue(value$iv17);
                                it$iv2 = value$iv17;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(editText2, dp4, dp5, (Function2) it$iv2, $composer3, 0);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299831935, "CC(remember):OuroTextField.android.kt#9igjgp");
                            invalid$iv13 = $composer3.changedInstance(editText2) | $composer3.changedInstance(spannableString) | $composer3.changedInstance(toSelection) | $composer3.changed(density) | $composer3.changed(visibleBottom);
                            it$iv3 = $composer3.rememberedValue();
                            if (!invalid$iv13 || it$iv3 == Composer.Companion.getEmpty()) {
                                Object value$iv18 = (Function2) new OuroTextField_androidKt$OuroTextField$5$1(editText2, spannableString, toSelection, density, visibleBottom, visibleTop$delegate, null);
                                $composer3.updateRememberedValue(value$iv18);
                                it$iv3 = value$iv18;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(editText2, spannableString, toSelection, (Function2) it$iv3, $composer3, 0);
                            OuroTextRange compositionRange = OuroTextField$lambda$0(ouroState$delegate).getCompositionRange();
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299852363, "CC(remember):OuroTextField.android.kt#9igjgp");
                            invalid$iv14 = $composer3.changedInstance(editText2) | $composer3.changed(ouroState$delegate);
                            Object it$iv20 = $composer3.rememberedValue();
                            if (invalid$iv14 && it$iv20 != Composer.Companion.getEmpty()) {
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                EffectsKt.LaunchedEffect(compositionRange, (Function2) it$iv20, $composer3, 0);
                                Dp dp6 = Dp.box-impl(contentHeight);
                                ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                                invalid$iv15 = $composer3.changed(contentHeight) | ((57344 & $dirty3) == 16384);
                                Object it$iv21 = $composer3.rememberedValue();
                                if (invalid$iv15) {
                                    editText = editText2;
                                } else {
                                    editText = editText2;
                                    if (it$iv21 != Composer.Companion.getEmpty()) {
                                        function14 = function13;
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        EffectsKt.LaunchedEffect(function14, dp6, (Function2) it$iv21, $composer3, ($dirty3 >> 12) & 14);
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                                        it$iv4 = $composer3.rememberedValue();
                                        if (it$iv4 != Composer.Companion.getEmpty()) {
                                            mainAxisLength$delegate = mainAxisLength$delegate2;
                                            Object value$iv19 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda0
                                                public final Object invoke(Object obj) {
                                                    Unit OuroTextField$lambda$32$0;
                                                    OuroTextField$lambda$32$0 = OuroTextField_androidKt.OuroTextField$lambda$32$0(mainAxisLength$delegate, (IntSize) obj);
                                                    return OuroTextField$lambda$32$0;
                                                }
                                            };
                                            $composer3.updateRememberedValue(value$iv19);
                                            it$iv4 = value$iv19;
                                        } else {
                                            mainAxisLength$delegate = mainAxisLength$delegate2;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer3);
                                        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                                        ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                                        invalid$iv16 = (($dirty3 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty3) != 1048576);
                                        value$iv2 = $composer3.rememberedValue();
                                        if (!invalid$iv16 || value$iv2 == Composer.Companion.getEmpty()) {
                                            modifier3 = modifier5;
                                            $composer2 = $composer3;
                                            value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj) {
                                                    OuroEditScrollView OuroTextField$lambda$33$0;
                                                    OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                                                    return OuroTextField$lambda$33$0;
                                                }
                                            };
                                            $composer3.updateRememberedValue(value$iv2);
                                        } else {
                                            modifier3 = modifier5;
                                            $composer2 = $composer3;
                                        }
                                        ComposerKt.sourceInformationMarkerEnd($composer2);
                                        AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged, (Function1) null, $composer2, 0, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }
                                function14 = function13;
                                Object value$iv20 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight, null);
                                $composer3.updateRememberedValue(value$iv20);
                                it$iv21 = value$iv20;
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                EffectsKt.LaunchedEffect(function14, dp6, (Function2) it$iv21, $composer3, ($dirty3 >> 12) & 14);
                                ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                                it$iv4 = $composer3.rememberedValue();
                                if (it$iv4 != Composer.Companion.getEmpty()) {
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer3);
                                Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                                ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                                invalid$iv16 = (($dirty3 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty3) != 1048576);
                                value$iv2 = $composer3.rememberedValue();
                                if (invalid$iv16) {
                                }
                                modifier3 = modifier5;
                                $composer2 = $composer3;
                                value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                                    public final Object invoke(Object obj) {
                                        OuroEditScrollView OuroTextField$lambda$33$0;
                                        OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                                        return OuroTextField$lambda$33$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged2, (Function1) null, $composer2, 0, 4);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                            }
                            Object value$iv21 = (Function2) new OuroTextField_androidKt$OuroTextField$6$1(editText2, ouroState$delegate, null);
                            $composer3.updateRememberedValue(value$iv21);
                            it$iv20 = value$iv21;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(compositionRange, (Function2) it$iv20, $composer3, 0);
                            Dp dp62 = Dp.box-impl(contentHeight);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                            invalid$iv15 = $composer3.changed(contentHeight) | ((57344 & $dirty3) == 16384);
                            Object it$iv212 = $composer3.rememberedValue();
                            if (invalid$iv15) {
                            }
                            function14 = function13;
                            Object value$iv202 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight, null);
                            $composer3.updateRememberedValue(value$iv202);
                            it$iv212 = value$iv202;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            EffectsKt.LaunchedEffect(function14, dp62, (Function2) it$iv212, $composer3, ($dirty3 >> 12) & 14);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                            it$iv4 = $composer3.rememberedValue();
                            if (it$iv4 != Composer.Companion.getEmpty()) {
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                            ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                            invalid$iv16 = (($dirty3 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty3) != 1048576);
                            value$iv2 = $composer3.rememberedValue();
                            if (invalid$iv16) {
                            }
                            modifier3 = modifier5;
                            $composer2 = $composer3;
                            value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                                public final Object invoke(Object obj) {
                                    OuroEditScrollView OuroTextField$lambda$33$0;
                                    OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                                    return OuroTextField$lambda$33$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged22, (Function1) null, $composer2, 0, 4);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    } else {
                        $dirty = $dirty2;
                    }
                    Object value$iv22 = (Function2) new OuroTextField_androidKt$OuroTextField$3$1(editText2, density, visibleBottom, visibleTop$delegate, null);
                    $composer3.updateRememberedValue(value$iv22);
                    it$iv19 = value$iv22;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    int $dirty32 = $dirty;
                    EffectsKt.LaunchedEffect(editText2, dp2, dp3, (Function2) it$iv19, $composer3, 0);
                    Dp dp42 = Dp.box-impl(topPadding);
                    Dp dp52 = Dp.box-impl(bottomPadding);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299822650, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv12 = $composer3.changedInstance(editText2) | $composer3.changed(density) | $composer3.changed(topPadding) | $composer3.changed(bottomPadding);
                    it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv12) {
                    }
                    Object value$iv172 = (Function2) new OuroTextField_androidKt$OuroTextField$4$1(editText2, density, topPadding, bottomPadding, null);
                    $composer3.updateRememberedValue(value$iv172);
                    it$iv2 = value$iv172;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(editText2, dp42, dp52, (Function2) it$iv2, $composer3, 0);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299831935, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv13 = $composer3.changedInstance(editText2) | $composer3.changedInstance(spannableString) | $composer3.changedInstance(toSelection) | $composer3.changed(density) | $composer3.changed(visibleBottom);
                    it$iv3 = $composer3.rememberedValue();
                    if (!invalid$iv13) {
                    }
                    Object value$iv182 = (Function2) new OuroTextField_androidKt$OuroTextField$5$1(editText2, spannableString, toSelection, density, visibleBottom, visibleTop$delegate, null);
                    $composer3.updateRememberedValue(value$iv182);
                    it$iv3 = value$iv182;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(editText2, spannableString, toSelection, (Function2) it$iv3, $composer3, 0);
                    OuroTextRange compositionRange2 = OuroTextField$lambda$0(ouroState$delegate).getCompositionRange();
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299852363, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv14 = $composer3.changedInstance(editText2) | $composer3.changed(ouroState$delegate);
                    Object it$iv202 = $composer3.rememberedValue();
                    if (invalid$iv14) {
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(compositionRange2, (Function2) it$iv202, $composer3, 0);
                        Dp dp622 = Dp.box-impl(contentHeight);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                        invalid$iv15 = $composer3.changed(contentHeight) | ((57344 & $dirty32) == 16384);
                        Object it$iv2122 = $composer3.rememberedValue();
                        if (invalid$iv15) {
                        }
                        function14 = function13;
                        Object value$iv2022 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight, null);
                        $composer3.updateRememberedValue(value$iv2022);
                        it$iv2122 = value$iv2022;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        EffectsKt.LaunchedEffect(function14, dp622, (Function2) it$iv2122, $composer3, ($dirty32 >> 12) & 14);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                        it$iv4 = $composer3.rememberedValue();
                        if (it$iv4 != Composer.Companion.getEmpty()) {
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                        invalid$iv16 = (($dirty32 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty32) != 1048576);
                        value$iv2 = $composer3.rememberedValue();
                        if (invalid$iv16) {
                        }
                        modifier3 = modifier5;
                        $composer2 = $composer3;
                        value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                OuroEditScrollView OuroTextField$lambda$33$0;
                                OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                                return OuroTextField$lambda$33$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged222, (Function1) null, $composer2, 0, 4);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                    }
                    Object value$iv212 = (Function2) new OuroTextField_androidKt$OuroTextField$6$1(editText2, ouroState$delegate, null);
                    $composer3.updateRememberedValue(value$iv212);
                    it$iv202 = value$iv212;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(compositionRange2, (Function2) it$iv202, $composer3, 0);
                    Dp dp6222 = Dp.box-impl(contentHeight);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv15 = $composer3.changed(contentHeight) | ((57344 & $dirty32) == 16384);
                    Object it$iv21222 = $composer3.rememberedValue();
                    if (invalid$iv15) {
                    }
                    function14 = function13;
                    Object value$iv20222 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight, null);
                    $composer3.updateRememberedValue(value$iv20222);
                    it$iv21222 = value$iv20222;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    EffectsKt.LaunchedEffect(function14, dp6222, (Function2) it$iv21222, $composer3, ($dirty32 >> 12) & 14);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                    it$iv4 = $composer3.rememberedValue();
                    if (it$iv4 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier onSizeChanged2222 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                    invalid$iv16 = (($dirty32 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty32) != 1048576);
                    value$iv2 = $composer3.rememberedValue();
                    if (invalid$iv16) {
                    }
                    modifier3 = modifier5;
                    $composer2 = $composer3;
                    value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            OuroEditScrollView OuroTextField$lambda$33$0;
                            OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                            return OuroTextField$lambda$33$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged2222, (Function1) null, $composer2, 0, 4);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                value$iv16 = new OuroTextField_androidKt$OuroTextField$2$1(function12, offset, null);
                $composer3.updateRememberedValue(value$iv16);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(function12, dp, (Function2) value$iv16, $composer3, ($dirty2 >> 9) & 14);
                Dp dp22 = Dp.box-impl(OuroTextField$lambda$8(visibleTop$delegate));
                Dp dp32 = Dp.box-impl(visibleBottom);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299813385, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv11 = $composer3.changedInstance(editText2) | $composer3.changed(density) | $composer3.changed(visibleBottom);
                Object it$iv192 = $composer3.rememberedValue();
                if (invalid$iv11) {
                }
                Object value$iv222 = (Function2) new OuroTextField_androidKt$OuroTextField$3$1(editText2, density, visibleBottom, visibleTop$delegate, null);
                $composer3.updateRememberedValue(value$iv222);
                it$iv192 = value$iv222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int $dirty322 = $dirty;
                EffectsKt.LaunchedEffect(editText2, dp22, dp32, (Function2) it$iv192, $composer3, 0);
                Dp dp422 = Dp.box-impl(topPadding);
                Dp dp522 = Dp.box-impl(bottomPadding);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299822650, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv12 = $composer3.changedInstance(editText2) | $composer3.changed(density) | $composer3.changed(topPadding) | $composer3.changed(bottomPadding);
                it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv12) {
                }
                Object value$iv1722 = (Function2) new OuroTextField_androidKt$OuroTextField$4$1(editText2, density, topPadding, bottomPadding, null);
                $composer3.updateRememberedValue(value$iv1722);
                it$iv2 = value$iv1722;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(editText2, dp422, dp522, (Function2) it$iv2, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299831935, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv13 = $composer3.changedInstance(editText2) | $composer3.changedInstance(spannableString) | $composer3.changedInstance(toSelection) | $composer3.changed(density) | $composer3.changed(visibleBottom);
                it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv13) {
                }
                Object value$iv1822 = (Function2) new OuroTextField_androidKt$OuroTextField$5$1(editText2, spannableString, toSelection, density, visibleBottom, visibleTop$delegate, null);
                $composer3.updateRememberedValue(value$iv1822);
                it$iv3 = value$iv1822;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(editText2, spannableString, toSelection, (Function2) it$iv3, $composer3, 0);
                OuroTextRange compositionRange22 = OuroTextField$lambda$0(ouroState$delegate).getCompositionRange();
                ComposerKt.sourceInformationMarkerStart($composer3, 1299852363, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv14 = $composer3.changedInstance(editText2) | $composer3.changed(ouroState$delegate);
                Object it$iv2022 = $composer3.rememberedValue();
                if (invalid$iv14) {
                }
                Object value$iv2122 = (Function2) new OuroTextField_androidKt$OuroTextField$6$1(editText2, ouroState$delegate, null);
                $composer3.updateRememberedValue(value$iv2122);
                it$iv2022 = value$iv2122;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(compositionRange22, (Function2) it$iv2022, $composer3, 0);
                Dp dp62222 = Dp.box-impl(contentHeight);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv15 = $composer3.changed(contentHeight) | ((57344 & $dirty322) == 16384);
                Object it$iv212222 = $composer3.rememberedValue();
                if (invalid$iv15) {
                }
                function14 = function13;
                Object value$iv202222 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight, null);
                $composer3.updateRememberedValue(value$iv202222);
                it$iv212222 = value$iv202222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(function14, dp62222, (Function2) it$iv212222, $composer3, ($dirty322 >> 12) & 14);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                it$iv4 = $composer3.rememberedValue();
                if (it$iv4 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier onSizeChanged22222 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv16 = (($dirty322 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty322) != 1048576);
                value$iv2 = $composer3.rememberedValue();
                if (invalid$iv16) {
                }
                modifier3 = modifier5;
                $composer2 = $composer3;
                value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        OuroEditScrollView OuroTextField$lambda$33$0;
                        OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                        return OuroTextField$lambda$33$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged22222, (Function1) null, $composer2, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            OuroEditScrollView OuroTextField$lambda$52 = OuroTextField$lambda$5(scrollView$delegate);
            if (OuroTextField$lambda$52 != null) {
                int $i$f$cache = R.id.ouro_edit_text;
                value$iv = (OuroEditText) OuroTextField$lambda$52.findViewById($i$f$cache);
            } else {
                value$iv = null;
            }
            $composer3.updateRememberedValue(value$iv);
            it$iv9 = value$iv;
            OuroEditText editText22 = (OuroEditText) it$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299761046, "CC(remember):OuroTextField.android.kt#9igjgp");
            if (($dirty2 & 458752) != 131072) {
            }
            Object it$iv102 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv72 = Dp.box-impl(contentPadding.calculateTopPadding-D9Ej5fM());
            $composer3.updateRememberedValue(value$iv72);
            it$iv102 = value$iv72;
            float topPadding2 = ((Dp) it$iv102).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299764854, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv2 = (458752 & $dirty2) != 131072;
            Object it$iv112 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv82 = Dp.box-impl(contentPadding.calculateTopPadding-D9Ej5fM());
            $composer3.updateRememberedValue(value$iv82);
            it$iv112 = value$iv82;
            float bottomPadding2 = ((Dp) it$iv112).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float OuroTextField$lambda$83 = OuroTextField$lambda$8(visibleTop$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299768433, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv3 = $composer3.changed(OuroTextField$lambda$83) | $composer3.changed(topPadding2);
            Object it$iv122 = $composer3.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv92 = Dp.box-impl(Dp.constructor-impl(OuroTextField$lambda$8(visibleTop$delegate) - topPadding2));
            $composer3.updateRememberedValue(value$iv92);
            it$iv122 = value$iv92;
            float offset2 = ((Dp) it$iv122).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float OuroTextField$lambda$142 = OuroTextField$lambda$14(editTextHeight$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299772120, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv4 = $composer3.changed(OuroTextField$lambda$142) | $composer3.changed(topPadding2) | $composer3.changed(bottomPadding2);
            Object it$iv132 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv102 = Dp.box-impl(Dp.constructor-impl(Dp.constructor-impl(OuroTextField$lambda$14(editTextHeight$delegate) - topPadding2) - bottomPadding2));
            $composer3.updateRememberedValue(value$iv102);
            it$iv132 = value$iv102;
            float contentHeight2 = ((Dp) it$iv132).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            float OuroTextField$lambda$822 = OuroTextField$lambda$8(visibleTop$delegate);
            float OuroTextField$lambda$112 = OuroTextField$lambda$11(visibleHeight$delegate);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299776983, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv5 = $composer3.changed(OuroTextField$lambda$822) | $composer3.changed(OuroTextField$lambda$112);
            Object it$iv142 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv112 = Dp.box-impl(Dp.constructor-impl(OuroTextField$lambda$8(visibleTop$delegate) + OuroTextField$lambda$11(visibleHeight$delegate)));
            $composer3.updateRememberedValue(value$iv112);
            it$iv142 = value$iv112;
            float visibleBottom2 = ((Dp) it$iv142).unbox-impl();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int OuroTextField$lambda$22 = OuroTextField$lambda$2(mainAxisLength$delegate2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299781162, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv6 = $composer3.changed(OuroTextField$lambda$22) | $composer3.changed(density) | $composer3.changed(textMeasurer) | $composer3.changed(r21.ordinal());
            Object it$iv152 = $composer3.rememberedValue();
            if (invalid$iv6) {
            }
            Object value$iv122 = new SpannableStringBuilderContext(density, textMeasurer, r21, OuroTextField$lambda$2(mainAxisLength$delegate2), localImageState, (KFunction) new OuroTextField_androidKt$OuroTextField$builderContext$1$1(store));
            $composer3.updateRememberedValue(value$iv122);
            it$iv152 = value$iv122;
            SpannableStringBuilderContext builderContext2 = (SpannableStringBuilderContext) it$iv152;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            NodeStorage<OuroDocument> storage2 = OuroTextField$lambda$0(ouroState$delegate).getStorage();
            ComposerKt.sourceInformationMarkerStart($composer3, 1299794712, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv7 = $composer3.changed(storage2) | $composer3.changed(builderContext2);
            Object it$iv162 = $composer3.rememberedValue();
            if (invalid$iv7) {
            }
            if (!OuroTextField$lambda$0(ouroState$delegate).getStorage().getHasContent()) {
            }
            $composer3.updateRememberedValue(value$iv13);
            it$iv162 = value$iv13;
            Spannable spannableString2 = (Spannable) it$iv162;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            OuroTextRange textRange2 = OuroTextField$lambda$0(ouroState$delegate).getTextRange();
            ComposerKt.sourceInformationMarkerStart($composer3, 1299803434, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv8 = $composer3.changed(textRange2);
            Object it$iv172 = $composer3.rememberedValue();
            if (invalid$iv8) {
            }
            Object value$iv142 = OuroTextField$lambda$0(ouroState$delegate).getTextRange();
            $composer3.updateRememberedValue(value$iv142);
            it$iv172 = value$iv142;
            OuroTextRange toSelection2 = (OuroTextRange) it$iv172;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299806977, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv9 = $composer3.changedInstance(builderContext2) | $composer3.changedInstance(localImageState);
            Object it$iv182 = $composer3.rememberedValue();
            if (invalid$iv9) {
            }
            Object value$iv152 = (Function2) new OuroTextField_androidKt$OuroTextField$1$1(builderContext2, localImageState, null);
            $composer3.updateRememberedValue(value$iv152);
            it$iv182 = value$iv152;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(localImageState, (Function2) it$iv182, $composer3, 0);
            Dp dp7 = Dp.box-impl(offset2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299810274, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv10 = $composer3.changed(offset2) | (($dirty2 & 7168) != 2048);
            OuroTextField_androidKt$OuroTextField$2$1 value$iv162 = $composer3.rememberedValue();
            if (!invalid$iv10) {
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(function12, dp7, (Function2) value$iv162, $composer3, ($dirty2 >> 9) & 14);
                Dp dp222 = Dp.box-impl(OuroTextField$lambda$8(visibleTop$delegate));
                Dp dp322 = Dp.box-impl(visibleBottom2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299813385, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv11 = $composer3.changedInstance(editText22) | $composer3.changed(density) | $composer3.changed(visibleBottom2);
                Object it$iv1922 = $composer3.rememberedValue();
                if (invalid$iv11) {
                }
                Object value$iv2222 = (Function2) new OuroTextField_androidKt$OuroTextField$3$1(editText22, density, visibleBottom2, visibleTop$delegate, null);
                $composer3.updateRememberedValue(value$iv2222);
                it$iv1922 = value$iv2222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int $dirty3222 = $dirty;
                EffectsKt.LaunchedEffect(editText22, dp222, dp322, (Function2) it$iv1922, $composer3, 0);
                Dp dp4222 = Dp.box-impl(topPadding2);
                Dp dp5222 = Dp.box-impl(bottomPadding2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299822650, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv12 = $composer3.changedInstance(editText22) | $composer3.changed(density) | $composer3.changed(topPadding2) | $composer3.changed(bottomPadding2);
                it$iv2 = $composer3.rememberedValue();
                if (!invalid$iv12) {
                }
                Object value$iv17222 = (Function2) new OuroTextField_androidKt$OuroTextField$4$1(editText22, density, topPadding2, bottomPadding2, null);
                $composer3.updateRememberedValue(value$iv17222);
                it$iv2 = value$iv17222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(editText22, dp4222, dp5222, (Function2) it$iv2, $composer3, 0);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299831935, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv13 = $composer3.changedInstance(editText22) | $composer3.changedInstance(spannableString2) | $composer3.changedInstance(toSelection2) | $composer3.changed(density) | $composer3.changed(visibleBottom2);
                it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv13) {
                }
                Object value$iv18222 = (Function2) new OuroTextField_androidKt$OuroTextField$5$1(editText22, spannableString2, toSelection2, density, visibleBottom2, visibleTop$delegate, null);
                $composer3.updateRememberedValue(value$iv18222);
                it$iv3 = value$iv18222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(editText22, spannableString2, toSelection2, (Function2) it$iv3, $composer3, 0);
                OuroTextRange compositionRange222 = OuroTextField$lambda$0(ouroState$delegate).getCompositionRange();
                ComposerKt.sourceInformationMarkerStart($composer3, 1299852363, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv14 = $composer3.changedInstance(editText22) | $composer3.changed(ouroState$delegate);
                Object it$iv20222 = $composer3.rememberedValue();
                if (invalid$iv14) {
                }
                Object value$iv21222 = (Function2) new OuroTextField_androidKt$OuroTextField$6$1(editText22, ouroState$delegate, null);
                $composer3.updateRememberedValue(value$iv21222);
                it$iv20222 = value$iv21222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(compositionRange222, (Function2) it$iv20222, $composer3, 0);
                Dp dp622222 = Dp.box-impl(contentHeight2);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv15 = $composer3.changed(contentHeight2) | ((57344 & $dirty3222) == 16384);
                Object it$iv2122222 = $composer3.rememberedValue();
                if (invalid$iv15) {
                }
                function14 = function13;
                Object value$iv2022222 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight2, null);
                $composer3.updateRememberedValue(value$iv2022222);
                it$iv2122222 = value$iv2022222;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                EffectsKt.LaunchedEffect(function14, dp622222, (Function2) it$iv2122222, $composer3, ($dirty3222 >> 12) & 14);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
                it$iv4 = $composer3.rememberedValue();
                if (it$iv4 != Composer.Companion.getEmpty()) {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier onSizeChanged222222 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
                ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
                invalid$iv16 = (($dirty3222 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty3222) != 1048576);
                value$iv2 = $composer3.rememberedValue();
                if (invalid$iv16) {
                }
                modifier3 = modifier5;
                $composer2 = $composer3;
                value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        OuroEditScrollView OuroTextField$lambda$33$0;
                        OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                        return OuroTextField$lambda$33$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged222222, (Function1) null, $composer2, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            value$iv162 = new OuroTextField_androidKt$OuroTextField$2$1(function12, offset2, null);
            $composer3.updateRememberedValue(value$iv162);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(function12, dp7, (Function2) value$iv162, $composer3, ($dirty2 >> 9) & 14);
            Dp dp2222 = Dp.box-impl(OuroTextField$lambda$8(visibleTop$delegate));
            Dp dp3222 = Dp.box-impl(visibleBottom2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299813385, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv11 = $composer3.changedInstance(editText22) | $composer3.changed(density) | $composer3.changed(visibleBottom2);
            Object it$iv19222 = $composer3.rememberedValue();
            if (invalid$iv11) {
            }
            Object value$iv22222 = (Function2) new OuroTextField_androidKt$OuroTextField$3$1(editText22, density, visibleBottom2, visibleTop$delegate, null);
            $composer3.updateRememberedValue(value$iv22222);
            it$iv19222 = value$iv22222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            int $dirty32222 = $dirty;
            EffectsKt.LaunchedEffect(editText22, dp2222, dp3222, (Function2) it$iv19222, $composer3, 0);
            Dp dp42222 = Dp.box-impl(topPadding2);
            Dp dp52222 = Dp.box-impl(bottomPadding2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299822650, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv12 = $composer3.changedInstance(editText22) | $composer3.changed(density) | $composer3.changed(topPadding2) | $composer3.changed(bottomPadding2);
            it$iv2 = $composer3.rememberedValue();
            if (!invalid$iv12) {
            }
            Object value$iv172222 = (Function2) new OuroTextField_androidKt$OuroTextField$4$1(editText22, density, topPadding2, bottomPadding2, null);
            $composer3.updateRememberedValue(value$iv172222);
            it$iv2 = value$iv172222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(editText22, dp42222, dp52222, (Function2) it$iv2, $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299831935, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv13 = $composer3.changedInstance(editText22) | $composer3.changedInstance(spannableString2) | $composer3.changedInstance(toSelection2) | $composer3.changed(density) | $composer3.changed(visibleBottom2);
            it$iv3 = $composer3.rememberedValue();
            if (!invalid$iv13) {
            }
            Object value$iv182222 = (Function2) new OuroTextField_androidKt$OuroTextField$5$1(editText22, spannableString2, toSelection2, density, visibleBottom2, visibleTop$delegate, null);
            $composer3.updateRememberedValue(value$iv182222);
            it$iv3 = value$iv182222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(editText22, spannableString2, toSelection2, (Function2) it$iv3, $composer3, 0);
            OuroTextRange compositionRange2222 = OuroTextField$lambda$0(ouroState$delegate).getCompositionRange();
            ComposerKt.sourceInformationMarkerStart($composer3, 1299852363, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv14 = $composer3.changedInstance(editText22) | $composer3.changed(ouroState$delegate);
            Object it$iv202222 = $composer3.rememberedValue();
            if (invalid$iv14) {
            }
            Object value$iv212222 = (Function2) new OuroTextField_androidKt$OuroTextField$6$1(editText22, ouroState$delegate, null);
            $composer3.updateRememberedValue(value$iv212222);
            it$iv202222 = value$iv212222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(compositionRange2222, (Function2) it$iv202222, $composer3, 0);
            Dp dp6222222 = Dp.box-impl(contentHeight2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299856597, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv15 = $composer3.changed(contentHeight2) | ((57344 & $dirty32222) == 16384);
            Object it$iv21222222 = $composer3.rememberedValue();
            if (invalid$iv15) {
            }
            function14 = function13;
            Object value$iv20222222 = (Function2) new OuroTextField_androidKt$OuroTextField$7$1(function14, contentHeight2, null);
            $composer3.updateRememberedValue(value$iv20222222);
            it$iv21222222 = value$iv20222222;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(function14, dp6222222, (Function2) it$iv21222222, $composer3, ($dirty32222 >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299860190, "CC(remember):OuroTextField.android.kt#9igjgp");
            it$iv4 = $composer3.rememberedValue();
            if (it$iv4 != Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier onSizeChanged2222222 = OnRemeasuredModifierKt.onSizeChanged(modifier5, (Function1) it$iv4);
            ComposerKt.sourceInformationMarkerStart($composer3, 1299872533, "CC(remember):OuroTextField.android.kt#9igjgp");
            invalid$iv16 = (($dirty32222 & 896) != 256) | $composer3.changedInstance(focusRequester) | $composer3.changed(density) | $composer3.changedInstance(store) | $composer3.changed(ouroState$delegate) | ((3670016 & $dirty32222) != 1048576);
            value$iv2 = $composer3.rememberedValue();
            if (invalid$iv16) {
            }
            modifier3 = modifier5;
            $composer2 = $composer3;
            value$iv2 = new Function1() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    OuroEditScrollView OuroTextField$lambda$33$0;
                    OuroTextField$lambda$33$0 = OuroTextField_androidKt.OuroTextField$lambda$33$0(function1, focusRequester, hintText, density, editTextHeight$delegate, store, ouroState$delegate, visibleHeight$delegate, visibleTop$delegate, scrollView$delegate, (Context) obj);
                    return OuroTextField$lambda$33$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidView_androidKt.AndroidView((Function1) value$iv2, onSizeChanged2222222, (Function1) null, $composer2, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit OuroTextField$lambda$34;
                    OuroTextField$lambda$34 = OuroTextField_androidKt.OuroTextField$lambda$34(OuroStore.this, focusRequester, function1, function12, function13, contentPadding, hintText, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OuroTextField$lambda$34;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState OuroTextField$lambda$0(State<OuroState> state) {
        Object thisObj$iv = state.getValue();
        return (OuroState) thisObj$iv;
    }

    private static final int OuroTextField$lambda$2(MutableIntState $mainAxisLength$delegate) {
        IntState $this$getValue$iv = (IntState) $mainAxisLength$delegate;
        return $this$getValue$iv.getIntValue();
    }

    private static final OuroEditScrollView OuroTextField$lambda$5(MutableState<OuroEditScrollView> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (OuroEditScrollView) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float OuroTextField$lambda$8(MutableState<Dp> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void OuroTextField$lambda$9(MutableState<Dp> mutableState, float f) {
        Object value$iv = Dp.box-impl(f);
        mutableState.setValue(value$iv);
    }

    private static final float OuroTextField$lambda$11(MutableState<Dp> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void OuroTextField$lambda$12(MutableState<Dp> mutableState, float f) {
        Object value$iv = Dp.box-impl(f);
        mutableState.setValue(value$iv);
    }

    private static final float OuroTextField$lambda$14(MutableState<Dp> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Dp) $this$getValue$iv.getValue()).unbox-impl();
    }

    private static final void OuroTextField$lambda$15(MutableState<Dp> mutableState, float f) {
        Object value$iv = Dp.box-impl(f);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroTextField$lambda$32$0(MutableIntState $mainAxisLength$delegate, IntSize it) {
        $mainAxisLength$delegate.setIntValue((int) (it.unbox-impl() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroEditScrollView OuroTextField$lambda$33$0(Function1 $onKeyboardShow, final OuroFocusRequester $focusRequester, HintText $hintText, final Density $density, final MutableState $editTextHeight$delegate, final OuroStore $store, final State $ouroState$delegate, final MutableState $visibleHeight$delegate, final MutableState $visibleTop$delegate, MutableState $scrollView$delegate, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.ouro_edit_text, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type kntr.common.ouro.ui.textField.OuroEditScrollView");
        OuroEditScrollView editTextScrollView = (OuroEditScrollView) inflate;
        final OuroEditText editText = (OuroEditText) editTextScrollView.findViewById(R.id.ouro_edit_text);
        editText.setupKeyboardCallback($onKeyboardShow);
        editText.setupFocusRequester($focusRequester);
        editText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                OuroTextField_androidKt.OuroTextField$lambda$33$0$0($density, $editTextHeight$delegate, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        editText.addOuroTextChangedListener(new OuroEditTextListener() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$9$1$2
            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public void onTextChangedFiltered(CharSequence s, int start, int before, int count, boolean manual) {
                String insertedText;
                String insertedText2;
                if (manual) {
                    return;
                }
                if (before > 0 && count == 0) {
                    CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$onTextChangedFiltered$1(OuroStore.this, before, null), 1, null);
                } else if (count > 0 && before == 0) {
                    if (s != null && (insertedText2 = s.subSequence(start, start + count).toString()) != null) {
                        CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$onTextChangedFiltered$2(OuroStore.this, insertedText2, $ouroState$delegate, null), 1, null);
                    }
                } else if (before > 0 && count > 0) {
                    if (s != null && (insertedText = s.subSequence(start, start + count).toString()) != null) {
                        CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$onTextChangedFiltered$3(OuroStore.this, insertedText, start, before, $ouroState$delegate, null), 1, null);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                }
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public void onSelectionChangedFiltered(int selStart, int selEnd, boolean manual) {
                if (manual || selStart < 0 || selEnd < 0) {
                    return;
                }
                if (selStart + 1 == selEnd) {
                    Editable text = editText.getText();
                    boolean z = false;
                    if (text != null && text.length() == selEnd) {
                        Editable text2 = editText.getText();
                        if (text2 != null && text2.charAt(selStart) == 8204) {
                            z = true;
                        }
                        if (z) {
                            return;
                        }
                    }
                }
                OuroTextRange range = TextRangeUtilsKt.m2143toOuroTextRange5zctL8(TextRangeKt.TextRange(selStart, selEnd));
                OuroTextRange constrainRange = (OuroTextRange) CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$onSelectionChangedFiltered$constrainRange$1(OuroStore.this, range, null), 1, null);
                editText.setSelectionFromOutside(constrainRange.getStart(), constrainRange.getEnd());
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleEnterEvent() {
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleEnterEvent$1(OuroStore.this, $ouroState$delegate, null), 1, null);
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleDeleteEvent() {
                OuroState OuroTextField$lambda$0;
                OuroState OuroTextField$lambda$02;
                int it;
                OuroTextField$lambda$0 = OuroTextField_androidKt.OuroTextField$lambda$0($ouroState$delegate);
                int selStart = OuroTextField$lambda$0.getTextRange().getMin();
                OuroTextField$lambda$02 = OuroTextField_androidKt.OuroTextField$lambda$0($ouroState$delegate);
                int selEnd = OuroTextField$lambda$02.getTextRange().getMax();
                if (selStart == selEnd) {
                    Editable it2 = editText.getText();
                    if (it2 != null) {
                        boolean z = false;
                        if ((it2.length() > 0) && selStart > 0) {
                            z = true;
                        }
                        if (!z) {
                            it2 = null;
                        }
                        if (it2 != null) {
                            it = Character.charCount(Character.codePointBefore(it2, selStart));
                        }
                    }
                    it = 1;
                } else {
                    it = Math.abs(selEnd - selStart);
                }
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleDeleteEvent$1(OuroStore.this, it, null), 1, null);
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleCopyEvent(Function0<Unit> function0) {
                OuroState OuroTextField$lambda$0;
                Intrinsics.checkNotNullParameter(function0, "defaultAction");
                OuroTextField$lambda$0 = OuroTextField_androidKt.OuroTextField$lambda$0($ouroState$delegate);
                OuroTextRange range = OuroTextField$lambda$0.getTextRange();
                function0.invoke();
                OuroStore.this.dispatch(new OuroCopyAction(range));
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleCutEvent() {
                OuroStore.this.dispatch(new OuroCutAction(null, null, 3, null));
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handlePasteEvent() {
                OuroStore.this.dispatch(new OuroPasteAction(null, null, 3, null));
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleCommitText(CharSequence text) {
                Intrinsics.checkNotNullParameter(text, "text");
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleCommitText$1(OuroStore.this, text, $ouroState$delegate, null), 1, null);
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleSetComposingRegion(int start, int end) {
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleSetComposingRegion$1(OuroStore.this, start, end, null), 1, null);
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleFinishComposingText() {
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleFinishComposingText$1(OuroStore.this, null), 1, null);
                return true;
            }

            @Override // kntr.common.ouro.ui.textField.OuroEditTextListener
            public boolean handleSetComposingText(CharSequence text) {
                Intrinsics.checkNotNullParameter(text, "text");
                CoroutineExJvmKt.variantRunBlocking$default(null, new OuroTextField_androidKt$OuroTextField$9$1$2$handleSetComposingText$1(OuroStore.this, text, $ouroState$delegate, null), 1, null);
                return true;
            }
        });
        if ($hintText != null) {
            editText.setHint($hintText.getText());
            editText.setHintTextColor(ColorKt.toArgb-8_81llA($hintText.m2096getTextColor0d7_KjU()));
        }
        editTextScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$OuroTextField$9$1$3
            private boolean shouldForwardClickToEditText;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
                if (valueOf != null && valueOf.intValue() == 0) {
                    this.shouldForwardClickToEditText = true;
                } else if (valueOf != null && valueOf.intValue() == 2) {
                    this.shouldForwardClickToEditText = false;
                } else if (valueOf != null && valueOf.intValue() == 1) {
                    if (this.shouldForwardClickToEditText) {
                        this.shouldForwardClickToEditText = false;
                        OuroFocusRequester ouroFocusRequester = OuroFocusRequester.this;
                        if (ouroFocusRequester != null) {
                            ouroFocusRequester.requestFocus();
                        }
                    }
                } else {
                    this.shouldForwardClickToEditText = false;
                }
                return false;
            }
        });
        editTextScrollView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                OuroTextField_androidKt.OuroTextField$lambda$33$0$1($density, $visibleHeight$delegate, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        editTextScrollView.setOnScrollChangedCallback(new Function5() { // from class: kntr.common.ouro.ui.textField.OuroTextField_androidKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                Unit OuroTextField$lambda$33$0$2;
                OuroTextField$lambda$33$0$2 = OuroTextField_androidKt.OuroTextField$lambda$33$0$2($density, $visibleTop$delegate, (OuroEditScrollView) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), ((Integer) obj4).intValue(), ((Integer) obj5).intValue());
                return OuroTextField$lambda$33$0$2;
            }
        });
        $scrollView$delegate.setValue(editTextScrollView);
        return editTextScrollView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OuroTextField$lambda$33$0$0(Density $density, MutableState $editTextHeight$delegate, View v, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        OuroTextField$lambda$15($editTextHeight$delegate, $density.toDp-u2uoSUM(v.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OuroTextField$lambda$33$0$1(Density $density, MutableState $visibleHeight$delegate, View v, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        OuroTextField$lambda$12($visibleHeight$delegate, $density.toDp-u2uoSUM(v.getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OuroTextField$lambda$33$0$2(Density $density, MutableState $visibleTop$delegate, OuroEditScrollView view, int left, int top, int oldLeft, int oldTop) {
        Intrinsics.checkNotNullParameter(view, "view");
        OuroTextField$lambda$9($visibleTop$delegate, $density.toDp-u2uoSUM(view.getScrollY()));
        return Unit.INSTANCE;
    }
}