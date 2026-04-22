package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMoss;
import kntr.base.moss.platform.IPlatformResponseHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.protobuf.ProtoBuf;

/* compiled from: KMossService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ_\u0010\u0010\u001a\u00020\u0011\"\f\b\u0000\u0010\u0012*\u00060\u0001j\u0002`\u0013\"\f\b\u0001\u0010\u0014*\u00060\u0001j\u0002`\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJy\u0010\u0010\u001a\u00020\u0011\"\f\b\u0000\u0010\u0012*\u00060\u0001j\u0002`\u0013\"\f\b\u0001\u0010\u0014*\u00060\u0001j\u0002`\u00132\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00120\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00140 2\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007¢\u0006\u0002\u0010!JN\u0010\"\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\f\b\u0000\u0010\u0012*\u00060\u0001j\u0002`\u0013\"\f\b\u0001\u0010\u0014*\u00060\u0001j\u0002`\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00140\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0019JS\u0010#\u001a\u00020\u0011\"\f\b\u0000\u0010\u0012*\u00060\u0001j\u0002`\u0013\"\f\b\u0001\u0010\u0014*\u00060\u0001j\u0002`\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u00122\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0019¢\u0006\u0002\u0010$JN\u0010%\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u0019\"\f\b\u0000\u0010\u0012*\u00060\u0001j\u0002`\u0013\"\f\b\u0001\u0010\u0014*\u00060\u0001j\u0002`\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u00140\u00162\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0014\u0018\u00010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Lkntr/base/moss/api/KMossService;", "", "host", "", "port", "", "options", "Lkntr/base/moss/api/KCallOptions;", "<init>", "(Ljava/lang/String;ILkntr/base/moss/api/KCallOptions;)V", "getHost", "()Ljava/lang/String;", "getPort", "()I", "getOptions", "()Lkntr/base/moss/api/KCallOptions;", "asyncUnaryCall", "", "KReqT", "Lkntr/base/moss/api/KProtoMessage;", "KRespT", "method", "Lkntr/base/moss/api/KMethodDescriptor;", "request", "handler", "Lkntr/base/moss/api/KMossResponseHandler;", "rule", "Lkntr/base/moss/api/KMossHttpRule;", "(Lkntr/base/moss/api/KMethodDescriptor;Ljava/lang/Object;Lkntr/base/moss/api/KMossResponseHandler;Lkntr/base/moss/api/KMossHttpRule;)V", "requestSerializer", "Lkotlinx/serialization/SerializationStrategy;", "responseSerializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkntr/base/moss/api/KMethodDescriptor;Ljava/lang/Object;Lkotlinx/serialization/SerializationStrategy;Lkotlinx/serialization/DeserializationStrategy;Lkntr/base/moss/api/KMossResponseHandler;Lkntr/base/moss/api/KMossHttpRule;)V", "asyncClientStreamingCall", "asyncServerStreamingCall", "(Lkntr/base/moss/api/KMethodDescriptor;Ljava/lang/Object;Lkntr/base/moss/api/KMossResponseHandler;)V", "asyncBidiStreamingCall", "moss_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossService {
    private final String host;
    private final KCallOptions options;
    private final int port;

    public KMossService(String host, int port, KCallOptions options) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.port = port;
        this.options = options;
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        return this.port;
    }

    public final KCallOptions getOptions() {
        return this.options;
    }

    public static /* synthetic */ void asyncUnaryCall$default(KMossService kMossService, KMethodDescriptor kMethodDescriptor, Object obj, KMossResponseHandler kMossResponseHandler, KMossHttpRule kMossHttpRule, int i, Object obj2) {
        if ((i & 8) != 0) {
            kMossHttpRule = null;
        }
        kMossService.asyncUnaryCall(kMethodDescriptor, obj, kMossResponseHandler, kMossHttpRule);
    }

    public final <KReqT, KRespT> void asyncUnaryCall(KMethodDescriptor<KReqT, KRespT> kMethodDescriptor, KReqT kreqt, KMossResponseHandler<KRespT> kMossResponseHandler, KMossHttpRule rule) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        Intrinsics.checkNotNullParameter(kreqt, "request");
        asyncUnaryCall(kMethodDescriptor, kreqt, kMethodDescriptor.getReqSerialization(), kMethodDescriptor.getRespDeserialization(), kMossResponseHandler, rule);
    }

    public static /* synthetic */ void asyncUnaryCall$default(KMossService kMossService, KMethodDescriptor kMethodDescriptor, Object obj, SerializationStrategy serializationStrategy, DeserializationStrategy deserializationStrategy, KMossResponseHandler kMossResponseHandler, KMossHttpRule kMossHttpRule, int i, Object obj2) {
        KMossHttpRule kMossHttpRule2;
        if ((i & 32) == 0) {
            kMossHttpRule2 = kMossHttpRule;
        } else {
            kMossHttpRule2 = null;
        }
        kMossService.asyncUnaryCall(kMethodDescriptor, obj, serializationStrategy, deserializationStrategy, kMossResponseHandler, kMossHttpRule2);
    }

    public final <KReqT, KRespT> void asyncUnaryCall(KMethodDescriptor<?, ?> kMethodDescriptor, KReqT kreqt, SerializationStrategy<? super KReqT> serializationStrategy, final DeserializationStrategy<? extends KRespT> deserializationStrategy, final KMossResponseHandler<KRespT> kMossResponseHandler, KMossHttpRule rule) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        Intrinsics.checkNotNullParameter(kreqt, "request");
        Intrinsics.checkNotNullParameter(serializationStrategy, "requestSerializer");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "responseSerializer");
        byte[] reqData = ProtoBuf.Default.encodeToByteArray(serializationStrategy, kreqt);
        IPlatformResponseHandler iPlatformResponseHandler = new IPlatformResponseHandler() { // from class: kntr.base.moss.api.KMossService$asyncUnaryCall$respHandler$1
            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onNext(byte[] value) {
                Object model;
                if (value == null) {
                    model = null;
                } else {
                    try {
                        model = ProtoBuf.Default.decodeFromByteArray(deserializationStrategy, value);
                    } catch (Exception e) {
                        KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                        if (kMossResponseHandler2 != 0) {
                            kMossResponseHandler2.onError(new KNetworkException("Fail to decode response", e));
                            return;
                        }
                        return;
                    }
                }
                KMossResponseHandler<KRespT> kMossResponseHandler3 = kMossResponseHandler;
                if (kMossResponseHandler3 != 0) {
                    kMossResponseHandler3.onNext(model);
                }
            }

            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onError(KMossException t) {
                KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                if (kMossResponseHandler2 != 0) {
                    kMossResponseHandler2.onError(t);
                }
            }

            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onCompleted() {
                KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                if (kMossResponseHandler2 != 0) {
                    kMossResponseHandler2.onCompleted();
                }
            }
        };
        String str = this.host;
        int i = this.port;
        KCallOptions kCallOptions = this.options;
        if (kCallOptions == null) {
            kCallOptions = KCallOptions.Companion.getDefOptions();
        }
        KMossServiceComponent serviceComponent = new KMossServiceComponent(str, i, kCallOptions);
        ((IPlatformMoss) KMossServiceKt.getKMossServiceImpl().invoke()).asyncUnaryCall(serviceComponent, kMethodDescriptor, reqData, iPlatformResponseHandler, rule);
    }

    public final <KReqT, KRespT> KMossResponseHandler<KReqT> asyncClientStreamingCall(KMethodDescriptor<KReqT, KRespT> kMethodDescriptor, KMossResponseHandler<KRespT> kMossResponseHandler) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        throw KMossException.Companion.getUNSUPPORTED();
    }

    public final <KReqT, KRespT> void asyncServerStreamingCall(final KMethodDescriptor<KReqT, KRespT> kMethodDescriptor, KReqT kreqt, final KMossResponseHandler<KRespT> kMossResponseHandler) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        Intrinsics.checkNotNullParameter(kreqt, "request");
        byte[] reqData = ProtoBuf.Default.encodeToByteArray(kMethodDescriptor.getReqSerialization(), kreqt);
        KMossStream.Companion.getShared().register(kMethodDescriptor, reqData, new IPlatformResponseHandler() { // from class: kntr.base.moss.api.KMossService$asyncServerStreamingCall$respHandler$1
            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onNext(byte[] value) {
                Object model;
                if (value == null) {
                    model = null;
                } else {
                    try {
                        model = ProtoBuf.Default.decodeFromByteArray(kMethodDescriptor.getRespDeserialization(), value);
                    } catch (Exception e) {
                        KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                        if (kMossResponseHandler2 != 0) {
                            kMossResponseHandler2.onError(new KNetworkException("Fail to decode response", e));
                            return;
                        }
                        return;
                    }
                }
                KMossResponseHandler<KRespT> kMossResponseHandler3 = kMossResponseHandler;
                if (kMossResponseHandler3 != 0) {
                    kMossResponseHandler3.onNext(model);
                }
            }

            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onError(KMossException t) {
                KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                if (kMossResponseHandler2 != 0) {
                    kMossResponseHandler2.onError(t);
                }
            }

            @Override // kntr.base.moss.platform.IPlatformResponseHandler
            public void onCompleted() {
                KMossResponseHandler<KRespT> kMossResponseHandler2 = kMossResponseHandler;
                if (kMossResponseHandler2 != 0) {
                    kMossResponseHandler2.onCompleted();
                }
            }
        });
    }

    public final <KReqT, KRespT> KMossResponseHandler<KReqT> asyncBidiStreamingCall(KMethodDescriptor<KReqT, KRespT> kMethodDescriptor, KMossResponseHandler<KRespT> kMossResponseHandler) {
        Intrinsics.checkNotNullParameter(kMethodDescriptor, "method");
        throw KMossException.Companion.getUNSUPPORTED();
    }
}