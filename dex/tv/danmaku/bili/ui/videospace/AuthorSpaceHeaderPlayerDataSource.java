package tv.danmaku.bili.ui.videospace;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.PlayerDataSource;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AuthorSpaceHeaderPlayerDataSource.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayerDataSource;", "Ltv/danmaku/biliplayerv2/service/PlayerDataSource;", "authorSpaceHeaderPlayableParams", "Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;", "<init>", "(Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;)V", "getAuthorSpaceHeaderPlayableParams", "()Ltv/danmaku/bili/ui/videospace/AuthorSpaceHeaderPlayableParams;", "setAuthorSpaceHeaderPlayableParams", "video", "Ltv/danmaku/biliplayerv2/service/Video;", "getVideo", "()Ltv/danmaku/biliplayerv2/service/Video;", "setVideo", "(Ltv/danmaku/biliplayerv2/service/Video;)V", "getVideoCount", "", "position", "getVideoItemCount", "getVideoItem", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AuthorSpaceHeaderPlayerDataSource extends PlayerDataSource {
    public static final int $stable = 8;
    private AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams;

    /* renamed from: video  reason: collision with root package name */
    private Video f25video;

    public AuthorSpaceHeaderPlayerDataSource(AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams) {
        Intrinsics.checkNotNullParameter(authorSpaceHeaderPlayableParams, "authorSpaceHeaderPlayableParams");
        this.authorSpaceHeaderPlayableParams = authorSpaceHeaderPlayableParams;
        this.f25video = new Video();
        this.f25video.setId(String.valueOf(this.authorSpaceHeaderPlayableParams.getAvid()));
        this.f25video.setType(2);
    }

    public final AuthorSpaceHeaderPlayableParams getAuthorSpaceHeaderPlayableParams() {
        return this.authorSpaceHeaderPlayableParams;
    }

    public final void setAuthorSpaceHeaderPlayableParams(AuthorSpaceHeaderPlayableParams authorSpaceHeaderPlayableParams) {
        Intrinsics.checkNotNullParameter(authorSpaceHeaderPlayableParams, "<set-?>");
        this.authorSpaceHeaderPlayableParams = authorSpaceHeaderPlayableParams;
    }

    public final Video getVideo() {
        return this.f25video;
    }

    public final void setVideo(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "<set-?>");
        this.f25video = video2;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public int getVideoCount() {
        return 1;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public Video getVideo(int position) {
        return this.f25video;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public int getVideoItemCount(Video video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        return 1;
    }

    @Override // tv.danmaku.biliplayerv2.service.PlayerDataSource
    public Video.PlayableParams getVideoItem(Video video2, int position) {
        Intrinsics.checkNotNullParameter(video2, "video");
        return this.authorSpaceHeaderPlayableParams;
    }
}