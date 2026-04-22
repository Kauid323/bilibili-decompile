package video.common.resolver.model;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

/* compiled from: StreamInfo.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010Bw\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0014J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003Jm\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\u0005HÖ\u0001J%\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0001¢\u0006\u0002\b8R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u0006;"}, d2 = {"Lvideo/common/resolver/model/StreamInfo;", "", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "", IjkMediaMeta.IJKM_KEY_FORMAT, "", "description", "needVip", "", "newDescription", "displayDesc", "superscript", "vipFree", "subtitle", "supportDrm", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Z)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQuality", "()I", "getFormat", "()Ljava/lang/String;", "getDescription", "getNeedVip", "()Z", "getNewDescription", "getDisplayDesc", "getSuperscript", "getVipFree", "getSubtitle", "getSupportDrm", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$resolver_debug", "$serializer", "Companion", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class StreamInfo {
    public static final Companion Companion = new Companion(null);
    private final String description;
    private final String displayDesc;
    private final String format;
    private final boolean needVip;
    private final String newDescription;
    private final int quality;
    private final String subtitle;
    private final String superscript;
    private final boolean supportDrm;
    private final boolean vipFree;

    public StreamInfo() {
        this(0, (String) null, (String) null, false, (String) null, (String) null, (String) null, false, (String) null, false, (int) IjkMediaPlayerTracker.BLIJK_EV_BUFFERING_END, (DefaultConstructorMarker) null);
    }

    public final int component1() {
        return this.quality;
    }

    public final boolean component10() {
        return this.supportDrm;
    }

    public final String component2() {
        return this.format;
    }

    public final String component3() {
        return this.description;
    }

    public final boolean component4() {
        return this.needVip;
    }

    public final String component5() {
        return this.newDescription;
    }

    public final String component6() {
        return this.displayDesc;
    }

    public final String component7() {
        return this.superscript;
    }

    public final boolean component8() {
        return this.vipFree;
    }

    public final String component9() {
        return this.subtitle;
    }

    public final StreamInfo copy(int i, String str, String str2, boolean z, String str3, String str4, String str5, boolean z2, String str6, boolean z3) {
        Intrinsics.checkNotNullParameter(str, IjkMediaMeta.IJKM_KEY_FORMAT);
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "newDescription");
        Intrinsics.checkNotNullParameter(str4, "displayDesc");
        Intrinsics.checkNotNullParameter(str5, "superscript");
        Intrinsics.checkNotNullParameter(str6, "subtitle");
        return new StreamInfo(i, str, str2, z, str3, str4, str5, z2, str6, z3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StreamInfo) {
            StreamInfo streamInfo = (StreamInfo) obj;
            return this.quality == streamInfo.quality && Intrinsics.areEqual(this.format, streamInfo.format) && Intrinsics.areEqual(this.description, streamInfo.description) && this.needVip == streamInfo.needVip && Intrinsics.areEqual(this.newDescription, streamInfo.newDescription) && Intrinsics.areEqual(this.displayDesc, streamInfo.displayDesc) && Intrinsics.areEqual(this.superscript, streamInfo.superscript) && this.vipFree == streamInfo.vipFree && Intrinsics.areEqual(this.subtitle, streamInfo.subtitle) && this.supportDrm == streamInfo.supportDrm;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.quality * 31) + this.format.hashCode()) * 31) + this.description.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needVip)) * 31) + this.newDescription.hashCode()) * 31) + this.displayDesc.hashCode()) * 31) + this.superscript.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.vipFree)) * 31) + this.subtitle.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.supportDrm);
    }

    public String toString() {
        int i = this.quality;
        String str = this.format;
        String str2 = this.description;
        boolean z = this.needVip;
        String str3 = this.newDescription;
        String str4 = this.displayDesc;
        String str5 = this.superscript;
        boolean z2 = this.vipFree;
        String str6 = this.subtitle;
        return "StreamInfo(quality=" + i + ", format=" + str + ", description=" + str2 + ", needVip=" + z + ", newDescription=" + str3 + ", displayDesc=" + str4 + ", superscript=" + str5 + ", vipFree=" + z2 + ", subtitle=" + str6 + ", supportDrm=" + this.supportDrm + ")";
    }

    /* compiled from: StreamInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/common/resolver/model/StreamInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/common/resolver/model/StreamInfo;", "resolver_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StreamInfo> serializer() {
            return StreamInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ StreamInfo(int seen0, int quality, String format, String description, boolean needVip, String newDescription, String displayDesc, String superscript, boolean vipFree, String subtitle, boolean supportDrm, SerializationConstructorMarker serializationConstructorMarker) {
        if ((seen0 & 1) == 0) {
            this.quality = 0;
        } else {
            this.quality = quality;
        }
        if ((seen0 & 2) == 0) {
            this.format = "";
        } else {
            this.format = format;
        }
        if ((seen0 & 4) == 0) {
            this.description = "";
        } else {
            this.description = description;
        }
        if ((seen0 & 8) == 0) {
            this.needVip = false;
        } else {
            this.needVip = needVip;
        }
        if ((seen0 & 16) == 0) {
            this.newDescription = "";
        } else {
            this.newDescription = newDescription;
        }
        if ((seen0 & 32) == 0) {
            this.displayDesc = "";
        } else {
            this.displayDesc = displayDesc;
        }
        if ((seen0 & 64) == 0) {
            this.superscript = "";
        } else {
            this.superscript = superscript;
        }
        if ((seen0 & 128) == 0) {
            this.vipFree = false;
        } else {
            this.vipFree = vipFree;
        }
        if ((seen0 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0) {
            this.subtitle = "";
        } else {
            this.subtitle = subtitle;
        }
        if ((seen0 & 512) == 0) {
            this.supportDrm = false;
        } else {
            this.supportDrm = supportDrm;
        }
    }

    public StreamInfo(int quality, String format, String description, boolean needVip, String newDescription, String displayDesc, String superscript, boolean vipFree, String subtitle, boolean supportDrm) {
        Intrinsics.checkNotNullParameter(format, IjkMediaMeta.IJKM_KEY_FORMAT);
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(newDescription, "newDescription");
        Intrinsics.checkNotNullParameter(displayDesc, "displayDesc");
        Intrinsics.checkNotNullParameter(superscript, "superscript");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        this.quality = quality;
        this.format = format;
        this.description = description;
        this.needVip = needVip;
        this.newDescription = newDescription;
        this.displayDesc = displayDesc;
        this.superscript = superscript;
        this.vipFree = vipFree;
        this.subtitle = subtitle;
        this.supportDrm = supportDrm;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$resolver_debug(StreamInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.quality != 0) {
            output.encodeIntElement(serialDesc, 0, self.quality);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.format, "")) {
            output.encodeStringElement(serialDesc, 1, self.format);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.description, "")) {
            output.encodeStringElement(serialDesc, 2, self.description);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.needVip) {
            output.encodeBooleanElement(serialDesc, 3, self.needVip);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.newDescription, "")) {
            output.encodeStringElement(serialDesc, 4, self.newDescription);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.displayDesc, "")) {
            output.encodeStringElement(serialDesc, 5, self.displayDesc);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !Intrinsics.areEqual(self.superscript, "")) {
            output.encodeStringElement(serialDesc, 6, self.superscript);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.vipFree) {
            output.encodeBooleanElement(serialDesc, 7, self.vipFree);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || !Intrinsics.areEqual(self.subtitle, "")) {
            output.encodeStringElement(serialDesc, 8, self.subtitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.supportDrm) {
            output.encodeBooleanElement(serialDesc, 9, self.supportDrm);
        }
    }

    public /* synthetic */ StreamInfo(int i, String str, String str2, boolean z, String str3, String str4, String str5, boolean z2, String str6, boolean z3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? "" : str3, (i2 & 32) != 0 ? "" : str4, (i2 & 64) != 0 ? "" : str5, (i2 & 128) != 0 ? false : z2, (i2 & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) == 0 ? str6 : "", (i2 & 512) == 0 ? z3 : false);
    }

    public final int getQuality() {
        return this.quality;
    }

    public final String getFormat() {
        return this.format;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getNeedVip() {
        return this.needVip;
    }

    public final String getNewDescription() {
        return this.newDescription;
    }

    public final String getDisplayDesc() {
        return this.displayDesc;
    }

    public final String getSuperscript() {
        return this.superscript;
    }

    public final boolean getVipFree() {
        return this.vipFree;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final boolean getSupportDrm() {
        return this.supportDrm;
    }
}