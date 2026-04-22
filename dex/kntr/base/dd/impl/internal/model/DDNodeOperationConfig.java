package kntr.base.dd.impl.internal.model;

import java.util.Iterator;
import java.util.Locale;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.imp.FreeDataImpKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DDModel.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 ;2\u00020\u0001:\u000489:;BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bBM\b\u0010\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\tHÂ\u0003¢\u0006\u0002\u0010)JJ\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001J%\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0002\b7R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0014\u0012\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0006\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0011R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0002X\u0083\u0004¢\u0006\n\n\u0002\u0010\u001b\u0012\u0004\b\u001a\u0010\u0011R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "", "ignoreCase", "", "separator", "", "isNumericRange", "repeatModeRaw", "comparatorTypeRaw", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIgnoreCase$annotations", "()V", "getIgnoreCase", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSeparator$annotations", "getSeparator", "()Ljava/lang/String;", "isNumericRange$annotations", "getRepeatModeRaw$annotations", "getComparatorTypeRaw$annotations", "Ljava/lang/Integer;", "repeatMode", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;", "getRepeatMode", "()Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;", "comparatorType", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$ComparatorType;", "getComparatorType", "()Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$ComparatorType;", "component1", "component2", "component3", "component4", "component5", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$impl_debug", "RepeatMode", "ComparatorType", "$serializer", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class DDNodeOperationConfig {
    public static final Companion Companion = new Companion(null);
    private final Integer comparatorTypeRaw;
    private final Boolean ignoreCase;
    private final Boolean isNumericRange;
    private final String repeatModeRaw;
    private final String separator;

    public DDNodeOperationConfig() {
        this((Boolean) null, (String) null, (Boolean) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    private final String component4() {
        return this.repeatModeRaw;
    }

    private final Integer component5() {
        return this.comparatorTypeRaw;
    }

    public static /* synthetic */ DDNodeOperationConfig copy$default(DDNodeOperationConfig dDNodeOperationConfig, Boolean bool, String str, Boolean bool2, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = dDNodeOperationConfig.ignoreCase;
        }
        if ((i & 2) != 0) {
            str = dDNodeOperationConfig.separator;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            bool2 = dDNodeOperationConfig.isNumericRange;
        }
        Boolean bool3 = bool2;
        if ((i & 8) != 0) {
            str2 = dDNodeOperationConfig.repeatModeRaw;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            num = dDNodeOperationConfig.comparatorTypeRaw;
        }
        return dDNodeOperationConfig.copy(bool, str3, bool3, str4, num);
    }

    @SerialName(FreeDataImpKt.ISP_FLAG_CT)
    private static /* synthetic */ void getComparatorTypeRaw$annotations() {
    }

    @SerialName("ic")
    public static /* synthetic */ void getIgnoreCase$annotations() {
    }

    @SerialName("rm")
    private static /* synthetic */ void getRepeatModeRaw$annotations() {
    }

    @SerialName("d")
    public static /* synthetic */ void getSeparator$annotations() {
    }

    @SerialName("nr")
    public static /* synthetic */ void isNumericRange$annotations() {
    }

    public final Boolean component1() {
        return this.ignoreCase;
    }

    public final String component2() {
        return this.separator;
    }

    public final Boolean component3() {
        return this.isNumericRange;
    }

    public final DDNodeOperationConfig copy(Boolean bool, String str, Boolean bool2, String str2, Integer num) {
        return new DDNodeOperationConfig(bool, str, bool2, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DDNodeOperationConfig) {
            DDNodeOperationConfig dDNodeOperationConfig = (DDNodeOperationConfig) obj;
            return Intrinsics.areEqual(this.ignoreCase, dDNodeOperationConfig.ignoreCase) && Intrinsics.areEqual(this.separator, dDNodeOperationConfig.separator) && Intrinsics.areEqual(this.isNumericRange, dDNodeOperationConfig.isNumericRange) && Intrinsics.areEqual(this.repeatModeRaw, dDNodeOperationConfig.repeatModeRaw) && Intrinsics.areEqual(this.comparatorTypeRaw, dDNodeOperationConfig.comparatorTypeRaw);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.ignoreCase == null ? 0 : this.ignoreCase.hashCode()) * 31) + (this.separator == null ? 0 : this.separator.hashCode())) * 31) + (this.isNumericRange == null ? 0 : this.isNumericRange.hashCode())) * 31) + (this.repeatModeRaw == null ? 0 : this.repeatModeRaw.hashCode())) * 31) + (this.comparatorTypeRaw != null ? this.comparatorTypeRaw.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.ignoreCase;
        String str = this.separator;
        Boolean bool2 = this.isNumericRange;
        String str2 = this.repeatModeRaw;
        return "DDNodeOperationConfig(ignoreCase=" + bool + ", separator=" + str + ", isNumericRange=" + bool2 + ", repeatModeRaw=" + str2 + ", comparatorTypeRaw=" + this.comparatorTypeRaw + ")";
    }

    /* compiled from: DDModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DDNodeOperationConfig> serializer() {
            return new GeneratedSerializer<DDNodeOperationConfig>() { // from class: kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.dd.impl.internal.model.DDNodeOperationConfig", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDNodeOperationConfig> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDNodeOperationConfig> A[REMOVE]) =  kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer.INSTANCE kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer)
                         in method: kntr.base.dd.impl.internal.model.DDNodeOperationConfig.Companion.serializer():kotlinx.serialization.KSerializer<kntr.base.dd.impl.internal.model.DDNodeOperationConfig>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.base.dd.impl.internal.model.DDNodeOperationConfig")
                          (wrap: kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer : 0x0009: SGET  (r1v0 kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer A[REMOVE]) =  kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer.INSTANCE kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer)
                          (5 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer
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
                        kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer r0 = kntr.base.dd.impl.internal.model.DDNodeOperationConfig$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.base.dd.impl.internal.model.DDNodeOperationConfig.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ DDNodeOperationConfig(int seen0, Boolean ignoreCase, String separator, Boolean isNumericRange, String repeatModeRaw, Integer comparatorTypeRaw, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.ignoreCase = null;
                } else {
                    this.ignoreCase = ignoreCase;
                }
                if ((seen0 & 2) == 0) {
                    this.separator = null;
                } else {
                    this.separator = separator;
                }
                if ((seen0 & 4) == 0) {
                    this.isNumericRange = null;
                } else {
                    this.isNumericRange = isNumericRange;
                }
                if ((seen0 & 8) == 0) {
                    this.repeatModeRaw = null;
                } else {
                    this.repeatModeRaw = repeatModeRaw;
                }
                if ((seen0 & 16) == 0) {
                    this.comparatorTypeRaw = null;
                } else {
                    this.comparatorTypeRaw = comparatorTypeRaw;
                }
            }

            public DDNodeOperationConfig(Boolean ignoreCase, String separator, Boolean isNumericRange, String repeatModeRaw, Integer comparatorTypeRaw) {
                this.ignoreCase = ignoreCase;
                this.separator = separator;
                this.isNumericRange = isNumericRange;
                this.repeatModeRaw = repeatModeRaw;
                this.comparatorTypeRaw = comparatorTypeRaw;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$impl_debug(DDNodeOperationConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ignoreCase != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.ignoreCase);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.separator != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.separator);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.isNumericRange != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.isNumericRange);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.repeatModeRaw != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.repeatModeRaw);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.comparatorTypeRaw != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.comparatorTypeRaw);
                }
            }

            public /* synthetic */ DDNodeOperationConfig(Boolean bool, String str, Boolean bool2, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num);
            }

            public final Boolean getIgnoreCase() {
                return this.ignoreCase;
            }

            public final String getSeparator() {
                return this.separator;
            }

            public final Boolean isNumericRange() {
                return this.isNumericRange;
            }

            public final RepeatMode getRepeatMode() {
                String it = this.repeatModeRaw;
                if (it != null) {
                    RepeatMode.Companion companion = RepeatMode.Companion;
                    String lowerCase = it.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    return companion.from(lowerCase);
                }
                return null;
            }

            public final ComparatorType getComparatorType() {
                Integer num = this.comparatorTypeRaw;
                if (num != null) {
                    int it = num.intValue();
                    ComparatorType from = ComparatorType.Companion.from(it);
                    if (from != null) {
                        return from;
                    }
                }
                return ComparatorType.Default;
            }

            /* compiled from: DDModel.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;", "", "raw", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "Year", "Month", "Week", "Day", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public enum RepeatMode {
                Year("y"),
                Month("m"),
                Week("e"),
                Day("d");
                
                private final String raw;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
                public static final Companion Companion = new Companion(null);

                public static EnumEntries<RepeatMode> getEntries() {
                    return $ENTRIES;
                }

                RepeatMode(String raw) {
                    this.raw = raw;
                }

                public final String getRaw() {
                    return this.raw;
                }

                /* compiled from: DDModel.kt */
                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode$Companion;", "", "<init>", "()V", "from", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$RepeatMode;", "raw", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final RepeatMode from(String raw) {
                        Object obj;
                        Intrinsics.checkNotNullParameter(raw, "raw");
                        Iterator it = RepeatMode.getEntries().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            RepeatMode it2 = (RepeatMode) obj;
                            if (Intrinsics.areEqual(it2.getRaw(), raw)) {
                                break;
                            }
                        }
                        return (RepeatMode) obj;
                    }
                }
            }

            /* compiled from: DDModel.kt */
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$ComparatorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "DefaultVersion", "Companion", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
            /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
            public enum ComparatorType {
                Default(0),
                DefaultVersion(1);
                
                private final int value;
                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
                public static final Companion Companion = new Companion(null);

                public static EnumEntries<ComparatorType> getEntries() {
                    return $ENTRIES;
                }

                ComparatorType(int value) {
                    this.value = value;
                }

                public final int getValue() {
                    return this.value;
                }

                /* compiled from: DDModel.kt */
                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$ComparatorType$Companion;", "", "<init>", "()V", "from", "Lkntr/base/dd/impl/internal/model/DDNodeOperationConfig$ComparatorType;", "value", "", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
                /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
                public static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }

                    public final ComparatorType from(int value) {
                        Object obj;
                        boolean z;
                        Iterator it = ComparatorType.getEntries().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            ComparatorType it2 = (ComparatorType) obj;
                            if (it2.getValue() == value) {
                                z = true;
                                continue;
                            } else {
                                z = false;
                                continue;
                            }
                            if (z) {
                                break;
                            }
                        }
                        return (ComparatorType) obj;
                    }
                }
            }
        }