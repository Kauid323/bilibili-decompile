package tv.danmaku.bili.ui.garb.digital;

import com.bili.digital.common.player.VideoParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.digital.base.adapter.DigitalCardDetailAdapter;
import tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView;

/* compiled from: DigitalCardDetailRecycleView.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/garb/digital/DigitalCardDetailRecycleView;", "Ltv/danmaku/bili/ui/garb/digital/base/view/DigitalCardDetailBaseRecycleView;", "videoParams", "Lcom/bili/digital/common/player/VideoParams;", "isHalfScreen", "", "<init>", "(Lcom/bili/digital/common/player/VideoParams;Z)V", "getAdapter", "Ltv/danmaku/bili/ui/garb/digital/base/adapter/DigitalCardDetailAdapter;", "canScrollHorizontally", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DigitalCardDetailRecycleView extends DigitalCardDetailBaseRecycleView {
    public static final int $stable = 8;
    private final boolean isHalfScreen;
    private final VideoParams videoParams;

    public DigitalCardDetailRecycleView(VideoParams videoParams, boolean isHalfScreen) {
        Intrinsics.checkNotNullParameter(videoParams, "videoParams");
        this.videoParams = videoParams;
        this.isHalfScreen = isHalfScreen;
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView
    public DigitalCardDetailAdapter getAdapter() {
        return new DigitalCardDetailAdapter(getMActivityId(), this.videoParams, this.isHalfScreen);
    }

    @Override // tv.danmaku.bili.ui.garb.digital.base.view.DigitalCardDetailBaseRecycleView
    public boolean canScrollHorizontally() {
        return true;
    }
}