package kntr.app.upcomingEpisode.list.utils;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.community.interfacess.watch.v1.KArchiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KCalendarCardType;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KLiveInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KOgvCardInfo;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import com.bilibili.compose.theme.BiliTheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.CalendarCard;
import kntr.app.upcomingEpisode.list.model.CardUiType;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.AvatarSizeConfig;
import kntr.compose.avatar.AvatarState;
import kntr.compose.avatar.internal.AvatarContentKt;
import kntr.compose.avatar.model.AvatarItem;
import kntr.compose.avatar.parser.protobuf.AvatarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDate;

/* compiled from: UpcomingEpisodeUtils.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00180\u001cH\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"SetUpIconName", "", "avatar", "Lcom/bapis/bilibili/dagw/component/avatar/v1/KAvatarItem;", "upName", "", "upNameColor", "Landroidx/compose/ui/graphics/Color;", "onAuthorLayoutClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "avatarSize", "Landroidx/compose/ui/unit/Dp;", "SetUpIconName-wC_cr3g", "(Lcom/bapis/bilibili/dagw/component/avatar/v1/KAvatarItem;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "rememberCardUiType", "Lkntr/app/upcomingEpisode/list/model/CardUiType;", "card", "Lkntr/app/upcomingEpisode/list/model/CalendarCard;", "timeText", "", "(Lkntr/app/upcomingEpisode/list/model/CalendarCard;ZLandroidx/compose/runtime/Composer;II)Lkntr/app/upcomingEpisode/list/model/CardUiType;", "rememberVisibleCards", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "selection", "Lkotlinx/datetime/LocalDate;", "cardListMap", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Lkotlinx/datetime/LocalDate;Landroidx/compose/runtime/snapshots/SnapshotStateMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SetUpIconName_wC_cr3g$lambda$1(KAvatarItem kAvatarItem, String str, long j, Function0 function0, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m1310SetUpIconNamewC_cr3g(kAvatarItem, str, j, function0, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: SetUpIconName-wC_cr3g  reason: not valid java name */
    public static final void m1310SetUpIconNamewC_cr3g(final KAvatarItem avatar, final String upName, final long j, final Function0<Unit> function0, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        Composer $composer2;
        Modifier modifier3;
        float f3;
        float f4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv;
        int $dirty;
        Function0 factory$iv$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function0, "onAuthorLayoutClick");
        Composer $composer3 = $composer.startRestartGroup(806273871);
        ComposerKt.sourceInformation($composer3, "C(SetUpIconName)N(avatar,upName,upNameColor:c#ui.graphics.Color,onAuthorLayoutClick,modifier,avatarSize:c#ui.unit.Dp)44@1749L1014:UpcomingEpisodeUtils.kt#u60jee");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(avatar) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(upName) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(j) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function0) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            f2 = f;
        } else if ((196608 & $changed) == 0) {
            f2 = f;
            $dirty2 |= $composer3.changed(f2) ? 131072 : 65536;
        } else {
            f2 = f;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            f3 = f2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(20);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(806273871, $dirty3, -1, "kntr.app.upcomingEpisode.list.utils.SetUpIconName (UpcomingEpisodeUtils.kt:43)");
            }
            float f5 = f4;
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i5 = ((384 >> 6) & 112) | 6;
            RowScope $this$SetUpIconName_wC_cr3g_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -322018106, "C51@1939L329,61@2277L39:UpcomingEpisodeUtils.kt#u60jee");
            Modifier modifier$iv2 = SizeKt.size-3ABfNKs(Modifier.Companion, f5);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1564640855, "C:UpcomingEpisodeUtils.kt#u60jee");
            AvatarItem item = avatar != null ? AvatarKt.toAvatarItem(avatar) : null;
            if (item == null) {
                $composer3.startReplaceGroup(1564690825);
                $composer3.endReplaceGroup();
                $composer$iv$iv = $composer3;
                f3 = f5;
                $composer$iv = $composer3;
                $dirty = $dirty3;
            } else {
                $composer3.startReplaceGroup(1564690826);
                ComposerKt.sourceInformation($composer3, "*54@2081L35,55@2133L111");
                AvatarItem it = item;
                AvatarState state = kntr.compose.avatar.AvatarKt.m2455rememberAvatarStateziNgDLE(it, f5, $composer3, ($dirty3 >> 12) & 112);
                AvatarSizeConfig sizeConfig$iv = AvatarSizeConfig.Largest;
                f3 = f5;
                ComposerKt.sourceInformationMarkerStart($composer3, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
                Modifier modifier$iv3 = Modifier.Companion;
                Modifier modifier$iv$iv = modifier$iv3.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig$iv.m2498constraintSizeu2uoSUM(state)));
                Alignment contentAlignment$iv$iv = Alignment.Companion.getTopStart();
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
                int $changed$iv$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
                Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv3 << 6) & 896) | 6;
                $composer$iv = $composer3;
                $dirty = $dirty3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer3.createNode(factory$iv$iv$iv$iv);
                } else {
                    factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer3);
                $composer$iv$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i9 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -60560984, "C24@868L21:Avatar.kt#v7x95u");
                $composer3.startReplaceGroup(-833237573);
                ComposerKt.sourceInformation($composer3, "*25@905L20");
                AvatarScope $this$Avatar_u24lambda_u240_u240$iv = kntr.compose.avatar.AvatarKt.rememberAvatarScope($composer3, 0);
                AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240$iv, state, $composer3, (384 << 3) & 112);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Unit unit = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer3, 6);
            if (upName != null) {
                $composer3.startReplaceGroup(-321619292);
                ComposerKt.sourceInformation($composer3, "*66@2439L9,64@2372L375");
                TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                TextKt.Text-Nvy7gAk(upName, $this$SetUpIconName_wC_cr3g_u24lambda_u240.align(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 0.0f, 0.0f, 14, (Object) null), Alignment.Companion.getCenterVertically()), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, t13, $composer3, $dirty & 896, 24960, 110584);
                Unit unit3 = Unit.INSTANCE;
                $composer3.endReplaceGroup();
                Unit unit4 = Unit.INSTANCE;
            } else {
                $composer3.startReplaceGroup(-321619293);
                $composer3.endReplaceGroup();
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final float f6 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit SetUpIconName_wC_cr3g$lambda$1;
                    SetUpIconName_wC_cr3g$lambda$1 = UpcomingEpisodeUtilsKt.SetUpIconName_wC_cr3g$lambda$1(avatar, upName, j, function0, modifier4, f6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SetUpIconName_wC_cr3g$lambda$1;
                }
            });
        }
    }

    public static final CardUiType rememberCardUiType(CalendarCard card, boolean timeText, Composer $composer, int $changed, int i) {
        Object obj;
        KLiveInfo liveInfo;
        Intrinsics.checkNotNullParameter(card, "card");
        ComposerKt.sourceInformationMarkerStart($composer, 622675131, "C(rememberCardUiType)N(card,timeText)85@2903L2178:UpcomingEpisodeUtils.kt#u60jee");
        if ((i & 2) != 0) {
            timeText = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(622675131, $changed, -1, "kntr.app.upcomingEpisode.list.utils.rememberCardUiType (UpcomingEpisodeUtils.kt:83)");
        }
        boolean booleanValue = ((Boolean) card.getHasCardClicked().getValue()).booleanValue();
        ComposerKt.sourceInformationMarkerStart($composer, 1390352893, "CC(remember):UpcomingEpisodeUtils.kt#9igjgp");
        boolean invalid$iv = $composer.changed(booleanValue);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            KCalendarCardType calendarCardType = card.getCalendarCardType();
            boolean z = true;
            if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_ARCHIVE.INSTANCE)) {
                if (((Boolean) card.getHasCardClicked().getValue()).booleanValue()) {
                    obj = CardUiType.TYPE_DIM;
                } else {
                    KArchiveCardInfo archiveCardInfo = card.getArchiveCardInfo();
                    if (archiveCardInfo == null || !archiveCardInfo.isUnread()) {
                        z = false;
                    }
                    if (z) {
                        obj = CardUiType.TYPE_HIGHLIGHT;
                    } else {
                        obj = CardUiType.TYPE_DIM;
                    }
                }
            } else if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_OGV.INSTANCE)) {
                if (timeText) {
                    KOgvCardInfo ogvCardInfo = card.getOgvCardInfo();
                    if ((ogvCardInfo == null || ogvCardInfo.isUpdated()) ? false : true) {
                        obj = CardUiType.TYPE_HIGHLIGHT;
                    }
                }
                if (!((Boolean) card.getHasCardClicked().getValue()).booleanValue()) {
                    KOgvCardInfo ogvCardInfo2 = card.getOgvCardInfo();
                    if (!((ogvCardInfo2 == null || ogvCardInfo2.isUpdated()) ? false : true)) {
                        KOgvCardInfo ogvCardInfo3 = card.getOgvCardInfo();
                        if (ogvCardInfo3 == null || !ogvCardInfo3.isUnread()) {
                            z = false;
                        }
                        if (z) {
                            obj = CardUiType.TYPE_HIGHLIGHT;
                        } else {
                            obj = CardUiType.TYPE_DIM;
                        }
                    }
                }
                obj = CardUiType.TYPE_DIM;
            } else if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_LIVE.INSTANCE)) {
                KLiveCardInfo liveCardInfo = card.getLiveCardInfo();
                if (liveCardInfo == null || (liveInfo = liveCardInfo.getLiveInfo()) == null || liveInfo.getLiveStatus() != 0) {
                    z = false;
                }
                if (z) {
                    obj = CardUiType.TYPE_DIM;
                } else {
                    obj = CardUiType.TYPE_HIGHLIGHT;
                }
            } else if (Intrinsics.areEqual(calendarCardType, KCalendarCardType.CALENDAR_CARD_TYPE_RESERVE.INSTANCE)) {
                if (timeText) {
                    obj = CardUiType.TYPE_HIGHLIGHT;
                } else {
                    obj = CardUiType.TYPE_DIM;
                }
            } else {
                obj = CardUiType.TYPE_DIM;
            }
            Object value$iv = obj;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        CardUiType cardUiType = (CardUiType) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return cardUiType;
    }

    public static final SnapshotStateList<CalendarCard> rememberVisibleCards(LocalDate selection, SnapshotStateMap<LocalDate, SnapshotStateList<CalendarCard>> snapshotStateMap, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(snapshotStateMap, "cardListMap");
        ComposerKt.sourceInformationMarkerStart($composer, 1669727241, "C(rememberVisibleCards)N(selection,cardListMap)151@5386L200:UpcomingEpisodeUtils.kt#u60jee");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1669727241, $changed, -1, "kntr.app.upcomingEpisode.list.utils.rememberVisibleCards (UpcomingEpisodeUtils.kt:148)");
        }
        final SnapshotStateList originList = (SnapshotStateList) snapshotStateMap.get(selection);
        if (originList == null) {
            originList = SnapshotStateKt.mutableStateListOf();
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1709881359, "CC(remember):UpcomingEpisodeUtils.kt#9igjgp");
        boolean invalid$iv = $composer.changed(originList);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    SnapshotStateList rememberVisibleCards$lambda$0$0;
                    rememberVisibleCards$lambda$0$0 = UpcomingEpisodeUtilsKt.rememberVisibleCards$lambda$0$0(originList);
                    return rememberVisibleCards$lambda$0$0;
                }
            });
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        State visibleCards = (State) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        SnapshotStateList<CalendarCard> snapshotStateList = (SnapshotStateList) visibleCards.getValue();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return snapshotStateList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapshotStateList rememberVisibleCards$lambda$0$0(SnapshotStateList $originList) {
        Iterable $this$filter$iv = (Iterable) $originList;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            CalendarCard it = (CalendarCard) element$iv$iv;
            if (((Boolean) it.getShouldCardShow().getValue()).booleanValue()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return SnapshotStateKt.toMutableStateList((List) destination$iv$iv);
    }
}