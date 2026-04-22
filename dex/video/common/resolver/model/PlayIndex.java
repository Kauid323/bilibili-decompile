package video.common.resolver.model;

import BottomSheetItemData$;
import java.util.ArrayList;
import java.util.List;
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
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: PlayIndex.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002@ABo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u007f\b\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0011\u0010\u0016J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003Ju\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u00104\u001a\u00020\u000f2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\u0003HÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001J%\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\b?R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u001c\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001aR\u001c\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'¨\u0006B"}, d2 = {"Lvideo/common/resolver/model/PlayIndex;", "", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "", IjkMediaMeta.IJKM_KEY_FORMAT, "", "segmentList", "", "Lvideo/common/resolver/model/Segment;", "typeTag", "description", "pithyDescription", "superscript", "subtitle", "needVip", "", "vipFree", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuality", "()I", "getFormat", "()Ljava/lang/String;", "getSegmentList$annotations", "()V", "getSegmentList", "()Ljava/util/List;", "getTypeTag", "getDescription$annotations", "getDescription", "getPithyDescription$annotations", "getPithyDescription", "getSuperscript", "getSubtitle", "getNeedVip", "()Z", "getVipFree", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$resolver_debug", "$serializer", "Companion", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class PlayIndex {
    private final String description;
    private final String format;
    private final boolean needVip;
    private final String pithyDescription;
    private final int quality;
    private final List<Segment> segmentList;
    private final String subtitle;
    private final String superscript;
    private final String typeTag;
    private final boolean vipFree;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: video.common.resolver.model.PlayIndex$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = PlayIndex._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null, null, null, null, null, null};

    @SerialName("new_description")
    public static /* synthetic */ void getDescription$annotations() {
    }

    @SerialName("display_desc")
    public static /* synthetic */ void getPithyDescription$annotations() {
    }

    @SerialName("segment_list")
    public static /* synthetic */ void getSegmentList$annotations() {
    }

    public final int component1() {
        return this.quality;
    }

    public final boolean component10() {
        return this.vipFree;
    }

    public final String component2() {
        return this.format;
    }

    public final List<Segment> component3() {
        return this.segmentList;
    }

    public final String component4() {
        return this.typeTag;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.pithyDescription;
    }

    public final String component7() {
        return this.superscript;
    }

    public final String component8() {
        return this.subtitle;
    }

    public final boolean component9() {
        return this.needVip;
    }

    public final PlayIndex copy(int i, String str, List<Segment> list, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, IjkMediaMeta.IJKM_KEY_FORMAT);
        Intrinsics.checkNotNullParameter(list, "segmentList");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, "pithyDescription");
        Intrinsics.checkNotNullParameter(str5, "superscript");
        Intrinsics.checkNotNullParameter(str6, "subtitle");
        return new PlayIndex(i, str, list, str2, str3, str4, str5, str6, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayIndex) {
            PlayIndex playIndex = (PlayIndex) obj;
            return this.quality == playIndex.quality && Intrinsics.areEqual(this.format, playIndex.format) && Intrinsics.areEqual(this.segmentList, playIndex.segmentList) && Intrinsics.areEqual(this.typeTag, playIndex.typeTag) && Intrinsics.areEqual(this.description, playIndex.description) && Intrinsics.areEqual(this.pithyDescription, playIndex.pithyDescription) && Intrinsics.areEqual(this.superscript, playIndex.superscript) && Intrinsics.areEqual(this.subtitle, playIndex.subtitle) && this.needVip == playIndex.needVip && this.vipFree == playIndex.vipFree;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.quality * 31) + this.format.hashCode()) * 31) + this.segmentList.hashCode()) * 31) + (this.typeTag == null ? 0 : this.typeTag.hashCode())) * 31) + this.description.hashCode()) * 31) + this.pithyDescription.hashCode()) * 31) + this.superscript.hashCode()) * 31) + this.subtitle.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needVip)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.vipFree);
    }

    public String toString() {
        int i = this.quality;
        String str = this.format;
        List<Segment> list = this.segmentList;
        String str2 = this.typeTag;
        String str3 = this.description;
        String str4 = this.pithyDescription;
        String str5 = this.superscript;
        String str6 = this.subtitle;
        boolean z = this.needVip;
        return "PlayIndex(quality=" + i + ", format=" + str + ", segmentList=" + list + ", typeTag=" + str2 + ", description=" + str3 + ", pithyDescription=" + str4 + ", superscript=" + str5 + ", subtitle=" + str6 + ", needVip=" + z + ", vipFree=" + this.vipFree + ")";
    }

    /* compiled from: PlayIndex.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/common/resolver/model/PlayIndex$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/common/resolver/model/PlayIndex;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayIndex> serializer() {
            return PlayIndex$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayIndex(int seen0, int quality, String format, List segmentList, String typeTag, String description, String pithyDescription, String superscript, String subtitle, boolean needVip, boolean vipFree, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, PlayIndex$$serializer.INSTANCE.getDescriptor());
        }
        this.quality = quality;
        this.format = format;
        if ((seen0 & 4) == 0) {
            this.segmentList = new ArrayList();
        } else {
            this.segmentList = segmentList;
        }
        if ((seen0 & 8) == 0) {
            this.typeTag = null;
        } else {
            this.typeTag = typeTag;
        }
        if ((seen0 & 16) == 0) {
            this.description = "";
        } else {
            this.description = description;
        }
        if ((seen0 & 32) == 0) {
            this.pithyDescription = "";
        } else {
            this.pithyDescription = pithyDescription;
        }
        if ((seen0 & 64) == 0) {
            this.superscript = "";
        } else {
            this.superscript = superscript;
        }
        if ((seen0 & 128) == 0) {
            this.subtitle = "";
        } else {
            this.subtitle = subtitle;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.needVip = false;
        } else {
            this.needVip = needVip;
        }
        if ((seen0 & 512) == 0) {
            this.vipFree = false;
        } else {
            this.vipFree = vipFree;
        }
    }

    public PlayIndex(int quality, String format, List<Segment> list, String typeTag, String description, String pithyDescription, String superscript, String subtitle, boolean needVip, boolean vipFree) {
        Intrinsics.checkNotNullParameter(format, IjkMediaMeta.IJKM_KEY_FORMAT);
        Intrinsics.checkNotNullParameter(list, "segmentList");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(pithyDescription, "pithyDescription");
        Intrinsics.checkNotNullParameter(superscript, "superscript");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.quality = quality;
        this.format = format;
        this.segmentList = list;
        this.typeTag = typeTag;
        this.description = description;
        this.pithyDescription = pithyDescription;
        this.superscript = superscript;
        this.subtitle = subtitle;
        this.needVip = needVip;
        this.vipFree = vipFree;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(Segment$$serializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$resolver_debug(PlayIndex self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.quality);
        output.encodeStringElement(serialDesc, 1, self.format);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.segmentList, new ArrayList())) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.segmentList);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.typeTag != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.typeTag);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.description, "")) {
            output.encodeStringElement(serialDesc, 4, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.pithyDescription, "")) {
            output.encodeStringElement(serialDesc, 5, self.pithyDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.superscript, "")) {
            output.encodeStringElement(serialDesc, 6, self.superscript);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !Intrinsics.areEqual(self.subtitle, "")) {
            output.encodeStringElement(serialDesc, 7, self.subtitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.needVip) {
            output.encodeBooleanElement(serialDesc, 8, self.needVip);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.vipFree) {
            output.encodeBooleanElement(serialDesc, 9, self.vipFree);
        }
    }

    public /* synthetic */ PlayIndex(int i, String str, List list, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? new ArrayList() : list, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? "" : str6, (i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? false : z, (i2 & 512) != 0 ? false : z2);
    }

    public final int getQuality() {
        return this.quality;
    }

    public final String getFormat() {
        return this.format;
    }

    public final List<Segment> getSegmentList() {
        return this.segmentList;
    }

    public final String getTypeTag() {
        return this.typeTag;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getPithyDescription() {
        return this.pithyDescription;
    }

    public final String getSuperscript() {
        return this.superscript;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final boolean getNeedVip() {
        return this.needVip;
    }

    public final boolean getVipFree() {
        return this.vipFree;
    }
}