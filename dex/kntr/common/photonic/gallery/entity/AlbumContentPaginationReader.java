package kntr.common.photonic.gallery.entity;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: PlatformAlbumInfo.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/common/photonic/gallery/entity/AlbumContentPaginationReader;", "", "reader", "Lkntr/common/photonic/AlbumContentReader;", "pageSize", "", "<init>", "(Lkntr/common/photonic/AlbumContentReader;I)V", "read", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkntr/common/photonic/Asset;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gallery_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AlbumContentPaginationReader {
    public static final int $stable = 8;
    private final int pageSize;
    private final AlbumContentReader reader;

    public AlbumContentPaginationReader(AlbumContentReader reader, int pageSize) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.reader = reader;
        this.pageSize = pageSize;
    }

    public final Object read(Continuation<? super ReceiveChannel<? extends List<? extends Asset>>> continuation) {
        Channel channel = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(continuation.getContext().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), CoroutineExJvmKt.getIoContext(), (CoroutineStart) null, new AlbumContentPaginationReader$read$2(this, channel, null), 2, (Object) null);
        return channel;
    }
}