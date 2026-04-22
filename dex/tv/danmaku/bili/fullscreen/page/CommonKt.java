package tv.danmaku.bili.fullscreen.page;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
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
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import bili.resource.account.R;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.utils.ModifierUtilsKt;
import com.bilibili.compose.widget.BiliCheckBoxShape;
import com.bilibili.compose.widget.BiliCheckboxColors;
import com.bilibili.compose.widget.BiliCheckboxKt;
import com.bilibili.iconfont.KtxKt;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import shark.AndroidResourceIdNames;
import tv.danmaku.android.log.cache.RingBuffer;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.eula.EulaLinkType;
import tv.danmaku.bili.fullscreen.service.IspCode;
import tv.danmaku.bili.normal.ui.EulaTriggerType;
import tv.danmaku.bili.quick.LoginIspHelper;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.AgreementLinkHelper;

/* compiled from: Common.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0005\u001a½\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\t2M\u0010\u000f\u001aI\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\u001a>\u0010\u001b\u001a\u00020\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00010\tH\u0001¢\u0006\u0002\u0010\u001e\u001a/\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0001¢\u0006\u0002\u0010\"\u001a7\u0010#\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u00032\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0001¢\u0006\u0002\u0010&\u001a%\u0010'\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u000b2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0001¢\u0006\u0002\u0010)\u001a\u0015\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010+\u001a[\u0010,\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00052\b\b\u0002\u0010.\u001a\u00020\u00052\u000e\b\u0002\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\u001d2\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0001¢\u0006\u0002\u00102\u001a5\u00103\u001a\u00020\u00012\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00010\u001dH\u0001¢\u0006\u0002\u00109\"\u000e\u0010\u0019\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"LoginAgreement", "", "modifier", "Landroidx/compose/ui/Modifier;", "checked", "", "ispCode", "Ltv/danmaku/bili/fullscreen/service/IspCode;", "onCheckChanged", "Lkotlin/Function1;", "routeTo", "", "Lkotlin/ParameterName;", ChannelRoutes.CHANNEL_NAME, "url", "onClickEulaLink", "Lkotlin/Function3;", "Ltv/danmaku/bili/eula/EulaLinkType;", "type", "inDialog", "Ltv/danmaku/bili/normal/ui/EulaTriggerType;", "triggerType", "shape", "Lcom/bilibili/compose/widget/BiliCheckBoxShape;", "(Landroidx/compose/ui/Modifier;ZLtv/danmaku/bili/fullscreen/service/IspCode;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lcom/bilibili/compose/widget/BiliCheckBoxShape;Landroidx/compose/runtime/Composer;II)V", "URL_TAG", "TYPE_TAG", "LoginHelp", "onClickLoginHelp", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SwitchLogin", ReportUtilKt.POS_TITLE, "onSwitchClick", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LoginButton", "enable", "onLoginClick", "(Ljava/lang/String;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "PageHead", "onBackPress", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "LogoGroup", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "ThirdPartyLogin", "googleVisible", "facebookVisible", "onPasswordClick", "onGoogleClick", "onFacebookClick", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "OverseaImageText", "imageRes", "", "text", "iconFont", "onClick", "(ILjava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CommonKt {
    public static final String TYPE_TAG = "TYPE";
    public static final String URL_TAG = "URL";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginAgreement$lambda$2(Modifier modifier, boolean z, IspCode ispCode, Function1 function1, Function1 function12, Function3 function3, BiliCheckBoxShape biliCheckBoxShape, int i, int i2, Composer composer, int i3) {
        LoginAgreement(modifier, z, ispCode, function1, function12, function3, biliCheckBoxShape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginButton$lambda$2(String str, boolean z, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        LoginButton(str, z, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginHelp$lambda$1(Function0 function0, Function1 function1, int i, Composer composer, int i2) {
        LoginHelp(function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LogoGroup$lambda$1(Modifier modifier, int i, Composer composer, int i2) {
        LogoGroup(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverseaImageText$lambda$2(int i, String str, boolean z, Function0 function0, int i2, int i3, Composer composer, int i4) {
        OverseaImageText(i, str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageHead$lambda$2(String str, Function0 function0, int i, int i2, Composer composer, int i3) {
        PageHead(str, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SwitchLogin$lambda$2(String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        SwitchLogin(str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ThirdPartyLogin$lambda$4(Modifier modifier, boolean z, boolean z2, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        ThirdPartyLogin(modifier, z, z2, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginAgreement$lambda$0$0(boolean it) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v25 */
    public static final void LoginAgreement(Modifier modifier, boolean checked, IspCode ispCode, Function1<? super Boolean, Unit> function1, final Function1<? super String, Unit> function12, final Function3<? super EulaLinkType, ? super Boolean, ? super EulaTriggerType, Unit> function3, BiliCheckBoxShape shape, Composer $composer, final int $changed, final int i) {
        boolean checked2;
        Modifier modifier2;
        IspCode ispCode2;
        Function1 onCheckChanged;
        BiliCheckBoxShape shape2;
        boolean checked3;
        Function1 onCheckChanged2;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        Intrinsics.checkNotNullParameter(function12, "routeTo");
        Intrinsics.checkNotNullParameter(function3, "onClickEulaLink");
        Composer $composer3 = $composer.startRestartGroup(-208340044);
        ComposerKt.sourceInformation($composer3, "C(LoginAgreement)N(modifier,checked,ispCode,onCheckChanged,routeTo,onClickEulaLink,shape)60@2448L2,65@2656L2921:Common.kt#gqoihp");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            checked2 = checked;
        } else if (($changed & 48) == 0) {
            checked2 = checked;
            $dirty |= $composer3.changed(checked2) ? 32 : 16;
        } else {
            checked2 = checked;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= BR.negativeBtnVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            $dirty |= $composer3.changed(ispCode == null ? -1 : ispCode.ordinal()) ? BR.hallEnterHotText : BR.cover;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function12) ? RingBuffer.CONSUME_SIZE : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(shape == null ? -1 : ((Enum) shape).ordinal()) ? 1048576 : 524288;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            modifier2 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                checked2 = false;
            }
            IspCode ispCode3 = i4 != 0 ? IspCode.Unknown : ispCode;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1648686198, "CC(remember):Common.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda11
                        public final Object invoke(Object obj) {
                            Unit LoginAgreement$lambda$0$0;
                            LoginAgreement$lambda$0$0 = CommonKt.LoginAgreement$lambda$0$0(((Boolean) obj).booleanValue());
                            return LoginAgreement$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onCheckChanged3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onCheckChanged2 = onCheckChanged3;
            } else {
                onCheckChanged2 = function1;
            }
            BiliCheckBoxShape shape3 = i6 != 0 ? BiliCheckBoxShape.RECTANGLE : shape;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-208340044, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.LoginAgreement (Common.kt:64)");
            }
            int $changed$iv = $dirty2 & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & BR.containerVisible));
            int $changed$iv$iv = ($changed$iv << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = (($changed$iv >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -518058645, "C66@2691L193,114@4860L9,114@4897L6,115@4934L627,112@4785L786:Common.kt#gqoihp");
            BiliCheckboxKt.BiliCheckbox(checked2, onCheckChanged2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), Dp.constructor-impl(6), 0.0f, 9, (Object) null), false, (BiliCheckboxColors) null, shape3, $composer3, (($dirty2 >> 3) & 14) | (($dirty2 >> 6) & BR.containerVisible) | (($dirty2 >> 3) & 458752), 24);
            $composer3.startReplaceGroup(1368767746);
            ComposerKt.sourceInformation($composer3, "*77@3013L76,79@3142L6,85@3469L64,87@3586L6,109@4669L76");
            AnnotatedString.Builder $this$LoginAgreement_u24lambda_u241_u240 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_63, $composer3, 0));
            $composer3.startReplaceGroup(1368772432);
            ComposerKt.sourceInformation($composer3, "*82@3357L76");
            SpanStyle style$iv = new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_link-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
            int index$iv = $this$LoginAgreement_u24lambda_u241_u240.pushStyle(style$iv);
            try {
                String userProtocolUrl = AgreementLinkHelper.H5Urls.getUserProtocolUrl();
                shape2 = shape3;
                try {
                    Intrinsics.checkNotNullExpressionValue(userProtocolUrl, "getUserProtocolUrl(...)");
                    $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(URL_TAG, userProtocolUrl);
                    $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(TYPE_TAG, "Agreement");
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_56, $composer3, 0));
                Unit unit = Unit.INSTANCE;
                $this$LoginAgreement_u24lambda_u241_u240.pop(index$iv);
                $composer3.endReplaceGroup();
                $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(com.bilibili.app.accountui.R.string.account_fast_login_agreement_point, $composer3, 0));
                $composer3.startReplaceGroup(1368786640);
                ComposerKt.sourceInformation($composer3, "*90@3800L77");
                SpanStyle style$iv2 = new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_link-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
                index$iv = $this$LoginAgreement_u24lambda_u241_u240.pushStyle(style$iv2);
                try {
                    String privacyPolicyUrl = AgreementLinkHelper.H5Urls.getPrivacyPolicyUrl();
                    try {
                        Intrinsics.checkNotNullExpressionValue(privacyPolicyUrl, "getPrivacyPolicyUrl(...)");
                        $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(URL_TAG, privacyPolicyUrl);
                        $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(TYPE_TAG, "Privacy");
                        $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_110, $composer3, 0));
                        Unit unit2 = Unit.INSTANCE;
                        $this$LoginAgreement_u24lambda_u241_u240.pop(index$iv);
                        $composer3.endReplaceGroup();
                        if (ispCode3 != IspCode.Unknown) {
                            $composer3.startReplaceGroup(-831965966);
                            ComposerKt.sourceInformation($composer3, "94@3983L7");
                            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                            Object consume = $composer3.consume(this_$iv);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Context context = (Context) consume;
                            Pair<String, String> ispCarrierTextAndLink = LoginIspHelper.INSTANCE.getIspCarrierTextAndLink(context, ispCode3.getIspName());
                            String agreement = (String) ispCarrierTextAndLink.component1();
                            String linkUrl = (String) ispCarrierTextAndLink.component2();
                            if (agreement == null || linkUrl == null) {
                                ispCode2 = ispCode3;
                                $composer3.startReplaceGroup(-835895464);
                            } else {
                                $composer3.startReplaceGroup(-831699242);
                                ComposerKt.sourceInformation($composer3, "100@4245L77,101@4382L6");
                                $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_159, $composer3, 0));
                                SpanStyle style$iv3 = new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_link-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
                                ispCode2 = ispCode3;
                                index$iv = $this$LoginAgreement_u24lambda_u241_u240.pushStyle(style$iv3);
                                try {
                                    $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(URL_TAG, linkUrl);
                                    $this$LoginAgreement_u24lambda_u241_u240.pushStringAnnotation(TYPE_TAG, "IspAgreement");
                                    $this$LoginAgreement_u24lambda_u241_u240.append(agreement);
                                    Unit unit3 = Unit.INSTANCE;
                                } finally {
                                    $this$LoginAgreement_u24lambda_u241_u240.pop(index$iv);
                                }
                            }
                            $composer3.endReplaceGroup();
                        } else {
                            ispCode2 = ispCode3;
                            $composer3.startReplaceGroup(-835895464);
                        }
                        $composer3.endReplaceGroup();
                        $this$LoginAgreement_u24lambda_u241_u240.append(StringResources_androidKt.stringResource(R.string.account_global_string_13, $composer3, 0));
                        final AnnotatedString annotated = $this$LoginAgreement_u24lambda_u241_u240.toAnnotatedString();
                        $composer3.endReplaceGroup();
                        TextStyle textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1368831275, "CC(remember):Common.kt#9igjgp");
                        boolean invalid$iv = $composer3.changed(annotated) | ((57344 & $dirty2) == 16384) | ((458752 & $dirty2) == 131072) | (($dirty2 & 7168) == 2048) | (($dirty2 & BR.containerVisible) == 32);
                        Object it$iv2 = $composer3.rememberedValue();
                        if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                            $composer$iv$iv = $composer3;
                            final Function1 function13 = onCheckChanged2;
                            final boolean z = checked2;
                            $composer2 = $composer3;
                            $composer$iv = $composer3;
                            Object value$iv2 = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda12
                                public final Object invoke(Object obj) {
                                    Unit LoginAgreement$lambda$1$1$0;
                                    LoginAgreement$lambda$1$1$0 = CommonKt.LoginAgreement$lambda$1$1$0(annotated, function13, z, function12, function3, ((Integer) obj).intValue());
                                    return LoginAgreement$lambda$1$1$0;
                                }
                            };
                            $composer3.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        } else {
                            $composer2 = $composer3;
                            $composer$iv$iv = $composer3;
                            $composer$iv = $composer3;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ClickableTextKt.ClickableText-4YKlhWE(annotated, (Modifier) null, textStyle, false, 0, 0, (Function1) null, (Function1) it$iv2, $composer2, 0, (int) BR.cornerVisible);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        onCheckChanged = onCheckChanged2;
                        checked3 = checked2;
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                throw th;
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier2 = modifier;
            ispCode2 = ispCode;
            onCheckChanged = function1;
            shape2 = shape;
            checked3 = checked2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z2 = checked3;
            final IspCode ispCode4 = ispCode2;
            final Function1 function14 = onCheckChanged;
            final BiliCheckBoxShape biliCheckBoxShape = shape2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginAgreement$lambda$2;
                    LoginAgreement$lambda$2 = CommonKt.LoginAgreement$lambda$2(modifier3, z2, ispCode4, function14, function12, function3, biliCheckBoxShape, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginAgreement$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginAgreement$lambda$1$1$0(AnnotatedString $annotated, Function1 $onCheckChanged, boolean $checked, Function1 $routeTo, Function3 $onClickEulaLink, int it) {
        AnnotatedString.Range annotation = (AnnotatedString.Range) CollectionsKt.firstOrNull($annotated.getStringAnnotations(URL_TAG, it, it));
        if (annotation != null) {
            $routeTo.invoke(annotation.getItem());
            AnnotatedString.Range link = (AnnotatedString.Range) CollectionsKt.firstOrNull($annotated.getStringAnnotations(TYPE_TAG, it, it));
            if (link != null) {
                try {
                    EulaLinkEnum type = EulaLinkEnum.valueOf((String) link.getItem());
                    $onClickEulaLink.invoke(type.getGetType().invoke(annotation.getItem()), false, (Object) null);
                } catch (Exception e) {
                }
            }
        } else {
            $onCheckChanged.invoke(Boolean.valueOf(!$checked));
        }
        return Unit.INSTANCE;
    }

    public static final void LoginHelp(final Function0<Unit> function0, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(function0, "onClickLoginHelp");
        Intrinsics.checkNotNullParameter(function1, "routeTo");
        Composer $composer3 = $composer.startRestartGroup(-148328605);
        ComposerKt.sourceInformation($composer3, "C(LoginHelp)N(onClickLoginHelp,routeTo)149@6069L107,153@6193L71,154@6292L6,155@6332L9,148@6025L327:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148328605, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.LoginHelp (Common.kt:147)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, -809864146, "CC(remember):Common.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & BR.containerVisible) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda16
                    public final Object invoke() {
                        Unit LoginHelp$lambda$0$0;
                        LoginHelp$lambda$0$0 = CommonKt.LoginHelp$lambda$0$0(function1, function0);
                        return LoginHelp$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_26, $composer3, 0), ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer2, 0, 0, 65528);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginHelp$lambda$1;
                    LoginHelp$lambda$1 = CommonKt.LoginHelp$lambda$1(function0, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginHelp$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LoginHelp$lambda$0$0(Function1 $routeTo, Function0 $onClickLoginHelp) {
        $routeTo.invoke(AgreementLinkHelper.LINK_ACCOUNT_CHECK_HELP);
        $onClickLoginHelp.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    public static final void SwitchLogin(final String title, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Composer $composer2;
        Modifier modifier3;
        Function0 onSwitchClick;
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Composer $composer3 = $composer.startRestartGroup(-1209302841);
        ComposerKt.sourceInformation($composer3, "C(SwitchLogin)N(title,modifier,onSwitchClick)163@6480L2,165@6492L743:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= BR.negativeBtnVisible;
            function02 = function0;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            function02 = function0;
            $dirty |= $composer3.changedInstance(function02) ? BR.hallEnterHotText : BR.cover;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & BR.danmakuNumIcon) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onSwitchClick = function02;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                onSwitchClick = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, 1796110313, "CC(remember):Common.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onSwitchClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onSwitchClick = onSwitchClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1209302841, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.SwitchLogin (Common.kt:164)");
            }
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, onSwitchClick, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -910887421, "C171@6694L9,172@6739L6,169@6632L130,177@6905L7,175@6799L232,185@7202L6,174@6771L458:Common.kt#gqoihp");
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, $dirty2 & 14, 0, 65530);
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(AppCompatResources.getDrawable((Context) consume, com.bilibili.iconfont.R.drawable.ref_arrow_forward_right_line_500), $composer3, 0), (String) null, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_bold-0d7_KjU(), $composer3, Painter.$stable | BR.pendentVisible, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function0 function03 = onSwitchClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SwitchLogin$lambda$2;
                    SwitchLogin$lambda$2 = CommonKt.SwitchLogin$lambda$2(title, modifier4, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SwitchLogin$lambda$2;
                }
            });
        }
    }

    public static final void LoginButton(final String title, boolean enable, Modifier modifier, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Modifier modifier2;
        Composer $composer2;
        boolean enable2;
        Modifier modifier3;
        boolean enable3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Intrinsics.checkNotNullParameter(function0, "onLoginClick");
        Composer $composer3 = $composer.startRestartGroup(1713416913);
        ComposerKt.sourceInformation($composer3, "C(LoginButton)N(title,enable,modifier,onLoginClick)200@7481L54,207@7748L6,197@7397L698:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            z = enable;
        } else if (($changed & 48) == 0) {
            z = enable;
            $dirty |= $composer3.changed(z) ? 32 : 16;
        } else {
            z = enable;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= BR.negativeBtnVisible;
            modifier2 = modifier;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? BR.hallEnterHotText : BR.cover;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                enable3 = true;
            } else {
                enable3 = z;
            }
            if (i3 == 0) {
                modifier4 = modifier2;
            } else {
                modifier4 = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1713416913, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.LoginButton (Common.kt:196)");
            }
            boolean z2 = !enable3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1621186151, "CC(remember):Common.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Modifier LoginButton$lambda$0$0;
                        LoginButton$lambda$0$0 = CommonKt.LoginButton$lambda$0$0((Modifier) obj);
                        return LoginButton$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(ModifierUtilsKt.clickableNoInteraction(ModifierUtilsKt.ifMatch(modifier4, z2, (Function1) it$iv), enable3, function0), 0.0f, 1, (Object) null), Dp.constructor-impl(44)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50)), Dp.constructor-impl(18), 0.0f, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -874530843, "C215@8016L6,216@8065L9,213@7954L135:Common.kt#gqoihp");
            modifier3 = modifier4;
            enable2 = enable3;
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, $dirty2 & 14, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            enable2 = z;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z3 = enable2;
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit LoginButton$lambda$2;
                    LoginButton$lambda$2 = CommonKt.LoginButton$lambda$2(title, z3, modifier5, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LoginButton$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier LoginButton$lambda$0$0(Modifier it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return AlphaKt.alpha(it, 0.4f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v19 */
    public static final void PageHead(final String title, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        final Function0 onBackPress;
        Composer $composer2;
        Function0 onBackPress2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(title, ReportUtilKt.POS_TITLE);
        Composer $composer3 = $composer.startRestartGroup(1440387058);
        ComposerKt.sourceInformation($composer3, "C(PageHead)N(title,onBackPress)222@8174L2,223@8184L1114:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            onBackPress = function0;
        } else if (($changed & 48) == 0) {
            onBackPress = function0;
            $dirty |= $composer3.changedInstance(onBackPress) ? 32 : 16;
        } else {
            onBackPress = function0;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1232495156, "CC(remember):Common.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onBackPress3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onBackPress2 = onBackPress3;
            } else {
                onBackPress2 = onBackPress;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1440387058, $dirty2, -1, "tv.danmaku.bili.fullscreen.page.PageHead (Common.kt:222)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((6 >> 6) & BR.containerVisible) | 6;
            BoxScope $this$PageHead_u24lambda_u241 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, -1303347873, "C230@8350L9,231@8396L6,228@8288L316,239@8614L678:Common.kt#gqoihp");
            Function0 onBackPress4 = onBackPress2;
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(title, PaddingKt.padding-VpY3zN4$default($this$PageHead_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenter()), Dp.constructor-impl(48), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT17b(), $composer3, $dirty2 & 14, 0, 65016);
            Modifier modifier$iv2 = $this$PageHead_u24lambda_u241.align(PaddingKt.padding-VpY3zN4(ModifierUtilsKt.clickableNoInteraction$default(Modifier.Companion, false, onBackPress4, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10)), Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -643416941, "C248@8994L7,246@8880L248,254@9255L6,245@8848L434:Common.kt#gqoihp");
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(AppCompatResources.getDrawable((Context) consume, com.bilibili.iconfont.R.drawable.ref_arrow_back_left_line_500), $composer3, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | BR.pendentVisible, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onBackPress = onBackPress4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda15
                public final Object invoke(Object obj, Object obj2) {
                    Unit PageHead$lambda$2;
                    PageHead$lambda$2 = CommonKt.PageHead$lambda$2(title, onBackPress, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PageHead$lambda$2;
                }
            });
        }
    }

    public static final void LogoGroup(final Modifier modifier, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer $composer2 = $composer.startRestartGroup(333402787);
        ComposerKt.sourceInformation($composer2, "C(LogoGroup)N(modifier)262@9363L955:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(333402787, $dirty, -1, "tv.danmaku.bili.fullscreen.page.LogoGroup (Common.kt:261)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier, Dp.constructor-impl((float) BR.errorTip));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(16), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -595368521, "C268@9643L7,268@9606L91,273@9948L6,267@9577L400,277@10053L7,277@10016L102,280@10290L6,276@9987L325:Common.kt#gqoihp");
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, com.bilibili.app.accountui.R.drawable.ic_bili_logo), $composer2, 0), (String) null, PaddingKt.padding-VpY3zN4(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(200), Dp.constructor-impl(78)), Dp.constructor-impl(33), Dp.constructor-impl(9)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | BR.pendentVisible, 56);
            CompositionLocal this_$iv2 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ImageKt.Image(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume2, com.bilibili.app.accountui.R.drawable.fullscreen_login_slogan), $composer2, 0), (String) null, SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(200), Dp.constructor-impl(22)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGa9-0d7_KjU(), 0, 2, (Object) null), $composer2, Painter.$stable | BR.pendentVisible, 56);
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
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit LogoGroup$lambda$1;
                    LogoGroup$lambda$1 = CommonKt.LogoGroup$lambda$1(modifier, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return LogoGroup$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v41 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r7v20 */
    public static final void ThirdPartyLogin(Modifier modifier, boolean googleVisible, boolean facebookVisible, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean facebookVisible2;
        Function0 onPasswordClick;
        Function0 onGoogleClick;
        Composer $composer2;
        Modifier modifier2;
        Function0 onFacebookClick;
        boolean googleVisible2;
        boolean facebookVisible3;
        Function0 onGoogleClick2;
        Modifier modifier3;
        boolean googleVisible3;
        Function0 onFacebookClick2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-21127255);
        ComposerKt.sourceInformation($composer3, "C(ThirdPartyLogin)N(modifier,googleVisible,facebookVisible,onPasswordClick,onGoogleClick,onFacebookClick)290@10505L2,291@10541L2,292@10579L2,294@10590L2159:Common.kt#gqoihp");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            z = googleVisible;
        } else if (($changed & 48) == 0) {
            z = googleVisible;
            $dirty |= $composer3.changed(z) ? 32 : 16;
        } else {
            z = googleVisible;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= BR.negativeBtnVisible;
            facebookVisible2 = facebookVisible;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            facebookVisible2 = facebookVisible;
            $dirty |= $composer3.changed(facebookVisible2) ? BR.hallEnterHotText : BR.cover;
        } else {
            facebookVisible2 = facebookVisible;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onPasswordClick = function0;
        } else if (($changed & 3072) == 0) {
            onPasswordClick = function0;
            $dirty |= $composer3.changedInstance(onPasswordClick) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        } else {
            onPasswordClick = function0;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            onGoogleClick = function02;
        } else if (($changed & 24576) == 0) {
            onGoogleClick = function02;
            $dirty |= $composer3.changedInstance(onGoogleClick) ? RingBuffer.CONSUME_SIZE : 8192;
        } else {
            onGoogleClick = function02;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changedInstance(function03) ? 131072 : AndroidResourceIdNames.RESOURCE_ID_TYPE_ITERATOR;
        }
        if (!$composer3.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            onFacebookClick = function03;
            googleVisible2 = z;
            facebookVisible3 = facebookVisible2;
            onGoogleClick2 = onGoogleClick;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                googleVisible3 = z;
            } else {
                googleVisible3 = true;
            }
            if (i4 != 0) {
                facebookVisible2 = true;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1171549611, "CC(remember):Common.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onPasswordClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onPasswordClick = onPasswordClick2;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1171550763, "CC(remember):Common.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onGoogleClick3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onGoogleClick = onGoogleClick3;
            }
            if (i7 == 0) {
                onFacebookClick2 = function03;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, 1171551979, "CC(remember):Common.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onFacebookClick2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-21127255, $dirty, -1, "tv.danmaku.bili.fullscreen.page.ThirdPartyLogin (Common.kt:293)");
            }
            Modifier modifier$iv$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            modifier2 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            onFacebookClick = onFacebookClick2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 441840348, "C299@10739L869,326@11632L41,328@11697L1046:Common.kt#gqoihp");
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((BR.nickTextColor >> 3) & 14) | ((BR.nickTextColor >> 3) & BR.containerVisible));
            int $changed$iv$iv2 = (BR.nickTextColor << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            facebookVisible3 = facebookVisible2;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            onGoogleClick2 = onGoogleClick;
            googleVisible2 = googleVisible3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i11 = ((BR.nickTextColor >> 6) & BR.containerVisible) | 6;
            RowScope $this$ThirdPartyLogin_u24lambda_u243_u240 = rowScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 1054827231, "C309@11091L6,305@10937L179,312@11158L72,313@11266L9,314@11315L6,311@11129L277,321@11573L6,317@11419L179:Common.kt#gqoihp");
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ThirdPartyLogin_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            TextKt.Text--4IGK_g(StringResources_androidKt.stringResource(R.string.account_global_string_338, $composer3, 0), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(13), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 48, 0, 65528);
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$ThirdPartyLogin_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null), $composer3, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & BR.containerVisible));
            int $changed$iv$iv3 = (54 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv3 << 6;
            int $changed$iv$iv$iv3 = ($i$f$Row & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i13 = ((54 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1759901434, "C337@12043L72,335@11916L289:Common.kt#gqoihp");
            OverseaImageText(com.bilibili.iconfont.R.drawable.ref_lock_locked_fill_500, StringResources_androidKt.stringResource(R.string.account_global_string_359, $composer3, 0), true, onPasswordClick, $composer3, ($dirty & 7168) | BR.negativeBtnVisible, 0);
            if (googleVisible2) {
                $composer3.startReplaceGroup(1760201575);
                ComposerKt.sourceInformation($composer3, "343@12281L169");
                OverseaImageText(com.bilibili.app.accountui.R.drawable.ic_google, "Google", false, onGoogleClick2, $composer3, (($dirty >> 3) & 7168) | 48, 4);
            } else {
                $composer3.startReplaceGroup(1748054442);
            }
            $composer3.endReplaceGroup();
            if (facebookVisible3) {
                $composer3.startReplaceGroup(1760460735);
                ComposerKt.sourceInformation($composer3, "351@12544L175");
                OverseaImageText(com.bilibili.app.accountui.R.drawable.ic_facebook, "Facebook", false, onFacebookClick, $composer3, (($dirty >> 6) & 7168) | 48, 4);
            } else {
                $composer3.startReplaceGroup(1748054442);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final boolean z2 = googleVisible2;
            final boolean z3 = facebookVisible3;
            final Function0 function04 = onPasswordClick;
            final Function0 function05 = onGoogleClick2;
            final Function0 function06 = onFacebookClick;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit ThirdPartyLogin$lambda$4;
                    ThirdPartyLogin$lambda$4 = CommonKt.ThirdPartyLogin$lambda$4(modifier4, z2, z3, function04, function05, function06, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ThirdPartyLogin$lambda$4;
                }
            });
        }
    }

    public static final void OverseaImageText(final int imageRes, final String text, boolean iconFont, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Composer $composer$iv$iv$iv;
        boolean iconFont2;
        boolean iconFont3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(1836721005);
        ComposerKt.sourceInformation($composer2, "C(OverseaImageText)N(imageRes,text,iconFont,onClick)370@12955L13,368@12896L1404:Common.kt#gqoihp");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(imageRes) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(text) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= BR.negativeBtnVisible;
            z = iconFont;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            z = iconFont;
            $dirty |= $composer2.changed(z) ? BR.hallEnterHotText : BR.cover;
        } else {
            z = iconFont;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : MisakaHelper.MAX_REPORT_SIZE;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer$iv$iv$iv = $composer2;
            $composer$iv$iv$iv.skipToGroupEnd();
            iconFont2 = z;
        } else {
            if (i2 != 0) {
                iconFont3 = false;
            } else {
                iconFont3 = z;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1836721005, $dirty, -1, "tv.danmaku.bili.fullscreen.page.OverseaImageText (Common.kt:367)");
            }
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, -142667046, "CC(remember):Common.kt#9igjgp");
            boolean invalid$iv = ($dirty & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit OverseaImageText$lambda$0$0;
                        OverseaImageText$lambda$0$0 = CommonKt.OverseaImageText$lambda$0$0(function0);
                        return OverseaImageText$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((BR.negativeBtnVisible >> 3) & 14) | ((BR.negativeBtnVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.negativeBtnVisible << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((BR.negativeBtnVisible >> 6) & BR.containerVisible) | 6;
            ColumnScope $this$OverseaImageText_u24lambda_u241 = columnScope;
            ComposerKt.sourceInformationMarkerStart($composer2, -928649665, "C376@13220L6,373@13045L935,397@13989L40,400@14099L9,401@14144L6,398@14038L256:Common.kt#gqoihp");
            Modifier modifier$iv2 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), Color.Companion.getTransparent-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & BR.containerVisible;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer$iv$iv$iv = $composer2;
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1466379361, "C:Common.kt#gqoihp");
            if (!iconFont3) {
                iconFont2 = iconFont3;
                $composer2.startReplaceGroup(-1465972859);
                ComposerKt.sourceInformation($composer2, "391@13813L25,390@13776L180");
                ImageKt.Image(PainterResources_androidKt.painterResource(imageRes, $composer2, $dirty & 14), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer2, Painter.$stable | BR.pendentVisible, 120);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1466372666);
                ComposerKt.sourceInformation($composer2, "382@13476L7,381@13403L166,387@13708L6,380@13367L371");
                CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
                iconFont2 = iconFont3;
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer2.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IconKt.Icon-ww6aTOc(DrawablePainterKt.rememberDrawablePainter(KtxKt.getAppCompatDrawable((Context) consume, imageRes), $composer2, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), $composer2, Painter.$stable | BR.pendentVisible, 0);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer2, 6);
            TextKt.Text--4IGK_g(text, $this$OverseaImageText_u24lambda_u241.align(Modifier.Companion, Alignment.Companion.getCenterHorizontally()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, ($dirty >> 3) & 14, 0, 65016);
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
        ScopeUpdateScope endRestartGroup = $composer$iv$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = iconFont2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.fullscreen.page.CommonKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit OverseaImageText$lambda$2;
                    OverseaImageText$lambda$2 = CommonKt.OverseaImageText$lambda$2(imageRes, text, z2, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OverseaImageText$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OverseaImageText$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }
}