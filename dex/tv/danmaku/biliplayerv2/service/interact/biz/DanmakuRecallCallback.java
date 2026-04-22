package tv.danmaku.biliplayerv2.service.interact.biz;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/DanmakuRecallCallback;", "", "isShowToastWhenResult", "", "onRecallSuccess", "", "item", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/comment/CommentItem;", "onRecallError", "errMessage", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface DanmakuRecallCallback {
    boolean isShowToastWhenResult();

    void onRecallError(String str);

    void onRecallSuccess(CommentItem commentItem);
}