package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import bili.resource.playerbaseres.String1_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import bili.resource.playerbaseres.String3_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.CardTag;
import video.biz.offline.list.ui.widget.IconType;

/* compiled from: OfflineBadge.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"toBadgeModel", "Lvideo/biz/offline/list/ui/widget/OfflineBadgeModel;", "Lvideo/biz/offline/list/logic/model/CardTag;", "(Lvideo/biz/offline/list/logic/model/CardTag;Landroidx/compose/runtime/Composer;I)Lvideo/biz/offline/list/ui/widget/OfflineBadgeModel;", "OfflineBadgeView", "", "badge", "modifier", "Landroidx/compose/ui/Modifier;", "(Lvideo/biz/offline/list/ui/widget/OfflineBadgeModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineBadgeKt {

    /* compiled from: OfflineBadge.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardTag.values().length];
            try {
                iArr[CardTag.CHARGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CardTag.BANGUMI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CardTag.MOVIE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[CardTag.DOCUMENTARY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[CardTag.CN_BANGUMI.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[CardTag.TV_SERIES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[CardTag.VARIETY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineBadgeView$lambda$0(OfflineBadgeModel offlineBadgeModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OfflineBadgeView(offlineBadgeModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineBadgeView$lambda$2(OfflineBadgeModel offlineBadgeModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        OfflineBadgeView(offlineBadgeModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final OfflineBadgeModel toBadgeModel(CardTag $this$toBadgeModel, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$toBadgeModel, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -179963981, "C(toBadgeModel):OfflineBadge.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-179963981, $changed, -1, "video.biz.offline.list.ui.widget.toBadgeModel (OfflineBadge.kt:44)");
        }
        OfflineBadgeModel offlineBadgeModel = null;
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toBadgeModel.ordinal()]) {
            case 1:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2237(PlayerbaseresRes.INSTANCE.getString())), new IconType.IconFont("battery_charge_simple_fill"));
                break;
            case 2:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_575(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
            case 3:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String1_commonMainKt.getPlayerbaseres_global_string_2096(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
            case 4:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1062(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
            case 5:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_732(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
            case 6:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String3_commonMainKt.getPlayerbaseres_global_string_985(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
            case 7:
                offlineBadgeModel = new OfflineBadgeModel(PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2211(PlayerbaseresRes.INSTANCE.getString())), null, 2, null);
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return offlineBadgeModel;
    }

    public static final void OfflineBadgeView(final OfflineBadgeModel badge, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        final Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1571939556);
        ComposerKt.sourceInformation($composer2, "C(OfflineBadgeView)N(badge,modifier)95@3289L6,90@3123L1145:OfflineBadge.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(badge) : $composer2.changedInstance(badge) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571939556, $dirty, -1, "video.biz.offline.list.ui.widget.OfflineBadgeView (OfflineBadge.kt:88)");
            }
            if (badge != null) {
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(modifier3, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(2), Dp.constructor-impl((float) 0.5d));
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier modifier4 = modifier3;
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
                int i4 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 1441097082, "C122@4163L9,123@4208L6,120@4096L166:OfflineBadge.kt#uys4uf");
                IconType icon = badge.getIcon();
                if (icon instanceof IconType.IconFont) {
                    $composer2.startReplaceGroup(1441199412);
                    ComposerKt.sourceInformation($composer2, "101@3519L44");
                    Painter it = BiliIconfontKt.rememberIconFontPainter(((IconType.IconFont) badge.getIcon()).getIconFont(), $composer2, 0);
                    if (it == null) {
                        $composer2.startReplaceGroup(1441199411);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(1441199412);
                        ComposerKt.sourceInformation($composer2, "*104@3676L6,102@3591L234");
                        IconKt.Icon-ww6aTOc(it, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_white-0d7_KjU(), $composer2, Painter.$stable | 432, 0);
                        $composer2.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    }
                    $composer2.endReplaceGroup();
                } else if (icon instanceof IconType.Image) {
                    $composer2.startReplaceGroup(1441520169);
                    ComposerKt.sourceInformation($composer2, "112@3910L129");
                    String $this$asRequest_u24default$iv = ((IconType.Image) badge.getIcon()).getUrl();
                    BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer2, 48, 508);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(1441696776);
                    $composer2.endReplaceGroup();
                }
                TextKt.Text-Nvy7gAk(badge.getText(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT10(), $composer2, 0, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineBadgeKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit OfflineBadgeView$lambda$0;
                            OfflineBadgeView$lambda$0 = OfflineBadgeKt.OfflineBadgeView$lambda$0(OfflineBadgeModel.this, modifier3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return OfflineBadgeView$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineBadgeKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineBadgeView$lambda$2;
                    OfflineBadgeView$lambda$2 = OfflineBadgeKt.OfflineBadgeView$lambda$2(OfflineBadgeModel.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineBadgeView$lambda$2;
                }
            });
        }
    }
}