package tv.danmaku.bili.fullscreen.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.DividerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.text.SimpleTextFieldKt;
import com.bilibili.compose.text.TextFieldColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;
import tv.danmaku.bili.fullscreen.state.IFullscreenLoginReportAction;
import tv.danmaku.bili.fullscreen.state.IPasswordLoginPage;
import tv.danmaku.bili.fullscreen.state.PasswordLoginLoadingState;
import tv.danmaku.bili.fullscreen.state.PasswordLoginPageState;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: PasswordLoginPage.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001aÇ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\u0016\u001a7\u0010\u0017\u001a\u00020\u00182(\u0010\u0019\u001a\u0015\u0012\u0011\b\u0001\u0012\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001b0\u001a\"\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u001bH\u0003¢\u0006\u0002\u0010\u001c\u001a\u001f\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001a5\u0010#\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010$\u001a\u00020\u0018H\u0003¢\u0006\u0004\b%\u0010&\u001aQ\u0010'\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010$\u001a\u00020\u0018H\u0003¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"PasswordLoginPage", "", LoginReporterV2.PAGE_FROM_KEY, "Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;", "onAction", "Lkotlin/Function1;", "Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;", "onAccountInput", "", "onPasswordInput", "onBackPressed", "Lkotlin/Function0;", "onLoginClick", "", "onSwitchClick", "onAgreementCheck", "routeTo", "onForgetClick", "(Ltv/danmaku/bili/fullscreen/state/IPasswordLoginPage;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PasswordInputGroup", "account", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "rememberMaxLabelWidthOneTime", "Landroidx/compose/ui/unit/Dp;", "slots", "", "Landroidx/compose/runtime/Composable;", "([Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)F", "LabelText", "stringResId", "", "modifier", "Landroidx/compose/ui/Modifier;", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AccountRow", "labelTextMinWidth", "AccountRow-6a0pyJM", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;FLandroidx/compose/runtime/Composer;II)V", "PasswordRow", "PasswordRow-FJfuzF0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FLandroidx/compose/runtime/Composer;II)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PasswordLoginPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountRow_6a0pyJM$lambda$1(String str, Function1 function1, float f, int i, int i2, Composer composer, int i3) {
        m1074AccountRow6a0pyJM(str, function1, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelText$lambda$0(int i, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        LabelText(i, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordInputGroup$lambda$1(String str, String str2, Function1 function1, Function1 function12, Function0 function0, Function0 function02, int i, Composer composer, int i2) {
        PasswordInputGroup(str, str2, function1, function12, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$9(IPasswordLoginPage iPasswordLoginPage, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function1 function14, Function0 function02, Function1 function15, Function1 function16, Function0 function03, int i, int i2, Composer composer, int i3) {
        PasswordLoginPage(iPasswordLoginPage, function1, function12, function13, function0, function14, function02, function15, function16, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordRow_FJfuzF0$lambda$1(String str, Function1 function1, Function0 function0, Function0 function02, float f, int i, int i2, Composer composer, int i3) {
        m1075PasswordRowFJfuzF0(str, function1, function0, function02, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$1$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$3$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$5$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$6$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:200:0x05e1, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0695, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L127;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v65 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PasswordLoginPage(final IPasswordLoginPage page, final Function1<? super IFullscreenAction, Unit> function1, Function1<? super String, Unit> function12, Function1<? super String, Unit> function13, Function0<Unit> function0, Function1<? super Boolean, Unit> function14, Function0<Unit> function02, Function1<? super Boolean, Unit> function15, Function1<? super String, Unit> function16, Function0<Unit> function03, Composer $composer, final int $changed, final int i) {
        Function1 onAccountInput;
        Function1 onPasswordInput;
        Function0 onBackPressed;
        Function1<? super Boolean, Unit> function17;
        Function0 onSwitchClick;
        Function1 onAgreementCheck;
        Function1 routeTo;
        Function0 onForgetClick;
        Function1 onAccountInput2;
        Function1 onPasswordInput2;
        Function0 onBackPressed2;
        final Function1<? super Boolean, Unit> function18;
        Function0 onSwitchClick2;
        Function1 onAgreementCheck2;
        Function1 routeTo2;
        Function0 onForgetClick2;
        final PasswordLoginPageState pageState;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        final Function1<? super IFullscreenAction, Unit> function19;
        Intrinsics.checkNotNullParameter(page, LoginReporterV2.PAGE_FROM_KEY);
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(978042717);
        ComposerKt.sourceInformation($composer2, "C(PasswordLoginPage)N(page,onAction,onAccountInput,onPasswordInput,onBackPressed,onLoginClick,onSwitchClick,onAgreementCheck,routeTo,onForgetClick)48@2047L2,49@2091L2,50@2127L2,51@2169L2,52@2205L2,53@2251L2,54@2287L2,55@2323L2,61@2470L2247:PasswordLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(page) : $composer2.changedInstance(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? BR.hallEnterHotText : BR.cover;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function13) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changedInstance(function14) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 1048576 : 524288;
        }
        int i7 = i & BR.cover;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function15) ? 8388608 : 4194304;
        }
        int i8 = i & BR.hallEnterHotText;
        if (i8 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function16) ? 67108864 : 33554432;
        }
        int i9 = i & BR.roleType;
        if (i9 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function03) ? 536870912 : 268435456;
        }
        if ($composer2.shouldExecute(($dirty & 306783379) != 306783378, $dirty & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698782465, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda17
                        public final Object invoke(Object obj) {
                            Unit PasswordLoginPage$lambda$0$0;
                            PasswordLoginPage$lambda$0$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$0$0((String) obj);
                            return PasswordLoginPage$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onAccountInput2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onAccountInput2 = function12;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698781057, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit PasswordLoginPage$lambda$1$0;
                            PasswordLoginPage$lambda$1$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$1$0((String) obj);
                            return PasswordLoginPage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onPasswordInput2 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onPasswordInput2 = function13;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698779905, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onBackPressed2 = (Function0) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onBackPressed2 = function0;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698778561, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv4 = $composer2.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit PasswordLoginPage$lambda$3$0;
                            PasswordLoginPage$lambda$3$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$3$0(((Boolean) obj).booleanValue());
                            return PasswordLoginPage$lambda$3$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                function18 = (Function1) it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                function18 = function14;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698777409, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv5 = $composer2.rememberedValue();
                if (it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                onSwitchClick2 = (Function0) it$iv5;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onSwitchClick2 = function02;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698775937, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv6 = $composer2.rememberedValue();
                if (it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit PasswordLoginPage$lambda$5$0;
                            PasswordLoginPage$lambda$5$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$5$0(((Boolean) obj).booleanValue());
                            return PasswordLoginPage$lambda$5$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                onAgreementCheck2 = (Function1) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onAgreementCheck2 = function15;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698774785, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv7 = $composer2.rememberedValue();
                if (it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit PasswordLoginPage$lambda$6$0;
                            PasswordLoginPage$lambda$6$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$6$0((String) obj);
                            return PasswordLoginPage$lambda$6$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                routeTo2 = (Function1) it$iv7;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                routeTo2 = function16;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -698773633, "CC(remember):PasswordLoginPage.kt#9igjgp");
                Object it$iv8 = $composer2.rememberedValue();
                if (it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                onForgetClick2 = (Function0) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onForgetClick2 = function03;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(978042717, $dirty, -1, "tv.danmaku.bili.fullscreen.page.PasswordLoginPage (PasswordLoginPage.kt:56)");
            }
            if (page instanceof PasswordLoginLoadingState) {
                pageState = ((PasswordLoginLoadingState) page).getOriginal();
            } else if (!(page instanceof PasswordLoginPageState)) {
                throw new NoWhenBranchMatchedException();
            } else {
                pageState = (PasswordLoginPageState) page;
            }
            Function1 routeTo3 = routeTo2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            onAgreementCheck = onAgreementCheck2;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            onSwitchClick = onSwitchClick2;
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            onForgetClick = onForgetClick2;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            onPasswordInput = onPasswordInput2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i11 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1370882208, "C63@2517L71,62@2487L152,66@2648L2063:PasswordLoginPage.kt#gqoihp");
            CommonKt.PageHead(StringResources_androidKt.stringResource(R.string.account_global_string_72, $composer2, 0), onBackPressed2, $composer2, ($dirty >> 9) & BR.containerVisible, 0);
            onBackPressed = onBackPressed2;
            Modifier modifier$iv2 = WindowInsetsPadding_androidKt.navigationBarsPadding(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(24), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(32), 0.0f, 0.0f, 13, (Object) null));
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i13 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$PasswordLoginPage_u24lambda_u248_u240 = columnScope2;
            ComposerKt.sourceInformationMarkerStart($composer2, -2011886959, "C80@3222L44,74@2932L348,86@3497L70,87@3600L44,83@3294L364,91@3709L77,90@3672L175,95@3861L38,101@4103L310,97@3913L515,111@4441L41,113@4541L57,112@4495L152,116@4660L41:PasswordLoginPage.kt#gqoihp");
            String account = pageState.getAccount();
            String password = pageState.getPassword();
            ComposerKt.sourceInformationMarkerStart($composer2, 1459128629, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty) == 131072) | $composer2.changedInstance(pageState);
            Object it$iv9 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv9 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda18
                public final Object invoke() {
                    Unit PasswordLoginPage$lambda$8$0$0$0;
                    PasswordLoginPage$lambda$8$0$0$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$8$0$0$0(function18, pageState);
                    return PasswordLoginPage$lambda$8$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv9);
            it$iv9 = value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PasswordInputGroup(account, password, onAccountInput2, onPasswordInput, onForgetClick, (Function0) it$iv9, $composer2, ($dirty & 896) | ($dirty & 7168) | (($dirty >> 15) & 57344));
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(32), 0.0f, Dp.constructor-impl(24), 5, (Object) null);
            boolean z = (StringsKt.isBlank(pageState.getAccount()) || StringsKt.isBlank(pageState.getPassword())) ? false : true;
            String stringResource = StringResources_androidKt.stringResource(bili.resource.common.R.string.common_global_string_290, $composer2, 0);
            ComposerKt.sourceInformationMarkerStart($composer2, 1459140725, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv2 = ((458752 & $dirty) == 131072) | $composer2.changedInstance(pageState);
            onAccountInput = onAccountInput2;
            Object value$iv10 = $composer2.rememberedValue();
            if (invalid$iv2) {
            }
            value$iv10 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda19
                public final Object invoke() {
                    Unit PasswordLoginPage$lambda$8$0$1$0;
                    PasswordLoginPage$lambda$8$0$1$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$8$0$1$0(function18, pageState);
                    return PasswordLoginPage$lambda$8$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv10);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginButton(stringResource, z, modifier, (Function0) value$iv10, $composer2, BR.negativeBtnVisible, 0);
            CommonKt.SwitchLogin(StringResources_androidKt.stringResource(R.string.account_global_string_108, $composer2, 0), null, onSwitchClick, $composer2, ($dirty >> 12) & 896, 2);
            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$PasswordLoginPage_u24lambda_u248_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer2, 0);
            boolean agreementChecked = pageState.getAgreementChecked();
            ComposerKt.sourceInformationMarkerStart($composer2, 1459157087, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv3 = ($dirty & BR.containerVisible) == 32;
            Object it$iv10 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv10 == Composer.Companion.getEmpty()) {
                function19 = function1;
                Object value$iv11 = new Function3() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit PasswordLoginPage$lambda$8$0$2$0;
                        PasswordLoginPage$lambda$8$0$2$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$8$0$2$0(function19, (EulaLinkType) obj, ((Boolean) obj2).booleanValue(), (EulaTriggerType) obj3);
                        return PasswordLoginPage$lambda$8$0$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv11);
                it$iv10 = value$iv11;
            } else {
                function19 = function1;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginAgreement(null, agreementChecked, null, onAgreementCheck, routeTo3, (Function3) it$iv10, null, $composer2, (($dirty >> 12) & 7168) | (57344 & ($dirty >> 12)), 69);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1459170850, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv4 = ($dirty & BR.containerVisible) == 32;
            Object it$iv11 = $composer2.rememberedValue();
            if (invalid$iv4 || it$iv11 == Composer.Companion.getEmpty()) {
                Object value$iv12 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda21
                    public final Object invoke() {
                        Unit PasswordLoginPage$lambda$8$0$3$0;
                        PasswordLoginPage$lambda$8$0$3$0 = PasswordLoginPageKt.PasswordLoginPage$lambda$8$0$3$0(function19);
                        return PasswordLoginPage$lambda$8$0$3$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv12);
                it$iv11 = value$iv12;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CommonKt.LoginHelp((Function0) it$iv11, routeTo3, $composer2, ($dirty >> 21) & BR.containerVisible);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            routeTo = routeTo3;
            function17 = function18;
        } else {
            $composer2.skipToGroupEnd();
            onAccountInput = function12;
            onPasswordInput = function13;
            onBackPressed = function0;
            function17 = function14;
            onSwitchClick = function02;
            onAgreementCheck = function15;
            routeTo = function16;
            onForgetClick = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1 function110 = onAccountInput;
            final Function1 function111 = onPasswordInput;
            final Function0 function04 = onBackPressed;
            final Function1<? super Boolean, Unit> function112 = function17;
            final Function0 function05 = onSwitchClick;
            final Function1 function113 = onAgreementCheck;
            final Function1 function114 = routeTo;
            final Function0 function06 = onForgetClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PasswordLoginPage$lambda$9;
                    PasswordLoginPage$lambda$9 = PasswordLoginPageKt.PasswordLoginPage$lambda$9(IPasswordLoginPage.this, function1, function110, function111, function04, function112, function05, function113, function114, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PasswordLoginPage$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$8$0$0$0(Function1 $onLoginClick, PasswordLoginPageState $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$8$0$1$0(Function1 $onLoginClick, PasswordLoginPageState $pageState) {
        $onLoginClick.invoke(Boolean.valueOf($pageState.getAgreementChecked()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$8$0$2$0(Function1 $onAction, EulaLinkType type, boolean inDialog, EulaTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(type, "type");
        $onAction.invoke(new IFullscreenLoginReportAction.EulaLinkClicked(type, inDialog, triggerType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordLoginPage$lambda$8$0$3$0(Function1 $onAction) {
        $onAction.invoke(IFullscreenLoginReportAction.LoginHelpClick.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void PasswordInputGroup(final String account, final String password, final Function1<? super String, Unit> function1, final Function1<? super String, Unit> function12, final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1560502536);
        ComposerKt.sourceInformation($composer2, "C(PasswordInputGroup)N(account,password,onAccountInput,onPasswordInput,onForgetClick,onLoginClick)131@5006L223,135@5234L540:PasswordLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(account) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(password) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        if (!$composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1560502536, $dirty, -1, "tv.danmaku.bili.fullscreen.page.PasswordInputGroup (PasswordLoginPage.kt:129)");
            }
            float maxWidth = rememberMaxLabelWidthOneTime(new Function2[]{ComposableSingletons$PasswordLoginPageKt.INSTANCE.m1054getLambda$1076236361$accountui_apinkDebug(), ComposableSingletons$PasswordLoginPageKt.INSTANCE.m1055getLambda$1644208584$accountui_apinkDebug()}, $composer2, 0);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.nickTextColor << 3) & BR.containerVisible;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -996918962, "C139@5361L65,140@5461L6,140@5435L44,141@5488L227,148@5750L6,148@5724L44:PasswordLoginPage.kt#gqoihp");
            m1074AccountRow6a0pyJM(account, function1, maxWidth, $composer2, ($dirty & 14) | (($dirty >> 3) & BR.containerVisible), 0);
            DividerKt.Divider-oMI9zvI((Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_light-0d7_KjU(), 0.0f, 0.0f, $composer2, 0, 13);
            m1075PasswordRowFJfuzF0(password, function12, function0, function02, maxWidth, $composer2, (($dirty >> 3) & 14) | (($dirty >> 6) & BR.containerVisible) | (($dirty >> 6) & 896) | (($dirty >> 6) & 7168), 0);
            DividerKt.Divider-oMI9zvI((Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_light-0d7_KjU(), 0.0f, 0.0f, $composer2, 0, 13);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit PasswordInputGroup$lambda$1;
                    PasswordInputGroup$lambda$1 = PasswordLoginPageKt.PasswordInputGroup$lambda$1(account, password, function1, function12, function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PasswordInputGroup$lambda$1;
                }
            });
        }
    }

    private static final float rememberMaxLabelWidthOneTime(final Function2<? super Composer, ? super Integer, Unit>[] function2Arr, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 678774459, "C(rememberMaxLabelWidthOneTime)N(slots)154@5899L33,155@5952L34:PasswordLoginPage.kt#gqoihp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678774459, $changed, -1, "tv.danmaku.bili.fullscreen.page.rememberMaxLabelWidthOneTime (PasswordLoginPage.kt:153)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -532770628, "CC(remember):PasswordLoginPage.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default(Dp.box-impl(Dp.constructor-impl(0)), (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState labelMinWidth = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, -532768931, "CC(remember):PasswordLoginPage.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        final MutableState measured = (MutableState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (((Boolean) measured.getValue()).booleanValue()) {
            $composer.startReplaceGroup(658125895);
        } else {
            $composer.startReplaceGroup(664104028);
            ComposerKt.sourceInformation($composer, "157@6039L394,157@6022L411");
            ComposerKt.sourceInformationMarkerStart($composer, -532765787, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(function2Arr);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj, Object obj2) {
                        MeasureResult rememberMaxLabelWidthOneTime$lambda$2$0;
                        rememberMaxLabelWidthOneTime$lambda$2$0 = PasswordLoginPageKt.rememberMaxLabelWidthOneTime$lambda$2$0(function2Arr, labelMinWidth, measured, (SubcomposeMeasureScope) obj, (Constraints) obj2);
                        return rememberMaxLabelWidthOneTime$lambda$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SubcomposeLayoutKt.SubcomposeLayout((Modifier) null, (Function2) it$iv3, $composer, 0, 1);
        }
        $composer.endReplaceGroup();
        float f = ((Dp) labelMinWidth.getValue()).unbox-impl();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult rememberMaxLabelWidthOneTime$lambda$2$0(Function2[] $slots, MutableState $labelMinWidth, MutableState $measured, SubcomposeMeasureScope $this$SubcomposeLayout, Constraints constraints) {
        Integer num;
        Object[] $this$mapIndexed$iv;
        boolean z;
        Intrinsics.checkNotNullParameter($this$SubcomposeLayout, "$this$SubcomposeLayout");
        Object[] $this$mapIndexed$iv2 = $slots;
        boolean z2 = false;
        Collection destination$iv$iv = new ArrayList($this$mapIndexed$iv2.length);
        int index$iv$iv = 0;
        int length = $this$mapIndexed$iv2.length;
        int i = 0;
        while (true) {
            num = null;
            if (i >= length) {
                break;
            }
            int index$iv$iv2 = index$iv$iv + 1;
            Measurable measurable = (Measurable) CollectionsKt.firstOrNull($this$SubcomposeLayout.subcompose("label_" + index$iv$iv, $this$mapIndexed$iv2[i]));
            if (measurable != null) {
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                z = z2;
                num = measurable.measure-BRTryo0(constraints.unbox-impl());
            } else {
                $this$mapIndexed$iv = $this$mapIndexed$iv2;
                z = z2;
            }
            destination$iv$iv.add(num);
            i++;
            index$iv$iv = index$iv$iv2;
            $this$mapIndexed$iv2 = $this$mapIndexed$iv;
            z2 = z;
        }
        List placeables = (List) destination$iv$iv;
        Iterator it = placeables.iterator();
        if (it.hasNext()) {
            Placeable it2 = (Placeable) it.next();
            Integer valueOf = Integer.valueOf(it2 != null ? it2.getWidth() : 0);
            loop1: while (true) {
                num = valueOf;
                while (it.hasNext()) {
                    Placeable it3 = (Placeable) it.next();
                    valueOf = Integer.valueOf(it3 != null ? it3.getWidth() : 0);
                    if (num.compareTo(valueOf) < 0) {
                        break;
                    }
                }
            }
        }
        Integer num2 = num;
        int maxWidth = num2 != null ? num2.intValue() : 0;
        $this$SubcomposeLayout.getDensity();
        float $this$rememberMaxLabelWidthOneTime_u24lambda_u242_u240_u242 = $this$SubcomposeLayout.toDp-u2uoSUM(maxWidth);
        $labelMinWidth.setValue(Dp.box-impl($this$rememberMaxLabelWidthOneTime_u24lambda_u242_u240_u242));
        $measured.setValue(true);
        return MeasureScope.-CC.layout$default((MeasureScope) $this$SubcomposeLayout, 0, 0, (Map) null, new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit rememberMaxLabelWidthOneTime$lambda$2$0$3;
                rememberMaxLabelWidthOneTime$lambda$2$0$3 = PasswordLoginPageKt.rememberMaxLabelWidthOneTime$lambda$2$0$3((Placeable.PlacementScope) obj);
                return rememberMaxLabelWidthOneTime$lambda$2$0$3;
            }
        }, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberMaxLabelWidthOneTime$lambda$2$0$3(Placeable.PlacementScope $this$layout) {
        Intrinsics.checkNotNullParameter($this$layout, "$this$layout");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void LabelText(final int stringResId, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(937499731);
        ComposerKt.sourceInformation($composer3, "C(LabelText)N(stringResId,modifier)173@6584L27,174@6639L6,176@6708L9,172@6563L165:PasswordLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(stringResId) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(937499731, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.LabelText (PasswordLoginPage.kt:171)");
            }
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(stringResId, $composer3, $dirty2 & 14), modifier3, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer2, $dirty2 & BR.containerVisible, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit LabelText$lambda$0;
                    LabelText$lambda$0 = PasswordLoginPageKt.LabelText$lambda$0(stringResId, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LabelText$lambda$0;
                }
            });
        }
    }

    /* renamed from: AccountRow-6a0pyJM  reason: not valid java name */
    private static final void m1074AccountRow6a0pyJM(final String account, final Function1<? super String, Unit> function1, float f, Composer $composer, final int $changed, final int i) {
        float f2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1298221265);
        ComposerKt.sourceInformation($composer2, "C(AccountRow)N(account,onAccountInput,labelTextMinWidth:c#ui.unit.Dp)186@6869L885:PasswordLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(account) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
            f2 = f;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? BR.hallEnterHotText : BR.cover;
        } else {
            f2 = f;
        }
        if ($composer2.shouldExecute(($dirty & BR.danmakuNumIcon) != 146, $dirty & 1)) {
            float f3 = i2 != 0 ? Dp.constructor-impl(32) : f2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1298221265, $dirty, -1, "tv.danmaku.bili.fullscreen.page.AccountRow (PasswordLoginPage.kt:185)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(16), Dp.constructor-impl(10), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & BR.containerVisible));
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & BR.containerVisible) | 6;
            RowScope $this$AccountRow_6a0pyJM_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -2127074867, "C191@7009L168,200@7359L74,203@7454L72,205@7606L9,195@7186L562:PasswordLoginPage.kt#gqoihp");
            LabelText(R.string.account_global_string_97, SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, f3, 0.0f, 2, (Object) null), $composer2, 0, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$AccountRow_6a0pyJM_u24lambda_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(32), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 347037213, "CC(remember):PasswordLoginPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        Unit AccountRow_6a0pyJM$lambda$0$0$0;
                        AccountRow_6a0pyJM$lambda$0$0$0 = PasswordLoginPageKt.AccountRow_6a0pyJM$lambda$0$0$0((SemanticsPropertyReceiver) obj);
                        return AccountRow_6a0pyJM$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SimpleTextFieldKt.SimpleTextField(account, StringResources_androidKt.stringResource(R.string.account_global_string_147, $composer2, 0), function1, SemanticsModifierKt.semantics$default(weight$default, false, (Function1) it$iv, 1, (Object) null), BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), (TextStyle) null, false, true, 0, KeyboardOptions.copy-INvB4aQ$default(KeyboardOptions.Companion.getDefault(), 0, (Boolean) null, 0, ImeAction.Companion.getNext-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (Object) null), (KeyboardActions) null, (VisualTransformation) null, (Function1) null, (TextFieldColors) null, $composer2, ($dirty & 14) | 12582912 | (($dirty << 3) & 896), 0, 15712);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f2 = f3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final float f4 = f2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit AccountRow_6a0pyJM$lambda$1;
                    AccountRow_6a0pyJM$lambda$1 = PasswordLoginPageKt.AccountRow_6a0pyJM$lambda$1(account, function1, f4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AccountRow_6a0pyJM$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AccountRow_6a0pyJM$lambda$0$0$0(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentType($this$semantics, ContentType.Companion.getUsername());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x028d, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L57;
     */
    /* renamed from: PasswordRow-FJfuzF0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m1075PasswordRowFJfuzF0(final String password, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, float f, Composer $composer, final int $changed, final int i) {
        float f2;
        float f3;
        float f4;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1235553839);
        ComposerKt.sourceInformation($composer2, "C(PasswordRow)N(password,onPasswordInput,onForgetClick,onLoginClick,labelTextMinWidth:c#ui.unit.Dp)220@7959L1469:PasswordLoginPage.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(password) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            f2 = f;
        } else if (($changed & 24576) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            f2 = f;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            f3 = f2;
        } else {
            if (i2 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(32);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1235553839, $dirty, -1, "tv.danmaku.bili.fullscreen.page.PasswordRow (PasswordLoginPage.kt:219)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(10), 1, (Object) null);
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & BR.containerVisible) | 6;
            RowScope $this$PasswordRow_FJfuzF0_u24lambda_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer2, 668459219, "C225@8075L169,234@8427L74,237@8523L72,239@8676L9,245@8936L18,229@8253L780,250@9068L72,255@9349L6,256@9398L9,249@9043L379:PasswordLoginPage.kt#gqoihp");
            LabelText(R.string.account_global_string_161, SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, f4, 0.0f, 2, (Object) null), $composer2, 0, 0);
            Modifier weight$default = RowScope.-CC.weight$default($this$PasswordRow_FJfuzF0_u24lambda_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(32), 0.0f, 0.0f, 0.0f, 14, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -532616137, "CC(remember):PasswordLoginPage.kt#9igjgp");
            f3 = f4;
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda11
                    public final Object invoke(Object obj) {
                        Unit PasswordRow_FJfuzF0$lambda$0$0$0;
                        PasswordRow_FJfuzF0$lambda$0$0$0 = PasswordLoginPageKt.PasswordRow_FJfuzF0$lambda$0$0$0((SemanticsPropertyReceiver) obj);
                        return PasswordRow_FJfuzF0$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier semantics$default = SemanticsModifierKt.semantics$default(weight$default, false, (Function1) it$iv, 1, (Object) null);
            String stringResource = StringResources_androidKt.stringResource(R.string.account_global_string_117, $composer2, 0);
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.Companion.getPassword-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, (int) BR.contentBackground, (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -532599905, "CC(remember):PasswordLoginPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 7168) == 2048;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    Unit PasswordRow_FJfuzF0$lambda$0$1$0;
                    PasswordRow_FJfuzF0$lambda$0$1$0 = PasswordLoginPageKt.PasswordRow_FJfuzF0$lambda$0$1$0(function02, (KeyboardActionScope) obj);
                    return PasswordRow_FJfuzF0$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SimpleTextFieldKt.SimpleTextField(password, stringResource, function1, semantics$default, t16, (TextStyle) null, false, true, 0, keyboardOptions, new KeyboardActions((Function1) it$iv2, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, 62, (DefaultConstructorMarker) null), new PasswordVisualTransformation((char) 0, 1, (DefaultConstructorMarker) null), (Function1) null, (TextFieldColors) null, $composer2, ($dirty & 14) | 817889280 | (($dirty << 3) & 896), 0, 12640);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_152, $composer2, 0), ModifierUtilsKt.clickableNoInteraction$default(SizeKt.widthIn-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, Dp.constructor-impl(100), 1, (Object) null), false, function0, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), $composer2, 0, 0, 65528);
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
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.PasswordLoginPageKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit PasswordRow_FJfuzF0$lambda$1;
                    PasswordRow_FJfuzF0$lambda$1 = PasswordLoginPageKt.PasswordRow_FJfuzF0$lambda$1(password, function1, function0, function02, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PasswordRow_FJfuzF0$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordRow_FJfuzF0$lambda$0$0$0(SemanticsPropertyReceiver $this$semantics) {
        Intrinsics.checkNotNullParameter($this$semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentType($this$semantics, ContentType.Companion.getPassword());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PasswordRow_FJfuzF0$lambda$0$1$0(Function0 $onLoginClick, KeyboardActionScope $this$KeyboardActions) {
        Intrinsics.checkNotNullParameter($this$KeyboardActions, "$this$KeyboardActions");
        $onLoginClick.invoke();
        return Unit.INSTANCE;
    }
}