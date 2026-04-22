package kntr.base.dd.impl.internal.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: DDModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 22\u00020\u0001:\u000212BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u000fHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u00063"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDModel;", "", "platform", "", AppKey.VERSION, "", "list", "", "Lkntr/base/dd/impl/internal/model/DDNode;", "props", "Lkntr/base/dd/impl/internal/model/DDProp;", "tracks", "<init>", "(Ljava/lang/String;JLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JLjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getPlatform$annotations", "()V", "getPlatform", "()Ljava/lang/String;", "getVersion$annotations", "getVersion", "()J", "getList", "()Ljava/util/List;", "getProps", "getTracks", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_debug", "$serializer", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DDModel {
    private final List<DDNode> list;
    private final String platform;
    private final List<DDProp> props;
    private final List<DDNode> tracks;
    private final long version;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.dd.impl.internal.model.DDModel$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = DDModel._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.dd.impl.internal.model.DDModel$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = DDModel._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.base.dd.impl.internal.model.DDModel$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = DDModel._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    public DDModel() {
        this((String) null, 0L, (List) null, (List) null, (List) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DDModel copy$default(DDModel dDModel, String str, long j, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dDModel.platform;
        }
        if ((i & 2) != 0) {
            j = dDModel.version;
        }
        long j2 = j;
        List<DDNode> list4 = list;
        if ((i & 4) != 0) {
            list4 = dDModel.list;
        }
        List list5 = list4;
        List<DDProp> list6 = list2;
        if ((i & 8) != 0) {
            list6 = dDModel.props;
        }
        List list7 = list6;
        List<DDNode> list8 = list3;
        if ((i & 16) != 0) {
            list8 = dDModel.tracks;
        }
        return dDModel.copy(str, j2, list5, list7, list8);
    }

    @SerialName("p")
    public static /* synthetic */ void getPlatform$annotations() {
    }

    @SerialName("v")
    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.platform;
    }

    public final long component2() {
        return this.version;
    }

    public final List<DDNode> component3() {
        return this.list;
    }

    public final List<DDProp> component4() {
        return this.props;
    }

    public final List<DDNode> component5() {
        return this.tracks;
    }

    public final DDModel copy(String str, long j, List<DDNode> list, List<DDProp> list2, List<DDNode> list3) {
        Intrinsics.checkNotNullParameter(str, "platform");
        return new DDModel(str, j, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DDModel) {
            DDModel dDModel = (DDModel) obj;
            return Intrinsics.areEqual(this.platform, dDModel.platform) && this.version == dDModel.version && Intrinsics.areEqual(this.list, dDModel.list) && Intrinsics.areEqual(this.props, dDModel.props) && Intrinsics.areEqual(this.tracks, dDModel.tracks);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.platform.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.version)) * 31) + (this.list == null ? 0 : this.list.hashCode())) * 31) + (this.props == null ? 0 : this.props.hashCode())) * 31) + (this.tracks != null ? this.tracks.hashCode() : 0);
    }

    public String toString() {
        String str = this.platform;
        long j = this.version;
        List<DDNode> list = this.list;
        List<DDProp> list2 = this.props;
        return "DDModel(platform=" + str + ", version=" + j + ", list=" + list + ", props=" + list2 + ", tracks=" + this.tracks + ")";
    }

    /* compiled from: DDModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDModel$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/dd/impl/internal/model/DDModel;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DDModel> serializer() {
            return new GeneratedSerializer<DDModel>() { // from class: kntr.base.dd.impl.internal.model.DDModel$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.dd.impl.internal.model.DDModel", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDModel> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDModel> A[REMOVE]) =  kntr.base.dd.impl.internal.model.DDModel$$serializer.INSTANCE kntr.base.dd.impl.internal.model.DDModel$$serializer)
                         in method: kntr.base.dd.impl.internal.model.DDModel.Companion.serializer():kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDModel>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.base.dd.impl.internal.model.DDModel")
                          (wrap: kntr.base.dd.impl.internal.model.DDModel$$serializer : 0x0009: SGET  (r1v0 kntr.base.dd.impl.internal.model.DDModel$$serializer A[REMOVE]) =  kntr.base.dd.impl.internal.model.DDModel$$serializer.INSTANCE kntr.base.dd.impl.internal.model.DDModel$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.base.dd.impl.internal.model.DDModel$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.base.dd.impl.internal.model.DDModel$$serializer
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
                        kntr.base.dd.impl.internal.model.DDModel$$serializer r0 = kntr.base.dd.impl.internal.model.DDModel$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.base.dd.impl.internal.model.DDModel.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ DDModel(int seen0, String platform, long version, List list, List props, List tracks, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.platform = "";
                } else {
                    this.platform = platform;
                }
                if ((seen0 & 2) == 0) {
                    this.version = 0L;
                } else {
                    this.version = version;
                }
                if ((seen0 & 4) == 0) {
                    this.list = CollectionsKt.emptyList();
                } else {
                    this.list = list;
                }
                if ((seen0 & 8) == 0) {
                    this.props = CollectionsKt.emptyList();
                } else {
                    this.props = props;
                }
                if ((seen0 & 16) == 0) {
                    this.tracks = CollectionsKt.emptyList();
                } else {
                    this.tracks = tracks;
                }
            }

            public DDModel(String platform, long version, List<DDNode> list, List<DDProp> list2, List<DDNode> list3) {
                Intrinsics.checkNotNullParameter(platform, "platform");
                this.platform = platform;
                this.version = version;
                this.list = list;
                this.props = list2;
                this.tracks = list3;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(DDNode$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(DDProp$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ArrayListSerializer(DDNode$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$impl_debug(DDModel self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.platform, "")) {
                    output.encodeStringElement(serialDesc, 0, self.platform);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.version != 0) {
                    output.encodeLongElement(serialDesc, 1, self.version);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.list, CollectionsKt.emptyList())) {
                    output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.list);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.props, CollectionsKt.emptyList())) {
                    output.encodeNullableSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.props);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.tracks, CollectionsKt.emptyList())) {
                    output.encodeNullableSerializableElement(serialDesc, 4, lazyArr[4].getValue(), self.tracks);
                }
            }

            public /* synthetic */ DDModel(String str, long j, List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? CollectionsKt.emptyList() : list3);
            }

            public final String getPlatform() {
                return this.platform;
            }

            public final long getVersion() {
                return this.version;
            }

            public final List<DDNode> getList() {
                return this.list;
            }

            public final List<DDProp> getProps() {
                return this.props;
            }

            public final List<DDNode> getTracks() {
                return this.tracks;
            }
        }