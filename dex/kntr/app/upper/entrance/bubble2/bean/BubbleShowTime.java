package kntr.app.upper.entrance.bubble2.bean;

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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BubbleShowTime.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 J2\u00020\u0001:\u0002IJB\u0007¢\u0006\u0004\b\u0002\u0010\u0003Bq\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0002\u0010\u0016J\u0006\u00107\u001a\u00020\u0012J\b\u0010@\u001a\u00020\nH\u0016J%\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0001¢\u0006\u0002\bHR$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R&\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R$\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u0010\u0003\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R$\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b8\u0010\u0003\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u0010:\"\u0004\b?\u0010<¨\u0006K"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleShowTime;", "", "<init>", "()V", "seen0", "", "timestamp", "", "fans", "resourceId", "", "bubbleId", "bubbleTextId", "bubbleInterestScore", "", "bubbleHotScore", "force", "existData", "", "expire", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;FFIZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimestamp$annotations", "getTimestamp", "()J", "setTimestamp", "(J)V", "getFans$annotations", "getFans", "setFans", "getResourceId$annotations", "getResourceId", "()Ljava/lang/String;", "setResourceId", "(Ljava/lang/String;)V", "getBubbleId$annotations", "getBubbleId", "setBubbleId", "getBubbleTextId$annotations", "getBubbleTextId", "setBubbleTextId", "getBubbleInterestScore$annotations", "getBubbleInterestScore", "()F", "setBubbleInterestScore", "(F)V", "getBubbleHotScore$annotations", "getBubbleHotScore", "setBubbleHotScore", "getForce$annotations", "getForce", "()I", "setForce", "(I)V", "forceValue", "getExistData$annotations", "getExistData", "()Z", "setExistData", "(Z)V", "getExpire$annotations", "getExpire", "setExpire", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BubbleShowTime {
    public static final Companion Companion = new Companion(null);
    private float bubbleHotScore;
    private String bubbleId;
    private float bubbleInterestScore;
    private String bubbleTextId;
    private boolean existData;
    private boolean expire;
    private long fans;
    private int force;
    private String resourceId;
    private long timestamp;

    @SerialName("hot_score")
    public static /* synthetic */ void getBubbleHotScore$annotations() {
    }

    @SerialName("bubbleId")
    public static /* synthetic */ void getBubbleId$annotations() {
    }

    @SerialName("bubbleInterestScore")
    public static /* synthetic */ void getBubbleInterestScore$annotations() {
    }

    @SerialName("bubbleTextId")
    public static /* synthetic */ void getBubbleTextId$annotations() {
    }

    @SerialName("existData")
    public static /* synthetic */ void getExistData$annotations() {
    }

    @SerialName("expire")
    public static /* synthetic */ void getExpire$annotations() {
    }

    @SerialName("fans")
    public static /* synthetic */ void getFans$annotations() {
    }

    @SerialName("is_force")
    public static /* synthetic */ void getForce$annotations() {
    }

    @SerialName("resourceId")
    public static /* synthetic */ void getResourceId$annotations() {
    }

    @SerialName("timestamp")
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    /* compiled from: BubbleShowTime.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleShowTime$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleShowTime;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BubbleShowTime> serializer() {
            return new GeneratedSerializer<BubbleShowTime>() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.BubbleShowTime", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleShowTime> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleShowTime> A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer)
                         in method: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleShowTime>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.upper.entrance.bubble2.bean.BubbleShowTime")
                          (wrap: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer : 0x0009: SGET  (r1v0 kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer)
                          (10 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer
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
                        kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer r0 = kntr.app.upper.entrance.bubble2.bean.BubbleShowTime$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.upper.entrance.bubble2.bean.BubbleShowTime.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public BubbleShowTime() {
            }

            public /* synthetic */ BubbleShowTime(int seen0, long timestamp, long fans, String resourceId, String bubbleId, String bubbleTextId, float bubbleInterestScore, float bubbleHotScore, int force, boolean existData, boolean expire, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.timestamp = 0L;
                } else {
                    this.timestamp = timestamp;
                }
                if ((seen0 & 2) == 0) {
                    this.fans = 0L;
                } else {
                    this.fans = fans;
                }
                if ((seen0 & 4) == 0) {
                    this.resourceId = null;
                } else {
                    this.resourceId = resourceId;
                }
                if ((seen0 & 8) == 0) {
                    this.bubbleId = null;
                } else {
                    this.bubbleId = bubbleId;
                }
                if ((seen0 & 16) == 0) {
                    this.bubbleTextId = null;
                } else {
                    this.bubbleTextId = bubbleTextId;
                }
                if ((seen0 & 32) == 0) {
                    this.bubbleInterestScore = 0.0f;
                } else {
                    this.bubbleInterestScore = bubbleInterestScore;
                }
                if ((seen0 & 64) == 0) {
                    this.bubbleHotScore = 0.0f;
                } else {
                    this.bubbleHotScore = bubbleHotScore;
                }
                if ((seen0 & 128) == 0) {
                    this.force = 0;
                } else {
                    this.force = force;
                }
                if ((seen0 & 256) == 0) {
                    this.existData = false;
                } else {
                    this.existData = existData;
                }
                if ((seen0 & 512) == 0) {
                    this.expire = false;
                } else {
                    this.expire = expire;
                }
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$entrance_debug(BubbleShowTime self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.timestamp != 0) {
                    output.encodeLongElement(serialDesc, 0, self.timestamp);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.fans != 0) {
                    output.encodeLongElement(serialDesc, 1, self.fans);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.resourceId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.resourceId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.bubbleId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.bubbleId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.bubbleTextId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.bubbleTextId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || Float.compare(self.bubbleInterestScore, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 5, self.bubbleInterestScore);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || Float.compare(self.bubbleHotScore, 0.0f) != 0) {
                    output.encodeFloatElement(serialDesc, 6, self.bubbleHotScore);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.force != 0) {
                    output.encodeIntElement(serialDesc, 7, self.force);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.existData) {
                    output.encodeBooleanElement(serialDesc, 8, self.existData);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.expire) {
                    output.encodeBooleanElement(serialDesc, 9, self.expire);
                }
            }

            public final long getTimestamp() {
                return this.timestamp;
            }

            public final void setTimestamp(long j) {
                this.timestamp = j;
            }

            public final long getFans() {
                return this.fans;
            }

            public final void setFans(long j) {
                this.fans = j;
            }

            public final String getResourceId() {
                return this.resourceId;
            }

            public final void setResourceId(String str) {
                this.resourceId = str;
            }

            public final String getBubbleId() {
                return this.bubbleId;
            }

            public final void setBubbleId(String str) {
                this.bubbleId = str;
            }

            public final String getBubbleTextId() {
                return this.bubbleTextId;
            }

            public final void setBubbleTextId(String str) {
                this.bubbleTextId = str;
            }

            public final float getBubbleInterestScore() {
                return this.bubbleInterestScore;
            }

            public final void setBubbleInterestScore(float f) {
                this.bubbleInterestScore = f;
            }

            public final float getBubbleHotScore() {
                return this.bubbleHotScore;
            }

            public final void setBubbleHotScore(float f) {
                this.bubbleHotScore = f;
            }

            public final int getForce() {
                return this.force;
            }

            public final void setForce(int i) {
                this.force = i;
            }

            public final boolean forceValue() {
                return this.force == 1;
            }

            public final boolean getExistData() {
                return this.existData;
            }

            public final void setExistData(boolean z) {
                this.existData = z;
            }

            public final boolean getExpire() {
                return this.expire;
            }

            public final void setExpire(boolean z) {
                this.expire = z;
            }

            public String toString() {
                long j = this.timestamp;
                long j2 = this.fans;
                String str = this.resourceId;
                String str2 = this.bubbleId;
                String str3 = this.bubbleTextId;
                float f = this.bubbleInterestScore;
                float f2 = this.bubbleHotScore;
                boolean z = this.existData;
                return "BubbleShowTime(timestamp=" + j + ", fans=" + j2 + ", resourceId=" + str + ", bubbleId=" + str2 + ", bubbleTextId=" + str3 + ", bubbleInterestScore=" + f + ", bubbleHotScore=" + f2 + ", existData=" + z + ", expire=" + this.expire + ")";
            }
        }