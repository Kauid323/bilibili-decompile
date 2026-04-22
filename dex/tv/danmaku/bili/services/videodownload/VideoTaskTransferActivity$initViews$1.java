package tv.danmaku.bili.services.videodownload;

import android.os.Handler;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.utils.TransferListener;

/* compiled from: VideoTaskTransferActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"tv/danmaku/bili/services/videodownload/VideoTaskTransferActivity$initViews$1", "Ltv/danmaku/bili/services/videodownload/utils/TransferListener;", "onProgress", "", "allCount", "", "transfered", "onSuccess", "onFail", "t", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class VideoTaskTransferActivity$initViews$1 implements TransferListener {
    final /* synthetic */ VideoTaskTransferActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoTaskTransferActivity$initViews$1(VideoTaskTransferActivity $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.services.videodownload.utils.TransferListener
    public void onProgress(int allCount, int transfered) {
        if (transfered > 0) {
            this.this$0.updateProgress((transfered * 100) / allCount);
        }
    }

    @Override // tv.danmaku.bili.services.videodownload.utils.TransferListener
    public void onSuccess() {
        Handler mHandler;
        this.this$0.isSuccess = true;
        this.this$0.setResult(-1);
        this.this$0.showSuccess();
        this.this$0.updatePvExtra();
        VideoTaskTransferActivity videoTaskTransferActivity = this.this$0;
        final VideoTaskTransferActivity videoTaskTransferActivity2 = this.this$0;
        Runnable $this$onSuccess_u24lambda_u241 = new Runnable() { // from class: tv.danmaku.bili.services.videodownload.VideoTaskTransferActivity$initViews$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoTaskTransferActivity.this.finish();
            }
        };
        mHandler = this.this$0.getMHandler();
        mHandler.postDelayed($this$onSuccess_u24lambda_u241, 3000L);
        videoTaskTransferActivity.mAutoCloseAction = $this$onSuccess_u24lambda_u241;
    }

    @Override // tv.danmaku.bili.services.videodownload.utils.TransferListener
    public void onFail(Throwable t) {
        this.this$0.showFail();
    }
}