package tv.danmaku.biliplayerv2.service.interact.biz.model.comment;

public class NullCommentItem extends CommentItem {
    private int mType;

    public NullCommentItem(int type) {
        this.mType = type;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public boolean isValid() {
        return false;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public int getCommentType() {
        return this.mType;
    }

    @Override // tv.danmaku.biliplayerv2.service.interact.biz.model.comment.CommentItem
    public long getDuration() {
        return 0L;
    }
}