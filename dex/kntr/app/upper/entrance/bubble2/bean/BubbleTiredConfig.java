package kntr.app.upper.entrance.bubble2.bean;

import java.util.ArrayList;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: BubbleTiredConfig.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 M2\u00020\u0001:\u0002LMB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0085\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\n\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0002\u0010\u0018J\b\u0010B\u001a\u00020CH\u0016J%\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0001¢\u0006\u0002\bKR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R*\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R$\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R$\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R$\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R$\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R$\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R,\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010%\"\u0004\bA\u0010'¨\u0006N"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleTiredConfig;", "", "<init>", "()V", "seen0", "", "bubbleAvailableTime", "", "bubbleNullDataPeriod", "bubbleFansShow", "", "Lkntr/app/upper/entrance/bubble2/bean/FansShow;", "bubbleShowTimesDay", "bubbleResourceShow", "Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;", "bubbleTextShowDay", "bubbleTextShowTimes", "exposureTextDay", "exposureTextShowTimes", "cacheAvailableDay", "limitTimes", "Lkntr/app/upper/entrance/bubble2/bean/LimitTime;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILjava/util/List;ILkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;IIIIILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBubbleAvailableTime$annotations", "getBubbleAvailableTime", "()J", "setBubbleAvailableTime", "(J)V", "getBubbleNullDataPeriod$annotations", "getBubbleNullDataPeriod", "()I", "setBubbleNullDataPeriod", "(I)V", "getBubbleFansShow$annotations", "getBubbleFansShow", "()Ljava/util/List;", "setBubbleFansShow", "(Ljava/util/List;)V", "getBubbleShowTimesDay$annotations", "getBubbleShowTimesDay", "setBubbleShowTimesDay", "getBubbleResourceShow$annotations", "getBubbleResourceShow", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;", "setBubbleResourceShow", "(Lkntr/app/upper/entrance/bubble2/bean/BubbleResourceShow;)V", "getBubbleTextShowDay$annotations", "getBubbleTextShowDay", "setBubbleTextShowDay", "getBubbleTextShowTimes$annotations", "getBubbleTextShowTimes", "setBubbleTextShowTimes", "getExposureTextDay$annotations", "getExposureTextDay", "setExposureTextDay", "getExposureTextShowTimes$annotations", "getExposureTextShowTimes", "setExposureTextShowTimes", "getCacheAvailableDay$annotations", "getCacheAvailableDay", "setCacheAvailableDay", "getLimitTimes$annotations", "getLimitTimes", "setLimitTimes", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BubbleTiredConfig {
    private long bubbleAvailableTime;
    private List<FansShow> bubbleFansShow;
    private int bubbleNullDataPeriod;
    private BubbleResourceShow bubbleResourceShow;
    private int bubbleShowTimesDay;
    private int bubbleTextShowDay;
    private int bubbleTextShowTimes;
    private int cacheAvailableDay;
    private int exposureTextDay;
    private int exposureTextShowTimes;
    private List<LimitTime> limitTimes;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = BubbleTiredConfig._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = BubbleTiredConfig._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    })};

    @SerialName("bubble_available_time")
    public static /* synthetic */ void getBubbleAvailableTime$annotations() {
    }

    @SerialName("bubble_fans_show")
    public static /* synthetic */ void getBubbleFansShow$annotations() {
    }

    @SerialName("bubble_null_data_period")
    public static /* synthetic */ void getBubbleNullDataPeriod$annotations() {
    }

    @SerialName("bubble_resource_show")
    public static /* synthetic */ void getBubbleResourceShow$annotations() {
    }

    @SerialName("bubble_show_times_day")
    public static /* synthetic */ void getBubbleShowTimesDay$annotations() {
    }

    @SerialName("bubble_text_show_day")
    public static /* synthetic */ void getBubbleTextShowDay$annotations() {
    }

    @SerialName("bubble_text_show_times")
    public static /* synthetic */ void getBubbleTextShowTimes$annotations() {
    }

    @SerialName("cache_available_day")
    public static /* synthetic */ void getCacheAvailableDay$annotations() {
    }

    @SerialName("exposure_text_day")
    public static /* synthetic */ void getExposureTextDay$annotations() {
    }

    @SerialName("exposure_text_show_times")
    public static /* synthetic */ void getExposureTextShowTimes$annotations() {
    }

    @SerialName("req_limit_times")
    public static /* synthetic */ void getLimitTimes$annotations() {
    }

    /* compiled from: BubbleTiredConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleTiredConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleTiredConfig;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BubbleTiredConfig> serializer() {
            return new GeneratedSerializer<BubbleTiredConfig>() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig> A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer)
                         in method: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig")
                          (wrap: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer : 0x0009: SGET  (r1v0 kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer)
                          (11 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer
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
                        kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer r0 = kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.upper.entrance.bubble2.bean.BubbleTiredConfig.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public BubbleTiredConfig() {
                this.bubbleAvailableTime = 30L;
                this.bubbleNullDataPeriod = 1;
                this.bubbleFansShow = new ArrayList();
                this.bubbleShowTimesDay = 1;
                this.bubbleResourceShow = new BubbleResourceShow();
                this.bubbleTextShowDay = 30;
                this.bubbleTextShowTimes = 1;
                this.exposureTextDay = 7;
                this.exposureTextShowTimes = 1;
                this.cacheAvailableDay = 30;
            }

            public /* synthetic */ BubbleTiredConfig(int seen0, long bubbleAvailableTime, int bubbleNullDataPeriod, List bubbleFansShow, int bubbleShowTimesDay, BubbleResourceShow bubbleResourceShow, int bubbleTextShowDay, int bubbleTextShowTimes, int exposureTextDay, int exposureTextShowTimes, int cacheAvailableDay, List limitTimes, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.bubbleAvailableTime = 30L;
                } else {
                    this.bubbleAvailableTime = bubbleAvailableTime;
                }
                if ((seen0 & 2) == 0) {
                    this.bubbleNullDataPeriod = 1;
                } else {
                    this.bubbleNullDataPeriod = bubbleNullDataPeriod;
                }
                if ((seen0 & 4) == 0) {
                    this.bubbleFansShow = new ArrayList();
                } else {
                    this.bubbleFansShow = bubbleFansShow;
                }
                if ((seen0 & 8) == 0) {
                    this.bubbleShowTimesDay = 1;
                } else {
                    this.bubbleShowTimesDay = bubbleShowTimesDay;
                }
                if ((seen0 & 16) == 0) {
                    this.bubbleResourceShow = new BubbleResourceShow();
                } else {
                    this.bubbleResourceShow = bubbleResourceShow;
                }
                if ((seen0 & 32) == 0) {
                    this.bubbleTextShowDay = 30;
                } else {
                    this.bubbleTextShowDay = bubbleTextShowDay;
                }
                if ((seen0 & 64) == 0) {
                    this.bubbleTextShowTimes = 1;
                } else {
                    this.bubbleTextShowTimes = bubbleTextShowTimes;
                }
                if ((seen0 & 128) == 0) {
                    this.exposureTextDay = 7;
                } else {
                    this.exposureTextDay = exposureTextDay;
                }
                if ((seen0 & 256) == 0) {
                    this.exposureTextShowTimes = 1;
                } else {
                    this.exposureTextShowTimes = exposureTextShowTimes;
                }
                if ((seen0 & 512) == 0) {
                    this.cacheAvailableDay = 30;
                } else {
                    this.cacheAvailableDay = cacheAvailableDay;
                }
                if ((seen0 & 1024) == 0) {
                    this.limitTimes = null;
                } else {
                    this.limitTimes = limitTimes;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(FansShow$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(LimitTime$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$entrance_debug(BubbleTiredConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bubbleAvailableTime != 30) {
                    output.encodeLongElement(serialDesc, 0, self.bubbleAvailableTime);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.bubbleNullDataPeriod != 1) {
                    output.encodeIntElement(serialDesc, 1, self.bubbleNullDataPeriod);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.bubbleFansShow, new ArrayList())) {
                    output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.bubbleFansShow);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bubbleShowTimesDay != 1) {
                    output.encodeIntElement(serialDesc, 3, self.bubbleShowTimesDay);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.bubbleResourceShow, new BubbleResourceShow())) {
                    output.encodeSerializableElement(serialDesc, 4, BubbleResourceShow$$serializer.INSTANCE, self.bubbleResourceShow);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.bubbleTextShowDay != 30) {
                    output.encodeIntElement(serialDesc, 5, self.bubbleTextShowDay);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.bubbleTextShowTimes != 1) {
                    output.encodeIntElement(serialDesc, 6, self.bubbleTextShowTimes);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.exposureTextDay != 7) {
                    output.encodeIntElement(serialDesc, 7, self.exposureTextDay);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.exposureTextShowTimes != 1) {
                    output.encodeIntElement(serialDesc, 8, self.exposureTextShowTimes);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.cacheAvailableDay != 30) {
                    output.encodeIntElement(serialDesc, 9, self.cacheAvailableDay);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.limitTimes != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, lazyArr[10].getValue(), self.limitTimes);
                }
            }

            public final long getBubbleAvailableTime() {
                return this.bubbleAvailableTime;
            }

            public final void setBubbleAvailableTime(long j) {
                this.bubbleAvailableTime = j;
            }

            public final int getBubbleNullDataPeriod() {
                return this.bubbleNullDataPeriod;
            }

            public final void setBubbleNullDataPeriod(int i) {
                this.bubbleNullDataPeriod = i;
            }

            public final List<FansShow> getBubbleFansShow() {
                return this.bubbleFansShow;
            }

            public final void setBubbleFansShow(List<FansShow> list) {
                Intrinsics.checkNotNullParameter(list, "<set-?>");
                this.bubbleFansShow = list;
            }

            public final int getBubbleShowTimesDay() {
                return this.bubbleShowTimesDay;
            }

            public final void setBubbleShowTimesDay(int i) {
                this.bubbleShowTimesDay = i;
            }

            public final BubbleResourceShow getBubbleResourceShow() {
                return this.bubbleResourceShow;
            }

            public final void setBubbleResourceShow(BubbleResourceShow bubbleResourceShow) {
                Intrinsics.checkNotNullParameter(bubbleResourceShow, "<set-?>");
                this.bubbleResourceShow = bubbleResourceShow;
            }

            public final int getBubbleTextShowDay() {
                return this.bubbleTextShowDay;
            }

            public final void setBubbleTextShowDay(int i) {
                this.bubbleTextShowDay = i;
            }

            public final int getBubbleTextShowTimes() {
                return this.bubbleTextShowTimes;
            }

            public final void setBubbleTextShowTimes(int i) {
                this.bubbleTextShowTimes = i;
            }

            public final int getExposureTextDay() {
                return this.exposureTextDay;
            }

            public final void setExposureTextDay(int i) {
                this.exposureTextDay = i;
            }

            public final int getExposureTextShowTimes() {
                return this.exposureTextShowTimes;
            }

            public final void setExposureTextShowTimes(int i) {
                this.exposureTextShowTimes = i;
            }

            public final int getCacheAvailableDay() {
                return this.cacheAvailableDay;
            }

            public final void setCacheAvailableDay(int i) {
                this.cacheAvailableDay = i;
            }

            public final List<LimitTime> getLimitTimes() {
                return this.limitTimes;
            }

            public final void setLimitTimes(List<LimitTime> list) {
                this.limitTimes = list;
            }

            public String toString() {
                long j = this.bubbleAvailableTime;
                int i = this.bubbleNullDataPeriod;
                List<FansShow> list = this.bubbleFansShow;
                int i2 = this.bubbleShowTimesDay;
                BubbleResourceShow bubbleResourceShow = this.bubbleResourceShow;
                int i3 = this.bubbleTextShowDay;
                int i4 = this.bubbleTextShowTimes;
                int i5 = this.exposureTextDay;
                int i6 = this.exposureTextShowTimes;
                int i7 = this.cacheAvailableDay;
                return "BubbleTiredConfig(bubbleAvailableTime=" + j + ", bubbleNullDataPeriod=" + i + ", bubbleFansShow=" + list + ", bubbleShowTimesDay=" + i2 + ", bubbleResourceShow=" + bubbleResourceShow + ", bubbleTextShowDay=" + i3 + ", bubbleTextShowTimes=" + i4 + ", exposureTextDay=" + i5 + ", exposureTextShowTimes=" + i6 + ", cacheAvailableDay=" + i7 + ", limitTimes=" + this.limitTimes + ")";
            }
        }