package kntr.base.moss.platform;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KMethodDescriptor;
import kotlin.Metadata;

/* compiled from: IPlatformMossStream.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J*\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0007H&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/moss/platform/IPlatformMossStream;", "", "start", "", "stop", "register", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "request", "", "respHandler", "Lkntr/base/moss/platform/IPlatformResponseHandler;", "unregister", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPlatformMossStream {
    void register(KMethodDescriptor<?, ?> kMethodDescriptor, byte[] bArr, IPlatformResponseHandler iPlatformResponseHandler);

    void start();

    void stop();

    void unregister(KMethodDescriptor<?, ?> kMethodDescriptor);
}