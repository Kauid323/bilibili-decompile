package kntr.compose.avatar;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.AvatarItem;
import kntr.compose.avatar.model.layers.LayerGroup;
import kntr.compose.avatar.state.GroupState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarState.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u001a\u001a\u00020\u001b*\u00020\u001cH\u0001¢\u0006\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R/\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lkntr/compose/avatar/AvatarState;", "", "avatarItem", "Lkntr/compose/avatar/model/AvatarItem;", "normalSize", "Landroidx/compose/ui/unit/Dp;", "<init>", "(Lkntr/compose/avatar/model/AvatarItem;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAvatarItem", "()Lkntr/compose/avatar/model/AvatarItem;", "getNormalSize-D9Ej5fM", "()F", "F", "groupState", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkntr/compose/avatar/state/GroupState;", "getGroupState", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "fallbackGroup", "getFallbackGroup", "()Lkntr/compose/avatar/state/GroupState;", "setFallbackGroup", "(Lkntr/compose/avatar/state/GroupState;)V", "fallbackGroup$delegate", "Landroidx/compose/runtime/MutableState;", "Content", "", "Lkntr/compose/avatar/AvatarScope;", "Content$ui_debug", "(Lkntr/compose/avatar/AvatarScope;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvatarState {
    public static final int $stable = 0;
    private final AvatarItem avatarItem;
    private final MutableState fallbackGroup$delegate;
    private final SnapshotStateList<GroupState> groupState;
    private final float normalSize;

    public /* synthetic */ AvatarState(AvatarItem avatarItem, float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(avatarItem, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$2(AvatarState avatarState, AvatarScope avatarScope, int i, Composer composer, int i2) {
        avatarState.Content$ui_debug(avatarScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private AvatarState(AvatarItem avatarItem, float normalSize) {
        Intrinsics.checkNotNullParameter(avatarItem, "avatarItem");
        this.avatarItem = avatarItem;
        this.normalSize = normalSize;
        Iterable $this$map$iv = this.avatarItem.getGroups();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(new GroupState((LayerGroup) item$iv$iv, this.normalSize, null));
        }
        this.groupState = SnapshotStateKt.toMutableStateList((List) destination$iv$iv);
        LayerGroup it = this.avatarItem.getFallbackGroup();
        this.fallbackGroup$delegate = SnapshotStateKt.mutableStateOf$default(it != null ? new GroupState(it, this.normalSize, null) : null, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public final AvatarItem getAvatarItem() {
        return this.avatarItem;
    }

    /* renamed from: getNormalSize-D9Ej5fM  reason: not valid java name */
    public final float m2500getNormalSizeD9Ej5fM() {
        return this.normalSize;
    }

    public final SnapshotStateList<GroupState> getGroupState() {
        return this.groupState;
    }

    public final GroupState getFallbackGroup() {
        State $this$getValue$iv = this.fallbackGroup$delegate;
        return (GroupState) $this$getValue$iv.getValue();
    }

    public final void setFallbackGroup(GroupState groupState) {
        MutableState $this$setValue$iv = this.fallbackGroup$delegate;
        $this$setValue$iv.setValue(groupState);
    }

    public final void Content$ui_debug(final AvatarScope $this$Content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$Content, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-1879104572);
        ComposerKt.sourceInformation($composer2, "C(Content):AvatarState.kt#v7x95u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed($this$Content) : $composer2.changedInstance($this$Content) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(this) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1879104572, $dirty, -1, "kntr.compose.avatar.AvatarState.Content (AvatarState.kt:33)");
            }
            $composer2.startReplaceGroup(-1933228159);
            ComposerKt.sourceInformation($composer2, "*35@991L9");
            GroupState fallbackGroup = getFallbackGroup();
            if (fallbackGroup != null) {
                fallbackGroup.Content$ui_debug($this$Content, $composer2, $dirty & 14);
                Unit unit = Unit.INSTANCE;
            }
            $composer2.endReplaceGroup();
            Iterator it = this.groupState.iterator();
            while (it.hasNext()) {
                GroupState group = (GroupState) it.next();
                $composer2.startReplaceGroup(-1933224647);
                ComposerKt.sourceInformation($composer2, "*39@1089L9");
                group.Content$ui_debug($this$Content, $composer2, $dirty & 14);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.compose.avatar.AvatarState$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$2;
                    Content$lambda$2 = AvatarState.Content$lambda$2(AvatarState.this, $this$Content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$2;
                }
            });
        }
    }
}