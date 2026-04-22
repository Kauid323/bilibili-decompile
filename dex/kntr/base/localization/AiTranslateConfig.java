package kntr.base.localization;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LanguageConfig.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tBA\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u000bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J%\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0001¢\u0006\u0002\b*R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012¨\u0006-"}, d2 = {"Lkntr/base/localization/AiTranslateConfig;", "", "languageTag", "", "supportAiTranslate", "", "aiTranslateTitle", "aiTranslateSubtitle", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLanguageTag$annotations", "()V", "getLanguageTag", "()Ljava/lang/String;", "getSupportAiTranslate$annotations", "getSupportAiTranslate", "()Z", "getAiTranslateTitle$annotations", "getAiTranslateTitle", "getAiTranslateSubtitle$annotations", "getAiTranslateSubtitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$localization_debug", "$serializer", "Companion", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class AiTranslateConfig {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String aiTranslateSubtitle;
    private final String aiTranslateTitle;
    private final String languageTag;
    private final boolean supportAiTranslate;

    public AiTranslateConfig() {
        this((String) null, false, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AiTranslateConfig copy$default(AiTranslateConfig aiTranslateConfig, String str, boolean z, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aiTranslateConfig.languageTag;
        }
        if ((i & 2) != 0) {
            z = aiTranslateConfig.supportAiTranslate;
        }
        if ((i & 4) != 0) {
            str2 = aiTranslateConfig.aiTranslateTitle;
        }
        if ((i & 8) != 0) {
            str3 = aiTranslateConfig.aiTranslateSubtitle;
        }
        return aiTranslateConfig.copy(str, z, str2, str3);
    }

    @SerialName("ai_translate_sub_title")
    public static /* synthetic */ void getAiTranslateSubtitle$annotations() {
    }

    @SerialName("ai_translate_title")
    public static /* synthetic */ void getAiTranslateTitle$annotations() {
    }

    @SerialName("language_tag")
    public static /* synthetic */ void getLanguageTag$annotations() {
    }

    @SerialName("support_ai_translate")
    public static /* synthetic */ void getSupportAiTranslate$annotations() {
    }

    public final String component1() {
        return this.languageTag;
    }

    public final boolean component2() {
        return this.supportAiTranslate;
    }

    public final String component3() {
        return this.aiTranslateTitle;
    }

    public final String component4() {
        return this.aiTranslateSubtitle;
    }

    public final AiTranslateConfig copy(String str, boolean z, String str2, String str3) {
        return new AiTranslateConfig(str, z, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AiTranslateConfig) {
            AiTranslateConfig aiTranslateConfig = (AiTranslateConfig) obj;
            return Intrinsics.areEqual(this.languageTag, aiTranslateConfig.languageTag) && this.supportAiTranslate == aiTranslateConfig.supportAiTranslate && Intrinsics.areEqual(this.aiTranslateTitle, aiTranslateConfig.aiTranslateTitle) && Intrinsics.areEqual(this.aiTranslateSubtitle, aiTranslateConfig.aiTranslateSubtitle);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.languageTag == null ? 0 : this.languageTag.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.supportAiTranslate)) * 31) + (this.aiTranslateTitle == null ? 0 : this.aiTranslateTitle.hashCode())) * 31) + (this.aiTranslateSubtitle != null ? this.aiTranslateSubtitle.hashCode() : 0);
    }

    public String toString() {
        String str = this.languageTag;
        boolean z = this.supportAiTranslate;
        String str2 = this.aiTranslateTitle;
        return "AiTranslateConfig(languageTag=" + str + ", supportAiTranslate=" + z + ", aiTranslateTitle=" + str2 + ", aiTranslateSubtitle=" + this.aiTranslateSubtitle + ")";
    }

    /* compiled from: LanguageConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/localization/AiTranslateConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/localization/AiTranslateConfig;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AiTranslateConfig> serializer() {
            return new GeneratedSerializer<AiTranslateConfig>() { // from class: kntr.base.localization.AiTranslateConfig$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.localization.AiTranslateConfig", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.base.localization.AiTranslateConfig> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.base.localization.AiTranslateConfig> A[REMOVE]) =  kntr.base.localization.AiTranslateConfig$$serializer.INSTANCE kntr.base.localization.AiTranslateConfig$$serializer)
                         in method: kntr.base.localization.AiTranslateConfig.Companion.serializer():kotlinx.serialization.KSerializer<kntr.base.localization.AiTranslateConfig>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.base.localization.AiTranslateConfig")
                          (wrap: kntr.base.localization.AiTranslateConfig$$serializer : 0x0009: SGET  (r1v0 kntr.base.localization.AiTranslateConfig$$serializer A[REMOVE]) =  kntr.base.localization.AiTranslateConfig$$serializer.INSTANCE kntr.base.localization.AiTranslateConfig$$serializer)
                          (4 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.base.localization.AiTranslateConfig$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.base.localization.AiTranslateConfig$$serializer
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
                        kntr.base.localization.AiTranslateConfig$$serializer r0 = kntr.base.localization.AiTranslateConfig$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.base.localization.AiTranslateConfig.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ AiTranslateConfig(int seen0, String languageTag, boolean supportAiTranslate, String aiTranslateTitle, String aiTranslateSubtitle, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.languageTag = null;
                } else {
                    this.languageTag = languageTag;
                }
                if ((seen0 & 2) == 0) {
                    this.supportAiTranslate = false;
                } else {
                    this.supportAiTranslate = supportAiTranslate;
                }
                if ((seen0 & 4) == 0) {
                    this.aiTranslateTitle = null;
                } else {
                    this.aiTranslateTitle = aiTranslateTitle;
                }
                if ((seen0 & 8) == 0) {
                    this.aiTranslateSubtitle = null;
                } else {
                    this.aiTranslateSubtitle = aiTranslateSubtitle;
                }
            }

            public AiTranslateConfig(String languageTag, boolean supportAiTranslate, String aiTranslateTitle, String aiTranslateSubtitle) {
                this.languageTag = languageTag;
                this.supportAiTranslate = supportAiTranslate;
                this.aiTranslateTitle = aiTranslateTitle;
                this.aiTranslateSubtitle = aiTranslateSubtitle;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$localization_debug(AiTranslateConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.languageTag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.languageTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.supportAiTranslate) {
                    output.encodeBooleanElement(serialDesc, 1, self.supportAiTranslate);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.aiTranslateTitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.aiTranslateTitle);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.aiTranslateSubtitle != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.aiTranslateSubtitle);
                }
            }

            public /* synthetic */ AiTranslateConfig(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
            }

            public final String getLanguageTag() {
                return this.languageTag;
            }

            public final boolean getSupportAiTranslate() {
                return this.supportAiTranslate;
            }

            public final String getAiTranslateTitle() {
                return this.aiTranslateTitle;
            }

            public final String getAiTranslateSubtitle() {
                return this.aiTranslateSubtitle;
            }
        }