package kntr.common.photonic.gallery.entity;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumContentReader;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PlatformAlbumInfo.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.photonic.gallery.entity.AlbumContentPaginationReader$read$2", f = "PlatformAlbumInfo.kt", i = {0, 1}, l = {37, 45}, m = "invokeSuspend", n = {"buffer", "buffer"}, s = {"L$0", "L$0"}, v = 1)
public final class AlbumContentPaginationReader$read$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<List<Asset>> $channel;
    Object L$0;
    int label;
    final /* synthetic */ AlbumContentPaginationReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlbumContentPaginationReader$read$2(AlbumContentPaginationReader albumContentPaginationReader, Channel<List<Asset>> channel, Continuation<? super AlbumContentPaginationReader$read$2> continuation) {
        super(2, continuation);
        this.this$0 = albumContentPaginationReader;
        this.$channel = channel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AlbumContentPaginationReader$read$2(this.this$0, this.$channel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005a A[Catch: all -> 0x0081, Exception -> 0x0083, TRY_LEAVE, TryCatch #1 {Exception -> 0x0083, blocks: (B:7:0x0017, B:10:0x001f, B:16:0x0051, B:18:0x005a, B:13:0x0027), top: B:34:0x0008, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        List buffer;
        AlbumContentReader albumContentReader;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
            } catch (Exception e) {
                this.$channel.close(e);
            }
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    buffer = new ArrayList();
                    albumContentReader = this.this$0.reader;
                    this.L$0 = buffer;
                    this.label = 1;
                    if (albumContentReader.read().collect(new AnonymousClass1(buffer, this.this$0, this.$channel), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (!buffer.isEmpty()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(buffer);
                        this.label = 2;
                        if (this.$channel.send(CollectionsKt.toList(buffer), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    buffer = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    if (!buffer.isEmpty()) {
                    }
                    return Unit.INSTANCE;
                case 2:
                    List list = (List) this.L$0;
                    ResultKt.throwOnFailure($result);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } finally {
            SendChannel.DefaultImpls.close$default(this.$channel, (Throwable) null, 1, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PlatformAlbumInfo.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* renamed from: kntr.common.photonic.gallery.entity.AlbumContentPaginationReader$read$2$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ List<Asset> $buffer;
        final /* synthetic */ Channel<List<Asset>> $channel;
        final /* synthetic */ AlbumContentPaginationReader this$0;

        AnonymousClass1(List<Asset> list, AlbumContentPaginationReader albumContentPaginationReader, Channel<List<Asset>> channel) {
            this.$buffer = list;
            this.this$0 = albumContentPaginationReader;
            this.$channel = channel;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((Asset) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0035  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Asset asset, Continuation<? super Unit> continuation) {
            AlbumContentPaginationReader$read$2$1$emit$1 albumContentPaginationReader$read$2$1$emit$1;
            int i;
            if (continuation instanceof AlbumContentPaginationReader$read$2$1$emit$1) {
                albumContentPaginationReader$read$2$1$emit$1 = (AlbumContentPaginationReader$read$2$1$emit$1) continuation;
                if ((albumContentPaginationReader$read$2$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    albumContentPaginationReader$read$2$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = albumContentPaginationReader$read$2$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (albumContentPaginationReader$read$2$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.$buffer.add(asset);
                            int size = this.$buffer.size();
                            i = this.this$0.pageSize;
                            if (size >= i) {
                                Channel<List<Asset>> channel = this.$channel;
                                List list = CollectionsKt.toList(this.$buffer);
                                albumContentPaginationReader$read$2$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(asset);
                                albumContentPaginationReader$read$2$1$emit$1.label = 1;
                                if (channel.send(list, albumContentPaginationReader$read$2$1$emit$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                this.$buffer.clear();
                                break;
                            }
                            break;
                        case 1:
                            Asset asset2 = (Asset) albumContentPaginationReader$read$2$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            this.$buffer.clear();
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
            albumContentPaginationReader$read$2$1$emit$1 = new AlbumContentPaginationReader$read$2$1$emit$1(this, continuation);
            Object $result2 = albumContentPaginationReader$read$2$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (albumContentPaginationReader$read$2$1$emit$1.label) {
            }
            return Unit.INSTANCE;
        }
    }
}