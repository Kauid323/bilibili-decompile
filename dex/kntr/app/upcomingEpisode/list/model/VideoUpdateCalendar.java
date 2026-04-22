package kntr.app.upcomingEpisode.list.model;

import BottomSheetItemData$;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: VideoUploadCalendar.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNBw\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012B{\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\u0017\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010;\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010<\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u0010HÆ\u0003J~\u0010?\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00102\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\bHÖ\u0001J\t\u0010D\u001a\u00020\u0004HÖ\u0001J%\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\bLR*\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0018\u001a\u0004\b\u001f\u0010\u001dR \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010#\u0012\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0018\u001a\u0004\b%\u0010\u001dR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010(R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010\u0018\u001a\u0004\b*\u0010+R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010.\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010+R\u0013\u00100\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b1\u0010+R\u0019\u00102\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b3\u0010(R\u0011\u00104\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b5\u00106¨\u0006O"}, d2 = {"Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "", "reportParams", "", "", "title", "trackInfo", "type", "", "url", "unpublishedVideoList", "", "Lkntr/app/upcomingEpisode/list/model/UnpublishedVideo;", "unwatchedVideo", "Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "pageVisible", "", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getReportParams$annotations", "()V", "getReportParams", "()Ljava/util/Map;", "getTitle$annotations", "getTitle", "()Ljava/lang/String;", "getTrackInfo$annotations", "getTrackInfo", "getType$annotations", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl$annotations", "getUrl", "getUnpublishedVideoList$annotations", "getUnpublishedVideoList", "()Ljava/util/List;", "getUnwatchedVideo$annotations", "getUnwatchedVideo", "()Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "getPageVisible", "()Z", "ugc", "getUgc", "ogv", "getOgv", "unpublished", "getUnpublished", "heightDp", "getHeightDp", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;Z)Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$main_debug", "$serializer", "Companion", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class VideoUpdateCalendar {
    private final boolean pageVisible;
    private final Map<String, String> reportParams;
    private final String title;
    private final String trackInfo;
    private final Integer type;
    private final List<UnpublishedVideo> unpublishedVideoList;
    private final UnwatchedVideo unwatchedVideo;
    private final String url;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = VideoUpdateCalendar._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = VideoUpdateCalendar._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), null, null};

    public VideoUpdateCalendar() {
        this((Map) null, (String) null, (String) null, (Integer) null, (String) null, (List) null, (UnwatchedVideo) null, false, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    @SerialName("report_params")
    public static /* synthetic */ void getReportParams$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    @SerialName("track_info")
    public static /* synthetic */ void getTrackInfo$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("unpublished_video_list")
    public static /* synthetic */ void getUnpublishedVideoList$annotations() {
    }

    @SerialName("unwatched_video")
    public static /* synthetic */ void getUnwatchedVideo$annotations() {
    }

    @SerialName("url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    public final Map<String, String> component1() {
        return this.reportParams;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.trackInfo;
    }

    public final Integer component4() {
        return this.type;
    }

    public final String component5() {
        return this.url;
    }

    public final List<UnpublishedVideo> component6() {
        return this.unpublishedVideoList;
    }

    public final UnwatchedVideo component7() {
        return this.unwatchedVideo;
    }

    public final boolean component8() {
        return this.pageVisible;
    }

    public final VideoUpdateCalendar copy(Map<String, String> map, String str, String str2, Integer num, String str3, List<UnpublishedVideo> list, UnwatchedVideo unwatchedVideo, boolean z) {
        return new VideoUpdateCalendar(map, str, str2, num, str3, list, unwatchedVideo, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoUpdateCalendar) {
            VideoUpdateCalendar videoUpdateCalendar = (VideoUpdateCalendar) obj;
            return Intrinsics.areEqual(this.reportParams, videoUpdateCalendar.reportParams) && Intrinsics.areEqual(this.title, videoUpdateCalendar.title) && Intrinsics.areEqual(this.trackInfo, videoUpdateCalendar.trackInfo) && Intrinsics.areEqual(this.type, videoUpdateCalendar.type) && Intrinsics.areEqual(this.url, videoUpdateCalendar.url) && Intrinsics.areEqual(this.unpublishedVideoList, videoUpdateCalendar.unpublishedVideoList) && Intrinsics.areEqual(this.unwatchedVideo, videoUpdateCalendar.unwatchedVideo) && this.pageVisible == videoUpdateCalendar.pageVisible;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.reportParams == null ? 0 : this.reportParams.hashCode()) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.trackInfo == null ? 0 : this.trackInfo.hashCode())) * 31) + (this.type == null ? 0 : this.type.hashCode())) * 31) + (this.url == null ? 0 : this.url.hashCode())) * 31) + (this.unpublishedVideoList == null ? 0 : this.unpublishedVideoList.hashCode())) * 31) + (this.unwatchedVideo != null ? this.unwatchedVideo.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.pageVisible);
    }

    public String toString() {
        Map<String, String> map = this.reportParams;
        String str = this.title;
        String str2 = this.trackInfo;
        Integer num = this.type;
        String str3 = this.url;
        List<UnpublishedVideo> list = this.unpublishedVideoList;
        UnwatchedVideo unwatchedVideo = this.unwatchedVideo;
        return "VideoUpdateCalendar(reportParams=" + map + ", title=" + str + ", trackInfo=" + str2 + ", type=" + num + ", url=" + str3 + ", unpublishedVideoList=" + list + ", unwatchedVideo=" + unwatchedVideo + ", pageVisible=" + this.pageVisible + ")";
    }

    /* compiled from: VideoUploadCalendar.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoUpdateCalendar> serializer() {
            return new GeneratedSerializer<VideoUpdateCalendar>() { // from class: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar> A[REMOVE]) =  kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer.INSTANCE kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer)
                         in method: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar.Companion.serializer():kotlinx.serialization.KSerializer<kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar")
                          (wrap: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer : 0x0009: SGET  (r1v0 kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer A[REMOVE]) =  kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer.INSTANCE kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer)
                          (8 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer
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
                        kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer r0 = kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ VideoUpdateCalendar(int seen0, Map reportParams, String title, String trackInfo, Integer type, String url, List unpublishedVideoList, UnwatchedVideo unwatchedVideo, boolean pageVisible, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.reportParams = null;
                } else {
                    this.reportParams = reportParams;
                }
                if ((seen0 & 2) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
                if ((seen0 & 4) == 0) {
                    this.trackInfo = null;
                } else {
                    this.trackInfo = trackInfo;
                }
                if ((seen0 & 8) == 0) {
                    this.type = null;
                } else {
                    this.type = type;
                }
                if ((seen0 & 16) == 0) {
                    this.url = null;
                } else {
                    this.url = url;
                }
                if ((seen0 & 32) == 0) {
                    this.unpublishedVideoList = null;
                } else {
                    this.unpublishedVideoList = unpublishedVideoList;
                }
                if ((seen0 & 64) == 0) {
                    this.unwatchedVideo = null;
                } else {
                    this.unwatchedVideo = unwatchedVideo;
                }
                if ((seen0 & 128) == 0) {
                    this.pageVisible = false;
                } else {
                    this.pageVisible = pageVisible;
                }
            }

            public VideoUpdateCalendar(Map<String, String> map, String title, String trackInfo, Integer type, String url, List<UnpublishedVideo> list, UnwatchedVideo unwatchedVideo, boolean pageVisible) {
                this.reportParams = map;
                this.title = title;
                this.trackInfo = trackInfo;
                this.type = type;
                this.url = url;
                this.unpublishedVideoList = list;
                this.unwatchedVideo = unwatchedVideo;
                this.pageVisible = pageVisible;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(UnpublishedVideo$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$main_debug(VideoUpdateCalendar self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.reportParams != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.reportParams);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.trackInfo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.trackInfo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.type != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.type);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.url != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.url);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.unpublishedVideoList != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, lazyArr[5].getValue(), self.unpublishedVideoList);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.unwatchedVideo != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, UnwatchedVideo$$serializer.INSTANCE, self.unwatchedVideo);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.pageVisible) {
                    output.encodeBooleanElement(serialDesc, 7, self.pageVisible);
                }
            }

            public /* synthetic */ VideoUpdateCalendar(Map map, String str, String str2, Integer num, String str3, List list, UnwatchedVideo unwatchedVideo, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : list, (i & 64) == 0 ? unwatchedVideo : null, (i & 128) != 0 ? false : z);
            }

            public final Map<String, String> getReportParams() {
                return this.reportParams;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getTrackInfo() {
                return this.trackInfo;
            }

            public final Integer getType() {
                return this.type;
            }

            public final String getUrl() {
                return this.url;
            }

            public final List<UnpublishedVideo> getUnpublishedVideoList() {
                return this.unpublishedVideoList;
            }

            public final UnwatchedVideo getUnwatchedVideo() {
                return this.unwatchedVideo;
            }

            public final boolean getPageVisible() {
                return this.pageVisible;
            }

            /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
                if (r3.intValue() == 1) goto L5;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final UnwatchedVideo getUgc() {
                UnwatchedVideo unwatchedVideo = this.unwatchedVideo;
                Integer num = this.type;
                boolean z = num != null;
                if (z) {
                    return unwatchedVideo;
                }
                return null;
            }

            public final UnwatchedVideo getOgv() {
                UnwatchedVideo unwatchedVideo = this.unwatchedVideo;
                Integer num = this.type;
                if (num != null && num.intValue() == 2) {
                    return unwatchedVideo;
                }
                return null;
            }

            public final List<UnpublishedVideo> getUnpublished() {
                List<UnpublishedVideo> list = this.unpublishedVideoList;
                Integer num = this.type;
                if (num != null && num.intValue() == 3) {
                    return list;
                }
                return null;
            }

            public final int getHeightDp() {
                int itemCount = 1;
                int height = 42;
                if (getUgc() != null) {
                    itemCount = 1 + 1;
                    height = 42 + 65;
                }
                if (getOgv() != null) {
                    itemCount++;
                    height += 64;
                }
                if (getUnpublished() != null) {
                    itemCount++;
                    List<UnpublishedVideo> unpublished = getUnpublished();
                    int unpublishedSize = unpublished != null ? unpublished.size() : 0;
                    height += RangesKt.coerceAtLeast((unpublishedSize * 20) + ((unpublishedSize - 1) * 10), 0);
                }
                return height + ((itemCount - 1) * 10);
            }
        }