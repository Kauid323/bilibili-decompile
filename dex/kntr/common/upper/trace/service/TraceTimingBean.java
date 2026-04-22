package kntr.common.upper.trace.service;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: TraceTimingBean.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002-.B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0010¨\u0006/"}, d2 = {"Lkntr/common/upper/trace/service/TraceTimingBean;", "", "t1", "", "t2", "maxDeviationThreshold", "retryInterval", "maxRetryCount", "<init>", "(JJJJJ)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJJJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getT1", "()J", "getT2", "getMaxDeviationThreshold$annotations", "()V", "getMaxDeviationThreshold", "getRetryInterval$annotations", "getRetryInterval", "getMaxRetryCount$annotations", "getMaxRetryCount", "toString", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$trace_core_debug", "$serializer", "Companion", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class TraceTimingBean {
    public static final Companion Companion = new Companion(null);
    private final long maxDeviationThreshold;
    private final long maxRetryCount;
    private final long retryInterval;
    private final long t1;
    private final long t2;

    public TraceTimingBean() {
        this(0L, 0L, 0L, 0L, 0L, 31, (DefaultConstructorMarker) null);
    }

    @SerialName("acceptable_clock_max_error_ms")
    public static /* synthetic */ void getMaxDeviationThreshold$annotations() {
    }

    @SerialName("max_retry_count")
    public static /* synthetic */ void getMaxRetryCount$annotations() {
    }

    @SerialName("retry_interval_ms")
    public static /* synthetic */ void getRetryInterval$annotations() {
    }

    public final long component1() {
        return this.t1;
    }

    public final long component2() {
        return this.t2;
    }

    public final long component3() {
        return this.maxDeviationThreshold;
    }

    public final long component4() {
        return this.retryInterval;
    }

    public final long component5() {
        return this.maxRetryCount;
    }

    public final TraceTimingBean copy(long j, long j2, long j3, long j4, long j5) {
        return new TraceTimingBean(j, j2, j3, j4, j5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TraceTimingBean) {
            TraceTimingBean traceTimingBean = (TraceTimingBean) obj;
            return this.t1 == traceTimingBean.t1 && this.t2 == traceTimingBean.t2 && this.maxDeviationThreshold == traceTimingBean.maxDeviationThreshold && this.retryInterval == traceTimingBean.retryInterval && this.maxRetryCount == traceTimingBean.maxRetryCount;
        }
        return false;
    }

    public int hashCode() {
        return (((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.t1) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.t2)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.maxDeviationThreshold)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.retryInterval)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.maxRetryCount);
    }

    /* compiled from: TraceTimingBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/upper/trace/service/TraceTimingBean$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/upper/trace/service/TraceTimingBean;", "trace-core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TraceTimingBean> serializer() {
            return new GeneratedSerializer<TraceTimingBean>() { // from class: kntr.common.upper.trace.service.TraceTimingBean$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.upper.trace.service.TraceTimingBean", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.common.upper.trace.service.TraceTimingBean> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.common.upper.trace.service.TraceTimingBean> A[REMOVE]) =  kntr.common.upper.trace.service.TraceTimingBean$$serializer.INSTANCE kntr.common.upper.trace.service.TraceTimingBean$$serializer)
                         in method: kntr.common.upper.trace.service.TraceTimingBean.Companion.serializer():kotlinx.serialization.KSerializer<kntr.common.upper.trace.service.TraceTimingBean>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.common.upper.trace.service.TraceTimingBean")
                          (wrap: kntr.common.upper.trace.service.TraceTimingBean$$serializer : 0x0009: SGET  (r1v0 kntr.common.upper.trace.service.TraceTimingBean$$serializer A[REMOVE]) =  kntr.common.upper.trace.service.TraceTimingBean$$serializer.INSTANCE kntr.common.upper.trace.service.TraceTimingBean$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.common.upper.trace.service.TraceTimingBean$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.common.upper.trace.service.TraceTimingBean$$serializer
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
                        kntr.common.upper.trace.service.TraceTimingBean$$serializer r0 = kntr.common.upper.trace.service.TraceTimingBean$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.common.upper.trace.service.TraceTimingBean.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ TraceTimingBean(int seen0, long t1, long t2, long maxDeviationThreshold, long retryInterval, long maxRetryCount, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.t1 = 0L;
                } else {
                    this.t1 = t1;
                }
                if ((seen0 & 2) == 0) {
                    this.t2 = 0L;
                } else {
                    this.t2 = t2;
                }
                if ((seen0 & 4) == 0) {
                    this.maxDeviationThreshold = 0L;
                } else {
                    this.maxDeviationThreshold = maxDeviationThreshold;
                }
                if ((seen0 & 8) == 0) {
                    this.retryInterval = 0L;
                } else {
                    this.retryInterval = retryInterval;
                }
                if ((seen0 & 16) == 0) {
                    this.maxRetryCount = 0L;
                } else {
                    this.maxRetryCount = maxRetryCount;
                }
            }

            public TraceTimingBean(long t1, long t2, long maxDeviationThreshold, long retryInterval, long maxRetryCount) {
                this.t1 = t1;
                this.t2 = t2;
                this.maxDeviationThreshold = maxDeviationThreshold;
                this.retryInterval = retryInterval;
                this.maxRetryCount = maxRetryCount;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$trace_core_debug(TraceTimingBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.t1 != 0) {
                    output.encodeLongElement(serialDesc, 0, self.t1);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.t2 != 0) {
                    output.encodeLongElement(serialDesc, 1, self.t2);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.maxDeviationThreshold != 0) {
                    output.encodeLongElement(serialDesc, 2, self.maxDeviationThreshold);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.retryInterval != 0) {
                    output.encodeLongElement(serialDesc, 3, self.retryInterval);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.maxRetryCount != 0) {
                    output.encodeLongElement(serialDesc, 4, self.maxRetryCount);
                }
            }

            public /* synthetic */ TraceTimingBean(long j, long j2, long j3, long j4, long j5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, (i & 16) == 0 ? j5 : 0L);
            }

            public final long getT1() {
                return this.t1;
            }

            public final long getT2() {
                return this.t2;
            }

            public final long getMaxDeviationThreshold() {
                return this.maxDeviationThreshold;
            }

            public final long getRetryInterval() {
                return this.retryInterval;
            }

            public final long getMaxRetryCount() {
                return this.maxRetryCount;
            }

            public String toString() {
                long j = this.t1;
                long j2 = this.t2;
                long j3 = this.maxDeviationThreshold;
                long j4 = this.retryInterval;
                return "TraceTimingBean(t1=" + j + ", t2=" + j2 + ", maxDeviationThreshold=" + j3 + ", retryInterval=" + j4 + ", maxRetryCount=" + this.maxRetryCount + ")";
            }
        }