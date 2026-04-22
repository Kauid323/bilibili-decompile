package kntr.base.ktor.ignet;

import com.bilibili.ktor.IgnetAttributes;
import com.bilibili.ktor.IgnetCapability;
import com.bilibili.lib.ighttp.IgHttpEngine;
import com.bilibili.lib.ighttp.IgHttpRequest;
import com.bilibili.lib.ighttp.Protocol;
import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.engine.HttpClientEngineConfig;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeoutCapability;
import io.ktor.client.plugins.HttpTimeoutConfig;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.KConfig;
import kntr.base.log.KLog_androidKt;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: IgnetHttpEngine.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\u001a$\u0010\u0002\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082@¢\u0006\u0002\u0010\t\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0080@¢\u0006\u0002\u0010\r\u001a\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0018H\u0000\u001a\u0018\u0010\u0016\u001a\u00020\u0019*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001aH\u0000\u001a\f\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"KTOR_IGNET_POST_STREAM_BODY_ENABLE", "", "convertToIgnetHttpRequest", "Lcom/bilibili/lib/ighttp/IgHttpRequest;", "Lio/ktor/client/request/HttpRequestData;", "callContext", "Lkotlin/coroutines/CoroutineContext;", RedirectImpKt.REDIRECT_KV_CONFIG, "Lio/ktor/client/engine/HttpClientEngineConfig;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/engine/HttpClientEngineConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertToByteArray", "", "Lio/ktor/http/content/OutgoingContent;", "(Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "convertToIgnetStreamDataProvider", "Lcom/bilibili/lib/ighttp/IgHttpRequest$StreamDataProvider;", "uploadListener", "Lio/ktor/client/content/ProgressListener;", "setupTimeoutAttributes", "Lcom/bilibili/lib/ighttp/IgHttpRequest$Builder;", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeoutConfig;", "fromIgnetHttp", "Lio/ktor/http/HttpProtocolVersion;", "Lcom/bilibili/lib/ighttp/Protocol;", "Lio/ktor/http/Headers;", "", "removeFirstSlash", "ktor-ignet-engine_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class IgnetHttpEngineKt {
    private static final String KTOR_IGNET_POST_STREAM_BODY_ENABLE = "ktor_ignet_post_stream_body_enable";

    /* compiled from: IgnetHttpEngine.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Protocol.values().length];
            try {
                iArr[Protocol.HTTP_1_0.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Protocol.HTTP_1_1.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Protocol.HTTP_2.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object convertToIgnetHttpRequest(HttpRequestData $this$convertToIgnetHttpRequest, CoroutineContext callContext, HttpClientEngineConfig config, Continuation<? super IgHttpRequest> continuation) {
        IgnetHttpEngineKt$convertToIgnetHttpRequest$1 ignetHttpEngineKt$convertToIgnetHttpRequest$1;
        final LinkedHashMap igHeaders;
        int finalRequestTimeout;
        byte[] reqBody;
        Object obj;
        boolean streamBodyEnable;
        HttpRequestData $this$convertToIgnetHttpRequest2;
        IgHttpRequest.StreamDataProvider streamDataProvider;
        HttpClientEngineConfig config2;
        CoroutineContext callContext2;
        IgHttpRequest.StreamDataProvider streamDataProvider2;
        HttpRequestData $this$convertToIgnetHttpRequest3;
        Long requestTimeoutMillis;
        Proxy proxy;
        SocketAddress address;
        String socketAddress;
        CoroutineContext callContext3 = callContext;
        try {
            if (continuation instanceof IgnetHttpEngineKt$convertToIgnetHttpRequest$1) {
                ignetHttpEngineKt$convertToIgnetHttpRequest$1 = (IgnetHttpEngineKt$convertToIgnetHttpRequest$1) continuation;
                if ((ignetHttpEngineKt$convertToIgnetHttpRequest$1.label & Integer.MIN_VALUE) != 0) {
                    ignetHttpEngineKt$convertToIgnetHttpRequest$1.label -= Integer.MIN_VALUE;
                    Object $result = ignetHttpEngineKt$convertToIgnetHttpRequest$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (ignetHttpEngineKt$convertToIgnetHttpRequest$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            igHeaders = new LinkedHashMap();
                            UtilsKt.mergeHeaders($this$convertToIgnetHttpRequest.getHeaders(), $this$convertToIgnetHttpRequest.getBody(), new Function2() { // from class: kntr.base.ktor.ignet.IgnetHttpEngineKt$$ExternalSyntheticLambda0
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit convertToIgnetHttpRequest$lambda$0;
                                    convertToIgnetHttpRequest$lambda$0 = IgnetHttpEngineKt.convertToIgnetHttpRequest$lambda$0(igHeaders, (String) obj2, (String) obj3);
                                    return convertToIgnetHttpRequest$lambda$0;
                                }
                            });
                            HttpTimeoutConfig timeout = (HttpTimeoutConfig) $this$convertToIgnetHttpRequest.getCapabilityOrNull(HttpTimeoutCapability.INSTANCE);
                            finalRequestTimeout = (timeout == null || (requestTimeoutMillis = timeout.getRequestTimeoutMillis()) == null) ? 5000 : (int) requestTimeoutMillis.longValue();
                            IgnetAttributes attrs = (IgnetAttributes) $this$convertToIgnetHttpRequest.getCapabilityOrNull(IgnetCapability.INSTANCE);
                            KLog_androidKt.getKLog().i("IgnetHttpEngine", "IgnetCapability attr" + (attrs != null ? attrs.getAttrs() : null));
                            KLog_androidKt.getKLog().i("IgnetHttpEngine", "Timeout - request: " + finalRequestTimeout);
                            ProgressListener uploadListener = (ProgressListener) $this$convertToIgnetHttpRequest.getAttributes().getOrNull(BodyProgressKeysKt.getUploadProgressListenerAttributeKey());
                            boolean streamBodyEnable2 = KConfig.INSTANCE.ff(KTOR_IGNET_POST_STREAM_BODY_ENABLE, true);
                            reqBody = null;
                            if (!Intrinsics.areEqual($this$convertToIgnetHttpRequest.getMethod(), HttpMethod.Companion.getPost()) && !Intrinsics.areEqual($this$convertToIgnetHttpRequest.getMethod(), HttpMethod.Companion.getPut())) {
                                callContext2 = callContext3;
                                streamDataProvider2 = null;
                                config2 = config;
                                $this$convertToIgnetHttpRequest3 = $this$convertToIgnetHttpRequest;
                                break;
                            } else if (streamBodyEnable2) {
                                IgHttpRequest.StreamDataProvider streamDataProvider3 = convertToIgnetStreamDataProvider($this$convertToIgnetHttpRequest.getBody(), callContext3, uploadListener);
                                callContext2 = callContext3;
                                streamDataProvider2 = streamDataProvider3;
                                config2 = config;
                                $this$convertToIgnetHttpRequest3 = $this$convertToIgnetHttpRequest;
                                break;
                            } else {
                                OutgoingContent body = $this$convertToIgnetHttpRequest.getBody();
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$0 = $this$convertToIgnetHttpRequest;
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$1 = SpillingKt.nullOutSpilledVariable(callContext);
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$2 = config;
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$3 = igHeaders;
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$4 = SpillingKt.nullOutSpilledVariable(timeout);
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$5 = SpillingKt.nullOutSpilledVariable(attrs);
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$6 = SpillingKt.nullOutSpilledVariable(uploadListener);
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.I$0 = finalRequestTimeout;
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.Z$0 = streamBodyEnable2;
                                ignetHttpEngineKt$convertToIgnetHttpRequest$1.label = 1;
                                Object convertToByteArray = convertToByteArray(body, callContext3, ignetHttpEngineKt$convertToIgnetHttpRequest$1);
                                if (convertToByteArray == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                obj = convertToByteArray;
                                streamBodyEnable = streamBodyEnable2;
                                $this$convertToIgnetHttpRequest2 = $this$convertToIgnetHttpRequest;
                                streamDataProvider = null;
                                config2 = config;
                                streamDataProvider2 = streamDataProvider;
                                reqBody = (byte[]) obj;
                                callContext2 = callContext3;
                                $this$convertToIgnetHttpRequest3 = $this$convertToIgnetHttpRequest2;
                                break;
                            }
                            break;
                        case 1:
                            streamBodyEnable = ignetHttpEngineKt$convertToIgnetHttpRequest$1.Z$0;
                            finalRequestTimeout = ignetHttpEngineKt$convertToIgnetHttpRequest$1.I$0;
                            streamDataProvider = null;
                            ProgressListener progressListener = (ProgressListener) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$6;
                            IgnetAttributes ignetAttributes = (IgnetAttributes) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$5;
                            HttpTimeoutConfig httpTimeoutConfig = (HttpTimeoutConfig) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$4;
                            igHeaders = (Map) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$3;
                            config2 = (HttpClientEngineConfig) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$2;
                            callContext3 = (CoroutineContext) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$1;
                            $this$convertToIgnetHttpRequest2 = (HttpRequestData) ignetHttpEngineKt$convertToIgnetHttpRequest$1.L$0;
                            ResultKt.throwOnFailure($result);
                            obj = $result;
                            streamDataProvider2 = streamDataProvider;
                            reqBody = (byte[]) obj;
                            callContext2 = callContext3;
                            $this$convertToIgnetHttpRequest3 = $this$convertToIgnetHttpRequest2;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    IgHttpRequest.Builder method = new IgHttpRequest.Builder().engine(IgHttpEngine.getInstance()).url($this$convertToIgnetHttpRequest3.getUrl().toString()).headerTimeout(finalRequestTimeout).dataTimeout(finalRequestTimeout).headers(igHeaders).streamDataProvider(streamDataProvider2).method($this$convertToIgnetHttpRequest3.getMethod().getValue(), reqBody);
                    proxy = config2.getProxy();
                    if (proxy != null || (address = proxy.address()) == null || (socketAddress = address.toString()) == null || (r10 = removeFirstSlash(socketAddress)) == null) {
                        String str = "";
                    }
                    IgHttpRequest.Builder igRequestBuilder = method.proxyUrl(str);
                    return igRequestBuilder.build();
                }
            }
            IgHttpRequest.Builder method2 = new IgHttpRequest.Builder().engine(IgHttpEngine.getInstance()).url($this$convertToIgnetHttpRequest3.getUrl().toString()).headerTimeout(finalRequestTimeout).dataTimeout(finalRequestTimeout).headers(igHeaders).streamDataProvider(streamDataProvider2).method($this$convertToIgnetHttpRequest3.getMethod().getValue(), reqBody);
            proxy = config2.getProxy();
            if (proxy != null) {
            }
            String str2 = "";
            IgHttpRequest.Builder igRequestBuilder2 = method2.proxyUrl(str2);
            return igRequestBuilder2.build();
        } catch (Exception e) {
            KLog_androidKt.getKLog().w("IgnetHttpEngine", "e:" + e);
            return null;
        }
        ignetHttpEngineKt$convertToIgnetHttpRequest$1 = new IgnetHttpEngineKt$convertToIgnetHttpRequest$1(continuation);
        Object $result2 = ignetHttpEngineKt$convertToIgnetHttpRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ignetHttpEngineKt$convertToIgnetHttpRequest$1.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit convertToIgnetHttpRequest$lambda$0(Map $igHeaders, String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        String newValue = value;
        if (StringsKt.equals(key, "User-Agent", false)) {
            newValue = newValue + " engine:ignet_http";
        }
        $igHeaders.put(key, newValue);
        return Unit.INSTANCE;
    }

    public static final Object convertToByteArray(OutgoingContent $this$convertToByteArray, CoroutineContext callContext, Continuation<? super byte[]> continuation) {
        if ($this$convertToByteArray instanceof OutgoingContent.ByteArrayContent) {
            return ((OutgoingContent.ByteArrayContent) $this$convertToByteArray).bytes();
        }
        if ($this$convertToByteArray instanceof OutgoingContent.ReadChannelContent) {
            Object byteArray = ByteReadChannelOperationsKt.toByteArray(((OutgoingContent.ReadChannelContent) $this$convertToByteArray).readFrom(), continuation);
            return byteArray == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? byteArray : (byte[]) byteArray;
        } else if ($this$convertToByteArray instanceof OutgoingContent.WriteChannelContent) {
            Object byteArray2 = ByteReadChannelOperationsKt.toByteArray(ByteWriteChannelOperationsKt.writer$default(GlobalScope.INSTANCE, callContext, false, new IgnetHttpEngineKt$convertToByteArray$2($this$convertToByteArray, null), 2, (Object) null).getChannel(), continuation);
            return byteArray2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? byteArray2 : (byte[]) byteArray2;
        } else if ($this$convertToByteArray instanceof OutgoingContent.NoContent) {
            return new byte[0];
        } else {
            throw new UnsupportedContentTypeException($this$convertToByteArray);
        }
    }

    public static /* synthetic */ IgHttpRequest.StreamDataProvider convertToIgnetStreamDataProvider$default(OutgoingContent outgoingContent, CoroutineContext coroutineContext, ProgressListener progressListener, int i, Object obj) {
        if ((i & 2) != 0) {
            progressListener = null;
        }
        return convertToIgnetStreamDataProvider(outgoingContent, coroutineContext, progressListener);
    }

    public static final IgHttpRequest.StreamDataProvider convertToIgnetStreamDataProvider(OutgoingContent $this$convertToIgnetStreamDataProvider, final CoroutineContext callContext, final ProgressListener uploadListener) {
        Intrinsics.checkNotNullParameter($this$convertToIgnetStreamDataProvider, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        final Channel dataChannel = ChannelKt.Channel$default(-2, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        Long contentLength = $this$convertToIgnetStreamDataProvider.getContentLength();
        final long totalSize = contentLength != null ? contentLength.longValue() : -1L;
        final AtomicBoolean isClosed = new AtomicBoolean(false);
        final Ref.LongRef uploadedBytes = new Ref.LongRef();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(callContext), (CoroutineContext) null, (CoroutineStart) null, new IgnetHttpEngineKt$convertToIgnetStreamDataProvider$1($this$convertToIgnetStreamDataProvider, dataChannel, callContext, null), 3, (Object) null);
        return new IgHttpRequest.StreamDataProvider() { // from class: kntr.base.ktor.ignet.IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2
            public byte[] onProduceData(int maxLength) {
                if (isClosed.get()) {
                    return null;
                }
                return (byte[]) BuildersKt.runBlocking(callContext, new IgnetHttpEngineKt$convertToIgnetStreamDataProvider$2$onProduceData$1(dataChannel, isClosed, uploadedBytes, uploadListener, totalSize, null));
            }
        };
    }

    private static final IgHttpRequest.Builder setupTimeoutAttributes(IgHttpRequest.Builder $this$setupTimeoutAttributes, HttpTimeoutConfig timeoutAttributes) {
        Long connectTimeoutMillis = timeoutAttributes.getConnectTimeoutMillis();
        if (connectTimeoutMillis != null) {
            long it = connectTimeoutMillis.longValue();
            $this$setupTimeoutAttributes.headerTimeout((int) it);
        }
        Long requestTimeoutMillis = timeoutAttributes.getRequestTimeoutMillis();
        if (requestTimeoutMillis != null) {
            long it2 = requestTimeoutMillis.longValue();
            $this$setupTimeoutAttributes.dataTimeout((int) it2);
        }
        return $this$setupTimeoutAttributes;
    }

    public static final HttpProtocolVersion fromIgnetHttp(Protocol $this$fromIgnetHttp) {
        Intrinsics.checkNotNullParameter($this$fromIgnetHttp, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$fromIgnetHttp.ordinal()]) {
            case 1:
                return HttpProtocolVersion.Companion.getHTTP_1_0();
            case 2:
                return HttpProtocolVersion.Companion.getHTTP_1_1();
            case 3:
                return HttpProtocolVersion.Companion.getHTTP_2_0();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final Headers fromIgnetHttp(final Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new Headers() { // from class: kntr.base.ktor.ignet.IgnetHttpEngineKt$fromIgnetHttp$1
            private final boolean caseInsensitiveName = true;

            public /* bridge */ boolean contains(String name) {
                return Headers.DefaultImpls.contains(this, name);
            }

            public /* bridge */ boolean contains(String name, String value) {
                return Headers.DefaultImpls.contains(this, name, value);
            }

            public /* bridge */ void forEach(Function2<? super String, ? super List<String>, Unit> function2) {
                Headers.DefaultImpls.forEach(this, function2);
            }

            public /* bridge */ String get(String name) {
                return Headers.DefaultImpls.get(this, name);
            }

            public boolean getCaseInsensitiveName() {
                return this.caseInsensitiveName;
            }

            public List<String> getAll(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return toMultimap().get(name);
            }

            public Set<String> names() {
                return names();
            }

            public Set<Map.Entry<String, List<String>>> entries() {
                return toMultimap().entrySet();
            }

            public boolean isEmpty() {
                return isEmpty();
            }

            private final Map<String, List<String>> toMultimap() {
                HashMap ret = new HashMap();
                for (Map.Entry entry : map.entrySet()) {
                    ArrayList values = (ArrayList) ret.get(entry.getKey());
                    if (values == null) {
                        values = new ArrayList(2);
                    }
                    values.add(entry.getValue());
                    ret.put(entry.getKey(), values);
                }
                return ret;
            }
        };
    }

    public static final String removeFirstSlash(String $this$removeFirstSlash) {
        Intrinsics.checkNotNullParameter($this$removeFirstSlash, "<this>");
        return StringsKt.replaceFirst$default($this$removeFirstSlash, "/", "", false, 4, (Object) null);
    }
}