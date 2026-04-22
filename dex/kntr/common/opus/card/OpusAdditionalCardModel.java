package kntr.common.opus.card;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: OpusAdditionalCardModel.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusAdditionalCardModel;", "", "originalData", "", "getOriginalData", "()[B", "isInteractive", "", "()Z", "cardWidth", "", "getCardWidth", "()F", "VideoModel", "OpusModel", "CommentModel", "Lkntr/common/opus/card/OpusAdditionalCardModel$CommentModel;", "Lkntr/common/opus/card/OpusAdditionalCardModel$OpusModel;", "Lkntr/common/opus/card/OpusAdditionalCardModel$VideoModel;", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OpusAdditionalCardModel {

    /* compiled from: OpusAdditionalCardModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusAdditionalCardModel$CommentModel;", "Lkntr/common/opus/card/OpusAdditionalCardModel;", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface CommentModel extends OpusAdditionalCardModel {
    }

    /* compiled from: OpusAdditionalCardModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusAdditionalCardModel$OpusModel;", "Lkntr/common/opus/card/OpusAdditionalCardModel;", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface OpusModel extends OpusAdditionalCardModel {
    }

    /* compiled from: OpusAdditionalCardModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusAdditionalCardModel$VideoModel;", "Lkntr/common/opus/card/OpusAdditionalCardModel;", "style", "Lkntr/common/opus/card/OpusAdditionalCardModelVideoStyle;", "getStyle", "()Lkntr/common/opus/card/OpusAdditionalCardModelVideoStyle;", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface VideoModel extends OpusAdditionalCardModel {
        OpusAdditionalCardModelVideoStyle getStyle();
    }

    float getCardWidth();

    byte[] getOriginalData();

    boolean isInteractive();
}