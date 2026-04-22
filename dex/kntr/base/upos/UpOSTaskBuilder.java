package kntr.base.upos;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IUpOS.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004H&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/upos/UpOSTaskBuilder;", "", "setProfile", "profile", "", "setMetaProfile", "setFrom", "from", "setBiz", "biz", "build", "Lkntr/base/upos/UpOSTask;", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UpOSTaskBuilder {
    UpOSTask build();

    UpOSTaskBuilder setBiz(String str);

    UpOSTaskBuilder setFrom(String str);

    UpOSTaskBuilder setMetaProfile(String str);

    UpOSTaskBuilder setProfile(String str);
}