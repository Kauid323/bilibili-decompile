package video.biz.offline.base.model.model;

import kntr.base.appinfo.KAppInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.DateKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: ResolveModel.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lvideo/biz/offline/base/model/model/ResolveParam;", "", "videoInfo", "Lvideo/biz/offline/base/model/model/VideoInfo;", "playerInfo", "Lvideo/biz/offline/base/model/model/PlayerInfo;", "<init>", "(Lvideo/biz/offline/base/model/model/VideoInfo;Lvideo/biz/offline/base/model/model/PlayerInfo;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILvideo/biz/offline/base/model/model/VideoInfo;Lvideo/biz/offline/base/model/model/PlayerInfo;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getVideoInfo", "()Lvideo/biz/offline/base/model/model/VideoInfo;", "getPlayerInfo", "()Lvideo/biz/offline/base/model/model/PlayerInfo;", "resolveVideoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$model_debug", "$serializer", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Serializable
public final class ResolveParam {
    private final PlayerInfo playerInfo;
    private final VideoInfo videoInfo;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ResolveParam copy$default(ResolveParam resolveParam, VideoInfo videoInfo, PlayerInfo playerInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            videoInfo = resolveParam.videoInfo;
        }
        if ((i & 2) != 0) {
            playerInfo = resolveParam.playerInfo;
        }
        return resolveParam.copy(videoInfo, playerInfo);
    }

    public final VideoInfo component1() {
        return this.videoInfo;
    }

    public final PlayerInfo component2() {
        return this.playerInfo;
    }

    public final ResolveParam copy(VideoInfo videoInfo, PlayerInfo playerInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        return new ResolveParam(videoInfo, playerInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolveParam) {
            ResolveParam resolveParam = (ResolveParam) obj;
            return Intrinsics.areEqual(this.videoInfo, resolveParam.videoInfo) && Intrinsics.areEqual(this.playerInfo, resolveParam.playerInfo);
        }
        return false;
    }

    public int hashCode() {
        return (this.videoInfo.hashCode() * 31) + this.playerInfo.hashCode();
    }

    public String toString() {
        VideoInfo videoInfo = this.videoInfo;
        return "ResolveParam(videoInfo=" + videoInfo + ", playerInfo=" + this.playerInfo + ")";
    }

    /* compiled from: ResolveModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lvideo/biz/offline/base/model/model/ResolveParam$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lvideo/biz/offline/base/model/model/ResolveParam;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ResolveParam> serializer() {
            return ResolveParam$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ResolveParam(int seen0, VideoInfo videoInfo, PlayerInfo playerInfo, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, ResolveParam$$serializer.INSTANCE.getDescriptor());
        }
        this.videoInfo = videoInfo;
        this.playerInfo = playerInfo;
    }

    public ResolveParam(VideoInfo videoInfo, PlayerInfo playerInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(playerInfo, "playerInfo");
        this.videoInfo = videoInfo;
        this.playerInfo = playerInfo;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$model_debug(ResolveParam self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, VideoInfo$$serializer.INSTANCE, self.videoInfo);
        output.encodeSerializableElement(serialDesc, 1, PlayerInfo$$serializer.INSTANCE, self.playerInfo);
    }

    public final VideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public final PlayerInfo getPlayerInfo() {
        return this.playerInfo;
    }

    public final OfflineVideoEntity resolveVideoEntity() {
        OfflineVideoEntity entity;
        if (this.videoInfo.getBiz() == OfflineVideoEntity.BizType.UGC) {
            entity = OfflineVideoEntity.Companion.avEmptyModel(this.videoInfo.getAid(), this.videoInfo.getCid());
        } else {
            entity = OfflineVideoEntity.Companion.epEmptyModel(this.videoInfo.getAid(), this.videoInfo.getCid(), this.videoInfo.getSeasonId(), this.videoInfo.getEpisodeId());
        }
        entity.setVideoAttr(this.videoInfo.getVideoAttr());
        entity.setGroupId(this.videoInfo.getGroupId());
        entity.setGroupTitle(this.videoInfo.getGroupTitle());
        entity.setVideoTitle(this.videoInfo.getVideoTitle());
        entity.setPageTitle(this.videoInfo.getPageTitle());
        entity.setCover(this.videoInfo.getCover());
        entity.setAuthor(this.videoInfo.getAuthor());
        entity.setAuthorMid(this.videoInfo.getAuthorMid());
        entity.setBvid(this.videoInfo.getBvId());
        entity.setState(OfflineVideoEntity.State.PENDING.INSTANCE);
        entity.setCreateTime(DateKt.getCurrentTimeMillis());
        entity.setUpdateTime(DateKt.getCurrentTimeMillis());
        entity.setVideoIndex(this.videoInfo.getVideoIndex());
        entity.setPageIndex(this.videoInfo.getPageIndex());
        entity.setSeasonType(this.videoInfo.getSeasonType());
        entity.setFrom(this.videoInfo.getFromScene());
        entity.setAppVersion(KAppInfo.INSTANCE.getVersionCode());
        entity.setExtended(this.videoInfo.getExtended());
        entity.setEpSortedIds(this.videoInfo.getEpSortedIds());
        entity.setEpStatus(this.videoInfo.getEpStatus());
        entity.getVideoInfo().setQn(this.playerInfo.getQn());
        entity.getVideoInfo().setFnver(this.playerInfo.getFnver());
        entity.getVideoInfo().setFnval(this.playerInfo.getFnval());
        entity.getVideoInfo().setFourk(this.playerInfo.getFourk());
        entity.getVideoInfo().setCodecType(this.playerInfo.getCodecType());
        entity.getVideoInfo().setVoiceBalance(this.playerInfo.getVoiceBalance());
        entity.getVideoInfo().setNeedTrial(this.playerInfo.getNeedTrial());
        entity.getVideoInfo().setAudioType(this.playerInfo.getAudioType());
        return entity;
    }
}