package kntr.app.tribee.consume.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bapis.bilibili.app.dynamic.v2.KColor;
import com.bapis.bilibili.app.dynamic.v2.KDynReplyIcon;
import com.bapis.bilibili.app.dynamic.v2.KLightDarkIcon;
import com.bapis.bilibili.app.dynamic.v2.KTitleCategoryText;
import com.bapis.bilibili.app.dynamic.v2.KTitleTagPic;
import com.bapis.bilibili.app.dynamic.v2.KTribeeCategory;
import com.bapis.bilibili.app.dynamic.v2.KTribeeDyn;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSortType;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.FontResources_androidKt;
import srcs.common.compose.res.generated.resources.Font0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: TribeePostCompose.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"TribeePost", "", "tribeeId", "", "fromSpmid", "category", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;", "selectedCategoryId", "", "post", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;", "sortType", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeCategory;JLcom/bapis/bilibili/app/dynamic/v2/KTribeeDyn;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSortType;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePostComposeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePost$lambda$4(String str, String str2, KTribeeCategory kTribeeCategory, long j, KTribeeDyn kTribeeDyn, KTribeeSortType kTribeeSortType, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeePost(str, str2, kTribeeCategory, j, kTribeeDyn, kTribeeSortType, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x066a  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x077b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x082d  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x09a8 A[LOOP:2: B:189:0x09a2->B:191:0x09a8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x09e8  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0c2b  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0c37  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0c3d  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0cbf  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0d4c  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0e4b  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0e57  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0e5d  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0ee1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0fa3  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0fd5  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x1056  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x10ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeePost(final String tribeeId, final String fromSpmid, final KTribeeCategory category, final long selectedCategoryId, final KTribeeDyn post, final KTribeeSortType sortType, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        int $dirty;
        int i2;
        Modifier modifier4;
        String str;
        int i3;
        Composer $composer3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        ThemeDayNight theme;
        Color color;
        long color2;
        KDynReplyIcon replyIcon;
        final ThemeDayNight theme2;
        String $this$asRequest$iv;
        Object it$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv3;
        AnnotatedString.Builder $this$TribeePost_u24lambda_u243_u241_u242;
        int index$iv;
        Function0 factory$iv$iv$iv4;
        RowScope $this$TribeePost_u24lambda_u243_u241_u243;
        Composer $composer$iv$iv;
        Function0 factory$iv$iv$iv5;
        Composer $composer$iv2;
        Composer $composer$iv3;
        long j;
        KLightDarkIcon icon;
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(post, "post");
        Intrinsics.checkNotNullParameter(sortType, "sortType");
        Composer $composer4 = $composer.startRestartGroup(502098844);
        ComposerKt.sourceInformation($composer4, "C(TribeePost)N(tribeeId,fromSpmid,category,selectedCategoryId,post,sortType,modifier)71@2981L386,71@2930L437,84@3404L7,85@3443L7,86@3480L7,91@3607L6,93@3687L39,95@3785L658,87@3492L9801:TribeePostCompose.kt#iitu82");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(tribeeId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changed(fromSpmid) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changedInstance(category) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(selectedCategoryId) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer4.changedInstance(post) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(sortType) ? 131072 : 65536;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty2 |= 1572864;
            modifier2 = modifier;
        } else if ((1572864 & $changed) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 1048576 : 524288;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if ($composer4.shouldExecute((599187 & $dirty3) != 599186, $dirty3 & 1)) {
            Modifier modifier5 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(502098844, $dirty3, -1, "kntr.app.tribee.consume.page.TribeePost (TribeePostCompose.kt:70)");
            }
            Long valueOf = Long.valueOf(selectedCategoryId);
            ComposerKt.sourceInformationMarkerStart($composer4, 1480660926, "CC(remember):TribeePostCompose.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 7168) == 2048) | $composer4.changedInstance(category) | (($dirty3 & 14) == 4) | $composer4.changedInstance(post) | (($dirty3 & 112) == 32) | $composer4.changedInstance(sortType);
            Object value$iv = $composer4.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                $dirty = $dirty3;
                i2 = 0;
                modifier4 = modifier5;
                str = "CC(remember):TribeePostCompose.kt#9igjgp";
                i3 = 1;
                $composer3 = $composer4;
                value$iv = new TribeePostComposeKt$TribeePost$1$1(selectedCategoryId, category, tribeeId, post, fromSpmid, sortType, null);
                $composer4.updateRememberedValue(value$iv);
            } else {
                str = "CC(remember):TribeePostCompose.kt#9igjgp";
                $dirty = $dirty3;
                modifier4 = modifier5;
                $composer3 = $composer4;
                i3 = 1;
                i2 = 0;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(post, category, valueOf, (Function2) value$iv, $composer3, (($dirty >> 12) & 14) | (($dirty >> 3) & 112) | (($dirty >> 3) & 896));
            CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
            Composer $composer$iv4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer$iv4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ThemeDayNight theme3 = (ThemeDayNight) consume;
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer$iv4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            final Density density = (Density) consume2;
            CompositionLocal this_$iv3 = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer$iv4.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            final Router router = (Router) consume3;
            Modifier modifier6 = modifier4;
            Composer $composer5 = $composer3;
            Modifier modifier7 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(modifier6, 0.0f, i3, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, 1480683171, str);
            Object it$iv2 = $composer5.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer5.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 1480686926, str);
            int i5 = ($composer5.changedInstance(post) ? 1 : 0) | ($composer5.changedInstance(router) ? 1 : 0) | (($dirty & 14) == 4 ? i3 : i2) | ($composer5.changedInstance(category) ? 1 : 0) | (($dirty & 112) == 32 ? i3 : i2) | ($composer5.changedInstance(sortType) ? 1 : 0);
            Object value$iv3 = $composer5.rememberedValue();
            if (i5 != 0 || value$iv3 == Composer.Companion.getEmpty()) {
                $composer2 = $composer5;
                modifier3 = modifier6;
                value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.TribeePostComposeKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit TribeePost$lambda$2$0;
                        TribeePost$lambda$2$0 = TribeePostComposeKt.TribeePost$lambda$2$0(post, router, tribeeId, category, fromSpmid, sortType);
                        return TribeePost$lambda$2$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv3);
            } else {
                $composer2 = $composer5;
                modifier3 = modifier6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) value$iv3, 28, (Object) null);
            int $changed$iv = i2;
            Composer $composer$iv5 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv5, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv5, i2));
            CompositionLocalMap localMap$iv$iv = $composer$iv5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv5, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv5.startReusableNode();
            if ($composer$iv5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer$iv5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i7 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$TribeePost_u24lambda_u243 = RowScopeInstance.INSTANCE;
            Composer $composer6 = $composer$iv5;
            ComposerKt.sourceInformationMarkerStart($composer6, 323775881, "C112@4461L1615,157@6086L7201:TribeePostCompose.kt#iitu82");
            Modifier modifier$iv2 = $this$TribeePost_u24lambda_u243.align(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(10), 0.0f, 11, (Object) null), Dp.constructor-impl(26)), Alignment.Companion.getCenterVertically());
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i9 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 684369312, "C130@5190L387,142@5608L29,144@5689L71,152@5992L6,147@5773L293:TribeePostCompose.kt#iitu82");
            KDynReplyIcon replyIcon2 = post.getReplyIcon();
            try {
                if (replyIcon2 != null) {
                    KColor color3 = replyIcon2.getColor();
                    if (color3 != null) {
                        String it = TribeeExtensionsKt.getColor(color3, theme3);
                        if (it != null) {
                            String str2 = it;
                            if (!(StringsKt.startsWith$default(it, "#", false, 2, (Object) null) && (it.length() == 7 || it.length() == 9))) {
                                str2 = null;
                            }
                            if (str2 != null) {
                                color = Color.box-impl(ComposeColorParserKt.parseColor(str2));
                                long it2 = color.unbox-impl();
                                theme = theme3;
                                if (Color.equals-impl0(it2, Color.Companion.getTransparent-0d7_KjU())) {
                                    color = null;
                                }
                                if (color != null) {
                                    $composer6.startReplaceGroup(1823201243);
                                    ComposerKt.sourceInformation($composer6, "129@5165L6");
                                    long j2 = BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText4-0d7_KjU();
                                    $composer6.endReplaceGroup();
                                    color2 = j2;
                                } else {
                                    $composer6.startReplaceGroup(1823191726);
                                    $composer6.endReplaceGroup();
                                    color2 = color.unbox-impl();
                                }
                                replyIcon = post.getReplyIcon();
                                if (replyIcon != null || (icon = replyIcon.getIcon()) == null) {
                                    theme2 = theme;
                                    $this$asRequest$iv = null;
                                } else {
                                    theme2 = theme;
                                    $this$asRequest$iv = TribeeExtensionsKt.getUrl(icon, theme2);
                                }
                                if ($this$asRequest$iv == null) {
                                    $this$asRequest$iv = "";
                                }
                                ImageRequest $this$TribeePost_u24lambda_u243_u240_u242 = new ImageRequest($this$asRequest$iv);
                                $this$TribeePost_u24lambda_u243_u240_u242.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, color2, 0, 2, (Object) null));
                                BiliImageKt.BiliImage($this$TribeePost_u24lambda_u243_u240_u242.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer6, 48, 508);
                                Font numberFont = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer6, 0, 14);
                                ComposerKt.sourceInformationMarkerStart($composer6, 1823217853, str);
                                it$iv = $composer6.rememberedValue();
                                if (it$iv != Composer.Companion.getEmpty()) {
                                    Object value$iv4 = FontFamilyKt.FontFamily(new Font[]{numberFont});
                                    $composer6.updateRememberedValue(value$iv4);
                                    it$iv = value$iv4;
                                }
                                FontFamily numberFontFamily = (FontFamily) it$iv;
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                KDynReplyIcon replyIcon3 = post.getReplyIcon();
                                TextKt.Text-Nvy7gAk((replyIcon3 != null || (r7 = replyIcon3.getStat()) == null) ? "0" : "0", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, numberFontFamily, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer6, 12607536, 48, 259944);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                $composer6.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                ComposerKt.sourceInformationMarkerEnd($composer6);
                                Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                                $composer$iv = $composer6;
                                ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv3 = (6 << 3) & 112;
                                Modifier modifier$iv$iv = modifier$iv3;
                                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                                CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv$iv);
                                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                $composer$iv$iv$iv = $composer$iv;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer$iv$iv$iv.startReusableNode();
                                if ($composer$iv$iv$iv.getInserting()) {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                    $composer$iv$iv$iv.useNode();
                                } else {
                                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv3);
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv$iv$iv);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                                int i10 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                                int i11 = ((6 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1922811752, "C212@8879L1774,253@10667L2610:TribeePostCompose.kt#iitu82");
                                List tagPics = post.getTitleTags();
                                List $this$mapIndexed$iv = tagPics;
                                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                                Iterable $this$mapIndexedTo$iv$iv = $this$mapIndexed$iv;
                                int index$iv$iv = 0;
                                for (Object item$iv$iv : $this$mapIndexedTo$iv$iv) {
                                    int index$iv$iv2 = index$iv$iv + 1;
                                    if (index$iv$iv < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    KTitleTagPic kTitleTagPic = (KTitleTagPic) item$iv$iv;
                                    Iterable $this$mapIndexedTo$iv$iv2 = $this$mapIndexedTo$iv$iv;
                                    int index = index$iv$iv;
                                    destination$iv$iv.add("pic_" + index);
                                    index$iv$iv = index$iv$iv2;
                                    $this$mapIndexed$iv = $this$mapIndexed$iv;
                                    $this$mapIndexedTo$iv$iv = $this$mapIndexedTo$iv$iv2;
                                }
                                List tagPicIds = (List) destination$iv$iv;
                                String tagDividerId = "divider";
                                $composer$iv$iv$iv.startReplaceGroup(630713534);
                                ComposerKt.sourceInformation($composer$iv$iv$iv, "");
                                Map inlineContentMap = new LinkedHashMap();
                                $composer$iv$iv$iv.startReplaceGroup(630713704);
                                ComposerKt.sourceInformation($composer$iv$iv$iv, "*173@7047L823");
                                List $this$forEachIndexed$iv = tagPics;
                                int index$iv2 = 0;
                                for (Object item$iv : $this$forEachIndexed$iv) {
                                    int index$iv3 = index$iv2 + 1;
                                    if (index$iv2 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    List tagPics2 = tagPics;
                                    final KTitleTagPic pic = (KTitleTagPic) item$iv;
                                    Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                    int index2 = index$iv2;
                                    inlineContentMap.put(tagPicIds.get(index2), new InlineTextContent(new Placeholder(density.toSp-kPz2Gy4(((float) pic.getWidth()) + density.toPx-0680j_4(Dp.constructor-impl(4))), density.toSp-kPz2Gy4((float) pic.getHeight()), PlaceholderVerticalAlign.Companion.getTextCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(300909684, true, new Function3() { // from class: kntr.app.tribee.consume.page.TribeePostComposeKt$$ExternalSyntheticLambda1
                                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                                            Unit TribeePost$lambda$3$1$1$0$2;
                                            TribeePost$lambda$3$1$1$0$2 = TribeePostComposeKt.TribeePost$lambda$3$1$1$0$2(pic, theme2, density, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                                            return TribeePost$lambda$3$1$1$0$2;
                                        }
                                    }, $composer$iv$iv$iv, 54)));
                                    index$iv2 = index$iv3;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    tagPics = tagPics2;
                                    modifier$iv$iv = modifier$iv$iv;
                                    $composer$iv$iv$iv = $composer$iv$iv$iv;
                                    $composer6 = $composer6;
                                    $composer$iv = $composer$iv;
                                }
                                Composer $composer$iv6 = $composer$iv;
                                Composer $composer7 = $composer6;
                                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                                $composer$iv$iv$iv.endReplaceGroup();
                                inlineContentMap.put("divider", new InlineTextContent(new Placeholder(density.toSp-0xMU5do(Dp.constructor-impl(9)), density.toSp-0xMU5do(Dp.constructor-impl(14)), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableSingletons$TribeePostComposeKt.INSTANCE.m679getLambda$773400562$consume_debug()));
                                $composer$iv$iv$iv.endReplaceGroup();
                                $composer$iv$iv$iv.startReplaceGroup(630793969);
                                ComposerKt.sourceInformation($composer$iv$iv$iv, "*241@10269L6");
                                boolean z = false;
                                $this$TribeePost_u24lambda_u243_u241_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                                boolean z2 = false;
                                for (Object element$iv : tagPicIds) {
                                    boolean z3 = z;
                                    String it3 = (String) element$iv;
                                    InlineTextContentKt.appendInlineContent$default($this$TribeePost_u24lambda_u243_u241_u242, it3, (String) null, 2, (Object) null);
                                    tagDividerId = tagDividerId;
                                    z = z3;
                                    z2 = z2;
                                }
                                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv3;
                                $composer$iv$iv$iv.startReplaceGroup(630799299);
                                ComposerKt.sourceInformation($composer$iv$iv$iv, "");
                                Iterable $this$forEach$iv = post.getCategories();
                                boolean z4 = false;
                                for (Object element$iv2 : $this$forEach$iv) {
                                    KTitleCategoryText tagText = (KTitleCategoryText) element$iv2;
                                    FontWeight bold = FontWeight.Companion.getBold();
                                    long sp = TextUnitKt.getSp(16);
                                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                                    Color color4 = Color.box-impl(ComposeColorParserKt.parseColor(TribeeExtensionsKt.getColor(tagText.getFontColor(), theme2)));
                                    ThemeDayNight theme4 = theme2;
                                    Density density2 = density;
                                    long it4 = color4.unbox-impl();
                                    List tagPicIds2 = tagPicIds;
                                    boolean z5 = z4;
                                    if (Color.equals-impl0(it4, Color.Companion.getTransparent-0d7_KjU())) {
                                        color4 = null;
                                    }
                                    if (color4 == null) {
                                        $composer$iv$iv$iv.startReplaceGroup(131459755);
                                        ComposerKt.sourceInformation($composer$iv$iv$iv, "229@9774L6");
                                        long j3 = BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getGa7-0d7_KjU();
                                        $composer$iv$iv$iv.endReplaceGroup();
                                        j = j3;
                                    } else {
                                        $composer$iv$iv$iv.startReplaceGroup(131450424);
                                        $composer$iv$iv$iv.endReplaceGroup();
                                        j = color4.unbox-impl();
                                    }
                                    SpanStyle style$iv = new SpanStyle(j, sp, bold, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null);
                                    int index$iv4 = $this$TribeePost_u24lambda_u243_u241_u242.pushStyle(style$iv);
                                    try {
                                        $this$TribeePost_u24lambda_u243_u241_u242.append(tagText.getName());
                                        MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                                        try {
                                            InlineTextContentKt.appendInlineContent$default($this$TribeePost_u24lambda_u243_u241_u242, tagDividerId, (String) null, 2, (Object) null);
                                            Unit unit = Unit.INSTANCE;
                                            $this$TribeePost_u24lambda_u243_u241_u242.pop(index$iv4);
                                            $this$forEach$iv = $this$forEach$iv2;
                                            z4 = z5;
                                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                                            density = density2;
                                            theme2 = theme4;
                                            tagPicIds = tagPicIds2;
                                        } catch (Throwable th) {
                                            th = th;
                                            $this$TribeePost_u24lambda_u243_u241_u242.pop(index$iv4);
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                $composer$iv$iv$iv.endReplaceGroup();
                                SpanStyle style$iv2 = new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null);
                                index$iv = $this$TribeePost_u24lambda_u243_u241_u242.pushStyle(style$iv2);
                                $this$TribeePost_u24lambda_u243_u241_u242.append(post.getTitle());
                                Unit unit2 = Unit.INSTANCE;
                                $this$TribeePost_u24lambda_u243_u241_u242.pop(index$iv);
                                AnnotatedString annotatedString = $this$TribeePost_u24lambda_u243_u241_u242.toAnnotatedString();
                                $composer$iv$iv$iv.endReplaceGroup();
                                TextKt.Text-Z58ophY(annotatedString, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, inlineContentMap, (Function1) null, (TextStyle) null, $composer$iv$iv$iv, 48, 24960, 438268);
                                Modifier modifier$iv4 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(29)), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null);
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv$iv$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                                int $changed$iv$iv4 = (6 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv, 0));
                                CompositionLocalMap localMap$iv$iv4 = $composer$iv$iv$iv.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv, modifier$iv4);
                                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer$iv$iv$iv.startReusableNode();
                                if ($composer$iv$iv$iv.getInserting()) {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                                    $composer$iv$iv$iv.useNode();
                                } else {
                                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                                    $composer$iv$iv$iv.createNode(factory$iv$iv$iv4);
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv$iv$iv);
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                                int i12 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                int i13 = ((6 >> 6) & 112) | 6;
                                RowScope $this$TribeePost_u24lambda_u243_u241_u2432 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -565230264, "C:TribeePostCompose.kt#iitu82");
                                if (StringsKt.isBlank(post.getLeftText())) {
                                    $composer$iv$iv$iv.startReplaceGroup(-565237860);
                                    ComposerKt.sourceInformation($composer$iv$iv$iv, "263@11033L6,261@10939L405");
                                    $this$TribeePost_u24lambda_u243_u241_u243 = $this$TribeePost_u24lambda_u243_u241_u2432;
                                    TextKt.Text-Nvy7gAk(post.getLeftText(), $this$TribeePost_u24lambda_u243_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeePost_u24lambda_u243_u241_u2432, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv$iv$iv, 24576, 25008, 239592);
                                } else {
                                    $this$TribeePost_u24lambda_u243_u241_u243 = $this$TribeePost_u24lambda_u243_u241_u2432;
                                    $composer$iv$iv$iv.startReplaceGroup(-576102895);
                                }
                                $composer$iv$iv$iv.endReplaceGroup();
                                if (StringsKt.isBlank(post.getRightText()) || !StringsKt.isBlank(post.getViewStat())) {
                                    $composer$iv$iv$iv.startReplaceGroup(-564694027);
                                    ComposerKt.sourceInformation($composer$iv$iv$iv, "273@11465L1193");
                                    Modifier modifier$iv5 = $this$TribeePost_u24lambda_u243_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeePost_u24lambda_u243_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
                                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getEnd();
                                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer$iv$iv$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                    int $changed$iv$iv5 = (48 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv, 0));
                                    CompositionLocalMap localMap$iv$iv5 = $composer$iv$iv$iv.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv, modifier$iv5);
                                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                                    $composer$iv$iv = $composer$iv;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                    if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer$iv$iv$iv.startReusableNode();
                                    if ($composer$iv$iv$iv.getInserting()) {
                                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                                        $composer$iv$iv$iv.useNode();
                                    } else {
                                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                                        $composer$iv$iv$iv.createNode(factory$iv$iv$iv5);
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv$iv$iv);
                                    $composer$iv2 = $composer$iv$iv$iv;
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                                    int i14 = ($changed$iv$iv$iv5 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                                    int i15 = ((48 >> 6) & 112) | 6;
                                    RowScope $this$TribeePost_u24lambda_u243_u241_u243_u240 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1916951487, "C:TribeePostCompose.kt#iitu82");
                                    if (StringsKt.isBlank(post.getViewStat())) {
                                        $composer$iv$iv$iv.startReplaceGroup(1916982238);
                                        ComposerKt.sourceInformation($composer$iv$iv$iv, "279@11802L19,281@11971L6,278@11741L339,286@12219L6,284@12109L501");
                                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getEye_browse_line_900($composer$iv$iv$iv, 6), "stat icon", $this$TribeePost_u24lambda_u243_u241_u243_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenterVertically()), BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText3-0d7_KjU(), $composer$iv$iv$iv, Painter.$stable | 48, 0);
                                        $composer$iv3 = $composer$iv$iv$iv;
                                        TextKt.Text-Nvy7gAk(post.getViewStat(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv$iv$iv, 24624, 25008, 238568);
                                    } else {
                                        $composer$iv3 = $composer$iv$iv$iv;
                                        $composer$iv$iv$iv.startReplaceGroup(1905335259);
                                    }
                                    $composer$iv$iv$iv.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                    $composer$iv$iv$iv.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                                    if (StringsKt.isBlank(post.getRightText())) {
                                        $composer$iv$iv$iv.startReplaceGroup(-563449811);
                                        ComposerKt.sourceInformation($composer$iv$iv$iv, "300@12842L6,298@12739L484");
                                        TextKt.Text-Nvy7gAk(post.getRightText(), $this$TribeePost_u24lambda_u243_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, 0.0f, 0.0f, 14, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), TextUnitKt.getSp(17), TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer$iv$iv$iv, 24576, 25008, 238568);
                                    } else {
                                        $composer$iv$iv$iv.startReplaceGroup(-576102895);
                                    }
                                    $composer$iv$iv$iv.endReplaceGroup();
                                    $composer$iv$iv$iv.endReplaceGroup();
                                } else {
                                    $composer$iv$iv$iv.startReplaceGroup(-576102895);
                                    $composer$iv$iv$iv.endReplaceGroup();
                                    $composer$iv$iv = $composer$iv;
                                    $composer$iv2 = $composer$iv$iv$iv;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                $composer$iv$iv$iv.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                                $composer$iv$iv$iv2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                                ComposerKt.sourceInformationMarkerEnd($composer7);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                $composer$iv5.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            } else {
                                theme = theme3;
                            }
                        } else {
                            theme = theme3;
                        }
                    } else {
                        theme = theme3;
                    }
                } else {
                    theme = theme3;
                }
                $this$TribeePost_u24lambda_u243_u241_u242.append(post.getTitle());
                Unit unit22 = Unit.INSTANCE;
                $this$TribeePost_u24lambda_u243_u241_u242.pop(index$iv);
                AnnotatedString annotatedString2 = $this$TribeePost_u24lambda_u243_u241_u242.toAnnotatedString();
                $composer$iv$iv$iv.endReplaceGroup();
                TextKt.Text-Z58ophY(annotatedString2, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, inlineContentMap, (Function1) null, (TextStyle) null, $composer$iv$iv$iv, 48, 24960, 438268);
                Modifier modifier$iv42 = PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(29)), 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv42 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer$iv$iv$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv42 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv42 = $composer$iv$iv$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv, modifier$iv42);
                Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv42 = (($changed$iv$iv42 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer$iv$iv$iv);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv42 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i132 = ((6 >> 6) & 112) | 6;
                RowScope $this$TribeePost_u24lambda_u243_u241_u24322 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -565230264, "C:TribeePostCompose.kt#iitu82");
                if (StringsKt.isBlank(post.getLeftText())) {
                }
                $composer$iv$iv$iv.endReplaceGroup();
                if (StringsKt.isBlank(post.getRightText())) {
                }
                $composer$iv$iv$iv.startReplaceGroup(-564694027);
                ComposerKt.sourceInformation($composer$iv$iv$iv, "273@11465L1193");
                Modifier modifier$iv52 = $this$TribeePost_u24lambda_u243_u241_u243.alignByBaseline(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$TribeePost_u24lambda_u243_u241_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(6), 0.0f, 0.0f, 0.0f, 14, (Object) null));
                Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getEnd();
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer$iv$iv$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv52 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv, 0));
                CompositionLocalMap localMap$iv$iv52 = $composer$iv$iv$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv, modifier$iv52);
                Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                $composer$iv$iv = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                }
                $composer$iv$iv$iv.startReusableNode();
                if ($composer$iv$iv$iv.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer$iv$iv$iv);
                $composer$iv2 = $composer$iv$iv$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                int i142 = ($changed$iv$iv$iv52 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i152 = ((48 >> 6) & 112) | 6;
                RowScope $this$TribeePost_u24lambda_u243_u241_u243_u2402 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 1916951487, "C:TribeePostCompose.kt#iitu82");
                if (StringsKt.isBlank(post.getViewStat())) {
                }
                $composer$iv$iv$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                if (StringsKt.isBlank(post.getRightText())) {
                }
                $composer$iv$iv$iv.endReplaceGroup();
                $composer$iv$iv$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                $composer$iv$iv$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv6);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                $composer$iv5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                ComposerKt.sourceInformationMarkerEnd($composer$iv5);
                if (ComposerKt.isTraceInProgress()) {
                }
            } catch (Throwable th3) {
                $this$TribeePost_u24lambda_u243_u241_u242.pop(index$iv);
                throw th3;
            }
            color = null;
            if (color != null) {
            }
            replyIcon = post.getReplyIcon();
            if (replyIcon != null) {
            }
            theme2 = theme;
            $this$asRequest$iv = null;
            if ($this$asRequest$iv == null) {
            }
            ImageRequest $this$TribeePost_u24lambda_u243_u240_u2422 = new ImageRequest($this$asRequest$iv);
            $this$TribeePost_u24lambda_u243_u240_u2422.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, color2, 0, 2, (Object) null));
            BiliImageKt.BiliImage($this$TribeePost_u24lambda_u243_u240_u2422.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), null, null, null, null, null, null, null, $composer6, 48, 508);
            Font numberFont2 = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer6, 0, 14);
            ComposerKt.sourceInformationMarkerStart($composer6, 1823217853, str);
            it$iv = $composer6.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            FontFamily numberFontFamily2 = (FontFamily) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer6);
            KDynReplyIcon replyIcon32 = post.getReplyIcon();
            TextKt.Text-Nvy7gAk((replyIcon32 != null || (r7 = replyIcon32.getStat()) == null) ? "0" : "0", PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, numberFontFamily2, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(12), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer6, 12607536, 48, 259944);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer6.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            Modifier modifier$iv32 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            $composer$iv = $composer6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv22 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv22 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv32 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv22, horizontalAlignment$iv22, $composer$iv, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv32 = (6 << 3) & 112;
            Modifier modifier$iv$iv2 = modifier$iv32;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv32 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv$iv2);
            Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv32 = (($changed$iv$iv32 << 6) & 896) | 6;
            $composer$iv$iv$iv = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
            int i102 = ($changed$iv$iv$iv32 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope22 = ColumnScopeInstance.INSTANCE;
            int i112 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -1922811752, "C212@8879L1774,253@10667L2610:TribeePostCompose.kt#iitu82");
            List tagPics3 = post.getTitleTags();
            List $this$mapIndexed$iv2 = tagPics3;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
            Iterable $this$mapIndexedTo$iv$iv3 = $this$mapIndexed$iv2;
            int index$iv$iv3 = 0;
            while (r70.hasNext()) {
            }
            List tagPicIds3 = (List) destination$iv$iv2;
            String tagDividerId2 = "divider";
            $composer$iv$iv$iv.startReplaceGroup(630713534);
            ComposerKt.sourceInformation($composer$iv$iv$iv, "");
            Map inlineContentMap2 = new LinkedHashMap();
            $composer$iv$iv$iv.startReplaceGroup(630713704);
            ComposerKt.sourceInformation($composer$iv$iv$iv, "*173@7047L823");
            List $this$forEachIndexed$iv3 = tagPics3;
            int index$iv22 = 0;
            while (r70.hasNext()) {
            }
            Composer $composer$iv62 = $composer$iv;
            Composer $composer72 = $composer6;
            Composer $composer$iv$iv$iv22 = $composer$iv$iv$iv;
            $composer$iv$iv$iv.endReplaceGroup();
            inlineContentMap2.put("divider", new InlineTextContent(new Placeholder(density.toSp-0xMU5do(Dp.constructor-impl(9)), density.toSp-0xMU5do(Dp.constructor-impl(14)), PlaceholderVerticalAlign.Companion.getCenter-J6kI3mc(), (DefaultConstructorMarker) null), ComposableSingletons$TribeePostComposeKt.INSTANCE.m679getLambda$773400562$consume_debug()));
            $composer$iv$iv$iv.endReplaceGroup();
            $composer$iv$iv$iv.startReplaceGroup(630793969);
            ComposerKt.sourceInformation($composer$iv$iv$iv, "*241@10269L6");
            boolean z6 = false;
            $this$TribeePost_u24lambda_u243_u241_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            boolean z22 = false;
            while (r15.hasNext()) {
            }
            MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv32;
            $composer$iv$iv$iv.startReplaceGroup(630799299);
            ComposerKt.sourceInformation($composer$iv$iv$iv, "");
            Iterable $this$forEach$iv3 = post.getCategories();
            boolean z42 = false;
            while (r13.hasNext()) {
            }
            $composer$iv$iv$iv.endReplaceGroup();
            SpanStyle style$iv22 = new SpanStyle(BiliTheme.INSTANCE.getColors($composer$iv$iv$iv, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(16), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65528, (DefaultConstructorMarker) null);
            index$iv = $this$TribeePost_u24lambda_u243_u241_u242.pushStyle(style$iv22);
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.TribeePostComposeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePost$lambda$4;
                    TribeePost$lambda$4 = TribeePostComposeKt.TribeePost$lambda$4(tribeeId, fromSpmid, category, selectedCategoryId, post, sortType, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePost$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePost$lambda$2$0(KTribeeDyn $post, Router $router, String $tribeeId, KTribeeCategory $category, String $fromSpmid, KTribeeSortType $sortType) {
        Builder buildUpon;
        Builder appendQueryParameter;
        Uri p0;
        Uri uriOrNull = TribeeExtensionsKt.toUriOrNull($post.getJumpUri());
        if (uriOrNull != null && (buildUpon = uriOrNull.buildUpon()) != null && (appendQueryParameter = buildUpon.appendQueryParameter("from_spmid", TribeeExtensionsKt.SPMID)) != null && (p0 = appendQueryParameter.build()) != null) {
            $router.launch(p0);
        }
        TrackerKt.reportClickPost($tribeeId, String.valueOf($post.getDynId()), $category.getId(), $category.getName(), $fromSpmid, String.valueOf($sortType.getValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePost$lambda$3$1$1$0$2(final KTitleTagPic $pic, ThemeDayNight $theme, Density $density, String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)184@7707L21,185@7784L21,174@7081L759:TribeePostCompose.kt#iitu82");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(300909684, $changed, -1, "kntr.app.tribee.consume.page.TribeePost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeePostCompose.kt:174)");
            }
            String $this$asRequest$iv = TribeeExtensionsKt.getUrl($pic, $theme);
            ImageRequest $this$TribeePost_u24lambda_u243_u241_u241_u240_u242_u240 = new ImageRequest($this$asRequest$iv);
            ImageRequest.useOrigin$default($this$TribeePost_u24lambda_u243_u241_u241_u240_u242_u240, false, 1, null);
            BiliImageKt.BiliImage($this$TribeePost_u24lambda_u243_u241_u241_u240_u242_u240.build(), SizeKt.size-VpY3zN4(Modifier.Companion, $density.toDp-u2uoSUM((float) $pic.getWidth()), $density.toDp-u2uoSUM((float) $pic.getHeight())), null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(76189273, true, new Function2() { // from class: kntr.app.tribee.consume.page.TribeePostComposeKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeePost$lambda$3$1$1$0$2$3;
                    TribeePost$lambda$3$1$1$0$2$3 = TribeePostComposeKt.TribeePost$lambda$3$1$1$0$2$3($pic, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeePost$lambda$3$1$1$0$2$3;
                }
            }, $composer, 54), ComposableLambdaKt.rememberComposableLambda(915127331, true, new Function4() { // from class: kntr.app.tribee.consume.page.TribeePostComposeKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit TribeePost$lambda$3$1$1$0$2$4;
                    TribeePost$lambda$3$1$1$0$2$4 = TribeePostComposeKt.TribeePost$lambda$3$1$1$0$2$4($pic, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return TribeePost$lambda$3$1$1$0$2$4;
                }
            }, $composer, 54), $composer, 113246208, 124);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePost$lambda$3$1$1$0$2$3(KTitleTagPic $pic, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C184@7713L13:TribeePostCompose.kt#iitu82");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(76189273, $changed, -1, "kntr.app.tribee.consume.page.TribeePost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeePostCompose.kt:184)");
            }
            TribeeExtensionsKt.Placeholder($pic, null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeePost$lambda$3$1$1$0$2$4(KTitleTagPic $pic, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)185@7790L13:TribeePostCompose.kt#iitu82");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(915127331, $changed, -1, "kntr.app.tribee.consume.page.TribeePost.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeePostCompose.kt:185)");
        }
        TribeeExtensionsKt.Placeholder($pic, null, $composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}