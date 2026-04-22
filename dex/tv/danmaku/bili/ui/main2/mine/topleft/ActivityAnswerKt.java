package tv.danmaku.bili.ui.main2.mine.topleft;

import ComposableSingletons$CustomBottomSheetKt$;
import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.main2.api.AccountMine;
import tv.danmaku.bili.ui.main2.mine.GarbEnum;

/* compiled from: ActivityAnswer.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"ActivityAnswer", "", "activityAnswer", "Ltv/danmaku/bili/ui/main2/api/AccountMine$ActivityAnswer;", "garb", "Ltv/danmaku/bili/ui/main2/mine/GarbEnum;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ltv/danmaku/bili/ui/main2/api/AccountMine$ActivityAnswer;Ltv/danmaku/bili/ui/main2/mine/GarbEnum;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "rememberColorState", "Ltv/danmaku/bili/ui/main2/mine/topleft/ColorState;", "(Ltv/danmaku/bili/ui/main2/mine/GarbEnum;Landroidx/compose/runtime/Composer;I)Ltv/danmaku/bili/ui/main2/mine/topleft/ColorState;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ActivityAnswerKt {

    /* compiled from: ActivityAnswer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GarbEnum.values().length];
            try {
                iArr[GarbEnum.PURE_WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[GarbEnum.PURE_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[GarbEnum.PURE_NIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[GarbEnum.DARK_GARB_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[GarbEnum.DARK_GARB_NIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[GarbEnum.LIGHT_GARB_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[GarbEnum.LIGHT_GARB_NIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityAnswer$lambda$3(AccountMine.ActivityAnswer activityAnswer, GarbEnum garbEnum, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ActivityAnswer(activityAnswer, garbEnum, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0273, code lost:
        if ((!kotlin.text.StringsKt.isBlank(r2)) == true) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ActivityAnswer(final AccountMine.ActivityAnswer activityAnswer, final GarbEnum garb, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        int i2;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(activityAnswer, "activityAnswer");
        Intrinsics.checkNotNullParameter(garb, "garb");
        Composer $composer2 = $composer.startRestartGroup(-408483648);
        ComposerKt.sourceInformation($composer2, "C(ActivityAnswer)N(activityAnswer,garb,modifier)41@1524L166,41@1486L204,49@1710L5:ActivityAnswer.kt#2hz67j");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(activityAnswer) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(garb.ordinal()) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty2 |= BR.negativeBtnVisible;
            modifier2 = modifier;
        } else if (($changed & BR.negativeBtnVisible) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? BR.hallEnterHotText : BR.cover;
        } else {
            modifier2 = modifier;
        }
        if (!$composer2.shouldExecute(($dirty2 & BR.danmakuNumIcon) != 146, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-408483648, $dirty2, -1, "tv.danmaku.bili.ui.main2.mine.topleft.ActivityAnswer (ActivityAnswer.kt:40)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1710756602, "CC(remember):ActivityAnswer.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new ActivityAnswerKt$ActivityAnswer$1$1(null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(activityAnswer, (Function2) it$iv, $composer2, $dirty2 & 14);
            $composer2.startMovableGroup(-1710749245, Long.valueOf(BiliTheme.INSTANCE.getTheme($composer2, BiliTheme.$stable).getId()));
            ComposerKt.sourceInformation($composer2, "50@1743L24,51@1803L7,58@2023L458,52@1819L1890");
            ColorState colors = rememberColorState(garb, $composer2, ($dirty2 >> 3) & 14);
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            Modifier modifier5 = BackgroundKt.background-bw27NRU(modifier4, colors.m2114getBack0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer2, -1710740342, "CC(remember):ActivityAnswer.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(activityAnswer) | $composer2.changedInstance(context);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.ActivityAnswerKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit ActivityAnswer$lambda$1$0;
                        ActivityAnswer$lambda$1$0 = ActivityAnswerKt.ActivityAnswer$lambda$1$0(AccountMine.ActivityAnswer.this, context);
                        return ActivityAnswer$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((BR.pendentVisible >> 3) & 14) | ((BR.pendentVisible >> 3) & BR.containerVisible));
            int $changed$iv$iv = (BR.pendentVisible << 3) & BR.containerVisible;
            $dirty = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            modifier3 = modifier4;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((BR.pendentVisible >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 209337397, "C101@3671L9,96@3459L240:ActivityAnswer.kt#2hz67j");
            String badge = activityAnswer.badge;
            if (badge != null) {
                i2 = 1;
            }
            i2 = 0;
            if (i2 == 0) {
                $composer$iv$iv = $composer2;
                $composer$iv$iv$iv = $composer2;
                $composer$iv = $composer2;
                $composer2.startReplaceGroup(206650099);
            } else {
                $composer2.startReplaceGroup(209404511);
                ComposerKt.sourceInformation($composer2, "77@2772L659");
                Modifier modifier$iv2 = BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(28), Dp.constructor-impl(16)), BiliColorsSourceKt.getDayColors().getOperate_orange-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
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
                int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & BR.containerVisible) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1326799209, "C88@3231L9,86@3145L268:ActivityAnswer.kt#2hz67j");
                $composer$iv$iv = $composer2;
                $composer$iv$iv$iv = $composer2;
                $composer$iv = $composer2;
                TextKt.Text--4IGK_g(badge, (Modifier) null, BiliColorsSourceKt.getDayColors().getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getClip-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 0, 3120, 55290);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            String str = activityAnswer.text;
            if (str == null) {
                str = "";
            }
            TextKt.Text--4IGK_g(str, (Modifier) null, colors.m2115getFront0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), $composer2, 0, 3120, 55290);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endMovableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.topleft.ActivityAnswerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ActivityAnswer$lambda$3;
                    ActivityAnswer$lambda$3 = ActivityAnswerKt.ActivityAnswer$lambda$3(AccountMine.ActivityAnswer.this, garb, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ActivityAnswer$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActivityAnswer$lambda$1$0(AccountMine.ActivityAnswer $activityAnswer, Context $context) {
        Neurons.reportClick(false, "main.my-information.answer-in-guide.0.click", MapsKt.mapOf(TuplesKt.to("type", AudioIntentHelper.FROM_ACTIVITY)));
        String str = $activityAnswer.url;
        if (str == null) {
            str = "";
        }
        BLRouter.routeTo(RouteRequestKt.toRouteRequest(str), $context);
        return Unit.INSTANCE;
    }

    public static final ColorState rememberColorState(GarbEnum garb, Composer $composer, int $changed) {
        Object colorState;
        Intrinsics.checkNotNullParameter(garb, "garb");
        ComposerKt.sourceInformationMarkerStart($composer, -702851270, "C(rememberColorState)N(garb)109@3795L946:ActivityAnswer.kt#2hz67j");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-702851270, $changed, -1, "tv.danmaku.bili.ui.main2.mine.topleft.rememberColorState (ActivityAnswer.kt:108)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1130202004, "CC(remember):ActivityAnswer.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(garb.ordinal())) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            switch (WhenMappings.$EnumSwitchMapping$0[garb.ordinal()]) {
                case 1:
                    colorState = new ColorState(BiliColorsSourceKt.getDayColors().getOperate_orange_thin-0d7_KjU(), BiliColorsSourceKt.getDayColors().getOperate_orange-0d7_KjU(), null);
                    break;
                case 2:
                    colorState = new ColorState(BiliColorsSourceKt.getDayColors().getText_white-0d7_KjU(), BiliColorsSourceKt.getDayColors().getOperate_orange-0d7_KjU(), null);
                    break;
                case 3:
                    colorState = new ColorState(BiliColorsSourceKt.getNightColors().getOperate_orange_thin-0d7_KjU(), BiliColorsSourceKt.getNightColors().getOperate_orange-0d7_KjU(), null);
                    break;
                case 4:
                case 5:
                    colorState = new ColorState(ColorKt.Color(2150839091L), BiliColorsSourceKt.getDayColors().getText_white-0d7_KjU(), null);
                    break;
                case 6:
                case 7:
                    colorState = new ColorState(BiliColorsSourceKt.getDayColors().getOperate_orange_thin-0d7_KjU(), BiliColorsSourceKt.getDayColors().getOperate_orange-0d7_KjU(), null);
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            Object value$iv = colorState;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ColorState colorState2 = (ColorState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return colorState2;
    }
}