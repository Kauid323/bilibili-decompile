package video.biz.offline.base.infra.utils;

import com.bapis.bilibili.playershared.KDashItem;
import com.bapis.bilibili.playershared.KDashVideo;
import com.bapis.bilibili.playershared.KDolbyItem;
import com.bapis.bilibili.playershared.KResponseUrl;
import com.bapis.bilibili.playershared.KSegmentVideo;
import com.bapis.bilibili.playershared.KStream;
import com.bapis.bilibili.playershared.KStreamInfo;
import com.bapis.bilibili.playershared.KVodInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.common.resolver.model.DashMedia;
import video.common.resolver.model.DolbyInfo;
import video.common.resolver.model.Segment;
import video.common.resolver.model.SegmentVideo;
import video.common.resolver.model.Stream;
import video.common.resolver.model.StreamContent;
import video.common.resolver.model.StreamInfo;
import video.common.resolver.model.VodInfo;

/* compiled from: Extension.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0003\u001a\u00020\u0006*\u00020\u0007\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\b*\u00020\t\u001a\n\u0010\u0003\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0003\u001a\u00020\f*\u00020\r\u001a\n\u0010\u0003\u001a\u00020\u000e*\u00020\u000f\u001a\n\u0010\u0003\u001a\u00020\u0010*\u00020\u0011\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015¨\u0006\u0016"}, d2 = {"seasonType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "", "transform", "Lvideo/common/resolver/model/VodInfo;", "Lcom/bapis/bilibili/playershared/KVodInfo;", "Lvideo/common/resolver/model/StreamInfo;", "Lcom/bapis/bilibili/playershared/KStreamInfo;", "Lvideo/common/resolver/model/StreamContent;", "Lcom/bapis/bilibili/playershared/KStream$IContent;", "Lvideo/common/resolver/model/DashMedia;", "Lcom/bapis/bilibili/playershared/KDashVideo;", "Lvideo/common/resolver/model/SegmentVideo;", "Lcom/bapis/bilibili/playershared/KSegmentVideo;", "Lvideo/common/resolver/model/Segment;", "Lcom/bapis/bilibili/playershared/KResponseUrl;", "Lvideo/common/resolver/model/DolbyInfo;", "Lcom/bapis/bilibili/playershared/KDolbyItem;", "audioRes", "Lcom/bapis/bilibili/playershared/KDashItem;", "isDolby", "", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ExtensionKt {
    public static final OfflineVideoEntity.SeasonType seasonType(int $this$seasonType) {
        switch ($this$seasonType) {
            case 1:
                return OfflineVideoEntity.SeasonType.BANGUMI;
            case 2:
                return OfflineVideoEntity.SeasonType.MOVIE;
            case 3:
                return OfflineVideoEntity.SeasonType.DOCUMENTARY;
            case 4:
                return OfflineVideoEntity.SeasonType.CN_BANGUMI;
            case 5:
                return OfflineVideoEntity.SeasonType.TV_SERIES;
            case 6:
            default:
                return OfflineVideoEntity.SeasonType.UNKNOWN;
            case 7:
                return OfflineVideoEntity.SeasonType.VARIETY;
        }
    }

    public static final VodInfo transform(KVodInfo $this$transform) {
        Iterable $this$map$iv;
        StreamContent streamContent;
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        int quality = $this$transform.getQuality();
        String format = $this$transform.getFormat();
        long timelength = $this$transform.getTimelength();
        int videoCodecid = $this$transform.getVideoCodecid();
        Iterable $this$map$iv2 = $this$transform.getStreamList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv : $this$map$iv2) {
            KStream it = (KStream) item$iv$iv;
            KStreamInfo streamInfo = it.getStreamInfo();
            StreamInfo transform = streamInfo != null ? transform(streamInfo) : null;
            KStream.IContent content = it.getContent();
            if (content != null) {
                StreamContent transform2 = transform(content);
                $this$map$iv = $this$map$iv2;
                streamContent = transform2;
            } else {
                $this$map$iv = $this$map$iv2;
                streamContent = null;
            }
            destination$iv$iv.add(new Stream(transform, streamContent));
            $this$map$iv2 = $this$map$iv;
        }
        ArrayList arrayList = (List) destination$iv$iv;
        Iterable $this$map$iv3 = $this$transform.getDashAudio();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv2 : $this$map$iv3) {
            KDashItem item = (KDashItem) item$iv$iv2;
            destination$iv$iv2.add(new DashMedia(item.getId(), item.getBaseUrl(), item.getBackupUrl(), item.getBandwidth(), item.getCodecid(), item.getMd5(), item.getSize(), 0, false, (String) null, 0, 0, (String) null, (String) null, 16256, (DefaultConstructorMarker) null));
            $this$map$iv3 = $this$map$iv3;
        }
        ArrayList arrayList2 = (List) destination$iv$iv2;
        KDolbyItem dolby = $this$transform.getDolby();
        return new VodInfo(quality, format, timelength, videoCodecid, arrayList, arrayList2, dolby != null ? transform(dolby) : null);
    }

    public static final StreamInfo transform(KStreamInfo $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        return new StreamInfo($this$transform.getQuality(), $this$transform.getFormat(), $this$transform.getDescription(), $this$transform.getNeedVip(), $this$transform.getNewDescription(), $this$transform.getDisplayDesc(), $this$transform.getSuperscript(), $this$transform.getVipFree(), $this$transform.getSubtitle(), $this$transform.getSupportDrm());
    }

    public static final StreamContent transform(KStream.IContent $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        if ($this$transform instanceof KStream.KDashVideo) {
            return new StreamContent.Dash(transform(((KStream.KDashVideo) $this$transform).getValue()));
        }
        if ($this$transform instanceof KStream.KSegmentVideo) {
            return new StreamContent.Segment(transform(((KStream.KSegmentVideo) $this$transform).getValue()));
        }
        return null;
    }

    public static final DashMedia transform(KDashVideo $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        return new DashMedia(0, $this$transform.getBaseUrl(), $this$transform.getBackupUrl(), $this$transform.getBandwidth(), $this$transform.getCodecid(), $this$transform.getMd5(), $this$transform.getSize(), $this$transform.getAudioId(), $this$transform.getNoRexcode(), $this$transform.getFrameRate(), $this$transform.getWidth(), $this$transform.getHeight(), $this$transform.getWidevinePssh(), $this$transform.getBilidrmUri(), 1, (DefaultConstructorMarker) null);
    }

    public static final SegmentVideo transform(KSegmentVideo $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        Iterable $this$map$iv = $this$transform.getSegment();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KResponseUrl it = (KResponseUrl) item$iv$iv;
            destination$iv$iv.add(transform(it));
        }
        return new SegmentVideo((List) destination$iv$iv);
    }

    public static final Segment transform(KResponseUrl $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        return new Segment($this$transform.getOrder(), $this$transform.getLength(), $this$transform.getSize(), $this$transform.getUrl(), $this$transform.getBackupUrl(), $this$transform.getMd5());
    }

    public static final DolbyInfo transform(KDolbyItem $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        Iterable $this$map$iv = $this$transform.getAudio();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KDashItem item = (KDashItem) item$iv$iv;
            destination$iv$iv.add(new DashMedia(item.getId(), item.getBaseUrl(), item.getBackupUrl(), item.getBandwidth(), item.getCodecid(), item.getMd5(), item.getSize(), 0, false, (String) null, 0, 0, (String) null, (String) null, 16256, (DefaultConstructorMarker) null));
            $this$map$iv = $this$map$iv;
        }
        return new DolbyInfo((List) destination$iv$iv);
    }

    public static final KDashItem audioRes(KVodInfo $this$audioRes, boolean isDolby) {
        List audio;
        KDashItem kDashItem;
        Intrinsics.checkNotNullParameter($this$audioRes, "<this>");
        KDolbyItem dolby = $this$audioRes.getDolby();
        if (dolby != null && (audio = dolby.getAudio()) != null && (kDashItem = (KDashItem) CollectionsKt.firstOrNull(audio)) != null) {
            if (!isDolby) {
                kDashItem = null;
            }
            if (kDashItem != null) {
                return kDashItem;
            }
        }
        return (KDashItem) CollectionsKt.firstOrNull($this$audioRes.getDashAudio());
    }
}