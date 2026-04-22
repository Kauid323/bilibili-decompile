package tv.danmaku.bili.ui.main2.mine;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import tv.danmaku.bili.BR;

/* compiled from: DisplayStrategyUtils.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002./B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\fJ\u0006\u0010\u001b\u001a\u00020\u001cJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J'\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u001cHÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R$\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u00060"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/DisplayedInfo;", "", "times", "", "startTime", "", "type", "<init>", "(IJI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIJILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTimes$annotations", "()V", "getTimes", "()I", "setTimes", "(I)V", "getStartTime$annotations", "getStartTime", "()J", "setStartTime", "(J)V", "getType$annotations", "getType", "setType", "toJsonString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_apinkDebug", "Companion", "$serializer", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Serializable
public final class DisplayedInfo {
    private long startTime;
    private int times;
    private int type;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public DisplayedInfo() {
        this(0, 0L, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DisplayedInfo copy$default(DisplayedInfo displayedInfo, int i, long j, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = displayedInfo.times;
        }
        if ((i3 & 2) != 0) {
            j = displayedInfo.startTime;
        }
        if ((i3 & 4) != 0) {
            i2 = displayedInfo.type;
        }
        return displayedInfo.copy(i, j, i2);
    }

    @SerialName("b")
    public static /* synthetic */ void getStartTime$annotations() {
    }

    @SerialName("a")
    public static /* synthetic */ void getTimes$annotations() {
    }

    @SerialName("c")
    public static /* synthetic */ void getType$annotations() {
    }

    public final int component1() {
        return this.times;
    }

    public final long component2() {
        return this.startTime;
    }

    public final int component3() {
        return this.type;
    }

    public final DisplayedInfo copy(int i, long j, int i2) {
        return new DisplayedInfo(i, j, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayedInfo) {
            DisplayedInfo displayedInfo = (DisplayedInfo) obj;
            return this.times == displayedInfo.times && this.startTime == displayedInfo.startTime && this.type == displayedInfo.type;
        }
        return false;
    }

    public int hashCode() {
        return (((this.times * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.startTime)) * 31) + this.type;
    }

    public String toString() {
        int i = this.times;
        long j = this.startTime;
        return "DisplayedInfo(times=" + i + ", startTime=" + j + ", type=" + this.type + ")";
    }

    public /* synthetic */ DisplayedInfo(int seen0, int times, long startTime, int type, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.times = 0;
        } else {
            this.times = times;
        }
        if ((seen0 & 2) == 0) {
            this.startTime = 0L;
        } else {
            this.startTime = startTime;
        }
        if ((seen0 & 4) == 0) {
            this.type = 0;
        } else {
            this.type = type;
        }
    }

    public DisplayedInfo(int times, long startTime, int type) {
        this.times = times;
        this.startTime = startTime;
        this.type = type;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_apinkDebug(DisplayedInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.times != 0) {
            output.encodeIntElement(serialDesc, 0, self.times);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startTime != 0) {
            output.encodeLongElement(serialDesc, 1, self.startTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.type != 0) {
            output.encodeIntElement(serialDesc, 2, self.type);
        }
    }

    public /* synthetic */ DisplayedInfo(int i, long j, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0L : j, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getTimes() {
        return this.times;
    }

    public final void setTimes(int i) {
        this.times = i;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    /* compiled from: DisplayStrategyUtils.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00050\tJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/DisplayedInfo$Companion;", "", "<init>", "()V", "fromJsonString", "Ltv/danmaku/bili/ui/main2/mine/DisplayedInfo;", "string", "", "listFromJsonString", "", "toJsonString", "serializer", "Lkotlinx/serialization/KSerializer;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DisplayedInfo> serializer() {
            return new GeneratedSerializer<DisplayedInfo>() { // from class: tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("tv.danmaku.bili.ui.main2.mine.DisplayedInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<tv.danmaku.bili.ui.main2.mine.DisplayedInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<tv.danmaku.bili.ui.main2.mine.DisplayedInfo> A[REMOVE]) =  tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer.INSTANCE tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer)
                         in method: tv.danmaku.bili.ui.main2.mine.DisplayedInfo.Companion.serializer():kotlinx.serialization.KSerializer<tv.danmaku.bili.ui.main2.mine.DisplayedInfo>, file: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex
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
                          ("tv.danmaku.bili.ui.main2.mine.DisplayedInfo")
                          (wrap: tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer : 0x0009: SGET  (r1v0 tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer A[REMOVE]) =  tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer.INSTANCE tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer.<clinit>():void, file: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer
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
                        tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer r0 = tv.danmaku.bili.ui.main2.mine.DisplayedInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: tv.danmaku.bili.ui.main2.mine.DisplayedInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }

                public final DisplayedInfo fromJsonString(String string) {
                    Json this_$iv;
                    Intrinsics.checkNotNullParameter(string, "string");
                    this_$iv = DisplayStrategyUtilsKt.displayInfoJson;
                    this_$iv.getSerializersModule();
                    return (DisplayedInfo) this_$iv.decodeFromString(DisplayedInfo.Companion.serializer(), string);
                }

                public final List<DisplayedInfo> listFromJsonString(String string) {
                    Json this_$iv;
                    Intrinsics.checkNotNullParameter(string, "string");
                    this_$iv = DisplayStrategyUtilsKt.displayInfoJson;
                    this_$iv.getSerializersModule();
                    return (List) this_$iv.decodeFromString(new ArrayListSerializer(DisplayedInfo.Companion.serializer()), string);
                }

                public final String toJsonString(List<DisplayedInfo> list) {
                    StringFormat stringFormat;
                    Intrinsics.checkNotNullParameter(list, "<this>");
                    stringFormat = DisplayStrategyUtilsKt.displayInfoJson;
                    StringFormat $this$encodeToString$iv = stringFormat;
                    $this$encodeToString$iv.getSerializersModule();
                    return $this$encodeToString$iv.encodeToString(new ArrayListSerializer(DisplayedInfo.Companion.serializer()), list);
                }
            }

            public final String toJsonString() {
                StringFormat stringFormat;
                stringFormat = DisplayStrategyUtilsKt.displayInfoJson;
                StringFormat $this$encodeToString$iv = stringFormat;
                $this$encodeToString$iv.getSerializersModule();
                return $this$encodeToString$iv.encodeToString(Companion.serializer(), this);
            }
        }