package kntr.app.ad.common.model;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.ReferenceArraySerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MMAReplaceDefault.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u0001:\u0002%&Bk\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nBu\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R(\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R(\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R(\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013¨\u0006'"}, d2 = {"Lkntr/app/ad/common/model/MMAReplaceDefault;", RoomRecommendViewModel.EMPTY_CURSOR, "macDefaults", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "mac1Defaults", "oaidDefaults", "androididDefaults", "imeiDefaults", "<init>", "([Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(I[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMacDefaults$annotations", "()V", "getMacDefaults", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getMac1Defaults$annotations", "getMac1Defaults", "getOaidDefaults$annotations", "getOaidDefaults", "getAndroididDefaults$annotations", "getAndroididDefaults", "getImeiDefaults$annotations", "getImeiDefaults", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$base_debug", "$serializer", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class MMAReplaceDefault {
    private final String[] androididDefaults;
    private final String[] imeiDefaults;
    private final String[] mac1Defaults;
    private final String[] macDefaults;
    private final String[] oaidDefaults;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = MMAReplaceDefault._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = MMAReplaceDefault._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = MMAReplaceDefault._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$ExternalSyntheticLambda3
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$2;
            _childSerializers$_anonymous_$2 = MMAReplaceDefault._childSerializers$_anonymous_$2();
            return _childSerializers$_anonymous_$2;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$ExternalSyntheticLambda4
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$3;
            _childSerializers$_anonymous_$3 = MMAReplaceDefault._childSerializers$_anonymous_$3();
            return _childSerializers$_anonymous_$3;
        }
    })};

    public MMAReplaceDefault() {
        this((String[]) null, (String[]) null, (String[]) null, (String[]) null, (String[]) null, 31, (DefaultConstructorMarker) null);
    }

    @SerialName("__ANDROIDID__")
    public static /* synthetic */ void getAndroididDefaults$annotations() {
    }

    @SerialName("__IMEI__")
    public static /* synthetic */ void getImeiDefaults$annotations() {
    }

    @SerialName("__MAC1__")
    public static /* synthetic */ void getMac1Defaults$annotations() {
    }

    @SerialName("__MAC__")
    public static /* synthetic */ void getMacDefaults$annotations() {
    }

    @SerialName("__OAID__")
    public static /* synthetic */ void getOaidDefaults$annotations() {
    }

    /* compiled from: MMAReplaceDefault.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/ad/common/model/MMAReplaceDefault$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/ad/common/model/MMAReplaceDefault;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MMAReplaceDefault> serializer() {
            return new GeneratedSerializer<MMAReplaceDefault>() { // from class: kntr.app.ad.common.model.MMAReplaceDefault$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.MMAReplaceDefault", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.ad.common.model.MMAReplaceDefault> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.ad.common.model.MMAReplaceDefault> A[REMOVE]) =  kntr.app.ad.common.model.MMAReplaceDefault$$serializer.INSTANCE kntr.app.ad.common.model.MMAReplaceDefault$$serializer)
                         in method: kntr.app.ad.common.model.MMAReplaceDefault.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.ad.common.model.MMAReplaceDefault>, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0010: CONSTRUCTOR  (r0v1 'pluginGeneratedSerialDescriptor' kotlinx.serialization.descriptors.SerialDescriptor) = 
                          ("kntr.app.ad.common.model.MMAReplaceDefault")
                          (wrap: kntr.app.ad.common.model.MMAReplaceDefault$$serializer : 0x0009: SGET  (r1v0 kntr.app.ad.common.model.MMAReplaceDefault$$serializer A[REMOVE]) =  kntr.app.ad.common.model.MMAReplaceDefault$$serializer.INSTANCE kntr.app.ad.common.model.MMAReplaceDefault$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.ad.common.model.MMAReplaceDefault$$serializer.<clinit>():void, file: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.ad.common.model.MMAReplaceDefault$$serializer
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
                        kntr.app.ad.common.model.MMAReplaceDefault$$serializer r0 = kntr.app.ad.common.model.MMAReplaceDefault$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.ad.common.model.MMAReplaceDefault.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ MMAReplaceDefault(int seen0, String[] macDefaults, String[] mac1Defaults, String[] oaidDefaults, String[] androididDefaults, String[] imeiDefaults, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.macDefaults = null;
                } else {
                    this.macDefaults = macDefaults;
                }
                if ((seen0 & 2) == 0) {
                    this.mac1Defaults = null;
                } else {
                    this.mac1Defaults = mac1Defaults;
                }
                if ((seen0 & 4) == 0) {
                    this.oaidDefaults = null;
                } else {
                    this.oaidDefaults = oaidDefaults;
                }
                if ((seen0 & 8) == 0) {
                    this.androididDefaults = null;
                } else {
                    this.androididDefaults = androididDefaults;
                }
                if ((seen0 & 16) == 0) {
                    this.imeiDefaults = null;
                } else {
                    this.imeiDefaults = imeiDefaults;
                }
            }

            public MMAReplaceDefault(String[] macDefaults, String[] mac1Defaults, String[] oaidDefaults, String[] androididDefaults, String[] imeiDefaults) {
                this.macDefaults = macDefaults;
                this.mac1Defaults = mac1Defaults;
                this.oaidDefaults = oaidDefaults;
                this.androididDefaults = androididDefaults;
                this.imeiDefaults = imeiDefaults;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
                return new ReferenceArraySerializer(Reflection.getOrCreateKotlinClass(String.class), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE));
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$base_debug(MMAReplaceDefault self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.macDefaults != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, (SerializationStrategy) lazyArr[0].getValue(), self.macDefaults);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.mac1Defaults != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.mac1Defaults);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.oaidDefaults != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.oaidDefaults);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.androididDefaults != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.androididDefaults);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.imeiDefaults != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, (SerializationStrategy) lazyArr[4].getValue(), self.imeiDefaults);
                }
            }

            public /* synthetic */ MMAReplaceDefault(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : strArr, (i & 2) != 0 ? null : strArr2, (i & 4) != 0 ? null : strArr3, (i & 8) != 0 ? null : strArr4, (i & 16) != 0 ? null : strArr5);
            }

            public final String[] getMacDefaults() {
                return this.macDefaults;
            }

            public final String[] getMac1Defaults() {
                return this.mac1Defaults;
            }

            public final String[] getOaidDefaults() {
                return this.oaidDefaults;
            }

            public final String[] getAndroididDefaults() {
                return this.androididDefaults;
            }

            public final String[] getImeiDefaults() {
                return this.imeiDefaults;
            }
        }