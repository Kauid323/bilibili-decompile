package kntr.app.game.gamebind.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthorizeParams.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\b"}, d2 = {"fromUnbindRoleItem", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "unbindRole", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "fromRoleList", RoomRecommendViewModel.EMPTY_CURSOR, "fromUnbindRoleItemJSONString", RoomRecommendViewModel.EMPTY_CURSOR, "game-bind_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AuthorizeParamsKt {
    public static final AuthorizeParams fromUnbindRoleItem(UnbindRoleItem unbindRole, boolean fromRoleList) {
        Intrinsics.checkNotNullParameter(unbindRole, "unbindRole");
        String valueOf = String.valueOf(unbindRole.getGameBaseId());
        String gameName = unbindRole.getGameName();
        String icon = unbindRole.getIcon();
        int distributorChannelId = unbindRole.getDistributorChannelId();
        String distributorChannelName = unbindRole.getDistributorChannelName();
        if (distributorChannelName == null) {
            distributorChannelName = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        AuthorizeParams params = new AuthorizeParams(valueOf, gameName, icon, distributorChannelId, distributorChannelName, unbindRole.getAuthStatus(), false, unbindRole.getBindMethodType(), unbindRole.getGameInfo(), fromRoleList);
        return params;
    }

    public static final AuthorizeParams fromUnbindRoleItemJSONString(String unbindRole, boolean fromRoleList) {
        Intrinsics.checkNotNullParameter(unbindRole, "unbindRole");
        return fromUnbindRoleItem(UnbindRoleItemKt.decodeFromString(unbindRole), fromRoleList);
    }
}