package video.common.sharedata.model;

import io.ktor.http.CodecsKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLUtilsKt;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoShareData.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000201B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u000bHÖ\u0001J\t\u0010'\u001a\u00020\u001cHÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00062"}, d2 = {"Lvideo/common/sharedata/model/VideoShareData;", "", "arcInfo", "Lvideo/common/sharedata/model/VideoShareArcInfo;", "upInfo", "Lvideo/common/sharedata/model/VideoShareUPInfo;", "playInfo", "Lvideo/common/sharedata/model/VideoSharePlayInfo;", "<init>", "(Lvideo/common/sharedata/model/VideoShareArcInfo;Lvideo/common/sharedata/model/VideoShareUPInfo;Lvideo/common/sharedata/model/VideoSharePlayInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILvideo/common/sharedata/model/VideoShareArcInfo;Lvideo/common/sharedata/model/VideoShareUPInfo;Lvideo/common/sharedata/model/VideoSharePlayInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getArcInfo", "()Lvideo/common/sharedata/model/VideoShareArcInfo;", "setArcInfo", "(Lvideo/common/sharedata/model/VideoShareArcInfo;)V", "getUpInfo", "()Lvideo/common/sharedata/model/VideoShareUPInfo;", "setUpInfo", "(Lvideo/common/sharedata/model/VideoShareUPInfo;)V", "getPlayInfo", "()Lvideo/common/sharedata/model/VideoSharePlayInfo;", "setPlayInfo", "(Lvideo/common/sharedata/model/VideoSharePlayInfo;)V", "resolveShareUrl", "", "baseUrl", "resolveShareParam", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$sharedata_debug", "Companion", "$serializer", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class VideoShareData {
    public static final Companion Companion = new Companion(null);
    private VideoShareArcInfo arcInfo;
    private VideoSharePlayInfo playInfo;
    private VideoShareUPInfo upInfo;

    public VideoShareData() {
        this((VideoShareArcInfo) null, (VideoShareUPInfo) null, (VideoSharePlayInfo) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ VideoShareData copy$default(VideoShareData videoShareData, VideoShareArcInfo videoShareArcInfo, VideoShareUPInfo videoShareUPInfo, VideoSharePlayInfo videoSharePlayInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            videoShareArcInfo = videoShareData.arcInfo;
        }
        if ((i & 2) != 0) {
            videoShareUPInfo = videoShareData.upInfo;
        }
        if ((i & 4) != 0) {
            videoSharePlayInfo = videoShareData.playInfo;
        }
        return videoShareData.copy(videoShareArcInfo, videoShareUPInfo, videoSharePlayInfo);
    }

    public final VideoShareArcInfo component1() {
        return this.arcInfo;
    }

    public final VideoShareUPInfo component2() {
        return this.upInfo;
    }

    public final VideoSharePlayInfo component3() {
        return this.playInfo;
    }

    public final VideoShareData copy(VideoShareArcInfo videoShareArcInfo, VideoShareUPInfo videoShareUPInfo, VideoSharePlayInfo videoSharePlayInfo) {
        return new VideoShareData(videoShareArcInfo, videoShareUPInfo, videoSharePlayInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VideoShareData) {
            VideoShareData videoShareData = (VideoShareData) obj;
            return Intrinsics.areEqual(this.arcInfo, videoShareData.arcInfo) && Intrinsics.areEqual(this.upInfo, videoShareData.upInfo) && Intrinsics.areEqual(this.playInfo, videoShareData.playInfo);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.arcInfo == null ? 0 : this.arcInfo.hashCode()) * 31) + (this.upInfo == null ? 0 : this.upInfo.hashCode())) * 31) + (this.playInfo != null ? this.playInfo.hashCode() : 0);
    }

    public String toString() {
        VideoShareArcInfo videoShareArcInfo = this.arcInfo;
        VideoShareUPInfo videoShareUPInfo = this.upInfo;
        return "VideoShareData(arcInfo=" + videoShareArcInfo + ", upInfo=" + videoShareUPInfo + ", playInfo=" + this.playInfo + ")";
    }

    public /* synthetic */ VideoShareData(int seen0, VideoShareArcInfo arcInfo, VideoShareUPInfo upInfo, VideoSharePlayInfo playInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.arcInfo = null;
        } else {
            this.arcInfo = arcInfo;
        }
        if ((seen0 & 2) == 0) {
            this.upInfo = null;
        } else {
            this.upInfo = upInfo;
        }
        if ((seen0 & 4) == 0) {
            this.playInfo = null;
        } else {
            this.playInfo = playInfo;
        }
    }

    public VideoShareData(VideoShareArcInfo arcInfo, VideoShareUPInfo upInfo, VideoSharePlayInfo playInfo) {
        this.arcInfo = arcInfo;
        this.upInfo = upInfo;
        this.playInfo = playInfo;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$sharedata_debug(VideoShareData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.arcInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, VideoShareArcInfo$$serializer.INSTANCE, self.arcInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.upInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, VideoShareUPInfo$$serializer.INSTANCE, self.upInfo);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.playInfo != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, VideoSharePlayInfo$$serializer.INSTANCE, self.playInfo);
        }
    }

    public /* synthetic */ VideoShareData(VideoShareArcInfo videoShareArcInfo, VideoShareUPInfo videoShareUPInfo, VideoSharePlayInfo videoSharePlayInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : videoShareArcInfo, (i & 2) != 0 ? null : videoShareUPInfo, (i & 4) != 0 ? null : videoSharePlayInfo);
    }

    public final VideoShareArcInfo getArcInfo() {
        return this.arcInfo;
    }

    public final void setArcInfo(VideoShareArcInfo videoShareArcInfo) {
        this.arcInfo = videoShareArcInfo;
    }

    public final VideoShareUPInfo getUpInfo() {
        return this.upInfo;
    }

    public final void setUpInfo(VideoShareUPInfo videoShareUPInfo) {
        this.upInfo = videoShareUPInfo;
    }

    public final VideoSharePlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public final void setPlayInfo(VideoSharePlayInfo videoSharePlayInfo) {
        this.playInfo = videoSharePlayInfo;
    }

    /* compiled from: VideoShareData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¨\u0006\r"}, d2 = {"Lvideo/common/sharedata/model/VideoShareData$Companion;", "", "<init>", "()V", "init", "Lvideo/common/sharedata/model/VideoShareData;", "fromRouter", "url", "", "params", "", "serializer", "Lkotlinx/serialization/KSerializer;", "sharedata_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<VideoShareData> serializer() {
            return new GeneratedSerializer<VideoShareData>() { // from class: video.common.sharedata.model.VideoShareData$$serializer
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("video.common.sharedata.model.VideoShareData", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<video.common.sharedata.model.VideoShareData> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<video.common.sharedata.model.VideoShareData> A[REMOVE]) =  video.common.sharedata.model.VideoShareData$$serializer.INSTANCE video.common.sharedata.model.VideoShareData$$serializer)
                         in method: video.common.sharedata.model.VideoShareData.Companion.serializer():kotlinx.serialization.KSerializer<video.common.sharedata.model.VideoShareData>, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                          ("video.common.sharedata.model.VideoShareData")
                          (wrap: video.common.sharedata.model.VideoShareData$$serializer : 0x0009: SGET  (r1v0 video.common.sharedata.model.VideoShareData$$serializer A[REMOVE]) =  video.common.sharedata.model.VideoShareData$$serializer.INSTANCE video.common.sharedata.model.VideoShareData$$serializer)
                          (3 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: video.common.sharedata.model.VideoShareData$$serializer.<clinit>():void, file: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: video.common.sharedata.model.VideoShareData$$serializer
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
                        video.common.sharedata.model.VideoShareData$$serializer r0 = video.common.sharedata.model.VideoShareData$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: video.common.sharedata.model.VideoShareData.Companion.serializer():kotlinx.serialization.KSerializer");
                }

                public final VideoShareData init() {
                    return new VideoShareData((VideoShareArcInfo) null, (VideoShareUPInfo) null, (VideoSharePlayInfo) null, 7, (DefaultConstructorMarker) null);
                }

                public final VideoShareData fromRouter(String url) {
                    String it;
                    Intrinsics.checkNotNullParameter(url, "url");
                    VideoShareData info = new VideoShareData((VideoShareArcInfo) null, (VideoShareUPInfo) null, (VideoSharePlayInfo) null, 7, (DefaultConstructorMarker) null);
                    it = VideoShareDataKt.getQueryParam(url, "preload_info");
                    if (it != null) {
                        VideoShareArcInfo arcInfo = VideoShareArcInfo.Companion.fromJson(it);
                        VideoShareUPInfo upInfo = VideoShareUPInfo.Companion.fromJson(it);
                        info.setArcInfo(arcInfo);
                        info.setUpInfo(upInfo);
                    }
                    return info;
                }

                public final VideoShareData fromRouter(Map<String, String> map) {
                    String it;
                    Intrinsics.checkNotNullParameter(map, "params");
                    VideoShareData info = new VideoShareData((VideoShareArcInfo) null, (VideoShareUPInfo) null, (VideoSharePlayInfo) null, 7, (DefaultConstructorMarker) null);
                    String str = map.get("preload_info");
                    if (str != null && (it = CodecsKt.decodeURLPart$default(str, 0, 0, (Charset) null, 7, (Object) null)) != null) {
                        VideoShareArcInfo arcInfo = VideoShareArcInfo.Companion.fromJson(it);
                        VideoShareUPInfo upInfo = VideoShareUPInfo.Companion.fromJson(it);
                        info.setArcInfo(arcInfo);
                        info.setUpInfo(upInfo);
                    }
                    return info;
                }
            }

            public final String resolveShareUrl(String baseUrl) {
                Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
                URLBuilder $this$resolveShareUrl_u24lambda_u240 = URLUtilsKt.URLBuilder(baseUrl);
                $this$resolveShareUrl_u24lambda_u240.getParameters().append("preload_info", resolveShareParam());
                return $this$resolveShareUrl_u24lambda_u240.build().toString();
            }

            public final String resolveShareParam() {
                JsonObject jsonObject;
                JsonObject jsonObject2;
                JsonObject merged;
                Object $this$toJsonObject$iv = this.upInfo;
                try {
                    Json this_$iv$iv = VideoShareDataKt.json;
                    StringFormat $this$encodeToString$iv$iv = VideoShareDataKt.json;
                    $this$encodeToString$iv$iv.getSerializersModule();
                    String string$iv$iv = $this$encodeToString$iv$iv.encodeToString(BuiltinSerializersKt.getNullable(VideoShareUPInfo.Companion.serializer()), $this$toJsonObject$iv);
                    this_$iv$iv.getSerializersModule();
                    jsonObject = (JsonObject) this_$iv$iv.decodeFromString(JsonObject.Companion.serializer(), string$iv$iv);
                } catch (Exception e) {
                    jsonObject = null;
                }
                JsonObject upJson = jsonObject;
                Object $this$toJsonObject$iv2 = this.arcInfo;
                try {
                    Json this_$iv$iv2 = VideoShareDataKt.json;
                    StringFormat $this$encodeToString$iv$iv2 = VideoShareDataKt.json;
                    $this$encodeToString$iv$iv2.getSerializersModule();
                    String string$iv$iv2 = $this$encodeToString$iv$iv2.encodeToString(BuiltinSerializersKt.getNullable(VideoShareArcInfo.Companion.serializer()), $this$toJsonObject$iv2);
                    this_$iv$iv2.getSerializersModule();
                    jsonObject2 = (JsonObject) this_$iv$iv2.decodeFromString(JsonObject.Companion.serializer(), string$iv$iv2);
                } catch (Exception e2) {
                    jsonObject2 = null;
                }
                JsonObject videoJson = jsonObject2;
                merged = VideoShareDataKt.mergeJsonObjects(upJson, videoJson);
                try {
                    StringFormat $this$encodeToString$iv = VideoShareDataKt.json;
                    $this$encodeToString$iv.getSerializersModule();
                    return CodecsKt.encodeURLPath$default($this$encodeToString$iv.encodeToString(JsonObject.Companion.serializer(), merged), false, false, 3, (Object) null);
                } catch (Exception e3) {
                    return "";
                }
            }
        }