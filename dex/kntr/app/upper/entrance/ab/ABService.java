package kntr.app.upper.entrance.ab;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLProtocol;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.ab.ABService;
import kntr.base.net.comm.imp.InitHttpsWorldKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ABService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/upper/entrance/ab/ABService;", "", "<init>", "()V", "client", "Lio/ktor/client/HttpClient;", "getABData", "", "", "keys", "", "mid", "abExtra", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ABData", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ABService {
    public static final ABService INSTANCE = new ABService();
    private static final HttpClient client = KtorClientKt.getKtorHttpClient();

    private ABService() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01fb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getABData(List<String> list, String mid, String abExtra, Continuation<? super Map<String, String>> continuation) {
        ABService$getABData$1 aBService$getABData$1;
        ABService$getABData$1 aBService$getABData$12;
        String abExtra2;
        List<String> list2;
        String mid2;
        Url url;
        KType kType;
        Object bodyNullable;
        if (continuation instanceof ABService$getABData$1) {
            aBService$getABData$1 = (ABService$getABData$1) continuation;
            if ((aBService$getABData$1.label & Integer.MIN_VALUE) != 0) {
                aBService$getABData$1.label -= Integer.MIN_VALUE;
                aBService$getABData$12 = aBService$getABData$1;
                Object $result = aBService$getABData$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (aBService$getABData$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        URLProtocol https = URLProtocol.Companion.getHTTPS();
                        Parameters.Companion companion = Parameters.Companion;
                        ParametersBuilder $this$getABData_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                        $this$getABData_u24lambda_u240.append("ab_variables", CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                        $this$getABData_u24lambda_u240.append("mid", mid);
                        abExtra2 = abExtra;
                        $this$getABData_u24lambda_u240.append("ab_extra", abExtra2);
                        Unit unit = Unit.INSTANCE;
                        URLBuilder $this$getABData_u24lambda_u241 = new URLBuilder(https, InitHttpsWorldKt.HOST_MEMBER_BILIBILI_COM, 0, (String) null, (String) null, (List) null, $this$getABData_u24lambda_u240.build(), (String) null, false, 444, (DefaultConstructorMarker) null);
                        URLBuilderKt.setEncodedPath($this$getABData_u24lambda_u241, "/x/creative-tool/common/abtest");
                        Url url2 = $this$getABData_u24lambda_u241.build();
                        HttpClient $this$get_u24default$iv = client;
                        HttpRequestBuilder $this$get_u24lambda_u240$iv = new HttpRequestBuilder();
                        URLUtilsKt.takeFrom($this$get_u24lambda_u240$iv.getUrl(), url2);
                        $this$get_u24lambda_u240$iv.setMethod(HttpMethod.Companion.getGet());
                        HttpStatement httpStatement = new HttpStatement($this$get_u24lambda_u240$iv, $this$get_u24default$iv);
                        aBService$getABData$12.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        aBService$getABData$12.L$1 = SpillingKt.nullOutSpilledVariable(mid);
                        aBService$getABData$12.L$2 = SpillingKt.nullOutSpilledVariable(abExtra);
                        aBService$getABData$12.L$3 = SpillingKt.nullOutSpilledVariable(url2);
                        aBService$getABData$12.L$4 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        aBService$getABData$12.L$5 = SpillingKt.nullOutSpilledVariable(url2);
                        aBService$getABData$12.L$6 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        aBService$getABData$12.L$7 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        aBService$getABData$12.L$8 = SpillingKt.nullOutSpilledVariable($this$get_u24lambda_u240$iv);
                        aBService$getABData$12.L$9 = SpillingKt.nullOutSpilledVariable($this$get_u24default$iv);
                        aBService$getABData$12.I$0 = 0;
                        aBService$getABData$12.I$1 = 0;
                        aBService$getABData$12.I$2 = 0;
                        aBService$getABData$12.I$3 = 0;
                        aBService$getABData$12.label = 1;
                        $result = httpStatement.execute(aBService$getABData$12);
                        if ($result == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list2 = list;
                        mid2 = mid;
                        url = url2;
                        HttpResponse httpResponse = (HttpResponse) $result;
                        HttpClientCall call = httpResponse.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        try {
                            kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ABData.class)));
                        } catch (Throwable th) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        aBService$getABData$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        aBService$getABData$12.L$1 = SpillingKt.nullOutSpilledVariable(mid2);
                        aBService$getABData$12.L$2 = SpillingKt.nullOutSpilledVariable(abExtra2);
                        aBService$getABData$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                        aBService$getABData$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        aBService$getABData$12.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse);
                        aBService$getABData$12.L$6 = null;
                        aBService$getABData$12.L$7 = null;
                        aBService$getABData$12.L$8 = null;
                        aBService$getABData$12.L$9 = null;
                        aBService$getABData$12.I$0 = 0;
                        aBService$getABData$12.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, aBService$getABData$12);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        if (bodyNullable == null) {
                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                            if (success instanceof KApiResponse.Success) {
                                Map<String, String> abTestMap = ((ABData) success.getData()).getAbTestMap();
                                return abTestMap == null ? MapsKt.emptyMap() : abTestMap;
                            } else if (success instanceof KApiResponse.BusinessFailure) {
                                throw new Throwable("KResponse.Failure(" + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage() + ")");
                            } else if (success instanceof KApiResponse.ServiceUnavailable) {
                                throw new Throwable("KResponse.Unavailable(" + ((KApiResponse.ServiceUnavailable) success).getException().getMessage() + ")");
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<kntr.app.upper.entrance.ab.ABService.ABData>");
                    case 1:
                        int $i$f$body = aBService$getABData$12.I$3;
                        int i = aBService$getABData$12.I$2;
                        int i2 = aBService$getABData$12.I$1;
                        int i3 = aBService$getABData$12.I$0;
                        HttpClient httpClient = (HttpClient) aBService$getABData$12.L$9;
                        HttpRequestBuilder httpRequestBuilder = (HttpRequestBuilder) aBService$getABData$12.L$8;
                        HttpClient httpClient2 = (HttpClient) aBService$getABData$12.L$7;
                        HttpClient httpClient3 = (HttpClient) aBService$getABData$12.L$6;
                        Url url3 = (Url) aBService$getABData$12.L$5;
                        HttpClient httpClient4 = (HttpClient) aBService$getABData$12.L$4;
                        String abExtra3 = (String) aBService$getABData$12.L$2;
                        String mid3 = (String) aBService$getABData$12.L$1;
                        ResultKt.throwOnFailure($result);
                        mid2 = mid3;
                        list2 = (List) aBService$getABData$12.L$0;
                        url = (Url) aBService$getABData$12.L$3;
                        abExtra2 = abExtra3;
                        HttpResponse httpResponse2 = (HttpResponse) $result;
                        HttpClientCall call2 = httpResponse2.getCall();
                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                        kType = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(ABData.class)));
                        TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                        aBService$getABData$12.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                        aBService$getABData$12.L$1 = SpillingKt.nullOutSpilledVariable(mid2);
                        aBService$getABData$12.L$2 = SpillingKt.nullOutSpilledVariable(abExtra2);
                        aBService$getABData$12.L$3 = SpillingKt.nullOutSpilledVariable(url);
                        aBService$getABData$12.L$4 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        aBService$getABData$12.L$5 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                        aBService$getABData$12.L$6 = null;
                        aBService$getABData$12.L$7 = null;
                        aBService$getABData$12.L$8 = null;
                        aBService$getABData$12.L$9 = null;
                        aBService$getABData$12.I$0 = 0;
                        aBService$getABData$12.label = 2;
                        bodyNullable = call2.bodyNullable(typeInfo2, aBService$getABData$12);
                        if (bodyNullable != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        int i4 = aBService$getABData$12.I$0;
                        HttpResponse httpResponse3 = (HttpResponse) aBService$getABData$12.L$5;
                        HttpResponse httpResponse4 = (HttpResponse) aBService$getABData$12.L$4;
                        Url url4 = (Url) aBService$getABData$12.L$3;
                        String str = (String) aBService$getABData$12.L$2;
                        String str2 = (String) aBService$getABData$12.L$1;
                        List list3 = (List) aBService$getABData$12.L$0;
                        ResultKt.throwOnFailure($result);
                        bodyNullable = $result;
                        if (bodyNullable == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        aBService$getABData$1 = new ABService$getABData$1(this, continuation);
        aBService$getABData$12 = aBService$getABData$1;
        Object $result2 = aBService$getABData$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (aBService$getABData$12.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ABService.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0002\u0010\u000bJ%\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\b\u0018R2\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lkntr/app/upper/entrance/ab/ABService$ABData;", "", "<init>", "()V", "seen0", "", "abTestMap", "", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAbTestMap$annotations", "getAbTestMap", "()Ljava/util/Map;", "setAbTestMap", "(Ljava/util/Map;)V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ABData {
        private Map<String, String> abTestMap;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.ab.ABService$ABData$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = ABService.ABData._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        @SerialName("ab_test_map")
        public static /* synthetic */ void getAbTestMap$annotations() {
        }

        /* compiled from: ABService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/ab/ABService$ABData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/ab/ABService$ABData;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<ABData> serializer() {
                return new GeneratedSerializer<ABData>() { // from class: kntr.app.upper.entrance.ab.ABService$ABData$$serializer
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.ab.ABService.ABData", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<kntr.app.upper.entrance.ab.ABService$ABData> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.upper.entrance.ab.ABService$ABData> A[REMOVE]) =  kntr.app.upper.entrance.ab.ABService$ABData$$serializer.INSTANCE kntr.app.upper.entrance.ab.ABService$ABData$$serializer)
                             in method: kntr.app.upper.entrance.ab.ABService.ABData.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.upper.entrance.ab.ABService$ABData>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.util.ArrayList.forEach(ArrayList.java:1257)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:390)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method generation error
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:309)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0011: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                              ("kntr.app.upper.entrance.ab.ABService.ABData")
                              (wrap: kntr.app.upper.entrance.ab.ABService$ABData$$serializer : 0x0009: SGET  (r1v0 kntr.app.upper.entrance.ab.ABService$ABData$$serializer A[REMOVE]) =  kntr.app.upper.entrance.ab.ABService$ABData$$serializer.INSTANCE kntr.app.upper.entrance.ab.ABService$ABData$$serializer)
                              (1 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.upper.entrance.ab.ABService$ABData$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                            	... 5 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.upper.entrance.ab.ABService$ABData$$serializer
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:775)
                            	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:765)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                            	... 15 more
                            */
                        /*
                            this = this;
                            kntr.app.upper.entrance.ab.ABService$ABData$$serializer r0 = kntr.app.upper.entrance.ab.ABService$ABData$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kntr.app.upper.entrance.ab.ABService.ABData.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public ABData() {
                }

                public /* synthetic */ ABData(int seen0, Map abTestMap, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.abTestMap = null;
                    } else {
                        this.abTestMap = abTestMap;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$entrance_debug(ABData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    boolean z = true;
                    if (!output.shouldEncodeElementDefault(serialDesc, 0) && self.abTestMap == null) {
                        z = false;
                    }
                    if (z) {
                        output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.abTestMap);
                    }
                }

                public final Map<String, String> getAbTestMap() {
                    return this.abTestMap;
                }

                public final void setAbTestMap(Map<String, String> map) {
                    this.abTestMap = map;
                }
            }
        }