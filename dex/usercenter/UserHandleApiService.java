package usercenter;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KtorClientKt;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessageBuilder;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.content.NullBody;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import java.util.List;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import usercenter.UpdateHandleResult;
import usercenter.UserHandleApiService;

/* compiled from: UserHandleApiService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\n"}, d2 = {"Lusercenter/UserHandleApiService;", "", "<init>", "()V", "updateHandle", "Lusercenter/UpdateHandleResult;", "newHandle", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "UpdateHandleData", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UserHandleApiService {
    public static final int $stable = 0;
    public static final UserHandleApiService INSTANCE = new UserHandleApiService();

    /* compiled from: UserHandleApiService.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u0002./B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\t\u0010\nBG\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0016R\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lusercenter/UserHandleApiService$UpdateHandleData;", "", "code", "", "msg", "", "handle", "optionHandleList", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCode$annotations", "()V", "getCode", "()J", "getMsg$annotations", "getMsg", "()Ljava/lang/String;", "getHandle$annotations", "getHandle", "getOptionHandleList$annotations", "getOptionHandleList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$usercenter_debug", "$serializer", "Companion", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    @Serializable
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UpdateHandleData {
        private final long code;
        private final String handle;
        private final String msg;
        private final List<String> optionHandleList;
        public static final Companion Companion = new Companion(null);
        public static final int $stable = 8;
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: usercenter.UserHandleApiService$UpdateHandleData$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = UserHandleApiService.UpdateHandleData._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public UpdateHandleData() {
            this(0L, (String) null, (String) null, (List) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ UpdateHandleData copy$default(UpdateHandleData updateHandleData, long j, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = updateHandleData.code;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = updateHandleData.msg;
            }
            String str3 = str;
            if ((i & 4) != 0) {
                str2 = updateHandleData.handle;
            }
            String str4 = str2;
            List<String> list2 = list;
            if ((i & 8) != 0) {
                list2 = updateHandleData.optionHandleList;
            }
            return updateHandleData.copy(j2, str3, str4, list2);
        }

        @SerialName("code")
        public static /* synthetic */ void getCode$annotations() {
        }

        @SerialName("handle")
        public static /* synthetic */ void getHandle$annotations() {
        }

        @SerialName("msg")
        public static /* synthetic */ void getMsg$annotations() {
        }

        @SerialName("option_handle_list")
        public static /* synthetic */ void getOptionHandleList$annotations() {
        }

        public final long component1() {
            return this.code;
        }

        public final String component2() {
            return this.msg;
        }

        public final String component3() {
            return this.handle;
        }

        public final List<String> component4() {
            return this.optionHandleList;
        }

        public final UpdateHandleData copy(long j, String str, String str2, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "msg");
            Intrinsics.checkNotNullParameter(str2, "handle");
            Intrinsics.checkNotNullParameter(list, "optionHandleList");
            return new UpdateHandleData(j, str, str2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UpdateHandleData) {
                UpdateHandleData updateHandleData = (UpdateHandleData) obj;
                return this.code == updateHandleData.code && Intrinsics.areEqual(this.msg, updateHandleData.msg) && Intrinsics.areEqual(this.handle, updateHandleData.handle) && Intrinsics.areEqual(this.optionHandleList, updateHandleData.optionHandleList);
            }
            return false;
        }

        public int hashCode() {
            return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.code) * 31) + this.msg.hashCode()) * 31) + this.handle.hashCode()) * 31) + this.optionHandleList.hashCode();
        }

        public String toString() {
            long j = this.code;
            String str = this.msg;
            String str2 = this.handle;
            return "UpdateHandleData(code=" + j + ", msg=" + str + ", handle=" + str2 + ", optionHandleList=" + this.optionHandleList + ")";
        }

        /* compiled from: UserHandleApiService.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lusercenter/UserHandleApiService$UpdateHandleData$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lusercenter/UserHandleApiService$UpdateHandleData;", "usercenter_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<UpdateHandleData> serializer() {
                return new GeneratedSerializer<UpdateHandleData>() { // from class: usercenter.UserHandleApiService$UpdateHandleData$$serializer
                    public static final int $stable;
                    private static final SerialDescriptor descriptor;

                    public final SerialDescriptor getDescriptor() {
                        return descriptor;
                    }

                    static {
                        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("usercenter.UserHandleApiService.UpdateHandleData", 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                              (wrap: kotlinx.serialization.KSerializer<usercenter.UserHandleApiService$UpdateHandleData> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<usercenter.UserHandleApiService$UpdateHandleData> A[REMOVE]) =  usercenter.UserHandleApiService$UpdateHandleData$$serializer.INSTANCE usercenter.UserHandleApiService$UpdateHandleData$$serializer)
                             in method: usercenter.UserHandleApiService.UpdateHandleData.Companion.serializer():kotlinx.serialization.KSerializer<usercenter.UserHandleApiService$UpdateHandleData>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                              ("usercenter.UserHandleApiService.UpdateHandleData")
                              (wrap: usercenter.UserHandleApiService$UpdateHandleData$$serializer : 0x0009: SGET  (r1v0 usercenter.UserHandleApiService$UpdateHandleData$$serializer A[REMOVE]) =  usercenter.UserHandleApiService$UpdateHandleData$$serializer.INSTANCE usercenter.UserHandleApiService$UpdateHandleData$$serializer)
                              (4 int)
                             call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: usercenter.UserHandleApiService$UpdateHandleData$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: usercenter.UserHandleApiService$UpdateHandleData$$serializer
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
                            usercenter.UserHandleApiService$UpdateHandleData$$serializer r0 = usercenter.UserHandleApiService$UpdateHandleData$$serializer.INSTANCE
                            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: usercenter.UserHandleApiService.UpdateHandleData.Companion.serializer():kotlinx.serialization.KSerializer");
                    }
                }

                public /* synthetic */ UpdateHandleData(int seen0, long code, String msg, String handle, List optionHandleList, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.code = 0L;
                    } else {
                        this.code = code;
                    }
                    if ((seen0 & 2) == 0) {
                        this.msg = "";
                    } else {
                        this.msg = msg;
                    }
                    if ((seen0 & 4) == 0) {
                        this.handle = "";
                    } else {
                        this.handle = handle;
                    }
                    if ((seen0 & 8) == 0) {
                        this.optionHandleList = CollectionsKt.emptyList();
                    } else {
                        this.optionHandleList = optionHandleList;
                    }
                }

                public UpdateHandleData(long code, String msg, String handle, List<String> list) {
                    Intrinsics.checkNotNullParameter(msg, "msg");
                    Intrinsics.checkNotNullParameter(handle, "handle");
                    Intrinsics.checkNotNullParameter(list, "optionHandleList");
                    this.code = code;
                    this.msg = msg;
                    this.handle = handle;
                    this.optionHandleList = list;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(StringSerializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$usercenter_debug(UpdateHandleData self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.code != 0) {
                        output.encodeLongElement(serialDesc, 0, self.code);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.msg, "")) {
                        output.encodeStringElement(serialDesc, 1, self.msg);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.handle, "")) {
                        output.encodeStringElement(serialDesc, 2, self.handle);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.optionHandleList, CollectionsKt.emptyList())) {
                        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.optionHandleList);
                    }
                }

                public /* synthetic */ UpdateHandleData(long j, String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
                }

                public final long getCode() {
                    return this.code;
                }

                public final String getMsg() {
                    return this.msg;
                }

                public final String getHandle() {
                    return this.handle;
                }

                public final List<String> getOptionHandleList() {
                    return this.optionHandleList;
                }
            }

            private UserHandleApiService() {
            }

            /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
            /* JADX WARN: Removed duplicated region for block: B:22:0x008c  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x01e6 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:61:0x01e7  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x01ea A[Catch: Exception -> 0x0322, TRY_LEAVE, TryCatch #7 {Exception -> 0x0322, blocks: (B:63:0x01ea, B:66:0x01f5, B:68:0x0208, B:69:0x0275, B:70:0x0298, B:72:0x029c, B:73:0x02ec, B:75:0x02f0, B:77:0x0314, B:78:0x0319, B:79:0x031a, B:80:0x0321, B:51:0x0193, B:58:0x01bb), top: B:103:0x0193 }] */
            /* JADX WARN: Removed duplicated region for block: B:79:0x031a A[Catch: Exception -> 0x0322, TryCatch #7 {Exception -> 0x0322, blocks: (B:63:0x01ea, B:66:0x01f5, B:68:0x0208, B:69:0x0275, B:70:0x0298, B:72:0x029c, B:73:0x02ec, B:75:0x02f0, B:77:0x0314, B:78:0x0319, B:79:0x031a, B:80:0x0321, B:51:0x0193, B:58:0x01bb), top: B:103:0x0193 }] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object updateHandle(String newHandle, Continuation<? super UpdateHandleResult> continuation) {
                UserHandleApiService$updateHandle$1 userHandleApiService$updateHandle$1;
                UserHandleApiService$updateHandle$1 userHandleApiService$updateHandle$12;
                HttpClient $this$post$iv;
                HttpMessageBuilder httpRequestBuilder;
                ParametersBuilder $this$updateHandle_u24lambda_u240_u240;
                KType kType;
                Object execute;
                String newHandle2;
                KType kType2;
                KType kType3;
                Object bodyNullable;
                if (continuation instanceof UserHandleApiService$updateHandle$1) {
                    userHandleApiService$updateHandle$1 = (UserHandleApiService$updateHandle$1) continuation;
                    if ((userHandleApiService$updateHandle$1.label & Integer.MIN_VALUE) != 0) {
                        userHandleApiService$updateHandle$1.label -= Integer.MIN_VALUE;
                        userHandleApiService$updateHandle$12 = userHandleApiService$updateHandle$1;
                        Object $result = userHandleApiService$updateHandle$12.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (userHandleApiService$updateHandle$12.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                try {
                                    $this$post$iv = KtorClientKt.getKtorHttpClient();
                                    httpRequestBuilder = new HttpRequestBuilder();
                                    HttpRequestKt.url(httpRequestBuilder, "https://api.bilibili.com/x/member/handle/update");
                                    HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getFormUrlEncoded());
                                    Parameters.Companion companion = Parameters.Companion;
                                    $this$updateHandle_u24lambda_u240_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
                                } catch (Exception e) {
                                    e = e;
                                }
                                try {
                                    $this$updateHandle_u24lambda_u240_u240.append("handle", newHandle);
                                    Object body$iv = HttpUrlEncodedKt.formUrlEncode($this$updateHandle_u24lambda_u240_u240.build());
                                    if (body$iv == null) {
                                        httpRequestBuilder.setBody(NullBody.INSTANCE);
                                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                                        try {
                                            kType2 = Reflection.typeOf(String.class);
                                        } catch (Throwable th) {
                                            kType2 = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass, kType2));
                                    } else if (body$iv instanceof OutgoingContent) {
                                        httpRequestBuilder.setBody(body$iv);
                                        httpRequestBuilder.setBodyType((TypeInfo) null);
                                    } else {
                                        httpRequestBuilder.setBody(body$iv);
                                        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                                        try {
                                            kType = Reflection.typeOf(String.class);
                                        } catch (Throwable th2) {
                                            kType = null;
                                        }
                                        httpRequestBuilder.setBodyType(new TypeInfo(orCreateKotlinClass2, kType));
                                    }
                                    httpRequestBuilder.setMethod(HttpMethod.Companion.getPost());
                                    HttpStatement httpStatement = new HttpStatement(httpRequestBuilder, $this$post$iv);
                                    userHandleApiService$updateHandle$12.L$0 = SpillingKt.nullOutSpilledVariable(newHandle);
                                    userHandleApiService$updateHandle$12.L$1 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    userHandleApiService$updateHandle$12.L$2 = SpillingKt.nullOutSpilledVariable("https://api.bilibili.com/x/member/handle/update");
                                    userHandleApiService$updateHandle$12.L$3 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    userHandleApiService$updateHandle$12.L$4 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    userHandleApiService$updateHandle$12.L$5 = SpillingKt.nullOutSpilledVariable(httpRequestBuilder);
                                    userHandleApiService$updateHandle$12.L$6 = SpillingKt.nullOutSpilledVariable($this$post$iv);
                                    userHandleApiService$updateHandle$12.I$0 = 0;
                                    userHandleApiService$updateHandle$12.I$1 = 0;
                                    userHandleApiService$updateHandle$12.I$2 = 0;
                                    userHandleApiService$updateHandle$12.I$3 = 0;
                                    userHandleApiService$updateHandle$12.label = 1;
                                    execute = httpStatement.execute(userHandleApiService$updateHandle$12);
                                    if (execute == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    newHandle2 = newHandle;
                                    try {
                                        HttpResponse httpResponse = (HttpResponse) execute;
                                        HttpClientCall call = httpResponse.getCall();
                                        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                        try {
                                            kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UpdateHandleData.class)));
                                        } catch (Throwable th3) {
                                            kType3 = null;
                                        }
                                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass3, kType3);
                                        userHandleApiService$updateHandle$12.L$0 = SpillingKt.nullOutSpilledVariable(newHandle2);
                                        userHandleApiService$updateHandle$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        userHandleApiService$updateHandle$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse);
                                        userHandleApiService$updateHandle$12.L$3 = null;
                                        userHandleApiService$updateHandle$12.L$4 = null;
                                        userHandleApiService$updateHandle$12.L$5 = null;
                                        userHandleApiService$updateHandle$12.L$6 = null;
                                        userHandleApiService$updateHandle$12.I$0 = 0;
                                        userHandleApiService$updateHandle$12.label = 2;
                                        bodyNullable = call.bodyNullable(typeInfo, userHandleApiService$updateHandle$12);
                                        if (bodyNullable != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        if (bodyNullable == null) {
                                            KApiResponse.Success success = (KApiResponse) bodyNullable;
                                            if (success instanceof KApiResponse.Success) {
                                                if (((UpdateHandleData) success.getData()).getCode() != 0) {
                                                    KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle business failure: " + ((UpdateHandleData) success.getData()).getCode() + ", " + ((UpdateHandleData) success.getData()).getMsg());
                                                    return new UpdateHandleResult.Failure(((UpdateHandleData) success.getData()).getCode(), ((UpdateHandleData) success.getData()).getMsg(), ((UpdateHandleData) success.getData()).getOptionHandleList());
                                                }
                                                return new UpdateHandleResult.Success(((UpdateHandleData) success.getData()).getHandle(), ((UpdateHandleData) success.getData()).getMsg());
                                            } else if (!(success instanceof KApiResponse.BusinessFailure)) {
                                                if (success instanceof KApiResponse.ServiceUnavailable) {
                                                    KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle service error", ((KApiResponse.ServiceUnavailable) success).getException());
                                                    return new UpdateHandleResult.Failure(-1L, "", null, 4, null);
                                                }
                                                throw new NoWhenBranchMatchedException();
                                            } else {
                                                KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle error: " + ((KApiResponse.BusinessFailure) success).getCode() + ", " + ((KApiResponse.BusinessFailure) success).getMessage());
                                                return new UpdateHandleResult.Failure(((KApiResponse.BusinessFailure) success).getCode(), String.valueOf(((KApiResponse.BusinessFailure) success).getMessage()), null, 4, null);
                                            }
                                        }
                                        throw new NullPointerException("null cannot be cast to non-null type com.bilibili.ktor.KApiResponse<usercenter.UserHandleApiService.UpdateHandleData>");
                                    } catch (Exception e2) {
                                        e = e2;
                                        KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle http failed", e);
                                        return new UpdateHandleResult.Failure(-1L, "", null, 4, null);
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle http failed", e);
                                    return new UpdateHandleResult.Failure(-1L, "", null, 4, null);
                                }
                            case 1:
                                int i = userHandleApiService$updateHandle$12.I$3;
                                int i2 = userHandleApiService$updateHandle$12.I$2;
                                int i3 = userHandleApiService$updateHandle$12.I$1;
                                int i4 = userHandleApiService$updateHandle$12.I$0;
                                HttpClient httpClient = (HttpClient) userHandleApiService$updateHandle$12.L$6;
                                HttpRequestBuilder httpRequestBuilder2 = (HttpRequestBuilder) userHandleApiService$updateHandle$12.L$5;
                                HttpClient httpClient2 = (HttpClient) userHandleApiService$updateHandle$12.L$4;
                                HttpClient httpClient3 = (HttpClient) userHandleApiService$updateHandle$12.L$3;
                                String str = (String) userHandleApiService$updateHandle$12.L$2;
                                HttpClient httpClient4 = (HttpClient) userHandleApiService$updateHandle$12.L$1;
                                newHandle2 = (String) userHandleApiService$updateHandle$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    execute = $result;
                                    HttpResponse httpResponse2 = (HttpResponse) execute;
                                    HttpClientCall call2 = httpResponse2.getCall();
                                    KClass orCreateKotlinClass32 = Reflection.getOrCreateKotlinClass(KApiResponse.class);
                                    kType3 = Reflection.typeOf(KApiResponse.class, KTypeProjection.Companion.invariant(Reflection.typeOf(UpdateHandleData.class)));
                                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass32, kType3);
                                    userHandleApiService$updateHandle$12.L$0 = SpillingKt.nullOutSpilledVariable(newHandle2);
                                    userHandleApiService$updateHandle$12.L$1 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                                    userHandleApiService$updateHandle$12.L$2 = SpillingKt.nullOutSpilledVariable(httpResponse2);
                                    userHandleApiService$updateHandle$12.L$3 = null;
                                    userHandleApiService$updateHandle$12.L$4 = null;
                                    userHandleApiService$updateHandle$12.L$5 = null;
                                    userHandleApiService$updateHandle$12.L$6 = null;
                                    userHandleApiService$updateHandle$12.I$0 = 0;
                                    userHandleApiService$updateHandle$12.label = 2;
                                    bodyNullable = call2.bodyNullable(typeInfo2, userHandleApiService$updateHandle$12);
                                    if (bodyNullable != coroutine_suspended) {
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle http failed", e);
                                    return new UpdateHandleResult.Failure(-1L, "", null, 4, null);
                                }
                                break;
                            case 2:
                                int i5 = userHandleApiService$updateHandle$12.I$0;
                                HttpResponse httpResponse3 = (HttpResponse) userHandleApiService$updateHandle$12.L$2;
                                HttpResponse httpResponse4 = (HttpResponse) userHandleApiService$updateHandle$12.L$1;
                                String str2 = (String) userHandleApiService$updateHandle$12.L$0;
                                try {
                                    ResultKt.throwOnFailure($result);
                                    bodyNullable = $result;
                                    if (bodyNullable == null) {
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    KLog_androidKt.getKLog().e("UserHandleApiService", "Request updateHandle http failed", e);
                                    return new UpdateHandleResult.Failure(-1L, "", null, 4, null);
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }
                userHandleApiService$updateHandle$1 = new UserHandleApiService$updateHandle$1(this, continuation);
                userHandleApiService$updateHandle$12 = userHandleApiService$updateHandle$1;
                Object $result2 = userHandleApiService$updateHandle$12.result;
                Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (userHandleApiService$updateHandle$12.label) {
                }
            }
        }