package kntr.compose.avatar;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.internal.AvatarContentKt;
import kntr.compose.avatar.internal.AvatarScopeImpl;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Avatar.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0087\b¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Avatar", "", "state", "Lkntr/compose/avatar/AvatarState;", "modifier", "Landroidx/compose/ui/Modifier;", "sizeConfig", "Lkntr/compose/avatar/AvatarSizeConfig;", "(Lkntr/compose/avatar/AvatarState;Landroidx/compose/ui/Modifier;Lkntr/compose/avatar/AvatarSizeConfig;Landroidx/compose/runtime/Composer;II)V", "rememberAvatarState", "avatarItem", "Lkntr/compose/avatar/model/AvatarItem;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "rememberAvatarState-ziNgDLE", "(Lkntr/compose/avatar/model/AvatarItem;FLandroidx/compose/runtime/Composer;I)Lkntr/compose/avatar/AvatarState;", "rememberAvatarScope", "Lkntr/compose/avatar/AvatarScope;", "(Landroidx/compose/runtime/Composer;I)Lkntr/compose/avatar/AvatarScope;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvatarKt {
    public static final void Avatar(AvatarState state, Modifier modifier, AvatarSizeConfig sizeConfig, Composer $composer, int $changed, int i) {
        Modifier modifier2;
        AvatarSizeConfig sizeConfig2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(state, "state");
        ComposerKt.sourceInformationMarkerStart($composer, -1812324423, "CC(Avatar)N(state,modifier,sizeConfig)20@712L229:Avatar.kt#v7x95u");
        if ((i & 2) != 0) {
            modifier2 = (Modifier) Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        if ((i & 4) == 0) {
            sizeConfig2 = sizeConfig;
        } else {
            sizeConfig2 = AvatarSizeConfig.Normal;
        }
        Modifier modifier$iv = modifier2.then(SizeKt.size-3ABfNKs(Modifier.Companion, sizeConfig2.m2498constraintSizeu2uoSUM(state)));
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        $composer.startReusableNode();
        if ($composer.getInserting()) {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv2;
            $composer.useNode();
        }
        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
        int i2 = ($changed$iv$iv$iv >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i3 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -60560984, "C24@868L21:Avatar.kt#v7x95u");
        $composer.startReplaceGroup(-833237573);
        ComposerKt.sourceInformation($composer, "*25@905L20");
        AvatarScope $this$Avatar_u24lambda_u240_u240 = rememberAvatarScope($composer, 0);
        AvatarContentKt.AvatarContent($this$Avatar_u24lambda_u240_u240, state, $composer, ($changed << 3) & 112);
        $composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
    }

    /* renamed from: rememberAvatarState-ziNgDLE  reason: not valid java name */
    public static final AvatarState m2455rememberAvatarStateziNgDLE(AvatarItem avatarItem, float f, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(avatarItem, "avatarItem");
        ComposerKt.sourceInformationMarkerStart($composer, 1532671322, "C(rememberAvatarState)N(avatarItem,normalSize:c#ui.unit.Dp)34@1047L60:Avatar.kt#v7x95u");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1532671322, $changed, -1, "kntr.compose.avatar.rememberAvatarState (Avatar.kt:34)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -276639146, "CC(remember):Avatar.kt#9igjgp");
        boolean invalid$iv = ((($changed & 14) ^ 6) > 4 && $composer.changed(avatarItem)) || ($changed & 6) == 4;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new AvatarState(avatarItem, f, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        AvatarState avatarState = (AvatarState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return avatarState;
    }

    public static final AvatarScope rememberAvatarScope(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 378958320, "C(rememberAvatarScope)38@1166L42:Avatar.kt#v7x95u");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(378958320, $changed, -1, "kntr.compose.avatar.rememberAvatarScope (Avatar.kt:38)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -893273158, "CC(remember):Avatar.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new AvatarScopeImpl();
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        AvatarScopeImpl avatarScopeImpl = (AvatarScopeImpl) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return avatarScopeImpl;
    }
}