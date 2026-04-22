package kntr.app.tribee.invite.track;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.KNeuron;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InviteTracker.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"INVITE_PAGE_PV", "", "inviteCodeExposure", "", "tribeeId", "", "inviteCodeClick", "actionType", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InviteTrackerKt {
    public static final String INVITE_PAGE_PV = "tribee.my-invite-code.0.0.pv";

    public static final void inviteCodeExposure(long tribeeId) {
        KNeuron.INSTANCE.reportExposure(false, "tribee.my-invite-code.code-card.0.show", MapsKt.mapOf(TuplesKt.to("tribee_id", String.valueOf(tribeeId))));
    }

    public static final void inviteCodeClick(long tribeeId, String actionType) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        KNeuron.INSTANCE.reportClick(false, "tribee.my-invite-code.code-card.0.click", MapsKt.mapOf(new Pair[]{TuplesKt.to("tribee_id", String.valueOf(tribeeId)), TuplesKt.to(WatchLaterReporterKt.KEY_ACTION_TYPE, actionType)}));
    }
}