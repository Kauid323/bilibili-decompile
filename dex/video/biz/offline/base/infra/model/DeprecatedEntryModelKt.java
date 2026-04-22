package video.biz.offline.base.infra.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: DeprecatedEntryModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¨\u0006\u0007"}, d2 = {"toDeprecatedEntryModel", "Lvideo/biz/offline/base/infra/model/DeprecatedEntryModel;", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "convert", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$MediaType;", "toMediaType", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DeprecatedEntryModelKt {

    /* compiled from: DeprecatedEntryModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.MediaType.values().length];
            try {
                iArr[OfflineVideoEntity.MediaType.DASH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.MediaType.FLV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DeprecatedEntryModel toDeprecatedEntryModel(OfflineVideoEntity $this$toDeprecatedEntryModel) {
        String videoTitle;
        Intrinsics.checkNotNullParameter($this$toDeprecatedEntryModel, "<this>");
        DeprecatedPageModel deprecatedPageModel = new DeprecatedPageModel($this$toDeprecatedEntryModel.getCid(), $this$toDeprecatedEntryModel.getPageIndex(), $this$toDeprecatedEntryModel.getFrom(), $this$toDeprecatedEntryModel.getPageTitle(), $this$toDeprecatedEntryModel.getLinkStr(), "", false, 0, $this$toDeprecatedEntryModel.getWidth(), $this$toDeprecatedEntryModel.getHeight(), $this$toDeprecatedEntryModel.getRotate(), "", "");
        DeprecatedPageModel it = $this$toDeprecatedEntryModel.getBizType() == OfflineVideoEntity.BizType.UGC ? 1 : null;
        DeprecatedPageModel pageData = it != null ? deprecatedPageModel : null;
        DeprecatedEpisodeModel deprecatedEpisodeModel = new DeprecatedEpisodeModel($this$toDeprecatedEntryModel.getAid(), 0, $this$toDeprecatedEntryModel.getCid(), $this$toDeprecatedEntryModel.getCover(), $this$toDeprecatedEntryModel.getEpisodeId(), $this$toDeprecatedEntryModel.getVideoTitle(), $this$toDeprecatedEntryModel.getPageTitle(), $this$toDeprecatedEntryModel.getFrom(), $this$toDeprecatedEntryModel.getSeasonType().getSeasonType(), $this$toDeprecatedEntryModel.getWidth(), $this$toDeprecatedEntryModel.getHeight(), $this$toDeprecatedEntryModel.getRotate(), $this$toDeprecatedEntryModel.getLinkStr(), $this$toDeprecatedEntryModel.getBvid(), $this$toDeprecatedEntryModel.getPageIndex());
        DeprecatedEpisodeModel it2 = $this$toDeprecatedEntryModel.getBizType() == OfflineVideoEntity.BizType.OGV ? 1 : null;
        DeprecatedEpisodeModel ep = it2 != null ? deprecatedEpisodeModel : null;
        int convert = convert($this$toDeprecatedEntryModel.getMediaType());
        boolean z = $this$toDeprecatedEntryModel.getMediaType() == OfflineVideoEntity.MediaType.DASH;
        boolean areEqual = Intrinsics.areEqual($this$toDeprecatedEntryModel.getState(), OfflineVideoEntity.State.COMPLETED.INSTANCE);
        long totalSize = $this$toDeprecatedEntryModel.getTotalSize();
        long downloadedSize = $this$toDeprecatedEntryModel.getDownloadedSize();
        if ($this$toDeprecatedEntryModel.getBizType() == OfflineVideoEntity.BizType.OGV) {
            videoTitle = $this$toDeprecatedEntryModel.getGroupTitle();
        } else {
            videoTitle = $this$toDeprecatedEntryModel.getVideoTitle();
        }
        return new DeprecatedEntryModel(convert, z, areEqual, totalSize, downloadedSize, videoTitle, $this$toDeprecatedEntryModel.getQnPath(), $this$toDeprecatedEntryModel.getCover(), $this$toDeprecatedEntryModel.getRealVideoQuality(), $this$toDeprecatedEntryModel.getPreferredVideoQuality(), 0L, Duration.getInWholeMilliseconds-impl($this$toDeprecatedEntryModel.m2773getDurationUwyO8pc()), $this$toDeprecatedEntryModel.getDanmakuCount(), $this$toDeprecatedEntryModel.getUpdateTime(), $this$toDeprecatedEntryModel.getCreateTime(), $this$toDeprecatedEntryModel.getDownloadedSize() * ((long) 5) > $this$toDeprecatedEntryModel.getTotalSize(), false, $this$toDeprecatedEntryModel.getQualityDisplay(), "", false, $this$toDeprecatedEntryModel.getAppVersion(), $this$toDeprecatedEntryModel.getVideoInfo().getAudioType(), $this$toDeprecatedEntryModel.getVideoInfo().getAudioType(), $this$toDeprecatedEntryModel.getAid(), 0, $this$toDeprecatedEntryModel.getSeasonId(), $this$toDeprecatedEntryModel.getBvid(), $this$toDeprecatedEntryModel.getAuthorMid(), $this$toDeprecatedEntryModel.getAuthor(), $this$toDeprecatedEntryModel.hitAttr(OfflineVideoEntity.VideoAttr.ChargingPay), $this$toDeprecatedEntryModel.getAuthCode(), pageData, ep, null, 0, 2, null);
    }

    public static final int convert(OfflineVideoEntity.MediaType $this$convert) {
        Intrinsics.checkNotNullParameter($this$convert, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[$this$convert.ordinal()]) {
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final OfflineVideoEntity.MediaType toMediaType(int $this$toMediaType) {
        if ($this$toMediaType == 1) {
            return OfflineVideoEntity.MediaType.FLV;
        }
        return OfflineVideoEntity.MediaType.DASH;
    }
}