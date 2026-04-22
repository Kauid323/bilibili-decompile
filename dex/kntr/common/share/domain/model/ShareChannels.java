package kntr.common.share.domain.model;

import java.util.ArrayList;
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
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ShareChannels.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0002JKB\u009d\u0001\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010B}\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u000f\u0010\u0015J\u0006\u00103\u001a\u000204J\u001d\u00105\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u00106\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u001d\u00107\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u009f\u0001\u0010=\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010>\u001a\u0002042\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0012HÖ\u0001J\t\u0010A\u001a\u00020\tHÖ\u0001J%\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00002\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020HH\u0001¢\u0006\u0002\bIR8\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR8\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR8\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR&\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0017\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&R\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010$\"\u0004\b-\u0010&R&\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\u0017\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006L"}, d2 = {"Lkntr/common/share/domain/model/ShareChannels;", "", "aboveChannels", "Ljava/util/ArrayList;", "Lkntr/common/share/domain/model/ChannelItem;", "Lkotlin/collections/ArrayList;", "belowChannels", "systemChannels", "jumpLink", "", "copyLink", "picture", "text", "extra", "Lkntr/common/share/domain/model/ChannelExtra;", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/common/share/domain/model/ChannelExtra;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkntr/common/share/domain/model/ChannelExtra;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAboveChannels$annotations", "()V", "getAboveChannels", "()Ljava/util/ArrayList;", "setAboveChannels", "(Ljava/util/ArrayList;)V", "getBelowChannels$annotations", "getBelowChannels", "setBelowChannels", "getSystemChannels$annotations", "getSystemChannels", "setSystemChannels", "getJumpLink$annotations", "getJumpLink", "()Ljava/lang/String;", "setJumpLink", "(Ljava/lang/String;)V", "getCopyLink$annotations", "getCopyLink", "setCopyLink", "getPicture", "setPicture", "getText", "setText", "getExtra$annotations", "getExtra", "()Lkntr/common/share/domain/model/ChannelExtra;", "setExtra", "(Lkntr/common/share/domain/model/ChannelExtra;)V", "isEmpty", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_debug", "$serializer", "Companion", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class ShareChannels {
    private ArrayList<ChannelItem> aboveChannels;
    private ArrayList<ChannelItem> belowChannels;
    private String copyLink;
    private ChannelExtra extra;
    private String jumpLink;
    private String picture;
    private ArrayList<ChannelItem> systemChannels;
    private String text;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.share.domain.model.ShareChannels$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = ShareChannels._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.share.domain.model.ShareChannels$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = ShareChannels._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.share.domain.model.ShareChannels$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = ShareChannels._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    }), null, null, null, null, null};

    public ShareChannels() {
        this((ArrayList) null, (ArrayList) null, (ArrayList) null, (String) null, (String) null, (String) null, (String) null, (ChannelExtra) null, (int) KotlinVersion.MAX_COMPONENT_VALUE, (DefaultConstructorMarker) null);
    }

    @SerialName("above_channels")
    public static /* synthetic */ void getAboveChannels$annotations() {
    }

    @SerialName("below_channels")
    public static /* synthetic */ void getBelowChannels$annotations() {
    }

    @SerialName("copy_link")
    public static /* synthetic */ void getCopyLink$annotations() {
    }

    @SerialName("extra")
    public static /* synthetic */ void getExtra$annotations() {
    }

    @SerialName("jump_link")
    public static /* synthetic */ void getJumpLink$annotations() {
    }

    @SerialName("system_channels")
    public static /* synthetic */ void getSystemChannels$annotations() {
    }

    public final ArrayList<ChannelItem> component1() {
        return this.aboveChannels;
    }

    public final ArrayList<ChannelItem> component2() {
        return this.belowChannels;
    }

    public final ArrayList<ChannelItem> component3() {
        return this.systemChannels;
    }

    public final String component4() {
        return this.jumpLink;
    }

    public final String component5() {
        return this.copyLink;
    }

    public final String component6() {
        return this.picture;
    }

    public final String component7() {
        return this.text;
    }

    public final ChannelExtra component8() {
        return this.extra;
    }

    public final ShareChannels copy(ArrayList<ChannelItem> arrayList, ArrayList<ChannelItem> arrayList2, ArrayList<ChannelItem> arrayList3, String str, String str2, String str3, String str4, ChannelExtra channelExtra) {
        return new ShareChannels(arrayList, arrayList2, arrayList3, str, str2, str3, str4, channelExtra);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareChannels) {
            ShareChannels shareChannels = (ShareChannels) obj;
            return Intrinsics.areEqual(this.aboveChannels, shareChannels.aboveChannels) && Intrinsics.areEqual(this.belowChannels, shareChannels.belowChannels) && Intrinsics.areEqual(this.systemChannels, shareChannels.systemChannels) && Intrinsics.areEqual(this.jumpLink, shareChannels.jumpLink) && Intrinsics.areEqual(this.copyLink, shareChannels.copyLink) && Intrinsics.areEqual(this.picture, shareChannels.picture) && Intrinsics.areEqual(this.text, shareChannels.text) && Intrinsics.areEqual(this.extra, shareChannels.extra);
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((this.aboveChannels == null ? 0 : this.aboveChannels.hashCode()) * 31) + (this.belowChannels == null ? 0 : this.belowChannels.hashCode())) * 31) + (this.systemChannels == null ? 0 : this.systemChannels.hashCode())) * 31) + (this.jumpLink == null ? 0 : this.jumpLink.hashCode())) * 31) + (this.copyLink == null ? 0 : this.copyLink.hashCode())) * 31) + (this.picture == null ? 0 : this.picture.hashCode())) * 31) + (this.text == null ? 0 : this.text.hashCode())) * 31) + (this.extra != null ? this.extra.hashCode() : 0);
    }

    public String toString() {
        ArrayList<ChannelItem> arrayList = this.aboveChannels;
        ArrayList<ChannelItem> arrayList2 = this.belowChannels;
        ArrayList<ChannelItem> arrayList3 = this.systemChannels;
        String str = this.jumpLink;
        String str2 = this.copyLink;
        String str3 = this.picture;
        String str4 = this.text;
        return "ShareChannels(aboveChannels=" + arrayList + ", belowChannels=" + arrayList2 + ", systemChannels=" + arrayList3 + ", jumpLink=" + str + ", copyLink=" + str2 + ", picture=" + str3 + ", text=" + str4 + ", extra=" + this.extra + ")";
    }

    /* compiled from: ShareChannels.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/share/domain/model/ShareChannels$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/share/domain/model/ShareChannels;", "domain_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ShareChannels> serializer() {
            return new GeneratedSerializer<ShareChannels>() { // from class: kntr.common.share.domain.model.ShareChannels$$serializer
                public static final int $stable;
                private static final SerialDescriptor descriptor;

                public final SerialDescriptor getDescriptor() {
                    return descriptor;
                }

                static {
                    SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.common.share.domain.model.ShareChannels", 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: RETURN  
                          (wrap: kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareChannels> : 0x0002: SGET  (r0v1 kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareChannels> A[REMOVE]) =  kntr.common.share.domain.model.ShareChannels$$serializer.INSTANCE kntr.common.share.domain.model.ShareChannels$$serializer)
                         in method: kntr.common.share.domain.model.ShareChannels.Companion.serializer():kotlinx.serialization.KSerializer<kntr.common.share.domain.model.ShareChannels>, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                          ("kntr.common.share.domain.model.ShareChannels")
                          (wrap: kntr.common.share.domain.model.ShareChannels$$serializer : 0x0009: SGET  (r1v0 kntr.common.share.domain.model.ShareChannels$$serializer A[REMOVE]) =  kntr.common.share.domain.model.ShareChannels$$serializer.INSTANCE kntr.common.share.domain.model.ShareChannels$$serializer)
                          (8 int)
                         call: kotlinx.serialization.internal.PluginGeneratedSerialDescriptor.<init>(java.lang.String, kotlinx.serialization.internal.GeneratedSerializer, int):void type: CONSTRUCTOR in method: kntr.common.share.domain.model.ShareChannels$$serializer.<clinit>():void, file: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Anonymous inner class unlimited recursion detected. Convert class to inner: kntr.common.share.domain.model.ShareChannels$$serializer
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
                        kntr.common.share.domain.model.ShareChannels$$serializer r0 = kntr.common.share.domain.model.ShareChannels$$serializer.INSTANCE
                        kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kntr.common.share.domain.model.ShareChannels.Companion.serializer():kotlinx.serialization.KSerializer");
                }
            }

            public /* synthetic */ ShareChannels(int seen0, ArrayList aboveChannels, ArrayList belowChannels, ArrayList systemChannels, String jumpLink, String copyLink, String picture, String text, ChannelExtra extra, SerializationConstructorMarker serializationConstructorMarker) {
                if ((seen0 & 1) == 0) {
                    this.aboveChannels = null;
                } else {
                    this.aboveChannels = aboveChannels;
                }
                if ((seen0 & 2) == 0) {
                    this.belowChannels = null;
                } else {
                    this.belowChannels = belowChannels;
                }
                if ((seen0 & 4) == 0) {
                    this.systemChannels = null;
                } else {
                    this.systemChannels = systemChannels;
                }
                if ((seen0 & 8) == 0) {
                    this.jumpLink = null;
                } else {
                    this.jumpLink = jumpLink;
                }
                if ((seen0 & 16) == 0) {
                    this.copyLink = null;
                } else {
                    this.copyLink = copyLink;
                }
                if ((seen0 & 32) == 0) {
                    this.picture = null;
                } else {
                    this.picture = picture;
                }
                if ((seen0 & 64) == 0) {
                    this.text = null;
                } else {
                    this.text = text;
                }
                if ((seen0 & 128) == 0) {
                    this.extra = null;
                } else {
                    this.extra = extra;
                }
            }

            public ShareChannels(ArrayList<ChannelItem> arrayList, ArrayList<ChannelItem> arrayList2, ArrayList<ChannelItem> arrayList3, String jumpLink, String copyLink, String picture, String text, ChannelExtra extra) {
                this.aboveChannels = arrayList;
                this.belowChannels = arrayList2;
                this.systemChannels = arrayList3;
                this.jumpLink = jumpLink;
                this.copyLink = copyLink;
                this.picture = picture;
                this.text = text;
                this.extra = extra;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
                return new ArrayListSerializer(ChannelItem$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
                return new ArrayListSerializer(ChannelItem$$serializer.INSTANCE);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
                return new ArrayListSerializer(ChannelItem$$serializer.INSTANCE);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$domain_debug(ShareChannels self, CompositeEncoder output, SerialDescriptor serialDesc) {
                Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.aboveChannels != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, lazyArr[0].getValue(), self.aboveChannels);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.belowChannels != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.belowChannels);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 2) || self.systemChannels != null) {
                    output.encodeNullableSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.systemChannels);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 3) || self.jumpLink != null) {
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.jumpLink);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 4) || self.copyLink != null) {
                    output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.copyLink);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 5) || self.picture != null) {
                    output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.picture);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 6) || self.text != null) {
                    output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.text);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 7) || self.extra != null) {
                    output.encodeNullableSerializableElement(serialDesc, 7, ChannelExtra$$serializer.INSTANCE, self.extra);
                }
            }

            public /* synthetic */ ShareChannels(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, String str, String str2, String str3, String str4, ChannelExtra channelExtra, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : arrayList2, (i & 4) != 0 ? null : arrayList3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? null : str4, (i & 128) == 0 ? channelExtra : null);
            }

            public final ArrayList<ChannelItem> getAboveChannels() {
                return this.aboveChannels;
            }

            public final void setAboveChannels(ArrayList<ChannelItem> arrayList) {
                this.aboveChannels = arrayList;
            }

            public final ArrayList<ChannelItem> getBelowChannels() {
                return this.belowChannels;
            }

            public final void setBelowChannels(ArrayList<ChannelItem> arrayList) {
                this.belowChannels = arrayList;
            }

            public final ArrayList<ChannelItem> getSystemChannels() {
                return this.systemChannels;
            }

            public final void setSystemChannels(ArrayList<ChannelItem> arrayList) {
                this.systemChannels = arrayList;
            }

            public final String getJumpLink() {
                return this.jumpLink;
            }

            public final void setJumpLink(String str) {
                this.jumpLink = str;
            }

            public final String getCopyLink() {
                return this.copyLink;
            }

            public final void setCopyLink(String str) {
                this.copyLink = str;
            }

            public final String getPicture() {
                return this.picture;
            }

            public final void setPicture(String str) {
                this.picture = str;
            }

            public final String getText() {
                return this.text;
            }

            public final void setText(String str) {
                this.text = str;
            }

            public final ChannelExtra getExtra() {
                return this.extra;
            }

            public final void setExtra(ChannelExtra channelExtra) {
                this.extra = channelExtra;
            }

            public final boolean isEmpty() {
                ArrayList<ChannelItem> arrayList = this.aboveChannels;
                if (arrayList != null ? arrayList.isEmpty() : true) {
                    ArrayList<ChannelItem> arrayList2 = this.belowChannels;
                    if (arrayList2 != null ? arrayList2.isEmpty() : true) {
                        ArrayList<ChannelItem> arrayList3 = this.systemChannels;
                        if (arrayList3 != null ? arrayList3.isEmpty() : true) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }