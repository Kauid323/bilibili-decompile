package kntr.common.opus.card;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.opus.card.OpusAdditionalCardModel;
import kotlin.Metadata;

/* compiled from: OpusAdditionalCardModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusAdditionalCommentCardView;", "", "model", "Lkntr/common/opus/card/OpusAdditionalCardModel$CommentModel;", "getModel", "()Lkntr/common/opus/card/OpusAdditionalCardModel$CommentModel;", "setModel", "(Lkntr/common/opus/card/OpusAdditionalCardModel$CommentModel;)V", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OpusAdditionalCommentCardView {
    OpusAdditionalCardModel.CommentModel getModel();

    void setModel(OpusAdditionalCardModel.CommentModel commentModel);
}