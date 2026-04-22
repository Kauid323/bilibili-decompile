package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

public abstract class StaticCommentItem extends CommentItem {
    private static final int DEFAULT_STATIC_DURATION_MILLIS = 4000;

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public final long getDuration() {
        return PlayerToastConfig.DURATION_4;
    }
}