package video.biz.offline.base.infra.model;

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
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.DashMedia$$serializer;
import video.common.resolver.model.Segment;
import video.common.resolver.model.Segment$$serializer;

/* compiled from: DeprecatedIndexModel.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0004\b\b\u0010\tBK\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J%\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0001¢\u0006\u0002\b&R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedIndexModel;", "", "video", "", "Lvideo/common/resolver/model/DashMedia;", "audio", "segmentList", "Lvideo/common/resolver/model/Segment;", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideo", "()Ljava/util/List;", "getAudio", "getSegmentList$annotations", "()V", "getSegmentList", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$infra_debug", "$serializer", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class DeprecatedIndexModel {
    private final List<DashMedia> audio;
    private final List<Segment> segmentList;

    /* renamed from: video  reason: collision with root package name */
    private final List<DashMedia> f29video;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.infra.model.DeprecatedIndexModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DeprecatedIndexModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.infra.model.DeprecatedIndexModel$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = DeprecatedIndexModel._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.biz.offline.base.infra.model.DeprecatedIndexModel$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = DeprecatedIndexModel._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public DeprecatedIndexModel() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DeprecatedIndexModel copy$default(DeprecatedIndexModel deprecatedIndexModel, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = deprecatedIndexModel.f29video;
        }
        if ((i & 2) != 0) {
            list2 = deprecatedIndexModel.audio;
        }
        if ((i & 4) != 0) {
            list3 = deprecatedIndexModel.segmentList;
        }
        return deprecatedIndexModel.copy(list, list2, list3);
    }

    @SerialName("segment_list")
    public static /* synthetic */ void getSegmentList$annotations() {
    }

    public final List<DashMedia> component1() {
        return this.f29video;
    }

    public final List<DashMedia> component2() {
        return this.audio;
    }

    public final List<Segment> component3() {
        return this.segmentList;
    }

    public final DeprecatedIndexModel copy(List<DashMedia> list, List<DashMedia> list2, List<Segment> list3) {
        Intrinsics.checkNotNullParameter(list, "video");
        Intrinsics.checkNotNullParameter(list2, "audio");
        Intrinsics.checkNotNullParameter(list3, "segmentList");
        return new DeprecatedIndexModel(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DeprecatedIndexModel) {
            DeprecatedIndexModel deprecatedIndexModel = (DeprecatedIndexModel) obj;
            return Intrinsics.areEqual(this.f29video, deprecatedIndexModel.f29video) && Intrinsics.areEqual(this.audio, deprecatedIndexModel.audio) && Intrinsics.areEqual(this.segmentList, deprecatedIndexModel.segmentList);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f29video.hashCode() * 31) + this.audio.hashCode()) * 31) + this.segmentList.hashCode();
    }

    public String toString() {
        List<DashMedia> list = this.f29video;
        List<DashMedia> list2 = this.audio;
        return "DeprecatedIndexModel(video=" + list + ", audio=" + list2 + ", segmentList=" + this.segmentList + ")";
    }

    /* compiled from: DeprecatedIndexModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/infra/model/DeprecatedIndexModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/infra/model/DeprecatedIndexModel;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeprecatedIndexModel> serializer() {
            return new GeneratedSerializer<DeprecatedIndexModel>() { // from class: video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.biz.offline.base.infra.model.DeprecatedIndexModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedIndexModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedIndexModel> A[REMOVE]) =  video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer.INSTANCE video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer)
                         in method: video.biz.offline.base.infra.model.DeprecatedIndexModel.Companion.serializer():kotlinx.serialization.KSerializer<video.biz.offline.base.infra.model.DeprecatedIndexModel>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.biz.offline.base.infra.model.DeprecatedIndexModel")
                          (wrap: video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer : 0x0009: SGET  (r1v0 video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer A[REMOVE]) =  video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer.INSTANCE video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer
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
                        video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer r0 = video.biz.offline.base.infra.model.DeprecatedIndexModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.biz.offline.base.infra.model.DeprecatedIndexModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ DeprecatedIndexModel(int seen0, List video2, List audio, List segmentList, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.f29video = CollectionsKt.emptyList();
                } else {
                    this.f29video = video2;
                }
                if ((seen0 & 2) == 0) {
                    this.audio = CollectionsKt.emptyList();
                } else {
                    this.audio = audio;
                }
                if ((seen0 & 4) == 0) {
                    this.segmentList = CollectionsKt.emptyList();
                } else {
                    this.segmentList = segmentList;
                }
            }

            public DeprecatedIndexModel(List<DashMedia> list, List<DashMedia> list2, List<Segment> list3) {
                Intrinsics.checkNotNullParameter(list, "video");
                Intrinsics.checkNotNullParameter(list2, "audio");
                Intrinsics.checkNotNullParameter(list3, "segmentList");
                this.f29video = list;
                this.audio = list2;
                this.segmentList = list3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(DashMedia$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(DashMedia$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ArrayListSerializer(Segment$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$infra_debug(DeprecatedIndexModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.f29video, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.f29video);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.audio, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.audio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.segmentList, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.segmentList);
                }
            }

            public /* synthetic */ DeprecatedIndexModel(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
            }

            public final List<DashMedia> getVideo() {
                return this.f29video;
            }

            public final List<DashMedia> getAudio() {
                return this.audio;
            }

            public final List<Segment> getSegmentList() {
                return this.segmentList;
            }
        }