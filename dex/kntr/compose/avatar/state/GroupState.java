package kntr.compose.avatar.state;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.AvatarScope;
import kntr.compose.avatar.internal.GroupScopeImpl;
import kntr.compose.avatar.model.layers.Layer;
import kntr.compose.avatar.model.layers.LayerGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GroupState.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\fR\u001b\u0010\u0016\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\f¨\u0006\u001e"}, d2 = {"Lkntr/compose/avatar/state/GroupState;", "", "layerGroup", "Lkntr/compose/avatar/model/layers/LayerGroup;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkntr/compose/avatar/model/layers/LayerGroup;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLayerGroup", "()Lkntr/compose/avatar/model/layers/LayerGroup;", "isCritical", "", "()Z", "layers", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/compose/avatar/state/LayerState;", "getLayers", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "hasCriticalLayer", "getHasCriticalLayer", "hasCriticalLayer$delegate", "Landroidx/compose/runtime/State;", "readyToDraw", "getReadyToDraw", "readyToDraw$delegate", "Content", "", "Lkntr/compose/avatar/AvatarScope;", "Content$ui_debug", "(Lkntr/compose/avatar/AvatarScope;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GroupState {
    public static final int $stable = 0;
    private final State hasCriticalLayer$delegate;
    private final LayerGroup layerGroup;
    private final SnapshotStateList<LayerState> layers;
    private final State readyToDraw$delegate;

    public /* synthetic */ GroupState(LayerGroup layerGroup, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(layerGroup, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$1(GroupState groupState, AvatarScope avatarScope, int i, Composer composer, int i2) {
        groupState.Content$ui_debug(avatarScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private GroupState(LayerGroup layerGroup, float normalSize) {
        Intrinsics.checkNotNullParameter(layerGroup, "layerGroup");
        this.layerGroup = layerGroup;
        Iterable $this$map$iv = this.layerGroup.getLayers();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Layer it = (Layer) item$iv$iv;
            destination$iv$iv.add(new LayerState(it, normalSize, null));
        }
        this.layers = SnapshotStateKt.toMutableStateList((List) destination$iv$iv);
        this.hasCriticalLayer$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.compose.avatar.state.GroupState$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean hasCriticalLayer_delegate$lambda$0;
                hasCriticalLayer_delegate$lambda$0 = GroupState.hasCriticalLayer_delegate$lambda$0(GroupState.this);
                return Boolean.valueOf(hasCriticalLayer_delegate$lambda$0);
            }
        });
        this.readyToDraw$delegate = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.compose.avatar.state.GroupState$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean readyToDraw_delegate$lambda$0;
                readyToDraw_delegate$lambda$0 = GroupState.readyToDraw_delegate$lambda$0(GroupState.this);
                return Boolean.valueOf(readyToDraw_delegate$lambda$0);
            }
        });
    }

    public final LayerGroup getLayerGroup() {
        return this.layerGroup;
    }

    public final boolean isCritical() {
        return this.layerGroup.isCritical();
    }

    public final SnapshotStateList<LayerState> getLayers() {
        return this.layers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasCriticalLayer_delegate$lambda$0(GroupState this$0) {
        Iterable $this$any$iv = this$0.layers;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            LayerState it = (LayerState) element$iv;
            if (it.isCritical()) {
                return true;
            }
        }
        return false;
    }

    public final boolean getHasCriticalLayer() {
        State $this$getValue$iv = this.hasCriticalLayer$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final boolean getReadyToDraw() {
        State $this$getValue$iv = this.readyToDraw$delegate;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0064 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean readyToDraw_delegate$lambda$0(GroupState this$0) {
        LayerState it;
        Iterable $this$all$iv;
        Iterable $this$all$iv2 = this$0.layers;
        if (($this$all$iv2 instanceof Collection) && ((Collection) $this$all$iv2).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv2) {
            LayerState layerState = (LayerState) element$iv;
            if (this$0.getHasCriticalLayer()) {
                Iterable $this$all$iv3 = this$0.layers;
                if (!($this$all$iv3 instanceof Collection) || !((Collection) $this$all$iv3).isEmpty()) {
                    Iterator it2 = $this$all$iv3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object element$iv2 = it2.next();
                            LayerState it3 = (LayerState) element$iv2;
                            if (!it3.getReadyToDraw()) {
                                $this$all$iv = null;
                                break;
                            }
                        } else {
                            $this$all$iv = 1;
                            break;
                        }
                    }
                } else {
                    $this$all$iv = 1;
                }
                if ($this$all$iv == null) {
                    it = null;
                    continue;
                    if (it == null) {
                        return false;
                    }
                }
            }
            it = 1;
            continue;
            if (it == null) {
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x016a, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Content$ui_debug(final AvatarScope $this$Content, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Content, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-1213288075);
        ComposerKt.sourceInformation($composer2, "C(Content)39@1170L323:GroupState.kt#iflarf");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 17) != 16, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1213288075, $dirty, -1, "kntr.compose.avatar.state.GroupState.Content (GroupState.kt:38)");
            }
            Modifier modifier$iv$iv = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -543949619, "C42@1244L51:GroupState.kt#iflarf");
            LayerGroup layerGroup = this.layerGroup;
            ComposerKt.sourceInformationMarkerStart($composer2, -17546578, "CC(remember):GroupState.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(layerGroup);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new GroupScopeImpl(this.layerGroup);
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            GroupScopeImpl scope = (GroupScopeImpl) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-17544406);
            ComposerKt.sourceInformation($composer2, "");
            GroupScopeImpl $this$Content_u24lambda_u240_u241 = scope;
            $composer2.startReplaceGroup(-17543490);
            ComposerKt.sourceInformation($composer2, "");
            Iterator it = this.layers.iterator();
            while (it.hasNext()) {
                LayerState layer = (LayerState) it.next();
                $composer2.startReplaceGroup(-17542144);
                ComposerKt.sourceInformation($composer2, "*46@1420L9");
                layer.Content$ui_debug($this$Content_u24lambda_u240_u241, $composer2, 0);
                $composer2.endReplaceGroup();
                it = it;
                $this$Content_u24lambda_u240_u241 = $this$Content_u24lambda_u240_u241;
            }
            $composer2.endReplaceGroup();
            $composer2.endReplaceGroup();
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.compose.avatar.state.GroupState$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$1;
                    Content$lambda$1 = GroupState.Content$lambda$1(GroupState.this, $this$Content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$1;
                }
            });
        }
    }
}