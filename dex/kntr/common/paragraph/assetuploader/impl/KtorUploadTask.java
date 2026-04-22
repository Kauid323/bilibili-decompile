package kntr.common.paragraph.assetuploader.impl;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KApiResponseKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.content.ProgressListener;
import io.ktor.client.plugins.BodyProgressKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.forms.FormBuilder;
import io.ktor.client.request.forms.FormDslKt;
import io.ktor.client.request.forms.InputProvider;
import io.ktor.client.request.forms.MultiPartFormDataContent;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HeaderValueWithParametersKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.common.paragraph.assetuploader.ImageUploadResult;
import kntr.common.paragraph.assetuploader.UploadTask;
import kntr.common.paragraph.assetuploader.base.AssetUploaderParams;
import kntr.common.paragraph.watermark.AssetUploaderWaterMark;
import kntr.common.photonic.Asset;
import kntr.common.photonic.ContentSize;
import kntr.common.photonic.ContentSizeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.uuid.Uuid;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.io.Source;

/* compiled from: MossAssetUploaderImpl.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0096@¢\u0006\u0004\b\"\u0010#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\tX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/KtorUploadTask;", "Lkntr/common/paragraph/assetuploader/UploadTask;", "asset", "Lkntr/common/photonic/Asset;", "index", "", "client", "Lio/ktor/client/HttpClient;", "bucket", "", "params", "Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;", "<init>", "(Lkntr/common/photonic/Asset;ILio/ktor/client/HttpClient;Ljava/lang/String;Lkntr/common/paragraph/assetuploader/base/AssetUploaderParams;)V", "getAsset", "()Lkntr/common/photonic/Asset;", "getIndex", "()I", "getClient", "()Lio/ktor/client/HttpClient;", "getBucket", "()Ljava/lang/String;", "progressChannel", "Lkotlinx/coroutines/channels/Channel;", "Lkntr/common/photonic/ContentSize;", "contentUniqueId", "getContentUniqueId$annotations", "()V", "taskContentSize", "getTaskContentSize-QJZHGII", "()D", "awaitResult", "Lkotlin/Result;", "Lkntr/common/paragraph/assetuploader/ImageUploadResult;", "awaitResult-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progress", "Lkotlinx/coroutines/flow/Flow;", "getProgress", "()Lkotlinx/coroutines/flow/Flow;", "Companion", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KtorUploadTask implements UploadTask {
    private static final String ASSET_UPLOADER_EVENT_ERROR = "asset.uploader.event.error";
    private static final String ASSET_UPLOADER_EVENT_START = "asset.uploader.event.start";
    private static final String ASSET_UPLOADER_EVENT_SUCCESS = "asset.uploader.event.success";
    public static final Companion Companion = new Companion(null);
    private final Asset asset;
    private final String bucket;
    private final HttpClient client;
    private final String contentUniqueId;
    private final int index;
    private final AssetUploaderParams params;
    private final Channel<ContentSize> progressChannel;

    private static /* synthetic */ void getContentUniqueId$annotations() {
    }

    public KtorUploadTask(Asset asset, int index, HttpClient client, String bucket, AssetUploaderParams params) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(params, "params");
        this.asset = asset;
        this.index = index;
        this.client = client;
        this.bucket = bucket;
        this.params = params;
        this.progressChannel = ChannelKt.Channel$default(0, BufferOverflow.DROP_OLDEST, (Function1) null, 5, (Object) null);
        this.contentUniqueId = Uuid.Companion.random().toString();
    }

    @Override // kntr.common.paragraph.assetuploader.UploadTask
    public Asset getAsset() {
        return this.asset;
    }

    public final int getIndex() {
        return this.index;
    }

    public final HttpClient getClient() {
        return this.client;
    }

    public final String getBucket() {
        return this.bucket;
    }

    @Override // kntr.common.paragraph.assetuploader.UploadTask
    /* renamed from: getTaskContentSize-QJZHGII */
    public double mo2151getTaskContentSizeQJZHGII() {
        return getAsset().mo2158getContentSizeQJZHGII();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|108|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e0, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e1, code lost:
        r26 = "height";
        r30 = "width";
        r20 = "asset_size";
        r18 = "asset_path";
        r16 = "asset_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0318, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01e1 A[Catch: all -> 0x0318, TRY_LEAVE, TryCatch #6 {all -> 0x0318, blocks: (B:71:0x02ff, B:72:0x030f, B:73:0x0317, B:54:0x0289, B:66:0x02bd, B:39:0x01d6, B:50:0x020a, B:42:0x01e1, B:49:0x0202), top: B:99:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x027e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02ff A[Catch: all -> 0x0318, TryCatch #6 {all -> 0x0318, blocks: (B:71:0x02ff, B:72:0x030f, B:73:0x0317, B:54:0x0289, B:66:0x02bd, B:39:0x01d6, B:50:0x020a, B:42:0x01e1, B:49:0x0202), top: B:99:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x030f A[Catch: all -> 0x0318, TryCatch #6 {all -> 0x0318, blocks: (B:71:0x02ff, B:72:0x030f, B:73:0x0317, B:54:0x0289, B:66:0x02bd, B:39:0x01d6, B:50:0x020a, B:42:0x01e1, B:49:0x0202), top: B:99:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03f9  */
    @Override // kntr.common.paragraph.assetuploader.UploadTask
    /* renamed from: awaitResult-IoAF18A */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo2150awaitResultIoAF18A(Continuation<? super Result<ImageUploadResult>> continuation) {
        KtorUploadTask$awaitResult$1 ktorUploadTask$awaitResult$1;
        KtorUploadTask$awaitResult$1 ktorUploadTask$awaitResult$12;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object m2636constructorimpl;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Throwable it;
        KtorUploadTask $this$awaitResult_IoAF18A_u24lambda_u240;
        Object reader;
        int $i$f$request;
        Object obj11;
        final KtorUploadTask $this$awaitResult_IoAF18A_u24lambda_u2402;
        final Source contentReader;
        HttpRequestBuilder $this$submitFormWithBinaryData_u24lambda_u243$iv$iv;
        Object body$iv$iv$iv;
        KType kType;
        Object execute;
        KtorUploadTask $this$awaitResult_IoAF18A_u24lambda_u2403;
        KType kType2;
        Object bodyNullable;
        if (continuation instanceof KtorUploadTask$awaitResult$1) {
            ktorUploadTask$awaitResult$1 = (KtorUploadTask$awaitResult$1) continuation;
            if ((ktorUploadTask$awaitResult$1.label & Integer.MIN_VALUE) != 0) {
                ktorUploadTask$awaitResult$1.label -= Integer.MIN_VALUE;
                ktorUploadTask$awaitResult$12 = ktorUploadTask$awaitResult$1;
                Object $result = ktorUploadTask$awaitResult$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (ktorUploadTask$awaitResult$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        KNeuron.INSTANCE.simpleTrackT(ASSET_UPLOADER_EVENT_START, MapsKt.mapOf(new Pair[]{TuplesKt.to("asset_id", this.contentUniqueId), TuplesKt.to("asset_path", getAsset().getIdentifier()), TuplesKt.to("asset_size", String.valueOf(mo2151getTaskContentSizeQJZHGII())), TuplesKt.to("width", String.valueOf(getAsset().getResolution().getWidthPx())), TuplesKt.to("height", String.valueOf(getAsset().getResolution().getHeightPx()))}));
                        try {
                            Result.Companion companion = Result.Companion;
                            $this$awaitResult_IoAF18A_u24lambda_u240 = this;
                            Asset asset = $this$awaitResult_IoAF18A_u24lambda_u240.getAsset();
                            ktorUploadTask$awaitResult$12.L$0 = $this$awaitResult_IoAF18A_u24lambda_u240;
                            ktorUploadTask$awaitResult$12.I$0 = 0;
                            ktorUploadTask$awaitResult$12.label = 1;
                            reader = asset.reader(ktorUploadTask$awaitResult$12);
                        } catch (Throwable th) {
                            th = th;
                            obj = "height";
                            obj2 = "width";
                            obj3 = "asset_size";
                            obj4 = "asset_path";
                            obj5 = "asset_id";
                            Result.Companion companion2 = Result.Companion;
                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                            }
                            SendChannel.DefaultImpls.close$default(this.progressChannel, (Throwable) null, 1, (Object) null);
                            return m2636constructorimpl;
                        }
                        if (reader == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $i$f$request = 0;
                        obj11 = reader;
                        $this$awaitResult_IoAF18A_u24lambda_u2402 = $this$awaitResult_IoAF18A_u24lambda_u240;
                        contentReader = (Source) obj11;
                        HttpClient $this$submitFormWithBinaryData$iv = $this$awaitResult_IoAF18A_u24lambda_u2402.client;
                        List formData$iv = FormDslKt.formData(new Function1() { // from class: kntr.common.paragraph.assetuploader.impl.KtorUploadTask$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj12) {
                                Unit awaitResult_IoAF18A$lambda$0$0;
                                awaitResult_IoAF18A$lambda$0$0 = KtorUploadTask.awaitResult_IoAF18A$lambda$0$0(KtorUploadTask.this, contentReader, (FormBuilder) obj12);
                                return awaitResult_IoAF18A$lambda$0$0;
                            }
                        });
                        obj = "height";
                        try {
                            $this$submitFormWithBinaryData_u24lambda_u243$iv$iv = new HttpRequestBuilder();
                            obj2 = "width";
                            try {
                                $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setMethod(HttpMethod.Companion.getPost());
                                body$iv$iv$iv = new MultiPartFormDataContent(formData$iv, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
                                obj3 = "asset_size";
                                try {
                                    if (body$iv$iv$iv instanceof OutgoingContent) {
                                        obj4 = "asset_path";
                                        obj5 = "asset_id";
                                        $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setBody(body$iv$iv$iv);
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MultiPartFormDataContent.class);
                                        try {
                                            kType = Reflection.typeOf(MultiPartFormDataContent.class);
                                        } catch (Throwable th2) {
                                            kType = null;
                                        }
                                        $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setBodyType(new TypeInfo(orCreateKotlinClass, kType));
                                    } else {
                                        obj4 = "asset_path";
                                        try {
                                            $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setBody(body$iv$iv$iv);
                                            obj5 = "asset_id";
                                            $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setBodyType((TypeInfo) null);
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj5 = "asset_id";
                                            Result.Companion companion22 = Result.Companion;
                                            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
                                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                                            }
                                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                                            if (it != null) {
                                            }
                                            SendChannel.DefaultImpls.close$default(this.progressChannel, (Throwable) null, 1, (Object) null);
                                            return m2636constructorimpl;
                                        }
                                    }
                                    HttpRequestKt.url($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, "https://api.bilibili.com/x/dynamic/feed/draw/upload_bfs");
                                    BodyProgressKt.onUpload($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, new ProgressListener() { // from class: kntr.common.paragraph.assetuploader.impl.KtorUploadTask$awaitResult$2$result$2$1
                                        public final Object onProgress(long bytesSentTotal, Long l, Continuation<? super Unit> continuation2) {
                                            Channel channel;
                                            channel = KtorUploadTask.this.progressChannel;
                                            Object send = channel.send(ContentSize.m2181boximpl(ContentSizeKt.bytes(Boxing.boxLong(bytesSentTotal))), continuation2);
                                            return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                                        }
                                    });
                                    HttpStatement httpStatement = new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, $this$submitFormWithBinaryData$iv);
                                    ktorUploadTask$awaitResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitResult_IoAF18A_u24lambda_u2402);
                                    ktorUploadTask$awaitResult$12.L$1 = SpillingKt.nullOutSpilledVariable(contentReader);
                                    ktorUploadTask$awaitResult$12.L$2 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv);
                                    ktorUploadTask$awaitResult$12.L$3 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/dynamic/feed/draw/upload_bfs");
                                    ktorUploadTask$awaitResult$12.L$4 = SpillingKt.nullOutSpilledVariable(formData$iv);
                                    ktorUploadTask$awaitResult$12.L$5 = SpillingKt.nullOutSpilledVariable(ktorUploadTask$awaitResult$12);
                                    ktorUploadTask$awaitResult$12.L$6 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv);
                                    ktorUploadTask$awaitResult$12.L$7 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv);
                                    ktorUploadTask$awaitResult$12.L$8 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv);
                                    ktorUploadTask$awaitResult$12.L$9 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData_u24lambda_u243$iv$iv);
                                    ktorUploadTask$awaitResult$12.I$0 = $i$f$request;
                                    ktorUploadTask$awaitResult$12.I$1 = 0;
                                    ktorUploadTask$awaitResult$12.I$2 = 0;
                                    ktorUploadTask$awaitResult$12.I$3 = 0;
                                    ktorUploadTask$awaitResult$12.I$4 = 0;
                                    ktorUploadTask$awaitResult$12.label = 2;
                                    execute = httpStatement.execute(ktorUploadTask$awaitResult$12);
                                } catch (Throwable th4) {
                                    th = th4;
                                    obj4 = "asset_path";
                                    obj5 = "asset_id";
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                obj3 = "asset_size";
                                obj4 = "asset_path";
                                obj5 = "asset_id";
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            obj2 = "width";
                            obj3 = "asset_size";
                            obj4 = "asset_path";
                            obj5 = "asset_id";
                        }
                        if (execute != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $this$awaitResult_IoAF18A_u24lambda_u2403 = $this$awaitResult_IoAF18A_u24lambda_u2402;
                        HttpResponse result = (HttpResponse) execute;
                        HttpClientCall call = result.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            try {
                                kType2 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ImageUploadResult.class)));
                            } catch (Throwable th7) {
                                kType2 = null;
                                TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass2, kType2);
                                ktorUploadTask$awaitResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitResult_IoAF18A_u24lambda_u2403);
                                ktorUploadTask$awaitResult$12.L$1 = SpillingKt.nullOutSpilledVariable(contentReader);
                                ktorUploadTask$awaitResult$12.L$2 = SpillingKt.nullOutSpilledVariable(result);
                                ktorUploadTask$awaitResult$12.L$3 = SpillingKt.nullOutSpilledVariable(ktorUploadTask$awaitResult$12);
                                ktorUploadTask$awaitResult$12.L$4 = SpillingKt.nullOutSpilledVariable(result);
                                ktorUploadTask$awaitResult$12.L$5 = null;
                                ktorUploadTask$awaitResult$12.L$6 = null;
                                ktorUploadTask$awaitResult$12.L$7 = null;
                                ktorUploadTask$awaitResult$12.L$8 = null;
                                ktorUploadTask$awaitResult$12.L$9 = null;
                                ktorUploadTask$awaitResult$12.I$0 = $i$f$request;
                                ktorUploadTask$awaitResult$12.I$1 = 0;
                                ktorUploadTask$awaitResult$12.label = 3;
                                bodyNullable = call.bodyNullable(typeInfo, ktorUploadTask$awaitResult$12);
                                if (bodyNullable == coroutine_suspended) {
                                }
                            }
                        } catch (Throwable th8) {
                        }
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType2);
                        ktorUploadTask$awaitResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitResult_IoAF18A_u24lambda_u2403);
                        ktorUploadTask$awaitResult$12.L$1 = SpillingKt.nullOutSpilledVariable(contentReader);
                        ktorUploadTask$awaitResult$12.L$2 = SpillingKt.nullOutSpilledVariable(result);
                        ktorUploadTask$awaitResult$12.L$3 = SpillingKt.nullOutSpilledVariable(ktorUploadTask$awaitResult$12);
                        ktorUploadTask$awaitResult$12.L$4 = SpillingKt.nullOutSpilledVariable(result);
                        ktorUploadTask$awaitResult$12.L$5 = null;
                        ktorUploadTask$awaitResult$12.L$6 = null;
                        ktorUploadTask$awaitResult$12.L$7 = null;
                        ktorUploadTask$awaitResult$12.L$8 = null;
                        ktorUploadTask$awaitResult$12.L$9 = null;
                        ktorUploadTask$awaitResult$12.I$0 = $i$f$request;
                        ktorUploadTask$awaitResult$12.I$1 = 0;
                        ktorUploadTask$awaitResult$12.label = 3;
                        bodyNullable = call.bodyNullable(typeInfo2, ktorUploadTask$awaitResult$12);
                        if (bodyNullable == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            Object asResult = KApiResponseKt.asResult((KApiResponse) bodyNullable);
                            ResultKt.throwOnFailure(asResult);
                            m2636constructorimpl = Result.m2636constructorimpl((ImageUploadResult) asResult);
                            if (Result.m2643isSuccessimpl(m2636constructorimpl)) {
                                ImageUploadResult it2 = (ImageUploadResult) m2636constructorimpl;
                                KLog_androidKt.getKLog().i(MossAssetUploaderImpl.TAG, "Succeed to upload asset " + getAsset().getIdentifier());
                                obj6 = obj5;
                                obj7 = obj4;
                                obj8 = obj3;
                                obj10 = obj2;
                                obj9 = obj;
                                KNeuron.INSTANCE.simpleTrackT(ASSET_UPLOADER_EVENT_SUCCESS, MapsKt.mapOf(new Pair[]{TuplesKt.to(obj6, this.contentUniqueId), TuplesKt.to(obj7, it2.getImageUrl()), TuplesKt.to(obj8, String.valueOf(it2.m2148getImageSizeQJZHGII())), TuplesKt.to(obj10, String.valueOf(it2.getImageWidth())), TuplesKt.to(obj9, String.valueOf(it2.getImageHeight())), TuplesKt.to("ai_gen_pic", String.valueOf(it2.getAiGenPic()))}));
                            } else {
                                obj6 = obj5;
                                obj7 = obj4;
                                obj8 = obj3;
                                obj9 = obj;
                                obj10 = obj2;
                            }
                            it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
                            if (it != null) {
                                JobKt.ensureActive(ktorUploadTask$awaitResult$12.getContext());
                                KLog_androidKt.getKLog().e(MossAssetUploaderImpl.TAG, "Fail to upload asset " + getAsset().getIdentifier(), it.getCause());
                                KNeuron kNeuron = KNeuron.INSTANCE;
                                Pair[] pairArr = new Pair[6];
                                String message = it.getMessage();
                                if (message == null) {
                                    message = "";
                                }
                                pairArr[0] = TuplesKt.to("error", message);
                                pairArr[1] = TuplesKt.to(obj6, this.contentUniqueId);
                                pairArr[2] = TuplesKt.to(obj7, getAsset().getIdentifier());
                                pairArr[3] = TuplesKt.to(obj8, ContentSize.m2193toStringimpl(mo2151getTaskContentSizeQJZHGII()));
                                pairArr[4] = TuplesKt.to(obj10, String.valueOf(getAsset().getResolution().getWidthPx()));
                                pairArr[5] = TuplesKt.to(obj9, String.valueOf(getAsset().getResolution().getHeightPx()));
                                kNeuron.simpleTrackT(ASSET_UPLOADER_EVENT_ERROR, MapsKt.mapOf(pairArr));
                            }
                            SendChannel.DefaultImpls.close$default(this.progressChannel, (Throwable) null, 1, (Object) null);
                            return m2636constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.common.paragraph.assetuploader.ImageUploadResult>");
                    case 1:
                        int i = ktorUploadTask$awaitResult$12.I$0;
                        KtorUploadTask $this$awaitResult_IoAF18A_u24lambda_u2404 = (KtorUploadTask) ktorUploadTask$awaitResult$12.L$0;
                        ResultKt.throwOnFailure($result);
                        $this$awaitResult_IoAF18A_u24lambda_u2402 = $this$awaitResult_IoAF18A_u24lambda_u2404;
                        $i$f$request = i;
                        obj11 = $result;
                        contentReader = (Source) obj11;
                        HttpClient $this$submitFormWithBinaryData$iv2 = $this$awaitResult_IoAF18A_u24lambda_u2402.client;
                        List formData$iv2 = FormDslKt.formData(new Function1() { // from class: kntr.common.paragraph.assetuploader.impl.KtorUploadTask$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj12) {
                                Unit awaitResult_IoAF18A$lambda$0$0;
                                awaitResult_IoAF18A$lambda$0$0 = KtorUploadTask.awaitResult_IoAF18A$lambda$0$0(KtorUploadTask.this, contentReader, (FormBuilder) obj12);
                                return awaitResult_IoAF18A$lambda$0$0;
                            }
                        });
                        obj = "height";
                        $this$submitFormWithBinaryData_u24lambda_u243$iv$iv = new HttpRequestBuilder();
                        obj2 = "width";
                        $this$submitFormWithBinaryData_u24lambda_u243$iv$iv.setMethod(HttpMethod.Companion.getPost());
                        body$iv$iv$iv = new MultiPartFormDataContent(formData$iv2, (String) null, (ContentType) null, 6, (DefaultConstructorMarker) null);
                        obj3 = "asset_size";
                        if (body$iv$iv$iv instanceof OutgoingContent) {
                        }
                        HttpRequestKt.url($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, "https://api.bilibili.com/x/dynamic/feed/draw/upload_bfs");
                        BodyProgressKt.onUpload($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, new ProgressListener() { // from class: kntr.common.paragraph.assetuploader.impl.KtorUploadTask$awaitResult$2$result$2$1
                            public final Object onProgress(long bytesSentTotal, Long l, Continuation<? super Unit> continuation2) {
                                Channel channel;
                                channel = KtorUploadTask.this.progressChannel;
                                Object send = channel.send(ContentSize.m2181boximpl(ContentSizeKt.bytes(Boxing.boxLong(bytesSentTotal))), continuation2);
                                return send == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                            }
                        });
                        HttpStatement httpStatement2 = new HttpStatement($this$submitFormWithBinaryData_u24lambda_u243$iv$iv, $this$submitFormWithBinaryData$iv2);
                        ktorUploadTask$awaitResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitResult_IoAF18A_u24lambda_u2402);
                        ktorUploadTask$awaitResult$12.L$1 = SpillingKt.nullOutSpilledVariable(contentReader);
                        ktorUploadTask$awaitResult$12.L$2 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv2);
                        ktorUploadTask$awaitResult$12.L$3 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/dynamic/feed/draw/upload_bfs");
                        ktorUploadTask$awaitResult$12.L$4 = SpillingKt.nullOutSpilledVariable(formData$iv2);
                        ktorUploadTask$awaitResult$12.L$5 = SpillingKt.nullOutSpilledVariable(ktorUploadTask$awaitResult$12);
                        ktorUploadTask$awaitResult$12.L$6 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv2);
                        ktorUploadTask$awaitResult$12.L$7 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv2);
                        ktorUploadTask$awaitResult$12.L$8 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData$iv2);
                        ktorUploadTask$awaitResult$12.L$9 = SpillingKt.nullOutSpilledVariable($this$submitFormWithBinaryData_u24lambda_u243$iv$iv);
                        ktorUploadTask$awaitResult$12.I$0 = $i$f$request;
                        ktorUploadTask$awaitResult$12.I$1 = 0;
                        ktorUploadTask$awaitResult$12.I$2 = 0;
                        ktorUploadTask$awaitResult$12.I$3 = 0;
                        ktorUploadTask$awaitResult$12.I$4 = 0;
                        ktorUploadTask$awaitResult$12.label = 2;
                        execute = httpStatement2.execute(ktorUploadTask$awaitResult$12);
                        if (execute != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int $i$f$body = ktorUploadTask$awaitResult$12.I$4;
                        int i2 = ktorUploadTask$awaitResult$12.I$3;
                        int i3 = ktorUploadTask$awaitResult$12.I$2;
                        int i4 = ktorUploadTask$awaitResult$12.I$1;
                        int i5 = ktorUploadTask$awaitResult$12.I$0;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) ktorUploadTask$awaitResult$12.L$9;
                        HttpClient httpClient = (HttpClient) ktorUploadTask$awaitResult$12.L$8;
                        HttpClient httpClient2 = (HttpClient) ktorUploadTask$awaitResult$12.L$7;
                        HttpClient httpClient3 = (HttpClient) ktorUploadTask$awaitResult$12.L$6;
                        KtorUploadTask$awaitResult$1 ktorUploadTask$awaitResult$13 = (KtorUploadTask$awaitResult$1) ktorUploadTask$awaitResult$12.L$5;
                        List list = (List) ktorUploadTask$awaitResult$12.L$4;
                        String str = (String) ktorUploadTask$awaitResult$12.L$3;
                        HttpClient httpClient4 = (HttpClient) ktorUploadTask$awaitResult$12.L$2;
                        Source contentReader2 = (Source) ktorUploadTask$awaitResult$12.L$1;
                        KtorUploadTask $this$awaitResult_IoAF18A_u24lambda_u2405 = (KtorUploadTask) ktorUploadTask$awaitResult$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = "height";
                        obj2 = "width";
                        $i$f$request = i5;
                        contentReader = contentReader2;
                        obj4 = "asset_path";
                        execute = $result;
                        $this$awaitResult_IoAF18A_u24lambda_u2403 = $this$awaitResult_IoAF18A_u24lambda_u2405;
                        obj5 = "asset_id";
                        obj3 = "asset_size";
                        HttpResponse result2 = (HttpResponse) execute;
                        HttpClientCall call2 = result2.getCall();
                        KClass orCreateKotlinClass22 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType2 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ImageUploadResult.class)));
                        TypeInfo typeInfo22 = new TypeInfo(orCreateKotlinClass22, kType2);
                        ktorUploadTask$awaitResult$12.L$0 = SpillingKt.nullOutSpilledVariable($this$awaitResult_IoAF18A_u24lambda_u2403);
                        ktorUploadTask$awaitResult$12.L$1 = SpillingKt.nullOutSpilledVariable(contentReader);
                        ktorUploadTask$awaitResult$12.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                        ktorUploadTask$awaitResult$12.L$3 = SpillingKt.nullOutSpilledVariable(ktorUploadTask$awaitResult$12);
                        ktorUploadTask$awaitResult$12.L$4 = SpillingKt.nullOutSpilledVariable(result2);
                        ktorUploadTask$awaitResult$12.L$5 = null;
                        ktorUploadTask$awaitResult$12.L$6 = null;
                        ktorUploadTask$awaitResult$12.L$7 = null;
                        ktorUploadTask$awaitResult$12.L$8 = null;
                        ktorUploadTask$awaitResult$12.L$9 = null;
                        ktorUploadTask$awaitResult$12.I$0 = $i$f$request;
                        ktorUploadTask$awaitResult$12.I$1 = 0;
                        ktorUploadTask$awaitResult$12.label = 3;
                        bodyNullable = call2.bodyNullable(typeInfo22, ktorUploadTask$awaitResult$12);
                        if (bodyNullable == coroutine_suspended) {
                        }
                        break;
                    case 3:
                        int i6 = ktorUploadTask$awaitResult$12.I$1;
                        int i7 = ktorUploadTask$awaitResult$12.I$0;
                        HttpResponse httpResponse = (HttpResponse) ktorUploadTask$awaitResult$12.L$4;
                        KtorUploadTask$awaitResult$1 ktorUploadTask$awaitResult$14 = (KtorUploadTask$awaitResult$1) ktorUploadTask$awaitResult$12.L$3;
                        HttpResponse httpResponse2 = (HttpResponse) ktorUploadTask$awaitResult$12.L$2;
                        Source source = (Source) ktorUploadTask$awaitResult$12.L$1;
                        KtorUploadTask ktorUploadTask = (KtorUploadTask) ktorUploadTask$awaitResult$12.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = "height";
                        obj2 = "width";
                        obj3 = "asset_size";
                        obj4 = "asset_path";
                        obj5 = "asset_id";
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        ktorUploadTask$awaitResult$1 = new KtorUploadTask$awaitResult$1(this, continuation);
        ktorUploadTask$awaitResult$12 = ktorUploadTask$awaitResult$1;
        Object $result2 = ktorUploadTask$awaitResult$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (ktorUploadTask$awaitResult$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitResult_IoAF18A$lambda$0$0(KtorUploadTask $this_runCatching, final Source $contentReader, FormBuilder $this$formData) {
        Intrinsics.checkNotNullParameter($this$formData, "$this$formData");
        HeadersBuilder textHeader = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        textHeader.set(HttpHeaders.INSTANCE.getContentType(), ContentType.Text.INSTANCE.getPlain() + "; charset=utf-8");
        $this$formData.append("biz", $this_runCatching.bucket, textHeader.build());
        $this$formData.append("pos", Integer.valueOf($this_runCatching.index), textHeader.build());
        $this$formData.append("is_live", false, textHeader.build());
        AssetUploaderWaterMark waterMark = $this_runCatching.params.getWaterMark();
        if (waterMark != null) {
            $this$formData.append("watermark", $this_runCatching.params.getWaterMark().getEnable() ? "1" : "0", textHeader.build());
            $this$formData.append("g", $this_runCatching.params.getWaterMark().getPosition().getParam(), textHeader.build());
            $this$formData.append("wm_text", $this_runCatching.params.getAccountName(), textHeader.build());
        }
        HeadersBuilder fileHeader = new HeadersBuilder(0, 1, (DefaultConstructorMarker) null);
        fileHeader.set(HttpHeaders.INSTANCE.getContentDisposition(), "filename=" + HeaderValueWithParametersKt.escapeIfNeeded(String.valueOf($this_runCatching.index)));
        $this$formData.append("file_up", new InputProvider((Long) null, new Function0() { // from class: kntr.common.paragraph.assetuploader.impl.KtorUploadTask$$ExternalSyntheticLambda1
            public final Object invoke() {
                Source awaitResult_IoAF18A$lambda$0$0$0;
                awaitResult_IoAF18A$lambda$0$0$0 = KtorUploadTask.awaitResult_IoAF18A$lambda$0$0$0($contentReader);
                return awaitResult_IoAF18A$lambda$0$0$0;
            }
        }, 1, (DefaultConstructorMarker) null), fileHeader.build());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source awaitResult_IoAF18A$lambda$0$0$0(Source $contentReader) {
        return $contentReader;
    }

    @Override // kntr.common.paragraph.assetuploader.UploadTask
    public Flow<ContentSize> getProgress() {
        return FlowKt.receiveAsFlow(this.progressChannel);
    }

    /* compiled from: MossAssetUploaderImpl.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/common/paragraph/assetuploader/impl/KtorUploadTask$Companion;", "", "<init>", "()V", "ASSET_UPLOADER_EVENT_START", "", "ASSET_UPLOADER_EVENT_ERROR", "ASSET_UPLOADER_EVENT_SUCCESS", "assetuploader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}