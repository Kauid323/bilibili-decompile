package kntr.compose.avatar.model.common;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IResource.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/compose/avatar/model/common/IResource;", "", "type", "Lkntr/compose/avatar/model/common/SourceType;", "getType", "()Lkntr/compose/avatar/model/common/SourceType;", "placeHolder", "Lkntr/compose/avatar/model/common/LocalSourceEnum;", "getPlaceHolder", "()Lkntr/compose/avatar/model/common/LocalSourceEnum;", "isValidResource", "", "()Z", "descStr", "", "getDescStr", "()Ljava/lang/String;", "Lkntr/compose/avatar/model/common/DrawSource;", "Lkntr/compose/avatar/model/common/InvalidResource;", "Lkntr/compose/avatar/model/common/LocalSource;", "Lkntr/compose/avatar/model/common/UrlResource;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IResource {
    String getDescStr();

    LocalSourceEnum getPlaceHolder();

    SourceType getType();

    boolean isValidResource();
}