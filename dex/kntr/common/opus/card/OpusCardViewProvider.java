package kntr.common.opus.card;

import android.view.View;
import android.view.ViewGroup;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: OpusCardViewProvider.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/common/opus/card/OpusCardViewProvider;", "", "getAdditionalCardView", "Landroid/view/View;", "model", "Lkntr/common/opus/card/OpusAdditionalCardModel;", "parent", "Landroid/view/ViewGroup;", "card_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OpusCardViewProvider {
    View getAdditionalCardView(OpusAdditionalCardModel opusAdditionalCardModel, ViewGroup viewGroup);
}