package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IResource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkntr/compose/avatar/model/common/InvalidResource;", "Lkntr/compose/avatar/model/common/IResource;", "<init>", "()V", "type", "Lkntr/compose/avatar/model/common/SourceType;", "getType", "()Lkntr/compose/avatar/model/common/SourceType;", "placeHolder", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "getPlaceHolder", "()Lkntr/compose/avatar/model/common/LocalSourceEnum;", "isValidResource", "", "()Z", "descStr", "", "getDescStr", "()Ljava/lang/String;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InvalidResource implements IResource {
    public static final InvalidResource INSTANCE = new InvalidResource();

    private InvalidResource() {
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public SourceType getType() {
        return SourceType.InvalidSource;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public LocalSourceEnum getPlaceHolder() {
        return LocalSourceEnum.Invalid;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public boolean isValidResource() {
        return false;
    }

    @Override // kntr.compose.avatar.model.common.IResource
    public String getDescStr() {
        return "Invalid";
    }
}