package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

public abstract class FlyCommentItem extends CommentItem {
    private static final long FLY_DURATION = 0;

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public final long getDuration() {
        return 0L;
    }
}