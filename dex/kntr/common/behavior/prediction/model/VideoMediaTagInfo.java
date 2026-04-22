package kntr.common.behavior.prediction.model;

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

/* compiled from: VideoMediaTagInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 >2\u00020\u0001:\u0002=>Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBu\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001J%\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u0014\u001a\u0004\b$\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016¨\u0006?"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoMediaTagInfo;", "", "negativeCommentCnt", "", "neutralCommentCnt", "positiveCommentCnt", "totalCommentCnt", "tendencyCommentRatio", "qualityTag", "tidName", "subTidName", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNegativeCommentCnt$annotations", "()V", "getNegativeCommentCnt", "()Ljava/lang/String;", "getNeutralCommentCnt$annotations", "getNeutralCommentCnt", "getPositiveCommentCnt$annotations", "getPositiveCommentCnt", "getTotalCommentCnt$annotations", "getTotalCommentCnt", "getTendencyCommentRatio$annotations", "getTendencyCommentRatio", "getQualityTag$annotations", "getQualityTag", "getTidName$annotations", "getTidName", "getSubTidName$annotations", "getSubTidName", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$behavior_prediction_debug", "$serializer", "Companion", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class VideoMediaTagInfo {
    public static final Companion Companion = new Companion(null);
    private final String negativeCommentCnt;
    private final String neutralCommentCnt;
    private final String positiveCommentCnt;
    private final String qualityTag;
    private final String subTidName;
    private final String tendencyCommentRatio;
    private final String tidName;
    private final String title;
    private final String totalCommentCnt;

    public VideoMediaTagInfo() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 511, (DefaultConstructorMarker) null);
    }

    @SerialName("negative_comment_cnt")
    public static /* synthetic */ void getNegativeCommentCnt$annotations() {
    }

    @SerialName("neutral_comment_cnt")
    public static /* synthetic */ void getNeutralCommentCnt$annotations() {
    }

    @SerialName("positive_comment_cnt")
    public static /* synthetic */ void getPositiveCommentCnt$annotations() {
    }

    @SerialName("quality_tag")
    public static /* synthetic */ void getQualityTag$annotations() {
    }

    @SerialName("sub_tid_name")
    public static /* synthetic */ void getSubTidName$annotations() {
    }

    @SerialName("tendency_comment_ratio")
    public static /* synthetic */ void getTendencyCommentRatio$annotations() {
    }

    @SerialName("tid_name")
    public static /* synthetic */ void getTidName$annotations() {
    }

    @SerialName("total_comment_cnt")
    public static /* synthetic */ void getTotalCommentCnt$annotations() {
    }

    public final String component1() {
        return this.negativeCommentCnt;
    }

    public final String component2() {
        return this.neutralCommentCnt;
    }

    public final String component3() {
        return this.positiveCommentCnt;
    }

    public final String component4() {
        return this.totalCommentCnt;
    }

    public final String component5() {
        return this.tendencyCommentRatio;
    }

    public final String component6() {
        return this.qualityTag;
    }

    public final String component7() {
        return this.tidName;
    }

    public final String component8() {
        return this.subTidName;
    }

    public final String component9() {
        return this.title;
    }

    public final VideoMediaTagInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return new VideoMediaTagInfo(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoMediaTagInfo) {
            VideoMediaTagInfo videoMediaTagInfo = (VideoMediaTagInfo) obj;
            return Intrinsics.areEqual(this.negativeCommentCnt, videoMediaTagInfo.negativeCommentCnt) && Intrinsics.areEqual(this.neutralCommentCnt, videoMediaTagInfo.neutralCommentCnt) && Intrinsics.areEqual(this.positiveCommentCnt, videoMediaTagInfo.positiveCommentCnt) && Intrinsics.areEqual(this.totalCommentCnt, videoMediaTagInfo.totalCommentCnt) && Intrinsics.areEqual(this.tendencyCommentRatio, videoMediaTagInfo.tendencyCommentRatio) && Intrinsics.areEqual(this.qualityTag, videoMediaTagInfo.qualityTag) && Intrinsics.areEqual(this.tidName, videoMediaTagInfo.tidName) && Intrinsics.areEqual(this.subTidName, videoMediaTagInfo.subTidName) && Intrinsics.areEqual(this.title, videoMediaTagInfo.title);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.negativeCommentCnt == null ? 0 : this.negativeCommentCnt.hashCode()) * 31) + (this.neutralCommentCnt == null ? 0 : this.neutralCommentCnt.hashCode())) * 31) + (this.positiveCommentCnt == null ? 0 : this.positiveCommentCnt.hashCode())) * 31) + (this.totalCommentCnt == null ? 0 : this.totalCommentCnt.hashCode())) * 31) + (this.tendencyCommentRatio == null ? 0 : this.tendencyCommentRatio.hashCode())) * 31) + (this.qualityTag == null ? 0 : this.qualityTag.hashCode())) * 31) + (this.tidName == null ? 0 : this.tidName.hashCode())) * 31) + (this.subTidName == null ? 0 : this.subTidName.hashCode())) * 31) + (this.title != null ? this.title.hashCode() : 0);
    }

    public String toString() {
        String str = this.negativeCommentCnt;
        String str2 = this.neutralCommentCnt;
        String str3 = this.positiveCommentCnt;
        String str4 = this.totalCommentCnt;
        String str5 = this.tendencyCommentRatio;
        String str6 = this.qualityTag;
        String str7 = this.tidName;
        String str8 = this.subTidName;
        return "VideoMediaTagInfo(negativeCommentCnt=" + str + ", neutralCommentCnt=" + str2 + ", positiveCommentCnt=" + str3 + ", totalCommentCnt=" + str4 + ", tendencyCommentRatio=" + str5 + ", qualityTag=" + str6 + ", tidName=" + str7 + ", subTidName=" + str8 + ", title=" + this.title + ")";
    }

    /* compiled from: VideoMediaTagInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/behavior/prediction/model/VideoMediaTagInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/behavior/prediction/model/VideoMediaTagInfo;", "behavior-prediction_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoMediaTagInfo> serializer() {
            return new GeneratedSerializer<VideoMediaTagInfo>() { // from class: kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.behavior.prediction.model.VideoMediaTagInfo", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoMediaTagInfo> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoMediaTagInfo> A[REMOVE]) =  kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer.INSTANCE kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer)
                         in method: kntr.common.behavior.prediction.model.VideoMediaTagInfo.Companion.serializer():kotlinx.serialization.KSerializer<kntr.common.behavior.prediction.model.VideoMediaTagInfo>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.common.behavior.prediction.model.VideoMediaTagInfo")
                          (wrap: kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer : 0x0009: SGET  (r1v0 kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer A[REMOVE]) =  kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer.INSTANCE kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer)
                          (9 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer
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
                        kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer r0 = kntr.common.behavior.prediction.model.VideoMediaTagInfo$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.common.behavior.prediction.model.VideoMediaTagInfo.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ VideoMediaTagInfo(int seen0, String negativeCommentCnt, String neutralCommentCnt, String positiveCommentCnt, String totalCommentCnt, String tendencyCommentRatio, String qualityTag, String tidName, String subTidName, String title, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.negativeCommentCnt = null;
                } else {
                    this.negativeCommentCnt = negativeCommentCnt;
                }
                if ((seen0 & 2) == 0) {
                    this.neutralCommentCnt = null;
                } else {
                    this.neutralCommentCnt = neutralCommentCnt;
                }
                if ((seen0 & 4) == 0) {
                    this.positiveCommentCnt = null;
                } else {
                    this.positiveCommentCnt = positiveCommentCnt;
                }
                if ((seen0 & 8) == 0) {
                    this.totalCommentCnt = null;
                } else {
                    this.totalCommentCnt = totalCommentCnt;
                }
                if ((seen0 & 16) == 0) {
                    this.tendencyCommentRatio = null;
                } else {
                    this.tendencyCommentRatio = tendencyCommentRatio;
                }
                if ((seen0 & 32) == 0) {
                    this.qualityTag = null;
                } else {
                    this.qualityTag = qualityTag;
                }
                if ((seen0 & 64) == 0) {
                    this.tidName = null;
                } else {
                    this.tidName = tidName;
                }
                if ((seen0 & 128) == 0) {
                    this.subTidName = null;
                } else {
                    this.subTidName = subTidName;
                }
                if ((seen0 & 256) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
            }

            public VideoMediaTagInfo(String negativeCommentCnt, String neutralCommentCnt, String positiveCommentCnt, String totalCommentCnt, String tendencyCommentRatio, String qualityTag, String tidName, String subTidName, String title) {
                this.negativeCommentCnt = negativeCommentCnt;
                this.neutralCommentCnt = neutralCommentCnt;
                this.positiveCommentCnt = positiveCommentCnt;
                this.totalCommentCnt = totalCommentCnt;
                this.tendencyCommentRatio = tendencyCommentRatio;
                this.qualityTag = qualityTag;
                this.tidName = tidName;
                this.subTidName = subTidName;
                this.title = title;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$behavior_prediction_debug(VideoMediaTagInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.negativeCommentCnt != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.negativeCommentCnt);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.neutralCommentCnt != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.neutralCommentCnt);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.positiveCommentCnt != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.positiveCommentCnt);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.totalCommentCnt != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.totalCommentCnt);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.tendencyCommentRatio != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.tendencyCommentRatio);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.qualityTag != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.qualityTag);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.tidName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.tidName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.subTidName != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.subTidName);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.title);
                }
            }

            public /* synthetic */ VideoMediaTagInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) == 0 ? str9 : null);
            }

            public final String getNegativeCommentCnt() {
                return this.negativeCommentCnt;
            }

            public final String getNeutralCommentCnt() {
                return this.neutralCommentCnt;
            }

            public final String getPositiveCommentCnt() {
                return this.positiveCommentCnt;
            }

            public final String getTotalCommentCnt() {
                return this.totalCommentCnt;
            }

            public final String getTendencyCommentRatio() {
                return this.tendencyCommentRatio;
            }

            public final String getQualityTag() {
                return this.qualityTag;
            }

            public final String getTidName() {
                return this.tidName;
            }

            public final String getSubTidName() {
                return this.subTidName;
            }

            public final String getTitle() {
                return this.title;
            }
        }