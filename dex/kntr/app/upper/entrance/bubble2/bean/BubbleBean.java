package kntr.app.upper.entrance.bubble2.bean;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble2.bean.BubbleBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BubbleBean.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u0006,-./01B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BC\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0002\u0010\u000fJ\b\u0010\"\u001a\u00020#H\u0016J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R$\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R,\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u0003\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u00062"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "", "<init>", "()V", "seen0", "", "recommend", "resourceList", "", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "zeroTs", "", "fans", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/List;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRecommend$annotations", "getRecommend", "()I", "setRecommend", "(I)V", "getResourceList$annotations", "getResourceList", "()Ljava/util/List;", "setResourceList", "(Ljava/util/List;)V", "getZeroTs$annotations", "getZeroTs", "()J", "setZeroTs", "(J)V", "getFans$annotations", "getFans", "setFans", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "Resource", "Bubble", "Text", "VersionFilter", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class BubbleBean {
    private long fans;
    private int recommend;
    private List<Resource> resourceList;
    private long zeroTs;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleBean$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = BubbleBean._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};

    @SerialName("fans")
    public static /* synthetic */ void getFans$annotations() {
    }

    @SerialName("recommend")
    public static /* synthetic */ void getRecommend$annotations() {
    }

    @SerialName("resource_list")
    public static /* synthetic */ void getResourceList$annotations() {
    }

    @SerialName("zero_ts")
    public static /* synthetic */ void getZeroTs$annotations() {
    }

    /* compiled from: BubbleBean.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BubbleBean> serializer() {
            return new GeneratedSerializer<BubbleBean>() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.BubbleBean", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleBean> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleBean> A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer)
                         in method: kntr.app.upper.entrance.bubble2.bean.BubbleBean.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.upper.entrance.bubble2.bean.BubbleBean>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.upper.entrance.bubble2.bean.BubbleBean")
                          (wrap: kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer : 0x0009: SGET  (r1v0 kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer A[REMOVE]) =  kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer.INSTANCE kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer
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
                        kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer r0 = kntr.app.upper.entrance.bubble2.bean.BubbleBean$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.upper.entrance.bubble2.bean.BubbleBean.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public BubbleBean() {
            }

            public /* synthetic */ BubbleBean(int seen0, int recommend, List resourceList, long zeroTs, long fans, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.recommend = 0;
                } else {
                    this.recommend = recommend;
                }
                if ((seen0 & 2) == 0) {
                    this.resourceList = null;
                } else {
                    this.resourceList = resourceList;
                }
                if ((seen0 & 4) == 0) {
                    this.zeroTs = 0L;
                } else {
                    this.zeroTs = zeroTs;
                }
                if ((seen0 & 8) == 0) {
                    this.fans = 0L;
                } else {
                    this.fans = fans;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(BubbleBean$Resource$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$entrance_debug(BubbleBean self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.recommend != 0) {
                    output.encodeIntElement(serialDesc, 0, self.recommend);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.resourceList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.resourceList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.zeroTs != 0) {
                    output.encodeLongElement(serialDesc, 2, self.zeroTs);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.fans != 0) {
                    output.encodeLongElement(serialDesc, 3, self.fans);
                }
            }

            public final int getRecommend() {
                return this.recommend;
            }

            public final void setRecommend(int i) {
                this.recommend = i;
            }

            public final List<Resource> getResourceList() {
                return this.resourceList;
            }

            public final void setResourceList(List<Resource> list) {
                this.resourceList = list;
            }

            public final long getZeroTs() {
                return this.zeroTs;
            }

            public final void setZeroTs(long j) {
                this.zeroTs = j;
            }

            /* compiled from: BubbleBean.kt */
            @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 k2\u00020\u0001:\u0002jkB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B½\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0005\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u0002\u0010\u001eJ\u0006\u0010_\u001a\u00020`J\b\u0010a\u001a\u00020\u0007H\u0016J%\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0001¢\u0006\u0002\biR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0003\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R&\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R&\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0003\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R$\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0003\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010\u0003\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b=\u0010\u0003\u001a\u0004\b>\u00107\"\u0004\b?\u00109R&\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010\u0003\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R&\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bC\u0010\u0003\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#R&\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bK\u0010\u0003\u001a\u0004\bL\u00107\"\u0004\bM\u00109R&\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010\u0003\u001a\u0004\bO\u0010!\"\u0004\bP\u0010#R&\u0010\u0017\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bQ\u0010\u0003\u001a\u0004\bR\u0010!\"\u0004\bS\u0010#R$\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bT\u0010\u0003\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bY\u0010\u0003\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR$\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\\\u0010\u0003\u001a\u0004\b]\u00107\"\u0004\b^\u00109¨\u0006l"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "", "<init>", "()V", "seen0", "", "strategyId", "", "strategyName", "crowdId", "experimentId", "startTime", "", "endTime", "weight", "pool", "location", "resourceId", "operateTopicId", "bubble", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;", "status", "creator", "resourceName", "interestScore", "", "hotScore", "force", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIIILjava/lang/String;Ljava/lang/String;Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;ILjava/lang/String;Ljava/lang/String;FFILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getStrategyId$annotations", "getStrategyId", "()Ljava/lang/String;", "setStrategyId", "(Ljava/lang/String;)V", "getStrategyName$annotations", "getStrategyName", "setStrategyName", "getCrowdId$annotations", "getCrowdId", "setCrowdId", "getExperimentId$annotations", "getExperimentId", "setExperimentId", "getStartTime$annotations", "getStartTime", "()J", "setStartTime", "(J)V", "getEndTime$annotations", "getEndTime", "setEndTime", "getWeight$annotations", "getWeight", "()I", "setWeight", "(I)V", "getPool$annotations", "getPool", "setPool", "getLocation$annotations", "getLocation", "setLocation", "getResourceId$annotations", "getResourceId", "setResourceId", "getOperateTopicId$annotations", "getOperateTopicId", "setOperateTopicId", "getBubble$annotations", "getBubble", "()Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;", "setBubble", "(Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;)V", "getStatus$annotations", "getStatus", "setStatus", "getCreator$annotations", "getCreator", "setCreator", "getResourceName$annotations", "getResourceName", "setResourceName", "getInterestScore$annotations", "getInterestScore", "()F", "setInterestScore", "(F)V", "getHotScore$annotations", "getHotScore", "setHotScore", "getForce$annotations", "getForce", "setForce", "forceValue", "", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Resource {
                public static final Companion Companion = new Companion(null);
                private Bubble bubble;
                private String creator;
                private String crowdId;
                private long endTime;
                private String experimentId;
                private int force;
                private float hotScore;
                private float interestScore;
                private int location;
                private String operateTopicId;
                private int pool;
                private String resourceId;
                private String resourceName;
                private long startTime;
                private int status;
                private String strategyId;
                private String strategyName;
                private int weight;

                @SerialName("bubble")
                public static /* synthetic */ void getBubble$annotations() {
                }

                @SerialName("creator")
                public static /* synthetic */ void getCreator$annotations() {
                }

                @SerialName("crowd_id")
                public static /* synthetic */ void getCrowdId$annotations() {
                }

                @SerialName("end_time")
                public static /* synthetic */ void getEndTime$annotations() {
                }

                @SerialName("experiment_id")
                public static /* synthetic */ void getExperimentId$annotations() {
                }

                @SerialName("is_force")
                public static /* synthetic */ void getForce$annotations() {
                }

                @SerialName("hot_score")
                public static /* synthetic */ void getHotScore$annotations() {
                }

                @SerialName("interest_score")
                public static /* synthetic */ void getInterestScore$annotations() {
                }

                @SerialName("location")
                public static /* synthetic */ void getLocation$annotations() {
                }

                @SerialName("operate_topic_id")
                public static /* synthetic */ void getOperateTopicId$annotations() {
                }

                @SerialName("pool")
                public static /* synthetic */ void getPool$annotations() {
                }

                @SerialName("resource_id")
                public static /* synthetic */ void getResourceId$annotations() {
                }

                @SerialName("resource_name")
                public static /* synthetic */ void getResourceName$annotations() {
                }

                @SerialName("start_time")
                public static /* synthetic */ void getStartTime$annotations() {
                }

                @SerialName("status")
                public static /* synthetic */ void getStatus$annotations() {
                }

                @SerialName("strategy_id")
                public static /* synthetic */ void getStrategyId$annotations() {
                }

                @SerialName("strategy_name")
                public static /* synthetic */ void getStrategyName$annotations() {
                }

                @SerialName("weight")
                public static /* synthetic */ void getWeight$annotations() {
                }

                /* compiled from: BubbleBean.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Resource> serializer() {
                        return BubbleBean$Resource$$serializer.INSTANCE;
                    }
                }

                public Resource() {
                }

                public /* synthetic */ Resource(int seen0, String strategyId, String strategyName, String crowdId, String experimentId, long startTime, long endTime, int weight, int pool, int location, String resourceId, String operateTopicId, Bubble bubble, int status, String creator, String resourceName, float interestScore, float hotScore, int force, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.strategyId = null;
                    } else {
                        this.strategyId = strategyId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.strategyName = null;
                    } else {
                        this.strategyName = strategyName;
                    }
                    if ((seen0 & 4) == 0) {
                        this.crowdId = null;
                    } else {
                        this.crowdId = crowdId;
                    }
                    if ((seen0 & 8) == 0) {
                        this.experimentId = null;
                    } else {
                        this.experimentId = experimentId;
                    }
                    if ((seen0 & 16) == 0) {
                        this.startTime = 0L;
                    } else {
                        this.startTime = startTime;
                    }
                    if ((seen0 & 32) == 0) {
                        this.endTime = 0L;
                    } else {
                        this.endTime = endTime;
                    }
                    if ((seen0 & 64) == 0) {
                        this.weight = 0;
                    } else {
                        this.weight = weight;
                    }
                    if ((seen0 & 128) == 0) {
                        this.pool = 0;
                    } else {
                        this.pool = pool;
                    }
                    if ((seen0 & 256) == 0) {
                        this.location = 0;
                    } else {
                        this.location = location;
                    }
                    if ((seen0 & 512) == 0) {
                        this.resourceId = null;
                    } else {
                        this.resourceId = resourceId;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.operateTopicId = null;
                    } else {
                        this.operateTopicId = operateTopicId;
                    }
                    if ((seen0 & 2048) == 0) {
                        this.bubble = null;
                    } else {
                        this.bubble = bubble;
                    }
                    if ((seen0 & 4096) == 0) {
                        this.status = 0;
                    } else {
                        this.status = status;
                    }
                    if ((seen0 & 8192) == 0) {
                        this.creator = null;
                    } else {
                        this.creator = creator;
                    }
                    if ((seen0 & 16384) == 0) {
                        this.resourceName = null;
                    } else {
                        this.resourceName = resourceName;
                    }
                    if ((seen0 & 32768) == 0) {
                        this.interestScore = 0.0f;
                    } else {
                        this.interestScore = interestScore;
                    }
                    if ((seen0 & 65536) == 0) {
                        this.hotScore = 0.0f;
                    } else {
                        this.hotScore = hotScore;
                    }
                    if ((seen0 & 131072) == 0) {
                        this.force = 0;
                    } else {
                        this.force = force;
                    }
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$entrance_debug(Resource self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.strategyId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.strategyId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.strategyName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.strategyName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.crowdId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.crowdId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.experimentId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.experimentId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.startTime != 0) {
                        output.encodeLongElement(serialDesc, 4, self.startTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.endTime != 0) {
                        output.encodeLongElement(serialDesc, 5, self.endTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.weight != 0) {
                        output.encodeIntElement(serialDesc, 6, self.weight);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.pool != 0) {
                        output.encodeIntElement(serialDesc, 7, self.pool);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.location != 0) {
                        output.encodeIntElement(serialDesc, 8, self.location);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.resourceId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.resourceId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.operateTopicId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.operateTopicId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 11) || self.bubble != null) {
                        output.encodeNullableSerializableElement(serialDesc, 11, BubbleBean$Bubble$$serializer.INSTANCE, self.bubble);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 12) || self.status != 0) {
                        output.encodeIntElement(serialDesc, 12, self.status);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 13) || self.creator != null) {
                        output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.creator);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 14) || self.resourceName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.resourceName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 15) || Float.compare(self.interestScore, 0.0f) != 0) {
                        output.encodeFloatElement(serialDesc, 15, self.interestScore);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 16) || Float.compare(self.hotScore, 0.0f) != 0) {
                        output.encodeFloatElement(serialDesc, 16, self.hotScore);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 17) || self.force != 0) {
                        output.encodeIntElement(serialDesc, 17, self.force);
                    }
                }

                public final String getStrategyId() {
                    return this.strategyId;
                }

                public final void setStrategyId(String str) {
                    this.strategyId = str;
                }

                public final String getStrategyName() {
                    return this.strategyName;
                }

                public final void setStrategyName(String str) {
                    this.strategyName = str;
                }

                public final String getCrowdId() {
                    return this.crowdId;
                }

                public final void setCrowdId(String str) {
                    this.crowdId = str;
                }

                public final String getExperimentId() {
                    return this.experimentId;
                }

                public final void setExperimentId(String str) {
                    this.experimentId = str;
                }

                public final long getStartTime() {
                    return this.startTime;
                }

                public final void setStartTime(long j) {
                    this.startTime = j;
                }

                public final long getEndTime() {
                    return this.endTime;
                }

                public final void setEndTime(long j) {
                    this.endTime = j;
                }

                public final int getWeight() {
                    return this.weight;
                }

                public final void setWeight(int i) {
                    this.weight = i;
                }

                public final int getPool() {
                    return this.pool;
                }

                public final void setPool(int i) {
                    this.pool = i;
                }

                public final int getLocation() {
                    return this.location;
                }

                public final void setLocation(int i) {
                    this.location = i;
                }

                public final String getResourceId() {
                    return this.resourceId;
                }

                public final void setResourceId(String str) {
                    this.resourceId = str;
                }

                public final String getOperateTopicId() {
                    return this.operateTopicId;
                }

                public final void setOperateTopicId(String str) {
                    this.operateTopicId = str;
                }

                public final Bubble getBubble() {
                    return this.bubble;
                }

                public final void setBubble(Bubble bubble) {
                    this.bubble = bubble;
                }

                public final int getStatus() {
                    return this.status;
                }

                public final void setStatus(int i) {
                    this.status = i;
                }

                public final String getCreator() {
                    return this.creator;
                }

                public final void setCreator(String str) {
                    this.creator = str;
                }

                public final String getResourceName() {
                    return this.resourceName;
                }

                public final void setResourceName(String str) {
                    this.resourceName = str;
                }

                public final float getInterestScore() {
                    return this.interestScore;
                }

                public final void setInterestScore(float f) {
                    this.interestScore = f;
                }

                public final float getHotScore() {
                    return this.hotScore;
                }

                public final void setHotScore(float f) {
                    this.hotScore = f;
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

                public String toString() {
                    String str = this.strategyId;
                    String str2 = this.strategyName;
                    String str3 = this.crowdId;
                    String str4 = this.experimentId;
                    long j = this.startTime;
                    long j2 = this.endTime;
                    int i = this.weight;
                    int i2 = this.pool;
                    int i3 = this.location;
                    String str5 = this.resourceId;
                    String str6 = this.operateTopicId;
                    Bubble bubble = this.bubble;
                    int i4 = this.status;
                    String str7 = this.creator;
                    String str8 = this.resourceName;
                    float f = this.interestScore;
                    return "Resource(strategyId=" + str + ", strategyName=" + str2 + ", crowdId=" + str3 + ", experimentId=" + str4 + ", startTime=" + j + ", endTime=" + j2 + ", weight=" + i + ", pool=" + i2 + ", location=" + i3 + ", resourceId=" + str5 + ", operateTopicId=" + str6 + ", bubble=" + bubble + ", status=" + i4 + ", creator=" + str7 + ", resourceName=" + str8 + ", interestScore=" + f + ", hotScore=" + this.hotScore + ")";
                }
            }

            public final long getFans() {
                return this.fans;
            }

            public final void setFans(long j) {
                this.fans = j;
            }

            /* compiled from: BubbleBean.kt */
            @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 L2\u00020\u0001:\u0002KLB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0091\u0001\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0002\u0010\u0018J\b\u0010B\u001a\u00020\u0007H\u0016J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010\u0003\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010\u001dR&\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR&\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR,\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR&\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR,\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u00103\"\u0004\b>\u00105R&\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b?\u0010\u0003\u001a\u0004\b@\u0010\u001b\"\u0004\bA\u0010\u001d¨\u0006M"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;", "", "<init>", "()V", "seen0", "", "bubbleId", "", "type", "joinRecommend", "", "typeName", "subTypeName", "tag", "text", "", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Text;", "startTime", "endTime", "versionFilter", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$VersionFilter;", "jumpUrl", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getBubbleId$annotations", "getBubbleId", "()Ljava/lang/String;", "setBubbleId", "(Ljava/lang/String;)V", "getType$annotations", "getType", "()I", "setType", "(I)V", "getJoinRecommend$annotations", "getJoinRecommend", "()Z", "setJoinRecommend", "(Z)V", "getTypeName$annotations", "getTypeName", "setTypeName", "getSubTypeName$annotations", "getSubTypeName", "setSubTypeName", "getTag$annotations", "getTag", "setTag", "getText$annotations", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "getStartTime$annotations", "getStartTime", "setStartTime", "getEndTime$annotations", "getEndTime", "setEndTime", "getVersionFilter$annotations", "getVersionFilter", "setVersionFilter", "getJumpUrl$annotations", "getJumpUrl", "setJumpUrl", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Bubble {
                private String bubbleId;
                private String endTime;
                private boolean joinRecommend;
                private String jumpUrl;
                private String startTime;
                private String subTypeName;
                private String tag;
                private List<Text> text;
                private int type;
                private String typeName;
                private List<VersionFilter> versionFilter;
                public static final Companion Companion = new Companion(null);
                private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleBean$Bubble$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_;
                        _childSerializers$_anonymous_ = BubbleBean.Bubble._childSerializers$_anonymous_();
                        return _childSerializers$_anonymous_;
                    }
                }), null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upper.entrance.bubble2.bean.BubbleBean$Bubble$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        KSerializer _childSerializers$_anonymous_$0;
                        _childSerializers$_anonymous_$0 = BubbleBean.Bubble._childSerializers$_anonymous_$0();
                        return _childSerializers$_anonymous_$0;
                    }
                }), null};

                @SerialName("id")
                public static /* synthetic */ void getBubbleId$annotations() {
                }

                @SerialName("end_time")
                public static /* synthetic */ void getEndTime$annotations() {
                }

                @SerialName("is_join_recommend")
                public static /* synthetic */ void getJoinRecommend$annotations() {
                }

                @SerialName("jump_url")
                public static /* synthetic */ void getJumpUrl$annotations() {
                }

                @SerialName("start_time")
                public static /* synthetic */ void getStartTime$annotations() {
                }

                @SerialName("sub_type_name")
                public static /* synthetic */ void getSubTypeName$annotations() {
                }

                @SerialName("tag")
                public static /* synthetic */ void getTag$annotations() {
                }

                @SerialName("text")
                public static /* synthetic */ void getText$annotations() {
                }

                @SerialName("type")
                public static /* synthetic */ void getType$annotations() {
                }

                @SerialName("type_name")
                public static /* synthetic */ void getTypeName$annotations() {
                }

                @SerialName("version_filter")
                public static /* synthetic */ void getVersionFilter$annotations() {
                }

                /* compiled from: BubbleBean.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Bubble;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Bubble> serializer() {
                        return BubbleBean$Bubble$$serializer.INSTANCE;
                    }
                }

                public Bubble() {
                }

                public /* synthetic */ Bubble(int seen0, String bubbleId, int type, boolean joinRecommend, String typeName, String subTypeName, String tag, List text, String startTime, String endTime, List versionFilter, String jumpUrl, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.bubbleId = null;
                    } else {
                        this.bubbleId = bubbleId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.type = 0;
                    } else {
                        this.type = type;
                    }
                    if ((seen0 & 4) == 0) {
                        this.joinRecommend = false;
                    } else {
                        this.joinRecommend = joinRecommend;
                    }
                    if ((seen0 & 8) == 0) {
                        this.typeName = null;
                    } else {
                        this.typeName = typeName;
                    }
                    if ((seen0 & 16) == 0) {
                        this.subTypeName = null;
                    } else {
                        this.subTypeName = subTypeName;
                    }
                    if ((seen0 & 32) == 0) {
                        this.tag = null;
                    } else {
                        this.tag = tag;
                    }
                    if ((seen0 & 64) == 0) {
                        this.text = null;
                    } else {
                        this.text = text;
                    }
                    if ((seen0 & 128) == 0) {
                        this.startTime = null;
                    } else {
                        this.startTime = startTime;
                    }
                    if ((seen0 & 256) == 0) {
                        this.endTime = null;
                    } else {
                        this.endTime = endTime;
                    }
                    if ((seen0 & 512) == 0) {
                        this.versionFilter = null;
                    } else {
                        this.versionFilter = versionFilter;
                    }
                    if ((seen0 & 1024) == 0) {
                        this.jumpUrl = null;
                    } else {
                        this.jumpUrl = jumpUrl;
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                    return new ArrayListSerializer(BubbleBean$Text$$serializer.INSTANCE);
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                    return new ArrayListSerializer(BubbleBean$VersionFilter$$serializer.INSTANCE);
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$entrance_debug(Bubble self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.bubbleId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.bubbleId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != 0) {
                        output.encodeIntElement(serialDesc, 1, self.type);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.joinRecommend) {
                        output.encodeBooleanElement(serialDesc, 2, self.joinRecommend);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.typeName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.typeName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 4) || self.subTypeName != null) {
                        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.subTypeName);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 5) || self.tag != null) {
                        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.tag);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 6) || self.text != null) {
                        output.encodeNullableSerializableElement(serialDesc, 6, lazyArr[6].getValue(), self.text);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 7) || self.startTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.startTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 8) || self.endTime != null) {
                        output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.endTime);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 9) || self.versionFilter != null) {
                        output.encodeNullableSerializableElement(serialDesc, 9, lazyArr[9].getValue(), self.versionFilter);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 10) || self.jumpUrl != null) {
                        output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.jumpUrl);
                    }
                }

                public final String getBubbleId() {
                    return this.bubbleId;
                }

                public final void setBubbleId(String str) {
                    this.bubbleId = str;
                }

                public final int getType() {
                    return this.type;
                }

                public final void setType(int i) {
                    this.type = i;
                }

                public final boolean getJoinRecommend() {
                    return this.joinRecommend;
                }

                public final void setJoinRecommend(boolean z) {
                    this.joinRecommend = z;
                }

                public final String getTypeName() {
                    return this.typeName;
                }

                public final void setTypeName(String str) {
                    this.typeName = str;
                }

                public final String getSubTypeName() {
                    return this.subTypeName;
                }

                public final void setSubTypeName(String str) {
                    this.subTypeName = str;
                }

                public final String getTag() {
                    return this.tag;
                }

                public final void setTag(String str) {
                    this.tag = str;
                }

                public final List<Text> getText() {
                    return this.text;
                }

                public final void setText(List<Text> list) {
                    this.text = list;
                }

                public final String getStartTime() {
                    return this.startTime;
                }

                public final void setStartTime(String str) {
                    this.startTime = str;
                }

                public final String getEndTime() {
                    return this.endTime;
                }

                public final void setEndTime(String str) {
                    this.endTime = str;
                }

                public final List<VersionFilter> getVersionFilter() {
                    return this.versionFilter;
                }

                public final void setVersionFilter(List<VersionFilter> list) {
                    this.versionFilter = list;
                }

                public final String getJumpUrl() {
                    return this.jumpUrl;
                }

                public final void setJumpUrl(String str) {
                    this.jumpUrl = str;
                }

                public String toString() {
                    String str = this.bubbleId;
                    int i = this.type;
                    boolean z = this.joinRecommend;
                    String str2 = this.typeName;
                    String str3 = this.subTypeName;
                    String str4 = this.tag;
                    List<Text> list = this.text;
                    String str5 = this.startTime;
                    String str6 = this.endTime;
                    List<VersionFilter> list2 = this.versionFilter;
                    return "Bubble(bubbleId=" + str + ", type=" + i + ", joinRecommend=" + z + ", typeName=" + str2 + ", subTypeName=" + str3 + ", tag=" + str4 + ", text=" + list + ", startTime=" + str5 + ", endTime=" + str6 + ", versionFilter=" + list2 + ", jumpUrl=" + this.jumpUrl + ")";
                }
            }

            /* compiled from: BubbleBean.kt */
            @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003BC\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0002\u0010\rJ\b\u0010\u001c\u001a\u00020\u0007H\u0016J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R&\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R&\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012¨\u0006'"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Text;", "", "<init>", "()V", "seen0", "", "textId", "", "title", "subtitle", "url", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTextId$annotations", "getTextId", "()Ljava/lang/String;", "setTextId", "(Ljava/lang/String;)V", "getTitle$annotations", "getTitle", "setTitle", "getSubtitle$annotations", "getSubtitle", "setSubtitle", "getUrl$annotations", "getUrl", "setUrl", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class Text {
                public static final Companion Companion = new Companion(null);
                private String subtitle;
                private String textId;
                private String title;
                private String url;

                @SerialName("subtitle")
                public static /* synthetic */ void getSubtitle$annotations() {
                }

                @SerialName("id")
                public static /* synthetic */ void getTextId$annotations() {
                }

                @SerialName("title")
                public static /* synthetic */ void getTitle$annotations() {
                }

                @SerialName("url")
                public static /* synthetic */ void getUrl$annotations() {
                }

                /* compiled from: BubbleBean.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Text$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Text;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<Text> serializer() {
                        return BubbleBean$Text$$serializer.INSTANCE;
                    }
                }

                public Text() {
                }

                public /* synthetic */ Text(int seen0, String textId, String title, String subtitle, String url, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.textId = null;
                    } else {
                        this.textId = textId;
                    }
                    if ((seen0 & 2) == 0) {
                        this.title = null;
                    } else {
                        this.title = title;
                    }
                    if ((seen0 & 4) == 0) {
                        this.subtitle = null;
                    } else {
                        this.subtitle = subtitle;
                    }
                    if ((seen0 & 8) == 0) {
                        this.url = null;
                    } else {
                        this.url = url;
                    }
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$entrance_debug(Text self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.textId != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.textId);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.subtitle != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.subtitle);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 3) || self.url != null) {
                        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.url);
                    }
                }

                public final String getTextId() {
                    return this.textId;
                }

                public final void setTextId(String str) {
                    this.textId = str;
                }

                public final String getTitle() {
                    return this.title;
                }

                public final void setTitle(String str) {
                    this.title = str;
                }

                public final String getSubtitle() {
                    return this.subtitle;
                }

                public final void setSubtitle(String str) {
                    this.subtitle = str;
                }

                public final String getUrl() {
                    return this.url;
                }

                public final void setUrl(String str) {
                    this.url = str;
                }

                public String toString() {
                    String str = this.textId;
                    String str2 = this.title;
                    String str3 = this.subtitle;
                    return "Text(id=" + str + ", title=" + str2 + ", subtitle=" + str3 + ", url=" + this.url + ")";
                }
            }

            /* compiled from: BubbleBean.kt */
            @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0002\u0010\fJ\b\u0010\u0018\u001a\u00020\u0007H\u0016J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R&\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$VersionFilter;", "", "<init>", "()V", "seen0", "", "platform", "", "upperLimit", "lowerLimit", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlatform$annotations", "getPlatform", "()Ljava/lang/String;", "setPlatform", "(Ljava/lang/String;)V", "getUpperLimit$annotations", "getUpperLimit", "setUpperLimit", "getLowerLimit$annotations", "getLowerLimit", "setLowerLimit", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$entrance_debug", "$serializer", "Companion", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            @Serializable
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public static final class VersionFilter {
                public static final Companion Companion = new Companion(null);
                private String lowerLimit;
                private String platform;
                private String upperLimit;

                @SerialName("lower_limit")
                public static /* synthetic */ void getLowerLimit$annotations() {
                }

                @SerialName("platform")
                public static /* synthetic */ void getPlatform$annotations() {
                }

                @SerialName("upper_limit")
                public static /* synthetic */ void getUpperLimit$annotations() {
                }

                /* compiled from: BubbleBean.kt */
                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$VersionFilter$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$VersionFilter;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final KSerializer<VersionFilter> serializer() {
                        return BubbleBean$VersionFilter$$serializer.INSTANCE;
                    }
                }

                public VersionFilter() {
                }

                public /* synthetic */ VersionFilter(int seen0, String platform, String upperLimit, String lowerLimit, SerializationConstructorMarker serializationConstructorMarker) {
                    if ((seen0 & 1) == 0) {
                        this.platform = null;
                    } else {
                        this.platform = platform;
                    }
                    if ((seen0 & 2) == 0) {
                        this.upperLimit = null;
                    } else {
                        this.upperLimit = upperLimit;
                    }
                    if ((seen0 & 4) == 0) {
                        this.lowerLimit = null;
                    } else {
                        this.lowerLimit = lowerLimit;
                    }
                }

                @JvmStatic
                public static final /* synthetic */ void write$Self$entrance_debug(VersionFilter self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    if (output.shouldEncodeElementDefault(serialDesc, 0) || self.platform != null) {
                        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.platform);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 1) || self.upperLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.upperLimit);
                    }
                    if (output.shouldEncodeElementDefault(serialDesc, 2) || self.lowerLimit != null) {
                        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.lowerLimit);
                    }
                }

                public final String getPlatform() {
                    return this.platform;
                }

                public final void setPlatform(String str) {
                    this.platform = str;
                }

                public final String getUpperLimit() {
                    return this.upperLimit;
                }

                public final void setUpperLimit(String str) {
                    this.upperLimit = str;
                }

                public final String getLowerLimit() {
                    return this.lowerLimit;
                }

                public final void setLowerLimit(String str) {
                    this.lowerLimit = str;
                }

                public String toString() {
                    String str = this.platform;
                    String str2 = this.upperLimit;
                    return "VersionFilter(platform=" + str + ", upperLimit=" + str2 + ", lowerLimit=" + this.lowerLimit + ")";
                }
            }

            public String toString() {
                int i = this.recommend;
                List<Resource> list = this.resourceList;
                long j = this.zeroTs;
                return "BubbleBean(recommend=" + i + ", resourceList=" + list + ", zeroTs=" + j + ", fans=" + this.fans + ")";
            }
        }