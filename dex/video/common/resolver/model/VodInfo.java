package video.common.resolver.model;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: VodInfo.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 +2\u00020\u0001:\u0002*+B[\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011Bg\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006,"}, d2 = {"Lvideo/common/resolver/model/VodInfo;", "", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "", IjkMediaMeta.IJKM_KEY_FORMAT, "", "timeLength", "", "videoCodecid", "streamList", "", "Lvideo/common/resolver/model/Stream;", "dashAudio", "Lvideo/common/resolver/model/DashMedia;", "dolby", "Lvideo/common/resolver/model/DolbyInfo;", "<init>", "(ILjava/lang/String;JILjava/util/List;Ljava/util/List;Lvideo/common/resolver/model/DolbyInfo;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;JILjava/util/List;Ljava/util/List;Lvideo/common/resolver/model/DolbyInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuality", "()I", "getFormat", "()Ljava/lang/String;", "getTimeLength", "()J", "getVideoCodecid", "getStreamList", "()Ljava/util/List;", "getDashAudio", "getDolby", "()Lvideo/common/resolver/model/DolbyInfo;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$resolver_debug", "$serializer", "Companion", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VodInfo {
    private final List<DashMedia> dashAudio;
    private final DolbyInfo dolby;
    private final String format;
    private final int quality;
    private final List<Stream> streamList;
    private final long timeLength;
    private final int videoCodecid;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.common.resolver.model.VodInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = VodInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.common.resolver.model.VodInfo$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = VodInfo._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null};

    public VodInfo() {
        this(0, (String) null, 0L, 0, (List) null, (List) null, (DolbyInfo) null, 127, (DefaultConstructorMarker) null);
    }

    /* compiled from: VodInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/common/resolver/model/VodInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/common/resolver/model/VodInfo;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VodInfo> serializer() {
            return new GeneratedSerializer<VodInfo>() { // from class: video.common.resolver.model.VodInfo$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.common.resolver.model.VodInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.common.resolver.model.VodInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.common.resolver.model.VodInfo> A[REMOVE]) =  video.common.resolver.model.VodInfo$$serializer.INSTANCE video.common.resolver.model.VodInfo$$serializer)
                         in method: video.common.resolver.model.VodInfo.Companion.serializer():kotlinx.serialization.KSerializer<video.common.resolver.model.VodInfo>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.common.resolver.model.VodInfo")
                          (wrap: video.common.resolver.model.VodInfo$$serializer : 0x0009: SGET  (r1v0 video.common.resolver.model.VodInfo$$serializer A[REMOVE]) =  video.common.resolver.model.VodInfo$$serializer.INSTANCE video.common.resolver.model.VodInfo$$serializer)
                          (7 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.common.resolver.model.VodInfo$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.common.resolver.model.VodInfo$$serializer
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
                        video.common.resolver.model.VodInfo$$serializer r0 = video.common.resolver.model.VodInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.common.resolver.model.VodInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ VodInfo(int seen0, int quality, String format, long timeLength, int videoCodecid, List streamList, List dashAudio, DolbyInfo dolby, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.quality = 0;
                } else {
                    this.quality = quality;
                }
                if ((seen0 & 2) == 0) {
                    this.format = "";
                } else {
                    this.format = format;
                }
                if ((seen0 & 4) == 0) {
                    this.timeLength = 0L;
                } else {
                    this.timeLength = timeLength;
                }
                if ((seen0 & 8) == 0) {
                    this.videoCodecid = 0;
                } else {
                    this.videoCodecid = videoCodecid;
                }
                if ((seen0 & 16) == 0) {
                    this.streamList = CollectionsKt.emptyList();
                } else {
                    this.streamList = streamList;
                }
                if ((seen0 & 32) == 0) {
                    this.dashAudio = CollectionsKt.emptyList();
                } else {
                    this.dashAudio = dashAudio;
                }
                if ((seen0 & 64) == 0) {
                    this.dolby = null;
                } else {
                    this.dolby = dolby;
                }
            }

            public VodInfo(int quality, String format, long timeLength, int videoCodecid, List<Stream> list, List<DashMedia> list2, DolbyInfo dolby) {
                Intrinsics.checkNotNullParameter(format, IjkMediaMeta.IJKM_KEY_FORMAT);
                Intrinsics.checkNotNullParameter(list, "streamList");
                Intrinsics.checkNotNullParameter(list2, "dashAudio");
                this.quality = quality;
                this.format = format;
                this.timeLength = timeLength;
                this.videoCodecid = videoCodecid;
                this.streamList = list;
                this.dashAudio = list2;
                this.dolby = dolby;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(Stream$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(DashMedia$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$resolver_debug(VodInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.quality != 0) {
                    output.encodeIntElement(serialDesc, 0, self.quality);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.format, "")) {
                    output.encodeStringElement(serialDesc, 1, self.format);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.timeLength != 0) {
                    output.encodeLongElement(serialDesc, 2, self.timeLength);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.videoCodecid != 0) {
                    output.encodeIntElement(serialDesc, 3, self.videoCodecid);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.streamList, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.streamList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.dashAudio, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy) lazyArr[5].getValue(), self.dashAudio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.dolby != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, DolbyInfo$$serializer.INSTANCE, self.dolby);
                }
            }

            public /* synthetic */ VodInfo(int i, String str, long j, int i2, List list, List list2, DolbyInfo dolbyInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0L : j, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 64) != 0 ? null : dolbyInfo);
            }

            public final int getQuality() {
                return this.quality;
            }

            public final String getFormat() {
                return this.format;
            }

            public final long getTimeLength() {
                return this.timeLength;
            }

            public final int getVideoCodecid() {
                return this.videoCodecid;
            }

            public final List<Stream> getStreamList() {
                return this.streamList;
            }

            public final List<DashMedia> getDashAudio() {
                return this.dashAudio;
            }

            public final DolbyInfo getDolby() {
                return this.dolby;
            }
        }