package video.biz.offline.base.model.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import video.biz.offline.base.model.ext.OfflineConfigKt;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245BK\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eB[\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u00066"}, d2 = {"Lvideo/biz/offline/base/model/model/PlayerInfo;", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_QN, "", "fnver", "fnval", "fourk", "", "codecType", "voiceBalance", "", "needTrial", "audioType", "<init>", "(IIIZIJZI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIIIZIJZILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getQn", "()I", "getFnver", "getFnval", "getFourk", "()Z", "getCodecType", "getVoiceBalance", "()J", "getNeedTrial", "getAudioType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$model_debug", "$serializer", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class PlayerInfo {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int audioType;
    private final int codecType;
    private final int fnval;
    private final int fnver;
    private final boolean fourk;
    private final boolean needTrial;
    private final int qn;
    private final long voiceBalance;

    public final int component1() {
        return this.qn;
    }

    public final int component2() {
        return this.fnver;
    }

    public final int component3() {
        return this.fnval;
    }

    public final boolean component4() {
        return this.fourk;
    }

    public final int component5() {
        return this.codecType;
    }

    public final long component6() {
        return this.voiceBalance;
    }

    public final boolean component7() {
        return this.needTrial;
    }

    public final int component8() {
        return this.audioType;
    }

    public final PlayerInfo copy(int i, int i2, int i3, boolean z, int i4, long j, boolean z2, int i5) {
        return new PlayerInfo(i, i2, i3, z, i4, j, z2, i5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PlayerInfo) {
            PlayerInfo playerInfo = (PlayerInfo) obj;
            return this.qn == playerInfo.qn && this.fnver == playerInfo.fnver && this.fnval == playerInfo.fnval && this.fourk == playerInfo.fourk && this.codecType == playerInfo.codecType && this.voiceBalance == playerInfo.voiceBalance && this.needTrial == playerInfo.needTrial && this.audioType == playerInfo.audioType;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.qn * 31) + this.fnver) * 31) + this.fnval) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.fourk)) * 31) + this.codecType) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.voiceBalance)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.needTrial)) * 31) + this.audioType;
    }

    public String toString() {
        int i = this.qn;
        int i2 = this.fnver;
        int i3 = this.fnval;
        boolean z = this.fourk;
        int i4 = this.codecType;
        long j = this.voiceBalance;
        boolean z2 = this.needTrial;
        return "PlayerInfo(qn=" + i + ", fnver=" + i2 + ", fnval=" + i3 + ", fourk=" + z + ", codecType=" + i4 + ", voiceBalance=" + j + ", needTrial=" + z2 + ", audioType=" + this.audioType + ")";
    }

    /* compiled from: ResolveModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/model/model/PlayerInfo$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/model/model/PlayerInfo;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayerInfo> serializer() {
            return PlayerInfo$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PlayerInfo(int seen0, int qn, int fnver, int fnval, boolean fourk, int codecType, long voiceBalance, boolean needTrial, int audioType, SerializationConstructorMarker serializationConstructorMarker) {
        if (191 != (seen0 & 191)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 191, PlayerInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.qn = qn;
        this.fnver = fnver;
        this.fnval = fnval;
        this.fourk = fourk;
        this.codecType = codecType;
        this.voiceBalance = voiceBalance;
        if ((seen0 & 64) == 0) {
            this.needTrial = OfflineConfigKt.getVipQualities().contains(Integer.valueOf(this.qn));
        } else {
            this.needTrial = needTrial;
        }
        this.audioType = audioType;
    }

    public PlayerInfo(int qn, int fnver, int fnval, boolean fourk, int codecType, long voiceBalance, boolean needTrial, int audioType) {
        this.qn = qn;
        this.fnver = fnver;
        this.fnval = fnval;
        this.fourk = fourk;
        this.codecType = codecType;
        this.voiceBalance = voiceBalance;
        this.needTrial = needTrial;
        this.audioType = audioType;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$model_debug(PlayerInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.qn);
        output.encodeIntElement(serialDesc, 1, self.fnver);
        output.encodeIntElement(serialDesc, 2, self.fnval);
        output.encodeBooleanElement(serialDesc, 3, self.fourk);
        output.encodeIntElement(serialDesc, 4, self.codecType);
        output.encodeLongElement(serialDesc, 5, self.voiceBalance);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.needTrial != OfflineConfigKt.getVipQualities().contains(Integer.valueOf(self.qn))) {
            output.encodeBooleanElement(serialDesc, 6, self.needTrial);
        }
        output.encodeIntElement(serialDesc, 7, self.audioType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlayerInfo(int i, int i2, int i3, boolean z, int i4, long j, boolean z2, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, z, i4, j, r9, i5);
        boolean z3;
        if ((i6 & 64) == 0) {
            z3 = z2;
        } else {
            z3 = OfflineConfigKt.getVipQualities().contains(Integer.valueOf(i));
        }
    }

    public final int getQn() {
        return this.qn;
    }

    public final int getFnver() {
        return this.fnver;
    }

    public final int getFnval() {
        return this.fnval;
    }

    public final boolean getFourk() {
        return this.fourk;
    }

    public final int getCodecType() {
        return this.codecType;
    }

    public final long getVoiceBalance() {
        return this.voiceBalance;
    }

    public final boolean getNeedTrial() {
        return this.needTrial;
    }

    public final int getAudioType() {
        return this.audioType;
    }
}