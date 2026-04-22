package tv.danmaku.videoplayer.coreV2.transformer;

import com.bilibili.lib.media.resource.MediaResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.utils.P2PManuscriptInfo;
import tv.danmaku.videoplayer.coreV2.MediaItem;
import tv.danmaku.videoplayer.coreV2.VideoBizType;

/* compiled from: IMediaItemTransformer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ(\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J$\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/IMediaItemTransformer;", "", "createMediaItem", "Ltv/danmaku/videoplayer/coreV2/MediaItem;", "resource", "Lcom/bilibili/lib/media/resource/MediaResource;", "params", "Ltv/danmaku/videoplayer/coreV2/transformer/MediaItemParams;", "listener", "Ltv/danmaku/videoplayer/coreV2/MediaItem$IStatusListener;", "updateMediaItem", "", "mediaItem", "oldResource", "newResource", "Companion", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IMediaItemTransformer {
    public static final Companion Companion = Companion.$$INSTANCE;

    MediaItem<?> createMediaItem(MediaResource mediaResource, MediaItemParams mediaItemParams, MediaItem.IStatusListener iStatusListener);

    void updateMediaItem(MediaItem<?> mediaItem, MediaResource mediaResource, MediaResource mediaResource2);

    /* compiled from: IMediaItemTransformer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/transformer/IMediaItemTransformer$Companion;", "", "<init>", "()V", "transformP2PParams", "Ltv/danmaku/ijk/media/player/utils/P2PManuscriptInfo;", "params", "Ltv/danmaku/videoplayer/coreV2/transformer/P2PParams;", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* compiled from: IMediaItemTransformer.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[VideoBizType.values().length];
                try {
                    iArr[VideoBizType.PGC.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[VideoBizType.UGC.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private Companion() {
        }

        public final P2PManuscriptInfo transformP2PParams(P2PParams params) {
            P2PManuscriptInfo.ManuscriptType type;
            Intrinsics.checkNotNullParameter(params, "params");
            switch (WhenMappings.$EnumSwitchMapping$0[params.getType().ordinal()]) {
                case 1:
                    type = P2PManuscriptInfo.ManuscriptType.MANUSCRIPT_PGC;
                    break;
                case 2:
                    type = P2PManuscriptInfo.ManuscriptType.MANUSCRIPT_UGC;
                    break;
                default:
                    type = P2PManuscriptInfo.ManuscriptType.MANUSCRIPT_UNKNOWN;
                    break;
            }
            P2PManuscriptInfo build = new P2PManuscriptInfo.Builder().setAvid(params.getAvid()).setCid(params.getCid()).setEpisodeId(params.getEpid()).setSeasonId(params.getSeasonId()).setManuscriptType(type).setUpMid(params.getMid()).setUploadUtcTime(params.getCreateTime()).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            return build;
        }
    }
}