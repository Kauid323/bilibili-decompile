package tv.danmaku.bili.ui.main2.mine.topleft;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.homepage.R;
import com.bilibili.app.comm.list.common.contract.RouterResultContract;
import com.bilibili.app.comm.restrict.utils.TeenagersModeKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.bilibili.iconfont.KtxKt;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: TeensAge.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001at\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000721\u0010\n\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000bH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"TeesAgeButton", "", "initAge", "", "checkPassword", "", "chooseAge", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onSuccess", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "age", "(IZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TeensAgeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeesAgeButton$lambda$4(int i, boolean z, Function1 function1, Function2 function2, int i2, int i3, Composer composer, int i4) {
        TeesAgeButton(i, z, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0163, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TeesAgeButton(int initAge, boolean checkPassword, final Function1<? super Continuation<? super Integer>, ? extends Object> function1, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Composer $composer, final int $changed, final int i) {
        int initAge2;
        boolean z;
        int initAge3;
        boolean checkPassword2;
        int $dirty;
        int initAge4;
        Modifier modifier;
        Object obj;
        MutableIntState ageState;
        Function0 factory$iv$iv$iv;
        String str;
        int i2;
        Intrinsics.checkNotNullParameter(function1, "chooseAge");
        Intrinsics.checkNotNullParameter(function2, "onSuccess");
        Composer $composer2 = $composer.startRestartGroup(342980841);
        ComposerKt.sourceInformation($composer2, "C(TeesAgeButton)N(initAge,checkPassword,chooseAge,onSuccess)46@1785L24,48@1830L51,54@2023L164,52@1902L285,69@2341L6,72@2463L415,64@2193L1716:TeensAge.kt#2hz67j");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            if ((i & 1) == 0) {
                initAge2 = initAge;
                if ($composer2.changed(initAge2)) {
                    i2 = 4;
                    $dirty2 |= i2;
                }
            } else {
                initAge2 = initAge;
            }
            i2 = 2;
            $dirty2 |= i2;
        } else {
            initAge2 = initAge;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            z = checkPassword;
        } else if (($changed & 48) == 0) {
            z = checkPassword;
            $dirty2 |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = checkPassword;
        }
        if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty2 |= $composer2.changedInstance(function1) ? BR.hallEnterHotText : BR.cover;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function2) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if ((i & 1) != 0) {
                    initAge2 = TeenagersModeKt.getTeenagerAge();
                    $dirty2 &= -15;
                }
                if (i3 != 0) {
                    $dirty = $dirty2;
                    initAge4 = initAge2;
                    checkPassword2 = true;
                } else {
                    $dirty = $dirty2;
                    initAge4 = initAge2;
                    checkPassword2 = z;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty2 &= -15;
                }
                $dirty = $dirty2;
                initAge4 = initAge2;
                checkPassword2 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(342980841, $dirty, -1, "tv.danmaku.bili.ui.main2.mine.topleft.TeesAgeButton (TeensAge.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -1107886052, "CC(remember):TeensAge.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotIntStateKt.mutableIntStateOf(initAge4);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableIntState ageState2 = (MutableIntState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ActivityResultContract teenagersModeResultContract = new TeenagersModeResultContract("bilibili://main/teenagersmode");
            ComposerKt.sourceInformationMarkerStart($composer2, -1107879763, "CC(remember):TeensAge.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | $composer2.changedInstance(function2);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit TeesAgeButton$lambda$1$0;
                    TeesAgeButton$lambda$1$0 = TeensAgeKt.TeesAgeButton$lambda$1$0(scope, function2, ageState2, (Integer) obj2);
                    return TeesAgeButton$lambda$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ManagedActivityResultLauncher launcher = ActivityResultRegistryKt.rememberLauncherForActivityResult(teenagersModeResultContract, (Function1) it$iv2, $composer2, RouterResultContract.$stable);
            Modifier modifier2 = BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) BR.contentColor)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer2, -1107865432, "CC(remember):TeensAge.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(scope) | $composer2.changedInstance(function1) | (($dirty & BR.containerVisible) == 32) | $composer2.changedInstance(launcher) | $composer2.changedInstance(function2);
            Object value$iv3 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                final boolean z2 = checkPassword2;
                modifier = modifier2;
                obj = null;
                ageState = ageState2;
                value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TeesAgeButton$lambda$2$0;
                        TeesAgeButton$lambda$2$0 = TeensAgeKt.TeesAgeButton$lambda$2$0(scope, function1, z2, launcher, function2, ageState2);
                        return TeesAgeButton$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                modifier = modifier2;
                ageState = ageState2;
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ModifierUtilsKt.clickableNoInteraction$default(modifier, false, (Function0) value$iv3, 1, obj);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
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
            initAge3 = initAge4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 469614100, "C94@3341L6,95@3385L9,88@3004L405,97@3418L39,99@3496L7,106@3689L40,109@3872L6,105@3660L242:TeensAge.kt#2hz67j");
            if (ageState.getIntValue() >= 0) {
                $composer2.startReplaceGroup(469643177);
                ComposerKt.sourceInformation($composer2, "90@3075L108");
                String stringResource = StringResources_androidKt.stringResource(R.string.homepage_global_string_15, new Object[]{String.valueOf(ageState.getIntValue())}, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource;
            } else {
                $composer2.startReplaceGroup(469785994);
                ComposerKt.sourceInformation($composer2, "92@3220L75");
                String stringResource2 = StringResources_androidKt.stringResource(bili.resource.others.R.string.others_global_string_236, $composer2, 0);
                $composer2.endReplaceGroup();
                str = stringResource2;
            }
            TextKt.Text--4IGK_g(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 0, 65530);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            $composer2.startReplaceGroup(1262089273);
            ComposerKt.sourceInformation($composer2, "*100@3519L121");
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Context $this$TeesAgeButton_u24lambda_u243_u240 = (Context) consume;
            ComposerKt.sourceInformationMarkerStart($composer2, 1257524173, "CC(remember):TeensAge.kt#9igjgp");
            Object value$iv4 = $composer2.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = KtxKt.getAppCompatDrawable($this$TeesAgeButton_u24lambda_u243_u240, com.bilibili.iconfont.R.drawable.ref_arrow_expand_line_900);
                $composer2.updateRememberedValue(value$iv4);
            }
            Drawable icon = (Drawable) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceGroup();
            ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(icon, $composer2, 0), "expand", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_medium-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | BR.pendentVisible, 56);
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
            initAge3 = initAge2;
            checkPassword2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final int i6 = initAge3;
            final boolean z3 = checkPassword2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit TeesAgeButton$lambda$4;
                    TeesAgeButton$lambda$4 = TeensAgeKt.TeesAgeButton$lambda$4(i6, z3, function1, function2, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return TeesAgeButton$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeesAgeButton$lambda$1$0(CoroutineScope $scope, Function2 $onSuccess, MutableIntState $ageState, Integer age) {
        if (age != null) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TeensAgeKt$TeesAgeButton$launcher$1$1$1($onSuccess, age, $ageState, null), 3, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TeesAgeButton$lambda$2$0(CoroutineScope $scope, Function1 $chooseAge, boolean $checkPassword, ManagedActivityResultLauncher $launcher, Function2 $onSuccess, MutableIntState $ageState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TeensAgeKt$TeesAgeButton$1$1$1($chooseAge, $checkPassword, $launcher, $onSuccess, $ageState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}