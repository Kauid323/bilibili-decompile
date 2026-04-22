package kntr.common.behavior.prediction.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: VideoQualityDeviceActionInfo.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 B2\u00020\u0001:\u0002ABBa\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fBm\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u00100\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010#J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003Jh\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0007HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001J%\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0002\b@R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u001eR \u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b!\u0010\u0015\u001a\u0004\b\"\u0010#R \u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010$\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010#R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0015\u001a\u0004\b(\u0010)¨\u0006C"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;", "", "wifiTag", "", "mobileTag", "vipTag", "wifiMaxQn", "", "mobileMaxQn", "lstmWifiMaxQn", "lstmMobileMaxQn", "recentSwitches", "", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceSwitchInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getWifiTag$annotations", "()V", "getWifiTag", "()Ljava/lang/String;", "getMobileTag$annotations", "getMobileTag", "getVipTag$annotations", "getVipTag", "getWifiMaxQn$annotations", "getWifiMaxQn", "()I", "getMobileMaxQn$annotations", "getMobileMaxQn", "getLstmWifiMaxQn$annotations", "getLstmWifiMaxQn", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLstmMobileMaxQn$annotations", "getLstmMobileMaxQn", "getRecentSwitches$annotations", "getRecentSwitches", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;)Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$behavior_prediction_debug", "$serializer", "Companion", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class VideoQualityDeviceActionInfo {
    private final Integer lstmMobileMaxQn;
    private final Integer lstmWifiMaxQn;
    private final int mobileMaxQn;
    private final String mobileTag;
    private final List<VideoQualityDeviceSwitchInfo> recentSwitches;
    private final String vipTag;
    private final int wifiMaxQn;
    private final String wifiTag;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, null, null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = VideoQualityDeviceActionInfo._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public VideoQualityDeviceActionInfo() {
        this((String) null, (String) null, (String) null, 0, 0, (Integer) null, (Integer) null, (List) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VideoQualityDeviceActionInfo copy$default(VideoQualityDeviceActionInfo videoQualityDeviceActionInfo, String str, String str2, String str3, int i, int i2, Integer num, Integer num2, List list, int i3, Object obj) {
        return videoQualityDeviceActionInfo.copy((i3 & 1) != 0 ? videoQualityDeviceActionInfo.wifiTag : str, (i3 & 2) != 0 ? videoQualityDeviceActionInfo.mobileTag : str2, (i3 & 4) != 0 ? videoQualityDeviceActionInfo.vipTag : str3, (i3 & 8) != 0 ? videoQualityDeviceActionInfo.wifiMaxQn : i, (i3 & 16) != 0 ? videoQualityDeviceActionInfo.mobileMaxQn : i2, (i3 & 32) != 0 ? videoQualityDeviceActionInfo.lstmWifiMaxQn : num, (i3 & 64) != 0 ? videoQualityDeviceActionInfo.lstmMobileMaxQn : num2, (i3 & 128) != 0 ? videoQualityDeviceActionInfo.recentSwitches : list);
    }

    @SerialName("lstm_mobile_max_qn")
    public static /* synthetic */ void getLstmMobileMaxQn$annotations() {
    }

    @SerialName("lstm_wifi_max_qn")
    public static /* synthetic */ void getLstmWifiMaxQn$annotations() {
    }

    @SerialName("mobile_max_qn")
    public static /* synthetic */ void getMobileMaxQn$annotations() {
    }

    @SerialName("mobile_tag")
    public static /* synthetic */ void getMobileTag$annotations() {
    }

    @SerialName("recent_switches")
    public static /* synthetic */ void getRecentSwitches$annotations() {
    }

    @SerialName("vip_tag")
    public static /* synthetic */ void getVipTag$annotations() {
    }

    @SerialName("wifi_max_qn")
    public static /* synthetic */ void getWifiMaxQn$annotations() {
    }

    @SerialName("wifi_tag")
    public static /* synthetic */ void getWifiTag$annotations() {
    }

    public final String component1() {
        return this.wifiTag;
    }

    public final String component2() {
        return this.mobileTag;
    }

    public final String component3() {
        return this.vipTag;
    }

    public final int component4() {
        return this.wifiMaxQn;
    }

    public final int component5() {
        return this.mobileMaxQn;
    }

    public final Integer component6() {
        return this.lstmWifiMaxQn;
    }

    public final Integer component7() {
        return this.lstmMobileMaxQn;
    }

    public final List<VideoQualityDeviceSwitchInfo> component8() {
        return this.recentSwitches;
    }

    public final VideoQualityDeviceActionInfo copy(String str, String str2, String str3, int i, int i2, Integer num, Integer num2, List<VideoQualityDeviceSwitchInfo> list) {
        Intrinsics.checkNotNullParameter(str, "wifiTag");
        Intrinsics.checkNotNullParameter(str2, "mobileTag");
        Intrinsics.checkNotNullParameter(str3, "vipTag");
        Intrinsics.checkNotNullParameter(list, "recentSwitches");
        return new VideoQualityDeviceActionInfo(str, str2, str3, i, i2, num, num2, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoQualityDeviceActionInfo) {
            VideoQualityDeviceActionInfo videoQualityDeviceActionInfo = (VideoQualityDeviceActionInfo) obj;
            return Intrinsics.areEqual(this.wifiTag, videoQualityDeviceActionInfo.wifiTag) && Intrinsics.areEqual(this.mobileTag, videoQualityDeviceActionInfo.mobileTag) && Intrinsics.areEqual(this.vipTag, videoQualityDeviceActionInfo.vipTag) && this.wifiMaxQn == videoQualityDeviceActionInfo.wifiMaxQn && this.mobileMaxQn == videoQualityDeviceActionInfo.mobileMaxQn && Intrinsics.areEqual(this.lstmWifiMaxQn, videoQualityDeviceActionInfo.lstmWifiMaxQn) && Intrinsics.areEqual(this.lstmMobileMaxQn, videoQualityDeviceActionInfo.lstmMobileMaxQn) && Intrinsics.areEqual(this.recentSwitches, videoQualityDeviceActionInfo.recentSwitches);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.wifiTag.hashCode() * 31) + this.mobileTag.hashCode()) * 31) + this.vipTag.hashCode()) * 31) + this.wifiMaxQn) * 31) + this.mobileMaxQn) * 31) + (this.lstmWifiMaxQn == null ? 0 : this.lstmWifiMaxQn.hashCode())) * 31) + (this.lstmMobileMaxQn != null ? this.lstmMobileMaxQn.hashCode() : 0)) * 31) + this.recentSwitches.hashCode();
    }

    public String toString() {
        String str = this.wifiTag;
        String str2 = this.mobileTag;
        String str3 = this.vipTag;
        int i = this.wifiMaxQn;
        int i2 = this.mobileMaxQn;
        Integer num = this.lstmWifiMaxQn;
        Integer num2 = this.lstmMobileMaxQn;
        return "VideoQualityDeviceActionInfo(wifiTag=" + str + ", mobileTag=" + str2 + ", vipTag=" + str3 + ", wifiMaxQn=" + i + ", mobileMaxQn=" + i2 + ", lstmWifiMaxQn=" + num + ", lstmMobileMaxQn=" + num2 + ", recentSwitches=" + this.recentSwitches + ")";
    }

    /* compiled from: VideoQualityDeviceActionInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/behavior/prediction/model/VideoQualityDeviceActionInfo;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoQualityDeviceActionInfo> serializer() {
            return new GeneratedSerializer<VideoQualityDeviceActionInfo>() { // from class: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo> A[REMOVE]) =  kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer.INSTANCE kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer)
                         in method: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo.Companion.serializer():kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo")
                          (wrap: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer : 0x0009: SGET  (r1v0 kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer A[REMOVE]) =  kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer.INSTANCE kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer)
                          (8 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer
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
                        kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer r0 = kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.common.behavior.prediction.model.VideoQualityDeviceActionInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ VideoQualityDeviceActionInfo(int seen0, String wifiTag, String mobileTag, String vipTag, int wifiMaxQn, int mobileMaxQn, Integer lstmWifiMaxQn, Integer lstmMobileMaxQn, List recentSwitches, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.wifiTag = "";
                } else {
                    this.wifiTag = wifiTag;
                }
                if ((seen0 & 2) == 0) {
                    this.mobileTag = "";
                } else {
                    this.mobileTag = mobileTag;
                }
                if ((seen0 & 4) == 0) {
                    this.vipTag = "";
                } else {
                    this.vipTag = vipTag;
                }
                if ((seen0 & 8) == 0) {
                    this.wifiMaxQn = 80;
                } else {
                    this.wifiMaxQn = wifiMaxQn;
                }
                if ((seen0 & 16) == 0) {
                    this.mobileMaxQn = 80;
                } else {
                    this.mobileMaxQn = mobileMaxQn;
                }
                if ((seen0 & 32) == 0) {
                    this.lstmWifiMaxQn = null;
                } else {
                    this.lstmWifiMaxQn = lstmWifiMaxQn;
                }
                if ((seen0 & 64) == 0) {
                    this.lstmMobileMaxQn = null;
                } else {
                    this.lstmMobileMaxQn = lstmMobileMaxQn;
                }
                if ((seen0 & 128) == 0) {
                    this.recentSwitches = CollectionsKt.emptyList();
                } else {
                    this.recentSwitches = recentSwitches;
                }
            }

            public VideoQualityDeviceActionInfo(String wifiTag, String mobileTag, String vipTag, int wifiMaxQn, int mobileMaxQn, Integer lstmWifiMaxQn, Integer lstmMobileMaxQn, List<VideoQualityDeviceSwitchInfo> list) {
                Intrinsics.checkNotNullParameter(wifiTag, "wifiTag");
                Intrinsics.checkNotNullParameter(mobileTag, "mobileTag");
                Intrinsics.checkNotNullParameter(vipTag, "vipTag");
                Intrinsics.checkNotNullParameter(list, "recentSwitches");
                this.wifiTag = wifiTag;
                this.mobileTag = mobileTag;
                this.vipTag = vipTag;
                this.wifiMaxQn = wifiMaxQn;
                this.mobileMaxQn = mobileMaxQn;
                this.lstmWifiMaxQn = lstmWifiMaxQn;
                this.lstmMobileMaxQn = lstmMobileMaxQn;
                this.recentSwitches = list;
            }

            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(VideoQualityDeviceSwitchInfo$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$behavior_prediction_debug(VideoQualityDeviceActionInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual(self.wifiTag, "")) {
                    output.encodeStringElement(serialDesc, 0, self.wifiTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.mobileTag, "")) {
                    output.encodeStringElement(serialDesc, 1, self.mobileTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.vipTag, "")) {
                    output.encodeStringElement(serialDesc, 2, self.vipTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.wifiMaxQn != 80) {
                    output.encodeIntElement(serialDesc, 3, self.wifiMaxQn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.mobileMaxQn != 80) {
                    output.encodeIntElement(serialDesc, 4, self.mobileMaxQn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.lstmWifiMaxQn != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.lstmWifiMaxQn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.lstmMobileMaxQn != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.lstmMobileMaxQn);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.recentSwitches, CollectionsKt.emptyList())) {
                    output.encodeSerializableElement(serialDesc, 7, lazyArr[7].getValue(), self.recentSwitches);
                }
            }

            public /* synthetic */ VideoQualityDeviceActionInfo(String str, String str2, String str3, int i, int i2, Integer num, Integer num2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) == 0 ? str3 : "", (i3 & 8) != 0 ? 80 : i, (i3 & 16) == 0 ? i2 : 80, (i3 & 32) != 0 ? null : num, (i3 & 64) == 0 ? num2 : null, (i3 & 128) != 0 ? CollectionsKt.emptyList() : list);
            }

            public final String getWifiTag() {
                return this.wifiTag;
            }

            public final String getMobileTag() {
                return this.mobileTag;
            }

            public final String getVipTag() {
                return this.vipTag;
            }

            public final int getWifiMaxQn() {
                return this.wifiMaxQn;
            }

            public final int getMobileMaxQn() {
                return this.mobileMaxQn;
            }

            public final Integer getLstmWifiMaxQn() {
                return this.lstmWifiMaxQn;
            }

            public final Integer getLstmMobileMaxQn() {
                return this.lstmMobileMaxQn;
            }

            public final List<VideoQualityDeviceSwitchInfo> getRecentSwitches() {
                return this.recentSwitches;
            }
        }