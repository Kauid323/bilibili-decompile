package kntr.compose.avatar.internal;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.AvatarGroupScope;
import kntr.compose.avatar.model.layers.LayerGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarScopeImpl.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkntr/compose/avatar/internal/GroupScopeImpl;", "Lkntr/compose/avatar/AvatarGroupScope;", "group", "Lkntr/compose/avatar/model/layers/LayerGroup;", "<init>", "(Lkntr/compose/avatar/model/layers/LayerGroup;)V", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GroupScopeImpl implements AvatarGroupScope {
    public static final int $stable = 0;
    private final LayerGroup group;

    public GroupScopeImpl(LayerGroup group) {
        Intrinsics.checkNotNullParameter(group, "group");
        this.group = group;
    }
}