package video.biz.offline.list.logic.utils;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderVideoModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: OfflineAuthApi.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lvideo/biz/offline/list/logic/utils/EpisodeParam;", "", "episodeId", "", AuthorSpaceHeaderVideoModel.EXTRA_PARAM_QUALITY, "", "<init>", "(JI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getEpisodeId$annotations", "()V", "getEpisodeId", "()J", "getQuality$annotations", "getQuality", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$logic_debug", "$serializer", "Companion", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class EpisodeParam {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final long episodeId;
    private final int quality;

    public static /* synthetic */ EpisodeParam copy$default(EpisodeParam episodeParam, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = episodeParam.episodeId;
        }
        if ((i2 & 2) != 0) {
            i = episodeParam.quality;
        }
        return episodeParam.copy(j, i);
    }

    @SerialName("ep_id")
    public static /* synthetic */ void getEpisodeId$annotations() {
    }

    @SerialName(IjkMediaPlayer.OnNativeInvokeListener.ARG_QN)
    public static /* synthetic */ void getQuality$annotations() {
    }

    public final long component1() {
        return this.episodeId;
    }

    public final int component2() {
        return this.quality;
    }

    public final EpisodeParam copy(long j, int i) {
        return new EpisodeParam(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EpisodeParam) {
            EpisodeParam episodeParam = (EpisodeParam) obj;
            return this.episodeId == episodeParam.episodeId && this.quality == episodeParam.quality;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.episodeId) * 31) + this.quality;
    }

    public String toString() {
        long j = this.episodeId;
        return "EpisodeParam(episodeId=" + j + ", quality=" + this.quality + ")";
    }

    /* compiled from: OfflineAuthApi.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/list/logic/utils/EpisodeParam$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/list/logic/utils/EpisodeParam;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EpisodeParam> serializer() {
            return EpisodeParam$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ EpisodeParam(int seen0, long episodeId, int quality, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, EpisodeParam$$serializer.INSTANCE.getDescriptor());
        }
        this.episodeId = episodeId;
        this.quality = quality;
    }

    public EpisodeParam(long episodeId, int quality) {
        this.episodeId = episodeId;
        this.quality = quality;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$logic_debug(EpisodeParam self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.episodeId);
        output.encodeIntElement(serialDesc, 1, self.quality);
    }

    public final long getEpisodeId() {
        return this.episodeId;
    }

    public final int getQuality() {
        return this.quality;
    }
}