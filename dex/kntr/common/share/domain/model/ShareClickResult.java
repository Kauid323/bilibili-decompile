package kntr.common.share.domain.model;

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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShareClickResult.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGB\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010+J\u0092\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\tHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001J%\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0001¢\u0006\u0002\bER\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0017R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010!\u0012\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010 R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u0017R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u0017R \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010,\u0012\u0004\b*\u0010\u001c\u001a\u0004\b\u000e\u0010+¨\u0006H"}, d2 = {"Lkntr/common/share/domain/model/ShareClickResult;", "", "content", "", "link", "picture", "title", "audioLink", "shareMode", "", "programId", "programPath", "header", "schema", "isFirstShare", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContent", "()Ljava/lang/String;", "getLink", "getPicture", "getTitle", "getAudioLink$annotations", "()V", "getAudioLink", "getShareMode$annotations", "getShareMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgramId$annotations", "getProgramId", "getProgramPath$annotations", "getProgramPath", "getHeader$annotations", "getHeader", "getSchema$annotations", "getSchema", "isFirstShare$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lkntr/common/share/domain/model/ShareClickResult;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_debug", "$serializer", "Companion", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ShareClickResult {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String audioLink;
    private final String content;
    private final String header;
    private final Boolean isFirstShare;
    private final String link;
    private final String picture;
    private final String programId;
    private final String programPath;
    private final String schema;
    private final Integer shareMode;
    private final String title;

    public ShareClickResult() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (Boolean) null, 2047, (DefaultConstructorMarker) null);
    }

    @SerialName("audio_play_link")
    public static /* synthetic */ void getAudioLink$annotations() {
    }

    @SerialName("header")
    public static /* synthetic */ void getHeader$annotations() {
    }

    @SerialName("program_id")
    public static /* synthetic */ void getProgramId$annotations() {
    }

    @SerialName("program_path")
    public static /* synthetic */ void getProgramPath$annotations() {
    }

    @SerialName("schema")
    public static /* synthetic */ void getSchema$annotations() {
    }

    @SerialName("share_mode")
    public static /* synthetic */ void getShareMode$annotations() {
    }

    @SerialName("is_first_share")
    public static /* synthetic */ void isFirstShare$annotations() {
    }

    public final String component1() {
        return this.content;
    }

    public final String component10() {
        return this.schema;
    }

    public final Boolean component11() {
        return this.isFirstShare;
    }

    public final String component2() {
        return this.link;
    }

    public final String component3() {
        return this.picture;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.audioLink;
    }

    public final Integer component6() {
        return this.shareMode;
    }

    public final String component7() {
        return this.programId;
    }

    public final String component8() {
        return this.programPath;
    }

    public final String component9() {
        return this.header;
    }

    public final ShareClickResult copy(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, Boolean bool) {
        return new ShareClickResult(str, str2, str3, str4, str5, num, str6, str7, str8, str9, bool);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareClickResult) {
            ShareClickResult shareClickResult = (ShareClickResult) obj;
            return Intrinsics.areEqual(this.content, shareClickResult.content) && Intrinsics.areEqual(this.link, shareClickResult.link) && Intrinsics.areEqual(this.picture, shareClickResult.picture) && Intrinsics.areEqual(this.title, shareClickResult.title) && Intrinsics.areEqual(this.audioLink, shareClickResult.audioLink) && Intrinsics.areEqual(this.shareMode, shareClickResult.shareMode) && Intrinsics.areEqual(this.programId, shareClickResult.programId) && Intrinsics.areEqual(this.programPath, shareClickResult.programPath) && Intrinsics.areEqual(this.header, shareClickResult.header) && Intrinsics.areEqual(this.schema, shareClickResult.schema) && Intrinsics.areEqual(this.isFirstShare, shareClickResult.isFirstShare);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((this.content == null ? 0 : this.content.hashCode()) * 31) + (this.link == null ? 0 : this.link.hashCode())) * 31) + (this.picture == null ? 0 : this.picture.hashCode())) * 31) + (this.title == null ? 0 : this.title.hashCode())) * 31) + (this.audioLink == null ? 0 : this.audioLink.hashCode())) * 31) + (this.shareMode == null ? 0 : this.shareMode.hashCode())) * 31) + (this.programId == null ? 0 : this.programId.hashCode())) * 31) + (this.programPath == null ? 0 : this.programPath.hashCode())) * 31) + (this.header == null ? 0 : this.header.hashCode())) * 31) + (this.schema == null ? 0 : this.schema.hashCode())) * 31) + (this.isFirstShare != null ? this.isFirstShare.hashCode() : 0);
    }

    public String toString() {
        String str = this.content;
        String str2 = this.link;
        String str3 = this.picture;
        String str4 = this.title;
        String str5 = this.audioLink;
        Integer num = this.shareMode;
        String str6 = this.programId;
        String str7 = this.programPath;
        String str8 = this.header;
        String str9 = this.schema;
        return "ShareClickResult(content=" + str + ", link=" + str2 + ", picture=" + str3 + ", title=" + str4 + ", audioLink=" + str5 + ", shareMode=" + num + ", programId=" + str6 + ", programPath=" + str7 + ", header=" + str8 + ", schema=" + str9 + ", isFirstShare=" + this.isFirstShare + ")";
    }

    /* compiled from: ShareClickResult.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/share/domain/model/ShareClickResult$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/share/domain/model/ShareClickResult;", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShareClickResult> serializer() {
            return new GeneratedSerializer<ShareClickResult>() { // from class: kntr.common.share.domain.model.ShareClickResult$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.share.domain.model.ShareClickResult", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareClickResult> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareClickResult> A[REMOVE]) =  kntr.common.share.domain.model.ShareClickResult$$serializer.INSTANCE kntr.common.share.domain.model.ShareClickResult$$serializer)
                         in method: kntr.common.share.domain.model.ShareClickResult.Companion.serializer():kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareClickResult>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.common.share.domain.model.ShareClickResult")
                          (wrap: kntr.common.share.domain.model.ShareClickResult$$serializer : 0x0009: SGET  (r1v0 kntr.common.share.domain.model.ShareClickResult$$serializer A[REMOVE]) =  kntr.common.share.domain.model.ShareClickResult$$serializer.INSTANCE kntr.common.share.domain.model.ShareClickResult$$serializer)
                          (11 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.common.share.domain.model.ShareClickResult$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.common.share.domain.model.ShareClickResult$$serializer
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
                        kntr.common.share.domain.model.ShareClickResult$$serializer r0 = kntr.common.share.domain.model.ShareClickResult$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.common.share.domain.model.ShareClickResult.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ ShareClickResult(int seen0, String content, String link, String picture, String title, String audioLink, Integer shareMode, String programId, String programPath, String header, String schema, Boolean isFirstShare, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.content = null;
                } else {
                    this.content = content;
                }
                if ((seen0 & 2) == 0) {
                    this.link = null;
                } else {
                    this.link = link;
                }
                if ((seen0 & 4) == 0) {
                    this.picture = null;
                } else {
                    this.picture = picture;
                }
                if ((seen0 & 8) == 0) {
                    this.title = null;
                } else {
                    this.title = title;
                }
                if ((seen0 & 16) == 0) {
                    this.audioLink = null;
                } else {
                    this.audioLink = audioLink;
                }
                if ((seen0 & 32) == 0) {
                    this.shareMode = null;
                } else {
                    this.shareMode = shareMode;
                }
                if ((seen0 & 64) == 0) {
                    this.programId = null;
                } else {
                    this.programId = programId;
                }
                if ((seen0 & 128) == 0) {
                    this.programPath = null;
                } else {
                    this.programPath = programPath;
                }
                if ((seen0 & 256) == 0) {
                    this.header = null;
                } else {
                    this.header = header;
                }
                if ((seen0 & 512) == 0) {
                    this.schema = null;
                } else {
                    this.schema = schema;
                }
                if ((seen0 & 1024) == 0) {
                    this.isFirstShare = null;
                } else {
                    this.isFirstShare = isFirstShare;
                }
            }

            public ShareClickResult(String content, String link, String picture, String title, String audioLink, Integer shareMode, String programId, String programPath, String header, String schema, Boolean isFirstShare) {
                this.content = content;
                this.link = link;
                this.picture = picture;
                this.title = title;
                this.audioLink = audioLink;
                this.shareMode = shareMode;
                this.programId = programId;
                this.programPath = programPath;
                this.header = header;
                this.schema = schema;
                this.isFirstShare = isFirstShare;
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$domain_debug(ShareClickResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.content);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.link != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.link);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.picture != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.picture);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.title != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.title);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.audioLink != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.audioLink);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.shareMode != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.shareMode);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.programId != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.programId);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.programPath != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.programPath);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 8) || self.header != null) {
                    output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.header);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 9) || self.schema != null) {
                    output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.schema);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 10) || self.isFirstShare != null) {
                    output.encodeNullableSerializableElement(serialDesc, 10, BooleanSerializer.INSTANCE, self.isFirstShare);
                }
            }

            public /* synthetic */ ShareClickResult(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) == 0 ? bool : null);
            }

            public final String getContent() {
                return this.content;
            }

            public final String getLink() {
                return this.link;
            }

            public final String getPicture() {
                return this.picture;
            }

            public final String getTitle() {
                return this.title;
            }

            public final String getAudioLink() {
                return this.audioLink;
            }

            public final Integer getShareMode() {
                return this.shareMode;
            }

            public final String getProgramId() {
                return this.programId;
            }

            public final String getProgramPath() {
                return this.programPath;
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getSchema() {
                return this.schema;
            }

            public final Boolean isFirstShare() {
                return this.isFirstShare;
            }
        }