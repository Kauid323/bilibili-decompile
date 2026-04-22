package tv.danmaku.bili.ui.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.image.BiliImageKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.iconfont.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.ui.watchlater.data.Owner;
import tv.danmaku.bili.ui.watchlater.data.WatchLaterItem;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;

/* compiled from: WatchLaterCard.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u001ap\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"WatchLaterCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "isCheckMode", "", "isChecked", "item", "Ltv/danmaku/bili/ui/watchlater/data/WatchLaterItem;", "onCardClick", "Lkotlin/Function0;", "onCardLongClick", "onThreePointClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "aid", "(Landroidx/compose/ui/Modifier;ZZLtv/danmaku/bili/ui/watchlater/data/WatchLaterItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "WatchLaterDividerCard", "dividerText", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WatchLaterCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$1(Modifier modifier, boolean z, boolean z2, WatchLaterItem watchLaterItem, Function0 function0, Function0 function02, Function1 function1, int i, int i2, Composer composer, int i3) {
        WatchLaterCard(modifier, z, z2, watchLaterItem, function0, function02, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterDividerCard$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WatchLaterDividerCard(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x08c0, code lost:
        if (r4.changedInstance(r143) != false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x09d9, code lost:
        if (r0 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0d93, code lost:
        if (r3.changedInstance(r0) != false) goto L198;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0907  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x091f  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x099a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0a6b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0b03  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0b0f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0b15  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0b93  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0cd5  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0d10  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0df3  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0e3c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WatchLaterCard(Modifier modifier, boolean isCheckMode, final boolean isChecked, final WatchLaterItem item, final Function0<Unit> function0, final Function0<Unit> function02, final Function1<? super Long, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isCheckMode2;
        int $dirty;
        Composer $composer2;
        Modifier modifier$iv$iv;
        Modifier modifier3;
        boolean isCheckMode3;
        Function0 factory$iv$iv$iv;
        Composer $composer3;
        Composer $composer$iv;
        String str;
        Function0 factory$iv$iv$iv2;
        String pic;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer4;
        boolean invalid$iv;
        String str2;
        Function0 factory$iv$iv$iv5;
        Composer $composer5;
        Composer $composer6;
        final WatchLaterItem watchLaterItem;
        boolean z;
        boolean invalid$iv2;
        Object it$iv;
        String name;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function0, "onCardClick");
        Intrinsics.checkNotNullParameter(function02, "onCardLongClick");
        Intrinsics.checkNotNullParameter(function1, "onThreePointClick");
        Composer $composer7 = $composer.startRestartGroup(-271938732);
        ComposerKt.sourceInformation($composer7, "C(WatchLaterCard)N(modifier,isCheckMode,isChecked,item,onCardClick,onCardLongClick,onThreePointClick)50@1992L6833:WatchLaterCard.kt#ooxe70");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer7.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            isCheckMode2 = isCheckMode;
        } else if (($changed & 48) == 0) {
            isCheckMode2 = isCheckMode;
            $dirty2 |= $composer7.changed(isCheckMode2) ? 32 : 16;
        } else {
            isCheckMode2 = isCheckMode;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer7.changed(isChecked) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= ($changed & 4096) == 0 ? $composer7.changed(item) : $composer7.changedInstance(item) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer7.changedInstance(function0) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer7.changedInstance(function02) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty2 |= $composer7.changedInstance(function1) ? 1048576 : 524288;
        }
        if (!$composer7.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer7;
            $composer2.skipToGroupEnd();
            modifier$iv$iv = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                isCheckMode3 = isCheckMode2;
            } else {
                isCheckMode3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-271938732, $dirty2, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterCard (WatchLaterCard.kt:49)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.combinedClickable-hoGz1lA$default(IntrinsicKt.height(SizeKt.fillMaxWidth$default(modifier3, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), IntrinsicSize.Max), false, (String) null, (Role) null, (String) null, function02, (Function0) null, false, (MutableInteractionSource) null, function0, 239, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer7, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer7, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer7, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer7, 0));
            CompositionLocalMap localMap$iv$iv = $composer7.getCurrentCompositionLocalMap();
            modifier$iv$iv = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer7, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer7, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer7.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer7.startReusableNode();
            if ($composer7.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer7.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer7.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer7);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer7, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            RowScope $this$WatchLaterCard_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer7, -1735965477, "C72@2646L2325,128@4980L40,130@5030L3788:WatchLaterCard.kt#ooxe70");
            if (isCheckMode3) {
                $composer7.startReplaceGroup(-1736140752);
                ComposerKt.sourceInformation($composer7, "61@2329L194,67@2536L91");
                $composer$iv = $composer7;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                WatchLaterWidgetKt.m1792WatchLaterCheckBoxX34t5lA(isChecked, $this$WatchLaterCard_u24lambda_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), Alignment.Companion.getCenterVertically()), 0L, 0L, 0, 0L, $composer7, ($dirty2 >> 6) & 14, 60);
                $composer3 = $composer7;
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
            } else {
                $composer3 = $composer7;
                $composer$iv = $composer7;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer3.startReplaceGroup(-1738448206);
            }
            $composer3.endReplaceGroup();
            Modifier modifier$iv2 = ClipKt.clip(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(128), Dp.constructor-impl(72)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            Composer $composer$iv2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            String str3 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str3);
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
            Composer $composer$iv3 = $composer$iv;
            CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv2.startReusableNode();
            if ($composer$iv2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv2);
            boolean isCheckMode4 = isCheckMode3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((0 >> 6) & 112) | 6;
            BoxScope $this$WatchLaterCard_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv2, -329854712, "C77@2800L210,89@3350L9,83@3024L754:WatchLaterCard.kt#ooxe70");
            BiliImageKt.BiliImage((item.isInvalid() || (pic = item.getPic()) == null) ? "" : pic, ClipKt.clip(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), (String) null, false, 0, (String) null, false, (Function3) null, (Alignment) null, (ContentScale) null, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (ColorFilter) null, $composer$iv2, 0, 0, 4092);
            String coverText = item.getCoverText();
            WatchLaterWidgetKt.m1791IconTextH8uBujs(coverText == null ? "" : coverText, PaddingKt.padding-VpY3zN4($this$WatchLaterCard_u24lambda_u240_u240.align(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.6f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Alignment.Companion.getBottomEnd()), Dp.constructor-impl(3), Dp.constructor-impl(1)), item.isInvalid() ? Integer.valueOf(R.drawable.ref_warning_report_circle_line_500) : null, 0, Dp.constructor-impl(2), Dp.constructor-impl(11), Color.Companion.getWhite-0d7_KjU(), Color.Companion.getWhite-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT10(), false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, $composer$iv2, 14376960, 0, 7688);
            String pgcLabel = item.getPgcLabel();
            if (pgcLabel == null || StringsKt.isBlank(pgcLabel)) {
                $composer$iv2.startReplaceGroup(-332700296);
            } else {
                $composer$iv2.startReplaceGroup(-328867673);
                ComposerKt.sourceInformation($composer$iv2, "103@3931L9,104@3984L6,108@4165L6,101@3845L561");
                TextKt.Text--4IGK_g(item.getPgcLabel(), $this$WatchLaterCard_u24lambda_u240_u240.align(PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), Dp.constructor-impl(4), Dp.constructor-impl(1)), Alignment.Companion.getTopEnd()), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getText_white-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv2, BiliTheme.$stable).getT10(), $composer$iv2, 0, 0, 65528);
            }
            $composer$iv2.endReplaceGroup();
            if (item.isInvalid() || item.getProgress() <= 0) {
                $composer$iv2.startReplaceGroup(-332700296);
            } else {
                $composer$iv2.startReplaceGroup(-328244077);
                ComposerKt.sourceInformation($composer$iv2, "123@4857L6,118@4589L358");
                float fraction = ((float) item.getProgress()) / ((float) item.getDuration());
                BoxKt.Box($this$WatchLaterCard_u24lambda_u240_u240.align(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.fillMaxWidth(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), fraction), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default((float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(3), Dp.constructor-impl(3), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 9, (Object) null)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null), Alignment.Companion.getBottomStart()), $composer$iv2, 0);
            }
            $composer$iv2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(10)), $composer3, 6);
            Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Composer $composer$iv4 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv3);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i9 = ((6 >> 6) & 112) | 6;
            BoxScope $this$WatchLaterCard_u24lambda_u240_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1340132963, "C131@5083L2969:WatchLaterCard.kt#ooxe70");
            Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Composer $composer8 = $composer3;
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv4 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv4.startReusableNode();
            if ($composer$iv4.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv4.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv9;
                $composer$iv4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i10 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int i11 = ((6 >> 6) & 112) | 6;
            ColumnScope $this$WatchLaterCard_u24lambda_u240_u241_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 894163512, "C133@5203L88,142@5615L9,143@5668L6,132@5143L643,147@5803L101,168@6697L1340:WatchLaterCard.kt#ooxe70");
            Modifier modifier4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1218082891, "CC(remember):WatchLaterCard.kt#9igjgp");
            if (($dirty2 & 7168) != 2048) {
                if (($dirty2 & 4096) != 0) {
                    $composer4 = $composer7;
                } else {
                    $composer4 = $composer7;
                }
                invalid$iv = false;
                Object value$iv = $composer$iv4.rememberedValue();
                if (!invalid$iv && value$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) value$iv);
                    if (!item.isInvalid()) {
                        $composer$iv4.startReplaceGroup(894297276);
                        ComposerKt.sourceInformation($composer$iv4, "138@5394L81");
                        String stringResource = StringResources_androidKt.stringResource(bili.resource.favorites.R.string.favorites_global_string_227, $composer$iv4, 0);
                        $composer$iv4.endReplaceGroup();
                        str2 = stringResource;
                    } else {
                        $composer$iv4.startReplaceGroup(894459933);
                        $composer$iv4.endReplaceGroup();
                        String title = item.getTitle();
                        if (title != null) {
                            str2 = title;
                        } else {
                            str2 = "";
                        }
                    }
                    TextKt.Text--4IGK_g(str2, graphicsLayer, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT14(), $composer$iv4, 0, 3120, 55288);
                    SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv4, 0);
                    if (!item.getShowUp()) {
                        $composer$iv4.startReplaceGroup(894885439);
                        ComposerKt.sourceInformation($composer$iv4, "153@6028L96,158@6321L9,160@6426L6,161@6485L6,152@5960L566,163@6547L115");
                        Modifier modifier5 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer$iv4, -1218056483, "CC(remember):WatchLaterCard.kt#9igjgp");
                        boolean invalid$iv3 = ($dirty2 & 7168) == 2048 || (($dirty2 & 4096) != 0 && $composer4.changedInstance(item));
                        Object value$iv2 = $composer$iv4.rememberedValue();
                        if (invalid$iv3) {
                        }
                        value$iv2 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                Unit WatchLaterCard$lambda$0$1$0$1$0;
                                WatchLaterCard$lambda$0$1$0$1$0 = WatchLaterCardKt.WatchLaterCard$lambda$0$1$0$1$0(WatchLaterItem.this, (GraphicsLayerScope) obj);
                                return WatchLaterCard$lambda$0$1$0$1$0;
                            }
                        };
                        $composer$iv4.updateRememberedValue(value$iv2);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                        Modifier graphicsLayer2 = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) value$iv2);
                        Owner owner = item.getOwner();
                        WatchLaterWidgetKt.m1791IconTextH8uBujs((owner == null || (name = owner.getName()) == null) ? "" : name, graphicsLayer2, Integer.valueOf(com.bilibili.app.comm.baseres.R.drawable.ic_vector_info_up_v2), 0, Dp.constructor-impl(2), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT12(), false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, $composer$iv4, 24576, 0, 7720);
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer$iv4, 6);
                    } else {
                        $composer$iv4.startReplaceGroup(888970949);
                    }
                    $composer$iv4.endReplaceGroup();
                    Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                    Composer $composer9 = $composer4;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv5 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer$iv4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv5);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    int $dirty3 = $dirty2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer$iv4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv4.startReusableNode();
                    if (!$composer$iv4.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv4.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv4);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i12 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i13 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv4, -1318168770, "C:WatchLaterCard.kt#ooxe70");
                    if (item.isInvalid()) {
                        $composer$iv4.startReplaceGroup(-1318148590);
                        ComposerKt.sourceInformation($composer$iv4, "191@7957L40");
                        String leftText = item.getLeftText();
                        if (!(leftText == null || StringsKt.isBlank(leftText))) {
                            $composer$iv4.startReplaceGroup(-1318080514);
                            ComposerKt.sourceInformation($composer$iv4, "175@7126L9,177@7247L6,178@7314L6,171@6872L491");
                            WatchLaterWidgetKt.m1791IconTextH8uBujs(item.getLeftText(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(10), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 11, (Object) null), null, item.getLeftIconType(), Dp.constructor-impl(2), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT12(), false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, $composer$iv4, 24624, 0, 7716);
                        } else {
                            $composer$iv4.startReplaceGroup(-1324913751);
                        }
                        $composer$iv4.endReplaceGroup();
                        String rightText = item.getRightText();
                        if (!(rightText == null || StringsKt.isBlank(rightText))) {
                            $composer$iv4.startReplaceGroup(-1317478432);
                            ComposerKt.sourceInformation($composer$iv4, "185@7669L9,187@7790L6,188@7857L6,182@7481L425");
                            String rightText2 = item.getRightText();
                            WatchLaterWidgetKt.m1791IconTextH8uBujs(rightText2 == null ? "" : rightText2, null, null, item.getRightIconType(), Dp.constructor-impl(2), DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText3-0d7_KjU(), BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getGraph_medium-0d7_KjU(), BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT12(), false, false, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, null, $composer$iv4, 24576, 0, 7718);
                        } else {
                            $composer$iv4.startReplaceGroup(-1324913751);
                        }
                        $composer$iv4.endReplaceGroup();
                        SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer$iv4, 6);
                    } else {
                        $composer$iv4.startReplaceGroup(-1324913751);
                    }
                    $composer$iv4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    if (isCheckMode4) {
                        $composer6 = $composer$iv4;
                        $composer6.startReplaceGroup(1343015962);
                        ComposerKt.sourceInformation($composer6, "198@8137L81,204@8482L99,208@8668L31,210@8764L6,197@8101L693");
                        Painter painterResource = PainterResources_androidKt.painterResource(com.bilibili.app.comm.baseres.R.drawable.ic_vector_more_new, $composer6, 0);
                        Modifier align = $this$WatchLaterCard_u24lambda_u240_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), Alignment.Companion.getBottomEnd());
                        ComposerKt.sourceInformationMarkerStart($composer6, 597524566, "CC(remember):WatchLaterCard.kt#9igjgp");
                        Object it$iv2 = $composer6.rememberedValue();
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                            $composer6.updateRememberedValue(value$iv3);
                            it$iv2 = value$iv3;
                        }
                        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        ComposerKt.sourceInformationMarkerStart($composer6, 597530450, "CC(remember):WatchLaterCard.kt#9igjgp");
                        boolean z2 = ($dirty3 & 3670016) == 1048576;
                        $dirty = $dirty3;
                        if (($dirty & 7168) != 2048) {
                            if (($dirty & 4096) != 0) {
                                watchLaterItem = item;
                                $composer5 = $composer9;
                            } else {
                                watchLaterItem = item;
                                $composer5 = $composer9;
                            }
                            z = false;
                            invalid$iv2 = z2 | z;
                            it$iv = $composer6.rememberedValue();
                            if (!invalid$iv2 || it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv4 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda2
                                    public final Object invoke() {
                                        Unit WatchLaterCard$lambda$0$1$2$0;
                                        WatchLaterCard$lambda$0$1$2$0 = WatchLaterCardKt.WatchLaterCard$lambda$0$1$2$0(function1, watchLaterItem);
                                        return WatchLaterCard$lambda$0$1$2$0;
                                    }
                                };
                                $composer6.updateRememberedValue(value$iv4);
                                it$iv = value$iv4;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer6);
                            IconKt.Icon-ww6aTOc(painterResource, "more", ClickableKt.clickable-O2vRcR0$default(align, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText4-0d7_KjU(), $composer6, Painter.$stable | 48, 0);
                        } else {
                            watchLaterItem = item;
                            $composer5 = $composer9;
                        }
                        z = true;
                        invalid$iv2 = z2 | z;
                        it$iv = $composer6.rememberedValue();
                        if (!invalid$iv2) {
                        }
                        Object value$iv42 = new Function0() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda2
                            public final Object invoke() {
                                Unit WatchLaterCard$lambda$0$1$2$0;
                                WatchLaterCard$lambda$0$1$2$0 = WatchLaterCardKt.WatchLaterCard$lambda$0$1$2$0(function1, watchLaterItem);
                                return WatchLaterCard$lambda$0$1$2$0;
                            }
                        };
                        $composer6.updateRememberedValue(value$iv42);
                        it$iv = value$iv42;
                        ComposerKt.sourceInformationMarkerEnd($composer6);
                        IconKt.Icon-ww6aTOc(painterResource, "more", ClickableKt.clickable-O2vRcR0$default(align, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText4-0d7_KjU(), $composer6, Painter.$stable | 48, 0);
                    } else {
                        $composer5 = $composer9;
                        $composer6 = $composer$iv4;
                        $dirty = $dirty3;
                        $composer6.startReplaceGroup(1334974159);
                    }
                    $composer6.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer6);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    $composer$iv4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer8);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    $composer7.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerEnd($composer7);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer2 = $composer5;
                    isCheckMode2 = isCheckMode4;
                }
                value$iv = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit WatchLaterCard$lambda$0$1$0$0$0;
                        WatchLaterCard$lambda$0$1$0$0$0 = WatchLaterCardKt.WatchLaterCard$lambda$0$1$0$0$0(WatchLaterItem.this, (GraphicsLayerScope) obj);
                        return WatchLaterCard$lambda$0$1$0$0$0;
                    }
                };
                $composer$iv4.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                Modifier graphicsLayer3 = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) value$iv);
                if (!item.isInvalid()) {
                }
                TextKt.Text--4IGK_g(str2, graphicsLayer3, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT14(), $composer$iv4, 0, 3120, 55288);
                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv4, 0);
                if (!item.getShowUp()) {
                }
                $composer$iv4.endReplaceGroup();
                Modifier modifier$iv52 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                Composer $composer92 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv52 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
                int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                CompositionLocalMap localMap$iv$iv52 = $composer$iv4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv52);
                Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv52 = (($changed$iv$iv52 << 6) & 896) | 6;
                int $dirty32 = $dirty2;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv4.getApplier() instanceof Applier)) {
                }
                $composer$iv4.startReusableNode();
                if (!$composer$iv4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer$iv4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv52, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                int i122 = ($changed$iv$iv$iv52 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i132 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1318168770, "C:WatchLaterCard.kt#ooxe70");
                if (item.isInvalid()) {
                }
                $composer$iv4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                if (isCheckMode4) {
                }
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer2 = $composer5;
                isCheckMode2 = isCheckMode4;
            } else {
                $composer4 = $composer7;
            }
            invalid$iv = true;
            Object value$iv5 = $composer$iv4.rememberedValue();
            if (!invalid$iv) {
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                Modifier graphicsLayer32 = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) value$iv5);
                if (!item.isInvalid()) {
                }
                TextKt.Text--4IGK_g(str2, graphicsLayer32, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT14(), $composer$iv4, 0, 3120, 55288);
                SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv4, 0);
                if (!item.getShowUp()) {
                }
                $composer$iv4.endReplaceGroup();
                Modifier modifier$iv522 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
                Composer $composer922 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv222 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv222 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv522 = RowKt.rowMeasurePolicy(horizontalArrangement$iv222, verticalAlignment$iv222, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv522 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
                int compositeKeyHash$iv$iv522 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
                CompositionLocalMap localMap$iv$iv522 = $composer$iv4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv522 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv522);
                Function0 factory$iv$iv$iv1022 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv522 = (($changed$iv$iv522 << 6) & 896) | 6;
                int $dirty322 = $dirty2;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv4.getApplier() instanceof Applier)) {
                }
                $composer$iv4.startReusableNode();
                if (!$composer$iv4.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv522 = Updater.constructor-impl($composer$iv4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, measurePolicy$iv522, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, localMap$iv$iv522, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv522, Integer.valueOf(compositeKeyHash$iv$iv522), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv522, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv522, materialized$iv$iv522, ComposeUiNode.Companion.getSetModifier());
                int i1222 = ($changed$iv$iv$iv522 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope22 = RowScopeInstance.INSTANCE;
                int i1322 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv4, -1318168770, "C:WatchLaterCard.kt#ooxe70");
                if (item.isInvalid()) {
                }
                $composer$iv4.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                if (isCheckMode4) {
                }
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                $composer$iv4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer$iv4);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                $composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer7);
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer2 = $composer5;
                isCheckMode2 = isCheckMode4;
            }
            value$iv5 = new Function1() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit WatchLaterCard$lambda$0$1$0$0$0;
                    WatchLaterCard$lambda$0$1$0$0$0 = WatchLaterCardKt.WatchLaterCard$lambda$0$1$0$0$0(WatchLaterItem.this, (GraphicsLayerScope) obj);
                    return WatchLaterCard$lambda$0$1$0$0$0;
                }
            };
            $composer$iv4.updateRememberedValue(value$iv5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            Modifier graphicsLayer322 = GraphicsLayerModifierKt.graphicsLayer(modifier4, (Function1) value$iv5);
            if (!item.isInvalid()) {
            }
            TextKt.Text--4IGK_g(str2, graphicsLayer322, BiliTheme.INSTANCE.getColors($composer$iv4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv4, BiliTheme.$stable).getT14(), $composer$iv4, 0, 3120, 55288);
            SpacerKt.Spacer(ColumnScope.-CC.weight$default($this$WatchLaterCard_u24lambda_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv4, 0);
            if (!item.getShowUp()) {
            }
            $composer$iv4.endReplaceGroup();
            Modifier modifier$iv5222 = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            Composer $composer9222 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2222 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2222 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv5222 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2222, verticalAlignment$iv2222, $composer$iv4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv5222 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1159599143, str3);
            int compositeKeyHash$iv$iv5222 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv4, 0));
            CompositionLocalMap localMap$iv$iv5222 = $composer$iv4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5222 = ComposedModifierKt.materializeModifier($composer$iv4, modifier$iv5222);
            Function0 factory$iv$iv$iv10222 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5222 = (($changed$iv$iv5222 << 6) & 896) | 6;
            int $dirty3222 = $dirty2;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv4.getApplier() instanceof Applier)) {
            }
            $composer$iv4.startReusableNode();
            if (!$composer$iv4.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5222 = Updater.constructor-impl($composer$iv4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, measurePolicy$iv5222, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, localMap$iv$iv5222, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5222, Integer.valueOf(compositeKeyHash$iv$iv5222), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5222, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5222, materialized$iv$iv5222, ComposeUiNode.Companion.getSetModifier());
            int i12222 = ($changed$iv$iv$iv5222 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope222 = RowScopeInstance.INSTANCE;
            int i13222 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv4, -1318168770, "C:WatchLaterCard.kt#ooxe70");
            if (item.isInvalid()) {
            }
            $composer$iv4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            if (isCheckMode4) {
            }
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            $composer$iv4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            $composer7.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            if (ComposerKt.isTraceInProgress()) {
            }
            $composer2 = $composer5;
            isCheckMode2 = isCheckMode4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier$iv$iv;
            final boolean z3 = isCheckMode2;
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterCard$lambda$1;
                    WatchLaterCard$lambda$1 = WatchLaterCardKt.WatchLaterCard$lambda$1(modifier6, z3, isChecked, item, function0, function02, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$0$1$0$0$0(WatchLaterItem $item, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($item.isInvalid() ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$0$1$0$1$0(WatchLaterItem $item, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($item.isInvalid() ? 0.4f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCard$lambda$0$1$2$0(Function1 $onThreePointClick, WatchLaterItem $item) {
        $onThreePointClick.invoke(Long.valueOf($item.getAid()));
        return Unit.INSTANCE;
    }

    public static final void WatchLaterDividerCard(final String dividerText, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-440274217);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterDividerCard)N(dividerText,modifier)220@8926L812:WatchLaterCard.kt#ooxe70");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(dividerText) ? 4 : 2;
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
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-440274217, $dirty, -1, "tv.danmaku.bili.ui.watchlater.compose.WatchLaterDividerCard (WatchLaterCard.kt:219)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
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
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$WatchLaterDividerCard_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1114008880, "C230@9232L6,226@9100L161,235@9423L9,236@9468L6,232@9270L292,244@9703L6,240@9571L161:WatchLaterCard.kt#ooxe70");
            DividerKt.Divider-oMI9zvI(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$WatchLaterDividerCard_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $composer2, 0, 12);
            TextKt.Text--4IGK_g(dividerText == null ? "" : dividerText, PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl((float) 7.5d), Dp.constructor-impl(6)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 48, 3120, 55288);
            DividerKt.Divider-oMI9zvI(SizeKt.height-3ABfNKs(RowScope.-CC.weight$default($this$WatchLaterDividerCard_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getLine_regular-0d7_KjU(), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, $composer2, 0, 12);
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
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.ui.watchlater.compose.WatchLaterCardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterDividerCard$lambda$1;
                    WatchLaterDividerCard$lambda$1 = WatchLaterCardKt.WatchLaterDividerCard$lambda$1(dividerText, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterDividerCard$lambda$1;
                }
            });
        }
    }
}